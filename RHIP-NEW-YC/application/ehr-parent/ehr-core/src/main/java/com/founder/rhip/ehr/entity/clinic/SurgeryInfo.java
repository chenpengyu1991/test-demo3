package com.founder.rhip.ehr.entity.clinic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "MS_SURGERY_INFO")
public class SurgeryInfo implements Serializable {

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

    @Column(name = "AGE", columnDefinition = "VARCHAR2|年龄||", length = 20, nullable = true)
    private String age;

    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况||", length = 3, nullable = true)
    private String marriage;

    @Column(name = "HOSPITAL_CODE", columnDefinition = "VARCHAR2|医疗机构代码||", length = 10, nullable = true)
    private String hospitalCode;

    @Column(name = "HOSPITAL_NAME", columnDefinition = "VARCHAR2|医疗机构名称||", length = 70, nullable = true)
    private String hospitalName;

    @Column(name = "ANESTHESIA_METHOD_CODE", columnDefinition = "VARCHAR2|麻醉方法代码||", length = 2, nullable = true)
    private String anesthesiaMethodCode;

    @Column(name = "ANESTHESIA_METHOD_NAME", columnDefinition = "VARCHAR2|麻醉方法名称||", length = 50, nullable = true)
    private String anesthesiaMethodName;

    @Column(name = "ANESTHESIA_DOCTOR_CODE", columnDefinition = "VARCHAR2|麻醉医师工号||", length = 18, nullable = true)
    private String anesthesiaDoctorCode;

    @Column(name = "ANESTHESIA_DOCTOR_NAME", columnDefinition = "VARCHAR2|麻醉医师姓名||", length = 50, nullable = true)
    private String anesthesiaDoctorName;

    @Column(name = "ANESTHESIA_DOCTOR_IDCARD", columnDefinition = "VARCHAR2|麻醉医师身份证号||", length = 18, nullable = true)
    private String anesthesiaDoctorIdCard;

    @Column(name = "INCISION_HEALING_GRADE_CODE", columnDefinition = "VARCHAR2|切口愈合等级代码||", length = 1, nullable = true)
    private String incisionHealingGradeCode;

    @Column(name = "INCISION_HEALING_GRADE_NAME", columnDefinition = "VARCHAR2|切口愈合等级名称||", length = 50, nullable = true)
    private String incisionHealingGradeName;

    @Column(name = "OPERTATION_CODE", columnDefinition = "VARCHAR2|手术/操作代码||", length = 5, nullable = true)
    private String opertationCode;

    @Column(name = "OPERTATION_NAME", columnDefinition = "VARCHAR2|手术/操作名称||", length = 80, nullable = true)
    private String opertationName;

    @Column(name = "OPERTATION_DESC", columnDefinition = "VARCHAR2|手术操作名称的详细描述||", length = 200, nullable = true)
    private String opertationDesc;

    @Column(name = "OPERTATION_TARGET_CODE", columnDefinition = "VARCHAR2|手术操作目标部位代码||", length = 5, nullable = true)
    private String opertationTargetCode;

    @Column(name = "OPERTATION_TARGET_NAME", columnDefinition = "VARCHAR2|手术操作目标部位名称||", length = 50, nullable = true)
    private String opertationTargetName;

    @Column(name = "OPERATOR_CODE", columnDefinition = "VARCHAR2|手术者姓名工号||", length = 18, nullable = true)
    private String operatorCode;

    @Column(name = "OPERATOR_NAME", columnDefinition = "VARCHAR2|手术者姓名||", length = 50, nullable = true)
    private String operatorName;

    @Column(name = "OPERATION_UNIT_NAME", columnDefinition = "VARCHAR2|手术机构名称||", length = 70, nullable = true)
    private String operationUnitName;

    @Column(name = "OPERATOR_IDCARD", columnDefinition = "VARCHAR2|手术者姓名身份证||", length = 18, nullable = true)
    private String operatorIdCard;

    @Column(name = "OPERTATION_DATE", columnDefinition = "TIMESTAMP|手术/操作日期时间||", nullable = true)
    private Date opertationDate;

    @Column(name = "OPERATION_LEVEL_NAME", columnDefinition = "VARCHAR2|手术级别名称||", length = 50, nullable = true)
    private String operationLevelName;

    @Column(name = "OPERATION_ASSISTANT_ONE", columnDefinition = "VARCHAR2|手术、操作医师1助||", length = 50, nullable = true)
    private String operationAssistantOne;

    @Column(name = "OPERATION_ASSISTANT_TWO", columnDefinition = "VARCHAR2|手术、操作医师2助||", length = 50, nullable = true)
    private String operationAssistantTwo;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;
    
    @Column(name = "APPLY_NO", columnDefinition = "VARCHAR2|申请单编号||", length = 50, nullable = true)
    private String applyNo;
    
    @Column(name = "BEGIN_TIME", columnDefinition = "TIMESTAMP|手术开始时间||", nullable = true)
    private Date beginTime;
    
    @Column(name = "END_TIME", columnDefinition = "TIMESTAMP|手术结束时间||", nullable = true)
    private Date endTime;
    
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";
    
	@Column(name = "OP_EM_HP_MARK", columnDefinition = "NUMBER|门急诊住院标识|", length = 1, nullable = true)
	private Integer opEmHpMark;
	
    @Column(name = "ANALYSIS_STATUS", columnDefinition = "VARCHAR2|是否分析处理状态||", length = 1, nullable = true)
    private String analysisStatus = "0";
    
    @Column(name = "IS_LIMIT", columnDefinition = "NUMBER|是否限制||", length = 1, nullable = true)
    private Integer isLimit = -1;
    
    @Column(name = "IS_ANALYSE", columnDefinition = "NUMBER|是否处理手术史||", length = 1, nullable = true)
    private Integer isAnalyse = -1;
    
	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;
	
    @Transient
    private String opEmHpNo;

    @Transient
    private String operationLevelCode;
    
    @Transient
    private String opertationDateDesc;
    
    @Transient
    private String opEmHpMarkDesc;
    
    
    public String getOpEmHpMarkDesc() {
		return opEmHpMarkDesc;
	}

	public void setOpEmHpMarkDesc(String opEmHpMarkDesc) {
		this.opEmHpMarkDesc = opEmHpMarkDesc;
	}

	public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

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

    public String getHospitalCode() {
        return hospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getAnesthesiaMethodCode() {
        return anesthesiaMethodCode;
    }

    public void setAnesthesiaMethodCode(String anesthesiaMethodCode) {
        this.anesthesiaMethodCode = anesthesiaMethodCode;
    }

    public String getAnesthesiaMethodName() {
        return anesthesiaMethodName;
    }

    public void setAnesthesiaMethodName(String anesthesiaMethodName) {
        this.anesthesiaMethodName = anesthesiaMethodName;
    }

    public String getAnesthesiaDoctorCode() {
        return anesthesiaDoctorCode;
    }

    public void setAnesthesiaDoctorCode(String anesthesiaDoctorCode) {
        this.anesthesiaDoctorCode = anesthesiaDoctorCode;
    }

    public String getAnesthesiaDoctorName() {
        return anesthesiaDoctorName;
    }

    public void setAnesthesiaDoctorName(String anesthesiaDoctorName) {
        this.anesthesiaDoctorName = anesthesiaDoctorName;
    }

    public String getAnesthesiaDoctorIdCard() {
        return anesthesiaDoctorIdCard;
    }

    public void setAnesthesiaDoctorIdCard(String anesthesiaDoctorIdCard) {
        this.anesthesiaDoctorIdCard = anesthesiaDoctorIdCard;
    }

    public String getIncisionHealingGradeCode() {
        return incisionHealingGradeCode;
    }

    public void setIncisionHealingGradeCode(String incisionHealingGradeCode) {
        this.incisionHealingGradeCode = incisionHealingGradeCode;
    }

    public String getIncisionHealingGradeName() {
        return incisionHealingGradeName;
    }

    public void setIncisionHealingGradeName(String incisionHealingGradeName) {
        this.incisionHealingGradeName = incisionHealingGradeName;
    }

    public String getOpertationCode() {
        return opertationCode;
    }

    public void setOpertationCode(String opertationCode) {
        this.opertationCode = opertationCode;
    }

    public String getOpertationName() {
        return opertationName;
    }

    public void setOpertationName(String opertationName) {
        this.opertationName = opertationName;
    }

    public String getOpertationDesc() {
        return opertationDesc;
    }

    public void setOpertationDesc(String opertationDesc) {
        this.opertationDesc = opertationDesc;
    }

    public String getOpertationTargetCode() {
        return opertationTargetCode;
    }

    public void setOpertationTargetCode(String opertationTargetCode) {
        this.opertationTargetCode = opertationTargetCode;
    }

    public String getOpertationTargetName() {
        return opertationTargetName;
    }

    public void setOpertationTargetName(String opertationTargetName) {
        this.opertationTargetName = opertationTargetName;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperationUnitName() {
        return operationUnitName;
    }

    public void setOperationUnitName(String operationUnitName) {
        this.operationUnitName = operationUnitName;
    }

    public String getOperatorIdCard() {
        return operatorIdCard;
    }

    public void setOperatorIdCard(String operatorIdCard) {
        this.operatorIdCard = operatorIdCard;
    }

    public Date getOpertationDate() {
        return opertationDate;
    }

    public void setOpertationDate(Date opertationDate) {
        this.opertationDate = opertationDate;
    }

    public String getOperationLevelName() {
        return operationLevelName;
    }

    public void setOperationLevelName(String operationLevelName) {
        this.operationLevelName = operationLevelName;
    }

    public String getOperationAssistantOne() {
        return operationAssistantOne;
    }

    public void setOperationAssistantOne(String operationAssistantOne) {
        this.operationAssistantOne = operationAssistantOne;
    }

    public String getOperationAssistantTwo() {
        return operationAssistantTwo;
    }

    public void setOperationAssistantTwo(String operationAssistantTwo) {
        this.operationAssistantTwo = operationAssistantTwo;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

	

	public Integer getOpEmHpMark() {
		return opEmHpMark;
	}

	
	
	public String getOpEmHpNo() {
		return opEmHpNo;
	}

	
	public void setOpEmHpNo(String opEmHpNo) {
		this.opEmHpNo = opEmHpNo;
	}

	
	public String getApplyNo() {
		return applyNo;
	}

	
	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}

	
	public String getOperationLevelCode() {
		if (StringUtils.contains(operationLevelName, "一级")) {
			this.operationLevelCode = "1";
		} else if (StringUtils.contains(operationLevelName, "二级")) {
			this.operationLevelCode = "2";
		} else if (StringUtils.contains(operationLevelName, "三级")) {
			this.operationLevelCode = "3";
		}  else if (StringUtils.contains(operationLevelName, "四级")) {
			this.operationLevelCode = "4";
		}
		return operationLevelCode;
	}

	
	public void setOperationLevelCode(String operationLevelCode) {
		this.operationLevelCode = operationLevelCode;
	}

	
	public Date getBeginTime() {
		return beginTime;
	}

	
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	
	public Date getEndTime() {
		return endTime;
	}

	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	
	public String getOpertationDateDesc() {
		return opertationDateDesc;
	}

	
	public void setOpertationDateDesc(String opertationDateDesc) {
		this.opertationDateDesc = opertationDateDesc;
	}

	
	public String getProcessStatus() {
		return processStatus;
	}

	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}



	public void setOpEmHpMark(Integer opEmHpMark) {
		this.opEmHpMark = opEmHpMark;
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

	
	public Integer getIsAnalyse() {
		return isAnalyse;
	}

	
	public void setIsAnalyse(Integer isAnalyse) {
		this.isAnalyse = isAnalyse;
	}

	public Date getGatherDate() {
		return gatherDate;
	}

	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
	}

	
	
}
