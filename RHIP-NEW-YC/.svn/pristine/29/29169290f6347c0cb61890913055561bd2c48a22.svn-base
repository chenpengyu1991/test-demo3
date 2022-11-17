package com.founder.rhip.ehr.entity.clinic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "DA_PHARMACY_RETURN")
public class PharmacyReturn implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|唯一自增长编码|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "BATCH_NO", columnDefinition = "VARCHAR2|退库单号（入库批次号）|50|", length = 50, nullable = true)
	private String batchNo;

	@Column(name = "RETURN_DT", columnDefinition = "DATE|退库日期||", nullable = true)
	private Date returnDt;

	@Column(name = "RETURN_REASON", columnDefinition = "VARCHAR2|退货原因|400|", length = 400, nullable = true)
	private String returnReason;

	@Column(name = "ORG_TYPE", columnDefinition = "VARCHAR2|机构类型(A1综合医院；B1中心；B2站；D400医务室；L监督所；R2其他)|4|", length = 4, nullable = true)
	private String orgType;
	
	@Column(name = "GBCODE", columnDefinition = "VARCHAR2|行政区划代码(镇）|50|", length = 50, nullable = true)
	private String gbcode;
	
	@Column(name = "SUP_ORGAN_CODE", columnDefinition = "VARCHAR2|上级机构编码(中心)|50|", length = 50, nullable = true)
	private String supOrganCode;
	
	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|退库医疗机构编码|50|", length = 50, nullable = true)
	private String organCode;

	@Column(name = "ORGAN_NAME", columnDefinition = "VARCHAR2|退库医疗机构名称|100|", length = 100, nullable = true)
	private String organName;

	@Column(name = "PHARMACY_TYPE_COE", columnDefinition = "VARCHAR2|退货药房类别编码（1门诊药房；2病区药房；3科室；4退货；5调拨；6其他）|1|", length = 1, nullable = true)
	private String pharmacyTypeCode;

	@Column(name = "PHARMACY_TYPE_OTHER", columnDefinition = "VARCHAR2|退货药房类别其他|50|", length = 50, nullable = true)
	private String pharmacyTypeOther;

	@Column(name = "TRANSFER_SLIP", columnDefinition = "VARCHAR2|调拨单号|50|", length = 50, nullable = true)
	private String transferSlip;

	@Column(name = "PHARMACY_CODE", columnDefinition = "VARCHAR2|退货药房编码|50|", length = 50, nullable = true)
	private String pharmacyCode;

	@Column(name = "PHARMACY_NAME", columnDefinition = "VARCHAR2|退货药房名称|100|", length = 100, nullable = true)
	private String pharmacyName;

	@Column(name = "DEPARTMENT_CODE", columnDefinition = "VARCHAR2|退货科室编码|50|", length = 50, nullable = true)
	private String departmentCode;

	@Column(name = "DEPARTMENT", columnDefinition = "VARCHAR2|退货科室名称|100|", length = 100, nullable = true)
	private String departmentName;

	@Column(name = "SUPPLIER_UNIT_CODE", columnDefinition = "VARCHAR2|供货单位编码|50|", length = 50, nullable = true)
	private String supplierUnitCode;

	@Column(name = "SUPPLIER_UNIT_NAME", columnDefinition = "VARCHAR2|供货单位名称|100|", length = 100, nullable = true)
	private String supplierUnitName;

	@Column(name = "COMMENTS", columnDefinition = "VARCHAR2|备注|200|", length = 200, nullable = true)
	private String comments;

	@Column(name = "OPERATOR_CODE", columnDefinition = "VARCHAR2|退货人员编码|50|", length = 50, nullable = true)
	private String operatorCode;

	@Column(name = "OPERATOR_NAME", columnDefinition = "VARCHAR2|退货人员名称|50|", length = 50, nullable = true)
	private String operatorName;

	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|创建机构编码|50|", length = 50, nullable = true)
	private String createOrganCode;

	@Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|创建机构名称|100|", length = 100, nullable = true)
	private String createOrganName;

	@Column(name = "CREATE_DATE", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createDate;

	@Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|更新机构编码|50|", length = 50, nullable = true)
	private String updateOrganCode;

	@Column(name = "UPDATE_ORGAN_NAME", columnDefinition = "VARCHAR2|更新机构名称|100|", length = 100, nullable = true)
	private String updateOrganName;

	@Column(name = "UPDATE_DATE", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateDate;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBatchNo() {
		return this.batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Date getReturnDt() {
		return this.returnDt;
	}

	public void setReturnDt(Date returnDt) {
		this.returnDt = returnDt;
	}

	public String getReturnReason() {
		return this.returnReason;
	}

	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
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

	public String getPharmacyTypeCode() {
		return this.pharmacyTypeCode;
	}

	public void setPharmacyTypeCode(String pharmacyTypeCode) {
		this.pharmacyTypeCode = pharmacyTypeCode;
	}

	public String getPharmacyTypeOther() {
		return this.pharmacyTypeOther;
	}

	public void setPharmacyTypeOther(String pharmacyTypeOther) {
		this.pharmacyTypeOther = pharmacyTypeOther;
	}

	public String getTransferSlip() {
		return this.transferSlip;
	}

	public void setTransferSlip(String transferSlip) {
		this.transferSlip = transferSlip;
	}

	public String getPharmacyCode() {
		return this.pharmacyCode;
	}

	public void setPharmacyCode(String pharmacyCode) {
		this.pharmacyCode = pharmacyCode;
	}

	public String getPharmacyName() {
		return this.pharmacyName;
	}

	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}

	public String getDepartmentCode() {
		return this.departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getSupplierUnitCode() {
		return this.supplierUnitCode;
	}

	public void setSupplierUnitCode(String supplierUnitCode) {
		this.supplierUnitCode = supplierUnitCode;
	}

	public String getSupplierUnitName() {
		return this.supplierUnitName;
	}

	public void setSupplierUnitName(String supplierUnitName) {
		this.supplierUnitName = supplierUnitName;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getOperatorCode() {
		return this.operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getOperatorName() {
		return this.operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getCreateOrganCode() {
		return this.createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	public String getCreateOrganName() {
		return this.createOrganName;
	}

	public void setCreateOrganName(String createOrganName) {
		this.createOrganName = createOrganName;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateOrganCode() {
		return this.updateOrganCode;
	}

	public void setUpdateOrganCode(String updateOrganCode) {
		this.updateOrganCode = updateOrganCode;
	}

	public String getUpdateOrganName() {
		return this.updateOrganName;
	}

	public void setUpdateOrganName(String updateOrganName) {
		this.updateOrganName = updateOrganName;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getGbcode() {
		return gbcode;
	}

	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
	}

	public String getSupOrganCode() {
		return supOrganCode;
	}

	public void setSupOrganCode(String supOrganCode) {
		this.supOrganCode = supOrganCode;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

}