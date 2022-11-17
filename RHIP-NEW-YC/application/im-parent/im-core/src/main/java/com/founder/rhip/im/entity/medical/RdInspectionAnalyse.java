package com.founder.rhip.im.entity.medical;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name="RD_INSPECTION_ANALYSE")
public class RdInspectionAnalyse implements Serializable {

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

	@Column(name="INSPECTION_NUM",columnDefinition="NUMBER|检查总人次|12|",length=12,nullable=true)
	private Integer inspectionNum;

	@Column(name="OUT_INSPECTION_NUM",columnDefinition="NUMBER|门诊检查人次|12|",length=12,nullable=true)
	private Integer outInspectionNum;

	@Column(name="IN_INSPECTION_NUM",columnDefinition="NUMBER|住院检查人次|12|",length=12,nullable=true)
	private Integer inInspectionNum;

	@Column(name="INSPECTION_AMOUNT",columnDefinition="NUMBER|检查总金额||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal inspectionAmount;

	@Column(name="OUT_INSPECTION_AMOUNT",columnDefinition="NUMBER|门诊检查总金额||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal outInspectionAmount;

	@Column(name="IN_INSPECTION_AMOUNT",columnDefinition="NUMBER|住院检查总金额||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal inInspectionAmount;

	@Column(name="AVG_INSPECTION_AMOUNT",columnDefinition="NUMBER|平均检查金额||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal avgInspectionAmount;

	@Column(name="AVG_OUT_INSPECTION_AMOUNT",columnDefinition="NUMBER|门诊平均检查金额||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal avgOutInspectionAmount;

	@Column(name="AVG_IN_INSPECTION_AMOUNT",columnDefinition="NUMBER|住院平均检查金额||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal avgInInspectionAmount;
	
	@Column(name="EXAMINATION_NUM",columnDefinition="NUMBER|检验总人次|12|",length=12,nullable=true)
	private Integer examinationNum;
	
	@Column(name="OUT_EXAMINATION_NUM",columnDefinition="NUMBER|门诊检验人次|12|",length=12,nullable=true)
	private Integer outExaminationNum;
	
	@Column(name="IN_EXAMINATION_NUM",columnDefinition="NUMBER|住院检验人次|12|",length=12,nullable=true)
	private Integer inExaminationNum;
	
	@Column(name="EXAMINATION_AMOUNT",columnDefinition="NUMBER|检验总金额||",length=12,scale=12,precision=2, nullable=true)
	private BigDecimal examinationAmount;
	
	@Column(name="OUT_EXAMINATION_AMOUNT",columnDefinition="NUMBER|门诊检验总金额||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal outExaminationAmount;
	
	@Column(name="IN_EXAMINATION_AMOUNT",columnDefinition="NUMBER|住院检验总金额||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal inExaminationAmount;
	
	@Column(name="AVG_EXAMINATION_AMOUNT",columnDefinition="NUMBER|平均检验金额||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal avgExaminationAmount;
	
	@Column(name="AVG_OUT_EXAMINATION_AMOUNT",columnDefinition="NUMBER|门诊平均检验金额||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal avgOutExaminationAmount;
	
	@Column(name="AVG_IN_EXAMINATION_AMOUNT",columnDefinition="NUMBER|住院平均检验金额||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal avgInExaminationAmount;

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

	public Integer getInspectionNum() {
		return this.inspectionNum;
	}

	public void setInspectionNum(Integer inspectionNum) {
		this.inspectionNum = inspectionNum;
	}

	public Integer getOutInspectionNum() {
		return this.outInspectionNum;
	}

	public void setOutInspectionNum(Integer outInspectionNum) {
		this.outInspectionNum = outInspectionNum;
	}

	public Integer getInInspectionNum() {
		return this.inInspectionNum;
	}

	public void setInInspectionNum(Integer inInspectionNum) {
		this.inInspectionNum = inInspectionNum;
	}

	public BigDecimal getInspectionAmount() {
		return this.inspectionAmount;
	}

	public void setInspectionAmount(BigDecimal inspectionAmount) {
		this.inspectionAmount = inspectionAmount;
	}

	public BigDecimal getOutInspectionAmount() {
		return this.outInspectionAmount;
	}

	public void setOutInspectionAmount(BigDecimal outInspectionAmount) {
		this.outInspectionAmount = outInspectionAmount;
	}

	public BigDecimal getInInspectionAmount() {
		return this.inInspectionAmount;
	}

	public void setInInspectionAmount(BigDecimal inInspectionAmount) {
		this.inInspectionAmount = inInspectionAmount;
	}

	public BigDecimal getAvgInspectionAmount() {
		return this.avgInspectionAmount;
	}

	public void setAvgInspectionAmount(BigDecimal avgInspectionAmount) {
		this.avgInspectionAmount = avgInspectionAmount;
	}

	public BigDecimal getAvgOutInspectionAmount() {
		return this.avgOutInspectionAmount;
	}

	public void setAvgOutInspectionAmount(BigDecimal avgOutInspectionAmount) {
		this.avgOutInspectionAmount = avgOutInspectionAmount;
	}

	public BigDecimal getAvgInInspectionAmount() {
		return this.avgInInspectionAmount;
	}

	public void setAvgInInspectionAmount(BigDecimal avgInInspectionAmount) {
		this.avgInInspectionAmount = avgInInspectionAmount;
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

	public Integer getExaminationNum() {
		return examinationNum;
	}

	public void setExaminationNum(Integer examinationNum) {
		this.examinationNum = examinationNum;
	}

	public Integer getOutExaminationNum() {
		return outExaminationNum;
	}

	public void setOutExaminationNum(Integer outExaminationNum) {
		this.outExaminationNum = outExaminationNum;
	}

	public Integer getInExaminationNum() {
		return inExaminationNum;
	}

	public BigDecimal getExaminationAmount() {
		return examinationAmount;
	}

	public void setExaminationAmount(BigDecimal examinationAmount) {
		this.examinationAmount = examinationAmount;
	}

	public BigDecimal getOutExaminationAmount() {
		return outExaminationAmount;
	}

	public void setOutExaminationAmount(BigDecimal outExaminationAmount) {
		this.outExaminationAmount = outExaminationAmount;
	}

	public BigDecimal getInExaminationAmount() {
		return inExaminationAmount;
	}

	public void setInExaminationAmount(BigDecimal inExaminationAmount) {
		this.inExaminationAmount = inExaminationAmount;
	}

	public BigDecimal getAvgExaminationAmount() {
		return avgExaminationAmount;
	}

	public void setAvgExaminationAmount(BigDecimal avgExaminationAmount) {
		this.avgExaminationAmount = avgExaminationAmount;
	}

	public BigDecimal getAvgOutExaminationAmount() {
		return avgOutExaminationAmount;
	}

	public void setAvgOutExaminationAmount(BigDecimal avgOutExaminationAmount) {
		this.avgOutExaminationAmount = avgOutExaminationAmount;
	}

	public BigDecimal getAvgInExaminationAmount() {
		return avgInExaminationAmount;
	}

	public void setAvgInExaminationAmount(BigDecimal avgInExaminationAmount) {
		this.avgInExaminationAmount = avgInExaminationAmount;
	}

	public void setInExaminationNum(Integer inExaminationNum) {
		this.inExaminationNum = inExaminationNum;
	}

	

	
}