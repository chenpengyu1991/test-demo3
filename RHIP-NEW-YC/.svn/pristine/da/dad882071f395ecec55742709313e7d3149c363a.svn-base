package com.founder.rhip.ehr.entity.healtheducation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by chen.q on 15-6-8.
 */

@Entity
@Table(name = "HEALTH_PROMORION")
public class HealthPromorion {
    private static final long serialVersionUID = -4042562865383051809L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
    private Long id;

    @Column(name = "PROMORION_DATE", columnDefinition = "DATE|发布日期||", nullable = true)
    private Date promorionDate;

    @Column(name = "PROMORION_TITLE", columnDefinition = "VARCHAR2|宣传标题||", length = 200, nullable = true)
    private String promorionTitle;

    @Column(name = "PROMORION_CONTENT", columnDefinition = "VARCHAR2|宣传内容功能||", length = 4000, nullable = true)
    private String promorionContent;

    @Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|发布机构代码||", length = 20, nullable = true)
    private String organCode;

    @Column(name = "ORGAN_NAME", columnDefinition = "VARCHAR2|发布机构名称||", length = 70, nullable = true)
    private String organName;

    @Column(name = "USER_CODE", columnDefinition = "VARCHAR2|发布人CODE||", length = 50, nullable = true)
    private String userCode;

    @Column(name = "USER_NAME", columnDefinition = "VARCHAR2|发布人名||", length = 50, nullable = true)
    private String userName;

    @Column(name = "CREATE_DATE", columnDefinition = "DATE|创建时间||", nullable = true)
    private Date createDate;

    private String operatorType;//1查看2修改3新增

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPromorionDate() {
        return promorionDate;
    }

    public void setPromorionDate(Date promorionDate) {
        this.promorionDate = promorionDate;
    }

    public String getPromorionTitle() {
        return promorionTitle;
    }

    public void setPromorionTitle(String promorionTitle) {
        this.promorionTitle = promorionTitle;
    }

    public String getPromorionContent() {
        return promorionContent;
    }

    public void setPromorionContent(String promorionContent) {
        this.promorionContent = promorionContent;
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

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }
}
