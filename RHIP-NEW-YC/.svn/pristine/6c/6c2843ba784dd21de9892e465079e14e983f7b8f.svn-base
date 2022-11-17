package com.founder.rhip.ehr.entity.management.mhm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MHM_OTHER_INFO")
public class MhmOtherInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "EVENT_ID", columnDefinition = "NUMBER|本系统唯一编码|11|", length = 11, nullable = false)
	private Long eventId;

	@Column(name = "FILL_ORGAN_CODE", columnDefinition = "VARCHAR2|填写机构|100|", length = 100, nullable = true)
	private String fillOrganCode;

	@Column(name = "BELONG_TOWNSHIP", columnDefinition = "VARCHAR2|所属乡镇|100|", length = 100, nullable = true)
	private String belongTownship;

	@Column(name = "BELONG_CENTER", columnDefinition = "VARCHAR2|所属中心|100|", length = 100, nullable = true)
	private String belongCenter;
	
	@Column(name = "FILL_DOCTOR_ID", columnDefinition = "VARCHAR2|填写医生|50|", length = 50, nullable = true)
	private String fillDoctorId;

	@Column(name = "FILL_DATE", columnDefinition = "DATE|填写时间||", nullable = true)
	private Date fillDate;

	@Column(name = "PATIENT_TYPE", columnDefinition = "VARCHAR2|病人类型|20|", length = 20, nullable = true)
	private String patientType;

	@Column(name = "MANAGEMENT_TOWN", columnDefinition = "VARCHAR2|管理单位－镇|100|", length = 100, nullable = true)
	private String managementTown;

    @Column(name = "MANAGEMENT_CENTER", columnDefinition = "VARCHAR2|管理单位－中心|100|", length = 100, nullable = true)
    private String managementCenter;

    @Column(name = "MANAGEMENT_STATION", columnDefinition = "VARCHAR2|管理单位－站|100|", length = 100, nullable = true)
    private String managementStation;

	@Column(name = "FREE_FLAG", columnDefinition = "VARCHAR2|是否免费服药|20|", length = 20, nullable = true)
	private String freeFlag;

	@Column(name = "BASIC_MEDICAL_UNIT", columnDefinition = "VARCHAR2|基层医疗卫生机构|100|", length = 100, nullable = true)
	private String basicMedicalUnit;

	@Column(name = "INFORMED_CONSENT", columnDefinition = "VARCHAR2|知情同意|20|", length = 20, nullable = true)
	private String informedConsent;

	@Column(name = "INFORMED_CONSENT_SIGN_DATE", columnDefinition = "DATE|知情同意签字时间||", nullable = true)
	private Date informedConsentSignDate;

	@Column(name = "INFORMED_CONSENT_NAME", columnDefinition = "VARCHAR2|知情同意签字|50|", length = 50, nullable = true)
	private String informedConsentName;

	@Column(name = "EFFECT_FLAG", columnDefinition = "VARCHAR2|患者是否对家庭社会有影响|20|", length = 20, nullable = true)
	private String effectFlag;

	@Column(name = "MILD_AFFRAY", columnDefinition = "NUMBER|轻度滋事|2|", length = 2, nullable = true)
	private Integer mildAffray;

	@Column(name = "CAUSE_TROUBLE", columnDefinition = "NUMBER|肇事|2|", length = 2, nullable = true)
	private Integer causeTrouble;

	@Column(name = "ACCIDENT", columnDefinition = "NUMBER|肇祸|2|", length = 2, nullable = true)
	private Integer accident;

	@Column(name = "AUTOLESION", columnDefinition = "NUMBER|自伤|2|", length = 2, nullable = true)
	private Integer autolesion;

	@Column(name = "ATTEMPTED_SUICIDE", columnDefinition = "NUMBER|自杀未遂|2|", length = 2, nullable = true)
	private Integer attemptedSuicide;

	@Column(name = "POOR_FAMILIES_FLAG", columnDefinition = "VARCHAR2|是否为当地认定得贫困家庭|20|", length = 20, nullable = true)
	private String poorFamiliesFlag;

	@Column(name = "SUBSISTENCE_OPTION", columnDefinition = "VARCHAR2|低保情况|20|", length = 20, nullable = true)
	private String subsistenceOption;

	@Column(name = "MEDICAL_INSURANCE", columnDefinition = "VARCHAR2|医保情况|20|", length = 20, nullable = true)
	private String medicalInsurance;

	@Column(name = "MEDICAL_INSURANCE_OTHER", columnDefinition = "VARCHAR2|医保情况-其他|100|", length = 100, nullable = true)
	private String medicalInsuranceOther;

	@Column(name = "STATE_ECONOMY", columnDefinition = "VARCHAR2|经济状况|20|", length = 20, nullable = true)
	private String stateEconomy;

	@Column(name = "LOCK_STATE", columnDefinition = "VARCHAR2|关锁状态|20|", length = 20, nullable = true)
	private String lockState;

	@Column(name = "BRING_INTO_FLAG", columnDefinition = "VARCHAR2|是否纳入管理|20|", length = 20, nullable = true)
	private String bringIntoFlag;

	@Column(name = "BRING_INTO_DATE", columnDefinition = "DATE|纳入管理时间||", nullable = true)
	private Date bringIntoDate;

	@Column(name = "BRING_INTO_MODE", columnDefinition = "VARCHAR2|纳入管理方式|20|", length = 20, nullable = true)
	private String bringIntoMode;

	@Column(name = "JOINT_HABITATION", columnDefinition = "VARCHAR2|共同居住者|20|", length = 20, nullable = true)
	private String jointHabitation;

	@Column(name = "CHALLENGED_FLAG", columnDefinition = "VARCHAR2|有无残疾|20|", length = 20, nullable = true)
	private String challengedFlag;

	@Column(name = "CHALLENGED_CATEGORY", columnDefinition = "VARCHAR2|残疾类别|20|", length = 20, nullable = true)
	private String challengedCategory;

	@Column(name = "CHALLENGED_GRADE", columnDefinition = "VARCHAR2|残疾等级|20|", length = 20, nullable = true)
	private String challengedGrade;

	@Column(name = "CHALLENGED_IDENTIFY_DATE", columnDefinition = "DATE|残疾鉴定时间||", nullable = true)
	private Date challengedIdentifyDate;

	@Column(name = "OTHER_SPECIAL", columnDefinition = "VARCHAR2|其他需要说明得特殊情况|100|", length = 100, nullable = true)
	private String otherSpecial;

	@Column(name = "BRING_VERSION", columnDefinition = "NUMBER|版本号(每修改一次纳入管理方式，更新一下版本)|11|", length = 11, nullable = true)
	private Long bringVersion;

	@Column(name = "FREE_VERSION", columnDefinition = "NUMBER|版本号(每修改一次时候免费服药，更新一下版本)|11|", length = 11, nullable = true)
	private Long freeVersion;

	@Column(name = "MODIFY_DOCTOR_ID", columnDefinition = "VARCHAR2|修改医生|50|", length = 50, nullable = true)
	private String modifyDoctorId;

	@Column(name = "MODIFY_ORGAN_CODE", columnDefinition = "VARCHAR2|修改机构|20|", length = 20, nullable = true)
	private String modifyOrganCode;

	@Column(name = "MODIFY_DATE", columnDefinition = "DATE|修改日期||", nullable = true)
	private Date modifyDate;

    @Column(name = "IS_BASE", columnDefinition = "VARCHAR2|是否基础管理|2|", length = 2, nullable = true)
    private String isBase;

    @Column(name = "BASE_DT", columnDefinition = "DATE|基础管理时间||", nullable = true)
    private Date baseDt;

    @Column(name = "MOVE_ID", columnDefinition = "NUMBER|迁入迁出有效操作ID|11|", length = 11, nullable = true)
    private Long moveId;

	@Column(name = "DIAGNOSIS_ORGAN_CODE", columnDefinition = "VARCHAR2|诊断机构|100|", length = 100, nullable = true)
	private String diagnosisOrganCode;
	
	@Column(name = "DIAGNOSIS_DOCTOR_ID", columnDefinition = "VARCHAR2|诊断医生|50|", length = 50, nullable = true)
	private String diagnosisDoctorId;
	
	@Column(name = "DIAGNOSIS_DATE", columnDefinition = "DATE|诊断日期||", nullable = true)
	private Date diagnosisDate;

	@Column(name = "RE_ORGAN_CODE", columnDefinition = "VARCHAR2|复核机构|100|", length = 100, nullable = true)
	private String reOrganCode;
	
	@Column(name = "RE_DOCTOR_ID", columnDefinition = "VARCHAR2|复核医生|50|", length = 50, nullable = true)
	private String reDoctorId;
	
	@Column(name = "RE_DATE", columnDefinition = "DATE|复核日期||", nullable = true)
	private Date reDate;
	
	@Column(name = "SUBSIDIZED_FLAG", columnDefinition = "VARCHAR2|是否为监护补助对象|20|", length = 20, nullable = true)
	private String subsidizedFlag;
	
	@Column(name = "HELP_SERVICE_FLAG", columnDefinition = "VARCHAR2|是否为关爱帮扶小组服务对象|20|", length = 20, nullable = true)
	private String helpServiceFlag;
	
	@Column(name = "FAMILY_DOCTOR_FLAG", columnDefinition = "VARCHAR2|是否为家庭医师签约服务对象|20|", length = 20, nullable = true)
	private String familyDoctorFlag;
	
	@Column(name = "COMMUNITY_REHABILITTATION_FLAG", columnDefinition = "VARCHAR2|是否参加社区康复服务|20|", length = 20, nullable = true)
	private String communityRehabilittationFlag;
	
    public String getHelpServiceFlag() {
		return helpServiceFlag;
	}

	public void setHelpServiceFlag(String helpServiceFlag) {
		this.helpServiceFlag = helpServiceFlag;
	}

	public String getFamilyDoctorFlag() {
		return familyDoctorFlag;
	}

	public void setFamilyDoctorFlag(String familyDoctorFlag) {
		this.familyDoctorFlag = familyDoctorFlag;
	}

	public String getCommunityRehabilittationFlag() {
		return communityRehabilittationFlag;
	}

	public void setCommunityRehabilittationFlag(String communityRehabilittationFlag) {
		this.communityRehabilittationFlag = communityRehabilittationFlag;
	}

	public String getSubsidizedFlag() {
		return subsidizedFlag;
	}

	public void setSubsidizedFlag(String subsidizedFlag) {
		this.subsidizedFlag = subsidizedFlag;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEventId() {
		return this.eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getFillOrganCode() {
		return this.fillOrganCode;
	}

	public void setFillOrganCode(String fillOrganCode) {
		this.fillOrganCode = fillOrganCode;
	}

	public String getFillDoctorId() {
		return this.fillDoctorId;
	}

	public void setFillDoctorId(String fillDoctorId) {
		this.fillDoctorId = fillDoctorId;
	}

	public Date getFillDate() {
		return this.fillDate;
	}

	public void setFillDate(Date fillDate) {
		this.fillDate = fillDate;
	}

	public String getPatientType() {
		return this.patientType;
	}

	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}

	public String getFreeFlag() {
		return this.freeFlag;
	}

	public void setFreeFlag(String freeFlag) {
		this.freeFlag = freeFlag;
	}

	public String getBasicMedicalUnit() {
		return this.basicMedicalUnit;
	}

	public void setBasicMedicalUnit(String basicMedicalUnit) {
		this.basicMedicalUnit = basicMedicalUnit;
	}

	public String getInformedConsent() {
		return this.informedConsent;
	}

	public void setInformedConsent(String informedConsent) {
		this.informedConsent = informedConsent;
	}

	public Date getInformedConsentSignDate() {
		return this.informedConsentSignDate;
	}

	public void setInformedConsentSignDate(Date informedConsentSignDate) {
		this.informedConsentSignDate = informedConsentSignDate;
	}

	public String getInformedConsentName() {
		return this.informedConsentName;
	}

	public void setInformedConsentName(String informedConsentName) {
		this.informedConsentName = informedConsentName;
	}

	public String getEffectFlag() {
		return this.effectFlag;
	}

	public void setEffectFlag(String effectFlag) {
		this.effectFlag = effectFlag;
	}

	public Integer getMildAffray() {
		return this.mildAffray;
	}

	public void setMildAffray(Integer mildAffray) {
		this.mildAffray = mildAffray;
	}

	public Integer getCauseTrouble() {
		return this.causeTrouble;
	}

	public void setCauseTrouble(Integer causeTrouble) {
		this.causeTrouble = causeTrouble;
	}

	public Integer getAccident() {
		return this.accident;
	}

	public void setAccident(Integer accident) {
		this.accident = accident;
	}

	public Integer getAutolesion() {
		return this.autolesion;
	}

	public void setAutolesion(Integer autolesion) {
		this.autolesion = autolesion;
	}

	public Integer getAttemptedSuicide() {
		return this.attemptedSuicide;
	}

	public void setAttemptedSuicide(Integer attemptedSuicide) {
		this.attemptedSuicide = attemptedSuicide;
	}

	public String getPoorFamiliesFlag() {
		return this.poorFamiliesFlag;
	}

	public void setPoorFamiliesFlag(String poorFamiliesFlag) {
		this.poorFamiliesFlag = poorFamiliesFlag;
	}

	public String getSubsistenceOption() {
		return this.subsistenceOption;
	}

	public void setSubsistenceOption(String subsistenceOption) {
		this.subsistenceOption = subsistenceOption;
	}

	public String getMedicalInsurance() {
		return this.medicalInsurance;
	}

	public void setMedicalInsurance(String medicalInsurance) {
		this.medicalInsurance = medicalInsurance;
	}

	public String getMedicalInsuranceOther() {
		return this.medicalInsuranceOther;
	}

	public void setMedicalInsuranceOther(String medicalInsuranceOther) {
		this.medicalInsuranceOther = medicalInsuranceOther;
	}

	public String getStateEconomy() {
		return this.stateEconomy;
	}

	public void setStateEconomy(String stateEconomy) {
		this.stateEconomy = stateEconomy;
	}

	public String getLockState() {
		return this.lockState;
	}

	public void setLockState(String lockState) {
		this.lockState = lockState;
	}

	public String getBringIntoFlag() {
		return this.bringIntoFlag;
	}

	public void setBringIntoFlag(String bringIntoFlag) {
		this.bringIntoFlag = bringIntoFlag;
	}

	public Date getBringIntoDate() {
		return this.bringIntoDate;
	}

	public void setBringIntoDate(Date bringIntoDate) {
		this.bringIntoDate = bringIntoDate;
	}

	public String getBringIntoMode() {
		return this.bringIntoMode;
	}

	public void setBringIntoMode(String bringIntoMode) {
		this.bringIntoMode = bringIntoMode;
	}

	public String getJointHabitation() {
		return this.jointHabitation;
	}

	public void setJointHabitation(String jointHabitation) {
		this.jointHabitation = jointHabitation;
	}

	public String getChallengedFlag() {
		return this.challengedFlag;
	}

	public void setChallengedFlag(String challengedFlag) {
		this.challengedFlag = challengedFlag;
	}

	public String getChallengedCategory() {
		return this.challengedCategory;
	}

	public void setChallengedCategory(String challengedCategory) {
		this.challengedCategory = challengedCategory;
	}

	public String getChallengedGrade() {
		return this.challengedGrade;
	}

	public void setChallengedGrade(String challengedGrade) {
		this.challengedGrade = challengedGrade;
	}

	public Date getChallengedIdentifyDate() {
		return this.challengedIdentifyDate;
	}

	public void setChallengedIdentifyDate(Date challengedIdentifyDate) {
		this.challengedIdentifyDate = challengedIdentifyDate;
	}

	public String getOtherSpecial() {
		return this.otherSpecial;
	}

	public void setOtherSpecial(String otherSpecial) {
		this.otherSpecial = otherSpecial;
	}

	public Long getBringVersion() {
		return this.bringVersion;
	}

	public void setBringVersion(Long bringVersion) {
		this.bringVersion = bringVersion;
	}

	public Long getFreeVersion() {
		return this.freeVersion;
	}

	public void setFreeVersion(Long freeVersion) {
		this.freeVersion = freeVersion;
	}

	public String getModifyDoctorId() {
		return this.modifyDoctorId;
	}

	public void setModifyDoctorId(String modifyDoctorId) {
		this.modifyDoctorId = modifyDoctorId;
	}

	public String getModifyOrganCode() {
		return this.modifyOrganCode;
	}

	public void setModifyOrganCode(String modifyOrganCode) {
		this.modifyOrganCode = modifyOrganCode;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getBelongTownship() {
		return belongTownship;
	}

	public void setBelongTownship(String belongTownship) {
		this.belongTownship = belongTownship;
	}

	public String getBelongCenter() {
		return belongCenter;
	}

	public void setBelongCenter(String belongCenter) {
		this.belongCenter = belongCenter;
	}

    public String getIsBase() {
        return isBase;
    }

    public void setIsBase(String base) {
        isBase = base;
    }

    public Date getBaseDt() {
        return baseDt;
    }

    public void setBaseDt(Date baseDt) {
        this.baseDt = baseDt;
    }

    public String getManagementTown() {
        return managementTown;
    }

    public void setManagementTown(String managementTown) {
        this.managementTown = managementTown;
    }

    public String getManagementCenter() {
        return managementCenter;
    }

    public void setManagementCenter(String managementCenter) {
        this.managementCenter = managementCenter;
    }

    public String getManagementStation() {
        return managementStation;
    }

    public void setManagementStation(String managementStation) {
        this.managementStation = managementStation;
    }

    public Long getMoveId() {
        return moveId;
    }

    public void setMoveId(Long moveId) {
        this.moveId = moveId;
    }

	public String getDiagnosisOrganCode() {
		return diagnosisOrganCode;
	}

	public void setDiagnosisOrganCode(String diagnosisOrganCode) {
		this.diagnosisOrganCode = diagnosisOrganCode;
	}

	public String getDiagnosisDoctorId() {
		return diagnosisDoctorId;
	}

	public void setDiagnosisDoctorId(String diagnosisDoctorId) {
		this.diagnosisDoctorId = diagnosisDoctorId;
	}

	public Date getDiagnosisDate() {
		return diagnosisDate;
	}

	public void setDiagnosisDate(Date diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}

	public String getReOrganCode() {
		return reOrganCode;
	}

	public void setReOrganCode(String reOrganCode) {
		this.reOrganCode = reOrganCode;
	}

	public String getReDoctorId() {
		return reDoctorId;
	}

	public void setReDoctorId(String reDoctorId) {
		this.reDoctorId = reDoctorId;
	}

	public Date getReDate() {
		return reDate;
	}

	public void setReDate(Date reDate) {
		this.reDate = reDate;
	}
}