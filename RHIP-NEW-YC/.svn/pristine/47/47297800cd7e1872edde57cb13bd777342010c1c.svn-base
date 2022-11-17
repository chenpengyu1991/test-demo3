package com.founder.rhip.ehr.entity.management.mhm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MHM_OUTPATIENT_RECORD")
public class MhmOutpatientRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|MHM_OUTPATIENT_RECORD|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "EVENT_ID", columnDefinition = "NUMBER|本系统唯一编码|11|", length = 11, nullable = false)
	private Long eventId;

	@Column(name = "STATUS_ID", columnDefinition = "NUMBER|STATUS表编码|11|", length = 11, nullable = false)
	private Long statusId;

	@Column(name = "OUTPATIENT_DT", columnDefinition = "DATE|门诊时间||", nullable = true)
	private Date outpatientDt;

	@Column(name = "OUTPATIENT_ORGAN", columnDefinition = "VARCHAR2|就诊机构|100|", length = 100, nullable = true)
	private String outpatientOrgan;

	@Column(name = "OUTPATIENT_NO", columnDefinition = "VARCHAR2|门诊号|100|", length = 100, nullable = true)
	private String outpatientNo;

	@Column(name = "DIAGNOSIS_RESULT", columnDefinition = "VARCHAR2|诊断结果|100|", length = 100, nullable = true)
	private String diagnosisResult;

	@Column(name = "DIAGNOSIS_DOCTOR", columnDefinition = "VARCHAR2|诊断医生|50|", length = 50, nullable = true)
	private String diagnosisDoctor;

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

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public Date getOutpatientDt() {
		return this.outpatientDt;
	}

	public void setOutpatientDt(Date OutpatientDt) {
		this.outpatientDt = OutpatientDt;
	}

	public String getOutpatientOrgan() {
		return this.outpatientOrgan;
	}

	public void setOutpatientOrgan(String OutpatientOrgan) {
		this.outpatientOrgan = OutpatientOrgan;
	}

	public String getOutpatientNo() {
		return this.outpatientNo;
	}

	public void setOutpatientNo(String OutpatientNo) {
		this.outpatientNo = OutpatientNo;
	}

	public String getDiagnosisResult() {
		return this.diagnosisResult;
	}

	public void setDiagnosisResult(String diagnosisResult) {
		this.diagnosisResult = diagnosisResult;
	}

	public String getDiagnosisDoctor() {
		return this.diagnosisDoctor;
	}

	public void setDiagnosisDoctor(String diagnosisDoctor) {
		this.diagnosisDoctor = diagnosisDoctor;
	}

}