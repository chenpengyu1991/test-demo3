package com.founder.rhip.ehr.entity.management;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "DM_DIABETIC_FOLLOWUP")
public class DmDiabeticFollowup implements Serializable {

	private static final long serialVersionUID = -191777589646204634L;

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

	@Column(name = "CUR_SYMPTOM", columnDefinition = "VARCHAR2|症状代码组合||", length = 200, nullable = true)
	private String curSymptom;
	
	@Column(name = "CUR_SYMPTOM_FLAG", columnDefinition = "VARCHAR2|症状标志||", length = 1, nullable = true)
	private String curSymptomFlag;

	@Column(name = "OTHER_SYMPTOM", columnDefinition = "VARCHAR2|其他症状描述||", length =300, nullable = true)
	private String otherSymptom;

	@Column(name = "HEIGHT", columnDefinition = "DECIMAL|身高(cm)||",length = 5, scale = 1, nullable = true)
	private String height;

	@Column(name = "BODY_WEIGHT", columnDefinition = "DECIMAL|体重(kg)||",length = 5, scale = 1, nullable = true)
	private String bodyWeight;

	@Column(name = "INDEX_OF_BODY_CHARACTERISTICS", columnDefinition = "DECIMAL|体质指数||", length = 5, scale = 2, nullable = true)
	private BigDecimal indexOfBodyCharacteristics;

	@Column(name = "SBP", columnDefinition = "NUMBER|收缩压(mmHg)||", length = 4, nullable = true)
	private BigDecimal sbp;

	@Column(name = "DBP", columnDefinition = "NUMBER|舒张压(mmHg)||", length = 4, nullable = true)
	private String dbp;

	@Column(name = "ARTERIOPALMUS", columnDefinition = "VARCHAR2|足背动脉搏动标志||", length = 1, nullable = true)
	private BigDecimal arteriopalmus;

	@Column(name = "DAILY_SMOKE", columnDefinition = "NUMBER|日吸烟量(支)||", length = 4, nullable = true)
	private BigDecimal dailySmoke;

	@Column(name = "DAILY_DRINK", columnDefinition = "NUMBER|日饮酒量(两)||", length = 4, nullable = true)
	private BigDecimal dailyDrink;

	@Column(name = "TRAIN_FREQUENCY_TYPE", columnDefinition = "NUMBER|运动频率代码||", length = 2, nullable = true)
	private BigDecimal trainFrequencyType;

	@Column(name = "TRAINING_MIN", columnDefinition = "NUMBER|每次运动时长(min)||",length = 4, nullable = true)
	private Integer trainingMin;

	@Column(name = "DAILY_RICE", columnDefinition = "NUMBER|日主食量(g)||",length = 4, nullable = true)
	private Integer dailyRice;

	@Column(name = "MENTALITY", columnDefinition = "VARCHAR2|心理调整评价代码||",length = 1, nullable = true)
	private Integer mentality;

	@Column(name = "COMPIANCE", columnDefinition = "VARCHAR2|遵医行为评价代码||",length = 1, nullable = true)
	private Integer compiance;

	@Column(name = "FPG", columnDefinition = "DECIMAL|空腹血糖值(mmol/L)||", length = 4,scale = 1 ,nullable = true)
	private BigDecimal fpg;

	@Column(name = "GLU_VALUE", columnDefinition = "DECIMAL|随机血糖值(mmol/L)||", length = 4, scale = 1, nullable = true)
	private BigDecimal gluValue;

	@Column(name = "GLU_TWO_HOUR_VALUE", columnDefinition = "DECIMAL|餐后2小时血糖值(mmol/L)||", length = 4, scale = 1, nullable = true)
	private String gluTwoHourValue;

	@Column(name = "LOW_EFFECTS", columnDefinition = "SMALLINT|低血糖反应代码||", nullable = true)
	private Integer lowEffects;

	@Column(name = "HGB", columnDefinition = "NUMBER|fpg(%)||", length = 4, scale = 2, nullable = true)
	private BigDecimal hgb;

	@Column(name = "SUB_CHECK", columnDefinition = "VARCHAR2|其他辅助检查描述||", length = 1, nullable = true)
	private String subCheck;

	@Column(name = "MEDICATION_COMPLIANCE", columnDefinition = "VARCHAR2|服药依从性代码||", length = 1, nullable = true)
	private String medicationCompliance;

	@Column(name = "SIDE_EFFECTS", columnDefinition = "VARCHAR2|不良反应标志||", length = 1, nullable = true)
	private String sideEffects;

	@Column(name = "DRUG_REACTION", columnDefinition = "VARCHAR2|药物不良反应标志||", length = 2, nullable = true)
	private String drugReaction;

	@Column(name = "HYPOGLYCEMIA_REACTION", columnDefinition = "VARCHAR2|低血糖反应标志||", length = 2, nullable = true)
	private String hypoglycemiaReaction;

	@Column(name = "DI_COMPLICATION", columnDefinition = "VARCHAR2|糖尿病并发症||", length = 50, nullable = true)
	private String diComplication;

	@Column(name = "EFFECTS_STATE", columnDefinition = "VARCHAR2|药物不良反应描述||", length = 100, nullable = true)
	private String effectsState;

	@Column(name = "VISIT_TYPE", columnDefinition = "VARCHAR2|随访评价结果代码||", length = 1, nullable = true)
	private String visitType;

	@Column(name = "INSULIN_TYPE", columnDefinition = "VARCHAR2|胰岛素用药种类||", length = 100, nullable = true)
	private String insulinType;

	@Column(name = "INSULIN_FREQUENCY", columnDefinition = "VARCHAR2|胰岛素用药使用频率(次/d)||", length = 1, nullable = true)
	private String insulinFrequency;

	@Column(name = "INSULIN_DOSE", columnDefinition = "VARCHAR2|胰岛素用药次剂量(U)||", length = 1, nullable = true)
	private String insulinDose;

	@Column(name = "DRUG_CODE_FIRST", columnDefinition = "VARCHAR2|第一种药物编码||", length = 12, nullable = true)
	private String drugCodeFirst;

	@Column(name = "DRUG_NAME_FIRST", columnDefinition = "VARCHAR2|第一种药物名称||", length = 16, nullable = true)
	private String drugNameFirst;

	@Column(name = "DRUG_PERDAY_FIRST", columnDefinition = "NUMNER|第一种药物使用频率||",length = 2, nullable = true)
	private Integer drugPerdayFirst;

	@Column(name = "DRUG_PERTIME_FIRST", columnDefinition = "DECIMAL|第一种药物每次剂量||",length = 8,scale = 2,nullable = true)
	private BigDecimal drugPertimeFirst;

	@Column(name = "DRUG_CODE_SECOND", columnDefinition = "VARCHAR2|第二种药物编码||", length = 12, nullable = true)
	private String drugCodeSecond;

	@Column(name = "DRUG_NAME_SECOND", columnDefinition = "VARCHAR2|第二种药物名称||", length = 16, nullable = true)
	private String drugNameSecond;

	@Column(name = "DRUG_PERDAY_SECOND", columnDefinition = "NUMNER|第二种药物使用频率||", length = 2,nullable = true)
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

	@Column(name = "HEART_RATE", columnDefinition = "VARCHAR2|足背动脉搏动||", nullable = true)
	private String heartRate;

	@Column(name = "HEART_RATE_PART", columnDefinition = "VARCHAR2|足背动脉搏动部位||", nullable = true)
	private String heartRatePart;

	@Column(name = "SELF_BS_MONITORING", columnDefinition = "VARCHAR2|自我血糖监测||",length = 1, nullable = true)
	private String selfBsMonitoring;
	
	@Column(name = "TC", columnDefinition = "NUMBER|总胆固醇||", precision = 5, scale = 2, nullable = true)
	private BigDecimal tc;
	
	@Column(name = "TRIGLYCERIDE_VALUE", columnDefinition = "NUMBER|甘油三酯||", precision = 3, scale = 1, nullable = true)
	private BigDecimal triglycerideValue;
	
	@Column(name = "LDLC_DETECT_VALUE", columnDefinition = "NUMBER|血清低密度脂蛋白胆固醇||", precision = 5, scale = 2, nullable = true)
	private BigDecimal ldlcDetectValue;
	
	@Column(name = "HDLC_DETECT_VALUE", columnDefinition = "NUMBER|血清高密度脂蛋白胆固醇||", precision = 5, scale = 1, nullable = true)
	private BigDecimal hdlcDetectValue;
	
	@Column(name = "SIGN_OTHER", columnDefinition = "VARCHAR2|体征其它|", length = 300, nullable = true)
	private String signOther;

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
	
	@Column(name = "REFERRAL_DI_FLAG", columnDefinition = "VARCHAR2|转诊标识||", length = 1, nullable = true)
	private String referralDiFlag;
	
	@Column(name = "MEDICATE_DI_FLAG", columnDefinition = "VARCHAR2|用药标识||", length = 1, nullable = true)
	private String medicateDiFlag;
	
	@Column(name = "NEXT_EXERCISE_FREQUENCY", columnDefinition = "NUMNER 下次随访运动次数||",length = 2,nullable = true)
	private Integer nextExerciseFrequency;

	@Column(name = "NEXT_EXERCISE_TIME", columnDefinition = "NUMNER|下次随访运动时间||", length = 4, nullable = true)
	private Integer nextExerciseTime;
	
	@Column(name = "STAPLE", columnDefinition = "NUMBER|下次随访日主食量(g)||",length = 4, nullable = true)
	private Integer staple;
	
	@Column(name = "CHECK_DATE", columnDefinition = "DATE|辅助检查检查日期||", nullable = true)
	private Date checkDate;
	
	@Column(name = "OTHER_CHECK", columnDefinition = "VARCHAR2|其它检查|", length = 300, nullable = true)
	private String otherCheck;
	
	@Column(name = "INSULIN_SORT", columnDefinition = "VARCHAR2|胰岛素种类||", length = 16, nullable = true)
	private String insulinSort;

	@Column(name = "INSULIN_USAGE", columnDefinition = "NUMNER|胰岛素使用频率||", length = 2,nullable = true)
	private Integer insulinUsage;

	@Column(name = "INSULIN_USAGE_REMARK", columnDefinition = "VARCHAR2|胰岛素使用备注||", length = 50,nullable = true)
	private String insulinUsageRemark;
	
	@Column(name = "DOSAGE", columnDefinition = "NUMNER|胰岛素每次剂量||",length = 3, nullable = true)
	private Integer dosage;
	
	@Column(name = "FIRST_MEDICATE_UNIT", columnDefinition = "VARCHAR2|第一种用药单位||", length = 2, nullable = true)
	private String firstMedicateUnit;
	
	@Column(name = "SECOND_MEDICATE_UNIT", columnDefinition = "VARCHAR2|第二种用药单位||", length = 2, nullable = true)
	private String secondMedicateUnit;
	
	@Column(name = "THIRD_MEDICATE_UNIT", columnDefinition = "VARCHAR2|第三种用药单位||", length = 2, nullable = true)
	private String thirdMedicateUnit;
	
	@Column(name = "INSULIN_DOSAGE_UNIT", columnDefinition = "VARCHAR2|胰岛素用药单位||", length = 2, nullable = true)
	private String insulinDosageUnit;
	
	@Column(name = "INSULIN_FLAG", columnDefinition = "VARCHAR2|胰岛素使用标识||", length = 2, nullable = true)
	private String insulinFlag;
	
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";

	@Column(name = "COMMENTS", columnDefinition = "VARCHAR2|备注||", length = 1000, nullable = true)
	private String comments;

	@Column(name = "IS_SYMPTOM_CHRONIC_COUGH", columnDefinition = "VARCHAR2|慢性咳嗽、咳痰≥2周|FS10238|", length = 2, nullable = true)
	private String isSymptomChronicCough;

	@Column(name = "IS_HEMOSPUTUM", columnDefinition = "VARCHAR2|咯血、血痰|FS10238|", length = 2, nullable = true)
	private String isHemosputum;

	@Column(name = "IS_SYMPTOM_CHEST_PAIN", columnDefinition = "VARCHAR2|发热、盗汗、胸痛或不明原因消瘦≥2周|FS10238|", length = 2, nullable = true)
	private String isSymptomChestPain;

	@Transient
	private String trainFrequencyTypeDesc;
	
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
	private boolean arteriopalmusB;
	
	@Transient
	private boolean sideEffectsB;
	
	@Transient
	private boolean referralDiFlagB;
	
	@Transient
	private String planType;
	
	//下次运动频率代码
	@Transient
	private String nextExerciseFrequencyDesc;
		
	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getInsulinFlag() {
		return insulinFlag;
	}

	public void setInsulinFlag(String insulinFlag) {
		this.insulinFlag = insulinFlag;
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
	
	public String getInsulinDosageUnit() {
		return insulinDosageUnit;
	}

	public void setInsulinDosageUnit(String insulinDosageUnit) {
		this.insulinDosageUnit = insulinDosageUnit;
	}

	public String getInsulinSort() {
		return insulinSort;
	}

	public void setInsulinSort(String insulinSort) {
		this.insulinSort = insulinSort;
	}

	public Integer getInsulinUsage() {
		return insulinUsage;
	}

	public void setInsulinUsage(Integer insulinUsage) {
		this.insulinUsage = insulinUsage;
	}
	
	public Integer getDosage() {
		return dosage;
	}

	public void setDosage(Integer dosage) {
		this.dosage = dosage;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getOtherCheck() {
		return otherCheck;
	}

	public void setOtherCheck(String otherCheck) {
		this.otherCheck = otherCheck;
	}

	public Integer getStaple() {
		return staple;
	}

	public void setStaple(Integer staple) {
		this.staple = staple;
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

	public String getMedicateDiFlag() {
		return medicateDiFlag;
	}

	public void setMedicateDiFlag(String medicateDiFlag) {
		this.medicateDiFlag = medicateDiFlag;
	}

	public String getReferralDiFlag() {
		return referralDiFlag;
	}

	public void setReferralDiFlag(String referralDiFlag) {
		this.referralDiFlag = referralDiFlag;
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

	public String getReferralOrganCode() {
		return referralOrganCode;
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

	public String getHeight() {
		return this.height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getBodyWeight() {
		return this.bodyWeight;
	}

	public void setBodyWeight(String bodyWeight) {
		this.bodyWeight = bodyWeight;
	}

	public BigDecimal getSbp() {
		return this.sbp;
	}

	public void setSbp(BigDecimal sbp) {
		this.sbp = sbp;
	}

	public String getDbp() {
		return this.dbp;
	}

	public void setDbp(String dbp) {
		this.dbp = dbp;
	}

	public BigDecimal getArteriopalmus() {
		return this.arteriopalmus;
	}

	public void setArteriopalmus(BigDecimal arteriopalmus) {
		this.arteriopalmus = arteriopalmus;
	}

	public BigDecimal getDailySmoke() {
		return this.dailySmoke;
	}

	public void setDailySmoke(BigDecimal dailySmoke) {
		this.dailySmoke = dailySmoke;
	}

	public BigDecimal getDailyDrink() {
		return this.dailyDrink;
	}

	public void setDailyDrink(BigDecimal dailyDrink) {
		this.dailyDrink = dailyDrink;
	}

	public BigDecimal getTrainFrequencyType() {
		return this.trainFrequencyType;
	}

	public void setTrainFrequencyType(BigDecimal trainFrequencyType) {
		this.trainFrequencyType = trainFrequencyType;
	}

	public Integer getTrainingMin() {
		return this.trainingMin;
	}

	public void setTrainingMin(Integer trainingMin) {
		this.trainingMin = trainingMin;
	}

	public Integer getDailyRice() {
		return this.dailyRice;
	}

	public void setDailyRice(Integer dailyRice) {
		this.dailyRice = dailyRice;
	}

	public Integer getMentality() {
		return this.mentality;
	}

	public void setMentality(Integer mentality) {
		this.mentality = mentality;
	}

	public Integer getCompiance() {
		return this.compiance;
	}

	public void setCompiance(Integer compiance) {
		this.compiance = compiance;
	}

	public BigDecimal getFpg() {
		return this.fpg;
	}

	public void setFpg(BigDecimal fpg) {
		this.fpg = fpg;
	}

	public BigDecimal getGluValue() {
		return this.gluValue;
	}

	public void setGluValue(BigDecimal gluValue) {
		this.gluValue = gluValue;
	}

	public Integer getLowEffects() {
		return this.lowEffects;
	}

	public void setLowEffects(Integer lowEffects) {
		this.lowEffects = lowEffects;
	}

	public BigDecimal getHgb() {
		return this.hgb;
	}

	public void setHgb(BigDecimal hgb) {
		this.hgb = hgb;
	}

	public String getSubCheck() {
		return this.subCheck;
	}

	public void setSubCheck(String subCheck) {
		this.subCheck = subCheck;
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

	public String getInsulinType() {
		return this.insulinType;
	}

	public void setInsulinType(String insulinType) {
		this.insulinType = insulinType;
	}

	public String getInsulinFrequency() {
		return this.insulinFrequency;
	}

	public void setInsulinFrequency(String insulinFrequency) {
		this.insulinFrequency = insulinFrequency;
	}

	public String getInsulinDose() {
		return this.insulinDose;
	}

	public void setInsulinDose(String insulinDose) {
		this.insulinDose = insulinDose;
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

	public BigDecimal getIndexOfBodyCharacteristics() {
		return indexOfBodyCharacteristics;
	}

	public void setIndexOfBodyCharacteristics(BigDecimal indexOfBodyCharacteristics) {
		this.indexOfBodyCharacteristics = indexOfBodyCharacteristics;
	}

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public String getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(String heartRate) {
		this.heartRate = heartRate;
	}

	public String getSelfBsMonitoring() {
		return selfBsMonitoring;
	}

	public void setSelfBsMonitoring(String selfBsMonitoring) {
		this.selfBsMonitoring = selfBsMonitoring;
	}

	public String getDrugReaction() {
		return drugReaction;
	}

	public void setDrugReaction(String drugReaction) {
		this.drugReaction = drugReaction;
	}

	public String getHypoglycemiaReaction() {
		return hypoglycemiaReaction;
	}

	public void setHypoglycemiaReaction(String hypoglycemiaReaction) {
		this.hypoglycemiaReaction = hypoglycemiaReaction;
	}

	public String getDiComplication() {
		return diComplication;
	}

	public void setDiComplication(String diComplication) {
		this.diComplication = diComplication;
	}

	public String getGluTwoHourValue() {
		return gluTwoHourValue;
	}

	public void setGluTwoHourValue(String gluTwoHourValue) {
		this.gluTwoHourValue = gluTwoHourValue;
	}

	public String getDrugCodeFirst() {
		return drugCodeFirst;
	}

	public void setDrugCodeFirst(String drugCodeFirst) {
		this.drugCodeFirst = drugCodeFirst;
	}

	public String getDrugNameFirst() {
		return drugNameFirst;
	}

	public void setDrugNameFirst(String drugNameFirst) {
		this.drugNameFirst = drugNameFirst;
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

	public BigDecimal getLdlcDetectValue() {
		return ldlcDetectValue;
	}

	public void setLdlcDetectValue(BigDecimal ldlcDetectValue) {
		this.ldlcDetectValue = ldlcDetectValue;
	}

	public BigDecimal getHdlcDetectValue() {
		return hdlcDetectValue;
	}

	public void setHdlcDetectValue(BigDecimal hdlcDetectValue) {
		this.hdlcDetectValue = hdlcDetectValue;
	}

	public String getSignOther() {
		return signOther;
	}

	public void setSignOther(String signOther) {
		this.signOther = signOther;
	}

	public String getCurSymptomFlag() {
		return curSymptomFlag;
	}

	public void setCurSymptomFlag(String curSymptomFlag) {
		this.curSymptomFlag = curSymptomFlag;
	}

	public String getInsulinUsageRemark() {
		return insulinUsageRemark;
	}

	public void setInsulinUsageRemark(String insulinUsageRemark) {
		this.insulinUsageRemark = insulinUsageRemark;
	}

	
	public String getProcessStatus() {
		return processStatus;
	}

	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	
	public String getTrainFrequencyTypeDesc() {
		return trainFrequencyTypeDesc;
	}

	
	public void setTrainFrequencyTypeDesc(String trainFrequencyTypeDesc) {
		this.trainFrequencyTypeDesc = trainFrequencyTypeDesc;
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

	public boolean isArteriopalmusB() {
		return arteriopalmusB;
	}

	public void setArteriopalmusB(boolean arteriopalmusB) {
		this.arteriopalmusB = arteriopalmusB;
	}

	public boolean isSideEffectsB() {
		return sideEffectsB;
	}

	public void setSideEffectsB(boolean sideEffectsB) {
		this.sideEffectsB = sideEffectsB;
	}

	public boolean isReferralDiFlagB() {
		return referralDiFlagB;
	}

	public void setReferralDiFlagB(boolean referralDiFlagB) {
		this.referralDiFlagB = referralDiFlagB;
	}

	public String getNextExerciseFrequencyDesc() {
		return nextExerciseFrequencyDesc;
	}

	public void setNextExerciseFrequencyDesc(String nextExerciseFrequencyDesc) {
		this.nextExerciseFrequencyDesc = nextExerciseFrequencyDesc;
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

	public String getHeartRatePart() {
		return heartRatePart;
	}

	public void setHeartRatePart(String heartRatePart) {
		this.heartRatePart = heartRatePart;
	}

	public String getIsSymptomChronicCough() {
		return isSymptomChronicCough;
	}

	public void setIsSymptomChronicCough(String isSymptomChronicCough) {
		this.isSymptomChronicCough = isSymptomChronicCough;
	}

	public String getIsHemosputum() {
		return isHemosputum;
	}

	public void setIsHemosputum(String isHemosputum) {
		this.isHemosputum = isHemosputum;
	}

	public String getIsSymptomChestPain() {
		return isSymptomChestPain;
	}

	public void setIsSymptomChestPain(String isSymptomChestPain) {
		this.isSymptomChestPain = isSymptomChestPain;
	}
}