package com.founder.rhip.ehr.entity.blood;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "BS_BLOOD_DONOR_INFO")
public class BsBloodDonorInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|系统id|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "BLOOD_NO", columnDefinition = "VARCHAR2|献血序列号|18|", length = 18, nullable = false)
	private String bloodNo;

	@Column(name = "BLOOD_DONOR_NO", columnDefinition = "VARCHAR2|献血者识别码|30|", length = 30, nullable = false)
	private String bloodDonorNo;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名|50|", length = 50, nullable = true)
	private String name;

	@Column(name = "BLOOD_CATEGORY", columnDefinition = "VARCHAR2|血液品种名称|50|", length = 50, nullable = true)
	private String bloodCategory;

	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证件号码|30|", length = 30, nullable = true)
	private String idcard;

	@Column(name = "OTHER_IDCARD_TYPE", columnDefinition = "VARCHAR2|其他证件类型|10|", length = 10, nullable = true)
	private String otherIdcardType;

	@Column(name = "OTHER_IDCARD", columnDefinition = "VARCHAR2|其他证件号码|30|", length = 30, nullable = true)
	private String otherIdcard;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别|1|", length = 1, nullable = true)
	private String gender;

	@Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
	private Date birthday;

	@Column(name = "NATIONALITY", columnDefinition = "VARCHAR2|国籍|10|", length = 10, nullable = true)
	private String nationality;

	@Column(name = "NATION", columnDefinition = "VARCHAR2|民族|20|", length = 20, nullable = true)
	private String nation;

	@Column(name = "AGE", columnDefinition = "VARCHAR2|年龄|10|", length = 10, nullable = true)
	private String age;

	@Column(name = "OCCUPATION", columnDefinition = "VARCHAR2|职业|30|", length = 30, nullable = true)
	private String occupation;

	@Column(name = "EDUCATION", columnDefinition = "VARCHAR2|文化程度|20|", length = 20, nullable = true)
	private String education;

	@Column(name = "HOUSEHOLD_TYPE", columnDefinition = "VARCHAR2|常住类型|50|", length = 50, nullable = true)
	private String householdType;

	@Column(name = "UNIT_NAME", columnDefinition = "VARCHAR2|单位名称|70|", length = 70, nullable = true)
	private String unitName;

	@Column(name = "ABO_BLOOD_TYPE", columnDefinition = "VARCHAR2|ABO血型|10|", length = 10, nullable = true)
	private String aboBloodType;

	@Column(name = "RH_BLOOD_TYPE", columnDefinition = "VARCHAR2|Rh血型|10|", length = 10, nullable = true)
	private String rhBloodType;

	@Column(name = "BLOOD_TYPE", columnDefinition = "VARCHAR2|献血方式|50|", length = 50, nullable = true)
	private String bloodType;

	@Column(name = "BLOOD_SAMPLE_TYPE", columnDefinition = "VARCHAR2|采血类型|50|", length = 50, nullable = true)
	private String bloodSampleType;

	@Column(name = "BLOOD_SAMPLE_ERROR", columnDefinition = "VARCHAR2|采血异常|50|", length = 50, nullable = true)
	private String bloodSampleError;

	@Column(name = "BOOLD_VOLUME", columnDefinition = "NUMBER|献血量（特指全血默认单位ml）|10|", length = 10, nullable = true)
	private Long booldVolume;

	@Column(name = "ACTUAL_BOOLD_VOLUME", columnDefinition = "VARCHAR2|实际采血量|50|", length = 50, nullable = true)
	private String actualBooldVolume;

	@Column(name = "CHECK_RESULT", columnDefinition = "VARCHAR2|检验结论|200|", length = 200, nullable = true)
	private String checkResult;

	@Column(name = "OPERATOR_JOB_NO", columnDefinition = "VARCHAR2|采血者工作证编号|18|", length = 18, nullable = true)
	private String operatorJobNo;

	@Column(name = "OPERATOR_NAME", columnDefinition = "VARCHAR2|采血者姓名|50|", length = 50, nullable = true)
	private String operatorName;

	@Column(name = "OPERATOR_IDCARD", columnDefinition = "VARCHAR2|采血者身份证号|18|", length = 18, nullable = true)
	private String operatorIdcard;

	@Column(name = "MOBILIZATION_TYPE", columnDefinition = "VARCHAR2|动员方式|50|", length = 50, nullable = true)
	private String mobilizationType;

	@Column(name = "MOBILIZATION_UNIT", columnDefinition = "VARCHAR2|动员单位|70|", length = 70, nullable = true)
	private String mobilizationUnit;

	@Column(name = "BLOOD_BANK_FLAG", columnDefinition = "VARCHAR2|是否是爱心血库成员|1|", length = 1, nullable = true)
	private String bloodBankFlag;

	@Column(name = "VOLUNTEER_FLAG", columnDefinition = "VARCHAR2|是否是单采自愿者|1|", length = 1, nullable = true)
	private String volunteerFlag;

	@Column(name = "SUITABLE_DATE", columnDefinition = "DATE|适宜献血日期||", nullable = true)
	private Date suitableDate;

	@Column(name = "CONTACT_TEL", columnDefinition = "VARCHAR2|联系方式|14|", length = 14, nullable = true)
	private String contactTel;

	@Column(name = "CREATE_USER_NAME", columnDefinition = "VARCHAR2|创建人姓名|50|", length = 50, nullable = true)
	private String createUserName;

	@Column(name = "CREATE_IDCARD", columnDefinition = "VARCHAR2|创建人身份证|18|", length = 18, nullable = true)
	private String createIdcard;

	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|创建机构代码|18|", length = 18, nullable = true)
	private String createOrganCode;

	@Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|创建机构名称|72|", length = 72, nullable = true)
	private String createOrganName;

	@Column(name = "CREATE_DEPARTMENT_CODE", columnDefinition = "VARCHAR2|创建科室代码|50|", length = 50, nullable = true)
	private String createDepartmentCode;

	@Column(name = "CREATE_DEPARTMENT_NAME", columnDefinition = "VARCHAR2|创建科室名称|100|", length = 100, nullable = true)
	private String createDepartmentName;

	@Column(name = "CREATE_DATE", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createDate;

	@Column(name = "BLOOD_DATE", columnDefinition = "DATE|采血日期||", nullable = true)
	private Date bloodDate;

	@Column(name = "DON_BLOOD", columnDefinition = "VARCHAR2|献血类型及献血量|80|", length = 80, nullable = true)
	private String donBlood;

    @Column(name = "BOOLD_PLASMA", columnDefinition = "NUMBER|献血量（特指血浆默认单位ml）|10|", length = 10, nullable = true)
    private Long booldPlasma;

    @Column(name = "BOOLD_PLATELET", columnDefinition = "NUMBER|献血量（特指血小板默认单位ml）|10|", length = 10, nullable = true)
    private Long booldPlatelet;

    @Column(name = "BOOLD_RBC", columnDefinition = "NUMBER|献血量（特指红细胞默认单位ml）|10|", length = 10, nullable = true)
    private Long booldRbc;

    @Column(name = "BOOLD_OTHER", columnDefinition = "NUMBER|献血量（特指其他默认单位ml）|10|", length = 10, nullable = true)
    private Long booldOther;

    public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBloodNo() {
		return this.bloodNo;
	}

	public void setBloodNo(String bloodNo) {
		this.bloodNo = bloodNo;
	}

	public String getBloodDonorNo() {
		return this.bloodDonorNo;
	}

	public void setBloodDonorNo(String bloodDonorNo) {
		this.bloodDonorNo = bloodDonorNo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBloodCategory() {
		return this.bloodCategory;
	}

	public void setBloodCategory(String bloodCategory) {
		this.bloodCategory = bloodCategory;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getOtherIdcardType() {
		return this.otherIdcardType;
	}

	public void setOtherIdcardType(String otherIdcardType) {
		this.otherIdcardType = otherIdcardType;
	}

	public String getOtherIdcard() {
		return this.otherIdcard;
	}

	public void setOtherIdcard(String otherIdcard) {
		this.otherIdcard = otherIdcard;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getHouseholdType() {
		return this.householdType;
	}

	public void setHouseholdType(String householdType) {
		this.householdType = householdType;
	}

	public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getAboBloodType() {
		return this.aboBloodType;
	}

	public void setAboBloodType(String aboBloodType) {
		this.aboBloodType = aboBloodType;
	}

	public String getRhBloodType() {
		return this.rhBloodType;
	}

	public void setRhBloodType(String rhBloodType) {
		this.rhBloodType = rhBloodType;
	}

	public String getBloodType() {
		return this.bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getBloodSampleType() {
		return this.bloodSampleType;
	}

	public void setBloodSampleType(String bloodSampleType) {
		this.bloodSampleType = bloodSampleType;
	}

	public String getBloodSampleError() {
		return this.bloodSampleError;
	}

	public void setBloodSampleError(String bloodSampleError) {
		this.bloodSampleError = bloodSampleError;
	}

	public Long getBooldVolume() {
		return this.booldVolume;
	}

	public void setBooldVolume(Long booldVolume) {
		this.booldVolume = booldVolume;
	}

	public String getActualBooldVolume() {
		return this.actualBooldVolume;
	}

	public void setActualBooldVolume(String actualBooldVolume) {
		this.actualBooldVolume = actualBooldVolume;
	}

	public String getCheckResult() {
		return this.checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	public String getOperatorJobNo() {
		return this.operatorJobNo;
	}

	public void setOperatorJobNo(String operatorJobNo) {
		this.operatorJobNo = operatorJobNo;
	}

	public String getOperatorName() {
		return this.operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getOperatorIdcard() {
		return this.operatorIdcard;
	}

	public void setOperatorIdcard(String operatorIdcard) {
		this.operatorIdcard = operatorIdcard;
	}

	public String getMobilizationType() {
		return this.mobilizationType;
	}

	public void setMobilizationType(String mobilizationType) {
		this.mobilizationType = mobilizationType;
	}

	public String getMobilizationUnit() {
		return this.mobilizationUnit;
	}

	public void setMobilizationUnit(String mobilizationUnit) {
		this.mobilizationUnit = mobilizationUnit;
	}

	public String getBloodBankFlag() {
		return this.bloodBankFlag;
	}

	public void setBloodBankFlag(String bloodBankFlag) {
		this.bloodBankFlag = bloodBankFlag;
	}

	public String getVolunteerFlag() {
		return this.volunteerFlag;
	}

	public void setVolunteerFlag(String volunteerFlag) {
		this.volunteerFlag = volunteerFlag;
	}

	public Date getSuitableDate() {
		return this.suitableDate;
	}

	public void setSuitableDate(Date suitableDate) {
		this.suitableDate = suitableDate;
	}

	public String getContactTel() {
		return this.contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public String getCreateUserName() {
		return this.createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getCreateIdcard() {
		return this.createIdcard;
	}

	public void setCreateIdcard(String createIdcard) {
		this.createIdcard = createIdcard;
	}

	public String getCreateOrganCode() {
		return this.createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	public String getCreateOrganName() {
		return this.createOrganName;
	}

	public void setCreateOrganName(String createOrganName) {
		this.createOrganName = createOrganName;
	}

	public String getCreateDepartmentCode() {
		return this.createDepartmentCode;
	}

	public void setCreateDepartmentCode(String createDepartmentCode) {
		this.createDepartmentCode = createDepartmentCode;
	}

	public String getCreateDepartmentName() {
		return this.createDepartmentName;
	}

	public void setCreateDepartmentName(String createDepartmentName) {
		this.createDepartmentName = createDepartmentName;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getBloodDate() {
		return this.bloodDate;
	}

	public void setBloodDate(Date bloodDate) {
		this.bloodDate = bloodDate;
	}

	public String getDonBlood() {
		return this.donBlood;
	}

	public void setDonBlood(String donBlood) {
		this.donBlood = donBlood;
	}

    public Long getBooldPlasma() {
        return booldPlasma;
    }

    public void setBooldPlasma(Long booldPlasma) {
        this.booldPlasma = booldPlasma;
    }

    public Long getBooldPlatelet() {
        return booldPlatelet;
    }

    public void setBooldPlatelet(Long booldPlatelet) {
        this.booldPlatelet = booldPlatelet;
    }

    public Long getBooldRbc() {
        return booldRbc;
    }

    public void setBooldRbc(Long booldRbc) {
        this.booldRbc = booldRbc;
    }

    public Long getBooldOther() {
        return booldOther;
    }

    public void setBooldOther(Long booldOther) {
        this.booldOther = booldOther;
    }
}