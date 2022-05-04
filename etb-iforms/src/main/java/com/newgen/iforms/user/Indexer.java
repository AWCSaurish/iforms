package com.newgen.iforms.user;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.awcsoftware.dao.IGmmcoMdmDao;
import com.awcsoftware.dto.mdm.MdmEmployeeMaster;
import com.awcsoftware.dto.vendor.Vendor;
import com.google.gson.Gson;
import com.newgen.dto.POBean;
import com.newgen.dto.POHistoryBean;
import com.newgen.dto.PoDetailsBean;
import com.newgen.dto.Table3;
import com.newgen.dto.Table4;
import com.newgen.dto.Table6;
import com.newgen.iforms.EControl;
import com.newgen.iforms.FormDef;
import com.newgen.iforms.custom.IFormReference;
import com.newgen.iforms.custom.IFormServerEventHandler;
import com.newgen.methods.PORelated;
import com.newgen.mvcbeans.model.WorkdeskModel;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Indexer implements IFormServerEventHandler {
	@Autowired
	private IGmmcoMdmDao dao;

	@Autowired
	private PORelated related;

	@Autowired
	private ApplicationContext ctx;
	
	final static Logger logger = Logger.getLogger(Indexer.class);

	public Indexer() {
		logger.info("From Indexer Cons.");
	}

	@Override
	public void beforeFormLoad(FormDef fd, IFormReference ifr) {
		ifr.clearCombo("user_action");
		ifr.addItemInCombo("user_action", "Send For Posting", "Send For Posting");
		ifr.addItemInCombo("user_action", "Raise Exception", "Raise Exception");
		ifr.addItemInCombo("user_action", "Reject", "Reject");
		logger.info("From Form Loaded Spring :: ");
		List<String> currList = dao.getCurrency();
		for (String str : currList) {
			//logger.info("Currency :: "+str);
			ifr.addItemInCombo("currency", str, str);
		}
		List<MdmEmployeeMaster> list = dao.getListOfEmployees();
		for (MdmEmployeeMaster master : list) {
			ifr.addItemInCombo("employeecode", master.getEmployee_code(), master.getEmployee_code());
			//logger.info("Master :: "+master);
		}
		//System.out.println("Form load GMMCO GSTIN :: "+(String)ifr.getValue("gstingmmco"));
		//System.out.println("Form load Vendor GSTIN :: "+(String)ifr.getValue("gstinvendor"));
		//System.out.println("*******************************");
		//System.out.println("Tester ::"+((String)ifr.getValue("gstinvendor")).equals(""));
		//System.out.println("*******************************");
		calculateGstCategory((String)ifr.getValue("gstingmmco"), (String)ifr.getValue("gstinvendor"), ifr);
	}

	@Override
	public String setMaskedValue(String string, String string1) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public JSONArray executeEvent(FormDef fd, IFormReference ifr, String string, String string1) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public String executeServerEvent(IFormReference ifr, String string, String string1, String string2) {
		switch (string1) {

		case "onClick":
			switch (string) {

			case "Btn_Simulate":
				logger.info("invoicenumber :: " + (String) ifr.getValue("invoicenumber"));
				logger.info("invoicetotalamount :: " + (String) ifr.getValue("invoicetotalamount"));
				logger.info("vendorcode :: " + (String) ifr.getValue("vendorcode"));
				logger.info("processid :: " + ifr.getObjGeneralData().getM_strProcessInstanceId());

				Integer inv = dao.getInvoice((String) ifr.getValue("invoicenumber"),
						(String) ifr.getValue("invoicetotalamount"), (String) ifr.getValue("vendorcode"),
						ifr.getObjGeneralData().getM_strProcessInstanceId());
				logger.info("Invoice :: " + inv);
				if(inv>0)
					ifr.setValue("textbox32", "" + "DuplicateInvoice");
				Vendor vendor = dao.getVendor((String) ifr.getValue("gstinvendor")).get(0);
				validateLineLevelData(ifr);
				if (ifr.getValue("vendorcode").toString().equalsIgnoreCase(vendor.getVendor_code())) {
					logger.info("Vendor Match");
				} else {
					logger.info("Vendor Mismatch");
					// ifr.setValue("textbox35", "Vendor Mismatch");
				}
				break;
			case "fetchgrn":
				Double taxableAmountHeader=0.0;
				String NetPovalueX = "";
				//Double Qtydbl = 0.0d;
				Double NetPovaluedoubleX = 0.0d;
				DecimalFormat df = new DecimalFormat("0.00");
				ifr.clearTable("table4");
				ArrayList<POHistoryBean> history = related.getPOHistory("MatDocNo eq '" + ifr.getValue("grno") + "'");
				JSONArray jsonArrX = new JSONArray();
				for (POHistoryBean historyX : history) {
					JSONObject jsonObj = new JSONObject();
					
					jsonObj.put("PO Number", historyX.getPoNumber());
					jsonObj.put("Material Code", historyX.getMaterial());
					jsonObj.put("UOM", historyX.getUom());
					jsonObj.put("Mat Doc Item", historyX.getMatDocItem());
					jsonObj.put("Fiscal Year", historyX.getFiscalYear());
					jsonObj.put("Profit Centre", historyX.getProfitCenter());
					jsonObj.put("Net Value", historyX.getAmountDoccurr());
					//jsonObj.put("Net Price", historyX.getAmountLoccurr());
					NetPovaluedoubleX = Double.parseDouble(historyX.getAmountDoccurr());
					NetPovalueX = df.format(NetPovaluedoubleX);
					System.out.println("NetPovalue : " + NetPovalueX);
					jsonObj.put("GRN Refence Document Number", historyX.getRefDocNo());
					jsonObj.put("Delivery Note - GRN Number", historyX.getMatDocNo());
					jsonObj.put("GRN Date", datefromAPI(historyX.getPostDate()));
					jsonObj.put("Line Item number", historyX.getPoItem());
					jsonObj.put("GRN- Quantity", historyX.getQuantity());
					jsonObj.put("Serial Number", historyX.getSerialNo());
					jsonObj.put("Plant", historyX.getPlant());
					jsonObj.put("Inbound Delivery", historyX.getDeliveryNumber());
					jsonObj.put("GRN Number", historyX.getMatDocNo());
					jsonObj.put("IR Quantity", "Test Value Remove it after real values");
					logger.info("IR Quantity :: "+historyX.getIrQuantity());
					ArrayList<POBean> poBean = related.getPODetails("PoNumber eq '" + ifr.getValue("ponumber") + "'");
					ArrayList<PoDetailsBean> details = related
							.getPOLines("PoNumber eq '" + ifr.getValue("ponumber") + "'");
					for (PoDetailsBean detailsX : details) {
						jsonObj.put("HSN SAC", detailsX.getControlCode());
					}
					jsonArrX.add(jsonObj);
					taxableAmountHeader+=Double.parseDouble(NetPovalueX);
				}
				ifr.setValue("taxableAmount", ""+taxableAmountHeader);
				ifr.setValue("tdsBaseAmount", ""+taxableAmountHeader);
				ifr.addDataToGrid("table4", jsonArrX);
				break;
			case "fetchPOData":
				//
				String plant = null;
				ifr.clearTable("table3");
				DecimalFormat dfX = new DecimalFormat("0.00");
				ArrayList<POBean> poBean = related.getPODetails("PoNumber eq '" + ifr.getValue("ponumber") + "'");
				ArrayList<PoDetailsBean> details = related.getPOLines("PoNumber eq '" + ifr.getValue("ponumber") + "'");
				//String QtyFormated = ""; 
				String NetPovalue2 = "";
				//Double Qtydbl = 0.0d;
				Double NetPovaluedouble2 = 0.0d;
				logger.info("VendorCode From PO ::" + poBean.get(0).getVendor());
				logger.info("Currency From PO :: " + poBean.get(0).getCurrency());
				ifr.setValue("poVendorCode", poBean.get(0).getVendor());
				ifr.setValue("currency", poBean.get(0).getCurrency());
				JSONArray jsonArr = new JSONArray();
				for (PoDetailsBean detailsX : details) {
					JSONObject jsonObj = new JSONObject();
					NetPovaluedouble2 = Double.parseDouble(detailsX.getNetValue());
					NetPovalue2 = dfX.format(NetPovaluedouble2);
					System.out.println("NetPovalue : " + NetPovalue2);
					
					jsonObj.put("CGST Rate", detailsX.getCgstPer());
					jsonObj.put("CGST Amount", detailsX.getCgstVal());
					jsonObj.put("SGST Rate", detailsX.getSgstPer());
					jsonObj.put("SGST Amount", detailsX.getSgstVal());
					jsonObj.put("IGST Rate", detailsX.getIgstPer());
					jsonObj.put("IGST Amount", detailsX.getIgstVal());
					jsonObj.put("Material", detailsX.getMaterial());
					
					jsonObj.put("PO No", detailsX.getPoNumber());
					jsonObj.put("PO Line Item", detailsX.getPoItem());
					jsonObj.put("Tax Code", detailsX.getTaxCode());
					jsonObj.put("Line Item Text", "");
					jsonObj.put("Taxable Amount Line Item Amount", NetPovalue2);
					jsonObj.put("Qty", detailsX.getQuantity());
					jsonObj.put("UOM", detailsX.getUom());
					jsonObj.put("Other Charges", "");
					jsonObj.put("WBS", detailsX.getWbs());
					jsonObj.put("GL Account", detailsX.getCostElement());
					jsonObj.put("Profit Centre", detailsX.getProfitCenter());
					jsonObj.put("Amount", detailsX.getNetValue());
					jsonObj.put("Plant", detailsX.getPlant());
					plant = detailsX.getPlant();
					jsonArr.add(jsonObj);
					
					//For Taxable Amount Header
					//taxableAmountHeader+=Double.parseDouble(NetPovalue2);
				}
				ifr.setValue("plant", plant);
				//ifr.setValue("taxableAmount", ""+taxableAmountHeader);
				/*GmmcoGstin gstin = dao.getGmmcoGstin(plant);
				logger.info("GMMCO GSTIN :: " + gstin);
				if (gstin != null) {
					ifr.setValue("businessplace", gstin.getBusinessPlace());
					ifr.setValue("gstingmmco", gstin.getSupplierGSTIN());

				}*/
				ArrayList<POHistoryBean> history1 = related
						.getPOHistory("PoNumber eq '" + ifr.getValue("ponumber") + "'");
				System.out.println("history1 : " + history1);
				ifr.clearCombo("grno");
				for (POHistoryBean histx : history1) {
					System.out.println(" histx.getMatDocNo() = " + histx.getMatDocNo());
					ifr.addItemInCombo("grno", histx.getMatDocNo(), histx.getMatDocNo());
				}

				ifr.addDataToGrid("table3", jsonArr);

				break;

			default:
				break;
			}

			break;
		case "onChange":

			switch (string)

			{
			
			case "fetchSectionCode":
				logger.info("withholdingtaxcode :: "+(String)ifr.getValue("withholdingtaxcode"));
				ifr.setValue("sectioncode", dao.getSectionCode((String)ifr.getValue("withholdingtaxcode")));
				break;
			
			case "fetchBusinessPlace":
				/*ifr.clearCombo("businessplace");
				for (String str : data) {
					logger.info("businessplace :: " + str);
					ifr.addItemInCombo("businessplace", str, str);
				}*/
				ifr.setValue("businessplace", dao.getBusinessPlace((String) ifr.getValue("gstingmmco")));
				calculateGstCategory((String)ifr.getValue("gstingmmco"), (String)ifr.getValue("gstinvendor"), ifr);
				break;

			case "empCode":
				MdmEmployeeMaster master = dao.getEmployee((String) ifr.getValue("employeecode"));
				logger.info("Master :: " + master);
				ifr.setValue("employeeemailID", master.getEmployee_email_id());
				ifr.setValue("employeeName", master.getEmployee_name());
				ifr.setValue("division", master.getDivision_code());
				break;
			case "copyInvoiceNumber":
				ifr.setValue("Documentheadertext", (String)ifr.getValue("invoicenumber"));
				break;
			case "fetchVendorCode":
				String gstinvendor = (String) ifr.getValue("gstinvendor");
				List<Vendor> vendorList = dao.getVendor(gstinvendor);
				Vendor vendor = vendorList.get(0);
				if (vendor != null) {

					ifr.clearCombo("withholdingtaxcode");
					logger.info("Vendor Found for the mentioned GSTIN :: " + gstinvendor);
					ifr.setValue("hiddenVendorCode", vendor.getVendor_code());
					ifr.setValue("vendorcode", vendor.getVendor_code());
					ifr.setValue("vendorname", vendor.getVendor_name());
					for (Vendor vendorX : vendorList) {
						ifr.addItemInCombo("withholdingtaxcode", vendorX.getWithholding_tax(),
								vendorX.getWithholding_tax());
					}
				} else
					logger.info("Vendor Not Found for the mentioned GSTIN :: " + gstinvendor);
				calculateGstCategory((String)ifr.getValue("gstingmmco"), (String)ifr.getValue("gstinvendor"), ifr);
				break;
			default:
				break;
			}
			break;

		default:
			break;

		}

		return "";
	}

	@Override
	public JSONArray validateSubmittedForm(FormDef fd, IFormReference ifr, String string) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public String executeCustomService(FormDef fd, IFormReference ifr, String string, String string1, String string2) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public String getCustomFilterXML(FormDef fd, IFormReference ifr, String string) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public String generateHTML(EControl ec) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public String introduceWorkItemInWorkFlow(IFormReference ifr, HttpServletRequest hsr, HttpServletResponse hsr1) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public String introduceWorkItemInWorkFlow(IFormReference ifr, HttpServletRequest hsr, HttpServletResponse hsr1,
			WorkdeskModel wm) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}
	public String datefromAPI(String datefrom) {

		String[] replacer = { "/Date(", ")/" };

		for (int i = 0; i < replacer.length; i++) {
			datefrom = datefrom.replace(replacer[i], "");
		}
		System.out.println("Date :: " + datefrom);
		Long l = new Long(datefrom);
		Date d1 = new Date(l);
		System.out.println(d1);

		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		String finaldate = form.format(d1);
		System.out.println(finaldate);
		return finaldate;
	}
	public void calculateGstCategory(String gmmco,String vendor,IFormReference ifr) {
		if(gmmco.equals("") || vendor.equals("")) {
			logger.info("No Calculation !");
		}
		else {
			
			if (gmmco.substring(0, 2).equalsIgnoreCase(vendor.substring(0, 2))) {
				System.out.println("Indexer Line 326 :: CGST  SGST");
				//gstTaxCodeFill("CGST  SGST", ifr);
				ifr.setValue("gstCategory", "CGST/SGST");
				 //ifr.addItemInCombo("gstCategory", "CGST/SGST", "CGST/SGST");
				 //ifr.addItemInCombo("gstCategory", "IGST", "IGST");
				gstTaxCodeFill("CGST  SGST", ifr);
				
			}
		 else {
			 ifr.setValue("gstCategory", "IGST");
			 //ifr.addItemInCombo("gstCategory", "IGST", "IGST");
			 //ifr.addItemInCombo("gstCategory", "CGST/SGST", "CGST/SGST");
			 gstTaxCodeFill("IGST", ifr);
		 }
		
		}
	}
	public void gstTaxCodeFill(String cat, IFormReference ifr) {
		System.out.println("Category ::: " + cat);
		List<String> list=dao.getTaxCode(cat);
		logger.info("List Size ::: "+list);
		for(String strX:list) {
			System.out.println("John Cena :: "+strX);
			ifr.addItemInCombo("taxcode", strX, strX);
		}
		
	}
	public String getPartNo(String partno) {
		Pattern pattern = Pattern.compile("[0-9]+[a-zA-Z]*[0-9]+");

		String part = "";
		String[] sub = {};

		String newline = System.getProperty("line.separator");
		boolean hasNewline = partno.contains(newline);
		if (hasNewline) {

			sub = partno.split("\\n");
			part = sub[0];
		} else if (partno.contains(" ")) {

			sub = partno.split(" ");
			part = sub[0];
		} else {
			part = partno.substring(0, 10);
		}

		//Matcher matcher = pattern.matcher(part);
		System.out.println("Sub String :: " + part);
		/*String b = "";
		while (matcher.find()) {
			b += matcher.group();
		}*/
		// System.out.println("Final Part Number ::: " + b);
		// System.out.println("***************************************");
		return part;
	}
	public void validateLineLevelData(IFormReference ifr) {
		LinkedList<Table6> invoiceList=  (LinkedList) ctx.getBean("dataArr");
		LinkedList<Table3> poList=  (LinkedList) ctx.getBean("dataArr");
		LinkedList<Table4> grnList=  (LinkedList) ctx.getBean("dataArr");
		JSONArray invoiceArr= ifr.getDataFromGrid("table6");
		JSONArray poArr= ifr.getDataFromGrid("table3");
		JSONArray grnArr= ifr.getDataFromGrid("table4");
		logger.info("Invoice Arr ::: "+invoiceArr);
		if(invoiceArr.size()==0) {
			ifr.setValue("textbox32", "" + "InvoiceTabBlank");
		}
		else if(grnArr.size()==0) {
			ifr.setValue("textbox32", "" + "GrnTabBlank");
		}
		else if(poArr.size()==0) {
			ifr.setValue("textbox32", "" + "POTabBlank");
		}
		else {
			//*********************Invoice Tab
			Iterator<JSONObject> itrInvoice=invoiceArr.iterator();
			while(itrInvoice.hasNext()) {
				JSONObject obj = itrInvoice.next();
				Table6 table6=new Gson().fromJson(obj.toJSONString(), Table6.class);
				//logger.info("Table 6 ::"+table6);
				invoiceList.add(table6);
			}
			logger.info("Table 6 List :::-> "+invoiceList);
			//*********************Invoice Tab
			//*********************PO Tab
			Iterator<JSONObject> itrPO=poArr.iterator();
			while(itrPO.hasNext()) {
				JSONObject objX = itrPO.next();
				Table3 table3=new Gson().fromJson(objX.toJSONString(), Table3.class);
				poList.add(table3);
			}
			logger.info("Table 3 List :: "+poList);
			//*********************PO Tab
			//*********************GRN Tab
			Iterator<JSONObject> itrGrn=grnArr.iterator();
			while(itrGrn.hasNext()) {
				JSONObject objY = itrGrn.next();
				logger.info("objY :: T4 :: "+objY);
				Table4 table4=new Gson().fromJson(objY.toJSONString(), Table4.class);
				grnList.add(table4);
			}
			logger.info("Table 4 List :: "+grnList);
			//*********************GRN Tab
			for(Table6 t6:invoiceList) {
				if(t6.getPartNo()!=null && t6.getPartNo()!="") {
					String testVal=getPartNo(t6.getPartNo());
					logger.info("Raw Part No from Invoice ::"+t6.getPartNo());
					logger.info("Fetch Part No ::"+testVal);
					for(Table4 t4:grnList) {
						if(t4.getMaterialCode().contains(testVal)) {
							logger.info("Congratulations You have a Match with Invoice Part Number with GRN Material Code");
							//HSN Start
							logger.info("t4.getHSNSAC() :: "+t4.getHSNSAC());
							logger.info("t6.getHSNCode() :: "+t6.getHSNCode());
							
							if(t4.getHSNSAC()==null || t6.getHSNCode()==null) {
								ifr.setValue("textbox32", "BlankHSN");
								ifr.setValue("textbox77", "GRN or Invoice HSN can't be blank or null for the matching part number :: "+testVal);
							}
							else {
								if(t4.getHSNSAC().equalsIgnoreCase(t6.getHSNCode())) 
									logger.info("HSN Match Invoice & GRN");
								else {
									ifr.setValue("textbox32", "HSNMismatch");
									logger.info("GRN HSN With Part Number "+testVal+" did not match");
									ifr.setValue("textbox77", "GRN HSN With Part Number "+testVal+" did not match");
									break;
								}
							}
							//HSN Close
							//Invoice Quantity Start
							logger.info("t4.getGRNQuantity() :: "+t4.getGRNQuantity());
							logger.info("t6.getQuantity() :: "+t6.getQuantity());
							
							if(t4.getGRNQuantity()==null || t4.getGRNQuantity().equalsIgnoreCase("") || t6.getQuantity()==null || t6.getQuantity().equalsIgnoreCase("")) {
								ifr.setValue("textbox32", "BlankQuantity");
								ifr.setValue("textbox77", "GRN or Invoice Quantity can't be blank or null for the matching part number :: "+testVal);
							}
							else {
								String grnQuantity=null;
								String invQunatity=null;
								try {
									grnQuantity=getDecimalNumber(t4.getGRNQuantity());
								}
								catch(NumberFormatException e) {
									logger.info("Number Trap 1"+e);
									ifr.setValue("textbox32", "NumberFormat1");
									ifr.setValue("textbox77", "GRN Quantity is not a valid number with Part Number :: "+testVal);
								}
								try {
									invQunatity=getDecimalNumber((t6.getQuantity()));
								}
								catch(NumberFormatException e) {
									logger.info("Number Trap 2");
									ifr.setValue("textbox32", "NumberFormat2");
									ifr.setValue("textbox77", "Invoice Quantity is not a valid number with Part Number :: "+testVal);
								}
								logger.info("INV Quantity :: "+invQunatity);
								logger.info("GRN Quantity :: "+grnQuantity);
								if(grnQuantity.equalsIgnoreCase(invQunatity)) 
									logger.info("Quantity Match Invoice & GRN");
								else {
									ifr.setValue("textbox32", "QuantityMismatch");
									logger.info("Quantity Mismatch With Part Number "+testVal+" did not match");
									ifr.setValue("textbox77", "Quantity Mismatch With Part Number "+testVal+" did not match");
									break;
								}
							}
							//Invoice Quantity Close

							//Amount Start
							logger.info("t4.getNetPrice() :: "+t4.getNetPrice());
							logger.info("t6.getTaxableValue() :: "+t6.getTaxableValue());
							
							if(t4.getNetPrice()==null || t4.getNetPrice().equalsIgnoreCase("") || t6.getTaxableValue()==null || t6.getTaxableValue().equalsIgnoreCase("")) {
								ifr.setValue("textbox32", "BlankPrice");
								ifr.setValue("textbox77", "GRN Net Price Field or Invoice Taxable Field can't be blank or null for the matching part number :: "+testVal);
							}
							else {
								String grnPrice=null;
								String invPrice=null;
								try {
									grnPrice=getDecimalNumber(t4.getNetPrice());
								}
								catch(NumberFormatException e) {
									logger.info("Number Trap 3"+e);
									ifr.setValue("textbox32", "NumberFormat3");
									ifr.setValue("textbox77", "GRN Price is not a valid number with Part Number :: "+testVal);
								}
								try {
									invPrice=getDecimalNumber((t6.getTaxableValue()));
								}
								catch(NumberFormatException e) {
									logger.info("Number Trap 2");
									ifr.setValue("textbox32", "NumberFormat4");
									ifr.setValue("textbox77", "Invoice Price is not a valid number with Part Number :: "+testVal);
								}
								logger.info("INV Price :: "+invPrice);
								logger.info("GRN Price :: "+grnPrice);
								if(grnPrice.equalsIgnoreCase(invPrice)) 
									logger.info("Price Match Invoice & GRN");
								else {
									ifr.setValue("textbox32", "PriceMismatch");
									logger.info("Price Mismatch With Part Number "+testVal+" did not match");
									ifr.setValue("textbox77", "Price Mismatch With Part Number "+testVal+" did not match");
									break;
								}
							}
							//Amount Close

							
						}
					}
				}
			}
		}
		
	}
	public String getDecimalNumber(String number) {
		Double d=Double.parseDouble(number);
		return String.format("%.5f", d);
	}
}