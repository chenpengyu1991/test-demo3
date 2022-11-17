package com.founder.rhip.ehr.dto;

import java.io.Serializable;

import javax.persistence.Column;

public class HealthRecordCensus implements Serializable{

    private static final long serialVersionUID = -1398047229946590341L;

    @Column(name = "ID", columnDefinition = "VARCHAR2|uuid|uuid|", length = 50, nullable = false)
    private String id;

    @Column(name = "ORG_CODE", columnDefinition = "VARCHAR2|机构编码|50|", length = 50, nullable = true)
    private String orgCode;

    @Column(name = "ORG_NAME", columnDefinition = "VARCHAR2|机构名称|50|", length = 50, nullable = true)
    private String orgName;

    @Column(name = "YEAR", columnDefinition = "NUMBER|年份|5|", length = 5, nullable = true)
    private Integer year;

    @Column(name = "QUARTER", columnDefinition = "NUMBER|季度|1|", length = 1, nullable = true)
    private Integer quarter;
    
    @Column(name = "GENRE_CODE", columnDefinition = "VARCHAR2|机构类型|50|", length = 50, nullable = true)
    private String genreCode;

    @Column(name = "GB_CODE", columnDefinition = "VARCHAR2|12位行政区划代码|50", length = 50,nullable = true)
    private String gbCode;
	
	@Column(name = "PERMANENT_NUM", columnDefinition = "NUMBER|辖区内常住居民数||", length = 9, nullable = true)
    private Integer permanentNum = 0;
	
	@Column(name = "BUILD_RECORD_NUM", columnDefinition = "NUMBER|建档人数||", length = 9, nullable = true)
    private Integer buildRecordNum = 0;
	
	@Column(name = "BUILD_E_RECORD_NUM", columnDefinition = "NUMBER|建立电子健康档案人数||", length = 9, nullable = true)
    private Integer buildERecordNum = 0;
	
	@Column(name = "DYNAMIC_RECORD_NUM", columnDefinition = "NUMBER|档案中有动态记录的档案份数||", length = 9, nullable = true)
    private Integer dynamicRecordNum = 0;
	
    private String countType;	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getQuarter() {
		return quarter;
	}

	public void setQuarter(Integer quarter) {
		this.quarter = quarter;
	}

	public String getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

	public String getGbCode() {
		return gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public Integer getPermanentNum() {
		return permanentNum;
	}

	public void setPermanentNum(Integer permanentNum) {
		this.permanentNum = permanentNum;
	}

	public Integer getBuildRecordNum() {
		return buildRecordNum;
	}

	public void setBuildRecordNum(Integer buildRecordNum) {
		this.buildRecordNum = buildRecordNum;
	}

	public Integer getBuildERecordNum() {
		return buildERecordNum;
	}

	public void setBuildERecordNum(Integer buildERecordNum) {
		this.buildERecordNum = buildERecordNum;
	}

	public Integer getDynamicRecordNum() {
		return dynamicRecordNum;
	}

	public void setDynamicRecordNum(Integer dynamicRecordNum) {
		this.dynamicRecordNum = dynamicRecordNum;
	}

	public String getCountType() {
		return countType;
	}

	public void setCountType(String countType) {
		this.countType = countType;
	}
	
}
