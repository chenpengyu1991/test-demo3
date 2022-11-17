package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "DM_DEFORMITY_PERSON_FOLLOWUP")
public class DeformityPersonFollowup implements Serializable {

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

    @Column(name = "HEIGHT", columnDefinition = "NUMBER|身高(cm)||", length = 5, nullable = true)
    private Integer height;

    @Column(name = "BODY_WEIGHT", columnDefinition = "NUMBER|体重(kg)||", scale = 5, precision = 1, nullable = true)
    private BigDecimal bodyWeight;

    @Column(name = "SBP", columnDefinition = "NUMBER|收缩压(mmHg)||", length = 5, nullable = true)
    private Integer sbp;

    @Column(name = "DBP", columnDefinition = "NUMBER|舒张压(mmHg)||", length = 5, nullable = true)
    private Integer dbp;

    @Column(name = "TEMPERATURE", columnDefinition = "NUMBER|体温(℃)||", scale = 4, precision = 1, nullable = true)
    private BigDecimal temperature;

    @Column(name = "PULSE_RATE", columnDefinition = "NUMBER|脉率(次/min)||", length = 5, nullable = true)
    private Integer pulseRate;

    @Column(name = "VISUAL", columnDefinition = "VARCHAR2|有无视力障碍||", length = 1, nullable = true)
    private String visual;

    @Column(name = "DYSAUDIA", columnDefinition = "VARCHAR2|有无听力障碍||", length = 1, nullable = true)
    private String dysaudia;

    @Column(name = "DYSGNOSIA", columnDefinition = "VARCHAR2|有无智力障碍||", length = 1, nullable = true)
    private String dysgnosia;

    @Column(name = "MENTAL", columnDefinition = "VARCHAR2|有无精神障碍||", length = 1, nullable = true)
    private String mental;

    @Column(name = "LANGUAGE", columnDefinition = "VARCHAR2|有无语言障碍||", length = 1, nullable = true)
    private String language;

    @Column(name = "WALKING", columnDefinition = "VARCHAR2|有无行走障碍||", length = 1, nullable = true)
    private String walking;

    @Column(name = "WORK", columnDefinition = "VARCHAR2|有无劳动障碍||", length = 1, nullable = true)
    private String work;

    @Column(name = "SELFCARE", columnDefinition = "VARCHAR2|有无自理障碍||", length = 1, nullable = true)
    private String selfcare;

    @Column(name = "RECOVERY", columnDefinition = "VARCHAR2|康复服务情况代码组合||", length = 100, nullable = true)
    private String recovery;

    @Column(name = "REFERRAL_REASON", columnDefinition = "VARCHAR2|转介原因||", length = 100, nullable = true)
    private String referralReason;

    @Column(name = "REFERRAL", columnDefinition = "VARCHAR2|转介去向||", length = 100, nullable = true)
    private String referral;

    @Column(name = "TRAINING_MONTH", columnDefinition = "NUMBER|功能训练(次/月)||", length = 5, nullable = true)
    private Integer trainingMonth;

    @Column(name = "TRAINING_TIME", columnDefinition = "NUMBER|训练时间(分钟)||", length = 5, nullable = true)
    private Integer trainingTime;

    @Column(name = "TRAINING_GROUND", columnDefinition = "VARCHAR2|训练场地代码||", length = 1, nullable = true)
    private String trainingGround;

    @Column(name = "TRAINING_EFFECT", columnDefinition = "VARCHAR2|训练效果代码||", length = 1, nullable = true)
    private String trainingEffect;

    @Column(name = "RECOVERY_AIM", columnDefinition = "VARCHAR2|康复目标代码组合||", length = 100, nullable = true)
    private String recoveryAim;

    @Column(name = "COMPIANCE", columnDefinition = "VARCHAR2|遵医行为评价代码||", length = 1, nullable = true)
    private String compiance;

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

    public Integer getHeight() {
        return this.height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public BigDecimal getBodyWeight() {
        return this.bodyWeight;
    }

    public void setBodyWeight(BigDecimal bodyWeight) {
        this.bodyWeight = bodyWeight;
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

    public BigDecimal getTemperature() {
        return this.temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public Integer getPulseRate() {
        return this.pulseRate;
    }

    public void setPulseRate(Integer pulseRate) {
        this.pulseRate = pulseRate;
    }

    public String getVisual() {
        return this.visual;
    }

    public void setVisual(String visual) {
        this.visual = visual;
    }

    public String getDysaudia() {
        return this.dysaudia;
    }

    public void setDysaudia(String dysaudia) {
        this.dysaudia = dysaudia;
    }

    public String getDysgnosia() {
        return this.dysgnosia;
    }

    public void setDysgnosia(String dysgnosia) {
        this.dysgnosia = dysgnosia;
    }

    public String getMental() {
        return this.mental;
    }

    public void setMental(String mental) {
        this.mental = mental;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getWalking() {
        return this.walking;
    }

    public void setWalking(String walking) {
        this.walking = walking;
    }

    public String getWork() {
        return this.work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getSelfcare() {
        return this.selfcare;
    }

    public void setSelfcare(String selfcare) {
        this.selfcare = selfcare;
    }

    public String getRecovery() {
        return this.recovery;
    }

    public void setRecovery(String recovery) {
        this.recovery = recovery;
    }

    public String getReferralReason() {
        return this.referralReason;
    }

    public void setReferralReason(String referralReason) {
        this.referralReason = referralReason;
    }

    public String getReferral() {
        return this.referral;
    }

    public void setReferral(String referral) {
        this.referral = referral;
    }

    public Integer getTrainingMonth() {
        return this.trainingMonth;
    }

    public void setTrainingMonth(Integer trainingMonth) {
        this.trainingMonth = trainingMonth;
    }

    public Integer getTrainingTime() {
        return this.trainingTime;
    }

    public void setTrainingTime(Integer trainingTime) {
        this.trainingTime = trainingTime;
    }

    public String getTrainingGround() {
        return this.trainingGround;
    }

    public void setTrainingGround(String trainingGround) {
        this.trainingGround = trainingGround;
    }

    public String getTrainingEffect() {
        return this.trainingEffect;
    }

    public void setTrainingEffect(String trainingEffect) {
        this.trainingEffect = trainingEffect;
    }

    public String getRecoveryAim() {
        return this.recoveryAim;
    }

    public void setRecoveryAim(String recoveryAim) {
        this.recoveryAim = recoveryAim;
    }

    public String getCompiance() {
        return this.compiance;
    }

    public void setCompiance(String compiance) {
        this.compiance = compiance;
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
