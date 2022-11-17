package com.founder.rhip.ehr.entity.finance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "FC_PUB_FINANCE_INFO")
public class FcPubFinanceInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = true)
	private Long id;

	@Column(name = "MONTH", columnDefinition = "CHAR|年月|6|", length = 6, nullable = true)
	private String month;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|单   位|50|", length = 50, nullable = true)
	private String organCode;

	@Column(name = "SRHJ", columnDefinition = "NUMBER|收入合计||", length = 15, nullable = true)
	private BigDecimal srhj;

	@Column(name = "YLSR", columnDefinition = "NUMBER|医疗收入||", length = 15, nullable = true)
	private BigDecimal ylsr;

	@Column(name = "YPSR", columnDefinition = "NUMBER|药品收入||", length = 15, nullable = true)
	private BigDecimal ypsr;

	@Column(name = "CZBZ", columnDefinition = "NUMBER|财政补助收入||", length = 15, nullable = true)
	private BigDecimal czbz;

	@Column(name = "QTSR", columnDefinition = "NUMBER|其他收入||", length = 15, nullable = true)
	private BigDecimal qtsr;

	@Column(name = "ZCHJ", columnDefinition = "NUMBER|支出合计||", length = 15, nullable = true)
	private BigDecimal zchj;

	@Column(name = "YLCB", columnDefinition = "NUMBER|医疗业务成本||", length = 15, nullable = true)
	private BigDecimal ylcb;

	@Column(name = "YPF", columnDefinition = "NUMBER|药品费||", length = 15, nullable = true)
	private BigDecimal ypf;

	@Column(name = "ZJ", columnDefinition = "NUMBER|折旧（摊销）||", length = 15, nullable = true)
	private BigDecimal zj;

	@Column(name = "CZXMBZ", columnDefinition = "NUMBER|财政项目补助支出||", length = 15, nullable = true)
	private BigDecimal czxmbz;

	@Column(name = "KJZC", columnDefinition = "NUMBER|科教项目支出||", length = 15, nullable = true)
	private BigDecimal kjzc;

	@Column(name = "GLFY", columnDefinition = "NUMBER|管理费用||", length = 15, nullable = true)
	private BigDecimal glfy;

	@Column(name = "QTZC", columnDefinition = "NUMBER|其他支出||", length = 15, nullable = true)
	private BigDecimal qtzc;

	@Column(name = "JYC", columnDefinition = "NUMBER|结余(含财政基本补助）||", length = 15, nullable = true)
	private BigDecimal jyc;

	@Column(name = "JYN", columnDefinition = "NUMBER|结余(不含财政补助）||", length = 15, nullable = true)
	private BigDecimal jyn;

	@Column(name = "YPB", columnDefinition = "NUMBER|药品收入占业务总收入比例%||", length = 15, nullable = true)
	private BigDecimal ypb;

	@Column(name = "YPCJ", columnDefinition = "NUMBER|药品综合差价率%||", length = 15, nullable = true)
	private BigDecimal ypcj;

	@Column(name = "SRHJL", columnDefinition = "NUMBER|收入合计(去年同期)||", length = 15, nullable = true)
	private BigDecimal srhjl;

	@Column(name = "CZBZL", columnDefinition = "NUMBER|财政补助(去年同期)||", length = 15, nullable = true)
	private BigDecimal czbzl;

	@Column(name = "JYL", columnDefinition = "NUMBER|结余（含财政补助）(去年同期)||", length = 15, nullable = true)
	private BigDecimal jyl;

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

	public BigDecimal getSrhj() {
		return this.srhj;
	}

	public void setSrhj(BigDecimal srhj) {
		this.srhj = srhj;
	}

	public BigDecimal getYlsr() {
		return this.ylsr;
	}

	public void setYlsr(BigDecimal ylsr) {
		this.ylsr = ylsr;
	}

	public BigDecimal getYpsr() {
		return this.ypsr;
	}

	public void setYpsr(BigDecimal ypsr) {
		this.ypsr = ypsr;
	}

	public BigDecimal getCzbz() {
		return this.czbz;
	}

	public void setCzbz(BigDecimal czbz) {
		this.czbz = czbz;
	}

	public BigDecimal getQtsr() {
		return this.qtsr;
	}

	public void setQtsr(BigDecimal qtsr) {
		this.qtsr = qtsr;
	}

	public BigDecimal getZchj() {
		return this.zchj;
	}

	public void setZchj(BigDecimal zchj) {
		this.zchj = zchj;
	}

	public BigDecimal getYlcb() {
		return this.ylcb;
	}

	public void setYlcb(BigDecimal ylcb) {
		this.ylcb = ylcb;
	}

	public BigDecimal getYpf() {
		return this.ypf;
	}

	public void setYpf(BigDecimal ypf) {
		this.ypf = ypf;
	}

	public BigDecimal getZj() {
		return this.zj;
	}

	public void setZj(BigDecimal zj) {
		this.zj = zj;
	}

	public BigDecimal getCzxmbz() {
		return this.czxmbz;
	}

	public void setCzxmbz(BigDecimal czxmbz) {
		this.czxmbz = czxmbz;
	}

	public BigDecimal getKjzc() {
		return this.kjzc;
	}

	public void setKjzc(BigDecimal kjzc) {
		this.kjzc = kjzc;
	}

	public BigDecimal getGlfy() {
		return this.glfy;
	}

	public void setGlfy(BigDecimal glfy) {
		this.glfy = glfy;
	}

	public BigDecimal getQtzc() {
		return this.qtzc;
	}

	public void setQtzc(BigDecimal qtzc) {
		this.qtzc = qtzc;
	}

    public BigDecimal getJyc() {
        return jyc;
    }

    public void setJyc(BigDecimal jyc) {
        this.jyc = jyc;
    }

    public BigDecimal getJyn() {
		return this.jyn;
	}

	public void setJyn(BigDecimal jyn) {
		this.jyn = jyn;
	}

	public BigDecimal getYpb() {
		return this.ypb;
	}

	public void setYpb(BigDecimal ypb) {
		this.ypb = ypb;
	}

	public BigDecimal getYpcj() {
		return this.ypcj;
	}

	public void setYpcj(BigDecimal ypcj) {
		this.ypcj = ypcj;
	}

	public BigDecimal getSrhjl() {
		return this.srhjl;
	}

	public void setSrhjl(BigDecimal srhjl) {
		this.srhjl = srhjl;
	}

    public BigDecimal getCzbzl() {
        return czbzl;
    }

    public void setCzbzl(BigDecimal czbzl) {
        this.czbzl = czbzl;
    }

    public BigDecimal getJyl() {
		return this.jyl;
	}

	public void setJyl(BigDecimal jyl) {
		this.jyl = jyl;
	}

}