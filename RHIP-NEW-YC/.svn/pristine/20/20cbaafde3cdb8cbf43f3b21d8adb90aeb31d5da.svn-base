package com.founder.rhip.ehr.entity.report;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name = "RP_INHOSPITAL")
public class RpInhospital implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "RP_NAME", columnDefinition = "VARCHAR2|表名（多名称用分号间隔）|100|", length = 100, nullable = true)
	private String rpName;

	@Column(name = "GB_CODE", columnDefinition = "VARCHAR2|所在镇code|50|", length = 50, nullable = true)
	private String gbCode;

	@Column(name = "CENTER_CODE", columnDefinition = "VARCHAR2|中心code|50|", length = 50, nullable = true)
	private String centerCode;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|机构code|50|", length = 50, nullable = true)
	private String organCode;

	@Column(name = "ORGAN_TYPE", columnDefinition = "VARCHAR2|机构类型|5|", length = 5, nullable = true)
	private String organType;

	@Column(name = "RP_DATE", columnDefinition = "DATE|统计日期（出院日期）||", nullable = true)
	private Date rpDate;

	@Column(name = "DOCTOR_NUM", columnDefinition = "NUMBER|医技人员数|10|", length = 10, nullable = true)
	private Long doctorNum;

	@Column(name = "IN_NUM", columnDefinition = "NUMBER|入院病人数（入院日期）|10|", length = 10, nullable = true)
	private Long inNum;

	@Column(name = "BE_NUM", columnDefinition = "NUMBER|在院病人数|10|", length = 10, nullable = true)
	private Long beNum;

	@Column(name = "LEAVE_NUM", columnDefinition = "NUMBER|出院病人数|10|", length = 10, nullable = true)
	private Long leaveNum;

	@Column(name = "INHOSPITAL_DAY", columnDefinition = "NUMBER|住院日数|10|", length = 10, nullable = true)
	private Long inhospitalDay;

	@Column(name = "OPERATION_NUM", columnDefinition = "NUMBER|出院病人手术数|10|", length = 10, nullable = true)
	private Long operationNum;

	@Column(name = "ANESTHESIA_NUM", columnDefinition = "NUMBER|出院病人麻醉数|10|", length = 10, nullable = true)
	private Long anesthesiaNum;

	@Column(name = "CLINICAL_PATHWAY_NUM", columnDefinition = "NUMBER|实施临床路径人次数|10|", length = 10, nullable = true)
	private Long clinicalPathwayNum;

	@Column(name = "OUTCP_NUM", columnDefinition = "NUMBER|临床路径退出数|10|", length = 10, nullable = true)
	private Long outCpNum;

	@Column(name = "COMPLETE_CP_NUM", columnDefinition = "NUMBER|临床路径完成数|10|", length = 10, nullable = true)
	private Long completeCpNum;

	@Column(name = "CURE_CP_NUM", columnDefinition = "NUMBER|临床路径治愈数|10|", length = 10, nullable = true)
	private Long cureCpNum;

	@Column(name = "DEATH_CP_NUM", columnDefinition = "NUMBER|临床路径死亡数|10|", length = 10, nullable = true)
	private Long deathCpNum;

	@Column(name = "PERSONAL_FEE", columnDefinition = "NUMBER|个人费用（住院费用）||", length = 10, nullable = true)
	private BigDecimal personalFee;

	@Column(name = "COOPERATIVE_MEDICAL_FEE", columnDefinition = "NUMBER|医疗保险金额（住院费用）||", length = 10, nullable = true)
	private BigDecimal cooperativeMedicalFee;

	@Column(name = "FEE_TOTAL", columnDefinition = "NUMBER|合计费用（住院费用）||", length = 10, nullable = true)
	private BigDecimal feeTotal;

	@Column(name = "CASE_NUM", columnDefinition = "NUMBER|病案数|10|", length = 10, nullable = true)
	private Long caseNum = 0l;

	@Column(name = "A_CASE_NUM", columnDefinition = "NUMBER|病案质量甲数|10|", length = 10, nullable = true)
	private Long aCaseNum = 0l;

	@Column(name = "B_CASE_NUM", columnDefinition = "NUMBER|病案质量乙数|10|", length = 10, nullable = true)
	private Long bCaseNum = 0l;

	@Column(name = "C_CASE_NUM", columnDefinition = "NUMBER|病案质量丙数|10|", length = 10, nullable = true)
	private Long cCaseNum = 0l;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRpName() {
		return this.rpName;
	}

	public void setRpName(String rpName) {
		this.rpName = rpName;
	}

	public String getGbCode() {
		return this.gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public String getCenterCode() {
		return this.centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getOrganType() {
		return this.organType;
	}

	public void setOrganType(String organType) {
		this.organType = organType;
	}

	public Date getRpDate() {
		return this.rpDate;
	}

	public void setRpDate(Date rpDate) {
		this.rpDate = rpDate;
	}

	public Long getDoctorNum() {
		return this.doctorNum;
	}

	public void setDoctorNum(Long doctorNum) {
		this.doctorNum = doctorNum;
	}

	public Long getInNum() {
		return this.inNum;
	}

	public void setInNum(Long inNum) {
		this.inNum = inNum;
	}

	public Long getBeNum() {
		return this.beNum;
	}

	public void setBeNum(Long beNum) {
		this.beNum = beNum;
	}

	public Long getLeaveNum() {
		return this.leaveNum;
	}

	public void setLeaveNum(Long leaveNum) {
		this.leaveNum = leaveNum;
	}

	public Long getInhospitalDay() {
		return this.inhospitalDay;
	}

	public void setInhospitalDay(Long inhospitalDay) {
		this.inhospitalDay = inhospitalDay;
	}

	public Long getOperationNum() {
		return this.operationNum;
	}

	public void setOperationNum(Long operationNum) {
		this.operationNum = operationNum;
	}

	public Long getAnesthesiaNum() {
		return this.anesthesiaNum;
	}

	public void setAnesthesiaNum(Long anesthesiaNum) {
		this.anesthesiaNum = anesthesiaNum;
	}

	public Long getClinicalPathwayNum() {
		return this.clinicalPathwayNum;
	}

	public void setClinicalPathwayNum(Long clinicalPathwayNum) {
		this.clinicalPathwayNum = clinicalPathwayNum;
	}

	public Long getOutCpNum() {
		return this.outCpNum;
	}

	public void setOutCpNum(Long outCpNum) {
		this.outCpNum = outCpNum;
	}

	public Long getCompleteCpNum() {
		return this.completeCpNum;
	}

	public void setCompleteCpNum(Long completeCpNum) {
		this.completeCpNum = completeCpNum;
	}

	public Long getCureCpNum() {
		return this.cureCpNum;
	}

	public void setCureCpNum(Long cureCpNum) {
		this.cureCpNum = cureCpNum;
	}

	public Long getDeathCpNum() {
		return this.deathCpNum;
	}

	public void setDeathCpNum(Long deathCpNum) {
		this.deathCpNum = deathCpNum;
	}

	public BigDecimal getPersonalFee() {
		return this.personalFee;
	}

	public void setPersonalFee(BigDecimal personalFee) {
		this.personalFee = personalFee;
	}

	public BigDecimal getCooperativeMedicalFee() {
		return this.cooperativeMedicalFee;
	}

	public void setCooperativeMedicalFee(BigDecimal cooperativeMedicalFee) {
		this.cooperativeMedicalFee = cooperativeMedicalFee;
	}

	public BigDecimal getFeeTotal() {
		return this.feeTotal;
	}

	public void setFeeTotal(BigDecimal feeTotal) {
		this.feeTotal = feeTotal;
	}

	public Long getCaseNum() {
		return this.caseNum;
	}

	public void setCaseNum(Long caseNum) {
		this.caseNum = caseNum;
	}

	public Long getaCaseNum() {
		return aCaseNum;
	}

	public void setaCaseNum(Long aCaseNum) {
		this.aCaseNum = aCaseNum;
	}

	public Long getbCaseNum() {
		return bCaseNum;
	}

	public void setbCaseNum(Long bCaseNum) {
		this.bCaseNum = bCaseNum;
	}

	public Long getcCaseNum() {
		return cCaseNum;
	}

	public void setcCaseNum(Long cCaseNum) {
		this.cCaseNum = cCaseNum;
	}

}