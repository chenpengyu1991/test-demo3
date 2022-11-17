package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "DM_DEFORMITY_PERSON_MGMT")
public class DeformityPersonMgmt implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "SMPI_ID", columnDefinition = "VARCHAR2|PIX号||", length = 50, nullable = true)
    private String smpiId;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = false)
    private String ehrId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号||", length = 17, nullable = false)
    private String healthFileNo;

    @Column(name = "GLKH", columnDefinition = "VARCHAR2|管理卡号||", length = 20, nullable = false)
    private String glkh;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|居民身份证/健康卡号||", length = 18, nullable = false)
    private String idcard;

    @Column(name = "DISABILITY_MAIN", columnDefinition = "VARCHAR2|主要残疾代码||", length = 1, nullable = true)
    private String disabilityMain;

    @Column(name = "DISABILITY_MULT", columnDefinition = "VARCHAR2|多重残疾代码组合||", length = 100, nullable = true)
    private String disabilityMult;

    @Column(name = "DISABILITY_OTHER", columnDefinition = "VARCHAR2|其他伤残说明||", length = 100, nullable = true)
    private String disabilityOther;

    @Column(name = "DISABILITY_LEVEL", columnDefinition = "VARCHAR2|伤残等级代码||", length = 1, nullable = true)
    private String disabilityLevel;

    @Column(name = "DISABILITY_REASON", columnDefinition = "VARCHAR2|主要致残原因代码||", length = 2, nullable = true)
    private String disabilityReason;

    @Column(name = "DISABILITY_DATE", columnDefinition = "DATE|致残日期||", nullable = true)
    private Date disabilityDate;

    @Column(name = "TEL_NUMBER", columnDefinition = "VARCHAR2|联系电话-号码||", length = 20, nullable = true)
    private String telNumber;

    @Column(name = "DISABILITY_CER", columnDefinition = "VARCHAR2|有无残疾证||", length = 1, nullable = true)
    private String disabilityCer;

    @Column(name = "CER_NUMBER", columnDefinition = "VARCHAR2|残疾证号||", length = 20, nullable = true)
    private String cerNumber;

    @Column(name = "IS_RECOVERY", columnDefinition = "VARCHAR2|康复治疗标志||", length = 1, nullable = true)
    private String isRecovery;

    @Column(name = "RECOVERY_PHONE", columnDefinition = "VARCHAR2|康复机构电话||", length = 20, nullable = true)
    private String recoveryPhone;

    @Column(name = "RECOVERY_ORG", columnDefinition = "VARCHAR2|康复机构名称||", length = 70, nullable = true)
    private String recoveryOrg;

    @Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|更新机构编码||", length = 15, nullable = true)
    private String updateOrgancode;

    @Column(name = "UPDATE_ORGAN_NAME", columnDefinition = "VARCHAR2|更新机构名称||", length = 70, nullable = true)
    private String updateOrganname;

    @Column(name = "UPDATE_IDCARD", columnDefinition = "VARCHAR2|更新人身份证号||", length = 18, nullable = true)
    private String updateIdcard;

    @Column(name = "UPDATE_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 50, nullable = true)
    private String updateName;

    @Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP|更新日期和时间||", nullable = true)
    private Date updateDate;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getHealthFileNo() {
        return this.healthFileNo;
    }

    public void setHealthFileNo(String healthFileNo) {
        this.healthFileNo = healthFileNo;
    }

    public String getGlkh() {
        return this.glkh;
    }

    public void setGlkh(String glkh) {
        this.glkh = glkh;
    }

    public String getIdcard() {
        return this.idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getDisabilityMain() {
        return this.disabilityMain;
    }

    public void setDisabilityMain(String disabilityMain) {
        this.disabilityMain = disabilityMain;
    }

    public String getDisabilityMult() {
        return this.disabilityMult;
    }

    public void setDisabilityMult(String disabilityMult) {
        this.disabilityMult = disabilityMult;
    }

    public String getDisabilityOther() {
        return this.disabilityOther;
    }

    public void setDisabilityOther(String disabilityOther) {
        this.disabilityOther = disabilityOther;
    }

    public String getDisabilityLevel() {
        return this.disabilityLevel;
    }

    public void setDisabilityLevel(String disabilityLevel) {
        this.disabilityLevel = disabilityLevel;
    }

    public String getDisabilityReason() {
        return this.disabilityReason;
    }

    public void setDisabilityReason(String disabilityReason) {
        this.disabilityReason = disabilityReason;
    }

    public Date getDisabilityDate() {
        return this.disabilityDate;
    }

    public void setDisabilityDate(Date disabilityDate) {
        this.disabilityDate = disabilityDate;
    }

    public String getTelNumber() {
        return this.telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getDisabilityCer() {
        return this.disabilityCer;
    }

    public void setDisabilityCer(String disabilityCer) {
        this.disabilityCer = disabilityCer;
    }

    public String getCerNumber() {
        return this.cerNumber;
    }

    public void setCerNumber(String cerNumber) {
        this.cerNumber = cerNumber;
    }

    public String getIsRecovery() {
        return this.isRecovery;
    }

    public void setIsRecovery(String isRecovery) {
        this.isRecovery = isRecovery;
    }

    public String getRecoveryPhone() {
        return this.recoveryPhone;
    }

    public void setRecoveryPhone(String recoveryPhone) {
        this.recoveryPhone = recoveryPhone;
    }

    public String getRecoveryOrg() {
        return this.recoveryOrg;
    }

    public void setRecoveryOrg(String recoveryOrg) {
        this.recoveryOrg = recoveryOrg;
    }

    public String getUpdateOrgancode() {
        return this.updateOrgancode;
    }

    public void setUpdateOrgancode(String updateOrgancode) {
        this.updateOrgancode = updateOrgancode;
    }

    public String getUpdateOrganname() {
        return this.updateOrganname;
    }

    public void setUpdateOrganname(String updateOrganname) {
        this.updateOrganname = updateOrganname;
    }

    public String getUpdateIdcard() {
        return this.updateIdcard;
    }

    public void setUpdateIdcard(String updateIdcard) {
        this.updateIdcard = updateIdcard;
    }

    public String getUpdateName() {
        return this.updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getEhrId() {
        return ehrId;
    }

    public void setEhrId(String ehrId) {
        this.ehrId = ehrId;
    }


    public String getSmpiId() {
        return smpiId;
    }

    public void setSmpiId(String smpiId) {
        this.smpiId = smpiId;
    }

}
