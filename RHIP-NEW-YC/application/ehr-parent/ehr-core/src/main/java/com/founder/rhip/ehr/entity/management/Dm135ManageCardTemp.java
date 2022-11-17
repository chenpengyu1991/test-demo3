package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jingqiu on 17-4-19.
 */
@Entity
@Table(name = "DM_135MANAGE_CARD_TEMP")
public class Dm135ManageCardTemp {

    @Id
    @Column(name ="ID",columnDefinition ="VARCHAR2|主键",length = 32, nullable = true)
    private String id;

    @Column(name ="NAME",columnDefinition ="VARCHAR2|姓名",length = 20, nullable = true)
    private String name;

    @Column(name ="ID_NO",columnDefinition ="VARCHAR2|身份标识",length = 30, nullable = true)
    private String idNo;

    @Column(name ="BIRTHDATE",columnDefinition ="DATE|出生日期",length = 7, nullable = true)
    private Date birthdate;

    @Column(name ="GENDER",columnDefinition ="NUMBER|性别",length = 0, nullable = true)
    private Integer gender;

    @Column(name ="ADDRESS",columnDefinition ="VARCHAR2|地址",length = 255, nullable = true)
    private String address;

    @Column(name ="MARRIAGE",columnDefinition ="NUMBER|婚姻状况类别代码",length = 0, nullable = true)
    private Integer marriage;

    @Column(name ="OCCUPATION",columnDefinition ="NUMBER|职业类别代码",length = 0, nullable = true)
    private Integer occupation;

    @Column(name ="TEL",columnDefinition ="VARCHAR2|联系电话",length = 20, nullable = true)
    private String tel;

    @Column(name ="WORK_UNIT",columnDefinition ="VARCHAR2|工作单位",length = 255, nullable = true)
    private String workUnit;

    @Column(name ="IS_DO_AWARENESS",columnDefinition ="NUMBER|1已做2未做",length = 0, nullable = true)
    private Integer isDoAwareness;

    @Column(name ="IS_DO_QUESTION",columnDefinition ="NUMBER|1已做2未做",length = 0, nullable = true)
    private Integer isDoQuestion;

    @Column(name ="ME_NUMBER",columnDefinition ="VARCHAR2|体检编号",length = 32, nullable = true)
    private String meNumber;

    @Column(name ="CELL_PHONE",columnDefinition ="VARCHAR2|手机",length = 20, nullable = true)
    private String cellPhone;

    @Column(name ="OVERWEIGHT",columnDefinition ="NUMBER|超重0、否 1、是",length = 0, nullable = true)
    private Integer overweight;

    @Column(name ="BMI",columnDefinition ="NUMBER|BMI值",length = 0, nullable = true)
    private BigDecimal bmi;

    @Column(name ="WAISTLINE",columnDefinition ="NUMBER|腰围",length = 0, nullable = true)
    private BigDecimal waistline;

    @Column(name ="SPORTING",columnDefinition ="NUMBER|运动0、不 1、有",length = 0, nullable = true)
    private Integer sporting;

    @Column(name ="SPORT_TIMES",columnDefinition ="NUMBER|每周运动次数",length = 0, nullable = true)
    private Integer sportTimes;

    @Column(name ="SMOKING",columnDefinition ="NUMBER|当前吸烟0、否 1、是",length = 0, nullable = true)
    private Integer smoking;

    @Column(name ="SMOKING_TIMES",columnDefinition ="NUMBER|每日吸烟数",length = 0, nullable = true)
    private Integer smokingTimes;

    @Column(name ="DRINKING",columnDefinition ="NUMBER|长期饮酒0、否 1、是",length = 0, nullable = true)
    private Integer drinking;

    @Column(name ="DRINKING_TIMES",columnDefinition ="NUMBER|每周平均喝酒次数",length = 0, nullable = true)
    private Integer drinkingTimes;

    @Column(name ="LIPIN",columnDefinition ="NUMBER|饮食偏油脂0、否 1、是",length = 0, nullable = true)
    private Integer lipin;

    @Column(name ="MORE_MEAT",columnDefinition ="NUMBER|每天吃8两以上鱼肉0、否 1、是",length = 0, nullable = true)
    private Integer moreMeat;

    @Column(name ="MORE_OIL",columnDefinition ="NUMBER|每月吃油4斤以上",length = 0, nullable = true)
    private Integer moreOil;

    @Column(name ="TC",columnDefinition ="NUMBER|总胆固醇0或具体的数",length = 0, nullable = true)
    private BigDecimal tc;

    @Column(name ="TRIGLYCERIDE",columnDefinition ="NUMBER|甘油三酯0或具体的数",length = 0, nullable = true)
    private BigDecimal triglyceride;

    @Column(name ="FAMILY_HISTORY",columnDefinition ="NUMBER|家族史0、无 1、有",length = 0, nullable = true)
    private Integer familyHistory;

    @Column(name ="FH_FATHER",columnDefinition ="NUMBER|直系亲属高血压、糖尿病病史-父亲0、无 1、有",length = 0, nullable = true)
    private Integer fhFather;

    @Column(name ="FH_MEMBER",columnDefinition ="NUMBER|直系亲属高血压、糖尿病病史-同辈家庭成员0、无 1、有",length = 0, nullable = true)
    private Integer fhMember;

    @Column(name ="LHDLC",columnDefinition ="VARCHAR2|高密度脂蛋白胆固醇",length = 9, nullable = true)
    private String lhdlc;

    @Column(name ="SBP",columnDefinition ="NUMBER|收缩压",length = 0, nullable = true)
    private Integer sbp;

    @Column(name ="DBP",columnDefinition ="NUMBER|舒张压",length = 0, nullable = true)
    private Integer dbp;

    @Column(name ="IS_HBP_TREATMENT",columnDefinition ="NUMBER|抗高血压治疗",length = 0, nullable = true)
    private Integer isHbpTreatment;

    @Column(name ="FBG",columnDefinition ="VARCHAR2|空腹血糖",length = 9, nullable = true)
    private String fbg;

    @Column(name ="HEIGHT",columnDefinition ="NUMBER|身高",length = 15, nullable = true)
    private BigDecimal height;

    @Column(name ="WEIGHT",columnDefinition ="NUMBER|体重",length = 15, nullable = true)
    private BigDecimal weight;

    @Column(name ="POPU_FLAG",columnDefinition ="NUMBER|人员状态 1，高危，2，患者，3一般人群",length = 0, nullable = true)
    private Integer popuFlag;

    @Column(name ="CREATE_DATE",columnDefinition ="DATE|体检日期",length = 7, nullable = true)
    private Date createDate;

    @Column(name ="MODIFY_DATE",columnDefinition ="DATE|修改时间",length = 7, nullable = true)
    private Date modifyDate;

    @Column(name ="TR_SYMBOL",columnDefinition ="NUMBER|高三酰甘油符号",length = 0, nullable = true)
    private Integer trSymbol;

    @Column(name ="LH_SYMBOL",columnDefinition ="NUMBER|低高密度脂蛋白胆固醇符号",length = 0, nullable = true)
    private Integer lhSymbol;

    @Column(name ="FBG_SYMBOL",columnDefinition ="NUMBER|高空腹血糖 1 mmol/l 2 mg/dl",length = 0, nullable = true)
    private Integer fbgSymbol;

    @Column(name ="CREATE_UNIT",columnDefinition ="VARCHAR2|",length = 9, nullable = true)
    private String createUnit;

    @Column(name ="CREATOR",columnDefinition ="NUMBER|",length = 0, nullable = true)
    private Integer creator;

    @Column(name ="TC_SYMBOL",columnDefinition ="NUMBER|",length = 0, nullable = true)
    private Integer tcSymbol;

    @Column(name ="BELONG_UNIT",columnDefinition ="VARCHAR2|体检人员所属机构(社区服务站)",length = 9, nullable = true)
    private String belongUnit;

    @Column(name ="FILTER_TYPE",columnDefinition ="NUMBER|筛选类型 1 ATTP3 2 国家 3 自定义",length = 15, nullable = true)
    private Integer filterType;

    @Column(name ="HIP",columnDefinition ="NUMBER|臀围",length = 15, nullable = true)
    private BigDecimal hip;

    @Column(name ="LDLC",columnDefinition ="VARCHAR2|低密度脂蛋白",length = 9, nullable = true)
    private String ldlc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getMarriage() {
        return marriage;
    }

    public void setMarriage(Integer marriage) {
        this.marriage = marriage;
    }

    public Integer getOccupation() {
        return occupation;
    }

    public void setOccupation(Integer occupation) {
        this.occupation = occupation;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public Integer getIsDoAwareness() {
        return isDoAwareness;
    }

    public void setIsDoAwareness(Integer isDoAwareness) {
        this.isDoAwareness = isDoAwareness;
    }

    public Integer getIsDoQuestion() {
        return isDoQuestion;
    }

    public void setIsDoQuestion(Integer isDoQuestion) {
        this.isDoQuestion = isDoQuestion;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Integer getOverweight() {
        return overweight;
    }

    public void setOverweight(Integer overweight) {
        this.overweight = overweight;
    }

    public BigDecimal getBmi() {
        return bmi;
    }

    public void setBmi(BigDecimal bmi) {
        this.bmi = bmi;
    }

    public BigDecimal getWaistline() {
        return waistline;
    }

    public void setWaistline(BigDecimal waistline) {
        this.waistline = waistline;
    }

    public Integer getSporting() {
        return sporting;
    }

    public void setSporting(Integer sporting) {
        this.sporting = sporting;
    }

    public Integer getSportTimes() {
        return sportTimes;
    }

    public void setSportTimes(Integer sportTimes) {
        this.sportTimes = sportTimes;
    }

    public Integer getSmoking() {
        return smoking;
    }

    public void setSmoking(Integer smoking) {
        this.smoking = smoking;
    }

    public Integer getSmokingTimes() {
        return smokingTimes;
    }

    public void setSmokingTimes(Integer smokingTimes) {
        this.smokingTimes = smokingTimes;
    }

    public Integer getDrinking() {
        return drinking;
    }

    public void setDrinking(Integer drinking) {
        this.drinking = drinking;
    }

    public Integer getDrinkingTimes() {
        return drinkingTimes;
    }

    public void setDrinkingTimes(Integer drinkingTimes) {
        this.drinkingTimes = drinkingTimes;
    }

    public Integer getLipin() {
        return lipin;
    }

    public void setLipin(Integer lipin) {
        this.lipin = lipin;
    }

    public Integer getMoreMeat() {
        return moreMeat;
    }

    public void setMoreMeat(Integer moreMeat) {
        this.moreMeat = moreMeat;
    }

    public Integer getMoreOil() {
        return moreOil;
    }

    public void setMoreOil(Integer moreOil) {
        this.moreOil = moreOil;
    }

    public BigDecimal getTc() {
        return tc;
    }

    public void setTc(BigDecimal tc) {
        this.tc = tc;
    }

    public BigDecimal getTriglyceride() {
        return triglyceride;
    }

    public void setTriglyceride(BigDecimal triglyceride) {
        this.triglyceride = triglyceride;
    }

    public Integer getFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(Integer familyHistory) {
        this.familyHistory = familyHistory;
    }

    public Integer getFhFather() {
        return fhFather;
    }

    public void setFhFather(Integer fhFather) {
        this.fhFather = fhFather;
    }

    public Integer getFhMember() {
        return fhMember;
    }

    public void setFhMember(Integer fhMember) {
        this.fhMember = fhMember;
    }

    public String getLhdlc() {
        return lhdlc;
    }

    public void setLhdlc(String lhdlc) {
        this.lhdlc = lhdlc;
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

    public Integer getIsHbpTreatment() {
        return isHbpTreatment;
    }

    public void setIsHbpTreatment(Integer isHbpTreatment) {
        this.isHbpTreatment = isHbpTreatment;
    }

    public String getFbg() {
        return fbg;
    }

    public void setFbg(String fbg) {
        this.fbg = fbg;
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

    public Integer getPopuFlag() {
        return popuFlag;
    }

    public void setPopuFlag(Integer popuFlag) {
        this.popuFlag = popuFlag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getTrSymbol() {
        return trSymbol;
    }

    public void setTrSymbol(Integer trSymbol) {
        this.trSymbol = trSymbol;
    }

    public Integer getLhSymbol() {
        return lhSymbol;
    }

    public void setLhSymbol(Integer lhSymbol) {
        this.lhSymbol = lhSymbol;
    }

    public Integer getFbgSymbol() {
        return fbgSymbol;
    }

    public void setFbgSymbol(Integer fbgSymbol) {
        this.fbgSymbol = fbgSymbol;
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

    public Integer getTcSymbol() {
        return tcSymbol;
    }

    public void setTcSymbol(Integer tcSymbol) {
        this.tcSymbol = tcSymbol;
    }

    public String getBelongUnit() {
        return belongUnit;
    }

    public void setBelongUnit(String belongUnit) {
        this.belongUnit = belongUnit;
    }

    public Integer getFilterType() {
        return filterType;
    }

    public void setFilterType(Integer filterType) {
        this.filterType = filterType;
    }

    public BigDecimal getHip() {
        return hip;
    }

    public void setHip(BigDecimal hip) {
        this.hip = hip;
    }

    public String getLdlc() {
        return ldlc;
    }

    public void setLdlc(String ldlc) {
        this.ldlc = ldlc;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getMeNumber() {
        return meNumber;
    }

    public void setMeNumber(String meNumber) {
        this.meNumber = meNumber;
    }
}
