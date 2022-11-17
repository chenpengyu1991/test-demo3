package com.founder.rhip.dref.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

import java.util.Date;

public class DualReferralQueryForm {

    private String name;

    private String dualReferralType;

    private Date referralDate;

    private String destDeptCode;

    private String referralHospitalCode;

    private String referralSource;

    private String referralStatus;

    private String requestUrlType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDualReferralType() {
        return dualReferralType;
    }

    public void setDualReferralType(String dualReferralType) {
        this.dualReferralType = dualReferralType;
    }

    public Date getReferralDate() {
        return referralDate;
    }

    public void setReferralDate(Date referralDate) {
        this.referralDate = referralDate;
    }

    public String getDestDeptCode() {
        return destDeptCode;
    }

    public void setDestDeptCode(String destDeptCode) {
        this.destDeptCode = destDeptCode;
    }

    public String getReferralHospitalCode() {
        return referralHospitalCode;
    }

    public void setReferralHospitalCode(String referralHospitalCode) {
        this.referralHospitalCode = referralHospitalCode;
    }

    public String getReferralSource() {
        return referralSource;
    }

    public void setReferralSource(String referralSource) {
        this.referralSource = referralSource;
    }

    public String getReferralStatus() {
        return referralStatus;
    }

    public void setReferralStatus(String referralStatus) {
        this.referralStatus = referralStatus;
    }

    public String getRequestUrlType() {
        return requestUrlType;
    }

    public void setRequestUrlType(String requestUrlType) {
        this.requestUrlType = requestUrlType;
    }

    public Criteria toCriteria() {
        Criteria criteria = new Criteria();
        if (StringUtil.isNotEmpty(name)) {
            criteria.add("name", OP.LIKE, name);
        }
        if (StringUtil.isNotEmpty(dualReferralType)) {
            criteria.add("dualReferralType", dualReferralType);
        }
        if (ObjectUtil.isNotEmpty(referralDate)) {
            criteria.add("referralDate", referralDate);
        }
        if (StringUtil.isNotEmpty(destDeptCode)) {
            criteria.add("destDeptCode", destDeptCode);
        }
        if (StringUtil.isNotEmpty(referralHospitalCode)) {
            criteria.add("referralHospitalCode", referralHospitalCode);
        }
        if (StringUtil.isNotEmpty(referralSource)) {
            criteria.add("referralSource", referralSource);
        }
        if (StringUtil.isNotEmpty(referralStatus)) {
            criteria.add("referralStatus", referralStatus);
        }
        return criteria;
    }
}
