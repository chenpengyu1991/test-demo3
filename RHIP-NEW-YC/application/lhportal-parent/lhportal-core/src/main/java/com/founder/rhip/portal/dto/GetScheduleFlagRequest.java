package com.founder.rhip.portal.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetScheduleFlagRequest implements Serializable{
	private static final long serialVersionUID = -1893167872644876493L;
	private static final String REQUSETID = "weixin";
	
	private String requestid = REQUSETID;

	private PageActionIn pageactionin;
	
	private Retrieveargs retrieveargs;

	public String getRequestid() {
		return requestid;
	}

	public void setRequestid(String requestid) {
		this.requestid = requestid;
	}


	public PageActionIn getPageactionin() {
		return pageactionin;
	}

	public void setPageactionin(PageActionIn pageactionin) {
		this.pageactionin = pageactionin;
	}

	public Retrieveargs getRetrieveargs() {
		return retrieveargs;
	}

	public void setRetrieveargs(Retrieveargs retrieveargs) {
		this.retrieveargs = retrieveargs;
	}

	

	
}
