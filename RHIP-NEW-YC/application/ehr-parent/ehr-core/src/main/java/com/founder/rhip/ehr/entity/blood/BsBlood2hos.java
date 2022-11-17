package com.founder.rhip.ehr.entity.blood;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name = "BS_BLOOD2HOS")
public class BsBlood2hos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|系统id|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "OUT_ID", columnDefinition = "VARCHAR2|发血单号|15|", length = 15, nullable = true)
	private String outId;

	@Column(name = "OUTTIME", columnDefinition = "DATE|发血日期||", nullable = true)
	private Date outtime;

	@Column(name = "DONID", columnDefinition = "VARCHAR2|献血码|15|", length = 15, nullable = true)
	private String donid;

	@Column(name = "PROCID", columnDefinition = "VARCHAR2|血液产品码|10|", length = 10, nullable = true)
	private String procid;

	@Column(name = "PROCNAME", columnDefinition = "VARCHAR2|血液名称|50|", length = 50, nullable = true)
	private String procname;

	@Column(name = "CAPACITY", columnDefinition = "NUMBER(8,2)|容量||", scale = 8, precision = 2, nullable = true)
	private BigDecimal capacity;

	@Column(name = "ABOTYPE", columnDefinition = "VARCHAR2|RH血型|2|", length = 2, nullable = true)
	private String abotype;

	@Column(name = "RHTYPE", columnDefinition = "VARCHAR2|RH血型|6|", length = 6, nullable = true)
	private String rhtype;

	@Column(name = "DONTIME", columnDefinition = "DATE|采血日期||", nullable = true)
	private Date dontime;

	@Column(name = "PROCTIME", columnDefinition = "DATE|制备日期||", nullable = true)
	private Date proctime;

	@Column(name = "EXPTIME", columnDefinition = "DATE|失效日期||", nullable = true)
	private Date exptime;

	@Column(name = "BLOODMONEY", columnDefinition = "NUMBER(8,2)|血液价格||", nullable = true)
	private String bloodmoney;

	@Column(name = "HOSID", columnDefinition = "NUMBER|医院编号|11|", length = 11, nullable = true)
	private String hosid;

	@Column(name = "HOSNAME", columnDefinition = "VARCHAR2|医院名称|20|", length = 20, nullable = true)
	private String hosname;

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

	public String getOutId() {
		return this.outId;
	}

	public void setOutId(String outId) {
		this.outId = outId;
	}

	public Date getOuttime() {
		return this.outtime;
	}

	public void setOuttime(Date outtime) {
		this.outtime = outtime;
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

	public String getProcname() {
		return this.procname;
	}

	public void setProcname(String procname) {
		this.procname = procname;
	}

	public BigDecimal getCapacity() {
		return this.capacity;
	}

	public void setCapacity(BigDecimal capacity) {
		this.capacity = capacity;
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

	public String getBloodmoney() {
		return this.bloodmoney;
	}

	public void setBloodmoney(String bloodmoney) {
		this.bloodmoney = bloodmoney;
	}

	public String getHosid() {
		return this.hosid;
	}

	public void setHosid(String hosid) {
		this.hosid = hosid;
	}

	public String getHosname() {
		return this.hosname;
	}

	public void setHosname(String hosname) {
		this.hosname = hosname;
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