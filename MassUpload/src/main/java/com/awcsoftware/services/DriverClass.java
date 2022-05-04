package com.awcsoftware.services;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.awcsoftware.dmsapi.UploadDocument;

public class DriverClass {
	final static Logger logger = Logger.getLogger(DriverClass.class);
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		File f=new File("D:\\documents\\Orient Electric\\");
		String[] arr=f.list();
		String sessionId=ctx.getBean(OmnidocsServices.class).getSessionId();
		UploadDocument udDocument= ctx.getBean(UploadDocument.class);
		logger.info("Session Id :: "+sessionId);
		for(String str:arr) {
			logger.info("File :: "+str);
			udDocument.upload(sessionId, new File("D:\\documents\\Orient Electric\\"+str));
		}
		
	}

}
