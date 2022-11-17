package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 实验室检查
 */
@Entity
@Table(name = "IDM_LAB_EXAMINE")
public class LabExamine implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编码|11|", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "DARK_FIELD_MICROSCOPE", columnDefinition = "VARCHAR2|暗视野显微镜检查|20|", length = 20, nullable = true)
	private String darkFieldMicroscope;

	@Column(name = "RPR_USR_VDR", columnDefinition = "VARCHAR2|RPR/USR/VDRL检查|20|", length = 20, nullable = true)
	private String rprUsrVdr;

	@Column(name = "TPPA_TPHA", columnDefinition = "VARCHAR2|TPPA（TPHA）检查|20|", length = 20, nullable = true)
	private String tppaTpha;

	@Column(name = "VIRAL_ISOLATION", columnDefinition = "VARCHAR2|病毒分离方法|200|", length = 200, nullable = true)
	private String viralIsolation;

	@Column(name = "IDENTIFICATION_VIRUS", columnDefinition = "VARCHAR2|病毒鉴定|20|", length = 20, nullable = true)
	private String identificationVirus;

	@Column(name = "IDENTIFICATION_DATE", columnDefinition = "DATE|病毒鉴定时间||", nullable = true)
	private Date identificationDate;

	@Column(name = "PAIRED_SERA_TYPE", columnDefinition = "VARCHAR2|双份血清诊断型别|20|", length = 20, nullable = true)
	private String pairedSeraType;

	@Column(name = "PAIRED_SERA_DATE", columnDefinition = "DATE|双份血清诊断型别诊断时间||", nullable = true)
	private Date pairedSeraDate;

	@Column(name = "ANTIBODY_ASSAY_ANTIGEN", columnDefinition = "VARCHAR2|检测抗体所用抗原|100|", length = 100, nullable = true)
	private String antibodyAssayAntigen;

	@Column(name = "OTHER_DIAGNOSED", columnDefinition = "VARCHAR2|其他诊断方法和结果|100|", length = 100, nullable = true)
	private String otherDiagnosed;

	@Column(name = "OTHER_DIAGNOSED_DATE", columnDefinition = "DATE|其他诊断方法和结果诊断时间||", nullable = true)
	private Date otherDiagnosedDate;

	@Column(name = "ROUTINE_BLOOD", columnDefinition = "VARCHAR2|是否血常规|20|", length = 20, nullable = true)
	private String routineBlood;

	@Column(name = "ROUTINE_BLOOD_DATE", columnDefinition = "DATE|采样时间||", nullable = true)
	private Date routineBloodDate;

	@Column(name = "SEROLOGICALLY", columnDefinition = "VARCHAR2|血清学检测结果|20|", length = 20, nullable = true)
	private String serologically;

	@Column(name = "SEROLOGICALLY_DATE", columnDefinition = "DATE|采样时间||", nullable = true)
	private Date serologicallyDate;

	@Column(name = "SEROLOGICALLY_METHOD", columnDefinition = "VARCHAR2|检测方法|100|", length = 100, nullable = true)
	private String serologicallyMethod;

	@Column(name = "SERUM_SPECIMEN_DATE", columnDefinition = "DATE|标本血清采集日期||", nullable = true)
	private Date serumSpecimenDate;

	@Column(name = "MEASLES_IGM", columnDefinition = "VARCHAR2|麻疹IgM抗体|20|", length = 20, nullable = true)
	private String measlesIgm;

	@Column(name = "RU_IGM", columnDefinition = "VARCHAR2|风疹IgM抗体|20|", length = 20, nullable = true)
	private String ruIgm;

	@Column(name = "ETIOLOGY_SPECIMENS", columnDefinition = "VARCHAR2|是否采集病原学检测标本|20|", length = 20, nullable = true)
	private String etiologySpecimens;

	@Column(name = "NASOPHARYNGEAL_SWAB", columnDefinition = "VARCHAR2|鼻咽拭子|20|", length = 20, nullable = true)
	private String nasopharyngealSwab;

	@Column(name = "NASOPHARYNGEAL_SWAB_DATE", columnDefinition = "DATE|鼻咽拭子采集日期||", nullable = true)
	private Date nasopharyngealSwabDate;

	@Column(name = "URINE_ALIQUOT", columnDefinition = "VARCHAR2|尿标本|20|", length = 20, nullable = true)
	private String urineAliquot;

	@Column(name = "URINE_ALIQUOT_DATE", columnDefinition = "DATE|尿标本采集日期||", nullable = true)
	private Date urineAliquotDate;

	@Column(name = "OTHER_SPECIMEN", columnDefinition = "VARCHAR2|其他标本|100|", length = 100, nullable = true)
	private String otherSpecimen;

	@Column(name = "OTHER_SPECIMEN_DATE", columnDefinition = "DATE|其他标本采集日期||", nullable = true)
	private Date otherSpecimenDate;

	@Column(name = "MORBILLIVIRUS_RESULT", columnDefinition = "VARCHAR2|麻疹病毒鉴定结果|20|", length = 20, nullable = true)
	private String morbillivirusResult;

	@Column(name = "MORBILLIVIRUS_GENOTYPE", columnDefinition = "VARCHAR2|麻疹病毒鉴定结果基因型|100|", length = 100, nullable = true)
	private String morbillivirusGenotype;

	@Column(name = "RUBELLAVIRUS_RESULT", columnDefinition = "VARCHAR2|风疹病毒鉴定结果|20|", length = 20, nullable = true)
	private String rubellavirusResult;

	@Column(name = "RUBELLAVIRUS_GENOTYPE", columnDefinition = "VARCHAR2|风疹病毒鉴定结果基因型|100|", length = 100, nullable = true)
	private String rubellavirusGenotype;

	@Column(name = "SEROLOGY_DATE", columnDefinition = "DATE|血清学送检日期||", nullable = true)
	private Date serologyDate;

	@Column(name = "OX_2", columnDefinition = "VARCHAR2|ox_2|100|", length = 100, nullable = true)
	private String ox_2;

	@Column(name = "OX_1_9", columnDefinition = "VARCHAR2|ox_1_9|100|", length = 100, nullable = true)
	private String ox_1_9;

	@Column(name = "OXK", columnDefinition = "VARCHAR2|OXK|100|", length = 100, nullable = true)
	private String oxk;

	@Column(name = "BLOODTESTS_DATE", columnDefinition = "DATE|血常规送检日期||", nullable = true)
	private Date bloodtestsDate;

	@Column(name = "LEUKOCYTE_COUNT", columnDefinition = "VARCHAR2|白细胞计数|20|", scale = 20, precision = 1, nullable = true)
	private String leukocyteCount;

	@Column(name = "NEUTROPHILCELL", columnDefinition = "VARCHAR2|中性|20|", scale = 20, precision = 1, nullable = true)
	private String neutrophilcell;

	@Column(name = "LYMPHOCYTE", columnDefinition = "VARCHAR2|淋巴细胞|20|", scale = 20, precision = 1, nullable = true)
	private String lymphocyte;

	@Column(name = "EOSINOPHILS", columnDefinition = "VARCHAR2|嗜酸性|20|", scale = 20, precision = 1, nullable = true)
	private String eosinophils;

	@Column(name = "RBC_COUNT", columnDefinition = "VARCHAR2|红细胞总数|20|", scale = 20, precision = 1, nullable = true)
	private String rbcCount;

	@Column(name = "HEMOCHROME", columnDefinition = "VARCHAR2|血色素|20|", scale = 20, precision = 1, nullable = true)
	private String hemochrome;

	@Column(name = "BASOPHIL", columnDefinition = "VARCHAR2|血百分_嗜碱|20|", scale = 20, precision = 1, nullable = true)
	private String basophil;

	@Column(name = "ALBUMIN", columnDefinition = "VARCHAR2|白蛋白/球蛋白|20|", length = 20, nullable = true)
	private String albumin;

	@Column(name = "GLOBULIN_PRECIPITATION_TEST", columnDefinition = "VARCHAR2|球蛋白沉淀试验|20|", length = 20, nullable = true)
	private String globulinPrecipitationTest;

	@Column(name = "FORMOLGET_TEST", columnDefinition = "VARCHAR2|醛凝试验|20|", length = 20, nullable = true)
	private String formolgetTest;

	@Column(name = "IHA", columnDefinition = "VARCHAR2|间接血凝试验|100|", length = 100, nullable = true)
	private String iha;

	@Column(name = "IFAT", columnDefinition = "VARCHAR2|IFAT|100|", length = 100, nullable = true)
	private String ifat;

	@Column(name = "ELISA", columnDefinition = "VARCHAR2|ELISA|100|", length = 100, nullable = true)
	private String elisa;

	@Column(name = "BONEMARROW_ASPIRATION", columnDefinition = "VARCHAR2|骨髓穿刺|20|", length = 20, nullable = true)
	private String bonemarrowAspiration;

	@Column(name = "LYMPHNODE_PUNCTURE", columnDefinition = "VARCHAR2|淋巴结穿刺|20|", length = 20, nullable = true)
	private String lymphnodePuncture;

	@Column(name = "SPLENIC_PUNCTURE", columnDefinition = "VARCHAR2|脾穿刺|20|", length = 20, nullable = true)
	private String splenicPuncture;

	@Column(name = "LIVER_PUNCTURE", columnDefinition = "VARCHAR2|肝穿刺|20|", length = 20, nullable = true)
	private String liverPuncture;

	@Column(name = "CULTURE_POSITIVE", columnDefinition = "VARCHAR2|培养阳性|20|", length = 20, nullable = true)
	private String culturePositive;

	@Column(name = "OTHER_CULTURE_POSITIVE", columnDefinition = "VARCHAR2|培养阳性_其他|100|", length = 100, nullable = true)
	private String otherCulturePositive;

	@Column(name = "DRUG", columnDefinition = "VARCHAR2|治疗药物|20|", length = 20, nullable = true)
	private String drug;

	@Column(name = "LEUKOCYTE_FLG", columnDefinition = "VARCHAR2|白细胞总数|20|", length = 20, nullable = true)
	private String leukocyteFlg;

	@Column(name = "EOSINOPHILS_FLG", columnDefinition = "VARCHAR2|嗜酸性细胞|20|", length = 20, nullable = true)
	private String eosinophilsFlg;

	@Column(name = "INTRADERMAL_TEST", columnDefinition = "VARCHAR2|皮内试验|20|", length = 20, nullable = true)
	private String intradermalTest;

	@Column(name = "HEPATIC_CYST", columnDefinition = "VARCHAR2|肝脏囊肿样病变|20|", length = 20, nullable = true)
	private String hepaticCyst;

	@Column(name = "SPLENIC_CYST", columnDefinition = "VARCHAR2|脾脏囊肿样病变|20|", length = 20, nullable = true)
	private String splenicCyst;

	@Column(name = "RENAL_CYST", columnDefinition = "VARCHAR2|肾脏囊肿样病变|20|", length = 20, nullable = true)
	private String renalCyst;

	@Column(name = "SHADOW_LUNGS", columnDefinition = "VARCHAR2|肺部圆（椭圆）阴影|20|", length = 20, nullable = true)
	private String shadowLungs;

	@Column(name = "SHADOW_OTHER", columnDefinition = "VARCHAR2|其他部位阴影|20|", length = 20, nullable = true)
	private String shadowOther;

	@Column(name = "SHADOW_BRAIN_CYST", columnDefinition = "VARCHAR2|颅脑囊肿阴影|20|", length = 20, nullable = true)
	private String shadowBrainCyst;

	@Column(name = "SHADOW_PULMONARY_CYST", columnDefinition = "VARCHAR2|肺部囊肿阴影|20|", length = 20, nullable = true)
	private String shadowPulmonaryCyst;

	@Column(name = "SHADOW_LIVER_CYST", columnDefinition = "VARCHAR2|肝脏囊肿阴影|20|", length = 20, nullable = true)
	private String shadowLiverCyst;

	@Column(name = "SAMPLE_NAME", columnDefinition = "VARCHAR2|标本名称|100|", length = 100, nullable = true)
	private String sampleName;

	@Column(name = "SEROLOGICALLY_RESULT", columnDefinition = "VARCHAR2|血清学检验结果|100|", length = 100, nullable = true)
	private String serologicallyResult;

	@Column(name = "ETIOLOGICAL_TEST_RESULT", columnDefinition = "VARCHAR2|病原学检验结果|100|", length = 100, nullable = true)
	private String etiologicalTestResult;

	@Column(name = "REPORT_TIME", columnDefinition = "DATE|检测结果报告时间||", nullable = true)
	private Date reportTime;

	@Column(name = "OTHER_RESULT", columnDefinition = "VARCHAR2|其他检测结果|100|", length = 100, nullable = true)
	private String otherResult;

	@Column(name = "HEMOGRAM", columnDefinition = "VARCHAR2|血象有无|20|", length = 20, nullable = true)
	private String hemogram;

	@Column(name = "HEMOGRAM_WBC", columnDefinition = "VARCHAR2|WBC|20|", length = 20, nullable = true)
	private String hemogramWbc;

	@Column(name = "HEMOGRAM_N", columnDefinition = "VARCHAR2|N|20|", length = 20, nullable = true)
	private String hemogramN;

	@Column(name = "HEMOGRAM_L", columnDefinition = "VARCHAR2|L|20|", length = 20, nullable = true)
	private String hemogramL;

	@Column(name = "CEREBROSPINAL_PRESSURE", columnDefinition = "VARCHAR2|脑脊液压力|20|", length = 20, nullable = true)
	private String cerebrospinalPressure;

	@Column(name = "CEREBROSPINAL_ASPECT", columnDefinition = "VARCHAR2|脑脊液外观|20|", length = 20, nullable = true)
	private String cerebrospinalAspect;

	@Column(name = "CEREBROSPINALCELL_COUNT", columnDefinition = "VARCHAR2|脑脊液细胞计数|20|", length = 20, nullable = true)
	private String cerebrospinalcellCount;

	@Column(name = "CEREBROSPINAL_PROTEIN", columnDefinition = "VARCHAR2|脑脊液蛋白|100|", length = 100, nullable = true)
	private String cerebrospinalProtein;

	@Column(name = "CEREBROSPINAL_SUGAR", columnDefinition = "VARCHAR2|脑脊液糖含量|100|", length = 100, nullable = true)
	private String cerebrospinalSugar;

	@Column(name = "XRAY_TEST_RESULT", columnDefinition = "VARCHAR2|X线检查结果|20|", length = 20, nullable = true)
	private String xrayTestResult;

	@Column(name = "XRAY_TEST_EXPRESSION", columnDefinition = "VARCHAR2|X线检查结果表现情况|100|", length = 100, nullable = true)
	private String xrayTestExpression;

	@Column(name = "MUSCLE_CALPAIN", columnDefinition = "VARCHAR2|肌钙蛋白酶|100|", length = 100, nullable = true)
	private String muscleCalpain;

	@Column(name = "MYOGLOBIN", columnDefinition = "VARCHAR2|肌红蛋白酶|100|", length = 100, nullable = true)
	private String myoglobin;

	@Column(name = "GONOCOCCUS_TEST", columnDefinition = "VARCHAR2|淋球菌涂片检查|20|", length = 20, nullable = true)
	private String gonococcusTest;

	@Column(name = "GONOCOCCUS_CULTURE", columnDefinition = "VARCHAR2|淋球菌培养|20|", length = 20, nullable = true)
	private String gonococcusCulture;

	@Column(name = "RBPT", columnDefinition = "VARCHAR2|虎红平板凝集反应|20|", length = 20, nullable = true)
	private String rbpt;

	@Column(name = "PATHOGEN_ISOLATION", columnDefinition = "VARCHAR2|病原分离|20|", length = 20, nullable = true)
	private String pathogenIsolation;

	@Column(name = "TITER_SAT", columnDefinition = "VARCHAR2|最高SAT滴度为|100|", length = 100, nullable = true)
	private String titerSat;

	@Column(name = "OTHER_TEST", columnDefinition = "VARCHAR2|其他试验|100|", length = 100, nullable = true)
	private String otherTest;

	@Column(name = "DIPHTHERIA_IGG_DWELLTIME", columnDefinition = "DATE|白喉IgG急性期-采样时间||", nullable = true)
	private Date diphtheriaIggDwelltime;

	@Column(name = "DIPHTHERIA_IGG_RESULT", columnDefinition = "VARCHAR2|白喉IgG急性期-结果|100|", length = 100, nullable = true)
	private String diphtheriaIggResult;

	@Column(name = "DIPHTHERIA_CULTURE_DWELLTIME_1", columnDefinition = "DATE|咽拭子白喉杆菌培养-采样时间1||", nullable = true)
	private Date diphtheriaCultureDwelltime_1;

	@Column(name = "DIPHTHERIA_CULTURE_RESULT_1", columnDefinition = "VARCHAR2|咽拭子白喉杆菌培养-结果1|100|", length = 100, nullable = true)
	private String diphtheriaCultureResult_1;

	@Column(name = "DIPHTHERIA_CULTURE_DWELLTIME_2", columnDefinition = "DATE|咽拭子白喉杆菌培养-采样时间2||", nullable = true)
	private Date diphtheriaCultureDwelltime_2;

	@Column(name = "DIPHTHERIA_CULTURE_RESULT_2", columnDefinition = "VARCHAR2|咽拭子白喉杆菌培养-结果2|100|", length = 100, nullable = true)
	private String diphtheriaCultureResult_2;

	@Column(name = "DIPHTHERIA_TOX_DWELLTIME_1", columnDefinition = "DATE|白喉杆菌毒力-采样时间1||", nullable = true)
	private Date diphtheriaToxDwelltime_1;

	@Column(name = "DIPHTHERIA_TOX_RESULT_1", columnDefinition = "VARCHAR2|白喉杆菌毒力-结果1|100|", length = 100, nullable = true)
	private String diphtheriaToxResult_1;

	@Column(name = "DIPHTHERIA_TOX_DWELLTIME_2", columnDefinition = "DATE|白喉杆菌毒力-采样时间2||", nullable = true)
	private Date diphtheriaToxDwelltime_2;

	@Column(name = "DIPHTHERIA_TOX_RESULT_2", columnDefinition = "VARCHAR2|白喉杆菌毒力-结果2|100|", length = 100, scale = 5, precision = 1, nullable = true)
	private String diphtheriaToxResult_2;

	@Column(name = "CEREBROSPINAL_LEUKOCYTE_COUNT", columnDefinition = "VARCHAR2|脑脊液白细胞|20|", length = 20, nullable = true)
	private String cerebrospinalLeukocyteCount;

	@Column(name = "CEREBROSPINAL_CHLORIDE", columnDefinition = "VARCHAR2|脑脊液氯化物|20|", length = 20, nullable = true)
	private String cerebrospinalChloride;

	@Column(name = "LAB_DIAGNOSIS", columnDefinition = "VARCHAR2|实验室诊断|20|", length = 20, nullable = true)
	private String labDiagnosis;

	@Column(name = "CULTURE_CEREBROSPINAL", columnDefinition = "VARCHAR2|实验室诊断-脑脊液培养|20|", length = 20, nullable = true)
	private String cultureCerebrospinal;

	@Column(name = "CEREBROSPINAL_SPEC_ANTIGEN", columnDefinition = "VARCHAR2|实验室诊断-脑脊液特异抗原检查|20|", length = 20, nullable = true)
	private String cerebrospinalSpecAntigen;

	@Column(name = "CEREBROSPINAL_NM", columnDefinition = "VARCHAR2|实验室诊断-脑脊液Nm特异DNA PCR|20|", length = 20, nullable = true)
	private String cerebrospinalNm;

	@Column(name = "PETECHIA_GNID", columnDefinition = "VARCHAR2|实验室诊断-瘀点瘀斑图片检查是否见到革兰氏阴性双球菌|20|", length = 20, nullable = true)
	private String petechiaGnid;

	@Column(name = "BLOOD_CULTURE", columnDefinition = "VARCHAR2|实验室诊断-血液培养|20|", length = 20, nullable = true)
	private String bloodCulture;

	@Column(name = "BLOOD_NM_DNA", columnDefinition = "VARCHAR2|实验室诊断-血液Nm特异DNA PCR|20|", length = 20, nullable = true)
	private String bloodNmDna;

	@Column(name = "SEROLOGY_ANTIBODY", columnDefinition = "VARCHAR2|实验室诊断-血清学抗体诊断结果|20|", length = 20, nullable = true)
	private String serologyAntibody;

	@Column(name = "SENSITIVITY_RESULT", columnDefinition = "VARCHAR2|药敏结果|20|", length = 20, nullable = true)
	private String sensitivityResult;

	@Column(name = "SENSITIVE_DRUGS_1", columnDefinition = "VARCHAR2|敏感药品1|100|", length = 100, nullable = true)
	private String sensitiveDrugs_1;

	@Column(name = "SENSITIVE_DRUGS_2", columnDefinition = "VARCHAR2|敏感药品2|100|", length = 100, nullable = true)
	private String sensitiveDrugs_2;

	@Column(name = "SENSITIVE_DRUGS_3", columnDefinition = "VARCHAR2|敏感药品3|100|", length = 100, nullable = true)
	private String sensitiveDrugs_3;

	@Column(name = "SENSITIVE_DRUGS_4", columnDefinition = "VARCHAR2|敏感药品4|100|", length = 100, nullable = true)
	private String sensitiveDrugs_4;

	@Column(name = "SENSITIVE_DRUGS_5", columnDefinition = "VARCHAR2|敏感药品5|100|", length = 100, nullable = true)
	private String sensitiveDrugs_5;

	@Column(name = "DEJECTA_LEUKOCYTE", columnDefinition = "VARCHAR2|粪便镜检白细胞|20|", length = 20, nullable = true)
	private String dejectaLeukocyte;

	@Column(name = "DEJECTA_ERYTHROCYTE", columnDefinition = "VARCHAR2|粪便镜检红细胞|20|", length = 20, nullable = true)
	private String dejectaErythrocyte;

	@Column(name = "AMOEBA_TROPHOZOITE_S", columnDefinition = "VARCHAR2|粪便镜检阿米巴大滋养体|20|", length = 20, nullable = true)
	private String amoebaTrophozoiteS;

	@Column(name = "AMOEBA_TROPHOZOITE_B", columnDefinition = "VARCHAR2|粪便镜检阿米巴小滋养体|20|", length = 20, nullable = true)
	private String amoebaTrophozoiteB;

	@Column(name = "STOOL_CULTURE", columnDefinition = "VARCHAR2|粪便培养|20|", length = 20, nullable = true)
	private String stoolCulture;

	@Column(name = "CUFF_BUTTER", columnDefinition = "VARCHAR2|束臂试验|20|", length = 20, nullable = true)
	private String cuffButter;

	@Column(name = "LEUKOCYTE_COUNT_FLG", columnDefinition = "VARCHAR2|白细胞计数|20|", length = 20, nullable = true)
	private String leukocyteCountFlg;

	@Column(name = "PLATELET_REDUCE", columnDefinition = "VARCHAR2|血小板减少|20|", length = 20, nullable = true)
	private String plateletReduce;

	@Column(name = "HEMATOKRIT", columnDefinition = "VARCHAR2|红细胞积压|100|", length = 100, nullable = true)
	private String hematokrit;

	@Column(name = "HAEMORRHAGE_TIME", columnDefinition = "VARCHAR2|出血时间|20|", length = 20, nullable = true)
	private String haemorrhageTime;

	@Column(name = "CRUOR_TIME", columnDefinition = "VARCHAR2|凝血时间|20|", length = 20, nullable = true)
	private String cruorTime;

	@Column(name = "URINE_ROUTINE", columnDefinition = "VARCHAR2|尿常规|100|", length = 20, nullable = true)
	private String urineRoutine;

	@Column(name = "LIVER_FUNCTION", columnDefinition = "VARCHAR2|肝功能|20|", length = 20, nullable = true)
	private String liverFunction;

	@Column(name = "DENGUE_IGG_COLLECT_TIME", columnDefinition = "DATE|登革抗体IgG-标本采集时间||", nullable = true)
	private Date dengueIggCollectTime;

	@Column(name = "DENGUE_IGG_TEST_METHOD", columnDefinition = "VARCHAR2|登革抗体IgG-检测方法|100|", length = 100, nullable = true)
	private String dengueIggTestMethod;

	@Column(name = "DENGUE_IGG_TEST_RESULT", columnDefinition = "VARCHAR2|登革抗体IgG-检测结果|100|", length = 100, nullable = true)
	private String dengueIggTestResult;

	@Column(name = "DENGUE_IGM_COLLECT_TIME", columnDefinition = "DATE|登革抗体IgM-标本采集时间||", nullable = true)
	private Date dengueIgmCollectTime;

	@Column(name = "DENGUE_IGM_TEST_METHOD", columnDefinition = "VARCHAR2|登革抗体IgM-检测方法|100|", length = 100, nullable = true)
	private String dengueIgmTestMethod;

	@Column(name = "DENGUE_IGM_TEST_RESULT", columnDefinition = "VARCHAR2|登革抗体IgM-检测结果|100|", length = 100, nullable = true)
	private String dengueIgmTestResult;

	@Column(name = "DENGUE_SEPARATE_COLLECT_TIME", columnDefinition = "DATE|登革病毒分离-标本采集时间||", nullable = true)
	private Date dengueSeparateCollectTime;

	@Column(name = "DENGUE_SEPARATE_TEST_METHOD", columnDefinition = "VARCHAR2|登革病毒分离-检测方法|100|", length = 100, nullable = true)
	private String dengueSeparateTestMethod;

	@Column(name = "DENGUE_SEPARATE_TEST_RESULT", columnDefinition = "VARCHAR2|登革病毒分离-检测结果|100|", length = 100, nullable = true)
	private String dengueSeparateTestResult;

	@Column(name = "DENGUE_ANTIGEN_COLLECT_TIME", columnDefinition = "DATE|登革病毒抗原-标本采集时间||", nullable = true)
	private Date dengueAntigenCollectTime;

	@Column(name = "DENGUE_ANTIGEN_TEST_METHOD", columnDefinition = "VARCHAR2|登革病毒抗原-检测方法|100|", length = 100, nullable = true)
	private String dengueAntigenTestMethod;

	@Column(name = "DENGUE_ANTIGEN_TEST_RESULT", columnDefinition = "VARCHAR2|登革病毒抗原-检测结果|100|", length = 100, nullable = true)
	private String dengueAntigenTestResult;

	@Column(name = "SERUM_COLLECT_FLG", columnDefinition = "VARCHAR2|医院实验室检测用血清是否采集|20|", length = 20, nullable = true)
	private String serumCollectFlg;

	@Column(name = "SERUM_REPORT_TIME", columnDefinition = "DATE|医院实验室检测用血清-报告结果时间||", nullable = true)
	private Date serumReportTime;

	@Column(name = "SERUM_METHOD", columnDefinition = "VARCHAR2|医院实验室检测用血清-检测方法|20|", length = 20, nullable = true)
	private String serumMethod;

	@Column(name = "SERUM_JE_ANTIBODY_IGM", columnDefinition = "VARCHAR2|医院实验室检测用血清-乙脑特异性抗体IgM|20|", length = 20, nullable = true)
	private String serumJeAntibodyIgm;

	@Column(name = "SERUM_JE_ANTIBODY_IGG", columnDefinition = "VARCHAR2|医院实验室检测用血清-乙脑特异性抗体IgG|20|", length = 20, nullable = true)
	private String serumJeAntibodyIgg;

	@Column(name = "SERUM_JE_IGG_TITER", columnDefinition = "VARCHAR2|医院实验室检测用血清-乙脑特异性IgG的效价|100|", length = 100, nullable = true)
	private String serumJeIggTiter;

	@Column(name = "FIRST_SERUM", columnDefinition = "VARCHAR2|疾控检测用第1份血清|20|", length = 20, nullable = true)
	private String firstSerum;

	@Column(name = "FIRST_SERUM_COLLECT_TIME", columnDefinition = "DATE|疾控检测用第1份血清-采集时间||", nullable = true)
	private Date firstSerumCollectTime;

	@Column(name = "FIRST_SERUM_REPORT_TIME", columnDefinition = "DATE|疾控检测用第1份血清-报告结果时间||", nullable = true)
	private Date firstSerumReportTime;

	@Column(name = "FIRST_SERUM_METHOD", columnDefinition = "VARCHAR2|疾控检测用第1份血清-实验室检测方法|20|", length = 20, nullable = true)
	private String firstSerumMethod;

	@Column(name = "FIRST_SERUM_JE_ANTIBODY_IGM", columnDefinition = "VARCHAR2|疾控检测用第1份血清-乙脑特异性抗体IgM|20|", length = 20, nullable = true)
	private String firstSerumJeAntibodyIgm;

	@Column(name = "FIRST_SERUM_JE_ANTIBODY_IGG", columnDefinition = "VARCHAR2|疾控检测用第1份血清-乙脑特异性抗体IgG |20|", length = 20, nullable = true)
	private String firstSerumJeAntibodyIgg;

	@Column(name = "FIRST_SERUM_JE_IGG_TITER", columnDefinition = "VARCHAR2|疾控检测用第1份血清-乙脑特异性IgG的效价|100|", length = 100, nullable = true)
	private String firstSerumJeIggTiter;

	@Column(name = "SECOND_SERUM", columnDefinition = "VARCHAR2|疾控检测用第2份血清|20|", length = 20, nullable = true)
	private String secondSerum;

	@Column(name = "SECOND_SERUM_COLLECT_TIME", columnDefinition = "DATE|疾控检测用第2份血清-采集时间||", nullable = true)
	private Date secondSerumCollectTime;

	@Column(name = "SECOND_SERUM_REPORT_TIME", columnDefinition = "DATE|疾控检测用第2份血清-报告结果时间||", nullable = true)
	private Date secondSerumReportTime;

	@Column(name = "SECOND_SERUM_METHOD", columnDefinition = "VARCHAR2|疾控检测用第2份血清-实验室检测方法|20|", length = 20, nullable = true)
	private String secondSerumMethod;

	@Column(name = "SECOND_SERUM_JE_ANTIBODY_IGM", columnDefinition = "VARCHAR2|疾控检测用第2份血清-乙脑特异性抗体IgM|20|", length = 20, nullable = true)
	private String secondSerumJeAntibodyIgm;

	@Column(name = "SECOND_SERUM_JE_ANTIBODY_IGG", columnDefinition = "VARCHAR2|疾控检测用第2份血清-乙脑特异性抗体IgG |20|", length = 20, nullable = true)
	private String secondSerumJeAntibodyIgg;

	@Column(name = "SECOND_SERUM_JE_IGG_TITER", columnDefinition = "VARCHAR2|疾控检测用第2份血清-乙脑特异性IgG的效价|100|", length = 100, nullable = true)
	private String secondSerumJeIggTiter;

	@Column(name = "CSF_CHECK", columnDefinition = "VARCHAR2|脑脊液检测|20|", length = 20, nullable = true)
	private String csfCheck;

	@Column(name = "CSF_CHECK_COLLECT_TIME", columnDefinition = "DATE|脑脊液检测-采集时间||", nullable = true)
	private Date csfCheckCollectTime;

	@Column(name = "CSF_CHECK_REPORT_TIME", columnDefinition = "DATE|脑脊液检测-报告结果时间||", nullable = true)
	private Date csfCheckReportTime;

	@Column(name = "CSF_PHYSICS_TEST", columnDefinition = "VARCHAR2|脑脊液检测-物理检测|20|", length = 20, nullable = true)
	private String csfPhysicsTest;

	@Column(name = "CSF_CELL", columnDefinition = "VARCHAR2|脑脊液检测-生化检测-细胞数|20|", length = 20, nullable = true)
	private String csfCell;

	@Column(name = "CSF_ALBUMEN", columnDefinition = "VARCHAR2|脑脊液检测-生化检测-蛋白|20|", length = 20, nullable = true)
	private String csfAlbumen;

	@Column(name = "CSF_SUGAR", columnDefinition = "VARCHAR2|脑脊液检测-糖|20|", length = 20, nullable = true)
	private String csfSugar;

	@Column(name = "CSF_SUGAR_COUNT", columnDefinition = "VARCHAR2|脑脊液检测-糖检测值|20|", length = 20, nullable = true)
	private String csfSugarCount;

	@Column(name = "CSF_CHLORIDE", columnDefinition = "VARCHAR2|脑脊液检测-氯化物|20|", length = 20, nullable = true)
	private String csfChloride;

	@Column(name = "CSF_CHLORIDE_COUNT", columnDefinition = "VARCHAR2|脑脊液检测-氯化物检测值|20|", length = 20, nullable = true)
	private String csfChlorideCount;

	@Column(name = "CSF_JE_ANTIBODY", columnDefinition = "VARCHAR2|脑脊液检测-乙脑特异性抗体|20|", length = 20, nullable = true)
	private String csfJeAntibody;

	@Column(name = "JE_VIRAL_ISOLATION", columnDefinition = "VARCHAR2|病毒分离|20|", length = 20, nullable = true)
	private String jeViralIsolation;

	@Column(name = "JE_VIRAL_ISOLATION_SAMPLE", columnDefinition = "VARCHAR2|病毒分离-病毒分离标本|20|", length = 20, nullable = true)
	private String jeViralIsolationSample;

	@Column(name = "JE_VIRAL_ISOLATION_TIME", columnDefinition = "DATE|病毒分离-病毒分离时间||", nullable = true)
	private Date jeViralIsolationTime;

	@Column(name = "JE_VIRAL_ISOLATION_RESULT", columnDefinition = "VARCHAR2|病毒分离-病毒分离结果|20|", length = 20, nullable = true)
	private String jeViralIsolationResult;

	@Column(name = "JE_VIRAL_IDENTI_RESULT", columnDefinition = "VARCHAR2|病毒分离-病毒鉴定结果|20|", length = 20, nullable = true)
	private String jeViralIdentiResult;

	@Column(name = "JE_VIRAL_PCR", columnDefinition = "VARCHAR2|病毒分离-聚合酶链反应(PCR)结果|20|", length = 20, nullable = true)
	private String jeViralPcr;

	@Column(name = "SAMPLE_CLASS", columnDefinition = "VARCHAR2|标本种类|20|", length = 20, nullable = true)
	private String sampleClass;

	@Column(name = "TEST_ITEM", columnDefinition = "VARCHAR2|检测项目|20|", length = 20, nullable = true)
	private String testItem;

	@Column(name = "TEST_RESULT", columnDefinition = "VARCHAR2|检测结果|20|", length = 20, nullable = true)
	private String testResult;

	@Column(name = "URINE_PROTEIN", columnDefinition = "VARCHAR2|尿蛋白|20|", length = 20, nullable = true)
	private String urineProtein;

	@Column(name = "CYLINDERURIA_FLG", columnDefinition = "VARCHAR2|有无尿膜状物/管型尿/血尿|20|", length = 20, nullable = true)
	private String cylinderuriaFlg;

	@Column(name = "EHF_IGG_COLLECTTIME", columnDefinition = "DATE|出血热抗体IgG标本采集时间||", nullable = true)
	private Date ehfIggCollecttime;

	@Column(name = "EHF_IGG_TEST_METHOD", columnDefinition = "VARCHAR2|出血热抗体IgG检测方式|100|", length = 100, nullable = true)
	private String ehfIggTestMethod;

	@Column(name = "EHF_IGG_TEST_RESULT", columnDefinition = "VARCHAR2|出血热抗体IgG检测结果|100|", length = 100, nullable = true)
	private String ehfIggTestResult;

	@Column(name = "EHF_IGM_COLLECTTIME", columnDefinition = "DATE|出血热抗体IgM检测采集时间||", nullable = true)
	private Date ehfIgmCollecttime;

	@Column(name = "EHF_IGM_TEST_METHOD", columnDefinition = "VARCHAR2|出血热抗体IgM检测方式|100|", length = 100, nullable = true)
	private String ehfIgmTestMethod;

	@Column(name = "EHF_IGM_TEST_RESULT", columnDefinition = "VARCHAR2|出血热抗体IgM检测结果|100|", length = 100, nullable = true)
	private String ehfIgmTestResult;

	@Column(name = "HANTAVIRUS_COLLECTIME", columnDefinition = "DATE|汉坦病毒分离标本采集时间||", nullable = true)
	private Date hantavirusCollectime;

	@Column(name = "HANTAVIRUS_TEST_METHOD", columnDefinition = "VARCHAR2|汉坦病毒分离检测方式|100|", length = 100, nullable = true)
	private String hantavirusTestMethod;

	@Column(name = "HANTAVIRUS_TEST_RESULT", columnDefinition = "VARCHAR2|汉坦病毒分离检测结果|100|", length = 100, nullable = true)
	private String hantavirusTestResult;

	@Column(name = "SERUM_SPECIMEN_F", columnDefinition = "VARCHAR2|第一份血清标本|2|", length = 2, nullable = true)
	private String serumSpecimenF;

	@Column(name = "SERUM_SPECIMEN_DT_F", columnDefinition = "DATE|第一份血清标本_采集日期||", nullable = true)
	private Date serumSpecimenDtF;

	@Column(name = "SERUM_SPECIMEN_S", columnDefinition = "VARCHAR2|第二份血清标本|2|", length = 2, nullable = true)
	private String serumSpecimenS;

	@Column(name = "SERUM_SPECIMEN_DT_S", columnDefinition = "DATE|第二份血清标本_采集日期||", nullable = true)
	private Date serumSpecimenDtS;

	@Column(name = "FIRST_SERUM_MEASLES_IGM", columnDefinition = "VARCHAR2|第一份血标本麻疹IgM抗体检测结果|20|", length = 20, nullable = true)
	private String firstSerumMeaslesIgm;

	@Column(name = "FIRST_SERUM_RUBELLA_IGM", columnDefinition = "VARCHAR2|第一份血标本风疹IgM抗体检测结果|20|", length = 20, nullable = true)
	private String firstSerumRubellaIgm;

	@Column(name = "SECOND_SERUM_MEASLES_IGM", columnDefinition = "VARCHAR2|第二份血标本麻疹IgM抗体检测结果|20|", length = 20, nullable = true)
	private String secondSerumMeaslesIgm;

	@Column(name = "SECOND_SERUM_RUBELLA_IGM", columnDefinition = "VARCHAR2|第二份血标本风疹IgM抗体检测结果|20|", length = 20, nullable = true)
	private String secondSerumRubellaIgm;

	@Column(name = "STOOL_COLLECTTIME_1", columnDefinition = "DATE|采集日期||", nullable = true)
	private Date stoolCollecttime_1;

	@Column(name = "STOOL_COLLECTNAME_1", columnDefinition = "VARCHAR2|采集人姓名|50|", length = 50, nullable = true)
	private String stoolCollectname_1;

	@Column(name = "STOOL_COLLECTUNIT_1", columnDefinition = "VARCHAR2|采集人单位|100|", length = 100, nullable = true)
	private String stoolCollectunit_1;

	@Column(name = "PROVINCIAL_RECEIVE_DATE_1", columnDefinition = "DATE|省级实验室收到粪便日期||", nullable = true)
	private Date provincialReceiveDate_1;

	@Column(name = "WITH_ICE_FLG_1", columnDefinition = "VARCHAR2|标本是否带冰运送|20|", length = 20, nullable = true)
	private String withIceFlg_1;

	@Column(name = "SAMPLE_STATUS_1", columnDefinition = "VARCHAR2|标本状态|20|", length = 20, nullable = true)
	private String sampleStatus_1;

	@Column(name = "SAMPLE_NUMBER_1", columnDefinition = "VARCHAR2|标本量|20|", length = 20, nullable = true)
	private String sampleNumber_1;

	@Column(name = "VIRAL_ISOLATION_FLG_1", columnDefinition = "VARCHAR2|是否进行病毒分离|20|", length = 20, nullable = true)
	private String viralIsolationFlg_1;

	@Column(name = "VACCINATE_DATE_1", columnDefinition = "DATE|标本接种日期||", nullable = true)
	private Date vaccinateDate_1;

	@Column(name = "POLIOVIRUS_GROUP_FLG_1", columnDefinition = "VARCHAR2|是否进行脊灰病毒分型|20|", length = 20, nullable = true)
	private String poliovirusGroupFlg_1;

	@Column(name = "VIRAL_TYPE_1_1", columnDefinition = "VARCHAR2|Ⅰ型病毒|20|", length = 20, nullable = true)
	private String viralType_1_1;

	@Column(name = "VIRAL_TYPE_2_1", columnDefinition = "VARCHAR2|Ⅱ型病毒|20|", length = 20, nullable = true)
	private String viralType_2_1;

	@Column(name = "VIRAL_TYPE_3_1", columnDefinition = "VARCHAR2|Ⅲ型病毒|20|", length = 20, nullable = true)
	private String viralType_3_1;

	@Column(name = "OTHER_ENTEROVIRUS_1", columnDefinition = "VARCHAR2|其它肠道病毒|20|", length = 20, nullable = true)
	private String otherEnterovirus_1;

	@Column(name = "RESULT_REPORT_DATE_1", columnDefinition = "DATE|检验结果报告日期||", nullable = true)
	private Date resultReportDate_1;

	@Column(name = "NATIONAL_RECEIVE_DATE_1", columnDefinition = "DATE|国家级实验室收到分离物日期|", nullable = true)
	private Date nationalReceiveDate_1;

	@Column(name = "NATIONAL_REPORT_DATE_1", columnDefinition = "DATE|收到国家级实验室结果日期||", nullable = true)
	private Date nationalReportDate_1;

	@Column(name = "STOOL_COLLECTTIME_2", columnDefinition = "DATE|采集日期||", nullable = true)
	private Date stoolCollecttime_2;

	@Column(name = "STOOL_COLLECTNAME_2", columnDefinition = "VARCHAR2|采集人姓名|50|", length = 50, nullable = true)
	private String stoolCollectname_2;

	@Column(name = "STOOL_COLLECTUNIT_2", columnDefinition = "VARCHAR2|采集人单位|100|", length = 100, nullable = true)
	private String stoolCollectunit_2;

	@Column(name = "PROVINCIAL_RECEIVE_DATE_2", columnDefinition = "DATE|省级实验室收到粪便日期||", nullable = true)
	private Date provincialReceiveDate_2;

	@Column(name = "WITH_ICE_FLG_2", columnDefinition = "VARCHAR2|标本是否带冰运送|20|", length = 20, nullable = true)
	private String withIceFlg_2;

	@Column(name = "SAMPLE_STATUS_2", columnDefinition = "VARCHAR2|标本状态|20|", length = 20, nullable = true)
	private String sampleStatus_2;

	@Column(name = "SAMPLE_NUMBER_2", columnDefinition = "VARCHAR2|标本量||", length = 20, nullable = true)
	private String sampleNumber_2;

	@Column(name = "VIRAL_ISOLATION_FLG_2", columnDefinition = "VARCHAR2|是否进行病毒分离|20|", length = 20, nullable = true)
	private String viralIsolationFlg_2;

	@Column(name = "VACCINATE_DATE_2", columnDefinition = "DATE|标本接种日期||", nullable = true)
	private Date vaccinateDate_2;

	@Column(name = "POLIOVIRUS_GROUP_FLG_2", columnDefinition = "VARCHAR2|是否进行脊灰病毒分型|20|", length = 20, nullable = true)
	private String poliovirusGroupFlg_2;

	@Column(name = "VIRAL_TYPE_1_2", columnDefinition = "VARCHAR2|Ⅰ型病毒|20|", length = 20, nullable = true)
	private String viralType_1_2;

	@Column(name = "VIRAL_TYPE_2_2", columnDefinition = "VARCHAR2|Ⅱ型病毒|20|", length = 20, nullable = true)
	private String viralType_2_2;

	@Column(name = "VIRAL_TYPE_3_2", columnDefinition = "VARCHAR2|Ⅲ型病毒|20|", length = 20, nullable = true)
	private String viralType_3_2;

	@Column(name = "OTHER_ENTEROVIRUS_2", columnDefinition = "VARCHAR2|其它肠道病毒|20|", length = 20, nullable = true)
	private String otherEnterovirus_2;

	@Column(name = "RESULT_REPORT_DATE_2", columnDefinition = "DATE|检验结果报告日期||", nullable = true)
	private Date resultReportDate_2;

	@Column(name = "NATIONAL_RECEIVE_DATE_2", columnDefinition = "DATE|国家级实验室收到分离物日期|", nullable = true)
	private Date nationalReceiveDate_2;

	@Column(name = "NATIONAL_REPORT_DATE_2", columnDefinition = "DATE|收到国家级实验室结果日期||", nullable = true)
	private Date nationalReportDate_2;

	@Column(name = "POLIOMYELITIS_TYPE_1", columnDefinition = "VARCHAR2|Ⅰ型脊灰野病毒|20|", length = 20, nullable = true)
	private String poliomyelitisType_1;

	@Column(name = "POLIOMYELITIS_TYPE_2", columnDefinition = "VARCHAR2|Ⅱ型脊灰野病毒|20|", length = 20, nullable = true)
	private String poliomyelitisType_2;

	@Column(name = "POLIOMYELITIS_TYPE_3", columnDefinition = "VARCHAR2|Ⅲ型脊灰野病毒|20|", length = 20, nullable = true)
	private String poliomyelitisType_3;

	@Column(name = "POLIO_VACCINE_VIRUS_TYPE_1", columnDefinition = "VARCHAR2|Ⅰ型脊灰疫苗病毒|20|", length = 20, nullable = true)
	private String polioVaccineVirusType_1;

	@Column(name = "POLIO_VACCINE_VIRUS_TYPE_2", columnDefinition = "VARCHAR2|Ⅱ型脊灰疫苗病毒|20|", length = 20, nullable = true)
	private String polioVaccineVirusType_2;

	@Column(name = "POLIO_VACCINE_VIRUS_TYPE_3", columnDefinition = "VARCHAR2|Ⅲ型脊灰疫苗病毒|20|", length = 20, nullable = true)
	private String polioVaccineVirusType_3;

	@Column(name = "VDPV_TYPE_1", columnDefinition = "VARCHAR2|Ⅰ型脊灰疫苗衍生病毒|20|", length = 20, nullable = true)
	private String vdpvType_1;

	@Column(name = "VDPV_TYPE_2", columnDefinition = "VARCHAR2|Ⅱ型脊灰疫苗衍生病毒|20|", length = 20, nullable = true)
	private String vdpvType_2;

	@Column(name = "VDPV_TYPE_3", columnDefinition = "VARCHAR2|Ⅲ型脊灰疫苗衍生病毒|20|", length = 20, nullable = true)
	private String vdpvType_3;

	@Column(name = "OTHER_ENTEROVIRUS", columnDefinition = "VARCHAR2|其它肠道病毒|20|", length = 20, nullable = true)
	private String otherEnterovirus;

	@Column(name = "UNDETERMINED", columnDefinition = "VARCHAR2|待定|20|", length = 20, nullable = true)
	private String undetermined;

	@Column(name = "INSPECTION_REPORT_DATE", columnDefinition = "DATE|国家级实验室鉴定报告日期||", nullable = true)
	private Date inspectionReportDate;

	@Column(name = "ALT", columnDefinition = "VARCHAR2|ALT||", length = 20, nullable = true)
	private String alt;

	@Column(name = "AST", columnDefinition = "VARCHAR2|AST||", length = 20, nullable = true)
	private String ast;

	@Column(name = "TBIL", columnDefinition = "VARCHAR2|总胆红素||", length = 20, nullable = true)
	private String tbil;

	@Column(name = "HAV_IGM", columnDefinition = "VARCHAR2|抗HAV-IgM|20|", length = 20, nullable = true)
	private String havIgm;

	@Column(name = "HBSAG", columnDefinition = "VARCHAR2|HBsAg|20|", length = 20, nullable = true)
	private String hbsag;

	@Column(name = "ANTI_HBS", columnDefinition = "VARCHAR2|抗HBs|20|", length = 20, nullable = true)
	private String antiHbs;

	@Column(name = "HBEAG", columnDefinition = "VARCHAR2|HbeAg|20|", length = 20, nullable = true)
	private String hbeag;

	@Column(name = "ANTI_HBE", columnDefinition = "VARCHAR2|抗Hbe|20|", length = 20, nullable = true)
	private String antiHbe;

	@Column(name = "ANTI_HBC_IGM", columnDefinition = "VARCHAR2|抗HBc-IgM|20|", length = 20, nullable = true)
	private String antiHbcIgm;

	@Column(name = "ANTI_HCV_IGM", columnDefinition = "VARCHAR2|抗HCV-IgM|20|", length = 20, nullable = true)
	private String antiHcvIgm;

	@Column(name = "ANTI_HDV_IGM", columnDefinition = "VARCHAR2|抗HDV-IgM|20|", length = 20, nullable = true)
	private String antiHdvIgm;

	@Column(name = "ANTI_HEV_IGM", columnDefinition = "VARCHAR2|抗HEV-IgM|20|", length = 20, nullable = true)
	private String antiHevIgm;

	@Column(name = "FIRST_LEUKOCYTE_COUNT", columnDefinition = "VARCHAR2|初诊时白细胞计数|20|", length = 20, nullable = true)
	private String firstLeukocyteCount;

	@Column(name = "FIRST_NEUTROPHILIC", columnDefinition = "VARCHAR2|初诊时中性粒细胞|20|", length = 20, nullable = true)
	private String firstNeutrophilic;

	@Column(name = "FIRST_LYMPHOCYTE_COUNT", columnDefinition = "VARCHAR2|初诊时淋巴细胞计数|20|", length = 20, nullable = true)
	private String firstLymphocyteCount;

	@Column(name = "ADMISSION_LEUKOCYTE_COUNT", columnDefinition = "VARCHAR2|入院时白细胞计数|20|", length = 20, nullable = true)
	private String admissionLeukocyteCount;

	@Column(name = "ADMISSION_NEUTROPHILIC", columnDefinition = "VARCHAR2|入院时中性粒细胞|20|", length = 20, nullable = true)
	private String admissionNeutrophilic;

	@Column(name = "ADMISSION_LYMPHOCYTE_COUNT", columnDefinition = "VARCHAR2|入院时淋巴细胞计数|20|", length = 20, nullable = true)
	private String admissionLymphocyteCount;

	@Column(name = "CHEST_XRAY_FIRST_TIME", columnDefinition = "DATE|胸部Ｘ线初诊时检查时间||", nullable = true)
	private Date chestXrayFirstTime;

	@Column(name = "CHEST_XRAY_FIRST_RESULT", columnDefinition = "VARCHAR2|胸部Ｘ线初诊时检查结果|20|", length = 20, nullable = true)
	private String chestXrayFirstResult;

	@Column(name = "CHEST_XRAY_FIRST_OTHER", columnDefinition = "VARCHAR2|胸部Ｘ线初诊时检查其他|100|", length = 100, nullable = true)
	private String chestXrayFirstOther;

	@Column(name = "CHEST_XRAY_ADMISSION_TIME", columnDefinition = "DATE|胸部Ｘ线入院时检查时间||", nullable = true)
	private Date chestXrayAdmissionTime;

	@Column(name = "CHEST_XRAY_ADMISSION_RESULT", columnDefinition = "VARCHAR2|胸部Ｘ线入院时检查结果|20|", length = 20, nullable = true)
	private String chestXrayAdmissionResult;

	@Column(name = "CHEST_XRAY_ADMISSION_OTHER", columnDefinition = "VARCHAR2|胸部Ｘ线入院时检查其他|100|", length = 100, nullable = true)
	private String chestXrayAdmissionOther;

	@Column(name = "CHEST_XRAY_RESULT", columnDefinition = "VARCHAR2|胸部Ｘ线结果具体描述|100|", length = 100, nullable = true)
	private String chestXrayResult;

	@Column(name = "FIRST_DRAWBLOOD_TIME", columnDefinition = "DATE|第一份血清采血时间||", nullable = true)
	private Date firstDrawbloodTime;

	@Column(name = "FIRST_SARS_IGM", columnDefinition = "VARCHAR2|第一份血清SARS-IgM|20|", length = 20, nullable = true)
	private String firstSarsIgm;

	@Column(name = "FIRST_SARS_IGG", columnDefinition = "VARCHAR2|第一份血清SARS-IgG|20|", length = 20, nullable = true)
	private String firstSarsIgg;

	@Column(name = "FIRST_SARS_ANTI", columnDefinition = "VARCHAR2|第一份血清SARS-总抗体|20|", length = 20, nullable = true)
	private String firstSarsAnti;

	@Column(name = "SECOND_DRAWBLOOD_TIME", columnDefinition = "DATE|第二份血清采血时间||", nullable = true)
	private Date secondDrawbloodTime;

	@Column(name = "SECOND_SARS_IGM", columnDefinition = "VARCHAR2|第二份血清SARS-IgM|20|", length = 20, nullable = true)
	private String secondSarsIgm;

	@Column(name = "SECOND_SARS_IGG", columnDefinition = "VARCHAR2|第二份血清SARS-IgG|20|", length = 20, nullable = true)
	private String secondSarsIgg;

	@Column(name = "SECOND_SARS_ANTI", columnDefinition = "VARCHAR2|第二份血清SARS-总抗体|20|", length = 20, nullable = true)
	private String secondSarsAnti;

	@Column(name = "STOOL_COLLECTTIME", columnDefinition = "DATE|粪便采集时间||", nullable = true)
	private Date stoolCollecttime;

	@Column(name = "STOOL_PCR", columnDefinition = "VARCHAR2|粪便-PCR|20|", length = 20, nullable = true)
	private String stoolPcr;

	@Column(name = "STOOL_RT_PCR", columnDefinition = "VARCHAR2|粪便-RT-PCR|20|", length = 20, nullable = true)
	private String stoolRtPcr;

	@Column(name = "STOOL_SEQUENCING", columnDefinition = "VARCHAR2|粪便核算测序|20|", length = 20, nullable = true)
	private String stoolSequencing;

	@Column(name = "STOOL_VIRAL_ISOLATION", columnDefinition = "VARCHAR2|粪便病毒分离|20|", length = 20, nullable = true)
	private String stoolViralIsolation;

	@Column(name = "THROAT_SWAB_COLLECTTIME", columnDefinition = "DATE|咽拭液采集时间||", nullable = true)
	private Date throatSwabCollecttime;

	@Column(name = "THROAT_SWAB_PCR", columnDefinition = "VARCHAR2|咽拭液-PCR|20|", length = 20, nullable = true)
	private String throatSwabPcr;

	@Column(name = "THROAT_SWAB_RT_PCR", columnDefinition = "VARCHAR2|咽拭液-RT-PCR|20|", length = 20, nullable = true)
	private String throatSwabRtPcr;

	@Column(name = "THROAT_SWAB_SEQUENCING", columnDefinition = "VARCHAR2|咽拭液核算测序|20|", length = 20, nullable = true)
	private String throatSwabSequencing;

	@Column(name = "THROAT_SWAB_VIRAL_ISOLATION", columnDefinition = "VARCHAR2|咽拭液病毒分离|20|", length = 20, nullable = true)
	private String throatSwabViralIsolation;

	@Column(name = "PHLEGM_COLLECTTIME", columnDefinition = "DATE|痰采集时间||", nullable = true)
	private Date phlegmCollecttime;

	@Column(name = "PHLEGM_PCR", columnDefinition = "VARCHAR2|痰-PCR|20|", length = 20, nullable = true)
	private String phlegmPcr;

	@Column(name = "PHLEGM_PCR_RESULT", columnDefinition = "VARCHAR2|痰-涂片－未查原因|20|", length = 20, nullable = true)
	private String phlegmPcrResult;
	
	@Column(name = "PHLEGM_RT_PCR", columnDefinition = "VARCHAR2|痰-RT-PCR|20|", length = 20, nullable = true)
	private String phlegmRtPcr;
	
	@Column(name = "PHLEGM_RT_PCR_RESULT", columnDefinition = "VARCHAR2|痰-培养－未查原因|20|", length = 20, nullable = true)
	private String phlegmRtPcrResult;

	@Column(name = "PHLEGM_SEQUENCING", columnDefinition = "VARCHAR2|痰核算测序|20|", length = 20, nullable = true)
	private String phlegmSequencing;

	@Column(name = "PHLEGM_VIRAL_ISOLATION", columnDefinition = "VARCHAR2|痰病毒分离|20|", length = 20, nullable = true)
	private String phlegmViralIsolation;

	@Column(name = "BLOOD_COLLECTTIME", columnDefinition = "DATE|血液采集时间||", nullable = true)
	private Date bloodCollecttime;

	@Column(name = "BLOOD_PCR", columnDefinition = "VARCHAR2|血液-PCR|20|", length = 20, nullable = true)
	private String bloodPcr;

	@Column(name = "BLOOD_RT_PCR", columnDefinition = "VARCHAR2|血液-RT-PCR|20|", length = 20, nullable = true)
	private String bloodRtPcr;

	@Column(name = "BLOOD_SEQUENCING", columnDefinition = "VARCHAR2|血液核算测序|20|", length = 20, nullable = true)
	private String bloodSequencing;

	@Column(name = "BLOOD_VIRAL_ISOLATION", columnDefinition = "VARCHAR2|血液病毒分离|20|", length = 20, nullable = true)
	private String bloodViralIsolation;

	@Column(name = "CHEST_XRAYS", columnDefinition = "VARCHAR2|胸透|100|", length = 100, nullable = true)
	private String chestXrays;

	@Column(name = "PERTUSSIS", columnDefinition = "VARCHAR2|百日咳培养|100|", length = 100, nullable = true)
	private String pertussis;

	@Column(name = "PERTUSSIS_DT", columnDefinition = "DATE|百日咳培养日期||", nullable = true)
	private Date pertussisDt;

	@Column(name = "DIPHTHERIA_IGG_RECOVER_DT", columnDefinition = "DATE|白喉IgG恢复期-采样时间||", nullable = true)
	private Date diphtheriaIggRecoverDt;

	@Column(name = "DIPHTHERIA_IGG_RE_RESULT", columnDefinition = "VARCHAR2|白喉IgG恢复期-结果|100|", length = 100, nullable = true)
	private String diphtheriaIggReResult;
	
	@Column(name = "SAMPLE_NUMBER_FLAG_1", columnDefinition = "标本量（是否）", nullable = true)
	private String sampleNumberFlag_1;
	
	@Column(name = "SAMPLE_NUMBER_FLAG_2", columnDefinition = "标本量（是否）", nullable = true)
	private String sampleNumberFlag_2;

    @Column(name = "X_NO", columnDefinition = "VARCHAR2|Ｘ线号|20|", length = 20, nullable = true)
    private String xNo;

    @Column(name = "HEART_CHECK", columnDefinition = "VARCHAR2|心脏检查|100|", length = 100, nullable = true)
    private String heartCheck;

    @Column(name = "LIVER_CHECK", columnDefinition = "VARCHAR2|肝脏检查|100|", length = 100, nullable = true)
    private String liverCheck;

    @Column(name = "KIDNEY_CHECK", columnDefinition = "VARCHAR2|肾脏检查|100|", length = 100, nullable = true)
    private String kidneyCheck;

    @Column(name = "OTHER", columnDefinition = "VARCHAR2|其他|100|", length = 100, nullable = true)
    private String other;

    @Column(name = "TUBERCULIN_TEST", columnDefinition = "VARCHAR2|结素试验|100|", length = 100, nullable = true)
    private String tuberculinTest;

    @Column(name = "CAVITY", columnDefinition = "VARCHAR2|空洞|100|", length = 100, nullable = true)
    private String cavity;

    @Column(name = "CAVITY_SCALE", columnDefinition = "VARCHAR2|空洞分级|2|", length = 2, nullable = true)
    private String cavityScale;

    @Column(name = "PIC_REPORT_DT", columnDefinition = "DATE|痰涂片报告日期||", nullable = true)
    private Date picReportDt;

    @Column(name = "CULTURE_REPORT_DT", columnDefinition = "DATE|痰培养报告日期||", nullable = true)
    private Date cultureReportDt;

    @Column(name = "DRUG_RESULT_1", columnDefinition = "VARCHAR2|药敏试验结果1|2|", length = 2, nullable = true)
    private String drugResult1;

    @Column(name = "DRUG_RESULT_2", columnDefinition = "VARCHAR2|药敏试验结果2|2|", length = 2, nullable = true)
    private String drugResult2;

    @Column(name = "DRUG_REPORT_DT", columnDefinition = "DATE|药敏报告日期||", nullable = true)
    private Date drugReportDt;

    @Column(name = "HIV_RESULT", columnDefinition = "VARCHAR2|hiv检测结果|2|", length = 2, nullable = true)
    private String hivResult;

    @Column(name = "HIV_CD_4", columnDefinition = "VARCHAR2|hiv检测cd4值|10|", length = 10, nullable = true)
    private String hivCd4;

    @Column(name = "HIV_REPORT_DT", columnDefinition = "DATE|hiv报告日期||", nullable = true)
    private Date hivReportDt;

    @Column(name = "CAVITY_FLAG", columnDefinition = "VARCHAR2|空洞选择|2|", length = 2, nullable = true)
    private String cavityFlag;

    @Column(name = "SPUTUM_2", columnDefinition = "VARCHAR2|满两月痰检|2|", length = 2, nullable = true)
    private String sputum_2;

    @Column(name = "SPUTUM_3", columnDefinition = "VARCHAR2|满三月痰检|2|", length = 2, nullable = true)
    private String sputum_3;

    @Column(name = "TEST_DT", columnDefinition = "DATE|检验日期||", nullable = true)
    private Date testDt;

    @Column(name = "TEST_USER", columnDefinition = "VARCHAR2|检验人|50|", length = 50, nullable = true)
    private String testUser;

    @Column(name = "PLASMODIUM_DT", columnDefinition = "DATE|血检虐原虫时间||", nullable = true)
    private Date plasmodiumDt;

    @Column(name = "RDT", columnDefinition = "VARCHAR2|镜检/RDT结果|2|", length = 2, nullable = true)
    private String rdt;

    @Column(name = "IHA_CHECK", columnDefinition = "VARCHAR2|IHA检验|2|", length = 2, nullable = true)
    private String ihaCheck;

    @Column(name = "IHA_DT", columnDefinition = "DATE|IHA检验时间||", nullable = true)
    private Date ihaDt;

    @Column(name = "DDIA", columnDefinition = "VARCHAR2|DDIA检验|2|", length = 2, nullable = true)
    private String ddia;

    @Column(name = "DDIA_DT", columnDefinition = "DATE|DDIA检验时间||", nullable = true)
    private Date ddiaDt;

    @Column(name = "COPT", columnDefinition = "VARCHAR2|COPT检验|2|", length = 2, nullable = true)
    private String copt;

    @Column(name = "COPT_DT", columnDefinition = "DATE|COPT检验时间||", nullable = true)
    private Date coptDt;

    @Column(name = "STOOL", columnDefinition = "VARCHAR2|粪检|2|", length = 2, nullable = true)
    private String stool;

    @Column(name = "STOOL_DT", columnDefinition = "DATE|粪检时间||", nullable = true)
    private Date stoolDt;

    @Column(name = "ONE_THREE", columnDefinition = "VARCHAR2|一血三检|2|", length = 2, nullable = true)
    private String oneThree;

    @Column(name = "B", columnDefinition = "VARCHAR2|B超|100|", length = 100, nullable = true)
    private String b;

    @Column(name = "GGT", columnDefinition = "VARCHAR2|GGT|20|", length = 20, nullable = true)
    private String ggt;

    @Column(name = "SPLENIC_CHECK", columnDefinition = "VARCHAR2|脾检查|100|", length = 100, nullable = true)
    private String splenicCheck;

    @Column(name = "ASCITES", columnDefinition = "VARCHAR2|腹水|100|", length = 100, nullable = true)
    private String ascites;

    @Column(name = "CHECK_DT", columnDefinition = "DATE|检查时间||", nullable = true)
    private Date checkDt;

    @Column(name = "CHECK_UNIT", columnDefinition = "VARCHAR2|检查单位|100|", length = 100, nullable = true)
    private String checkUnit;

    @Column(name = "FUNGUS_CONDITION", columnDefinition = "VARCHAR2|查菌情况|2|", length = 2, nullable = true)
    private String fungusCondition;

    @Column(name = "BI", columnDefinition = "VARCHAR2|bi|20|", length = 20, nullable = true)
    private String bi;

    @Column(name = "UN_CHECK_RESULT", columnDefinition = "VARCHAR2|未查原因|100|", length = 100, nullable = true)
    private String unCheckResult;

    @Column(name = "AFB", columnDefinition = "VARCHAR2|afb|20|", length = 20, nullable = true)
    private String afb;

    @Column(name = "PATHOLOGY_NO", columnDefinition = "VARCHAR2|病理号|100|", length = 100, nullable = true)
    private String pathologyNo;

    @Column(name = "URINE_GUISE", columnDefinition = "VARCHAR2|尿液外观|2|", length = 2, nullable = true)
    private String urineGuise;

    @Column(name = "URINE_HARD", columnDefinition = "VARCHAR2|排尿困难|2|", length = 2, nullable = true)
    private String urineHard;

    @Column(name = "CHY", columnDefinition = "VARCHAR2|乳糜试验|2|", length = 2, nullable = true)
    private String chy;

    @Column(name = "TREAT_CONDITION", columnDefinition = "VARCHAR2|治疗情况|2|", length = 2, nullable = true)
    private String treatCondition;

    @Column(name = "TUNICA_VAGINAL_WIDTH", columnDefinition = "VARCHAR2|鞘膜积液长度|20|", length = 20, nullable = true)
    private String tunicaVaginalWidth;

    @Column(name = "TUNICA_VAGINAL_GIRTH", columnDefinition = "VARCHAR2|鞘膜积液周经|20|", length = 20, nullable = true)
    private String tunicaVaginalGirth;

    @Column(name = "TENDERNESS", columnDefinition = "VARCHAR2|压痛|2|", length = 2, nullable = true)
    private String tenderness;

    @Column(name = "TRANSILLUMINATION", columnDefinition = "VARCHAR2|透光试验|2|", length = 2, nullable = true)
    private String transillumination;

    @Column(name = "DRUG_H", columnDefinition = "VARCHAR2|药敏试验H|2|", length = 2, nullable = true)
    private String drugH;
    
    @Column(name = "DRUG_R", columnDefinition = "VARCHAR2|药敏试验R|2|", length = 2, nullable = true)
    private String drugR;

    @Column(name = "DRUG_E", columnDefinition = "VARCHAR2|药敏试验E|2|", length = 2, nullable = true)
    private String drugE;

    @Column(name = "DRUG_S", columnDefinition = "VARCHAR2|药敏试验S|2|", length = 2, nullable = true)
    private String drugS;

    @Column(name = "X_SOURCE", columnDefinition = "VARCHAR2|胸片来源|2|", length = 2, nullable = true)
    private String xSource;

    @Column(name = "SAMPLE_RESOURCE", columnDefinition = "VARCHAR2|标本来源|2|", length = 2, nullable = true)
    private String sampleResource;

    @Column(name = "FC_CHECK_DT", columnDefinition = "DATE|查菌检查时间||", nullable = true)
    private Date fcCheckDt;

    @Column(name = "FC_CHECK_UNIT", columnDefinition = "VARCHAR2|查菌检查单位|100|", length = 100, nullable = true)
    private String fcCheckUnit;

    @Column(name = "HGB", columnDefinition = "VARCHAR2|血红蛋白|20|", length = 20, nullable = true)
    private String hgb;

    @Column(name = "TP", columnDefinition = "VARCHAR2|总蛋白|20|", length = 20, nullable = true)
    private String tp;
    
    @Column(name = "CR", columnDefinition = "VARCHAR2|肌酐|20|", length = 20, nullable = true)
    private String cr;
    
    @Column(name = "BUN", columnDefinition = "VARCHAR2|血尿素氮|20|", length = 20, nullable = true)
    private String bun;
    
    @Column(name = "FBG", columnDefinition = "VARCHAR2|空腹血糖|20|", length = 20, nullable = true)
    private String fbg;
    
    @Column(name = "TG", columnDefinition = "VARCHAR2|甘油三酯|20|", length = 20, nullable = true)
    private String tg;
    
    @Column(name = "CHOL", columnDefinition = "VARCHAR2|总胆固醇|20|", length = 20, nullable = true)
    private String chol;
    
    @Column(name = "RIGHT_OBLIQUE_DIAMETER", columnDefinition = "VARCHAR2|右叶最大斜径|20|", length = 20, nullable = true)
    private String rightObliqueDiameter;
    
    @Column(name = "LEFT_LONG_DIAMETER", columnDefinition = "VARCHAR2|左叶长径|20|", length = 20, nullable = true)
    private String leftLongDiameter;
    
    @Column(name = "LEFT_PACHY_DIAMETER", columnDefinition = "VARCHAR2|左叶厚径|20|", length = 20, nullable = true)
    private String leftPachyDiameter;
    
    @Column(name = "LIVER_PARENCHYMA", columnDefinition = "VARCHAR2|肝实质|20|", length = 20, nullable = true)
    private String liverParenchyma;

    @Column(name = "PORTAL_VEIN_INNER_DIAMETER", columnDefinition = "VARCHAR2|门静脉内径|20|", length = 20, nullable = true)
    private String portalVeinInnerDiameter;
    
    @Column(name = "SPLEEN_LONG_DIAMETER", columnDefinition = "VARCHAR2|脾脏长径|20|", length = 20, nullable = true)
    private String spleenLongDiameter;
    
    @Column(name = "SPLEEN_PACHY_DIAMATER", columnDefinition = "VARCHAR2|脾脏厚径|20|", length = 20, nullable = true)
    private String spleenPachyDiamater;
    
    @Column(name = "SPLEEN_RIB", columnDefinition = "VARCHAR2|脾脏肋下|20|", length = 20, nullable = true)
    private String spleenRib;
    
    @Column(name = "SPLEEN_INNER_DIAMETER", columnDefinition = "VARCHAR2|脾静脉内径|20|", length = 20, nullable = true)
    private String spleenInnerDiameter;
    
    @Column(name = "CD_EXAMINE", columnDefinition = "VARCHAR2|鏄惁鎺ュ彈CD4妫�祴|20|", length = 20, nullable = true)
   	private String cdExamine;
   	@Column(name = "CD_EXAMINE_RESULT", columnDefinition = "VARCHAR2| CD4妫�祴缁撴灉|20|", length = 20, nullable = true)
   	private String cdExamineResult;
   	@Column(name = "CD_EXAMINE_DATE", columnDefinition = "VARCHAR2|CD4妫�祴鏃ユ湡||",  nullable = true)
   	private Date cdExamineDate;
   	
	@Column(name = "URINE_SUGAR", columnDefinition = "VARCHAR2|灏跨硸|20|", length = 20, nullable = true)
   	private String urineSugar;
	@Column(name = "URINE_PROPORTION", columnDefinition = "VARCHAR2|姣旈噸|20|", length = 20, nullable = true)
   	private String urineProportion;
	@Column(name = "BILE_ACID", columnDefinition = "VARCHAR2|鑳嗘眮閰竱20|", length = 20, nullable = true)
   	private String bileAcid;
	@Column(name = "DBLL", columnDefinition = "VARCHAR2|鐩存帴鑳嗙孩绱燚BLL|20|", length = 20, nullable = true)
   	private String dbll;
   	@Column(name = "IBLL", columnDefinition = "VARCHAR2|闂存帴鑳嗙孩绱爘20|", length = 20, nullable = true)
   	private String ibll;
	@Column(name = "ACP", columnDefinition = "VARCHAR2|纰辨�纾烽吀閰禔CP|20|", length = 20, nullable = true)
   	private String acp;
   	@Column(name = "GLUTAMYL_AMINOPEPTIDASE", columnDefinition = "VARCHAR2|-璋锋皑閰拌浆鑲介叾|20|", length = 20, nullable = true)
   	private String glutamylAminopeptidase;
	@Column(name = "GLOBULIN", columnDefinition = "VARCHAR2|鐞冭泲鐧絴20|", length = 20, nullable = true)
   	private String globulin;
	@Column(name = "AG", columnDefinition = "VARCHAR2|鐧界悆姣斾緥A/G|20|", length = 20, nullable = true)
   	private String ag;
	@Column(name = "ELECTROCARDIOGRAM", columnDefinition = "VARCHAR2|蹇冪數鍥緗20|", length = 20, nullable = true)
   	private String electrocardiogram;
	@Column(name = "ULTRASONIC", columnDefinition = "VARCHAR2|瓒呭０娉20|", length = 20, nullable = true)
   	private String ultrasonic;
	@Column(name = "X_RAY", columnDefinition = "VARCHAR2|X绾垮厜|20|", length = 20, nullable = true)
   	private String xRay;
	
	@Column(name = "HBSAG_POSITIVE_DT", columnDefinition = "VARCHAR2|HBsAg阳性时间|20|", length = 20, nullable = true)
	private String hbsagPositiveDt;
	
	@Column(name = "HBV_SIGN", columnDefinition = "VARCHAR2|乙肝体征是否|20|", length = 20, nullable = true)
	private String hbvSign;

	@Column(name = "HBV_SIGN_DT", columnDefinition = "DATE|乙肝体征时间||", nullable = true)
	private Date hbvSignDt;

	@Column(name = "HBC_CHECK_RESULT", columnDefinition = "VARCHAR2|抗HBc检测结果|20|", length = 20, nullable = true)
	private String hbcCheckResult;

	@Column(name = "PUNCTURE_CHECK_RESULT", columnDefinition = "VARCHAR2|肝穿检测结果|20|", length = 20, nullable = true)
	private String punctureCheckResult;

	@Column(name = "FIRST_SERUM_RECENT_DATE", columnDefinition = "DATE|第一份血标本收到日期||", nullable = true)
	private Date firstSerumRecentDate;

	@Column(name = "FIRST_SERUM_RECENT_ORG", columnDefinition = "VARCHAR2|第一份血标本检测机构|100|", length = 20, nullable = true)
	private String firstSerumRecentOrg;

	@Column(name = "FIRST_SERUM_RESULT_DATE", columnDefinition = "DATE|第一份血标本报告日期||", nullable = true)
	private Date firstSerumResultDate;

	@Column(name = "SECONED_SERUM_RECENT_DATE", columnDefinition = "DATE|第二份血标本收到日期||", nullable = true)
	private Date seconedSerumRecentDate;

	@Column(name = "SECONED_SERUM_RECENT_ORG", columnDefinition = "VARCHAR2|第二份血标本检测机构|100|", length = 20, nullable = true)
	private String seconedSerumRecentOrg;

	@Column(name = "SECONED_SERUM_RESULT_DATE", columnDefinition = "DATE|第二份血标本报告日期||", nullable = true)
	private Date seconedSerumResultDate;


	@Column(name = "IGG", columnDefinition = "VARCHAR2|麻疹IgG抗体检测|2|", length = 2, nullable = true)
	private String igg;
	@Column(name = "MZ_IGG", columnDefinition = "VARCHAR2|麻疹IgG抗体是否≥4倍升高或阳转|2|", length = 2, nullable = true)
	private String mzIgg;
	@Column(name = "FZ_IGG", columnDefinition = "VARCHAR2|风疹IgG抗体是否≥4倍升高或阳转|2|", length = 2, nullable = true)
	private String fzIgg;

	@Column(name = "IGG_ORG", columnDefinition = "VARCHAR2|麻疹IgG抗体检测机构|100|", length = 100, nullable = true)
	private String iggOrg;

	@Column(name = "IGG_RESULT_DATE", columnDefinition = "DATE|麻疹IgG抗体检测报告日期||", nullable = true)
	private Date iggResultDate;



	@Column(name = "NUCLEIC_ACID_DETECTION", columnDefinition = "VARCHAR2|是否开展核酸检测|2|", length = 2, nullable = true)
	private String nucleicAcidDetection;
	@Column(name = "ETIOLOGY_RECENT_DATE", columnDefinition = "DATE|病原学标本收到日期||", nullable = true)
	private Date etiologyRecentDate;
	@Column(name = "SAMPLE_KIND", columnDefinition = "VARCHAR2|标本类型|100|", length = 100, nullable = true)
	private String sampleKind;
	@Column(name = "SAMPLE_TREATMENT", columnDefinition = "VARCHAR2|检测方法|100|", length = 100, nullable = true)
	private String sampleTreatment;
	@Column(name = "MZ_NUCLEIC_RESULT", columnDefinition = "VARCHAR2|麻疹核酸检测结果为|2|", length = 2, nullable = true)
	private String mzNucleicResult;
	@Column(name = "MZ_RNASEP_RESULT", columnDefinition = "VARCHAR2|人RNaseP基因检测结果为|2|", length = 2, nullable = true)
	private String mzRnasepResult;
	@Column(name = "FZ_NUCLEIC_RESULT", columnDefinition = "VARCHAR2|风疹核酸检测结果为|2|", length = 2, nullable = true)
	private String fzNucleicResult;
	@Column(name = "FZ_RNASEP_RESULT", columnDefinition = "VARCHAR2|人RNaseP基因检测结果为|2|", length = 2, nullable = true)
	private String fzRnasepResult;
	@Column(name = "NUCLEIC_ACID_DETECTION_ORG", columnDefinition = "VARCHAR2|检测单位|100|", length = 100, nullable = true)
	private String nucleicAcidDetectionOrg;
	@Column(name = "NUCLEIC_RESULT_DATE", columnDefinition = "DATE|检测结果报告日期||", nullable = true)
	private Date nucleicResultDate;

	@Column(name = "B_ETIOLOGY_RECENT_DATE", columnDefinition = "DATE|病原学标本收到日期||", nullable = true)
	private Date bEtiologyRecentDate;
	@Column(name = "B_SAMPLE_KIND", columnDefinition = "VARCHAR2|标本类型|100|", length = 100, nullable = true)
	private String bSampleKind;
	@Column(name = "CELLS_VIRUS_ISOLATION", columnDefinition = "VARCHAR2|病毒分离所用细胞|2|", length = 2, nullable = true)
	private String cellsVirusIsolation;
	@Column(name = "SEPRATE_RESULT", columnDefinition = "VARCHAR2|分离鉴定结果|2|", length = 2, nullable = true)
	private String seprateResult;
	@Column(name = "B_NUCLEIC_ACID_DETECTION_ORG", columnDefinition = "VARCHAR2|检测单位|100|", length = 100, nullable = true)
	private String bNucleicAcidDetectionOrg;
	@Column(name = "B_NUCLEIC_RESULT_DATE", columnDefinition = "DATE|检测结果报告日期||", nullable = true)
	private Date bNucleicResultDate;
//麻疹基因检测
	@Column(name = "DNA_ETIOLOGY_RECENT_DATE", columnDefinition = "DATE|基因型鉴定标本收到日期||", nullable = true)
	private Date dnaEtiologyRecentDate;
	@Column(name = "DNA_SAMPLE_KIND", columnDefinition = "VARCHAR2|基因标本类型|100|", length = 100, nullable = true)
	private String dnaSampleKind;
	@Column(name = "DNA_SAMPLE_KIND_OTHER", columnDefinition = "VARCHAR2|基因标本类型其他|100|", length = 100, nullable = true)
	private String dnaSampleKindOther;
	@Column(name = "MZ_DNA_RESULT", columnDefinition = "VARCHAR2|麻疹病毒基因型鉴定结果|20|", length = 2, nullable = true)
	private String mzDnaResult;
	@Column(name = "MZ_DNA_KIND", columnDefinition = "VARCHAR2|基因型|100|", length = 100, nullable = true)
	private String mzDnaKind;
	@Column(name = "MZ_DNA_NAME", columnDefinition = "VARCHAR2|毒株命名|100|", length = 100, nullable = true)
	private String mzDnaName;
	@Column(name = "FZ_DNA_RESULT", columnDefinition = "VARCHAR2|风疹病毒基因型鉴定结果|20|", length = 2, nullable = true)
	private String fzDnaResult;
	@Column(name = "FZ_DNA_KIND", columnDefinition = "VARCHAR2|基因型|100|", length = 100, nullable = true)
	private String fzDnaKind;
	@Column(name = "FZ_DNA_NAME", columnDefinition = "VARCHAR2|毒株命名|100|", length = 100, nullable = true)
	private String fzDnaName;
	@Column(name = "DNA_NUCLEIC_ACID_DETECTION_ORG", columnDefinition = "VARCHAR2|检测单位|100|", length = 100, nullable = true)
	private String dnaNucleicAcidDetectionOrg;
	@Column(name = "DNA_NUCLEIC_RESULT_DATE", columnDefinition = "DATE|检测结果报告日期||", nullable = true)
	private Date dnaNucleicResultDate;

	//乙型脑炎
	@Column(name = "LIMPH_ONE", columnDefinition = "VARCHAR2|淋巴比例1|100|", length = 100, nullable = true)
	private String limphOne;
	@Column(name = "LIMPH_TWO", columnDefinition = "VARCHAR2|淋巴比例2|100|", length = 100, nullable = true)
	private String limphTwo;

	//布病
	@Column(name = "SLIDE_AGGLUTUNATION", columnDefinition = "VARCHAR2|玻片凝集反映|2|", length = 2, nullable = true)
	private String slideAgglutunation;
	@Column(name = "SKIN_SENSIBILITY", columnDefinition = "VARCHAR2|皮肤过敏实验|2|", length = 2, nullable = true)
	private String skinSensibility;
	@Column(name = "FIXATION", columnDefinition = "VARCHAR2|补体结合实验1:100(+ +)|2|", length = 2, nullable = true)
	private String fixation;
	@Column(name = "COMBS", columnDefinition = "VARCHAR2|Combs实验滴度为1:400(+ +)|2|", length = 2, nullable = true)
	private String combs;
	@Column(name = "B_CLINICAL", columnDefinition = "VARCHAR2|临床诊断|100|", length = 100, nullable = true)
	private String bClinical;
	//腮腺

	@Column(name = "SX_BLOOD_COLLECT", columnDefinition = "VARCHAR2|病人血标本采集|2|", length = 2, nullable = true)
	private String sxBloodCollect;
	@Column(name = "SX_COLLECT_DATE", columnDefinition = "DATE|采集日期||", nullable = true)
	private Date sxCollectDate;
	@Column(name = "SX_IGM", columnDefinition = "VARCHAR2|腮腺炎特异性IgM抗性|2|", length = 2, nullable = true)
	private String sxIgm;
	//霍乱
	@Column(name = "STOOL_RESULT_1", columnDefinition = "VARCHAR2|粪检结果1|50|", length = 50, nullable = true)
	private String stoolResult_1;
	@Column(name = "STOOL_RESULT_2", columnDefinition = "VARCHAR2|粪检结果2|50|", length = 50, nullable = true)
	private String stoolResult_2;
	@Column(name = "STOOL_RESULT_3", columnDefinition = "VARCHAR2|粪检结果3|50|", length = 50, nullable = true)
	private String stoolResult_3;
	@Column(name = "STOOL_RESULT_4", columnDefinition = "VARCHAR2|粪检结果4|50|", length = 50, nullable = true)
	private String stoolResult_4;
	@Column(name = "STOOL_RESULT_5", columnDefinition = "VARCHAR2|粪检结果5|50|", length = 50, nullable = true)
	private String stoolResult_5;
	@Column(name = "STOOL_COLLECTTIME_3", columnDefinition = "DATE|粪检时间4||", nullable = true)
	private Date stoolCollecttime_3;
	@Column(name = "STOOL_COLLECTTIME_4", columnDefinition = "DATE|粪检时间4||", nullable = true)
	private Date stoolCollecttime_4;
	@Column(name = "STOOL_COLLECTTIME_5", columnDefinition = "DATE|粪检时间5||", nullable = true)
	private Date stoolCollecttime_5;

	@Column(name = "SENSITIVE_DRUGS_ONE", columnDefinition = "VARCHAR2|敏感药品1|100|", length = 100, nullable = true)
	private String sensitiveDrugsOne;
	@Column(name = "SENSITIVE_DRUGS_TWO", columnDefinition = "VARCHAR2|敏感药品2|100|", length = 100, nullable = true)
	private String sensitiveDrugsTwo;
	@Column(name = "SENSITIVE_DRUGS_THREE", columnDefinition = "VARCHAR2|敏感药品3|100|", length = 100, nullable = true)
	private String sensitiveDrugsThree;
	@Column(name = "SENSITIVE_DRUGS_FOUR", columnDefinition = "VARCHAR2|敏感药品4|100|", length = 100, nullable = true)
	private String sensitiveDrugsFour;
	@Column(name = "SENSITIVE_DRUGS_FIVE", columnDefinition = "VARCHAR2|敏感药品5|100|", length = 100, nullable = true)
	private String sensitiveDrugsFive;

	@Column(name = "STOOL_COLLECTTIME_ONE", columnDefinition = "DATE|第1次检测时间||", nullable = true)
	private Date stoolCollecttimeOne;
	@Column(name = "STOOL_COLLECTTIME_TWO", columnDefinition = "DATE|第2次检测时间||", nullable = true)
	private Date stoolCollecttimeTwo;
	@Column(name = "STOOL_COLLECTTIME_THREE", columnDefinition = "DATE|第3次检测时间||", nullable = true)
	private Date stoolCollecttimeThree;
	@Column(name = "STOOL_COLLECTTIME_FOUR", columnDefinition = "DATE|第4次检测时间||", nullable = true)
	private Date stoolCollecttimeFour;
	@Column(name = "STOOL_COLLECTTIME_FIVE", columnDefinition = "DATE|第5次检测时间||", nullable = true)
	private Date stoolCollecttimeFive;
	@Column(name = "STOOL_RESULT_ONE", columnDefinition = "VARCHAR2|第1次检测结果|100|", length = 100, nullable = true)
	private String stoolResultOne;
	@Column(name = "STOOL_RESULT_Two", columnDefinition = "VARCHAR2|第2次检测结果|100|", length = 100, nullable = true)
	private String stoolResultTwo;
	@Column(name = "STOOL_RESULT_Three", columnDefinition = "VARCHAR2|第3次检测结果|100|", length = 100, nullable = true)
	private String stoolResultThree;
	@Column(name = "STOOL_RESULT_Four", columnDefinition = "VARCHAR2|第4次检测结果|100|", length = 100, nullable = true)
	private String stoolResultFour;
	@Column(name = "STOOL_RESULT_Five", columnDefinition = "VARCHAR2|第5次检测结果|100|", length = 100, nullable = true)
	private String stoolResultFive;
	
	@Column(name = "ALT_SCOPE", columnDefinition = "VARCHAR2|ALT正常值范围||", length = 20, nullable = true)
	private String altScope;

	@Column(name = "AST_SCOPE", columnDefinition = "VARCHAR2|AST正常值范围||", length = 20, nullable = true)
	private String astScope;
	
	@Column(name = "HBVDNA", columnDefinition = "VARCHAR2|HBVDNA||", length = 20, nullable = true)
	private String hbvdna;

	@Column(name = "HCVRNA", columnDefinition = "VARCHAR2|HCVRNA||", length = 20, nullable = true)
	private String hcvrna;
	
	@Transient
	private String stoolCollectHourFive;//第五次时间-小时
	@Transient
	private String stoolCollectHourFour;//第四次时间-小时
	@Transient
	private String stoolCollectHourThree;//第三次时间-小时
	@Transient
	private String stoolCollectHourTwo;//第二次时间-小时
	@Transient
	private String stoolCollectHourOne;//第一次时间-小时
	
	public String getHbvdna() {
		return hbvdna;
	}

	public void setHbvdna(String hbvdna) {
		this.hbvdna = hbvdna;
	}

	public String getHcvrna() {
		return hcvrna;
	}

	public void setHcvrna(String hcvrna) {
		this.hcvrna = hcvrna;
	}

	public String getAltScope() {
		return altScope;
	}

	public void setAltScope(String altScope) {
		this.altScope = altScope;
	}

	public String getAstScope() {
		return astScope;
	}

	public void setAstScope(String astScope) {
		this.astScope = astScope;
	}

	public Date getStoolCollecttimeOne() {
		return stoolCollecttimeOne;
	}

	public void setStoolCollecttimeOne(Date stoolCollecttimeOne) {
		this.stoolCollecttimeOne = stoolCollecttimeOne;
	}

	public Date getStoolCollecttimeTwo() {
		return stoolCollecttimeTwo;
	}

	public void setStoolCollecttimeTwo(Date stoolCollecttimeTwo) {
		this.stoolCollecttimeTwo = stoolCollecttimeTwo;
	}

	public Date getStoolCollecttimeThree() {
		return stoolCollecttimeThree;
	}

	public void setStoolCollecttimeThree(Date stoolCollecttimeThree) {
		this.stoolCollecttimeThree = stoolCollecttimeThree;
	}

	public Date getStoolCollecttimeFour() {
		return stoolCollecttimeFour;
	}

	public void setStoolCollecttimeFour(Date stoolCollecttimeFour) {
		this.stoolCollecttimeFour = stoolCollecttimeFour;
	}

	public Date getStoolCollecttimeFive() {
		return stoolCollecttimeFive;
	}

	public void setStoolCollecttimeFive(Date stoolCollecttimeFive) {
		this.stoolCollecttimeFive = stoolCollecttimeFive;
	}

	public String getStoolResultOne() {
		return stoolResultOne;
	}

	public void setStoolResultOne(String stoolResultOne) {
		this.stoolResultOne = stoolResultOne;
	}

	public String getStoolResultTwo() {
		return stoolResultTwo;
	}

	public void setStoolResultTwo(String stoolResultTwo) {
		this.stoolResultTwo = stoolResultTwo;
	}

	public String getStoolResultThree() {
		return stoolResultThree;
	}

	public void setStoolResultThree(String stoolResultThree) {
		this.stoolResultThree = stoolResultThree;
	}

	public String getStoolResultFour() {
		return stoolResultFour;
	}

	public void setStoolResultFour(String stoolResultFour) {
		this.stoolResultFour = stoolResultFour;
	}

	public String getStoolResultFive() {
		return stoolResultFive;
	}

	public void setStoolResultFive(String stoolResultFive) {
		this.stoolResultFive = stoolResultFive;
	}

	public String getSensitiveDrugsOne() {
		return sensitiveDrugsOne;
	}

	public void setSensitiveDrugsOne(String sensitiveDrugsOne) {
		this.sensitiveDrugsOne = sensitiveDrugsOne;
	}

	public String getSensitiveDrugsTwo() {
		return sensitiveDrugsTwo;
	}

	public void setSensitiveDrugsTwo(String sensitiveDrugsTwo) {
		this.sensitiveDrugsTwo = sensitiveDrugsTwo;
	}

	public String getSensitiveDrugsThree() {
		return sensitiveDrugsThree;
	}

	public void setSensitiveDrugsThree(String sensitiveDrugsThree) {
		this.sensitiveDrugsThree = sensitiveDrugsThree;
	}

	public String getSensitiveDrugsFour() {
		return sensitiveDrugsFour;
	}

	public void setSensitiveDrugsFour(String sensitiveDrugsFour) {
		this.sensitiveDrugsFour = sensitiveDrugsFour;
	}

	public String getSensitiveDrugsFive() {
		return sensitiveDrugsFive;
	}

	public void setSensitiveDrugsFive(String sensitiveDrugsFive) {
		this.sensitiveDrugsFive = sensitiveDrugsFive;
	}

	public String getStoolResult_1() {
		return stoolResult_1;
	}

	public void setStoolResult_1(String stoolResult_1) {
		this.stoolResult_1 = stoolResult_1;
	}

	public String getStoolResult_2() {
		return stoolResult_2;
	}

	public void setStoolResult_2(String stoolResult_2) {
		this.stoolResult_2 = stoolResult_2;
	}

	public String getStoolResult_3() {
		return stoolResult_3;
	}

	public void setStoolResult_3(String stoolResult_3) {
		this.stoolResult_3 = stoolResult_3;
	}

	public String getStoolResult_4() {
		return stoolResult_4;
	}

	public void setStoolResult_4(String stoolResult_4) {
		this.stoolResult_4 = stoolResult_4;
	}

	public String getStoolResult_5() {
		return stoolResult_5;
	}

	public void setStoolResult_5(String stoolResult_5) {
		this.stoolResult_5 = stoolResult_5;
	}

	public Date getStoolCollecttime_3() {
		return stoolCollecttime_3;
	}

	public void setStoolCollecttime_3(Date stoolCollecttime_3) {
		this.stoolCollecttime_3 = stoolCollecttime_3;
	}

	public Date getStoolCollecttime_4() {
		return stoolCollecttime_4;
	}

	public void setStoolCollecttime_4(Date stoolCollecttime_4) {
		this.stoolCollecttime_4 = stoolCollecttime_4;
	}

	public Date getStoolCollecttime_5() {
		return stoolCollecttime_5;
	}

	public void setStoolCollecttime_5(Date stoolCollecttime_5) {
		this.stoolCollecttime_5 = stoolCollecttime_5;
	}

	public String getSxBloodCollect() {
		return sxBloodCollect;
	}

	public void setSxBloodCollect(String sxBloodCollect) {
		this.sxBloodCollect = sxBloodCollect;
	}

	public Date getSxCollectDate() {
		return sxCollectDate;
	}

	public void setSxCollectDate(Date sxCollectDate) {
		this.sxCollectDate = sxCollectDate;
	}

	public String getSxIgm() {
		return sxIgm;
	}

	public void setSxIgm(String sxIgm) {
		this.sxIgm = sxIgm;
	}

	public String getbClinical() {
		return bClinical;
	}

	public void setbClinical(String bClinical) {
		this.bClinical = bClinical;
	}

	public String getSlideAgglutunation() {
		return slideAgglutunation;
	}

	public void setSlideAgglutunation(String slideAgglutunation) {
		this.slideAgglutunation = slideAgglutunation;
	}

	public String getSkinSensibility() {
		return skinSensibility;
	}

	public void setSkinSensibility(String skinSensibility) {
		this.skinSensibility = skinSensibility;
	}

	public String getFixation() {
		return fixation;
	}

	public void setFixation(String fixation) {
		this.fixation = fixation;
	}

	public String getCombs() {
		return combs;
	}

	public void setCombs(String combs) {
		this.combs = combs;
	}

	public String getLimphOne() {
		return limphOne;
	}

	public void setLimphOne(String limphOne) {
		this.limphOne = limphOne;
	}

	public String getLimphTwo() {
		return limphTwo;
	}

	public void setLimphTwo(String limphTwo) {
		this.limphTwo = limphTwo;
	}


	public String getDnaSampleKind() {
		return dnaSampleKind;
	}

	public void setDnaSampleKind(String dnaSampleKind) {
		this.dnaSampleKind = dnaSampleKind;
	}

	public String getDnaSampleKindOther() {
		return dnaSampleKindOther;
	}

	public void setDnaSampleKindOther(String dnaSampleKindOther) {
		this.dnaSampleKindOther = dnaSampleKindOther;
	}

	public String getMzDnaResult() {
		return mzDnaResult;
	}

	public void setMzDnaResult(String mzDnaResult) {
		this.mzDnaResult = mzDnaResult;
	}

	public String getMzDnaKind() {
		return mzDnaKind;
	}

	public void setMzDnaKind(String mzDnaKind) {
		this.mzDnaKind = mzDnaKind;
	}

	public String getMzDnaName() {
		return mzDnaName;
	}

	public void setMzDnaName(String mzDnaName) {
		this.mzDnaName = mzDnaName;
	}

	public String getFzDnaResult() {
		return fzDnaResult;
	}

	public void setFzDnaResult(String fzDnaResult) {
		this.fzDnaResult = fzDnaResult;
	}

	public String getFzDnaKind() {
		return fzDnaKind;
	}

	public void setFzDnaKind(String fzDnaKind) {
		this.fzDnaKind = fzDnaKind;
	}

	public String getFzDnaName() {
		return fzDnaName;
	}

	public void setFzDnaName(String fzDnaName) {
		this.fzDnaName = fzDnaName;
	}

	public String getDnaNucleicAcidDetectionOrg() {
		return dnaNucleicAcidDetectionOrg;
	}

	public void setDnaNucleicAcidDetectionOrg(String dnaNucleicAcidDetectionOrg) {
		this.dnaNucleicAcidDetectionOrg = dnaNucleicAcidDetectionOrg;
	}

	public Date getbEtiologyRecentDate() {
		return bEtiologyRecentDate;
	}

	public void setbEtiologyRecentDate(Date bEtiologyRecentDate) {
		this.bEtiologyRecentDate = bEtiologyRecentDate;
	}

	public String getbSampleKind() {
		return bSampleKind;
	}

	public void setbSampleKind(String bSampleKind) {
		this.bSampleKind = bSampleKind;
	}

	public String getCellsVirusIsolation() {
		return cellsVirusIsolation;
	}

	public void setCellsVirusIsolation(String cellsVirusIsolation) {
		this.cellsVirusIsolation = cellsVirusIsolation;
	}

	public String getSeprateResult() {
		return seprateResult;
	}

	public void setSeprateResult(String seprateResult) {
		this.seprateResult = seprateResult;
	}

	public String getbNucleicAcidDetectionOrg() {
		return bNucleicAcidDetectionOrg;
	}

	public void setbNucleicAcidDetectionOrg(String bNucleicAcidDetectionOrg) {
		this.bNucleicAcidDetectionOrg = bNucleicAcidDetectionOrg;
	}

	public Date getEtiologyRecentDate() {
		return etiologyRecentDate;
	}

	public void setEtiologyRecentDate(Date etiologyRecentDate) {
		this.etiologyRecentDate = etiologyRecentDate;
	}

	public String getSampleKind() {
		return sampleKind;
	}

	public void setSampleKind(String sampleKind) {
		this.sampleKind = sampleKind;
	}

	public String getSampleTreatment() {
		return sampleTreatment;
	}

	public void setSampleTreatment(String sampleTreatment) {
		this.sampleTreatment = sampleTreatment;
	}

	public String getMzNucleicResult() {
		return mzNucleicResult;
	}

	public void setMzNucleicResult(String mzNucleicResult) {
		this.mzNucleicResult = mzNucleicResult;
	}

	public String getMzRnasepResult() {
		return mzRnasepResult;
	}

	public void setMzRnasepResult(String mzRnasepResult) {
		this.mzRnasepResult = mzRnasepResult;
	}

	public String getFzNucleicResult() {
		return fzNucleicResult;
	}

	public void setFzNucleicResult(String fzNucleicResult) {
		this.fzNucleicResult = fzNucleicResult;
	}

	public String getFzRnasepResult() {
		return fzRnasepResult;
	}

	public void setFzRnasepResult(String fzRnasepResult) {
		this.fzRnasepResult = fzRnasepResult;
	}

	public String getNucleicAcidDetectionOrg() {
		return nucleicAcidDetectionOrg;
	}

	public void setNucleicAcidDetectionOrg(String nucleicAcidDetectionOrg) {
		this.nucleicAcidDetectionOrg = nucleicAcidDetectionOrg;
	}

	public String getNucleicAcidDetection() {
		return nucleicAcidDetection;
	}

	public void setNucleicAcidDetection(String nucleicAcidDetection) {
		this.nucleicAcidDetection = nucleicAcidDetection;
	}

	public Date getNucleicResultDate() {
		return nucleicResultDate;
	}

	public void setNucleicResultDate(Date nucleicResultDate) {
		this.nucleicResultDate = nucleicResultDate;
	}

	public Date getbNucleicResultDate() {
		return bNucleicResultDate;
	}

	public void setbNucleicResultDate(Date bNucleicResultDate) {
		this.bNucleicResultDate = bNucleicResultDate;
	}

	public Date getDnaEtiologyRecentDate() {
		return dnaEtiologyRecentDate;
	}

	public void setDnaEtiologyRecentDate(Date dnaEtiologyRecentDate) {
		this.dnaEtiologyRecentDate = dnaEtiologyRecentDate;
	}

	public Date getDnaNucleicResultDate() {
		return dnaNucleicResultDate;
	}

	public void setDnaNucleicResultDate(Date dnaNucleicResultDate) {
		this.dnaNucleicResultDate = dnaNucleicResultDate;
	}

	public String getIgg() {
		return igg;
	}

	public void setIgg(String igg) {
		this.igg = igg;
	}

	public String getMzIgg() {
		return mzIgg;
	}

	public void setMzIgg(String mzIgg) {
		this.mzIgg = mzIgg;
	}

	public String getFzIgg() {
		return fzIgg;
	}

	public void setFzIgg(String fzIgg) {
		this.fzIgg = fzIgg;
	}

	public String getIggOrg() {
		return iggOrg;
	}

	public void setIggOrg(String iggOrg) {
		this.iggOrg = iggOrg;
	}

	public Date getIggResultDate() {
		return iggResultDate;
	}

	public void setIggResultDate(Date iggResultDate) {
		this.iggResultDate = iggResultDate;
	}

	public Date getFirstSerumRecentDate() {
		return firstSerumRecentDate;
	}

	public void setFirstSerumRecentDate(Date firstSerumRecentDate) {
		this.firstSerumRecentDate = firstSerumRecentDate;
	}

	public String getFirstSerumRecentOrg() {
		return firstSerumRecentOrg;
	}

	public void setFirstSerumRecentOrg(String firstSerumRecentOrg) {
		this.firstSerumRecentOrg = firstSerumRecentOrg;
	}

	public Date getFirstSerumResultDate() {
		return firstSerumResultDate;
	}

	public void setFirstSerumResultDate(Date firstSerumResultDate) {
		this.firstSerumResultDate = firstSerumResultDate;
	}

	public Date getSeconedSerumRecentDate() {
		return seconedSerumRecentDate;
	}

	public void setSeconedSerumRecentDate(Date seconedSerumRecentDate) {
		this.seconedSerumRecentDate = seconedSerumRecentDate;
	}

	public String getSeconedSerumRecentOrg() {
		return seconedSerumRecentOrg;
	}

	public void setSeconedSerumRecentOrg(String seconedSerumRecentOrg) {
		this.seconedSerumRecentOrg = seconedSerumRecentOrg;
	}

	public Date getSeconedSerumResultDate() {
		return seconedSerumResultDate;
	}

	public void setSeconedSerumResultDate(Date seconedSerumResultDate) {
		this.seconedSerumResultDate = seconedSerumResultDate;
	}

	public String getHbsagPositiveDt() {
		return hbsagPositiveDt;
	}

	public void setHbsagPositiveDt(String hbsagPositiveDt) {
		this.hbsagPositiveDt = hbsagPositiveDt;
	}

	public String getHbvSign() {
		return hbvSign;
	}

	public void setHbvSign(String hbvSign) {
		this.hbvSign = hbvSign;
	}

	public Date getHbvSignDt() {
		return hbvSignDt;
	}

	public void setHbvSignDt(Date hbvSignDt) {
		this.hbvSignDt = hbvSignDt;
	}

	public String getHbcCheckResult() {
		return hbcCheckResult;
	}

	public void setHbcCheckResult(String hbcCheckResult) {
		this.hbcCheckResult = hbcCheckResult;
	}

	public String getPunctureCheckResult() {
		return punctureCheckResult;
	}

	public void setPunctureCheckResult(String punctureCheckResult) {
		this.punctureCheckResult = punctureCheckResult;
	}

	public String getUrineSugar() {
		return urineSugar;
	}

	public void setUrineSugar(String urineSugar) {
		this.urineSugar = urineSugar;
	}

	public String getUrineProportion() {
		return urineProportion;
	}

	public void setUrineProportion(String urineProportion) {
		this.urineProportion = urineProportion;
	}

	public String getBileAcid() {
		return bileAcid;
	}

	public void setBileAcid(String bileAcid) {
		this.bileAcid = bileAcid;
	}

	public String getDbll() {
		return dbll;
	}

	public void setDbll(String dbll) {
		this.dbll = dbll;
	}

	public String getIbll() {
		return ibll;
	}

	public void setIbll(String ibll) {
		this.ibll = ibll;
	}

	public String getAcp() {
		return acp;
	}

	public void setAcp(String acp) {
		this.acp = acp;
	}

	public String getGlutamylAminopeptidase() {
		return glutamylAminopeptidase;
	}

	public void setGlutamylAminopeptidase(String glutamylAminopeptidase) {
		this.glutamylAminopeptidase = glutamylAminopeptidase;
	}

	public String getGlobulin() {
		return globulin;
	}

	public void setGlobulin(String globulin) {
		this.globulin = globulin;
	}

	public String getAg() {
		return ag;
	}

	public void setAg(String ag) {
		this.ag = ag;
	}

	public String getElectrocardiogram() {
		return electrocardiogram;
	}

	public void setElectrocardiogram(String electrocardiogram) {
		this.electrocardiogram = electrocardiogram;
	}

	public String getUltrasonic() {
		return ultrasonic;
	}

	public void setUltrasonic(String ultrasonic) {
		this.ultrasonic = ultrasonic;
	}

	public String getxRay() {
		return xRay;
	}

	public void setxRay(String xRay) {
		this.xRay = xRay;
	}

	public String getCdExamine() {
		return cdExamine;
	}

	public void setCdExamine(String cdExamine) {
		this.cdExamine = cdExamine;
	}

	public String getCdExamineResult() {
		return cdExamineResult;
	}

	public void setCdExamineResult(String cdExamineResult) {
		this.cdExamineResult = cdExamineResult;
	}

	public Date getCdExamineDate() {
		return cdExamineDate;
	}

	public void setCdExamineDate(Date cdExamineDate) {
		this.cdExamineDate = cdExamineDate;
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

	public String getDarkFieldMicroscope() {
		return this.darkFieldMicroscope;
	}

	public void setDarkFieldMicroscope(String darkFieldMicroscope) {
		this.darkFieldMicroscope = darkFieldMicroscope;
	}

	public String getRprUsrVdr() {
		return this.rprUsrVdr;
	}

	public void setRprUsrVdr(String rprUsrVdr) {
		this.rprUsrVdr = rprUsrVdr;
	}

	public String getTppaTpha() {
		return this.tppaTpha;
	}

	public void setTppaTpha(String tppaTpha) {
		this.tppaTpha = tppaTpha;
	}

	public String getViralIsolation() {
		return this.viralIsolation;
	}

	public void setViralIsolation(String viralIsolation) {
		this.viralIsolation = viralIsolation;
	}

	public String getIdentificationVirus() {
		return this.identificationVirus;
	}

	public void setIdentificationVirus(String identificationVirus) {
		this.identificationVirus = identificationVirus;
	}

	public Date getIdentificationDate() {
		return this.identificationDate;
	}

	public void setIdentificationDate(Date identificationDate) {
		this.identificationDate = identificationDate;
	}

	public String getPairedSeraType() {
		return this.pairedSeraType;
	}

	public void setPairedSeraType(String pairedSeraType) {
		this.pairedSeraType = pairedSeraType;
	}

	public Date getPairedSeraDate() {
		return this.pairedSeraDate;
	}

	public void setPairedSeraDate(Date pairedSeraDate) {
		this.pairedSeraDate = pairedSeraDate;
	}

	public String getAntibodyAssayAntigen() {
		return this.antibodyAssayAntigen;
	}

	public void setAntibodyAssayAntigen(String antibodyAssayAntigen) {
		this.antibodyAssayAntigen = antibodyAssayAntigen;
	}

	public String getOtherDiagnosed() {
		return this.otherDiagnosed;
	}

	public void setOtherDiagnosed(String otherDiagnosed) {
		this.otherDiagnosed = otherDiagnosed;
	}

	public Date getOtherDiagnosedDate() {
		return this.otherDiagnosedDate;
	}

	public void setOtherDiagnosedDate(Date otherDiagnosedDate) {
		this.otherDiagnosedDate = otherDiagnosedDate;
	}

	public String getRoutineBlood() {
		return this.routineBlood;
	}

	public void setRoutineBlood(String routineBlood) {
		this.routineBlood = routineBlood;
	}

	public Date getRoutineBloodDate() {
		return this.routineBloodDate;
	}

	public void setRoutineBloodDate(Date routineBloodDate) {
		this.routineBloodDate = routineBloodDate;
	}

	public String getSerologically() {
		return this.serologically;
	}

	public void setSerologically(String serologically) {
		this.serologically = serologically;
	}

	public Date getSerologicallyDate() {
		return this.serologicallyDate;
	}

	public void setSerologicallyDate(Date serologicallyDate) {
		this.serologicallyDate = serologicallyDate;
	}

	public String getSerologicallyMethod() {
		return this.serologicallyMethod;
	}

	public void setSerologicallyMethod(String serologicallyMethod) {
		this.serologicallyMethod = serologicallyMethod;
	}

	public Date getSerumSpecimenDate() {
		return this.serumSpecimenDate;
	}

	public void setSerumSpecimenDate(Date serumSpecimenDate) {
		this.serumSpecimenDate = serumSpecimenDate;
	}

	public String getMeaslesIgm() {
		return this.measlesIgm;
	}

	public void setMeaslesIgm(String measlesIgm) {
		this.measlesIgm = measlesIgm;
	}

	public String getRuIgm() {
		return this.ruIgm;
	}

	public void setRuIgm(String ruIgm) {
		this.ruIgm = ruIgm;
	}

	public String getEtiologySpecimens() {
		return this.etiologySpecimens;
	}

	public void setEtiologySpecimens(String etiologySpecimens) {
		this.etiologySpecimens = etiologySpecimens;
	}

	public String getNasopharyngealSwab() {
		return this.nasopharyngealSwab;
	}

	public void setNasopharyngealSwab(String nasopharyngealSwab) {
		this.nasopharyngealSwab = nasopharyngealSwab;
	}

	public Date getNasopharyngealSwabDate() {
		return this.nasopharyngealSwabDate;
	}

	public void setNasopharyngealSwabDate(Date nasopharyngealSwabDate) {
		this.nasopharyngealSwabDate = nasopharyngealSwabDate;
	}

	public String getUrineAliquot() {
		return this.urineAliquot;
	}

	public void setUrineAliquot(String urineAliquot) {
		this.urineAliquot = urineAliquot;
	}

	public Date getUrineAliquotDate() {
		return this.urineAliquotDate;
	}

	public void setUrineAliquotDate(Date urineAliquotDate) {
		this.urineAliquotDate = urineAliquotDate;
	}

	public String getOtherSpecimen() {
		return this.otherSpecimen;
	}

	public void setOtherSpecimen(String otherSpecimen) {
		this.otherSpecimen = otherSpecimen;
	}

	public Date getOtherSpecimenDate() {
		return this.otherSpecimenDate;
	}

	public void setOtherSpecimenDate(Date otherSpecimenDate) {
		this.otherSpecimenDate = otherSpecimenDate;
	}

	public String getMorbillivirusResult() {
		return this.morbillivirusResult;
	}

	public void setMorbillivirusResult(String morbillivirusResult) {
		this.morbillivirusResult = morbillivirusResult;
	}

	public String getMorbillivirusGenotype() {
		return this.morbillivirusGenotype;
	}

	public void setMorbillivirusGenotype(String morbillivirusGenotype) {
		this.morbillivirusGenotype = morbillivirusGenotype;
	}

	public String getRubellavirusResult() {
		return this.rubellavirusResult;
	}

	public void setRubellavirusResult(String rubellavirusResult) {
		this.rubellavirusResult = rubellavirusResult;
	}

	public String getRubellavirusGenotype() {
		return this.rubellavirusGenotype;
	}

	public void setRubellavirusGenotype(String rubellavirusGenotype) {
		this.rubellavirusGenotype = rubellavirusGenotype;
	}

	public Date getSerologyDate() {
		return this.serologyDate;
	}

	public void setSerologyDate(Date serologyDate) {
		this.serologyDate = serologyDate;
	}

	public String getOx_2() {
		return this.ox_2;
	}

	public void setOx_2(String ox_2) {
		this.ox_2 = ox_2;
	}

	public String getOx_1_9() {
		return this.ox_1_9;
	}

	public void setOx_1_9(String ox_1_9) {
		this.ox_1_9 = ox_1_9;
	}

	public String getOxk() {
		return this.oxk;
	}

	public void setOxk(String oxk) {
		this.oxk = oxk;
	}

	public Date getBloodtestsDate() {
		return this.bloodtestsDate;
	}

	public void setBloodtestsDate(Date bloodtestsDate) {
		this.bloodtestsDate = bloodtestsDate;
	}

	public String getLeukocyteCount() {
		return this.leukocyteCount;
	}

	public void setLeukocyteCount(String leukocyteCount) {
		this.leukocyteCount = leukocyteCount;
	}

	public String getNeutrophilcell() {
		return this.neutrophilcell;
	}

	public void setNeutrophilcell(String neutrophilcell) {
		this.neutrophilcell = neutrophilcell;
	}

	public String getLymphocyte() {
		return this.lymphocyte;
	}

	public void setLymphocyte(String lymphocyte) {
		this.lymphocyte = lymphocyte;
	}

	public String getEosinophils() {
		return this.eosinophils;
	}

	public void setEosinophils(String eosinophils) {
		this.eosinophils = eosinophils;
	}

	public String getRbcCount() {
		return this.rbcCount;
	}

	public void setRbcCount(String rbcCount) {
		this.rbcCount = rbcCount;
	}

	public String getHemochrome() {
		return this.hemochrome;
	}

	public void setHemochrome(String hemochrome) {
		this.hemochrome = hemochrome;
	}

	public String getBasophil() {
		return this.basophil;
	}

	public void setBasophil(String basophil) {
		this.basophil = basophil;
	}

	public String getAlbumin() {
		return this.albumin;
	}

	public void setAlbumin(String albumin) {
		this.albumin = albumin;
	}

	public String getGlobulinPrecipitationTest() {
		return this.globulinPrecipitationTest;
	}

	public void setGlobulinPrecipitationTest(String globulinPrecipitationTest) {
		this.globulinPrecipitationTest = globulinPrecipitationTest;
	}

	public String getFormolgetTest() {
		return this.formolgetTest;
	}

	public void setFormolgetTest(String formolgetTest) {
		this.formolgetTest = formolgetTest;
	}

	public String getIha() {
		return this.iha;
	}

	public void setIha(String iha) {
		this.iha = iha;
	}

	public String getIfat() {
		return this.ifat;
	}

	public void setIfat(String ifat) {
		this.ifat = ifat;
	}

	public String getElisa() {
		return this.elisa;
	}

	public void setElisa(String elisa) {
		this.elisa = elisa;
	}

	public String getBonemarrowAspiration() {
		return this.bonemarrowAspiration;
	}

	public void setBonemarrowAspiration(String bonemarrowAspiration) {
		this.bonemarrowAspiration = bonemarrowAspiration;
	}

	public String getLymphnodePuncture() {
		return this.lymphnodePuncture;
	}

	public void setLymphnodePuncture(String lymphnodePuncture) {
		this.lymphnodePuncture = lymphnodePuncture;
	}

	public String getSplenicPuncture() {
		return this.splenicPuncture;
	}

	public void setSplenicPuncture(String splenicPuncture) {
		this.splenicPuncture = splenicPuncture;
	}

	public String getLiverPuncture() {
		return this.liverPuncture;
	}

	public void setLiverPuncture(String liverPuncture) {
		this.liverPuncture = liverPuncture;
	}

	public String getCulturePositive() {
		return this.culturePositive;
	}

	public void setCulturePositive(String culturePositive) {
		this.culturePositive = culturePositive;
	}

	public String getOtherCulturePositive() {
		return this.otherCulturePositive;
	}

	public void setOtherCulturePositive(String otherCulturePositive) {
		this.otherCulturePositive = otherCulturePositive;
	}

	public String getDrug() {
		return this.drug;
	}

	public void setDrug(String drug) {
		this.drug = drug;
	}

	public String getLeukocyteFlg() {
		return this.leukocyteFlg;
	}

	public void setLeukocyteFlg(String leukocyteFlg) {
		this.leukocyteFlg = leukocyteFlg;
	}

	public String getEosinophilsFlg() {
		return this.eosinophilsFlg;
	}

	public void setEosinophilsFlg(String eosinophilsFlg) {
		this.eosinophilsFlg = eosinophilsFlg;
	}

	public String getIntradermalTest() {
		return this.intradermalTest;
	}

	public void setIntradermalTest(String intradermalTest) {
		this.intradermalTest = intradermalTest;
	}

	public String getHepaticCyst() {
		return this.hepaticCyst;
	}

	public void setHepaticCyst(String hepaticCyst) {
		this.hepaticCyst = hepaticCyst;
	}

	public String getSplenicCyst() {
		return this.splenicCyst;
	}

	public void setSplenicCyst(String splenicCyst) {
		this.splenicCyst = splenicCyst;
	}

	public String getRenalCyst() {
		return this.renalCyst;
	}

	public void setRenalCyst(String renalCyst) {
		this.renalCyst = renalCyst;
	}

	public String getShadowLungs() {
		return this.shadowLungs;
	}

	public void setShadowLungs(String shadowLungs) {
		this.shadowLungs = shadowLungs;
	}

	public String getShadowOther() {
		return this.shadowOther;
	}

	public void setShadowOther(String shadowOther) {
		this.shadowOther = shadowOther;
	}

	public String getShadowBrainCyst() {
		return this.shadowBrainCyst;
	}

	public void setShadowBrainCyst(String shadowBrainCyst) {
		this.shadowBrainCyst = shadowBrainCyst;
	}

	public String getShadowPulmonaryCyst() {
		return this.shadowPulmonaryCyst;
	}

	public void setShadowPulmonaryCyst(String shadowPulmonaryCyst) {
		this.shadowPulmonaryCyst = shadowPulmonaryCyst;
	}

	public String getShadowLiverCyst() {
		return this.shadowLiverCyst;
	}

	public void setShadowLiverCyst(String shadowLiverCyst) {
		this.shadowLiverCyst = shadowLiverCyst;
	}

	public String getSampleName() {
		return this.sampleName;
	}

	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}

	public String getSerologicallyResult() {
		return this.serologicallyResult;
	}

	public void setSerologicallyResult(String serologicallyResult) {
		this.serologicallyResult = serologicallyResult;
	}

	public String getEtiologicalTestResult() {
		return this.etiologicalTestResult;
	}

	public void setEtiologicalTestResult(String etiologicalTestResult) {
		this.etiologicalTestResult = etiologicalTestResult;
	}

	public Date getReportTime() {
		return this.reportTime;
	}

	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}

	public String getOtherResult() {
		return this.otherResult;
	}

	public void setOtherResult(String otherResult) {
		this.otherResult = otherResult;
	}

	public String getHemogram() {
		return this.hemogram;
	}

	public void setHemogram(String hemogram) {
		this.hemogram = hemogram;
	}

	public String getHemogramWbc() {
		return this.hemogramWbc;
	}

	public void setHemogramWbc(String hemogramWbc) {
		this.hemogramWbc = hemogramWbc;
	}

	public String getHemogramN() {
		return this.hemogramN;
	}

	public void setHemogramN(String hemogramN) {
		this.hemogramN = hemogramN;
	}

	public String getHemogramL() {
		return this.hemogramL;
	}

	public void setHemogramL(String hemogramL) {
		this.hemogramL = hemogramL;
	}

	public String getCerebrospinalPressure() {
		return this.cerebrospinalPressure;
	}

	public void setCerebrospinalPressure(String cerebrospinalPressure) {
		this.cerebrospinalPressure = cerebrospinalPressure;
	}

	public String getCerebrospinalAspect() {
		return this.cerebrospinalAspect;
	}

	public void setCerebrospinalAspect(String cerebrospinalAspect) {
		this.cerebrospinalAspect = cerebrospinalAspect;
	}

	public String getCerebrospinalcellCount() {
		return this.cerebrospinalcellCount;
	}

	public void setCerebrospinalcellCount(String cerebrospinalcellCount) {
		this.cerebrospinalcellCount = cerebrospinalcellCount;
	}

	public String getCerebrospinalProtein() {
		return this.cerebrospinalProtein;
	}

	public void setCerebrospinalProtein(String cerebrospinalProtein) {
		this.cerebrospinalProtein = cerebrospinalProtein;
	}

	public String getCerebrospinalSugar() {
		return this.cerebrospinalSugar;
	}

	public void setCerebrospinalSugar(String cerebrospinalSugar) {
		this.cerebrospinalSugar = cerebrospinalSugar;
	}

	public String getXrayTestResult() {
		return this.xrayTestResult;
	}

	public void setXrayTestResult(String xrayTestResult) {
		this.xrayTestResult = xrayTestResult;
	}

	public String getXrayTestExpression() {
		return this.xrayTestExpression;
	}

	public void setXrayTestExpression(String xrayTestExpression) {
		this.xrayTestExpression = xrayTestExpression;
	}

	public String getMuscleCalpain() {
		return this.muscleCalpain;
	}

	public void setMuscleCalpain(String muscleCalpain) {
		this.muscleCalpain = muscleCalpain;
	}

	public String getMyoglobin() {
		return this.myoglobin;
	}

	public void setMyoglobin(String myoglobin) {
		this.myoglobin = myoglobin;
	}

	public String getGonococcusTest() {
		return this.gonococcusTest;
	}

	public void setGonococcusTest(String gonococcusTest) {
		this.gonococcusTest = gonococcusTest;
	}

	public String getGonococcusCulture() {
		return this.gonococcusCulture;
	}

	public void setGonococcusCulture(String gonococcusCulture) {
		this.gonococcusCulture = gonococcusCulture;
	}

	public String getRbpt() {
		return this.rbpt;
	}

	public void setRbpt(String rbpt) {
		this.rbpt = rbpt;
	}

	public String getPathogenIsolation() {
		return this.pathogenIsolation;
	}

	public void setPathogenIsolation(String pathogenIsolation) {
		this.pathogenIsolation = pathogenIsolation;
	}

	public String getTiterSat() {
		return this.titerSat;
	}

	public void setTiterSat(String titerSat) {
		this.titerSat = titerSat;
	}

	public String getOtherTest() {
		return this.otherTest;
	}

	public void setOtherTest(String otherTest) {
		this.otherTest = otherTest;
	}

	public Date getDiphtheriaIggDwelltime() {
		return this.diphtheriaIggDwelltime;
	}

	public void setDiphtheriaIggDwelltime(Date diphtheriaIggDwelltime) {
		this.diphtheriaIggDwelltime = diphtheriaIggDwelltime;
	}

	public String getDiphtheriaIggResult() {
		return this.diphtheriaIggResult;
	}

	public void setDiphtheriaIggResult(String diphtheriaIggResult) {
		this.diphtheriaIggResult = diphtheriaIggResult;
	}

	public Date getDiphtheriaCultureDwelltime_1() {
		return this.diphtheriaCultureDwelltime_1;
	}

	public void setDiphtheriaCultureDwelltime_1(Date diphtheriaCultureDwelltime_1) {
		this.diphtheriaCultureDwelltime_1 = diphtheriaCultureDwelltime_1;
	}

	public String getDiphtheriaCultureResult_1() {
		return this.diphtheriaCultureResult_1;
	}

	public void setDiphtheriaCultureResult_1(String diphtheriaCultureResult_1) {
		this.diphtheriaCultureResult_1 = diphtheriaCultureResult_1;
	}

	public Date getDiphtheriaCultureDwelltime_2() {
		return this.diphtheriaCultureDwelltime_2;
	}

	public void setDiphtheriaCultureDwelltime_2(Date diphtheriaCultureDwelltime_2) {
		this.diphtheriaCultureDwelltime_2 = diphtheriaCultureDwelltime_2;
	}

	public String getDiphtheriaCultureResult_2() {
		return this.diphtheriaCultureResult_2;
	}

	public void setDiphtheriaCultureResult_2(String diphtheriaCultureResult_2) {
		this.diphtheriaCultureResult_2 = diphtheriaCultureResult_2;
	}

	public Date getDiphtheriaToxDwelltime_1() {
		return this.diphtheriaToxDwelltime_1;
	}

	public void setDiphtheriaToxDwelltime_1(Date diphtheriaToxDwelltime_1) {
		this.diphtheriaToxDwelltime_1 = diphtheriaToxDwelltime_1;
	}

	public String getDiphtheriaToxResult_1() {
		return this.diphtheriaToxResult_1;
	}

	public void setDiphtheriaToxResult_1(String diphtheriaToxResult_1) {
		this.diphtheriaToxResult_1 = diphtheriaToxResult_1;
	}

	public Date getDiphtheriaToxDwelltime_2() {
		return this.diphtheriaToxDwelltime_2;
	}

	public void setDiphtheriaToxDwelltime_2(Date diphtheriaToxDwelltime_2) {
		this.diphtheriaToxDwelltime_2 = diphtheriaToxDwelltime_2;
	}

	public String getDiphtheriaToxResult_2() {
		return this.diphtheriaToxResult_2;
	}

	public void setDiphtheriaToxResult_2(String diphtheriaToxResult_2) {
		this.diphtheriaToxResult_2 = diphtheriaToxResult_2;
	}

	public String getCerebrospinalLeukocyteCount() {
		return this.cerebrospinalLeukocyteCount;
	}

	public void setCerebrospinalLeukocyteCount(String cerebrospinalLeukocyteCount) {
		this.cerebrospinalLeukocyteCount = cerebrospinalLeukocyteCount;
	}

	public String getCerebrospinalChloride() {
		return this.cerebrospinalChloride;
	}

	public void setCerebrospinalChloride(String cerebrospinalChloride) {
		this.cerebrospinalChloride = cerebrospinalChloride;
	}

	public String getLabDiagnosis() {
		return this.labDiagnosis;
	}

	public void setLabDiagnosis(String labDiagnosis) {
		this.labDiagnosis = labDiagnosis;
	}

	public String getCultureCerebrospinal() {
		return this.cultureCerebrospinal;
	}

	public void setCultureCerebrospinal(String cultureCerebrospinal) {
		this.cultureCerebrospinal = cultureCerebrospinal;
	}

	public String getCerebrospinalSpecAntigen() {
		return this.cerebrospinalSpecAntigen;
	}

	public void setCerebrospinalSpecAntigen(String cerebrospinalSpecAntigen) {
		this.cerebrospinalSpecAntigen = cerebrospinalSpecAntigen;
	}

	public String getCerebrospinalNm() {
		return this.cerebrospinalNm;
	}

	public void setCerebrospinalNm(String cerebrospinalNm) {
		this.cerebrospinalNm = cerebrospinalNm;
	}

	public String getPetechiaGnid() {
		return this.petechiaGnid;
	}

	public void setPetechiaGnid(String petechiaGnid) {
		this.petechiaGnid = petechiaGnid;
	}

	public String getBloodCulture() {
		return this.bloodCulture;
	}

	public void setBloodCulture(String bloodCulture) {
		this.bloodCulture = bloodCulture;
	}

	public String getBloodNmDna() {
		return this.bloodNmDna;
	}

	public void setBloodNmDna(String bloodNmDna) {
		this.bloodNmDna = bloodNmDna;
	}

	public String getSerologyAntibody() {
		return this.serologyAntibody;
	}

	public void setSerologyAntibody(String serologyAntibody) {
		this.serologyAntibody = serologyAntibody;
	}

	public String getSensitivityResult() {
		return this.sensitivityResult;
	}

	public void setSensitivityResult(String sensitivityResult) {
		this.sensitivityResult = sensitivityResult;
	}

	public String getsensitiveDrugs_1() {
		return this.sensitiveDrugs_1;
	}

	public void setsensitiveDrugs_1(String sensitiveDrugs_1) {
		this.sensitiveDrugs_1 = sensitiveDrugs_1;
	}

	public String getsensitiveDrugs_2() {
		return this.sensitiveDrugs_2;
	}

	public void setsensitiveDrugs_2(String sensitiveDrugs_2) {
		this.sensitiveDrugs_2 = sensitiveDrugs_2;
	}

	public String getsensitiveDrugs_3() {
		return this.sensitiveDrugs_3;
	}

	public void setsensitiveDrugs_3(String sensitiveDrugs_3) {
		this.sensitiveDrugs_3 = sensitiveDrugs_3;
	}

	public String getsensitiveDrugs_4() {
		return this.sensitiveDrugs_4;
	}

	public void setsensitiveDrugs_4(String sensitiveDrugs_4) {
		this.sensitiveDrugs_4 = sensitiveDrugs_4;
	}

	public String getsensitiveDrugs_5() {
		return this.sensitiveDrugs_5;
	}

	public void setsensitiveDrugs_5(String sensitiveDrugs_5) {
		this.sensitiveDrugs_5 = sensitiveDrugs_5;
	}

	public String getDejectaLeukocyte() {
		return this.dejectaLeukocyte;
	}

	public void setDejectaLeukocyte(String dejectaLeukocyte) {
		this.dejectaLeukocyte = dejectaLeukocyte;
	}

	public String getDejectaErythrocyte() {
		return this.dejectaErythrocyte;
	}

	public void setDejectaErythrocyte(String dejectaErythrocyte) {
		this.dejectaErythrocyte = dejectaErythrocyte;
	}

	public String getAmoebaTrophozoiteS() {
		return this.amoebaTrophozoiteS;
	}

	public void setAmoebaTrophozoiteS(String amoebaTrophozoiteS) {
		this.amoebaTrophozoiteS = amoebaTrophozoiteS;
	}

	public String getAmoebaTrophozoiteB() {
		return this.amoebaTrophozoiteB;
	}

	public void setAmoebaTrophozoiteB(String amoebaTrophozoiteB) {
		this.amoebaTrophozoiteB = amoebaTrophozoiteB;
	}

	public String getStoolCulture() {
		return this.stoolCulture;
	}

	public void setStoolCulture(String stoolCulture) {
		this.stoolCulture = stoolCulture;
	}

	public String getCuffButter() {
		return this.cuffButter;
	}

	public void setCuffButter(String cuffButter) {
		this.cuffButter = cuffButter;
	}

	public String getLeukocyteCountFlg() {
		return this.leukocyteCountFlg;
	}

	public void setLeukocyteCountFlg(String leukocyteCountFlg) {
		this.leukocyteCountFlg = leukocyteCountFlg;
	}

	public String getPlateletReduce() {
		return this.plateletReduce;
	}

	public void setPlateletReduce(String plateletReduce) {
		this.plateletReduce = plateletReduce;
	}

	public String getHematokrit() {
		return this.hematokrit;
	}

	public void setHematokrit(String hematokrit) {
		this.hematokrit = hematokrit;
	}

	public String getHaemorrhageTime() {
		return this.haemorrhageTime;
	}

	public void setHaemorrhageTime(String haemorrhageTime) {
		this.haemorrhageTime = haemorrhageTime;
	}

	public String getCruorTime() {
		return this.cruorTime;
	}

	public void setCruorTime(String cruorTime) {
		this.cruorTime = cruorTime;
	}

	public String getUrineRoutine() {
		return this.urineRoutine;
	}

	public void setUrineRoutine(String urineRoutine) {
		this.urineRoutine = urineRoutine;
	}

	public String getLiverFunction() {
		return this.liverFunction;
	}

	public void setLiverFunction(String liverFunction) {
		this.liverFunction = liverFunction;
	}

	public Date getDengueIggCollectTime() {
		return this.dengueIggCollectTime;
	}

	public void setDengueIggCollectTime(Date dengueIggCollectTime) {
		this.dengueIggCollectTime = dengueIggCollectTime;
	}

	public String getDengueIggTestMethod() {
		return this.dengueIggTestMethod;
	}

	public void setDengueIggTestMethod(String dengueIggTestMethod) {
		this.dengueIggTestMethod = dengueIggTestMethod;
	}

	public String getDengueIggTestResult() {
		return this.dengueIggTestResult;
	}

	public void setDengueIggTestResult(String dengueIggTestResult) {
		this.dengueIggTestResult = dengueIggTestResult;
	}

	public Date getDengueIgmCollectTime() {
		return this.dengueIgmCollectTime;
	}

	public void setDengueIgmCollectTime(Date dengueIgmCollectTime) {
		this.dengueIgmCollectTime = dengueIgmCollectTime;
	}

	public String getDengueIgmTestMethod() {
		return this.dengueIgmTestMethod;
	}

	public void setDengueIgmTestMethod(String dengueIgmTestMethod) {
		this.dengueIgmTestMethod = dengueIgmTestMethod;
	}

	public String getDengueIgmTestResult() {
		return this.dengueIgmTestResult;
	}

	public void setDengueIgmTestResult(String dengueIgmTestResult) {
		this.dengueIgmTestResult = dengueIgmTestResult;
	}

	public Date getDengueSeparateCollectTime() {
		return this.dengueSeparateCollectTime;
	}

	public void setDengueSeparateCollectTime(Date dengueSeparateCollectTime) {
		this.dengueSeparateCollectTime = dengueSeparateCollectTime;
	}

	public String getDengueSeparateTestMethod() {
		return this.dengueSeparateTestMethod;
	}

	public void setDengueSeparateTestMethod(String dengueSeparateTestMethod) {
		this.dengueSeparateTestMethod = dengueSeparateTestMethod;
	}

	public String getDengueSeparateTestResult() {
		return this.dengueSeparateTestResult;
	}

	public void setDengueSeparateTestResult(String dengueSeparateTestResult) {
		this.dengueSeparateTestResult = dengueSeparateTestResult;
	}

	public Date getDengueAntigenCollectTime() {
		return this.dengueAntigenCollectTime;
	}

	public void setDengueAntigenCollectTime(Date dengueAntigenCollectTime) {
		this.dengueAntigenCollectTime = dengueAntigenCollectTime;
	}

	public String getDengueAntigenTestMethod() {
		return this.dengueAntigenTestMethod;
	}

	public void setDengueAntigenTestMethod(String dengueAntigenTestMethod) {
		this.dengueAntigenTestMethod = dengueAntigenTestMethod;
	}

	public String getDengueAntigenTestResult() {
		return this.dengueAntigenTestResult;
	}

	public void setDengueAntigenTestResult(String dengueAntigenTestResult) {
		this.dengueAntigenTestResult = dengueAntigenTestResult;
	}

	public String getSerumCollectFlg() {
		return this.serumCollectFlg;
	}

	public void setSerumCollectFlg(String serumCollectFlg) {
		this.serumCollectFlg = serumCollectFlg;
	}

	public Date getSerumReportTime() {
		return this.serumReportTime;
	}

	public void setSerumReportTime(Date serumReportTime) {
		this.serumReportTime = serumReportTime;
	}

	public String getSerumMethod() {
		return this.serumMethod;
	}

	public void setSerumMethod(String serumMethod) {
		this.serumMethod = serumMethod;
	}

	public String getSerumJeAntibodyIgm() {
		return this.serumJeAntibodyIgm;
	}

	public void setSerumJeAntibodyIgm(String serumJeAntibodyIgm) {
		this.serumJeAntibodyIgm = serumJeAntibodyIgm;
	}

	public String getSerumJeAntibodyIgg() {
		return this.serumJeAntibodyIgg;
	}

	public void setSerumJeAntibodyIgg(String serumJeAntibodyIgg) {
		this.serumJeAntibodyIgg = serumJeAntibodyIgg;
	}

	public String getSerumJeIggTiter() {
		return this.serumJeIggTiter;
	}

	public void setSerumJeIggTiter(String serumJeIggTiter) {
		this.serumJeIggTiter = serumJeIggTiter;
	}

	public String getFirstSerum() {
		return this.firstSerum;
	}

	public void setFirstSerum(String firstSerum) {
		this.firstSerum = firstSerum;
	}

	public Date getFirstSerumCollectTime() {
		return this.firstSerumCollectTime;
	}

	public void setFirstSerumCollectTime(Date firstSerumCollectTime) {
		this.firstSerumCollectTime = firstSerumCollectTime;
	}

	public Date getFirstSerumReportTime() {
		return this.firstSerumReportTime;
	}

	public void setFirstSerumReportTime(Date firstSerumReportTime) {
		this.firstSerumReportTime = firstSerumReportTime;
	}

	public String getFirstSerumMethod() {
		return this.firstSerumMethod;
	}

	public void setFirstSerumMethod(String firstSerumMethod) {
		this.firstSerumMethod = firstSerumMethod;
	}

	public String getFirstSerumJeAntibodyIgm() {
		return this.firstSerumJeAntibodyIgm;
	}

	public void setFirstSerumJeAntibodyIgm(String firstSerumJeAntibodyIgm) {
		this.firstSerumJeAntibodyIgm = firstSerumJeAntibodyIgm;
	}

	public String getFirstSerumJeAntibodyIgg() {
		return this.firstSerumJeAntibodyIgg;
	}

	public void setFirstSerumJeAntibodyIgg(String firstSerumJeAntibodyIgg) {
		this.firstSerumJeAntibodyIgg = firstSerumJeAntibodyIgg;
	}

	public String getFirstSerumJeIggTiter() {
		return this.firstSerumJeIggTiter;
	}

	public void setFirstSerumJeIggTiter(String firstSerumJeIggTiter) {
		this.firstSerumJeIggTiter = firstSerumJeIggTiter;
	}

	public String getSecondSerum() {
		return this.secondSerum;
	}

	public void setSecondSerum(String secondSerum) {
		this.secondSerum = secondSerum;
	}

	public Date getSecondSerumCollectTime() {
		return this.secondSerumCollectTime;
	}

	public void setSecondSerumCollectTime(Date secondSerumCollectTime) {
		this.secondSerumCollectTime = secondSerumCollectTime;
	}

	public Date getSecondSerumReportTime() {
		return this.secondSerumReportTime;
	}

	public void setSecondSerumReportTime(Date secondSerumReportTime) {
		this.secondSerumReportTime = secondSerumReportTime;
	}

	public String getSecondSerumMethod() {
		return this.secondSerumMethod;
	}

	public void setSecondSerumMethod(String secondSerumMethod) {
		this.secondSerumMethod = secondSerumMethod;
	}

	public String getSecondSerumJeAntibodyIgm() {
		return this.secondSerumJeAntibodyIgm;
	}

	public void setSecondSerumJeAntibodyIgm(String secondSerumJeAntibodyIgm) {
		this.secondSerumJeAntibodyIgm = secondSerumJeAntibodyIgm;
	}

	public String getSecondSerumJeAntibodyIgg() {
		return this.secondSerumJeAntibodyIgg;
	}

	public void setSecondSerumJeAntibodyIgg(String secondSerumJeAntibodyIgg) {
		this.secondSerumJeAntibodyIgg = secondSerumJeAntibodyIgg;
	}

	public String getSecondSerumJeIggTiter() {
		return this.secondSerumJeIggTiter;
	}

	public void setSecondSerumJeIggTiter(String secondSerumJeIggTiter) {
		this.secondSerumJeIggTiter = secondSerumJeIggTiter;
	}

	public String getCsfCheck() {
		return this.csfCheck;
	}

	public void setCsfCheck(String csfCheck) {
		this.csfCheck = csfCheck;
	}

	public Date getCsfCheckCollectTime() {
		return this.csfCheckCollectTime;
	}

	public void setCsfCheckCollectTime(Date csfCheckCollectTime) {
		this.csfCheckCollectTime = csfCheckCollectTime;
	}

	public Date getCsfCheckReportTime() {
		return this.csfCheckReportTime;
	}

	public void setCsfCheckReportTime(Date csfCheckReportTime) {
		this.csfCheckReportTime = csfCheckReportTime;
	}

	public String getCsfPhysicsTest() {
		return this.csfPhysicsTest;
	}

	public void setCsfPhysicsTest(String csfPhysicsTest) {
		this.csfPhysicsTest = csfPhysicsTest;
	}

	public String getCsfCell() {
		return this.csfCell;
	}

	public void setCsfCell(String csfCell) {
		this.csfCell = csfCell;
	}

	public String getCsfAlbumen() {
		return this.csfAlbumen;
	}

	public void setCsfAlbumen(String csfAlbumen) {
		this.csfAlbumen = csfAlbumen;
	}

	public String getCsfSugar() {
		return this.csfSugar;
	}

	public void setCsfSugar(String csfSugar) {
		this.csfSugar = csfSugar;
	}

	public String getCsfSugarCount() {
		return this.csfSugarCount;
	}

	public void setCsfSugarCount(String csfSugarCount) {
		this.csfSugarCount = csfSugarCount;
	}

	public String getCsfChloride() {
		return this.csfChloride;
	}

	public void setCsfChloride(String csfChloride) {
		this.csfChloride = csfChloride;
	}

	public String getCsfChlorideCount() {
		return this.csfChlorideCount;
	}

	public void setCsfChlorideCount(String csfChlorideCount) {
		this.csfChlorideCount = csfChlorideCount;
	}

	public String getCsfJeAntibody() {
		return this.csfJeAntibody;
	}

	public void setCsfJeAntibody(String csfJeAntibody) {
		this.csfJeAntibody = csfJeAntibody;
	}

	public String getJeViralIsolation() {
		return this.jeViralIsolation;
	}

	public void setJeViralIsolation(String jeViralIsolation) {
		this.jeViralIsolation = jeViralIsolation;
	}

	public String getJeViralIsolationSample() {
		return this.jeViralIsolationSample;
	}

	public void setJeViralIsolationSample(String jeViralIsolationSample) {
		this.jeViralIsolationSample = jeViralIsolationSample;
	}

	public Date getJeViralIsolationTime() {
		return this.jeViralIsolationTime;
	}

	public void setJeViralIsolationTime(Date jeViralIsolationTime) {
		this.jeViralIsolationTime = jeViralIsolationTime;
	}

	public String getJeViralIsolationResult() {
		return this.jeViralIsolationResult;
	}

	public void setJeViralIsolationResult(String jeViralIsolationResult) {
		this.jeViralIsolationResult = jeViralIsolationResult;
	}

	public String getJeViralIdentiResult() {
		return this.jeViralIdentiResult;
	}

	public void setJeViralIdentiResult(String jeViralIdentiResult) {
		this.jeViralIdentiResult = jeViralIdentiResult;
	}

	public String getJeViralPcr() {
		return this.jeViralPcr;
	}

	public void setJeViralPcr(String jeViralPcr) {
		this.jeViralPcr = jeViralPcr;
	}

	public String getSampleClass() {
		return this.sampleClass;
	}

	public void setSampleClass(String sampleClass) {
		this.sampleClass = sampleClass;
	}

	public String getTestItem() {
		return this.testItem;
	}

	public void setTestItem(String testItem) {
		this.testItem = testItem;
	}

	public String getTestResult() {
		return this.testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

	public String getUrineProtein() {
		return this.urineProtein;
	}

	public void setUrineProtein(String urineProtein) {
		this.urineProtein = urineProtein;
	}

	public String getCylinderuriaFlg() {
		return this.cylinderuriaFlg;
	}

	public void setCylinderuriaFlg(String cylinderuriaFlg) {
		this.cylinderuriaFlg = cylinderuriaFlg;
	}

	public Date getEhfIggCollecttime() {
		return this.ehfIggCollecttime;
	}

	public void setEhfIggCollecttime(Date ehfIggCollecttime) {
		this.ehfIggCollecttime = ehfIggCollecttime;
	}

	public String getEhfIggTestMethod() {
		return this.ehfIggTestMethod;
	}

	public void setEhfIggTestMethod(String ehfIggTestMethod) {
		this.ehfIggTestMethod = ehfIggTestMethod;
	}

	public String getEhfIggTestResult() {
		return this.ehfIggTestResult;
	}

	public void setEhfIggTestResult(String ehfIggTestResult) {
		this.ehfIggTestResult = ehfIggTestResult;
	}

	public Date getEhfIgmCollecttime() {
		return this.ehfIgmCollecttime;
	}

	public void setEhfIgmCollecttime(Date ehfIgmCollecttime) {
		this.ehfIgmCollecttime = ehfIgmCollecttime;
	}

	public String getEhfIgmTestMethod() {
		return this.ehfIgmTestMethod;
	}

	public void setEhfIgmTestMethod(String ehfIgmTestMethod) {
		this.ehfIgmTestMethod = ehfIgmTestMethod;
	}

	public String getEhfIgmTestResult() {
		return this.ehfIgmTestResult;
	}

	public void setEhfIgmTestResult(String ehfIgmTestResult) {
		this.ehfIgmTestResult = ehfIgmTestResult;
	}

	public Date getHantavirusCollectime() {
		return this.hantavirusCollectime;
	}

	public void setHantavirusCollectime(Date hantavirusCollectime) {
		this.hantavirusCollectime = hantavirusCollectime;
	}

	public String getHantavirusTestMethod() {
		return this.hantavirusTestMethod;
	}

	public void setHantavirusTestMethod(String hantavirusTestMethod) {
		this.hantavirusTestMethod = hantavirusTestMethod;
	}

	public String getHantavirusTestResult() {
		return this.hantavirusTestResult;
	}

	public void setHantavirusTestResult(String hantavirusTestResult) {
		this.hantavirusTestResult = hantavirusTestResult;
	}

	public String getSerumSpecimenF() {
		return this.serumSpecimenF;
	}

	public void setSerumSpecimenF(String serumSpecimenF) {
		this.serumSpecimenF = serumSpecimenF;
	}

	public Date getSerumSpecimenDtF() {
		return this.serumSpecimenDtF;
	}

	public void setSerumSpecimenDtF(Date serumSpecimenDtF) {
		this.serumSpecimenDtF = serumSpecimenDtF;
	}

	public String getSerumSpecimenS() {
		return this.serumSpecimenS;
	}

	public void setSerumSpecimenS(String serumSpecimenS) {
		this.serumSpecimenS = serumSpecimenS;
	}

	public Date getSerumSpecimenDtS() {
		return this.serumSpecimenDtS;
	}

	public void setSerumSpecimenDtS(Date serumSpecimenDtS) {
		this.serumSpecimenDtS = serumSpecimenDtS;
	}

	public String getFirstSerumMeaslesIgm() {
		return this.firstSerumMeaslesIgm;
	}

	public void setFirstSerumMeaslesIgm(String firstSerumMeaslesIgm) {
		this.firstSerumMeaslesIgm = firstSerumMeaslesIgm;
	}

	public String getFirstSerumRubellaIgm() {
		return this.firstSerumRubellaIgm;
	}

	public void setFirstSerumRubellaIgm(String firstSerumRubellaIgm) {
		this.firstSerumRubellaIgm = firstSerumRubellaIgm;
	}

	public String getSecondSerumMeaslesIgm() {
		return this.secondSerumMeaslesIgm;
	}

	public void setSecondSerumMeaslesIgm(String secondSerumMeaslesIgm) {
		this.secondSerumMeaslesIgm = secondSerumMeaslesIgm;
	}

	public String getSecondSerumRubellaIgm() {
		return this.secondSerumRubellaIgm;
	}

	public void setSecondSerumRubellaIgm(String secondSerumRubellaIgm) {
		this.secondSerumRubellaIgm = secondSerumRubellaIgm;
	}

	public Date getStoolCollecttime_1() {
		return this.stoolCollecttime_1;
	}

	public void setStoolCollecttime_1(Date stoolCollecttime_1) {
		this.stoolCollecttime_1 = stoolCollecttime_1;
	}

	public String getStoolCollectname_1() {
		return this.stoolCollectname_1;
	}

	public void setStoolCollectname_1(String stoolCollectname_1) {
		this.stoolCollectname_1 = stoolCollectname_1;
	}

	public String getStoolCollectunit_1() {
		return this.stoolCollectunit_1;
	}

	public void setStoolCollectunit_1(String stoolCollectunit_1) {
		this.stoolCollectunit_1 = stoolCollectunit_1;
	}

	public Date getProvincialReceiveDate_1() {
		return this.provincialReceiveDate_1;
	}

	public void setProvincialReceiveDate_1(Date provincialReceiveDate_1) {
		this.provincialReceiveDate_1 = provincialReceiveDate_1;
	}

	public String getWithIceFlg_1() {
		return this.withIceFlg_1;
	}

	public void setWithIceFlg_1(String withIceFlg_1) {
		this.withIceFlg_1 = withIceFlg_1;
	}

	public String getSampleStatus_1() {
		return this.sampleStatus_1;
	}

	public void setSampleStatus_1(String sampleStatus_1) {
		this.sampleStatus_1 = sampleStatus_1;
	}

	public String getSampleNumber_1() {
		return this.sampleNumber_1;
	}

	public void setSampleNumber_1(String sampleNumber_1) {
		this.sampleNumber_1 = sampleNumber_1;
	}

	public String getViralIsolationFlg_1() {
		return this.viralIsolationFlg_1;
	}

	public void setViralIsolationFlg_1(String viralIsolationFlg_1) {
		this.viralIsolationFlg_1 = viralIsolationFlg_1;
	}

	public Date getVaccinateDate_1() {
		return this.vaccinateDate_1;
	}

	public void setVaccinateDate_1(Date vaccinateDate_1) {
		this.vaccinateDate_1 = vaccinateDate_1;
	}

	public String getPoliovirusGroupFlg_1() {
		return this.poliovirusGroupFlg_1;
	}

	public void setPoliovirusGroupFlg_1(String poliovirusGroupFlg_1) {
		this.poliovirusGroupFlg_1 = poliovirusGroupFlg_1;
	}

	public String getViralType_1_1() {
		return this.viralType_1_1;
	}

	public void setViralType_1_1(String viralType_1_1) {
		this.viralType_1_1 = viralType_1_1;
	}

	public String getViralType_2_1() {
		return this.viralType_2_1;
	}

	public void setViralType_2_1(String viralType_2_1) {
		this.viralType_2_1 = viralType_2_1;
	}

	public String getViralType_3_1() {
		return this.viralType_3_1;
	}

	public void setViralType_3_1(String viralType_3_1) {
		this.viralType_3_1 = viralType_3_1;
	}

	public String getOtherEnterovirus_1() {
		return this.otherEnterovirus_1;
	}

	public void setOtherEnterovirus_1(String otherEnterovirus_1) {
		this.otherEnterovirus_1 = otherEnterovirus_1;
	}

	public Date getResultReportDate_1() {
		return this.resultReportDate_1;
	}

	public void setResultReportDate_1(Date resultReportDate_1) {
		this.resultReportDate_1 = resultReportDate_1;
	}

	public Date getNationalReceiveDate_1() {
		return this.nationalReceiveDate_1;
	}

	public void setNationalReceiveDate_1(Date nationalReceiveDate_1) {
		this.nationalReceiveDate_1 = nationalReceiveDate_1;
	}

	public Date getNationalReportDate_1() {
		return this.nationalReportDate_1;
	}

	public void setNationalReportDate_1(Date nationalReportDate_1) {
		this.nationalReportDate_1 = nationalReportDate_1;
	}

	public Date getstoolCollecttime_2() {
		return this.stoolCollecttime_2;
	}

	public void setstoolCollecttime_2(Date stoolCollecttime_2) {
		this.stoolCollecttime_2 = stoolCollecttime_2;
	}

	public String getstoolCollectname_2() {
		return this.stoolCollectname_2;
	}

	public void setstoolCollectname_2(String stoolCollectname_2) {
		this.stoolCollectname_2 = stoolCollectname_2;
	}

	public String getstoolCollectunit_2() {
		return this.stoolCollectunit_2;
	}

	public void setstoolCollectunit_2(String stoolCollectunit_2) {
		this.stoolCollectunit_2 = stoolCollectunit_2;
	}

	public Date getprovincialReceiveDate_2() {
		return this.provincialReceiveDate_2;
	}

	public void setprovincialReceiveDate_2(Date provincialReceiveDate_2) {
		this.provincialReceiveDate_2 = provincialReceiveDate_2;
	}

	public String getwithIceFlg_2() {
		return this.withIceFlg_2;
	}

	public void setwithIceFlg_2(String withIceFlg_2) {
		this.withIceFlg_2 = withIceFlg_2;
	}

	public String getsampleStatus_2() {
		return this.sampleStatus_2;
	}

	public void setsampleStatus_2(String sampleStatus_2) {
		this.sampleStatus_2 = sampleStatus_2;
	}

	public String getsampleNumber_2() {
		return this.sampleNumber_2;
	}

	public void setsampleNumber_2(String sampleNumber_2) {
		this.sampleNumber_2 = sampleNumber_2;
	}

	public String getviralIsolationFlg_2() {
		return this.viralIsolationFlg_2;
	}

	public void setviralIsolationFlg_2(String viralIsolationFlg_2) {
		this.viralIsolationFlg_2 = viralIsolationFlg_2;
	}

	public Date getvaccinateDate_2() {
		return this.vaccinateDate_2;
	}

	public void setvaccinateDate_2(Date vaccinateDate_2) {
		this.vaccinateDate_2 = vaccinateDate_2;
	}

	public String getpoliovirusGroupFlg_2() {
		return this.poliovirusGroupFlg_2;
	}

	public void setpoliovirusGroupFlg_2(String poliovirusGroupFlg_2) {
		this.poliovirusGroupFlg_2 = poliovirusGroupFlg_2;
	}

	public String getViralType_1_2() {
		return this.viralType_1_2;
	}

	public void setViralType_1_2(String viralType_1_2) {
		this.viralType_1_2 = viralType_1_2;
	}

	public String getViralType_2_2() {
		return this.viralType_2_2;
	}

	public void setViralType_2_2(String viralType_2_2) {
		this.viralType_2_2 = viralType_2_2;
	}

	public String getViralType_3_2() {
		return this.viralType_3_2;
	}

	public void setViralType_3_2(String viralType_3_2) {
		this.viralType_3_2 = viralType_3_2;
	}

	public String getOtherEnterovirus_2() {
		return this.otherEnterovirus_2;
	}

	public void setOtherEnterovirus_2(String otherEnterovirus_2) {
		this.otherEnterovirus_2 = otherEnterovirus_2;
	}

	public Date getResultReportDate_2() {
		return this.resultReportDate_2;
	}

	public void setResultReportDate_2(Date resultReportDate_2) {
		this.resultReportDate_2 = resultReportDate_2;
	}

	public Date getNationalReceiveDate_2() {
		return this.nationalReceiveDate_2;
	}

	public void setNationalReceiveDate_2(Date nationalReceiveDate_2) {
		this.nationalReceiveDate_2 = nationalReceiveDate_2;
	}

	public Date getNationalReportDate_2() {
		return this.nationalReportDate_2;
	}

	public void setNationalReportDate_2(Date nationalReportDate_2) {
		this.nationalReportDate_2 = nationalReportDate_2;
	}

	public String getPoliomyelitisType_1() {
		return this.poliomyelitisType_1;
	}

	public void setPoliomyelitisType_1(String poliomyelitisType_1) {
		this.poliomyelitisType_1 = poliomyelitisType_1;
	}

	public String getPoliomyelitisType_2() {
		return this.poliomyelitisType_2;
	}

	public void setPoliomyelitisType_2(String poliomyelitisType_2) {
		this.poliomyelitisType_2 = poliomyelitisType_2;
	}

	public String getPoliomyelitisType_3() {
		return this.poliomyelitisType_3;
	}

	public void setPoliomyelitisType_3(String poliomyelitisType_3) {
		this.poliomyelitisType_3 = poliomyelitisType_3;
	}

	public String getPolioVaccineVirusType_1() {
		return this.polioVaccineVirusType_1;
	}

	public void setPolioVaccineVirusType_1(String polioVaccineVirusType_1) {
		this.polioVaccineVirusType_1 = polioVaccineVirusType_1;
	}

	public String getPolioVaccineVirusType_2() {
		return this.polioVaccineVirusType_2;
	}

	public void setPolioVaccineVirusType_2(String polioVaccineVirusType_2) {
		this.polioVaccineVirusType_2 = polioVaccineVirusType_2;
	}

	public String getPolioVaccineVirusType_3() {
		return this.polioVaccineVirusType_3;
	}

	public void setPolioVaccineVirusType_3(String polioVaccineVirusType_3) {
		this.polioVaccineVirusType_3 = polioVaccineVirusType_3;
	}

	public String getVdpvType_1() {
		return this.vdpvType_1;
	}

	public void setVdpvType_1(String vdpvType_1) {
		this.vdpvType_1 = vdpvType_1;
	}

	public String getVdpvType_2() {
		return this.vdpvType_2;
	}

	public void setVdpvType_2(String vdpvType_2) {
		this.vdpvType_2 = vdpvType_2;
	}

	public String getVdpvType_3() {
		return this.vdpvType_3;
	}

	public void setVdpvType_3(String vdpvType_3) {
		this.vdpvType_3 = vdpvType_3;
	}

	public String getOtherEnterovirus() {
		return this.otherEnterovirus;
	}

	public void setOtherEnterovirus(String otherEnterovirus) {
		this.otherEnterovirus = otherEnterovirus;
	}

	public String getUndetermined() {
		return this.undetermined;
	}

	public void setUndetermined(String undetermined) {
		this.undetermined = undetermined;
	}

	public Date getInspectionReportDate() {
		return this.inspectionReportDate;
	}

	public void setInspectionReportDate(Date inspectionReportDate) {
		this.inspectionReportDate = inspectionReportDate;
	}

	public String getAlt() {
		return this.alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getAst() {
		return this.ast;
	}

	public void setAst(String ast) {
		this.ast = ast;
	}

	public String getTbil() {
		return this.tbil;
	}

	public void setTbil(String tbil) {
		this.tbil = tbil;
	}

	public String getHavIgm() {
		return this.havIgm;
	}

	public void setHavIgm(String havIgm) {
		this.havIgm = havIgm;
	}

	public String getHbsag() {
		return this.hbsag;
	}

	public void setHbsag(String hbsag) {
		this.hbsag = hbsag;
	}

	public String getAntiHbs() {
		return this.antiHbs;
	}

	public void setAntiHbs(String antiHbs) {
		this.antiHbs = antiHbs;
	}

	public String getHbeag() {
		return this.hbeag;
	}

	public void setHbeag(String hbeag) {
		this.hbeag = hbeag;
	}

	public String getAntiHbe() {
		return this.antiHbe;
	}

	public void setAntiHbe(String antiHbe) {
		this.antiHbe = antiHbe;
	}

	public String getAntiHbcIgm() {
		return this.antiHbcIgm;
	}

	public void setAntiHbcIgm(String antiHbcIgm) {
		this.antiHbcIgm = antiHbcIgm;
	}

	public String getAntiHcvIgm() {
		return this.antiHcvIgm;
	}

	public void setAntiHcvIgm(String antiHcvIgm) {
		this.antiHcvIgm = antiHcvIgm;
	}

	public String getAntiHdvIgm() {
		return this.antiHdvIgm;
	}

	public void setAntiHdvIgm(String antiHdvIgm) {
		this.antiHdvIgm = antiHdvIgm;
	}

	public String getAntiHevIgm() {
		return this.antiHevIgm;
	}

	public void setAntiHevIgm(String antiHevIgm) {
		this.antiHevIgm = antiHevIgm;
	}

	public String getFirstLeukocyteCount() {
		return this.firstLeukocyteCount;
	}

	public void setFirstLeukocyteCount(String firstLeukocyteCount) {
		this.firstLeukocyteCount = firstLeukocyteCount;
	}

	public String getFirstNeutrophilic() {
		return this.firstNeutrophilic;
	}

	public void setFirstNeutrophilic(String firstNeutrophilic) {
		this.firstNeutrophilic = firstNeutrophilic;
	}

	public String getFirstLymphocyteCount() {
		return this.firstLymphocyteCount;
	}

	public void setFirstLymphocyteCount(String firstLymphocyteCount) {
		this.firstLymphocyteCount = firstLymphocyteCount;
	}

	public String getAdmissionLeukocyteCount() {
		return this.admissionLeukocyteCount;
	}

	public void setAdmissionLeukocyteCount(String admissionLeukocyteCount) {
		this.admissionLeukocyteCount = admissionLeukocyteCount;
	}

	public String getAdmissionNeutrophilic() {
		return this.admissionNeutrophilic;
	}

	public void setAdmissionNeutrophilic(String admissionNeutrophilic) {
		this.admissionNeutrophilic = admissionNeutrophilic;
	}

	public String getAdmissionLymphocyteCount() {
		return this.admissionLymphocyteCount;
	}

	public void setAdmissionLymphocyteCount(String admissionLymphocyteCount) {
		this.admissionLymphocyteCount = admissionLymphocyteCount;
	}

	public Date getChestXrayFirstTime() {
		return this.chestXrayFirstTime;
	}

	public void setChestXrayFirstTime(Date chestXrayFirstTime) {
		this.chestXrayFirstTime = chestXrayFirstTime;
	}

	public String getChestXrayFirstResult() {
		return this.chestXrayFirstResult;
	}

	public void setChestXrayFirstResult(String chestXrayFirstResult) {
		this.chestXrayFirstResult = chestXrayFirstResult;
	}

	public String getChestXrayFirstOther() {
		return this.chestXrayFirstOther;
	}

	public void setChestXrayFirstOther(String chestXrayFirstOther) {
		this.chestXrayFirstOther = chestXrayFirstOther;
	}

	public Date getChestXrayAdmissionTime() {
		return this.chestXrayAdmissionTime;
	}

	public void setChestXrayAdmissionTime(Date chestXrayAdmissionTime) {
		this.chestXrayAdmissionTime = chestXrayAdmissionTime;
	}

	public String getChestXrayAdmissionResult() {
		return this.chestXrayAdmissionResult;
	}

	public void setChestXrayAdmissionResult(String chestXrayAdmissionResult) {
		this.chestXrayAdmissionResult = chestXrayAdmissionResult;
	}

	public String getChestXrayAdmissionOther() {
		return this.chestXrayAdmissionOther;
	}

	public void setChestXrayAdmissionOther(String chestXrayAdmissionOther) {
		this.chestXrayAdmissionOther = chestXrayAdmissionOther;
	}

	public String getChestXrayResult() {
		return this.chestXrayResult;
	}

	public void setChestXrayResult(String chestXrayResult) {
		this.chestXrayResult = chestXrayResult;
	}

	public Date getFirstDrawbloodTime() {
		return this.firstDrawbloodTime;
	}

	public void setFirstDrawbloodTime(Date firstDrawbloodTime) {
		this.firstDrawbloodTime = firstDrawbloodTime;
	}

	public String getFirstSarsIgm() {
		return this.firstSarsIgm;
	}

	public void setFirstSarsIgm(String firstSarsIgm) {
		this.firstSarsIgm = firstSarsIgm;
	}

	public String getFirstSarsIgg() {
		return this.firstSarsIgg;
	}

	public void setFirstSarsIgg(String firstSarsIgg) {
		this.firstSarsIgg = firstSarsIgg;
	}

	public String getFirstSarsAnti() {
		return this.firstSarsAnti;
	}

	public void setFirstSarsAnti(String firstSarsAnti) {
		this.firstSarsAnti = firstSarsAnti;
	}

	public Date getSecondDrawbloodTime() {
		return this.secondDrawbloodTime;
	}

	public void setSecondDrawbloodTime(Date secondDrawbloodTime) {
		this.secondDrawbloodTime = secondDrawbloodTime;
	}

	public String getSecondSarsIgm() {
		return this.secondSarsIgm;
	}

	public void setSecondSarsIgm(String secondSarsIgm) {
		this.secondSarsIgm = secondSarsIgm;
	}

	public String getSecondSarsIgg() {
		return this.secondSarsIgg;
	}

	public void setSecondSarsIgg(String secondSarsIgg) {
		this.secondSarsIgg = secondSarsIgg;
	}

	public String getSecondSarsAnti() {
		return this.secondSarsAnti;
	}

	public void setSecondSarsAnti(String secondSarsAnti) {
		this.secondSarsAnti = secondSarsAnti;
	}

	public Date getStoolCollecttime() {
		return this.stoolCollecttime;
	}

	public void setStoolCollecttime(Date stoolCollecttime) {
		this.stoolCollecttime = stoolCollecttime;
	}

	public String getStoolPcr() {
		return this.stoolPcr;
	}

	public void setStoolPcr(String stoolPcr) {
		this.stoolPcr = stoolPcr;
	}

	public String getStoolRtPcr() {
		return this.stoolRtPcr;
	}

	public void setStoolRtPcr(String stoolRtPcr) {
		this.stoolRtPcr = stoolRtPcr;
	}

	public String getStoolSequencing() {
		return this.stoolSequencing;
	}

	public void setStoolSequencing(String stoolSequencing) {
		this.stoolSequencing = stoolSequencing;
	}

	public String getStoolViralIsolation() {
		return this.stoolViralIsolation;
	}

	public void setStoolViralIsolation(String stoolViralIsolation) {
		this.stoolViralIsolation = stoolViralIsolation;
	}

	public Date getThroatSwabCollecttime() {
		return this.throatSwabCollecttime;
	}

	public void setThroatSwabCollecttime(Date throatSwabCollecttime) {
		this.throatSwabCollecttime = throatSwabCollecttime;
	}

	public String getThroatSwabPcr() {
		return this.throatSwabPcr;
	}

	public void setThroatSwabPcr(String throatSwabPcr) {
		this.throatSwabPcr = throatSwabPcr;
	}

	public String getThroatSwabRtPcr() {
		return this.throatSwabRtPcr;
	}

	public void setThroatSwabRtPcr(String throatSwabRtPcr) {
		this.throatSwabRtPcr = throatSwabRtPcr;
	}

	public String getThroatSwabSequencing() {
		return this.throatSwabSequencing;
	}

	public void setThroatSwabSequencing(String throatSwabSequencing) {
		this.throatSwabSequencing = throatSwabSequencing;
	}

	public String getThroatSwabViralIsolation() {
		return this.throatSwabViralIsolation;
	}

	public void setThroatSwabViralIsolation(String throatSwabViralIsolation) {
		this.throatSwabViralIsolation = throatSwabViralIsolation;
	}

	public Date getPhlegmCollecttime() {
		return this.phlegmCollecttime;
	}

	public void setPhlegmCollecttime(Date phlegmCollecttime) {
		this.phlegmCollecttime = phlegmCollecttime;
	}

	public String getPhlegmPcr() {
		return this.phlegmPcr;
	}

	public void setPhlegmPcr(String phlegmPcr) {
		this.phlegmPcr = phlegmPcr;
	}

	public String getPhlegmRtPcr() {
		return this.phlegmRtPcr;
	}

	public void setPhlegmRtPcr(String phlegmRtPcr) {
		this.phlegmRtPcr = phlegmRtPcr;
	}

	public String getPhlegmSequencing() {
		return this.phlegmSequencing;
	}

	public void setPhlegmSequencing(String phlegmSequencing) {
		this.phlegmSequencing = phlegmSequencing;
	}

	public String getPhlegmViralIsolation() {
		return this.phlegmViralIsolation;
	}

	public void setPhlegmViralIsolation(String phlegmViralIsolation) {
		this.phlegmViralIsolation = phlegmViralIsolation;
	}

	public Date getBloodCollecttime() {
		return this.bloodCollecttime;
	}

	public void setBloodCollecttime(Date bloodCollecttime) {
		this.bloodCollecttime = bloodCollecttime;
	}

	public String getBloodPcr() {
		return this.bloodPcr;
	}

	public void setBloodPcr(String bloodPcr) {
		this.bloodPcr = bloodPcr;
	}

	public String getBloodRtPcr() {
		return this.bloodRtPcr;
	}

	public void setBloodRtPcr(String bloodRtPcr) {
		this.bloodRtPcr = bloodRtPcr;
	}

	public String getBloodSequencing() {
		return this.bloodSequencing;
	}

	public void setBloodSequencing(String bloodSequencing) {
		this.bloodSequencing = bloodSequencing;
	}

	public String getBloodViralIsolation() {
		return this.bloodViralIsolation;
	}

	public void setBloodViralIsolation(String bloodViralIsolation) {
		this.bloodViralIsolation = bloodViralIsolation;
	}

	public String getChestXrays() {
		return this.chestXrays;
	}

	public void setChestXrays(String chestXrays) {
		this.chestXrays = chestXrays;
	}

	public String getPertussis() {
		return this.pertussis;
	}

	public void setPertussis(String pertussis) {
		this.pertussis = pertussis;
	}

	public Date getPertussisDt() {
		return this.pertussisDt;
	}

	public void setPertussisDt(Date pertussisDt) {
		this.pertussisDt = pertussisDt;
	}

	public Date getDiphtheriaIggRecoverDt() {
		return this.diphtheriaIggRecoverDt;
	}

	public void setDiphtheriaIggRecoverDt(Date diphtheriaIggRecoverDt) {
		this.diphtheriaIggRecoverDt = diphtheriaIggRecoverDt;
	}

	public String getDiphtheriaIggReResult() {
		return this.diphtheriaIggReResult;
	}

	public void setDiphtheriaIggReResult(String diphtheriaIggReResult) {
		this.diphtheriaIggReResult = diphtheriaIggReResult;
	}
	
    public String getsampleNumberFlag_1() {
		return sampleNumberFlag_1;
	}

	public void setsampleNumberFlag_1(String sampleNumberFlag_1) {
		this.sampleNumberFlag_1 = sampleNumberFlag_1;
	}

	public String getsampleNumberFlag_2() {
		return sampleNumberFlag_2;
	}

	public void setsampleNumberFlag_2(String sampleNumberFlag_2) {
		this.sampleNumberFlag_2 = sampleNumberFlag_2;
	}



	/*检测结果报告时间-小时*/
    @Transient
    private String reportHour;

    public String getReportHour() {
        return reportHour;
    }

    public void setReportHour(String reportHour) {
        this.reportHour = reportHour;
    }

    public String getxNo() {
        return this.xNo;
    }

    public void setxNo(String xNo) {
        this.xNo = xNo;
    }

    public String getHeartCheck() {
        return this.heartCheck;
    }

    public void setHeartCheck(String heartCheck) {
        this.heartCheck = heartCheck;
    }

    public String getLiverCheck() {
        return this.liverCheck;
    }

    public void setLiverCheck(String liverCheck) {
        this.liverCheck = liverCheck;
    }

    public String getKidneyCheck() {
        return this.kidneyCheck;
    }

    public void setKidneyCheck(String kidneyCheck) {
        this.kidneyCheck = kidneyCheck;
    }

    public String getOther() {
        return this.other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getTuberculinTest() {
        return this.tuberculinTest;
    }

    public void setTuberculinTest(String tuberculinTest) {
        this.tuberculinTest = tuberculinTest;
    }

    public String getCavity() {
		return cavity;
	}

	public void setCavity(String cavity) {
		this.cavity = cavity;
	}

	public String getCavityScale() {
        return this.cavityScale;
    }

    public void setCavityScale(String cavityScale) {
        this.cavityScale = cavityScale;
    }

    public Date getPicReportDt() {
        return this.picReportDt;
    }

    public void setPicReportDt(Date picReportDt) {
        this.picReportDt = picReportDt;
    }

    public Date getCultureReportDt() {
        return this.cultureReportDt;
    }

    public void setCultureReportDt(Date cultureReportDt) {
        this.cultureReportDt = cultureReportDt;
    }

    public String getDrugResult1() {
        return this.drugResult1;
    }

    public void setDrugResult1(String drugResult1) {
        this.drugResult1 = drugResult1;
    }

    public String getDrugResult2() {
        return this.drugResult2;
    }

    public void setDrugResult2(String drugResult2) {
        this.drugResult2 = drugResult2;
    }

    public Date getDrugReportDt() {
        return this.drugReportDt;
    }

    public void setDrugReportDt(Date drugReportDt) {
        this.drugReportDt = drugReportDt;
    }

    public String getHivResult() {
        return this.hivResult;
    }

    public void setHivResult(String hivResult) {
        this.hivResult = hivResult;
    }

    public String getHivCd4() {
        return this.hivCd4;
    }

    public void setHivCd4(String hivCd4) {
        this.hivCd4 = hivCd4;
    }

    public Date getHivReportDt() {
        return this.hivReportDt;
    }

    public void setHivReportDt(Date hivReportDt) {
        this.hivReportDt = hivReportDt;
    }

    public String getCavityFlag() {
        return this.cavityFlag;
    }

    public void setCavityFlag(String cavityFlag) {
        this.cavityFlag = cavityFlag;
    }

    public String getsputum_2() {
        return this.sputum_2;
    }

    public void setsputum_2(String sputum_2) {
        this.sputum_2 = sputum_2;
    }

    public String getsputum_3() {
        return this.sputum_3;
    }

    public void setsputum_3(String sputum_3) {
        this.sputum_3 = sputum_3;
    }

    public Date getTestDt() {
        return this.testDt;
    }

    public void setTestDt(Date testDt) {
        this.testDt = testDt;
    }

    public String getTestUser() {
        return this.testUser;
    }

    public void setTestUser(String testUser) {
        this.testUser = testUser;
    }

    public Date getPlasmodiumDt() {
        return this.plasmodiumDt;
    }

    public void setPlasmodiumDt(Date plasmodiumDt) {
        this.plasmodiumDt = plasmodiumDt;
    }

    public String getRdt() {
        return this.rdt;
    }

    public void setRdt(String rdt) {
        this.rdt = rdt;
    }

    public String getIhaCheck() {
        return this.ihaCheck;
    }

    public void setIhaCheck(String ihaCheck) {
        this.ihaCheck = ihaCheck;
    }

    public Date getIhaDt() {
        return this.ihaDt;
    }

    public void setIhaDt(Date ihaDt) {
        this.ihaDt = ihaDt;
    }

    public String getDdia() {
        return this.ddia;
    }

    public void setDdia(String ddia) {
        this.ddia = ddia;
    }

    public Date getDdiaDt() {
        return this.ddiaDt;
    }

    public void setDdiaDt(Date ddiaDt) {
        this.ddiaDt = ddiaDt;
    }

    public String getCopt() {
        return this.copt;
    }

    public void setCopt(String copt) {
        this.copt = copt;
    }

    public Date getCoptDt() {
        return this.coptDt;
    }

    public void setCoptDt(Date coptDt) {
        this.coptDt = coptDt;
    }

    public String getStool() {
        return this.stool;
    }

    public void setStool(String stool) {
        this.stool = stool;
    }

    public Date getStoolDt() {
        return this.stoolDt;
    }

    public void setStoolDt(Date stoolDt) {
        this.stoolDt = stoolDt;
    }

    public String getOneThree() {
        return this.oneThree;
    }

    public void setOneThree(String oneThree) {
        this.oneThree = oneThree;
    }

    public String getB() {
        return this.b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getGgt() {
        return this.ggt;
    }

    public void setGgt(String ggt) {
        this.ggt = ggt;
    }

    public String getSplenicCheck() {
        return this.splenicCheck;
    }

    public void setSplenicCheck(String splenicCheck) {
        this.splenicCheck = splenicCheck;
    }

    public String getAscites() {
        return this.ascites;
    }

    public void setAscites(String ascites) {
        this.ascites = ascites;
    }

    public Date getCheckDt() {
        return this.checkDt;
    }

    public void setCheckDt(Date checkDt) {
        this.checkDt = checkDt;
    }

    public String getCheckUnit() {
        return this.checkUnit;
    }

    public void setCheckUnit(String checkUnit) {
        this.checkUnit = checkUnit;
    }

    public String getFungusCondition() {
        return this.fungusCondition;
    }

    public void setFungusCondition(String fungusCondition) {
        this.fungusCondition = fungusCondition;
    }

    public String getBi() {
        return this.bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public String getUnCheckResult() {
        return this.unCheckResult;
    }

    public void setUnCheckResult(String unCheckResult) {
        this.unCheckResult = unCheckResult;
    }

    public String getAfb() {
        return this.afb;
    }

    public void setAfb(String afb) {
        this.afb = afb;
    }

    public String getPathologyNo() {
        return this.pathologyNo;
    }

    public void setPathologyNo(String pathologyNo) {
        this.pathologyNo = pathologyNo;
    }

    public String getUrineGuise() {
        return this.urineGuise;
    }

    public void setUrineGuise(String urineGuise) {
        this.urineGuise = urineGuise;
    }

    public String getUrineHard() {
        return this.urineHard;
    }

    public void setUrineHard(String urineHard) {
        this.urineHard = urineHard;
    }

    public String getChy() {
        return this.chy;
    }

    public void setChy(String chy) {
        this.chy = chy;
    }

    public String getTreatCondition() {
        return this.treatCondition;
    }

    public void setTreatCondition(String treatCondition) {
        this.treatCondition = treatCondition;
    }

    public String getTunicaVaginalWidth() {
        return tunicaVaginalWidth;
    }

    public void setTunicaVaginalWidth(String tunicaVaginalWidth) {
        this.tunicaVaginalWidth = tunicaVaginalWidth;
    }

    public String getTunicaVaginalGirth() {
        return tunicaVaginalGirth;
    }

    public void setTunicaVaginalGirth(String tunicaVaginalGirth) {
        this.tunicaVaginalGirth = tunicaVaginalGirth;
    }

    public String getTenderness() {
        return this.tenderness;
    }

    public void setTenderness(String tenderness) {
        this.tenderness = tenderness;
    }

    public String getTransillumination() {
        return this.transillumination;
    }

    public void setTransillumination(String transillumination) {
        this.transillumination = transillumination;
    }

	public String getPhlegmPcrResult() {
		return phlegmPcrResult;
	}

	public void setPhlegmPcrResult(String phlegmPcrResult) {
		this.phlegmPcrResult = phlegmPcrResult;
	}

	public String getPhlegmRtPcrResult() {
		return phlegmRtPcrResult;
	}

	public void setPhlegmRtPcrResult(String phlegmRtPcrResult) {
		this.phlegmRtPcrResult = phlegmRtPcrResult;
	}

	public String getDrugH() {
		return drugH;
	}

	public void setDrugH(String drugH) {
		this.drugH = drugH;
	}

	public String getDrugR() {
		return drugR;
	}

	public void setDrugR(String drugR) {
		this.drugR = drugR;
	}

	public String getDrugE() {
		return drugE;
	}

	public void setDrugE(String drugE) {
		this.drugE = drugE;
	}

	public String getDrugS() {
		return drugS;
	}

	public void setDrugS(String drugS) {
		this.drugS = drugS;
	}

    public String getxSource() {
        return xSource;
    }

    public void setxSource(String xSource) {
        this.xSource = xSource;
    }

	/**
	 * @return the sampleResource
	 */
	public String getSampleResource() {
		return sampleResource;
	}

	/**
	 * @param sampleResource the sampleResource to set
	 */
	public void setSampleResource(String sampleResource) {
		this.sampleResource = sampleResource;
	}

    public Date getFcCheckDt() {
        return this.fcCheckDt;
    }

    public void setFcCheckDt(Date fcCheckDt) {
        this.fcCheckDt = fcCheckDt;
    }

    public String getFcCheckUnit() {
        return this.fcCheckUnit;
    }

    public void setFcCheckUnit(String fcCheckUnit) {
        this.fcCheckUnit = fcCheckUnit;
    }

	public String getHgb() {
		return hgb;
	}

	public void setHgb(String hgb) {
		this.hgb = hgb;
	}

	public String getTp() {
		return tp;
	}

	public void setTp(String tp) {
		this.tp = tp;
	}

	public String getCr() {
		return cr;
	}

	public void setCr(String cr) {
		this.cr = cr;
	}

	public String getBun() {
		return bun;
	}

	public void setBun(String bun) {
		this.bun = bun;
	}

	public String getFbg() {
		return fbg;
	}

	public void setFbg(String fbg) {
		this.fbg = fbg;
	}

	public String getTg() {
		return tg;
	}

	public void setTg(String tg) {
		this.tg = tg;
	}

	public String getChol() {
		return chol;
	}

	public void setChol(String chol) {
		this.chol = chol;
	}

	public String getRightObliqueDiameter() {
		return rightObliqueDiameter;
	}

	public void setRightObliqueDiameter(String rightObliqueDiameter) {
		this.rightObliqueDiameter = rightObliqueDiameter;
	}

	public String getLeftLongDiameter() {
		return leftLongDiameter;
	}

	public void setLeftLongDiameter(String leftLongDiameter) {
		this.leftLongDiameter = leftLongDiameter;
	}

	public String getLeftPachyDiameter() {
		return leftPachyDiameter;
	}

	public void setLeftPachyDiameter(String leftPachyDiameter) {
		this.leftPachyDiameter = leftPachyDiameter;
	}

	public String getLiverParenchyma() {
		return liverParenchyma;
	}

	public void setLiverParenchyma(String liverParenchyma) {
		this.liverParenchyma = liverParenchyma;
	}

	public String getPortalVeinInnerDiameter() {
		return portalVeinInnerDiameter;
	}

	public void setPortalVeinInnerDiameter(String portalVeinInnerDiameter) {
		this.portalVeinInnerDiameter = portalVeinInnerDiameter;
	}

	public String getSpleenLongDiameter() {
		return spleenLongDiameter;
	}

	public void setSpleenLongDiameter(String spleenLongDiameter) {
		this.spleenLongDiameter = spleenLongDiameter;
	}

	public String getSpleenPachyDiamater() {
		return spleenPachyDiamater;
	}

	public void setSpleenPachyDiamater(String spleenPachyDiamater) {
		this.spleenPachyDiamater = spleenPachyDiamater;
	}

	public String getSpleenRib() {
		return spleenRib;
	}

	public void setSpleenRib(String spleenRib) {
		this.spleenRib = spleenRib;
	}

	public String getSpleenInnerDiameter() {
		return spleenInnerDiameter;
	}

	public void setSpleenInnerDiameter(String spleenInnerDiameter) {
		this.spleenInnerDiameter = spleenInnerDiameter;
	}

	public String getStoolCollectHourFive() {
		return stoolCollectHourFive;
	}

	public void setStoolCollectHourFive(String stoolCollectHourFive) {
		this.stoolCollectHourFive = stoolCollectHourFive;
	}

	public String getStoolCollectHourFour() {
		return stoolCollectHourFour;
	}

	public void setStoolCollectHourFour(String stoolCollectHourFour) {
		this.stoolCollectHourFour = stoolCollectHourFour;
	}

	public String getStoolCollectHourThree() {
		return stoolCollectHourThree;
	}

	public void setStoolCollectHourThree(String stoolCollectHourThree) {
		this.stoolCollectHourThree = stoolCollectHourThree;
	}

	public String getStoolCollectHourTwo() {
		return stoolCollectHourTwo;
	}

	public void setStoolCollectHourTwo(String stoolCollectHourTwo) {
		this.stoolCollectHourTwo = stoolCollectHourTwo;
	}

	public String getStoolCollectHourOne() {
		return stoolCollectHourOne;
	}

	public void setStoolCollectHourOne(String stoolCollectHourOne) {
		this.stoolCollectHourOne = stoolCollectHourOne;
	}
	
}
