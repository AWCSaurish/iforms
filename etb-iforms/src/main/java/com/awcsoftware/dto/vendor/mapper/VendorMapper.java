package com.awcsoftware.dto.vendor.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.awcsoftware.dto.vendor.Vendor;
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class VendorMapper implements RowMapper<Vendor>{
	@Autowired
	private ApplicationContext ctx;
	@Override
	public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Vendor vendor=ctx.getBean(Vendor.class);
		vendor.setWithholding_tax(rs.getString("withholding_tax"));
		vendor.setVendor_code(rs.getString("vendor_code"));
		vendor.setVendor_GSTN(rs.getString("vendor_GSTN"));
		vendor.setVendor_name(rs.getString("vendor_name"));
		return vendor;
	}

}
