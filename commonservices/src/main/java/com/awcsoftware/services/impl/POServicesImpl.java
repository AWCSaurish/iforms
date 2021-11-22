package com.awcsoftware.services.impl;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.awcsoftware.dao.IGmmcoMdmDao;
import com.awcsoftware.dto.mdm.MdmEmployeeMaster;
import com.awcsoftware.dto.po.HeaderResult;
import com.awcsoftware.dto.po.HistoryResult;
import com.awcsoftware.dto.po.LineResult;
import com.awcsoftware.dto.po.POResponse;
import com.awcsoftware.dto.po.Root;
import com.awcsoftware.services.IPOServices;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class POServicesImpl implements IPOServices{
	final static Logger logger = Logger.getLogger(POServicesImpl.class);
	@Autowired
	private ApplicationContext ctx;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private POResponse response;
	@Override
	public List<HeaderResult> getPoHeader(String filter) {
		Root object=null;
		GeneralServices services=ctx.getBean(GeneralServices.class);
		JSONObject outputjson = services.poPullRequest(filter, PropertiesReader.getProp().getProperty("POUrl"));
		logger.info("Object S :: "+outputjson);
		try {
			object=objectMapper.readValue(outputjson.toString(),Root.class);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (List<HeaderResult>) object.getD().getResults();
	}
	@Override
	public List<LineResult> getPOLines(String filter) {
		Root object=null;
		GeneralServices services=ctx.getBean(GeneralServices.class);
		JSONObject outputjson=services.poPullRequest(filter, PropertiesReader.getProp().getProperty("POLineUrl"));
		try {
			object=objectMapper.readValue(outputjson.toString(),Root.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (List<LineResult>) object.getD().getResults();
	}
	@Override
	public POResponse getPODetails(String filter) {
		 response.setHeader(getPoHeader(filter));
		 response.setLine(getPOLines(filter));
		 response.setHistory(getPOHistory(filter));
		 return response;
	}
	@Override
	public List<HistoryResult> getPOHistory(String filter) {
		Root object=null;
		GeneralServices services=ctx.getBean(GeneralServices.class);
		JSONObject outputjson=services.poPullRequest(filter, PropertiesReader.getProp().getProperty("POHistoryUrl"));
		try {
			object=objectMapper.readValue(outputjson.toString(),Root.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (List<HistoryResult>) object.getD().getResults();
		
	}
	@Override
	public List<MdmEmployeeMaster> getListOfEmployees() {
		IGmmcoMdmDao dao=ctx.getBean(IGmmcoMdmDao.class);
		return dao.getListOfEmployees();
	}
	
}
