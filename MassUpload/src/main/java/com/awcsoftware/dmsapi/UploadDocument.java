package com.awcsoftware.dmsapi;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.awcsoftware.dto.UploadResponse;
import com.awcsoftware.services.PropertiesReader;
import com.newgen.dmsapi.DMSXmlResponse;

import ISPack.CPISDocumentTxn;
import ISPack.ISUtil.JPDBRecoverDocData;
import ISPack.ISUtil.JPISException;
import ISPack.ISUtil.JPISIsIndex;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UploadDocument {
	final static Logger logger = Logger.getLogger(UploadDocument.class);
	@Autowired
	private JPDBRecoverDocData docDBData;
	@Autowired
	private JPISIsIndex newIsIndex;
	@Autowired
	private DMSXmlResponse resp;
	@Autowired
	private CabinetAPI api;
	@Autowired
	private ApplicationContext ctx;

	public static String getDocType(String ext) {
		String docType = "";
		if (ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("JPEG") || ext.equalsIgnoreCase("png")
				|| ext.equalsIgnoreCase("tiff") || ext.equalsIgnoreCase("bmp") || ext.equalsIgnoreCase("png")) {
			logger.info("Doctype is Image");
			docType = "I";
		} else if (ext.equalsIgnoreCase("mp4") || ext.equalsIgnoreCase("vob") || ext.equalsIgnoreCase("mkv")
				|| ext.equalsIgnoreCase("webm") || ext.equalsIgnoreCase("avi")) {
			logger.info("Doctype is Video");
			docType = "V";
		} else if (ext.equalsIgnoreCase("pdf")) {
			docType = "I";
		} else {
			logger.info("Doctype is Others");
			docType = "N";
		}
		return docType;
	}

	public UploadResponse upload(String sessionId,File fileX) {
		UploadResponse ur = ctx.getBean(UploadResponse.class);
		String docType = null;
		int docIndex = 0;
		String isIndex = null;
		logger.info("File X"+fileX);
		int folderIndex = 0;
		folderIndex = 1540;
		
		StringBuffer errorMsg=(StringBuffer)ctx.getBean("errorMsg");
		
		if (folderIndex == -1 || folderIndex == 0) {
			ur.setDocId(0);
			ur.setImageIndex(0);
			errorMsg.append(PropertiesReader.getProp().getProperty("rootFolderIssue"));
			ur.setStatus(errorMsg);
			return ur;
		} else {
			try {
				logger.info("Tracking Folder Index :" + folderIndex);

				docType = getDocType(FilenameUtils.getExtension(fileX.getName()));
				int pageNum = 1;
				logger.info("Before pdf check, file extension is: "+FilenameUtils.getExtension(fileX.getName()));
				if (FilenameUtils.getExtension(fileX.getName()).equals("pdf")) {
					logger.info("PDF check true");
					PDDocument doc = PDDocument.load(fileX);
					logger.info("PDF Loaded");
					pageNum = doc.getNumberOfPages();
					logger.info("PDF number of pages:"+pageNum);
					doc.close();
				}
				
				logger.info("Number of pages before OD call:"+pageNum);
				
				String xmlData = "<?xml version=\"1.0\"?><NGOAddDocument_Input><Option>NGOAddDocument</Option><CabinetName>"
						+ PropertiesReader.getProp().getProperty("cabinetName") + "</CabinetName><UserDBId>" + sessionId
						+ "</UserDBId><GroupIndex></GroupIndex><Document><ParentFolderIndex>" + folderIndex
						+ "</ParentFolderIndex><NoOfPages>" + pageNum
						+ "</NoOfPages><AccessType>S</AccessType><DocumentName>" + FilenameUtils.getBaseName(fileX.getName())
						+ "</DocumentName><CreationDateTime></CreationDateTime><ExpiryDateTime></ExpiryDateTime><VersionFlag>N</VersionFlag><DocumentType>"
						+ docType + "</DocumentType><DocumentSize>" + fileX.length()
						+ "</DocumentSize><CreatedByApp></CreatedByApp><CreatedByAppName>" + FilenameUtils.getExtension(fileX.getName())
						+ "</CreatedByAppName><ISIndex></ISIndex><FTSDocumentIndex>0</FTSDocumentIndex><ODMADocumentIndex></ODMADocumentIndex><Comment></Comment><Author></Author><OwnerIndex>1</OwnerIndex><EnableLog>Y</EnableLog><FTSFlag>PP</FTSFlag>"
						+ "<NameLength>255</NameLength></Document></NGOAddDocument_Input>";

				
				CPISDocumentTxn.AddDocument_MT(null, PropertiesReader.getProp().getProperty("serverIp"),
						Short.parseShort(PropertiesReader.getProp().getProperty("jtsPort")),
						PropertiesReader.getProp().getProperty("cabinetName"), Short.parseShort("1"),
						"D:\\documents\\Orient Electric\\"+fileX.getName(), docDBData, "1",
						newIsIndex);
				docIndex = newIsIndex.m_nDocIndex;
				isIndex = newIsIndex.m_nDocIndex + "#" + newIsIndex.m_sVolumeId;
				logger.info("DocIndex :" + docIndex + " /isIndex :" + isIndex);
				String frontData = xmlData.substring(0, xmlData.indexOf("<ISIndex>") + 9);
				String endData = xmlData.substring(xmlData.indexOf("</ISIndex>"), xmlData.length());
				xmlData = frontData + isIndex + endData;

				logger.info("INPUT XML : \n"+xmlData);
				
				resp = api.callBroker(xmlData);
				logger.info("OUTPUT XML : \n"+resp);
				
				if (resp.getVal("Status").equalsIgnoreCase("0")) {
					logger.info("Completed Document Upload Call");
					String indexParse = resp.getVal("ISIndex");
					indexParse = indexParse.substring(0, indexParse.indexOf("#"));
					ur.setDocId(Integer.parseInt(resp.getVal("DocumentIndex")));
					//ur.setStatus(resp.getVal("Status"));
					errorMsg.append(resp.getVal("Status"));
					ur.setStatus(errorMsg);
					ur.setName(resp.getVal("DocumentName"));
					ur.setExt(resp.getVal("CreatedByAppName"));
					ur.setSize(resp.getVal("DocumentSize"));
					
					ur.setImageIndex(Integer.parseInt(indexParse));
				} else {
					logger.info("Incomplete Document Upload Call");
					ur.setDocId(0);
					ur.setImageIndex(0);
					//ur.setStatus(resp.getVal("Error"));
					errorMsg.append(resp.getVal("Error"));
					ur.setStatus(errorMsg);

				}
				logger.info("File Delete Operation : " + fileX.delete());

			} catch (IOException | JPISException e) {
				logger.error(e);
				e.printStackTrace();
			}
			return ur;
		}

	}

}