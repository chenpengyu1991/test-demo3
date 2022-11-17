package com.founder.rhip.portal.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
public class QueryReserve implements Serializable {
	private static final long serialVersionUID = -1893167872644876493L;

	private String idcard;
	private String searchCode;
	private String ehrId;//新增一个变量EHR_ID
	
	@XmlElement
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	@XmlElement
	public String getSearchCode() {
		return searchCode;
	}
	public void setSearchCode(String searchCode) {
		this.searchCode = searchCode;
	}
	@XmlElement
	public String getEhrId() {
		return ehrId;
	}
	public void setEhrId(String ehrId) {
		this.ehrId = ehrId;
	}
}
