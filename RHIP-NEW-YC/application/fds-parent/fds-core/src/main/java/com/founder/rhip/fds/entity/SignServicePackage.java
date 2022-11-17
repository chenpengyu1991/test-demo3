package com.founder.rhip.fds.entity;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="SIGN_SERVICE_PACKAGE")
public class SignServicePackage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|业务主键|11|",length=11,nullable=false)
	private Long id;

	@Column(name="SIGN_ID",columnDefinition="NUMBER|签约ID|11|",length=11,nullable=true)
	private Long signId;

	@Column(name="SIGN_PERSON_ID",columnDefinition="NUMBER|签约居民ID|11|",length=11,nullable=true)
	private Long signPersonId;

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

	@Column(name="VALID",columnDefinition="CHAR|有效性（1：有效，0：无效）|1|",length=1,nullable=true)
	private String valid;

	@Column(name="PAID_FLAG",columnDefinition="CHAR|付费标记 0：未付费，1：已付费|1|",length=1,nullable=true)
	private String paidFlag;

	@Column(name="PAID_TIME",columnDefinition="DATE|付费时间||",nullable=true)
	private Date paidTime;

	@Column(name="CANCEL_TIME",columnDefinition="DATE|解约时间||",nullable=true)
	private Date cancelTime;

	@Column(name="RESCIND_FLAG",columnDefinition="CHAR|解约标记（1：已解约，0：正常）|1|",length=1,nullable=true)
	private String rescindFlag;

	@Column(name="CREATE_USER",columnDefinition="VARCHAR2|创建人|64|",length=64,nullable=true)
	private String createUser;

	@Column(name="CREATE_DATE",columnDefinition="DATE|创建日期||",nullable=true)
	private Date createDate;

	@Column(name="UPDATE_USER",columnDefinition="VARCHAR2|更新人|64|",length=64,nullable=true)
	private String updateUser;

	@Column(name="UPDATE_DATE",columnDefinition="DATE|更新日期||",nullable=true)
	private Date updateDate;


	@Transient
	private List<SignServiceItem> signServiceItems;

	//服务包类型
	@Transient
	private String packageType;

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

	public Long getSignPersonId() {
		return this.signPersonId;
	}

	public void setSignPersonId(Long signPersonId) {
		this.signPersonId = signPersonId;
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

	public String getValid() {
		return this.valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getPaidFlag() {
		return this.paidFlag;
	}

	public void setPaidFlag(String paidFlag) {
		this.paidFlag = paidFlag;
	}

	public Date getPaidTime() {
		return this.paidTime;
	}

	public void setPaidTime(Date paidTime) {
		this.paidTime = paidTime;
	}

	public Date getCancelTime() {
		return this.cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public String getRescindFlag() {
		return this.rescindFlag;
	}

	public void setRescindFlag(String rescindFlag) {
		this.rescindFlag = rescindFlag;
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


	public List<SignServiceItem> getSignServiceItems() {
		return signServiceItems;
	}

	public void setSignServiceItems(List<SignServiceItem> signServiceItems) {
		this.signServiceItems = signServiceItems;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
}