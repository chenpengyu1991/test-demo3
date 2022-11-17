package com.founder.rhip.ehr.entity.basic;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "BI_FAMILY_INFO_RH")
public class FamilyInfoRh implements Serializable{
	
	private static final long serialVersionUID = 2L;
	
	@Id
	@Column(name = "Id", columnDefinition = "NUMBER|家庭标识|11|", length = 11, nullable = false)
	private long id;
	
	@Column(name = "GBCODE", columnDefinition = "VARCHAR2|原住地12位行政区划代码||", length = 12, nullable = true)
	private String gbCode;
	
	@Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|原住址-乡(镇、街道办事处)||", length = 70, nullable = true)
	private String patownShip;
	
	@Column(name = "INPUT_ORGAN_CODE", columnDefinition = "VARCHAR2|原机构编码||", length = 15, nullable = true)
	private String inputOrganCode;
	
	@Column(name = "RECORD_CHANGE_TIME", columnDefinition = "DATE|迁移时间||", length = 15, nullable = true)
	private Date recordChangeTime;
	
	private String name;
	
	private String idcard;
	
	//现机构编码
    private String currentOrganCode;
    
    //操作者
    private String operator;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGbCode() {
		return gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public String getPatownShip() {
		return patownShip;
	}

	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}

	public String getInputOrganCode() {
		return inputOrganCode;
	}

	public void setInputOrganCode(String inputOrganCode) {
		this.inputOrganCode = inputOrganCode;
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
