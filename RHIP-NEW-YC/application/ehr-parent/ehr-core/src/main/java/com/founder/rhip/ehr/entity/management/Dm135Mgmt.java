package com.founder.rhip.ehr.entity.management;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jingqiu on 17-4-19.
 */
@Entity
@Table(name = "DM_135MGMT")
public class Dm135Mgmt {
    @Id
    @Column(name ="ID",columnDefinition ="VARCHAR2|主键",length = 32, nullable = true)
    private String id;

    @Column(name ="PERSON_ID",columnDefinition ="VARCHAR2|健康档案外键",length = 32, nullable = true)
    private String personId;

    @Column(name ="NAME",columnDefinition ="VARCHAR2|姓名",length = 15, nullable = true)
    private String name;

    @Column(name ="ID_NO",columnDefinition ="VARCHAR2|身份证号",length = 30, nullable = true)
    private String idNo;

    @Column(name ="BIRTHDATE",columnDefinition ="DATE|出生日期",length = 7, nullable = true)
    private Date birthdate;

    @Column(name ="GENDER",columnDefinition ="NUMBER|性别",length = 0, nullable = true)
    private Integer gender;

    @Column(name ="ADDRESS",columnDefinition ="VARCHAR2|地址",length = 255, nullable = true)
    private String address;

    @Column(name ="TEL",columnDefinition ="VARCHAR2|联系电话",length = 20, nullable = true)
    private String tel;

    @Column(name ="WAIST_LINE",columnDefinition ="NUMBER|腰围",length = 0, nullable = true)
    private BigDecimal waistLine;

    @Column(name ="TG",columnDefinition ="NUMBER|高三酰甘油/甘油三酯",length = 0, nullable = true)
    private BigDecimal tg;

    @Column(name ="LHDLC",columnDefinition ="VARCHAR2|低高密度脂蛋白胆固醇",length = 9, nullable = true)
    private String lhdlc;

    @Column(name ="SBP",columnDefinition ="NUMBER|收缩压",length = 0, nullable = true)
    private Integer sbp;

    @Column(name ="DBP",columnDefinition ="NUMBER|舒张压",length = 0, nullable = true)
    private Integer dbp;

    @Column(name ="FBG",columnDefinition ="VARCHAR2|空腹血糖",length = 9, nullable = true)
    private String fbg;

    @Column(name ="BMI",columnDefinition ="NUMBER|BMI值",length = 0, nullable = true)
    private BigDecimal bmi;

    @Column(name ="TC",columnDefinition ="NUMBER|总胆固醇",length = 0, nullable = true)
    private BigDecimal tc;

    @Column(name ="DF_LEVEL",columnDefinition ="NUMBER|危险因素分级：1、低危 2、中危 3、高危",length = 0, nullable = true)
    private Integer dfLevel;

    @Column(name ="CYCLE",columnDefinition ="NUMBER|随访周期：1、一次/年 2、二次/年 3、四次/年",length = 0, nullable = true)
    private Integer cycle;

    @Column(name ="OPINION",columnDefinition ="VARCHAR2|管理意见，多个用英文逗号分隔",length = 40, nullable = true)
    private String opinion;

    @Column(name ="MG_UNIT",columnDefinition ="VARCHAR2|管理机构",length = 9, nullable = true)
    private String mgUnit;

    @Column(name ="MG_UNIT_NAME",columnDefinition ="VARCHAR2|管理机构名称",length = 100, nullable = true)
    private String mgUnitName;

    @Column(name ="DOCTOR",columnDefinition ="NUMBER|管理机构医生code",length = 0, nullable = true)
    private Integer doctor;

    @Column(name ="DOCTOR_NAME",columnDefinition ="VARCHAR2|管理机构医生",length = 52, nullable = true)
    private String doctorName;

    @Column(name ="AFFIRM_PERSON",columnDefinition ="VARCHAR2|居民签字",length = 40, nullable = true)
    private String affirmPerson;

    @Column(name ="CREATE_DATE",columnDefinition ="DATE|体检日期",length = 7, nullable = true)
    private Date createDate;

    @Column(name ="CREATE_UNIT",columnDefinition ="VARCHAR2|建卡单位",length = 9, nullable = true)
    private String createUnit;

    @Column(name ="CREATOR",columnDefinition ="NUMBER|建卡者",length = 0, nullable = true)
    private Integer creator;

    @Column(name ="MGMT_FLAG",columnDefinition ="NUMBER|纳入管理标识,1.已管理，2未管理 3.已被纳入慢病管理",length = 0, nullable = true)
    private Integer mgmtFlag = 2;

    @Column(name ="DF",columnDefinition ="VARCHAR2|危险因素种类",length = 255, nullable = true)
    private String df;

    @Column(name ="FILTER_TYPE",columnDefinition ="NUMBER|筛选类型 1 ATTP3 2 国家 3 自定义",length = 15, nullable = true)
    private Integer filterType;

    @Column(name ="WORK_UNIT",columnDefinition ="VARCHAR2|",length = 255, nullable = true)
    private String workUnit;

    @Column(name ="MG_DATE",columnDefinition ="DATE|建卡日期",length = 7, nullable = true)
    private Date mgDate;

    @Column(name ="ME_NUMBER",columnDefinition ="VARCHAR2|体检编号",length = 32, nullable = true)
    private String meNumber;

    @Column(name ="CELL_PHONE",columnDefinition ="VARCHAR2|手机",length = 20, nullable = true)
    private String cellPhone;

    @Column(name ="HIP",columnDefinition ="NUMBER|臀围",length = 15, nullable = true)
    private BigDecimal hip;

    @Column(name ="LDLC",columnDefinition ="VARCHAR2|低密度脂蛋白",length = 9, nullable = true)
    private String ldlc;

    @Column(name ="DONE_QUESTION",columnDefinition ="NUMBER|1已做 2未做",length = 0, nullable = true)
    private Integer doneQuestion = 2;

    @Column(name ="IS_SHOW",columnDefinition ="VARCHAR2|是否页面展示 1：是 0：否",length = 30, nullable = true)
    private String isShow = "1";

    @Column(name ="IS_APPRAISE",columnDefinition ="VARCHAR2|是否已评价 1：是 0：否",length = 30, nullable = true)
    private String isAppraise = "0";

    @Column(name ="APPRAISE_RESULT",columnDefinition ="NUMBER|评价结果 1：结束高危评价 2：高危分级调整 3：转为患者管理",length = 30, nullable = true)
    private Integer appraiseResult;

    @Transient
    private Integer age;
    @Transient
    private String dfCode;
    @Transient
    private String dfName;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public BigDecimal getWaistLine() {
        return waistLine;
    }

    public void setWaistLine(BigDecimal waistLine) {
        this.waistLine = waistLine;
    }

    public BigDecimal getTg() {
        return tg;
    }

    public void setTg(BigDecimal tg) {
        this.tg = tg;
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

    public String getFbg() {
        return fbg;
    }

    public void setFbg(String fbg) {
        this.fbg = fbg;
    }

    public BigDecimal getBmi() {
        return bmi;
    }

    public void setBmi(BigDecimal bmi) {
        this.bmi = bmi;
    }

    public BigDecimal getTc() {
        return tc;
    }

    public void setTc(BigDecimal tc) {
        this.tc = tc;
    }

    public Integer getDfLevel() {
        return dfLevel;
    }

    public void setDfLevel(Integer dfLevel) {
        this.dfLevel = dfLevel;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getMgUnit() {
        return mgUnit;
    }

    public void setMgUnit(String mgUnit) {
        this.mgUnit = mgUnit;
    }

    public String getMgUnitName() {
        return mgUnitName;
    }

    public void setMgUnitName(String mgUnitName) {
        this.mgUnitName = mgUnitName;
    }

    public Integer getDoctor() {
        return doctor;
    }

    public void setDoctor(Integer doctor) {
        this.doctor = doctor;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getAffirmPerson() {
        return affirmPerson;
    }

    public void setAffirmPerson(String affirmPerson) {
        this.affirmPerson = affirmPerson;
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

    public Integer getMgmtFlag() {
        return mgmtFlag;
    }

    public void setMgmtFlag(Integer mgmtFlag) {
        this.mgmtFlag = mgmtFlag;
    }

    public String getDf() {
        return df;
    }

    public void setDf(String df) {
        this.df = df;
    }

    public Integer getFilterType() {
        return filterType;
    }

    public void setFilterType(Integer filterType) {
        this.filterType = filterType;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public Date getMgDate() {
        return mgDate;
    }

    public void setMgDate(Date mgDate) {
        this.mgDate = mgDate;
    }

    public String getMeNumber() {
        return meNumber;
    }

    public void setMeNumber(String meNumber) {
        this.meNumber = meNumber;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
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

    public Integer getDoneQuestion() {
        return doneQuestion;
    }

    public void setDoneQuestion(Integer doneQuestion) {
        this.doneQuestion = doneQuestion;
    }

    public Integer getAge() {
        return DateUtil.getAgeByBirthday(birthdate);
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getIsAppraise() {
        return isAppraise;
    }

    public void setIsAppraise(String isAppraise) {
        this.isAppraise = isAppraise;
    }

    public Integer getAppraiseResult() {
        return appraiseResult;
    }

    public void setAppraiseResult(Integer appraiseResult) {
        this.appraiseResult = appraiseResult;
    }

    public String getDfCode() {
        if(ObjectUtil.isNotEmpty(df)) {
            JSONArray jsonArray = JSONArray.fromObject(df);
            String[] names = new String[jsonArray.size()];
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                names[i] = jsonObject.get("id").toString();
            }
            dfCode = StringUtil.join(names, ",");
        }
        return dfCode;
    }

    public void setDfCode(String dfCode) {
        this.dfCode = dfCode;
        String[] dfValues = dfCode.split(",");
        JSONArray jsonArray = new JSONArray();
        for (String dfValue : dfValues) {
            if(ObjectUtil.isNotEmpty(dfValue)) {
                String[] temp = dfValue.split(":");
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", temp[0]);
                jsonObject.put("name", temp[1]);
                jsonArray.add(jsonObject);
            }
        }
        this.df = jsonArray.toString();
    }

    public String getDfName() {
        if(ObjectUtil.isNotEmpty(df)) {
            JSONArray jsonArray = JSONArray.fromObject(df);
            String[] names = new String[jsonArray.size()];
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                names[i] = jsonObject.get("name").toString();
            }
            dfName = StringUtil.join(names, ",");
        }

        return dfName;
    }

    public void setDfName(String dfName) {
        this.dfName = dfName;
    }
}
