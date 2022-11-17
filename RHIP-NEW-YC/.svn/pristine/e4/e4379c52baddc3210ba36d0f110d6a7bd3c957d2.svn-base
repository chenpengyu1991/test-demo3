package com.founder.rhip.im.entity.medical;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 检验结果统计
 */
@Entity
@Table(name="RD_EXAM_ANALYS")
public class RdExamAnalys implements Serializable {

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

	@Column(name="WBC_NUMBER",columnDefinition="NUMBER|白细胞检验人次数|12|",length=12,nullable=true)
	private Integer wbcNumber;

	@Column(name="WBC_LOW_NUMBER",columnDefinition="NUMBER|白细胞偏低人次数|12|",length=12,nullable=true)
	private Integer wbcLowNumber;

	@Column(name="WBC_HIGH_NUMBER",columnDefinition="NUMBER|白细胞偏高人次数|12|",length=12,nullable=true)
	private Integer wbcHighNumber;

	@Column(name="RBC_NUMBER",columnDefinition="NUMBER|红细胞检验人次数|2|",length=2,nullable=true)
	private Integer rbcNumber;

	@Column(name="RBC_LOW_NUMBER",columnDefinition="NUMBER|红细胞偏低人次数|12|",length=12,nullable=true)
	private Integer rbcLowNumber;

	@Column(name="RBC_HIGH_NUMBER",columnDefinition="NUMBER|红细胞偏高人次数|12|",length=12,nullable=true)
	private Integer rbcHighNumber;

	@Column(name="PLT_NUMBER",columnDefinition="NUMBER|血小板检验人次数|12|",length=12,nullable=true)
	private Integer pltNumber;

	@Column(name="PLT_LOW_NUMBER",columnDefinition="NUMBER|血小板偏低人次数|12|",length=12,nullable=true)
	private Integer pltLowNumber;

	@Column(name="PLT_HIGH_NUMBER",columnDefinition="NUMBER|血小板偏高人次数|12|",length=12,nullable=true)
	private Integer pltHighNumber;

	@Column(name="AA_NUMBER",columnDefinition="NUMBER|乙型肝炎抗原检查人数|12|",length=12,nullable=true)
	private Integer aaNumber;

	@Column(name="AA_POSITIVE_NUMBER",columnDefinition="NUMBER|乙型肝炎抗原阳性人数|12|",length=12,nullable=true)
	private Integer aaPositiveNumber;

	@Column(name="CREATE_DATE",columnDefinition="TIMESTAMP|||",nullable=true)
	private Date createDate;

	@Column(name="UPDATE_DATE",columnDefinition="TIMESTAMP|||",nullable=true)
	private Date updateDate;



	public RdExamAnalys(){}
	public RdExamAnalys(String organCode, String organName, String gbCode, String centerCode, String genreCode
			, Integer year, Integer halfYear
			, Integer quarter, Integer month
			, Integer wbcNumber, Integer wbcLowNumber, Integer wbcHighNumber
			, Integer rbcNumber, Integer rbcLowNumber, Integer rbcHighNumber
			, Integer pltNumber, Integer pltLowNumber, Integer pltHighNumber
			, Integer aaNumber, Integer aaPositiveNumber
			, Date yearMonth) {
		super();
		this.organCode = organCode;
		this.organName = organName;
		this.gbCode = gbCode;
		this.centerCode = centerCode;
		this.genreCode = genreCode;
		this.year = year;
		this.halfYear = halfYear;
		this.quarter = quarter;
		this.month = month;
		this.yearMonth = yearMonth;
		this.createDate = new Date();
		this.wbcNumber = wbcNumber;
		this.wbcLowNumber = wbcLowNumber;
		this.wbcHighNumber = wbcHighNumber;
		this.rbcNumber = rbcNumber;
		this.rbcLowNumber = rbcLowNumber;
		this.rbcHighNumber = rbcHighNumber;
		this.pltNumber = pltNumber;
		this.pltLowNumber = pltLowNumber;
		this.pltHighNumber = pltHighNumber;
		this.aaNumber = aaNumber;
		this.aaPositiveNumber = aaPositiveNumber;
	}

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

	public Integer getWbcNumber() {
		return this.wbcNumber;
	}

	public void setWbcNumber(Integer wbcNumber) {
		this.wbcNumber = wbcNumber;
	}

	public Integer getWbcLowNumber() {
		return this.wbcLowNumber;
	}

	public void setWbcLowNumber(Integer wbcLowNumber) {
		this.wbcLowNumber = wbcLowNumber;
	}

	public Integer getWbcHighNumber() {
		return this.wbcHighNumber;
	}

	public void setWbcHighNumber(Integer wbcHighNumber) {
		this.wbcHighNumber = wbcHighNumber;
	}

	public Integer getRbcNumber() {
		return this.rbcNumber;
	}

	public void setRbcNumber(Integer rbcNumber) {
		this.rbcNumber = rbcNumber;
	}

	public Integer getRbcLowNumber() {
		return this.rbcLowNumber;
	}

	public void setRbcLowNumber(Integer rbcLowNumber) {
		this.rbcLowNumber = rbcLowNumber;
	}

	public Integer getRbcHighNumber() {
		return this.rbcHighNumber;
	}

	public void setRbcHighNumber(Integer rbcHighNumber) {
		this.rbcHighNumber = rbcHighNumber;
	}

	public Integer getPltNumber() {
		return this.pltNumber;
	}

	public void setPltNumber(Integer pltNumber) {
		this.pltNumber = pltNumber;
	}

	public Integer getPltLowNumber() {
		return this.pltLowNumber;
	}

	public void setPltLowNumber(Integer pltLowNumber) {
		this.pltLowNumber = pltLowNumber;
	}

	public Integer getPltHighNumber() {
		return this.pltHighNumber;
	}

	public void setPltHighNumber(Integer pltHighNumber) {
		this.pltHighNumber = pltHighNumber;
	}

	public Integer getAaNumber() {
		return this.aaNumber;
	}

	public void setAaNumber(Integer aaNumber) {
		this.aaNumber = aaNumber;
	}

	public Integer getAaPositiveNumber() {
		return this.aaPositiveNumber;
	}

	public void setAaPositiveNumber(Integer aaPositiveNumber) {
		this.aaPositiveNumber = aaPositiveNumber;
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