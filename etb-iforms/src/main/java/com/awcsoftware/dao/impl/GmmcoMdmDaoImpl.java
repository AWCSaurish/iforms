package com.awcsoftware.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.awcsoftware.dao.IGmmcoMdmDao;
import com.awcsoftware.dto.mdm.GmmcoGstin;
import com.awcsoftware.dto.mdm.MdmEmployeeMaster;
import com.awcsoftware.dto.mdm.mapper.GmmcoGstinMapper;
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
	public List<Vendor> getVendor(String gstin) {
		Object[] obj = new Object[] {gstin};
		List<Vendor> temp=template.query(PropertiesReader.getProp().getProperty("mdm_vendor"),obj, ctx.getBean(VendorMapper.class));
		// logger.info("Vendor List ::"+temp);
		return temp;
		//return template.queryForList(PropertiesReader.getProp().getProperty("mdm_vendor"),obj, ctx.getBean(VendorMapper.class));
	}
	@Override
	public Integer getInvoice(String invoicenumber, String invoicetotalamount, String vendorcode,String processid) {
		Integer i=null;
		logger.info("ETB Duplicate Invoice Check vendorcode :: "+vendorcode);
		logger.info("ETB Duplicate Invoice Check invoicetotalamount :: "+invoicetotalamount);
		logger.info("ETB Duplicate Invoice Check invoicenumber :: "+invoicenumber);
		logger.info("ETB Duplicate Invoice Check processid :: "+processid);
		Object[] obj = new Object[] {invoicenumber,invoicetotalamount,vendorcode,processid};
		try {
			i = template.queryForObject(PropertiesReader.getProp().getProperty("validateInvoice"),obj, Integer.class);
			return i;
		}
		catch(EmptyResultDataAccessException e) {
			return i;
		}
		
	}
	/*@Override
	public List<String> getBusinessPlace(String gstin) {
		List<String> i=null;
		logger.info("ETB Business Place Code :: "+gstin);
		
		Object[] obj = new Object[] {gstin};
		try {
			i = template.queryForList(PropertiesReader.getProp().getProperty("getBusinessPlace"),obj, String.class);
			return i;
		}
		catch(EmptyResultDataAccessException e) {
			return i;
		}
		
	}*/
	@Override
	public String getBusinessPlace(String code) {
		Object[] obj = new Object[] {code};
		return template.queryForObject(PropertiesReader.getProp().getProperty("getBusinessPlace"),obj, String.class);
		//return null;
	}
	
	@Override
	public List<String> getCurrency() {
		List<String> list=template.queryForList(PropertiesReader.getProp().getProperty("mdm_currency"), String.class);
		return list;
	}
	@Override
	public GmmcoGstin getGmmcoGstin(String plantCode) {
		logger.info("Plant From DAO :: "+plantCode);
		Object[] obj = new Object[] {plantCode};
		GmmcoGstin gstin= template.queryForObject(PropertiesReader.getProp().getProperty("gmmcoGstin"),obj, ctx.getBean(GmmcoGstinMapper.class));
		logger.info("GSTIN From DAO :: "+gstin);
		return gstin;
		
	}
	@Override
	public String getWithholdingTaxCodeType(String withholding_tax_code) {
		Object[] obj = new Object[] {withholding_tax_code};
		return template.queryForObject(PropertiesReader.getProp().getProperty("withholdingTaxCodeType"),obj, String.class);
	}
	@Override
	public String getSectionCode(String withholding_tax_code) {
		Object[] obj = new Object[] {withholding_tax_code};
		return template.queryForObject(PropertiesReader.getProp().getProperty("sectionCode"),obj, String.class);
	}
	@Override
	public List<String> getTaxCode(String taxCategory) {
		Object[] obj = new Object[] {taxCategory};
		try {
		List<String> list=template.queryForList(PropertiesReader.getProp().getProperty("mdm_tax_master"),obj, String.class);
		logger.info("Data Found for TAX Category ::: "+list);
		return list;
		}
		catch(Exception e) {
			logger.info("Exception in TAX Category !");
			logger.info(e);
			return null;
		}
	}
	
}
