package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "DM_ELDERLY_HEALTH_FOLLOWUP")
public class ElderlyHealthFollowup implements Serializable {

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

    @Column(name = "BODY_WEIGHT", columnDefinition = "NUMBER|体重(kg)||", scale = 5, precision = 1, nullable = true)
    private BigDecimal bodyWeight;

    @Column(name = "PULSE_RATE", columnDefinition = "NUMBER|脉率(次/min)||", length = 5, nullable = true)
    private Integer pulseRate;

    @Column(name = "SBP", columnDefinition = "NUMBER|收缩压(mmHg)||", length = 5, nullable = true)
    private Integer sbp;

    @Column(name = "DBP", columnDefinition = "NUMBER|舒张压(mmHg)||", length = 5, nullable = true)
    private Integer dbp;

    @Column(name = "HARMONY", columnDefinition = "VARCHAR2|家庭和睦代码||", length = 1, nullable = true)
    private String harmony;

    @Column(name = "MOOD", columnDefinition = "VARCHAR2|每天心情代码||", length = 1, nullable = true)
    private String mood;

    @Column(name = "TRAINING", columnDefinition = "VARCHAR2|体育锻炼代码||", length = 1, nullable = true)
    private String training;

    @Column(name = "MEMORY", columnDefinition = "VARCHAR2|记忆力代码||", length = 1, nullable = true)
    private String memory;

    @Column(name = "LANGUAGE", columnDefinition = "VARCHAR2|语言表达能力代码||", length = 1, nullable = true)
    private String language;

    @Column(name = "MEALS", columnDefinition = "VARCHAR2|独立完成吃饭代码||", length = 1, nullable = true)
    private String meals;

    @Column(name = "DRESS", columnDefinition = "VARCHAR2|独立完成穿衣代码||", length = 1, nullable = true)
    private String dress;

    @Column(name = "BATH", columnDefinition = "VARCHAR2|独立完成洗澡代码||", length = 1, nullable = true)
    private String bath;

    @Column(name = "TOILET", columnDefinition = "VARCHAR2|独立去卫生间代码||", length = 1, nullable = true)
    private String toilet;

    @Column(name = "STAIRS", columnDefinition = "VARCHAR2|独立上下楼梯代码||", length = 1, nullable = true)
    private String stairs;

    @Column(name = "WHEELCHAIR", columnDefinition = "VARCHAR2|控制轮椅能力代码||", length = 1, nullable = true)
    private String wheelchair;

    @Column(name = "MEAL_RATIONALITY", columnDefinition = "VARCHAR2|饮食合理性评价||", length = 1, nullable = true)
    private String mealRationality;

    @Column(name = "HEALTH_PORERLOM", columnDefinition = "VARCHAR2|主要健康问题描述||", length = 400, nullable = true)
    private String healthPorerlom;

    @Column(name = "URINATE", columnDefinition = "VARCHAR2|小便能否自理||", length = 1, nullable = true)
    private String urinate;

    @Column(name = "CACATION", columnDefinition = "VARCHAR2|能否自行排便||", length = 1, nullable = true)
    private String cacation;

    @Column(name = "COMPIANCE", columnDefinition = "VARCHAR2|遵医行为评价代码||", length = 1, nullable = true)
    private String compiance;

    @Column(name = "OPINION", columnDefinition = "VARCHAR2|医生意见或建议||", length = 400, nullable = true)
    private String opinion;

    @Column(name = "HEALTH_EVALUATE", columnDefinition = "VARCHAR2|健康评价||", length = 1, nullable = true)
    private String healthEvaluate;

    @Column(name = "NEXT_SUPERVISION_DATE", columnDefinition = "DATE|下次访视日期||", nullable = true)
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

    public BigDecimal getBodyWeight() {
        return this.bodyWeight;
    }

    public void setBodyWeight(BigDecimal bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    public Integer getPulseRate() {
        return this.pulseRate;
    }

    public void setPulseRate(Integer pulseRate) {
        this.pulseRate = pulseRate;
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

    public String getHarmony() {
        return this.harmony;
    }

    public void setHarmony(String harmony) {
        this.harmony = harmony;
    }

    public String getMood() {
        return this.mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getTraining() {
        return this.training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public String getMemory() {
        return this.memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMeals() {
        return this.meals;
    }

    public void setMeals(String meals) {
        this.meals = meals;
    }

    public String getDress() {
        return this.dress;
    }

    public void setDress(String dress) {
        this.dress = dress;
    }

    public String getBath() {
        return this.bath;
    }

    public void setBath(String bath) {
        this.bath = bath;
    }

    public String getToilet() {
        return this.toilet;
    }

    public void setToilet(String toilet) {
        this.toilet = toilet;
    }

    public String getStairs() {
        return this.stairs;
    }

    public void setStairs(String stairs) {
        this.stairs = stairs;
    }

    public String getWheelchair() {
        return this.wheelchair;
    }

    public void setWheelchair(String wheelchair) {
        this.wheelchair = wheelchair;
    }

    public String getMealRationality() {
        return this.mealRationality;
    }

    public void setMealRationality(String mealRationality) {
        this.mealRationality = mealRationality;
    }

    public String getHealthPorerlom() {
        return this.healthPorerlom;
    }

    public void setHealthPorerlom(String healthPorerlom) {
        this.healthPorerlom = healthPorerlom;
    }

    public String getUrinate() {
        return this.urinate;
    }

    public void setUrinate(String urinate) {
        this.urinate = urinate;
    }

    public String getCacation() {
        return this.cacation;
    }

    public void setCacation(String cacation) {
        this.cacation = cacation;
    }

    public String getCompiance() {
        return this.compiance;
    }

    public void setCompiance(String compiance) {
        this.compiance = compiance;
    }

    public String getOpinion() {
        return this.opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getHealthEvaluate() {
        return this.healthEvaluate;
    }

    public void setHealthEvaluate(String healthEvaluate) {
        this.healthEvaluate = healthEvaluate;
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
