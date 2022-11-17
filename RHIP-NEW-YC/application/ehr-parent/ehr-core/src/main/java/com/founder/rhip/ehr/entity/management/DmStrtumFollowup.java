package com.founder.rhip.ehr.entity.management;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "DM_STRTUM_FOLLOWUP")
public class DmStrtumFollowup implements Serializable {

	private static final long serialVersionUID = -8260112637337608061L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;

	@Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
	private String ehrId;

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|个人信息唯一编号||", length = 11, nullable = true)
	private Long personId;

	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|居民身份证/健康卡号||", length = 18, nullable = true)
	private String idcard;

	@Column(name = "VISIT_WAY_CODE", columnDefinition = "VARCHAR2|随访方式代码||", length = 1, nullable = true)
	private String visitWayCode;

	@Column(name = "POSITIVE_SIGNS", columnDefinition = "VARCHAR|体格检查阳性体征||", length = 300, nullable = true)
	private String  positiveSigns;

	@Column(name = "ASSAY", columnDefinition = "VARCHAR|化验||", length = 300, nullable = true)
	private String  assay;

	@Column(name = "ECG", columnDefinition = "VARCHAR|心电图||", length = 300, nullable = true)
	private String ecg;

	@Column(name = "SPECIAL_EXAM", columnDefinition = "VARCHAR|特殊检查||", length = 300, nullable = true)
	private String specialExam;

	@Column(name = "OTHER_STATUS", columnDefinition = "VARCHAR|其他状况||", length = 300, nullable = true)
	private String otherStatus;

	@Column(name = "SMOKING", columnDefinition = "VARCHAR2|吸烟量与以前相比?||",length = 2, nullable = true)
	private String smoking;

	@Column(name = "DRINKING", columnDefinition = "VARCHAR2|饮酒量与以前相比||",length =2, nullable = true)
	private String drinking;

	@Column(name = "MEAT", columnDefinition = "VARCHAR2|肉类较以前摄入||",length = 2, nullable = true)
	private String meat;

	@Column(name = "PRODUCE", columnDefinition = "VARCHAR2|蔬菜水果较以前摄入||",length = 2, nullable = true)
	private String produce;

	@Column(name = "PHYSICAL_ACTIVITY", columnDefinition = "VARCHAR2|体力活动较以前||",length = 2, nullable = true)
	private String physicalActivity;

	@Column(name = "ECG_TIMES", columnDefinition = "VARCHAR2|测心电图次数||",length = 2, nullable = true)
	private String ecgTimes;

	@Column(name = "BLOOD_TIMES", columnDefinition = "VARCHAR2|测血生化指标次数||",length = 2, nullable = true)
	private String bloodTimes;

	@Column(name = "DRUG_PAYMENTS", columnDefinition = "VARCHAR2|月平均药费支出（元）||",length = 2, nullable = true)
	private String drugPayments;

	@Column(name = "NON_DRUGS", columnDefinition = "VARCHAR|非药物治疗措施||", length = 20, nullable = true)
	private String nonDrugs;
	
	@Column(name = "NON_DRUGS_OTHER", columnDefinition = "VARCHAR|非药物治疗措施其它||", length = 300, nullable = true)
	private String nonDrugsOther;

	@Column(name = "HEDUCATION", columnDefinition = "VARCHAR|针对性健康教育||", length = 300, nullable = true)
	private String heducation;

	@Column(name = "CONCLUSION", columnDefinition = "SMALLINT|结论||", length = 2,nullable = true)
	private String conclusion;

	@Column(name = "AFFIRM_PERSON", columnDefinition = "VARCHAR|确认人||", length = 20, nullable = true)
	private String affirmPerson;

	@Column(name = "CONDITION", columnDefinition = "VARCHAR|病情（常规）||", length = 300, nullable = true)
	private String condition;

	@Column(name = "TREATMENT", columnDefinition = "VARCHAR|治疗（常规）||", length = 300, nullable = true)
	private String treatment;

	@Column(name = "FOLLOWUP_FLAG", columnDefinition = "VARCHAR2|随访类型标识||", length = 1, nullable = true)
	private String followupFlag;

	@Column(name = "DISEASE_TYPE", columnDefinition = "VARCHAR2|疾病类型||", length = 1, nullable = true)
	private String diseaseType;

	@Column(name = "HEIGHT", columnDefinition = "DECIMAL|身高(cm)||", length = 5, scale = 1, nullable = true)
	private BigDecimal height;

	@Column(name = "BODY_WEIGHT", columnDefinition = "DECIMAL|体重(kg)||", length = 5, scale = 1, nullable = true)
	private BigDecimal bodyWeight;

	@Column(name = "WAOSTLINE", columnDefinition = "DECIMAL|腰围(cm)||", length = 5, scale = 1, nullable = true)
	private BigDecimal waostline;

	@Column(name = "BP_EXAM_FLAG", columnDefinition = "VARCHAR2|血压检测标志||", length = 1, nullable = true)
	private String bpExamFlag;

	@Column(name = "SBP", columnDefinition = "NUMNER|收缩压(mmHg)||",length =4, nullable = true)
	private Integer sbp;

	@Column(name = "DBP", columnDefinition = "NUMNER|舒张压(mmHg)||",length = 4, nullable = true)
	private Integer dbp;

	@Column(name = "BLOOD_GLUCOSE_FALG", columnDefinition = "VARCHAR2|血糖检测标志||", length = 1, nullable = true)
	private String bloodGlucoseFalg;

	@Column(name = "FPG", columnDefinition = "NUMNER|空腹血糖值(mmol/L)||",length = 5,scale = 2, nullable = true)
	private BigDecimal fpg;

	@Column(name = "GLU_VALUE", columnDefinition = "NUMNER|餐后2小时血糖值(mmol/L)||", length = 5,scale = 2, nullable = true)
	private BigDecimal gluValue;

	@Column(name = "HGB", columnDefinition = "NUMNER|糖化血红蛋白值(%)||",length = 5,scale = 2, nullable = true)
	private BigDecimal hgb;

	@Column(name = "BLOOD_FAT", columnDefinition = "VARCHAR2|血脂检测||", length = 1, nullable = true)
	private String bloodFat;

	@Column(name = "TC", columnDefinition = "DECIMAL|总胆固醇值(mmol／L)||", length = 5, scale = 2, nullable = true)
	private BigDecimal tc;

	@Column(name = "TRIGLYCERIDE_VALUE", columnDefinition = "DECIMAL|甘油三酯值(mmol/L)||", length = 3, scale = 1, nullable = true)
	private BigDecimal triglycerideValue;

	@Column(name = "LDLC_DETECT_VALUE", columnDefinition = "DECIMAL|血清低密度脂蛋白胆固醇检测值(mmol/L)||", length = 5, scale = 2, nullable = true)
	private BigDecimal ldlcDetectValue;

	@Column(name = "HDLC_DETECT_VALUE", columnDefinition = "DECIMAL|血清高密度脂蛋自胆固醇检测值(mmol/L)||", length = 5, scale = 2, nullable = true)
	private BigDecimal hdlcDetectValue;

	@Column(name = "BP_DRUG_FLAG", columnDefinition = "VARCHAR2|血压用药标志||", length = 1, nullable = true)
	private String bpDrugFlag;

	@Column(name = "BP_DRUG_CODE_FIRST", columnDefinition = "VARCHAR2|第一种药物编码||", length = 12, nullable = true)
	private String bpDrugCodeFirst;

	@Column(name = "BP_DRUG_NAME_FIRST", columnDefinition = "VARCHAR2|第一种药物名称||", length = 50, nullable = true)
	private String bpDrugNameFirst;

	@Column(name = "BP_DRUG_METHOD_FIRST", columnDefinition = "VARCHAR2|第一种药物使用方法||", length = 100, nullable = true)
	private String bpDrugMethodFirst;

	@Column(name = "BP_DRUG_CODE_SECOND", columnDefinition = "VARCHAR2|第二种药物编码||", length = 12, nullable = true)
	private String bpDrugCodeSecond;

	@Column(name = "BP_DRUG_NAME_SECOND", columnDefinition = "VARCHAR2|第二种药物名称||", length = 50, nullable = true)
	private String bpDrugNameSecond;

	@Column(name = "BP_DRUG_METHOD_SECOND", columnDefinition = "VARCHAR2|第二种药物使用方法||", length = 100, nullable = true)
	private String bpDrugMethodSecond;

	@Column(name = "BP_DRUG_CODE_THIRD", columnDefinition = "VARCHAR2|第三种药物编码||", length = 12, nullable = true)
	private String bpDrugCodeThird;

	@Column(name = "BP_DRUG_NAME_THIRD", columnDefinition = "VARCHAR2|第三种药物名称||", length = 50, nullable = true)
	private String bpDrugNameThird;

	@Column(name = "BP_DRUG_METHOD_THIRD", columnDefinition = "VARCHAR2|第三种药物使用方法||", length = 100, nullable = true)
	private String bpDrugMethodThird;
	
	@Column(name = "BP_DRUG_NO_REGULAR_REASON", columnDefinition = "VARCHAR2|为规律用药原因||", length = 2, nullable = true)
	private String bpDrugNoRegularReason ;

	@Column(name = "BG_DRUG_FLAG", columnDefinition = "VARCHAR2|血糖用药标志||", length = 1, nullable = true)
	private String bgDrugFlag;

	@Column(name = "BG_DRUG_CODE_FIRST", columnDefinition = "VARCHAR2|第一种药物编码||", length = 12, nullable = true)
	private String bgDrugCodeFirst;

	@Column(name = "BG_DRUG_NAME_FIRST", columnDefinition = "VARCHAR2|第一种药物名称||", length = 50, nullable = true)
	private String bgDrugNameFirst;

	@Column(name = "BG_DRUG_METHOD_FIRST", columnDefinition = "VARCHAR2|第一种药物使用方法||", length = 100, nullable = true)
	private String bgDrugMethodFirst;

	@Column(name = "BG_DRUG_CODE_SECOND", columnDefinition = "VARCHAR2|第二种药物编码||", length = 12, nullable = true)
	private String bgDrugCodeSecond;

	@Column(name = "BG_DRUG_NAME_SECOND", columnDefinition = "VARCHAR2|第二种药物名称||", length = 50, nullable = true)
	private String bgDrugNameSecond;

	@Column(name = "BG_DRUG_METHOD_SECOND", columnDefinition = "VARCHAR2|第二种药物使用方法||", length = 100, nullable = true)
	private String bgDrugMethodSecond;

	@Column(name = "BG_DRUG_CODE_THIRD", columnDefinition = "VARCHAR2|第三种药物编码||", length = 12, nullable = true)
	private String bgDrugCodeThird;

	@Column(name = "BG_DRUG_NAME_THIRD", columnDefinition = "VARCHAR2|第三种药物名称||", length = 50, nullable = true)
	private String bgDrugNameThird;

	@Column(name = "BG_DRUG_METHOD_THIRD", columnDefinition = "VARCHAR2|第三种药物使用方法||", length = 100, nullable = true)
	private String bgDrugMethodThird;
	
	@Column(name = "BG_DRUG_NO_REGULAR_REASON", columnDefinition = "VARCHAR2|为规律用药原因||", length = 2, nullable = true)
	private String bgDrugNoRegularReason ;

	@Column(name = "BF_DRUG_FLAG", columnDefinition = "VARCHAR2|血脂用药||", length = 1, nullable = true)
	private String bfDrugFlag;

	@Column(name = "BF_DRUG_CODE_FIRST", columnDefinition = "VARCHAR2|第一种药物编码||", length = 12, nullable = true)
	private String bfDrugCodeFirst;

	@Column(name = "BF_DRUG_NAME_FIRST", columnDefinition = "VARCHAR2|第一种药物名称||", length = 50, nullable = true)
	private String bfDrugNameFirst;

	@Column(name = "BF_DRUG_METHOD_FIRST", columnDefinition = "VARCHAR2|第一种药物使用方法||", length = 100, nullable = true)
	private String bfDrugMethodFirst;

	@Column(name = "BF_DRUG_CODE_SECOND", columnDefinition = "VARCHAR2|第二种药物编码||", length = 12, nullable = true)
	private String bfDrugCodeSecond;

	@Column(name = "BF_DRUG_NAME_SECOND", columnDefinition = "VARCHAR2|第二种药物名称||", length = 50, nullable = true)
	private String bfDrugNameSecond;

	@Column(name = "BF_DRUG_METHOD_SECOND", columnDefinition = "VARCHAR2|第二种药物使用方法||", length = 100, nullable = true)
	private String bfDrugMethodSecond;

	@Column(name = "BF_DRUG_CODE_THIRD", columnDefinition = "VARCHAR2|第三种药物编码||", length = 12, nullable = true)
	private String bfDrugCodeThird;

	@Column(name = "BF_DRUG_NAME_THIRD", columnDefinition = "VARCHAR2|第三种药物名称||", length = 50, nullable = true)
	private String bfDrugNameThird;

	@Column(name = "BF_DRUG_METHOD_THIRD", columnDefinition = "VARCHAR2|第三种药物使用方法||", length = 100, nullable = true)
	private String bfDrugMethodThird;
	
	@Column(name = "BF_DRUG_NO_REGULAR_REASON", columnDefinition = "VARCHAR2|为规律用药原因||", length = 2, nullable = true)
	private String bfDrugNoRegularReason ;

	@Column(name = "VISIT_DATE", columnDefinition = "DATE|本次随访日期||", nullable = true)
	private Date visitDate;

	@Column(name = "NEXT_VISIT_DATE", columnDefinition = "DATE|下次随访日期||", nullable = true)
	private Date nextVisitDate;

	@Column(name = "VISIT_ORGAN_CODE", columnDefinition = "VARCHAR2|随访机构编码||", length = 15, nullable = true)
	private String visitOrganCode;

	@Column(name = "VISIT_ORGAN_NAME", columnDefinition = "VARCHAR2|随访机构名称||", length = 70, nullable = true)
	private String visitOrganName;

	@Column(name = "VISIT_IDCARD", columnDefinition = "VARCHAR2|随访人身份证号||", length = 18, nullable = true)
	private String visitIdcard;

	@Column(name = "VISIT_NAME", columnDefinition = "VARCHAR2|随访人姓名||", length = 50, nullable = true)
	private String visitName;

	@Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 70, nullable = true)
	private String createOrganName;

	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构编码||", length = 50, nullable = true)
	private String createOrganCode;

	@Column(name = "CREATE_DOCTOR_NAME", columnDefinition = "VARCHAR2|填报人姓名||", length = 50, nullable = true)
	private String createDoctorName;

	@Column(name = "CREATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|填报人编码||", length = 18, nullable = true)
	private String createDoctorCode;

	@Column(name = "CREATE_DATE", columnDefinition = "TIMESTAMP|填报时间||", nullable = true)
	private Date createDate;

	@Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|更新机构编码||", length = 50, nullable = true)
	private String updateOrganCode;

	@Column(name = "UPDATE_ORGAN_NAME", columnDefinition = "VARCHAR2|更新机构名称||", length = 70, nullable = true)
	private String updateOrganName;

	@Column(name = "UPDATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|更新人编码||", length = 18, nullable = true)
	private String updateDoctorCode;

	@Column(name = "UPDATE_DOCTOR_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 50, nullable = true)
	private String updateDoctorName;

	@Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP|更新日期和时间||", nullable = true)
	private Date updateDate;

	@Column(name = "IS_DELETE", columnDefinition = "INT|删除状态||", nullable = true)
	private Integer isDelete;

	@Column(name = "COMMENTS", columnDefinition = "VARCHAR2|备注||", length = 1000, nullable = true)
	private String comments;

	@Transient
	private Long planId;

    @Transient
    private String[] nonDrugsArray;
	
    @Transient
    private String planType;
    
	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String[] getNonDrugsArray() {
        return nonDrugsArray;
    }

    public void setNonDrugsArray(String[] nonDrugsArray) {
        this.nonDrugsArray = nonDrugsArray;
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

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getVisitWayCode() {
		return visitWayCode;
	}

	public void setVisitWayCode(String visitWayCode) {
		this.visitWayCode = visitWayCode;
	}

	public String getPositiveSigns() {
		return positiveSigns;
	}

	public void setPositiveSigns(String positiveSigns) {
		this.positiveSigns = positiveSigns;
	}

	public String getAssay() {
		return assay;
	}

	public void setAssay(String assay) {
		this.assay = assay;
	}

	public String getEcg() {
		return ecg;
	}

	public void setEcg(String ecg) {
		this.ecg = ecg;
	}

	public String getSpecialExam() {
		return specialExam;
	}

	public void setSpecialExam(String specialExam) {
		this.specialExam = specialExam;
	}

	public String getOtherStatus() {
		return otherStatus;
	}

	public void setOtherStatus(String otherStatus) {
		this.otherStatus = otherStatus;
	}


	public String getNonDrugs() {
		return nonDrugs;
	}

	public void setNonDrugs(String nonDrugs) {
		this.nonDrugs = nonDrugs;
	}

	public String getHeducation() {
		return heducation;
	}

	public void setHeducation(String heducation) {
		this.heducation = heducation;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public String getAffirmPerson() {
		return affirmPerson;
	}

	public void setAffirmPerson(String affirmPerson) {
		this.affirmPerson = affirmPerson;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getFollowupFlag() {
		return followupFlag;
	}

	public void setFollowupFlag(String followupFlag) {
		this.followupFlag = followupFlag;
	}

	public String getDiseaseType() {
		return diseaseType;
	}

	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
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

	public String getBpExamFlag() {
		return bpExamFlag;
	}

	public void setBpExamFlag(String bpExamFlag) {
		this.bpExamFlag = bpExamFlag;
	}

	public Integer getSbp() {
		return sbp;
	}

	public void setSbp(Integer sbp) {
		this.sbp = sbp;
	}

	public Integer getDbp() {
		return dbp;
	}

	public void setDbp(Integer dbp) {
		this.dbp = dbp;
	}


	public BigDecimal getFpg() {
		return fpg;
	}

	public void setFpg(BigDecimal fpg) {
		this.fpg = fpg;
	}

	public BigDecimal getGluValue() {
		return gluValue;
	}

	public void setGluValue(BigDecimal gluValue) {
		this.gluValue = gluValue;
	}

	public BigDecimal getHgb() {
		return hgb;
	}

	public void setHgb(BigDecimal hgb) {
		this.hgb = hgb;
	}

	public String getBloodFat() {
		return bloodFat;
	}

	public void setBloodFat(String bloodFat) {
		this.bloodFat = bloodFat;
	}

	public BigDecimal getTc() {
		return tc;
	}

	public void setTc(BigDecimal tc) {
		this.tc = tc;
	}

	public BigDecimal getTriglycerideValue() {
		return triglycerideValue;
	}

	public void setTriglycerideValue(BigDecimal triglycerideValue) {
		this.triglycerideValue = triglycerideValue;
	}

	public BigDecimal getLdlcDetectValue() {
		return ldlcDetectValue;
	}

	public void setLdlcDetectValue(BigDecimal ldlcDetectValue) {
		this.ldlcDetectValue = ldlcDetectValue;
	}

	public BigDecimal getHdlcDetectValue() {
		return hdlcDetectValue;
	}

	public void setHdlcDetectValue(BigDecimal hdlcDetectValue) {
		this.hdlcDetectValue = hdlcDetectValue;
	}

	public String getBpDrugFlag() {
		return bpDrugFlag;
	}

	public void setBpDrugFlag(String bpDrugFlag) {
		this.bpDrugFlag = bpDrugFlag;
	}

	public String getBpDrugCodeFirst() {
		return bpDrugCodeFirst;
	}

	public void setBpDrugCodeFirst(String bpDrugCodeFirst) {
		this.bpDrugCodeFirst = bpDrugCodeFirst;
	}

	public String getBpDrugNameFirst() {
		return bpDrugNameFirst;
	}

	public void setBpDrugNameFirst(String bpDrugNameFirst) {
		this.bpDrugNameFirst = bpDrugNameFirst;
	}

	public String getBpDrugMethodFirst() {
		return bpDrugMethodFirst;
	}

	public void setBpDrugMethodFirst(String bpDrugMethodFirst) {
		this.bpDrugMethodFirst = bpDrugMethodFirst;
	}

	public String getBpDrugCodeSecond() {
		return bpDrugCodeSecond;
	}

	public void setBpDrugCodeSecond(String bpDrugCodeSecond) {
		this.bpDrugCodeSecond = bpDrugCodeSecond;
	}

	public String getBpDrugNameSecond() {
		return bpDrugNameSecond;
	}

	public void setBpDrugNameSecond(String bpDrugNameSecond) {
		this.bpDrugNameSecond = bpDrugNameSecond;
	}

	public String getBpDrugMethodSecond() {
		return bpDrugMethodSecond;
	}

	public void setBpDrugMethodSecond(String bpDrugMethodSecond) {
		this.bpDrugMethodSecond = bpDrugMethodSecond;
	}

	public String getBpDrugCodeThird() {
		return bpDrugCodeThird;
	}

	public void setBpDrugCodeThird(String bpDrugCodeThird) {
		this.bpDrugCodeThird = bpDrugCodeThird;
	}

	public String getBpDrugNameThird() {
		return bpDrugNameThird;
	}

	public void setBpDrugNameThird(String bpDrugNameThird) {
		this.bpDrugNameThird = bpDrugNameThird;
	}

	public String getBpDrugMethodThird() {
		return bpDrugMethodThird;
	}

	public void setBpDrugMethodThird(String bpDrugMethodThird) {
		this.bpDrugMethodThird = bpDrugMethodThird;
	}

	public String getBgDrugFlag() {
		return bgDrugFlag;
	}

	public void setBgDrugFlag(String bgDrugFlag) {
		this.bgDrugFlag = bgDrugFlag;
	}

	public String getBgDrugCodeFirst() {
		return bgDrugCodeFirst;
	}

	public void setBgDrugCodeFirst(String bgDrugCodeFirst) {
		this.bgDrugCodeFirst = bgDrugCodeFirst;
	}

	public String getBgDrugNameFirst() {
		return bgDrugNameFirst;
	}

	public void setBgDrugNameFirst(String bgDrugNameFirst) {
		this.bgDrugNameFirst = bgDrugNameFirst;
	}

	public String getBgDrugMethodFirst() {
		return bgDrugMethodFirst;
	}

	public void setBgDrugMethodFirst(String bgDrugMethodFirst) {
		this.bgDrugMethodFirst = bgDrugMethodFirst;
	}

	public String getBgDrugCodeSecond() {
		return bgDrugCodeSecond;
	}

	public void setBgDrugCodeSecond(String bgDrugCodeSecond) {
		this.bgDrugCodeSecond = bgDrugCodeSecond;
	}

	public String getBgDrugNameSecond() {
		return bgDrugNameSecond;
	}

	public void setBgDrugNameSecond(String bgDrugNameSecond) {
		this.bgDrugNameSecond = bgDrugNameSecond;
	}

	public String getBgDrugMethodSecond() {
		return bgDrugMethodSecond;
	}

	public void setBgDrugMethodSecond(String bgDrugMethodSecond) {
		this.bgDrugMethodSecond = bgDrugMethodSecond;
	}

	public String getBgDrugCodeThird() {
		return bgDrugCodeThird;
	}

	public void setBgDrugCodeThird(String bgDrugCodeThird) {
		this.bgDrugCodeThird = bgDrugCodeThird;
	}

	public String getBgDrugNameThird() {
		return bgDrugNameThird;
	}

	public void setBgDrugNameThird(String bgDrugNameThird) {
		this.bgDrugNameThird = bgDrugNameThird;
	}

	public String getBgDrugMethodThird() {
		return bgDrugMethodThird;
	}

	public void setBgDrugMethodThird(String bgDrugMethodThird) {
		this.bgDrugMethodThird = bgDrugMethodThird;
	}

	public String getBfDrugFlag() {
		return bfDrugFlag;
	}

	public void setBfDrugFlag(String bfDrugFlag) {
		this.bfDrugFlag = bfDrugFlag;
	}

	public String getBfDrugCodeFirst() {
		return bfDrugCodeFirst;
	}

	public void setBfDrugCodeFirst(String bfDrugCodeFirst) {
		this.bfDrugCodeFirst = bfDrugCodeFirst;
	}

	public String getBfDrugNameFirst() {
		return bfDrugNameFirst;
	}

	public void setBfDrugNameFirst(String bfDrugNameFirst) {
		this.bfDrugNameFirst = bfDrugNameFirst;
	}

	public String getBfDrugMethodFirst() {
		return bfDrugMethodFirst;
	}

	public void setBfDrugMethodFirst(String bfDrugMethodFirst) {
		this.bfDrugMethodFirst = bfDrugMethodFirst;
	}

	public String getBfDrugCodeSecond() {
		return bfDrugCodeSecond;
	}

	public void setBfDrugCodeSecond(String bfDrugCodeSecond) {
		this.bfDrugCodeSecond = bfDrugCodeSecond;
	}

	public String getBfDrugNameSecond() {
		return bfDrugNameSecond;
	}

	public void setBfDrugNameSecond(String bfDrugNameSecond) {
		this.bfDrugNameSecond = bfDrugNameSecond;
	}

	public String getBfDrugMethodSecond() {
		return bfDrugMethodSecond;
	}

	public void setBfDrugMethodSecond(String bfDrugMethodSecond) {
		this.bfDrugMethodSecond = bfDrugMethodSecond;
	}

	public String getBfDrugCodeThird() {
		return bfDrugCodeThird;
	}

	public void setBfDrugCodeThird(String bfDrugCodeThird) {
		this.bfDrugCodeThird = bfDrugCodeThird;
	}

	public String getBfDrugNameThird() {
		return bfDrugNameThird;
	}

	public void setBfDrugNameThird(String bfDrugNameThird) {
		this.bfDrugNameThird = bfDrugNameThird;
	}

	public String getBfDrugMethodThird() {
		return bfDrugMethodThird;
	}

	public void setBfDrugMethodThird(String bfDrugMethodThird) {
		this.bfDrugMethodThird = bfDrugMethodThird;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Date getNextVisitDate() {
		return nextVisitDate;
	}

	public void setNextVisitDate(Date nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}

	public String getVisitOrganCode() {
		return visitOrganCode;
	}

	public void setVisitOrganCode(String visitOrganCode) {
		this.visitOrganCode = visitOrganCode;
	}

	public String getVisitOrganName() {
		return visitOrganName;
	}

	public void setVisitOrganName(String visitOrganName) {
		this.visitOrganName = visitOrganName;
	}

	public String getVisitIdcard() {
		return visitIdcard;
	}

	public void setVisitIdcard(String visitIdcard) {
		this.visitIdcard = visitIdcard;
	}

	public String getVisitName() {
		return visitName;
	}

	public void setVisitName(String visitName) {
		this.visitName = visitName;
	}

	public String getCreateOrganName() {
		return createOrganName;
	}

	public void setCreateOrganName(String createOrganName) {
		this.createOrganName = createOrganName;
	}

	public String getCreateOrganCode() {
		return createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	public String getCreateDoctorName() {
		return createDoctorName;
	}

	public void setCreateDoctorName(String createDoctorName) {
		this.createDoctorName = createDoctorName;
	}

	public String getCreateDoctorCode() {
		return createDoctorCode;
	}

	public void setCreateDoctorCode(String createDoctorCode) {
		this.createDoctorCode = createDoctorCode;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateOrganCode() {
		return updateOrganCode;
	}

	public void setUpdateOrganCode(String updateOrganCode) {
		this.updateOrganCode = updateOrganCode;
	}

	public String getUpdateOrganName() {
		return updateOrganName;
	}

	public void setUpdateOrganName(String updateOrganName) {
		this.updateOrganName = updateOrganName;
	}

	public String getUpdateDoctorCode() {
		return updateDoctorCode;
	}

	public void setUpdateDoctorCode(String updateDoctorCode) {
		this.updateDoctorCode = updateDoctorCode;
	}

	public String getUpdateDoctorName() {
		return updateDoctorName;
	}

	public void setUpdateDoctorName(String updateDoctorName) {
		this.updateDoctorName = updateDoctorName;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public String getBpDrugNoRegularReason() {
		return bpDrugNoRegularReason;
	}

	public void setBpDrugNoRegularReason(String bpDrugNoRegularReason) {
		this.bpDrugNoRegularReason = bpDrugNoRegularReason;
	}

	public String getBgDrugNoRegularReason() {
		return bgDrugNoRegularReason;
	}

	public void setBgDrugNoRegularReason(String bgDrugNoRegularReason) {
		this.bgDrugNoRegularReason = bgDrugNoRegularReason;
	}

	public String getBfDrugNoRegularReason() {
		return bfDrugNoRegularReason;
	}

	public void setBfDrugNoRegularReason(String bfDrugNoRegularReason) {
		this.bfDrugNoRegularReason = bfDrugNoRegularReason;
	}

	public String getBloodGlucoseFalg() {
		return bloodGlucoseFalg;
	}

	public void setBloodGlucoseFalg(String bloodGlucoseFalg) {
		this.bloodGlucoseFalg = bloodGlucoseFalg;
	}

	public String getNonDrugsOther() {
		return nonDrugsOther;
	}

	public void setNonDrugsOther(String nonDrugsOther) {
		this.nonDrugsOther = nonDrugsOther;
	}

	public String getSmoking() {
		return smoking;
	}

	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}

	public String getDrinking() {
		return drinking;
	}

	public void setDrinking(String drinking) {
		this.drinking = drinking;
	}

	public String getMeat() {
		return meat;
	}

	public void setMeat(String meat) {
		this.meat = meat;
	}

	public String getProduce() {
		return produce;
	}

	public void setProduce(String produce) {
		this.produce = produce;
	}

	public String getPhysicalActivity() {
		return physicalActivity;
	}

	public void setPhysicalActivity(String physicalActivity) {
		this.physicalActivity = physicalActivity;
	}

	public String getEcgTimes() {
		return ecgTimes;
	}

	public void setEcgTimes(String ecgTimes) {
		this.ecgTimes = ecgTimes;
	}

	public String getBloodTimes() {
		return bloodTimes;
	}

	public void setBloodTimes(String bloodTimes) {
		this.bloodTimes = bloodTimes;
	}

	public String getDrugPayments() {
		return drugPayments;
	}

	public void setDrugPayments(String drugPayments) {
		this.drugPayments = drugPayments;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}