package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "DM_HYPERTENSION_CONCLUSION")
public class HypertensionConclusion implements Serializable {

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

    @Column(name = "IDCARD", columnDefinition = "NUMBER|居民身份证/健康卡号||", length = 5, nullable = false)
    private Integer idcard;

    @Column(name = "SBP", columnDefinition = "NUMBER|收缩压(mmHg)||", length = 5, nullable = true)
    private Integer sbp;

    @Column(name = "DBP", columnDefinition = "NUMBER|舒张压(mmHg)||", length = 5, nullable = true)
    private Integer dbp;

    @Column(name = "HYPERTENSION_MANAGEMENT_LEVEL", columnDefinition = "VARCHAR2|高血压管理级别||", length = 1, nullable = true)
    private String hypertensionManagementLevel;

    @Column(name = "CLASSIFICATION_OF_HEALTH", columnDefinition = "VARCHAR2|健康状况分级||", length = 1, nullable = true)
    private String classificationOfHealth;

    @Column(name = "HYPERTENSION_RISK_HIERARCHY", columnDefinition = "VARCHAR2|高血压危险分层||", length = 1, nullable = true)
    private String hypertensionRiskHierarchy;

    @Column(name = "CONCLUSIONS_OF_YEAR", columnDefinition = "NUMBER|结论年度||", length = 5, nullable = true)
    private Integer conclusionsOfYear;

    @Column(name = "ANNUAL_VISIT_TIMES", columnDefinition = "NUMBER|每年随访次数||", length = 5, nullable = true)
    private Integer annualVisitTimes;

    @Column(name = "FILL_UNIT_NAME", columnDefinition = "VARCHAR2|填报单位名称||", length = 70, nullable = true)
    private String fillUnitName;

    @Column(name = "FILL_USER_NAME", columnDefinition = "VARCHAR2|填报人姓名||", length = 50, nullable = true)
    private String fillUserName;

    @Column(name = "FILL_DATE", columnDefinition = "DATE|填报日期||", nullable = true)
    private Date fillDate;

    @Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|更新机构编码||", length = 15, nullable = true)
    private String updateOrgancode;

    @Column(name = "UPDATE_ORGAN_NAME", columnDefinition = "VARCHAR2|更新机构名称||", length = 70, nullable = true)
    private String updateOrganname;

    @Column(name = "UPDATE_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 50, nullable = true)
    private String updateName;

    @Column(name = "UPDATE_IDCARD", columnDefinition = "VARCHAR2|更新人身份证号||", length = 18, nullable = true)
    private String updateIdcard;

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

    public Integer getIdcard() {
        return this.idcard;
    }

    public void setIdcard(Integer idcard) {
        this.idcard = idcard;
    }

    public Integer getSbp() {
        return this.sbp;
    }

    public void setSbp(Integer sbp) {
        this.sbp = sbp;
    }

    public Integer getDbp() {
        return this.dbp;
    }

    public void setDbp(Integer dbp) {
        this.dbp = dbp;
    }

    public String getHypertensionManagementLevel() {
        return this.hypertensionManagementLevel;
    }

    public void setHypertensionManagementLevel(String hypertensionManagementLevel) {
        this.hypertensionManagementLevel = hypertensionManagementLevel;
    }

    public String getClassificationOfHealth() {
        return this.classificationOfHealth;
    }

    public void setClassificationOfHealth(String classificationOfHealth) {
        this.classificationOfHealth = classificationOfHealth;
    }

    public String getHypertensionRiskHierarchy() {
        return this.hypertensionRiskHierarchy;
    }

    public void setHypertensionRiskHierarchy(String hypertensionRiskHierarchy) {
        this.hypertensionRiskHierarchy = hypertensionRiskHierarchy;
    }

    public Integer getConclusionsOfYear() {
        return this.conclusionsOfYear;
    }

    public void setConclusionsOfYear(Integer conclusionsOfYear) {
        this.conclusionsOfYear = conclusionsOfYear;
    }

    public Integer getAnnualVisitTimes() {
        return this.annualVisitTimes;
    }

    public void setAnnualVisitTimes(Integer annualVisitTimes) {
        this.annualVisitTimes = annualVisitTimes;
    }

    public String getFillUnitName() {
        return this.fillUnitName;
    }

    public void setFillUnitName(String fillUnitName) {
        this.fillUnitName = fillUnitName;
    }

    public String getFillUserName() {
        return this.fillUserName;
    }

    public void setFillUserName(String fillUserName) {
        this.fillUserName = fillUserName;
    }

    public Date getFillDate() {
        return this.fillDate;
    }

    public void setFillDate(Date fillDate) {
        this.fillDate = fillDate;
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

    public String getUpdateName() {
        return this.updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getUpdateIdcard() {
        return this.updateIdcard;
    }

    public void setUpdateIdcard(String updateIdcard) {
        this.updateIdcard = updateIdcard;
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
