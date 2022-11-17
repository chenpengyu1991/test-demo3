package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 其他信息
 */
@Entity
@Table(name = "IDM_OTHER_CONDITION")
public class OtherCondition implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编码|11|", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "SURVEY_SUMMARY", columnDefinition = "VARCHAR2|处置调查小结|4000|", length = 4000, nullable = true)
	private String surveySummary;

	@Column(name = "SOURCES_INFECTION", columnDefinition = "VARCHAR2|可能传播源|100|", length = 100, nullable = true)
	private String sourcesInfection;

	@Column(name = "ROUTE_TRANSMISSION", columnDefinition = "VARCHAR2|可能传播途径|100|", length = 100, nullable = true)
	private String routeTransmission;

	@Column(name = "CONTROL_MEASURES", columnDefinition = "VARCHAR2|简述控制措施|4000|", length = 4000, nullable = true)
	private String controlMeasures;

	@Column(name = "OUTCOME_CODE", columnDefinition = "VARCHAR2|转归|2|", length = 2, nullable = true)
	private String outcomeCode;

	@Column(name = "HORMONOTHERAPY_FLG", columnDefinition = "VARCHAR2|是否用激素治疗|2|", length = 2, nullable = true)
	private String hormonotherapyFlg;

	@Column(name = "ANTIBACTERIALS", columnDefinition = "VARCHAR2|所用抗菌药物|100|", length = 100, nullable = true)
	private String antibacterials;

	@Column(name = "ANTIBACTERIALS_PERTIME", columnDefinition = "VARCHAR2|治疗剂量|20|", length = 20, nullable = true)
	private String antibacterialsPertime;

	@Column(name = "ANTIBACTERIALS_DAY", columnDefinition = "VARCHAR2|治疗天数|20|", length = 20, nullable = true)
	private String antibacterialsDay;

	@Column(name = "THERAPY_TIME", columnDefinition = "DATE|开始治疗时间||", nullable = true)
	private Date therapyTime;

	@Column(name = "DEATH_TIME", columnDefinition = "DATE|死亡时间||", nullable = true)
	private Date deathTime;

	@Column(name = "DEATH_CAUSE", columnDefinition = "VARCHAR2|死亡原因|100|", length = 100, nullable = true)
	private String deathCause;

	@Column(name = "CASE_TYPE", columnDefinition = "VARCHAR2|病例分类|20|", length = 20, nullable = true)
	private String caseType;

	@Column(name = "DOCOTR_NAME", columnDefinition = "VARCHAR2|主管医生|50|", length = 50, nullable = true)
	private String docotrName;

	@Column(name = "CLINICAL_CASE", columnDefinition = "VARCHAR2|病例临床诊断|20|", length = 20, nullable = true)
	private String clinicalCase;

	@Column(name = "SOURCE_INFECTION", columnDefinition = "VARCHAR2|可能感染来源|20|", length = 20, nullable = true)
	private String sourceInfection;

	@Column(name = "MODE_INFECTION", columnDefinition = "VARCHAR2|可能感染方式|20|", length = 20, nullable = true)
	private String modeInfection;

	@Column(name = "TREATMENT_MEASURES", columnDefinition = "VARCHAR2|其它处理措施|50|", length = 50, nullable = true)
	private String treatmentMeasures;

	@Column(name = "FIRST_CASE_FLG", columnDefinition = "VARCHAR2|是否首例|20|", length = 20, nullable = true)
	private String firstCaseFlg;

	@Column(name = "DENGUE_CASE_TYPE", columnDefinition = "VARCHAR2|病例分类|20|", length = 20, nullable = true)
	private String dengueCaseType;

	@Column(name = "CLASSIFY_ACCORDING", columnDefinition = "VARCHAR2|分类依据|20|", length = 20, nullable = true)
	private String classifyAccording;

	@Column(name = "CLASSIFY_ACCORDING_OTHER", columnDefinition = "VARCHAR2|分类依据_其他|100|", length = 100, nullable = true)
	private String classifyAccordingOther;

	@Column(name = "CURE_FLG", columnDefinition = "VARCHAR2|是否治愈|2|", length = 2, nullable = true)
	private String cureFlg;

	@Column(name = "CURE_DATE", columnDefinition = "DATE|治愈时间||", nullable = true)
	private Date cureDate;

	@Column(name = "DEATH_FLG", columnDefinition = "VARCHAR2|是否死亡|20|", length = 20, nullable = true)
	private String deathFlg;

	@Column(name = "INPATIENT_FLG", columnDefinition = "VARCHAR2|是否住院|2|", length = 2, nullable = true)
	private String inpatientFlg;

	@Column(name = "INHOS_TIME", columnDefinition = "DATE|入院时间||", nullable = true)
	private Date inhosTime;

	@Column(name = "OUTHOS_DATE", columnDefinition = "DATE|出院时间||", nullable = true)
	private Date outhosDate;

	@Column(name = "SUPPLY_INVESTIGATION", columnDefinition = "VARCHAR2|补充调查|100|", length = 100, nullable = true)
	private String supplyInvestigation;

	@Column(name = "COMPLICATIONS", columnDefinition = "VARCHAR2|并发症|100|", length = 100, nullable = true)
	private String complications;

	@Column(name = "CLINICAL_CASE_EXCLUDE_NAME", columnDefinition = "VARCHAR2|病例临床诊断-排除病名|100|", length = 100, nullable = true)
	private String clinicalCaseExcludeName;

	@Column(name = "DIAGNOSIS_UNIT", columnDefinition = "VARCHAR2|诊断单位|100|", length = 100, nullable = true)
	private String diagnosisUnit;

	@Column(name = "FINAL_DIAGNOSIS", columnDefinition = "VARCHAR2|最终诊断|2|", length = 2, nullable = true)
	private String finalDiagnosis;

	@Column(name = "OUTCOME_CODE_OTHER", columnDefinition = "VARCHAR2|转归-其他|100|", length = 100, nullable = true)
	private String outcomeCodeOther;

	@Column(name = "CASE_SOURCE", columnDefinition = "VARCHAR2|病例来源|2|", length = 2, nullable = true)
	private String caseSource;

    @Column(name = "FEES_TYPE", columnDefinition = "VARCHAR2|收费类型|2|", length = 2, nullable = true)
    private String feesType;

    @Column(name = "CURE_CONDITION", columnDefinition = "VARCHAR2|治疗情况|500|", length = 500, nullable = true)
    private String cureCondition;

    @Column(name = "CURE_UNIT", columnDefinition = "VARCHAR2|治疗单位|100|", length = 100, nullable = true)
    private String cureUnit;

    @Column(name = "H_DAYS", columnDefinition = "VARCHAR2|H天数|20|", length = 20, nullable = true)
    private String hDays;

    @Column(name = "R_DAYS", columnDefinition = "VARCHAR2|R天数|20|", length = 20, nullable = true)
    private String rDays;

    @Column(name = "S_DAYS", columnDefinition = "VARCHAR2|S天数|20|", length = 20, nullable = true)
    private String sDays;

    @Column(name = "E_DAYS", columnDefinition = "VARCHAR2|E天数|20|", length = 20, nullable = true)
    private String eDays;

    @Column(name = "Z_DAYS", columnDefinition = "VARCHAR2|Z天数|20|", length = 20, nullable = true)
    private String zDays;
    
    @Column(name = "STOP_REASON", columnDefinition = "VARCHAR2|停止治疗原因|2|", length = 2, nullable = true)
    private String stopReason;

    @Column(name = "STOP_REASON_OTHER", columnDefinition = "VARCHAR2|停止治疗原因_其他|100|", length = 100, nullable = true)
    private String stopReasonOther;

    @Column(name = "STOP_REASON_DT", columnDefinition = "DATE|停止治疗日期||", nullable = true)
    private Date stopReasonDt;

    @Column(name = "MANAGE_TYPE", columnDefinition = "VARCHAR2|治疗管理方式|2|", length = 2, nullable = true)
    private String manageType;

    @Column(name = "SYS_MANAGE", columnDefinition = "VARCHAR2|系统管理|2|", length = 2, nullable = true)
    private String sysManage;

    @Column(name = "JUDGE_DOCTOR", columnDefinition = "VARCHAR2|判定医生|100|", length = 100, nullable = true)
    private String judgeDoctor;

    @Column(name = "JUDGE_DT", columnDefinition = "DATE|判定日期||", nullable = true)
    private Date judgeDt;

    @Column(name = "DISEASE_RECORD", columnDefinition = "CLOB|病程记录||", nullable = true)
    private String diseaseRecord;

    @Column(name = "THIS_DT", columnDefinition = "DATE|本次治疗日期||", nullable = true)
    private Date thisDt;

    @Column(name = "THIS_TYPE", columnDefinition = "VARCHAR2|治疗分类|2|", length = 2, nullable = true)
    private String thisType;

    @Column(name = "THIS_TYPE_1", columnDefinition = "VARCHAR2|治疗分类|2|", length = 2, nullable = true)
    private String thisType1;

    @Column(name = "THIS_TYPE_OTHER", columnDefinition = "VARCHAR2|治疗分类-其他|100|", length = 100, nullable = true)
    private String thisTypeOther;

    @Column(name = "THIS_FEES_TYPE", columnDefinition = "VARCHAR2|费用支付方式|2|", length = 2, nullable = true)
    private String thisFeesType;

    @Column(name = "THIS_MANAGE_TYPE", columnDefinition = "VARCHAR2|治疗管理方式|2|", length = 2, nullable = true)
    private String thisManageType;

    @Column(name = "CHANGE_TYPE", columnDefinition = "VARCHAR2|变更方式|100|", length = 100, nullable = true)
    private String changeType;

    @Column(name = "CHANGE_DT", columnDefinition = "DATE|变更日期||", nullable = true)
    private Date changeDt;

    @Column(name = "HIV", columnDefinition = "VARCHAR2|hiv|2|", length = 2, nullable = true)
    private String hiv;
    
    @Column(name = "HIV_START_DT", columnDefinition = "DATE|hiv开始日期||", nullable = true)
	private Date hivStartDt;
    
    @Column(name = "CPT", columnDefinition = "VARCHAR2|cpt|50|", length = 50, nullable = true)
    private String cpt;

    @Column(name = "CPT_START_DT", columnDefinition = "DATE|cpt开始日期||", nullable = true)
	private Date cptStartDt;
    
    @Column(name = "THIS_DOCTOR", columnDefinition = "VARCHAR2|治疗医生|50|", length = 50, nullable = true)
    private String thisDoctor;

    @Column(name = "RETREATMENT_DT", columnDefinition = "DATE|复治日期||", nullable = true)
    private Date retreatmentDt;

    @Column(name = "CHEMOTHERAPY", columnDefinition = "VARCHAR2|化疗方案|2|", length = 2, nullable = true)
    private String chemotherapy;

    @Column(name = "CHEMOTHERAPY_1", columnDefinition = "VARCHAR2|化疗方案1|2|", length = 2, nullable = true)
    private String chemotherapy1;

    @Column(name = "CHEMOTHERAPY_2", columnDefinition = "VARCHAR2|化疗方案2|2|", length = 2, nullable = true)
    private String chemotherapy2;

    @Column(name = "CHEMOTHERAPY_3", columnDefinition = "VARCHAR2|化疗方案3|2|", length = 2, nullable = true)
    private String chemotherapy3;

    @Column(name = "CHEMOTHERAPY_OTHER", columnDefinition = "VARCHAR2|化疗方案其他|50|", length = 50, nullable = true)
    private String chemotherapyOther;

    @Column(name = "ABATAMENT", columnDefinition = "VARCHAR2|减免比例|20|", length = 20, nullable = true)
    private String abatement;

    @Column(name = "CASE_SOURCE_OTHER", columnDefinition = "VARCHAR2|病例来源其他|50|", length = 50, nullable = true)
    private String caseSourceOther;

    @Column(name = "COMMENTS", columnDefinition = "VARCHAR2|备注|1000|", length = 1000, nullable = true)
    private String comments;

    @Column(name = "WHOLE_TREAT", columnDefinition = "VARCHAR2|全程足量正规治疗|2|", length = 2, nullable = true)
    private String wholeTreat;

    @Column(name = "DRUG_UNIT", columnDefinition = "VARCHAR2|药物单位|100|", length = 100, nullable = true)
    private String drugUnit;

    @Column(name = "DRUG_TOTAL", columnDefinition = "VARCHAR2|药物总量|20|", length = 20, nullable = true)
    private String drugTotal;

    @Column(name = "TREAT_DAYS", columnDefinition = "VARCHAR2|治疗时间|20|", length = 20, nullable = true)
    private String treatDays;

    @Column(name = "PRACTICAL_DAYS", columnDefinition = "VARCHAR2|实用天数|20|", length = 20, nullable = true)
    private String practicalDays;

    @Column(name = "PRACTICAL_NUM", columnDefinition = "VARCHAR2|实用剂数|20|", length = 20, nullable = true)
    private String practicalNum;

    @Column(name = "DRUG_PERCENT", columnDefinition = "VARCHAR2|占总计量比重|20|", length = 29, nullable = true)
    private String drugPercent;

    @Column(name = "DRUG_REACTION", columnDefinition = "VARCHAR2|药物副反应|100|", length = 100, nullable = true)
    private String drugReaction;

    @Column(name = "MENTAL_STATUS", columnDefinition = "VARCHAR2|精神状态|2|", length = 2, nullable = true)
    private String MentalStatus;

    @Column(name = "CLASSIFY_ACCORDING_LAST", columnDefinition = "VARCHAR2|晚血分型（复查后）|2|", length = 2, nullable = true)
    private String classifyAccordingLast;

    @Column(name = "CASE_TYPE_LAST", columnDefinition = "VARCHAR2|晚血病情分类（复查后）|2|", length = 2, nullable = true)
    private String caseTypeLast;

    @Column(name = "SALVATION_CONDITION", columnDefinition = "VARCHAR2|救助情况|100|", length = 100, nullable = true)
    private String salvationCondition;

    @Column(name = "TREAT_METHOD", columnDefinition = "VARCHAR2|治疗方法|200|", length = 200, nullable = true)
    private String treatMethod;

    @Column(name = "SUPERVISOR_USER", columnDefinition = "VARCHAR2|督导服药人|50|", length = 50, nullable = true)
    private String supervisorUser;

    @Column(name = "DRUG_NORM", columnDefinition = "VARCHAR2|药物规范性|2|", length = 2, nullable = true)
    private String drugNorm;

    @Column(name = "DRUG_OBJECT", columnDefinition = "VARCHAR2|是否应服对象|2|", length = 2, nullable = true)
    private String drugObject;

    @Column(name = "NO_OBJECT_RESULT", columnDefinition = "VARCHAR2|非对象原因|2|", length = 2, nullable = true)
    private String noObjectResult;

    @Column(name = "NO_OBJECT_OTHER", columnDefinition = "VARCHAR2|非对象原因其他|100|", length = 100, nullable = true)
    private String noObjectOther;

    @Column(name = "NO_WHOLE_RESULT", columnDefinition = "VARCHAR2|非全程原因|2|", length = 2, nullable = true)
    private String noWholeResult;

    @Column(name = "NO_WHOLE_OTHER", columnDefinition = "VARCHAR2|非全程原因其他|100|", length = 100, nullable = true)
    private String noWholeOther;

    @Column(name = "REST_OBJECT", columnDefinition = "VARCHAR2|休治对象|2|", length = 2, nullable = true)
    private String restObject;

    @Column(name = "VALID", columnDefinition = "VARCHAR2|药物是否有效|2|", length = 2, nullable = true)
    private String valid;
    
    @Column(name = "TRAVEL", columnDefinition = "VARCHAR2|自（病例）发病起前10天内是否去过外省或本省其他地市（区）旅行|50|", length = 50, nullable = true)
	private String travel;
	@Column(name = "TRPROVINCE_FIRST", columnDefinition = "VARCHAR2|旅行地点1:省|50|", length = 50, nullable = true)
	private String trprovinceFirst;
	@Column(name = "TRCITY_FIRST", columnDefinition = "VARCHAR2|旅行地点1:市|50|", length = 50, nullable = true)
	private String trcityFirst;
	@Column(name = "TRCOUNTY_FIRST", columnDefinition = "VARCHAR2|旅行地点1:县(区)|50|", length = 50, nullable = true)
	private String trcountyFirst;	
	@Column(name = "TRTOWNSHIP_FIRST", columnDefinition = "VARCHAR2|旅行地点1:乡(街道)|50|", length = 50, nullable = true)
	private String trtownShipFirst;
	@Column(name = "TRCATEGORY_FIRST", columnDefinition = "VARCHAR2|旅行地点1地址|200|", length = 200, nullable = true)
	private String trcategoryFirst;
	@Column(name = "TRPROVINCE_SECOND", columnDefinition = "VARCHAR2|旅行地点2:省|50|", length = 50, nullable = true)
	private String trprovinceSecond;
	@Column(name = "TRCITY_SECOND", columnDefinition = "VARCHAR2|旅行地点2:市|50|", length = 50, nullable = true)
	private String trcitySecond;
	@Column(name = "TRCOUNTY_SECOND", columnDefinition = "VARCHAR2|旅行地点2:县(区)|50|", length = 50, nullable = true)
	private String trcountySecond;	
	@Column(name = "TRTOWNSHIP_SECOND", columnDefinition = "VARCHAR2|旅行地点2:乡(街道)|50|", length = 50, nullable = true)
	private String trtownShipSecond;
	@Column(name = "TRCATEGORY_SECOND", columnDefinition = "VARCHAR2|旅行地点2地址|200|", length = 200, nullable = true)
	private String trcategorySecond;
	@Column(name = "TRPROVINCE_THIRD", columnDefinition = "VARCHAR2|旅行地点3:省|50|", length = 50, nullable = true)
	private String trprovinceThird;
	@Column(name = "TRCITY_THIRD", columnDefinition = "VARCHAR2|旅行地点3:市|50|", length = 50, nullable = true)
	private String trcityThird;
	@Column(name = "TRCOUNTY_THIRD", columnDefinition = "VARCHAR2|旅行地点3:县(区)|50|", length = 50, nullable = true)
	private String trcountyThird;	
	@Column(name = "TRTOWNSHIP_THIRD", columnDefinition = "VARCHAR2|旅行地点3:乡(街道)|50|", length = 50, nullable = true)
	private String trtownShipThird;
	@Column(name = "TRCATEGORY_THIRD", columnDefinition = "VARCHAR2|旅行地点3地址|200|", length = 200, nullable = true)
	private String trcategoryThird;


	@Column(name = "RESISTENCE_AGUE", columnDefinition = "VARCHAR2|抗疟药物试剂|2|", length = 2, nullable = true)
	private String resistenceAgue;
	@Column(name = "AGUE_IDEA", columnDefinition = "VARCHAR2|试剂方法|100|", length = 100, nullable = true)
	private String agueIdea;
	@Column(name = "AGUE_DRUGS", columnDefinition = "VARCHAR2|治疗药物名称|100|", length = 100, nullable = true)
	private String agueDrugs;
	@Column(name = "AGUE_ENOUGH", columnDefinition = "VARCHAR2|是否全程足量（正规）治疗|2|", length = 2, nullable = true)
	private String agueEnough;
	@Column(name = "IN_HOSPITAL", columnDefinition = "VARCHAR2|住院治疗|2|", length = 2, nullable = true)
	private String inHospital;


	//麻疹
	@Column(name = "MZ_ILL_KIND", columnDefinition = "VARCHAR2|检测病例分类|2|", length = 2, nullable = true)
	private String mzIllKind;
	@Column(name = "MZ_HOT", columnDefinition = "VARCHAR2|接种相关发热出疹|2|", length = 2, nullable = true)
	private String mzHot;
	@Column(name = "MZ_SOURCE", columnDefinition = "VARCHAR2|麻疹感染来源|20|", length = 2, nullable = true)
	private String mzSource;
	@Column(name = "MZ_BASIS", columnDefinition = "VARCHAR2|判断依据|100|", length = 100, nullable = true)
	private String mzBasis;
	//钩端螺旋体病
	@Column(name = "MODE_INFECTION_OTHER", columnDefinition = "VARCHAR2|可能感染方式-其他|50|", length = 50, nullable = true)
	private String modeInfectionOther;


	//脑炎
	@Column(name = "CASE_EPIDEMIC", columnDefinition = "VARCHAR2|病例疫情|2|", length = 2, nullable = true)
	private String caseEpidemic;

	@Column(name = "DEATH_PLACE", columnDefinition = "VARCHAR2|死亡地点|100|", length = 100, nullable = true)
	private String deathPlace;
	
	//霍乱
	@Column(name = "OUTHOS_BASIS", columnDefinition = "VARCHAR2|出院依据|20|", length = 20, nullable = true)
	private String outhosBasis;
	@Column(name = "OUTHOS_BASIS_OTHER", columnDefinition = "VARCHAR2|出院依据-其他|50|", length = 50,nullable = true)
	private String outhosBasisOther;
	@Column(name = "INFECTION_TYPE", columnDefinition = "VARCHAR2|感染类型|20|", length = 20, nullable = true)
	private String infectionType;
	//风疹
	@Column(name = "DIAGNOSE_ACCORDING", columnDefinition = "VARCHAR2|确诊病例依据|20|", length = 20, nullable = true)
	private String diagnoseAccording;
	
	public String getInfectionType() {
		return infectionType;
	}

	public void setInfectionType(String infectionType) {
		this.infectionType = infectionType;
	}

	public String getOuthosBasis() {
		return outhosBasis;
	}

	public void setOuthosBasis(String outhosBasis) {
		this.outhosBasis = outhosBasis;
	}

	public String getOuthosBasisOther() {
		return outhosBasisOther;
	}

	public void setOuthosBasisOther(String outhosBasisOther) {
		this.outhosBasisOther = outhosBasisOther;
	}

	public String getDeathPlace() {
		return deathPlace;
	}

	public void setDeathPlace(String deathPlace) {
		this.deathPlace = deathPlace;
	}

	public String getCaseEpidemic() {
		return caseEpidemic;
	}

	public void setCaseEpidemic(String caseEpidemic) {
		this.caseEpidemic = caseEpidemic;
	}

	public String getModeInfectionOther() {
		return modeInfectionOther;
	}

	public void setModeInfectionOther(String modeInfectionOther) {
		this.modeInfectionOther = modeInfectionOther;
	}

	public String getMzIllKind() {
		return mzIllKind;
	}

	public void setMzIllKind(String mzIllKind) {
		this.mzIllKind = mzIllKind;
	}

	public String getMzHot() {
		return mzHot;
	}

	public void setMzHot(String mzHot) {
		this.mzHot = mzHot;
	}

	public String getMzSource() {
		return mzSource;
	}

	public void setMzSource(String mzSource) {
		this.mzSource = mzSource;
	}

	public String getMzBasis() {
		return mzBasis;
	}

	public void setMzBasis(String mzBasis) {
		this.mzBasis = mzBasis;
	}

	public String getResistenceAgue() {
		return resistenceAgue;
	}

	public void setResistenceAgue(String resistenceAgue) {
		this.resistenceAgue = resistenceAgue;
	}

	public String getAgueIdea() {
		return agueIdea;
	}

	public void setAgueIdea(String agueIdea) {
		this.agueIdea = agueIdea;
	}

	public String getAgueDrugs() {
		return agueDrugs;
	}

	public void setAgueDrugs(String agueDrugs) {
		this.agueDrugs = agueDrugs;
	}

	public String getAgueEnough() {
		return agueEnough;
	}

	public void setAgueEnough(String agueEnough) {
		this.agueEnough = agueEnough;
	}

	public String getInHospital() {
		return inHospital;
	}

	public void setInHospital(String inHospital) {
		this.inHospital = inHospital;
	}

	@Column(name = "REMOVE_FROM_WORK", columnDefinition = "VARCHAR2|调离工作岗位|20|", length = 20, nullable = true)
	private String removeFromWork;
	
	public String getTravel() {
		return travel;
	}

	public String getRemoveFromWork() {
		return removeFromWork;
	}

	public void setRemoveFromWork(String removeFromWork) {
		this.removeFromWork = removeFromWork;
	}

	public void setTravel(String travel) {
		this.travel = travel;
	}

	public String getTrprovinceFirst() {
		return trprovinceFirst;
	}

	public void setTrprovinceFirst(String trprovinceFirst) {
		this.trprovinceFirst = trprovinceFirst;
	}

	public String getTrcityFirst() {
		return trcityFirst;
	}

	public void setTrcityFirst(String trcityFirst) {
		this.trcityFirst = trcityFirst;
	}

	public String getTrcountyFirst() {
		return trcountyFirst;
	}

	public void setTrcountyFirst(String trcountyFirst) {
		this.trcountyFirst = trcountyFirst;
	}

	public String getTrtownShipFirst() {
		return trtownShipFirst;
	}

	public void setTrtownShipFirst(String trtownShipFirst) {
		this.trtownShipFirst = trtownShipFirst;
	}

	public String getTrcategoryFirst() {
		return trcategoryFirst;
	}

	public void setTrcategoryFirst(String trcategoryFirst) {
		this.trcategoryFirst = trcategoryFirst;
	}

	public String getTrprovinceSecond() {
		return trprovinceSecond;
	}

	public void setTrprovinceSecond(String trprovinceSecond) {
		this.trprovinceSecond = trprovinceSecond;
	}

	public String getTrcitySecond() {
		return trcitySecond;
	}

	public void setTrcitySecond(String trcitySecond) {
		this.trcitySecond = trcitySecond;
	}

	public String getTrcountySecond() {
		return trcountySecond;
	}

	public void setTrcountySecond(String trcountySecond) {
		this.trcountySecond = trcountySecond;
	}

	public String getTrtownShipSecond() {
		return trtownShipSecond;
	}

	public void setTrtownShipSecond(String trtownShipSecond) {
		this.trtownShipSecond = trtownShipSecond;
	}

	public String getTrcategorySecond() {
		return trcategorySecond;
	}

	public void setTrcategorySecond(String trcategorySecond) {
		this.trcategorySecond = trcategorySecond;
	}

	public String getTrprovinceThird() {
		return trprovinceThird;
	}

	public void setTrprovinceThird(String trprovinceThird) {
		this.trprovinceThird = trprovinceThird;
	}

	public String getTrcityThird() {
		return trcityThird;
	}

	public void setTrcityThird(String trcityThird) {
		this.trcityThird = trcityThird;
	}

	public String getTrcountyThird() {
		return trcountyThird;
	}

	public void setTrcountyThird(String trcountyThird) {
		this.trcountyThird = trcountyThird;
	}

	public String getTrtownShipThird() {
		return trtownShipThird;
	}

	public void setTrtownShipThird(String trtownShipThird) {
		this.trtownShipThird = trtownShipThird;
	}

	public String getTrcategoryThird() {
		return trcategoryThird;
	}

	public void setTrcategoryThird(String trcategoryThird) {
		this.trcategoryThird = trcategoryThird;
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

	public String getSurveySummary() {
		return this.surveySummary;
	}

	public void setSurveySummary(String surveySummary) {
		this.surveySummary = surveySummary;
	}

	public String getSourcesInfection() {
		return this.sourcesInfection;
	}

	public void setSourcesInfection(String sourcesInfection) {
		this.sourcesInfection = sourcesInfection;
	}

	public String getRouteTransmission() {
		return this.routeTransmission;
	}

	public void setRouteTransmission(String routeTransmission) {
		this.routeTransmission = routeTransmission;
	}

	public String getControlMeasures() {
		return this.controlMeasures;
	}

	public void setControlMeasures(String controlMeasures) {
		this.controlMeasures = controlMeasures;
	}

	public String getOutcomeCode() {
		return this.outcomeCode;
	}

	public void setOutcomeCode(String outcomeCode) {
		this.outcomeCode = outcomeCode;
	}

	public String getHormonotherapyFlg() {
		return this.hormonotherapyFlg;
	}

	public void setHormonotherapyFlg(String hormonotherapyFlg) {
		this.hormonotherapyFlg = hormonotherapyFlg;
	}

	public String getAntibacterials() {
		return this.antibacterials;
	}

	public void setAntibacterials(String antibacterials) {
		this.antibacterials = antibacterials;
	}

	public String getAntibacterialsPertime() {
		return this.antibacterialsPertime;
	}

	public void setAntibacterialsPertime(String antibacterialsPertime) {
		this.antibacterialsPertime = antibacterialsPertime;
	}

	public String getAntibacterialsDay() {
		return this.antibacterialsDay;
	}

	public void setAntibacterialsDay(String antibacterialsDay) {
		this.antibacterialsDay = antibacterialsDay;
	}

	public Date getTherapyTime() {
		return this.therapyTime;
	}

	public void setTherapyTime(Date therapyTime) {
		this.therapyTime = therapyTime;
	}

	public Date getDeathTime() {
		return this.deathTime;
	}

	public void setDeathTime(Date deathTime) {
		this.deathTime = deathTime;
	}

	public String getDeathCause() {
		return this.deathCause;
	}

	public void setDeathCause(String deathCause) {
		this.deathCause = deathCause;
	}

	public String getCaseType() {
		return this.caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	public String getDocotrName() {
		return this.docotrName;
	}

	public void setDocotrName(String docotrName) {
		this.docotrName = docotrName;
	}

	public String getClinicalCase() {
		return this.clinicalCase;
	}

	public void setClinicalCase(String clinicalCase) {
		this.clinicalCase = clinicalCase;
	}

	public String getSourceInfection() {
		return this.sourceInfection;
	}

	public void setSourceInfection(String sourceInfection) {
		this.sourceInfection = sourceInfection;
	}

	public String getModeInfection() {
		return this.modeInfection;
	}

	public void setModeInfection(String modeInfection) {
		this.modeInfection = modeInfection;
	}

	public String getTreatmentMeasures() {
		return this.treatmentMeasures;
	}

	public void setTreatmentMeasures(String treatmentMeasures) {
		this.treatmentMeasures = treatmentMeasures;
	}

	public String getFirstCaseFlg() {
		return this.firstCaseFlg;
	}

	public void setFirstCaseFlg(String firstCaseFlg) {
		this.firstCaseFlg = firstCaseFlg;
	}

	public String getDengueCaseType() {
		return this.dengueCaseType;
	}

	public void setDengueCaseType(String dengueCaseType) {
		this.dengueCaseType = dengueCaseType;
	}

	public String getClassifyAccording() {
		return this.classifyAccording;
	}

	public void setClassifyAccording(String classifyAccording) {
		this.classifyAccording = classifyAccording;
	}

	public String getClassifyAccordingOther() {
		return this.classifyAccordingOther;
	}

	public void setClassifyAccordingOther(String classifyAccordingOther) {
		this.classifyAccordingOther = classifyAccordingOther;
	}

	public String getCureFlg() {
		return this.cureFlg;
	}

	public void setCureFlg(String cureFlg) {
		this.cureFlg = cureFlg;
	}

	public Date getCureDate() {
		return this.cureDate;
	}

	public void setCureDate(Date cureDate) {
		this.cureDate = cureDate;
	}

	public String getDeathFlg() {
		return this.deathFlg;
	}

	public void setDeathFlg(String deathFlg) {
		this.deathFlg = deathFlg;
	}

	public String getInpatientFlg() {
		return this.inpatientFlg;
	}

	public void setInpatientFlg(String inpatientFlg) {
		this.inpatientFlg = inpatientFlg;
	}

	public Date getInhosTime() {
		return this.inhosTime;
	}

	public void setInhosTime(Date inhosTime) {
		this.inhosTime = inhosTime;
	}

	public Date getOuthosDate() {
		return this.outhosDate;
	}

	public void setOuthosDate(Date outhosDate) {
		this.outhosDate = outhosDate;
	}

	public String getSupplyInvestigation() {
		return this.supplyInvestigation;
	}

	public void setSupplyInvestigation(String supplyInvestigation) {
		this.supplyInvestigation = supplyInvestigation;
	}

	public String getComplications() {
		return this.complications;
	}

	public void setComplications(String complications) {
		this.complications = complications;
	}

	public String getClinicalCaseExcludeName() {
		return this.clinicalCaseExcludeName;
	}

	public void setClinicalCaseExcludeName(String clinicalCaseExcludeName) {
		this.clinicalCaseExcludeName = clinicalCaseExcludeName;
	}

	public String getDiagnosisUnit() {
		return this.diagnosisUnit;
	}

	public void setDiagnosisUnit(String diagnosisUnit) {
		this.diagnosisUnit = diagnosisUnit;
	}

	public String getFinalDiagnosis() {
		return this.finalDiagnosis;
	}

	public void setFinalDiagnosis(String finalDiagnosis) {
		this.finalDiagnosis = finalDiagnosis;
	}

	public String getOutcomeCodeOther() {
		return this.outcomeCodeOther;
	}

	public void setOutcomeCodeOther(String outcomeCodeOther) {
		this.outcomeCodeOther = outcomeCodeOther;
	}

	public String getCaseSource() {
		return this.caseSource;
	}

	public void setCaseSource(String caseSource) {
		this.caseSource = caseSource;
	}

    public String getFeesType() {
        return this.feesType;
    }

    public void setFeesType(String feesType) {
        this.feesType = feesType;
    }

    public String getCureCondition() {
        return this.cureCondition;
    }

    public void setCureCondition(String cureCondition) {
        this.cureCondition = cureCondition;
    }

    public String getCureUnit() {
        return this.cureUnit;
    }

    public void setCureUnit(String cureUnit) {
        this.cureUnit = cureUnit;
    }

    public String getStopReason() {
        return this.stopReason;
    }

    public void setStopReason(String stopReason) {
        this.stopReason = stopReason;
    }

    public String getStopReasonOther() {
        return this.stopReasonOther;
    }

    public void setStopReasonOther(String stopReasonOther) {
        this.stopReasonOther = stopReasonOther;
    }

    public Date getStopReasonDt() {
        return this.stopReasonDt;
    }

    public void setStopReasonDt(Date stopReasonDt) {
        this.stopReasonDt = stopReasonDt;
    }

    public String getManageType() {
        return this.manageType;
    }

    public void setManageType(String manageType) {
        this.manageType = manageType;
    }

    public String getSysManage() {
        return this.sysManage;
    }

    public void setSysManage(String sysManage) {
        this.sysManage = sysManage;
    }

    public String getJudgeDoctor() {
        return this.judgeDoctor;
    }

    public void setJudgeDoctor(String judgeDoctor) {
        this.judgeDoctor = judgeDoctor;
    }

    public Date getJudgeDt() {
        return this.judgeDt;
    }

    public void setJudgeDt(Date judgeDt) {
        this.judgeDt = judgeDt;
    }

    public String getDiseaseRecord() {
        return this.diseaseRecord;
    }

    public void setDiseaseRecord(String diseaseRecord) {
        this.diseaseRecord = diseaseRecord;
    }

    public Date getThisDt() {
        return this.thisDt;
    }

    public void setThisDt(Date thisDt) {
        this.thisDt = thisDt;
    }

    public String getThisType() {
        return this.thisType;
    }

    public void setThisType(String thisType) {
        this.thisType = thisType;
    }

    public String getThisType1() {
        return this.thisType1;
    }

    public void setThisType1(String thisType1) {
        this.thisType1 = thisType1;
    }

    public String getThisTypeOther() {
        return this.thisTypeOther;
    }

    public void setThisTypeOther(String thisTypeOther) {
        this.thisTypeOther = thisTypeOther;
    }

    public String getThisFeesType() {
        return this.thisFeesType;
    }

    public void setThisFeesType(String thisFeesType) {
        this.thisFeesType = thisFeesType;
    }

    public String getThisManageType() {
        return this.thisManageType;
    }

    public void setThisManageType(String thisManageType) {
        this.thisManageType = thisManageType;
    }

    public String getChangeType() {
        return this.changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public Date getChangeDt() {
        return this.changeDt;
    }

    public void setChangeDt(Date changeDt) {
        this.changeDt = changeDt;
    }

    public String getHiv() {
        return this.hiv;
    }

    public void setHiv(String hiv) {
        this.hiv = hiv;
    }

    public String getCpt() {
        return this.cpt;
    }

    public void setCpt(String cpt) {
        this.cpt = cpt;
    }

    public String getThisDoctor() {
        return this.thisDoctor;
    }

    public void setThisDoctor(String thisDoctor) {
        this.thisDoctor = thisDoctor;
    }

    public Date getRetreatmentDt() {
        return this.retreatmentDt;
    }

    public void setRetreatmentDt(Date retreatmentDt) {
        this.retreatmentDt = retreatmentDt;
    }

    public String getChemotherapy() {
        return this.chemotherapy;
    }

    public void setChemotherapy(String chemotherapy) {
        this.chemotherapy = chemotherapy;
    }

    public String getChemotherapy1() {
        return this.chemotherapy1;
    }

    public void setChemotherapy1(String chemotherapy1) {
        this.chemotherapy1 = chemotherapy1;
    }

    public String getChemotherapy2() {
        return this.chemotherapy2;
    }

    public void setChemotherapy2(String chemotherapy2) {
        this.chemotherapy2 = chemotherapy2;
    }

    public String getChemotherapy3() {
        return this.chemotherapy3;
    }

    public void setChemotherapy3(String chemotherapy3) {
        this.chemotherapy3 = chemotherapy3;
    }

    public String getChemotherapyOther() {
        return this.chemotherapyOther;
    }

    public void setChemotherapyOther(String chemotherapyOther) {
        this.chemotherapyOther = chemotherapyOther;
    }

    public String getAbatement() {
        return this.abatement;
    }

    public void setAbatement(String abatement) {
        this.abatement = abatement;
    }

    public String getCaseSourceOther() {
        return this.caseSourceOther;
    }

    public void setCaseSourceOther(String caseSourceOther) {
        this.caseSourceOther = caseSourceOther;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getWholeTreat() {
        return this.wholeTreat;
    }

    public void setWholeTreat(String wholeTreat) {
        this.wholeTreat = wholeTreat;
    }

    public String getDrugUnit() {
        return this.drugUnit;
    }

    public void setDrugUnit(String drugUnit) {
        this.drugUnit = drugUnit;
    }

    public String getDrugTotal() {
        return this.drugTotal;
    }

    public void setDrugTotal(String drugTotal) {
        this.drugTotal = drugTotal;
    }

    public String getTreatDays() {
        return this.treatDays;
    }

    public void setTreatDays(String treatDays) {
        this.treatDays = treatDays;
    }

    public String getPracticalDays() {
        return this.practicalDays;
    }

    public void setPracticalDays(String practicalDays) {
        this.practicalDays = practicalDays;
    }

    public String getPracticalNum() {
        return this.practicalNum;
    }

    public void setPracticalNum(String practicalNum) {
        this.practicalNum = practicalNum;
    }

    public String getDrugPercent() {
        return this.drugPercent;
    }

    public void setDrugPercent(String drugPercent) {
        this.drugPercent = drugPercent;
    }

    public String getDrugReaction() {
        return this.drugReaction;
    }

    public void setDrugReaction(String drugReaction) {
        this.drugReaction = drugReaction;
    }

    public String getMentalStatus() {
        return this.MentalStatus;
    }

    public void setMentalStatus(String MentalStatus) {
        this.MentalStatus = MentalStatus;
    }

    public String getClassifyAccordingLast() {
        return this.classifyAccordingLast;
    }

    public void setClassifyAccordingLast(String classifyAccordingLast) {
        this.classifyAccordingLast = classifyAccordingLast;
    }

    public String getCaseTypeLast() {
        return this.caseTypeLast;
    }

    public void setCaseTypeLast(String caseTypeLast) {
        this.caseTypeLast = caseTypeLast;
    }

    public String getSalvationCondition() {
        return this.salvationCondition;
    }

    public void setSalvationCondition(String salvationCondition) {
        this.salvationCondition = salvationCondition;
    }

    public String getTreatMethod() {
        return this.treatMethod;
    }

    public void setTreatMethod(String treatMethod) {
        this.treatMethod = treatMethod;
    }

    public String getSupervisorUser() {
        return this.supervisorUser;
    }

    public void setSupervisorUser(String supervisorUser) {
        this.supervisorUser = supervisorUser;
    }

    public String getDrugNorm() {
        return this.drugNorm;
    }

    public void setDrugNorm(String drugNorm) {
        this.drugNorm = drugNorm;
    }

    public String getDrugObject() {
        return this.drugObject;
    }

    public void setDrugObject(String drugObject) {
        this.drugObject = drugObject;
    }

    public String getNoObjectResult() {
        return this.noObjectResult;
    }

    public void setNoObjectResult(String noObjectResult) {
        this.noObjectResult = noObjectResult;
    }

    public String getNoObjectOther() {
        return this.noObjectOther;
    }

    public void setNoObjectOther(String noObjectOther) {
        this.noObjectOther = noObjectOther;
    }

    public String getNoWholeResult() {
        return this.noWholeResult;
    }

    public void setNoWholeResult(String noWholeResult) {
        this.noWholeResult = noWholeResult;
    }

    public String getNoWholeOther() {
        return this.noWholeOther;
    }

    public void setNoWholeOther(String noWholeOther) {
        this.noWholeOther = noWholeOther;
    }

    public String getRestObject() {
        return this.restObject;
    }

    public void setRestObject(String restObject) {
        this.restObject = restObject;
    }

	public String gethDays() {
		return hDays;
	}

	public void sethDays(String hDays) {
		this.hDays = hDays;
	}

	public String getrDays() {
		return rDays;
	}

	public void setrDays(String rDays) {
		this.rDays = rDays;
	}

	public String getsDays() {
		return sDays;
	}

	public void setsDays(String sDays) {
		this.sDays = sDays;
	}

	public String geteDays() {
		return eDays;
	}

	public void seteDays(String eDays) {
		this.eDays = eDays;
	}

	public String getzDays() {
		return zDays;
	}

	public void setzDays(String zDays) {
		this.zDays = zDays;
	}

	/**
	 * @return the valid
	 */
	public String getValid() {
		return valid;
	}

	/**
	 * @param valid the valid to set
	 */
	public void setValid(String valid) {
		this.valid = valid;
	}

	public Date getHivStartDt() {
		return hivStartDt;
	}

	public void setHivStartDt(Date hivStartDt) {
		this.hivStartDt = hivStartDt;
	}

	public Date getCptStartDt() {
		return cptStartDt;
	}

	public void setCptStartDt(Date cptStartDt) {
		this.cptStartDt = cptStartDt;
	}

	public String getDiagnoseAccording() {
		return diagnoseAccording;
	}

	public void setDiagnoseAccording(String diagnoseAccording) {
		this.diagnoseAccording = diagnoseAccording;
	}
	
}
