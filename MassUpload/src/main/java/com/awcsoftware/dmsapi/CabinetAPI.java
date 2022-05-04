package com.awcsoftware.dmsapi;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.awcsoftware.services.PropertiesReader;
import com.newgen.dmsapi.DMSCallBroker;
import com.newgen.dmsapi.DMSInputXml;
import com.newgen.dmsapi.DMSXmlResponse;

@Component
public class CabinetAPI {
	final static Logger logger = Logger.getLogger(CabinetAPI.class);
	@Autowired
	private DMSInputXml inputxml;
	@Autowired
	private DMSXmlResponse response;

	DMSXmlResponse callBroker(String str) {
		try {
			response.setXmlString(DMSCallBroker.execute(str, PropertiesReader.getProp().getProperty("serverIp"),
					Integer.valueOf(PropertiesReader.getProp().getProperty("jtsPort")), 0));

		} catch (Exception e) {
			logger.info("Error in DMS Call Broker" + e);

		}

		return response;
	}

	public DMSXmlResponse connectCabinet() {
		return callBroker(inputxml.getConnectCabinetXml(PropertiesReader.getProp().getProperty("cabinetName"),
				"supervisor", "supervisor351", "", "Y", "0", "S", ""));
	}

	public DMSXmlResponse disconnectCabinet(String sessionId) {
		return callBroker(
				inputxml.getDisconnectCabinetXml(PropertiesReader.getProp().getProperty("cabinetName"), sessionId));
	}


}
