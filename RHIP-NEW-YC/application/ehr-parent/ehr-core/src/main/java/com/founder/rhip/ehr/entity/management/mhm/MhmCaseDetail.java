package com.founder.rhip.ehr.entity.management.mhm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "MHM_CASE_DETAIL")
public class MhmCaseDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "EVENT_ID", columnDefinition = "NUMBER|本系统唯一编码|11|", length = 11, nullable = false)
	private Long eventId;

	@Column(name = "DEFINITE_QUESTION", columnDefinition = "VARCHAR2|明确问题|100|", length = 100, nullable = true)
	private String definiteQuestion;

	@Column(name = "SET_GOAL", columnDefinition = "VARCHAR2|制定目标|100|", length = 100, nullable = true)
	private String setGoal;

	@Column(name = "TAKE_STRATEGY", columnDefinition = "VARCHAR2|采取策略|100|", length = 100, nullable = true)
	private String takeStrategy;

	@Column(name = "PERSON_LIABLE", columnDefinition = "VARCHAR2|责任人|50|", length = 50, nullable = true)
	private String personLiable;

	@Column(name = "FINISH_TIME", columnDefinition = "DATE|完成时间||", nullable = true)
	private Date finishTime;

	@Column(name = "FILL_ORGAN_CODE", columnDefinition = "VARCHAR2|填写机构|100|", length = 100, nullable = true)
	private String fillOrganCode;

	@Column(name = "FILL_DOCTOR_ID", columnDefinition = "VARCHAR2|填写医生|50|", length = 50, nullable = true)
	private String fillDoctorId;

	@Column(name = "FILL_DATE", columnDefinition = "DATE|填写时间||", nullable = true)
	private Date fillDate;

	@Column(name = "MODIFY_DOCTOR_ID", columnDefinition = "VARCHAR2|修改医生|50|", length = 50, nullable = true)
	private String modifyDoctorId;

	@Column(name = "MODIFY_ORGAN_CODE", columnDefinition = "VARCHAR2|修改机构|20|", length = 20, nullable = true)
	private String modifyOrganCode;

	@Column(name = "MODIFY_DATE", columnDefinition = "DATE|修改日期||", nullable = true)
	private Date modifyDate;

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

	public String getDefiniteQuestion() {
		return this.definiteQuestion;
	}

	public void setDefiniteQuestion(String definiteQuestion) {
		this.definiteQuestion = definiteQuestion;
	}

	public String getSetGoal() {
		return this.setGoal;
	}

	public void setSetGoal(String setGoal) {
		this.setGoal = setGoal;
	}

	public String getTakeStrategy() {
		return this.takeStrategy;
	}

	public void setTakeStrategy(String takeStrategy) {
		this.takeStrategy = takeStrategy;
	}

	public String getPersonLiable() {
		return this.personLiable;
	}

	public void setPersonLiable(String personLiable) {
		this.personLiable = personLiable;
	}

	public Date getFinishTime() {
		return this.finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public String getFillOrganCode() {
		return this.fillOrganCode;
	}

	public void setFillOrganCode(String fillOrganCode) {
		this.fillOrganCode = fillOrganCode;
	}

	public String getFillDoctorId() {
		return this.fillDoctorId;
	}

	public void setFillDoctorId(String fillDoctorId) {
		this.fillDoctorId = fillDoctorId;
	}

	public Date getFillDate() {
		return this.fillDate;
	}

	public void setFillDate(Date fillDate) {
		this.fillDate = fillDate;
	}

	public String getModifyDoctorId() {
		return this.modifyDoctorId;
	}

	public void setModifyDoctorId(String modifyDoctorId) {
		this.modifyDoctorId = modifyDoctorId;
	}

	public String getModifyOrganCode() {
		return this.modifyOrganCode;
	}

	public void setModifyOrganCode(String modifyOrganCode) {
		this.modifyOrganCode = modifyOrganCode;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

}