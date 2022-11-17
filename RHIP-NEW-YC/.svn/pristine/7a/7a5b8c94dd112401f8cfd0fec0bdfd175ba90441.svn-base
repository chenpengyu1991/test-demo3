package com.founder.rhip.ehr.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class ChildStatistical implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -2552671336375808157L;

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
	
	@Column(name = "REPORTING_TIME", columnDefinition = "DATE|填报时间||", nullable = true)
    private Date reportingTime;
	
	@Column(name = "UPDATE_REPORTING_TIME", columnDefinition = "DATE|填报时间||", nullable = true)
    private Date updateReportingTime;
	
	@Column(name = "familyVisitNum", columnDefinition = "NUMBER|推介转诊结核病患者人数||", nullable = true)
    private Integer familyVisitNum=0;
	
	@Column(name = "womenChildNum", columnDefinition = "NUMBER|随访管理结核病患者人数||",  nullable = true)
    private Integer womenChildNum=0;

	@Column(name = "deliveryNum", columnDefinition = "NUMBER|推介转诊结核病患者人数||", nullable = true)
    private Integer deliveryNum=0;
	
	@Column(name = "childExaminationNum", columnDefinition = "NUMBER|随访管理结核病患者人数||",  nullable = true)
    private Integer childExaminationNum=0;
	@Column(name = "createOrganCode", columnDefinition = "VARCHAR2|填报单位编码||", length = 50, nullable = true)
    private String createOrganCode;
	
	public String getCreateOrganCode() {
		return createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	public Integer getFamilyVisitNum() {
		return familyVisitNum;
	}

	public void setFamilyVisitNum(Integer familyVisitNum) {
		this.familyVisitNum = familyVisitNum;
	}

	public Integer getWomenChildNum() {
		return womenChildNum;
	}

	public void setWomenChildNum(Integer womenChildNum) {
		this.womenChildNum = womenChildNum;
	}

	public Integer getDeliveryNum() {
		return deliveryNum;
	}

	public void setDeliveryNum(Integer deliveryNum) {
		this.deliveryNum = deliveryNum;
	}

	public Integer getChildExaminationNum() {
		return childExaminationNum;
	}

	public void setChildExaminationNum(Integer childExaminationNum) {
		this.childExaminationNum = childExaminationNum;
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

	public Date getReportingTime() {
		return reportingTime;
	}

	public void setReportingTime(Date reportingTime) {
		this.reportingTime = reportingTime;
	}

	public Date getUpdateReportingTime() {
		return updateReportingTime;
	}

	public void setUpdateReportingTime(Date updateReportingTime) {
		this.updateReportingTime = updateReportingTime;
	}

	
	
	
}
