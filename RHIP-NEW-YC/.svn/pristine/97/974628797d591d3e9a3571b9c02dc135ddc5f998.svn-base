package com.founder.rhip.ehr.entity.nc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "NC_CHILD_EXAMINATION")
public class NcChildExamination implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_CARD", columnDefinition = "VARCHAR2|身份证号码|18|", length = 18, nullable = false)
	private String idCard;

	@Column(name = "PERSON_NAME", columnDefinition = "VARCHAR2|姓名|50|", length = 50, nullable = true)
	private String personName;

	@Column(name = "IS_REGULAR", columnDefinition = "VARCHAR2|是否定期检查|1|", length = 1, nullable = false)
	private String isRegular;

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

	public String getIsRegular() {
		return this.isRegular;
	}

	public void setIsRegular(String isRegular) {
		this.isRegular = isRegular;
	}

}