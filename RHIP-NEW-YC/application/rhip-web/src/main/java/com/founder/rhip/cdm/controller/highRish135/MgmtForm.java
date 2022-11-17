package com.founder.rhip.cdm.controller.highRish135;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

/**
 * Created by jingqiu on 17-4-19.
 */
public class MgmtForm {

    private String name;
    private String idcard;
    private Integer gender;
    private Integer doneQuestion;

    public Criteria toCriteria() {
        Criteria criteria = new Criteria();
        if (StringUtil.isNotEmpty(name)) {
            criteria.add("name", OP.LIKE, name);
        }
        if (StringUtil.isNotEmpty(idcard)) {
            criteria.add("idNo", OP.LIKE, idcard);
        }
        if (ObjectUtil.isNotEmpty(gender)) {
            criteria.add("gender", gender);
        }
        if (ObjectUtil.isNotEmpty(doneQuestion) && doneQuestion != 0) {
            criteria.add("doneQuestion", doneQuestion);
        }
        return criteria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getDoneQuestion() {
        return doneQuestion;
    }

    public void setDoneQuestion(Integer doneQuestion) {
        this.doneQuestion = doneQuestion;
    }
}
