package com.founder.rhip.ehr.entity.clinic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "MS_OUTHOSPITAL_SUMMARY")
public class OuthospitalSummary implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
    private String ehrId;

    @Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|记录表编号||", length = 20, nullable = true)
    private String recordNumber;

    @Column(name = "ADMISSION_NO", columnDefinition = "VARCHAR2|住院号||", length = 10, nullable = true)
    private String admissionNo;

    @Column(name = "MEDICAL_RECORD_NO", columnDefinition = "VARCHAR2|病案号||", length = 18, nullable = true)
    private String medicalRecordNo;

    @Column(name = "IDCARD_HOS", columnDefinition = "VARCHAR2|医保卡号||", length = 30, nullable = true)
    private String idcardHos;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
    private String name;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
    private String gender;

    @Column(name = "AGE", columnDefinition = "VARCHAR2|年龄||", length = 20, nullable = true)
    private String age;

    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况||", length = 3, nullable = true)
    private String marriage;

    @Column(name = "OCCUPATION", columnDefinition = "VARCHAR2|职业类别代码||", length = 8, nullable = true)
    private String occupation;

    @Column(name = "OCCUPATION_NAME", columnDefinition = "VARCHAR2|职业名称||", length = 100, nullable = true)
    private String occupationName;

    @Column(name = "HOSPITAL_CODE", columnDefinition = "VARCHAR2|医疗机构代码||", length = 10, nullable = true)
    private String hospitalCode;

    @Column(name = "HOSPITAL_NAME", columnDefinition = "VARCHAR2|医疗机构名称||", length = 70, nullable = true)
    private String hospitalName;

    @Column(name = "DEPARTMENT_CODE", columnDefinition = "VARCHAR2|科室代码||", length = 5, nullable = true)
    private String departmentCode;

    @Column(name = "DEPARTMENT_NAME", columnDefinition = "VARCHAR2|科室名称||", length = 50, nullable = true)
    private String departmentName;

    @Column(name = "SICK_AREA_NAME", columnDefinition = "VARCHAR2|病区名称||", length = 50, nullable = true)
    private String sickAreaName;

    @Column(name = "SICKROOM_NO", columnDefinition = "VARCHAR2|病房号||", length = 5, nullable = true)
    private String sickroomNo;

    @Column(name = "SICKBED_NO", columnDefinition = "VARCHAR2|病床号||", length = 5, nullable = true)
    private String sickbedNo;

    @Column(name = "INHOS_DATE", columnDefinition = "TIMESTAMP|入院日期时间||", nullable = true)
    private Date inhosDate;

    @Column(name = "INHOS_CONDITION", columnDefinition = "VARCHAR2|住院患者入院病情||", length = 1, nullable = true)
    private String inhosCondition;

    @Column(name = "AE_RESULT", columnDefinition = "VARCHAR2|辅助检查结果||", length = 100, nullable = true)
    private String aeResult;

    @Column(name = "TREATMENT_PROCESS_DESC", columnDefinition = "VARCHAR2|诊疗过程描述||", length = 500, nullable = true)
    private String treatmentProcessDesc;

    @Column(name = "OUTHOS_STATE", columnDefinition = "VARCHAR2|出院情况||", length = 200, nullable = true)
    private String outhosState;

    @Column(name = "OUTHOS_SYMPTOM_BODY_FEATURE", columnDefinition = "VARCHAR2|出院时症状与体征||", length = 200, nullable = true)
    private String outHospitalSymptomBodyFeature;

    @Column(name = "OUTHOS_ADVICE", columnDefinition = "VARCHAR2|出院医嘱||", length = 200, nullable = true)
    private String outhosAdvice;

    @Column(name = "OUTHOS_DATE", columnDefinition = "DATE|出院日期||", nullable = true)
    private Date outhosDate;

    @Column(name = "ACTUAL_ADMISSION_DAY_TIMES", columnDefinition = "NUMBER|实际住院天数||", length = 5, nullable = true)
    private Integer actualAdmissionDayTimes;


    @Column(name = "INHOS_STATE", columnDefinition = "VARCHAR2|入院病情||", length = 1000, nullable = true)
    private String inhosState;

    @Column(name = "DOCTOR_SIGNATURE", columnDefinition = "VARCHAR2|医师签名||", length = 50, nullable = true)
    private String doctorSignature;

    @Column(name = "DOCTOR_SIGNATURE_DATE", columnDefinition = "TIMESTAMP|医师签名日期||", nullable = true)
    private Date doctorSignatureDate;

    @Column(name = "ATTENDING_DOCTOR_SIGNATURE", columnDefinition = "VARCHAR2|主治医师签名||", length = 50, nullable = true)
    private String attendingDoctorSignature;

    @Column(name = "ATTENDING_SIGNATURE_DATE", columnDefinition = "TIMESTAMP|主治医师签名日期||", nullable = true)
    private Date attendingSignatureDate;

    @Column(name = "SIGNATURE_DATE", columnDefinition = "TIMESTAMP|签名日期时间||", nullable = true)
    private Date signatureDate;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

    @Column(name = "ICD_CODE", columnDefinition = "VARCHAR2||", length = 10, nullable = true)
    private String icdCode;
    
	@Column(name = "OTHERCARDTYPE", columnDefinition = "VARCHAR2|其他就医卡证类型||", length = 2, nullable = true)
	private String othercardtype;

	@Column(name = "OTHERCARDNO", columnDefinition = "VARCHAR2|其他就医卡证号码||", length = 50, nullable = true)
	private String othercardno;

	@Column(name = "HP_S_NO", columnDefinition = "VARCHAR2|住院流水号||", length = 50, nullable = true)
	private String hpSNo;

	@Column(name = "WOUND_HEAL", columnDefinition = "VARCHAR2|切口愈合情况代码||", length = 2, nullable = true)
	private String woundHeal;

	@Column(name = "DPT_CODE", columnDefinition = "VARCHAR2|出院科室编码||", length = 2, nullable = true)
	private String dptCode;

	@Column(name = "RCD_DT", columnDefinition = "DATE|记录时间||", nullable = true)
	private Date rcdDt;

	@Column(name = "HP_CUR_PRO", columnDefinition = "VARCHAR2|住院治疗过程描述||", length = 800, nullable = true)
	private String hpCurPro;
	
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus;
	
    @Column(name = "IS_LIMIT", columnDefinition = "NUMBER|是否限制||", length = 1, nullable = true)
    private Integer isLimit = -1;
    
	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;
	
	@Transient
	private String outhosDateDesc;
	
	@Transient
	private String rcdDtDesc;

	@Transient
	private String outhosAdviceDesc;
	
    public String getOuthosAdviceDesc() {
		return outhosAdviceDesc;
	}

	public void setOuthosAdviceDesc(String outhosAdviceDesc) {
		this.outhosAdviceDesc = outhosAdviceDesc;
	}

	public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getRecordNumber() {
        return this.recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
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

    public String getIdcardHos() {
        return this.idcardHos;
    }

    public void setIdcardHos(String idcardHos) {
        this.idcardHos = idcardHos;
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

    public String getDepartmentCode() {
        return this.departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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

    public Date getInhosDate() {
        return this.inhosDate;
    }

    public void setInhosDate(Date inhosDate) {
        this.inhosDate = inhosDate;
    }

    public String getInhosCondition() {
        return this.inhosCondition;
    }

    public void setInhosCondition(String inhosCondition) {
        this.inhosCondition = inhosCondition;
    }

    public String getAeResult() {
        return this.aeResult;
    }

    public void setAeResult(String aeResult) {
        this.aeResult = aeResult;
    }

    public String getTreatmentProcessDesc() {
        return this.treatmentProcessDesc;
    }

    public void setTreatmentProcessDesc(String treatmentProcessDesc) {
        this.treatmentProcessDesc = treatmentProcessDesc;
    }


    public String getOutHospitalSymptomBodyFeature() {
        return this.outHospitalSymptomBodyFeature;
    }

    public void setOutHospitalSymptomBodyFeature(String outHospitalSymptomBodyFeature) {
        this.outHospitalSymptomBodyFeature = outHospitalSymptomBodyFeature;
    }

    public String getOuthosState() {
        return outhosState;
    }

    public void setOuthosState(String outhosState) {
        this.outhosState = outhosState;
    }

    public String getOuthosAdvice() {
        return outhosAdvice;
    }

    public void setOuthosAdvice(String outhosAdvice) {
        this.outhosAdvice = outhosAdvice;
    }

    public Date getOuthosDate() {
        return outhosDate;
    }

    public void setOuthosDate(Date outhosDate) {
        this.outhosDate = outhosDate;
    }

    public Integer getActualAdmissionDayTimes() {
        return this.actualAdmissionDayTimes;
    }

    public void setActualAdmissionDayTimes(Integer actualAdmissionDayTimes) {
        this.actualAdmissionDayTimes = actualAdmissionDayTimes;
    }


    public Date getSignatureDate() {
        return this.signatureDate;
    }

    public void setSignatureDate(Date signatureDate) {
        this.signatureDate = signatureDate;
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getOccupationName() {
        return occupationName;
    }

    public void setOccupationName(String occupationName) {
        this.occupationName = occupationName;
    }

    public String getInhosState() {
        return inhosState;
    }

    public void setInhosState(String inhosState) {
        this.inhosState = inhosState;
    }

    public String getDoctorSignature() {
        return doctorSignature;
    }

    public void setDoctorSignature(String doctorSignature) {
        this.doctorSignature = doctorSignature;
    }

    public Date getDoctorSignatureDate() {
        return doctorSignatureDate;
    }

    public void setDoctorSignatureDate(Date doctorSignatureDate) {
        this.doctorSignatureDate = doctorSignatureDate;
    }

    public String getAttendingDoctorSignature() {
        return attendingDoctorSignature;
    }

    public void setAttendingDoctorSignature(String attendingDoctorSignature) {
        this.attendingDoctorSignature = attendingDoctorSignature;
    }

	public Date getAttendingSignatureDate() {
		return attendingSignatureDate;
	}

	public void setAttendingSignatureDate(Date attendingSignatureDate) {
		this.attendingSignatureDate = attendingSignatureDate;
	}

	public String getAge() {
		return age;
	}

	
	public void setAge(String age) {
		this.age = age;
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

	public String getWoundHeal() {
		return woundHeal;
	}

	public void setWoundHeal(String woundHeal) {
		this.woundHeal = woundHeal;
	}

	public String getDptCode() {
		return dptCode;
	}

	public void setDptCode(String dptCode) {
		this.dptCode = dptCode;
	}

	public Date getRcdDt() {
		return rcdDt;
	}

	public void setRcdDt(Date rcdDt) {
		this.rcdDt = rcdDt;
	}

	public String getHpCurPro() {
		return hpCurPro;
	}

	public void setHpCurPro(String hpCurPro) {
		this.hpCurPro = hpCurPro;
	}

	
	public String getProcessStatus() {
		return processStatus;
	}

	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	
	public String getOuthosDateDesc() {
		return outhosDateDesc;
	}

	
	public void setOuthosDateDesc(String outhosDateDesc) {
		this.outhosDateDesc = outhosDateDesc;
	}

	
	public String getRcdDtDesc() {
		return rcdDtDesc;
	}

	
	public void setRcdDtDesc(String rcdDtDesc) {
		this.rcdDtDesc = rcdDtDesc;
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
