package com.founder.rhip.portal.service.form;

import java.util.Date;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;

public class ReserveSearchForm {
	
	private String hospital;
	private String clinic;
	private String name;
	private String idcard;
	private String regFrom;
	private Date requestDateBegin;
	private Date requestDateEnd;
	private Date submitDateBegin;
	private Date submitDateEnd;
	private String reserveStauts;
	
	private String ampm;
	
	private String doctorName;
	private String frequentName;
	
	public Criteria getCriteria(){
		Criteria criteria = new Criteria();
		
		if(ObjectUtil.isNotEmpty(hospital)){
			criteria.add("hospitalCode", hospital);
		}

		if(ObjectUtil.isNotEmpty(frequentName)){
			criteria.add("name", frequentName);
		} else {
			
			if(ObjectUtil.isNotEmpty(name)){
				criteria.add("name",OP.LIKE, name);
			}
			
			if(ObjectUtil.isNotEmpty(idcard)){
				criteria.add("idcard", idcard);
			}
		}
		
		
		if(ObjectUtil.isNotEmpty(clinic)){
			criteria.add("deptSn", clinic);
		}
		
		if(ObjectUtil.isNotEmpty(regFrom)){
			criteria.add("regFrom", regFrom);
		}
		
		if(ObjectUtil.isNotEmpty(reserveStauts)){
			criteria.add("RESERVER_STAUTS", reserveStauts);
		}
		
		if(ObjectUtil.isNotEmpty(doctorName)){
			criteria.add("doctorName",OP.LIKE, doctorName);
		}
		if(ObjectUtil.isNotEmpty(ampm)){
			criteria.add("ampm", ampm);
		}
		
		DateUtil.getCriteriaByDateRange(criteria, "requestDate", requestDateBegin, requestDateEnd);
		DateUtil.getCriteriaByDateRange(criteria, "submitDate", submitDateBegin, submitDateEnd);
		return criteria;
	}
	
	public String getAmpm() {
		return ampm;
	}


	public void setAmpm(String ampm) {
		this.ampm = ampm;
	}


	public String getDoctorName() {
		return doctorName;
	}


	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}


	public String getReserveStauts() {
		return reserveStauts;
	}

	public void setReserveStauts(String reserveStauts) {
		this.reserveStauts = reserveStauts;
	}

	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getClinic() {
		return clinic;
	}
	public void setClinic(String clinic) {
		this.clinic = clinic;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public Date getRequestDateBegin() {
		return requestDateBegin;
	}

	public void setRequestDateBegin(Date requestDateBegin) {
		this.requestDateBegin = requestDateBegin;
	}

	public Date getRequestDateEnd() {
		return requestDateEnd;
	}

	public void setRequestDateEnd(Date requestDateEnd) {
		this.requestDateEnd = requestDateEnd;
	}

	public Date getSubmitDateBegin() {
		return submitDateBegin;
	}

	public void setSubmitDateBegin(Date submitDateBegin) {
		this.submitDateBegin = submitDateBegin;
	}

	public Date getSubmitDateEnd() {
		return submitDateEnd;
	}

	public void setSubmitDateEnd(Date submitDateEnd) {
		this.submitDateEnd = submitDateEnd;
	}

	public String getRegFrom() {
		return regFrom;
	}

	public void setRegFrom(String regFrom) {
		this.regFrom = regFrom;
	}

	public String getFrequentName() {
		return frequentName;
	}

	public void setFrequentName(String frequentName) {
		this.frequentName = frequentName;
	}

}
