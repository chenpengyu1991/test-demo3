package com.founder.rhip.im.entity.medical;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name="RD_OUTPATIENT_ANALYSE")
public class RdOutpatientAnalyse implements Serializable {

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

	@Column(name="OUTPATIENT_CLINIC_NUM",columnDefinition="NUMBER|门诊人次|12|",length=12,nullable=true)
	private Integer outpatientClinicNum;

	@Column(name="REG_AMOUNT",columnDefinition="NUMBER|挂号费用-金额||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal regAmount;

	@Column(name="REG_SCALE",columnDefinition="NUMBER|挂号费用-比例||",length=12,scale=12,precision=2,nullable=true)
	private double regScale;

	@Column(name="MED_AMOUNT",columnDefinition="NUMBER|医疗费用-金额||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal medAmount;

	@Column(name="MED_SCALE",columnDefinition="NUMBER|医疗费用-比例||",length=12,scale=12,precision=2,nullable=true)
	private double medScale;

	@Column(name="DRUG_AMOUNT",columnDefinition="NUMBER|药品费用-金额||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal drugAmount;

	@Column(name="DRUG_SCALE",columnDefinition="NUMBER|药品费用-比例||",length=12,scale=12,precision=2,nullable=true)
	private double drugScale;

	@Column(name="TOTAL_AMOUNT",columnDefinition="NUMBER|金额合计||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal totalAmount;

	@Column(name="PER_AMOUNT",columnDefinition="NUMBER|每门诊人次费用||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal perAmount;

	@Column(name="PER_DRUG_AMOUNT",columnDefinition="NUMBER|每门诊人次药费-金额||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal perDrugAmount;

	@Column(name="PER_DRUG_SCALE",columnDefinition="NUMBER|每门诊人次药费-比例||",length=12,scale=12,precision=2,nullable=true)
	private double perDrugScale;

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

	public Integer getOutpatientClinicNum() {
		return this.outpatientClinicNum;
	}

	public void setOutpatientClinicNum(Integer outpatientClinicNum) {
		this.outpatientClinicNum = outpatientClinicNum;
	}

	public BigDecimal getRegAmount() {
		return this.regAmount;
	}

	public void setRegAmount(BigDecimal regAmount) {
		this.regAmount = regAmount;
	}

	public double getRegScale() {
		return this.regScale;
	}

	public void setRegScale(double regScale) {
		this.regScale = regScale;
	}

	public BigDecimal getMedAmount() {
		return this.medAmount;
	}

	public void setMedAmount(BigDecimal medAmount) {
		this.medAmount = medAmount;
	}

	public double getMedScale() {
		return this.medScale;
	}

	public void setMedScale(double medScale) {
		this.medScale = medScale;
	}

	public BigDecimal getDrugAmount() {
		return this.drugAmount;
	}

	public void setDrugAmount(BigDecimal drugAmount) {
		this.drugAmount = drugAmount;
	}

	public double getDrugScale() {
		return this.drugScale;
	}

	public void setDrugScale(double drugScale) {
		this.drugScale = drugScale;
	}

	public BigDecimal getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getPerAmount() {
		return this.perAmount;
	}

	public void setPerAmount(BigDecimal perAmount) {
		this.perAmount = perAmount;
	}

	public BigDecimal getPerDrugAmount() {
		return this.perDrugAmount;
	}

	public void setPerDrugAmount(BigDecimal perDrugAmount) {
		this.perDrugAmount = perDrugAmount;
	}

	public double getPerDrugScale() {
		return this.perDrugScale;
	}

	public void setPerDrugScale(double perDrugScale) {
		this.perDrugScale = perDrugScale;
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