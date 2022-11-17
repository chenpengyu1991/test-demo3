package com.founder.rhip.ehr.entity.clinic;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.annotation.DisplayField;
import com.founder.rhip.ehr.annotation.RecordTrace;
import com.founder.rhip.ehr.annotation.Star;
import com.founder.rhip.ehr.common.StarType;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "MS_PHYSIQUE_EXAMINATION")
public class PhysiqueExamination implements Serializable {

    private static final long serialVersionUID = 1L;

    @RecordTrace
    @Star(star = StarType.THREE)
    @DisplayField(star = StarType.THREE)
    @Column(name = "EXAMINATION_DATE", columnDefinition = "DATE|体检日期||", nullable = true)
    private Date examinationDate;
    
    @Column(name = "MANA_DOCTOR_NO", columnDefinition = "VARCHAR2|责任医师工号||", length = 18, nullable = true)
    private String manaDoctorNo;

    @DisplayField(star = StarType.THREE)
    @Column(name = "MANA_DOCTOR_ID", columnDefinition = "VARCHAR2|责任医师ID||", length = 50, nullable = true)
    private String manaDoctorId;

    @Column(name = "MANA_DOCTOR_NAME", columnDefinition = "VARCHAR2|责任医师姓名||", length = 50, nullable = true)
    private String manaDoctorName;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = false)
    private String ehrId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "PHYSICAL_EXAM_CODE", columnDefinition = "VARCHAR2|健康体检表编号||", length = 18, nullable = true)
    private String physicalExamCode;

    @Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号||", length = 17, nullable = true)
    private String healthFileNo;
    
    @Column(name = "PHYSICAL_EXAM_TYPE", columnDefinition = "VARCHAR2|体检类别||", length = 10, nullable = true)
    private String physicalExamType;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
    private String name;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
    private String gender;

    @Column(name = "AGE", columnDefinition = "VARCHAR2|年龄||", length = 20, nullable = true)
    private String age;

    @Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
    private Date birthday;

    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况||", length = 3, nullable = true)
    private String marriage;

    @Star(star = StarType.THREE)
    @DisplayField(star = StarType.THREE)
    @Column(name = "SYMPTOM_FLAG", columnDefinition = "CHAR|症状标志||", length = 1, nullable = true)
    private String symptomFlag;

    @Column(name = "SYMPTOM_HEADACHE", columnDefinition = "CHAR|头痛||", length = 1, nullable = true)
    private String symptomHeadache;

    @Column(name = "SYMPTOM_DIZZY", columnDefinition = "CHAR|头晕||", length = 1, nullable = true)
    private String symptomDizzy;

    @Column(name = "SYMPTOM_PALPITATIONS", columnDefinition = "CHAR|心悸||", length = 1, nullable = true)
    private String symptomPalpitations;

    @Column(name = "SYMPTOM_CHEST_TIGHTNESS", columnDefinition = "CHAR|胸闷||", length = 1, nullable = true)
    private String symptomChestTightness;

    @Column(name = "SYMPTOM_CHEST_PAIN", columnDefinition = "CHAR|胸痛||", length = 1, nullable = true)
    private String symptomChestPain;

    @Column(name = "SYMPTOM_CHRONIC_COUGH", columnDefinition = "CHAR|慢性咳嗽||", length = 1, nullable = true)
    private String symptomChronicCough;

    @Column(name = "SYMPTOM_COUGH", columnDefinition = "CHAR|咳嗽||", length = 1, nullable = true)
    private String symptomCough;

    @Column(name = "SYMPTOM_DYSPNEA", columnDefinition = "CHAR|呼吸困难||", length = 1, nullable = true)
    private String symptomDyspnea;

    @Column(name = "SYMPTOM_POLYDIPSIA", columnDefinition = "CHAR|多饮||", length = 1, nullable = true)
    private String symptomPolydipsia;

    @Column(name = "SYMPTOM_POLYURIA", columnDefinition = "CHAR|多尿||", length = 1, nullable = true)
    private String symptomPolyuria;

    @Column(name = "SYMPTOM_WEIGHT_LOSS", columnDefinition = "CHAR|体重下降||", length = 1, nullable = true)
    private String symptomWeightLoss;

    @Column(name = "SYMPTOM_FATIGUE", columnDefinition = "CHAR|乏力||", length = 1, nullable = true)
    private String symptomFatigue;

    @Column(name = "SYMPTOM_JOINT_PAIN", columnDefinition = "CHAR|关节肿痛||", length = 1, nullable = true)
    private String symptomJointPain;

    @Column(name = "SYMPTOM_BLURRED_VISION", columnDefinition = "CHAR|视力模糊||", length = 1, nullable = true)
    private String symptomBlurredVision;

    @Column(name = "SYMPTOM_NUMBNESS", columnDefinition = "CHAR|手脚麻木||", length = 1, nullable = true)
    private String symptomNumbness;

    @Column(name = "SYMPTOM_URGENCY", columnDefinition = "CHAR|尿急||", length = 1, nullable = true)
    private String symptomUrgency;

    @Column(name = "SYMPTOM_DYSURIA", columnDefinition = "CHAR|尿痛||", length = 1, nullable = true)
    private String symptomDysuria;

    @Column(name = "SYMPTOM_CONSTIPATION", columnDefinition = "CHAR|便秘||", length = 1, nullable = true)
    private String symptomConstipation;

    @Column(name = "SYMPTOM_DIARRHEA", columnDefinition = "CHAR|腹泻||", length = 1, nullable = true)
    private String symptomDiarrhea;

    @Column(name = "SYMPTOM_NAUSEA_VOMITING", columnDefinition = "CHAR|恶心呕吐||", length = 1, nullable = true)
    private String symptomNauseaVomiting;

    @Column(name = "SYMPTOM_VERTIGO", columnDefinition = "CHAR|眼花||", length = 1, nullable = true)
    private String symptomVertigo;

    @Column(name = "SYMPTOM_TINNITUS", columnDefinition = "CHAR|耳鸣||", length = 1, nullable = true)
    private String symptomTinnitus;

    @Column(name = "SYMPTOM_BREAST_TENDERNESS", columnDefinition = "CHAR|乳房胀痛||", length = 1, nullable = true)
    private String symptomBreastTenderness;

    @Column(name = "SYMPTOM_OTHER", columnDefinition = "CHAR|其他症状||", length = 1, nullable = true)
    private String symptomOther;

    @Column(name = "SYMPTOM_OTHER_DESC", columnDefinition = "VARCHAR2|其他症状描述||", length = 100, nullable = true)
    private String symptomOtherDesc;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "TEMPERATURE", columnDefinition = "NUMBER|体温(℃)||", scale = 4, precision = 1, nullable = true)
    private BigDecimal temperature;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "PULSE_RATE", columnDefinition = "NUMBER|脉率(次/min)||", length = 4, nullable = true)
    private Integer pulseRate;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "RESPIRATORY_RATE", columnDefinition = "NUMBER|呼吸频率(次/min)||", length = 4, nullable = true)
    private Integer respiratoryRate;

    @RecordTrace
    @Column(name = "LEFT_SBP", columnDefinition = "NUMBER|左侧收缩压(mmHg)||", length = 4, nullable = true)
    private Integer leftSbp;

    @RecordTrace
    @Column(name = "LEFT_DBP", columnDefinition = "NUMBER|左侧舒张压(mmHg)||", length = 4, nullable = true)
    private Integer leftDbp;

    @RecordTrace
    @Column(name = "RIGHT_SBP", columnDefinition = "NUMBER|右侧收缩压(mmHg)||", length = 4, nullable = true)
    private Integer rightSbp;

    @RecordTrace
    @Column(name = "RIGHT_DBP", columnDefinition = "NUMBER|右侧舒张压(mmHg)||", length = 4, nullable = true)
    private Integer rightDbp;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "HEIGHT", columnDefinition = "NUMBER|身高(cm)||", scale = 5, precision = 1, nullable = true)
    private BigDecimal height;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "BODY_WEIGHT", columnDefinition = "NUMBER|体重(kg)||", scale = 5, precision = 1, nullable = true)
    private BigDecimal bodyWeight;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "WAOSTLINE", columnDefinition = "NUMBER|腰围(cm)||", scale = 5, precision = 1, nullable = true)
    private BigDecimal waostline;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "INDEX_OF_BODY_CHARACTERISTICS", columnDefinition = "NUMBER|体质指数(BMI)||", scale = 5, precision = 2, nullable = true)
    private BigDecimal indexOfBodyCharacteristics;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "WHR", columnDefinition = "NUMBER|腰臀围比值||", scale = 5, precision = 1, nullable = true)
    private BigDecimal whr;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "HIP", columnDefinition = "NUMBER|臀围(cm)||", scale = 5, precision = 1, nullable = true)
    private BigDecimal hip;

    @RecordTrace(isDic = true, dictCode = "CV0401013")
    @Column(name = "HEALTH_SELF_ASSESSMENT", columnDefinition = "VARCHAR2|老年人健康状态自我评估||", length = 1, nullable = true)
    private String healthSelfAssessment;

    @RecordTrace(isDic = true, dictCode = "CV0401014")
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

    @RecordTrace
    @Column(name = "COGNITION_SCREEN_RESULT", columnDefinition = "VARCHAR2|老年人认知功能粗筛结果||", length = 1, nullable = true)
    private String cognitionScreenResult;

    @Column(name = "COGNITION_SCREEN_SCORE", columnDefinition = "NUMBER|老年人认知功能评分||", length = 4, nullable = true)
    private Integer cognitionScreenScore;

    @RecordTrace
    @Column(name = "EMOTION_SCREEN_RESULT", columnDefinition = "VARCHAR2|老年人情感状态粗筛结果||", length = 1, nullable = true)
    private String emotionScreenResult;

    @Column(name = "EMOTION_SCREEN_RESULT_STR", columnDefinition = "VARCHAR2|老年人情感状态粗筛结果字符串||", length = 1, nullable = true)
    private String emotionScreenResultStr;
    
    @Column(name = "DEPRESSION_SCORE", columnDefinition = "NUMBER|老年人抑郁评分||", length = 3, nullable = true)
    private Integer depressionScore;

    @RecordTrace(isDic = true, dictCode = "FS10208")
    @Column(name = "TRAIN_FREQUENCY_TYPE_CODE", columnDefinition = "VARCHAR2|锻炼频率||", length = 1, nullable = true)
    private String trainFrequencyTypeCode;

    @RecordTrace
    @Column(name = "TRAINING_MIN", columnDefinition = "NUMBER|每次锻炼时间(分钟)||", length = 4, nullable = true)
    private Integer trainingMin;

    @RecordTrace
    @Column(name = "TRAINING_TOTALTIME", columnDefinition = "NUMBER|坚持锻炼时间(月)||", length = 5, nullable = true)
    private BigDecimal trainingTotaltime;

    @RecordTrace(isDic = true, dictCode = "FS990004")
    @Column(name = "TRAINING_WAY", columnDefinition = "VARCHAR2|锻炼方式||", length = 100, nullable = true)
    private String trainingWay;
    
    @RecordTrace
    @Column(name = "OTHER_TRAINING_WAY", columnDefinition = "VARCHAR2|其他锻炼方式||", length = 100, nullable = true)
    private String otherTrainingWay;

    @Column(name = "DIET_HUNSU_EQUILIBRIUM", columnDefinition = "CHAR|荤素均衡||", length = 1, nullable = true)
    private String dietHunsuEquilibrium;
    
    @Column(name = "DIET_MEAT_MAIN", columnDefinition = "CHAR|荤食为主||", length = 1, nullable = true)
    private String dietMeatMain;

    @Column(name = "DIET_VEGETARIAN", columnDefinition = "CHAR|素食为主||", length = 1, nullable = true)
    private String dietVegetarian;

    @Column(name = "DIET_HALOPHILIC", columnDefinition = "CHAR|嗜盐||", length = 1, nullable = true)
    private String dietHalophilic;

    @Column(name = "DIET_ADDICTED_OIL", columnDefinition = "CHAR|嗜油||", length = 1, nullable = true)
    private String dietAddictedOil;

    @Column(name = "DIET_SUGAR_CRAVINGS", columnDefinition = "CHAR|嗜糖||", length = 1, nullable = true)
    private String dietSugarCravings;

    @RecordTrace(isDic = true, dictCode = "CV0300101")
    @Column(name = "SMODE_STATUS_CODE", columnDefinition = "VARCHAR2|吸烟状况||", length = 1, nullable = true)
    private String smodeStatusCode;

    @RecordTrace
    @Column(name = "DAILY_SMOKE", columnDefinition = "NUMBER|日吸烟量(支)||", length = 4, nullable = true)
    private Integer dailySmoke;

    @RecordTrace
    @Column(name = "SMOKE_AGE", columnDefinition = "NUMBER|开始吸烟年龄(岁)||", length = 3, nullable = true)
    private Integer smokeAge;

    @RecordTrace
    @Column(name = "QUIT_SMOKE_AGE", columnDefinition = "NUMBER|戒烟年龄(岁)||", length = 3, nullable = true)
    private Integer quitSmokeAge;

    @RecordTrace(isDic = true, dictCode = "FS10208")
    @Column(name = "DRINK_FREQUENCY", columnDefinition = "VARCHAR2|饮酒频率||", length = 1, nullable = true)
    private String drinkFrequency;

    @RecordTrace
    @Column(name = "blood_pressure_source", columnDefinition = "VARCHAR2|血压来源||", length = 1, nullable = true)
    private String bloodPressureSource;
    
    @RecordTrace
    @Column(name = "blood_sugar_source", columnDefinition = "VARCHAR2|血糖来源||", length = 1, nullable = true)
    private String bloodSugarSource;
    
    @RecordTrace
    @Column(name = "DAILY_DRINK", columnDefinition = "NUMBER|日饮酒量(两)||", length = 4, nullable = true)
    private Integer dailyDrink;

    @RecordTrace(isDic = true, dictCode = "FS10214")
    @Column(name = "NODRINK", columnDefinition = "CHAR|戒酒标志||", length = 1, nullable = true)
    private String nodrink;

    @RecordTrace
    @Column(name = "NODRINK_AGE", columnDefinition = "NUMBER|戒酒年龄(岁)||", length = 3, nullable = true)
    private Integer nodrinkAge;

    @RecordTrace
    @Column(name = "DRINK_AGE", columnDefinition = "NUMBER|开始饮酒年龄(岁)||", length = 3, nullable = true)
    private Integer drinkAge;

    @RecordTrace(isDic = true, dictCode = "FS10009")
    @Column(name = "DRUNK", columnDefinition = "CHAR|醉酒标志||", length = 1, nullable = true)
    private String drunk;

    @Column(name = "DRINK_SPIRIT", columnDefinition = "CHAR|白酒||", length = 1, nullable = true)
    private String drinkSpirit;

    @Column(name = "DRINK_BEER", columnDefinition = "CHAR|啤酒||", length = 1, nullable = true)
    private String drinkBeer;

    @Column(name = "DRINK_RED_WINE", columnDefinition = "CHAR|红酒||", length = 1, nullable = true)
    private String drinkRedWine;

    @Column(name = "DRINK_YELLOW_WINE", columnDefinition = "CHAR|黄酒||", length = 1, nullable = true)
    private String drinkYellowWine;

    @Column(name = "DRINK_OTHER", columnDefinition = "CHAR|其他||", length = 1, nullable = true)
    private String drinkOther;

    @Column(name = "DRINK_OTHER_DESC", columnDefinition = "VARCHAR2|其他描述||", length = 100, nullable = true)
    private String drinkOtherDesc;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
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

    @RecordTrace(isDic = true, dictCode = "CV0410007")
    @DisplayField(star = StarType.THREE)
    @Column(name = "LIP_APPEARANCE_CEHCK_RESULT", columnDefinition = "VARCHAR2|口唇外观检查结果||", length = 1, nullable = true)
    private String lipAppearanceCehckResult;

    @Column(name = "DENTITION_TYPE", columnDefinition = "VARCHAR2|齿列类别||", length = 1, nullable = true)
    private String dentitionType;

    @Column(name = "DENTITION_DESC", columnDefinition = "VARCHAR2|齿列描述||", length = 100, nullable = true)
    private String dentitionDesc;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "DENTITION_ANOMALY_FLAG", columnDefinition = "CHAR|齿列异常标志||", length = 1, nullable = true)
    private String dentitionAnomalyFlag;

    @Column(name = "MISSING_TOOTH_FLG", columnDefinition = "NUMBER|缺齿标志||", length = 1, nullable = true)
    private Integer missingToothFlg;

    @Column(name = "MISSING_TOOTH", columnDefinition = "VARCHAR2|缺齿位置,上左,上右,下左,下右以逗号分隔||", length = 1, nullable = true)
    private String missingTooth;

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

    @Column(name = "DECAYED_TOOTH", columnDefinition = "VARCHAR2|龋齿位置,上左,上右,下左,下右以逗号分隔||", length = 1, nullable = true)
    private String decayedTooth;

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

    @Column(name = "DENTURE_TOOTH", columnDefinition = "VARCHAR2|义齿位置,上左,上右,下左,下右以逗号分隔||", length = 1, nullable = true)
    private String dentureTooth;

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

    @RecordTrace(isDic = true, dictCode = "FS10183")
    @DisplayField(star = StarType.THREE)
    @Column(name = "PHARYNX_CHECK_RESULT", columnDefinition = "VARCHAR2|咽部检查结果||", length = 1, nullable = true)
    private String pharynxCheckResult;

    @Column(name = "THROAT_TONSIL_CHECK_RESULT", columnDefinition = "VARCHAR2|喉部扁桃体检查结果||", length = 1, nullable = true)
    private String throatTonsilCheckResult;

    @Column(name = "THROAT_CHECK_RESULT", columnDefinition = "VARCHAR2|喉头检查结果||", length = 1, nullable = true)
    private String throatCheckResult;

    @Column(name = "THROAT_ANOMALY_DESC", columnDefinition = "VARCHAR2|喉部检查异常描述||", length = 1, nullable = true)
    private String throatAnomalyDesc;

    @RecordTrace
    @Column(name = "L_NAKED_EYE", columnDefinition = "NUMBER|左眼裸眼远视力值||", scale = 3, precision = 1, nullable = true)
    private Float lNakedEye;

    @RecordTrace
    @Column(name = "R_NAKED_EYE", columnDefinition = "NUMBER|右眼裸眼远枧力值||", scale = 3, precision = 1, nullable = true)
    private Float rNakedEye;

    @RecordTrace
    @Column(name = "L_EYECORRECTION", columnDefinition = "NUMBER|左眼矫正远视力值||", scale = 3, precision = 1, nullable = true)
    private Float lEyecorrection;

    @RecordTrace
    @Column(name = "R_EYECORRECTION", columnDefinition = "NUMBER|右眼矫正远视力值||", scale = 3, precision = 1, nullable = true)
    private Float rEyecorrection;

    @RecordTrace(isDic = true, dictCode = "FS10170")
    @DisplayField(star = StarType.THREE)
    @Column(name = "HEAR_DETECT_RESULT", columnDefinition = "VARCHAR2|听力检测结果||", length = 1, nullable = true)
    private String hearDetectResult;

    @RecordTrace(isDic = true, dictCode = "FS10212")
    @DisplayField(star = StarType.THREE)
    @Column(name = "MOTOR_FUNC_STATE", columnDefinition = "VARCHAR2|运动功能状态||", length = 1, nullable = true)
    private String motorFuncState;

    @DisplayField(star = StarType.THREE)
    @Column(name = "FUNDUS_OCULI_ANOMALY_FLAG", columnDefinition = "CHAR|眼底检查结果异常标志||", length = 1, nullable = true)
    private String fundusOculiAnomalyFlag;

    @Column(name = "FUNDUS_OCULI_ANOMALY_DESC", columnDefinition = "VARCHAR2|眼底检查结果异常描述||", length = 100, nullable = true)
    private String fundusOculiAnomalyDesc;

    @DisplayField(star = StarType.THREE)
    @Column(name = "SKIN_CHECK_RESULT", columnDefinition = "VARCHAR2|皮肤检查结果||", length = 1, nullable = true)
    private String skinCheckResult;

    @Column(name = "SKIN_CHECK_DESC", columnDefinition = "VARCHAR2|皮肤检查结果其他描述||", length = 100, nullable = true)
    private String skinCheckDesc;

    @DisplayField(star = StarType.THREE)
    @Column(name = "SCLERA_CHECK_RESULT", columnDefinition = "VARCHAR2|巩膜检查结果||", length = 1, nullable = true)
    private String scleraCheckResult;

    @Column(name = "SCLERA_CHECK_DESC", columnDefinition = "VARCHAR2|巩膜检查结果其他描述||", length = 100, nullable = true)
    private String scleraCheckDesc;

    @DisplayField(star = StarType.THREE)
    @Column(name = "LYMPH_NODE_CHECK_RESULT", columnDefinition = "VARCHAR2|淋巴结检查结果||", length = 1, nullable = true)
    private String lymphNodeCheckResult;

    @Column(name = "LYMPH_NODE_CHECK_DESC", columnDefinition = "VARCHAR2|淋巴结检查结果其他描述||", length = 100, nullable = true)
    private String lymphNodeCheckDesc;

    @Column(name = "LYMPHOCYTE_COUNT", columnDefinition = "NUMBER|淋巴细胞数(%)||", length = 5, nullable = true)
    private Integer lymphocyteCount;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "BARREL_CHEST", columnDefinition = "CHAR|桶状胸标志||", length = 1, nullable = true)
    private String barrelChest;

    @DisplayField(star = StarType.THREE)
    @Column(name = "LUNGS_ANOMALY_SOUND", columnDefinition = "CHAR|肺部异常呼吸音标志||", length = 1, nullable = true)
    private String lungsAnomalySound;

    @Column(name = "LUNGS_ANOMALY_DESC", columnDefinition = "VARCHAR2|肺部异常呼吸音描述||", length = 100, nullable = true)
    private String lungsAnomalyDesc;

    @DisplayField(star = StarType.THREE)
    @Column(name = "LUNGS_RALE_FLAG", columnDefinition = "CHAR|肺部罗音标志||", length = 1, nullable = true)
    private String lungsRaleFlag;

    @Column(name = "LUNGS_RALE_DESC", columnDefinition = "VARCHAR2|肺部罗音其他描述||", length = 100, nullable = true)
    private String lungsRaleDesc;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "HEART_RATE", columnDefinition = "NUMBER|心率(次/min)||", length = 4, nullable = true)
    private Integer heartRate;

    @RecordTrace(isDic = true, dictCode = "FS10176")
    @DisplayField(star = StarType.THREE)
    @Column(name = "CARDIOVERTER", columnDefinition = "VARCHAR2|心律类别||", length = 1, nullable = true)
    private String cardioverter;

    @DisplayField(star = StarType.THREE)
    @Column(name = "HEART_MURMUR_FLAG", columnDefinition = "CHAR|心脏杂音标志||", length = 1, nullable = true)
    private String heartMurmurFlag;

    @Column(name = "HEART_MURMUR_DESC", columnDefinition = "VARCHAR2|心脏杂音描述||", length = 100, nullable = true)
    private String heartMurmurDesc;

    @DisplayField(star = StarType.THREE)
    @Column(name = "ABDOMINAL_TENDERNESS_FLAG", columnDefinition = "CHAR|腹部压痛标志||", length = 1, nullable = true)
    private String abdominalTendernessFlag;

    @Column(name = "ABDOMINAL_TENDERNESS_DESC", columnDefinition = "VARCHAR2|腹部压痛描述||", length = 100, nullable = true)
    private String abdominalTendernessDesc;

    @DisplayField(star = StarType.THREE)
    @Column(name = "ABDOMINAL_MASS_FLAG", columnDefinition = "CHAR|腹部包块标志||", length = 1, nullable = true)
    private String abdominalMassFlag;

    @Column(name = "ABDOMINAL_MASS_DESC", columnDefinition = "VARCHAR2|腹部包块描述||", length = 100, nullable = true)
    private String abdominalMassDesc;

    @DisplayField(star = StarType.THREE)
    @Column(name = "LIVER_FLAG", columnDefinition = "CHAR|肝大标志||", length = 1, nullable = true)
    private String liverFlag;

    @Column(name = "LIVER_DESC", columnDefinition = "VARCHAR2|肝大描述||", length = 100, nullable = true)
    private String liverDesc;

    @DisplayField(star = StarType.THREE)
    @Column(name = "SPLENOMEGALY_FLAG", columnDefinition = "CHAR|脾大标志||", length = 1, nullable = true)
    private String splenomegalyFlag;

    @Column(name = "SPLENOMEGALY_DESC", columnDefinition = "VARCHAR2|脾大描述||", length = 100, nullable = true)
    private String splenomegalyDesc;

    @DisplayField(star = StarType.THREE)
    @Column(name = "ABDOMINAL_VOICED_FLAG", columnDefinition = "CHAR|腹部移动性浊音标志||", length = 1, nullable = true)
    private String abdominalVoicedFlag;

    @Column(name = "ABDOMINAL_VOICED_DESC", columnDefinition = "VARCHAR2|腹部移动性浊音描述||", length = 100, nullable = true)
    private String abdominalVoicedDesc;

    @RecordTrace(isDic = true, dictCode = "CV0410014")
    @DisplayField(star = StarType.THREE)
    @Column(name = "LEGS_EDEMA_CHECK_RESULT", columnDefinition = "VARCHAR2|下肢水肿检查结果||", length = 1, nullable = true)
    private String legsEdemaCheckResult;

    @RecordTrace(isDic = true, dictCode = "CV0410015")
    @DisplayField(star = StarType.THREE)
    @Column(name = "ARTERIOPALMUS", columnDefinition = "VARCHAR2|足背动脉搏动||", length = 1, nullable = true)
    private String arteriopalmus;

    @RecordTrace(isDic = true, dictCode = "CV0410013")
    @DisplayField(star = StarType.THREE)
    @Column(name = "DRE_CHECK_RESULT_TYPE", columnDefinition = "VARCHAR2|肛门指诊检查结果类别||", length = 1, nullable = true)
    private String dreCheckResultType;

    @Column(name = "DRE_CHECK_RESULT_DESC", columnDefinition = "VARCHAR2|肛门指诊检查结果描述||", length = 100, nullable = true)
    private String dreCheckResultDesc;

    @DisplayField(star = StarType.THREE)
    @Column(name = "BREAST_ANOMALY_FLAG", columnDefinition = "CHAR|乳腺检查异常标志||", length = 1, nullable = true)
    private String breastAnomalyFlag;

    @Column(name = "BREAST_RESECTION", columnDefinition = "CHAR|乳腺乳房切除||", length = 1, nullable = true)
    private String breastResection;

    @Column(name = "BREAST_ANOMALY_LACTATION", columnDefinition = "CHAR|乳腺异常泌乳||", length = 1, nullable = true)
    private String breastAnomalyLactation;

    @Column(name = "BREAST_MASS", columnDefinition = "CHAR|乳腺包块||", length = 1, nullable = true)
    private String breastMass;

    @Column(name = "BREAST_OTHER", columnDefinition = "CHAR|乳腺其他||", length = 1, nullable = true)
    private String breastOther;

    @Column(name = "BREAST_OTHER_DESC", columnDefinition = "VARCHAR2|乳腺其他描述||", length = 100, nullable = true)
    private String breastOtherDesc;

    @DisplayField(star = StarType.THREE)
    @Column(name = "VULVA_ANOMALY_FLAG", columnDefinition = "CHAR|外阴异常标志||", length = 1, nullable = true)
    private String vulvaAnomalyFlag;

    @Column(name = "VULVA_ANOMALY_DESC", columnDefinition = "VARCHAR2|外阴异常描述||", length = 100, nullable = true)
    private String vulvaAnomalyDesc;

    @DisplayField(star = StarType.THREE)
    @Column(name = "VAGINA_ANOMALY_FLAG", columnDefinition = "CHAR|阴道异常标志||", length = 1, nullable = true)
    private String vaginaAnomalyFlag;

    @Column(name = "VAGINA_ANOMALY_DESC", columnDefinition = "VARCHAR2|阴道异常描述||", length = 100, nullable = true)
    private String vaginaAnomalyDesc;

    @DisplayField(star = StarType.THREE)
    @Column(name = "CERVICAL_ANOMALY_FLAG", columnDefinition = "CHAR|宫颈异常标志||", length = 1, nullable = true)
    private String cervicalAnomalyFlag;

    @Column(name = "CERVICAL_ANOMALY_DESC", columnDefinition = "VARCHAR2|宫颈异常描述||", length = 100, nullable = true)
    private String cervicalAnomalyDesc;

    @DisplayField(star = StarType.THREE)
    @Column(name = "CORPUS_ANOMALY_FLAG", columnDefinition = "CHAR|宫体异常标志||", length = 1, nullable = true)
    private String corpusAnomalyFlag;

    @Column(name = "CORPUS_ANOMALY_DESC", columnDefinition = "VARCHAR2|宫体异常描述||", length = 100, nullable = true)
    private String corpusAnomalyDesc;

    @DisplayField(star = StarType.THREE)
    @Column(name = "ACCESSORIES_ANOMALY_FLAG", columnDefinition = "CHAR|附件异常标志||", length = 1, nullable = true)
    private String accessoriesAnomalyFlag;

    @Column(name = "ACCESSORIES_ANOMALY_DESC", columnDefinition = "VARCHAR2|附件异常描述||", length = 100, nullable = true)
    private String accessoriesAnomalyDesc;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "OTHER_CHECK_RESULT", columnDefinition = "VARCHAR2|其他查体结果||", length = 100, nullable = true)
    private String otherCheckResult;

    @Column(name = "THYROID_CHECK_RESULT", columnDefinition = "VARCHAR2|甲状腺检查结果||", length = 1, nullable = true)
    private String thyroidCheckResult;

    @Column(name = "SPINE_CHECK_RESULT", columnDefinition = "VARCHAR2|脊柱检查结果||", length = 1, nullable = true)
    private String spineCheckResult;

    @Column(name = "LIMBS_CHECK_RESULT", columnDefinition = "VARCHAR2|四肢检查结果||", length = 1, nullable = true)
    private String limbsCheckResult;

    @Column(name = "PROSTATE_CHECK_RESULT", columnDefinition = "VARCHAR2|前列腺检查结果||", length = 1, nullable = true)
    private String prostateCheckResult;

    @Column(name = "EXT_GENITAL_CHECK_ANOMALY", columnDefinition = "VARCHAR2|外生殖器异常标志||", length = 1, nullable = true)
    private String extGenitalCheckAnomaly;

	/*@Column(name = "EXT_CHECK_ANOMALY_DESC", columnDefinition = "VARCHAR2|外科检查异常描述||", length = 100, nullable = true)
    private String extGenitalCheckAnomalyDesc;*/

    @Column(name = "CHEST_CHECK_RESULT", columnDefinition = "VARCHAR2|胸廓检查结果||", length = 1, nullable = true)
    private String chestCheckResult;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "HEMOGLOBIN_VALUE", columnDefinition = "NUMBER|血红蛋白值(g/L)||", length = 4, nullable = true)
    private Integer hemoglobinValue;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "LEUKOCYTE_COUNT", columnDefinition = "NUMBER|白细胞计数值(G/L)||", scale = 4, precision = 1, nullable = true)
    private BigDecimal leukocyteCount;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "PLATELET_COUNT", columnDefinition = "NUMBER|血小板计数值(G/L)||", length = 4, nullable = true)
    private Integer plateletCount;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "BLOOD_ROUTINE_OTHER_DESC", columnDefinition = "VARCHAR2|血常规其他描述||", length = 100, nullable = true)
    private String bloodRoutineOtherDesc;

    @Column(name = "URINE_PRO_QUALITATIVE_RESULT", columnDefinition = "VARCHAR2|尿蛋白定性检测结果||", length = 1, nullable = true)
    private String urineProQualitativeResult;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "URINE_PRO_QUANTITATIVE_VALUE", columnDefinition = "NUMBER|尿蛋白定量检测值(mg/24h)||", scale = 5, precision = 1, nullable = true)
    private String urineProQuantitativeValue;

    @Column(name = "URINE_SUG_QUALITATIVE_RESULT", columnDefinition = "VARCHAR2|尿糖定性检测结果||", length = 1, nullable = true)
    private String urineSugQualitativeResult;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "URINE_SUG_QUANTITATIVE_VALUE", columnDefinition = "NUMBER|尿糖定量检测值(mmol/L)||", scale = 4, precision = 1, nullable = true)
    private String urineSugQuantitativeValue;

    @Column(name = "KET_QUALITATIVE_DETECTION", columnDefinition = "VARCHAR2|尿酮体定性检测结果||", length = 1, nullable = true)
    private String ketQualitativeDetection;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "KET_QUANTITATIVE_VALUE", columnDefinition = "VARCHAR2|尿酮体定量检测值||", length = 10, nullable = true)
    private String ketQuantitativeValue;

    @Column(name = "ERY_DETECTION_RESULT", columnDefinition = "VARCHAR2|尿潜血检测结果||", length = 1, nullable = true)
    private String eryDetectionResult;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "ERY_QUANTITATIVE_VALUE", columnDefinition = "VARCHAR2|尿潜血定量检测值||", length = 10, nullable = true)
    private String eryQuantitativeValue;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "URINE_ROUTINES_OTHER_DESC", columnDefinition = "VARCHAR2|尿常规其他描述||", length = 100, nullable = true)
    private String urineRoutinesOtherDesc;

    @Column(name = "URINE_PROPORTION", columnDefinition = "NUMBER|尿比重||", scale = 5, precision = 3, nullable = true)
    private BigDecimal urineProportion;

    @Column(name = "URINE_PH", columnDefinition = "NUMBER|尿液酸碱度||", scale = 4, precision = 1, nullable = true)
    private BigDecimal urinePh;

    @RecordTrace
    @Column(name = "FPG_MMOL", columnDefinition = "NUMBER|空腹血糖值(mmol／L)||", scale = 4, precision = 1, nullable = true)
    private BigDecimal fpgMmol;

    @RecordTrace
    @Column(name = "FPG_MG", columnDefinition = "NUMBER|空腹血糖值(mg／dL)||", scale = 4, precision = 1, nullable = true)
    private BigDecimal fpgMg;

    @Column(name = "GLU_VALUE", columnDefinition = "NUMBER|餐后2小时血糖值(mmol/L)||", scale = 4, precision = 1, nullable = true)
    private BigDecimal gluValue;

    @DisplayField(star = StarType.THREE)
    @Column(name = "ECG_ANOMALY_FLAG", columnDefinition = "CHAR|心电图异常标志||", length = 1, nullable = true)
    private String ecgAnomalyFlag;

    @Column(name = "ECG_ANOMALY_DESC", columnDefinition = "VARCHAR2|心电图异常描述||", length = 300, nullable = true)
    private String ecgAnomalyDesc;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "URINE_MICRO_TONG_ALBUMIN", columnDefinition = "NUMBER|尿微量血蛋白(mg/dL)||", scale = 5, precision = 1, nullable = true)
    private BigDecimal urineMicroTongAlbumin;

    @RecordTrace(isDic = true, dictCode = "FS10058")
    @DisplayField(star = StarType.THREE)
    @Column(name = "FECAL_OCCULT_BLOOD", columnDefinition = "CHAR|大便潜血标志||", length = 1, nullable = true)
    private String fecalOccultBlood;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "HGB", columnDefinition = "NUMBER|糖化血红蛋白值(%)||", scale = 4, precision = 1, nullable = true)
    private BigDecimal hgb;

    @RecordTrace(isDic = true, dictCode = "FS10058")
    @DisplayField(star = StarType.THREE)
    @Column(name = "HBSAG_DETECT_RESULT", columnDefinition = "VARCHAR2|乙型肝炎病毒表面抗原检测结果||", length = 1, nullable = true)
    private String hbsagDetectResult;

    @Column(name = "HBEAG_DETECT_RESULT", columnDefinition = "VARCHAR2|乙型肝炎病毒e抗原检测结果||", length = 1, nullable = true)
    private String hbeagDetectResult;

    @Column(name = "HBS_DETECT_RESULT", columnDefinition = "VARCHAR2|乙型肝炎病毒表面抗体检测结果||", length = 1, nullable = true)
    private String hbsDetectResult;

    @Column(name = "HBE_DETECT_RESULT", columnDefinition = "VARCHAR2|乙型肝炎病毒e抗体检测结果||", length = 1, nullable = true)
    private String hbeDetectResult;

    @Column(name = "HBCAB_DETECT_RESULT", columnDefinition = "VARCHAR2|乙型肝炎病毒核心抗体检测结果||", length = 1, nullable = true)
    private String hbcabDetectResult;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "SERUM_GPT_VALUE", columnDefinition = "NUMBER|血清谷丙转氨酶值(U/L)||", length = 5,precision = 2, nullable = true)
    private BigDecimal serumGptValue;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "SERUM_AST_VALUE", columnDefinition = "NUMBER|血清谷草转氨酶值(U/L)||", length = 5,precision = 2, nullable = true)
    private BigDecimal serumAstValue;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "ALBUMIN_CONCENTRATION", columnDefinition = "NUMBER|白蛋白浓度(g/L)||", length = 5,precision = 2, nullable = true)
    private BigDecimal albuminConcentration;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "TOTAL_BILIRUBIN", columnDefinition = "NUMBER|总胆红素(umol/L)||", scale = 4, precision = 1, nullable = true)
    private BigDecimal totalBilirubin;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "CONJUGATED_BILIRUBIN", columnDefinition = "VARCHAR2|结合胆红素值(μmol/L)||", length = 10, nullable = true)
    private String conjugatedBilirubin;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "CREATININE", columnDefinition = "NUMBER|血清肌酐值(umol/L)||", scale = 4, precision = 1, nullable = true)
    private BigDecimal creatinine;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "BLOOD_UREA_NITROGEN_VALUE", columnDefinition = "NUMBER|血尿素氮检测值(mmol/L)||", scale = 4, precision = 1, nullable = true)
    private BigDecimal bloodUreaNitrogenValue;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "POTASSIUM_CONCENTRATION", columnDefinition = "NUMBER|血钾浓度(mmol/L)||", scale = 4, precision = 1, nullable = true)
    private BigDecimal potassiumConcentration;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "SODIUM_CONCENTRATION", columnDefinition = "NUMBER|血钠浓度(mmol/L)||", length = 4, nullable = true)
    private Integer sodiumConcentration;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "TC", columnDefinition = "NUMBER|总胆固醇(mmol/L)||", scale = 5, precision = 2, nullable = true)
    private BigDecimal tc;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "TRIGLYCERIDE_VALUE", columnDefinition = "NUMBER|甘油三酯值(mmol/L)||", scale = 3, precision = 1, nullable = true)
    private BigDecimal triglycerideValue;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "LDLC_DETECT_VALUE", columnDefinition = "NUMBER|血清低密度脂蛋白胆固醇检测值(mmol/L)||", scale = 5, precision = 2, nullable = true)
    private BigDecimal ldlcDetectValue;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "HDLC_DETECT_VALUE", columnDefinition = "NUMBER|血清高密度脂蛋自胆固醇检测值(mmol/L)||", scale = 5, precision = 2, nullable = true)
    private BigDecimal hdlcDetectValue;

    @Column(name = "CEA_CONCENTRATION", columnDefinition = "NUMBER|癌胚抗原浓度值(ug/L)||", scale = 4, precision = 1, nullable = true)
    private BigDecimal ceaConcentration;

    @DisplayField(star = StarType.THREE)
    @Column(name = "CHEST_X_ANOMALYF_FLAG", columnDefinition = "VARCHAR2|胸部X线检查异常标志||", length = 1, nullable = true)
    private String chestXAnomalyfFlag;

    @Column(name = "CHEST_X_ANOMALYF_DESC", columnDefinition = "VARCHAR2|胸部X线检查异常描述||", length = 800, nullable = true)
    private String chestXAnomalyfDesc;

    /*第三版规范修改：由“B超”修改为“腹部B超+其他” modify by yejianfei 20180411*/
    @DisplayField(star = StarType.THREE)
    @Column(name = "BMODE_ANOMALYF_FLAG", columnDefinition = "VARCHAR2|B超腹部B超标志||", length = 1, nullable = true)
    private String bmodeAnomalyfFlag;

    @Column(name = "BMODE_ANOMALYF_DESC", columnDefinition = "VARCHAR2|B超腹部B超描述||", length = 1000, nullable = true)
    private String bmodeAnomalyfDesc;

    @DisplayField(star = StarType.THREE)
    @Column(name = "BMODE_OTHER_ANOMALYF_FLAG", columnDefinition = "VARCHAR2|B超其他标志||", length = 1, nullable = true)
    private String bmodeOtherAnomalyfFlag;

    @Column(name = "BMODE_OTHER_ANOMALYF_DESC", columnDefinition = "VARCHAR2|B超其他描述||", length = 1000, nullable = true)
    private String bmodeOtherAnomalyfDesc;
    /*第三版规范修改：由“B超”修改为“腹部B超+其他” modify by yejianfei 20180411*/



    @Column(name = "BMODE_LIVER_ANOMALYF_FLAG", columnDefinition = "VARCHAR2|B超检查(肝)结果异常标识||", length = 1, nullable = true)
    private String bmodeLiverAnomalyfFlag;

    @Column(name = "BMODE_BILE_ANOMALYF_FLAG", columnDefinition = "VARCHAR2|B超检查(胆)结果异常标识||", length = 1, nullable = true)
    private String bmodeBileAnomalyfFlag;

    @Column(name = "BMODE_PANCREAS_ANOMALYF_FLAG", columnDefinition = "VARCHAR2|B超检查(胰)结果异常标识||", length = 1, nullable = true)
    private String bmodePancreasAnomalyfFlag;

    @Column(name = "BMODE_KIDNEY_ANOMALYF_FLAG", columnDefinition = "VARCHAR2|B超检查(肾)结果异常标识||", length = 1, nullable = true)
    private String bmodeKidneyAnomalyfFlag;

    @Column(name = "BMODE_SPLEEN_ANOMALYF_FLAG", columnDefinition = "VARCHAR2|B超检查(脾)结果异常标识||", length = 1, nullable = true)
    private String bmodeSpleenAnomalyfFlag;

    @Column(name = "CERVICAL_SMEAR_ANOMALYF_FLAG", columnDefinition = "CHAR|宫颈涂片异常标志||", length = 1, nullable = true)
    private String cervicalSmearAnomalyfFlag;

    @Column(name = "CERVICAL_SMEAR_ANOMALYF_DESC", columnDefinition = "VARCHAR2|宫颈涂片异常描述||", length = 100, nullable = true)
    private String cervicalSmearAnomalyfDesc;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "OTHER_AUXILIARY_EXAMINATION", columnDefinition = "VARCHAR2|其他辅助检查||", length = 100, nullable = true)
    private String otherAuxiliaryExamination;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "TCM_PEACEFUL_QUALITY", columnDefinition = "VARCHAR2|平和质||", length = 1, nullable = true)
    private String tcmPeacefulQuality;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "TCM_QI_QUALITY", columnDefinition = "VARCHAR2|气虚质||", length = 1, nullable = true)
    private String tcmQiQuality;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "TCM_YANG_QUALITY", columnDefinition = "VARCHAR2|阳虚质||", length = 1, nullable = true)
    private String tcmYangQuality;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "TCM_YIN_DEFICIENCY", columnDefinition = "VARCHAR2|阴虚质||", length = 1, nullable = true)
    private String tcmYinDeficiency;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "TCM_PHLEGM_WETNESS", columnDefinition = "VARCHAR2|痰湿质||", length = 1, nullable = true)
    private String tcmPhlegmWetness;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "TCM_HEAT_MEDIUM", columnDefinition = "VARCHAR2|湿热质||", length = 1, nullable = true)
    private String tcmHeatMedium;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "TCM_BLOOD_QUALITY", columnDefinition = "VARCHAR2|血瘀质||", length = 1, nullable = true)
    private String tcmBloodQuality;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "TCM_QI_STAGNATION", columnDefinition = "VARCHAR2|气郁质||", length = 1, nullable = true)
    private String tcmQiStagnation;

    @RecordTrace
    @DisplayField(star = StarType.THREE)
    @Column(name = "TCM_SPECIAL_QUALITY", columnDefinition = "VARCHAR2|特秉质||", length = 1, nullable = true)
    private String tcmSpecialQuality;

    @DisplayField(star = StarType.THREE)
    @Column(name = "CVASCULAR_FLAG", columnDefinition = "VARCHAR2|脑血管疾病标志||", length = 1, nullable = true)
    private String cvascularFlag;

    @Column(name = "CVASCULAR_HEMORRHAGE_STROKE", columnDefinition = "VARCHAR2|脑血管缺血性卒中||", length = 1, nullable = true)
    private String cvascularHemorrhageStroke;

    @Column(name = "CVASCULAR_HEMORRHAGE", columnDefinition = "VARCHAR2|脑血管脑出血||", length = 1, nullable = true)
    private String cvascularHemorrhage;

    @Column(name = "CVASCULAR_SAH", columnDefinition = "VARCHAR2|脑血管蛛网膜下腔出血||", length = 1, nullable = true)
    private String cvascularSah;

    @Column(name = "COVASCULAR_TRANSIENT_ISCHEMIC", columnDefinition = "VARCHAR2|脑血管短暂性脑缺血||", length = 1, nullable = true)
    private String covascularTransientIschemic;

    @Column(name = "COVASCULAR_OTHER", columnDefinition = "VARCHAR2|脑血管疾病其他||", length = 1, nullable = true)
    private String covascularOther;

    @Column(name = "CVASCULAR_OTHER_DESC", columnDefinition = "VARCHAR2|脑血管疾病其他描述||", length = 100, nullable = true)
    private String cvascularOtherDesc;

    @DisplayField(star = StarType.THREE)
    @Column(name = "KIDNEY_DISEASE_FLAG", columnDefinition = "VARCHAR2|肾脏疾病标志||", length = 1, nullable = true)
    private String kidneyDiseaseFlag;

    @Column(name = "KIDNEY_DIABETIC_NEPHROPATHY", columnDefinition = "VARCHAR2|肾脏糖尿病肾病||", length = 1, nullable = true)
    private String kidneyDiabeticNephropathy;

    @Column(name = "KIDNEY_RENAL_FAILURE", columnDefinition = "VARCHAR2|肾脏肾功能衰竭||", length = 1, nullable = true)
    private String kidneyRenalFailure;

    @Column(name = "KIDNEY_ACUTE_NEPHRITIS", columnDefinition = "VARCHAR2|肾脏急性肾炎||", length = 1, nullable = true)
    private String kidneyAcuteNephritis;

    @Column(name = "KIDNEY_CHRONIC_NEPHRITIS", columnDefinition = "VARCHAR2|肾脏慢性肾炎||", length = 1, nullable = true)
    private String kidneyChronicNephritis;

    @Column(name = "KIDNEY_OTHER", columnDefinition = "VARCHAR2|肾脏疾病其他||", length = 1, nullable = true)
    private String kidneyOther;

    @Column(name = "KIDNEY_OTHER_DESC", columnDefinition = "VARCHAR2|肾脏疾病其他描述||", length = 100, nullable = true)
    private String kidneyOtherDesc;

    @DisplayField(star = StarType.THREE)
    @Column(name = "HEART_DISEASE_FLAG", columnDefinition = "VARCHAR2|心脏疾病标志||", length = 1, nullable = true)
    private String heartDiseaseFlag;

    @Column(name = "HEART_MIOCARDIAL_INFARCTION", columnDefinition = "VARCHAR2|心脏心肌梗死||", length = 1, nullable = true)
    private String heartMiocardialInfarction;

    @Column(name = "HEART_ANGINA_PECTORIS", columnDefinition = "VARCHAR2|心脏心绞痛||", length = 1, nullable = true)
    private String heartAnginaPectoris;

    @Column(name = "HEART_CORONARY", columnDefinition = "VARCHAR2|心脏冠状动脉血运重建||", length = 1, nullable = true)
    private String heartCoronary;

    @Column(name = "HEART_CONGESTIVE_HEART", columnDefinition = "VARCHAR2|心脏充血性心力||", length = 1, nullable = true)
    private String heartCongestiveHeart;

    @Column(name = "HEART_PRECORDIAL_PAIN", columnDefinition = "VARCHAR2|心脏心前区疼痛||", length = 1, nullable = true)
    private String heartPrecordialPain;

    @Column(name = "HEART_OTHER", columnDefinition = "VARCHAR2|心脏疾病其他||", length = 1, nullable = true)
    private String heartOther;

    @Column(name = "HEART_OTHER_DESC", columnDefinition = "VARCHAR2|心脏疾病其他描述||", length = 100, nullable = true)
    private String heartOtherDesc;

    @DisplayField(star = StarType.THREE)
    @Column(name = "ARTERY_DISEASE_FLAG", columnDefinition = "VARCHAR2|血管疾病标志||", length = 1, nullable = true)
    private String arteryDiseaseFlag;

    @Column(name = "ARTERY_DISSECTING_ANEURYSM", columnDefinition = "VARCHAR2|血管夹层动脉瘤||", length = 1, nullable = true)
    private String arteryDissectingAneurysm;

    @Column(name = "ARTERY_PAOD", columnDefinition = "VARCHAR2|血管动脉闭塞性疾病||", length = 1, nullable = true)
    private String arteryPaod;

    @Column(name = "ARTERY_OTHER", columnDefinition = "VARCHAR2|血管疾病其他||", length = 1, nullable = true)
    private String arteryOther;

    @Column(name = "ARTERY_OTHER_DESC", columnDefinition = "VARCHAR2|血管疾病其他描述||", length = 100, nullable = true)
    private String arteryOtherDesc;

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

    @DisplayField(star = StarType.THREE)
    @Column(name = "EYE_DISEASES_FLAG", columnDefinition = "VARCHAR2|眼部疾病标志||", length = 1, nullable = true)
    private String eyeDiseasesFlag;

    @Column(name = "EYE_RETINAL_OOZING", columnDefinition = "VARCHAR2|眼部视网膜出血或渗出||", length = 1, nullable = true)
    private String eyeRetinalOozing;

    @Column(name = "EYE_OPTIC_PAPILLA", columnDefinition = "VARCHAR2|眼部视乳头水肿||", length = 1, nullable = true)
    private String eyeOpticPapilla;

    @Column(name = "EYE_CATARACT", columnDefinition = "VARCHAR2|眼部白内障||", length = 1, nullable = true)
    private String eyeCataract;

    @Column(name = "EYE_OTHER", columnDefinition = "VARCHAR2|眼部疾病其他||", length = 1, nullable = true)
    private String eyeOther;

    @Column(name = "EYE_OTHER_DESC", columnDefinition = "VARCHAR2|眼部疾病其他描述||", length = 100, nullable = true)
    private String eyeOtherDesc;

    @DisplayField(star = StarType.THREE)
    @Column(name = "NERVOUS_DISEASES_FLAG", columnDefinition = "VARCHAR2|神经系统疾病标志||", length = 1, nullable = true)
    private String nervousDiseasesFlag;

    @Column(name = "NERVOUS_DISEASES_DESC", columnDefinition = "VARCHAR2|神经系统疾病描述||", length = 100, nullable = true)
    private String nervousDiseasesDesc;

    @Column(name = "PHYSIOLOGY_ANOMALY_FLAG", columnDefinition = "VARCHAR2|生理反射异常标志||", length = 1, nullable = true)
    private String physiologyAnomalyFlag;

    @Column(name = "PHYSIOLOGY_ANOMALYF_DESC", columnDefinition = "VARCHAR2|生理反射异常描述||", length = 100, nullable = true)
    private String physiologyAnomalyfDesc;

    @Column(name = "PATHOLOGY_CHECK_FLAG", columnDefinition = "VARCHAR2|病理反射检查结果标志||", length = 1, nullable = true)
    private String pathologyCheckFlag;

    @Column(name = "PATHOLOGY_CHECK_DESC", columnDefinition = "VARCHAR2|病理反射检查结果描述||", length = 100, nullable = true)
    private String pathologyCheckDesc;

    @DisplayField(star = StarType.THREE)
    @Column(name = "HEALTH_OTHER", columnDefinition = "VARCHAR2|现存主要健康问题其他系统疾病标志||", length = 1, nullable = true)
    private String healthOther;

    @Column(name = "HEALTH_OTHER_DESC", columnDefinition = "VARCHAR2|现存主要健康问题其他系统疾病描述||", length = 100, nullable = true)
    private String healthOtherDesc;

    @DisplayField(star = StarType.THREE)
    @Column(name = "HEALTH_EVALUATE_ANOMALY_FLAG", columnDefinition = "CHAR|健康评价异常标志||", length = 1, nullable = true)
    private String healthEvaluateAnomalyFlag;

    @Column(name = "GUIDE_INTO_CHRONIC_DISEASE", columnDefinition = "CHAR|健康指导纳入慢性病患者健康管理||", length = 1, nullable = true)
    private String guideIntoChronicDisease;

    @Column(name = "GUIDE_REGULAR_FOLLOWUP", columnDefinition = "CHAR|健康指导定期随访||", length = 1, nullable = true)
    private String guideRegularFollowup;

    @Column(name = "GUIDE_SUGGESTION_REVIEW", columnDefinition = "CHAR|健康指导建议复查||", length = 1, nullable = true)
    private String guideSuggestionReview;

    @Column(name = "GUIDE_SUGGESTION_REFERRAL", columnDefinition = "CHAR|健康指导建议转诊||", length = 1, nullable = true)
    private String guideSuggestionReferral;

    @Column(name = "PREVENTION_OSTEOPOROSIS", columnDefinition = "CHAR|骨质疏松预防||", length = 1, nullable = true)
    private String preventionOsteoporosis;

    @Column(name = "PREVENTION_TUMBLE", columnDefinition = "CHAR|防跌倒措施||", length = 1, nullable = true)
    private String preventionTumble;

    @Column(name = "PREVENTION_INJURY", columnDefinition = "CHAR|意外伤害预防||", length = 1, nullable = true)
    private String preventionInjury;

    @Column(name = "included_six_management", columnDefinition = "CHAR|纳入0-6岁儿童管理||", length = 1, nullable = true)
    private String includedSixManagement;
    
    @Column(name = "maternal_management", columnDefinition = "CHAR|纳入孕产妇管理项目||", length = 1, nullable = true)
    private String maternalManagement;
    
    @Column(name = "RISK_QUIT_SMOKING", columnDefinition = "CHAR|危险因素戒烟||", length = 1, nullable = true)
    private String riskQuitSmoking;

    @Column(name = "RISK_HEALTH_DRINK", columnDefinition = "CHAR|危险因素健康饮酒||", length = 1, nullable = true)
    private String riskHealthDrink;

    @Column(name = "RISK_DIET", columnDefinition = "CHAR|危险因素饮食||", length = 1, nullable = true)
    private String riskDiet;

    @Column(name = "RISK_EXERCISE", columnDefinition = "CHAR|危险因素锻炼||", length = 1, nullable = true)
    private String riskExercise;

    @Column(name = "RISK_WEIGHT_REDUCTION", columnDefinition = "CHAR|危险因素减体重||", length = 1, nullable = true)
    private String riskWeightReduction;

    @Column(name = "RISK_WEIGHT_TARGET", columnDefinition = "VARCHAR2|危险因素减体重目标描述||", length = 7, nullable = true)
    private String riskWeightTarget;

    @Column(name = "GUIDE_VACCINATION", columnDefinition = "CHAR|健康指导接种疫苗||", length = 1, nullable = true)
    private String guideVaccination;

    @Column(name = "GUIDE_VACCINATION_DESC", columnDefinition = "VARCHAR2|健康指导接种疫苗描述||", length = 100, nullable = true)
    private String guideVaccinationDesc;

    @Column(name = "RISK_OTHER", columnDefinition = "CHAR|危险因素其他||", length = 1, nullable = true)
    private String riskOther;

    @Column(name = "RISK_OTHER_DESC", columnDefinition = "VARCHAR2|危险因素其他描述||", length = 100, nullable = true)
    private String riskOtherDesc;

    @Column(name = "EXAMINATION_RESULT", columnDefinition = "VARCHAR2|体检结果||", length = 400, nullable = true)
    private String examinationResult;

    @Column(name = "EXAMINATION_ORGAN_CODE", columnDefinition = "VARCHAR2|体检机构编码||", length = 15, nullable = true)
    private String examinationOrganCode;

    @Column(name = "EXAMINATION_ORGAN_NAME", columnDefinition = "VARCHAR2|体检机构名称||", length = 70, nullable = true)
    private String examinationOrganName;

    @Column(name = "MANA_DOCTOR_IDCARD", columnDefinition = "VARCHAR2|责任医师身份证号||", length = 18, nullable = true)
    private String manaDoctorIdcard;

    @Column(name = "INPUT_IDCARD", columnDefinition = "VARCHAR2|建档人身份证号||", length = 18, nullable = true)
    private String inputIdcard;

    @Column(name = "INPUT_NAME", columnDefinition = "VARCHAR2|建档人姓名||", length = 50, nullable = true)
    private String inputName;

    @Column(name = "INPUT_DATE", columnDefinition = "DATE|建档日期和时间||", nullable = true)
    private Date inputDate;
    
	@Column(name = "PHYSICAL_EXAM_COST", columnDefinition = "NUMBER|体检费用||", scale = 8, precision = 2, nullable = true)
	private BigDecimal physicalExamCost;

	@Column(name = "HEALTH_EVALUATE_RESULT", columnDefinition = "VARCHAR2|健康评价结果代码||", length = 1, nullable = true)
	private String healthEvaluateResult;

	@Column(name = "HEALTH_EVALUATE_ANOMALY_DESC", columnDefinition = "VARCHAR2|健康评价异常描述||", length = 100, nullable = true)
	private String healthEvaluateAnomalyDesc;

	@Column(name = "HEALTH_GUIDANCE", columnDefinition = "VARCHAR2|健康指导代码||", length = 10, nullable = true)
	private String healthGuidance;

	@Column(name = "SUGGESTION", columnDefinition = "VARCHAR2|其他医生建议||", length = 100, nullable = true)
	private String suggestion;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

	@Column(name = "TCM_CONCLUSION", columnDefinition = "VARCHAR2|体质辨识结论|200|",length=200, nullable = true)
	private String tcmConclusion;
	
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";

    @Column(name = "HEALTH_EVALUATE_CHECK", columnDefinition = "VARCHAR2|健康评价异常(另外13项异常)||", length = 50, nullable = true)
    private String healthEvaluateCheck;

    @Column(name = "HEALTH_EVALUATE_OTHER_DESC", columnDefinition = "VARCHAR2|健康评价异常(其他异常)||", length = 100, nullable = true)
    private String healthEvaluateOtherDesc;
	
	@Column(name = "IDENTIFICATION_ID", columnDefinition = "NUMBER|辨识表ID|11|", length = 11, nullable = false)
	private Long identificationId;
	
	private Long oldIdentificationId;
	
	@Transient
	private Integer decayedToothNumber;
	
	@Transient
	private Integer missingToothNumber;
	
	@Transient
	private Integer dentureToothNumber;
	
	@Transient
	private String  idCardNo;
	
	@Transient
	private String sourceId;
	
	@Transient
	private String authorOrganization;
	
	@Transient
	private String inputDateDesc;
	
	@Transient
	private String examinationDateDesc;
	
	@Transient
	private String lymphNodeCheckResultDesc;
	
	@Transient
	private String dreCheckResultTypeDesc;
	
	@Transient
	private String scleraCheckResultDesc;
	
	@Transient
	private String lipAppearanceCehckResultDesc;
	
	@Transient
	private String bmodeLiverAnomalyfFlagDesc;
	
	@Transient
	private String bmodeBileAnomalyfFlagDesc;
	
    @Transient
    private String bmodePancreasAnomalyfFlagDesc;
    
    @Transient
    private String bmodeKidneyAnomalyfFlagDesc;
    
    @Transient
    private String bmodeSpleenAnomalyfFlagDesc;
    
    @Transient
    private String hearDetectResultDesc;
    
    @Transient
    private String emotionScreenResultDesc;
    
    @Transient
    private String cognitionScreenResultDesc;
    
    @Transient
    private String lifeAbilitySelfAssessmentDesc;
    
    @Transient
    private String motorFuncStateDesc;
    
    @Transient
    private String hbsDetectResultDesc;
    
    @Transient
    private String hbsagDetectResultDesc;
    
    @Transient
    private String physiologyAnomalyFlagDesc;
    
    @Transient
    private String pathologyCheckFlagDesc;
    
    @Transient
    private String colorVisionDesc;
    
    @Transient
    private String eardrumCheckResultDesc;
    
    @Transient
    private String nasalSeptumCheckResultDesc;
    
    @Transient
    private String nasalMucosaCheckResultDesc;
    
    @Transient
    private String throatTonsilCheckResultDesc;
    
    @Transient
    private String throatCheckResultDesc;
    
    @Transient
    private String periodontalCehckResultDesc;
    
    @Transient
    private String thyroidCheckResultDesc;
    
    @Transient
    private String prostateCheckResultDesc;
    
    @Transient
    private String legsEdemaCheckResultDesc;
    
    @Transient
    private String cardioverterDesc;
    
    @Transient
    private String pharynxCheckResultDesc;
    
    @Transient
    private String arteriopalmusDesc;
    
    @Transient
    private String healthSelfAssessmentDesc;
    
    @Transient
    private String urineProQualitativeResultDesc;
    
    @Transient
    private String eryDetectionResultDesc;
    
    @Transient
    private String urineSugQualitativeResultDesc;
    
    @Transient
    private String ketQualitativeDetectionDesc;
    
    @Transient
    private Long RecordId;
    
    public Long getRecordId() {
		return RecordId;
	}

	public void setRecordId(Long recordId) {
		RecordId = recordId;
	}

	public String getEmotionScreenResultStr() {
		return emotionScreenResultStr;
	}

	public void setEmotionScreenResultStr(String emotionScreenResultStr) {
		this.emotionScreenResultStr = emotionScreenResultStr;
	}

	public String getLegsEdemaCheckResultDesc() {
		return legsEdemaCheckResultDesc;
	}

	public void setLegsEdemaCheckResultDesc(String legsEdemaCheckResultDesc) {
		this.legsEdemaCheckResultDesc = legsEdemaCheckResultDesc;
	}

	public String getCardioverterDesc() {
		return cardioverterDesc;
	}

	public void setCardioverterDesc(String cardioverterDesc) {
		this.cardioverterDesc = cardioverterDesc;
	}

	public String getPharynxCheckResultDesc() {
		return pharynxCheckResultDesc;
	}

	public void setPharynxCheckResultDesc(String pharynxCheckResultDesc) {
		this.pharynxCheckResultDesc = pharynxCheckResultDesc;
	}

	public String getArteriopalmusDesc() {
		return arteriopalmusDesc;
	}

	public void setArteriopalmusDesc(String arteriopalmusDesc) {
		this.arteriopalmusDesc = arteriopalmusDesc;
	}

	public String getHealthSelfAssessmentDesc() {
		return healthSelfAssessmentDesc;
	}

	public void setHealthSelfAssessmentDesc(String healthSelfAssessmentDesc) {
		this.healthSelfAssessmentDesc = healthSelfAssessmentDesc;
	}

	public String getUrineProQualitativeResultDesc() {
		return urineProQualitativeResultDesc;
	}

	public void setUrineProQualitativeResultDesc(
			String urineProQualitativeResultDesc) {
		this.urineProQualitativeResultDesc = urineProQualitativeResultDesc;
	}

	public String getEryDetectionResultDesc() {
		return eryDetectionResultDesc;
	}

	public void setEryDetectionResultDesc(String eryDetectionResultDesc) {
		this.eryDetectionResultDesc = eryDetectionResultDesc;
	}

	public String getUrineSugQualitativeResultDesc() {
		return urineSugQualitativeResultDesc;
	}

	public void setUrineSugQualitativeResultDesc(
			String urineSugQualitativeResultDesc) {
		this.urineSugQualitativeResultDesc = urineSugQualitativeResultDesc;
	}

	public String getKetQualitativeDetectionDesc() {
		return ketQualitativeDetectionDesc;
	}

	public void setKetQualitativeDetectionDesc(String ketQualitativeDetectionDesc) {
		this.ketQualitativeDetectionDesc = ketQualitativeDetectionDesc;
	}

	public String getProstateCheckResultDesc() {
		return prostateCheckResultDesc;
	}

	public void setProstateCheckResultDesc(String prostateCheckResultDesc) {
		this.prostateCheckResultDesc = prostateCheckResultDesc;
	}

	public String getThyroidCheckResultDesc() {
		return thyroidCheckResultDesc;
	}

	public void setThyroidCheckResultDesc(String thyroidCheckResultDesc) {
		this.thyroidCheckResultDesc = thyroidCheckResultDesc;
	}

	public String getPeriodontalCehckResultDesc() {
		return periodontalCehckResultDesc;
	}

	public void setPeriodontalCehckResultDesc(String periodontalCehckResultDesc) {
		this.periodontalCehckResultDesc = periodontalCehckResultDesc;
	}

	public String getThroatTonsilCheckResultDesc() {
		return throatTonsilCheckResultDesc;
	}

	public void setThroatTonsilCheckResultDesc(String throatTonsilCheckResultDesc) {
		this.throatTonsilCheckResultDesc = throatTonsilCheckResultDesc;
	}

	public String getThroatCheckResultDesc() {
		return throatCheckResultDesc;
	}

	public void setThroatCheckResultDesc(String throatCheckResultDesc) {
		this.throatCheckResultDesc = throatCheckResultDesc;
	}

	public String getNasalSeptumCheckResultDesc() {
		return nasalSeptumCheckResultDesc;
	}

	public void setNasalSeptumCheckResultDesc(String nasalSeptumCheckResultDesc) {
		this.nasalSeptumCheckResultDesc = nasalSeptumCheckResultDesc;
	}

	public String getNasalMucosaCheckResultDesc() {
		return nasalMucosaCheckResultDesc;
	}

	public void setNasalMucosaCheckResultDesc(String nasalMucosaCheckResultDesc) {
		this.nasalMucosaCheckResultDesc = nasalMucosaCheckResultDesc;
	}

	public String getEardrumCheckResultDesc() {
		return eardrumCheckResultDesc;
	}

	public void setEardrumCheckResultDesc(String eardrumCheckResultDesc) {
		this.eardrumCheckResultDesc = eardrumCheckResultDesc;
	}

	public String getColorVisionDesc() {
		return colorVisionDesc;
	}

	public void setColorVisionDesc(String colorVisionDesc) {
		this.colorVisionDesc = colorVisionDesc;
	}

	public String getPathologyCheckFlagDesc() {
		return pathologyCheckFlagDesc;
	}

	public void setPathologyCheckFlagDesc(String pathologyCheckFlagDesc) {
		this.pathologyCheckFlagDesc = pathologyCheckFlagDesc;
	}

	public String getPhysiologyAnomalyFlagDesc() {
		return physiologyAnomalyFlagDesc;
	}

	public void setPhysiologyAnomalyFlagDesc(String physiologyAnomalyFlagDesc) {
		this.physiologyAnomalyFlagDesc = physiologyAnomalyFlagDesc;
	}

	public String getHbsagDetectResultDesc() {
		return hbsagDetectResultDesc;
	}

	public void setHbsagDetectResultDesc(String hbsagDetectResultDesc) {
		this.hbsagDetectResultDesc = hbsagDetectResultDesc;
	}

	public String getHbsDetectResultDesc() {
		return hbsDetectResultDesc;
	}

	public void setHbsDetectResultDesc(String hbsDetectResultDesc) {
		this.hbsDetectResultDesc = hbsDetectResultDesc;
	}

	public String getMotorFuncStateDesc() {
		return motorFuncStateDesc;
	}

	public void setMotorFuncStateDesc(String motorFuncStateDesc) {
		this.motorFuncStateDesc = motorFuncStateDesc;
	}

	public String getLifeAbilitySelfAssessmentDesc() {
		return lifeAbilitySelfAssessmentDesc;
	}

	public void setLifeAbilitySelfAssessmentDesc(
			String lifeAbilitySelfAssessmentDesc) {
		this.lifeAbilitySelfAssessmentDesc = lifeAbilitySelfAssessmentDesc;
	}

	public String getCognitionScreenResultDesc() {
		return cognitionScreenResultDesc;
	}

	public void setCognitionScreenResultDesc(String cognitionScreenResultDesc) {
		this.cognitionScreenResultDesc = cognitionScreenResultDesc;
	}

	public String getEmotionScreenResultDesc() {
		return emotionScreenResultDesc;
	}

	public void setEmotionScreenResultDesc(String emotionScreenResultDesc) {
		this.emotionScreenResultDesc = emotionScreenResultDesc;
	}

	public String getHearDetectResultDesc() {
		return hearDetectResultDesc;
	}

	public void setHearDetectResultDesc(String hearDetectResultDesc) {
		this.hearDetectResultDesc = hearDetectResultDesc;
	}

	public String getBmodeSpleenAnomalyfFlagDesc() {
		return bmodeSpleenAnomalyfFlagDesc;
	}

	public void setBmodeSpleenAnomalyfFlagDesc(String bmodeSpleenAnomalyfFlagDesc) {
		this.bmodeSpleenAnomalyfFlagDesc = bmodeSpleenAnomalyfFlagDesc;
	}

	public String getBmodeKidneyAnomalyfFlagDesc() {
		return bmodeKidneyAnomalyfFlagDesc;
	}

	public void setBmodeKidneyAnomalyfFlagDesc(String bmodeKidneyAnomalyfFlagDesc) {
		this.bmodeKidneyAnomalyfFlagDesc = bmodeKidneyAnomalyfFlagDesc;
	}

	public String getBmodePancreasAnomalyfFlagDesc() {
		return bmodePancreasAnomalyfFlagDesc;
	}

	public void setBmodePancreasAnomalyfFlagDesc(
			String bmodePancreasAnomalyfFlagDesc) {
		this.bmodePancreasAnomalyfFlagDesc = bmodePancreasAnomalyfFlagDesc;
	}

	public String getBmodeBileAnomalyfFlagDesc() {
		return bmodeBileAnomalyfFlagDesc;
	}

	public void setBmodeBileAnomalyfFlagDesc(String bmodeBileAnomalyfFlagDesc) {
		this.bmodeBileAnomalyfFlagDesc = bmodeBileAnomalyfFlagDesc;
	}

	public String getBmodeLiverAnomalyfFlagDesc() {
		return bmodeLiverAnomalyfFlagDesc;
	}

	public void setBmodeLiverAnomalyfFlagDesc(String bmodeLiverAnomalyfFlagDesc) {
		this.bmodeLiverAnomalyfFlagDesc = bmodeLiverAnomalyfFlagDesc;
	}

	public String getLipAppearanceCehckResultDesc() {
		return lipAppearanceCehckResultDesc;
	}

	public void setLipAppearanceCehckResultDesc(String lipAppearanceCehckResultDesc) {
		this.lipAppearanceCehckResultDesc = lipAppearanceCehckResultDesc;
	}

	public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getPhysicalExamCode() {
        return this.physicalExamCode;
    }

    public void setPhysicalExamCode(String physicalExamCode) {
        this.physicalExamCode = physicalExamCode;
    }

    public String getHealthFileNo() {
        return this.healthFileNo;
    }

    public void setHealthFileNo(String healthFileNo) {
        this.healthFileNo = healthFileNo;
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

    
	public String getAge() {
		return age;
	}

	
	public void setAge(String age) {
		this.age = age;
	}

	public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMarriage() {
        return this.marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getSymptomFlag() {
        return this.symptomFlag;
    }

    public void setSymptomFlag(String symptomFlag) {
        this.symptomFlag = symptomFlag;
    }

    public String getSymptomHeadache() {
        return this.symptomHeadache;
    }

    public void setSymptomHeadache(String symptomHeadache) {
        this.symptomHeadache = symptomHeadache;
    }

    public String getSymptomDizzy() {
        return this.symptomDizzy;
    }

    public void setSymptomDizzy(String symptomDizzy) {
        this.symptomDizzy = symptomDizzy;
    }

    public String getSymptomPalpitations() {
        return this.symptomPalpitations;
    }

    public void setSymptomPalpitations(String symptomPalpitations) {
        this.symptomPalpitations = symptomPalpitations;
    }

    public String getSymptomChestTightness() {
        return this.symptomChestTightness;
    }

    public void setSymptomChestTightness(String symptomChestTightness) {
        this.symptomChestTightness = symptomChestTightness;
    }

    public String getSymptomChestPain() {
        return this.symptomChestPain;
    }

    public void setSymptomChestPain(String symptomChestPain) {
        this.symptomChestPain = symptomChestPain;
    }

    public String getSymptomChronicCough() {
        return this.symptomChronicCough;
    }

    public void setSymptomChronicCough(String symptomChronicCough) {
        this.symptomChronicCough = symptomChronicCough;
    }

    public String getSymptomCough() {
        return this.symptomCough;
    }

    public void setSymptomCough(String symptomCough) {
        this.symptomCough = symptomCough;
    }

    public String getSymptomDyspnea() {
        return this.symptomDyspnea;
    }

    public void setSymptomDyspnea(String symptomDyspnea) {
        this.symptomDyspnea = symptomDyspnea;
    }

    public String getSymptomPolydipsia() {
        return this.symptomPolydipsia;
    }

    public void setSymptomPolydipsia(String symptomPolydipsia) {
        this.symptomPolydipsia = symptomPolydipsia;
    }

    public String getSymptomPolyuria() {
        return this.symptomPolyuria;
    }

    public void setSymptomPolyuria(String symptomPolyuria) {
        this.symptomPolyuria = symptomPolyuria;
    }

    public String getSymptomWeightLoss() {
        return this.symptomWeightLoss;
    }

    public void setSymptomWeightLoss(String symptomWeightLoss) {
        this.symptomWeightLoss = symptomWeightLoss;
    }

    public String getSymptomFatigue() {
        return this.symptomFatigue;
    }

    public void setSymptomFatigue(String symptomFatigue) {
        this.symptomFatigue = symptomFatigue;
    }

    public String getSymptomJointPain() {
        return this.symptomJointPain;
    }

    public void setSymptomJointPain(String symptomJointPain) {
        this.symptomJointPain = symptomJointPain;
    }

    public String getSymptomBlurredVision() {
        return this.symptomBlurredVision;
    }

    public void setSymptomBlurredVision(String symptomBlurredVision) {
        this.symptomBlurredVision = symptomBlurredVision;
    }

    public String getSymptomNumbness() {
        return this.symptomNumbness;
    }

    public void setSymptomNumbness(String symptomNumbness) {
        this.symptomNumbness = symptomNumbness;
    }

    public String getSymptomUrgency() {
        return this.symptomUrgency;
    }

    public void setSymptomUrgency(String symptomUrgency) {
        this.symptomUrgency = symptomUrgency;
    }

    public String getSymptomDysuria() {
        return this.symptomDysuria;
    }

    public void setSymptomDysuria(String symptomDysuria) {
        this.symptomDysuria = symptomDysuria;
    }

    public String getSymptomConstipation() {
        return this.symptomConstipation;
    }

    public void setSymptomConstipation(String symptomConstipation) {
        this.symptomConstipation = symptomConstipation;
    }

    public String getSymptomDiarrhea() {
        return this.symptomDiarrhea;
    }

    public void setSymptomDiarrhea(String symptomDiarrhea) {
        this.symptomDiarrhea = symptomDiarrhea;
    }

    public String getSymptomNauseaVomiting() {
        return this.symptomNauseaVomiting;
    }

    public void setSymptomNauseaVomiting(String symptomNauseaVomiting) {
        this.symptomNauseaVomiting = symptomNauseaVomiting;
    }

    public String getSymptomVertigo() {
        return this.symptomVertigo;
    }

    public void setSymptomVertigo(String symptomVertigo) {
        this.symptomVertigo = symptomVertigo;
    }

    public String getSymptomTinnitus() {
        return this.symptomTinnitus;
    }

    public void setSymptomTinnitus(String symptomTinnitus) {
        this.symptomTinnitus = symptomTinnitus;
    }

    public String getSymptomBreastTenderness() {
        return this.symptomBreastTenderness;
    }

    public void setSymptomBreastTenderness(String symptomBreastTenderness) {
        this.symptomBreastTenderness = symptomBreastTenderness;
    }

    public String getSymptomOther() {
        return this.symptomOther;
    }

    public void setSymptomOther(String symptomOther) {
        this.symptomOther = symptomOther;
    }

    public String getSymptomOtherDesc() {
        return this.symptomOtherDesc;
    }

    public void setSymptomOtherDesc(String symptomOtherDesc) {
        this.symptomOtherDesc = symptomOtherDesc;
    }

    public BigDecimal getTemperature() {
        return this.temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public Integer getPulseRate() {
        return this.pulseRate;
    }

    public void setPulseRate(Integer pulseRate) {
        this.pulseRate = pulseRate;
    }

    public Integer getRespiratoryRate() {
        return this.respiratoryRate;
    }

    public void setRespiratoryRate(Integer respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public Integer getLeftSbp() {
        return this.leftSbp;
    }

    public void setLeftSbp(Integer leftSbp) {
        this.leftSbp = leftSbp;
    }

    public Integer getLeftDbp() {
        return this.leftDbp;
    }

    public void setLeftDbp(Integer leftDbp) {
        this.leftDbp = leftDbp;
    }

    public Integer getRightSbp() {
        return this.rightSbp;
    }

    public void setRightSbp(Integer rightSbp) {
        this.rightSbp = rightSbp;
    }

    public Integer getRightDbp() {
        return this.rightDbp;
    }

    public void setRightDbp(Integer rightDbp) {
        this.rightDbp = rightDbp;
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

    public BigDecimal getWaostline() {
        return this.waostline;
    }

    public void setWaostline(BigDecimal waostline) {
        this.waostline = waostline;
    }

    public BigDecimal getIndexOfBodyCharacteristics() {
        return this.indexOfBodyCharacteristics;
    }

    public void setIndexOfBodyCharacteristics(BigDecimal indexOfBodyCharacteristics) {
        this.indexOfBodyCharacteristics = indexOfBodyCharacteristics;
    }

    public String getHealthSelfAssessment() {
        return this.healthSelfAssessment;
    }

    public void setHealthSelfAssessment(String healthSelfAssessment) {
        this.healthSelfAssessment = healthSelfAssessment;
    }

    public String getLifeAbilitySelfAssessment() {
        return this.lifeAbilitySelfAssessment;
    }

    public void setLifeAbilitySelfAssessment(String lifeAbilitySelfAssessment) {
        this.lifeAbilitySelfAssessment = lifeAbilitySelfAssessment;
    }

    public String getCognitionScreenResult() {
        return this.cognitionScreenResult;
    }

    public void setCognitionScreenResult(String cognitionScreenResult) {
        this.cognitionScreenResult = cognitionScreenResult;
    }

    public Integer getCognitionScreenScore() {
        return this.cognitionScreenScore;
    }

    public void setCognitionScreenScore(Integer cognitionScreenScore) {
        this.cognitionScreenScore = cognitionScreenScore;
    }

    public String getEmotionScreenResult() {
        return this.emotionScreenResult;
    }

    public void setEmotionScreenResult(String emotionScreenResult) {
        this.emotionScreenResult = emotionScreenResult;
    }

    public Integer getDepressionScore() {
        return this.depressionScore;
    }

    public void setDepressionScore(Integer depressionScore) {
        this.depressionScore = depressionScore;
    }

    public String getTrainFrequencyTypeCode() {
        return this.trainFrequencyTypeCode;
    }

    public void setTrainFrequencyTypeCode(String trainFrequencyTypeCode) {
        this.trainFrequencyTypeCode = trainFrequencyTypeCode;
    }

    public Integer getTrainingMin() {
        return this.trainingMin;
    }

    public void setTrainingMin(Integer trainingMin) {
        this.trainingMin = trainingMin;
    }

    public BigDecimal getTrainingTotaltime() {
        return this.trainingTotaltime;
    }

    public void setTrainingTotaltime(BigDecimal trainingTotaltime) {
        this.trainingTotaltime = trainingTotaltime;
    }

    public String getTrainingWay() {
        return this.trainingWay;
    }

    public void setTrainingWay(String trainingWay) {
        this.trainingWay = trainingWay;
    }

    public String getDietHunsuEquilibrium() {
        return this.dietHunsuEquilibrium;
    }

    public void setDietHunsuEquilibrium(String dietHunsuEquilibrium) {
        this.dietHunsuEquilibrium = dietHunsuEquilibrium;
    }

    public String getDietMeatMain() {
        return this.dietMeatMain;
    }

    public void setDietMeatMain(String dietMeatMain) {
        this.dietMeatMain = dietMeatMain;
    }

    public String getDietVegetarian() {
        return this.dietVegetarian;
    }

    public void setDietVegetarian(String dietVegetarian) {
        this.dietVegetarian = dietVegetarian;
    }

    public String getDietHalophilic() {
        return this.dietHalophilic;
    }

    public void setDietHalophilic(String dietHalophilic) {
        this.dietHalophilic = dietHalophilic;
    }

    public String getDietAddictedOil() {
        return this.dietAddictedOil;
    }

    public void setDietAddictedOil(String dietAddictedOil) {
        this.dietAddictedOil = dietAddictedOil;
    }

    public String getDietSugarCravings() {
        return this.dietSugarCravings;
    }

    public void setDietSugarCravings(String dietSugarCravings) {
        this.dietSugarCravings = dietSugarCravings;
    }

    public String getSmodeStatusCode() {
        return this.smodeStatusCode;
    }

    public void setSmodeStatusCode(String smodeStatusCode) {
        this.smodeStatusCode = smodeStatusCode;
    }

    public Integer getDailySmoke() {
        return this.dailySmoke;
    }

    public void setDailySmoke(Integer dailySmoke) {
        this.dailySmoke = dailySmoke;
    }

    public Integer getSmokeAge() {
        return this.smokeAge;
    }

    public void setSmokeAge(Integer smokeAge) {
        this.smokeAge = smokeAge;
    }

    public Integer getQuitSmokeAge() {
        return this.quitSmokeAge;
    }

    public void setQuitSmokeAge(Integer quitSmokeAge) {
        this.quitSmokeAge = quitSmokeAge;
    }

    public String getDrinkFrequency() {
        return this.drinkFrequency;
    }

    public void setDrinkFrequency(String drinkFrequency) {
        this.drinkFrequency = drinkFrequency;
    }

    public Integer getDailyDrink() {
        return this.dailyDrink;
    }

    public void setDailyDrink(Integer dailyDrink) {
        this.dailyDrink = dailyDrink;
    }

    public String getNodrink() {
        return this.nodrink;
    }

    public void setNodrink(String nodrink) {
        this.nodrink = nodrink;
    }

    public Integer getNodrinkAge() {
        return this.nodrinkAge;
    }

    public void setNodrinkAge(Integer nodrinkAge) {
        this.nodrinkAge = nodrinkAge;
    }

    public Integer getDrinkAge() {
        return this.drinkAge;
    }

    public void setDrinkAge(Integer drinkAge) {
        this.drinkAge = drinkAge;
    }

    public String getDrunk() {
        return this.drunk;
    }

    public void setDrunk(String drunk) {
        this.drunk = drunk;
    }

    public String getDrinkSpirit() {
        return this.drinkSpirit;
    }

    public void setDrinkSpirit(String drinkSpirit) {
        this.drinkSpirit = drinkSpirit;
    }

    public String getDrinkBeer() {
        return this.drinkBeer;
    }

    public void setDrinkBeer(String drinkBeer) {
        this.drinkBeer = drinkBeer;
    }

    public String getDrinkRedWine() {
        return this.drinkRedWine;
    }

    public void setDrinkRedWine(String drinkRedWine) {
        this.drinkRedWine = drinkRedWine;
    }

    public String getDrinkYellowWine() {
        return this.drinkYellowWine;
    }

    public void setDrinkYellowWine(String drinkYellowWine) {
        this.drinkYellowWine = drinkYellowWine;
    }

    public String getDrinkOther() {
        return this.drinkOther;
    }

    public void setDrinkOther(String drinkOther) {
        this.drinkOther = drinkOther;
    }

    public String getDrinkOtherDesc() {
        return this.drinkOtherDesc;
    }

    public void setDrinkOtherDesc(String drinkOtherDesc) {
        this.drinkOtherDesc = drinkOtherDesc;
    }

    public String getOccupationExposureFlag() {
        return this.occupationExposureFlag;
    }

    public void setOccupationExposureFlag(String occupationExposureFlag) {
        this.occupationExposureFlag = occupationExposureFlag;
    }

    public String getRiskOccupationDesc() {
        return this.riskOccupationDesc;
    }

    public void setRiskOccupationDesc(String riskOccupationDesc) {
        this.riskOccupationDesc = riskOccupationDesc;
    }

    public Integer getRiskOccupationTime() {
        return this.riskOccupationTime;
    }

    public void setRiskOccupationTime(Integer riskOccupationTime) {
        this.riskOccupationTime = riskOccupationTime;
    }

    public String getDustTypeDesc() {
        return this.dustTypeDesc;
    }

    public void setDustTypeDesc(String dustTypeDesc) {
        this.dustTypeDesc = dustTypeDesc;
    }

    public String getDustProtectionFlag() {
        return this.dustProtectionFlag;
    }

    public void setDustProtectionFlag(String dustProtectionFlag) {
        this.dustProtectionFlag = dustProtectionFlag;
    }

    public String getDustProtectionDesc() {
        return this.dustProtectionDesc;
    }

    public void setDustProtectionDesc(String dustProtectionDesc) {
        this.dustProtectionDesc = dustProtectionDesc;
    }

    public String getRadiationTypeDesc() {
        return this.radiationTypeDesc;
    }

    public void setRadiationTypeDesc(String radiationTypeDesc) {
        this.radiationTypeDesc = radiationTypeDesc;
    }

    public String getRadiationProtectionFlag() {
        return this.radiationProtectionFlag;
    }

    public void setRadiationProtectionFlag(String radiationProtectionFlag) {
        this.radiationProtectionFlag = radiationProtectionFlag;
    }

    public String getRadiationProtectionDesc() {
        return this.radiationProtectionDesc;
    }

    public void setRadiationProtectionDesc(String radiationProtectionDesc) {
        this.radiationProtectionDesc = radiationProtectionDesc;
    }

    public String getPhysicsTypeDesc() {
        return this.physicsTypeDesc;
    }

    public void setPhysicsTypeDesc(String physicsTypeDesc) {
        this.physicsTypeDesc = physicsTypeDesc;
    }

    public String getPhysicsProtectionFlag() {
        return this.physicsProtectionFlag;
    }

    public void setPhysicsProtectionFlag(String physicsProtectionFlag) {
        this.physicsProtectionFlag = physicsProtectionFlag;
    }

    public String getPhysicsProtectionDesc() {
        return this.physicsProtectionDesc;
    }

    public void setPhysicsProtectionDesc(String physicsProtectionDesc) {
        this.physicsProtectionDesc = physicsProtectionDesc;
    }

    public String getChemistryTypeDesc() {
        return this.chemistryTypeDesc;
    }

    public void setChemistryTypeDesc(String chemistryTypeDesc) {
        this.chemistryTypeDesc = chemistryTypeDesc;
    }

    public String getChemistryProtectionFlag() {
        return this.chemistryProtectionFlag;
    }

    public void setChemistryProtectionFlag(String chemistryProtectionFlag) {
        this.chemistryProtectionFlag = chemistryProtectionFlag;
    }

    public String getChemistryProtectionDesc() {
        return this.chemistryProtectionDesc;
    }

    public void setChemistryProtectionDesc(String chemistryProtectionDesc) {
        this.chemistryProtectionDesc = chemistryProtectionDesc;
    }

    public String getOtherTypeDesc() {
        return this.otherTypeDesc;
    }

    public void setOtherTypeDesc(String otherTypeDesc) {
        this.otherTypeDesc = otherTypeDesc;
    }

    public String getOtherProtectionFlag() {
        return this.otherProtectionFlag;
    }

    public void setOtherProtectionFlag(String otherProtectionFlag) {
        this.otherProtectionFlag = otherProtectionFlag;
    }

    public String getOtherProtectionDesc() {
        return this.otherProtectionDesc;
    }

    public void setOtherProtectionDesc(String otherProtectionDesc) {
        this.otherProtectionDesc = otherProtectionDesc;
    }

    public String getDentitionAnomalyFlag() {
        return dentitionAnomalyFlag;
    }

    public void setDentitionAnomalyFlag(String dentitionAnomalyFlag) {
        this.dentitionAnomalyFlag = dentitionAnomalyFlag;
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
        return this.periodontalCehckResult;
    }

    public void setPeriodontalCehckResult(String periodontalCehckResult) {
        this.periodontalCehckResult = periodontalCehckResult;
    }

    public String getLipAppearanceCehckResult() {
        return this.lipAppearanceCehckResult;
    }

    public void setLipAppearanceCehckResult(String lipAppearanceCehckResult) {
        this.lipAppearanceCehckResult = lipAppearanceCehckResult;
    }

    public String getDentitionType() {
        return this.dentitionType;
    }

    public void setDentitionType(String dentitionType) {
        this.dentitionType = dentitionType;
    }

    public String getDentitionDesc() {
        return this.dentitionDesc;
    }

    public void setDentitionDesc(String dentitionDesc) {
        this.dentitionDesc = dentitionDesc;
    }

    public String getPharynxCheckResult() {
        return this.pharynxCheckResult;
    }

    public void setPharynxCheckResult(String pharynxCheckResult) {
        this.pharynxCheckResult = pharynxCheckResult;
    }

    public String getThroatTonsilCheckResult() {
        return this.throatTonsilCheckResult;
    }

    public void setThroatTonsilCheckResult(String throatTonsilCheckResult) {
        this.throatTonsilCheckResult = throatTonsilCheckResult;
    }

    public String getThroatCheckResult() {
        return this.throatCheckResult;
    }

    public void setThroatCheckResult(String throatCheckResult) {
        this.throatCheckResult = throatCheckResult;
    }

    public String getThroatAnomalyDesc() {
        return this.throatAnomalyDesc;
    }

    public void setThroatAnomalyDesc(String throatAnomalyDesc) {
        this.throatAnomalyDesc = throatAnomalyDesc;
    }

    public Float getLNakedEye() {
        return this.lNakedEye;
    }

    public void setLNakedEye(Float lNakedEye) {
        this.lNakedEye = lNakedEye;
    }

    public Float getRNakedEye() {
        return this.rNakedEye;
    }

    public void setRNakedEye(Float rNakedEye) {
        this.rNakedEye = rNakedEye;
    }

    public Float getLEyecorrection() {
        return this.lEyecorrection;
    }

    public void setLEyecorrection(Float lEyecorrection) {
        this.lEyecorrection = lEyecorrection;
    }

    public Float getREyecorrection() {
        return this.rEyecorrection;
    }

    public void setREyecorrection(Float rEyecorrection) {
        this.rEyecorrection = rEyecorrection;
    }

    public String getHearDetectResult() {
        return this.hearDetectResult;
    }

    public void setHearDetectResult(String hearDetectResult) {
        this.hearDetectResult = hearDetectResult;
    }

    public String getMotorFuncState() {
        return this.motorFuncState;
    }

    public void setMotorFuncState(String motorFuncState) {
        this.motorFuncState = motorFuncState;
    }

    public String getFundusOculiAnomalyFlag() {
        return this.fundusOculiAnomalyFlag;
    }

    public void setFundusOculiAnomalyFlag(String fundusOculiAnomalyFlag) {
        this.fundusOculiAnomalyFlag = fundusOculiAnomalyFlag;
    }

    public String getFundusOculiAnomalyDesc() {
        return this.fundusOculiAnomalyDesc;
    }

    public void setFundusOculiAnomalyDesc(String fundusOculiAnomalyDesc) {
        this.fundusOculiAnomalyDesc = fundusOculiAnomalyDesc;
    }

    public String getSkinCheckResult() {
        return this.skinCheckResult;
    }

    public void setSkinCheckResult(String skinCheckResult) {
        this.skinCheckResult = skinCheckResult;
    }

    public String getSkinCheckDesc() {
        return this.skinCheckDesc;
    }

    public void setSkinCheckDesc(String skinCheckDesc) {
        this.skinCheckDesc = skinCheckDesc;
    }

    public String getScleraCheckResult() {
        return this.scleraCheckResult;
    }

    public void setScleraCheckResult(String scleraCheckResult) {
        this.scleraCheckResult = scleraCheckResult;
    }

    public String getScleraCheckDesc() {
        return this.scleraCheckDesc;
    }

    public void setScleraCheckDesc(String scleraCheckDesc) {
        this.scleraCheckDesc = scleraCheckDesc;
    }

    public String getLymphNodeCheckResult() {
        return this.lymphNodeCheckResult;
    }

    public void setLymphNodeCheckResult(String lymphNodeCheckResult) {
        this.lymphNodeCheckResult = lymphNodeCheckResult;
    }

    public String getLymphNodeCheckDesc() {
        return this.lymphNodeCheckDesc;
    }

    public void setLymphNodeCheckDesc(String lymphNodeCheckDesc) {
        this.lymphNodeCheckDesc = lymphNodeCheckDesc;
    }

    public Integer getLymphocyteCount() {
        return this.lymphocyteCount;
    }

    public void setLymphocyteCount(Integer lymphocyteCount) {
        this.lymphocyteCount = lymphocyteCount;
    }

    public String getBarrelChest() {
        return this.barrelChest;
    }

    public void setBarrelChest(String barrelChest) {
        this.barrelChest = barrelChest;
    }

    public String getLungsAnomalySound() {
        return this.lungsAnomalySound;
    }

    public void setLungsAnomalySound(String lungsAnomalySound) {
        this.lungsAnomalySound = lungsAnomalySound;
    }

    public String getLungsAnomalyDesc() {
        return this.lungsAnomalyDesc;
    }

    public void setLungsAnomalyDesc(String lungsAnomalyDesc) {
        this.lungsAnomalyDesc = lungsAnomalyDesc;
    }

    public String getLungsRaleFlag() {
        return this.lungsRaleFlag;
    }

    public void setLungsRaleFlag(String lungsRaleFlag) {
        this.lungsRaleFlag = lungsRaleFlag;
    }

    public String getLungsRaleDesc() {
        return this.lungsRaleDesc;
    }

    public void setLungsRaleDesc(String lungsRaleDesc) {
        this.lungsRaleDesc = lungsRaleDesc;
    }

    public Integer getHeartRate() {
        return this.heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public String getCardioverter() {
        return this.cardioverter;
    }

    public void setCardioverter(String cardioverter) {
        this.cardioverter = cardioverter;
    }

    public String getHeartMurmurFlag() {
        return this.heartMurmurFlag;
    }

    public void setHeartMurmurFlag(String heartMurmurFlag) {
        this.heartMurmurFlag = heartMurmurFlag;
    }

    public String getHeartMurmurDesc() {
        return this.heartMurmurDesc;
    }

    public void setHeartMurmurDesc(String heartMurmurDesc) {
        this.heartMurmurDesc = heartMurmurDesc;
    }

    public String getAbdominalTendernessFlag() {
        return this.abdominalTendernessFlag;
    }

    public void setAbdominalTendernessFlag(String abdominalTendernessFlag) {
        this.abdominalTendernessFlag = abdominalTendernessFlag;
    }

    public String getAbdominalTendernessDesc() {
        return this.abdominalTendernessDesc;
    }

    public void setAbdominalTendernessDesc(String abdominalTendernessDesc) {
        this.abdominalTendernessDesc = abdominalTendernessDesc;
    }

    public String getAbdominalMassFlag() {
        return this.abdominalMassFlag;
    }

    public void setAbdominalMassFlag(String abdominalMassFlag) {
        this.abdominalMassFlag = abdominalMassFlag;
    }

    public String getAbdominalMassDesc() {
        return this.abdominalMassDesc;
    }

    public void setAbdominalMassDesc(String abdominalMassDesc) {
        this.abdominalMassDesc = abdominalMassDesc;
    }

    public String getLiverFlag() {
        return this.liverFlag;
    }

    public void setLiverFlag(String liverFlag) {
        this.liverFlag = liverFlag;
    }

    public String getLiverDesc() {
        return this.liverDesc;
    }

    public void setLiverDesc(String liverDesc) {
        this.liverDesc = liverDesc;
    }

    public String getSplenomegalyFlag() {
        return this.splenomegalyFlag;
    }

    public void setSplenomegalyFlag(String splenomegalyFlag) {
        this.splenomegalyFlag = splenomegalyFlag;
    }

    public String getSplenomegalyDesc() {
        return this.splenomegalyDesc;
    }

    public void setSplenomegalyDesc(String splenomegalyDesc) {
        this.splenomegalyDesc = splenomegalyDesc;
    }

    public String getAbdominalVoicedFlag() {
        return this.abdominalVoicedFlag;
    }

    public void setAbdominalVoicedFlag(String abdominalVoicedFlag) {
        this.abdominalVoicedFlag = abdominalVoicedFlag;
    }

    public String getAbdominalVoicedDesc() {
        return this.abdominalVoicedDesc;
    }

    public void setAbdominalVoicedDesc(String abdominalVoicedDesc) {
        this.abdominalVoicedDesc = abdominalVoicedDesc;
    }

    public String getLegsEdemaCheckResult() {
        return this.legsEdemaCheckResult;
    }

    public void setLegsEdemaCheckResult(String legsEdemaCheckResult) {
        this.legsEdemaCheckResult = legsEdemaCheckResult;
    }

    public String getArteriopalmus() {
        return this.arteriopalmus;
    }

    public void setArteriopalmus(String arteriopalmus) {
        this.arteriopalmus = arteriopalmus;
    }

    public String getDreCheckResultType() {
        return this.dreCheckResultType;
    }

    public void setDreCheckResultType(String dreCheckResultType) {
        this.dreCheckResultType = dreCheckResultType;
    }

    public String getDreCheckResultDesc() {
        return this.dreCheckResultDesc;
    }

    public void setDreCheckResultDesc(String dreCheckResultDesc) {
        this.dreCheckResultDesc = dreCheckResultDesc;
    }

    public String getBreastAnomalyFlag() {
        return this.breastAnomalyFlag;
    }

    public void setBreastAnomalyFlag(String breastAnomalyFlag) {
        this.breastAnomalyFlag = breastAnomalyFlag;
    }

    public String getBreastResection() {
        return this.breastResection;
    }

    public void setBreastResection(String breastResection) {
        this.breastResection = breastResection;
    }

    public String getBreastAnomalyLactation() {
        return this.breastAnomalyLactation;
    }

    public void setBreastAnomalyLactation(String breastAnomalyLactation) {
        this.breastAnomalyLactation = breastAnomalyLactation;
    }

    public String getBreastMass() {
        return this.breastMass;
    }

    public void setBreastMass(String breastMass) {
        this.breastMass = breastMass;
    }

    public String getBreastOther() {
        return this.breastOther;
    }

    public void setBreastOther(String breastOther) {
        this.breastOther = breastOther;
    }

    public String getBreastOtherDesc() {
        return this.breastOtherDesc;
    }

    public void setBreastOtherDesc(String breastOtherDesc) {
        this.breastOtherDesc = breastOtherDesc;
    }

    public String getVulvaAnomalyFlag() {
        return vulvaAnomalyFlag;
    }

    public void setVulvaAnomalyFlag(String vulvaAnomalyFlag) {
        this.vulvaAnomalyFlag = vulvaAnomalyFlag;
    }

    public String getVulvaAnomalyDesc() {
        return vulvaAnomalyDesc;
    }

    public void setVulvaAnomalyDesc(String vulvaAnomalyDesc) {
        this.vulvaAnomalyDesc = vulvaAnomalyDesc;
    }

    public String getVaginaAnomalyFlag() {
        return this.vaginaAnomalyFlag;
    }

    public void setVaginaAnomalyFlag(String vaginaAnomalyFlag) {
        this.vaginaAnomalyFlag = vaginaAnomalyFlag;
    }

    public String getVaginaAnomalyDesc() {
        return this.vaginaAnomalyDesc;
    }

    public void setVaginaAnomalyDesc(String vaginaAnomalyDesc) {
        this.vaginaAnomalyDesc = vaginaAnomalyDesc;
    }

    public String getCervicalAnomalyFlag() {
        return this.cervicalAnomalyFlag;
    }

    public void setCervicalAnomalyFlag(String cervicalAnomalyFlag) {
        this.cervicalAnomalyFlag = cervicalAnomalyFlag;
    }

    public String getCervicalAnomalyDesc() {
        return this.cervicalAnomalyDesc;
    }

    public void setCervicalAnomalyDesc(String cervicalAnomalyDesc) {
        this.cervicalAnomalyDesc = cervicalAnomalyDesc;
    }

    public String getCorpusAnomalyFlag() {
        return this.corpusAnomalyFlag;
    }

    public void setCorpusAnomalyFlag(String corpusAnomalyFlag) {
        this.corpusAnomalyFlag = corpusAnomalyFlag;
    }

    public String getCorpusAnomalyDesc() {
        return this.corpusAnomalyDesc;
    }

    public void setCorpusAnomalyDesc(String corpusAnomalyDesc) {
        this.corpusAnomalyDesc = corpusAnomalyDesc;
    }

    public String getAccessoriesAnomalyFlag() {
        return this.accessoriesAnomalyFlag;
    }

    public void setAccessoriesAnomalyFlag(String accessoriesAnomalyFlag) {
        this.accessoriesAnomalyFlag = accessoriesAnomalyFlag;
    }

    public String getAccessoriesAnomalyDesc() {
        return this.accessoriesAnomalyDesc;
    }

    public void setAccessoriesAnomalyDesc(String accessoriesAnomalyDesc) {
        this.accessoriesAnomalyDesc = accessoriesAnomalyDesc;
    }

    public String getThyroidCheckResult() {
        return this.thyroidCheckResult;
    }

    public void setThyroidCheckResult(String thyroidCheckResult) {
        this.thyroidCheckResult = thyroidCheckResult;
    }

    public String getSpineCheckResult() {
        return this.spineCheckResult;
    }

    public void setSpineCheckResult(String spineCheckResult) {
        this.spineCheckResult = spineCheckResult;
    }

    public String getLimbsCheckResult() {
        return this.limbsCheckResult;
    }

    public void setLimbsCheckResult(String limbsCheckResult) {
        this.limbsCheckResult = limbsCheckResult;
    }

    public String getProstateCheckResult() {
        return this.prostateCheckResult;
    }

    public void setProstateCheckResult(String prostateCheckResult) {
        this.prostateCheckResult = prostateCheckResult;
    }

    public String getExtGenitalCheckAnomaly() {
        return this.extGenitalCheckAnomaly;
    }

    public void setExtGenitalCheckAnomaly(String extGenitalCheckAnomaly) {
        this.extGenitalCheckAnomaly = extGenitalCheckAnomaly;
    }

    public String getChestCheckResult() {
        return this.chestCheckResult;
    }

    public void setChestCheckResult(String chestCheckResult) {
        this.chestCheckResult = chestCheckResult;
    }

    public String getOtherCheckResult() {
        return this.otherCheckResult;
    }

    public void setOtherCheckResult(String otherCheckResult) {
        this.otherCheckResult = otherCheckResult;
    }

    public Integer getHemoglobinValue() {
        return this.hemoglobinValue;
    }

    public void setHemoglobinValue(Integer hemoglobinValue) {
        this.hemoglobinValue = hemoglobinValue;
    }

    public BigDecimal getLeukocyteCount() {
        return this.leukocyteCount;
    }

    public void setLeukocyteCount(BigDecimal leukocyteCount) {
        this.leukocyteCount = leukocyteCount;
    }

    public Integer getPlateletCount() {
        return this.plateletCount;
    }

    public void setPlateletCount(Integer plateletCount) {
        this.plateletCount = plateletCount;
    }

    public String getBloodRoutineOtherDesc() {
        return this.bloodRoutineOtherDesc;
    }

    public void setBloodRoutineOtherDesc(String bloodRoutineOtherDesc) {
        this.bloodRoutineOtherDesc = bloodRoutineOtherDesc;
    }

    public String getUrineProQualitativeResult() {
        return this.urineProQualitativeResult;
    }

    public void setUrineProQualitativeResult(String urineProQualitativeResult) {
        this.urineProQualitativeResult = urineProQualitativeResult;
    }

    public String getUrineSugQualitativeResult() {
        return this.urineSugQualitativeResult;
    }

    public void setUrineSugQualitativeResult(String urineSugQualitativeResult) {
        this.urineSugQualitativeResult = urineSugQualitativeResult;
    }


    public String getKetQualitativeDetection() {
        return this.ketQualitativeDetection;
    }

    public void setKetQualitativeDetection(String ketQualitativeDetection) {
        this.ketQualitativeDetection = ketQualitativeDetection;
    }

    public String getKetQuantitativeValue() {
        return this.ketQuantitativeValue;
    }

    public void setKetQuantitativeValue(String ketQuantitativeValue) {
        this.ketQuantitativeValue = ketQuantitativeValue;
    }

    public String getEryDetectionResult() {
        return this.eryDetectionResult;
    }

    public void setEryDetectionResult(String eryDetectionResult) {
        this.eryDetectionResult = eryDetectionResult;
    }

    public String getEryQuantitativeValue() {
        return this.eryQuantitativeValue;
    }

    public void setEryQuantitativeValue(String eryQuantitativeValue) {
        this.eryQuantitativeValue = eryQuantitativeValue;
    }

    public String getUrineRoutinesOtherDesc() {
        return this.urineRoutinesOtherDesc;
    }

    public void setUrineRoutinesOtherDesc(String urineRoutinesOtherDesc) {
        this.urineRoutinesOtherDesc = urineRoutinesOtherDesc;
    }

    public BigDecimal getUrineProportion() {
        return this.urineProportion;
    }

    public void setUrineProportion(BigDecimal urineProportion) {
        this.urineProportion = urineProportion;
    }

    public BigDecimal getUrinePh() {
        return this.urinePh;
    }

    public void setUrinePh(BigDecimal urinePh) {
        this.urinePh = urinePh;
    }

    public BigDecimal getUrineMicroTongAlbumin() {
        return this.urineMicroTongAlbumin;
    }

    public void setUrineMicroTongAlbumin(BigDecimal urineMicroTongAlbumin) {
        this.urineMicroTongAlbumin = urineMicroTongAlbumin;
    }

    public BigDecimal getFpgMmol() {
        return this.fpgMmol;
    }

    public void setFpgMmol(BigDecimal fpgMmol) {
        this.fpgMmol = fpgMmol;
    }

    public BigDecimal getFpgMg() {
        return this.fpgMg;
    }

    public void setFpgMg(BigDecimal fpgMg) {
        this.fpgMg = fpgMg;
    }

    public BigDecimal getGluValue() {
        return this.gluValue;
    }

    public void setGluValue(BigDecimal gluValue) {
        this.gluValue = gluValue;
    }

    public String getEcgAnomalyFlag() {
        return this.ecgAnomalyFlag;
    }

    public void setEcgAnomalyFlag(String ecgAnomalyFlag) {
        this.ecgAnomalyFlag = ecgAnomalyFlag;
    }

    public String getEcgAnomalyDesc() {
        return this.ecgAnomalyDesc;
    }

    public void setEcgAnomalyDesc(String ecgAnomalyDesc) {
        this.ecgAnomalyDesc = ecgAnomalyDesc;
    }

    public String getFecalOccultBlood() {
        return this.fecalOccultBlood;
    }

    public void setFecalOccultBlood(String fecalOccultBlood) {
        this.fecalOccultBlood = fecalOccultBlood;
    }

    public BigDecimal getHgb() {
        return this.hgb;
    }

    public void setHgb(BigDecimal hgb) {
        this.hgb = hgb;
    }

    public String getHbsagDetectResult() {
        return this.hbsagDetectResult;
    }

    public void setHbsagDetectResult(String hbsagDetectResult) {
        this.hbsagDetectResult = hbsagDetectResult;
    }

    public String getHbeagDetectResult() {
        return this.hbeagDetectResult;
    }

    public void setHbeagDetectResult(String hbeagDetectResult) {
        this.hbeagDetectResult = hbeagDetectResult;
    }

    public String getHbsDetectResult() {
        return this.hbsDetectResult;
    }

    public void setHbsDetectResult(String hbsDetectResult) {
        this.hbsDetectResult = hbsDetectResult;
    }

    public String getHbeDetectResult() {
        return this.hbeDetectResult;
    }

    public void setHbeDetectResult(String hbeDetectResult) {
        this.hbeDetectResult = hbeDetectResult;
    }

    public String getHbcabDetectResult() {
        return this.hbcabDetectResult;
    }

    public void setHbcabDetectResult(String hbcabDetectResult) {
        this.hbcabDetectResult = hbcabDetectResult;
    }

    public BigDecimal getSerumGptValue() {
		return serumGptValue;
	}

	public void setSerumGptValue(BigDecimal serumGptValue) {
		this.serumGptValue = serumGptValue;
	}

	public BigDecimal getSerumAstValue() {
		return serumAstValue;
	}

	public void setSerumAstValue(BigDecimal serumAstValue) {
		this.serumAstValue = serumAstValue;
	}

	public BigDecimal getAlbuminConcentration() {
        return this.albuminConcentration;
    }

    public void setAlbuminConcentration(BigDecimal albuminConcentration) {
        this.albuminConcentration = albuminConcentration;
    }

    public BigDecimal getTotalBilirubin() {
        return this.totalBilirubin;
    }

    public void setTotalBilirubin(BigDecimal totalBilirubin) {
        this.totalBilirubin = totalBilirubin;
    }

    public String getConjugatedBilirubin() {
        return this.conjugatedBilirubin;
    }

    public void setConjugatedBilirubin(String conjugatedBilirubin) {
        this.conjugatedBilirubin = conjugatedBilirubin;
    }

    public String getGuideVaccinationDesc() {
        return guideVaccinationDesc;
    }

    public void setGuideVaccinationDesc(String guideVaccinationDesc) {
        this.guideVaccinationDesc = guideVaccinationDesc;
    }

    public BigDecimal getCreatinine() {
        return this.creatinine;
    }

    public void setCreatinine(BigDecimal creatinine) {
        this.creatinine = creatinine;
    }

    public BigDecimal getBloodUreaNitrogenValue() {
        return this.bloodUreaNitrogenValue;
    }

    public void setBloodUreaNitrogenValue(BigDecimal bloodUreaNitrogenValue) {
        this.bloodUreaNitrogenValue = bloodUreaNitrogenValue;
    }

    public BigDecimal getPotassiumConcentration() {
        return this.potassiumConcentration;
    }

    public void setPotassiumConcentration(BigDecimal potassiumConcentration) {
        this.potassiumConcentration = potassiumConcentration;
    }

    public Integer getSodiumConcentration() {
        return this.sodiumConcentration;
    }

    public void setSodiumConcentration(Integer sodiumConcentration) {
        this.sodiumConcentration = sodiumConcentration;
    }

    public BigDecimal getTc() {
        return this.tc;
    }

    public void setTc(BigDecimal tc) {
        this.tc = tc;
    }

    public BigDecimal getTriglycerideValue() {
        return this.triglycerideValue;
    }

    public void setTriglycerideValue(BigDecimal triglycerideValue) {
        this.triglycerideValue = triglycerideValue;
    }

    public BigDecimal getLdlcDetectValue() {
        return this.ldlcDetectValue;
    }

    public void setLdlcDetectValue(BigDecimal ldlcDetectValue) {
        this.ldlcDetectValue = ldlcDetectValue;
    }

    public BigDecimal getHdlcDetectValue() {
        return this.hdlcDetectValue;
    }

    public void setHdlcDetectValue(BigDecimal hdlcDetectValue) {
        this.hdlcDetectValue = hdlcDetectValue;
    }

    public BigDecimal getCeaConcentration() {
        return this.ceaConcentration;
    }

    public void setCeaConcentration(BigDecimal ceaConcentration) {
        this.ceaConcentration = ceaConcentration;
    }

    public String getChestXAnomalyfFlag() {
        return this.chestXAnomalyfFlag;
    }

    public void setChestXAnomalyfFlag(String chestXAnomalyfFlag) {
        this.chestXAnomalyfFlag = chestXAnomalyfFlag;
    }

    public String getChestXAnomalyfDesc() {
        return this.chestXAnomalyfDesc;
    }

    public void setChestXAnomalyfDesc(String chestXAnomalyfDesc) {
        this.chestXAnomalyfDesc = chestXAnomalyfDesc;
    }

    public String getBmodeAnomalyfFlag() {
        return this.bmodeAnomalyfFlag;
    }

    public void setBmodeAnomalyfFlag(String bmodeAnomalyfFlag) {
        this.bmodeAnomalyfFlag = bmodeAnomalyfFlag;
    }

    public String getBmodeAnomalyfDesc() {
        return this.bmodeAnomalyfDesc;
    }

    public void setBmodeAnomalyfDesc(String bmodeAnomalyfDesc) {
        this.bmodeAnomalyfDesc = bmodeAnomalyfDesc;
    }

    public String getBmodeLiverAnomalyfFlag() {
        return this.bmodeLiverAnomalyfFlag;
    }

    public void setBmodeLiverAnomalyfFlag(String bmodeLiverAnomalyfFlag) {
        this.bmodeLiverAnomalyfFlag = bmodeLiverAnomalyfFlag;
    }

    public String getBmodeBileAnomalyfFlag() {
        return this.bmodeBileAnomalyfFlag;
    }

    public void setBmodeBileAnomalyfFlag(String bmodeBileAnomalyfFlag) {
        this.bmodeBileAnomalyfFlag = bmodeBileAnomalyfFlag;
    }

    public String getBmodePancreasAnomalyfFlag() {
        return this.bmodePancreasAnomalyfFlag;
    }

    public void setBmodePancreasAnomalyfFlag(String bmodePancreasAnomalyfFlag) {
        this.bmodePancreasAnomalyfFlag = bmodePancreasAnomalyfFlag;
    }

    public String getBmodeKidneyAnomalyfFlag() {
        return this.bmodeKidneyAnomalyfFlag;
    }

    public void setBmodeKidneyAnomalyfFlag(String bmodeKidneyAnomalyfFlag) {
        this.bmodeKidneyAnomalyfFlag = bmodeKidneyAnomalyfFlag;
    }

    public String getBmodeSpleenAnomalyfFlag() {
        return this.bmodeSpleenAnomalyfFlag;
    }

    public void setBmodeSpleenAnomalyfFlag(String bmodeSpleenAnomalyfFlag) {
        this.bmodeSpleenAnomalyfFlag = bmodeSpleenAnomalyfFlag;
    }

    public String getCervicalSmearAnomalyfFlag() {
        return this.cervicalSmearAnomalyfFlag;
    }

    public void setCervicalSmearAnomalyfFlag(String cervicalSmearAnomalyfFlag) {
        this.cervicalSmearAnomalyfFlag = cervicalSmearAnomalyfFlag;
    }

    public String getCervicalSmearAnomalyfDesc() {
        return this.cervicalSmearAnomalyfDesc;
    }

    public void setCervicalSmearAnomalyfDesc(String cervicalSmearAnomalyfDesc) {
        this.cervicalSmearAnomalyfDesc = cervicalSmearAnomalyfDesc;
    }

    public String getOtherAuxiliaryExamination() {
        return this.otherAuxiliaryExamination;
    }

    public void setOtherAuxiliaryExamination(String otherAuxiliaryExamination) {
        this.otherAuxiliaryExamination = otherAuxiliaryExamination;
    }

    public String getTcmPeacefulQuality() {
        return this.tcmPeacefulQuality;
    }

    public void setTcmPeacefulQuality(String tcmPeacefulQuality) {
        this.tcmPeacefulQuality = tcmPeacefulQuality;
    }

    public String getTcmQiQuality() {
        return this.tcmQiQuality;
    }

    public void setTcmQiQuality(String tcmQiQuality) {
        this.tcmQiQuality = tcmQiQuality;
    }

    public String getTcmYangQuality() {
        return this.tcmYangQuality;
    }

    public void setTcmYangQuality(String tcmYangQuality) {
        this.tcmYangQuality = tcmYangQuality;
    }

    public String getTcmYinDeficiency() {
        return this.tcmYinDeficiency;
    }

    public void setTcmYinDeficiency(String tcmYinDeficiency) {
        this.tcmYinDeficiency = tcmYinDeficiency;
    }

    public String getTcmPhlegmWetness() {
        return this.tcmPhlegmWetness;
    }

    public void setTcmPhlegmWetness(String tcmPhlegmWetness) {
        this.tcmPhlegmWetness = tcmPhlegmWetness;
    }

    public String getTcmHeatMedium() {
        return this.tcmHeatMedium;
    }

    public void setTcmHeatMedium(String tcmHeatMedium) {
        this.tcmHeatMedium = tcmHeatMedium;
    }

    public String getTcmBloodQuality() {
        return this.tcmBloodQuality;
    }

    public void setTcmBloodQuality(String tcmBloodQuality) {
        this.tcmBloodQuality = tcmBloodQuality;
    }

    public String getTcmQiStagnation() {
        return this.tcmQiStagnation;
    }

    public void setTcmQiStagnation(String tcmQiStagnation) {
        this.tcmQiStagnation = tcmQiStagnation;
    }

    public String getTcmSpecialQuality() {
        return this.tcmSpecialQuality;
    }

    public void setTcmSpecialQuality(String tcmSpecialQuality) {
        this.tcmSpecialQuality = tcmSpecialQuality;
    }

    public String getCvascularFlag() {
        return this.cvascularFlag;
    }

    public void setCvascularFlag(String cvascularFlag) {
        this.cvascularFlag = cvascularFlag;
    }

    public String getCvascularHemorrhageStroke() {
        return this.cvascularHemorrhageStroke;
    }

    public void setCvascularHemorrhageStroke(String cvascularHemorrhageStroke) {
        this.cvascularHemorrhageStroke = cvascularHemorrhageStroke;
    }

    public String getCvascularHemorrhage() {
        return this.cvascularHemorrhage;
    }

    public void setCvascularHemorrhage(String cvascularHemorrhage) {
        this.cvascularHemorrhage = cvascularHemorrhage;
    }

    public String getCvascularSah() {
        return this.cvascularSah;
    }

    public void setCvascularSah(String cvascularSah) {
        this.cvascularSah = cvascularSah;
    }

    public String getCovascularTransientIschemic() {
        return this.covascularTransientIschemic;
    }

    public void setCovascularTransientIschemic(String covascularTransientIschemic) {
        this.covascularTransientIschemic = covascularTransientIschemic;
    }

    public String getCovascularOther() {
        return this.covascularOther;
    }

    public void setCovascularOther(String covascularOther) {
        this.covascularOther = covascularOther;
    }

    public String getCvascularOtherDesc() {
        return this.cvascularOtherDesc;
    }

    public void setCvascularOtherDesc(String cvascularOtherDesc) {
        this.cvascularOtherDesc = cvascularOtherDesc;
    }

    public String getKidneyDiseaseFlag() {
        return this.kidneyDiseaseFlag;
    }

    public void setKidneyDiseaseFlag(String kidneyDiseaseFlag) {
        this.kidneyDiseaseFlag = kidneyDiseaseFlag;
    }

    public String getKidneyDiabeticNephropathy() {
        return this.kidneyDiabeticNephropathy;
    }

    public void setKidneyDiabeticNephropathy(String kidneyDiabeticNephropathy) {
        this.kidneyDiabeticNephropathy = kidneyDiabeticNephropathy;
    }

    public String getKidneyRenalFailure() {
        return this.kidneyRenalFailure;
    }

    public void setKidneyRenalFailure(String kidneyRenalFailure) {
        this.kidneyRenalFailure = kidneyRenalFailure;
    }

    public String getKidneyAcuteNephritis() {
        return this.kidneyAcuteNephritis;
    }

    public void setKidneyAcuteNephritis(String kidneyAcuteNephritis) {
        this.kidneyAcuteNephritis = kidneyAcuteNephritis;
    }

    public String getKidneyChronicNephritis() {
        return this.kidneyChronicNephritis;
    }

    public void setKidneyChronicNephritis(String kidneyChronicNephritis) {
        this.kidneyChronicNephritis = kidneyChronicNephritis;
    }

    public String getKidneyOther() {
        return this.kidneyOther;
    }

    public void setKidneyOther(String kidneyOther) {
        this.kidneyOther = kidneyOther;
    }

    public String getKidneyOtherDesc() {
        return this.kidneyOtherDesc;
    }

    public void setKidneyOtherDesc(String kidneyOtherDesc) {
        this.kidneyOtherDesc = kidneyOtherDesc;
    }

    public String getHeartDiseaseFlag() {
        return this.heartDiseaseFlag;
    }

    public void setHeartDiseaseFlag(String heartDiseaseFlag) {
        this.heartDiseaseFlag = heartDiseaseFlag;
    }

    public String getHeartMiocardialInfarction() {
        return this.heartMiocardialInfarction;
    }

    public void setHeartMiocardialInfarction(String heartMiocardialInfarction) {
        this.heartMiocardialInfarction = heartMiocardialInfarction;
    }

    public String getHeartAnginaPectoris() {
        return this.heartAnginaPectoris;
    }

    public void setHeartAnginaPectoris(String heartAnginaPectoris) {
        this.heartAnginaPectoris = heartAnginaPectoris;
    }

    public String getHeartCoronary() {
        return this.heartCoronary;
    }

    public void setHeartCoronary(String heartCoronary) {
        this.heartCoronary = heartCoronary;
    }

    public String getHeartCongestiveHeart() {
        return this.heartCongestiveHeart;
    }

    public void setHeartCongestiveHeart(String heartCongestiveHeart) {
        this.heartCongestiveHeart = heartCongestiveHeart;
    }

    public String getHeartPrecordialPain() {
        return this.heartPrecordialPain;
    }

    public void setHeartPrecordialPain(String heartPrecordialPain) {
        this.heartPrecordialPain = heartPrecordialPain;
    }

    public String getHeartOther() {
        return this.heartOther;
    }

    public void setHeartOther(String heartOther) {
        this.heartOther = heartOther;
    }

    public String getHeartOtherDesc() {
        return this.heartOtherDesc;
    }

    public void setHeartOtherDesc(String heartOtherDesc) {
        this.heartOtherDesc = heartOtherDesc;
    }

    public String getArteryDiseaseFlag() {
        return this.arteryDiseaseFlag;
    }

    public void setArteryDiseaseFlag(String arteryDiseaseFlag) {
        this.arteryDiseaseFlag = arteryDiseaseFlag;
    }

    public String getArteryDissectingAneurysm() {
        return this.arteryDissectingAneurysm;
    }

    public void setArteryDissectingAneurysm(String arteryDissectingAneurysm) {
        this.arteryDissectingAneurysm = arteryDissectingAneurysm;
    }

    public String getArteryPaod() {
        return this.arteryPaod;
    }

    public void setArteryPaod(String arteryPaod) {
        this.arteryPaod = arteryPaod;
    }

    public String getArteryOther() {
        return this.arteryOther;
    }

    public void setArteryOther(String arteryOther) {
        this.arteryOther = arteryOther;
    }

    public String getArteryOtherDesc() {
        return this.arteryOtherDesc;
    }

    public void setArteryOtherDesc(String arteryOtherDesc) {
        this.arteryOtherDesc = arteryOtherDesc;
    }

    public String getColorVision() {
        return this.colorVision;
    }

    public void setColorVision(String colorVision) {
        this.colorVision = colorVision;
    }

    public String getEardrumCheckResult() {
        return this.eardrumCheckResult;
    }

    public void setEardrumCheckResult(String eardrumCheckResult) {
        this.eardrumCheckResult = eardrumCheckResult;
    }

    public String getEarAnomalyfDesc() {
        return this.earAnomalyfDesc;
    }

    public void setEarAnomalyfDesc(String earAnomalyfDesc) {
        this.earAnomalyfDesc = earAnomalyfDesc;
    }

    public String getNasalSeptumCheckResult() {
        return this.nasalSeptumCheckResult;
    }

    public void setNasalSeptumCheckResult(String nasalSeptumCheckResult) {
        this.nasalSeptumCheckResult = nasalSeptumCheckResult;
    }

    public String getNasalMucosaCheckResult() {
        return this.nasalMucosaCheckResult;
    }

    public void setNasalMucosaCheckResult(String nasalMucosaCheckResult) {
        this.nasalMucosaCheckResult = nasalMucosaCheckResult;
    }

    public String getNasalAnomalyfDesc() {
        return this.nasalAnomalyfDesc;
    }

    public void setNasalAnomalyfDesc(String nasalAnomalyfDesc) {
        this.nasalAnomalyfDesc = nasalAnomalyfDesc;
    }

    public String getEyeDiseasesFlag() {
        return this.eyeDiseasesFlag;
    }

    public void setEyeDiseasesFlag(String eyeDiseasesFlag) {
        this.eyeDiseasesFlag = eyeDiseasesFlag;
    }

    public String getEyeRetinalOozing() {
        return this.eyeRetinalOozing;
    }

    public void setEyeRetinalOozing(String eyeRetinalOozing) {
        this.eyeRetinalOozing = eyeRetinalOozing;
    }

    public String getEyeOpticPapilla() {
        return this.eyeOpticPapilla;
    }

    public void setEyeOpticPapilla(String eyeOpticPapilla) {
        this.eyeOpticPapilla = eyeOpticPapilla;
    }

    public String getEyeCataract() {
        return this.eyeCataract;
    }

    public void setEyeCataract(String eyeCataract) {
        this.eyeCataract = eyeCataract;
    }

    public String getEyeOther() {
        return this.eyeOther;
    }

    public void setEyeOther(String eyeOther) {
        this.eyeOther = eyeOther;
    }

    public String getEyeOtherDesc() {
        return this.eyeOtherDesc;
    }

    public void setEyeOtherDesc(String eyeOtherDesc) {
        this.eyeOtherDesc = eyeOtherDesc;
    }

    public String getNervousDiseasesFlag() {
        return this.nervousDiseasesFlag;
    }

    public void setNervousDiseasesFlag(String nervousDiseasesFlag) {
        this.nervousDiseasesFlag = nervousDiseasesFlag;
    }

    public String getNervousDiseasesDesc() {
        return this.nervousDiseasesDesc;
    }

    public void setNervousDiseasesDesc(String nervousDiseasesDesc) {
        this.nervousDiseasesDesc = nervousDiseasesDesc;
    }

    public String getPhysiologyAnomalyFlag() {
        return this.physiologyAnomalyFlag;
    }

    public void setPhysiologyAnomalyFlag(String physiologyAnomalyFlag) {
        this.physiologyAnomalyFlag = physiologyAnomalyFlag;
    }

    public String getPhysiologyAnomalyfDesc() {
        return this.physiologyAnomalyfDesc;
    }

    public void setPhysiologyAnomalyfDesc(String physiologyAnomalyfDesc) {
        this.physiologyAnomalyfDesc = physiologyAnomalyfDesc;
    }

    public String getPathologyCheckFlag() {
        return this.pathologyCheckFlag;
    }

    public void setPathologyCheckFlag(String pathologyCheckFlag) {
        this.pathologyCheckFlag = pathologyCheckFlag;
    }

    public String getPathologyCheckDesc() {
        return this.pathologyCheckDesc;
    }

    public void setPathologyCheckDesc(String pathologyCheckDesc) {
        this.pathologyCheckDesc = pathologyCheckDesc;
    }

    public String getHealthOther() {
        return this.healthOther;
    }

    public void setHealthOther(String healthOther) {
        this.healthOther = healthOther;
    }

    public String getHealthOtherDesc() {
        return this.healthOtherDesc;
    }

    public void setHealthOtherDesc(String healthOtherDesc) {
        this.healthOtherDesc = healthOtherDesc;
    }

    public String getHealthEvaluateAnomalyFlag() {
        return this.healthEvaluateAnomalyFlag;
    }

    public void setHealthEvaluateAnomalyFlag(String healthEvaluateAnomalyFlag) {
        this.healthEvaluateAnomalyFlag = healthEvaluateAnomalyFlag;
    }

    public String getGuideIntoChronicDisease() {
        return this.guideIntoChronicDisease;
    }

    public void setGuideIntoChronicDisease(String guideIntoChronicDisease) {
        this.guideIntoChronicDisease = guideIntoChronicDisease;
    }

    public String getGuideRegularFollowup() {
        return this.guideRegularFollowup;
    }

    public void setGuideRegularFollowup(String guideRegularFollowup) {
        this.guideRegularFollowup = guideRegularFollowup;
    }

    public String getGuideVaccination() {
        return this.guideVaccination;
    }

    public void setGuideVaccination(String guideVaccination) {
        this.guideVaccination = guideVaccination;
    }

    public String getGuideSuggestionReview() {
        return this.guideSuggestionReview;
    }

    public void setGuideSuggestionReview(String guideSuggestionReview) {
        this.guideSuggestionReview = guideSuggestionReview;
    }

    public String getGuideSuggestionReferral() {
        return this.guideSuggestionReferral;
    }

    public void setGuideSuggestionReferral(String guideSuggestionReferral) {
        this.guideSuggestionReferral = guideSuggestionReferral;
    }

    public String getIncludedSixManagement() {
		return includedSixManagement;
	}

	public void setIncludedSixManagement(String includedSixManagement) {
		this.includedSixManagement = includedSixManagement;
	}

	public String getMaternalManagement() {
		return maternalManagement;
	}

	public void setMaternalManagement(String maternalManagement) {
		this.maternalManagement = maternalManagement;
	}

	public String getRiskQuitSmoking() {
        return this.riskQuitSmoking;
    }

    public void setRiskQuitSmoking(String riskQuitSmoking) {
        this.riskQuitSmoking = riskQuitSmoking;
    }

    public String getRiskHealthDrink() {
        return this.riskHealthDrink;
    }

    public void setRiskHealthDrink(String riskHealthDrink) {
        this.riskHealthDrink = riskHealthDrink;
    }

    public String getRiskDiet() {
        return this.riskDiet;
    }

    public void setRiskDiet(String riskDiet) {
        this.riskDiet = riskDiet;
    }

    public String getRiskExercise() {
        return this.riskExercise;
    }

    public void setRiskExercise(String riskExercise) {
        this.riskExercise = riskExercise;
    }

    public String getRiskWeightReduction() {
        return this.riskWeightReduction;
    }

    public void setRiskWeightReduction(String riskWeightReduction) {
        this.riskWeightReduction = riskWeightReduction;
    }

    public String getRiskWeightTarget() {
        return this.riskWeightTarget;
    }

    public void setRiskWeightTarget(String riskWeightTarget) {
        this.riskWeightTarget = riskWeightTarget;
    }

    public String getRiskOther() {
        return this.riskOther;
    }

    public void setRiskOther(String riskOther) {
        this.riskOther = riskOther;
    }

    public String getRiskOtherDesc() {
        return this.riskOtherDesc;
    }

    public void setRiskOtherDesc(String riskOtherDesc) {
        this.riskOtherDesc = riskOtherDesc;
    }

    public String getExaminationResult() {
        return this.examinationResult;
    }

    public void setExaminationResult(String examinationResult) {
        this.examinationResult = examinationResult;
    }

    public String getExaminationOrganCode() {
        return this.examinationOrganCode;
    }

    public void setExaminationOrganCode(String examinationOrganCode) {
        this.examinationOrganCode = examinationOrganCode;
    }

    public String getExaminationOrganName() {
        return this.examinationOrganName;
    }

    public void setExaminationOrganName(String examinationOrganName) {
        this.examinationOrganName = examinationOrganName;
    }

    public Date getExaminationDate() {
        return this.examinationDate;
    }

    public void setExaminationDate(Date examinationDate) {
        this.examinationDate = examinationDate;
    }

    public String getManaDoctorNo() {
        return this.manaDoctorNo;
    }

    public void setManaDoctorNo(String manaDoctorNo) {
        this.manaDoctorNo = manaDoctorNo;
    }

    public String getManaDoctorName() {
        return this.manaDoctorName;
    }

    public void setManaDoctorName(String manaDoctorName) {
        this.manaDoctorName = manaDoctorName;
    }

    public String getManaDoctorIdcard() {
        return this.manaDoctorIdcard;
    }

    public void setManaDoctorIdcard(String manaDoctorIdcard) {
        this.manaDoctorIdcard = manaDoctorIdcard;
    }

    public String getInputIdcard() {
        return this.inputIdcard;
    }

    public void setInputIdcard(String inputIdcard) {
        this.inputIdcard = inputIdcard;
    }

    public String getInputName() {
        return this.inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

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

    public BigDecimal getWhr() {
        return whr;
    }

    public void setWhr(BigDecimal whr) {
        this.whr = whr;
    }

    public BigDecimal getHip() {
        return hip;
    }

    public void setHip(BigDecimal hip) {
        this.hip = hip;
    }

    public Integer getDecayedToothFlg() {
        return decayedToothFlg;
    }

    public void setDecayedToothFlg(Integer decayedToothFlg) {
        this.decayedToothFlg = decayedToothFlg;
    }

    public Integer getMissingToothFlg() {
        return missingToothFlg;
    }

    public void setMissingToothFlg(Integer missingToothFlg) {
        this.missingToothFlg = missingToothFlg;
    }

    public Integer getDentureToothFlg() {
        return dentureToothFlg;
    }

    public void setDentureToothFlg(Integer dentureToothFlg) {
        this.dentureToothFlg = dentureToothFlg;
    }

    public String getManaDoctorId() {
        return manaDoctorId;
    }

    public void setManaDoctorId(String manaDoctorId) {
        this.manaDoctorId = manaDoctorId;
    }

	
	public String getPhysicalExamType() {
		return physicalExamType;
	}

	
	public void setPhysicalExamType(String physicalExamType) {
		this.physicalExamType = physicalExamType;
	}

	
	public BigDecimal getPhysicalExamCost() {
		return physicalExamCost;
	}

	
	public void setPhysicalExamCost(BigDecimal physicalExamCost) {
		this.physicalExamCost = physicalExamCost;
	}

	
	public String getHealthEvaluateResult() {
		return healthEvaluateResult;
	}

	
	public void setHealthEvaluateResult(String healthEvaluateResult) {
		this.healthEvaluateResult = healthEvaluateResult;
	}

	
	public String getHealthEvaluateAnomalyDesc() {
		return healthEvaluateAnomalyDesc;
	}

	
	public void setHealthEvaluateAnomalyDesc(String healthEvaluateAnomalyDesc) {
		this.healthEvaluateAnomalyDesc = healthEvaluateAnomalyDesc;
	}

	
	public String getHealthGuidance() {
		return healthGuidance;
	}

	
	public void setHealthGuidance(String healthGuidance) {
		this.healthGuidance = healthGuidance;
	}

	
	public String getSuggestion() {
		return suggestion;
	}

	
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
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

	public String getOtherTrainingWay() {
		return otherTrainingWay;
	}

	public void setOtherTrainingWay(String otherTrainingWay) {
		this.otherTrainingWay = otherTrainingWay;
	}

	public String getTcmConclusion() {
		return tcmConclusion;
	}

	public void setTcmConclusion(String tcmConclusion) {
		this.tcmConclusion = tcmConclusion;
	}

	
	public Integer getDecayedToothNumber() {
		this.decayedToothNumber = 0;
		if (ObjectUtil.isNotEmpty(decayedToothNumberUpl)) {
			decayedToothNumber += decayedToothNumberUpl;
		}
		if (ObjectUtil.isNotEmpty(decayedToothNumberUpr)) {
			decayedToothNumber += decayedToothNumberUpr;
		}
		if (ObjectUtil.isNotEmpty(decayedToothNumberDownl)) {
			decayedToothNumber += decayedToothNumberDownl;
		}
		if (ObjectUtil.isNotEmpty(decayedToothNumberDownr)) {
			decayedToothNumber += decayedToothNumberDownr;
		}

		return decayedToothNumber;
	}

	
	public void setDecayedToothNumber(Integer decayedToothNumber) {
		this.decayedToothNumber = decayedToothNumber;
	}

	
	public Integer getMissingToothNumber() {
		this.missingToothNumber = 0;
		if (ObjectUtil.isNotEmpty(missingToothNumberUpl)) {
			this.missingToothNumber += missingToothNumberUpl;
		}
		if (ObjectUtil.isNotEmpty(missingToothNumberUpr)) {
			this.missingToothNumber += missingToothNumberUpr;
		}
		if (ObjectUtil.isNotEmpty(missingToothNumberDownl)) {
			this.missingToothNumber += missingToothNumberDownl;
		}
		if (ObjectUtil.isNotEmpty(missingToothNumberDownr)) {
			this.missingToothNumber += missingToothNumberDownr;
		}
		return missingToothNumber;
	}

	
	public void setMissingToothNumber(Integer missingToothNumber) {
		this.missingToothNumber = missingToothNumber;
	}

	
	public Integer getDentureToothNumber() {
		this.dentureToothNumber = 0;
		if (ObjectUtil.isNotEmpty(dentureToothNumberUpl)) {
			dentureToothNumber += dentureToothNumberUpl;
		}
		
		if (ObjectUtil.isNotEmpty(dentureToothNumberUpr)) {
			dentureToothNumber += dentureToothNumberUpr;
		}
		if (ObjectUtil.isNotEmpty(dentureToothNumberDownl)) {
			dentureToothNumber += dentureToothNumberDownl;
		}
		if (ObjectUtil.isNotEmpty(dentureToothNumberDownr)) {
			dentureToothNumber += dentureToothNumberDownr;
		}
		return dentureToothNumber;
	}

	
	public void setDentureToothNumber(Integer dentureToothNumber) {
		this.dentureToothNumber = dentureToothNumber;
	}

	
	public String getIdCardNo() {
		return idCardNo;
	}

	
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	
	public String getProcessStatus() {
		return processStatus;
	}

	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	
	public String getSourceId() {
		return sourceId;
	}

	
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	
	public String getAuthorOrganization() {
		this.authorOrganization = this.examinationOrganCode;
		return authorOrganization;
	}

	
	public void setAuthorOrganization(String authorOrganization) {
		this.authorOrganization = authorOrganization;
	}

	
	public String getInputDateDesc() {
		return inputDateDesc;
	}

	
	public void setInputDateDesc(String inputDateDesc) {
		this.inputDateDesc = inputDateDesc;
	}

	
	public String getExaminationDateDesc() {
		return examinationDateDesc;
	}

	
	public void setExaminationDateDesc(String examinationDateDesc) {
		this.examinationDateDesc = examinationDateDesc;
	}

	
	public String getLymphNodeCheckResultDesc() {
		return lymphNodeCheckResultDesc;
	}

	
	public void setLymphNodeCheckResultDesc(String lymphNodeCheckResultDesc) {
		this.lymphNodeCheckResultDesc = lymphNodeCheckResultDesc;
	}

	
	public String getDreCheckResultTypeDesc() {
		return dreCheckResultTypeDesc;
	}

	
	public void setDreCheckResultTypeDesc(String dreCheckResultTypeDesc) {
		this.dreCheckResultTypeDesc = dreCheckResultTypeDesc;
	}

	
	public String getScleraCheckResultDesc() {
		return scleraCheckResultDesc;
	}

	
	public void setScleraCheckResultDesc(String scleraCheckResultDesc) {
		this.scleraCheckResultDesc = scleraCheckResultDesc;
	}

    public String getUrineProQuantitativeValue() {
        return urineProQuantitativeValue;
    }

    public void setUrineProQuantitativeValue(String urineProQuantitativeValue) {
        this.urineProQuantitativeValue = urineProQuantitativeValue;
    }

    public String getUrineSugQuantitativeValue() {
        return urineSugQuantitativeValue;
    }

    public void setUrineSugQuantitativeValue(String urineSugQuantitativeValue) {
        this.urineSugQuantitativeValue = urineSugQuantitativeValue;
    }

	public String getBloodPressureSource() {
		return bloodPressureSource;
	}

	public void setBloodPressureSource(String bloodPressureSource) {
		this.bloodPressureSource = bloodPressureSource;
	}

	public String getBloodSugarSource() {
		return bloodSugarSource;
	}

	public void setBloodSugarSource(String bloodSugarSource) {
		this.bloodSugarSource = bloodSugarSource;
	}
    public String getBmodeOtherAnomalyfFlag() {
        return bmodeOtherAnomalyfFlag;
    }

    public void setBmodeOtherAnomalyfFlag(String bmodeOtherAnomalyfFlag) {
        this.bmodeOtherAnomalyfFlag = bmodeOtherAnomalyfFlag;
    }

    public String getBmodeOtherAnomalyfDesc() {
        return bmodeOtherAnomalyfDesc;
    }

    public void setBmodeOtherAnomalyfDesc(String bmodeOtherAnomalyfDesc) {
        this.bmodeOtherAnomalyfDesc = bmodeOtherAnomalyfDesc;
    }


    public String getMissingTooth() {
        return missingTooth;
    }

    public void setMissingTooth(String missingTooth) {
        this.missingTooth = missingTooth;
    }

    public String getDecayedTooth() {
        return decayedTooth;
    }

    public void setDecayedTooth(String decayedTooth) {
        this.decayedTooth = decayedTooth;
    }

    public String getDentureTooth() {
        return dentureTooth;
    }

    public void setDentureTooth(String dentureTooth) {
        this.dentureTooth = dentureTooth;
    }

    public String getHealthEvaluateCheck() {
        return healthEvaluateCheck;
    }

    public void setHealthEvaluateCheck(String healthEvaluateCheck) {
        this.healthEvaluateCheck = healthEvaluateCheck;
    }

    public String getHealthEvaluateOtherDesc() {
        return healthEvaluateOtherDesc;
    }

    public void setHealthEvaluateOtherDesc(String healthEvaluateOtherDesc) {
        this.healthEvaluateOtherDesc = healthEvaluateOtherDesc;
    }

	public Long getIdentificationId() {
		return identificationId;
	}

	public void setIdentificationId(Long identificationId) {
		this.identificationId = identificationId;
	}

	public Long getOldIdentificationId() {
		return oldIdentificationId;
	}

	public void setOldIdentificationId(Long oldIdentificationId) {
		this.oldIdentificationId = oldIdentificationId;
	}

    public String getPreventionOsteoporosis() {
        return preventionOsteoporosis;
    }

    public void setPreventionOsteoporosis(String preventionOsteoporosis) {
        this.preventionOsteoporosis = preventionOsteoporosis;
    }

    public String getPreventionTumble() {
        return preventionTumble;
    }

    public void setPreventionTumble(String preventionTumble) {
        this.preventionTumble = preventionTumble;
    }

    public String getPreventionInjury() {
        return preventionInjury;
    }

    public void setPreventionInjury(String preventionInjury) {
        this.preventionInjury = preventionInjury;
    }
}
