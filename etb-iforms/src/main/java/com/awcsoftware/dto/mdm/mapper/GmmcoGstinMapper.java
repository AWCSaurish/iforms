package com.awcsoftware.dto.mdm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.awcsoftware.dto.mdm.GmmcoGstin;
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GmmcoGstinMapper implements RowMapper<GmmcoGstin> {
	public GmmcoGstinMapper() {
		System.out.println("GmmcoGstin Mapper Created");
	}
	@Autowired
	private ApplicationContext ctx;
	@Override
	public GmmcoGstin mapRow(ResultSet rs, int rowNum) throws SQLException {
		GmmcoGstin gmmco=ctx.getBean(GmmcoGstin.class);
		System.out.println("TESTER PRATIK");
		gmmco.setBusinessPlace(rs.getString("BusinessPlace"));
		gmmco.setSupplierGSTIN(rs.getString("SupplierGSTIN"));
		return gmmco;
	}

}
