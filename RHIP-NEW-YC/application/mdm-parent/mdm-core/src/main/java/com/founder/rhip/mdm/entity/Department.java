/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */
package com.founder.rhip.mdm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
@Table(name = "MDM_DEPARTMENT")
public class Department implements Serializable {
	
	private static final long serialVersionUID = -5517030507845132265L;

	public static final String DEPT_CODE = "deptCode";
	
	public static final String DEPT_ID = "deptId";
	
	public static final String ORGAN_CODE = "organCode";

	@Id
	@Column(name = "DEPT_ID", columnDefinition = "NUMBER|自增ID||", nullable = false)
	private Long deptId;
	
	@Column(name = "DEPT_CODE", columnDefinition = "VARCHAR2|机构科室编码||", length = 20, nullable = false)
	private String deptCode;

	@Column(name = "PARENT_CODE", columnDefinition = "VARCHAR2|上级科室编码||", length = 20, nullable = true)
	private String parentCode;

	@Column(name = "DEPT_FULL_NAME", columnDefinition = "VARCHAR2|机构科室全称||", length = 250, nullable = true)
	private String deptFullName;

	@Column(name = "DEPT_NAME", columnDefinition = "VARCHAR2|机构科室简称||", length = 250, nullable = true)
	private String deptName;

	@Column(name = "MANAGE_CODE", columnDefinition = "VARCHAR2|机构科室类别||", length = 20, nullable = true)
	private String manageCode;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|所属机构编码||", length = 20, nullable = true)
	private String organCode;

	@Column(name = "ORGAN_NAME", columnDefinition = "VARCHAR2|所属机构名称||", length = 250, nullable = true)
	private String organName;

	@Column(name = "TEL", columnDefinition = "VARCHAR2|科室电话||", length = 20, nullable = true)
	private String tel;

	@Column(name = "FAX", columnDefinition = "VARCHAR2|科室传真||", length = 20, nullable = true)
	private String fax;

	@Column(name = "MNUMBER", columnDefinition = "NUMBER|男性职工人数||", nullable = true)
	private Integer mnumber;

	@Column(name = "FNUMBER", columnDefinition = "NUMBER|女性职工人数||", nullable = true)
	private Integer fnumber;

	@Column(name = "START_DATE", columnDefinition = "DATE|科室成立日期||", nullable = true)
	private Date startDate;

	@Column(name = "END_DATE", columnDefinition = "DATE|科室撤销日期||", nullable = true)
	private Date endDate;

	@Column(name = "OPERATOR", columnDefinition = "VARCHAR2|操作者||", length = 100, nullable = false)
	private String operator;

	@Column(name = "OPERATE_TIME", columnDefinition = "NUMBER|操作时间||", nullable = false)
	private Long operateTime;
	
	@Column(name = "OPERATE_TYPE", columnDefinition = "VARCHAR2|操作类型||", length = 50, nullable = true)
	private String operateType;
	
	private List<Department> childs = new ArrayList<Department>();

	public String getDeptCode() {
		return this.deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getParentCode() {
		return this.parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getDeptFullName() {
		return this.deptFullName;
	}

	public void setDeptFullName(String deptFullName) {
		this.deptFullName = deptFullName;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getManageCode() {
		return this.manageCode;
	}

	public void setManageCode(String manageCode) {
		this.manageCode = manageCode;
	}

	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getOrganName() {
		return this.organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Integer getMnumber() {
		return this.mnumber;
	}

	public void setMnumber(Integer mnumber) {
		this.mnumber = mnumber;
	}

	public Integer getFnumber() {
		return this.fnumber;
	}

	public void setFnumber(Integer fnumber) {
		this.fnumber = fnumber;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Long getOperateTime() {
		return this.operateTime;
	}

	public void setOperateTime(Long operateTime) {
		this.operateTime = operateTime;
	}
	
	public void addChild(Department child) {
		child.setParentCode(deptCode);
		childs.add(child);
	}

	public List<Department> getChilds() {
		return childs;
	}

	public void setChilds(List<Department> childs) {
		this.childs = childs;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

}