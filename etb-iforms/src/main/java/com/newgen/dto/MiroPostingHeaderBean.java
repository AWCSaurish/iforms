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
public class MiroPostingHeaderBean {

    private String InvoiceInd;
    private String DocType;
    private String DocDate;
    private String PstngDate;
    private String RefDocNo;
    private String CompCode;
    private String DiffInv;
    private String Currency;
    private String GrossAmount;
    private String CalcTaxInd;
    private String Pmnttrms;
    private String BlineDate;
    private String HeaderTxt;
    private String PymtMeth;
    private String AllocNmbr;
    private String ItemText;
    private String BusinessPlace;
    private String Irn;
    private String SectionCode;
    private String InterRefNo;
    private String BoeNo;
    private String BoeDate;
    private String BolNo;
    private String BolDate;
    private String InvType;
    private String DocketNo;
    private String DocketDate;

    public String getInvoiceInd() {
        return InvoiceInd;
    }

    public void setInvoiceInd(String InvoiceInd) {
        this.InvoiceInd = InvoiceInd;
    }

    public String getDocType() {
        return DocType;
    }

    public void setDocType(String DocType) {
        this.DocType = DocType;
    }

    public String getDocDate() {
        return DocDate;
    }

    public void setDocDate(String DocDate) {
        this.DocDate = DocDate;
    }

    public String getPstngDate() {
        return PstngDate;
    }

    public void setPstngDate(String PstngDate) {
        this.PstngDate = PstngDate;
    }

    public String getRefDocNo() {
        return RefDocNo;
    }

    public void setRefDocNo(String RefDocNo) {
        this.RefDocNo = RefDocNo;
    }

    public String getCompCode() {
        return CompCode;
    }

    public void setCompCode(String CompCode) {
        this.CompCode = CompCode;
    }

    public String getDiffInv() {
        return DiffInv;
    }

    public void setDiffInv(String DiffInv) {
        this.DiffInv = DiffInv;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String Currency) {
        this.Currency = Currency;
    }

    public String getGrossAmount() {
        return GrossAmount;
    }

    public void setGrossAmount(String GrossAmount) {
        this.GrossAmount = GrossAmount;
    }

    public String getCalcTaxInd() {
        return CalcTaxInd;
    }

    public void setCalcTaxInd(String CalcTaxInd) {
        this.CalcTaxInd = CalcTaxInd;
    }

    public String getPmnttrms() {
        return Pmnttrms;
    }

    public void setPmnttrms(String Pmnttrms) {
        this.Pmnttrms = Pmnttrms;
    }

    public String getBlineDate() {
        return BlineDate;
    }

    public void setBlineDate(String BlineDate) {
        this.BlineDate = BlineDate;
    }

    public String getHeaderTxt() {
        return HeaderTxt;
    }

    public void setHeaderTxt(String HeaderTxt) {
        this.HeaderTxt = HeaderTxt;
    }

    public String getPymtMeth() {
        return PymtMeth;
    }

    public void setPymtMeth(String PymtMeth) {
        this.PymtMeth = PymtMeth;
    }

    public String getAllocNmbr() {
        return AllocNmbr;
    }

    public void setAllocNmbr(String AllocNmbr) {
        this.AllocNmbr = AllocNmbr;
    }

    public String getItemText() {
        return ItemText;
    }

    public void setItemText(String ItemText) {
        this.ItemText = ItemText;
    }

    public String getBusinessPlace() {
        return BusinessPlace;
    }

    public void setBusinessPlace(String BusinessPlace) {
        this.BusinessPlace = BusinessPlace;
    }

    public String getIrn() {
        return Irn;
    }

    public void setIrn(String Irn) {
        this.Irn = Irn;
    }

    public String getSectionCode() {
        return SectionCode;
    }

    public void setSectionCode(String SectionCode) {
        this.SectionCode = SectionCode;
    }

    public String getInterRefNo() {
        return InterRefNo;
    }

    public void setInterRefNo(String InterRefNo) {
        this.InterRefNo = InterRefNo;
    }

    public String getBoeNo() {
        return BoeNo;
    }

    public void setBoeNo(String BoeNo) {
        this.BoeNo = BoeNo;
    }

    public String getBoeDate() {
        return BoeDate;
    }

    public void setBoeDate(String BoeDate) {
        this.BoeDate = BoeDate;
    }

    public String getBolNo() {
        return BolNo;
    }

    public void setBolNo(String BolNo) {
        this.BolNo = BolNo;
    }

    public String getBolDate() {
        return BolDate;
    }

    public void setBolDate(String BolDate) {
        this.BolDate = BolDate;
    }

    public String getInvType() {
        return InvType;
    }

    public void setInvType(String InvType) {
        this.InvType = InvType;
    }

    public String getDocketNo() {
        return DocketNo;
    }

    public void setDocketNo(String DocketNo) {
        this.DocketNo = DocketNo;
    }

    public String getDocketDate() {
        return DocketDate;
    }

    public void setDocketDate(String DocketDate) {
        this.DocketDate = DocketDate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.InvoiceInd);
        hash = 71 * hash + Objects.hashCode(this.DocType);
        hash = 71 * hash + Objects.hashCode(this.DocDate);
        hash = 71 * hash + Objects.hashCode(this.PstngDate);
        hash = 71 * hash + Objects.hashCode(this.RefDocNo);
        hash = 71 * hash + Objects.hashCode(this.CompCode);
        hash = 71 * hash + Objects.hashCode(this.DiffInv);
        hash = 71 * hash + Objects.hashCode(this.Currency);
        hash = 71 * hash + Objects.hashCode(this.GrossAmount);
        hash = 71 * hash + Objects.hashCode(this.CalcTaxInd);
        hash = 71 * hash + Objects.hashCode(this.Pmnttrms);
        hash = 71 * hash + Objects.hashCode(this.BlineDate);
        hash = 71 * hash + Objects.hashCode(this.HeaderTxt);
        hash = 71 * hash + Objects.hashCode(this.PymtMeth);
        hash = 71 * hash + Objects.hashCode(this.AllocNmbr);
        hash = 71 * hash + Objects.hashCode(this.ItemText);
        hash = 71 * hash + Objects.hashCode(this.BusinessPlace);
        hash = 71 * hash + Objects.hashCode(this.Irn);
        hash = 71 * hash + Objects.hashCode(this.SectionCode);
        hash = 71 * hash + Objects.hashCode(this.InterRefNo);
        hash = 71 * hash + Objects.hashCode(this.BoeNo);
        hash = 71 * hash + Objects.hashCode(this.BoeDate);
        hash = 71 * hash + Objects.hashCode(this.BolNo);
        hash = 71 * hash + Objects.hashCode(this.BolDate);
        hash = 71 * hash + Objects.hashCode(this.InvType);
        hash = 71 * hash + Objects.hashCode(this.DocketNo);
        hash = 71 * hash + Objects.hashCode(this.DocketDate);
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
        final MiroPostingHeaderBean other = (MiroPostingHeaderBean) obj;
        if (!Objects.equals(this.InvoiceInd, other.InvoiceInd)) {
            return false;
        }
        if (!Objects.equals(this.DocType, other.DocType)) {
            return false;
        }
        if (!Objects.equals(this.DocDate, other.DocDate)) {
            return false;
        }
        if (!Objects.equals(this.PstngDate, other.PstngDate)) {
            return false;
        }
        if (!Objects.equals(this.RefDocNo, other.RefDocNo)) {
            return false;
        }
        if (!Objects.equals(this.CompCode, other.CompCode)) {
            return false;
        }
        if (!Objects.equals(this.DiffInv, other.DiffInv)) {
            return false;
        }
        if (!Objects.equals(this.Currency, other.Currency)) {
            return false;
        }
        if (!Objects.equals(this.GrossAmount, other.GrossAmount)) {
            return false;
        }
        if (!Objects.equals(this.CalcTaxInd, other.CalcTaxInd)) {
            return false;
        }
        if (!Objects.equals(this.Pmnttrms, other.Pmnttrms)) {
            return false;
        }
        if (!Objects.equals(this.BlineDate, other.BlineDate)) {
            return false;
        }
        if (!Objects.equals(this.HeaderTxt, other.HeaderTxt)) {
            return false;
        }
        if (!Objects.equals(this.PymtMeth, other.PymtMeth)) {
            return false;
        }
        if (!Objects.equals(this.AllocNmbr, other.AllocNmbr)) {
            return false;
        }
        if (!Objects.equals(this.ItemText, other.ItemText)) {
            return false;
        }
        if (!Objects.equals(this.BusinessPlace, other.BusinessPlace)) {
            return false;
        }
        if (!Objects.equals(this.Irn, other.Irn)) {
            return false;
        }
        if (!Objects.equals(this.SectionCode, other.SectionCode)) {
            return false;
        }
        if (!Objects.equals(this.InterRefNo, other.InterRefNo)) {
            return false;
        }
        if (!Objects.equals(this.BoeNo, other.BoeNo)) {
            return false;
        }
        if (!Objects.equals(this.BoeDate, other.BoeDate)) {
            return false;
        }
        if (!Objects.equals(this.BolNo, other.BolNo)) {
            return false;
        }
        if (!Objects.equals(this.BolDate, other.BolDate)) {
            return false;
        }
        if (!Objects.equals(this.InvType, other.InvType)) {
            return false;
        }
        if (!Objects.equals(this.DocketNo, other.DocketNo)) {
            return false;
        }
        if (!Objects.equals(this.DocketDate, other.DocketDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiroPostingHeaderBean{" + "InvoiceInd=" + InvoiceInd + ", DocType=" + DocType + ", DocDate=" + DocDate + ", PstngDate=" + PstngDate + ", RefDocNo=" + RefDocNo + ", CompCode=" + CompCode + ", DiffInv=" + DiffInv + ", Currency=" + Currency + ", GrossAmount=" + GrossAmount + ", CalcTaxInd=" + CalcTaxInd + ", Pmnttrms=" + Pmnttrms + ", BlineDate=" + BlineDate + ", HeaderTxt=" + HeaderTxt + ", PymtMeth=" + PymtMeth + ", AllocNmbr=" + AllocNmbr + ", ItemText=" + ItemText + ", BusinessPlace=" + BusinessPlace + ", Irn=" + Irn + ", SectionCode=" + SectionCode + ", InterRefNo=" + InterRefNo + ", BoeNo=" + BoeNo + ", BoeDate=" + BoeDate + ", BolNo=" + BolNo + ", BolDate=" + BolDate + ", InvType=" + InvType + ", DocketNo=" + DocketNo + ", DocketDate=" + DocketDate + '}';
    }

}
