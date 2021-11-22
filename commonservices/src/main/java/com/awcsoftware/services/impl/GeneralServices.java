package com.awcsoftware.services.impl;

import javax.ws.rs.core.MultivaluedMap;
import javax.xml.bind.DatatypeConverter;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GeneralServices {
	final static Logger logger = Logger.getLogger(GeneralServices.class);
	@Autowired
	private JSONParser parser;
	
	
	public JSONObject poPullRequest(String filter, String url) {
		JSONObject json = null;
		try {
		logger.info("Filter : "+filter +" :: URL : "+url);
		ClientResponse resp = getWebResource()
				.path(url)
				.queryParam("$filter", filter)
				.queryParam("$format", "json")
				.header("Authorization", "Basic " + encodeAuthString()).get(ClientResponse.class);
		json = (JSONObject) parser.parse(resp.getEntity(String.class)); 
		}
		catch(ParseException e) {
			logger.info(e.getStackTrace());
		}
		logger.info("JSON :: "+json);
		return json;
	}

	public String tokenPullRequest() {
		String token = null;
		ClientResponse resp = getWebResource().path(PropertiesReader.getProp().getProperty("TokenUrl"))
                .header("X-CSRF-Token", "fetch")
                .header("Authorization", "Basic " + encodeAuthString()).get(ClientResponse.class);
		logger.info("Status Code :: " + resp.getStatus());
		logger.info("Response ::: " + resp.toString());
        MultivaluedMap<String, String> head = resp.getHeaders();
        token = head.getFirst("x-csrf-token");
        logger.info("Response Output ::: " + resp.getEntity(String.class));
        logger.info("Token From Header ::: " + token);
        return token;
	}
	
	public String miroPosting(String token, String input) {
        String outputxml = null;
        ClientResponse resp = getWebResource().path(PropertiesReader.getProp().getProperty("mirourl")).accept("application/xml").type("application/json")
                .header("X-CSRF-Token", token)
                .header("Authorization", "Basic " + encodeAuthString())
                .post(ClientResponse.class, input);
        logger.info("Status Code :: " + resp.getStatus());
        logger.info("Response ::: " + resp.toString());
        outputxml = resp.getEntity(String.class);
        logger.info("Response Output ::: " + outputxml);

        return outputxml;
	}
	
	public WebResource getWebResource() {
		return Client.create().resource("");
	}
	public String encodeAuthString() {
		String str=DatatypeConverter.printBase64Binary((PropertiesReader.getProp().getProperty("APIUser") + ":"
				+ PropertiesReader.getProp().getProperty("APIPass")).getBytes());
		logger.info("Auth String :: "+str);
		return str;
	}
	
}
