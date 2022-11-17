package com.founder.rhip.im.entity.medical;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="RD_DIAGNOSIS")
public class RdDiagnosis implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|业务主键|11|",length=11,nullable=false)
	private Long id;

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

	@Column(name="YEAR_MONTH",columnDefinition="DATE|具体日期||",nullable=true)
	private Date yearMonth;

	@Column(name="YEAR",columnDefinition="NUMBER|年度|4|",length=4,nullable=false)
	private Integer year;

	@Column(name="HALF_YEAR",columnDefinition="NUMBER|半年|1|",length=1,nullable=false)
	private Integer halfYear;

	@Column(name="QUARTER",columnDefinition="NUMBER|季度|1|",length=1,nullable=false)
	private Integer quarter;

	@Column(name="MONTH",columnDefinition="NUMBER|月度|2|",length=2,nullable=false)
	private Integer month;

	@Column(name="DIAGNOSIS_CODE",columnDefinition="VARCHAR2|诊断代码|20|",length=20,nullable=false)
	private String diagnosisCode;

	@Column(name="DIAGNOSIS_NAME",columnDefinition="VARCHAR2|诊断名称|255|",length=255,nullable=false)
	private String diagnosisName;

	@Column(name="DIAGNOSIS_COUNT",columnDefinition="NUMBER|诊断数量|10|",length=10,nullable=false)
	private Integer diagnosisCount;

	@Column(name="CREATE_DATE",columnDefinition="TIMESTAMP|创建时间||",nullable=true)
	private Date createDate;

	@Column(name="UPDATE_DATE",columnDefinition="TIMESTAMP|更新时间||",nullable=true)
	private Date updateDate;

	public RdDiagnosis(){}
	public RdDiagnosis(String organCode, String organName, String gbCode, String centerCode, String genreCode
			, Integer year, Integer halfYear, Integer quarter, Integer month
			, String diagnosisCode, String diagnosisName, Integer diagnosisCount, Date yearMonth) {
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
		this.diagnosisCode = diagnosisCode;
		this.diagnosisName = diagnosisName;
		this.diagnosisCount = diagnosisCount;
		this.yearMonth = yearMonth;
		this.createDate = new Date();
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

	public String getDiagnosisCode() {
		return this.diagnosisCode;
	}

	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}

	public String getDiagnosisName() {
		return diagnosisName;
	}

	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}

	public Integer getDiagnosisCount() {
		return this.diagnosisCount;
	}

	public void setDiagnosisCount(Integer diagnosisCount) {
		this.diagnosisCount = diagnosisCount;
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