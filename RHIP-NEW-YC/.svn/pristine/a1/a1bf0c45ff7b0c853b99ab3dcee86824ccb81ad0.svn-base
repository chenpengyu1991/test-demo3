package com.founder.rhip.ehr.entity.wsMonitor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="WS_OPERATION_LOG")
public class WsOperationLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|数据库唯一编号（自增长）|11|",length=11,nullable=false)
	private Long id;

	@Column(name="CLIENT_ID",columnDefinition="NUMBER|客户端信息表ID|11|",length=11,nullable=false)
	private Long clientId;

	@Column(name="USER_IP",columnDefinition="VARCHAR2|来访机器IP地址|50|",length=50,nullable=true)
	private String userIp;

	@Column(name="START_TIME",columnDefinition="DATE|请求开始时间||",nullable=true)
	private Date startTime;

	@Column(name="IS_SUCCESS",columnDefinition="VARCHAR2|处理成功标志|1|",length=1,nullable=true)
	private String isSuccess;

	@Column(name="END_TIME",columnDefinition="DATE|请求结束时间||",nullable=true)
	private Date endTime;

	@Column(name="REQUEST_MEG",columnDefinition="CLOB|请求消息||",nullable=true)
	private String requestMeg;

	@Column(name="RESPONSE_MEG",columnDefinition="CLOB|响应消息||",nullable=true)
	private String responseMeg;

	@Column(name="WEB_SERVICE_NAME",columnDefinition="VARCHAR2|接口名称(KEY)|100|",length=100,nullable=true)
	private String webServiceName;

	@Column(name="WS_METHOD_NAME",columnDefinition="VARCHAR2|接口方法名称|100|",length=100,nullable=true)
	private String wsMethodName;

	@Column(name="OPERATION_NAME",columnDefinition="VARCHAR2|操作类别|50|",length=50,nullable=true)
	private String operationName;

	@Column(name="REMARK",columnDefinition="VARCHAR2|备注|200|",length=200,nullable=true)
	private String remark;

	@Transient
	private String orgCode;


	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClientId() {
		return this.clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getUserIp() {
		return this.userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getIsSuccess() {
		return this.isSuccess;
	}

	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getRequestMeg() {
		return this.requestMeg;
	}

	public void setRequestMeg(String requestMeg) {
		this.requestMeg = requestMeg;
	}

	public String getResponseMeg() {
		return this.responseMeg;
	}

	public void setResponseMeg(String responseMeg) {
		this.responseMeg = responseMeg;
	}

	public String getWebServiceName() {
		return this.webServiceName;
	}

	public void setWebServiceName(String webServiceName) {
		this.webServiceName = webServiceName;
	}

	public String getWsMethodName() {
		return this.wsMethodName;
	}

	public void setWsMethodName(String wsMethodName) {
		this.wsMethodName = wsMethodName;
	}

	public String getOperationName() {
		return this.operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}