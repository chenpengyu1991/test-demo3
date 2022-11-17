package com.founder.rhip.ehr.entity.finance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "FC_GOV_BASE_DATA")
public class FcGovBaseData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = true)
	private Long id;

	@Column(name = "MONTH", columnDefinition = "CHAR|年月|6|", length = 6, nullable = true)
	private String month;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|单位|50|", length = 50, nullable = true)
	private String organCode;

	@Column(name = "JG_NUM", columnDefinition = "NUMBER|机构数(个)||", length = 15, nullable = true)
	private BigDecimal jgNum;

	@Column(name = "BZ_NUM", columnDefinition = "NUMBER|编制人数(人)||", length = 15, nullable = true)
	private BigDecimal bzNum;

	@Column(name = "EYZB_NUM", columnDefinition = "NUMBER|年末在编在职人数(人)||", length = 15, nullable = true)
	private BigDecimal eyzbNum;

	@Column(name = "EYZZ_NUM", columnDefinition = "NUMBER|年末在职职工人数(人)||", length = 15, nullable = true)
	private BigDecimal eyzzNum;

	@Column(name = "WJ_NUM", columnDefinition = "NUMBER|卫技人员(人)||", length = 15, nullable = true)
	private BigDecimal wjNum;

	@Column(name = "PJZZ_NUM", columnDefinition = "NUMBER|平均在职职工人数(人)||", length = 15, nullable = true)
	private BigDecimal pjzzNum;

	@Column(name = "QMLT_NUM", columnDefinition = "NUMBER|期末离退休人数(人)||", length = 15, nullable = true)
	private BigDecimal qmltNum;

	@Column(name = "NCGDZC_FEE", columnDefinition = "NUMBER|年初固定资产原值(元)||", length = 15, nullable = true)
	private BigDecimal ncgdzcMon;

	@Column(name = "QMGDZC_FEE", columnDefinition = "NUMBER|期末固定资产原值(元)||", length = 15, nullable = true)
	private BigDecimal qmgdzcMon;

	@Column(name = "ZYSB_FEE", columnDefinition = "NUMBER|专用设备(元)||", length = 15, nullable = true)
	private BigDecimal zysbMon;

	@Column(name = "FWJZ_FEE", columnDefinition = "NUMBER|房屋及建筑物(元)||", length = 15, nullable = true)
	private BigDecimal fwjzMon;

	@Column(name = "QMFWJZ_FEE", columnDefinition = "NUMBER|期末房屋及建筑物面积(㎡)||", length = 15, nullable = true)
	private BigDecimal qmfwjzMon;

	@Column(name = "YWYF_M", columnDefinition = "NUMBER|业务用房(㎡)||", length = 15, nullable = true)
	private BigDecimal ywyfM;

	@Column(name = "M10WSB_NUM", columnDefinition = "NUMBER|单价在10万元以上的专业设备台数(台)||", length = 15, nullable = true)
	private BigDecimal m10wsbNum;

	@Column(name = "M1WSB_FEE", columnDefinition = "NUMBER|单价在1万元以上的专业设备金额(元)||", length = 15, nullable = true)
	private BigDecimal m1wsbNum;

	@Column(name = "FED_FEE", columnDefinition = "NUMBER|零余额账户用款额度(元)||", length = 15, nullable = true)
	private BigDecimal fedMon;

	@Column(name = "FHED_FEE", columnDefinition = "NUMBER|财政应返还额度(元)||", length = 15, nullable = true)
	private BigDecimal fhedMon;

	@Column(name = "QTYS_FEE", columnDefinition = "NUMBER|其他应收款(元)||", length = 15, nullable = true)
	private BigDecimal qtysMon;

	@Column(name = "GD_FEE", columnDefinition = "NUMBER|固定资产(元)||", length = 15, nullable = true)
	private BigDecimal gdMon;

	@Column(name = "ZJ_FEE", columnDefinition = "NUMBER|在建工程(元)||", length = 15, nullable = true)
	private BigDecimal zjMon;

	@Column(name = "DQ_FEE", columnDefinition = "NUMBER|短期借款(元)||", length = 15, nullable = true)
	private BigDecimal dgMon;

	@Column(name = "YF_FEE", columnDefinition = "NUMBER|应付账款(元)||", length = 15, nullable = true)
	private BigDecimal yfMon;

	@Column(name = "QTYF_FEE", columnDefinition = "NUMBER|其他应付款(元)||", length = 15, nullable = true)
	private BigDecimal qtyfMon;

	@Column(name = "CQYF_FEE", columnDefinition = "NUMBER|长期应付款(元)||", length = 15, nullable = true)
	private BigDecimal cqyfMon;

	@Column(name = "SYJJ_FEE", columnDefinition = "NUMBER|事业基金(元)||", length = 15, nullable = true)
	private BigDecimal syjjMon;

	@Column(name = "FLDZC_FEE", columnDefinition = "NUMBER|非流动资产基金(元)||", length = 15, nullable = true)
	private BigDecimal fldzcMon;

	@Column(name = "ZYJJ_FEE", columnDefinition = "NUMBER|专用基金(元)||", length = 15, nullable = true)
	private BigDecimal zyjjMon;

	@Column(name = "CZBZ_FEE", columnDefinition = "NUMBER|财政补助结转(元)||", length = 15, nullable = true)
	private BigDecimal czbzMon;

	@Column(name = "SYJY_FEE", columnDefinition = "NUMBER|事业结余(元)||", length = 15, nullable = true)
	private BigDecimal syjyMon;

	@Column(name = "JZC_FEE", columnDefinition = "NUMBER|净资产总计||", length = 15, nullable = true)
	private BigDecimal jzcMon;

	@Column(name = "ZC_FEE", columnDefinition = "NUMBER|资产总计||", length = 15, nullable = true)
	private BigDecimal zxMon;

	@Column(name = "CZBZSR_FEE", columnDefinition = "NUMBER|财政补助收入||", length = 15, nullable = true)
	private BigDecimal czbzsrFee;

	@Column(name = "SYSR_FEE", columnDefinition = "NUMBER|事业收入||", length = 15, nullable = true)
	private BigDecimal sysrFee;

	@Column(name = "SYZC_FEE", columnDefinition = "NUMBER|事业支出||", length = 15, nullable = true)
	private BigDecimal syzcFee;

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

	public BigDecimal getJgNum() {
		return this.jgNum;
	}

	public void setJgNum(BigDecimal jgNum) {
		this.jgNum = jgNum;
	}

	public BigDecimal getBzNum() {
		return this.bzNum;
	}

	public void setBzNum(BigDecimal bzNum) {
		this.bzNum = bzNum;
	}

	public BigDecimal getEyzbNum() {
		return this.eyzbNum;
	}

	public void setEyzbNum(BigDecimal eyzbNum) {
		this.eyzbNum = eyzbNum;
	}

	public BigDecimal getEyzzNum() {
		return this.eyzzNum;
	}

	public void setEyzzNum(BigDecimal eyzzNum) {
		this.eyzzNum = eyzzNum;
	}

	public BigDecimal getWjNum() {
		return this.wjNum;
	}

	public void setWjNum(BigDecimal wjNum) {
		this.wjNum = wjNum;
	}

	public BigDecimal getPjzzNum() {
		return this.pjzzNum;
	}

	public void setPjzzNum(BigDecimal pjzzNum) {
		this.pjzzNum = pjzzNum;
	}

	public BigDecimal getQmltNum() {
		return this.qmltNum;
	}

	public void setQmltNum(BigDecimal qmltNum) {
		this.qmltNum = qmltNum;
	}

	public BigDecimal getNcgdzcMon() {
		return this.ncgdzcMon;
	}

	public void setNcgdzcMon(BigDecimal ncgdzcMon) {
		this.ncgdzcMon = ncgdzcMon;
	}

	public BigDecimal getQmgdzcMon() {
		return this.qmgdzcMon;
	}

	public void setQmgdzcMon(BigDecimal qmgdzcMon) {
		this.qmgdzcMon = qmgdzcMon;
	}

	public BigDecimal getZysbMon() {
		return this.zysbMon;
	}

	public void setZysbMon(BigDecimal zysbMon) {
		this.zysbMon = zysbMon;
	}

	public BigDecimal getFwjzMon() {
		return this.fwjzMon;
	}

	public void setFwjzMon(BigDecimal fwjzMon) {
		this.fwjzMon = fwjzMon;
	}

	public BigDecimal getQmfwjzMon() {
		return this.qmfwjzMon;
	}

	public void setQmfwjzMon(BigDecimal qmfwjzMon) {
		this.qmfwjzMon = qmfwjzMon;
	}

	public BigDecimal getYwyfM() {
		return this.ywyfM;
	}

	public void setYwyfM(BigDecimal ywyfM) {
		this.ywyfM = ywyfM;
	}

	public BigDecimal getM10wsbNum() {
		return this.m10wsbNum;
	}

	public void setM10wsbNum(BigDecimal m10wsbNum) {
		this.m10wsbNum = m10wsbNum;
	}

	public BigDecimal getM1wsbNum() {
		return this.m1wsbNum;
	}

	public void setM1wsbNum(BigDecimal m1wsbNum) {
		this.m1wsbNum = m1wsbNum;
	}

	public BigDecimal getFedMon() {
		return this.fedMon;
	}

	public void setFedMon(BigDecimal fedMon) {
		this.fedMon = fedMon;
	}

	public BigDecimal getFhedMon() {
		return this.fhedMon;
	}

	public void setFhedMon(BigDecimal fhedMon) {
		this.fhedMon = fhedMon;
	}

	public BigDecimal getQtysMon() {
		return this.qtysMon;
	}

	public void setQtysMon(BigDecimal qtysMon) {
		this.qtysMon = qtysMon;
	}

	public BigDecimal getGdMon() {
		return this.gdMon;
	}

	public void setGdMon(BigDecimal gdMon) {
		this.gdMon = gdMon;
	}

	public BigDecimal getZjMon() {
		return this.zjMon;
	}

	public void setZjMon(BigDecimal zjMon) {
		this.zjMon = zjMon;
	}

	public BigDecimal getDgMon() {
		return this.dgMon;
	}

	public void setDgMon(BigDecimal dgMon) {
		this.dgMon = dgMon;
	}

	public BigDecimal getYfMon() {
		return this.yfMon;
	}

	public void setYfMon(BigDecimal yfMon) {
		this.yfMon = yfMon;
	}

	public BigDecimal getQtyfMon() {
		return this.qtyfMon;
	}

	public void setQtyfMon(BigDecimal qtyfMon) {
		this.qtyfMon = qtyfMon;
	}

	public BigDecimal getCqyfMon() {
		return this.cqyfMon;
	}

	public void setCqyfMon(BigDecimal cqyfMon) {
		this.cqyfMon = cqyfMon;
	}

	public BigDecimal getSyjjMon() {
		return this.syjjMon;
	}

	public void setSyjjMon(BigDecimal syjjMon) {
		this.syjjMon = syjjMon;
	}

	public BigDecimal getFldzcMon() {
		return this.fldzcMon;
	}

	public void setFldzcMon(BigDecimal fldzcMon) {
		this.fldzcMon = fldzcMon;
	}

	public BigDecimal getZyjjMon() {
		return this.zyjjMon;
	}

	public void setZyjjMon(BigDecimal zyjjMon) {
		this.zyjjMon = zyjjMon;
	}

	public BigDecimal getCzbzMon() {
		return this.czbzMon;
	}

	public void setCzbzMon(BigDecimal czbzMon) {
		this.czbzMon = czbzMon;
	}

	public BigDecimal getSyjyMon() {
		return this.syjyMon;
	}

	public void setSyjyMon(BigDecimal syjyMon) {
		this.syjyMon = syjyMon;
	}

	public BigDecimal getJzcMon() {
		return this.jzcMon;
	}

	public void setJzcMon(BigDecimal jzcMon) {
		this.jzcMon = jzcMon;
	}

	public BigDecimal getZxMon() {
		return this.zxMon;
	}

	public void setZxMon(BigDecimal zxMon) {
		this.zxMon = zxMon;
	}

	public BigDecimal getCzbzsrFee() {
		return this.czbzsrFee;
	}

	public void setCzbzsrFee(BigDecimal czbzsrFee) {
		this.czbzsrFee = czbzsrFee;
	}

	public BigDecimal getSysrFee() {
		return this.sysrFee;
	}

	public void setSysrFee(BigDecimal sysrFee) {
		this.sysrFee = sysrFee;
	}

	public BigDecimal getSyzcFee() {
		return this.syzcFee;
	}

	public void setSyzcFee(BigDecimal syzcFee) {
		this.syzcFee = syzcFee;
	}

}