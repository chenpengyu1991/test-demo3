package com.founder.rhip.portal.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@XmlRootElement(name = "Resp")
@XmlAccessorType(XmlAccessType.FIELD)
public class NoCardPreRegResponseFY implements Serializable {

	private static final long serialVersionUID = 577024078443982329L;
	
	private String TransactionCode;
	
	private String RespMessage;
	
	private String RespCode;
	
	private String SickID;

	public String getTransactionCode() {
		return TransactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		TransactionCode = transactionCode;
	}

	public String getRespMessage() {
		return RespMessage;
	}

	public void setRespMessage(String respMessage) {
		RespMessage = respMessage;
	}

	public String getRespCode() {
		return RespCode;
	}

	public void setRespCode(String respCode) {
		RespCode = respCode;
	}

	public String getSickID() {
		return SickID;
	}

	public void setSickID(String sickID) {
		SickID = sickID;
	}
	
}
