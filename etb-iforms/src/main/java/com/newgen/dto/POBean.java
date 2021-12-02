/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newgen.dto;

import java.util.Objects;

/**
 *
 * @author Saurish
 */
public class POBean {

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

    public POBean() {
    }

    public POBean(String PoNumber, String DocDate, String PoType, String Vendor, String ConditionDoc, String ConditionDocItem, String ConditionType, String Description, String Percentage, String ConditionValue, String CalculationType, String Currency, String ExchangeRate, String Message) {
        this.PoNumber = PoNumber;
        this.DocDate = DocDate;
        this.PoType = PoType;
        this.Vendor = Vendor;
        this.ConditionDoc = ConditionDoc;
        this.ConditionDocItem = ConditionDocItem;
        this.ConditionType = ConditionType;
        this.Description = Description;
        this.Percentage = Percentage;
        this.ConditionValue = ConditionValue;
        this.CalculationType = CalculationType;
        this.Currency = Currency;
        this.ExchangeRate = ExchangeRate;
        this.Message = Message;
    }

    public String getPoNumber() {
        return PoNumber;
    }

    public void setPoNumber(String PoNumber) {
        this.PoNumber = PoNumber;
    }

    public String getDocDate() {
        return DocDate;
    }

    public void setDocDate(String DocDate) {
        this.DocDate = DocDate;
    }

    public String getPoType() {
        return PoType;
    }

    public void setPoType(String PoType) {
        this.PoType = PoType;
    }

    public String getVendor() {
        return Vendor;
    }

    public void setVendor(String Vendor) {
        this.Vendor = Vendor;
    }

    public String getConditionDoc() {
        return ConditionDoc;
    }

    public void setConditionDoc(String ConditionDoc) {
        this.ConditionDoc = ConditionDoc;
    }

    public String getConditionDocItem() {
        return ConditionDocItem;
    }

    public void setConditionDocItem(String ConditionDocItem) {
        this.ConditionDocItem = ConditionDocItem;
    }

    public String getConditionType() {
        return ConditionType;
    }

    public void setConditionType(String ConditionType) {
        this.ConditionType = ConditionType;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getPercentage() {
        return Percentage;
    }

    public void setPercentage(String Percentage) {
        this.Percentage = Percentage;
    }

    public String getConditionValue() {
        return ConditionValue;
    }

    public void setConditionValue(String ConditionValue) {
        this.ConditionValue = ConditionValue;
    }

    public String getCalculationType() {
        return CalculationType;
    }

    public void setCalculationType(String CalculationType) {
        this.CalculationType = CalculationType;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String Currency) {
        this.Currency = Currency;
    }

    public String getExchangeRate() {
        return ExchangeRate;
    }

    public void setExchangeRate(String ExchangeRate) {
        this.ExchangeRate = ExchangeRate;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.PoNumber);
        hash = 97 * hash + Objects.hashCode(this.DocDate);
        hash = 97 * hash + Objects.hashCode(this.PoType);
        hash = 97 * hash + Objects.hashCode(this.Vendor);
        hash = 97 * hash + Objects.hashCode(this.ConditionDoc);
        hash = 97 * hash + Objects.hashCode(this.ConditionDocItem);
        hash = 97 * hash + Objects.hashCode(this.ConditionType);
        hash = 97 * hash + Objects.hashCode(this.Description);
        hash = 97 * hash + Objects.hashCode(this.Percentage);
        hash = 97 * hash + Objects.hashCode(this.ConditionValue);
        hash = 97 * hash + Objects.hashCode(this.CalculationType);
        hash = 97 * hash + Objects.hashCode(this.Currency);
        hash = 97 * hash + Objects.hashCode(this.ExchangeRate);
        hash = 97 * hash + Objects.hashCode(this.Message);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final POBean other = (POBean) obj;
        if (!Objects.equals(this.PoNumber, other.PoNumber)) {
            return false;
        }
        if (!Objects.equals(this.DocDate, other.DocDate)) {
            return false;
        }
        if (!Objects.equals(this.PoType, other.PoType)) {
            return false;
        }
        if (!Objects.equals(this.Vendor, other.Vendor)) {
            return false;
        }
        if (!Objects.equals(this.ConditionDoc, other.ConditionDoc)) {
            return false;
        }
        if (!Objects.equals(this.ConditionDocItem, other.ConditionDocItem)) {
            return false;
        }
        if (!Objects.equals(this.ConditionType, other.ConditionType)) {
            return false;
        }
        if (!Objects.equals(this.Description, other.Description)) {
            return false;
        }
        if (!Objects.equals(this.Percentage, other.Percentage)) {
            return false;
        }
        if (!Objects.equals(this.ConditionValue, other.ConditionValue)) {
            return false;
        }
        if (!Objects.equals(this.CalculationType, other.CalculationType)) {
            return false;
        }
        if (!Objects.equals(this.Currency, other.Currency)) {
            return false;
        }
        if (!Objects.equals(this.ExchangeRate, other.ExchangeRate)) {
            return false;
        }
        if (!Objects.equals(this.Message, other.Message)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "POBean{" + "PoNumber=" + PoNumber + ", DocDate=" + DocDate + ", PoType=" + PoType + ", Vendor=" + Vendor + ", ConditionDoc=" + ConditionDoc + ", ConditionDocItem=" + ConditionDocItem + ", ConditionType=" + ConditionType + ", Description=" + Description + ", Percentage=" + Percentage + ", ConditionValue=" + ConditionValue + ", CalculationType=" + CalculationType + ", Currency=" + Currency + ", ExchangeRate=" + ExchangeRate + ", Message=" + Message + '}';
    }

}
