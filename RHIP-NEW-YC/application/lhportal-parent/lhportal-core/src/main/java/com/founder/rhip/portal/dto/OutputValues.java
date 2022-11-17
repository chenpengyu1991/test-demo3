package com.founder.rhip.portal.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class OutputValues implements Serializable {
	
	private static final long serialVersionUID = -1274509236958653569L;

	private String ordertime;
	
	private String pinkey;
	
	private String registrationfee;

	private String clinicfee;

	private String reservefee;

	private String payregfee;
	
	private String orderid;

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}

	public String getPinkey() {
		return pinkey;
	}

	public void setPinkey(String pinkey) {
		this.pinkey = pinkey;
	}

	public String getRegistrationfee() {
		return registrationfee;
	}

	public void setRegistrationfee(String registrationfee) {
		this.registrationfee = registrationfee;
	}

	public String getClinicfee() {
		return clinicfee;
	}

	public void setClinicfee(String clinicfee) {
		this.clinicfee = clinicfee;
	}

	public String getReservefee() {
		return reservefee;
	}

	public void setReservefee(String reservefee) {
		this.reservefee = reservefee;
	}

	public String getPayregfee() {
		return payregfee;
	}

	public void setPayregfee(String payregfee) {
		this.payregfee = payregfee;
	}

	
}
