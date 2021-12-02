package com.awcsoftware.services;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.awcsoftware.dto.po.PORequest;
import com.awcsoftware.dto.po.POResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sun.jersey.api.client.ClientResponse;
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PORestClient implements RestClient{
	final static Logger logger = Logger.getLogger(PORestClient.class);
	@Autowired
	private JSONParser parser;
	@Autowired
	private PORequest req;
	@Autowired
	private ObjectMapper objectMapper;
	@Override
	public POResponse getPODetails(String filter) {
		POResponse object=null;
		try {
		//logger.info("From PO Rest Client :: "+filter);
		req.setFilter(filter);
		String test=json.createJson(req);
		//logger.info("Test :: "+test);
		JSONObject json = null;
		ClientResponse resp = GeneralServices.getWebResource().path(PropertiesReader.getProp().getProperty("PoDetailsUrl")).accept("application/json").type("application/json").post(ClientResponse.class,test);
		logger.info("Hello !"+resp);
			json = (JSONObject) parser.parse(resp.getEntity(String.class)); 
			logger.info("JSON After Parse :: "+json);
			object=objectMapper.readValue(json.toString(),POResponse.class);
			logger.info("Object :: "+object);
		} catch (Exception e) {
			System.out.println("Catch Block :: "+e);
			System.err.println("Catch Block :: "+e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
	public GeneralServices json=(req)->{
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json;
		try {
			json = ow.writeValueAsString(req);
			logger.info("JSON ::"+json);
			return json;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			//logger.info("From Catch :: JSON :: "+e);
			return null;
		}
		
	};
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		ctx.getBean(PORestClient.class).getPODetails("PoNumber eq '2000000000'");
	}
}
