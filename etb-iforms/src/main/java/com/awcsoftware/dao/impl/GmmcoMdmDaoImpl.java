package com.awcsoftware.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.awcsoftware.dao.IGmmcoMdmDao;
import com.awcsoftware.dto.mdm.MdmEmployeeMaster;
import com.awcsoftware.dto.mdm.mapper.MdmEmployeeMasterMapper;
import com.awcsoftware.dto.vendor.Vendor;
import com.awcsoftware.dto.vendor.mapper.VendorMapper;
import com.awcsoftware.services.PropertiesReader;
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GmmcoMdmDaoImpl implements IGmmcoMdmDao {
	final static Logger logger = Logger.getLogger(GmmcoMdmDaoImpl.class);
	@Autowired
	private JdbcTemplate template;
	@Autowired
	private ApplicationContext ctx;
	
	@Override
	public List<MdmEmployeeMaster> getListOfEmployees() {
		return template.query(PropertiesReader.getProp().getProperty("mdm_employee_master"), ctx.getBean(MdmEmployeeMasterMapper.class));
	}
	@Override
	public MdmEmployeeMaster getEmployee(String empCode) {
		Object[] obj = new Object[] {empCode};
		return template.queryForObject(PropertiesReader.getProp().getProperty("mdm_employee"),obj, ctx.getBean(MdmEmployeeMasterMapper.class));
	}
	@Override
	public Vendor getVendor(String gstin) {
		Object[] obj = new Object[] {gstin};
		return template.queryForObject(PropertiesReader.getProp().getProperty("mdm_vendor"),obj, ctx.getBean(VendorMapper.class));
	}
	@Override
	public Integer getInvoice(String invoicenumber, String invoicetotalamount, String vendorcode) {
		Integer i=null;
		logger.info("ETB Duplicate Invoice Check vendorcode :: "+vendorcode);
		logger.info("ETB Duplicate Invoice Check invoicetotalamount :: "+invoicetotalamount);
		logger.info("ETB Duplicate Invoice Check invoicenumber :: "+invoicenumber);
		Object[] obj = new Object[] {invoicenumber,invoicetotalamount,vendorcode};
		try {
			i = template.queryForObject(PropertiesReader.getProp().getProperty("validateInvoice"),obj, Integer.class);
			return i;
		}
		catch(EmptyResultDataAccessException e) {
			return i;
		}
		
	}
	@Override
	public String getBusinessPlace(String placeCode) {
		String i=null;
		logger.info("ETB Business Place Code :: "+placeCode);
		
		Object[] obj = new Object[] {placeCode};
		try {
			i = template.queryForObject(PropertiesReader.getProp().getProperty("getBusinessPlace"),obj, String.class);
			return i;
		}
		catch(EmptyResultDataAccessException e) {
			return i;
		}
		
	}
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		String i=ctx.getBean(GmmcoMdmDaoImpl.class).getBusinessPlace("APX");
		System.out.println("INV :: "+i);
	}
}
