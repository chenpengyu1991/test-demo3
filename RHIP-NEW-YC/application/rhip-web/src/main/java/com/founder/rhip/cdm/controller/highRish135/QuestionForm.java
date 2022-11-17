package com.founder.rhip.cdm.controller.highRish135;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

/**
 * Created by jingqiu on 17-4-17.
 */
public class QuestionForm {
    private String name;
    private String idcard;
    private String physicalExamNo;
    private String barCode;
    private Integer doneQuestion;
  /*  private Integer questionType;*/

    public Criteria toCriteria() {
        Criteria criteria = new Criteria();
        if (StringUtil.isNotEmpty(name)) {
            criteria.add("name", OP.LIKE, name);
        }
        if (StringUtil.isNotEmpty(idcard)) {
            criteria.add("idNo", OP.LIKE, idcard);
        }
        if (StringUtil.isNotEmpty(physicalExamNo)) {
            criteria.add("meNumber", OP.LIKE, physicalExamNo);
        }
        if (StringUtil.isNotEmpty(barCode)) {
            criteria.add("barCode", barCode);
        }
        if (ObjectUtil.isNotEmpty(doneQuestion)) {
            if(doneQuestion == 2) {
                criteria.add(new Criteria("doneQuestion", doneQuestion).add(LOP.OR, "doneQuestion", OP.IS, "null"));
            } else {
                criteria.add("doneQuestion", doneQuestion);
            }

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

    public String getPhysicalExamNo() {
        return physicalExamNo;
    }

    public void setPhysicalExamNo(String physicalExamNo) {
        this.physicalExamNo = physicalExamNo;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Integer getDoneQuestion() {
        return doneQuestion;
    }

    public void setDoneQuestion(Integer doneQuestion) {
        this.doneQuestion = doneQuestion;
    }

    /*    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }*/
}
