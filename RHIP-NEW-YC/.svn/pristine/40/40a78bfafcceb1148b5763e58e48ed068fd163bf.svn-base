package com.founder.rhip.fds.entity;

import com.founder.fasf.util.StringUtil;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="SIGN_PERSON")
public class SignPerson implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|业务主键|11|",length=11,nullable=false)
	private Long id;

	@Column(name="SIGN_ID",columnDefinition="NUMBER|签约ID|11|",length=11,nullable=true)
	private Long signId;

	@Column(name="SIGN_NUMBER",columnDefinition="VARCHAR2|签约编号|50|",length=50,nullable=true)
	private String signNumber;

	@Column(name="ORGAN_CODE",columnDefinition="VARCHAR2|机构编码|20|",length=20,nullable=true)
	private String organCode;

	@Column(name="TEAM_CODE",columnDefinition="VARCHAR2|团队编码|50|",length=50,nullable=true)
	private String teamCode;

	@Column(name="DOCTOR_ID",columnDefinition="NUMBER|签约医生ID|11|",length=11,nullable=true)
	private Long doctorId;

	@Column(name="SIGN_TYPE",columnDefinition="CHAR|签约类型：个人、家庭(1:个人，2：家庭)|1|",length=1,nullable=true)
	private String signType;

	@Column(name="SIGN_TIME",columnDefinition="DATE|签约时间||",nullable=true)
	private Date signTime;

	@Column(name="CANCEL_TIME",columnDefinition="DATE|解约时间||",nullable=true)
	private Date cancelTime;

	@Column(name="EFFECTIVE_START_DATE",columnDefinition="DATE|生效日期||",nullable=true)
	private Date effectiveStartDate;

	@Column(name="EFFECTIVE_END_DATE",columnDefinition="DATE|终止日期||",nullable=true)
	private Date effectiveEndDate;

	@Column(name="ACCOUNT_NUMBER",columnDefinition="VARCHAR2|户口号|12|",length=12,nullable=true)
	private String accountNumber;

	@Column(name="NAME",columnDefinition="VARCHAR2|姓名|100|",length=100,nullable=true)
	private String name;

	@Column(name="IDCARD_TYPE",columnDefinition="CHAR|证件类型|2|",length=2,nullable=true)
	private String idcardType;

	@Column(name="IDCARD",columnDefinition="VARCHAR2|证件号码|18|",length=18,nullable=true)
	private String idcard;

	@Column(name="PHONE_NUMBER",columnDefinition="VARCHAR2|联系电话|20|",length=20,nullable=true)
	private String phoneNumber;

	@Column(name="ADDRESS",columnDefinition="VARCHAR2|家庭地址|200|",length=200,nullable=true)
	private String address;

	@Column(name="GROUP_CLASSIFICATION",columnDefinition="VARCHAR2|人群分类|50|",length=50,nullable=true)
	private String groupClassification;

	@Column(name="GENDER",columnDefinition="CHAR|性别|1|",length=1,nullable=true)
	private String gender;

	@Column(name="HOUSEHOLD_TYPE",columnDefinition="VARCHAR2|常住类型|10|",length=10,nullable=true)
	private String householdType;

	@Column(name="FAMILY_MEM_TYPE_CODE",columnDefinition="VARCHAR2|家庭成员类别代码|10|",length=10,nullable=true)
	private String familyMemTypeCode;

	@Column(name="VALID",columnDefinition="CHAR|有效性（1：有效，0：无效）|1|",length=1,nullable=true)
	private String valid;

	@Column(name="PAID_FLAG",columnDefinition="CHAR|付费标记 0：未付费，1：已付费|1|",length=1,nullable=true)
	private String paidFlag;

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
	private List<String> groupClassificationList;

	public List<String> getGroupClassificationList() {
		if(StringUtil.isNotEmpty(this.groupClassification)) {
			this.groupClassificationList = Arrays.asList(this.groupClassification.split(","));
		}
		return groupClassificationList;
	}


	//医生姓名
	@Transient
	private String doctorName;
	//团队姓名
	@Transient
	private String teamName;
    //拒绝体检标志 1：拒绝
	@Transient
	private String refuseFlag;
	//存在高血压、糖尿病包标志    
	@Transient
	private String packageFlag;
	//是否做过家医服务标志
	@Transient
	private String serviceFlag;
	
	
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

	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getTeamCode() {
		return this.teamCode;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}

	public Long getDoctorId() {
		return this.doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getSignType() {
		return this.signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public Date getSignTime() {
		return this.signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public Date getCancelTime() {
		return this.cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public Date getEffectiveStartDate() {
		return this.effectiveStartDate;
	}

	public void setEffectiveStartDate(Date effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public Date getEffectiveEndDate() {
		return this.effectiveEndDate;
	}

	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcardType() {
		return this.idcardType;
	}

	public void setIdcardType(String idcardType) {
		this.idcardType = idcardType;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGroupClassification() {
		return this.groupClassification;
	}

	public void setGroupClassification(String groupClassification) {
		this.groupClassification = groupClassification;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHouseholdType() {
		return this.householdType;
	}

	public void setHouseholdType(String householdType) {
		this.householdType = householdType;
	}

	public String getFamilyMemTypeCode() {
		return this.familyMemTypeCode;
	}

	public void setFamilyMemTypeCode(String familyMemTypeCode) {
		this.familyMemTypeCode = familyMemTypeCode;
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

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getRefuseFlag() {
		return refuseFlag;
	}

	public void setRefuseFlag(String refuseFlag) {
		this.refuseFlag = refuseFlag;
	}

	public String getPackageFlag() {
		return packageFlag;
	}

	public void setPackageFlag(String packageFlag) {
		this.packageFlag = packageFlag;
	}

	public String getServiceFlag() {
		return serviceFlag;
	}

	public void setServiceFlag(String serviceFlag) {
		this.serviceFlag = serviceFlag;
	}
	
}