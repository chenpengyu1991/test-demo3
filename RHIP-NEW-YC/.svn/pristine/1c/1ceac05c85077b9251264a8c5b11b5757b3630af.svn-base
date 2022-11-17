package com.founder.rhip.ehr.entity.clinic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "OUT_TRANSFER")
public class OutTransfer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|唯一自增长编码|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "SERIAL_NUMBER", columnDefinition = "VARCHAR2|编号|20|", length = 20, nullable = true)
	private String serialNumber;

	@Column(name = "ICD_CODE", columnDefinition = "VARCHAR2|疾病编码ICD-10|20|", length = 20, nullable = true)
	private String icdCode;

	@Column(name = "ICD_NAME", columnDefinition = "VARCHAR2|疾病名称|200|", length = 200, nullable = true)
	private String icdName;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名|50|", length = 50, nullable = true)
	private String name;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别|1|", length = 1, nullable = true)
	private String gender;

	@Column(name = "BIRTHDATE", columnDefinition = "DATE|出生年月||", nullable = true)
	private Date birthdate;

	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证号|18|", length = 18, nullable = true)
	private String idcard;

	@Column(name = "OUT_NO", columnDefinition = "VARCHAR2|门诊号/住院号|20|", length = 20, nullable = true)
	private String outNo;

	@Column(name = "INSURANCE_NO", columnDefinition = "VARCHAR2|保险编号|100|", length = 100, nullable = true)
	private String insuranceNo;

	@Column(name = "DIAGNOSE", columnDefinition = "VARCHAR2|初步诊断|100|", length = 100, nullable = true)
	private String diagnose;

	@Column(name = "DOCTOR", columnDefinition = "VARCHAR2|诊治医师|50|", length = 50, nullable = true)
	private String doctor;

	@Column(name = "DIRECTOR", columnDefinition = "VARCHAR2|科主任|100|", length = 100, nullable = true)
	private String director;

	@Column(name = "SUMMARY", columnDefinition = "VARCHAR2|病情摘要|400|", length = 400, nullable = true)
	private String summary;

	@Column(name = "TRANSFER_DT", columnDefinition = "DATE|转出日期||", nullable = true)
	private Date transferDt;

	@Column(name = "FROM_ORGAN_CODE", columnDefinition = "VARCHAR2|转出医疗机构|100|", length = 100, nullable = true)
	private String fromOrganCode;

	@Column(name = "CREATE_TRANSFER_USER_CODE", columnDefinition = "VARCHAR2|转出操作人|50|", length = 50, nullable = true)
	private String createTransferUserCode;

	@Column(name = "CREATE_TRANSFER_USER", columnDefinition = "VARCHAR2|转出操作人|50|", length = 50, nullable = true)
	private String createTransferUser;

	@Column(name = "CREATE_TRANSFER_DT", columnDefinition = "DATE|转出操作日期||", nullable = true)
	private Date createTransferDt;

	@Column(name = "TO_ADDRESS", columnDefinition = "VARCHAR2|转入地点|100|", length = 100, nullable = true)
	private String toAddress;

	@Column(name = "TO_ORGAN_CODE", columnDefinition = "VARCHAR2|转入医疗机构|100|", length = 100, nullable = true)
	private String toOrganCode;

    @Column(name = "TO_ORGAN_OTHER", columnDefinition = "VARCHAR2|转入医疗机构其他|100|", length = 100, nullable = true)
    private String toOrganOther;

	@Column(name = "MEDICAL_DEPT_AUDIT", columnDefinition = "VARCHAR2|医务科审批|2|", length = 2, nullable = true)
	private String medicalDeptAudit;

	@Column(name = "MEDICAL_DEPT_OPINION", columnDefinition = "VARCHAR2|医务科意见|100|", length = 100, nullable = true)
	private String medicalDeptOpinion;

	@Column(name = "MEDICAL_DEPT_USER_CODE", columnDefinition = "VARCHAR2|医务科经办人code|50|", length = 50, nullable = true)
	private String medicalDeptUserCode;

	@Column(name = "MEDICAL_DEPT_DT", columnDefinition = "DATE|医务科经办日期||", nullable = true)
	private Date medicalDeptDt;

	@Column(name = "CENTER_AUDIT", columnDefinition = "VARCHAR2|合管中心审批|2|", length = 2, nullable = true)
	private String centerAudit;

	@Column(name = "CENTER_OPINION", columnDefinition = "VARCHAR2|合管中心意见|100|", length = 100, nullable = true)
	private String centerOpinion;

	@Column(name = "CENTER_USER", columnDefinition = "VARCHAR2|合管中心经办人|50|", length = 50, nullable = true)
	private String centerUser;

	@Column(name = "CENTER_DT", columnDefinition = "DATE|合管中心日期||", nullable = true)
	private Date centerDt;

	@Column(name = "IN_FROM_ORGAN_CODE", columnDefinition = "VARCHAR2|转出医疗机构内部编码|100|", length = 100, nullable = true)
	private String inFromOrganCode;

	@Column(name = "IN_TO_ORGAN_CODE", columnDefinition = "VARCHAR2|转入医疗机构内部编码（暂时和系统编码一致）|100|", length = 100, nullable = true)
	private String inToOrganCode;

    @Column(name = "PATIENT_TYPE", columnDefinition = "VARCHAR2|病人类型|2|", length = 2, nullable = true)
    private String patientType;

    @Column(name = "FROM_TYPE", columnDefinition = "VARCHAR2| 转出类型（0门诊；1住院）|2|", length = 2, nullable = true)
    private String fromType;

    @Column(name = "FROM_OFFICE_CODE", columnDefinition = "VARCHAR2|转出科室代码|100|", length = 100, nullable = true)
    private String fromOfficeCode;

    @Column(name = "FROM_OFFICE_NAME", columnDefinition = "VARCHAR2| 转出科室名称|100|", length = 100, nullable = true)
    private String fromOfficeName;

    @Column(name = "HG_CODE", columnDefinition = "VARCHAR2| 合管中心唯一编码|20|", length = 20, nullable = true)
    private String hgCode;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getIcdCode() {
		return this.icdCode;
	}

	public void setIcdCode(String icdCode) {
		this.icdCode = icdCode;
	}

	public String getIcdName() {
		return this.icdName;
	}

	public void setIcdName(String icdName) {
		this.icdName = icdName;
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

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getOutNo() {
		return this.outNo;
	}

	public void setOutNo(String outNo) {
		this.outNo = outNo;
	}

	public String getInsuranceNo() {
		return this.insuranceNo;
	}

	public void setInsuranceNo(String insuranceNo) {
		this.insuranceNo = insuranceNo;
	}

	public String getDiagnose() {
		return this.diagnose;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}

	public String getDoctor() {
		return this.doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getTransferDt() {
		return this.transferDt;
	}

	public void setTransferDt(Date transferDt) {
		this.transferDt = transferDt;
	}

	public String getFromOrganCode() {
		return this.fromOrganCode;
	}

	public void setFromOrganCode(String fromOrganCode) {
		this.fromOrganCode = fromOrganCode;
	}

	public String getCreateTransferUserCode() {
		return this.createTransferUserCode;
	}

	public void setCreateTransferUserCode(String createTransferUserCode) {
		this.createTransferUserCode = createTransferUserCode;
	}

	public String getCreateTransferUser() {
		return this.createTransferUser;
	}

	public void setCreateTransferUser(String createTransferUser) {
		this.createTransferUser = createTransferUser;
	}

	public Date getCreateTransferDt() {
		return this.createTransferDt;
	}

	public void setCreateTransferDt(Date createTransferDt) {
		this.createTransferDt = createTransferDt;
	}

	public String getToAddress() {
		return this.toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getToOrganCode() {
		return this.toOrganCode;
	}

	public void setToOrganCode(String toOrganCode) {
		this.toOrganCode = toOrganCode;
	}

	public String getMedicalDeptAudit() {
		return this.medicalDeptAudit;
	}

	public void setMedicalDeptAudit(String medicalDeptAudit) {
		this.medicalDeptAudit = medicalDeptAudit;
	}

	public String getMedicalDeptOpinion() {
		return this.medicalDeptOpinion;
	}

	public void setMedicalDeptOpinion(String medicalDeptOpinion) {
		this.medicalDeptOpinion = medicalDeptOpinion;
	}

	public String getMedicalDeptUserCode() {
		return this.medicalDeptUserCode;
	}

	public void setMedicalDeptUserCode(String medicalDeptUserCode) {
		this.medicalDeptUserCode = medicalDeptUserCode;
	}

	public Date getMedicalDeptDt() {
		return this.medicalDeptDt;
	}

	public void setMedicalDeptDt(Date medicalDeptDt) {
		this.medicalDeptDt = medicalDeptDt;
	}

	public String getCenterAudit() {
		return this.centerAudit;
	}

	public void setCenterAudit(String centerAudit) {
		this.centerAudit = centerAudit;
	}

	public String getCenterOpinion() {
		return this.centerOpinion;
	}

	public void setCenterOpinion(String centerOpinion) {
		this.centerOpinion = centerOpinion;
	}

	public String getCenterUser() {
		return this.centerUser;
	}

	public void setCenterUser(String centerUser) {
		this.centerUser = centerUser;
	}

	public Date getCenterDt() {
		return this.centerDt;
	}

	public void setCenterDt(Date centerDt) {
		this.centerDt = centerDt;
	}

	public String getInFromOrganCode() {
		return this.inFromOrganCode;
	}

	public void setInFromOrganCode(String inFromOrganCode) {
		this.inFromOrganCode = inFromOrganCode;
	}

	public String getInToOrganCode() {
		return this.inToOrganCode;
	}

	public void setInToOrganCode(String inToOrganCode) {
		this.inToOrganCode = inToOrganCode;
	}

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public String getToOrganOther() {
        return toOrganOther;
    }

    public void setToOrganOther(String toOrganOther) {
        this.toOrganOther = toOrganOther;
    }

    public String getFromType() {
        return fromType;
    }

    public void setFromType(String fromType) {
        this.fromType = fromType;
    }

    public String getFromOfficeCode() {
        return fromOfficeCode;
    }

    public void setFromOfficeCode(String fromOfficeCode) {
        this.fromOfficeCode = fromOfficeCode;
    }

    public String getFromOfficeName() {
        return fromOfficeName;
    }

    public void setFromOfficeName(String fromOfficeName) {
        this.fromOfficeName = fromOfficeName;
    }

    public String getHgCode() {
        return hgCode;
    }

    public void setHgCode(String hgCode) {
        this.hgCode = hgCode;
    }
}