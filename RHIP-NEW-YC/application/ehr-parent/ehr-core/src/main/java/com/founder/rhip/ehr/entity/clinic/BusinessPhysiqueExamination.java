package com.founder.rhip.ehr.entity.clinic;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "MS_BUSINESS_PHY_EXAM")
public class BusinessPhysiqueExamination implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "PHYSICAL_EXAM_CODE", columnDefinition = "VARCHAR2|健康体检表编号||", length = 18, nullable = true)
    private String physicalExamCode;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = false)
    private String ehrId;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|个人信息唯一编号||", length = 11, nullable = true)
    private Long personId;

    @Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号||", length = 17, nullable = true)
    private String healthFileNo;
    
    @Column(name = "PHYSICAL_EXAM_TYPE", columnDefinition = "VARCHAR2|体检类别||", length = 10, nullable = true)
    private String physicalExamType;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
    private String name;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
    private String gender;

    @Column(name = "AGE", columnDefinition = "NUMBER|年龄||", length = 3, nullable = true)
    private Integer age;

    @Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
    private Date birthday;

    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况||", length = 3, nullable = true)
    private String marriage;

    @Column(name = "SYMPTOM_FLAG", columnDefinition = "CHAR|症状标志||", length = 1, nullable = true)
    private String symptomFlag;

    @Column(name = "SYMPTOM_DESC", columnDefinition = "VARCHAR2|症状描述||", length = 100, nullable = true)
    private String symptomDesc;

    @Column(name = "TEMPERATURE", columnDefinition = "NUMBER|体温(℃)||", scale = 4, precision = 1, nullable = true)
    private BigDecimal temperature;

    @Column(name = "PULSE_RATE", columnDefinition = "NUMBER|脉率(次/min)||", length = 4, nullable = true)
    private Integer pulseRate;

    @Column(name = "RESPIRATORY_RATE", columnDefinition = "NUMBER|呼吸频率(次/min)||", length = 4, nullable = true)
    private Integer respiratoryRate;

    @Column(name = "LEFT_SBP", columnDefinition = "NUMBER|左侧收缩压(mmHg)||", length = 4, nullable = true)
    private Integer leftSbp;

    @Column(name = "LEFT_DBP", columnDefinition = "NUMBER|左侧舒张压(mmHg)||", length = 4, nullable = true)
    private Integer leftDbp;

    @Column(name = "RIGHT_SBP", columnDefinition = "NUMBER|右侧收缩压(mmHg)||", length = 4, nullable = true)
    private Integer rightSbp;

    @Column(name = "RIGHT_DBP", columnDefinition = "NUMBER|右侧舒张压(mmHg)||", length = 4, nullable = true)
    private Integer rightDbp;

    @Column(name = "HEIGHT", columnDefinition = "NUMBER|身高(cm)||", scale = 5, precision = 1, nullable = true)
    private BigDecimal height;

    @Column(name = "BODY_WEIGHT", columnDefinition = "NUMBER|体重(kg)||", scale = 5, precision = 1, nullable = true)
    private BigDecimal bodyWeight;

    @Column(name = "WAOSTLINE", columnDefinition = "NUMBER|腰围(cm)||", scale = 5, precision = 1, nullable = true)
    private BigDecimal waostline;

    @Column(name = "HIP", columnDefinition = "NUMBER|臀围(cm)||", scale = 5, precision = 1, nullable = true)
    private BigDecimal hip;

    @Column(name = "WHR", columnDefinition = "NUMBER|腰臀围比值||", scale = 5, precision = 1, nullable = true)
    private BigDecimal whr;

    @Column(name = "INDEX_OF_BODY_CHARACTERISTICS", columnDefinition = "NUMBER|体质指数(BMI)||", scale = 5, precision = 2, nullable = true)
    private BigDecimal indexOfBodyCharacteristics;

    @Column(name = "HEALTH_SELF_ASSESSMENT", columnDefinition = "VARCHAR2|老年人健康状态自我评估||", length = 1, nullable = true)
    private String healthSelfAssessment;

    @Column(name = "LIFE_ABILITY_SELF_ASSESSMENT", columnDefinition = "VARCHAR2|老年人生活自理能力自我评估||", length = 1, nullable = true)
    private String lifeAbilitySelfAssessment;

    @Column(name = "EATING_ASSESSMENT", columnDefinition = "VARCHAR2|老年人进餐能力自我评估||", length = 2, nullable = true)
    private Integer eatingAssessment;

    @Column(name = "CLEANING_ASSESSMENT", columnDefinition = "VARCHAR2|老年人梳洗能力自我评估||", length = 2, nullable = true)
    private Integer cleaningAssessment;

    @Column(name = "CLOTHING_ASSESSMENT", columnDefinition = "VARCHAR2|老年人生活穿衣能力自我评估||", length = 2, nullable = true)
    private Integer clothingAssessment;

    @Column(name = "DEFECATION_ASSESSMENT", columnDefinition = "VARCHAR2|老年人如厕能力自我评估||", length = 2, nullable = true)
    private Integer defecationAssessment;

    @Column(name = "EXERCISE_ASSESSMENT", columnDefinition = "VARCHAR2|老年人活动能力自我评估||", length = 2, nullable = true)
    private Integer exerciseAssessment;

    @Column(name = "COGNITION_SCREEN_RESULT", columnDefinition = "VARCHAR2|老年人认知功能粗筛结果||", length = 1, nullable = true)
    private String cognitionScreenResult;

    @Column(name = "COGNITION_SCREEN_SCORE", columnDefinition = "NUMBER|老年人认知功能评分||", length = 4, nullable = true)
    private Integer cognitionScreenScore;

    @Column(name = "EMOTION_SCREEN_RESULT", columnDefinition = "VARCHAR2|老年人情感状态粗筛结果||", length = 1, nullable = true)
    private String emotionScreenResult;

    @Column(name = "DEPRESSION_SCORE", columnDefinition = "NUMBER|老年人抑郁评分||", length = 3, nullable = true)
    private Integer depressionScore;

    @Column(name = "TRAIN_FREQUENCY_TYPE_CODE", columnDefinition = "VARCHAR2|锻炼频率||", length = 1, nullable = true)
    private String trainFrequencyTypeCode;

    @Column(name = "TRAINING_MIN", columnDefinition = "NUMBER|每次锻炼时间(分钟)||", length = 4, nullable = true)
    private Integer trainingMin;

    @Column(name = "TRAINING_TOTALTIME", columnDefinition = "NUMBER|坚持锻炼时间(月)||", length = 5, nullable = true)
    private Integer trainingTotaltime;

    @Column(name = "TRAINING_WAY", columnDefinition = "VARCHAR2|锻炼方式||", length = 100, nullable = true)
    private String trainingWay;

    @Column(name = "DIET_PRE_DESC", columnDefinition = "VARCHAR2|饮食偏好描述||", length = 100, nullable = true)
    private String dietPreDesc;

    @Column(name = "SMODE_STATUS_CODE", columnDefinition = "VARCHAR2|吸烟状况||", length = 1, nullable = true)
    private String smodeStatusCode;

    @Column(name = "DAILY_SMOKE", columnDefinition = "NUMBER|日吸烟量(支)||", length = 4, nullable = true)
    private Integer dailySmoke;

    @Column(name = "SMOKE_AGE", columnDefinition = "NUMBER|开始吸烟年龄(岁)||", length = 3, nullable = true)
    private Integer smokeAge;

    @Column(name = "QUIT_SMOKE_AGE", columnDefinition = "NUMBER|戒烟年龄(岁)||", length = 3, nullable = true)
    private Integer quitSmokeAge;

    @Column(name = "DRINK_FREQUENCY", columnDefinition = "VARCHAR2|饮酒频率||", length = 1, nullable = true)
    private String drinkFrequency;

    @Column(name = "DAILY_DRINK", columnDefinition = "NUMBER|日饮酒量(两)||", length = 4, nullable = true)
    private Integer dailyDrink;

    @Column(name = "NODRINK", columnDefinition = "CHAR|戒酒标志||", length = 1, nullable = true)
    private String nodrink;

    @Column(name = "NODRINK_AGE", columnDefinition = "NUMBER|戒酒年龄(岁)||", length = 3, nullable = true)
    private Integer nodrinkAge;

    @Column(name = "DRINK_AGE", columnDefinition = "NUMBER|开始饮酒年龄(岁)||", length = 3, nullable = true)
    private Integer drinkAge;

    @Column(name = "DRUNK", columnDefinition = "CHAR|醉酒标志||", length = 1, nullable = true)
    private String drunk;

    @Column(name = "DRINK_TYPE_DESC", columnDefinition = "VARCHAR2|饮酒类型描述||", length = 100, nullable = true)
    private String drinkTypeDesc;

    @Column(name = "OCCUPATION_EXPOSURE_FLAG", columnDefinition = "CHAR|职业危害因素接触史||", length = 1, nullable = true)
    private String occupationExposureFlag;

    @Column(name = "RISK_OCCUPATION_DESC", columnDefinition = "VARCHAR2|有危害因素接触职业描述||", length = 100, nullable = true)
    private String riskOccupationDesc;

    @Column(name = "RISK_OCCUPATION_TIME", columnDefinition = "NUMBER|从事有危害因素职业时长(a)||", length = 3, nullable = true)
    private Integer riskOccupationTime;

    @Column(name = "DUST_TYPE_DESC", columnDefinition = "VARCHAR2|粉尘类别描述||", length = 100, nullable = true)
    private String dustTypeDesc;

    @Column(name = "DUST_PROTECTION_FLAG", columnDefinition = "CHAR|粉尘防护措施标志||", length = 1, nullable = true)
    private String dustProtectionFlag;

    @Column(name = "DUST_PROTECTION_DESC", columnDefinition = "VARCHAR2|粉尘防护措施描述||", length = 100, nullable = true)
    private String dustProtectionDesc;

    @Column(name = "RADIATION_TYPE_DESC", columnDefinition = "VARCHAR2|放射物质类别描述||", length = 100, nullable = true)
    private String radiationTypeDesc;

    @Column(name = "RADIATION_PROTECTION_FLAG", columnDefinition = "CHAR|放射物质防护措施标志||", length = 1, nullable = true)
    private String radiationProtectionFlag;

    @Column(name = "RADIATION_PROTECTION_DESC", columnDefinition = "VARCHAR2|放射物质防护措施描述||", length = 100, nullable = true)
    private String radiationProtectionDesc;

    @Column(name = "PHYSICS_TYPE_DESC", columnDefinition = "VARCHAR2|物理因素类别描述||", length = 100, nullable = true)
    private String physicsTypeDesc;

    @Column(name = "PHYSICS_PROTECTION_FLAG", columnDefinition = "CHAR|物理因素防护措施标志||", length = 1, nullable = true)
    private String physicsProtectionFlag;

    @Column(name = "PHYSICS_PROTECTION_DESC", columnDefinition = "VARCHAR2|物理因素防护措施描述||", length = 100, nullable = true)
    private String physicsProtectionDesc;

    @Column(name = "CHEMISTRY_TYPE_DESC", columnDefinition = "VARCHAR2|化学物质类别描述||", length = 100, nullable = true)
    private String chemistryTypeDesc;

    @Column(name = "CHEMISTRY_PROTECTION_FLAG", columnDefinition = "CHAR|化学物质防护措施标志||", length = 1, nullable = true)
    private String chemistryProtectionFlag;

    @Column(name = "CHEMISTRY_PROTECTION_DESC", columnDefinition = "VARCHAR2|化学物质防护措施描述||", length = 100, nullable = true)
    private String chemistryProtectionDesc;

    @Column(name = "OTHER_TYPE_DESC", columnDefinition = "VARCHAR2|其它类别描述||", length = 100, nullable = true)
    private String otherTypeDesc;

    @Column(name = "OTHER_PROTECTION_FLAG", columnDefinition = "CHAR|其它防护措施标志||", length = 1, nullable = true)
    private String otherProtectionFlag;

    @Column(name = "OTHER_PROTECTION_DESC", columnDefinition = "VARCHAR2|其它防护措施描述||", length = 100, nullable = true)
    private String otherProtectionDesc;

    @Column(name = "LIP_APPEARANCE_CEHCK_RESULT", columnDefinition = "VARCHAR2|口唇外观检查结果||", length = 1, nullable = true)
    private String lipAppearanceCehckResult;

    @Column(name = "DENTITION_TYPE", columnDefinition = "VARCHAR2|齿列类别||", length = 1, nullable = true)
    private String dentitionType;

    @Column(name = "DENTITION_DESC", columnDefinition = "VARCHAR2|齿列描述||", length = 100, nullable = true)
    private String dentitionDesc;

    @Column(name = "DENTITION_ANOMALY_FLAG", columnDefinition = "CHAR|齿列异常标志||", length = 1, nullable = true)
    private String dentitionAnomalyFlag;

    @Column(name = "MISSING_TOOTH_FLG", columnDefinition = "NUMBER|缺齿标志||", length = 1, nullable = true)
    private Integer missingToothFlg;

    @Column(name = "MISSING_TOOTH_NUMBER_UPL", columnDefinition = "NUMBER|缺齿数(颗)上左||", length = 3, nullable = true)
    private Integer missingToothNumberUpl;

    @Column(name = "MISSING_TOOTH_NUMBER_UPR", columnDefinition = "NUMBER|缺齿数(颗)上右||", length = 3, nullable = true)
    private Integer missingToothNumberUpr;

    @Column(name = "MISSING_TOOTH_NUMBER_DOWNL", columnDefinition = "NUMBER|缺齿数(颗)下左||", length = 3, nullable = true)
    private Integer missingToothNumberDownl;

    @Column(name = "MISSING_TOOTH_NUMBER_DOWNR", columnDefinition = "NUMBER|缺齿数(颗)下右||", length = 3, nullable = true)
    private Integer missingToothNumberDownr;

    @Column(name = "DECAYED_TOOTH_FLG", columnDefinition = "NUMBER|龋齿标志||", length = 1, nullable = true)
    private Integer decayedToothFlg;

    @Column(name = "DECAYED_TOOTH_NUMBER_UPL", columnDefinition = "NUMBER|龋齿数(颗)上左||", length = 3, nullable = true)
    private Integer decayedToothNumberUpl;

    @Column(name = "DECAYED_TOOTH_NUMBER_UPR", columnDefinition = "NUMBER|龋齿数(颗)上右||", length = 3, nullable = true)
    private Integer decayedToothNumberUpr;

    @Column(name = "DECAYED_TOOTH_NUMBER_DOWNL", columnDefinition = "NUMBER|龋齿数(颗)下左||", length = 3, nullable = true)
    private Integer decayedToothNumberDownl;

    @Column(name = "DECAYED_TOOTH_NUMBER_DOWNR", columnDefinition = "NUMBER|龋齿数(颗)下右||", length = 3, nullable = true)
    private Integer decayedToothNumberDownr;

    @Column(name = "DENTURE_TOOTH_FLG", columnDefinition = "NUMBER|义齿标志||", length = 1, nullable = true)
    private Integer dentureToothFlg;

    @Column(name = "DENTURE_TOOTH_NUMBER_UPL", columnDefinition = "NUMBER|义齿数(颗)上左||", length = 3, nullable = true)
    private Integer dentureToothNumberUpl;

    @Column(name = "DENTURE_TOOTH_NUMBER_UPR", columnDefinition = "NUMBER|义齿数(颗)上右||", length = 3, nullable = true)
    private Integer dentureToothNumberUpr;

    @Column(name = "DENTURE_TOOTH_NUMBER_DOWNL", columnDefinition = "NUMBER|义齿数(颗)下左||", length = 3, nullable = true)
    private Integer dentureToothNumberDownl;

    @Column(name = "DENTURE_TOOTH_NUMBER_DOWNR", columnDefinition = "NUMBER|义齿数(颗)下右||", length = 3, nullable = true)
    private Integer dentureToothNumberDownr;

    @Column(name = "PERIODONTAL_CEHCK_RESULT", columnDefinition = "VARCHAR2|牙周检查结果||", length = 1, nullable = true)
    private String periodontalCehckResult;

    @Column(name = "PHARYNX_CHECK_RESULT", columnDefinition = "VARCHAR2|咽部检查结果||", length = 1, nullable = true)
    private String pharynxCheckResult;

    @Column(name = "THROAT_TONSIL_CHECK_RESULT", columnDefinition = "VARCHAR2|喉部扁桃体检查结果||", length = 1, nullable = true)
    private String throatTonsilCheckResult;

    @Column(name = "THROAT_CHECK_RESULT", columnDefinition = "VARCHAR2|喉头检查结果||", length = 1, nullable = true)
    private String throatCheckResult;

    @Column(name = "THROAT_ANOMALY_DESC", columnDefinition = "VARCHAR2|喉部检查异常描述||", length = 1, nullable = true)
    private String throatAnomalyDesc;

    @Column(name = "L_NAKED_EYE", columnDefinition = "NUMBER|左眼裸眼远视力值||", scale = 3, precision = 1, nullable = true)
    private Float lNakedEye = 0.0f;

    @Column(name = "R_NAKED_EYE", columnDefinition = "NUMBER|右眼裸眼远枧力值||", scale = 3, precision = 1, nullable = true)
    private Float rNakedEye = 0.0f;

    @Column(name = "L_EYECORRECTION", columnDefinition = "NUMBER|左眼矫正远视力值||", scale = 3, precision = 1, nullable = true)
    private Float lEyecorrection = 0.0f;

    @Column(name = "R_EYECORRECTION", columnDefinition = "NUMBER|右眼矫正远视力值||", scale = 3, precision = 1, nullable = true)
    private Float rEyecorrection = 0.0f;

    @Column(name = "HEAR_DETECT_RESULT", columnDefinition = "VARCHAR2|听力检测结果||", length = 1, nullable = true)
    private String hearDetectResult;

    @Column(name = "MOTOR_FUNC_STATE", columnDefinition = "VARCHAR2|运动功能状态||", length = 1, nullable = true)
    private String motorFuncState;

    @Column(name = "COLOR_VISION", columnDefinition = "VARCHAR2|辨色力||", length = 1, nullable = true)
    private String colorVision;

    @Column(name = "EARDRUM_CHECK_RESULT", columnDefinition = "VARCHAR2|鼓膜检查结果||", length = 1, nullable = true)
    private String eardrumCheckResult;

    @Column(name = "EAR_ANOMALYF_DESC", columnDefinition = "VARCHAR2|耳检查异常描述||", length = 100, nullable = true)
    private String earAnomalyfDesc;

    @Column(name = "NASAL_SEPTUM_CHECK_RESULT", columnDefinition = "VARCHAR2|鼻中隔检查结果||", length = 1, nullable = true)
    private String nasalSeptumCheckResult;

    @Column(name = "NASAL_MUCOSA_CHECK_RESULT", columnDefinition = "VARCHAR2|鼻粘膜检查结果||", length = 1, nullable = true)
    private String nasalMucosaCheckResult;

    @Column(name = "NASAL_ANOMALYF_DESC", columnDefinition = "VARCHAR2|鼻部检查异常描述||", length = 100, nullable = true)
    private String nasalAnomalyfDesc;
  
    @Column(name = "PHYSIOLOGY_ANOMALY_FLAG", columnDefinition = "VARCHAR2|生理反射异常标志||", length = 1, nullable = true)
    private String physiologyAnomalyFlag;

    @Column(name = "PHYSIOLOGY_ANOMALYF_DESC", columnDefinition = "VARCHAR2|生理反射异常描述||", length = 100, nullable = true)
    private String physiologyAnomalyfDesc;

    @Column(name = "EXAMINATION_RESULT", columnDefinition = "VARCHAR2|体检结果||", length = 400, nullable = true)
    private String examinationResult;

    @Column(name = "EXAMINATION_ORGAN_CODE", columnDefinition = "VARCHAR2|体检机构编码||", length = 15, nullable = true)
    private String examinationOrganCode;

    @Column(name = "EXAMINATION_ORGAN_NAME", columnDefinition = "VARCHAR2|体检机构名称||", length = 70, nullable = true)
    private String examinationOrganName;

    @Column(name = "MANA_DOCTOR_ID", columnDefinition = "VARCHAR2|责任医师ID||", length = 50, nullable = true)
    private String manaDoctorId;

    @Column(name = "MANA_DOCTOR_NO", columnDefinition = "VARCHAR2|责任医师工号||", length = 18, nullable = true)
    private String manaDoctorNo;

    @Column(name = "MANA_DOCTOR_NAME", columnDefinition = "VARCHAR2|责任医师姓名||", length = 50, nullable = true)
    private String manaDoctorName;

    @Column(name = "MANA_DOCTOR_IDCARD", columnDefinition = "VARCHAR2|责任医师身份证号||", length = 18, nullable = true)
    private String manaDoctorIdcard;

    @Column(name = "INPUT_IDCARD", columnDefinition = "VARCHAR2|建档人身份证号||", length = 18, nullable = true)
    private String inputIdcard;

    @Column(name = "INPUT_NAME", columnDefinition = "VARCHAR2|建档人姓名||", length = 50, nullable = true)
    private String inputName;

    @Column(name = "INPUTER_ID", columnDefinition = "VARCHAR2|建档人ID||", length = 50, nullable = true)
    private String inputerId;

    @Column(name = "EXAMINATION_DATE", columnDefinition = "DATE|体检日期||", nullable = true)
    private Date examinationDate;
 
    @Column(name = "INPUT_DATE", columnDefinition = "DATE|建档日期和时间||", nullable = true)
    private Date inputDate;
    
    @Column(name = "PHYSICAL_EXAM_COST", columnDefinition = "NUMBER|体检费用||", scale = 8, precision = 2, nullable = true)
    private BigDecimal physicalExamCost;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhysicalExamCode() {
		return physicalExamCode;
	}

	public void setPhysicalExamCode(String physicalExamCode) {
		this.physicalExamCode = physicalExamCode;
	}

	public String getEhrId() {
		return ehrId;
	}

	public void setEhrId(String ehrId) {
		this.ehrId = ehrId;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getHealthFileNo() {
		return healthFileNo;
	}

	public void setHealthFileNo(String healthFileNo) {
		this.healthFileNo = healthFileNo;
	}

	public String getPhysicalExamType() {
		return physicalExamType;
	}

	public void setPhysicalExamType(String physicalExamType) {
		this.physicalExamType = physicalExamType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getSymptomFlag() {
		return symptomFlag;
	}

	public void setSymptomFlag(String symptomFlag) {
		this.symptomFlag = symptomFlag;
	}

	public String getSymptomDesc() {
		return symptomDesc;
	}

	public void setSymptomDesc(String symptomDesc) {
		this.symptomDesc = symptomDesc;
	}

	public BigDecimal getTemperature() {
		return temperature;
	}

	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}

	public Integer getPulseRate() {
		return pulseRate;
	}

	public void setPulseRate(Integer pulseRate) {
		this.pulseRate = pulseRate;
	}

	public Integer getRespiratoryRate() {
		return respiratoryRate;
	}

	public void setRespiratoryRate(Integer respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}

	public Integer getLeftSbp() {
		return leftSbp;
	}

	public void setLeftSbp(Integer leftSbp) {
		this.leftSbp = leftSbp;
	}

	public Integer getLeftDbp() {
		return leftDbp;
	}

	public void setLeftDbp(Integer leftDbp) {
		this.leftDbp = leftDbp;
	}

	public Integer getRightSbp() {
		return rightSbp;
	}

	public void setRightSbp(Integer rightSbp) {
		this.rightSbp = rightSbp;
	}

	public Integer getRightDbp() {
		return rightDbp;
	}

	public void setRightDbp(Integer rightDbp) {
		this.rightDbp = rightDbp;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public BigDecimal getBodyWeight() {
		return bodyWeight;
	}

	public void setBodyWeight(BigDecimal bodyWeight) {
		this.bodyWeight = bodyWeight;
	}

	public BigDecimal getWaostline() {
		return waostline;
	}

	public void setWaostline(BigDecimal waostline) {
		this.waostline = waostline;
	}

	public BigDecimal getHip() {
		return hip;
	}

	public void setHip(BigDecimal hip) {
		this.hip = hip;
	}

	public BigDecimal getWhr() {
		return whr;
	}

	public void setWhr(BigDecimal whr) {
		this.whr = whr;
	}

	public BigDecimal getIndexOfBodyCharacteristics() {
		return indexOfBodyCharacteristics;
	}

	public void setIndexOfBodyCharacteristics(BigDecimal indexOfBodyCharacteristics) {
		this.indexOfBodyCharacteristics = indexOfBodyCharacteristics;
	}

	public String getHealthSelfAssessment() {
		return healthSelfAssessment;
	}

	public void setHealthSelfAssessment(String healthSelfAssessment) {
		this.healthSelfAssessment = healthSelfAssessment;
	}

	public String getLifeAbilitySelfAssessment() {
		return lifeAbilitySelfAssessment;
	}

	public void setLifeAbilitySelfAssessment(String lifeAbilitySelfAssessment) {
		this.lifeAbilitySelfAssessment = lifeAbilitySelfAssessment;
	}

	public Integer getEatingAssessment() {
		return eatingAssessment;
	}

	public void setEatingAssessment(Integer eatingAssessment) {
		this.eatingAssessment = eatingAssessment;
	}

	public Integer getCleaningAssessment() {
		return cleaningAssessment;
	}

	public void setCleaningAssessment(Integer cleaningAssessment) {
		this.cleaningAssessment = cleaningAssessment;
	}

	public Integer getClothingAssessment() {
		return clothingAssessment;
	}

	public void setClothingAssessment(Integer clothingAssessment) {
		this.clothingAssessment = clothingAssessment;
	}

	public Integer getDefecationAssessment() {
		return defecationAssessment;
	}

	public void setDefecationAssessment(Integer defecationAssessment) {
		this.defecationAssessment = defecationAssessment;
	}

	public Integer getExerciseAssessment() {
		return exerciseAssessment;
	}

	public void setExerciseAssessment(Integer exerciseAssessment) {
		this.exerciseAssessment = exerciseAssessment;
	}

	public String getCognitionScreenResult() {
		return cognitionScreenResult;
	}

	public void setCognitionScreenResult(String cognitionScreenResult) {
		this.cognitionScreenResult = cognitionScreenResult;
	}

	public Integer getCognitionScreenScore() {
		return cognitionScreenScore;
	}

	public void setCognitionScreenScore(Integer cognitionScreenScore) {
		this.cognitionScreenScore = cognitionScreenScore;
	}

	public String getEmotionScreenResult() {
		return emotionScreenResult;
	}

	public void setEmotionScreenResult(String emotionScreenResult) {
		this.emotionScreenResult = emotionScreenResult;
	}

	public Integer getDepressionScore() {
		return depressionScore;
	}

	public void setDepressionScore(Integer depressionScore) {
		this.depressionScore = depressionScore;
	}

	public String getTrainFrequencyTypeCode() {
		return trainFrequencyTypeCode;
	}

	public void setTrainFrequencyTypeCode(String trainFrequencyTypeCode) {
		this.trainFrequencyTypeCode = trainFrequencyTypeCode;
	}

	public Integer getTrainingMin() {
		return trainingMin;
	}

	public void setTrainingMin(Integer trainingMin) {
		this.trainingMin = trainingMin;
	}

	public Integer getTrainingTotaltime() {
		return trainingTotaltime;
	}

	public void setTrainingTotaltime(Integer trainingTotaltime) {
		this.trainingTotaltime = trainingTotaltime;
	}

	public String getTrainingWay() {
		return trainingWay;
	}

	public void setTrainingWay(String trainingWay) {
		this.trainingWay = trainingWay;
	}

	public String getDietPreDesc() {
		return dietPreDesc;
	}

	public void setDietPreDesc(String dietPreDesc) {
		this.dietPreDesc = dietPreDesc;
	}

	public String getSmodeStatusCode() {
		return smodeStatusCode;
	}

	public void setSmodeStatusCode(String smodeStatusCode) {
		this.smodeStatusCode = smodeStatusCode;
	}

	public Integer getDailySmoke() {
		return dailySmoke;
	}

	public void setDailySmoke(Integer dailySmoke) {
		this.dailySmoke = dailySmoke;
	}

	public Integer getSmokeAge() {
		return smokeAge;
	}

	public void setSmokeAge(Integer smokeAge) {
		this.smokeAge = smokeAge;
	}

	public Integer getQuitSmokeAge() {
		return quitSmokeAge;
	}

	public void setQuitSmokeAge(Integer quitSmokeAge) {
		this.quitSmokeAge = quitSmokeAge;
	}

	public String getDrinkFrequency() {
		return drinkFrequency;
	}

	public void setDrinkFrequency(String drinkFrequency) {
		this.drinkFrequency = drinkFrequency;
	}

	public Integer getDailyDrink() {
		return dailyDrink;
	}

	public void setDailyDrink(Integer dailyDrink) {
		this.dailyDrink = dailyDrink;
	}

	public String getNodrink() {
		return nodrink;
	}

	public void setNodrink(String nodrink) {
		this.nodrink = nodrink;
	}

	public Integer getNodrinkAge() {
		return nodrinkAge;
	}

	public void setNodrinkAge(Integer nodrinkAge) {
		this.nodrinkAge = nodrinkAge;
	}

	public Integer getDrinkAge() {
		return drinkAge;
	}

	public void setDrinkAge(Integer drinkAge) {
		this.drinkAge = drinkAge;
	}

	public String getDrunk() {
		return drunk;
	}

	public void setDrunk(String drunk) {
		this.drunk = drunk;
	}

	public String getDrinkTypeDesc() {
		return drinkTypeDesc;
	}

	public void setDrinkTypeDesc(String drinkTypeDesc) {
		this.drinkTypeDesc = drinkTypeDesc;
	}

	public String getOccupationExposureFlag() {
		return occupationExposureFlag;
	}

	public void setOccupationExposureFlag(String occupationExposureFlag) {
		this.occupationExposureFlag = occupationExposureFlag;
	}

	public String getRiskOccupationDesc() {
		return riskOccupationDesc;
	}

	public void setRiskOccupationDesc(String riskOccupationDesc) {
		this.riskOccupationDesc = riskOccupationDesc;
	}

	public Integer getRiskOccupationTime() {
		return riskOccupationTime;
	}

	public void setRiskOccupationTime(Integer riskOccupationTime) {
		this.riskOccupationTime = riskOccupationTime;
	}

	public String getDustTypeDesc() {
		return dustTypeDesc;
	}

	public void setDustTypeDesc(String dustTypeDesc) {
		this.dustTypeDesc = dustTypeDesc;
	}

	public String getDustProtectionFlag() {
		return dustProtectionFlag;
	}

	public void setDustProtectionFlag(String dustProtectionFlag) {
		this.dustProtectionFlag = dustProtectionFlag;
	}

	public String getDustProtectionDesc() {
		return dustProtectionDesc;
	}

	public void setDustProtectionDesc(String dustProtectionDesc) {
		this.dustProtectionDesc = dustProtectionDesc;
	}

	public String getRadiationTypeDesc() {
		return radiationTypeDesc;
	}

	public void setRadiationTypeDesc(String radiationTypeDesc) {
		this.radiationTypeDesc = radiationTypeDesc;
	}

	public String getRadiationProtectionFlag() {
		return radiationProtectionFlag;
	}

	public void setRadiationProtectionFlag(String radiationProtectionFlag) {
		this.radiationProtectionFlag = radiationProtectionFlag;
	}

	public String getRadiationProtectionDesc() {
		return radiationProtectionDesc;
	}

	public void setRadiationProtectionDesc(String radiationProtectionDesc) {
		this.radiationProtectionDesc = radiationProtectionDesc;
	}

	public String getPhysicsTypeDesc() {
		return physicsTypeDesc;
	}

	public void setPhysicsTypeDesc(String physicsTypeDesc) {
		this.physicsTypeDesc = physicsTypeDesc;
	}

	public String getPhysicsProtectionFlag() {
		return physicsProtectionFlag;
	}

	public void setPhysicsProtectionFlag(String physicsProtectionFlag) {
		this.physicsProtectionFlag = physicsProtectionFlag;
	}

	public String getPhysicsProtectionDesc() {
		return physicsProtectionDesc;
	}

	public void setPhysicsProtectionDesc(String physicsProtectionDesc) {
		this.physicsProtectionDesc = physicsProtectionDesc;
	}

	public String getChemistryTypeDesc() {
		return chemistryTypeDesc;
	}

	public void setChemistryTypeDesc(String chemistryTypeDesc) {
		this.chemistryTypeDesc = chemistryTypeDesc;
	}

	public String getChemistryProtectionFlag() {
		return chemistryProtectionFlag;
	}

	public void setChemistryProtectionFlag(String chemistryProtectionFlag) {
		this.chemistryProtectionFlag = chemistryProtectionFlag;
	}

	public String getChemistryProtectionDesc() {
		return chemistryProtectionDesc;
	}

	public void setChemistryProtectionDesc(String chemistryProtectionDesc) {
		this.chemistryProtectionDesc = chemistryProtectionDesc;
	}

	public String getOtherTypeDesc() {
		return otherTypeDesc;
	}

	public void setOtherTypeDesc(String otherTypeDesc) {
		this.otherTypeDesc = otherTypeDesc;
	}

	public String getOtherProtectionFlag() {
		return otherProtectionFlag;
	}

	public void setOtherProtectionFlag(String otherProtectionFlag) {
		this.otherProtectionFlag = otherProtectionFlag;
	}

	public String getOtherProtectionDesc() {
		return otherProtectionDesc;
	}

	public void setOtherProtectionDesc(String otherProtectionDesc) {
		this.otherProtectionDesc = otherProtectionDesc;
	}

	public String getLipAppearanceCehckResult() {
		return lipAppearanceCehckResult;
	}

	public void setLipAppearanceCehckResult(String lipAppearanceCehckResult) {
		this.lipAppearanceCehckResult = lipAppearanceCehckResult;
	}

	public String getDentitionType() {
		return dentitionType;
	}

	public void setDentitionType(String dentitionType) {
		this.dentitionType = dentitionType;
	}

	public String getDentitionDesc() {
		return dentitionDesc;
	}

	public void setDentitionDesc(String dentitionDesc) {
		this.dentitionDesc = dentitionDesc;
	}

	public String getDentitionAnomalyFlag() {
		return dentitionAnomalyFlag;
	}

	public void setDentitionAnomalyFlag(String dentitionAnomalyFlag) {
		this.dentitionAnomalyFlag = dentitionAnomalyFlag;
	}

	public Integer getMissingToothFlg() {
		return missingToothFlg;
	}

	public void setMissingToothFlg(Integer missingToothFlg) {
		this.missingToothFlg = missingToothFlg;
	}

	public Integer getMissingToothNumberUpl() {
		return missingToothNumberUpl;
	}

	public void setMissingToothNumberUpl(Integer missingToothNumberUpl) {
		this.missingToothNumberUpl = missingToothNumberUpl;
	}

	public Integer getMissingToothNumberUpr() {
		return missingToothNumberUpr;
	}

	public void setMissingToothNumberUpr(Integer missingToothNumberUpr) {
		this.missingToothNumberUpr = missingToothNumberUpr;
	}

	public Integer getMissingToothNumberDownl() {
		return missingToothNumberDownl;
	}

	public void setMissingToothNumberDownl(Integer missingToothNumberDownl) {
		this.missingToothNumberDownl = missingToothNumberDownl;
	}

	public Integer getMissingToothNumberDownr() {
		return missingToothNumberDownr;
	}

	public void setMissingToothNumberDownr(Integer missingToothNumberDownr) {
		this.missingToothNumberDownr = missingToothNumberDownr;
	}

	public Integer getDecayedToothFlg() {
		return decayedToothFlg;
	}

	public void setDecayedToothFlg(Integer decayedToothFlg) {
		this.decayedToothFlg = decayedToothFlg;
	}

	public Integer getDecayedToothNumberUpl() {
		return decayedToothNumberUpl;
	}

	public void setDecayedToothNumberUpl(Integer decayedToothNumberUpl) {
		this.decayedToothNumberUpl = decayedToothNumberUpl;
	}

	public Integer getDecayedToothNumberUpr() {
		return decayedToothNumberUpr;
	}

	public void setDecayedToothNumberUpr(Integer decayedToothNumberUpr) {
		this.decayedToothNumberUpr = decayedToothNumberUpr;
	}

	public Integer getDecayedToothNumberDownl() {
		return decayedToothNumberDownl;
	}

	public void setDecayedToothNumberDownl(Integer decayedToothNumberDownl) {
		this.decayedToothNumberDownl = decayedToothNumberDownl;
	}

	public Integer getDecayedToothNumberDownr() {
		return decayedToothNumberDownr;
	}

	public void setDecayedToothNumberDownr(Integer decayedToothNumberDownr) {
		this.decayedToothNumberDownr = decayedToothNumberDownr;
	}

	public Integer getDentureToothFlg() {
		return dentureToothFlg;
	}

	public void setDentureToothFlg(Integer dentureToothFlg) {
		this.dentureToothFlg = dentureToothFlg;
	}

	public Integer getDentureToothNumberUpl() {
		return dentureToothNumberUpl;
	}

	public void setDentureToothNumberUpl(Integer dentureToothNumberUpl) {
		this.dentureToothNumberUpl = dentureToothNumberUpl;
	}

	public Integer getDentureToothNumberUpr() {
		return dentureToothNumberUpr;
	}

	public void setDentureToothNumberUpr(Integer dentureToothNumberUpr) {
		this.dentureToothNumberUpr = dentureToothNumberUpr;
	}

	public Integer getDentureToothNumberDownl() {
		return dentureToothNumberDownl;
	}

	public void setDentureToothNumberDownl(Integer dentureToothNumberDownl) {
		this.dentureToothNumberDownl = dentureToothNumberDownl;
	}

	public Integer getDentureToothNumberDownr() {
		return dentureToothNumberDownr;
	}

	public void setDentureToothNumberDownr(Integer dentureToothNumberDownr) {
		this.dentureToothNumberDownr = dentureToothNumberDownr;
	}

	public String getPeriodontalCehckResult() {
		return periodontalCehckResult;
	}

	public void setPeriodontalCehckResult(String periodontalCehckResult) {
		this.periodontalCehckResult = periodontalCehckResult;
	}

	public String getPharynxCheckResult() {
		return pharynxCheckResult;
	}

	public void setPharynxCheckResult(String pharynxCheckResult) {
		this.pharynxCheckResult = pharynxCheckResult;
	}

	public String getThroatTonsilCheckResult() {
		return throatTonsilCheckResult;
	}

	public void setThroatTonsilCheckResult(String throatTonsilCheckResult) {
		this.throatTonsilCheckResult = throatTonsilCheckResult;
	}

	public String getThroatCheckResult() {
		return throatCheckResult;
	}

	public void setThroatCheckResult(String throatCheckResult) {
		this.throatCheckResult = throatCheckResult;
	}

	public String getThroatAnomalyDesc() {
		return throatAnomalyDesc;
	}

	public void setThroatAnomalyDesc(String throatAnomalyDesc) {
		this.throatAnomalyDesc = throatAnomalyDesc;
	}

	public Float getlNakedEye() {
		return lNakedEye;
	}

	public void setlNakedEye(Float lNakedEye) {
		this.lNakedEye = lNakedEye;
	}

	public Float getrNakedEye() {
		return rNakedEye;
	}

	public void setrNakedEye(Float rNakedEye) {
		this.rNakedEye = rNakedEye;
	}

	public Float getlEyecorrection() {
		return lEyecorrection;
	}

	public void setlEyecorrection(Float lEyecorrection) {
		this.lEyecorrection = lEyecorrection;
	}

	public Float getrEyecorrection() {
		return rEyecorrection;
	}

	public void setrEyecorrection(Float rEyecorrection) {
		this.rEyecorrection = rEyecorrection;
	}

	public String getHearDetectResult() {
		return hearDetectResult;
	}

	public void setHearDetectResult(String hearDetectResult) {
		this.hearDetectResult = hearDetectResult;
	}

	public String getMotorFuncState() {
		return motorFuncState;
	}

	public void setMotorFuncState(String motorFuncState) {
		this.motorFuncState = motorFuncState;
	}

	public String getColorVision() {
		return colorVision;
	}

	public void setColorVision(String colorVision) {
		this.colorVision = colorVision;
	}

	public String getEardrumCheckResult() {
		return eardrumCheckResult;
	}

	public void setEardrumCheckResult(String eardrumCheckResult) {
		this.eardrumCheckResult = eardrumCheckResult;
	}

	public String getEarAnomalyfDesc() {
		return earAnomalyfDesc;
	}

	public void setEarAnomalyfDesc(String earAnomalyfDesc) {
		this.earAnomalyfDesc = earAnomalyfDesc;
	}

	public String getNasalSeptumCheckResult() {
		return nasalSeptumCheckResult;
	}

	public void setNasalSeptumCheckResult(String nasalSeptumCheckResult) {
		this.nasalSeptumCheckResult = nasalSeptumCheckResult;
	}

	public String getNasalMucosaCheckResult() {
		return nasalMucosaCheckResult;
	}

	public void setNasalMucosaCheckResult(String nasalMucosaCheckResult) {
		this.nasalMucosaCheckResult = nasalMucosaCheckResult;
	}

	public String getNasalAnomalyfDesc() {
		return nasalAnomalyfDesc;
	}

	public void setNasalAnomalyfDesc(String nasalAnomalyfDesc) {
		this.nasalAnomalyfDesc = nasalAnomalyfDesc;
	}

	public String getPhysiologyAnomalyFlag() {
		return physiologyAnomalyFlag;
	}

	public void setPhysiologyAnomalyFlag(String physiologyAnomalyFlag) {
		this.physiologyAnomalyFlag = physiologyAnomalyFlag;
	}

	public String getPhysiologyAnomalyfDesc() {
		return physiologyAnomalyfDesc;
	}

	public void setPhysiologyAnomalyfDesc(String physiologyAnomalyfDesc) {
		this.physiologyAnomalyfDesc = physiologyAnomalyfDesc;
	}

	public String getExaminationResult() {
		return examinationResult;
	}

	public void setExaminationResult(String examinationResult) {
		this.examinationResult = examinationResult;
	}

	public String getExaminationOrganCode() {
		return examinationOrganCode;
	}

	public void setExaminationOrganCode(String examinationOrganCode) {
		this.examinationOrganCode = examinationOrganCode;
	}

	public String getExaminationOrganName() {
		return examinationOrganName;
	}

	public void setExaminationOrganName(String examinationOrganName) {
		this.examinationOrganName = examinationOrganName;
	}

	public String getManaDoctorId() {
		return manaDoctorId;
	}

	public void setManaDoctorId(String manaDoctorId) {
		this.manaDoctorId = manaDoctorId;
	}

	public String getManaDoctorNo() {
		return manaDoctorNo;
	}

	public void setManaDoctorNo(String manaDoctorNo) {
		this.manaDoctorNo = manaDoctorNo;
	}

	public String getManaDoctorName() {
		return manaDoctorName;
	}

	public void setManaDoctorName(String manaDoctorName) {
		this.manaDoctorName = manaDoctorName;
	}

	public String getManaDoctorIdcard() {
		return manaDoctorIdcard;
	}

	public void setManaDoctorIdcard(String manaDoctorIdcard) {
		this.manaDoctorIdcard = manaDoctorIdcard;
	}

	public String getInputIdcard() {
		return inputIdcard;
	}

	public void setInputIdcard(String inputIdcard) {
		this.inputIdcard = inputIdcard;
	}

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public String getInputerId() {
		return inputerId;
	}

	public void setInputerId(String inputerId) {
		this.inputerId = inputerId;
	}

	public Date getExaminationDate() {
		return examinationDate;
	}

	public void setExaminationDate(Date examinationDate) {
		this.examinationDate = examinationDate;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public BigDecimal getPhysicalExamCost() {
		return physicalExamCost;
	}

	public void setPhysicalExamCost(BigDecimal physicalExamCost) {
		this.physicalExamCost = physicalExamCost;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

 }