package com.founder.rhip.ehr.entity.women;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "WH_POSTPARTUM_DAYS_HEALTH_INFO")
public class PostpartumDaysHealthInfo {
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "EHR_ID")
    private String ehrId;

    @Column(name = "PERSON_ID")
    private Long personId;

    @Column(name = "RECORD_NUMBER")
    private String recordNumber;

    @Column(name = "HEALTH_FILE_NO")
    private String healthFileNo;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ID_CARD")
    private String idCard;

    @Column(name = "SUPERVISION_DATE")
    private Date supervisionDate;

    @Column(name = "HEALTH_STATUS")
    private String healthStatus;

    @Column(name = "PSYCHOLOGICAL_STATUS")
    private String psychologicalStatus;

    @Column(name = "SBP")
    private Short sbp;

    @Column(name = "DBP")
    private Short dbp;

    @Column(name = "BREAST_ANOMALY_SIGN")
    private String breastAnomalySign;

    @Column(name = "BREAST_ANOMALY_DESC")
    private String breastAnomalyDesc;

    @Column(name = "L_BREAST_EXAMINATION_RESULT")
    private String lBreastExaminationResult;

    @Column(name = "R_BREAST_CHECK_RESULT")
    private String rBreastCheckResult;

    @Column(name = "LOCHIA_ANOMALY_SIGN")
    private String lochiaAnomalySign;

    @Column(name = "LOCHIA_CONDITION")
    private String lochiaCondition;

    @Column(name = "CORPUS_ANOMALY")
    private String corpusAnomaly;

    @Column(name = "CORPUS_ANOMALY_DESC")
    private String corpusAnomalyDesc;

    @Column(name = "WOUND_ANOMALY_SIGN")
    private String woundAnomalySign;

    @Column(name = "WOUND_ANOMALY_DESC")
    private String woundAnomalyDesc;

    @Column(name = "WOUND_HEALING_STATUS")
    private String woundHealingStatus;

    @Column(name = "OTHER")
    private String other;

    @Column(name = "PUERPERA_RESTORES_MARK")
    private String puerperaRestoresMark;

    @Column(name = "HEALTH_ASSESSMENT_DESC")
    private String healthAssessmentDesc;

    @Column(name = "HEALTH_GUIDANCE_CLASS")
    private String healthGuidanceClass;

    @Column(name = "HEALTH_GUIDANCE_DESC")
    private String healthGuidanceDesc;

    @Column(name = "FINAL_MARK")
    private String finalMark;

    @Column(name = "REFERRAL_FLAG")
    private String referralFlag;

    @Column(name = "REFERRAL_HOSPITAL_NAME")
    private String referralHospitalName;

    @Column(name = "REFERRAL_DEPT_NAME")
    private String referralDeptName;

    @Column(name = "REFERRAL_REASON")
    private String referralReason;

    @Column(name = "SUPERVISION_DOCTOR")
    private String supervisionDoctor;

    @Column(name = "IS_DELETE")
    private Short isDelete;

    @Column(name = "MOTHER_IDCARD")
    private String motherIdcard;

    @Column(name = "BABY_CARD_NO")
    private String babyCardNo;

    @Column(name = "CREATE_ORGAN_CODE")
    private String createOrganCode;

    @Column(name = "CREATE_ORGAN_NAME")
    private String createOrganName;

    @Column(name = "PROCESS_STATUS")
    private String processStatus;

    @Column(name = "GATHER_DATE")
    private Date gatherDate;

    @Column(name = "CLASSIFY_FLAG")
    private String classifyFlag;

    @Column(name = "CLASSIFY_DESC")
    private String classifyDesc;

    @Column(name = "DELIVERY_DATE")
    private Date deliveryDate;

    @Column(name = "LEAVE_HOSPITAL_DATE")
    private Date leaveHospitalDate;

    @Column(name = "CM_HEALTH_MANAGE")
    private String cmHealthManage;

    @Column(name = "CM_HEALTH_MANAGE_DESC")
    private String cmHealthManageDesc;

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

    /**
     * @return EHR_ID
     */
    public String getEhrId() {
        return ehrId;
    }

    /**
     * @param ehrId
     */
    public void setEhrId(String ehrId) {
        this.ehrId = ehrId;
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
     * @return RECORD_NUMBER
     */
    public String getRecordNumber() {
        return recordNumber;
    }

    /**
     * @param recordNumber
     */
    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    /**
     * @return HEALTH_FILE_NO
     */
    public String getHealthFileNo() {
        return healthFileNo;
    }

    /**
     * @param healthFileNo
     */
    public void setHealthFileNo(String healthFileNo) {
        this.healthFileNo = healthFileNo;
    }

    /**
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return ID_CARD
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * @param idCard
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * @return SUPERVISION_DATE
     */
    public Date getSupervisionDate() {
        return supervisionDate;
    }

    /**
     * @param supervisionDate
     */
    public void setSupervisionDate(Date supervisionDate) {
        this.supervisionDate = supervisionDate;
    }

    /**
     * @return HEALTH_STATUS
     */
    public String getHealthStatus() {
        return healthStatus;
    }

    /**
     * @param healthStatus
     */
    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    /**
     * @return PSYCHOLOGICAL_STATUS
     */
    public String getPsychologicalStatus() {
        return psychologicalStatus;
    }

    /**
     * @param psychologicalStatus
     */
    public void setPsychologicalStatus(String psychologicalStatus) {
        this.psychologicalStatus = psychologicalStatus;
    }

    /**
     * @return SBP
     */
    public Short getSbp() {
        return sbp;
    }

    /**
     * @param sbp
     */
    public void setSbp(Short sbp) {
        this.sbp = sbp;
    }

    /**
     * @return DBP
     */
    public Short getDbp() {
        return dbp;
    }

    /**
     * @param dbp
     */
    public void setDbp(Short dbp) {
        this.dbp = dbp;
    }

    /**
     * @return BREAST_ANOMALY_SIGN
     */
    public String getBreastAnomalySign() {
        return breastAnomalySign;
    }

    /**
     * @param breastAnomalySign
     */
    public void setBreastAnomalySign(String breastAnomalySign) {
        this.breastAnomalySign = breastAnomalySign;
    }

    /**
     * @return BREAST_ANOMALY_DESC
     */
    public String getBreastAnomalyDesc() {
        return breastAnomalyDesc;
    }

    /**
     * @param breastAnomalyDesc
     */
    public void setBreastAnomalyDesc(String breastAnomalyDesc) {
        this.breastAnomalyDesc = breastAnomalyDesc;
    }

    /**
     * @return L_BREAST_EXAMINATION_RESULT
     */
    public String getlBreastExaminationResult() {
        return lBreastExaminationResult;
    }

    /**
     * @param lBreastExaminationResult
     */
    public void setlBreastExaminationResult(String lBreastExaminationResult) {
        this.lBreastExaminationResult = lBreastExaminationResult;
    }

    /**
     * @return R_BREAST_CHECK_RESULT
     */
    public String getrBreastCheckResult() {
        return rBreastCheckResult;
    }

    /**
     * @param rBreastCheckResult
     */
    public void setrBreastCheckResult(String rBreastCheckResult) {
        this.rBreastCheckResult = rBreastCheckResult;
    }

    /**
     * @return LOCHIA_ANOMALY_SIGN
     */
    public String getLochiaAnomalySign() {
        return lochiaAnomalySign;
    }

    /**
     * @param lochiaAnomalySign
     */
    public void setLochiaAnomalySign(String lochiaAnomalySign) {
        this.lochiaAnomalySign = lochiaAnomalySign;
    }

    /**
     * @return LOCHIA_CONDITION
     */
    public String getLochiaCondition() {
        return lochiaCondition;
    }

    /**
     * @param lochiaCondition
     */
    public void setLochiaCondition(String lochiaCondition) {
        this.lochiaCondition = lochiaCondition;
    }

    /**
     * @return CORPUS_ANOMALY
     */
    public String getCorpusAnomaly() {
        return corpusAnomaly;
    }

    /**
     * @param corpusAnomaly
     */
    public void setCorpusAnomaly(String corpusAnomaly) {
        this.corpusAnomaly = corpusAnomaly;
    }

    /**
     * @return CORPUS_ANOMALY_DESC
     */
    public String getCorpusAnomalyDesc() {
        return corpusAnomalyDesc;
    }

    /**
     * @param corpusAnomalyDesc
     */
    public void setCorpusAnomalyDesc(String corpusAnomalyDesc) {
        this.corpusAnomalyDesc = corpusAnomalyDesc;
    }

    /**
     * @return WOUND_ANOMALY_SIGN
     */
    public String getWoundAnomalySign() {
        return woundAnomalySign;
    }

    /**
     * @param woundAnomalySign
     */
    public void setWoundAnomalySign(String woundAnomalySign) {
        this.woundAnomalySign = woundAnomalySign;
    }

    /**
     * @return WOUND_ANOMALY_DESC
     */
    public String getWoundAnomalyDesc() {
        return woundAnomalyDesc;
    }

    /**
     * @param woundAnomalyDesc
     */
    public void setWoundAnomalyDesc(String woundAnomalyDesc) {
        this.woundAnomalyDesc = woundAnomalyDesc;
    }

    /**
     * @return WOUND_HEALING_STATUS
     */
    public String getWoundHealingStatus() {
        return woundHealingStatus;
    }

    /**
     * @param woundHealingStatus
     */
    public void setWoundHealingStatus(String woundHealingStatus) {
        this.woundHealingStatus = woundHealingStatus;
    }

    /**
     * @return OTHER
     */
    public String getOther() {
        return other;
    }

    /**
     * @param other
     */
    public void setOther(String other) {
        this.other = other;
    }

    /**
     * @return PUERPERA_RESTORES_MARK
     */
    public String getPuerperaRestoresMark() {
        return puerperaRestoresMark;
    }

    /**
     * @param puerperaRestoresMark
     */
    public void setPuerperaRestoresMark(String puerperaRestoresMark) {
        this.puerperaRestoresMark = puerperaRestoresMark;
    }

    /**
     * @return HEALTH_ASSESSMENT_DESC
     */
    public String getHealthAssessmentDesc() {
        return healthAssessmentDesc;
    }

    /**
     * @param healthAssessmentDesc
     */
    public void setHealthAssessmentDesc(String healthAssessmentDesc) {
        this.healthAssessmentDesc = healthAssessmentDesc;
    }

    /**
     * @return HEALTH_GUIDANCE_CLASS
     */
    public String getHealthGuidanceClass() {
        return healthGuidanceClass;
    }

    /**
     * @param healthGuidanceClass
     */
    public void setHealthGuidanceClass(String healthGuidanceClass) {
        this.healthGuidanceClass = healthGuidanceClass;
    }

    /**
     * @return HEALTH_GUIDANCE_DESC
     */
    public String getHealthGuidanceDesc() {
        return healthGuidanceDesc;
    }

    /**
     * @param healthGuidanceDesc
     */
    public void setHealthGuidanceDesc(String healthGuidanceDesc) {
        this.healthGuidanceDesc = healthGuidanceDesc;
    }

    /**
     * @return FINAL_MARK
     */
    public String getFinalMark() {
        return finalMark;
    }

    /**
     * @param finalMark
     */
    public void setFinalMark(String finalMark) {
        this.finalMark = finalMark;
    }

    /**
     * @return REFERRAL_FLAG
     */
    public String getReferralFlag() {
        return referralFlag;
    }

    /**
     * @param referralFlag
     */
    public void setReferralFlag(String referralFlag) {
        this.referralFlag = referralFlag;
    }

    /**
     * @return REFERRAL_HOSPITAL_NAME
     */
    public String getReferralHospitalName() {
        return referralHospitalName;
    }

    /**
     * @param referralHospitalName
     */
    public void setReferralHospitalName(String referralHospitalName) {
        this.referralHospitalName = referralHospitalName;
    }

    /**
     * @return REFERRAL_DEPT_NAME
     */
    public String getReferralDeptName() {
        return referralDeptName;
    }

    /**
     * @param referralDeptName
     */
    public void setReferralDeptName(String referralDeptName) {
        this.referralDeptName = referralDeptName;
    }

    /**
     * @return REFERRAL_REASON
     */
    public String getReferralReason() {
        return referralReason;
    }

    /**
     * @param referralReason
     */
    public void setReferralReason(String referralReason) {
        this.referralReason = referralReason;
    }

    /**
     * @return SUPERVISION_DOCTOR
     */
    public String getSupervisionDoctor() {
        return supervisionDoctor;
    }

    /**
     * @param supervisionDoctor
     */
    public void setSupervisionDoctor(String supervisionDoctor) {
        this.supervisionDoctor = supervisionDoctor;
    }

    /**
     * @return IS_DELETE
     */
    public Short getIsDelete() {
        return isDelete;
    }

    /**
     * @param isDelete
     */
    public void setIsDelete(Short isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * @return MOTHER_IDCARD
     */
    public String getMotherIdcard() {
        return motherIdcard;
    }

    /**
     * @param motherIdcard
     */
    public void setMotherIdcard(String motherIdcard) {
        this.motherIdcard = motherIdcard;
    }

    /**
     * @return BABY_CARD_NO
     */
    public String getBabyCardNo() {
        return babyCardNo;
    }

    /**
     * @param babyCardNo
     */
    public void setBabyCardNo(String babyCardNo) {
        this.babyCardNo = babyCardNo;
    }

    /**
     * @return CREATE_ORGAN_CODE
     */
    public String getCreateOrganCode() {
        return createOrganCode;
    }

    /**
     * @param createOrganCode
     */
    public void setCreateOrganCode(String createOrganCode) {
        this.createOrganCode = createOrganCode;
    }

    /**
     * @return CREATE_ORGAN_NAME
     */
    public String getCreateOrganName() {
        return createOrganName;
    }

    /**
     * @param createOrganName
     */
    public void setCreateOrganName(String createOrganName) {
        this.createOrganName = createOrganName;
    }

    /**
     * @return PROCESS_STATUS
     */
    public String getProcessStatus() {
        return processStatus;
    }

    /**
     * @param processStatus
     */
    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    /**
     * @return GATHER_DATE
     */
    public Date getGatherDate() {
        return gatherDate;
    }

    /**
     * @param gatherDate
     */
    public void setGatherDate(Date gatherDate) {
        this.gatherDate = gatherDate;
    }

    /**
     * @return CLASSIFY_FLAG
     */
    public String getClassifyFlag() {
        return classifyFlag;
    }

    /**
     * @param classifyFlag
     */
    public void setClassifyFlag(String classifyFlag) {
        this.classifyFlag = classifyFlag;
    }

    /**
     * @return CLASSIFY_DESC
     */
    public String getClassifyDesc() {
        return classifyDesc;
    }

    /**
     * @param classifyDesc
     */
    public void setClassifyDesc(String classifyDesc) {
        this.classifyDesc = classifyDesc;
    }

    /**
     * @return DELIVERY_DATE
     */
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * @param deliveryDate
     */
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * @return LEAVE_HOSPITAL_DATE
     */
    public Date getLeaveHospitalDate() {
        return leaveHospitalDate;
    }

    /**
     * @param leaveHospitalDate
     */
    public void setLeaveHospitalDate(Date leaveHospitalDate) {
        this.leaveHospitalDate = leaveHospitalDate;
    }

    /**
     * @return CM_HEALTH_MANAGE
     */
    public String getCmHealthManage() {
        return cmHealthManage;
    }

    /**
     * @param cmHealthManage
     */
    public void setCmHealthManage(String cmHealthManage) {
        this.cmHealthManage = cmHealthManage;
    }

    /**
     * @return CM_HEALTH_MANAGE_DESC
     */
    public String getCmHealthManageDesc() {
        return cmHealthManageDesc;
    }

    /**
     * @param cmHealthManageDesc
     */
    public void setCmHealthManageDesc(String cmHealthManageDesc) {
        this.cmHealthManageDesc = cmHealthManageDesc;
    }
}
