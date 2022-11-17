package com.founder.rhip.ehr.dto.idm;


import com.founder.fasf.util.StringUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * 丝虫病列表
 * @author Cary Chan
 *
 */
public class FilariasisQueryDto implements Serializable {
	private static final long serialVersionUID = -8675673170121437464L;

    private String idmId;
	
	/*事件唯一Id*/
	private String singleId;
	
	/*姓名*/
    private String name;
    
    /*性别*/
    private String gender;    

    /*年龄*/
    private String age; 
    
    /*身份证*/
    private String idcard;

    /*状态体征*/
    private String feature;

    /*淋巴管（结）*/
    private String lymphatic;

    /*象皮肿*/
    private String lymphedema;

    /*乳糜尿*/
    private String chyluria;

    /*鞘膜积液*/
    private String tunicaVaginali;

    /*状态体征*/
    private String status;

    /*现住址镇*/
    private String patownShip;

    /*现住址社区*/
    private String pastreet;

    /*现住详细*/
    private String pahouseNumber;

    /*现住详细*/
    private String paAddress;

    /*血检结果*/
    private String testResult;

    /*备注*/
    private String comments;

    /*填写日期*/
    private Date fillDate;

    /*电话*/
    private String phoneNumber;

    /*注销标志（0正常，1注销）*/
    private Integer logoff;

    public String getSingleId() {
        return singleId;
    }

    public void setSingleId(String singleId) {
        this.singleId = singleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getLymphatic() {
        return StringUtil.isNullOrEmpty(lymphatic)?"0":lymphatic;
    }

    public void setLymphatic(String lymphatic) {
        this.lymphatic = lymphatic;
    }

    public String getLymphedema() {
        return lymphedema;
    }

    public void setLymphedema(String lymphedema) {
        this.lymphedema = lymphedema;
    }

    public String getChyluria() {
        return StringUtil.isNullOrEmpty(chyluria)?"0":chyluria;
    }

    public void setChyluria(String chyluria) {
        this.chyluria = chyluria;
    }

    public String getTunicaVaginali() {
        return tunicaVaginali;
    }

    public void setTunicaVaginali(String tunicaVaginali) {
        this.tunicaVaginali = tunicaVaginali;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPatownShip() {
        return patownShip;
    }

    public void setPatownShip(String patownShip) {
        this.patownShip = patownShip;
    }

    public String getPastreet() {
        return pastreet;
    }

    public void setPastreet(String pastreet) {
        this.pastreet = pastreet;
    }

    public String getPahouseNumber() {
        return pahouseNumber;
    }

    public void setPahouseNumber(String pahouseNumber) {
        this.pahouseNumber = pahouseNumber;
    }

    public String getPaAddress() {
        return paAddress;
    }

    public void setPaAddress(String paAddress) {
        this.paAddress = paAddress;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getFillDate() {
        return fillDate;
    }

    public void setFillDate(Date fillDate) {
        this.fillDate = fillDate;
    }

    public String getIdmId() {
        return idmId;
    }

    public void setIdmId(String idmId) {
        this.idmId = idmId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getLogoff() {
        return logoff;
    }

    public void setLogoff(Integer logoff) {
        this.logoff = logoff;
    }
}