package com.founder.rhip.ehr.dto;

public class PatientQueryForm {
    private String name;
    private String certType;
    private String certNo;
    private String healthCardNo;
    private Integer orgIdPatient;//患者所属社区
    private Integer orgIdUser;//当前用户所属机构

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public Integer getOrgIdPatient() {
        return orgIdPatient;
    }

    public void setOrgIdPatient(Integer orgIdPatient) {
        this.orgIdPatient = orgIdPatient;
    }

    public Integer getOrgIdUser() {
        return orgIdUser;
    }

    public void setOrgIdUser(Integer orgIdUser) {
        this.orgIdUser = orgIdUser;
    }

    public String getHealthCardNo() {
        return healthCardNo;
    }

    public void setHealthCardNo(String healthCardNo) {
        this.healthCardNo = healthCardNo;
    }
}
