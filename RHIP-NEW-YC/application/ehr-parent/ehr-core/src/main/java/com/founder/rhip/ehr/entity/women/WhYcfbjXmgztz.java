package com.founder.rhip.ehr.entity.women;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table ( name ="WH_YCFBJ_XMGZTZ" )
public class WhYcfbjXmgztz  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|数据库唯一编号（自增长）|11|",length=11,nullable=false)
	private Long id;

	@Column(name="DWMC",columnDefinition="VARCHAR2|单位名称|50|",length=50,nullable=true)
	private String dwmc;

	@Column(name="NF",columnDefinition="NUMBER|年份|4|",length=4,nullable=false)
	private Integer nf;

	@Column(name="YF",columnDefinition="NUMBER|月份|2|",length=2,nullable=false)
	private Integer yf;

	@Column(name="XQRKS",columnDefinition="NUMBER|辖区人口数|10|",length=10,nullable=false)
	private Integer xqrks = 0;

	@Column(name="CSL",columnDefinition="NUMBER|出生率|10|",length=10,nullable=true)
	private BigDecimal csl= new BigDecimal(0);

	@Column(name="NYCFMBJCS",columnDefinition="NUMBER|年孕产妇目标建册数|10|",length=10,nullable=true)
	private Integer nycfmbjcs = 0;

	@Column(name="YCFMBJCS",columnDefinition="NUMBER|孕产妇目标建册数|10|",length=10,nullable=true)
	private Integer ycfmbjcs =0;

	@Column(name="HCS",columnDefinition="NUMBER|活产数|10|",length=10,nullable=true)
	private Integer hcs = 0;

	@Column(name="SJJCS",columnDefinition="NUMBER|实际建册数|10|",length=10,nullable=true)
	private Integer sjjcs = 0;

	@Column(name="ZYJCS",columnDefinition="NUMBER|早孕检查数|10|",length=10,nullable=true)
	private Integer zyjcs = 0;

	@Column(name="ZYJCL",columnDefinition="NUMBER|早孕建册率|10|",length=10,nullable=true)
	private BigDecimal zyjcl = new BigDecimal(0);

	@Column(name="YSLESZJCS",columnDefinition="NUMBER|孕16-20周检查数|10|",length=10,nullable=true)
	private Integer ysleszjcs = 0;

	@Column(name="YEYESZJCS",columnDefinition="NUMBER|孕21-24周检查数|10|",length=10,nullable=true)
	private Integer yeyeszjcs = 0;

	@Column(name="YEBSLZJCS",columnDefinition="NUMBER|孕28-36周检查数|10|",length=10,nullable=true)
	private Integer yebslzjcs = 0;

	@Column(name="YSQSLZJCS",columnDefinition="NUMBER|孕37-40周检查数|10|",length=10,nullable=true)
	private Integer ysqslzjcs = 0;

	@Column(name="JKGLS",columnDefinition="NUMBER|健康管理数|10|",length=10,nullable=true)
	private Integer jkgls = 0;

	@Column(name="JKGLL",columnDefinition="NUMBER|健康管理率|10|",length=10,nullable=true)
	private BigDecimal jkgll =new BigDecimal(0);;

	@Column(name="CHFSS",columnDefinition="NUMBER|产后访视数|10|",length=10,nullable=true)
	private Integer chfss = 0;

	@Column(name="CHFSL",columnDefinition="NUMBER|产后访视率|10|",length=10,nullable=true)
	private BigDecimal chfsl = new BigDecimal(0);;

	@Column(name="XTGLS",columnDefinition="NUMBER|系统管理数|10|",length=10,nullable=true)
	private Integer xtgls =0;

	@Column(name="XTGLL",columnDefinition="NUMBER|系统管理率|10|",nullable=true)
	private BigDecimal xtgll = new BigDecimal(0);;

	@Column(name="TBR",columnDefinition="VARCHAR2|填表人|50|",length=50,nullable=true)
	private String tbr;

   	@Column(name="TBRQ",columnDefinition="DATE|填表日期||",nullable=true)
	private Date tbrq;

	public Date getTbrq() {
		return tbrq;
	}

	public void setTbrq(Date tbrq) {
		this.tbrq = tbrq;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDwmc() {
		return dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public Integer getNf() {
		return nf;
	}

	public void setNf(Integer nf) {
		this.nf = nf;
	}

	public Integer getYf() {
		return yf;
	}

	public void setYf(Integer yf) {
		this.yf = yf;
	}

	public Integer getXqrks() {
		return xqrks;
	}

	public void setXqrks(Integer xqrks) {
		this.xqrks = xqrks;
	}

	public BigDecimal getCsl() {
		return csl;
	}

	public void setCsl(BigDecimal csl) {
		this.csl = csl;
	}

	public Integer getNycfmbjcs() {
		return nycfmbjcs;
	}

	public void setNycfmbjcs(Integer nycfmbjcs) {
		this.nycfmbjcs = nycfmbjcs;
	}

	public Integer getYcfmbjcs() {
		return ycfmbjcs;
	}

	public void setYcfmbjcs(Integer ycfmbjcs) {
		this.ycfmbjcs = ycfmbjcs;
	}

	public Integer getHcs() {
		return hcs;
	}

	public void setHcs(Integer hcs) {
		this.hcs = hcs;
	}

	public Integer getSjjcs() {
		return sjjcs;
	}

	public void setSjjcs(Integer sjjcs) {
		this.sjjcs = sjjcs;
	}

	public Integer getZyjcs() {
		return zyjcs;
	}

	public void setZyjcs(Integer zyjcs) {
		this.zyjcs = zyjcs;
	}

	public BigDecimal getZyjcl() {
		return zyjcl;
	}

	public void setZyjcl(BigDecimal zyjcl) {
		this.zyjcl = zyjcl;
	}

	public Integer getYsleszjcs() {
		return ysleszjcs;
	}

	public void setYsleszjcs(Integer ysleszjcs) {
		this.ysleszjcs = ysleszjcs;
	}

	public Integer getYeyeszjcs() {
		return yeyeszjcs;
	}

	public void setYeyeszjcs(Integer yeyeszjcs) {
		this.yeyeszjcs = yeyeszjcs;
	}

	public Integer getYebslzjcs() {
		return yebslzjcs;
	}

	public void setYebslzjcs(Integer yebslzjcs) {
		this.yebslzjcs = yebslzjcs;
	}

	public Integer getYsqslzjcs() {
		return ysqslzjcs;
	}

	public void setYsqslzjcs(Integer ysqslzjcs) {
		this.ysqslzjcs = ysqslzjcs;
	}

	public Integer getJkgls() {
		return jkgls;
	}

	public void setJkgls(Integer jkgls) {
		this.jkgls = jkgls;
	}

	public BigDecimal getJkgll() {
		return jkgll;
	}

	public void setJkgll(BigDecimal jkgll) {
		this.jkgll = jkgll;
	}

	public Integer getChfss() {
		return chfss;
	}

	public void setChfss(Integer chfss) {
		this.chfss = chfss;
	}

	public BigDecimal getChfsl() {
		return chfsl;
	}

	public void setChfsl(BigDecimal chfsl) {
		this.chfsl = chfsl;
	}

	public Integer getXtgls() {
		return xtgls;
	}

	public void setXtgls(Integer xtgls) {
		this.xtgls = xtgls;
	}

	public BigDecimal getXtgll() {
		return xtgll;
	}

	public void setXtgll(BigDecimal xtgll) {
		this.xtgll = xtgll;
	}

	public String getTbr() {
		return tbr;
	}

	public void setTbr(String tbr) {
		this.tbr = tbr;
	}
}
