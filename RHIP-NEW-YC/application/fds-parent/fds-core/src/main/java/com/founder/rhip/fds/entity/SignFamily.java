package com.founder.rhip.fds.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="SIGN_FAMILY")
public class SignFamily implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|业务主键|11|",length=11,nullable=false)
	private Long id;

	@Column(name="ACCOUNT_NUMBER",columnDefinition="VARCHAR2|户口号|12|",length=12,nullable=true)
	private String accountNumber;

	@Column(name="GBCODE",columnDefinition="VARCHAR2|12位行政区划代码|12|",length=12,nullable=true)
	private String gbcode;

	@Column(name="ZONE_GBCODE",columnDefinition="VARCHAR2|10位行政区划代码|12|",length=12,nullable=true)
	private String zoneGbcode;

	@Column(name="HOUSEHOLDER_NAME",columnDefinition="VARCHAR2|户主姓名|50|",length=50,nullable=true)
	private String householderName;

	@Column(name="HOUSEHOLDER_IDCARD",columnDefinition="VARCHAR2|户主身份证号|18|",length=18,nullable=true)
	private String householderIdcard;

	@Column(name="FAMILY_TYPE",columnDefinition="CHAR|户属性代码|1|",length=1,nullable=true)
	private String familyType;

	@Column(name="PAPROVINCE",columnDefinition="VARCHAR2|现住地址-省(自治区、直辖市)|100|",length=100,nullable=true)
	private String paprovince;

	@Column(name="PACITY",columnDefinition="VARCHAR2|现住地址一市(地区、州)|100|",length=100,nullable=true)
	private String pacity;

	@Column(name="PACOUNTY",columnDefinition="VARCHAR2|现住地址-县(区)|100|",length=100,nullable=true)
	private String pacounty;

	@Column(name="PATOWN_SHIP",columnDefinition="VARCHAR2|现住地址一乡(镇、街道办事处)|100|",length=100,nullable=true)
	private String patownShip;

	@Column(name="PASTREET",columnDefinition="VARCHAR2|现住地址-村(街、路、弄等)|100|",length=100,nullable=true)
	private String pastreet;

	@Column(name="PAHOUSE_NUMBER",columnDefinition="VARCHAR2|现住地址-门牌号码|100|",length=100,nullable=true)
	private String pahouseNumber;

	@Column(name="PAPOST_CODE",columnDefinition="VARCHAR2|现住址邮政编码|10|",length=10,nullable=true)
	private String papostCode;

	@Column(name="HOME_PHONE",columnDefinition="VARCHAR2|住宅电话|20|",length=20,nullable=true)
	private String homePhone;

	@Column(name="ADDRESS",columnDefinition="VARCHAR2|住宅详细地址|100|",length=100,nullable=true)
	private String address;

	@Column(name="PERSON_NUM",columnDefinition="VARCHAR2|家庭人数(人)|2|",length=2,nullable=true)
	private String personNum;

	@Column(name="INPUT_ORGAN_CODE",columnDefinition="VARCHAR2|建档机构编码|20|",length=20,nullable=true)
	private String inputOrganCode;

	@Column(name="INPUT_ORGAN_NAME",columnDefinition="VARCHAR2|建档人员姓名|100|",length=100,nullable=true)
	private String inputOrganName;

	@Column(name="INPUT_DATE",columnDefinition="DATE|建档日期||",nullable=true)
	private Date inputDate;

	@Column(name="MEMBER_LINK",columnDefinition="VARCHAR2|成员基本关系表|500|",length=500,nullable=true)
	private String memberLink;

	@Column(name="IS_DELETE",columnDefinition="NUMBER|删除标记|1|",length=1,nullable=true)
	private Long isDelete;

	@Column(name="STATUS",columnDefinition="NUMBER|家庭状态（0:已建档  1：审核中   2:已注销  3:退回）|1|",length=1,nullable=true)
	private Long status;

	@Column(name="VALID",columnDefinition="CHAR|有效性（1：有效，0：无效）|1|",length=1,nullable=true)
	private String valid;

	@Column(name="SIGN_FLAG",columnDefinition="CHAR|签约标记 0：家庭成员未全部签约，1：家庭成员已全部签约|1|",length=1,nullable=true)
	private String signFlag;

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

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getGbcode() {
		return this.gbcode;
	}

	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
	}

	public String getZoneGbcode() {
		return this.zoneGbcode;
	}

	public void setZoneGbcode(String zoneGbcode) {
		this.zoneGbcode = zoneGbcode;
	}

	public String getHouseholderName() {
		return this.householderName;
	}

	public void setHouseholderName(String householderName) {
		this.householderName = householderName;
	}

	public String getHouseholderIdcard() {
		return this.householderIdcard;
	}

	public void setHouseholderIdcard(String householderIdcard) {
		this.householderIdcard = householderIdcard;
	}

	public String getFamilyType() {
		return this.familyType;
	}

	public void setFamilyType(String familyType) {
		this.familyType = familyType;
	}

	public String getPaprovince() {
		return this.paprovince;
	}

	public void setPaprovince(String paprovince) {
		this.paprovince = paprovince;
	}

	public String getPacity() {
		return this.pacity;
	}

	public void setPacity(String pacity) {
		this.pacity = pacity;
	}

	public String getPacounty() {
		return this.pacounty;
	}

	public void setPacounty(String pacounty) {
		this.pacounty = pacounty;
	}

	public String getPatownShip() {
		return this.patownShip;
	}

	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}

	public String getPastreet() {
		return this.pastreet;
	}

	public void setPastreet(String pastreet) {
		this.pastreet = pastreet;
	}

	public String getPahouseNumber() {
		return this.pahouseNumber;
	}

	public void setPahouseNumber(String pahouseNumber) {
		this.pahouseNumber = pahouseNumber;
	}

	public String getPapostCode() {
		return this.papostCode;
	}

	public void setPapostCode(String papostCode) {
		this.papostCode = papostCode;
	}

	public String getHomePhone() {
		return this.homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPersonNum() {
		return this.personNum;
	}

	public void setPersonNum(String personNum) {
		this.personNum = personNum;
	}

	public String getInputOrganCode() {
		return this.inputOrganCode;
	}

	public void setInputOrganCode(String inputOrganCode) {
		this.inputOrganCode = inputOrganCode;
	}

	public String getInputOrganName() {
		return this.inputOrganName;
	}

	public void setInputOrganName(String inputOrganName) {
		this.inputOrganName = inputOrganName;
	}

	public Date getInputDate() {
		return this.inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public String getMemberLink() {
		return this.memberLink;
	}

	public void setMemberLink(String memberLink) {
		this.memberLink = memberLink;
	}

	public Long getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Long isDelete) {
		this.isDelete = isDelete;
	}

	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getValid() {
		return this.valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getSignFlag() {
		return this.signFlag;
	}

	public void setSignFlag(String signFlag) {
		this.signFlag = signFlag;
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

}