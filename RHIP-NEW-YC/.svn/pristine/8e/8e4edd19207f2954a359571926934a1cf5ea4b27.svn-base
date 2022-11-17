package com.founder.rhip.ehr.entity.clinic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "EHR_HEALTH_EVENT")
public class EHRHealthEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static final Integer EHR_OLD_PEPOLE_FLAG_NOT_PROCESS = 0;
    
    public static final Integer EHR_OLD_PEPOLE_FLAG_PROCESS = 1;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
    private String ehrId;

    @Column(name = "EHR_TYPE", columnDefinition = "VARCHAR2|活动类型||", length = 12, nullable = true)
    private String ehrType;

    @Column(name = "EHR_NAME", columnDefinition = "VARCHAR2|活动名称||", length = 70, nullable = true)
    private String ehrName;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
    private String name;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
    private String gender;

    @Column(name = "AGE", columnDefinition = "VARCHAR2|年龄||", length = 20, nullable = true)
    private String age;

    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况||", length = 3, nullable = true)
    private String marriage;

    @Column(name = "DISEASE_CODE", columnDefinition = "VARCHAR2|疾病代码||", length = 8, nullable = true)
    private String diseaseCode;

    @Column(name = "DISEASE_NAME", columnDefinition = "VARCHAR2|疾病名称||", length = 100, nullable = true)
    private String diseaseName;

    @Column(name = "CLINIC_YEAR", columnDefinition = "VARCHAR2|就诊年份||", length = 4, nullable = true)
    private String clinicYear;

    @Column(name = "CLINIC_MONTH", columnDefinition = "VARCHAR2|就诊月份||", length = 2, nullable = true)
    private String clinicMonth;

    @Column(name = "CLINIC_DATE", columnDefinition = "DATE|就诊日期时间||", nullable = true)
    private Date clinicDate;

    @Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|创建机构代码||", length = 20, nullable = true)
    private String createOrganCode;

    @Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|创建机构名称||", length = 70, nullable = true)
    private String createOrganName;

    @Column(name = "CREATE_ROOM_CODE", columnDefinition = "VARCHAR2|创建科室代码||", length = 5, nullable = true)
    private String createRoomCode;

    @Column(name = "CREATE_ROOM_NAME", columnDefinition = "VARCHAR2|创建科室名称||", length = 50, nullable = true)
    private String createRoomName;

    @Column(name = "CREATE_DATE", columnDefinition = "DATE|创建时间||", nullable = true)
    private Date createDate;

    @Column(name = "CREATE_PERSON", columnDefinition = "VARCHAR2|创建人姓名||", length = 50, nullable = true)
    private String createPerson;

    @Column(name = "CREATE_IDCARD", columnDefinition = "VARCHAR2|创建人身份证号||", length = 3, nullable = true)
    private String createIdcard;

    @Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|更新机构代码||", length = 20, nullable = true)
    private String updateOrganCode;

    @Column(name = "UPDATE_ORGAN_NAME", columnDefinition = "VARCHAR2|更新机构名称||", length = 70, nullable = true)
    private String update;

    @Column(name = "UPDATE_ROOM_CODE", columnDefinition = "VARCHAR2|更新科室代码||", length = 5, nullable = true)
    private String updateRoomCode;

    @Column(name = "UPDATE_ROOM_NAME", columnDefinition = "VARCHAR2|更新科室名称||", length = 50, nullable = true)
    private String updateRoomName;

    @Column(name = "UPDATE_DATE", columnDefinition = "DATE|更新日期和时间||", nullable = true)
    private Date updateDate;

    @Column(name = "UPDATE_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 50, nullable = true)
    private String updateName;

    @Column(name = "UPDATE_IDCARD", columnDefinition = "VARCHAR2|更新人身份证号||", length = 100, nullable = true)
    private String updateIdcard;

    @Column(name = "CLINIC_ORGAN_CODE", columnDefinition = "VARCHAR2|就诊机构代码||", length = 20, nullable = false)
    private String clinicOrganCode;

    @Column(name = "CLINIC_ORGAN_NAME", columnDefinition = "VARCHAR2|就诊机构名称||", length = 70, nullable = false)
    private String clinicOrganName;

    @Column(name = "CLINIC_ROOM_CODE", columnDefinition = "VARCHAR2|就诊科室代码||", length = 20, nullable = false)
    private String clinicRoomCode;

    @Column(name = "CLINIC_ROOM_NAME", columnDefinition = "VARCHAR2|就诊科室名称||", length = 50, nullable = false)
    private String clinicRoomName;
    
    @Column(name = "EHR_OLD_PEPOLE_FLAG", columnDefinition = "Integer|老年人扁平化处理标志0：未处理  1：已处理||", length = 1, nullable = true)
    private Integer ehrOldPepoleFlag = 0;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

    @Column(name = "DATA_SOURCE", columnDefinition = "NUMBER||数据来源 1：来自系统  2：来自集成  默认为：1", length = 1, nullable = true)
    private Integer dataSource;
    
    @Column(name = "IS_LIMIT", columnDefinition = "NUMBER|是否限制||", length = 1, nullable = true)
    private Integer isLimit = -1;
    
	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;

//    @Column(name = "ID_CARD", columnDefinition = "VARCHAR2|身份证号||", length = 18,nullable = true)
//    private String idCard;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getEhrId() {
        return ehrId;
    }

    public void setEhrId(String ehrId) {
        this.ehrId = ehrId;
    }

    public String getEhrName() {
        return ehrName;
    }

    public void setEhrName(String ehrName) {
        this.ehrName = ehrName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getDiseaseCode() {
        return this.diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    public String getDiseaseName() {
        return this.diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getClinicYear() {
        return this.clinicYear;
    }

    public void setClinicYear(String clinicYear) {
        this.clinicYear = clinicYear;
    }

    public String getClinicMonth() {
        return this.clinicMonth;
    }

    public void setClinicMonth(String clinicMonth) {
        this.clinicMonth = clinicMonth;
    }

    public Date getClinicDate() {
        return this.clinicDate;
    }

    public void setClinicDate(Date clinicDate) {
        this.clinicDate = clinicDate;
    }

    public String getCreateOrganCode() {
        return this.createOrganCode;
    }

    public void setCreateOrganCode(String createOrganCode) {
        this.createOrganCode = createOrganCode;
    }

    public String getCreateOrganName() {
        return this.createOrganName;
    }

    public void setCreateOrganName(String createOrganName) {
        this.createOrganName = createOrganName;
    }

    public String getCreateRoomCode() {
        return this.createRoomCode;
    }

    public void setCreateRoomCode(String createRoomCode) {
        this.createRoomCode = createRoomCode;
    }

    public String getCreateRoomName() {
        return this.createRoomName;
    }

    public void setCreateRoomName(String createRoomName) {
        this.createRoomName = createRoomName;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreatePerson() {
        return this.createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public String getCreateIdcard() {
        return this.createIdcard;
    }

    public void setCreateIdcard(String createIdcard) {
        this.createIdcard = createIdcard;
    }

    public String getUpdateOrganCode() {
        return this.updateOrganCode;
    }

    public void setUpdateOrganCode(String updateOrganCode) {
        this.updateOrganCode = updateOrganCode;
    }

    public String getUpdate() {
        return this.update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getUpdateRoomCode() {
        return this.updateRoomCode;
    }

    public void setUpdateRoomCode(String updateRoomCode) {
        this.updateRoomCode = updateRoomCode;
    }

    public String getUpdateRoomName() {
        return this.updateRoomName;
    }

    public void setUpdateRoomName(String updateRoomName) {
        this.updateRoomName = updateRoomName;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateName() {
        return this.updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getUpdateIdcard() {
        return this.updateIdcard;
    }

    public void setUpdateIdcard(String updateIdcard) {
        this.updateIdcard = updateIdcard;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getClinicOrganCode() {
        return clinicOrganCode;
    }

    public void setClinicOrganCode(String clinicOrganCode) {
        this.clinicOrganCode = clinicOrganCode;
    }

    public String getClinicOrganName() {
        return clinicOrganName;
    }

    public void setClinicOrganName(String clinicOrganName) {
        this.clinicOrganName = clinicOrganName;
    }

    public String getClinicRoomCode() {
        return clinicRoomCode;
    }

    public void setClinicRoomCode(String clinicRoomCode) {
        this.clinicRoomCode = clinicRoomCode;
    }

    public String getClinicRoomName() {
        return clinicRoomName;
    }

    public void setClinicRoomName(String clinicRoomName) {
        this.clinicRoomName = clinicRoomName;
    }

    public String getEhrType() {
        return ehrType;
    }

    public void setEhrType(String ehrType) {
        this.ehrType = ehrType;
    }

    public Integer getDataSource() {
        return dataSource;
    }

    public void setDataSource(Integer dataSource) {
        this.dataSource = dataSource;
    }

	public Integer getEhrOldPepoleFlag() {
		return ehrOldPepoleFlag;
	}

	public void setEhrOldPepoleFlag(Integer ehrOldPepoleFlag) {
		this.ehrOldPepoleFlag = ehrOldPepoleFlag;
	}

	
	public Integer getIsLimit() {
		return isLimit;
	}

	
	public void setIsLimit(Integer isLimit) {
		this.isLimit = isLimit;
	}

	public Date getGatherDate() {
		return gatherDate;
	}

	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
	}

//    public String getIdCard() {
//        return idCard;
//    }
//
//    public void setIdCard(String idCard) {
//        this.idCard = idCard;
//    }
}
