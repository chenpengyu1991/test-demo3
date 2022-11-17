package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import com.founder.fasf.util.StringUtil;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "IDM_LIST_AC")
public class ListAc implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Integer id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
	private Integer idmId;

	@Column(name = "TREATMENT_NUM", columnDefinition = "VARCHAR2|就诊次数||", length = 2, nullable = true)
	private String treatmentNum;

	@Column(name = "TREATMENT_UNIT", columnDefinition = "VARCHAR2|就诊单位||", length = 200, nullable = true)
	private String treatmentUnit;

	@Column(name = "TREATMENT_DT", columnDefinition = "DATE|就诊日期||", nullable = true)
	private Date treatmentDt;

	@Column(name = "TREAT_DAYS", columnDefinition = "VARCHAR2|治疗天数||", length = 100, nullable = true)
	private String treatDays;

	@Column(name = "DIAGNOSIS_RESULT", columnDefinition = "VARCHAR2|诊断结果||", length = 100, nullable = true)
	private String diagnosisResult;

	@Column(name = "QUARANTINE", columnDefinition = "VARCHAR2|是否隔离||", length = 2, nullable = true)
	private String quarantine;

	@Column(name = "INHOSPITAL_DT", columnDefinition = "DATE|入住院时间||", nullable = true)
	private Date inhospitalDt;

	@Column(name = "OUTPATIENT_NO", columnDefinition = "VARCHAR2|门诊/住院病历号||", length = 100, nullable = true)
	private String outpatientNo;

	@Column(name = "LAPSE", columnDefinition = "VARCHAR2|转归||", length = 2, nullable = true)
	private String lapse;

	@Column(name = "TREATMENT_DEPARTMENTS", columnDefinition = "VARCHAR2|就诊医院和科室||", length = 200, nullable = true)
	private String treatmentDepartments;

	@Column(name = "DIAGNOSIS_NAME", columnDefinition = "VARCHAR2|诊断病名||", length = 100, nullable = true)
	private String diagnosisName;

	@Column(name = "MEDICAL_WORKERS", columnDefinition = "VARCHAR2|接诊、治疗的医护人员||", length = 200, nullable = true)
	private String medicalWorkers;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdmId() {
		return this.idmId;
	}

	public void setIdmId(Integer idmId) {
		this.idmId = idmId;
	}

	public String getTreatmentNum() {
		return this.treatmentNum;
	}

	public void setTreatmentNum(String treatmentNum) {
		this.treatmentNum = treatmentNum;
	}

	public String getTreatmentUnit() {
		return this.treatmentUnit;
	}

	public void setTreatmentUnit(String treatmentUnit) {
		this.treatmentUnit = treatmentUnit;
	}

	public Date getTreatmentDt() {
		return this.treatmentDt;
	}

	public void setTreatmentDt(Date treatmentDt) {
		this.treatmentDt = treatmentDt;
	}

	public String getTreatDays() {
		return this.treatDays;
	}

	public void setTreatDays(String treatDays) {
		this.treatDays = treatDays;
	}

	public String getDiagnosisResult() {
		return this.diagnosisResult;
	}

	public void setDiagnosisResult(String diagnosisResult) {
		this.diagnosisResult = diagnosisResult;
	}

	public String getQuarantine() {
		return this.quarantine;
	}

	public void setQuarantine(String quarantine) {
		this.quarantine = quarantine;
	}

	public Date getInhospitalDt() {
		return this.inhospitalDt;
	}

	public void setInhospitalDt(Date inhospitalDt) {
		this.inhospitalDt = inhospitalDt;
	}

	public String getOutpatientNo() {
		return this.outpatientNo;
	}

	public void setOutpatientNo(String outpatientNo) {
		this.outpatientNo = outpatientNo;
	}

	public String getLapse() {
		return this.lapse;
	}

	public void setLapse(String lapse) {
		this.lapse = lapse;
	}

	public String getTreatmentDepartments() {
		return this.treatmentDepartments;
	}

	public void setTreatmentDepartments(String treatmentDepartments) {
		this.treatmentDepartments = treatmentDepartments;
	}

	public String getDiagnosisName() {
		return this.diagnosisName;
	}

	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}

	public String getMedicalWorkers() {
		return this.medicalWorkers;
	}

	public void setMedicalWorkers(String medicalWorkers) {
		this.medicalWorkers = medicalWorkers;
	}

    public String getQuarantineStr(){
        return StringUtil.isNotEmpty(quarantine)?("1".equals(quarantine)?"是":"否"):"";
    }

    public String getLapseStr(){
        String result = "";
        if(StringUtil.isNotEmpty(lapse)){
            if("1".equals(lapse)){
                result = "痊愈";
            }else if("2".equals(lapse)){
                result = "好转";
            }else if("4".equals(lapse)){
                result = "死亡";
            }
        }
        return result;
    }

}