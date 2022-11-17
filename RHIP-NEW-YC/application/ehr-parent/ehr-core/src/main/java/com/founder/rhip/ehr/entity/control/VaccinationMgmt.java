package com.founder.rhip.ehr.entity.control;

import com.founder.rhip.ehr.service.export.Item;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DC_VACCINATION_MGMT")
public class VaccinationMgmt implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|EHR号||", length = 20, nullable = true)
    private String ehrId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|PIX号|11|", length = 11, nullable = true)
    private Long personId;

    @Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号||", length = 17, nullable = true)
    private String healthFileNo;
    
	@Column(name = "VACCINATION_TICKET_NUMBER", columnDefinition = "VARCHAR2|接种票据号||", length = 20, nullable = true)
	private String vaccinationTicketNumber;
    
    @Column(name = "BARCODE", columnDefinition = "VARCHAR2|条码编码(接种证号)||", length = 20, nullable = true)
	private String barcode;
    
	@Column(name = "BARCODE_GRANT_DATE", columnDefinition = "DATE|条码发放日期||", nullable = true)
	private Date barcodeGrantDate;
	
	@Column(name = "CARD_SCAR_FLAG", columnDefinition = "VARCHAR2|卡疤||", length = 1, nullable = true)
	private String cardScarFlag;
	
	@Column(name = "COMMUNICATION_ADDRESS", columnDefinition = "VARCHAR2|通信地址||", length = 70, nullable = true)
	private String communicationAddress;
	
	@Column(name = "GRANT_DATE", columnDefinition = "DATE|发放日期||", nullable = true)
	private Date grantDate;
	
	@Column(name = "REGISTER_DATE", columnDefinition = "DATE|登记日期||", nullable = true)
	private Date registerDate;
	
	@Column(name = "GRANT_UNIT_NAME", columnDefinition = "VARCHAR2|发放单位||", length = 70, nullable = true)
	private String grantUnitName;

    @Column(name = "BIRTH_CERTIFICATE_NO", columnDefinition = "VARCHAR2|出生医学证明编号||", length = 10, nullable = true)
    private String birthCertificateNo;
    
	@Column(name = "VACCINATION_CODE", columnDefinition = "VARCHAR2|受接种者编号||", length = 18, nullable = true)
	private String vaccinationCode;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
    private String name;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别代码||", length = 1, nullable = true)
    private String gender;

    @Column(name = "NATION", columnDefinition = "VARCHAR2|民族||", length = 2, nullable = true)
    private String nation;

    @Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|本人电话号码||", length = 20, nullable = true)
    private String phoneNumber;

    @Column(name = "ADDRESS", columnDefinition = "VARCHAR2|出生地类别代码||", length = 300, nullable = true)
    private String address;

    @Column(name = "ADDRESS_TYPE", columnDefinition = "VARCHAR2|出生地类别代码||", length = 1, nullable = true)
    private String addressType;

    @Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
    private Date birthday;

    @Column(name = "BIRTHDAYTIME", columnDefinition = "TIMESTAMP|出生日期时间||", nullable = true)
    private Date birthdayTime;

    @Column(name = "BIRTH_WEIGHT", columnDefinition = "NUMBER|出生体重(g)||", length = 5, nullable = true)
    private Integer birthWeight;
    
    @Column(name = "WEIGHT", columnDefinition = "NUMBER|体重(kg)||", length = 5, nullable = true)
    private Integer weight;
    
    @Column(name = "GUARDIAN_PHONE_TEXT", columnDefinition = "VARCHAR2|监护人联系电话||", length = 50, nullable = true)
    private String guardianPhoneText;
    
    @Column(name = "GUARDIAN_NAME_TEXT", columnDefinition = "VARCHAR2|监护人姓名||", length = 50, nullable = true)
    private String guardianNameText;
    
    @Column(name = "OCCUPATION", columnDefinition = "VARCHAR2|职业||", length = 20, nullable = true)
    private String occupation;
    
	@Column(name = "ENROLLMENT_RECORD", columnDefinition = "VARCHAR2|入托/入学记录||", length = 100, nullable = true)
	private String enrollmentRecord;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证件号码||", length = 18, nullable = true)
    private String idCard;

    @Column(name = "IDCARD_TYPE", columnDefinition = "VARCHAR2|身份证件类别代码||", length = 2, nullable = true)
    private String idCardType;
    
	@Column(name = "OTHER_IDCARD_TYPE", columnDefinition = "VARCHAR2|其他证件类别代码||", length = 2, nullable = true)
	private String otherIdcardType;

	@Column(name = "OTHER_IDCARD", columnDefinition = "VARCHAR2|其他证件号码||", length = 20, nullable = true)
	private String otherIdcard;

	@Column(name = "HOUSEHOLD_TYPE", columnDefinition = "VARCHAR2|常住地址户籍类型||", length = 10, nullable = true)
	private String householdType;
	
    @Column(name = "HRPROVINCE", columnDefinition = "VARCHAR2|户籍地址-省(自治区、直辖市)||", length = 70, nullable = true)
    private String hrprovince;

    @Column(name = "HRCITY", columnDefinition = "VARCHAR2|卢籍地址-市(地区、州)||", length = 70, nullable = true)
    private String hrcity;

    @Column(name = "HRCOUNTY", columnDefinition = "VARCHAR2|户籍地址-县(区)||", length = 70, nullable = true)
    private String hrcounty;

    @Column(name = "HRTOWN_SHIP", columnDefinition = "VARCHAR2|户籍地址-乡(镇、街道办事处)||", length = 70, nullable = true)
    private String hrtownShip;

    @Column(name = "HRSTREET", columnDefinition = "VARCHAR2|户籍地址-村(街、路、弄等)||", length = 70, nullable = true)
    private String hrstreet;

    @Column(name = "HR_GROUP", columnDefinition = "VARCHAR2|户籍小组地址||", length = 2, nullable = true)
    private String hrGroup;

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

    @Column(name = "PA_GROUP", columnDefinition = "VARCHAR2|现住址小组地址||", length = 2, nullable = true)
    private String paGroup;

    @Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|现住地址-门牌号码||", length = 70, nullable = true)
    private String pahouseNumber;
    
	@Column(name = "FATHER_IDCARD", columnDefinition = "VARCHAR2|父亲身份证||", length = 18, nullable = true)
	private String fatherIdcard;

    @Column(name = "FATHER_NAME", columnDefinition = "VARCHAR2|父亲姓名||", length = 30, nullable = true)
    private String fatherName;

    @Column(name = "MOTHER_NAME", columnDefinition = "VARCHAR2|母亲姓名||", length = 30, nullable = true)
    private String motherName;
    
	@Column(name = "FATHER_UNIT_NAME", columnDefinition = "VARCHAR2|父亲工作单位||", length = 70, nullable = true)
	private String fatherUnitName;
	
	@Column(name = "FATHER_HBSAG", columnDefinition = "VARCHAR2|父亲乙肝表面抗原||", length = 1, nullable = true)
	private String fatherHbsag;

    @Column(name = "WAHOUSE_NUMBER", columnDefinition = "VARCHAR2|母亲乙肝表面抗原||", length = 1, nullable = true)
    private String wahouseNumber;
    
	@Column(name = "MOTHER_HBSAG", columnDefinition = "VARCHAR2|母亲乙肝表面抗原||", length = 1, nullable = true)
	private String motherHbsag;

    @Column(name = "GUARDER_NAME", columnDefinition = "VARCHAR2|监护人姓名||", length = 50, nullable = true)
    private String guarderName;

    @Column(name = "PHONE", columnDefinition = "VARCHAR2|监护人电话号码||", length = 20, nullable = true)
    private String phone;
    
    @Column(name = "GUARDER_IDCARD", columnDefinition = "VARCHAR2|监护人身份证件号码||", length = 18, nullable = true)
    private String guarderIdCard;

    @Column(name = "GUARDER_RELATION_CODE", columnDefinition = "VARCHAR2|监护人与本人关系代码||", length = 2, nullable = true)
    private String guarderRelationCode;

    @Column(name = "FAMILY_PHONE", columnDefinition = "VARCHAR2|家人电话号码||", length = 20, nullable = true)
    private String familyPhone;

    @Column(name = "UNIT_PHONE", columnDefinition = "VARCHAR2|工作单位电话号码||", length = 20, nullable = true)
    private String unitPhone;

    @Column(name = "INFECTIOUS_HISTORY", columnDefinition = "VARCHAR2|传染病史||", length = 100, nullable = true)
    private String infectiousHistory;

    @Column(name = "ALLERGEN", columnDefinition = "VARCHAR2|过敏原||", length = 20, nullable = true)
    private String allergen;

    @Column(name = "ALLERGY_SYMPTOMS", columnDefinition = "VARCHAR2|过敏症状||", length = 100, nullable = true)
    private String allergySymptoms;
    
	@Column(name = "IMMIGRATION_DATE", columnDefinition = "DATE|迁入日期||", nullable = true)
	private Date immigrationDate;
    
	@Column(name = "CREATE_CARD_NAME", columnDefinition = "VARCHAR2|建卡人姓名||", length = 50, nullable = true)
	private String createCardName;
	
	@Column(name = "EVACUATION_DATE", columnDefinition = "DATE|迁出日期||", nullable = true)
	private Date evacuationDate;
	
	@Column(name = "EVACUATION_CAUSE", columnDefinition = "VARCHAR2|迁出原因||", length = 100, nullable = true)
	private String evacuationCause;
    
	@Column(name = "CREATE_CARD_DATE", columnDefinition = "DATE|建卡日期||", nullable = true)
	private Date createCardDate;
	
	@Column(name = "MOTHER_PHONE", columnDefinition = "VARCHAR2|母亲电话号码||", length = 20, nullable = true)
	private String motherPhone;
	
	@Column(name = "MOTHER_UNIT_NAME", columnDefinition = "VARCHAR2|母亲工作单位名称||", length = 100, nullable = true)
	private String motherUnitName;
	
	@Column(name = "OTHER_PHONE", columnDefinition = "VARCHAR2|其他电话号码||", length = 20, nullable = true)
	private String otherPhone;
	
	@Column(name = "NEIGHBORHOOD_ADDRESS", columnDefinition = "VARCHAR2|居委会地址||", length = 100, nullable = true)
	private String neighborhoodAddress;
	
	@Column(name = "PAADDRESS", columnDefinition = "VARCHAR2|现住址||", length = 100, nullable = true)
	private String paaddress;
	
	@Column(name = "RH_BLOOD_TYPE", columnDefinition = "VARCHAR2|RH血型||", length = 20, nullable = true)
	private String rhBloodType;
	
	@Column(name = "ABO_BLOOD_TYPE", columnDefinition = "VARCHAR2|ABO血型||", length = 20, nullable = true)
	private String aboBloodType;
	
	@Column(name = "TABOO_FLAG", columnDefinition = "VARCHAR2|有禁忌||", length = 1, nullable = true)
	private String tabooFlag;
	
	@Column(name = "UNIT_NAME", columnDefinition = "VARCHAR2|所在单位||", length = 70, nullable = true)
	private String unitName;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete = 0;
    
	@Column(name = "ABO_BLOOD_NAME", columnDefinition = "VARCHAR2|ABO血型名称||", length = 20, nullable = true)
	private String aboBloodName;
	
	@Column(name = "VACCINATION_TYPE", columnDefinition = "VARCHAR2|疫苗类型，02为成人次疫苗||", length = 20, nullable = true)
	private String vaccinationType;
	
	@Column(name = "VACCINATION_DOCTOR_NAME", columnDefinition = "VARCHAR2|接种医生姓名||", length = 50, nullable = true)
	private String vaccinationDoctorName;
	
	@Column(name = "BIRTH_HOS_NAME", columnDefinition = "VARCHAR2|||", length = 20, nullable = true)
	private String birthHosName;
	
	@Column(name = "MOTHER_IDCARD", columnDefinition = "VARCHAR2|母亲身份证||", length = 18, nullable = true)
	private String motherIdcard;
	
    @Transient
    private Integer age;
    
	@Column(name = "IS_INJECTED", columnDefinition = "VARCHAR2|是否曾经接种||", length = 1, nullable = true)
	private String isInjected;
	
	@Column(name = "LAST_INJECTED_DATE", columnDefinition = "DATE|最近接种时间||", nullable = true)
	private Date lastInjectedDate;
	
	@Column(name = "COUNT", columnDefinition = "NUMBER|接种针次数||", nullable = true)
	private Integer count;
	
	@Column(name = "FACTORY", columnDefinition = "VARCHAR2|生产厂家||", length = 20, nullable = true)
	private String factory;
	
	@Column(name = "other_note", columnDefinition = "VARCHAR2|其他情况||", length = 500, nullable = true)
	private String otherNote;
	
    @Column(name = "IS_ANALYSE", columnDefinition = "NUMBER|是否处理过敏史||", length = 1, nullable = true)
    private Integer isAnalyse = -1;
    
    @Column(name = "PAPOST_CODE", columnDefinition = "VARCHAR2|现住址邮政编码||", length = 6, nullable = true)
	private String papostCode;
    
    // 23价疫苗修改添加开始  添加人：高飞  添加日期：20180328
    @Column(name = "RESIDENCE_TYPE", columnDefinition = "VARCHAR2|户口性质||", length = 2, nullable = true)
   	private String residenceType;
    
    @Column(name = "DOMICILE_FALG", columnDefinition = "VARCHAR2|常住类型||", length = 2, nullable = true)
   	private String domicileFalg;
    
    @Transient
    private String vaccineHistory; // 既往接种史 
    
    @Transient
    private String diseaseHistory; // 疾病史
    //23价疫苗修改添加结束
    
	@Transient
    private String guarderRelationCodeDesc;
	
	@Transient
	private String pneumoniaVaccFlag; // 23价疫苗接种标记  添加人：高飞  添加日期：20180403
	
	@Transient
	private String ageFlag; //65-85周岁年年龄标志  添加人：俞佳伟  添加日期：20180614
	

    public String getGenderDesc() {
        return genderDesc;
    }

    public void setGenderDesc(String genderDesc) {
        this.genderDesc = genderDesc;
    }

    @Transient
    private String genderDesc;
	
	public String getPapostCode() {
		return papostCode;
	}

	public void setPapostCode(String papostCode) {
		this.papostCode = papostCode;
	}


    public String getGuarderRelationCodeDesc() {
		return guarderRelationCodeDesc;
	}

	public void setGuarderRelationCodeDesc(String guarderRelationCodeDesc) {
		this.guarderRelationCodeDesc = guarderRelationCodeDesc;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getIsInjected() {
		return isInjected;
	}

	public void setIsInjected(String isInjected) {
		this.isInjected = isInjected;
	}

	public Date getLastInjectedDate() {
		return lastInjectedDate;
	}

	public void setLastInjectedDate(Date lastInjectedDate) {
		this.lastInjectedDate = lastInjectedDate;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getOtherNote() {
		return otherNote;
	}

	public void setOtherNote(String otherNote) {
		this.otherNote = otherNote;
	}

	public Integer getAge() {
    	return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getHealthFileNo() {
        return this.healthFileNo;
    }

    public void setHealthFileNo(String healthFileNo) {
        this.healthFileNo = healthFileNo;
    }

    public String getBirthCertificateNo() {
        return this.birthCertificateNo;
    }

    public void setBirthCertificateNo(String birthCertificateNo) {
        this.birthCertificateNo = birthCertificateNo;
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

    public Date getBirthdayTime() {
        return birthdayTime;
    }

    public void setBirthdayTime(Date birthdayTime) {
        this.birthdayTime = birthdayTime;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getBirthWeight() {
        return this.birthWeight;
    }

    public void setBirthWeight(Integer birthWeight) {
        this.birthWeight = birthWeight;
    }

    public String getIdCard() {
        return this.idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIdCardType() {
        return this.idCardType;
    }

    public void setIdCardType(String idCardType) {
        this.idCardType = idCardType;
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

    public String getWahouseNumber() {
        return this.wahouseNumber;
    }

    public void setWahouseNumber(String wahouseNumber) {
        this.wahouseNumber = wahouseNumber;
    }

    public String getGuarderName() {
        return this.guarderName;
    }

    public void setGuarderName(String guarderName) {
        this.guarderName = guarderName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGuarderIdCard() {
        return this.guarderIdCard;
    }

    public void setGuarderIdCard(String guarderIdCard) {
        this.guarderIdCard = guarderIdCard;
    }

    public String getGuarderRelationCode() {
        return this.guarderRelationCode;
    }

    public void setGuarderRelationCode(String guarderRelationCode) {
        this.guarderRelationCode = guarderRelationCode;
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

    public String getInfectiousHistory() {
        return this.infectiousHistory;
    }

    public void setInfectiousHistory(String infectiousHistory) {
        this.infectiousHistory = infectiousHistory;
    }

    public String getAllergen() {
        return this.allergen;
    }

    public void setAllergen(String allergen) {
        this.allergen = allergen;
    }

    public String getAllergySymptoms() {
        return this.allergySymptoms;
    }

    public void setAllergySymptoms(String allergySymptoms) {
        this.allergySymptoms = allergySymptoms;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEhrId() {
        return ehrId;
    }

    public void setEhrId(String ehrId) {
        this.ehrId = ehrId;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

	
	public String getVaccinationTicketNumber() {
		return vaccinationTicketNumber;
	}

	
	public void setVaccinationTicketNumber(String vaccinationTicketNumber) {
		this.vaccinationTicketNumber = vaccinationTicketNumber;
	}

	
	public String getBarcode() {
		return barcode;
	}

	
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	
	public Date getBarcodeGrantDate() {
		return barcodeGrantDate;
	}

	
	public void setBarcodeGrantDate(Date barcodeGrantDate) {
		this.barcodeGrantDate = barcodeGrantDate;
	}

	
	public String getCardScarFlag() {
		return cardScarFlag;
	}

	
	public void setCardScarFlag(String cardScarFlag) {
		this.cardScarFlag = cardScarFlag;
	}

	
	public String getCommunicationAddress() {
		return communicationAddress;
	}

	
	public void setCommunicationAddress(String communicationAddress) {
		this.communicationAddress = communicationAddress;
	}

	
	public Date getGrantDate() {
		return grantDate;
	}

	
	public void setGrantDate(Date grantDate) {
		this.grantDate = grantDate;
	}

	
	public Date getRegisterDate() {
		return registerDate;
	}

	
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	
	public String getGrantUnitName() {
		return grantUnitName;
	}

	
	public void setGrantUnitName(String grantUnitName) {
		this.grantUnitName = grantUnitName;
	}

	
	public String getVaccinationCode() {
		return vaccinationCode;
	}

	
	public void setVaccinationCode(String vaccinationCode) {
		this.vaccinationCode = vaccinationCode;
	}

	
	public String getEnrollmentRecord() {
		return enrollmentRecord;
	}

	
	public void setEnrollmentRecord(String enrollmentRecord) {
		this.enrollmentRecord = enrollmentRecord;
	}

	
	public String getOtherIdcardType() {
		return otherIdcardType;
	}

	
	public void setOtherIdcardType(String otherIdcardType) {
		this.otherIdcardType = otherIdcardType;
	}

	
	public String getOtherIdcard() {
		return otherIdcard;
	}

	
	public void setOtherIdcard(String otherIdcard) {
		this.otherIdcard = otherIdcard;
	}

	
	public String getFatherIdcard() {
		return fatherIdcard;
	}

	
	public void setFatherIdcard(String fatherIdcard) {
		this.fatherIdcard = fatherIdcard;
	}

	
	public String getFatherUnitName() {
		return fatherUnitName;
	}

	
	public void setFatherUnitName(String fatherUnitName) {
		this.fatherUnitName = fatherUnitName;
	}

	
	public String getFatherHbsag() {
		return fatherHbsag;
	}

	
	public void setFatherHbsag(String fatherHbsag) {
		this.fatherHbsag = fatherHbsag;
	}

	
	public String getMotherHbsag() {
		return motherHbsag;
	}

	
	public void setMotherHbsag(String motherHbsag) {
		this.motherHbsag = motherHbsag;
	}

	
	public Date getImmigrationDate() {
		return immigrationDate;
	}

	
	public void setImmigrationDate(Date immigrationDate) {
		this.immigrationDate = immigrationDate;
	}

	
	public String getCreateCardName() {
		return createCardName;
	}

	
	public void setCreateCardName(String createCardName) {
		this.createCardName = createCardName;
	}

	
	public Date getEvacuationDate() {
		return evacuationDate;
	}

	
	public void setEvacuationDate(Date evacuationDate) {
		this.evacuationDate = evacuationDate;
	}

	
	public String getEvacuationCause() {
		return evacuationCause;
	}

	
	public void setEvacuationCause(String evacuationCause) {
		this.evacuationCause = evacuationCause;
	}

	
	public Date getCreateCardDate() {
		return createCardDate;
	}

	
	public void setCreateCardDate(Date createCardDate) {
		this.createCardDate = createCardDate;
	}

	
	public String getMotherPhone() {
		return motherPhone;
	}

	
	public void setMotherPhone(String motherPhone) {
		this.motherPhone = motherPhone;
	}

	
	public String getMotherUnitName() {
		return motherUnitName;
	}

	
	public void setMotherUnitName(String motherUnitName) {
		this.motherUnitName = motherUnitName;
	}

	
	public String getOtherPhone() {
		return otherPhone;
	}

	
	public void setOtherPhone(String otherPhone) {
		this.otherPhone = otherPhone;
	}

	
	public String getNeighborhoodAddress() {
		return neighborhoodAddress;
	}

	
	public void setNeighborhoodAddress(String neighborhoodAddress) {
		this.neighborhoodAddress = neighborhoodAddress;
	}

	
	public String getPaaddress() {
		return paaddress;
	}

	
	public void setPaaddress(String paaddress) {
		this.paaddress = paaddress;
	}

	
	public String getRhBloodType() {
		return rhBloodType;
	}

	
	public void setRhBloodType(String rhBloodType) {
		this.rhBloodType = rhBloodType;
	}

	
	public String getTabooFlag() {
		return tabooFlag;
	}

	
	public void setTabooFlag(String tabooFlag) {
		this.tabooFlag = tabooFlag;
	}

	
	public String getUnitName() {
		return unitName;
	}

	
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	
	public String getAboBloodType() {
		return aboBloodType;
	}

	
	public void setAboBloodType(String aboBloodType) {
		this.aboBloodType = aboBloodType;
	}

	
	public String getAboBloodName() {
		return aboBloodName;
	}

	
	public void setAboBloodName(String aboBloodName) {
		this.aboBloodName = aboBloodName;
	}

	public String getVaccinationType() {
		return vaccinationType;
	}

	public void setVaccinationType(String vaccinationType) {
		this.vaccinationType = vaccinationType;
	}

	public String getHouseholdType() {
		return householdType;
	}

	public void setHouseholdType(String householdType) {
		this.householdType = householdType;
	}

	
	public String getVaccinationDoctorName() {
		return vaccinationDoctorName;
	}

	
	public void setVaccinationDoctorName(String vaccinationDoctorName) {
		this.vaccinationDoctorName = vaccinationDoctorName;
	}

	
	public String getBirthHosName() {
		return birthHosName;
	}

	
	public void setBirthHosName(String birthHosName) {
		this.birthHosName = birthHosName;
	}

	
	public String getMotherIdcard() {
		return motherIdcard;
	}

	
	public void setMotherIdcard(String motherIdcard) {
		this.motherIdcard = motherIdcard;
	}

	
	public Integer getIsAnalyse() {
		return isAnalyse;
	}

	
	public void setIsAnalyse(Integer isAnalyse) {
		this.isAnalyse = isAnalyse;
	}

	public String getVaccineHistory() {
		return vaccineHistory;
	}

	public void setVaccineHistory(String vaccineHistory) {
		this.vaccineHistory = vaccineHistory;
	}

	public String getResidenceType() {
		return residenceType;
	}

	public void setResidenceType(String residenceType) {
		this.residenceType = residenceType;
	}

	public String getDomicileFalg() {
		return domicileFalg;
	}

	public void setDomicileFalg(String domicileFalg) {
		this.domicileFalg = domicileFalg;
	}

	public String getPneumoniaVaccFlag() {
		return pneumoniaVaccFlag;
	}

	public void setPneumoniaVaccFlag(String pneumoniaVaccFlag) {
		this.pneumoniaVaccFlag = pneumoniaVaccFlag;
	}

	public String getDiseaseHistory() {
		return diseaseHistory;
	}

	public void setDiseaseHistory(String diseaseHistory) {
		this.diseaseHistory = diseaseHistory;
	}

	
	public String getAgeFlag() {
		return ageFlag;
	}

	public void setAgeFlag(String ageFlag) {
		this.ageFlag = ageFlag;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getGuardianPhoneText() {
		return guardianPhoneText;
	}

	public void setGuardianPhoneText(String guardianPhoneText) {
		this.guardianPhoneText = guardianPhoneText;
	}

	public String getGuardianNameText() {
		return guardianNameText;
	}

	public void setGuardianNameText(String guardianNameText) {
		this.guardianNameText = guardianNameText;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
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
}
