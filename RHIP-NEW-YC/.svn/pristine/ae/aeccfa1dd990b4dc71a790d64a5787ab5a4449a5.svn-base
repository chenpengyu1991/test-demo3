/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */
package com.founder.rhip.mdm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ORGAN_UPDATE_QUEUE")
public class OrganUpdateQueue implements Serializable {

	private static final long serialVersionUID = 7911786610032269232L;

	@Column(name = "NEW_ORGAN_CODE", columnDefinition = "VARCHAR2|新中心或者站编码||", length = 20, nullable = false)
	private String newOrganCode;

	@Column(name = "OLD_ORGAN_CODE", columnDefinition = "VARCHAR2|以往中心或者站编码||", length = 50, nullable = true)
	private String oldOrganCode;

	@Column(name = "GENRE_CODE", columnDefinition = "VARCHAR2|以往机构类型||", length = 100, nullable = false)
	private String genreCode;
	
	@Column(name = "UPDATE_FLAG", columnDefinition = "VARCHAR2|更新标志 默认为0 更新后为1||", length = 100, nullable = false)
	private String updateFlag = "0";
	
	@Column(name = "OPERATOR", columnDefinition = "VARCHAR2|操作者||", length = 100, nullable = false)
	private String operator;

	@Column(name = "OPERATE_TIME", columnDefinition = "NUMBER|操作时间||", nullable = false)
	private Long operateTime;
	
	@Column(name = "OPERATE_TYPE", columnDefinition = "VARCHAR2|操作类型||", length = 50, nullable = true)
	private String operateType;

	public String getNewOrganCode() {
		return newOrganCode;
	}

	public void setNewOrganCode(String newOrganCode) {
		this.newOrganCode = newOrganCode;
	}

	public String getOldOrganCode() {
		return oldOrganCode;
	}

	public void setOldOrganCode(String oldOrganCode) {
		this.oldOrganCode = oldOrganCode;
	}

	public String getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

	public String getUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Long getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Long operateTime) {
		this.operateTime = operateTime;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
}