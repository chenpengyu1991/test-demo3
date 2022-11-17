package com.founder.rhip.ncp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "NCP_PATIENT")
public class FollowDto implements Serializable {

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|主键|, length = 0, nullable =false")
    private BigDecimal id;
    @Column(name = "CARDNO", columnDefinition = "VARCHAR2|证件号|, length = 18, nullable = false")
    private String cardno;
    @Column(name = "CARD_TYPE", columnDefinition = "VARCHAR2|证件类型编码0：身份证|, length = 2, nullable = false")
    private String cardType;
    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名|, length = 30, nullable = false")
    private String name;
    @Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期|, length = 0, nullable = false")
    private Date birthday;
    @Column(name = "SEX", columnDefinition = "VARCHAR2|性别编码|, length = 2, nullable = false")
    private String sex;

    @Column(name = "TEL", columnDefinition = "VARCHAR2|电话|, length = 11, nullable = false")
    private String tel;

    @Column(name = "CLINICAL_CLASS", columnDefinition = "VARCHAR2|临床分型|, length = 2, nullable = true")
    private String clinicalClass;

    @Column(name = "MANAGEMENT_ORG", columnDefinition = "VARCHAR2|管理机构编号|, length = 10, nullable = false")
    private String managementOrg;

    @Column(name = "DISCHARGE_DATE", columnDefinition = "DATE|出院时间|, length = 0, nullable = true")
    private Date dischargeDate;

    @Column(name = "HEALTH_STATUS", columnDefinition = "NUMBER|健康评价状态1:正常0:异常|, length = 1, nullable = false")
    private Integer healthStatus;

    @Column(name = "REEXAMINE_STATUS", columnDefinition = "NUMBER|复查状态1:已复查0:未复查|, length = 1, nullable = false")
    private Integer reexamineStatus;

    @Column(name = "PATIENT_TYPE", columnDefinition = "VARCHAR2|疑似/确诊 编码||", length = 2, nullable = true)
    private String patientType;

    @Column(name = "ZL_TYPE", columnDefinition = "VARCHAR2|治疗类型1:县内治疗2：县外治疗||", length = 2, nullable = true)
    private String zlType;

    private Integer personId;

    private String populationCategory;//人群分类


    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public String getZlType() {
        return zlType;
    }

    public void setZlType(String zlType) {
        this.zlType = zlType;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getClinicalClass() {
        return clinicalClass;
    }

    public void setClinicalClass(String clinicalClass) {
        this.clinicalClass = clinicalClass;
    }

    public String getManagementOrg() {
        return managementOrg;
    }

    public void setManagementOrg(String managementOrg) {
        this.managementOrg = managementOrg;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public Integer getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(Integer healthStatus) {
        this.healthStatus = healthStatus;
    }

    public Integer getReexamineStatus() {
        return reexamineStatus;
    }

    public void setReexamineStatus(Integer reexamineStatus) {
        this.reexamineStatus = reexamineStatus;
    }

    public String getPopulationCategory() {
        return populationCategory;
    }

    public void setPopulationCategory(String populationCategory) {
        this.populationCategory = populationCategory;
    }
}
