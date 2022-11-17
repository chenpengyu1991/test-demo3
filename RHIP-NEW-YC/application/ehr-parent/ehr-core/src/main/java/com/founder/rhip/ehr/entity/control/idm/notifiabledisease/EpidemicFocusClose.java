package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import java.util.Date;

/**
 *疫源地处理、密切接触者登记y
 */
@Entity
@Table(name = "IDM_EPIDEMIC_FOCUS_CLOSE")
public class EpidemicFocusClose implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编码||", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "PATIENT_ISOLATION_COND", columnDefinition = "VARCHAR2|病人隔离情况||", length = 500, nullable = true)
	private String patientIsolationCond;

	@Column(name = "FARM_SET", columnDefinition = "VARCHAR2|疫点设置情况||", length = 500, nullable = true)
	private String farmSet;

	@Column(name = "NOTIFIED_CARD_DATE", columnDefinition = "DATE|接报卡日期||", nullable = true)
	private Date notifiedCardDate;

	@Column(name = "REPORT_ORG", columnDefinition = "VARCHAR2|报告单位||", length = 100, nullable = true)
	private String reportOrg;

	@Column(name = "REPORT_PERSON", columnDefinition = "VARCHAR2|报告人||", length = 50, nullable = true)
	private String reportPerson;

	@Column(name = "FIRST_VISIT_DATE", columnDefinition = "DATE|初访日期||", nullable = true)
	private Date firstVisitDate;

	@Column(name = "DELOUSING_SITUATION", columnDefinition = "VARCHAR2|灭虱情况||", length = 2, nullable = true)
	private String delousingSituation;

	@Column(name = "FLEA_SITUATION", columnDefinition = "VARCHAR2|灭蚤情况||", length = 2, nullable = true)
	private String fleaSituation;

	@Column(name = "DERATIZATION_SITUATION", columnDefinition = "VARCHAR2|灭鼠情况||", length = 2, nullable = true)
	private String deratizationSituation;

	@Column(name = "SEC_SUPERVISION_DATE", columnDefinition = "DATE|第二次访视日期||", nullable = true)
	private Date secSupervisionDate;

	@Column(name = "IS_PEOPLE_CONTINUED", columnDefinition = "VARCHAR2|有无续发病人||", length = 2, nullable = true)
	private String isPeopleContinued;

	@Column(name = "PATIENT_OUTCOME", columnDefinition = "VARCHAR2|病人转归||", length = 2, nullable = true)
	private String patientOutcome;

	@Column(name = "DATE_CLOSED", columnDefinition = "DATE|结案日期||", nullable = true)
	private Date dateClosed;

	@Column(name = "INFECTION_SOURCE", columnDefinition = "VARCHAR2|感染来源||", length = 2, nullable = true)
	private String infectionSource;

	@Column(name = "PAT_ACCOM_DISIN", columnDefinition = "VARCHAR2|病人住室消毒||", length = 2, nullable = true)
	private String patAccomDisin;

	@Column(name = "PAT_DISCHARGE_DISIN", columnDefinition = "VARCHAR2|病人分泌物消毒||", length = 2, nullable = true)
	private String patDischargeDisin;

	@Column(name = "PAT_ACCOM_VENT", columnDefinition = "VARCHAR2|病人住室通风||", length = 2, nullable = true)
	private String patAccomVent;

	@Column(name = "OTHER", columnDefinition = "VARCHAR2|其它||", length = 100, nullable = true)
	private String other;

	@Column(name = "DISEASE_REPORT_DATE", columnDefinition = "DATE|县级疾控接到报告时间||", nullable = true)
	private Date diseaseReportDate;

	@Column(name = "DISEASE_SCENE_DATE", columnDefinition = "DATE|县级疾控到达现场时间||", nullable = true)
	private Date diseaseSceneDate;

	@Column(name = "FARM_NUM", columnDefinition = "VARCHAR2|疫点个数|20|", length = 20, nullable = true)
	private String farmNum;

	@Column(name = "RANGE_FAMILY", columnDefinition = "VARCHAR2|范围-户20|", length = 20, nullable = true)
	private String rangeFamily;

	@Column(name = "RANGE_NUM", columnDefinition = "VARCHAR2|范围-个|20|", length = 20, nullable = true)
	private String rangeNum;

	@Column(name = "REMOVE_DATE", columnDefinition = "DATE|解除时间||", nullable = true)
	private Date removeDate;

	@Column(name = "TERM_STER_TIME", columnDefinition = "DATE|终末消毒时间||", nullable = true)
	private Date termSterTime;

	@Column(name = "IS_PATIENT_ISOLATION", columnDefinition = "VARCHAR2|病人是否隔离||", length = 2, nullable = true)
	private String isPatientIsolation;

	@Column(name = "ISOLATION_PLACE", columnDefinition = "VARCHAR2|隔离地点||", length = 2, nullable = true)
	private String isolationPlace;

	@Column(name = "IS_EXCRETA_DISI", columnDefinition = "VARCHAR2|病人排泄物消毒||", length = 2, nullable = true)
	private String isExcretaDisi;

	@Column(name = "ZERO_FOUR", columnDefinition = "VARCHAR2|病家及院内人口-0~4岁|20|", length = 20, nullable = true)
	private String zeroFour;

	@Column(name = "FIVE_NINE", columnDefinition = "VARCHAR2|病家及院内人口-5~9岁|20|", length = 20, nullable = true)
	private String fiveNine;

	@Column(name = "TEN", columnDefinition = "VARCHAR2|病家及院内人口-10~19岁|20|", length = 20, nullable = true)
	private String ten;

	@Column(name = "TWENTY", columnDefinition = "VARCHAR2|病家及院内人口-20~29岁|20|", length = 20, nullable = true)
	private String twenty;

	@Column(name = "THIRTY", columnDefinition = "VARCHAR2|病家及院内人口-30~39岁|20|", length = 20, nullable = true)
	private String thirty;

	@Column(name = "FORTY", columnDefinition = "VARCHAR2|病家及院内人口-40~49岁|20|", length = 20, nullable = true)
	private String forty;

	@Column(name = "FIFTY", columnDefinition = "VARCHAR2|病家及院内人口-50~59岁|20|", length = 20, nullable = true)
	private String fifty;

	@Column(name = "ABOVE_SIXTY", columnDefinition = "VARCHAR2|60岁及以上|20|", length = 20, nullable = true)
	private String aboveSixty;

	@Column(name = "IS_SIM_SYMPT_FAMILY", columnDefinition = "VARCHAR2|有无家庭其他成员出现过类似症状||", length = 2, nullable = true)
	private String isSimSymptFamily;

	@Column(name = "RECENT_ONSET_TIME", columnDefinition = "DATE|最近一次发病时间（患者除外）||", nullable = true)
	private Date recentOnsetTime;

	@Column(name = "IS_TOURISM_HISTORY", columnDefinition = "VARCHAR2|发病前2个月内是否有外出（或旅游）史||", length = 2, nullable = true)
	private String isTourismHistory;

	@Column(name = "GO_WHERE", columnDefinition = "VARCHAR2|到何地||", length = 200, nullable = true)
	private String goWhere;

	@Column(name = "ABSENCE_DWELL_TIME", columnDefinition = "VARCHAR2|外出停留时间|20|", length = 20, nullable = true)
	private String absenceDwellTime;

	@Column(name = "RETURN_TIME", columnDefinition = "DATE|返回时间||", nullable = true)
	private Date returnTime;

	@Column(name = "CONTACT_RAT", columnDefinition = "VARCHAR2|发病前1月内是否接触鼠类||", length = 2, nullable = true)
	private String contactRat;

	@Column(name = "CONTACT_FORM", columnDefinition = "VARCHAR2|接触方式||", length = 2, nullable = true)
	private String contactForm;

	@Column(name = "IS_INSECT_BITES_HISTORY", columnDefinition = "VARCHAR2|发病前1月内是否有昆虫叮咬史||", length = 2, nullable = true)
	private String isInsectBitesHistory;

	@Column(name = "IS_RAT_FECES_POLLUTION", columnDefinition = "VARCHAR2|发病前1月内是否吃过被鼠排泄物污染的食物||", length = 2, nullable = true)
	private String isRatFecesPollution;

	@Column(name = "IS_DRANK_FIELD_WATER", columnDefinition = "VARCHAR2|发病前1月内是否在野外喝过沟（塘）水||", length = 2, nullable = true)
	private String isDrankFieldWater;

	@Column(name = "IS_SIT_RAT", columnDefinition = "VARCHAR2|发病前1月内是否在鼠洞附近坐卧||", length = 2, nullable = true)
	private String isSitRat;

	@Column(name = "IS_SIT_GRASS", columnDefinition = "VARCHAR2|发病前1月内是否在场院禾草上坐卧||", length = 2, nullable = true)
	private String isSitGrass;

	@Column(name = "IS_STAYACCOM", columnDefinition = "VARCHAR2|发病前1月内是否在野外住宿||", length = 2, nullable = true)
	private String isStayaccom;

	@Column(name = "PLACE_DETAIL", columnDefinition = "VARCHAR2|具体地点||", length = 200, nullable = true)
	private String placeDetail;

	@Column(name = "IS_RAT_NEARBY", columnDefinition = "VARCHAR2|其附近有无鼠、鼠洞或鼠排泄物||", length = 2, nullable = true)
	private String isRatNearby;

	@Column(name = "SHOP_TYPE", columnDefinition = "VARCHAR2|铺的类型||", length = 2, nullable = true)
	private String shopType;

	@Column(name = "OTHER_SHOP_TYPE", columnDefinition = "VARCHAR2|其他铺的类型||", length = 200, nullable = true)
	private String otherShopType;

	@Column(name = "IS_RAT_WORKPLACE", columnDefinition = "VARCHAR2|工作场所有无鼠或鼠排泄物||", length = 2, nullable = true)
	private String isRatWorkplace;

	@Column(name = "IS_HEM_BLOOD_URINE", columnDefinition = "VARCHAR2|发病前1月内是否接触过出血热病人血/尿||", length = 2, nullable = true)
	private String isHemBloodUrine;

	@Column(name = "IS_GO_PLACE", columnDefinition = "VARCHAR2|发病前7天内是否到过以下场所||", length = 200, nullable = true)
	private String isGoPlace;

	@Column(name = "PUB_PLA_NAME_ADDR", columnDefinition = "VARCHAR2|所到公共场所的具体名称及地址||", length = 400, nullable = true)
	private String pubPlaNameAddr;

	@Column(name = "IS_AGENDA", columnDefinition = "VARCHAR2|发病前7天内是否外出旅行、出差||", length = 2, nullable = true)
	private String isAgenda;

	@Column(name = "TRAVEL_AGENDA", columnDefinition = "VARCHAR2|说明行程||", length = 500, nullable = true)
	private String travelAgenda;

	@Column(name = "IS_HN_EPIDEMIC", columnDefinition = "VARCHAR2|旅行、出差所经地是否有甲型H1N1流感疫情||", length = 2, nullable = true)
	private String isHnEpidemic;

	@Column(name = "TRAFFIC_TOOLS_BEFORE", columnDefinition = "VARCHAR2|发病前七天曾经搭乘过的交通工具（可多选）||", length = 200, nullable = true)
	private String trafficToolsBefore;

	@Column(name = "TRAFFIC_TOOLS_BE_OTH", columnDefinition = "VARCHAR2|其它||", length = 200, nullable = true)
	private String trafficToolsBeOth;

	@Column(name = "TRAFFIC_TOOLS", columnDefinition = "VARCHAR2|具体说明搭乘交通工具的情况||", length = 200, nullable = true)
	private String trafficTools;

	@Column(name = "IS_CONTACTS", columnDefinition = "VARCHAR2|有无密切接触者||", length = 2, nullable = true)
	private String isContacts;

	@Column(name = "CONTACTS_NUM", columnDefinition = "VARCHAR2|密切接触者的人数|20|", length = 20, nullable = true)
	private String contactsNum;

	@Column(name = "MED_OBS_NUM", columnDefinition = "VARCHAR2|目前已纳入医学观察的人数|20|", length = 20, nullable = true)
	private String medObsNum;

	@Column(name = "IS_FEVER_RESPIRATORY", columnDefinition = "VARCHAR2|是否有人出现发热和/或呼吸道症状||", length = 2, nullable = true)
	private String isFeverRespiratory;

	@Column(name = "CASES_QUEST_NUM", columnDefinition = "VARCHAR2|霍乱个案调查表人数|20|", length = 20, nullable = true)
	private String casesQuestNum;

	@Column(name = "DISINF_DRUGS_CONC", columnDefinition = "VARCHAR2|消毒药物及浓度||", length = 20, nullable = true)
	private String disinfDrugsConc;

	@Column(name = "PLACE", columnDefinition = "VARCHAR2|污染衣、被、席等地点||", length = 200, nullable = true)
	private String place;

	@Column(name = "DIRT_CLEANING_DATE", columnDefinition = "DATE|污物清洗时间（yy/mm/dd）||", nullable = true)
	private Date dirtCleaningDate;

	@Column(name = "DIRT_CLEANING_PLACE", columnDefinition = "VARCHAR2|污物清洗地点||", length = 200, nullable = true)
	private String dirtCleaningPlace;

	@Column(name = "TER_STER_DATE", columnDefinition = "DATE|终末消毒时间（yy/mm/dd）||", nullable = true)
	private Date terSterDate;

	@Column(name = "FARM_MED_TIME", columnDefinition = "DATE|疫点内人群服药时间（yy/mm/dd）||", nullable = true)
	private Date farmMedTime;

	@Column(name = "FARM_MED_NUM", columnDefinition = "VARCHAR2|疫点内服药人数|20|", length = 20, nullable = true)
	private String farmMedNum;

	@Column(name = "FARM_SKETCHES", columnDefinition = "VARCHAR2|疫点示意图||", length = 200, nullable = true)
	private String farmSketches;

	@Column(name = "FARM_SUMMARY", columnDefinition = "VARCHAR2|疫点调查小结||", length = 200, nullable = true)
	private String farmSummary;

	@Column(name = "INFECTIOUS_FOCUS_DISPOSE", columnDefinition = "VARCHAR2|疫源地处理||", length = 400, nullable = true)
	private String infectiousFocusDispose;

	@Column(name = "FARM_PEOPLE_NUM", columnDefinition = "VARCHAR2|疫点人数|20|", length = 20, nullable = true)
	private String farmPeopleNum;

	@Column(name = "IS_FEVER_RESPIRATORY_NUM", columnDefinition = "VARCHAR2|是否有人出现发热和/或呼吸道症状-人数|20|", length = 20, nullable = true)
	private String isFeverRespiratoryNum;

	@Column(name = "CONTACT_FORM_OTHER", columnDefinition = "VARCHAR2|接触方式-其他||", length = 200, nullable = true)
	private String contactFormOther;

    @Column(name = "FARM_ADDR", columnDefinition = "VARCHAR2|疫水接触地点|200|", length = 200, nullable = true)
    private String farmAddr;

    @Column(name = "FARM_DT", columnDefinition = "DATE|疫水时间||", nullable = true)
    private Date farmDt;

    @Column(name = "FARM_TIMES", columnDefinition = "VARCHAR2|疫水次数|20|", length = 20, nullable = true)
    private String farmTimes;

    @Column(name = "CONTACT_DEGREE", columnDefinition = "VARCHAR2|接触程度|2|", length = 2, nullable = true)
    private String contactDegree;

    @Column(name = "IN_CONTACT", columnDefinition = "VARCHAR2|家内－接触人员|2|", length = 2, nullable = true)
    private String inContact;

    @Column(name = "IN_CONTACT_OTHER", columnDefinition = "VARCHAR2|家内－接触人员其他|100|", length = 100, nullable = true)
    private String inContactOther;

    @Column(name = "OUT_CONTACT", columnDefinition = "VARCHAR2|家外－接触人员|2|", length = 2, nullable = true)
    private String outContact;

    @Column(name = "OUT_CONTACT_OTHER", columnDefinition = "VARCHAR2|家外－接触人员其他|100|", length = 100, nullable = true)
    private String outContactOther;

    @Column(name = "IS_FARM", columnDefinition = "VARCHAR2|是否疫点|2|", length = 2, nullable = true)
    private String isFarm;

    @Column(name = "FARM_NAME", columnDefinition = "VARCHAR2|疫点名称|100|", length = 100, nullable = true)
    private String farmName;

    @Column(name = "FARM_RANGE", columnDefinition = "VARCHAR2|疫点范围|20|", length = 20, nullable = true)
    private String farmRange;

    @Column(name = "FARM_AREA", columnDefinition = "VARCHAR2|疫点面积|20|", length = 20, nullable = true)
    private String farmArea;

    @Column(name = "FARM_FOREIGN_NUM", columnDefinition = "VARCHAR2|疫点外来人口数|20|", length = 20, nullable = true)
    private String farmForeignNum;

    @Column(name = "DRUG_NAME", columnDefinition = "VARCHAR2|服药药物名称和方法|100|", length = 100, nullable = true)
    private String drugName;

    @Column(name = "MOSQUITO_DT", columnDefinition = "DATE|灭蚊日期||", nullable = true)
    private Date mosquitoDt;

    @Column(name = "MOSQUITO_DRUG_NAME", columnDefinition = "VARCHAR2|灭蚊药物名称和方法|100|", length = 100, nullable = true)
    private String mosquitoDrugName;

    @Column(name = "MOSQUITO_RANGE", columnDefinition = "VARCHAR2|灭蚊范围|100|", length = 100, nullable = true)
    private String mosquitoRange;

    @Column(name = "HE_DT", columnDefinition = "DATE|健康教育日期||", nullable = true)
    private Date heDt;

    @Column(name = "HE_CONTENT", columnDefinition = "VARCHAR2|健康教育内容|100|", length = 100, nullable = true)
    private String heContent;

    @Column(name = "HE_NUM", columnDefinition = "VARCHAR2|受教人数|20|", length = 20, nullable = true)
    private String heNum;
   
    @Column(name = "SIXTY", columnDefinition = "VARCHAR2|病家及院内人口-60~69岁|20|", length = 20, nullable = true)
	private String sixty;
    @Column(name = "ABOVE_SEVENTY", columnDefinition = "VARCHAR2|70岁及以上|20|", length = 20, nullable = true)
	private String aboveSeventy;
	@Column(name = "SIM_SYMPT_FAMILY", columnDefinition = "VARCHAR2|家庭其他成员出现过类似症状||", length = 100, nullable = true)
	private String simSymptFamily;
	
	@Column(name = "QUARANTINE_BEGIN_DATE", columnDefinition = "VARCHAR2|隔离开始时间||", nullable = true)
	private Date quarantineBeginDate;
	
	@Column(name = "QUARANTINE_END_DATE", columnDefinition = "VARCHAR2|隔离结束时间||", nullable = true)
	private Date quarantineEndDate;
	
	@Column(name = "MEDICAL_OBSERVATION_RESULTS", columnDefinition = "VARCHAR2|医学观察结果|100|", length = 100, nullable = true)
	private String medicalObservationResults;
	
	@Column(name = "PROCESS_METHOD", columnDefinition = "VARCHAR2|处理方法||", length = 20, nullable = true)
	private String processMethod;

	 @Transient
	 private String diseaseReportHour;//县级疾控接到报告时间-小时
	 @Transient
	 private String diseaseSceneHour;//县级疾控到达现场时间-小时
	 @Transient
	 private String removeHour;//解除时间-小时
	 @Transient
	 private String termSterHour;//终末消毒时间-小时
	 
	public String getProcessMethod() {
		return processMethod;
	}

	public void setProcessMethod(String processMethod) {
		this.processMethod = processMethod;
	}

	public String getMedicalObservationResults() {
		return medicalObservationResults;
	}

	public void setMedicalObservationResults(String medicalObservationResults) {
		this.medicalObservationResults = medicalObservationResults;
	}

	public Date getQuarantineBeginDate() {
		return quarantineBeginDate;
	}

	public void setQuarantineBeginDate(Date quarantineBeginDate) {
		this.quarantineBeginDate = quarantineBeginDate;
	}

	public Date getQuarantineEndDate() {
		return quarantineEndDate;
	}

	public void setQuarantineEndDate(Date quarantineEndDate) {
		this.quarantineEndDate = quarantineEndDate;
	}

	public String getSixty() {
		return sixty;
	}

	public void setSixty(String sixty) {
		this.sixty = sixty;
	}

	public String getAboveSeventy() {
		return aboveSeventy;
	}

	public void setAboveSeventy(String aboveSeventy) {
		this.aboveSeventy = aboveSeventy;
	}

	public String getSimSymptFamily() {
		return simSymptFamily;
	}

	public void setSimSymptFamily(String simSymptFamily) {
		this.simSymptFamily = simSymptFamily;
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

	public String getPatientIsolationCond() {
		return this.patientIsolationCond;
	}

	public void setPatientIsolationCond(String patientIsolationCond) {
		this.patientIsolationCond = patientIsolationCond;
	}

	public String getFarmSet() {
		return this.farmSet;
	}

	public void setFarmSet(String farmSet) {
		this.farmSet = farmSet;
	}

	public Date getNotifiedCardDate() {
		return this.notifiedCardDate;
	}

	public void setNotifiedCardDate(Date notifiedCardDate) {
		this.notifiedCardDate = notifiedCardDate;
	}

	public String getReportOrg() {
		return this.reportOrg;
	}

	public void setReportOrg(String reportOrg) {
		this.reportOrg = reportOrg;
	}

	public String getReportPerson() {
		return this.reportPerson;
	}

	public void setReportPerson(String reportPerson) {
		this.reportPerson = reportPerson;
	}

	public Date getFirstVisitDate() {
		return this.firstVisitDate;
	}

	public void setFirstVisitDate(Date firstVisitDate) {
		this.firstVisitDate = firstVisitDate;
	}

	public String getDelousingSituation() {
		return this.delousingSituation;
	}

	public void setDelousingSituation(String delousingSituation) {
		this.delousingSituation = delousingSituation;
	}

	public String getFleaSituation() {
		return this.fleaSituation;
	}

	public void setFleaSituation(String fleaSituation) {
		this.fleaSituation = fleaSituation;
	}

	public String getDeratizationSituation() {
		return this.deratizationSituation;
	}

	public void setDeratizationSituation(String deratizationSituation) {
		this.deratizationSituation = deratizationSituation;
	}

	public Date getSecSupervisionDate() {
		return this.secSupervisionDate;
	}

	public void setSecSupervisionDate(Date secSupervisionDate) {
		this.secSupervisionDate = secSupervisionDate;
	}

	public String getIsPeopleContinued() {
		return this.isPeopleContinued;
	}

	public void setIsPeopleContinued(String isPeopleContinued) {
		this.isPeopleContinued = isPeopleContinued;
	}

	public String getPatientOutcome() {
		return this.patientOutcome;
	}

	public void setPatientOutcome(String patientOutcome) {
		this.patientOutcome = patientOutcome;
	}

	public Date getDateClosed() {
		return this.dateClosed;
	}

	public void setDateClosed(Date dateClosed) {
		this.dateClosed = dateClosed;
	}

	public String getInfectionSource() {
		return this.infectionSource;
	}

	public void setInfectionSource(String infectionSource) {
		this.infectionSource = infectionSource;
	}

	public String getPatAccomDisin() {
		return this.patAccomDisin;
	}

	public void setPatAccomDisin(String patAccomDisin) {
		this.patAccomDisin = patAccomDisin;
	}

	public String getPatDischargeDisin() {
		return this.patDischargeDisin;
	}

	public void setPatDischargeDisin(String patDischargeDisin) {
		this.patDischargeDisin = patDischargeDisin;
	}

	public String getPatAccomVent() {
		return this.patAccomVent;
	}

	public void setPatAccomVent(String patAccomVent) {
		this.patAccomVent = patAccomVent;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public Date getDiseaseReportDate() {
		return this.diseaseReportDate;
	}

	public void setDiseaseReportDate(Date diseaseReportDate) {
		this.diseaseReportDate = diseaseReportDate;
	}

	public Date getDiseaseSceneDate() {
		return this.diseaseSceneDate;
	}

	public void setDiseaseSceneDate(Date diseaseSceneDate) {
		this.diseaseSceneDate = diseaseSceneDate;
	}

	public String getFarmNum() {
		return this.farmNum;
	}

	public void setFarmNum(String farmNum) {
		this.farmNum = farmNum;
	}

	public String getRangeFamily() {
		return this.rangeFamily;
	}

	public void setRangeFamily(String rangeFamily) {
		this.rangeFamily = rangeFamily;
	}

	public String getRangeNum() {
		return this.rangeNum;
	}

	public void setRangeNum(String rangeNum) {
		this.rangeNum = rangeNum;
	}

	public Date getRemoveDate() {
		return this.removeDate;
	}

	public void setRemoveDate(Date removeDate) {
		this.removeDate = removeDate;
	}

	public Date getTermSterTime() {
		return this.termSterTime;
	}

	public void setTermSterTime(Date termSterTime) {
		this.termSterTime = termSterTime;
	}

	public String getIsPatientIsolation() {
		return this.isPatientIsolation;
	}

	public void setIsPatientIsolation(String isPatientIsolation) {
		this.isPatientIsolation = isPatientIsolation;
	}

	public String getIsolationPlace() {
		return this.isolationPlace;
	}

	public void setIsolationPlace(String isolationPlace) {
		this.isolationPlace = isolationPlace;
	}

	public String getIsExcretaDisi() {
		return this.isExcretaDisi;
	}

	public void setIsExcretaDisi(String isExcretaDisi) {
		this.isExcretaDisi = isExcretaDisi;
	}

	public String getZeroFour() {
		return this.zeroFour;
	}

	public void setZeroFour(String zeroFour) {
		this.zeroFour = zeroFour;
	}

	public String getFiveNine() {
		return this.fiveNine;
	}

	public void setFiveNine(String fiveNine) {
		this.fiveNine = fiveNine;
	}

	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getTwenty() {
		return this.twenty;
	}

	public void setTwenty(String twenty) {
		this.twenty = twenty;
	}

	public String getThirty() {
		return this.thirty;
	}

	public void setThirty(String thirty) {
		this.thirty = thirty;
	}

	public String getForty() {
		return this.forty;
	}

	public void setForty(String forty) {
		this.forty = forty;
	}

	public String getFifty() {
		return this.fifty;
	}

	public void setFifty(String fifty) {
		this.fifty = fifty;
	}

	public String getAboveSixty() {
		return this.aboveSixty;
	}

	public void setAboveSixty(String aboveSixty) {
		this.aboveSixty = aboveSixty;
	}

	public String getIsSimSymptFamily() {
		return this.isSimSymptFamily;
	}

	public void setIsSimSymptFamily(String isSimSymptFamily) {
		this.isSimSymptFamily = isSimSymptFamily;
	}

	public Date getRecentOnsetTime() {
		return this.recentOnsetTime;
	}

	public void setRecentOnsetTime(Date recentOnsetTime) {
		this.recentOnsetTime = recentOnsetTime;
	}

	public String getIsTourismHistory() {
		return this.isTourismHistory;
	}

	public void setIsTourismHistory(String isTourismHistory) {
		this.isTourismHistory = isTourismHistory;
	}

	public String getGoWhere() {
		return this.goWhere;
	}

	public void setGoWhere(String goWhere) {
		this.goWhere = goWhere;
	}

	public String getAbsenceDwellTime() {
		return this.absenceDwellTime;
	}

	public void setAbsenceDwellTime(String absenceDwellTime) {
		this.absenceDwellTime = absenceDwellTime;
	}

	public Date getReturnTime() {
		return this.returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	public String getContactRat() {
		return this.contactRat;
	}

	public void setContactRat(String contactRat) {
		this.contactRat = contactRat;
	}

	public String getContactForm() {
		return this.contactForm;
	}

	public void setContactForm(String contactForm) {
		this.contactForm = contactForm;
	}

	public String getIsInsectBitesHistory() {
		return this.isInsectBitesHistory;
	}

	public void setIsInsectBitesHistory(String isInsectBitesHistory) {
		this.isInsectBitesHistory = isInsectBitesHistory;
	}

	public String getIsRatFecesPollution() {
		return this.isRatFecesPollution;
	}

	public void setIsRatFecesPollution(String isRatFecesPollution) {
		this.isRatFecesPollution = isRatFecesPollution;
	}

	public String getIsDrankFieldWater() {
		return this.isDrankFieldWater;
	}

	public void setIsDrankFieldWater(String isDrankFieldWater) {
		this.isDrankFieldWater = isDrankFieldWater;
	}

	public String getIsSitRat() {
		return this.isSitRat;
	}

	public void setIsSitRat(String isSitRat) {
		this.isSitRat = isSitRat;
	}

	public String getIsSitGrass() {
		return this.isSitGrass;
	}

	public void setIsSitGrass(String isSitGrass) {
		this.isSitGrass = isSitGrass;
	}

	public String getIsStayaccom() {
		return this.isStayaccom;
	}

	public void setIsStayaccom(String isStayaccom) {
		this.isStayaccom = isStayaccom;
	}

	public String getPlaceDetail() {
		return this.placeDetail;
	}

	public void setPlaceDetail(String placeDetail) {
		this.placeDetail = placeDetail;
	}

	public String getIsRatNearby() {
		return this.isRatNearby;
	}

	public void setIsRatNearby(String isRatNearby) {
		this.isRatNearby = isRatNearby;
	}

	public String getShopType() {
		return this.shopType;
	}

	public void setShopType(String shopType) {
		this.shopType = shopType;
	}

	public String getOtherShopType() {
		return this.otherShopType;
	}

	public void setOtherShopType(String otherShopType) {
		this.otherShopType = otherShopType;
	}

	public String getIsRatWorkplace() {
		return this.isRatWorkplace;
	}

	public void setIsRatWorkplace(String isRatWorkplace) {
		this.isRatWorkplace = isRatWorkplace;
	}

	public String getIsHemBloodUrine() {
		return this.isHemBloodUrine;
	}

	public void setIsHemBloodUrine(String isHemBloodUrine) {
		this.isHemBloodUrine = isHemBloodUrine;
	}

	public String getIsGoPlace() {
		return this.isGoPlace;
	}

	public void setIsGoPlace(String isGoPlace) {
		this.isGoPlace = isGoPlace;
	}

	public String getPubPlaNameAddr() {
		return this.pubPlaNameAddr;
	}

	public void setPubPlaNameAddr(String pubPlaNameAddr) {
		this.pubPlaNameAddr = pubPlaNameAddr;
	}

	public String getIsAgenda() {
		return this.isAgenda;
	}

	public void setIsAgenda(String isAgenda) {
		this.isAgenda = isAgenda;
	}

	public String getTravelAgenda() {
		return this.travelAgenda;
	}

	public void setTravelAgenda(String travelAgenda) {
		this.travelAgenda = travelAgenda;
	}

	public String getIsHnEpidemic() {
		return isHnEpidemic;
	}

	public void setIsHnEpidemic(String isHnEpidemic) {
		this.isHnEpidemic = isHnEpidemic;
	}

	public String getTrafficToolsBefore() {
		return this.trafficToolsBefore;
	}

	public void setTrafficToolsBefore(String trafficToolsBefore) {
		this.trafficToolsBefore = trafficToolsBefore;
	}

	public String getTrafficToolsBeOth() {
		return this.trafficToolsBeOth;
	}

	public void setTrafficToolsBeOth(String trafficToolsBeOth) {
		this.trafficToolsBeOth = trafficToolsBeOth;
	}

	public String getTrafficTools() {
		return this.trafficTools;
	}

	public void setTrafficTools(String trafficTools) {
		this.trafficTools = trafficTools;
	}

	public String getIsContacts() {
		return this.isContacts;
	}

	public void setIsContacts(String isContacts) {
		this.isContacts = isContacts;
	}

	public String getContactsNum() {
		return this.contactsNum;
	}

	public void setContactsNum(String contactsNum) {
		this.contactsNum = contactsNum;
	}

	public String getMedObsNum() {
		return this.medObsNum;
	}

	public void setMedObsNum(String medObsNum) {
		this.medObsNum = medObsNum;
	}

	public String getIsFeverRespiratory() {
		return this.isFeverRespiratory;
	}

	public void setIsFeverRespiratory(String isFeverRespiratory) {
		this.isFeverRespiratory = isFeverRespiratory;
	}

	public String getCasesQuestNum() {
		return this.casesQuestNum;
	}

	public void setCasesQuestNum(String casesQuestNum) {
		this.casesQuestNum = casesQuestNum;
	}

	public String getDisinfDrugsConc() {
		return this.disinfDrugsConc;
	}

	public void setDisinfDrugsConc(String disinfDrugsConc) {
		this.disinfDrugsConc = disinfDrugsConc;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getDirtCleaningDate() {
		return this.dirtCleaningDate;
	}

	public void setDirtCleaningDate(Date dirtCleaningDate) {
		this.dirtCleaningDate = dirtCleaningDate;
	}

	public String getDirtCleaningPlace() {
		return this.dirtCleaningPlace;
	}

	public void setDirtCleaningPlace(String dirtCleaningPlace) {
		this.dirtCleaningPlace = dirtCleaningPlace;
	}

	public Date getTerSterDate() {
		return this.terSterDate;
	}

	public void setTerSterDate(Date terSterDate) {
		this.terSterDate = terSterDate;
	}

	public Date getFarmMedTime() {
		return this.farmMedTime;
	}

	public void setFarmMedTime(Date farmMedTime) {
		this.farmMedTime = farmMedTime;
	}

	public String getFarmMedNum() {
		return this.farmMedNum;
	}

	public void setFarmMedNum(String farmMedNum) {
		this.farmMedNum = farmMedNum;
	}

	public String getFarmSketches() {
		return this.farmSketches;
	}

	public void setFarmSketches(String farmSketches) {
		this.farmSketches = farmSketches;
	}

	public String getFarmSummary() {
		return this.farmSummary;
	}

	public void setFarmSummary(String farmSummary) {
		this.farmSummary = farmSummary;
	}

	public String getInfectiousFocusDispose() {
		return this.infectiousFocusDispose;
	}

	public void setInfectiousFocusDispose(String infectiousFocusDispose) {
		this.infectiousFocusDispose = infectiousFocusDispose;
	}

	public String getFarmPeopleNum() {
		return this.farmPeopleNum;
	}

	public void setFarmPeopleNum(String farmPeopleNum) {
		this.farmPeopleNum = farmPeopleNum;
	}

	public String getIsFeverRespiratoryNum() {
		return this.isFeverRespiratoryNum;
	}

	public void setIsFeverRespiratoryNum(String isFeverRespiratoryNum) {
		this.isFeverRespiratoryNum = isFeverRespiratoryNum;
	}

	public String getContactFormOther() {
		return this.contactFormOther;
	}

	public void setContactFormOther(String contactFormOther) {
		this.contactFormOther = contactFormOther;
	}

    public String getFarmAddr() {
        return this.farmAddr;
    }

    public void setFarmAddr(String farmAddr) {
        this.farmAddr = farmAddr;
    }

    public Date getFarmDt() {
        return this.farmDt;
    }

    public void setFarmDt(Date farmDt) {
        this.farmDt = farmDt;
    }

    public String getFarmTimes() {
        return this.farmTimes;
    }

    public void setFarmTimes(String farmTimes) {
        this.farmTimes = farmTimes;
    }

    public String getContactDegree() {
        return this.contactDegree;
    }

    public void setContactDegree(String contactDegree) {
        this.contactDegree = contactDegree;
    }

    public String getInContact() {
        return this.inContact;
    }

    public void setInContact(String inContact) {
        this.inContact = inContact;
    }

    public String getInContactOther() {
        return this.inContactOther;
    }

    public void setInContactOther(String inContactOther) {
        this.inContactOther = inContactOther;
    }

    public String getOutContact() {
        return this.outContact;
    }

    public void setOutContact(String outContact) {
        this.outContact = outContact;
    }

    public String getOutContactOther() {
        return this.outContactOther;
    }

    public void setOutContactOther(String outContactOther) {
        this.outContactOther = outContactOther;
    }

    public String getIsFarm() {
        return this.isFarm;
    }

    public void setIsFarm(String isFarm) {
        this.isFarm = isFarm;
    }

    public String getFarmName() {
        return this.farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getFarmRange() {
        return this.farmRange;
    }

    public void setFarmRange(String farmRange) {
        this.farmRange = farmRange;
    }

    public String getFarmArea() {
        return this.farmArea;
    }

    public void setFarmArea(String farmArea) {
        this.farmArea = farmArea;
    }

    public String getFarmForeignNum() {
        return this.farmForeignNum;
    }

    public void setFarmForeignNum(String farmForeignNum) {
        this.farmForeignNum = farmForeignNum;
    }

    public String getDrugName() {
        return this.drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public Date getMosquitoDt() {
        return this.mosquitoDt;
    }

    public void setMosquitoDt(Date mosquitoDt) {
        this.mosquitoDt = mosquitoDt;
    }

    public String getMosquitoDrugName() {
        return this.mosquitoDrugName;
    }

    public void setMosquitoDrugName(String mosquitoDrugName) {
        this.mosquitoDrugName = mosquitoDrugName;
    }

    public String getMosquitoRange() {
        return this.mosquitoRange;
    }

    public void setMosquitoRange(String mosquitoRange) {
        this.mosquitoRange = mosquitoRange;
    }

    public Date getHeDt() {
        return this.heDt;
    }

    public void setHeDt(Date heDt) {
        this.heDt = heDt;
    }

    public String getHeContent() {
        return this.heContent;
    }

    public void setHeContent(String heContent) {
        this.heContent = heContent;
    }

    public String getHeNum() {
        return this.heNum;
    }

    public void setHeNum(String heNum) {
        this.heNum = heNum;
    }

	public String getDiseaseReportHour() {
		return diseaseReportHour;
	}

	public void setDiseaseReportHour(String diseaseReportHour) {
		this.diseaseReportHour = diseaseReportHour;
	}

	public String getDiseaseSceneHour() {
		return diseaseSceneHour;
	}

	public void setDiseaseSceneHour(String diseaseSceneHour) {
		this.diseaseSceneHour = diseaseSceneHour;
	}

	public String getRemoveHour() {
		return removeHour;
	}

	public void setRemoveHour(String removeHour) {
		this.removeHour = removeHour;
	}

	public String getTermSterHour() {
		return termSterHour;
	}

	public void setTermSterHour(String termSterHour) {
		this.termSterHour = termSterHour;
	}

}
