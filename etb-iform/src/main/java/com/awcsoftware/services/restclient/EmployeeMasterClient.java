package com.awcsoftware.services.restclient;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.awcsoftware.dto.mdm.MdmEmployeeMaster;
import com.awcsoftware.services.GeneralServices;
import com.awcsoftware.services.PropertiesReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientResponse;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EmployeeMasterClient {
	final static Logger logger = Logger.getLogger(EmployeeMasterClient.class);
	@Autowired
	private JSONParser parser;
	@Autowired
	private ObjectMapper objectMapper;

	public void sample() {
		JSONArray json = null;
		try {
			ClientResponse resp = GeneralServices.getWebResource()
					.path(PropertiesReader.getProp().getProperty("EmpMasterUrl")).queryParam("$format", "json")
					.get(ClientResponse.class);

			json = (JSONArray) parser.parse(resp.getEntity(String.class));
			System.out.println("JSON Array" + json);
			for (int i = 0; i < json.size(); i++) {
				MdmEmployeeMaster object = null;
				JSONObject outputjson = (JSONObject) json.get(i);
				object = objectMapper.readValue(outputjson.toString(), MdmEmployeeMaster.class);
				System.out.println("-->" + object);
			}
		} catch (Exception e) {
			logger.info(e.getLocalizedMessage());
		}

	}
	public JSONArray getEmployees() {
		System.out.println("From GetEmployees");
		try {
			ClientResponse resp = GeneralServices.getWebResource()
					.path(PropertiesReader.getProp().getProperty("EmpMasterUrl")).queryParam("$format", "json")
					.get(ClientResponse.class);
			logger.info("1-->");
			JSONArray arr=(JSONArray) parser.parse(resp.getEntity(String.class));
			logger.info("2-->");
			logger.info("Array Length :: "+arr.size());
			logger.info("Arr :: "+arr);
			 return arr;
			
		} catch (Exception e) {
			logger.info(e.getLocalizedMessage());
			return null;
		}
	}
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		ctx.getBean(EmployeeMasterClient.class).getEmployees();
	}
}
