package com.founder.rhip.ehr.entity.women;

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
@Table(name = "WH_MATERNAL_DEATH")
@XmlRootElement(name = "maternalDeath")
public class MaternalDeath implements Serializable {


	private static final long serialVersionUID = -3162207776732323270L;
	
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键|11|", length = 11, nullable = false)
	private Long id;
	
	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|人员ID||", length = 11, nullable = true)
	private Long personId;
	
	@Column(name = "RECORD_NO", columnDefinition = "VARCHAR2|记录表单号||", length = 100, nullable = false)
	private String recordNo;
	
	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 100, nullable = false)
	private String name;
	
	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证件号码||", length = 18, nullable = false)
	private String idcard;
	
	@Column(name = "HR_PROVINCE", columnDefinition = "VARCHAR2|常住地址-省(自治区、直辖市)||", length = 70, nullable = true)
	private String hrProvince;
	
	@Column(name = "HR_CITY", columnDefinition = "VARCHAR2|常住地址-市(地区、州)||", length = 70, nullable = true)
	private String hrCity;

	@Column(name = "HR_COUNTY", columnDefinition = "VARCHAR2|常住地址-县(区)||", length = 70, nullable = true)
	private String hrCounty;

	@Column(name = "HR_TOWN_SHIP", columnDefinition = "VARCHAR2|常住地址-乡(镇、街道办事处)||", length = 70, nullable = true)
	private String hrTownShip;

	@Column(name = "HR_STREET", columnDefinition = "VARCHAR2|常住地址-村(街、路、弄等)||", length = 70, nullable = true)
	private String hrStreet;
	
	@Column(name = "TEMP_PROVINCE", columnDefinition = "VARCHAR2|暂住地址-省(自治区、直辖市)||", length = 70, nullable = true)
	private String tempProvince;
	
	@Column(name = "TEMP_CITY", columnDefinition = "VARCHAR2|暂住地址-市(地区、州)||", length = 70, nullable = true)
	private String tempCity;

	@Column(name = "TEMP_COUNTY", columnDefinition = "VARCHAR2|暂住地址-县(区)||", length = 70, nullable = true)
	private String tempCounty;

	@Column(name = "TEMP_TOWN_SHIP", columnDefinition = "VARCHAR2|暂住地址-乡(镇、街道办事处)||", length = 70, nullable = true)
	private String tempTownShip;

	@Column(name = "TEMP_STREET", columnDefinition = "VARCHAR2|暂住地址-村(街、路、弄等)||", length = 70, nullable = true)
	private String tempStreet;
	
	@Column(name = "TELEPHONE", columnDefinition = "VARCHAR2|电话||", length = 20, nullable = true)
	private String telephone;
	
	@Column(name = "HOUSEHOLD_TYPE", columnDefinition = "VARCHAR2|户籍类型||", length = 10, nullable = true)
	private String householdType;
	
	@Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
	private Date birthday;
	
	@Column(name = "NATION", columnDefinition = "VARCHAR2|民族||", length = 2, nullable = true)
	private String nation;
	
	@Column(name = "EDUCATION", columnDefinition = "VARCHAR2|学历||", length = 2, nullable = true)
	private String education;
	
	@Column(name = "GRAVIDITY_TIMES", columnDefinition = "NUMBER|孕次||", length = 3, nullable = true)
    private Integer gravidityTimes;

    @Column(name = "PRODUCTION_TIMES", columnDefinition = "NUMBER|产次||", length = 3, nullable = true)
    private Integer productionTimes;
	
    @Column(name = "ABORTION_TOTAL_NUMBER", columnDefinition = "NUMBER|流产总次数(次)||", length = 5, nullable = true)
    private Integer abortionTotalNumber;
    
    @Column(name = "LAST_MENSTRUAL_DATE", columnDefinition = "DATE|末次月经日期||", nullable = true)
    private Date lastMenstrualDate;
    
    @Column(name = "DELIVERY_DATE", columnDefinition = "DATE|末次分娩日期||", nullable = true)
    private Date deliveryDate;

    @Column(name = "DEATH_DATE", columnDefinition = "DATE|死亡日期||", nullable = true)
    private Date deathDate;
    
    @Column(name = "DELIVERY_WAY", columnDefinition = "VARCHAR2|分娩方式代码||", length = 2, nullable = true)
    private String deliveryWay;
    
    @Column(name = "DELIVERY_PLACE_CODE", columnDefinition = "VARCHAR2|分娩地点类别代码||", length = 2, nullable = true)
    private String deliveryPlaceCode;
    
    @Column(name = "DEATH_PLACE_CODE", columnDefinition = "VARCHAR2|死亡地点类别代码||", length = 2, nullable = true)
    private String deathPlaceCode;
    
    @Column(name = "MIDWIFERY_PERSON_TYPE", columnDefinition = "VARCHAR2|助产人员类别||", length = 10, nullable = true)
    private String midwiferyPersonType;
    
    @Column(name = "PRENATAL_CHECK_TAG", columnDefinition = "VARCHAR2|产前检查标志||", length = 2, nullable = true)
    private String prenatalCheckTag;
    
    @Column(name = "ANTENATEL_CHECK_NUMBER", columnDefinition = "NUMBER|产检次数(次)||",  nullable = true)
    private Integer antenatelCheckNumber;
    
    @Column(name = "HIGH_DIAGNOSIS_TYPE", columnDefinition = "NUMBER|死亡最高诊断依据类别代码||",  nullable = true)
    private Integer highDiagnosisType;
    
    @Column(name = "DEATH_CAUSE_CODE", columnDefinition = "VARCHAR2|死亡原因代码||", length = 5, nullable = true)
    private String deathCauseCode;
    
    
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
	public String getRecordNo() {
		return recordNo;
	}

	public void setRecordNo(String recordNo) {
		this.recordNo = recordNo;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	@XmlElement
	public String getHrProvince() {
		return hrProvince;
	}

	public void setHrProvince(String hrProvince) {
		this.hrProvince = hrProvince;
	}

	@XmlElement
	public String getHrCity() {
		return hrCity;
	}

	public void setHrCity(String hrCity) {
		this.hrCity = hrCity;
	}

	@XmlElement
	public String getHrCounty() {
		return hrCounty;
	}

	public void setHrCounty(String hrCounty) {
		this.hrCounty = hrCounty;
	}

	@XmlElement
	public String getHrTownShip() {
		return hrTownShip;
	}

	public void setHrTownShip(String hrTownShip) {
		this.hrTownShip = hrTownShip;
	}

	@XmlElement
	public String getHrStreet() {
		return hrStreet;
	}

	public void setHrStreet(String hrStreet) {
		this.hrStreet = hrStreet;
	}

	@XmlElement
	public String getTempProvince() {
		return tempProvince;
	}

	public void setTempProvince(String tempProvince) {
		this.tempProvince = tempProvince;
	}

	@XmlElement
	public String getTempCity() {
		return tempCity;
	}

	public void setTempCity(String tempCity) {
		this.tempCity = tempCity;
	}

	@XmlElement
	public String getTempCounty() {
		return tempCounty;
	}

	public void setTempCounty(String tempCounty) {
		this.tempCounty = tempCounty;
	}

	@XmlElement
	public String getTempTownShip() {
		return tempTownShip;
	}

	public void setTempTownShip(String tempTownShip) {
		this.tempTownShip = tempTownShip;
	}

	@XmlElement
	public String getTempStreet() {
		return tempStreet;
	}

	public void setTempStreet(String tempStreet) {
		this.tempStreet = tempStreet;
	}

	@XmlElement
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@XmlElement
	public String getHouseholdType() {
		return householdType;
	}

	public void setHouseholdType(String householdType) {
		this.householdType = householdType;
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
	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	@XmlElement
	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@XmlElement
	public Integer getGravidityTimes() {
		return gravidityTimes;
	}

	public void setGravidityTimes(Integer gravidityTimes) {
		this.gravidityTimes = gravidityTimes;
	}

	@XmlElement
	public Integer getProductionTimes() {
		return productionTimes;
	}

	public void setProductionTimes(Integer productionTimes) {
		this.productionTimes = productionTimes;
	}

	@XmlElement
	public Integer getAbortionTotalNumber() {
		return abortionTotalNumber;
	}

	public void setAbortionTotalNumber(Integer abortionTotalNumber) {
		this.abortionTotalNumber = abortionTotalNumber;
	}

	@XmlElement
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	public Date getLastMenstrualDate() {
		return lastMenstrualDate;
	}

	public void setLastMenstrualDate(Date lastMenstrualDate) {
		this.lastMenstrualDate = lastMenstrualDate;
	}

	@XmlElement
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
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
	public String getDeliveryWay() {
		return deliveryWay;
	}

	public void setDeliveryWay(String deliveryWay) {
		this.deliveryWay = deliveryWay;
	}

	@XmlElement
	public String getDeliveryPlaceCode() {
		return deliveryPlaceCode;
	}

	public void setDeliveryPlaceCode(String deliveryPlaceCode) {
		this.deliveryPlaceCode = deliveryPlaceCode;
	}

	@XmlElement
	public String getDeathPlaceCode() {
		return deathPlaceCode;
	}

	public void setDeathPlaceCode(String deathPlaceCode) {
		this.deathPlaceCode = deathPlaceCode;
	}

	@XmlElement
	public String getMidwiferyPersonType() {
		return midwiferyPersonType;
	}

	public void setMidwiferyPersonType(String midwiferyPersonType) {
		this.midwiferyPersonType = midwiferyPersonType;
	}

	@XmlElement
	public String getPrenatalCheckTag() {
		return prenatalCheckTag;
	}

	public void setPrenatalCheckTag(String prenatalCheckTag) {
		this.prenatalCheckTag = prenatalCheckTag;
	}

	@XmlElement
	public Integer getAntenatelCheckNumber() {
		return antenatelCheckNumber;
	}

	public void setAntenatelCheckNumber(Integer antenatelCheckNumber) {
		this.antenatelCheckNumber = antenatelCheckNumber;
	}

	@XmlElement
	public Integer getHighDiagnosisType() {
		return highDiagnosisType;
	}

	public void setHighDiagnosisType(Integer highDiagnosisType) {
		this.highDiagnosisType = highDiagnosisType;
	}

	@XmlElement
	public String getDeathCauseCode() {
		return deathCauseCode;
	}

	public void setDeathCauseCode(String deathCauseCode) {
		this.deathCauseCode = deathCauseCode;
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
