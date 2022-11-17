package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * jiang haiying 保存建档时的建档单位建档人建档日期
 */
@Entity
@Table(name = "BI_PERSON_INPUT_INFO")
public class PersonInputInfo implements Serializable {

	private static final long serialVersionUID = -7313564364933619294L;

	@Id
	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|personId|11|", length = 11, nullable = false)
	private Long personId;

	@Column(name = "INPUTER_ID", columnDefinition = "VARCHAR2|建档人员ID||", length = 50, nullable = true)
	private String inputerId;

	@Column(name = "INPUT_ORGAN_CODE", columnDefinition = "VARCHAR2|建档机构编码||", length = 15, nullable = true)
	private String inputOrganCode;

	@Column(name = "INPUT_DATE", columnDefinition = "DATE|建档日期||", nullable = true)
	private Date inputDate;

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getInputerId() {
		return inputerId;
	}

	public void setInputerId(String inputerId) {
		this.inputerId = inputerId;
	}

	public String getInputOrganCode() {
		return inputOrganCode;
	}

	public void setInputOrganCode(String inputOrganCode) {
		this.inputOrganCode = inputOrganCode;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
}