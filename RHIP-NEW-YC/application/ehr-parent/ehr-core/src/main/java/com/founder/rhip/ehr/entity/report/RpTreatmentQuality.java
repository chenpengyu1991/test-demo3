package com.founder.rhip.ehr.entity.report;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RP_TREATMENT_QUALITY")
public class RpTreatmentQuality implements Serializable {

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

	@Column(name = "INHOSPITAL_DEATH_NUM", columnDefinition = "NUMBER|住院死亡数|10|", length = 10, nullable = true)
	private Long inhospitalDeathNum = 0l;

	@Column(name = "AUTO_LEAVE_NUM", columnDefinition = "NUMBER|自动出院数|10|", length = 10, nullable = true)
	private Long autoLeaveNum = 0l;

	@Column(name = "INHOSPITAL_SURGERY_NUM", columnDefinition = "NUMBER|住院手术数|10|", length = 10, nullable = true)
	private Long inhospitalSurgeryNum = 0l;

	@Column(name = "OPERATIVE_DEATH_NUM", columnDefinition = "NUMBER|手术死亡数|10|", length = 10, nullable = true)
	private Long operativeDeathNum = 0l;

	@Column(name = "CRITICAL_RESCUE_NUM", columnDefinition = "NUMBER|危重抢救数|10|", length = 10, nullable = true)
	private Long criticalRescueNum = 0l;

	@Column(name = "CRITICAL_DEATH_NUM", columnDefinition = "NUMBER|危重死亡数|10|", length = 10, nullable = true)
	private Long criticalDeathNum = 0l;

	@Column(name = "NEONATAL_DEATH_NUM", columnDefinition = "NUMBER|新生儿死亡数|10|", length = 10, nullable = true)
	private Long neonatalDeathNum = 0l;

	@Column(name = "NEWBORN_NUM", columnDefinition = "NUMBER|新生儿数|10|", length = 10, nullable = true)
	private Long newbornNum = 0l;

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

	public Long getInhospitalDeathNum() {
		return inhospitalDeathNum;
	}

	public void setInhospitalDeathNum(Long inhospitalDeathNum) {
		this.inhospitalDeathNum = inhospitalDeathNum;
	}

	public Long getAutoLeaveNum() {
		return autoLeaveNum;
	}

	public void setAutoLeaveNum(Long autoLeaveNum) {
		this.autoLeaveNum = autoLeaveNum;
	}

	public Long getInhospitalSurgeryNum() {
		return inhospitalSurgeryNum;
	}

	public void setInhospitalSurgeryNum(Long inhospitalSurgeryNum) {
		this.inhospitalSurgeryNum = inhospitalSurgeryNum;
	}

	public Long getOperativeDeathNum() {
		return operativeDeathNum;
	}

	public void setOperativeDeathNum(Long operativeDeathNum) {
		this.operativeDeathNum = operativeDeathNum;
	}

	public Long getCriticalRescueNum() {
		return criticalRescueNum;
	}

	public void setCriticalRescueNum(Long criticalRescueNum) {
		this.criticalRescueNum = criticalRescueNum;
	}

	public Long getCriticalDeathNum() {
		return criticalDeathNum;
	}

	public void setCriticalDeathNum(Long criticalDeathNum) {
		this.criticalDeathNum = criticalDeathNum;
	}

	public Long getNeonatalDeathNum() {
		return neonatalDeathNum;
	}

	public void setNeonatalDeathNum(Long neonatalDeathNum) {
		this.neonatalDeathNum = neonatalDeathNum;
	}

	public Long getNewbornNum() {
		return newbornNum;
	}

	public void setNewbornNum(Long newbornNum) {
		this.newbornNum = newbornNum;
	}

}