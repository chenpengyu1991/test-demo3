package com.founder.rhip.ehr.entity.report;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "RP_WEIGHT_SET")
public class RpWeightSet implements Serializable {

	private static final long serialVersionUID = -7359455699953380983L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "RP_NAME", columnDefinition = "VARCHAR2|表名（多名称用分号间隔）||", length = 100, nullable = true)
	private String rpName;
	
	@Column(name = "GB_CODE", columnDefinition = "VARCHAR2|所在镇编码||", length = 50, nullable = true)
	private String gbCode;
	
	@Column(name = "CENTER_CODE", columnDefinition = "VARCHAR2|中心编码||", length = 50, nullable = true)
	private String centerCode;
	
	@NotEmpty(message = "请选择机构！")
	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|机构编码||", length = 50, nullable = true)
	private String organCode;
	
	@Column(name = "ORGAN_TYPE", columnDefinition = "VARCHAR2|机构类型||", length = 5, nullable = true)
	private String organType;

	@Column(name = "RP_TYPE", columnDefinition = "VARCHAR2|权重类型（字典：FS990011）|1|", length = 1, nullable = true)
	private String rpType;

	@NotEmpty(message = "请权重开始时间！")
	@Column(name = "RP_BEGIN_DATE", columnDefinition = "DATE|权重开始时间||", nullable = true)
	private Date rpBeginDate;

	//@NotEmpty(message = "请输入权重结束时间！")
	@Column(name = "RP_END_DATE", columnDefinition = "DATE|权重结束时间||", nullable = true)
	private Date rpEndDate;

	//@NotEmpty(message = "请选择权重指标！")
	@Column(name = "WEIGHT_INDEX", columnDefinition = "VARCHAR2|权重指标（字典）|5|", length = 5, nullable = true)
	private String weightIndex;

	@Column(name = "WEIGHT_VALUE", columnDefinition = "NUMBER|权重值|5|", length = 5, nullable = true)
	private Integer weightValue;

	@Column(name = "WEIGHT_DATUM_BEGIN", columnDefinition = "NUMBER|完成度/百分比开始值（包干型该字段有值）|5|", length = 5, nullable = true)
	private Integer weightDatumBegin;

	@Column(name = "WEIGHT_DATUM_END", columnDefinition = "NUMBER|完成度/百分比结束值（包干型该字段有值）|5|", length = 5, nullable = true)
	private Integer weightDatumEnd;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRpName() {
		return rpName;
	}

	public void setRpName(String rpName) {
		this.rpName = rpName;
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

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getOrganType() {
		return organType;
	}

	public void setOrganType(String organType) {
		this.organType = organType;
	}

	public String getRpType() {
		return rpType;
	}

	public void setRpType(String rpType) {
		this.rpType = rpType;
	}

	public Date getRpBeginDate() {
		return rpBeginDate;
	}

	public void setRpBeginDate(Date rpBeginDate) {
		this.rpBeginDate = rpBeginDate;
	}

	public Date getRpEndDate() {
		return rpEndDate;
	}

	public void setRpEndDate(Date rpEndDate) {
		this.rpEndDate = rpEndDate;
	}

	public String getWeightIndex() {
		return weightIndex;
	}

	public void setWeightIndex(String weightIndex) {
		this.weightIndex = weightIndex;
	}

	public Integer getWeightValue() {
		return weightValue;
	}

	public void setWeightValue(Integer weightValue) {
		this.weightValue = weightValue;
	}

	public Integer getWeightDatumBegin() {
		return weightDatumBegin;
	}

	public void setWeightDatumBegin(Integer weightDatumBegin) {
		this.weightDatumBegin = weightDatumBegin;
	}

	public Integer getWeightDatumEnd() {
		return weightDatumEnd;
	}

	public void setWeightDatumEnd(Integer weightDatumEnd) {
		this.weightDatumEnd = weightDatumEnd;
	}
}
