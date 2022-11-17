package com.founder.rhip.im.entity;

import javax.persistence.Column;
import java.util.Date;

/**
 * 报表实体基类
 */
public abstract class ReportBaseEntity {

	@Column(name="ORGAN_CODE",columnDefinition="VARCHAR2|机构代码|20|",length=20,nullable=false)
	private String organCode;

	@Column(name="ORGAN_NAME",columnDefinition="VARCHAR2|机构名称|100|",length=100,nullable=false)
	private String organName;

	@Column(name="GB_CODE",columnDefinition="VARCHAR2|镇—行政区划代码|20|",length=20,nullable=false)
	private String gbCode;

	@Column(name="CENTER_CODE",columnDefinition="VARCHAR2|中心—行政区划代码|20|",length=20,nullable=false)
	private String centerCode;

	@Column(name="GENRE_CODE",columnDefinition="VARCHAR2|机构类型|50|",length=50,nullable=true)
	private String genreCode;

	@Column(name="YEAR_MONTH",columnDefinition="DATE|日期—格式YYYY-MM||",nullable=true)
	private Date yearMonth;

	@Column(name="YEAR",columnDefinition="NUMBER|年度|4|",length=4,nullable=false)
	private Integer year;

	@Column(name="HALF_YEAR",columnDefinition="NUMBER|半年|1|",length=1,nullable=false)
	private Integer halfYear;

	@Column(name="QUARTER",columnDefinition="NUMBER|季度|1|",length=1,nullable=false)
	private Integer quarter;

	@Column(name="MONTH",columnDefinition="NUMBER|月度|2|",length=2,nullable=false)
	private Integer month;

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
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

	public String getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

	public Date getYearMonth() {
		return yearMonth;
	}

	public void setYearMonth(Date yearMonth) {
		this.yearMonth = yearMonth;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getHalfYear() {
		return halfYear;
	}

	public void setHalfYear(Integer halfYear) {
		this.halfYear = halfYear;
	}

	public Integer getQuarter() {
		return quarter;
	}

	public void setQuarter(Integer quarter) {
		this.quarter = quarter;
	}


}