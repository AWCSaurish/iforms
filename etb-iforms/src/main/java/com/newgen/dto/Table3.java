package com.newgen.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Component
@Scope("prototype")
@Data
public class Table3 {
	 @SerializedName("PO Line Item")
	 private String POLineItem;
	 @SerializedName("CGST Amount")
	 private String CGSTAmount;
	 @SerializedName("SGST Rate")
	 private String SGSTRate;
	 @SerializedName("Profit Centre")
	 private String ProfitCentre;
	 @SerializedName("Tax Code")
	 private String TaxCode;
	 private String Amount;
	 @SerializedName("PO No")
	 private String PONo;
	 @SerializedName("Taxable Amount Line Item Amount")
	 private String TaxableAmountLineItemAmount;
	 private String WBS;
	 private String Material;
	 @SerializedName("Line Item Text")
	 private String LineItemText;
	 private String UOM;
	 private String Plant;
	 @SerializedName("GL Account")
	 private String GLAccount;
	 private String Qty;
	 @SerializedName("IGST Amount")
	 private String IGSTAmount;
	 @SerializedName("CGST Rate")
	 private String CGSTRate;
	 @SerializedName("Other Charges")
	 private String OtherCharges;
	 @SerializedName("IGST Rate")
	 private String IGSTRate;
	 @SerializedName("GR Number")
	 private String GRNumber;
	 @SerializedName("SGST Amount")
	 private String SGSTAmount;

}
