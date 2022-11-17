package com.founder.rhip.ehr.entity.women;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.founder.rhip.ehr.common.JaxbDateSerializer;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "WH_BIRTH_DEFECT_MONITOR")
@XmlRootElement(name = "birthDefectMonitor")
public class BirthDefectMonitor implements Serializable {

	private static final long serialVersionUID = -5982696127261773236L;

	@Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = false)
    private String ehrId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;
    
    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;

    @Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|记录表单编号||", length = 20, nullable = true)
    private String recordNumber;

    @Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号||", length = 17, nullable = true)
    private String healthFileNo;

    @Column(name = "ADMISSION_NO", columnDefinition = "VARCHAR2|住院号||", length = 10, nullable = true)
    private String admissionNo;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 30, nullable = true)
    private String name;
    
    @Column(name = "ID_CARD", columnDefinition = "VARCHAR2|身份证件号码||", length = 18, nullable = true)
    private String idCard;

    @Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
    private Date birthday;

    @Column(name = "NATION", columnDefinition = "VARCHAR2|民族||", length = 2, nullable = true)
    private String nation;

    @Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|本人电话号码||", length = 20, nullable = true)
    private String phoneNumber;

    @Column(name = "EDUCATION", columnDefinition = "VARCHAR2|文化程度代码||", length = 2, nullable = true)
    private String education;

    @Column(name = "FAMILY_PER_CAPITA_INCOME_TYPE", columnDefinition = "VARCHAR2|家庭年人均收入类别代码||", length = 1, nullable = true)
    private String familyPerCapitaIncomeType;

    @Column(name = "AREA_CODE", columnDefinition = "VARCHAR2|行政区划代码||", length = 6, nullable = true)
    private String areaCode;

    @Column(name = "HRSTREET", columnDefinition = "VARCHAR2|户籍地址-村(街、路、弄等)||", length = 70, nullable = true)
    private String hrstreet;

    @Column(name = "HRHOUSE_NUMBER", columnDefinition = "VARCHAR2|户籍地址-门牌号码||", length = 70, nullable = true)
    private String hrhouseNumber;

    @Column(name = "HRPROVINCE", columnDefinition = "VARCHAR2|户籍地址-省(自治区、直辖市)||", length = 70, nullable = true)
    private String hrprovince;

    @Column(name = "HRCITY", columnDefinition = "VARCHAR2|户籍地址-市(地区、州)||", length = 70, nullable = true)
    private String hrcity;

    @Column(name = "HRCOUNTY", columnDefinition = "VARCHAR2|户籍地址-县(区)||", length = 70, nullable = true)
    private String hrcounty;

    @Column(name = "HRTOWN_SHIP", columnDefinition = "VARCHAR2|户籍地址-乡(镇、街道办事处)||", length = 70, nullable = true)
    private String hrtownShip;

    @Column(name = "HRPOST_CODE", columnDefinition = "VARCHAR2|户籍地址邮政编码||", length = 6, nullable = true)
    private String hrpostCode;

    @Column(name = "PASTREET", columnDefinition = "VARCHAR2|现住址-村(街、路、弄等)||", length = 70, nullable = true)
    private String pastreet;

    @Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|现住址-门牌号码||", length = 70, nullable = true)
    private String pahouseNumber;

    @Column(name = "PAPROVINCE", columnDefinition = "VARCHAR2|现住址-省(自治区、直辖市)||", length = 70, nullable = true)
    private String paprovince;

    @Column(name = "PACITY", columnDefinition = "VARCHAR2|现住址-市(地区、州)||", length = 70, nullable = true)
    private String pacity;

    @Column(name = "PACOUNTY", columnDefinition = "VARCHAR2|现住址-县(区)||", length = 70, nullable = true)
    private String pacounty;

    @Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|现住址-乡(镇、街道办事处)||", length = 70, nullable = true)
    private String patownShip;

    @Column(name = "PAPOST_CODE", columnDefinition = "VARCHAR2|现住址邮政编码||", length = 6, nullable = true)
    private String papostCode;

    @Column(name = "FAMILY_GENE_DISEASE_HISTORY", columnDefinition = "VARCHAR2|家族遗传性疾病史||", length = 100, nullable = true)
    private String familyGeneDiseaseHistory;

    @Column(name = "FAMILY_KIN_MARRIAGE_FLAG", columnDefinition = "CHAR|家族近亲婚配标志||", length = 1, nullable = true)
    private String familyKinMarriageFlag;

    @Column(name = "FAMILY_KIN_MARRIAGE_RELATION", columnDefinition = "VARCHAR2|家族近亲婚配者与本人关系代码||", length = 1, nullable = true)
    private String familyKinMarriageRelation;

    @Column(name = "NEONATAL_GENDER", columnDefinition = "VARCHAR2|新生儿性别代码||", length = 1, nullable = true)
    private String neonatalGender;

    @Column(name = "GESTATIONAL_AGE", columnDefinition = "NUMBER|胎龄||", length = 5, nullable = true)
    private Integer gestationalAge;

    @Column(name = "DELIVERY_DATE", columnDefinition = "TIMESTAMP|分娩日期时间||", nullable = true)
    private Date deliveryDate;

    @Column(name = "BIRTH_WEIGHT", columnDefinition = "NUMBER|出生体重(g)||", length = 5, nullable = true)
    private Integer birthWeight;

    @Column(name = "GESTATIONAL_NUMBER", columnDefinition = "NUMBER|胎数||", length = 5, nullable = true)
    private Integer gestationalNumber;

    @Column(name = "MULTIPLE_BIRTHS_TYPE", columnDefinition = "VARCHAR2|多胎类型代码||", length = 1, nullable = true)
    private String multipleBirthsType;

    @Column(name = "BIRTH_DEFECT", columnDefinition = "VARCHAR2|出生缺陷儿结局代码||", length = 1, nullable = true)
    private String birthDefect;

    @Column(name = "THERAPEUTIC_ABORTION_FLAG", columnDefinition = "CHAR|治疗性引产标志||", length = 1, nullable = true)
    private String therapeuticAbortionFlag;

    @Column(name = "DIAGNOSIS_BASIS_TYPE", columnDefinition = "VARCHAR2|出生缺陷诊断依据类别代码||", length = 1, nullable = true)
    private String diagnosisBasisType;

    @Column(name = "DEFINITE_TIME_TYPE", columnDefinition = "VARCHAR2|出生缺陷确诊时间类别代码||", length = 1, nullable = true)
    private String definiteTimeType;

    @Column(name = "BIRTH_DEFECT_TYPE", columnDefinition = "VARCHAR2|出生缺陷类别代码||", length = 2, nullable = true)
    private String birthDefectType;

    @Column(name = "TRIMESTER_ILLNESS_FLAG", columnDefinition = "CHAR|孕早期患病-标志||", length = 1, nullable = true)
    private String trimesterIllnessFlag;

    @Column(name = "TRIMESTER_ILLNESS_STATE", columnDefinition = "VARCHAR2|孕早期患病-情况||", length = 50, nullable = true)
    private String trimesterIllnessState;

    @Column(name = "TRIMESTER_MEDICATION_TYPE", columnDefinition = "VARCHAR2|孕早期服药类别代码||", length = 1, nullable = true)
    private String trimesterMedicationType;

    @Column(name = "DRUG_NAME", columnDefinition = "VARCHAR2|药物名称||", length = 50, nullable = true)
    private String drugName;

    @Column(name = "TRIMESTER_HARM_FACTOR_TYPE", columnDefinition = "VARCHAR2|孕早期接触有害因素-类别代码||", length = 1, nullable = true)
    private String trimesterHarmFactorType;

    @Column(name = "TRIMESTER_HARM_FACTOR_STATE", columnDefinition = "VARCHAR2|孕早期接触有害因素-情况||", length = 50, nullable = true)
    private String trimesterHarmFactorState;

    @Column(name = "FILL_DATE", columnDefinition = "DATE|填报日期||", nullable = true)
    private Date fillDate;

    @Column(name = "FILL_USER_NAME", columnDefinition = "VARCHAR2|填报人姓名||", length = 30, nullable = true)
    private String fillUserName;

    @Column(name = "FILL_TITLE_CODE", columnDefinition = "VARCHAR2|填报人职称代码||", length = 2, nullable = true)
    private String fillTitleCode;

    @Column(name = "FILL_UNIT_NAME", columnDefinition = "VARCHAR2|填报单位名称||", length = 70, nullable = true)
    private String fillUnitName;

    @Column(name = "HOSPITAL_TRIAL_TABLE_DATE", columnDefinition = "DATE|医院审表日期||", nullable = true)
    private Date hospitalTrialTableDate;

    @Column(name = "HOSPITAL_TRIAL_TABLE_NAME", columnDefinition = "VARCHAR2|医院审表人姓名||", length = 30, nullable = true)
    private String hospitalTrialTableName;

    @Column(name = "HOSPITAL_TRIAL_TABLE_TITLE", columnDefinition = "VARCHAR2|医院审表人职称代码||", length = 2, nullable = true)
    private String hospitalTrialTableTitle;

    @Column(name = "PROVINCIAL_TRIAL_TABLE_DATE", columnDefinition = "DATE|省级审表日期||", nullable = true)
    private Date provincialTrialTableDate;

    @Column(name = "PROVINCIAL_TRIAL_TABLE_NAME", columnDefinition = "VARCHAR2|省级审表人姓名||", length = 30, nullable = true)
    private String provincialTrialTableName;

    @Column(name = "PROVINCIAL_TRIAL_TABLE_TITLE", columnDefinition = "VARCHAR2|省级审表人职称代码||", length = 2, nullable = true)
    private String provincialTrialTableTitle;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

  	@Column(name = "MOTHER_IDCARD", columnDefinition = "VARCHAR2|母亲身份证件-号码||", length = 18, nullable = true)
	private String motherIdcard;
	
	@Column(name = "BABY_CARD_NO", columnDefinition = "VARCHAR2|宝宝卡号||", length = 13, nullable = true)
	private String babyCardNo;
	
	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构代码||", length = 20, nullable = true)
	private String createOrganCode;
	
	@Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 70, nullable = true)
	private String createOrganName;
    
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @XmlElement
    public String getRecordNumber() {
        return this.recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    @XmlElement
    public String getHealthFileNo() {
        return this.healthFileNo;
    }

    public void setHealthFileNo(String healthFileNo) {
        this.healthFileNo = healthFileNo;
    }

    @XmlElement
    public String getAdmissionNo() {
        return this.admissionNo;
    }

    public void setAdmissionNo(String admissionNo) {
        this.admissionNo = admissionNo;
    }

    @XmlElement
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @XmlElement
    public String getNation() {
        return this.nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @XmlElement
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @XmlElement
    public String getEducation() {
        return this.education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @XmlElement
    public String getFamilyPerCapitaIncomeType() {
        return this.familyPerCapitaIncomeType;
    }

    public void setFamilyPerCapitaIncomeType(String familyPerCapitaIncomeType) {
        this.familyPerCapitaIncomeType = familyPerCapitaIncomeType;
    }

    @XmlElement
    public String getAreaCode() {
        return this.areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @XmlElement
    public String getHrstreet() {
        return this.hrstreet;
    }

    public void setHrstreet(String hrstreet) {
        this.hrstreet = hrstreet;
    }

    @XmlElement
    public String getHrhouseNumber() {
        return this.hrhouseNumber;
    }

    public void setHrhouseNumber(String hrhouseNumber) {
        this.hrhouseNumber = hrhouseNumber;
    }

    @XmlElement
    public String getHrprovince() {
        return this.hrprovince;
    }

    public void setHrprovince(String hrprovince) {
        this.hrprovince = hrprovince;
    }

    @XmlElement
    public String getHrcity() {
        return this.hrcity;
    }

    public void setHrcity(String hrcity) {
        this.hrcity = hrcity;
    }

    @XmlElement
    public String getHrcounty() {
        return this.hrcounty;
    }

    public void setHrcounty(String hrcounty) {
        this.hrcounty = hrcounty;
    }

    @XmlElement
    public String getHrtownShip() {
        return this.hrtownShip;
    }

    public void setHrtownShip(String hrtownShip) {
        this.hrtownShip = hrtownShip;
    }

    @XmlElement
    public String getHrpostCode() {
        return this.hrpostCode;
    }

    public void setHrpostCode(String hrpostCode) {
        this.hrpostCode = hrpostCode;
    }

    @XmlElement
    public String getPastreet() {
        return this.pastreet;
    }

    public void setPastreet(String pastreet) {
        this.pastreet = pastreet;
    }

    @XmlElement
    public String getPahouseNumber() {
        return this.pahouseNumber;
    }

    public void setPahouseNumber(String pahouseNumber) {
        this.pahouseNumber = pahouseNumber;
    }

    @XmlElement
    public String getPaprovince() {
        return this.paprovince;
    }

    public void setPaprovince(String paprovince) {
        this.paprovince = paprovince;
    }

    @XmlElement
    public String getPacity() {
        return this.pacity;
    }

    public void setPacity(String pacity) {
        this.pacity = pacity;
    }

    @XmlElement
    public String getPacounty() {
        return this.pacounty;
    }

    public void setPacounty(String pacounty) {
        this.pacounty = pacounty;
    }

    @XmlElement
    public String getPatownShip() {
        return this.patownShip;
    }

    public void setPatownShip(String patownShip) {
        this.patownShip = patownShip;
    }

    @XmlElement
    public String getPapostCode() {
        return this.papostCode;
    }

    public void setPapostCode(String papostCode) {
        this.papostCode = papostCode;
    }

    @XmlElement
    public String getFamilyGeneDiseaseHistory() {
		return familyGeneDiseaseHistory;
	}

	public void setFamilyGeneDiseaseHistory(String familyGeneDiseaseHistory) {
		this.familyGeneDiseaseHistory = familyGeneDiseaseHistory;
	}

	@XmlElement
    public String getFamilyKinMarriageFlag() {
        return this.familyKinMarriageFlag;
    }

    public void setFamilyKinMarriageFlag(String familyKinMarriageFlag) {
        this.familyKinMarriageFlag = familyKinMarriageFlag;
    }

    @XmlElement
    public String getFamilyKinMarriageRelation() {
        return this.familyKinMarriageRelation;
    }

    public void setFamilyKinMarriageRelation(String familyKinMarriageRelation) {
        this.familyKinMarriageRelation = familyKinMarriageRelation;
    }

    @XmlElement
    public String getNeonatalGender() {
        return this.neonatalGender;
    }

    public void setNeonatalGender(String neonatalGender) {
        this.neonatalGender = neonatalGender;
    }

    @XmlElement
    public Integer getGestationalAge() {
        return this.gestationalAge;
    }

    public void setGestationalAge(Integer gestationalAge) {
        this.gestationalAge = gestationalAge;
    }

    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    public Date getDeliveryDate() {
        return this.deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @XmlElement
    public Integer getBirthWeight() {
		return birthWeight;
	}

	public void setBirthWeight(Integer birthWeight) {
		this.birthWeight = birthWeight;
	}

    @XmlElement
    public Integer getGestationalNumber() {
        return this.gestationalNumber;
    }

	public void setGestationalNumber(Integer gestationalNumber) {
        this.gestationalNumber = gestationalNumber;
    }

    @XmlElement
    public String getMultipleBirthsType() {
        return this.multipleBirthsType;
    }

    public void setMultipleBirthsType(String multipleBirthsType) {
        this.multipleBirthsType = multipleBirthsType;
    }

    @XmlElement
    public String getBirthDefect() {
        return this.birthDefect;
    }

    public void setBirthDefect(String birthDefect) {
        this.birthDefect = birthDefect;
    }

    @XmlElement
    public String getTherapeuticAbortionFlag() {
        return this.therapeuticAbortionFlag;
    }

    public void setTherapeuticAbortionFlag(String therapeuticAbortionFlag) {
        this.therapeuticAbortionFlag = therapeuticAbortionFlag;
    }

    @XmlElement
    public String getDiagnosisBasisType() {
        return this.diagnosisBasisType;
    }

    public void setDiagnosisBasisType(String diagnosisBasisType) {
        this.diagnosisBasisType = diagnosisBasisType;
    }

    @XmlElement
    public String getDefiniteTimeType() {
        return this.definiteTimeType;
    }

    public void setDefiniteTimeType(String definiteTimeType) {
        this.definiteTimeType = definiteTimeType;
    }

    @XmlElement
    public String getBirthDefectType() {
        return this.birthDefectType;
    }

    public void setBirthDefectType(String birthDefectType) {
        this.birthDefectType = birthDefectType;
    }

    @XmlElement
    public String getTrimesterIllnessFlag() {
        return this.trimesterIllnessFlag;
    }

    public void setTrimesterIllnessFlag(String trimesterIllnessFlag) {
        this.trimesterIllnessFlag = trimesterIllnessFlag;
    }
    
    @XmlElement
    public String getTrimesterIllnessState() {
		return trimesterIllnessState;
	}

	public void setTrimesterIllnessState(String trimesterIllnessState) {
		this.trimesterIllnessState = trimesterIllnessState;
	}

	@XmlElement
    public String getTrimesterMedicationType() {
        return this.trimesterMedicationType;
    }

    public void setTrimesterMedicationType(String trimesterMedicationType) {
        this.trimesterMedicationType = trimesterMedicationType;
    }

    @XmlElement
    public String getDrugName() {
        return this.drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    @XmlElement
    public String getTrimesterHarmFactorType() {
        return this.trimesterHarmFactorType;
    }

    public void setTrimesterHarmFactorType(String trimesterHarmFactorType) {
        this.trimesterHarmFactorType = trimesterHarmFactorType;
    }

    @XmlElement
    public String getTrimesterHarmFactorState() {
		return trimesterHarmFactorState;
	}

	public void setTrimesterHarmFactorState(String trimesterHarmFactorState) {
		this.trimesterHarmFactorState = trimesterHarmFactorState;
	}

	@XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    public Date getFillDate() {
        return this.fillDate;
    }

    public void setFillDate(Date fillDate) {
        this.fillDate = fillDate;
    }

    @XmlElement
    public String getFillUserName() {
        return this.fillUserName;
    }

    public void setFillUserName(String fillUserName) {
        this.fillUserName = fillUserName;
    }

    @XmlElement
    public String getFillTitleCode() {
        return this.fillTitleCode;
    }

    public void setFillTitleCode(String fillTitleCode) {
        this.fillTitleCode = fillTitleCode;
    }

    @XmlElement
    public String getFillUnitName() {
        return this.fillUnitName;
    }

    public void setFillUnitName(String fillUnitName) {
        this.fillUnitName = fillUnitName;
    }

    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    public Date getHospitalTrialTableDate() {
        return this.hospitalTrialTableDate;
    }

    public void setHospitalTrialTableDate(Date hospitalTrialTableDate) {
        this.hospitalTrialTableDate = hospitalTrialTableDate;
    }

    @XmlElement
    public String getHospitalTrialTableName() {
        return this.hospitalTrialTableName;
    }

    public void setHospitalTrialTableName(String hospitalTrialTableName) {
        this.hospitalTrialTableName = hospitalTrialTableName;
    }

    @XmlElement
    public String getHospitalTrialTableTitle() {
        return this.hospitalTrialTableTitle;
    }

    public void setHospitalTrialTableTitle(String hospitalTrialTableTitle) {
        this.hospitalTrialTableTitle = hospitalTrialTableTitle;
    }

    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    public Date getProvincialTrialTableDate() {
        return this.provincialTrialTableDate;
    }

    public void setProvincialTrialTableDate(Date provincialTrialTableDate) {
        this.provincialTrialTableDate = provincialTrialTableDate;
    }

    @XmlElement
    public String getProvincialTrialTableName() {
        return this.provincialTrialTableName;
    }

    public void setProvincialTrialTableName(String provincialTrialTableName) {
        this.provincialTrialTableName = provincialTrialTableName;
    }

    @XmlElement
    public String getProvincialTrialTableTitle() {
        return this.provincialTrialTableTitle;
    }

    public void setProvincialTrialTableTitle(String provincialTrialTableTitle) {
        this.provincialTrialTableTitle = provincialTrialTableTitle;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement
    public String getEhrId() {
        return ehrId;
    }

    public void setEhrId(String ehrId) {
        this.ehrId = ehrId;
    }

	
	public Long getPersonId() {
		return personId;
	}

	
	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	
	public String getIdCard() {
		return idCard;
	}

	
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}


	@XmlElement
	public String getMotherIdcard() {
		return motherIdcard;
	}

	public void setMotherIdcard(String motherIdcard) {
		this.motherIdcard = motherIdcard;
	}

	@XmlElement
	public String getBabyCardNo() {
		return babyCardNo;
	}

	public void setBabyCardNo(String babyCardNo) {
		this.babyCardNo = babyCardNo;
	}

	@XmlElement
	public String getCreateOrganCode() {
		return createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	@XmlElement
	public String getCreateOrganName() {
		return createOrganName;
	}

	public void setCreateOrganName(String createOrganName) {
		this.createOrganName = createOrganName;
	}
}
