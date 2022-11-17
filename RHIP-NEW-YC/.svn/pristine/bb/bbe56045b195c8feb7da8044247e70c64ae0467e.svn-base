package com.founder.rhip.ehr.entity.clinic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name = "DA_EQUIPMENT_STORE")
public class EquipmentStore implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|唯一自增长编码|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "BATCH_NO", columnDefinition = "VARCHAR2|库存单号（批次号）|50|", length = 50, nullable = true)
	private String batchNo;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|库存医疗机构编码|50|", length = 50, nullable = true)
	private String organCode;

	@Column(name = "ORGAN_NAME", columnDefinition = "VARCHAR2|库存医疗机构名称|100|", length = 100, nullable = true)
	private String organName;

	@Column(name = "INTERNAL_CODE", columnDefinition = "VARCHAR2|设备内部编码|50|", length = 50, nullable = true)
	private String internalCode;

	@Column(name = "MEDICARE_CODE", columnDefinition = "VARCHAR2|设备医保编码|50|", length = 50, nullable = true)
	private String medicareCode;

	@Column(name = "AGRICULTURAL_CODE", columnDefinition = "VARCHAR2|设备农保编码|50|", length = 50, nullable = true)
	private String agriculturalCode;

	@Column(name = "PIATS", columnDefinition = "VARCHAR2|电子监管码－－外部（厂家的）|50|", length = 50, nullable = true)
	private String piats;

	@Column(name = "BID_CODE", columnDefinition = "VARCHAR2|设备招标采购编码|24|", length = 24, nullable = true)
	private String bidCode;

	@Column(name = "SOURCE_TYPE", columnDefinition = "VARCHAR2|来源分类（进口、国产）|1|", length = 1, nullable = true)
	private String sourceType;

	@Column(name = "REGISTER_NO", columnDefinition = "VARCHAR2|注册证号|50|", length = 50, nullable = true)
	private String registerNo;

	@Column(name = "PROPERTY_NO", columnDefinition = "VARCHAR2|财产编号|50|", length = 50, nullable = true)
	private String propertyNo;

	@Column(name = "GENERIC_NAME", columnDefinition = "VARCHAR2|设备通用名称|50|", length = 50, nullable = true)
	private String genericName;

	@Column(name = "TRADE_NAME", columnDefinition = "VARCHAR2|设备商用名称|50|", length = 50, nullable = true)
	private String tradeName;

	@Column(name = "PINYING", columnDefinition = "VARCHAR2|设备名称全拼|50|", length = 50, nullable = true)
	private String pinying;

	@Column(name = "PINYING_SHORT", columnDefinition = "VARCHAR2|设备缩写拼音|50|", length = 50, nullable = true)
	private String pinyingShort;

	@Column(name = "SPECIFICATIONS", columnDefinition = "VARCHAR2|规格|50|", length = 50, nullable = true)
	private String specifications;

	@Column(name = "UNIT", columnDefinition = "VARCHAR2|单位|50|", length = 50, nullable = true)
	private String unit;
	
	@Column(name = "MODEL_NO", columnDefinition = "VARCHAR2|型号|50|", length = 50, nullable = true)
	private String modelNo;

	@Column(name = "DURABLE_YEARS", columnDefinition = "VARCHAR2|使用年限|50|", length = 50, nullable = true)
	private String durableYears;

	@Column(name = "SUPPLIER_UNIT_CODE", columnDefinition = "VARCHAR2|供货单位编码|50|", length = 50, nullable = true)
	private String supplierUnitCode;

	@Column(name = "SUPPLIER_UNIT_NAME", columnDefinition = "VARCHAR2|供货单位名称|100|", length = 100, nullable = true)
	private String supplierUnitName;

	@Column(name = "FAC_CODE", columnDefinition = "VARCHAR2|生产厂家编码|50|", length = 50, nullable = true)
	private String facCode;

	@Column(name = "FAC_NAME", columnDefinition = "VARCHAR2|生产厂家名称|70|", length = 70, nullable = true)
	private String facName;

	@Column(name = "BRAND", columnDefinition = "VARCHAR2|品牌|50|", length = 50, nullable = true)
	private String brand;

	@Column(name = "APPROVAL_NUMBER", columnDefinition = "VARCHAR2|批准文号|50|", length = 50, nullable = true)
	private String approvalNumber;

	@Column(name = "PROD_PATCH", columnDefinition = "VARCHAR2|外包装生产批号|32|", length = 32, nullable = true)
	private String prodPatch;

	@Column(name = "PRODUCED_DT", columnDefinition = "DATE|生产日期||", nullable = true)
	private Date producedDt;

	@Column(name = "STORAGE_PRICE", columnDefinition = "NUMBER|库存单价（进货价格）||",scale = 10, precision = 2, nullable = true)
	private BigDecimal storagePrice;

	@Column(name = "STORAGE_NUM", columnDefinition = "NUMBER|库存数量||",scale = 10, precision = 2, nullable = true)
	private BigDecimal storageNum;

	@Column(name = "STORAGE_AMOUNT", columnDefinition = "NUMBER|库存金额（库存单价×库存数量）||",scale = 10, precision = 2, nullable = true)
	private BigDecimal storageAmount;

	@Column(name = "INVOICE_NUM", columnDefinition = "VARCHAR2|发票号|50|", length = 50, nullable = true)
	private String invoiceNum;

	@Column(name = "PURCHASE_DT", columnDefinition = "DATE|采购日期||", nullable = true)
	private Date purchaseDt;

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

	public String getInternalCode() {
		return this.internalCode;
	}

	public void setInternalCode(String internalCode) {
		this.internalCode = internalCode;
	}

	public String getMedicareCode() {
		return this.medicareCode;
	}

	public void setMedicareCode(String medicareCode) {
		this.medicareCode = medicareCode;
	}

	public String getAgriculturalCode() {
		return this.agriculturalCode;
	}

	public void setAgriculturalCode(String agriculturalCode) {
		this.agriculturalCode = agriculturalCode;
	}

	public String getPiats() {
		return this.piats;
	}

	public void setPiats(String piats) {
		this.piats = piats;
	}

	public String getBidCode() {
		return this.bidCode;
	}

	public void setBidCode(String bidCode) {
		this.bidCode = bidCode;
	}

	public String getSourceType() {
		return this.sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getRegisterNo() {
		return this.registerNo;
	}

	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}

	public String getPropertyNo() {
		return this.propertyNo;
	}

	public void setPropertyNo(String propertyNo) {
		this.propertyNo = propertyNo;
	}

	public String getGenericName() {
		return this.genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	public String getTradeName() {
		return this.tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public String getPinying() {
		return this.pinying;
	}

	public void setPinying(String pinying) {
		this.pinying = pinying;
	}

	public String getPinyingShort() {
		return this.pinyingShort;
	}

	public void setPinyingShort(String pinyingShort) {
		this.pinyingShort = pinyingShort;
	}

	public String getSpecifications() {
		return this.specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public String getModelNo() {
		return this.modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getDurableYears() {
		return this.durableYears;
	}

	public void setDurableYears(String durableYears) {
		this.durableYears = durableYears;
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

	public String getFacCode() {
		return this.facCode;
	}

	public void setFacCode(String facCode) {
		this.facCode = facCode;
	}

	public String getFacName() {
		return this.facName;
	}

	public void setFacName(String facName) {
		this.facName = facName;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getApprovalNumber() {
		return this.approvalNumber;
	}

	public void setApprovalNumber(String approvalNumber) {
		this.approvalNumber = approvalNumber;
	}

	public String getProdPatch() {
		return this.prodPatch;
	}

	public void setProdPatch(String prodPatch) {
		this.prodPatch = prodPatch;
	}

	public Date getProducedDt() {
		return this.producedDt;
	}

	public void setProducedDt(Date producedDt) {
		this.producedDt = producedDt;
	}

	public BigDecimal getStoragePrice() {
		return this.storagePrice;
	}

	public void setStoragePrice(BigDecimal storagePrice) {
		this.storagePrice = storagePrice;
	}

	public BigDecimal getStorageNum() {
		return this.storageNum;
	}

	public void setStorageNum(BigDecimal storageNum) {
		this.storageNum = storageNum;
	}

	public BigDecimal getStorageAmount() {
		return this.storageAmount;
	}

	public void setStorageAmount(BigDecimal storageAmount) {
		this.storageAmount = storageAmount;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}