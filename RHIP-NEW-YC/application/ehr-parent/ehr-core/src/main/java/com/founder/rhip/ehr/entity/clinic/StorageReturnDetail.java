package com.founder.rhip.ehr.entity.clinic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "DA_STORAGE_RETURN_DETAIL")
public class StorageReturnDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|唯一自增长编码|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "BATCH_NO", columnDefinition = "VARCHAR2|出库单号（批次号）|50|", length = 50, nullable = true)
	private String batchNo;

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

	@Column(name = "RETURN_PRICE", columnDefinition = "NUMBER|退库单价（出库价格）||",scale = 10, precision = 2, nullable = true)
	private BigDecimal returnPrice;

	@Column(name = "RETURN_NUM", columnDefinition = "NUMBER|退库数量||",scale = 10, precision = 2, nullable = true)
	private BigDecimal returnNum;

	@Column(name = "RETURN_AMOUNT", columnDefinition = "NUMBER|退库金额（退库单价×退库数量）||",scale = 10, precision = 2, nullable = true)
	private BigDecimal returnAmount;

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

	@Column(name = "WHOLESALE_PRICE", columnDefinition = "NUMBER|批发价格||",scale = 10, precision = 2, nullable = true)
	private BigDecimal wholesalePrice;

	@Column(name = "RETAIL_PRICE", columnDefinition = "NUMBER|零售价格||",scale = 10, precision = 2, nullable = true)
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

	public BigDecimal getReturnPrice() {
		return this.returnPrice;
	}

	public void setReturnPrice(BigDecimal returnPrice) {
		this.returnPrice = returnPrice;
	}

	public BigDecimal getReturnNum() {
		return this.returnNum;
	}

	public void setReturnNum(BigDecimal returnNum) {
		this.returnNum = returnNum;
	}

	public BigDecimal getReturnAmount() {
		return this.returnAmount;
	}

	public void setReturnAmount(BigDecimal returnAmount) {
		this.returnAmount = returnAmount;
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

}