package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "DM_DIABETIC_MGMT")
public class DiabeticMgmt implements Serializable {

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

    @Column(name = "FIRST_DATE", columnDefinition = "DATE|首次发病日期||", nullable = true)
    private Date firstDate;

    @Column(name = "RECUR_DATE", columnDefinition = "DATE|最近复发日期||", nullable = true)
    private Date recurDate;

    @Column(name = "TC", columnDefinition = "NUMBER|总胆固醇值(mmol／L)||", scale = 5, precision = 2, nullable = true)
    private BigDecimal tc;

    @Column(name = "FPG", columnDefinition = "NUMBER|空腹血糖值(mmol／L)||", scale = 4, precision = 1, nullable = true)
    private BigDecimal fpg;

    @Column(name = "FBG_RANDOM", columnDefinition = "NUMBER|随机血糖值(mmol/L)||", scale = 4, precision = 1, nullable = true)
    private BigDecimal fbgRandom;

    @Column(name = "GLU_VALUE", columnDefinition = "NUMBER|餐后2小时血糖值(mmol／L)||", scale = 4, precision = 1, nullable = true)
    private BigDecimal gluvalue;

    @Column(name = "CREATININE", columnDefinition = "NUMBER|血肌酐值(μmol/L)||", scale = 5, precision = 1, nullable = true)
    private BigDecimal creatinine;

    @Column(name = "URINE_PRO_QUANTITATIVE_VALUE", columnDefinition = "NUMBER|尿蛋白定量检测值(mg/24h)||", scale = 5, precision = 1, nullable = true)
    private BigDecimal urineProteinDetectValue;

    @Column(name = "OTHER_ASSAY", columnDefinition = "VARCHAR2|其他化验指标||", length = 100, nullable = true)
    private String otherAssay;

    @Column(name = "DIAGNOSE_TYPE", columnDefinition = "VARCHAR2|诊断分型代码||", length = 1, nullable = true)
    private String diagnoseType;

    @Column(name = "MANAGE_TYPE", columnDefinition = "VARCHAR2|管理级别代码||", length = 1, nullable = true)
    private String manageType;

    @Column(name = "DIAGNOSIS", columnDefinition = "VARCHAR2|诊断依据描述||", length = 100, nullable = true)
    private String diagnosis;

    @Column(name = "UNIT_LEVEL", columnDefinition = "VARCHAR2|确诊单位级别||", length = 1, nullable = true)
    private String unitLevel;

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

    public String getIdcard() {
        return this.idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
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

    public BigDecimal getFbgRandom() {
        return this.fbgRandom;
    }

    public void setFbgRandom(BigDecimal fbgRandom) {
        this.fbgRandom = fbgRandom;
    }

    public BigDecimal getGluvalue() {
        return this.gluvalue;
    }

    public void setGluvalue(BigDecimal gluvalue) {
        this.gluvalue = gluvalue;
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

    public String getOtherAssay() {
        return this.otherAssay;
    }

    public void setOtherAssay(String otherAssay) {
        this.otherAssay = otherAssay;
    }

    public String getDiagnoseType() {
        return this.diagnoseType;
    }

    public void setDiagnoseType(String diagnoseType) {
        this.diagnoseType = diagnoseType;
    }

    public String getManageType() {
        return this.manageType;
    }

    public void setManageType(String manageType) {
        this.manageType = manageType;
    }

    public String getDiagnosis() {
        return this.diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getUnitLevel() {
        return this.unitLevel;
    }

    public void setUnitLevel(String unitLevel) {
        this.unitLevel = unitLevel;
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
