package com.founder.rhip.ehr.entity.report;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "RP_EXAMINATION")
public class RpExaminationEvent implements Serializable {

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

	@Column(name = "EXAMINATION_NUM", columnDefinition = "NUMBER|检验人次数|10|", length = 10, nullable = true)
	private Long examinationNum;

	@Column(name = "EXAMINATION_CODE", columnDefinition = "VARCHAR2|检验大类code|50|", length = 50, nullable = true)
	private String examinationCode;

	@Column(name = "EXAMINATION_NAME", columnDefinition = "VARCHAR2|检验大类|5|", length = 5, nullable = true)
	private String examinationName;
	
	@Column(name = "EXAMINATION_DETAIL_CODE", columnDefinition = "VARCHAR2|检验细项code|50|", length = 50, nullable = true)
	private String examinationDetailCode;

	@Column(name = "EXAMINATION_DETAIL_NAME", columnDefinition = "VARCHAR2|检验细项|5|", length = 5, nullable = true)
	private String examinationDetailName;
	
	@Column(name = "RESULT_LOW", columnDefinition = "NUMBER|结果偏低|10|", length = 10, nullable = true)
	private Long resultLow;
	
	@Column(name = "RESULT_HIGH", columnDefinition = "NUMBER|结果偏高|10|", length = 10, nullable = true)
	private Long resultHigh;
	
	@Column(name = "RESULT_NORMAL", columnDefinition = "NUMBER|结果正常|10|", length = 10, nullable = true)
	private Long resultNormal;

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

	public Long getExaminationNum() {
		return examinationNum;
	}

	public void setExaminationNum(Long examinationNum) {
		this.examinationNum = examinationNum;
	}

	public String getExaminationCode() {
		return examinationCode;
	}

	public void setExaminationCode(String examinationCode) {
		this.examinationCode = examinationCode;
	}

	public String getExaminationName() {
		return examinationName;
	}

	public void setExaminationName(String examinationName) {
		this.examinationName = examinationName;
	}

	public String getExaminationDetailCode() {
		return examinationDetailCode;
	}

	public void setExaminationDetailCode(String examinationDetailCode) {
		this.examinationDetailCode = examinationDetailCode;
	}

	public String getExaminationDetailName() {
		return examinationDetailName;
	}

	public void setExaminationDetailName(String examinationDetailName) {
		this.examinationDetailName = examinationDetailName;
	}

	public Long getResultLow() {
		return resultLow;
	}

	public void setResultLow(Long resultLow) {
		this.resultLow = resultLow;
	}

	public Long getResultHigh() {
		return resultHigh;
	}

	public void setResultHigh(Long resultHigh) {
		this.resultHigh = resultHigh;
	}

	public Long getResultNormal() {
		return resultNormal;
	}

	public void setResultNormal(Long resultNormal) {
		this.resultNormal = resultNormal;
	}
	
}