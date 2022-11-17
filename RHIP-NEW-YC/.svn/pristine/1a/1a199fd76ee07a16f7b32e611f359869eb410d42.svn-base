package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 *流行病学调查
 */
@Entity
@Table(name = "IDM_EPIDEMIOLOGICAL_SURVEY")
public class EpidemiologicalSurvey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编码|11|", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "USE_CONDOM", columnDefinition = "VARCHAR2|婚外性接触时，避孕套使用情况|2|", length = 2, nullable = true)
	private String useCondom;

	@Column(name = "LAST_EXTRAMARITAL_SEX_DAYS", columnDefinition = "VARCHAR2|最近一次婚外性接触时间(天数)|20|", length = 20, nullable = true)
	private String lastExtramaritalSexDays;

	@Column(name = "ONE_MONTH_DOUBTFUL_WATER", columnDefinition = "VARCHAR2|发病前1月内接触可疑疫水|2|", length = 2, nullable = true)
	private String oneMonthDoubtfulWater;

	@Column(name = "ONE_MONTH_DOUBTFUL_WATER_DT", columnDefinition = "DATE|发病前1月内接触可疑疫水时间||", nullable = true)
	private Date oneMonthDoubtfulWaterDt;

	@Column(name = "DOUBTFUL_CONTACT_WAY", columnDefinition = "VARCHAR2|接触方式|2|", length = 2, nullable = true)
	private String doubtfulContactWay;

	@Column(name = "CONTACT_RELATION_OTHER", columnDefinition = "VARCHAR2|接触方式-其他|20|", length = 20, nullable = true)
	private String contactRelationOther;
	
	@Column(name = "ONE_MONTH_MOUSE", columnDefinition = "VARCHAR2|发病前1月内是否接触鼠类|2|", length = 2, nullable = true)
	private String oneMonthMouse;

	@Column(name = "ONE_MONTH_MOUSE_CONTACT", columnDefinition = "VARCHAR2|发病前1月内是否接触鼠类接触方式|2|", length = 2, nullable = true)
	private String oneMonthMouseContact;

	@Column(name = "ONE_MONTH_MOUSE_ANIMAL", columnDefinition = "VARCHAR2|发病前1月内是否接触其它动物及其排泄物|2|", length = 2, nullable = true)
	private String oneMonthMouseAnimal;

	@Column(name = "ANIMAL_CATEGORY", columnDefinition = "VARCHAR2|动物种类|2|", length = 2, nullable = true)
	private String animalCategory;

	@Column(name = "LEPTOSPIROSIS_VACCINATION", columnDefinition = "VARCHAR2|钩体病疫苗预防接种史|2|", length = 2, nullable = true)
	private String leptospirosisVaccination;

	@Column(name = "LAST_INOCULATE_DT", columnDefinition = "DATE|最近一次接种时间||", nullable = true)
	private Date lastInoculateDt;

	@Column(name = "INOCULATE_METROLOGY", columnDefinition = "VARCHAR2|接种计量|100|", length = 100, nullable = true)
	private String inoculateMetrology;

	@Column(name = "INOCULATE_NUM", columnDefinition = "VARCHAR2|接种次数|20|", length = 20, nullable = true)
	private String inoculateNum;

	@Column(name = "INOCULATE_PART", columnDefinition = "VARCHAR2|接种部位|100|", length = 100, nullable = true)
	private String inoculatePart;

	@Column(name = "PPH", columnDefinition = "VARCHAR2|既往是否患过此病|2|", length = 2, nullable = true)
	private String pph;

	@Column(name = "DIAGNOSIS_UNIT", columnDefinition = "VARCHAR2|诊断单位|100|", length = 100, nullable = true)
	private String diagnosisUnit;

	@Column(name = "DIAGNOSIS_DT", columnDefinition = "DATE|诊断时间||", nullable = true)
	private Date diagnosisDt;

	@Column(name = "INFLUENZA_VACCINATIONS", columnDefinition = "VARCHAR2|流感有无接种|2|", length = 2, nullable = true)
	private String influenzaVaccinations;

	@Column(name = "FLU_LAST_INOCULATE_DT", columnDefinition = "DATE|流感最后一次接种日期||", nullable = true)
	private Date fluLastInoculateDt;

	@Column(name = "TIV_PRODUCT_NAME", columnDefinition = "VARCHAR2|流感疫苗产品名|100|", length = 100, nullable = true)
	private String tivProductName;

	@Column(name = "TIV_MANUFACTURERS", columnDefinition = "VARCHAR2|流感疫苗厂家|100|", length = 100, nullable = true)
	private String tivManufacturers;

	@Column(name = "TIV_WAY_PART", columnDefinition = "VARCHAR2|流感接种方式及部位|100|", length = 100, nullable = true)
	private String tivWayPart;

	@Column(name = "TIV_ADDR", columnDefinition = "VARCHAR2|流感接种地点|100|", length = 100, nullable = true)
	private String tivAddr;

	@Column(name = "RECENT_CONTACT_PATIENTS", columnDefinition = "VARCHAR2|近期接触症状相似病人|2|", length = 2, nullable = true)
	private String recentContactPatients;

	@Column(name = "RECENT_CONTACT_PATIENTS_ADDR", columnDefinition = "VARCHAR2|近期接触症状相似病人地点|100|", length = 100, nullable = true)
	private String recentContactPatientsAddr;

	@Column(name = "OFTEN_PUBLIC_PLACE", columnDefinition = "VARCHAR2|经常出入人群拥挤的公共场所|100|", length = 100, nullable = true)
	private String oftenPublicPlace;

	@Column(name = "WASHING_HAND_EATING_TOILET", columnDefinition = "VARCHAR2|平时饭前便后洗手|2|", length = 2, nullable = true)
	private String washingHandEatingToilet;

	@Column(name = "MUMPS_VACCINE", columnDefinition = "VARCHAR2|腮腺炎疫苗|2|", length = 2, nullable = true)
	private String mumpsVaccine;

	@Column(name = "MMR_VACCINE", columnDefinition = "VARCHAR2|麻腮风三联疫苗|2|", length = 2, nullable = true)
	private String mmrVaccine;

	@Column(name = "MENINGITIS", columnDefinition = "VARCHAR2|流脑疫苗|2|", length = 2, nullable = true)
	private String meningitis;

	@Column(name = "JESPECT", columnDefinition = "VARCHAR2|乙脑疫苗|2|", length = 2, nullable = true)
	private String jespect;

	@Column(name = "ERUPTION_CONTACT", columnDefinition = "VARCHAR2|发病前7-21天与出疹病人密切接触|2|", length = 2, nullable = true)
	private String eruptionContact;

	@Column(name = "ERUPTION_CONTACT_ADDR", columnDefinition = "VARCHAR2|发病前7-21天与出疹病人密切接触地点|100|", length = 100, nullable = true)
	private String eruptionContactAddr;

	@Column(name = "ERUPTION_CONTACT_PUBLIC_PLACE", columnDefinition = "VARCHAR2|发病前7-21天与出疹病人密切接触场所|2|", length = 2, nullable = true)
	private String eruptionContactPublicPlace;

	@Column(name = "RUBELLA_VACCINE", columnDefinition = "VARCHAR2|风疹疫苗接种史|2|", length = 2, nullable = true)
	private String rubellaVaccine;

	@Column(name = "LAST_RUBELLA_VACCINE_DT", columnDefinition = "DATE|风疹疫苗最近一次日期||", nullable = true)
	private Date lastRubellaVaccineDt;

	@Column(name = "EXCEPT_RUBELLA", columnDefinition = "VARCHAR2|除麻疹疫苗外，还接种以下疫苗|20|", length = 20, nullable = true)
	private String exceptRubella;

	@Column(name = "TWODAYS_AGO_CONTACT_PATIENTS", columnDefinition = "VARCHAR2|病前2天接触同类病人|2|", length = 2, nullable = true)
	private String twodaysAgoContactPatients;

	@Column(name = "RELATION_PATIENT", columnDefinition = "VARCHAR2|与患者关系|100|", length = 100, nullable = true)
	private String relationPatient;

	@Column(name = "HOME_TOWEL", columnDefinition = "VARCHAR2|家庭内毛巾|2|", length = 2, nullable = true)
	private String homeTowel;

	@Column(name = "HOME_BASIN", columnDefinition = "VARCHAR2|家庭内脸盆|2|", length = 2, nullable = true)
	private String homeBasin;

	@Column(name = "HOME_NUM", columnDefinition = "VARCHAR2|家庭人数|20|", length = 20, nullable = true)
	private String homeNum;

	@Column(name = "BUS", columnDefinition = "VARCHAR2|乘坐公交车|2|", length = 2, nullable = true)
	private String bus;

	@Column(name = "BUS_NUM", columnDefinition = "VARCHAR2|乘坐公交车次数|20|", length = 20, nullable = true)
	private String busNum;

	@Column(name = "DUS_DETAIL", columnDefinition = "VARCHAR2|乘坐公交车主要乘坐几路车|50|", length = 50, nullable = true)
	private String dusDetail;

	@Column(name = "TEXI", columnDefinition = "VARCHAR2|乘坐出租车|2|", length = 2, nullable = true)
	private String texi;

	@Column(name = "TEXI_NUM", columnDefinition = "VARCHAR2|乘坐出租车次数|20|", length = 20, nullable = true)
	private String texiNum;

	@Column(name = "SWIM", columnDefinition = "VARCHAR2|游泳|2|", length = 2, nullable = true)
	private String swim;

	@Column(name = "HOME_QUARANTINE", columnDefinition = "VARCHAR2|发病期间在家隔离|2|", length = 2, nullable = true)
	private String homeQuarantine;

	@Column(name = "TEL", columnDefinition = "VARCHAR2|是否打电话|2|", length = 2, nullable = true)
	private String tel;

	@Column(name = "COMPUTER", columnDefinition = "VARCHAR2|是否使用电脑|2|", length = 2, nullable = true)
	private String computer;

	@Column(name = "ELEVATOR", columnDefinition = "VARCHAR2|公共场所乘坐电梯|2|", length = 2, nullable = true)
	private String elevator;

	@Column(name = "ELEVATOR_NUM", columnDefinition = "VARCHAR2|公共场所乘坐电梯次数|100|", length = 100, nullable = true)
	private String elevatorNum;

	@Column(name = "RESTAURANT", columnDefinition = "VARCHAR2|饭店就餐|2|", length = 2, nullable = true)
	private String restaurant;

	@Column(name = "RESTAURANT_NUM", columnDefinition = "VARCHAR2|饭店就餐次数|100|", length = 100, nullable = true)
	private String restaurantNum;

	@Column(name = "BALLROOM", columnDefinition = "VARCHAR2|舞厅或街头跳舞|2|", length = 2, nullable = true)
	private String ballroom;

	@Column(name = "BALLROOM_NUM", columnDefinition = "VARCHAR2|舞厅或街头跳舞次数|100|", length = 100, nullable = true)
	private String ballroomNum;

	@Column(name = "CYBERCAFE", columnDefinition = "VARCHAR2|有否去过网吧|2|", length = 2, nullable = true)
	private String cybercafe;

	@Column(name = "CYBERCAFE_NUM", columnDefinition = "VARCHAR2|有否去过网吧次数|100|", length = 100, nullable = true)
	private String cybercafeNum;

	@Column(name = "BOWLING", columnDefinition = "VARCHAR2|有无打保龄球|2|", length = 2, nullable = true)
	private String bowling;

	@Column(name = "BOWLING_NUM", columnDefinition = "VARCHAR2|有无打保龄球次数|100|", length = 100, nullable = true)
	private String bowlingNum;

	@Column(name = "OTHER_PUBLIC_PLACE", columnDefinition = "VARCHAR2|其他主要公共场所|100|", length = 100, nullable = true)
	private String otherPublicPlace;

	@Column(name = "HOME_CONTACT_PATIENTS", columnDefinition = "VARCHAR2|家庭或者邻居种有无同样病人|2|", length = 2, nullable = true)
	private String homeContactPatients;

	@Column(name = "HOME_CONTACT_PATIENTS_DT", columnDefinition = "DATE|家庭或者邻居种同样病人患病日期||", nullable = true)
	private Date homeContactPatientsDt;

	@Column(name = "TYPHUS", columnDefinition = "VARCHAR2|患者过去斑疹伤寒史|2|", length = 2, nullable = true)
	private String typhus;

	@Column(name = "TYPHUS_DT", columnDefinition = "DATE|患者过去斑疹伤寒史日期||", nullable = true)
	private Date typhusDt;

	@Column(name = "OUT_HISTORY", columnDefinition = "VARCHAR2|病前外出史|2|", length = 2, nullable = true)
	private String outHistory;

	@Column(name = "OUT_HISTORY_ADDR", columnDefinition = "VARCHAR2|病前5～21天内外出史地点|200|", length = 200, nullable = true)
	private String outHistoryAddr;

	@Column(name = "OUT_HISTORY_DEGIN_DT", columnDefinition = "DATE|病前5～21天内外出史开始时间||", nullable = true)
	private Date outHistoryDeginDt;

	@Column(name = "OUT_HISTORY_END_DT", columnDefinition = "DATE|病前5～21天内外出史结束时间||", nullable = true)
	private Date outHistoryEndDt;

	@Column(name = "LOUSE", columnDefinition = "VARCHAR2|该地虱子|2|", length = 2, nullable = true)
	private String louse;

	@Column(name = "FLEA", columnDefinition = "VARCHAR2|该地跳蚤|2|", length = 2, nullable = true)
	private String flea;

	@Column(name = "MOUSE", columnDefinition = "VARCHAR2|该地老鼠|2|", length = 2, nullable = true)
	private String mouse;

	@Column(name = "CAT", columnDefinition = "VARCHAR2|该地猫|2|", length = 2, nullable = true)
	private String cat;

	@Column(name = "CONTACT_HISTORY", columnDefinition = "VARCHAR2|接触史|2|", length = 2, nullable = true)
	private String contactHistory;

	@Column(name = "CONTACT_PATIENT_NAME", columnDefinition = "VARCHAR2|接触病人名称|50|", length = 50, nullable = true)
	private String contactPatientName;

	@Column(name = "CONTACT_RELATION", columnDefinition = "VARCHAR2|接触关系|100|", length = 100, nullable = true)
	private String contactRelation;

	@Column(name = "CONTACT_WAY", columnDefinition = "VARCHAR2|接触方式|2|", length = 2, nullable = true)
	private String contactWay;

	@Column(name = "LIVING_SPACE", columnDefinition = "VARCHAR2|家庭居住面积|100|", length = 100, nullable = true)
	private String livingSpace;

	@Column(name = "LIVING_NUM", columnDefinition = "VARCHAR2|居住人数|20|", length = 20, nullable = true)
	private String livingNum;

	@Column(name = "HOME_LOUSE", columnDefinition = "VARCHAR2|虱子|2|", length = 2, nullable = true)
	private String homeLouse;

	@Column(name = "HOME_FLEA", columnDefinition = "VARCHAR2|该地跳蚤|2|", length = 2, nullable = true)
	private String homeFlea;

	@Column(name = "HOMEMOUSE", columnDefinition = "VARCHAR2|该地老鼠|2|", length = 2, nullable = true)
	private String homeMouse;

	@Column(name = "HOME_CAT", columnDefinition = "VARCHAR2|家中养猫|2|", length = 2, nullable = true)
	private String homeCat;

	@Column(name = "HOME_DOG", columnDefinition = "VARCHAR2|家中养狗|2|", length = 2, nullable = true)
	private String homeDog;

	@Column(name = "INOCULATE_HISTORY", columnDefinition = "VARCHAR2|接种史|2|", length = 2, nullable = true)
	private String inoculateHistory;

	@Column(name = "INOCULATE_DT", columnDefinition = "DATE|接种时间||", nullable = true)
	private Date inoculateDt;

	@Column(name = "FIELD_WORK", columnDefinition = "VARCHAR2|外出野外作业|2|", length = 2, nullable = true)
	private String fieldWork;

	@Column(name = "FIELD_HUNT", columnDefinition = "VARCHAR2|外出野外捕猎|2|", length = 2, nullable = true)
	private String fieldHunt;

	@Column(name = "FIELD_TIME", columnDefinition = "VARCHAR2|外出到该地时间|2|", length = 2, nullable = true)
	private String fieldTime;

	@Column(name = "WILDLIFE_CONTACT_HISTORY", columnDefinition = "VARCHAR2|野生动物接触史|2|", length = 2, nullable = true)
	private String wildlifeContactHistory;

	@Column(name = "CONTACT_WILDLIFE", columnDefinition = "VARCHAR2|接触过何种动物|100|", length = 100, nullable = true)
	private String contactWildlife;

	@Column(name = "WILDLIFE_CONTACT_WAY", columnDefinition = "VARCHAR2|接触方式|100|", length = 100, nullable = true)
	private String wildlifeContactWay;

	@Column(name = "TRANSFUSION", columnDefinition = "VARCHAR2|是否输过血|2|", length = 2, nullable = true)
	private String transfusion;

	@Column(name = "HOME_DOG_NUM", columnDefinition = "VARCHAR2|家中狗数|20|", length = 20, nullable = true)
	private String homeDogNum;

	@Column(name = "DISEASE_DOG_NUM", columnDefinition = "VARCHAR2|患病狗数|20|", length = 20, nullable = true)
	private String diseaseDogNum;

	@Column(name = "DIE_DOG_NUM", columnDefinition = "VARCHAR2|死亡狗数|20|", length = 20, nullable = true)
	private String dieDogNum;

	@Column(name = "PASTORAL_LIFE", columnDefinition = "VARCHAR2|在牧区工作生活|2|", length = 2, nullable = true)
	private String pastoralLife;

	@Column(name = "CONTACT_PASTORAL", columnDefinition = "VARCHAR2|到过牧区|2|", length = 2, nullable = true)
	private String contactPastoral;

	@Column(name = "PASTORAL_DOG", columnDefinition = "VARCHAR2|与牧区狗接触|2|", length = 2, nullable = true)
	private String pastoralDog;

	@Column(name = "PASTORAL_WATER", columnDefinition = "VARCHAR2|在牧区吃生菜喝生水|2|", length = 2, nullable = true)
	private String pastoralWater;

	@Column(name = "ANIMAL_CONTACT", columnDefinition = "VARCHAR2|与动物接触情况|100|", length = 100, nullable = true)
	private String animalContact;

	@Column(name = "LABOR_PROTECTION", columnDefinition = "VARCHAR2|劳动保护情况|100|", length = 100, nullable = true)
	private String laborProtection;

	@Column(name = "LOCALTION_SCARLATINA", columnDefinition = "VARCHAR2|本地有无猩红热流行|2|", length = 2, nullable = true)
	private String localtionScarlatina;

    @Column(name = "THE_SCARLATINA", columnDefinition = "VARCHAR2|该地有无猩红热流行|2|", length = 2, nullable = true)
    private String theScarlatina;

    @Column(name = "HOME_POPULATION_NUM", columnDefinition = "VARCHAR2|家庭人口数|20|", length = 20, nullable = true)
	private String homePopulationNum;

	@Column(name = "DOUBTFUL_PATIENT_NAME", columnDefinition = "VARCHAR2|疑似病人姓名|50|", length = 50, nullable = true)
	private String doubtfulPatientName;

	@Column(name = "DOUBTFUL_PATIENT_SEX", columnDefinition = "VARCHAR2|疑似病人性别|100|", length = 100, nullable = true)
	private String doubtfulPatientSex;

	@Column(name = "DOUBTFUL_PATIENT_AGE", columnDefinition = "VARCHAR2|疑似病人年龄|100|", length = 100, nullable = true)
	private String doubtfulPatientAge;

	@Column(name = "DOUBTFUL_PATIENT_ATTACK_DT", columnDefinition = "DATE|疑似病人发病日期||", nullable = true)
	private Date doubtfulPatientAttackDt;

	@Column(name = "DOUBTFUL_PATIENT_RELATION", columnDefinition = "VARCHAR2|疑似病人与患者关系|100|", length = 100, nullable = true)
	private String doubtfulPatientRelation;

	@Column(name = "DOUBTFUL_PATIENT_CONTACT_WAY", columnDefinition = "VARCHAR2|疑似病人接触方式|2|", length = 2, nullable = true)
	private String doubtfulPatientContactWay;

	@Column(name = "SIMILAR_CASES", columnDefinition = "VARCHAR2|周围类似病例|2|", length = 2, nullable = true)
	private String similarCases;

	@Column(name = "DIPHTHERITIS_VACCINATION", columnDefinition = "VARCHAR2|白喉预防接种史|2|", length = 2, nullable = true)
	private String diphtheritisVaccination;

	@Column(name = "DIPHTHERITIS_VACCINE_F", columnDefinition = "VARCHAR2|白喉预防接种疫苗名称1|100|", length = 100, nullable = true)
	private String diphtheritisVaccineF;

	@Column(name = "DIPHTHERITIS_VACCINE_DT_F", columnDefinition = "VARCHAR2|白喉预防接种时间1|100|", length = 100, nullable = true)
	private String diphtheritisVaccineDtF;

	@Column(name = "DIPHTHERITIS_VACCINE_S", columnDefinition = "VARCHAR2|白喉预防接种疫苗名称2|100|", length = 100, nullable = true)
	private String diphtheritisVaccineS;

	@Column(name = "DIPHTHERITIS_VACCINE_DT_S", columnDefinition = "VARCHAR2|白喉预防接种时间2|100|", length = 100, nullable = true)
	private String diphtheritisVaccineDtS;

	@Column(name = "DIPHTHERITIS_VACCINE_T", columnDefinition = "VARCHAR2|白喉预防接种疫苗名称3|100|", length = 100, nullable = true)
	private String diphtheritisVaccineT;

	@Column(name = "DIPHTHERITIS_VACCINE_DT_T", columnDefinition = "VARCHAR2|白喉预防接种时间3|100|", length = 100, nullable = true)
	private String diphtheritisVaccineDtT;

	@Column(name = "DIPHTHERITIS_VACCINE_FO", columnDefinition = "VARCHAR2|白喉预防接种疫苗名称4|100|", length = 100, nullable = true)
	private String diphtheritisVaccineFo;

	@Column(name = "DIPHTHERITIS_VACCINE_DT_FO", columnDefinition = "VARCHAR2|白喉预防接种时间4|100|", length = 100, nullable = true)
	private String diphtheritisVaccineDtFo;

	@Column(name = "DIPHTHERITIS_VACCINE_FI", columnDefinition = "VARCHAR2|白喉预防接种疫苗名称5|100|", length = 100, nullable = true)
	private String diphtheritisVaccineFi;

	@Column(name = "DIPHTHERITIS_VACCINE_DT_FI", columnDefinition = "VARCHAR2|白喉预防接种时间5|100|", length = 100, nullable = true)
	private String diphtheritisVaccineDtFi;

	@Column(name = "DIPHTHERITIS_VACCINE_SI", columnDefinition = "VARCHAR2|白喉预防接种疫苗名称6|100|", length = 100, nullable = true)
	private String diphtheritisVaccineSi;

	@Column(name = "DIPHTHERITIS_VACCINE_DT_SI", columnDefinition = "VARCHAR2|白喉预防接种时间6|100|", length = 100, nullable = true)
	private String diphtheritisVaccineDtSi;

	@Column(name = "VACCINATION_REASON", columnDefinition = "VARCHAR2|接种依据|2|", length = 2, nullable = true)
	private String vaccinationReason;

	@Column(name = "LAST_A_DT", columnDefinition = "DATE|发病前最后一次接种-A群疫苗接种时间||", nullable = true)
	private Date lastADt;

	@Column(name = "LAST_AC_DT", columnDefinition = "DATE|发病前最后一次接种-A+C群疫苗接种时间||", nullable = true)
	private Date lastAcDt;

	@Column(name = "SIMILAR_PATIENTS", columnDefinition = "VARCHAR2|发病地点近期是否有同类（流脑）病人|2|", length = 2, nullable = true)
	private String similarPatients;

	@Column(name = "DYSENTERY", columnDefinition = "VARCHAR2|既往一年内痢疾史|2|", length = 2, nullable = true)
	private String dysentery;

	@Column(name = "DYSENTERY_DT", columnDefinition = "DATE|发病时间||", nullable = true)
	private Date dysenteryDt;

	@Column(name = "RAW_WATER", columnDefinition = "VARCHAR2|病前喝生水史|2|", length = 2, nullable = true)
	private String rawWater;

	@Column(name = "DOUBTFUL_DIET", columnDefinition = "VARCHAR2|病前一周内可疑饮食史|2|", length = 2, nullable = true)
	private String doubtfulDiet;

	@Column(name = "DOUBTFUL_DIET_DT", columnDefinition = "DATE|进食时间||", nullable = true)
	private Date doubtfulDietDt;

	@Column(name = "DOUBTFUL_DIET_NAME", columnDefinition = "VARCHAR2|食物名称|100|", length = 100, nullable = true)
	private String doubtfulDietName;

	@Column(name = "SAME_MEAL_NUM", columnDefinition = "VARCHAR2|同餐人数|20|", length = 20, nullable = true)
	private String sameMealNum;

	@Column(name = "DYSENTERY_NUM", columnDefinition = "VARCHAR2|发病人数|20|", length = 20, nullable = true)
	private String dysenteryNum;

	@Column(name = "DYSENTERY_CONTACT_HISTORY", columnDefinition = "VARCHAR2|病前一周内与确诊痢疾病人接触史|2|", length = 2, nullable = true)
	private String dysenteryContactHistory;

	@Column(name = "DRINKING_WATER", columnDefinition = "VARCHAR2|饮用水源|2|", length = 2, nullable = true)
	private String drinkingWater;

	@Column(name = "WASH_WATER", columnDefinition = "VARCHAR2|洗漱用水|2|", length = 2, nullable = true)
	private String washWater;

	@Column(name = "WATER_DISINFECT", columnDefinition = "VARCHAR2|上述用水是否消毒|2|", length = 2, nullable = true)
	private String waterDisinfect;

	@Column(name = "HOME_HEALTH", columnDefinition = "VARCHAR2|居所卫生|2|", length = 2, nullable = true)
	private String homeHealth;

	@Column(name = "FLY", columnDefinition = "VARCHAR2|室内苍蝇|2|", length = 2, nullable = true)
	private String fly;

	@Column(name = "TOILET", columnDefinition = "VARCHAR2|厕所使用|2|", length = 2, nullable = true)
	private String toilet;

	@Column(name = "DISINFECT_TREATMENT", columnDefinition = "VARCHAR2|消毒和处理情况|2|", length = 2, nullable = true)
	private String disinfectTreatment;

	@Column(name = "CORPSE_TREATMENT", columnDefinition = "VARCHAR2|死尸处理|2|", length = 2, nullable = true)
	private String corpseTreatment;

	@Column(name = "DYSENTERY_DT_ORDER", columnDefinition = "VARCHAR2|在本疫点病例发病时间顺序|20|", length = 20, nullable = true)
	private String dysenteryDtOrder;

	@Column(name = "ANTHRAX", columnDefinition = "VARCHAR2|既往炭疽病史|2|", length = 2, nullable = true)
	private String anthrax;

	@Column(name = "ANTHRAX_DT", columnDefinition = "DATE|既往炭疽病史-时间||", nullable = true)
	private Date anthraxDt;

	@Column(name = "ANTHRAX_VACCINATION", columnDefinition = "VARCHAR2|炭疽菌苗接种史|2|", length = 2, nullable = true)
	private String anthraxVaccination;

	@Column(name = "ANTHRAX_VACCINATION_DT", columnDefinition = "DATE|炭疽菌苗接种史-接种时间||", nullable = true)
	private Date anthraxVaccinationDt;

	@Column(name = "OUT_HISTORY_DAYS", columnDefinition = "VARCHAR2|外出时间（天）|20|", length = 20, nullable = true)
	private String outHistoryDays;

	@Column(name = "DYSENTERY_OUT_HISTORY_ADDR", columnDefinition = "VARCHAR2|发病后到过何处|100|", length = 100, nullable = true)
	private String dysenteryOutHistoryAddr;

	@Column(name = "DYSENTERY_OUT_HISTORY_DAYS", columnDefinition = "VARCHAR2|停留时间（天）|20|", length = 20, nullable = true)
	private String dysenteryOutHistoryDays;

	@Column(name = "JESPECT_CATEGORY", columnDefinition = "VARCHAR2|疫苗种类|2|", length = 2, nullable = true)
	private String jespectCategory;

	@Column(name = "JESPECT_INACTIVATE_DT_F", columnDefinition = "DATE|乙脑灭活疫苗-第1次接种时间||", nullable = true)
	private Date jespectInactivateDtF;

	@Column(name = "JESPECT_INACTIVATE_DT_S", columnDefinition = "DATE|乙脑灭活疫苗-第2次接种时间||", nullable = true)
	private Date jespectInactivateDtS;

	@Column(name = "JESPECT_INACTIVATE_DT_T", columnDefinition = "DATE|乙脑灭活疫苗-第3次接种时间||", nullable = true)
	private Date jespectInactivateDtT;

	@Column(name = "JESPECT_INACTIVATE_DT_FO", columnDefinition = "DATE|乙脑灭活疫苗-第4次接种时间||", nullable = true)
	private Date jespectInactivateDtFo;

	@Column(name = "JESPECT_INACTIVATE_LAST", columnDefinition = "DATE|乙脑灭活疫苗-最后1次接种时间||", nullable = true)
	private Date jespectInactivateLast;

	@Column(name = "JESPECT_ATTENUATED_DT_F", columnDefinition = "DATE|乙脑减毒活疫苗-第1次接种时间||", nullable = true)
	private Date jespectAttenuatedDtF;

	@Column(name = "JESPECT_ATTENUATED_DT_S", columnDefinition = "DATE|乙脑减毒活疫苗-第2次接种时间||", nullable = true)
	private Date jespectAttenuatedDtS;

	@Column(name = "JESPECT_ATTENUATED_DT_T", columnDefinition = "DATE|乙脑减毒活疫苗-第3次接种时间||", nullable = true)
	private Date jespectAttenuatedDtT;

	@Column(name = "JESPECT_ATTENUATED_LAST", columnDefinition = "DATE|乙脑减毒活疫苗-最后1次接种时间||", nullable = true)
	private Date jespectAttenuatedLast;

	@Column(name = "UNVACCINATED_REASON", columnDefinition = "VARCHAR2|未接种或未全程接种的主要原因|2|", length = 2, nullable = true)
	private String unvaccinatedReason;

	@Column(name = "UNVACCINATED_REASON_OTHER", columnDefinition = "VARCHAR2|未接种或未全程接种的主要原因-其它|100|", length = 100, nullable = true)
	private String unvaccinatedReasonOther;

	@Column(name = "COLLECTIVE_UNIT", columnDefinition = "VARCHAR2|否在集体单位（如学校、幼儿园、工厂等）|2|", length = 2, nullable = true)
	private String collectiveUnit;

	@Column(name = "COLLECTIVE_UNIT_NAME", columnDefinition = "VARCHAR2|集体单位名称|100|", length = 100, nullable = true)
	private String collectiveUnitName;

	@Column(name = "MEASLESVACCINE_INGREDIENTS_NUM", columnDefinition = "VARCHAR2|含麻疹成分疫苗接种剂次|2|", length = 2, nullable = true)
	private String measlesvaccineIngredientsNum;

	@Column(name = "MV_IMMUNIZATION_HISTORY_SOURCE", columnDefinition = "VARCHAR2|免疫史来源|2|", length = 2, nullable = true)
	private String mvImmunizationHistorySource;

	@Column(name = "MV_INOCULATE_DT", columnDefinition = "DATE|剂次接种时间||", nullable = true)
	private Date mvInoculateDt;

	@Column(name = "MV_LAST_INOCULATE_DT", columnDefinition = "DATE|最后一剂接种时间||", nullable = true)
	private Date mvLastInoculateDt;
	
	@Column(name = "MV_SEC_INOCULATE_DT", columnDefinition = "DATE|第二剂接种时间||", nullable = true)
	private Date mvSecInoculateDt;

	@Column(name = "RUBELLAVACCINE_INGREDIENTS_NUM", columnDefinition = "VARCHAR2|含风疹成分疫苗接种剂次|2|", length = 2, nullable = true)
	private String rubellavaccineIngredientsNum;

	@Column(name = "RV_IMMUNIZATION_HISTORY_SOURCE", columnDefinition = "VARCHAR2|免疫史来源|2|", length = 2, nullable = true)
	private String rvImmunizationHistorySource;

	@Column(name = "RV_INOCULATE_DT", columnDefinition = "DATE|剂次接种时间||", nullable = true)
	private Date rvInoculateDt;

	@Column(name = "RV_LAST_INOCULATE_DT", columnDefinition = "DATE|最后一剂接种时间||", nullable = true)
	private Date rvLastInoculateDt;

	@Column(name = "DYSENTERY_BEEN_HOSPITAL", columnDefinition = "VARCHAR2|发病前7-21天是否去过医院|2|", length = 2, nullable = true)
	private String dysenteryBeenHospital;

	@Column(name = "DYSENTERY_BEEN_HOSPITAL_NAME", columnDefinition = "VARCHAR2|医院名称|100|", length = 100, nullable = true)
	private String dysenteryBeenHospitalName;

	@Column(name = "DYSENTERY_BEEN_HOSPITAL_DATE", columnDefinition = "DATE|去医院日期||", nullable = true)
	private Date dysenteryBeenHospitalDate;

	@Column(name = "LAB_PATIENTS_CONTACT", columnDefinition = "VARCHAR2|是否与实验室诊断病例有流行病学联系|2|", length = 2, nullable = true)
	private String labPatientsContact;
	
	@Column(name = "MV_LAB_PAT_CON", columnDefinition = "VARCHAR2|是否与实验室诊断麻疹病例有流行病学联系|2|", length = 2, nullable = true)
	private String mvLabPatCon;
	
	@Column(name = "FZ_LAB_PAT_CON", columnDefinition = "VARCHAR2|是否与实验室诊断风疹病例有流行病学联系|2|", length = 2, nullable = true)
	private String fzLabPatCon;

	@Column(name = "LAB_CONFIRMED_CASE", columnDefinition = "VARCHAR2|实验室诊断病例|2|", length = 2, nullable = true)
	private String labConfirmedCase;

	@Column(name = "MEASLES_OUTBREAK_CASE", columnDefinition = "VARCHAR2|是否为麻疹暴发疫情中的病例|2|", length = 2, nullable = true)
	private String measlesOutbreakCase;

	@Column(name = "NEW_OUTBREAK", columnDefinition = "VARCHAR2|是否为一起新的暴发|2|", length = 2, nullable = true)
	private String newOutbreak;

	@Column(name = "OUTBREAK_NO", columnDefinition = "VARCHAR2|暴发编码|100|", length = 100, nullable = true)
	private String outbreakNo;

	@Column(name = "OPV_NUM", columnDefinition = "VARCHAR2|累计服脊灰疫苗次数|20|", length = 20, nullable = true)
	private String opvNum;

	@Column(name = "IMMUNIZATION_HISTORY_SOURCE", columnDefinition = "VARCHAR2|服苗依据|2|", length = 2, nullable = true)
	private String immunizationHistorySource;

	@Column(name = "PALSY_LAST_DT", columnDefinition = "DATE|麻痹前最近一次服苗日期||", nullable = true)
	private Date palsyLastDt;

	@Column(name = "IMMUNIZATION_HISTORY_FORM", columnDefinition = "VARCHAR2|服苗形式|2|", length = 2, nullable = true)
	private String immunizationHistoryForm;

	@Column(name = "STOOL_LAST_DT", columnDefinition = "DATE|采便前最近一次服苗日期||", nullable = true)
	private Date stoolLastDt;

	@Column(name = "HEPATITIS_B_VACCINE", columnDefinition = "VARCHAR2|是否接种过乙肝疫苗吗|2|", length = 2, nullable = true)
	private String hepatitisBVaccine;

	@Column(name = "HEPATITIS_B_VACCINE_DT_F", columnDefinition = "DATE|接种第一针时间||", nullable = true)
	private Date hepatitisBVaccineDtF;

	@Column(name = "HEPATITIS_B_VACCINE_DT_S", columnDefinition = "DATE|接种第二针时间||", nullable = true)
	private Date hepatitisBVaccineDtS;

	@Column(name = "HEPATITIS_B_VACCINE_DT_T", columnDefinition = "DATE|接种第三针时间||", nullable = true)
	private Date hepatitisBVaccineDtT;

	@Column(name = "FIRST_EPISODE_DT", columnDefinition = "DATE|初次发病时间||", nullable = true)
	private Date firstEpisodeDt;

	@Column(name = "FIRST_TREATMENT_DT", columnDefinition = "DATE|首次就诊时间||", nullable = true)
	private Date firstTreatmentDt;

	@Column(name = "THE_TREATMENT_UNIT", columnDefinition = "VARCHAR2|本次就诊单位|2|", length = 2, nullable = true)
	private String theTreatmentUnit;

	@Column(name = "HEPATITIS_B_VACCINE_NUM", columnDefinition = "VARCHAR2|如接种过乙肝疫苗，打过几针|2|", length = 2, nullable = true)
	private String hepatitisBVaccineNum;

	@Column(name = "HBS", columnDefinition = "VARCHAR2|接种乙肝疫苗最后一针1～2月后，是否检测过抗-HBs|2|", length = 2, nullable = true)
	private String hbs;

	@Column(name = "HEPATITIS_B_IMMUNOGLOBULIN", columnDefinition = "VARCHAR2|是否接种过乙肝高效价免疫球蛋白|2|", length = 2, nullable = true)
	private String hepatitisBImmunoglobulin;

	@Column(name = "HEPATITIS_B_IMMUNOGLOBULIN_DT", columnDefinition = "DATE|乙肝高效价免疫球蛋白接种时间||", nullable = true)
	private Date hepatitisBImmunoglobulinDt;

	@Column(name = "AIMMUGEN", columnDefinition = "VARCHAR2|既往是否接种过甲肝疫苗|2|", length = 2, nullable = true)
	private String aimmugen;

	@Column(name = "AIMMUGEN_CATEGORY", columnDefinition = "VARCHAR2|甲肝疫苗种类|2|", length = 2, nullable = true)
	private String aimmugenCategory;

	@Column(name = "AIMMUGEN_NUM", columnDefinition = "VARCHAR2|接种甲肝疫苗的次数|2|", length = 2, nullable = true)
	private String aimmugenNum;

	@Column(name = "AIMMUGEN_DT_F", columnDefinition = "DATE|甲肝第一针甲肝疫苗接种时间||", nullable = true)
	private Date aimmugenDtF;

	@Column(name = "AIMMUGEN_DT_S", columnDefinition = "DATE|甲肝第二针甲肝疫苗接种时间||", nullable = true)
	private Date aimmugenDtS;

	@Column(name = "HEPATITIS_A_GAMMA_GLOBULIN", columnDefinition = "VARCHAR2|您是否接种过甲肝丙种球蛋白|2|", length = 2, nullable = true)
	private String hepatitisAGammaGlobulin;

	@Column(name = "HEPATITIS_A_GAMMA_GLOBULIN_DT", columnDefinition = "DATE|甲肝丙种球蛋白接种时间||", nullable = true)
	private Date hepatitisAGammaGlobulinDt;

	@Column(name = "DIAGNOSIS_LIVER_CATEGORY", columnDefinition = "VARCHAR2|是否曾经被明确诊断过以下“肝病”|200|", length = 200, nullable = true)
	private String diagnosisLiverCategory;

	@Column(name = "LIVER_FIRST_EPISODE_DT", columnDefinition = "DATE|初次诊断时间||", nullable = true)
	private Date liverFirstEpisodeDt;

	@Column(name = "LIVER_DIAGNOSIS", columnDefinition = "VARCHAR2|临床诊断为|2|", length = 2, nullable = true)
	private String liverDiagnosis;

	@Column(name = "LIVER_DIAGNOSIS_UNIT", columnDefinition = "VARCHAR2|临床诊断单位|2|", length = 2, nullable = true)
	private String liverDiagnosisUnit;

	@Column(name = "HEPATITIS", columnDefinition = "VARCHAR2|既往肝炎史|2|", length = 2, nullable = true)
	private String hepatitis;

	@Column(name = "HEPATITIS_DT", columnDefinition = "DATE|肝炎发病时间||", nullable = true)
	private Date hepatitisDt;

	@Column(name = "HEPATITIS_CATEGORY", columnDefinition = "VARCHAR2|肝炎型别|2|", length = 2, nullable = true)
	private String hepatitisCategory;

	@Column(name = "HEPATITIS_OTHER", columnDefinition = "VARCHAR2|肝炎型别-其它|100|", length = 100, nullable = true)
	private String hepatitisOther;

	@Column(name = "HEPATITIS_CONTACT_HISTORY", columnDefinition = "VARCHAR2|病前2至6月内与确诊肝炎病人接触史|2|", length = 2, nullable = true)
	private String hepatitisContactHistory;

	@Column(name = "CH_HEPATITIS_CATEGORY", columnDefinition = "VARCHAR2|肝炎型别|20|", length = 20, nullable = true)
	private String chHepatitisCategory;

    @Column(name = "CONTACT_WAY_MULTI", columnDefinition = "VARCHAR2|接触方式－多选|200|", length = 200, nullable = true)
	private String contactWayMulti;

	@Column(name = "CH_HEPATITIS_OTHER", columnDefinition = "VARCHAR2|肝炎型别其他|100|", length = 100, nullable = true)
	private String chHepatitisOther;

	@Column(name = "SURVEY_DATE", columnDefinition = "DATE|调查日期||", nullable = true)
	private Date surveyDate;

	@Column(name = "SARS_PATIENT", columnDefinition = "VARCHAR2|发病前2周内是否接触过非典病人或/和疑似非典患者|2|", length = 2, nullable = true)
	private String sarsPatient;

	@Column(name = "SARS_ANIMAL", columnDefinition = "VARCHAR2|发病前两周内接触动物（罕见动物、禽类）情况|2|", length = 2, nullable = true)
	private String sarsAnimal;

	@Column(name = "PLAGUE", columnDefinition = "VARCHAR2|该地是否有鼠疫流行|2|", length = 2, nullable = true)
	private String plague;

	@Column(name = "PLAGUE_ADDR", columnDefinition = "VARCHAR2|该地详细地址|200|", length = 200, nullable = true)
	private String plagueAddr;

	@Column(name = "CONTACT_PATIENTS", columnDefinition = "VARCHAR2|是否接触过疑似病人|2|", length = 2, nullable = true)
	private String contactPatients;

	@Column(name = "VACCINATION_DT", columnDefinition = "DATE|预防接种时间||", nullable = true)
	private Date vaccinationDt;

	@Column(name = "VACCINUM_CATEGORY", columnDefinition = "VARCHAR2|菌苗种类|100|", length = 100, nullable = true)
	private String vaccinumCategory;

	@Column(name = "HEALTH_CONDITION", columnDefinition = "VARCHAR2|过去健康状况|2|", length = 2, nullable = true)
	private String healthCondition;

	@Column(name = "COURTYARD_HOME_POPULATION_NUM", columnDefinition = "VARCHAR2|病家及院内人口数|20|", length = 20, nullable = true)
	private String courtyardHomePopulationNum;

	@Column(name = "HOME_PLAGUE", columnDefinition = "VARCHAR2|家庭中或院内有无其他人患鼠疫|2|", length = 2, nullable = true)
	private String homePlague;

	@Column(name = "DISEASE_VILLAGE_HOUSEHOLDS", columnDefinition = "VARCHAR2|疫村户数|20|", length = 20, nullable = true)
	private String diseaseVillageHouseholds;

	@Column(name = "DISEASE_VILLAGE_POPULATION_NUM", columnDefinition = "VARCHAR2|疫村人口数|20|", length = 20, nullable = true)
	private String diseaseVillagePopulationNum;

	@Column(name = "DISEASE_VILLAGE_M_NUM", columnDefinition = "VARCHAR2|疫村男人口数|20|", length = 20, nullable = true)
	private String diseaseVillageMNum;

	@Column(name = "DISEASE_VILLAGE_F_NUM", columnDefinition = "VARCHAR2|疫村女人口数|20|", length = 20, nullable = true)
	private String diseaseVillageFNum;

	@Column(name = "DISEASE_VILLAGE_TRAFFIC", columnDefinition = "VARCHAR2|疫村地理交通情况（附地图）|200|", length = 200, nullable = true)
	private String diseaseVillageTraffic;

	@Column(name = "DIE_MOUSE_CATEGORY", columnDefinition = "VARCHAR2|病死鼠发现种类|100|", length = 100, nullable = true)
	private String dieMouseCategory;

	@Column(name = "DIE_MOUSE_NUM", columnDefinition = "VARCHAR2|病死鼠发现只数|20|", length = 20, nullable = true)
	private String dieMouseNum;

	@Column(name = "DIE_MOUSE_DT", columnDefinition = "DATE|病死鼠发现日期||", nullable = true)
	private Date dieMouseDt;

	@Column(name = "DIE_MOUSE_ADDR", columnDefinition = "VARCHAR2|病死鼠发现地点|200|", length = 200, nullable = true)
	private String dieMouseAddr;

	@Column(name = "DIE_MOUSE_PLAGUE_CATEGORY", columnDefinition = "VARCHAR2|病死鼠鼠疫检出种类|100|", length = 100, nullable = true)
	private String dieMousePlagueCategory;

	@Column(name = "DIE_MOUSE_PLAGUE_NUM", columnDefinition = "VARCHAR2|病死鼠鼠疫检出只数|20|", length = 20, nullable = true)
	private String dieMousePlagueNum;

	@Column(name = "DIE_MOUSE_PLAGUE_DT", columnDefinition = "DATE|病死鼠鼠疫检出日期||", nullable = true)
	private Date dieMousePlagueDt;

	@Column(name = "FLEA_CATEGORY", columnDefinition = "VARCHAR2|蚤类疫检出种类|100|", length = 100, nullable = true)
	private String fleaCategory;

	@Column(name = "FLEA_FORM", columnDefinition = "VARCHAR2|蚤类疫检出组成|100|", length = 100, nullable = true)
	private String fleaForm;

	@Column(name = "FLEA_NUM", columnDefinition = "VARCHAR2|蚤类疫检出只数|20|", length = 20, nullable = true)
	private String fleaNum;

	@Column(name = "FLEA_DT", columnDefinition = "DATE|蚤类疫检出日期||", nullable = true)
	private Date fleaDt;

	@Column(name = "IN_MOUSE_DENSITY", columnDefinition = "VARCHAR2|室内鼠密度|20|", length = 20, nullable = true)
	private String inMouseDensity;

	@Column(name = "IN_MOUSE_FLEA_EXPONENT", columnDefinition = "VARCHAR2|室内鼠蚤指数|20|", length = 20, nullable = true)
	private String inMouseFleaExponent;

	@Column(name = "OUT_MOUSE_DENSITY", columnDefinition = "VARCHAR2|室外鼠密度|20|", length = 20, nullable = true)
	private String outMouseDensity;

	@Column(name = "OUT_MOUSE_FLEA_EXPONENT", columnDefinition = "VARCHAR2|室外鼠蚤指数|20|", length = 20, nullable = true)
	private String outMouseFleaExponent;

	@Column(name = "HISTORICAL_EPIDEMIC_AREA", columnDefinition = "VARCHAR2|周围有无历史疫区|200|", length = 200, nullable = true)
	private String historicalEpidemicArea;

	@Column(name = "CONTECT_DETAIL", columnDefinition = "VARCHAR2|特殊活动记录|4000|", length = 4000, nullable = true)
	private String contectDetail;

	@Column(name = "DIAGNOSIS_LIVER_CATEGORY_OTHER", columnDefinition = "VARCHAR2|是否曾经被明确诊断过以下“肝病”-其他|20|", length = 20, nullable = true)
	private String diagnosisLiverCategoryOther;

	@Column(name = "IMMUNI_HISTORY_FORM_OTHER", columnDefinition = "VARCHAR2|服苗形式-其他|200|", length = 200, nullable = true)
	private String immuniHistoryFormOther;

	@Column(name = "REPORT_DT", columnDefinition = "DATE|调查日期||", nullable = true)
	private Date reportDt;

	@Column(name = "LIVE_TIME", columnDefinition = "VARCHAR2|发病时在现住址居住时间|2|", length = 2, nullable = true)
	private String liveTime;

	@Column(name = "MR_OTHER", columnDefinition = "VARCHAR2|麻疹、风疹-其他|200|", length = 200, nullable = true)
	private String mrOther;

	@Column(name = "CONTACT_DT", columnDefinition = "VARCHAR2|接触时间|200|", length = 200, nullable = true)
	private String contactDt;

	@Column(name = "SEX_DAYS", columnDefinition = "VARCHAR2|最近一次与配偶性接触时间||", length = 20, nullable = true)
	private String sexDays;

	@Column(name = "EXTRAMARITAL_SEX", columnDefinition = "VARCHAR2|婚外性接触史|2|", length = 2, nullable = true)
	private String extramaritalSex;

	@Column(name = "SEX_HISTORY", columnDefinition = "VARCHAR2|父母性病史|2|", length = 2, nullable = true)
	private String sexHistory;

	@Column(name = "LOUSE_NUM", columnDefinition = "VARCHAR2|该地虱子只数|20|", length = 20, nullable = true)
	private String louse_num;

	@Column(name = "MOSQUITO_FACILITIES", columnDefinition = "VARCHAR2|防蚊设施|2|", length = 2, nullable = true)
	private String mosquitoFacilities;

	@Column(name = "USING_MOSQUITI_NETS", columnDefinition = "VARCHAR2|是否使用蚊帐|2|", length = 2, nullable = true)
	private String usingMosquitiNets;

	@Column(name = "BRIVOUAC", columnDefinition = "VARCHAR2|是否露宿|2|", length = 2, nullable = true)
	private String brivouac;
	
	@Column(name = "IMMUNIZATION_HISTORY_FORM_F", columnDefinition = "VARCHAR2|服苗形式1|2|", length = 2, nullable = true)
	private String immunizationHistoryFormF;
	
	@Column(name = "IMMUNIZATION_HISTORY_FORM_S", columnDefinition = "VARCHAR2|服苗形式2|2|", length = 2, nullable = true)
	private String immunizationHistoryFormS;
	
	@Column(name = "IMMUNIZATION_HISTORY_FORM_T", columnDefinition = "VARCHAR2|服苗形式3|2|", length = 2, nullable = true)
	private String immunizationHistoryFormT;
	
	@Column(name = "IMMUNI_HISTORY_FORM_F_OTHER", columnDefinition = "VARCHAR2|服苗形式-其他1|200|", length = 200, nullable = true)
	private String immuniHistoryFormFOther;
	
	@Column(name = "IMMUNI_HISTORY_FORM_S_OTHER", columnDefinition = "VARCHAR2|服苗形式-其他2|200|", length = 200, nullable = true)
	private String immuniHistoryFormSOther;
	
	@Column(name = "IMMUNI_HISTORY_FORM_T_OTHER", columnDefinition = "VARCHAR2|服苗形式-其他3|200|", length = 200, nullable = true)
	private String immuniHistoryFormTOther;
	
	@Column(name = "RAIN_FALL", columnDefinition = "VARCHAR2|发病前一周下雨否|2|", length = 2, nullable = true)
	private String rainFall;
	
	@Column(name = "RAIN_FALL_NUM", columnDefinition = "VARCHAR2|降雨量|20|", length = 20, nullable = true)
	private String rainFallNum;
	
	@Column(name = "OTHER", columnDefinition = "VARCHAR2|其他|200|", length = 200, nullable = true)
	private String other;
	
	@Column(name = "FIRST_CASE_NAME", columnDefinition = "VARCHAR2|首发病例姓名|20|", length = 20, nullable = true)
	private String firstCaseName;

	@Column(name = "FIRST_CASE_DT", columnDefinition = "DATE|首发病例发病日期||", nullable = true)
	private Date firstCaseDt;


	@Column(name = "MV_ONE", columnDefinition = "VARCHAR2|麻疹首次接种疫苗|2|", length = 2, nullable = true)
	private String mvOne;
	@Column(name = "MV_SEC", columnDefinition = "VARCHAR2|麻疹第二剂接种疫苗种类|2|", length = 2, nullable = true)
	private String mvSec;
	@Column(name = "MV_LAST", columnDefinition = "VARCHAR2|麻疹最后一次接种疫苗|2|", length = 2, nullable = true)
	private String mvLast;
	@Column(name = "FZ_ONE", columnDefinition = "VARCHAR2|风疹首次接种疫苗(风疹)|2|", length = 2, nullable = true)
	private String fzOne;
	@Column(name = "FZ_LAST", columnDefinition = "VARCHAR2|风疹最后一次接种疫苗（风疹）|2|", length = 2, nullable = true)
	private String fzLast;

	@Column(name = "IS_PREGANT", columnDefinition = "VARCHAR2|是否是怀孕妇女|2|", length = 2, nullable = true)
	private String isPregant;
	@Column(name = "PREGANT_WEEK", columnDefinition = "VARCHAR2|怀孕周数|3|", length = 3, nullable = true)
	private String pregantWeek;

	@Column(name = "MV_REASON", columnDefinition = "VARCHAR2|婴儿未按照麻疹要求接种的原因|100|", length = 100, nullable = true)
	private String mvReason;


	@Column(name = "LOCAL", columnDefinition = "VARCHAR2|可能感染地|2|", length = 2, nullable = true)
	private String local;
	@Column(name = "OTHER_LOCAL", columnDefinition = "VARCHAR2|可能感染地-其他国家|100|", length = 100, nullable = true)
	private String otherLocal;
	@Column(name = "DERAIL_LOCAL", columnDefinition = "VARCHAR2|可能感染地-地址|500|", length = 500, nullable = true)
	private String derailLocal;
	@Column(name = "DETAIL_SOURCE", columnDefinition = "VARCHAR2|详细感染地来源|500|", length = 500, nullable = true)
	private String detailSource;
	@Column(name = "BASIS", columnDefinition = "VARCHAR2|详述判断依据|500|", length = 500, nullable = true)
	private String basis;
	@Column(name = "EXAM_COMMENT", columnDefinition = "VARCHAR2|个案调查备注|500|", length = 500, nullable = true)
	private String examComment;


	//布病
	@Column(name = "IS_COAT", columnDefinition = "VARCHAR2|使用防护衣|2|", length = 2, nullable = true)
	private String isCoat;
	@Column(name = "IS_WATER", columnDefinition = "VARCHAR2|使用消毒液|2|", length = 2, nullable = true)
	private String isWater;
	@Column(name = "IS_TOG", columnDefinition = "VARCHAR2|是否人畜共用一口井|2|", length = 2, nullable = true)
	private String isTog;
	@Column(name = "IS_LIVE", columnDefinition = "VARCHAR2|幼羔放卧室内饲养|2|", length = 2, nullable = true)
	private String isLive;

	//腮腺
	@Column(name = "SX_SAME_CASE", columnDefinition = "VARCHAR2|当地有无同样病例发生|2|", length = 2, nullable = true)
	private String sxSameCase;
	@Column(name = "SX_BEFORE_TOUCH", columnDefinition = "VARCHAR2|发病前2-3周与同样病例有无接触|2|", length = 2, nullable = true)
	private String sxBeforeTouch;
	@Column(name = "SX_TOUCH_TRIPE", columnDefinition = "VARCHAR2|接触方式|2|", length = 2, nullable = true)
	private String sxTouchTripe;
	@Column(name = "SX_FAMILY_SAME_CASE", columnDefinition = "VARCHAR2|家庭内有无同样的病人|2|", length = 2, nullable = true)
	private String sxFamilySameCase;
	@Column(name = "SX_ACCEPT_VACCINE", columnDefinition = "VARCHAR2|是否接种过腮腺炎疫苗|2|", length = 2, nullable = true)
	private String sxAcceptVaccine;
	@Column(name = "SX_ACCEPT_LAST_DATE", columnDefinition = "DATE|最后一次接种时间||", nullable = true)
	private Date sxAcceptLastDate;
	@Column(name = "SX_BASIS", columnDefinition = "VARCHAR2|接种依据|2|", length = 2, nullable = true)
	private String sxBasis;
	@Column(name = "SX_VISIT_PLACE", columnDefinition = "VARCHAR2|发病前3周或病后去过何地|2|", length = 2, nullable = true)
	private String sxVisitPlace;
	@Column(name = "SX_PLACE_OTHER", columnDefinition = "VARCHAR2|其他|100|", length = 100, nullable = true)
	private String sxPlaceOther;
	@Column(name = "SX_QUERANTINE", columnDefinition = "VARCHAR2|病人隔离|2|", length = 2, nullable = true)
	private String sxQuerantine;
	@Column(name = "SX_QUERANTINE_PLACE", columnDefinition = "VARCHAR2|隔离地点|2|", length = 2, nullable = true)
	private String sxQuerantinePlace;
	@Column(name = "SX_QUERANTINE_PLACE_OTHER", columnDefinition = "VARCHAR2|其他|100|", length = 100, nullable = true)
	private String sxQuerantinePlaceOther;
	@Column(name = "SX_QUERANTINE_STAR", columnDefinition = "DATE|隔离开始时间||", nullable = true)
	private Date sxQuerantineStar;
	@Column(name = "SX_QUERANTINE_END", columnDefinition = "DATE|隔离结束时间||", nullable = true)
	private Date sxQuerantineEnd;
	@Column(name = "SX_TOUCH_NUM", columnDefinition = "VARCHAR2|与患者密切接触者的人数|100|", length = 100, nullable = true)
	private String sxTouchNum;

	@Column(name = "TEL_KIND", columnDefinition = "VARCHAR2|使用电话的种类|2|", length = 2, nullable = true)
	private String telKind;
	@Column(name = "PC_KIND", columnDefinition = "VARCHAR2|使用电脑的种类|2|", length = 2, nullable = true)
	private String pcKind;
	@Column(name = "PUBLIC_PLACE_NUM", columnDefinition = "VARCHAR2|去公共场所的次数|10|", length = 10, nullable = true)
	private String publicPlaceNum;
	@Column(name = "PUBLIC_PLACE", columnDefinition = "VARCHAR2|哪些场所|100|", length = 100, nullable = true)
	private String publicPlace;
	

	public String getMvLabPatCon() {
		return mvLabPatCon;
	}

	public void setMvLabPatCon(String mvLabPatCon) {
		this.mvLabPatCon = mvLabPatCon;
	}

	public String getFzLabPatCon() {
		return fzLabPatCon;
	}

	public void setFzLabPatCon(String fzLabPatCon) {
		this.fzLabPatCon = fzLabPatCon;
	}

	public Date getMvSecInoculateDt() {
		return mvSecInoculateDt;
	}

	public void setMvSecInoculateDt(Date mvSecInoculateDt) {
		this.mvSecInoculateDt = mvSecInoculateDt;
	}

	public String getMvSec() {
		return mvSec;
	}

	public void setMvSec(String mvSec) {
		this.mvSec = mvSec;
	}

	public String getTelKind() {
		return telKind;
	}

	public void setTelKind(String telKind) {
		this.telKind = telKind;
	}

	public String getPcKind() {
		return pcKind;
	}

	public void setPcKind(String pcKind) {
		this.pcKind = pcKind;
	}

	public String getPublicPlaceNum() {
		return publicPlaceNum;
	}

	public void setPublicPlaceNum(String publicPlaceNum) {
		this.publicPlaceNum = publicPlaceNum;
	}

	public String getPublicPlace() {
		return publicPlace;
	}

	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	public Date getDysenteryBeenHospitalDate() {
		return dysenteryBeenHospitalDate;
	}

	public void setDysenteryBeenHospitalDate(Date dysenteryBeenHospitalDate) {
		this.dysenteryBeenHospitalDate = dysenteryBeenHospitalDate;
	}

	public String getSxSameCase() {
		return sxSameCase;
	}

	public void setSxSameCase(String sxSameCase) {
		this.sxSameCase = sxSameCase;
	}

	public String getSxBeforeTouch() {
		return sxBeforeTouch;
	}

	public void setSxBeforeTouch(String sxBeforeTouch) {
		this.sxBeforeTouch = sxBeforeTouch;
	}

	public String getSxTouchTripe() {
		return sxTouchTripe;
	}

	public void setSxTouchTripe(String sxTouchTripe) {
		this.sxTouchTripe = sxTouchTripe;
	}

	public String getSxFamilySameCase() {
		return sxFamilySameCase;
	}

	public void setSxFamilySameCase(String sxFamilySameCase) {
		this.sxFamilySameCase = sxFamilySameCase;
	}

	public String getSxAcceptVaccine() {
		return sxAcceptVaccine;
	}

	public void setSxAcceptVaccine(String sxAcceptVaccine) {
		this.sxAcceptVaccine = sxAcceptVaccine;
	}

	public Date getSxAcceptLastDate() {
		return sxAcceptLastDate;
	}

	public void setSxAcceptLastDate(Date sxAcceptLastDate) {
		this.sxAcceptLastDate = sxAcceptLastDate;
	}

	public String getSxBasis() {
		return sxBasis;
	}

	public void setSxBasis(String sxBasis) {
		this.sxBasis = sxBasis;
	}

	public String getSxVisitPlace() {
		return sxVisitPlace;
	}

	public void setSxVisitPlace(String sxVisitPlace) {
		this.sxVisitPlace = sxVisitPlace;
	}

	public String getSxPlaceOther() {
		return sxPlaceOther;
	}

	public void setSxPlaceOther(String sxPlaceOther) {
		this.sxPlaceOther = sxPlaceOther;
	}

	public String getSxQuerantine() {
		return sxQuerantine;
	}

	public void setSxQuerantine(String sxQuerantine) {
		this.sxQuerantine = sxQuerantine;
	}

	public String getSxQuerantinePlace() {
		return sxQuerantinePlace;
	}

	public void setSxQuerantinePlace(String sxQuerantinePlace) {
		this.sxQuerantinePlace = sxQuerantinePlace;
	}

	public String getSxQuerantinePlaceOther() {
		return sxQuerantinePlaceOther;
	}

	public void setSxQuerantinePlaceOther(String sxQuerantinePlaceOther) {
		this.sxQuerantinePlaceOther = sxQuerantinePlaceOther;
	}

	public Date getSxQuerantineStar() {
		return sxQuerantineStar;
	}

	public void setSxQuerantineStar(Date sxQuerantineStar) {
		this.sxQuerantineStar = sxQuerantineStar;
	}

	public Date getSxQuerantineEnd() {
		return sxQuerantineEnd;
	}

	public void setSxQuerantineEnd(Date sxQuerantineEnd) {
		this.sxQuerantineEnd = sxQuerantineEnd;
	}

	public String getSxTouchNum() {
		return sxTouchNum;
	}

	public void setSxTouchNum(String sxTouchNum) {
		this.sxTouchNum = sxTouchNum;
	}

	public String getIsCoat() {
		return isCoat;
	}

	public void setIsCoat(String isCoat) {
		this.isCoat = isCoat;
	}

	public String getIsWater() {
		return isWater;
	}

	public void setIsWater(String isWater) {
		this.isWater = isWater;
	}

	public String getIsTog() {
		return isTog;
	}

	public void setIsTog(String isTog) {
		this.isTog = isTog;
	}

	public String getIsLive() {
		return isLive;
	}

	public void setIsLive(String isLive) {
		this.isLive = isLive;
	}

	public String getMvOne() {
		return mvOne;
	}

	public void setMvOne(String mvOne) {
		this.mvOne = mvOne;
	}

	public String getMvLast() {
		return mvLast;
	}

	public void setMvLast(String mvLast) {
		this.mvLast = mvLast;
	}

	public String getFzOne() {
		return fzOne;
	}

	public void setFzOne(String fzOne) {
		this.fzOne = fzOne;
	}

	public String getFzLast() {
		return fzLast;
	}

	public void setFzLast(String fzLast) {
		this.fzLast = fzLast;
	}

	public String getIsPregant() {
		return isPregant;
	}

	public void setIsPregant(String isPregant) {
		this.isPregant = isPregant;
	}

	public String getPregantWeek() {
		return pregantWeek;
	}

	public void setPregantWeek(String pregantWeek) {
		this.pregantWeek = pregantWeek;
	}

	public String getMvReason() {
		return mvReason;
	}

	public void setMvReason(String mvReason) {
		this.mvReason = mvReason;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getOtherLocal() {
		return otherLocal;
	}

	public void setOtherLocal(String otherLocal) {
		this.otherLocal = otherLocal;
	}

	public String getDerailLocal() {
		return derailLocal;
	}

	public void setDerailLocal(String derailLocal) {
		this.derailLocal = derailLocal;
	}

	public String getDetailSource() {
		return detailSource;
	}

	public void setDetailSource(String detailSource) {
		this.detailSource = detailSource;
	}

	public String getBasis() {
		return basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
	}

	public String getExamComment() {
		return examComment;
	}

	public void setExamComment(String examComment) {
		this.examComment = examComment;
	}
	
	public String getFirstCaseName() {
		return firstCaseName;
	}

	public void setFirstCaseName(String firstCaseName) {
		this.firstCaseName = firstCaseName;
	}

	public Date getFirstCaseDt() {
		return firstCaseDt;
	}

	public void setFirstCaseDt(Date firstCaseDt) {
		this.firstCaseDt = firstCaseDt;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getRainFall() {
		return rainFall;
	}

	public void setRainFall(String rainFall) {
		this.rainFall = rainFall;
	}

	public String getRainFallNum() {
		return rainFallNum;
	}

	public void setRainFallNum(String rainFallNum) {
		this.rainFallNum = rainFallNum;
	}

	public String getImmuniHistoryFormFOther() {
		return immuniHistoryFormFOther;
	}

	public void setImmuniHistoryFormFOther(String immuniHistoryFormFOther) {
		this.immuniHistoryFormFOther = immuniHistoryFormFOther;
	}

	public String getImmuniHistoryFormSOther() {
		return immuniHistoryFormSOther;
	}

	public void setImmuniHistoryFormSOther(String immuniHistoryFormSOther) {
		this.immuniHistoryFormSOther = immuniHistoryFormSOther;
	}

	public String getImmuniHistoryFormTOther() {
		return immuniHistoryFormTOther;
	}

	public void setImmuniHistoryFormTOther(String immuniHistoryFormTOther) {
		this.immuniHistoryFormTOther = immuniHistoryFormTOther;
	}

	public String getImmunizationHistoryFormF() {
		return immunizationHistoryFormF;
	}

	public void setImmunizationHistoryFormF(String immunizationHistoryFormF) {
		this.immunizationHistoryFormF = immunizationHistoryFormF;
	}

	public String getImmunizationHistoryFormS() {
		return immunizationHistoryFormS;
	}

	public void setImmunizationHistoryFormS(String immunizationHistoryFormS) {
		this.immunizationHistoryFormS = immunizationHistoryFormS;
	}

	public String getImmunizationHistoryFormT() {
		return immunizationHistoryFormT;
	}

	public void setImmunizationHistoryFormT(String immunizationHistoryFormT) {
		this.immunizationHistoryFormT = immunizationHistoryFormT;
	}

	public String getUsingMosquitiNets() {
		return usingMosquitiNets;
	}

	public void setUsingMosquitiNets(String usingMosquitiNets) {
		this.usingMosquitiNets = usingMosquitiNets;
	}

	public String getBrivouac() {
		return brivouac;
	}

	public void setBrivouac(String brivouac) {
		this.brivouac = brivouac;
	}

	public String getMosquitoFacilities() {
		return mosquitoFacilities;
	}

	public void setMosquitoFacilities(String mosquitoFacilities) {
		this.mosquitoFacilities = mosquitoFacilities;
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

	public String getUseCondom() {
		return this.useCondom;
	}

	public void setUseCondom(String useCondom) {
		this.useCondom = useCondom;
	}

	public String getLastExtramaritalSexDays() {
		return this.lastExtramaritalSexDays;
	}

	public void setLastExtramaritalSexDays(String lastExtramaritalSexDays) {
		this.lastExtramaritalSexDays = lastExtramaritalSexDays;
	}

	public String getOneMonthDoubtfulWater() {
		return this.oneMonthDoubtfulWater;
	}

	public void setOneMonthDoubtfulWater(String oneMonthDoubtfulWater) {
		this.oneMonthDoubtfulWater = oneMonthDoubtfulWater;
	}

	public Date getOneMonthDoubtfulWaterDt() {
		return this.oneMonthDoubtfulWaterDt;
	}

	public void setOneMonthDoubtfulWaterDt(Date oneMonthDoubtfulWaterDt) {
		this.oneMonthDoubtfulWaterDt = oneMonthDoubtfulWaterDt;
	}

	public String getDoubtfulContactWay() {
		return this.doubtfulContactWay;
	}

	public void setDoubtfulContactWay(String doubtfulContactWay) {
		this.doubtfulContactWay = doubtfulContactWay;
	}

	public String getOneMonthMouse() {
		return this.oneMonthMouse;
	}

	public void setOneMonthMouse(String oneMonthMouse) {
		this.oneMonthMouse = oneMonthMouse;
	}

	public String getOneMonthMouseContact() {
		return this.oneMonthMouseContact;
	}

	public void setOneMonthMouseContact(String oneMonthMouseContact) {
		this.oneMonthMouseContact = oneMonthMouseContact;
	}

	public String getOneMonthMouseAnimal() {
		return this.oneMonthMouseAnimal;
	}

	public void setOneMonthMouseAnimal(String oneMonthMouseAnimal) {
		this.oneMonthMouseAnimal = oneMonthMouseAnimal;
	}

	public String getAnimalCategory() {
		return this.animalCategory;
	}

	public void setAnimalCategory(String animalCategory) {
		this.animalCategory = animalCategory;
	}

	public String getLeptospirosisVaccination() {
		return this.leptospirosisVaccination;
	}

	public void setLeptospirosisVaccination(String leptospirosisVaccination) {
		this.leptospirosisVaccination = leptospirosisVaccination;
	}

	public Date getLastInoculateDt() {
		return this.lastInoculateDt;
	}

	public void setLastInoculateDt(Date lastInoculateDt) {
		this.lastInoculateDt = lastInoculateDt;
	}

	public String getInoculateMetrology() {
		return this.inoculateMetrology;
	}

	public void setInoculateMetrology(String inoculateMetrology) {
		this.inoculateMetrology = inoculateMetrology;
	}

	public String getInoculateNum() {
		return this.inoculateNum;
	}

	public void setInoculateNum(String inoculateNum) {
		this.inoculateNum = inoculateNum;
	}

	public String getInoculatePart() {
		return this.inoculatePart;
	}

	public void setInoculatePart(String inoculatePart) {
		this.inoculatePart = inoculatePart;
	}

	public String getPph() {
		return this.pph;
	}

	public void setPph(String pph) {
		this.pph = pph;
	}

	public String getDiagnosisUnit() {
		return this.diagnosisUnit;
	}

	public void setDiagnosisUnit(String diagnosisUnit) {
		this.diagnosisUnit = diagnosisUnit;
	}

	public Date getDiagnosisDt() {
		return this.diagnosisDt;
	}

	public void setDiagnosisDt(Date diagnosisDt) {
		this.diagnosisDt = diagnosisDt;
	}

	public String getInfluenzaVaccinations() {
		return this.influenzaVaccinations;
	}

	public void setInfluenzaVaccinations(String influenzaVaccinations) {
		this.influenzaVaccinations = influenzaVaccinations;
	}

	public Date getFluLastInoculateDt() {
		return this.fluLastInoculateDt;
	}

	public void setFluLastInoculateDt(Date fluLastInoculateDt) {
		this.fluLastInoculateDt = fluLastInoculateDt;
	}

	public String getTivProductName() {
		return this.tivProductName;
	}

	public void setTivProductName(String tivProductName) {
		this.tivProductName = tivProductName;
	}

	public String getTivManufacturers() {
		return this.tivManufacturers;
	}

	public void setTivManufacturers(String tivManufacturers) {
		this.tivManufacturers = tivManufacturers;
	}

	public String getTivWayPart() {
		return this.tivWayPart;
	}

	public void setTivWayPart(String tivWayPart) {
		this.tivWayPart = tivWayPart;
	}

	public String getTivAddr() {
		return this.tivAddr;
	}

	public void setTivAddr(String tivAddr) {
		this.tivAddr = tivAddr;
	}

	public String getRecentContactPatients() {
		return this.recentContactPatients;
	}

	public void setRecentContactPatients(String recentContactPatients) {
		this.recentContactPatients = recentContactPatients;
	}

	public String getRecentContactPatientsAddr() {
		return this.recentContactPatientsAddr;
	}

	public void setRecentContactPatientsAddr(String recentContactPatientsAddr) {
		this.recentContactPatientsAddr = recentContactPatientsAddr;
	}

	public String getOftenPublicPlace() {
		return this.oftenPublicPlace;
	}

	public void setOftenPublicPlace(String oftenPublicPlace) {
		this.oftenPublicPlace = oftenPublicPlace;
	}

	public String getWashingHandEatingToilet() {
		return this.washingHandEatingToilet;
	}

	public void setWashingHandEatingToilet(String washingHandEatingToilet) {
		this.washingHandEatingToilet = washingHandEatingToilet;
	}

	public String getMumpsVaccine() {
		return this.mumpsVaccine;
	}

	public void setMumpsVaccine(String mumpsVaccine) {
		this.mumpsVaccine = mumpsVaccine;
	}

	public String getMmrVaccine() {
		return this.mmrVaccine;
	}

	public void setMmrVaccine(String mmrVaccine) {
		this.mmrVaccine = mmrVaccine;
	}

	public String getMeningitis() {
		return this.meningitis;
	}

	public void setMeningitis(String meningitis) {
		this.meningitis = meningitis;
	}

	public String getJespect() {
		return this.jespect;
	}

	public void setJespect(String jespect) {
		this.jespect = jespect;
	}

	public String getEruptionContact() {
		return this.eruptionContact;
	}

	public void setEruptionContact(String eruptionContact) {
		this.eruptionContact = eruptionContact;
	}

	public String getEruptionContactAddr() {
		return this.eruptionContactAddr;
	}

	public void setEruptionContactAddr(String eruptionContactAddr) {
		this.eruptionContactAddr = eruptionContactAddr;
	}

	public String getEruptionContactPublicPlace() {
		return this.eruptionContactPublicPlace;
	}

	public void setEruptionContactPublicPlace(String eruptionContactPublicPlace) {
		this.eruptionContactPublicPlace = eruptionContactPublicPlace;
	}

	public String getRubellaVaccine() {
		return this.rubellaVaccine;
	}

	public void setRubellaVaccine(String rubellaVaccine) {
		this.rubellaVaccine = rubellaVaccine;
	}

	public Date getLastRubellaVaccineDt() {
		return this.lastRubellaVaccineDt;
	}

	public void setLastRubellaVaccineDt(Date lastRubellaVaccineDt) {
		this.lastRubellaVaccineDt = lastRubellaVaccineDt;
	}

	public String getExceptRubella() {
		return this.exceptRubella;
	}

	public void setExceptRubella(String exceptRubella) {
		this.exceptRubella = exceptRubella;
	}

	public String getTwodaysAgoContactPatients() {
		return this.twodaysAgoContactPatients;
	}

	public void setTwodaysAgoContactPatients(String twodaysAgoContactPatients) {
		this.twodaysAgoContactPatients = twodaysAgoContactPatients;
	}

	public String getRelationPatient() {
		return this.relationPatient;
	}

	public void setRelationPatient(String relationPatient) {
		this.relationPatient = relationPatient;
	}

	public String getHomeTowel() {
		return this.homeTowel;
	}

	public void setHomeTowel(String homeTowel) {
		this.homeTowel = homeTowel;
	}

	public String getHomeBasin() {
		return this.homeBasin;
	}

	public void setHomeBasin(String homeBasin) {
		this.homeBasin = homeBasin;
	}

	public String getHomeNum() {
		return this.homeNum;
	}

	public void setHomeNum(String homeNum) {
		this.homeNum = homeNum;
	}

	public String getBus() {
		return this.bus;
	}

	public void setBus(String bus) {
		this.bus = bus;
	}

	public String getBusNum() {
		return this.busNum;
	}

	public void setBusNum(String busNum) {
		this.busNum = busNum;
	}

	public String getDusDetail() {
		return this.dusDetail;
	}

	public void setDusDetail(String dusDetail) {
		this.dusDetail = dusDetail;
	}

	public String getTexi() {
		return this.texi;
	}

	public void setTexi(String texi) {
		this.texi = texi;
	}

	public String getTexiNum() {
		return this.texiNum;
	}

	public void setTexiNum(String texiNum) {
		this.texiNum = texiNum;
	}

	public String getSwim() {
		return this.swim;
	}

	public void setSwim(String swim) {
		this.swim = swim;
	}

	public String getHomeQuarantine() {
		return this.homeQuarantine;
	}

	public void setHomeQuarantine(String homeQuarantine) {
		this.homeQuarantine = homeQuarantine;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getComputer() {
		return this.computer;
	}

	public void setComputer(String computer) {
		this.computer = computer;
	}

	public String getElevator() {
		return this.elevator;
	}

	public void setElevator(String elevator) {
		this.elevator = elevator;
	}

	public String getElevatorNum() {
		return this.elevatorNum;
	}

	public void setElevatorNum(String elevatorNum) {
		this.elevatorNum = elevatorNum;
	}

	public String getRestaurant() {
		return this.restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public String getRestaurantNum() {
		return this.restaurantNum;
	}

	public void setRestaurantNum(String restaurantNum) {
		this.restaurantNum = restaurantNum;
	}

	public String getBallroom() {
		return this.ballroom;
	}

	public void setBallroom(String ballroom) {
		this.ballroom = ballroom;
	}

	public String getBallroomNum() {
		return this.ballroomNum;
	}

	public void setBallroomNum(String ballroomNum) {
		this.ballroomNum = ballroomNum;
	}

	public String getCybercafe() {
		return this.cybercafe;
	}

	public void setCybercafe(String cybercafe) {
		this.cybercafe = cybercafe;
	}

	public String getCybercafeNum() {
		return this.cybercafeNum;
	}

	public void setCybercafeNum(String cybercafeNum) {
		this.cybercafeNum = cybercafeNum;
	}

	public String getBowling() {
		return this.bowling;
	}

	public void setBowling(String bowling) {
		this.bowling = bowling;
	}

	public String getBowlingNum() {
		return this.bowlingNum;
	}

	public void setBowlingNum(String bowlingNum) {
		this.bowlingNum = bowlingNum;
	}

	public String getOtherPublicPlace() {
		return this.otherPublicPlace;
	}

	public void setOtherPublicPlace(String otherPublicPlace) {
		this.otherPublicPlace = otherPublicPlace;
	}

	public String getHomeContactPatients() {
		return this.homeContactPatients;
	}

	public void setHomeContactPatients(String homeContactPatients) {
		this.homeContactPatients = homeContactPatients;
	}

	public Date getHomeContactPatientsDt() {
		return this.homeContactPatientsDt;
	}

	public void setHomeContactPatientsDt(Date homeContactPatientsDt) {
		this.homeContactPatientsDt = homeContactPatientsDt;
	}

	public String getTyphus() {
		return this.typhus;
	}

	public void setTyphus(String typhus) {
		this.typhus = typhus;
	}

	public Date getTyphusDt() {
		return this.typhusDt;
	}

	public void setTyphusDt(Date typhusDt) {
		this.typhusDt = typhusDt;
	}

	public String getOutHistory() {
		return this.outHistory;
	}

	public void setOutHistory(String outHistory) {
		this.outHistory = outHistory;
	}

	public String getOutHistoryAddr() {
		return this.outHistoryAddr;
	}

	public void setOutHistoryAddr(String outHistoryAddr) {
		this.outHistoryAddr = outHistoryAddr;
	}

	public Date getOutHistoryDeginDt() {
		return this.outHistoryDeginDt;
	}

	public void setOutHistoryDeginDt(Date outHistoryDeginDt) {
		this.outHistoryDeginDt = outHistoryDeginDt;
	}

	public Date getOutHistoryEndDt() {
		return this.outHistoryEndDt;
	}

	public void setOutHistoryEndDt(Date outHistoryEndDt) {
		this.outHistoryEndDt = outHistoryEndDt;
	}

	public String getLouse() {
		return this.louse;
	}

	public void setLouse(String louse) {
		this.louse = louse;
	}

	public String getFlea() {
		return this.flea;
	}

	public void setFlea(String flea) {
		this.flea = flea;
	}

	public String getMouse() {
		return this.mouse;
	}

	public void setMouse(String mouse) {
		this.mouse = mouse;
	}

	public String getCat() {
		return this.cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getContactHistory() {
		return this.contactHistory;
	}

	public void setContactHistory(String contactHistory) {
		this.contactHistory = contactHistory;
	}

	public String getContactPatientName() {
		return this.contactPatientName;
	}

	public void setContactPatientName(String contactPatientName) {
		this.contactPatientName = contactPatientName;
	}

	public String getContactRelation() {
		return this.contactRelation;
	}

	public void setContactRelation(String contactRelation) {
		this.contactRelation = contactRelation;
	}

	public String getContactWay() {
		return this.contactWay;
	}

	public void setContactWay(String contactWay) {
		this.contactWay = contactWay;
	}

	public String getLivingSpace() {
		return this.livingSpace;
	}

	public void setLivingSpace(String livingSpace) {
		this.livingSpace = livingSpace;
	}

	public String getLivingNum() {
		return this.livingNum;
	}

	public void setLivingNum(String livingNum) {
		this.livingNum = livingNum;
	}

	public String getHomeLouse() {
		return this.homeLouse;
	}

	public void setHomeLouse(String homeLouse) {
		this.homeLouse = homeLouse;
	}

	public String getHomeFlea() {
		return this.homeFlea;
	}

	public void setHomeFlea(String homeFlea) {
		this.homeFlea = homeFlea;
	}

	public String getHomeMouse() {
		return this.homeMouse;
	}

	public void setHomeMouse(String homeMouse) {
		this.homeMouse = homeMouse;
	}

	public String getHomeCat() {
		return this.homeCat;
	}

	public void setHomeCat(String homeCat) {
		this.homeCat = homeCat;
	}

	public String getHomeDog() {
		return this.homeDog;
	}

	public void setHomeDog(String homeDog) {
		this.homeDog = homeDog;
	}

	public String getInoculateHistory() {
		return this.inoculateHistory;
	}

	public void setInoculateHistory(String inoculateHistory) {
		this.inoculateHistory = inoculateHistory;
	}

	public Date getInoculateDt() {
		return this.inoculateDt;
	}

	public void setInoculateDt(Date inoculateDt) {
		this.inoculateDt = inoculateDt;
	}

	public String getFieldWork() {
		return this.fieldWork;
	}

	public void setFieldWork(String fieldWork) {
		this.fieldWork = fieldWork;
	}

	public String getFieldHunt() {
		return this.fieldHunt;
	}

	public void setFieldHunt(String fieldHunt) {
		this.fieldHunt = fieldHunt;
	}

	public String getFieldTime() {
		return this.fieldTime;
	}

	public void setFieldTime(String fieldTime) {
		this.fieldTime = fieldTime;
	}

	public String getWildlifeContactHistory() {
		return this.wildlifeContactHistory;
	}

	public void setWildlifeContactHistory(String wildlifeContactHistory) {
		this.wildlifeContactHistory = wildlifeContactHistory;
	}

	public String getContactWildlife() {
		return this.contactWildlife;
	}

	public void setContactWildlife(String contactWildlife) {
		this.contactWildlife = contactWildlife;
	}

	public String getWildlifeContactWay() {
		return this.wildlifeContactWay;
	}

	public void setWildlifeContactWay(String wildlifeContactWay) {
		this.wildlifeContactWay = wildlifeContactWay;
	}

	public String getTransfusion() {
		return this.transfusion;
	}

	public void setTransfusion(String transfusion) {
		this.transfusion = transfusion;
	}

	public String getHomeDogNum() {
		return this.homeDogNum;
	}

	public void setHomeDogNum(String homeDogNum) {
		this.homeDogNum = homeDogNum;
	}

	public String getDiseaseDogNum() {
		return this.diseaseDogNum;
	}

	public void setDiseaseDogNum(String diseaseDogNum) {
		this.diseaseDogNum = diseaseDogNum;
	}

	public String getDieDogNum() {
		return this.dieDogNum;
	}

	public void setDieDogNum(String dieDogNum) {
		this.dieDogNum = dieDogNum;
	}

	public String getPastoralLife() {
		return this.pastoralLife;
	}

	public void setPastoralLife(String pastoralLife) {
		this.pastoralLife = pastoralLife;
	}

	public String getContactPastoral() {
		return this.contactPastoral;
	}

	public void setContactPastoral(String contactPastoral) {
		this.contactPastoral = contactPastoral;
	}

	public String getPastoralDog() {
		return this.pastoralDog;
	}

	public void setPastoralDog(String pastoralDog) {
		this.pastoralDog = pastoralDog;
	}

	public String getPastoralWater() {
		return this.pastoralWater;
	}

	public void setPastoralWater(String pastoralWater) {
		this.pastoralWater = pastoralWater;
	}

	public String getAnimalContact() {
		return this.animalContact;
	}

	public void setAnimalContact(String animalContact) {
		this.animalContact = animalContact;
	}

	public String getLaborProtection() {
		return this.laborProtection;
	}

	public void setLaborProtection(String laborProtection) {
		this.laborProtection = laborProtection;
	}

	public String getLocaltionScarlatina() {
		return this.localtionScarlatina;
	}

	public void setLocaltionScarlatina(String localtionScarlatina) {
		this.localtionScarlatina = localtionScarlatina;
	}

    public String getTheScarlatina() {
        return this.theScarlatina;
    }

    public void setTheScarlatina(String theScarlatina) {
        this.theScarlatina = theScarlatina;
    }

	public String getHomePopulationNum() {
		return this.homePopulationNum;
	}

	public void setHomePopulationNum(String homePopulationNum) {
		this.homePopulationNum = homePopulationNum;
	}

	public String getDoubtfulPatientName() {
		return this.doubtfulPatientName;
	}

	public void setDoubtfulPatientName(String doubtfulPatientName) {
		this.doubtfulPatientName = doubtfulPatientName;
	}

	public String getDoubtfulPatientSex() {
		return this.doubtfulPatientSex;
	}

	public void setDoubtfulPatientSex(String doubtfulPatientSex) {
		this.doubtfulPatientSex = doubtfulPatientSex;
	}

	public String getDoubtfulPatientAge() {
		return this.doubtfulPatientAge;
	}

	public void setDoubtfulPatientAge(String doubtfulPatientAge) {
		this.doubtfulPatientAge = doubtfulPatientAge;
	}

	public Date getDoubtfulPatientAttackDt() {
		return this.doubtfulPatientAttackDt;
	}

	public void setDoubtfulPatientAttackDt(Date doubtfulPatientAttackDt) {
		this.doubtfulPatientAttackDt = doubtfulPatientAttackDt;
	}

	public String getDoubtfulPatientRelation() {
		return this.doubtfulPatientRelation;
	}

	public void setDoubtfulPatientRelation(String doubtfulPatientRelation) {
		this.doubtfulPatientRelation = doubtfulPatientRelation;
	}

	public String getDoubtfulPatientContactWay() {
		return this.doubtfulPatientContactWay;
	}

	public void setDoubtfulPatientContactWay(String doubtfulPatientContactWay) {
		this.doubtfulPatientContactWay = doubtfulPatientContactWay;
	}

	public String getSimilarCases() {
		return this.similarCases;
	}

	public void setSimilarCases(String similarCases) {
		this.similarCases = similarCases;
	}

	public String getDiphtheritisVaccination() {
		return this.diphtheritisVaccination;
	}

	public void setDiphtheritisVaccination(String diphtheritisVaccination) {
		this.diphtheritisVaccination = diphtheritisVaccination;
	}

	public String getDiphtheritisVaccineF() {
		return this.diphtheritisVaccineF;
	}

	public void setDiphtheritisVaccineF(String diphtheritisVaccineF) {
		this.diphtheritisVaccineF = diphtheritisVaccineF;
	}

	public String getDiphtheritisVaccineDtF() {
		return this.diphtheritisVaccineDtF;
	}

	public void setDiphtheritisVaccineDtF(String diphtheritisVaccineDtF) {
		this.diphtheritisVaccineDtF = diphtheritisVaccineDtF;
	}

	public String getDiphtheritisVaccineS() {
		return this.diphtheritisVaccineS;
	}

	public void setDiphtheritisVaccineS(String diphtheritisVaccineS) {
		this.diphtheritisVaccineS = diphtheritisVaccineS;
	}

	public String getDiphtheritisVaccineDtS() {
		return this.diphtheritisVaccineDtS;
	}

	public void setDiphtheritisVaccineDtS(String diphtheritisVaccineDtS) {
		this.diphtheritisVaccineDtS = diphtheritisVaccineDtS;
	}

	public String getDiphtheritisVaccineT() {
		return this.diphtheritisVaccineT;
	}

	public void setDiphtheritisVaccineT(String diphtheritisVaccineT) {
		this.diphtheritisVaccineT = diphtheritisVaccineT;
	}

	public String getDiphtheritisVaccineDtT() {
		return this.diphtheritisVaccineDtT;
	}

	public void setDiphtheritisVaccineDtT(String diphtheritisVaccineDtT) {
		this.diphtheritisVaccineDtT = diphtheritisVaccineDtT;
	}

	public String getDiphtheritisVaccineFo() {
		return this.diphtheritisVaccineFo;
	}

	public void setDiphtheritisVaccineFo(String diphtheritisVaccineFo) {
		this.diphtheritisVaccineFo = diphtheritisVaccineFo;
	}

	public String getDiphtheritisVaccineDtFo() {
		return this.diphtheritisVaccineDtFo;
	}

	public void setDiphtheritisVaccineDtFo(String diphtheritisVaccineDtFo) {
		this.diphtheritisVaccineDtFo = diphtheritisVaccineDtFo;
	}

	public String getDiphtheritisVaccineFi() {
		return this.diphtheritisVaccineFi;
	}

	public void setDiphtheritisVaccineFi(String diphtheritisVaccineFi) {
		this.diphtheritisVaccineFi = diphtheritisVaccineFi;
	}

	public String getDiphtheritisVaccineDtFi() {
		return this.diphtheritisVaccineDtFi;
	}

	public void setDiphtheritisVaccineDtFi(String diphtheritisVaccineDtFi) {
		this.diphtheritisVaccineDtFi = diphtheritisVaccineDtFi;
	}

	public String getDiphtheritisVaccineSi() {
		return this.diphtheritisVaccineSi;
	}

	public void setDiphtheritisVaccineSi(String diphtheritisVaccineSi) {
		this.diphtheritisVaccineSi = diphtheritisVaccineSi;
	}

	public String getDiphtheritisVaccineDtSi() {
		return this.diphtheritisVaccineDtSi;
	}

	public void setDiphtheritisVaccineDtSi(String diphtheritisVaccineDtSi) {
		this.diphtheritisVaccineDtSi = diphtheritisVaccineDtSi;
	}

	public String getVaccinationReason() {
		return this.vaccinationReason;
	}

	public void setVaccinationReason(String vaccinationReason) {
		this.vaccinationReason = vaccinationReason;
	}

	public Date getLastADt() {
		return this.lastADt;
	}

	public void setLastADt(Date lastADt) {
		this.lastADt = lastADt;
	}

	public Date getLastAcDt() {
		return this.lastAcDt;
	}

	public void setLastAcDt(Date lastAcDt) {
		this.lastAcDt = lastAcDt;
	}

	public String getSimilarPatients() {
		return this.similarPatients;
	}

	public void setSimilarPatients(String similarPatients) {
		this.similarPatients = similarPatients;
	}

	public String getDysentery() {
		return this.dysentery;
	}

	public void setDysentery(String dysentery) {
		this.dysentery = dysentery;
	}

	public Date getDysenteryDt() {
		return this.dysenteryDt;
	}

	public void setDysenteryDt(Date dysenteryDt) {
		this.dysenteryDt = dysenteryDt;
	}

	public String getRawWater() {
		return this.rawWater;
	}

	public void setRawWater(String rawWater) {
		this.rawWater = rawWater;
	}

	public String getDoubtfulDiet() {
		return this.doubtfulDiet;
	}

	public void setDoubtfulDiet(String doubtfulDiet) {
		this.doubtfulDiet = doubtfulDiet;
	}

	public Date getDoubtfulDietDt() {
		return this.doubtfulDietDt;
	}

	public void setDoubtfulDietDt(Date doubtfulDietDt) {
		this.doubtfulDietDt = doubtfulDietDt;
	}

	public String getDoubtfulDietName() {
		return this.doubtfulDietName;
	}

	public void setDoubtfulDietName(String doubtfulDietName) {
		this.doubtfulDietName = doubtfulDietName;
	}

	public String getSameMealNum() {
		return this.sameMealNum;
	}

	public void setSameMealNum(String sameMealNum) {
		this.sameMealNum = sameMealNum;
	}

	public String getDysenteryNum() {
		return this.dysenteryNum;
	}

	public void setDysenteryNum(String dysenteryNum) {
		this.dysenteryNum = dysenteryNum;
	}

	public String getDysenteryContactHistory() {
		return this.dysenteryContactHistory;
	}

	public void setDysenteryContactHistory(String dysenteryContactHistory) {
		this.dysenteryContactHistory = dysenteryContactHistory;
	}

	public String getDrinkingWater() {
		return this.drinkingWater;
	}

	public void setDrinkingWater(String drinkingWater) {
		this.drinkingWater = drinkingWater;
	}

	public String getWashWater() {
		return this.washWater;
	}

	public void setWashWater(String washWater) {
		this.washWater = washWater;
	}

	public String getWaterDisinfect() {
		return this.waterDisinfect;
	}

	public void setWaterDisinfect(String waterDisinfect) {
		this.waterDisinfect = waterDisinfect;
	}

	public String getHomeHealth() {
		return this.homeHealth;
	}

	public void setHomeHealth(String homeHealth) {
		this.homeHealth = homeHealth;
	}

	public String getFly() {
		return this.fly;
	}

	public void setFly(String fly) {
		this.fly = fly;
	}

	public String getToilet() {
		return this.toilet;
	}

	public void setToilet(String toilet) {
		this.toilet = toilet;
	}

	public String getDisinfectTreatment() {
		return this.disinfectTreatment;
	}

	public void setDisinfectTreatment(String disinfectTreatment) {
		this.disinfectTreatment = disinfectTreatment;
	}

	public String getCorpseTreatment() {
		return this.corpseTreatment;
	}

	public void setCorpseTreatment(String corpseTreatment) {
		this.corpseTreatment = corpseTreatment;
	}

	public String getDysenteryDtOrder() {
		return this.dysenteryDtOrder;
	}

	public void setDysenteryDtOrder(String dysenteryDtOrder) {
		this.dysenteryDtOrder = dysenteryDtOrder;
	}

	public String getAnthrax() {
		return this.anthrax;
	}

	public void setAnthrax(String anthrax) {
		this.anthrax = anthrax;
	}

	public Date getAnthraxDt() {
		return this.anthraxDt;
	}

	public void setAnthraxDt(Date anthraxDt) {
		this.anthraxDt = anthraxDt;
	}

	public String getAnthraxVaccination() {
		return this.anthraxVaccination;
	}

	public void setAnthraxVaccination(String anthraxVaccination) {
		this.anthraxVaccination = anthraxVaccination;
	}

	public Date getAnthraxVaccinationDt() {
		return this.anthraxVaccinationDt;
	}

	public void setAnthraxVaccinationDt(Date anthraxVaccinationDt) {
		this.anthraxVaccinationDt = anthraxVaccinationDt;
	}

	public String getOutHistoryDays() {
		return this.outHistoryDays;
	}

	public void setOutHistoryDays(String outHistoryDays) {
		this.outHistoryDays = outHistoryDays;
	}

	public String getDysenteryOutHistoryAddr() {
		return this.dysenteryOutHistoryAddr;
	}

	public void setDysenteryOutHistoryAddr(String dysenteryOutHistoryAddr) {
		this.dysenteryOutHistoryAddr = dysenteryOutHistoryAddr;
	}

	public String getDysenteryOutHistoryDays() {
		return this.dysenteryOutHistoryDays;
	}

	public void setDysenteryOutHistoryDays(String dysenteryOutHistoryDays) {
		this.dysenteryOutHistoryDays = dysenteryOutHistoryDays;
	}

	public String getJespectCategory() {
		return this.jespectCategory;
	}

	public void setJespectCategory(String jespectCategory) {
		this.jespectCategory = jespectCategory;
	}

	public Date getJespectInactivateDtF() {
		return this.jespectInactivateDtF;
	}

	public void setJespectInactivateDtF(Date jespectInactivateDtF) {
		this.jespectInactivateDtF = jespectInactivateDtF;
	}

	public Date getJespectInactivateDtS() {
		return this.jespectInactivateDtS;
	}

	public void setJespectInactivateDtS(Date jespectInactivateDtS) {
		this.jespectInactivateDtS = jespectInactivateDtS;
	}

	public Date getJespectInactivateDtT() {
		return this.jespectInactivateDtT;
	}

	public void setJespectInactivateDtT(Date jespectInactivateDtT) {
		this.jespectInactivateDtT = jespectInactivateDtT;
	}

	public Date getJespectInactivateDtFo() {
		return this.jespectInactivateDtFo;
	}

	public void setJespectInactivateDtFo(Date jespectInactivateDtFo) {
		this.jespectInactivateDtFo = jespectInactivateDtFo;
	}

	public Date getJespectInactivateLast() {
		return this.jespectInactivateLast;
	}

	public void setJespectInactivateLast(Date jespectInactivateLast) {
		this.jespectInactivateLast = jespectInactivateLast;
	}

	public Date getJespectAttenuatedDtF() {
		return this.jespectAttenuatedDtF;
	}

	public void setJespectAttenuatedDtF(Date jespectAttenuatedDtF) {
		this.jespectAttenuatedDtF = jespectAttenuatedDtF;
	}

	public Date getJespectAttenuatedDtS() {
		return this.jespectAttenuatedDtS;
	}

	public void setJespectAttenuatedDtS(Date jespectAttenuatedDtS) {
		this.jespectAttenuatedDtS = jespectAttenuatedDtS;
	}

	public Date getJespectAttenuatedDtT() {
		return this.jespectAttenuatedDtT;
	}

	public void setJespectAttenuatedDtT(Date jespectAttenuatedDtT) {
		this.jespectAttenuatedDtT = jespectAttenuatedDtT;
	}

	public Date getJespectAttenuatedLast() {
		return this.jespectAttenuatedLast;
	}

	public void setJespectAttenuatedLast(Date jespectAttenuatedLast) {
		this.jespectAttenuatedLast = jespectAttenuatedLast;
	}

	public String getUnvaccinatedReason() {
		return this.unvaccinatedReason;
	}

	public void setUnvaccinatedReason(String unvaccinatedReason) {
		this.unvaccinatedReason = unvaccinatedReason;
	}

	public String getUnvaccinatedReasonOther() {
		return this.unvaccinatedReasonOther;
	}

	public void setUnvaccinatedReasonOther(String unvaccinatedReasonOther) {
		this.unvaccinatedReasonOther = unvaccinatedReasonOther;
	}

	public String getCollectiveUnit() {
		return this.collectiveUnit;
	}

	public void setCollectiveUnit(String collectiveUnit) {
		this.collectiveUnit = collectiveUnit;
	}

	public String getCollectiveUnitName() {
		return this.collectiveUnitName;
	}

	public void setCollectiveUnitName(String collectiveUnitName) {
		this.collectiveUnitName = collectiveUnitName;
	}

	public String getMeaslesvaccineIngredientsNum() {
		return this.measlesvaccineIngredientsNum;
	}

	public void setMeaslesvaccineIngredientsNum(String measlesvaccineIngredientsNum) {
		this.measlesvaccineIngredientsNum = measlesvaccineIngredientsNum;
	}

	public String getMvImmunizationHistorySource() {
		return this.mvImmunizationHistorySource;
	}

	public void setMvImmunizationHistorySource(String mvImmunizationHistorySource) {
		this.mvImmunizationHistorySource = mvImmunizationHistorySource;
	}

	public Date getMvInoculateDt() {
		return this.mvInoculateDt;
	}

	public void setMvInoculateDt(Date mvInoculateDt) {
		this.mvInoculateDt = mvInoculateDt;
	}

	public Date getMvLastInoculateDt() {
		return this.mvLastInoculateDt;
	}

	public void setMvLastInoculateDt(Date mvLastInoculateDt) {
		this.mvLastInoculateDt = mvLastInoculateDt;
	}

	public String getRubellavaccineIngredientsNum() {
		return this.rubellavaccineIngredientsNum;
	}

	public void setRubellavaccineIngredientsNum(String rubellavaccineIngredientsNum) {
		this.rubellavaccineIngredientsNum = rubellavaccineIngredientsNum;
	}

	public String getRvImmunizationHistorySource() {
		return this.rvImmunizationHistorySource;
	}

	public void setRvImmunizationHistorySource(String rvImmunizationHistorySource) {
		this.rvImmunizationHistorySource = rvImmunizationHistorySource;
	}

	public Date getRvInoculateDt() {
		return this.rvInoculateDt;
	}

	public void setRvInoculateDt(Date rvInoculateDt) {
		this.rvInoculateDt = rvInoculateDt;
	}

	public Date getRvLastInoculateDt() {
		return this.rvLastInoculateDt;
	}

	public void setRvLastInoculateDt(Date rvLastInoculateDt) {
		this.rvLastInoculateDt = rvLastInoculateDt;
	}

	public String getDysenteryBeenHospital() {
		return this.dysenteryBeenHospital;
	}

	public void setDysenteryBeenHospital(String dysenteryBeenHospital) {
		this.dysenteryBeenHospital = dysenteryBeenHospital;
	}

	public String getDysenteryBeenHospitalName() {
		return this.dysenteryBeenHospitalName;
	}

	public void setDysenteryBeenHospitalName(String dysenteryBeenHospitalName) {
		this.dysenteryBeenHospitalName = dysenteryBeenHospitalName;
	}

	public String getLabPatientsContact() {
		return this.labPatientsContact;
	}

	public void setLabPatientsContact(String labPatientsContact) {
		this.labPatientsContact = labPatientsContact;
	}

	public String getLabConfirmedCase() {
		return this.labConfirmedCase;
	}

	public void setLabConfirmedCase(String labConfirmedCase) {
		this.labConfirmedCase = labConfirmedCase;
	}

	public String getMeaslesOutbreakCase() {
		return this.measlesOutbreakCase;
	}

	public void setMeaslesOutbreakCase(String measlesOutbreakCase) {
		this.measlesOutbreakCase = measlesOutbreakCase;
	}

	public String getNewOutbreak() {
		return this.newOutbreak;
	}

	public void setNewOutbreak(String newOutbreak) {
		this.newOutbreak = newOutbreak;
	}

	public String getOutbreakNo() {
		return this.outbreakNo;
	}

	public void setOutbreakNo(String outbreakNo) {
		this.outbreakNo = outbreakNo;
	}

	public String getOpvNum() {
		return this.opvNum;
	}

	public void setOpvNum(String opvNum) {
		this.opvNum = opvNum;
	}

	public String getImmunizationHistorySource() {
		return this.immunizationHistorySource;
	}

	public void setImmunizationHistorySource(String immunizationHistorySource) {
		this.immunizationHistorySource = immunizationHistorySource;
	}

	public Date getPalsyLastDt() {
		return this.palsyLastDt;
	}

	public void setPalsyLastDt(Date palsyLastDt) {
		this.palsyLastDt = palsyLastDt;
	}

	public String getImmunizationHistoryForm() {
		return this.immunizationHistoryForm;
	}

	public void setImmunizationHistoryForm(String immunizationHistoryForm) {
		this.immunizationHistoryForm = immunizationHistoryForm;
	}

	public Date getStoolLastDt() {
		return this.stoolLastDt;
	}

	public void setStoolLastDt(Date stoolLastDt) {
		this.stoolLastDt = stoolLastDt;
	}

	public String getHepatitisBVaccine() {
		return this.hepatitisBVaccine;
	}

	public void setHepatitisBVaccine(String hepatitisBVaccine) {
		this.hepatitisBVaccine = hepatitisBVaccine;
	}

	public Date getHepatitisBVaccineDtF() {
		return this.hepatitisBVaccineDtF;
	}

	public void setHepatitisBVaccineDtF(Date hepatitisBVaccineDtF) {
		this.hepatitisBVaccineDtF = hepatitisBVaccineDtF;
	}

	public Date getHepatitisBVaccineDtS() {
		return this.hepatitisBVaccineDtS;
	}

	public void setHepatitisBVaccineDtS(Date hepatitisBVaccineDtS) {
		this.hepatitisBVaccineDtS = hepatitisBVaccineDtS;
	}

	public Date getHepatitisBVaccineDtT() {
		return this.hepatitisBVaccineDtT;
	}

	public void setHepatitisBVaccineDtT(Date hepatitisBVaccineDtT) {
		this.hepatitisBVaccineDtT = hepatitisBVaccineDtT;
	}

	public Date getFirstEpisodeDt() {
		return this.firstEpisodeDt;
	}

	public void setFirstEpisodeDt(Date firstEpisodeDt) {
		this.firstEpisodeDt = firstEpisodeDt;
	}

	public Date getFirstTreatmentDt() {
		return this.firstTreatmentDt;
	}

	public void setFirstTreatmentDt(Date firstTreatmentDt) {
		this.firstTreatmentDt = firstTreatmentDt;
	}

	public String getTheTreatmentUnit() {
		return this.theTreatmentUnit;
	}

	public void setTheTreatmentUnit(String theTreatmentUnit) {
		this.theTreatmentUnit = theTreatmentUnit;
	}

	public String getHepatitisBVaccineNum() {
		return this.hepatitisBVaccineNum;
	}

	public void setHepatitisBVaccineNum(String hepatitisBVaccineNum) {
		this.hepatitisBVaccineNum = hepatitisBVaccineNum;
	}

	public String getHbs() {
		return this.hbs;
	}

	public void setHbs(String hbs) {
		this.hbs = hbs;
	}

	public String getHepatitisBImmunoglobulin() {
		return this.hepatitisBImmunoglobulin;
	}

	public void setHepatitisBImmunoglobulin(String hepatitisBImmunoglobulin) {
		this.hepatitisBImmunoglobulin = hepatitisBImmunoglobulin;
	}

	public Date getHepatitisBImmunoglobulinDt() {
		return this.hepatitisBImmunoglobulinDt;
	}

	public void setHepatitisBImmunoglobulinDt(Date hepatitisBImmunoglobulinDt) {
		this.hepatitisBImmunoglobulinDt = hepatitisBImmunoglobulinDt;
	}

	public String getAimmugen() {
		return this.aimmugen;
	}

	public void setAimmugen(String aimmugen) {
		this.aimmugen = aimmugen;
	}

	public String getAimmugenCategory() {
		return this.aimmugenCategory;
	}

	public void setAimmugenCategory(String aimmugenCategory) {
		this.aimmugenCategory = aimmugenCategory;
	}

	public String getAimmugenNum() {
		return this.aimmugenNum;
	}

	public void setAimmugenNum(String aimmugenNum) {
		this.aimmugenNum = aimmugenNum;
	}

	public Date getAimmugenDtF() {
		return this.aimmugenDtF;
	}

	public void setAimmugenDtF(Date aimmugenDtF) {
		this.aimmugenDtF = aimmugenDtF;
	}

	public Date getAimmugenDtS() {
		return this.aimmugenDtS;
	}

	public void setAimmugenDtS(Date aimmugenDtS) {
		this.aimmugenDtS = aimmugenDtS;
	}

	public String getHepatitisAGammaGlobulin() {
		return this.hepatitisAGammaGlobulin;
	}

	public void setHepatitisAGammaGlobulin(String hepatitisAGammaGlobulin) {
		this.hepatitisAGammaGlobulin = hepatitisAGammaGlobulin;
	}

	public Date getHepatitisAGammaGlobulinDt() {
		return this.hepatitisAGammaGlobulinDt;
	}

	public void setHepatitisAGammaGlobulinDt(Date hepatitisAGammaGlobulinDt) {
		this.hepatitisAGammaGlobulinDt = hepatitisAGammaGlobulinDt;
	}

	public String getDiagnosisLiverCategory() {
		return this.diagnosisLiverCategory;
	}

	public void setDiagnosisLiverCategory(String diagnosisLiverCategory) {
		this.diagnosisLiverCategory = diagnosisLiverCategory;
	}

	public Date getLiverFirstEpisodeDt() {
		return this.liverFirstEpisodeDt;
	}

	public void setLiverFirstEpisodeDt(Date liverFirstEpisodeDt) {
		this.liverFirstEpisodeDt = liverFirstEpisodeDt;
	}

	public String getLiverDiagnosis() {
		return this.liverDiagnosis;
	}

	public void setLiverDiagnosis(String liverDiagnosis) {
		this.liverDiagnosis = liverDiagnosis;
	}

	public String getLiverDiagnosisUnit() {
		return this.liverDiagnosisUnit;
	}

	public void setLiverDiagnosisUnit(String liverDiagnosisUnit) {
		this.liverDiagnosisUnit = liverDiagnosisUnit;
	}

	public String getHepatitis() {
		return this.hepatitis;
	}

	public void setHepatitis(String hepatitis) {
		this.hepatitis = hepatitis;
	}

	public Date getHepatitisDt() {
		return this.hepatitisDt;
	}

	public void setHepatitisDt(Date hepatitisDt) {
		this.hepatitisDt = hepatitisDt;
	}

	public String getHepatitisCategory() {
		return this.hepatitisCategory;
	}

	public void setHepatitisCategory(String hepatitisCategory) {
		this.hepatitisCategory = hepatitisCategory;
	}

	public String getHepatitisOther() {
		return this.hepatitisOther;
	}

	public void setHepatitisOther(String hepatitisOther) {
		this.hepatitisOther = hepatitisOther;
	}

	public String getHepatitisContactHistory() {
		return this.hepatitisContactHistory;
	}

	public void setHepatitisContactHistory(String hepatitisContactHistory) {
		this.hepatitisContactHistory = hepatitisContactHistory;
	}

	public String getChHepatitisCategory() {
		return this.chHepatitisCategory;
	}

	public void setChHepatitisCategory(String chHepatitisCategory) {
		this.chHepatitisCategory = chHepatitisCategory;
	}

	public String getChHepatitisOther() {
		return this.chHepatitisOther;
	}

	public void setChHepatitisOther(String chHepatitisOther) {
		this.chHepatitisOther = chHepatitisOther;
	}

	public Date getSurveyDate() {
		return this.surveyDate;
	}

	public void setSurveyDate(Date surveyDate) {
		this.surveyDate = surveyDate;
	}

	public String getSarsPatient() {
		return this.sarsPatient;
	}

	public void setSarsPatient(String sarsPatient) {
		this.sarsPatient = sarsPatient;
	}

	public String getSarsAnimal() {
		return this.sarsAnimal;
	}

	public void setSarsAnimal(String sarsAnimal) {
		this.sarsAnimal = sarsAnimal;
	}

	public String getPlague() {
		return this.plague;
	}

	public void setPlague(String plague) {
		this.plague = plague;
	}

	public String getPlagueAddr() {
		return this.plagueAddr;
	}

	public void setPlagueAddr(String plagueAddr) {
		this.plagueAddr = plagueAddr;
	}

	public String getContactPatients() {
		return this.contactPatients;
	}

	public void setContactPatients(String contactPatients) {
		this.contactPatients = contactPatients;
	}

	public Date getVaccinationDt() {
		return this.vaccinationDt;
	}

	public void setVaccinationDt(Date vaccinationDt) {
		this.vaccinationDt = vaccinationDt;
	}

	public String getVaccinumCategory() {
		return this.vaccinumCategory;
	}

	public void setVaccinumCategory(String vaccinumCategory) {
		this.vaccinumCategory = vaccinumCategory;
	}

	public String getHealthCondition() {
		return this.healthCondition;
	}

	public void setHealthCondition(String healthCondition) {
		this.healthCondition = healthCondition;
	}

	public String getCourtyardHomePopulationNum() {
		return this.courtyardHomePopulationNum;
	}

	public void setCourtyardHomePopulationNum(String courtyardHomePopulationNum) {
		this.courtyardHomePopulationNum = courtyardHomePopulationNum;
	}

	public String getHomePlague() {
		return this.homePlague;
	}

	public void setHomePlague(String homePlague) {
		this.homePlague = homePlague;
	}

	public String getDiseaseVillageHouseholds() {
		return this.diseaseVillageHouseholds;
	}

	public void setDiseaseVillageHouseholds(String diseaseVillageHouseholds) {
		this.diseaseVillageHouseholds = diseaseVillageHouseholds;
	}

	public String getDiseaseVillagePopulationNum() {
		return this.diseaseVillagePopulationNum;
	}

	public void setDiseaseVillagePopulationNum(String diseaseVillagePopulationNum) {
		this.diseaseVillagePopulationNum = diseaseVillagePopulationNum;
	}

	public String getDiseaseVillageMNum() {
		return this.diseaseVillageMNum;
	}

	public void setDiseaseVillageMNum(String diseaseVillageMNum) {
		this.diseaseVillageMNum = diseaseVillageMNum;
	}

	public String getDiseaseVillageFNum() {
		return this.diseaseVillageFNum;
	}

	public void setDiseaseVillageFNum(String diseaseVillageFNum) {
		this.diseaseVillageFNum = diseaseVillageFNum;
	}

	public String getDiseaseVillageTraffic() {
		return this.diseaseVillageTraffic;
	}

	public void setDiseaseVillageTraffic(String diseaseVillageTraffic) {
		this.diseaseVillageTraffic = diseaseVillageTraffic;
	}

	public String getDieMouseCategory() {
		return this.dieMouseCategory;
	}

	public void setDieMouseCategory(String dieMouseCategory) {
		this.dieMouseCategory = dieMouseCategory;
	}

	public String getDieMouseNum() {
		return this.dieMouseNum;
	}

	public void setDieMouseNum(String dieMouseNum) {
		this.dieMouseNum = dieMouseNum;
	}

	public Date getDieMouseDt() {
		return this.dieMouseDt;
	}

	public void setDieMouseDt(Date dieMouseDt) {
		this.dieMouseDt = dieMouseDt;
	}

	public String getDieMouseAddr() {
		return this.dieMouseAddr;
	}

	public void setDieMouseAddr(String dieMouseAddr) {
		this.dieMouseAddr = dieMouseAddr;
	}

	public String getDieMousePlagueCategory() {
		return this.dieMousePlagueCategory;
	}

	public void setDieMousePlagueCategory(String dieMousePlagueCategory) {
		this.dieMousePlagueCategory = dieMousePlagueCategory;
	}

	public String getDieMousePlagueNum() {
		return this.dieMousePlagueNum;
	}

	public void setDieMousePlagueNum(String dieMousePlagueNum) {
		this.dieMousePlagueNum = dieMousePlagueNum;
	}

	public Date getDieMousePlagueDt() {
		return this.dieMousePlagueDt;
	}

	public void setDieMousePlagueDt(Date dieMousePlagueDt) {
		this.dieMousePlagueDt = dieMousePlagueDt;
	}

	public String getFleaCategory() {
		return this.fleaCategory;
	}

	public void setFleaCategory(String fleaCategory) {
		this.fleaCategory = fleaCategory;
	}

	public String getFleaForm() {
		return this.fleaForm;
	}

	public void setFleaForm(String fleaForm) {
		this.fleaForm = fleaForm;
	}

	public String getFleaNum() {
		return this.fleaNum;
	}

	public void setFleaNum(String fleaNum) {
		this.fleaNum = fleaNum;
	}

	public Date getFleaDt() {
		return this.fleaDt;
	}

	public void setFleaDt(Date fleaDt) {
		this.fleaDt = fleaDt;
	}

	public String getInMouseDensity() {
		return this.inMouseDensity;
	}

	public void setInMouseDensity(String inMouseDensity) {
		this.inMouseDensity = inMouseDensity;
	}

	public String getInMouseFleaExponent() {
		return this.inMouseFleaExponent;
	}

	public void setInMouseFleaExponent(String inMouseFleaExponent) {
		this.inMouseFleaExponent = inMouseFleaExponent;
	}

	public String getOutMouseDensity() {
		return this.outMouseDensity;
	}

	public void setOutMouseDensity(String outMouseDensity) {
		this.outMouseDensity = outMouseDensity;
	}

	public String getOutMouseFleaExponent() {
		return this.outMouseFleaExponent;
	}

	public void setOutMouseFleaExponent(String outMouseFleaExponent) {
		this.outMouseFleaExponent = outMouseFleaExponent;
	}

	public String getHistoricalEpidemicArea() {
		return this.historicalEpidemicArea;
	}

	public void setHistoricalEpidemicArea(String historicalEpidemicArea) {
		this.historicalEpidemicArea = historicalEpidemicArea;
	}

	public String getContectDetail() {
		return this.contectDetail;
	}

	public void setContectDetail(String contectDetail) {
		this.contectDetail = contectDetail;
	}

	public String getDiagnosisLiverCategoryOther() {
		return this.diagnosisLiverCategoryOther;
	}

	public void setDiagnosisLiverCategoryOther(String diagnosisLiverCategoryOther) {
		this.diagnosisLiverCategoryOther = diagnosisLiverCategoryOther;
	}

	public String getImmuniHistoryFormOther() {
		return this.immuniHistoryFormOther;
	}

	public void setImmuniHistoryFormOther(String immuniHistoryFormOther) {
		this.immuniHistoryFormOther = immuniHistoryFormOther;
	}

	public Date getReportDt() {
		return this.reportDt;
	}

	public void setReportDt(Date reportDt) {
		this.reportDt = reportDt;
	}

	public String getLiveTime() {
		return this.liveTime;
	}

	public void setLiveTime(String liveTime) {
		this.liveTime = liveTime;
	}

	public String getMrOther() {
		return this.mrOther;
	}

	public void setMrOther(String mrOther) {
		this.mrOther = mrOther;
	}

	public String getContactDt() {
		return this.contactDt;
	}

	public void setContactDt(String contactDt) {
		this.contactDt = contactDt;
	}

	public String getSexDays() {
		return this.sexDays;
	}

	public void setSexDays(String sexDays) {
		this.sexDays = sexDays;
	}

	public String getExtramaritalSex() {
		return this.extramaritalSex;
	}

	public void setExtramaritalSex(String extramaritalSex) {
		this.extramaritalSex = extramaritalSex;
	}

	public String getSexHistory() {
		return this.sexHistory;
	}

	public void setSexHistory(String sexHistory) {
		this.sexHistory = sexHistory;
	}

	public String getLouse_num() {
		return this.louse_num;
	}

	public void setLouse_num(String louse_num) {
		this.louse_num = louse_num;
	}

    public String getContactWayMulti() {
        return contactWayMulti;
    }

    public void setContactWayMulti(String contactWayMulti) {
        this.contactWayMulti = contactWayMulti;
    }

    /**
	 * @return the contactRelationOther
	 */
	public String getContactRelationOther() {
		return contactRelationOther;
	}

	/**
	 * @param contactRelationOther the contactRelationOther to set
	 */
	public void setContactRelationOther(String contactRelationOther) {
		this.contactRelationOther = contactRelationOther;
	}
}