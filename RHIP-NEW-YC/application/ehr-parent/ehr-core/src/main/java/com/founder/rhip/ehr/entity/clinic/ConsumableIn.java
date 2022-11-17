package com.founder.rhip.ehr.entity.clinic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "DA_CONSUMABLE_IN")
public class ConsumableIn implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|唯一自增长编码|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "BATCH_NO", columnDefinition = "VARCHAR2|入库单号（入库批次号）|50|", length = 50, nullable = true)
	private String batchNo;

	@Column(name = "STORAGE_DT", columnDefinition = "DATE|入库日期||", nullable = true)
	private Date storageDt;

	@Column(name = "STORAGE_TYPE_CODE", columnDefinition = "VARCHAR2|入库方式编码（1采购入库；2盘盈入库；3其他）|1|", length = 1, nullable = true)
	private String storageTypeCode;

	@Column(name = "STORAGE_TYPE_OTHER", columnDefinition = "VARCHAR2|入库方式其他|20|", length = 20, nullable = true)
	private String storageTypeOther;

	@Column(name = "SUPPLIER_UNIT_CODE", columnDefinition = "VARCHAR2|供货单位编码|50|", length = 50, nullable = true)
	private String supplierUnitCode;

	@Column(name = "SUPPLIER_UNIT_NAME", columnDefinition = "VARCHAR2|供货单位名称|100|", length = 100, nullable = true)
	private String supplierUnitName;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|入库医疗机构编码|50|", length = 50, nullable = true)
	private String organCode;

	@Column(name = "ORGAN_NAME", columnDefinition = "VARCHAR2|入库医疗机构名称|100|", length = 100, nullable = true)
	private String organName;

	@Column(name = "PURCHASE_TYPE_CODE", columnDefinition = "VARCHAR2|采购方式编码|2|", length = 2, nullable = true)
	private String purchaseTypeCode;

	@Column(name = "PURCHASE_TYPE_NAME", columnDefinition = "VARCHAR2|采购方式名称|20|", length = 20, nullable = true)
	private String purchaseTypeName;

	@Column(name = "INVOICE_NUM", columnDefinition = "VARCHAR2|发票号|50|", length = 50, nullable = true)
	private String invoiceNum;

	@Column(name = "PURCHASE_DT", columnDefinition = "DATE|采购日期||", nullable = true)
	private Date purchaseDt;

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

	public Date getStorageDt() {
		return this.storageDt;
	}

	public void setStorageDt(Date storageDt) {
		this.storageDt = storageDt;
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

	public Date getPurchaseDt() {
		return this.purchaseDt;
	}

	public void setPurchaseDt(Date purchaseDt) {
		this.purchaseDt = purchaseDt;
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

}