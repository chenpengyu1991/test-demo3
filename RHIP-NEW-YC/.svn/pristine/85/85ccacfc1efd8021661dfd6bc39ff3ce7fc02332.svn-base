package com.founder.rhip.ehr.entity.child;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "CH_UNDERTHREE_MANAGEMENT")
public class ChildUnderThreeManage implements Serializable{
	
	@Column(name = "MONTH_RECORD", columnDefinition = "VARCHAR2|时间||", length = 20, nullable = true)
	private String monthRecord;
	
	@Column(name = "UNDERTHREE_NUMBER", columnDefinition = "NUMBER|三岁以下孩童数量||", length = 11, nullable = false)
	private Long underThreeNumber;
	
	@Column(name = "MANAGEMENT_NUMBER", columnDefinition = "NUMBER|系统管理儿童数量||", length = 11, nullable = false)
	private Long managementNumber;
	
	@Column(name = "GBCODE", columnDefinition = "VARCHAR2|机构编码||", length = 20, nullable = false)
	private String gbCode;
	
	//系统管理率
	private Double managementRate;

	public String getMonthRecord() {
		return monthRecord;
	}

	public void setMonthRecord(String monthRecord) {
		this.monthRecord = monthRecord;
	}

	public Long getUnderThreeNumber() {
		return underThreeNumber;
	}

	public void setUnderThreeNumber(Long underThreeNumber) {
		this.underThreeNumber = underThreeNumber;
	}

	public Long getManagementNumber() {
		return managementNumber;
	}

	public void setManagementNumber(Long managementNumber) {
		this.managementNumber = managementNumber;
	}

	public String getGbCode() {
		return gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public Double getManagementRate() {
		return managementRate;
	}

	public void setManagementRate(Double managementRate) {
		this.managementRate = managementRate;
	}
	
	
}

