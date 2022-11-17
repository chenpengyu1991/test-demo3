package com.founder.rhip.fds.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PHYSICAL_EXAM_ITEM")
public class PhysicalExamItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4304888104674961369L;
	
	@Id
	@Column(name="ID",columnDefinition="NUMBER|业务主键|11|",length=11,nullable=false)
	private Long id;

	@Column(name="SIGN_ID",columnDefinition="NUMBER|签约ID|11|",length=11,nullable=true)
	private Long signId;

	@Column(name="SIGN_NUMBER",columnDefinition="VARCHAR2|签约编号|50|",length=50,nullable=true)
	private String signNumber;

	@Column(name="SERVICE_PACKAGE_CODE",columnDefinition="VARCHAR2|服务包编码|20|",length=20,nullable=true)
	private String servicePackageCode;

	@Column(name="SERVICE_ITEM_CODE",columnDefinition="VARCHAR2|服务项目编码|20|",length=20,nullable=true)
	private String serviceItemCode;

	@Column(name="PERSON_ID",columnDefinition="NUMBER|服务对象ID|11|",length=11,nullable=true)
	private Long personId;

	@Column(name="PERSON_NAME",columnDefinition="VARCHAR2|服务对象名称|100|",length=100,nullable=true)
	private String personName;

	@Column(name="PERSON_IDCARD",columnDefinition="VARCHAR2|服务对象身份证|18|",length=18,nullable=true)
	private String personIdcard;

	@Column(name="DOCTOR_NAME",columnDefinition="VARCHAR2|服务医生姓名|100|",length=100,nullable=true)
	private String doctorName;

	@Column(name="DOCTOR_ID",columnDefinition="NUMBER|服务医生ID|11|",length=11,nullable=true)
	private Long doctorId;

	@Column(name="DOCTOR_IDCARD",columnDefinition="VARCHAR2|服务医生身份证号码|18|",length=18,nullable=true)
	private String doctorIdcard;

	@Column(name="ORGAN_CODE",columnDefinition="VARCHAR2|机构编码|20|",length=20,nullable=true)
	private String organCode;

	@Column(name="TEAM_CODE",columnDefinition="VARCHAR2|团队编码|50|",length=50,nullable=true)
	private String teamCode;

    @Column(name = "TC", columnDefinition = "NUMBER|总胆固醇(mmol/L)||", scale = 5, precision = 2, nullable = true)
	private BigDecimal tc;
    
    @Column(name = "TRIGLYCERIDE_VALUE", columnDefinition = "NUMBER|甘油三酯值(mmol/L)||", scale = 3, precision = 1, nullable = true)
	private BigDecimal triglycerideValue;
    
    @Column(name = "HDLC_DETECT_VALUE", columnDefinition = "NUMBER|高密度脂蛋自胆固醇检测值(mmol/L)||", scale = 5, precision = 2, nullable = true)
	private BigDecimal hdlcDetectValue;
    
    @Column(name = "LDLC_DETECT_VALUE", columnDefinition = "NUMBER|低密度脂蛋白胆固醇检测值(mmol/L)||", scale = 5, precision = 2, nullable = true)
	private BigDecimal ldlcDetectValue;
    
    @Column(name = "CREATININE", columnDefinition = "NUMBER|肌酐值(umol/L)||", scale = 1, precision = 4, nullable = true)
	private BigDecimal creatinine;
    
    @Column(name = "BUA",columnDefinition="NUMBER|血尿酸||",nullable=true)
    private BigDecimal bua;
    
    @Column(name = "BUN",columnDefinition="NUMBER|尿素氮||",nullable=true)
    private BigDecimal bun;
    
    @Column(name = "MICROGLOBULIN",columnDefinition="NUMBER|β2微球蛋白||",nullable=true)
    private BigDecimal microglobulin;
    
    @Column(name = "DORSALIS_PEDIS_PULSE",columnDefinition="VARCHAR2|足背动脉搏动|500|",nullable=true)
    private String dorsalisPedisPulse;
    
    @Column(name = "FOOT_NERVE_EXAMINATION",columnDefinition="VARCHAR2|足神经检查|500|",nullable=true)
    private String footNerveExamination;
    
    @Column(name = "HEMOGLOBIN_VALUE", columnDefinition = "NUMBER|血红蛋白值(g/L)||", length = 4, nullable = true)
	private Integer hemoglobinValue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSignId() {
		return signId;
	}

	public void setSignId(Long signId) {
		this.signId = signId;
	}

	public String getSignNumber() {
		return signNumber;
	}

	public void setSignNumber(String signNumber) {
		this.signNumber = signNumber;
	}

	public String getServicePackageCode() {
		return servicePackageCode;
	}

	public void setServicePackageCode(String servicePackageCode) {
		this.servicePackageCode = servicePackageCode;
	}

	public String getServiceItemCode() {
		return serviceItemCode;
	}

	public void setServiceItemCode(String serviceItemCode) {
		this.serviceItemCode = serviceItemCode;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonIdcard() {
		return personIdcard;
	}

	public void setPersonIdcard(String personIdcard) {
		this.personIdcard = personIdcard;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorIdcard() {
		return doctorIdcard;
	}

	public void setDoctorIdcard(String doctorIdcard) {
		this.doctorIdcard = doctorIdcard;
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getTeamCode() {
		return teamCode;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}

	public BigDecimal getTc() {
		return tc;
	}

	public void setTc(BigDecimal tc) {
		this.tc = tc;
	}

	public BigDecimal getTriglycerideValue() {
		return triglycerideValue;
	}

	public void setTriglycerideValue(BigDecimal triglycerideValue) {
		this.triglycerideValue = triglycerideValue;
	}

	public BigDecimal getHdlcDetectValue() {
		return hdlcDetectValue;
	}

	public void setHdlcDetectValue(BigDecimal hdlcDetectValue) {
		this.hdlcDetectValue = hdlcDetectValue;
	}

	public BigDecimal getLdlcDetectValue() {
		return ldlcDetectValue;
	}

	public void setLdlcDetectValue(BigDecimal ldlcDetectValue) {
		this.ldlcDetectValue = ldlcDetectValue;
	}

	public BigDecimal getCreatinine() {
		return creatinine;
	}

	public void setCreatinine(BigDecimal creatinine) {
		this.creatinine = creatinine;
	}

	public BigDecimal getBua() {
		return bua;
	}

	public void setBua(BigDecimal bua) {
		this.bua = bua;
	}

	public BigDecimal getBun() {
		return bun;
	}

	public void setBun(BigDecimal bun) {
		this.bun = bun;
	}

	public BigDecimal getMicroglobulin() {
		return microglobulin;
	}

	public void setMicroglobulin(BigDecimal microglobulin) {
		this.microglobulin = microglobulin;
	}

	public String getDorsalisPedisPulse() {
		return dorsalisPedisPulse;
	}

	public void setDorsalisPedisPulse(String dorsalisPedisPulse) {
		this.dorsalisPedisPulse = dorsalisPedisPulse;
	}

	public String getFootNerveExamination() {
		return footNerveExamination;
	}

	public void setFootNerveExamination(String footNerveExamination) {
		this.footNerveExamination = footNerveExamination;
	}

	public Integer getHemoglobinValue() {
		return hemoglobinValue;
	}

	public void setHemoglobinValue(Integer hemoglobinValue) {
		this.hemoglobinValue = hemoglobinValue;
	}

    
}
