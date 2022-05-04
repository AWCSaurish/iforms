package com.awcsoftware.dao;

import java.util.List;

import com.awcsoftware.dto.mdm.GmmcoGstin;
import com.awcsoftware.dto.mdm.MdmEmployeeMaster;
import com.awcsoftware.dto.vendor.Vendor;

public interface IGmmcoMdmDao {
	public List<MdmEmployeeMaster> getListOfEmployees();
	public MdmEmployeeMaster getEmployee(String empCode);
	public List<Vendor> getVendor(String gstin);
	public Integer getInvoice(String invoicenumber,String invoicetotalamount,String vendorcode,String processid);
	//public List<String> getBusinessPlace(String code);
	public String getBusinessPlace(String code);
	public List<String> getCurrency();
	public GmmcoGstin getGmmcoGstin(String plantCode);
	public String getWithholdingTaxCodeType(String withholding_tax_code);
	public String getSectionCode(String withholding_tax_code);
	public List<String> getTaxCode(String taxCategory);
}
