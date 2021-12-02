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
public class ITGLSetBean {

    private String RefDocNo;
    private String GlAccount;
    private String ItemAmount;
    private String DbCrInd;
    private String TaxCode;
    private String Costcenter;
    private String ProfitCtr;
    private String Plant;

    public String getRefDocNo() {
        return RefDocNo;
    }

    public void setRefDocNo(String RefDocNo) {
        this.RefDocNo = RefDocNo;
    }

    public String getGlAccount() {
        return GlAccount;
    }

    public void setGlAccount(String GlAccount) {
        this.GlAccount = GlAccount;
    }

    public String getItemAmount() {
        return ItemAmount;
    }

    public void setItemAmount(String ItemAmount) {
        this.ItemAmount = ItemAmount;
    }

    public String getDbCrInd() {
        return DbCrInd;
    }

    public void setDbCrInd(String DbCrInd) {
        this.DbCrInd = DbCrInd;
    }

    public String getTaxCode() {
        return TaxCode;
    }

    public void setTaxCode(String TaxCode) {
        this.TaxCode = TaxCode;
    }

    public String getCostcenter() {
        return Costcenter;
    }

    public void setCostcenter(String Costcenter) {
        this.Costcenter = Costcenter;
    }

    public String getProfitCtr() {
        return ProfitCtr;
    }

    public void setProfitCtr(String ProfitCtr) {
        this.ProfitCtr = ProfitCtr;
    }

    public String getPlant() {
        return Plant;
    }

    public void setPlant(String Plant) {
        this.Plant = Plant;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.RefDocNo);
        hash = 53 * hash + Objects.hashCode(this.GlAccount);
        hash = 53 * hash + Objects.hashCode(this.ItemAmount);
        hash = 53 * hash + Objects.hashCode(this.DbCrInd);
        hash = 53 * hash + Objects.hashCode(this.TaxCode);
        hash = 53 * hash + Objects.hashCode(this.Costcenter);
        hash = 53 * hash + Objects.hashCode(this.ProfitCtr);
        hash = 53 * hash + Objects.hashCode(this.Plant);
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
        final ITGLSetBean other = (ITGLSetBean) obj;
        if (!Objects.equals(this.RefDocNo, other.RefDocNo)) {
            return false;
        }
        if (!Objects.equals(this.GlAccount, other.GlAccount)) {
            return false;
        }
        if (!Objects.equals(this.ItemAmount, other.ItemAmount)) {
            return false;
        }
        if (!Objects.equals(this.DbCrInd, other.DbCrInd)) {
            return false;
        }
        if (!Objects.equals(this.TaxCode, other.TaxCode)) {
            return false;
        }
        if (!Objects.equals(this.Costcenter, other.Costcenter)) {
            return false;
        }
        if (!Objects.equals(this.ProfitCtr, other.ProfitCtr)) {
            return false;
        }
        if (!Objects.equals(this.Plant, other.Plant)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ITGLSetBean{" + "RefDocNo=" + RefDocNo + ", GlAccount=" + GlAccount + ", ItemAmount=" + ItemAmount + ", DbCrInd=" + DbCrInd + ", TaxCode=" + TaxCode + ", Costcenter=" + Costcenter + ", ProfitCtr=" + ProfitCtr + ", Plant=" + Plant + '}';
    }

}
