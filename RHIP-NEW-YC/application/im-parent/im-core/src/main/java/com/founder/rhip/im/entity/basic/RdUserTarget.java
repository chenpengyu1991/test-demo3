package com.founder.rhip.im.entity.basic;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="RD_USER_TARGET")
public class RdUserTarget implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|业务主键|11|",length=11,nullable=false)
	private Long id;

	@Column(name="USER_CODE",columnDefinition="VARCHAR2|用户标识|10|",length=10,nullable=false)
	private String userCode;

	@Column(name="USER_NAME",columnDefinition="VARCHAR2|用户名称|150|",length=150,nullable=true)
	private String userName;

	@Column(name="TARGET_ID",columnDefinition="NUMBER|指标ID|11|",length=11,nullable=false)
	private Long targetId;

	@Column(name="NAME_ZH",columnDefinition="VARCHAR2|指标名称|200|",length=200,nullable=true)
	private String nameZh;

	@Column(name="TARGET_CODE",columnDefinition="VARCHAR2|指标编码|60|",length=60,nullable=true)
	private String targetCode;

	@Column(name="TARGET_TYPE",columnDefinition="VARCHAR2|指标类型|20|",length=20,nullable=true)
	private String targetType;

	@Column(name="TARGET_SORT",columnDefinition="NUMBER|排序|11|",length=11,nullable=true)
	private Long targetSort;

	@Column(name="CREATER",columnDefinition="VARCHAR2|创建人|100|",length=100,nullable=true)
	private String creater;

	@Column(name="CREATE_ORG_CODE",columnDefinition="VARCHAR2|创建机构|100|",length=100,nullable=true)
	private String createOrgCode;

	@Column(name="CREATE_DATE",columnDefinition="TIMESTAMP|创建时间||",nullable=true)
	private Date createDate;

	@Column(name="UPDATE_DATE",columnDefinition="TIMESTAMP|更新时间||",nullable=true)
	private Date updateDate;


	@Transient
	private String path;

	@Transient
	private String unit;

	@Transient
	private String chartType;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getTargetId() {
		return this.targetId;
	}

	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}

	public String getNameZh() {
		return this.nameZh;
	}

	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}

	public String getTargetCode() {
		return this.targetCode;
	}

	public void setTargetCode(String targetCode) {
		this.targetCode = targetCode;
	}

	public String getTargetType() {
		return this.targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	public Long getTargetSort() {
		return this.targetSort;
	}

	public void setTargetSort(Long targetSort) {
		this.targetSort = targetSort;
	}

	public String getCreater() {
		return this.creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getCreateOrgCode() {
		return this.createOrgCode;
	}

	public void setCreateOrgCode(String createOrgCode) {
		this.createOrgCode = createOrgCode;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getChartType() {
		return chartType;
	}

	public void setChartType(String chartType) {
		this.chartType = chartType;
	}

}