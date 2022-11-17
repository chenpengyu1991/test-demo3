package com.founder.rhip.ehr.entity.basic;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FS_INTEGRATION_MONITOR")
public class IntegrationMonitor implements Serializable {

	private static final long serialVersionUID = -1135822217236977004L;
	
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;
	
	@Column(name = "NUMBER_CODE", columnDefinition = "VARCHAR2|编号代码||", length = 10, nullable = true)
	private String numberCode;
	
	@Column(name = "NUMBER_NAME", columnDefinition = "VARCHAR2|编号名称||", length = 50, nullable = true)
	private String numberName;
	
	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|机构代码||", length = 15, nullable = true)
	private String organCode;
	
	@Column(name = "ORGAN_NAME", columnDefinition = "VARCHAR2|机构名称||", length = 100, nullable = true)
	private String organName;
	
	@Column(name = "FLOW_TYPE", columnDefinition = "VARCHAR2|流程类型||", length = 6, nullable = true)
	private String flowType;
	
	@Column(name = "FLOW_NAME", columnDefinition = "VARCHAR2|流程名称||", length = 50, nullable = true)
	private String flowName;
	
	@Column(name = "IP_ADDRESS", columnDefinition = "VARCHAR2|IP地址||", length = 50, nullable = true)
	private String ipAddress;
	
	@Column(name = "FRONT_UPLOAD_COUNT", columnDefinition = "VARCHAR2|应传数据－前置机||", length = 8, nullable = true)
	private Long frontUploadCount;
	
	@Column(name = "MIDDLE_UPLOAD_COUNT", columnDefinition = "VARCHAR2|应传数据－中间库||", length = 8, nullable = true)
	private Long middleUploadCount;
	
	@Column(name = "FACT_UPLOAD_COUNT", columnDefinition = "VARCHAR2|实际上传数据||", length = 8, nullable = true)
	private Long factUploadCount;
	
	@Column(name = "FACT_ADD_COUNT", columnDefinition = "VARCHAR2|实际新增数据||", length = 8, nullable = true)
	private Long factAddCount;
	
	@Column(name = "FACT_UPDATE_COUNT", columnDefinition = "VARCHAR2|实际更新数据||", length = 8, nullable = true)
	private Long factUpdateCount;
	
	@Column(name = "FACT_FAIL_COUNT", columnDefinition = "VARCHAR2|实际失败数据||", length = 8, nullable = true)
	private Long factFailCount;
	
	@Column(name = "RECORD_DATE", columnDefinition = "DATE|记录时间||", nullable = true)
	private Date recordDate;
	
	@Column(name = "RECORD_NAME", columnDefinition = "VARCHAR2|记录人姓名||", length = 50, nullable = true)
	private String recordName;
	
	@Column(name = "UPDATE_DATE", columnDefinition = "DATE|修改时间||", nullable = true)
	private Date updateDate;
	
	@Column(name = "UPDATE_NAME", columnDefinition = "VARCHAR2|修改人姓名||", length = 50, nullable = true)
	private String updateName;
	
	@Column(name = "STATUS", columnDefinition = "NUMBER|状态||", length = 1, nullable = true)
	private Integer status;

	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getNumberCode() {
		return numberCode;
	}

	
	public void setNumberCode(String numberCode) {
		this.numberCode = numberCode;
	}

	
	public String getNumberName() {
		return numberName;
	}

	
	public void setNumberName(String numberName) {
		this.numberName = numberName;
	}

	
	public String getOrganCode() {
		return organCode;
	}

	
	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	
	public String getOrganName() {
		return organName;
	}

	
	public void setOrganName(String organName) {
		this.organName = organName;
	}

	
	public String getFlowType() {
		return flowType;
	}

	
	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}

	
	public String getFlowName() {
		return flowName;
	}

	
	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	
	public String getIpAddress() {
		return ipAddress;
	}

	
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	
	public Long getFrontUploadCount() {
		return frontUploadCount;
	}

	
	public void setFrontUploadCount(Long frontUploadCount) {
		this.frontUploadCount = frontUploadCount;
	}

	
	public Long getMiddleUploadCount() {
		return middleUploadCount;
	}

	
	public void setMiddleUploadCount(Long middleUploadCount) {
		this.middleUploadCount = middleUploadCount;
	}

	
	public Long getFactUploadCount() {
		return factUploadCount;
	}

	
	public void setFactUploadCount(Long factUploadCount) {
		this.factUploadCount = factUploadCount;
	}

	
	public Long getFactAddCount() {
		return factAddCount;
	}

	
	public void setFactAddCount(Long factAddCount) {
		this.factAddCount = factAddCount;
	}

	
	public Long getFactUpdateCount() {
		return factUpdateCount;
	}

	
	public void setFactUpdateCount(Long factUpdateCount) {
		this.factUpdateCount = factUpdateCount;
	}

	
	public Long getFactFailCount() {
		return factFailCount;
	}

	
	public void setFactFailCount(Long factFailCount) {
		this.factFailCount = factFailCount;
	}

	
	public Date getRecordDate() {
		return recordDate;
	}

	
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	
	public String getRecordName() {
		return recordName;
	}

	
	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}

	
	public Date getUpdateDate() {
		return updateDate;
	}

	
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	
	public String getUpdateName() {
		return updateName;
	}

	
	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	
	public Integer getStatus() {
		return status;
	}

	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
