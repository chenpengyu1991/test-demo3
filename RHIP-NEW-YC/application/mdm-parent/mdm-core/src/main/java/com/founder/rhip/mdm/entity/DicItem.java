
package com.founder.rhip.mdm.entity;

import com.founder.rhip.mdm.common.StatusValue;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DIC_ITEM")
public class DicItem implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String ITEM_ID = "itemId";
	
	public static final String ITEM_CODE = "itemCode";
	
	public static final String ITEM_NAME = "itemName";
	
	public static final String PARENT_CODE = "parentCode";
	
	public static final String VERSION = "version";
	
	public DicItem() {
		
	}
	
	public DicItem(String itemCode, String itemName) {
		this.itemCode = itemCode;
		this.itemName = itemName;
	}

	@Id
	@Column(name = "ITEM_ID", columnDefinition = "NUMBER|字典项ID|20|", length = 20, nullable = false)
	private Long itemId;

	@Column(name = "DIC_CODE", columnDefinition = "VARCHAR2|标准字典编码|20|", length = 20, nullable = true)
	private String dicCode;

	@Column(name = "ITEM_CODE", columnDefinition = "VARCHAR2|标准字典项编码|50|", length = 50, nullable = true)
	private String itemCode;

	@Column(name = "ITEM_NAME", columnDefinition = "VARCHAR2|字典项名称|500|", length = 500, nullable = true)
	private String itemName;

	@Column(name = "PY_CODE", columnDefinition = "VARCHAR2|拼音码|50|", length = 50, nullable = true)
	private String pyCode;

	@Column(name = "WB_CODE", columnDefinition = "VARCHAR2|五笔码|50|", length = 50, nullable = true)
	private String wbCode;

	@Column(name = "D_CODE", columnDefinition = "VARCHAR2|自定义编码|50|", length = 50, nullable = true)
	private String dCode;

	@Column(name = "PARENT_CODE", columnDefinition = "VARCHAR2|上一级字典编码|20|", length = 20, nullable = true)
	private String parentCode;

	@Column(name = "VERSION", columnDefinition = "NUMBER|版本号|20|", nullable = true)
	private Long version;

	@Column(name = "CS1", columnDefinition = "VARCHAR2|扩展字符型字段1|200|", length = 200, nullable = true)
	private String cs1;

	@Column(name = "CS2", columnDefinition = "VARCHAR2|扩展字符型字段2|200|", length = 200, nullable = true)
	private String cs2;

	@Column(name = "CS3", columnDefinition = "VARCHAR2|扩展字符型字段3|200|", length = 200, nullable = true)
	private String cs3;

	@Column(name = "CS4", columnDefinition = "VARCHAR2|扩展字符型字段4|200|", length = 200, nullable = true)
	private String cs4;

	@Column(name = "CS5", columnDefinition = "VARCHAR2|扩展字符型字段5|200|", length = 200, nullable = true)
	private String cs5;

	@Column(name = "CS6", columnDefinition = "VARCHAR2|扩展字符型字段6|200|", length = 200, nullable = true)
	private String cs6;

	@Column(name = "CS7", columnDefinition = "VARCHAR2|扩展字符型字段7|200|", length = 200, nullable = true)
	private String cs7;

	@Column(name = "CS8", columnDefinition = "VARCHAR2|扩展字符型字段8|200|", length = 200, nullable = true)
	private String cs8;

	@Column(name = "CS9", columnDefinition = "VARCHAR2|扩展字符型字段9|200|", length = 200, nullable = true)
	private String cs9;

	@Column(name = "CS10", columnDefinition = "VARCHAR2|扩展字符型字段10|200|", length = 200, nullable = true)
	private String cs10;

	@Column(name = "STATUS", columnDefinition = "NUMBER|状态|1|", length = 1, nullable = true)
	private Integer status = StatusValue.normalValue.getValue();
	
	@Column(name = "OPERATOR", columnDefinition = "VARCHAR2|操作者||", length = 100, nullable = false)
	private String operator;

	@Column(name = "OPERATE_TIME", columnDefinition = "NUMBER|操作时间||", nullable = false)
	private Long operateTime;

	@Column(name = "OPERATE_TYPE", columnDefinition = "VARCHAR2|操作类型||", length = 50, nullable = true)
	private String operateType;
	
	@Column(name = "SORT", columnDefinition = "NUMBER|排序字段||", length = 1, nullable = true)
	private Integer sort;

	@Column(name = "ICD_CODE", columnDefinition = "VARCHAR2|ICD疾病编码||", length = 1500, nullable = true)
	private String icdCode;


	/*@Transient
	private String parentName;*/
	
	@Transient
	private Integer majorVersion;
	
	@Transient
	private String versionDesc;

	@Transient
	private String organCode;
	
	@Transient
	private String mappingResults;
	
	public Integer getMajorVersion() {
		return majorVersion;
	}

	public void setMajorVersion(Integer majorVersion) {
		this.majorVersion = majorVersion;
	}

	public String getVersionDesc() {
		return versionDesc;
	}

	public void setVersionDesc(String versionDesc) {
		this.versionDesc = versionDesc;
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getMappingResults() {
		return mappingResults;
	}

	public void setMappingResults(String mappingResults) {
		this.mappingResults = mappingResults;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getPyCode() {
		return pyCode;
	}

	public void setPyCode(String pyCode) {
		this.pyCode = pyCode;
	}

	public String getWbCode() {
		return wbCode;
	}

	public void setWbCode(String wbCode) {
		this.wbCode = wbCode;
	}

	public String getdCode() {
		return dCode;
	}

	public void setdCode(String dCode) {
		this.dCode = dCode;
	}

	public String getCs1() {
		return cs1;
	}

	public void setCs1(String cs1) {
		this.cs1 = cs1;
	}

	public String getCs2() {
		return cs2;
	}

	public void setCs2(String cs2) {
		this.cs2 = cs2;
	}

	public String getCs3() {
		return cs3;
	}

	public void setCs3(String cs3) {
		this.cs3 = cs3;
	}

	public String getCs4() {
		return cs4;
	}

	public void setCs4(String cs4) {
		this.cs4 = cs4;
	}

	public String getCs5() {
		return cs5;
	}

	public void setCs5(String cs5) {
		this.cs5 = cs5;
	}

	public String getCs6() {
		return cs6;
	}

	public void setCs6(String cs6) {
		this.cs6 = cs6;
	}

	public String getCs7() {
		return cs7;
	}

	public void setCs7(String cs7) {
		this.cs7 = cs7;
	}

	public String getCs8() {
		return cs8;
	}

	public void setCs8(String cs8) {
		this.cs8 = cs8;
	}

	public String getCs9() {
		return cs9;
	}

	public void setCs9(String cs9) {
		this.cs9 = cs9;
	}

	public String getCs10() {
		return cs10;
	}

	public void setCs10(String cs10) {
		this.cs10 = cs10;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDicCode() {
		return dicCode;
	}

	public void setDicCode(String dicCode) {
		this.dicCode = dicCode;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Long getOperateTime() {
		return operateTime;
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

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getIcdCode() {
		return icdCode;
	}

	public void setIcdCode(String icdCode) {
		this.icdCode = icdCode;
	}
}