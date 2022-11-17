package com.founder.rhip.im.entity.medical;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="RD_HEALTH_RESOURCES")
public class RdHealthResources implements Serializable {

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

	@Column(name="PREPARATION_NUM",columnDefinition="NUMBER|编制人数|12|",length=12,nullable=true)
	private Integer preparationNum;

	@Column(name="SERIES_NUM",columnDefinition="NUMBER|在编人数|12|",length=12,nullable=true)
	private Integer seriesNum;

	@Column(name="WORKERS_NUM",columnDefinition="NUMBER|在岗职工数|12|",length=12,nullable=true)
	private Integer workersNum;

	@Column(name="HEALTH_TECHNICAL_NUM",columnDefinition="NUMBER|卫生技术人员数|12|",length=12,nullable=true)
	private Integer healthTechnicalNum;

	@Column(name="OTHER_NUM",columnDefinition="NUMBER|其它技术人员数|12|",length=12,nullable=true)
	private Integer otherNum;

	@Column(name="MANAGE_NUM",columnDefinition="NUMBER|管理人员数|12|",length=12,nullable=true)
	private Integer manageNum;

	@Column(name="SKILLED_NUM",columnDefinition="NUMBER|工勤技能人员数|12|",length=12,nullable=true)
	private Integer skilledNum;

	@Column(name="MEDICAL_CARE_RATIO",columnDefinition="NUMBER|医护之比||",length=12,scale=12,precision=2,nullable=true)
	private double medicalCareRatio;

	@Column(name="GENERAL_DOCTOR_NUM",columnDefinition="NUMBER|全科医师数|12|",length=12,nullable=true)
	private Integer generalDoctorNum;

	@Column(name="RURAL_DOCTORS_NUM",columnDefinition="NUMBER|乡村医生数|12|",length=12,nullable=true)
	private Integer ruralDoctorsNum;

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

	public Integer getPreparationNum() {
		return this.preparationNum;
	}

	public void setPreparationNum(Integer preparationNum) {
		this.preparationNum = preparationNum;
	}

	public Integer getSeriesNum() {
		return this.seriesNum;
	}

	public void setSeriesNum(Integer seriesNum) {
		this.seriesNum = seriesNum;
	}

	public Integer getWorkersNum() {
		return this.workersNum;
	}

	public void setWorkersNum(Integer workersNum) {
		this.workersNum = workersNum;
	}

	public Integer getHealthTechnicalNum() {
		return this.healthTechnicalNum;
	}

	public void setHealthTechnicalNum(Integer healthTechnicalNum) {
		this.healthTechnicalNum = healthTechnicalNum;
	}

	public Integer getOtherNum() {
		return this.otherNum;
	}

	public void setOtherNum(Integer otherNum) {
		this.otherNum = otherNum;
	}

	public Integer getManageNum() {
		return this.manageNum;
	}

	public void setManageNum(Integer manageNum) {
		this.manageNum = manageNum;
	}

	public Integer getSkilledNum() {
		return this.skilledNum;
	}

	public void setSkilledNum(Integer skilledNum) {
		this.skilledNum = skilledNum;
	}

	public double getMedicalCareRatio() {
		return this.medicalCareRatio;
	}

	public void setMedicalCareRatio(double medicalCareRatio) {
		this.medicalCareRatio = medicalCareRatio;
	}

	public Integer getGeneralDoctorNum() {
		return this.generalDoctorNum;
	}

	public void setGeneralDoctorNum(Integer generalDoctorNum) {
		this.generalDoctorNum = generalDoctorNum;
	}

	public Integer getRuralDoctorsNum() {
		return this.ruralDoctorsNum;
	}

	public void setRuralDoctorsNum(Integer ruralDoctorsNum) {
		this.ruralDoctorsNum = ruralDoctorsNum;
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