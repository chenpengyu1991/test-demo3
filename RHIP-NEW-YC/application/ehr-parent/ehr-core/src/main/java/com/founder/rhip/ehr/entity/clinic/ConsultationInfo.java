package com.founder.rhip.ehr.entity.clinic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "MS_CONSULTATION_INFO")
public class ConsultationInfo implements Serializable {

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

    @Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号||", length = 17, nullable = true)
    private String healthFileNo;

    @Column(name = "CONSULTATION_RECORD_CODE", columnDefinition = "VARCHAR2|会诊记录编号||", length = 20, nullable = true)
    private String consultationRecordCode;

    @Column(name = "CONSULTATION_ORG_CODE", columnDefinition = "VARCHAR2|会诊所在医疗卫生机构代码||", length = 10, nullable = true)
    private String consultationOrgCode;

    @Column(name = "CONSULTATION_ORG_NAME", columnDefinition = "VARCHAR2|会诊所在医疗卫生机构名称||", length = 70, nullable = true)
    private String consultationOrgName;

    @Column(name = "CONSULTATION_COURSE", columnDefinition = "VARCHAR2|会诊原因||", length = 200, nullable = true)
    private String consultationCourse;

    @Column(name = "CONSULTATION_SUGGESTION", columnDefinition = "VARCHAR2|会诊意见||", length = 200, nullable = true)
    private String consultationSuggestion;

    @Column(name = "CONSULTATION_DAE", columnDefinition = "DATE|会诊日期||", nullable = true)
    private Date consultationDae;

    @Column(name = "CONSULTATION_DOCTOR_NAME", columnDefinition = "VARCHAR2|会诊医师姓名||", length = 50, nullable = true)
    private String consultationDoctorName;

    @Column(name = "DIAGNOSE_DOCTOR_CODE", columnDefinition = "VARCHAR2|责任医生工号||", length = 18, nullable = true)
    private String diagnoseDoctorCode;

    @Column(name = "MANA_DOCTOR_NAME", columnDefinition = "VARCHAR2|责任医师姓名||", length = 50, nullable = true)
    private String manaDoctorName;

    @Column(name = "MANA_DOCTOR_IDCARD", columnDefinition = "VARCHAR2|责任医生身份证号||", length = 18, nullable = true)
    private String manaDoctorIdCard;

    @Column(name = "INPUT_CODE", columnDefinition = "VARCHAR2|建档人工号||", length = 18, nullable = true)
    private String inputCode;

    @Column(name = "INPUT_NAME", columnDefinition = "VARCHAR2|建档人姓名||", length = 50, nullable = true)
    private String inputName;

    @Column(name = "INPUT_IDCARD", columnDefinition = "VARCHAR2|建档人身份证号||", length = 18, nullable = true)
    private String inputIdcard;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;
    
    @Column(name = "IS_LIMIT", columnDefinition = "NUMBER|是否限制||", length = 1, nullable = true)
    private Integer isLimit = -1;
    
	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;

	@Transient
	private String idCard;
	
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

    public String getHealthFileNo() {
        return this.healthFileNo;
    }

    public void setHealthFileNo(String healthFileNo) {
        this.healthFileNo = healthFileNo;
    }

    public String getConsultationRecordCode() {
        return this.consultationRecordCode;
    }

    public void setConsultationRecordCode(String consultationRecordCode) {
        this.consultationRecordCode = consultationRecordCode;
    }

    public String getConsultationOrgCode() {
        return this.consultationOrgCode;
    }

    public void setConsultationOrgCode(String consultationOrgCode) {
        this.consultationOrgCode = consultationOrgCode;
    }

    public String getConsultationOrgName() {
        return this.consultationOrgName;
    }

    public void setConsultationOrgName(String consultationOrgName) {
        this.consultationOrgName = consultationOrgName;
    }

    public String getConsultationCourse() {
        return this.consultationCourse;
    }

    public void setConsultationCourse(String consultationCourse) {
        this.consultationCourse = consultationCourse;
    }

    public String getConsultationSuggestion() {
        return this.consultationSuggestion;
    }

    public void setConsultationSuggestion(String consultationSuggestion) {
        this.consultationSuggestion = consultationSuggestion;
    }

    public Date getConsultationDae() {
        return this.consultationDae;
    }

    public void setConsultationDae(Date consultationDae) {
        this.consultationDae = consultationDae;
    }

    public String getConsultationDoctorName() {
        return this.consultationDoctorName;
    }

    public void setConsultationDoctorName(String consultationDoctorName) {
        this.consultationDoctorName = consultationDoctorName;
    }

    public String getDiagnoseDoctorCode() {
        return this.diagnoseDoctorCode;
    }

    public void setDiagnoseDoctorCode(String diagnoseDoctorCode) {
        this.diagnoseDoctorCode = diagnoseDoctorCode;
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

    public String getInputCode() {
        return this.inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode;
    }

    public String getInputName() {
        return this.inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getInputIdcard() {
        return this.inputIdcard;
    }

    public void setInputIdcard(String inputIdcard) {
        this.inputIdcard = inputIdcard;
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

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	
	
    
}
