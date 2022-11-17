package com.founder.rhip.ehr.entity.clinic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name = "DA_CONSUMABLE_BREAKAGE")
public class ConsumableBreakage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|唯一自增长编码|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "BATCH_NO", columnDefinition = "VARCHAR2|报损单号（批次号）|50|", length = 50, nullable = true)
	private String batchNo;

	@Column(name = "BREAKAGE_DT", columnDefinition = "DATE|报损日期||", nullable = true)
	private Date breakageDt;

	@Column(name = "BREAKAGE_REASON", columnDefinition = "VARCHAR2|报损原因|400|", length = 400, nullable = true)
	private String breakageReason;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|库存医疗机构编码|50|", length = 50, nullable = true)
	private String organCode;

	@Column(name = "ORGAN_NAME", columnDefinition = "VARCHAR2|库存医疗机构名称|100|", length = 100, nullable = true)
	private String organName;

	@Column(name = "STORAGE_LOCATION", columnDefinition = "VARCHAR2|库位|40|", length = 40, nullable = true)
	private String storageLocation;

	@Column(name = "INTERNAL_CODE", columnDefinition = "VARCHAR2|耗材内部编码|50|", length = 50, nullable = true)
	private String internalCode;

	@Column(name = "MEDICARE_CODE", columnDefinition = "VARCHAR2|耗材医保编码|50|", length = 50, nullable = true)
	private String medicareCode;

	@Column(name = "AGRICULTURAL_CODE", columnDefinition = "VARCHAR2|耗材农保编码|50|", length = 50, nullable = true)
	private String agriculturalCode;

	@Column(name = "PIATS", columnDefinition = "VARCHAR2|电子监管码－－外部（厂家的）|50|", length = 50, nullable = true)
	private String piats;

	@Column(name = "BID_CODE", columnDefinition = "VARCHAR2|耗材招标采购编码|24|", length = 24, nullable = true)
	private String bidCode;

	@Column(name = "REGISTER_NO", columnDefinition = "VARCHAR2|注册证号|50|", length = 50, nullable = true)
	private String registerNo;

	@Column(name = "GENERIC_NAME", columnDefinition = "VARCHAR2|耗材通用名称|50|", length = 50, nullable = true)
	private String genericName;

	@Column(name = "TRADE_NAME", columnDefinition = "VARCHAR2|耗材商用名称|50|", length = 50, nullable = true)
	private String tradeName;

	@Column(name = "PINYING", columnDefinition = "VARCHAR2|耗材名称全拼|50|", length = 50, nullable = true)
	private String pinying;

	@Column(name = "PINYING_SHORT", columnDefinition = "VARCHAR2|耗材缩写拼音|50|", length = 50, nullable = true)
	private String pinyingShort;

	@Column(name = "SOURCE_TYPE", columnDefinition = "VARCHAR2|来源分类（进口、国产）|1|", length = 1, nullable = true)
	private String sourceType;

	@Column(name = "ONEOFF", columnDefinition = "VARCHAR2|是否一次性耗材（是、否）|1|", length = 1, nullable = true)
	private String oneoff;

	@Column(name = "HIGH_VALUE", columnDefinition = "VARCHAR2|是否高值耗材（是、否）|1|", length = 1, nullable = true)
	private String highvalue;

	@Column(name = "IMPLANT", columnDefinition = "VARCHAR2|是否植入性耗材（是、否）|1|", length = 1, nullable = true)
	private String implant;

	@Column(name = "MANAGE_TYPE_CODE_GB", columnDefinition = "VARCHAR2|管理分类编码（国家）|1|", length = 1, nullable = true)
	private String manageTypeCodeGb;

	@Column(name = "MANAGE_TYPE_CODE_IN", columnDefinition = "VARCHAR2|管理分类编码（内部）|1|", length = 1, nullable = true)
	private String manageTypeCodeIn;

	@Column(name = "STORAGE_PRICE", columnDefinition = "NUMBER|库存单价（进货价格）||", scale = 10, precision = 2, nullable = true)
	private BigDecimal storagePrice;

	@Column(name = "BREAKAGE_NUM", columnDefinition = "NUMBER|报损数量||", scale = 10, precision = 2, nullable = true)
	private BigDecimal breakageNum;

	@Column(name = "STORAGE_AMOUNT", columnDefinition = "NUMBER|库存金额（库存单价×报损数量）||", scale = 10, precision = 2, nullable = true)
	private BigDecimal storageAmount;

	@Column(name = "FAC_CODE", columnDefinition = "VARCHAR2|生产厂家编码|50|", length = 50, nullable = true)
	private String facCode;

	@Column(name = "FAC_NAME", columnDefinition = "VARCHAR2|生产厂家名称|70|", length = 70, nullable = true)
	private String facName;

	@Column(name = "APPROVAL_NUMBER", columnDefinition = "VARCHAR2|批准文号|50|", length = 50, nullable = true)
	private String approvalNumber;

	@Column(name = "PROD_PATCH", columnDefinition = "VARCHAR2|外包装生产批号|32|", length = 32, nullable = true)
	private String prodPatch;

	@Column(name = "PRODUCED_DT", columnDefinition = "DATE|生产日期||", nullable = true)
	private Date producedDt;

	@Column(name = "EXPIRY_DT", columnDefinition = "DATE|失效日期（有效期）||", nullable = true)
	private Date expiryDt;

	@Column(name = "STORAGE", columnDefinition = "VARCHAR2|贮藏|100|", length = 100, nullable = true)
	private String storage;

	@Column(name = "SPECIFICATIONS", columnDefinition = "VARCHAR2|规格|50|", length = 50, nullable = true)
	private String specifications;

	@Column(name = "PACKAGING", columnDefinition = "VARCHAR2|包装|50|", length = 50, nullable = true)
	private String packaging;

	@Column(name = "WHOLESALE_PRICE", columnDefinition = "NUMBER|批发价格||", scale = 10, precision = 2, nullable = true)
	private BigDecimal wholesalePrice;

	@Column(name = "RETAIL_PRICE", columnDefinition = "NUMBER|零售价格||", scale = 10, precision = 2, nullable = true)
	private BigDecimal retailPrice;

	@Column(name = "OPERATOR_CODE", columnDefinition = "VARCHAR2|报损人员编码|50|", length = 50, nullable = true)
	private String operatorCode;

	@Column(name = "OPERATOR_NAME", columnDefinition = "VARCHAR2|报损人员名称|50|", length = 50, nullable = true)
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

	public Date getBreakageDt() {
		return this.breakageDt;
	}

	public void setBreakageDt(Date breakageDt) {
		this.breakageDt = breakageDt;
	}

	public String getBreakageReason() {
		return this.breakageReason;
	}

	public void setBreakageReason(String breakageReason) {
		this.breakageReason = breakageReason;
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

	public String getStorageLocation() {
		return this.storageLocation;
	}

	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
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

	public String getRegisterNo() {
		return this.registerNo;
	}

	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
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

	public String getSourceType() {
		return this.sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getOneoff() {
		return this.oneoff;
	}

	public void setOneoff(String oneoff) {
		this.oneoff = oneoff;
	}

	public String getHighvalue() {
		return this.highvalue;
	}

	public void setHighvalue(String highvalue) {
		this.highvalue = highvalue;
	}

	public String getImplant() {
		return this.implant;
	}

	public void setImplant(String implant) {
		this.implant = implant;
	}

	public BigDecimal getStoragePrice() {
		return this.storagePrice;
	}

	public void setStoragePrice(BigDecimal storagePrice) {
		this.storagePrice = storagePrice;
	}

	public BigDecimal getBreakageNum() {
		return this.breakageNum;
	}

	public void setBreakageNum(BigDecimal breakageNum) {
		this.breakageNum = breakageNum;
	}

	public BigDecimal getStorageAmount() {
		return this.storageAmount;
	}

	public void setStorageAmount(BigDecimal storageAmount) {
		this.storageAmount = storageAmount;
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

	public Date getExpiryDt() {
		return this.expiryDt;
	}

	public void setExpiryDt(Date expiryDt) {
		this.expiryDt = expiryDt;
	}

	public String getStorage() {
		return this.storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getSpecifications() {
		return this.specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public String getPackaging() {
		return this.packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	public BigDecimal getWholesalePrice() {
		return this.wholesalePrice;
	}

	public void setWholesalePrice(BigDecimal wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}

	public BigDecimal getRetailPrice() {
		return this.retailPrice;
	}

	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
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

	public String getManageTypeCodeGb() {
		return manageTypeCodeGb;
	}

	public void setManageTypeCodeGb(String manageTypeCodeGb) {
		this.manageTypeCodeGb = manageTypeCodeGb;
	}

	public String getManageTypeCodeIn() {
		return manageTypeCodeIn;
	}

	public void setManageTypeCodeIn(String manageTypeCodeIn) {
		this.manageTypeCodeIn = manageTypeCodeIn;
	}

}