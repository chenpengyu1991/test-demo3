package com.founder.rhip.ehr.entity.women;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jingqiu on 17-5-5.
 */
@Table(name = "WH_PRENATAL_SCREEN_DIAGNOSIS")
public class PrenatalScreenDiagnosis {

	private static final long serialVersionUID = 3210843039295920241L;

	@Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = false)
	private String ehrId;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
	private Long id;

	/**
	 * 人员编码
	 */
	@Column(name = "PERSON_ID")
	private Long personId;

	/**
	 * 城乡居民健康档案编号
	 */
	@Column(name = "HEALTH_FILE_NO")
	private String healthFileNo;

	/**
	 * 姓名
	 */
	@Column(name = "NAME")
	private String name;

	/**
	 * 出生日期
	 */
	@Column(name = "BIRTHDAY")
	private Date birthday;

	/**
	 * 本人电话号码
	 */
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	/**
	 * 身份证件类别代码
	 */
	@Column(name = "IDCARD_TYPE")
	private String idcardType;

	/**
	 * 身份证件号码
	 */
	@Column(name = "ID_CARD")
	private String idCard;

	/**
	 * 行政区划代码
	 */
	@Column(name = "AREA_CODE")
	private String areaCode;

	/**
	 * 户籍地址-村(街、路、弄等)
	 */
	@Column(name = "HRSTREET")
	private String hrstreet;

	/**
	 * 户籍地址-门牌号码
	 */
	@Column(name = "HRHOUSE_NUMBER")
	private String hrhouseNumber;

	/**
	 * 户籍地址-省(自治区、直辖市)
	 */
	@Column(name = "HRPROVINCE")
	private String hrprovince;

	/**
	 * 户籍地址-市(地区、州)
	 */
	@Column(name = "HRCITY")
	private String hrcity;

	/**
	 * 户籍地址-县(区)
	 */
	@Column(name = "HRCOUNTY")
	private String hrcounty;

	/**
	 * 户籍地址-乡(镇、街道办事处)
	 */
	@Column(name = "HRTOWN_SHIP")
	private String hrtownShip;

	/**
	 * 户籍地址邮政编码
	 */
	@Column(name = "HRPOST_CODE")
	private String hrpostCode;

	/**
	 * 现住址-村(街、路、弄等)
	 */
	@Column(name = "PASTREET")
	private String pastreet;

	/**
	 * 现住址-门牌号码
	 */
	@Column(name = "PAHOUSE_NUMBER")
	private String pahouseNumber;

	/**
	 * 现住址-省(自治区、直辖市)
	 */
	@Column(name = "PAPROVINCE")
	private String paprovince;

	/**
	 * 现住址-市(地区、州)
	 */
	@Column(name = "PACITY")
	private String pacity;

	/**
	 * 现住址-县(区)
	 */
	@Column(name = "PACOUNTY")
	private String pacounty;

	/**
	 * 现住址-乡(镇、街道办事处)
	 */
	@Column(name = "PATOWN_SHIP")
	private String patownShip;

	/**
	 * 现住址邮政编码
	 */
	@Column(name = "PAPOST_CODE")
	private String papostCode;

	/**
	 * 记录表单编号
	 */
	@Column(name = "RECORD_NUMBER")
	private String recordNumber;

	/**
	 * 体重(kg)
	 */
	@Column(name = "BODY_WEIGHT")
	private BigDecimal bodyWeight;

	/**
	 * 收缩压(mmHg)
	 */
	@Column(name = "SBP")
	private String sbp;

	/**
	 * 舒张压(mmHg)
	 */
	@Column(name = "DBP")
	private String dbp;

	/**
	 * 妊娠结局
	 */
	@Column(name = "PREGNANCY_OUTCOME")
	private String pregnancyOutcome;

	/**
	 * 检查(测)日期
	 */
	@Column(name = "CHECK_DATE")
	private Date checkDate;

	/**
	 * 产前筛查孕周
	 */
	@Column(name = "SCREENING_PRE_WEEK")
	private Integer screeningPreWeek;

	/**
	 * 产前筛查项目
	 */
	@Column(name = "SCREENING_ITEM")
	private String screeningItem;

	/**
	 * 产前筛查方法代码
	 */
	@Column(name = "SCREENING_METHOD")
	private String screeningMethod;

	/**
	 * 产前筛查结果
	 */
	@Column(name = "SCREENING_RESULT")
	private String screeningResult;

	/**
	 * 筛查日期
	 */
	@Column(name = "SCREENING_DATE")
	private Date screeningDate;

	/**
	 * 产前筛查医师姓名
	 */
	@Column(name = "SCREENING_DOCTOR_NAME")
	private String screeningDoctorName;

	/**
	 * 产前筛查机构名称
	 */
	@Column(name = "SCREENING_ORGAN_NAME")
	private String screeningOrganName;

	/**
	 * 产前诊断孕周
	 */
	@Column(name = "DIAGNOSIS_PRE_WEEK")
	private Integer diagnosisPreWeek;

	/**
	 * 诊断项目
	 */
	@Column(name = "DIAGNOSIS_ITEM")
	private String diagnosisItem;

	/**
	 * 诊断方法
	 */
	@Column(name = "DIAGNOSIS_METHOD")
	private String diagnosisMethod;

	/**
	 * 诊断结果
	 */
	@Column(name = "DIAGNOSIS_RESULT")
	private String diagnosisResult;

	/**
	 * 产前诊断医学意见
	 */
	@Column(name = "DIAGNOSIS_MEDICAL_OPINION")
	private String diagnosisMedicalOpinion;

	/**
	 * 诊断日期
	 */
	@Column(name = "DIAGNOSIS_DATE")
	private Date diagnosisDate;

	/**
	 * 产前诊断医师姓名
	 */
	@Column(name = "DIAGNOSTICIAN_NAME")
	private String diagnosticianName;

	/**
	 * 诊断机构名称
	 */
	@Column(name = "DIAGNOSIS_ORGAN_NAME")
	private String diagnosisOrganName;

	/**
	 * 删除状态
	 */
	@Column(name = "IS_DELETE")
	private Integer isDelete;

	/**
	 * 母亲身份证件-号码
	 */
	@Column(name = "MOTHER_IDCARD")
	private String motherIdcard;

	/**
	 * 宝宝卡号
	 */
	@Column(name = "BABY_CARD_NO")
	private String babyCardNo;

	/**
	 * 填报机构代码
	 */
	@Column(name = "CREATE_ORGAN_CODE")
	private String createOrganCode;

	/**
	 * 填报机构名称
	 */
	@Column(name = "CREATE_ORGAN_NAME")
	private String createOrganName;

	/**
	 * 处理状态
	 */
	@Column(name = "PROCESS_STATUS")
	private String processStatus;

	/**
	 * 采集日期
	 */
	@Column(name = "GATHER_DATE")
	private Date gatherDate;

	@Transient
	private String checkDateDesc;

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Date getGatherDate() {
		return gatherDate;
	}

	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
	}

	public String getRecordNumber() {
		return this.recordNumber;
	}

	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}

	public BigDecimal getBodyWeight() {
		return this.bodyWeight;
	}

	public void setBodyWeight(BigDecimal bodyWeight) {
		this.bodyWeight = bodyWeight;
	}

	public String getSbp() {
		return sbp;
	}

	public void setSbp(String sbp) {
		this.sbp = sbp;
	}

	public String getDbp() {
		return dbp;
	}

	public void setDbp(String dbp) {
		this.dbp = dbp;
	}

	public String getPregnancyOutcome() {
		return this.pregnancyOutcome;
	}

	public void setPregnancyOutcome(String pregnancyOutcome) {
		this.pregnancyOutcome = pregnancyOutcome;
	}

	public Date getCheckDate() {
		return this.checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public Integer getScreeningPreWeek() {
		return screeningPreWeek;
	}

	public void setScreeningPreWeek(Integer screeningPreWeek) {
		this.screeningPreWeek = screeningPreWeek;
	}

	public String getScreeningItem() {
		return screeningItem;
	}

	public void setScreeningItem(String screeningItem) {
		this.screeningItem = screeningItem;
	}

	public String getScreeningMethod() {
		return screeningMethod;
	}

	public void setScreeningMethod(String screeningMethod) {
		this.screeningMethod = screeningMethod;
	}

	public String getScreeningResult() {
		return screeningResult;
	}

	public void setScreeningResult(String screeningResult) {
		this.screeningResult = screeningResult;
	}

	public Date getScreeningDate() {
		return this.screeningDate;
	}

	public void setScreeningDate(Date screeningDate) {
		this.screeningDate = screeningDate;
	}

	public String getScreeningDoctorName() {
		return screeningDoctorName;
	}

	public void setScreeningDoctorName(String screeningDoctorName) {
		this.screeningDoctorName = screeningDoctorName;
	}

	public String getScreeningOrganName() {
		return screeningOrganName;
	}

	public void setScreeningOrganName(String screeningOrganName) {
		this.screeningOrganName = screeningOrganName;
	}

	public Integer getDiagnosisPreWeek() {
		return this.diagnosisPreWeek;
	}

	public void setDiagnosisPreWeek(Integer diagnosisPreWeek) {
		this.diagnosisPreWeek = diagnosisPreWeek;
	}

	public String getDiagnosisItem() {
		return this.diagnosisItem;
	}

	public void setDiagnosisItem(String diagnosisItem) {
		this.diagnosisItem = diagnosisItem;
	}

	public String getDiagnosisMethod() {
		return this.diagnosisMethod;
	}

	public void setDiagnosisMethod(String diagnosisMethod) {
		this.diagnosisMethod = diagnosisMethod;
	}

	public String getDiagnosisResult() {
		return this.diagnosisResult;
	}

	public void setDiagnosisResult(String diagnosisResult) {
		this.diagnosisResult = diagnosisResult;
	}

	public String getDiagnosisMedicalOpinion() {
		return diagnosisMedicalOpinion;
	}

	public void setDiagnosisMedicalOpinion(String diagnosisMedicalOpinion) {
		this.diagnosisMedicalOpinion = diagnosisMedicalOpinion;
	}

	public String getDiagnosticianName() {
		return diagnosticianName;
	}

	public void setDiagnosticianName(String diagnosticianName) {
		this.diagnosticianName = diagnosticianName;
	}

	public Date getDiagnosisDate() {
		return this.diagnosisDate;
	}

	public void setDiagnosisDate(Date diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}

	public String getDiagnosisOrganName() {
		return this.diagnosisOrganName;
	}

	public void setDiagnosisOrganName(String diagnosisOrganName) {
		this.diagnosisOrganName = diagnosisOrganName;
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

	public String getHealthFileNo() {
		return healthFileNo;
	}


	public void setHealthFileNo(String healthFileNo) {
		this.healthFileNo = healthFileNo;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getIdcardType() {
		return idcardType;
	}


	public void setIdcardType(String idcardType) {
		this.idcardType = idcardType;
	}

	public String getIdCard() {
		return idCard;
	}


	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getAreaCode() {
		return areaCode;
	}


	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getHrstreet() {
		return hrstreet;
	}


	public void setHrstreet(String hrstreet) {
		this.hrstreet = hrstreet;
	}

	public String getHrhouseNumber() {
		return hrhouseNumber;
	}


	public void setHrhouseNumber(String hrhouseNumber) {
		this.hrhouseNumber = hrhouseNumber;
	}

	public String getHrprovince() {
		return hrprovince;
	}


	public void setHrprovince(String hrprovince) {
		this.hrprovince = hrprovince;
	}

	public String getHrcity() {
		return hrcity;
	}


	public void setHrcity(String hrcity) {
		this.hrcity = hrcity;
	}

	public String getHrcounty() {
		return hrcounty;
	}


	public void setHrcounty(String hrcounty) {
		this.hrcounty = hrcounty;
	}

	public String getHrtownShip() {
		return hrtownShip;
	}


	public void setHrtownShip(String hrtownShip) {
		this.hrtownShip = hrtownShip;
	}

	public String getHrpostCode() {
		return hrpostCode;
	}


	public void setHrpostCode(String hrpostCode) {
		this.hrpostCode = hrpostCode;
	}

	public String getPastreet() {
		return pastreet;
	}


	public void setPastreet(String pastreet) {
		this.pastreet = pastreet;
	}

	public String getPahouseNumber() {
		return pahouseNumber;
	}


	public void setPahouseNumber(String pahouseNumber) {
		this.pahouseNumber = pahouseNumber;
	}

	public String getPaprovince() {
		return paprovince;
	}


	public void setPaprovince(String paprovince) {
		this.paprovince = paprovince;
	}

	public String getPacity() {
		return pacity;
	}


	public void setPacity(String pacity) {
		this.pacity = pacity;
	}

	public String getPacounty() {
		return pacounty;
	}


	public void setPacounty(String pacounty) {
		this.pacounty = pacounty;
	}

	public String getPatownShip() {
		return patownShip;
	}


	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}

	public String getPapostCode() {
		return papostCode;
	}

	public void setPapostCode(String papostCode) {
		this.papostCode = papostCode;
	}

	public String getMotherIdcard() {
		return motherIdcard;
	}

	public void setMotherIdcard(String motherIdcard) {
		this.motherIdcard = motherIdcard;
	}

	public String getBabyCardNo() {
		return babyCardNo;
	}

	public void setBabyCardNo(String babyCardNo) {
		this.babyCardNo = babyCardNo;
	}

	public String getCreateOrganCode() {
		return createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	public String getCreateOrganName() {
		return createOrganName;
	}

	public void setCreateOrganName(String createOrganName) {
		this.createOrganName = createOrganName;
	}


	public String getCheckDateDesc() {
		return checkDateDesc;
	}


	public void setCheckDateDesc(String checkDateDesc) {
		this.checkDateDesc = checkDateDesc;
	}


	public String getProcessStatus() {
		return processStatus;
	}


	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

}


