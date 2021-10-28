package com.awcsoftware.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.awcsoftware.dto.POResponse;
import com.awcsoftware.dto.poheader.Result;
import com.awcsoftware.dto.poheader.Root;
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
	public List<Result> getPoHeader(String filter) {
		Root object=null;
		GeneralServices services=ctx.getBean(GeneralServices.class);
		JSONObject outputjson = services.poPullRequest(filter, PropertiesReader.getProp().getProperty("POUrl"));
		try {
			object=objectMapper.readValue(outputjson.toString(),Root.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return object.getD().getResults();
	}
	@Override
	public List<com.awcsoftware.dto.poline.Result> getPOLines(String filter) {
		com.awcsoftware.dto.poline.Root object=null;
		GeneralServices services=ctx.getBean(GeneralServices.class);
		JSONObject outputjson=services.poPullRequest(filter, PropertiesReader.getProp().getProperty("POLineUrl"));
		try {
			object=objectMapper.readValue(outputjson.toString(),com.awcsoftware.dto.poline.Root.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return object.getD().getResults();
	}
	@Override
	public POResponse getPODetails(String filter) {
		 response.setHeader(getPoHeader(filter)); ;
		 response.setLine(getPOLines(filter));;
		 return response;
	}
	@Override
	public void getPOHistory(String filter) {
		GeneralServices services=ctx.getBean(GeneralServices.class);
		JSONObject outputjson=services.poPullRequest(filter, PropertiesReader.getProp().getProperty("POHistoryUrl"));
		logger.info("outputjson :: "+outputjson);
		
	}
	
}
