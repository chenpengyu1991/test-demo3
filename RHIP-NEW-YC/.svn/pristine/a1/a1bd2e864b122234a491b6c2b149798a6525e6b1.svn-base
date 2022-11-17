package com.founder.rhip.ehr.entity.blood;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name = "BS_REIMBURSEMENT")
public class BsReimbursement implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|系统id|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "REID", columnDefinition = "VARCHAR2|报销编号|20|", length = 20, nullable = false)
	private String reid;

	@Column(name = "DORID", columnDefinition = "VARCHAR2|献血者编号|8|", length = 8, nullable = true)
	private String dorid;

	@Column(name = "PATIENTNAME", columnDefinition = "VARCHAR2|用血者姓名|10|", length = 10, nullable = true)
	private String patientname;

	@Column(name = "PATIENTIDENTITYTYPE", columnDefinition = "VARCHAR2|用血者证件类型|10|", length = 10, nullable = true)
	private String patientidentitytype;

	@Column(name = "PATIENTIDENTITYID", columnDefinition = "VARCHAR2|用血者证件号|30|", length = 30, nullable = true)
	private String patientidentityid;

	@Column(name = "USETIME", columnDefinition = "DATE|用血时间||", nullable = true)
	private Date usetime;

	@Column(name = "USEAMOUNT", columnDefinition = "VARCHAR2|用血量|80|", length = 80, nullable = true)
	private String useamount;

	@Column(name = "HOSPITAL", columnDefinition = "VARCHAR2|用血医院|20|", length = 20, nullable = true)
	private String hospital;

	@Column(name = "REASON", columnDefinition = "VARCHAR2|用血原因|50|", length = 50, nullable = true)
	private String reason;

	@Column(name = "INVOICE", columnDefinition = "VARCHAR2|发票号|15|", length = 15, nullable = true)
	private String invoice;

	@Column(name = "RELATION", columnDefinition = "VARCHAR2|献血者用血者关系|15|", length = 15, nullable = true)
	private String relation;

	@Column(name = "PROVETYPE", columnDefinition = "VARCHAR2|证明资料类型|20|", length = 20, nullable = true)
	private String provetype;

	@Column(name = "PRINCIPLE", columnDefinition = "VARCHAR2|返回政策|50|", length = 50, nullable = true)
	private String principle;

	@Column(name = "MONEY", columnDefinition = "NUMBER|报销金额||", scale = 10, precision = 2, nullable = true)
	private BigDecimal money;

	@Column(name = "PAYEE", columnDefinition = "VARCHAR2|报销人姓名|15|", length = 15, nullable = true)
	private String payee;

	@Column(name = "PAYEEIDENTITYTYPE", columnDefinition = "VARCHAR2|报销人证件类型|15|", length = 15, nullable = true)
	private String payeeidentitytype;

	@Column(name = "PAYEEIDENTITYID", columnDefinition = "VARCHAR2|报销人证件号|30|", length = 30, nullable = true)
	private String payeeidentityid;

	@Column(name = "PAYEETIME", columnDefinition = "DATE|报销时间||", nullable = true)
	private Date payeetime;

	@Column(name = "BLOODSTATION", columnDefinition = "VARCHAR2|报销血站|20|", length = 20, nullable = true)
	private String bloodstation;

	@Column(name = "BRANCH", columnDefinition = "VARCHAR2|区域|15|", length = 15, nullable = true)
	private String branch;

	@Column(name = "MAKETIME", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date maketime;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReid() {
		return this.reid;
	}

	public void setReid(String reid) {
		this.reid = reid;
	}

	public String getDorid() {
		return this.dorid;
	}

	public void setDorid(String dorid) {
		this.dorid = dorid;
	}

	public String getPatientname() {
		return this.patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public String getPatientidentitytype() {
		return this.patientidentitytype;
	}

	public void setPatientidentitytype(String patientidentitytype) {
		this.patientidentitytype = patientidentitytype;
	}

	public String getPatientidentityid() {
		return this.patientidentityid;
	}

	public void setPatientidentityid(String patientidentityid) {
		this.patientidentityid = patientidentityid;
	}

	public Date getUsetime() {
		return this.usetime;
	}

	public void setUsetime(Date usetime) {
		this.usetime = usetime;
	}

	public String getUseamount() {
		return this.useamount;
	}

	public void setUseamount(String useamount) {
		this.useamount = useamount;
	}

	public String getHospital() {
		return this.hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getInvoice() {
		return this.invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getProvetype() {
		return this.provetype;
	}

	public void setProvetype(String provetype) {
		this.provetype = provetype;
	}

	public String getPrinciple() {
		return this.principle;
	}

	public void setPrinciple(String principle) {
		this.principle = principle;
	}

	public BigDecimal getMoney() {
		return this.money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getPayee() {
		return this.payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getPayeeidentitytype() {
		return this.payeeidentitytype;
	}

	public void setPayeeidentitytype(String payeeidentitytype) {
		this.payeeidentitytype = payeeidentitytype;
	}

	public String getPayeeidentityid() {
		return this.payeeidentityid;
	}

	public void setPayeeidentityid(String payeeidentityid) {
		this.payeeidentityid = payeeidentityid;
	}

	public Date getPayeetime() {
		return this.payeetime;
	}

	public void setPayeetime(Date payeetime) {
		this.payeetime = payeetime;
	}

	public String getBloodstation() {
		return this.bloodstation;
	}

	public void setBloodstation(String bloodstation) {
		this.bloodstation = bloodstation;
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