package com.newgen.iforms.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.awcsoftware.dao.IGmmcoMdmDao;
import com.awcsoftware.dto.mdm.MdmEmployeeMaster;
import com.awcsoftware.dto.vendor.Vendor;
import com.newgen.dto.POBean;
import com.newgen.dto.POHistoryBean;
import com.newgen.dto.PoDetailsBean;
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
	final static Logger logger = Logger.getLogger(Indexer.class);
	

	public Indexer() {
		logger.info("From Indexer Cons.");
	}

	@Override
	public void beforeFormLoad(FormDef fd, IFormReference ifr) {
		logger.info("From Form Loaded Spring :: ");
		List<String> currList = dao.getCurrency();
		for(String str:currList) {
			ifr.addItemInCombo("currency", str, str);
		}
		List<MdmEmployeeMaster> list = dao.getListOfEmployees();
		for (MdmEmployeeMaster master : list) {
			ifr.addItemInCombo("employeecode", master.getEmployee_code(), master.getEmployee_code());
			//logger.info("Master :: "+master);
		}
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
			switch(string) {
			case "Btn_Simulate":
				String t1=(String)ifr.getValue("textbox34");
				String t2=(String)ifr.getValue("vendorcode");
				logger.info("T1 :: "+t1);
				logger.info("T2 :: "+t2);
				if(t1.equalsIgnoreCase(t2)) {
					logger.info("Vendor Match");
					ifr.setValue("textbox34", "Vendor Match");
				}
				else {
					logger.info("Vendor Mistatch");
				}
				Integer inv=dao.getInvoice((String)ifr.getValue("invoicenumber"), (String)ifr.getValue("invoicetotalamount"), (String)ifr.getValue("vendorcode"));
				logger.info("Invoice :: "+inv);
				//Method 1 Start
				ifr.setValue("textbox32", ""+inv);
				//Method 2 start
					/*if(inv!=0)
					{
						ifr.setValue("textbox32", "dup");
					}*/
				//return "Duplicate Invoice Found";
				break;
			case "fetchPOData":
				ifr.clearTable("table3");
				ifr.clearTable("table4");
				
				ArrayList<POBean> poBean = related.getPODetails("PoNumber eq '"+ifr.getValue("ponumber")+"'");
				ArrayList<PoDetailsBean> details = related.getPOLines("PoNumber eq '"+ifr.getValue("ponumber")+"'");
				ArrayList<POHistoryBean> history=related.getPOHistory("PoNumber eq '"+ifr.getValue("ponumber")+"'");
				//POResponse response=client.getPODetails("PoNumber eq '"+ifr.getValue("ponumber")+"'");
				ifr.setValue("textbox34", poBean.get(0).getVendor());
				ifr.setValue("currency", poBean.get(0).getCurrency());
				JSONArray jsonArr = new JSONArray();
				for(PoDetailsBean detailsX:details) {
					JSONObject jsonObj = new JSONObject();
					jsonObj.put("PO No", detailsX.getPoNumber());
					jsonObj.put("PO Category", detailsX.getPoType());
					jsonObj.put("PO Line Item", detailsX.getPoItem());
					jsonObj.put("GR Number", "");
					jsonObj.put("Tax Code", detailsX.getTaxCode());
					jsonObj.put("Line Item Text", "");
					jsonObj.put("Taxable Amount (Line Item Amount )", "");
					jsonObj.put("Qty", detailsX.getQuantity());
					jsonObj.put("UOM", detailsX.getUom());
					jsonObj.put("Other Charges", "");
					jsonObj.put("WBS", detailsX.getWbs());
					jsonObj.put("GL Account", "");
					jsonObj.put("Profit Centre", "");
					jsonObj.put("Amount", detailsX.getNetValue());
					jsonObj.put("Plant", detailsX.getPlant());
					jsonArr.add(jsonObj);
				}
				
				JSONArray jsonArrX = new JSONArray();
				for(POHistoryBean historyX:history) {
					JSONObject jsonObj = new JSONObject();
					jsonObj.put("PO Number", historyX.getPoNumber());
					jsonObj.put("HSN/SAC", "");
					jsonObj.put("Material Code", historyX.getMatDocItem());
					jsonObj.put("PO Text", "");
					jsonObj.put("Account Assignment Category", "");
					jsonObj.put("WBSL Amount", "");
					jsonObj.put("Order Number", "");
					jsonObj.put("Asset", "");
					jsonObj.put("Profit Centre", "");
					jsonObj.put("Net PO Value", historyX.getAmountDoccurr());
					jsonObj.put("Net Price Value", historyX.getAmountLoccurr());
					jsonObj.put("Price Per Unit", "");
					jsonObj.put("Refence Document Number-GRN", historyX.getRefDocNo());
					jsonObj.put("Delivery Note - GRN Number", historyX.getMatDocNo());
					jsonObj.put("GRN Date", historyX.getPostDate());
					jsonObj.put("Line Item number", historyX.getPoItem());
					jsonObj.put("GRN- Quantity", historyX.getQuantity());
					jsonObj.put("Assignment", "");
					jsonObj.put("Serial Number", historyX.getSerialNo());
					jsonObj.put("Material Group", historyX.getMaterial());
					jsonObj.put("Plant", historyX.getPlant());
					jsonObj.put("Delivery", historyX.getDeliveryItem());
					jsonArrX.add(jsonObj);
				}
				
				ifr.addDataToGrid("table3", jsonArr);
				ifr.addDataToGrid("table4", jsonArrX);
				break;
				
				default : break;
			}
			
			break;
		case "onChange":

			switch (string)

			{
			case "empCode":
				MdmEmployeeMaster master=dao.getEmployee((String) ifr.getValue("employeecode"));
				logger.info("Master :: "+master);
				ifr.setValue("employeeemailID", master.getEmployee_email_id());
				ifr.setValue("employeeName", master.getEmployee_name());
				ifr.setValue("division", master.getDivision_code());
				break;
			case "fetchVendorCode":
				Vendor vendor = dao.getVendor((String)ifr.getValue("gstinvendor"));
				ifr.setValue("vendorcode", vendor.getVendor_code());
				
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

}