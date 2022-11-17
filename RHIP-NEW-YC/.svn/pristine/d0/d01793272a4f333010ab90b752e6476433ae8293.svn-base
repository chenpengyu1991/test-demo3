package com.founder.rhip.ehr.entity.clinic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "MS_RECEPTION")
public class Reception implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|自增长序列|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
    private String ehrId;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|人员ID||", length = 11, nullable = true)
    private Long personId;

    @Column(name = "SUBJECTIVE_DATA", columnDefinition = "VARCHAR2|就诊者的主观资料||", length = 200, nullable = true)
    private String subjectiveData;

    @Column(name = "OBJECTIVE_DATA", columnDefinition = "VARCHAR2|就诊者的客观资料||", length = 200, nullable = true)
    private String objectiveData;

    @Column(name = "ASSESSMENT", columnDefinition = "VARCHAR2|评估||", length = 200, nullable = true)
    private String assessment;

    @Column(name = "DISPOSAL_PLAN", columnDefinition = "VARCHAR2|处置计划||", length = 200, nullable = true)
    private String disposalPlan;

    @Column(name = "MANAGE_DOCTOR_CODE", columnDefinition = "VARCHAR2|责任医生编号||", length = 18, nullable = true)
    private String manageDoctorCode;

    @Column(name = "MANAGE_DOCTOR_NAME", columnDefinition = "VARCHAR2|责任医生姓名||", length = 50, nullable = true)
    private String manageDoctorName;

    @Column(name = "RECEPTION_DATE", columnDefinition = "DATE|接诊日期||", nullable = true)
    private Date receptionDate;

    @Column(name = "CREATE_DATE", columnDefinition = "DATE|创建时间||", nullable = true)
    private Date createDate;

    @Column(name = "CREATE_USER", columnDefinition = "VARCHAR2|创建用户||", length = 20, nullable = true)
    private String createUser;

    @Column(name = "CREATE_ORG", columnDefinition = "VARCHAR2|创建机构||", length = 20, nullable = true)
    private String createOrg;

    @Column(name = "UPDATE_DATE", columnDefinition = "DATE|更新时间||", nullable = true)
    private Date updateDate;

    @Column(name = "UPDATE_USER", columnDefinition = "VARCHAR2|更新人||", length = 20, nullable = true)
    private String updateUser;

    @Column(name = "UPDATE_ORG", columnDefinition = "VARCHAR2|更新机构||", length = 20, nullable = true)
    private String updateOrg;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER|是否被删除||", length = 1, nullable = true)
    private Integer isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEhrId() {
        return ehrId;
    }

    public void setEhrId(String ehrId) {
        this.ehrId = ehrId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getSubjectiveData() {
        return subjectiveData;
    }

    public void setSubjectiveData(String subjectiveData) {
        this.subjectiveData = subjectiveData;
    }

    public String getObjectiveData() {
        return objectiveData;
    }

    public void setObjectiveData(String objectiveData) {
        this.objectiveData = objectiveData;
    }

    public String getAssessment() {
        return assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }

    public String getDisposalPlan() {
        return disposalPlan;
    }

    public void setDisposalPlan(String disposalPlan) {
        this.disposalPlan = disposalPlan;
    }

    public String getManageDoctorCode() {
        return manageDoctorCode;
    }

    public void setManageDoctorCode(String manageDoctorCode) {
        this.manageDoctorCode = manageDoctorCode;
    }

    public String getManageDoctorName() {
        return manageDoctorName;
    }

    public void setManageDoctorName(String manageDoctorName) {
        this.manageDoctorName = manageDoctorName;
    }

    public Date getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(Date receptionDate) {
        this.receptionDate = receptionDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateOrg() {
        return createOrg;
    }

    public void setCreateOrg(String createOrg) {
        this.createOrg = createOrg;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateOrg() {
        return updateOrg;
    }

    public void setUpdateOrg(String updateOrg) {
        this.updateOrg = updateOrg;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
