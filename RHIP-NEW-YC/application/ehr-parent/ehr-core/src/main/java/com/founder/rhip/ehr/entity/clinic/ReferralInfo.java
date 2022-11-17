package com.founder.rhip.ehr.entity.clinic;

import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.common.JaxbDateSerializer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "MS_REFERRAL_INFO")
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReferralInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @XmlTransient
    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;

    @XmlTransient
    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @XmlTransient
    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
    private String ehrId;

    @XmlTransient
    @Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号||", length = 17, nullable = true)
    private String healthFileNo;

    @XmlTransient
    @Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|记录表单编号||", length = 20, nullable = true)
    private String recordNumber;

    @XmlTransient
    @Column(name = "MEDICAL_RECORD_NO", columnDefinition = "VARCHAR2|病案号||", length = 18, nullable = true)
    private String medicalRecordNo;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
    private String name;

    @XmlTransient
    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
    private String gender;

    @XmlTransient
    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况||", length = 3, nullable = true)
    private String marriage;

    @XmlTransient
    @Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
    private Date birthday;

    @Column(name = "PATIENT_PHONE", columnDefinition = "VARCHAR2|转诊患者电话号码||", length = 20, nullable = true)
    private String patientPhone;

    @XmlTransient
    @Column(name = "FAPROVINCE", columnDefinition = "VARCHAR2|家庭地址-省(自治区、直辖市)||", length = 70, nullable = true)
    private String faprovince;

    @XmlTransient
    @Column(name = "FACITY", columnDefinition = "VARCHAR2|家庭地址-市(地区、州)||", length = 70, nullable = true)
    private String facity;

    @XmlTransient
    @Column(name = "FACOUNTY", columnDefinition = "VARCHAR2|家庭地址-县(区)||", length = 70, nullable = true)
    private String facounty;

    @XmlTransient
    @Column(name = "FATOWN_SHIP", columnDefinition = "VARCHAR2|家庭地址-乡(镇、街道办事处)||", length = 70, nullable = true)
    private String fatownShip;

    @XmlTransient
    @Column(name = "FASTREET", columnDefinition = "VARCHAR2|家庭地址-村(街、路、弄等)||", length = 70, nullable = true)
    private String fastreet;

    @XmlTransient
    @Column(name = "FAHOUSE_NUMBER", columnDefinition = "VARCHAR2|家庭地址-门牌号码||", length = 70, nullable = true)
    private String fahouseNumber;

    @Column(name = "REFERRAL_TYPE", columnDefinition = "VARCHAR2|转诊类型||", length = 1, nullable = true)
    private String referralType;

    @Column(name = "DEST_DEPT_CODE", columnDefinition = "VARCHAR2|转出医疗机构代码||", length = 10, nullable = true)
    private String destDeptCode;

    @Column(name = "DEST_DEPT_NAME", columnDefinition = "VARCHAR2|转出医疗机构名称||", length = 70, nullable = true)
    private String destDeptName;

    @Column(name = "DEST_ROOM_CODE", columnDefinition = "VARCHAR2|转出医疗机构科室代码||", length = 5, nullable = true)
    private String destRoomCode;

    @Column(name = "DEST_ROOM_NAME", columnDefinition = "VARCHAR2|转出医疗机构科室名称||", length = 50, nullable = true)
    private String destRoomName;

    @Column(name = "REFERRAL_HOSPITAL_CODE", columnDefinition = "VARCHAR2|转入医疗机构代码||", length = 10, nullable = true)
    private String referralHospitalCode;

    @Column(name = "REFERRAL_HOSPITAL_NAME", columnDefinition = "VARCHAR2|转入医疗机构名称||", length = 70, nullable = true)
    private String referralHospitalName;

    @Column(name = "REFERRAL_DEPT_CODE", columnDefinition = "VARCHAR2|转入医疗机构科室代码||", length = 5, nullable = true)
    private String referralDeptCode;

    @Column(name = "REFERRAL_DEPT_NAME", columnDefinition = "VARCHAR2|转入医疗机构科室名称||", length = 50, nullable = true)
    private String referralDeptName;

    @Column(name = "REFERRAL_RECORD_DETAIL_DESC", columnDefinition = "VARCHAR2|转诊记录详细描述||", length = 100, nullable = true)
    private String referralRecordDetailDesc;

    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    @Column(name = "REFERRAL_DATE", columnDefinition = "DATE|转诊日期||", nullable = true)
    private Date referralDate;

    @Column(name = "REFERRAL_REASON", columnDefinition = "VARCHAR2|转诊原因||", length = 100, nullable = true)
    private String referralReason;

    @Column(name = "TREATMENT_PLAN", columnDefinition = "VARCHAR2|治疗方案||", length = 200, nullable = true)
    private String treatmentPlan;

    @Column(name = "REHABILITATION_GUIDE", columnDefinition = "VARCHAR2|康复措施指导||", length = 100, nullable = true)
    private String rehabilitationGuide;

    @Column(name = "RESERVE_CODE", columnDefinition = "VARCHAR2|预约编号||", length = 10, nullable = true)
    private String reserveCode;

    @Column(name = "RESERVE_DOCTOR_NAME", columnDefinition = "VARCHAR2|预约医生姓名||", length = 50, nullable = true)
    private String reserveDoctorName;

    @Column(name = "RESERVE_DATE", columnDefinition = "DATE|预约日期||", nullable = true)
    private Date reserveDate;

    @Column(name = "DIAGNOSE_DOCTOR_CODE", columnDefinition = "VARCHAR2|责任医生工号||", length = 18, nullable = true)
    private String diagnoseDoctorCode;

    @Column(name = "OPERATION_DOCTOR_NAME", columnDefinition = "VARCHAR2|责任医生姓名||", length = 50, nullable = true)
    private String operationDoctorName;

    @Column(name = "DIAGNOSE_DOCTOR_IDCARD", columnDefinition = "VARCHAR2|责任医生身份证||", length = 18, nullable = true)
    private String diagnoseDoctorIdCard;

    @Column(name = "REFERRAL_DOCTOR_NAME", columnDefinition = "VARCHAR2|转诊医师姓名||", length = 50, nullable = true)
    private String referralDoctorName;

    @Column(name = "REFERRAL_DOCTOR_PHONE", columnDefinition = "VARCHAR2|转诊医师电话号码||", length = 20, nullable = true)
    private String referralDoctorPhone;

    @Column(name = "REFERRAL_DOCTOR_IDCARD", columnDefinition = "VARCHAR2|转诊医师身份证||", length = 18, nullable = true)
    private String referralDoctorIdCard;

    @Column(name = "RECEPTION_DOCTOR_CODE", columnDefinition = "VARCHAR2|接诊医师姓名工号||", length = 18, nullable = true)
    private String receptionDoctorCode;

    @Column(name = "RECEPTION_DOCTOR_NAME", columnDefinition = "VARCHAR2|接诊医师姓名||", length = 50, nullable = true)
    private String receptionDoctorName;

    @Column(name = "RECEPTION_DOCTOR_IDCARD", columnDefinition = "VARCHAR2|接诊医师姓名身份证||", length = 18, nullable = true)
    private String receptionDoctorIdCard;

    @XmlTransient
    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

	@Column(name = "PRIMARY_DIAGNOSIS", columnDefinition = "VARCHAR2|初步印象||", length = 200, nullable = true)
	private String primaryDiagnosis;

	@Column(name = "MEDICAL_HISTORY", columnDefinition = "VARCHAR2|主要既往史||", length = 200, nullable = true)
	private String medicalHistory;

	@Column(name = "TREATMENT", columnDefinition = "VARCHAR2|治疗经过||", length = 200, nullable = true)
	private String treatment;

	@Column(name = "DIAGNOSIS", columnDefinition = "VARCHAR2|诊断结果||", length = 100, nullable = true)
	private String diagnosis;

	@Column(name = "CHECK_RESULT", columnDefinition = "VARCHAR2|检查结果||", length = 200, nullable = true)
	private String checkResult;

	@XmlTransient
	@Column(name = "INTEGRATED_DATA", columnDefinition = "VARCHAR2|是否集成数据||", length = 1, nullable = true)
	private Integer integratedData;

	@Column(name = "DUAL_REFERRAL_TYPE", columnDefinition = "VARCHAR2|双向转诊类型||", length = 1, nullable = true)
	private String dualReferralType;

	@Column(name = "ID_CARD", columnDefinition = "VARCHAR2|病人身份证||", length = 18, nullable = true)
	private String idCard;

	@XmlTransient
	@Column(name = "UPDATE_PERSON", columnDefinition = "VARCHAR2|更新人||", length = 200, nullable = true)
	private String updatePerson;

	@XmlTransient
	@Column(name = "UPDATE_ORGAN", columnDefinition = "VARCHAR2|更新机构||", length = 200, nullable = true)
	private String updateOrgan;
	
	@XmlTransient
	@Column(name = "UPDATE_TIME", columnDefinition = "VARCHAR2|更新时间||", length = 200, nullable = true)
	private Date updateTime;
	
	@XmlTransient
    @Column(name = "IS_LIMIT", columnDefinition = "NUMBER|是否限制||", length = 1, nullable = true)
    private Integer isLimit = -1;
    
	@XmlTransient
	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;

    @Column(name = "REFERRAL_CODE", columnDefinition = "VARCHAR2|转诊唯一吗||", nullable = true)
    private String referralCode;

    @Column(name = "REFUSE_REASON", columnDefinition = "VARCHAR2|拒接原因||", nullable = true)
    private String refuseReason;

    // 1: APP  2:平台  3:医院
    @Column(name = "REFERRAL_SOURCE", columnDefinition = "NUMBER|转诊来源||", nullable = true)
    private Integer referralSource;

    // 0:未接收  1:已接受  2:拒绝接收
    @Column(name = "REFERRAL_STATUS", columnDefinition = "VARCHAR2|转诊状态||", nullable = true)
    private Integer referralStatus;

    @Column(name = "FA_GROUP", columnDefinition = "VARCHAR2|现住址小组地址||", length = 30, nullable = true)
    private String faGroup;

    @Column(name = "AGE", columnDefinition = "NUMBER|年龄||", length = 30, nullable = true)
    private int age;

    public String getFaGroup() {
        return faGroup;
    }

    public void setFaGroup(String faGroup) {
        this.faGroup = faGroup;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    public Integer getReferralSource() {
        return referralSource;
    }

    public void setReferralSource(Integer referralSource) {
        this.referralSource = referralSource;
    }

    public Integer getReferralStatus() {
        return referralStatus;
    }

    public void setReferralStatus(Integer referralStatus) {
        this.referralStatus = referralStatus;
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

    public String getHealthFileNo() {
        return this.healthFileNo;
    }

    public void setHealthFileNo(String healthFileNo) {
        this.healthFileNo = healthFileNo;
    }

    public String getRecordNumber() {
        return this.recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public String getMedicalRecordNo() {
        return this.medicalRecordNo;
    }

    public void setMedicalRecordNo(String medicalRecordNo) {
        this.medicalRecordNo = medicalRecordNo;
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

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

	public Integer getAge() {
		return this.age;
	}

    public String getPatientPhone() {
        return this.patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getFaprovince() {
        return this.faprovince;
    }

    public void setFaprovince(String faprovince) {
        this.faprovince = faprovince;
    }

    public String getFacity() {
        return this.facity;
    }

    public void setFacity(String facity) {
        this.facity = facity;
    }

    public String getFacounty() {
        return this.facounty;
    }

    public void setFacounty(String facounty) {
        this.facounty = facounty;
    }

    public String getFatownShip() {
        return this.fatownShip;
    }

    public void setFatownShip(String fatownShip) {
        this.fatownShip = fatownShip;
    }

    public String getFastreet() {
        return this.fastreet;
    }

    public void setFastreet(String fastreet) {
        this.fastreet = fastreet;
    }

    public String getFahouseNumber() {
        return this.fahouseNumber;
    }

    public void setFahouseNumber(String fahouseNumber) {
        this.fahouseNumber = fahouseNumber;
    }

    public String getReferralType() {
        return this.referralType;
    }

    public void setReferralType(String referralType) {
        this.referralType = referralType;
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

    public String getReferralRecordDetailDesc() {
        return this.referralRecordDetailDesc;
    }

    public void setReferralRecordDetailDesc(String referralRecordDetailDesc) {
        this.referralRecordDetailDesc = referralRecordDetailDesc;
    }

    public Date getReferralDate() {
        return this.referralDate;
    }

    public void setReferralDate(Date referralDate) {
        this.referralDate = referralDate;
    }

    public String getReferralReason() {
        return this.referralReason;
    }

    public void setReferralReason(String referralReason) {
        this.referralReason = referralReason;
    }

    public String getTreatmentPlan() {
        return this.treatmentPlan;
    }

    public void setTreatmentPlan(String treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    public String getRehabilitationGuide() {
        return this.rehabilitationGuide;
    }

    public void setRehabilitationGuide(String rehabilitationGuide) {
        this.rehabilitationGuide = rehabilitationGuide;
    }

    public String getReserveCode() {
        return this.reserveCode;
    }

    public void setReserveCode(String reserveCode) {
        this.reserveCode = reserveCode;
    }

    public String getReserveDoctorName() {
        return this.reserveDoctorName;
    }

    public void setReserveDoctorName(String reserveDoctorName) {
        this.reserveDoctorName = reserveDoctorName;
    }

    public Date getReserveDate() {
        return this.reserveDate;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    public String getDiagnoseDoctorCode() {
        return this.diagnoseDoctorCode;
    }

    public void setDiagnoseDoctorCode(String diagnoseDoctorCode) {
        this.diagnoseDoctorCode = diagnoseDoctorCode;
    }

    public String getOperationDoctorName() {
        return this.operationDoctorName;
    }

    public void setOperationDoctorName(String operationDoctorName) {
        this.operationDoctorName = operationDoctorName;
    }

    public String getDiagnoseDoctorIdCard() {
        return this.diagnoseDoctorIdCard;
    }

    public void setDiagnoseDoctorIdCard(String diagnoseDoctorIdCard) {
        this.diagnoseDoctorIdCard = diagnoseDoctorIdCard;
    }

    public String getReferralDoctorName() {
        return this.referralDoctorName;
    }

    public void setReferralDoctorName(String referralDoctorName) {
        this.referralDoctorName = referralDoctorName;
    }

    public String getReferralDoctorPhone() {
        return this.referralDoctorPhone;
    }

    public void setReferralDoctorPhone(String referralDoctorPhone) {
        this.referralDoctorPhone = referralDoctorPhone;
    }

    public String getReferralDoctorIdCard() {
        return this.referralDoctorIdCard;
    }

    public void setReferralDoctorIdCard(String referralDoctorIdCard) {
        this.referralDoctorIdCard = referralDoctorIdCard;
    }

    public String getReceptionDoctorCode() {
        return this.receptionDoctorCode;
    }

    public void setReceptionDoctorCode(String receptionDoctorCode) {
        this.receptionDoctorCode = receptionDoctorCode;
    }

    public String getReceptionDoctorName() {
        return this.receptionDoctorName;
    }

    public void setReceptionDoctorName(String receptionDoctorName) {
        this.receptionDoctorName = receptionDoctorName;
    }

    public String getReceptionDoctorIdCard() {
        return this.receptionDoctorIdCard;
    }

    public void setReceptionDoctorIdCard(String receptionDoctorIdCard) {
        this.receptionDoctorIdCard = receptionDoctorIdCard;
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

	public Integer getDelete() {
		return isDelete;
	}

	public void setDelete(Integer delete) {
		isDelete = delete;
	}

	public String getPrimaryDiagnosis() {
		return primaryDiagnosis;
	}

	public void setPrimaryDiagnosis(String primaryDiagnosis) {
		this.primaryDiagnosis = primaryDiagnosis;
	}

	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	public Integer getIntegratedData() {
		return integratedData;
	}

	public void setIntegratedData(Integer integratedData) {
		this.integratedData = integratedData;
	}

	public String getDualReferralType() {
		return dualReferralType;
	}

	public void setDualReferralType(String dualReferralType) {
		this.dualReferralType = dualReferralType;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getUpdatePerson() {
		return updatePerson;
	}

	public void setUpdatePerson(String updatePerson) {
		this.updatePerson = updatePerson;
	}

	public String getUpdateOrgan() {
		return updateOrgan;
	}

	public void setUpdateOrgan(String updateOrgan) {
		this.updateOrgan = updateOrgan;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	
	public Integer getIsLimit() {
		return isLimit;
	}

	
	public void setIsLimit(Integer isLimit) {
		this.isLimit = isLimit;
	}

	public Date getGatherDate() {
		return gatherDate;
	}

	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
	}

	
	
	
	
}
