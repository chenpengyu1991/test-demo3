package com.founder.rhip.ehr.dto;

import com.founder.rhip.ehr.entity.basic.PersonCanceledInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfo;

import java.io.Serializable;

public class PersonRecordOffDTO implements Serializable {
	private static final long serialVersionUID = 7058978460129848652L;
	
	//个人基本信息表中基本信息
	private PersonInfo personInfo;
	
	//注销信息
	private PersonCanceledInfo personCanceledInfo;

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	

	public PersonCanceledInfo getPersonCanceledInfo() {
		return personCanceledInfo;
	}

	public void setPersonCanceledInfo(PersonCanceledInfo personCanceledInfo) {
		this.personCanceledInfo = personCanceledInfo;
	}
	
}
