package com.founder.rhip.im.entity.medical;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="RD_BED_DISTRIBUTION")
public class RdBedDistribution implements Serializable {

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

	@Column(name="AUTHORIZED_BED",columnDefinition="NUMBER|编制床位|12|",length=12,nullable=true)
	private Integer authorizedBed;

	@Column(name="REAL_BED",columnDefinition="NUMBER|实有床位|12|",length=12,nullable=true)
	private Integer realBed;

	@Column(name="ACTUAL_AVAILABLE_BED_DAYS",columnDefinition="NUMBER|实际开放总床日数|12|",length=12,nullable=true)
	private Integer actualAvailableBedDays;

	@Column(name="ACTUAL_USING_BED_DAYS",columnDefinition="NUMBER|实际占用总床日数|12|",length=12,nullable=true)
	private Integer actualUsingBedDays;

	@Column(name="INPATIENT_BED_DAYS",columnDefinition="NUMBER|出院者占用总床日数|12|",length=12,nullable=true)
	private Integer inpatientBedDays;

	@Column(name="OBSERVATION_BED",columnDefinition="NUMBER|观察床数|12|",length=12,nullable=true)
	private Integer observationBed;

	@Column(name="FAMILY_BEDS",columnDefinition="NUMBER|全年开设家庭病床总数|12|",length=12,nullable=true)
	private Integer familyBeds;

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

	public Integer getAuthorizedBed() {
		return this.authorizedBed;
	}

	public void setAuthorizedBed(Integer authorizedBed) {
		this.authorizedBed = authorizedBed;
	}

	public Integer getRealBed() {
		return this.realBed;
	}

	public void setRealBed(Integer realBed) {
		this.realBed = realBed;
	}

	public Integer getActualAvailableBedDays() {
		return this.actualAvailableBedDays;
	}

	public void setActualAvailableBedDays(Integer actualAvailableBedDays) {
		this.actualAvailableBedDays = actualAvailableBedDays;
	}

	public Integer getActualUsingBedDays() {
		return this.actualUsingBedDays;
	}

	public void setActualUsingBedDays(Integer actualUsingBedDays) {
		this.actualUsingBedDays = actualUsingBedDays;
	}

	public Integer getInpatientBedDays() {
		return this.inpatientBedDays;
	}

	public void setInpatientBedDays(Integer inpatientBedDays) {
		this.inpatientBedDays = inpatientBedDays;
	}

	public Integer getObservationBed() {
		return this.observationBed;
	}

	public void setObservationBed(Integer observationBed) {
		this.observationBed = observationBed;
	}

	public Integer getFamilyBeds() {
		return this.familyBeds;
	}

	public void setFamilyBeds(Integer familyBeds) {
		this.familyBeds = familyBeds;
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