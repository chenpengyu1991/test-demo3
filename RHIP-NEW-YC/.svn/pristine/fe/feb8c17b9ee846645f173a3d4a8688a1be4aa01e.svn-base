package com.founder.rhip.ehr.entity.clinic;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "MS_OBSERVATION_INFO")
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.NONE)
public class ObservationInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
    private String ehrId;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
    private String name;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
    private String gender;

    @Column(name = "AGE", columnDefinition = "NUMBER|年龄||", length = 20, nullable = true)
    private String age;

    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况||", length = 3, nullable = true)
    private String marriage;

    @Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|记录表单编号||", length = 20, nullable = true)
    private String recordNumber;

    @Column(name = "OBSERVATION_ITEM_CODE", columnDefinition = "VARCHAR2|观察项目代码||", length = 30, nullable = true)
    private String observationItemCode;

    @Column(name = "OBSERVATION_ITEM_NAME", columnDefinition = "VARCHAR2|观察项目名称||", length = 60, nullable = true)
    @XmlElement(required = true)
    private String observationItemName;

    @Column(name = "OBSERVATION_METHOD_CODE", columnDefinition = "VARCHAR2|观察方法代码||", length = 30, nullable = true)
    private String observationMethodCode;

    @Column(name = "OBSERVATION_METHOD_NAME", columnDefinition = "VARCHAR2|观察方法名称||", length = 100, nullable = true)
    private String observationMethodName;

    @Column(name = "OBSERVATION_RESULT_CODE", columnDefinition = "VARCHAR2|观察结果代码||", length = 30, nullable = true)
    private String observationResultCode;

    @Column(name = "OBSERVATION_RESULT", columnDefinition = "VARCHAR2|观察结果||", length = 200, nullable = true)
    @XmlElement(required = true)
    private String observationResult;

    @Column(name = "OBSERVATION_UNIT_CODE", columnDefinition = "VARCHAR2|观察结果单位代码||", length = 30, nullable = true)
    private String observationUnitCode;

    @Column(name = "OBSERVATION_UNIT_NAME", columnDefinition = "VARCHAR2|观察结果单位名称||", length = 70, nullable = true)
    @XmlElement(required = true)
    private String observationUnitName;

    @Column(name = "RESULT_START_DATE", columnDefinition = "DATE|结果开始（发现）日期||", nullable = true)
    private Date resultStartDate;

    @Column(name = "RESULT_STOP_DATE", columnDefinition = "DATE|结果停止(治愈)日期||", nullable = true)
    private Date resultStopDate;

    @Column(name = "REMARKS", columnDefinition = "VARCHAR2|备注||", length = 100, nullable = true)
    private String remarks;

    @Column(name = "CONCLUSION", columnDefinition = "VARCHAR2|结论||", length = 200, nullable = true)
    private String conclusion;

    @Column(name = "CHECK_DATE", columnDefinition = "DATE|检查（测）日期||", nullable = true)
    private Date checkDate;

    @Column(name = "CHECK_ORG_NAME", columnDefinition = "VARCHAR2|检查（测）机构名称||", length = 70, nullable = true)
    private String checkOrgName;

    @Column(name = "CHECK_ROOM_CODE", columnDefinition = "VARCHAR2|检查（测）科室代码||", length = 5, nullable = true)
    private String checkRoomCode;

    @Column(name = "CHECK_ROOM_NAME", columnDefinition = "VARCHAR2|检查（测）科室名称||", length = 50, nullable = true)
    private String checkRoomName;

    @Column(name = "CHECK_PEOPLE_CODE", columnDefinition = "VARCHAR2|检查（测）人员工号||", length = 18, nullable = true)
    private String checkPeopleCode;

    @Column(name = "CHECK_PEOPLE_NAME", columnDefinition = "VARCHAR2|检查（测）人员姓名||", length = 50, nullable = true)
    private String checkPeopleName;

    @Column(name = "CHECK_PEOPLE_IDCARD", columnDefinition = "VARCHAR2|检查（测）人员身份证||", length = 18, nullable = true)
    private String checkPeopleIdCard;

    @Column(name = "UPDATE_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 50, nullable = true)
    private String updateName;

    @Column(name = "UPDATE_IDCARD", columnDefinition = "VARCHAR2|更新人身份证号||", length = 18, nullable = true)
    private String updateIdcard;

    @Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP|更新日期和时间||", nullable = true)
    private Date updateDate;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;
    
    @Column(name = "CHECK_ORG_CODE", columnDefinition = "VARCHAR2|创建机构代码||", length = 50, nullable = true)
    private String checkOrgCode;
    
    @Column(name = "ANALYSIS_STATUS", columnDefinition = "VARCHAR2|是否分析处理状态||", length = 1, nullable = true)
    private String analysisStatus;
    
    @Column(name = "IS_LIMIT", columnDefinition = "NUMBER|是否限制||", length = 1, nullable = true)
    private Integer isLimit = -1;
    
	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;
    
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getEhrId() {
        return this.ehrId;
    }

    public void setEhrId(String ehrId) {
        this.ehrId = ehrId;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getRecordNumber() {
        return this.recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public String getObservationItemCode() {
        return this.observationItemCode;
    }

    public void setObservationItemCode(String observationItemCode) {
        this.observationItemCode = observationItemCode;
    }

    public String getObservationItemName() {
        return this.observationItemName;
    }

    public void setObservationItemName(String observationItemName) {
        this.observationItemName = observationItemName;
    }

    public String getObservationMethodCode() {
        return this.observationMethodCode;
    }

    public void setObservationMethodCode(String observationMethodCode) {
        this.observationMethodCode = observationMethodCode;
    }

    public String getObservationMethodName() {
        return this.observationMethodName;
    }

    public void setObservationMethodName(String observationMethodName) {
        this.observationMethodName = observationMethodName;
    }

    public String getObservationResultCode() {
        return this.observationResultCode;
    }

    public void setObservationResultCode(String observationResultCode) {
        this.observationResultCode = observationResultCode;
    }

    public String getObservationResult() {
        return this.observationResult;
    }

    public void setObservationResult(String observationResult) {
        this.observationResult = observationResult;
    }

    public String getObservationUnitCode() {
        return this.observationUnitCode;
    }

    public void setObservationUnitCode(String observationUnitCode) {
        this.observationUnitCode = observationUnitCode;
    }

    public String getObservationUnitName() {
        return this.observationUnitName;
    }

    public void setObservationUnitName(String observationUnitName) {
        this.observationUnitName = observationUnitName;
    }

    public Date getResultStartDate() {
        return this.resultStartDate;
    }

    public void setResultStartDate(Date resultStartDate) {
        this.resultStartDate = resultStartDate;
    }

    public Date getResultStopDate() {
        return this.resultStopDate;
    }

    public void setResultStopDate(Date resultStopDate) {
        this.resultStopDate = resultStopDate;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getConclusion() {
        return this.conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public Date getCheckDate() {
        return this.checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckOrgName() {
        return this.checkOrgName;
    }

    public void setCheckOrgName(String checkOrgName) {
        this.checkOrgName = checkOrgName;
    }

    public String getCheckRoomCode() {
        return this.checkRoomCode;
    }

    public void setCheckRoomCode(String checkRoomCode) {
        this.checkRoomCode = checkRoomCode;
    }

    public String getCheckRoomName() {
        return this.checkRoomName;
    }

    public void setCheckRoomName(String checkRoomName) {
        this.checkRoomName = checkRoomName;
    }

    public String getCheckPeopleCode() {
        return this.checkPeopleCode;
    }

    public void setCheckPeopleCode(String checkPeopleCode) {
        this.checkPeopleCode = checkPeopleCode;
    }

    public String getCheckPeopleName() {
        return this.checkPeopleName;
    }

    public void setCheckPeopleName(String checkPeopleName) {
        this.checkPeopleName = checkPeopleName;
    }

    public String getCheckPeopleIdCard() {
        return this.checkPeopleIdCard;
    }

    public void setCheckPeopleIdCard(String checkPeopleIdCard) {
        this.checkPeopleIdCard = checkPeopleIdCard;
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

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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

	public String getCheckOrgCode() {
		return checkOrgCode;
	}

	public void setCheckOrgCode(String checkOrgCode) {
		this.checkOrgCode = checkOrgCode;
	}

	
	public String getAnalysisStatus() {
		return analysisStatus;
	}

	
	public void setAnalysisStatus(String analysisStatus) {
		this.analysisStatus = analysisStatus;
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

	
	
	
}
