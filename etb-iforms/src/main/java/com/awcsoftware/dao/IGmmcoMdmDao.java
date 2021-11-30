package com.awcsoftware.dao;

import java.util.List;

import com.awcsoftware.dto.mdm.MdmEmployeeMaster;
import com.awcsoftware.dto.vendor.Vendor;

public interface IGmmcoMdmDao {
	public List<MdmEmployeeMaster> getListOfEmployees();
	public MdmEmployeeMaster getEmployee(String empCode);
	public Vendor getVendor(String gstin);
	public Integer getInvoice(String invoicenumber,String invoicetotalamount,String vendorcode);
	public String getBusinessPlace(String code);
}
