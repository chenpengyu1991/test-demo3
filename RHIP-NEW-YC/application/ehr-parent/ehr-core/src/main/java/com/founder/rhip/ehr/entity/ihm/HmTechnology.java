package com.founder.rhip.ehr.entity.ihm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "HM_TECHNOLOGY")
public class HmTechnology implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|医疗机构编码||", length = 20, nullable = true)
	private String organCode;

	@Column(name = "OUTPATIENT_CT_NUM", columnDefinition = "NUMBER|门诊CT数||", length = 10, nullable = true)
	private Long outpatientCtNum;

	@Column(name = "INPATIENT_CT_NUM", columnDefinition = "NUMBER|住院CT数||", length = 10, nullable = true)
	private Long inpatientCtNum;

	@Column(name = "OUTPATIENT_XRAY_NUM", columnDefinition = "NUMBER|X-线门诊数||", length = 10, nullable = true)
	private Long outpatientXrayNum;

	@Column(name = "INPATIENT_XRAY_NUM", columnDefinition = "NUMBER|X-线住院数||", length = 10, nullable = true)
	private Long inpatientXrayNum;

	@Column(name = "PATHOLOGY_TIMES_NUM", columnDefinition = "NUMBER|病理总次数||", length = 10, nullable = true)
	private Long pathologyTimesNum;

	@Column(name = "EXAM_BRU", columnDefinition = "NUMBER|检验科血常规||", length = 10, nullable = true)
	private Long examBru;

	@Column(name = "EXAM_URINE_ROUTINE", columnDefinition = "NUMBER|检验科尿常规||", length = 10, nullable = true)
	private Long examUrineRoutine;

	@Column(name = "EXAM_SRT", columnDefinition = "NUMBER|检验科大便常规||", length = 10, nullable = true)
	private Long examSrt;

	@Column(name = "EXAM_BLOOD_BIO", columnDefinition = "NUMBER|检验科血生化||", length = 10, nullable = true)
	private Long examBloodBio;

	@Column(name = "EXAM_BLOOD_SUGAR", columnDefinition = "NUMBER|检验科末梢血糖监测||", length = 10, nullable = true)
	private Long examBloodSugar;

	@Column(name = "EXAM_TRANSFUSION", columnDefinition = "NUMBER|检验科输血常规||", length = 10, nullable = true)
	private Long examTransfusion;

	@Column(name = "EXAM_COAGULATION", columnDefinition = "NUMBER|检验科凝血功能||", length = 10, nullable = true)
	private Long examCoagulation;

	@Column(name = "B_ULTRASOUND_NUM", columnDefinition = "NUMBER|B超门诊与住院总例数||", length = 10, nullable = true)
	private Long bUltrasoundNum;

	@Column(name = "ELECTROCARDIOGRAM_NUM", columnDefinition = "NUMBER|心电图门诊与住院总例数||", length = 10, nullable = true)
	private Long electrocardiogramNum;

	@Column(name = "GASTROSCOPE_NUM", columnDefinition = "NUMBER|胃镜门诊与住院总例数||", length = 10, nullable = true)
	private Long gastroscopeNum;

	@Column(name = "CREATE_DATE", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createDate;

	@Column(name = "UPDATE_DATE", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateDate;

	@Column(name = "INTEGRATION_DATE", columnDefinition = "DATE|集成时间||", nullable = true)
	private Date integrationDate;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除标志||", length = 1, nullable = true)
	private Long isDelete;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public Long getOutpatientCtNum() {
		return this.outpatientCtNum;
	}

	public void setOutpatientCtNum(Long outpatientCtNum) {
		this.outpatientCtNum = outpatientCtNum;
	}

	public Long getInpatientCtNum() {
		return this.inpatientCtNum;
	}

	public void setInpatientCtNum(Long inpatientCtNum) {
		this.inpatientCtNum = inpatientCtNum;
	}

	public Long getOutpatientXrayNum() {
		return this.outpatientXrayNum;
	}

	public void setOutpatientXrayNum(Long outpatientXrayNum) {
		this.outpatientXrayNum = outpatientXrayNum;
	}

	public Long getInpatientXrayNum() {
		return this.inpatientXrayNum;
	}

	public void setInpatientXrayNum(Long inpatientXrayNum) {
		this.inpatientXrayNum = inpatientXrayNum;
	}

	public Long getPathologyTimesNum() {
		return this.pathologyTimesNum;
	}

	public void setPathologyTimesNum(Long pathologyTimesNum) {
		this.pathologyTimesNum = pathologyTimesNum;
	}

	public Long getExamBru() {
		return this.examBru;
	}

	public void setExamBru(Long examBru) {
		this.examBru = examBru;
	}

	public Long getExamUrineRoutine() {
		return this.examUrineRoutine;
	}

	public void setExamUrineRoutine(Long examUrineRoutine) {
		this.examUrineRoutine = examUrineRoutine;
	}

	public Long getExamSrt() {
		return this.examSrt;
	}

	public void setExamSrt(Long examSrt) {
		this.examSrt = examSrt;
	}

	public Long getExamBloodBio() {
		return this.examBloodBio;
	}

	public void setExamBloodBio(Long examBloodBio) {
		this.examBloodBio = examBloodBio;
	}

	public Long getExamBloodSugar() {
		return this.examBloodSugar;
	}

	public void setExamBloodSugar(Long examBloodSugar) {
		this.examBloodSugar = examBloodSugar;
	}

	public Long getExamTransfusion() {
		return this.examTransfusion;
	}

	public void setExamTransfusion(Long examTransfusion) {
		this.examTransfusion = examTransfusion;
	}

	public Long getExamCoagulation() {
		return this.examCoagulation;
	}

	public void setExamCoagulation(Long examCoagulation) {
		this.examCoagulation = examCoagulation;
	}

	public Long getBUltrasoundNum() {
		return this.bUltrasoundNum;
	}

	public void setBUltrasoundNum(Long bUltrasoundNum) {
		this.bUltrasoundNum = bUltrasoundNum;
	}

	public Long getElectrocardiogramNum() {
		return this.electrocardiogramNum;
	}

	public void setElectrocardiogramNum(Long electrocardiogramNum) {
		this.electrocardiogramNum = electrocardiogramNum;
	}

	public Long getGastroscopeNum() {
		return this.gastroscopeNum;
	}

	public void setGastroscopeNum(Long gastroscopeNum) {
		this.gastroscopeNum = gastroscopeNum;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getIntegrationDate() {
		return this.integrationDate;
	}

	public void setIntegrationDate(Date integrationDate) {
		this.integrationDate = integrationDate;
	}

	public Long getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Long isDelete) {
		this.isDelete = isDelete;
	}

}