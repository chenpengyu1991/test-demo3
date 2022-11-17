package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 诊断依据、诊断结果
 */
@Entity
@Table(name = "IDM_DIAGNOSIS")
public class Diagnosis implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编码|11|", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "CLINICAL_DIAGNOSIS", columnDefinition = "VARCHAR2|临床诊断|100|", length = 100, nullable = true)
	private String clinicalDiagnosis;

	@Column(name = "THERAPEUTIC_METHOD", columnDefinition = "VARCHAR2|主要治疗方法|200|", length = 200, nullable = true)
	private String therapeuticMethod;

	@Column(name = "DIAGNOSIS_REASON", columnDefinition = "VARCHAR2|诊断依据|100|", length = 100, nullable = true)
	private String diagnosisReason;

	@Column(name = "DIAGNOSIS_DT", columnDefinition = "DATE|诊断时间||", nullable = true)
	private Date diagnosisDt;

	@Column(name = "EXCLUDE_DT", columnDefinition = "DATE|排除时间||", nullable = true)
	private Date excludeDt;

	@Column(name = "DIAGNOSIS_DISEASE", columnDefinition = "VARCHAR2|排除病例最后确诊疾病|100|", length = 100, nullable = true)
	private String diagnosisDisease;

	@Column(name = "AFP", columnDefinition = "VARCHAR2|是否是AFP病例|2|", length = 2, nullable = true)
	private String afp;

	@Column(name = "AFP_CATEGORY", columnDefinition = "VARCHAR2|是AFP病例|2|", length = 2, nullable = true)
	private String afpCategory;

	@Column(name = "AFP_OTHER", columnDefinition = "VARCHAR2|是AFP病例其它|100|", length = 100, nullable = true)
	private String afpOther;

	@Column(name = "UN_AFP", columnDefinition = "VARCHAR2|不是AFP病例|2|", length = 2, nullable = true)
	private String unAfp;

	@Column(name = "UN_AFP_OTHER", columnDefinition = "VARCHAR2|不是AFP病例其它|100|", length = 100, nullable = true)
	private String unAfpOther;

	@Column(name = "DIAGNOSIS_CATEGORY", columnDefinition = "VARCHAR2|最后诊断及分类(省填写)|2|", length = 2, nullable = true)
	private String diagnosisCategory;

	@Column(name = "NO_SPECIMEN", columnDefinition = "VARCHAR2|无合格粪便标本或无标本|2|", length = 2, nullable = true)
	private String noSpecimen;

	@Column(name = "RESIDUAL_PARALYSIS", columnDefinition = "VARCHAR2|发病60天后残留麻痹|2|", length = 2, nullable = true)
	private String residualParalysis;

	@Column(name = "CASE_LOST_FOLLOWUP", columnDefinition = "VARCHAR2|病例失访|2|", length = 2, nullable = true)
	private String caseLostFollowup;

	@Column(name = "CASE_DIE", columnDefinition = "VARCHAR2|病例死亡|2|", length = 2, nullable = true)
	private String caseDie;

	@Column(name = "EXPERT_AFFIRM", columnDefinition = "VARCHAR2|省级专家诊断小组认定|2|", length = 2, nullable = true)
	private String expertAffirm;

	@Column(name = "POLIO_EXCLUDE_REASON", columnDefinition = "VARCHAR2|如为脊灰排除病例,依据|2|", length = 2, nullable = true)
	private String polioExcludeReason;

	@Column(name = "POLIO_DIAGNOSIS_REASON", columnDefinition = "VARCHAR2|如为脊灰确诊病例,依据|2|", length = 2, nullable = true)
	private String polioDiagnosisReason;

	@Column(name = "POLIO_EXCLUDE_DIAGNOSIS", columnDefinition = "VARCHAR2|脊灰排除病例临床诊断|2|", length = 2, nullable = true)
	private String polioExcludeDiagnosis;

	@Column(name = "OTHER", columnDefinition = "VARCHAR2|其它|100|", length = 100, nullable = true)
	private String other;

	@Column(name = "FOLLOW_UP", columnDefinition = "VARCHAR2|是否进行病例随访|2|", length = 2, nullable = true)
	private String followUp;

	@Column(name = "FOLLOW_UP_UNIT", columnDefinition = "VARCHAR2|随访单位|2|", length = 2, nullable = true)
	private String followUpUnit;

	@Column(name = "FOLLOW_UP_DT", columnDefinition = "DATE|随访日期||", nullable = true)
	private Date followUpDt;

	@Column(name = "FOLLOW_UP_NAME", columnDefinition = "VARCHAR2|随访人姓名|50|", length = 50, nullable = true)
	private String followUpName;

	@Column(name = "FOLLOWUP_CASE_DIE", columnDefinition = "VARCHAR2|病例死亡|2|", length = 2, nullable = true)
	private String followupCaseDie;

	@Column(name = "FOLLOWUP_CASE_LOST_FOLLOWUP", columnDefinition = "VARCHAR2|病例失访|2|", length = 2, nullable = true)
	private String followupCaseLostFollowup;

	@Column(name = "FOLLOWUP_RESIDUAL_PARALYSIS", columnDefinition = "VARCHAR2|是否残留麻痹|2|", length = 2, nullable = true)
	private String followupResidualParalysis;

	@Column(name = "LEFT_UPPER_LIMB", columnDefinition = "VARCHAR2|左上肢|2|", length = 2, nullable = true)
	private String leftUpperLimb;

	@Column(name = "RIGHT_UPPER_LIMB", columnDefinition = "VARCHAR2|右上肢|2|", length = 2, nullable = true)
	private String rightUpperLimb;

	@Column(name = "LEFT_LOWER_LIMB", columnDefinition = "VARCHAR2|左下肢|2|", length = 2, nullable = true)
	private String leftLowerLimb;

	@Column(name = "RIGHT_LOWER_LIMB", columnDefinition = "VARCHAR2|右下肢|2|", length = 2, nullable = true)
	private String rightLowerLimb;

	@Column(name = "LIMB_SENSORY_DISTURBANCE", columnDefinition = "VARCHAR2|肢体感觉障碍|2|", length = 2, nullable = true)
	private String limbSensoryDisturbance;

	@Column(name = "LIMB_PART", columnDefinition = "VARCHAR2|部位(请注明)|100|", length = 100, nullable = true)
	private String limbPart;

	@Column(name = "INCONTINENT_DURATION", columnDefinition = "String|如有大小便失禁,持续时间|20|", length = 20, nullable = true)
	private String incontinentDuration;

	@Column(name = "BABINSKI_REFLEX", columnDefinition = "VARCHAR2|巴彬斯基氏反射|2|", length = 2, nullable = true)
	private String babinskiReflex;

	@Column(name = "ANKLE_CLONUS", columnDefinition = "VARCHAR2|踝阵挛|2|", length = 2, nullable = true)
	private String ankleClonus;

	@Column(name = "MUSCLE_ATROPHY", columnDefinition = "VARCHAR2|肌肉萎缩|2|", length = 2, nullable = true)
	private String muscleAtrophy;

	@Column(name = "MUSCLE_PART", columnDefinition = "VARCHAR2|部位(请注明)|100|", length = 100, nullable = true)
	private String musclePart;

	@Column(name = "DTR_UNUSUAL", columnDefinition = "VARCHAR2|深部腱反射异常|2|", length = 2, nullable = true)
	private String dtrUnusual;

	@Column(name = "TENDO_CALCANEUS", columnDefinition = "VARCHAR2|跟腱|2|", length = 2, nullable = true)
	private String tendoCalcaneus;

	@Column(name = "KNEE", columnDefinition = "VARCHAR2|膝|2|", length = 2, nullable = true)
	private String knee;

	@Column(name = "BICEPS_BRACHII", columnDefinition = "VARCHAR2|肱二头肌|2|", length = 2, nullable = true)
	private String bicepsBrachii;

	@Column(name = "LOCOMOTOR_ACTIVITY", columnDefinition = "VARCHAR2|行走能力|2|", length = 2, nullable = true)
	private String locomotorActivity;

	@Column(name = "CHECK_DOCTOR", columnDefinition = "VARCHAR2|检查医师|2|", length = 2, nullable = true)
	private String checkDoctor;

	@Column(name = "OUT_HOSPITL_DIAGNOSIS", columnDefinition = "VARCHAR2|病例出院诊断|2|", length = 2, nullable = true)
	private String outHospitlDiagnosis;

	@Column(name = "DIAGNOSIS_OTHER", columnDefinition = "VARCHAR2|其它|100|", length = 100, nullable = true)
	private String diagnosisOther;

	@Column(name = "TO_CDC_DT", columnDefinition = "DATE|随访表送达省CDC时间||", nullable = true)
	private Date toCdcDt;

	@Column(name = "EXPOSE_DT", columnDefinition = "DATE|暴露（被伤）日期|精确到年月日时|", nullable = true)
	private Date exposeDt;

	@Column(name = "SYMPTOM_SIGN", columnDefinition = "VARCHAR2|症状体征|2|", length = 2, nullable = true)
	private String symptomSign;

	@Column(name = "LIVER_FUNCTION", columnDefinition = "VARCHAR2|肝功能|2|", length = 2, nullable = true)
	private String liverFunction;

	@Column(name = "VIRUS_INFECTION", columnDefinition = "VARCHAR2|病毒感染标志|2|", length = 2, nullable = true)
	private String virusInfection;

	@Column(name = "HBVER", columnDefinition = "VARCHAR2|本次发病前是否是乙肝病毒携带者|2|", length = 2, nullable = true)
	private String hbver;

	@Column(name = "HCVER", columnDefinition = "VARCHAR2|本次发病前是否是丙肝病毒携带者|2|", length = 2, nullable = true)
	private String hcver;

	@Column(name = "HDVER", columnDefinition = "VARCHAR2|本次发病前是否是丁肝病毒携带者|2|", length = 2, nullable = true)
	private String hdver;

	@Column(name = "EPIDEMIOLOGY_HISTORY", columnDefinition = "VARCHAR2|可疑流行病学史|2|", length = 2, nullable = true)
	private String epidemiologyHistory;

	@Column(name = "CLINICAL_FEATURE", columnDefinition = "VARCHAR2|临床表现典型|2|", length = 2, nullable = true)
	private String clinicalFeature;

	@Column(name = "BACILLUS_COMMA_POSITIVE", columnDefinition = "VARCHAR2|霍乱弧菌检验阳性|2|", length = 2, nullable = true)
	private String bacillusCommaPositive;

	@Column(name = "ETIOLOGY_CATEGORY", columnDefinition = "VARCHAR2|病原分型|2|", length = 2, nullable = true)
	private String etiologyCategory;

	@Column(name = "BACTERIOPHAGE", columnDefinition = "VARCHAR2|噬菌体-生物型|200|", length = 200, nullable = true)
	private String bacteriophage;

	@Column(name = "CHOLERA_CONCLUSION", columnDefinition = "VARCHAR2|霍乱诊断结论|2|", length = 2, nullable = true)
	private String choleraConclusion;

	@Column(name = "LAST_DIAGNOSIS", columnDefinition = "VARCHAR2|最后诊断|2|", length = 2, nullable = true)
	private String lastDiagnosis;

	@Column(name = "CHECK_DOCTOR_OTHER", columnDefinition = "VARCHAR2|检查医师-其他|100|", length = 100, nullable = true)
	private String checkDoctorOther;

	@Column(name = "DOUBTFUL_DT", columnDefinition = "DATE|疑似时间||", nullable = true)
	private Date doubtfulDt;

	@Column(name = "DIAGNOSIS_TYPE", columnDefinition = "VARCHAR2|最终诊断|2|", length = 2, nullable = true)
	private String diagnosisType;

	@Column(name = "DIAGNOSIS_ACCORDING", columnDefinition = "VARCHAR2|确诊依据|2|", length = 2, nullable = true)
	private String diagnosisAccording;

    @Column(name = "TENTATIVE_DIAGNOSIS", columnDefinition = "VARCHAR2|初步诊断|2|", length = 2, nullable = true)
    private String tentativeDiagnosis;

    @Column(name = "TRANSFER_TREATMENT_ACCORDING", columnDefinition = "VARCHAR2|转诊依据|2|", length = 2, nullable = true)
    private String transferTreatmentAccording;

    @Column(name = "DIAGNOSIS_REASON_MULTI", columnDefinition = "VARCHAR2|诊断结果（复选）|100|", length = 100, nullable = true)
    private String diagnosisReasonMulti;

    @Column(name = "OTHER_PHTHISIS", columnDefinition = "VARCHAR2|合并其他结核|2|", length = 2, nullable = true)
    private String otherPhthisis;

    @Column(name = "OTHER_PHTHISIS_MULTI", columnDefinition = "VARCHAR2|合并其他结核-选择|100|", length = 100, nullable = true)
    private String otherPhthisisMulti;

    @Column(name = "OTHER_PHTHISIS_OTHER", columnDefinition = "VARCHAR2|合并其他结核-其他|100|", length = 100, nullable = true)
    private String otherPhthisisOther;

    @Column(name = "COMPLICATION", columnDefinition = "VARCHAR2|合并症|2|", length = 2, nullable = true)
    private String complication;

    @Column(name = "COMPLICATION_MULTI", columnDefinition = "VARCHAR2|合并症-选择|100|", length = 100, nullable = true)
    private String complicationMulti;

    @Column(name = "COMPLICATION_OTHER", columnDefinition = "VARCHAR2|合并症-其他|100|", length = 100, nullable = true)
    private String complicationOther;

    @Column(name = "REGISTER_DT", columnDefinition = "DATE|本次登记日期||", nullable = true)
    private Date registerDt;

    @Column(name = "DIAGNOSIS_UNIT", columnDefinition = "VARCHAR2|诊断单位|100|", length = 100, nullable = true)
    private String diagnosisUnit;

    @Column(name = "PERSON_TYPE", columnDefinition = "VARCHAR2|人员分类|2|", length = 2, nullable = true)
    private String personType;

    @Column(name = "ACCORDING_SKIN_LESION", columnDefinition = "VARCHAR2|疑似依据－皮损|200|", length = 200, nullable = true)
    private String accordingSkinLesion;

    @Column(name = "ACCORDING_SYMPTOM", columnDefinition = "VARCHAR2|疑似依据－症状|200|", length = 200, nullable = true)
    private String accordingSymptom;

    @Column(name = "ACCORDING_SIGNS", columnDefinition = "VARCHAR2|疑似依据－体症|200|", length = 200, nullable = true)
    private String accordingSigns;

    @Column(name = "IS_LEPROSY", columnDefinition = "VARCHAR2|是否麻风|2|", length = 2, nullable = true)
    private String isLeprosy;

    @Column(name = "LEPROSY_TYPE", columnDefinition = "VARCHAR2|麻风分类|2|", length = 2, nullable = true)
    private String leprosyType;

    @Column(name = "LEPROSY_REACTION", columnDefinition = "VARCHAR2|麻风反应|2|", length = 2, nullable = true)
    private String leprosyReaction;

    @Column(name = "NEURITIS", columnDefinition = "VARCHAR2|神经炎|2|", length = 2, nullable = true)
    private String neuritis;

    @Column(name = "MDT", columnDefinition = "VARCHAR2|mdt方案|200|", length = 200, nullable = true)
    private String mdt;

    @Column(name = "NEURITIS_SCHEME", columnDefinition = "VARCHAR2|神经炎方案|200|", length = 200, nullable = true)
    private String neuritisScheme;

    @Column(name = "SCHEME", columnDefinition = "VARCHAR2|方案|200|", length = 200, nullable = true)
    private String scheme;

    @Column(name = "DIAGNOSIS_DOCTOR", columnDefinition = "VARCHAR2|诊断医生|50|", length = 50, nullable = true)
    private String diagnosisDoctor;
    
    @Column(name = "LEPROSY_REACTION_REASON", columnDefinition = "VARCHAR2|麻风反应依据|100|", length = 100, nullable = true)
    private String leprosyReactionReason;
    
    @Column(name = "NEURITIS_REASON", columnDefinition = "VARCHAR2|神经炎反应依据|100|", length = 100, nullable = true)
    private String neuritisReason;
    
    @Column(name = "DOCTOR_TELL", columnDefinition = "VARCHAR2|负责医生电话|50|", length = 100, nullable = true)
    private String doctorTell;
    
    @Column(name = "TREATMENT_DOCTOR", columnDefinition = "VARCHAR2|经治医生|50|", length = 100, nullable = true)
    private String treatmentDoctor;

    @Column(name = "TREATMENT_DT", columnDefinition = "DATE|经治时间||", nullable = true)
    private Date treatmentDt;
    
	@Column(name = "WB_EXAMINE_RESULT", columnDefinition = "VARCHAR2|WB确认结果|20|", length = 20, nullable = true)
   	private String wbExamineResult;
    @Column(name = "WB_EXAMINE_DATE", columnDefinition = "DATE|WB检测日期||",  nullable = true)
   	private Date wbExamineDate;
   	@Column(name = "HIV_CONFIRMATION_DATE", columnDefinition = "DATE|艾滋病确诊日期||",  nullable = true)
   	private Date hivConfirmationDate;
  
	@Column(name = "LAST_DIAGNOSIS_TEXT", columnDefinition = "VARCHAR2|最后诊断文本内容|100|", length = 2, nullable = true)
	private String lastDiagnosisText;
	
   	public String getWbExamineResult() {
		return wbExamineResult;
	}

	public void setWbExamineResult(String wbExamineResult) {
		this.wbExamineResult = wbExamineResult;
	}

	public Date getWbExamineDate() {
		return wbExamineDate;
	}

	public void setWbExamineDate(Date wbExamineDate) {
		this.wbExamineDate = wbExamineDate;
	}

	public Date getHivConfirmationDate() {
		return hivConfirmationDate;
	}

	public void setHivConfirmationDate(Date hivConfirmationDate) {
		this.hivConfirmationDate = hivConfirmationDate;
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

	public String getClinicalDiagnosis() {
		return this.clinicalDiagnosis;
	}

	public void setClinicalDiagnosis(String clinicalDiagnosis) {
		this.clinicalDiagnosis = clinicalDiagnosis;
	}

	public String getTherapeuticMethod() {
		return this.therapeuticMethod;
	}

	public void setTherapeuticMethod(String therapeuticMethod) {
		this.therapeuticMethod = therapeuticMethod;
	}

	public String getDiagnosisReason() {
		return this.diagnosisReason;
	}

	public void setDiagnosisReason(String diagnosisReason) {
		this.diagnosisReason = diagnosisReason;
	}

	public Date getDiagnosisDt() {
		return this.diagnosisDt;
	}

	public void setDiagnosisDt(Date diagnosisDt) {
		this.diagnosisDt = diagnosisDt;
	}

	public Date getExcludeDt() {
		return this.excludeDt;
	}

	public void setExcludeDt(Date excludeDt) {
		this.excludeDt = excludeDt;
	}

	public String getDiagnosisDisease() {
		return this.diagnosisDisease;
	}

	public void setDiagnosisDisease(String diagnosisDisease) {
		this.diagnosisDisease = diagnosisDisease;
	}

	public String getAfp() {
		return this.afp;
	}

	public void setAfp(String afp) {
		this.afp = afp;
	}

	public String getAfpCategory() {
		return this.afpCategory;
	}

	public void setAfpCategory(String afpCategory) {
		this.afpCategory = afpCategory;
	}

	public String getAfpOther() {
		return this.afpOther;
	}

	public void setAfpOther(String afpOther) {
		this.afpOther = afpOther;
	}

	public String getUnAfp() {
		return this.unAfp;
	}

	public void setUnAfp(String unAfp) {
		this.unAfp = unAfp;
	}

	public String getUnAfpOther() {
		return this.unAfpOther;
	}

	public void setUnAfpOther(String unAfpOther) {
		this.unAfpOther = unAfpOther;
	}

	public String getDiagnosisCategory() {
		return this.diagnosisCategory;
	}

	public void setDiagnosisCategory(String diagnosisCategory) {
		this.diagnosisCategory = diagnosisCategory;
	}

	public String getNoSpecimen() {
		return this.noSpecimen;
	}

	public void setNoSpecimen(String noSpecimen) {
		this.noSpecimen = noSpecimen;
	}

	public String getResidualParalysis() {
		return this.residualParalysis;
	}

	public void setResidualParalysis(String residualParalysis) {
		this.residualParalysis = residualParalysis;
	}

	public String getCaseLostFollowup() {
		return this.caseLostFollowup;
	}

	public void setCaseLostFollowup(String caseLostFollowup) {
		this.caseLostFollowup = caseLostFollowup;
	}

	public String getCaseDie() {
		return this.caseDie;
	}

	public void setCaseDie(String caseDie) {
		this.caseDie = caseDie;
	}

	public String getExpertAffirm() {
		return this.expertAffirm;
	}

	public void setExpertAffirm(String expertAffirm) {
		this.expertAffirm = expertAffirm;
	}

	public String getPolioExcludeReason() {
		return this.polioExcludeReason;
	}

	public void setPolioExcludeReason(String polioExcludeReason) {
		this.polioExcludeReason = polioExcludeReason;
	}

	public String getPolioDiagnosisReason() {
		return this.polioDiagnosisReason;
	}

	public void setPolioDiagnosisReason(String polioDiagnosisReason) {
		this.polioDiagnosisReason = polioDiagnosisReason;
	}

	public String getPolioExcludeDiagnosis() {
		return this.polioExcludeDiagnosis;
	}

	public void setPolioExcludeDiagnosis(String polioExcludeDiagnosis) {
		this.polioExcludeDiagnosis = polioExcludeDiagnosis;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getFollowUp() {
		return this.followUp;
	}

	public void setFollowUp(String followUp) {
		this.followUp = followUp;
	}

	public String getFollowUpUnit() {
		return this.followUpUnit;
	}

	public void setFollowUpUnit(String followUpUnit) {
		this.followUpUnit = followUpUnit;
	}

	public Date getFollowUpDt() {
		return this.followUpDt;
	}

	public void setFollowUpDt(Date followUpDt) {
		this.followUpDt = followUpDt;
	}

	public String getFollowUpName() {
		return this.followUpName;
	}

	public void setFollowUpName(String followUpName) {
		this.followUpName = followUpName;
	}

	public String getFollowupCaseDie() {
		return this.followupCaseDie;
	}

	public void setFollowupCaseDie(String followupCaseDie) {
		this.followupCaseDie = followupCaseDie;
	}

	public String getFollowupCaseLostFollowup() {
		return this.followupCaseLostFollowup;
	}

	public void setFollowupCaseLostFollowup(String followupCaseLostFollowup) {
		this.followupCaseLostFollowup = followupCaseLostFollowup;
	}

	public String getFollowupResidualParalysis() {
		return this.followupResidualParalysis;
	}

	public void setFollowupResidualParalysis(String followupResidualParalysis) {
		this.followupResidualParalysis = followupResidualParalysis;
	}

	public String getLeftUpperLimb() {
		return this.leftUpperLimb;
	}

	public void setLeftUpperLimb(String leftUpperLimb) {
		this.leftUpperLimb = leftUpperLimb;
	}

	public String getRightUpperLimb() {
		return this.rightUpperLimb;
	}

	public void setRightUpperLimb(String rightUpperLimb) {
		this.rightUpperLimb = rightUpperLimb;
	}

	public String getLeftLowerLimb() {
		return this.leftLowerLimb;
	}

	public void setLeftLowerLimb(String leftLowerLimb) {
		this.leftLowerLimb = leftLowerLimb;
	}

	public String getRightLowerLimb() {
		return this.rightLowerLimb;
	}

	public void setRightLowerLimb(String rightLowerLimb) {
		this.rightLowerLimb = rightLowerLimb;
	}

	public String getLimbSensoryDisturbance() {
		return this.limbSensoryDisturbance;
	}

	public void setLimbSensoryDisturbance(String limbSensoryDisturbance) {
		this.limbSensoryDisturbance = limbSensoryDisturbance;
	}

	public String getLimbPart() {
		return this.limbPart;
	}

	public void setLimbPart(String limbPart) {
		this.limbPart = limbPart;
	}

	public String getIncontinentDuration() {
		return this.incontinentDuration;
	}

	public void setIncontinentDuration(String incontinentDuration) {
		this.incontinentDuration = incontinentDuration;
	}

	public String getBabinskiReflex() {
		return this.babinskiReflex;
	}

	public void setBabinskiReflex(String babinskiReflex) {
		this.babinskiReflex = babinskiReflex;
	}

	public String getAnkleClonus() {
		return this.ankleClonus;
	}

	public void setAnkleClonus(String ankleClonus) {
		this.ankleClonus = ankleClonus;
	}

	public String getMuscleAtrophy() {
		return this.muscleAtrophy;
	}

	public void setMuscleAtrophy(String muscleAtrophy) {
		this.muscleAtrophy = muscleAtrophy;
	}

	public String getMusclePart() {
		return this.musclePart;
	}

	public void setMusclePart(String musclePart) {
		this.musclePart = musclePart;
	}

	public String getDtrUnusual() {
		return this.dtrUnusual;
	}

	public void setDtrUnusual(String dtrUnusual) {
		this.dtrUnusual = dtrUnusual;
	}

	public String getTendoCalcaneus() {
		return this.tendoCalcaneus;
	}

	public void setTendoCalcaneus(String tendoCalcaneus) {
		this.tendoCalcaneus = tendoCalcaneus;
	}

	public String getKnee() {
		return this.knee;
	}

	public void setKnee(String knee) {
		this.knee = knee;
	}

	public String getBicepsBrachii() {
		return this.bicepsBrachii;
	}

	public void setBicepsBrachii(String bicepsBrachii) {
		this.bicepsBrachii = bicepsBrachii;
	}

	public String getLocomotorActivity() {
		return this.locomotorActivity;
	}

	public void setLocomotorActivity(String locomotorActivity) {
		this.locomotorActivity = locomotorActivity;
	}

	public String getCheckDoctor() {
		return this.checkDoctor;
	}

	public void setCheckDoctor(String checkDoctor) {
		this.checkDoctor = checkDoctor;
	}

	public String getOutHospitlDiagnosis() {
		return this.outHospitlDiagnosis;
	}

	public void setOutHospitlDiagnosis(String outHospitlDiagnosis) {
		this.outHospitlDiagnosis = outHospitlDiagnosis;
	}

	public String getDiagnosisOther() {
		return this.diagnosisOther;
	}

	public void setDiagnosisOther(String diagnosisOther) {
		this.diagnosisOther = diagnosisOther;
	}

	public Date getToCdcDt() {
		return this.toCdcDt;
	}

	public void setToCdcDt(Date toCdcDt) {
		this.toCdcDt = toCdcDt;
	}

	public Date getExposeDt() {
		return this.exposeDt;
	}

	public void setExposeDt(Date exposeDt) {
		this.exposeDt = exposeDt;
	}

	public String getSymptomSign() {
		return this.symptomSign;
	}

	public void setSymptomSign(String symptomSign) {
		this.symptomSign = symptomSign;
	}

	public String getLiverFunction() {
		return this.liverFunction;
	}

	public void setLiverFunction(String liverFunction) {
		this.liverFunction = liverFunction;
	}

	public String getVirusInfection() {
		return this.virusInfection;
	}

	public void setVirusInfection(String virusInfection) {
		this.virusInfection = virusInfection;
	}

	public String getHbver() {
		return this.hbver;
	}

	public void setHbver(String hbver) {
		this.hbver = hbver;
	}

	public String getHcver() {
		return this.hcver;
	}

	public void setHcver(String hcver) {
		this.hcver = hcver;
	}

	public String getHdver() {
		return this.hdver;
	}

	public void setHdver(String hdver) {
		this.hdver = hdver;
	}

	public String getEpidemiologyHistory() {
		return this.epidemiologyHistory;
	}

	public void setEpidemiologyHistory(String epidemiologyHistory) {
		this.epidemiologyHistory = epidemiologyHistory;
	}

	public String getClinicalFeature() {
		return this.clinicalFeature;
	}

	public void setClinicalFeature(String clinicalFeature) {
		this.clinicalFeature = clinicalFeature;
	}

	public String getBacillusCommaPositive() {
		return this.bacillusCommaPositive;
	}

	public void setBacillusCommaPositive(String bacillusCommaPositive) {
		this.bacillusCommaPositive = bacillusCommaPositive;
	}

	public String getEtiologyCategory() {
		return this.etiologyCategory;
	}

	public void setEtiologyCategory(String etiologyCategory) {
		this.etiologyCategory = etiologyCategory;
	}

	public String getBacteriophage() {
		return this.bacteriophage;
	}

	public void setBacteriophage(String bacteriophage) {
		this.bacteriophage = bacteriophage;
	}

	public String getCholeraConclusion() {
		return this.choleraConclusion;
	}

	public void setCholeraConclusion(String choleraConclusion) {
		this.choleraConclusion = choleraConclusion;
	}

	public String getLastDiagnosis() {
		return this.lastDiagnosis;
	}

	public void setLastDiagnosis(String lastDiagnosis) {
		this.lastDiagnosis = lastDiagnosis;
	}

	public String getCheckDoctorOther() {
		return this.checkDoctorOther;
	}

	public void setCheckDoctorOther(String checkDoctorOther) {
		this.checkDoctorOther = checkDoctorOther;
	}

	public Date getDoubtfulDt() {
		return this.doubtfulDt;
	}

	public void setDoubtfulDt(Date doubtfulDt) {
		this.doubtfulDt = doubtfulDt;
	}

	public String getDiagnosisType() {
		return this.diagnosisType;
	}

	public void setDiagnosisType(String diagnosisType) {
		this.diagnosisType = diagnosisType;
	}

	public String getDiagnosisAccording() {
		return this.diagnosisAccording;
	}

	public void setDiagnosisAccording(String diagnosisAccording) {
		this.diagnosisAccording = diagnosisAccording;
	}

    public String getTentativeDiagnosis() {
        return this.tentativeDiagnosis;
    }

    public void setTentativeDiagnosis(String tentativeDiagnosis) {
        this.tentativeDiagnosis = tentativeDiagnosis;
    }

    public String getTransferTreatmentAccording() {
        return this.transferTreatmentAccording;
    }

    public void setTransferTreatmentAccording(String transferTreatmentAccording) {
        this.transferTreatmentAccording = transferTreatmentAccording;
    }

    public String getDiagnosisReasonMulti() {
        return this.diagnosisReasonMulti;
    }

    public void setDiagnosisReasonMulti(String diagnosisReasonMulti) {
        this.diagnosisReasonMulti = diagnosisReasonMulti;
    }

    public String getOtherPhthisis() {
        return this.otherPhthisis;
    }

    public void setOtherPhthisis(String otherPhthisis) {
        this.otherPhthisis = otherPhthisis;
    }

    public String getOtherPhthisisMulti() {
        return this.otherPhthisisMulti;
    }

    public void setOtherPhthisisMulti(String otherPhthisisMulti) {
        this.otherPhthisisMulti = otherPhthisisMulti;
    }

    public String getOtherPhthisisOther() {
        return this.otherPhthisisOther;
    }

    public void setOtherPhthisisOther(String otherPhthisisOther) {
        this.otherPhthisisOther = otherPhthisisOther;
    }

    public String getComplication() {
        return this.complication;
    }

    public void setComplication(String complication) {
        this.complication = complication;
    }

    public String getComplicationMulti() {
        return this.complicationMulti;
    }

    public void setComplicationMulti(String complicationMulti) {
        this.complicationMulti = complicationMulti;
    }

    public String getComplicationOther() {
        return this.complicationOther;
    }

    public void setComplicationOther(String complicationOther) {
        this.complicationOther = complicationOther;
    }

    public Date getRegisterDt() {
        return this.registerDt;
    }

    public void setRegisterDt(Date registerDt) {
        this.registerDt = registerDt;
    }

    public String getDiagnosisUnit() {
        return this.diagnosisUnit;
    }

    public void setDiagnosisUnit(String diagnosisUnit) {
        this.diagnosisUnit = diagnosisUnit;
    }

    public String getPersonType() {
        return this.personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public String getAccordingSkinLesion() {
        return this.accordingSkinLesion;
    }

    public void setAccordingSkinLesion(String accordingSkinLesion) {
        this.accordingSkinLesion = accordingSkinLesion;
    }

    public String getAccordingSymptom() {
        return this.accordingSymptom;
    }

    public void setAccordingSymptom(String accordingSymptom) {
        this.accordingSymptom = accordingSymptom;
    }

    public String getAccordingSigns() {
        return this.accordingSigns;
    }

    public void setAccordingSigns(String accordingSigns) {
        this.accordingSigns = accordingSigns;
    }

    public String getIsLeprosy() {
        return this.isLeprosy;
    }

    public void setIsLeprosy(String isLeprosy) {
        this.isLeprosy = isLeprosy;
    }

    public String getLeprosyType() {
        return this.leprosyType;
    }

    public void setLeprosyType(String leprosyType) {
        this.leprosyType = leprosyType;
    }

    public String getLeprosyReaction() {
        return this.leprosyReaction;
    }

    public void setLeprosyReaction(String leprosyReaction) {
        this.leprosyReaction = leprosyReaction;
    }

    public String getNeuritis() {
        return this.neuritis;
    }

    public void setNeuritis(String neuritis) {
        this.neuritis = neuritis;
    }

    public String getMdt() {
        return this.mdt;
    }

    public void setMdt(String mdt) {
        this.mdt = mdt;
    }

    public String getNeuritisScheme() {
        return this.neuritisScheme;
    }

    public void setNeuritisScheme(String neuritisScheme) {
        this.neuritisScheme = neuritisScheme;
    }

    public String getScheme() {
        return this.scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getDiagnosisDoctor() {
        return this.diagnosisDoctor;
    }

    public void setDiagnosisDoctor(String diagnosisDoctor) {
        this.diagnosisDoctor = diagnosisDoctor;
    }

	public String getLeprosyReactionReason() {
		return leprosyReactionReason;
	}

	public void setLeprosyReactionReason(String leprosyReactionReason) {
		this.leprosyReactionReason = leprosyReactionReason;
	}

	public String getNeuritisReason() {
		return neuritisReason;
	}

	public void setNeuritisReason(String neuritisReason) {
		this.neuritisReason = neuritisReason;
	}

	public String getDoctorTell() {
		return doctorTell;
	}

	public void setDoctorTell(String doctorTell) {
		this.doctorTell = doctorTell;
	}

	public String getTreatmentDoctor() {
		return treatmentDoctor;
	}

	public void setTreatmentDoctor(String treatmentDoctor) {
		this.treatmentDoctor = treatmentDoctor;
	}

	public Date getTreatmentDt() {
		return treatmentDt;
	}

	public void setTreatmentDt(Date treatmentDt) {
		this.treatmentDt = treatmentDt;
	}

	public String getLastDiagnosisText() {
		return lastDiagnosisText;
	}

	public void setLastDiagnosisText(String lastDiagnosisText) {
		this.lastDiagnosisText = lastDiagnosisText;
	}
}