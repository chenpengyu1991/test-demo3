package com.founder.rhip.ehr.entity.management;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2017/5/17.
 */
@Entity
@Table(name = "DM_ANSWER_PEOPLE")
public class DmAnswerPeople implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|主键|, length = 11, nullable =true")
    private Long id;
    @Column(name = "SEX", columnDefinition = "VARCHAR2|性别编号|, length = 1, nullable = true")
    private String sex;
    @Column(name = "AGE", columnDefinition = "LONG|年龄|, length = 2147483647, nullable = true")
    private Long age;
    @Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间|, length = 0, nullable = true")
    private Date createTime;

    @Transient
    private List<DmAnswer> answers; //答案

    public List<DmAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<DmAnswer> answers) {
        this.answers = answers;
    }

    public void setId(Long id){
        this.id=id;
    }
    public Long getId(){
        return id;
    }
    public void setSex(String sex){
        this.sex=sex;
    }
    public String getSex(){
        return sex;
    }
    public void setAge(Long age){
        this.age=age;
    }
    public Long getAge(){
        return age;
    }
    public void setCreateTime(Date createTime){
        this.createTime=createTime;
    }
    public Date getCreateTime(){
        return createTime;
    }
}
