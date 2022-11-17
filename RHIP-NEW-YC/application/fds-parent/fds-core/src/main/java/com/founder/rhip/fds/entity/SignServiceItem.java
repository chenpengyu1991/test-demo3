package com.founder.rhip.fds.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="SIGN_SERVICE_ITEM")
public class SignServiceItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|业务主键|11|",length=11,nullable=false)
	private Long id;

	@Column(name="SIGN_ID",columnDefinition="NUMBER|签约ID|11|",length=11,nullable=true)
	private Long signId;

	@Column(name="SIGN_NUMBER",columnDefinition="VARCHAR2|签约编号|50|",length=50,nullable=true)
	private String signNumber;

	@Column(name="SERVICE_PACKAGE_CODE",columnDefinition="VARCHAR2|服务包编码|20|",length=20,nullable=true)
	private String servicePackageCode;

	@Column(name="SERVICE_PACKAGE_NAME",columnDefinition="VARCHAR2|服务包名称|64|",length=64,nullable=true)
	private String servicePackageName;

	@Column(name="SERVICE_PACKAGE_PRICE",columnDefinition="NUMBER|服务包价格|10|",length=10,nullable=true)
	private Double servicePackagePrice;

	@Column(name="GROUP_CLASSIFICATION",columnDefinition="VARCHAR2|人群分类|50|",length=50,nullable=true)
	private String groupClassification;

	@Column(name="SERVICE_ITEM_CODE",columnDefinition="VARCHAR2|服务项目编码|20|",length=20,nullable=true)
	private String serviceItemCode;

	@Column(name="SERVICE_ITEM_NAME",columnDefinition="VARCHAR2|服务项目名称|64|",length=64,nullable=true)
	private String serviceItemName;

	@Column(name="SERVICE_ITEM_PRICE",columnDefinition="NUMBER|服务项目价格|10|",length=10,nullable=true)
	private Double serviceItemPrice;

	@Column(name="NEED_TIMES",columnDefinition="CHAR|是否计次|1|",length=1,nullable=true)
	private String needTimes;

	@Column(name="TIMES",columnDefinition="NUMBER|服务次数|6|",length=6,nullable=true)
	private Integer times;

	@Column(name="ACTUAL_TIMES",columnDefinition="NUMBER|实际已服务次数|6|",length=6,nullable=true)
	private Integer actualTimes;

	@Column(name = "ITEM_TYPE")
	private String itemType;

	@Column(name="VALID",columnDefinition="CHAR|有效性（1：有效，0：无效）|1|",length=1,nullable=true)
	private String valid;

	@Column(name="CREATE_USER",columnDefinition="VARCHAR2|创建人|64|",length=64,nullable=true)
	private String createUser;

	@Column(name="CREATE_DATE",columnDefinition="DATE|创建日期||",nullable=true)
	private Date createDate;

	@Column(name="UPDATE_USER",columnDefinition="VARCHAR2|更新人|64|",length=64,nullable=true)
	private String updateUser;

	@Column(name="UPDATE_DATE",columnDefinition="DATE|更新日期||",nullable=true)
	private Date updateDate;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSignId() {
		return this.signId;
	}

	public void setSignId(Long signId) {
		this.signId = signId;
	}

	public String getSignNumber() {
		return this.signNumber;
	}

	public void setSignNumber(String signNumber) {
		this.signNumber = signNumber;
	}

	public String getServicePackageCode() {
		return this.servicePackageCode;
	}

	public void setServicePackageCode(String servicePackageCode) {
		this.servicePackageCode = servicePackageCode;
	}

	public String getServicePackageName() {
		return this.servicePackageName;
	}

	public void setServicePackageName(String servicePackageName) {
		this.servicePackageName = servicePackageName;
	}

	public Double getServicePackagePrice() {
		return this.servicePackagePrice;
	}

	public void setServicePackagePrice(Double servicePackagePrice) {
		this.servicePackagePrice = servicePackagePrice;
	}

	public String getGroupClassification() {
		return this.groupClassification;
	}

	public void setGroupClassification(String groupClassification) {
		this.groupClassification = groupClassification;
	}

	public String getServiceItemCode() {
		return this.serviceItemCode;
	}

	public void setServiceItemCode(String serviceItemCode) {
		this.serviceItemCode = serviceItemCode;
	}

	public String getServiceItemName() {
		return this.serviceItemName;
	}

	public void setServiceItemName(String serviceItemName) {
		this.serviceItemName = serviceItemName;
	}

	public Double getServiceItemPrice() {
		return this.serviceItemPrice;
	}

	public void setServiceItemPrice(Double serviceItemPrice) {
		this.serviceItemPrice = serviceItemPrice;
	}

	public String getNeedTimes() {
		return this.needTimes;
	}

	public void setNeedTimes(String needTimes) {
		this.needTimes = needTimes;
	}

	public Integer getTimes() {
		return this.times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public Integer getActualTimes() {
		return this.actualTimes;
	}

	public void setActualTimes(Integer actualTimes) {
		this.actualTimes = actualTimes;
	}

	public String getValid() {
		return this.valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
}