package com.founder.rhip.ehr.entity.nc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "NC_HEALTH_CERTIFICATE")
public class NcHealthCertificate implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_CARD", columnDefinition = "VARCHAR2|身份证号码|18|", length = 18, nullable = false)
	private String idCard;

	@Column(name = "PERSON_NAME", columnDefinition = "VARCHAR2|姓名|50|", length = 50, nullable = true)
	private String personName;

	@Column(name = "IS_ISSUED", columnDefinition = "VARCHAR2|是/否发证|1|", length = 1, nullable = false)
	private String isIssued;

	@Column(name = "ISSUE_DATE", columnDefinition = "DATE|发证日期||", nullable = true)
	private Date issueDate;

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPersonName() {
		return this.personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getIsIssued() {
		return this.isIssued;
	}

	public void setIsIssued(String isIssued) {
		this.isIssued = isIssued;
	}

	public Date getIssueDate() {
		return this.issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

}