package com.newgen.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Component
@Scope("prototype")
@Data
public class Table4 {
	 @SerializedName("Inbound Delivery")
	 private String InboundDelivery;
	 @SerializedName("Profit Centre")
	 private String ProfitCentre;
	 @SerializedName("GRN Number")
	 private String GRNNumber;
	 @SerializedName("HSN SAC")
	 private String HSNSAC;
	 @SerializedName("PO Number")
	 private String PONumber;
	 @SerializedName("Serial Number")
	 private String SerialNumber;
	 @SerializedName("IR Quantity")
	 private String IRQuantity;
	 private String Assignment;
	 private String Plant;
	 @SerializedName("Material Code")
	 private String MaterialCode;
	 private String Asset;
	 @SerializedName("Price Per Unit")
	 private String PricePerUnit;
	 @SerializedName("GRN Refence Document Number")
	 private String GRNRefenceDocumentNumber;
	 @SerializedName("Account Assignment Category")
	 private String AccountAssignmentCategory;
	 @SerializedName("PO Text")
	 private String POText;
	 @SerializedName("WBSL Amount")
	 private String WBSLAmount;
	 @SerializedName("GRN Date")
	 private String GRNDate;
	 @SerializedName("GRN- Quantity")
	 private String GRNQuantity;
	 @SerializedName("Net Value")
	 private String NetValue;
	 @SerializedName("Fiscal Year")
	 private String FiscalYear;
	 private String UOM;
	 @SerializedName("Line Item number")
	 private String LineItemnumber;
	 @SerializedName("Net Price")
	 private String NetPrice;
	 @SerializedName("Order Number")
	 private String OrderNumber;
	 @SerializedName("Mat Doc Item")
	 private String MatDocItem;


	
}
