package com.founder.rhip.im.entity.medical;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name="RD_INPATIENT_ANALYSE")
public class RdInpatientAnalyse implements Serializable {

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

	@Column(name="LEAVE_NUM",columnDefinition="NUMBER|出院人次数|12|",length=12,nullable=true)
	private Integer leaveNum;

	@Column(name="INHOSPITAL_DAY",columnDefinition="NUMBER|住院天数-合计|12|",length=12,nullable=true)
	private Integer inhospitalDay;

	@Column(name="AVG_INHOSPITAL_DAY",columnDefinition="NUMBER|住院天数-人均||",length=12,scale=12,precision=2,nullable=true)
	private double avgInhospitalDay;

	@Column(name="MED_AMOUNT",columnDefinition="NUMBER|医疗费用-合计||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal medAmount;

	@Column(name="AVG_MED_AMOUNT",columnDefinition="NUMBER|医疗费用-人均||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal avgMedAmount;

	@Column(name="AVG_PER_MED_AMOUNT",columnDefinition="NUMBER|医疗费用-人均每日||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal avgPerMedAmount;

	@Column(name="DRUG_AMOUNT",columnDefinition="NUMBER|药品费用-合计||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal drugAmount;

	@Column(name="AVG_DRUG_AMOUNT",columnDefinition="NUMBER|药品费用-人均||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal avgDrugAmount;

	@Column(name="AVG_PER_DRUG_AMOUNT",columnDefinition="NUMBER|药品费用-人均每日||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal avgPerDrugAmount;

	@Column(name="DRUG_AMOUNT_SACLE",columnDefinition="NUMBER|药品费用-比例||",length=12,scale=12,precision=2,nullable=true)
	private double drugAmountSacle;

	@Column(name="INHOSPITAL_AMOUNT",columnDefinition="NUMBER|住院总费用-总计||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal inhospitalAmount;

	@Column(name="AVG_INHOSPITAL_AMOUNT",columnDefinition="NUMBER|住院总费用-人均||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal avgInhospitalAmount;

	@Column(name="AVG_PER_INHOSPITAL_AMOUNT",columnDefinition="NUMBER|住院总费用-人均每日||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal avgPerInhospitalAmount;

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

	public Integer getLeaveNum() {
		return this.leaveNum;
	}

	public void setLeaveNum(Integer leaveNum) {
		this.leaveNum = leaveNum;
	}

	public Integer getInhospitalDay() {
		return this.inhospitalDay;
	}

	public void setInhospitalDay(Integer inhospitalDay) {
		this.inhospitalDay = inhospitalDay;
	}

	public double getAvgInhospitalDay() {
		return this.avgInhospitalDay;
	}

	public void setAvgInhospitalDay(double avgInhospitalDay) {
		this.avgInhospitalDay = avgInhospitalDay;
	}

	public BigDecimal getMedAmount() {
		return this.medAmount;
	}

	public void setMedAmount(BigDecimal medAmount) {
		this.medAmount = medAmount;
	}

	public BigDecimal getAvgMedAmount() {
		return this.avgMedAmount;
	}

	public void setAvgMedAmount(BigDecimal avgMedAmount) {
		this.avgMedAmount = avgMedAmount;
	}

	public BigDecimal getAvgPerMedAmount() {
		return this.avgPerMedAmount;
	}

	public void setAvgPerMedAmount(BigDecimal avgPerMedAmount) {
		this.avgPerMedAmount = avgPerMedAmount;
	}

	public BigDecimal getDrugAmount() {
		return this.drugAmount;
	}

	public void setDrugAmount(BigDecimal drugAmount) {
		this.drugAmount = drugAmount;
	}

	public BigDecimal getAvgDrugAmount() {
		return this.avgDrugAmount;
	}

	public void setAvgDrugAmount(BigDecimal avgDrugAmount) {
		this.avgDrugAmount = avgDrugAmount;
	}

	public BigDecimal getAvgPerDrugAmount() {
		return this.avgPerDrugAmount;
	}

	public void setAvgPerDrugAmount(BigDecimal avgPerDrugAmount) {
		this.avgPerDrugAmount = avgPerDrugAmount;
	}

	public double getDrugAmountSacle() {
		return this.drugAmountSacle;
	}

	public void setDrugAmountSacle(double drugAmountSacle) {
		this.drugAmountSacle = drugAmountSacle;
	}

	public BigDecimal getInhospitalAmount() {
		return this.inhospitalAmount;
	}

	public void setInhospitalAmount(BigDecimal inhospitalAmount) {
		this.inhospitalAmount = inhospitalAmount;
	}

	public BigDecimal getAvgInhospitalAmount() {
		return this.avgInhospitalAmount;
	}

	public void setAvgInhospitalAmount(BigDecimal avgInhospitalAmount) {
		this.avgInhospitalAmount = avgInhospitalAmount;
	}

	public BigDecimal getAvgPerInhospitalAmount() {
		return this.avgPerInhospitalAmount;
	}

	public void setAvgPerInhospitalAmount(BigDecimal avgPerInhospitalAmount) {
		this.avgPerInhospitalAmount = avgPerInhospitalAmount;
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