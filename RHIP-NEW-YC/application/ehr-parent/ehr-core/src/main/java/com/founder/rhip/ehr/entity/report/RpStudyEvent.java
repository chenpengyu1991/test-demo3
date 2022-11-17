package com.founder.rhip.ehr.entity.report;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "RP_STUDY_EVENT")
public class RpStudyEvent implements Serializable {

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

	@Column(name = "STUDY_NUM", columnDefinition = "NUMBER|检查人次数|10|", length = 10, nullable = true)
	private Long studyNum;

	@Column(name = "STUDY_CODE", columnDefinition = "VARCHAR2|检查类别code|50|", length = 50, nullable = true)
	private String studyCode;

	@Column(name = "STUDY_NAME", columnDefinition = "VARCHAR2|检查类别|5|", length = 5, nullable = true)
	private String studyName;

	@Transient
	private Long countBus;
	
	@Transient
	private Long countCt;
	
	@Transient
	private Long countEcg;
	
	@Transient
	private Long countCxr;
	
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

	public Long getStudyNum() {
		return studyNum;
	}

	public void setStudyNum(Long studyNum) {
		this.studyNum = studyNum;
	}

	public String getStudyCode() {
		return studyCode;
	}

	public void setStudyCode(String studyCode) {
		this.studyCode = studyCode;
	}

	public String getStudyName() {
		return studyName;
	}

	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}

	public Long getCountBus() {
		return countBus;
	}

	public void setCountBus(Long countBus) {
		this.countBus = countBus;
	}

	public Long getCountCt() {
		return countCt;
	}

	public void setCountCt(Long countCt) {
		this.countCt = countCt;
	}

	public Long getCountEcg() {
		return countEcg;
	}

	public void setCountEcg(Long countEcg) {
		this.countEcg = countEcg;
	}

	public Long getCountCxr() {
		return countCxr;
	}

	public void setCountCxr(Long countCxr) {
		this.countCxr = countCxr;
	}
	
}