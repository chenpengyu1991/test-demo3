package com.founder.rhip.mdm.entity;

import com.founder.rhip.mdm.common.StatusValue;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "MDM_MEDICINE")
public class Medicine implements Serializable {
	
	private static final long serialVersionUID = 9043604896676672917L;

	public static final String MEDICINE_CODE = "medicineCode";
	
	public static final String OPERATOR = "operator";
	
	public static final String OPERATE_TIME = "operateTime";
	
	public static final String OPERATE_TYPE = "operateType";
	
	public static final String STATUS = "status";
	
	public static final String VERSION = "version";

	@Id
	@Column(name = "MEDICINE_CODE", columnDefinition = "VARCHAR2|标准药品编码||", length = 50, nullable = true)
	private String medicineCode;

	@Column(name = "LEVEL_CODE", columnDefinition = "VARCHAR2|级别码||", length = 20, nullable = true)
	private String levelCode;

	@Column(name = "CATEGORY_CODE", columnDefinition = "VARCHAR2|药物类型码||", length = 20, nullable = true)
	private String categoryCode;

	@Column(name = "COMMON_NAME", columnDefinition = "VARCHAR2|通用名||", length = 300, nullable = true)
	private String commonName;

	@Column(name = "ENGLISH_NAME", columnDefinition = "VARCHAR2|英文名||", length = 300, nullable = true)
	private String englishName;

	@Column(name = "PRODUCT_NAME", columnDefinition = "VARCHAR2|商品名||", length = 300, nullable = true)
	private String productName;

	@Column(name = "SPECIFICATION", columnDefinition = "VARCHAR2|规格||", length = 300, nullable = true)
	private String specification;

	@Column(name = "DOSAGE", columnDefinition = "VARCHAR2|剂型||", length = 150, nullable = true)
	private String dosage;

	@Column(name = "UNIT", columnDefinition = "VARCHAR2|单位||", length = 100, nullable = true)
	private String unit;

	@Column(name = "MATERIAL", columnDefinition = "VARCHAR2|包装材质||", length = 250, nullable = true)
	private String material;

	@Column(name = "PACKAGE_SIZE", columnDefinition = "NUMBER|包装比||", nullable = true)
	private Integer packageSize;

	@Column(name = "MANUFACTORY", columnDefinition = "VARCHAR2|生产厂家||", length = 300, nullable = true)
	private String manufactory;
	
	@Column(name = "VERSION", columnDefinition = "VARCHAR2|标准药品版本||", nullable = true)
	private Long version;

	@Column(name = "STATUS", columnDefinition = "NUMBER|状态||1", length = 1, nullable = false)
	private Integer status = StatusValue.normalValue.getValue();

	@Column(name = "OPERATOR", columnDefinition = "VARCHAR2|操作者||", length = 100, nullable = false)
	private String operator;

	@Column(name = "OPERATE_TIME", columnDefinition = "NUMBER|操作时间||", nullable = false)
	private Long operateTime;
	
	@Column(name = "OPERATE_TYPE", columnDefinition = "VARCHAR2|操作类型||", length = 50, nullable = true)
	private String operateType;
	
	@Column(name = "CATEGORY_NAME_ONE", columnDefinition = "VARCHAR2|一级分类名||", length = 50, nullable = true)
	private String categoryNameOne;
	
	@Column(name = "CATEGORY_NAME_TWO", columnDefinition = "VARCHAR2|二级分类名||", length = 50, nullable = true)
	private String categoryNameTwo;
	
	@Column(name = "CATEGORY_NAME_THREE", columnDefinition = "VARCHAR2|三级分类名||", length = 50, nullable = true)
	private String categoryNameThree;

	public String getMedicineCode() {
		return this.medicineCode;
	}

	public void setMedicineCode(String medicineCode) {
		this.medicineCode = medicineCode;
	}

	public String getLevelCode() {
		return this.levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	public String getCategoryCode() {
		return this.categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	
	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getEnglishName() {
		return this.englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSpecification() {
		return this.specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getDosage() {
		return this.dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Integer getPackageSize() {
		return this.packageSize;
	}

	public void setPackageSize(Integer packageSize) {
		this.packageSize = packageSize;
	}

	public String getManufactory() {
		return this.manufactory;
	}

	public void setManufactory(String manufactory) {
		this.manufactory = manufactory;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getCategoryNameOne() {
		return categoryNameOne;
	}

	public void setCategoryNameOne(String categoryNameOne) {
		this.categoryNameOne = categoryNameOne;
	}

	public String getCategoryNameTwo() {
		return categoryNameTwo;
	}

	public void setCategoryNameTwo(String categoryNameTwo) {
		this.categoryNameTwo = categoryNameTwo;
	}

	public String getCategoryNameThree() {
		return categoryNameThree;
	}

	public void setCategoryNameThree(String categoryNameThree) {
		this.categoryNameThree = categoryNameThree;
	}

}