package com.awcsoftware.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.awcsoftware.dmsapi.CabinetAPI;
import com.newgen.dmsapi.DMSXmlResponse;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OmnidocsServices {
	final static Logger logger = Logger.getLogger(OmnidocsServices.class);

	@Autowired
	private ApplicationContext ctx;

	public String getSessionId() {
		CabinetAPI api = ctx.getBean(CabinetAPI.class);
		DMSXmlResponse response = api.connectCabinet();
		if (response.getVal("Status").equalsIgnoreCase("0")) {
			return response.getVal("UserDBId");
		} else {
			return response.getVal("Error");
		}
	}

}
