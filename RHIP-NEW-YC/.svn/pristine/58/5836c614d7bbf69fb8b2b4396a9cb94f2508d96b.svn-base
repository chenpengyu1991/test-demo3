package com.founder.rhip.ehr.entity.clinic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "MS_DISEASE_DIAGNOSIS_INFO")
public class DiseaseDiagnosisInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
    private String ehrId;

	@Column(name = "DIAGNOSIS_NUMBER", columnDefinition = "VARCHAR2|诊断索引号||", length = 50, nullable = true)
	private String diagnosisNumber;
	
    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
    private String name;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
    private String gender;

    @Column(name = "AGE", columnDefinition = "VARCHAR2|年龄||", length = 20, nullable = true)
    private String age;

    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况||", length = 3, nullable = true)
    private String marriage;

    @Column(name = "DIAGNOSIS_CODE", columnDefinition = "VARCHAR2|诊断代码||", length = 5, nullable = true)
    private String diagnosisCode;

    @Column(name = "DIAGNOSIS_DESC", columnDefinition = "VARCHAR2|诊断名称||", length = 50, nullable = true)
    private String diagnosisDesc;

    @Column(name = "DIAGNOSIS_TYPE_CODE", columnDefinition = "VARCHAR2|诊断类型-代码||", length = 2, nullable = true)
    private String diagnosisTypeCode;

    @Column(name = "PATHOGENESIS_DATE", columnDefinition = "TIMESTAMP|发病日期时间||", nullable = true)
    private Date pathogenesisDate;

    @Column(name = "PRIMARY_SITE", columnDefinition = "VARCHAR2|原发部位||", length = 50, nullable = true)
    private String primarySite;

    @Column(name = "SECONDARY_SITE", columnDefinition = "VARCHAR2|继发（转移）部位||", length = 50, nullable = true)
    private String secondarySite;

    @Column(name = "NLOHMSI_CODE", columnDefinition = "VARCHAR2|病理类型代码||", length = 7, nullable = true)
    private String nlohmsiCode;

    @Column(name = "NLOHMSI_NAME", columnDefinition = "VARCHAR2|病理类型名称||", length = 100, nullable = true)
    private String nlohmsiName;

    @Column(name = "DISEASE_CODE", columnDefinition = "VARCHAR2|疾病代码||", length = 18, nullable = true)
    private String diseaseCode;

    @Column(name = "DISEASE_NAME", columnDefinition = "VARCHAR2|疾病名称||", length = 100, nullable = true)
    private String diseaseName;

    @Column(name = "INHOS_CONDITION_CODE", columnDefinition = "VARCHAR2|入院病情代码||", length = 18, nullable = true)
    private String inhosConditionCode;

    @Column(name = "INHOS_CONDITION_NAME", columnDefinition = "VARCHAR2|入院病情名称||", length = 100, nullable = true)
    private String inhosConditionName;

    @Column(name = "TREATMENT_PLAN", columnDefinition = "VARCHAR2|治疗方案||", length = 200, nullable = true)
    private String treatmentPlan;

    @Column(name = "HEALTH_ASSESSMENT", columnDefinition = "VARCHAR2|健康问题评估||", length = 200, nullable = true)
    private String healthAssessment;

    @Column(name = "DISPOSAL_PLAN", columnDefinition = "VARCHAR2|处置计划||", length = 200, nullable = true)
    private String disposalPlan;

    @Column(name = "HOSPITAL_CODE", columnDefinition = "VARCHAR2|医疗机构代码||", length = 10, nullable = true)
    private String hospitalCode;

    @Column(name = "HOSPITAL_NAME", columnDefinition = "VARCHAR2|医疗机构名称||", length = 70, nullable = true)
    private String hospitalName;

    @Column(name = "DIAGNOSE_DATE", columnDefinition = "DATE|诊断时间||", nullable = true)
    private Date diagnoseDate;

    @Column(name = "DIAGNOSE_ROOM_CODE", columnDefinition = "VARCHAR2|诊断科室代码||", length = 5, nullable = true)
    private String diagnoseRoomCode;

    @Column(name = "DIAGNOSE_ROOM_NAME", columnDefinition = "VARCHAR2|诊断科室名称||", length = 50, nullable = true)
    private String diagnoseRoomName;

    @Column(name = "DIAGNOSE_DOCTOR_CODE", columnDefinition = "VARCHAR2|诊断医生工号||", length = 18, nullable = true)
    private String diagnoseDoctorCode;

    @Column(name = "DIAGNOSE_DOCTOR_NAME", columnDefinition = "VARCHAR2|诊断医生姓名||", length = 50, nullable = true)
    private String diagnoseDoctorName;

    @Column(name = "DIAGNOSE_DOCTOR_IDCARD", columnDefinition = "VARCHAR2|诊断医生身份证号||", length = 18, nullable = true)
    private String diagnoseDoctorIdCard;

    @Column(name = "UPDATE_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 50, nullable = true)
    private String updateName;

    @Column(name = "UPDATE_IDCARD", columnDefinition = "VARCHAR2|更新人身份证号||", length = 18, nullable = true)
    private String updateIdcard;

    @Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP|更新日期和时间||", nullable = true)
    private Date updateDate;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;
    
	@Column(name = "INIT_SUBS_MARK", columnDefinition = "VARCHAR2|初诊/复诊标志||", length = 1, nullable = true)
	private String initSubsMark;

	@Column(name = "CM_MDIS_CODE", columnDefinition = "VARCHAR2|中医诊断疾病代码||", length = 8, nullable = true)
	private String cmMdisCode;

	@Column(name = "CM_MDIS_NAME", columnDefinition = "VARCHAR2|中医诊断疾病名称||", length = 100, nullable = true)
	private String cmMdisName;

	@Column(name = "PIRNCIPAL_DIAGNOSIS", columnDefinition = "VARCHAR2|是否主要诊断||", length = 1, nullable = true)
	private String pirncipalDiagnosis;

	@Column(name = "CM_DIS_NAME", columnDefinition = "VARCHAR2|门急诊中医诊断疾病名称||", length = 8, nullable = true)
	private String cmDisName;

	@Column(name = "CM_DIS_CODE", columnDefinition = "VARCHAR2|门急诊中医诊断疾病编码||", length = 100, nullable = true)
	private String cmDisCode;

	@Column(name = "WM_DIS_NAME", columnDefinition = "VARCHAR2|门急诊西医诊断疾病名称||", length = 100, nullable = true)
	private String wmDisName;
	
    @Column(name = "ANALYSIS_STATUS", columnDefinition = "VARCHAR2|是否分析处理状态||", length = 1, nullable = true)
    private String analysisStatus;
    
    @Column(name = "IS_LIMIT", columnDefinition = "NUMBER|是否限制||", length = 1, nullable = true)
    private Integer isLimit = -1;
    
    @Column(name = "IS_ANALYSE", columnDefinition = "NUMBER|是否处理疾病史||", length = 1, nullable = true)
    private Integer isAnalyse = -1;

    @Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
    private Date gatherDate;
    
    @Column(name = "OP_EM_HP_MARK", columnDefinition = "VARCHAR2|门急诊住院标识1：门诊2：急诊3：住院4：体检||", length = 1, nullable = true)
    private String opEmHpMark;

    @Transient
    private String diagnoseDateDesc;
    
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

    public String getDiagnosisCode() {
        return this.diagnosisCode;
    }

    public void setDiagnosisCode(String diagnosisCode) {
        this.diagnosisCode = diagnosisCode;
    }

    public String getDiagnosisDesc() {
        return this.diagnosisDesc;
    }

    public void setDiagnosisDesc(String diagnosisDesc) {
        this.diagnosisDesc = diagnosisDesc;
    }

    public String getDiagnosisTypeCode() {
        return this.diagnosisTypeCode;
    }

    public void setDiagnosisTypeCode(String diagnosisTypeCode) {
        this.diagnosisTypeCode = diagnosisTypeCode;
    }

    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getInhosConditionCode() {
        return inhosConditionCode;
    }

    public void setInhosConditionCode(String inhosConditionCode) {
        this.inhosConditionCode = inhosConditionCode;
    }

    public String getInhosConditionName() {
        return inhosConditionName;
    }

    public void setInhosConditionName(String inhosConditionName) {
        this.inhosConditionName = inhosConditionName;
    }

    public Date getPathogenesisDate() {
        return this.pathogenesisDate;
    }

    public void setPathogenesisDate(Date pathogenesisDate) {
        this.pathogenesisDate = pathogenesisDate;
    }

    public String getPrimarySite() {
        return this.primarySite;
    }

    public void setPrimarySite(String primarySite) {
        this.primarySite = primarySite;
    }

    public String getSecondarySite() {
        return this.secondarySite;
    }

    public void setSecondarySite(String secondarySite) {
        this.secondarySite = secondarySite;
    }

    public String getNlohmsiCode() {
        return this.nlohmsiCode;
    }

    public void setNlohmsiCode(String nlohmsiCode) {
        this.nlohmsiCode = nlohmsiCode;
    }

    public String getNlohmsiName() {
        return this.nlohmsiName;
    }

    public void setNlohmsiName(String nlohmsiName) {
        this.nlohmsiName = nlohmsiName;
    }

    public String getTreatmentPlan() {
        return this.treatmentPlan;
    }

    public void setTreatmentPlan(String treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    public String getHealthAssessment() {
        return this.healthAssessment;
    }

    public void setHealthAssessment(String healthAssessment) {
        this.healthAssessment = healthAssessment;
    }

    public String getDisposalPlan() {
        return this.disposalPlan;
    }

    public void setDisposalPlan(String disposalPlan) {
        this.disposalPlan = disposalPlan;
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

    public Date getDiagnoseDate() {
        return this.diagnoseDate;
    }

    public void setDiagnoseDate(Date diagnoseDate) {
        this.diagnoseDate = diagnoseDate;
    }

    public String getDiagnoseRoomCode() {
        return this.diagnoseRoomCode;
    }

    public void setDiagnoseRoomCode(String diagnoseRoomCode) {
        this.diagnoseRoomCode = diagnoseRoomCode;
    }

    public String getDiagnoseRoomName() {
        return this.diagnoseRoomName;
    }

    public void setDiagnoseRoomName(String diagnoseRoomName) {
        this.diagnoseRoomName = diagnoseRoomName;
    }

    public String getDiagnoseDoctorCode() {
        return this.diagnoseDoctorCode;
    }

    public void setDiagnoseDoctorCode(String diagnoseDoctorCode) {
        this.diagnoseDoctorCode = diagnoseDoctorCode;
    }

    public String getDiagnoseDoctorName() {
        return this.diagnoseDoctorName;
    }

    public void setDiagnoseDoctorName(String diagnoseDoctorName) {
        this.diagnoseDoctorName = diagnoseDoctorName;
    }

    public String getDiagnoseDoctorIdCard() {
        return this.diagnoseDoctorIdCard;
    }

    public void setDiagnoseDoctorIdCard(String diagnoseDoctorIdCard) {
        this.diagnoseDoctorIdCard = diagnoseDoctorIdCard;
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

	public String getDiagnosisNumber() {
		return diagnosisNumber;
	}

	public void setDiagnosisNumber(String diagnosisNumber) {
		this.diagnosisNumber = diagnosisNumber;
	}

	public String getInitSubsMark() {
		return initSubsMark;
	}

	public void setInitSubsMark(String initSubsMark) {
		this.initSubsMark = initSubsMark;
	}

	public String getCmMdisCode() {
		return cmMdisCode;
	}

	public void setCmMdisCode(String cmMdisCode) {
		this.cmMdisCode = cmMdisCode;
	}

	public String getCmMdisName() {
		return cmMdisName;
	}

	public void setCmMdisName(String cmMdisName) {
		this.cmMdisName = cmMdisName;
	}

	public String getPirncipalDiagnosis() {
		return pirncipalDiagnosis;
	}

	public void setPirncipalDiagnosis(String pirncipalDiagnosis) {
		this.pirncipalDiagnosis = pirncipalDiagnosis;
	}

	public String getCmDisName() {
		return cmDisName;
	}

	public void setCmDisName(String cmDisName) {
		this.cmDisName = cmDisName;
	}

	public String getCmDisCode() {
		return cmDisCode;
	}

	public void setCmDisCode(String cmDisCode) {
		this.cmDisCode = cmDisCode;
	}

	public String getWmDisName() {
		return wmDisName;
	}

	public void setWmDisName(String wmDisName) {
		this.wmDisName = wmDisName;
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

	
	public String getDiagnoseDateDesc() {
		return diagnoseDateDesc;
	}

	
	public void setDiagnoseDateDesc(String diagnoseDateDesc) {
		this.diagnoseDateDesc = diagnoseDateDesc;
	}

    public Date getGatherDate() {
        return gatherDate;
    }

    public void setGatherDate(Date gatherDate) {
        this.gatherDate = gatherDate;
    }

	public String getOpEmHpMark() {
		return opEmHpMark;
	}

	public void setOpEmHpMark(String opEmHpMark) {
		this.opEmHpMark = opEmHpMark;
	}
    
    
}
