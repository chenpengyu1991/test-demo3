package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "DM_POTENTIAL_PERSON_PARAM")
public class DmPotentialPersonParam implements Serializable {

	private static final long serialVersionUID = -9140871679015492230L;

	@Id
	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|潜在人员id||", length = 11, nullable = true)
	private Long personId;

	@Id
	@Column(name = "PARAMETER_ID", columnDefinition = "VARCHAR2|危险因素id||", length = 11, nullable = true)
	private String parameterId;
	
	@Column(name = "RESULT_VALUE", columnDefinition = "VARCHAR2|危险因素值||", length = 50, nullable = true)
	private String resultValue;
	
	

	public String getResultValue() {
		return resultValue;
	}

	public void setResultValue(String resultValue) {
		this.resultValue = resultValue;
	}

	public Long getPersonId() {
		return this.personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getParameterId() {
		return this.parameterId;
	}

	public void setParameterId(String parameterId) {
		this.parameterId = parameterId;
	}

}