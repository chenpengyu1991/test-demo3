package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "DM_HYPERTENSION_MGMT")
public class HypertensionMgmt implements Serializable {

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

    @Column(name = "GLKH", columnDefinition = "VARCHAR2|管理卡号||", length = 20, nullable = true)
    private String glkh;

    @Column(name = "FIRST_DATE", columnDefinition = "DATE|首次发病日期||", nullable = true)
    private Date firstDate;

    @Column(name = "RECUR_DATE", columnDefinition = "DATE|最近复发日期||", nullable = true)
    private Date recurDate;

    @Column(name = "TC", columnDefinition = "NUMBER|总胆固醇值(mmol／L)||", scale = 5, precision = 2, nullable = true)
    private BigDecimal tc;

    @Column(name = "FPG", columnDefinition = "NUMBER|空腹血糖值(mmol／L)||", scale = 5, precision = 1, nullable = true)
    private BigDecimal fpg;

    @Column(name = "CREATININE", columnDefinition = "NUMBER|血肌酐值(μmol/L)||", scale = 5, precision = 1, nullable = true)
    private BigDecimal creatinine;

    @Column(name = "URINE_PRO_QUANTITATIVE_VALUE", columnDefinition = "NUMBER|尿蛋白定量检测值(mg/24h)||", scale = 5, precision = 1, nullable = true)
    private BigDecimal urineProteinDetectValue;

    @Column(name = "IS_STROKE", columnDefinition = "CHAR|是否中风||", length = 1, nullable = true)
    private String isStroke;

    @Column(name = "STROKE_REASON", columnDefinition = "VARCHAR2|中风原因||", length = 100, nullable = true)
    private String strokeReason;

    @Column(name = "DIAGNOSE_TYPE", columnDefinition = "VARCHAR2|诊断分级代码||", length = 1, nullable = true)
    private String diagnoseType;

    @Column(name = "DANGER_LEVEL", columnDefinition = "VARCHAR2|危险因素分层||", length = 1, nullable = true)
    private String dangerLevel;

    @Column(name = "DIAGNOSIS", columnDefinition = "VARCHAR2|诊断依据||", length = 100, nullable = true)
    private String diagnosis;

    @Column(name = "ORGAN_LEVEL", columnDefinition = "VARCHAR2|确诊单位级别代码||", length = 1, nullable = true)
    private String organLevel;

    @Column(name = "DIAGNOSIS_ORGAN_NAME", columnDefinition = "VARCHAR2|诊断机构名称||", length = 70, nullable = true)
    private String diagnosisOrganName;

    @Column(name = "DIAGNOSE_DOCTOR", columnDefinition = "VARCHAR2|诊断医生姓名||", length = 50, nullable = true)
    private String diagnoseDoctor;

    @Column(name = "DIAGNOSIS_DATE", columnDefinition = "DATE|诊断日期||", nullable = true)
    private Date diagnosisDate;

    @Column(name = "TREATMENT_EFFECT", columnDefinition = "VARCHAR2|治疗情况描述||", length = 100, nullable = true)
    private String treatmentEffect;

    @Column(name = "MEDICATION_COMPLIANCE", columnDefinition = "VARCHAR2|服药依从性代码||", length = 1, nullable = true)
    private String medicationCompliance;

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

    public Date getFirstDate() {
        return this.firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    public Date getRecurDate() {
        return this.recurDate;
    }

    public void setRecurDate(Date recurDate) {
        this.recurDate = recurDate;
    }

    public BigDecimal getTc() {
        return this.tc;
    }

    public void setTc(BigDecimal tc) {
        this.tc = tc;
    }

    public BigDecimal getFpg() {
        return this.fpg;
    }

    public void setFpg(BigDecimal fpg) {
        this.fpg = fpg;
    }

    public BigDecimal getCreatinine() {
        return this.creatinine;
    }

    public void setCreatinine(BigDecimal creatinine) {
        this.creatinine = creatinine;
    }

    public BigDecimal getUrineProteinDetectValue() {
        return this.urineProteinDetectValue;
    }

    public void setUrineProteinDetectValue(BigDecimal urineProteinDetectValue) {
        this.urineProteinDetectValue = urineProteinDetectValue;
    }

    public String getIsStroke() {
        return this.isStroke;
    }

    public void setIsStroke(String isStroke) {
        this.isStroke = isStroke;
    }

    public String getStrokeReason() {
        return this.strokeReason;
    }

    public void setStrokeReason(String strokeReason) {
        this.strokeReason = strokeReason;
    }

    public String getDiagnoseType() {
        return this.diagnoseType;
    }

    public void setDiagnoseType(String diagnoseType) {
        this.diagnoseType = diagnoseType;
    }

    public String getDangerLevel() {
        return this.dangerLevel;
    }

    public void setDangerLevel(String dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

    public String getDiagnosis() {
        return this.diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getOrganLevel() {
        return this.organLevel;
    }

    public void setOrganLevel(String organLevel) {
        this.organLevel = organLevel;
    }

    public String getDiagnosisOrganName() {
        return this.diagnosisOrganName;
    }

    public void setDiagnosisOrganName(String diagnosisOrganName) {
        this.diagnosisOrganName = diagnosisOrganName;
    }

    public String getDiagnoseDoctor() {
        return this.diagnoseDoctor;
    }

    public void setDiagnoseDoctor(String diagnoseDoctor) {
        this.diagnoseDoctor = diagnoseDoctor;
    }

    public Date getDiagnosisDate() {
        return this.diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public String getTreatmentEffect() {
        return this.treatmentEffect;
    }

    public void setTreatmentEffect(String treatmentEffect) {
        this.treatmentEffect = treatmentEffect;
    }

    public String getMedicationCompliance() {
        return this.medicationCompliance;
    }

    public void setMedicationCompliance(String medicationCompliance) {
        this.medicationCompliance = medicationCompliance;
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
