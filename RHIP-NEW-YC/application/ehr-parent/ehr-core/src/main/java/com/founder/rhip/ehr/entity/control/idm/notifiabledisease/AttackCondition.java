package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/**
 * 发病情况
 * @author Jiang Haiying
 *
 */
@Entity
@Table(name = "IDM_ATTACK_CONDITION")
public class AttackCondition implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编码|11|", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "PATHOGENESIS_DATE", columnDefinition = "DATE|发病日期||", nullable = true)
	private Date pathogenesisDate;

	@Column(name = "CLINIC_DATE", columnDefinition = "DATE|就诊日期||", nullable = true)
	private Date clinicDate;

	@Column(name = "PATHOGENESIS_PLACE", columnDefinition = "VARCHAR2|发病地点|100|", length = 100, nullable = true)
	private String pathogenesisPlace;

	@Column(name = "ADMISSION_HOSPITAL", columnDefinition = "VARCHAR2|住院医院|100|", length = 100, nullable = true)
	private String admissionHospital;

	@Column(name = "ADMISSION_NO", columnDefinition = "VARCHAR2|住院号|50|", length = 50, nullable = true)
	private String admissionNo;

	@Column(name = "INHOS_DATE", columnDefinition = "DATE|住院日期||", nullable = true)
	private Date inhosDate;

	@Column(name = "OUT_HOSPITAL_DATE", columnDefinition = "DATE|出院日期||", nullable = true)
	private Date outHospitalDate;

	@Column(name = "INHOS_DIAGNOSIS", columnDefinition = "VARCHAR2|入院诊断|20|", length = 20, nullable = true)
	private String inhosDiagnosis;

	@Column(name = "INHOS_DIAGNOSIS_OTHER", columnDefinition = "VARCHAR2|入院诊断_其他|100|", length = 100, nullable = true)
	private String inhosDiagnosisOther;

	@Column(name = "INHOS_DIAGNOSIS_DATE", columnDefinition = "DATE|入院诊断日期||", nullable = true)
	private Date inhosDiagnosisDate;

	@Column(name = "CLINICAL_CLASSIFICATION", columnDefinition = "VARCHAR2|临床分型|2|", length = 2, nullable = true)
	private String clinicalClassification;

	@Column(name = "OUT_DIAGNOSIS", columnDefinition = "VARCHAR2|出院诊断|2|", length = 2, nullable = true)
	private String outDiagnosis;

	@Column(name = "OUT_DIAGNOSIS_OTHER", columnDefinition = "VARCHAR2|出院诊断_其他|100|", length = 100, nullable = true)
	private String outDiagnosisOther;

	@Column(name = "ANTIBACTERIAL_DRUG_NAME", columnDefinition = "VARCHAR2|抗菌药物名称|100|", length = 100, nullable = true)
	private String antibacterialDrugName;

	@Column(name = "FIRST_USE_TIME", columnDefinition = "DATE|首次使用时间||", nullable = true)
	private Date firstUseTime;

	@Column(name = "FIRST_USE_UNIT", columnDefinition = "VARCHAR2|首次使用计量|20|", length = 20, nullable = true)
	private String firstUseUnit;

	@Column(name = "HERXHEIMER_REACTION", columnDefinition = "VARCHAR2|赫氏反应|2|", length = 2, nullable = true)
	private String herxheimerReaction;

	@Column(name = "HORMONOTHERAPY", columnDefinition = "VARCHAR2|是否用激素治疗|2|", length = 2, nullable = true)
	private String hormonotherapy;

	@Column(name = "FIRST_VISIT_DATE", columnDefinition = "DATE|初诊日期||", nullable = true)
	private Date firstVisitDate;

	@Column(name = "FIRST_VISIT_UNIT", columnDefinition = "VARCHAR2|初诊医疗单位|100|", length = 100, nullable = true)
	private String firstVisitUnit;

    @Column(name = "FIRST_VISIT_UNIT_OTHER", columnDefinition = "VARCHAR2|初诊单位--其他|100|", length = 100, nullable = true)
    private String firstVisitUnitOther;

	@Column(name = "CONFIRMATION_DATE", columnDefinition = "DATE|确诊日期|时间要到年月日时|", nullable = true)
	private Date confirmationDate;

	@Column(name = "CONFIRMATION_HOSPITAL", columnDefinition = "VARCHAR2|确诊诊断医院|100|", length = 100, nullable = true)
	private String confirmationHospital;

	@Column(name = "FIRST_VISIT_NAME", columnDefinition = "VARCHAR2|初诊名称|100|", length = 100, nullable = true)
	private String firstVisitName;

	@Column(name = "CONFIRMATION_NAME", columnDefinition = "VARCHAR2|确诊病名|100|", length = 100, nullable = true)
	private String confirmationName;

	@Column(name = "PROGNOSIS", columnDefinition = "VARCHAR2|预后|2|", length = 2, nullable = true)
	private String prognosis;

	@Column(name = "PROGNOSIS_OTHER", columnDefinition = "VARCHAR2|预后_其他|100|", length = 100, nullable = true)
	private String prognosisOther;

	@Column(name = "SEQUELAE", columnDefinition = "VARCHAR2|后遗症|2|", length = 2, nullable = true)
	private String sequelae;

	@Column(name = "SEQUELAE_NAME", columnDefinition = "VARCHAR2|后遗症_描述|100|", length = 100, nullable = true)
	private String sequelaeName;

	@Column(name = "INVASION_PAPROVINCE", columnDefinition = "VARCHAR2|发病地点-省|12|", length = 12, nullable = true)
	private String invasionPaprovince;

	@Column(name = "INVASION_PACITY", columnDefinition = "VARCHAR2|发病地点-市|12|", length = 12, nullable = true)
	private String invasionPacity;

	@Column(name = "INVASION_PACOUNTY", columnDefinition = "VARCHAR2|发病地点-县（区）|12|", length = 12, nullable = true)
	private String invasionPacounty;

	@Column(name = "MOTHER_AGE", columnDefinition = "VARCHAR2|母亲年龄|20|", length = 20, nullable = true)
	private String motherAge;

	@Column(name = "TETANUS_TOXOID_FLG", columnDefinition = "VARCHAR2|是否接种过破伤风类毒素|2|", length = 2, nullable = true)
	private String tetanusToxoidFlg;

	@Column(name = "VACCINATE_COUNT", columnDefinition = "VARCHAR2|接种次数|20|", length = 20, nullable = true)
	private String vaccinateCount;

	@Column(name = "LAST_VACCINATE_DATE", columnDefinition = "DATE|最后一次接种日期||", nullable = true)
	private Date lastVaccinateDate;

	@Column(name = "PRENATAL_DIAGNOSIS", columnDefinition = "VARCHAR2|是否产前检查|2|", length = 2, nullable = true)
	private String prenatalDiagnosis;

	@Column(name = "MIDWIFE", columnDefinition = "VARCHAR2|患儿由谁接生|2|", length = 2, nullable = true)
	private String midwife;

	@Column(name = "HOSPITAL_FLG", columnDefinition = "VARCHAR2|患儿是否到医疗机构就诊|2|", length = 2, nullable = true)
	private String hospitalFlg;

	@Column(name = "FIRST_CLINIC_ORGAN_DATE", columnDefinition = "DATE|初次就诊日期||", nullable = true)
	private Date firstClinicOrganDate;

	@Column(name = "ORGAN_LEVEL", columnDefinition = "VARCHAR2|就诊医疗机构级别|2|", length = 2, nullable = true)
	private String organLevel;

	@Column(name = "DIAGNOSIS", columnDefinition = "VARCHAR2|就诊时诊断|100|", length = 100, nullable = true)
	private String diagnosis;

	@Column(name = "DEATH_MOCEZUELO_FLAG", columnDefinition = "VARCHAR2|患儿是否死于新生儿破伤风|2|", length = 2, nullable = true)
	private String deathMocezueloFlag;

	@Column(name = "MOCEZUELO_FLAG", columnDefinition = "VARCHAR2|患儿是否新生儿破伤风|2|", length = 2, nullable = true)
	private String mocezueloFlag;

	@Column(name = "AROUND_INVASION", columnDefinition = "VARCHAR2|周围还有类似病例发生|2|", length = 2, nullable = true)
	private String aroundInvasion;

	@Column(name = "AROUND_INVASION_COUNT", columnDefinition = "VARCHAR2|周围发病数|20|", length = 5, nullable = true)
	private String aroundInvasionCount;

	@Column(name = "FIRST_CLINIC_ORGAN", columnDefinition = "VARCHAR2|第1次-就诊医院|100|", length = 100, nullable = true)
	private String firstClinicOrgan;

	@Column(name = "FIRST_CLINIC_DOCTOR", columnDefinition = "VARCHAR2|第1次-接诊医生|100|", length = 100, nullable = true)
	private String firstClinicDoctor;

	@Column(name = "FIRST_DIAGNOSIS", columnDefinition = "VARCHAR2|第1次-临床诊断|100|", length = 100, nullable = true)
	private String firstDiagnosis;

	@Column(name = "ADMISSION_FLG", columnDefinition = "VARCHAR2|是否住院|2|", length = 2, nullable = true)
	private String admissionFlg;

	@Column(name = "INHOS_ROOM", columnDefinition = "VARCHAR2|住院科室|100|", length = 100, nullable = true)
	private String inhosRoom;

	@Column(name = "MEDICAL_RECORD_NO", columnDefinition = "VARCHAR2|病例号|100|", length = 100, nullable = true)
	private String medicalRecordNo;

	@Column(name = "CARRIER_FLG", columnDefinition = "VARCHAR2|出院时病原携带情况|2|", length = 2, nullable = true)
	private String carrierFlg;

	@Column(name = "GERMICULTURE_RESULT", columnDefinition = "VARCHAR2|出院时病原携带情况-细菌培养结果|100|", length = 100, nullable = true)
	private String germicultureResult;

	@Column(name = "DENGUE_INHOS_DIAGNOSIS", columnDefinition = "VARCHAR2|登革热入院诊断|2|", length = 2, nullable = true)
	private String dengueInhosDiagnosis;

	@Column(name = "DENGUE_INHOS_DIAGNOSIS_OTHER", columnDefinition = "VARCHAR2|登革热入院诊断-其他|100|", length = 100, nullable = true)
	private String dengueInhosDiagnosisOther;

	@Column(name = "DENGUE_INHOS_DIAGNOSIS_DATE", columnDefinition = "DATE|登革热临床诊断日期||", nullable = true)
	private Date dengueInhosDiagnosisDate;

	@Column(name = "DENGUE_OUT_DIAGNOSIS", columnDefinition = "VARCHAR2|登革热出院诊断|2|", length = 2, nullable = true)
	private String dengueOutDiagnosis;

	@Column(name = "DENGUE_OUT_DIAGNOSIS_OTHER", columnDefinition = "VARCHAR2|登革热出院诊断-其他|100|", length = 100, nullable = true)
	private String dengueOutDiagnosisOther;

	@Column(name = "DENGUE_CLINICAL_TYPING", columnDefinition = "VARCHAR2|登革热临床分型|2|", length = 2, nullable = true)
	private String dengueClinicalTyping;

	@Column(name = "EHF_INHOS_DIAGNOSIS", columnDefinition = "VARCHAR2|流行性出血热入院诊断|2|", length = 2, nullable = true)
	private String ehfInhosDiagnosis;

	@Column(name = "EHF_INHOS_DIAGNOSIS_OTHER", columnDefinition = "VARCHAR2|流行性出血热入院诊断其他|100|", length = 100, nullable = true)
	private String ehfInhosDiagnosisOther;

	@Column(name = "EHF_OUT_DIAGNOSIS", columnDefinition = "VARCHAR2|流行性出血热出院诊断|2|", length = 2, nullable = true)
	private String ehfOutDiagnosis;

	@Column(name = "EHF_OUT_DIAGNOSIS_OTHER", columnDefinition = "VARCHAR2|流行性出血热出院诊断其他|100|", length = 100, nullable = true)
	private String ehfOutDiagnosisOther;

	@Column(name = "EHF_CLINICAL_TYPING", columnDefinition = "VARCHAR2|流行性出血热临床分型|2|", length = 2, nullable = true)
	private String ehfClinicalTyping;

	@Column(name = "DISEASE_NAME", columnDefinition = "VARCHAR2|疾病名称|100|", length = 100, nullable = true)
	private String diseaseName;

	@Column(name = "CONTACTS_SYMPTOMS", columnDefinition = "VARCHAR2|接触者有无相同症状|2|", length = 2, nullable = true)
	private String contactsSymptoms;

	@Column(name = "REMARKS", columnDefinition = "VARCHAR2|备注|100|", length = 100, nullable = true)
	private String remarks;

	@Column(name = "CLINICAL_MANIFESTATION", columnDefinition = "VARCHAR2|临床表现|200|", length = 200, nullable = true)
	private String clinicalManifestation;

	@Column(name = "CLINICAL_OTHER", columnDefinition = "VARCHAR2|临床表现其他|100|", length = 100, nullable = true)
	private String clinicalOther;

	@Column(name = "TEMPERATURE", columnDefinition = "VARCHAR2|临床表现_体温|20|", length = 20, nullable = true)
	private String temperature;

	@Column(name = "PNEUMONIA_FLG", columnDefinition = "VARCHAR2|是否进展为肺炎|2|", length = 2, nullable = true)
	private String pneumoniaFlg;

	@Column(name = "TAKE_ANTIVIRAL_DRUG", columnDefinition = "VARCHAR2|患者发病前两周是否服用过抗病毒药物|2|", length = 2, nullable = true)
	private String takeAntiviralDrug;

	@Column(name = "ANTIVIRAL_DRUG_NAME", columnDefinition = "VARCHAR2|药物名称|100|", length = 100, nullable = true)
	private String antiviralDrugName;

	@Column(name = "ANTIVIRAL_DRUG_OTHER", columnDefinition = "VARCHAR2|其他|100|", length = 100, nullable = true)
	private String antiviralDrugOther;

	@Column(name = "TAKE_TAMIFLU", columnDefinition = "VARCHAR2|发病后是否服用过达菲|2|", length = 2, nullable = true)
	private String takeTamiflu;

	@Column(name = "TAKE_TAMIFLU_START", columnDefinition = "DATE|开始服用日期||", nullable = true)
	private Date takeTamifluStart;

	@Column(name = "TAKE_TAMIFLU_LAST", columnDefinition = "DATE|最后服用日期||", nullable = true)
	private Date takeTamifluLast;

	@Column(name = "TAKE_TAMIFLU_DOS", columnDefinition = "VARCHAR2|服用剂量|20|", length = 20, nullable = true)
	private String takeTamifluDos;

	@Column(name = "SIDE_EFFECT", columnDefinition = "VARCHAR2|服药过程中是否出现副作用|2|", length = 2, nullable = true)
	private String sideEffect;

	@Column(name = "SIDE_EFFECT_EXPRESSION", columnDefinition = "VARCHAR2|表现|100|", length = 100, nullable = true)
	private String sideEffectExpression;

	@Column(name = "TAKE_OTHER_ANTIVIRAL_DRUG", columnDefinition = "VARCHAR2|是否服用过其他抗病毒药物|2|", length = 2, nullable = true)
	private String takeOtherAntiviralDrug;

	@Column(name = "OTHER_ANTIVIRAL_DRUG_NAME", columnDefinition = "VARCHAR2|药物名称|100|", length = 100, nullable = true)
	private String otherAntiviralDrugName;

	@Column(name = "ASSISTED_VENTILATION", columnDefinition = "VARCHAR2|患者治疗过程中是否曾使用辅助通气|2|", length = 2, nullable = true)
	private String assistedVentilation;

	@Column(name = "ASSISTED_VENTILATION_TYPE", columnDefinition = "VARCHAR2|种类|2|", length = 2, nullable = true)
	private String assistedVentilationType;

	@Column(name = "ASSISTED_VENTILATION_OTHER", columnDefinition = "VARCHAR2|其他|100|", length = 100, nullable = true)
	private String assistedVentilationOther;

	@Column(name = "TAKE_ANTIBIOTIC", columnDefinition = "VARCHAR2|患者是否曾服用抗生素|2|", length = 2, nullable = true)
	private String takeAntibiotic;

	@Column(name = "ANTIBIOTIC_NAME", columnDefinition = "VARCHAR2|药物名称|100|", length = 100, nullable = true)
	private String antibioticName;

	@Column(name = "PATHOGENESIS_PLACE_SELECT", columnDefinition = "VARCHAR2|发病地点选择版本|2|", length = 2, nullable = true)
	private String pathogenesisPlaceSelect;

	@Column(name = "SELF_MEDICATION", columnDefinition = "VARCHAR2|前往医疗机构就诊前，是否自行服药|2|", length = 2, nullable = true)
	private String selfMedication;

	@Column(name = "MEDICATION_TYPE", columnDefinition = "VARCHAR2|若自行服药，则服药种类|100|", length = 100, nullable = true)
	private String medicationType;

	@Column(name = "FIRST_SYMPTOM", columnDefinition = "VARCHAR2|首发症状|100|", length = 100, nullable = true)
	private String firstSymptom;

	@Column(name = "REPORT_ADDRESS", columnDefinition = "VARCHAR2|报告单位|100|", length = 100, nullable = true)
	private String reportAddress;

	@Column(name = "REPORT_TIME", columnDefinition = "DATE|报告时间||", nullable = true)
	private Date reportTime;

	@Column(name = "DIAGNOSIS_FLAG", columnDefinition = "VARCHAR2|是否诊断|1|", length = 1, nullable = true)
	private String diagnosisFlag;

	@Column(name = "DIE_DT", columnDefinition = "DATE|死亡日期||", nullable = true)
	private Date dieDt;

	@Column(name = "DIAGNOSIS_COURSE_DAY", columnDefinition = "VARCHAR2|病程天数|20|", length = 20, nullable = true)
	private String diagnosisCourseDay;

	@Column(name = "GBCODE", columnDefinition = "VARCHAR2|国标码|20|", length = 20, nullable = true)
	private String gbcode;

	@Column(name = "CLINIC_DOCTOR", columnDefinition = "VARCHAR2|接诊医生|50|", length = 50, nullable = true)
	private String clinicDoctor;

    @Column(name = "THIS_DIAGNOSIS_TYPE", columnDefinition = "VARCHAR2|本次诊断方式|2|", length = 2, nullable = true)
    private String thisDiagnosisType;

    @Column(name = "THIS_DIAGNOSIS_TYPE_OTHER", columnDefinition = "VARCHAR2|本次诊断方式其他|100|", length = 100, nullable = true)
    private String thisDiagnosisTypeOther;

    @Column(name = "PATHOGENESIS_TYPE", columnDefinition = "VARCHAR2|发病方式|2|", length = 2, nullable = true)
    private String pathogenesisType;

    @Column(name = "ILLNES_DEGREE", columnDefinition = "VARCHAR2|病情程度|2|", length = 2, nullable = true)
    private String illnesDegree;

    @Column(name = "MISDIAGNOSE_NUM", columnDefinition = "VARCHAR2|误诊漏诊次数|20|", length = 20, nullable = true)
    private String misdiagnoseNum;

    @Column(name = "EARLY_PART", columnDefinition = "VARCHAR2|初发部位|2|", length = 2, nullable = true)
    private String earlyPart;

    @Column(name = "EARLY_PART_OTHER", columnDefinition = "VARCHAR2|初发部位其他|100|", length = 100, nullable = true)
    private String earlyPartOther;

    @Column(name = "EARLY_SYMPTOM", columnDefinition = "VARCHAR2|初发症状|2|", length = 2, nullable = true)
    private String earlySymptom;

    @Column(name = "EARLY_SYMPTOM_OTHER", columnDefinition = "VARCHAR2|初发症状其他|100|", length = 100, nullable = true)
    private String earlySymptomOther;

    @Column(name = "TEL", columnDefinition = "VARCHAR2|确诊电话|30|", length = 30, nullable = true)
    private String tel;

    @Column(name = "LYMPHATIC", columnDefinition = "VARCHAR2|淋巴管/结炎发作情况|2|", length = 2, nullable = true)
    private String lymphatic;

    @Column(name = "BREAK_OUT_DT", columnDefinition = "DATE|首次发作日期||", nullable = true)
    private Date breakOutDt;

    @Column(name = "LAST_BREAK_OUT_DT", columnDefinition = "DATE|最近发作日期||", nullable = true)
    private Date lastBreakOutDt;

    @Column(name = "BREAK_OUT_NUM", columnDefinition = "VARCHAR2|年平均发作次数|20|", length = 20, nullable = true)
    private String breakOutNum;

    @Column(name = "PER_DAYS", columnDefinition = "VARCHAR2|平均病程天数|20|", length = 20, nullable = true)
    private String perDays;

    @Column(name = "BREAK_OUT_SEASON", columnDefinition = "VARCHAR2|发作季节|2|", length = 2, nullable = true)
    private String breakOutSeason;

    @Column(name = "BREAK_OUT_PART", columnDefinition = "VARCHAR2|发作部位|2|", length = 2, nullable = true)
    private String breakOutPart;

    @Column(name = "BREAK_OUT_POINT", columnDefinition = "VARCHAR2|发作特点|2|", length = 2, nullable = true)
    private String breakOutPoint;

    @Column(name = "ERYSIPELAS", columnDefinition = "VARCHAR2|丹毒样皮炎|2|", length = 2, nullable = true)
    private String erysipelas;

    @Column(name = "CHYLURIA", columnDefinition = "VARCHAR2|乳糜尿|2|", length = 2, nullable = true)
    private String chyluria;

    @Column(name = "CHYLURIA_DT", columnDefinition = "DATE|首次发作时间||", nullable = true)
    private Date chyluriaDt;

    @Column(name = "CHYLURIA_LAST_DT", columnDefinition = "DATE|最近发作时间||", nullable = true)
    private Date chyluriaLastDt;

    @Column(name = "CHYLURIA_RATE", columnDefinition = "VARCHAR2|发作频率|20|", length = 20, nullable = true)
    private String chyluriaRate;

    @Column(name = "CHYLURIA_DURATION", columnDefinition = "VARCHAR2|发作最长持续时间|20|", length = 20, nullable = true)
    private String chyluriaDuration;

    @Column(name = "CHYLURIA_RESULT", columnDefinition = "VARCHAR2|发作诱因|2|", length = 2, nullable = true)
    private String chyluriaResult;

    @Column(name = "CHYLURIA_POINT", columnDefinition = "VARCHAR2|发作特点|2|", length = 2, nullable = true)
    private String chyluriaPoint;

    @Column(name = "TUNICA_VAGINALI", columnDefinition = "VARCHAR2|鞘膜积液|2|", length = 2, nullable = true)
    private String tunicaVaginali;

    @Column(name = "TUNICA_VAGINALI_DT", columnDefinition = "DATE|首次发作时间||", nullable = true)
    private Date tunicaVaginaliDt;

    @Column(name = "TUNICA_VAGINALI_POINT", columnDefinition = "VARCHAR2|部位|2|", length = 2, nullable = true)
    private String tunicaVaginaliPoint;

    @Column(name = "FOREIGN_ADDR", columnDefinition = "VARCHAR2|国外发病地点|100|", length = 100, nullable = true)
    private String foreignAddr;

    @Column(name = "LYMPHEDEMA", columnDefinition = "VARCHAR2|淋巴水肿/橡皮肿|2|", length = 2, nullable = true)
    private String lymphedema;
    
    @Column(name = "PARTNER_INFECTED", columnDefinition = "VARCHAR2|配偶/固定性伴HIV感染状况|20|", length = 20, nullable = true)
   	private String partnerInfected;
   	@Column(name = "CHILDREN_INFECTED", columnDefinition = "VARCHAR2|子女HIV感染状况|20|", length = 20, nullable = true)
   	private String childrenInfected;
   	@Column(name = "DEATH_COURSE", columnDefinition = "VARCHAR2|死亡时病程阶段|20|", length = 20, nullable = true)
   	private String deathCourse;
   	@Column(name = "DEATH_CAUSE", columnDefinition = "VARCHAR2|主要死因 |20|", length = 20, nullable = true)
   	private String deathCause;
   	@Column(name = "DEATH_CAUSE_OTHER", columnDefinition = "VARCHAR2|主要死因-其他 |100|", length = 100, nullable = true)
   	private String deathCauseOther;
   	@Column(name = "INFECTION_ROUTE", columnDefinition = "VARCHAR2|最可能的感染途径 |50|", length = 50, nullable = true)
   	private String infectionRoute;
   	@Column(name = "INFECTION_ROUTE_OTHER", columnDefinition = "VARCHAR2|最可能的感染途径-其他 |100|", length = 100, nullable = true)
   	private String infectionRouteOther; 
   	@Column(name = "CROWD_CATEGORY_OTHER", columnDefinition = "VARCHAR2|人群类别-其他 |50|", length = 50, nullable = true)
   	private String crowdCategoryOther;
   	@Column(name = "CROWD_CATEGORY", columnDefinition = "VARCHAR2|人群类别 |100|", length = 100, nullable = true)
   	private String crowdCategory;
   	@Column(name = "SAMPLE_SOURCE", columnDefinition = "VARCHAR2|样本来源 |20|", length = 20, nullable = true)
   	private String sampleSource;
 	@Column(name = "SAMPLE_SOURCE_OTHER", columnDefinition = "VARCHAR2|样本来源-其他 |20|", length = 20, nullable = true)
   	private String sampleSourceOther;

	@Column(name = "IS_OVERSEAS", columnDefinition = "VARCHAR2|发病地点是否在国外|2|", length = 2, nullable = true)
	private String isOverseas;

	@Column(name = "BLOOD_TEST_DATE", columnDefinition = "DATE|血检虐原虫日期||",  nullable = true)
	private Date bloodTestDate;

	@Column(name = "MICROSCOPIC_EXAMINATION", columnDefinition = "VARCHAR2|镜检结果|2|", length = 2,  nullable = true)
	private String microscopicExamination;

	@Column(name = "IS_PRIMARY", columnDefinition = "VARCHAR2|是否初发|2|", length = 2,  nullable = true)
	private String isPrimary;

	@Column(name = "COMPLICATION", columnDefinition = "VARCHAR2|是否有并发症|2|", length = 2,  nullable = true)
	private String complication;

	@Column(name = "COMPLICATION_NAME", columnDefinition = "VARCHAR2|并发症名称|100|", length = 100,  nullable = true)
	private String complicationName;

	@Column(name = "IS_DEATH", columnDefinition = "VARCHAR2|病例是否死亡|2|", length = 2,  nullable = true)
	private String isDeath;
	
	@Column(name = "ACPROVINCE", columnDefinition = "VARCHAR2|调查地省|20|", length = 20, nullable = true)
	private String acprovince;

	@Column(name = "ACCITY", columnDefinition = "VARCHAR2|调查地市|20|", length = 20, nullable = true)
	private String accity;

	@Column(name = "ACCOUNTY", columnDefinition = "VARCHAR2|调查地县区|20|", length = 20, nullable = true)
	private String accounty;

	@Column(name = "ACTOWN_SHIP", columnDefinition = "VARCHAR2|调查地乡街道|100|", length = 100, nullable = true)
	private String actownShip;

	@Column(name = "ACSTREET", columnDefinition = "VARCHAR2|调查地村社区|100|", length = 100, nullable = true)
	private String acstreet;

	@Column(name = "ACHOUSE_NUMBER", columnDefinition = "VARCHAR2|调查地门牌号|100|", length = 100, nullable = true)
	private String achouseNumber;

    @Column(name = "AC_ADDRESS", columnDefinition = "VARCHAR2|调查地详细|100|", length = 100, nullable = true)
    private String acAddress;

    @Transient
    private String pathogenesisHour;//发病日期-小时
    @Transient
    private String firstVisitHour;// 首诊时间-小时
    
	public String getAcprovince() {
		return acprovince;
	}

	public void setAcprovince(String acprovince) {
		this.acprovince = acprovince;
	}

	public String getAccity() {
		return accity;
	}

	public void setAccity(String accity) {
		this.accity = accity;
	}

	public String getAccounty() {
		return accounty;
	}

	public void setAccounty(String accounty) {
		this.accounty = accounty;
	}

	public String getActownShip() {
		return actownShip;
	}

	public void setActownShip(String actownShip) {
		this.actownShip = actownShip;
	}

	public String getAcstreet() {
		return acstreet;
	}

	public void setAcstreet(String acstreet) {
		this.acstreet = acstreet;
	}

	public String getAchouseNumber() {
		return achouseNumber;
	}

	public void setAchouseNumber(String achouseNumber) {
		this.achouseNumber = achouseNumber;
	}

	public String getAcAddress() {
		return acAddress;
	}

	public void setAcAddress(String acAddress) {
		this.acAddress = acAddress;
	}

	public String getComplication() {
		return complication;
	}

	public void setComplication(String complication) {
		this.complication = complication;
	}

	public String getComplicationName() {
		return complicationName;
	}

	public void setComplicationName(String complicationName) {
		this.complicationName = complicationName;
	}

	public String getIsDeath() {
		return isDeath;
	}

	public void setIsDeath(String isDeath) {
		this.isDeath = isDeath;
	}

	public String getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(String isPrimary) {
		this.isPrimary = isPrimary;
	}

	public String getMicroscopicExamination() {
		return microscopicExamination;
	}

	public void setMicroscopicExamination(String microscopicExamination) {
		this.microscopicExamination = microscopicExamination;
	}

	public Date getBloodTestDate() {
		return bloodTestDate;
	}

	public void setBloodTestDate(Date bloodTestDate) {
		this.bloodTestDate = bloodTestDate;
	}

	public String getIsOverseas() {
		return isOverseas;
	}

	public void setIsOverseas(String isOverseas) {
		this.isOverseas = isOverseas;
	}

	public String getSampleSourceOther() {
		return sampleSourceOther;
	}

	public void setSampleSourceOther(String sampleSourceOther) {
		this.sampleSourceOther = sampleSourceOther;
	}

	public String getPartnerInfected() {
		return partnerInfected;
	}

	public void setPartnerInfected(String partnerInfected) {
		this.partnerInfected = partnerInfected;
	}

	public String getChildrenInfected() {
		return childrenInfected;
	}

	public void setChildrenInfected(String childrenInfected) {
		this.childrenInfected = childrenInfected;
	}

	public String getDeathCourse() {
		return deathCourse;
	}

	public void setDeathCourse(String deathCourse) {
		this.deathCourse = deathCourse;
	}

	public String getDeathCause() {
		return deathCause;
	}

	public void setDeathCause(String deathCause) {
		this.deathCause = deathCause;
	}

	public String getDeathCauseOther() {
		return deathCauseOther;
	}

	public void setDeathCauseOther(String deathCauseOther) {
		this.deathCauseOther = deathCauseOther;
	}

	public String getInfectionRoute() {
		return infectionRoute;
	}

	public void setInfectionRoute(String infectionRoute) {
		this.infectionRoute = infectionRoute;
	}

	public String getInfectionRouteOther() {
		return infectionRouteOther;
	}

	public void setInfectionRouteOther(String infectionRouteOther) {
		this.infectionRouteOther = infectionRouteOther;
	}

	public String getCrowdCategoryOther() {
		return crowdCategoryOther;
	}

	public void setCrowdCategoryOther(String crowdCategoryOther) {
		this.crowdCategoryOther = crowdCategoryOther;
	}

	public String getCrowdCategory() {
		return crowdCategory;
	}

	public void setCrowdCategory(String crowdCategory) {
		this.crowdCategory = crowdCategory;
	}

	public String getSampleSource() {
		return sampleSource;
	}

	public void setSampleSource(String sampleSource) {
		this.sampleSource = sampleSource;
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

	public Date getPathogenesisDate() {
		return this.pathogenesisDate;
	}

	public void setPathogenesisDate(Date pathogenesisDate) {
		this.pathogenesisDate = pathogenesisDate;
	}

	public Date getClinicDate() {
		return this.clinicDate;
	}

	public void setClinicDate(Date clinicDate) {
		this.clinicDate = clinicDate;
	}

	public String getPathogenesisPlace() {
		return this.pathogenesisPlace;
	}

	public void setPathogenesisPlace(String pathogenesisPlace) {
		this.pathogenesisPlace = pathogenesisPlace;
	}

	public String getAdmissionHospital() {
		return this.admissionHospital;
	}

	public void setAdmissionHospital(String admissionHospital) {
		this.admissionHospital = admissionHospital;
	}

	public String getAdmissionNo() {
		return this.admissionNo;
	}

	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}

	public Date getInhosDate() {
		return this.inhosDate;
	}

	public void setInhosDate(Date inhosDate) {
		this.inhosDate = inhosDate;
	}

	public Date getOutHospitalDate() {
		return this.outHospitalDate;
	}

	public void setOutHospitalDate(Date outHospitalDate) {
		this.outHospitalDate = outHospitalDate;
	}

	public String getInhosDiagnosis() {
		return this.inhosDiagnosis;
	}

	public void setInhosDiagnosis(String inhosDiagnosis) {
		this.inhosDiagnosis = inhosDiagnosis;
	}

	public String getInhosDiagnosisOther() {
		return this.inhosDiagnosisOther;
	}

	public void setInhosDiagnosisOther(String inhosDiagnosisOther) {
		this.inhosDiagnosisOther = inhosDiagnosisOther;
	}

	public Date getInhosDiagnosisDate() {
		return this.inhosDiagnosisDate;
	}

	public void setInhosDiagnosisDate(Date inhosDiagnosisDate) {
		this.inhosDiagnosisDate = inhosDiagnosisDate;
	}

	public String getClinicalClassification() {
		return this.clinicalClassification;
	}

	public void setClinicalClassification(String clinicalClassification) {
		this.clinicalClassification = clinicalClassification;
	}

	public String getOutDiagnosis() {
		return this.outDiagnosis;
	}

	public void setOutDiagnosis(String outDiagnosis) {
		this.outDiagnosis = outDiagnosis;
	}

	public String getOutDiagnosisOther() {
		return this.outDiagnosisOther;
	}

	public void setOutDiagnosisOther(String outDiagnosisOther) {
		this.outDiagnosisOther = outDiagnosisOther;
	}

	public String getAntibacterialDrugName() {
		return this.antibacterialDrugName;
	}

	public void setAntibacterialDrugName(String antibacterialDrugName) {
		this.antibacterialDrugName = antibacterialDrugName;
	}

	public Date getFirstUseTime() {
		return this.firstUseTime;
	}

	public void setFirstUseTime(Date firstUseTime) {
		this.firstUseTime = firstUseTime;
	}

	public String getFirstUseUnit() {
		return this.firstUseUnit;
	}

	public void setFirstUseUnit(String firstUseUnit) {
		this.firstUseUnit = firstUseUnit;
	}

	public String getHerxheimerReaction() {
		return this.herxheimerReaction;
	}

	public void setHerxheimerReaction(String herxheimerReaction) {
		this.herxheimerReaction = herxheimerReaction;
	}

	public String getHormonotherapy() {
		return this.hormonotherapy;
	}

	public void setHormonotherapy(String hormonotherapy) {
		this.hormonotherapy = hormonotherapy;
	}

	public Date getFirstVisitDate() {
		return this.firstVisitDate;
	}

	public void setFirstVisitDate(Date firstVisitDate) {
		this.firstVisitDate = firstVisitDate;
	}

	public String getFirstVisitUnit() {
		return this.firstVisitUnit;
	}

	public void setFirstVisitUnit(String firstVisitUnit) {
		this.firstVisitUnit = firstVisitUnit;
	}

	public Date getConfirmationDate() {
		return this.confirmationDate;
	}

	public void setConfirmationDate(Date confirmationDate) {
		this.confirmationDate = confirmationDate;
	}

	public String getConfirmationHospital() {
		return this.confirmationHospital;
	}

	public void setConfirmationHospital(String confirmationHospital) {
		this.confirmationHospital = confirmationHospital;
	}

	public String getFirstVisitName() {
		return this.firstVisitName;
	}

	public void setFirstVisitName(String firstVisitName) {
		this.firstVisitName = firstVisitName;
	}

	public String getConfirmationName() {
		return this.confirmationName;
	}

	public void setConfirmationName(String confirmationName) {
		this.confirmationName = confirmationName;
	}

	public String getPrognosis() {
		return this.prognosis;
	}

	public void setPrognosis(String prognosis) {
		this.prognosis = prognosis;
	}

	public String getPrognosisOther() {
		return this.prognosisOther;
	}

	public void setPrognosisOther(String prognosisOther) {
		this.prognosisOther = prognosisOther;
	}

	public String getSequelae() {
		return this.sequelae;
	}

	public void setSequelae(String sequelae) {
		this.sequelae = sequelae;
	}

	public String getSequelaeName() {
		return this.sequelaeName;
	}

	public void setSequelaeName(String sequelaeName) {
		this.sequelaeName = sequelaeName;
	}

	public String getInvasionPaprovince() {
		return this.invasionPaprovince;
	}

	public void setInvasionPaprovince(String invasionPaprovince) {
		this.invasionPaprovince = invasionPaprovince;
	}

	public String getInvasionPacity() {
		return this.invasionPacity;
	}

	public void setInvasionPacity(String invasionPacity) {
		this.invasionPacity = invasionPacity;
	}

	public String getInvasionPacounty() {
		return this.invasionPacounty;
	}

	public void setInvasionPacounty(String invasionPacounty) {
		this.invasionPacounty = invasionPacounty;
	}

	public String getMotherAge() {
		return this.motherAge;
	}

	public void setMotherAge(String motherAge) {
		this.motherAge = motherAge;
	}

	public String getTetanusToxoidFlg() {
		return this.tetanusToxoidFlg;
	}

	public void setTetanusToxoidFlg(String tetanusToxoidFlg) {
		this.tetanusToxoidFlg = tetanusToxoidFlg;
	}

	public String getVaccinateCount() {
		return this.vaccinateCount;
	}

	public void setVaccinateCount(String vaccinateCount) {
		this.vaccinateCount = vaccinateCount;
	}

	public Date getLastVaccinateDate() {
		return this.lastVaccinateDate;
	}

	public void setLastVaccinateDate(Date lastVaccinateDate) {
		this.lastVaccinateDate = lastVaccinateDate;
	}

	public String getPrenatalDiagnosis() {
		return this.prenatalDiagnosis;
	}

	public void setPrenatalDiagnosis(String prenatalDiagnosis) {
		this.prenatalDiagnosis = prenatalDiagnosis;
	}

	public String getMidwife() {
		return this.midwife;
	}

	public void setMidwife(String midwife) {
		this.midwife = midwife;
	}

	public String getHospitalFlg() {
		return this.hospitalFlg;
	}

	public void setHospitalFlg(String hospitalFlg) {
		this.hospitalFlg = hospitalFlg;
	}

	public Date getFirstClinicOrganDate() {
		return this.firstClinicOrganDate;
	}

	public void setFirstClinicOrganDate(Date firstClinicOrganDate) {
		this.firstClinicOrganDate = firstClinicOrganDate;
	}

	public String getOrganLevel() {
		return this.organLevel;
	}

	public void setOrganLevel(String organLevel) {
		this.organLevel = organLevel;
	}

	public String getDiagnosis() {
		return this.diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getDeathMocezueloFlag() {
		return this.deathMocezueloFlag;
	}

	public void setDeathMocezueloFlag(String deathMocezueloFlag) {
		this.deathMocezueloFlag = deathMocezueloFlag;
	}

	public String getMocezueloFlag() {
		return this.mocezueloFlag;
	}

	public void setMocezueloFlag(String mocezueloFlag) {
		this.mocezueloFlag = mocezueloFlag;
	}

	public String getAroundInvasion() {
		return this.aroundInvasion;
	}

	public void setAroundInvasion(String aroundInvasion) {
		this.aroundInvasion = aroundInvasion;
	}

	public String getAroundInvasionCount() {
		return this.aroundInvasionCount;
	}

	public void setAroundInvasionCount(String aroundInvasionCount) {
		this.aroundInvasionCount = aroundInvasionCount;
	}

	public String getFirstClinicOrgan() {
		return this.firstClinicOrgan;
	}

	public void setFirstClinicOrgan(String firstClinicOrgan) {
		this.firstClinicOrgan = firstClinicOrgan;
	}

	public String getFirstClinicDoctor() {
		return this.firstClinicDoctor;
	}

	public void setFirstClinicDoctor(String firstClinicDoctor) {
		this.firstClinicDoctor = firstClinicDoctor;
	}

	public String getFirstDiagnosis() {
		return this.firstDiagnosis;
	}

	public void setFirstDiagnosis(String firstDiagnosis) {
		this.firstDiagnosis = firstDiagnosis;
	}

	public String getAdmissionFlg() {
		return this.admissionFlg;
	}

	public void setAdmissionFlg(String admissionFlg) {
		this.admissionFlg = admissionFlg;
	}

	public String getInhosRoom() {
		return this.inhosRoom;
	}

	public void setInhosRoom(String inhosRoom) {
		this.inhosRoom = inhosRoom;
	}

	public String getMedicalRecordNo() {
		return this.medicalRecordNo;
	}

	public void setMedicalRecordNo(String medicalRecordNo) {
		this.medicalRecordNo = medicalRecordNo;
	}

	public String getCarrierFlg() {
		return this.carrierFlg;
	}

	public void setCarrierFlg(String carrierFlg) {
		this.carrierFlg = carrierFlg;
	}

	public String getGermicultureResult() {
		return this.germicultureResult;
	}

	public void setGermicultureResult(String germicultureResult) {
		this.germicultureResult = germicultureResult;
	}

	public String getDengueInhosDiagnosis() {
		return this.dengueInhosDiagnosis;
	}

	public void setDengueInhosDiagnosis(String dengueInhosDiagnosis) {
		this.dengueInhosDiagnosis = dengueInhosDiagnosis;
	}

	public String getDengueInhosDiagnosisOther() {
		return this.dengueInhosDiagnosisOther;
	}

	public void setDengueInhosDiagnosisOther(String dengueInhosDiagnosisOther) {
		this.dengueInhosDiagnosisOther = dengueInhosDiagnosisOther;
	}

	public Date getDengueInhosDiagnosisDate() {
		return this.dengueInhosDiagnosisDate;
	}

	public void setDengueInhosDiagnosisDate(Date dengueInhosDiagnosisDate) {
		this.dengueInhosDiagnosisDate = dengueInhosDiagnosisDate;
	}

	public String getDengueOutDiagnosis() {
		return this.dengueOutDiagnosis;
	}

	public void setDengueOutDiagnosis(String dengueOutDiagnosis) {
		this.dengueOutDiagnosis = dengueOutDiagnosis;
	}

	public String getDengueOutDiagnosisOther() {
		return this.dengueOutDiagnosisOther;
	}

	public void setDengueOutDiagnosisOther(String dengueOutDiagnosisOther) {
		this.dengueOutDiagnosisOther = dengueOutDiagnosisOther;
	}

	public String getDengueClinicalTyping() {
		return this.dengueClinicalTyping;
	}

	public void setDengueClinicalTyping(String dengueClinicalTyping) {
		this.dengueClinicalTyping = dengueClinicalTyping;
	}

	public String getEhfInhosDiagnosis() {
		return this.ehfInhosDiagnosis;
	}

	public void setEhfInhosDiagnosis(String ehfInhosDiagnosis) {
		this.ehfInhosDiagnosis = ehfInhosDiagnosis;
	}

	public String getEhfInhosDiagnosisOther() {
		return this.ehfInhosDiagnosisOther;
	}

	public void setEhfInhosDiagnosisOther(String ehfInhosDiagnosisOther) {
		this.ehfInhosDiagnosisOther = ehfInhosDiagnosisOther;
	}

	public String getEhfOutDiagnosis() {
		return this.ehfOutDiagnosis;
	}

	public void setEhfOutDiagnosis(String ehfOutDiagnosis) {
		this.ehfOutDiagnosis = ehfOutDiagnosis;
	}

	public String getEhfOutDiagnosisOther() {
		return this.ehfOutDiagnosisOther;
	}

	public void setEhfOutDiagnosisOther(String ehfOutDiagnosisOther) {
		this.ehfOutDiagnosisOther = ehfOutDiagnosisOther;
	}

	public String getEhfClinicalTyping() {
		return this.ehfClinicalTyping;
	}

	public void setEhfClinicalTyping(String ehfClinicalTyping) {
		this.ehfClinicalTyping = ehfClinicalTyping;
	}

	public String getDiseaseName() {
		return this.diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public String getContactsSymptoms() {
		return this.contactsSymptoms;
	}

	public void setContactsSymptoms(String contactsSymptoms) {
		this.contactsSymptoms = contactsSymptoms;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getClinicalManifestation() {
		return this.clinicalManifestation;
	}

	public void setClinicalManifestation(String clinicalManifestation) {
		this.clinicalManifestation = clinicalManifestation;
	}

	public String getClinicalOther() {
		return this.clinicalOther;
	}

	public void setClinicalOther(String clinicalOther) {
		this.clinicalOther = clinicalOther;
	}

	public String getTemperature() {
		return this.temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getPneumoniaFlg() {
		return this.pneumoniaFlg;
	}

	public void setPneumoniaFlg(String pneumoniaFlg) {
		this.pneumoniaFlg = pneumoniaFlg;
	}

	public String getTakeAntiviralDrug() {
		return this.takeAntiviralDrug;
	}

	public void setTakeAntiviralDrug(String takeAntiviralDrug) {
		this.takeAntiviralDrug = takeAntiviralDrug;
	}

	public String getAntiviralDrugName() {
		return this.antiviralDrugName;
	}

	public void setAntiviralDrugName(String antiviralDrugName) {
		this.antiviralDrugName = antiviralDrugName;
	}

	public String getAntiviralDrugOther() {
		return this.antiviralDrugOther;
	}

	public void setAntiviralDrugOther(String antiviralDrugOther) {
		this.antiviralDrugOther = antiviralDrugOther;
	}

	public String getTakeTamiflu() {
		return this.takeTamiflu;
	}

	public void setTakeTamiflu(String takeTamiflu) {
		this.takeTamiflu = takeTamiflu;
	}

	public Date getTakeTamifluStart() {
		return this.takeTamifluStart;
	}

	public void setTakeTamifluStart(Date takeTamifluStart) {
		this.takeTamifluStart = takeTamifluStart;
	}

	public Date getTakeTamifluLast() {
		return this.takeTamifluLast;
	}

	public void setTakeTamifluLast(Date takeTamifluLast) {
		this.takeTamifluLast = takeTamifluLast;
	}

	public String getTakeTamifluDos() {
		return this.takeTamifluDos;
	}

	public void setTakeTamifluDos(String takeTamifluDos) {
		this.takeTamifluDos = takeTamifluDos;
	}

	public String getSideEffect() {
		return this.sideEffect;
	}

	public void setSideEffect(String sideEffect) {
		this.sideEffect = sideEffect;
	}

	public String getSideEffectExpression() {
		return this.sideEffectExpression;
	}

	public void setSideEffectExpression(String sideEffectExpression) {
		this.sideEffectExpression = sideEffectExpression;
	}

	public String getTakeOtherAntiviralDrug() {
		return this.takeOtherAntiviralDrug;
	}

	public void setTakeOtherAntiviralDrug(String takeOtherAntiviralDrug) {
		this.takeOtherAntiviralDrug = takeOtherAntiviralDrug;
	}

	public String getOtherAntiviralDrugName() {
		return this.otherAntiviralDrugName;
	}

	public void setOtherAntiviralDrugName(String otherAntiviralDrugName) {
		this.otherAntiviralDrugName = otherAntiviralDrugName;
	}

	public String getAssistedVentilation() {
		return this.assistedVentilation;
	}

	public void setAssistedVentilation(String assistedVentilation) {
		this.assistedVentilation = assistedVentilation;
	}

	public String getAssistedVentilationType() {
		return this.assistedVentilationType;
	}

	public void setAssistedVentilationType(String assistedVentilationType) {
		this.assistedVentilationType = assistedVentilationType;
	}

	public String getAssistedVentilationOther() {
		return this.assistedVentilationOther;
	}

	public void setAssistedVentilationOther(String assistedVentilationOther) {
		this.assistedVentilationOther = assistedVentilationOther;
	}

	public String getTakeAntibiotic() {
		return this.takeAntibiotic;
	}

	public void setTakeAntibiotic(String takeAntibiotic) {
		this.takeAntibiotic = takeAntibiotic;
	}

	public String getAntibioticName() {
		return this.antibioticName;
	}

	public void setAntibioticName(String antibioticName) {
		this.antibioticName = antibioticName;
	}

	public String getPathogenesisPlaceSelect() {
		return this.pathogenesisPlaceSelect;
	}

	public void setPathogenesisPlaceSelect(String pathogenesisPlaceSelect) {
		this.pathogenesisPlaceSelect = pathogenesisPlaceSelect;
	}

	public String getSelfMedication() {
		return this.selfMedication;
	}

	public void setSelfMedication(String selfMedication) {
		this.selfMedication = selfMedication;
	}

	public String getMedicationType() {
		return this.medicationType;
	}

	public void setMedicationType(String medicationType) {
		this.medicationType = medicationType;
	}

	public String getFirstSymptom() {
		return this.firstSymptom;
	}

	public void setFirstSymptom(String firstSymptom) {
		this.firstSymptom = firstSymptom;
	}

	public String getReportAddress() {
		return this.reportAddress;
	}

	public void setReportAddress(String reportAddress) {
		this.reportAddress = reportAddress;
	}

	public Date getReportTime() {
		return this.reportTime;
	}

	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}

	public String getDiagnosisFlag() {
		return this.diagnosisFlag;
	}

	public void setDiagnosisFlag(String diagnosisFlag) {
		this.diagnosisFlag = diagnosisFlag;
	}

	public Date getDieDt() {
		return this.dieDt;
	}

	public void setDieDt(Date dieDt) {
		this.dieDt = dieDt;
	}

	public String getDiagnosisCourseDay() {
		return this.diagnosisCourseDay;
	}

	public void setDiagnosisCourseDay(String diagnosisCourseDay) {
		this.diagnosisCourseDay = diagnosisCourseDay;
	}

	public String getGbcode() {
		return this.gbcode;
	}

	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
	}

	public String getClinicDoctor() {
		return this.clinicDoctor;
	}

	public void setClinicDoctor(String clinicDoctor) {
		this.clinicDoctor = clinicDoctor;
	}

    @Transient
    private String confirmationHour;//确诊时间-小时

    public String getConfirmationHour() {
        return confirmationHour;
    }

    public void setConfirmationHour(String confirmationHour) {
        this.confirmationHour = confirmationHour;
    }

    public String getThisDiagnosisType() {
        return thisDiagnosisType;
    }

    public void setThisDiagnosisType(String thisDiagnosisType) {
        this.thisDiagnosisType = thisDiagnosisType;
    }

    public String getThisDiagnosisTypeOther() {
        return thisDiagnosisTypeOther;
    }

    public void setThisDiagnosisTypeOther(String thisDiagnosisTypeOther) {
        this.thisDiagnosisTypeOther = thisDiagnosisTypeOther;
    }

    public String getPathogenesisType() {
        return pathogenesisType;
    }

    public void setPathogenesisType(String pathogenesisType) {
        this.pathogenesisType = pathogenesisType;
    }

    public String getIllnesDegree() {
        return illnesDegree;
    }

    public void setIllnesDegree(String illnesDegree) {
        this.illnesDegree = illnesDegree;
    }

    public String getMisdiagnoseNum() {
        return misdiagnoseNum;
    }

    public void setMisdiagnoseNum(String misdiagnoseNum) {
        this.misdiagnoseNum = misdiagnoseNum;
    }

    public String getEarlyPart() {
        return earlyPart;
    }

    public void setEarlyPart(String earlyPart) {
        this.earlyPart = earlyPart;
    }

    public String getEarlyPartOther() {
        return earlyPartOther;
    }

    public void setEarlyPartOther(String earlyPartOther) {
        this.earlyPartOther = earlyPartOther;
    }

    public String getEarlySymptom() {
        return earlySymptom;
    }

    public void setEarlySymptom(String earlySymptom) {
        this.earlySymptom = earlySymptom;
    }

    public String getEarlySymptomOther() {
        return earlySymptomOther;
    }

    public void setEarlySymptomOther(String earlySymptomOther) {
        this.earlySymptomOther = earlySymptomOther;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLymphatic() {
        return lymphatic;
    }

    public void setLymphatic(String lymphatic) {
        this.lymphatic = lymphatic;
    }

    public Date getBreakOutDt() {
        return breakOutDt;
    }

    public void setBreakOutDt(Date breakOutDt) {
        this.breakOutDt = breakOutDt;
    }

    public Date getLastBreakOutDt() {
        return lastBreakOutDt;
    }

    public void setLastBreakOutDt(Date lastBreakOutDt) {
        this.lastBreakOutDt = lastBreakOutDt;
    }

    public String getBreakOutNum() {
        return breakOutNum;
    }

    public void setBreakOutNum(String breakOutNum) {
        this.breakOutNum = breakOutNum;
    }

    public String getPerDays() {
        return perDays;
    }

    public void setPerDays(String perDays) {
        this.perDays = perDays;
    }

    public String getBreakOutSeason() {
        return breakOutSeason;
    }

    public void setBreakOutSeason(String breakOutSeason) {
        this.breakOutSeason = breakOutSeason;
    }

    public String getBreakOutPart() {
        return breakOutPart;
    }

    public void setBreakOutPart(String breakOutPart) {
        this.breakOutPart = breakOutPart;
    }

    public String getBreakOutPoint() {
        return breakOutPoint;
    }

    public void setBreakOutPoint(String breakOutPoint) {
        this.breakOutPoint = breakOutPoint;
    }

    public String getErysipelas() {
        return erysipelas;
    }

    public void setErysipelas(String erysipelas) {
        this.erysipelas = erysipelas;
    }

    public String getChyluria() {
        return chyluria;
    }

    public void setChyluria(String chyluria) {
        this.chyluria = chyluria;
    }

    public Date getChyluriaDt() {
        return chyluriaDt;
    }

    public void setChyluriaDt(Date chyluriaDt) {
        this.chyluriaDt = chyluriaDt;
    }

    public Date getChyluriaLastDt() {
        return chyluriaLastDt;
    }

    public void setChyluriaLastDt(Date chyluriaLastDt) {
        this.chyluriaLastDt = chyluriaLastDt;
    }

    public String getChyluriaRate() {
        return chyluriaRate;
    }

    public void setChyluriaRate(String chyluriaRate) {
        this.chyluriaRate = chyluriaRate;
    }

    public String getChyluriaDuration() {
        return chyluriaDuration;
    }

    public void setChyluriaDuration(String chyluriaDuration) {
        this.chyluriaDuration = chyluriaDuration;
    }

    public String getChyluriaResult() {
        return chyluriaResult;
    }

    public void setChyluriaResult(String chyluriaResult) {
        this.chyluriaResult = chyluriaResult;
    }

    public String getChyluriaPoint() {
        return chyluriaPoint;
    }

    public void setChyluriaPoint(String chyluriaPoint) {
        this.chyluriaPoint = chyluriaPoint;
    }

    public String getTunicaVaginali() {
        return tunicaVaginali;
    }

    public void setTunicaVaginali(String tunicaVaginali) {
        this.tunicaVaginali = tunicaVaginali;
    }

    public Date getTunicaVaginaliDt() {
        return tunicaVaginaliDt;
    }

    public void setTunicaVaginaliDt(Date tunicaVaginaliDt) {
        this.tunicaVaginaliDt = tunicaVaginaliDt;
    }

    public String getTunicaVaginaliPoint() {
        return tunicaVaginaliPoint;
    }

    public void setTunicaVaginaliPoint(String tunicaVaginaliPoint) {
        this.tunicaVaginaliPoint = tunicaVaginaliPoint;
    }

    public String getForeignAddr() {
        return foreignAddr;
    }

    public void setForeignAddr(String foreignAddr) {
        this.foreignAddr = foreignAddr;
    }

    public String getLymphedema() {
        return lymphedema;
    }

    public void setLymphedema(String lymphedema) {
        this.lymphedema = lymphedema;
    }

    public String getFirstVisitUnitOther() {
        return firstVisitUnitOther;
    }

    public void setFirstVisitUnitOther(String firstVisitUnitOther) {
        this.firstVisitUnitOther = firstVisitUnitOther;
    }

	public String getPathogenesisHour() {
		return pathogenesisHour;
	}

	public void setPathogenesisHour(String pathogenesisHour) {
		this.pathogenesisHour = pathogenesisHour;
	}

	public String getFirstVisitHour() {
		return firstVisitHour;
	}

	public void setFirstVisitHour(String firstVisitHour) {
		this.firstVisitHour = firstVisitHour;
	}
    
}
