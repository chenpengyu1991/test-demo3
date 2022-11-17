package com.founder.rhip.ehr.entity.nc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "NC_PUNISHMENT")
public class NcPunishment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_CARD", columnDefinition = "VARCHAR2|身份证号码|18|", length = 18, nullable = false)
	private String idCard;

	@Column(name = "PERSON_NAME", columnDefinition = "VARCHAR2|姓名|50|", length = 50, nullable = true)
	private String personName;

	@Column(name = "PUNISHED_DATE", columnDefinition = "DATE|日期||", nullable = true)
	private Date punishedDate;

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

	public Date getPunishedDate() {
		return this.punishedDate;
	}

	public void setPunishedDate(Date punishedDate) {
		this.punishedDate = punishedDate;
	}

}