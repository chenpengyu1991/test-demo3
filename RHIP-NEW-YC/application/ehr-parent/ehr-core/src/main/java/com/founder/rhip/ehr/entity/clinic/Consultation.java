package com.founder.rhip.ehr.entity.clinic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MS_CONSULTATION")
public class Consultation implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "ID", columnDefinition = "NUMBER|自增长序列|11|", length = 11, nullable = false)
  private Long id;

  @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
  private String ehrId;

  @Column(name = "PERSON_ID", columnDefinition = "NUMBER|人员ID|", length = 11, nullable = true)
  private Long personId;

  @Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|健康档案编号||", length = 17, nullable = true)
  private String healthFileNo;

  @Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证号||", length = 18, nullable = true)
  private String idcard;

  @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
  private String name;

  @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
  private String gender;

  @Column(name = "CONSULATION_REASON", columnDefinition = "VARCHAR2|会诊原因||", length = 200, nullable = true)
  private String consulationReason;

  @Column(name = "CONSULATION_OPINION", columnDefinition = "VARCHAR2|会诊建议||", length = 200, nullable = true)
  private String consulationOpinion;

  @Column(name = "CONSULATION_ORG_AND_NAME", columnDefinition = "VARCHAR2|会诊机构和医生姓名||", length = 4000, nullable = true)
  private String consulationOrgAndName;

  @Column(name = "MANAGE_DOCTOR_CODE", columnDefinition = "VARCHAR2|责任医生编号||", length = 18, nullable = true)
  private String manageDoctorCode;

  @Column(name = "MANAGE_DOCTOR_NAME", columnDefinition = "VARCHAR2|责任医生姓名||", length = 50, nullable = true)
  private String manageDoctorName;

  @Column(name = "CONSULATION_DATE", columnDefinition = "DATE|会诊日期||", nullable = true)
  private Date consulationDate;

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

    public String getHealthFileNo() {
        return healthFileNo;
    }

    public void setHealthFileNo(String healthFileNo) {
        this.healthFileNo = healthFileNo;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getConsulationReason() {
        return consulationReason;
    }

    public void setConsulationReason(String consulationReason) {
        this.consulationReason = consulationReason;
    }

    public String getConsulationOpinion() {
        return consulationOpinion;
    }

    public void setConsulationOpinion(String consulationOpinion) {
        this.consulationOpinion = consulationOpinion;
    }

    public String getConsulationOrgAndName() {
        return consulationOrgAndName;
    }

    public void setConsulationOrgAndName(String consulationOrgAndName) {
        this.consulationOrgAndName = consulationOrgAndName;
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

    public Date getConsulationDate() {
        return consulationDate;
    }

    public void setConsulationDate(Date consulationDate) {
        this.consulationDate = consulationDate;
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
