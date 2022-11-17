package com.founder.rhip.ehr.entity.child;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yuanzg on 2017/6/16.
 */
@Entity
@Table(name = "RD_CHILD_WEEK_EXAMNUM")
public class ChildWeekExamNum implements Serializable {
    private static final long serialVersionUID = -8941532920260997923L;

    @Id
    @Column(name = "ID",columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name ="ORGAN_CODE",columnDefinition = "VARCHAR2|登记机构编码|50",length = 50,nullable = true)
    private String organCode;

    @Column(name ="ORGAN_NAME",columnDefinition = "VARCHAR2|登记机构名称|50",length = 50,nullable = true)
    private String organName;

    @Column(name = "CHILD_EXAMNUM",columnDefinition = "NUMBER|一周内儿童体检预约数|11|", length = 11, nullable = true)
    private int childExamnum;

    @Column(name = "CREATE_DATE",columnDefinition = "DATE|创建时间||", nullable = true)
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public int getChildExamnum() {
        return childExamnum;
    }

    public void setChildExamnum(int childExamnum) {
        this.childExamnum = childExamnum;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
