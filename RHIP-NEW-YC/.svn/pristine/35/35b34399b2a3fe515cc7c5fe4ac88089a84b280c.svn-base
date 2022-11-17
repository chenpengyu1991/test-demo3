package com.founder.rhip.ehr.entity.child;

import com.founder.fasf.util.DateUtil;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "CH_BIRTH_CERTIFICATE")
public class BirthCertificate {
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "JDBC")
	private Long id;

	@Column(name = "EHR_ID")
	private String ehrId;

	@Column(name = "PERSON_ID")
	private Long personId;

	@Column(name = "BIRTH_CERTIFICATE_NO")
	private String birthCertificateNo;

	@Column(name = "NEONATAL_NAME")
	private String neonatalName;

	@Column(name = "NEONATAL_GENDER")
	private String neonatalGender;

	@Column(name = "NEONATAL_BIRTHDAY")
	private Date neonatalBirthday;

	@Column(name = "AREA_CODE")
	private String areaCode;

	@Column(name = "PAPROVINCE")
	private String paprovince;

	@Column(name = "PACITY")
	private String pacity;

	@Column(name = "PACOUNTY")
	private String pacounty;

	@Column(name = "PATOWN_SHIP")
	private String patownShip;

	@Column(name = "PASTREET")
	private String pastreet;

	@Column(name = "PAHOUSE_NUMBER")
	private String pahouseNumber;

	@Column(name = "PAPOST_CODE")
	private String papostCode;

	@Column(name = "GESTATIONAL_WEEK")
	private Short gestationalWeek;

	@Column(name = "NEONATAL_HEALTH")
	private String neonatalHealth;

	@Column(name = "BIRTH_STATURE")
	private BigDecimal birthStature;

	@Column(name = "BIRTH_WEIGHT")
	private Short birthWeight;

	@Column(name = "MOTHER_NAME")
	private String motherName;

	@Column(name = "MOTHER_BIRTH_DATE")
	private Date motherBirthDate;

	@Column(name = "MOTHER_NATIONALITY")
	private String motherNationality;

	@Column(name = "MOTHER_NATION")
	private String motherNation;

	@Column(name = "MOTHER_IDCARD_TYPE")
	private String motherIdcardType;

	@Column(name = "MOTHER_IDCARD")
	private String motherIdcard;

	@Column(name = "MOTHER_PAPROVINCE")
	private String motherPaprovince;

	@Column(name = "MOTHER_PACITY")
	private String motherPacity;

	@Column(name = "MOTHER_PACOUNTY")
	private String motherPacounty;

	@Column(name = "MOTHER_PATOWN_SHIP")
	private String motherPatownShip;

	@Column(name = "MOTHER_PASTREET")
	private String motherPastreet;

	@Column(name = "MOTHER_PAHOUSE_NUMBER")
	private String motherPahouseNumber;

	@Column(name = "MOTHER_PAPOST_CODE")
	private String motherPapostCode;

	@Column(name = "FATHER_NAME")
	private String fatherName;

	@Column(name = "FATHER_BIRTH_DATE")
	private Date fatherBirthDate;

	@Column(name = "FATHER_NATIONALITY")
	private String fatherNationality;

	@Column(name = "FATHER_NATION")
	private String fatherNation;

	@Column(name = "FATHER_IDCARD_TYPE")
	private String fatherIdcardType;

	@Column(name = "FATHER_IDCARD")
	private String fatherIdcard;

	@Column(name = "FATHER_PAPROVINCE")
	private String fatherPaprovince;

	@Column(name = "FATHER_PACITY")
	private String fatherPacity;

	@Column(name = "FATHER_PACOUNTY")
	private String fatherPacounty;

	@Column(name = "FATHER_PATOWN_SHIP")
	private String fatherPatownShip;

	@Column(name = "FATHER_PASTREET")
	private String fatherPastreet;

	@Column(name = "FATHER_PAHOUSE_NUMBER")
	private String fatherPahouseNumber;

	@Column(name = "FATHER_PAPOST_CODE")
	private String fatherPapostCode;

	@Column(name = "BIRTH_PLACE_TYPE")
	private String birthPlaceType;

	@Column(name = "MIDWIFERY_NAME")
	private String midwiferyName;

	@Column(name = "MIDWIFERY_ORGAN_CODE")
	private String midwiferyOrganCode;

	@Column(name = "MIDWIFERY_ORGAN_NAME")
	private String midwiferyOrganName;

	@Column(name = "ISSUED_NAME")
	private String issuedName;

	@Column(name = "LICENSING_NAME")
	private String licensingName;

	@Column(name = "ISSUED_DATE")
	private Date issuedDate;

	@Column(name = "VISA_ORGAN_CODE")
	private String visaOrganCode;

	@Column(name = "VISA_ORGAN_NAME")
	private String visaOrganName;

	@Column(name = "PROCESS_STATUS")
	private String processStatus;

	@Column(name = "BABY_CARD_NO")
	private String babyCardNo;

	@Column(name = "CREATE_ORGAN_CODE")
	private String createOrganCode;

	@Column(name = "CREATE_ORGAN_NAME")
	private String createOrganName;

	@Column(name = "GATHER_DATE")
	private Date gatherDate;

	@Column(name = "IS_DELETE")
	private Short isDelete;



	/**
	 * 母亲年龄
	 */
	@Transient
	private Integer motherAge;
	/**
	 * 父亲年龄
	 */
	@Transient
	private Integer fatherAge;

	public Integer getFatherAge() {
		Double age = DateUtil.getAgeByBirthday(this.getFatherBirthDate(),this.neonatalBirthday);
		return age.intValue();
	}

	public Integer getMotherAge() {
		Double age = DateUtil.getAgeByBirthday(this.getMotherBirthDate(),this.neonatalBirthday);
		return age.intValue();
	}

	/**
	 * @return ID
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return EHR_ID
	 */
	public String getEhrId() {
		return ehrId;
	}

	/**
	 * @param ehrId
	 */
	public void setEhrId(String ehrId) {
		this.ehrId = ehrId;
	}

	/**
	 * @return PERSON_ID
	 */
	public Long getPersonId() {
		return personId;
	}

	/**
	 * @param personId
	 */
	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	/**
	 * @return BIRTH_CERTIFICATE_NO
	 */
	public String getBirthCertificateNo() {
		return birthCertificateNo;
	}

	/**
	 * @param birthCertificateNo
	 */
	public void setBirthCertificateNo(String birthCertificateNo) {
		this.birthCertificateNo = birthCertificateNo;
	}

	/**
	 * @return NEONATAL_NAME
	 */
	public String getNeonatalName() {
		return neonatalName;
	}

	/**
	 * @param neonatalName
	 */
	public void setNeonatalName(String neonatalName) {
		this.neonatalName = neonatalName;
	}

	/**
	 * @return NEONATAL_GENDER
	 */
	public String getNeonatalGender() {
		return neonatalGender;
	}

	/**
	 * @param neonatalGender
	 */
	public void setNeonatalGender(String neonatalGender) {
		this.neonatalGender = neonatalGender;
	}

	/**
	 * @return NEONATAL_BIRTHDAY
	 */
	public Date getNeonatalBirthday() {
		return neonatalBirthday;
	}

	/**
	 * @param neonatalBirthday
	 */
	public void setNeonatalBirthday(Date neonatalBirthday) {
		this.neonatalBirthday = neonatalBirthday;
	}

	/**
	 * @return AREA_CODE
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * @param areaCode
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * @return PAPROVINCE
	 */
	public String getPaprovince() {
		return paprovince;
	}

	/**
	 * @param paprovince
	 */
	public void setPaprovince(String paprovince) {
		this.paprovince = paprovince;
	}

	/**
	 * @return PACITY
	 */
	public String getPacity() {
		return pacity;
	}

	/**
	 * @param pacity
	 */
	public void setPacity(String pacity) {
		this.pacity = pacity;
	}

	/**
	 * @return PACOUNTY
	 */
	public String getPacounty() {
		return pacounty;
	}

	/**
	 * @param pacounty
	 */
	public void setPacounty(String pacounty) {
		this.pacounty = pacounty;
	}

	/**
	 * @return PATOWN_SHIP
	 */
	public String getPatownShip() {
		return patownShip;
	}

	/**
	 * @param patownShip
	 */
	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}

	/**
	 * @return PASTREET
	 */
	public String getPastreet() {
		return pastreet;
	}

	/**
	 * @param pastreet
	 */
	public void setPastreet(String pastreet) {
		this.pastreet = pastreet;
	}

	/**
	 * @return PAHOUSE_NUMBER
	 */
	public String getPahouseNumber() {
		return pahouseNumber;
	}

	/**
	 * @param pahouseNumber
	 */
	public void setPahouseNumber(String pahouseNumber) {
		this.pahouseNumber = pahouseNumber;
	}

	/**
	 * @return PAPOST_CODE
	 */
	public String getPapostCode() {
		return papostCode;
	}

	/**
	 * @param papostCode
	 */
	public void setPapostCode(String papostCode) {
		this.papostCode = papostCode;
	}

	/**
	 * @return GESTATIONAL_WEEK
	 */
	public Short getGestationalWeek() {
		return gestationalWeek;
	}

	/**
	 * @param gestationalWeek
	 */
	public void setGestationalWeek(Short gestationalWeek) {
		this.gestationalWeek = gestationalWeek;
	}

	/**
	 * @return NEONATAL_HEALTH
	 */
	public String getNeonatalHealth() {
		return neonatalHealth;
	}

	/**
	 * @param neonatalHealth
	 */
	public void setNeonatalHealth(String neonatalHealth) {
		this.neonatalHealth = neonatalHealth;
	}

	/**
	 * @return BIRTH_STATURE
	 */
	public BigDecimal getBirthStature() {
		return birthStature;
	}

	/**
	 * @param birthStature
	 */
	public void setBirthStature(BigDecimal birthStature) {
		this.birthStature = birthStature;
	}

	/**
	 * @return BIRTH_WEIGHT
	 */
	public Short getBirthWeight() {
		return birthWeight;
	}

	/**
	 * @param birthWeight
	 */
	public void setBirthWeight(Short birthWeight) {
		this.birthWeight = birthWeight;
	}

	/**
	 * @return MOTHER_NAME
	 */
	public String getMotherName() {
		return motherName;
	}

	/**
	 * @param motherName
	 */
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	/**
	 * @return MOTHER_BIRTH_DATE
	 */
	public Date getMotherBirthDate() {
		return motherBirthDate;
	}

	/**
	 * @param motherBirthDate
	 */
	public void setMotherBirthDate(Date motherBirthDate) {
		this.motherBirthDate = motherBirthDate;
	}

	/**
	 * @return MOTHER_NATIONALITY
	 */
	public String getMotherNationality() {
		return motherNationality;
	}

	/**
	 * @param motherNationality
	 */
	public void setMotherNationality(String motherNationality) {
		this.motherNationality = motherNationality;
	}

	/**
	 * @return MOTHER_NATION
	 */
	public String getMotherNation() {
		return motherNation;
	}

	/**
	 * @param motherNation
	 */
	public void setMotherNation(String motherNation) {
		this.motherNation = motherNation;
	}

	/**
	 * @return MOTHER_IDCARD_TYPE
	 */
	public String getMotherIdcardType() {
		return motherIdcardType;
	}

	/**
	 * @param motherIdcardType
	 */
	public void setMotherIdcardType(String motherIdcardType) {
		this.motherIdcardType = motherIdcardType;
	}

	/**
	 * @return MOTHER_IDCARD
	 */
	public String getMotherIdcard() {
		return motherIdcard;
	}

	/**
	 * @param motherIdcard
	 */
	public void setMotherIdcard(String motherIdcard) {
		this.motherIdcard = motherIdcard;
	}

	/**
	 * @return MOTHER_PAPROVINCE
	 */
	public String getMotherPaprovince() {
		return motherPaprovince;
	}

	/**
	 * @param motherPaprovince
	 */
	public void setMotherPaprovince(String motherPaprovince) {
		this.motherPaprovince = motherPaprovince;
	}

	/**
	 * @return MOTHER_PACITY
	 */
	public String getMotherPacity() {
		return motherPacity;
	}

	/**
	 * @param motherPacity
	 */
	public void setMotherPacity(String motherPacity) {
		this.motherPacity = motherPacity;
	}

	/**
	 * @return MOTHER_PACOUNTY
	 */
	public String getMotherPacounty() {
		return motherPacounty;
	}

	/**
	 * @param motherPacounty
	 */
	public void setMotherPacounty(String motherPacounty) {
		this.motherPacounty = motherPacounty;
	}

	/**
	 * @return MOTHER_PATOWN_SHIP
	 */
	public String getMotherPatownShip() {
		return motherPatownShip;
	}

	/**
	 * @param motherPatownShip
	 */
	public void setMotherPatownShip(String motherPatownShip) {
		this.motherPatownShip = motherPatownShip;
	}

	/**
	 * @return MOTHER_PASTREET
	 */
	public String getMotherPastreet() {
		return motherPastreet;
	}

	/**
	 * @param motherPastreet
	 */
	public void setMotherPastreet(String motherPastreet) {
		this.motherPastreet = motherPastreet;
	}

	/**
	 * @return MOTHER_PAHOUSE_NUMBER
	 */
	public String getMotherPahouseNumber() {
		return motherPahouseNumber;
	}

	/**
	 * @param motherPahouseNumber
	 */
	public void setMotherPahouseNumber(String motherPahouseNumber) {
		this.motherPahouseNumber = motherPahouseNumber;
	}

	/**
	 * @return MOTHER_PAPOST_CODE
	 */
	public String getMotherPapostCode() {
		return motherPapostCode;
	}

	/**
	 * @param motherPapostCode
	 */
	public void setMotherPapostCode(String motherPapostCode) {
		this.motherPapostCode = motherPapostCode;
	}

	/**
	 * @return FATHER_NAME
	 */
	public String getFatherName() {
		return fatherName;
	}

	/**
	 * @param fatherName
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	/**
	 * @return FATHER_BIRTH_DATE
	 */
	public Date getFatherBirthDate() {
		return fatherBirthDate;
	}

	/**
	 * @param fatherBirthDate
	 */
	public void setFatherBirthDate(Date fatherBirthDate) {
		this.fatherBirthDate = fatherBirthDate;
	}

	/**
	 * @return FATHER_NATIONALITY
	 */
	public String getFatherNationality() {
		return fatherNationality;
	}

	/**
	 * @param fatherNationality
	 */
	public void setFatherNationality(String fatherNationality) {
		this.fatherNationality = fatherNationality;
	}

	/**
	 * @return FATHER_NATION
	 */
	public String getFatherNation() {
		return fatherNation;
	}

	/**
	 * @param fatherNation
	 */
	public void setFatherNation(String fatherNation) {
		this.fatherNation = fatherNation;
	}

	/**
	 * @return FATHER_IDCARD_TYPE
	 */
	public String getFatherIdcardType() {
		return fatherIdcardType;
	}

	/**
	 * @param fatherIdcardType
	 */
	public void setFatherIdcardType(String fatherIdcardType) {
		this.fatherIdcardType = fatherIdcardType;
	}

	/**
	 * @return FATHER_IDCARD
	 */
	public String getFatherIdcard() {
		return fatherIdcard;
	}

	/**
	 * @param fatherIdcard
	 */
	public void setFatherIdcard(String fatherIdcard) {
		this.fatherIdcard = fatherIdcard;
	}

	/**
	 * @return FATHER_PAPROVINCE
	 */
	public String getFatherPaprovince() {
		return fatherPaprovince;
	}

	/**
	 * @param fatherPaprovince
	 */
	public void setFatherPaprovince(String fatherPaprovince) {
		this.fatherPaprovince = fatherPaprovince;
	}

	/**
	 * @return FATHER_PACITY
	 */
	public String getFatherPacity() {
		return fatherPacity;
	}

	/**
	 * @param fatherPacity
	 */
	public void setFatherPacity(String fatherPacity) {
		this.fatherPacity = fatherPacity;
	}

	/**
	 * @return FATHER_PACOUNTY
	 */
	public String getFatherPacounty() {
		return fatherPacounty;
	}

	/**
	 * @param fatherPacounty
	 */
	public void setFatherPacounty(String fatherPacounty) {
		this.fatherPacounty = fatherPacounty;
	}

	/**
	 * @return FATHER_PATOWN_SHIP
	 */
	public String getFatherPatownShip() {
		return fatherPatownShip;
	}

	/**
	 * @param fatherPatownShip
	 */
	public void setFatherPatownShip(String fatherPatownShip) {
		this.fatherPatownShip = fatherPatownShip;
	}

	/**
	 * @return FATHER_PASTREET
	 */
	public String getFatherPastreet() {
		return fatherPastreet;
	}

	/**
	 * @param fatherPastreet
	 */
	public void setFatherPastreet(String fatherPastreet) {
		this.fatherPastreet = fatherPastreet;
	}

	/**
	 * @return FATHER_PAHOUSE_NUMBER
	 */
	public String getFatherPahouseNumber() {
		return fatherPahouseNumber;
	}

	/**
	 * @param fatherPahouseNumber
	 */
	public void setFatherPahouseNumber(String fatherPahouseNumber) {
		this.fatherPahouseNumber = fatherPahouseNumber;
	}

	/**
	 * @return FATHER_PAPOST_CODE
	 */
	public String getFatherPapostCode() {
		return fatherPapostCode;
	}

	/**
	 * @param fatherPapostCode
	 */
	public void setFatherPapostCode(String fatherPapostCode) {
		this.fatherPapostCode = fatherPapostCode;
	}

	/**
	 * @return BIRTH_PLACE_TYPE
	 */
	public String getBirthPlaceType() {
		return birthPlaceType;
	}

	/**
	 * @param birthPlaceType
	 */
	public void setBirthPlaceType(String birthPlaceType) {
		this.birthPlaceType = birthPlaceType;
	}

	/**
	 * @return MIDWIFERY_NAME
	 */
	public String getMidwiferyName() {
		return midwiferyName;
	}

	/**
	 * @param midwiferyName
	 */
	public void setMidwiferyName(String midwiferyName) {
		this.midwiferyName = midwiferyName;
	}

	/**
	 * @return MIDWIFERY_ORGAN_CODE
	 */
	public String getMidwiferyOrganCode() {
		return midwiferyOrganCode;
	}

	/**
	 * @param midwiferyOrganCode
	 */
	public void setMidwiferyOrganCode(String midwiferyOrganCode) {
		this.midwiferyOrganCode = midwiferyOrganCode;
	}

	/**
	 * @return MIDWIFERY_ORGAN_NAME
	 */
	public String getMidwiferyOrganName() {
		return midwiferyOrganName;
	}

	/**
	 * @param midwiferyOrganName
	 */
	public void setMidwiferyOrganName(String midwiferyOrganName) {
		this.midwiferyOrganName = midwiferyOrganName;
	}

	/**
	 * @return ISSUED_NAME
	 */
	public String getIssuedName() {
		return issuedName;
	}

	/**
	 * @param issuedName
	 */
	public void setIssuedName(String issuedName) {
		this.issuedName = issuedName;
	}

	/**
	 * @return LICENSING_NAME
	 */
	public String getLicensingName() {
		return licensingName;
	}

	/**
	 * @param licensingName
	 */
	public void setLicensingName(String licensingName) {
		this.licensingName = licensingName;
	}

	/**
	 * @return ISSUED_DATE
	 */
	public Date getIssuedDate() {
		return issuedDate;
	}

	/**
	 * @param issuedDate
	 */
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	/**
	 * @return VISA_ORGAN_CODE
	 */
	public String getVisaOrganCode() {
		return visaOrganCode;
	}

	/**
	 * @param visaOrganCode
	 */
	public void setVisaOrganCode(String visaOrganCode) {
		this.visaOrganCode = visaOrganCode;
	}

	/**
	 * @return VISA_ORGAN_NAME
	 */
	public String getVisaOrganName() {
		return visaOrganName;
	}

	/**
	 * @param visaOrganName
	 */
	public void setVisaOrganName(String visaOrganName) {
		this.visaOrganName = visaOrganName;
	}

	/**
	 * @return PROCESS_STATUS
	 */
	public String getProcessStatus() {
		return processStatus;
	}

	/**
	 * @param processStatus
	 */
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	/**
	 * @return BABY_CARD_NO
	 */
	public String getBabyCardNo() {
		return babyCardNo;
	}

	/**
	 * @param babyCardNo
	 */
	public void setBabyCardNo(String babyCardNo) {
		this.babyCardNo = babyCardNo;
	}

	/**
	 * @return CREATE_ORGAN_CODE
	 */
	public String getCreateOrganCode() {
		return createOrganCode;
	}

	/**
	 * @param createOrganCode
	 */
	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	/**
	 * @return CREATE_ORGAN_NAME
	 */
	public String getCreateOrganName() {
		return createOrganName;
	}

	/**
	 * @param createOrganName
	 */
	public void setCreateOrganName(String createOrganName) {
		this.createOrganName = createOrganName;
	}

	/**
	 * @return GATHER_DATE
	 */
	public Date getGatherDate() {
		return gatherDate;
	}

	/**
	 * @param gatherDate
	 */
	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
	}

	/**
	 * @return IS_DELETE
	 */
	public Short getIsDelete() {
		return isDelete;
	}

	/**
	 * @param isDelete
	 */
	public void setIsDelete(Short isDelete) {
		this.isDelete = isDelete;
	}
}