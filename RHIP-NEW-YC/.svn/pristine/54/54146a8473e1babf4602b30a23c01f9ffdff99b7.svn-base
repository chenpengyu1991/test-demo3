package com.founder.rhip.ehr.entity.blood;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "BS_BLOODBANK")
public class BsBloodbank implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "ID", columnDefinition = "NUMBER|系统id|11|", length = 11, nullable = true)
	private Long id;

	@Column(name = "DONID", columnDefinition = "VARCHAR2|献血码|15|", length = 15, nullable = true)
	private String donid;

	@Column(name = "PROCID", columnDefinition = "VARCHAR2|血液产品码|10|", length = 10, nullable = true)
	private String procid;

	@Column(name = "ABOTYPE", columnDefinition = "VARCHAR2|ABO血型|2|", nullable = true)
	private String abotype;

	@Column(name = "RHTYPE", columnDefinition = "VARCHAR2|RH血型|6|", length = 6, nullable = true)
	private String rhtype;

	@Column(name = "DONTIME", columnDefinition = "DATE|采血日期||", nullable = true)
	private Date dontime;

	@Column(name = "PROCTIME", columnDefinition = "DATE|制备日期||", nullable = true)
	private Date proctime;

	@Column(name = "EXPTIME", columnDefinition = "DATE|失效日期||", nullable = true)
	private Date exptime;

	@Column(name = "BRANCH", columnDefinition = "VARCHAR2|区域|6|", length = 6, nullable = true)
	private String branch;

	@Column(name = "MAKETIME", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date maketime;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDonid() {
		return this.donid;
	}

	public void setDonid(String donid) {
		this.donid = donid;
	}

	public String getProcid() {
		return this.procid;
	}

	public void setProcid(String procid) {
		this.procid = procid;
	}

	public String getAbotype() {
		return this.abotype;
	}

	public void setAbotype(String abotype) {
		this.abotype = abotype;
	}

	public String getRhtype() {
		return this.rhtype;
	}

	public void setRhtype(String rhtype) {
		this.rhtype = rhtype;
	}

	public Date getDontime() {
		return this.dontime;
	}

	public void setDontime(Date dontime) {
		this.dontime = dontime;
	}

	public Date getProctime() {
		return this.proctime;
	}

	public void setProctime(Date proctime) {
		this.proctime = proctime;
	}

	public Date getExptime() {
		return this.exptime;
	}

	public void setExptime(Date exptime) {
		this.exptime = exptime;
	}

	public String getBranch() {
		return this.branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Date getMaketime() {
		return this.maketime;
	}

	public void setMaketime(Date maketime) {
		this.maketime = maketime;
	}

}