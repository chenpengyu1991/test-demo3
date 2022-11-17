package com.founder.rhip.fds.entity;

import java.io.Serializable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="SERVICE_PACKAGE")
public class ServicePackage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|业务主键|11|",length=11,nullable=false)
	private Long id;

	@Column(name="CODE",columnDefinition="VARCHAR2|代码|20|",length=20,nullable=true)
	private String code;

	@Column(name="NAME",columnDefinition="VARCHAR2|名称|64|",length=64,nullable=true)
	private String name;

	@Column(name="PRICE",columnDefinition="NUMBER|价格|10|",length=10,nullable=true)
	private Double price;

	@Column(name="TYPE",columnDefinition="VARCHAR2|类型|2|",length=2,nullable=true)
	private String type;

	@Column(name="INPUT_PRICE",columnDefinition="NUMBER|人工价格|10|",length=10,nullable=true)
	private Double inputPrice;

	@Column(name="PRICE_DETAIL",columnDefinition="VARCHAR2|价格明细|64|",length=64,nullable=true)
	private String priceDetail;

	@Column(name="DISCOUNT",columnDefinition="NUMBER|折扣|6|",length=6,nullable=true)
	private Double discount;

	@Column(name="PAY_RATIO_DETAIL",columnDefinition="VARCHAR2|签约支付方式|64|",length=64,nullable=true)
	private String payRatioDetail;

	@Column(name="DESCRIPTION",columnDefinition="VARCHAR2|描述|1000|",length=1000,nullable=true)
	private String description;

	@Column(name="GROUP_CLASSIFICATION",columnDefinition="VARCHAR2|人群分类|50|",length=50,nullable=true)
	private String groupClassification;

	@Column(name="VALID",columnDefinition="CHAR|有效性（1：有效，0：无效）|1|",length=1,nullable=true)
	private String valid;

	@Column(name="PUBLISHED",columnDefinition="CHAR|是否发布（1：已发布，0：未发布）|1|",length=1,nullable=true)
	private String published;

	@Column(name="TURNON_DATE",columnDefinition="DATE|启用日期||",nullable=true)
	private Date turnonDate;

	@Column(name="TURNOFF_DATE",columnDefinition="DATE|停用日期||",nullable=true)
	private Date turnoffDate;

	@Column(name="SIGNED_NUM",columnDefinition="NUMBER|签约个数|10|",length=10,nullable=true)
	private Double signedNum;

	@Column(name="CREATE_USER",columnDefinition="VARCHAR2|创建人|64|",length=64,nullable=true)
	private String createUser;

	@Column(name="CREATE_DATE",columnDefinition="DATE|创建日期||",nullable=true)
	private Date createDate;

	@Column(name="UPDATE_USER",columnDefinition="VARCHAR2|更新人|64|",length=64,nullable=true)
	private String updateUser;

	@Column(name="UPDATE_DATE",columnDefinition="DATE|更新日期||",nullable=true)
	private Date updateDate;

	//服务包项目集合
	@Transient
	private List<ServiceItem> serviceItems = new ArrayList<>();

	//服务包类型名称
	@Transient
	private String typeName;

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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getInputPrice() {
		return this.inputPrice;
	}

	public void setInputPrice(Double inputPrice) {
		this.inputPrice = inputPrice;
	}

	public String getPriceDetail() {
		return this.priceDetail;
	}

	public void setPriceDetail(String priceDetail) {
		this.priceDetail = priceDetail;
	}

	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getPayRatioDetail() {
		return this.payRatioDetail;
	}

	public void setPayRatioDetail(String payRatioDetail) {
		this.payRatioDetail = payRatioDetail;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Double getSignedNum() {
		return this.signedNum;
	}

	public void setSignedNum(Double signedNum) {
		this.signedNum = signedNum;
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


	public List<ServiceItem> getServiceItems() {
		return serviceItems;
	}

	public void setServiceItems(List<ServiceItem> serviceItems) {
		this.serviceItems = serviceItems;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}