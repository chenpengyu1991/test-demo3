package com.founder.rhip.ehr.dto;

import java.io.Serializable;

/**
 * Created by yuanzg on 2018/1/8.
 */
public class HealthSuperviseForm implements Serializable{
    private static final long serialVersionUID = -1398047229946590341L;
    private String year;
    private String quarter;
    private String orgCode;
    private String centerOrgCode;
    private String gbcode;
    private String currentOrgCode;
    private String currentGBCode;
    private String countType;

    public String getCountType() {
        return countType;
    }

    public void setCountType(String countType) {
        this.countType = countType;
    }

    public String getCurrentGBCode() {
        return currentGBCode;
    }

    public void setCurrentGBCode(String currentGBCode) {
        this.currentGBCode = currentGBCode;
    }

    public String getCurrentOrgCode() {
        return currentOrgCode;
    }

    public void setCurrentOrgCode(String currentOrgCode) {
        this.currentOrgCode = currentOrgCode;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getCenterOrgCode() {
        return centerOrgCode;
    }

    public void setCenterOrgCode(String centerOrgCode) {
        this.centerOrgCode = centerOrgCode;
    }

    public String getGbcode() {
        return gbcode;
    }

    public void setGbcode(String gbcode) {
        this.gbcode = gbcode;
    }
}
