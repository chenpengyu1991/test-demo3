package com.founder.rhip.ehr.entity.management.mhm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MHM_BASICS_INFO")
public class MhmBasicsInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "EVENT_ID", columnDefinition = "NUMBER|本系统唯一编码|11|", length = 11, nullable = false)
	private Long eventId;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|病人姓名|50|", length = 50, nullable = true)
	private String name;

	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证号|18|", length = 18, nullable = true)
	private String idcard;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别|1|", length = 1, nullable = true)
	private String gender;

	@Column(name = "BIRTHDATE", columnDefinition = "DATE|出生日期||", nullable = true)
	private Date birthdate;

	@Column(name = "AGE", columnDefinition = "NUMBER|年龄|3|", length = 3, nullable = true)
	private Integer age;

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

	@Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|现居住地门牌号|100|", length = 100, nullable = true)
	private String pahouseNumber;

	@Column(name = "PARENTS_NAME", columnDefinition = "VARCHAR2|家长或监护人姓名|50|", length = 50, nullable = true)
	private String parentsName;

	@Column(name = "UNIT_NAME", columnDefinition = "VARCHAR2|工作或学习单位|100|", length = 100, nullable = true)
	private String unitName;

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

	@Column(name = "HRHOUSE_NUMBER", columnDefinition = "VARCHAR2|户口所在地门牌号|100|", length = 100, nullable = true)
	private String hrhouseNumber;

	@Column(name = "NATION", columnDefinition = "VARCHAR2|民族|2|", length = 2, nullable = true)
	private String nation;

	@Column(name = "FLOAT_POPULATION", columnDefinition = "VARCHAR2|是否流动人口|2|", length = 2, nullable = true)
	private String floatPopulation;

	@Column(name = "OCCUPATION_OTHER", columnDefinition = "VARCHAR2|职业-其他|100|", length = 100, nullable = true)
	private String occupationOther;

	@Column(name = "CONTACT_NAME", columnDefinition = "VARCHAR2|联系人|50|", length = 50, nullable = true)
	private String contactName;

	@Column(name = "CONTACT_PHONE", columnDefinition = "VARCHAR2|联系电话|20|", length = 20, nullable = true)
	private String contactPhone;

	@Column(name = "FAMILY_PHONE", columnDefinition = "VARCHAR2|家庭电话|20|", length = 20, nullable = true)
	private String familyPhone;

	@Column(name = "RELATION", columnDefinition = "VARCHAR2|与户主关系|2|", length = 2, nullable = true)
	private String relation;

	@Column(name = "EDUCATION", columnDefinition = "VARCHAR2|患者文化程度|11|", length = 11, nullable = true)
	private String education;

	@Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况|2|", length = 2, nullable = true)
	private String marriage;

	@Column(name = "HEAD_HOUSEHOLD_NAME", columnDefinition = "VARCHAR2|户主姓名|50|", length = 50, nullable = true)
	private String headHouseholdName;

	@Column(name = "GUARDER_RELATION_CODE", columnDefinition = "VARCHAR2|与监护人关系|20|", length = 20, nullable = true)
	private String guarderRelationCode;

	@Column(name = "PA_GBCODE", columnDefinition = "VARCHAR2|现住址国标码|20|", length = 20, nullable = true)
	private String paGbcode;

	@Column(name = "HR_GBCODE", columnDefinition = "VARCHAR2|户籍国标码|20|", length = 20, nullable = true)
	private String hrGbcode;

	@Column(name = "FORMER_NAME", columnDefinition = "VARCHAR2|曾用名|50|", length = 50, nullable = true)
	private String formerName;

	@Column(name = "PA_ADDRESS", columnDefinition = "VARCHAR2|现住址详细|100|", length = 100, nullable = true)
	private String paAddress;

	@Column(name = "HR_ADDRESS", columnDefinition = "VARCHAR2|户籍详细|100|", length = 100, nullable = true)
	private String hrAddress;

	@Column(name = "PA_POLICE_STATION", columnDefinition = "VARCHAR2|现地址派出所|100|", length = 100, nullable = true)
	private String paPoliceStation;

	@Column(name = "HR_POLICE_STATION", columnDefinition = "VARCHAR2|户籍地派出所|100|", length = 100, nullable = true)
	private String hrPoliceStation;

	@Column(name = "GUARDER_IDCARD", columnDefinition = "VARCHAR2|监护人身份证号|18|", length = 18, nullable = true)
	private String guarderIdcard;

	@Column(name = "GUARDER_ADDRESS", columnDefinition = "VARCHAR2|监护人地址|100|", length = 100, nullable = true)
	private String guarderAddress;

	@Column(name = "GUARDER_PHONE", columnDefinition = "VARCHAR2|监护人电话|20|", length = 20, nullable = true)
	private String guarderPhone;

	@Column(name = "GUARDER_SERVICE_CENTER", columnDefinition = "VARCHAR2|监护人服务处所|100|", length = 100, nullable = true)
	private String guarderServiceCenter;

	@Column(name = "VICEROYSHIP", columnDefinition = "VARCHAR2|所属辖区|100|", length = 100, nullable = true)
	private String viceroyship;

	@Column(name = "PATIENT_RESOURCE", columnDefinition = "VARCHAR2|病人来源|2|", length = 2, nullable = true)
	private String patientResource;

    @Column(name = "VICEROYSHIP_CONTACT", columnDefinition = "VARCHAR2|辖区村(居)委会联系人|50|", length = 50, nullable = true)
    private String viceroyshipContact;

    @Column(name = "VICEROYSHIP_TEL", columnDefinition = "VARCHAR2|辖区村(居)委会联系电话|20|", length = 20, nullable = true)
    private String viceroyshipTel;
    
    @Column(name = "PA_GROUP", columnDefinition = "VARCHAR2|现住址小组地址||", length = 2, nullable = true)
	private String paGroup;
    
    @Column(name = "HR_GROUP", columnDefinition = "VARCHAR2|户籍地址小组地址||", length = 2, nullable = true)
	private String hrGroup;
    
    @Column(name = "household", columnDefinition = "VARCHAR2|户别||", length = 2, nullable = true)
	private String household;
    
    
    public String getHousehold() {
		return household;
	}

	public void setHousehold(String household) {
		this.household = household;
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

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEventId() {
		return this.eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
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

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
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
		return this.pahouseNumber;
	}

	public void setPahouseNumber(String pahouseNumber) {
		this.pahouseNumber = pahouseNumber;
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

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getFloatPopulation() {
		return this.floatPopulation;
	}

	public void setFloatPopulation(String floatPopulation) {
		this.floatPopulation = floatPopulation;
	}

	public String getOccupationOther() {
		return this.occupationOther;
	}

	public void setOccupationOther(String occupationOther) {
		this.occupationOther = occupationOther;
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

	public String getFamilyPhone() {
		return this.familyPhone;
	}

	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
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

	public String getHeadHouseholdName() {
		return this.headHouseholdName;
	}

	public void setHeadHouseholdName(String headHouseholdName) {
		this.headHouseholdName = headHouseholdName;
	}

	public String getGuarderRelationCode() {
		return this.guarderRelationCode;
	}

	public void setGuarderRelationCode(String guarderRelationCode) {
		this.guarderRelationCode = guarderRelationCode;
	}

	public String getPaGbcode() {
		return this.paGbcode;
	}

	public void setPaGbcode(String paGbcode) {
		this.paGbcode = paGbcode;
	}

	public String getHrGbcode() {
		return this.hrGbcode;
	}

	public void setHrGbcode(String hrGbcode) {
		this.hrGbcode = hrGbcode;
	}

	public String getFormerName() {
		return this.formerName;
	}

	public void setFormerName(String formerName) {
		this.formerName = formerName;
	}

	public String getPaAddress() {
		return this.paAddress;
	}

	public void setPaAddress(String paAddress) {
		this.paAddress = paAddress;
	}

	public String getHrAddress() {
		return this.hrAddress;
	}

	public void setHrAddress(String hrAddress) {
		this.hrAddress = hrAddress;
	}

	public String getPaPoliceStation() {
		return this.paPoliceStation;
	}

	public void setPaPoliceStation(String paPoliceStation) {
		this.paPoliceStation = paPoliceStation;
	}

	public String getHrPoliceStation() {
		return this.hrPoliceStation;
	}

	public void setHrPoliceStation(String hrPoliceStation) {
		this.hrPoliceStation = hrPoliceStation;
	}

	public String getGuarderIdcard() {
		return this.guarderIdcard;
	}

	public void setGuarderIdcard(String guarderIdcard) {
		this.guarderIdcard = guarderIdcard;
	}

	public String getGuarderAddress() {
		return this.guarderAddress;
	}

	public void setGuarderAddress(String guarderAddress) {
		this.guarderAddress = guarderAddress;
	}

	public String getGuarderPhone() {
		return this.guarderPhone;
	}

	public void setGuarderPhone(String guarderPhone) {
		this.guarderPhone = guarderPhone;
	}

	public String getGuarderServiceCenter() {
		return this.guarderServiceCenter;
	}

	public void setGuarderServiceCenter(String guarderServiceCenter) {
		this.guarderServiceCenter = guarderServiceCenter;
	}

	public String getViceroyship() {
		return this.viceroyship;
	}

	public void setViceroyship(String viceroyship) {
		this.viceroyship = viceroyship;
	}

	public String getPatientResource() {
		return patientResource;
	}

	public void setPatientResource(String patientResource) {
		this.patientResource = patientResource;
	}

    public String getViceroyshipContact() {
        return viceroyshipContact;
    }

    public void setViceroyshipContact(String viceroyshipContact) {
        this.viceroyshipContact = viceroyshipContact;
    }

    public String getViceroyshipTel() {
        return viceroyshipTel;
    }

    public void setViceroyshipTel(String viceroyshipTel) {
        this.viceroyshipTel = viceroyshipTel;
    }
}