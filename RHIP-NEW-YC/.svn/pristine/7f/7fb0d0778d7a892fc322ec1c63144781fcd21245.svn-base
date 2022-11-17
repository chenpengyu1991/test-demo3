package com.founder.rhip.fds.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="DOCTOR")
public class Doctor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|业务主键|11|",length=11,nullable=false)
	private Long id;

	@Column(name="USER_NAME",columnDefinition="VARCHAR2|用户名|30|",length=30,nullable=true)
	private String userName;

	@Column(name="ORGAN_CODE",columnDefinition="VARCHAR2|医疗卫生机构分类与代码|20|",length=20,nullable=true)
	private String organCode;

	@Column(name="NAME",columnDefinition="VARCHAR2|姓名|50|",length=50,nullable=true)
	private String name;

	@Column(name="ID_CARD",columnDefinition="VARCHAR2|身份证号|20|",length=20,nullable=true)
	private String idCard;

	@Column(name="WORK_ID_CARD",columnDefinition="VARCHAR2|工作证号|20|",length=20,nullable=true)
	private String workIdCard;

	@Column(name="CARD_NUM",columnDefinition="VARCHAR2|胸牌号|20|",length=20,nullable=true)
	private String cardNum;

	@Column(name="BIRTHDAY",columnDefinition="DATE|生日||",nullable=true)
	private Date birthday;

	@Column(name="GENDER",columnDefinition="VARCHAR2|性别代码|1|",length=1,nullable=true)
	private String gender;

	@Column(name="NATION",columnDefinition="VARCHAR2|民族代码|2|",length=2,nullable=true)
	private String nation;

	@Column(name="MARRIAGE",columnDefinition="VARCHAR2|婚姻状况|30|",length=30,nullable=true)
	private String marriage;

	@Column(name="MOBILE",columnDefinition="VARCHAR2|职工手机|20|",length=20,nullable=true)
	private String mobile;

	@Column(name="EMAIL",columnDefinition="VARCHAR2|电子邮箱|100|",length=100,nullable=true)
	private String email;

	@Column(name="UNIVERSITY",columnDefinition="VARCHAR2|毕业学校|100|",length=100,nullable=true)
	private String university;

	@Column(name="GRADUATE_DATE",columnDefinition="DATE|毕业日期||",nullable=true)
	private Date graduateDate;

	@Column(name="SPECIALITY",columnDefinition="VARCHAR2|所学专业名称|100|",length=100,nullable=true)
	private String speciality;

	@Column(name="EDUCATION_CATEGORY",columnDefinition="VARCHAR2|最高学历种类代码|30|",length=30,nullable=true)
	private String educationCategory;

	@Column(name="EDUCATION",columnDefinition="VARCHAR2|最高学历代码|30|",length=30,nullable=true)
	private String education;

	@Column(name="DEGREE",columnDefinition="VARCHAR2|最高学位代码|30|",length=30,nullable=true)
	private String degree;

	@Column(name="STAFF_TYPE",columnDefinition="VARCHAR2|职工分类标志|1|",length=1,nullable=true)
	private String staffType;

	@Column(name="CY_TYPE",columnDefinition="VARCHAR2|从业分类|2|",length=2,nullable=true)
	private String cyType;

	@Column(name="RY_TYPE",columnDefinition="VARCHAR2|人员分类|2|",length=2,nullable=true)
	private String ryType;

	@Column(name="WORK",columnDefinition="VARCHAR2|从事专业|100|",length=100,nullable=true)
	private String work;

	@Column(name="TECHNICAL",columnDefinition="VARCHAR2|职称等级|1|",length=1,nullable=true)
	private String technical;

	@Column(name="TECHNICAL_NAME",columnDefinition="VARCHAR2|职称名称|30|",length=30,nullable=true)
	private String technicalName;

	@Column(name="BUSINESS",columnDefinition="VARCHAR2|职务等级|10|",length=10,nullable=true)
	private String business;

	@Column(name="BUSINESS_NAME",columnDefinition="VARCHAR2|职务名称|30|",length=30,nullable=true)
	private String businessName;

	@Column(name="OFFICE_TEL",columnDefinition="VARCHAR2|办公室电话|20|",length=20,nullable=true)
	private String officeTel;

	@Column(name="OFFICE_FAX",columnDefinition="VARCHAR2|办公室传真|20|",length=20,nullable=true)
	private String officeFax;

	@Column(name="START_WORK_DATE",columnDefinition="DATE|参加工作日期||",nullable=true)
	private Date startWorkDate;

	@Column(name="ORG_WORK_DATE",columnDefinition="DATE|到本单位日期||",nullable=true)
	private Date orgWorkDate;

	@Column(name="PRACTICE_STATUS",columnDefinition="VARCHAR2|执业状态|100|",length=100,nullable=true)
	private String practiceStatus;

	@Column(name="QUAL_CERT",columnDefinition="VARCHAR2|资格证书编码|100|",length=100,nullable=true)
	private String qualCert;

	@Column(name="PRAC_CERT",columnDefinition="VARCHAR2|执业证书编码|100|",length=100,nullable=true)
	private String pracCert;

	@Column(name="PRACTICE_LEVEL",columnDefinition="VARCHAR2|执业级别|100|",length=100,nullable=true)
	private String practiceLevel;

	@Column(name="PRACTICE_TYPE",columnDefinition="VARCHAR2|执业类别|100|",length=100,nullable=true)
	private String practiceType;

	@Column(name="PRACTICE_SUBJECT",columnDefinition="VARCHAR2|执业科目|100|",length=100,nullable=true)
	private String practiceSubject;

	@Column(name="APPROVAL_DATE",columnDefinition="DATE|批准日期||",nullable=true)
	private Date approvalDate;

	@Column(name="AVATAR",columnDefinition="VARCHAR2|头像|200|",length=200,nullable=true)
	private String avatar;

	@Column(name="AVATAR_MONGO",columnDefinition="VARCHAR2|头像(Mongo)|64|",length=64,nullable=true)
	private String avatarMongo;

	@Column(name="CERT_FILE",columnDefinition="VARCHAR2|资质证书文件路径|200|",length=200,nullable=true)
	private String certFile;

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

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getWorkIdCard() {
		return this.workIdCard;
	}

	public void setWorkIdCard(String workIdCard) {
		this.workIdCard = workIdCard;
	}

	public String getCardNum() {
		return this.cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getMarriage() {
		return this.marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUniversity() {
		return this.university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public Date getGraduateDate() {
		return this.graduateDate;
	}

	public void setGraduateDate(Date graduateDate) {
		this.graduateDate = graduateDate;
	}

	public String getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getEducationCategory() {
		return this.educationCategory;
	}

	public void setEducationCategory(String educationCategory) {
		this.educationCategory = educationCategory;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getStaffType() {
		return this.staffType;
	}

	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}

	public String getCyType() {
		return this.cyType;
	}

	public void setCyType(String cyType) {
		this.cyType = cyType;
	}

	public String getRyType() {
		return this.ryType;
	}

	public void setRyType(String ryType) {
		this.ryType = ryType;
	}

	public String getWork() {
		return this.work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getTechnical() {
		return this.technical;
	}

	public void setTechnical(String technical) {
		this.technical = technical;
	}

	public String getTechnicalName() {
		return this.technicalName;
	}

	public void setTechnicalName(String technicalName) {
		this.technicalName = technicalName;
	}

	public String getBusiness() {
		return this.business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getBusinessName() {
		return this.businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getOfficeTel() {
		return this.officeTel;
	}

	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}

	public String getOfficeFax() {
		return this.officeFax;
	}

	public void setOfficeFax(String officeFax) {
		this.officeFax = officeFax;
	}

	public Date getStartWorkDate() {
		return this.startWorkDate;
	}

	public void setStartWorkDate(Date startWorkDate) {
		this.startWorkDate = startWorkDate;
	}

	public Date getOrgWorkDate() {
		return this.orgWorkDate;
	}

	public void setOrgWorkDate(Date orgWorkDate) {
		this.orgWorkDate = orgWorkDate;
	}

	public String getPracticeStatus() {
		return this.practiceStatus;
	}

	public void setPracticeStatus(String practiceStatus) {
		this.practiceStatus = practiceStatus;
	}

	public String getQualCert() {
		return this.qualCert;
	}

	public void setQualCert(String qualCert) {
		this.qualCert = qualCert;
	}

	public String getPracCert() {
		return this.pracCert;
	}

	public void setPracCert(String pracCert) {
		this.pracCert = pracCert;
	}

	public String getPracticeLevel() {
		return this.practiceLevel;
	}

	public void setPracticeLevel(String practiceLevel) {
		this.practiceLevel = practiceLevel;
	}

	public String getPracticeType() {
		return this.practiceType;
	}

	public void setPracticeType(String practiceType) {
		this.practiceType = practiceType;
	}

	public String getPracticeSubject() {
		return this.practiceSubject;
	}

	public void setPracticeSubject(String practiceSubject) {
		this.practiceSubject = practiceSubject;
	}

	public Date getApprovalDate() {
		return this.approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getAvatarMongo() {
		return this.avatarMongo;
	}

	public void setAvatarMongo(String avatarMongo) {
		this.avatarMongo = avatarMongo;
	}

	public String getCertFile() {
		return this.certFile;
	}

	public void setCertFile(String certFile) {
		this.certFile = certFile;
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

}