package com.founder.rhip.ehr.entity.jj;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "JJ_TACCEPTEVENT")
public class JjTacceptevent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ACCEPT_NO", columnDefinition = "VARCHAR2|受理编码|50|", length = 50, nullable = false)
	private String acceptNo;

	@Column(name = "EVENT_NO", columnDefinition = "VARCHAR2|事件编码|50|", length = 50, nullable = true)
	private String eventNo;

	@Column(name = "ACCEPT_TYPE", columnDefinition = "VARCHAR2|受理类型|50|", length = 50, nullable = true)
	private String acceptType;

	@Column(name = "ASSIGNEE", columnDefinition = "VARCHAR2|受理人|20|", length = 20, nullable = true)
	private String assignee;

	@Column(name = "RING_TIME", columnDefinition = "DATE|电话振铃时刻||", nullable = true)
	private Date ringTime;

	@Column(name = "BEGIN_TIME", columnDefinition = "DATE|开始受理时刻||", nullable = true)
	private Date beginTime;

	@Column(name = "END_TIME", columnDefinition = "DATE|结束受理时刻||", nullable = true)
	private Date endTime;

	@Column(name = "ORDER_TIME", columnDefinition = "DATE|发送指令时刻||", nullable = true)
	private Date orderTime;

	@Column(name = "LOCALE_ADDR", columnDefinition = "VARCHAR2|现场地址|200|", length = 200, nullable = true)
	private String localeAddr;

	@Column(name = "WAITING_ADDR", columnDefinition = "VARCHAR2|等车地址|100|", length = 100, nullable = true)
	private String waitingAddr;

	@Column(name = "SEND_TO_ADDR", columnDefinition = "VARCHAR2|送往地址|100|", length = 100, nullable = true)
	private String sendToAddr;

	@Column(name = "FROM_CALL", columnDefinition = "VARCHAR2|呼救电话|20|", length = 20, nullable = true)
	private String fromCall;

	@Column(name = "PAT_NAME", columnDefinition = "VARCHAR2|患者姓名|40|", length = 40, nullable = true)
	private String patName;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别|10|", length = 10, nullable = true)
	private String gender;

	@Column(name = "AGE", columnDefinition = "VARCHAR2|年龄|20|", length = 20, nullable = true)
	private String age;

	@Column(name = "DISEASE_DISCRIBE", columnDefinition = "VARCHAR2|病种判断|100|", length = 100, nullable = true)
	private String diseaseDiscribe;

	public String getAcceptNo() {
		return this.acceptNo;
	}

	public void setAcceptNo(String acceptNo) {
		this.acceptNo = acceptNo;
	}

	public String getEventNo() {
		return this.eventNo;
	}

	public void setEventNo(String eventNo) {
		this.eventNo = eventNo;
	}

	public String getAcceptType() {
		return this.acceptType;
	}

	public void setAcceptType(String acceptType) {
		this.acceptType = acceptType;
	}

	public String getAssignee() {
		return this.assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public Date getRingTime() {
		return this.ringTime;
	}

	public void setRingTime(Date ringTime) {
		this.ringTime = ringTime;
	}

	public Date getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getLocaleAddr() {
		return this.localeAddr;
	}

	public void setLocaleAddr(String localeAddr) {
		this.localeAddr = localeAddr;
	}

	public String getWaitingAddr() {
		return this.waitingAddr;
	}

	public void setWaitingAddr(String waitingAddr) {
		this.waitingAddr = waitingAddr;
	}

	public String getSendToAddr() {
		return this.sendToAddr;
	}

	public void setSendToAddr(String sendToAddr) {
		this.sendToAddr = sendToAddr;
	}

	public String getFromCall() {
		return this.fromCall;
	}

	public void setFromCall(String fromCall) {
		this.fromCall = fromCall;
	}

	public String getPatName() {
		return this.patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDiseaseDiscribe() {
		return this.diseaseDiscribe;
	}

	public void setDiseaseDiscribe(String diseaseDiscribe) {
		this.diseaseDiscribe = diseaseDiscribe;
	}

}