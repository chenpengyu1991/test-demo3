package com.founder.rhip.ehr.entity.clinic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "DA_PHARMACY")
public class Pharmacy implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|唯一自增长编码|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "BATCH_NO", columnDefinition = "VARCHAR2|库存单号（批次号）|50|", length = 50, nullable = true)
	private String batchNo;

	@Column(name = "ORG_TYPE", columnDefinition = "VARCHAR2|机构类型(A1综合医院；B1中心；B2站；D400医务室；L监督所；R2其他)|4|", length = 4, nullable = true)
	private String orgType;
	
	@Column(name = "GBCODE", columnDefinition = "VARCHAR2|行政区划代码(镇）|50|", length = 50, nullable = true)
	private String gbcode;
	
	@Column(name = "SUP_ORGAN_CODE", columnDefinition = "VARCHAR2|上级机构编码(中心)|50|", length = 50, nullable = true)
	private String supOrganCode;
	
	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|库存医疗机构编码|50|", length = 50, nullable = true)
	private String organCode;

	@Column(name = "ORGAN_NAME", columnDefinition = "VARCHAR2|库存医疗机构名称|100|", length = 100, nullable = true)
	private String organName;

	@Column(name = "PHARMACY_TYPE_CODE", columnDefinition = "VARCHAR2|药房类型编码（1门诊药房；2病区药房；3科室；4其他）|1|", length = 1, nullable = true)
	private String pharmacyTypeCode;

	@Column(name = "PHARMACY_TYPE_OTHER", columnDefinition = "VARCHAR2|药房类型其他|50|", length = 50, nullable = true)
	private String pharmacyTypeOther;

	@Column(name = "PHARMACY_CODE", columnDefinition = "VARCHAR2|药房编码|50|", length = 50, nullable = true)
	private String pharmacyCode;

	@Column(name = "PHARMACY_NAME", columnDefinition = "VARCHAR2|药房名称|100|", length = 100, nullable = true)
	private String pharmacyName;

	@Column(name = "DEPARTMENT_CODE", columnDefinition = "VARCHAR2|科室编码|50|", length = 50, nullable = true)
	private String departmentCode;

	@Column(name = "DEPARTMENT", columnDefinition = "VARCHAR2|科室名称|100|", length = 100, nullable = true)
	private String departmentName;

	@Column(name = "BASE_DRUG_CODE", columnDefinition = "VARCHAR2|药品基药编码|50|", length = 50, nullable = true)
	private String baseDrugCode;

	@Column(name = "INTERNAL_DRUG_CODE", columnDefinition = "VARCHAR2|药品内部编码|50|", length = 50, nullable = true)
	private String internalDrugCode;

	@Column(name = "DRUG_MEDICARE_CODE", columnDefinition = "VARCHAR2|药品医保编码|50|", length = 50, nullable = true)
	private String drugMedicareCode;

	@Column(name = "DRUG_AGRICULTURAL_CODE", columnDefinition = "VARCHAR2|药品农保编码|50|", length = 50, nullable = true)
	private String drugAgriculturalCode;

	@Column(name = "PIATS", columnDefinition = "VARCHAR2|电子监管码－－外部（厂家的）|50|", length = 50, nullable = true)
	private String piats;

	@Column(name = "BID_CODE", columnDefinition = "VARCHAR2|药品招标采购编码|24|", length = 24, nullable = true)
	private String bidCode;

	@Column(name = "DRUG_GENERIC_NAME", columnDefinition = "VARCHAR2|药品通用名称|50|", length = 50, nullable = true)
	private String drugGenericName;

	@Column(name = "DRUG_TRADE_NAME", columnDefinition = "VARCHAR2|药品商用名称|50|", length = 50, nullable = true)
	private String drugTradeName;

	@Column(name = "PINYING", columnDefinition = "VARCHAR2|药品名称全拼|50|", length = 50, nullable = true)
	private String pinying;

	@Column(name = "PINYING_SHORT", columnDefinition = "VARCHAR2|药品缩写拼音|50|", length = 50, nullable = true)
	private String pinyingShort;

	@Column(name = "SOURCE_TYPE", columnDefinition = "VARCHAR2|来源分类（进口、国产）|1|", length = 1, nullable = true)
	private String sourceType;

	@Column(name = "USE_TYPE", columnDefinition = "VARCHAR2|用途分类（处方药、非处方药）|1|", length = 1, nullable = true)
	private String useType;

	@Column(name = "DRUG_TYPE", columnDefinition = "VARCHAR2|药品分类（中药、西药、中成药）|1|", length = 1, nullable = true)
	private String drugType;

	@Column(name = "OTC_TYPE", columnDefinition = "VARCHAR2|非处方分类（甲类非处方药、乙类非处方药）|1|", length = 1, nullable = true)
	private String otcType;

	@Column(name = "SPECIAL_DRUG_TYPE", columnDefinition = "VARCHAR2|特殊药品分类（麻醉药品、精神药品、医疗用毒性药品、放射性药品、戒毒药品）|1|", length = 1, nullable = true)
	private String specialDrugType;

	@Column(name = "PHARMACY_PRICE", columnDefinition = "NUMBER|库存单价（进货价格）||",scale = 10, precision = 2, nullable = true)
	private BigDecimal pharmacyPrice;

	@Column(name = "PHARMACY_NUM", columnDefinition = "NUMBER|库存数量||",scale = 10, precision = 2, nullable = true)
	private BigDecimal pharmacyNum;

	@Column(name = "PHARMACY_AMOUNT", columnDefinition = "NUMBER|库存金额（库存单价×库存数量）||", scale = 10, precision = 2, nullable = true)
	private BigDecimal pharmacyAmount;

	@Column(name = "FAC_CODE", columnDefinition = "VARCHAR2|生产厂家编码|50|", length = 50, nullable = true)
	private String facCode;

	@Column(name = "FAC_NAME", columnDefinition = "VARCHAR2|生产厂家名称|70|", length = 70, nullable = true)
	private String facName;

	@Column(name = "APPROVAL_NUMBER", columnDefinition = "VARCHAR2|批准文号|50|", length = 50, nullable = true)
	private String approvalNumber;

	@Column(name = "PROD_PATCH", columnDefinition = "VARCHAR2|药品外包装生产批号|32|", length = 32, nullable = true)
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

	public String getBaseDrugCode() {
		return this.baseDrugCode;
	}

	public void setBaseDrugCode(String baseDrugCode) {
		this.baseDrugCode = baseDrugCode;
	}

	public String getInternalDrugCode() {
		return this.internalDrugCode;
	}

	public void setInternalDrugCode(String internalDrugCode) {
		this.internalDrugCode = internalDrugCode;
	}

	public String getDrugMedicareCode() {
		return this.drugMedicareCode;
	}

	public void setDrugMedicareCode(String drugMedicareCode) {
		this.drugMedicareCode = drugMedicareCode;
	}

	public String getDrugAgriculturalCode() {
		return this.drugAgriculturalCode;
	}

	public void setDrugAgriculturalCode(String drugAgriculturalCode) {
		this.drugAgriculturalCode = drugAgriculturalCode;
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

	public String getDrugGenericName() {
		return this.drugGenericName;
	}

	public void setDrugGenericName(String drugGenericName) {
		this.drugGenericName = drugGenericName;
	}

	public String getDrugTradeName() {
		return this.drugTradeName;
	}

	public void setDrugTradeName(String drugTradeName) {
		this.drugTradeName = drugTradeName;
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

	public String getUseType() {
		return this.useType;
	}

	public void setUseType(String useType) {
		this.useType = useType;
	}

	public String getDrugType() {
		return this.drugType;
	}

	public void setDrugType(String drugType) {
		this.drugType = drugType;
	}

	public String getOtcType() {
		return this.otcType;
	}

	public void setOtcType(String otcType) {
		this.otcType = otcType;
	}

	public String getSpecialDrugType() {
		return this.specialDrugType;
	}

	public void setSpecialDrugType(String specialDrugType) {
		this.specialDrugType = specialDrugType;
	}

	public BigDecimal getPharmacyPrice() {
		return this.pharmacyPrice;
	}

	public void setPharmacyPrice(BigDecimal pharmacyPrice) {
		this.pharmacyPrice = pharmacyPrice;
	}

	public BigDecimal getPharmacyNum() {
		return this.pharmacyNum;
	}

	public void setPharmacyNum(BigDecimal pharmacyNum) {
		this.pharmacyNum = pharmacyNum;
	}

	public BigDecimal getPharmacyAmount() {
		return this.pharmacyAmount;
	}

	public void setPharmacyAmount(BigDecimal pharmacyAmount) {
		this.pharmacyAmount = pharmacyAmount;
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