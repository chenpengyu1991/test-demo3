package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 *暴露史
 */
@Entity
@Table(name = "IDM_EXPOSURE_HISTORY")
public class ExposureHistory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编码|11|", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "ADDR_PROVINCE", columnDefinition = "VARCHAR2|暴露详细地址省|2|", length = 2, nullable = true)
	private String addrProvince;

	@Column(name = "ADDR_CITY", columnDefinition = "VARCHAR2|暴露详细地址市|2|", length = 2, nullable = true)
	private String addrCity;

	@Column(name = "ADDR_COUNTY", columnDefinition = "VARCHAR2|暴露详细地址县|2|", length = 2, nullable = true)
	private String addrCounty;

	@Column(name = "ADDR_RURAL", columnDefinition = "VARCHAR2|暴露详细地址乡|100|", length = 100, nullable = true)
	private String addrRural;

	@Column(name = "ADDR_VILLAGE", columnDefinition = "VARCHAR2|暴露详细地址村|100|", length = 100, nullable = true)
	private String addrVillage;

	@Column(name = "ADDR_GROUP", columnDefinition = "VARCHAR2|暴露详细地址组|100|", length = 100, nullable = true)
	private String addrGroup;

	@Column(name = "EXPOSURE_WAY", columnDefinition = "VARCHAR2|暴露方式|2|", length = 2, nullable = true)
	private String exposureWay;

	@Column(name = "EXPOSURE_LEVEL", columnDefinition = "VARCHAR2|暴露程度|2|", length = 2, nullable = true)
	private String exposureLevel;

	@Column(name = "EXPOSURE_PART", columnDefinition = "VARCHAR2|暴露部位|200|", length = 200, nullable = true)
	private String exposurePart;

	@Column(name = "WOUND_MANAGEMENT", columnDefinition = "VARCHAR2|伤口处理|2|", length = 2, nullable = true)
	private String woundManagement;

	@Column(name = "HANDLING_TIME", columnDefinition = "DATE|处理时间||", nullable = true)
	private Date handlingTime;

	@Column(name = "HANDLING_UNIT", columnDefinition = "VARCHAR2|处理单位|2|", length = 2, nullable = true)
	private String handlingUnit;

	@Column(name = "HANDLING_UNIT_OTHER", columnDefinition = "VARCHAR2|处理单位其他|100|", length = 100, nullable = true)
	private String handlingUnitOther;

	@Column(name = "HANDLING_WAY", columnDefinition = "VARCHAR2|处理方式|200|", length = 200, nullable = true)
	private String handlingWay;

	@Column(name = "HANDLING_WAY_OTHER", columnDefinition = "VARCHAR2|处理方式其他|100|", length = 100, nullable = true)
	private String handlingWayOther;

	@Column(name = "IMMUNIZATION_HISTORY", columnDefinition = "VARCHAR2|暴露免疫史|2|", length = 2, nullable = true)
	private String immunizationHistory;

	@Column(name = "IMMUNIZATION_DT", columnDefinition = "DATE|暴露免疫时间||", nullable = true)
	private Date immunizationDt;

	@Column(name = "ANTISERUM_INJECTION", columnDefinition = "VARCHAR2|暴露后抗血清注射|2|", length = 2, nullable = true)
	private String antiserumInjection;

	@Column(name = "ANTISERUM_INJECTION_CATEGORY", columnDefinition = "VARCHAR2|暴露后抗血清注射种类|2|", length = 2, nullable = true)
	private String antiserumInjectionCategory;

	@Column(name = "ANTISERUM_INJECTION_DT", columnDefinition = "DATE|暴露后抗血清注射时间||", nullable = true)
	private Date antiserumInjectionDt;

	@Column(name = "ANTISERUM_INJECTION_MEASURE", columnDefinition = "VARCHAR2|暴露后抗血清注射量|100|", length = 100, nullable = true)
	private String antiserumInjectionMeasure;

	@Column(name = "IRRITABILITY", columnDefinition = "VARCHAR2|暴露后抗血清注射有无过敏|2|", length = 2, nullable = true)
	private String irritability;

	@Column(name = "IRRITABILITY_DETAIL", columnDefinition = "VARCHAR2|暴露后抗血清注射过敏表现|100|", length = 100, nullable = true)
	private String irritabilityDetail;

	@Column(name = "RABIES_VACCINATION", columnDefinition = "VARCHAR2|暴露后人用狂犬病疫苗注射|2|", length = 2, nullable = true)
	private String rabiesVaccination;

	@Column(name = "RABIES_VACCINATION_UNIT", columnDefinition = "VARCHAR2|暴露后人用狂犬病疫苗注射单位|2|", length = 2, nullable = true)
	private String rabiesVaccinationUnit;

	@Column(name = "RABIES_VACCINATION_UNIT_OTHER", columnDefinition = "VARCHAR2|暴露后人用狂犬病疫苗注射单位其他|100|", length = 100, nullable = true)
	private String rabiesVaccinationUnitOther;

	@Column(name = "RABIES_VACCINATION_CATEGORY", columnDefinition = "VARCHAR2|暴露后人用狂犬病疫苗注射种类|2|", length = 2, nullable = true)
	private String rabiesVaccinationCategory;

	@Column(name = "RABIES_VACCINATION_DT_F", columnDefinition = "DATE|暴露后人用狂犬病疫苗注射首针时间||", nullable = true)
	private Date rabiesVaccinationDtF;

	@Column(name = "RABIES_VACCINATION_MEASURE_F", columnDefinition = "VARCHAR2|暴露后人用狂犬病疫苗注射首次计量|2|", length = 2, nullable = true)
	private String rabiesVaccinationMeasureF;

	@Column(name = "IMMUNE_PROCEDURE", columnDefinition = "VARCHAR2|暴露后人用狂犬病疫苗注射免疫程序|2|", length = 2, nullable = true)
	private String immuneProcedure;

	@Column(name = "IMMUNE_PROCEDURE_OTHER", columnDefinition = "VARCHAR2|暴露后人用狂犬病疫苗注射免疫程序其他|100|", length = 100, nullable = true)
	private String immuneProcedureOther;

	@Column(name = "RABIES_VACCINATION_NUM", columnDefinition = "VARCHAR2|暴露后人用狂犬病疫苗注射针次|20|", length = 20, nullable = true)
	private String rabiesVaccinationNum;

	@Column(name = "RABIES_VACCINATION_UNDO", columnDefinition = "VARCHAR2|暴露后人用狂犬病疫苗注射未全程原因|100|", length = 100, nullable = true)
	private String rabiesVaccinationUndo;

	@Column(name = "RABIES_VACCINATION_REINFORCED", columnDefinition = "VARCHAR2|暴露后人用狂犬病疫苗注射加强|2|", length = 2, nullable = true)
	private String rabiesVaccinationReinforced;

	@Column(name = "REINFORCED_NUM", columnDefinition = "VARCHAR2|暴露后人用狂犬病疫苗注射加强针次|20|", length = 20, nullable = true)
	private String reinforcedNum;

	@Column(name = "REINFORCED_UNIT", columnDefinition = "VARCHAR2|暴露后人用狂犬病疫苗注射疫苗生产单位|100|", length = 100, nullable = true)
	private String reinforcedUnit;

	@Column(name = "REINFORCED_BATCH", columnDefinition = "VARCHAR2|暴露后人用狂犬病疫苗注射批号|100|", length = 100, nullable = true)
	private String reinforcedBatch;

	@Column(name = "RABIES_VACCINATION_EXP_DT", columnDefinition = "DATE|暴露后人用狂犬病疫苗失效期||", nullable = true)
	private Date rabiesVaccinationExpDt;

	@Column(name = "CASE_AREA", columnDefinition = "VARCHAR2|发病前7天内是否曾经到过出现疑似或确诊病例的国家/地区|2|", length = 2, nullable = true)
	private String caseArea;

	@Column(name = "CASE_AREA_ADDR", columnDefinition = "VARCHAR2|详细地址|100|", length = 100, nullable = true)
	private String caseAreaAddr;

	@Column(name = "DOUBTFUL_HN", columnDefinition = "VARCHAR2|疑似甲型H1N1流感病人|2|", length = 2, nullable = true)
	private String doubtfulHn;

	@Column(name = "DIAGNOSIS_HN", columnDefinition = "VARCHAR2|确诊甲型H1N1流感病人|2|", length = 2, nullable = true)
	private String diagnosisHn;

	@Column(name = "FEVER_PATIENT", columnDefinition = "VARCHAR2|发热（体温≥37.5℃）伴咽痛或咳嗽的病人|2|", length = 2, nullable = true)
	private String feverPatient;

	@Column(name = "RESPIRATORY_SYMPTOMS_PATIENT", columnDefinition = "VARCHAR2|仅有呼吸道症状的病人（无发热）|2|", length = 2, nullable = true)
	private String respiratorySymptomsPatient;

	@Column(name = "PATIENT_OTHER", columnDefinition = "VARCHAR2|其他发热病人|2|", length = 2, nullable = true)
	private String patientOther;

	@Column(name = "EXPOSURE_DT_FIRST", columnDefinition = "DATE|首次暴露时间||", nullable = true)
	private Date exposureDtFirst;

	@Column(name = "EXPOSURE_DT_LAST", columnDefinition = "DATE|末次暴露时间||", nullable = true)
	private Date exposureDtLast;

	@Column(name = "CONTACT_WAY", columnDefinition = "VARCHAR2|接触方式|20|", length = 20, nullable = true)
	private String contactWay;

	@Column(name = "CONTACT_WAY_OTHER", columnDefinition = "VARCHAR2|其他|100|", length = 100, nullable = true)
	private String contactWayOther;

	@Column(name = "CONSERVATORY_MEASURE", columnDefinition = "VARCHAR2|接触患者时是否采取防护措施|2|", length = 2, nullable = true)
	private String conservatoryMeasure;

	@Column(name = "CONSERVATORY_MEASURE_WAY", columnDefinition = "VARCHAR2|防护措施|2|", length = 2, nullable = true)
	private String conservatoryMeasureWay;

	@Column(name = "HN_LAB", columnDefinition = "VARCHAR2|发病前7天内，是否到过甲型H1N1流感病毒学实验室|2|", length = 2, nullable = true)
	private String hnLab;

	@Column(name = "CONSERVATORY_MEASURE_LAB", columnDefinition = "VARCHAR2|若曾到过实验室，是否采取防护措施|2|", length = 2, nullable = true)
	private String conservatoryMeasureLab;

	@Column(name = "CONTACT_ANIMAL", columnDefinition = "VARCHAR2|病前2周内是否接触禽类及其它动物|2|", length = 2, nullable = true)
	private String contactAnimal;

	@Column(name = "CONTACT_ANIMAL_CATEGORY", columnDefinition = "VARCHAR2|接触动物种类|200|", length = 200, nullable = true)
	private String contactAnimalCategory;

	@Column(name = "CONTACT_ANIMAL_WAY", columnDefinition = "VARCHAR2|接触方式|200|", length = 200, nullable = true)
	private String contactAnimalWay;

	@Column(name = "CONTACT_ANIMAL_DT", columnDefinition = "DATE|接触时间||", nullable = true)
	private Date contactAnimalDt;

	@Column(name = "WATER_CATEGORY", columnDefinition = "VARCHAR2|接触家禽后是否洗手|2|", length = 2, nullable = true)
	private String waterCategory;

	@Column(name = "PUBLIC_PLACE", columnDefinition = "VARCHAR2|若未接触过禽类及其它动物，是否在病前2周内到过|200|", length = 200, nullable = true)
	private String publicPlace;

	@Column(name = "DIE_ANIMAL_CATEGORY", columnDefinition = "VARCHAR2|病前2周内是否接触病死禽类|2|", length = 2, nullable = true)
	private String dieAnimalCategory;

	@Column(name = "ANIMAL_CONTACT_CATEGORY", columnDefinition = "VARCHAR2|接触种类|200|", length = 200, nullable = true)
	private String animalContactCategory;

	@Column(name = "ANIMAL_CONTACT_WAY", columnDefinition = "VARCHAR2|接触方式|200|", length = 200, nullable = true)
	private String animalContactWay;

	@Column(name = "ANIMAL_CONTACT_DT", columnDefinition = "DATE|接触时间||", nullable = true)
	private Date animalContactDt;

	@Column(name = "BOIL_CATEGORY", columnDefinition = "VARCHAR2|若食用病死禽肉，则所食用时是否熟透|2|", length = 2, nullable = true)
	private String boilCategory;

	@Column(name = "SLAUGHTER_CATEGOEY", columnDefinition = "VARCHAR2|病前2周内，若参与宰杀、加工病死禽类，则主要方式|200|", length = 200, nullable = true)
	private String slaughterCategoey;

	@Column(name = "WOUND_CATEGORY", columnDefinition = "VARCHAR2|接触病死禽期间，手部伤口情况|2|", length = 2, nullable = true)
	private String woundCategory;

	@Column(name = "CONSERVATORY_MEASURE_ANIMAL", columnDefinition = "VARCHAR2|处理病死禽类时是否采取防护措施及其它预防措施|200|", length = 200, nullable = true)
	private String conservatoryMeasureAnimal;

	@Column(name = "DIE_ANIMAL_WATER_CATEGORY", columnDefinition = "VARCHAR2|处理病死禽后是否洗手|2|", length = 2, nullable = true)
	private String dieAnimalWaterCategory;

	@Column(name = "FEVER_PATIENT_CONTACT", columnDefinition = "VARCHAR2|发病前2周内是否与其它发热病人有所接触|2|", length = 2, nullable = true)
	private String feverPatientContact;

	@Column(name = "MASK", columnDefinition = "VARCHAR2|若在医院接触病人，则与病人接触时是否戴口罩|2|", length = 2, nullable = true)
	private String mask;

	@Column(name = "WATER", columnDefinition = "VARCHAR2|若看望病人，看望病人后是否洗手|2|", length = 2, nullable = true)
	private String water;

	@Column(name = "HN_LAB_WEEK", columnDefinition = "VARCHAR2|发病前2周内，是否到过禽流感病毒学实验室|2|", length = 2, nullable = true)
	private String hnLabWeek;

	@Column(name = "CONSERVATORY_MEASURE_LAB_WEEK", columnDefinition = "VARCHAR2|若曾到过实验室，是否进行防护|2|", length = 2, nullable = true)
	private String conservatoryMeasureLabWeek;

	@Column(name = "IN_HOSPITAL", columnDefinition = "VARCHAR2|住院|2|", length = 2, nullable = true)
	private String inHospital;

	@Column(name = "IN_HOSPITAL_DT", columnDefinition = "DATE|住院时间||", nullable = true)
	private Date inHospitalDt;

	@Column(name = "OUT_HOSPITAL_DT", columnDefinition = "DATE|出院时间||", nullable = true)
	private Date outHospitalDt;

	@Column(name = "HOSPITAL_UNIT", columnDefinition = "VARCHAR2|医疗单位|2|", length = 2, nullable = true)
	private String hospitalUnit;

	@Column(name = "IN_HOSPITAL_DEPARTMENT", columnDefinition = "VARCHAR2|住院科室|2|", length = 2, nullable = true)
	private String inHospitalDepartment;

	@Column(name = "OPERATION", columnDefinition = "VARCHAR2|手术|2|", length = 2, nullable = true)
	private String operation;

	@Column(name = "OPERATION_DETAIL", columnDefinition = "VARCHAR2|何种手术|100|", length = 100, nullable = true)
	private String operationDetail;

	@Column(name = "OPERATION_DT", columnDefinition = "DATE|手术时间||", nullable = true)
	private Date operationDt;

	@Column(name = "OPERATION_UNIT", columnDefinition = "VARCHAR2|手术单位|20|", length = 20, nullable = true)
	private String operationUnit;

	@Column(name = "RECEPTION_BLOOD_HISTORY", columnDefinition = "VARCHAR2|受血史|2|", length = 2, nullable = true)
	private String receptionBloodHistory;

	@Column(name = "RECEPTION_BLOOD_NUM", columnDefinition = "VARCHAR2|受血次数|20|", length = 20, nullable = true)
	private String receptionBloodNum;

	@Column(name = "RECEPTION_BLOOD_MEASURE", columnDefinition = "VARCHAR2|累计受血量|100|", length = 100, nullable = true)
	private String receptionBloodMeasure;

	@Column(name = "RECEPTION_BLOOD_BEGIN_DT", columnDefinition = "DATE|受血开始时间||", nullable = true)
	private Date receptionBloodBeginDt;

	@Column(name = "RECEPTION_BLOOD_UNIT", columnDefinition = "VARCHAR2|医疗单位|20|", length = 20, nullable = true)
	private String receptionBloodUnit;

	@Column(name = "DONATE_BLOOD_HISTORY", columnDefinition = "VARCHAR2|献血史|2|", length = 2, nullable = true)
	private String donateBloodHistory;

	@Column(name = "DONATE_BLOOD_NUM", columnDefinition = "VARCHAR2|献血次数|20|", length = 20, nullable = true)
	private String donateBloodNum;

	@Column(name = "DONATE_BLOOD_UNIT", columnDefinition = "VARCHAR2|献血单位|100|", length = 100, nullable = true)
	private String donateBloodUnit;

	@Column(name = "DONATE_BLOOD_CATEGORY", columnDefinition = "VARCHAR2|献血类型|2|", length = 2, nullable = true)
	private String donateBloodCategory;

	@Column(name = "IVT", columnDefinition = "VARCHAR2|静脉输液|2|", length = 2, nullable = true)
	private String ivt;

	@Column(name = "IVT_UNIT", columnDefinition = "VARCHAR2|静脉输液医疗单位|2|", length = 2, nullable = true)
	private String ivtUnit;

	@Column(name = "ACUPUNCTURE", columnDefinition = "VARCHAR2|针灸治疗|2|", length = 2, nullable = true)
	private String acupuncture;

	@Column(name = "ACUPUNCTURE_UNIT", columnDefinition = "VARCHAR2|针灸治疗医疗单位|20|", length = 20, nullable = true)
	private String acupunctureUnit;

	@Column(name = "ACUPUNCTURE_DATE", columnDefinition = "DATE|针灸治疗时间||", nullable = true)
	private Date acupunctureDate;
	
	@Column(name = "INTRAVENOUS_INJECTION", columnDefinition = "VARCHAR2|肌肉、静脉注射|2|", length = 2, nullable = true)
	private String intravenousInjection;

	@Column(name = "II_DISPOSABLE_SYRINGE", columnDefinition = "VARCHAR2|一次性注射器|2|", length = 2, nullable = true)
	private String iiDisposableSyringe;

	@Column(name = "II_NEEDLE_TUBING", columnDefinition = "VARCHAR2|一人一针一管|2|", length = 2, nullable = true)
	private String iiNeedleTubing;

	@Column(name = "INTRAVENOUS_INJECTION_UNIT", columnDefinition = "VARCHAR2|肌肉、静脉注射医疗单位|2|", length = 2, nullable = true)
	private String intravenousInjectionUnit;

	@Column(name = "VACCINATION", columnDefinition = "VARCHAR2|预防接种|2|", length = 2, nullable = true)
	private String vaccination;

	@Column(name = "VA_DISPOSABLE_SYRINGE", columnDefinition = "VARCHAR2|一次性注射器|2|", length = 2, nullable = true)
	private String vaDisposableSyringe;

	@Column(name = "VA_NEEDLE_TUBING", columnDefinition = "VARCHAR2|一人一针一管|2|", length = 2, nullable = true)
	private String vaNeedleTubing;

	@Column(name = "VACCINATION_UNIT", columnDefinition = "VARCHAR2|接种单位|2|", length = 2, nullable = true)
	private String vaccinationUnit;

	@Column(name = "TOOTH", columnDefinition = "VARCHAR2|拔牙|2|", length = 2, nullable = true)
	private String tooth;

	@Column(name = "TOOTH_NUM", columnDefinition = "VARCHAR2|拔牙次数|20|", length = 20, nullable = true)
	private String toothNum;

	@Column(name = "TOOTH_DT", columnDefinition = "DATE|拔牙时间||", nullable = true)
	private Date toothDt;

	@Column(name = "TOOTH_UNIT", columnDefinition = "VARCHAR2|拔牙单位|20|", length = 20, nullable = true)
	private String toothUnit;

	@Column(name = "HBV", columnDefinition = "VARCHAR2|家庭内乙肝病人或HBV携带者|2|", length = 2, nullable = true)
	private String hbv;

	@Column(name = "HBV_RELATION", columnDefinition = "VARCHAR2|与患者关系|2|", length = 2, nullable = true)
	private String hbvRelation;

	@Column(name = "SHARE_TOOTHBRUSH", columnDefinition = "VARCHAR2|共用牙刷|2|", length = 2, nullable = true)
	private String shareToothbrush;

	@Column(name = "SHARE_TOOTH_CUP", columnDefinition = "VARCHAR2|共用刷牙杯|2|", length = 2, nullable = true)
	private String shareToothCup;

	@Column(name = "SHARE_RAZOR", columnDefinition = "VARCHAR2|共用剃刀|2|", length = 2, nullable = true)
	private String shareRazor;

	@Column(name = "PILES", columnDefinition = "VARCHAR2|家庭成员中痔疮患者|2|", length = 2, nullable = true)
	private String piles;

	@Column(name = "MENSE_POLLUTE", columnDefinition = "VARCHAR2|月经血污染物品|2|", length = 2, nullable = true)
	private String mensePollute;

	@Column(name = "SHAVE", columnDefinition = "VARCHAR2|理发时刮面|2|", length = 2, nullable = true)
	private String shave;

	@Column(name = "TATTOOING_EYEBROW", columnDefinition = "VARCHAR2|文眉|2|", length = 2, nullable = true)
	private String tattooingEyebrow;

	@Column(name = "TATTOO", columnDefinition = "VARCHAR2|文身|2|", length = 2, nullable = true)
	private String tattoo;

	@Column(name = "HEPATITIS_B_PATIENT_CONTACT", columnDefinition = "VARCHAR2|日常密切接触者中是否有乙肝病人或表面抗原携带者|2|", length = 2, nullable = true)
	private String hepatitisBPatientContact;

	@Column(name = "HEPATITIS_B_PATIENT_CATEGORY", columnDefinition = "VARCHAR2|如有，是谁|200|", length = 200, nullable = true)
	private String hepatitisBPatientCategory;

	@Column(name = "HEPATITIS_B_PATIENT_OTHER", columnDefinition = "VARCHAR2|如有，是谁其它|100|", length = 100, nullable = true)
	private String hepatitisBPatientOther;

	@Column(name = "INTERVENTIONAL_HISTORY", columnDefinition = "VARCHAR2|有无介入性（胃镜、肠镜、支纤镜、腹腔镜等）医学诊疗史|2|", length = 2, nullable = true)
	private String interventionalHistory;

	@Column(name = "SHARE_SYRINGE", columnDefinition = "VARCHAR2|有无与他人共用注射器史|2|", length = 2, nullable = true)
	private String shareSyringe;

	@Column(name = "TRAUMATIC_TREATMENT", columnDefinition = "VARCHAR2|您曾去美容院做过创伤性治疗（纹眉、眼线、唇线、纹身、打耳洞等）|2|", length = 2, nullable = true)
	private String traumaticTreatment;

	@Column(name = "SHAVE_FREQUENCY", columnDefinition = "VARCHAR2|您经常去理发店修面或刮胡须吗|2|", length = 2, nullable = true)
	private String shaveFrequency;

	@Column(name = "PEDICURE_FREQUENCY", columnDefinition = "VARCHAR2|您经常去洗浴场所或足浴店修脚|2|", length = 2, nullable = true)
	private String pedicureFrequency;

	@Column(name = "HEMODIALYSIS_HISTORY", columnDefinition = "VARCHAR2|有无血液透析治疗史|2|", length = 2, nullable = true)
	private String hemodialysisHistory;

	@Column(name = "BLOOD_SAMPLE", columnDefinition = "VARCHAR2|如是医务人员，是否接触血液标本|2|", length = 2, nullable = true)
	private String bloodSample;

	@Column(name = "BLOOD_SAMPLE_FREQUENCY", columnDefinition = "VARCHAR2|接触频次|2|", length = 2, nullable = true)
	private String bloodSampleFrequency;

	@Column(name = "RECEPTION_BLOOD_END_DT", columnDefinition = "DATE|受血结束时间||", nullable = true)
	private Date receptionBloodEndDt;

	@Column(name = "PAT_LIVE_ENVIR", columnDefinition = "VARCHAR2|病例居住地点(村庄/居民楼)周围环境描述|200|", length = 200, nullable = true)
	private String patLiveEnvir;

	@Column(name = "IS_MARKET", columnDefinition = "VARCHAR2|病例居住地点(村庄/居民楼)周围3公里内是否有|200|", length = 200, nullable = true)
	private String isMarket;

	@Column(name = "IS_SEE_ANIMAL", columnDefinition = "VARCHAR2|是否能见到候鸟或野禽|2|", length = 2, nullable = true)
	private String isSeeAnimal;

	@Column(name = "IS_DIE_ANIMAL", columnDefinition = "VARCHAR2|近期是否有死亡候鸟或野禽|2|", length = 2, nullable = true)
	private String isDieAnimal;

	@Column(name = "PLACE", columnDefinition = "VARCHAR2|常见地点|200|", length = 200, nullable = true)
	private String place;

	@Column(name = "DIE_ANIMAL_DATE", columnDefinition = "DATE|候鸟或野禽最近死亡时间||", nullable = true)
	private Date dieAnimalDate;

	@Column(name = "IS_DIE_LIVE", columnDefinition = "VARCHAR2|病例居住地点(村庄/居民区)动物饲养或病死情况|2|", length = 2, nullable = true)
	private String isDieLive;

	@Column(name = "IS_DIE_HN", columnDefinition = "VARCHAR2|农业部门是否已经证实死亡家禽死于H5N1型禽流感|2|", length = 2, nullable = true)
	private String isDieHn;

	@Column(name = "IS_DISINFECT", columnDefinition = "VARCHAR2|当地环境是否已经进行彻底消毒|2|", length = 2, nullable = true)
	private String isDisinfect;

	@Column(name = "DISINFECT_DATE", columnDefinition = "DATE|若已经彻底消毒,则时间为||", nullable = true)
	private Date disinfectDate;

	@Column(name = "IS_PAT", columnDefinition = "VARCHAR2|有病死动物后,当地有无流感样/发热/不明原因死亡病例等|2|", length = 2, nullable = true)
	private String isPat;

	@Column(name = "CONSERVATORY_MEASURE_WAY_OTHER", columnDefinition = "VARCHAR2|防护措施-其他|200|", length = 200, nullable = true)
	private String conservatoryMeasureWayOther;

	@Column(name = "IMMUNIZATION_HISTORY_NUM", columnDefinition = "VARCHAR2|暴露免疫史-免疫针次数|20|", length = 20, nullable = true)
	private String immunizationHistoryNum;

	@Column(name = "EXPOSURE_WAY_OTHER", columnDefinition = "VARCHAR2|暴露方式-其他|100|", length = 100, nullable = true)
	private String exposureWayOther;

	@Column(name = "EXPOSURE_DT", columnDefinition = "DATE|暴露日期||", nullable = true)
	private Date exposureDt;


	@Column(name = "BIRD_OCCUPATION", columnDefinition = "VARCHAR2|是否是职业涉禽人员|50|", length = 50, nullable = true)
	private String birdOccupation;
	@Column(name = "BIRD_SPECIES_OC", columnDefinition = "VARCHAR2|经常接触的禽类动物种类|50|", length = 50, nullable = true)
	private String birdSpeciesOc;
	@Column(name = "BIRD_SPECIES_OTHER_OC", columnDefinition = "VARCHAR2|经常接触的禽类动物种类-其他|50|", length = 50, nullable = true)
	private String birdSpeciesOtherOc;	
	@Column(name = "CONTACT_WAY_OC", columnDefinition = "VARCHAR2|接触的环节|50|", length = 50, nullable = true)
	private String contactWayOc;
	@Column(name = "CONTACT_WAY_OTHER_OC", columnDefinition = "VARCHAR2|接触的环节-其他|50|", length = 50, nullable = true)
	private String contactWayOtherOc;
	@Column(name = "CONTACT_BI", columnDefinition = "VARCHAR2|自（病例）发病起前10天内是否接触过禽类|50|", length = 50, nullable = true)
	private String contactBi;
	@Column(name = "CONTACT_HEALTH_BI", columnDefinition = "VARCHAR2|自（病例）发病起前10天内是否接触过外表健康的禽类|50|", length = 50, nullable = true)
	private String contactHealthBi;
	@Column(name = "CONTACT_FRE_HEALTH_BI", columnDefinition = "VARCHAR2|接触频率|50|", length = 50, nullable = true)
	private String contactFreHealthBi;
	@Column(name = "CONTACT_DAY_HEALTH_BI", columnDefinition = "VARCHAR2|是否每天的接触和防护等方式都基本类似|50|", length = 50, nullable = true)
	private String contactDayHealthBi;
	@Column(name = "BIRD_SPECIES_HEALTH_BI", columnDefinition = "VARCHAR2|接触禽的种类|50|", length = 50, nullable = true)
	private String birdSpeciesHealthBi;
	@Column(name = "CONTACT_WAY_HEALTH_BI", columnDefinition = "VARCHAR2|接触方式|50|", length = 50, nullable = true)
	private String contactWayHealthBi;
	@Column(name = "HAND_HEALTH_BI", columnDefinition = "VARCHAR2|接触禽类时，手部伤口情况|50|", length = 50, nullable = true)
	private String handHealthBi;
	@Column(name = "PROTECT_HEALTH_BI", columnDefinition = "VARCHAR2|接触禽类时是否采取防护措施 |50|", length = 50, nullable = true)
	private String protectHealthBi;
	@Column(name = "PROTECT_WAY_HEALTH_BI", columnDefinition = "VARCHAR2|接触禽类时防护措施|50|", length = 50, nullable = true)
	private String protectWayHealthBi;
	@Column(name = "CONTACT_WAY_OTHER_HEALTH_BI", columnDefinition = "VARCHAR2|接触禽类时防护措施-其他|50|", length = 50, nullable = true)
	private String contactWayOtherHealthBi;
	@Column(name = "Contact_DEATH_BI", columnDefinition = "VARCHAR2|自（病例）发病起前10天内是否接触病、死的禽类|50|", length = 50, nullable = true)
	private String contactDeathBi;
	@Column(name = "CONTACT_FRE_DEATH_BI", columnDefinition = "VARCHAR2|接触频率|50|", length = 50, nullable = true)
	private String contactFreDeathBi;
	@Column(name = "CONTACT_DAY_DEATH_BI", columnDefinition = "VARCHAR2|是否每天的接触和防护等方式都基本类似|50|", length = 50, nullable = true)
	private String contactDayDeathBi;
	@Column(name = "BIRD_SPECIES_DEATH_BI", columnDefinition = "VARCHAR2|接触禽的种类|50|", length = 50, nullable = true)
	private String birdSpeciesDeathBi;
	@Column(name = "CONTACT_WAY_DEATH_BI", columnDefinition = "VARCHAR2|接触方式|50|", length = 50, nullable = true)
	private String contactWayDeathBi;
	@Column(name = "HAND_DEATH_BI", columnDefinition = "VARCHAR2|接触病死禽类时，手部伤口情况|50|", length = 50, nullable = true)
	private String handDeathBi;
	@Column(name = "PROTECT_DEATH_BI", columnDefinition = "VARCHAR2|接触禽类时是否采取防护措施 |50|", length = 50, nullable = true)
	private String protectDeathBi;
	@Column(name = "PROTECT_WAY_DEATH_BI", columnDefinition = "VARCHAR2|接触禽类时防护措施|50|", length = 50, nullable = true)
	private String protectWayDeathBi;
	@Column(name = "PROTECT_WAY_OTHER_DEATH_BI", columnDefinition = "VARCHAR2|接触禽类时防护措施-其他|50|", length = 50, nullable = true)
	private String protectWayOtherDeathBi;
	
	@Column(name = "TO_BREED_EN", columnDefinition = "VARCHAR2|自（病例）发病起前10天内是否到过禽类养殖场所|50|", length = 50, nullable = true)
	private String toBreedEn;
	@Column(name = "CONTACT_FRE_BREED_EN", columnDefinition = "VARCHAR2|访问的频率|50|", length = 50, nullable = true)
	private String contactFreBreedEn;
	@Column(name = "CONTACT_DAY_BREED_EN", columnDefinition = "VARCHAR2|是否每天的情况基本类似|50|", length = 50, nullable = true)
	private String contactDayBreedEn;
	@Column(name = "BIRD_SPECIES_BREED_EN", columnDefinition = "VARCHAR2|此养殖场所养殖的禽类种类|50|", length = 50, nullable = true)
	private String birdSpeciesBreedEn;
	@Column(name = "BIRD_DEATH_BREED_EN", columnDefinition = "VARCHAR2|访问时此场所有无禽类病死现象|50|", length = 50, nullable = true)
	private String birdDeathBreedEn;
	@Column(name = "WORKSHOP_BREED_EN", columnDefinition = "VARCHAR2|是否到过养殖场所中饲养禽类的房间或车间|50|", length = 50, nullable = true)
	private String workshopBreedEn;
	@Column(name = "CONTACT_BREED_EN", columnDefinition = "VARCHAR2|是否直接接触过养殖场所内的禽类|50|", length = 50, nullable = true)
	private String contactBreedEn;
	
	@Column(name = "TO_MARKET_EN", columnDefinition = "VARCHAR2|自（病例）发病起前10天内是否到过有活禽摊位的菜市场|50|", length = 50, nullable = true)
	private String toMarketEn;
	@Column(name = "CONTACT_FRE_MARKET_EN", columnDefinition = "VARCHAR2|是否每天的情况基本类似|50|", length = 50, nullable = true)
	private String contactFreMarketEn;
	@Column(name = "CONTACT_DAY_MARKET_EN", columnDefinition = "VARCHAR2|是否每天的接触和防护等方式都基本类似|50|", length = 50, nullable = true)
	private String contactDayMarketEn;
	@Column(name = "PASSAGEWAY_MARKET_EN", columnDefinition = "VARCHAR2|是否经过有活禽摊位的通道|50|", length = 50, nullable = true)
	private String passagewayMarketEn;
	@Column(name = "NEAR_MARKET_EN", columnDefinition = "VARCHAR2|是否到过活禽摊位1米之内的范围|50|", length = 50, nullable = true)
	private String nearMarketEn;
	@Column(name = "CONTACT_MARKET_EN", columnDefinition = "VARCHAR2|是否直接接触活禽摊位的活禽|50|", length = 50, nullable = true)
	private String contactMarketEn;
	@Column(name = "VISIT_NUM_MARKET_EN", columnDefinition = "VARCHAR2|自（病例）发病起前10天内共访问次数|50|", length = 50, nullable = true)
	private String visitNumMarketEn;
	
	@Column(name = "RELATIVES_CA", columnDefinition = "VARCHAR2|是否与H7N9禽流感确诊病例为三代以内血亲|50|", length = 50, nullable = true)
	private String relativesCa;
	@Column(name = "RELATIONSHIP_CA", columnDefinition = "VARCHAR2|关系|50|", length = 50, nullable = true)
	private String relationshipCa;
	@Column(name = "CONTACT_CA", columnDefinition = "VARCHAR2|自（病例）发病起前10天内至（病例）出现结局事件前，是否与人感染H7N9禽流感疑似或确诊病例接触过|50|", length = 50, nullable = true)
	private String contactCa;
	@Column(name = "CONTACT_FRE_CA", columnDefinition = "VARCHAR2|接触频率|50|", length = 50, nullable = true)
	private String contactFreCa;
	@Column(name = "CONTACT_DAY_CA", columnDefinition = "VARCHAR2|是否每天的接触和防护等方式都基本类似|50|", length = 50, nullable = true)
	private String contactDayCa;
	@Column(name = "CONTACT_WAY_CA", columnDefinition = "VARCHAR2|如果接触过人感染H7N9禽流感疑似或确诊病例，接触方式|50|", length = 50, nullable = true)
	private String contactWayCa;	
	@Column(name = "DIAGNOSIS_CA", columnDefinition = "VARCHAR2|如为“诊治病人”，具体操作为|50|", length = 50, nullable = true)
	private String diagnosisCa;
	@Column(name = "PROTECT_CA", columnDefinition = "VARCHAR2|接触人感染H7N9禽流感疑似或确诊病例时是否有防护措施|50|", length = 50, nullable = true)
	private String protectCa;
	@Column(name = "PROTECT_WAY_CA", columnDefinition = "VARCHAR2|采取的措施|50|", length = 50, nullable = true)
	private String protectWayCa;
	@Column(name = "CONTACT_TIME_CA", columnDefinition = "VARCHAR2|接触人感染H7N9禽流感疑似或确诊病例的持续时间|50|", length = 50, nullable = true)
	private String contactTimeCa;
	
	@Column(name = "CONTACT_FE", columnDefinition = "VARCHAR2|自（病例）发病起前10天内，是否接触过除上述病例外的其它发热呼吸道病人|50|", length = 50, nullable = true)
	private String contactFe;
	@Column(name = "CONTACT_FRE_FE", columnDefinition = "VARCHAR2|接触频率|50|", length = 50, nullable = true)
	private String contactFreFe;
	@Column(name = "CONTACT_DAY_FE", columnDefinition = "VARCHAR2|是否每天的接触和防护等方式都基本类似|50|", length = 50, nullable = true)
	private String contactDayFe;
	@Column(name = "CONTACT_WAY_FE", columnDefinition = "VARCHAR2|接触方式|50|", length = 50, nullable = true)
	private String contactWayFe;	
	@Column(name = "DIAGNOSIS_FE", columnDefinition = "VARCHAR2|如为“诊治病人”，具体操作为|50|", length = 50, nullable = true)
	private String diagnosisFe;
	@Column(name = "PROTECT_FE", columnDefinition = "VARCHAR2|接触发热病人时是否有防护措施|50|", length = 50, nullable = true)
	private String protectFe;
	@Column(name = "PROTECT_WAY_FE", columnDefinition = "VARCHAR2|采取的措施|50|", length = 50, nullable = true)
	private String protectWayFe;
	@Column(name = "CONTACT_TIME_FE", columnDefinition = "VARCHAR2|接触发热病人的持续时间|50|", length = 50, nullable = true)
	private String contactTimeFe;
	
	@Column(name = "TAKE_DRUG_HIS", columnDefinition = "VARCHAR2|吸毒史|20|", length = 20, nullable = true)
   	private String takeDrugHis;
    @Column(name = "FIRST_TAKE_DRUG_DATE", columnDefinition = "DATE|首次吸毒时间||", nullable = true)
   	private Date firstTakeDrugDate;
	@Column(name = "TAKE_DRUG_WAY", columnDefinition = "VARCHAR2|目前的吸毒方式|20|", length = 20, nullable = true)
   	private String takeDrugWay;
    @Column(name = "DRUG_INJECTION_HIS", columnDefinition = "VARCHAR2|注射毒品史|20|", length = 20, nullable = true)
   	private String drugInjectionHis;
	@Column(name = "FIRST_DRUG_INJECTION_DATE", columnDefinition = "DATE|首次注射毒品时间||", nullable = true)
   	private Date firstDrugInjectionDate;
    @Column(name = "SHARED_INJECTOR_HIS", columnDefinition = "VARCHAR2|共用注射器史|20|", length = 20, nullable = true)
   	private String sharedInjectorHis;
	@Column(name = "TAKE_DRUG_PARTNER", columnDefinition = "VARCHAR2|配偶或固定性伴是否吸毒|20|", length = 20, nullable = true)
   	private String takeDrugPartner;
	@Column(name = "SEX_BEHAVIOR_HIS", columnDefinition = "VARCHAR2|性接触史|20|", length = 20, nullable = true)
   	private String sexBehaviorHis;
    @Column(name = "OPPOSITE_SEX_BEHAVIOR", columnDefinition = "VARCHAR2|异性性行为|20|", length = 20, nullable = true)
   	private String oppositeSexBehavior;
	@Column(name = "COMMERCIAL_SEX_BEHAVIOR", columnDefinition = "VARCHAR2|商业性行为|20|", length = 20, nullable = true)
   	private String commercialSexBehavior;
    @Column(name = "LAST_COM_BEH_CONDOM", columnDefinition = "VARCHAR2|最近一次商业性行为时是否使用安全套|20|", length = 20, nullable = true)
   	private String lastComBehCondom;
	@Column(name = "LAST_MONTH_COM_BEH_CONDOM", columnDefinition = "VARCHAR2|过去一个月商业性行为时是否使用安全套|20|", length = 20, nullable = true)
   	private String lastMonthComBehCondom;
    @Column(name = "MARRIAGE_SEX_BEHAVIOR", columnDefinition = "VARCHAR2|婚内性行为|20|", length = 20, nullable = true)
   	private String marriageSexBehavior;
	@Column(name = "LAST_MAR_BEH_CONDOM", columnDefinition = "VARCHAR2|最近一次夫妻性生活时是否使用安全套|20|", length = 20, nullable = true)
   	private String lastMarBehCondom;
	@Column(name = "LAST_MONTH_MAR_BEH_CONDOM", columnDefinition = "VARCHAR2|过去一个月夫妻性生活时是否使用安全套|20|", length = 20, nullable = true)
   	private String lastMonthMarBehCondom;
    @Column(name = "NO_COM_MAR_SEX_BEH", columnDefinition = "VARCHAR2|婚外非商业性行为|20|", length = 20, nullable = true)
   	private String noComMarSexBeh;
	@Column(name = "LAST_NO_COM_MAR_BEH_CONDOM", columnDefinition = "VARCHAR2|最近一次婚外非商业性行为时是否使用安全套|20|", length = 20, nullable = true)
   	private String lastNoComMarBehCondom;
    @Column(name = "LAST_MON_NO_COM_MAR_BEH_CONDOM", columnDefinition = "VARCHAR2|过去一个月婚外非商业性行为时是否使用安全套|20|", length = 20, nullable = true)
   	private String lastMonNoComMarBehCondom;
    @Column(name = "GAY_SEX_BEHAVIOR", columnDefinition = "VARCHAR2|同性性行为|20|", length = 20, nullable = true)
   	private String gaySexBehavior;
	@Column(name = "ANAL_SEX", columnDefinition = "VARCHAR2|最近六个月内是否有肛交性行为|20|", length = 20, nullable = true)
   	private String analSex;
    @Column(name = "SIX_MONTH_ANAL_SEX_CONDOM", columnDefinition = "VARCHAR2|最近六个月内肛交性行为时是否使用过安全套|20|", length = 20, nullable = true)
   	private String sixMonthAnalSexCondom;
	@Column(name = "LAST_ANAL_SEX_CONDOM", columnDefinition = "VARCHAR2|最近一次肛交性行为时是否使用过安全套|20|", length = 20, nullable = true)
   	private String lastAnalSexCondom;	
	@Column(name = "BLOOD_RECEPTION_TYPE", columnDefinition = "VARCHAR2|受血类别|20|", length = 20, nullable = true)
   	private String bloodReceptionType;
	@Column(name = "FIRST_BLOOD_RECE_DATE", columnDefinition = "DATE|首次受血、血浆或血液制品时间||", nullable = true)
   	private Date firstBloodReceDate;
    @Column(name = "FIRST_BLOOD_RECE_ADDRESS", columnDefinition = "VARCHAR2|首次受血、血浆或血液制品地点|100|", length = 100, nullable = true)
   	private String firstBloodReceAddress;
    @Column(name = "LAST_BLOOD_RECE_DATE", columnDefinition = "DATE|末次受血、血浆或血液制品时间|20|", nullable = true)
   	private Date lastBloodReceDate;
	@Column(name = "LAST_BLOOD_RECE_ADDRESS", columnDefinition = "VARCHAR2|末次受血、血浆或血液制品地点|100|", length = 100, nullable = true)
   	private String lastBloodReceAddress;
    @Column(name = "FIRST_BLOOD_SUPPLY_DATE", columnDefinition = "DATE|首次供全血时间||", nullable = true)
   	private Date firstBloodSupplyDate;
	@Column(name = "FIRST_BLOOD_SUPPLY_ADDRESS", columnDefinition = "VARCHAR2|首次供全血地点|100|", length = 20, nullable = true)
   	private String firstBloodSupplyAddress;
	@Column(name = "FIRST_BLOOD_SUPPLY_UNIT", columnDefinition = "VARCHAR2|首次供全血采血单位|100|", length = 20, nullable = true)
   	private String firstBloodSupplyUnit;
	@Column(name = "LAST_BLOOD_SUPPLY_DATE", columnDefinition = "DATE|末次供全血时间||", nullable = true)
   	private Date lastBloodSupplyDate;
	@Column(name = "LAST_BLOOD_SUPPLY_ADDRESS", columnDefinition = "VARCHAR2|末次供全血地点|100|", length = 20, nullable = true)
   	private String lastBloodSupplyAddress;
	@Column(name = "LAST_BLOOD_SUPPLY_UNIT", columnDefinition = "VARCHAR2|末次供全血采血单位|100|", length = 20, nullable = true)
   	private String lastBloodSupplyUnit;
	@Column(name = "FIRST_PLASMA_SUPPLY_DATE", columnDefinition = "DATE|首次供血浆时间||", nullable = true)
   	private Date firstPlasmaSupplyDate;
	@Column(name = "FIRST_PLASMA_SUPPLY_ADDRESS", columnDefinition = "VARCHAR2|首次供血浆地点|100|", length = 20, nullable = true)
   	private String firstPlasmaSupplyAddress;
	@Column(name = "FIRST_PLASMA_SUPPLY_UNIT", columnDefinition = "VARCHAR2|首次供血浆采血单位|100|", length = 20, nullable = true)
   	private String firstPlasmaSupplyUnit;
	
	@Column(name = "LAST_PLASMA_SUPPLY_DATE", columnDefinition = "DATE|末次供血浆时间||", nullable = true)
   	private Date lastPlasmaSupplyDate;
	@Column(name = "LAST_PLASMA_SUPPLY_ADDRESS", columnDefinition = "VARCHAR2|末次供血浆地点|100|", length = 20, nullable = true)
   	private String lastPlasmaSupplyAddress;
	@Column(name = "LAST_PLASMA_SUPPLY_UNIT", columnDefinition = "VARCHAR2|末次供血浆采血单位|100|", length = 20, nullable = true)
   	private String lastPlasmaSupplyUnit;
	@Column(name = "HAVING_CHILDREN", columnDefinition = "VARCHAR2|目前有无子女|20|", length = 20, nullable = true)
   	private String havingChildren;
	@Column(name = "CHILDREN_HIV_POSITIVE", columnDefinition = "VARCHAR2|是否子女HIV阳性|20|", length = 20, nullable = true)
   	private String childrenHivPositive;
    @Column(name = "BLOCK_DRUG_THERAPY", columnDefinition = "VARCHAR2|患儿是否接受母婴阻断药物治疗|20|", length = 20, nullable = true)
   	private String blockDrugTherapy;
    @Column(name = "MOTHER_HIV_ANTIBODY", columnDefinition = "VARCHAR2|母亲HIV抗体|20|", nullable = true)
   	private String motherHivAntibody;
	@Column(name = "MOTHER_ANTIVIRAL_THERAPY", columnDefinition = "VARCHAR2|母亲是否接受过抗病毒药物治疗|20|", length = 20, nullable = true)
   	private String motherAntiviralTherapy;
	@Column(name = "FEEDING_WAY", columnDefinition = "VARCHAR2|喂养方式|20|", length = 20, nullable = true)
   	private String feedingWay;

	private String exposureHour;//暴露日期-小时
	private String handlingHour;//处理时间-小时
	private String rabiesVaccinationHourF;//首针时间-小时
	
	public Date getAcupunctureDate() {
		return acupunctureDate;
	}

	public void setAcupunctureDate(Date acupunctureDate) {
		this.acupunctureDate = acupunctureDate;
	}

	public String getTakeDrugHis() {
		return takeDrugHis;
	}

	public void setTakeDrugHis(String takeDrugHis) {
		this.takeDrugHis = takeDrugHis;
	}

	public Date getFirstTakeDrugDate() {
		return firstTakeDrugDate;
	}

	public void setFirstTakeDrugDate(Date firstTakeDrugDate) {
		this.firstTakeDrugDate = firstTakeDrugDate;
	}

	public String getTakeDrugWay() {
		return takeDrugWay;
	}

	public void setTakeDrugWay(String takeDrugWay) {
		this.takeDrugWay = takeDrugWay;
	}

	public String getDrugInjectionHis() {
		return drugInjectionHis;
	}

	public void setDrugInjectionHis(String drugInjectionHis) {
		this.drugInjectionHis = drugInjectionHis;
	}

	public Date getFirstDrugInjectionDate() {
		return firstDrugInjectionDate;
	}

	public void setFirstDrugInjectionDate(Date firstDrugInjectionDate) {
		this.firstDrugInjectionDate = firstDrugInjectionDate;
	}

	public String getSharedInjectorHis() {
		return sharedInjectorHis;
	}

	public void setSharedInjectorHis(String sharedInjectorHis) {
		this.sharedInjectorHis = sharedInjectorHis;
	}

	public String getTakeDrugPartner() {
		return takeDrugPartner;
	}

	public void setTakeDrugPartner(String takeDrugPartner) {
		this.takeDrugPartner = takeDrugPartner;
	}

	public String getSexBehaviorHis() {
		return sexBehaviorHis;
	}

	public void setSexBehaviorHis(String sexBehaviorHis) {
		this.sexBehaviorHis = sexBehaviorHis;
	}

	public String getOppositeSexBehavior() {
		return oppositeSexBehavior;
	}

	public void setOppositeSexBehavior(String oppositeSexBehavior) {
		this.oppositeSexBehavior = oppositeSexBehavior;
	}

	public String getCommercialSexBehavior() {
		return commercialSexBehavior;
	}

	public void setCommercialSexBehavior(String commercialSexBehavior) {
		this.commercialSexBehavior = commercialSexBehavior;
	}

	public String getLastComBehCondom() {
		return lastComBehCondom;
	}

	public void setLastComBehCondom(String lastComBehCondom) {
		this.lastComBehCondom = lastComBehCondom;
	}

	public String getLastMonthComBehCondom() {
		return lastMonthComBehCondom;
	}

	public void setLastMonthComBehCondom(String lastMonthComBehCondom) {
		this.lastMonthComBehCondom = lastMonthComBehCondom;
	}

	public String getMarriageSexBehavior() {
		return marriageSexBehavior;
	}

	public void setMarriageSexBehavior(String marriageSexBehavior) {
		this.marriageSexBehavior = marriageSexBehavior;
	}

	public String getLastMarBehCondom() {
		return lastMarBehCondom;
	}

	public void setLastMarBehCondom(String lastMarBehCondom) {
		this.lastMarBehCondom = lastMarBehCondom;
	}

	public String getLastMonthMarBehCondom() {
		return lastMonthMarBehCondom;
	}

	public void setLastMonthMarBehCondom(String lastMonthMarBehCondom) {
		this.lastMonthMarBehCondom = lastMonthMarBehCondom;
	}

	public String getNoComMarSexBeh() {
		return noComMarSexBeh;
	}

	public void setNoComMarSexBeh(String noComMarSexBeh) {
		this.noComMarSexBeh = noComMarSexBeh;
	}

	public String getLastNoComMarBehCondom() {
		return lastNoComMarBehCondom;
	}

	public void setLastNoComMarBehCondom(String lastNoComMarBehCondom) {
		this.lastNoComMarBehCondom = lastNoComMarBehCondom;
	}

	public String getLastMonNoComMarBehCondom() {
		return lastMonNoComMarBehCondom;
	}

	public void setLastMonNoComMarBehCondom(String lastMonNoComMarBehCondom) {
		this.lastMonNoComMarBehCondom = lastMonNoComMarBehCondom;
	}

	public String getGaySexBehavior() {
		return gaySexBehavior;
	}

	public void setGaySexBehavior(String gaySexBehavior) {
		this.gaySexBehavior = gaySexBehavior;
	}

	public String getAnalSex() {
		return analSex;
	}

	public void setAnalSex(String analSex) {
		this.analSex = analSex;
	}

	public String getSixMonthAnalSexCondom() {
		return sixMonthAnalSexCondom;
	}

	public void setSixMonthAnalSexCondom(String sixMonthAnalSexCondom) {
		this.sixMonthAnalSexCondom = sixMonthAnalSexCondom;
	}

	public String getLastAnalSexCondom() {
		return lastAnalSexCondom;
	}

	public void setLastAnalSexCondom(String lastAnalSexCondom) {
		this.lastAnalSexCondom = lastAnalSexCondom;
	}

	public String getBloodReceptionType() {
		return bloodReceptionType;
	}

	public void setBloodReceptionType(String bloodReceptionType) {
		this.bloodReceptionType = bloodReceptionType;
	}

	public Date getFirstBloodReceDate() {
		return firstBloodReceDate;
	}

	public void setFirstBloodReceDate(Date firstBloodReceDate) {
		this.firstBloodReceDate = firstBloodReceDate;
	}

	public String getFirstBloodReceAddress() {
		return firstBloodReceAddress;
	}

	public void setFirstBloodReceAddress(String firstBloodReceAddress) {
		this.firstBloodReceAddress = firstBloodReceAddress;
	}

	public Date getLastBloodReceDate() {
		return lastBloodReceDate;
	}

	public void setLastBloodReceDate(Date lastBloodReceDate) {
		this.lastBloodReceDate = lastBloodReceDate;
	}

	public String getLastBloodReceAddress() {
		return lastBloodReceAddress;
	}

	public void setLastBloodReceAddress(String lastBloodReceAddress) {
		this.lastBloodReceAddress = lastBloodReceAddress;
	}

	public Date getFirstBloodSupplyDate() {
		return firstBloodSupplyDate;
	}

	public void setFirstBloodSupplyDate(Date firstBloodSupplyDate) {
		this.firstBloodSupplyDate = firstBloodSupplyDate;
	}

	public String getFirstBloodSupplyAddress() {
		return firstBloodSupplyAddress;
	}

	public void setFirstBloodSupplyAddress(String firstBloodSupplyAddress) {
		this.firstBloodSupplyAddress = firstBloodSupplyAddress;
	}

	public String getFirstBloodSupplyUnit() {
		return firstBloodSupplyUnit;
	}

	public void setFirstBloodSupplyUnit(String firstBloodSupplyUnit) {
		this.firstBloodSupplyUnit = firstBloodSupplyUnit;
	}

	public Date getLastBloodSupplyDate() {
		return lastBloodSupplyDate;
	}

	public void setLastBloodSupplyDate(Date lastBloodSupplyDate) {
		this.lastBloodSupplyDate = lastBloodSupplyDate;
	}

	public String getLastBloodSupplyAddress() {
		return lastBloodSupplyAddress;
	}

	public void setLastBloodSupplyAddress(String lastBloodSupplyAddress) {
		this.lastBloodSupplyAddress = lastBloodSupplyAddress;
	}

	public String getLastBloodSupplyUnit() {
		return lastBloodSupplyUnit;
	}

	public void setLastBloodSupplyUnit(String lastBloodSupplyUnit) {
		this.lastBloodSupplyUnit = lastBloodSupplyUnit;
	}

	public Date getFirstPlasmaSupplyDate() {
		return firstPlasmaSupplyDate;
	}

	public void setFirstPlasmaSupplyDate(Date firstPlasmaSupplyDate) {
		this.firstPlasmaSupplyDate = firstPlasmaSupplyDate;
	}

	public String getFirstPlasmaSupplyAddress() {
		return firstPlasmaSupplyAddress;
	}

	public void setFirstPlasmaSupplyAddress(String firstPlasmaSupplyAddress) {
		this.firstPlasmaSupplyAddress = firstPlasmaSupplyAddress;
	}

	public String getFirstPlasmaSupplyUnit() {
		return firstPlasmaSupplyUnit;
	}

	public void setFirstPlasmaSupplyUnit(String firstPlasmaSupplyUnit) {
		this.firstPlasmaSupplyUnit = firstPlasmaSupplyUnit;
	}

	public Date getLastPlasmaSupplyDate() {
		return lastPlasmaSupplyDate;
	}

	public void setLastPlasmaSupplyDate(Date lastPlasmaSupplyDate) {
		this.lastPlasmaSupplyDate = lastPlasmaSupplyDate;
	}

	public String getLastPlasmaSupplyAddress() {
		return lastPlasmaSupplyAddress;
	}

	public void setLastPlasmaSupplyAddress(String lastPlasmaSupplyAddress) {
		this.lastPlasmaSupplyAddress = lastPlasmaSupplyAddress;
	}

	public String getLastPlasmaSupplyUnit() {
		return lastPlasmaSupplyUnit;
	}

	public void setLastPlasmaSupplyUnit(String lastPlasmaSupplyUnit) {
		this.lastPlasmaSupplyUnit = lastPlasmaSupplyUnit;
	}

	public String getHavingChildren() {
		return havingChildren;
	}

	public void setHavingChildren(String havingChildren) {
		this.havingChildren = havingChildren;
	}

	public String getChildrenHivPositive() {
		return childrenHivPositive;
	}

	public void setChildrenHivPositive(String childrenHivPositive) {
		this.childrenHivPositive = childrenHivPositive;
	}

	public String getBlockDrugTherapy() {
		return blockDrugTherapy;
	}

	public void setBlockDrugTherapy(String blockDrugTherapy) {
		this.blockDrugTherapy = blockDrugTherapy;
	}

	public String getMotherHivAntibody() {
		return motherHivAntibody;
	}

	public void setMotherHivAntibody(String motherHivAntibody) {
		this.motherHivAntibody = motherHivAntibody;
	}

	public String getMotherAntiviralTherapy() {
		return motherAntiviralTherapy;
	}

	public void setMotherAntiviralTherapy(String motherAntiviralTherapy) {
		this.motherAntiviralTherapy = motherAntiviralTherapy;
	}

	public String getFeedingWay() {
		return feedingWay;
	}

	public void setFeedingWay(String feedingWay) {
		this.feedingWay = feedingWay;
	}

	public String getBirdOccupation() {
		return birdOccupation;
	}

	public void setBirdOccupation(String birdOccupation) {
		this.birdOccupation = birdOccupation;
	}

	public String getBirdSpeciesOc() {
		return birdSpeciesOc;
	}

	public void setBirdSpeciesOc(String birdSpeciesOc) {
		this.birdSpeciesOc = birdSpeciesOc;
	}

	public String getBirdSpeciesOtherOc() {
		return birdSpeciesOtherOc;
	}

	public void setBirdSpeciesOtherOc(String birdSpeciesOtherOc) {
		this.birdSpeciesOtherOc = birdSpeciesOtherOc;
	}

	public String getContactWayOc() {
		return contactWayOc;
	}

	public void setContactWayOc(String contactWayOc) {
		this.contactWayOc = contactWayOc;
	}

	public String getContactWayOtherOc() {
		return contactWayOtherOc;
	}

	public void setContactWayOtherOc(String contactWayOtherOc) {
		this.contactWayOtherOc = contactWayOtherOc;
	}

	public String getContactBi() {
		return contactBi;
	}

	public void setContactBi(String contactBi) {
		this.contactBi = contactBi;
	}

	public String getContactHealthBi() {
		return contactHealthBi;
	}

	public void setContactHealthBi(String contactHealthBi) {
		this.contactHealthBi = contactHealthBi;
	}

	public String getContactFreHealthBi() {
		return contactFreHealthBi;
	}

	public void setContactFreHealthBi(String contactFreHealthBi) {
		this.contactFreHealthBi = contactFreHealthBi;
	}

	public String getContactDayHealthBi() {
		return contactDayHealthBi;
	}

	public void setContactDayHealthBi(String contactDayHealthBi) {
		this.contactDayHealthBi = contactDayHealthBi;
	}

	public String getBirdSpeciesHealthBi() {
		return birdSpeciesHealthBi;
	}

	public void setBirdSpeciesHealthBi(String birdSpeciesHealthBi) {
		this.birdSpeciesHealthBi = birdSpeciesHealthBi;
	}

	public String getContactWayHealthBi() {
		return contactWayHealthBi;
	}

	public void setContactWayHealthBi(String contactWayHealthBi) {
		this.contactWayHealthBi = contactWayHealthBi;
	}

	public String getHandHealthBi() {
		return handHealthBi;
	}

	public void setHandHealthBi(String handHealthBi) {
		this.handHealthBi = handHealthBi;
	}

	public String getProtectHealthBi() {
		return protectHealthBi;
	}

	public void setProtectHealthBi(String protectHealthBi) {
		this.protectHealthBi = protectHealthBi;
	}

	public String getProtectWayHealthBi() {
		return protectWayHealthBi;
	}

	public void setProtectWayHealthBi(String protectWayHealthBi) {
		this.protectWayHealthBi = protectWayHealthBi;
	}

	public String getContactWayOtherHealthBi() {
		return contactWayOtherHealthBi;
	}

	public void setContactWayOtherHealthBi(String contactWayOtherHealthBi) {
		this.contactWayOtherHealthBi = contactWayOtherHealthBi;
	}

	public String getContactDeathBi() {
		return contactDeathBi;
	}

	public void setContactDeathBi(String contactDeathBi) {
		this.contactDeathBi = contactDeathBi;
	}

	public String getContactFreDeathBi() {
		return contactFreDeathBi;
	}

	public void setContactFreDeathBi(String contactFreDeathBi) {
		this.contactFreDeathBi = contactFreDeathBi;
	}

	public String getContactDayDeathBi() {
		return contactDayDeathBi;
	}

	public void setContactDayDeathBi(String contactDayDeathBi) {
		this.contactDayDeathBi = contactDayDeathBi;
	}

	public String getBirdSpeciesDeathBi() {
		return birdSpeciesDeathBi;
	}

	public void setBirdSpeciesDeathBi(String birdSpeciesDeathBi) {
		this.birdSpeciesDeathBi = birdSpeciesDeathBi;
	}

	public String getContactWayDeathBi() {
		return contactWayDeathBi;
	}

	public void setContactWayDeathBi(String contactWayDeathBi) {
		this.contactWayDeathBi = contactWayDeathBi;
	}

	public String getHandDeathBi() {
		return handDeathBi;
	}

	public void setHandDeathBi(String handDeathBi) {
		this.handDeathBi = handDeathBi;
	}

	public String getProtectDeathBi() {
		return protectDeathBi;
	}

	public void setProtectDeathBi(String protectDeathBi) {
		this.protectDeathBi = protectDeathBi;
	}

	public String getProtectWayDeathBi() {
		return protectWayDeathBi;
	}

	public void setProtectWayDeathBi(String protectWayDeathBi) {
		this.protectWayDeathBi = protectWayDeathBi;
	}

	public String getProtectWayOtherDeathBi() {
		return protectWayOtherDeathBi;
	}

	public void setProtectWayOtherDeathBi(String protectWayOtherDeathBi) {
		this.protectWayOtherDeathBi = protectWayOtherDeathBi;
	}

	public String getToBreedEn() {
		return toBreedEn;
	}

	public void setToBreedEn(String toBreedEn) {
		this.toBreedEn = toBreedEn;
	}

	public String getContactFreBreedEn() {
		return contactFreBreedEn;
	}

	public void setContactFreBreedEn(String contactFreBreedEn) {
		this.contactFreBreedEn = contactFreBreedEn;
	}

	public String getContactDayBreedEn() {
		return contactDayBreedEn;
	}

	public void setContactDayBreedEn(String contactDayBreedEn) {
		this.contactDayBreedEn = contactDayBreedEn;
	}

	public String getBirdSpeciesBreedEn() {
		return birdSpeciesBreedEn;
	}

	public void setBirdSpeciesBreedEn(String birdSpeciesBreedEn) {
		this.birdSpeciesBreedEn = birdSpeciesBreedEn;
	}

	public String getBirdDeathBreedEn() {
		return birdDeathBreedEn;
	}

	public void setBirdDeathBreedEn(String birdDeathBreedEn) {
		this.birdDeathBreedEn = birdDeathBreedEn;
	}

	public String getWorkshopBreedEn() {
		return workshopBreedEn;
	}

	public void setWorkshopBreedEn(String workshopBreedEn) {
		this.workshopBreedEn = workshopBreedEn;
	}

	public String getContactBreedEn() {
		return contactBreedEn;
	}

	public void setContactBreedEn(String contactBreedEn) {
		this.contactBreedEn = contactBreedEn;
	}

	public String getToMarketEn() {
		return toMarketEn;
	}

	public void setToMarketEn(String toMarketEn) {
		this.toMarketEn = toMarketEn;
	}

	public String getContactFreMarketEn() {
		return contactFreMarketEn;
	}

	public void setContactFreMarketEn(String contactFreMarketEn) {
		this.contactFreMarketEn = contactFreMarketEn;
	}

	public String getContactDayMarketEn() {
		return contactDayMarketEn;
	}

	public void setContactDayMarketEn(String contactDayMarketEn) {
		this.contactDayMarketEn = contactDayMarketEn;
	}

	public String getPassagewayMarketEn() {
		return passagewayMarketEn;
	}

	public void setPassagewayMarketEn(String passagewayMarketEn) {
		this.passagewayMarketEn = passagewayMarketEn;
	}

	public String getNearMarketEn() {
		return nearMarketEn;
	}

	public void setNearMarketEn(String nearMarketEn) {
		this.nearMarketEn = nearMarketEn;
	}

	public String getContactMarketEn() {
		return contactMarketEn;
	}

	public void setContactMarketEn(String contactMarketEn) {
		this.contactMarketEn = contactMarketEn;
	}

	public String getVisitNumMarketEn() {
		return visitNumMarketEn;
	}

	public void setVisitNumMarketEn(String visitNumMarketEn) {
		this.visitNumMarketEn = visitNumMarketEn;
	}

	public String getRelativesCa() {
		return relativesCa;
	}

	public void setRelativesCa(String relativesCa) {
		this.relativesCa = relativesCa;
	}

	public String getRelationshipCa() {
		return relationshipCa;
	}

	public void setRelationshipCa(String relationshipCa) {
		this.relationshipCa = relationshipCa;
	}

	public String getContactCa() {
		return contactCa;
	}

	public void setContactCa(String contactCa) {
		this.contactCa = contactCa;
	}

	public String getContactFreCa() {
		return contactFreCa;
	}

	public void setContactFreCa(String contactFreCa) {
		this.contactFreCa = contactFreCa;
	}

	public String getContactDayCa() {
		return contactDayCa;
	}

	public void setContactDayCa(String contactDayCa) {
		this.contactDayCa = contactDayCa;
	}

	public String getContactWayCa() {
		return contactWayCa;
	}

	public void setContactWayCa(String contactWayCa) {
		this.contactWayCa = contactWayCa;
	}

	public String getDiagnosisCa() {
		return diagnosisCa;
	}

	public void setDiagnosisCa(String diagnosisCa) {
		this.diagnosisCa = diagnosisCa;
	}

	public String getProtectCa() {
		return protectCa;
	}

	public void setProtectCa(String protectCa) {
		this.protectCa = protectCa;
	}

	public String getProtectWayCa() {
		return protectWayCa;
	}

	public void setProtectWayCa(String protectWayCa) {
		this.protectWayCa = protectWayCa;
	}

	public String getContactTimeCa() {
		return contactTimeCa;
	}

	public void setContactTimeCa(String contactTimeCa) {
		this.contactTimeCa = contactTimeCa;
	}

	public String getContactFe() {
		return contactFe;
	}

	public void setContactFe(String contactFe) {
		this.contactFe = contactFe;
	}

	public String getContactFreFe() {
		return contactFreFe;
	}

	public void setContactFreFe(String contactFreFe) {
		this.contactFreFe = contactFreFe;
	}

	public String getContactDayFe() {
		return contactDayFe;
	}

	public void setContactDayFe(String contactDayFe) {
		this.contactDayFe = contactDayFe;
	}

	public String getContactWayFe() {
		return contactWayFe;
	}

	public void setContactWayFe(String contactWayFe) {
		this.contactWayFe = contactWayFe;
	}

	public String getDiagnosisFe() {
		return diagnosisFe;
	}

	public void setDiagnosisFe(String diagnosisFe) {
		this.diagnosisFe = diagnosisFe;
	}

	public String getProtectFe() {
		return protectFe;
	}

	public void setProtectFe(String protectFe) {
		this.protectFe = protectFe;
	}

	public String getProtectWayFe() {
		return protectWayFe;
	}

	public void setProtectWayFe(String protectWayFe) {
		this.protectWayFe = protectWayFe;
	}

	public String getContactTimeFe() {
		return contactTimeFe;
	}

	public void setContactTimeFe(String contactTimeFe) {
		this.contactTimeFe = contactTimeFe;
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

	public String getAddrProvince() {
		return this.addrProvince;
	}

	public void setAddrProvince(String addrProvince) {
		this.addrProvince = addrProvince;
	}

	public String getAddrCity() {
		return this.addrCity;
	}

	public void setAddrCity(String addrCity) {
		this.addrCity = addrCity;
	}

	public String getAddrCounty() {
		return this.addrCounty;
	}

	public void setAddrCounty(String addrCounty) {
		this.addrCounty = addrCounty;
	}

	public String getAddrRural() {
		return this.addrRural;
	}

	public void setAddrRural(String addrRural) {
		this.addrRural = addrRural;
	}

	public String getAddrVillage() {
		return this.addrVillage;
	}

	public void setAddrVillage(String addrVillage) {
		this.addrVillage = addrVillage;
	}

	public String getAddrGroup() {
		return this.addrGroup;
	}

	public void setAddrGroup(String addrGroup) {
		this.addrGroup = addrGroup;
	}

	public String getExposureWay() {
		return this.exposureWay;
	}

	public void setExposureWay(String exposureWay) {
		this.exposureWay = exposureWay;
	}

	public String getExposureLevel() {
		return this.exposureLevel;
	}

	public void setExposureLevel(String exposureLevel) {
		this.exposureLevel = exposureLevel;
	}

	public String getExposurePart() {
		return this.exposurePart;
	}

	public void setExposurePart(String exposurePart) {
		this.exposurePart = exposurePart;
	}

	public String getWoundManagement() {
		return this.woundManagement;
	}

	public void setWoundManagement(String woundManagement) {
		this.woundManagement = woundManagement;
	}

	public Date getHandlingTime() {
		return this.handlingTime;
	}

	public void setHandlingTime(Date handlingTime) {
		this.handlingTime = handlingTime;
	}

	public String getHandlingUnit() {
		return this.handlingUnit;
	}

	public void setHandlingUnit(String handlingUnit) {
		this.handlingUnit = handlingUnit;
	}

	public String getHandlingUnitOther() {
		return this.handlingUnitOther;
	}

	public void setHandlingUnitOther(String handlingUnitOther) {
		this.handlingUnitOther = handlingUnitOther;
	}

	public String getHandlingWay() {
		return this.handlingWay;
	}

	public void setHandlingWay(String handlingWay) {
		this.handlingWay = handlingWay;
	}

	public String getHandlingWayOther() {
		return this.handlingWayOther;
	}

	public void setHandlingWayOther(String handlingWayOther) {
		this.handlingWayOther = handlingWayOther;
	}

	public String getImmunizationHistory() {
		return this.immunizationHistory;
	}

	public void setImmunizationHistory(String immunizationHistory) {
		this.immunizationHistory = immunizationHistory;
	}

	public Date getImmunizationDt() {
		return this.immunizationDt;
	}

	public void setImmunizationDt(Date immunizationDt) {
		this.immunizationDt = immunizationDt;
	}

	public String getAntiserumInjection() {
		return this.antiserumInjection;
	}

	public void setAntiserumInjection(String antiserumInjection) {
		this.antiserumInjection = antiserumInjection;
	}

	public String getAntiserumInjectionCategory() {
		return this.antiserumInjectionCategory;
	}

	public void setAntiserumInjectionCategory(String antiserumInjectionCategory) {
		this.antiserumInjectionCategory = antiserumInjectionCategory;
	}

	public Date getAntiserumInjectionDt() {
		return this.antiserumInjectionDt;
	}

	public void setAntiserumInjectionDt(Date antiserumInjectionDt) {
		this.antiserumInjectionDt = antiserumInjectionDt;
	}

	public String getAntiserumInjectionMeasure() {
		return this.antiserumInjectionMeasure;
	}

	public void setAntiserumInjectionMeasure(String antiserumInjectionMeasure) {
		this.antiserumInjectionMeasure = antiserumInjectionMeasure;
	}

	public String getIrritability() {
		return this.irritability;
	}

	public void setIrritability(String irritability) {
		this.irritability = irritability;
	}

	public String getIrritabilityDetail() {
		return this.irritabilityDetail;
	}

	public void setIrritabilityDetail(String irritabilityDetail) {
		this.irritabilityDetail = irritabilityDetail;
	}

	public String getRabiesVaccination() {
		return this.rabiesVaccination;
	}

	public void setRabiesVaccination(String rabiesVaccination) {
		this.rabiesVaccination = rabiesVaccination;
	}

	public String getRabiesVaccinationUnit() {
		return this.rabiesVaccinationUnit;
	}

	public void setRabiesVaccinationUnit(String rabiesVaccinationUnit) {
		this.rabiesVaccinationUnit = rabiesVaccinationUnit;
	}

	public String getRabiesVaccinationUnitOther() {
		return this.rabiesVaccinationUnitOther;
	}

	public void setRabiesVaccinationUnitOther(String rabiesVaccinationUnitOther) {
		this.rabiesVaccinationUnitOther = rabiesVaccinationUnitOther;
	}

	public String getRabiesVaccinationCategory() {
		return this.rabiesVaccinationCategory;
	}

	public void setRabiesVaccinationCategory(String rabiesVaccinationCategory) {
		this.rabiesVaccinationCategory = rabiesVaccinationCategory;
	}

	public Date getRabiesVaccinationDtF() {
		return this.rabiesVaccinationDtF;
	}

	public void setRabiesVaccinationDtF(Date rabiesVaccinationDtF) {
		this.rabiesVaccinationDtF = rabiesVaccinationDtF;
	}

	public String getRabiesVaccinationMeasureF() {
		return this.rabiesVaccinationMeasureF;
	}

	public void setRabiesVaccinationMeasureF(String rabiesVaccinationMeasureF) {
		this.rabiesVaccinationMeasureF = rabiesVaccinationMeasureF;
	}

	public String getImmuneProcedure() {
		return this.immuneProcedure;
	}

	public void setImmuneProcedure(String immuneProcedure) {
		this.immuneProcedure = immuneProcedure;
	}

	public String getImmuneProcedureOther() {
		return this.immuneProcedureOther;
	}

	public void setImmuneProcedureOther(String immuneProcedureOther) {
		this.immuneProcedureOther = immuneProcedureOther;
	}

	public String getRabiesVaccinationNum() {
		return this.rabiesVaccinationNum;
	}

	public void setRabiesVaccinationNum(String rabiesVaccinationNum) {
		this.rabiesVaccinationNum = rabiesVaccinationNum;
	}

	public String getRabiesVaccinationUndo() {
		return this.rabiesVaccinationUndo;
	}

	public void setRabiesVaccinationUndo(String rabiesVaccinationUndo) {
		this.rabiesVaccinationUndo = rabiesVaccinationUndo;
	}

	public String getRabiesVaccinationReinforced() {
		return this.rabiesVaccinationReinforced;
	}

	public void setRabiesVaccinationReinforced(String rabiesVaccinationReinforced) {
		this.rabiesVaccinationReinforced = rabiesVaccinationReinforced;
	}

	public String getReinforcedNum() {
		return this.reinforcedNum;
	}

	public void setReinforcedNum(String reinforcedNum) {
		this.reinforcedNum = reinforcedNum;
	}

	public String getReinforcedUnit() {
		return this.reinforcedUnit;
	}

	public void setReinforcedUnit(String reinforcedUnit) {
		this.reinforcedUnit = reinforcedUnit;
	}

	public String getReinforcedBatch() {
		return this.reinforcedBatch;
	}

	public void setReinforcedBatch(String reinforcedBatch) {
		this.reinforcedBatch = reinforcedBatch;
	}

	public Date getRabiesVaccinationExpDt() {
		return this.rabiesVaccinationExpDt;
	}

	public void setRabiesVaccinationExpDt(Date rabiesVaccinationExpDt) {
		this.rabiesVaccinationExpDt = rabiesVaccinationExpDt;
	}

	public String getCaseArea() {
		return this.caseArea;
	}

	public void setCaseArea(String caseArea) {
		this.caseArea = caseArea;
	}

	public String getCaseAreaAddr() {
		return this.caseAreaAddr;
	}

	public void setCaseAreaAddr(String caseAreaAddr) {
		this.caseAreaAddr = caseAreaAddr;
	}

	public String getDoubtfulHn() {
		return this.doubtfulHn;
	}

	public void setDoubtfulHn(String doubtfulHn) {
		this.doubtfulHn = doubtfulHn;
	}

	public String getDiagnosisHn() {
		return this.diagnosisHn;
	}

	public void setDiagnosisHn(String diagnosisHn) {
		this.diagnosisHn = diagnosisHn;
	}

	public String getFeverPatient() {
		return this.feverPatient;
	}

	public void setFeverPatient(String feverPatient) {
		this.feverPatient = feverPatient;
	}

	public String getRespiratorySymptomsPatient() {
		return this.respiratorySymptomsPatient;
	}

	public void setRespiratorySymptomsPatient(String respiratorySymptomsPatient) {
		this.respiratorySymptomsPatient = respiratorySymptomsPatient;
	}

	public String getPatientOther() {
		return this.patientOther;
	}

	public void setPatientOther(String patientOther) {
		this.patientOther = patientOther;
	}

	public Date getExposureDtFirst() {
		return this.exposureDtFirst;
	}

	public void setExposureDtFirst(Date exposureDtFirst) {
		this.exposureDtFirst = exposureDtFirst;
	}

	public Date getExposureDtLast() {
		return this.exposureDtLast;
	}

	public void setExposureDtLast(Date exposureDtLast) {
		this.exposureDtLast = exposureDtLast;
	}

	public String getContactWay() {
		return this.contactWay;
	}

	public void setContactWay(String contactWay) {
		this.contactWay = contactWay;
	}

	public String getContactWayOther() {
		return this.contactWayOther;
	}

	public void setContactWayOther(String contactWayOther) {
		this.contactWayOther = contactWayOther;
	}

	public String getConservatoryMeasure() {
		return this.conservatoryMeasure;
	}

	public void setConservatoryMeasure(String conservatoryMeasure) {
		this.conservatoryMeasure = conservatoryMeasure;
	}

	public String getConservatoryMeasureWay() {
		return this.conservatoryMeasureWay;
	}

	public void setConservatoryMeasureWay(String conservatoryMeasureWay) {
		this.conservatoryMeasureWay = conservatoryMeasureWay;
	}

	public String getHnLab() {
		return this.hnLab;
	}

	public void setHnLab(String hnLab) {
		this.hnLab = hnLab;
	}

	public String getConservatoryMeasureLab() {
		return this.conservatoryMeasureLab;
	}

	public void setConservatoryMeasureLab(String conservatoryMeasureLab) {
		this.conservatoryMeasureLab = conservatoryMeasureLab;
	}

	public String getContactAnimal() {
		return this.contactAnimal;
	}

	public void setContactAnimal(String contactAnimal) {
		this.contactAnimal = contactAnimal;
	}

	public String getContactAnimalCategory() {
		return this.contactAnimalCategory;
	}

	public void setContactAnimalCategory(String contactAnimalCategory) {
		this.contactAnimalCategory = contactAnimalCategory;
	}

	public String getContactAnimalWay() {
		return this.contactAnimalWay;
	}

	public void setContactAnimalWay(String contactAnimalWay) {
		this.contactAnimalWay = contactAnimalWay;
	}

	public Date getContactAnimalDt() {
		return this.contactAnimalDt;
	}

	public void setContactAnimalDt(Date contactAnimalDt) {
		this.contactAnimalDt = contactAnimalDt;
	}

	public String getWaterCategory() {
		return this.waterCategory;
	}

	public void setWaterCategory(String waterCategory) {
		this.waterCategory = waterCategory;
	}

	public String getPublicPlace() {
		return this.publicPlace;
	}

	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	public String getDieAnimalCategory() {
		return this.dieAnimalCategory;
	}

	public void setDieAnimalCategory(String dieAnimalCategory) {
		this.dieAnimalCategory = dieAnimalCategory;
	}

	public String getAnimalContactCategory() {
		return this.animalContactCategory;
	}

	public void setAnimalContactCategory(String animalContactCategory) {
		this.animalContactCategory = animalContactCategory;
	}

	public String getAnimalContactWay() {
		return this.animalContactWay;
	}

	public void setAnimalContactWay(String animalContactWay) {
		this.animalContactWay = animalContactWay;
	}

	public Date getAnimalContactDt() {
		return this.animalContactDt;
	}

	public void setAnimalContactDt(Date animalContactDt) {
		this.animalContactDt = animalContactDt;
	}

	public String getBoilCategory() {
		return this.boilCategory;
	}

	public void setBoilCategory(String boilCategory) {
		this.boilCategory = boilCategory;
	}

	public String getSlaughterCategoey() {
		return this.slaughterCategoey;
	}

	public void setSlaughterCategoey(String slaughterCategoey) {
		this.slaughterCategoey = slaughterCategoey;
	}

	public String getWoundCategory() {
		return this.woundCategory;
	}

	public void setWoundCategory(String woundCategory) {
		this.woundCategory = woundCategory;
	}

	public String getConservatoryMeasureAnimal() {
		return this.conservatoryMeasureAnimal;
	}

	public void setConservatoryMeasureAnimal(String conservatoryMeasureAnimal) {
		this.conservatoryMeasureAnimal = conservatoryMeasureAnimal;
	}

	public String getDieAnimalWaterCategory() {
		return this.dieAnimalWaterCategory;
	}

	public void setDieAnimalWaterCategory(String dieAnimalWaterCategory) {
		this.dieAnimalWaterCategory = dieAnimalWaterCategory;
	}

	public String getFeverPatientContact() {
		return this.feverPatientContact;
	}

	public void setFeverPatientContact(String feverPatientContact) {
		this.feverPatientContact = feverPatientContact;
	}

	public String getMask() {
		return this.mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public String getWater() {
		return this.water;
	}

	public void setWater(String water) {
		this.water = water;
	}

    public String getHnLabWeek() {
        return hnLabWeek;
    }

    public void setHnLabWeek(String hnLabWeek) {
        this.hnLabWeek = hnLabWeek;
    }

    public String getConservatoryMeasureLabWeek() {
		return this.conservatoryMeasureLabWeek;
	}

	public void setConservatoryMeasureLabWeek(String conservatoryMeasureLabWeek) {
		this.conservatoryMeasureLabWeek = conservatoryMeasureLabWeek;
	}

	public String getInHospital() {
		return this.inHospital;
	}

	public void setInHospital(String inHospital) {
		this.inHospital = inHospital;
	}

	public Date getInHospitalDt() {
		return this.inHospitalDt;
	}

	public void setInHospitalDt(Date inHospitalDt) {
		this.inHospitalDt = inHospitalDt;
	}

	public Date getOutHospitalDt() {
		return this.outHospitalDt;
	}

	public void setOutHospitalDt(Date outHospitalDt) {
		this.outHospitalDt = outHospitalDt;
	}

	public String getHospitalUnit() {
		return this.hospitalUnit;
	}

	public void setHospitalUnit(String hospitalUnit) {
		this.hospitalUnit = hospitalUnit;
	}

	public String getInHospitalDepartment() {
		return this.inHospitalDepartment;
	}

	public void setInHospitalDepartment(String inHospitalDepartment) {
		this.inHospitalDepartment = inHospitalDepartment;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getOperationDetail() {
		return this.operationDetail;
	}

	public void setOperationDetail(String operationDetail) {
		this.operationDetail = operationDetail;
	}

	public Date getOperationDt() {
		return this.operationDt;
	}

	public void setOperationDt(Date operationDt) {
		this.operationDt = operationDt;
	}

	public String getOperationUnit() {
		return this.operationUnit;
	}

	public void setOperationUnit(String operationUnit) {
		this.operationUnit = operationUnit;
	}

	public String getReceptionBloodHistory() {
		return this.receptionBloodHistory;
	}

	public void setReceptionBloodHistory(String receptionBloodHistory) {
		this.receptionBloodHistory = receptionBloodHistory;
	}

	public String getReceptionBloodNum() {
		return this.receptionBloodNum;
	}

	public void setReceptionBloodNum(String receptionBloodNum) {
		this.receptionBloodNum = receptionBloodNum;
	}

	public String getReceptionBloodMeasure() {
		return this.receptionBloodMeasure;
	}

	public void setReceptionBloodMeasure(String receptionBloodMeasure) {
		this.receptionBloodMeasure = receptionBloodMeasure;
	}

	public Date getReceptionBloodBeginDt() {
		return this.receptionBloodBeginDt;
	}

	public void setReceptionBloodBeginDt(Date receptionBloodBeginDt) {
		this.receptionBloodBeginDt = receptionBloodBeginDt;
	}

	public String getReceptionBloodUnit() {
		return this.receptionBloodUnit;
	}

	public void setReceptionBloodUnit(String receptionBloodUnit) {
		this.receptionBloodUnit = receptionBloodUnit;
	}

	public String getDonateBloodHistory() {
		return this.donateBloodHistory;
	}

	public void setDonateBloodHistory(String donateBloodHistory) {
		this.donateBloodHistory = donateBloodHistory;
	}

	public String getDonateBloodNum() {
		return this.donateBloodNum;
	}

	public void setDonateBloodNum(String donateBloodNum) {
		this.donateBloodNum = donateBloodNum;
	}

	public String getDonateBloodUnit() {
		return this.donateBloodUnit;
	}

	public void setDonateBloodUnit(String donateBloodUnit) {
		this.donateBloodUnit = donateBloodUnit;
	}

	public String getDonateBloodCategory() {
		return this.donateBloodCategory;
	}

	public void setDonateBloodCategory(String donateBloodCategory) {
		this.donateBloodCategory = donateBloodCategory;
	}

	public String getIvt() {
		return this.ivt;
	}

	public void setIvt(String ivt) {
		this.ivt = ivt;
	}

	public String getIvtUnit() {
		return this.ivtUnit;
	}

	public void setIvtUnit(String ivtUnit) {
		this.ivtUnit = ivtUnit;
	}

	public String getAcupuncture() {
		return this.acupuncture;
	}

	public void setAcupuncture(String acupuncture) {
		this.acupuncture = acupuncture;
	}

	public String getAcupunctureUnit() {
		return this.acupunctureUnit;
	}

	public void setAcupunctureUnit(String acupunctureUnit) {
		this.acupunctureUnit = acupunctureUnit;
	}

	public String getIntravenousInjection() {
		return this.intravenousInjection;
	}

	public void setIntravenousInjection(String intravenousInjection) {
		this.intravenousInjection = intravenousInjection;
	}

	public String getIiDisposableSyringe() {
		return this.iiDisposableSyringe;
	}

	public void setIiDisposableSyringe(String iiDisposableSyringe) {
		this.iiDisposableSyringe = iiDisposableSyringe;
	}

	public String getIiNeedleTubing() {
		return this.iiNeedleTubing;
	}

	public void setIiNeedleTubing(String iiNeedleTubing) {
		this.iiNeedleTubing = iiNeedleTubing;
	}

	public String getIntravenousInjectionUnit() {
		return this.intravenousInjectionUnit;
	}

	public void setIntravenousInjectionUnit(String intravenousInjectionUnit) {
		this.intravenousInjectionUnit = intravenousInjectionUnit;
	}

	public String getVaccination() {
		return this.vaccination;
	}

	public void setVaccination(String vaccination) {
		this.vaccination = vaccination;
	}

	public String getVaDisposableSyringe() {
		return this.vaDisposableSyringe;
	}

	public void setVaDisposableSyringe(String vaDisposableSyringe) {
		this.vaDisposableSyringe = vaDisposableSyringe;
	}

	public String getVaNeedleTubing() {
		return this.vaNeedleTubing;
	}

	public void setVaNeedleTubing(String vaNeedleTubing) {
		this.vaNeedleTubing = vaNeedleTubing;
	}

	public String getVaccinationUnit() {
		return this.vaccinationUnit;
	}

	public void setVaccinationUnit(String vaccinationUnit) {
		this.vaccinationUnit = vaccinationUnit;
	}

	public String getTooth() {
		return this.tooth;
	}

	public void setTooth(String tooth) {
		this.tooth = tooth;
	}

	public String getToothNum() {
		return this.toothNum;
	}

	public void setToothNum(String toothNum) {
		this.toothNum = toothNum;
	}

	public Date getToothDt() {
		return this.toothDt;
	}

	public void setToothDt(Date toothDt) {
		this.toothDt = toothDt;
	}

	public String getToothUnit() {
		return this.toothUnit;
	}

	public void setToothUnit(String toothUnit) {
		this.toothUnit = toothUnit;
	}

	public String getHbv() {
		return this.hbv;
	}

	public void setHbv(String hbv) {
		this.hbv = hbv;
	}

	public String getHbvRelation() {
		return this.hbvRelation;
	}

	public void setHbvRelation(String hbvRelation) {
		this.hbvRelation = hbvRelation;
	}

	public String getShareToothbrush() {
		return this.shareToothbrush;
	}

	public void setShareToothbrush(String shareToothbrush) {
		this.shareToothbrush = shareToothbrush;
	}

	public String getShareToothCup() {
		return this.shareToothCup;
	}

	public void setShareToothCup(String shareToothCup) {
		this.shareToothCup = shareToothCup;
	}

	public String getShareRazor() {
		return this.shareRazor;
	}

	public void setShareRazor(String shareRazor) {
		this.shareRazor = shareRazor;
	}

	public String getPiles() {
		return this.piles;
	}

	public void setPiles(String piles) {
		this.piles = piles;
	}

	public String getMensePollute() {
		return this.mensePollute;
	}

	public void setMensePollute(String mensePollute) {
		this.mensePollute = mensePollute;
	}

	public String getShave() {
		return this.shave;
	}

	public void setShave(String shave) {
		this.shave = shave;
	}

	public String getTattooingEyebrow() {
		return this.tattooingEyebrow;
	}

	public void setTattooingEyebrow(String tattooingEyebrow) {
		this.tattooingEyebrow = tattooingEyebrow;
	}

	public String getTattoo() {
		return this.tattoo;
	}

	public void setTattoo(String tattoo) {
		this.tattoo = tattoo;
	}

	public String getHepatitisBPatientContact() {
		return this.hepatitisBPatientContact;
	}

	public void setHepatitisBPatientContact(String hepatitisBPatientContact) {
		this.hepatitisBPatientContact = hepatitisBPatientContact;
	}

	public String getHepatitisBPatientCategory() {
		return this.hepatitisBPatientCategory;
	}

	public void setHepatitisBPatientCategory(String hepatitisBPatientCategory) {
		this.hepatitisBPatientCategory = hepatitisBPatientCategory;
	}

	public String getHepatitisBPatientOther() {
		return this.hepatitisBPatientOther;
	}

	public void setHepatitisBPatientOther(String hepatitisBPatientOther) {
		this.hepatitisBPatientOther = hepatitisBPatientOther;
	}

	public String getInterventionalHistory() {
		return this.interventionalHistory;
	}

	public void setInterventionalHistory(String interventionalHistory) {
		this.interventionalHistory = interventionalHistory;
	}

	public String getShareSyringe() {
		return this.shareSyringe;
	}

	public void setShareSyringe(String shareSyringe) {
		this.shareSyringe = shareSyringe;
	}

	public String getTraumaticTreatment() {
		return this.traumaticTreatment;
	}

	public void setTraumaticTreatment(String traumaticTreatment) {
		this.traumaticTreatment = traumaticTreatment;
	}

	public String getShaveFrequency() {
		return this.shaveFrequency;
	}

	public void setShaveFrequency(String shaveFrequency) {
		this.shaveFrequency = shaveFrequency;
	}

	public String getPedicureFrequency() {
		return this.pedicureFrequency;
	}

	public void setPedicureFrequency(String pedicureFrequency) {
		this.pedicureFrequency = pedicureFrequency;
	}

	public String getHemodialysisHistory() {
		return this.hemodialysisHistory;
	}

	public void setHemodialysisHistory(String hemodialysisHistory) {
		this.hemodialysisHistory = hemodialysisHistory;
	}

	public String getBloodSample() {
		return this.bloodSample;
	}

	public void setBloodSample(String bloodSample) {
		this.bloodSample = bloodSample;
	}

	public String getBloodSampleFrequency() {
		return this.bloodSampleFrequency;
	}

	public void setBloodSampleFrequency(String bloodSampleFrequency) {
		this.bloodSampleFrequency = bloodSampleFrequency;
	}

	public Date getReceptionBloodEndDt() {
		return this.receptionBloodEndDt;
	}

	public void setReceptionBloodEndDt(Date receptionBloodEndDt) {
		this.receptionBloodEndDt = receptionBloodEndDt;
	}

	public String getPatLiveEnvir() {
		return this.patLiveEnvir;
	}

	public void setPatLiveEnvir(String patLiveEnvir) {
		this.patLiveEnvir = patLiveEnvir;
	}

	public String getIsMarket() {
		return this.isMarket;
	}

	public void setIsMarket(String isMarket) {
		this.isMarket = isMarket;
	}

	public String getIsSeeAnimal() {
		return this.isSeeAnimal;
	}

	public void setIsSeeAnimal(String isSeeAnimal) {
		this.isSeeAnimal = isSeeAnimal;
	}

	public String getIsDieAnimal() {
		return this.isDieAnimal;
	}

	public void setIsDieAnimal(String isDieAnimal) {
		this.isDieAnimal = isDieAnimal;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getDieAnimalDate() {
		return this.dieAnimalDate;
	}

	public void setDieAnimalDate(Date dieAnimalDate) {
		this.dieAnimalDate = dieAnimalDate;
	}

	public String getIsDieLive() {
		return this.isDieLive;
	}

	public void setIsDieLive(String isDieLive) {
		this.isDieLive = isDieLive;
	}

    public String getIsDieHn() {
        return this.isDieHn;
    }

    public void setIsDieHn(String isDieHn) {
        this.isDieHn = isDieHn;
    }

    public String getIsDisinfect() {
		return this.isDisinfect;
	}

	public void setIsDisinfect(String isDisinfect) {
		this.isDisinfect = isDisinfect;
	}

	public Date getDisinfectDate() {
		return this.disinfectDate;
	}

	public void setDisinfectDate(Date disinfectDate) {
		this.disinfectDate = disinfectDate;
	}

	public String getIsPat() {
		return this.isPat;
	}

	public void setIsPat(String isPat) {
		this.isPat = isPat;
	}

	public String getConservatoryMeasureWayOther() {
		return this.conservatoryMeasureWayOther;
	}

	public void setConservatoryMeasureWayOther(String conservatoryMeasureWayOther) {
		this.conservatoryMeasureWayOther = conservatoryMeasureWayOther;
	}

	public String getImmunizationHistoryNum() {
		return this.immunizationHistoryNum;
	}

	public void setImmunizationHistoryNum(String immunizationHistoryNum) {
		this.immunizationHistoryNum = immunizationHistoryNum;
	}

	public String getExposureWayOther() {
		return this.exposureWayOther;
	}

	public void setExposureWayOther(String exposureWayOther) {
		this.exposureWayOther = exposureWayOther;
	}

	public Date getExposureDt() {
		return this.exposureDt;
	}

	public void setExposureDt(Date exposureDt) {
		this.exposureDt = exposureDt;
	}

	public String getExposureHour() {
		return exposureHour;
	}

	public void setExposureHour(String exposureHour) {
		this.exposureHour = exposureHour;
	}

	public String getHandlingHour() {
		return handlingHour;
	}

	public void setHandlingHour(String handlingHour) {
		this.handlingHour = handlingHour;
	}

	public String getRabiesVaccinationHourF() {
		return rabiesVaccinationHourF;
	}

	public void setRabiesVaccinationHourF(String rabiesVaccinationHourF) {
		this.rabiesVaccinationHourF = rabiesVaccinationHourF;
	}

}
