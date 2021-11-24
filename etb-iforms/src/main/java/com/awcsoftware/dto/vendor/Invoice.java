package com.awcsoftware.dto.vendor;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Invoice {
	private String invoicenumber,invoicetotalamount,vendorcode;
	public Invoice() {
	}
	public String getInvoicenumber() {
		return invoicenumber;
	}
	public void setInvoicenumber(String invoicenumber) {
		this.invoicenumber = invoicenumber;
	}
	public String getInvoicetotalamount() {
		return invoicetotalamount;
	}
	public void setInvoicetotalamount(String invoicetotalamount) {
		this.invoicetotalamount = invoicetotalamount;
	}
	public String getVendorcode() {
		return vendorcode;
	}
	public void setVendorcode(String vendorcode) {
		this.vendorcode = vendorcode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((invoicenumber == null) ? 0 : invoicenumber.hashCode());
		result = prime * result + ((invoicetotalamount == null) ? 0 : invoicetotalamount.hashCode());
		result = prime * result + ((vendorcode == null) ? 0 : vendorcode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		if (invoicenumber == null) {
			if (other.invoicenumber != null)
				return false;
		} else if (!invoicenumber.equals(other.invoicenumber))
			return false;
		if (invoicetotalamount == null) {
			if (other.invoicetotalamount != null)
				return false;
		} else if (!invoicetotalamount.equals(other.invoicetotalamount))
			return false;
		if (vendorcode == null) {
			if (other.vendorcode != null)
				return false;
		} else if (!vendorcode.equals(other.vendorcode))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Invoice [invoicenumber=" + invoicenumber + ", invoicetotalamount=" + invoicetotalamount
				+ ", vendorcode=" + vendorcode + "]";
	}
	
}
