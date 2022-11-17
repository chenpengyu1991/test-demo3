package com.founder.rhip.mdm.entity;

import com.founder.rhip.mdm.common.StatusValue;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DICTIONARY")
public class Dictionary implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String DIC_CODE = "dicCode";
	
	public static final String DIC_NAME = "dicName";
	
	public static final String CATEGORY_ID = "categoryId";
	
	public static final String VERSION = "version";
	
	public static final String STATUS = "status";

	@Id
	@Column(name = "DIC_CODE", columnDefinition = "VARCHAR2|字典编码|20|", length = 20, nullable = true)
	private String dicCode;

	@Column(name = "DIC_NAME", columnDefinition = "VARCHAR2|字典名称|300|", length = 100, nullable = true)
	private String dicName;
	
	@Column(name = "CATEGORY_ID", columnDefinition = "VARCHAR2|字典分类ID|", length = 20, nullable = true)
	private String categoryId;
	
	@Column(name = "SOURCE_CODE", columnDefinition = "VARCHAR2|使用标准|", length = 20, nullable = true)
	private String sourceCode;

	@Column(name = "OID", columnDefinition = "VARCHAR2|OID|50|", length = 50, nullable = true)
	private String oid;

	@Column(name = "OID_NAME", columnDefinition = "VARCHAR2|OID标识名|100|", length = 100, nullable = true)
	private String oidName;

	@Column(name = "VERSION", columnDefinition = "NUMBER|版本号|20|", nullable = true)
	private Long version;

	@Column(name = "STATUS", columnDefinition = "NUMBER|状态|1|", length = 1, nullable = true)
	private Integer status = StatusValue.normalValue.getValue();
	
	@Column(name = "DESCRIBE", columnDefinition = "VARCHAR2|描述|", length = 500, nullable = true)
	private String describe;
	
	@Column(name = "OPERATOR", columnDefinition = "VARCHAR2|操作者||", length = 100, nullable = false)
	private String operator;

	@Column(name = "OPERATE_TIME", columnDefinition = "NUMBER|操作时间||", nullable = false)
	private Long operateTime;
	
	@Column(name = "OPERATE_TYPE", columnDefinition = "VARCHAR2|操作类型||", length = 50, nullable = true)
	private String operateType;
	
	//private List<DicConfig> configs = new ArrayList<DicConfig>();
	
	private List<DicItem> items = new ArrayList<DicItem>();

	public String getDicCode() {
		return dicCode;
	}

	public void setDicCode(String dicCode) {
		this.dicCode = dicCode;
	}

	public String getDicName() {
		return dicName;
	}

	public void setDicName(String dicName) {
		this.dicName = dicName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getOidName() {
		return oidName;
	}

	public void setOidName(String oidName) {
		this.oidName = oidName;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public List<DicItem> getItems() {
		return items;
	}

	public void setItems(List<DicItem> items) {
		this.items = items;
	}
	
	public void addItem(DicItem item) {
		item.setDicCode(dicCode);
		items.add(item);
	}
/*
	public List<DicConfig> getConfigs() {
		return configs;
	}

	public void setConfigs(List<DicConfig> configs) {
		this.configs = configs;
	}
*/
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
	
}