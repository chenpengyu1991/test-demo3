package com.founder.rhip.ehr.entity.finance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "FC_ORGAN_ASSETS_INFO")
public class FcOrganAssetsInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = true)
	private Long id;

	@Column(name = "MONTH", columnDefinition = "CHAR|年月|6|", length = 6, nullable = true)
	private String month;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|单位|50|", length = 50, nullable = true)
	private String organCode;

	@Column(name = "XRCT_NUM", columnDefinition = "NUMBER|X线电子计算机断层扫描装置(CT)数量||", length = 15, nullable = true)
	private BigDecimal xrctNum;

	@Column(name = "XRCT_FEE", columnDefinition = "NUMBER|X线电子计算机断层扫描装置(CT)金额||", length = 15, nullable = true)
	private BigDecimal xrctFee;

	@Column(name = "MRI_NUM", columnDefinition = "NUMBER|医用磁共振成像设备(MRI)数量||", length = 15, nullable = true)
	private BigDecimal mriNum;

	@Column(name = "MRI_FEE", columnDefinition = "NUMBER|医用磁共振成像设备(MRI)金额||", length = 15, nullable = true)
	private BigDecimal mriFee;

	@Column(name = "DSA_NUM", columnDefinition = "NUMBER|800毫安以上数字减影血管造影X线机(DSA)数量||", length = 15, nullable = true)
	private BigDecimal dsaNum;

	@Column(name = "DSA_FEE", columnDefinition = "NUMBER|800毫安以上数字减影血管造影X线机(DSA)金额||", length = 15, nullable = true)
	private BigDecimal dsaFee;

	@Column(name = "SPECT_NUM", columnDefinition = "NUMBER|单光子发射型电子计算机断层扫描仪(SPECT)数量||", length = 15, nullable = true)
	private BigDecimal spectNum;

	@Column(name = "SPECT_FEE", columnDefinition = "NUMBER|单光子发射型电子计算机断层扫描仪(SPECT)金额||", length = 15, nullable = true)
	private BigDecimal spectFee;

	@Column(name = "LA_NUM", columnDefinition = "NUMBER|医用电子直线加速器(LA)数量||", length = 15, nullable = true)
	private BigDecimal laNum;

	@Column(name = "LA_FEE", columnDefinition = "NUMBER|医用电子直线加速器(LA)金额||", length = 15, nullable = true)
	private BigDecimal laFee;

	@Column(name = "M200X_NUM", columnDefinition = "NUMBER|200MA或以上X光机数量||", length = 15, nullable = true)
	private BigDecimal m200xNum;

	@Column(name = "M200X_FEE", columnDefinition = "NUMBER|200MA或以上X光机金额||", length = 15, nullable = true)
	private BigDecimal m2200xFee;

	@Column(name = "CU_NUM", columnDefinition = "NUMBER|彩色B超数量||", length = 15, nullable = true)
	private BigDecimal cuNum;

	@Column(name = "CU_FEE", columnDefinition = "NUMBER|彩色B超金额||", length = 15, nullable = true)
	private BigDecimal cuFee;

	@Column(name = "PC_NUM", columnDefinition = "NUMBER|便携式彩超数量||", length = 15, nullable = true)
	private BigDecimal pcNum;

	@Column(name = "PC_FEE", columnDefinition = "NUMBER|便携式彩超金额||", length = 15, nullable = true)
	private BigDecimal pcFee;

	@Column(name = "BWU_NUM", columnDefinition = "NUMBER|黑白B超数量||", length = 15, nullable = true)
	private BigDecimal bwuNum;

	@Column(name = "BWU_FEE", columnDefinition = "NUMBER|黑白B超金额||", length = 15, nullable = true)
	private BigDecimal bwuFee;

	@Column(name = "EC_NUM", columnDefinition = "NUMBER|心电图机数量||", length = 15, nullable = true)
	private BigDecimal ecNum;

	@Column(name = "EC_FEE", columnDefinition = "NUMBER|心电图机金额||", length = 15, nullable = true)
	private BigDecimal ecFee;

	@Column(name = "ABA_NUM", columnDefinition = "NUMBER|自动生化分析仪数量||", length = 15, nullable = true)
	private BigDecimal abaNum;

	@Column(name = "ABA_FEE", columnDefinition = "NUMBER|自动生化分析仪金额||", length = 15, nullable = true)
	private BigDecimal abaFee;

	@Column(name = "UA_NUM", columnDefinition = "NUMBER|尿分析仪数量||", length = 15, nullable = true)
	private BigDecimal uaNum;

	@Column(name = "UA_FEE", columnDefinition = "NUMBER|尿分析仪金额||", length = 15, nullable = true)
	private BigDecimal uaFee;

	@Column(name = "GLM_NUM", columnDefinition = "NUMBER|洗胃机数量||", length = 15, nullable = true)
	private BigDecimal glmNum;

	@Column(name = "GLM_FEE", columnDefinition = "NUMBER|洗胃机金额||", length = 15, nullable = true)
	private BigDecimal glmFee;

	@Column(name = "SV_NUM", columnDefinition = "NUMBER|救护车、防疫车等特殊车辆数量||", length = 15, nullable = true)
	private BigDecimal svNum;

	@Column(name = "SV_FEE", columnDefinition = "NUMBER|救护车、防疫车等特殊车辆金额||", length = 15, nullable = true)
	private BigDecimal svFee;

	@Column(name = "OV_NUM", columnDefinition = "NUMBER|公务用车（含执法执勤车辆）数量||", length = 15, nullable = true)
	private BigDecimal ovNum;

	@Column(name = "OV_FEE", columnDefinition = "NUMBER|公务用车（含执法执勤车辆）金额||", length = 15, nullable = true)
	private BigDecimal OvFee;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMonth() {
		return this.month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public BigDecimal getXrctNum() {
		return this.xrctNum;
	}

	public void setXrctNum(BigDecimal xrctNum) {
		this.xrctNum = xrctNum;
	}

	public BigDecimal getXrctFee() {
		return this.xrctFee;
	}

	public void setXrctFee(BigDecimal xrctFee) {
		this.xrctFee = xrctFee;
	}

	public BigDecimal getMriNum() {
		return this.mriNum;
	}

	public void setMriNum(BigDecimal mriNum) {
		this.mriNum = mriNum;
	}

	public BigDecimal getMriFee() {
		return this.mriFee;
	}

	public void setMriFee(BigDecimal mriFee) {
		this.mriFee = mriFee;
	}

	public BigDecimal getDsaNum() {
		return this.dsaNum;
	}

	public void setDsaNum(BigDecimal dsaNum) {
		this.dsaNum = dsaNum;
	}

	public BigDecimal getDsaFee() {
		return this.dsaFee;
	}

	public void setDsaFee(BigDecimal dsaFee) {
		this.dsaFee = dsaFee;
	}

	public BigDecimal getSpectNum() {
		return this.spectNum;
	}

	public void setSpectNum(BigDecimal spectNum) {
		this.spectNum = spectNum;
	}

	public BigDecimal getSpectFee() {
		return this.spectFee;
	}

	public void setSpectFee(BigDecimal spectFee) {
		this.spectFee = spectFee;
	}

	public BigDecimal getLaNum() {
		return this.laNum;
	}

	public void setLaNum(BigDecimal laNum) {
		this.laNum = laNum;
	}

	public BigDecimal getLaFee() {
		return this.laFee;
	}

	public void setLaFee(BigDecimal laFee) {
		this.laFee = laFee;
	}

	public BigDecimal getM200xNum() {
		return this.m200xNum;
	}

	public void setM200xNum(BigDecimal m200xNum) {
		this.m200xNum = m200xNum;
	}

	public BigDecimal getM2200xFee() {
		return this.m2200xFee;
	}

	public void setM2200xFee(BigDecimal m2200xFee) {
		this.m2200xFee = m2200xFee;
	}

	public BigDecimal getCuNum() {
		return this.cuNum;
	}

	public void setCuNum(BigDecimal cuNum) {
		this.cuNum = cuNum;
	}

	public BigDecimal getCuFee() {
		return this.cuFee;
	}

	public void setCuFee(BigDecimal cuFee) {
		this.cuFee = cuFee;
	}

	public BigDecimal getPcNum() {
		return this.pcNum;
	}

	public void setPcNum(BigDecimal pcNum) {
		this.pcNum = pcNum;
	}

	public BigDecimal getPcFee() {
		return this.pcFee;
	}

	public void setPcFee(BigDecimal pcFee) {
		this.pcFee = pcFee;
	}

	public BigDecimal getBwuNum() {
		return this.bwuNum;
	}

	public void setBwuNum(BigDecimal bwuNum) {
		this.bwuNum = bwuNum;
	}

	public BigDecimal getBwuFee() {
		return this.bwuFee;
	}

	public void setBwuFee(BigDecimal bwuFee) {
		this.bwuFee = bwuFee;
	}

	public BigDecimal getEcNum() {
		return this.ecNum;
	}

	public void setEcNum(BigDecimal ecNum) {
		this.ecNum = ecNum;
	}

	public BigDecimal getEcFee() {
		return this.ecFee;
	}

	public void setEcFee(BigDecimal ecFee) {
		this.ecFee = ecFee;
	}

	public BigDecimal getAbaNum() {
		return this.abaNum;
	}

	public void setAbaNum(BigDecimal abaNum) {
		this.abaNum = abaNum;
	}

	public BigDecimal getAbaFee() {
		return this.abaFee;
	}

	public void setAbaFee(BigDecimal abaFee) {
		this.abaFee = abaFee;
	}

	public BigDecimal getUaNum() {
		return this.uaNum;
	}

	public void setUaNum(BigDecimal uaNum) {
		this.uaNum = uaNum;
	}

	public BigDecimal getUaFee() {
		return this.uaFee;
	}

	public void setUaFee(BigDecimal uaFee) {
		this.uaFee = uaFee;
	}

	public BigDecimal getGlmNum() {
		return this.glmNum;
	}

	public void setGlmNum(BigDecimal glmNum) {
		this.glmNum = glmNum;
	}

	public BigDecimal getGlmFee() {
		return this.glmFee;
	}

	public void setGlmFee(BigDecimal glmFee) {
		this.glmFee = glmFee;
	}

	public BigDecimal getSvNum() {
		return this.svNum;
	}

	public void setSvNum(BigDecimal svNum) {
		this.svNum = svNum;
	}

	public BigDecimal getSvFee() {
		return this.svFee;
	}

	public void setSvFee(BigDecimal svFee) {
		this.svFee = svFee;
	}

	public BigDecimal getOvNum() {
		return this.ovNum;
	}

	public void setOvNum(BigDecimal ovNum) {
		this.ovNum = ovNum;
	}

	public BigDecimal getOvFee() {
		return this.OvFee;
	}

	public void setOvFee(BigDecimal OvFee) {
		this.OvFee = OvFee;
	}

}