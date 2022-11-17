package com.founder.rhip.ehr.entity.report;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RP_INHOSPITAL_TREATMENT")
public class RpInhospitalTreatment implements Serializable {

	private static final long serialVersionUID = -2567746078940746925L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;
	
	@Column(name = "RP_NAME", columnDefinition = "VARCHAR2|表名（多名称用分号间隔）||", length = 100, nullable = true)
	private String rpName;
	
	@Column(name = "GB_CODE", columnDefinition = "VARCHAR2|所在镇编码||", length = 50, nullable = true)
	private String gbCode;
	
	@Column(name = "CENTER_CODE", columnDefinition = "VARCHAR2|中心编码||", length = 50, nullable = true)
	private String centerCode;
	
	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|机构编码||", length = 50, nullable = true)
	private String organCode;
	
	@Column(name = "ORGAN_TYPE", columnDefinition = "VARCHAR2|机构类型||", length = 5, nullable = true)
	private String organType;
	
	@Column(name = "RP_YEAR", columnDefinition = "VARCHAR2|统计年||", length = 4, nullable = true)
	private String rpYear;
	
	@Column(name = "DISEASES_CODE", columnDefinition = "VARCHAR2|疾病编码||", length = 5, nullable = true)
	private String diseasesCode;
	
	@Column(name = "CASE_NUM_1", columnDefinition = "NUMBER|疾病例数（1季度）||", length = 10, nullable = true)
	private Long caseNum1;
	
	@Column(name = "CASE_DEATH_NUM_1", columnDefinition = "NUMBER|疾病死亡例数（1季度）||", length = 10, nullable = true)
	private Long caseDeathNum1;
	
	@Column(name = "FIFTEEN_AGAIN_NUM_1", columnDefinition = "NUMBER|15日内在住院历数（1季度）||", length = 10, nullable = true)
	private Long fifteenAgainNum1;
	
	@Column(name = "MONTH_AGAIN_NUM_1", columnDefinition = "NUMBER|31日内在住院历数（1季度）||", length = 10, nullable = true)
	private Long monthAgainNum1;
	
	@Column(name = "INHOSPITAL_DAY_1", columnDefinition = "NUMBER|总住院日（1季度）||", length = 10, nullable = true)
	private Long inhospitalDay1;
	
	@Column(name = "INHOSPITAL_FEE_1", columnDefinition = "NUMBER|总住院费用（1季度）||", length = 10, nullable = true)
	private Long inhospitalFee1;
	
	@Column(name = "CASE_NUM_2", columnDefinition = "NUMBER|疾病例数（2季度）||", length = 10, nullable = true)
	private Long caseNum2;
	
	@Column(name = "CASE_DEATH_NUM_2", columnDefinition = "NUMBER|疾病死亡例数（2季度）||", length = 10, nullable = true)
	private Long caseDeathNum2;
	
	@Column(name = "FIFTEEN_AGAIN_NUM_2", columnDefinition = "NUMBER|15日内在住院历数（2季度）||", length = 10, nullable = true)
	private Long fifteenAgainNum2;
	
	@Column(name = "MONTH_AGAIN_NUM_2", columnDefinition = "NUMBER|31日内在住院历数（2季度）||", length = 10, nullable = true)
	private Long monthAgainNum2;
	
	@Column(name = "INHOSPITAL_DAY_2", columnDefinition = "NUMBER|总住院日（2季度）||", length = 10, nullable = true)
	private Long inhospitalDay2;
	
	@Column(name = "INHOSPITAL_FEE_2", columnDefinition = "NUMBER|总住院费用（2季度）||", length = 10, nullable = true)
	private Long inhospitalFee2;
	
	@Column(name = "CASE_NUM_3", columnDefinition = "NUMBER|疾病例数（3季度）||", length = 10, nullable = true)
	private Long caseNum3;
	
	@Column(name = "CASE_DEATH_NUM_3", columnDefinition = "NUMBER|疾病死亡例数（3季度）||", length = 10, nullable = true)
	private Long caseDeathNum3;
	
	@Column(name = "FIFTEEN_AGAIN_NUM_3", columnDefinition = "NUMBER|15日内在住院历数（3季度）||", length = 10, nullable = true)
	private Long fifteenAgainNum3;
	
	@Column(name = "MONTH_AGAIN_NUM_3", columnDefinition = "NUMBER|31日内在住院历数（3季度）||", length = 10, nullable = true)
	private Long monthAgainNum3;
	
	@Column(name = "INHOSPITAL_DAY_3", columnDefinition = "NUMBER|总住院日（3季度）||", length = 10, nullable = true)
	private Long inhospitalDay3;
	
	@Column(name = "INHOSPITAL_FEE_3", columnDefinition = "NUMBER|总住院费用（3季度）||", length = 10, nullable = true)
	private Long inhospitalFee3;
	
	@Column(name = "CASE_NUM_4", columnDefinition = "NUMBER|疾病例数（4季度）||", length = 10, nullable = true)
	private Long caseNum4;
	
	@Column(name = "CASE_DEATH_NUM_4", columnDefinition = "NUMBER|疾病死亡例数（4季度）||", length = 10, nullable = true)
	private Long caseDeathNum4;
	
	@Column(name = "FIFTEEN_AGAIN_NUM_4", columnDefinition = "NUMBER|15日内在住院历数（4季度）||", length = 10, nullable = true)
	private Long fifteenAgainNum4;
	
	@Column(name = "MONTH_AGAIN_NUM_4", columnDefinition = "NUMBER|41日内在住院历数（4季度）||", length = 10, nullable = true)
	private Long monthAgainNum4;
	
	@Column(name = "INHOSPITAL_DAY_4", columnDefinition = "NUMBER|总住院日（4季度）||", length = 10, nullable = true)
	private Long inhospitalDay4;
	
	@Column(name = "INHOSPITAL_FEE_4", columnDefinition = "NUMBER|总住院费用（4季度）||", length = 10, nullable = true)
	private Long inhospitalFee4;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRpName() {
		return rpName;
	}

	public void setRpName(String rpName) {
		this.rpName = rpName;
	}

	public String getGbCode() {
		return gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public String getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getOrganType() {
		return organType;
	}

	public void setOrganType(String organType) {
		this.organType = organType;
	}

	public String getRpYear() {
		return rpYear;
	}

	public void setRpYear(String rpYear) {
		this.rpYear = rpYear;
	}


	public String getDiseasesCode() {
		return diseasesCode;
	}

	public void setDiseasesCode(String diseasesCode) {
		this.diseasesCode = diseasesCode;
	}

	public Long getCaseNum1() {
		return caseNum1;
	}

	public void setCaseNum1(Long caseNum1) {
		this.caseNum1 = caseNum1;
	}

	public Long getCaseDeathNum1() {
		return caseDeathNum1;
	}

	public void setCaseDeathNum1(Long caseDeathNum1) {
		this.caseDeathNum1 = caseDeathNum1;
	}

	public Long getFifteenAgainNum1() {
		return fifteenAgainNum1;
	}

	public void setFifteenAgainNum1(Long fifteenAgainNum1) {
		this.fifteenAgainNum1 = fifteenAgainNum1;
	}

	public Long getMonthAgainNum1() {
		return monthAgainNum1;
	}

	public void setMonthAgainNum1(Long monthAgainNum1) {
		this.monthAgainNum1 = monthAgainNum1;
	}

	public Long getInhospitalDay1() {
		return inhospitalDay1;
	}

	public void setInhospitalDay1(Long inhospitalDay1) {
		this.inhospitalDay1 = inhospitalDay1;
	}

	public Long getInhospitalFee1() {
		return inhospitalFee1;
	}

	public void setInhospitalFee1(Long inhospitalFee1) {
		this.inhospitalFee1 = inhospitalFee1;
	}

	public Long getCaseNum2() {
		return caseNum2;
	}

	public void setCaseNum2(Long caseNum2) {
		this.caseNum2 = caseNum2;
	}

	public Long getCaseDeathNum2() {
		return caseDeathNum2;
	}

	public void setCaseDeathNum2(Long caseDeathNum2) {
		this.caseDeathNum2 = caseDeathNum2;
	}

	public Long getFifteenAgainNum2() {
		return fifteenAgainNum2;
	}

	public void setFifteenAgainNum2(Long fifteenAgainNum2) {
		this.fifteenAgainNum2 = fifteenAgainNum2;
	}

	public Long getMonthAgainNum2() {
		return monthAgainNum2;
	}

	public void setMonthAgainNum2(Long monthAgainNum2) {
		this.monthAgainNum2 = monthAgainNum2;
	}

	public Long getInhospitalDay2() {
		return inhospitalDay2;
	}

	public void setInhospitalDay2(Long inhospitalDay2) {
		this.inhospitalDay2 = inhospitalDay2;
	}

	public Long getInhospitalFee2() {
		return inhospitalFee2;
	}

	public void setInhospitalFee2(Long inhospitalFee2) {
		this.inhospitalFee2 = inhospitalFee2;
	}

	public Long getCaseNum3() {
		return caseNum3;
	}

	public void setCaseNum3(Long caseNum3) {
		this.caseNum3 = caseNum3;
	}

	public Long getCaseDeathNum3() {
		return caseDeathNum3;
	}

	public void setCaseDeathNum3(Long caseDeathNum3) {
		this.caseDeathNum3 = caseDeathNum3;
	}

	public Long getFifteenAgainNum3() {
		return fifteenAgainNum3;
	}

	public void setFifteenAgainNum3(Long fifteenAgainNum3) {
		this.fifteenAgainNum3 = fifteenAgainNum3;
	}

	public Long getMonthAgainNum3() {
		return monthAgainNum3;
	}

	public void setMonthAgainNum3(Long monthAgainNum3) {
		this.monthAgainNum3 = monthAgainNum3;
	}

	public Long getInhospitalDay3() {
		return inhospitalDay3;
	}

	public void setInhospitalDay3(Long inhospitalDay3) {
		this.inhospitalDay3 = inhospitalDay3;
	}

	public Long getInhospitalFee3() {
		return inhospitalFee3;
	}

	public void setInhospitalFee3(Long inhospitalFee3) {
		this.inhospitalFee3 = inhospitalFee3;
	}

	public Long getCaseNum4() {
		return caseNum4;
	}

	public void setCaseNum4(Long caseNum4) {
		this.caseNum4 = caseNum4;
	}

	public Long getCaseDeathNum4() {
		return caseDeathNum4;
	}

	public void setCaseDeathNum4(Long caseDeathNum4) {
		this.caseDeathNum4 = caseDeathNum4;
	}

	public Long getFifteenAgainNum4() {
		return fifteenAgainNum4;
	}

	public void setFifteenAgainNum4(Long fifteenAgainNum4) {
		this.fifteenAgainNum4 = fifteenAgainNum4;
	}

	public Long getMonthAgainNum4() {
		return monthAgainNum4;
	}

	public void setMonthAgainNum4(Long monthAgainNum4) {
		this.monthAgainNum4 = monthAgainNum4;
	}

	public Long getInhospitalDay4() {
		return inhospitalDay4;
	}

	public void setInhospitalDay4(Long inhospitalDay4) {
		this.inhospitalDay4 = inhospitalDay4;
	}

	public Long getInhospitalFee4() {
		return inhospitalFee4;
	}

	public void setInhospitalFee4(Long inhospitalFee4) {
		this.inhospitalFee4 = inhospitalFee4;
	}
	
	
}
