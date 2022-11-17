package com.founder.rhip.ehr.entity.women;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "WH_HIGHRISK_MATERNAL_REG")
public class HighriskMaternalReg {
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

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "AGE_UNIT_CODE")
    private String ageUnitCode;

    @Column(name = "AGE_UNIT_NAME")
    private String ageUnitName;

    @Column(name = "IDCARD_TYPE_CODE")
    private String idcardTypeCode;

    @Column(name = "IDCARD_TYPE_NAME")
    private String idcardTypeName;

    @Column(name = "IDCARD")
    private String idcard;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "OCCUPATION")
    private String occupation;

    @Column(name = "GRAVIDITY_TIMES")
    private Short gravidityTimes;

    @Column(name = "PRODUCTION_TIMES")
    private Short productionTimes;

    @Column(name = "HR_ADDRESS")
    private String hrAddress;

    @Column(name = "PA_ADDRESS")
    private String paAddress;

    @Column(name = "HUSBAND_NAME")
    private String husbandName;

    @Column(name = "HUSBAND_PHONE")
    private String husbandPhone;

    @Column(name = "LAST_MENSTRUAL_DATE")
    private Date lastMenstrualDate;

    @Column(name = "ESTIMATED_DUE_DATES")
    private Date estimatedDueDates;

    @Column(name = "DISCOVERY_DATE")
    private Date discoveryDate;

    @Column(name = "GESTATIONAL_WEEKS")
    private String gestationalWeeks;

    @Column(name = "RISK_FACTOR_CODE")
    private String riskFactorCode;

    @Column(name = "RISK_FACTOR_NAME")
    private String riskFactorName;

    @Column(name = "RISK_FACTOR_DESC")
    private String riskFactorDesc;

    @Column(name = "RISK_LEVEL_CODE")
    private String riskLevelCode;

    @Column(name = "RISK_LEVEL_NAME")
    private String riskLevelName;

    @Column(name = "RISK_SCORE_VALUE")
    private Integer riskScoreValue;

    @Column(name = "TREATMENT_RESULTS")
    private String treatmentResults;

    @Column(name = "TREATMENT_RESULTS_NAME")
    private String treatmentResultsName;

    @Column(name = "IN_HOSPITAL_DT")
    private Date inHospitalDt;

    @Column(name = "OUT_HOSPITAL_DT")
    private Date outHospitalDt;

    @Column(name = "DELIVERY_PLACE")
    private String deliveryPlace;

    @Column(name = "DELIVERY_WAY")
    private String deliveryWay;

    @Column(name = "REFERRAL_FLAG")
    private String referralFlag;

    @Column(name = "REFERRAL_NAME")
    private String referralName;

    @Column(name = "REFERRAL_REASON")
    private String referralReason;

    @Column(name = "REFERRAL_HOSPITAL_CODE")
    private String referralHospitalCode;

    @Column(name = "REFERRAL_HOSPITAL_NAME")
    private String referralHospitalName;

    @Column(name = "REFERRAL_DEPT_CODE")
    private String referralDeptCode;

    @Column(name = "REFERRAL_DEPT_NAME")
    private String referralDeptName;

    @Column(name = "REPORTER")
    private String reporter;

    @Column(name = "REPORT_DATE")
    private Date reportDate;

    @Column(name = "REPORTER_HOSPITAL_NAME")
    private String reporterHospitalName;

    @Column(name = "FINAL_MARK")
    private String finalMark;

    @Column(name = "FINAL_MARK_NAME")
    private String finalMarkName;

    @Column(name = "INPUT_ORG_CODE")
    private String inputOrgCode;

    @Column(name = "INPUT_ORG_NAME")
    private String inputOrgName;

    @Column(name = "INPUT_DOCTOR_CODE")
    private String inputDoctorCode;

    @Column(name = "INPUT_DOCTOR_NAME")
    private String inputDoctorName;

    @Column(name = "INPUT_DOCTOR_PHONE")
    private String inputDoctorPhone;

    @Column(name = "MANAGE_ORG_CODE")
    private String manageOrgCode;

    @Column(name = "MANAGE_ORG_NAME")
    private String manageOrgName;

    @Column(name = "INPUT_DATE")
    private Date inputDate;

    @Column(name = "LAST_MODIFY_TIME")
    private Date lastModifyTime;

    @Column(name = "LAST_MODIFY_DOCTOR_CODE")
    private String lastModifyDoctorCode;

    @Column(name = "LAST_MODIFY_DOCTOR_NAME")
    private String lastModifyDoctorName;

    @Column(name = "LAST_MODIFY_ORG_CODE")
    private String lastModifyOrgCode;

    @Column(name = "LAST_MODIFY_ORG_NAME")
    private String lastModifyOrgName;

    @Column(name = "CLINIC_ORGAN_CODE")
    private String clinicOrganCode;

    @Column(name = "CLINIC_ORGAN_NAME")
    private String clinicOrganName;

    @Column(name = "BUSINESS_ID")
    private String businessId;

    @Column(name = "UPLOAD_TIME")
    private Date uploadTime;

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
     * @return BIRTHDAY
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return AGE
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return AGE_UNIT_CODE
     */
    public String getAgeUnitCode() {
        return ageUnitCode;
    }

    /**
     * @param ageUnitCode
     */
    public void setAgeUnitCode(String ageUnitCode) {
        this.ageUnitCode = ageUnitCode;
    }

    /**
     * @return AGE_UNIT_NAME
     */
    public String getAgeUnitName() {
        return ageUnitName;
    }

    /**
     * @param ageUnitName
     */
    public void setAgeUnitName(String ageUnitName) {
        this.ageUnitName = ageUnitName;
    }

    /**
     * @return IDCARD_TYPE_CODE
     */
    public String getIdcardTypeCode() {
        return idcardTypeCode;
    }

    /**
     * @param idcardTypeCode
     */
    public void setIdcardTypeCode(String idcardTypeCode) {
        this.idcardTypeCode = idcardTypeCode;
    }

    /**
     * @return IDCARD_TYPE_NAME
     */
    public String getIdcardTypeName() {
        return idcardTypeName;
    }

    /**
     * @param idcardTypeName
     */
    public void setIdcardTypeName(String idcardTypeName) {
        this.idcardTypeName = idcardTypeName;
    }

    /**
     * @return IDCARD
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * @param idcard
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    /**
     * @return PHONE
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return OCCUPATION
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * @param occupation
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * @return GRAVIDITY_TIMES
     */
    public Short getGravidityTimes() {
        return gravidityTimes;
    }

    /**
     * @param gravidityTimes
     */
    public void setGravidityTimes(Short gravidityTimes) {
        this.gravidityTimes = gravidityTimes;
    }

    /**
     * @return PRODUCTION_TIMES
     */
    public Short getProductionTimes() {
        return productionTimes;
    }

    /**
     * @param productionTimes
     */
    public void setProductionTimes(Short productionTimes) {
        this.productionTimes = productionTimes;
    }

    /**
     * @return HR_ADDRESS
     */
    public String getHrAddress() {
        return hrAddress;
    }

    /**
     * @param hrAddress
     */
    public void setHrAddress(String hrAddress) {
        this.hrAddress = hrAddress;
    }

    /**
     * @return PA_ADDRESS
     */
    public String getPaAddress() {
        return paAddress;
    }

    /**
     * @param paAddress
     */
    public void setPaAddress(String paAddress) {
        this.paAddress = paAddress;
    }

    /**
     * @return HUSBAND_NAME
     */
    public String getHusbandName() {
        return husbandName;
    }

    /**
     * @param husbandName
     */
    public void setHusbandName(String husbandName) {
        this.husbandName = husbandName;
    }

    /**
     * @return HUSBAND_PHONE
     */
    public String getHusbandPhone() {
        return husbandPhone;
    }

    /**
     * @param husbandPhone
     */
    public void setHusbandPhone(String husbandPhone) {
        this.husbandPhone = husbandPhone;
    }

    /**
     * @return LAST_MENSTRUAL_DATE
     */
    public Date getLastMenstrualDate() {
        return lastMenstrualDate;
    }

    /**
     * @param lastMenstrualDate
     */
    public void setLastMenstrualDate(Date lastMenstrualDate) {
        this.lastMenstrualDate = lastMenstrualDate;
    }

    /**
     * @return ESTIMATED_DUE_DATES
     */
    public Date getEstimatedDueDates() {
        return estimatedDueDates;
    }

    /**
     * @param estimatedDueDates
     */
    public void setEstimatedDueDates(Date estimatedDueDates) {
        this.estimatedDueDates = estimatedDueDates;
    }

    /**
     * @return DISCOVERY_DATE
     */
    public Date getDiscoveryDate() {
        return discoveryDate;
    }

    /**
     * @param discoveryDate
     */
    public void setDiscoveryDate(Date discoveryDate) {
        this.discoveryDate = discoveryDate;
    }

    /**
     * @return GESTATIONAL_WEEKS
     */
    public String getGestationalWeeks() {
        return gestationalWeeks;
    }

    /**
     * @param gestationalWeeks
     */
    public void setGestationalWeeks(String gestationalWeeks) {
        this.gestationalWeeks = gestationalWeeks;
    }

    /**
     * @return RISK_FACTOR_CODE
     */
    public String getRiskFactorCode() {
        return riskFactorCode;
    }

    /**
     * @param riskFactorCode
     */
    public void setRiskFactorCode(String riskFactorCode) {
        this.riskFactorCode = riskFactorCode;
    }

    /**
     * @return RISK_FACTOR_NAME
     */
    public String getRiskFactorName() {
        return riskFactorName;
    }

    /**
     * @param riskFactorName
     */
    public void setRiskFactorName(String riskFactorName) {
        this.riskFactorName = riskFactorName;
    }

    /**
     * @return RISK_FACTOR_DESC
     */
    public String getRiskFactorDesc() {
        return riskFactorDesc;
    }

    /**
     * @param riskFactorDesc
     */
    public void setRiskFactorDesc(String riskFactorDesc) {
        this.riskFactorDesc = riskFactorDesc;
    }

    /**
     * @return RISK_LEVEL_CODE
     */
    public String getRiskLevelCode() {
        return riskLevelCode;
    }

    /**
     * @param riskLevelCode
     */
    public void setRiskLevelCode(String riskLevelCode) {
        this.riskLevelCode = riskLevelCode;
    }

    /**
     * @return RISK_LEVEL_NAME
     */
    public String getRiskLevelName() {
        return riskLevelName;
    }

    /**
     * @param riskLevelName
     */
    public void setRiskLevelName(String riskLevelName) {
        this.riskLevelName = riskLevelName;
    }

    /**
     * @return RISK_SCORE_VALUE
     */
    public Integer getRiskScoreValue() {
        return riskScoreValue;
    }

    /**
     * @param riskScoreValue
     */
    public void setRiskScoreValue(Integer riskScoreValue) {
        this.riskScoreValue = riskScoreValue;
    }

    /**
     * @return TREATMENT_RESULTS
     */
    public String getTreatmentResults() {
        return treatmentResults;
    }

    /**
     * @param treatmentResults
     */
    public void setTreatmentResults(String treatmentResults) {
        this.treatmentResults = treatmentResults;
    }

    /**
     * @return TREATMENT_RESULTS_NAME
     */
    public String getTreatmentResultsName() {
        return treatmentResultsName;
    }

    /**
     * @param treatmentResultsName
     */
    public void setTreatmentResultsName(String treatmentResultsName) {
        this.treatmentResultsName = treatmentResultsName;
    }

    /**
     * @return IN_HOSPITAL_DT
     */
    public Date getInHospitalDt() {
        return inHospitalDt;
    }

    /**
     * @param inHospitalDt
     */
    public void setInHospitalDt(Date inHospitalDt) {
        this.inHospitalDt = inHospitalDt;
    }

    /**
     * @return OUT_HOSPITAL_DT
     */
    public Date getOutHospitalDt() {
        return outHospitalDt;
    }

    /**
     * @param outHospitalDt
     */
    public void setOutHospitalDt(Date outHospitalDt) {
        this.outHospitalDt = outHospitalDt;
    }

    /**
     * @return DELIVERY_PLACE
     */
    public String getDeliveryPlace() {
        return deliveryPlace;
    }

    /**
     * @param deliveryPlace
     */
    public void setDeliveryPlace(String deliveryPlace) {
        this.deliveryPlace = deliveryPlace;
    }

    /**
     * @return DELIVERY_WAY
     */
    public String getDeliveryWay() {
        return deliveryWay;
    }

    /**
     * @param deliveryWay
     */
    public void setDeliveryWay(String deliveryWay) {
        this.deliveryWay = deliveryWay;
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
     * @return REFERRAL_NAME
     */
    public String getReferralName() {
        return referralName;
    }

    /**
     * @param referralName
     */
    public void setReferralName(String referralName) {
        this.referralName = referralName;
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
     * @return REFERRAL_HOSPITAL_CODE
     */
    public String getReferralHospitalCode() {
        return referralHospitalCode;
    }

    /**
     * @param referralHospitalCode
     */
    public void setReferralHospitalCode(String referralHospitalCode) {
        this.referralHospitalCode = referralHospitalCode;
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
     * @return REFERRAL_DEPT_CODE
     */
    public String getReferralDeptCode() {
        return referralDeptCode;
    }

    /**
     * @param referralDeptCode
     */
    public void setReferralDeptCode(String referralDeptCode) {
        this.referralDeptCode = referralDeptCode;
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
     * @return REPORTER
     */
    public String getReporter() {
        return reporter;
    }

    /**
     * @param reporter
     */
    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    /**
     * @return REPORT_DATE
     */
    public Date getReportDate() {
        return reportDate;
    }

    /**
     * @param reportDate
     */
    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    /**
     * @return REPORTER_HOSPITAL_NAME
     */
    public String getReporterHospitalName() {
        return reporterHospitalName;
    }

    /**
     * @param reporterHospitalName
     */
    public void setReporterHospitalName(String reporterHospitalName) {
        this.reporterHospitalName = reporterHospitalName;
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
     * @return FINAL_MARK_NAME
     */
    public String getFinalMarkName() {
        return finalMarkName;
    }

    /**
     * @param finalMarkName
     */
    public void setFinalMarkName(String finalMarkName) {
        this.finalMarkName = finalMarkName;
    }

    /**
     * @return INPUT_ORG_CODE
     */
    public String getInputOrgCode() {
        return inputOrgCode;
    }

    /**
     * @param inputOrgCode
     */
    public void setInputOrgCode(String inputOrgCode) {
        this.inputOrgCode = inputOrgCode;
    }

    /**
     * @return INPUT_ORG_NAME
     */
    public String getInputOrgName() {
        return inputOrgName;
    }

    /**
     * @param inputOrgName
     */
    public void setInputOrgName(String inputOrgName) {
        this.inputOrgName = inputOrgName;
    }

    /**
     * @return INPUT_DOCTOR_CODE
     */
    public String getInputDoctorCode() {
        return inputDoctorCode;
    }

    /**
     * @param inputDoctorCode
     */
    public void setInputDoctorCode(String inputDoctorCode) {
        this.inputDoctorCode = inputDoctorCode;
    }

    /**
     * @return INPUT_DOCTOR_NAME
     */
    public String getInputDoctorName() {
        return inputDoctorName;
    }

    /**
     * @param inputDoctorName
     */
    public void setInputDoctorName(String inputDoctorName) {
        this.inputDoctorName = inputDoctorName;
    }

    /**
     * @return INPUT_DOCTOR_PHONE
     */
    public String getInputDoctorPhone() {
        return inputDoctorPhone;
    }

    /**
     * @param inputDoctorPhone
     */
    public void setInputDoctorPhone(String inputDoctorPhone) {
        this.inputDoctorPhone = inputDoctorPhone;
    }

    /**
     * @return MANAGE_ORG_CODE
     */
    public String getManageOrgCode() {
        return manageOrgCode;
    }

    /**
     * @param manageOrgCode
     */
    public void setManageOrgCode(String manageOrgCode) {
        this.manageOrgCode = manageOrgCode;
    }

    /**
     * @return MANAGE_ORG_NAME
     */
    public String getManageOrgName() {
        return manageOrgName;
    }

    /**
     * @param manageOrgName
     */
    public void setManageOrgName(String manageOrgName) {
        this.manageOrgName = manageOrgName;
    }

    /**
     * @return INPUT_DATE
     */
    public Date getInputDate() {
        return inputDate;
    }

    /**
     * @param inputDate
     */
    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    /**
     * @return LAST_MODIFY_TIME
     */
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * @param lastModifyTime
     */
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    /**
     * @return LAST_MODIFY_DOCTOR_CODE
     */
    public String getLastModifyDoctorCode() {
        return lastModifyDoctorCode;
    }

    /**
     * @param lastModifyDoctorCode
     */
    public void setLastModifyDoctorCode(String lastModifyDoctorCode) {
        this.lastModifyDoctorCode = lastModifyDoctorCode;
    }

    /**
     * @return LAST_MODIFY_DOCTOR_NAME
     */
    public String getLastModifyDoctorName() {
        return lastModifyDoctorName;
    }

    /**
     * @param lastModifyDoctorName
     */
    public void setLastModifyDoctorName(String lastModifyDoctorName) {
        this.lastModifyDoctorName = lastModifyDoctorName;
    }

    /**
     * @return LAST_MODIFY_ORG_CODE
     */
    public String getLastModifyOrgCode() {
        return lastModifyOrgCode;
    }

    /**
     * @param lastModifyOrgCode
     */
    public void setLastModifyOrgCode(String lastModifyOrgCode) {
        this.lastModifyOrgCode = lastModifyOrgCode;
    }

    /**
     * @return LAST_MODIFY_ORG_NAME
     */
    public String getLastModifyOrgName() {
        return lastModifyOrgName;
    }

    /**
     * @param lastModifyOrgName
     */
    public void setLastModifyOrgName(String lastModifyOrgName) {
        this.lastModifyOrgName = lastModifyOrgName;
    }

    /**
     * @return CLINIC_ORGAN_CODE
     */
    public String getClinicOrganCode() {
        return clinicOrganCode;
    }

    /**
     * @param clinicOrganCode
     */
    public void setClinicOrganCode(String clinicOrganCode) {
        this.clinicOrganCode = clinicOrganCode;
    }

    /**
     * @return CLINIC_ORGAN_NAME
     */
    public String getClinicOrganName() {
        return clinicOrganName;
    }

    /**
     * @param clinicOrganName
     */
    public void setClinicOrganName(String clinicOrganName) {
        this.clinicOrganName = clinicOrganName;
    }

    /**
     * @return BUSINESS_ID
     */
    public String getBusinessId() {
        return businessId;
    }

    /**
     * @param businessId
     */
    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    /**
     * @return UPLOAD_TIME
     */
    public Date getUploadTime() {
        return uploadTime;
    }

    /**
     * @param uploadTime
     */
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
}