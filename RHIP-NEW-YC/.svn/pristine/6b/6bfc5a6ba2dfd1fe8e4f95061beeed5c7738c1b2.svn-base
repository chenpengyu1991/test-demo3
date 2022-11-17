package com.founder.rhip.portal.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.founder.rhip.ehr.common.JaxbDateSerializer2;

@XmlAccessorType(XmlAccessType.FIELD)
public class Dept implements Serializable {
	private static final long serialVersionUID = -1893167872644876493L;

	@XmlElement(name="UpperDeptCode")
	private String deptSn;
	
	@XmlElement(name="UpperDeptName")
	private String deptName;

	public String getDeptSn() {
		return deptSn;
	}

	public void setDeptSn(String deptSn) {
		this.deptSn = deptSn;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
}
