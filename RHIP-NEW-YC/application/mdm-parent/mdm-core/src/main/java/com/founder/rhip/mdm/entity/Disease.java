package com.founder.rhip.mdm.entity;

import com.founder.rhip.mdm.common.StatusValue;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "MDM_DISEASE")
public class Disease implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String DISEASE_ID = "diseaseId";
	
	public static final String ICD10MAIN = "icd10main";
	
	public static final String ICD10EXT = "icd10ext";
	
	public static final String STATUS = "status";
	
	public static final String OPERATOR = "operator";
	
	public static final String OPERATE_TIME = "operateTime";
	
	public static final String OPERATE_TYPE = "operateType";
	
	public static final String VERSION = "version";

	@Id
	@Column(name = "DISEASE_ID", columnDefinition = "NUMBER|疾病ID||", nullable = false)
	private Long diseaseId;

	@Column(name = "DISEASE_NAME", columnDefinition = "VARCHAR2|疾病名称||", length = 1000, nullable = false)
	private String diseaseName;

	@Column(name = "ICD10MAIN", columnDefinition = "VARCHAR2|ICD10主编码||", length = 20, nullable = true)
	private String icd10main;

	@Column(name = "ICD10EXT", columnDefinition = "VARCHAR2|ICD10附加码||", length = 20, nullable = true)
	private String icd10ext;

	@Column(name = "PARENT_CODE", columnDefinition = "VARCHAR2|上级疾病码||", length = 20, nullable = true)
	private String parentCode;

	@Column(name = "PY_CODE", columnDefinition = "VARCHAR2|拼音码||", length = 20, nullable = true)
	private String pyCode;

	@Column(name = "WB_CODE", columnDefinition = "VARCHAR2|五笔名||", length = 20, nullable = true)
	private String wbCode;

	@Column(name = "DCODE", columnDefinition = "VARCHAR2|自定义名||", length = 20, nullable = true)
	private String dcode;

	@Column(name = "VERSION", columnDefinition = "NUMBER|版本||", nullable = true)
	private Long version;

	@Column(name = "STATUS", columnDefinition = "NUMBER|状态||1", nullable = false)
	private Integer status = StatusValue.normalValue.getValue();
	
	@Column(name = "CATEGORY_ONE", columnDefinition = "VARCHAR2|一级分类||", length = 10, nullable = true)
	private String categoryOne;
	
	@Column(name = "CATEGORY_TWO", columnDefinition = "VARCHAR2|二级分类||", length = 10, nullable = true)
	private String categoryTwo;
	
	@Column(name = "CATEGORYE_THREE", columnDefinition = "VARCHAR2|三级分类||", length = 10, nullable = true)
	private String categoryThree;

	@Column(name = "OPERATOR", columnDefinition = "VARCHAR2|操作者||", length = 20, nullable = false)
	private String operator;

	@Column(name = "OPERATE_TYPE", columnDefinition = "VARCHAR2|操作类型||", length = 20, nullable = true)
	private String operateType;

	@Column(name = "OPERATE_TIME", columnDefinition = "NUMBER|操作时间||", nullable = false)
	private Long operateTime;

	public Long getDiseaseId() {
		return this.diseaseId;
	}

	public void setDiseaseId(Long diseaseId) {
		this.diseaseId = diseaseId;
	}

	public String getDiseaseName() {
		return this.diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public String getIcd10main() {
		return this.icd10main;
	}

	public void setIcd10main(String icd10main) {
		this.icd10main = icd10main;
	}

	public String getIcd10ext() {
		return this.icd10ext;
	}

	public void setIcd10ext(String icd10ext) {
		this.icd10ext = icd10ext;
	}

	public String getParentCode() {
		return this.parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getPyCode() {
		return this.pyCode;
	}

	public void setPyCode(String pyCode) {
		this.pyCode = pyCode;
	}

	public String getWbCode() {
		return this.wbCode;
	}

	public void setWbCode(String wbCode) {
		this.wbCode = wbCode;
	}

	public String getDcode() {
		return this.dcode;
	}

	public void setDcode(String dcode) {
		this.dcode = dcode;
	}

	public Long getVersion() {
		return this.version;
	}

	public void setVersion(Long version) {
		this.version = version;
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

	public String getOperateType() {
		return this.operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public Long getOperateTime() {
		return this.operateTime;
	}

	public void setOperateTime(Long operateTime) {
		this.operateTime = operateTime;
	}

	public String getCategoryOne() {
		return categoryOne;
	}

	public void setCategoryOne(String categoryOne) {
		this.categoryOne = categoryOne;
	}

	public String getCategoryTwo() {
		return categoryTwo;
	}

	public void setCategoryTwo(String categoryTwo) {
		this.categoryTwo = categoryTwo;
	}

	public String getCategoryThree() {
		return categoryThree;
	}

	public void setCategoryThree(String categoryThree) {
		this.categoryThree = categoryThree;
	}

}