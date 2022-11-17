package com.founder.rhip.ehr.entity.ihm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "IHM_INHOS_TARGET_REPORT")
public class InhosTargetReport implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|子增长字段|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "GB_CODE", columnDefinition = "VARCHAR2|镇编码|50|", length = 50, nullable = true)
	private String gbCode;

	@Column(name = "GENRE_CODE", columnDefinition = "VARCHAR2|类型编码|50|", length = 50, nullable = true)
	private String genreCode;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|机构编码|50|", length = 50, nullable = true)
	private String organCode;

	@Column(name = "DISEASE_TYPE", columnDefinition = "VARCHAR2|疾病类型|10|", length = 10, nullable = true)
	private String diseaseType;

	@Column(name = "YEAR_NUM", columnDefinition = "NUMBER|监测年份||", scale = 8, precision = 2, nullable = true)
	private Integer yearNum;

	@Column(name = "QUARTER_NUM", columnDefinition = "NUMBER|监测季度||", scale = 8, precision = 2, nullable = true)
	private Integer quarterNum;

	@Column(name = "CASE_NUM", columnDefinition = "NUMBER|病例数|10|", length = 10, nullable = true)
	private Integer caseNum;

	@Column(name = "DIE_NUM", columnDefinition = "NUMBER|死亡数|10|", length = 10, nullable = true)
	private Integer dieNum;

	@Column(name = "FIFTEEN_RATE", columnDefinition = "NUMBER|15日内再住院率||", scale = 10, precision = 4, nullable = true)
	private BigDecimal fifteenRate;

	@Column(name = "THIRTYONE_RATE", columnDefinition = "NUMBER|31日内再住院率||", scale = 10, precision = 4, nullable = true)
	private BigDecimal thirtyoneRate;

	@Column(name = "SUM_DAY", columnDefinition = "NUMBER|住院日总数||", scale = 10, precision = 4, nullable = true)
	private BigDecimal sumDay;

	@Column(name = "SUM_FEE", columnDefinition = "NUMBER|住院费用总额||", scale = 10, precision = 4, nullable = true)
	private BigDecimal sumFee;

	@Column(name = "CREATE_DATE", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createDate;

	@Column(name = "MODIFY_DATE", columnDefinition = "DATE|修改时间||", nullable = true)
	private Date modifyDate;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGbCode() {
		return this.gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public String getGenreCode() {
		return this.genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getDiseaseType() {
		return this.diseaseType;
	}

	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}

	public Integer getYearNum() {
		return this.yearNum;
	}

	public void setYearNum(Integer yearNum) {
		this.yearNum = yearNum;
	}

	public Integer getQuarterNum() {
		return this.quarterNum;
	}

	public void setQuarterNum(Integer quarterNum) {
		this.quarterNum = quarterNum;
	}

	public Integer getCaseNum() {
		return this.caseNum;
	}

	public void setCaseNum(Integer caseNum) {
		this.caseNum = caseNum;
	}

	public Integer getDieNum() {
		return this.dieNum;
	}

	public void setDieNum(Integer dieNum) {
		this.dieNum = dieNum;
	}

	public BigDecimal getFifteenRate() {
		return this.fifteenRate;
	}

	public void setFifteenRate(BigDecimal fifteenRate) {
		this.fifteenRate = fifteenRate;
	}

	public BigDecimal getThirtyoneRate() {
		return this.thirtyoneRate;
	}

	public void setThirtyoneRate(BigDecimal thirtyoneRate) {
		this.thirtyoneRate = thirtyoneRate;
	}

	public BigDecimal getSumDay() {
		return this.sumDay;
	}

	public void setSumDay(BigDecimal sumDay) {
		this.sumDay = sumDay;
	}

	public BigDecimal getSumFee() {
		return this.sumFee;
	}

	public void setSumFee(BigDecimal sumFee) {
		this.sumFee = sumFee;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

}