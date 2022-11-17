package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import com.founder.fasf.util.StringUtil;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "IDM_LIST_EH")
public class ListEh implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Integer id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
	private Integer idmId;

	@Column(name = "FARM_NAME", columnDefinition = "VARCHAR2|养殖场名称||", length = 200, nullable = true)
	private String farmName;

	@Column(name = "ANIMAL_TYPE", columnDefinition = "VARCHAR2|动物种类||", length = 200, nullable = true)
	private String animalType;

	@Column(name = "ANIMAL_NUM", columnDefinition = "VARCHAR2|饲养数量||", length = 100, nullable = true)
	private String animalNum;

	@Column(name = "DIE_NUM", columnDefinition = "VARCHAR2|病死数量||", length = 100, nullable = true)
	private String dieNum;

	@Column(name = "DIE_DT", columnDefinition = "DATE|病死时间||", nullable = true)
	private Date dieDt;

	@Column(name = "PROCESS_MODE", columnDefinition = "VARCHAR2|处理方式||", length = 200, nullable = true)
	private String processMode;

	@Column(name = "PROCESS_DT", columnDefinition = "DATE|处理时间||", nullable = true)
	private Date processDt;

	@Column(name = "PROCESS_NUM", columnDefinition = "VARCHAR2|参与处理人员数量||", length = 100, nullable = true)
	private String processNum;

	@Column(name = "FAMILY_NUM", columnDefinition = "VARCHAR2|总户数||", length = 100, nullable = true)
	private String familyNum;

	@Column(name = "PEOPLE_NUM", columnDefinition = "VARCHAR2|总人口数||", length = 100, nullable = true)
	private String peopleNum;

	@Column(name = "PERMANENT_POPULATION", columnDefinition = "VARCHAR2|常住人口||", length = 100, nullable = true)
	private String permanentPopulation;

	@Column(name = "FOWL_FAMILY_NUM", columnDefinition = "VARCHAR2|饲养家禽户数||", length = 100, nullable = true)
	private String fowlFamilyNum;

	@Column(name = "FOWL_PEOPLE_NUM", columnDefinition = "VARCHAR2|饲养家禽户人口数||", length = 100, nullable = true)
	private String fowlPeopleNum;

	@Column(name = "DIE_FOWL_NUM", columnDefinition = "VARCHAR2|病死家禽户数||", length = 100, nullable = true)
	private String dieFowlNum;

	@Column(name = "EXCEPTION_NUM", columnDefinition = "VARCHAR2|异常表现人数||", length = 100, nullable = true)
	private String exceptionNum;

	@Column(name = "PCR", columnDefinition = "VARCHAR2|分离(PCR)阳性标本类型||", length = 200, nullable = true)
	private String pcr;

	@Column(name = "SAMPLE_ADDR", columnDefinition = "VARCHAR2|采集地点||", length = 200, nullable = true)
	private String sampleAddr;

	@Column(name = "SAMPLE_DT", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date sampleDt;

	@Column(name = "SEPARATE_DT", columnDefinition = "DATE|分离时间||", nullable = true)
	private Date separateDt;

	@Column(name = "SEPARATE_UNIT", columnDefinition = "VARCHAR2|分离单位||", length = 200, nullable = true)
	private String separateUnit;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|病例姓名||", length = 100, nullable = true)
	private String name;

	@Column(name = "SEX", columnDefinition = "VARCHAR2|性别||", length = 2, nullable = true)
	private String sex;

	@Column(name = "AGE", columnDefinition = "VARCHAR2|年龄||", length = 100, nullable = true)
	private String age;

	@Column(name = "CLINICAL_MANIFESTATION", columnDefinition = "VARCHAR2|临床表现||", length = 200, nullable = true)
	private String clinicalManifestation;

	@Column(name = "SAVE_DIE_DT", columnDefinition = "DATE|并发死亡时间||", nullable = true)
	private Date saveDieDt;

	@Column(name = "CONTACT", columnDefinition = "VARCHAR2|有无接触及时间||", length = 200, nullable = true)
	private String contact;

	@Column(name = "COMMENTS", columnDefinition = "VARCHAR2|备注||", length = 200, nullable = true)
	private String comments;

	@Column(name = "DIAGNOSIS", columnDefinition = "VARCHAR2|诊断||", length = 200, nullable = true)
	private String diagnosis;

	@Column(name = "CONTACT_DT_LAST", columnDefinition = "DATE|最后接触时间||", nullable = true)
	private Date contactDtLast;

	@Column(name = "CONTACT_TYPE_RATE", columnDefinition = "VARCHAR2|接触方式及频率||", length = 200, nullable = true)
	private String contactTypeRate;

	@Column(name = "CONTACT_ADDR", columnDefinition = "VARCHAR2|接触地点||", length = 200, nullable = true)
	private String contactAddr;

	@Column(name = "TRAVEL_BEGIN", columnDefinition = "VARCHAR2|旅行起始地||", length = 200, nullable = true)
	private String travelBegin;

	@Column(name = "TRAVEL_DT", columnDefinition = "DATE|旅行时间||", nullable = true)
	private Date travelDt;

	@Column(name = "TRAVEL_ADDR", columnDefinition = "VARCHAR2|旅行目的地||", length = 200, nullable = true)
	private String travelAddr;

	@Column(name = "CONDITION", columnDefinition = "VARCHAR2|发病地点以外所到地区情况||", length = 200, nullable = true)
	private String condition;

    @Column(name = "FLAG", columnDefinition = "VARCHAR2|子表标识||", length = 20, nullable = true)
    private String flag;

    @Column(name = "DIE_FOWL_PEOPLE_NUM", columnDefinition = "VARCHAR2|病死家禽户人口数||", length = 100, nullable = true)
    private String dieFowlPeopleNum;

    @Column(name = "ATTACK_DT", columnDefinition = "DATE|发病时间||", nullable = true)
    private Date attackDt;
    
    @Column(name = "BIRD_STATE", columnDefinition = "VARCHAR2|接触禽的状态||", length = 100, nullable = true)
    private String birdState;
    @Column(name = "BIRD_STATE_STR", columnDefinition = "VARCHAR2|接触禽的状态||", length = 100, nullable = true)
    private String birdStateStr;
	@Column(name = "BIRD_SPECIES", columnDefinition = "VARCHAR2|接触禽的种类||", length = 100, nullable = true)
    private String birdSpecies;
	@Column(name = "BIRD_SPECIES_OTHER", columnDefinition = "VARCHAR2|接触禽的种类-其他||", length = 100, nullable = true)
    private String birdSpeciesOther;
	@Column(name = "BIRD_SPECIES_STR", columnDefinition = "VARCHAR2|接触禽的种类||", length = 100, nullable = true)
    private String birdSpeciesStr;
	@Column(name = "CONTACT_WAY", columnDefinition = "VARCHAR2|接触方式||", length = 100, nullable = true)
    private String contactWay;
	@Column(name = "CONTACT_WAY_OTHER", columnDefinition = "VARCHAR2|接触方式-其他||", length = 100, nullable = true)
    private String contactWayOther;
	@Column(name = "CONTACT_WAY_STR", columnDefinition = "VARCHAR2|接触方式||", length = 100, nullable = true)
    private String contactWayStr;
	@Column(name = "HAND_STATE", columnDefinition = "VARCHAR2|接触时手部伤口情况||", length = 100, nullable = true)
    private String handState;
	@Column(name = "HAND_STATE_STR", columnDefinition = "VARCHAR2|接触时手部伤口情况||", length = 100, nullable = true)
    private String handStateStr;
	@Column(name = "PROTECT_WAY", columnDefinition = "VARCHAR2|接触禽类时的防护措施||", length = 100, nullable = true)
    private String protectWay;
	@Column(name = "PROTECT_WAY_STR", columnDefinition = "VARCHAR2|接触禽类时的防护措施||", length = 100, nullable = true)
    private String protectWayStr;
	@Column(name = "PROTECT_WAY_OTHER", columnDefinition = "VARCHAR2|接触禽类时的防护措施-其他||", length = 100, nullable = true)
    private String protectWayOther;
	@Column(name = "BIRD_DEATH", columnDefinition = "VARCHAR2|访问时此场所有无禽类病死现象||", length = 100, nullable = true)
    private String birdDeath;
	@Column(name = "BIRD_DEATH_STR", columnDefinition = "VARCHAR2|访问时此场所有无禽类病死现象||", length = 100, nullable = true)
    private String birdDeathStr;
	@Column(name = "WORKSHOP", columnDefinition = "VARCHAR2|是否到过养殖场所中饲养禽类的房间或车间||", length = 100, nullable = true)
    private String workshop;
	@Column(name = "WORKSHOP_STR", columnDefinition = "VARCHAR2|是否到过养殖场所中饲养禽类的房间或车间||", length = 100, nullable = true)
    private String workshopStr;
	@Column(name = "CONTACT_BIRD", columnDefinition = "VARCHAR2|是否直接接触过养殖场所内的禽类||", length = 100, nullable = true)
    private String contactBird;
	@Column(name = "CONTACT_BIRD_STR", columnDefinition = "VARCHAR2|是否直接接触过养殖场所内的禽类||", length = 100, nullable = true)
    private String contactBirdStr;
	@Column(name = "TO_MARKET", columnDefinition = "VARCHAR2|是否到过||", length = 100, nullable = true)
    private String toMarket;
	@Column(name = "TO_MARKET_STR", columnDefinition = "VARCHAR2|是否到过||", length = 100, nullable = true)
    private String toMarketStr;
	@Column(name = "NEAR_MARKET", columnDefinition = "VARCHAR2|是否到过活禽摊位1米之内的范围||", length = 100, nullable = true)
    private String nearMarket;
	@Column(name = "NEAR_MARKET_STR", columnDefinition = "VARCHAR2|是否到过活禽摊位1米之内的范围||", length = 100, nullable = true)
    private String nearMarketStr;
	@Column(name = "PASSAGEWAY", columnDefinition = "VARCHAR2|是否经过有活禽摊位的通道||", length = 100, nullable = true)
    private String passageway;
	@Column(name = "PASSAGEWAY_STR", columnDefinition = "VARCHAR2|是否经过有活禽摊位的通道||", length = 100, nullable = true)
    private String passagewayStr;
	@Column(name = "CONTACT_MARKET", columnDefinition = "VARCHAR2|是否直接接触活禽摊位的活禽||", length = 100, nullable = true)
    private String contactMarket;
	@Column(name = "CONTACT_MARKET_STR", columnDefinition = "VARCHAR2|是否直接接触活禽摊位的活禽||", length = 100, nullable = true)
    private String contactMarketStr;
	@Column(name = "VISIT_NUM", columnDefinition = "VARCHAR2|接触活禽摊位的活禽次数||", length = 100, nullable = true)
    private String visitNum;
	@Column(name = "PATIENT_TYPE", columnDefinition = "VARCHAR2|接触病例/发热病人类型||", length = 100, nullable = true)
    private String patientType;
	@Column(name = "PATIENT_TYPE_STR", columnDefinition = "VARCHAR2|接触病例/发热病人类型||", length = 100, nullable = true)
    private String patientTypeStr;
	@Column(name = "DIAGNOSIS_PATIENT", columnDefinition = "VARCHAR2|“诊治病人”，具体操作||", length = 100, nullable = true)
    private String diagnosisPatient;
	@Column(name = "DIAGNOSIS_PATIENT_STR", columnDefinition = "VARCHAR2|“诊治病人”，具体操作||", length = 100, nullable = true)
    private String diagnosisPatientStr;
	@Column(name = "CONTACT_TIME", columnDefinition = "VARCHAR2|接触发热病人的持续时间（小时）||", length = 100, nullable = true)
    private String contactTime;
	
	public String getBirdStateStr() {
		return birdStateStr;
	}

	public void setBirdStateStr(String birdStateStr) {
		this.birdStateStr = birdStateStr;
	}

	public String getBirdSpeciesStr() {
		return birdSpeciesStr;
	}

	public void setBirdSpeciesStr(String birdSpeciesStr) {
		this.birdSpeciesStr = birdSpeciesStr;
	}

	public String getContactWayStr() {
		return contactWayStr;
	}

	public void setContactWayStr(String contactWayStr) {
		this.contactWayStr = contactWayStr;
	}

	public String getHandStateStr() {
		return handStateStr;
	}

	public void setHandStateStr(String handStateStr) {
		this.handStateStr = handStateStr;
	}

	public String getProtectWayStr() {
		return protectWayStr;
	}

	public void setProtectWayStr(String protectWayStr) {
		this.protectWayStr = protectWayStr;
	}

	public String getBirdDeathStr() {
		return birdDeathStr;
	}

	public void setBirdDeathStr(String birdDeathStr) {
		this.birdDeathStr = birdDeathStr;
	}

	public String getWorkshopStr() {
		return workshopStr;
	}

	public void setWorkshopStr(String workshopStr) {
		this.workshopStr = workshopStr;
	}

	public String getContactBirdStr() {
		return contactBirdStr;
	}

	public void setContactBirdStr(String contactBirdStr) {
		this.contactBirdStr = contactBirdStr;
	}

	public String getToMarketStr() {
		return toMarketStr;
	}

	public void setToMarketStr(String toMarketStr) {
		this.toMarketStr = toMarketStr;
	}

	public String getNearMarketStr() {
		return nearMarketStr;
	}

	public void setNearMarketStr(String nearMarketStr) {
		this.nearMarketStr = nearMarketStr;
	}

	public String getPassagewayStr() {
		return passagewayStr;
	}

	public void setPassagewayStr(String passagewayStr) {
		this.passagewayStr = passagewayStr;
	}

	public String getContactMarketStr() {
		return contactMarketStr;
	}

	public void setContactMarketStr(String contactMarketStr) {
		this.contactMarketStr = contactMarketStr;
	}

	public String getPatientTypeStr() {
		return patientTypeStr;
	}

	public void setPatientTypeStr(String patientTypeStr) {
		this.patientTypeStr = patientTypeStr;
	}

	public String getDiagnosisPatientStr() {
		return diagnosisPatientStr;
	}

	public void setDiagnosisPatientStr(String diagnosisPatientStr) {
		this.diagnosisPatientStr = diagnosisPatientStr;
	}

	public String getBirdState() {
		return birdState;
	}

	public void setBirdState(String birdState) {
		this.birdState = birdState;
	}

	public String getBirdSpecies() {
		return birdSpecies;
	}

	public void setBirdSpecies(String birdSpecies) {
		this.birdSpecies = birdSpecies;
	}

	public String getBirdSpeciesOther() {
		return birdSpeciesOther;
	}

	public void setBirdSpeciesOther(String birdSpeciesOther) {
		this.birdSpeciesOther = birdSpeciesOther;
	}

	public String getContactWay() {
		return contactWay;
	}

	public void setContactWay(String contactWay) {
		this.contactWay = contactWay;
	}

	public String getContactWayOther() {
		return contactWayOther;
	}

	public void setContactWayOther(String contactWayOther) {
		this.contactWayOther = contactWayOther;
	}

	public String getHandState() {
		return handState;
	}

	public void setHandState(String handState) {
		this.handState = handState;
	}

	public String getProtectWay() {
		return protectWay;
	}

	public void setProtectWay(String protectWay) {
		this.protectWay = protectWay;
	}

	public String getProtectWayOther() {
		return protectWayOther;
	}

	public void setProtectWayOther(String protectWayOther) {
		this.protectWayOther = protectWayOther;
	}

	public String getBirdDeath() {
		return birdDeath;
	}

	public void setBirdDeath(String birdDeath) {
		this.birdDeath = birdDeath;
	}

	public String getWorkshop() {
		return workshop;
	}

	public void setWorkshop(String workshop) {
		this.workshop = workshop;
	}

	public String getContactBird() {
		return contactBird;
	}

	public void setContactBird(String contactBird) {
		this.contactBird = contactBird;
	}

	public String getToMarket() {
		return toMarket;
	}

	public void setToMarket(String toMarket) {
		this.toMarket = toMarket;
	}

	public String getNearMarket() {
		return nearMarket;
	}

	public void setNearMarket(String nearMarket) {
		this.nearMarket = nearMarket;
	}

	public String getPassageway() {
		return passageway;
	}

	public void setPassageway(String passageway) {
		this.passageway = passageway;
	}

	public String getContactMarket() {
		return contactMarket;
	}

	public void setContactMarket(String contactMarket) {
		this.contactMarket = contactMarket;
	}

	public String getVisitNum() {
		return visitNum;
	}

	public void setVisitNum(String visitNum) {
		this.visitNum = visitNum;
	}

	public String getPatientType() {
		return patientType;
	}

	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}

	public String getDiagnosisPatient() {
		return diagnosisPatient;
	}

	public void setDiagnosisPatient(String diagnosisPatient) {
		this.diagnosisPatient = diagnosisPatient;
	}

	public String getContactTime() {
		return contactTime;
	}

	public void setContactTime(String contactTime) {
		this.contactTime = contactTime;
	}

	public void setSexStr(String sexStr) {
		this.sexStr = sexStr;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdmId() {
		return this.idmId;
	}

	public void setIdmId(Integer idmId) {
		this.idmId = idmId;
	}

	public String getFarmName() {
		return this.farmName;
	}

	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}

	public String getAnimalType() {
		return this.animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public String getAnimalNum() {
		return this.animalNum;
	}

	public void setAnimalNum(String animalNum) {
		this.animalNum = animalNum;
	}

	public String getDieNum() {
		return this.dieNum;
	}

	public void setDieNum(String dieNum) {
		this.dieNum = dieNum;
	}

	public Date getDieDt() {
		return this.dieDt;
	}

	public void setDieDt(Date dieDt) {
		this.dieDt = dieDt;
	}

	public String getProcessMode() {
		return this.processMode;
	}

	public void setProcessMode(String processMode) {
		this.processMode = processMode;
	}

	public Date getProcessDt() {
		return this.processDt;
	}

	public void setProcessDt(Date processDt) {
		this.processDt = processDt;
	}

	public String getProcessNum() {
		return this.processNum;
	}

	public void setProcessNum(String processNum) {
		this.processNum = processNum;
	}

	public String getFamilyNum() {
		return this.familyNum;
	}

	public void setFamilyNum(String familyNum) {
		this.familyNum = familyNum;
	}

	public String getPeopleNum() {
		return this.peopleNum;
	}

	public void setPeopleNum(String peopleNum) {
		this.peopleNum = peopleNum;
	}

	public String getPermanentPopulation() {
		return this.permanentPopulation;
	}

	public void setPermanentPopulation(String permanentPopulation) {
		this.permanentPopulation = permanentPopulation;
	}

	public String getFowlFamilyNum() {
		return this.fowlFamilyNum;
	}

	public void setFowlFamilyNum(String fowlFamilyNum) {
		this.fowlFamilyNum = fowlFamilyNum;
	}

	public String getFowlPeopleNum() {
		return this.fowlPeopleNum;
	}

	public void setFowlPeopleNum(String fowlPeopleNum) {
		this.fowlPeopleNum = fowlPeopleNum;
	}

	public String getDieFowlNum() {
		return this.dieFowlNum;
	}

	public void setDieFowlNum(String dieFowlNum) {
		this.dieFowlNum = dieFowlNum;
	}

	public String getExceptionNum() {
		return this.exceptionNum;
	}

	public void setExceptionNum(String exceptionNum) {
		this.exceptionNum = exceptionNum;
	}

	public String getPcr() {
		return this.pcr;
	}

	public void setPcr(String pcr) {
		this.pcr = pcr;
	}

	public String getSampleAddr() {
		return this.sampleAddr;
	}

	public void setSampleAddr(String sampleAddr) {
		this.sampleAddr = sampleAddr;
	}

	public Date getSampleDt() {
		return this.sampleDt;
	}

	public void setSampleDt(Date sampleDt) {
		this.sampleDt = sampleDt;
	}

	public Date getSeparateDt() {
		return this.separateDt;
	}

	public void setSeparateDt(Date separateDt) {
		this.separateDt = separateDt;
	}

	public String getSeparateUnit() {
		return this.separateUnit;
	}

	public void setSeparateUnit(String separateUnit) {
		this.separateUnit = separateUnit;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getClinicalManifestation() {
		return this.clinicalManifestation;
	}

	public void setClinicalManifestation(String clinicalManifestation) {
		this.clinicalManifestation = clinicalManifestation;
	}

	public Date getSaveDieDt() {
		return this.saveDieDt;
	}

	public void setSaveDieDt(Date saveDieDt) {
		this.saveDieDt = saveDieDt;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getDiagnosis() {
		return this.diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Date getContactDtLast() {
		return this.contactDtLast;
	}

	public void setContactDtLast(Date contactDtLast) {
		this.contactDtLast = contactDtLast;
	}

	public String getContactTypeRate() {
		return this.contactTypeRate;
	}

	public void setContactTypeRate(String contactTypeRate) {
		this.contactTypeRate = contactTypeRate;
	}

	public String getContactAddr() {
		return this.contactAddr;
	}

	public void setContactAddr(String contactAddr) {
		this.contactAddr = contactAddr;
	}

	public String getTravelBegin() {
		return this.travelBegin;
	}

	public void setTravelBegin(String travelBegin) {
		this.travelBegin = travelBegin;
	}

	public Date getTravelDt() {
		return this.travelDt;
	}

	public void setTravelDt(Date travelDt) {
		this.travelDt = travelDt;
	}

	public String getTravelAddr() {
		return this.travelAddr;
	}

	public void setTravelAddr(String travelAddr) {
		this.travelAddr = travelAddr;
	}

	public String getCondition() {
		return this.condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getDieFowlPeopleNum() {
        return dieFowlPeopleNum;
    }

    public void setDieFowlPeopleNum(String dieFowlPeopleNum) {
        this.dieFowlPeopleNum = dieFowlPeopleNum;
    }

    public Date getAttackDt() {
        return attackDt;
    }

    public void setAttackDt(Date attackDt) {
        this.attackDt = attackDt;
    }

    @Transient
    private String sexStr;

    public String getSexStr() {
        return StringUtil.isNotEmpty(sex)?("1".equals(sex)?"男":"女"):"";
    }
}