package com.founder.rhip.ehr.entity.report;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RP_VACCINATION")
public class RpVaccination implements Serializable {


	private static final long serialVersionUID = 998658136606316735L;

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
	
	@Column(name = "RP_DATE", columnDefinition = "VARCHAR2|接种日期||", nullable = true)
	private Date rpDate;
	
	@Column(name = "DOCTOR_NUM", columnDefinition = "NUMBER|医技人员数量||", length = 5, nullable = true)
	private Long doctorNum;
	
	@Column(name = "VACCINATION_NUM", columnDefinition = "NUMBER|接种人数||", length = 5, nullable = true)
	private Long vaccinationNum;

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

	public Long getVaccinationNum() {
		return vaccinationNum;
	}

	public void setVaccinationNum(Long vaccinationNum) {
		this.vaccinationNum = vaccinationNum;
	}

	
	
}
