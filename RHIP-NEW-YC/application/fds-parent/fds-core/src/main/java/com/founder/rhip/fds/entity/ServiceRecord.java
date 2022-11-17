package com.founder.rhip.fds.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="SERVICE_RECORD")
public class ServiceRecord implements Serializable {

	private static final long serialVersionUID = 1L;

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

	@Column(name="SERVICE_TIME",columnDefinition="DATE|服务时间||",nullable=true)
	private Date serviceTime;

	@Column(name="SERVICE_TYPE",columnDefinition="VARCHAR2|服务方式|2|",length=2,nullable=true)
	private String serviceType;

	@Column(name="SERVICE_PLACE",columnDefinition="VARCHAR2|服务地点|100|",length=100,nullable=true)
	private String servicePlace;

	@Column(name="SATISFACTION",columnDefinition="NUMBER|服务满意度（居民对医生）|2|",length=2,nullable=true)
	private Long satisfaction;

	@Column(name="CONCLUSION",columnDefinition="VARCHAR2|服务结论：医生对服务的总结|2000|",length=2000,nullable=true)
	private String conclusion;

	@Column(name="REMARK",columnDefinition="VARCHAR2|服务备注|2000|",length=2000,nullable=true)
	private String remark;

	@Column(name="VALID",columnDefinition="CHAR|有效性（1：有效，0：无效）|1|",length=1,nullable=true)
	private String valid;

	@Column(name="CREATE_USER",columnDefinition="VARCHAR2|创建人|64|",length=64,nullable=true)
	private String createUser;

	@Column(name="CREATE_DATE",columnDefinition="DATE|创建日期||",nullable=true)
	private Date createDate;

	@Column(name="UPDATE_USER",columnDefinition="VARCHAR2|更新人|64|",length=64,nullable=true)
	private String updateUser;

	@Column(name="UPDATE_DATE",columnDefinition="DATE|更新日期||",nullable=true)
	private Date updateDate;
	
	
    @Column(name = "HBP_SBP",columnDefinition="VARCHAR2|收缩压|64|",nullable=true)
    private String hbpSbp;
    
    @Column(name = "HBP_DBP",columnDefinition="VARCHAR2|舒张压|64|",nullable=true)
    private String hbpDbp;
    
    @Column(name = "DI",columnDefinition="VARCHAR2|血糖|64|",nullable=true)
    private String di;
    
//    @Column(name = "FUNDOSCOPY",columnDefinition="VARCHAR2|眼底检查|200|",nullable=true)
//    private String fundoscopy;
//    
//    @Column(name = "CHEST_XRAY",columnDefinition="VARCHAR2|胸透|500|",nullable=true)
//    private String chestXray;
//    
//    @Column(name = "ECG",columnDefinition="VARCHAR2|心电图检查|500|",nullable=true)
//    private String ecg;
    
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
    
    @Column(name = "GLYCATED_HEMOGLOBIN",columnDefinition="NUMBER|糖化血红蛋白||",nullable=true)
    private BigDecimal glycatedHemoglobin;
    
    @Column(name = "DORSALIS_PEDIS_PULSE",columnDefinition="VARCHAR2|足背动脉搏动|500|",nullable=true)
    private String dorsalisPedisPulse;
    
    @Column(name = "FOOT_NERVE_EXAMINATION",columnDefinition="VARCHAR2|足神经检查|500|",nullable=true)
    private String footNerveExamination;
    
    @Column(name = "HEMOGLOBIN_VALUE", columnDefinition = "NUMBER|血红蛋白值(g/L)||", length = 4, nullable = true)
	private BigDecimal hemoglobinValue;
    
    @Column(name = "LUNG_FUNCTION",columnDefinition="VARCHAR2|肺功能|500|",nullable=true)
    private String lungFunction;
    
    @Column(name = "SOURCE",columnDefinition="NUMBER|来源1:家医平台2:区卫平台随访3:医院体检|1|",nullable=true)
    private Integer source = 1;
    
    @Column(name="FOLLOWUP_ID",columnDefinition="NUMBER|随访ID|11|",length=11,nullable=true)
    private Long followUpId;
    
	//服务包名称
	@Transient
	private String servicePackageName;

	//服务编码名称
	@Transient
	private String serviceItemName;


	@Transient
	private String teamName;


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSignId() {
		return this.signId;
	}

	public void setSignId(Long signId) {
		this.signId = signId;
	}

	public String getSignNumber() {
		return this.signNumber;
	}

	public void setSignNumber(String signNumber) {
		this.signNumber = signNumber;
	}

	public String getServicePackageCode() {
		return this.servicePackageCode;
	}

	public void setServicePackageCode(String servicePackageCode) {
		this.servicePackageCode = servicePackageCode;
	}

	public String getServiceItemCode() {
		return this.serviceItemCode;
	}

	public void setServiceItemCode(String serviceItemCode) {
		this.serviceItemCode = serviceItemCode;
	}

	public Long getPersonId() {
		return this.personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return this.personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonIdcard() {
		return this.personIdcard;
	}

	public void setPersonIdcard(String personIdcard) {
		this.personIdcard = personIdcard;
	}

	public String getDoctorName() {
		return this.doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Long getDoctorId() {
		return this.doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorIdcard() {
		return this.doctorIdcard;
	}

	public void setDoctorIdcard(String doctorIdcard) {
		this.doctorIdcard = doctorIdcard;
	}

	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getTeamCode() {
		return this.teamCode;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}

	public Date getServiceTime() {
		return this.serviceTime;
	}

	public void setServiceTime(Date serviceTime) {
		this.serviceTime = serviceTime;
	}

	public String getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServicePlace() {
		return this.servicePlace;
	}

	public void setServicePlace(String servicePlace) {
		this.servicePlace = servicePlace;
	}

	public Long getSatisfaction() {
		return this.satisfaction;
	}

	public void setSatisfaction(Long satisfaction) {
		this.satisfaction = satisfaction;
	}

	public String getConclusion() {
		return this.conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getValid() {
		return this.valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getServicePackageName() {
		return servicePackageName;
	}

	public void setServicePackageName(String servicePackageName) {
		this.servicePackageName = servicePackageName;
	}

	public String getServiceItemName() {
		return serviceItemName;
	}

	public void setServiceItemName(String serviceItemName) {
		this.serviceItemName = serviceItemName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getHbpSbp() {
		return hbpSbp;
	}

	public void setHbpSbp(String hbpSbp) {
		this.hbpSbp = hbpSbp;
	}

	public String getHbpDbp() {
		return hbpDbp;
	}

	public void setHbpDbp(String hbpDbp) {
		this.hbpDbp = hbpDbp;
	}

	public String getDi() {
		return di;
	}

	public void setDi(String di) {
		this.di = di;
	}

//	public String getFundoscopy() {
//		return fundoscopy;
//	}
//
//	public void setFundoscopy(String fundoscopy) {
//		this.fundoscopy = fundoscopy;
//	}
//
//	public String getChestXray() {
//		return chestXray;
//	}
//
//	public void setChestXray(String chestXray) {
//		this.chestXray = chestXray;
//	}
//
//	public String getEcg() {
//		return ecg;
//	}
//
//	public void setEcg(String ecg) {
//		this.ecg = ecg;
//	}

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

	public BigDecimal getHemoglobinValue() {
		return hemoglobinValue;
	}

	public void setHemoglobinValue(BigDecimal hemoglobinValue) {
		this.hemoglobinValue = hemoglobinValue;
	}

	public String getLungFunction() {
		return lungFunction;
	}

	public void setLungFunction(String lungFunction) {
		this.lungFunction = lungFunction;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public Long getFollowUpId() {
		return followUpId;
	}

	public void setFollowUpId(Long followUpId) {
		this.followUpId = followUpId;
	}

	public BigDecimal getGlycatedHemoglobin() {
		return glycatedHemoglobin;
	}

	public void setGlycatedHemoglobin(BigDecimal glycatedHemoglobin) {
		this.glycatedHemoglobin = glycatedHemoglobin;
	}
	
	
}