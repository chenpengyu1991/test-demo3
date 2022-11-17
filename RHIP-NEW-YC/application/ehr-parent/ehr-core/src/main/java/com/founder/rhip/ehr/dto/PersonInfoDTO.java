package com.founder.rhip.ehr.dto;

import com.founder.rhip.ehr.common.IValidateDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;

import java.io.Serializable;

public class PersonInfoDTO implements IValidateDTO {
	private static final long serialVersionUID = -3979269886372258197L;
	private PersonInfo personInfo;

	private String recordStatus;
	
	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

}
