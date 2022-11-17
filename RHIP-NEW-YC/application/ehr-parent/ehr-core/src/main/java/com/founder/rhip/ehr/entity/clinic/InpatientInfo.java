package com.founder.rhip.ehr.entity.clinic;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "MS_INPATIENT_INFO")
public class InpatientInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号||", length = 17, nullable = true)
    private String healthFileNo;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
    private String ehrId;

    @Column(name = "ADMISSION_NO", columnDefinition = "VARCHAR2|住院号||", length = 10, nullable = true)
    private String admissionNo;

    @Column(name = "MEDICAL_RECORD_NO", columnDefinition = "VARCHAR2|病案号||", length = 18, nullable = true)
    private String medicalRecordNo;

    @Column(name = "INHOS_CONDITION", columnDefinition = "VARCHAR2|住院患者入院病情||", length = 1, nullable = true)
    private String inhosCondition;

    @Column(name = "INHOS_COUNT", columnDefinition = "NUMBER|住院次数(次)||", length = 3, nullable = true)
    private Integer inhosCount;

    @Column(name = "INHOS_STATE_CODE", columnDefinition = "NUMBER|住院情况代码||", length = 3, nullable = true)
    private Integer inhosSituationCode;

    @Column(name = "INHOS_DAYS", columnDefinition = "NUMBER|住院患者住院天数||", length = 5, nullable = true)
    private Integer inhosDays;

    @Column(name = "INHOS_RESCUE_TIMES", columnDefinition = "NUMBER|住院患者抢救次数||", length = 5, nullable = true)
    private Integer inhosRescueTimes;

    @Column(name = "INHOS_RESCUE_SUCCESS_TIMES", columnDefinition = "NUMBER|住院患者抢救成功次数||", length = 5, nullable = true)
    private Integer inhosRescueSuccessTimes;

    @Column(name = "INHOS_CONDITION_CODE", columnDefinition = "VARCHAR2|住院原因代码||", length = 1, nullable = true)
    private String inhosConditionCode;

    @Column(name = "DEST_DEPT_CODE", columnDefinition = "VARCHAR2|转出医疗机构代码||", length = 10, nullable = true)
    private String destDeptCode;

    @Column(name = "DEST_DEPT_NAME", columnDefinition = "VARCHAR2|转出医疗机构名称||", length = 70, nullable = true)
    private String destDeptName;

    @Column(name = "DEST_ROOM_CODE", columnDefinition = "VARCHAR2|转出医疗机构科室代码||", length = 5, nullable = true)
    private String destRoomCode;

    @Column(name = "DEST_ROOM_NAME", columnDefinition = "VARCHAR2|转出医疗机构科室名称||", length = 50, nullable = true)
    private String destRoomName;

    @Column(name = "REFERRAL_HOSPITAL_CODE", columnDefinition = "VARCHAR2|创建机构代码||", length = 10, nullable = true)
    private String referralHospitalCode;

    @Column(name = "REFERRAL_HOSPITAL_NAME", columnDefinition = "VARCHAR2|创建机构名称||", length = 70, nullable = true)
    private String referralHospitalName;

    @Column(name = "REFERRAL_DEPT_CODE", columnDefinition = "VARCHAR2|转入机构科室代码||", length = 5, nullable = true)
    private String referralDeptCode;

    @Column(name = "REFERRAL_DEPT_NAME", columnDefinition = "VARCHAR2|转入机构科室名称||", length = 50, nullable = true)
    private String referralDeptName;

    @Column(name = "INHOS_REASON", columnDefinition = "VARCHAR2|入院原因||", length = 100, nullable = true)
    private String inhosReason;

    @Column(name = "INHOS_DATE", columnDefinition = "TIMESTAMP|入院日期时间||", nullable = true)
    private Date inhosDate;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
    private String name;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
    private String gender;

    @Column(name = "AGE", columnDefinition = "VARCHAR2|年龄||", length = 20, nullable = true)
    private String age;

    @Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
    private Date birthday;

    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况||", length = 3, nullable = true)
    private String marriage;

    @Column(name = "INHOS_INFECTIVITY_FLAG", columnDefinition = "CHAR|住院者传染性标志||", length = 1, nullable = true)
    private String inhosInfectivityFlag;

    @Column(name = "INHOS_COST_VISIT_FLAG", columnDefinition = "CHAR|住院患者随诊标志||", length = 1, nullable = true)
    private String inhosCostVisitFlag;

    @Column(name = "INHOS_AUTOPSY_FLAG", columnDefinition = "CHAR|住院患者尸检标志||", length = 1, nullable = true)
    private String inhosAutopsyFlag;

    @Column(name = "INHOS_TEACH_CASE_FLAG", columnDefinition = "CHAR|住院患者示教病例标志||", length = 1, nullable = true)
    private String inhosTeachCaseFlag;

    @Column(name = "OTHER_MEDICAL_TREATMENT", columnDefinition = "VARCHAR2|其他医学处置||", length = 200, nullable = true)
    private String otherMedicalTreatment;

    @Column(name = "UNDERLYING_DEATH_CODE", columnDefinition = "VARCHAR2|根本死因代码||", length = 5, nullable = true)
    private String underlyingDeathCode;

    @Column(name = "DEATH_DATE", columnDefinition = "TIMESTAMP|死亡日期时间||", nullable = true)
    private Date deathDate;

    @Column(name = "SICK_AREA_NAME", columnDefinition = "VARCHAR2|病区名称||", length = 50, nullable = true)
    private String sickAreaName;

    @Column(name = "SICKROOM_NO", columnDefinition = "VARCHAR2|病房号||", length = 5, nullable = true)
    private String sickroomNo;

    @Column(name = "SICKBED_NO", columnDefinition = "VARCHAR2|病床号||", length = 5, nullable = true)
    private String sickbedNo;

    @Column(name = "PATHOGENESIS_DATE", columnDefinition = "TIMESTAMP|发病日期时间||", nullable = true)
    private Date pathogenesisDate;

    @Column(name = "TREATMENT_RESULTS_CODE", columnDefinition = "VARCHAR2|治疗结果代码||", length = 1, nullable = true)
    private String treatmentResultsCode;

    @Column(name = "RELATED_PHYSICIAN_ROLE_NAME", columnDefinition = "VARCHAR2|相关医师角色名称||", length = 20, nullable = true)
    private String relatedPhysicianRoleName;

    @Column(name = "RELATED_PHYSICIAN_NAME", columnDefinition = "VARCHAR2|相关医师姓名||", length = 50, nullable = true)
    private String relatedPhysicianName;

    @Column(name = "ATTENDING_PHYSICIAN_NO", columnDefinition = "VARCHAR2|主治医师工号||", length = 18, nullable = true)
    private String attendingPhysicianNo;

    @Column(name = "ATTENDING_PHYSICIAN_NAME", columnDefinition = "VARCHAR2|主治医师名称||", length = 50, nullable = true)
    private String attendingPhysicianName;

    @Column(name = "ATTENDING_PHYSICIAN_IDCARD", columnDefinition = "VARCHAR2|主治医生身份证号||", length = 18, nullable = true)
    private String attendingPhysicianIdCard;

    @Column(name = "INHOS_COST_PAY_CODE", columnDefinition = "VARCHAR2|医疗费用支付方式代码||", length = 2, nullable = true)
    private String inhosCostPayCode;

    @Column(name = "INHOS_SETTLEMENT_CODE", columnDefinition = "VARCHAR2|医疗费用结算方式代码||", length = 2, nullable = true)
    private String inhosSettlementCode;

    @Column(name = "PERSONAL_EXPENSES", columnDefinition = "NUMBER|个人承担费用(元)||", scale = 8, precision = 2, nullable = true)
    private BigDecimal personalExpenses;

    @Column(name = "MEDICAL_INSURANCE_COST_SUM", columnDefinition = "NUMBER|医疗保险金额(元)||", scale = 8, precision = 2, nullable = true)
    private BigDecimal medicalInsuranceCostSum;

    @Column(name = "OTHER_SUBSIDIES_COST_SUM", columnDefinition = "NUMBER|其他补助金额(元)||", scale = 8, precision = 2, nullable = true)
    private BigDecimal otherSubsidiesCostSum;

    @Column(name = "INHOS_COST_SUM", columnDefinition = "NUMBER|总费用||", scale = 8, precision = 2, nullable = true)
    private BigDecimal inhosCostSum;

    @Column(name = "OUT_HOSPITAL_DATE", columnDefinition = "DATE|出院日期||", nullable = true)
    private Date outHospitalDate;

    @Column(name = "FILL_USER_NAME", columnDefinition = "VARCHAR2|填报人姓名||", length = 50, nullable = true)
    private String fillUserName;

    @Column(name = "FILL_USER_IDCARD", columnDefinition = "VARCHAR2|填报身份证号||", length = 18, nullable = true)
    private String fillUserIdCard;

    @Column(name = "FILL_TIME", columnDefinition = "TIMESTAMP|填报日期时间||", nullable = true)
    private Date fillTime;

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

	@Column(name = "OTHERCARDNO", columnDefinition = "VARCHAR2|其他就医卡证号码||", length = 50, nullable = true)
	private String othercardno;

	@Column(name = "HP_S_NO", columnDefinition = "VARCHAR2|住院流水号||", length = 50, nullable = true)
	private String hpSNo;

	@Column(name = "SOURCE_CODE", columnDefinition = "VARCHAR2|入院来源代码||", length = 2, nullable = true)
	private String sourceCode;

	@Column(name = "PROVIDEHX_NAME", columnDefinition = "VARCHAR2|供史者姓名||", length = 50, nullable = true)
	private String providehxName;

	@Column(name = "RELA_CODE", columnDefinition = "VARCHAR2|与患者关系代码||", length = 2, nullable = true)
	private String relaCode;

	@Column(name = "IFALLER_MARK", columnDefinition = "VARCHAR2|有无过敏标志||", length = 2, nullable = true)
	private String ifallerMark;

	@Column(name = "DIALECTICAL", columnDefinition = "VARCHAR2|中医辩证分型||", length = 2, nullable = true)
	private String dialectical;

	@Column(name = "RCD_DT", columnDefinition = "DATE|记录时间||", nullable = true)
	private Date rcdDt;
	
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus;
	
    @Column(name = "IS_LIMIT", columnDefinition = "NUMBER|是否限制||", length = 1, nullable = true)
    private Integer isLimit = -1;
    
    @Column(name = "IS_ANALYSE", columnDefinition = "NUMBER|是否处理疾病史||", length = 1, nullable = true)
    private Integer isAnalyse = -1;
    
	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;

    @Transient
    private String icdCode;
    
    @Transient
    private String inhosDateDesc;
    
    @Transient
    private String pastHistory;
    
    @Transient
    private String familyHeredityHistory;
    
    @Transient
    private String drugAllergyHistory;
    
    @Transient
    private String vitalSignDesc;
    
    @Transient
    private String studyInfo;
    
    @Transient
    private String RelaCodeDesc;
    
    @Transient
    private String ifallerMarkDesc;
    
    @Transient
    private String idcard;
    
    public String getIfallerMarkDesc() {
		return ifallerMarkDesc;
	}

	public void setIfallerMarkDesc(String ifallerMarkDesc) {
		this.ifallerMarkDesc = ifallerMarkDesc;
	}

	public String getRelaCodeDesc() {
		return RelaCodeDesc;
	}

	public void setRelaCodeDesc(String relaCodeDesc) {
		RelaCodeDesc = relaCodeDesc;
	}

	public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getHealthFileNo() {
        return this.healthFileNo;
    }

    public void setHealthFileNo(String healthFileNo) {
        this.healthFileNo = healthFileNo;
    }

    public String getEhrId() {
        return this.ehrId;
    }

    public void setEhrId(String ehrId) {
        this.ehrId = ehrId;
    }

    public String getAdmissionNo() {
        return this.admissionNo;
    }

    public void setAdmissionNo(String admissionNo) {
        this.admissionNo = admissionNo;
    }

    public String getMedicalRecordNo() {
        return this.medicalRecordNo;
    }

    public void setMedicalRecordNo(String medicalRecordNo) {
        this.medicalRecordNo = medicalRecordNo;
    }

    public String getInhosCondition() {
        return this.inhosCondition;
    }

    public void setInhosCondition(String inhosCondition) {
        this.inhosCondition = inhosCondition;
    }

    public Integer getInhosCount() {
        return this.inhosCount;
    }

    public void setInhosCount(Integer inhosCount) {
        this.inhosCount = inhosCount;
    }

    public Integer getInhosSituationCode() {
        return this.inhosSituationCode;
    }

    public void setInhosSituationCode(Integer inhosSituationCode) {
        this.inhosSituationCode = inhosSituationCode;
    }

    public Integer getInhosDays() {
        return this.inhosDays;
    }

    public void setInhosDays(Integer inhosDays) {
        this.inhosDays = inhosDays;
    }

    public Integer getInhosRescueTimes() {
        return this.inhosRescueTimes;
    }

    public void setInhosRescueTimes(Integer inhosRescueTimes) {
        this.inhosRescueTimes = inhosRescueTimes;
    }

    public Integer getInhosRescueSuccessTimes() {
        return this.inhosRescueSuccessTimes;
    }

    public void setInhosRescueSuccessTimes(Integer inhosRescueSuccessTimes) {
        this.inhosRescueSuccessTimes = inhosRescueSuccessTimes;
    }

    public String getInhosConditionCode() {
        return this.inhosConditionCode;
    }

    public void setInhosConditionCode(String inhosConditionCode) {
        this.inhosConditionCode = inhosConditionCode;
    }

    public String getDestDeptCode() {
        return this.destDeptCode;
    }

    public void setDestDeptCode(String destDeptCode) {
        this.destDeptCode = destDeptCode;
    }

    public String getDestDeptName() {
        return this.destDeptName;
    }

    public void setDestDeptName(String destDeptName) {
        this.destDeptName = destDeptName;
    }

    public String getDestRoomCode() {
        return this.destRoomCode;
    }

    public void setDestRoomCode(String destRoomCode) {
        this.destRoomCode = destRoomCode;
    }

    public String getDestRoomName() {
        return this.destRoomName;
    }

    public void setDestRoomName(String destRoomName) {
        this.destRoomName = destRoomName;
    }

    public String getReferralHospitalCode() {
        return this.referralHospitalCode;
    }

    public void setReferralHospitalCode(String referralHospitalCode) {
        this.referralHospitalCode = referralHospitalCode;
    }

    public String getReferralHospitalName() {
        return this.referralHospitalName;
    }

    public void setReferralHospitalName(String referralHospitalName) {
        this.referralHospitalName = referralHospitalName;
    }

    public String getReferralDeptCode() {
        return this.referralDeptCode;
    }

    public void setReferralDeptCode(String referralDeptCode) {
        this.referralDeptCode = referralDeptCode;
    }

    public String getReferralDeptName() {
        return this.referralDeptName;
    }

    public void setReferralDeptName(String referralDeptName) {
        this.referralDeptName = referralDeptName;
    }

    public String getInhosReason() {
        return this.inhosReason;
    }

    public void setInhosReason(String inhosReason) {
        this.inhosReason = inhosReason;
    }

    public Date getInhosDate() {
        return this.inhosDate;
    }

    public void setInhosDate(Date inhosDate) {
        this.inhosDate = inhosDate;
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

	public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMarriage() {
        return this.marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getInhosInfectivityFlag() {
        return this.inhosInfectivityFlag;
    }

    public void setInhosInfectivityFlag(String inhosInfectivityFlag) {
        this.inhosInfectivityFlag = inhosInfectivityFlag;
    }

    public String getInhosCostVisitFlag() {
        return this.inhosCostVisitFlag;
    }

    public void setInhosCostVisitFlag(String inhosCostVisitFlag) {
        this.inhosCostVisitFlag = inhosCostVisitFlag;
    }

    public String getInhosAutopsyFlag() {
        return this.inhosAutopsyFlag;
    }

    public void setInhosAutopsyFlag(String inhosAutopsyFlag) {
        this.inhosAutopsyFlag = inhosAutopsyFlag;
    }

    public String getInhosTeachCaseFlag() {
        return this.inhosTeachCaseFlag;
    }

    public void setInhosTeachCaseFlag(String inhosTeachCaseFlag) {
        this.inhosTeachCaseFlag = inhosTeachCaseFlag;
    }

    public String getOtherMedicalTreatment() {
        return this.otherMedicalTreatment;
    }

    public void setOtherMedicalTreatment(String otherMedicalTreatment) {
        this.otherMedicalTreatment = otherMedicalTreatment;
    }

    public String getUnderlyingDeathCode() {
        return this.underlyingDeathCode;
    }

    public void setUnderlyingDeathCode(String underlyingDeathCode) {
        this.underlyingDeathCode = underlyingDeathCode;
    }

    public Date getDeathDate() {
        return this.deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public String getSickAreaName() {
        return this.sickAreaName;
    }

    public void setSickAreaName(String sickAreaName) {
        this.sickAreaName = sickAreaName;
    }

    public String getSickroomNo() {
        return this.sickroomNo;
    }

    public void setSickroomNo(String sickroomNo) {
        this.sickroomNo = sickroomNo;
    }

    public String getSickbedNo() {
        return this.sickbedNo;
    }

    public void setSickbedNo(String sickbedNo) {
        this.sickbedNo = sickbedNo;
    }

    public Date getPathogenesisDate() {
        return this.pathogenesisDate;
    }

    public void setPathogenesisDate(Date pathogenesisDate) {
        this.pathogenesisDate = pathogenesisDate;
    }

    public String getTreatmentResultsCode() {
        return this.treatmentResultsCode;
    }

    public void setTreatmentResultsCode(String treatmentResultsCode) {
        this.treatmentResultsCode = treatmentResultsCode;
    }

    public String getRelatedPhysicianRoleName() {
        return this.relatedPhysicianRoleName;
    }

    public void setRelatedPhysicianRoleName(String relatedPhysicianRoleName) {
        this.relatedPhysicianRoleName = relatedPhysicianRoleName;
    }

    public String getRelatedPhysicianName() {
        return this.relatedPhysicianName;
    }

    public void setRelatedPhysicianName(String relatedPhysicianName) {
        this.relatedPhysicianName = relatedPhysicianName;
    }

    public String getAttendingPhysicianNo() {
        return this.attendingPhysicianNo;
    }

    public void setAttendingPhysicianNo(String attendingPhysicianNo) {
        this.attendingPhysicianNo = attendingPhysicianNo;
    }

    public String getAttendingPhysicianName() {
        return this.attendingPhysicianName;
    }

    public void setAttendingPhysicianName(String attendingPhysicianName) {
        this.attendingPhysicianName = attendingPhysicianName;
    }

    public String getAttendingPhysicianIdCard() {
        return this.attendingPhysicianIdCard;
    }

    public void setAttendingPhysicianIdCard(String attendingPhysicianIdCard) {
        this.attendingPhysicianIdCard = attendingPhysicianIdCard;
    }

    public String getInhosCostPayCode() {
        return this.inhosCostPayCode;
    }

    public void setInhosCostPayCode(String inhosCostPayCode) {
        this.inhosCostPayCode = inhosCostPayCode;
    }

    public String getInhosSettlementCode() {
        return this.inhosSettlementCode;
    }

    public void setInhosSettlementCode(String inhosSettlementCode) {
        this.inhosSettlementCode = inhosSettlementCode;
    }

    public BigDecimal getPersonalExpenses() {
        return this.personalExpenses;
    }

    public void setPersonalExpenses(BigDecimal personalExpenses) {
        this.personalExpenses = personalExpenses;
    }

    public BigDecimal getMedicalInsuranceCostSum() {
        return this.medicalInsuranceCostSum;
    }

    public void setMedicalInsuranceCostSum(BigDecimal medicalInsuranceCostSum) {
        this.medicalInsuranceCostSum = medicalInsuranceCostSum;
    }

    public BigDecimal getOtherSubsidiesCostSum() {
        return this.otherSubsidiesCostSum;
    }

    public void setOtherSubsidiesCostSum(BigDecimal otherSubsidiesCostSum) {
        this.otherSubsidiesCostSum = otherSubsidiesCostSum;
    }

    public BigDecimal getInhosCostSum() {
        return this.inhosCostSum;
    }

    public void setInhosCostSum(BigDecimal inhosCostSum) {
        this.inhosCostSum = inhosCostSum;
    }

    public Date getOutHospitalDate() {
        return this.outHospitalDate;
    }

    public void setOutHospitalDate(Date outHospitalDate) {
        this.outHospitalDate = outHospitalDate;
    }

    public String getFillUserName() {
        return this.fillUserName;
    }

    public void setFillUserName(String fillUserName) {
        this.fillUserName = fillUserName;
    }

    public String getFillUserIdCard() {
        return this.fillUserIdCard;
    }

    public void setFillUserIdCard(String fillUserIdCard) {
        this.fillUserIdCard = fillUserIdCard;
    }

    public Date getFillTime() {
        return this.fillTime;
    }

    public void setFillTime(Date fillTime) {
        this.fillTime = fillTime;
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

    public String getIcdCode() {
        return icdCode;
    }

    public void setIcdCode(String icdCode) {
        this.icdCode = icdCode;
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

	public String getHpSNo() {
		return hpSNo;
	}

	public void setHpSNo(String hpSNo) {
		this.hpSNo = hpSNo;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getProvidehxName() {
		return providehxName;
	}

	public void setProvidehxName(String providehxName) {
		this.providehxName = providehxName;
	}

	public String getRelaCode() {
		return relaCode;
	}

	public void setRelaCode(String relaCode) {
		this.relaCode = relaCode;
	}

	public String getIfallerMark() {
		return ifallerMark;
	}

	public void setIfallerMark(String ifallerMark) {
		this.ifallerMark = ifallerMark;
	}

	public String getDialectical() {
		return dialectical;
	}

	public void setDialectical(String dialectical) {
		this.dialectical = dialectical;
	}

	public Date getRcdDt() {
		return rcdDt;
	}

	public void setRcdDt(Date rcdDt) {
		this.rcdDt = rcdDt;
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

	
	public Integer getIsAnalyse() {
		return isAnalyse;
	}

	
	public void setIsAnalyse(Integer isAnalyse) {
		this.isAnalyse = isAnalyse;
	}

	
	public String getInhosDateDesc() {
		return inhosDateDesc;
	}

	
	public void setInhosDateDesc(String inhosDateDesc) {
		this.inhosDateDesc = inhosDateDesc;
	}

	
	public String getPastHistory() {
		return pastHistory;
	}

	
	public void setPastHistory(String pastHistory) {
		this.pastHistory = pastHistory;
	}

	
	public String getFamilyHeredityHistory() {
		return familyHeredityHistory;
	}

	
	public void setFamilyHeredityHistory(String familyHeredityHistory) {
		this.familyHeredityHistory = familyHeredityHistory;
	}

	
	public String getDrugAllergyHistory() {
		return drugAllergyHistory;
	}

	
	public void setDrugAllergyHistory(String drugAllergyHistory) {
		this.drugAllergyHistory = drugAllergyHistory;
	}

	
	public String getVitalSignDesc() {
		return vitalSignDesc;
	}

	
	public void setVitalSignDesc(String vitalSignDesc) {
		this.vitalSignDesc = vitalSignDesc;
	}

	
	public String getStudyInfo() {
		return studyInfo;
	}

	
	public void setStudyInfo(String studyInfo) {
		this.studyInfo = studyInfo;
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

}
