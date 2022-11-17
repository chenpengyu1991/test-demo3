package com.founder.rhip.portal.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.portal.common.TransCodeConstants;

import java.io.Serializable;

@XmlRootElement(name = "Req")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaveReserveRequestFY implements Serializable{

	private static final long serialVersionUID = 1505407048520217546L;

	private String oracode = TransCodeConstants.ORACODE;

	private String oraauthcode = TransCodeConstants.ORAAUTHCODE;

	private String TransactionCode = TransCodeConstants.RESERVE_REGISTER;

	private String OrderID;

	private String IDCardNo;

	private String CardNo;

	private String Mobile;

	private String Name;

	//"1" 上午  "2" 下午
	private String WorkType;

	private String DeptCode;

	private String DocCode;

	private String STime;

	private String UserId;

	private String WorkDate;

	private String CustomTime;

	private String SickID;
	
	public String getDocCode() {
		return DocCode;
	}

	public void setDocCode(String docCode) {
		DocCode = docCode;
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

	public String getOrderID() {
		return OrderID;
	}

	public void setOrderID(String orderID) {
		OrderID = orderID;
	}

	public String getIDCardNo() {
		return IDCardNo;
	}

	public void setIDCardNo(String IDCardNo) {
		this.IDCardNo = IDCardNo;
	}

	public String getCardNo() {
		return CardNo;
	}

	public void setCardNo(String cardNo) {
		CardNo = cardNo;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getWorkType() {
		return WorkType;
	}

	public void setWorkType(String workType) {
		WorkType = workType;
	}

	public String getDeptCode() {
		return DeptCode;
	}

	public void setDeptCode(String deptCode) {
		DeptCode = deptCode;
	}

	public String getSTime() {
		return STime;
	}

	public void setSTime(String STime) {
		this.STime = STime;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getWorkDate() {
		return WorkDate;
	}

	public void setWorkDate(String workDate) {
		WorkDate = workDate;
	}

	public String getCustomTime() {
		return CustomTime;
	}

	public void setCustomTime(String customTime) {
		CustomTime = customTime;
	}

	public String getSickID() {
		return SickID;
	}

	public void setSickID(String sickID) {
		SickID = sickID;
	}
	
}
