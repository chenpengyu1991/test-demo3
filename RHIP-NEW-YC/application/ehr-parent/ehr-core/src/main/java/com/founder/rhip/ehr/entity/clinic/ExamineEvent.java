package com.founder.rhip.ehr.entity.clinic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.founder.fasf.util.ObjectUtil;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MS_EXAMINE_EVENT")
public class ExamineEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
    private String ehrId;

    @Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|记录表单编号||", length = 20, nullable = true)
    private String recordNumber;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
    private String name;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
    private String gender;

    @Column(name = "AGE", columnDefinition = "VARCHAR2|年龄||", length = 20, nullable = true)
    private String age;

    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况||", length = 3, nullable = true)
    private String marriage;

    @Column(name = "CHECK_LIST_TITLE", columnDefinition = "VARCHAR2|检验单标题||", length = 50, nullable = true)
    private String checkListTitle;

    @Column(name = "SAMPLE_TYPE_NAME", columnDefinition = "VARCHAR2|样本类型名称||", length = 50, nullable = true)
    private String sampleTypeName;

    @Column(name = "INSPECTION_TYPE", columnDefinition = "VARCHAR2|检查/检验类别||", length = 100, nullable = true)
    private String inspectionType;

    @Column(name = "HOSPITAL_CODE", columnDefinition = "VARCHAR2|医疗机构代码||", length = 10, nullable = true)
    private String hospitalCode;

    @Column(name = "HOSPITAL_NAME", columnDefinition = "VARCHAR2|医疗机构名称||", length = 70, nullable = true)
    private String hospitalName;

    @Column(name = "APPLY_ROOM_CODE", columnDefinition = "VARCHAR2|申请科室代码||", length = 5, nullable = true)
    private String applyRoomCode;

    @Column(name = "APPLY_ROOM_NAME", columnDefinition = "VARCHAR2|申请科室名称||", length = 50, nullable = true)
    private String applyRoomName;

    @Column(name = "APPLY_PEOPLE_NO", columnDefinition = "VARCHAR2|申请人工号||", length = 18, nullable = true)
    private String applyPeopleNo;

    @Column(name = "APPLY_PEOPLE_NAME", columnDefinition = "VARCHAR2|申请人名称||", length = 50, nullable = true)
    private String applyPeopleName;

    @Column(name = "APPLY_PEOPLE_IDCARD", columnDefinition = "VARCHAR2|申请人身份证||", length = 18, nullable = true)
    private String applyPeopleIdCard;

    @Column(name = "APPLY_DATE", columnDefinition = "DATE|申请时间||", nullable = true)
    private Date applyDate;

    @Column(name = "AUDIT_CODE", columnDefinition = "VARCHAR2|审核人工号||", length = 18, nullable = true)
    private String auditCode;

    @Column(name = "AUDIT_NAME", columnDefinition = "VARCHAR2|审核人姓名||", length = 50, nullable = true)
    private String auditName;

    @Column(name = "AUDIT_IDCARD", columnDefinition = "VARCHAR2|审核人身份证||", length = 18, nullable = true)
    private String auditIdCard;

    @Column(name = "AUDIT_DATE", columnDefinition = "DATE|审核时间||", nullable = true)
    private Date auditDate;

    @Column(name = "CHECK_PEOPLE_CODE", columnDefinition = "VARCHAR2|检查（测）人员工号||", length = 18, nullable = true)
    private String checkPeopleCode;

    @Column(name = "CHECK_PEOPLE_NAME", columnDefinition = "VARCHAR2|检查（测）人员姓名||", length = 50, nullable = true)
    private String checkPeopleName;

    @Column(name = "CHECK_PEOPLE_IDCARD", columnDefinition = "VARCHAR2|检查（测）人员身份证||", length = 18, nullable = true)
    private String checkPeopleIdCard;

    @Column(name = "CHECK_DATE", columnDefinition = "DATE|检查（测）日期||", nullable = true)
    private Date checkDate;

    @Column(name = "UPDATE_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 50, nullable = true)
    private String updateName;

    @Column(name = "UPDATE_IDCARD", columnDefinition = "VARCHAR2|更新人身份证号||", length = 18, nullable = true)
    private String updateIdcard;

    @Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP|更新日期和时间||", nullable = true)
    private Date updateDate;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;
    
	@Column(name = "EXAMINATION_NUMBER", columnDefinition = "VARCHAR2|检验单编号||", length = 50, nullable = true)
	private String examinationNumber;
	
	@Column(name = "EXAMINATION_CODE", columnDefinition = "VARCHAR2|检查/检验项目代码||", length = 50, nullable = true)
	private String examinationCode;
	
	@Column(name = "EXAMINATION_NAME", columnDefinition = "VARCHAR2|检查/检验项目名称||", length = 70, nullable = true)
	private String examinationName;
	
	@Column(name = "OTHERCARDTYPE", columnDefinition = "VARCHAR2|其他就医卡证类型||", length = 2, nullable = true)
	private String othercardtype;

	@Column(name = "OTHERCARDNO", columnDefinition = "VARCHAR2|其他就医卡证号码||", length = 24, nullable = true)
	private String othercardno;

	@Column(name = "OP_EM_HP_EX_NO", columnDefinition = "VARCHAR2|门诊/急诊/住院/体检编号||", length = 24, nullable = true)
	private String opEmHpExNo;

	@Column(name = "OP_EM_HP_EX_MARK", columnDefinition = "VARCHAR2|门诊/急诊/住院/体检标识||", length = 24, nullable = true)
	private String opEmHpExMark;

	@Column(name = "RPT_CAT_CODE", columnDefinition = "VARCHAR2|报告单类别代码||", length = 2, nullable = true)
	private String rptCatCode;

	@Column(name = "SAMP_DT", columnDefinition = "DATE|标本采样时间||", nullable = true)
	private Date sampDt;

	@Column(name = "ACCEPT_DT", columnDefinition = "DATE|接收标本时间||", nullable = true)
	private Date acceptDt;

	@Column(name = "EQPT_CAT_CODE", columnDefinition = "VARCHAR2|设备类别代码||", length = 7, nullable = true)
	private String eqptCatCode;

	@Column(name = "EQPT_NO", columnDefinition = "VARCHAR2|仪器编号||", length = 24, nullable = true)
	private String eqptNo;

	@Column(name = "EQPT_NAME", columnDefinition = "VARCHAR2|仪器名称||", length = 100, nullable = true)
	private String eqptName;

	@Column(name = "TESTMETHOD", columnDefinition = "VARCHAR2|检验方法||", length = 100, nullable = true)
	private String testmethod;
	
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";
	
    @Column(name = "IS_LIMIT", columnDefinition = "NUMBER|是否限制||", length = 1, nullable = true)
    private Integer isLimit = -1;
	
	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;
	
	@Column(name = "OP_EM_IN_EX_MARK", columnDefinition = "VARCHAR2|门急诊、住院、体检标识||", length = 1, nullable = true)
	private String opEmInExMark;
	
	@Transient
	private String applyOrgCode;
	
	@Transient
	private String checkOrgCode;
	
	@Transient
	private String applyDateDesc;
	
	@Transient
	private String sampDtDesc;

	@Transient
	private String acceptDtDesc;
	
	@Transient
	private String checkDateDesc;

    @Transient
    private String idcard;
	
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

    public String getRecordNumber() {
        return this.recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
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

    public String getCheckListTitle() {
        return this.checkListTitle;
    }

    public void setCheckListTitle(String checkListTitle) {
        this.checkListTitle = checkListTitle;
    }

    public String getSampleTypeName() {
        return this.sampleTypeName;
    }

    public void setSampleTypeName(String sampleTypeName) {
        this.sampleTypeName = sampleTypeName;
    }

    public String getInspectionType() {
        return this.inspectionType;
    }

    public void setInspectionType(String inspectionType) {
        this.inspectionType = inspectionType;
    }

    public String getHospitalCode() {
        return this.hospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }

    public String getHospitalName() {
        return this.hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getApplyRoomCode() {
        return this.applyRoomCode;
    }

    public void setApplyRoomCode(String applyRoomCode) {
        this.applyRoomCode = applyRoomCode;
    }

    public String getApplyRoomName() {
        return this.applyRoomName;
    }

    public void setApplyRoomName(String applyRoomName) {
        this.applyRoomName = applyRoomName;
    }

    public String getApplyPeopleNo() {
        return this.applyPeopleNo;
    }

    public void setApplyPeopleNo(String applyPeopleNo) {
        this.applyPeopleNo = applyPeopleNo;
    }

    public String getApplyPeopleName() {
        return this.applyPeopleName;
    }

    public void setApplyPeopleName(String applyPeopleName) {
        this.applyPeopleName = applyPeopleName;
    }

    public String getApplyPeopleIdCard() {
        return this.applyPeopleIdCard;
    }

    public void setApplyPeopleIdCard(String applyPeopleIdCard) {
        this.applyPeopleIdCard = applyPeopleIdCard;
    }

    public Date getApplyDate() {
        return this.applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getAuditCode() {
        return this.auditCode;
    }

    public void setAuditCode(String auditCode) {
        this.auditCode = auditCode;
    }

    public String getAuditName() {
        return this.auditName;
    }

    public void setAuditName(String auditName) {
        this.auditName = auditName;
    }

    public String getAuditIdCard() {
        return this.auditIdCard;
    }

    public void setAuditIdCard(String auditIdCard) {
        this.auditIdCard = auditIdCard;
    }

    public Date getAuditDate() {
        return this.auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
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

    public Date getCheckDate() {
        return this.checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
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

	
	public String getExaminationNumber() {
		return examinationNumber;
	}

	
	public void setExaminationNumber(String examinationNumber) {
		this.examinationNumber = examinationNumber;
	}

	
	public String getExaminationCode() {
		return examinationCode;
	}

	
	public void setExaminationCode(String examinationCode) {
		this.examinationCode = examinationCode;
	}

	
	public String getExaminationName() {
		return examinationName;
	}

	public void setExaminationName(String examinationName) {
		this.examinationName = examinationName;
	}

	public String getOthercardtype() {
		return othercardtype;
	}

	public void setOthercardtype(String othercardtype) {
		this.othercardtype = othercardtype;
	}

	public String getOthercardno() {
		return othercardno;
	}

	public void setOthercardno(String othercardno) {
		this.othercardno = othercardno;
	}

	public String getOpEmHpExNo() {
		return opEmHpExNo;
	}

	public void setOpEmHpExNo(String opEmHpExNo) {
		this.opEmHpExNo = opEmHpExNo;
	}

	public String getOpEmHpExMark() {
		return opEmHpExMark;
	}

	public void setOpEmHpExMark(String opEmHpExMark) {
		this.opEmHpExMark = opEmHpExMark;
	}

	public String getRptCatCode() {
		return rptCatCode;
	}

	public void setRptCatCode(String rptCatCode) {
		this.rptCatCode = rptCatCode;
	}

	public Date getSampDt() {
		return sampDt;
	}

	public void setSampDt(Date sampDt) {
		this.sampDt = sampDt;
	}

	public Date getAcceptDt() {
		return acceptDt;
	}

	public void setAcceptDt(Date acceptDt) {
		this.acceptDt = acceptDt;
	}

	public String getEqptCatCode() {
		return eqptCatCode;
	}

	public void setEqptCatCode(String eqptCatCode) {
		this.eqptCatCode = eqptCatCode;
	}

	public String getEqptNo() {
		return eqptNo;
	}

	public void setEqptNo(String eqptNo) {
		this.eqptNo = eqptNo;
	}

	public String getEqptName() {
		return eqptName;
	}

	public void setEqptName(String eqptName) {
		this.eqptName = eqptName;
	}

	public String getTestmethod() {
		return testmethod;
	}

	public void setTestmethod(String testmethod) {
		this.testmethod = testmethod;
	}

	
	public String getApplyOrgCode() {
		if (ObjectUtil.isNotEmpty(hospitalCode)) {
			applyOrgCode = hospitalCode;
		}
		return applyOrgCode;
	}

	
	public void setApplyOrgCode(String applyOrgCode) {
		this.applyOrgCode = applyOrgCode;
	}

	
	public String getCheckOrgCode() {
		if (ObjectUtil.isNotEmpty(hospitalCode)) {
			this.checkOrgCode = hospitalCode;
		}
		return checkOrgCode;
	}

	
	public void setCheckOrgCode(String checkOrgCode) {
		this.checkOrgCode = checkOrgCode;
	}

	
	public String getProcessStatus() {
		return processStatus;
	}

	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	
	public String getApplyDateDesc() {
		return applyDateDesc;
	}

	
	public void setApplyDateDesc(String applyDateDesc) {
		this.applyDateDesc = applyDateDesc;
	}

	
	public String getSampDtDesc() {
		return sampDtDesc;
	}

	
	public void setSampDtDesc(String sampDtDesc) {
		this.sampDtDesc = sampDtDesc;
	}

	
	public String getAcceptDtDesc() {
		return acceptDtDesc;
	}

	
	public void setAcceptDtDesc(String acceptDtDesc) {
		this.acceptDtDesc = acceptDtDesc;
	}

	
	public String getCheckDateDesc() {
		return checkDateDesc;
	}

	
	public void setCheckDateDesc(String checkDateDesc) {
		this.checkDateDesc = checkDateDesc;
	}

	
	public Integer getIsLimit() {
		return isLimit;
	}

	
	public void setIsLimit(Integer isLimit) {
		this.isLimit = isLimit;
	}

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

	public Date getGatherDate() {
		return gatherDate;
	}

	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
	}

	public String getOpEmInExMark() {
		return opEmInExMark;
	}

	public void setOpEmInExMark(String opEmInExMark) {
		this.opEmInExMark = opEmInExMark;
	}
    
    
}
