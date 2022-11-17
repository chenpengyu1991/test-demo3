package com.founder.rhip.ehr.entity.women;

import com.founder.rhip.ehr.common.JaxbDateSerializer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "WH_MOTHERHOOD_PERIOD_FOLLOWUP")
@XmlRootElement
public class MotherhoodPeriodFollowup implements Serializable {

	private static final long serialVersionUID = -4804039611745983566L;

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 11, scale = 0)
	private Long id;
	
	@Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = false)
	private String ehrId;
	
	@Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|产后42天健康检查记录表单编号||", length = 20, nullable = true)
	private String recordNumber;
	
	@Column(name = "PERSON_ID", precision = 11, scale = 0)
	private Long personId;
	
	@Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号||", length = 17, nullable = true)
	private String healthFileNo;
	
	@Column(name = "ADMISSION_NO", length = 10)
	private String admissionNo;
	
	@Column(name = "MOTHER_NAME", columnDefinition = "VARCHAR2|姓名||", length = 100, nullable = true)
	private String motherName;
	
	@Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||")
	private Date birthday;
	
	@Column(name = "NATION", columnDefinition = "VARCHAR2|民族||",  length = 2)
	private String nation;
	
	@Column(name = "EDUCATION", columnDefinition = "VARCHAR2|学历||", length = 2)
	private String education;
	
	@Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|本人电话号码||", length = 60)
	private String phoneNumber;
	
	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证件号码||", length = 54)
	private String idcard;
	
	@Column(name = "OTHER_IDCARD_TYPE", columnDefinition = "VARCHAR2|身份证件类别代码||", length = 2)
	private String otherIdcardType;
	
	@Column(name = "OTHER_IDCARD", columnDefinition = "VARCHAR2|其他证件号||", length = 60)
	private String otherIdcard;
	
	@Column(name = "OCCUPATION_TYPE", columnDefinition = "VARCHAR2|职业类别||", length = 3)
	private String occupationType;
	
	@Column(name = "UNIT_NAME", columnDefinition = "VARCHAR2|单位/学校名称||", length = 210)
	private String unitName;
	
	@Column(name = "SPOUSE_NAME",  columnDefinition = "VARCHAR2|配偶姓名||", length = 90)
	private String spouseName;
	
	@Column(name = "SPOUSE_BIRTHDAY", columnDefinition = "DATE|配偶出生日期||")
	private Date spouseBirthday;
	
	@Column(name = "SPOUSE_NATION", columnDefinition = "DATE|配偶民族||",  length = 2)
	private String spouseNation;
	
	@Column(name = "SPOUSE_EDUCATION", columnDefinition = "DATE|配偶学历||", length = 2)
	private String spouseEducation;
	
	@Column(name = "SPOUSE_IDCARD", columnDefinition = "DATE|配偶身份证||", length = 54)
	private String spouseIdcard;
	
	@Column(name = "SPOUSE_OCCUPATION", columnDefinition = "DATE|配偶职业||", length = 3)
	private String spouseOccupation;
	
	@Column(name = "SPOUSE_UNIT_NAME", columnDefinition = "DATE|配偶单位名称||", length = 210)
	private String spouseUnitName;
	
	@Column(name = "NEONATAL_NAME", columnDefinition = "DATE|新生儿姓名||", length = 90)
	private String neonatalName;
	
	@Column(name = "NEONATAL_GENDER", columnDefinition = "DATE|新生儿性别||", length = 1)
	private String neonatalGender;
	
	@Column(name = "AREA_CODE", columnDefinition = "VARCHAR2|行政区划代码||", length = 12)
	private String areaCode;
	
	@Column(name = "HRSTREET", columnDefinition = "VARCHAR2|户籍地址-村(街、路、弄等)||", length = 210)
	private String hrstreet;
	
	@Column(name = "HRHOUSE_NUMBER", columnDefinition = "VARCHAR2|户籍地址-门牌号码||", length = 210)
	private String hrhouseNumber;
	
	@Column(name = "HRPROVINCE", columnDefinition = "VARCHAR2|户籍地址-省(自治区、直辖市)||", length = 210)
	private String hrprovince;
	
	@Column(name = "HRCITY", columnDefinition = "VARCHAR2|户籍地址-市(地区、州)||", length = 210)
	private String hrcity;
	
	@Column(name = "HRCOUNTY", columnDefinition = "VARCHAR2|户籍地址-县(区)||", length = 210)
	private String hrcounty;
	
	@Column(name = "HRTOWN_SHIP", columnDefinition = "VARCHAR2|户籍地址-乡(镇、街道办事处)||", length = 210)
	private String hrtownShip;
	
	@Column(name = "HRPOST_CODE", columnDefinition = "VARCHAR2|户籍地址邮政编码||", length = 6)
	private String hrpostCode;
	
	@Column(name = "PASTREET", columnDefinition = "VARCHAR2|现住址-村(街、路、弄等)||", length = 210)
	private String pastreet;
	
	@Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|现住址-门牌号码||", length = 210)
	private String pahouseNumber;
	
	@Column(name = "PAPROVINCE", columnDefinition = "VARCHAR2|现住址-省(自治区、直辖市)||", length = 210)
	private String paprovince;
	
	@Column(name = "PACITY", columnDefinition = "VARCHAR2|现住址-市(地区、州)||", length = 210)
	private String pacity;
	
	@Column(name = "PACOUNTY", columnDefinition = "VARCHAR2|现住址-县(区)||", length = 210)
	private String pacounty;
	
	@Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|现住址-乡(镇、街道办事处)||", length = 210)
	private String patownShip;
	
	@Column(name = "PAPOST_CODE", columnDefinition = "VARCHAR2|现住址邮政编码||", length = 6)
	private String papostCode;
	
	@Column(name = "PRESENT_HISTORY", length = 300)
	private String presentHistory;
	
	@Column(name = "PAST_MEDICAL_HISTORY", length = 300)
	private String pastMedicalHistory;
	
	@Column(name = "OPERATION_HISTORY", length = 300)
	private String operationHistory;
	
	@Column(name = "ALLERGIC_HISTORY", length = 300)
	private String allergicHistory;
	
	@Column(name = "FAMILY_GENE_DISEASE_HISTORY", length = 300)
	private String familyGeneDiseaseHistory;
	
	@Column(name = "MENARCHE_AGE", precision = 3, scale = 0)
	private Integer menarcheAge;
	
	@Column(name = "MENSTRUAL_DURATION", precision = 5, scale = 0)
	private Integer menstrualDuration;
	
	@Column(name = "MENSTRUAL_BLEEDING_TYPE", length = 1)
	private String menstrualBleedingType;
	
	@Column(name = "MENSTRUAL_CYCLE", precision = 5, scale = 0)
	private Integer menstrualCycle;
	
	@Column(name = "LAST_MENSTRUAL_DATE")
	private Date lastMenstrualDate;
	
	@Column(name = "DYSMENORRHEA_DEGREE", length = 1)
	private String dysmenorrheaDegree;
	
	@Column(name = "GRAVIDITY_TIMES", precision = 3, scale = 0)
	private Integer gravidityTimes;
	
	@Column(name = "PRODUCTION_TIMES", precision = 3, scale = 0)
	private Integer productionTimes;
	
	@Column(name = "PREMATURE_DELIVERY_TIMES", precision = 3, scale = 0)
	private Integer prematureDeliveryTimes;
	
	@Column(name = "SPONTANEOUS_ABORTION_TIMES", precision = 3, scale = 0)
	private Integer spontaneousAbortionTimes;
	
	@Column(name = "ARTIFICIAL_ABORTION_TIMES", precision = 3, scale = 0)
	private Integer artificialAbortionTimes;
	
	@Column(name = "CESAREAN_SECTION_TIMES", precision = 3, scale = 0)
	private Integer cesareanSectionTimes;
	
	@Column(name = "VAGINA_DELIVERY_TIMES", precision = 3, scale = 0)
	private Integer vaginaDeliveryTimes;
	
	@Column(name = "STILLBIRTH_CASES_NUMBER", precision = 5, scale = 0)
	private Integer stillbirthCasesNumber;
	
	@Column(name = "STILLBORN_CASES_NUMBER", precision = 5, scale = 0)
	private Integer stillbornCasesNumber;
	
	@Column(name = "PREVIOUS_CHILDBIRTH_WAY", length = 2)
	private String previousChildbirthWay;
	
	@Column(name = "PREVIOUS_PREGNANCY_END_WAY", length = 1)
	private String previousPregnancyEndWay;
	
	@Column(name = "PREVIOUS_CHILDBIRTH_DATE")
	private Date previousChildbirthDate;
	
	@Column(name = "PREVIOUS_PREGNANCY_END_DATE")
	private Date previousPregnancyEndDate;
	
	@Column(name = "DBP", length = 10)
	private String dbp;
	
	@Column(name = "SBP", length = 10)
	private String sbp;
	
	@Column(name = "BASE_DBP", length = 10)
	private String baseDbp;
	
	@Column(name = "BASE_SBP", length = 10)
	private String baseSbp;
	
	@Column(name = "TEMPERATURE", precision = 4, scale = 1)
	private BigDecimal temperature;
	
	@Column(name = "WEIGHT", precision = 5, scale = 1)
	private BigDecimal weight;
	
	@Column(name = "BASE_WEIGHT", precision = 5, scale = 1)
	private BigDecimal baseWeight;
	
	@Column(name = "ABDOMINAL_GIRTH", precision = 5, scale = 1)
	private BigDecimal abdominalGirth;
	
	@Column(name = "SYMPTOM", length = 300)
	private String symptom;
	
	@Column(name = "SIGNS", length = 300)
	private String signs;
	
	@Column(name = "HEART_RATE", length = 10)
	private String heartRate;
	
	@Column(name = "FETAL_HEART_RATE", length = 10)
	private String fetalHeartRate;
	
	@Column(name = "DELIVERY_WEEK", precision = 5, scale = 0)
	private Integer deliveryWeek;
	
	@Column(name = "DELIVERY_DATE")
	private Date deliveryDate;
	
	@Column(name = "DELIVERY_WAY", length = 2)
	private String deliveryWay;
	
	@Column(name = "DELIVERY_OUTCOME", length = 50)
	private String deliveryOutcome;
	
	@Column(name = "TOTAL_LABOR_RUNTIME", precision = 5, scale = 0)
	private Integer totalLaborRuntime;
	
	@Column(name = "FIRST_TOTAL_LABOR_RUNTIME", precision = 5, scale = 0)
	private Integer firstTotalLaborRuntime;
	
	@Column(name = "SECOND_TOTAL_LABOR_RUNTIME", precision = 5, scale = 0)
	private Integer secondTotalLaborRuntime;
	
	@Column(name = "THIRD_TOTAL_LABOR_RUNTIME", precision = 5, scale = 0)
	private Integer thirdTotalLaborRuntime;
	
	@Column(name = "POSTPARTUM_OPEN_MILK_RUNTIME", precision = 5, scale = 0)
	private Integer postpartumOpenMilkRuntime;
	
	@Column(name = "POSTPARTUM_DAYS", precision = 5, scale = 0)
	private Integer postpartumDays;
	
	@Column(name = "COMPLICATIONS_CODE", length = 2)
	private String complicationsCode;
	
	@Column(name = "DELIVERY_TOTAL_BLEED", precision = 5, scale = 0)
	private Integer deliveryTotalBleed;
	
	@Column(name = "DELIVERY_BLEED", precision = 5, scale = 0)
	private Integer deliveryBleed;
	
	@Column(name = "DELIVERY_TWO_BLEED", precision = 5, scale = 0)
	private Integer deliveryTwoBleed;
	
	@Column(name = "NEONATAL_TEMPERATURE", precision = 4, scale = 1)
	private BigDecimal neonatalTemperature;
	
	@Column(name = "NEONATAL_HEART_RATE", length = 10)
	private String neonatalHeartRate;
	
	@Column(name = "NEONATAL_WEIGHT", precision = 5, scale = 0)
	private Integer neonatalWeight;
	
	@Column(name = "NEONATAL_STATURE", precision = 5, scale = 1)
	private BigDecimal neonatalStature;
	
	@Column(name = "NEONATAL_HEIGHT", precision = 5, scale = 1)
	private BigDecimal neonatalHeight;
	
	@Column(name = "NEONATAL_HEAD_CIRCUMFERENCE", precision = 5, scale = 1)
	private BigDecimal neonatalHeadCircumference;
	
	@Column(name = "NEONATAL_BUST", precision = 5, scale = 1)
	private BigDecimal neonatalBust;
	
	@Column(name = "NEONATAL_CARDIAC_AUSCU_RESULT", length = 300)
	private String neonatalCardiacAuscuResult;
	
	@Column(name = "NEONATAL_LUNG_AUSCU_RESULT", length = 300)
	private String neonatalLungAuscuResult;
	
	@Column(name = "LOCHIA_CONDITION", length = 300)
	private String lochiaCondition;
	
	@Column(name = "ESTIMATED_DUE_DATES")
	private Date estimatedDueDates;
	
	@Column(name = "PREGNANCY_ANOMALIES_RECORD", length = 300)
	private String pregnancyAnomaliesRecord;
	
	@Column(name = "EARLY_RESPONSE_START_WEEK", precision = 3, scale = 0)
	private Integer earlyResponseStartWeek;
	
	@Column(name = "EARLY_RESPONSE_FLAG", length = 1)
	private String earlyResponseFlag;
	
	@Column(name = "SEVERE_MATERNAL_FLAG", length = 1)
	private String severeMaternalFlag;
	
	
	@Column(name = "RISK_FACTOR_CODE", length = 3)
	private String riskFactorCode;
	
	@Column(name = "RISK_FACTOR_FLAG", length = 1)
	private String riskFactorFlag;
	
	@Column(name = "RISK_SCORE_DATE")
	private Date riskScoreDate;
	
	@Column(name = "RISK_SCORE_PRE_WEEK", precision = 5, scale = 0)
	private Integer riskScorePreWeek;
	
	@Column(name = "RISK_SCORE_VALUE", precision = 3, scale = 0)
	private Integer riskScoreValue;
	
	@Column(name = "RISK_PREGNANCY_LEVEL", length = 1)
	private String riskPregnancyLevel;
	
	@Column(name = "UTERINE_BOTTOM_HEIGHT", precision = 4, scale = 1)
	private BigDecimal uterineBottomHeight;
	
	@Column(name = "EXTERNAL_CONJUGATE", precision = 3, scale = 1)
	private BigDecimal externalConjugate;
	
	@Column(name = "INTER_SPINOUS_DIAMETER", precision = 4, scale = 1)
	private BigDecimal interSpinousDiameter;
	
	@Column(name = "INTER_CRESTAL_DIAMETER", precision = 4, scale = 1)
	private BigDecimal interCrestalDiameter;
	
	@Column(name = "CHIAL_TUBEROSITY_DIAMETER", precision = 4, scale = 1)
	private BigDecimal chialTuberosityDiameter;
	
	@Column(name = "PELVIMETRY_DATE")
	private Date pelvimetryDate;
	
	@Column(name = "PELVIMETRY_PRE_WEEK", precision = 5, scale = 0)
	private Integer pelvimetryPreWeek;
	
	@Column(name = "ORAL_EXAMINATION_RESULT", length = 300)
	private String oralExaminationResult;
	
	@Column(name = "CARDIAC_AUSCU_RESULT", length = 300)
	private String cardiacAuscuResult;
	
	@Column(name = "LUNG_AUSCU_RESULT", length = 300)
	private String lungAuscuResult;
	
	@Column(name = "LIVER_PALP_RESULT", length = 300)
	private String liverPalpResult;
	
	@Column(name = "SPLEEN_PALP_RESULT", length = 300)
	private String spleenPalpResult;
	
	@Column(name = "CERVIX_CHECK_RESULT", length = 300)
	private String cervixCheckResult;
	
	@Column(name = "VAGINA_CHECK_RESULT", length = 300)
	private String vaginaCheckResult;
	
	@Column(name = "PERINEUM_CUT_FLAG", length = 1)
	private String perineumCutFlag;
	
	@Column(name = "PERINEUM_TEAR_NEEDLE_NUMBER", precision = 5, scale = 0)
	private Integer perineumTearNeedleNumber;
	
	@Column(name = "PERINEUM_TEAR_DEGREE", length = 1)
	private String perineumTearDegree;
	
	@Column(name = "UTERUS_CHECK_RESULT", length = 300)
	private String uterusCheckResult;
	
	@Column(name = "L_ATTACHMENT_CHECK_RESULT", length = 1)
	private String lAttachmentCheckResult;
	
	@Column(name = "R_ATTACHMENT_CHECK_RESULT", length = 1)
	private String rAttachmentCheckResult;
	
	@Column(name = "L_BREAST_CHECK_RESULT", length = 1)
	private String lBreastCheckResult;
	
	@Column(name = "R_BREAST_CHECK_RESULT", length = 1)
	private String rBreastCheckResult;
	
	@Column(name = "SPINE_CHECK_RESULT", length = 300)
	private String spineCheckResult;
	
	@Column(name = "THYROID_CHECK_RESULT", length = 300)
	private String thyroidCheckResult;
	
	@Column(name = "SKIN_HAIR_CHECK_RESULT", length = 300)
	private String skinHairCheckResult;
	
	@Column(name = "UMBILICUS_CHECK_RESULT", length = 300)
	private String umbilicusCheckResult;
	
	@Column(name = "VULVA_CHECK_RESULT", length = 300)
	private String vulvaCheckResult;
	
	@Column(name = "NIPPLE_CHECK_RESULT", length = 300)
	private String nippleCheckResult;
	
	@Column(name = "MILK_VOLUME_CODE", length = 1)
	private String milkVolumeCode;
	
	@Column(name = "LIMBS_CHECK_RESULT", length = 300)
	private String limbsCheckResult;
	
	@Column(name = "EDEMA_DEGREE_CODE", length = 1)
	private String edemaDegreeCode;
	
	@Column(name = "JOIN_FLAG", length = 1)
	private String joinFlag;
	
	@Column(name = "BMODE_CHECK_RESULT", length = 300)
	private String bmodeCheckResult;
	
	@Column(name = "NEONATAL_SLEEP_CONDITION", length = 300)
	private String neonatalSleepCondition;
	
	@Column(name = "FETAL_PREGNANT_WEEK", precision = 3, scale = 0)
	private Integer fetalPregnantWeek;
	
	@Column(name = "FETAL_POSITION", length = 2)
	private String fetalPosition;
	
	@Column(name = "GESTATIONAL_NUMBER", precision = 3, scale = 0)
	private Integer gestationalNumber;
	
	@Column(name = "FETAL_CODE", length = 1)
	private String fetalCode;
	
	@Column(name = "ABO_BLOOD_TYPE", length = 1)
	private String aboBloodType;
	
	@Column(name = "RH_BLOOD_TYPE", length = 1)
	private String rhBloodType;
	
	@Column(name = "NEONATAL_JAUNDICE_DEGREE", length = 1)
	private String neonatalJaundiceDegree;
	
	@Column(name = "LIVER_DETECT_RESULT", length = 1)
	private String liverDetectResult;
	
	@Column(name = "RENAL_DETECT_RESULT", length = 1)
	private String renalDetectResult;
	
	@Column(name = "SERUM_BHCG_VALUE", precision = 4, scale = 1)
	private BigDecimal serumBhcgValue;
	
	@Column(name = "BLOOD_GLUCOSE_VALUES", precision = 4, scale = 1)
	private BigDecimal bloodGlucoseValues;
	
	@Column(name = "LEUKOCYTE_COUNT", precision = 4, scale = 1)
	private BigDecimal leukocyteCount;
	
	@Column(name = "ERYTHROCYTE_COUNT", precision = 3, scale = 1)
	private BigDecimal erythrocyteCount;
	
	@Column(name = "PLATELET_COUNT", precision = 5, scale = 0)
	private Integer plateletCount;
	
	@Column(name = "BLEEDING_TIME", precision = 5, scale = 0)
	private Integer bleedingTime;
	
	@Column(name = "COAGULATION_TIME", precision = 5, scale = 0)
	private Integer coagulationTime;
	
	@Column(name = "HEMOGLOBIN_VALUE", precision = 5, scale = 0)
	private Integer hemoglobinValue;
	
	@Column(name = "SERUM_GPT_VALUE", precision = 5, scale = 0)
	private Integer serumGptValue;
	
	@Column(name = "URINE_PROPORTION", precision = 5, scale = 3)
	private BigDecimal urineProportion;
	
	@Column(name = "URINE_PRO_QUANTITATIVE_VALUE", precision = 5, scale = 1)
	private BigDecimal urineProQuantitativeValue;
	
	@Column(name = "URINE_SUG_QUANTITATIVE_DETECT", precision = 4, scale = 1)
	private BigDecimal urineSugQuantitativeDetect;
	
	@Column(name = "URINE_PH", precision = 4, scale = 1)
	private BigDecimal urinePh;
	
	@Column(name = "VAGINA_SECRETIONS_DESC", length = 300)
	private String vaginaSecretionsDesc;
	
	@Column(name = "TRICHOMO_DETECT_RESULT", length = 1)
	private String trichomoDetectResult;
	
	@Column(name = "CANDIDA_DETECT_RESULT", length = 1)
	private String candidaDetectResult;
	
	@Column(name = "VAGINA_SECRETIONS_CLEANLINESS", length = 1)
	private String vaginaSecretionsCleanliness;
	
	@Column(name = "HBSAG_DETECT_RESULT", length = 1)
	private String hbsagDetectResult;
	
	@Column(name = "SYPHILIS_SEROLOGY_CHECK_RESULT", length = 1)
	private String syphilisSerologyCheckResult;
	
	@Column(name = "N_GONORRHOEAE_CHECK_RESULT", length = 300)
	private String NGonorrhoeaeCheckResult;
	
	@Column(name = "HIVLG_DETECT_RESULT", length = 1)
	private String hivlgDetectResult;
	
	@Column(name = "FEEDING_TYPE", length = 1)
	private String feedingType;
	
	@Column(name = "HIP_RED_FLAG", length = 1)
	private String hipRedFlag;
	
	@Column(name = "APGAR_VALUE", precision = 3, scale = 0)
	private Integer apgarValue;
	
	@Column(name = "NEONATAL_PEERE_CORD", length = 300)
	private String neonatalPeereCord;
	
	@Column(name = "NEONATAL_FECAL_RECORD", length = 300)
	private String neonatalFecalRecord;
	
	@Column(name = "NEONATAL_SPECIAL_CASE", length = 300)
	private String neonatalSpecialCase;
	
	@Column(name = "AE_RESULT", length = 300)
	private String aeResult;
	
	@Column(name = "AE_ITEM_NAME", length = 300)
	private String aeItemName;
	
	@Column(name = "POSTPARTUM_DAYS_CHECK_RESULT", length = 300)
	private String postpartumDaysCheckResult;
	
	@Column(name = "REFERRAL_RECORD", length = 300)
	private String referralRecord;
	
	@Column(name = "RISK_SCREEN_ORGAN_NAME", length = 210)
	private String riskScreenOrganName;
	
	@Column(name = "RISK_PREG_PROG_CODE", length = 1)
	private String riskPregProgCode;
	
	@Column(name = "COMPLICATION_HISTORY", length = 300)
	private String complicationHistory;
	
	@Column(name = "PREG_DIAGNOSIS_WAY", length = 1)
	private String pregDiagnosisWay;
	
	@Column(name = "WOUND_HEALING_STATUS", length = 1)
	private String woundHealingStatus;
	
	@Column(name = "BIRTH_DEFECT_FLAG", length = 1)
	private String birthDefectFlag;
	
	@Column(name = "BIRTH_DEFECT_TYPE", length = 2)
	private String birthDefectType;
	
	@Column(name = "BIRTH_DEFECTS_NUMBER", precision = 3, scale = 0)
	private Integer birthDefectsNumber;
	
	@Column(name = "NEONATAL_COMPLICATIONS_FLAG", length = 1)
	private String neonatalComplicationsFlag;
	
	@Column(name = "NEONATAL_COMPLICATIONS_CODE", length = 7)
	private String neonatalComplicationsCode;
	
	@Column(name = "NEONATAL_SCREENING_FLAG", length = 1)
	private String neonatalScreeningFlag;
	
	@Column(name = "NEONATAL_RESCUE_FLAG", length = 1)
	private String neonatalRescueFlag;
	
	@Column(name = "NEONATAL_RESCUE_METHOD", length = 1)
	private String neonatalRescueMethod;
	
	@Column(name = "MATERNAL_DEATHTIME_TYPE", length = 1)
	private String maternalDeathtimeType;
	
	@Column(name = "MG_OPINION", length = 300)
	private String mgOpinion;
	
	@Column(name = "MATERNAL_MG_OPINION", length = 300)
	private String maternalMgOpinion;
	
	@Column(name = "FAMILY_PLAN_GUIDANCE", length = 300)
	private String familyPlanGuidance;
	
	@Column(name = "MISSIONARY_CONTENT", length = 300)
	private String missionaryContent;
	
	@Column(name = "CHECK_NAME", length = 90)
	private String checkName;
	
    @Column(name = "CHECK_JOB_NUMBER", columnDefinition = "VARCHAR2|检查人员工号||", length = 50, nullable = true)
    private String checkJobNumber;
    
    @Column(name = "CHECK_IDCARD", columnDefinition = "VARCHAR2|检查人员身份证||", length = 18, nullable = true)
    private String checkIdcard;
	 
	
	@Column(name = "CHECK_ORGAN_NAME", length = 210)
	private String checkOrganName;
	
	@Column(name = "CHECK_DATE")
	private Date checkDate;
	
	@Column(name = "MIDWIFERY_NAME", length = 90)
	private String midwiferyName;
	
	@Column(name = "MIDWIFERY_ORGAN_NAME", length = 210)
	private String midwiferyOrganName;
	
	@Column(name = "INPUT_GESTATIONAL_WEEK", precision = 5, scale = 0)
	private Integer inputGestationalWeek;
	
	@Column(name = "INPUT_NAME", length = 90)
	private String inputName;
	
	@Column(name = "INPUT_ORGAN_NAME", length = 210)
	private String inputOrganName;
	
	@Column(name = "CLOSED_DATE")
	private Date closedDate;
	
	@Column(name = "CLOSED_UNIT_NAME", length = 210)
	private String closedUnitName;
	
	@Column(name = "RESERVATION_DATE")
	private Date reservationDate;
	
	@Column(name = "INTERVIEW_DATE")
	private Date interviewDate;
	
	@Column(name = "INTERVIEW_NAME", length = 90)
	private String interviewName;
	
	@Column(name = "INTERVIEW_ORGAN_NAME", length = 210)
	private String interviewOrganName;
	
	@Column(name = "IS_DELETE", precision = 1, scale = 0)
	private Boolean isDelete;
	
  	@Column(name = "MOTHER_IDCARD", columnDefinition = "VARCHAR2|母亲身份证件-号码||", length = 18, nullable = true)
	private String motherIdcard;
	
	@Column(name = "BABY_CARD_NO", columnDefinition = "VARCHAR2|宝宝卡号||", length = 13, nullable = true)
	private String babyCardNo;
	
	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构代码||", length = 20, nullable = true)
	private String createOrganCode;
	
	@Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 70, nullable = true)
	private String createOrganName;
	
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";
	
	@Column(name = "PROCESS_STATUS1", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus1 = "0";
	
    @Column(name = "IS_ANALYSE", columnDefinition = "NUMBER|是否处理过敏史||", length = 1, nullable = true)
    private Integer isAnalyse = -1;
	
	@Transient
	private String lastMenstrualDateDesc;
	
	@Transient
	private String previousPregnancyEndDateDesc;
	
	@Transient
	private String menstrualBleedingTypeDesc;
	
	@Transient
	private String dysmenorrheaDegreeDesc;
	
	@Transient
	private String riskPregProgCodeDesc;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@XmlElement public String getEhrId() {
		return this.ehrId;
	}

	public void setEhrId(String ehrId) {
		this.ehrId = ehrId;
	}

	@XmlElement public String getRecordNumber() {
		return this.recordNumber;
	}

	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}

	public Long getPersonId() {
		return this.personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	@XmlElement public String getHealthFileNo() {
		return this.healthFileNo;
	}

	public void setHealthFileNo(String healthFileNo) {
		this.healthFileNo = healthFileNo;
	}

	@XmlElement public String getAdmissionNo() {
		return this.admissionNo;
	}

	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}

	@XmlElement public String getMotherName() {
		return this.motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@XmlElement public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	@XmlElement public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@XmlElement public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@XmlElement public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	@XmlElement public String getOtherIdcardType() {
		return this.otherIdcardType;
	}

	public void setOtherIdcardType(String otherIdcardType) {
		this.otherIdcardType = otherIdcardType;
	}

	@XmlElement public String getOtherIdcard() {
		return this.otherIdcard;
	}

	public void setOtherIdcard(String otherIdcard) {
		this.otherIdcard = otherIdcard;
	}

	@XmlElement public String getOccupationType() {
		return this.occupationType;
	}

	public void setOccupationType(String occupationType) {
		this.occupationType = occupationType;
	}

	@XmlElement public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	@XmlElement public String getSpouseName() {
		return this.spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	public Date getSpouseBirthday() {
		return this.spouseBirthday;
	}

	public void setSpouseBirthday(Date spouseBirthday) {
		this.spouseBirthday = spouseBirthday;
	}

	@XmlElement public String getSpouseNation() {
		return this.spouseNation;
	}

	public void setSpouseNation(String spouseNation) {
		this.spouseNation = spouseNation;
	}

	@XmlElement public String getSpouseEducation() {
		return this.spouseEducation;
	}

	public void setSpouseEducation(String spouseEducation) {
		this.spouseEducation = spouseEducation;
	}

	@XmlElement public String getSpouseIdcard() {
		return this.spouseIdcard;
	}

	public void setSpouseIdcard(String spouseIdcard) {
		this.spouseIdcard = spouseIdcard;
	}

	@XmlElement public String getSpouseOccupation() {
		return this.spouseOccupation;
	}

	public void setSpouseOccupation(String spouseOccupation) {
		this.spouseOccupation = spouseOccupation;
	}

	 @XmlElement public String getSpouseUnitName() {
		return this.spouseUnitName;
	}

	public void setSpouseUnitName(String spouseUnitName) {
		this.spouseUnitName = spouseUnitName;
	}

	 @XmlElement public String getNeonatalName() {
		return this.neonatalName;
	}

	public void setNeonatalName(String neonatalName) {
		this.neonatalName = neonatalName;
	}

	 @XmlElement public String getNeonatalGender() {
		return this.neonatalGender;
	}

	public void setNeonatalGender(String neonatalGender) {
		this.neonatalGender = neonatalGender;
	}

	 @XmlElement public String getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	 @XmlElement public String getHrstreet() {
		return this.hrstreet;
	}

	public void setHrstreet(String hrstreet) {
		this.hrstreet = hrstreet;
	}

	 @XmlElement public String getHrhouseNumber() {
		return this.hrhouseNumber;
	}

	public void setHrhouseNumber(String hrhouseNumber) {
		this.hrhouseNumber = hrhouseNumber;
	}

	 @XmlElement public String getHrprovince() {
		return this.hrprovince;
	}

	public void setHrprovince(String hrprovince) {
		this.hrprovince = hrprovince;
	}

	 @XmlElement public String getHrcity() {
		return this.hrcity;
	}

	public void setHrcity(String hrcity) {
		this.hrcity = hrcity;
	}

	 @XmlElement public String getHrcounty() {
		return this.hrcounty;
	}

	public void setHrcounty(String hrcounty) {
		this.hrcounty = hrcounty;
	}

	 @XmlElement public String getHrtownShip() {
		return this.hrtownShip;
	}

	public void setHrtownShip(String hrtownShip) {
		this.hrtownShip = hrtownShip;
	}

	@XmlElement public String getHrpostCode() {
		return this.hrpostCode;
	}

	public void setHrpostCode(String hrpostCode) {
		this.hrpostCode = hrpostCode;
	}

	@XmlElement public String getPastreet() {
		return this.pastreet;
	}

	public void setPastreet(String pastreet) {
		this.pastreet = pastreet;
	}

	@XmlElement public String getPahouseNumber() {
		return this.pahouseNumber;
	}

	public void setPahouseNumber(String pahouseNumber) {
		this.pahouseNumber = pahouseNumber;
	}

	@XmlElement public String getPaprovince() {
		return this.paprovince;
	}

	public void setPaprovince(String paprovince) {
		this.paprovince = paprovince;
	}

	@XmlElement public String getPacity() {
		return this.pacity;
	}

	public void setPacity(String pacity) {
		this.pacity = pacity;
	}

	@XmlElement public String getPacounty() {
		return this.pacounty;
	}

	public void setPacounty(String pacounty) {
		this.pacounty = pacounty;
	}

	@XmlElement public String getPatownShip() {
		return this.patownShip;
	}

	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}

	@XmlElement public String getPapostCode() {
		return this.papostCode;
	}

	public void setPapostCode(String papostCode) {
		this.papostCode = papostCode;
	}

	@XmlElement public String getPresentHistory() {
		return this.presentHistory;
	}

	public void setPresentHistory(String presentHistory) {
		this.presentHistory = presentHistory;
	}

	@XmlElement public String getPastMedicalHistory() {
		return this.pastMedicalHistory;
	}

	public void setPastMedicalHistory(String pastMedicalHistory) {
		this.pastMedicalHistory = pastMedicalHistory;
	}

	@XmlElement public String getOperationHistory() {
		return this.operationHistory;
	}

	public void setOperationHistory(String operationHistory) {
		this.operationHistory = operationHistory;
	}

	@XmlElement public String getAllergicHistory() {
		return this.allergicHistory;
	}

	public void setAllergicHistory(String allergicHistory) {
		this.allergicHistory = allergicHistory;
	}

	@XmlElement public String getFamilyGeneDiseaseHistory() {
		return this.familyGeneDiseaseHistory;
	}

	public void setFamilyGeneDiseaseHistory(String familyGeneDiseaseHistory) {
		this.familyGeneDiseaseHistory = familyGeneDiseaseHistory;
	}

	public Integer getMenarcheAge() {
		return this.menarcheAge;
	}

	public void setMenarcheAge(Integer menarcheAge) {
		this.menarcheAge = menarcheAge;
	}

	public Integer getMenstrualDuration() {
		return this.menstrualDuration;
	}

	public void setMenstrualDuration(Integer menstrualDuration) {
		this.menstrualDuration = menstrualDuration;
	}

	@XmlElement public String getMenstrualBleedingType() {
		return this.menstrualBleedingType;
	}

	public void setMenstrualBleedingType(String menstrualBleedingType) {
		this.menstrualBleedingType = menstrualBleedingType;
	}

	public Integer getMenstrualCycle() {
		return this.menstrualCycle;
	}

	public void setMenstrualCycle(Integer menstrualCycle) {
		this.menstrualCycle = menstrualCycle;
	}

	
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
	public Date getLastMenstrualDate() {
		return this.lastMenstrualDate;
	}

	public void setLastMenstrualDate(Date lastMenstrualDate) {
		this.lastMenstrualDate = lastMenstrualDate;
	}

	@XmlElement public String getDysmenorrheaDegree() {
		return this.dysmenorrheaDegree;
	}

	public void setDysmenorrheaDegree(String dysmenorrheaDegree) {
		this.dysmenorrheaDegree = dysmenorrheaDegree;
	}

	public Integer getGravidityTimes() {
		return this.gravidityTimes;
	}

	public void setGravidityTimes(Integer gravidityTimes) {
		this.gravidityTimes = gravidityTimes;
	}

	public Integer getProductionTimes() {
		return this.productionTimes;
	}

	public void setProductionTimes(Integer productionTimes) {
		this.productionTimes = productionTimes;
	}

	public Integer getPrematureDeliveryTimes() {
		return this.prematureDeliveryTimes;
	}

	public void setPrematureDeliveryTimes(Integer prematureDeliveryTimes) {
		this.prematureDeliveryTimes = prematureDeliveryTimes;
	}

	public Integer getSpontaneousAbortionTimes() {
		return this.spontaneousAbortionTimes;
	}

	public void setSpontaneousAbortionTimes(Integer spontaneousAbortionTimes) {
		this.spontaneousAbortionTimes = spontaneousAbortionTimes;
	}

	public Integer getArtificialAbortionTimes() {
		return this.artificialAbortionTimes;
	}

	public void setArtificialAbortionTimes(Integer artificialAbortionTimes) {
		this.artificialAbortionTimes = artificialAbortionTimes;
	}

	public Integer getCesareanSectionTimes() {
		return this.cesareanSectionTimes;
	}

	public void setCesareanSectionTimes(Integer cesareanSectionTimes) {
		this.cesareanSectionTimes = cesareanSectionTimes;
	}

	public Integer getVaginaDeliveryTimes() {
		return this.vaginaDeliveryTimes;
	}

	public void setVaginaDeliveryTimes(Integer vaginaDeliveryTimes) {
		this.vaginaDeliveryTimes = vaginaDeliveryTimes;
	}

	public Integer getStillbirthCasesNumber() {
		return this.stillbirthCasesNumber;
	}

	public void setStillbirthCasesNumber(Integer stillbirthCasesNumber) {
		this.stillbirthCasesNumber = stillbirthCasesNumber;
	}

	public Integer getStillbornCasesNumber() {
		return this.stillbornCasesNumber;
	}

	public void setStillbornCasesNumber(Integer stillbornCasesNumber) {
		this.stillbornCasesNumber = stillbornCasesNumber;
	}

	@XmlElement public String getPreviousChildbirthWay() {
		return this.previousChildbirthWay;
	}

	public void setPreviousChildbirthWay(String previousChildbirthWay) {
		this.previousChildbirthWay = previousChildbirthWay;
	}

	@XmlElement public String getPreviousPregnancyEndWay() {
		return this.previousPregnancyEndWay;
	}

	public void setPreviousPregnancyEndWay(String previousPregnancyEndWay) {
		this.previousPregnancyEndWay = previousPregnancyEndWay;
	}

	
	@XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
	public Date getPreviousChildbirthDate() {
		return this.previousChildbirthDate;
	}

	public void setPreviousChildbirthDate(Date previousChildbirthDate) {
		this.previousChildbirthDate = previousChildbirthDate;
	}

	
	@XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
	public Date getPreviousPregnancyEndDate() {
		return this.previousPregnancyEndDate;
	}

	public void setPreviousPregnancyEndDate(Date previousPregnancyEndDate) {
		this.previousPregnancyEndDate = previousPregnancyEndDate;
	}

	@XmlElement public String getDbp() {
		return this.dbp;
	}

	public void setDbp(String dbp) {
		this.dbp = dbp;
	}

	@XmlElement public String getSbp() {
		return this.sbp;
	}

	public void setSbp(String sbp) {
		this.sbp = sbp;
	}

	@XmlElement public String getBaseDbp() {
		return this.baseDbp;
	}

	public void setBaseDbp(String baseDbp) {
		this.baseDbp = baseDbp;
	}

	@XmlElement public String getBaseSbp() {
		return this.baseSbp;
	}

	public void setBaseSbp(String baseSbp) {
		this.baseSbp = baseSbp;
	}

	public BigDecimal getTemperature() {
		return this.temperature;
	}

	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public BigDecimal getBaseWeight() {
		return this.baseWeight;
	}

	public void setBaseWeight(BigDecimal baseWeight) {
		this.baseWeight = baseWeight;
	}

	public BigDecimal getAbdominalGirth() {
		return this.abdominalGirth;
	}

	public void setAbdominalGirth(BigDecimal abdominalGirth) {
		this.abdominalGirth = abdominalGirth;
	}

	@XmlElement public String getSymptom() {
		return this.symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	@XmlElement public String getSigns() {
		return this.signs;
	}

	public void setSigns(String signs) {
		this.signs = signs;
	}

	@XmlElement public String getHeartRate() {
		return this.heartRate;
	}

	public void setHeartRate(String heartRate) {
		this.heartRate = heartRate;
	}

	@XmlElement public String getFetalHeartRate() {
		return this.fetalHeartRate;
	}

	public void setFetalHeartRate(String fetalHeartRate) {
		this.fetalHeartRate = fetalHeartRate;
	}

	public Integer getDeliveryWeek() {
		return this.deliveryWeek;
	}

	public void setDeliveryWeek(Integer deliveryWeek) {
		this.deliveryWeek = deliveryWeek;
	}

	
	@XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
	public Date getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@XmlElement public String getDeliveryWay() {
		return this.deliveryWay;
	}

	public void setDeliveryWay(String deliveryWay) {
		this.deliveryWay = deliveryWay;
	}

	@XmlElement public String getDeliveryOutcome() {
		return this.deliveryOutcome;
	}

	public void setDeliveryOutcome(String deliveryOutcome) {
		this.deliveryOutcome = deliveryOutcome;
	}

	public Integer getTotalLaborRuntime() {
		return this.totalLaborRuntime;
	}

	public void setTotalLaborRuntime(Integer totalLaborRuntime) {
		this.totalLaborRuntime = totalLaborRuntime;
	}

	public Integer getFirstTotalLaborRuntime() {
		return this.firstTotalLaborRuntime;
	}

	public void setFirstTotalLaborRuntime(Integer firstTotalLaborRuntime) {
		this.firstTotalLaborRuntime = firstTotalLaborRuntime;
	}

	public Integer getSecondTotalLaborRuntime() {
		return this.secondTotalLaborRuntime;
	}

	public void setSecondTotalLaborRuntime(Integer secondTotalLaborRuntime) {
		this.secondTotalLaborRuntime = secondTotalLaborRuntime;
	}

	public Integer getThirdTotalLaborRuntime() {
		return this.thirdTotalLaborRuntime;
	}

	public void setThirdTotalLaborRuntime(Integer thirdTotalLaborRuntime) {
		this.thirdTotalLaborRuntime = thirdTotalLaborRuntime;
	}

	public Integer getPostpartumOpenMilkRuntime() {
		return this.postpartumOpenMilkRuntime;
	}

	public void setPostpartumOpenMilkRuntime(Integer postpartumOpenMilkRuntime) {
		this.postpartumOpenMilkRuntime = postpartumOpenMilkRuntime;
	}

	public Integer getPostpartumDays() {
		return this.postpartumDays;
	}

	public void setPostpartumDays(Integer postpartumDays) {
		this.postpartumDays = postpartumDays;
	}

	@XmlElement public String getComplicationsCode() {
		return this.complicationsCode;
	}

	public void setComplicationsCode(String complicationsCode) {
		this.complicationsCode = complicationsCode;
	}

	public Integer getDeliveryTotalBleed() {
		return this.deliveryTotalBleed;
	}

	public void setDeliveryTotalBleed(Integer deliveryTotalBleed) {
		this.deliveryTotalBleed = deliveryTotalBleed;
	}

	public Integer getDeliveryBleed() {
		return this.deliveryBleed;
	}

	public void setDeliveryBleed(Integer deliveryBleed) {
		this.deliveryBleed = deliveryBleed;
	}

	public Integer getDeliveryTwoBleed() {
		return this.deliveryTwoBleed;
	}

	public void setDeliveryTwoBleed(Integer deliveryTwoBleed) {
		this.deliveryTwoBleed = deliveryTwoBleed;
	}

	public BigDecimal getNeonatalTemperature() {
		return this.neonatalTemperature;
	}

	public void setNeonatalTemperature(BigDecimal neonatalTemperature) {
		this.neonatalTemperature = neonatalTemperature;
	}

	@XmlElement public String getNeonatalHeartRate() {
		return this.neonatalHeartRate;
	}

	public void setNeonatalHeartRate(String neonatalHeartRate) {
		this.neonatalHeartRate = neonatalHeartRate;
	}

	public Integer getNeonatalWeight() {
		return this.neonatalWeight;
	}

	public void setNeonatalWeight(Integer neonatalWeight) {
		this.neonatalWeight = neonatalWeight;
	}

	public BigDecimal getNeonatalStature() {
		return this.neonatalStature;
	}

	public void setNeonatalStature(BigDecimal neonatalStature) {
		this.neonatalStature = neonatalStature;
	}

	public BigDecimal getNeonatalHeight() {
		return this.neonatalHeight;
	}

	public void setNeonatalHeight(BigDecimal neonatalHeight) {
		this.neonatalHeight = neonatalHeight;
	}

	public BigDecimal getNeonatalHeadCircumference() {
		return this.neonatalHeadCircumference;
	}

	public void setNeonatalHeadCircumference(BigDecimal neonatalHeadCircumference) {
		this.neonatalHeadCircumference = neonatalHeadCircumference;
	}

	public BigDecimal getNeonatalBust() {
		return this.neonatalBust;
	}

	public void setNeonatalBust(BigDecimal neonatalBust) {
		this.neonatalBust = neonatalBust;
	}

	@XmlElement public String getNeonatalCardiacAuscuResult() {
		return this.neonatalCardiacAuscuResult;
	}

	public void setNeonatalCardiacAuscuResult(String neonatalCardiacAuscuResult) {
		this.neonatalCardiacAuscuResult = neonatalCardiacAuscuResult;
	}

	@XmlElement public String getNeonatalLungAuscuResult() {
		return this.neonatalLungAuscuResult;
	}

	public void setNeonatalLungAuscuResult(String neonatalLungAuscuResult) {
		this.neonatalLungAuscuResult = neonatalLungAuscuResult;
	}

	@XmlElement public String getLochiaCondition() {
		return this.lochiaCondition;
	}

	public void setLochiaCondition(String lochiaCondition) {
		this.lochiaCondition = lochiaCondition;
	}

	@XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
	public Date getEstimatedDueDates() {
		return this.estimatedDueDates;
	}

	public void setEstimatedDueDates(Date estimatedDueDates) {
		this.estimatedDueDates = estimatedDueDates;
	}

	@XmlElement public String getPregnancyAnomaliesRecord() {
		return this.pregnancyAnomaliesRecord;
	}

	public void setPregnancyAnomaliesRecord(String pregnancyAnomaliesRecord) {
		this.pregnancyAnomaliesRecord = pregnancyAnomaliesRecord;
	}

	public Integer getEarlyResponseStartWeek() {
		return this.earlyResponseStartWeek;
	}

	public void setEarlyResponseStartWeek(Integer earlyResponseStartWeek) {
		this.earlyResponseStartWeek = earlyResponseStartWeek;
	}

	@XmlElement public String getEarlyResponseFlag() {
		return this.earlyResponseFlag;
	}

	public void setEarlyResponseFlag(String earlyResponseFlag) {
		this.earlyResponseFlag = earlyResponseFlag;
	}

	@XmlElement public String getSevereMaternalFlag() {
		return this.severeMaternalFlag;
	}

	public void setSevereMaternalFlag(String severeMaternalFlag) {
		this.severeMaternalFlag = severeMaternalFlag;
	}

	@XmlElement
	public String getRiskFactorCode() {
		return this.riskFactorCode;
	}

	public void setRiskFactorCode(String riskFactorCode) {
		this.riskFactorCode = riskFactorCode;
	}

	
	@XmlElement public String getRiskFactorFlag() {
		return this.riskFactorFlag;
	}

	public void setRiskFactorFlag(String riskFactorFlag) {
		this.riskFactorFlag = riskFactorFlag;
	}

	
	
	@XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
	public Date getRiskScoreDate() {
		return this.riskScoreDate;
	}

	public void setRiskScoreDate(Date riskScoreDate) {
		this.riskScoreDate = riskScoreDate;
	}

	
	@XmlElement
	public Integer getRiskScorePreWeek() {
		return this.riskScorePreWeek;
	}

	public void setRiskScorePreWeek(Integer riskScorePreWeek) {
		this.riskScorePreWeek = riskScorePreWeek;
	}

	
	@XmlElement
	public Integer getRiskScoreValue() {
		return this.riskScoreValue;
	}

	public void setRiskScoreValue(Integer riskScoreValue) {
		this.riskScoreValue = riskScoreValue;
	}

	
	@XmlElement public String getRiskPregnancyLevel() {
		return this.riskPregnancyLevel;
	}

	public void setRiskPregnancyLevel(String riskPregnancyLevel) {
		this.riskPregnancyLevel = riskPregnancyLevel;
	}


	@XmlElement
	public BigDecimal getUterineBottomHeight() {
		return this.uterineBottomHeight;
	}

	public void setUterineBottomHeight(BigDecimal uterineBottomHeight) {
		this.uterineBottomHeight = uterineBottomHeight;
	}

	
	@XmlElement
	public BigDecimal getExternalConjugate() {
		return this.externalConjugate;
	}

	public void setExternalConjugate(BigDecimal externalConjugate) {
		this.externalConjugate = externalConjugate;
	}

	
	@XmlElement
	public BigDecimal getInterSpinousDiameter() {
		return this.interSpinousDiameter;
	}

	public void setInterSpinousDiameter(BigDecimal interSpinousDiameter) {
		this.interSpinousDiameter = interSpinousDiameter;
	}

	
	@XmlElement
	public BigDecimal getInterCrestalDiameter() {
		return this.interCrestalDiameter;
	}

	public void setInterCrestalDiameter(BigDecimal interCrestalDiameter) {
		this.interCrestalDiameter = interCrestalDiameter;
	}

	
	@XmlElement
	public BigDecimal getChialTuberosityDiameter() {
		return this.chialTuberosityDiameter;
	}

	public void setChialTuberosityDiameter(BigDecimal chialTuberosityDiameter) {
		this.chialTuberosityDiameter = chialTuberosityDiameter;
	}

	
	
	@XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
	public Date getPelvimetryDate() {
		return this.pelvimetryDate;
	}

	public void setPelvimetryDate(Date pelvimetryDate) {
		this.pelvimetryDate = pelvimetryDate;
	}

	
	@XmlElement
	public Integer getPelvimetryPreWeek() {
		return this.pelvimetryPreWeek;
	}

	public void setPelvimetryPreWeek(Integer pelvimetryPreWeek) {
		this.pelvimetryPreWeek = pelvimetryPreWeek;
	}

	
	@XmlElement public String getOralExaminationResult() {
		return this.oralExaminationResult;
	}

	public void setOralExaminationResult(String oralExaminationResult) {
		this.oralExaminationResult = oralExaminationResult;
	}

	
	@XmlElement public String getCardiacAuscuResult() {
		return this.cardiacAuscuResult;
	}

	public void setCardiacAuscuResult(String cardiacAuscuResult) {
		this.cardiacAuscuResult = cardiacAuscuResult;
	}

	
	@XmlElement public String getLungAuscuResult() {
		return this.lungAuscuResult;
	}

	public void setLungAuscuResult(String lungAuscuResult) {
		this.lungAuscuResult = lungAuscuResult;
	}

	
	@XmlElement public String getLiverPalpResult() {
		return this.liverPalpResult;
	}

	public void setLiverPalpResult(String liverPalpResult) {
		this.liverPalpResult = liverPalpResult;
	}

	
	@XmlElement public String getSpleenPalpResult() {
		return this.spleenPalpResult;
	}

	public void setSpleenPalpResult(String spleenPalpResult) {
		this.spleenPalpResult = spleenPalpResult;
	}

	
	@XmlElement public String getCervixCheckResult() {
		return this.cervixCheckResult;
	}

	public void setCervixCheckResult(String cervixCheckResult) {
		this.cervixCheckResult = cervixCheckResult;
	}

	
	@XmlElement public String getVaginaCheckResult() {
		return this.vaginaCheckResult;
	}

	public void setVaginaCheckResult(String vaginaCheckResult) {
		this.vaginaCheckResult = vaginaCheckResult;
	}

	
	@XmlElement public String getPerineumCutFlag() {
		return this.perineumCutFlag;
	}

	public void setPerineumCutFlag(String perineumCutFlag) {
		this.perineumCutFlag = perineumCutFlag;
	}

	
	@XmlElement
	public Integer getPerineumTearNeedleNumber() {
		return this.perineumTearNeedleNumber;
	}

	public void setPerineumTearNeedleNumber(Integer perineumTearNeedleNumber) {
		this.perineumTearNeedleNumber = perineumTearNeedleNumber;
	}

	
	@XmlElement public String getPerineumTearDegree() {
		return this.perineumTearDegree;
	}

	public void setPerineumTearDegree(String perineumTearDegree) {
		this.perineumTearDegree = perineumTearDegree;
	}

	
	@XmlElement public String getUterusCheckResult() {
		return this.uterusCheckResult;
	}

	public void setUterusCheckResult(String uterusCheckResult) {
		this.uterusCheckResult = uterusCheckResult;
	}

	
	@XmlElement
	public String getlAttachmentCheckResult() {
		return lAttachmentCheckResult;
	}
	
	
	public void setlAttachmentCheckResult(String lAttachmentCheckResult) {
		this.lAttachmentCheckResult = lAttachmentCheckResult;
	}
	

	
	@XmlElement 
	public String getrAttachmentCheckResult() {
		return rAttachmentCheckResult;
	}
	
	public void setrAttachmentCheckResult(String rAttachmentCheckResult) {
		this.rAttachmentCheckResult = rAttachmentCheckResult;
	}


	
	@XmlElement
	public String getlBreastCheckResult() {
		return lBreastCheckResult;
	}

	public void setlBreastCheckResult(String lBreastCheckResult) {
		this.lBreastCheckResult = lBreastCheckResult;
	}

	
	@XmlElement
	public String getrBreastCheckResult() {
		return rBreastCheckResult;
	}

	
	public void setrBreastCheckResult(String rBreastCheckResult) {
		this.rBreastCheckResult = rBreastCheckResult;
	}


	
	@XmlElement public String getSpineCheckResult() {
		return this.spineCheckResult;
	}

	public void setSpineCheckResult(String spineCheckResult) {
		this.spineCheckResult = spineCheckResult;
	}

	
	@XmlElement public String getThyroidCheckResult() {
		return this.thyroidCheckResult;
	}

	public void setThyroidCheckResult(String thyroidCheckResult) {
		this.thyroidCheckResult = thyroidCheckResult;
	}

	
	@XmlElement public String getSkinHairCheckResult() {
		return this.skinHairCheckResult;
	}

	public void setSkinHairCheckResult(String skinHairCheckResult) {
		this.skinHairCheckResult = skinHairCheckResult;
	}

	
	@XmlElement public String getUmbilicusCheckResult() {
		return this.umbilicusCheckResult;
	}

	public void setUmbilicusCheckResult(String umbilicusCheckResult) {
		this.umbilicusCheckResult = umbilicusCheckResult;
	}

	
	@XmlElement public String getVulvaCheckResult() {
		return this.vulvaCheckResult;
	}

	public void setVulvaCheckResult(String vulvaCheckResult) {
		this.vulvaCheckResult = vulvaCheckResult;
	}

	
	@XmlElement public String getNippleCheckResult() {
		return this.nippleCheckResult;
	}

	public void setNippleCheckResult(String nippleCheckResult) {
		this.nippleCheckResult = nippleCheckResult;
	}

	
	@XmlElement public String getMilkVolumeCode() {
		return this.milkVolumeCode;
	}

	public void setMilkVolumeCode(String milkVolumeCode) {
		this.milkVolumeCode = milkVolumeCode;
	}

	
	@XmlElement public String getLimbsCheckResult() {
		return this.limbsCheckResult;
	}

	public void setLimbsCheckResult(String limbsCheckResult) {
		this.limbsCheckResult = limbsCheckResult;
	}

	
	@XmlElement public String getEdemaDegreeCode() {
		return this.edemaDegreeCode;
	}

	public void setEdemaDegreeCode(String edemaDegreeCode) {
		this.edemaDegreeCode = edemaDegreeCode;
	}

	
	@XmlElement public String getJoinFlag() {
		return this.joinFlag;
	}

	public void setJoinFlag(String joinFlag) {
		this.joinFlag = joinFlag;
	}

	
	@XmlElement public String getBmodeCheckResult() {
		return this.bmodeCheckResult;
	}

	public void setBmodeCheckResult(String bmodeCheckResult) {
		this.bmodeCheckResult = bmodeCheckResult;
	}

	
	@XmlElement public String getNeonatalSleepCondition() {
		return this.neonatalSleepCondition;
	}

	public void setNeonatalSleepCondition(String neonatalSleepCondition) {
		this.neonatalSleepCondition = neonatalSleepCondition;
	}

	
	@XmlElement
	public Integer getFetalPregnantWeek() {
		return this.fetalPregnantWeek;
	}

	public void setFetalPregnantWeek(Integer fetalPregnantWeek) {
		this.fetalPregnantWeek = fetalPregnantWeek;
	}

	
	@XmlElement public String getFetalPosition() {
		return this.fetalPosition;
	}

	public void setFetalPosition(String fetalPosition) {
		this.fetalPosition = fetalPosition;
	}

	
	@XmlElement
	public Integer getGestationalNumber() {
		return this.gestationalNumber;
	}

	public void setGestationalNumber(Integer gestationalNumber) {
		this.gestationalNumber = gestationalNumber;
	}

	
	@XmlElement public String getFetalCode() {
		return this.fetalCode;
	}

	public void setFetalCode(String fetalCode) {
		this.fetalCode = fetalCode;
	}

	
	@XmlElement public String getAboBloodType() {
		return this.aboBloodType;
	}

	public void setAboBloodType(String aboBloodType) {
		this.aboBloodType = aboBloodType;
	}

	
	@XmlElement public String getRhBloodType() {
		return this.rhBloodType;
	}

	public void setRhBloodType(String rhBloodType) {
		this.rhBloodType = rhBloodType;
	}

	
	@XmlElement public String getNeonatalJaundiceDegree() {
		return this.neonatalJaundiceDegree;
	}

	public void setNeonatalJaundiceDegree(String neonatalJaundiceDegree) {
		this.neonatalJaundiceDegree = neonatalJaundiceDegree;
	}

	
	@XmlElement public String getLiverDetectResult() {
		return this.liverDetectResult;
	}

	public void setLiverDetectResult(String liverDetectResult) {
		this.liverDetectResult = liverDetectResult;
	}

	
	@XmlElement public String getRenalDetectResult() {
		return this.renalDetectResult;
	}

	public void setRenalDetectResult(String renalDetectResult) {
		this.renalDetectResult = renalDetectResult;
	}

	
	@XmlElement
	public BigDecimal getSerumBhcgValue() {
		return this.serumBhcgValue;
	}

	public void setSerumBhcgValue(BigDecimal serumBhcgValue) {
		this.serumBhcgValue = serumBhcgValue;
	}

		
	@XmlElement
	public BigDecimal getBloodGlucoseValues() {
		return this.bloodGlucoseValues;
	}

	public void setBloodGlucoseValues(BigDecimal bloodGlucoseValues) {
		this.bloodGlucoseValues = bloodGlucoseValues;
	}

	
	@XmlElement
	public BigDecimal getLeukocyteCount() {
		return this.leukocyteCount;
	}

	public void setLeukocyteCount(BigDecimal leukocyteCount) {
		this.leukocyteCount = leukocyteCount;
	}

	
	@XmlElement
	public BigDecimal getErythrocyteCount() {
		return this.erythrocyteCount;
	}

	public void setErythrocyteCount(BigDecimal erythrocyteCount) {
		this.erythrocyteCount = erythrocyteCount;
	}

	
	@XmlElement
	public Integer getPlateletCount() {
		return this.plateletCount;
	}

	public void setPlateletCount(Integer plateletCount) {
		this.plateletCount = plateletCount;
	}

	
	@XmlElement
	public Integer getBleedingTime() {
		return this.bleedingTime;
	}

	public void setBleedingTime(Integer bleedingTime) {
		this.bleedingTime = bleedingTime;
	}

	
	@XmlElement
	public Integer getCoagulationTime() {
		return this.coagulationTime;
	}

	public void setCoagulationTime(Integer coagulationTime) {
		this.coagulationTime = coagulationTime;
	}

	
	@XmlElement
	public Integer getHemoglobinValue() {
		return this.hemoglobinValue;
	}

	public void setHemoglobinValue(Integer hemoglobinValue) {
		this.hemoglobinValue = hemoglobinValue;
	}

	
	@XmlElement
	public Integer getSerumGptValue() {
		return this.serumGptValue;
	}

	public void setSerumGptValue(Integer serumGptValue) {
		this.serumGptValue = serumGptValue;
	}

	
	@XmlElement
	public BigDecimal getUrineProportion() {
		return this.urineProportion;
	}

	public void setUrineProportion(BigDecimal urineProportion) {
		this.urineProportion = urineProportion;
	}

	
	@XmlElement
	public BigDecimal getUrineProQuantitativeValue() {
		return this.urineProQuantitativeValue;
	}

	public void setUrineProQuantitativeValue(BigDecimal urineProQuantitativeValue) {
		this.urineProQuantitativeValue = urineProQuantitativeValue;
	}

	@XmlElement
	public BigDecimal getUrineSugQuantitativeDetect() {
		return this.urineSugQuantitativeDetect;
	}

	public void setUrineSugQuantitativeDetect(BigDecimal urineSugQuantitativeDetect) {
		this.urineSugQuantitativeDetect = urineSugQuantitativeDetect;
	}

	@XmlElement
	public BigDecimal getUrinePh() {
		return this.urinePh;
	}

	public void setUrinePh(BigDecimal urinePh) {
		this.urinePh = urinePh;
	}

	
	@XmlElement public String getVaginaSecretionsDesc() {
		return this.vaginaSecretionsDesc;
	}

	public void setVaginaSecretionsDesc(String vaginaSecretionsDesc) {
		this.vaginaSecretionsDesc = vaginaSecretionsDesc;
	}

	
	@XmlElement public String getTrichomoDetectResult() {
		return this.trichomoDetectResult;
	}

	public void setTrichomoDetectResult(String trichomoDetectResult) {
		this.trichomoDetectResult = trichomoDetectResult;
	}

	
	@XmlElement public String getCandidaDetectResult() {
		return this.candidaDetectResult;
	}

	public void setCandidaDetectResult(String candidaDetectResult) {
		this.candidaDetectResult = candidaDetectResult;
	}

	
	@XmlElement public String getVaginaSecretionsCleanliness() {
		return this.vaginaSecretionsCleanliness;
	}

	public void setVaginaSecretionsCleanliness(
			String vaginaSecretionsCleanliness) {
		this.vaginaSecretionsCleanliness = vaginaSecretionsCleanliness;
	}

	
	@XmlElement public String getHbsagDetectResult() {
		return this.hbsagDetectResult;
	}

	public void setHbsagDetectResult(String hbsagDetectResult) {
		this.hbsagDetectResult = hbsagDetectResult;
	}

	
	@XmlElement public String getSyphilisSerologyCheckResult() {
		return this.syphilisSerologyCheckResult;
	}

	public void setSyphilisSerologyCheckResult(
			String syphilisSerologyCheckResult) {
		this.syphilisSerologyCheckResult = syphilisSerologyCheckResult;
	}

	
	@XmlElement public String getNGonorrhoeaeCheckResult() {
		return this.NGonorrhoeaeCheckResult;
	}

	public void setNGonorrhoeaeCheckResult(String NGonorrhoeaeCheckResult) {
		this.NGonorrhoeaeCheckResult = NGonorrhoeaeCheckResult;
	}

	
	@XmlElement public String getHivlgDetectResult() {
		return this.hivlgDetectResult;
	}

	public void setHivlgDetectResult(String hivlgDetectResult) {
		this.hivlgDetectResult = hivlgDetectResult;
	}

	
	@XmlElement public String getFeedingType() {
		return this.feedingType;
	}

	public void setFeedingType(String feedingType) {
		this.feedingType = feedingType;
	}

	
	@XmlElement public String getHipRedFlag() {
		return this.hipRedFlag;
	}

	public void setHipRedFlag(String hipRedFlag) {
		this.hipRedFlag = hipRedFlag;
	}

	
	public Integer getApgarValue() {
		return this.apgarValue;
	}

	public void setApgarValue(Integer apgarValue) {
		this.apgarValue = apgarValue;
	}

	
	@XmlElement public String getNeonatalPeereCord() {
		return this.neonatalPeereCord;
	}

	public void setNeonatalPeereCord(String neonatalPeereCord) {
		this.neonatalPeereCord = neonatalPeereCord;
	}

	
	@XmlElement public String getNeonatalFecalRecord() {
		return this.neonatalFecalRecord;
	}

	public void setNeonatalFecalRecord(String neonatalFecalRecord) {
		this.neonatalFecalRecord = neonatalFecalRecord;
	}

	
	@XmlElement public String getNeonatalSpecialCase() {
		return this.neonatalSpecialCase;
	}

	public void setNeonatalSpecialCase(String neonatalSpecialCase) {
		this.neonatalSpecialCase = neonatalSpecialCase;
	}

	
	@XmlElement public String getAeResult() {
		return this.aeResult;
	}

	public void setAeResult(String aeResult) {
		this.aeResult = aeResult;
	}

	
	@XmlElement public String getAeItemName() {
		return this.aeItemName;
	}

	public void setAeItemName(String aeItemName) {
		this.aeItemName = aeItemName;
	}

	
	@XmlElement public String getPostpartumDaysCheckResult() {
		return this.postpartumDaysCheckResult;
	}

	public void setPostpartumDaysCheckResult(String postpartumDaysCheckResult) {
		this.postpartumDaysCheckResult = postpartumDaysCheckResult;
	}

	
	@XmlElement public String getReferralRecord() {
		return this.referralRecord;
	}

	public void setReferralRecord(String referralRecord) {
		this.referralRecord = referralRecord;
	}

	
	@XmlElement public String getRiskScreenOrganName() {
		return this.riskScreenOrganName;
	}

	public void setRiskScreenOrganName(String riskScreenOrganName) {
		this.riskScreenOrganName = riskScreenOrganName;
	}

	
	@XmlElement public String getRiskPregProgCode() {
		return this.riskPregProgCode;
	}

	public void setRiskPregProgCode(String riskPregProgCode) {
		this.riskPregProgCode = riskPregProgCode;
	}

	
	@XmlElement public String getComplicationHistory() {
		return this.complicationHistory;
	}

	public void setComplicationHistory(String complicationHistory) {
		this.complicationHistory = complicationHistory;
	}

	
	@XmlElement public String getPregDiagnosisWay() {
		return this.pregDiagnosisWay;
	}

	public void setPregDiagnosisWay(String pregDiagnosisWay) {
		this.pregDiagnosisWay = pregDiagnosisWay;
	}

	
	@XmlElement public String getWoundHealingStatus() {
		return this.woundHealingStatus;
	}

	public void setWoundHealingStatus(String woundHealingStatus) {
		this.woundHealingStatus = woundHealingStatus;
	}

	
	@XmlElement public String getBirthDefectFlag() {
		return this.birthDefectFlag;
	}

	public void setBirthDefectFlag(String birthDefectFlag) {
		this.birthDefectFlag = birthDefectFlag;
	}

	
	@XmlElement public String getBirthDefectType() {
		return this.birthDefectType;
	}

	public void setBirthDefectType(String birthDefectType) {
		this.birthDefectType = birthDefectType;
	}

	
	@XmlElement
	public Integer getBirthDefectsNumber() {
		return this.birthDefectsNumber;
	}

	public void setBirthDefectsNumber(Integer birthDefectsNumber) {
		this.birthDefectsNumber = birthDefectsNumber;
	}

	
	@XmlElement public String getNeonatalComplicationsFlag() {
		return this.neonatalComplicationsFlag;
	}

	public void setNeonatalComplicationsFlag(String neonatalComplicationsFlag) {
		this.neonatalComplicationsFlag = neonatalComplicationsFlag;
	}

	
	@XmlElement public String getNeonatalComplicationsCode() {
		return this.neonatalComplicationsCode;
	}

	public void setNeonatalComplicationsCode(String neonatalComplicationsCode) {
		this.neonatalComplicationsCode = neonatalComplicationsCode;
	}

	
	@XmlElement public String getNeonatalScreeningFlag() {
		return this.neonatalScreeningFlag;
	}

	public void setNeonatalScreeningFlag(String neonatalScreeningFlag) {
		this.neonatalScreeningFlag = neonatalScreeningFlag;
	}

	
	@XmlElement public String getNeonatalRescueFlag() {
		return this.neonatalRescueFlag;
	}

	public void setNeonatalRescueFlag(String neonatalRescueFlag) {
		this.neonatalRescueFlag = neonatalRescueFlag;
	}

	
	@XmlElement public String getNeonatalRescueMethod() {
		return this.neonatalRescueMethod;
	}

	public void setNeonatalRescueMethod(String neonatalRescueMethod) {
		this.neonatalRescueMethod = neonatalRescueMethod;
	}

	
	@XmlElement public String getMaternalDeathtimeType() {
		return this.maternalDeathtimeType;
	}

	public void setMaternalDeathtimeType(String maternalDeathtimeType) {
		this.maternalDeathtimeType = maternalDeathtimeType;
	}

	
	@XmlElement public String getMgOpinion() {
		return this.mgOpinion;
	}

	public void setMgOpinion(String mgOpinion) {
		this.mgOpinion = mgOpinion;
	}

	
	@XmlElement public String getMaternalMgOpinion() {
		return this.maternalMgOpinion;
	}

	public void setMaternalMgOpinion(String maternalMgOpinion) {
		this.maternalMgOpinion = maternalMgOpinion;
	}

	
	@XmlElement public String getFamilyPlanGuidance() {
		return this.familyPlanGuidance;
	}

	public void setFamilyPlanGuidance(String familyPlanGuidance) {
		this.familyPlanGuidance = familyPlanGuidance;
	}

	
	@XmlElement public String getMissionaryContent() {
		return this.missionaryContent;
	}

	public void setMissionaryContent(String missionaryContent) {
		this.missionaryContent = missionaryContent;
	}

	
	@XmlElement public String getCheckName() {
		return this.checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	
	@XmlElement public String getCheckOrganName() {
		return this.checkOrganName;
	}

	public void setCheckOrganName(String checkOrganName) {
		this.checkOrganName = checkOrganName;
	}

	
	
	@XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
	public Date getCheckDate() {
		return this.checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	
	@XmlElement public String getMidwiferyName() {
		return this.midwiferyName;
	}

	public void setMidwiferyName(String midwiferyName) {
		this.midwiferyName = midwiferyName;
	}

	
	@XmlElement public String getMidwiferyOrganName() {
		return this.midwiferyOrganName;
	}

	public void setMidwiferyOrganName(String midwiferyOrganName) {
		this.midwiferyOrganName = midwiferyOrganName;
	}

	
	@XmlElement
	public Integer getInputGestationalWeek() {
		return this.inputGestationalWeek;
	}

	public void setInputGestationalWeek(Integer inputGestationalWeek) {
		this.inputGestationalWeek = inputGestationalWeek;
	}

	
	@XmlElement public String getInputName() {
		return this.inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	
	@XmlElement public String getInputOrganName() {
		return this.inputOrganName;
	}

	public void setInputOrganName(String inputOrganName) {
		this.inputOrganName = inputOrganName;
	}

	
	@XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
	public Date getClosedDate() {
		return this.closedDate;
	}

	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}

	
	@XmlElement public String getClosedUnitName() {
		return this.closedUnitName;
	}

	public void setClosedUnitName(String closedUnitName) {
		this.closedUnitName = closedUnitName;
	}

	
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
	public Date getReservationDate() {
		return this.reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
		
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
	public Date getInterviewDate() {
		return this.interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}
	
	@XmlElement public String getInterviewName() {
		return this.interviewName;
	}

	public void setInterviewName(String interviewName) {
		this.interviewName = interviewName;
	}

	
	@XmlElement public String getInterviewOrganName() {
		return this.interviewOrganName;
	}

	public void setInterviewOrganName(String interviewOrganName) {
		this.interviewOrganName = interviewOrganName;
	}

	
	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	
	@XmlElement
	public String getMotherIdcard() {
		return motherIdcard;
	}

	public void setMotherIdcard(String motherIdcard) {
		this.motherIdcard = motherIdcard;
	}

	@XmlElement
	public String getBabyCardNo() {
		return babyCardNo;
	}

	public void setBabyCardNo(String babyCardNo) {
		this.babyCardNo = babyCardNo;
	}

	@XmlElement
	public String getCreateOrganCode() {
		return createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	@XmlElement
	public String getCreateOrganName() {
		return createOrganName;
	}

	public void setCreateOrganName(String createOrganName) {
		this.createOrganName = createOrganName;
	}

	
	public String getLastMenstrualDateDesc() {
		return lastMenstrualDateDesc;
	}

	
	public void setLastMenstrualDateDesc(String lastMenstrualDateDesc) {
		this.lastMenstrualDateDesc = lastMenstrualDateDesc;
	}

	
	public String getProcessStatus() {
		return processStatus;
	}

	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	
	public String getPreviousPregnancyEndDateDesc() {
		return previousPregnancyEndDateDesc;
	}

	
	public void setPreviousPregnancyEndDateDesc(String previousPregnancyEndDateDesc) {
		this.previousPregnancyEndDateDesc = previousPregnancyEndDateDesc;
	}

	
	public String getProcessStatus1() {
		return processStatus1;
	}

	
	public void setProcessStatus1(String processStatus1) {
		this.processStatus1 = processStatus1;
	}

	
	public Integer getIsAnalyse() {
		return isAnalyse;
	}

	
	public void setIsAnalyse(Integer isAnalyse) {
		this.isAnalyse = isAnalyse;
	}

	public String getMenstrualBleedingTypeDesc() {
		return menstrualBleedingTypeDesc;
	}

	public void setMenstrualBleedingTypeDesc(String menstrualBleedingTypeDesc) {
		this.menstrualBleedingTypeDesc = menstrualBleedingTypeDesc;
	}

	public String getDysmenorrheaDegreeDesc() {
		return dysmenorrheaDegreeDesc;
	}

	public void setDysmenorrheaDegreeDesc(String dysmenorrheaDegreeDesc) {
		this.dysmenorrheaDegreeDesc = dysmenorrheaDegreeDesc;
	}

	public String getRiskPregProgCodeDesc() {
		return riskPregProgCodeDesc;
	}

	public void setRiskPregProgCodeDesc(String riskPregProgCodeDesc) {
		this.riskPregProgCodeDesc = riskPregProgCodeDesc;
	}

	public String getCheckJobNumber() {
		return checkJobNumber;
	}

	public void setCheckJobNumber(String checkJobNumber) {
		this.checkJobNumber = checkJobNumber;
	}

	public String getCheckIdcard() {
		return checkIdcard;
	}

	public void setCheckIdcard(String checkIdcard) {
		this.checkIdcard = checkIdcard;
	}
	
}
