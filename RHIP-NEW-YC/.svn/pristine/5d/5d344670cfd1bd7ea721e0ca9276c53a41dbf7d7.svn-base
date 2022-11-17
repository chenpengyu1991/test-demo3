package com.founder.rhip.ehr.entity.chm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CHM_STATISTICS_RESULT")
public class ChmStatisticsResult implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	// 选择机构
	@Column(name = "UNIT", columnDefinition = "VARCHAR2|医疗机构|50|", length = 50, nullable = true)
	private String unit;

	// 统计项目
	@Column(name = "PROJECT", columnDefinition = "VARCHAR2|统计项目|50|", length = 50, nullable = true)
	private String project;

	// 统计时段
	@Column(name = "PERIOD", columnDefinition = "VARCHAR2|统计时段|50|", length = 50, nullable = true)
	private String period;

	// 统计结果
	@Column(name = "RESULT_NUM", columnDefinition = "NUMBER|统计结果|11|", length = 11, nullable = true)
	private String resultNum;

	// 机构编号
	@Column(name = "UNIT_CODE", columnDefinition = "VARCHAR2|医疗机构|50|", length = 50, nullable = true)
	private String unitCode;

	// 门诊抗生素比例
	@Column(name = "ATBTC_RATIO", columnDefinition = "NUMBER|统计结果|11|", scale = 8, precision = 2, nullable = true)
	private Double atbtcRatio;

	// 急诊抗生素比例
	@Column(name = "ATBTC_EOP_RATIO", columnDefinition = "NUMBER|统计结果|11|", scale = 8, precision = 2, nullable = true)
	private Double atbtcEopRatio;

	// 二联抗生素比例
	@Column(name = "ANTIBIOTIC_TWO_RATIO", columnDefinition = "NUMBER|统计结果|11|", scale = 8, precision = 2, nullable = true)
	private Double antibioticTwoRatio;

	// 门诊CT数
	@Column(name = "OUTPATIENT_CT_NUM", columnDefinition = "NUMBER|统计结果|11|", length = 11, nullable = true)
	private String outpatientCtNum;

	// 住院CT数
	@Column(name = "INTPATIENT_CT_NUM", columnDefinition = "NUMBER|统计结果|11|", length = 11, nullable = true)
	private String inpatientCtNum;

	// X-线门诊数
	@Column(name = "OUTPATIENT_XRAY_NUM", columnDefinition = "NUMBER|统计结果|11|", length = 11, nullable = true)
	private String outpatientXrayNum;

	// X-线住院数
	@Column(name = "INTPATIENT_CT_NUM", columnDefinition = "NUMBER|统计结果|11|", length = 11, nullable = true)
	private String inpatientXrayNum;

	// B超门诊与住院总例数
	@Column(name = "B_ULTRASOUND_NUM", columnDefinition = "NUMBER|统计结果|11|", length = 11, nullable = true)
	private String bUltrasoundNum;

	// 心电图门诊与住院总例数
	@Column(name = "ELECTROCARDIOGRAM_NUM", columnDefinition = "NUMBER|统计结果|11|", length = 11, nullable = true)
	private String electrocardiogramNum;

	// 胃镜门诊与住院总例数
	@Column(name = "GASTROSCOPE_NUM", columnDefinition = "NUMBER|统计结果|11|", length = 11, nullable = true)
	private String gastroscopeNum;

	// 人员姓名
	@Column(name = "PERSON_Name", columnDefinition = "VARCHAR2|人员编号|20|", length = 20, nullable = true)
	private String personName;

	// 人员编号
	@Column(name = "PERSON_CODE", columnDefinition = "VARCHAR2|人员编号|50|", length = 50, nullable = true)
	private String personCode;

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public String getOutpatientCtNum() {
		return outpatientCtNum;
	}

	public void setOutpatientCtNum(String outpatientCtNum) {
		this.outpatientCtNum = outpatientCtNum;
	}

	public String getInpatientCtNum() {
		return inpatientCtNum;
	}

	public void setInpatientCtNum(String inpatientCtNum) {
		this.inpatientCtNum = inpatientCtNum;
	}

	public String getOutpatientXrayNum() {
		return outpatientXrayNum;
	}

	public void setOutpatientXrayNum(String outpatientXrayNum) {
		this.outpatientXrayNum = outpatientXrayNum;
	}

	public String getInpatientXrayNum() {
		return inpatientXrayNum;
	}

	public void setInpatientXrayNum(String inpatientXrayNum) {
		this.inpatientXrayNum = inpatientXrayNum;
	}

	public String getbUltrasoundNum() {
		return bUltrasoundNum;
	}

	public void setbUltrasoundNum(String bUltrasoundNum) {
		this.bUltrasoundNum = bUltrasoundNum;
	}

	public String getElectrocardiogramNum() {
		return electrocardiogramNum;
	}

	public void setElectrocardiogramNum(String electrocardiogramNum) {
		this.electrocardiogramNum = electrocardiogramNum;
	}

	public String getGastroscopeNum() {
		return gastroscopeNum;
	}

	public void setGastroscopeNum(String gastroscopeNum) {
		this.gastroscopeNum = gastroscopeNum;
	}

	public Double getAtbtcRatio() {
		return atbtcRatio;
	}

	public void setAtbtcRatio(Double atbtcRatio) {
		this.atbtcRatio = atbtcRatio;
	}

	public Double getAtbtcEopRatio() {
		return atbtcEopRatio;
	}

	public void setAtbtcEopRatio(Double atbtcEopRatio) {
		this.atbtcEopRatio = atbtcEopRatio;
	}

	public Double getAntibioticTwoRatio() {
		return antibioticTwoRatio;
	}

	public void setAntibioticTwoRatio(Double antibioticTwoRatio) {
		this.antibioticTwoRatio = antibioticTwoRatio;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getResultNum() {
		return resultNum;
	}

	public void setResultNum(String resultNum) {
		this.resultNum = resultNum;
	}

}
