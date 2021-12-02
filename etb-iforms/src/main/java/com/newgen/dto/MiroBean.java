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
public class MiroBean {

    private String sapDocNo;
    private String postingDate;
    private String fiscalYear;
    private String totalAmount;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSapDocNo() {
        return sapDocNo;
    }

    public void setSapDocNo(String sapDocNo) {
        this.sapDocNo = sapDocNo;
    }

    public String getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(String postingDate) {
        this.postingDate = postingDate;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.sapDocNo);
        hash = 53 * hash + Objects.hashCode(this.postingDate);
        hash = 53 * hash + Objects.hashCode(this.fiscalYear);
        hash = 53 * hash + Objects.hashCode(this.totalAmount);
        hash = 53 * hash + Objects.hashCode(this.message);
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
        final MiroBean other = (MiroBean) obj;
        if (!Objects.equals(this.sapDocNo, other.sapDocNo)) {
            return false;
        }
        if (!Objects.equals(this.postingDate, other.postingDate)) {
            return false;
        }
        if (!Objects.equals(this.fiscalYear, other.fiscalYear)) {
            return false;
        }
        if (!Objects.equals(this.totalAmount, other.totalAmount)) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiroBean{" + "sapDocNo=" + sapDocNo + ", postingDate=" + postingDate + ", fiscalYear=" + fiscalYear + ", totalAmount=" + totalAmount + ", message=" + message + '}';
    }

}
