package com.founder.rhip.ehr.entity.clinic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "MS_STUDY_EVENT")
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.NONE)
public class StudyEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
    private String ehrId;

    @Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|记录表编号||", length = 20, nullable = true)
    private String recordNumber;

    @Column(name = "BAR_CODE", columnDefinition = "VARCHAR2|条形码||", length = 20, nullable = true)
    private String barCode;

    @Column(name = "INVOICE_NUMBER", columnDefinition = "VARCHAR2|发票号码||", length = 20, nullable = true)
    private String invoiceNumber;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
    private String name;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
    private String gender;

    @Column(name = "AGE", columnDefinition = "VARCHAR2|年龄||", length = 20, nullable = true)
    private String age;

    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况||", length = 3, nullable = true)
    private String marriage;

    @Column(name = "INSPECTION_TITLE", columnDefinition = "VARCHAR2|检查单标题||", length = 50, nullable = true)
    private String inspectionTitle;

    @Column(name = "INSPECTION_TYPE", columnDefinition = "VARCHAR2|检查/检验类别||", length = 100, nullable = true)
    private String inspectionType;

    @Column(name = "INSPECTION_NAME", columnDefinition = "VARCHAR2|检查/检验名称||", length = 50, nullable = true)
    @XmlElement
    private String inspectionName;

    @Column(name = "INSPECTION_ITEM_CODE", columnDefinition = "VARCHAR2|检查/检验项目代码||", length = 20, nullable = true)
    private String inspectionItemCode;

    @Column(name = "INSPECTION_ITEM_NAME", columnDefinition = "VARCHAR2|检查/检验项目名称||", length = 80, nullable = true)
    private String inspectionItemName;

    @Column(name = "INSPECTION_QUANTIFY_RESULT", columnDefinition = "NUMBER|检查/检验定量结果||", length = 8, nullable = true)
    private Integer inspectionQuantifyResult;

    @Column(name = "INSPECTION_RESULT", columnDefinition = "VARCHAR2|检查/检验结果代码||", length = 1, nullable = true)
    private String inspectionResult;

    @Column(name = "INSPECTION_UNIT", columnDefinition = "VARCHAR2|检查/检验计量单位||", length = 20, nullable = true)
    private String inspectionUnit;

    @Column(name = "LESIONS_NAME", columnDefinition = "VARCHAR2|病变名称||", length = 50, nullable = true)
    private String lesionsName;

    @Column(name = "FINDINGS", columnDefinition = "VARCHAR2|检查所见||", length = 100, nullable = true)
    @XmlElement
    private String findings;

    @Column(name = "CONCLUSION_CODE", columnDefinition = "VARCHAR2|结论代码||", length = 10, nullable = true)
    private String conclusionCode;

    @Column(name = "CONCLUSION_DESC", columnDefinition = "VARCHAR2|结论描述||", length = 100, nullable = true)
    @XmlElement
    private String conclusionDesc;

    @Column(name = "SUGGESTION", columnDefinition = "VARCHAR2|建议||", length = 200, nullable = true)
    @XmlElement
    private String suggestion;

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
    @XmlElement
    private String auditName;

    @Column(name = "AUDIT_IDCARD", columnDefinition = "VARCHAR2|审核人身份证||", length = 18, nullable = true)
    private String auditIdCard;

    @Column(name = "AUDIT_DATE", columnDefinition = "DATE|审核时间||", nullable = true)
    @XmlElement
    private Date auditDate;

    @Column(name = "CHECK_PEOPLE_CODE", columnDefinition = "VARCHAR2|检查（测）人员工号||", length = 18, nullable = true)
    private String checkPeopleCode;

    @Column(name = "CHECK_PEOPLE_NAME", columnDefinition = "VARCHAR2|检查（测）人员姓名||", length = 50, nullable = true)
    @XmlElement
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
    
	@Column(name = "OTHERCARDTYPE", columnDefinition = "VARCHAR2|其他就医卡证类型||", length = 2, nullable = true)
	private String othercardtype;

	@Column(name = "OTHERCARDNO", columnDefinition = "VARCHAR2|其他就医卡证号码||", length = 24, nullable = true)
	private String othercardno;

	@Column(name = "PROJ_CAT_CODE", columnDefinition = "VARCHAR2|检查分类代码||", length = 2, nullable = true)
	private String projCatCode;

	@Column(name = "CKPT_CODE", columnDefinition = "VARCHAR2|检查部位代码||", length = 2, nullable = true)
	private String ckptCode;

	@Column(name = "CKPT_NAME", columnDefinition = "VARCHAR2|检查部位名称||", length = 30, nullable = true)
	private String ckptName;

	@Column(name = "IMAGE_UIDADDR", columnDefinition = "VARCHAR2|影像UID地址||", length = 18, nullable = true)
	private String imageUidaddr;

	@Column(name = "EQPT_CAT_CODE", columnDefinition = "VARCHAR2|设备分类代码||", length = 18, nullable = true)
	private String eqptCatCode;

	@Column(name = "EQPT_NO", columnDefinition = "VARCHAR2|检查仪器编号||", length = 24, nullable = true)
	private String eqptNo;

	@Column(name = "EQPT_NAME", columnDefinition = "VARCHAR2|检查仪器名称||", length = 50, nullable = true)
	private String eqptName;

	@Column(name = "DIAG_MARK", columnDefinition = "VARCHAR2|中医/西医诊断标志||", length = 1, nullable = true)
	private String diagMark;
	
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";
	
    @Column(name = "IS_LIMIT", columnDefinition = "NUMBER|是否限制||", length = 1, nullable = true)
    private Integer isLimit = -1;
    
	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;
	
	@Column(name = "OP_EM_IN_EX_MARK", columnDefinition = "VARCHAR2|门急诊、住院、体检标识||", length = 1, nullable = true)
	private String opEmInExMark;
	
	
	@Transient
	private String opEmHpExMark;
	
	@Transient
	private String opEmHpExNo;
	
	@Transient
	private String applyOrgCode;
	
	@Transient
	private String checkOrgCode;
	
	@Transient
	private String reportOrgCode;
	
	@Transient
	private String reportDateDesc;
	
	@Transient
	private String applyDateDesc;
	
	@Transient
	private String checkDateDesc;

    @Transient
    private String outpatientNo;

    @Transient
    private String idCard;
    
    @Transient
    private String diagMarkDesc;
   
    public String getDiagMarkDesc() {
		return diagMarkDesc;
	}

	public void setDiagMarkDesc(String diagMarkDesc) {
		this.diagMarkDesc = diagMarkDesc;
	}

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

    public String getBarCode() {
        return this.barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getInvoiceNumber() {
        return this.invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
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

    public String getInspectionTitle() {
        return this.inspectionTitle;
    }

    public void setInspectionTitle(String inspectionTitle) {
        this.inspectionTitle = inspectionTitle;
    }

    public String getInspectionType() {
        return this.inspectionType;
    }

    public void setInspectionType(String inspectionType) {
        this.inspectionType = inspectionType;
    }

    public String getInspectionName() {
        return this.inspectionName;
    }

    public void setInspectionName(String inspectionName) {
        this.inspectionName = inspectionName;
    }

    public String getInspectionItemCode() {
        return this.inspectionItemCode;
    }

    public void setInspectionItemCode(String inspectionItemCode) {
        this.inspectionItemCode = inspectionItemCode;
    }

    public String getInspectionItemName() {
        return this.inspectionItemName;
    }

    public void setInspectionItemName(String inspectionItemName) {
        this.inspectionItemName = inspectionItemName;
    }

    public Integer getInspectionQuantifyResult() {
        return this.inspectionQuantifyResult;
    }

    public void setInspectionQuantifyResult(Integer inspectionQuantifyResult) {
        this.inspectionQuantifyResult = inspectionQuantifyResult;
    }

    public String getInspectionResult() {
        return this.inspectionResult;
    }

    public void setInspectionResult(String inspectionResult) {
        this.inspectionResult = inspectionResult;
    }

    public String getInspectionUnit() {
        return this.inspectionUnit;
    }

    public void setInspectionUnit(String inspectionUnit) {
        this.inspectionUnit = inspectionUnit;
    }

    public String getLesionsName() {
        return this.lesionsName;
    }

    public void setLesionsName(String lesionsName) {
        this.lesionsName = lesionsName;
    }

    public String getFindings() {
        return this.findings;
    }

    public void setFindings(String findings) {
        this.findings = findings;
    }

    public String getConclusionCode() {
        return this.conclusionCode;
    }

    public void setConclusionCode(String conclusionCode) {
        this.conclusionCode = conclusionCode;
    }

    public String getConclusionDesc() {
        return this.conclusionDesc;
    }

    public void setConclusionDesc(String conclusionDesc) {
        this.conclusionDesc = conclusionDesc;
    }

    public String getSuggestion() {
        return this.suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
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

	public String getProjCatCode() {
		return projCatCode;
	}

	public void setProjCatCode(String projCatCode) {
		this.projCatCode = projCatCode;
	}

	public String getCkptCode() {
		return ckptCode;
	}

	public void setCkptCode(String ckptCode) {
		this.ckptCode = ckptCode;
	}

	public String getCkptName() {
		return ckptName;
	}

	public void setCkptName(String ckptName) {
		this.ckptName = ckptName;
	}

	public String getImageUidaddr() {
		return imageUidaddr;
	}

	public void setImageUidaddr(String imageUidaddr) {
		this.imageUidaddr = imageUidaddr;
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

	public String getDiagMark() {
		return diagMark;
	}

	public void setDiagMark(String diagMark) {
		this.diagMark = diagMark;
	}

	
	public String getApplyOrgCode() {
		this.applyOrgCode = hospitalCode;
		return applyOrgCode;
	}

	
	public void setApplyOrgCode(String applyOrgCode) {
		this.applyOrgCode = applyOrgCode;
	}

	
	public String getCheckOrgCode() {
		this.checkOrgCode = hospitalCode;
		return checkOrgCode;
	}

	
	public void setCheckOrgCode(String checkOrgCode) {
		this.checkOrgCode = checkOrgCode;
	}

	
	public String getReportOrgCode() {
		this.reportOrgCode = hospitalCode;
		return reportOrgCode;
	}

	
	public void setReportOrgCode(String reportOrgCode) {
		this.reportOrgCode = reportOrgCode;
	}

	
	public String getReportDateDesc() {
		return reportDateDesc;
	}

	
	public void setReportDateDesc(String reportDateDesc) {
		this.reportDateDesc = reportDateDesc;
	}

	public String getOpEmHpExMark() {
		return opEmHpExMark;
	}

	
	public void setOpEmHpExMark(String opEmHpExMark) {
		this.opEmHpExMark = opEmHpExMark;
	}

	public String getOpEmHpExNo() {
		return opEmHpExNo;
	}

	
	public void setOpEmHpExNo(String opEmHpExNo) {
		this.opEmHpExNo = opEmHpExNo;
	}

	
	public String getApplyDateDesc() {
		return applyDateDesc;
	}

	
	public void setApplyDateDesc(String applyDateDesc) {
		this.applyDateDesc = applyDateDesc;
	}

	
	public String getCheckDateDesc() {
		return checkDateDesc;
	}

	
	public void setCheckDateDesc(String checkDateDesc) {
		this.checkDateDesc = checkDateDesc;
	}

	
	public String getProcessStatus() {
		return processStatus;
	}

	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	
	public Integer getIsLimit() {
		return isLimit;
	}

	
	public void setIsLimit(Integer isLimit) {
		this.isLimit = isLimit;
	}


    public String getOutpatientNo() {
        return outpatientNo;
    }

    public void setOutpatientNo(String outpatientNo) {
        this.outpatientNo = outpatientNo;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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
