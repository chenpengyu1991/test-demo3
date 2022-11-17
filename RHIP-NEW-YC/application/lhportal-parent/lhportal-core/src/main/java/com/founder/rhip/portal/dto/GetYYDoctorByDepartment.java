package com.founder.rhip.portal.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetYYDoctorByDepartment implements Serializable {
	private static final long serialVersionUID = -1893167872644876493L;

	private String hospitalCode;
	private String deptSn;
	private String clinicType;
	
	public String getDeptSn() {
		return deptSn;
	}
	public void setDeptSn(String deptSn) {
		this.deptSn = deptSn;
	}
	public String getClinicType() {
		return clinicType;
	}
	public void setClinicType(String clinicType) {
		this.clinicType = clinicType;
	}
	public String getHospitalCode() {
		return hospitalCode;
	}
	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}
}