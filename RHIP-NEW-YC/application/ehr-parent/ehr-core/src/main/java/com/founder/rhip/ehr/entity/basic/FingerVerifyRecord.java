package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "FINGER_VERIFY_RECORD")
public class FingerVerifyRecord implements Serializable {

    private static final long serialVersionUID = 1L;

/*    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|人员ID|11|", length = 11, nullable = false)
    private Long personId;*/

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证号|18|", length = 18, nullable = false)
    private String idcard;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名|50|", length = 50, nullable = true)
    private String name;

    @Column(name = "EXE_CODE", columnDefinition = "VARCHAR2|类型|2|", length = 2, nullable = true)
    private String exeCode;

    @Column(name = "EXE_DES", columnDefinition = "VARCHAR2|类型描述|20|", length = 20, nullable = true)
    private String exeDes;

    @Column(name = "RESULT", columnDefinition = "VARCHAR2|验证结果|1|", length = 1, nullable = true)
    private String result;

    @Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
    private Date createTime;

    @Column(name = "CREATE_USER", columnDefinition = "VARCHAR2|创建人员|20|", length = 20, nullable = true)
    private String createUser;

    @Column(name = "CREATE_NAME", columnDefinition = "VARCHAR2|操作人姓名|20|", length = 20, nullable = true)
    private String createName;

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExeCode() {
        return exeCode;
    }

    public void setExeCode(String exeCode) {
        this.exeCode = exeCode;
    }

    public String getExeDes() {
        return exeDes;
    }

    public void setExeDes(String exeDes) {
        this.exeDes = exeDes;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }
}