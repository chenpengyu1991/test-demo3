package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 主要临床表现
 * @author Jiang Haiying
 *
 */
@Entity
@Table(name = "IDM_CLINICAL_MANIFESTATIONS")
public class ClinicalManifestations implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编码||", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "TEMPERATURE", columnDefinition = "VARCHAR2|体温||", length = 10, nullable = true)
	private String temperature;

	@Column(name = "VOMIT_CHARACTER", columnDefinition = "VARCHAR2|呕吐物性状||", length = 500, nullable = true)
	private String vomitCharacter;

	@Column(name = "STOOL_PROPERTY", columnDefinition = "VARCHAR2|大便性状||", length = 500, nullable = true)
	private String stoolProperty;

	@Column(name = "ABDOMINAL_PAIN_PARTS", columnDefinition = "VARCHAR2|腹痛部位||", length = 500, nullable = true)
	private String abdominalPainParts;

	@Column(name = "PASTEURELLESES", columnDefinition = "VARCHAR2|巴氏症||", length = 500, nullable = true)
	private String pasteurelleses;

	@Column(name = "BRUCELLOSIS", columnDefinition = "VARCHAR2|布氏症||", length = 500, nullable = true)
	private String brucellosis;

	@Column(name = "LOU_GEHRIGS_DISEASE", columnDefinition = "VARCHAR2|克氏症||", length = 500, nullable = true)
	private String louGehrigsDisease;

	@Column(name = "LYMPHADENECTASIS_PART", columnDefinition = "VARCHAR2|淋巴结肿大-部位||", length = 500, nullable = true)
	private String lymphadenectasisPart;

	@Column(name = "SYMPTOMS_TIME", columnDefinition = "DATE|出现症状时间||", nullable = true)
	private Date symptomsTime;

	@Column(name = "SPOT_PIMPLES", columnDefinition = "VARCHAR2|生殖器部位有暗红斑或丘疹||", length = 500, nullable = true)
	private String spotPimples;

	@Column(name = "OTHER_THAN_SPOT_PIMPLES", columnDefinition = "VARCHAR2|生殖器部位以外有暗红斑或丘疹||", length = 500, nullable = true)
	private String otherThanSpotPimples;

	@Column(name = "APPEARANCES", columnDefinition = "VARCHAR2|出现部位||", length = 500, nullable = true)
	private String appearances;

	@Column(name = "UN_INGUINAL_LYMPH_NODES", columnDefinition = "VARCHAR2|单侧腹股沟淋巴结肿大||", length = 500, nullable = true)
	private String unInguinalLymphNodes;

	@Column(name = "RASH", columnDefinition = "VARCHAR2|皮疹||", length = 500, nullable = true)
	private String rash;

	@Column(name = "CONDYLOMA", columnDefinition = "VARCHAR2|扁平湿疣||", length = 500, nullable = true)
	private String condyloma;

	@Column(name = "ALOPECIASYPHILITICA", columnDefinition = "VARCHAR2|梅毒性脱发||", length = 500, nullable = true)
	private String alopeciasyphilitica;

	@Column(name = "SYPHILITIC_LEUKODERMA", columnDefinition = "VARCHAR2|梅毒性白斑||", length = 500, nullable = true)
	private String syphiliticLeukoderma;

	@Column(name = "OTHER", columnDefinition = "VARCHAR2|其他||", length = 500, nullable = true)
	private String other;

	@Column(name = "FEVER", columnDefinition = "VARCHAR2|发热||", length = 2, nullable = true)
	private String fever;

	@Column(name = "HIGHEST_TEMPERATURE", columnDefinition = "VARCHAR2|最高体温|20|", length = 20, nullable = true)
	private String highestTemperature;

	@Column(name = "HEATING_DURATION", columnDefinition = "VARCHAR2|发热持续时间|20|", length = 20, nullable = true)
	private String heatingDuration;

	@Column(name = "CHILLS", columnDefinition = "VARCHAR2|畏寒||", length = 2, nullable = true)
	private String chills;

	@Column(name = "WHOLE_BODY_PAIN", columnDefinition = "VARCHAR2|全身肌痛||", length = 2, nullable = true)
	private String wholeBodyPain;

	@Column(name = "GASTROCNEMIUS_PAIN", columnDefinition = "VARCHAR2|腓肠肌痛||", length = 2, nullable = true)
	private String gastrocnemiusPain;

	@Column(name = "LASSITUDE", columnDefinition = "VARCHAR2|疲乏无力||", length = 2, nullable = true)
	private String lassitude;

	@Column(name = "GASTROCNEMIUS_TENDERNESS", columnDefinition = "VARCHAR2|腓肠肌压痛||", length = 2, nullable = true)
	private String gastrocnemiusTenderness;

	@Column(name = "SUPERFICIAL_LYMPH_NODES", columnDefinition = "VARCHAR2|浅表淋巴结肿大||", length = 2, nullable = true)
	private String superficialLymphNodes;

	@Column(name = "VOMIT", columnDefinition = "VARCHAR2|呕吐||", length = 2, nullable = true)
	private String vomit;

	@Column(name = "STOMACHACHE", columnDefinition = "VARCHAR2|腹痛||", length = 2, nullable = true)
	private String stomachache;

	@Column(name = "DIARRHEA", columnDefinition = "VARCHAR2|腹泻||", length = 2, nullable = true)
	private String diarrhea;

	@Column(name = "COUGH", columnDefinition = "VARCHAR2|咳嗽||", length = 2, nullable = true)
	private String cough;

	@Column(name = "HEMOPTYSIS", columnDefinition = "VARCHAR2|咯血||", length = 2, nullable = true)
	private String hemoptysis;

	@Column(name = "SKIN_SCLERA_YELLOW", columnDefinition = "VARCHAR2|皮肤巩膜黄染||", length = 2, nullable = true)
	private String skinScleraYellow;

	@Column(name = "EPISTAXIS", columnDefinition = "VARCHAR2|鼻衄||", length = 2, nullable = true)
	private String epistaxis;

	@Column(name = "BLEEDING_SPOTS_SKIN", columnDefinition = "VARCHAR2|皮肤出血点||", length = 2, nullable = true)
	private String bleedingSpotsSkin;

	@Column(name = "HEPATOMEGALY", columnDefinition = "VARCHAR2|肝肿大||", length = 2, nullable = true)
	private String hepatomegaly;

	@Column(name = "SPLENOMEGALY", columnDefinition = "VARCHAR2|脾肿大||", length = 2, nullable = true)
	private String splenomegaly;

	@Column(name = "OLIGURIA", columnDefinition = "VARCHAR2|少尿||", length = 2, nullable = true)
	private String oliguria;

	@Column(name = "HEMATURESIS", columnDefinition = "VARCHAR2|血尿||", length = 2, nullable = true)
	private String hematuresis;

	@Column(name = "RENAL_PAIN", columnDefinition = "VARCHAR2|肾区疼痛||", length = 2, nullable = true)
	private String renalPain;

	@Column(name = "HEADACHE", columnDefinition = "VARCHAR2|头痛||", length = 2, nullable = true)
	private String headache;

	@Column(name = "NECK_RIGIDITY", columnDefinition = "VARCHAR2|颈项强直||", length = 2, nullable = true)
	private String neckRigidity;

	@Column(name = "CONVULSION", columnDefinition = "VARCHAR2|抽搐||", length = 2, nullable = true)
	private String convulsion;

	@Column(name = "PARALYSIS", columnDefinition = "VARCHAR2|瘫痪||", length = 2, nullable = true)
	private String paralysis;

	@Column(name = "G_BRINELL_POSITIVE", columnDefinition = "VARCHAR2|克布氏征阳性||", length = 2, nullable = true)
	private String gBrinellPositive;

	@Column(name = "DISTURBANCE_CONSCIOUSNESS", columnDefinition = "VARCHAR2|意识障碍||", length = 20, nullable = true)
	private String disturbanceConsciousness;

	@Column(name = "IS_SYMPTOMS", columnDefinition = "VARCHAR2|有无如下症状||", length = 2, nullable = true)
	private String isSymptoms;

	@Column(name = "FEEBLE", columnDefinition = "VARCHAR2|乏力||", length = 2, nullable = true)
	private String feeble;

	@Column(name = "BACK_PAIN", columnDefinition = "VARCHAR2|要背酸痛||", length = 2, nullable = true)
	private String backPain;

	@Column(name = "LIMB_ACHE", columnDefinition = "VARCHAR2|四肢酸痛||", length = 2, nullable = true)
	private String limbAche;

	@Column(name = "SNEEZE", columnDefinition = "VARCHAR2|打喷嚏||", length = 2, nullable = true)
	private String sneeze;

	@Column(name = "NAUSEA", columnDefinition = "VARCHAR2|恶心||", length = 2, nullable = true)
	private String nausea;

	@Column(name = "DIARRHEA_DAILY_TIMES", columnDefinition = "VARCHAR2|腹泻每日次数|20|", length = 20, nullable = true)
	private String diarrheaDailyTimes;

	@Column(name = "PNEUMONIA", columnDefinition = "VARCHAR2|肺炎||", length = 2, nullable = true)
	private String pneumonia;

	@Column(name = "ASTHMA", columnDefinition = "VARCHAR2|哮喘||", length = 2, nullable = true)
	private String asthma;

	@Column(name = "THROM_VIOLET_INSANE", columnDefinition = "VARCHAR2|血小板减少星紫癫||", length = 2, nullable = true)
	private String thromVioletInsane;

	@Column(name = "REYE_SYNDROME", columnDefinition = "VARCHAR2|Reye's综合症||", length = 2, nullable = true)
	private String reyeSyndrome;

	@Column(name = "ABORTION", columnDefinition = "VARCHAR2|流产||", length = 2, nullable = true)
	private String abortion;

	@Column(name = "STILLBIRTH", columnDefinition = "VARCHAR2|死胎||", length = 2, nullable = true)
	private Integer stillbirth;

	@Column(name = "ONSET", columnDefinition = "VARCHAR2|起病急||", length = 2, nullable = true)
	private String onset;

	@Column(name = "DATE_ACCIDENT", columnDefinition = "DATE|发病日期||", nullable = true)
	private Date dateAccident;

	@Column(name = "ORG_DIAGNOSTICS_WRITE", columnDefinition = "VARCHAR2|诊断单位||", length = 100, nullable = true)
	private String orgDiagnosticsWrite;

	@Column(name = "HOT_DATE", columnDefinition = "DATE|发热日期||", nullable = true)
	private Date hotDate;

	@Column(name = "SENSATION_CHILL", columnDefinition = "VARCHAR2|怕冷||", length = 2, nullable = true)
	private String sensationChill;

	@Column(name = "POOR_APPETITE", columnDefinition = "VARCHAR2|食欲不佳||", length = 2, nullable = true)
	private String poorAppetite;

	@Column(name = "PAROTID_SWEL_DATE", columnDefinition = "DATE|腮腺肿胀日期||", nullable = true)
	private Date parotidSwelDate;

	@Column(name = "SWELLING_METHOD", columnDefinition = "VARCHAR2|肿胀方法||", length = 2, nullable = true)
	private String swellingMethod;

	@Column(name = "MASS_TENDERNESS", columnDefinition = "VARCHAR2|肿块压痛||", length = 2, nullable = true)
	private String massTenderness;

	@Column(name = "MASS_RED", columnDefinition = "VARCHAR2|肿块红肿||", length = 2, nullable = true)
	private String massRed;

	@Column(name = "MASS_FLUCT_DRY", columnDefinition = "VARCHAR2|肿块有波动干||", length = 2, nullable = true)
	private String massFluctDry;

	@Column(name = "IS_MASS_RECEDING", columnDefinition = "VARCHAR2|肿块现在是否退去||", length = 2, nullable = true)
	private String isMassReceding;

	@Column(name = "MASS_ASIDE_DATE", columnDefinition = "DATE|肿块退去日期||", nullable = true)
	private Date massAsideDate;

	@Column(name = "IS_COMPLICATIONS", columnDefinition = "VARCHAR2|是否有并发症||", length = 2, nullable = true)
	private String isComplications;

	@Column(name = "COMPLICATIONS", columnDefinition = "VARCHAR2|并发症||", length = 200, nullable = true)
	private String complications;

	@Column(name = "CORYZA", columnDefinition = "VARCHAR2|卡他性鼻炎||", length = 2, nullable = true)
	private String coryza;

	@Column(name = "CONJUNCTIVITIS", columnDefinition = "VARCHAR2|结膜炎||", length = 2, nullable = true)
	private String conjunctivitis;

	@Column(name = "RASH_DATE", columnDefinition = "DATE|出疹日期||", nullable = true)
	private Date rashDate;

	@Column(name = "RASH_ORDER", columnDefinition = "VARCHAR2|出疹顺序||", length = 2, nullable = true)
	private String rashOrder;

	@Column(name = "MEASLES_SHAPE", columnDefinition = "VARCHAR2|疹子形状||", length = 2, nullable = true)
	private String measlesShape;

	@Column(name = "ENANTHEMA", columnDefinition = "VARCHAR2|粘膜疹||", length = 2, nullable = true)
	private String enanthema;

	@Column(name = "RASH_BACK_DATE", columnDefinition = "VARCHAR2|退疹日期||",length = 20, nullable = true)
	private String rashBackDate;

	@Column(name = "IS_RASH_PIGMENTATION", columnDefinition = "VARCHAR2|退疹后色素沉着||", length = 2, nullable = true)
	private String isRashPigmentation;

	@Column(name = "CHAFF_BRAN_SAMPLE_DEBOND", columnDefinition = "VARCHAR2|糠麸样脱屑||", length = 2, nullable = true)
	private String chaffBranSampleDebond;

	@Column(name = "ARTHRALGIA", columnDefinition = "VARCHAR2|关节疼痛||", length = 2, nullable = true)
	private String arthralgia;

	@Column(name = "ITCHY_EYES", columnDefinition = "VARCHAR2|眼刺痒||", length = 2, nullable = true)
	private String itchyEyes;

	@Column(name = "HEAVY_EYELID", columnDefinition = "VARCHAR2|眼睑沉重||", length = 2, nullable = true)
	private String heavyEyelid;

	@Column(name = "PHOTOPHOBIA_TEARS", columnDefinition = "VARCHAR2|畏光流泪||", length = 2, nullable = true)
	private String photophobiaTears;

	@Column(name = "SCORCHING_HOT", columnDefinition = "VARCHAR2|灼热||", length = 2, nullable = true)
	private String scorchingHot;

	@Column(name = "UNCLEAR_VISION", columnDefinition = "VARCHAR2|视物不清||", length = 2, nullable = true)
	private String unclearVision;

	@Column(name = "SWELL", columnDefinition = "VARCHAR2|肿胀||", length = 2, nullable = true)
	private String swell;

	@Column(name = "MUCOSA_SECRETION", columnDefinition = "VARCHAR2|粘膜分泌物||", length = 2, nullable = true)
	private String mucosaSecretion;

	@Column(name = "PURULENT_SECRETION", columnDefinition = "VARCHAR2|脓性分泌物||", length = 2, nullable = true)
	private String purulentSecretion;

	@Column(name = "CONJUNCTIVAL_CONGESTION", columnDefinition = "VARCHAR2|结膜充血||", length = 2, nullable = true)
	private String conjunctivalCongestion;

	@Column(name = "COURSE_DAYS", columnDefinition = "VARCHAR2|病程天数|20|", length = 20, nullable = true)
	private String courseDays;

	@Column(name = "HOT_TYPE", columnDefinition = "VARCHAR2|热型||", length = 2, nullable = true)
	private String hotType;

	@Column(name = "MUSCULAR_STIFFNESS", columnDefinition = "VARCHAR2|全身酸痛||", length = 2, nullable = true)
	private String muscularStiffness;

	@Column(name = "PHARYNGEAL_CONGESTION", columnDefinition = "VARCHAR2|咽充血||", length = 2, nullable = true)
	private String pharyngealCongestion;

	@Column(name = "ANURESIS", columnDefinition = "VARCHAR2|尿闭||", length = 2, nullable = true)
	private String anuresis;

	@Column(name = "SPLENOMEGALIA", columnDefinition = "VARCHAR2|脾肿大||", length = 2, nullable = true)
	private String splenomegalia;

	@Column(name = "CHILL", columnDefinition = "VARCHAR2|寒战||", length = 2, nullable = true)
	private String chill;

	@Column(name = "SWEAT", columnDefinition = "VARCHAR2|出汗||", length = 2, nullable = true)
	private String sweat;

	@Column(name = "SPLEEN_SWOLLEN_DATE", columnDefinition = "VARCHAR2|脾肿发现日期||", length = 20, nullable = true)
	private String spleenSwollenDate;

	@Column(name = "LOSE_WEIGHT", columnDefinition = "VARCHAR2|体重减轻||", length = 2, nullable = true)
	private String loseWeight;

	@Column(name = "WEIGHT_RECESSION", columnDefinition = "VARCHAR2|体重衰退||", length = 2, nullable = true)
	private String weightRecession;

	@Column(name = "NYCTALOPIA", columnDefinition = "VARCHAR2|夜盲||", length = 2, nullable = true)
	private String nyctalopia;

	@Column(name = "NOSEBLEED", columnDefinition = "VARCHAR2|鼻血||", length = 2, nullable = true)
	private String nosebleed;

	@Column(name = "GINGIVAL_BLEEDING", columnDefinition = "VARCHAR2|牙龈出血||", length = 2, nullable = true)
	private String gingivalBleeding;

	@Column(name = "WHEEZE", columnDefinition = "VARCHAR2|气喘||", length = 2, nullable = true)
	private String wheeze;

	@Column(name = "HEMOSPUTUM", columnDefinition = "VARCHAR2|血痰||", length = 2, nullable = true)
	private String hemosputum;

	@Column(name = "HOARSENESS", columnDefinition = "VARCHAR2|嘶哑||", length = 2, nullable = true)
	private String hoarseness;

	@Column(name = "PALPITATION", columnDefinition = "VARCHAR2|心悸||", length = 2, nullable = true)
	private String palpitation;

	@Column(name = "DYSENTERY", columnDefinition = "VARCHAR2|痢疾||", length = 2, nullable = true)
	private String dysentery;

	@Column(name = "EMACIATION", columnDefinition = "VARCHAR2|消瘦||", length = 2, nullable = true)
	private String emaciation;

	@Column(name = "ANEMIA", columnDefinition = "VARCHAR2|贫血||", length = 2, nullable = true)
	private String anemia;

	@Column(name = "BRADYGENESIS", columnDefinition = "VARCHAR2|发育迟缓||", length = 2, nullable = true)
	private String bradygenesis;

	@Column(name = "ECCHYMOSIS", columnDefinition = "VARCHAR2|瘀斑||", length = 2, nullable = true)
	private String ecchymosis;

	@Column(name = "SKIN_DISEASE", columnDefinition = "VARCHAR2|皮肤病||", length = 2, nullable = true)
	private String skinDisease;

	@Column(name = "JAUNDICE", columnDefinition = "VARCHAR2|黄疸||", length = 2, nullable = true)
	private String jaundice;

	@Column(name = "EDEMA", columnDefinition = "VARCHAR2|浮肿||", length = 2, nullable = true)
	private String edema;

	@Column(name = "TONSIL_SWOLLEN", columnDefinition = "VARCHAR2|扁桃腺肿大||", length = 2, nullable = true)
	private String tonsilSwollen;

	@Column(name = "TONGUE_COATING", columnDefinition = "VARCHAR2|舌苔||", length = 2, nullable = true)
	private String tongueCoating;

	@Column(name = "ORAL_ULCER", columnDefinition = "VARCHAR2|口腔溃疡||", length = 2, nullable = true)
	private String oralUlcer;

	@Column(name = "NOMA", columnDefinition = "VARCHAR2|走马疳||", length = 2, nullable = true)
	private String noma;

	@Column(name = "HEART_RATE", columnDefinition = "VARCHAR2|心率|20|", length = 20, nullable = true)
	private String heartRate;

	@Column(name = "HEART_RHYTHM", columnDefinition = "VARCHAR2|心律||", length = 2, nullable = true)
	private String heartRhythm;

	@Column(name = "CARDIAC_MURMUR", columnDefinition = "VARCHAR2|心脏杂音||", length = 2, nullable = true)
	private String cardiacMurmur;

	@Column(name = "LUNGS", columnDefinition = "VARCHAR2|肺||", length = 2, nullable = true)
	private String lungs;

	@Column(name = "ABDOMINAL_CIRCUMFERENCE", columnDefinition = "VARCHAR2|腹围|20|", length = 20, nullable = true)
	private String abdominalCircumference;

	@Column(name = "ASCITES", columnDefinition = "VARCHAR2|腹水||", length = 2, nullable = true)
	private String ascites;

	@Column(name = "SPLEEN_RIB_UNDER", columnDefinition = "VARCHAR2|脾肋下||", length = 20, nullable = true)
	private String spleenRibUnder;

	@Column(name = "LIVER_RIB_UNDER", columnDefinition = "VARCHAR2|肝肋下||", length = 20, nullable = true)
	private String liverRibUnder;

	@Column(name = "LIVER_SORE", columnDefinition = "VARCHAR2|肝区肿痛||", length = 50, nullable = true)
	private String liverSore;

	@Column(name = "EPILEPTIC_SEIZURE", columnDefinition = "VARCHAR2|癫痫发作||", length = 2, nullable = true)
	private String epilepticSeizure;

	@Column(name = "DIARRHOEA_DAYS", columnDefinition = "VARCHAR2|腹泻天数|20|", length = 20, nullable = true)
	private String diarrhoeaDays;

	@Column(name = "DIARRHEA_VARIABLE", columnDefinition = "VARCHAR2|腹泻变量||", length = 2, nullable = true)
	private String diarrheaVariable;

	@Column(name = "DIARRHEA_SMELL", columnDefinition = "VARCHAR2|腹泻气味||", length = 2, nullable = true)
	private String diarrheaSmell;

	@Column(name = "CONDITION_DEFECATION", columnDefinition = "VARCHAR2|排便情况||", length = 2, nullable = true)
	private String conditionDefecation;

	@Column(name = "ABDOMINAL_PAIN", columnDefinition = "VARCHAR2|腹痛类型||", length = 2, nullable = true)
	private String abdominalPain;

	@Column(name = "BARBORYGMUS", columnDefinition = "VARCHAR2|腹鸣||", length = 2, nullable = true)
	private String barborygmus;

	@Column(name = "ABDOMINAL_DISTENSION", columnDefinition = "VARCHAR2|腹胀||", length = 2, nullable = true)
	private String abdominalDistension;

	@Column(name = "WATER_LOSS_SITUATION", columnDefinition = "VARCHAR2|失水情况||", length = 2, nullable = true)
	private String waterLossSituation;

	@Column(name = "HEADACHE_DIZZINESS", columnDefinition = "VARCHAR2|头痛头昏||", length = 2, nullable = true)
	private String headacheDizziness;

	@Column(name = "CLINICAL_TYPE_LEVEL", columnDefinition = "VARCHAR2|临床类型||", length = 2, nullable = true)
	private String clinicalTypeLevel;

	@Column(name = "VOMIT_DAYS", columnDefinition = "VARCHAR2|呕吐天数|20|", length = 20, nullable = true)
	private String vomitDays;

	@Column(name = "VOMIT_TIMES", columnDefinition = "VARCHAR2|呕吐次数|20|", length = 20, nullable = true)
	private String vomitTimes;

	@Column(name = "VOMIT_WAY", columnDefinition = "VARCHAR2|呕吐方式||", length = 2, nullable = true)
	private String vomitWay;

	@Column(name = "VOMITING_QUANTITY", columnDefinition = "VARCHAR2|呕吐量||", length = 2, nullable = true)
	private String vomitingQuantity;

	@Column(name = "ORAL_MUCOUS_ULCER_HERPES", columnDefinition = "VARCHAR2|口腔粘膜上出现红色溃疡型疱疹||", length = 2, nullable = true)
	private String oralMucousUlcerHerpes;

	@Column(name = "RESPIRATORY", columnDefinition = "VARCHAR2|呼吸系统||", length = 12, nullable = true)
	private String respiratory;

	@Column(name = "OTHER_RESPIRATORY", columnDefinition = "VARCHAR2|呼吸系统-其他||", length = 100, nullable = true)
	private String otherRespiratory;

	@Column(name = "DIGESTIVE_SYSTEM", columnDefinition = "VARCHAR2|消化系统||", length = 15, nullable = true)
	private String digestiveSystem;

	@Column(name = "OTHER_DIGESTIVE_SYSTEM", columnDefinition = "VARCHAR2|消化系统-其他||", length = 100, nullable = true)
	private String otherDigestiveSystem;

	@Column(name = "NERVOUS_SYSTEM", columnDefinition = "VARCHAR2|神经系统||", length = 21, nullable = true)
	private String nervousSystem;

	@Column(name = "ARRHYTHMIA", columnDefinition = "VARCHAR2|心律失常||", length = 2, nullable = true)
	private String arrhythmia;

	@Column(name = "TENDON_REFLEX", columnDefinition = "VARCHAR2|腱反射||", length = 2, nullable = true)
	private String tendonReflex;

	@Column(name = "MUSCLE_TENSION", columnDefinition = "VARCHAR2|肌张力||", length = 2, nullable = true)
	private String muscleTension;

	@Column(name = "COMPL", columnDefinition = "VARCHAR2|合并症||", length = 2, nullable = true)
	private String compl;

	@Column(name = "COMPL_DESCRIPTION", columnDefinition = "VARCHAR2|合并症-描述||", length = 100, nullable = true)
	private String complDescription;

	@Column(name = "IS_RED_MEATUS_CERVICAL", columnDefinition = "VARCHAR2|尿道口或宫颈是否有红肿||", length = 2, nullable = true)
	private String isRedMeatusCervical;

	@Column(name = "IS_ODYNURIA", columnDefinition = "VARCHAR2|是否有尿痛||", length = 2, nullable = true)
	private String isOdynuria;

	@Column(name = "IS_FREQUENT_MICTURITION", columnDefinition = "VARCHAR2|是否有尿频||", length = 2, nullable = true)
	private String isFrequentMicturition;

	@Column(name = "IS_URGENCY_URINATION", columnDefinition = "VARCHAR2|是否有尿急||", length = 2, nullable = true)
	private String isUrgencyUrination;

	@Column(name = "IS_SECRETION_URETHRAL_VAGINAL", columnDefinition = "VARCHAR2|尿道或阴道是否有脓性分泌物||", length = 2, nullable = true)
	private String isSecretionUrethralVaginal;

	@Column(name = "HIDROSIS", columnDefinition = "VARCHAR2|多汗||", length = 2, nullable = true)
	private String hidrosis;

	@Column(name = "TESTICULAR_SWELLING", columnDefinition = "VARCHAR2|睾丸肿大||", length = 2, nullable = true)
	private String testicularSwelling;

	@Column(name = "SORE_THROAT", columnDefinition = "VARCHAR2|咽喉痛||", length = 2, nullable = true)
	private String soreThroat;

	@Column(name = "CIRCUMORAL_PALLOR", columnDefinition = "VARCHAR2|口周苍白圈||", length = 2, nullable = true)
	private String circumoralPallor;

	@Column(name = "RASPBERRY_TONGUE", columnDefinition = "VARCHAR2|杨梅舌||", length = 2, nullable = true)
	private String raspberryTongue;

	@Column(name = "SWALLOW_SPONDYLOLYSIS_RED", columnDefinition = "VARCHAR2|咽峡部和扁桃体红肿||", length = 2, nullable = true)
	private String swallowSpondylolysisRed;

	@Column(name = "RASH_DAYS", columnDefinition = "VARCHAR2|出疹持续天数|20|", length = 20, nullable = true)
	private String rashDays;

	@Column(name = "RASH_SHAPE_DISTRIBUTION", columnDefinition = "VARCHAR2|疹形及分布||", length = 100, nullable = true)
	private String rashShapeDistribution;

	@Column(name = "PEEL", columnDefinition = "VARCHAR2|脱皮||", length = 2, nullable = true)
	private String peel;

	@Column(name = "CHARACTER", columnDefinition = "VARCHAR2|性状||", length = 2, nullable = true)
	private String character;

	@Column(name = "CHIEF", columnDefinition = "VARCHAR2|主诉||", length = 500, nullable = true)
	private String chief;

	@Column(name = "HISTORY_PRESENT_ILLNESS", columnDefinition = "VARCHAR2|现病史||", length = 500, nullable = true)
	private String historyPresentIllness;

	@Column(name = "MALE_BODY_CHARAC", columnDefinition = "VARCHAR2|阳体特征||", length = 500, nullable = true)
	private String maleBodyCharac;

	@Column(name = "SEIZURE", columnDefinition = "VARCHAR2|惊厥||", length = 2, nullable = true)
	private String seizure;

	@Column(name = "OPISTHOTONOS", columnDefinition = "VARCHAR2|角弓反张||", length = 2, nullable = true)
	private String opisthotonos;

	@Column(name = "ISOLATION_PATIENTS", columnDefinition = "VARCHAR2|病人隔离||", length = 2, nullable = true)
	private String isolationPatients;

	@Column(name = "ISOLATION_PLACE", columnDefinition = "VARCHAR2|隔离地点||", length = 2, nullable = true)
	private String isolationPlace;

	@Column(name = "ISOLATION_PLACE_OTH", columnDefinition = "VARCHAR2|隔离地点-其它||", length = 100, nullable = true)
	private String isolationPlaceOth;

	@Column(name = "ANTIBIOTIC_DRUGS", columnDefinition = "VARCHAR2|使用抗生素药物||", length = 2, nullable = true)
	private String antibioticDrugs;

	@Column(name = "ANTIBIOTIC_DRUGS_NAME", columnDefinition = "VARCHAR2|使用药物名称||", length = 100, nullable = true)
	private String antibioticDrugsName;

	@Column(name = "USING_EFFECT", columnDefinition = "VARCHAR2|使用效果||", length = 2, nullable = true)
	private String usingEffect;

	@Column(name = "DIZZINESS", columnDefinition = "VARCHAR2|头晕||", length = 2, nullable = true)
	private String dizziness;

	@Column(name = "CONSTIPATION", columnDefinition = "VARCHAR2|便秘||", length = 2, nullable = true)
	private String constipation;

	@Column(name = "HEMAFECIA", columnDefinition = "VARCHAR2|便血||", length = 2, nullable = true)
	private String hemafecia;

	@Column(name = "APATHIA", columnDefinition = "VARCHAR2|表情淡漠||", length = 2, nullable = true)
	private String apathia;

	@Column(name = "DELIRIUM", columnDefinition = "VARCHAR2|谵妄||", length = 2, nullable = true)
	private String delirium;

	@Column(name = "COMA", columnDefinition = "VARCHAR2|昏迷||", length = 2, nullable = true)
	private String coma;

	@Column(name = "RELATIVE_BRADYCARDIA", columnDefinition = "VARCHAR2|相对缓脉||", length = 2, nullable = true)
	private String relativeBradycardia;

	@Column(name = "ROSEOLA", columnDefinition = "VARCHAR2|玫瑰疹||", length = 2, nullable = true)
	private String roseola;

	@Column(name = "ENTERORRHAGIA", columnDefinition = "VARCHAR2|并发症-肠出血||", length = 2, nullable = true)
	private String enterorrhagia;

	@Column(name = "ENTEROBROSIS", columnDefinition = "VARCHAR2|并发症-肠穿孔||", length = 2, nullable = true)
	private String enterobrosis;

	@Column(name = "TENESMUS", columnDefinition = "VARCHAR2|里急后重||", length = 2, nullable = true)
	private String tenesmus;

	@Column(name = "CLIN_CLASS", columnDefinition = "VARCHAR2|临床分型||", length = 2, nullable = true)
	private String clinClass;

	@Column(name = "ANTHRAX_CLIN_MANIF_ONE", columnDefinition = "VARCHAR2|炭疽临床表现1||", length = 2, nullable = true)
	private String anthraxClinManifOne;

	@Column(name = "ANTHRAX_CARB", columnDefinition = "VARCHAR2|炭疽痈||", length = 2, nullable = true)
	private String anthraxCarb;

	@Column(name = "ANTHRAX_CARB_NUM", columnDefinition = "VARCHAR2|炭疽痈-个数|20|", length = 20, nullable = true)
	private String anthraxCarbNum;

	@Column(name = "ANTHRAX_CARB_PARTS", columnDefinition = "VARCHAR2|炭疽痈部位||", length = 2, nullable = true)
	private String anthraxCarbParts;

	@Column(name = "ANTHRAX_CARB_BEL", columnDefinition = "VARCHAR2|炭疽痈属于||", length = 2, nullable = true)
	private String anthraxCarbBel;

	@Column(name = "MAL_EDEMA", columnDefinition = "VARCHAR2|恶性水肿||", length = 2, nullable = true)
	private String malEdema;

	@Column(name = "MAL_EDEMA_PARTS", columnDefinition = "VARCHAR2|恶性水肿-部位||", length = 200, nullable = true)
	private String malEdemaParts;

	@Column(name = "ANTHRAX_CLIN_MANIF_TWO", columnDefinition = "VARCHAR2|炭疽临床表现2||", length = 2, nullable = true)
	private String anthraxClinManifTwo;

	@Column(name = "ANTHRAX_CLIN_MANIF_THR", columnDefinition = "VARCHAR2|炭疽临床表现3||", length = 2, nullable = true)
	private String anthraxClinManifThr;

	@Column(name = "BLEEDING_VOLUME", columnDefinition = "VARCHAR2|出血量|20|", length = 20, nullable = true)
	private String bleedingVolume;

	@Column(name = "DYSPNEA", columnDefinition = "VARCHAR2|呼吸困难||", length = 2, nullable = true)
	private String dyspnea;

	@Column(name = "SKIN_MUC_CY", columnDefinition = "VARCHAR2|皮肤粘膜发绀||", length = 2, nullable = true)
	private String skinMucCy;

	@Column(name = "SEPTIC_STOCK", columnDefinition = "VARCHAR2|感染性休克||", length = 2, nullable = true)
	private String septicStock;

	@Column(name = "CLINICAL_TYPE", columnDefinition = "VARCHAR2|临床类型||", length = 2, nullable = true)
	private Integer clinicalType;

	@Column(name = "FACIAL_BLUSHING", columnDefinition = "VARCHAR2|颜面潮红||", length = 2, nullable = true)
	private Integer facialBlushing;

	@Column(name = "ORBIT_PAIN", columnDefinition = "VARCHAR2|眶后痛||", length = 2, nullable = true)
	private String orbitPain;

	@Column(name = "MYALGIA", columnDefinition = "VARCHAR2|肌痛||", length = 2, nullable = true)
	private String myalgia;

	@Column(name = "BRIGHT_BREASTED", columnDefinition = "VARCHAR2|胸红||", length = 2, nullable = true)
	private String brightBreasted;

	@Column(name = "CONJUNCTIVAL_HEMORRHAGE", columnDefinition = "VARCHAR2|结膜出血||", length = 2, nullable = true)
	private String conjunctivalHemorrhage;

	@Column(name = "HAEMATEMESIS", columnDefinition = "VARCHAR2|呕血||", length = 2, nullable = true)
	private String haematemesis;

	@Column(name = "EYELIDS_SWELLING", columnDefinition = "VARCHAR2|眼睑浮肿||", length = 2, nullable = true)
	private String eyelidsSwelling;

	@Column(name = "SKIN_BLE_TYPE", columnDefinition = "VARCHAR2|皮肤出血点-类型||", length = 2, nullable = true)
	private String skinBleType;

	@Column(name = "SKIN_BLE_TYPE_OTH", columnDefinition = "VARCHAR2|皮肤出血点-类型-其它||", length = 100, nullable = true)
	private String skinBleTypeOth;

	@Column(name = "RASH_TYPE", columnDefinition = "VARCHAR2|皮疹-类型||", length = 2, nullable = true)
	private String rashType;

	@Column(name = "RASH_TYPE_OTHER", columnDefinition = "VARCHAR2|皮疹-类型-其它||", length = 100, nullable = true)
	private String rashTypeOther;

	@Column(name = "RASH_PARTS", columnDefinition = "VARCHAR2|皮疹部位||", length = 20, nullable = true)
	private String rashParts;

	@Column(name = "IRRITABILITY", columnDefinition = "VARCHAR2|烦躁||", length = 2, nullable = true)
	private String irritability;

	@Column(name = "FEVER_LIMITS", columnDefinition = "VARCHAR2|发热度数范围||", length = 2, nullable = true)
	private String feverLimits;

	@Column(name = "SPIRITS_DROOPING", columnDefinition = "VARCHAR2|临床症状-精神萎靡||", length = 2, nullable = true)
	private String spiritsDrooping;

	@Column(name = "FUSSINESS", columnDefinition = "VARCHAR2|临床症状-易激怒||", length = 2, nullable = true)
	private Integer fussiness;

	@Column(name = "SLEEPINESS", columnDefinition = "VARCHAR2|临床症状-嗜睡||", length = 2, nullable = true)
	private String sleepiness;

	@Column(name = "RESPIRATORY_FAILURE", columnDefinition = "VARCHAR2|临床症状-呼吸衰竭||", length = 2, nullable = true)
	private String respiratoryFailure;

	@Column(name = "CIRCULATORY_FAILURE", columnDefinition = "VARCHAR2|临床症状-循环衰竭||", length = 2, nullable = true)
	private Integer circulatoryFailure;

	@Column(name = "BLOOD_PRESSURE_CHANGE", columnDefinition = "VARCHAR2|临床体征-血压改变||", length = 2, nullable = true)
	private String bloodPressureChange;

	@Column(name = "BREATH_RHYTHM_CHANGE", columnDefinition = "VARCHAR2|临床体征-呼吸节律改变||", length = 2, nullable = true)
	private Integer breathRhythmChange;

	@Column(name = "PUPIL_SIZE_CHANGE", columnDefinition = "VARCHAR2|临床体征-瞳孔大小改变||", length = 2, nullable = true)
	private String pupilSizeChange;

	@Column(name = "MENINGEAL_IRRITATION", columnDefinition = "VARCHAR2|临床体征-脑膜刺激征||", length = 2, nullable = true)
	private String meningealIrritation;

	@Column(name = "CHIMNEY", columnDefinition = "VARCHAR2|临床体征-前囱膨隆||", length = 2, nullable = true)
	private String chimney;

	@Column(name = "ABDOMINAL_REFLEXES", columnDefinition = "VARCHAR2|临床体征-腹壁反射||", length = 2, nullable = true)
	private String abdominalReflexes;

	@Column(name = "CREMASTERIC_FRELEX", columnDefinition = "VARCHAR2|临床体征-提睾反射||", length = 2, nullable = true)
	private String cremastericFrelex;

	@Column(name = "MUSCLE_TENSION_ENHANCED", columnDefinition = "VARCHAR2|临床体征-肌张力增强||", length = 2, nullable = true)
	private String muscleTensionEnhanced;

	@Column(name = "BABINSKI_SIGN", columnDefinition = "VARCHAR2|临床体征-巴彬斯基征||", length = 2, nullable = true)
	private String babinskiSign;

	@Column(name = "BRONCHOPNEUMONIA", columnDefinition = "VARCHAR2|并发症-支气管肺炎||", length = 2, nullable = true)
	private String bronchopneumonia;

	@Column(name = "PULMONARY_ATELECTASIS", columnDefinition = "VARCHAR2|并发症-肺不张||", length = 2, nullable = true)
	private String pulmonaryAtelectasis;

	@Column(name = "SEPSIS", columnDefinition = "VARCHAR2|并发症-败血症||", length = 2, nullable = true)
	private String sepsis;

	@Column(name = "GASTROINTESTINAL_BLEEDING", columnDefinition = "VARCHAR2|并发症-胃肠道出血||", length = 2, nullable = true)
	private String gastrointestinalBleeding;

	@Column(name = "URINARY_TRACT_INFECTION", columnDefinition = "VARCHAR2|并发症-尿路感染||", length = 2, nullable = true)
	private String urinaryTractInfection;

	@Column(name = "FOLLOW_UP_DATE", columnDefinition = "DATE|随访日期||", nullable = true)
	private Date followUpDate;

	@Column(name = "OUTCOME", columnDefinition = "VARCHAR2|病情转归||", length = 2, nullable = true)
	private String outcome;

	@Column(name = "OUTCOME_OTHER_SELECT", columnDefinition = "VARCHAR2|病情转归-其它||", length = 100, nullable = true)
	private String outcomeOtherSelect;

	@Column(name = "OUTCOME_DISTURB_CONSCIOUSNESS", columnDefinition = "VARCHAR2|病情转归-意识障碍||", length = 2, nullable = true)
	private String outcomDisturbanceConsciousness;

	@Column(name = "LANGUAGE_RETARDATION", columnDefinition = "VARCHAR2|病情转归-语言迟钝||", length = 2, nullable = true)
	private String languageRetardation;

	@Column(name = "APHASIA", columnDefinition = "VARCHAR2|病情转归-失语||", length = 2, nullable = true)
	private String aphasia;

	@Column(name = "STUPID", columnDefinition = "VARCHAR2|病情转归-痴呆||", length = 2, nullable = true)
	private String stupid;

	@Column(name = "PALSY", columnDefinition = "VARCHAR2|病情转归-瘫痪||", length = 2, nullable = true)
	private String palsy;

	@Column(name = "TORSIONAL_SPASM", columnDefinition = "VARCHAR2|病情转归-扭转型痉挛||", length = 2, nullable = true)
	private String torsionalSpasm;

	@Column(name = "MEMORY_IMPAIRMENT_UNDERSTAND", columnDefinition = "VARCHAR2|病情转归-记忆力及理解减退||", length = 2, nullable = true)
	private String memoryImpairmentUnderstand;

	@Column(name = "DEAF", columnDefinition = "VARCHAR2|病情转归-耳聋||", length = 2, nullable = true)
	private Integer deaf;

	@Column(name = "EPILEPSY", columnDefinition = "VARCHAR2|病情转归-癫痫||", length = 2, nullable = true)
	private Integer epilepsy;

	@Column(name = "DYSPHAGIA", columnDefinition = "VARCHAR2|病情转归-吞咽困难||", length = 2, nullable = true)
	private String dysphagia;

	@Column(name = "OPTIC_ATROPHY", columnDefinition = "VARCHAR2|病情转归-视神经萎缩||", length = 2, nullable = true)
	private Integer opticAtrophy;

	@Column(name = "HYDROSTOMIA", columnDefinition = "VARCHAR2|病情转归-流涎||", length = 2, nullable = true)
	private String hydrostomia;

	@Column(name = "PSYCHOPATHY", columnDefinition = "VARCHAR2|病情转归-精神失常||", length = 2, nullable = true)
	private String psychopathy;

	@Column(name = "OUTCOME_OTHER_WRITE", columnDefinition = "VARCHAR2|病情转归-其他||", length = 100, nullable = true)
	private String outcomeOtherWrite;

	@Column(name = "DEATH_REASON", columnDefinition = "VARCHAR2|死亡原因||", length = 2, nullable = true)
	private String deathReason;

	@Column(name = "DEATH_REASON_OTHER", columnDefinition = "VARCHAR2|死亡原因-其他||", length = 100, nullable = true)
	private String deathReasonOther;

	@Column(name = "FOLLOW_INVEST_WAY", columnDefinition = "VARCHAR2|随访调查方式||", length = 2, nullable = true)
	private String followInvestWay;

	@Column(name = "FOLLOW_INVEST_WAY_OTHER", columnDefinition = "VARCHAR2|随访调查方式-其他||", length = 100, nullable = true)
	private String followInvestWayOther;

	@Column(name = "FOLLOW_INVEST_PERSON", columnDefinition = "VARCHAR2|随访调查-调查人||", length = 50, nullable = true)
	private String followInvestPerson;

	@Column(name = "DEATH_TIME", columnDefinition = "DATE|死亡时间||", nullable = true)
	private Date deathTime;

	@Column(name = "ORG_DIAGNOSTICS_SELECT", columnDefinition = "VARCHAR2|诊断单位||", length = 2, nullable = true)
	private String orgDiagnosticsSelect;

	@Column(name = "DISEASE_CLINICAL_SYMPTOMS", columnDefinition = "VARCHAR2|发病临床症状||", length = 200, nullable = true)
	private String diseaseClinicalSymptoms;

	@Column(name = "ORBITAL_PAIN", columnDefinition = "VARCHAR2|眼眶痛||", length = 2, nullable = true)
	private String orbitalPain;

	@Column(name = "BLUSH", columnDefinition = "VARCHAR2|脸红||", length = 2, nullable = true)
	private String blush;

	@Column(name = "NECK_REDS", columnDefinition = "VARCHAR2|颈红||", length = 2, nullable = true)
	private String neckReds;

	@Column(name = "IS_PETECHIAE_ALAR_ARM_CHEST", columnDefinition = "VARCHAR2|腋下/上臂/胸部或其它部位有无皮肤出血点||", length = 2, nullable = true)
	private String isPetechiaeAlarArmChest;

	@Column(name = "ALAR_ARM_CHEST_VALUE", columnDefinition = "VARCHAR2|腋下/上臂/胸部或其它部位出血点性状||", length = 2, nullable = true)
	private String alarArmChestValue;

	@Column(name = "ALAR_ARM_CHEST_OTHER", columnDefinition = "VARCHAR2|腋下/上臂/胸部或其它部位出血点性状其他||", length = 100, nullable = true)
	private String alarArmChestOther;

	@Column(name = "IS_PETECHIAE_ORAL_NASAL", columnDefinition = "VARCHAR2|口腔、鼻腔等处粘膜有无出血点||", length = 2, nullable = true)
	private String isPetechiaeOralNasal;

	@Column(name = "HYPOTENSION", columnDefinition = "VARCHAR2|低血压||", length = 100, nullable = true)
	private String hypotension;

	@Column(name = "KOPLIK_SPOTS", columnDefinition = "VARCHAR2|麻疹粘膜斑（柯氏斑）||", length = 2, nullable = true)
	private String koplikSpots;

	@Column(name = "ORIGINAL_SYMPTOM", columnDefinition = "VARCHAR2|首发症状||", length = 200, nullable = true)
	private String originalSymptom;

	@Column(name = "FLU_LIKE_PERFORMANCE", columnDefinition = "VARCHAR2|流感样表现||", length = 200, nullable = true)
	private String fluLikePerformance;

	@Column(name = "THREE_DAYS_INJECTION_HISTORY", columnDefinition = "VARCHAR2|3天内注射史||", length = 2, nullable = true)
	private String threeDaysInjectionHistory;

	@Column(name = "PARALYSIS_APPEAR_DATE", columnDefinition = "DATE|麻痹出现日期||", nullable = true)
	private Date paralysisAppearDate;

	@Column(name = "LEFT_UPPER_EXTREMITY", columnDefinition = "VARCHAR2|左上肢||", length = 2, nullable = true)
	private String leftUpperExtremity;

	@Column(name = "RIGHT_UPPER_EXTREMITY", columnDefinition = "VARCHAR2|右上肢||", length = 2, nullable = true)
	private String rightUpperExtremity;

	@Column(name = "LEFT_LOWER_EXTREMITY", columnDefinition = "VARCHAR2|右上肢||", length = 2, nullable = true)
	private String leftLowerExtremity;

	@Column(name = "RIGHT_LOWER_EXTREMITY", columnDefinition = "VARCHAR2|右下肢||", length = 2, nullable = true)
	private String rightLowerExtremity;

	@Column(name = "BODY_OBSTACLE", columnDefinition = "VARCHAR2|肢体感觉障碍||", length = 2, nullable = true)
	private String bodyObstacle;

	@Column(name = "GATISM", columnDefinition = "VARCHAR2|大小便失禁||", length = 2, nullable = true)
	private String gatism;

	@Column(name = "BABINSKI_REFLECTION", columnDefinition = "VARCHAR2|巴彬斯基氏反射||", length = 2, nullable = true)
	private Integer babinskiReflection;

	@Column(name = "ANKKCLONUS", columnDefinition = "VARCHAR2|踝阵挛||", length = 2, nullable = true)
	private String ankkclonus;

	@Column(name = "DEEP_TENDON_REFLEX", columnDefinition = "VARCHAR2|深部腱反射||", length = 2, nullable = true)
	private String deepTendonReflex;

	@Column(name = "FIRST_ATTACK_FEVER", columnDefinition = "VARCHAR2|最初麻痹时伴发热（>37℃）||", length = 2, nullable = true)
	private String firstAttackFever;

	@Column(name = "CLINIC_TIMES", columnDefinition = "VARCHAR2|就诊次数||", length = 2, nullable = true)
	private String clinicTimes;

	@Column(name = "THIS_CLINIC_DATE", columnDefinition = "DATE|本次就诊日期||", nullable = true)
	private Date thisClinicDate;

	@Column(name = "THIS_CLINIC_DIAGNOSIS", columnDefinition = "VARCHAR2|本次就诊的诊断结果||", length = 2, nullable = true)
	private String thisClinicDiagnosis;

	@Column(name = "MEDICAL_ORG_F", columnDefinition = "VARCHAR2|就诊单位||", length = 2, nullable = true)
	private String medicalOrgF;

	@Column(name = "CLINIC_DATE_F", columnDefinition = "DATE|就诊日期||", nullable = true)
	private Date clinicDateF;

	@Column(name = "DIAGNOSIS_F", columnDefinition = "VARCHAR2|诊断结果||", length = 2, nullable = true)
	private String diagnosisF;

	@Column(name = "IS_REPORT_F", columnDefinition = "VARCHAR2|是否报告||", length = 2, nullable = true)
	private String isReportF;

	@Column(name = "CLINIC_DATE_L", columnDefinition = "DATE|就诊日期||", nullable = true)
	private Date clinicDateL;

	@Column(name = "DIAGNOSIS_L", columnDefinition = "VARCHAR2|诊断结果||", length = 2, nullable = true)
	private Integer diagnosisL;

	@Column(name = "IS_REPORT_L", columnDefinition = "VARCHAR2|是否报告||", length = 2, nullable = true)
	private String isReportL;

	@Column(name = "HOSPITAL_TYPE", columnDefinition = "VARCHAR2|医院类别||", length = 2, nullable = true)
	private Integer hospitalType;

	@Column(name = "HOSPITAL_NAME", columnDefinition = "VARCHAR2|医院名称||", length = 50, nullable = true)
	private String hospitalName;

	@Column(name = "MEDICAL_RECORD_NUM", columnDefinition = "VARCHAR2|病案编号||", length = 100, nullable = true)
	private String medicalRecordNum;

	@Column(name = "DISGUST_OIL_BELLY_DISTENSION", columnDefinition = "VARCHAR2|厌油腹胀||", length = 2, nullable = true)
	private String disgustOilBellyDistension;

	@Column(name = "SEMILIQUID_STOOL", columnDefinition = "VARCHAR2|溏便||", length = 2, nullable = true)
	private String semiliquidStool;

	@Column(name = "TEA_URINE", columnDefinition = "VARCHAR2|茶尿||", length = 2, nullable = true)
	private String teaUrine;

	@Column(name = "SPIDER_BURST", columnDefinition = "VARCHAR2|蜘蛛痣||", length = 2, nullable = true)
	private String spiderBurst;

	@Column(name = "LIVER_PALMS", columnDefinition = "VARCHAR2|肝掌||", length = 2, nullable = true)
	private String liverPalms;

	@Column(name = "FROTHY_SPUTUM", columnDefinition = "VARCHAR2|泡沫谈||", length = 2, nullable = true)
	private String frothySputum;

	@Column(name = "COLD_HEAT", columnDefinition = "VARCHAR2|恶寒、高热||", length = 2, nullable = true)
	private String coldHeat;

	@Column(name = "MANIA", columnDefinition = "VARCHAR2|狂躁||", length = 2, nullable = true)
	private String mania;

	@Column(name = "OBNUBILATION", columnDefinition = "VARCHAR2|神志不清||", length = 2, nullable = true)
	private String obnubilation;

	@Column(name = "BLOODY_STOOL", columnDefinition = "VARCHAR2|血便||", length = 2, nullable = true)
	private String bloodyStool;

	@Column(name = "BLOODY_VOMIT", columnDefinition = "VARCHAR2|血性呕吐物||", length = 2, nullable = true)
	private String bloodyVomit;

	@Column(name = "BLOOD_PRESSURE", columnDefinition = "VARCHAR2|血压（收缩压）||", length = 100, nullable = true)
	private String bloodPressure;

	@Column(name = "blood_pressure_diastolic", columnDefinition = "VARCHAR2|舒张压||", length = 100, nullable = true)
	private String bloodPressureDiastolic;
	
	@Column(name = "LYMPHADENECTASIS", columnDefinition = "VARCHAR2|淋巴结肿大||", length = 2, nullable = true)
	private String lymphadenectasis;

	@Column(name = "CHEST_PAIN", columnDefinition = "VARCHAR2|胸痛||", length = 2, nullable = true)
	private String chestPain;

	@Column(name = "SUBCUTANEOUS_MUCOSA_BLEED", columnDefinition = "VARCHAR2|皮下及粘膜出血||", length = 2, nullable = true)
	private String subcutaneousMucosaBleed;

	@Column(name = "OTHER_SELECT", columnDefinition = "VARCHAR2|其他-单选的||", length = 2, nullable = true)
	private String otherSelect;

	@Column(name = "EXPECTORATION", columnDefinition = "VARCHAR2|咳痰||", length = 2, nullable = true)
	private String expectoration;

	@Column(name = "CATARRH", columnDefinition = "VARCHAR2|上呼吸道卡他症状||", length = 2, nullable = true)
	private String catarrh;

	@Column(name = "CHEST_STUFLY", columnDefinition = "VARCHAR2|胸闷||", length = 2, nullable = true)
	private String chestStufly;

	@Column(name = "DYSPNEA_TYPE", columnDefinition = "VARCHAR2|呼吸困难||", length = 2, nullable = true)
	private String dyspneaType;

	@Column(name = "NASAL_OBSTRUCTION", columnDefinition = "VARCHAR2|鼻塞||", length = 2, nullable = true)
	private String nasalObstruction;

	@Column(name = "RUNNING_NOSE", columnDefinition = "VARCHAR2|流涕||", length = 2, nullable = true)
	private String runningNose;

	@Column(name = "CURE_DT", columnDefinition = "DATE|治疗日期||", nullable = true)
	private Date cureDt;

	@Column(name = "CHINESE_MEDICINE", columnDefinition = "VARCHAR2|曾用中药|100|", length = 100, nullable = true)
	private String chineseMedicine;

	@Column(name = "WESTERN_MEDICINE", columnDefinition = "VARCHAR2|曾用西药|100|", length = 100, nullable = true)
	private String westernMedicine;

	@Column(name = "ANTIBIOTICS_DT", columnDefinition = "DATE|抗菌素使用日期||", nullable = true)
	private Date antibioticsDt;

	@Column(name = "ANTIBIOTICS_DAYS", columnDefinition = "VARCHAR2|抗菌素使用天数|20|", length = 20, nullable = true)
	private String antibioticsDays;
	
	@Column(name = "CROW", columnDefinition = "VARCHAR2|鸡鸣声||", length = 2, nullable = true)
	private String crow;
	
	@Column(name = "LIP", columnDefinition = "VARCHAR2|唇青紫||", length = 2, nullable = true)
	private String lip;
	
	@Column(name = "JUGULAR_DISTENTION", columnDefinition = "VARCHAR2|颈静脉怒张||", length = 2, nullable = true)
	private String jugularDistention;
	
	@Column(name = "SLEEP_UNEASY", columnDefinition = "VARCHAR2|睡眠不安||", length = 2, nullable = true)
	private String sleepUneasy;
	
	@Column(name = "CHOKE_RESENTMENT", columnDefinition = "VARCHAR2|憋气||", length = 2, nullable = true)
	private String chokeResentment;
	
	@Column(name = "ASPHYXIA", columnDefinition = "VARCHAR2|窒息||", length = 2, nullable = true)
	private String asphyxia;

    @Column(name = "NIGHT_SWEAT", columnDefinition = "VARCHAR2|盗汗|2|", length = 2, nullable = true)
    private String nightSweat;

    @Column(name = "FIRST_DT", columnDefinition = "DATE|首诊日期||", nullable = true)
    private Date firstDt;

    @Column(name = "PULSE", columnDefinition = "VARCHAR2|脉搏|20|", length = 20, nullable = true)
    private String pulse;

    @Column(name = "WEIGHT", columnDefinition = "VARCHAR2|体重|20|", length = 20, nullable = true)
    private String weight;

    @Column(name = "SYMPTOM_DURATION", columnDefinition = "VARCHAR2|症状持续时间|2|", length = 2, nullable = true)
    private String symptomDuration;

    @Column(name = "CERCARIAL_DERMATITIS", columnDefinition = "VARCHAR2|尾蚴性皮炎|2|", length = 2, nullable = true)
    private String cercarialDermatitis;

    @Column(name = "LIVER_XIPHOID_BELOW", columnDefinition = "VARCHAR2|肝脏－剑突下|10|", length = 10, nullable = true)
    private String liverXiphoidBelow;

    @Column(name = "LIVER_RID_BELOW", columnDefinition = "VARCHAR2|肝脏－肋下|10|", length = 10, nullable = true)
    private String liverRidBelow;

    @Column(name = "LIVER_GRAIN", columnDefinition = "VARCHAR2|肝脏－质地|10|", length = 10, nullable = true)
    private String liverGrain;

    @Column(name = "LIVER_NODE", columnDefinition = "VARCHAR2|肝脏－结节|10|", length = 10, nullable = true)
    private String liverNode;

    @Column(name = "LIVER_TENDERNESS", columnDefinition = "VARCHAR2|肝脏－压痛|10|", length = 10, nullable = true)
    private String liverTenderness;

    @Column(name = "SPLEEN_SCOPE_UP", columnDefinition = "VARCHAR2|脾脏－上界|10|", length = 10, nullable = true)
    private String spleenScopeUp;

    @Column(name = "SPLEEN_RID_BELOW", columnDefinition = "VARCHAR2|脾脏－肋下|10|", length = 10, nullable = true)
    private String spleenRidBelow;

    @Column(name = "SPLEEN_TENDERNESS", columnDefinition = "VARCHAR2|脾脏－压痛|10|", length = 10, nullable = true)
    private String spleenTenderness;

    @Column(name = "CARDIAC_DULLNES", columnDefinition = "VARCHAR2|心浊音界|2|", length = 2, nullable = true)
    private String cardiacDullnes;

    @Column(name = "CARDIAC_DULLNES_DETAIL", columnDefinition = "VARCHAR2|心浊音界=扩大缩小|10|", length = 10, nullable = true)
    private String cardiacDullnesDetail;

    @Column(name = "LUNGS_DETAIL", columnDefinition = "VARCHAR2|肺-具体|100|", length = 100, nullable = true)
    private String lungsDetaiL;

    @Column(name = "BELLY_OUTLINE", columnDefinition = "VARCHAR2|腹部外形|2|", length = 2, nullable = true)
    private String bellyOutline;

    @Column(name = "DULL_SOUND", columnDefinition = "VARCHAR2|移动性浊音|2|", length = 2, nullable = true)
    private String dullSound;

    @Column(name = "VENA_EPIGASTRICA", columnDefinition = "VARCHAR2|腹壁静脉|2|", length = 2, nullable = true)
    private String venaEpigastrica;

    @Column(name = "LABOR_FORCE", columnDefinition = "VARCHAR2|劳动力|2|", length = 2, nullable = true)
    private String laborForce;

    @Column(name = "LABOR_STAMINA", columnDefinition = "VARCHAR2|劳动耐力|2|", length = 2, nullable = true)
    private String laborStamina;

    @Column(name = "NUTRITURE", columnDefinition = "VARCHAR2|营养状况|2|", length = 2, nullable = true)
    private String nutriture;

    @Column(name = "FORM_TYPE", columnDefinition = "VARCHAR2|形态|2|", length = 2, nullable = true)
    private String formType;

    @Column(name = "FORM_TYPE_OTHER", columnDefinition = "VARCHAR2|形态其他|100|", length = 100, nullable = true)
    private String formTypeOther;

    @Column(name = "BORDER_TYPE", columnDefinition = "VARCHAR2|边缘|2|", length = 2, nullable = true)
    private String borderType;

    @Column(name = "FACE_TYPE", columnDefinition = "VARCHAR2|表面|2|", length = 2, nullable = true)
    private String faceType;

    @Column(name = "COLOR_TYPE", columnDefinition = "VARCHAR2|颜色|2|", length = 2, nullable = true)
    private String colorType;

    @Column(name = "NUM_TYPE", columnDefinition = "VARCHAR2|数量|2|", length = 2, nullable = true)
    private String numType;

    @Column(name = "DISTRIBUTION_TYPE", columnDefinition = "VARCHAR2|分布|2|", length = 2, nullable = true)
    private String distributionType;

    @Column(name = "EYEBROW_TYPE", columnDefinition = "VARCHAR2|眉毛|2|", length = 2, nullable = true)
    private String eyebrowType;

    @Column(name = "EYEBROW_TYPE_OTHER", columnDefinition = "VARCHAR2|眉毛其他|100|", length = 100, nullable = true)
    private String eyebrowTypeOther;

    @Column(name = "N_CHECK", columnDefinition = "VARCHAR2|皮N检查|100|", length = 100, nullable = true)
    private String nCheck;

    @Column(name = "SENSIBILITY_CHECK", columnDefinition = "VARCHAR2|浅感觉检查|100|", length = 100, nullable = true)
    private String sensibilityCheck;

    @Column(name = "FEELING", columnDefinition = "VARCHAR2|感觉|2|", length = 2, nullable = true)
    private String feeling;

    @Column(name = "TOUCH", columnDefinition = "VARCHAR2|触觉|2|", length = 2, nullable = true)
    private String touch;

    @Column(name = "ALGESIA", columnDefinition = "VARCHAR2|痛觉|2|", length = 2, nullable = true)
    private String algesia;

    @Column(name = "DISABILITY", columnDefinition = "VARCHAR2|畸残|2|", length = 2, nullable = true)
    private String disability;

    @Column(name = "FACIAL_PARALYSIS", columnDefinition = "VARCHAR2|面瘫|2|", length = 2, nullable = true)
    private String facialParalysis;

    @Column(name = "RABBIT_EYE", columnDefinition = "VARCHAR2|兔眼|2|", length = 2, nullable = true)
    private String rabbitEye;

    @Column(name = "THE_EYE", columnDefinition = "VARCHAR2|眼部|2|", length = 2, nullable = true)
    private String theEye;

    @Column(name = "GO_BLIND", columnDefinition = "VARCHAR2|失明|2|", length = 2, nullable = true)
    private String goBlind;

    @Column(name = "CLAW_HAND", columnDefinition = "VARCHAR2|爪型手|2|", length = 2, nullable = true)
    private String clawHand;

    @Column(name = "APE_HAND", columnDefinition = "VARCHAR2|猿手|2|", length = 2, nullable = true)
    private String apeHand;

    @Column(name = "MUSCLE_ATROPHY", columnDefinition = "VARCHAR2|骨间肌萎缩|2|", length = 2, nullable = true)
    private String muscleAtrophy;

    @Column(name = "A_SHORT", columnDefinition = "VARCHAR2|指短缩|2|", length = 2, nullable = true)
    private String aShort;

    @Column(name = "METATARSAL_SHORT", columnDefinition = "VARCHAR2|趾跖短缩|2|", length = 2, nullable = true)
    private String metatarsalShort;

    @Column(name = "TALIPES_VARUS", columnDefinition = "VARCHAR2|足内翻|2|", length = 2, nullable = true)
    private String talipesVarus;

    @Column(name = "CLAW_TOE", columnDefinition = "VARCHAR2|爪型趾|2|", length = 2, nullable = true)
    private String clawToe;

    @Column(name = "WRIST_DROP", columnDefinition = "VARCHAR2|垂腕|2|", length = 2, nullable = true)
    private String wristDrop;

    @Column(name = "FOOT_DROP", columnDefinition = "VARCHAR2|垂足|2|", length = 2, nullable = true)
    private String footDrop;

    @Column(name = "FEELING_LOSE", columnDefinition = "VARCHAR2|保护性感觉丧失|2|", length = 2, nullable = true)
    private String feelingLose;

    @Column(name = "HAND", columnDefinition = "VARCHAR2|手|2|", length = 2, nullable = true)
    private String hand;

    @Column(name = "FOOT", columnDefinition = "VARCHAR2|足|2|", length = 2, nullable = true)
    private String foot;

    @Column(name = "EYE", columnDefinition = "VARCHAR2|眼|2|", length = 2, nullable = true)
    private String eye;

    @Column(name = "IS_ULCER", columnDefinition = "VARCHAR2|溃疡|2|", length = 2, nullable = true)
    private String isUlcer;

    @Column(name = "ULCER_HAND", columnDefinition = "VARCHAR2|溃疡－手|2|", length = 2, nullable = true)
    private String ulcerHand;

    @Column(name = "ULCER_LEG", columnDefinition = "VARCHAR2|溃疡－小腿|2|", length = 2, nullable = true)
    private String ulcerLeg;

    @Column(name = "ULCER_ANKLE", columnDefinition = "VARCHAR2|溃疡－踝|2|", length = 2, nullable = true)
    private String ulcerAnkle;

    @Column(name = "ULCER_FOOT", columnDefinition = "VARCHAR2|溃疡－足底|2|", length = 2, nullable = true)
    private String ulcerFoot;

    @Column(name = "ULCER_TOE", columnDefinition = "VARCHAR2|溃疡－趾|2|", length = 2, nullable = true)
    private String ulcerToe;

    @Column(name = "ULCER_OTHER", columnDefinition = "VARCHAR2|溃疡－其他|100|", length = 100, nullable = true)
    private String ulcerOther;

    @Column(name = "LYMPHEDEMA", columnDefinition = "VARCHAR2|淋巴水肿/橡皮肿|2|", length = 2, nullable = true)
    private String lymphedema;

    @Column(name = "UPPER_LIMB", columnDefinition = "VARCHAR2|上肢|2|", length = 2, nullable = true)
    private String upperLimb;

    @Column(name = "LOWER_LIMB", columnDefinition = "VARCHAR2|下肢|2|", length = 2, nullable = true)
    private String lowerLimb;

    @Column(name = "LEFT_STAGE", columnDefinition = "VARCHAR2|左期|20|", length = 20, nullable = true)
    private String leftStage;

    @Column(name = "RIGHT_STAGE", columnDefinition = "VARCHAR2|右期|20|", length = 20, nullable = true)
    private String rightStage;

    @Column(name = "LOWER_LIMB_LEFT", columnDefinition = "VARCHAR2|下肢左|20|", length = 20, nullable = true)
    private String lowerLimbLeft;

    @Column(name = "LOWER_LIMB_RIGHT", columnDefinition = "VARCHAR2|下肢右|20|", length = 20, nullable = true)
    private String lowerLimbRight;

    @Column(name = "PITTING_EDEMA", columnDefinition = "VARCHAR2|凹陷性水肿|2|", length = 2, nullable = true)
    private String pittingEdema;

    @Column(name = "SKIN", columnDefinition = "VARCHAR2|皮肤|2|", length = 2, nullable = true)
    private String skin;

    @Column(name = "SKIN_THICHEN", columnDefinition = "VARCHAR2|皮肤增厚|2|", length = 2, nullable = true)
    private String skinThichen;

    @Column(name = "SKIN_FOLD", columnDefinition = "VARCHAR2|皮肤皱褶|2|", length = 2, nullable = true)
    private String skinFold;

    @Column(name = "DEFORMITY", columnDefinition = "VARCHAR2|患肢畸形|2|", length = 2, nullable = true)
    private String deformity;

    @Column(name = "DYSFUNCTION", columnDefinition = "VARCHAR2|功能障碍|2|", length = 2, nullable = true)
    private String dysfunction;

    @Column(name = "GRADING", columnDefinition = "VARCHAR2|脾脏-分级|2|", length = 2, nullable = true)
    private String grading;
 
	@Column(name = "PSYCHOSIS", columnDefinition = "VARCHAR2|精神状态||", length = 2, nullable = true)
	private String psychosis;
	
	//登革热
	@Column(name = "ONSET_FROM_DAY", columnDefinition = "VARCHAR2|起病急起病后从第几天|20|", length = 20, nullable = true)
	private String onsetFromDay;
	@Column(name = "ONSET_TO_DAY", columnDefinition = "VARCHAR2|起病急起病后到第几天|20|", length = 20, nullable = true)
	private String onsetToDay;
	@Column(name = "FEVER_FROM_DAY", columnDefinition = "VARCHAR2|发热起病后从第几天|20|", length = 20, nullable = true)
	private String feverFromDay;
	@Column(name = "FEVER_TO_DAY", columnDefinition = "VARCHAR2|发热起病后到第几天|20|", length = 20, nullable = true)
	private String feverToDay;
	@Column(name = "HEADACHE_FROM_DAY", columnDefinition = "VARCHAR2|头痛起病后从第几天|20|", length = 20, nullable = true)
	private String headacheFromDay;
	@Column(name = "HEADACHE_TO_DAY", columnDefinition = "VARCHAR2|头痛起病后到第几天|20|", length = 20, nullable = true)
	private String headacheToDay;
	@Column(name = "FACIAL_BLUSHING_FROM_DAY", columnDefinition = "VARCHAR2|颜面潮红起病后从第几天|20|", length = 20, nullable = true)
	private String facialBlushingFromDay;
	@Column(name = "FACIAL_BLUSHING_TO_DAY", columnDefinition = "VARCHAR2|颜面潮红起病后到第几天|20|", length = 20, nullable = true)
	private String facialBlushingToDay;
	@Column(name = "ORBIT_PAIN_FROM_DAY", columnDefinition = "VARCHAR2|眼眶后痛起病后从第几天|20|", length = 20, nullable = true)
	private String orbitPainFromDay;
	@Column(name = "ORBIT_PAIN_TO_DAY", columnDefinition = "VARCHAR2|眼眶后痛起病后到第几天|20|", length = 20, nullable = true)
	private String orbitPainToDay;
	@Column(name = "MYALGIA_FROM_DAY", columnDefinition = "VARCHAR2|肌肉痛起病后从第几天|20|", length = 20, nullable = true)
	private String myalgiaFromDay;
	@Column(name = "MYALGIA_TO_DAY", columnDefinition = "VARCHAR2|肌肉痛起病后到第几天|20|", length = 20, nullable = true)
	private String myalgiaToDay;
	@Column(name = "LIMB_ACHE_FROM_DAY", columnDefinition = "VARCHAR2|关节痛起病后从第几天|20|", length = 20, nullable = true)
	private String limbAcheFromDay;
	@Column(name = "LIMB_ACHE_TO_DAY", columnDefinition = "VARCHAR2|关节痛起病后到第几天态|20|", length = 20, nullable = true)
	private String limbAcheToDay;
	@Column(name = "EPISTAXIS_FROM_DAY", columnDefinition = "VARCHAR2|鼻出血起病后从第几天|20|", length = 20, nullable = true)
	private String epistaxisFromDay;
	@Column(name = "EPISTAXIS_TO_DAY", columnDefinition = "VARCHAR2|鼻出血起病后到第几天|20|", length = 20, nullable = true)
	private String epistaxisToDay;
	@Column(name = "GINGIVAL_BLEEDING_FROM_DAY", columnDefinition = "VARCHAR2|牙龈出血起病后从第几天|20|", length = 20, nullable = true)
	private String gingivalBleedingFromDay;
	@Column(name = "GINGIVAL_BLEEDING_TO_DAY", columnDefinition = "VARCHAR2|牙龈出血起病后到第几天|20|", length = 20, nullable = true)
	private String gingivalBleedingToDay;
	@Column(name = "HAEMATEMESIS_FROM_DAY", columnDefinition = "VARCHAR2|呕血起病后从第几天|20|", length = 20, nullable = true)
	private String haematemesisFromDay;
	@Column(name = "HAEMATEMESIS_TO_DAY", columnDefinition = "VARCHAR2|呕血起病后到第几天|20|", length = 20, nullable = true)
	private String haematemesisToDay;
	@Column(name = "HEMAFECIA_FROM_DAY", columnDefinition = "VARCHAR2|便血起病后从第几天|20|", length = 20, nullable = true)
	private String hemafeciaFromDay;
	@Column(name = "HEMAFECIA_TO_DAY", columnDefinition = "VARCHAR2|便血起病后到第几天|20|", length = 20, nullable = true)
	private String hemafeciaToDay;
	@Column(name = "HEMATURESIS_FROM_DAY", columnDefinition = "VARCHAR2|血尿起病后从第几天|20|", length = 20, nullable = true)
	private String hematuresisFromDay;
	@Column(name = "HEMATURESIS_TO_DAY", columnDefinition = "VARCHAR2|血尿起病后到第几天|20|", length = 20, nullable = true)
	private String hematuresisToDay;
	@Column(name = "SKIN_BLE_TYPE_OTH_FROM_DAY", columnDefinition = "VARCHAR2|其他出血起病后从第几天|20|", length = 20, nullable = true)
	private String skinBleTypeOthFromDay;
	@Column(name = "SKIN_BLE_TYPE_OTH_TO_DAY", columnDefinition = "VARCHAR2|其他出血起病后到第几天|20|", length = 20, nullable = true)
	private String skinBleTypeOthToDay;
	@Column(name = "BLEEDING_SPOTS_SKIN_FROM_DAY", columnDefinition = "VARCHAR2|皮肤出血点起病后从第几天|20|", length = 20, nullable = true)
	private String bleedingSpotsSkinFromDay;
	@Column(name = "BLEEDING_SPOTS_SKIN_TO_DAY", columnDefinition = "VARCHAR2|皮肤出血点起病后到第几天|20|", length = 20, nullable = true)
	private String bleedingSpotsSkinToDay;
	@Column(name = "RASH_TYPE_FROM_DAY", columnDefinition = "VARCHAR2|皮疹（形态）起病后从第几天|20|", length = 20, nullable = true)
	private String rashTypeFromDay;
	@Column(name = "RASH_TYPE_TO_DAY", columnDefinition = "VARCHAR2|皮疹（形态）起病后到第几天|20|", length = 20, nullable = true)
	private String rashTypeToDay;
	@Column(name = "RASH_PARTS_FROM_DAY", columnDefinition = "VARCHAR2|皮疹（部位）起病后从第几天|20|", length = 20, nullable = true)
	private String rashPartsFromDay;
	@Column(name = "RASH_PARTS_TO_DAY", columnDefinition = "VARCHAR2|皮疹（部位）起病后到第几天|20|", length = 20, nullable = true)
	private String rashPartsToDay;
	@Column(name = "IRRITABILITY_FROM_DAY", columnDefinition = "VARCHAR2|烦躁起病后从第几天|20|", length = 20, nullable = true)
	private String irritabilityFromDay;
	@Column(name = "IRRITABILITY_TO_DAY", columnDefinition = "VARCHAR2|烦躁起病后到第几天|20|", length = 20, nullable = true)
	private String irritabilityToDay;
	@Column(name = "COMA_FROM_DAY", columnDefinition = "VARCHAR2|昏迷起病后从第几天|20|", length = 20, nullable = true)
	private String comaFromDay;
	@Column(name = "COMA_TO_DAY", columnDefinition = "VARCHAR2|昏迷起病后到第几天|20|", length = 20, nullable = true)
	private String comaToDay;
	@Column(name = "SEPTIC_STOCK_FROM_DAY", columnDefinition = "VARCHAR2|休克起病后从第几天|20|", length = 20, nullable = true)
	private String septicStockFromDay;
	@Column(name = "SEPTIC_STOCK_TO_DAY", columnDefinition = "VARCHAR2|休克起病后到第几天|20|", length = 20, nullable = true)
	private String septicStockToDay;	
	@Column(name = "HEPATOMEGALY_FROM_DAY", columnDefinition = "VARCHAR2|肝肿大起病后从第几天|20|", length = 20, nullable = true)
	private String hepatomegalyFromDay;
	@Column(name = "HEPATOMEGALY_TO_DAY", columnDefinition = "VARCHAR2|肝肿大起病后到第几天|20|", length = 20, nullable = true)
	private String hepatomegalyToDay;
	@Column(name = "SPLENOMEGALY_FROM_DAY", columnDefinition = "VARCHAR2|脾肿大起病后从第几天|20|", length = 20, nullable = true)
	private String splenomegalyFromDay;
	@Column(name = "SPLENOMEGALY_TO_DAY", columnDefinition = "VARCHAR2|脾肿大起病后到第几天|20|", length = 20, nullable = true)
	private String splenomegalyToDay;
	@Column(name = "LYMPHADENECTASIS_SKIN_FROM_DAY", columnDefinition = "VARCHAR2|淋巴结大起病后从第几天|20|", length = 20, nullable = true)
	private String lymphadenectasisSkinFromDay;
	@Column(name = "LYMPHADENECTASIS_SKIN_TO_DAY", columnDefinition = "VARCHAR2|淋巴结大起病后到第几天|20|", length = 20, nullable = true)
	private String lymphadenectasisSkinToDay;
	@Column(name = "CLINICAL_KIND", columnDefinition = "VARCHAR2|诊断类型|20|", length = 20, nullable = true)
	private String clinicalKind;
	@Column(name = "CUFF_BUTTER", columnDefinition = "VARCHAR2|束臂试验|20|", length = 20, nullable = true)
	private String cuffButter;
	@Column(name = "CUFF_BUTTER_FROM_DAY", columnDefinition = "VARCHAR2|束臂试验起病后从第几天|20|", length = 20, nullable = true)
	private String cuffButterFromDay;
	@Column(name = "CUFF_BUTTER_TO_DAY", columnDefinition = "VARCHAR2|束臂试验起病后到第几天|20|", length = 20, nullable = true)
	private String cuffButterToDay;
	@Column(name = "LEG_PAIN", columnDefinition = "VARCHAR2|腿痛||", length = 2, nullable = true)
	private String legPain;

	@Column(name = "BACKACHE", columnDefinition = "VARCHAR2|腰酸||", length = 2, nullable = true)
	private String backache;
	
	@Column(name = "HEMORRHAGE", columnDefinition = "VARCHAR2|出血||", length = 50, nullable = true)
	private String hemorrhage;
	
	@Column(name = "URINE", columnDefinition = "VARCHAR2|小便情况||", length = 50, nullable = true)
	private String urine;
	
	@Column(name = "PROTEINURIA", columnDefinition = "VARCHAR2|蛋白尿 ||", length = 50, nullable = true)
	private String proteinuria;
	//风疹
	@Column(name = "HOT_BACK_DATE", columnDefinition = "DATE|退热日期 ||", nullable = true)
	private Date hotBackDate;
	@Column(name = "BACK_RASH_DATE", columnDefinition = "VARCHAR2|退疹日期||", nullable = true)
	private Date backRashDate;
	//伤寒、副伤寒
	@Column(name = "SIGN", columnDefinition = "VARCHAR2|症状与体征|100|", length = 100, nullable = true)
	private String sign;

	@Column(name = "ORAL_MUCOSAL_PATCHES", columnDefinition = "VARCHAR2|诊断类型|2|", length = 2, nullable = true)
	private String oralMucosalPatches;


	//腹泻
	@Column(name = "GASTROCNEMIUS", columnDefinition = "VARCHAR2|腓肠肌疼痛|2|", length = 2, nullable = true)
	private String gastrocnemius;
	@Column(name = "DIARRHEA_PATTERN", columnDefinition = "VARCHAR2|腹泻方式|2|", length = 2, nullable = true)
	private String diarrheaPattern;
	@Column(name = "FX_FOUNDER", columnDefinition = "VARCHAR2|感染者发现方式|2|", length = 2, nullable = true)
	private String fxFounder;
	@Column(name = "FX_OTHER", columnDefinition = "VARCHAR2|其他|100|", length = 100, nullable = true)
	private String fxOther;
	@Column(name = "FX_BASIS", columnDefinition = "VARCHAR2|确诊依据|2|", length = 2, nullable = true)
	private String fxBasis;
	@Column(name = "FX_SAMPLE_DATE", columnDefinition = "DATE|采样时间||", nullable = true)
	private Date fxSampleDate;
	@Column(name = "FX_SAMPLE_NAME", columnDefinition = "VARCHAR2|标本名称|100|", length = 100, nullable = true)
	private String fxSampleName;
	@Column(name = "FX_RESULT_DATE", columnDefinition = "DATE|报告时间||", nullable = true)
	private Date fxResultDate;
	@Column(name = "RED_CELL", columnDefinition = "VARCHAR2|红细胞|100|", length = 100, nullable = true)
	private String redCell;
	@Column(name = "WHITE_CELL", columnDefinition = "VARCHAR2|白细胞|100|", length = 100, nullable = true)
	private String whiteCell;
	@Column(name = "PUS_CELL", columnDefinition = "VARCHAR2|脓细胞|100|", length = 100, nullable = true)
	private String pusCell;
	@Column(name = "FX_SUREM_RESULT", columnDefinition = "VARCHAR2|血清学检验结果|100|", length =100, nullable = true)
	private String fxSuremResult;
	@Column(name = "PATIENT_RETURN", columnDefinition = "VARCHAR2|病人转归|2|", length = 2, nullable = true)
	private String patientReturn;
	@Column(name = "FX_DEATH_REASON", columnDefinition = "VARCHAR2|死因|100|", length = 100, nullable = true)
	private String fxDeathReason;

	//布病
	@Column(name = "ANTIBIOBIC_TREAT", columnDefinition = "VARCHAR2|抗生素治疗|2|", length = 2, nullable = true)
	private String antibiobicTreat;
	@Column(name = "ANTIGEN_TREAT", columnDefinition = "VARCHAR2|抗原治疗|2|", length = 2, nullable = true)
	private String antigenTreat;
	@Column(name = "HYDROLYSIS_TREAT", columnDefinition = "VARCHAR2|水解素治疗|2|", length = 2, nullable = true)
	private String hydrolysisTreat;
	@Column(name = "BACTERIOLYSIN_TREAT", columnDefinition = "VARCHAR2|溶菌素治疗|2|", length = 2, nullable = true)
	private String bacteriolysinTreat;
	@Column(name = "GRAY_PSEUDOME", columnDefinition = "VARCHAR2|鼻咽部有不易剥落的灰白色假膜|2|", length = 2, nullable = true)
	private String grayPseudome;
	//腮腺
	@Column(name = "SX_SWEL", columnDefinition = "VARCHAR2|腮腺非化脓性肿胀|2|", length = 2, nullable = true)
	private String sxSwel;
	@Column(name = "SX_SWEL_OTHER", columnDefinition = "VARCHAR2|其他唾液腺非化脓性肿胀|2|", length = 2, nullable = true)
	private String sxSwelOther;
	@Column(name = "SX_ACID", columnDefinition = "VARCHAR2|含酸性食物胀痛加剧|2|", length = 2, nullable = true)
	private String sxAcid;
	@Column(name = "SX_MATER", columnDefinition = "VARCHAR2|脑膜刺激征|2|", length = 2, nullable = true)
	private String sxMater;
	@Column(name = "SX_PAIN", columnDefinition = "VARCHAR2|睾丸胀痛|2|", length = 2, nullable = true)
	private String sxPain;

	@Column(name = "PATHOROGICAL_REFLEX", columnDefinition = "VARCHAR2|病理反射|2|", length = 2, nullable = true)
	private String pathorogicalReflex;

	public String getPathorogicalReflex() {
		return pathorogicalReflex;
	}

	public void setPathorogicalReflex(String pathorogicalReflex) {
		this.pathorogicalReflex = pathorogicalReflex;
	}

	public String getCuffButter() {
		return cuffButter;
	}

	public void setCuffButter(String cuffButter) {
		this.cuffButter = cuffButter;
	}

	public String getCuffButterFromDay() {
		return cuffButterFromDay;
	}

	public void setCuffButterFromDay(String cuffButterFromDay) {
		this.cuffButterFromDay = cuffButterFromDay;
	}

	public String getCuffButterToDay() {
		return cuffButterToDay;
	}

	public void setCuffButterToDay(String cuffButterToDay) {
		this.cuffButterToDay = cuffButterToDay;
	}

	public String getSxSwel() {
		return sxSwel;
	}

	public void setSxSwel(String sxSwel) {
		this.sxSwel = sxSwel;
	}

	public String getSxSwelOther() {
		return sxSwelOther;
	}

	public void setSxSwelOther(String sxSwelOther) {
		this.sxSwelOther = sxSwelOther;
	}

	public String getSxAcid() {
		return sxAcid;
	}

	public void setSxAcid(String sxAcid) {
		this.sxAcid = sxAcid;
	}

	public String getSxMater() {
		return sxMater;
	}

	public void setSxMater(String sxMater) {
		this.sxMater = sxMater;
	}

	public String getSxPain() {
		return sxPain;
	}

	public void setSxPain(String sxPain) {
		this.sxPain = sxPain;
	}

	public String getGrayPseudome() {
		return grayPseudome;
	}

	public void setGrayPseudome(String grayPseudome) {
		this.grayPseudome = grayPseudome;
	}


	public String getAntibiobicTreat() {
		return antibiobicTreat;
	}

	public void setAntibiobicTreat(String antibiobicTreat) {
		this.antibiobicTreat = antibiobicTreat;
	}

	public String getAntigenTreat() {
		return antigenTreat;
	}

	public void setAntigenTreat(String antigenTreat) {
		this.antigenTreat = antigenTreat;
	}

	public String getHydrolysisTreat() {
		return hydrolysisTreat;
	}

	public void setHydrolysisTreat(String hydrolysisTreat) {
		this.hydrolysisTreat = hydrolysisTreat;
	}

	public String getBacteriolysinTreat() {
		return bacteriolysinTreat;
	}

	public void setBacteriolysinTreat(String bacteriolysinTreat) {
		this.bacteriolysinTreat = bacteriolysinTreat;
	}

	public String getOralMucosalPatches() {
		return oralMucosalPatches;
	}

	public void setOralMucosalPatches(String oralMucosalPatches) {
		this.oralMucosalPatches = oralMucosalPatches;
	}

	public String getGastrocnemius() {
		return gastrocnemius;
	}

	public void setGastrocnemius(String gastrocnemius) {
		this.gastrocnemius = gastrocnemius;
	}

	public String getDiarrheaPattern() {
		return diarrheaPattern;
	}

	public void setDiarrheaPattern(String diarrheaPattern) {
		this.diarrheaPattern = diarrheaPattern;
	}

	public String getFxFounder() {
		return fxFounder;
	}

	public void setFxFounder(String fxFounder) {
		this.fxFounder = fxFounder;
	}

	public String getFxOther() {
		return fxOther;
	}

	public void setFxOther(String fxOther) {
		this.fxOther = fxOther;
	}

	public String getFxBasis() {
		return fxBasis;
	}

	public void setFxBasis(String fxBasis) {
		this.fxBasis = fxBasis;
	}

	public Date getFxSampleDate() {
		return fxSampleDate;
	}

	public void setFxSampleDate(Date fxSampleDate) {
		this.fxSampleDate = fxSampleDate;
	}

	public String getFxSampleName() {
		return fxSampleName;
	}

	public void setFxSampleName(String fxSampleName) {
		this.fxSampleName = fxSampleName;
	}

	public Date getFxResultDate() {
		return fxResultDate;
	}

	public void setFxResultDate(Date fxResultDate) {
		this.fxResultDate = fxResultDate;
	}

	public String getRedCell() {
		return redCell;
	}

	public void setRedCell(String redCell) {
		this.redCell = redCell;
	}

	public String getWhiteCell() {
		return whiteCell;
	}

	public void setWhiteCell(String whiteCell) {
		this.whiteCell = whiteCell;
	}

	public String getPusCell() {
		return pusCell;
	}

	public void setPusCell(String pusCell) {
		this.pusCell = pusCell;
	}

	public String getFxSuremResult() {
		return fxSuremResult;
	}

	public void setFxSuremResult(String fxSuremResult) {
		this.fxSuremResult = fxSuremResult;
	}

	public String getPatientReturn() {
		return patientReturn;
	}

	public void setPatientReturn(String patientReturn) {
		this.patientReturn = patientReturn;
	}

	public String getFxDeathReason() {
		return fxDeathReason;
	}

	public void setFxDeathReason(String fxDeathReason) {
		this.fxDeathReason = fxDeathReason;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Date getBackRashDate() {
		return backRashDate;
	}

	public void setBackRashDate(Date backRashDate) {
		this.backRashDate = backRashDate;
	}

	public Date getHotBackDate() {
		return hotBackDate;
	}

	public void setHotBackDate(Date hotBackDate) {
		this.hotBackDate = hotBackDate;
	}

	public String getProteinuria() {
		return proteinuria;
	}

	public void setProteinuria(String proteinuria) {
		this.proteinuria = proteinuria;
	}

	public String getUrine() {
		return urine;
	}

	public void setUrine(String urine) {
		this.urine = urine;
	}

	public String getHemorrhage() {
		return hemorrhage;
	}

	public void setHemorrhage(String hemorrhage) {
		this.hemorrhage = hemorrhage;
	}

	public String getLegPain() {
		return legPain;
	}

	public void setLegPain(String legPain) {
		this.legPain = legPain;
	}

	public String getBackache() {
		return backache;
	}

	public void setBackache(String backache) {
		this.backache = backache;
	}

	public String getClinicalKind() {
		return clinicalKind;
	}

	public void setClinicalKind(String clinicalKind) {
		this.clinicalKind = clinicalKind;
	}

	@Column(name = "STOOL_PROPERTY_OTHER", columnDefinition = "VARCHAR2|大便性状-其他||", length = 50, nullable = true)
	private String stoolPropertyOther;
	
	public String getStoolPropertyOther() {
		return stoolPropertyOther;
	}

	public void setStoolPropertyOther(String stoolPropertyOther) {
		this.stoolPropertyOther = stoolPropertyOther;
	}

	public String getOnsetFromDay() {
		return onsetFromDay;
	}

	public void setOnsetFromDay(String onsetFromDay) {
		this.onsetFromDay = onsetFromDay;
	}

	public String getOnsetToDay() {
		return onsetToDay;
	}

	public void setOnsetToDay(String onsetToDay) {
		this.onsetToDay = onsetToDay;
	}

	public String getFeverFromDay() {
		return feverFromDay;
	}

	public void setFeverFromDay(String feverFromDay) {
		this.feverFromDay = feverFromDay;
	}

	public String getFeverToDay() {
		return feverToDay;
	}

	public void setFeverToDay(String feverToDay) {
		this.feverToDay = feverToDay;
	}

	public String getHeadacheFromDay() {
		return headacheFromDay;
	}

	public void setHeadacheFromDay(String headacheFromDay) {
		this.headacheFromDay = headacheFromDay;
	}

	public String getHeadacheToDay() {
		return headacheToDay;
	}

	public void setHeadacheToDay(String headacheToDay) {
		this.headacheToDay = headacheToDay;
	}

	public String getFacialBlushingFromDay() {
		return facialBlushingFromDay;
	}

	public void setFacialBlushingFromDay(String facialBlushingFromDay) {
		this.facialBlushingFromDay = facialBlushingFromDay;
	}

	public String getFacialBlushingToDay() {
		return facialBlushingToDay;
	}

	public void setFacialBlushingToDay(String facialBlushingToDay) {
		this.facialBlushingToDay = facialBlushingToDay;
	}

	public String getOrbitPainFromDay() {
		return orbitPainFromDay;
	}

	public void setOrbitPainFromDay(String orbitPainFromDay) {
		this.orbitPainFromDay = orbitPainFromDay;
	}

	public String getOrbitPainToDay() {
		return orbitPainToDay;
	}

	public void setOrbitPainToDay(String orbitPainToDay) {
		this.orbitPainToDay = orbitPainToDay;
	}

	public String getMyalgiaFromDay() {
		return myalgiaFromDay;
	}

	public void setMyalgiaFromDay(String myalgiaFromDay) {
		this.myalgiaFromDay = myalgiaFromDay;
	}

	public String getMyalgiaToDay() {
		return myalgiaToDay;
	}

	public void setMyalgiaToDay(String myalgiaToDay) {
		this.myalgiaToDay = myalgiaToDay;
	}

	public String getLimbAcheFromDay() {
		return limbAcheFromDay;
	}

	public void setLimbAcheFromDay(String limbAcheFromDay) {
		this.limbAcheFromDay = limbAcheFromDay;
	}

	public String getLimbAcheToDay() {
		return limbAcheToDay;
	}

	public void setLimbAcheToDay(String limbAcheToDay) {
		this.limbAcheToDay = limbAcheToDay;
	}

	public String getEpistaxisFromDay() {
		return epistaxisFromDay;
	}

	public void setEpistaxisFromDay(String epistaxisFromDay) {
		this.epistaxisFromDay = epistaxisFromDay;
	}

	public String getEpistaxisToDay() {
		return epistaxisToDay;
	}

	public void setEpistaxisToDay(String epistaxisToDay) {
		this.epistaxisToDay = epistaxisToDay;
	}

	public String getGingivalBleedingFromDay() {
		return gingivalBleedingFromDay;
	}

	public void setGingivalBleedingFromDay(String gingivalBleedingFromDay) {
		this.gingivalBleedingFromDay = gingivalBleedingFromDay;
	}

	public String getGingivalBleedingToDay() {
		return gingivalBleedingToDay;
	}

	public void setGingivalBleedingToDay(String gingivalBleedingToDay) {
		this.gingivalBleedingToDay = gingivalBleedingToDay;
	}

	public String getHaematemesisFromDay() {
		return haematemesisFromDay;
	}

	public void setHaematemesisFromDay(String haematemesisFromDay) {
		this.haematemesisFromDay = haematemesisFromDay;
	}

	public String getHaematemesisToDay() {
		return haematemesisToDay;
	}

	public void setHaematemesisToDay(String haematemesisToDay) {
		this.haematemesisToDay = haematemesisToDay;
	}

	public String getHemafeciaFromDay() {
		return hemafeciaFromDay;
	}

	public void setHemafeciaFromDay(String hemafeciaFromDay) {
		this.hemafeciaFromDay = hemafeciaFromDay;
	}

	public String getHemafeciaToDay() {
		return hemafeciaToDay;
	}

	public void setHemafeciaToDay(String hemafeciaToDay) {
		this.hemafeciaToDay = hemafeciaToDay;
	}

	public String getHematuresisFromDay() {
		return hematuresisFromDay;
	}

	public void setHematuresisFromDay(String hematuresisFromDay) {
		this.hematuresisFromDay = hematuresisFromDay;
	}

	public String getHematuresisToDay() {
		return hematuresisToDay;
	}

	public void setHematuresisToDay(String hematuresisToDay) {
		this.hematuresisToDay = hematuresisToDay;
	}

	public String getSkinBleTypeOthFromDay() {
		return skinBleTypeOthFromDay;
	}

	public void setSkinBleTypeOthFromDay(String skinBleTypeOthFromDay) {
		this.skinBleTypeOthFromDay = skinBleTypeOthFromDay;
	}

	public String getSkinBleTypeOthToDay() {
		return skinBleTypeOthToDay;
	}

	public void setSkinBleTypeOthToDay(String skinBleTypeOthToDay) {
		this.skinBleTypeOthToDay = skinBleTypeOthToDay;
	}

	public String getBleedingSpotsSkinFromDay() {
		return bleedingSpotsSkinFromDay;
	}

	public void setBleedingSpotsSkinFromDay(String bleedingSpotsSkinFromDay) {
		this.bleedingSpotsSkinFromDay = bleedingSpotsSkinFromDay;
	}

	public String getBleedingSpotsSkinToDay() {
		return bleedingSpotsSkinToDay;
	}

	public void setBleedingSpotsSkinToDay(String bleedingSpotsSkinToDay) {
		this.bleedingSpotsSkinToDay = bleedingSpotsSkinToDay;
	}

	public String getRashTypeFromDay() {
		return rashTypeFromDay;
	}

	public void setRashTypeFromDay(String rashTypeFromDay) {
		this.rashTypeFromDay = rashTypeFromDay;
	}

	public String getRashTypeToDay() {
		return rashTypeToDay;
	}

	public void setRashTypeToDay(String rashTypeToDay) {
		this.rashTypeToDay = rashTypeToDay;
	}

	public String getRashPartsFromDay() {
		return rashPartsFromDay;
	}

	public void setRashPartsFromDay(String rashPartsFromDay) {
		this.rashPartsFromDay = rashPartsFromDay;
	}

	public String getRashPartsToDay() {
		return rashPartsToDay;
	}

	public void setRashPartsToDay(String rashPartsToDay) {
		this.rashPartsToDay = rashPartsToDay;
	}

	public String getIrritabilityFromDay() {
		return irritabilityFromDay;
	}

	public void setIrritabilityFromDay(String irritabilityFromDay) {
		this.irritabilityFromDay = irritabilityFromDay;
	}

	public String getIrritabilityToDay() {
		return irritabilityToDay;
	}

	public void setIrritabilityToDay(String irritabilityToDay) {
		this.irritabilityToDay = irritabilityToDay;
	}

	public String getComaFromDay() {
		return comaFromDay;
	}

	public void setComaFromDay(String comaFromDay) {
		this.comaFromDay = comaFromDay;
	}

	public String getComaToDay() {
		return comaToDay;
	}

	public void setComaToDay(String comaToDay) {
		this.comaToDay = comaToDay;
	}

	public String getSepticStockFromDay() {
		return septicStockFromDay;
	}

	public void setSepticStockFromDay(String septicStockFromDay) {
		this.septicStockFromDay = septicStockFromDay;
	}

	public String getSepticStockToDay() {
		return septicStockToDay;
	}

	public void setSepticStockToDay(String septicStockToDay) {
		this.septicStockToDay = septicStockToDay;
	}

	public String getHepatomegalyFromDay() {
		return hepatomegalyFromDay;
	}

	public void setHepatomegalyFromDay(String hepatomegalyFromDay) {
		this.hepatomegalyFromDay = hepatomegalyFromDay;
	}

	public String getHepatomegalyToDay() {
		return hepatomegalyToDay;
	}

	public void setHepatomegalyToDay(String hepatomegalyToDay) {
		this.hepatomegalyToDay = hepatomegalyToDay;
	}

	public String getSplenomegalyFromDay() {
		return splenomegalyFromDay;
	}

	public void setSplenomegalyFromDay(String splenomegalyFromDay) {
		this.splenomegalyFromDay = splenomegalyFromDay;
	}

	public String getSplenomegalyToDay() {
		return splenomegalyToDay;
	}

	public void setSplenomegalyToDay(String splenomegalyToDay) {
		this.splenomegalyToDay = splenomegalyToDay;
	}

	public String getLymphadenectasisSkinFromDay() {
		return lymphadenectasisSkinFromDay;
	}

	public void setLymphadenectasisSkinFromDay(String lymphadenectasisSkinFromDay) {
		this.lymphadenectasisSkinFromDay = lymphadenectasisSkinFromDay;
	}

	public String getLymphadenectasisSkinToDay() {
		return lymphadenectasisSkinToDay;
	}

	public void setLymphadenectasisSkinToDay(String lymphadenectasisSkinToDay) {
		this.lymphadenectasisSkinToDay = lymphadenectasisSkinToDay;
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

	public String getTemperature() {
		return this.temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getVomitCharacter() {
		return this.vomitCharacter;
	}

	public void setVomitCharacter(String vomitCharacter) {
		this.vomitCharacter = vomitCharacter;
	}

	public String getStoolProperty() {
		return this.stoolProperty;
	}

	public void setStoolProperty(String stoolProperty) {
		this.stoolProperty = stoolProperty;
	}

	public String getAbdominalPainParts() {
		return this.abdominalPainParts;
	}

	public void setAbdominalPainParts(String abdominalPainParts) {
		this.abdominalPainParts = abdominalPainParts;
	}

	public String getPasteurelleses() {
		return this.pasteurelleses;
	}

	public void setPasteurelleses(String pasteurelleses) {
		this.pasteurelleses = pasteurelleses;
	}

	public String getBrucellosis() {
		return this.brucellosis;
	}

	public void setBrucellosis(String brucellosis) {
		this.brucellosis = brucellosis;
	}

	public String getLouGehrigsDisease() {
		return this.louGehrigsDisease;
	}

	public void setLouGehrigsDisease(String louGehrigsDisease) {
		this.louGehrigsDisease = louGehrigsDisease;
	}

	public String getLymphadenectasisPart() {
		return this.lymphadenectasisPart;
	}

	public void setLymphadenectasisPart(String lymphadenectasisPart) {
		this.lymphadenectasisPart = lymphadenectasisPart;
	}

	public Date getSymptomsTime() {
		return this.symptomsTime;
	}

	public void setSymptomsTime(Date symptomsTime) {
		this.symptomsTime = symptomsTime;
	}

	public String getSpotPimples() {
		return this.spotPimples;
	}

	public void setSpotPimples(String spotPimples) {
		this.spotPimples = spotPimples;
	}

	public String getOtherThanSpotPimples() {
		return this.otherThanSpotPimples;
	}

	public void setOtherThanSpotPimples(String otherThanSpotPimples) {
		this.otherThanSpotPimples = otherThanSpotPimples;
	}

	public String getAppearances() {
		return this.appearances;
	}

	public void setAppearances(String appearances) {
		this.appearances = appearances;
	}

	public String getUnInguinalLymphNodes() {
		return this.unInguinalLymphNodes;
	}

	public void setUnInguinalLymphNodes(String unInguinalLymphNodes) {
		this.unInguinalLymphNodes = unInguinalLymphNodes;
	}

	public String getRash() {
		return this.rash;
	}

	public void setRash(String rash) {
		this.rash = rash;
	}

	public String getCondyloma() {
		return this.condyloma;
	}

	public void setCondyloma(String condyloma) {
		this.condyloma = condyloma;
	}

	public String getAlopeciasyphilitica() {
		return this.alopeciasyphilitica;
	}

	public void setAlopeciasyphilitica(String alopeciasyphilitica) {
		this.alopeciasyphilitica = alopeciasyphilitica;
	}

	public String getSyphiliticLeukoderma() {
		return this.syphiliticLeukoderma;
	}

	public void setSyphiliticLeukoderma(String syphiliticLeukoderma) {
		this.syphiliticLeukoderma = syphiliticLeukoderma;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getFever() {
		return this.fever;
	}

	public void setFever(String fever) {
		this.fever = fever;
	}

	public String getHighestTemperature() {
		return this.highestTemperature;
	}

	public void setHighestTemperature(String highestTemperature) {
		this.highestTemperature = highestTemperature;
	}

	public String getHeatingDuration() {
		return this.heatingDuration;
	}

	public void setHeatingDuration(String heatingDuration) {
		this.heatingDuration = heatingDuration;
	}

	public String getChills() {
		return this.chills;
	}

	public void setChills(String chills) {
		this.chills = chills;
	}

	public String getWholeBodyPain() {
		return this.wholeBodyPain;
	}

	public void setWholeBodyPain(String wholeBodyPain) {
		this.wholeBodyPain = wholeBodyPain;
	}

	public String getGastrocnemiusPain() {
		return this.gastrocnemiusPain;
	}

	public void setGastrocnemiusPain(String gastrocnemiusPain) {
		this.gastrocnemiusPain = gastrocnemiusPain;
	}

	public String getLassitude() {
		return this.lassitude;
	}

	public void setLassitude(String lassitude) {
		this.lassitude = lassitude;
	}

	public String getGastrocnemiusTenderness() {
		return this.gastrocnemiusTenderness;
	}

	public void setGastrocnemiusTenderness(String gastrocnemiusTenderness) {
		this.gastrocnemiusTenderness = gastrocnemiusTenderness;
	}

	public String getSuperficialLymphNodes() {
		return this.superficialLymphNodes;
	}

	public void setSuperficialLymphNodes(String superficialLymphNodes) {
		this.superficialLymphNodes = superficialLymphNodes;
	}

	public String getVomit() {
		return this.vomit;
	}

	public void setVomit(String vomit) {
		this.vomit = vomit;
	}

	public String getStomachache() {
		return this.stomachache;
	}

	public void setStomachache(String stomachache) {
		this.stomachache = stomachache;
	}

	public String getDiarrhea() {
		return this.diarrhea;
	}

	public void setDiarrhea(String diarrhea) {
		this.diarrhea = diarrhea;
	}

	public String getCough() {
		return this.cough;
	}

	public void setCough(String cough) {
		this.cough = cough;
	}

	public String getHemoptysis() {
		return this.hemoptysis;
	}

	public void setHemoptysis(String hemoptysis) {
		this.hemoptysis = hemoptysis;
	}

	public String getSkinScleraYellow() {
		return this.skinScleraYellow;
	}

	public void setSkinScleraYellow(String skinScleraYellow) {
		this.skinScleraYellow = skinScleraYellow;
	}

	public String getEpistaxis() {
		return this.epistaxis;
	}

	public void setEpistaxis(String epistaxis) {
		this.epistaxis = epistaxis;
	}

	public String getBleedingSpotsSkin() {
		return this.bleedingSpotsSkin;
	}

	public void setBleedingSpotsSkin(String bleedingSpotsSkin) {
		this.bleedingSpotsSkin = bleedingSpotsSkin;
	}

	public String getHepatomegaly() {
		return this.hepatomegaly;
	}

	public void setHepatomegaly(String hepatomegaly) {
		this.hepatomegaly = hepatomegaly;
	}

	public String getSplenomegaly() {
		return this.splenomegaly;
	}

	public void setSplenomegaly(String splenomegaly) {
		this.splenomegaly = splenomegaly;
	}

	public String getOliguria() {
		return this.oliguria;
	}

	public void setOliguria(String oliguria) {
		this.oliguria = oliguria;
	}

	public String getHematuresis() {
		return this.hematuresis;
	}

	public void setHematuresis(String hematuresis) {
		this.hematuresis = hematuresis;
	}

	public String getRenalPain() {
		return this.renalPain;
	}

	public void setRenalPain(String renalPain) {
		this.renalPain = renalPain;
	}

	public String getHeadache() {
		return this.headache;
	}

	public void setHeadache(String headache) {
		this.headache = headache;
	}

	public String getNeckRigidity() {
		return this.neckRigidity;
	}

	public void setNeckRigidity(String neckRigidity) {
		this.neckRigidity = neckRigidity;
	}

	public String getConvulsion() {
		return this.convulsion;
	}

	public void setConvulsion(String convulsion) {
		this.convulsion = convulsion;
	}

	public String getParalysis() {
		return this.paralysis;
	}

	public void setParalysis(String paralysis) {
		this.paralysis = paralysis;
	}

	public String getgBrinellPositive() {
		return this.gBrinellPositive;
	}

	public void setgBrinellPositive(String gBrinellPositive) {
		this.gBrinellPositive = gBrinellPositive;
	}

	public String getDisturbanceConsciousness() {
		return this.disturbanceConsciousness;
	}

	public void setDisturbanceConsciousness(String disturbanceConsciousness) {
		this.disturbanceConsciousness = disturbanceConsciousness;
	}

	public String getIsSymptoms() {
		return this.isSymptoms;
	}

	public void setIsSymptoms(String isSymptoms) {
		this.isSymptoms = isSymptoms;
	}

	public String getFeeble() {
		return this.feeble;
	}

	public void setFeeble(String feeble) {
		this.feeble = feeble;
	}

	public String getBackPain() {
		return this.backPain;
	}

	public void setBackPain(String backPain) {
		this.backPain = backPain;
	}

	public String getLimbAche() {
		return this.limbAche;
	}

	public void setLimbAche(String limbAche) {
		this.limbAche = limbAche;
	}

	public String getSneeze() {
		return this.sneeze;
	}

	public void setSneeze(String sneeze) {
		this.sneeze = sneeze;
	}

	public String getNausea() {
		return this.nausea;
	}

	public void setNausea(String nausea) {
		this.nausea = nausea;
	}

	public String getDiarrheaDailyTimes() {
		return this.diarrheaDailyTimes;
	}

	public void setDiarrheaDailyTimes(String diarrheaDailyTimes) {
		this.diarrheaDailyTimes = diarrheaDailyTimes;
	}

	public String getPneumonia() {
		return this.pneumonia;
	}

	public void setPneumonia(String pneumonia) {
		this.pneumonia = pneumonia;
	}

	public String getAsthma() {
		return this.asthma;
	}

	public void setAsthma(String asthma) {
		this.asthma = asthma;
	}

	public String getThromVioletInsane() {
		return this.thromVioletInsane;
	}

	public void setThromVioletInsane(String thromVioletInsane) {
		this.thromVioletInsane = thromVioletInsane;
	}

	public String getReyeSyndrome() {
		return this.reyeSyndrome;
	}

	public void setReyeSyndrome(String reyeSyndrome) {
		this.reyeSyndrome = reyeSyndrome;
	}

	public String getAbortion() {
		return this.abortion;
	}

	public void setAbortion(String abortion) {
		this.abortion = abortion;
	}

	public Integer getStillbirth() {
		return this.stillbirth;
	}

	public void setStillbirth(Integer stillbirth) {
		this.stillbirth = stillbirth;
	}

	public String getOnset() {
		return this.onset;
	}

	public void setOnset(String onset) {
		this.onset = onset;
	}

	public Date getDateAccident() {
		return this.dateAccident;
	}

	public void setDateAccident(Date dateAccident) {
		this.dateAccident = dateAccident;
	}

	public String getOrgDiagnosticsWrite() {
		return this.orgDiagnosticsWrite;
	}

	public void setOrgDiagnosticsWrite(String orgDiagnosticsWrite) {
		this.orgDiagnosticsWrite = orgDiagnosticsWrite;
	}

	public Date getHotDate() {
		return this.hotDate;
	}

	public void setHotDate(Date hotDate) {
		this.hotDate = hotDate;
	}

	public String getSensationChill() {
		return this.sensationChill;
	}

	public void setSensationChill(String sensationChill) {
		this.sensationChill = sensationChill;
	}

	public String getPoorAppetite() {
		return this.poorAppetite;
	}

	public void setPoorAppetite(String poorAppetite) {
		this.poorAppetite = poorAppetite;
	}

	public Date getParotidSwelDate() {
		return this.parotidSwelDate;
	}

	public void setParotidSwelDate(Date parotidSwelDate) {
		this.parotidSwelDate = parotidSwelDate;
	}

	public String getSwellingMethod() {
		return this.swellingMethod;
	}

	public void setSwellingMethod(String swellingMethod) {
		this.swellingMethod = swellingMethod;
	}

	public String getMassTenderness() {
		return this.massTenderness;
	}

	public void setMassTenderness(String massTenderness) {
		this.massTenderness = massTenderness;
	}

	public String getMassRed() {
		return this.massRed;
	}

	public void setMassRed(String massRed) {
		this.massRed = massRed;
	}

	public String getMassFluctDry() {
		return this.massFluctDry;
	}

	public void setMassFluctDry(String massFluctDry) {
		this.massFluctDry = massFluctDry;
	}

	public String getIsMassReceding() {
		return this.isMassReceding;
	}

	public void setIsMassReceding(String isMassReceding) {
		this.isMassReceding = isMassReceding;
	}

	public Date getMassAsideDate() {
		return this.massAsideDate;
	}

	public void setMassAsideDate(Date massAsideDate) {
		this.massAsideDate = massAsideDate;
	}

	public String getIsComplications() {
		return this.isComplications;
	}

	public void setIsComplications(String isComplications) {
		this.isComplications = isComplications;
	}

	public String getComplications() {
		return this.complications;
	}

	public void setComplications(String complications) {
		this.complications = complications;
	}

	public String getCoryza() {
		return this.coryza;
	}

	public void setCoryza(String coryza) {
		this.coryza = coryza;
	}

	public String getConjunctivitis() {
		return this.conjunctivitis;
	}

	public void setConjunctivitis(String conjunctivitis) {
		this.conjunctivitis = conjunctivitis;
	}

	public Date getRashDate() {
		return this.rashDate;
	}

	public void setRashDate(Date rashDate) {
		this.rashDate = rashDate;
	}

	public String getRashOrder() {
		return this.rashOrder;
	}

	public void setRashOrder(String rashOrder) {
		this.rashOrder = rashOrder;
	}

	public String getMeaslesShape() {
		return this.measlesShape;
	}

	public void setMeaslesShape(String measlesShape) {
		this.measlesShape = measlesShape;
	}

	public String getEnanthema() {
		return this.enanthema;
	}

	public void setEnanthema(String enanthema) {
		this.enanthema = enanthema;
	}

	public String getRashBackDate() {
		return this.rashBackDate;
	}

	public void setRashBackDate(String rashBackDate) {
		this.rashBackDate = rashBackDate;
	}

	public String getIsRashPigmentation() {
		return this.isRashPigmentation;
	}

	public void setIsRashPigmentation(String isRashPigmentation) {
		this.isRashPigmentation = isRashPigmentation;
	}

	public String getChaffBranSampleDebond() {
		return this.chaffBranSampleDebond;
	}

	public void setChaffBranSampleDebond(String chaffBranSampleDebond) {
		this.chaffBranSampleDebond = chaffBranSampleDebond;
	}

	public String getArthralgia() {
		return this.arthralgia;
	}

	public void setArthralgia(String arthralgia) {
		this.arthralgia = arthralgia;
	}

	public String getItchyEyes() {
		return this.itchyEyes;
	}

	public void setItchyEyes(String itchyEyes) {
		this.itchyEyes = itchyEyes;
	}

	public String getHeavyEyelid() {
		return this.heavyEyelid;
	}

	public void setHeavyEyelid(String heavyEyelid) {
		this.heavyEyelid = heavyEyelid;
	}

	public String getPhotophobiaTears() {
		return this.photophobiaTears;
	}

	public void setPhotophobiaTears(String photophobiaTears) {
		this.photophobiaTears = photophobiaTears;
	}

	public String getScorchingHot() {
		return this.scorchingHot;
	}

	public void setScorchingHot(String scorchingHot) {
		this.scorchingHot = scorchingHot;
	}

	public String getUnclearVision() {
		return this.unclearVision;
	}

	public void setUnclearVision(String unclearVision) {
		this.unclearVision = unclearVision;
	}

	public String getSwell() {
		return this.swell;
	}

	public void setSwell(String swell) {
		this.swell = swell;
	}

	public String getMucosaSecretion() {
		return this.mucosaSecretion;
	}

	public void setMucosaSecretion(String mucosaSecretion) {
		this.mucosaSecretion = mucosaSecretion;
	}

	public String getPurulentSecretion() {
		return this.purulentSecretion;
	}

	public void setPurulentSecretion(String purulentSecretion) {
		this.purulentSecretion = purulentSecretion;
	}

	public String getConjunctivalCongestion() {
		return this.conjunctivalCongestion;
	}

	public void setConjunctivalCongestion(String conjunctivalCongestion) {
		this.conjunctivalCongestion = conjunctivalCongestion;
	}

	public String getCourseDays() {
		return this.courseDays;
	}

	public void setCourseDays(String courseDays) {
		this.courseDays = courseDays;
	}

	public String getHotType() {
		return this.hotType;
	}

	public void setHotType(String hotType) {
		this.hotType = hotType;
	}

	public String getMuscularStiffness() {
		return this.muscularStiffness;
	}

	public void setMuscularStiffness(String muscularStiffness) {
		this.muscularStiffness = muscularStiffness;
	}

	public String getPharyngealCongestion() {
		return this.pharyngealCongestion;
	}

	public void setPharyngealCongestion(String pharyngealCongestion) {
		this.pharyngealCongestion = pharyngealCongestion;
	}

	public String getAnuresis() {
		return this.anuresis;
	}

	public void setAnuresis(String anuresis) {
		this.anuresis = anuresis;
	}

	public String getSplenomegalia() {
		return this.splenomegalia;
	}

	public void setSplenomegalia(String splenomegalia) {
		this.splenomegalia = splenomegalia;
	}

	public String getChill() {
		return this.chill;
	}

	public void setChill(String chill) {
		this.chill = chill;
	}

	public String getSweat() {
		return this.sweat;
	}

	public void setSweat(String sweat) {
		this.sweat = sweat;
	}

	public String getSpleenSwollenDate() {
		return this.spleenSwollenDate;
	}

	public void setSpleenSwollenDate(String spleenSwollenDate) {
		this.spleenSwollenDate = spleenSwollenDate;
	}

	public String getLoseWeight() {
		return this.loseWeight;
	}

	public void setLoseWeight(String loseWeight) {
		this.loseWeight = loseWeight;
	}

	public String getWeightRecession() {
		return this.weightRecession;
	}

	public void setWeightRecession(String weightRecession) {
		this.weightRecession = weightRecession;
	}

	public String getNyctalopia() {
		return this.nyctalopia;
	}

	public void setNyctalopia(String nyctalopia) {
		this.nyctalopia = nyctalopia;
	}

	public String getNosebleed() {
		return this.nosebleed;
	}

	public void setNosebleed(String nosebleed) {
		this.nosebleed = nosebleed;
	}

	public String getGingivalBleeding() {
		return this.gingivalBleeding;
	}

	public void setGingivalBleeding(String gingivalBleeding) {
		this.gingivalBleeding = gingivalBleeding;
	}

	public String getWheeze() {
		return this.wheeze;
	}

	public void setWheeze(String wheeze) {
		this.wheeze = wheeze;
	}

	public String getHemosputum() {
		return this.hemosputum;
	}

	public void setHemosputum(String hemosputum) {
		this.hemosputum = hemosputum;
	}

	public String getHoarseness() {
		return this.hoarseness;
	}

	public void setHoarseness(String hoarseness) {
		this.hoarseness = hoarseness;
	}

	public String getPalpitation() {
		return this.palpitation;
	}

	public void setPalpitation(String palpitation) {
		this.palpitation = palpitation;
	}

	public String getDysentery() {
		return this.dysentery;
	}

	public void setDysentery(String dysentery) {
		this.dysentery = dysentery;
	}

	public String getEmaciation() {
		return this.emaciation;
	}

	public void setEmaciation(String emaciation) {
		this.emaciation = emaciation;
	}

	public String getAnemia() {
		return this.anemia;
	}

	public void setAnemia(String anemia) {
		this.anemia = anemia;
	}

	public String getBradygenesis() {
		return this.bradygenesis;
	}

	public void setBradygenesis(String bradygenesis) {
		this.bradygenesis = bradygenesis;
	}

	public String getEcchymosis() {
		return this.ecchymosis;
	}

	public void setEcchymosis(String ecchymosis) {
		this.ecchymosis = ecchymosis;
	}

	public String getSkinDisease() {
		return this.skinDisease;
	}

	public void setSkinDisease(String skinDisease) {
		this.skinDisease = skinDisease;
	}

	public String getJaundice() {
		return this.jaundice;
	}

	public void setJaundice(String jaundice) {
		this.jaundice = jaundice;
	}

	public String getEdema() {
		return this.edema;
	}

	public void setEdema(String edema) {
		this.edema = edema;
	}

	public String getTonsilSwollen() {
		return this.tonsilSwollen;
	}

	public void setTonsilSwollen(String tonsilSwollen) {
		this.tonsilSwollen = tonsilSwollen;
	}

	public String getTongueCoating() {
		return this.tongueCoating;
	}

	public void setTongueCoating(String tongueCoating) {
		this.tongueCoating = tongueCoating;
	}

	public String getOralUlcer() {
		return this.oralUlcer;
	}

	public void setOralUlcer(String oralUlcer) {
		this.oralUlcer = oralUlcer;
	}

	public String getNoma() {
		return this.noma;
	}

	public void setNoma(String noma) {
		this.noma = noma;
	}

	public String getHeartRate() {
		return this.heartRate;
	}

	public void setHeartRate(String heartRate) {
		this.heartRate = heartRate;
	}

	public String getHeartRhythm() {
		return this.heartRhythm;
	}

	public void setHeartRhythm(String heartRhythm) {
		this.heartRhythm = heartRhythm;
	}

	public String getCardiacMurmur() {
		return this.cardiacMurmur;
	}

	public void setCardiacMurmur(String cardiacMurmur) {
		this.cardiacMurmur = cardiacMurmur;
	}

	public String getLungs() {
		return this.lungs;
	}

	public void setLungs(String lungs) {
		this.lungs = lungs;
	}

	public String getAbdominalCircumference() {
		return this.abdominalCircumference;
	}

	public void setAbdominalCircumference(String abdominalCircumference) {
		this.abdominalCircumference = abdominalCircumference;
	}

	public String getAscites() {
		return this.ascites;
	}

	public void setAscites(String ascites) {
		this.ascites = ascites;
	}

	public String getSpleenRibUnder() {
		return this.spleenRibUnder;
	}

	public void setSpleenRibUnder(String spleenRibUnder) {
		this.spleenRibUnder = spleenRibUnder;
	}

	public String getLiverRibUnder() {
		return this.liverRibUnder;
	}

	public void setLiverRibUnder(String liverRibUnder) {
		this.liverRibUnder = liverRibUnder;
	}

	public String getLiverSore() {
		return this.liverSore;
	}

	public void setLiverSore(String liverSore) {
		this.liverSore = liverSore;
	}

	public String getEpilepticSeizure() {
		return this.epilepticSeizure;
	}

	public void setEpilepticSeizure(String epilepticSeizure) {
		this.epilepticSeizure = epilepticSeizure;
	}

	public String getDiarrhoeaDays() {
		return this.diarrhoeaDays;
	}

	public void setDiarrhoeaDays(String diarrhoeaDays) {
		this.diarrhoeaDays = diarrhoeaDays;
	}

	public String getDiarrheaVariable() {
		return this.diarrheaVariable;
	}

	public void setDiarrheaVariable(String diarrheaVariable) {
		this.diarrheaVariable = diarrheaVariable;
	}

	public String getDiarrheaSmell() {
		return this.diarrheaSmell;
	}

	public void setDiarrheaSmell(String diarrheaSmell) {
		this.diarrheaSmell = diarrheaSmell;
	}

	public String getConditionDefecation() {
		return this.conditionDefecation;
	}

	public void setConditionDefecation(String conditionDefecation) {
		this.conditionDefecation = conditionDefecation;
	}

	public String getAbdominalPain() {
		return this.abdominalPain;
	}

	public void setAbdominalPain(String abdominalPain) {
		this.abdominalPain = abdominalPain;
	}

	public String getBarborygmus() {
		return this.barborygmus;
	}

	public void setBarborygmus(String barborygmus) {
		this.barborygmus = barborygmus;
	}

	public String getAbdominalDistension() {
		return this.abdominalDistension;
	}

	public void setAbdominalDistension(String abdominalDistension) {
		this.abdominalDistension = abdominalDistension;
	}

	public String getWaterLossSituation() {
		return this.waterLossSituation;
	}

	public void setWaterLossSituation(String waterLossSituation) {
		this.waterLossSituation = waterLossSituation;
	}

	public String getHeadacheDizziness() {
		return this.headacheDizziness;
	}

	public void setHeadacheDizziness(String headacheDizziness) {
		this.headacheDizziness = headacheDizziness;
	}

	public String getClinicalTypeLevel() {
		return this.clinicalTypeLevel;
	}

	public void setClinicalTypeLevel(String clinicalTypeLevel) {
		this.clinicalTypeLevel = clinicalTypeLevel;
	}

	public String getVomitDays() {
		return this.vomitDays;
	}

	public void setVomitDays(String vomitDays) {
		this.vomitDays = vomitDays;
	}

	public String getVomitTimes() {
		return this.vomitTimes;
	}

	public void setVomitTimes(String vomitTimes) {
		this.vomitTimes = vomitTimes;
	}

	public String getVomitWay() {
		return this.vomitWay;
	}

	public void setVomitWay(String vomitWay) {
		this.vomitWay = vomitWay;
	}

	public String getVomitingQuantity() {
		return this.vomitingQuantity;
	}

	public void setVomitingQuantity(String vomitingQuantity) {
		this.vomitingQuantity = vomitingQuantity;
	}

	public String getOralMucousUlcerHerpes() {
		return this.oralMucousUlcerHerpes;
	}

	public void setOralMucousUlcerHerpes(String oralMucousUlcerHerpes) {
		this.oralMucousUlcerHerpes = oralMucousUlcerHerpes;
	}

	public String getRespiratory() {
		return this.respiratory;
	}

	public void setRespiratory(String respiratory) {
		this.respiratory = respiratory;
	}

	public String getOtherRespiratory() {
		return this.otherRespiratory;
	}

	public void setOtherRespiratory(String otherRespiratory) {
		this.otherRespiratory = otherRespiratory;
	}

	public String getDigestiveSystem() {
		return this.digestiveSystem;
	}

	public void setDigestiveSystem(String digestiveSystem) {
		this.digestiveSystem = digestiveSystem;
	}

	public String getOtherDigestiveSystem() {
		return this.otherDigestiveSystem;
	}

	public void setOtherDigestiveSystem(String otherDigestiveSystem) {
		this.otherDigestiveSystem = otherDigestiveSystem;
	}

	public String getNervousSystem() {
		return this.nervousSystem;
	}

	public void setNervousSystem(String nervousSystem) {
		this.nervousSystem = nervousSystem;
	}

	public String getArrhythmia() {
		return this.arrhythmia;
	}

	public void setArrhythmia(String arrhythmia) {
		this.arrhythmia = arrhythmia;
	}

	public String getTendonReflex() {
		return this.tendonReflex;
	}

	public void setTendonReflex(String tendonReflex) {
		this.tendonReflex = tendonReflex;
	}

	public String getMuscleTension() {
		return this.muscleTension;
	}

	public void setMuscleTension(String muscleTension) {
		this.muscleTension = muscleTension;
	}

	public String getCompl() {
		return this.compl;
	}

	public void setCompl(String compl) {
		this.compl = compl;
	}

	public String getComplDescription() {
		return this.complDescription;
	}

	public void setComplDescription(String complDescription) {
		this.complDescription = complDescription;
	}

	public String getIsRedMeatusCervical() {
		return this.isRedMeatusCervical;
	}

	public void setIsRedMeatusCervical(String isRedMeatusCervical) {
		this.isRedMeatusCervical = isRedMeatusCervical;
	}

	public String getIsOdynuria() {
		return this.isOdynuria;
	}

	public void setIsOdynuria(String isOdynuria) {
		this.isOdynuria = isOdynuria;
	}

	public String getIsFrequentMicturition() {
		return this.isFrequentMicturition;
	}

	public void setIsFrequentMicturition(String isFrequentMicturition) {
		this.isFrequentMicturition = isFrequentMicturition;
	}

	public String getIsUrgencyUrination() {
		return this.isUrgencyUrination;
	}

	public void setIsUrgencyUrination(String isUrgencyUrination) {
		this.isUrgencyUrination = isUrgencyUrination;
	}

	public String getIsSecretionUrethralVaginal() {
		return this.isSecretionUrethralVaginal;
	}

	public void setIsSecretionUrethralVaginal(String isSecretionUrethralVaginal) {
		this.isSecretionUrethralVaginal = isSecretionUrethralVaginal;
	}

	public String getHidrosis() {
		return this.hidrosis;
	}

	public void setHidrosis(String hidrosis) {
		this.hidrosis = hidrosis;
	}

	public String getTesticularSwelling() {
		return this.testicularSwelling;
	}

	public void setTesticularSwelling(String testicularSwelling) {
		this.testicularSwelling = testicularSwelling;
	}

	public String getSoreThroat() {
		return this.soreThroat;
	}

	public void setSoreThroat(String soreThroat) {
		this.soreThroat = soreThroat;
	}

	public String getCircumoralPallor() {
		return this.circumoralPallor;
	}

	public void setCircumoralPallor(String circumoralPallor) {
		this.circumoralPallor = circumoralPallor;
	}

	public String getRaspberryTongue() {
		return this.raspberryTongue;
	}

	public void setRaspberryTongue(String raspberryTongue) {
		this.raspberryTongue = raspberryTongue;
	}

	public String getSwallowSpondylolysisRed() {
		return this.swallowSpondylolysisRed;
	}

	public void setSwallowSpondylolysisRed(String swallowSpondylolysisRed) {
		this.swallowSpondylolysisRed = swallowSpondylolysisRed;
	}

	public String getRashDays() {
		return this.rashDays;
	}

	public void setRashDays(String rashDays) {
		this.rashDays = rashDays;
	}

	public String getRashShapeDistribution() {
		return this.rashShapeDistribution;
	}

	public void setRashShapeDistribution(String rashShapeDistribution) {
		this.rashShapeDistribution = rashShapeDistribution;
	}

	public String getPeel() {
		return this.peel;
	}

	public void setPeel(String peel) {
		this.peel = peel;
	}

	public String getCharacter() {
		return this.character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getChief() {
		return this.chief;
	}

	public void setChief(String chief) {
		this.chief = chief;
	}

	public String getHistoryPresentIllness() {
		return this.historyPresentIllness;
	}

	public void setHistoryPresentIllness(String historyPresentIllness) {
		this.historyPresentIllness = historyPresentIllness;
	}

	public String getMaleBodyCharac() {
		return this.maleBodyCharac;
	}

	public void setMaleBodyCharac(String maleBodyCharac) {
		this.maleBodyCharac = maleBodyCharac;
	}

	public String getSeizure() {
		return this.seizure;
	}

	public void setSeizure(String seizure) {
		this.seizure = seizure;
	}

	public String getOpisthotonos() {
		return this.opisthotonos;
	}

	public void setOpisthotonos(String opisthotonos) {
		this.opisthotonos = opisthotonos;
	}

	public String getIsolationPatients() {
		return this.isolationPatients;
	}

	public void setIsolationPatients(String isolationPatients) {
		this.isolationPatients = isolationPatients;
	}

	public String getIsolationPlace() {
		return this.isolationPlace;
	}

	public void setIsolationPlace(String isolationPlace) {
		this.isolationPlace = isolationPlace;
	}

	public String getIsolationPlaceOth() {
		return this.isolationPlaceOth;
	}

	public void setIsolationPlaceOth(String isolationPlaceOth) {
		this.isolationPlaceOth = isolationPlaceOth;
	}

	public String getAntibioticDrugs() {
		return this.antibioticDrugs;
	}

	public void setAntibioticDrugs(String antibioticDrugs) {
		this.antibioticDrugs = antibioticDrugs;
	}

	public String getAntibioticDrugsName() {
		return this.antibioticDrugsName;
	}

	public void setAntibioticDrugsName(String antibioticDrugsName) {
		this.antibioticDrugsName = antibioticDrugsName;
	}

	public String getUsingEffect() {
		return this.usingEffect;
	}

	public void setUsingEffect(String usingEffect) {
		this.usingEffect = usingEffect;
	}

	public String getDizziness() {
		return this.dizziness;
	}

	public void setDizziness(String dizziness) {
		this.dizziness = dizziness;
	}

	public String getConstipation() {
		return this.constipation;
	}

	public void setConstipation(String constipation) {
		this.constipation = constipation;
	}

	public String getHemafecia() {
		return this.hemafecia;
	}

	public void setHemafecia(String hemafecia) {
		this.hemafecia = hemafecia;
	}

	public String getApathia() {
		return this.apathia;
	}

	public void setApathia(String apathia) {
		this.apathia = apathia;
	}

	public String getDelirium() {
		return this.delirium;
	}

	public void setDelirium(String delirium) {
		this.delirium = delirium;
	}

	public String getComa() {
		return this.coma;
	}

	public void setComa(String coma) {
		this.coma = coma;
	}

	public String getRelativeBradycardia() {
		return this.relativeBradycardia;
	}

	public void setRelativeBradycardia(String relativeBradycardia) {
		this.relativeBradycardia = relativeBradycardia;
	}

	public String getRoseola() {
		return this.roseola;
	}

	public void setRoseola(String roseola) {
		this.roseola = roseola;
	}

	public String getEnterorrhagia() {
		return this.enterorrhagia;
	}

	public void setEnterorrhagia(String enterorrhagia) {
		this.enterorrhagia = enterorrhagia;
	}

	public String getEnterobrosis() {
		return this.enterobrosis;
	}

	public void setEnterobrosis(String enterobrosis) {
		this.enterobrosis = enterobrosis;
	}

	public String getTenesmus() {
		return this.tenesmus;
	}

	public void setTenesmus(String tenesmus) {
		this.tenesmus = tenesmus;
	}

	public String getClinClass() {
		return this.clinClass;
	}

	public void setClinClass(String clinClass) {
		this.clinClass = clinClass;
	}

	public String getAnthraxClinManifOne() {
		return this.anthraxClinManifOne;
	}

	public void setAnthraxClinManifOne(String anthraxClinManifOne) {
		this.anthraxClinManifOne = anthraxClinManifOne;
	}

	public String getAnthraxCarb() {
		return this.anthraxCarb;
	}

	public void setAnthraxCarb(String anthraxCarb) {
		this.anthraxCarb = anthraxCarb;
	}

	public String getAnthraxCarbNum() {
		return this.anthraxCarbNum;
	}

	public void setAnthraxCarbNum(String anthraxCarbNum) {
		this.anthraxCarbNum = anthraxCarbNum;
	}

	public String getAnthraxCarbParts() {
		return this.anthraxCarbParts;
	}

	public void setAnthraxCarbParts(String anthraxCarbParts) {
		this.anthraxCarbParts = anthraxCarbParts;
	}

	public String getAnthraxCarbBel() {
		return this.anthraxCarbBel;
	}

	public void setAnthraxCarbBel(String anthraxCarbBel) {
		this.anthraxCarbBel = anthraxCarbBel;
	}

	public String getMalEdema() {
		return this.malEdema;
	}

	public void setMalEdema(String malEdema) {
		this.malEdema = malEdema;
	}

	public String getMalEdemaParts() {
		return this.malEdemaParts;
	}

	public void setMalEdemaParts(String malEdemaParts) {
		this.malEdemaParts = malEdemaParts;
	}

	public String getAnthraxClinManifTwo() {
		return this.anthraxClinManifTwo;
	}

	public void setAnthraxClinManifTwo(String anthraxClinManifTwo) {
		this.anthraxClinManifTwo = anthraxClinManifTwo;
	}

	public String getAnthraxClinManifThr() {
		return this.anthraxClinManifThr;
	}

	public void setAnthraxClinManifThr(String anthraxClinManifThr) {
		this.anthraxClinManifThr = anthraxClinManifThr;
	}

	public String getBleedingVolume() {
		return this.bleedingVolume;
	}

	public void setBleedingVolume(String bleedingVolume) {
		this.bleedingVolume = bleedingVolume;
	}

	public String getDyspnea() {
		return this.dyspnea;
	}

	public void setDyspnea(String dyspnea) {
		this.dyspnea = dyspnea;
	}

	public String getSkinMucCy() {
		return this.skinMucCy;
	}

	public void setSkinMucCy(String skinMucCy) {
		this.skinMucCy = skinMucCy;
	}

	public String getSepticStock() {
		return this.septicStock;
	}

	public void setSepticStock(String septicStock) {
		this.septicStock = septicStock;
	}

	public Integer getClinicalType() {
		return this.clinicalType;
	}

	public void setClinicalType(Integer clinicalType) {
		this.clinicalType = clinicalType;
	}

	public Integer getFacialBlushing() {
		return this.facialBlushing;
	}

	public void setFacialBlushing(Integer facialBlushing) {
		this.facialBlushing = facialBlushing;
	}

	public String getOrbitPain() {
		return this.orbitPain;
	}

	public void setOrbitPain(String orbitPain) {
		this.orbitPain = orbitPain;
	}

	public String getMyalgia() {
		return this.myalgia;
	}

	public void setMyalgia(String myalgia) {
		this.myalgia = myalgia;
	}

	public String getBrightBreasted() {
		return this.brightBreasted;
	}

	public void setBrightBreasted(String brightBreasted) {
		this.brightBreasted = brightBreasted;
	}

	public String getConjunctivalHemorrhage() {
		return this.conjunctivalHemorrhage;
	}

	public void setConjunctivalHemorrhage(String conjunctivalHemorrhage) {
		this.conjunctivalHemorrhage = conjunctivalHemorrhage;
	}

	public String getHaematemesis() {
		return this.haematemesis;
	}

	public void setHaematemesis(String haematemesis) {
		this.haematemesis = haematemesis;
	}

	public String getEyelidsSwelling() {
		return this.eyelidsSwelling;
	}

	public void setEyelidsSwelling(String eyelidsSwelling) {
		this.eyelidsSwelling = eyelidsSwelling;
	}

	public String getSkinBleType() {
		return this.skinBleType;
	}

	public void setSkinBleType(String skinBleType) {
		this.skinBleType = skinBleType;
	}

	public String getSkinBleTypeOth() {
		return this.skinBleTypeOth;
	}

	public void setSkinBleTypeOth(String skinBleTypeOth) {
		this.skinBleTypeOth = skinBleTypeOth;
	}

	public String getRashType() {
		return this.rashType;
	}

	public void setRashType(String rashType) {
		this.rashType = rashType;
	}

	public String getRashTypeOther() {
		return this.rashTypeOther;
	}

	public void setRashTypeOther(String rashTypeOther) {
		this.rashTypeOther = rashTypeOther;
	}

	public String getRashParts() {
		return this.rashParts;
	}

	public void setRashParts(String rashParts) {
		this.rashParts = rashParts;
	}

	public String getIrritability() {
		return this.irritability;
	}

	public void setIrritability(String irritability) {
		this.irritability = irritability;
	}

	public String getFeverLimits() {
		return this.feverLimits;
	}

	public void setFeverLimits(String feverLimits) {
		this.feverLimits = feverLimits;
	}

	public String getSpiritsDrooping() {
		return this.spiritsDrooping;
	}

	public void setSpiritsDrooping(String spiritsDrooping) {
		this.spiritsDrooping = spiritsDrooping;
	}

	public Integer getFussiness() {
		return this.fussiness;
	}

	public void setFussiness(Integer fussiness) {
		this.fussiness = fussiness;
	}

	public String getSleepiness() {
		return this.sleepiness;
	}

	public void setSleepiness(String sleepiness) {
		this.sleepiness = sleepiness;
	}

	public String getRespiratoryFailure() {
		return this.respiratoryFailure;
	}

	public void setRespiratoryFailure(String respiratoryFailure) {
		this.respiratoryFailure = respiratoryFailure;
	}

	public Integer getCirculatoryFailure() {
		return this.circulatoryFailure;
	}

	public void setCirculatoryFailure(Integer circulatoryFailure) {
		this.circulatoryFailure = circulatoryFailure;
	}

	public String getBloodPressureChange() {
		return this.bloodPressureChange;
	}

	public void setBloodPressureChange(String bloodPressureChange) {
		this.bloodPressureChange = bloodPressureChange;
	}

	public Integer getBreathRhythmChange() {
		return this.breathRhythmChange;
	}

	public void setBreathRhythmChange(Integer breathRhythmChange) {
		this.breathRhythmChange = breathRhythmChange;
	}

	public String getPupilSizeChange() {
		return this.pupilSizeChange;
	}

	public void setPupilSizeChange(String pupilSizeChange) {
		this.pupilSizeChange = pupilSizeChange;
	}

	public String getMeningealIrritation() {
		return this.meningealIrritation;
	}

	public void setMeningealIrritation(String meningealIrritation) {
		this.meningealIrritation = meningealIrritation;
	}

	public String getChimney() {
		return this.chimney;
	}

	public void setChimney(String chimney) {
		this.chimney = chimney;
	}

	public String getAbdominalReflexes() {
		return this.abdominalReflexes;
	}

	public void setAbdominalReflexes(String abdominalReflexes) {
		this.abdominalReflexes = abdominalReflexes;
	}

	public String getCremastericFrelex() {
		return this.cremastericFrelex;
	}

	public void setCremastericFrelex(String cremastericFrelex) {
		this.cremastericFrelex = cremastericFrelex;
	}

	public String getMuscleTensionEnhanced() {
		return this.muscleTensionEnhanced;
	}

	public void setMuscleTensionEnhanced(String muscleTensionEnhanced) {
		this.muscleTensionEnhanced = muscleTensionEnhanced;
	}

	public String getBabinskiSign() {
		return this.babinskiSign;
	}

	public void setBabinskiSign(String babinskiSign) {
		this.babinskiSign = babinskiSign;
	}

	public String getBronchopneumonia() {
		return this.bronchopneumonia;
	}

	public void setBronchopneumonia(String bronchopneumonia) {
		this.bronchopneumonia = bronchopneumonia;
	}

	public String getPulmonaryAtelectasis() {
		return this.pulmonaryAtelectasis;
	}

	public void setPulmonaryAtelectasis(String pulmonaryAtelectasis) {
		this.pulmonaryAtelectasis = pulmonaryAtelectasis;
	}

	public String getSepsis() {
		return this.sepsis;
	}

	public void setSepsis(String sepsis) {
		this.sepsis = sepsis;
	}

    public String getGastrointestinalBleeding() {
        return gastrointestinalBleeding;
    }

    public void setGastrointestinalBleeding(String gastrointestinalBleeding) {
        this.gastrointestinalBleeding = gastrointestinalBleeding;
    }

    public String getUrinaryTractInfection() {
		return this.urinaryTractInfection;
	}

	public void setUrinaryTractInfection(String urinaryTractInfection) {
		this.urinaryTractInfection = urinaryTractInfection;
	}

	public Date getFollowUpDate() {
		return this.followUpDate;
	}

	public void setFollowUpDate(Date followUpDate) {
		this.followUpDate = followUpDate;
	}

	public String getOutcome() {
		return this.outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public String getOutcomeOtherSelect() {
		return this.outcomeOtherSelect;
	}

	public void setOutcomeOtherSelect(String outcomeOtherSelect) {
		this.outcomeOtherSelect = outcomeOtherSelect;
	}

	public String getOutcomDisturbanceConsciousness() {
		return this.outcomDisturbanceConsciousness;
	}

	public void setOutcomDisturbanceConsciousness(String outcomDisturbanceConsciousness) {
		this.outcomDisturbanceConsciousness = outcomDisturbanceConsciousness;
	}

	public String getLanguageRetardation() {
		return this.languageRetardation;
	}

	public void setLanguageRetardation(String languageRetardation) {
		this.languageRetardation = languageRetardation;
	}

	public String getAphasia() {
		return this.aphasia;
	}

	public void setAphasia(String aphasia) {
		this.aphasia = aphasia;
	}

	public String getStupid() {
		return this.stupid;
	}

	public void setStupid(String stupid) {
		this.stupid = stupid;
	}

	public String getPalsy() {
		return this.palsy;
	}

	public void setPalsy(String palsy) {
		this.palsy = palsy;
	}

	public String getTorsionalSpasm() {
		return this.torsionalSpasm;
	}

	public void setTorsionalSpasm(String torsionalSpasm) {
		this.torsionalSpasm = torsionalSpasm;
	}

	public String getMemoryImpairmentUnderstand() {
		return this.memoryImpairmentUnderstand;
	}

	public void setMemoryImpairmentUnderstand(String memoryImpairmentUnderstand) {
		this.memoryImpairmentUnderstand = memoryImpairmentUnderstand;
	}

	public Integer getDeaf() {
		return this.deaf;
	}

	public void setDeaf(Integer deaf) {
		this.deaf = deaf;
	}

	public Integer getEpilepsy() {
		return this.epilepsy;
	}

	public void setEpilepsy(Integer epilepsy) {
		this.epilepsy = epilepsy;
	}

	public String getDysphagia() {
		return this.dysphagia;
	}

	public void setDysphagia(String dysphagia) {
		this.dysphagia = dysphagia;
	}

	public Integer getOpticAtrophy() {
		return this.opticAtrophy;
	}

	public void setOpticAtrophy(Integer opticAtrophy) {
		this.opticAtrophy = opticAtrophy;
	}

	public String getHydrostomia() {
		return this.hydrostomia;
	}

	public void setHydrostomia(String hydrostomia) {
		this.hydrostomia = hydrostomia;
	}

	public String getPsychopathy() {
		return this.psychopathy;
	}

	public void setPsychopathy(String psychopathy) {
		this.psychopathy = psychopathy;
	}

	public String getOutcomeOtherWrite() {
		return this.outcomeOtherWrite;
	}

	public void setOutcomeOtherWrite(String outcomeOtherWrite) {
		this.outcomeOtherWrite = outcomeOtherWrite;
	}

	public String getDeathReason() {
		return this.deathReason;
	}

	public void setDeathReason(String deathReason) {
		this.deathReason = deathReason;
	}

	public String getDeathReasonOther() {
		return this.deathReasonOther;
	}

	public void setDeathReasonOther(String deathReasonOther) {
		this.deathReasonOther = deathReasonOther;
	}

	public String getFollowInvestWay() {
		return this.followInvestWay;
	}

	public void setFollowInvestWay(String followInvestWay) {
		this.followInvestWay = followInvestWay;
	}

	public String getFollowInvestWayOther() {
		return this.followInvestWayOther;
	}

	public void setFollowInvestWayOther(String followInvestWayOther) {
		this.followInvestWayOther = followInvestWayOther;
	}

	public String getFollowInvestPerson() {
		return this.followInvestPerson;
	}

	public void setFollowInvestPerson(String followInvestPerson) {
		this.followInvestPerson = followInvestPerson;
	}

	public Date getDeathTime() {
		return this.deathTime;
	}

	public void setDeathTime(Date deathTime) {
		this.deathTime = deathTime;
	}

	public String getOrgDiagnosticsSelect() {
		return this.orgDiagnosticsSelect;
	}

	public void setOrgDiagnosticsSelect(String orgDiagnosticsSelect) {
		this.orgDiagnosticsSelect = orgDiagnosticsSelect;
	}

	public String getDiseaseClinicalSymptoms() {
		return this.diseaseClinicalSymptoms;
	}

	public void setDiseaseClinicalSymptoms(String diseaseClinicalSymptoms) {
		this.diseaseClinicalSymptoms = diseaseClinicalSymptoms;
	}

	public String getOrbitalPain() {
		return this.orbitalPain;
	}

	public void setOrbitalPain(String orbitalPain) {
		this.orbitalPain = orbitalPain;
	}

	public String getBlush() {
		return this.blush;
	}

	public void setBlush(String blush) {
		this.blush = blush;
	}

	public String getNeckReds() {
		return this.neckReds;
	}

	public void setNeckReds(String neckReds) {
		this.neckReds = neckReds;
	}

	public String getIsPetechiaeAlarArmChest() {
		return this.isPetechiaeAlarArmChest;
	}

	public void setIsPetechiaeAlarArmChest(String isPetechiaeAlarArmChest) {
		this.isPetechiaeAlarArmChest = isPetechiaeAlarArmChest;
	}

	public String getAlarArmChestValue() {
		return this.alarArmChestValue;
	}

	public void setAlarArmChestValue(String alarArmChestValue) {
		this.alarArmChestValue = alarArmChestValue;
	}

	public String getAlarArmChestOther() {
		return this.alarArmChestOther;
	}

	public void setAlarArmChestOther(String alarArmChestOther) {
		this.alarArmChestOther = alarArmChestOther;
	}

	public String getIsPetechiaeOralNasal() {
		return this.isPetechiaeOralNasal;
	}

	public void setIsPetechiaeOralNasal(String isPetechiaeOralNasal) {
		this.isPetechiaeOralNasal = isPetechiaeOralNasal;
	}

	public String getHypotension() {
		return this.hypotension;
	}

	public void setHypotension(String hypotension) {
		this.hypotension = hypotension;
	}

	public String getKoplikSpots() {
		return this.koplikSpots;
	}

	public void setKoplikSpots(String koplikSpots) {
		this.koplikSpots = koplikSpots;
	}

	public String getOriginalSymptom() {
		return this.originalSymptom;
	}

	public void setOriginalSymptom(String originalSymptom) {
		this.originalSymptom = originalSymptom;
	}

	public String getFluLikePerformance() {
		return this.fluLikePerformance;
	}

	public void setFluLikePerformance(String fluLikePerformance) {
		this.fluLikePerformance = fluLikePerformance;
	}

	public String getThreeDaysInjectionHistory() {
		return this.threeDaysInjectionHistory;
	}

	public void setThreeDaysInjectionHistory(String threeDaysInjectionHistory) {
		this.threeDaysInjectionHistory = threeDaysInjectionHistory;
	}

	public Date getParalysisAppearDate() {
		return this.paralysisAppearDate;
	}

	public void setParalysisAppearDate(Date paralysisAppearDate) {
		this.paralysisAppearDate = paralysisAppearDate;
	}

	public String getLeftUpperExtremity() {
		return this.leftUpperExtremity;
	}

	public void setLeftUpperExtremity(String leftUpperExtremity) {
		this.leftUpperExtremity = leftUpperExtremity;
	}

	public String getRightUpperExtremity() {
		return this.rightUpperExtremity;
	}

	public void setRightUpperExtremity(String rightUpperExtremity) {
		this.rightUpperExtremity = rightUpperExtremity;
	}

	public String getLeftLowerExtremity() {
		return this.leftLowerExtremity;
	}

	public void setLeftLowerExtremity(String leftLowerExtremity) {
		this.leftLowerExtremity = leftLowerExtremity;
	}

	public String getRightLowerExtremity() {
		return this.rightLowerExtremity;
	}

	public void setRightLowerExtremity(String rightLowerExtremity) {
		this.rightLowerExtremity = rightLowerExtremity;
	}

	public String getBodyObstacle() {
		return this.bodyObstacle;
	}

	public void setBodyObstacle(String bodyObstacle) {
		this.bodyObstacle = bodyObstacle;
	}

	public String getGatism() {
		return this.gatism;
	}

	public void setGatism(String gatism) {
		this.gatism = gatism;
	}

	public Integer getBabinskiReflection() {
		return this.babinskiReflection;
	}

	public void setBabinskiReflection(Integer babinskiReflection) {
		this.babinskiReflection = babinskiReflection;
	}

	public String getAnkkclonus() {
		return this.ankkclonus;
	}

	public void setAnkkclonus(String ankkclonus) {
		this.ankkclonus = ankkclonus;
	}

	public String getDeepTendonReflex() {
		return this.deepTendonReflex;
	}

	public void setDeepTendonReflex(String deepTendonReflex) {
		this.deepTendonReflex = deepTendonReflex;
	}

	public String getFirstAttackFever() {
		return this.firstAttackFever;
	}

	public void setFirstAttackFever(String firstAttackFever) {
		this.firstAttackFever = firstAttackFever;
	}

	public String getClinicTimes() {
		return this.clinicTimes;
	}

	public void setClinicTimes(String clinicTimes) {
		this.clinicTimes = clinicTimes;
	}

	public Date getThisClinicDate() {
		return this.thisClinicDate;
	}

	public void setThisClinicDate(Date thisClinicDate) {
		this.thisClinicDate = thisClinicDate;
	}

	public String getThisClinicDiagnosis() {
		return this.thisClinicDiagnosis;
	}

	public void setThisClinicDiagnosis(String thisClinicDiagnosis) {
		this.thisClinicDiagnosis = thisClinicDiagnosis;
	}

	public String getMedicalOrgF() {
		return this.medicalOrgF;
	}

	public void setMedicalOrgF(String medicalOrgF) {
		this.medicalOrgF = medicalOrgF;
	}

	public Date getClinicDateF() {
		return this.clinicDateF;
	}

	public void setClinicDateF(Date clinicDateF) {
		this.clinicDateF = clinicDateF;
	}

	public String getDiagnosisF() {
		return this.diagnosisF;
	}

	public void setDiagnosisF(String diagnosisF) {
		this.diagnosisF = diagnosisF;
	}

	public String getIsReportF() {
		return this.isReportF;
	}

	public void setIsReportF(String isReportF) {
		this.isReportF = isReportF;
	}

	public Date getClinicDateL() {
		return this.clinicDateL;
	}

	public void setClinicDateL(Date clinicDateL) {
		this.clinicDateL = clinicDateL;
	}

	public Integer getDiagnosisL() {
		return this.diagnosisL;
	}

	public void setDiagnosisL(Integer diagnosisL) {
		this.diagnosisL = diagnosisL;
	}

	public String getIsReportL() {
		return this.isReportL;
	}

	public void setIsReportL(String isReportL) {
		this.isReportL = isReportL;
	}

	public Integer getHospitalType() {
		return this.hospitalType;
	}

	public void setHospitalType(Integer hospitalType) {
		this.hospitalType = hospitalType;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getMedicalRecordNum() {
		return medicalRecordNum;
	}

	public void setMedicalRecordNum(String medicalRecordNum) {
		this.medicalRecordNum = medicalRecordNum;
	}

    public String getDisgustOilBellyDistension() {
        return disgustOilBellyDistension;
    }

    public void setDisgustOilBellyDistension(String disgustOilBellyDistension) {
        this.disgustOilBellyDistension = disgustOilBellyDistension;
    }

    public String getSemiliquidStool() {
		return this.semiliquidStool;
	}

	public void setSemiliquidStool(String semiliquidStool) {
		this.semiliquidStool = semiliquidStool;
	}

	public String getTeaUrine() {
		return this.teaUrine;
	}

	public void setTeaUrine(String teaUrine) {
		this.teaUrine = teaUrine;
	}

	public String getSpiderBurst() {
		return this.spiderBurst;
	}

	public void setSpiderBurst(String spiderBurst) {
		this.spiderBurst = spiderBurst;
	}

	public String getLiverPalms() {
		return this.liverPalms;
	}

	public void setLiverPalms(String liverPalms) {
		this.liverPalms = liverPalms;
	}

	public String getFrothySputum() {
		return this.frothySputum;
	}

	public void setFrothySputum(String frothySputum) {
		this.frothySputum = frothySputum;
	}

	public String getColdHeat() {
		return this.coldHeat;
	}

	public void setColdHeat(String coldHeat) {
		this.coldHeat = coldHeat;
	}

	public String getMania() {
		return this.mania;
	}

	public void setMania(String mania) {
		this.mania = mania;
	}

	public String getObnubilation() {
		return this.obnubilation;
	}

	public void setObnubilation(String obnubilation) {
		this.obnubilation = obnubilation;
	}

	public String getBloodyStool() {
		return this.bloodyStool;
	}

	public void setBloodyStool(String bloodyStool) {
		this.bloodyStool = bloodyStool;
	}

	public String getBloodyVomit() {
		return this.bloodyVomit;
	}

	public void setBloodyVomit(String bloodyVomit) {
		this.bloodyVomit = bloodyVomit;
	}

	public String getBloodPressure() {
		return this.bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public String getLymphadenectasis() {
		return this.lymphadenectasis;
	}

	public void setLymphadenectasis(String lymphadenectasis) {
		this.lymphadenectasis = lymphadenectasis;
	}

	public String getChestPain() {
		return this.chestPain;
	}

	public void setChestPain(String chestPain) {
		this.chestPain = chestPain;
	}

	public String getSubcutaneousMucosaBleed() {
		return this.subcutaneousMucosaBleed;
	}

	public void setSubcutaneousMucosaBleed(String subcutaneousMucosaBleed) {
		this.subcutaneousMucosaBleed = subcutaneousMucosaBleed;
	}

	public String getOtherSelect() {
		return this.otherSelect;
	}

	public void setOtherSelect(String otherSelect) {
		this.otherSelect = otherSelect;
	}

	public String getExpectoration() {
		return this.expectoration;
	}

	public void setExpectoration(String expectoration) {
		this.expectoration = expectoration;
	}

	public String getCatarrh() {
		return this.catarrh;
	}

	public void setCatarrh(String catarrh) {
		this.catarrh = catarrh;
	}

	public String getChestStufly() {
		return this.chestStufly;
	}

	public void setChestStufly(String chestStufly) {
		this.chestStufly = chestStufly;
	}

	public String getDyspneaType() {
		return this.dyspneaType;
	}

	public void setDyspneaType(String dyspneaType) {
		this.dyspneaType = dyspneaType;
	}

	public String getNasalObstruction() {
		return this.nasalObstruction;
	}

	public void setNasalObstruction(String nasalObstruction) {
		this.nasalObstruction = nasalObstruction;
	}

	public String getRunningNose() {
		return this.runningNose;
	}

	public void setRunningNose(String runningNose) {
		this.runningNose = runningNose;
	}

	public Date getCureDt() {
		return this.cureDt;
	}

	public void setCureDt(Date cureDt) {
		this.cureDt = cureDt;
	}

	public String getChineseMedicine() {
		return this.chineseMedicine;
	}

	public void setChineseMedicine(String chineseMedicine) {
		this.chineseMedicine = chineseMedicine;
	}

	public String getWesternMedicine() {
		return this.westernMedicine;
	}

	public void setWesternMedicine(String westernMedicine) {
		this.westernMedicine = westernMedicine;
	}

	public Date getAntibioticsDt() {
		return this.antibioticsDt;
	}

	public void setAntibioticsDt(Date antibioticsDt) {
		this.antibioticsDt = antibioticsDt;
	}

	public String getAntibioticsDays() {
		return this.antibioticsDays;
	}

	public void setAntibioticsDays(String antibioticsDays) {
		this.antibioticsDays = antibioticsDays;
	}

	public String getCrow() {
		return crow;
	}

	public void setCrow(String crow) {
		this.crow = crow;
	}

	public String getLip() {
		return lip;
	}

	public void setLip(String lip) {
		this.lip = lip;
	}

	public String getJugularDistention() {
		return jugularDistention;
	}

	public void setJugularDistention(String jugularDistention) {
		this.jugularDistention = jugularDistention;
	}

	public String getSleepUneasy() {
		return sleepUneasy;
	}

	public void setSleepUneasy(String sleepUneasy) {
		this.sleepUneasy = sleepUneasy;
	}

	public String getChokeResentment() {
		return chokeResentment;
	}

	public void setChokeResentment(String chokeResentment) {
		this.chokeResentment = chokeResentment;
	}

	public String getAsphyxia() {
		return asphyxia;
	}

	public void setAsphyxia(String asphyxia) {
		this.asphyxia = asphyxia;
	}

    public String getNightSweat() {
        return this.nightSweat;
    }

    public void setNightSweat(String nightSweat) {
        this.nightSweat = nightSweat;
    }

    public Date getFirstDt() {
        return this.firstDt;
    }

    public void setFirstDt(Date firstDt) {
        this.firstDt = firstDt;
    }

    public String getPulse() {
        return this.pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

    public String getWeight() {
        return this.weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSymptomDuration() {
        return this.symptomDuration;
    }

    public void setSymptomDuration(String symptomDuration) {
        this.symptomDuration = symptomDuration;
    }

    public String getCercarialDermatitis() {
        return this.cercarialDermatitis;
    }

    public void setCercarialDermatitis(String cercarialDermatitis) {
        this.cercarialDermatitis = cercarialDermatitis;
    }

    public String getLiverXiphoidBelow() {
        return this.liverXiphoidBelow;
    }

    public void setLiverXiphoidBelow(String liverXiphoidBelow) {
        this.liverXiphoidBelow = liverXiphoidBelow;
    }

    public String getLiverRidBelow() {
        return this.liverRidBelow;
    }

    public void setLiverRidBelow(String liverRidBelow) {
        this.liverRidBelow = liverRidBelow;
    }

    public String getLiverGrain() {
        return this.liverGrain;
    }

    public void setLiverGrain(String liverGrain) {
        this.liverGrain = liverGrain;
    }

    public String getLiverNode() {
        return this.liverNode;
    }

    public void setLiverNode(String liverNode) {
        this.liverNode = liverNode;
    }

    public String getLiverTenderness() {
        return this.liverTenderness;
    }

    public void setLiverTenderness(String liverTenderness) {
        this.liverTenderness = liverTenderness;
    }

    public String getSpleenScopeUp() {
        return this.spleenScopeUp;
    }

    public void setSpleenScopeUp(String spleenScopeUp) {
        this.spleenScopeUp = spleenScopeUp;
    }

    public String getSpleenRidBelow() {
        return this.spleenRidBelow;
    }

    public void setSpleenRidBelow(String spleenRidBelow) {
        this.spleenRidBelow = spleenRidBelow;
    }

    public String getSpleenTenderness() {
        return this.spleenTenderness;
    }

    public void setSpleenTenderness(String spleenTenderness) {
        this.spleenTenderness = spleenTenderness;
    }

    public String getCardiacDullnes() {
        return this.cardiacDullnes;
    }

    public void setCardiacDullnes(String cardiacDullnes) {
        this.cardiacDullnes = cardiacDullnes;
    }

    public String getCardiacDullnesDetail() {
        return this.cardiacDullnesDetail;
    }

    public void setCardiacDullnesDetail(String cardiacDullnesDetail) {
        this.cardiacDullnesDetail = cardiacDullnesDetail;
    }

    public String getLungsDetaiL() {
        return this.lungsDetaiL;
    }

    public void setLungsDetaiL(String lungsDetaiL) {
        this.lungsDetaiL = lungsDetaiL;
    }

    public String getBellyOutline() {
        return this.bellyOutline;
    }

    public void setBellyOutline(String bellyOutline) {
        this.bellyOutline = bellyOutline;
    }

    public String getDullSound() {
        return this.dullSound;
    }

    public void setDullSound(String dullSound) {
        this.dullSound = dullSound;
    }

    public String getVenaEpigastrica() {
        return this.venaEpigastrica;
    }

    public void setVenaEpigastrica(String venaEpigastrica) {
        this.venaEpigastrica = venaEpigastrica;
    }

    public String getLaborForce() {
        return this.laborForce;
    }

    public void setLaborForce(String laborForce) {
        this.laborForce = laborForce;
    }

    public String getLaborStamina() {
        return this.laborStamina;
    }

    public void setLaborStamina(String laborStamina) {
        this.laborStamina = laborStamina;
    }

    public String getNutriture() {
        return this.nutriture;
    }

    public void setNutriture(String nutriture) {
        this.nutriture = nutriture;
    }

    public String getFormType() {
        return this.formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getFormTypeOther() {
        return this.formTypeOther;
    }

    public void setFormTypeOther(String formTypeOther) {
        this.formTypeOther = formTypeOther;
    }

    public String getBorderType() {
        return this.borderType;
    }

    public void setBorderType(String borderType) {
        this.borderType = borderType;
    }

    public String getFaceType() {
        return this.faceType;
    }

    public void setFaceType(String faceType) {
        this.faceType = faceType;
    }

    public String getColorType() {
        return this.colorType;
    }

    public void setColorType(String colorType) {
        this.colorType = colorType;
    }

    public String getNumType() {
        return this.numType;
    }

    public void setNumType(String numType) {
        this.numType = numType;
    }

    public String getDistributionType() {
        return this.distributionType;
    }

    public void setDistributionType(String distributionType) {
        this.distributionType = distributionType;
    }

    public String getEyebrowType() {
        return this.eyebrowType;
    }

    public void setEyebrowType(String eyebrowType) {
        this.eyebrowType = eyebrowType;
    }

    public String getEyebrowTypeOther() {
        return this.eyebrowTypeOther;
    }

    public void setEyebrowTypeOther(String eyebrowTypeOther) {
        this.eyebrowTypeOther = eyebrowTypeOther;
    }

    public String getnCheck() {
		return nCheck;
	}

	public void setnCheck(String nCheck) {
		this.nCheck = nCheck;
	}

	public String getSensibilityCheck() {
        return this.sensibilityCheck;
    }

    public void setSensibilityCheck(String sensibilityCheck) {
        this.sensibilityCheck = sensibilityCheck;
    }

    public String getFeeling() {
        return this.feeling;
    }

    public void setFeeling(String feeling) {
        this.feeling = feeling;
    }

    public String getTouch() {
        return this.touch;
    }

    public void setTouch(String touch) {
        this.touch = touch;
    }

    public String getAlgesia() {
        return this.algesia;
    }

    public void setAlgesia(String algesia) {
        this.algesia = algesia;
    }

    public String getDisability() {
        return this.disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public String getFacialParalysis() {
        return this.facialParalysis;
    }

    public void setFacialParalysis(String facialParalysis) {
        this.facialParalysis = facialParalysis;
    }

    public String getRabbitEye() {
        return this.rabbitEye;
    }

    public void setRabbitEye(String rabbitEye) {
        this.rabbitEye = rabbitEye;
    }

    public String getTheEye() {
        return this.theEye;
    }

    public void setTheEye(String theEye) {
        this.theEye = theEye;
    }

    public String getGoBlind() {
        return this.goBlind;
    }

    public void setGoBlind(String goBlind) {
        this.goBlind = goBlind;
    }

    public String getClawHand() {
        return this.clawHand;
    }

    public void setClawHand(String clawHand) {
        this.clawHand = clawHand;
    }

    public String getApeHand() {
        return this.apeHand;
    }

    public void setApeHand(String apeHand) {
        this.apeHand = apeHand;
    }

    public String getMuscleAtrophy() {
        return this.muscleAtrophy;
    }

    public void setMuscleAtrophy(String muscleAtrophy) {
        this.muscleAtrophy = muscleAtrophy;
    }

    public String getaShort() {
		return aShort;
	}

	public void setaShort(String aShort) {
		this.aShort = aShort;
	}

	public String getMetatarsalShort() {
        return this.metatarsalShort;
    }

    public void setMetatarsalShort(String metatarsalShort) {
        this.metatarsalShort = metatarsalShort;
    }

    public String getTalipesVarus() {
        return this.talipesVarus;
    }

    public void setTalipesVarus(String talipesVarus) {
        this.talipesVarus = talipesVarus;
    }

    public String getClawToe() {
        return this.clawToe;
    }

    public void setClawToe(String clawToe) {
        this.clawToe = clawToe;
    }

    public String getWristDrop() {
        return this.wristDrop;
    }

    public void setWristDrop(String wristDrop) {
        this.wristDrop = wristDrop;
    }

    public String getFootDrop() {
        return this.footDrop;
    }

    public void setFootDrop(String footDrop) {
        this.footDrop = footDrop;
    }

    public String getFeelingLose() {
        return this.feelingLose;
    }

    public void setFeelingLose(String feelingLose) {
        this.feelingLose = feelingLose;
    }

    public String getHand() {
        return this.hand;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }

    public String getFoot() {
        return this.foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    public String getEye() {
        return this.eye;
    }

    public void setEye(String eye) {
        this.eye = eye;
    }

    public String getIsUlcer() {
        return this.isUlcer;
    }

    public void setIsUlcer(String isUlcer) {
        this.isUlcer = isUlcer;
    }

    public String getUlcerHand() {
        return this.ulcerHand;
    }

    public void setUlcerHand(String ulcerHand) {
        this.ulcerHand = ulcerHand;
    }

    public String getUlcerLeg() {
        return this.ulcerLeg;
    }

    public void setUlcerLeg(String ulcerLeg) {
        this.ulcerLeg = ulcerLeg;
    }

    public String getUlcerAnkle() {
        return this.ulcerAnkle;
    }

    public void setUlcerAnkle(String ulcerAnkle) {
        this.ulcerAnkle = ulcerAnkle;
    }

    public String getUlcerFoot() {
        return this.ulcerFoot;
    }

    public void setUlcerFoot(String ulcerFoot) {
        this.ulcerFoot = ulcerFoot;
    }

    public String getUlcerToe() {
        return this.ulcerToe;
    }

    public void setUlcerToe(String ulcerToe) {
        this.ulcerToe = ulcerToe;
    }

    public String getUlcerOther() {
        return this.ulcerOther;
    }

    public void setUlcerOther(String ulcerOther) {
        this.ulcerOther = ulcerOther;
    }

    public String getLymphedema() {
        return this.lymphedema;
    }

    public void setLymphedema(String lymphedema) {
        this.lymphedema = lymphedema;
    }

    public String getUpperLimb() {
        return this.upperLimb;
    }

    public void setUpperLimb(String upperLimb) {
        this.upperLimb = upperLimb;
    }

    public String getLowerLimb() {
        return this.lowerLimb;
    }

    public void setLowerLimb(String lowerLimb) {
        this.lowerLimb = lowerLimb;
    }

    public String getLeftStage() {
        return this.leftStage;
    }

    public void setLeftStage(String leftStage) {
        this.leftStage = leftStage;
    }

    public String getRightStage() {
        return this.rightStage;
    }

    public void setRightStage(String rightStage) {
        this.rightStage = rightStage;
    }

    public String getLowerLimbLeft() {
        return this.lowerLimbLeft;
    }

    public void setLowerLimbLeft(String lowerLimbLeft) {
        this.lowerLimbLeft = lowerLimbLeft;
    }

    public String getLowerLimbRight() {
        return this.lowerLimbRight;
    }

    public void setLowerLimbRight(String lowerLimbRight) {
        this.lowerLimbRight = lowerLimbRight;
    }

    public String getPittingEdema() {
        return this.pittingEdema;
    }

    public void setPittingEdema(String pittingEdema) {
        this.pittingEdema = pittingEdema;
    }

    public String getSkin() {
        return this.skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getSkinThichen() {
        return skinThichen;
    }

    public void setSkinThichen(String skinThichen) {
        this.skinThichen = skinThichen;
    }

    public String getSkinFold() {
        return this.skinFold;
    }

    public void setSkinFold(String skinFold) {
        this.skinFold = skinFold;
    }

    public String getDeformity() {
        return this.deformity;
    }

    public void setDeformity(String deformity) {
        this.deformity = deformity;
    }

    public String getDysfunction() {
        return this.dysfunction;
    }

    public void setDysfunction(String dysfunction) {
        this.dysfunction = dysfunction;
    }

	public String getBloodPressureDiastolic() {
		return bloodPressureDiastolic;
	}

	public void setBloodPressureDiastolic(String bloodPressureDiastolic) {
		this.bloodPressureDiastolic = bloodPressureDiastolic;
	}

	/**
	 * @return the grading
	 */
	public String getGrading() {
		return grading;
	}

	/**
	 * @param grading the grading to set
	 */
	public void setGrading(String grading) {
		this.grading = grading;
	}

	public String getPsychosis() {
		return psychosis;
	}

	public void setPsychosis(String psychosis) {
		this.psychosis = psychosis;
	}

}