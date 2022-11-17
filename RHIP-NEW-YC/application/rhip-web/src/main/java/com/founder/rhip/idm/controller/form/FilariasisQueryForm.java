/*
 * Copyright (c) 2010-2020 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 */

package com.founder.rhip.idm.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import org.apache.commons.lang.StringUtils;


public class FilariasisQueryForm {
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

    /*管理状态*/
    private String status;

    /*现住址镇*/
    private String patownShip;

    /*现住址社区*/
    private String pastreet;

    private String logoff;

    private String surveyOrg;//检测单位
    private String currentUnit;//管理机构


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

    public String getLogoff() {
        return logoff;
    }

    public void setLogoff(String logoff) {
        this.logoff = logoff;
    }

    public String getSurveyOrg() {
        return surveyOrg;
    }

    public void setSurveyOrg(String surveyOrg) {
        this.surveyOrg = surveyOrg;
    }

    public String getCurrentUnit() {
        return currentUnit;
    }

    public void setCurrentUnit(String currentUnit) {
        this.currentUnit = currentUnit;
    }

    public Criteria getCriteria(Criteria criteria){

		/*姓名-一般情况*/
		if (StringUtils.isNotBlank(name)){
			criteria.add("G.name", OP.LIKE, name);
		}
		/*性别-一般情况*/
		if (StringUtils.isNotBlank(gender)){
			criteria.add("G.gender", OP.LIKE, gender);
		}
		/*身份证号-一般情况*/
		if (StringUtils.isNotBlank(idcard)){
			criteria.add("G.idcard", idcard);
		}
        if (StringUtils.isNotBlank(logoff)){
            criteria.add("S.LOGOFF", logoff);
        }
		/*症状体征 1:象皮肿 2:乳糜尿 3:鞘膜积液 4:淋巴管(结)炎*/
		if (StringUtils.isNotBlank(feature)){
            switch (feature){
                case "1" : criteria.add("A.LYMPHEDEMA", "1");
                    break;
                case "2" : criteria.add("A.CHYLURIA", "1");
                    break;
                case "3" : criteria.add("A.TUNICA_VAGINALI", "1");
                    break;
                case "4" : criteria.add("A.LYMPHATIC", "1");
                    break;
            }
		}
        /*管理状态*/
         if (StringUtils.isNotBlank(status)){
         criteria.add("S.SPECIAL_STATUS", status);
         }
        /*管理单位*/
        if (StringUtils.isNotBlank(currentUnit)){
            criteria.add("S.CURRENT_UNIT", currentUnit);
        }
		return criteria;
	}

    public Criteria getRegCriteria(Criteria criteria){

		/*姓名*/
        if (StringUtils.isNotBlank(name)){
            criteria.add("G.name", OP.LIKE, name);
        }
		/*性别*/
        if (StringUtils.isNotBlank(gender)){
            criteria.add("G.gender", OP.LIKE, gender);
        }
        /*现住址镇*/
        if (StringUtils.isNotBlank(patownShip)){
            criteria.add("G.PATOWN_SHIP", patownShip);
        }
        /*现住址社区*/
        if (StringUtils.isNotBlank(pastreet)){
            criteria.add("G.PASTREET", pastreet);
        }

        /*检测单位*/
        if (StringUtils.isNotBlank(surveyOrg)){
            criteria.add("I.SURVEY_ORG", surveyOrg);
        }
        return criteria;
    }
}
