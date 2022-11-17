package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DC_DEATH_INFO")
public class DeathInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|PERSON号||", length = 11, nullable = true)
    private Long personId;
    
    @Column(name = "NAME", columnDefinition = "VARCHAR2|本人姓名||", length = 50, nullable = true)
    private String name;
    
    @Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号||", length = 17, nullable = true)
	private String healthFileNo;
    
    @Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
    private Date birthday;
    
    @Column(name = "INPUTER_ID", columnDefinition = "VARCHAR2|建档人员ID||", length = 50, nullable = true)
	private String inputerId;

	@Column(name = "INPUT_NAME", columnDefinition = "VARCHAR2|建档人||", length = 30, nullable = true)
	private String inputName;
	
	@Column(name = "INPUT_DATE", columnDefinition = "DATE|建档日期||", nullable = true)
	private Date inputDate;
	
	 @Column(name = "HRPROVINCE", columnDefinition = "VARCHAR2|户籍地址-省(自治区、直辖市)市)||", length = 70, nullable = true)
    private String hrprovince;

    @Column(name = "HRCITY", columnDefinition = "VARCHAR2|户籍地址-市(地区、州)||", length = 70, nullable = true)
    private String hrcity;

    @Column(name = "HRCOUNTY", columnDefinition = "VARCHAR2|户籍地址-县(区)||", length = 70, nullable = true)
    private String hrcounty;
    // 存放住址所选择的区的名称
    @Column(name = "HRTOWN_SHIP", columnDefinition = "VARCHAR2|户籍地址-乡(镇、街道办事处)||", length = 70, nullable = true)
    private String hrtownShip;

    @Column(name = "HRSTREET", columnDefinition = "VARCHAR2|户籍地址-村(街、路、弄等)||", length = 70, nullable = true)
    private String hrstreet;

    @Column(name = "HRHOUSE_NUMBER", columnDefinition = "VARCHAR2|户籍地址-门牌号码||", length = 70, nullable = true)
    private String hrhouseNumber;

    @Column(name = "PAPROVINCE", columnDefinition = "VARCHAR2|现住地址-省(自治区、直辖市)||", length = 70, nullable = true)
    private String paprovince;

    @Column(name = "PACITY", columnDefinition = "VARCHAR2|现住地址-市(地区、州)||", length = 70, nullable = true)
    private String pacity;

    @Column(name = "PACOUNTY", columnDefinition = "VARCHAR2|现住地址-县(区)||", length = 70, nullable = true)
    private String pacounty;

    @Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|现住地址-乡(镇、街道办事处)||", length = 70, nullable = true)
    private String patownShip;

    @Column(name = "PASTREET", columnDefinition = "VARCHAR2|现住地址-村(街、路、弄等)||", length = 70, nullable = true)
    private String pastreet;

    @Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|现住地址-门牌号码||", length = 70, nullable = true)
    private String pahouseNumber;

	@Column(name = "DEATH_REASON", columnDefinition = "VARCHAR2|| 根本死因", length = 20, nullable = true)
	private String deathReason;
    
	 @Column(name = "DEATH_DATE", columnDefinition = "TIMESTAMP|死亡日期时间||", nullable = true)
	private Date deathDate;
    
	  @Column(name = "DEATH_PLACE_TYPE", columnDefinition = "VARCHAR2|死亡地点类别代码||", length = 2, nullable = true)
	  private String deathPlaceType;
	  
	  @Column(name = "PLACE", columnDefinition = "VARCHAR2|死亡地点||", length = 2, nullable = true)
	  private String place;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别代码（可选项，男，女，不明，不详）||", length = 1, nullable = true)
    private String gender;

    @Column(name = "NATION", columnDefinition = "VARCHAR2|民族||", length = 2, nullable = true)
    private String nation;

    @Column(name = "OCCUPATION", columnDefinition = "VARCHAR2|职业类别代码||", length = 3, nullable = true)
    private String occupation;
    
    @Column(name = "DEATH_CERTIFICATE_NO", columnDefinition = "VARCHAR2|死亡医学证明编号||", length = 20, nullable = true)
    private String deathCertificateNo;
    
    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证件号码||", length = 18, nullable = true)
    private String idcard;
    
    @Column(name = "LIVING_TYPE", columnDefinition = "VARCHAR2|常住类型||", length = 20, nullable = true)
	private String livingType;
    
    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况代码||", length = 2, nullable = true)
    private String marriage;

    @Column(name = "EDUCATION", columnDefinition = "VARCHAR2|学历代码||", length = 2, nullable = true)
    private String education;

    @Column(name = "UNIT_NAME", columnDefinition = "VARCHAR2|工作单位名称||", length = 70, nullable = true)
    private String unitName;
    
    @Column(name = "AGE", columnDefinition = "VARCHAR2|实足年龄||", length = 5, nullable = true)
    private String age;

	@Column(name = "GUARDIAN", columnDefinition = "VARCHAR2|家属姓名||", length = 50, nullable = true)
	private String guardian;
	
	@Column(name = "GUARDIAN_UNIT_NAME", columnDefinition = "VARCHAR2|家属姓名||", length = 50, nullable = true)
	private String guardianUnitName;
    

	@Column(name = "DIRECT_CONDITION", columnDefinition = "VARCHAR2|| 直接导致死亡的疾病或情况", length = 20, nullable = true)
	private String directCondition;
	
	@Column(name = "CONDITION_A", columnDefinition = "VARCHAR2|| 引起(a)的疾病或情况", length = 20, nullable = true)
	private String conditionA;
	
	@Column(name = "CONDITION_B", columnDefinition = "VARCHAR2|| 引起(b)的疾病或情况", length = 20, nullable = true)
	private String conditionB;
	
	@Column(name = "CONDITION_C", columnDefinition = "VARCHAR2|| 引起(c)的疾病或情况", length = 25, nullable = true)
	private String conditionC;
	
	@Column(name = "INTERVAL_RUNTIME", columnDefinition = "VARCHAR2|时间间隔-时长||", length = 3, nullable = true)
	private String intervalRuntime;
    
	@Column(name = "DEATH_HIGH_ORGAN_LEVEL", columnDefinition = "VARCHAR2|主要致死疾病的最高诊断机构级别代码||", length = 2, nullable = true)
	private String deathHighOrganLevel;

    @Column(name = "DEATH_HIGH_EVIDENCE_TYPE_CODE", columnDefinition = "VARCHAR2|死亡最高诊断依据类别代码||", length = 1, nullable = true)
    private String deathHighEvidenceTypeCode;
	
    @Column(name = "ADMISSION_NO", columnDefinition = "VARCHAR2|住院号||", length = 10, nullable = true)
    private String admissionNo;

    @Column(name = "DEATH_HOSPITAL_NAME", columnDefinition = "VARCHAR2|死亡医院名称||", length = 70, nullable = true)
    private String deathHospitalName;

    @Column(name = "FILL_USER_NAME", columnDefinition = "VARCHAR2|填报姓名||", length = 50, nullable = true) 
    private String fillUserName;
    
	@Column(name = "FILL_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构代号||", length = 20, nullable = true) 
    private String fillOrganCode;
    
	@Column(name = "FILL_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 70, nullable = true) 
    private String fillOrganName;

    @Column(name = "FILL_TIME", columnDefinition = "TIMESTAMP|填报日期时间||", nullable = true)
    private Date fillTime;
    
    @Column(name = "DOCTOR_NAME", columnDefinition = "VARCHAR2|医师姓名||", length = 50, nullable = true) 
    private String doctorName;

	@Column(name = "REPORT_NO", columnDefinition = "VARCHAR2|| 编号", length = 20, nullable = true)
	private String reportNo;

	@Column(name = "CATEGORY_NO", columnDefinition = "VARCHAR2|| 分类编号（可选项，选中之后将value填写到输入框中）", length = 5, nullable = true)
	private String categoryNo;
	
    @Column(name = "DISEASE_HISTORY", columnDefinition = "VARCHAR2|调查记录生前疾病史及症状体征||", length = 5, nullable = true)
    private String diseaseHistory;
	
    @Column(name = "CONTACT_NAME", columnDefinition = "VARCHAR2|联系人姓名||", length = 50, nullable = true)
    private String contactName;
    
    @Column(name = "RELATION", columnDefinition = "VARCHAR2|联系人姓名||", length = 50, nullable = true)
    private String relation;
    
    @Column(name = "CONTACT_UNIT_NAME", columnDefinition = "VARCHAR2|联系地址或者工作单位||", length = 50, nullable = true)
    private String contactUnitName;

	@Column(name = "DEATH_REASON_DEDUCTION", columnDefinition = "VARCHAR2|| 死因推断", length = 20, nullable = true)
	private String deathReasonDeduction;
	
	@Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete=0;
	
    @Column(name = "SURVEY_TIME", columnDefinition = "TIMESTAMP|调查日期时间||", nullable = true)
    private Date surveyTime;
    
    @Column(name = "CANCEL_STATUS", columnDefinition = "VARCHAR2|注销状态PH00035  0未注销 1已注销||", nullable = true)
    private String cancelStatus;

    @Column(name = "FILING_FLAG", columnDefinition = "VARCHAR2|建档状态||", length = 1, nullable = true)
	private String filingFlag; // 0：未建档 1：已建档，3 已退回 9已注销 4无身份证 5待审核
    
	@Column(name = "HOUSEHOLD_TYPE", columnDefinition = "VARCHAR2|户籍类型||", length = 20, nullable = true)
	private String householdType;
	
	@Column(name = "REMARKS", columnDefinition = "VARCHAR2|户籍类型||", length = 20, nullable = true)
	private String remarks;

	public String getCancelStatus() {
		return cancelStatus;
	}

	public String getFilingFlag() {
		return filingFlag;
	}

	public void setFilingFlag(String filingFlag) {
		this.filingFlag = filingFlag;
	}

	public void setCancelStatus(String cancelStatus) {
		this.cancelStatus = cancelStatus;
	}

	public Date getSurveyTime() {
		return surveyTime;
	}

	public void setSurveyTime(Date surveyTime) {
		this.surveyTime = surveyTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHealthFileNo() {
		return healthFileNo;
	}

	public void setHealthFileNo(String healthFileNo) {
		this.healthFileNo = healthFileNo;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getInputerId() {
		return inputerId;
	}

	public void setInputerId(String inputerId) {
		this.inputerId = inputerId;
	}

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public String getHrprovince() {
		return hrprovince;
	}

	public void setHrprovince(String hrprovince) {
		this.hrprovince = hrprovince;
	}

	public String getHrcity() {
		return hrcity;
	}

	public void setHrcity(String hrcity) {
		this.hrcity = hrcity;
	}

	public String getHrcounty() {
		return hrcounty;
	}

	public void setHrcounty(String hrcounty) {
		this.hrcounty = hrcounty;
	}

	public String getHrtownShip() {
		return hrtownShip;
	}

	public void setHrtownShip(String hrtownShip) {
		this.hrtownShip = hrtownShip;
	}

	public String getHrstreet() {
		return hrstreet;
	}

	public void setHrstreet(String hrstreet) {
		this.hrstreet = hrstreet;
	}

	public String getHrhouseNumber() {
		return hrhouseNumber;
	}

	public void setHrhouseNumber(String hrhouseNumber) {
		this.hrhouseNumber = hrhouseNumber;
	}

	public String getPaprovince() {
		return paprovince;
	}

	public void setPaprovince(String paprovince) {
		this.paprovince = paprovince;
	}

	public String getPacity() {
		return pacity;
	}

	public void setPacity(String pacity) {
		this.pacity = pacity;
	}

	public String getPacounty() {
		return pacounty;
	}

	public void setPacounty(String pacounty) {
		this.pacounty = pacounty;
	}

	public String getPatownShip() {
		return patownShip;
	}

	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}

	public String getPastreet() {
		return pastreet;
	}

	public void setPastreet(String pastreet) {
		this.pastreet = pastreet;
	}

	public String getPahouseNumber() {
		return pahouseNumber;
	}

	public void setPahouseNumber(String pahouseNumber) {
		this.pahouseNumber = pahouseNumber;
	}

	public String getDeathReason() {
		return deathReason;
	}

	public void setDeathReason(String deathReason) {
		this.deathReason = deathReason;
	}

	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	public String getDeathPlaceType() {
		return deathPlaceType;
	}

	public void setDeathPlaceType(String deathPlaceType) {
		this.deathPlaceType = deathPlaceType;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}



	public String getDeathCertificateNo() {
		return deathCertificateNo;
	}

	public void setDeathCertificateNo(String deathCertificateNo) {
		this.deathCertificateNo = deathCertificateNo;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getLivingType() {
		return livingType;
	}

	public void setLivingType(String livingType) {
		this.livingType = livingType;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGuardian() {
		return guardian;
	}

	public void setGuardian(String guardian) {
		this.guardian = guardian;
	}

	public String getGuardianUnitName() {
		return guardianUnitName;
	}

	public void setGuardianUnitName(String guardianUnitName) {
		this.guardianUnitName = guardianUnitName;
	}

	public String getDirectCondition() {
		return directCondition;
	}

	public void setDirectCondition(String directCondition) {
		this.directCondition = directCondition;
	}

	public String getConditionA() {
		return conditionA;
	}

	public void setConditionA(String conditionA) {
		this.conditionA = conditionA;
	}

	public String getConditionB() {
		return conditionB;
	}

	public void setConditionB(String conditionB) {
		this.conditionB = conditionB;
	}

	public String getConditionC() {
		return conditionC;
	}

	public void setConditionC(String conditionC) {
		this.conditionC = conditionC;
	}

	public String getIntervalRuntime() {
		return intervalRuntime;
	}

	public void setIntervalRuntime(String intervalRuntime) {
		this.intervalRuntime = intervalRuntime;
	}

	public String getDeathHighOrganLevel() {
		return deathHighOrganLevel;
	}

	public void setDeathHighOrganLevel(String deathHighOrganLevel) {
		this.deathHighOrganLevel = deathHighOrganLevel;
	}

	public String getDeathHighEvidenceTypeCode() {
		return deathHighEvidenceTypeCode;
	}

	public void setDeathHighEvidenceTypeCode(String deathHighEvidenceTypeCode) {
		this.deathHighEvidenceTypeCode = deathHighEvidenceTypeCode;
	}

	public String getAdmissionNo() {
		return admissionNo;
	}

	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}

	public String getDeathHospitalName() {
		return deathHospitalName;
	}

	public void setDeathHospitalName(String deathHospitalName) {
		this.deathHospitalName = deathHospitalName;
	}

	public String getFillUserName() {
		return fillUserName;
	}

	public void setFillUserName(String fillUserName) {
		this.fillUserName = fillUserName;
	}

	public String getFillOrganCode() {
		return fillOrganCode;
	}

	public void setFillOrganCode(String fillOrganCode) {
		this.fillOrganCode = fillOrganCode;
	}

	public String getFillOrganName() {
		return fillOrganName;
	}

	public void setFillOrganName(String fillOrganName) {
		this.fillOrganName = fillOrganName;
	}

	public Date getFillTime() {
		return fillTime;
	}

	public void setFillTime(Date fillTime) {
		this.fillTime = fillTime;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getReportNo() {
		return reportNo;
	}

	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getDiseaseHistory() {
		return diseaseHistory;
	}

	public void setDiseaseHistory(String diseaseHistory) {
		this.diseaseHistory = diseaseHistory;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getContactUnitName() {
		return contactUnitName;
	}

	public void setContactUnitName(String contactUnitName) {
		this.contactUnitName = contactUnitName;
	}

	public String getDeathReasonDeduction() {
		return deathReasonDeduction;
	}

	public void setDeathReasonDeduction(String deathReasonDeduction) {
		this.deathReasonDeduction = deathReasonDeduction;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getHouseholdType() {
		return householdType;
	}

	public void setHouseholdType(String householdType) {
		this.householdType = householdType;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
    

}
