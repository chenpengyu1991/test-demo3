package com.founder.rhip.ehr.entity.control.idm.special;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "IDM_LIST_RR")
public class ListRr implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|传染病唯一编码|11|", length = 11, nullable = true)
	private Long idmId;

	@Column(name = "DEVELOPMENT", columnDefinition = "VARCHAR2|发育|2|", length = 2, nullable = true)
	private String development;

	@Column(name = "NUTRITION", columnDefinition = "VARCHAR2|营养|2|", length = 2, nullable = true)
	private String nutrition;

	@Column(name = "ANEMIA", columnDefinition = "VARCHAR2|贫血|2|", length = 2, nullable = true)
	private String anemia;

	@Column(name = "SYSTOLIC_PRESSURE", columnDefinition = "VARCHAR2|血压－收缩|20|", length = 20, nullable = true)
	private String systolicPressure;

	@Column(name = "DIASTOLIC_PRESSURE", columnDefinition = "VARCHAR2|血压－舒张|20|", length = 20, nullable = true)
	private String diastolicPressure;

	@Column(name = "CARDIAC_DULLNESS", columnDefinition = "VARCHAR2|心浊音界|2|", length = 2, nullable = true)
	private String cardiacDullness;

	@Column(name = "EXPANSION", columnDefinition = "VARCHAR2|扩大|20|", length = 20, nullable = true)
	private String expansion;

	@Column(name = "CARDIAC_RHYTHM", columnDefinition = "VARCHAR2|心率|20|", length = 20, nullable = true)
	private String cardiacRhythm;

	@Column(name = "HEART_RATE", columnDefinition = "VARCHAR2|心律|20|", length = 20, nullable = true)
	private String heartRate;

	@Column(name = "SOUFFLE", columnDefinition = "VARCHAR2|杂音|100|", length = 100, nullable = true)
	private String souffle;

	@Column(name = "LUNGS", columnDefinition = "VARCHAR2|肺脏|400|", length = 400, nullable = true)
	private String lungs;

	@Column(name = "EXTERNAL", columnDefinition = "VARCHAR2|外形|2|", length = 2, nullable = true)
	private String external;

	@Column(name = "SHIFTING_DULLNESS", columnDefinition = "VARCHAR2|移动性浊音|2|", length = 2, nullable = true)
	private String shiftingDullness;

	@Column(name = "VENA_EPIGASTRICA", columnDefinition = "VARCHAR2|腹壁静脉|2|", length = 2, nullable = true)
	private String venaEpigastrica;

	@Column(name = "OTHER", columnDefinition = "VARCHAR2|其他|400|", length = 400, nullable = true)
	private String other;

	@Column(name = "LAB_EXAMINE", columnDefinition = "VARCHAR2|实验室检查|400|", length = 400, nullable = true)
	private String labExamine;

	@Column(name = "DIAGNOSIS", columnDefinition = "VARCHAR2|诊断|400|", length = 400, nullable = true)
	private String diagnosis;

	@Column(name = "COMMENTS", columnDefinition = "VARCHAR2|治疗意见|400|", length = 400, nullable = true)
	private String comments;

	@Column(name = "DRUGS", columnDefinition = "VARCHAR2|治疗药物|100|", length = 100, nullable = true)
	private String drugs;

	@Column(name = "MEASURE", columnDefinition = "VARCHAR2|计量|20|", length = 20, nullable = true)
	private String measure;

	@Column(name = "TOTAL_MEASURE", columnDefinition = "VARCHAR2|总量|20|", length = 20, nullable = true)
	private String totalMeasure;

	@Column(name = "TREATMENT_COURSE", columnDefinition = "VARCHAR2|疗程|20|", length = 20, nullable = true)
	private String treatmentCourse;

	@Column(name = "TREATMENT_DT", columnDefinition = "DATE|治疗时间||", nullable = true)
	private Date treatmentDt;

	@Column(name = "REALITY_DAYS", columnDefinition = "VARCHAR2|实际天数|20|", length = 20, nullable = true)
	private String realityDays;

	@Column(name = "REALITY_MEASURE", columnDefinition = "VARCHAR2|实际计量|20|", length = 20, nullable = true)
	private String realityMeasure;

	@Column(name = "MEASURE_RATE", columnDefinition = "VARCHAR2|剂量率|20|", length = 20, nullable = true)
	private String measureRate;

	@Column(name = "SIDE_REACTION", columnDefinition = "VARCHAR2|药物副反应|400|", length = 400, nullable = true)
	private String sideReaction;

	@Column(name = "DIAGNOSIS_UNIT", columnDefinition = "VARCHAR2|诊断单位|100|", length = 100, nullable = true)
	private String diagnosisUnit;

	@Column(name = "TREATMENT_DOCTOR", columnDefinition = "VARCHAR2|治疗医生|50|", length = 50, nullable = true)
	private String treatmentDoctor;
	
	@Column(name = "TREATMENT_TYPE", columnDefinition = "VARCHAR2|治疗类型|100|", length = 100, nullable = true)
	private String treatmentType;

	@Column(name = "TREATMENT_MONEY", columnDefinition = "VARCHAR2|金额|100|", length = 100, nullable = true)
	private String treatmentMoney;
	
	@Column(name = "LAPSETO", columnDefinition = "VARCHAR2|转归|2|", length = 2, nullable = true)
	private String lapseto;
	
	@Column(name = "CREATE_UNIT", columnDefinition = "VARCHAR2|新增单位|100|", length = 100, nullable = true)
	private String createUnit;

	@Column(name = "CREATE_DT", columnDefinition = "DATE|新增时间||", nullable = true)
	private Date createDt;

	@Column(name = "CREATE_USER", columnDefinition = "VARCHAR2|新增人|50|", length = 50, nullable = true)
	private String createUser;

	@Column(name = "MODIFY_UNIT", columnDefinition = "VARCHAR2|修改单位|100|", length = 100, nullable = true)
	private String modifyUnit;

	@Column(name = "MODIFY_DT", columnDefinition = "DATE|修改时间||", nullable = true)
	private Date modifyDt;

	@Column(name = "MODIFY_USER", columnDefinition = "VARCHAR2|修改人|50|", length = 50, nullable = true)
	private String modifyUser;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除标识|1|", length = 1, nullable = true)
	private Integer isDelete;

	@Column(name = "FLAG", columnDefinition = "VARCHAR2|类型|20|", length = 20, nullable = true)
	private String flag;

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

	public String getDevelopment() {
		return this.development;
	}

	public void setDevelopment(String development) {
		this.development = development;
	}

	public String getNutrition() {
		return this.nutrition;
	}

	public void setNutrition(String nutrition) {
		this.nutrition = nutrition;
	}

	public String getAnemia() {
		return this.anemia;
	}

	public void setAnemia(String anemia) {
		this.anemia = anemia;
	}

	public String getSystolicPressure() {
		return this.systolicPressure;
	}

	public void setSystolicPressure(String systolicPressure) {
		this.systolicPressure = systolicPressure;
	}

	public String getDiastolicPressure() {
		return this.diastolicPressure;
	}

	public void setDiastolicPressure(String diastolicPressure) {
		this.diastolicPressure = diastolicPressure;
	}

	public String getCardiacDullness() {
		return this.cardiacDullness;
	}

	public void setCardiacDullness(String cardiacDullness) {
		this.cardiacDullness = cardiacDullness;
	}

	public String getExpansion() {
		return this.expansion;
	}

	public void setExpansion(String expansion) {
		this.expansion = expansion;
	}

	public String getCardiacRhythm() {
		return this.cardiacRhythm;
	}

	public void setCardiacRhythm(String cardiacRhythm) {
		this.cardiacRhythm = cardiacRhythm;
	}

	public String getHeartRate() {
		return this.heartRate;
	}

	public void setHeartRate(String heartRate) {
		this.heartRate = heartRate;
	}

	public String getSouffle() {
		return this.souffle;
	}

	public void setSouffle(String souffle) {
		this.souffle = souffle;
	}

	public String getLungs() {
		return this.lungs;
	}

	public void setLungs(String lungs) {
		this.lungs = lungs;
	}

	public String getExternal() {
		return this.external;
	}

	public void setExternal(String external) {
		this.external = external;
	}

	public String getShiftingDullness() {
		return this.shiftingDullness;
	}

	public void setShiftingDullness(String shiftingDullness) {
		this.shiftingDullness = shiftingDullness;
	}

	public String getVenaEpigastrica() {
		return this.venaEpigastrica;
	}

	public void setVenaEpigastrica(String venaEpigastrica) {
		this.venaEpigastrica = venaEpigastrica;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getLabExamine() {
		return this.labExamine;
	}

	public void setLabExamine(String labExamine) {
		this.labExamine = labExamine;
	}

	public String getDiagnosis() {
		return this.diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getDrugs() {
		return this.drugs;
	}

	public void setDrugs(String drugs) {
		this.drugs = drugs;
	}

	public String getMeasure() {
		return this.measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public String getTotalMeasure() {
		return this.totalMeasure;
	}

	public void setTotalMeasure(String totalMeasure) {
		this.totalMeasure = totalMeasure;
	}

	public String getTreatmentCourse() {
		return this.treatmentCourse;
	}

	public void setTreatmentCourse(String treatmentCourse) {
		this.treatmentCourse = treatmentCourse;
	}

	public Date getTreatmentDt() {
		return this.treatmentDt;
	}

	public void setTreatmentDt(Date treatmentDt) {
		this.treatmentDt = treatmentDt;
	}

	public String getRealityDays() {
		return this.realityDays;
	}

	public void setRealityDays(String realityDays) {
		this.realityDays = realityDays;
	}

	public String getRealityMeasure() {
		return this.realityMeasure;
	}

	public void setRealityMeasure(String realityMeasure) {
		this.realityMeasure = realityMeasure;
	}

	public String getMeasureRate() {
		return this.measureRate;
	}

	public void setMeasureRate(String measureRate) {
		this.measureRate = measureRate;
	}

	public String getSideReaction() {
		return this.sideReaction;
	}

	public void setSideReaction(String sideReaction) {
		this.sideReaction = sideReaction;
	}

	public String getDiagnosisUnit() {
		return this.diagnosisUnit;
	}

	public void setDiagnosisUnit(String diagnosisUnit) {
		this.diagnosisUnit = diagnosisUnit;
	}

	public String getTreatmentDoctor() {
		return this.treatmentDoctor;
	}

	public void setTreatmentDoctor(String treatmentDoctor) {
		this.treatmentDoctor = treatmentDoctor;
	}

	public String getCreateUnit() {
		return this.createUnit;
	}

	public void setCreateUnit(String createUnit) {
		this.createUnit = createUnit;
	}

	public Date getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getModifyUnit() {
		return this.modifyUnit;
	}

	public void setModifyUnit(String modifyUnit) {
		this.modifyUnit = modifyUnit;
	}

	public Date getModifyDt() {
		return this.modifyDt;
	}

	public void setModifyDt(Date modifyDt) {
		this.modifyDt = modifyDt;
	}

	public String getModifyUser() {
		return this.modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * @return the treatmentType
	 */
	public String getTreatmentType() {
		return treatmentType;
	}

	/**
	 * @param treatmentType the treatmentType to set
	 */
	public void setTreatmentType(String treatmentType) {
		this.treatmentType = treatmentType;
	}

	/**
	 * @return the treatmentMoney
	 */
	public String getTreatmentMoney() {
		return treatmentMoney;
	}

	/**
	 * @param treatmentMoney the treatmentMoney to set
	 */
	public void setTreatmentMoney(String treatmentMoney) {
		this.treatmentMoney = treatmentMoney;
	}

	/**
	 * @return the lapseto
	 */
	public String getLapseto() {
		return lapseto;
	}

	/**
	 * @param lapseto the lapseto to set
	 */
	public void setLapseto(String lapseto) {
		this.lapseto = lapseto;
	}

}