package com.newgen.iforms.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.awcsoftware.dao.IGmmcoMdmDao;
import com.awcsoftware.dto.mdm.MdmEmployeeMaster;
import com.newgen.iforms.EControl;
import com.newgen.iforms.FormDef;
import com.newgen.iforms.custom.IFormReference;
import com.newgen.iforms.custom.IFormServerEventHandler;
import com.newgen.mvcbeans.model.WorkdeskModel;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Indexer implements IFormServerEventHandler {
	@Autowired
	private IGmmcoMdmDao dao;

	final static Logger logger = Logger.getLogger(Indexer.class);

	public Indexer() {
		logger.info("From Indexer Cons.");
	}

	@Override
	public void beforeFormLoad(FormDef fd, IFormReference ifr) {
		logger.info("From Form Loaded Spring :: ");
		List<MdmEmployeeMaster> list = dao.getListOfEmployees();
		for (MdmEmployeeMaster master : list) {
			ifr.addItemInCombo("employeecode", master.getEmployee_code(), master.getEmployee_code());
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
		logger.info("string :: " + string);
		logger.info("string1 :: " + string1);
		logger.info("string2 :: " + string2);

		switch (string1) {

		case "OnClick":
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