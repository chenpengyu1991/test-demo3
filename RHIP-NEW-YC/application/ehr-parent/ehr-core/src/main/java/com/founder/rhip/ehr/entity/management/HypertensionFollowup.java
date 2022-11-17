package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "DM_HYPERTENSION_FOLLOWUP")
public class HypertensionFollowup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "SMPI_ID", columnDefinition = "VARCHAR2|PIX号||", length = 50, nullable = true)
    private String smpiId;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = false)
    private String ehrId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|记录表单编号||", length = 20, nullable = false)
    private String recordNumber;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|居民身份证/健康卡号||", length = 18, nullable = false)
    private String idcard;

    @Column(name = "VISIT_DATE", columnDefinition = "DATE|本次随访日期||", nullable = true)
    private Date visitDate;

    @Column(name = "VISIT_WAY_CODE", columnDefinition = "VARCHAR2|随访方式代码||", length = 1, nullable = true)
    private String visitWayCode;

    @Column(name = "CUR_SYMPTOM", columnDefinition = "VARCHAR2|症状代码组合||", length = 200, nullable = true)
    private String curSymptom;

    @Column(name = "OTHER_SYMPTOM", columnDefinition = "VARCHAR2|其他症状描述||", length = 100, nullable = true)
    private String otherSymptom;

    @Column(name = "OTHER_BODY_CHARACTERISTICS", columnDefinition = "VARCHAR2|体征其他||", length = 100, nullable = true)
    private String otherBodyCharacteristics;

    @Column(name = "INDEX_OF_BODY_CHARACTERISTICS", columnDefinition = "NUMBER|体质指数||", scale = 5, precision = 2, nullable = true)
    private BigDecimal indexOfBodyCharacteristics;

    @Column(name = "TURN_SICKNESS_REASON", columnDefinition = "VARCHAR2|转症原因||", length = 100, nullable = true)
    private String turnSicknessReason;

    @Column(name = "HEIGHT", columnDefinition = "NUMBER|身高(cm)||", scale = 5, precision = 1, nullable = true)
    private BigDecimal height;

    @Column(name = "BODY_WEIGHT", columnDefinition = "NUMBER|体重(kg)||", scale = 5, precision = 1, nullable = true)
    private BigDecimal bodyWeight;

    @Column(name = "HIP", columnDefinition = "NUMBER|臀围(cm)||", scale = 5, precision = 1, nullable = true)
    private BigDecimal hip;

    @Column(name = "WAOSTLINE", columnDefinition = "NUMBER|腰围(cm)||", scale = 5, precision = 1, nullable = true)
    private BigDecimal waostline;

    @Column(name = "SBP", columnDefinition = "NUMBER|收缩压(mmHg)||", length = 5, nullable = true)
    private Integer sbp;

    @Column(name = "DBP", columnDefinition = "NUMBER|舒张压(mmHg)||", length = 5, nullable = true)
    private Integer dbp;

    @Column(name = "HEART_RATE", columnDefinition = "NUMBER|心率(次/min)||", length = 5, nullable = true)
    private Integer heartRate;

    @Column(name = "DAILY_SMOKE", columnDefinition = "NUMBER|日吸烟量(支)||", length = 5, nullable = true)
    private Integer dailySmoke;

    @Column(name = "DAILY_DRINK", columnDefinition = "NUMBER|日饮酒量(两)||", length = 5, nullable = true)
    private Integer dailyDrink;

    @Column(name = "TRAIN_FREQUENCY_TYPE_CODE", columnDefinition = "VARCHAR2|运动频率代码||", length = 1, nullable = true)
    private String trainFrequencyTypeCode;

    @Column(name = "TRAINING_MIN", columnDefinition = "NUMBER|每次锻炼时间(min)||", length = 5, nullable = true)
    private Integer trainingMin;

    @Column(name = "SALT_CLASSIFICATION_CODE", columnDefinition = "VARCHAR2|摄盐量分级代码||", length = 1, nullable = true)
    private String saltClassificationCode;

    @Column(name = "MENTALITY", columnDefinition = "VARCHAR2|心理调整评价代码||", length = 1, nullable = true)
    private String mentality;

    @Column(name = "COMPIANCE", columnDefinition = "VARCHAR2|遵医行为评价代码||", length = 1, nullable = true)
    private String compiance;

    @Column(name = "AE_RESULT_DESC", columnDefinition = "VARCHAR2|辅助检查结果描述||", length = 100, nullable = true)
    private String aeResultDesc;

    @Column(name = "MEDICATION_COMPLIANCE", columnDefinition = "VARCHAR2|服药依从性代码||", length = 1, nullable = true)
    private String medicationCompliance;

    @Column(name = "SIDE_EFFECTS", columnDefinition = "VARCHAR2|药物不良反应标志||", length = 1, nullable = true)
    private String sideEffects;

    @Column(name = "EFFECTS_STATE", columnDefinition = "VARCHAR2|药物不良反应描述||", length = 100, nullable = true)
    private String effectsState;

    @Column(name = "VISIT_TYPE", columnDefinition = "VARCHAR2|随访评价结果代码||", length = 1, nullable = true)
    private String visitType;

    @Column(name = "CHINESE_MEDICINE_TYPE", columnDefinition = "VARCHAR2|中药类别代码||", length = 1, nullable = true)
    private String chineseMedicineType;

    @Column(name = "DRUG_CODE1", columnDefinition = "VARCHAR2|第一种药物编码||", length = 12, nullable = true)
    private String drugCode1;

    @Column(name = "DRUG_NAME1", columnDefinition = "VARCHAR2|第一种药物名称||", length = 50, nullable = true)
    private String drugName1;

    @Column(name = "DRUG_PERDAY1", columnDefinition = "NUMBER|第一种药物使用频率||", length = 5, nullable = true)
    private Integer drugPerday1;

    @Column(name = "DRUG_PERTIME1", columnDefinition = "NUMBER|第一种药物每次剂量||", length = 5, nullable = true)
    private Integer drugPertime1;

    @Column(name = "DRUG_CODE2", columnDefinition = "VARCHAR2|第二种药物编码||", length = 12, nullable = true)
    private String drugCode2;

    @Column(name = "DRUG_NAME2", columnDefinition = "VARCHAR2|第二种药物名称||", length = 50, nullable = true)
    private String drugName2;

    @Column(name = "DRUG_PERDAY2", columnDefinition = "NUMBER|第二种药物使用频率||", length = 5, nullable = true)
    private Integer drugPerday2;

    @Column(name = "DRUG_PERTIME2", columnDefinition = "NUMBER|第二种药物每次剂量||", length = 5, nullable = true)
    private Integer drugPertime2;

    @Column(name = "DRUG_CODE3", columnDefinition = "VARCHAR2|第三种药物编码||", length = 12, nullable = true)
    private String drugCode3;

    @Column(name = "DRUG_NAME3", columnDefinition = "VARCHAR2|第三种药物名称||", length = 50, nullable = true)
    private String drugName3;

    @Column(name = "DRUG_PERDAY3", columnDefinition = "NUMBER|第三种药物使用频率||", length = 5, nullable = true)
    private Integer drugPerday3;

    @Column(name = "DRUG_PERTIME3", columnDefinition = "NUMBER|第三种药物每次剂量||", length = 5, nullable = true)
    private Integer drugPertime3;

    @Column(name = "NEXT_SUPERVISION_DATE", columnDefinition = "DATE|下次随访日期||", nullable = true)
    private Date nextSupervisionDate;

    @Column(name = "INPUT_ORGAN_CODE", columnDefinition = "VARCHAR2|随访机构编码||", length = 15, nullable = true)
    private String inputOrganCode;

    @Column(name = "INPUT_ORGAN_NAME", columnDefinition = "VARCHAR2|随访机构名称||", length = 70, nullable = true)
    private String inputOrganName;

    @Column(name = "INPUT_IDCARD", columnDefinition = "VARCHAR2|随访人身份证号||", length = 18, nullable = true)
    private String inputIdcard;

    @Column(name = "INPUT_NAME", columnDefinition = "VARCHAR2|随访人姓名||", length = 50, nullable = true)
    private String inputName;

    @Column(name = "INPUT_DATE", columnDefinition = "TIMESTAMP|录入日期和时间||", nullable = true)
    private Date inputDate;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getRecordNumber() {
        return this.recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public String getIdcard() {
        return this.idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Date getVisitDate() {
        return this.visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getVisitWayCode() {
        return this.visitWayCode;
    }

    public void setVisitWayCode(String visitWayCode) {
        this.visitWayCode = visitWayCode;
    }

    public String getCurSymptom() {
        return this.curSymptom;
    }

    public void setCurSymptom(String curSymptom) {
        this.curSymptom = curSymptom;
    }

    public String getOtherSymptom() {
        return this.otherSymptom;
    }

    public void setOtherSymptom(String otherSymptom) {
        this.otherSymptom = otherSymptom;
    }

    public String getOtherBodyCharacteristics() {
        return this.otherBodyCharacteristics;
    }

    public void setOtherBodyCharacteristics(String otherBodyCharacteristics) {
        this.otherBodyCharacteristics = otherBodyCharacteristics;
    }

    public BigDecimal getIndexOfBodyCharacteristics() {
        return this.indexOfBodyCharacteristics;
    }

    public void setIndexOfBodyCharacteristics(BigDecimal indexOfBodyCharacteristics) {
        this.indexOfBodyCharacteristics = indexOfBodyCharacteristics;
    }

    public String getTurnSicknessReason() {
        return this.turnSicknessReason;
    }

    public void setTurnSicknessReason(String turnSicknessReason) {
        this.turnSicknessReason = turnSicknessReason;
    }

    public BigDecimal getHeight() {
        return this.height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getBodyWeight() {
        return this.bodyWeight;
    }

    public void setBodyWeight(BigDecimal bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    public BigDecimal getHip() {
        return this.hip;
    }

    public void setHip(BigDecimal hip) {
        this.hip = hip;
    }

    public BigDecimal getWaostline() {
        return this.waostline;
    }

    public void setWaostline(BigDecimal waostline) {
        this.waostline = waostline;
    }

    public Integer getSbp() {
        return this.sbp;
    }

    public void setSbp(Integer sbp) {
        this.sbp = sbp;
    }

    public Integer getDbp() {
        return this.dbp;
    }

    public void setDbp(Integer dbp) {
        this.dbp = dbp;
    }

    public Integer getHeartRate() {
        return this.heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public Integer getDailySmoke() {
        return this.dailySmoke;
    }

    public void setDailySmoke(Integer dailySmoke) {
        this.dailySmoke = dailySmoke;
    }

    public Integer getDailyDrink() {
        return this.dailyDrink;
    }

    public void setDailyDrink(Integer dailyDrink) {
        this.dailyDrink = dailyDrink;
    }

    public String getTrainFrequencyTypeCode() {
        return this.trainFrequencyTypeCode;
    }

    public void setTrainFrequencyTypeCode(String trainFrequencyTypeCode) {
        this.trainFrequencyTypeCode = trainFrequencyTypeCode;
    }

    public Integer getTrainingMin() {
        return this.trainingMin;
    }

    public void setTrainingMin(Integer trainingMin) {
        this.trainingMin = trainingMin;
    }

    public String getSaltClassificationCode() {
        return this.saltClassificationCode;
    }

    public void setSaltClassificationCode(String saltClassificationCode) {
        this.saltClassificationCode = saltClassificationCode;
    }

    public String getMentality() {
        return this.mentality;
    }

    public void setMentality(String mentality) {
        this.mentality = mentality;
    }

    public String getCompiance() {
        return this.compiance;
    }

    public void setCompiance(String compiance) {
        this.compiance = compiance;
    }

    public String getAeResultDesc() {
        return this.aeResultDesc;
    }

    public void setAeResultDesc(String aeResultDesc) {
        this.aeResultDesc = aeResultDesc;
    }

    public String getMedicationCompliance() {
        return this.medicationCompliance;
    }

    public void setMedicationCompliance(String medicationCompliance) {
        this.medicationCompliance = medicationCompliance;
    }

    public String getSideEffects() {
        return this.sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public String getEffectsState() {
        return this.effectsState;
    }

    public void setEffectsState(String effectsState) {
        this.effectsState = effectsState;
    }

    public String getVisitType() {
        return this.visitType;
    }

    public void setVisitType(String visitType) {
        this.visitType = visitType;
    }

    public String getChineseMedicineType() {
        return this.chineseMedicineType;
    }

    public void setChineseMedicineType(String chineseMedicineType) {
        this.chineseMedicineType = chineseMedicineType;
    }

    public String getDrugCode1() {
        return this.drugCode1;
    }

    public void setDrugCode1(String drugCode1) {
        this.drugCode1 = drugCode1;
    }

    public String getDrugName1() {
        return this.drugName1;
    }

    public void setDrugName1(String drugName1) {
        this.drugName1 = drugName1;
    }

    public Integer getDrugPerday1() {
        return this.drugPerday1;
    }

    public void setDrugPerday1(Integer drugPerday1) {
        this.drugPerday1 = drugPerday1;
    }

    public Integer getDrugPertime1() {
        return this.drugPertime1;
    }

    public void setDrugPertime1(Integer drugPertime1) {
        this.drugPertime1 = drugPertime1;
    }

    public String getDrugCode2() {
        return this.drugCode2;
    }

    public void setDrugCode2(String drugCode2) {
        this.drugCode2 = drugCode2;
    }

    public String getDrugName2() {
        return this.drugName2;
    }

    public void setDrugName2(String drugName2) {
        this.drugName2 = drugName2;
    }

    public Integer getDrugPerday2() {
        return this.drugPerday2;
    }

    public void setDrugPerday2(Integer drugPerday2) {
        this.drugPerday2 = drugPerday2;
    }

    public Integer getDrugPertime2() {
        return this.drugPertime2;
    }

    public void setDrugPertime2(Integer drugPertime2) {
        this.drugPertime2 = drugPertime2;
    }

    public String getDrugCode3() {
        return this.drugCode3;
    }

    public void setDrugCode3(String drugCode3) {
        this.drugCode3 = drugCode3;
    }

    public String getDrugName3() {
        return this.drugName3;
    }

    public void setDrugName3(String drugName3) {
        this.drugName3 = drugName3;
    }

    public Integer getDrugPerday3() {
        return this.drugPerday3;
    }

    public void setDrugPerday3(Integer drugPerday3) {
        this.drugPerday3 = drugPerday3;
    }

    public Integer getDrugPertime3() {
        return this.drugPertime3;
    }

    public void setDrugPertime3(Integer drugPertime3) {
        this.drugPertime3 = drugPertime3;
    }

    public Date getNextSupervisionDate() {
        return this.nextSupervisionDate;
    }

    public void setNextSupervisionDate(Date nextSupervisionDate) {
        this.nextSupervisionDate = nextSupervisionDate;
    }

    public String getInputOrganCode() {
        return this.inputOrganCode;
    }

    public void setInputOrganCode(String inputOrganCode) {
        this.inputOrganCode = inputOrganCode;
    }

    public String getInputOrganName() {
        return this.inputOrganName;
    }

    public void setInputOrganName(String inputOrganName) {
        this.inputOrganName = inputOrganName;
    }

    public String getInputIdcard() {
        return this.inputIdcard;
    }

    public void setInputIdcard(String inputIdcard) {
        this.inputIdcard = inputIdcard;
    }

    public String getInputName() {
        return this.inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public Date getInputDate() {
        return this.inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getEhrId() {
        return ehrId;
    }

    public void setEhrId(String ehrId) {
        this.ehrId = ehrId;
    }


    public String getSmpiId() {
        return smpiId;
    }

    public void setSmpiId(String smpiId) {
        this.smpiId = smpiId;
    }

}
