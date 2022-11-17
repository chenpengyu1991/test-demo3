package com.founder.rhip.portal.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class NewOrderRequest implements Serializable{

	private static final long serialVersionUID = -513687139646536026L;

	private static final String REQUSETID = "weixin";
	
	private String requestid = REQUSETID;

	private InputValues inputvalues;

	public String getRequestid() {
		return requestid;
	}

	public void setRequestid(String requestid) {
		this.requestid = requestid;
	}

	public InputValues getInputvalues() {
		return inputvalues;
	}

	public void setInputvalues(InputValues inputvalues) {
		this.inputvalues = inputvalues;
	}

	
	
}
