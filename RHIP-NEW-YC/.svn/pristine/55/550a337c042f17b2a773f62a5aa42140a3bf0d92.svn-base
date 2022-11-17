package com.founder.rhip.ehr.entity.clinic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "DA_PHARMACY_IN")
public class PharmacyIn implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|唯一自增长编码|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "BATCH_NO", columnDefinition = "VARCHAR2|入库单号（入库批次号）|50|", length = 50, nullable = true)
	private String batchNo;

	@Column(name = "PHARMACY_DT", columnDefinition = "DATE|入库日期||", nullable = true)
	private Date pharmacyDt;

	@Column(name = "STORAGE_TYPE_CODE", columnDefinition = "VARCHAR2|入库方式编码（1采购入库；2盘盈入库；3正常入库；4其他）|1|", length = 1, nullable = true)
	private String storageTypeCode;

	@Column(name = "STORAGE_TYPE_OTHER", columnDefinition = "VARCHAR2|入库方式其他|20|", length = 20, nullable = true)
	private String storageTypeOther;

	@Column(name = "ORG_TYPE", columnDefinition = "VARCHAR2|机构类型(A1综合医院；B1中心；B2站；D400医务室；L监督所；R2其他)|4|", length = 4, nullable = true)
	private String orgType;
	
	@Column(name = "GBCODE", columnDefinition = "VARCHAR2|行政区划代码(镇）|50|", length = 50, nullable = true)
	private String gbcode;
	
	@Column(name = "SUP_ORGAN_CODE", columnDefinition = "VARCHAR2|上级机构编码(中心)|50|", length = 50, nullable = true)
	private String supOrganCode;
	
	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|入库医疗机构编码|50|", length = 50, nullable = true)
	private String organCode;

	@Column(name = "ORGAN_NAME", columnDefinition = "VARCHAR2|入库医疗机构名称|100|", length = 100, nullable = true)
	private String organName;

	@Column(name = "PHARMACY_TYPE_CODE", columnDefinition = "VARCHAR2|入库药房类型（1门诊药房；2病区药房；3科室；4其他|1|", length = 1, nullable = true)
	private String pharmacyTypeCode;

	@Column(name = "PHARMACY_TYPE_OTHER", columnDefinition = "VARCHAR2|入库药房其他|20|", length = 20, nullable = true)
	private String pharmacyTypeOther;

	@Column(name = "PHARMACY_CODE", columnDefinition = "VARCHAR2|入库药房编码|50|", length = 50, nullable = true)
	private String pharmacyCode;

	@Column(name = "PHARMACY_NAME", columnDefinition = "VARCHAR2|入库药房名称|100|", length = 100, nullable = true)
	private String pharmacyName;

	@Column(name = "DEPARTMENT_CODE", columnDefinition = "VARCHAR2|入库科室编码|50|", length = 50, nullable = true)
	private String departmentCode;

	@Column(name = "DEPARTMENT_NAME", columnDefinition = "VARCHAR2|入库科室名称|100|", length = 100, nullable = true)
	private String departmentName;

	@Column(name = "SUPPLIER_UNIT_CODE", columnDefinition = "VARCHAR2|供货单位编码（入库方式为采购入库的时候有值 ）|50|", length = 50, nullable = true)
	private String supplierUnitCode;

	@Column(name = "SUPPLIER_UNIT_NAME", columnDefinition = "VARCHAR2|供货单位名称（入库方式为采购入库的时候有值 ）|100|", length = 100, nullable = true)
	private String supplierUnitName;

	@Column(name = "PURCHASE_TYPE_CODE", columnDefinition = "VARCHAR2|采购方式编码（入库方式为采购入库的时候有值 ）|2|", length = 2, nullable = true)
	private String purchaseTypeCode;

	@Column(name = "PURCHASE_TYPE_NAME", columnDefinition = "VARCHAR2|采购方式（入库方式为采购入库的时候有值 ）|20|", length = 20, nullable = true)
	private String purchaseTypeName;

	@Column(name = "INVOICE_NUM", columnDefinition = "VARCHAR2|发票号（入库方式为采购入库的时候有值 ）|50|", length = 50, nullable = true)
	private String invoiceNum;

	@Column(name = "COMMENTS", columnDefinition = "VARCHAR2|备注|200|", length = 200, nullable = true)
	private String comments;

	@Column(name = "OPERATOR_CODE", columnDefinition = "VARCHAR2|入库人员编码|50|", length = 50, nullable = true)
	private String operatorCode;

	@Column(name = "OPERATOR_NAME", columnDefinition = "VARCHAR2|入库人员名称|50|", length = 50, nullable = true)
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

	public Date getPharmacyDt() {
		return this.pharmacyDt;
	}

	public void setPharmacyDt(Date pharmacyDt) {
		this.pharmacyDt = pharmacyDt;
	}

	public String getStorageTypeCode() {
		return this.storageTypeCode;
	}

	public void setStorageTypeCode(String storageTypeCode) {
		this.storageTypeCode = storageTypeCode;
	}

	public String getStorageTypeOther() {
		return this.storageTypeOther;
	}

	public void setStorageTypeOther(String storageTypeOther) {
		this.storageTypeOther = storageTypeOther;
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

	public String getPurchaseTypeCode() {
		return this.purchaseTypeCode;
	}

	public void setPurchaseTypeCode(String purchaseTypeCode) {
		this.purchaseTypeCode = purchaseTypeCode;
	}

	public String getPurchaseTypeName() {
		return this.purchaseTypeName;
	}

	public void setPurchaseTypeName(String purchaseTypeName) {
		this.purchaseTypeName = purchaseTypeName;
	}

	public String getInvoiceNum() {
		return this.invoiceNum;
	}

	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
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