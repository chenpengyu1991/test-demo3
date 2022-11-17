package com.founder.rhip.ehr.entity.clinic;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ECH_ELDERLY_PHY_STATUS")
public class ElderlyPhyStatus implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|EHR平台人员ID||", length = 11, nullable = true)
	private Long personId;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
	private String name;

	@Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = false)
	private String ehrId;

	@Column(name = "PHYSICAL_EXAM_CODE", columnDefinition = "VARCHAR2|健康体检表编号||", length = 18, nullable = true)
	private String physicalExamCode;

	@Column(name = "EXAM_YEAR", columnDefinition = "VARCHAR2|体检年份||", length = 10, nullable = true)
	private String examYear;

	@Column(name = "EXAMINATION_DATE", columnDefinition = "DATE|体检日期||", nullable = true)
	private Date examinationDate;

	@Column(name = "EXAMINATION_ORGAN_CODE", columnDefinition = "VARCHAR2|体检机构编码||", length = 15, nullable = true)
	private String examinationOrganCode;

	@Column(name = "MANA_DOCTOR_ID", columnDefinition = "VARCHAR2|责任医师ID||", length = 50, nullable = true)
	private String manaDoctorId;

	@Column(name = "CRITERION_EXAMINATION", columnDefinition = "NUMBER|是否规范年检 0 否  1是 ||", nullable = true)
	private Integer criterionExamination;

	@Column(name = "HEALTH_GUIDE_STATUS", columnDefinition = "NUMBER|中医指导状态 0 否  1是||", nullable = true)
	private Integer healthGuideStatus;

	@Column(name = "ESTIMATE_STATUS", columnDefinition = "NUMBER|健康评估状态||", nullable = true)
	private Integer estimateStatus;

	@Column(name = "TCM_STATUS", columnDefinition = "NUMBER|体质辨识状态(0 否  1是)||", length = 2, nullable = true)
	private Integer tcmStatus;

	public String getEhrId() {
		return ehrId;
	}

	public void setEhrId(String ehrId) {
		this.ehrId = ehrId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhysicalExamCode() {
		return physicalExamCode;
	}

	public void setPhysicalExamCode(String physicalExamCode) {
		this.physicalExamCode = physicalExamCode;
	}

	public String getExamYear() {
		return examYear;
	}

	public void setExamYear(String examYear) {
		this.examYear = examYear;
	}

	public Date getExaminationDate() {
		return examinationDate;
	}

	public void setExaminationDate(Date examinationDate) {
		this.examinationDate = examinationDate;
	}

	public String getExaminationOrganCode() {
		return examinationOrganCode;
	}

	public void setExaminationOrganCode(String examinationOrganCode) {
		this.examinationOrganCode = examinationOrganCode;
	}

	public String getManaDoctorId() {
		return manaDoctorId;
	}

	public void setManaDoctorId(String manaDoctorId) {
		this.manaDoctorId = manaDoctorId;
	}

	public Integer getCriterionExamination() {
		return criterionExamination;
	}

	public void setCriterionExamination(Integer criterionExamination) {
		this.criterionExamination = criterionExamination;
	}

	public Integer getHealthGuideStatus() {
		return healthGuideStatus;
	}

	public void setHealthGuideStatus(Integer healthGuideStatus) {
		this.healthGuideStatus = healthGuideStatus;
	}

	public Integer getEstimateStatus() {
		return estimateStatus;
	}

	public void setEstimateStatus(Integer estimateStatus) {
		this.estimateStatus = estimateStatus;
	}

	public Integer getTcmStatus() {
		return tcmStatus;
	}

	public void setTcmStatus(Integer tcmStatus) {
		this.tcmStatus = tcmStatus;
	}

}
