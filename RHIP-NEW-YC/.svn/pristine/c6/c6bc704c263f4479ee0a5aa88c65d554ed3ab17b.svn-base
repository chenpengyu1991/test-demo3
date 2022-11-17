package com.founder.rhip.ehr.entity.report;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RP_PREMARITAL_EXAMINATION")
public class RpPremaritalExamination implements Serializable {

	private static final long serialVersionUID = 969583323259984485L;
	
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
	
	@Column(name = "GESTATIONAL_WOMEN_NUM", columnDefinition = "NUMBER|育龄妇女登记数||", length = 10, nullable = true)
	private Long gestationalWomenNum;
	
	@Column(name = "SCREENING_WOMEN_NUM", columnDefinition = "NUMBER|妇女疾病筛查数||", length = 10, nullable = true)
	private Long screeningWomenNum;
	
	@Column(name = "MALE_PREMARITAL_NUM", columnDefinition = "NUMBER|女性婚检人数||", length = 10, nullable = true)
	private Long malePremaritalNum;
	
	@Column(name = "FEMALE_PREMARITAL_NUM", columnDefinition = "NUMBER|男性婚检人数||", length = 10, nullable = true)
	private Long femalePremaritalNum;
	
	@Column(name = "PREMARITAL_NUM", columnDefinition = "NUMBER|婚检人数||", length = 10, nullable = true)
	private Long premaritalNum;

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

	public Long getGestationalWomenNum() {
		return gestationalWomenNum;
	}

	public void setGestationalWomenNum(Long gestationalWomenNum) {
		this.gestationalWomenNum = gestationalWomenNum;
	}

	public Long getScreeningWomenNum() {
		return screeningWomenNum;
	}

	public void setScreeningWomenNum(Long screeningWomenNum) {
		this.screeningWomenNum = screeningWomenNum;
	}

	public Long getMalePremaritalNum() {
		return malePremaritalNum;
	}

	public void setMalePremaritalNum(Long malePremaritalNum) {
		this.malePremaritalNum = malePremaritalNum;
	}

	public Long getFemalePremaritalNum() {
		return femalePremaritalNum;
	}

	public void setFemalePremaritalNum(Long femalePremaritalNum) {
		this.femalePremaritalNum = femalePremaritalNum;
	}

	public Long getPremaritalNum() {
		return premaritalNum;
	}

	public void setPremaritalNum(Long premaritalNum) {
		this.premaritalNum = premaritalNum;
	}


}
