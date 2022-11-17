package com.founder.rhip.mdm.entity;

import com.founder.rhip.mdm.common.JsonDateSerializer;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "MDM_STAFF")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@XmlRootElement(name = "staff")
public class Staff implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长字段||", length = 50, nullable = false)
	private Long id;

    @Id
    @Column(name = "STAFF_CODE", columnDefinition = "VARCHAR2|人员编号|10|", length = 10, nullable = false)
    private String staffCode;

	@Column(name = "SMPI_ID", columnDefinition = "VARCHAR2|人员主索引标识||", length = 50, nullable = false)
	private String smpiId;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|医疗卫生机构分类与代码||", length = 15, nullable = true)
	private String organCode;

	@Column(name = "DEPT_CODE", columnDefinition = "VARCHAR2|所在科室编码||", length = 5, nullable = true)
	private String deptCode;

	@Column(name = "LOCAL_ID", columnDefinition = "VARCHAR2|机构本地系统ID||", length = 50, nullable = true)
	private String localId;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
	private String name;

	@Column(name = "CPY", columnDefinition = "VARCHAR2|拼音||", length = 100, nullable = true)
	private String cpy;

	@Column(name = "ID_CARD", columnDefinition = "VARCHAR2|身份证号||", length = 20, nullable = true)
	private String idCard;

	@Column(name = "WORK_ID_CARD", columnDefinition = "VARCHAR2|工作证号||", length = 20, nullable = true)
	private String workIdCard;

	@Column(name = "CARD_NUM", columnDefinition = "VARCHAR2|胸牌号||", length = 20, nullable = true)
	private String cardNum;

	@Column(name = "BIRTHDAY", columnDefinition = "DATE|生日||", nullable = true)
	private Date birthday;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别代码||", length = 1, nullable = true)
	private String gender;

	@Column(name = "NATION", columnDefinition = "VARCHAR2|民族代码||", length = 2, nullable = true)
	private String nation;

	@Column(name = "GB_CODE", columnDefinition = "VARCHAR2|12位行政区划代码||", length = 12, nullable = true)
	private String gbCode;

	@Column(name = "PA_PROVINCE", columnDefinition = "VARCHAR2|职工家庭地址-省(自治区、直辖市)||", length = 100, nullable = true)
	private String paProvince;

	@Column(name = "PA_CITY", columnDefinition = "VARCHAR2|职工家庭地址-市(地区、州)||", length = 100, nullable = true)
	private String paCity;

	@Column(name = "PA_COUNTY", columnDefinition = "VARCHAR2|职工家庭地址-县(区)||", length = 100, nullable = true)
	private String paCounty;

	@Column(name = "PA_TOWNSHIP", columnDefinition = "VARCHAR2|职工家庭地址-乡(镇、街道办事处)||", length = 100, nullable = true)
	private String paTownship;

	@Column(name = "PA_STREET", columnDefinition = "VARCHAR2|职工家庭地址-村(街、路、弄等)||", length = 100, nullable = true)
	private String paStreet;

	@Column(name = "PA_HOUSE_NUMBER", columnDefinition = "VARCHAR2|职工家庭地址-门牌号码||", length = 100, nullable = true)
	private String paHouseNumber;

	@Column(name = "PA_POSTCODE", columnDefinition = "VARCHAR2|职工家庭地址地区邮政编码||", length = 6, nullable = true)
	private String paPostcode;

	@Column(name = "HOME_TEL", columnDefinition = "VARCHAR2|职工住宅电话||", length = 20, nullable = true)
	private String homeTel;

	@Column(name = "MOBILE", columnDefinition = "VARCHAR2|职工手机||", length = 20, nullable = true)
	private String mobile;

	@Column(name = "MAIL", columnDefinition = "VARCHAR2|电子邮箱||", length = 100, nullable = true)
	private String mail;

	@Column(name = "UNIVERSITY", columnDefinition = "VARCHAR2|毕业学校||", length = 100, nullable = true)
	private String university;

	@Column(name = "GRADUATE_DATE", columnDefinition = "DATE|毕业日期||", nullable = true)
	private Date graduateDate;

	@Column(name = "SPECIALITY", columnDefinition = "VARCHAR2|所学专业名称||", length = 100, nullable = true)
	private String speciality;

	@Column(name = "EDUCATION_CATEGORY", columnDefinition = "VARCHAR2|最高学历种类代码||", length = 1, nullable = true)
	private String educationCategory;

    @Column(name = "EDUCATION", columnDefinition = "VARCHAR2|最高学历代码||", length = 1, nullable = true)
    private String education;

	@Column(name = "DEGREE", columnDefinition = "VARCHAR2|最高学位代码||", length = 1, nullable = true)
	private String degree;

	@Column(name = "PARTY", columnDefinition = "VARCHAR2|党派编码||", length = 2, nullable = true)
	private String party;

	@Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|居民本人当前婚姻状况代码||", length = 1, nullable = true)
	private String marriage;

	@Column(name = "TYPE", columnDefinition = "VARCHAR2|职工分类标志||", length = 1, nullable = true)
	private String type;

	@Column(name = "WORK", columnDefinition = "VARCHAR2|从事专业||", length = 100, nullable = true)
	private String work;

	@Column(name = "TECHNICAL", columnDefinition = "VARCHAR2|职称等级||", length = 1, nullable = true)
	private String technical;

	@Column(name = "TECHNICAL_NAME", columnDefinition = "VARCHAR2|职称名称||", length = 30, nullable = true)
	private String technicalName;

	@Column(name = "BUSINESS", columnDefinition = "VARCHAR2|职务等级||", length = 1, nullable = true)
	private String business;

	@Column(name = "BUSINESS_NAME", columnDefinition = "VARCHAR2|职务名称||", length = 30, nullable = true)
	private String businessName;

	@Column(name = "OFFICE_TEL", columnDefinition = "VARCHAR2|办公室电话||", length = 20, nullable = true)
	private String officeTel;

	@Column(name = "OFFICE_FAX", columnDefinition = "VARCHAR2|办公室传真||", length = 20, nullable = true)
	private String officeFax;

	@Column(name = "START_WORK_DATE", columnDefinition = "DATE|参加工作日期||", nullable = true)
	private Date startWorkDate;

	@Column(name = "ORG_WORK_DATE", columnDefinition = "DATE|到本单位日期||", nullable = true)
	private Date orgWorkDate;

	@Column(name = "UPDATE_PERSON", columnDefinition = "VARCHAR2|更新人姓名||", length = 100, nullable = true)
	private String updatePerson;
	
	@Column(name = "UPDATE_TIME", columnDefinition = "NUMBER|修改日期||", nullable = false)
	private Long updateTime;
	
	@Column(name = "STATUS", columnDefinition = "NUMBER|在职状态||", length = 1, nullable = false)
	private Integer status = 1;

	@Column(name = "PRACTICE_STATUS", columnDefinition = "VARCHAR2|执业状态||", length = 100, nullable = true)
	private String practiceStatus;

	@Column(name = "QUAL_CERT", columnDefinition = "VARCHAR2|资格证书编码||", length = 100, nullable = true)
	private String qualCert;

	@Column(name = "PRAC_CERT", columnDefinition = "VARCHAR2|执业证书编码||", length = 100, nullable = true)
	private String pracCert;

	@Column(name = "PRACTICE_LEVEL", columnDefinition = "VARCHAR2|执业级别||", length = 100, nullable = true)
	private String practiceLevel;

	@Column(name = "PRACTICE_TYPE", columnDefinition = "VARCHAR2|执业类别||", length = 100, nullable = true)
	private String practiceType;

	@Column(name = "PRACTICE_SUBJECT", columnDefinition = "VARCHAR2|执业科目||", length = 100, nullable = true)
	private String practiceSubject;

	@Column(name = "APPROVAL_DATE", columnDefinition = "DATE|批准日期||", nullable = true)
	private Date approvalDate;

	@Column(name = "OPERATE_TYPE", columnDefinition = "VARCHAR2|操作类型", length = 20, nullable = true)
	private String operateType;
	
	@Column(name = "PERIOD", columnDefinition = "VARCHAR2|学时数|10|", length = 10, nullable = true)
	private String period;

	@Column(name = "CREDIT_A", columnDefinition = "CHAR|一类学分|10|", length = 10, nullable = true)
	private String creditA;

	@Column(name = "CREDIT_B", columnDefinition = "VARCHAR2|二类学分|10|", length = 10, nullable = true)
	private String creditB;

    @Column(name = "CY_TYPE", columnDefinition = "VARCHAR2|从业分类||", length = 2, nullable = true)
    private String cyType;

    @Column(name = "RY_TYPE", columnDefinition = "VARCHAR2|人员分类||", length = 2, nullable = true)
    private String ryType;

    @Column(name = "PARTY_DATE", columnDefinition = "DATE|入党日期||", nullable = true)
    private Date partyDate;

    @Column(name = "PARTY_JOB", columnDefinition = "VARCHAR2|党派职务||", length = 20, nullable = true)
    private String partyJob;

    @Column(name = "JOB_CONDITION", columnDefinition = "VARCHAR2|学术团体任职情况||", length = 100, nullable = true)
    private String jobCondition;

    private String honorString;

    private List<StaffHonor> staffHonors;

	private List<StaffOrg> staffOrgs;

    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getSmpiId() {
		return this.smpiId;
	}

	public void setSmpiId(String smpiId) {
		this.smpiId = smpiId;
	}

	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getDeptCode() {
		return this.deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getLocalId() {
		return this.localId;
	}

	public void setLocalId(String localId) {
		this.localId = localId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpy() {
		return cpy;
	}

	public void setCpy(String cpy) {
		this.cpy = cpy;
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

	@JsonSerialize(using = JsonDateSerializer.class)
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

	public String getGbCode() {
		return this.gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public String getPaProvince() {
		return this.paProvince;
	}

	public void setPaProvince(String paProvince) {
		this.paProvince = paProvince;
	}

	public String getPaCity() {
		return this.paCity;
	}

	public void setPaCity(String paCity) {
		this.paCity = paCity;
	}

	public String getPaCounty() {
		return this.paCounty;
	}

	public void setPaCounty(String paCounty) {
		this.paCounty = paCounty;
	}

	public String getPaTownship() {
		return this.paTownship;
	}

	public void setPaTownship(String paTownship) {
		this.paTownship = paTownship;
	}

	public String getPaStreet() {
		return this.paStreet;
	}

	public void setPaStreet(String paStreet) {
		this.paStreet = paStreet;
	}

	public String getPaHouseNumber() {
		return this.paHouseNumber;
	}

	public void setPaHouseNumber(String paHouseNumber) {
		this.paHouseNumber = paHouseNumber;
	}

	public String getPaPostcode() {
		return this.paPostcode;
	}

	public void setPaPostcode(String paPostcode) {
		this.paPostcode = paPostcode;
	}

	public String getHomeTel() {
		return this.homeTel;
	}

	public void setHomeTel(String homeTel) {
		this.homeTel = homeTel;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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
        return educationCategory;
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

	public String getParty() {
		return this.party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getMarriage() {
		return this.marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getUpdatePerson() {
		return updatePerson;
	}

	public void setUpdatePerson(String updatePerson) {
		this.updatePerson = updatePerson;
	}

	public Long getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPracticeStatus() {
		return practiceStatus;
	}

	public void setPracticeStatus(String practiceStatus) {
		this.practiceStatus = practiceStatus;
	}

	public String getQualCert() {
		return qualCert;
	}

	public void setQualCert(String qualCert) {
		this.qualCert = qualCert;
	}

	public String getPracCert() {
		return pracCert;
	}

	public void setPracCert(String pracCert) {
		this.pracCert = pracCert;
	}

	public String getPracticeLevel() {
		return practiceLevel;
	}

	public void setPracticeLevel(String practiceLevel) {
		this.practiceLevel = practiceLevel;
	}

	public String getPracticeType() {
		return practiceType;
	}

	public void setPracticeType(String practiceType) {
		this.practiceType = practiceType;
	}

	public String getPracticeSubject() {
		return practiceSubject;
	}

	public void setPracticeSubject(String practiceSubject) {
		this.practiceSubject = practiceSubject;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
	
	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getCreditA() {
		return creditA;
	}

	public void setCreditA(String creditA) {
		this.creditA = creditA;
	}

	public String getCreditB() {
		return creditB;
	}

	public void setCreditB(String creditB) {
		this.creditB = creditB;
	}

    public String getCyType() {
        return cyType;
    }

    public void setCyType(String cyType) {
        this.cyType = cyType;
    }

    public String getRyType() {
        return ryType;
    }

    public void setRyType(String ryType) {
        this.ryType = ryType;
    }

    public Date getPartyDate() {
        return partyDate;
    }

    public void setPartyDate(Date partyDate) {
        this.partyDate = partyDate;
    }

    public String getPartyJob() {
        return partyJob;
    }

    public void setPartyJob(String partyJob) {
        this.partyJob = partyJob;
    }

    public String getJobCondition() {
        return jobCondition;
    }

    public void setJobCondition(String jobCondition) {
        this.jobCondition = jobCondition;
    }

    public String getHonorString() {
        return honorString;
    }

    public void setHonorString(String honorString) {
        this.honorString = honorString;
    }

    public List<StaffHonor> getStaffHonors() {
        return staffHonors;
    }

    public void setStaffHonors(List<StaffHonor> staffHonors) {
        this.staffHonors = staffHonors;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

	public List<StaffOrg> getStaffOrgs() {
		return staffOrgs;
	}

	public void setStaffOrgs(List<StaffOrg> staffOrgs) {
		this.staffOrgs = staffOrgs;
	}
}