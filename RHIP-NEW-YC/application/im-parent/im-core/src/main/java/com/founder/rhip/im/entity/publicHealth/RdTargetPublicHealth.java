package com.founder.rhip.im.entity.publicHealth;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="RD_TARGET_PUBLIC_HEALTH")
public class RdTargetPublicHealth implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|业务主键|11|",length=11,nullable=false)
	private Long id;

	@Column(name="TARGET_CODE",columnDefinition="VARCHAR2|指标编码|100|",length=100,nullable=false)
	private String targetCode;

	@Column(name="TARGET_NAME",columnDefinition="VARCHAR2|指标名称|100|",length=100,nullable=false)
	private String targetName;

	@Column(name="VALUE1",columnDefinition="VARCHAR2|指标值1|100|",length=100,nullable=true)
	private String value1;

	@Column(name="VALUE2",columnDefinition="VARCHAR2|指标值2|101|",length=100,nullable=true)
	private String value2;

	@Column(name="VALUE3",columnDefinition="VARCHAR2|指标值3|102|",length=100,nullable=true)
	private String value3;

	@Column(name="VALUE4",columnDefinition="VARCHAR2|指标值4|103|",length=100,nullable=true)
	private String value4;

	@Column(name="VALUE5",columnDefinition="VARCHAR2|指标值5|104|",length=100,nullable=true)
	private String value5;

	@Column(name="VALUE6",columnDefinition="VARCHAR2|指标值6|105|",length=100,nullable=true)
	private String value6;

	@Column(name="VALUE7",columnDefinition="VARCHAR2|指标值7|106|",length=100,nullable=true)
	private String value7;

	@Column(name="VALUE8",columnDefinition="VARCHAR2|指标值8|107|",length=100,nullable=true)
	private String value8;

	@Column(name="VALUE9",columnDefinition="VARCHAR2|指标值9|108|",length=100,nullable=true)
	private String value9;

	@Column(name="VALUE10",columnDefinition="VARCHAR2|指标值10|109|",length=100,nullable=true)
	private String value10;

	@Column(name="CREATER",columnDefinition="VARCHAR2|创建人|100|",length=100,nullable=true)
	private String creater;

	@Column(name="CREATE_ORG_CODE",columnDefinition="VARCHAR2|创建机构|100|",length=100,nullable=true)
	private String createOrgCode;

	@Column(name="CREATE_DATE",columnDefinition="TIMESTAMP|创建时间||",nullable=true)
	private Date createDate;

	@Column(name="UPDATER",columnDefinition="VARCHAR2|更新人|100|",length=100,nullable=true)
	private String updater;

	@Column(name="UPDATE_ORG_CODE",columnDefinition="VARCHAR2|更新机构|100|",length=100,nullable=true)
	private String updateOrgCode;

	@Column(name="UPDATE_DATE",columnDefinition="TIMESTAMP|更新时间||",nullable=true)
	private Date updateDate;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTargetCode() {
		return this.targetCode;
	}

	public void setTargetCode(String targetCode) {
		this.targetCode = targetCode;
	}

	public String getTargetName() {
		return this.targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	public String getValue1() {
		return this.value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return this.value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String getValue3() {
		return this.value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}

	public String getValue4() {
		return this.value4;
	}

	public void setValue4(String value4) {
		this.value4 = value4;
	}

	public String getValue5() {
		return this.value5;
	}

	public void setValue5(String value5) {
		this.value5 = value5;
	}

	public String getValue6() {
		return this.value6;
	}

	public void setValue6(String value6) {
		this.value6 = value6;
	}

	public String getValue7() {
		return this.value7;
	}

	public void setValue7(String value7) {
		this.value7 = value7;
	}

	public String getValue8() {
		return this.value8;
	}

	public void setValue8(String value8) {
		this.value8 = value8;
	}

	public String getValue9() {
		return this.value9;
	}

	public void setValue9(String value9) {
		this.value9 = value9;
	}

	public String getValue10() {
		return this.value10;
	}

	public void setValue10(String value10) {
		this.value10 = value10;
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

	public String getUpdater() {
		return this.updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public String getUpdateOrgCode() {
		return this.updateOrgCode;
	}

	public void setUpdateOrgCode(String updateOrgCode) {
		this.updateOrgCode = updateOrgCode;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}