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
import com.awcsoftware.dto.po.POResponse;
import com.awcsoftware.dto.vendor.Vendor;
import com.awcsoftware.services.RestClient;
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
	private RestClient client;
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
				logger.info("Test For Rest Response :: ");
				ArrayList<POBean> poBean = related.getPODetails("PoNumber eq '"+ifr.getValue("ponumber")+"'");
				//ArrayList<PoDetailsBean> details = related.getPOLines("PoNumber eq '"+ifr.getValue("ponumber")+"'");
				//ArrayList<POHistoryBean> history=related.getPOHistory("PoNumber eq '"+ifr.getValue("ponumber")+"'");
				//POResponse response=client.getPODetails("PoNumber eq '"+ifr.getValue("ponumber")+"'");
				ifr.setValue("textbox34", poBean.get(0).getVendor());
				ifr.setValue("currency", poBean.get(0).getCurrency());
				
				//Line Item
				/*JSONArray arr=new JSONArray();
				{
					JSONObject obj = new JSONObject();
					obj.put("PO No", null);
					arr.add(obj);
				}
				ifr.addDataToGrid("tableName", arr);
				logger.info("Response :: "+response);*/
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