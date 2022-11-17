package com.founder.rhip.ehr.entity.management.mhm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "MHM_PATH_HISTORY")
public class MhmPathHistory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "EVENT_ID", columnDefinition = "NUMBER|本系统唯一编码|11|", length = 11, nullable = false)
	private Long eventId;

	@Column(name = "FIRST_DISEASE_DATE", columnDefinition = "DATE|初次发病时间||", nullable = true)
	private Date firstDiseaseDate;

	@Column(name = "HOSPITAL_COURSE", columnDefinition = "VARCHAR2|住院情况|200|", length = 200, nullable = true)
	private String hospitalCourse;

	@Column(name = "FIRST_TREATMENT_DATE", columnDefinition = "DATE|首次抗精神病药治疗时间||", nullable = true)
	private Date firstTreatmentDate;

	@Column(name = "SYMPTOM", columnDefinition = "VARCHAR2|症状|200|", length = 200, nullable = true)
	private String symptom;

	@Column(name = "PREVIOUS_TREATMENT", columnDefinition = "VARCHAR2|既往治疗情况－门诊|200|", length = 200, nullable = true)
	private String previousTreatment;

	@Column(name = "PREVIOUS_INHOSPITAL_TIMES", columnDefinition = "NUMBER|既往住院次数|5|", length = 5, nullable = true)
	private Integer previousInhospitalTimes;

	@Column(name = "LAST_INHOSPITAL_EFFECT", columnDefinition = "VARCHAR2|最近一次住院疗效|200|", length = 200, nullable = true)
	private String lastInhospitalEffect;

	@Column(name = "FAMILY_HISTORY", columnDefinition = "VARCHAR2|两次三代精神病家族史|200|", length = 200, nullable = true)
	private String familyHistory;

	@Column(name = "LOCK_STATE", columnDefinition = "VARCHAR2|关锁情况|20|", length = 20, nullable = true)
	private String lockState;

	@Column(name = "LAST_LEAVE_HOSPITAL_DATE", columnDefinition = "DATE|末次出院日期||", nullable = true)
	private Date lastLeaveHospitalDate;

	@Column(name = "LAST_INHOSPITAL", columnDefinition = "VARCHAR2|末次住院医院|100|", length = 100, nullable = true)
	private String lastInhospital;

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

	public Date getFirstDiseaseDate() {
		return this.firstDiseaseDate;
	}

	public void setFirstDiseaseDate(Date firstDiseaseDate) {
		this.firstDiseaseDate = firstDiseaseDate;
	}

	public String getHospitalCourse() {
		return this.hospitalCourse;
	}

	public void setHospitalCourse(String hospitalCourse) {
		this.hospitalCourse = hospitalCourse;
	}

	public Date getFirstTreatmentDate() {
		return this.firstTreatmentDate;
	}

	public void setFirstTreatmentDate(Date firstTreatmentDate) {
		this.firstTreatmentDate = firstTreatmentDate;
	}

	public String getSymptom() {
		return this.symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getPreviousTreatment() {
		return this.previousTreatment;
	}

	public void setPreviousTreatment(String previousTreatment) {
		this.previousTreatment = previousTreatment;
	}

	public Integer getPreviousInhospitalTimes() {
		return this.previousInhospitalTimes;
	}

	public void setPreviousInhospitalTimes(Integer previousInhospitalTimes) {
		this.previousInhospitalTimes = previousInhospitalTimes;
	}

	public String getLastInhospitalEffect() {
		return this.lastInhospitalEffect;
	}

	public void setLastInhospitalEffect(String lastInhospitalEffect) {
		this.lastInhospitalEffect = lastInhospitalEffect;
	}

	public String getFamilyHistory() {
		return this.familyHistory;
	}

	public void setFamilyHistory(String familyHistory) {
		this.familyHistory = familyHistory;
	}

	public String getLockState() {
		return this.lockState;
	}

	public void setLockState(String lockState) {
		this.lockState = lockState;
	}

	public Date getLastLeaveHospitalDate() {
		return this.lastLeaveHospitalDate;
	}

	public void setLastLeaveHospitalDate(Date lastLeaveHospitalDate) {
		this.lastLeaveHospitalDate = lastLeaveHospitalDate;
	}

	public String getLastInhospital() {
		return this.lastInhospital;
	}

	public void setLastInhospital(String lastInhospital) {
		this.lastInhospital = lastInhospital;
	}

}