package com.founder.rhip.portal.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.JaxbDateSerializer;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchReserve implements Serializable {
	private static final long serialVersionUID = -1893167872644876493L;

	private String hospitalCode;
	private String idcard;
	private String name;
	private String searchCode;
	
	private String reserverStauts;
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date startRequestDate;
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date endRequestDate;
	
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSearchCode() {
		return searchCode;
	}
	public void setSearchCode(String searchCode) {
		this.searchCode = searchCode;
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
	public String getHospitalCode() {
		return hospitalCode;
	}
	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}
	
	public String getReserverStauts() {
		return reserverStauts;
	}
	public void setReserverStauts(String reserverStauts) {
		this.reserverStauts = reserverStauts;
	}
	public Criteria getCriteria(){
		Criteria criteria = new Criteria("hospitalCode", this.getHospitalCode());
		if(ObjectUtil.isNotEmpty(this.getSearchCode())){
			criteria.add("searchCode", this.getSearchCode());
		}
		if(ObjectUtil.isNotEmpty(this.getIdcard())){
			criteria.add("idcard", this.getIdcard());
		}
		if(ObjectUtil.isNotEmpty(this.getName())){
			criteria.add("name", this.getName());
		}
		if(ObjectUtil.isNotEmpty(this.getReserverStauts())){
			criteria.add("reserverStauts", this.getReserverStauts());
		}
		
		DateUtil.getCriteriaByDateRange(criteria, "requestDate", this.getStartRequestDate(), this.getEndRequestDate());
		return criteria;
	}
	
}
