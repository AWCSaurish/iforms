package com.newgen.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
@Component
@Scope("prototype")
@Data
public class Table6 {
	@SerializedName("CGST Amount")
	private String CGSTAmount;
	@SerializedName("SGST Rate")
	private String SGSTRate;
	private String Description;
	private String Quantity;
	@SerializedName("TCS Rate")
	private String TCSRate;
	@SerializedName("PO Number")
	private String PONumber;
	@SerializedName("Basic Value")
	private String BasicValue;
	@SerializedName("Line Item Total Amount")
	private String LineItemTotalAmount;
	private String UOM;
	@SerializedName("HSN Code")
	private String HSNCode;
	@SerializedName("Taxable Value")
	private String TaxableValue;
	@SerializedName("IGST Amount")
	private String IGSTAmount;
	@SerializedName("Chasis No")
	private String ChasisNo;
	@SerializedName("CGST Rate")
	private String CGSTRate;
	@SerializedName("Part No")
	private String PartNo;
	@SerializedName("Machine	Serial No")
	private String MachineSerialNo;
	@SerializedName("Other Charges")
	private String OtherCharges;
	@SerializedName("IGST Rate")
	private String IGSTRate;
	@SerializedName("Unit Price")
	private String UnitPrice;
	@SerializedName("SGST Amount")
	private String SGSTAmount;
	@SerializedName("TCS Amount")
	private String TCSAmount;
	

}
