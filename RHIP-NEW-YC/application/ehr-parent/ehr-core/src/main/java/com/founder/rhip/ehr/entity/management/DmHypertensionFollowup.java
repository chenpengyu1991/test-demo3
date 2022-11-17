package com.founder.rhip.ehr.entity.management;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "DM_HYPERTENSION_FOLLOWUP")
public class DmHypertensionFollowup implements Serializable {

	private static final long serialVersionUID = 6551379003296424633L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;

	@Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
	private String ehrId;

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|个人信息唯一编号||", length = 11, nullable = true)
	private Long personId;

	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|居民身份证/健康卡号||", length = 18, nullable = true)
	private String idcard;

	@Column(name = "VISIT_WAY_CODE", columnDefinition = "VARCHAR2|随访方式代码||", length = 1, nullable = true)
	private String visitWayCode;

	@Column(name = "CUR_SYMPTOM_FLAG", columnDefinition = "VARCHAR2|症状标志||", length = 1, nullable = true)
	private String curSymptomFlag;
	
	@Column(name = "CUR_SYMPTOM", columnDefinition = "VARCHAR2|症状代码组合||", length = 200, nullable = true)
	private String curSymptom;

	@Column(name = "OTHER_SYMPTOM", columnDefinition = "VARCHAR2|其他症状描述||", length = 300, nullable = true)
	private String otherSymptom;

	@Column(name = "OTHER_BODY_CHARACTERISTICS", columnDefinition = "VARCHAR2|体征其他||", length = 100, nullable = true)
	private String otherBodyCharacteristics;

	@Column(name = "INDEX_OF_BODY_CHARACTERISTICS", columnDefinition = "DECIMAL|体质指数||", length = 5, scale = 2, nullable = true)
	private BigDecimal indexOfBodyCharacteristics;
	
	@Column(name = "TURN_SICKNESS_REASON", columnDefinition = "VARCHAR2|转症原因||", length = 100, nullable = true)
	private String turnSicknessReason;

	@Column(name = "HEIGHT", columnDefinition = "DECIMAL|身高(cm)||", length = 5, scale = 1, nullable = true)
	private BigDecimal height;

	@Column(name = "BODY_WEIGHT", columnDefinition = "DECIMAL|体重(kg)||", length = 5, scale = 1, nullable = true)
	private BigDecimal bodyWeight;

	@Column(name = "HIP", columnDefinition = "DECIMAL|臀围(cm)||", length = 5, scale = 1, nullable = true)
	private BigDecimal hip;

	@Column(name = "WAOSTLINE", columnDefinition = "DECIMAL|腰围(cm)||", length = 5, scale = 1, nullable = true)
	private BigDecimal waostline;

	@Column(name = "SBP", columnDefinition = "NUMNER|收缩压(mmHg)||",length = 4,nullable = true)
	private Integer sbp;

	@Column(name = "DBP", columnDefinition = "NUMNER|舒张压(mmHg)||",length = 4,nullable = true)
	private Integer dbp;

	@Column(name = "HEART_RATE", columnDefinition = "NUMNER|心率(次/min)||",length = 3, nullable = true)
	private Integer heartRate;

	@Column(name = "SIGN_OTHER", columnDefinition = "VARCHAR2|体征其它|", length = 300, nullable = true)
	private String signOther;

	//TODO 名字 
	@Column(name = "DAILY_DAILY_SMOKEBER", columnDefinition = "NUMNER|日吸烟量(支)||",length = 4,nullable = true)
	private Integer dailyDailySmokeber;

	@Column(name = "DAILY_DRINK", columnDefinition = "NUMNER|日饮酒量(两)||",length = 4,nullable = true)
	private Integer dailyDrink;

	@Column(name = "TRAIN_FREQUENCY", columnDefinition = "NUMNER|运动频率||", length = 2, nullable = true)
	private Integer trainFrequency;

	@Column(name = "TRAINING_MIN", columnDefinition = "NUMNER|每次锻炼时间(min)||", length = 4, nullable = true)
	private Integer trainingMin;

	@Column(name = "SALT_CLASSIFICATION", columnDefinition = "VARCHAR2|摄盐量分级代码||", length = 1, nullable = true)
	private String saltClassification;

	@Column(name = "MENTALITY", columnDefinition = "VARCHAR2|心理调整评价代码||", length = 1, nullable = true)
	private String mentality;

	@Column(name = "COMPIANCE", columnDefinition = "VARCHAR2|遵医行为评价代码||", length = 1, nullable = true)
	private String compiance;

	@Column(name = "AE_RESULT_DESC", columnDefinition = "VARCHAR2|辅助检查结果描述||", length = 100, nullable = true)
	private String aeResultDesc;

	@Column(name = "MEDICATION_COMPLIANCE", columnDefinition = "VARCHAR2|服药依从性代码||", length = 1, nullable = true)
	private String medicationCompliance;

	@Column(name = "SIDE_EFFECTS", columnDefinition = "VARCHAR2|药物不良反应标志||", length = 1, nullable = true)
	private String sideEffects;

	@Column(name = "EFFECTS_STATE", columnDefinition = "VARCHAR2|药物不良反应描述||", length = 100, nullable = true)
	private String effectsState;

	@Column(name = "VISIT_TYPE", columnDefinition = "VARCHAR2|随访评价结果代码||", length = 1, nullable = true)
	private String visitType;

	@Column(name = "CHINESE_MEDICINE_TYPE", columnDefinition = "VARCHAR2|中药类别代码||", length = 1, nullable = true)
	private String chineseMedicineType;

	@Column(name = "DRUG_CODE_FIRST", columnDefinition = "VARCHAR2|第一种药物编码||", length = 12, nullable = true)
	private String drugCodeFirst;

	@Column(name = "DRUG_NAME_FIRST", columnDefinition = "VARCHAR2|第一种药物名称||", length = 16, nullable = true)
	private String drugNameFirst;

	@Column(name = "DRUG_PERDAY_FIRST", columnDefinition = "NUMNER|第一种药物使用频率||",length = 2, nullable = true)
	private Integer drugPerdayFirst;

	@Column(name = "DRUG_PERTIME_FIRST", columnDefinition = "DECIMAL|第一种药物每次剂量||",length = 8,scale = 2, nullable = true)
	private BigDecimal drugPertimeFirst;

	@Column(name = "DRUG_CODE_SECOND", columnDefinition = "VARCHAR2|第二种药物编码||", length = 12, nullable = true)
	private String drugCodeSecond;

	@Column(name = "DRUG_NAME_SECOND", columnDefinition = "VARCHAR2|第二种药物名称||", length = 16, nullable = true)
	private String drugNameSecond;

	@Column(name = "DRUG_PERDAY_SECOND", columnDefinition = "NUMNER|第二种药物使用频率||",length = 2, nullable = true)
	private Integer drugPerdaySecond;

	@Column(name = "DRUG_PERTIME_SECOND", columnDefinition = "DECIMAL|第二种药物每次剂量||",length = 8,scale = 2, nullable = true)
	private BigDecimal drugPertimeSecond;

	@Column(name = "DRUG_CODE_THIRD", columnDefinition = "VARCHAR2|第三种药物编码||", length = 12, nullable = true)
	private String drugCodeThird;

	@Column(name = "DRUG_NAME_THIRD", columnDefinition = "VARCHAR2|第三种药物名称||", length = 16, nullable = true)
	private String drugNameThird;

	@Column(name = "DRUG_PERDAY_THIRD", columnDefinition = "NUMNER|第三种药物使用频率||",length = 2, nullable = true)
	private Integer drugPerdayThird;

	@Column(name = "DRUG_PERTIME_THIRD", columnDefinition = "DECIMAL|第三种药物每次剂量||",length = 8,scale = 2, nullable = true)
	private BigDecimal drugPertimeThird;

	@Column(name = "VISIT_DATE", columnDefinition = "DATE|本次随访日期||", nullable = true)
	private Date visitDate;

	@Column(name = "NEXT_VISIT_DATE", columnDefinition = "DATE|下次随访日期||", nullable = true)
	private Date nextVisitDate;

	@Column(name = "VISIT_ORGAN_CODE", columnDefinition = "VARCHAR2|随访机构编码||", length = 15, nullable = true)
	private String visitOrganCode;

	@Column(name = "VISIT_ORGAN_NAME", columnDefinition = "VARCHAR2|随访机构名称||", length = 70, nullable = true)
	private String visitOrganName;

	@Column(name = "VISIT_IDCARD", columnDefinition = "VARCHAR2|随访人身份证号||", length = 18, nullable = true)
	private String visitIdcard;

	@Column(name = "VISIT_NAME", columnDefinition = "VARCHAR2|随访人姓名||", length = 50, nullable = true)
	private String visitName;

	@Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 70, nullable = true)
	private String createOrganName;

	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构编码||", length = 50, nullable = true)
	private String createOrganCode;

	@Column(name = "CREATE_DOCTOR_NAME", columnDefinition = "VARCHAR2|填报人姓名||", length = 50, nullable = true)
	private String createDoctorName;

	@Column(name = "CREATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|填报人编码||", length = 18, nullable = true)
	private String createDoctorCode;

	@Column(name = "CREATE_DATE", columnDefinition = "TIMESTAMP|填报时间||", nullable = true)
	private Date createDate;

	@Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|更新机构编码||", length = 50, nullable = true)
	private String updateOrganCode;

	@Column(name = "UPDATE_ORGAN_NAME", columnDefinition = "VARCHAR2|更新机构名称||", length = 70, nullable = true)
	private String updateOrganName;

	@Column(name = "UPDATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|更新人编码||", length = 18, nullable = true)
	private String updateDoctorCode;

	@Column(name = "UPDATE_DOCTOR_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 50, nullable = true)
	private String updateDoctorName;

	@Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP|更新日期和时间||", nullable = true)
	private Date updateDate;

	@Column(name = "IS_DELETE", columnDefinition = "INT|删除状态||", nullable = true)
	private Integer isDelete;

	@Column(name = "SALINITY", columnDefinition = "NUMBER|食盐量||", precision = 4, scale = 1, nullable = true)
	private BigDecimal salinity;

	@Column(name = "MEAT_MOUNT", columnDefinition = "NUMBER|食脂肪量||", precision = 6, scale = 1, nullable = true)
	private BigDecimal meatMount;

	@Column(name = "TC", columnDefinition = "NUMBER|总胆固醇||", precision = 5, scale = 2, nullable = true)
	private BigDecimal tc;
	
	@Column(name = "TRIGLYCERIDE_VALUE", columnDefinition = "NUMBER|甘油三酯||", precision = 3, scale = 1, nullable = true)
	private BigDecimal triglycerideValue;
	
	@Column(name = "LDLC_DETECT_VALUE", columnDefinition = "NUMBER|血清低密度脂蛋白胆固醇||", precision = 5, scale = 2, nullable = true)
	private BigDecimal ldlcDetectValue;
	
	@Column(name = "HDLC_DETECT_VALUE", columnDefinition = "NUMBER|血清高密度脂蛋白胆固醇||", precision = 5, scale = 1, nullable = true)
	private BigDecimal hdlcDetectValue;
	
	@Column(name = "REFERRAL_ORGAN_CODE ", columnDefinition = "VARCHAR2|转诊机构编码||", length = 50, nullable = true)
	private String referralOrganCode ;

	@Column(name = "REFERRAL_REASONS", columnDefinition = "VARCHAR2|转诊原因||", length = 300, nullable = true)
	private String referralReasons ;
	
	@Column(name = "REFERRAL_DEPARTMENT", columnDefinition = "VARCHAR2|转诊科别||", length = 100, nullable = true)
	private String referralDepartment;

	@Column(name = "REFERRAL_DOCTOR", columnDefinition = "VARCHAR2|转诊医生||", length = 100, nullable = true)
	private String referralDoctor;

	@Column(name = "REFERRAL_DATE", columnDefinition = "TIMESTAMP|转诊时间||", length = 100, nullable = true)
	private Date referralDate;

	@Column(name = "NEXT_FOLLOWUP_DAILY_DRINK", columnDefinition = "NUMNER|下次随访日饮酒量(两)||",length = 4,nullable = true)
	private Integer nextFollowupDailyDrink;
	
	@Column(name = "SMOKEBER_TARGET", columnDefinition = "NUMNER|下次随访日吸烟量(支)||",length = 4,nullable = true)
	private Integer smokeberTarget;
	
	@Column(name = "NEXT_FOLLOWUP_BMI", columnDefinition = "DECIMAL|下次随访达到的体质指数||", length = 5, scale = 2, nullable = true)
	private BigDecimal nextFollowupBmi;

	@Column(name = "NEXT_FOLLOWUP_BODY_WEIGHT", columnDefinition = "DECIMAL|下次随访达到体重(kg)||", length = 5, scale = 1, nullable = true)
	private BigDecimal nextFollowupBodyWeight;
	
	@Column(name = "REFERRAL_HBP_FLAG", columnDefinition = "VARCHAR2|转诊标识||", length = 1, nullable = true)
	private String referralHbpFlag;
	
	@Column(name = "MEDICATE_HBP_FLAG", columnDefinition = "VARCHAR2|用药标识||", length = 1, nullable = true)
	private String medicateHbpFlag;
	
	@Column(name = "NEXT_EXERCISE_FREQUENCY", columnDefinition = "NUMNER 下次随访运动次数||",length = 2,nullable = true)
	private Integer nextExerciseFrequency;

	@Column(name = "NEXT_EXERCISE_TIME", columnDefinition = "NUMNER|下次随访运动时间||", length = 4, nullable = true)
	private Integer nextExerciseTime;
	
	@Column(name = "NEXT_SALINITY_TARGET", columnDefinition = "VARCHAR2|下次随访食盐状况||", length = 1, nullable = true)
	private String nextSalinityTarget;
	
	@Column(name = "FIRST_MEDICATE_UNIT", columnDefinition = "VARCHAR2|第一种用药单位||", length = 2, nullable = true)
	private String firstMedicateUnit;
	
	@Column(name = "SECOND_MEDICATE_UNIT", columnDefinition = "VARCHAR2|第二种用药单位||", length = 2, nullable = true)
	private String secondMedicateUnit;
	
	@Column(name = "THIRD_MEDICATE_UNIT", columnDefinition = "VARCHAR2|第三种用药单位||", length = 2, nullable = true)
	private String thirdMedicateUnit;
	
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";

	@Column(name = "COMMENTS", columnDefinition = "VARCHAR2|备注||", length = 1000, nullable = true)
	private String comments;

	@Transient
	private String createDateDesc;
	
	@Transient
	private String trainFrequencyDesc;
	
	@Transient
	private String mentalityDesc;
	
	@Transient
	private String compianceDesc;
	
	@Transient
	private String nextVisitDateDesc;
	
	@Transient
	private String visitDateDesc;
	
	@Transient
	private String visitTypeDesc;
	
	@Transient
	private String drugUseCodeDesc;
	
	@Transient
	private String chineseMedicineTypeDesc;
	
	@Transient
	private String nextExerciseFrequencyDesc;
	
	@Transient
	private String medicationComplianceDesc;
	
	@Transient
	private String saltClassificationDesc;
	
	@Transient
	private String planType;
	
	
	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getFirstMedicateUnit() {
		return firstMedicateUnit;
	}

	public void setFirstMedicateUnit(String firstMedicateUnit) {
		this.firstMedicateUnit = firstMedicateUnit;
	}

	public String getSecondMedicateUnit() {
		return secondMedicateUnit;
	}

	public void setSecondMedicateUnit(String secondMedicateUnit) {
		this.secondMedicateUnit = secondMedicateUnit;
	}

	public String getThirdMedicateUnit() {
		return thirdMedicateUnit;
	}

	public void setThirdMedicateUnit(String thirdMedicateUnit) {
		this.thirdMedicateUnit = thirdMedicateUnit;
	}
	@Transient
	private String name;
	@Transient
	private Date birthday;
	@Transient
	private String nation;
	@Transient
	private String gender;
	
    @Transient
    private String hbpKind;
    
    @Transient
    private String hbpKindDesc;
	
	public String getNextSalinityTarget() {
		return nextSalinityTarget;
	}

	public void setNextSalinityTarget(String nextSalinityTarget) {
		this.nextSalinityTarget = nextSalinityTarget;
	}

	public Integer getNextExerciseFrequency() {
		return nextExerciseFrequency;
	}

	public void setNextExerciseFrequency(Integer nextExerciseFrequency) {
		this.nextExerciseFrequency = nextExerciseFrequency;
	}

	public Integer getNextExerciseTime() {
		return nextExerciseTime;
	}

	public void setNextExerciseTime(Integer nextExerciseTime) {
		this.nextExerciseTime = nextExerciseTime;
	}

	public String getMedicateHbpFlag() {
		return medicateHbpFlag;
	}

	public void setMedicateHbpFlag(String medicateHbpFlag) {
		this.medicateHbpFlag = medicateHbpFlag;
	}

	public String getReferralHbpFlag() {
		return referralHbpFlag;
	}

	public void setReferralHbpFlag(String referralHbpFlag) {
		this.referralHbpFlag = referralHbpFlag;
	}

	public String getReferralOrganCode() {
		return referralOrganCode;
	}
	
	public Integer getNextFollowupDailyDrink() {
		return nextFollowupDailyDrink;
	}

	public void setNextFollowupDailyDrink(Integer nextFollowupDailyDrink) {
		this.nextFollowupDailyDrink = nextFollowupDailyDrink;
	}
	public Integer getSmokeberTarget() {
		return smokeberTarget;
	}

	public void setSmokeberTarget(Integer smokeberTarget) {
		this.smokeberTarget = smokeberTarget;
	}

	public BigDecimal getNextFollowupBmi() {
		return nextFollowupBmi;
	}

	public void setNextFollowupBmi(BigDecimal nextFollowupBmi) {
		this.nextFollowupBmi = nextFollowupBmi;
	}

	public BigDecimal getNextFollowupBodyWeight() {
		return nextFollowupBodyWeight;
	}

	public void setNextFollowupBodyWeight(BigDecimal nextFollowupBodyWeight) {
		this.nextFollowupBodyWeight = nextFollowupBodyWeight;
	}

	public void setReferralOrganCode(String referralOrganCode) {
		this.referralOrganCode = referralOrganCode;
	}

	public String getReferralReasons() {
		return referralReasons;
	}

	public void setReferralReasons(String referralReasons) {
		this.referralReasons = referralReasons;
	}

	public String getReferralDepartment() {
		return referralDepartment;
	}

	public void setReferralDepartment(String referralDepartment) {
		this.referralDepartment = referralDepartment;
	}
	
	@Transient
	private Long planId;// 计划id

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEhrId() {
		return this.ehrId;
	}

	public void setEhrId(String ehrId) {
		this.ehrId = ehrId;
	}

	public Long getPersonId() {
		return this.personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getVisitWayCode() {
		return this.visitWayCode;
	}

	public void setVisitWayCode(String visitWayCode) {
		this.visitWayCode = visitWayCode;
	}

	public String getCurSymptom() {
		return this.curSymptom;
	}

	public void setCurSymptom(String curSymptom) {
		this.curSymptom = curSymptom;
	}

	public String getOtherSymptom() {
		return this.otherSymptom;
	}

	public void setOtherSymptom(String otherSymptom) {
		this.otherSymptom = otherSymptom;
	}

	public String getOtherBodyCharacteristics() {
		return this.otherBodyCharacteristics;
	}

	public void setOtherBodyCharacteristics(String otherBodyCharacteristics) {
		this.otherBodyCharacteristics = otherBodyCharacteristics;
	}

	public BigDecimal getIndexOfBodyCharacteristics() {
		return this.indexOfBodyCharacteristics;
	}

	public void setIndexOfBodyCharacteristics(BigDecimal indexOfBodyCharacteristics) {
		this.indexOfBodyCharacteristics = indexOfBodyCharacteristics;
	}

	public String getTurnSicknessReason() {
		return this.turnSicknessReason;
	}

	public void setTurnSicknessReason(String turnSicknessReason) {
		this.turnSicknessReason = turnSicknessReason;
	}

	public BigDecimal getHeight() {
		return this.height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public BigDecimal getBodyWeight() {
		return this.bodyWeight;
	}

	public void setBodyWeight(BigDecimal bodyWeight) {
		this.bodyWeight = bodyWeight;
	}

	public BigDecimal getHip() {
		return this.hip;
	}

	public void setHip(BigDecimal hip) {
		this.hip = hip;
	}

	public BigDecimal getWaostline() {
		return this.waostline;
	}

	public void setWaostline(BigDecimal waostline) {
		this.waostline = waostline;
	}

	public Integer getSbp() {
		return this.sbp;
	}

	public void setSbp(Integer sbp) {
		this.sbp = sbp;
	}

	public Integer getDbp() {
		return this.dbp;
	}

	public void setDbp(Integer dbp) {
		this.dbp = dbp;
	}

	public Integer getHeartRate() {
		return this.heartRate;
	}

	public void setHeartRate(Integer heartRate) {
		this.heartRate = heartRate;
	}

	public Integer getDailyDailySmokeber() {
		return this.dailyDailySmokeber;
	}

	public void setDailyDailySmokeber(Integer dailyDailySmokeber) {
		this.dailyDailySmokeber = dailyDailySmokeber;
	}

	public Integer getDailyDrink() {
		return this.dailyDrink;
	}

	public void setDailyDrink(Integer dailyDrink) {
		this.dailyDrink = dailyDrink;
	}

	public Integer getTrainingMin() {
		return this.trainingMin;
	}

	public void setTrainingMin(Integer trainingMin) {
		this.trainingMin = trainingMin;
	}

	public String getSaltClassification() {
		return this.saltClassification;
	}

	public void setSaltClassification(String saltClassification) {
		this.saltClassification = saltClassification;
	}

	public String getMentality() {
		return this.mentality;
	}

	public void setMentality(String mentality) {
		this.mentality = mentality;
	}

	public String getCompiance() {
		return this.compiance;
	}

	public void setCompiance(String compiance) {
		this.compiance = compiance;
	}

	public String getAeResultDesc() {
		return this.aeResultDesc;
	}

	public void setAeResultDesc(String aeResultDesc) {
		this.aeResultDesc = aeResultDesc;
	}

	public String getMedicationCompliance() {
		return this.medicationCompliance;
	}

	public void setMedicationCompliance(String medicationCompliance) {
		this.medicationCompliance = medicationCompliance;
	}

	public String getSideEffects() {
		return this.sideEffects;
	}

	public void setSideEffects(String sideEffects) {
		this.sideEffects = sideEffects;
	}

	public String getEffectsState() {
		return this.effectsState;
	}

	public void setEffectsState(String effectsState) {
		this.effectsState = effectsState;
	}

	public String getVisitType() {
		return this.visitType;
	}

	public void setVisitType(String visitType) {
		this.visitType = visitType;
	}

	public String getChineseMedicineType() {
		return this.chineseMedicineType;
	}

	public void setChineseMedicineType(String chineseMedicineType) {
		this.chineseMedicineType = chineseMedicineType;
	}

	public Date getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Date getNextVisitDate() {
		return this.nextVisitDate;
	}

	public void setNextVisitDate(Date nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}

	public String getVisitOrganCode() {
		return this.visitOrganCode;
	}

	public void setVisitOrganCode(String visitOrganCode) {
		this.visitOrganCode = visitOrganCode;
	}

	public String getVisitOrganName() {
		return this.visitOrganName;
	}

	public void setVisitOrganName(String visitOrganName) {
		this.visitOrganName = visitOrganName;
	}

	public String getVisitIdcard() {
		return this.visitIdcard;
	}

	public void setVisitIdcard(String visitIdcard) {
		this.visitIdcard = visitIdcard;
	}

	public String getVisitName() {
		return this.visitName;
	}

	public void setVisitName(String visitName) {
		this.visitName = visitName;
	}

	public String getCreateOrganName() {
		return this.createOrganName;
	}

	public void setCreateOrganName(String createOrganName) {
		this.createOrganName = createOrganName;
	}

	public String getCreateOrganCode() {
		return this.createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	public String getCreateDoctorName() {
		return this.createDoctorName;
	}

	public void setCreateDoctorName(String createDoctorName) {
		this.createDoctorName = createDoctorName;
	}

	public String getCreateDoctorCode() {
		return this.createDoctorCode;
	}

	public void setCreateDoctorCode(String createDoctorCode) {
		this.createDoctorCode = createDoctorCode;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateOrganCode() {
		return this.updateOrganCode;
	}

	public void setUpdateOrganCode(String updateOrganCode) {
		this.updateOrganCode = updateOrganCode;
	}

	public String getUpdateOrganName() {
		return this.updateOrganName;
	}

	public void setUpdateOrganName(String updateOrganName) {
		this.updateOrganName = updateOrganName;
	}

	public String getUpdateDoctorCode() {
		return this.updateDoctorCode;
	}

	public void setUpdateDoctorCode(String updateDoctorCode) {
		this.updateDoctorCode = updateDoctorCode;
	}

	public String getUpdateDoctorName() {
		return this.updateDoctorName;
	}

	public void setUpdateDoctorName(String updateDoctorName) {
		this.updateDoctorName = updateDoctorName;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public Integer getTrainFrequency() {
		return trainFrequency;
	}

	public void setTrainFrequency(Integer trainFrequency) {
		this.trainFrequency = trainFrequency;
	}

	public String getSignOther() {
		return signOther;
	}

	public void setSignOther(String signOther) {
		this.signOther = signOther;
	}

	public String getDrugNameFirst() {
		return drugNameFirst;
	}

	public void setDrugNameFirst(String drugNameFirst) {
		this.drugNameFirst = drugNameFirst;
	}

	public String getDrugCodeFirst() {
		return drugCodeFirst;
	}

	public void setDrugCodeFirst(String drugCodeFirst) {
		this.drugCodeFirst = drugCodeFirst;
	}

	public Integer getDrugPerdayFirst() {
		return drugPerdayFirst;
	}

	public void setDrugPerdayFirst(Integer drugPerdayFirst) {
		this.drugPerdayFirst = drugPerdayFirst;
	}

	public String getDrugCodeSecond() {
		return drugCodeSecond;
	}

	public void setDrugCodeSecond(String drugCodeSecond) {
		this.drugCodeSecond = drugCodeSecond;
	}

	public String getDrugNameSecond() {
		return drugNameSecond;
	}

	public void setDrugNameSecond(String drugNameSecond) {
		this.drugNameSecond = drugNameSecond;
	}

	public Integer getDrugPerdaySecond() {
		return drugPerdaySecond;
	}

	public void setDrugPerdaySecond(Integer drugPerdaySecond) {
		this.drugPerdaySecond = drugPerdaySecond;
	}

	public String getDrugCodeThird() {
		return drugCodeThird;
	}

	public void setDrugCodeThird(String drugCodeThird) {
		this.drugCodeThird = drugCodeThird;
	}

	public String getDrugNameThird() {
		return drugNameThird;
	}

	public void setDrugNameThird(String drugNameThird) {
		this.drugNameThird = drugNameThird;
	}

	public Integer getDrugPerdayThird() {
		return drugPerdayThird;
	}

	public void setDrugPerdayThird(Integer drugPerdayThird) {
		this.drugPerdayThird = drugPerdayThird;
	}

	public BigDecimal getDrugPertimeFirst() {
		return drugPertimeFirst;
	}

	public void setDrugPertimeFirst(BigDecimal drugPertimeFirst) {
		this.drugPertimeFirst = drugPertimeFirst;
	}

	public BigDecimal getDrugPertimeSecond() {
		return drugPertimeSecond;
	}

	public void setDrugPertimeSecond(BigDecimal drugPertimeSecond) {
		this.drugPertimeSecond = drugPertimeSecond;
	}

	public BigDecimal getDrugPertimeThird() {
		return drugPertimeThird;
	}

	public void setDrugPertimeThird(BigDecimal drugPertimeThird) {
		this.drugPertimeThird = drugPertimeThird;
	}

	public BigDecimal getSalinity() {
		return salinity;
	}

	public void setSalinity(BigDecimal salinity) {
		this.salinity = salinity;
	}

	public BigDecimal getMeatMount() {
		return meatMount;
	}

	public void setMeatMount(BigDecimal meatMount) {
		this.meatMount = meatMount;
	}

	public BigDecimal getTc() {
		return tc;
	}

	public void setTc(BigDecimal tc) {
		this.tc = tc;
	}

	public BigDecimal getTriglycerideValue() {
		return triglycerideValue;
	}

	public void setTriglycerideValue(BigDecimal triglycerideValue) {
		this.triglycerideValue = triglycerideValue;
	}


	public BigDecimal getHdlcDetectValue() {
		return hdlcDetectValue;
	}

	public void setHdlcDetectValue(BigDecimal hdlcDetectValue) {
		this.hdlcDetectValue = hdlcDetectValue;
	}


	public BigDecimal getLdlcDetectValue() {
		return ldlcDetectValue;
	}

	public void setLdlcDetectValue(BigDecimal ldlcDetectValue) {
		this.ldlcDetectValue = ldlcDetectValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCurSymptomFlag() {
		return curSymptomFlag;
	}

	public void setCurSymptomFlag(String curSymptomFlag) {
		this.curSymptomFlag = curSymptomFlag;
	}

	
	public String getCreateDateDesc() {
		return createDateDesc;
	}

	
	public void setCreateDateDesc(String createDateDesc) {
		this.createDateDesc = createDateDesc;
	}

	
	public String getHbpKind() {
		return hbpKind;
	}

	
	public void setHbpKind(String hbpKind) {
		this.hbpKind = hbpKind;
	}

	
	public String getHbpKindDesc() {
		return hbpKindDesc;
	}

	
	public void setHbpKindDesc(String hbpKindDesc) {
		this.hbpKindDesc = hbpKindDesc;
	}

	
	public String getTrainFrequencyDesc() {
		return trainFrequencyDesc;
	}

	
	public void setTrainFrequencyDesc(String trainFrequencyDesc) {
		this.trainFrequencyDesc = trainFrequencyDesc;
	}

	
	public String getMentalityDesc() {
		return mentalityDesc;
	}

	
	public void setMentalityDesc(String mentalityDesc) {
		this.mentalityDesc = mentalityDesc;
	}

	
	public String getCompianceDesc() {
		return compianceDesc;
	}

	
	public void setCompianceDesc(String compianceDesc) {
		this.compianceDesc = compianceDesc;
	}

	
	public String getNextVisitDateDesc() {
		return nextVisitDateDesc;
	}

	
	public void setNextVisitDateDesc(String nextVisitDateDesc) {
		this.nextVisitDateDesc = nextVisitDateDesc;
	}

	
	public String getVisitDateDesc() {
		return visitDateDesc;
	}

	
	public void setVisitDateDesc(String visitDateDesc) {
		this.visitDateDesc = visitDateDesc;
	}

	
	public String getVisitTypeDesc() {
		return visitTypeDesc;
	}

	
	public void setVisitTypeDesc(String visitTypeDesc) {
		this.visitTypeDesc = visitTypeDesc;
	}

	
	public String getProcessStatus() {
		return processStatus;
	}

	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	public String getDrugUseCodeDesc() {
		return drugUseCodeDesc;
	}

	public void setDrugUseCodeDesc(String drugUseCodeDesc) {
		this.drugUseCodeDesc = drugUseCodeDesc;
	}

	public String getChineseMedicineTypeDesc() {
		return chineseMedicineTypeDesc;
	}

	public void setChineseMedicineTypeDesc(String chineseMedicineTypeDesc) {
		this.chineseMedicineTypeDesc = chineseMedicineTypeDesc;
	}

	public String getNextExerciseFrequencyDesc() {
		return nextExerciseFrequencyDesc;
	}

	public void setNextExerciseFrequencyDesc(String nextExerciseFrequencyDesc) {
		this.nextExerciseFrequencyDesc = nextExerciseFrequencyDesc;
	}

	public String getMedicationComplianceDesc() {
		return medicationComplianceDesc;
	}

	public void setMedicationComplianceDesc(String medicationComplianceDesc) {
		this.medicationComplianceDesc = medicationComplianceDesc;
	}

	public String getSaltClassificationDesc() {
		return saltClassificationDesc;
	}

	public void setSaltClassificationDesc(String saltClassificationDesc) {
		this.saltClassificationDesc = saltClassificationDesc;
	}

	public String getReferralDoctor() {
		return referralDoctor;
	}

	public void setReferralDoctor(String referralDoctor) {
		this.referralDoctor = referralDoctor;
	}

	public Date getReferralDate() {
		return referralDate;
	}

	public void setReferralDate(Date referralDate) {
		this.referralDate = referralDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}