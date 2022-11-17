package com.founder.rhip.ehr.entity.report;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RP_CHILD_HEALTHCARE")
public class RpChildHealthcare implements Serializable {


	private static final long serialVersionUID = 1828408179933745936L;
	
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
	
	@Column(name = "RP_DATE", columnDefinition = "VARCHAR2|统计日期||", nullable = true)
	private Date rpDate;
	
	@Column(name = "DOCTOR_NUM", columnDefinition = "NUMBER|医技人员数||", length = 10, nullable = true)
	private Long doctorNum;

	@Column(name = "NEONATES_VISIT_NUM", columnDefinition = "NUMBER|新生儿访视数||", length = 10, nullable = true)
	private Long neonatesVisitNum;
	
	@Column(name = "PKU_SCREENING_NUM", columnDefinition = "NUMBER|苯丙酮尿症筛查数||", length = 10, nullable = true)
	private Long pkuScreeningNum;
	
	@Column(name = "HYPOTHYROIDISM_SCREENING_NUM", columnDefinition = "NUMBER|甲状腺功能减低症筛查数||", length = 10, nullable = true)
	private Long hypothyroidismScreeningNum;
	
	@Column(name = "HEARING_SCREENING_NUM", columnDefinition = "NUMBER|听力筛查数||", length = 10, nullable = true)
	private Long hearingScreeningNum;
	
	@Column(name = "SYSTEM_MANAGEMENT_NUM", columnDefinition = "NUMBER|3岁以下系统管理数||", length = 10, nullable = true)
	private Long systemManagementNum;
	
	@Column(name = "HEALTH_CARE_COVERAGE_NUM", columnDefinition = "NUMBER|7岁以下保健覆盖数||", length = 10, nullable = true)
	private Long healthCareCoverageNum;
	
	@Column(name = "WEIGHT_CHECK_NUM", columnDefinition = "NUMBER|体重检查人数||", length = 10, nullable = true)
	private Long weightCheckNum;
	
	@Column(name = "MEDIAN_NUM", columnDefinition = "NUMBER|体重<（中位数—2SD）的人数||", length = 10, nullable = true)
	private Long medianNum;
	
	@Column(name = "HGB_CHECK_NUM", columnDefinition = "NUMBER|血红蛋白检查人数||", length = 10, nullable = true)
	private Long hgbCheckNum;
	
	@Column(name = "SEVERE_ANEMIA_NUM", columnDefinition = "NUMBER|中重度贫血人数||", length = 10, nullable = true)
	private Long severeAnemiaNum;

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

	public Date getRpDate() {
		return rpDate;
	}

	public void setRpDate(Date rpDate) {
		this.rpDate = rpDate;
	}

	public Long getDoctorNum() {
		return doctorNum;
	}

	public void setDoctorNum(Long doctorNum) {
		this.doctorNum = doctorNum;
	}

	public Long getNeonatesVisitNum() {
		return neonatesVisitNum;
	}

	public void setNeonatesVisitNum(Long neonatesVisitNum) {
		this.neonatesVisitNum = neonatesVisitNum;
	}

	public Long getPkuScreeningNum() {
		return pkuScreeningNum;
	}

	public void setPkuScreeningNum(Long pkuScreeningNum) {
		this.pkuScreeningNum = pkuScreeningNum;
	}

	public Long getHypothyroidismScreeningNum() {
		return hypothyroidismScreeningNum;
	}

	public void setHypothyroidismScreeningNum(Long hypothyroidismScreeningNum) {
		this.hypothyroidismScreeningNum = hypothyroidismScreeningNum;
	}

	public Long getHearingScreeningNum() {
		return hearingScreeningNum;
	}

	public void setHearingScreeningNum(Long hearingScreeningNum) {
		this.hearingScreeningNum = hearingScreeningNum;
	}

	public Long getSystemManagementNum() {
		return systemManagementNum;
	}

	public void setSystemManagementNum(Long systemManagementNum) {
		this.systemManagementNum = systemManagementNum;
	}

	public Long getHealthCareCoverageNum() {
		return healthCareCoverageNum;
	}

	public void setHealthCareCoverageNum(Long healthCareCoverageNum) {
		this.healthCareCoverageNum = healthCareCoverageNum;
	}

	public Long getWeightCheckNum() {
		return weightCheckNum;
	}

	public void setWeightCheckNum(Long weightCheckNum) {
		this.weightCheckNum = weightCheckNum;
	}

	public Long getMedianNum() {
		return medianNum;
	}

	public void setMedianNum(Long medianNum) {
		this.medianNum = medianNum;
	}

	public Long getHgbCheckNum() {
		return hgbCheckNum;
	}

	public void setHgbCheckNum(Long hgbCheckNum) {
		this.hgbCheckNum = hgbCheckNum;
	}

	public Long getSevereAnemiaNum() {
		return severeAnemiaNum;
	}

	public void setSevereAnemiaNum(Long severeAnemiaNum) {
		this.severeAnemiaNum = severeAnemiaNum;
	}
	
	
	
}
