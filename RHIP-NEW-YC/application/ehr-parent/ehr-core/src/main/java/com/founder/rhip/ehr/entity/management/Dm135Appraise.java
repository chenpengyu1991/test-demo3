package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by haiyingjiang on 17/5/11.
 */
@Entity
@Table(name = "DM_135APPRAISE")
public class Dm135Appraise {

    @Id
    @Column(name ="ID",columnDefinition ="VARCHAR2|主键",length = 32, nullable = true)
    private String id;

    @Column(name ="PERSON_ID",columnDefinition ="VARCHAR2|健康档案外键",length = 32, nullable = true)
    private String personId;

    @Column(name ="ID_NO",columnDefinition ="VARCHAR2|身份证号",length = 30, nullable = true)
    private String idNo;

    @Column(name ="ME_NUMBER",columnDefinition ="VARCHAR2|体检编号",length = 32, nullable = true)
    private String meNumber;

    @Column(name ="ONE_B_PRESSURE",columnDefinition ="NUMBER|第一次随访血压1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer oneBPressure;

    @Column(name ="TWO_B_PRESSURE",columnDefinition ="NUMBER|第二次随访血压1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer twoBPressure;

    @Column(name ="THREE_B_PRESSURE",columnDefinition ="NUMBER|第三次随访血压1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer threeBPressure;

    @Column(name ="ONE_B_SUGAR",columnDefinition ="NUMBER|第一次随访血糖1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer oneBSugar;

    @Column(name ="TWO_B_SUGAR",columnDefinition ="NUMBER|第二次随访血糖1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer twoBSugar;

    @Column(name ="THREE_B_SUGAR",columnDefinition ="NUMBER|第三次随访血糖1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer threeBSugar;

    @Column(name ="ONE_WASITE_LINE",columnDefinition ="NUMBER|第一次随访腰围1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer oneWasiteLine;

    @Column(name ="TWO_WASITE_LINE",columnDefinition ="NUMBER|第二次随访腰围1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer twoWasiteLine;

    @Column(name ="THREE_WASITE_LINE",columnDefinition ="NUMBER|第三次随访腰围1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer threeWasiteLine;

    @Column(name ="ONE_HIPS",columnDefinition ="NUMBER|第一次随访臀围1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer oneHips;

    @Column(name ="TWO_HIPS",columnDefinition ="NUMBER|第二次随访臀围1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer twoHips;

    @Column(name ="THREE_HIPS",columnDefinition ="NUMBER|第三次随访臀围1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer threeHips;

    @Column(name ="ONE_BMI",columnDefinition ="NUMBER|第一次随访BMI1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer oneBmi;

    @Column(name ="TWO_BMI",columnDefinition ="NUMBER|第二次随访BMI1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer twoBmi;

    @Column(name ="THREE_BMI",columnDefinition ="NUMBER|第三次随访BMI1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer threeBmi;

    @Column(name ="ONE_WEIGHT",columnDefinition ="NUMBER|第一次随访体重1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer oneWeight;

    @Column(name ="TWO_WEIGHT",columnDefinition ="NUMBER|第二次随访体重1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer twoWeight;

    @Column(name ="THREE_WEIGHT",columnDefinition ="NUMBER|第三次随访体重1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer threeWeight;

    @Column(name ="ONE_TC",columnDefinition ="NUMBER|第一次随访总胆固醇1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer oneTc;

    @Column(name ="TWO_TC",columnDefinition ="NUMBER|第二次随访总胆固醇1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer twoTc;

    @Column(name ="THREE_TC",columnDefinition ="NUMBER|第三次随访总胆固醇1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer threeTc;

    @Column(name ="ONE_TG",columnDefinition ="NUMBER|第一次随访甘油三酯1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer oneTg;

    @Column(name ="TWO_TG",columnDefinition ="NUMBER|第二次随访甘油三酯1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer twoTg;

    @Column(name ="THREE_TG",columnDefinition ="NUMBER|第三次随访甘油三酯1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer threeTg;

    @Column(name ="ONE_HDLC",columnDefinition ="NUMBER|第一次随访高密度脂1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer oneHdlc;

    @Column(name ="TWO_HDLC",columnDefinition ="NUMBER|第二次随访高密度脂1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer twoHdlc;

    @Column(name ="THREE_HDLC",columnDefinition ="NUMBER|第三次随访高密度脂1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer threeHdlc;

    @Column(name ="ONE_LDLC",columnDefinition ="NUMBER|第一次随访低密度脂1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer oneLdlc;

    @Column(name ="TWO_LDLC",columnDefinition ="NUMBER|第二次随访低密度脂1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer twoLdlc;

    @Column(name ="THREE_LDLC",columnDefinition ="NUMBER|第三次随访低密度脂1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer threeLdlc;

    @Column(name ="ONE_SMOKE",columnDefinition ="NUMBER|第一次随访吸烟1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer oneSmoke;

    @Column(name ="TWO_SMOKE",columnDefinition ="NUMBER|第二次随访吸烟1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer twoSmoke;

    @Column(name ="THREE_SMOKE",columnDefinition ="NUMBER|第三次随访吸烟1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer threeSmoke;

    @Column(name ="ONE_DRINK",columnDefinition ="NUMBER|第一次随访饮酒1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer oneDrink;

    @Column(name ="TWO_DRINK",columnDefinition ="NUMBER|第二次随访饮酒1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer twoDrink;

    @Column(name ="THREE_DRINK",columnDefinition ="NUMBER|第三次随访饮酒1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer threeDrink;

    @Column(name ="ONE_DRINK_TEA",columnDefinition ="NUMBER|第一次随访喝茶1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer oneDrinkTea;

    @Column(name ="TWO_DRINK_TEA",columnDefinition ="NUMBER|第二次随访喝茶1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer twoDrinkTea;

    @Column(name ="THREE_DRINK_TEA",columnDefinition ="NUMBER|第三次随访喝茶1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer threeDrinkTea;

    @Column(name ="ONE_MEALS_TASTE",columnDefinition ="NUMBER|第一次随访膳食口味1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer one_mealsTaste;

    @Column(name ="TWO_MEALS_TASTE",columnDefinition ="NUMBER|第二次随访膳食口味1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer two_mealsTaste;

    @Column(name ="THREE_MEALS_TASTE",columnDefinition ="NUMBER|第三次随访膳食口味1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer three_mealsTaste;

    @Column(name ="ONE_FAT_DIET",columnDefinition ="NUMBER|第一次随访高脂膳食1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer oneFatDiet;

    @Column(name ="TWO_FAT_DIET",columnDefinition ="NUMBER|第二次随访高脂膳食1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer twoFatDiet;

    @Column(name ="THREE_FAT_DIET",columnDefinition ="NUMBER|第三次随访高脂膳食1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer threeFatDiet;

    @Column(name ="ONE_HOUSE_WORK",columnDefinition ="NUMBER|第一次随访家务劳动1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer oneHouseWork;

    @Column(name ="TWO_HOUSE_WORK",columnDefinition ="NUMBER|第二次随访家务劳动1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer twoHouseWork;

    @Column(name ="THREE_HOUSE_WORK",columnDefinition ="NUMBER|第三次随访家务劳动1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer threeHouseWork;

    @Column(name ="ONE_SPORT",columnDefinition ="NUMBER|第一次随访运动1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer oneSport;

    @Column(name ="TWO_SPORT",columnDefinition ="NUMBER|第二次随访运动1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer twoSport;

    @Column(name ="THREE_SPORT",columnDefinition ="NUMBER|第三次随访运动1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer threeSport;

    @Column(name ="ONE_RESTING",columnDefinition ="NUMBER|第一次随访静息1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer oneResting;

    @Column(name ="TWO_RESTING",columnDefinition ="NUMBER|第二次随访静息1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer twoResting;

    @Column(name ="THREE_RESTING",columnDefinition ="NUMBER|第三次随访静息1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer threeResting;

    @Column(name ="ONE_SLEEP",columnDefinition ="NUMBER|第一次随访睡眠1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer oneSleep;

    @Column(name ="TWO_SLEEP",columnDefinition ="NUMBER|第二次随访睡眠1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer twoSleep;

    @Column(name ="THREE_SLEEP",columnDefinition ="NUMBER|第三次随访睡眠1：控制。2：改善。3：未改善",length = 30, nullable = true)
    private Integer threeSleep;

    @Column(name ="MANAGE_RESULT",columnDefinition ="NUMBER|健康管理结果1：很成功。2：还不错。3：有待加强",length = 30, nullable = true)
    private Integer manageResult;

    @Column(name ="DF_LEVEL",columnDefinition ="NUMBER|危险",length = 30, nullable = true)
    private Integer dfLevel;

    @Column(name ="IS_CHANGE_PLAN",columnDefinition ="NUMBER|是否改变管理计划0：否。1：是",length = 30, nullable = true)
    private Integer isChangePlan;

    @Column(name ="APPRAISE_RESULT",columnDefinition ="NUMBER|评价结果 1：结束高危评价 2：高危分级调整 3：转为患者管理",length = 30, nullable = true)
    private Integer appraiseResult;

    @Column(name ="DIAGNOSES_DISEASES",columnDefinition ="VARCHAR2|疾病类型1高血压 2 糖尿病",length = 9, nullable = true)
    private String diagnosesDiseases;

    @Column(name ="IS_OLD",columnDefinition ="VARCHAR2|是否为历史数据 1：是 0：否",length = 30, nullable = true)
    private String isOld = "0";

    @Column(name ="CREATE_DATE",columnDefinition ="DATE|建卡日期",length = 7, nullable = true)
    private Date createDate;

    @Column(name ="CREATE_UNIT",columnDefinition ="VARCHAR2|建卡单位",length = 9, nullable = true)
    private String createUnit;

    @Column(name ="CREATOR",columnDefinition ="NUMBER|建卡者",length = 0, nullable = true)
    private Integer creator;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Integer getOneBPressure() {
        return oneBPressure;
    }

    public void setOneBPressure(Integer oneBPressure) {
        this.oneBPressure = oneBPressure;
    }

    public Integer getTwoBPressure() {
        return twoBPressure;
    }

    public void setTwoBPressure(Integer twoBPressure) {
        this.twoBPressure = twoBPressure;
    }

    public Integer getThreeBPressure() {
        return threeBPressure;
    }

    public void setThreeBPressure(Integer threeBPressure) {
        this.threeBPressure = threeBPressure;
    }

    public Integer getOneBSugar() {
        return oneBSugar;
    }

    public void setOneBSugar(Integer oneBSugar) {
        this.oneBSugar = oneBSugar;
    }

    public Integer getTwoBSugar() {
        return twoBSugar;
    }

    public void setTwoBSugar(Integer twoBSugar) {
        this.twoBSugar = twoBSugar;
    }

    public Integer getThreeBSugar() {
        return threeBSugar;
    }

    public void setThreeBSugar(Integer threeBSugar) {
        this.threeBSugar = threeBSugar;
    }

    public Integer getOneWasiteLine() {
        return oneWasiteLine;
    }

    public void setOneWasiteLine(Integer oneWasiteLine) {
        this.oneWasiteLine = oneWasiteLine;
    }

    public Integer getTwoWasiteLine() {
        return twoWasiteLine;
    }

    public void setTwoWasiteLine(Integer twoWasiteLine) {
        this.twoWasiteLine = twoWasiteLine;
    }

    public Integer getThreeWasiteLine() {
        return threeWasiteLine;
    }

    public void setThreeWasiteLine(Integer threeWasiteLine) {
        this.threeWasiteLine = threeWasiteLine;
    }

    public Integer getOneHips() {
        return oneHips;
    }

    public void setOneHips(Integer oneHips) {
        this.oneHips = oneHips;
    }

    public Integer getTwoHips() {
        return twoHips;
    }

    public void setTwoHips(Integer twoHips) {
        this.twoHips = twoHips;
    }

    public Integer getThreeHips() {
        return threeHips;
    }

    public void setThreeHips(Integer threeHips) {
        this.threeHips = threeHips;
    }

    public Integer getOneBmi() {
        return oneBmi;
    }

    public void setOneBmi(Integer oneBmi) {
        this.oneBmi = oneBmi;
    }

    public Integer getTwoBmi() {
        return twoBmi;
    }

    public void setTwoBmi(Integer twoBmi) {
        this.twoBmi = twoBmi;
    }

    public Integer getThreeBmi() {
        return threeBmi;
    }

    public void setThreeBmi(Integer threeBmi) {
        this.threeBmi = threeBmi;
    }

    public Integer getOneWeight() {
        return oneWeight;
    }

    public void setOneWeight(Integer oneWeight) {
        this.oneWeight = oneWeight;
    }

    public Integer getTwoWeight() {
        return twoWeight;
    }

    public void setTwoWeight(Integer twoWeight) {
        this.twoWeight = twoWeight;
    }

    public Integer getThreeWeight() {
        return threeWeight;
    }

    public void setThreeWeight(Integer threeWeight) {
        this.threeWeight = threeWeight;
    }

    public Integer getOneTc() {
        return oneTc;
    }

    public void setOneTc(Integer oneTc) {
        this.oneTc = oneTc;
    }

    public Integer getTwoTc() {
        return twoTc;
    }

    public void setTwoTc(Integer twoTc) {
        this.twoTc = twoTc;
    }

    public Integer getThreeTc() {
        return threeTc;
    }

    public void setThreeTc(Integer threeTc) {
        this.threeTc = threeTc;
    }

    public Integer getOneTg() {
        return oneTg;
    }

    public void setOneTg(Integer oneTg) {
        this.oneTg = oneTg;
    }

    public Integer getTwoTg() {
        return twoTg;
    }

    public void setTwoTg(Integer twoTg) {
        this.twoTg = twoTg;
    }

    public Integer getThreeTg() {
        return threeTg;
    }

    public void setThreeTg(Integer threeTg) {
        this.threeTg = threeTg;
    }

    public Integer getOneHdlc() {
        return oneHdlc;
    }

    public void setOneHdlc(Integer oneHdlc) {
        this.oneHdlc = oneHdlc;
    }

    public Integer getTwoHdlc() {
        return twoHdlc;
    }

    public void setTwoHdlc(Integer twoHdlc) {
        this.twoHdlc = twoHdlc;
    }

    public Integer getThreeHdlc() {
        return threeHdlc;
    }

    public void setThreeHdlc(Integer threeHdlc) {
        this.threeHdlc = threeHdlc;
    }

    public Integer getOneLdlc() {
        return oneLdlc;
    }

    public void setOneLdlc(Integer oneLdlc) {
        this.oneLdlc = oneLdlc;
    }

    public Integer getTwoLdlc() {
        return twoLdlc;
    }

    public void setTwoLdlc(Integer twoLdlc) {
        this.twoLdlc = twoLdlc;
    }

    public Integer getThreeLdlc() {
        return threeLdlc;
    }

    public void setThreeLdlc(Integer threeLdlc) {
        this.threeLdlc = threeLdlc;
    }

    public Integer getOneSmoke() {
        return oneSmoke;
    }

    public void setOneSmoke(Integer oneSmoke) {
        this.oneSmoke = oneSmoke;
    }

    public Integer getTwoSmoke() {
        return twoSmoke;
    }

    public void setTwoSmoke(Integer twoSmoke) {
        this.twoSmoke = twoSmoke;
    }

    public Integer getThreeSmoke() {
        return threeSmoke;
    }

    public void setThreeSmoke(Integer threeSmoke) {
        this.threeSmoke = threeSmoke;
    }

    public Integer getOneDrink() {
        return oneDrink;
    }

    public void setOneDrink(Integer oneDrink) {
        this.oneDrink = oneDrink;
    }

    public Integer getTwoDrink() {
        return twoDrink;
    }

    public void setTwoDrink(Integer twoDrink) {
        this.twoDrink = twoDrink;
    }

    public Integer getThreeDrink() {
        return threeDrink;
    }

    public void setThreeDrink(Integer threeDrink) {
        this.threeDrink = threeDrink;
    }

    public Integer getOneDrinkTea() {
        return oneDrinkTea;
    }

    public void setOneDrinkTea(Integer oneDrinkTea) {
        this.oneDrinkTea = oneDrinkTea;
    }

    public Integer getTwoDrinkTea() {
        return twoDrinkTea;
    }

    public void setTwoDrinkTea(Integer twoDrinkTea) {
        this.twoDrinkTea = twoDrinkTea;
    }

    public Integer getThreeDrinkTea() {
        return threeDrinkTea;
    }

    public void setThreeDrinkTea(Integer threeDrinkTea) {
        this.threeDrinkTea = threeDrinkTea;
    }

    public Integer getOne_mealsTaste() {
        return one_mealsTaste;
    }

    public void setOne_mealsTaste(Integer one_mealsTaste) {
        this.one_mealsTaste = one_mealsTaste;
    }

    public Integer getTwo_mealsTaste() {
        return two_mealsTaste;
    }

    public void setTwo_mealsTaste(Integer two_mealsTaste) {
        this.two_mealsTaste = two_mealsTaste;
    }

    public Integer getThree_mealsTaste() {
        return three_mealsTaste;
    }

    public void setThree_mealsTaste(Integer three_mealsTaste) {
        this.three_mealsTaste = three_mealsTaste;
    }

    public Integer getOneFatDiet() {
        return oneFatDiet;
    }

    public void setOneFatDiet(Integer oneFatDiet) {
        this.oneFatDiet = oneFatDiet;
    }

    public Integer getTwoFatDiet() {
        return twoFatDiet;
    }

    public void setTwoFatDiet(Integer twoFatDiet) {
        this.twoFatDiet = twoFatDiet;
    }

    public Integer getThreeFatDiet() {
        return threeFatDiet;
    }

    public void setThreeFatDiet(Integer threeFatDiet) {
        this.threeFatDiet = threeFatDiet;
    }

    public Integer getOneHouseWork() {
        return oneHouseWork;
    }

    public void setOneHouseWork(Integer oneHouseWork) {
        this.oneHouseWork = oneHouseWork;
    }

    public Integer getTwoHouseWork() {
        return twoHouseWork;
    }

    public void setTwoHouseWork(Integer twoHouseWork) {
        this.twoHouseWork = twoHouseWork;
    }

    public Integer getThreeHouseWork() {
        return threeHouseWork;
    }

    public void setThreeHouseWork(Integer threeHouseWork) {
        this.threeHouseWork = threeHouseWork;
    }

    public Integer getOneSport() {
        return oneSport;
    }

    public void setOneSport(Integer oneSport) {
        this.oneSport = oneSport;
    }

    public Integer getTwoSport() {
        return twoSport;
    }

    public void setTwoSport(Integer twoSport) {
        this.twoSport = twoSport;
    }

    public Integer getThreeSport() {
        return threeSport;
    }

    public void setThreeSport(Integer threeSport) {
        this.threeSport = threeSport;
    }

    public Integer getOneResting() {
        return oneResting;
    }

    public void setOneResting(Integer oneResting) {
        this.oneResting = oneResting;
    }

    public Integer getTwoResting() {
        return twoResting;
    }

    public void setTwoResting(Integer twoResting) {
        this.twoResting = twoResting;
    }

    public Integer getThreeResting() {
        return threeResting;
    }

    public void setThreeResting(Integer threeResting) {
        this.threeResting = threeResting;
    }

    public Integer getOneSleep() {
        return oneSleep;
    }

    public void setOneSleep(Integer oneSleep) {
        this.oneSleep = oneSleep;
    }

    public Integer getTwoSleep() {
        return twoSleep;
    }

    public void setTwoSleep(Integer twoSleep) {
        this.twoSleep = twoSleep;
    }

    public Integer getThreeSleep() {
        return threeSleep;
    }

    public void setThreeSleep(Integer threeSleep) {
        this.threeSleep = threeSleep;
    }

    public Integer getManageResult() {
        return manageResult;
    }

    public void setManageResult(Integer manageResult) {
        this.manageResult = manageResult;
    }

    public Integer getDfLevel() {
        return dfLevel;
    }

    public void setDfLevel(Integer dfLevel) {
        this.dfLevel = dfLevel;
    }

    public Integer getIsChangePlan() {
        return isChangePlan;
    }

    public void setIsChangePlan(Integer isChangePlan) {
        this.isChangePlan = isChangePlan;
    }

    public Integer getAppraiseResult() {
        return appraiseResult;
    }

    public void setAppraiseResult(Integer appraiseResult) {
        this.appraiseResult = appraiseResult;
    }

    public String getDiagnosesDiseases() {
        return diagnosesDiseases;
    }

    public void setDiagnosesDiseases(String diagnosesDiseases) {
        this.diagnosesDiseases = diagnosesDiseases;
    }

    public String getIsOld() {
        return isOld;
    }

    public void setIsOld(String isOld) {
        this.isOld = isOld;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUnit() {
        return createUnit;
    }

    public void setCreateUnit(String createUnit) {
        this.createUnit = createUnit;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public String getMeNumber() {
        return meNumber;
    }

    public void setMeNumber(String meNumber) {
        this.meNumber = meNumber;
    }
}
