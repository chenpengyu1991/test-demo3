package com.founder.rhip.ehr.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;

/**
 * Created by jingqiu on 17-3-27.
 */
public class ChildExamQueryForm {

    String name;
    String babyCardNo;
    String gender;
    String motherIdCard;
    String examineAgeGroup;
    String checkOrganCode;
    String orgCode;

    public Criteria getCriteria() {
        Criteria criteria = new Criteria();
        Criteria deleteCriteria = new Criteria("IS_DELETE",OP.NE,EHRConstants.DELETE_FLG_1);
        deleteCriteria.add(LOP.OR,"IS_DELETE",OP.IS,"NULL");
        criteria.add(deleteCriteria);
        if (StringUtil.isNotEmpty(examineAgeGroup)) {
            criteria.add("examineAgeGroup", examineAgeGroup);
        }
        if (StringUtil.isNotEmpty(name)) {
            criteria.add("name", OP.LIKE, name);
        }
        if (StringUtil.isNotEmpty(babyCardNo)) {
            criteria.add("babyCardNo", babyCardNo);
        }
        if (StringUtil.isNotEmpty(gender)) {
            criteria.add("gender", gender);
        }
        if (StringUtil.isNotEmpty(motherIdCard)) {
            criteria.add("Id_card", motherIdCard);
        }
        if (StringUtil.isNotEmpty(checkOrganCode)) {
            criteria.add("checkOrganCode", checkOrganCode);
        }
        return criteria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBabyCardNo() {
        return babyCardNo;
    }

    public void setBabyCardNo(String babyCardNo) {
        this.babyCardNo = babyCardNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMotherIdCard() {
        return motherIdCard;
    }

    public void setMotherIdCard(String motherIdCard) {
        this.motherIdCard = motherIdCard;
    }

    public String getExamineAgeGroup() {
        return examineAgeGroup;
    }

    public void setExamineAgeGroup(String examineAgeGroup) {
        this.examineAgeGroup = examineAgeGroup;
    }

    public String getCheckOrganCode() {
        return checkOrganCode;
    }

    public void setCheckOrganCode(String checkOrganCode) {
        this.checkOrganCode = checkOrganCode;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }
}
