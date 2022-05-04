package com.newgen.dto;

import java.util.Objects;

public class POConditionBean {
	private String PoNumber;
	private String DocDate;
	private String PoType;
	private String Vendor;
	private String ConditionDoc;
	private String ConditionDocItem;
	private String ConditionType;
	private String Description;
	private String Percentage;
	private String ConditionValue;
	private String CalculationType;
	private String Currency;
	private String ExchangeRate;
	private String Message;
	public String getPoNumber() {
		return PoNumber;
	}
	public void setPoNumber(String poNumber) {
		PoNumber = poNumber;
	}
	public String getDocDate() {
		return DocDate;
	}
	public void setDocDate(String docDate) {
		DocDate = docDate;
	}
	public String getPoType() {
		return PoType;
	}
	public void setPoType(String poType) {
		PoType = poType;
	}
	public String getVendor() {
		return Vendor;
	}
	public void setVendor(String vendor) {
		Vendor = vendor;
	}
	public String getConditionDoc() {
		return ConditionDoc;
	}
	public void setConditionDoc(String conditionDoc) {
		ConditionDoc = conditionDoc;
	}
	public String getConditionDocItem() {
		return ConditionDocItem;
	}
	public void setConditionDocItem(String conditionDocItem) {
		ConditionDocItem = conditionDocItem;
	}
	public String getConditionType() {
		return ConditionType;
	}
	public void setConditionType(String conditionType) {
		ConditionType = conditionType;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getPercentage() {
		return Percentage;
	}
	public void setPercentage(String percentage) {
		Percentage = percentage;
	}
	public String getConditionValue() {
		return ConditionValue;
	}
	public void setConditionValue(String conditionValue) {
		ConditionValue = conditionValue;
	}
	public String getCalculationType() {
		return CalculationType;
	}
	public void setCalculationType(String calculationType) {
		CalculationType = calculationType;
	}
	public String getCurrency() {
		return Currency;
	}
	public void setCurrency(String currency) {
		Currency = currency;
	}
	public String getExchangeRate() {
		return ExchangeRate;
	}
	public void setExchangeRate(String exchangeRate) {
		ExchangeRate = exchangeRate;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	@Override
	public int hashCode() {
		return Objects.hash(CalculationType, ConditionDoc, ConditionDocItem, ConditionType, ConditionValue, Currency,
				Description, DocDate, ExchangeRate, Message, Percentage, PoNumber, PoType, Vendor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		POConditionBean other = (POConditionBean) obj;
		return Objects.equals(CalculationType, other.CalculationType)
				&& Objects.equals(ConditionDoc, other.ConditionDoc)
				&& Objects.equals(ConditionDocItem, other.ConditionDocItem)
				&& Objects.equals(ConditionType, other.ConditionType)
				&& Objects.equals(ConditionValue, other.ConditionValue) && Objects.equals(Currency, other.Currency)
				&& Objects.equals(Description, other.Description) && Objects.equals(DocDate, other.DocDate)
				&& Objects.equals(ExchangeRate, other.ExchangeRate) && Objects.equals(Message, other.Message)
				&& Objects.equals(Percentage, other.Percentage) && Objects.equals(PoNumber, other.PoNumber)
				&& Objects.equals(PoType, other.PoType) && Objects.equals(Vendor, other.Vendor);
	}
	@Override
	public String toString() {
		return "POConditionBean {PoNumber=" + PoNumber + ", DocDate=" + DocDate + ", PoType=" + PoType + ", Vendor="
				+ Vendor + ", ConditionDoc=" + ConditionDoc + ", ConditionDocItem=" + ConditionDocItem
				+ ", ConditionType=" + ConditionType + ", Description=" + Description + ", Percentage=" + Percentage
				+ ", ConditionValue=" + ConditionValue + ", CalculationType=" + CalculationType + ", Currency="
				+ Currency + ", ExchangeRate=" + ExchangeRate + ", Message=" + Message + "}";
	}
	

}
