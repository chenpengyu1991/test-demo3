package com.founder.rhip.ehr.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class ChildCensus implements Serializable{

	private static final long serialVersionUID = -7343705244872948203L;

	@Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;
	
	@Column(name = "CENTER_ORG_CODE", columnDefinition = "VARCHAR2|中心名称||", length = 50, nullable = true)
	private String centerOrgCode;
	
	@Column(name = "orgCode", columnDefinition = "VARCHAR2|填报单位编码||", length = 50, nullable = true)
    private String orgCode;
	
	@Column(name = "ORG_NAME", columnDefinition = "VARCHAR2|填报单位名称||", length = 50, nullable = true)
    private String orgName;
	
	@Column(name = "GB_CODE", columnDefinition = "VARCHAR2|区名称||", length = 50, nullable = true)
	private String gbCode;	
	
	@Column(name = "YEAR", columnDefinition = "NUMBER|年||", length = 2, nullable = true)
    private Integer year;
	
	@Column(name = "MONTH", columnDefinition = "NUMBER|月||", length = 2, nullable = true)
    private Integer month;
	
	@Column(name = "REPORTING_TIME", columnDefinition = "DATE|填报时间||", nullable = true)
    private Date reportingTime;
	
	@Column(name = "deathCount", columnDefinition = "NUMBER|儿童死亡报告卡||", nullable = true)
    private Integer deathCount=0;
	
	@Column(name = "visitCount", columnDefinition = "NUMBER|新生儿访视人次数||", nullable = true)
    private Integer visitCount=0;
	
	@Column(name = "examineCount1", columnDefinition = "NUMBER|1-8月龄儿童健康检查人次数||", nullable = true)
    private Integer examineCount1=0;
	
	@Column(name = "examineCount2", columnDefinition = "NUMBER|12-30月龄儿童健康检查人次数||", nullable = true)
    private Integer examineCount2=0;
	
	@Column(name = "examineCount6", columnDefinition = "NUMBER|3-6岁龄儿童健康检查人次数||", nullable = true)
    private Integer examineCount6=0;
	
	@Column(name = "tcmCount1", columnDefinition = "NUMBER|1-8月中医药健康管理儿童数||", nullable = true)
    private Integer tcmCount1=0;
	
	@Column(name = "tcmCount2", columnDefinition = "NUMBER|12-30月中医药健康管理儿童数||", nullable = true)
    private Integer tcmCount2=0;

	@Column(name = "tcmCount6", columnDefinition = "NUMBER|3-6岁中医药健康管理儿童数||", nullable = true)
    private Integer tcmCount6=0;

	private Integer deathSum=0;
	private Integer visitSum=0;
	private Integer examineSum1=0;
	private Integer examineSum2=0;
	private Integer examineSum6=0;
	
	private Integer tcmSum1=0;
	private Integer tcmSum2=0;
	private Integer tcmSum6=0;
	
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

	public Integer getDeathSum() {
		return deathSum;
	}

	public void setDeathSum(Integer deathSum) {
		this.deathSum = deathSum;
	}

	public Integer getVisitSum() {
		return visitSum;
	}

	public void setVisitSum(Integer visitSum) {
		this.visitSum = visitSum;
	}

	public Integer getExamineSum1() {
		return examineSum1;
	}

	public void setExamineSum1(Integer examineSum1) {
		this.examineSum1 = examineSum1;
	}

	public Integer getExamineSum2() {
		return examineSum2;
	}

	public void setExamineSum2(Integer examineSum2) {
		this.examineSum2 = examineSum2;
	}

	public Integer getExamineSum6() {
		return examineSum6;
	}

	public void setExamineSum6(Integer examineSum6) {
		this.examineSum6 = examineSum6;
	}

	public Integer getTcmSum1() {
		return tcmSum1;
	}

	public void setTcmSum1(Integer tcmSum1) {
		this.tcmSum1 = tcmSum1;
	}

	public Integer getTcmSum2() {
		return tcmSum2;
	}

	public void setTcmSum2(Integer tcmSum2) {
		this.tcmSum2 = tcmSum2;
	}

	public Integer getTcmSum6() {
		return tcmSum6;
	}

	public void setTcmSum6(Integer tcmSum6) {
		this.tcmSum6 = tcmSum6;
	}

	public Integer getDeathCount() {
		return deathCount;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getGbCode() {
		return gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public void setDeathCount(Integer deathCount) {
		this.deathCount = deathCount;
	}

	public Integer getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(Integer visitCount) {
		this.visitCount = visitCount;
	}

	public Integer getExamineCount1() {
		return examineCount1;
	}

	public void setExamineCount1(Integer examineCount1) {
		this.examineCount1 = examineCount1;
	}

	public Integer getExamineCount2() {
		return examineCount2;
	}

	public void setExamineCount2(Integer examineCount2) {
		this.examineCount2 = examineCount2;
	}

	public Integer getExamineCount6() {
		return examineCount6;
	}

	public void setExamineCount6(Integer examineCount6) {
		this.examineCount6 = examineCount6;
	}

	public Integer getTcmCount1() {
		return tcmCount1;
	}

	public void setTcmCount1(Integer tcmCount1) {
		this.tcmCount1 = tcmCount1;
	}

	public Integer getTcmCount2() {
		return tcmCount2;
	}

	public void setTcmCount2(Integer tcmCount2) {
		this.tcmCount2 = tcmCount2;
	}

	public Integer getTcmCount6() {
		return tcmCount6;
	}

	public void setTcmCount6(Integer tcmCount6) {
		this.tcmCount6 = tcmCount6;
	}

	public String getCenterOrgCode() {
		return centerOrgCode;
	}

	public void setCenterOrgCode(String centerOrgCode) {
		this.centerOrgCode = centerOrgCode;
	}

}
