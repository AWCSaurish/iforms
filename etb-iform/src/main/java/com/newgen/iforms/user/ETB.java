package com.newgen.iforms.user;

import org.apache.log4j.Logger;

import com.newgen.iforms.custom.IFormListenerFactory;
import com.newgen.iforms.custom.IFormReference;
import com.newgen.iforms.custom.IFormServerEventHandler;

public class ETB implements IFormListenerFactory {
	final static Logger logger = Logger.getLogger(ETB.class);
	@Override
	public IFormServerEventHandler getClassInstance(IFormReference ifr) {
		String activityName=ifr.getActivityName();
		logger.info("LoggerX KungFuS : "+activityName);
		System.out.println("Activity Name KungFuS : "+activityName);
		return new Indexer();
	}

}
