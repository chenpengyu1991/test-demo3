package com.founder.rhip.mdm.entity;

import java.beans.Transient;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DIC_ITEM_MAP")
public class DicItemMap implements Serializable {

	
	private static final long serialVersionUID = -398448691906444956L;
	
	public static final String MAP_ID = "mapId";
	
	public static final String LOCAL_DIC_CODE = "localDicCode";
	
	public static final String LOCAL_ITEM_CODE = "localItemCode";
	
	public static final String ITEM_CODE_VERSION = "itemCodeVersion";
	
	@Id
	@Column(name = "MAP_ID", columnDefinition = "NUMBER|主键|",nullable = false)
	private Long mapId;

	@Column(name = "DOMAIN_ID", columnDefinition = "VARCHAR2|系统域标识|20|", length = 20, nullable = false)
	private String domainId;

	@Column(name = "LOCAL_DIC_CODE", columnDefinition = "VARCHAR2|本地字典编码|20|", length = 20, nullable = false)
	private String localDicCode;
	
	@Column(name = "LOCAL_ITEM_CODE", columnDefinition = "VARCHAR2|本地字典项目编码|20|", length = 20, nullable = false)
	private String localItemCode;
	
	@Column(name = "LOCAL_ITEM_NAME", columnDefinition = "VARCHAR2|本地字典项目名称|20|", length = 20, nullable = false)
	private String localItemName;
	
	@Column(name = "DIC_CODE", columnDefinition = "VARCHAR2|字典编码|20|", length = 20, nullable = false)
	private String dicCode;
	
	@Column(name = "ITEM_CODE", columnDefinition = "VARCHAR2|映射字典项目编码|20|", length = 20, nullable = false)
	private String itemCode;

	@Column(name = "ITEM_CODE_VERSION", columnDefinition = "NUMBER|映射字典项目编码版本号|", length = 20, nullable = false)
	private Long itemCodeVersion;

	@Column(name = "ITEM_NAME", columnDefinition = "VARCHAR2|映射字典项目名称|500|", length = 500, nullable = false)
	private String itemName;

	@Column(name = "PY_CODE", columnDefinition = "VARCHAR2|拼音码|50|", length = 50, nullable = true)
	private String pyCode;

	@Column(name = "WB_CODE", columnDefinition = "VARCHAR2|五笔码|50|", length = 50, nullable = true)
	private String wbCode;
	
	@Column(name = "D_CODE", columnDefinition = "VARCHAR2|自定义编码|50|", length = 50, nullable = true)
	private String dCode;
	
	@Column(name = "STATUS", columnDefinition = "NUMBER|状态|", nullable = true)
	private Integer status;
	
	@Column(name = "OPERATOR", columnDefinition = "VARCHAR2|操作者||", length = 100, nullable = false)
	private String operator;

	@Column(name = "OPERATE_TIME", columnDefinition = "NUMBER|操作时间||", nullable = false)
	private Long operateTime;

	@Column(name = "OPERATE_TYPE", columnDefinition = "VARCHAR2|操作类型||", length = 50, nullable = true)
	private String operateType;
	
	private String versionDesc;

	public Long getMapId() {
		return mapId;
	}

	public void setMapId(Long mapId) {
		this.mapId = mapId;
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	public String getLocalDicCode() {
		return localDicCode;
	}

	public void setLocalDicCode(String localDicCode) {
		this.localDicCode = localDicCode;
	}

	public String getLocalItemCode() {
		return localItemCode;
	}

	public void setLocalItemCode(String localItemCode) {
		this.localItemCode = localItemCode;
	}

	public String getDicCode() {
		return dicCode;
	}

	public void setDicCode(String dicCode) {
		this.dicCode = dicCode;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Long getItemCodeVersion() {
		return itemCodeVersion;
	}

	public void setItemCodeVersion(Long itemCodeVersion) {
		this.itemCodeVersion = itemCodeVersion;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	@Transient
	public String getVersionDesc() {
		return versionDesc;
	}

	public void setVersionDesc(String versionDesc) {
		this.versionDesc = versionDesc;
	}

	public String getLocalItemName() {
		return localItemName;
	}

	public void setLocalItemName(String localItemName) {
		this.localItemName = localItemName;
	}
	
	
}
