/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */
package com.founder.rhip.mdm.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MDM_ORGANIZATION_AREA_HISTORY")
public class OrganizationAreaHistory implements Serializable {

	private static final long serialVersionUID = -3783853941045983055L;
	
	@Id
	@Column(name = "ORGANIZATION_AREA_ID", columnDefinition = "NUMBER|机构ID||", length = 20, nullable = false)
	private Long organizationAreaId;
	
	@Column(name = "ORGANIZATION_CODE", columnDefinition = "VARCHAR2|中心或者站编码||", length = 20, nullable = false)
	private String organizationCode;

	@Column(name = "AREA_CODE", columnDefinition = "VARCHAR2|区域编码||", length = 50, nullable = true)
	private String areaCode;

	@Column(name = "OPERATOR", columnDefinition = "VARCHAR2|操作者||", length = 100, nullable = false)
	private String operator;

	@Column(name = "OPERATE_TIME", columnDefinition = "NUMBER|操作时间||", nullable = false)
	private Long operateTime;
	
	@Column(name = "OPERATE_TYPE", columnDefinition = "VARCHAR2|操作类型||", length = 50, nullable = true)
	private String operateType;
	
	@Column(name = "AREA_TYPE", columnDefinition = "VARCHAR2|区域类型||", length = 2, nullable = true)
	private String areaType;

	@Transient
	private String itemName;
	
	@Transient
	private String organName;

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public Long getOrganizationAreaId() {
		return organizationAreaId;
	}

	public void setOrganizationAreaId(Long organizationAreaId) {
		this.organizationAreaId = organizationAreaId;
	}

	public String getAreaType() {
		return areaType;
	}

	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}
}