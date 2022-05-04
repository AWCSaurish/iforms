package ebig.oracle.cloud.integration.dao;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ebig.oracle.cloud.integration.ReportService.ReportRequest;
import ebig.oracle.cloud.integration.ReportService.RunReport;
import ebig.oracle.cloud.integration.ReportService.RunReportResponse;
import ebig.oracle.cloud.integration.connector.ReportServiceConnector;
import ebig.oracle.cloud.integration.entity.DataDS;

@Service
public class EbigOracleCloudIntegrationImplementation implements IEbigOracleCloudIntegrationService{

	
	@Value("${USERNAMEWSDL}")
    private String userNameWSDL;
	
	
	@Value("${PASSWORDWSDL}")
    private String passwordWSDL;
	
	@Value("${ReportAbsolutePath}")
	private String reportAbsolutePath;
	
	@Autowired
	private ReportServiceConnector reportServiceConnector;
	
	private static final Logger logger = LoggerFactory.getLogger(EbigOracleCloudIntegrationImplementation.class);
	
	@Override
	public DataDS getReportServiceData() {
		// TODO Auto-generated method stub
		
		logger.info("UserID ==>> "+  userNameWSDL  + " \n Password ==>> "+ passwordWSDL + " \n Path ==>>" + reportAbsolutePath);
		
		RunReport runReport = new RunReport();
		runReport.setPassword(passwordWSDL.trim());
		runReport.setUserID(userNameWSDL.trim());
		
		ReportRequest reportRequest = new ReportRequest();
		reportRequest.setReportAbsolutePath(reportAbsolutePath.trim());
		runReport.setReportRequest(reportRequest);
		
		RunReportResponse runReportResponse = (RunReportResponse) reportServiceConnector.callWebService("https://ebig.fa.us2.oraclecloud.com/xmlpserver/services/v2/ReportService", runReport);
		
		byte[] reportBytes = runReportResponse.getRunReportReturn().getReportBytes();
		//logger.info("byte array ==>>"+reportBytes);
		String byteArraytoString = new String(reportBytes);
		//logger.info("Response ::========>>> "+ byteArraytoString);
		
		DataDS dataDS = new DataDS();
		ObjectMapper objectMapper = new XmlMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
		try {
			 dataDS = objectMapper.readValue(byteArraytoString, DataDS.class);
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataDS;
	}

}
