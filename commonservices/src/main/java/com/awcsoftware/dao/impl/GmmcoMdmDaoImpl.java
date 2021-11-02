package com.awcsoftware.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.awcsoftware.dao.IGmmcoMdmDao;
import com.awcsoftware.dto.mdm.MdmEmployeeMaster;
import com.awcsoftware.dto.mdm.mapper.MdmEmployeeMasterMapper;
import com.awcsoftware.services.impl.PropertiesReader;
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GmmcoMdmDaoImpl implements IGmmcoMdmDao {
	final static Logger logger = Logger.getLogger(GmmcoMdmDaoImpl.class);
	@Autowired
	private JdbcTemplate template;
	@Autowired MdmEmployeeMasterMapper mapper;
	@Override
	public List<MdmEmployeeMaster> getListOfEmployees() {
		return template.query(PropertiesReader.getProp().getProperty("mdm_employee_master"), mapper);
	}

}
