package com.awcsoftware.dto.vendor.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.awcsoftware.dto.vendor.Invoice;
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class InvoiceMapper implements RowMapper<Invoice> {
	@Autowired
	private Invoice invoice;
	@Override
	public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException {
		invoice.setInvoicenumber(rs.getString("invoicenumber"));
		invoice.setInvoicetotalamount(rs.getString("invoicetotalamount"));
		invoice.setVendorcode(rs.getString("vendorcode"));
		return invoice;
	}

}
