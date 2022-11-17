package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jingqiu on 17-4-21.
 */
@Entity
@Table(name = "DM_135FOLLOWUP")
public class Dm135Followup {
    @Id
    @Column(name ="ID",columnDefinition ="VARCHAR2|主键",length = 32, nullable = true)
    private String id;

    @Column(name ="PERSON_ID",columnDefinition ="VARCHAR2|健康档案主键",length = 32, nullable = true)
    private String personId;

    @Column(name ="ID_NO",columnDefinition ="VARCHAR2|身份证标识",length = 30, nullable = true)
    private String idNo;

    @Column(name ="HEIGHT",columnDefinition ="NUMBER|身高",length = 0, nullable = true)
    private BigDecimal height;

    @Column(name ="WEIGHT",columnDefinition ="NUMBER|体重",length = 0, nullable = true)
    private BigDecimal weight;

    @Column(name ="WAIST_LINE",columnDefinition ="NUMBER|腰围",length = 0, nullable = true)
    private BigDecimal waistLine;

    @Column(name ="HIPS",columnDefinition ="NUMBER|臀围",length = 0, nullable = true)
    private BigDecimal hips;

    @Column(name ="SBP",columnDefinition ="NUMBER|收缩压",length = 0, nullable = true)
    private Integer sbp;

    @Column(name ="DBP",columnDefinition ="NUMBER|舒张压",length = 0, nullable = true)
    private Integer dbp;

    @Column(name ="FBG",columnDefinition ="VARCHAR2|空腹血糖",length = 9, nullable = true)
    private String fbg;

    @Column(name ="TC",columnDefinition ="NUMBER|总胆固醇",length = 0, nullable = true)
    private BigDecimal tc;

    @Column(name ="TG",columnDefinition ="NUMBER|高三酰甘油/甘油三酯",length = 0, nullable = true)
    private BigDecimal tg;

    @Column(name ="HDLC",columnDefinition ="VARCHAR2|高密度脂蛋白",length = 9, nullable = true)
    private String hdlc;

    @Column(name ="LDLC",columnDefinition ="VARCHAR2|低密度脂蛋白",length = 9, nullable = true)
    private String ldlc;

    @Column(name ="IS_H_TALK",columnDefinition ="NUMBER|是否参加健康讲座0：否 1：是",length = 0, nullable = true)
    private Integer isHTalk;

    @Column(name ="IS_H_TALK_NO",columnDefinition ="NUMBER|参加多少期",length = 0, nullable = true)
    private Integer isHTalkNo;

    @Column(name ="IS_H_MSG",columnDefinition ="NUMBER|是否接受到健康短信0：否 1：是",length = 0, nullable = true)
    private Integer isHMsg;

    @Column(name ="IS_R_BROCHURE",columnDefinition ="NUMBER|是否收到宣传折页0：否 1：是",length = 0, nullable = true)
    private Integer isRBrochure;

    @Column(name ="SMOKE_NO",columnDefinition ="NUMBER|每天吸烟多少支 0：少于每天1支 1：多于每天1支",length = 0, nullable = true)
    private Integer smokeNo;

    @Column(name ="MORE_SMOKE_NO",columnDefinition ="NUMBER|支/天",length = 0, nullable = true)
    private Integer moreSmokeNo;

    @Column(name ="DRINK",columnDefinition ="NUMBER|饮酒情况0=不饮1=饮9=不知道",length = 0, nullable = true)
    private Integer drink;

    @Column(name ="BEER_SIZE",columnDefinition ="NUMBER|啤酒毫升大小1=660ml大瓶 2=330ml小瓶 3=355ml易拉罐",length = 0, nullable = true)
    private Integer beerSize;

    @Column(name ="BEER_MONTH",columnDefinition ="NUMBER|啤酒月/年",length = 0, nullable = true)
    private Integer beerMonth;

    @Column(name ="BEER_SEQ",columnDefinition ="NUMBER|啤酒次/月",length = 0, nullable = true)
    private Integer beerSeq;

    @Column(name ="BEER_MILL",columnDefinition ="NUMBER|啤酒ml/次",length = 0, nullable = true)
    private Integer beerMill;

    @Column(name ="SPIRIT_DEGREE",columnDefinition ="NUMBER|白酒酒精度数",length = 0, nullable = true)
    private Integer spiritDegree;

    @Column(name ="SPIRIT_MONTH",columnDefinition ="NUMBER|白酒月/年",length = 0, nullable = true)
    private Integer spiritMonth;

    @Column(name ="SPIRIT_SEQ",columnDefinition ="NUMBER|白酒次/月",length = 0, nullable = true)
    private Integer spiritSeq;

    @Column(name ="SPIRIT_OUNCE",columnDefinition ="NUMBER|白酒两/次",length = 0, nullable = true)
    private BigDecimal spiritOunce;

    @Column(name ="WINE_MONTH",columnDefinition ="NUMBER|葡萄酒月/年",length = 0, nullable = true)
    private Integer wineMonth;

    @Column(name ="WINE_SEQ",columnDefinition ="NUMBER|葡萄酒次/月",length = 0, nullable = true)
    private Integer wineSeq;

    @Column(name ="WINE_OUNCE",columnDefinition ="NUMBER|葡萄酒两/次",length = 0, nullable = true)
    private BigDecimal wineOunce;

    @Column(name ="RICE_WINE_MONTH",columnDefinition ="NUMBER|米酒或黄酒月/年",length = 0, nullable = true)
    private Integer riceWineMonth;

    @Column(name ="RICE_WINE_SEQ",columnDefinition ="NUMBER|米酒或黄酒次/月",length = 0, nullable = true)
    private Integer riceWineSeq;

    @Column(name ="RICE_WINE_OUNCE",columnDefinition ="NUMBER|米酒或黄酒两/次",length = 0, nullable = true)
    private BigDecimal riceWineOunce;

    @Column(name ="STAPLE",columnDefinition ="NUMBER|主食0=不吃1=天2=周3=月4=年",length = 0, nullable = true)
    private Integer staple;

    @Column(name ="STAPLE_CATTY",columnDefinition ="NUMBER|主食斤",length = 0, nullable = true)
    private BigDecimal stapleCatty;

    @Column(name ="STAPLE_OUNCE",columnDefinition ="NUMBER|主食两",length = 0, nullable = true)
    private BigDecimal stapleOunce;

    @Column(name ="PIG_COW_SHEEP",columnDefinition ="NUMBER|猪牛羊肉0=不吃1=天2=周3=月4=年",length = 0, nullable = true)
    private Integer pigCowSheep;

    @Column(name ="PIG_COW_SHEEP_CATTY",columnDefinition ="NUMBER|猪牛羊肉斤",length = 0, nullable = true)
    private BigDecimal pigCowSheepCatty;

    @Column(name ="PIG_COW_SHEEP_OUNCE",columnDefinition ="NUMBER|猪牛羊肉两",length = 0, nullable = true)
    private BigDecimal pigCowSheepOunce;

    @Column(name ="CHICKEN_DUCK",columnDefinition ="NUMBER|鸡、鸭肉0=不吃1=天2=周3=月4=年",length = 0, nullable = true)
    private Integer chickenDuck;

    @Column(name ="CHICKEN_DUCK_CATTY",columnDefinition ="NUMBER|鸡、鸭肉斤",length = 0, nullable = true)
    private BigDecimal chickenDuckCatty;

    @Column(name ="CHICKEN_DUCK_OUNCE",columnDefinition ="NUMBER|鸡、鸭肉两",length = 0, nullable = true)
    private BigDecimal chickenDuckOunce;

    @Column(name ="FISH",columnDefinition ="NUMBER|鱼类0=不吃1=天2=周3=月4=年",length = 0, nullable = true)
    private Integer fish;

    @Column(name ="FISH_CATTY",columnDefinition ="NUMBER|鱼类斤",length = 0, nullable = true)
    private BigDecimal fishCatty;

    @Column(name ="FISH_OUNCE",columnDefinition ="NUMBER|鱼类两",length = 0, nullable = true)
    private BigDecimal fishOunce;

    @Column(name ="MILK_YOGURT",columnDefinition ="NUMBER|牛奶、酸奶0=不吃1=天2=周3=月4=年",length = 0, nullable = true)
    private Integer milkYogurt;

    @Column(name ="MILK_YOGURT_CATTY",columnDefinition ="NUMBER|牛奶、酸奶斤",length = 0, nullable = true)
    private BigDecimal milkYogurtCatty;

    @Column(name ="MILK_YOGURT_OUNCE",columnDefinition ="NUMBER|牛奶、酸奶两",length = 0, nullable = true)
    private BigDecimal milkYogurtOunce;

    @Column(name ="FRESH_FRUIT",columnDefinition ="NUMBER|新鲜水果0=不吃1=天2=周3=月4=年",length = 0, nullable = true)
    private Integer freshFruit;

    @Column(name ="FRESH_FRUIT_CATTY",columnDefinition ="NUMBER|新鲜水果斤",length = 0, nullable = true)
    private BigDecimal freshFruitCatty;

    @Column(name ="FRESH_FRUIT_OUNCE",columnDefinition ="NUMBER|新鲜水果两",length = 0, nullable = true)
    private BigDecimal freshFruitOunce;

    @Column(name ="FRESH_VEG",columnDefinition ="NUMBER|新鲜蔬菜0=不吃1=天2=周3=月4=年",length = 0, nullable = true)
    private Integer freshVeg;

    @Column(name ="FRESH_VEG_CATTY",columnDefinition ="NUMBER|新鲜蔬菜斤",length = 0, nullable = true)
    private BigDecimal freshVegCatty;

    @Column(name ="FRESH_VEG_OUNCE",columnDefinition ="NUMBER|新鲜蔬菜两",length = 0, nullable = true)
    private BigDecimal freshVegOunce;

    @Column(name ="LEGUMES",columnDefinition ="NUMBER|豆类食品0=不吃1=天2=周3=月4=年",length = 0, nullable = true)
    private Integer legumes;

    @Column(name ="LEGUMES_CATTY",columnDefinition ="NUMBER|豆类食品斤",length = 0, nullable = true)
    private BigDecimal legumesCatty;

    @Column(name ="LEGUMES_OUNCE",columnDefinition ="NUMBER|豆类食品两",length = 0, nullable = true)
    private BigDecimal legumesOunce;

    @Column(name ="VAR_NUT",columnDefinition ="NUMBER|各种坚果0=不吃1=天2=周3=月4=年",length = 0, nullable = true)
    private Integer varNut;

    @Column(name ="VAR_NUT_CATTY",columnDefinition ="NUMBER|各种坚果斤",length = 0, nullable = true)
    private BigDecimal varNutCatty;

    @Column(name ="VAR_NUT_OUNCE",columnDefinition ="NUMBER|各种坚果两",length = 0, nullable = true)
    private BigDecimal varNutOunce;

    @Column(name ="PICKLE",columnDefinition ="NUMBER|咸菜0=不吃1=天2=周3=月4=年",length = 0, nullable = true)
    private Integer pickle;

    @Column(name ="PICKLE_CATTY",columnDefinition ="NUMBER|咸菜斤",length = 0, nullable = true)
    private BigDecimal pickleCatty;

    @Column(name ="PICKLE_OUNCE",columnDefinition ="NUMBER|咸菜两",length = 0, nullable = true)
    private BigDecimal pickleOunce;

    @Column(name ="DRINK_TEA",columnDefinition ="NUMBER|您是否经常喝茶(随访期间每周至少3次)0=否1=是",length = 0, nullable = true)
    private Integer drinkTea;

    @Column(name ="TEA",columnDefinition ="NUMBER|喝哪种茶1=绿茶2=红茶（普洱、铁观音等）8=其他",length = 0, nullable = true)
    private Integer tea;

    @Column(name ="TEA_OUNCE",columnDefinition ="NUMBER|本人每月喝几两茶叶",length = 0, nullable = true)
    private BigDecimal teaOunce;

    @Column(name ="TEA_SEQ",columnDefinition ="NUMBER|每天泡几次茶（指换几次茶叶或换新的茶袋）",length = 0, nullable = true)
    private Integer teaSeq;

    @Column(name ="TASTE",columnDefinition ="NUMBER|您现在的口味与当地一般人相比1=偏咸2=差不多3=偏淡4=偏甜",length = 0, nullable = true)
    private Integer taste;

    @Column(name ="EAT_MEAT",columnDefinition ="NUMBER|最近一周吃肉是否＜75g/天0=是1=否",length = 0, nullable = true)
    private Integer eatMeat;

    @Column(name ="MEAT_CATEGORY",columnDefinition ="NUMBER|吃肉的种类是0=瘦肉1=肥瘦肉2=肥肉3=内脏",length = 0, nullable = true)
    private Integer meatCategory;

    @Column(name ="EGG_NO",columnDefinition ="NUMBER|最近一周吃蛋的个数0=0-3个/周1=3-7个/周 2=7个以上/周",length = 0, nullable = true)
    private Integer eggNo;

    @Column(name ="FRIED_FOODS_NO",columnDefinition ="NUMBER|近一周吃油炸食品数量0=未吃1=1-4次/周3=7次以上/周",length = 0, nullable = true)
    private Integer friedFoodsNo;

    @Column(name ="BRIOCHE_NO",columnDefinition ="NUMBER|近一周吃奶油糕点的数量0=未吃1=1-4次/周2=5-7次/周3=7次以上/周",length = 0, nullable = true)
    private Integer briocheNo;

    @Column(name ="HIGH_LABOR_DAY",columnDefinition ="NUMBER|较重度家务劳动天/周",length = 0, nullable = true)
    private Double highLaborDay;

    @Column(name ="HIGH_LABOR_HOUR",columnDefinition ="NUMBER|较重度家务劳动小时",length = 0, nullable = true)
    private Double highLaborHour;

    @Column(name ="HIGH_LABOR_MIN",columnDefinition ="NUMBER|较重度家务劳动分钟",length = 0, nullable = true)
    private Double highLaborMin;

    @Column(name ="GENERAL_LABOR_DAY",columnDefinition ="NUMBER|一般家务劳动天/周",length = 0, nullable = true)
    private Double generalLaborDay;

    @Column(name ="GENERAL_LABOR_HOUR",columnDefinition ="NUMBER|一般家务劳动小时",length = 0, nullable = true)
    private Double generalLaborHour;

    @Column(name ="GENERAL_LABOR_MIN",columnDefinition ="NUMBER|一般家务劳动分钟",length = 0, nullable = true)
    private Double generalLaborMin;

    @Column(name ="SPORTS",columnDefinition ="NUMBER|过去30天，您是否参加过体育锻炼或运动1＝是2＝否9＝记不清",length = 0, nullable = true)
    private Integer sports;

    @Column(name ="HIGH_PHY_ACTI_MONTH",columnDefinition ="NUMBER|重度体力活动月/年",length = 0, nullable = true)
    private Integer highPhyActiMonth;

    @Column(name ="HIGH_PHY_ACTI_DAY",columnDefinition ="NUMBER|重度体力活动天/月",length = 0, nullable = true)
    private Integer highPhyActiDay;

    @Column(name ="HIGH_PHY_ACTI_HOUR",columnDefinition ="NUMBER|重度体力活动小时",length = 0, nullable = true)
    private Integer highPhyActiHour;

    @Column(name ="HIGH_PHY_ACTI_MIN",columnDefinition ="NUMBER|重度体力活动分钟",length = 0, nullable = true)
    private Integer highPhyActiMin;

    @Column(name ="MIDDLE_PHY_ACTI_MONTH",columnDefinition ="NUMBER|中度体力活动月/年",length = 0, nullable = true)
    private Integer middlePhyActiMonth;

    @Column(name ="MIDDLE_PHY_ACTI_DAY",columnDefinition ="NUMBER|中度体力活动天/月",length = 0, nullable = true)
    private Integer middlePhyActiDay;

    @Column(name ="MIDDLE_PHY_ACTI_HOUR",columnDefinition ="NUMBER|中度体力活动小时",length = 0, nullable = true)
    private Integer middlePhyActiHour;

    @Column(name ="MIDDLE_PHY_ACTI_MIN",columnDefinition ="NUMBER|中度体力活动分钟",length = 0, nullable = true)
    private Integer middlePhyActiMin;

    @Column(name ="LOW_PHY_ACTI_MONTH",columnDefinition ="NUMBER|轻度体力活动月/年",length = 0, nullable = true)
    private Integer lowPhyActiMonth;

    @Column(name ="LOW_PHY_ACTI_DAY",columnDefinition ="NUMBER|轻度体力活动天/月",length = 0, nullable = true)
    private Integer lowPhyActiDay;

    @Column(name ="LOW_PHY_ACTI_HOUR",columnDefinition ="NUMBER|轻度体力活动小时",length = 0, nullable = true)
    private Integer lowPhyActiHour;

    @Column(name ="LOW_PHY_ACTI_MIN",columnDefinition ="NUMBER|轻度体力活动分钟",length = 0, nullable = true)
    private Integer lowPhyActiMin;

    @Column(name ="TV_DAY",columnDefinition ="NUMBER|看电视天/周",length = 0, nullable = true)
    private Integer tvDay;

    @Column(name ="TV_HOUR",columnDefinition ="NUMBER|看电视小时",length = 0, nullable = true)
    private Integer tvHour;

    @Column(name ="TV_MIN",columnDefinition ="NUMBER|看电视分钟",length = 0, nullable = true)
    private Integer tvMin;

    @Column(name ="OTHER_SPORT_HOUR",columnDefinition ="NUMBER|其他静息活动小时",length = 0, nullable = true)
    private Integer otherSportHour;

    @Column(name ="OTHER_SPORT_MIN",columnDefinition ="NUMBER|看电视分钟分钟",length = 0, nullable = true)
    private Integer otherSportMin;

    @Column(name ="SLEEP_HOUR",columnDefinition ="NUMBER|睡眠日均睡小时/天",length = 0, nullable = true)
    private Integer sleepHour;

    @Column(name ="SLEEP_DIS",columnDefinition ="NUMBER|睡眠障碍1=无2=入睡困难3=早醒4=多醒5=其他",length = 0, nullable = true)
    private Integer sleepDis;

    @Column(name ="EAT_BREAKFAST",columnDefinition ="NUMBER|是否每天规律吃早餐0=不吃早餐1=每周1-2次2=每周3-5次3=每天",length = 0, nullable = true)
    private Integer eatBreakfast;

    @Column(name ="NON_DRUG_M_D",columnDefinition ="VARCHAR2|非药物管理意见1=合理膳食2=适量运动3=戒烟4=降三高:血脂、血糖、血压5=心理平衡6=其他",length = 25, nullable = true)
    private String nonDrugMD;

    @Column(name ="NON_DRUG_M_D_OTHER",columnDefinition ="VARCHAR2|非药物管理意见其他",length = 100, nullable = true)
    private String nonDrugMDOther;

    @Column(name ="DRUG_M_D",columnDefinition ="VARCHAR2|药物管理意见",length = 200, nullable = true)
    private String drugMD;

    @Column(name ="CREATE_DATE",columnDefinition ="DATE|创建日期",length = 7, nullable = true)
    private Date createDate;

    @Column(name ="CREATE_UNIT",columnDefinition ="VARCHAR2|创建单位",length = 9, nullable = true)
    private String createUnit;

    @Column(name ="CREATOR",columnDefinition ="NUMBER|创建者",length = 0, nullable = true)
    private Integer creator;

    @Column(name ="FOLLOWUP_DATE",columnDefinition ="DATE|随访时间",length = 7, nullable = true)
    private Date followupDate;

    @Column(name ="FOLLOWUP_TYPE",columnDefinition ="NUMBER|随访类型",length = 0, nullable = true)
    private Integer followupType;
    @Column(name ="FOLLOWUP_DOCTOR",columnDefinition ="NUMBER|随访医生编码",length = 0, nullable = true)
    private Integer followupDoctor;
    @Column(name ="FOLLOWUP_DOCTOR_NAME",columnDefinition ="VARCHAR2|随访医生名称",length = 40, nullable = true)
    private String followupDoctorName;
    @Column(name ="MANAGE_RECORD",columnDefinition ="NUMBER|健康评估结果",length = 0, nullable = true)
    private Integer manageRecord;
    @Column(name ="SPORT_MIN",columnDefinition ="NUMBER|您的近1个月的运动目标是",length = 0, nullable = true)
    private Integer sportMin;
    @Column(name ="SPORT_DAY",columnDefinition ="NUMBER|您的近1个月的运动目标是",length = 0, nullable = true)
    private Integer sportDay;
    @Column(name ="WEIGHT_LESS",columnDefinition ="NUMBER|您的近1个月的目标是体重减少",length = 0, nullable = true)
    private BigDecimal weightLess;
    @Column(name ="WAIST_LINE_LESS",columnDefinition ="NUMBER|您的近1个月的目标是腰围减少",length = 0, nullable = true)
    private BigDecimal waistLineLess;
    @Column(name ="SMOKE_LESS",columnDefinition ="NUMBER|您的近1个月的目标是减少吸烟至",length = 0, nullable = true)
    private Integer smokeLess;
    @Column(name ="DRINK_LESS",columnDefinition ="NUMBER|您的近1个月的目标是减少饮酒至",length = 0, nullable = true)
    private Integer drinkLess;
    @Column(name ="THREE_MONTH_GLOAL",columnDefinition ="VARCHAR2|您的近3个月的心理平衡目标是",length = 255, nullable = true)
    private String threeMonthGloal;
    @Column(name ="WAIST_LINE_CONDITION",columnDefinition ="NUMBER|1 控制 2 改善 3 未改善",length = 0, nullable = true)
    private Integer waistLineCondition;
    @Column(name ="FBG_CONDITION",columnDefinition ="NUMBER|2 控制 2 改善 3 未改善",length = 0, nullable = true)
    private Integer fbgCondition;
    @Column(name ="HIPS_CONDITION",columnDefinition ="NUMBER|3 控制 2 改善 3 未改善",length = 0, nullable = true)
    private Integer hipsCondition;
    @Column(name ="BMI_CONDITION",columnDefinition ="NUMBER|4 控制 2 改善 3 未改善",length = 0, nullable = true)
    private Integer bmiCondition;
    @Column(name ="TC_CONDITION",columnDefinition ="NUMBER|5 控制 2 改善 3 未改善",length = 0, nullable = true)
    private Integer tcCondition;
    @Column(name ="TG_CONDITION",columnDefinition ="NUMBER|6 控制 2 改善 3 未改善",length = 0, nullable = true)
    private Integer tgCondition;
    @Column(name ="HDLC_CONDITION",columnDefinition ="NUMBER|7 控制 2 改善 3 未改善",length = 0, nullable = true)
    private Integer hdlcCondition;
    @Column(name ="LDLC_CONDITION",columnDefinition ="NUMBER|8 控制 2 改善 3 未改善",length = 0, nullable = true)
    private Integer ldlcCondition;
    @Column(name ="DRINK_CONDITION",columnDefinition ="NUMBER|9 控制 2 改善 3 未改善",length = 0, nullable = true)
    private Integer drinkCondition;
    @Column(name ="SMOKE_CONDITION",columnDefinition ="NUMBER|10 控制 2 改善 3 未改善",length = 0, nullable = true)
    private Integer smokeCondition;
    @Column(name ="DRINK_TEA_CONDITION",columnDefinition ="NUMBER|11 控制 2 改善 3 未改善",length = 0, nullable = true)
    private Integer drinkTeaCondition;
    @Column(name ="HOUSE_WORK_CONDITION",columnDefinition ="NUMBER|12 控制 2 改善 3 未改善",length = 0, nullable = true)
    private Integer houseWorkCondition;
    @Column(name ="SPORT_CONDITION",columnDefinition ="NUMBER|13 控制 2 改善 3 未改善",length = 0, nullable = true)
    private Integer sportCondition;
    @Column(name ="TASTE_CONDITION",columnDefinition ="NUMBER|14 控制 2 改善 3 未改善",length = 0, nullable = true)
    private Integer tasteCondition;
    @Column(name ="SLEEP_CONDITION",columnDefinition ="NUMBER|15 控制 2 改善 3 未改善",length = 0, nullable = true)
    private Integer sleepCondition;
    @Column(name ="RESTING_CONDITION",columnDefinition ="NUMBER|16 控制 2 改善 3 未改善",length = 0, nullable = true)
    private Integer restingCondition;
    @Column(name ="BLOOD_CONDITION",columnDefinition ="NUMBER|17 控制 2 改善 3 未改善",length = 0, nullable = true)
    private Integer bloodCondition;
    @Column(name ="FAT_DIET_CONDITION",columnDefinition ="NUMBER|18 控制 2 改善 3 未改善",length = 0, nullable = true)
    private Integer fatDietCondition;

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

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getWaistLine() {
        return waistLine;
    }

    public void setWaistLine(BigDecimal waistLine) {
        this.waistLine = waistLine;
    }

    public BigDecimal getHips() {
        return hips;
    }

    public void setHips(BigDecimal hips) {
        this.hips = hips;
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

    public String getFbg() {
        return fbg;
    }

    public void setFbg(String fbg) {
        this.fbg = fbg;
    }

    public BigDecimal getTc() {
        return tc;
    }

    public void setTc(BigDecimal tc) {
        this.tc = tc;
    }

    public BigDecimal getTg() {
        return tg;
    }

    public void setTg(BigDecimal tg) {
        this.tg = tg;
    }

    public String getHdlc() {
        return hdlc;
    }

    public void setHdlc(String hdlc) {
        this.hdlc = hdlc;
    }

    public String getLdlc() {
        return ldlc;
    }

    public void setLdlc(String ldlc) {
        this.ldlc = ldlc;
    }

    public Integer getIsHTalk() {
        return isHTalk;
    }

    public void setIsHTalk(Integer isHTalk) {
        this.isHTalk = isHTalk;
    }

    public Integer getIsHTalkNo() {
        return isHTalkNo;
    }

    public void setIsHTalkNo(Integer isHTalkNo) {
        this.isHTalkNo = isHTalkNo;
    }

    public Integer getIsHMsg() {
        return isHMsg;
    }

    public void setIsHMsg(Integer isHMsg) {
        this.isHMsg = isHMsg;
    }

    public Integer getIsRBrochure() {
        return isRBrochure;
    }

    public void setIsRBrochure(Integer isRBrochure) {
        this.isRBrochure = isRBrochure;
    }

    public Integer getSmokeNo() {
        return smokeNo;
    }

    public void setSmokeNo(Integer smokeNo) {
        this.smokeNo = smokeNo;
    }

    public Integer getMoreSmokeNo() {
        return moreSmokeNo;
    }

    public void setMoreSmokeNo(Integer moreSmokeNo) {
        this.moreSmokeNo = moreSmokeNo;
    }

    public Integer getDrink() {
        return drink;
    }

    public void setDrink(Integer drink) {
        this.drink = drink;
    }

    public Integer getBeerSize() {
        return beerSize;
    }

    public void setBeerSize(Integer beerSize) {
        this.beerSize = beerSize;
    }

    public Integer getBeerMonth() {
        return beerMonth;
    }

    public void setBeerMonth(Integer beerMonth) {
        this.beerMonth = beerMonth;
    }

    public Integer getBeerSeq() {
        return beerSeq;
    }

    public void setBeerSeq(Integer beerSeq) {
        this.beerSeq = beerSeq;
    }

    public Integer getBeerMill() {
        return beerMill;
    }

    public void setBeerMill(Integer beerMill) {
        this.beerMill = beerMill;
    }

    public Integer getSpiritDegree() {
        return spiritDegree;
    }

    public void setSpiritDegree(Integer spiritDegree) {
        this.spiritDegree = spiritDegree;
    }

    public Integer getSpiritMonth() {
        return spiritMonth;
    }

    public void setSpiritMonth(Integer spiritMonth) {
        this.spiritMonth = spiritMonth;
    }

    public Integer getSpiritSeq() {
        return spiritSeq;
    }

    public void setSpiritSeq(Integer spiritSeq) {
        this.spiritSeq = spiritSeq;
    }

    public BigDecimal getSpiritOunce() {
        return spiritOunce;
    }

    public void setSpiritOunce(BigDecimal spiritOunce) {
        this.spiritOunce = spiritOunce;
    }

    public Integer getWineMonth() {
        return wineMonth;
    }

    public void setWineMonth(Integer wineMonth) {
        this.wineMonth = wineMonth;
    }

    public Integer getWineSeq() {
        return wineSeq;
    }

    public void setWineSeq(Integer wineSeq) {
        this.wineSeq = wineSeq;
    }

    public BigDecimal getWineOunce() {
        return wineOunce;
    }

    public void setWineOunce(BigDecimal wineOunce) {
        this.wineOunce = wineOunce;
    }

    public Integer getRiceWineMonth() {
        return riceWineMonth;
    }

    public void setRiceWineMonth(Integer riceWineMonth) {
        this.riceWineMonth = riceWineMonth;
    }

    public Integer getRiceWineSeq() {
        return riceWineSeq;
    }

    public void setRiceWineSeq(Integer riceWineSeq) {
        this.riceWineSeq = riceWineSeq;
    }

    public BigDecimal getRiceWineOunce() {
        return riceWineOunce;
    }

    public void setRiceWineOunce(BigDecimal riceWineOunce) {
        this.riceWineOunce = riceWineOunce;
    }

    public Integer getStaple() {
        return staple;
    }

    public void setStaple(Integer staple) {
        this.staple = staple;
    }

    public BigDecimal getStapleCatty() {
        return stapleCatty;
    }

    public void setStapleCatty(BigDecimal stapleCatty) {
        this.stapleCatty = stapleCatty;
    }

    public BigDecimal getStapleOunce() {
        return stapleOunce;
    }

    public void setStapleOunce(BigDecimal stapleOunce) {
        this.stapleOunce = stapleOunce;
    }

    public Integer getPigCowSheep() {
        return pigCowSheep;
    }

    public void setPigCowSheep(Integer pigCowSheep) {
        this.pigCowSheep = pigCowSheep;
    }

    public BigDecimal getPigCowSheepCatty() {
        return pigCowSheepCatty;
    }

    public void setPigCowSheepCatty(BigDecimal pigCowSheepCatty) {
        this.pigCowSheepCatty = pigCowSheepCatty;
    }

    public BigDecimal getPigCowSheepOunce() {
        return pigCowSheepOunce;
    }

    public void setPigCowSheepOunce(BigDecimal pigCowSheepOunce) {
        this.pigCowSheepOunce = pigCowSheepOunce;
    }

    public Integer getChickenDuck() {
        return chickenDuck;
    }

    public void setChickenDuck(Integer chickenDuck) {
        this.chickenDuck = chickenDuck;
    }

    public BigDecimal getChickenDuckCatty() {
        return chickenDuckCatty;
    }

    public void setChickenDuckCatty(BigDecimal chickenDuckCatty) {
        this.chickenDuckCatty = chickenDuckCatty;
    }

    public BigDecimal getChickenDuckOunce() {
        return chickenDuckOunce;
    }

    public void setChickenDuckOunce(BigDecimal chickenDuckOunce) {
        this.chickenDuckOunce = chickenDuckOunce;
    }

    public Integer getFish() {
        return fish;
    }

    public void setFish(Integer fish) {
        this.fish = fish;
    }

    public BigDecimal getFishCatty() {
        return fishCatty;
    }

    public void setFishCatty(BigDecimal fishCatty) {
        this.fishCatty = fishCatty;
    }

    public BigDecimal getFishOunce() {
        return fishOunce;
    }

    public void setFishOunce(BigDecimal fishOunce) {
        this.fishOunce = fishOunce;
    }

    public Integer getMilkYogurt() {
        return milkYogurt;
    }

    public void setMilkYogurt(Integer milkYogurt) {
        this.milkYogurt = milkYogurt;
    }

    public BigDecimal getMilkYogurtCatty() {
        return milkYogurtCatty;
    }

    public void setMilkYogurtCatty(BigDecimal milkYogurtCatty) {
        this.milkYogurtCatty = milkYogurtCatty;
    }

    public BigDecimal getMilkYogurtOunce() {
        return milkYogurtOunce;
    }

    public void setMilkYogurtOunce(BigDecimal milkYogurtOunce) {
        this.milkYogurtOunce = milkYogurtOunce;
    }

    public Integer getFreshFruit() {
        return freshFruit;
    }

    public void setFreshFruit(Integer freshFruit) {
        this.freshFruit = freshFruit;
    }

    public BigDecimal getFreshFruitCatty() {
        return freshFruitCatty;
    }

    public void setFreshFruitCatty(BigDecimal freshFruitCatty) {
        this.freshFruitCatty = freshFruitCatty;
    }

    public BigDecimal getFreshFruitOunce() {
        return freshFruitOunce;
    }

    public void setFreshFruitOunce(BigDecimal freshFruitOunce) {
        this.freshFruitOunce = freshFruitOunce;
    }

    public Integer getFreshVeg() {
        return freshVeg;
    }

    public void setFreshVeg(Integer freshVeg) {
        this.freshVeg = freshVeg;
    }

    public BigDecimal getFreshVegCatty() {
        return freshVegCatty;
    }

    public void setFreshVegCatty(BigDecimal freshVegCatty) {
        this.freshVegCatty = freshVegCatty;
    }

    public BigDecimal getFreshVegOunce() {
        return freshVegOunce;
    }

    public void setFreshVegOunce(BigDecimal freshVegOunce) {
        this.freshVegOunce = freshVegOunce;
    }

    public Integer getLegumes() {
        return legumes;
    }

    public void setLegumes(Integer legumes) {
        this.legumes = legumes;
    }

    public BigDecimal getLegumesCatty() {
        return legumesCatty;
    }

    public void setLegumesCatty(BigDecimal legumesCatty) {
        this.legumesCatty = legumesCatty;
    }

    public BigDecimal getLegumesOunce() {
        return legumesOunce;
    }

    public void setLegumesOunce(BigDecimal legumesOunce) {
        this.legumesOunce = legumesOunce;
    }

    public Integer getVarNut() {
        return varNut;
    }

    public void setVarNut(Integer varNut) {
        this.varNut = varNut;
    }

    public BigDecimal getVarNutCatty() {
        return varNutCatty;
    }

    public void setVarNutCatty(BigDecimal varNutCatty) {
        this.varNutCatty = varNutCatty;
    }

    public BigDecimal getVarNutOunce() {
        return varNutOunce;
    }

    public void setVarNutOunce(BigDecimal varNutOunce) {
        this.varNutOunce = varNutOunce;
    }

    public Integer getPickle() {
        return pickle;
    }

    public void setPickle(Integer pickle) {
        this.pickle = pickle;
    }

    public BigDecimal getPickleCatty() {
        return pickleCatty;
    }

    public void setPickleCatty(BigDecimal pickleCatty) {
        this.pickleCatty = pickleCatty;
    }

    public BigDecimal getPickleOunce() {
        return pickleOunce;
    }

    public void setPickleOunce(BigDecimal pickleOunce) {
        this.pickleOunce = pickleOunce;
    }

    public Integer getDrinkTea() {
        return drinkTea;
    }

    public void setDrinkTea(Integer drinkTea) {
        this.drinkTea = drinkTea;
    }

    public Integer getTea() {
        return tea;
    }

    public void setTea(Integer tea) {
        this.tea = tea;
    }

    public BigDecimal getTeaOunce() {
        return teaOunce;
    }

    public void setTeaOunce(BigDecimal teaOunce) {
        this.teaOunce = teaOunce;
    }

    public Integer getTeaSeq() {
        return teaSeq;
    }

    public void setTeaSeq(Integer teaSeq) {
        this.teaSeq = teaSeq;
    }

    public Integer getTaste() {
        return taste;
    }

    public void setTaste(Integer taste) {
        this.taste = taste;
    }

    public Integer getEatMeat() {
        return eatMeat;
    }

    public void setEatMeat(Integer eatMeat) {
        this.eatMeat = eatMeat;
    }

    public Integer getMeatCategory() {
        return meatCategory;
    }

    public void setMeatCategory(Integer meatCategory) {
        this.meatCategory = meatCategory;
    }

    public Integer getEggNo() {
        return eggNo;
    }

    public void setEggNo(Integer eggNo) {
        this.eggNo = eggNo;
    }

    public Integer getFriedFoodsNo() {
        return friedFoodsNo;
    }

    public void setFriedFoodsNo(Integer friedFoodsNo) {
        this.friedFoodsNo = friedFoodsNo;
    }

    public Integer getBriocheNo() {
        return briocheNo;
    }

    public void setBriocheNo(Integer briocheNo) {
        this.briocheNo = briocheNo;
    }

    public Double getHighLaborDay() {
        return highLaborDay;
    }

    public void setHighLaborDay(Double highLaborDay) {
        this.highLaborDay = highLaborDay;
    }

    public Double getHighLaborHour() {
        return highLaborHour;
    }

    public void setHighLaborHour(Double highLaborHour) {
        this.highLaborHour = highLaborHour;
    }

    public Double getHighLaborMin() {
        return highLaborMin;
    }

    public void setHighLaborMin(Double highLaborMin) {
        this.highLaborMin = highLaborMin;
    }

    public Double getGeneralLaborDay() {
        return generalLaborDay;
    }

    public void setGeneralLaborDay(Double generalLaborDay) {
        this.generalLaborDay = generalLaborDay;
    }

    public Double getGeneralLaborHour() {
        return generalLaborHour;
    }

    public void setGeneralLaborHour(Double generalLaborHour) {
        this.generalLaborHour = generalLaborHour;
    }

    public Double getGeneralLaborMin() {
        return generalLaborMin;
    }

    public void setGeneralLaborMin(Double generalLaborMin) {
        this.generalLaborMin = generalLaborMin;
    }

    public Integer getSports() {
        return sports;
    }

    public void setSports(Integer sports) {
        this.sports = sports;
    }

    public Integer getHighPhyActiMonth() {
        return highPhyActiMonth;
    }

    public void setHighPhyActiMonth(Integer highPhyActiMonth) {
        this.highPhyActiMonth = highPhyActiMonth;
    }

    public Integer getHighPhyActiDay() {
        return highPhyActiDay;
    }

    public void setHighPhyActiDay(Integer highPhyActiDay) {
        this.highPhyActiDay = highPhyActiDay;
    }

    public Integer getHighPhyActiHour() {
        return highPhyActiHour;
    }

    public void setHighPhyActiHour(Integer highPhyActiHour) {
        this.highPhyActiHour = highPhyActiHour;
    }

    public Integer getHighPhyActiMin() {
        return highPhyActiMin;
    }

    public void setHighPhyActiMin(Integer highPhyActiMin) {
        this.highPhyActiMin = highPhyActiMin;
    }

    public Integer getMiddlePhyActiMonth() {
        return middlePhyActiMonth;
    }

    public void setMiddlePhyActiMonth(Integer middlePhyActiMonth) {
        this.middlePhyActiMonth = middlePhyActiMonth;
    }

    public Integer getMiddlePhyActiDay() {
        return middlePhyActiDay;
    }

    public void setMiddlePhyActiDay(Integer middlePhyActiDay) {
        this.middlePhyActiDay = middlePhyActiDay;
    }

    public Integer getMiddlePhyActiHour() {
        return middlePhyActiHour;
    }

    public void setMiddlePhyActiHour(Integer middlePhyActiHour) {
        this.middlePhyActiHour = middlePhyActiHour;
    }

    public Integer getMiddlePhyActiMin() {
        return middlePhyActiMin;
    }

    public void setMiddlePhyActiMin(Integer middlePhyActiMin) {
        this.middlePhyActiMin = middlePhyActiMin;
    }

    public Integer getLowPhyActiMonth() {
        return lowPhyActiMonth;
    }

    public void setLowPhyActiMonth(Integer lowPhyActiMonth) {
        this.lowPhyActiMonth = lowPhyActiMonth;
    }

    public Integer getLowPhyActiDay() {
        return lowPhyActiDay;
    }

    public void setLowPhyActiDay(Integer lowPhyActiDay) {
        this.lowPhyActiDay = lowPhyActiDay;
    }

    public Integer getLowPhyActiHour() {
        return lowPhyActiHour;
    }

    public void setLowPhyActiHour(Integer lowPhyActiHour) {
        this.lowPhyActiHour = lowPhyActiHour;
    }

    public Integer getLowPhyActiMin() {
        return lowPhyActiMin;
    }

    public void setLowPhyActiMin(Integer lowPhyActiMin) {
        this.lowPhyActiMin = lowPhyActiMin;
    }

    public Integer getTvDay() {
        return tvDay;
    }

    public void setTvDay(Integer tvDay) {
        this.tvDay = tvDay;
    }

    public Integer getTvHour() {
        return tvHour;
    }

    public void setTvHour(Integer tvHour) {
        this.tvHour = tvHour;
    }

    public Integer getTvMin() {
        return tvMin;
    }

    public void setTvMin(Integer tvMin) {
        this.tvMin = tvMin;
    }

    public Integer getOtherSportHour() {
        return otherSportHour;
    }

    public void setOtherSportHour(Integer otherSportHour) {
        this.otherSportHour = otherSportHour;
    }

    public Integer getOtherSportMin() {
        return otherSportMin;
    }

    public void setOtherSportMin(Integer otherSportMin) {
        this.otherSportMin = otherSportMin;
    }

    public Integer getSleepHour() {
        return sleepHour;
    }

    public void setSleepHour(Integer sleepHour) {
        this.sleepHour = sleepHour;
    }

    public Integer getSleepDis() {
        return sleepDis;
    }

    public void setSleepDis(Integer sleepDis) {
        this.sleepDis = sleepDis;
    }

    public Integer getEatBreakfast() {
        return eatBreakfast;
    }

    public void setEatBreakfast(Integer eatBreakfast) {
        this.eatBreakfast = eatBreakfast;
    }

    public String getNonDrugMD() {
        return nonDrugMD;
    }

    public void setNonDrugMD(String nonDrugMD) {
        this.nonDrugMD = nonDrugMD;
    }

    public String getNonDrugMDOther() {
        return nonDrugMDOther;
    }

    public void setNonDrugMDOther(String nonDrugMDOther) {
        this.nonDrugMDOther = nonDrugMDOther;
    }

    public String getDrugMD() {
        return drugMD;
    }

    public void setDrugMD(String drugMD) {
        this.drugMD = drugMD;
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

    public Date getFollowupDate() {
        return followupDate;
    }

    public void setFollowupDate(Date followupDate) {
        this.followupDate = followupDate;
    }

    public Integer getFollowupType() {
        return followupType;
    }

    public void setFollowupType(Integer followupType) {
        this.followupType = followupType;
    }

    public Integer getFollowupDoctor() {
        return followupDoctor;
    }

    public void setFollowupDoctor(Integer followupDoctor) {
        this.followupDoctor = followupDoctor;
    }

    public String getFollowupDoctorName() {
        return followupDoctorName;
    }

    public void setFollowupDoctorName(String followupDoctorName) {
        this.followupDoctorName = followupDoctorName;
    }

    public Integer getManageRecord() {
        return manageRecord;
    }

    public void setManageRecord(Integer manageRecord) {
        this.manageRecord = manageRecord;
    }

    public Integer getSportMin() {
        return sportMin;
    }

    public void setSportMin(Integer sportMin) {
        this.sportMin = sportMin;
    }

    public Integer getSportDay() {
        return sportDay;
    }

    public void setSportDay(Integer sportDay) {
        this.sportDay = sportDay;
    }

    public BigDecimal getWeightLess() {
        return weightLess;
    }

    public void setWeightLess(BigDecimal weightLess) {
        this.weightLess = weightLess;
    }

    public BigDecimal getWaistLineLess() {
        return waistLineLess;
    }

    public void setWaistLineLess(BigDecimal waistLineLess) {
        this.waistLineLess = waistLineLess;
    }

    public Integer getSmokeLess() {
        return smokeLess;
    }

    public void setSmokeLess(Integer smokeLess) {
        this.smokeLess = smokeLess;
    }

    public Integer getDrinkLess() {
        return drinkLess;
    }

    public void setDrinkLess(Integer drinkLess) {
        this.drinkLess = drinkLess;
    }

    public String getThreeMonthGloal() {
        return threeMonthGloal;
    }

    public void setThreeMonthGloal(String threeMonthGloal) {
        this.threeMonthGloal = threeMonthGloal;
    }

    public Integer getWaistLineCondition() {
        return waistLineCondition;
    }

    public void setWaistLineCondition(Integer waistLineCondition) {
        this.waistLineCondition = waistLineCondition;
    }

    public Integer getFbgCondition() {
        return fbgCondition;
    }

    public void setFbgCondition(Integer fbgCondition) {
        this.fbgCondition = fbgCondition;
    }

    public Integer getHipsCondition() {
        return hipsCondition;
    }

    public void setHipsCondition(Integer hipsCondition) {
        this.hipsCondition = hipsCondition;
    }

    public Integer getBmiCondition() {
        return bmiCondition;
    }

    public void setBmiCondition(Integer bmiCondition) {
        this.bmiCondition = bmiCondition;
    }

    public Integer getTcCondition() {
        return tcCondition;
    }

    public void setTcCondition(Integer tcCondition) {
        this.tcCondition = tcCondition;
    }

    public Integer getTgCondition() {
        return tgCondition;
    }

    public void setTgCondition(Integer tgCondition) {
        this.tgCondition = tgCondition;
    }

    public Integer getHdlcCondition() {
        return hdlcCondition;
    }

    public void setHdlcCondition(Integer hdlcCondition) {
        this.hdlcCondition = hdlcCondition;
    }

    public Integer getLdlcCondition() {
        return ldlcCondition;
    }

    public void setLdlcCondition(Integer ldlcCondition) {
        this.ldlcCondition = ldlcCondition;
    }

    public Integer getDrinkCondition() {
        return drinkCondition;
    }

    public void setDrinkCondition(Integer drinkCondition) {
        this.drinkCondition = drinkCondition;
    }

    public Integer getSmokeCondition() {
        return smokeCondition;
    }

    public void setSmokeCondition(Integer smokeCondition) {
        this.smokeCondition = smokeCondition;
    }

    public Integer getDrinkTeaCondition() {
        return drinkTeaCondition;
    }

    public void setDrinkTeaCondition(Integer drinkTeaCondition) {
        this.drinkTeaCondition = drinkTeaCondition;
    }

    public Integer getHouseWorkCondition() {
        return houseWorkCondition;
    }

    public void setHouseWorkCondition(Integer houseWorkCondition) {
        this.houseWorkCondition = houseWorkCondition;
    }

    public Integer getSportCondition() {
        return sportCondition;
    }

    public void setSportCondition(Integer sportCondition) {
        this.sportCondition = sportCondition;
    }

    public Integer getTasteCondition() {
        return tasteCondition;
    }

    public void setTasteCondition(Integer tasteCondition) {
        this.tasteCondition = tasteCondition;
    }

    public Integer getSleepCondition() {
        return sleepCondition;
    }

    public void setSleepCondition(Integer sleepCondition) {
        this.sleepCondition = sleepCondition;
    }

    public Integer getRestingCondition() {
        return restingCondition;
    }

    public void setRestingCondition(Integer restingCondition) {
        this.restingCondition = restingCondition;
    }

    public Integer getBloodCondition() {
        return bloodCondition;
    }

    public void setBloodCondition(Integer bloodCondition) {
        this.bloodCondition = bloodCondition;
    }

    public Integer getFatDietCondition() {
        return fatDietCondition;
    }

    public void setFatDietCondition(Integer fatDietCondition) {
        this.fatDietCondition = fatDietCondition;
    }
}
