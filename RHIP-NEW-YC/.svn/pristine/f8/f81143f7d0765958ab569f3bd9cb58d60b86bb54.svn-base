package com.founder.rhip.portal.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.portal.common.TransCodeConstants;

import java.io.Serializable;

@XmlRootElement(name = "Req")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetDeptmentListRequestFY implements Serializable{

	private static final long serialVersionUID = -6214498425729538842L;
	
	//0所有科室，1有排班科室
	private static final String TYPE="0";
	
	//0-全天 1-上午 2-下午
	private static final String WORKTIME = "0";
	
	private String oracode = TransCodeConstants.ORACODE;

	private String oraauthcode = TransCodeConstants.ORAAUTHCODE;
	

	private String TransactionCode = TransCodeConstants.QUERY_CLINIC;
	
	private String Type = TYPE;

	private String WorkTime = WORKTIME;

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getOracode() {
		return oracode;
	}

	public void setOracode(String oracode) {
		this.oracode = oracode;
	}

	public String getOraauthcode() {
		return oraauthcode;
	}

	public void setOraauthcode(String oraauthcode) {
		this.oraauthcode = oraauthcode;
	}

	public String getTransactionCode() {
		return TransactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		TransactionCode = transactionCode;
	}

	public String getWorkTime() {
		return WorkTime;
	}

	public void setWorkTime(String workTime) {
		WorkTime = workTime;
	}

}
