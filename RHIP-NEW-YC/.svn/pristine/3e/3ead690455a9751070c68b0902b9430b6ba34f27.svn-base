package com.founder.rhip.fds.entity;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="SERVICE_REL_PACKAGE_ITEM")
public class ServiceRelPackageItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|业务主键|11|",length=11,nullable=false)
	private Long id;

	@Column(name="PACKAGE_CODE",columnDefinition="VARCHAR2|包代码|20|",length=20,nullable=true)
	private String packageCode;

	@Column(name="ITEM_CODE",columnDefinition="VARCHAR2|项目代码|20|",length=20,nullable=true)
	private String itemCode;

	@Column(name="PRICE",columnDefinition="NUMBER|价格|6|",length=6,nullable=true)
	private Double price;

	@Column(name="NEED_TIMES",columnDefinition="CHAR|是否计次|1|",length=1,nullable=true)
	private String needTimes;

	@Column(name="TIMES",columnDefinition="NUMBER|次数|6|",length=6,nullable=true)
	private Long times;

	@Column(name="CREATE_USER",columnDefinition="VARCHAR2|创建人|64|",length=64,nullable=true)
	private String createUser;

	@Column(name="CREATE_DATE",columnDefinition="DATE|创建日期||",nullable=true)
	private Date createDate;

	@Column(name="UPDATE_USER",columnDefinition="VARCHAR2|更新人|64|",length=64,nullable=true)
	private String updateUser;

	@Column(name="UPDATE_DATE",columnDefinition="DATE|更新日期||",nullable=true)
	private Date updateDate;

	@Transient
	private String itemName;
	@Transient
	private String packageName;
	@Transient
	private String description;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPackageCode() {
		return this.packageCode;
	}

	public void setPackageCode(String packageCode) {
		this.packageCode = packageCode;
	}

	public String getItemCode() {
		return this.itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getNeedTimes() {
		return this.needTimes;
	}

	public void setNeedTimes(String needTimes) {
		this.needTimes = needTimes;
	}

	public Long getTimes() {
		return this.times;
	}

	public void setTimes(Long times) {
		this.times = times;
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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}