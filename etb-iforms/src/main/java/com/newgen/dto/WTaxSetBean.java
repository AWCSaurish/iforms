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
public class WTaxSetBean {

    private String RefDocNo;
    private String WiTaxType;
    private String WiTaxCode;
    private String WiTaxBase;

    public String getRefDocNo() {
        return RefDocNo;
    }

    public void setRefDocNo(String RefDocNo) {
        this.RefDocNo = RefDocNo;
    }

    public String getWiTaxType() {
        return WiTaxType;
    }

    public void setWiTaxType(String WiTaxType) {
        this.WiTaxType = WiTaxType;
    }

    public String getWiTaxCode() {
        return WiTaxCode;
    }

    public void setWiTaxCode(String WiTaxCode) {
        this.WiTaxCode = WiTaxCode;
    }

    public String getWiTaxBase() {
        return WiTaxBase;
    }

    public void setWiTaxBase(String WiTaxBase) {
        this.WiTaxBase = WiTaxBase;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.RefDocNo);
        hash = 67 * hash + Objects.hashCode(this.WiTaxType);
        hash = 67 * hash + Objects.hashCode(this.WiTaxCode);
        hash = 67 * hash + Objects.hashCode(this.WiTaxBase);
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
        final WTaxSetBean other = (WTaxSetBean) obj;
        if (!Objects.equals(this.RefDocNo, other.RefDocNo)) {
            return false;
        }
        if (!Objects.equals(this.WiTaxType, other.WiTaxType)) {
            return false;
        }
        if (!Objects.equals(this.WiTaxCode, other.WiTaxCode)) {
            return false;
        }
        if (!Objects.equals(this.WiTaxBase, other.WiTaxBase)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WTaxSetBean{" + "RefDocNo=" + RefDocNo + ", WiTaxType=" + WiTaxType + ", WiTaxCode=" + WiTaxCode + ", WiTaxBase=" + WiTaxBase + '}';
    }

}
