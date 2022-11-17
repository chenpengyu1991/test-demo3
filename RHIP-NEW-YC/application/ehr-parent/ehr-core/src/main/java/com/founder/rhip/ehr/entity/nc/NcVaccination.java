package com.founder.rhip.ehr.entity.nc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "NC_VACCINATION")
public class NcVaccination implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_CARD", columnDefinition = "VARCHAR2|身份证号码|18|", length = 18, nullable = false)
	private String idCard;

	@Column(name = "PERSON_NAME", columnDefinition = "VARCHAR2|姓名|50|", length = 50, nullable = true)
	private String personName;

	@Column(name = "BRITHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
	private Date birthday;

	@Column(name = "PARENT_NAME", columnDefinition = "VARCHAR2|父亲姓名/母亲姓名|50|", length = 50, nullable = true)
	private String parentName;

	@Column(name = "IS_COMPLETE", columnDefinition = "VARCHAR2|预防接种是否齐全|1|", length = 1, nullable = false)
	private String isComplete;

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

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getParentName() {
		return this.parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getIsComplete() {
		return this.isComplete;
	}

	public void setIsComplete(String isComplete) {
		this.isComplete = isComplete;
	}

}