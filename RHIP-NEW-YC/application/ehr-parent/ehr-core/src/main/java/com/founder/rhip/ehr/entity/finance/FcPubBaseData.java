package com.founder.rhip.ehr.entity.finance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "FC_PUB_BASE_DATA")
public class FcPubBaseData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = true)
	private Long id;

	@Column(name = "MONTH", columnDefinition = "CHAR|年月|6|", length = 6, nullable = true)
	private String month;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|单位|50|", length = 50, nullable = true)
	private String oragnCode;

	@Column(name = "ZBRS", columnDefinition = "NUMBER|编制人数||", length = 15, nullable = true)
	private BigDecimal zbrs;

	@Column(name = "QMZJ", columnDefinition = "NUMBER|期末在职职工人数||", length = 15, nullable = true)
	private BigDecimal qmzj;

	@Column(name = "PJZJ", columnDefinition = "NUMBER|平均在职职工人数||", length = 15, nullable = true)
	private BigDecimal pjzj;

	@Column(name = "WJRY", columnDefinition = "NUMBER|卫技人员||", length = 15, nullable = true)
	private BigDecimal wjry;

	@Column(name = "QMLX", columnDefinition = "NUMBER|期末离休人数||", length = 15, nullable = true)
	private BigDecimal qmlx;

	@Column(name = "QMTX", columnDefinition = "NUMBER|期末退休人数||", length = 15, nullable = true)
	private BigDecimal qmtx;

	@Column(name = "LSG", columnDefinition = "NUMBER|临时工人数||", length = 15, nullable = true)
	private BigDecimal lsg;

	@Column(name = "BZB", columnDefinition = "NUMBER|编制床位||", length = 15, nullable = true)
	private BigDecimal bzb;

	@Column(name = "QMSJKFB", columnDefinition = "NUMBER|期末实际开放床位||", length = 15, nullable = true)
	private BigDecimal qmsjkfb;

	@Column(name = "FWMJ", columnDefinition = "NUMBER|房屋面积||", length = 15, nullable = true)
	private BigDecimal fwmj;

	@Column(name = "YLYF", columnDefinition = "NUMBER|医疗用房||", length = 15, nullable = true)
	private BigDecimal ylyf;

	@Column(name = "SHYF", columnDefinition = "NUMBER|生活用房||", length = 15, nullable = true)
	private BigDecimal shyf;

	@Column(name = "NCGDZC", columnDefinition = "NUMBER|年初固定资产总值||", length = 15, nullable = true)
	private BigDecimal ncgdzc;

	@Column(name = "QMGDZC", columnDefinition = "NUMBER|期末固定资产总值||", length = 15, nullable = true)
	private BigDecimal qmgdzc;

	@Column(name = "FWJZW", columnDefinition = "NUMBER|房屋建筑物||", length = 15, nullable = true)
	private BigDecimal fwjzw;

	@Column(name = "ZYSB", columnDefinition = "NUMBER|专业设备||", length = 15, nullable = true)
	private BigDecimal zysb;

	@Column(name = "YBSB", columnDefinition = "NUMBER|一般设备||", length = 15, nullable = true)
	private BigDecimal ybsb;

	@Column(name = "QMFWJZMJ", columnDefinition = "NUMBER|期末房屋及建筑物面积||", length = 15, nullable = true)
	private BigDecimal qmfwjzmj;

	@Column(name = "YWYF", columnDefinition = "NUMBER|业务用房||", length = 15, nullable = true)
	private BigDecimal ywyf;

	@Column(name = "MJZRC", columnDefinition = "NUMBER|门急诊人次（不含体检）||", length = 15, nullable = true)
	private BigDecimal mjzrc;

	@Column(name = "SJZYCRS", columnDefinition = "NUMBER|实际占用总床日数||", length = 15, nullable = true)
	private BigDecimal sjzycrs;

	@Column(name = "CYRS", columnDefinition = "NUMBER|出院人数||", length = 15, nullable = true)
	private BigDecimal cyrs;

	@Column(name = "MZRCSR", columnDefinition = "NUMBER|每门诊人次收入||", length = 15, nullable = true)
	private BigDecimal mzrcsr;

	@Column(name = "MZRCZC", columnDefinition = "NUMBER|每门诊人次支出||", length = 15, nullable = true)
	private BigDecimal mzrczc;

	@Column(name = "ZYRCSR", columnDefinition = "NUMBER|每住院人次收入||", length = 15, nullable = true)
	private BigDecimal zyrcsr;

	@Column(name = "ZYRCZC", columnDefinition = "NUMBER|每住院人次支出||", length = 15, nullable = true)
	private BigDecimal zyrczc;

	@Column(name = "BCLXH", columnDefinition = "NUMBER|百元医疗收入卫生材料消耗||", length = 15, nullable = true)
	private BigDecimal bclxh;

	@Column(name = "CWZZCS", columnDefinition = "NUMBER|床位周转次数||", length = 15, nullable = true)
	private BigDecimal cwzzcs;

	@Column(name = "CWSYL", columnDefinition = "NUMBER|床位使用率||", length = 15, nullable = true)
	private BigDecimal cwsyl;

	@Column(name = "GLFYL", columnDefinition = "NUMBER|管理费用率||", length = 15, nullable = true)
	private BigDecimal glfyl;

	@Column(name = "ZGZLRC", columnDefinition = "NUMBER|每职工平均诊疗人次||", length = 15, nullable = true)
	private BigDecimal zgzlrc;

	@Column(name = "ZGZYCR", columnDefinition = "NUMBER|每职工平均住院床日||", length = 15, nullable = true)
	private BigDecimal zgzycr;

	@Column(name = "ZGYLSR", columnDefinition = "NUMBER|每职工平均医疗收入||", length = 15, nullable = true)
	private BigDecimal zgylsr;

	@Column(name = "ZGYWSR", columnDefinition = "NUMBER|每职工业务收入||", length = 15, nullable = true)
	private BigDecimal zgywsr;

	@Column(name = "TQJJS", columnDefinition = "NUMBER|提取奖金数||", length = 15, nullable = true)
	private BigDecimal tqjjs;

	@Column(name = "RJSR", columnDefinition = "NUMBER|事业人员人均收入||", length = 15, nullable = true)
	private BigDecimal rjsr;

	@Column(name = "RJJJ", columnDefinition = "NUMBER|事业人员人均奖金||", length = 15, nullable = true)
	private BigDecimal rjjj;

	@Column(name = "M10SB", columnDefinition = "NUMBER|单价在10万元以上的专业设备台数||", length = 15, nullable = true)
	private BigDecimal m10sb;

	@Column(name = "M1SB", columnDefinition = "NUMBER|单价在11万元以上的专业设备金额||", length = 15, nullable = true)
	private BigDecimal m1sb;

	@Column(name = "ZCFZJY", columnDefinition = "NUMBER|资产负债结余情况||", length = 15, nullable = true)
	private BigDecimal zcfzjy;

	@Column(name = "HBZJ", columnDefinition = "NUMBER|货币资金||", length = 15, nullable = true)
	private BigDecimal hbzj;

	@Column(name = "YSYLK", columnDefinition = "NUMBER|应收医疗款||", length = 15, nullable = true)
	private BigDecimal ysylk;

	@Column(name = "QTYSK", columnDefinition = "NUMBER|其他应收款||", length = 15, nullable = true)
	private BigDecimal qtysk;

	@Column(name = "CH", columnDefinition = "NUMBER|存货||", length = 15, nullable = true)
	private BigDecimal ch;

	@Column(name = "ZJGC", columnDefinition = "NUMBER|在建工程||", length = 15, nullable = true)
	private BigDecimal zjgc;

	@Column(name = "DQJK", columnDefinition = "NUMBER|短期借款||", length = 15, nullable = true)
	private BigDecimal dqjk;

	@Column(name = "YFZK", columnDefinition = "NUMBER|应付账款||", length = 15, nullable = true)
	private BigDecimal yfzk;

	@Column(name = "QTYFK", columnDefinition = "NUMBER|其他应付款||", length = 15, nullable = true)
	private BigDecimal qtyfk;

	@Column(name = "YTFY", columnDefinition = "NUMBER|预提费用||", length = 15, nullable = true)
	private BigDecimal ytyf;

	@Column(name = "SYJJ", columnDefinition = "NUMBER|事业基金||", length = 15, nullable = true)
	private BigDecimal syjj;

	@Column(name = "ZYJJ", columnDefinition = "NUMBER|专用基金||", length = 15, nullable = true)
	private BigDecimal zyjj;

	@Column(name = "DCJJ", columnDefinition = "NUMBER|待冲基金||", length = 15, nullable = true)
	private BigDecimal dcjj;

	@Column(name = "BQJY", columnDefinition = "NUMBER|本期结余||", length = 15, nullable = true)
	private BigDecimal bqjy;

	@Column(name = "JZCHJ", columnDefinition = "NUMBER|净资产合计||", length = 15, nullable = true)
	private BigDecimal jzchj;

	@Column(name = "ZCHJ", columnDefinition = "NUMBER|资产总计||", length = 15, nullable = true)
	private BigDecimal zchj;

	@Column(name = "COMMENTS", columnDefinition = "VARCHAR2|说明|100|", length = 100, nullable = true)
	private String comments;

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

	public String getOragnCode() {
		return this.oragnCode;
	}

	public void setOragnCode(String oragnCode) {
		this.oragnCode = oragnCode;
	}

	public BigDecimal getZbrs() {
		return this.zbrs;
	}

	public void setZbrs(BigDecimal zbrs) {
		this.zbrs = zbrs;
	}

	public BigDecimal getQmzj() {
		return this.qmzj;
	}

	public void setQmzj(BigDecimal qmzj) {
		this.qmzj = qmzj;
	}

	public BigDecimal getPjzj() {
		return this.pjzj;
	}

	public void setPjzj(BigDecimal pjzj) {
		this.pjzj = pjzj;
	}

	public BigDecimal getWjry() {
		return this.wjry;
	}

	public void setWjry(BigDecimal wjry) {
		this.wjry = wjry;
	}

	public BigDecimal getQmlx() {
		return this.qmlx;
	}

	public void setQmlx(BigDecimal qmlx) {
		this.qmlx = qmlx;
	}

	public BigDecimal getQmtx() {
		return this.qmtx;
	}

	public void setQmtx(BigDecimal qmtx) {
		this.qmtx = qmtx;
	}

	public BigDecimal getLsg() {
		return this.lsg;
	}

	public void setLsg(BigDecimal lsg) {
		this.lsg = lsg;
	}

	public BigDecimal getBzb() {
		return this.bzb;
	}

	public void setBzb(BigDecimal bzb) {
		this.bzb = bzb;
	}

	public BigDecimal getQmsjkfb() {
		return this.qmsjkfb;
	}

	public void setQmsjkfb(BigDecimal qmsjkfb) {
		this.qmsjkfb = qmsjkfb;
	}

	public BigDecimal getFwmj() {
		return this.fwmj;
	}

	public void setFwmj(BigDecimal fwmj) {
		this.fwmj = fwmj;
	}

	public BigDecimal getYlyf() {
		return this.ylyf;
	}

	public void setYlyf(BigDecimal ylyf) {
		this.ylyf = ylyf;
	}

	public BigDecimal getShyf() {
		return this.shyf;
	}

	public void setShyf(BigDecimal shyf) {
		this.shyf = shyf;
	}

	public BigDecimal getNcgdzc() {
		return this.ncgdzc;
	}

	public void setNcgdzc(BigDecimal ncgdzc) {
		this.ncgdzc = ncgdzc;
	}

	public BigDecimal getQmgdzc() {
		return this.qmgdzc;
	}

	public void setQmgdzc(BigDecimal qmgdzc) {
		this.qmgdzc = qmgdzc;
	}

	public BigDecimal getFwjzw() {
		return this.fwjzw;
	}

	public void setFwjzw(BigDecimal fwjzw) {
		this.fwjzw = fwjzw;
	}

	public BigDecimal getZysb() {
		return this.zysb;
	}

	public void setZysb(BigDecimal zysb) {
		this.zysb = zysb;
	}

	public BigDecimal getYbsb() {
		return this.ybsb;
	}

	public void setYbsb(BigDecimal ybsb) {
		this.ybsb = ybsb;
	}

	public BigDecimal getQmfwjzmj() {
		return this.qmfwjzmj;
	}

	public void setQmfwjzmj(BigDecimal qmfwjzmj) {
		this.qmfwjzmj = qmfwjzmj;
	}

	public BigDecimal getYwyf() {
		return this.ywyf;
	}

	public void setYwyf(BigDecimal ywyf) {
		this.ywyf = ywyf;
	}

	public BigDecimal getMjzrc() {
		return this.mjzrc;
	}

	public void setMjzrc(BigDecimal mjzrc) {
		this.mjzrc = mjzrc;
	}

	public BigDecimal getSjzycrs() {
		return this.sjzycrs;
	}

	public void setSjzycrs(BigDecimal sjzycrs) {
		this.sjzycrs = sjzycrs;
	}

	public BigDecimal getCyrs() {
		return this.cyrs;
	}

	public void setCyrs(BigDecimal cyrs) {
		this.cyrs = cyrs;
	}

	public BigDecimal getMzrcsr() {
		return this.mzrcsr;
	}

	public void setMzrcsr(BigDecimal mzrcsr) {
		this.mzrcsr = mzrcsr;
	}

	public BigDecimal getMzrczc() {
		return this.mzrczc;
	}

	public void setMzrczc(BigDecimal mzrczc) {
		this.mzrczc = mzrczc;
	}

	public BigDecimal getZyrcsr() {
		return this.zyrcsr;
	}

	public void setZyrcsr(BigDecimal zyrcsr) {
		this.zyrcsr = zyrcsr;
	}

	public BigDecimal getZyrczc() {
		return this.zyrczc;
	}

	public void setZyrczc(BigDecimal zyrczc) {
		this.zyrczc = zyrczc;
	}

	public BigDecimal getBclxh() {
		return this.bclxh;
	}

	public void setBclxh(BigDecimal bclxh) {
		this.bclxh = bclxh;
	}

	public BigDecimal getCwzzcs() {
		return this.cwzzcs;
	}

	public void setCwzzcs(BigDecimal cwzzcs) {
		this.cwzzcs = cwzzcs;
	}

	public BigDecimal getCwsyl() {
		return this.cwsyl;
	}

	public void setCwsyl(BigDecimal cwsyl) {
		this.cwsyl = cwsyl;
	}

	public BigDecimal getGlfyl() {
		return this.glfyl;
	}

	public void setGlfyl(BigDecimal glfyl) {
		this.glfyl = glfyl;
	}

	public BigDecimal getZgzlrc() {
		return this.zgzlrc;
	}

	public void setZgzlrc(BigDecimal zgzlrc) {
		this.zgzlrc = zgzlrc;
	}

	public BigDecimal getZgzycr() {
		return this.zgzycr;
	}

	public void setZgzycr(BigDecimal zgzycr) {
		this.zgzycr = zgzycr;
	}

	public BigDecimal getZgylsr() {
		return this.zgylsr;
	}

	public void setZgylsr(BigDecimal zgylsr) {
		this.zgylsr = zgylsr;
	}

	public BigDecimal getZgywsr() {
		return this.zgywsr;
	}

	public void setZgywsr(BigDecimal zgywsr) {
		this.zgywsr = zgywsr;
	}

	public BigDecimal getTqjjs() {
		return this.tqjjs;
	}

	public void setTqjjs(BigDecimal tqjjs) {
		this.tqjjs = tqjjs;
	}

	public BigDecimal getRjsr() {
		return this.rjsr;
	}

	public void setRjsr(BigDecimal rjsr) {
		this.rjsr = rjsr;
	}

	public BigDecimal getRjjj() {
		return this.rjjj;
	}

	public void setRjjj(BigDecimal rjjj) {
		this.rjjj = rjjj;
	}

	public BigDecimal getM10sb() {
		return this.m10sb;
	}

	public void setM10sb(BigDecimal m10sb) {
		this.m10sb = m10sb;
	}

	public BigDecimal getM1sb() {
		return this.m1sb;
	}

	public void setM1sb(BigDecimal m1sb) {
		this.m1sb = m1sb;
	}

	public BigDecimal getZcfzjy() {
		return this.zcfzjy;
	}

	public void setZcfzjy(BigDecimal zcfzjy) {
		this.zcfzjy = zcfzjy;
	}

	public BigDecimal getHbzj() {
		return this.hbzj;
	}

	public void setHbzj(BigDecimal hbzj) {
		this.hbzj = hbzj;
	}

	public BigDecimal getYsylk() {
		return this.ysylk;
	}

	public void setYsylk(BigDecimal ysylk) {
		this.ysylk = ysylk;
	}

	public BigDecimal getQtysk() {
		return this.qtysk;
	}

	public void setQtysk(BigDecimal qtysk) {
		this.qtysk = qtysk;
	}

	public BigDecimal getCh() {
		return this.ch;
	}

	public void setCh(BigDecimal ch) {
		this.ch = ch;
	}

	public BigDecimal getZjgc() {
		return this.zjgc;
	}

	public void setZjgc(BigDecimal zjgc) {
		this.zjgc = zjgc;
	}

	public BigDecimal getDqjk() {
		return this.dqjk;
	}

	public void setDqjk(BigDecimal dqjk) {
		this.dqjk = dqjk;
	}

	public BigDecimal getYfzk() {
		return this.yfzk;
	}

	public void setYfzk(BigDecimal yfzk) {
		this.yfzk = yfzk;
	}

	public BigDecimal getQtyfk() {
		return this.qtyfk;
	}

	public void setQtyfk(BigDecimal qtyfk) {
		this.qtyfk = qtyfk;
	}

	public BigDecimal getYtyf() {
		return this.ytyf;
	}

	public void setYtyf(BigDecimal ytyf) {
		this.ytyf = ytyf;
	}

	public BigDecimal getSyjj() {
		return this.syjj;
	}

	public void setSyjj(BigDecimal syjj) {
		this.syjj = syjj;
	}

	public BigDecimal getZyjj() {
		return this.zyjj;
	}

	public void setZyjj(BigDecimal zyjj) {
		this.zyjj = zyjj;
	}

	public BigDecimal getDcjj() {
		return this.dcjj;
	}

	public void setDcjj(BigDecimal dcjj) {
		this.dcjj = dcjj;
	}

	public BigDecimal getBqjy() {
		return this.bqjy;
	}

	public void setBqjy(BigDecimal bqjy) {
		this.bqjy = bqjy;
	}

	public BigDecimal getJzchj() {
		return this.jzchj;
	}

	public void setJzchj(BigDecimal jzchj) {
		this.jzchj = jzchj;
	}

	public BigDecimal getZchj() {
		return this.zchj;
	}

	public void setZchj(BigDecimal zchj) {
		this.zchj = zchj;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}