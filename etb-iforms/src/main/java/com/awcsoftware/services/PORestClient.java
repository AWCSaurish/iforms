package com.awcsoftware.services;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
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
	@Autowired
	private JSONParser parser;
	@Autowired
	private PORequest req;
	@Autowired
	private ObjectMapper objectMapper;
	@Override
	public POResponse getPODetails(String filter) {
		POResponse object=null;
		req.setFilter(filter);
		String test=json.createJson(req);
		JSONObject json = null;
		ClientResponse resp = GeneralServices.getWebResource()
				.path(PropertiesReader.getProp().getProperty("PoDetailsUrl")).accept("application/json").type("application/json")
				.post(ClientResponse.class,test);
		try {
			json = (JSONObject) parser.parse(resp.getEntity(String.class)); 
			object=objectMapper.readValue(json.toString(),POResponse.class);
			System.out.println("JSON Array" + object);
		} catch (Exception e) {
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
			return json;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
		
	};
	/*public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		ctx.getBean(PORestClient.class).getPODetails("PoNumber eq '2000000000'");
	}*/
}
