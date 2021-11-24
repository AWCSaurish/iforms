package com.awcsoftware.dto.vendor;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Vendor {
	private String vendor_code;
	private String vendor_name;
	private String vendor_GSTN;
	private String pan_number;
	public Vendor() {
	}
	public String getVendor_code() {
		return vendor_code;
	}
	public void setVendor_code(String vendor_code) {
		this.vendor_code = vendor_code;
	}
	public String getVendor_name() {
		return vendor_name;
	}
	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}
	public String getVendor_GSTN() {
		return vendor_GSTN;
	}
	public void setVendor_GSTN(String vendor_GSTN) {
		this.vendor_GSTN = vendor_GSTN;
	}
	public String getPan_number() {
		return pan_number;
	}
	public void setPan_number(String pan_number) {
		this.pan_number = pan_number;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pan_number == null) ? 0 : pan_number.hashCode());
		result = prime * result + ((vendor_GSTN == null) ? 0 : vendor_GSTN.hashCode());
		result = prime * result + ((vendor_code == null) ? 0 : vendor_code.hashCode());
		result = prime * result + ((vendor_name == null) ? 0 : vendor_name.hashCode());
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
		Vendor other = (Vendor) obj;
		if (pan_number == null) {
			if (other.pan_number != null)
				return false;
		} else if (!pan_number.equals(other.pan_number))
			return false;
		if (vendor_GSTN == null) {
			if (other.vendor_GSTN != null)
				return false;
		} else if (!vendor_GSTN.equals(other.vendor_GSTN))
			return false;
		if (vendor_code == null) {
			if (other.vendor_code != null)
				return false;
		} else if (!vendor_code.equals(other.vendor_code))
			return false;
		if (vendor_name == null) {
			if (other.vendor_name != null)
				return false;
		} else if (!vendor_name.equals(other.vendor_name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vendor [vendor_code=" + vendor_code + ", vendor_name=" + vendor_name + ", vendor_GSTN=" + vendor_GSTN
				+ ", pan_number=" + pan_number + "]";
	}
	
}
