package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
/**
 * 既往史
 * @author Jiang Haiying
 *
 */
@Entity
@Table(name = "IDM_PAST_HISTORY")
public class PastHistory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "VARCHAR2|本系统唯一编码|11|", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "VD_HISTORY", columnDefinition = "VARCHAR2|既往性病史|2|", length = 2, nullable = true)
	private String vdHistory;

	@Column(name = "VD_NAME", columnDefinition = "VARCHAR2|性病病名|100|", length = 100, nullable = true)
	private String vdName;

	@Column(name = "VD_DATE", columnDefinition = "DATE|性病患病时间||", nullable = true)
	private Date vdDate;

	@Column(name = "SPOUSE_VD_HISTORY", columnDefinition = "VARCHAR2|配偶性病史|2|", length = 2, nullable = true)
	private String spouseVdHistory;

	@Column(name = "SPOUSE_VD_NAME", columnDefinition = "VARCHAR2|配偶性病病名|100|", length = 100, nullable = true)
	private String spouseVdName;

	@Column(name = "SPOUSE_VD_DATE", columnDefinition = "DATE|配偶性病患病时间||", nullable = true)
	private Date spouseVdDate;

	@Column(name = "PARENTS_VD_HISTORY", columnDefinition = "VARCHAR2|父母性病史|2|", length = 2, nullable = true)
	private String parentsVdHistory;

	@Column(name = "CYST_OPERATION", columnDefinition = "VARCHAR2|囊肿摘除手术|2|", length = 2, nullable = true)
	private String cystOperation;

	@Column(name = "MEDICATION_HISTORY", columnDefinition = "VARCHAR2|药物治疗史|2|", length = 2, nullable = true)
	private String medicationHistory;

	@Column(name = "PAST_HISTORY", columnDefinition = "VARCHAR2|既往史描述|100|", length = 100, nullable = true)
	private String pastHistory;

	@Column(name = "HEALTH_FLG", columnDefinition = "VARCHAR2|过去身体是否健康|2|", length = 2, nullable = true)
	private String healthFlg;

	@Column(name = "DENGUE_JE_FLG", columnDefinition = "VARCHAR2|既往是否患过登革热或“乙脑”|2|", length = 2, nullable = true)
	private String dengueJeFlg;

	@Column(name = "JE_VACCINE_FLG", columnDefinition = "VARCHAR2|乙脑疫苗接种|2|", length = 2, nullable = true)
	private String jeVaccineFlg;

	@Column(name = "PAST_EHF_FLG", columnDefinition = "VARCHAR2|既往是否患过此病|2|", length = 2, nullable = true)
	private String pastEhfFlg;

	@Column(name = "EHF_DIAGNOSE_UNIT", columnDefinition = "VARCHAR2|患过此病诊断单位|100|", length = 100, nullable = true)
	private String ehfDiagnoseUnit;

	@Column(name = "EHF_DIAGNOSE_TIME", columnDefinition = "DATE|患过此病诊断时间||", nullable = true)
	private Date ehfDiagnoseTime;

	@Column(name = "RATPROOF_FLG", columnDefinition = "VARCHAR2|食物、粮食有无防鼠设备|2|", length = 2, nullable = true)
	private String ratproofFlg;

	@Column(name = "EHF_VACCINE_FLG", columnDefinition = "VARCHAR2|流行性出血热疫苗预防接种史|2|", length = 2, nullable = true)
	private String ehfVaccineFlg;

	@Column(name = "LAST_TIME_VACCINATE", columnDefinition = "DATE|最近一次接种时间||", nullable = true)
	private Date lastTimeVaccinate;

	@Column(name = "FAMILY_EHF_SYMPTOMS", columnDefinition = "VARCHAR2|有无家庭其他成员出现过类似症状|2|", length = 2, nullable = true)
	private String familyEhfSymptoms;

	@Column(name = "FAMILY_EHF_TIME", columnDefinition = "DATE|最近一例发病时间（患者除外）||", nullable = true)
	private Date familyEhfTime;

	@Column(name = "RATS_FLG", columnDefinition = "VARCHAR2|房内有无鼠|2|", length = 2, nullable = true)
	private String ratsFlg;

	@Column(name = "VARIA_FLG", columnDefinition = "VARCHAR2|院内有无杂物、草堆等|2|", length = 2, nullable = true)
	private String variaFlg;

	@Column(name = "ASTHMA_FLG", columnDefinition = "VARCHAR2|哮喘|2|", length = 2, nullable = true)
	private String asthmaFlg;

	@Column(name = "CPD_FLG", columnDefinition = "VARCHAR2|慢性肺病|2|", length = 2, nullable = true)
	private String cpdFlg;

	@Column(name = "CLD_FLG", columnDefinition = "VARCHAR2|慢性肝病|2|", length = 2, nullable = true)
	private String cldFlg;

	@Column(name = "DM_FLG", columnDefinition = "VARCHAR2|糖尿病|2|", length = 2, nullable = true)
	private String dmFlg;

	@Column(name = "TUBERCULOSIS_FLG", columnDefinition = "VARCHAR2|结核病|2|", length = 2, nullable = true)
	private String tuberculosisFlg;

	@Column(name = "CRD_FLG", columnDefinition = "VARCHAR2|慢性肾脏疾病|2|", length = 2, nullable = true)
	private String crdFlg;

	@Column(name = "HEART_DISEASE_FLG", columnDefinition = "VARCHAR2|心脏病|2|", length = 2, nullable = true)
	private String heartDiseaseFlg;

	@Column(name = "NERVOUS_DISEASES_FLG", columnDefinition = "VARCHAR2|神经系统疾病|2|", length = 2, nullable = true)
	private String nervousDiseasesFlg;

	@Column(name = "CANCER_FLG", columnDefinition = "VARCHAR2|癌症|2|", length = 2, nullable = true)
	private String cancerFlg;

	@Column(name = "HIV_AIDS_FLG", columnDefinition = "VARCHAR2|HIV/AIDS|2|", length = 2, nullable = true)
	private String hivAidsFlg;

	@Column(name = "IMMUNE_DEFICIENCY_FLG", columnDefinition = "VARCHAR2|其他免疫缺陷疾病|2|", length = 2, nullable = true)
	private String immuneDeficiencyFlg;

	@Column(name = "PREGNANCY_FLG", columnDefinition = "VARCHAR2|是否怀孕|2|", length = 2, nullable = true)
	private String pregnancyFlg;

	@Column(name = "GESTATION", columnDefinition = "VARCHAR2|孕期|20|", length = 20, nullable = true)
	private String gestation;

	@Column(name = "SMOKE_FLG", columnDefinition = "VARCHAR2|是否吸烟|2|", length = 2, nullable = true)
	private String smokeFlg;

	@Column(name = "SMOKE_DAY_COUNT", columnDefinition = "VARCHAR2|每天抽|2|", length = 2, nullable = true)
	private String smokeDayCount;

	@Column(name = "INFLUENZA_VACCINE", columnDefinition = "VARCHAR2|发病前1年内是否接种流感疫苗|2|", length = 2, nullable = true)
	private String influenzaVaccine;

	@Column(name = "INFLUENZA_VACCINE_DATE", columnDefinition = "DATE|接种时间||", nullable = true)
	private Date influenzaVaccineDate;

	@Column(name = "PNU_IMUNE_FLG", columnDefinition = "VARCHAR2|发病前1年内是否接种肺炎球菌疫苗|2|", length = 2, nullable = true)
	private String pnuImuneFlg;

	@Column(name = "PNU_IMUNE_DATE", columnDefinition = "DATE|接种时间||", nullable = true)
	private Date pnuImuneDate;

	@Column(name = "BASIC_DISEASE_FLG", columnDefinition = "VARCHAR2|基础疾病(糖尿病、高血压、心脏病、肾病等)|2|", length = 2, nullable = true)
	private String basicDiseaseFlg;

	@Column(name = "PAST_HISTORY_SARS", columnDefinition = "VARCHAR2|既往非典病史|2|", length = 2, nullable = true)
	private String pastHistorySars;

	@Column(name = "CHRONIC_DISEASE", columnDefinition = "VARCHAR2|有慢性疾病|100|", length = 100, nullable = true)
	private String chronicDisease;

	@Column(name = "WASH_HANDS_BEFORE_MEALS", columnDefinition = "VARCHAR2|饭前洗手|2|", length = 2, nullable = true)
	private String washHandsBeforeMeals;

	@Column(name = "WASH_HANDS_OTHER", columnDefinition = "VARCHAR2|饭前洗手其他|100|", length = 100, nullable = true)
	private String washHandsOther;

	@Column(name = "INJECT_IMM_FLG", columnDefinition = "VARCHAR2|是否注射免疫球蛋白|2|", length = 2, nullable = true)
	private String injectImmFlg;

	@Column(name = "LASTTIME_VACCINATE_IMM", columnDefinition = "DATE|最后一次接种时间||", nullable = true)
	private Date lasttimeVaccinateImm;

	@Column(name = "PREVIOUS_HISTORY", columnDefinition = "VARCHAR2|既往史|2|", length = 2, nullable = true)
	private String previousHistory;

	@Column(name = "PREVIOUS_TYPE", columnDefinition = "VARCHAR2|既往史-单选|2|", length = 2, nullable = true)
	private String previousType;

	@Column(name = "PREVIOUS_OTHER", columnDefinition = "VARCHAR2|既往史-其他|100|", length = 100, nullable = true)
	private String previousOther;

    @Column(name = "BCG_HISTORY", columnDefinition = "VARCHAR2|卡介苗史|2|", length = 2, nullable = true)
    private String bcgHistory;

    @Column(name = "CONTACT_HISTORY", columnDefinition = "VARCHAR2|密切接触史|2|", length = 2, nullable = true)
    private String contactHistory;

    @Column(name = "DRUG_ALLERGY", columnDefinition = "VARCHAR2|药物过敏史|2|", length = 2, nullable = true)
    private String drugAllergy;

    @Column(name = "AGUE_NUM", columnDefinition = "VARCHAR2|疟疾次数|20|", length = 20, nullable = true)
    private String agueNum;

    @Column(name = "LAST_DT", columnDefinition = "DATE|最近一次患该病时间||", nullable = true)
    private Date lastDt;

    @Column(name = "ATTACK_ADDR", columnDefinition = "VARCHAR2|发病地点|100|", length = 100, nullable = true)
    private String attackAddr;

    @Column(name = "ATTACK_PROVINCE", columnDefinition = "VARCHAR2|发病地点－省|100|", length = 100, nullable = true)
    private String attackProvince;

    @Column(name = "ATTACK_CITY", columnDefinition = "VARCHAR2|发病地点－市|100|", length = 100, nullable = true)
    private String attackCity;

    @Column(name = "ATTACK_COUNTY", columnDefinition = "VARCHAR2|发病地点－县|100|", length = 100, nullable = true)
    private String attackCounty;

    @Column(name = "ATTACK_TOWN_SHIP", columnDefinition = "VARCHAR2|发病地点－乡|100|", length = 100, nullable = true)
    private String attackTownShip;

    @Column(name = "ATTACK_VILLAGE", columnDefinition = "VARCHAR2|发病地点－村|100|", length = 100, nullable = true)
    private String attackVillage;

    @Column(name = "AGUE_DRUG", columnDefinition = "VARCHAR2|疟疾药品|2|", length = 2, nullable = true)
    private String agueDrug;

    @Column(name = "AGUE_DRUG_OTHER", columnDefinition = "VARCHAR2|疟疾药品－其他|100|", length = 100, nullable = true)
    private String agueDrugOther;

    @Column(name = "LAST_TREAT_DT", columnDefinition = "DATE|最近一次治疗时间||", nullable = true)
    private Date lastTreatDt;

    @Column(name = "LAST_TREAT_ADDR", columnDefinition = "VARCHAR2|最后一次治疗地点|100|", length = 100, nullable = true)
    private String lastTreatAddr;

    @Column(name = "LAST_TREAT_PROVINCE", columnDefinition = "VARCHAR2|最后一次治疗地点-省|100|", length = 100, nullable = true)
    private String lastTreatProvince;

    @Column(name = "LAST_TREAT_CITY", columnDefinition = "VARCHAR2|最后一次治疗地点－市|100|", length = 100, nullable = true)
    private String lastTreatCity;

    @Column(name = "LAST_TREAT_COUNTY", columnDefinition = "VARCHAR2|最后一次治疗地点－县|100|", length = 100, nullable = true)
    private String lastTreatCounty;

    @Column(name = "LAST_TREAT_TOWN_SHIP", columnDefinition = "VARCHAR2|最后一次治疗地点－乡|100|", length = 100, nullable = true)
    private String lastTreatTownShip;

    @Column(name = "LAST_TREAT_VILLAGE", columnDefinition = "VARCHAR2|最后一次治疗地点－村|100|", length = 100, nullable = true)
    private String lastTreatVillage;

    @Column(name = "WHOLE_TREAT", columnDefinition = "VARCHAR2|全程足量正规治疗|2|", length = 2, nullable = true)
    private String wholeTreat;

    @Column(name = "REST", columnDefinition = "VARCHAR2|休根|2|", length = 2, nullable = true)
    private String rest;

    @Column(name = "BLOOD_FLUKES_DRUG", columnDefinition = "VARCHAR2|血吸虫药物|100|", length = 100, nullable = true)
    private String bloodFlukesDrug;

    @Column(name = "ATTACK_YEAR", columnDefinition = "NUMBER|发病年份|4|", length = 4, nullable = true)
    private Integer attackYear;

    @Column(name = "DIAGNOSIS_BASIS", columnDefinition = "VARCHAR2|诊断依据|2|", length = 2, nullable = true)
    private String diagnosisBasis;

    @Column(name = "TREAT_NUM", columnDefinition = "VARCHAR2|治疗次数|2|", length = 2, nullable = true)
    private String treatNum;

    @Column(name = "TREAT_START_DT", columnDefinition = "DATE|治疗开始时间||", nullable = true)
    private Date treatStartDt;

    @Column(name = "TREAT_END_DT", columnDefinition = "DATE|治疗结束时间||", nullable = true)
    private Date treatEndDt;

    @Column(name = "TREAT_UNIT", columnDefinition = "VARCHAR2|治疗单位|100|", length = 100, nullable = true)
    private String treatUnit;

    @Column(name = "IS_FINISHED", columnDefinition = "VARCHAR2|是否完成|2|", length = 2, nullable = true)
    private String isFinished;

    @Column(name = "SIDE_REACTION", columnDefinition = "VARCHAR2|有何副反应|100|", length = 100, nullable = true)
    private String sideReaction;

    @Column(name = "MICROFILARIA_CHECK", columnDefinition = "VARCHAR2|既往微丝蚴检查情况|2|", length = 2, nullable = true)
    private String microfilariaCheck;

    @Column(name = "MICROFILARIA_DT", columnDefinition = "DATE|微丝蚴出生日期||", nullable = true)
    private Date microfilariaDt;

    @Column(name = "MICROFILARIA_RESULT", columnDefinition = "VARCHAR2|微丝蚴检查结果|2|", length = 2, nullable = true)
    private String microfilariaResult;

    @Column(name = "DIETHYLCARBAMAZINE", columnDefinition = "VARCHAR2|乙胺嗪治疗|2|", length = 2, nullable = true)
    private String diethylcarbamazine;

    @Column(name = "HYERPYREXIA_SHIVER", columnDefinition = "VARCHAR2|高热寒战史|2|", length = 2, nullable = true)
    private String hyerpyrexiaShiver;
    
    @Column(name = "STOP_REASON	", columnDefinition = "VARCHAR2|既往停止治疗原因|2|", length = 2, nullable = true)
    private String stopReason;
    
    @Column(name = "STOP_REASON_OTHER	", columnDefinition = "VARCHAR2|既往停止治疗原因－其他|100|", length = 100, nullable = true)
    private String stopReasonOther;

    @Column(name = "IS_FOREIGN	", columnDefinition = "VARCHAR2|发病地点是否国外|2|", length = 2, nullable = true)
    private String isForeign;

    @Column(name = "FOREIGN_ADDR", columnDefinition = "VARCHAR2|国外发病地点|100|", length = 100, nullable = true)
    private String foreignAddr;

    @Column(name = "ETIOLOGY_NUM", columnDefinition = "VARCHAR2|病原学治疗史次数|20|", length = 20, nullable = true)
    private String etiologyNum;

    @Column(name = "LAST_ETIOLOGY_DT", columnDefinition = "DATE|病原学治疗史:末次治疗时间||", nullable = true)
    private Date lastEtiologyDt;

    @Column(name = "ALIMENTARY_CANAL", columnDefinition = "VARCHAR2|上消化道出血史|2|", length = 2, nullable = true)
    private String alimentaryCanal;

    @Column(name = "ALIMENTARY_CANAL_NUM", columnDefinition = "VARCHAR2|上消化道出血次数|20|", length = 20, nullable = true)
    private String alimentaryCanalNum;

    @Column(name = "LAST_ALIMENTARY_CANAL_DT", columnDefinition = "DATE|上消化道:末次出血时间||", nullable = true)
    private Date lastAlimentaryCanalDt;
 
    @Column(name = "ASCITES", columnDefinition = "VARCHAR2|腹水史|2|", length = 2, nullable = true)
    private String ascites;
    
    @Column(name = "LAST_ASCITES_DT", columnDefinition = "DATE|末次腹水时间||", nullable = true)
    private Date lastAscitesDt;

    @Column(name = "SPLEEN", columnDefinition = "VARCHAR2|脾切史|2|", length = 2, nullable = true)
    private String spleen;

    @Column(name = "SPLEEN_DT", columnDefinition = "DATE|切脾时间||", nullable = true)
    private Date spleenDt;   

    @Column(name = "DDIA", columnDefinition = "VARCHAR2|DDIA|100|", length = 100, nullable = true)
    private String ddia;

    @Column(name = "ETIOLOGY", columnDefinition = "VARCHAR2|病原学治疗史|2|", length = 2, nullable = true)
    private String etiology;

    @Column(name = "FIRST_DIAGNOSIS_DT", columnDefinition = "DATE|首次诊断时间||", nullable = true)
    private Date firstDiagnosisDt;

    @Column(name = "FIRST_DIAGNOSIS_REASON ", columnDefinition = "VARCHAR2|首次诊断依据|2|", length = 2, nullable = true)
    private String firstDiagnosisReason;

    @Column(name = "FIRST_WXDIAGNOSIS_DT", columnDefinition = "DATE|首次诊断晚血时间||", nullable = true)
    private Date firstWxdiagnosisDt;

    @Column(name = "FIRST_DIAGNOSIS_TYPE", columnDefinition = "VARCHAR2|首次诊断类型|2|", length = 2, nullable = true)
    private String firstDiagnosisType;

    @Column(name = "HEPATIC_COMA", columnDefinition = "VARCHAR2|肝昏迷史|2|", length = 2, nullable = true)
    private String hepaticComa;

    @Column(name = "HEPATIC_COMA_DT", columnDefinition = "DATE|肝昏迷时间||", nullable = true)
    private Date hepaticComaDt;

    @Column(name = "HEPATITIS_TYPE", columnDefinition = "VARCHAR2|肝炎类型|2|", length = 2, nullable = true)
    private String hepatitisType;

    @Column(name = "HYPERTENSION", columnDefinition = "VARCHAR2|高血压|2|", length = 2, nullable = true)
    private String hypertension;

    @Column(name = "CHD", columnDefinition = "VARCHAR2|冠心病|2|", length = 2, nullable = true)
    private String chd;
    
    @Column(name = "FIRST_DIAGNOSIS_REASON_OTHER", columnDefinition = "VARCHAR2|诊断依据其他|100|", length = 100, nullable = true)
    private String firstDiagnosisReasonOther;    
    
	

	@Column(name = "LUNGS", columnDefinition = "VARCHAR2|是否有慢性肺部疾病|50|", length = 50, nullable = true)
	private String lungs;
	@Column(name = "LUNGS_CK", columnDefinition = "VARCHAR2|慢性肺部疾病|50|", length = 50, nullable = true)
	private String lungsCk;
	@Column(name = "LUNGS_CK_OTHER", columnDefinition = "VARCHAR2|慢性肺部疾病-其他|50|", length = 50, nullable = true)
	private String lungsCkOther;
	@Column(name = "CARDIOVASCULAR", columnDefinition = "VARCHAR2|是否有心脑血管疾病|50|", length = 50, nullable = true)
	private String cardiovascular;
	@Column(name = "CARDIOVASCULAR_CK", columnDefinition = "VARCHAR2|心脑血管疾病|50|", length = 50, nullable = true)
	private String cardiovascularCk;
	@Column(name = "CARDIOVASCULAR_CK_OTHER", columnDefinition = "VARCHAR2|心脑血管疾病-其他|50|", length = 50, nullable = true)
	private String cardiovascularCkOther;
	@Column(name = "METABOLIZE", columnDefinition = "VARCHAR2|是否有代谢性疾病|50|", length = 50, nullable = true)
	private String metabolize;
	@Column(name = "METABOLIZE_CK", columnDefinition = "VARCHAR2|代谢性疾病|50|", length = 50, nullable = true)
	private String metabolizeCk;
	@Column(name = "METABOLIZE_CK_OTHER", columnDefinition = "VARCHAR2|代谢性疾病-其他|50|", length = 50, nullable = true)
	private String metabolizeCkOther;
	@Column(name = "NEPHROPATHY", columnDefinition = "VARCHAR2|是否有慢性肾脏疾病|50|", length = 50, nullable = true)
	private String nephropathy;
	@Column(name = "NEPHROPATHY_CK", columnDefinition = "VARCHAR2|慢性肾脏疾病|50|", length = 50, nullable = true)
	private String nephropathyCk;
	@Column(name = "NEPHROPATHY_CK_OTHER", columnDefinition = "VARCHAR2|慢性肾脏疾病-其他|50|", length = 50, nullable = true)
	private String nephropathyCkOther;
	@Column(name = "NEPHROPATHY_INSUFFICIENCY", columnDefinition = "VARCHAR2|肾功能不全|50|", length = 50, nullable = true)
	private String nephropathyInsufficiency;
	
	@Column(name = "LIVER", columnDefinition = "VARCHAR2|是否有慢性肝脏疾病|50|", length = 50, nullable = true)
	private String liver;
	@Column(name = "LIVER_CK", columnDefinition = "VARCHAR2|慢性肝脏疾病|50|", length = 50, nullable = true)
	private String liverCk;
	@Column(name = "LIVER_CK_OTHER", columnDefinition = "VARCHAR2|慢性肝脏疾病-其他|50|", length = 50, nullable = true)
	private String liverCkOther;
	@Column(name = "RHEUMATISM", columnDefinition = "VARCHAR2|是否有风湿免疫性疾病|50|", length = 50, nullable = true)
	private String rheumatism;
	@Column(name = "RHEUMATISM_CK", columnDefinition = "VARCHAR2|风湿免疫性疾病|50|", length = 50, nullable = true)
	private String rheumatismCk;
	@Column(name = "RHEUMATISM_CK_OTHER", columnDefinition = "VARCHAR2|风湿免疫性疾病-其他|50|", length = 50, nullable = true)
	private String rheumatismCkOther;
	@Column(name = "BLOOD", columnDefinition = "VARCHAR2|是否有血液系统疾病|50|", length = 50, nullable = true)
	private String blood;
	@Column(name = "BLOOD_CK", columnDefinition = "VARCHAR2|血液系统疾病|50|", length = 50, nullable = true)
	private String bloodCk;
	@Column(name = "BLOOD_CK_OTHER", columnDefinition = "VARCHAR2|血液系统疾病-其他|50|", length = 50, nullable = true)
	private String bloodCkOther;
	@Column(name = "cancer", columnDefinition = "VARCHAR2|是否有血液和/或器官的癌症/肿瘤|50|", length = 50, nullable = true)
	private String cancer;
	@Column(name = "CANCER_CK", columnDefinition = "VARCHAR2|血液和/或器官的癌症/肿瘤|50|", length = 50, nullable = true)
	private String cancerCk;
	@Column(name = "CANCER_CK_OTHER", columnDefinition = "VARCHAR2|血液和/或器官的癌症/肿瘤-其他|50|", length = 50, nullable = true)
	private String cancerCkOther;
	
	@Column(name = "HIV", columnDefinition = "VARCHAR2|发病时处于免疫抑制状态（HIV/AIDS、 糖皮质激素或免疫抑制药物治疗、或器官移植后、造血干细胞移植后）|50|", length = 50, nullable = true)
	private String hiv;
	@Column(name = "HIV_CK", columnDefinition = "VARCHAR2|HIV/AIDS|50|", length = 50, nullable = true)
	private String hivCk;
	@Column(name = "HIV_CK_OTHER", columnDefinition = "VARCHAR2|HIV/AIDS-其他|50|", length = 50, nullable = true)
	private String hivCkOther;
	@Column(name = "NERVE", columnDefinition = "VARCHAR2|是否有神经系统或神经肌肉功能障碍|50|", length = 50, nullable = true)
	private String nerve;
	@Column(name = "NERVE_CK", columnDefinition = "VARCHAR2|神经系统或神经肌肉功能障碍|50|", length = 50, nullable = true)
	private String nerveCk;
	@Column(name = "NERVE_CK_OTHER", columnDefinition = "VARCHAR2|神经系统或神经肌肉功能障碍-其他|50|", length = 50, nullable = true)
	private String nerveCkOther;
	@Column(name = "DISEASE_OTHER_FIRST", columnDefinition = "VARCHAR2|其他疾病1|100|", length = 100, nullable = true)
	private String diseaseOtherFirst;
	@Column(name = "DISEASE_OTHER_SECOND", columnDefinition = "VARCHAR2|其他疾病2|100|", length = 100, nullable = true)
	private String diseaseOtherSecond;
	@Column(name = "DISEASE_OTHER_THIRD", columnDefinition = "VARCHAR2|其他疾病3|100|", length = 100, nullable = true)
	private String diseaseOtherThird;
	
	@Column(name = "PREGNANT", columnDefinition = "VARCHAR2|是否怀孕|50|", length = 50, nullable = true)
	private String pregnant;
	@Column(name = "PREGNANT_WEEK", columnDefinition = "VARCHAR2|孕期周|50|", length = 50, nullable = true)
	private String pregnantWeek;
	@Column(name = "PREGNANT_NUM", columnDefinition = "VARCHAR2|孕期次|50|", length = 50, nullable = true)
	private String pregnantNum;
	@Column(name = "SEASON_INFLUENZA_VACCINE", columnDefinition = "VARCHAR2|发病前1年是否接种过季节性流感疫苗|50|", length = 50, nullable = true)
	private String seasonInfluenzaVaccine;
	@Column(name = "SMOKE", columnDefinition = "VARCHAR2|是否吸烟|50|", length = 50, nullable = true)
	private String smoke;
	@Column(name = "SMOKE_DAY", columnDefinition = "VARCHAR2|吸烟量：支/天|50|", length = 50, nullable = true)
	private String smokeDay;
	@Column(name = "SMOKE_YEAR", columnDefinition = "VARCHAR2|吸烟年|50|", length = 50, nullable = true)
	private String smokeYear;
	@Column(name = "SMOKE_SI", columnDefinition = "VARCHAR2|吸烟指数SI|50|", length = 50, nullable = true)
	private String smokeSi;
	@Column(name = "SMOKE_ALL_TIME", columnDefinition = "VARCHAR2|是否一直不吸烟|50|", length = 50, nullable = true)
	private String smokeAllTime;
	@Column(name = "SMOKE_QUIT", columnDefinition = "VARCHAR2|是否戒烟|50|", length = 50, nullable = true)
	private String smokeQuit;
	@Column(name = "SMOKE_QUIT_YEAR", columnDefinition = "VARCHAR2|已戒烟年|50|", length = 50, nullable = true)
	private String smokeQuitYear;
	@Column(name = "ALCOHOL", columnDefinition = "VARCHAR2|是否喝酒|50|", length = 50, nullable = true)
	private String alcohol;
	@Column(name = "ALCOHOL_DAY", columnDefinition = "VARCHAR2|酒量:两/天|50|", length = 50, nullable = true)
	private String alcoholDay;
	@Column(name = "ALCOHOL_YEAR", columnDefinition = "VARCHAR2|喝酒年|50|", length = 50, nullable = true)
	private String alcoholYear;
	@Column(name = "ALCOHOL_DEGREE", columnDefinition = "VARCHAR2|酒精度数|50|", length = 50, nullable = true)
	private String alcoholDegree;
	@Column(name = "ALCOHOL_ALL_TIME", columnDefinition = "VARCHAR2|是否一直不喝酒 |50|", length = 50, nullable = true)
	private String alcoholAllTime;
	@Column(name = "ALCOHOL_QUIT", columnDefinition = "VARCHAR2|是否戒酒 |50|", length = 50, nullable = true)
	private String alcoholQuit;
	@Column(name = "ALCOHOL_QUIT_YEAR", columnDefinition = "VARCHAR2|已戒酒年|50|", length = 50, nullable = true)
	private String alcoholQuitYear;
	
	@Column(name = "JE_VACCINATION_NUM", columnDefinition = "VARCHAR2|乙脑疫苗接种次数|20|", length = 20, nullable = true)
   	private String jeVaccinationNum;
	@Column(name = "JE_FIRST_VACCINATION_DATE", columnDefinition = "VARCHAR2|乙脑疫苗第一针日期||",  nullable = true)
   	private Date jeFirstVaccinationDate;
	@Column(name = "JE_SECOND_VACCINATION_DATE", columnDefinition = "VARCHAR2|乙脑疫苗第二针日期||",  nullable = true)
   	private Date jeSecondVaccinationDate;

//疟疾既往史
	@Column(name = "AGUE_TIME", columnDefinition = "DATE|疟疾治疗时间||", nullable = true)
	private Date agueTime;
	@Column(name = "RECENT_AGUE_TIME", columnDefinition = "DATE|最近一次患疟疾时间||", nullable = true)
	private Date recentAgueTime;
	@Column(name = "AGUE_PLACE", columnDefinition = "VARCHAR2|疟疾治疗地点|500|", length = 500, nullable = true)
	private String aguePlace;
	@Column(name = "AGUE_ENOUGH", columnDefinition = "VARCHAR2|疟疾治疗全程是否足量|2|", length = 2, nullable = true)
	private String agueEnough;
	@Column(name = "AGUE_CLEAN", columnDefinition = "VARCHAR2|疟疾是否进行清理治疗|2|", length = 20, nullable = true)
	private String agueClean;
	@Column(name = "AGUE_ROOT", columnDefinition = "VARCHAR2|疟疾是否进行修根治疗|2|", length = 20, nullable = true)
	private String agueRoot;
	@Column(name = "IS_OUT", columnDefinition = "VARCHAR2|疟疾发病地点是否在国外|2|", length = 20, nullable = true)
	private String isOut;
	@Column(name = "AGUE_DRUGS", columnDefinition = "VARCHAR2|疟疾当时抗疟治疗药品|2|", length = 20, nullable = true)
	private String agueDrugs;
	@Column(name = "OUT_AGUE_PLACE", columnDefinition = "VARCHAR2|疟疾国外发病地点|500|", length = 20, nullable = true)
	private String outAguePlace;
	@Column(name = "IN_AGUE_PLACE", columnDefinition = "VARCHAR2|疟疾国内发病地点|500|", length = 20, nullable = true)
	private String inAguePlace;

	//布病
	@Column(name = "BB_TIME", columnDefinition = "DATE|接种时间||", nullable = true)
	private Date bbTime;
	@Column(name = "BB_KIND", columnDefinition = "VARCHAR2|菌苗种类|100|", length = 100, nullable = true)
	private String bbKind;
	@Column(name = "BB_TREAT", columnDefinition = "VARCHAR2|接种途径|100|", length = 100, nullable = true)
	private String bbTreat;
	@Column(name = "BB_DATE", columnDefinition = "DATE|确诊时间||", nullable = true)
	private Date bbDate;
	@Column(name = "BB_OTHER", columnDefinition = "VARCHAR2|其他|100|", length = 100, nullable = true)
	private String bbOther;
	@Column(name = "BB_NUM", columnDefinition = "VARCHAR2|本疫点第几例|100|", length = 100, nullable = true)
	private String bbNum;

	public Date getBbTime() {
		return bbTime;
	}

	public void setBbTime(Date bbTime) {
		this.bbTime = bbTime;
	}

	public String getBbKind() {
		return bbKind;
	}

	public void setBbKind(String bbKind) {
		this.bbKind = bbKind;
	}

	public String getBbTreat() {
		return bbTreat;
	}

	public void setBbTreat(String bbTreat) {
		this.bbTreat = bbTreat;
	}

	public Date getBbDate() {
		return bbDate;
	}

	public void setBbDate(Date bbDate) {
		this.bbDate = bbDate;
	}

	public String getBbOther() {
		return bbOther;
	}

	public void setBbOther(String bbOther) {
		this.bbOther = bbOther;
	}

	public String getBbNum() {
		return bbNum;
	}

	public void setBbNum(String bbNum) {
		this.bbNum = bbNum;
	}

	public Date getAgueTime() {
		return agueTime;
	}

	public void setAgueTime(Date agueTime) {
		this.agueTime = agueTime;
	}

	public Date getRecentAgueTime() {
		return recentAgueTime;
	}

	public void setRecentAgueTime(Date recentAgueTime) {
		this.recentAgueTime = recentAgueTime;
	}

	public String getAguePlace() {
		return aguePlace;
	}

	public void setAguePlace(String aguePlace) {
		this.aguePlace = aguePlace;
	}

	public String getAgueEnough() {
		return agueEnough;
	}

	public void setAgueEnough(String agueEnough) {
		this.agueEnough = agueEnough;
	}

	public String getAgueClean() {
		return agueClean;
	}

	public void setAgueClean(String agueClean) {
		this.agueClean = agueClean;
	}

	public String getAgueRoot() {
		return agueRoot;
	}

	public void setAgueRoot(String agueRoot) {
		this.agueRoot = agueRoot;
	}

	public String getIsOut() {
		return isOut;
	}

	public void setIsOut(String isOut) {
		this.isOut = isOut;
	}

	public String getAgueDrugs() {
		return agueDrugs;
	}

	public void setAgueDrugs(String agueDrugs) {
		this.agueDrugs = agueDrugs;
	}

	public String getOutAguePlace() {
		return outAguePlace;
	}

	public void setOutAguePlace(String outAguePlace) {
		this.outAguePlace = outAguePlace;
	}

	public String getInAguePlace() {
		return inAguePlace;
	}

	public void setInAguePlace(String inAguePlace) {
		this.inAguePlace = inAguePlace;
	}

	public String getJeVaccinationNum() {
		return jeVaccinationNum;
	}

	public void setJeVaccinationNum(String jeVaccinationNum) {
		this.jeVaccinationNum = jeVaccinationNum;
	}

	public Date getJeFirstVaccinationDate() {
		return jeFirstVaccinationDate;
	}

	public void setJeFirstVaccinationDate(Date jeFirstVaccinationDate) {
		this.jeFirstVaccinationDate = jeFirstVaccinationDate;
	}

	public Date getJeSecondVaccinationDate() {
		return jeSecondVaccinationDate;
	}

	public void setJeSecondVaccinationDate(Date jeSecondVaccinationDate) {
		this.jeSecondVaccinationDate = jeSecondVaccinationDate;
	}

	public String getLungs() {
		return lungs;
	}

	public void setLungs(String lungs) {
		this.lungs = lungs;
	}

	public String getLungsCk() {
		return lungsCk;
	}

	public void setLungsCk(String lungsCk) {
		this.lungsCk = lungsCk;
	}

	public String getLungsCkOther() {
		return lungsCkOther;
	}

	public void setLungsCkOther(String lungsCkOther) {
		this.lungsCkOther = lungsCkOther;
	}

	public String getCardiovascular() {
		return cardiovascular;
	}

	public void setCardiovascular(String cardiovascular) {
		this.cardiovascular = cardiovascular;
	}

	public String getCardiovascularCk() {
		return cardiovascularCk;
	}

	public void setCardiovascularCk(String cardiovascularCk) {
		this.cardiovascularCk = cardiovascularCk;
	}

	public String getCardiovascularCkOther() {
		return cardiovascularCkOther;
	}

	public void setCardiovascularCkOther(String cardiovascularCkOther) {
		this.cardiovascularCkOther = cardiovascularCkOther;
	}

	public String getMetabolize() {
		return metabolize;
	}

	public void setMetabolize(String metabolize) {
		this.metabolize = metabolize;
	}

	public String getMetabolizeCk() {
		return metabolizeCk;
	}

	public void setMetabolizeCk(String metabolizeCk) {
		this.metabolizeCk = metabolizeCk;
	}

	public String getMetabolizeCkOther() {
		return metabolizeCkOther;
	}

	public void setMetabolizeCkOther(String metabolizeCkOther) {
		this.metabolizeCkOther = metabolizeCkOther;
	}

	public String getNephropathy() {
		return nephropathy;
	}

	public void setNephropathy(String nephropathy) {
		this.nephropathy = nephropathy;
	}

	public String getNephropathyCk() {
		return nephropathyCk;
	}

	public void setNephropathyCk(String nephropathyCk) {
		this.nephropathyCk = nephropathyCk;
	}

	public String getNephropathyCkOther() {
		return nephropathyCkOther;
	}

	public void setNephropathyCkOther(String nephropathyCkOther) {
		this.nephropathyCkOther = nephropathyCkOther;
	}

	public String getNephropathyInsufficiency() {
		return nephropathyInsufficiency;
	}

	public void setNephropathyInsufficiency(String nephropathyInsufficiency) {
		this.nephropathyInsufficiency = nephropathyInsufficiency;
	}

	public String getLiver() {
		return liver;
	}

	public void setLiver(String liver) {
		this.liver = liver;
	}

	public String getLiverCk() {
		return liverCk;
	}

	public void setLiverCk(String liverCk) {
		this.liverCk = liverCk;
	}

	public String getLiverCkOther() {
		return liverCkOther;
	}

	public void setLiverCkOther(String liverCkOther) {
		this.liverCkOther = liverCkOther;
	}

	public String getRheumatism() {
		return rheumatism;
	}

	public void setRheumatism(String rheumatism) {
		this.rheumatism = rheumatism;
	}

	public String getRheumatismCk() {
		return rheumatismCk;
	}

	public void setRheumatismCk(String rheumatismCk) {
		this.rheumatismCk = rheumatismCk;
	}

	public String getRheumatismCkOther() {
		return rheumatismCkOther;
	}

	public void setRheumatismCkOther(String rheumatismCkOther) {
		this.rheumatismCkOther = rheumatismCkOther;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public String getBloodCk() {
		return bloodCk;
	}

	public void setBloodCk(String bloodCk) {
		this.bloodCk = bloodCk;
	}

	public String getBloodCkOther() {
		return bloodCkOther;
	}

	public void setBloodCkOther(String bloodCkOther) {
		this.bloodCkOther = bloodCkOther;
	}

	public String getCancer() {
		return cancer;
	}

	public void setCancer(String cancer) {
		this.cancer = cancer;
	}

	public String getCancerCk() {
		return cancerCk;
	}

	public void setCancerCk(String cancerCk) {
		this.cancerCk = cancerCk;
	}

	public String getCancerCkOther() {
		return cancerCkOther;
	}

	public void setCancerCkOther(String cancerCkOther) {
		this.cancerCkOther = cancerCkOther;
	}

	public String getHiv() {
		return hiv;
	}

	public void setHiv(String hiv) {
		this.hiv = hiv;
	}

	public String getHivCk() {
		return hivCk;
	}

	public void setHivCk(String hivCk) {
		this.hivCk = hivCk;
	}

	public String getHivCkOther() {
		return hivCkOther;
	}

	public void setHivCkOther(String hivCkOther) {
		this.hivCkOther = hivCkOther;
	}

	public String getNerve() {
		return nerve;
	}

	public void setNerve(String nerve) {
		this.nerve = nerve;
	}

	public String getNerveCk() {
		return nerveCk;
	}

	public void setNerveCk(String nerveCk) {
		this.nerveCk = nerveCk;
	}

	public String getNerveCkOther() {
		return nerveCkOther;
	}

	public void setNerveCkOther(String nerveCkOther) {
		this.nerveCkOther = nerveCkOther;
	}

	public String getDiseaseOtherFirst() {
		return diseaseOtherFirst;
	}

	public void setDiseaseOtherFirst(String diseaseOtherFirst) {
		this.diseaseOtherFirst = diseaseOtherFirst;
	}

	public String getDiseaseOtherSecond() {
		return diseaseOtherSecond;
	}

	public void setDiseaseOtherSecond(String diseaseOtherSecond) {
		this.diseaseOtherSecond = diseaseOtherSecond;
	}

	public String getDiseaseOtherThird() {
		return diseaseOtherThird;
	}

	public void setDiseaseOtherThird(String diseaseOtherThird) {
		this.diseaseOtherThird = diseaseOtherThird;
	}

	public String getPregnant() {
		return pregnant;
	}

	public void setPregnant(String pregnant) {
		this.pregnant = pregnant;
	}

	public String getPregnantWeek() {
		return pregnantWeek;
	}

	public void setPregnantWeek(String pregnantWeek) {
		this.pregnantWeek = pregnantWeek;
	}

	public String getPregnantNum() {
		return pregnantNum;
	}

	public void setPregnantNum(String pregnantNum) {
		this.pregnantNum = pregnantNum;
	}

	public String getSeasonInfluenzaVaccine() {
		return seasonInfluenzaVaccine;
	}

	public void setSeasonInfluenzaVaccine(String seasonInfluenzaVaccine) {
		this.seasonInfluenzaVaccine = seasonInfluenzaVaccine;
	}

	public String getSmoke() {
		return smoke;
	}

	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}

	public String getSmokeDay() {
		return smokeDay;
	}

	public void setSmokeDay(String smokeDay) {
		this.smokeDay = smokeDay;
	}

	public String getSmokeYear() {
		return smokeYear;
	}

	public void setSmokeYear(String smokeYear) {
		this.smokeYear = smokeYear;
	}

	public String getSmokeSi() {
		return smokeSi;
	}

	public void setSmokeSi(String smokeSi) {
		this.smokeSi = smokeSi;
	}

	public String getSmokeAllTime() {
		return smokeAllTime;
	}

	public void setSmokeAllTime(String smokeAllTime) {
		this.smokeAllTime = smokeAllTime;
	}

	public String getSmokeQuit() {
		return smokeQuit;
	}

	public void setSmokeQuit(String smokeQuit) {
		this.smokeQuit = smokeQuit;
	}

	public String getSmokeQuitYear() {
		return smokeQuitYear;
	}

	public void setSmokeQuitYear(String smokeQuitYear) {
		this.smokeQuitYear = smokeQuitYear;
	}

	public String getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}

	public String getAlcoholDay() {
		return alcoholDay;
	}

	public void setAlcoholDay(String alcoholDay) {
		this.alcoholDay = alcoholDay;
	}

	public String getAlcoholYear() {
		return alcoholYear;
	}

	public void setAlcoholYear(String alcoholYear) {
		this.alcoholYear = alcoholYear;
	}

	public String getAlcoholDegree() {
		return alcoholDegree;
	}

	public void setAlcoholDegree(String alcoholDegree) {
		this.alcoholDegree = alcoholDegree;
	}

	public String getAlcoholAllTime() {
		return alcoholAllTime;
	}

	public void setAlcoholAllTime(String alcoholAllTime) {
		this.alcoholAllTime = alcoholAllTime;
	}

	public String getAlcoholQuit() {
		return alcoholQuit;
	}

	public void setAlcoholQuit(String alcoholQuit) {
		this.alcoholQuit = alcoholQuit;
	}

	public String getAlcoholQuitYear() {
		return alcoholQuitYear;
	}

	public void setAlcoholQuitYear(String alcoholQuitYear) {
		this.alcoholQuitYear = alcoholQuitYear;
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

	public String getVdHistory() {
		return this.vdHistory;
	}

	public void setVdHistory(String vdHistory) {
		this.vdHistory = vdHistory;
	}

	public String getVdName() {
		return this.vdName;
	}

	public void setVdName(String vdName) {
		this.vdName = vdName;
	}

	public Date getVdDate() {
		return this.vdDate;
	}

	public void setVdDate(Date vdDate) {
		this.vdDate = vdDate;
	}

	public String getSpouseVdHistory() {
		return this.spouseVdHistory;
	}

	public void setSpouseVdHistory(String spouseVdHistory) {
		this.spouseVdHistory = spouseVdHistory;
	}

	public String getSpouseVdName() {
		return this.spouseVdName;
	}

	public void setSpouseVdName(String spouseVdName) {
		this.spouseVdName = spouseVdName;
	}

	public Date getSpouseVdDate() {
		return this.spouseVdDate;
	}

	public void setSpouseVdDate(Date spouseVdDate) {
		this.spouseVdDate = spouseVdDate;
	}

	public String getParentsVdHistory() {
		return this.parentsVdHistory;
	}

	public void setParentsVdHistory(String parentsVdHistory) {
		this.parentsVdHistory = parentsVdHistory;
	}

	public String getCystOperation() {
		return this.cystOperation;
	}

	public void setCystOperation(String cystOperation) {
		this.cystOperation = cystOperation;
	}

	public String getMedicationHistory() {
		return this.medicationHistory;
	}

	public void setMedicationHistory(String medicationHistory) {
		this.medicationHistory = medicationHistory;
	}

	public String getPastHistory() {
		return this.pastHistory;
	}

	public void setPastHistory(String pastHistory) {
		this.pastHistory = pastHistory;
	}

	public String getHealthFlg() {
		return this.healthFlg;
	}

	public void setHealthFlg(String healthFlg) {
		this.healthFlg = healthFlg;
	}

	public String getDengueJeFlg() {
		return this.dengueJeFlg;
	}

	public void setDengueJeFlg(String dengueJeFlg) {
		this.dengueJeFlg = dengueJeFlg;
	}

	public String getJeVaccineFlg() {
		return this.jeVaccineFlg;
	}

	public void setJeVaccineFlg(String jeVaccineFlg) {
		this.jeVaccineFlg = jeVaccineFlg;
	}

	public String getPastEhfFlg() {
		return this.pastEhfFlg;
	}

	public void setPastEhfFlg(String pastEhfFlg) {
		this.pastEhfFlg = pastEhfFlg;
	}

	public String getEhfDiagnoseUnit() {
		return this.ehfDiagnoseUnit;
	}

	public void setEhfDiagnoseUnit(String ehfDiagnoseUnit) {
		this.ehfDiagnoseUnit = ehfDiagnoseUnit;
	}

	public Date getEhfDiagnoseTime() {
		return this.ehfDiagnoseTime;
	}

	public void setEhfDiagnoseTime(Date ehfDiagnoseTime) {
		this.ehfDiagnoseTime = ehfDiagnoseTime;
	}

	public String getRatproofFlg() {
		return this.ratproofFlg;
	}

	public void setRatproofFlg(String ratproofFlg) {
		this.ratproofFlg = ratproofFlg;
	}

	public String getEhfVaccineFlg() {
		return this.ehfVaccineFlg;
	}

	public void setEhfVaccineFlg(String ehfVaccineFlg) {
		this.ehfVaccineFlg = ehfVaccineFlg;
	}

	public Date getLastTimeVaccinate() {
		return this.lastTimeVaccinate;
	}

	public void setLastTimeVaccinate(Date lastTimeVaccinate) {
		this.lastTimeVaccinate = lastTimeVaccinate;
	}

	public String getFamilyEhfSymptoms() {
		return this.familyEhfSymptoms;
	}

	public void setFamilyEhfSymptoms(String familyEhfSymptoms) {
		this.familyEhfSymptoms = familyEhfSymptoms;
	}

	public Date getFamilyEhfTime() {
		return this.familyEhfTime;
	}

	public void setFamilyEhfTime(Date familyEhfTime) {
		this.familyEhfTime = familyEhfTime;
	}

	public String getRatsFlg() {
		return this.ratsFlg;
	}

	public void setRatsFlg(String ratsFlg) {
		this.ratsFlg = ratsFlg;
	}

	public String getVariaFlg() {
		return this.variaFlg;
	}

	public void setVariaFlg(String variaFlg) {
		this.variaFlg = variaFlg;
	}

	public String getAsthmaFlg() {
		return this.asthmaFlg;
	}

	public void setAsthmaFlg(String asthmaFlg) {
		this.asthmaFlg = asthmaFlg;
	}

	public String getCpdFlg() {
		return this.cpdFlg;
	}

	public void setCpdFlg(String cpdFlg) {
		this.cpdFlg = cpdFlg;
	}

	public String getCldFlg() {
		return this.cldFlg;
	}

	public void setCldFlg(String cldFlg) {
		this.cldFlg = cldFlg;
	}

	public String getDmFlg() {
		return this.dmFlg;
	}

	public void setDmFlg(String dmFlg) {
		this.dmFlg = dmFlg;
	}

	public String getTuberculosisFlg() {
		return this.tuberculosisFlg;
	}

	public void setTuberculosisFlg(String tuberculosisFlg) {
		this.tuberculosisFlg = tuberculosisFlg;
	}

	public String getCrdFlg() {
		return this.crdFlg;
	}

	public void setCrdFlg(String crdFlg) {
		this.crdFlg = crdFlg;
	}

	public String getHeartDiseaseFlg() {
		return this.heartDiseaseFlg;
	}

	public void setHeartDiseaseFlg(String heartDiseaseFlg) {
		this.heartDiseaseFlg = heartDiseaseFlg;
	}

	public String getNervousDiseasesFlg() {
		return this.nervousDiseasesFlg;
	}

	public void setNervousDiseasesFlg(String nervousDiseasesFlg) {
		this.nervousDiseasesFlg = nervousDiseasesFlg;
	}

	public String getCancerFlg() {
		return this.cancerFlg;
	}

	public void setCancerFlg(String cancerFlg) {
		this.cancerFlg = cancerFlg;
	}

	public String getHivAidsFlg() {
		return this.hivAidsFlg;
	}

	public void setHivAidsFlg(String hivAidsFlg) {
		this.hivAidsFlg = hivAidsFlg;
	}

	public String getImmuneDeficiencyFlg() {
		return this.immuneDeficiencyFlg;
	}

	public void setImmuneDeficiencyFlg(String immuneDeficiencyFlg) {
		this.immuneDeficiencyFlg = immuneDeficiencyFlg;
	}

	public String getPregnancyFlg() {
		return this.pregnancyFlg;
	}

	public void setPregnancyFlg(String pregnancyFlg) {
		this.pregnancyFlg = pregnancyFlg;
	}

	public String getGestation() {
		return this.gestation;
	}

	public void setGestation(String gestation) {
		this.gestation = gestation;
	}

	public String getSmokeFlg() {
		return this.smokeFlg;
	}

	public void setSmokeFlg(String smokeFlg) {
		this.smokeFlg = smokeFlg;
	}

	public String getSmokeDayCount() {
		return this.smokeDayCount;
	}

	public void setSmokeDayCount(String smokeDayCount) {
		this.smokeDayCount = smokeDayCount;
	}

	public String getInfluenzaVaccine() {
		return this.influenzaVaccine;
	}

	public void setInfluenzaVaccine(String influenzaVaccine) {
		this.influenzaVaccine = influenzaVaccine;
	}

	public Date getInfluenzaVaccineDate() {
		return this.influenzaVaccineDate;
	}

	public void setInfluenzaVaccineDate(Date influenzaVaccineDate) {
		this.influenzaVaccineDate = influenzaVaccineDate;
	}

	public String getPnuImuneFlg() {
		return this.pnuImuneFlg;
	}

	public void setPnuImuneFlg(String pnuImuneFlg) {
		this.pnuImuneFlg = pnuImuneFlg;
	}

	public Date getPnuImuneDate() {
		return this.pnuImuneDate;
	}

	public void setPnuImuneDate(Date pnuImuneDate) {
		this.pnuImuneDate = pnuImuneDate;
	}

	public String getBasicDiseaseFlg() {
		return this.basicDiseaseFlg;
	}

	public void setBasicDiseaseFlg(String basicDiseaseFlg) {
		this.basicDiseaseFlg = basicDiseaseFlg;
	}

	public String getPastHistorySars() {
		return this.pastHistorySars;
	}

	public void setPastHistorySars(String pastHistorySars) {
		this.pastHistorySars = pastHistorySars;
	}

	public String getChronicDisease() {
		return this.chronicDisease;
	}

	public void setChronicDisease(String chronicDisease) {
		this.chronicDisease = chronicDisease;
	}

	public String getWashHandsBeforeMeals() {
		return this.washHandsBeforeMeals;
	}

	public void setWashHandsBeforeMeals(String washHandsBeforeMeals) {
		this.washHandsBeforeMeals = washHandsBeforeMeals;
	}

	public String getWashHandsOther() {
		return this.washHandsOther;
	}

	public void setWashHandsOther(String washHandsOther) {
		this.washHandsOther = washHandsOther;
	}

	public String getInjectImmFlg() {
		return this.injectImmFlg;
	}

	public void setInjectImmFlg(String injectImmFlg) {
		this.injectImmFlg = injectImmFlg;
	}

	public Date getLasttimeVaccinateImm() {
		return this.lasttimeVaccinateImm;
	}

	public void setLasttimeVaccinateImm(Date lasttimeVaccinateImm) {
		this.lasttimeVaccinateImm = lasttimeVaccinateImm;
	}

	public String getPreviousHistory() {
		return this.previousHistory;
	}

	public void setPreviousHistory(String previousHistory) {
		this.previousHistory = previousHistory;
	}

	public String getPreviousType() {
		return this.previousType;
	}

	public void setPreviousType(String previousType) {
		this.previousType = previousType;
	}

	public String getPreviousOther() {
		return this.previousOther;
	}

	public void setPreviousOther(String previousOther) {
		this.previousOther = previousOther;
	}

    public String getBcgHistory() {
        return this.bcgHistory;
    }

    public void setBcgHistory(String bcgHistory) {
        this.bcgHistory = bcgHistory;
    }

    public String getContactHistory() {
        return this.contactHistory;
    }

    public void setContactHistory(String contactHistory) {
        this.contactHistory = contactHistory;
    }

    public String getDrugAllergy() {
        return this.drugAllergy;
    }

    public void setDrugAllergy(String drugAllergy) {
        this.drugAllergy = drugAllergy;
    }

    public String getAgueNum() {
        return this.agueNum;
    }

    public void setAgueNum(String agueNum) {
        this.agueNum = agueNum;
    }

    public Date getLastDt() {
        return this.lastDt;
    }

    public void setLastDt(Date lastDt) {
        this.lastDt = lastDt;
    }

    public String getAttackAddr() {
        return this.attackAddr;
    }

    public void setAttackAddr(String attackAddr) {
        this.attackAddr = attackAddr;
    }

    public String getAttackProvince() {
        return this.attackProvince;
    }

    public void setAttackProvince(String attackProvince) {
        this.attackProvince = attackProvince;
    }

    public String getAttackCity() {
        return this.attackCity;
    }

    public void setAttackCity(String attackCity) {
        this.attackCity = attackCity;
    }

    public String getAttackCounty() {
        return this.attackCounty;
    }

    public void setAttackCounty(String attackCounty) {
        this.attackCounty = attackCounty;
    }

    public String getAttackTownShip() {
        return this.attackTownShip;
    }

    public void setAttackTownShip(String attackTownShip) {
        this.attackTownShip = attackTownShip;
    }

    public String getAttackVillage() {
        return this.attackVillage;
    }

    public void setAttackVillage(String attackVillage) {
        this.attackVillage = attackVillage;
    }

    public String getAgueDrug() {
        return this.agueDrug;
    }

    public void setAgueDrug(String agueDrug) {
        this.agueDrug = agueDrug;
    }

    public String getAgueDrugOther() {
        return this.agueDrugOther;
    }

    public void setAgueDrugOther(String agueDrugOther) {
        this.agueDrugOther = agueDrugOther;
    }

    public Date getLastTreatDt() {
        return this.lastTreatDt;
    }

    public void setLastTreatDt(Date lastTreatDt) {
        this.lastTreatDt = lastTreatDt;
    }

    public String getLastTreatAddr() {
        return this.lastTreatAddr;
    }

    public void setLastTreatAddr(String lastTreatAddr) {
        this.lastTreatAddr = lastTreatAddr;
    }

    public String getLastTreatProvince() {
        return this.lastTreatProvince;
    }

    public void setLastTreatProvince(String lastTreatProvince) {
        this.lastTreatProvince = lastTreatProvince;
    }

    public String getLastTreatCity() {
        return this.lastTreatCity;
    }

    public void setLastTreatCity(String lastTreatCity) {
        this.lastTreatCity = lastTreatCity;
    }

    public String getLastTreatCounty() {
        return this.lastTreatCounty;
    }

    public void setLastTreatCounty(String lastTreatCounty) {
        this.lastTreatCounty = lastTreatCounty;
    }

    public String getLastTreatTownShip() {
        return this.lastTreatTownShip;
    }

    public void setLastTreatTownShip(String lastTreatTownShip) {
        this.lastTreatTownShip = lastTreatTownShip;
    }

    public String getLastTreatVillage() {
        return this.lastTreatVillage;
    }

    public void setLastTreatVillage(String lastTreatVillage) {
        this.lastTreatVillage = lastTreatVillage;
    }

    public String getWholeTreat() {
        return this.wholeTreat;
    }

    public void setWholeTreat(String wholeTreat) {
        this.wholeTreat = wholeTreat;
    }

    public String getRest() {
        return this.rest;
    }

    public void setRest(String rest) {
        this.rest = rest;
    }

    public String getBloodFlukesDrug() {
        return this.bloodFlukesDrug;
    }

    public void setBloodFlukesDrug(String bloodFlukesDrug) {
        this.bloodFlukesDrug = bloodFlukesDrug;
    }

    public Integer getAttackYear() {
        return this.attackYear;
    }

    public void setAttackYear(Integer attackYear) {
        this.attackYear = attackYear;
    }

    public String getDiagnosisBasis() {
        return this.diagnosisBasis;
    }

    public void setDiagnosisBasis(String diagnosisBasis) {
        this.diagnosisBasis = diagnosisBasis;
    }

    public String getTreatNum() {
        return this.treatNum;
    }

    public void setTreatNum(String treatNum) {
        this.treatNum = treatNum;
    }

    public Date getTreatStartDt() {
        return this.treatStartDt;
    }

    public void setTreatStartDt(Date treatStartDt) {
        this.treatStartDt = treatStartDt;
    }

    public Date getTreatEndDt() {
        return this.treatEndDt;
    }

    public void setTreatEndDt(Date treatEndDt) {
        this.treatEndDt = treatEndDt;
    }

    public String getTreatUnit() {
        return this.treatUnit;
    }

    public void setTreatUnit(String treatUnit) {
        this.treatUnit = treatUnit;
    }

    public String getIsFinished() {
        return this.isFinished;
    }

    public void setIsFinished(String isFinished) {
        this.isFinished = isFinished;
    }

    public String getSideReaction() {
        return this.sideReaction;
    }

    public void setSideReaction(String sideReaction) {
        this.sideReaction = sideReaction;
    }

    public String getMicrofilariaResult() {
        return microfilariaResult;
    }

    public void setMicrofilariaResult(String microfilariaResult) {
        this.microfilariaResult = microfilariaResult;
    }

    public Date getMicrofilariaDt() {
        return microfilariaDt;
    }

    public void setMicrofilariaDt(Date microfilariaDt) {
        this.microfilariaDt = microfilariaDt;
    }

    public String getMicrofilariaCheck() {
        return microfilariaCheck;
    }

    public void setMicrofilariaCheck(String microfilariaCheck) {
        this.microfilariaCheck = microfilariaCheck;
    }

    public String getDiethylcarbamazine() {
        return this.diethylcarbamazine;
    }

    public void setDiethylcarbamazine(String diethylcarbamazine) {
        this.diethylcarbamazine = diethylcarbamazine;
    }

    public String getHyerpyrexiaShiver() {
        return hyerpyrexiaShiver;
    }

    public void setHyerpyrexiaShiver(String hyerpyrexiaShiver) {
        this.hyerpyrexiaShiver = hyerpyrexiaShiver;
    }

    public String getStopReason() {
        return this.stopReason;
    }

    public void setStopReason(String stopReason) {
        this.stopReason = stopReason;
    }

	public String getStopReasonOther() {
		return stopReasonOther;
	}

	public void setStopReasonOther(String stopReasonOther) {
		this.stopReasonOther = stopReasonOther;
	}

    public String getIsForeign() {
        return this.isForeign;
    }

    public void setIsForeign(String isForeign) {
        this.isForeign = isForeign;
    }

    public String getForeignAddr() {
        return foreignAddr;
    }

    public void setForeignAddr(String foreignAddr) {
        this.foreignAddr = foreignAddr;
    }

	/**
	 * @return the etiologyNum
	 */
	public String getEtiologyNum() {
		return etiologyNum;
	}

	/**
	 * @param etiologyNum the etiologyNum to set
	 */
	public void setEtiologyNum(String etiologyNum) {
		this.etiologyNum = etiologyNum;
	}

	/**
	 * @return the lastEtiologyDt
	 */
	public Date getLastEtiologyDt() {
		return lastEtiologyDt;
	}

	/**
	 * @param lastEtiologyDt the lastEtiologyDt to set
	 */
	public void setLastEtiologyDt(Date lastEtiologyDt) {
		this.lastEtiologyDt = lastEtiologyDt;
	}

	/**
	 * @return the alimentaryCanal
	 */
	public String getAlimentaryCanal() {
		return alimentaryCanal;
	}

	/**
	 * @param alimentaryCanal the alimentaryCanal to set
	 */
	public void setAlimentaryCanal(String alimentaryCanal) {
		this.alimentaryCanal = alimentaryCanal;
	}

	/**
	 * @return the alimentaryCanalNum
	 */
	public String getAlimentaryCanalNum() {
		return alimentaryCanalNum;
	}

	/**
	 * @param alimentaryCanalNum the alimentaryCanalNum to set
	 */
	public void setAlimentaryCanalNum(String alimentaryCanalNum) {
		this.alimentaryCanalNum = alimentaryCanalNum;
	}

	/**
	 * @return the lastAlimentaryCanalDt
	 */
	public Date getLastAlimentaryCanalDt() {
		return lastAlimentaryCanalDt;
	}

	/**
	 * @param lastAlimentaryCanalDt the lastAlimentaryCanalDt to set
	 */
	public void setLastAlimentaryCanalDt(Date lastAlimentaryCanalDt) {
		this.lastAlimentaryCanalDt = lastAlimentaryCanalDt;
	}

	/**
	 * @return the ascites
	 */
	public String getAscites() {
		return ascites;
	}

	/**
	 * @param ascites the ascites to set
	 */
	public void setAscites(String ascites) {
		this.ascites = ascites;
	}

	/**
	 * @return the lastAscitesDt
	 */
	public Date getLastAscitesDt() {
		return lastAscitesDt;
	}

	/**
	 * @param lastAscitesDt the lastAscitesDt to set
	 */
	public void setLastAscitesDt(Date lastAscitesDt) {
		this.lastAscitesDt = lastAscitesDt;
	}

	/**
	 * @return the spleen
	 */
	public String getSpleen() {
		return spleen;
	}

	/**
	 * @param spleen the spleen to set
	 */
	public void setSpleen(String spleen) {
		this.spleen = spleen;
	}

	/**
	 * @return the spleenDt
	 */
	public Date getSpleenDt() {
		return spleenDt;
	}

	/**
	 * @param spleenDt the spleenDt to set
	 */
	public void setSpleenDt(Date spleenDt) {
		this.spleenDt = spleenDt;
	}

	/**
	 * @return the ddia
	 */
	public String getDdia() {
		return ddia;
	}

	/**
	 * @param ddia the ddia to set
	 */
	public void setDdia(String ddia) {
		this.ddia = ddia;
	}

    public String getEtiology() {
        return etiology;
    }

    public void setEtiology(String etiology) {
        this.etiology = etiology;
    }

    public Date getFirstDiagnosisDt() {
        return firstDiagnosisDt;
    }

    public void setFirstDiagnosisDt(Date firstDiagnosisDt) {
        this.firstDiagnosisDt = firstDiagnosisDt;
    }

    public String getFirstDiagnosisReason() {
        return firstDiagnosisReason;
    }

    public void setFirstDiagnosisReason(String firstDiagnosisReason) {
        this.firstDiagnosisReason = firstDiagnosisReason;
    }

    public Date getFirstWxdiagnosisDt() {
        return firstWxdiagnosisDt;
    }

    public void setFirstWxdiagnosisDt(Date firstWxdiagnosisDt) {
        this.firstWxdiagnosisDt = firstWxdiagnosisDt;
    }

    public String getFirstDiagnosisType() {
        return firstDiagnosisType;
    }

    public void setFirstDiagnosisType(String firstDiagnosisType) {
        this.firstDiagnosisType = firstDiagnosisType;
    }

    public String getHepaticComa() {
        return hepaticComa;
    }

    public void setHepaticComa(String hepaticComa) {
        this.hepaticComa = hepaticComa;
    }

    public Date getHepaticComaDt() {
        return hepaticComaDt;
    }

    public void setHepaticComaDt(Date hepaticComaDt) {
        this.hepaticComaDt = hepaticComaDt;
    }

    public String getHepatitisType() {
        return hepatitisType;
    }

    public void setHepatitisType(String hepatitisType) {
        this.hepatitisType = hepatitisType;
    }

    public String getHypertension() {
        return hypertension;
    }

    public void setHypertension(String hypertension) {
        this.hypertension = hypertension;
    }

    public String getChd() {
        return chd;
    }

    public void setChd(String chd) {
        this.chd = chd;
    }

	public String getFirstDiagnosisReasonOther() {
		return firstDiagnosisReasonOther;
	}

	public void setFirstDiagnosisReasonOther(String firstDiagnosisReasonOther) {
		this.firstDiagnosisReasonOther = firstDiagnosisReasonOther;
	}
}