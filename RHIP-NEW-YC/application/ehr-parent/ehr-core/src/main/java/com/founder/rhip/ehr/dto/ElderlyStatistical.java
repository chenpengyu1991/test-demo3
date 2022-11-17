package com.founder.rhip.ehr.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class ElderlyStatistical implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;
	
	@Column(name = "ORG_CODE", columnDefinition = "VARCHAR2|填报单位编码||", length = 50, nullable = true)
    private String orgCode;
	
	@Column(name = "ORG_NAME", columnDefinition = "VARCHAR2|填报单位名称||", length = 50, nullable = true)
    private String orgName;
	
	@Column(name = "CENTER_ORG_CODE", columnDefinition = "VARCHAR2|中心名称||", length = 50, nullable = true)
	private String centerOrgCode;		

	@Column(name = "GB_CODE", columnDefinition = "VARCHAR2|区名称||", length = 50, nullable = true)
	private String gbCode;	
	
	@Column(name = "YEAR", columnDefinition = "NUMBER|年||", length = 2, nullable = true)
    private Integer year;
	
	@Column(name = "MONTH", columnDefinition = "NUMBER|月||", length = 2, nullable = true)
    private Integer month;
	
	@Column(name = "resident_Num", columnDefinition = "NUMBER|常住人数||", nullable = true)
    private Integer residentNum=0;
	
	@Column(name = "samsung_Num", columnDefinition = "NUMBER|三星人数||",  nullable = true)
    private Integer samsungNum=0;

	@Column(name = "health_Management_Num", columnDefinition = "NUMBER|接受健康管理人数||", nullable = true)
    private Integer healthManagementNum=0;
	
	@Column(name = "towstar_Num", columnDefinition = "NUMBER|二星人数||",  nullable = true)
    private Integer towstarNum=0;
	@Column(name = "createOrganCode", columnDefinition = "VARCHAR2|填报单位编码||", length = 50, nullable = true)
    private String createOrganCode;
	
	public String getCreateOrganCode() {
		return createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getCenterOrgCode() {
		return centerOrgCode;
	}

	public void setCenterOrgCode(String centerOrgCode) {
		this.centerOrgCode = centerOrgCode;
	}

	public String getGbCode() {
		return gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getResidentNum() {
		return residentNum;
	}

	public void setResidentNum(Integer residentNum) {
		this.residentNum = residentNum;
	}

	public Integer getSamsungNum() {
		return samsungNum;
	}

	public void setSamsungNum(Integer samsungNum) {
		this.samsungNum = samsungNum;
	}

	public Integer getHealthManagementNum() {
		return healthManagementNum;
	}

	public void setHealthManagementNum(Integer healthManagementNum) {
		this.healthManagementNum = healthManagementNum;
	}

	public Integer getTowstarNum() {
		return towstarNum;
	}

	public void setTowstarNum(Integer towstarNum) {
		this.towstarNum = towstarNum;
	}


	
	
	
}
