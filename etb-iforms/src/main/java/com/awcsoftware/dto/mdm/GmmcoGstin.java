package com.awcsoftware.dto.mdm;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GmmcoGstin {
	private String SupplierGSTIN;
	private String BusinessPlace;
	public GmmcoGstin() {
		System.out.println("GmmcoGstin Created");
	}
	public String getSupplierGSTIN() {
		return SupplierGSTIN;
	}
	public void setSupplierGSTIN(String supplierGSTIN) {
		SupplierGSTIN = supplierGSTIN;
	}
	public String getBusinessPlace() {
		return BusinessPlace;
	}
	public void setBusinessPlace(String businessPlace) {
		BusinessPlace = businessPlace;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BusinessPlace == null) ? 0 : BusinessPlace.hashCode());
		result = prime * result + ((SupplierGSTIN == null) ? 0 : SupplierGSTIN.hashCode());
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
		GmmcoGstin other = (GmmcoGstin) obj;
		if (BusinessPlace == null) {
			if (other.BusinessPlace != null)
				return false;
		} else if (!BusinessPlace.equals(other.BusinessPlace))
			return false;
		if (SupplierGSTIN == null) {
			if (other.SupplierGSTIN != null)
				return false;
		} else if (!SupplierGSTIN.equals(other.SupplierGSTIN))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GmmcoGstin [SupplierGSTIN=" + SupplierGSTIN + ", BusinessPlace=" + BusinessPlace + "]";
	}
	
}
