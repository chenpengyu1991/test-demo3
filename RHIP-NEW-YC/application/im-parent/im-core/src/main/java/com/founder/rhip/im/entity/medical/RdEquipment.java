package com.founder.rhip.im.entity.medical;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name="RD_EQUIPMENT")
public class RdEquipment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|业务主键|11|",length=11,nullable=false)
	private Long id;

	@Column(name="ORGAN_CODE",columnDefinition="VARCHAR2|机构代码|20|",length=20,nullable=true)
	private String organCode;

	@Column(name="ORGAN_NAME",columnDefinition="VARCHAR2|机构名称|100|",length=100,nullable=true)
	private String organName;

	@Column(name="GB_CODE",columnDefinition="VARCHAR2|镇—行政区划代码|20|",length=20,nullable=true)
	private String gbCode;

	@Column(name="CENTER_CODE",columnDefinition="VARCHAR2|中心—行政区划代码|20|",length=20,nullable=true)
	private String centerCode;

	@Column(name="GENRE_CODE",columnDefinition="VARCHAR2|机构类型|50|",length=50,nullable=true)
	private String genreCode;

	@Column(name="YEAR_MONTH",columnDefinition="DATE|日期—格式YYYY-MM||",nullable=true)
	private Date yearMonth;

	@Column(name="YEAR",columnDefinition="NUMBER|年度|4|",length=4,nullable=true)
	private Integer year;

	@Column(name="HALF_YEAR",columnDefinition="NUMBER|半年|1|",length=1,nullable=true)
	private Integer halfYear;

	@Column(name="QUARTER",columnDefinition="NUMBER|季度|1|",length=1,nullable=true)
	private Integer quarter;

	@Column(name="MONTH",columnDefinition="NUMBER|月度|2|",length=2,nullable=true)
	private Integer month;

	@Column(name="REPORT_TYPE",columnDefinition="NUMBER|报表类型（1：日报；2：月报）|2|",length=2,nullable=true)
	private Integer reportType;

	@Column(name="TYPE_ONE_NUM",columnDefinition="NUMBER|万元以上设备总台数|12|",length=12,nullable=true)
	private Integer typeOneNum;

	@Column(name="TYPE_ONE_COST",columnDefinition="NUMBER|万元以上设备总价值||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal typeOneCost;

	@Column(name="TYPE_TWO_NUM",columnDefinition="NUMBER|10-49万设备台数|12|",length=12,nullable=true)
	private Integer typeTwoNum;

	@Column(name="TYPE_THREE_NUM",columnDefinition="NUMBER|50-99万设备台数|12|",length=12,nullable=true)
	private Integer typeThreeNum;

	@Column(name="TYPE_FOUR_NUM",columnDefinition="NUMBER|100万以上设备台数|12|",length=12,nullable=true)
	private Integer typeFourNum;

	@Column(name="CREATE_DATE",columnDefinition="TIMESTAMP|创建时间||",nullable=true)
	private Date createDate;

	@Column(name="UPDATE_DATE",columnDefinition="TIMESTAMP|更新时间||",nullable=true)
	private Date updateDate;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getOrganName() {
		return this.organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getGbCode() {
		return this.gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public String getCenterCode() {
		return this.centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public String getGenreCode() {
		return this.genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

	public Date getYearMonth() {
		return this.yearMonth;
	}

	public void setYearMonth(Date yearMonth) {
		this.yearMonth = yearMonth;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getHalfYear() {
		return this.halfYear;
	}

	public void setHalfYear(Integer halfYear) {
		this.halfYear = halfYear;
	}

	public Integer getQuarter() {
		return this.quarter;
	}

	public void setQuarter(Integer quarter) {
		this.quarter = quarter;
	}

	public Integer getMonth() {
		return this.month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getReportType() {
		return this.reportType;
	}

	public void setReportType(Integer reportType) {
		this.reportType = reportType;
	}

	public Integer getTypeOneNum() {
		return this.typeOneNum;
	}

	public void setTypeOneNum(Integer typeOneNum) {
		this.typeOneNum = typeOneNum;
	}

	public BigDecimal getTypeOneCost() {
		return this.typeOneCost;
	}

	public void setTypeOneCost(BigDecimal typeOneCost) {
		this.typeOneCost = typeOneCost;
	}

	public Integer getTypeTwoNum() {
		return this.typeTwoNum;
	}

	public void setTypeTwoNum(Integer typeTwoNum) {
		this.typeTwoNum = typeTwoNum;
	}

	public Integer getTypeThreeNum() {
		return this.typeThreeNum;
	}

	public void setTypeThreeNum(Integer typeThreeNum) {
		this.typeThreeNum = typeThreeNum;
	}

	public Integer getTypeFourNum() {
		return this.typeFourNum;
	}

	public void setTypeFourNum(Integer typeFourNum) {
		this.typeFourNum = typeFourNum;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}