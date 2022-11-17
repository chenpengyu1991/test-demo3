package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "DM_TUMOR_MGMT")
public class TumorMgmt implements Serializable {

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

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|居民身份证/健康卡号||", length = 18, nullable = false)
    private String idcard;

    @Column(name = "GLKH", columnDefinition = "VARCHAR2|管理卡号||", length = 20, nullable = false)
    private String glkh;

    @Column(name = "FIRST_DATE", columnDefinition = "DATE|首次发病日期||", nullable = true)
    private Date firstDate;

    @Column(name = "RECUR_DATE", columnDefinition = "DATE|最近复发日期||", nullable = true)
    private Date recurDate;

    @Column(name = "DISEASE_NOTE", columnDefinition = "VARCHAR2|患病情况描述||", length = 100, nullable = true)
    private String diseaseNote;

    @Column(name = "DIAGNOSE_DISEASE_CODE", columnDefinition = "VARCHAR2|ICD-10编码||", length = 8, nullable = true)
    private String diagnoseDiseaseCode;

    @Column(name = "DIAGNOSE_DISEASE_NAME", columnDefinition = "VARCHAR2|诊断疾病名称||", length = 100, nullable = true)
    private String diagnoseDiseaseName;

    @Column(name = "DIAGNOSE_TYPET", columnDefinition = "VARCHAR2|肿瘤TNM分期T代码||", length = 2, nullable = true)
    private String diagnoseTypet;

    @Column(name = "DIAGNOSE_TYPEN", columnDefinition = "VARCHAR2|肿瘤TNM分期N代码||", length = 1, nullable = true)
    private String diagnoseTypen;

    @Column(name = "DIAGNOSE_TYPEM", columnDefinition = "VARCHAR2|肿瘤TNM分期M代码||", length = 1, nullable = true)
    private String diagnoseTypem;

    @Column(name = "CUR_STATE", columnDefinition = "VARCHAR2|目前疾病情况代码||", length = 1, nullable = true)
    private String curState;

    @Column(name = "TUMOR_CLINICAL", columnDefinition = "VARCHAR2|肿瘤临床分期代码||", length = 1, nullable = true)
    private String tumorClinical;

    @Column(name = "NLOHMSI_CODE", columnDefinition = "VARCHAR2|病理类型代码||", length = 7, nullable = true)
    private String nlohmsiCode;

    @Column(name = "NLOHMSI_NAME", columnDefinition = "VARCHAR2|病理类型名称||", length = 100, nullable = true)
    private String nlohmsiName;

    @Column(name = "ICD10_CODE", columnDefinition = "VARCHAR2|ICD-10编码||", length = 8, nullable = true)
    private String icd10Code;

    @Column(name = "DIAGNOSIS", columnDefinition = "VARCHAR2|诊断依据代码组合||", length = 100, nullable = true)
    private String diagnosis;

    @Column(name = "DIAGNOSIS_OTHER", columnDefinition = "VARCHAR2|其他诊断依据描述||", length = 100, nullable = true)
    private String diagnosisOther;

    @Column(name = "PART", columnDefinition = "VARCHAR2|若继发注明原发部位||", length = 100, nullable = true)
    private String part;

    @Column(name = "DIAGNOSE_ORG", columnDefinition = "VARCHAR2|诊断单位名称||", length = 70, nullable = true)
    private String diagnoseOrg;

    @Column(name = "DIAGNOSE_DOCIOR", columnDefinition = "VARCHAR2|责任医生姓名||", length = 50, nullable = true)
    private String diagnoseDocior;

    @Column(name = "DIAGNOSIS_DATE", columnDefinition = "DATE|诊断日期||", nullable = true)
    private Date diagnosisDate;

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

    public String getIdcard() {
        return this.idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
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

    public String getDiseaseNote() {
        return this.diseaseNote;
    }

    public void setDiseaseNote(String diseaseNote) {
        this.diseaseNote = diseaseNote;
    }

    public String getDiagnoseDiseaseCode() {
        return this.diagnoseDiseaseCode;
    }

    public void setDiagnoseDiseaseCode(String diagnoseDiseaseCode) {
        this.diagnoseDiseaseCode = diagnoseDiseaseCode;
    }

    public String getDiagnoseDiseaseName() {
        return this.diagnoseDiseaseName;
    }

    public void setDiagnoseDiseaseName(String diagnoseDiseaseName) {
        this.diagnoseDiseaseName = diagnoseDiseaseName;
    }

    public String getDiagnoseTypet() {
        return this.diagnoseTypet;
    }

    public void setDiagnoseTypet(String diagnoseTypet) {
        this.diagnoseTypet = diagnoseTypet;
    }

    public String getDiagnoseTypen() {
        return this.diagnoseTypen;
    }

    public void setDiagnoseTypen(String diagnoseTypen) {
        this.diagnoseTypen = diagnoseTypen;
    }

    public String getDiagnoseTypem() {
        return this.diagnoseTypem;
    }

    public void setDiagnoseTypem(String diagnoseTypem) {
        this.diagnoseTypem = diagnoseTypem;
    }

    public String getCurState() {
        return this.curState;
    }

    public void setCurState(String curState) {
        this.curState = curState;
    }

    public String getTumorClinical() {
        return this.tumorClinical;
    }

    public void setTumorClinical(String tumorClinical) {
        this.tumorClinical = tumorClinical;
    }

    public String getNlohmsiCode() {
        return this.nlohmsiCode;
    }

    public void setNlohmsiCode(String nlohmsiCode) {
        this.nlohmsiCode = nlohmsiCode;
    }

    public String getNlohmsiName() {
        return this.nlohmsiName;
    }

    public void setNlohmsiName(String nlohmsiName) {
        this.nlohmsiName = nlohmsiName;
    }

    public String getIcd10Code() {
        return this.icd10Code;
    }

    public void setIcd10Code(String icd10Code) {
        this.icd10Code = icd10Code;
    }

    public String getDiagnosis() {
        return this.diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDiagnosisOther() {
        return this.diagnosisOther;
    }

    public void setDiagnosisOther(String diagnosisOther) {
        this.diagnosisOther = diagnosisOther;
    }

    public String getPart() {
        return this.part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getDiagnoseOrg() {
        return this.diagnoseOrg;
    }

    public void setDiagnoseOrg(String diagnoseOrg) {
        this.diagnoseOrg = diagnoseOrg;
    }

    public String getDiagnoseDocior() {
        return this.diagnoseDocior;
    }

    public void setDiagnoseDocior(String diagnoseDocior) {
        this.diagnoseDocior = diagnoseDocior;
    }

    public Date getDiagnosisDate() {
        return this.diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
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
