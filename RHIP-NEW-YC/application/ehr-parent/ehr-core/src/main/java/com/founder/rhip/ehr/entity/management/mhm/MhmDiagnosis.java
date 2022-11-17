package com.founder.rhip.ehr.entity.management.mhm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MHM_DIAGNOSIS")
public class MhmDiagnosis implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "EVENT_ID", columnDefinition = "NUMBER|本系统唯一编码|11|", length = 11, nullable = false)
	private Long eventId;

	@Column(name = "DIAGNOSIS_RESULT", columnDefinition = "NUMBER|诊断结果|2|", length = 2, nullable = true)
	private Integer diagnosisResult;
	
	@Column(name = "RE_CHECK", columnDefinition = "NUMBER|复核状态|2|", length = 2, nullable = true)
	private Integer reCheck;
			
	@Column(name = "DIAGNOSIS_CONTENT", columnDefinition = "VARCHAR2|诊断结果内容|400|", length = 400, nullable = true)
	private String diagnosisContent;

	@Column(name = "CURRENT_DIAGNOSIS", columnDefinition = "VARCHAR2|目前诊断|400|", length = 400, nullable = true)
	private String currentDiagnosis;

	@Column(name = "DIAGNOSIS_HOSPITAL", columnDefinition = "VARCHAR2|诊断医院|400|", length = 400, nullable = true)
	private String diagnosisHospital;

    @Column(name = "IS_FOREIGN", columnDefinition = "VARCHAR2|是否外地诊断机构标示|2|", length = 2, nullable = true)
    private String isForeign;

    @Column(name = "FOREIGN_UNIT", columnDefinition = "VARCHAR2|外地机构|100|", length = 100, nullable = true)
    private String foreignUnit;

	@Column(name = "DIAGNOSIS_DOCTOR", columnDefinition = "VARCHAR2|诊断医生|50|", length = 50, nullable = true)
	private String diagnosisDoctor;

	@Column(name = "DIAGNOSIS_DATE", columnDefinition = "DATE|诊断日期||", nullable = true)
	private Date diagnosisDate;

	@Column(name = "SPECIALIST_ADVICE", columnDefinition = "VARCHAR2|专科医生建议|400|", length = 400, nullable = true)
	private String specialistAdvice;

	@Column(name = "RECOVERY_MEASURES", columnDefinition = "VARCHAR2|康复措施|400|", length = 400, nullable = true)
	private String RecoveryMeasures;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEventId() {
		return this.eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Integer getDiagnosisResult() {
		return this.diagnosisResult;
	}

	public void setDiagnosisResult(Integer diagnosisResult) {
		this.diagnosisResult = diagnosisResult;
	}

	public String getDiagnosisContent() {
		return this.diagnosisContent;
	}

	public void setDiagnosisContent(String diagnosisContent) {
		this.diagnosisContent = diagnosisContent;
	}

	public String getCurrentDiagnosis() {
		return this.currentDiagnosis;
	}

	public void setCurrentDiagnosis(String currentDiagnosis) {
		this.currentDiagnosis = currentDiagnosis;
	}

	public String getDiagnosisHospital() {
		return this.diagnosisHospital;
	}

	public void setDiagnosisHospital(String diagnosisHospital) {
		this.diagnosisHospital = diagnosisHospital;
	}

	public String getDiagnosisDoctor() {
		return this.diagnosisDoctor;
	}

	public void setDiagnosisDoctor(String diagnosisDoctor) {
		this.diagnosisDoctor = diagnosisDoctor;
	}

	public Date getDiagnosisDate() {
		return this.diagnosisDate;
	}

	public void setDiagnosisDate(Date diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}

	public String getSpecialistAdvice() {
		return this.specialistAdvice;
	}

	public void setSpecialistAdvice(String specialistAdvice) {
		this.specialistAdvice = specialistAdvice;
	}

	public String getRecoveryMeasures() {
		return this.RecoveryMeasures;
	}

	public void setRecoveryMeasures(String RecoveryMeasures) {
		this.RecoveryMeasures = RecoveryMeasures;
	}

    public String getIsForeign() {
        return isForeign;
    }

    public void setIsForeign(String foreign) {
        isForeign = foreign;
    }

    public String getForeignUnit() {
        return foreignUnit;
    }

    public void setForeignUnit(String foreignUnit) {
        this.foreignUnit = foreignUnit;
    }

	public Integer getReCheck() {
		return reCheck;
	}

	public void setReCheck(Integer reCheck) {
		this.reCheck = reCheck;
	}
}