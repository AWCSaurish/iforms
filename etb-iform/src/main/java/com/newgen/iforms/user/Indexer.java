package com.newgen.iforms.user;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.awcsoftware.dto.mdm.MdmEmployeeMaster;
import com.awcsoftware.services.restclient.EmployeeMasterClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newgen.iforms.EControl;
import com.newgen.iforms.FormDef;
import com.newgen.iforms.custom.IFormReference;
import com.newgen.iforms.custom.IFormServerEventHandler;
import com.newgen.mvcbeans.model.WorkdeskModel;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Indexer implements IFormServerEventHandler {
	
	@Autowired
	private EmployeeMasterClient emc;
	@Autowired
	private ObjectMapper objectMapper;
	
	final static Logger logger = Logger.getLogger(Indexer.class);
	public Indexer() {
		logger.info("From Indexer Cons.");
	}
    @Override
    public void beforeFormLoad(FormDef fd, IFormReference ifr) {
    	logger.info("Heelo Frol Imndexer :: ");
    	System.out.println("Heelo Frol Imndexer :: ");
    	JSONArray arr= emc.getEmployees();
    	
    	logger.info("Array Size :: "+arr.size());
    	
    	try {
    	for (int i = 0; i < arr.size(); i++) {
    		MdmEmployeeMaster object = null;
    		JSONObject outputjson = (JSONObject) arr.get(i);
    		object = objectMapper.readValue(outputjson.toString(), MdmEmployeeMaster.class);
    		logger.info("Mdm Emmployee Master :: "+object);
    		ifr.addItemInCombo("employeecode", object.getEmployee_code()+" "+object.getEmployee_name(),object.getEmployee_code());
		}
    	} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @Override
    public String setMaskedValue(String string, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JSONArray executeEvent(FormDef fd, IFormReference ifr, String string, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String executeServerEvent(IFormReference ifr, String string, String string1, String string2) {


        return "";
    }

    @Override
    public JSONArray validateSubmittedForm(FormDef fd, IFormReference ifr, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String executeCustomService(FormDef fd, IFormReference ifr, String string, String string1, String string2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCustomFilterXML(FormDef fd, IFormReference ifr, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String generateHTML(EControl ec) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String introduceWorkItemInWorkFlow(IFormReference ifr, HttpServletRequest hsr, HttpServletResponse hsr1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String introduceWorkItemInWorkFlow(IFormReference ifr, HttpServletRequest hsr, HttpServletResponse hsr1, WorkdeskModel wm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}