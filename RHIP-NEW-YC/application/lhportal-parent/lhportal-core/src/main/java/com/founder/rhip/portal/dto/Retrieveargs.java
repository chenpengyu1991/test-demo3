package com.founder.rhip.portal.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.founder.rhip.ehr.common.JaxbDateSerializer2;

@XmlAccessorType(XmlAccessType.FIELD)
public class Retrieveargs implements Serializable {
	private static final long serialVersionUID = -1893167872644876493L;
	
	/*银川第一人民医院的id*/
	private static final String HOSPITALID = "001";
	
	private String begindate;
	private String hospitalid = HOSPITALID;
	
	@XmlElement(nillable=true)
	private String deptcode;
	
	@XmlJavaTypeAdapter(JaxbDateSerializer2.class)
	@XmlElement(name="outpdate_start")
	private Date startRequestDate;
	
	@XmlJavaTypeAdapter(JaxbDateSerializer2.class)
	@XmlElement(name="outpdate_end")
	private Date endRequestDate;
	
	@XmlElement(nillable=true)
	private String timeinterval;
	@XmlElement(nillable=true)
	private String doctorno;
	@XmlElement(nillable=true)
	private String specialty;
	
	private String scheduleid;
	
	public String getBegindate() {
		return begindate;
	}
	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}
	public String getHospitalid() {
		return hospitalid;
	}
	public void setHospitalid(String hospitalid) {
		this.hospitalid = hospitalid;
	}
	public String getDeptcode() {
		return deptcode;
	}
	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
	}
	public Date getStartRequestDate() {
		return startRequestDate;
	}
	public void setStartRequestDate(Date startRequestDate) {
		this.startRequestDate = startRequestDate;
	}
	public Date getEndRequestDate() {
		return endRequestDate;
	}
	public void setEndRequestDate(Date endRequestDate) {
		this.endRequestDate = endRequestDate;
	}
	public String getTimeinterval() {
		return timeinterval;
	}
	public void setTimeinterval(String timeinterval) {
		this.timeinterval = timeinterval;
	}
	public String getDoctorno() {
		return doctorno;
	}
	public void setDoctorno(String doctorno) {
		this.doctorno = doctorno;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getScheduleid() {
		return scheduleid;
	}
	public void setScheduleid(String scheduleid) {
		this.scheduleid = scheduleid;
	}

	
}
