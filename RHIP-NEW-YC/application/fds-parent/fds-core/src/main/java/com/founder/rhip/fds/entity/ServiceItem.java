package com.founder.rhip.fds.entity;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="SERVICE_ITEM")
public class ServiceItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|业务主键|11|",length=11,nullable=false)
	private Long id;

	@Column(name="CODE",columnDefinition="VARCHAR2|代码|20|",length=20,nullable=true)
	private String code;

	@Column(name="NAME",columnDefinition="VARCHAR2|名称|64|",length=64,nullable=true)
	private String name;

	@Column(name="PRICE",columnDefinition="NUMBER|价格|6|",length=6,nullable=true)
	private Double price;

	@Column(name="DESCRIPTION",columnDefinition="VARCHAR2|描述|1000|",length=1000,nullable=true)
	private String description;

	@Column(name = "ITEM_TYPE")
	private String itemType;

	@Column(name="VALID",columnDefinition="CHAR|有效性（1：有效，0：无效）|1|",length=1,nullable=true)
	private String valid;

	@Column(name="PUBLISHED",columnDefinition="CHAR|是否发布（1：已发布，0：未发布）|1|",length=1,nullable=true)
	private String published;

	@Column(name="TURNON_DATE",columnDefinition="DATE|启用日期||",nullable=true)
	private Date turnonDate;

	@Column(name="TURNOFF_DATE",columnDefinition="DATE|停用日期||",nullable=true)
	private Date turnoffDate;

	@Column(name="CREATE_USER",columnDefinition="VARCHAR2|创建人|64|",length=64,nullable=true)
	private String createUser;

	@Column(name="CREATE_DATE",columnDefinition="DATE|创建日期||",nullable=true)
	private Date createDate;

	@Column(name="UPDATE_USER",columnDefinition="VARCHAR2|更新人|64|",length=64,nullable=true)
	private String updateUser;

	@Column(name="UPDATE_DATE",columnDefinition="DATE|更新日期||",nullable=true)
	private Date updateDate;

	@Transient
	private String needTimes;

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	@Transient
	private Integer times;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getValid() {
		return this.valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getPublished() {
		return this.published;
	}

	public void setPublished(String published) {
		this.published = published;
	}

	public Date getTurnonDate() {
		return this.turnonDate;
	}

	public void setTurnonDate(Date turnonDate) {
		this.turnonDate = turnonDate;
	}

	public Date getTurnoffDate() {
		return this.turnoffDate;
	}

	public void setTurnoffDate(Date turnoffDate) {
		this.turnoffDate = turnoffDate;
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

	public String getNeedTimes() {
		return needTimes;
	}

	public void setNeedTimes(String needTimes) {
		this.needTimes = needTimes;
	}
}