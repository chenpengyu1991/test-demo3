package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by admin on 2017/5/17.
 */
@Entity
@Table(name = "DM_ANSWER")
public class DmAnswer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "ANSWER_PEOPLE_ID", columnDefinition = "NUMBER|答题人ID|, length = 11, nullable = false")
    private Long answerPeopleId;
    @Column(name = "ANSWER", columnDefinition = "VARCHAR2|答案|, length = 12, nullable = true")
    private String answer;
    @Column(name = "QUESTION_CODE", columnDefinition = "NUMBER|题目编号|, length = 11, nullable = true")
    private Long questionCode;
    @Column(name = "ANSWER_VALUE", columnDefinition = "VARCHAR2|自定义答案|, length = 12, nullable = true")
    private String answerValue;
    @Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间|, length = 0, nullable = true")
    private Date createTime;

    public void setAnswerPeopleId(Long answerPeopleId){
        this.answerPeopleId=answerPeopleId;
    }
    public Long getAnswerPeopleId(){
        return answerPeopleId;
    }
    public void setAnswer(String answer){
        this.answer=answer;
    }
    public String getAnswer(){
        return answer;
    }
    public void setQuestionCode(Long questionCode){
        this.questionCode=questionCode;
    }
    public Long getQuestionCode(){
        return questionCode;
    }
    public void setAnswerValue(String answerValue){
        this.answerValue=answerValue;
    }
    public String getAnswerValue(){
        return answerValue;
    }
    public void setCreateTime(Date createTime){
        this.createTime=createTime;
    }
    public Date getCreateTime(){
        return createTime;
    }
}
