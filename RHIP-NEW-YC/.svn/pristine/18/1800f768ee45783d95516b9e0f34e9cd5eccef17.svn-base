package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "DM_RISK_FACTOR_FOLLOWUP")
public class RiskFactorFollowup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "SMPI_ID", columnDefinition = "VARCHAR2|PIX号||", length = 50, nullable = true)
    private String smpiId;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = false)
    private String ehrId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|记录表单编号||", length = 20, nullable = true)
    private String recordNumber;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|居民身份证/健康卡号||", length = 18, nullable = true)
    private String idcard;

    @Column(name = "SMOK_FREQUENCY_CODE", columnDefinition = "VARCHAR2|吸烟频率代码||", length = 1, nullable = true)
    private String smokFrequencyCode;

    @Column(name = "SMOKE_AGE", columnDefinition = "NUMBER|开始吸烟年龄(岁)||", length = 5, nullable = true)
    private Integer smokeAges;

    @Column(name = "START_SMOKE_AGE", columnDefinition = "NUMBER|开始每天吸烟年龄(岁)||", length = 5, nullable = true)
    private Integer startSmokeAge;

    @Column(name = "SMOK_TOBACCO_TYPE_CODE", columnDefinition = "VARCHAR2|吸食烟草种类代码||", length = 1, nullable = true)
    private String smokTobaccoTypeCode;

    @Column(name = "DAILY_SMOKE", columnDefinition = "NUMBER|日吸烟量(支)||", length = 5, nullable = true)
    private Integer dailySmoke;

    @Column(name = "STOP_SMOKE_RUNTIME", columnDefinition = "NUMBER|停止吸烟时长(d)||", length = 5, nullable = true)
    private Integer stopSmokeRuntime;

    @Column(name = "QUIT_SMOKING_TYPE", columnDefinition = "VARCHAR2|戒烟方法类别代码||", length = 2, nullable = true)
    private String smokingCessationMethodTypeCode;

    @Column(name = "SECONDHAND_SMOKE_CDOE", columnDefinition = "VARCHAR2|接触二手烟代码||", length = 1, nullable = true)
    private String secondhandSmokeCdoe;

    @Column(name = "SECONDHAND_SMOKE_DAYS", columnDefinition = "NUMBER|接触二手烟天数(d)||", length = 5, nullable = true)
    private Integer secondhandSmokeDays;

    @Column(name = "PASSIVE_SMOKE_TYPE", columnDefinition = "VARCHAR2|被动吸烟场所代码||", length = 1, nullable = true)
    private String passiveSmokeType;

    @Column(name = "DRINK_FLAG", columnDefinition = "CHAR|饮酒标志||", length = 1, nullable = true)
    private String drinkFlag;

    @Column(name = "DRINK_FREQUENCY", columnDefinition = "VARCHAR2|饮酒频率代码||", length = 1, nullable = true)
    private String drinkFrequency;

    @Column(name = "DRINK_TYPE", columnDefinition = "VARCHAR2|饮酒种类代码||", length = 1, nullable = true)
    private String drinkType;

    @Column(name = "DAILY_DRINK", columnDefinition = "NUMBER|日饮酒量(两)||", length = 5, nullable = true)
    private Integer dailyDrink;

    @Column(name = "DRINK_AGE", columnDefinition = "NUMBER|开始饮酒年龄(岁)||", length = 5, nullable = true)
    private Integer drinkAge;

    @Column(name = "DIET_TYPE_CODE", columnDefinition = "VARCHAR2|食物种类代码||", length = 1, nullable = true)
    private String dietTypeCode;

    @Column(name = "DIET_FREQUENCY", columnDefinition = "VARCHAR2|饮食频率分类代码||", length = 1, nullable = true)
    private String dietFrequency;

    @Column(name = "DAY_DIET_FREQ_TYPE", columnDefinition = "VARCHAR2|每天食用食物的频率类别代码||", length = 1, nullable = true)
    private String dayDietFreqType;

    @Column(name = "WEEK_DIET_FREQ_TYPE", columnDefinition = "VARCHAR2|每周食用食物的频率类别代码||", length = 1, nullable = true)
    private String weekDietFreqType;

    @Column(name = "MONTH_DIET_FREQ_TYPE", columnDefinition = "VARCHAR2|每月食用食物的频率类别代码||", length = 1, nullable = true)
    private String monthDietFreqType;

    @Column(name = "YEAR_DIET_FREQ_TYPE", columnDefinition = "VARCHAR2|每年食用的食物食用频率代码||", length = 1, nullable = true)
    private String yearDietFreqType;

    @Column(name = "BACTIVITY_TYPE_CODE", columnDefinition = "VARCHAR2|身体活动类别代码||", length = 1, nullable = true)
    private String bodyActivityTypeCode;

    @Column(name = "BACTIVITY_STRENGTH_TYPE_CODE", columnDefinition = "VARCHAR2|身体活动强度分类代码||", length = 1, nullable = true)
    private String bodyActivityStrengthTypeCode;

    @Column(name = "BACTIVITY_FREQUENCY_CODE", columnDefinition = "VARCHAR2|身体活动频率代码||", length = 1, nullable = true)
    private String bodyActivityFrequencyCode;

    @Column(name = "BACTIVITY_RUNTIME", columnDefinition = "NUMBER|身体活动时长(min)||", length = 5, nullable = true)
    private Integer bodyActivityRuntime;

    @Column(name = "CUMULATIVE_RUNTIME", columnDefinition = "NUMBER|步行或骑自行车累计时长(min)||", length = 5, nullable = true)
    private Integer cumulativeRuntime;

    @Column(name = "DAY_STATIC_BEHAVIOR_RUNTIME", columnDefinition = "NUMBER|日静态行为时长(min)||", length = 5, nullable = true)
    private Integer dayStaticBehaviorRuntime;

    @Column(name = "SLEEP_RUNTIME", columnDefinition = "NUMBER|全天睡眠时长(min)||", length = 5, nullable = true)
    private Integer sleepRuntime;

    @Column(name = "NIGHT_SLEEP_RUNTIME", columnDefinition = "NUMBER|晚上睡眠时长(min)||", length = 5, nullable = true)
    private Integer nightSleepRuntime;

    @Column(name = "SURVEY_NAME", columnDefinition = "VARCHAR2|调查人姓名||", length = 50, nullable = true)
    private String surveyName;

    @Column(name = "SURVEY_ORG_NAME", columnDefinition = "VARCHAR2|调查机构名称||", length = 70, nullable = true)
    private String surveyOrgName;

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

    public String getSmokFrequencyCode() {
        return this.smokFrequencyCode;
    }

    public void setSmokFrequencyCode(String smokFrequencyCode) {
        this.smokFrequencyCode = smokFrequencyCode;
    }

    public Integer getSmokeAges() {
        return this.smokeAges;
    }

    public void setSmokeAges(Integer smokeAges) {
        this.smokeAges = smokeAges;
    }

    public Integer getStartSmokeAge() {
        return this.startSmokeAge;
    }

    public void setStartSmokeAge(Integer startSmokeAge) {
        this.startSmokeAge = startSmokeAge;
    }

    public String getSmokTobaccoTypeCode() {
        return this.smokTobaccoTypeCode;
    }

    public void setSmokTobaccoTypeCode(String smokTobaccoTypeCode) {
        this.smokTobaccoTypeCode = smokTobaccoTypeCode;
    }

    public Integer getDailySmoke() {
        return this.dailySmoke;
    }

    public void setDailySmoke(Integer dailySmoke) {
        this.dailySmoke = dailySmoke;
    }

    public Integer getStopSmokeRuntime() {
        return this.stopSmokeRuntime;
    }

    public void setStopSmokeRuntime(Integer stopSmokeRuntime) {
        this.stopSmokeRuntime = stopSmokeRuntime;
    }

    public String getSmokingCessationMethodTypeCode() {
        return this.smokingCessationMethodTypeCode;
    }

    public void setSmokingCessationMethodTypeCode(String smokingCessationMethodTypeCode) {
        this.smokingCessationMethodTypeCode = smokingCessationMethodTypeCode;
    }

    public String getSecondhandSmokeCdoe() {
        return this.secondhandSmokeCdoe;
    }

    public void setSecondhandSmokeCdoe(String secondhandSmokeCdoe) {
        this.secondhandSmokeCdoe = secondhandSmokeCdoe;
    }

    public Integer getSecondhandSmokeDays() {
        return this.secondhandSmokeDays;
    }

    public void setSecondhandSmokeDays(Integer secondhandSmokeDays) {
        this.secondhandSmokeDays = secondhandSmokeDays;
    }

    public String getPassiveSmokeType() {
        return this.passiveSmokeType;
    }

    public void setPassiveSmokeType(String passiveSmokeType) {
        this.passiveSmokeType = passiveSmokeType;
    }

    public String getDrinkFlag() {
        return this.drinkFlag;
    }

    public void setDrinkFlag(String drinkFlag) {
        this.drinkFlag = drinkFlag;
    }

    public String getDrinkFrequency() {
        return this.drinkFrequency;
    }

    public void setDrinkFrequency(String drinkFrequency) {
        this.drinkFrequency = drinkFrequency;
    }

    public String getDrinkType() {
        return this.drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public Integer getDailyDrink() {
        return this.dailyDrink;
    }

    public void setDailyDrink(Integer dailyDrink) {
        this.dailyDrink = dailyDrink;
    }

    public Integer getDrinkAge() {
        return this.drinkAge;
    }

    public void setDrinkAge(Integer drinkAge) {
        this.drinkAge = drinkAge;
    }

    public String getDietTypeCode() {
        return this.dietTypeCode;
    }

    public void setDietTypeCode(String dietTypeCode) {
        this.dietTypeCode = dietTypeCode;
    }

    public String getDietFrequency() {
        return this.dietFrequency;
    }

    public void setDietFrequency(String dietFrequency) {
        this.dietFrequency = dietFrequency;
    }

    public String getDayDietFreqType() {
        return this.dayDietFreqType;
    }

    public void setDayDietFreqType(String dayDietFreqType) {
        this.dayDietFreqType = dayDietFreqType;
    }

    public String getWeekDietFreqType() {
        return this.weekDietFreqType;
    }

    public void setWeekDietFreqType(String weekDietFreqType) {
        this.weekDietFreqType = weekDietFreqType;
    }

    public String getMonthDietFreqType() {
        return this.monthDietFreqType;
    }

    public void setMonthDietFreqType(String monthDietFreqType) {
        this.monthDietFreqType = monthDietFreqType;
    }

    public String getYearDietFreqType() {
        return this.yearDietFreqType;
    }

    public void setYearDietFreqType(String yearDietFreqType) {
        this.yearDietFreqType = yearDietFreqType;
    }

    public String getBodyActivityTypeCode() {
        return this.bodyActivityTypeCode;
    }

    public void setBodyActivityTypeCode(String bodyActivityTypeCode) {
        this.bodyActivityTypeCode = bodyActivityTypeCode;
    }

    public String getBodyActivityStrengthTypeCode() {
        return this.bodyActivityStrengthTypeCode;
    }

    public void setBodyActivityStrengthTypeCode(String bodyActivityStrengthTypeCode) {
        this.bodyActivityStrengthTypeCode = bodyActivityStrengthTypeCode;
    }

    public String getBodyActivityFrequencyCode() {
        return this.bodyActivityFrequencyCode;
    }

    public void setBodyActivityFrequencyCode(String bodyActivityFrequencyCode) {
        this.bodyActivityFrequencyCode = bodyActivityFrequencyCode;
    }

    public Integer getBodyActivityRuntime() {
        return this.bodyActivityRuntime;
    }

    public void setBodyActivityRuntime(Integer bodyActivityRuntime) {
        this.bodyActivityRuntime = bodyActivityRuntime;
    }

    public Integer getCumulativeRuntime() {
        return this.cumulativeRuntime;
    }

    public void setCumulativeRuntime(Integer cumulativeRuntime) {
        this.cumulativeRuntime = cumulativeRuntime;
    }

    public Integer getDayStaticBehaviorRuntime() {
        return this.dayStaticBehaviorRuntime;
    }

    public void setDayStaticBehaviorRuntime(Integer dayStaticBehaviorRuntime) {
        this.dayStaticBehaviorRuntime = dayStaticBehaviorRuntime;
    }

    public Integer getSleepRuntime() {
        return this.sleepRuntime;
    }

    public void setSleepRuntime(Integer sleepRuntime) {
        this.sleepRuntime = sleepRuntime;
    }

    public Integer getNightSleepRuntime() {
        return this.nightSleepRuntime;
    }

    public void setNightSleepRuntime(Integer nightSleepRuntime) {
        this.nightSleepRuntime = nightSleepRuntime;
    }

    public String getSurveyName() {
        return this.surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public String getSurveyOrgName() {
        return this.surveyOrgName;
    }

    public void setSurveyOrgName(String surveyOrgName) {
        this.surveyOrgName = surveyOrgName;
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
