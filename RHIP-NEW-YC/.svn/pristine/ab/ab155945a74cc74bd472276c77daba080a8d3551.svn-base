package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "DM_DIABETIC_FOLLOWUP")
public class DiabeticFollowup implements Serializable {

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

    @Column(name = "OTHER_SYMPTOM", columnDefinition = "VARCHAR2|其他症状描述||", length = 20, nullable = true)
    private String otherSymptom;

    @Column(name = "HEIGHT", columnDefinition = "VARCHAR2|身高(cm)||", length = 100, nullable = true)
    private String height;

    @Column(name = "BODY_WEIGHT", columnDefinition = "VARCHAR2|体重(kg)||", length = 100, nullable = true)
    private String bodyWeight;

    @Column(name = "SBP", columnDefinition = "NUMBER|收缩压(mmHg)||", scale = 5, precision = 2, nullable = true)
    private BigDecimal sbp;

    @Column(name = "DBP", columnDefinition = "VARCHAR2|舒张压(mmHg)||", length = 100, nullable = true)
    private String dbp;

    @Column(name = "ARTERIOPALMUS", columnDefinition = "NUMBER|足背动脉搏动标志||", scale = 5, precision = 1, nullable = true)
    private BigDecimal arteriopalmus;

    @Column(name = "DAILY_SMOKE", columnDefinition = "NUMBER|日吸烟量(支)||", scale = 5, precision = 1, nullable = true)
    private BigDecimal dailySmoke;

    @Column(name = "DAILY_DRINK", columnDefinition = "NUMBER|日饮酒量(两)||", scale = 5, precision = 1, nullable = true)
    private BigDecimal dailyDrink;

    @Column(name = "TRAIN_FREQUENCY_TYPE_CODE", columnDefinition = "NUMBER|运动频率代码||", scale = 5, precision = 1, nullable = true)
    private BigDecimal trainFrequencyTypeCode;

    @Column(name = "TRAINING_MIN", columnDefinition = "NUMBER|每次运动时长(min)||", length = 5, nullable = true)
    private Integer trainingMin;

    @Column(name = "DAILY_RICE", columnDefinition = "NUMBER|日主食量(g)||", length = 5, nullable = true)
    private Integer dailyrice;

    @Column(name = "MENTALITY", columnDefinition = "NUMBER|心理调整评价代码||", length = 5, nullable = true)
    private Integer mentality;

    @Column(name = "COMPIANCE", columnDefinition = "NUMBER|遵医行为评价代码||", length = 5, nullable = true)
    private Integer compiance;

    @Column(name = "FPG", columnDefinition = "NUMBER|空腹血糖值(mmol/L)||", length = 5, nullable = true)
    private Integer fpg;

    @Column(name = "GLU_VALUE", columnDefinition = "VARCHAR2|餐后2小时血糖值(mmol/L)||", length = 1, nullable = true)
    private String gluValue;

    @Column(name = "LOW_EFFECTS", columnDefinition = "NUMBER|低血糖反应代码||", length = 5, nullable = true)
    private Integer lowEffects;

    @Column(name = "HGB", columnDefinition = "VARCHAR2|糖化血红蛋白值(%)||", length = 1, nullable = true)
    private String hgb;

    @Column(name = "SUB_CHECK", columnDefinition = "VARCHAR2|其他辅助检查描述||", length = 1, nullable = true)
    private String subCheck;

    @Column(name = "MEDICATION_COMPLIANCE", columnDefinition = "VARCHAR2|服药依从性代码||", length = 1, nullable = true)
    private String medicationCompliance;

    @Column(name = "SIDE_EFFECTS", columnDefinition = "VARCHAR2|药物不良反应标志||", length = 100, nullable = true)
    private String sideEffects;

    @Column(name = "EFFECTS_STATE", columnDefinition = "VARCHAR2|药物不良反应描述||", length = 1, nullable = true)
    private String effectsState;

    @Column(name = "VISIT_TYPE", columnDefinition = "VARCHAR2|随访评价结果代码||", length = 1, nullable = true)
    private String visitType;

    @Column(name = "INSULIN_TYPE", columnDefinition = "VARCHAR2|胰岛素用药种类||", length = 100, nullable = true)
    private String insulinType;

    @Column(name = "INSULIN_FREQUENCY", columnDefinition = "VARCHAR2|胰岛素用药使用频率(次/d)||", length = 1, nullable = true)
    private String insulinFrequency;

    @Column(name = "INSULIN_DOSE", columnDefinition = "VARCHAR2|胰岛素用药次剂量(U)||", length = 1, nullable = true)
    private String insulinDose;

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

    @Column(name = "IS_SYMPTOM_CHRONIC_COUGH", columnDefinition = "VARCHAR2|慢性咳嗽、咳痰≥2周|FS10238|", length = 2, nullable = true)
    private String isSymptomChronicCough;

    @Column(name = "IS_HEMOSPUTUM", columnDefinition = "VARCHAR2|咯血、血痰|FS10238|", length = 2, nullable = true)
    private String isHemosputum;

    @Column(name = "IS_SYMPTOM_CHEST_PAIN", columnDefinition = "VARCHAR2|发热、盗汗、胸痛或不明原因消瘦≥2周|FS10238|", length = 2, nullable = true)
    private String isSymptomChestPain;

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

    public String getHeight() {
        return this.height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getBodyWeight() {
        return this.bodyWeight;
    }

    public void setBodyWeight(String bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    public BigDecimal getSbp() {
        return this.sbp;
    }

    public void setSbp(BigDecimal sbp) {
        this.sbp = sbp;
    }

    public String getDbp() {
        return this.dbp;
    }

    public void setDbp(String dbp) {
        this.dbp = dbp;
    }

    public BigDecimal getArteriopalmus() {
        return this.arteriopalmus;
    }

    public void setArteriopalmus(BigDecimal arteriopalmus) {
        this.arteriopalmus = arteriopalmus;
    }

    public BigDecimal getDailySmoke() {
        return this.dailySmoke;
    }

    public void setDailySmoke(BigDecimal dailySmoke) {
        this.dailySmoke = dailySmoke;
    }

    public BigDecimal getDailyDrink() {
        return this.dailyDrink;
    }

    public void setDailyDrink(BigDecimal dailyDrink) {
        this.dailyDrink = dailyDrink;
    }

    public BigDecimal getTrainFrequencyTypeCode() {
        return this.trainFrequencyTypeCode;
    }

    public void setTrainFrequencyTypeCode(BigDecimal trainFrequencyTypeCode) {
        this.trainFrequencyTypeCode = trainFrequencyTypeCode;
    }

    public Integer getTrainingMin() {
        return this.trainingMin;
    }

    public void setTrainingMin(Integer trainingMin) {
        this.trainingMin = trainingMin;
    }

    public Integer getDailyrice() {
        return this.dailyrice;
    }

    public void setDailyrice(Integer dailyrice) {
        this.dailyrice = dailyrice;
    }

    public Integer getMentality() {
        return this.mentality;
    }

    public void setMentality(Integer mentality) {
        this.mentality = mentality;
    }

    public Integer getCompiance() {
        return this.compiance;
    }

    public void setCompiance(Integer compiance) {
        this.compiance = compiance;
    }

    public Integer getFpg() {
        return this.fpg;
    }

    public void setFpg(Integer fpg) {
        this.fpg = fpg;
    }

    public String getGluValue() {
        return this.gluValue;
    }

    public void setGluValue(String gluValue) {
        this.gluValue = gluValue;
    }

    public Integer getLowEffects() {
        return this.lowEffects;
    }

    public void setLowEffects(Integer lowEffects) {
        this.lowEffects = lowEffects;
    }

    public String getHgb() {
        return this.hgb;
    }

    public void setHgb(String hgb) {
        this.hgb = hgb;
    }

    public String getSubCheck() {
        return this.subCheck;
    }

    public void setSubCheck(String subCheck) {
        this.subCheck = subCheck;
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

    public String getInsulinType() {
        return this.insulinType;
    }

    public void setInsulinType(String insulinType) {
        this.insulinType = insulinType;
    }

    public String getInsulinFrequency() {
        return this.insulinFrequency;
    }

    public void setInsulinFrequency(String insulinFrequency) {
        this.insulinFrequency = insulinFrequency;
    }

    public String getInsulinDose() {
        return this.insulinDose;
    }

    public void setInsulinDose(String insulinDose) {
        this.insulinDose = insulinDose;
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

    public String getIsSymptomChronicCough() {
        return isSymptomChronicCough;
    }

    public void setIsSymptomChronicCough(String isSymptomChronicCough) {
        this.isSymptomChronicCough = isSymptomChronicCough;
    }

    public String getIsHemosputum() {
        return isHemosputum;
    }

    public void setIsHemosputum(String isHemosputum) {
        this.isHemosputum = isHemosputum;
    }

    public String getIsSymptomChestPain() {
        return isSymptomChestPain;
    }

    public void setIsSymptomChestPain(String isSymptomChestPain) {
        this.isSymptomChestPain = isSymptomChestPain;
    }
}
