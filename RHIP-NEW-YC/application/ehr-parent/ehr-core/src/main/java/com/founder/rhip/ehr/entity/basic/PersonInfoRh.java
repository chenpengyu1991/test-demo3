package com.founder.rhip.ehr.entity.basic;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "BI_PERSON_INFO_RH")
public class PersonInfoRh implements Serializable {
	
	private static final long serialVersionUID = 642308985505853018L;

	@Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;
    
	@Column(name = "GBCODE", columnDefinition = "VARCHAR2|原住地12位行政区划代码||", length = 12, nullable = true)
	private String gbCode;
	
	@Column(name = "HRTOWN_SHIP", columnDefinition = "VARCHAR2|户籍地址-乡(镇、街道办事处)||", length = 70, nullable = true)
	private String hrtownShip;
	
	@Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|原住址-乡(镇、街道办事处)||", length = 70, nullable = true)
	private String patownShip;
	
	@Column(name = "INPUT_CENTER_ORGAN_CODE", columnDefinition = "VARCHAR2|上级建档机构编码||", length = 15, nullable = true)
	private String inputCenterOrganCode;
	
	@Column(name = "INPUT_GBCODE", columnDefinition = "VARCHAR2|原住地12位行政区划代码||", length = 12, nullable = true)
	private String inputGbcode;
	
	@Column(name = "RECORD_CHANGE_TIME", columnDefinition = "DATE|迁移时间||", nullable = true)
	private Date recordChangeTime;

	@Column(name = "INPUT_ORGAN_CODE", columnDefinition = "VARCHAR2|原机构编码||", length = 15, nullable = true)
	private String inputOrganCode;

    private String name;
   
    private String idcard;
    
    //现机构编码
    private String currentOrganCode;
    
    private String operator;
    
    private String villageName;
    
    private Date manageTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGbCode() {
		return gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public String getHrtownShip() {
		return hrtownShip;
	}

	public void setHrtownShip(String hrtownShip) {
		this.hrtownShip = hrtownShip;
	}

	public String getPatownShip() {
		return patownShip;
	}

	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}

	public String getInputCenterOrganCode() {
		return inputCenterOrganCode;
	}

	public void setInputCenterOrganCode(String inputCenterOrganCode) {
		this.inputCenterOrganCode = inputCenterOrganCode;
	}

	public String getInputGbcode() {
		return inputGbcode;
	}

	public void setInputGbcode(String inputGbcode) {
		this.inputGbcode = inputGbcode;
	}

	public Date getRecordChangeTime() {
		return recordChangeTime;
	}

	public void setRecordChangeTime(Date recordChangeTime) {
		this.recordChangeTime = recordChangeTime;
	}

	public String getInputOrganCode() {
		return inputOrganCode;
	}

	public void setInputOrganCode(String inputOrganCode) {
		this.inputOrganCode = inputOrganCode;
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

	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	public Date getManageTime() {
		return manageTime;
	}

	public void setManageTime(Date manageTime) {
		this.manageTime = manageTime;
	}
	
}
