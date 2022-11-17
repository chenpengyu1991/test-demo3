package com.founder.rhip.ehr.entity.women;


import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Table(name = "WH_DELIVERY_RECORD_INFO")
public class DeliveryRecordInfo {
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

    @Column(name = "WOMEN_HEALTH_NUMBER")
    private String womenHealthNumber;

    @Column(name = "ADMISSION_NO")
    private String admissionNo;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ID_CARD")
    private String idCard;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "IDCARD_TYPE")
    private String idcardType;

    @Column(name = "DELIVERY_DATE")
    private Date deliveryDate;

    @Column(name = "DELIVERY_WEEK")
    private Integer deliveryWeek;

    @Column(name = "DELIVERY_WAY")
    private String deliveryWay;

    @Column(name = "DELIVERY_OUTCOME")
    private String deliveryOutcome;

    @Column(name = "DELIVERY_HOSPITAL_CODE")
    private String deliveryHospitalCode;

    @Column(name = "DELIVERY_HOSPITAL_NAME")
    private String deliveryHospitalName;

    @Column(name = "TOTAL_LABOR_RUNTIME")
    private Integer totalLaborRuntime;

    @Column(name = "FIRST_TOTAL_LABOR_RUNTIME")
    private Integer firstTotalLaborRuntime;

    @Column(name = "SECOND_TOTAL_LABOR_RUNTIME")
    private Integer secondTotalLaborRuntime;

    @Column(name = "THIRD_TOTAL_LABOR_RUNTIME")
    private Integer thirdTotalLaborRuntime;

    @Column(name = "POSTPARTUM_OPEN_MILK_RUNTIME")
    private Integer postpartumOpenMilkRuntime;

    @Column(name = "DELIVERY_BLEED")
    private Integer deliveryBleed;

    @Column(name = "DELIVERY_TOTAL_BLEED")
    private Integer deliveryTotalBleed;

    @Column(name = "DELIVERY_BLEED_AFTER_TWO_HOURS")
    private Integer deliveryBleedAfterTwoHours;

    @Column(name = "PERINEUM_CUT_FLAG")
    private String perineumCutFlag;

    @Column(name = "PERINEUM_TEAR_DEGREE")
    private String perineumTearDegree;

    @Column(name = "PERINEUM_TEAR_NEEDLE_NUMBER")
    private Integer perineumTearNeedleNumber;

    @Column(name = "SEVERE_MATERNAL_FLAG")
    private String severeMaternalFlag;

    @Column(name = "RISK_FACTOR_CODE")
    private String riskFactorCode;

    @Column(name = "RISK_FACTOR_FLAG")
    private String riskFactorFlag;

    @Column(name = "COMPLICATIONS_CODE")
    private String complicationsCode;

    @Column(name = "SYSTOLIC_PRESSURE")
    private Integer systolicPressure;

    @Column(name = "DIASTOLIC_PRESSURE")
    private Integer diastolicPressure;

    @Column(name = "GESTATIONAL_NUMBER")
    private Integer gestationalNumber;

    @Column(name = "INPATIENTDATE")
    private Date inpatientdate;

    @Column(name = "OUTPATIENTDATE")
    private Date outpatientdate;

    @Column(name = "POSTPARTUM_ADRESS")
    private String postpartumAdress;

    @Column(name = "CREATE_ORGAN_CODE")
    private String createOrganCode;

    @Column(name = "CREATE_ORGAN_NAME")
    private String createOrganName;

    @Column(name = "PROCESS_STATUS")
    private String processStatus;

    @Column(name = "GATHER_DATE")
    private Date gatherDate;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "UPDATE_DATE")
    private Date updateDate;

    @Column(name = "OPERATE")
    private String operate;

    @Column(name = "IS_DELETE")
    private Short isDelete;

    @Column(name = "PLACENTA")
    private String placenta;

    @Column(name = "PEEL_STATUS")
    private String peelStatus;

    @Transient
    private List<DeliveryNeonatal> neonatalList;

    @Column(name = "DELIVERY_OTHER")
    private String deliveryOther;

    @Column(name = "COMPLICATIONS_DESC")
    private String complicationsDesc;

    public String getDeliveryOther() {
        return deliveryOther;
    }

    public void setDeliveryOther(String deliveryOther) {
        this.deliveryOther = deliveryOther;
    }

    public String getComplicationsDesc() {
        return complicationsDesc;
    }

    public void setComplicationsDesc(String complicationsDesc) {
        this.complicationsDesc = complicationsDesc;
    }

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
     * @return WOMEN_HEALTH_NUMBER
     */
    public String getWomenHealthNumber() {
        return womenHealthNumber;
    }

    /**
     * @param womenHealthNumber
     */
    public void setWomenHealthNumber(String womenHealthNumber) {
        this.womenHealthNumber = womenHealthNumber;
    }

    /**
     * @return ADMISSION_NO
     */
    public String getAdmissionNo() {
        return admissionNo;
    }

    /**
     * @param admissionNo
     */
    public void setAdmissionNo(String admissionNo) {
        this.admissionNo = admissionNo;
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
     * @return IDCARD_TYPE
     */
    public String getIdcardType() {
        return idcardType;
    }

    /**
     * @param idcardType
     */
    public void setIdcardType(String idcardType) {
        this.idcardType = idcardType;
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
     * @return DELIVERY_WEEK
     */
    public Integer getDeliveryWeek() {
        return deliveryWeek;
    }

    /**
     * @param deliveryWeek
     */
    public void setDeliveryWeek(Integer deliveryWeek) {
        this.deliveryWeek = deliveryWeek;
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
     * @return DELIVERY_OUTCOME
     */
    public String getDeliveryOutcome() {
        return deliveryOutcome;
    }

    /**
     * @param deliveryOutcome
     */
    public void setDeliveryOutcome(String deliveryOutcome) {
        this.deliveryOutcome = deliveryOutcome;
    }

    /**
     * @return DELIVERY_HOSPITAL_CODE
     */
    public String getDeliveryHospitalCode() {
        return deliveryHospitalCode;
    }

    /**
     * @param deliveryHospitalCode
     */
    public void setDeliveryHospitalCode(String deliveryHospitalCode) {
        this.deliveryHospitalCode = deliveryHospitalCode;
    }

    /**
     * @return DELIVERY_HOSPITAL_NAME
     */
    public String getDeliveryHospitalName() {
        return deliveryHospitalName;
    }

    /**
     * @param deliveryHospitalName
     */
    public void setDeliveryHospitalName(String deliveryHospitalName) {
        this.deliveryHospitalName = deliveryHospitalName;
    }

    /**
     * @return TOTAL_LABOR_RUNTIME
     */
    public Integer getTotalLaborRuntime() {
        return totalLaborRuntime;
    }

    /**
     * @param totalLaborRuntime
     */
    public void setTotalLaborRuntime(Integer totalLaborRuntime) {
        this.totalLaborRuntime = totalLaborRuntime;
    }

    /**
     * @return FIRST_TOTAL_LABOR_RUNTIME
     */
    public Integer getFirstTotalLaborRuntime() {
        return firstTotalLaborRuntime;
    }

    /**
     * @param firstTotalLaborRuntime
     */
    public void setFirstTotalLaborRuntime(Integer firstTotalLaborRuntime) {
        this.firstTotalLaborRuntime = firstTotalLaborRuntime;
    }

    /**
     * @return SECOND_TOTAL_LABOR_RUNTIME
     */
    public Integer getSecondTotalLaborRuntime() {
        return secondTotalLaborRuntime;
    }

    /**
     * @param secondTotalLaborRuntime
     */
    public void setSecondTotalLaborRuntime(Integer secondTotalLaborRuntime) {
        this.secondTotalLaborRuntime = secondTotalLaborRuntime;
    }

    /**
     * @return THIRD_TOTAL_LABOR_RUNTIME
     */
    public Integer getThirdTotalLaborRuntime() {
        return thirdTotalLaborRuntime;
    }

    /**
     * @param thirdTotalLaborRuntime
     */
    public void setThirdTotalLaborRuntime(Integer thirdTotalLaborRuntime) {
        this.thirdTotalLaborRuntime = thirdTotalLaborRuntime;
    }

    /**
     * @return POSTPARTUM_OPEN_MILK_RUNTIME
     */
    public Integer getPostpartumOpenMilkRuntime() {
        return postpartumOpenMilkRuntime;
    }

    /**
     * @param postpartumOpenMilkRuntime
     */
    public void setPostpartumOpenMilkRuntime(Integer postpartumOpenMilkRuntime) {
        this.postpartumOpenMilkRuntime = postpartumOpenMilkRuntime;
    }

    /**
     * @return DELIVERY_BLEED
     */
    public Integer getDeliveryBleed() {
        return deliveryBleed;
    }

    /**
     * @param deliveryBleed
     */
    public void setDeliveryBleed(Integer deliveryBleed) {
        this.deliveryBleed = deliveryBleed;
    }

    /**
     * @return DELIVERY_TOTAL_BLEED
     */
    public Integer getDeliveryTotalBleed() {
        return deliveryTotalBleed;
    }

    /**
     * @param deliveryTotalBleed
     */
    public void setDeliveryTotalBleed(Integer deliveryTotalBleed) {
        this.deliveryTotalBleed = deliveryTotalBleed;
    }

    /**
     * @return DELIVERY_BLEED_AFTER_TWO_HOURS
     */
    public Integer getDeliveryBleedAfterTwoHours() {
        return deliveryBleedAfterTwoHours;
    }

    /**
     * @param deliveryBleedAfterTwoHours
     */
    public void setDeliveryBleedAfterTwoHours(Integer deliveryBleedAfterTwoHours) {
        this.deliveryBleedAfterTwoHours = deliveryBleedAfterTwoHours;
    }

    /**
     * @return PERINEUM_CUT_FLAG
     */
    public String getPerineumCutFlag() {
        return perineumCutFlag;
    }

    /**
     * @param perineumCutFlag
     */
    public void setPerineumCutFlag(String perineumCutFlag) {
        this.perineumCutFlag = perineumCutFlag;
    }

    /**
     * @return PERINEUM_TEAR_DEGREE
     */
    public String getPerineumTearDegree() {
        return perineumTearDegree;
    }

    /**
     * @param perineumTearDegree
     */
    public void setPerineumTearDegree(String perineumTearDegree) {
        this.perineumTearDegree = perineumTearDegree;
    }

    /**
     * @return PERINEUM_TEAR_NEEDLE_NUMBER
     */
    public Integer getPerineumTearNeedleNumber() {
        return perineumTearNeedleNumber;
    }

    /**
     * @param perineumTearNeedleNumber
     */
    public void setPerineumTearNeedleNumber(Integer perineumTearNeedleNumber) {
        this.perineumTearNeedleNumber = perineumTearNeedleNumber;
    }

    /**
     * @return SEVERE_MATERNAL_FLAG
     */
    public String getSevereMaternalFlag() {
        return severeMaternalFlag;
    }

    /**
     * @param severeMaternalFlag
     */
    public void setSevereMaternalFlag(String severeMaternalFlag) {
        this.severeMaternalFlag = severeMaternalFlag;
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
     * @return RISK_FACTOR_FLAG
     */
    public String getRiskFactorFlag() {
        return riskFactorFlag;
    }

    /**
     * @param riskFactorFlag
     */
    public void setRiskFactorFlag(String riskFactorFlag) {
        this.riskFactorFlag = riskFactorFlag;
    }

    /**
     * @return COMPLICATIONS_CODE
     */
    public String getComplicationsCode() {
        return complicationsCode;
    }

    /**
     * @param complicationsCode
     */
    public void setComplicationsCode(String complicationsCode) {
        this.complicationsCode = complicationsCode;
    }

    /**
     * @return SYSTOLIC_PRESSURE
     */
    public Integer getSystolicPressure() {
        return systolicPressure;
    }

    /**
     * @param systolicPressure
     */
    public void setSystolicPressure(Integer systolicPressure) {
        this.systolicPressure = systolicPressure;
    }

    /**
     * @return DIASTOLIC_PRESSURE
     */
    public Integer getDiastolicPressure() {
        return diastolicPressure;
    }

    /**
     * @param diastolicPressure
     */
    public void setDiastolicPressure(Integer diastolicPressure) {
        this.diastolicPressure = diastolicPressure;
    }

    /**
     * @return GESTATIONAL_NUMBER
     */
    public Integer getGestationalNumber() {
        return gestationalNumber;
    }

    /**
     * @param gestationalNumber
     */
    public void setGestationalNumber(Integer gestationalNumber) {
        this.gestationalNumber = gestationalNumber;
    }

    /**
     * @return INPATIENTDATE
     */
    public Date getInpatientdate() {
        return inpatientdate;
    }

    /**
     * @param inpatientdate
     */
    public void setInpatientdate(Date inpatientdate) {
        this.inpatientdate = inpatientdate;
    }

    /**
     * @return OUTPATIENTDATE
     */
    public Date getOutpatientdate() {
        return outpatientdate;
    }

    /**
     * @param outpatientdate
     */
    public void setOutpatientdate(Date outpatientdate) {
        this.outpatientdate = outpatientdate;
    }

    /**
     * @return POSTPARTUM_ADRESS
     */
    public String getPostpartumAdress() {
        return postpartumAdress;
    }

    /**
     * @param postpartumAdress
     */
    public void setPostpartumAdress(String postpartumAdress) {
        this.postpartumAdress = postpartumAdress;
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
     * @return CREATE_DATE
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return UPDATE_DATE
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * @return OPERATE
     */
    public String getOperate() {
        return operate;
    }

    /**
     * @param operate
     */
    public void setOperate(String operate) {
        this.operate = operate;
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
     * @return PLACENTA
     */
    public String getPlacenta() {
        return placenta;
    }

    /**
     * @param placenta
     */
    public void setPlacenta(String placenta) {
        this.placenta = placenta;
    }

    /**
     * @return PEEL_STATUS
     */
    public String getPeelStatus() {
        return peelStatus;
    }

    /**
     * @param peelStatus
     */
    public void setPeelStatus(String peelStatus) {
        this.peelStatus = peelStatus;
    }

    public List<DeliveryNeonatal> getNeonatalList() {
        return neonatalList;
    }

    public void setNeonatalList(List<DeliveryNeonatal> neonatalList) {
        this.neonatalList = neonatalList;
    }

}