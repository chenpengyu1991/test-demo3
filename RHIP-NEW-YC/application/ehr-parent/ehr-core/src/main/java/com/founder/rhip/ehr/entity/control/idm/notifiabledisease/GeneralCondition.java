package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 一般情况
 * @author Jiang Haiying
 *
 */
@Entity
@Table(name = "IDM_GENERAL_CONDITION")
public class GeneralCondition implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编码|11|", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号|17|", length = 17, nullable = true)
	private String healthFileNo;
	
	@Column(name = "NAME", columnDefinition = "VARCHAR2|病人姓名|100|", length = 100, nullable = true)
	private String name;

	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证号|18|", length = 18, nullable = true)
	private String idcard;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别|1|", length = 1, nullable = true)
	private String gender;

	@Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
	private Date birthday;

	@Column(name = "AGE", columnDefinition = "VARCHAR2|年龄|20|", length = 20, nullable = true)
	private String age;

	@Column(name = "AGE_UNIT", columnDefinition = "VARCHAR2|年龄单位|2|", length = 2, nullable = true)
	private String ageUnit;

	@Column(name = "OCCUPATION", columnDefinition = "VARCHAR2|职业|11|", length = 11, nullable = true)
	private String occupation;

	@Column(name = "PAPROVINCE", columnDefinition = "VARCHAR2|现居住地省|20|", length = 20, nullable = true)
	private String paprovince;

	@Column(name = "PACITY", columnDefinition = "VARCHAR2|现居住地市|20|", length = 20, nullable = true)
	private String pacity;

	@Column(name = "PACOUNTY", columnDefinition = "VARCHAR2|现居住地县区|20|", length = 20, nullable = true)
	private String pacounty;

	@Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|现居住地乡街道|100|", length = 100, nullable = true)
	private String patownShip;

	@Column(name = "PASTREET", columnDefinition = "VARCHAR2|现居住地村社区|100|", length = 100, nullable = true)
	private String pastreet;

	@Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|现居住地详细|100|", length = 100, nullable = true)
	private String pahouseNumber;

    @Column(name = "PA_ADDRESS", columnDefinition = "VARCHAR2|现居住址详细|100|", length = 100, nullable = true)
    private String paAddress;

	@Column(name = "ADDRESS_GBCODE", columnDefinition = "VARCHAR2|现住址国标码|100|", length = 100, nullable = true)
	private String addressGbcode;
	
	@Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|联系电话|20|", length = 20, nullable = true)
	private String phoneNumber;

	@Column(name = "PARENTS_NAME", columnDefinition = "VARCHAR2|家长或监护人姓名|50|", length = 50, nullable = true)
	private String parentsName;

	@Column(name = "UNIT_NAME", columnDefinition = "VARCHAR2|工作或学习单位|70|", length = 70, nullable = true)
	private String unitName;
	
	@Column(name = "UNIT_FLAG", columnDefinition = "VARCHAR2|有无单位|2|", length = 65, nullable = true)
	private String unitFlag;
	
	@Column(name = "HRPROVINCE", columnDefinition = "VARCHAR2|户口所在地省|20|", length = 20, nullable = true)
	private String hrprovince;

	@Column(name = "HRCITY", columnDefinition = "VARCHAR2|户口所在地市|20|", length = 20, nullable = true)
	private String hrcity;

	@Column(name = "HRCOUNTY", columnDefinition = "VARCHAR2|户口所在地县区|20|", length = 20, nullable = true)
	private String hrcounty;

	@Column(name = "HRTOWN_SHIP", columnDefinition = "VARCHAR2|户口所在地乡街道|100|", length = 100, nullable = true)
	private String hrtownShip;

	@Column(name = "HRSTREET", columnDefinition = "VARCHAR2|户口所在地村社区|100|", length = 100, nullable = true)
	private String hrstreet;

	@Column(name = "HRHOUSE_NUMBER", columnDefinition = "VARCHAR2|户口所在地详细|100|", length = 100, nullable = true)
	private String hrhouseNumber;

    @Column(name = "HR_ADDRESS", columnDefinition = "VARCHAR2|户口所在地详细|100|", length = 100, nullable = true)
    private String hrAddress;

	@Column(name = "NATION", columnDefinition = "VARCHAR2|民族|2|", length = 2, nullable = true)
	private String nation;

	@Column(name = "GRAVIDA_FLAG", columnDefinition = "VARCHAR2|是否孕妇|2|", length = 2, nullable = true)
	private String gravidaFlag;

	@Column(name = "FLOAT_POPULATION", columnDefinition = "VARCHAR2|是否流动人口|2|", length = 2, nullable = true)
	private String floatPopulation;

	@Column(name = "RESIDENCE_TIME", columnDefinition = "VARCHAR2|发病时在现住址居住时间|2|", length = 2, nullable = true)
	private String residenceTime;

	@Column(name = "PATIENT_ATTRIBUTE", columnDefinition = "VARCHAR2|病人属于|2|", length = 2, nullable = true)
	private String patientAttribute;

	@Column(name = "OCCUPATION_OTHER", columnDefinition = "VARCHAR2|职业-其他|100|", length = 100, nullable = true)
	private String occupationOther;

	@Column(name = "FATHER_NAME", columnDefinition = "VARCHAR2|父亲姓名|50|", length = 50, nullable = true)
	private String fatherName;

	@Column(name = "MOTHER_NAME", columnDefinition = "VARCHAR2|母亲姓名|50|", length = 50, nullable = true)
	private String motherName;

	@Column(name = "UNIT_PHONE", columnDefinition = "VARCHAR2|工作单位电话|20|", length = 20, nullable = true)
	private String unitPhone;

	@Column(name = "LIVING_CONDITIONS", columnDefinition = "VARCHAR2|居住情况|2|", length = 2, nullable = true)
	private String livingConditions;

	@Column(name = "HR_PLACE", columnDefinition = "VARCHAR2|户籍地|2|", length = 2, nullable = true)
	private String hrPlace;

	@Column(name = "COUNTY_RESIDENCE_TIME", columnDefinition = "VARCHAR2|本县居住时间|2|", length = 2, nullable = true)
	private String countyResidenceTime;

	@Column(name = "OUTGO_RANGE", columnDefinition = "VARCHAR2|发病前25天内外出情况，及其外出范围|2|", length = 2, nullable = true)
	private String outgoRange;

	@Column(name = "RANGE_OTHER_PROVINCES", columnDefinition = "VARCHAR2|外省|100|", length = 100, nullable = true)
	private String rangeOtherProvinces;

	@Column(name = "CONTACT_NAME", columnDefinition = "VARCHAR2|联系人|50|", length = 50, nullable = true)
	private String contactName;

	@Column(name = "CONTACT_PHONE", columnDefinition = "VARCHAR2|联系电话|20|", length = 20, nullable = true)
	private String contactPhone;

	@Column(name = "CONTACT_NAME_1", columnDefinition = "VARCHAR2|联系人1|50|", length = 50, nullable = true)
	private String contactName1;

	@Column(name = "CONTACT_PHONE_1", columnDefinition = "VARCHAR2|联系电话1|20|", length = 20, nullable = true)
	private String contactPhone1;
	
	@Column(name = "CONTACT_NAME_2", columnDefinition = "VARCHAR2|联系人2|50|", length = 50, nullable = true)
	private String contactName2;

	@Column(name = "CONTACT_PHONE_2", columnDefinition = "VARCHAR2|联系电话3|20|", length = 20, nullable = true)
	private String contactPhone2;
	
	@Column(name = "NATIONALITY", columnDefinition = "VARCHAR2|国籍|2|", length = 2, nullable = true)
	private String nationality;

	@Column(name = "NATIONALITY_OTHER", columnDefinition = "VARCHAR2|国籍其他|100|", length = 100, nullable = true)
	private String nationalityOther;

	@Column(name = "MOBILE", columnDefinition = "VARCHAR2|移动电话|20|", length = 20, nullable = true)
	private String mobile;

	@Column(name = "FAMILY_PHONE", columnDefinition = "VARCHAR2|家庭电话|20|", length = 20, nullable = true)
	private String familyPhone;

	@Column(name = "PARENTS_UNIT", columnDefinition = "VARCHAR2|家长工作单位|20|", length = 20, nullable = true)
	private String parentsUnit;

	@Column(name = "PARENTS_PHONE", columnDefinition = "VARCHAR2|家长电话号码|20|", length = 20, nullable = true)
	private String parentsPhone;

	@Column(name = "RELATION", columnDefinition = "VARCHAR2|与户主关系|2|", length = 2, nullable = true)
	private String relation;

	@Column(name = "EDUCATION", columnDefinition = "VARCHAR2|患者文化程度|5|", length = 5, nullable = true)
	private String education;

	@Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况|2|", length = 2, nullable = true)
	private String marriage;

	@Column(name = "MARRIAGE_DATE", columnDefinition = "DATE|结婚时间||", nullable = true)
	private Date marriageDate;

	@Column(name = "RESIDENCE_TYPE", columnDefinition = "VARCHAR2|居住地类型|2|", length = 2, nullable = true)
	private String residenceType;

	@Column(name = "ORGAN_LEVEL", columnDefinition = "VARCHAR2|诊断单位级别|2|", length = 2, nullable = true)
	private String organLevel;

	@Column(name = "RESIDENCE_GBCODE", columnDefinition = "VARCHAR2|户口国标码|100|", length = 100, nullable = true)
	private String residenceGbcode;

	@Column(name = "FATHER_UNIT", columnDefinition = "VARCHAR2|父亲工作单位|20|", length = 20, nullable = true)
	private String fatherUnit;

	@Column(name = "FATHER_ADDR", columnDefinition = "VARCHAR2|父亲单位地址|100|", length = 100, nullable = true)
	private String fatherAddr;

	@Column(name = "MOTHER_UNIT", columnDefinition = "VARCHAR2|母亲工作单位|20|", length = 20, nullable = true)
	private String motherUnit;

	@Column(name = "MOTHER_ADDR", columnDefinition = "VARCHAR2|母亲单位地址|100|", length = 100, nullable = true)
	private String motherAddr;

	@Column(name = "GBCODE", columnDefinition = "VARCHAR2|国标码|100|", length = 100, nullable = true)
	private String gbcode;

	@Column(name = "ADDR_TYPE", columnDefinition = "VARCHAR2|现住址-单选|2|", length = 2, nullable = true)
	private String addrType;

	@Column(name = "NATION_OTHER", columnDefinition = "VARCHAR2|民族-其他|20|", length = 20, nullable = true)
	private String nationOther;

	@Column(name = "PACATEGORY", columnDefinition = "VARCHAR2|现居住地组|20|", length = 20, nullable = true)
	private String pacategory;

	@Column(name = "HRCATEGORY", columnDefinition = "VARCHAR2|户籍所在地组|20|", length = 20, nullable = true)
	private String hrcategory;

	@Column(name = "BIRTHDATE_TYPE", columnDefinition = "VARCHAR2|生日类型|2|", length = 2, nullable = true)
	private String birthdateType;

	@Column(name = "BIRTHDATE_ADDR", columnDefinition = "VARCHAR2|生日地点|2|", length = 2, nullable = true)
	private String birthdateAddr;
	
	@Column(name = "OCCUPATION_FLAG", columnDefinition = "VARCHAR2|职业-选择（是否是医院工作人员）|11|", length = 11, nullable = true)
	private String occupationFlag;
	
	@Column(name = "LIVING_CONDITIONS_Other", columnDefinition = "VARCHAR2|居住情况－其他|100|", length = 100, nullable = true)
	private String livingConditionsOther;

    @Column(name = "DETAIN", columnDefinition = "VARCHAR2|羁押人员|2|", length = 2, nullable = true)
    private String detain;

    @Column(name = "FAMILY_INCOME", columnDefinition = "VARCHAR2|家庭年收入|20|", length = 20, nullable = true)
    private String familyIncome;

    @Column(name = "HEAD_HOUSEHOLD_NAME", columnDefinition = "VARCHAR2|户主姓名|50|", length = 50, nullable = true)
    private String headHouseholdName;

    @Column(name = "LABOR_FORCE", columnDefinition = "VARCHAR2|劳动力|2|", length = 2, nullable = true)
    private String laborForce;

    @Column(name = "POSTCODE", columnDefinition = "VARCHAR2|邮编|10|", length = 10, nullable = true)
    private String postcode;

    @Column(name = "NATIVE_PLACE", columnDefinition = "VARCHAR2|籍贯|100|", length = 100, nullable = true)
    private String nativePlace;
    
    @Column(name = "REGISTER_NUM", columnDefinition = "VARCHAR2|登记号|100|", length = 100, nullable = true)
    private String registerNum;

    @Column(name = "UNIT", columnDefinition = "VARCHAR2|病案号|100|", length = 100, nullable = true)
    private String unit;
    
    @Column(name = "TITLE_CITY", columnDefinition = "VARCHAR2|地(市）|100|", length = 100, nullable = true)
    private String titleCity;
    
    @Column(name = "TITLE_TOWN", columnDefinition = "VARCHAR2|县(区)|100|", length = 100, nullable = true)
    private String titleTown;
    
    @Column(name = "TITLE_UNIT", columnDefinition = "VARCHAR2|单位名称|100|", length = 100, nullable = true)
    private String titleUnit;

    @Column(name = "EDUCATION_YEAR", columnDefinition = "VARCHAR2|受正规教育年限|2|", length = 2, nullable = true)
    private String educationYear;

    @Column(name = "EPIDEMIC", columnDefinition = "VARCHAR2|居住地为（流行；非流行）|2|", length = 2, nullable = true)
    private String epidemic;

    @Column(name = "HR_TYPE", columnDefinition = "VARCHAR2|户口性质|2|", length = 2, nullable = true)
    private String hrType;

    @Column(name = "LOSE_JOB", columnDefinition = "VARCHAR2|是否失业|2|", length = 2, nullable = true)
    private String loseJob;

    @Column(name = "LOW_OBJECT", columnDefinition = "VARCHAR2|是否低保|2|", length = 2, nullable = true)
    private String lowObject;

    @Column(name = "HI_TYPE", columnDefinition = "VARCHAR2|医保类型|20|", length = 20, nullable = true)
    private String hiType;    

	@Column(name = "REPROVINCE", columnDefinition = "VARCHAR2|调查地省|20|", length = 20, nullable = true)
	private String reprovince;

	@Column(name = "RECITY", columnDefinition = "VARCHAR2|调查地市|20|", length = 20, nullable = true)
	private String recity;

	@Column(name = "RECOUNTY", columnDefinition = "VARCHAR2|调查地县区|20|", length = 20, nullable = true)
	private String recounty;

	@Column(name = "RETOWN_SHIP", columnDefinition = "VARCHAR2|调查地乡街道|100|", length = 100, nullable = true)
	private String retownShip;

	@Column(name = "RESTREET", columnDefinition = "VARCHAR2|调查地村社区|100|", length = 100, nullable = true)
	private String restreet;

	@Column(name = "REHOUSE_NUMBER", columnDefinition = "VARCHAR2|调查地门牌号|100|", length = 100, nullable = true)
	private String rehouseNumber;

    @Column(name = "RE_ADDRESS", columnDefinition = "VARCHAR2|调查地详细|100|", length = 100, nullable = true)
    private String reAddress;
    
    @Column(name = "SCHOOL_NAME", columnDefinition = "VARCHAR2|学校（幼儿园）名称|50|", length = 50, nullable = true)
	private String schoolName;
    
    @Column(name = "CLASSES", columnDefinition = "VARCHAR2|班级|20|", length = 20, nullable = true)
	private String classes;
    
    @Column(name = "GRADES", columnDefinition = "VARCHAR2|年级 |20|", length = 20, nullable = true)
	private String grades;

	@Column(name = "FAMILY_NUM", columnDefinition = "VARCHAR2|家庭人数|20|", length = 20, nullable = true)
	private String familyNum;

	@Column(name = "PREVALENCE", columnDefinition = "VARCHAR2|患病人数|20|", length = 20, nullable = true)
	private String prevalence;

	@Column(name = "OTHER_HR_PLACE", columnDefinition = "VARCHAR2|其他户籍地|100|", length = 100, nullable = true)
	private String otherHrPlace;

	@Column(name = "RELATIVE_RESIDENCE", columnDefinition = "VARCHAR2|相对住址户籍地|2|", length = 2, nullable = true)
	private String relativeResidence;
	//风疹病例
	@Column(name = "LESS_IN_PREGNANCY", columnDefinition = "VARCHAR2|于妊娠期小于3月|2|", length = 2, nullable = true)
	private String lessInPregnancy;
	
	@Column(name = "FROM_PROVINCE", columnDefinition = "VARCHAR2|来自省|20|", length = 20, nullable = true)
	private String fromProvince;
	
	@Column(name = "TO_SUZHOU_DATE", columnDefinition = "VARCHAR2|来苏州日期||", nullable = true)
	private Date toSuzhouDate;
	
	@Column(name = "TO_SUZHOU_TIME", columnDefinition = "VARCHAR2|来苏州时间|20|", length = 20, nullable = true)
	private String toSuzhouTime;

	@Column(name = "HR_GROUP", columnDefinition = "VARCHAR2|户籍小组地址||", length = 2, nullable = true)
	private String hrGroup;

	@Column(name = "PA_GROUP", columnDefinition = "VARCHAR2|现住址小组地址||", length = 2, nullable = true)
	private String paGroup;

	@Column(name = "RE_GROUP", columnDefinition = "VARCHAR2|调查地小组地址||", length = 2, nullable = true)
	private String reGroup;

	@Column(name = "DISCONTINUED_DATE", columnDefinition = "DATE|停止治疗时间||",  nullable = true)
	private Date discontinuedDate;

	@Column(name = "DISCONTINUED_REASON", columnDefinition = "VARCHAR2|停止治疗原因|20|", length = 100, nullable = true)
	private String discontinuedReason;

	@Column(name = "SHOULD_VISIT_NUM", columnDefinition = "NUMBER|应访视患者次数|20|", length = 20, nullable = true)
	private Integer shouldVisitNum;

	@Column(name = "ACTUAL_VISIT_NUM", columnDefinition = "NUMBER|实际访视次数|20|", length = 20, nullable = true)
	private Integer actualVisitNum;

	@Column(name = "SHOULD_DOSE_NUM", columnDefinition = "NUMBER|患者应服药次数|20|", length = 20, nullable = true)
	private Integer shouldDoseNum;

	@Column(name = "ACTUAL_DOSE_NUM", columnDefinition = "NUMBER|实际服药次数|20|", length = 20, nullable = true)
	private Integer actualDoseNum;

	@Column(name = "EVALUATE_DOC", columnDefinition = "VARCHAR2|评估医生签名|20|", length = 20, nullable = true)
	private String evaluateDoc;

	@Transient
	private double doseRate;

	public double getDoseRate() {
		return doseRate;
	}

	public void setDoseRate(double doseRate) {
		this.doseRate = doseRate;
	}

	public Integer getShouldVisitNum() {
		return shouldVisitNum;
	}

	public void setShouldVisitNum(Integer shouldVisitNum) {
		this.shouldVisitNum = shouldVisitNum;
	}

	public Integer getActualVisitNum() {
		return actualVisitNum;
	}

	public void setActualVisitNum(Integer actualVisitNum) {
		this.actualVisitNum = actualVisitNum;
	}

	public Integer getShouldDoseNum() {
		return shouldDoseNum;
	}

	public void setShouldDoseNum(Integer shouldDoseNum) {
		this.shouldDoseNum = shouldDoseNum;
	}

	public Integer getActualDoseNum() {
		return actualDoseNum;
	}

	public void setActualDoseNum(Integer actualDoseNum) {
		this.actualDoseNum = actualDoseNum;
	}

	public String getEvaluateDoc() {
		return evaluateDoc;
	}

	public void setEvaluateDoc(String evaluateDoc) {
		this.evaluateDoc = evaluateDoc;
	}

	public Date getDiscontinuedDate() {
		return discontinuedDate;
	}

	public void setDiscontinuedDate(Date discontinuedDate) {
		this.discontinuedDate = discontinuedDate;
	}

	public String getDiscontinuedReason() {
		return discontinuedReason;
	}

	public void setDiscontinuedReason(String discontinuedReason) {
		this.discontinuedReason = discontinuedReason;
	}

	public String getFromProvince() {
		return fromProvince;
	}

	public void setFromProvince(String fromProvince) {
		this.fromProvince = fromProvince;
	}

	public Date getToSuzhouDate() {
		return toSuzhouDate;
	}

	public void setToSuzhouDate(Date toSuzhouDate) {
		this.toSuzhouDate = toSuzhouDate;
	}

	public String getToSuzhouTime() {
		return toSuzhouTime;
	}

	public void setToSuzhouTime(String toSuzhouTime) {
		this.toSuzhouTime = toSuzhouTime;
	}

	public String getLessInPregnancy() {
		return lessInPregnancy;
	}

	public void setLessInPregnancy(String lessInPregnancy) {
		this.lessInPregnancy = lessInPregnancy;
	}

	public String getRelativeResidence() {
		return relativeResidence;
	}

	public void setRelativeResidence(String relativeResidence) {
		this.relativeResidence = relativeResidence;
	}

	public String getOtherHrPlace() {
		return otherHrPlace;
	}

	public void setOtherHrPlace(String otherHrPlace) {
		this.otherHrPlace = otherHrPlace;
	}

	public String getFamilyNum() {
		return familyNum;
	}

	public void setFamilyNum(String familyNum) {
		this.familyNum = familyNum;
	}

	public String getPrevalence() {
		return prevalence;
	}

	public void setPrevalence(String prevalence) {
		this.prevalence = prevalence;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getGrades() {
		return grades;
	}

	public void setGrades(String grades) {
		this.grades = grades;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdmId() {
		return this.idmId;
	}

	public void setIdmId(Long idmId) {
		this.idmId = idmId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAgeUnit() {
		return this.ageUnit;
	}

	public void setAgeUnit(String ageUnit) {
		this.ageUnit = ageUnit;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
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
        return pahouseNumber;
    }

    public void setPahouseNumber(String pahouseNumber) {
        this.pahouseNumber = pahouseNumber;
    }

    public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

    public String getPaAddress() {
        return paAddress;
    }

    public void setPaAddress(String paAddress) {
        this.paAddress = paAddress;
    }

    public String getParentsName() {
		return this.parentsName;
	}

	public void setParentsName(String parentsName) {
		this.parentsName = parentsName;
	}

	public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getHrprovince() {
		return this.hrprovince;
	}

	public void setHrprovince(String hrprovince) {
		this.hrprovince = hrprovince;
	}

	public String getHrcity() {
		return this.hrcity;
	}

	public void setHrcity(String hrcity) {
		this.hrcity = hrcity;
	}

	public String getHrcounty() {
		return this.hrcounty;
	}

	public void setHrcounty(String hrcounty) {
		this.hrcounty = hrcounty;
	}

	public String getHrtownShip() {
		return this.hrtownShip;
	}

	public void setHrtownShip(String hrtownShip) {
		this.hrtownShip = hrtownShip;
	}

	public String getHrstreet() {
		return this.hrstreet;
	}

	public void setHrstreet(String hrstreet) {
		this.hrstreet = hrstreet;
	}

	public String getHrhouseNumber() {
		return this.hrhouseNumber;
	}

	public void setHrhouseNumber(String hrhouseNumber) {
		this.hrhouseNumber = hrhouseNumber;
	}

    public String getHrAddress() {
        return hrAddress;
    }

    public void setHrAddress(String hrAddress) {
        this.hrAddress = hrAddress;
    }

    public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getGravidaFlag() {
		return this.gravidaFlag;
	}

	public void setGravidaFlag(String gravidaFlag) {
		this.gravidaFlag = gravidaFlag;
	}

	public String getFloatPopulation() {
		return this.floatPopulation;
	}

	public void setFloatPopulation(String floatPopulation) {
		this.floatPopulation = floatPopulation;
	}

	public String getResidenceTime() {
		return this.residenceTime;
	}

	public void setResidenceTime(String residenceTime) {
		this.residenceTime = residenceTime;
	}

	public String getPatientAttribute() {
		return this.patientAttribute;
	}

	public void setPatientAttribute(String patientAttribute) {
		this.patientAttribute = patientAttribute;
	}

	public String getOccupationOther() {
		return this.occupationOther;
	}

	public void setOccupationOther(String occupationOther) {
		this.occupationOther = occupationOther;
	}

	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return this.motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getUnitPhone() {
		return this.unitPhone;
	}

	public void setUnitPhone(String unitPhone) {
		this.unitPhone = unitPhone;
	}

	public String getLivingConditions() {
		return this.livingConditions;
	}

	public void setLivingConditions(String livingConditions) {
		this.livingConditions = livingConditions;
	}

	public String getHrPlace() {
		return this.hrPlace;
	}

	public void setHrPlace(String hrPlace) {
		this.hrPlace = hrPlace;
	}

	public String getCountyResidenceTime() {
		return this.countyResidenceTime;
	}

	public void setCountyResidenceTime(String countyResidenceTime) {
		this.countyResidenceTime = countyResidenceTime;
	}

	public String getOutgoRange() {
		return this.outgoRange;
	}

	public void setOutgoRange(String outgoRange) {
		this.outgoRange = outgoRange;
	}

	public String getRangeOtherProvinces() {
		return this.rangeOtherProvinces;
	}

	public void setRangeOtherProvinces(String rangeOtherProvinces) {
		this.rangeOtherProvinces = rangeOtherProvinces;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNationalityOther() {
		return this.nationalityOther;
	}

	public void setNationalityOther(String nationalityOther) {
		this.nationalityOther = nationalityOther;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFamilyPhone() {
		return this.familyPhone;
	}

	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}

	public String getParentsUnit() {
		return this.parentsUnit;
	}

	public void setParentsUnit(String parentsUnit) {
		this.parentsUnit = parentsUnit;
	}

	public String getParentsPhone() {
		return this.parentsPhone;
	}

	public void setParentsPhone(String parentsPhone) {
		this.parentsPhone = parentsPhone;
	}

	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getMarriage() {
		return this.marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public Date getMarriageDate() {
		return this.marriageDate;
	}

	public void setMarriageDate(Date marriageDate) {
		this.marriageDate = marriageDate;
	}

	public String getResidenceType() {
		return this.residenceType;
	}

	public void setResidenceType(String residenceType) {
		this.residenceType = residenceType;
	}

	public String getOrganLevel() {
		return this.organLevel;
	}

	public void setOrganLevel(String organLevel) {
		this.organLevel = organLevel;
	}

	public String getResidenceGbcode() {
		return this.residenceGbcode;
	}

	public void setResidenceGbcode(String residenceGbcode) {
		this.residenceGbcode = residenceGbcode;
	}

	public String getFatherUnit() {
		return this.fatherUnit;
	}

	public void setFatherUnit(String fatherUnit) {
		this.fatherUnit = fatherUnit;
	}

	public String getFatherAddr() {
		return this.fatherAddr;
	}

	public void setFatherAddr(String fatherAddr) {
		this.fatherAddr = fatherAddr;
	}

	public String getMotherUnit() {
		return this.motherUnit;
	}

	public void setMotherUnit(String motherUnit) {
		this.motherUnit = motherUnit;
	}

	public String getMotherAddr() {
		return this.motherAddr;
	}

	public void setMotherAddr(String motherAddr) {
		this.motherAddr = motherAddr;
	}

	public String getGbcode() {
		return this.gbcode;
	}

	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
	}

	public String getAddrType() {
		return this.addrType;
	}

	public void setAddrType(String addrType) {
		this.addrType = addrType;
	}

	public String getNationOther() {
		return this.nationOther;
	}

	public void setNationOther(String nationOther) {
		this.nationOther = nationOther;
	}

	public String getPacategory() {
		return this.pacategory;
	}

	public void setPacategory(String pacategory) {
		this.pacategory = pacategory;
	}

	public String getHrcategory() {
		return this.hrcategory;
	}

	public void setHrcategory(String hrcategory) {
		this.hrcategory = hrcategory;
	}

	public String getBirthdateType() {
		return this.birthdateType;
	}

	public void setBirthdateType(String birthdateType) {
		this.birthdateType = birthdateType;
	}

	public String getBirthdateAddr() {
		return this.birthdateAddr;
	}

	public void setBirthdateAddr(String birthdateAddr) {
		this.birthdateAddr = birthdateAddr;
	}

	public String getUnitFlag() {
		return unitFlag;
	}

	public void setUnitFlag(String unitFlag) {
		this.unitFlag = unitFlag;
	}

	/**
	 * @return the occupationFlag
	 */
	public String getOccupationFlag() {
		return occupationFlag;
	}

	/**
	 * @param occupationFlag the occupationFlag to set
	 */
	public void setOccupationFlag(String occupationFlag) {
		this.occupationFlag = occupationFlag;
	}

	/**
	 * @return the addressGbcode
	 */
	public String getAddressGbcode() {
		return addressGbcode;
	}

	/**
	 * @param addressGbcode the addressGbcode to set
	 */
	public void setAddressGbcode(String addressGbcode) {
		this.addressGbcode = addressGbcode;
	}

	public String getLivingConditionsOther() {
		return livingConditionsOther;
	}

	public void setLivingConditionsOther(String livingConditionsOther) {
		this.livingConditionsOther = livingConditionsOther;
	}

    public String getFamilyIncome() {
        return familyIncome;
    }

    public void setFamilyIncome(String familyIncome) {
        this.familyIncome = familyIncome;
    }

    public String getDetain() {
        return detain;
    }

    public void setDetain(String detain) {
        this.detain = detain;
    }

    public String getHeadHouseholdName() {
        return headHouseholdName;
    }

    public void setHeadHouseholdName(String headHouseholdName) {
        this.headHouseholdName = headHouseholdName;
    }

    public String getLaborForce() {
        return laborForce;
    }

    public void setLaborForce(String laborForce) {
        this.laborForce = laborForce;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

	public String getContactName1() {
		return contactName1;
	}

	public void setContactName1(String contactName1) {
		this.contactName1 = contactName1;
	}

	public String getContactPhone1() {
		return contactPhone1;
	}

	public void setContactPhone1(String contactPhone1) {
		this.contactPhone1 = contactPhone1;
	}

	public String getContactName2() {
		return contactName2;
	}

	public void setContactName2(String contactName2) {
		this.contactName2 = contactName2;
	}

	public String getContactPhone2() {
		return contactPhone2;
	}

	public void setContactPhone2(String contactPhone2) {
		this.contactPhone2 = contactPhone2;
	}

	public String getRegisterNum() {
		return registerNum;
	}

	public void setRegisterNum(String registerNum) {
		this.registerNum = registerNum;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getTitleCity() {
		return titleCity;
	}

	public void setTitleCity(String titleCity) {
		this.titleCity = titleCity;
	}

	public String getTitleTown() {
		return titleTown;
	}

	public void setTitleTown(String titleTown) {
		this.titleTown = titleTown;
	}

	public String getTitleUnit() {
		return titleUnit;
	}

	public void setTitleUnit(String titleUnit) {
		this.titleUnit = titleUnit;
	}

    public String getEducationYear() {
        return educationYear;
    }

    public void setEducationYear(String educationYear) {
        this.educationYear = educationYear;
    }

    public String getEpidemic() {
        return epidemic;
    }

    public void setEpidemic(String epidemic) {
        this.epidemic = epidemic;
    }

    public String getHrType() {
        return hrType;
    }

    public void setHrType(String hrType) {
        this.hrType = hrType;
    }

    public String getLoseJob() {
        return loseJob;
    }

    public void setLoseJob(String loseJob) {
        this.loseJob = loseJob;
    }

    public String getLowObject() {
        return lowObject;
    }

    public void setLowObject(String lowObject) {
        this.lowObject = lowObject;
    }

    public String getHiType() {
        return hiType;
    }

    public void setHiType(String hiType) {
        this.hiType = hiType;
    }

	public String getHealthFileNo() {
		return healthFileNo;
	}

	public void setHealthFileNo(String healthFileNo) {
		this.healthFileNo = healthFileNo;
	}

	public String getReprovince() {
		return reprovince;
	}

	public void setReprovince(String reprovince) {
		this.reprovince = reprovince;
	}

	public String getRecity() {
		return recity;
	}

	public void setRecity(String recity) {
		this.recity = recity;
	}

	public String getRecounty() {
		return recounty;
	}

	public void setRecounty(String recounty) {
		this.recounty = recounty;
	}

	public String getRetownShip() {
		return retownShip;
	}

	public void setRetownShip(String retownShip) {
		this.retownShip = retownShip;
	}

	public String getRestreet() {
		return restreet;
	}

	public void setRestreet(String restreet) {
		this.restreet = restreet;
	}

	public String getRehouseNumber() {
		return rehouseNumber;
	}

	public void setRehouseNumber(String rehouseNumber) {
		this.rehouseNumber = rehouseNumber;
	}

	public String getReAddress() {
		return reAddress;
	}

	public void setReAddress(String reAddress) {
		this.reAddress = reAddress;
	}

	public String getHrGroup() {
		return hrGroup;
	}

	public void setHrGroup(String hrGroup) {
		this.hrGroup = hrGroup;
	}

	public String getPaGroup() {
		return paGroup;
	}

	public void setPaGroup(String paGroup) {
		this.paGroup = paGroup;
	}

	public String getReGroup() {
		return reGroup;
	}

	public void setReGroup(String reGroup) {
		this.reGroup = reGroup;
	}
	
}