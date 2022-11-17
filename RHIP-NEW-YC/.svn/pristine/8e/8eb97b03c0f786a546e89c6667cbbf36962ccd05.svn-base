package com.founder.rhip.ehr.entity.child;


import com.founder.rhip.ehr.common.JaxbDateSerializer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "CH_CHILD_HEALTH_CARD")
@XmlRootElement(name = "childHealthCard")
public class ChildHealthCard implements Serializable {

	private static final long serialVersionUID = 7825015691180384324L;

	@Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;
    
    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;
    
	@Column(name = "MAGE_CARD_NUMBER", columnDefinition = "VARCHAR2|磁卡号||", length = 30, nullable = true)
    private String mageCardNumber;

    @Column(name = "IDCARD_HOS", columnDefinition = "VARCHAR2|医保卡号||", length = 30, nullable = true)
    private String idcardHos;

    @Column(name = "AREA_CODE", columnDefinition = "VARCHAR2|行政区划代码||", length = 12, nullable = true)
    private String areaCode;

    @Column(name = "BUILD_CARD_DATE", columnDefinition = "DATE|建卡日期||", nullable = true)
    private Date buildCardDate;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
    private String name;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证件号码||", length = 18, nullable = true)
    private String idcard;

    @Column(name = "SEX_CODE", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
    private String sexCode;

    @Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
    private Date birthday;

    @Column(name = "GESTATIONAL_WEEKS_WEEK", columnDefinition = "NUMBER|出生孕周-周||", length = 5, nullable = true)
    private Integer gestationalWeeksWeek;

    @Column(name = "GESTATIONAL_WEEKS_DAY", columnDefinition = "NUMBER|出生孕周-天||", length = 5, nullable = true)
    private Integer gestationalWeeksDay;

    @Column(name = "DELIVERY_WAY", columnDefinition = "VARCHAR2|分娩方式代码||", length = 2, nullable = true)
    private String deliveryWay;

    @Column(name = "BIRTH_WEIGHT", columnDefinition = "NUMBER|出生体重(g)||", length = 5, nullable = true)
    private Integer birthWeight;

    @Column(name = "BIRTH_STATURE", columnDefinition = "NUMBER|出生身长(cm)||", scale = 5, precision = 1, nullable = true)
    private BigDecimal birthStature;

    @Column(name = "POLYEMBRYONY_SIGN", columnDefinition = "CHAR|双多胎标志||", length = 1, nullable = true)
    private String polyembryonySign;

    @Column(name = "HOUSEHOLD_TYPE", columnDefinition = "VARCHAR2|常住类型||", length = 1, nullable = true)
    private String householdType;

    @Column(name = "DOMICILE_SIGN", columnDefinition = "CHAR|常住地址户籍标志||", length = 1, nullable = true)
    private String domicileSign;

    @Column(name = "HOUSEHOLD_TYPE_CODE", columnDefinition = "NUMBER|户籍类型代码||", length = 5, nullable = true)
    private Integer householdTypeCode;

    @Column(name = "DOMICILE_CODE", columnDefinition = "VARCHAR2|常住地址类别代码||", length = 1, nullable = true)
    private String domicileCode;

    @Column(name = "HRPROVINCE", columnDefinition = "VARCHAR2|户籍地址-省(自治区、直辖市)||", length = 70, nullable = true)
    private String hrprovince;

    @Column(name = "HRCITY", columnDefinition = "VARCHAR2|户籍地址-市(地区、州)||", length = 70, nullable = true)
    private String hrcity;

    @Column(name = "HRCOUNTY", columnDefinition = "VARCHAR2|户籍地址-县(区)||", length = 70, nullable = true)
    private String hrcounty;

    @Column(name = "HRTOWN_SHIP", columnDefinition = "VARCHAR2|户籍地址-乡(镇、街道办事处)||", length = 70, nullable = true)
    private String hrtownShip;

    @Column(name = "HRSTREET", columnDefinition = "VARCHAR2|户籍地址-村(街、路、弄等)||", length = 70, nullable = true)
    private String hrstreet;

    @Column(name = "HRHOUSE_NUMBER", columnDefinition = "VARCHAR2|户籍地址-门牌号码||", length = 70, nullable = true)
    private String hrhouseNumber;

    @Column(name = "HRPOST_CODE", columnDefinition = "VARCHAR2|户籍地址邮政编码||", length = 6, nullable = true)
    private String hrpostCode;

    @Column(name = "LAPROVINCE", columnDefinition = "VARCHAR2|居住地址-省||", length = 70, nullable = true)
    private String laprovince;

    @Column(name = "LACITY", columnDefinition = "VARCHAR2|居住地址-市||", length = 70, nullable = true)
    private String lacity;

    @Column(name = "LACOUNTY", columnDefinition = "VARCHAR2|居住地址-区县||", length = 70, nullable = true)
    private String lacounty;

    @Column(name = "LATOWN_SHIP", columnDefinition = "VARCHAR2|居住地址-乡镇||", length = 70, nullable = true)
    private String latownShip;

    @Column(name = "LASTREET", columnDefinition = "VARCHAR2|居住地址-村||", length = 70, nullable = true)
    private String lastreet;

    @Column(name = "LAHOUSE_NUMBER", columnDefinition = "VARCHAR2|居住地址-门牌||", length = 70, nullable = true)
    private String lahouseNumber;

    @Column(name = "LAPOST_CODE", columnDefinition = "VARCHAR2|居住地址邮政编码||", length = 6, nullable = true)
    private String lapostCode;

    @Column(name = "MOTHER_NAME", columnDefinition = "VARCHAR2|母亲姓名||", length = 30, nullable = true)
    private String motherName;

    @Column(name = "MOTHER_BIRTHDAY", columnDefinition = "DATE|母亲出生日期||", nullable = true)
    private Date motherBirthday;

    @Column(name = "MOTHER_NATION", columnDefinition = "VARCHAR2|母亲民族||", length = 2, nullable = true)
    private String motherNation;

    @Column(name = "MOTHER_UNIT_NAME", columnDefinition = "VARCHAR2|母亲工作单位名称||", length = 70, nullable = true)
    private String motherUnitName;

    @Column(name = "MOTHER_IDCARD", columnDefinition = "VARCHAR2|母亲身份证号码||", length = 18, nullable = true)
    private String motherIdcard;

    @Column(name = "FATHER_NAME", columnDefinition = "VARCHAR2|父亲姓名||", length = 30, nullable = true)
    private String fatherName;

    @Column(name = "FATHER_BIRTHDAY", columnDefinition = "DATE|父亲出生日期||", nullable = true)
    private Date fatherBirthday;

    @Column(name = "FATHER_NATION", columnDefinition = "VARCHAR2|父亲民族||", length = 2, nullable = true)
    private String fatherNation;

    @Column(name = "FATHER_UNIT_NAME", columnDefinition = "VARCHAR2|父亲工作单位名称||", length = 70, nullable = true)
    private String fatherUnitName;

    @Column(name = "FATHER_IDCARD", columnDefinition = "VARCHAR2|父亲身份证号码||", length = 18, nullable = true)
    private String fatherIdcard;

    @Column(name = "GUARDIAN", columnDefinition = "VARCHAR2|监护人姓名||", length = 50, nullable = true)
    private String guardian;

    @Column(name = "GUARDIAN_AGE", columnDefinition = "NUMBER|监护人年龄||", length = 3, nullable = true)
    private Integer guardianAge;

    @Column(name = "GUARDIAN_NATION", columnDefinition = "VARCHAR2|监护人民族||", length = 2, nullable = true)
    private String guardianNation;

    @Column(name = "GUARDIAN_UNIT_NAME", columnDefinition = "VARCHAR2|监护人工作单位名称||", length = 70, nullable = true)
    private String guardianUnitName;

    @Column(name = "PHONE", columnDefinition = "VARCHAR2|联系电话||", length = 20, nullable = true)
    private String phone;

    @Column(name = "RISK_FACTORS_CODE", columnDefinition = "VARCHAR2|高危因素代码||", length = 2, nullable = true)
    private String riskFactorsCode;

    @Column(name = "SUNSHINE", columnDefinition = "CHAR|是否参加母婴阳光工程（1是0否）||", length = 1, nullable = true)
    private String sunshine;

    @Column(name = "TREASURE", columnDefinition = "CHAR|是否开通母婴宝（1是0否）||", length = 1, nullable = true)
    private String treasure;

    @Column(name = "INPUT_ORGAN_CODE", columnDefinition = "VARCHAR2|建档机构编码||", length = 15, nullable = true)
    private String inputOrganCode;

    @Column(name = "INPUT_ORGAN_NAME", columnDefinition = "VARCHAR2|建档机构名称||", length = 70, nullable = true)
    private String inputOrganName;

    @Column(name = "INPUT_NAME", columnDefinition = "VARCHAR2|建档人员姓名||", length = 30, nullable = true)
    private String inputName;
    
    @Column(name = "INPUT_JOB_NUMBER", columnDefinition = "VARCHAR2|建档人员工号||", length = 50, nullable = true)
    private String inputJobNumber;
    
    @Column(name = "INPUT_IDCARD", columnDefinition = "VARCHAR2|建档人员身份证||", length = 18, nullable = true)
    private String inputIdcard;

    @Column(name = "INPUT_DATE", columnDefinition = "DATE|建档日期||", nullable = true)
    private Date inputDate;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;
    
	@Column(name = "BABY_CARD_NO", columnDefinition = "VARCHAR2|宝宝卡号||", length = 13, nullable = true)
	private String babyCardNo;
	
	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构代码||", length = 20, nullable = true)
	private String createOrganCode;
	
	@Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 70, nullable = true)
	private String createOrganName;
	
	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;

    @Column(name = "DEBILITY_CHILDREN_FLAG", columnDefinition = "CHAR|体弱儿童标志,1:是,2:否||", length = 1, nullable = true)
    private String debilityChildrenFlag;

    @Column(name = "DEFORMITY_FLAG", columnDefinition = "VARCHAR2|畸形标志,1:是,2:否||", length = 2, nullable = true)
    private String deformityFlag;

    @Column(name = "DEFORMITY_DESC", columnDefinition = "VARCHAR2|畸形描述||", length = 100, nullable = true)
    private String deformityDesc;
    
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @XmlElement
    public String getMageCardNumber() {
        return this.mageCardNumber;
    }

    public void setMageCardNumber(String mageCardNumber) {
        this.mageCardNumber = mageCardNumber;
    }

    @XmlElement
    public String getIdcardHos() {
        return this.idcardHos;
    }

    public void setIdcardHos(String idcardHos) {
        this.idcardHos = idcardHos;
    }

    @XmlElement
    public String getAreaCode() {
        return this.areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    public Date getBuildCardDate() {
        return this.buildCardDate;
    }

    public void setBuildCardDate(Date buildCardDate) {
        this.buildCardDate = buildCardDate;
    }

    @XmlElement
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getIdcard() {
        return this.idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    @XmlElement
    public String getSexCode() {
        return this.sexCode;
    }

    public void setSexCode(String sexCode) {
        this.sexCode = sexCode;
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
    public Integer getGestationalWeeksWeek() {
        return this.gestationalWeeksWeek;
    }

    public void setGestationalWeeksWeek(Integer gestationalWeeksWeek) {
        this.gestationalWeeksWeek = gestationalWeeksWeek;
    }

    @XmlElement
    public Integer getGestationalWeeksDay() {
        return this.gestationalWeeksDay;
    }

    public void setGestationalWeeksDay(Integer gestationalWeeksDay) {
        this.gestationalWeeksDay = gestationalWeeksDay;
    }

    @XmlElement
    public String getDeliveryWay() {
        return this.deliveryWay;
    }

    public void setDeliveryWay(String deliveryWay) {
        this.deliveryWay = deliveryWay;
    }

    @XmlElement
    public Integer getBirthWeight() {
        return this.birthWeight;
    }

    public void setBirthWeight(Integer birthWeight) {
        this.birthWeight = birthWeight;
    }

    @XmlElement
    public BigDecimal getBirthStature() {
        return this.birthStature;
    }

    public void setBirthStature(BigDecimal birthStature) {
        this.birthStature = birthStature;
    }

    @XmlElement
    public String getPolyembryonySign() {
        return this.polyembryonySign;
    }

    public void setPolyembryonySign(String polyembryonySign) {
        this.polyembryonySign = polyembryonySign;
    }

    @XmlElement
    public String getHouseholdType() {
        return this.householdType;
    }

    public void setHouseholdType(String householdType) {
        this.householdType = householdType;
    }

    @XmlElement
    public String getDomicileSign() {
        return this.domicileSign;
    }

    public void setDomicileSign(String domicileSign) {
        this.domicileSign = domicileSign;
    }

    @XmlElement
    public Integer getHouseholdTypeCode() {
        return this.householdTypeCode;
    }

    public void setHouseholdTypeCode(Integer householdTypeCode) {
        this.householdTypeCode = householdTypeCode;
    }

    @XmlElement
    public String getDomicileCode() {
        return this.domicileCode;
    }

    public void setDomicileCode(String domicileCode) {
        this.domicileCode = domicileCode;
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
    public String getHrpostCode() {
        return this.hrpostCode;
    }

    public void setHrpostCode(String hrpostCode) {
        this.hrpostCode = hrpostCode;
    }

    @XmlElement
    public String getLaprovince() {
        return this.laprovince;
    }

    public void setLaprovince(String laprovince) {
        this.laprovince = laprovince;
    }

    @XmlElement
    public String getLacity() {
        return this.lacity;
    }

    public void setLacity(String lacity) {
        this.lacity = lacity;
    }

    @XmlElement
    public String getLacounty() {
        return this.lacounty;
    }

    public void setLacounty(String lacounty) {
        this.lacounty = lacounty;
    }

    @XmlElement
    public String getLatownShip() {
        return this.latownShip;
    }

    public void setLatownShip(String latownShip) {
        this.latownShip = latownShip;
    }

    @XmlElement
    public String getLastreet() {
        return this.lastreet;
    }

    public void setLastreet(String lastreet) {
        this.lastreet = lastreet;
    }

    @XmlElement
    public String getLahouseNumber() {
        return this.lahouseNumber;
    }

    public void setLahouseNumber(String lahouseNumber) {
        this.lahouseNumber = lahouseNumber;
    }

    @XmlElement
    public String getLapostCode() {
        return this.lapostCode;
    }

    public void setLapostCode(String lapostCode) {
        this.lapostCode = lapostCode;
    }

    @XmlElement
    public String getMotherName() {
        return this.motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    public Date getMotherBirthday() {
        return this.motherBirthday;
    }

    public void setMotherBirthday(Date motherBirthday) {
        this.motherBirthday = motherBirthday;
    }

    @XmlElement
    public String getMotherNation() {
        return this.motherNation;
    }

    public void setMotherNation(String motherNation) {
        this.motherNation = motherNation;
    }

    @XmlElement
    public String getMotherUnitName() {
        return this.motherUnitName;
    }

    public void setMotherUnitName(String motherUnitName) {
        this.motherUnitName = motherUnitName;
    }

    @XmlElement
    public String getFatherName() {
        return this.fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    public Date getFatherBirthday() {
        return this.fatherBirthday;
    }

    public void setFatherBirthday(Date fatherBirthday) {
        this.fatherBirthday = fatherBirthday;
    }

    @XmlElement
    public String getFatherNation() {
        return this.fatherNation;
    }

    public void setFatherNation(String fatherNation) {
        this.fatherNation = fatherNation;
    }

    @XmlElement
    public String getFatherUnitName() {
        return this.fatherUnitName;
    }

    public void setFatherUnitName(String fatherUnitName) {
        this.fatherUnitName = fatherUnitName;
    }

    @XmlElement(name = "motherIdCard")
    public String getMotherIdcard() {
		return motherIdcard;
	}

	public void setMotherIdcard(String motherIdcard) {
		this.motherIdcard = motherIdcard;
	}

	@XmlElement(name = "fatherIdCard")
	public String getFatherIdcard() {
		return fatherIdcard;
	}

	public void setFatherIdcard(String fatherIdcard) {
		this.fatherIdcard = fatherIdcard;
	}

	@XmlElement
    public String getGuardian() {
        return this.guardian;
    }

    public void setGuardian(String guardian) {
        this.guardian = guardian;
    }

    @XmlElement
    public Integer getGuardianAge() {
        return this.guardianAge;
    }

    public void setGuardianAge(Integer guardianAge) {
        this.guardianAge = guardianAge;
    }

    @XmlElement
    public String getGuardianNation() {
        return this.guardianNation;
    }

    public void setGuardianNation(String guardianNation) {
        this.guardianNation = guardianNation;
    }

    @XmlElement
    public String getGuardianUnitName() {
        return this.guardianUnitName;
    }

    public void setGuardianUnitName(String guardianUnitName) {
        this.guardianUnitName = guardianUnitName;
    }

    @XmlElement
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @XmlElement
    public String getRiskFactorsCode() {
        return this.riskFactorsCode;
    }

    public void setRiskFactorsCode(String riskFactorsCode) {
        this.riskFactorsCode = riskFactorsCode;
    }

    @XmlElement
    public String getSunshine() {
        return this.sunshine;
    }

    public void setSunshine(String sunshine) {
        this.sunshine = sunshine;
    }

    @XmlElement
    public String getTreasure() {
        return this.treasure;
    }

    public void setTreasure(String treasure) {
        this.treasure = treasure;
    }

    @XmlElement
    public String getInputOrganCode() {
        return this.inputOrganCode;
    }

    public void setInputOrganCode(String inputOrganCode) {
        this.inputOrganCode = inputOrganCode;
    }

    @XmlElement
    public String getInputOrganName() {
        return this.inputOrganName;
    }

    public void setInputOrganName(String inputOrganName) {
        this.inputOrganName = inputOrganName;
    }

    @XmlElement
    public String getInputName() {
        return this.inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    public Date getInputDate() {
        return this.inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
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

	public Date getGatherDate() {
		return gatherDate;
	}

	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
	}

	public String getInputJobNumber() {
		return inputJobNumber;
	}

	public void setInputJobNumber(String inputJobNumber) {
		this.inputJobNumber = inputJobNumber;
	}

	public String getInputIdcard() {
		return inputIdcard;
	}

	public void setInputIdcard(String inputIdcard) {
		this.inputIdcard = inputIdcard;
	}

    public String getDebilityChildrenFlag() {
        return debilityChildrenFlag;
    }

    public void setDebilityChildrenFlag(String debilityChildrenFlag) {
        this.debilityChildrenFlag = debilityChildrenFlag;
    }

    public String getDeformityFlag() {
        return deformityFlag;
    }

    public void setDeformityFlag(String deformityFlag) {
        this.deformityFlag = deformityFlag;
    }

    public String getDeformityDesc() {
        return deformityDesc;
    }

    public void setDeformityDesc(String deformityDesc) {
        this.deformityDesc = deformityDesc;
    }
}
