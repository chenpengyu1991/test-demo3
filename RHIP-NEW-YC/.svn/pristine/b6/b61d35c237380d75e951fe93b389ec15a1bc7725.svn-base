package com.founder.rhip.portal.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.founder.rhip.ehr.common.JaxbDateSerializer2;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataRow implements Serializable {
	private static final long serialVersionUID = -1893167872644876493L;

	@XmlElement(name="hospitalid")
	private String hospitalCode;
	
	@XmlElement(name="hospitalname")
	private String hospitalName;
	
	@XmlElement(name="deptcode")
	private String deptSn;
	
	@XmlElement(name="deptname")
	private String name;
	
	@XmlElement(name="scheduleid")
	private String scheduleid;
	
	@XmlElement(name="doctorno")
	private String doctorSn;
	
	@XmlElement(name="doctorname")
	private String doctorname;
	
	@XmlElement(name="registrationfee")
	private String registerFee;
	
	@XmlElement(name="outpdate")
	private String requestDate;
	
	@XmlElement(name="timeinterval")
	private String ampm;
	
	private String clinicfee;
	
	private String clinicType = "01";
	
	private int reserveflag;
	
	private String scheduleflag;
	
	public String getHospitalCode() {
		return hospitalCode;
	}
	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getDeptSn() {
		return deptSn;
	}
	public void setDeptSn(String deptSn) {
		this.deptSn = deptSn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScheduleid() {
		return scheduleid;
	}
	public void setScheduleid(String scheduleid) {
		this.scheduleid = scheduleid;
	}
	public String getDoctorSn() {
		return doctorSn;
	}
	public void setDoctorSn(String doctorSn) {
		this.doctorSn = doctorSn;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	
	public String getClinicType() {
		return clinicType;
	}
	public void setClinicType(String clinicType) {
		this.clinicType = clinicType;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public String getAmpm() {
		return ampm;
	}
	public void setAmpm(String ampm) {
		this.ampm = ampm;
	}
	public int getReserveflag() {
		return reserveflag;
	}
	public void setReserveflag(int reserveflag) {
		this.reserveflag = reserveflag;
	}
	public String getRegisterFee() {
		return registerFee;
	}
	public void setRegisterFee(String registerFee) {
		this.registerFee = registerFee;
	}
	public String getClinicfee() {
		return clinicfee;
	}
	public void setClinicfee(String clinicfee) {
		this.clinicfee = clinicfee;
	}
	public String getScheduleflag() {
		return scheduleflag;
	}
	public void setScheduleflag(String scheduleflag) {
		this.scheduleflag = scheduleflag;
	}
	
}
