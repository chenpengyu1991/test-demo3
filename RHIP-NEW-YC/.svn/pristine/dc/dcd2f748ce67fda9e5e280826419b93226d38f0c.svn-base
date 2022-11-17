package com.founder.rhip.ehr.entity.management.mhm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "MHM_FOLLOWUP")
public class MhmFollowup implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "STATUS_ID", columnDefinition = "NUMBER|状态表id|11|", length = 11, nullable = false)
	private Long statusId;
	
	@Column(name = "EVENT_ID", columnDefinition = "NUMBER|本系统唯一编码|11|", length = 11, nullable = false)
	private Long eventId;

	@Column(name = "TYPE", columnDefinition = "VARCHAR2|随访状态（1随访，2失访）|2|", length = 2, nullable = true)
	private String type;

	@Column(name = "FOLLOWUP_DT", columnDefinition = "DATE|随访日期||", nullable = true)
	private Date followupDt;

	@Column(name = "PATIENT_TYPE", columnDefinition = "VARCHAR2|病人类型（重性:1、非重性:2）|20|", length = 20, nullable = true)
	private String patientType;
	
	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证|18|", length = 18, nullable = true)
	private String idcard;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名|20|", length = 20, nullable = true)
	private String name;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别|1|", length = 1, nullable = true)
	private String gender;

	@Column(name = "AGE", columnDefinition = "NUMBER|年龄|3|", length = 3, nullable = true)
	private Integer age;

	@Column(name = "FOLLOWUP_CATEGORY", columnDefinition = "VARCHAR2|失访分类|20|", length = 20, nullable = true)
	private String followupCategory;

	@Column(name = "ILLNESS_TYPE", columnDefinition = "VARCHAR2|基础管理随访病情分类|20|", length = 20, nullable = true)
	private String illnessType;

	@Column(name = "FOLLOWUP_TYPE", columnDefinition = "VARCHAR2|随访方式|20|", length = 20, nullable = true)
	private String followupType;

	@Column(name = "RISK_REGISTER", columnDefinition = "VARCHAR2|危险性评估登记|20|", length = 20, nullable = true)
	private String riskRegister;

	@Column(name = "LOCK_STATE", columnDefinition = "VARCHAR2|关锁情况|2|", length = 2, nullable = true)
	private String lockState;

	@Column(name = "HOSPITAL_COURSE", columnDefinition = "VARCHAR2|住院情况|200|", length = 200, nullable = true)
	private String hospitalCourse;

	@Column(name = "LASTLEAVE_HOSPITAL_DATE", columnDefinition = "DATE|末次出院日期||", nullable = true)
	private Date lastleaveHospitalDate;

	@Column(name = "ECONOMIC_GRANT_DEPT", columnDefinition = "VARCHAR2|是否获住院经济补贴|2|", length = 2, nullable = true)
	private String economicGrantDept;

	@Column(name = "FREE_INHOSPITAL", columnDefinition = "VARCHAR2|是否686免费住院治疗|2|", length = 2, nullable = true)
	private String freeInhospital;

	@Column(name = "SYMPTOM", columnDefinition = "VARCHAR2|目前症状|100|", length = 100, nullable = true)
	private String symptom;

	@Column(name = "SYMPTOM_OTHER", columnDefinition = "VARCHAR2|其他症状|100|", length = 100, nullable = true)
	private String symptomOther;

	@Column(name = "INSIGHT", columnDefinition = "VARCHAR2|自知力|2|", length = 2, nullable = true)
	private String insight;

	@Column(name = "SLEEP_CONDITION", columnDefinition = "VARCHAR2|睡眠情况|2|", length = 2, nullable = true)
	private String sleepCondition;

	@Column(name = "DIET_CONDITION", columnDefinition = "VARCHAR2|饮食情况|2|", length = 2, nullable = true)
	private String dietCondition;

	@Column(name = "LIVE_ARRANGE", columnDefinition = "VARCHAR2|个人生活料理|2|", length = 2, nullable = true)
	private String liveArrange;

	@Column(name = "HOUSEWORK", columnDefinition = "VARCHAR2|家务劳动|2|", length = 2, nullable = true)
	private String housework;

	@Column(name = "PRODUCTIVE_LABOR", columnDefinition = "VARCHAR2|生产劳动及工作|2|", length = 2, nullable = true)
	private String productiveLabor;

	@Column(name = "STUDY_CAPACITY", columnDefinition = "VARCHAR2|学习能力|2|", length = 2, nullable = true)
	private String studyCapacity;

	@Column(name = "INTERPERSONAL_COMMUNICATION", columnDefinition = "VARCHAR2|社会人际交往|2|", length = 2, nullable = true)
	private String interpersonalCommunication;

	@Column(name = "MILD_AFFRAY", columnDefinition = "VARCHAR2|滋事|20|", length = 20, nullable = true)
	private String mildAffray;

	@Column(name = "CAUSE_TROUBLE", columnDefinition = "VARCHAR2|肇事|20|", length = 20, nullable = true)
	private String causeTrouble;

	@Column(name = "ACCIDENT", columnDefinition = "VARCHAR2|肇祸|20|", length = 20, nullable = true)
	private String accident;

	@Column(name = "AUTOLESION", columnDefinition = "VARCHAR2|自伤|20|", length = 20, nullable = true)
	private String autolesion;

	@Column(name = "ATTEMPTED_SUICIDE", columnDefinition = "VARCHAR2|自杀未遂|20|", length = 20, nullable = true)
	private String attemptedSuicide;

	@Column(name = "MEDICATION_COMPLIANCE", columnDefinition = "VARCHAR2|服药依从性|2|", length = 2, nullable = true)
	private String medicationCompliance;

	@Column(name = "DRUG_ADVERSE_REACTION", columnDefinition = "VARCHAR2|药物不良反应|100|", length = 100, nullable = true)
	private String drugAdverseReaction;

	@Column(name = "DRUG_ADVERSE_REACTION_OTHER", columnDefinition = "VARCHAR2|药物不良反应其他情况|100|", length = 100, nullable = true)
	private String drugAdverseReactionOther;

	@Column(name = "THERAPEUTIC_EFFECT", columnDefinition = "VARCHAR2|治疗效果|2|", length = 2, nullable = true)
	private String therapeuticEffect;

	@Column(name = "REFERRALS", columnDefinition = "VARCHAR2|转诊|2|", length = 2, nullable = true)
	private String referrals;

	@Column(name = "REFERRALS_REASON", columnDefinition = "VARCHAR2|转诊原因|100|", length = 100, nullable = true)
	private String referralsReason;

	@Column(name = "REFERRALS_TO_ORGAN", columnDefinition = "VARCHAR2|转诊至机构|100|", length = 100, nullable = true)
	private String referralsToOrgan;

	@Column(name = "IS_CHECK", columnDefinition = "VARCHAR2|是否实验室检查|2|", length = 2, nullable = true)
	private String isCheck;
	
	@Column(name = "CHECK_TYPE", columnDefinition = "VARCHAR2|化验检查类型（多选）|100|", length = 100, nullable = true)
	private String checkType;
	
	@Column(name = "CHECK_OTHER", columnDefinition = "VARCHAR2|化验检查其他|100|", length = 100, nullable = true)
	private String checkOther;	
	
	@Column(name = "CHECK_RESULT", columnDefinition = "VARCHAR2|实验室检查结果|400|", length = 400, nullable = true)
	private String checkResult;

	@Column(name = "UNCURE_REASON", columnDefinition = "VARCHAR2|未治疗原因|2|", length = 2, nullable = true)
	private String uncureReason;

	@Column(name = "UNCURE_REASON_OTHER", columnDefinition = "VARCHAR2|未治疗原因其他|100|", length = 100, nullable = true)
	private String uncureReasonOther;

	@Column(name = "RECOVERY_MEASURES", columnDefinition = "VARCHAR2|康复措施|100|", length = 100, nullable = true)
	private String RecoveryMeasures;

	@Column(name = "RECOVERY_MEASURES_OTHER", columnDefinition = "VARCHAR2|康复措施其他|100|", length = 100, nullable = true)
	private String RecoveryMeasuresOther;

	@Column(name = "EVALUATION", columnDefinition = "VARCHAR2|病情总体评估|2|", length = 2, nullable = true)
	private String evaluation;

	@Column(name = "SOCIAL_FUNCTION", columnDefinition = "VARCHAR2|社会功能总评|2|", length = 2, nullable = true)
	private String socialFunction;

	@Column(name = "EMERGENCY_DISPOSAL", columnDefinition = "VARCHAR2|应急处置|2|", length = 2, nullable = true)
	private String emergencyDisposal;

    @Column(name = "IS_CASE", columnDefinition = "VARCHAR2|有否进行个案管理|2|", length = 2, nullable = true)
    private String isCase;

	@Column(name = "NEXT_FOLLOWUP_DT", columnDefinition = "DATE|下次随访日期||", nullable = true)
	private Date nextFollowupDt;

	@Column(name = "COMMENTS", columnDefinition = "VARCHAR2|备注|400|", length = 400, nullable = true)
	private String comments;

	@Column(name = "LOSE_REASON", columnDefinition = "VARCHAR2|失访原因|2|", length = 2, nullable = true)
	private String loseReason;

    @Column(name = "LOSE_REASON_OTHER", columnDefinition = "VARCHAR2|失访原因其他|100|", length = 100, nullable = true)
    private String loseReasonOther;

	@Column(name = "LOSE_REASON_DETAIL", columnDefinition = "VARCHAR2|失访原因说明|100|", length = 100, nullable = true)
	private String loseReasonDetail;

	@Column(name = "REPORT_DT", columnDefinition = "DATE|报告时间||", nullable = true)
	private Date reportDt;

	@Column(name = "DIEDT", columnDefinition = "DATE|死亡日期||", nullable = true)
	private Date dieDt;

	@Column(name = "DIE_REASON", columnDefinition = "VARCHAR2|死亡原因|2|", length = 2, nullable = true)
	private String dieReason;

    @Column(name = "DIE_REASON_OTHER", columnDefinition = "VARCHAR2|死亡原因其他|100|", length = 100, nullable = true)
    private String dieReasonOther;

	@Column(name = "DIE_REASON_DETAIL", columnDefinition = "VARCHAR2|死亡原因说明|100|", length = 100, nullable = true)
	private String dieReasonDetail;

	@Column(name = "FILL_ORGAN_CODE", columnDefinition = "VARCHAR2|填写机构|100|", length = 100, nullable = true)
	private String fillOrganCode;

	@Column(name = "FILL_DOCTOR_ID", columnDefinition = "VARCHAR2|填写医生|50|", length = 50, nullable = true)
	private String fillDoctorId;

	@Column(name = "FILL_DATE", columnDefinition = "DATE|填写日期||", nullable = true)
	private Date fillDate;

	@Column(name = "MODIFY_DOCTOR_ID", columnDefinition = "VARCHAR2|修改医生|50|", length = 50, nullable = true)
	private String modifyDoctorId;

	@Column(name = "MODIFY_ORGAN_CODE", columnDefinition = "VARCHAR2|修改机构|100|", length = 100, nullable = true)
	private String modifyOrganCode;

	@Column(name = "MODIFY_DATE", columnDefinition = "DATE|修改日期||", nullable = true)
	private Date modifyDate;

	@Column(name = "FOLLOWUP_STATUS", columnDefinition = "VARCHAR2|审核状态(0未审核；1通过；2未通过)|2|", length = 2, nullable = true)
	private String followupStatus;
	
	@Column(name = "FOLLOWUP_PATIENTS", columnDefinition = "VARCHAR2|本次随访对象|2|", length = 2, nullable = true)
	private String followupPatients;
	@Column(name = "DIE_REASON_PATHOGENY", columnDefinition = "VARCHAR2|死亡原因-躯体疾病|2|", length = 2, nullable = true)
	private String dieReasonPathogeny;
	@Column(name = "OTHER_HARMFUL_BEHAVIORS", columnDefinition = "VARCHAR2|其他危害行为|20|", length = 20, nullable = true)
	private String otherHarmfulBehaviors;
	@Column(name = "completed_referral", columnDefinition = "VARCHAR2|是否已转诊|2|", length = 2, nullable = true)
	private String completedReferral;
	
	@Column(name = "MEDICATION_ONE", columnDefinition = "VARCHAR2|用药情况-药物1|50|", length = 50, nullable = true)
	private String medicationOne;
	
	@Column(name = "MEDICATION_TWO", columnDefinition = "VARCHAR2|用药情况-药物2|50|", length = 50, nullable = true)
	private String medicationTwo;
	
	@Column(name = "MEDICATION_THREE", columnDefinition = "VARCHAR2|用药情况-药物3|50|", length = 50, nullable = true)
	private String medicationThree;
	
	@Column(name = "MEDICATION_DOSE_ONE", columnDefinition = "VARCHAR2|用药情况-药物1-每日(月)剂量|20|", length = 20, nullable = true)
	private String medicationDoseOne;
	
	@Column(name = "MEDICATION_DOSE_TWO", columnDefinition = "VARCHAR2|用药情况-药物2-每日(月)剂量|20|", length = 20, nullable = true)
	private String medicationDoseTwo;
	
	@Column(name = "MEDICATION_DOSE_THREE", columnDefinition = "VARCHAR2|用药情况-药物3-每日(月)剂量|20|", length = 20, nullable = true)
	private String medicationDoseThree;
	
	@Column(name = "GUIDANCE_ONE", columnDefinition = "VARCHAR2|用药指导-药物1|50|", length = 50, nullable = true)
	private String guidanceOne;
	
	@Column(name = "GUIDANCE_TWO", columnDefinition = "VARCHAR2|用药指导-药物2|50|", length = 50, nullable = true)
	private String guidanceTwo;
	
	@Column(name = "GUIDANCE_THREE", columnDefinition = "VARCHAR2|用药指导-药物3|50|", length = 50, nullable = true)
	private String guidanceThree;
	
	@Column(name = "MORNING_ONE", columnDefinition = "VARCHAR2|用药指导-药物1-早|20|", length = 20, nullable = true)
	private String morningOne;
	
	@Column(name = "MORNING_TWO", columnDefinition = "VARCHAR2|用药指导-药物2-早|20|", length = 20, nullable = true)
	private String morningTwo;
	
	@Column(name = "MORNING_THREE", columnDefinition = "VARCHAR2|用药指导-药物3-早|20|", length = 20, nullable = true)
	private String morningThree;
	
	@Column(name = "NOON_ONE", columnDefinition = "VARCHAR2|用药指导-药物1-中|20|", length = 20, nullable = true)
	private String noonOne;
	
	@Column(name = "NOON_TWO", columnDefinition = "VARCHAR2|用药指导-药物2-中|20|", length = 20, nullable = true)
	private String noonTwo;
	
	@Column(name = "NOON_THREE", columnDefinition = "VARCHAR2|用药指导-药物3-中|20|", length = 20, nullable = true)
	private String noonThree;
	
	@Column(name = "NIGHT_ONE", columnDefinition = "VARCHAR2|用药指导-药物1-晚|20|", length = 20, nullable = true)
	private String nightOne;
	
	@Column(name = "NIGHT_TWO", columnDefinition = "VARCHAR2|用药指导-药物2-晚|20|", length = 20, nullable = true)
	private String nightTwo;
	
	@Column(name = "NIGHT_THREE", columnDefinition = "VARCHAR2|用药指导-药物3-晚|20|", length = 20, nullable = true)
	private String nightThree;
	
	@Column(name = "WEEK_ONE", columnDefinition = "VARCHAR2|用药指导-长效药1|20|", length = 20, nullable = true)
	private String weekOne;
	
	@Column(name = "WEEK_TWO", columnDefinition = "VARCHAR2|用药指导-长效药2|20|", length = 20, nullable = true)
	private String weekTwo;
	
	@Column(name = "WEEK_THREE", columnDefinition = "VARCHAR2|用药指导-长效药3|20|", length = 20, nullable = true)
	private String weekThree;
	
	@Column(name = "TIME_ONE", columnDefinition = "VARCHAR2|用药指导-长效药1-每次|20|", length = 20, nullable = true)
	private String timeOne;
	
	@Column(name = "TIME_TWO", columnDefinition = "VARCHAR2|用药指导-长效药2-每次|20|", length = 20, nullable = true)
	private String timeTwo;
	
	@Column(name = "TIME_THREE", columnDefinition = "VARCHAR2|用药指导-长效药3-每次|20|", length = 20, nullable = true)
	private String timeThree;
	
	public String getWeekOne() {
		return weekOne;
	}

	public void setWeekOne(String weekOne) {
		this.weekOne = weekOne;
	}

	public String getWeekTwo() {
		return weekTwo;
	}

	public void setWeekTwo(String weekTwo) {
		this.weekTwo = weekTwo;
	}

	public String getWeekThree() {
		return weekThree;
	}

	public void setWeekThree(String weekThree) {
		this.weekThree = weekThree;
	}

	public String getTimeOne() {
		return timeOne;
	}

	public void setTimeOne(String timeOne) {
		this.timeOne = timeOne;
	}

	public String getTimeTwo() {
		return timeTwo;
	}

	public void setTimeTwo(String timeTwo) {
		this.timeTwo = timeTwo;
	}

	public String getTimeThree() {
		return timeThree;
	}

	public void setTimeThree(String timeThree) {
		this.timeThree = timeThree;
	}

	public String getMedicationOne() {
		return medicationOne;
	}

	public void setMedicationOne(String medicationOne) {
		this.medicationOne = medicationOne;
	}

	public String getMedicationTwo() {
		return medicationTwo;
	}

	public void setMedicationTwo(String medicationTwo) {
		this.medicationTwo = medicationTwo;
	}

	public String getMedicationThree() {
		return medicationThree;
	}

	public void setMedicationThree(String medicationThree) {
		this.medicationThree = medicationThree;
	}

	public String getMedicationDoseOne() {
		return medicationDoseOne;
	}

	public void setMedicationDoseOne(String medicationDoseOne) {
		this.medicationDoseOne = medicationDoseOne;
	}

	public String getMedicationDoseTwo() {
		return medicationDoseTwo;
	}

	public void setMedicationDoseTwo(String medicationDoseTwo) {
		this.medicationDoseTwo = medicationDoseTwo;
	}

	public String getMedicationDoseThree() {
		return medicationDoseThree;
	}

	public void setMedicationDoseThree(String medicationDoseThree) {
		this.medicationDoseThree = medicationDoseThree;
	}

	public String getGuidanceOne() {
		return guidanceOne;
	}

	public void setGuidanceOne(String guidanceOne) {
		this.guidanceOne = guidanceOne;
	}

	public String getGuidanceTwo() {
		return guidanceTwo;
	}

	public void setGuidanceTwo(String guidanceTwo) {
		this.guidanceTwo = guidanceTwo;
	}

	public String getGuidanceThree() {
		return guidanceThree;
	}

	public void setGuidanceThree(String guidanceThree) {
		this.guidanceThree = guidanceThree;
	}

	public String getMorningOne() {
		return morningOne;
	}

	public void setMorningOne(String morningOne) {
		this.morningOne = morningOne;
	}

	public String getMorningTwo() {
		return morningTwo;
	}

	public void setMorningTwo(String morningTwo) {
		this.morningTwo = morningTwo;
	}

	public String getMorningThree() {
		return morningThree;
	}

	public void setMorningThree(String morningThree) {
		this.morningThree = morningThree;
	}

	public String getNoonOne() {
		return noonOne;
	}

	public void setNoonOne(String noonOne) {
		this.noonOne = noonOne;
	}

	public String getNoonTwo() {
		return noonTwo;
	}

	public void setNoonTwo(String noonTwo) {
		this.noonTwo = noonTwo;
	}

	public String getNoonThree() {
		return noonThree;
	}

	public void setNoonThree(String noonThree) {
		this.noonThree = noonThree;
	}

	public String getNightOne() {
		return nightOne;
	}

	public void setNightOne(String nightOne) {
		this.nightOne = nightOne;
	}

	public String getNightTwo() {
		return nightTwo;
	}

	public void setNightTwo(String nightTwo) {
		this.nightTwo = nightTwo;
	}

	public String getNightThree() {
		return nightThree;
	}

	public void setNightThree(String nightThree) {
		this.nightThree = nightThree;
	}

	public String getCompletedReferral() {
		return completedReferral;
	}

	public void setCompletedReferral(String completedReferral) {
		this.completedReferral = completedReferral;
	}

	public String getDieReasonPathogeny() {
		return dieReasonPathogeny;
	}

	public String getOtherHarmfulBehaviors() {
		return otherHarmfulBehaviors;
	}

	public void setOtherHarmfulBehaviors(String otherHarmfulBehaviors) {
		this.otherHarmfulBehaviors = otherHarmfulBehaviors;
	}

	public void setDieReasonPathogeny(String dieReasonPathogeny) {
		this.dieReasonPathogeny = dieReasonPathogeny;
	}

	public String getFollowupPatients() {
		return followupPatients;
	}

	public void setFollowupPatients(String followupPatients) {
		this.followupPatients = followupPatients;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getFollowupDt() {
		return this.followupDt;
	}

	public void setFollowupDt(Date followupDt) {
		this.followupDt = followupDt;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
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

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getFollowupCategory() {
		return this.followupCategory;
	}

	public void setFollowupCategory(String followupCategory) {
		this.followupCategory = followupCategory;
	}

	public String getIllnessType() {
		return this.illnessType;
	}

	public void setIllnessType(String illnessType) {
		this.illnessType = illnessType;
	}

	public String getFollowupType() {
		return this.followupType;
	}

	public void setFollowupType(String followupType) {
		this.followupType = followupType;
	}

	public String getRiskRegister() {
		return this.riskRegister;
	}

	public void setRiskRegister(String riskRegister) {
		this.riskRegister = riskRegister;
	}

	public String getLockState() {
		return this.lockState;
	}

	public void setLockState(String lockState) {
		this.lockState = lockState;
	}

	public String getHospitalCourse() {
		return this.hospitalCourse;
	}

	public void setHospitalCourse(String hospitalCourse) {
		this.hospitalCourse = hospitalCourse;
	}

	public Date getLastleaveHospitalDate() {
		return this.lastleaveHospitalDate;
	}

	public void setLastleaveHospitalDate(Date lastleaveHospitalDate) {
		this.lastleaveHospitalDate = lastleaveHospitalDate;
	}

	public String getEconomicGrantDept() {
		return this.economicGrantDept;
	}

	public void setEconomicGrantDept(String economicGrantDept) {
		this.economicGrantDept = economicGrantDept;
	}

	public String getFreeInhospital() {
		return this.freeInhospital;
	}

	public void setFreeInhospital(String freeInhospital) {
		this.freeInhospital = freeInhospital;
	}

	public String getSymptom() {
		return this.symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getSymptomOther() {
		return this.symptomOther;
	}

	public void setSymptomOther(String symptomOther) {
		this.symptomOther = symptomOther;
	}

	public String getInsight() {
		return this.insight;
	}

	public void setInsight(String insight) {
		this.insight = insight;
	}

	public String getSleepCondition() {
		return this.sleepCondition;
	}

	public void setSleepCondition(String sleepCondition) {
		this.sleepCondition = sleepCondition;
	}

	public String getDietCondition() {
		return this.dietCondition;
	}

	public void setDietCondition(String dietCondition) {
		this.dietCondition = dietCondition;
	}

	public String getLiveArrange() {
		return this.liveArrange;
	}

	public void setLiveArrange(String liveArrange) {
		this.liveArrange = liveArrange;
	}

	public String getHousework() {
		return this.housework;
	}

	public void setHousework(String housework) {
		this.housework = housework;
	}

	public String getProductiveLabor() {
		return this.productiveLabor;
	}

	public void setProductiveLabor(String productiveLabor) {
		this.productiveLabor = productiveLabor;
	}

	public String getStudyCapacity() {
		return this.studyCapacity;
	}

	public void setStudyCapacity(String studyCapacity) {
		this.studyCapacity = studyCapacity;
	}

	public String getInterpersonalCommunication() {
		return this.interpersonalCommunication;
	}

	public void setInterpersonalCommunication(String interpersonalCommunication) {
		this.interpersonalCommunication = interpersonalCommunication;
	}

	public String getMildAffray() {
		return this.mildAffray;
	}

	public void setMildAffray(String mildAffray) {
		this.mildAffray = mildAffray;
	}

	public String getCauseTrouble() {
		return this.causeTrouble;
	}

	public void setCauseTrouble(String causeTrouble) {
		this.causeTrouble = causeTrouble;
	}

	public String getAccident() {
		return this.accident;
	}

	public void setAccident(String accident) {
		this.accident = accident;
	}

	public String getAutolesion() {
		return this.autolesion;
	}

	public void setAutolesion(String autolesion) {
		this.autolesion = autolesion;
	}

	public String getAttemptedSuicide() {
		return this.attemptedSuicide;
	}

	public void setAttemptedSuicide(String attemptedSuicide) {
		this.attemptedSuicide = attemptedSuicide;
	}

	public String getMedicationCompliance() {
		return this.medicationCompliance;
	}

	public void setMedicationCompliance(String medicationCompliance) {
		this.medicationCompliance = medicationCompliance;
	}

	public String getDrugAdverseReaction() {
		return this.drugAdverseReaction;
	}

	public void setDrugAdverseReaction(String drugAdverseReaction) {
		this.drugAdverseReaction = drugAdverseReaction;
	}

	public String getDrugAdverseReactionOther() {
		return this.drugAdverseReactionOther;
	}

	public void setDrugAdverseReactionOther(String drugAdverseReactionOther) {
		this.drugAdverseReactionOther = drugAdverseReactionOther;
	}

	public String getTherapeuticEffect() {
		return this.therapeuticEffect;
	}

	public void setTherapeuticEffect(String therapeuticEffect) {
		this.therapeuticEffect = therapeuticEffect;
	}

	public String getReferrals() {
		return this.referrals;
	}

	public void setReferrals(String referrals) {
		this.referrals = referrals;
	}

	public String getReferralsReason() {
		return this.referralsReason;
	}

	public void setReferralsReason(String referralsReason) {
		this.referralsReason = referralsReason;
	}

	public String getReferralsToOrgan() {
		return this.referralsToOrgan;
	}

	public void setReferralsToOrgan(String referralsToOrgan) {
		this.referralsToOrgan = referralsToOrgan;
	}

	public String getIsCheck() {
		return this.isCheck;
	}

	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}

	public String getCheckResult() {
		return this.checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	public String getUncureReason() {
		return this.uncureReason;
	}

	public void setUncureReason(String uncureReason) {
		this.uncureReason = uncureReason;
	}

	public String getUncureReasonOther() {
		return this.uncureReasonOther;
	}

	public void setUncureReasonOther(String uncureReasonOther) {
		this.uncureReasonOther = uncureReasonOther;
	}

	public String getRecoveryMeasures() {
		return this.RecoveryMeasures;
	}

	public void setRecoveryMeasures(String RecoveryMeasures) {
		this.RecoveryMeasures = RecoveryMeasures;
	}

	public String getRecoveryMeasuresOther() {
		return this.RecoveryMeasuresOther;
	}

	public void setRecoveryMeasuresOther(String RecoveryMeasuresOther) {
		this.RecoveryMeasuresOther = RecoveryMeasuresOther;
	}

	public String getEvaluation() {
		return this.evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public String getSocialFunction() {
		return this.socialFunction;
	}

	public void setSocialFunction(String socialFunction) {
		this.socialFunction = socialFunction;
	}

	public String getEmergencyDisposal() {
		return this.emergencyDisposal;
	}

	public void setEmergencyDisposal(String emergencyDisposal) {
		this.emergencyDisposal = emergencyDisposal;
	}


	public Date getNextFollowupDt() {
		return this.nextFollowupDt;
	}

    public String getIsCase() {
        return this.isCase;
    }

    public void setIsCase(String isCase) {
    	this.isCase = isCase;
    }

    public void setNextFollowupDt(Date nextFollowupDt) {
		this.nextFollowupDt = nextFollowupDt;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getLoseReason() {
		return this.loseReason;
	}

	public void setLoseReason(String loseReason) {
		this.loseReason = loseReason;
	}

    public String getLoseReasonOther() {
        return loseReasonOther;
    }

    public void setLoseReasonOther(String loseReasonOther) {
        this.loseReasonOther = loseReasonOther;
    }

    public String getLoseReasonDetail() {
		return this.loseReasonDetail;
	}

	public void setLoseReasonDetail(String loseReasonDetail) {
		this.loseReasonDetail = loseReasonDetail;
	}

	public Date getReportDt() {
		return this.reportDt;
	}

	public void setReportDt(Date reportDt) {
		this.reportDt = reportDt;
	}

	public Date getDieDt() {
		return this.dieDt;
	}

	public void setDieDt(Date dieDt) {
		this.dieDt = dieDt;
	}

	public String getDieReason() {
		return this.dieReason;
	}

	public void setDieReason(String dieReason) {
		this.dieReason = dieReason;
	}

    public String getDieReasonOther() {
        return dieReasonOther;
    }

    public void setDieReasonOther(String dieReasonOther) {
        this.dieReasonOther = dieReasonOther;
    }

    public String getDieReasonDetail() {
		return this.dieReasonDetail;
	}

	public void setDieReasonDetail(String dieReasonDetail) {
		this.dieReasonDetail = dieReasonDetail;
	}

	public String getFillOrganCode() {
		return this.fillOrganCode;
	}

	public void setFillOrganCode(String fillOrganCode) {
		this.fillOrganCode = fillOrganCode;
	}

	public String getFillDoctorId() {
		return this.fillDoctorId;
	}

	public void setFillDoctorId(String fillDoctorId) {
		this.fillDoctorId = fillDoctorId;
	}

	public Date getFillDate() {
		return this.fillDate;
	}

	public void setFillDate(Date fillDate) {
		this.fillDate = fillDate;
	}

	public String getModifyDoctorId() {
		return this.modifyDoctorId;
	}

	public void setModifyDoctorId(String modifyDoctorId) {
		this.modifyDoctorId = modifyDoctorId;
	}

	public String getModifyOrganCode() {
		return this.modifyOrganCode;
	}

	public void setModifyOrganCode(String modifyOrganCode) {
		this.modifyOrganCode = modifyOrganCode;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	public String getCheckOther() {
		return checkOther;
	}

	public void setCheckOther(String checkOther) {
		this.checkOther = checkOther;
	}

	public String getPatientType() {
		return patientType;
	}

	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getFollowupStatus() {
		return followupStatus;
	}

	public void setFollowupStatus(String followupStatus) {
		this.followupStatus = followupStatus;
	}

}