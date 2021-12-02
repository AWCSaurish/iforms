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
public class POHistoryBean {

    private String PoNumber = null;
    private String PoItem = null;
    private String DeliveryNumber = null;
    private String DeliveryItem = null;
    private String RefDocNo = null;
    private String MatDocNo = null;
    private String MatDocItem = null;
    private String DocDate = null;
    private String PostDate = null;
    private String Plant = null;
    private String Material = null;
    private String StorageLoc = null;
    private String Batch = null;
    private String SerialNo = null;
    private String ProfitCenter = null;
    private String Quantity = null;
    private String Uom = null;
    private String MovType = null;
    private String Incoterms = null;
    private String AmountDoccurr = null;
    private String Currency = null;
    private String AmountLoccurr = null;
    private String DelvAmtDoccurr = null;
    private String DelvCurrency = null;
    private String DelvAmtLoccurr = null;
    private String DcIndicator = null;
    private String FiscalYear = null;
    private String Vendor = null;
    private String Name = null;
    private String TaxNumber = null;
    private String Message = null;

    public String getPoNumber() {
        return PoNumber;
    }

    public void setPoNumber(String PoNumber) {
        this.PoNumber = PoNumber;
    }

    public String getPoItem() {
        return PoItem;
    }

    public void setPoItem(String PoItem) {
        this.PoItem = PoItem;
    }

    public String getDeliveryNumber() {
        return DeliveryNumber;
    }

    public void setDeliveryNumber(String DeliveryNumber) {
        this.DeliveryNumber = DeliveryNumber;
    }

    public String getDeliveryItem() {
        return DeliveryItem;
    }

    public void setDeliveryItem(String DeliveryItem) {
        this.DeliveryItem = DeliveryItem;
    }

    public String getRefDocNo() {
        return RefDocNo;
    }

    public void setRefDocNo(String RefDocNo) {
        this.RefDocNo = RefDocNo;
    }

    public String getMatDocNo() {
        return MatDocNo;
    }

    public void setMatDocNo(String MatDocNo) {
        this.MatDocNo = MatDocNo;
    }

    public String getMatDocItem() {
        return MatDocItem;
    }

    public void setMatDocItem(String MatDocItem) {
        this.MatDocItem = MatDocItem;
    }

    public String getDocDate() {
        return DocDate;
    }

    public void setDocDate(String DocDate) {
        this.DocDate = DocDate;
    }

    public String getPostDate() {
        return PostDate;
    }

    public void setPostDate(String PostDate) {
        this.PostDate = PostDate;
    }

    public String getPlant() {
        return Plant;
    }

    public void setPlant(String Plant) {
        this.Plant = Plant;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String Material) {
        this.Material = Material;
    }

    public String getStorageLoc() {
        return StorageLoc;
    }

    public void setStorageLoc(String StorageLoc) {
        this.StorageLoc = StorageLoc;
    }

    public String getBatch() {
        return Batch;
    }

    public void setBatch(String Batch) {
        this.Batch = Batch;
    }

    public String getSerialNo() {
        return SerialNo;
    }

    public void setSerialNo(String SerialNo) {
        this.SerialNo = SerialNo;
    }

    public String getProfitCenter() {
        return ProfitCenter;
    }

    public void setProfitCenter(String ProfitCenter) {
        this.ProfitCenter = ProfitCenter;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }

    public String getUom() {
        return Uom;
    }

    public void setUom(String Uom) {
        this.Uom = Uom;
    }

    public String getMovType() {
        return MovType;
    }

    public void setMovType(String MovType) {
        this.MovType = MovType;
    }

    public String getIncoterms() {
        return Incoterms;
    }

    public void setIncoterms(String Incoterms) {
        this.Incoterms = Incoterms;
    }

    public String getAmountDoccurr() {
        return AmountDoccurr;
    }

    public void setAmountDoccurr(String AmountDoccurr) {
        this.AmountDoccurr = AmountDoccurr;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String Currency) {
        this.Currency = Currency;
    }

    public String getAmountLoccurr() {
        return AmountLoccurr;
    }

    public void setAmountLoccurr(String AmountLoccurr) {
        this.AmountLoccurr = AmountLoccurr;
    }

    public String getDelvAmtDoccurr() {
        return DelvAmtDoccurr;
    }

    public void setDelvAmtDoccurr(String DelvAmtDoccurr) {
        this.DelvAmtDoccurr = DelvAmtDoccurr;
    }

    public String getDelvCurrency() {
        return DelvCurrency;
    }

    public void setDelvCurrency(String DelvCurrency) {
        this.DelvCurrency = DelvCurrency;
    }

    public String getDelvAmtLoccurr() {
        return DelvAmtLoccurr;
    }

    public void setDelvAmtLoccurr(String DelvAmtLoccurr) {
        this.DelvAmtLoccurr = DelvAmtLoccurr;
    }

    public String getDcIndicator() {
        return DcIndicator;
    }

    public void setDcIndicator(String DcIndicator) {
        this.DcIndicator = DcIndicator;
    }

    public String getFiscalYear() {
        return FiscalYear;
    }

    public void setFiscalYear(String FiscalYear) {
        this.FiscalYear = FiscalYear;
    }

    public String getVendor() {
        return Vendor;
    }

    public void setVendor(String Vendor) {
        this.Vendor = Vendor;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getTaxNumber() {
        return TaxNumber;
    }

    public void setTaxNumber(String TaxNumber) {
        this.TaxNumber = TaxNumber;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.PoNumber);
        hash = 79 * hash + Objects.hashCode(this.PoItem);
        hash = 79 * hash + Objects.hashCode(this.DeliveryNumber);
        hash = 79 * hash + Objects.hashCode(this.DeliveryItem);
        hash = 79 * hash + Objects.hashCode(this.RefDocNo);
        hash = 79 * hash + Objects.hashCode(this.MatDocNo);
        hash = 79 * hash + Objects.hashCode(this.MatDocItem);
        hash = 79 * hash + Objects.hashCode(this.DocDate);
        hash = 79 * hash + Objects.hashCode(this.PostDate);
        hash = 79 * hash + Objects.hashCode(this.Plant);
        hash = 79 * hash + Objects.hashCode(this.Material);
        hash = 79 * hash + Objects.hashCode(this.StorageLoc);
        hash = 79 * hash + Objects.hashCode(this.Batch);
        hash = 79 * hash + Objects.hashCode(this.SerialNo);
        hash = 79 * hash + Objects.hashCode(this.ProfitCenter);
        hash = 79 * hash + Objects.hashCode(this.Quantity);
        hash = 79 * hash + Objects.hashCode(this.Uom);
        hash = 79 * hash + Objects.hashCode(this.MovType);
        hash = 79 * hash + Objects.hashCode(this.Incoterms);
        hash = 79 * hash + Objects.hashCode(this.AmountDoccurr);
        hash = 79 * hash + Objects.hashCode(this.Currency);
        hash = 79 * hash + Objects.hashCode(this.AmountLoccurr);
        hash = 79 * hash + Objects.hashCode(this.DelvAmtDoccurr);
        hash = 79 * hash + Objects.hashCode(this.DelvCurrency);
        hash = 79 * hash + Objects.hashCode(this.DelvAmtLoccurr);
        hash = 79 * hash + Objects.hashCode(this.DcIndicator);
        hash = 79 * hash + Objects.hashCode(this.FiscalYear);
        hash = 79 * hash + Objects.hashCode(this.Vendor);
        hash = 79 * hash + Objects.hashCode(this.Name);
        hash = 79 * hash + Objects.hashCode(this.TaxNumber);
        hash = 79 * hash + Objects.hashCode(this.Message);
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
        final POHistoryBean other = (POHistoryBean) obj;
        if (!Objects.equals(this.PoNumber, other.PoNumber)) {
            return false;
        }
        if (!Objects.equals(this.PoItem, other.PoItem)) {
            return false;
        }
        if (!Objects.equals(this.DeliveryNumber, other.DeliveryNumber)) {
            return false;
        }
        if (!Objects.equals(this.DeliveryItem, other.DeliveryItem)) {
            return false;
        }
        if (!Objects.equals(this.RefDocNo, other.RefDocNo)) {
            return false;
        }
        if (!Objects.equals(this.MatDocNo, other.MatDocNo)) {
            return false;
        }
        if (!Objects.equals(this.MatDocItem, other.MatDocItem)) {
            return false;
        }
        if (!Objects.equals(this.DocDate, other.DocDate)) {
            return false;
        }
        if (!Objects.equals(this.PostDate, other.PostDate)) {
            return false;
        }
        if (!Objects.equals(this.Plant, other.Plant)) {
            return false;
        }
        if (!Objects.equals(this.Material, other.Material)) {
            return false;
        }
        if (!Objects.equals(this.StorageLoc, other.StorageLoc)) {
            return false;
        }
        if (!Objects.equals(this.Batch, other.Batch)) {
            return false;
        }
        if (!Objects.equals(this.SerialNo, other.SerialNo)) {
            return false;
        }
        if (!Objects.equals(this.ProfitCenter, other.ProfitCenter)) {
            return false;
        }
        if (!Objects.equals(this.Quantity, other.Quantity)) {
            return false;
        }
        if (!Objects.equals(this.Uom, other.Uom)) {
            return false;
        }
        if (!Objects.equals(this.MovType, other.MovType)) {
            return false;
        }
        if (!Objects.equals(this.Incoterms, other.Incoterms)) {
            return false;
        }
        if (!Objects.equals(this.AmountDoccurr, other.AmountDoccurr)) {
            return false;
        }
        if (!Objects.equals(this.Currency, other.Currency)) {
            return false;
        }
        if (!Objects.equals(this.AmountLoccurr, other.AmountLoccurr)) {
            return false;
        }
        if (!Objects.equals(this.DelvAmtDoccurr, other.DelvAmtDoccurr)) {
            return false;
        }
        if (!Objects.equals(this.DelvCurrency, other.DelvCurrency)) {
            return false;
        }
        if (!Objects.equals(this.DelvAmtLoccurr, other.DelvAmtLoccurr)) {
            return false;
        }
        if (!Objects.equals(this.DcIndicator, other.DcIndicator)) {
            return false;
        }
        if (!Objects.equals(this.FiscalYear, other.FiscalYear)) {
            return false;
        }
        if (!Objects.equals(this.Vendor, other.Vendor)) {
            return false;
        }
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        if (!Objects.equals(this.TaxNumber, other.TaxNumber)) {
            return false;
        }
        if (!Objects.equals(this.Message, other.Message)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "POHistoryBean{" + "PoNumber=" + PoNumber + ", PoItem=" + PoItem + ", DeliveryNumber=" + DeliveryNumber + ", DeliveryItem=" + DeliveryItem + ", RefDocNo=" + RefDocNo + ", MatDocNo=" + MatDocNo + ", MatDocItem=" + MatDocItem + ", DocDate=" + DocDate + ", PostDate=" + PostDate + ", Plant=" + Plant + ", Material=" + Material + ", StorageLoc=" + StorageLoc + ", Batch=" + Batch + ", SerialNo=" + SerialNo + ", ProfitCenter=" + ProfitCenter + ", Quantity=" + Quantity + ", Uom=" + Uom + ", MovType=" + MovType + ", Incoterms=" + Incoterms + ", AmountDoccurr=" + AmountDoccurr + ", Currency=" + Currency + ", AmountLoccurr=" + AmountLoccurr + ", DelvAmtDoccurr=" + DelvAmtDoccurr + ", DelvCurrency=" + DelvCurrency + ", DelvAmtLoccurr=" + DelvAmtLoccurr + ", DcIndicator=" + DcIndicator + ", FiscalYear=" + FiscalYear + ", Vendor=" + Vendor + ", Name=" + Name + ", TaxNumber=" + TaxNumber + ", Message=" + Message + '}';
    }

}
