package com.founder.rhip.ehr.entity.basic;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ECH_PHYSICAL_EXAM_RECORD_RH")
public class PhysicalExamRecordRh implements Serializable{

	private static final long serialVersionUID = -3457533372566567002L;
	
	@Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;
	
	@Column(name = "INPUT_SUPER_ORGAN_CODE", columnDefinition = "VARCHAR2|上级建档机构编码||", length = 15, nullable = true)
	private String inputSuperOrganCode;
	
	@Column(name = "INPUT_ORGAN_CODE", columnDefinition = "VARCHAR2|原机构编码||", length = 15, nullable = true)
	private String inputOrganCode;
    
	@Column(name = "GBCODE", columnDefinition = "VARCHAR2|原住地12位行政区划代码||", length = 12, nullable = true)
	private String gbCode;
	
	@Column(name = "RECORD_CHANGE_TIME", columnDefinition = "DATE|迁移时间||", nullable = true)
	private Date recordChangeTime;

    private String name;
   
    private String idcard;
    
    private Integer examStatus;
    
    private Date examYear;
    
    //现机构编码
    private String currentOrganCode;
    
    private String operator;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInputSuperOrganCode() {
		return inputSuperOrganCode;
	}

	public void setInputSuperOrganCode(String inputSuperOrganCode) {
		this.inputSuperOrganCode = inputSuperOrganCode;
	}

	public String getInputOrganCode() {
		return inputOrganCode;
	}

	public void setInputOrganCode(String inputOrganCode) {
		this.inputOrganCode = inputOrganCode;
	}

	public String getGbCode() {
		return gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public Date getRecordChangeTime() {
		return recordChangeTime;
	}

	public void setRecordChangeTime(Date recordChangeTime) {
		this.recordChangeTime = recordChangeTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public Integer getExamStatus() {
		return examStatus;
	}

	public void setExamStatus(Integer examStatus) {
		this.examStatus = examStatus;
	}

	public Date getExamYear() {
		return examYear;
	}

	public void setExamYear(Date examYear) {
		this.examYear = examYear;
	}

	public String getCurrentOrganCode() {
		return currentOrganCode;
	}

	public void setCurrentOrganCode(String currentOrganCode) {
		this.currentOrganCode = currentOrganCode;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
}
