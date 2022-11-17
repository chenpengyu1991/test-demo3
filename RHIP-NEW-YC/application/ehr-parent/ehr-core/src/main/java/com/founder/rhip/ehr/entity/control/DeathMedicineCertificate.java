package com.founder.rhip.ehr.entity.control;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


/**
 * 死亡医学证明实体
 *
 */
@Entity
@Table(name = "DC_DEATH_MEDICINE_CERTIFICATE")
public class DeathMedicineCertificate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "SMPI_ID", columnDefinition = "VARCHAR2|PIX号||", length = 50, nullable = true)
    private String smpiId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;
       
    @Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号||", length = 17, nullable = true)
	private String healthFileNo;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|PERSON号||", length = 11, nullable = true)
    private Long personId;

    @Column(name = "BIRTH_CERTIFICATE_NO", columnDefinition = "VARCHAR2|死亡医学证明编号||", length = 20, nullable = true)
    private String birthCertificateNo;

    @Column(name = "ADMISSION_NO", columnDefinition = "VARCHAR2|住院号||", length = 10, nullable = true)
    private String admissionNo;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|本人姓名||", length = 50, nullable = true)
    private String name;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别代码（可选项，男，女，不明，不详）||", length = 1, nullable = true)
    private String gender;

    @Column(name = "NATION", columnDefinition = "VARCHAR2|民族||", length = 2, nullable = true)
    private String nation;

    @Column(name = "OTHER_NATION_DESC", columnDefinition = "VARCHAR2|少数名族名称||", length = 50, nullable = true)
    private String otherNationDesc;

    @Column(name = "OCCUPATION", columnDefinition = "VARCHAR2|职业类别代码||", length = 3, nullable = true)
    private String occupation;

    @Column(name = "OCCUPATION_OTHER", columnDefinition = "VARCHAR2|职业其他||", length = 30, nullable = true)
    private String occupationOther;

    @Column(name = "IDCARD_TYPE", columnDefinition = "VARCHAR2|身份证件类别代码||", length = 2, nullable = true)
    private String idcardType;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证件号码||", length = 18, nullable = true)
    private String idcard;

    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况代码||", length = 2, nullable = true)
    private String marriage;

    @Column(name = "EDUCATION", columnDefinition = "VARCHAR2|学历代码||", length = 2, nullable = true)
    private String education;

    @Column(name = "UNIT_NAME", columnDefinition = "VARCHAR2|工作单位名称||", length = 70, nullable = true)
    private String unitName;

    @Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
    private Date birthday;

    @Column(name = "DEATH_DATE", columnDefinition = "TIMESTAMP|死亡日期时间||", nullable = true)
    private Date deathDate;

    @Column(name = "AGE", columnDefinition = "VARCHAR2|实足年龄||", length = 5, nullable = true)
    private String age;

    @Column(name = "AREA_CODE", columnDefinition = "VARCHAR2|行政区划代码||", length = 6, nullable = true)
    private String areaCode;

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
    
    @Column(name = "PA_GROUP", columnDefinition = "VARCHAR2|现住地址-组||", length = 70, nullable = true)
    private String paGroup;

    @Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|现住地址-门牌号码||", length = 70, nullable = true)
    private String pahouseNumber;

    @Column(name = "CONTACT_NAME", columnDefinition = "VARCHAR2|联系人姓名||", length = 50, nullable = true)
    private String contactName;

    @Column(name = "FAMILY_PHONE", columnDefinition = "VARCHAR2|家人电话号码||", length = 20, nullable = true)
    private String familyPhone;

    @Column(name = "UNIT_PHONE", columnDefinition = "VARCHAR2|工作单位电话号码||", length = 20, nullable = true)
    private String unitPhone;

    @Column(name = "DIRECT_DEATH_CAUSE_A", columnDefinition = "VARCHAR2|直接死亡原因a代码||", length = 5, nullable = true)
    private String directDeathCauseA;

	@Column(name = "ONSET_DEATH_RUN_TIME_A", columnDefinition = "VARCHAR2|发病到死亡的时长a||", length = 10, nullable = true)
    private String onsetDeathRunTimeA;

    @Column(name = "DIRECT_DEATH_CAUSE_B", columnDefinition = "VARCHAR2|直接死亡原因b代码||", length = 5, nullable = true)
    private String directDeathCauseB;

    @Column(name = "ONSET_DEATH_RUN_TIME_B", columnDefinition = "VARCHAR2|发病到死亡的时长b||", length = 10, nullable = true)
    private String onsetDeathRunTimeB;

    @Column(name = "DIRECT_DEATH_CAUSE_C", columnDefinition = "VARCHAR2|直接死亡原因c代码||", length = 5, nullable = true)
    private String directDeathCauseC;

    @Column(name = "ONSET_DEATH_RUN_TIME_C", columnDefinition = "VARCHAR2|发病到死亡的时长c||", length = 10, nullable = true)
    private String onsetDeathRunTimeC;

    @Column(name = "DIRECT_DEATH_CAUSE_D", columnDefinition = "VARCHAR2|直接死亡原因d代码||", length = 5, nullable = true)
    private String directDeathCauseD;

    @Column(name = "ONSET_DEATH_RUN_TIME_D", columnDefinition = "VARCHAR2|发病到死亡的时长d||", length = 10, nullable = true)
    private String onsetDeathRunTimeD;

    @Column(name = "OTHER_DISEASE_EVIDENCE1", columnDefinition = "VARCHAR2|其他疾病诊断1||", length = 5, nullable = true)
    private String otherDiseaseEvidence1;

    @Column(name = "OTHER_DISEASE_EVIDENCE2", columnDefinition = "VARCHAR2|其他疾病诊断2||", length = 5, nullable = true)
    private String otherDiseaseEvidence2;

    @Column(name = "OTHER_DISEASE_EVIDENCE3", columnDefinition = "VARCHAR2|其他疾病诊断3||", length = 5, nullable = true)
    private String otherDiseaseEvidence3;

    @Column(name = "UNDERLYING_DEATH_CODE", columnDefinition = "VARCHAR2|根本死因代码||", length = 5, nullable = true)
    private String underlyingDeathCode;

    @Column(name = "DEATH_HIGH_ORGAN_LEVEL", columnDefinition = "VARCHAR2|主要致死疾病的最高诊断机构级别代码||", length = 2, nullable = true)
    private String deathHighOrganLevel;

    @Column(name = "DEATH_HOSPITAL_NAME", columnDefinition = "VARCHAR2|死亡医院名称||", length = 70, nullable = true)
    private String deathHospitalName;

    @Column(name = "DEATH_PLACE_TYPE", columnDefinition = "VARCHAR2|死亡地点类别代码||", length = 2, nullable = true)
    private String deathPlaceType;

    @Column(name = "DEATH_HIGH_EVIDENCE_TYPE_CODE", columnDefinition = "VARCHAR2|死亡最高诊断依据类别代码||", length = 1, nullable = true)
    private String deathHighEvidenceTypeCode;

    @Column(name = "DEATH_CHAIN_SEQ_CODE", columnDefinition = "VARCHAR2|死因链-顺序代码||", length = 1, nullable = true)
    private String deathChainSeqCode;

    @Column(name = "DEATH_CHAIN_DISEASE_CODE", columnDefinition = "VARCHAR2|死因链-疾病代码||", length = 7, nullable = true)
    private String deathChainDiseaseCode;

    @Column(name = "INTERVAL_RUNTIME", columnDefinition = "NUMBER|时间间隔-时长||", length = 3, nullable = true)
    private Integer intervalRuntime;

    @Column(name = "INTERVAL_UNIT_CODE", columnDefinition = "VARCHAR2|时间间隔-单位代码||", length = 1, nullable = true)
    private String intervalUnitCode;

    @Column(name = "FILL_USER_NAME", columnDefinition = "VARCHAR2|填报姓名||", length = 50, nullable = true) 
    private String fillUserName;
    
	@Column(name = "FILL_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构代号||", length = 20, nullable = true) 
    private String fillOrganCode;
    
	@Column(name = "FILL_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 70, nullable = true) 
    private String fillOrganName;

    @Column(name = "FILL_TIME", columnDefinition = "TIMESTAMP|填报日期时间||", nullable = true)
    private Date fillTime;
    // 此处的值代表的意思为是否补卡，若为1，则选中了补卡(补卡是怎么回事儿呢，暂不清楚)
    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete=0;
	
    /************all under the field added by Kevin Ro **************/
	@Column(name = "REPORT_NO", columnDefinition = "VARCHAR2|| 编号", length = 20, nullable = true)
	private String reportNo;
	
	@Column(name = "UPDATE_TIME", columnDefinition = "TIMESTAMP|修改时间||", nullable = true)
    private Date updateTime;
	
	@Column(name = "FATHOR_NAME", columnDefinition = "VARCHAR2|| 父亲姓名", length = 20, nullable = true)
	private String fathorName;
	
	@Column(name = "MOTHOR_NAME", columnDefinition = "VARCHAR2|| 母亲姓名", length = 20, nullable = true)
	private String mothorName;
	
	@Column(name = "CENSUS_REGISTER", columnDefinition = "VARCHAR2|| 户籍（可选项）", length = 5, nullable = true)
	private String censusRegister;
	
	@Column(name = "DIRECT_CONDITION", columnDefinition = "VARCHAR2|| 直接导致死亡的疾病或情况", length = 20, nullable = true)
	private String directCondition;
	
	@Column(name = "CONDITION_A", columnDefinition = "VARCHAR2|| 引起(a)的疾病或情况", length = 20, nullable = true)
	private String conditionA;
	
	@Column(name = "CONDITION_B", columnDefinition = "VARCHAR2|| 引起(b)的疾病或情况", length = 20, nullable = true)
	private String conditionB;
	
	@Column(name = "CONDITION_C", columnDefinition = "VARCHAR2|| 引起(c)的疾病或情况", length = 25, nullable = true)
	private String conditionC;
	
	@Column(name = "DEATH_REASON", columnDefinition = "VARCHAR2|| 根本死因", length = 20, nullable = true)
	private String deathReason;
	
	@Column(name = "CATEGORY_NO", columnDefinition = "VARCHAR2|| 分类编号（可选项，选中之后将value填写到输入框中）", length = 5, nullable = true)
	private String categoryNo;
	
	@Column(name = "ICD10_CODE", columnDefinition = "VARCHAR2|| ICD10编码", length = 10, nullable = true)
	private String icd10Code;
	
	@Column(name = "DEATH_SITE", columnDefinition = "VARCHAR2|| 死亡地点（可选项）", length = 5, nullable = true)
	private String deathSite;
	
	@Column(name = "DEATH_SITE_OTHER_MARK", columnDefinition = "VARCHAR2|| 死亡地点(其他选项)备注", length = 20, nullable = true)
	private String deathSiteOtherMark;
	
	@Column(name = "BORN_WEIGHT", columnDefinition = "VARCHAR2|| 出身体重", length = 5, nullable = true)
	private String bornWeight;
	
	@Column(name = "BORN_WEIGHT_SELECT", columnDefinition = "VARCHAR2|| 出身体重(选择的是测量还是估计)", length = 5, nullable = true)
	private String bornWeightSelect;
	
	@Column(name = "PREGNANT_WEEK", columnDefinition = "VARCHAR2|| 孕周（怀孕多少周）", length = 5, nullable = true)
	private String pregnantWeek;
	
	@Column(name = "DEATH_BEFORE_TREAT", columnDefinition = "VARCHAR2|| 死前治疗(可选项)", length = 5, nullable = true)
	private String deathBeforeTreat;
	
	@Column(name = "DIAGNOSIS_LEVEL", columnDefinition = "VARCHAR2|| 诊断级别(可选项)", length = 5, nullable = true)
	private String diagnosisLevel;
	
	@Column(name = "BORN_SITE", columnDefinition = "VARCHAR2|| 出生地点(可选项)", length = 5, nullable = true)
	private String bornSite;
	
	@Column(name = "NO_TREAT_REASON", columnDefinition = "VARCHAR2|| 未治疗或未就医主要原因(可选项，单选)", length = 5, nullable = true)
	private String noTreatReason;
	
	@Column(name = "NO_TREAT_REASON_OTHER", columnDefinition = "VARCHAR2|| 未治疗或未就医主要原因(其他输入)", length = 20, nullable = true)
	private String noTreatReasonOther;
	
	@Column(name = "DEATH_REASON_BASIS", columnDefinition = "VARCHAR2|| 死因诊断依据(可选项，单选)", length = 5, nullable = true)
	private String deathReasonBasis;
	
	@Column(name = "AGE_SUI", columnDefinition = "VARCHAR2|| 年龄岁", length = 5, nullable = true)
	private String ageSui;
	
	@Column(name = "AGE_MONTH", columnDefinition = "VARCHAR2|| 年龄月", length = 5, nullable = true)
	private String ageMonth;
	
	@Column(name = "AGE_DAY", columnDefinition = "VARCHAR2|| 年龄天", length = 5, nullable = true)
	private String ageDay;
	
	@Column(name = "AGE_HOUR", columnDefinition = "VARCHAR2|| 年龄时", length = 5, nullable = true)
	private String ageHour;
	
	@Column(name = "AGE_SECOND", columnDefinition = "VARCHAR2|| 年龄分", length = 5, nullable = true)
	private String ageSecond;
	
	@Column(name = "is_add", columnDefinition = "VARCHAR2|| 是否选择了补卡", length = 2, nullable = true)
	private String isAdd;
	
	@Column(name = "HOUSEHOLD_TYPE", columnDefinition = "VARCHAR2|户籍类型||", length = 20, nullable = true)
	private String householdType;
	
	@Column(name = "REMARKS", columnDefinition = "VARCHAR2|备注||", length = 20, nullable = true)
	private String remarks;


    @Column(name = "FILING_FLAG", columnDefinition = "VARCHAR2|建档状态||", length = 1, nullable = true)
	private String filingFlag; // 0：未建档 1：已建档，3 已退回 9已注销 4无身份证 5待审核
	
    @Column(name = "SURVEY_TIME", columnDefinition = "TIMESTAMP|调查日期时间||", nullable = true)
    private Date surveyTime;
    
    
    @Column(name = "RELATION", columnDefinition = "VARCHAR2|联系人姓名||", length = 50, nullable = true)
    private String relation;
    
    @Column(name = "CONTACT_UNIT_NAME", columnDefinition = "VARCHAR2|联系地址或者工作单位||", length = 50, nullable = true)
    private String contactUnitName;
    
    @Column(name = "DISEASE_HISTORY", columnDefinition = "VARCHAR2|调查记录生前疾病史及症状体征||", length = 5, nullable = true)
    private String diseaseHistory;
    
    @Column(name = "DOCTOR_NAME", columnDefinition = "VARCHAR2|医师姓名||", length = 50, nullable = true) 
    private String doctorName;
    
    @Column(name = "INPUTER_ID", columnDefinition = "VARCHAR2|建档人员ID||", length = 50, nullable = true)
	private String inputerId;

	@Column(name = "INPUT_NAME", columnDefinition = "VARCHAR2|建档人||", length = 30, nullable = true)
	private String inputName;
	
	@Column(name = "INPUT_DATE", columnDefinition = "DATE|建档日期||", nullable = true)
	private Date inputDate;
	
    @Column(name = "PERSON_TYPE", columnDefinition = "VARCHAR2|群人分类：【1：5岁以下，2孕产妇，3其他】", nullable = true)
    private String personType;
    
    @Column(name = "DEATH_CERTIFICATE_NO", columnDefinition = "VARCHAR2|死亡医学证明编号||", length = 20, nullable = true)
    private String deathCertificateNo;
    
	@Column(name = "GUARDIAN", columnDefinition = "VARCHAR2|家属姓名||", length = 50, nullable = true)
	private String guardian;
	
	@Column(name = "GUARDIAN_UNIT_NAME", columnDefinition = "VARCHAR2|家属工作单位||", length = 50, nullable = true)
	private String guardianUnitName;
	
	@Column(name = "DEATH_REASON_DEDUCTION", columnDefinition = "VARCHAR2|| 死因推断", length = 20, nullable = true)
	private String deathReasonDeduction;
	
    @Column(name = "CANCEL_STATUS", columnDefinition = "VARCHAR2|注销状态", nullable = true)
    private String cancelStatus;
    
    @Column(name = "PREGNANCY_STATUS", columnDefinition = "VARCHAR2||死亡时是否处于妊娠期或妊娠终止后42天内||", nullable = true)
    private String pregnancyStatus;
    
    @Column(name = "DEATH_REASON_BASIS_STR", columnDefinition = "VARCHAR2||根本死亡原因", length = 5, nullable = true)
	private String deathReasonBasisStr;
    
    @Column(name = "INTERVAL_TIME", columnDefinition = "NUMBER|时间间隔||", length = 3, nullable = true)
    private String intervaltime;
    
    
    
    public String getIntervaltime() {
		return intervaltime;
	}

	public void setIntervaltime(String intervaltime) {
		this.intervaltime = intervaltime;
	}

	public String getPaGroup() {
  		return paGroup;
  	}

  	public void setPaGroup(String paGroup) {
  		this.paGroup = paGroup;
  	}
    
    
    public String getCancelStatus() {
		return cancelStatus;
	}

	public String getPregnancyStatus() {
		return pregnancyStatus;
	}

	public void setPregnancyStatus(String pregnancyStatus) {
		this.pregnancyStatus = pregnancyStatus;
	}

	public void setCancelStatus(String cancelStatus) {
		this.cancelStatus = cancelStatus;
	}

	public String getDeathReasonDeduction() {
		return deathReasonDeduction;
	}

	public void setDeathReasonDeduction(String deathReasonDeduction) {
		this.deathReasonDeduction = deathReasonDeduction;
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

	public String getPersonType() {
		return personType;
	}

	public String getDeathCertificateNo() {
		return deathCertificateNo;
	}

	public void setDeathCertificateNo(String deathCertificateNo) {
		this.deathCertificateNo = deathCertificateNo;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
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

	public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getBirthCertificateNo() {
        return this.birthCertificateNo;
    }

    public void setBirthCertificateNo(String birthCertificateNo) {
        this.birthCertificateNo = birthCertificateNo;
    }

    public String getAdmissionNo() {
        return this.admissionNo;
    }

    public void setAdmissionNo(String admissionNo) {
        this.admissionNo = admissionNo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getOccupation() {
        return this.occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
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

    public String getMarriage() {
        return this.marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getEducation() {
        return this.education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getUnitName() {
        return this.unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getDeathDate() {
        return this.deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAreaCode() {
        return this.areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
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

    public String getContactName() {
        return this.contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getFamilyPhone() {
        return this.familyPhone;
    }

    public void setFamilyPhone(String familyPhone) {
        this.familyPhone = familyPhone;
    }

    public String getUnitPhone() {
        return this.unitPhone;
    }

    public void setUnitPhone(String unitPhone) {
        this.unitPhone = unitPhone;
    }

    public String getDirectDeathCauseA() {
        return this.directDeathCauseA;
    }

    public void setDirectDeathCauseA(String directDeathCauseA) {
        this.directDeathCauseA = directDeathCauseA;
    }

    public String getOnsetDeathRunTimeA() {
        return this.onsetDeathRunTimeA;
    }

    public void setOnsetDeathRunTimeA(String onsetDeathRunTimeA) {
        this.onsetDeathRunTimeA = onsetDeathRunTimeA;
    }

    public String getDirectDeathCauseB() {
        return this.directDeathCauseB;
    }

    public void setDirectDeathCauseB(String directDeathCauseB) {
        this.directDeathCauseB = directDeathCauseB;
    }

    public String getOnsetDeathRunTimeB() {
        return this.onsetDeathRunTimeB;
    }

    public void setOnsetDeathRunTimeB(String onsetDeathRunTimeB) {
        this.onsetDeathRunTimeB = onsetDeathRunTimeB;
    }

    public String getDirectDeathCauseC() {
        return this.directDeathCauseC;
    }

    public void setDirectDeathCauseC(String directDeathCauseC) {
        this.directDeathCauseC = directDeathCauseC;
    }

    public String getOnsetDeathRunTimeC() {
        return this.onsetDeathRunTimeC;
    }

    public void setOnsetDeathRunTimeC(String onsetDeathRunTimeC) {
        this.onsetDeathRunTimeC = onsetDeathRunTimeC;
    }

    public String getDirectDeathCauseD() {
        return this.directDeathCauseD;
    }

    public void setDirectDeathCauseD(String directDeathCauseD) {
        this.directDeathCauseD = directDeathCauseD;
    }

    public String getOnsetDeathRunTimeD() {
        return this.onsetDeathRunTimeD;
    }

    public void setOnsetDeathRunTimeD(String onsetDeathRunTimeD) {
        this.onsetDeathRunTimeD = onsetDeathRunTimeD;
    }

    public String getOtherDiseaseEvidence1() {
        return this.otherDiseaseEvidence1;
    }

    public void setOtherDiseaseEvidence1(String otherDiseaseEvidence1) {
        this.otherDiseaseEvidence1 = otherDiseaseEvidence1;
    }

    public String getOtherDiseaseEvidence2() {
        return this.otherDiseaseEvidence2;
    }

    public void setOtherDiseaseEvidence2(String otherDiseaseEvidence2) {
        this.otherDiseaseEvidence2 = otherDiseaseEvidence2;
    }

    public String getOtherDiseaseEvidence3() {
        return this.otherDiseaseEvidence3;
    }

    public void setOtherDiseaseEvidence3(String otherDiseaseEvidence3) {
        this.otherDiseaseEvidence3 = otherDiseaseEvidence3;
    }

    public String getUnderlyingDeathCode() {
        return this.underlyingDeathCode;
    }

    public void setUnderlyingDeathCode(String underlyingDeathCode) {
        this.underlyingDeathCode = underlyingDeathCode;
    }

    public String getDeathHighOrganLevel() {
        return this.deathHighOrganLevel;
    }

    public void setDeathHighOrganLevel(String deathHighOrganLevel) {
        this.deathHighOrganLevel = deathHighOrganLevel;
    }

    public String getDeathHospitalName() {
        return this.deathHospitalName;
    }

    public void setDeathHospitalName(String deathHospitalName) {
        this.deathHospitalName = deathHospitalName;
    }

    public String getDeathPlaceType() {
        return this.deathPlaceType;
    }

    public void setDeathPlaceType(String deathPlaceType) {
        this.deathPlaceType = deathPlaceType;
    }

    public String getDeathHighEvidenceTypeCode() {
        return this.deathHighEvidenceTypeCode;
    }

    public void setDeathHighEvidenceTypeCode(String deathHighEvidenceTypeCode) {
        this.deathHighEvidenceTypeCode = deathHighEvidenceTypeCode;
    }

    public String getDeathChainSeqCode() {
        return this.deathChainSeqCode;
    }

    public void setDeathChainSeqCode(String deathChainSeqCode) {
        this.deathChainSeqCode = deathChainSeqCode;
    }

    public String getDeathChainDiseaseCode() {
        return this.deathChainDiseaseCode;
    }

    public void setDeathChainDiseaseCode(String deathChainDiseaseCode) {
        this.deathChainDiseaseCode = deathChainDiseaseCode;
    }

    public Integer getIntervalRuntime() {
        return this.intervalRuntime;
    }

    public void setIntervalRuntime(Integer intervalRuntime) {
        this.intervalRuntime = intervalRuntime;
    }

    public String getIntervalUnitCode() {
        return this.intervalUnitCode;
    }

    public void setIntervalUnitCode(String intervalUnitCode) {
        this.intervalUnitCode = intervalUnitCode;
    }

    public String getFillUserName() {
        return this.fillUserName;
    }

    public void setFillUserName(String fillUserName) {
        this.fillUserName = fillUserName;
    }

    public String getFillOrganName() {
        return this.fillOrganName;
    }

    public void setFillOrganName(String fillOrganName) {
        this.fillOrganName = fillOrganName;
    }

    public Date getFillTime() {
        return this.fillTime;
    }

    public void setFillTime(Date fillTime) {
        this.fillTime = fillTime;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getSmpiId() {
        return smpiId;
    }

    public void setSmpiId(String smpiId) {
        this.smpiId = smpiId;
    }

	public String getReportNo() {
		return reportNo;
	}

	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}

	public String getFathorName() {
		return fathorName;
	}

	public void setFathorName(String fathorName) {
		this.fathorName = fathorName;
	}

	public String getMothorName() {
		return mothorName;
	}

	public void setMothorName(String mothorName) {
		this.mothorName = mothorName;
	}

	public String getCensusRegister() {
		return censusRegister;
	}

	public void setCensusRegister(String censusRegister) {
		this.censusRegister = censusRegister;
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

	public String getDeathReason() {
		return deathReason;
	}

	public void setDeathReason(String deathReason) {
		this.deathReason = deathReason;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getIcd10Code() {
		return icd10Code;
	}

	public void setIcd10Code(String icd10Code) {
		this.icd10Code = icd10Code;
	}

	public String getDeathSite() {
		return deathSite;
	}

	public void setDeathSite(String deathSite) {
		this.deathSite = deathSite;
	}

	public String getDeathSiteOtherMark() {
		return deathSiteOtherMark;
	}

	public void setDeathSiteOtherMark(String deathSiteOtherMark) {
		this.deathSiteOtherMark = deathSiteOtherMark;
	}

	public String getBornWeight() {
		return bornWeight;
	}

	public void setBornWeight(String bornWeight) {
		this.bornWeight = bornWeight;
	}

	public String getBornWeightSelect() {
		return bornWeightSelect;
	}

	public void setBornWeightSelect(String bornWeightSelect) {
		this.bornWeightSelect = bornWeightSelect;
	}

	public String getPregnantWeek() {
		return pregnantWeek;
	}

	public void setPregnantWeek(String pregnantWeek) {
		this.pregnantWeek = pregnantWeek;
	}

	public String getDeathBeforeTreat() {
		return deathBeforeTreat;
	}

	public void setDeathBeforeTreat(String deathBeforeTreat) {
		this.deathBeforeTreat = deathBeforeTreat;
	}

	public String getDiagnosisLevel() {
		return diagnosisLevel;
	}

	public void setDiagnosisLevel(String diagnosisLevel) {
		this.diagnosisLevel = diagnosisLevel;
	}

	public String getBornSite() {
		return bornSite;
	}

	public void setBornSite(String bornSite) {
		this.bornSite = bornSite;
	}

	public String getNoTreatReason() {
		return noTreatReason;
	}

	public void setNoTreatReason(String noTreatReason) {
		this.noTreatReason = noTreatReason;
	}

	public String getDeathReasonBasis() {
		return deathReasonBasis;
	}

	public void setDeathReasonBasis(String deathReasonBasis) {
		this.deathReasonBasis = deathReasonBasis;
	}

	public String getAgeSui() {
		return ageSui;
	}

	public void setAgeSui(String ageSui) {
		this.ageSui = ageSui;
	}

	public String getAgeMonth() {
		return ageMonth;
	}

	public void setAgeMonth(String ageMonth) {
		this.ageMonth = ageMonth;
	}

	public String getAgeDay() {
		return ageDay;
	}

	public void setAgeDay(String ageDay) {
		this.ageDay = ageDay;
	}

	public String getAgeHour() {
		return ageHour;
	}

	public void setAgeHour(String ageHour) {
		this.ageHour = ageHour;
	}

	public String getAgeSecond() {
		return ageSecond;
	}

	public void setAgeSecond(String ageSecond) {
		this.ageSecond = ageSecond;
	}

	public String getNoTreatReasonOther() {
		return noTreatReasonOther;
	}

	public void setNoTreatReasonOther(String noTreatReasonOther) {
		this.noTreatReasonOther = noTreatReasonOther;
	}

    public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getIsAdd() {
		return isAdd;
	}

	public void setIsAdd(String isAdd) {
		this.isAdd = isAdd;
	}

	public String getFillOrganCode() {
		return fillOrganCode;
	}

	public void setFillOrganCode(String fillOrganCode) {
		this.fillOrganCode = fillOrganCode;
	}

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

	public String getHealthFileNo() {
		return healthFileNo;
	}

	public void setHealthFileNo(String healthFileNo) {
		this.healthFileNo = healthFileNo;
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

	public String getFilingFlag() {
		return filingFlag;
	}

	public void setFilingFlag(String filingFlag) {
		this.filingFlag = filingFlag;
	}

	public Date getSurveyTime() {
		return surveyTime;
	}

	public void setSurveyTime(Date surveyTime) {
		this.surveyTime = surveyTime;
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

	public String getDiseaseHistory() {
		return diseaseHistory;
	}

	public void setDiseaseHistory(String diseaseHistory) {
		this.diseaseHistory = diseaseHistory;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDeathReasonBasisStr() {
		return deathReasonBasisStr;
	}

	public void setDeathReasonBasisStr(String deathReasonBasisStr) {
		this.deathReasonBasisStr = deathReasonBasisStr;
	}

    public String getOtherNationDesc() {
        return otherNationDesc;
    }

    public void setOtherNationDesc(String otherNationDesc) {
        this.otherNationDesc = otherNationDesc;
    }

    public String getOccupationOther() {
        return occupationOther;
    }

    public void setOccupationOther(String occupationOther) {
        this.occupationOther = occupationOther;
    }
}
