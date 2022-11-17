package com.founder.rhip.ehr.entity.clinic;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.StringUtils;

import com.founder.fasf.util.ObjectUtil;

@Entity
@Table(name = "MS_EXAMINE_DETAIL")
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.NONE)
public class ExamineDetail implements Serializable {

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

    @Column(name = "SAMPLE_ID", columnDefinition = "VARCHAR2|样本识别号||", length = 20, nullable = true)
    private String sampleId;

    @Column(name = "INSPECTION_TYPE", columnDefinition = "VARCHAR2|检查/检验类别||", length = 100, nullable = true)
    private String inspectionType;

    @Column(name = "INSPECTION_ITEM_CODE", columnDefinition = "VARCHAR2|检查/检验项目代码||", length = 20, nullable = true)
    private String inspectionItemCode;

    @Column(name = "INSPECTION_ITEM_NAME", columnDefinition = "VARCHAR2|检查/检验项目名称||", length = 80, nullable = true)
    @XmlElement
    private String inspectionItemName;

    @Column(name = "INSPECTION_QUANTIFY_RESULT", columnDefinition = "NUMBER|检查/检验定量结果||", nullable = true)
    private BigDecimal inspectionQuantifyResult;

    @Column(name = "INSPECTION_RESULT", columnDefinition = "VARCHAR2|检查检验结果||", length = 200, nullable = true)
    @XmlElement
    private String inspectionResult;

    @Column(name = "INSPECTION_UNIT", columnDefinition = "VARCHAR2|检查/检验计量单位||", length = 20, nullable = true)
    @XmlElement
    private String inspectionUnit;

    @Column(name = "REFERENCE_RANGE", columnDefinition = "VARCHAR2|参考范围||", length = 100, nullable = true)
    @XmlElement
    private String referenceRange;

    @Column(name = "PROMPT", columnDefinition = "VARCHAR2|提示||", length = 100, nullable = true)
    @XmlElement
    private String prompt;

    @Column(name = "CONCLUSION", columnDefinition = "VARCHAR2|结论||", length = 100, nullable = true)
    private String conclusion;

    @Column(name = "CHECK_DATE", columnDefinition = "DATE|检查（测）日期||", nullable = true)
    private Date checkDate;

    @Column(name = "DETECTION_PEOPLE_NAME", columnDefinition = "VARCHAR2|检查（测）人员姓名||", length = 50, nullable = true)
    private String detectionPeopleName;

    @Column(name = "DETECTION_ORG_NAME", columnDefinition = "VARCHAR2|检查（测）机构名称||", length = 70, nullable = true)
    private String detectionOrgName;

    @Column(name = "DETECTION_ROOM_CODE", columnDefinition = "VARCHAR2|检查（测）科室代码||", length = 5, nullable = true)
    private String detectionRoomCode;

    @Column(name = "DETECTION_ROOM_NAME", columnDefinition = "VARCHAR2|检查（测）科室名称||", length = 50, nullable = true)
    private String detectionRoomName;

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
	
	private String referenceLowValue;
	
	private String referenceHighValue;
	
	@Column(name = "EX_PROJ_SN", columnDefinition = "VARCHAR2|检验项目顺序号||", length = 1, nullable = true)
	private String exProjSn;

	@Column(name = "UCL", columnDefinition = "NUMBER|危急重值上限||", length = 10, precision = 1, nullable = true)
	private Double ucl;

	@Column(name = "LCL", columnDefinition = "NUMBER|危急重值下限||", length = 10, precision = 1, nullable = true)
	private Double lcl;
	
    @Column(name = "ANALYSIS_STATUS", columnDefinition = "VARCHAR2|是否分析处理状态||", length = 1, nullable = true)
    private String analysisStatus;
    
    @Column(name = "IS_LIMIT", columnDefinition = "NUMBER|是否限制||", length = 1, nullable = true)
    private Integer isLimit = -1;
    
    @Column(name = "HOSPITAL_CODE", columnDefinition = "VARCHAR2|医疗机构代码||", length = 20, nullable = true)
    private String hospitalCode;
    
	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;
	
	@Transient
	private String checkResultType;
	
	@Transient
	private String checkResultTypeDesc;
	
    public String getCheckResultTypeDesc() {
		return checkResultTypeDesc;
	}

	public void setCheckResultTypeDesc(String checkResultTypeDesc) {
		this.checkResultTypeDesc = checkResultTypeDesc;
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

    public String getSampleId() {
        return this.sampleId;
    }

    public void setSampleId(String sampleId) {
        this.sampleId = sampleId;
    }

    public String getInspectionType() {
        return this.inspectionType;
    }

    public void setInspectionType(String inspectionType) {
        this.inspectionType = inspectionType;
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
	
	public BigDecimal getInspectionQuantifyResult() {
		return inspectionQuantifyResult;
	}

	
	public void setInspectionQuantifyResult(BigDecimal inspectionQuantifyResult) {
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

    public String getReferenceRange() {
        return this.referenceRange;
    }

    public void setReferenceRange(String referenceRange) {
        this.referenceRange = referenceRange;
    }

    public String getPrompt() {
        return this.prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
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

    public String getDetectionPeopleName() {
        return this.detectionPeopleName;
    }

    public void setDetectionPeopleName(String detectionPeopleName) {
        this.detectionPeopleName = detectionPeopleName;
    }

    public String getDetectionOrgName() {
        return this.detectionOrgName;
    }

    public void setDetectionOrgName(String detectionOrgName) {
        this.detectionOrgName = detectionOrgName;
    }

    public String getDetectionRoomCode() {
        return this.detectionRoomCode;
    }

    public void setDetectionRoomCode(String detectionRoomCode) {
        this.detectionRoomCode = detectionRoomCode;
    }

    public String getDetectionRoomName() {
        return this.detectionRoomName;
    }

    public void setDetectionRoomName(String detectionRoomName) {
        this.detectionRoomName = detectionRoomName;
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

	@Transient
	public String getReferenceLowValue() {
		if (ObjectUtil.isNotEmpty(referenceRange)) {
			referenceLowValue = StringUtils.substringBefore(referenceRange, "---");
		}
		return referenceLowValue;
	}

	
	public void setReferenceLowValue(String referenceLowValue) {
		this.referenceLowValue = referenceLowValue;
	}

	@Transient
	public String getReferenceHighValue() {
		if (ObjectUtil.isNotEmpty(referenceRange)) {
			referenceHighValue = StringUtils.substringAfter(referenceRange, "---");
		}
		return referenceHighValue;
	}

	
	public void setReferenceHighValue(String referenceHighValue) {
		this.referenceHighValue = referenceHighValue;
	}

	public String getExProjSn() {
		return exProjSn;
	}

	public void setExProjSn(String exProjSn) {
		this.exProjSn = exProjSn;
	}

	public Double getUcl() {
		return ucl;
	}

	public void setUcl(Double ucl) {
		this.ucl = ucl;
	}

	public Double getLcl() {
		return lcl;
	}

	public void setLcl(Double lcl) {
		this.lcl = lcl;
	}

	
	public String getCheckResultType() {
		// 1:正常 2:异常 3:不确定 TODO:实际检验结果值需要确认
		if (ObjectUtil.isNullOrEmpty(prompt)) {
			checkResultType = "3";
		} else if (StringUtils.equals(prompt, "0")) {
			checkResultType = "1";
		} else {
			checkResultType = "2";
		}
		return checkResultType;
	}

	
	public void setCheckResultType(String checkResultType) {
		this.checkResultType = checkResultType;
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

	
	public String getHospitalCode() {
		return hospitalCode;
	}

	
	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	public Date getGatherDate() {
		return gatherDate;
	}

	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
	}

	

	
}
