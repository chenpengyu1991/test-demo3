package com.founder.rhip.ehr.entity.basic;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: Andy
 * Date: 13-6-5
 * Time: 下午3:35
 */
@Entity
@Table(name = "MDM_USER_OPERATION_LOG")
public class UserOperationLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = false)
    private Long id;
    @Column(name = "USER_NAME",columnDefinition = "VARCHAR2|登录用户名|50|", length = 50, nullable = true)
    private String userName;
    @Column(name = "ORG_CODE", columnDefinition = "VARCHAR2|登录机构编码|50|", length = 50, nullable = true)
    private String orgCode;
    @Column(name = "USER_IP", columnDefinition = "VARCHAR2|用户IP地址|50|", length = 50, nullable = true)
    private String userIp;
    @Column(name = "USER_REQUEST", columnDefinition = "VARCHAR2|请求地址|300|", length = 300, nullable = true)
    private String userRequest;
    @Column(name = "MODULE_NAME", columnDefinition = "VARCHAR2|登录模块名称|200|", length = 200, nullable = true)
    private String moduleName;
    @Column(name = "ACTION_NAME", columnDefinition = "VARCHAR2|模块功能名称|200|", length = 200, nullable = true)
    private String actionName;
    @Column(name = "OPERATION_NAME", columnDefinition = "VARCHAR2|具体操作|100|", length =100 , nullable = true)
    private String operationName;
    @Column(name = "OPERATION_TIME", columnDefinition = "DATE|操作时间||", nullable = true)
    private Date operationTime = new Date();
    @Column(name = "REMARK", columnDefinition = "VARCHAR2|备注|200|", length = 200, nullable = true)
    private String remark;

    private String name;

    private String idCard;

    private String sourceName;

	private Date beginTime;
	private Date endTime;

    private String stationOrganCode;

    private String centerOrganCode;

    private String gbcode;

    public String getStationOrganCode() {
        return stationOrganCode;
    }

    public void setStationOrganCode(String stationOrganCode) {
        this.stationOrganCode = stationOrganCode;
    }

    public String getCenterOrganCode() {
        return centerOrganCode;
    }

    public void setCenterOrganCode(String centerOrganCode) {
        this.centerOrganCode = centerOrganCode;
    }

    public String getGbcode() {
        return gbcode;
    }

    public void setGbcode(String gbcode) {
        this.gbcode = gbcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getUserRequest() {
        return userRequest;
    }

    public void setUserRequest(String userRequest) {
        this.userRequest = userRequest;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
