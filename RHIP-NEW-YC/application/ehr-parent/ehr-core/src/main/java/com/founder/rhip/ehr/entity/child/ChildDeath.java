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
import java.util.Date;

@Entity
@Table(name = "CH_CHILD_DEATH")
@XmlRootElement(name = "childDeath")
public class ChildDeath implements Serializable {

	private static final long serialVersionUID = 1064263797131887102L;
	
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键|11|", length = 11, nullable = false)
	private Long id;
	
	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|人员ID||", length = 11, nullable = true)
	private Long personId;
	
	@Column(name = "CHILD_NAME", columnDefinition = "VARCHAR2|儿童姓名||", length = 100, nullable = false)
	private String childName;
	
	@Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
	private Date birthday;
	
	@Column(name = "DEATH_DATE", columnDefinition = "DATE|死亡日期||", nullable = true)
	private Date deathDate;
	
	@Column(name = "DEATH_AGE_YEAR", columnDefinition = "NUMBER|死亡年龄（岁）||", length = 5, nullable = true)
	private Integer deathAgeYear;
	
	@Column(name = "DEATH_AGE_MONTH", columnDefinition = "NUMBER|死亡年龄（月）||", length = 5, nullable = true)
	private Integer deathAgeMonth;
	
	@Column(name = "DEATH_AGE_DAY", columnDefinition = "NUMBER|死亡年龄（天）||", length = 5, nullable = true)
	private Integer deathAgeDay;
	
	@Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|现住址一乡(镇、街道办事处)||", length = 100, nullable = false)
	private String patownShip;
	
	@Column(name = "HOUSEHOLD_TYPE_CODE", columnDefinition = "NUMBER|户籍类型代码||", length = 5, nullable = true)
	private Integer householdTypeCode;
	
	@Column(name = "MOTHER_IDCARD", columnDefinition = "VARCHAR2|母亲身份证||", length = 18, nullable = false)
	private String motherIdcard;
	
	@Column(name = "MOTHER_NAME", columnDefinition = "VARCHAR2|母亲姓名||", length = 18, nullable = false)
	private String motherName;
	
	@Column(name = "FATHER_IDCARD", columnDefinition = "VARCHAR2|父亲身份证||", length = 18, nullable = false)
	private String fatherIdcard;
	
	@Column(name = "FATHER_NAME", columnDefinition = "VARCHAR2|父亲姓名||", length = 18, nullable = false)
	private String fatherName;
	
	@Column(name = "BABY_CARD_NO", columnDefinition = "VARCHAR2|宝宝卡号||", length = 13, nullable = true)
	private String babyCardNo;
	
	@Column(name = "COUNTY", columnDefinition = "VARCHAR2|地址-县(区)||", length = 250, nullable = true)
	private String county;

	@Column(name = "TOWN_SHIP", columnDefinition = "VARCHAR2|地址-乡(镇、街道办事处)||", length = 250, nullable = true)
	private String townShip;
	
	@Column(name = "STREET", columnDefinition = "VARCHAR2|地址-村(街、路、弄等)||", length = 250, nullable = true)
	private String street;
	
	@Column(name = "HOUSE_NUMBER", columnDefinition = "VARCHAR2|门牌号码||", length = 50, nullable = true)
	private String houseNumber;
	
	@Column(name = "PHONE", columnDefinition = "VARCHAR2|联系电话||", length = 20, nullable = true)
	private String phone;
	
	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
	private String gender;
	
	@Column(name = "GESTATIONAL_WEEKS_WEEK", columnDefinition = "NUMBER|出生孕周||", length = 5, nullable = true)
	private Integer gestationalWeeksWeek;
	
	@Column(name = "BIRTH_WEIGHT", columnDefinition = "NUMBER|出生体重(g)||", length = 5, nullable = true)
	private Integer birthWeight;
	
	@Column(name = "DELIVERY_PLACE_TYPE", columnDefinition = "VARCHAR2|出生地类别代码||", length = 20, nullable = true)
	private String deliveryPlaceType;
	
    @Column(name = "DIAGNOSIS_CODE", columnDefinition = "VARCHAR2|诊断代码||", length = 5, nullable = true)
    private String diagnosisCode;
    
    @Column(name = "DEATH_CAUSE_CODE", columnDefinition = "VARCHAR2|死亡原因代码||", length = 5, nullable = true)
    private String deathCauseCode;
    
    @Column(name = "DEATH_PLACE_CODE", columnDefinition = "VARCHAR2|死亡地点类别代码||", length = 5, nullable = true)
    private String deathPlaceCode;
    
    @Column(name = "DIAGNOSIS_TYPE_CODE", columnDefinition = "VARCHAR2|治疗类别代码||", length = 5, nullable = true)
    private String diagnosisTypeCode;
    
    @Column(name = "DIAGNOSIS_LEVEL", columnDefinition = "VARCHAR2|诊断级别代码||", length = 5, nullable = true)
    private String diagnosisLevel;
    
    @Column(name = "FILL_UNIT_CODE", columnDefinition = "VARCHAR2|填报单位编码||", length = 50, nullable = true)
    private String fillUnitCode;
    
    @Column(name = "FILL_UNIT_NAME", columnDefinition = "VARCHAR2|填报单位名称||", length = 50, nullable = true)
    private String fillUnitName;
    
    @Column(name = "FILL_AUTHOR", columnDefinition = "VARCHAR2|填报人||", length = 50, nullable = true)
    private String fillAuthor;
    
    @Column(name = "FILL_TIME", columnDefinition = "VARCHAR2|填报日期||", nullable = true)
    private Date fillTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement
	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	@XmlElement
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@XmlElement
	public Integer getDeathAgeYear() {
		return deathAgeYear;
	}

	public void setDeathAgeYear(Integer deathAgeYear) {
		this.deathAgeYear = deathAgeYear;
	}

	@XmlElement
	public Integer getDeathAgeMonth() {
		return deathAgeMonth;
	}

	public void setDeathAgeMonth(Integer deathAgeMonth) {
		this.deathAgeMonth = deathAgeMonth;
	}

	@XmlElement
	public Integer getDeathAgeDay() {
		return deathAgeDay;
	}

	public void setDeathAgeDay(Integer deathAgeDay) {
		this.deathAgeDay = deathAgeDay;
	}

	@XmlElement
	public String getPatownShip() {
		return patownShip;
	}

	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}
	
	@XmlElement
	public String getMotherIdcard() {
		return motherIdcard;
	}

	public void setMotherIdcard(String motherIdcard) {
		this.motherIdcard = motherIdcard;
	}

	@XmlElement
	public String getFatherIdcard() {
		return fatherIdcard;
	}

	public void setFatherIdcard(String fatherIdcard) {
		this.fatherIdcard = fatherIdcard;
	}

	@XmlElement
	public String getBabyCardNo() {
		return babyCardNo;
	}

	public void setBabyCardNo(String babyCardNo) {
		this.babyCardNo = babyCardNo;
	}

	@XmlElement
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	@XmlElement
	public Integer getHouseholdTypeCode() {
		return householdTypeCode;
	}

	public void setHouseholdTypeCode(Integer householdTypeCode) {
		this.householdTypeCode = householdTypeCode;
	}

	@XmlElement
	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	@XmlElement
	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	@XmlElement
	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	@XmlElement
	public String getTownShip() {
		return townShip;
	}

	public void setTownShip(String townShip) {
		this.townShip = townShip;
	}

	@XmlElement
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@XmlElement
	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	@XmlElement
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@XmlElement
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@XmlElement
	public Integer getGestationalWeeksWeek() {
		return gestationalWeeksWeek;
	}

	public void setGestationalWeeksWeek(Integer gestationalWeeksWeek) {
		this.gestationalWeeksWeek = gestationalWeeksWeek;
	}

	@XmlElement
	public Integer getBirthWeight() {
		return birthWeight;
	}

	public void setBirthWeight(Integer birthWeight) {
		this.birthWeight = birthWeight;
	}

	@XmlElement
	public String getDeliveryPlaceType() {
		return deliveryPlaceType;
	}

	public void setDeliveryPlaceType(String deliveryPlaceType) {
		this.deliveryPlaceType = deliveryPlaceType;
	}

	@XmlElement
	public String getDiagnosisCode() {
		return diagnosisCode;
	}

	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}

	@XmlElement
	public String getDeathCauseCode() {
		return deathCauseCode;
	}

	public void setDeathCauseCode(String deathCauseCode) {
		this.deathCauseCode = deathCauseCode;
	}

	@XmlElement
	public String getDeathPlaceCode() {
		return deathPlaceCode;
	}

	public void setDeathPlaceCode(String deathPlaceCode) {
		this.deathPlaceCode = deathPlaceCode;
	}

	@XmlElement
	public String getDiagnosisTypeCode() {
		return diagnosisTypeCode;
	}

	public void setDiagnosisTypeCode(String diagnosisTypeCode) {
		this.diagnosisTypeCode = diagnosisTypeCode;
	}

	@XmlElement
	public String getDiagnosisLevel() {
		return diagnosisLevel;
	}

	public void setDiagnosisLevel(String diagnosisLevel) {
		this.diagnosisLevel = diagnosisLevel;
	}

	@XmlElement
	public String getFillUnitCode() {
		return fillUnitCode;
	}

	public void setFillUnitCode(String fillUnitCode) {
		this.fillUnitCode = fillUnitCode;
	}

	@XmlElement
	public String getFillUnitName() {
		return fillUnitName;
	}

	public void setFillUnitName(String fillUnitName) {
		this.fillUnitName = fillUnitName;
	}

	@XmlElement
	public String getFillAuthor() {
		return fillAuthor;
	}

	public void setFillAuthor(String fillAuthor) {
		this.fillAuthor = fillAuthor;
	}

	@XmlElement
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	public Date getFillTime() {
		return fillTime;
	}

	public void setFillTime(Date fillTime) {
		this.fillTime = fillTime;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	 
	

}
