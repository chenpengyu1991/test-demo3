package com.founder.rhip.fds.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "SERVICE_PLAN")
public class ServicePlan implements Serializable {
   
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "ORGAN_CODE")
    private String organCode;

    @Column(name = "TEAM_CODE")
    private String teamCode;

    @Column(name = "DOCTOR_ID")
    private Long doctorId;

    @Column(name = "DOCTOR_IDCARD")
    private String doctorIdcard;

    @Column(name = "PACKAGE_CODE")
    private String packageCode;

    @Column(name = "ITEM_CODE")
    private String itemCode;

    @Column(name = "PERSON_ID")
    private Long personId;

    @Column(name = "PERSON_IDCARD")
    private String personIdcard;

    @Column(name = "PLAN_DATE")
    private Date planDate;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "VALID")
    private String valid;

    @Column(name = "PLAN_YEAR")
    private String planYear;

    @Column(name = "DISEASE_TYPE")
    private String diseaseType;

    @Column(name = "DATA_SRC")
    private String dataSrc;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "CREATE_USER")
    private String createUser;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "UPDATE_USER")
    private String updateUser;

    @Column(name = "UPDATE_DATE")
    private Date updateDate;

    /**
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }


    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }
    /**
     * @return DOCTOR_ID
     */
    public Long getDoctorId() {
        return doctorId;
    }

    /**
     * @param doctorId
     */
    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    /**
     * @return PACKAGE_CODE
     */
    public String getPackageCode() {
        return packageCode;
    }

    /**
     * @param packageCode
     */
    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    /**
     * @return ITEM_CODE
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return PERSON_ID
     */
    public Long getPersonId() {
        return personId;
    }

    /**
     * @param personId
     */
    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    /**
     * @return PLAN_DATE
     */
    public Date getPlanDate() {
        return planDate;
    }

    /**
     * @param planDate
     */
    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    /**
     * @return VALID
     */
    public String getValid() {
        return valid;
    }

    /**
     * @param valid
     */
    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getPlanYear() {
        return planYear;
    }

    public void setPlanYear(String planYear) {
        this.planYear = planYear;
    }

    public String getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType;
    }

    public String getDataSrc() {
        return dataSrc;
    }

    public void setDataSrc(String dataSrc) {
        this.dataSrc = dataSrc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return CREATE_USER
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * @return CREATE_DATE
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return UPDATE_USER
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * @param updateUser
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * @return UPDATE_DATE
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDoctorIdcard() {
        return doctorIdcard;
    }

    public void setDoctorIdcard(String doctorIdcard) {
        this.doctorIdcard = doctorIdcard;
    }

    public String getPersonIdcard() {
        return personIdcard;
    }

    public void setPersonIdcard(String personIdcard) {
        this.personIdcard = personIdcard;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}