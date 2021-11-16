package com.awcsoftware.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.awcsoftware.dao.IGmmcoDao;
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GmmcoDaoImpl implements IGmmcoDao {
	final static Logger logger = Logger.getLogger(GmmcoDaoImpl.class);

	@Override
	public void getEmployeeMasters() {
		logger.info("From Impl");
	}

}
