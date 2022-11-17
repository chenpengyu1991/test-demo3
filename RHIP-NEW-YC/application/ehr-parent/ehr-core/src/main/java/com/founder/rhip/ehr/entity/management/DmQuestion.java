package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by admin on 2017/5/17.
 */
@Entity
@Table(name = "DM_QUESTION")
public class DmQuestion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|主键|, length = 11, nullable =true")
    private Long id;
    @Column(name = "QUESTION_CODE", columnDefinition = "NUMBER|问题编号|, length = 11, nullable = false")
    private Long questionCode;
    @Column(name = "QUESTION", columnDefinition = "VARCHAR2|问题|, length = 150, nullable = false")
    private String question;
    @Column(name = "TYPE", columnDefinition = "VARCHAR2|1单选2多选|, length = 1, nullable = false")
    private String type;
    @Column(name = "RIGHT_ANSWER", columnDefinition = "VARCHAR2|正确答案|, length = 8, nullable = false")
    private String rightAnswer;
    @Column(name = "UNKNOWN", columnDefinition = "VARCHAR2|不知道编号|, length = 1, nullable = true")
    private String unknown;
    @Column(name = "ANSWER_CODE", columnDefinition = "VARCHAR2|答案字典编号|, length = 10, nullable = false")
    private String answerCode;

    public void setId(Long id){
        this.id=id;
    }
    public Long getId(){
        return id;
    }
    public void setQuestionCode(Long questionCode){
        this.questionCode=questionCode;
    }
    public Long getQuestionCode(){
        return questionCode;
    }
    public void setQuestion(String question){
        this.question=question;
    }
    public String getQuestion(){
        return question;
    }
    public void setType(String type){
        this.type=type;
    }
    public String getType(){
        return type;
    }
    public void setRightAnswer(String rightAnswer){
        this.rightAnswer=rightAnswer;
    }
    public String getRightAnswer(){
        return rightAnswer;
    }
    public void setUnknown(String unknown){
        this.unknown=unknown;
    }
    public String getUnknown(){
        return unknown;
    }
    public void setAnswerCode(String answerCode){
        this.answerCode=answerCode;
    }
    public String getAnswerCode(){
        return answerCode;
    }
}
