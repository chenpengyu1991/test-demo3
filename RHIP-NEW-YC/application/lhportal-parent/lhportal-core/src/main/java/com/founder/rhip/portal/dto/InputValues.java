package com.founder.rhip.portal.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class InputValues implements Serializable {
	
	private static final long serialVersionUID = -7929059661181887908L;
	
	private String reservemobile;
	
	private String hospitalid;
	
	private String scheduleid;

	private String parttimeid;

	private String creator;

	private String orderid;
	

	public String getReservemobile() {
		return reservemobile;
	}

	public void setReservemobile(String reservemobile) {
		this.reservemobile = reservemobile;
	}

	public String getHospitalid() {
		return hospitalid;
	}

	public void setHospitalid(String hospitalid) {
		this.hospitalid = hospitalid;
	}

	public String getScheduleid() {
		return scheduleid;
	}

	public void setScheduleid(String scheduleid) {
		this.scheduleid = scheduleid;
	}

	public String getParttimeid() {
		return parttimeid;
	}

	public void setParttimeid(String parttimeid) {
		this.parttimeid = parttimeid;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	
}
