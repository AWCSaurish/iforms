package com.awcsoftware.dto.poheader;

import com.awcsoftware.dto.Metadata;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
	
	    private Metadata __metadata;
	    @JsonProperty("PoNumber") 
	    private String poNumber;
	    @JsonProperty("DocDate") 
	    private Object docDate;
	    @JsonProperty("PoType") 
	    private String poType;
	    @JsonProperty("Vendor") 
	    private String vendor;
	    @JsonProperty("ConditionDoc") 
	    private String conditionDoc;
	    @JsonProperty("ConditionDocItem") 
	    private String conditionDocItem;
	    @JsonProperty("ConditionType") 
	    private String conditionType;
	    @JsonProperty("Description") 
	    private String description;
	    @JsonProperty("Percentage") 
	    private String percentage;
	    @JsonProperty("ConditionValue") 
	    private String conditionValue;
	    @JsonProperty("CalculationType") 
	    private String calculationType;
	    @JsonProperty("Currency") 
	    private String currency;
	    @JsonProperty("ExchangeRate") 
	    private String exchangeRate;
	    @JsonProperty("Message") 
	    private String message;
		public Metadata get__metadata() {
			return __metadata;
		}
		public void set__metadata(Metadata __metadata) {
			this.__metadata = __metadata;
		}
		public String getPoNumber() {
			return poNumber;
		}
		public void setPoNumber(String poNumber) {
			this.poNumber = poNumber;
		}
		public Object getDocDate() {
			return docDate;
		}
		public void setDocDate(Object docDate) {
			this.docDate = docDate;
		}
		public String getPoType() {
			return poType;
		}
		public void setPoType(String poType) {
			this.poType = poType;
		}
		public String getVendor() {
			return vendor;
		}
		public void setVendor(String vendor) {
			this.vendor = vendor;
		}
		public String getConditionDoc() {
			return conditionDoc;
		}
		public void setConditionDoc(String conditionDoc) {
			this.conditionDoc = conditionDoc;
		}
		public String getConditionDocItem() {
			return conditionDocItem;
		}
		public void setConditionDocItem(String conditionDocItem) {
			this.conditionDocItem = conditionDocItem;
		}
		public String getConditionType() {
			return conditionType;
		}
		public void setConditionType(String conditionType) {
			this.conditionType = conditionType;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getPercentage() {
			return percentage;
		}
		public void setPercentage(String percentage) {
			this.percentage = percentage;
		}
		public String getConditionValue() {
			return conditionValue;
		}
		public void setConditionValue(String conditionValue) {
			this.conditionValue = conditionValue;
		}
		public String getCalculationType() {
			return calculationType;
		}
		public void setCalculationType(String calculationType) {
			this.calculationType = calculationType;
		}
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
		public String getExchangeRate() {
			return exchangeRate;
		}
		public void setExchangeRate(String exchangeRate) {
			this.exchangeRate = exchangeRate;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((__metadata == null) ? 0 : __metadata.hashCode());
			result = prime * result + ((calculationType == null) ? 0 : calculationType.hashCode());
			result = prime * result + ((conditionDoc == null) ? 0 : conditionDoc.hashCode());
			result = prime * result + ((conditionDocItem == null) ? 0 : conditionDocItem.hashCode());
			result = prime * result + ((conditionType == null) ? 0 : conditionType.hashCode());
			result = prime * result + ((conditionValue == null) ? 0 : conditionValue.hashCode());
			result = prime * result + ((currency == null) ? 0 : currency.hashCode());
			result = prime * result + ((description == null) ? 0 : description.hashCode());
			result = prime * result + ((docDate == null) ? 0 : docDate.hashCode());
			result = prime * result + ((exchangeRate == null) ? 0 : exchangeRate.hashCode());
			result = prime * result + ((message == null) ? 0 : message.hashCode());
			result = prime * result + ((percentage == null) ? 0 : percentage.hashCode());
			result = prime * result + ((poNumber == null) ? 0 : poNumber.hashCode());
			result = prime * result + ((poType == null) ? 0 : poType.hashCode());
			result = prime * result + ((vendor == null) ? 0 : vendor.hashCode());
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
			Result other = (Result) obj;
			if (__metadata == null) {
				if (other.__metadata != null)
					return false;
			} else if (!__metadata.equals(other.__metadata))
				return false;
			if (calculationType == null) {
				if (other.calculationType != null)
					return false;
			} else if (!calculationType.equals(other.calculationType))
				return false;
			if (conditionDoc == null) {
				if (other.conditionDoc != null)
					return false;
			} else if (!conditionDoc.equals(other.conditionDoc))
				return false;
			if (conditionDocItem == null) {
				if (other.conditionDocItem != null)
					return false;
			} else if (!conditionDocItem.equals(other.conditionDocItem))
				return false;
			if (conditionType == null) {
				if (other.conditionType != null)
					return false;
			} else if (!conditionType.equals(other.conditionType))
				return false;
			if (conditionValue == null) {
				if (other.conditionValue != null)
					return false;
			} else if (!conditionValue.equals(other.conditionValue))
				return false;
			if (currency == null) {
				if (other.currency != null)
					return false;
			} else if (!currency.equals(other.currency))
				return false;
			if (description == null) {
				if (other.description != null)
					return false;
			} else if (!description.equals(other.description))
				return false;
			if (docDate == null) {
				if (other.docDate != null)
					return false;
			} else if (!docDate.equals(other.docDate))
				return false;
			if (exchangeRate == null) {
				if (other.exchangeRate != null)
					return false;
			} else if (!exchangeRate.equals(other.exchangeRate))
				return false;
			if (message == null) {
				if (other.message != null)
					return false;
			} else if (!message.equals(other.message))
				return false;
			if (percentage == null) {
				if (other.percentage != null)
					return false;
			} else if (!percentage.equals(other.percentage))
				return false;
			if (poNumber == null) {
				if (other.poNumber != null)
					return false;
			} else if (!poNumber.equals(other.poNumber))
				return false;
			if (poType == null) {
				if (other.poType != null)
					return false;
			} else if (!poType.equals(other.poType))
				return false;
			if (vendor == null) {
				if (other.vendor != null)
					return false;
			} else if (!vendor.equals(other.vendor))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Result [__metadata=" + __metadata + ", poNumber=" + poNumber + ", docDate=" + docDate + ", poType="
					+ poType + ", vendor=" + vendor + ", conditionDoc=" + conditionDoc + ", conditionDocItem="
					+ conditionDocItem + ", conditionType=" + conditionType + ", description=" + description
					+ ", percentage=" + percentage + ", conditionValue=" + conditionValue + ", calculationType="
					+ calculationType + ", currency=" + currency + ", exchangeRate=" + exchangeRate + ", message="
					+ message + "]";
		}
	    
}
