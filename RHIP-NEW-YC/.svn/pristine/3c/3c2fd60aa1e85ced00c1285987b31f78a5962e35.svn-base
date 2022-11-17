package com.founder.rhip.ehr.entity.clinic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "MS_OUTPATIENT_INFO")
public class OutpatientInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = false)
    private String ehrId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号||", length = 17, nullable = true)
    private String healthfileNo;

    @Column(name = "OUTPATIENT_NO", columnDefinition = "VARCHAR2|门诊号||", length = 18, nullable = true)
    private String outpatientNo;

    @Column(name = "CLINIC_RECORD_NO", columnDefinition = "VARCHAR2|接诊记录表编号||", length = 20, nullable = true)
    private String clinicRecordNo;

    @Column(name = "REPORT_CARD_TYPE_CODE", columnDefinition = "VARCHAR2|就诊卡类型/报卡类别代码||", length = 1, nullable = true)
    private String reportCardTypeCode;

    @Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|就诊卡/报告卡编码||", length = 20, nullable = true)
    private String recordNumber;

    @Column(name = "CLINIC_ORGAN_CODE", columnDefinition = "VARCHAR2|就诊机构代码||", length = 20, nullable = true)
    private String clinicOrganCode;

    @Column(name = "CLINIC_ORGAN_NAME", columnDefinition = "VARCHAR2|就诊机构名称||", length = 70, nullable = true)
    private String clinicOrganName;

    @Column(name = "MEDICAL_ROOM_CODE", columnDefinition = "VARCHAR2|就诊科室代码||", length = 5, nullable = true)
    private String medicalRoomCode;

    @Column(name = "MEDICAL_ROOM_NAME", columnDefinition = "VARCHAR2|就诊科室名称||", length = 50, nullable = true)
    private String medicalRoomName;

    @Column(name = "CLINIC_DATE", columnDefinition = "TIMESTAMP|就诊日期时间||", nullable = true)
    private Date clinicDate;

    @Column(name = "CLINIC_PEOPLE_NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
    private String clinicPeopleName;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
    private String gender;

    @Column(name = "AGE", columnDefinition = "VARCHAR2|年龄||", length = 20, nullable = true)
    private String age;

    @Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
    private Date birthday;

    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况||", length = 3, nullable = true)
    private String marriage;

    @Column(name = "CHIEF_COMPLAINT", columnDefinition = "VARCHAR2|主诉||", length = 100, nullable = true)
    private String chiefComplaint;

    @Column(name = "CONSULTATION_QUESTION", columnDefinition = "VARCHAR2|咨询问题||", length = 200, nullable = true)
    private String consultationQuestion;

    @Column(name = "HEALTH_SERVICES_REQUIRES", columnDefinition = "VARCHAR2|卫生服务要求||", length = 200, nullable = true)
    private String healthServicesRequires;

    @Column(name = "PATHOGENESIS_DATE", columnDefinition = "TIMESTAMP|发病日期时间||", nullable = true)
    private Date pathogenesisDate;

    @Column(name = "OTHER_MEDICAL_TREATMENT", columnDefinition = "VARCHAR2|其他医学处置||", length = 200, nullable = true)
    private String otherMedicalTreatment;

    @Column(name = "MEDICAL_COST_PAY_WAY", columnDefinition = "VARCHAR2|医疗费用支付方式代码||", length = 2, nullable = true)
    private String medicalCostPayWay;

    @Column(name = "OUTPATIENT_COST_ACCOUNTS_WAY", columnDefinition = "VARCHAR2|医疗费用结算方式代码||", length = 2, nullable = true)
    private String outpatientCostAccountsWay;

    @Column(name = "OUTPATIENT_COST_TYPE_CODE", columnDefinition = "VARCHAR2|费用类别代码||", length = 2, nullable = true)
    private String outpatientCostTypeCode;

    @Column(name = "OUTPATIENT_COST_TYPE_NAME", columnDefinition = "VARCHAR2|费用分类名称||", length = 20, nullable = true)
    private String outpatientCostTypeName;

    @Column(name = "OUTPATIENT_COST_SUM", columnDefinition = "NUMBER|总费用||", scale = 8, precision = 2, nullable = true)
    private BigDecimal outpatientCostSum;

    @Column(name = "PERSONAL_EXPENSES", columnDefinition = "NUMBER|个人承担费用(元)||", scale = 10, precision = 2, nullable = true)
    private BigDecimal personalExpenses;

    @Column(name = "MEDICAL_INSURANCE_COST_SUM", columnDefinition = "NUMBER|医疗保险金额(元)||", scale = 8, precision = 2, nullable = true)
    private BigDecimal medicalInsuranceCostSum;

    @Column(name = "OTHER_SUBSIDIES_COST_SUM", columnDefinition = "NUMBER|其他补助金额(元)||", scale = 8, precision = 2, nullable = true)
    private BigDecimal otherSubsidiesCostSum;

    @Column(name = "MANA_DOCTOR_NO", columnDefinition = "VARCHAR2|责任医师工号||", length = 18, nullable = true)
    private String manaDoctorNo;

    @Column(name = "MANA_DOCTOR_NAME", columnDefinition = "VARCHAR2|责任医师姓名||", length = 50, nullable = true)
    private String manaDoctorName;

    @Column(name = "MANA_DOCTOR_IDCARD", columnDefinition = "VARCHAR2|责任医师身份证号||", length = 18, nullable = true)
    private String manaDoctorIdCard;

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
    
    @Column(name = "OUTPATIENT_TYPE", columnDefinition = "NUMBER||门诊类型", length = 1, nullable = true)
    private Integer outpatientType;
    
    @Column(name = "MAIN_SYMPTOMS", columnDefinition = "VARCHAR2||主要症状代码组合", length = 400, nullable = true)
    private String mainSymptoms;
    
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";
	
    @Column(name = "IS_LIMIT", columnDefinition = "NUMBER|是否限制||", length = 1, nullable = true)
    private Integer isLimit = -1;
    
    @Column(name = "OBSERVED_PATIENT_FLAG", columnDefinition = "VARCHAR2|留观标志-0：未留观，1：留观||", length = 1, nullable = true)
	private String observedPatientFlag;
    
    @Column(name = "PRESCRIPTION_COUNT", columnDefinition = "NUMBER||门诊包含处方数", length = 5, nullable = true)
    private Integer prescriptionCount;

    @Column(name = "PRESCRIPTION_ROUTE_COUNT", columnDefinition = "NUMBER||门诊包含静滴处方数", length = 5, nullable = true)
    private Integer prescription_route_count;
    
	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;
    
	@Transient
	private String clinicDateDesc;
    
    @Transient
    private String conclusionDesc;
    
    @Transient
    private String checkDesc;
    
    @Transient
    private String authorOrganization;
    
    @Transient
    private String opEmMark;
    
    @Transient
    private String outpatientName;
    
    @Transient
    private String pastHistory;

    @Transient
    private String idcard;

    @Column(name = "VISIT_STATUS", columnDefinition = "NUMBER||就诊状态", length = 1, nullable = true)
    private Integer visitStatus;    

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getHealthfileNo() {
        return this.healthfileNo;
    }

    public void setHealthfileNo(String healthfileNo) {
        this.healthfileNo = healthfileNo;
    }

    public String getClinicRecordNo() {
        return this.clinicRecordNo;
    }

    public void setClinicRecordNo(String clinicRecordNo) {
        this.clinicRecordNo = clinicRecordNo;
    }

    public String getReportCardTypeCode() {
        return this.reportCardTypeCode;
    }

    public void setReportCardTypeCode(String reportCardTypeCode) {
        this.reportCardTypeCode = reportCardTypeCode;
    }

    public String getRecordNumber() {
        return this.recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public String getClinicOrganCode() {
        return this.clinicOrganCode;
    }

    public void setClinicOrganCode(String clinicOrganCode) {
        this.clinicOrganCode = clinicOrganCode;
    }

    public String getClinicOrganName() {
        return this.clinicOrganName;
    }

    public void setClinicOrganName(String clinicOrganName) {
        this.clinicOrganName = clinicOrganName;
    }

    public String getMedicalRoomCode() {
        return this.medicalRoomCode;
    }

    public void setMedicalRoomCode(String medicalRoomCode) {
        this.medicalRoomCode = medicalRoomCode;
    }

    public String getMedicalRoomName() {
        return this.medicalRoomName;
    }

    public void setMedicalRoomName(String medicalRoomName) {
        this.medicalRoomName = medicalRoomName;
    }

    public Date getClinicDate() {
        return this.clinicDate;
    }

    public void setClinicDate(Date clinicDate) {
        this.clinicDate = clinicDate;
    }

    public String getClinicPeopleName() {
        return this.clinicPeopleName;
    }

    public void setClinicPeopleName(String clinicPeopleName) {
        this.clinicPeopleName = clinicPeopleName;
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

    public String getChiefComplaint() {
        return this.chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }

    public String getConsultationQuestion() {
        return this.consultationQuestion;
    }

    public void setConsultationQuestion(String consultationQuestion) {
        this.consultationQuestion = consultationQuestion;
    }

    public String getHealthServicesRequires() {
        return this.healthServicesRequires;
    }

    public void setHealthServicesRequires(String healthServicesRequires) {
        this.healthServicesRequires = healthServicesRequires;
    }

    public Date getPathogenesisDate() {
        return this.pathogenesisDate;
    }

    public void setPathogenesisDate(Date pathogenesisDate) {
        this.pathogenesisDate = pathogenesisDate;
    }

    public String getOtherMedicalTreatment() {
        return this.otherMedicalTreatment;
    }

    public void setOtherMedicalTreatment(String otherMedicalTreatment) {
        this.otherMedicalTreatment = otherMedicalTreatment;
    }

    public String getMedicalCostPayWay() {
        return this.medicalCostPayWay;
    }

    public void setMedicalCostPayWay(String medicalCostPayWay) {
        this.medicalCostPayWay = medicalCostPayWay;
    }

    public String getOutpatientCostAccountsWay() {
        return this.outpatientCostAccountsWay;
    }

    public void setOutpatientCostAccountsWay(String outpatientCostAccountsWay) {
        this.outpatientCostAccountsWay = outpatientCostAccountsWay;
    }

    public String getOutpatientCostTypeCode() {
        return this.outpatientCostTypeCode;
    }

    public void setOutpatientCostTypeCode(String outpatientCostTypeCode) {
        this.outpatientCostTypeCode = outpatientCostTypeCode;
    }

    public String getOutpatientCostTypeName() {
        return this.outpatientCostTypeName;
    }

    public void setOutpatientCostTypeName(String outpatientCostTypeName) {
        this.outpatientCostTypeName = outpatientCostTypeName;
    }

    public BigDecimal getOutpatientCostSum() {
        return this.outpatientCostSum;
    }

    public void setOutpatientCostSum(BigDecimal outpatientCostSum) {
        this.outpatientCostSum = outpatientCostSum;
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

    public String getManaDoctorNo() {
        return this.manaDoctorNo;
    }

    public void setManaDoctorNo(String manaDoctorNo) {
        this.manaDoctorNo = manaDoctorNo;
    }

    public String getManaDoctorName() {
        return this.manaDoctorName;
    }

    public void setManaDoctorName(String manaDoctorName) {
        this.manaDoctorName = manaDoctorName;
    }

    public String getManaDoctorIdCard() {
        return this.manaDoctorIdCard;
    }

    public void setManaDoctorIdCard(String manaDoctorIdCard) {
        this.manaDoctorIdCard = manaDoctorIdCard;
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


    public String getEhrId() {
        return ehrId;
    }

    public void setEhrId(String ehrId) {
        this.ehrId = ehrId;
    }


    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

	
	public Integer getOutpatientType() {
		return outpatientType;
	}

	
	public void setOutpatientType(Integer outpatientType) {
		this.outpatientType = outpatientType;
	}

	
	public String getOutpatientNo() {
		return outpatientNo;
	}

	
	public void setOutpatientNo(String outpatientNo) {
		this.outpatientNo = outpatientNo;
	}

	public String getMainSymptoms() {
		return mainSymptoms;
	}

	public void setMainSymptoms(String mainSymptoms) {
		this.mainSymptoms = mainSymptoms;
	}

	
	public String getConclusionDesc() {
		return conclusionDesc;
	}

	
	public void setConclusionDesc(String conclusionDesc) {
		this.conclusionDesc = conclusionDesc;
	}

	
	public String getCheckDesc() {
		return checkDesc;
	}

	
	public void setCheckDesc(String checkDesc) {
		this.checkDesc = checkDesc;
	}

	
	public String getAuthorOrganization() {
		return authorOrganization;
	}

	
	public void setAuthorOrganization(String authorOrganization) {
		this.authorOrganization = authorOrganization;
	}

	
	public String getOpEmMark() {
		if (StringUtils.contains(medicalRoomName, "急诊")) {
			this.opEmMark = "2";
		} else {
			this.opEmMark = "1";
		}
		return opEmMark;
	}

	
	public void setOpEmMark(String opEmMark) {
		this.opEmMark = opEmMark;
	}

	
	public String getOutpatientName() {
		if (StringUtils.contains(medicalRoomName, "急诊")) {
			this.outpatientName = "急诊病历记录";
		} else {
			this.outpatientName = "门诊病历记录";
		}
		return outpatientName;
	}

	
	public void setOutpatientName(String outpatientName) {
		this.outpatientName = outpatientName;
	}

	
	public String getProcessStatus() {
		return processStatus;
	}

	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	
	public String getClinicDateDesc() {
		return clinicDateDesc;
	}

	
	public void setClinicDateDesc(String clinicDateDesc) {
		this.clinicDateDesc = clinicDateDesc;
	}

	public Integer getVisitStatus() {
		return visitStatus;
	}

	public void setVisitStatus(Integer visitStatus) {
		this.visitStatus = visitStatus;
	}

	
	public Integer getIsLimit() {
		return isLimit;
	}

	
	public void setIsLimit(Integer isLimit) {
		this.isLimit = isLimit;
	}

	public String getObservedPatientFlag() {
		return observedPatientFlag;
	}

	public void setObservedPatientFlag(String observedPatientFlag) {
		this.observedPatientFlag = observedPatientFlag;
	}

	public Integer getPrescriptionCount() {
		return prescriptionCount;
	}

	public void setPrescriptionCount(Integer prescriptionCount) {
		this.prescriptionCount = prescriptionCount;
	}

	public Integer getPrescription_route_count() {
		return prescription_route_count;
	}

	public void setPrescription_route_count(Integer prescription_route_count) {
		this.prescription_route_count = prescription_route_count;
	}

	
	public String getPastHistory() {
		return pastHistory;
	}

	
	public void setPastHistory(String pastHistory) {
		this.pastHistory = pastHistory;
	}

	public Date getGatherDate() {
		return gatherDate;
	}

	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
	}

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
}
