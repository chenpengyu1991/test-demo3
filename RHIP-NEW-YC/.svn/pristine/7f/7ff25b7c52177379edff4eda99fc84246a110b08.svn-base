package com.founder.rhip.ehr.entity.basic;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "HE_ACTIVE_RH")
public class ActivityInfoRh implements Serializable{
	
	private static final long serialVersionUID = 5L;
	
	@Id
	@Column(name = "Id", columnDefinition = "NUMBER|活动标识|11|", length = 11, nullable = false)
	private Long id;
	
	@Column(name = "ORG_CODE", columnDefinition = "VARCHAR2|原机构编码||", length = 18, nullable= true)
	private String inputOrganCode;
	
	@Column(name = "CENTER_ORG_CODE", columnDefinition = "VARCHAR2|中心机构编码||", length = 18, nullable= true)
	private String centerOrganCode;
	
	@Column(name = "GBCODE", columnDefinition = "VARCHAR2|行政区编码||", length = 18, nullable= true)
	private String gbCode;
	
	@Column(name = "RECORD_CHANGE_TIME", columnDefinition = "DATE|迁移时间||", nullable= true)
	private Date recordChangeTime;
	
	//活动类型
	private String activityType;
	
	//活动主题
	private String activityName;
	
	//活动时间
	private Date activityTime;
	
	//操作者
	private String operator;
	
	 //现机构编码
    private String currentOrganCode;

	public String getCurrentOrganCode() {
		return currentOrganCode;
	}

	public void setCurrentOrganCode(String currentOrganCode) {
		this.currentOrganCode = currentOrganCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInputOrganCode() {
		return inputOrganCode;
	}

	public void setInputOrganCode(String inputOrganCode) {
		this.inputOrganCode = inputOrganCode;
	}

	public String getCenterOrganCode() {
		return centerOrganCode;
	}

	public void setCenterOrganCode(String centerOrganCode) {
		this.centerOrganCode = centerOrganCode;
	}

	public String getGbCode() {
		return gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public Date getRecordChangeTime() {
		return recordChangeTime;
	}

	public void setRecordChangeTime(Date recordChangeTime) {
		this.recordChangeTime = recordChangeTime;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Date getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(Date activityTime) {
		this.activityTime = activityTime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	
}

