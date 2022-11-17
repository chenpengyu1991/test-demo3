package com.founder.rhip.ehr.entity.control;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

//

//
@Entity
@Table(name = "DC_OCCUPATION_DISEASE_REPORT")
public class OccupationDiseaseReport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "SMPI_ID", columnDefinition = "VARCHAR2|PIX号||", length = 50, nullable = true)
    private String smpiId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|职业病报告卡编号||", length = 20, nullable = true)
    private String recordNumber;

    @Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号||", length = 17, nullable = true)
    private String healthFileNo;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|本人姓名||", length = 50, nullable = true)
    private String name;

    @Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
    private Date birthday;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别代码||", length = 1, nullable = true)
    private String gender;

    @Column(name = "EDUCATION", columnDefinition = "VARCHAR2|学历代码||", length = 2, nullable = true)
    private String education;

    @Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|本人电话号码||", length = 20, nullable = true)
    private String phoneNumber;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证件号码||", length = 18, nullable = true)
    private String idcard;

    @Column(name = "IDCARD_TYPE", columnDefinition = "VARCHAR2|身份证件类别代码||", length = 2, nullable = true)
    private String idcardType;

    @Column(name = "WORK_DESC", columnDefinition = "VARCHAR2|从事职业工种描述||", length = 100, nullable = true)
    private String workDesc;

    @Column(name = "AREA_CODE", columnDefinition = "VARCHAR2|行政区划代码||", length = 6, nullable = true)
    private String areaCode;

    @Column(name = "HRSTREET", columnDefinition = "VARCHAR2|户籍地址-村(街、路、弄等)||", length = 70, nullable = true)
    private String hrstreet;

    @Column(name = "HRHOUSE_NUMBER", columnDefinition = "VARCHAR2|户籍地址-门牌号码||", length = 70, nullable = true)
    private String hrhouseNumber;

    @Column(name = "HRPROVINCE", columnDefinition = "VARCHAR2|户籍地址-省(自治区、直辖市)||", length = 70, nullable = true)
    private String hrprovince;

    @Column(name = "HRCITY", columnDefinition = "VARCHAR2|户籍地址-市(地区、州)||", length = 70, nullable = true)
    private String hrcity;

    @Column(name = "HRCOUNTY", columnDefinition = "VARCHAR2|户籍地址-县(区)||", length = 70, nullable = true)
    private String hrcounty;

    @Column(name = "HRTOWN_SHIP", columnDefinition = "VARCHAR2|户籍地址-乡(镇、街道办事处)||", length = 70, nullable = true)
    private String hrtownShip;

    @Column(name = "PASTREET", columnDefinition = "VARCHAR2|现住地址-村(街、路、弄等)||", length = 70, nullable = true)
    private String pastreet;

    @Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|现住地址-门牌号码||", length = 70, nullable = true)
    private String pahouseNumber;

    @Column(name = "PAPROVINCE", columnDefinition = "VARCHAR2|现住地址-省(自治区、直辖市)||", length = 70, nullable = true)
    private String paprovince;

    @Column(name = "PACITY", columnDefinition = "VARCHAR2|现住地址-市(地区、州)||", length = 70, nullable = true)
    private String pacity;

    @Column(name = "PACOUNTY", columnDefinition = "VARCHAR2|现住地址-县(区)||", length = 70, nullable = true)
    private String pacounty;

    @Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|现住地址-乡(镇、街道办事处)||", length = 70, nullable = true)
    private String patownShip;
    
	@Column(name = "PA_GROUP", columnDefinition = "VARCHAR2|现住址小组地址||", length = 2, nullable = true)
	private String paGroup;

    @Column(name = "UASTREET", columnDefinition = "VARCHAR2|工作单位地址-村(街、路、弄等)||", length = 70, nullable = true)
    private String uastreet;

    @Column(name = "UAHOUSE_NUMBER", columnDefinition = "VARCHAR2|工作单位地址-门牌号码||", length = 70, nullable = true)
    private String uahouseNumber;

    @Column(name = "UAPROVINCE", columnDefinition = "VARCHAR2|工作单位地址-省(自治区、直辖市)||", length = 70, nullable = true)
    private String uaprovince;

    @Column(name = "UACITY", columnDefinition = "VARCHAR2|工作单位地址-市(地区、州)||", length = 70, nullable = true)
    private String uacity;

    @Column(name = "UACOUNTY", columnDefinition = "VARCHAR2|工作单位地址-县(区)||", length = 70, nullable = true)
    private String uacounty;

    @Column(name = "UATOWN_SHIP", columnDefinition = "VARCHAR2|工作单位地址-乡(镇、街道办事处)||", length = 70, nullable = true)
    private String uatownShip;

    @Column(name = "UNIT_PHONE", columnDefinition = "VARCHAR2|工作单位电话号码||", length = 20, nullable = true)
    private String unitPhone;

    @Column(name = "UNIT_NAME", columnDefinition = "VARCHAR2|工作单位名称||", length = 70, nullable = true)
    private String unitName;

    @Column(name = "POST_CODE", columnDefinition = "VARCHAR2|邮政编码||", length = 6, nullable = true)
    private String postCode;

    @Column(name = "FAMILY_PHONE", columnDefinition = "VARCHAR2|家人电话号码||", length = 20, nullable = true)
    private String familyPhone;

    @Column(name = "ASBESTOSIS_TUBERCULOSIS_FLAG", columnDefinition = "CHAR|尘肺合并肺结核的标志||", length = 1, nullable = true)
    private String asbestosisTuberculosisFlag;

    @Column(name = "ASBESTOSIS_TYPE", columnDefinition = "VARCHAR2|尘肺类别代码||", length = 1, nullable = true)
    private String asbestosisType;

    @Column(name = "ASBESTOSIS_STAGE", columnDefinition = "VARCHAR2|尘肺期别代码||", length = 1, nullable = true)
    private String asbestosisStage;

    @Column(name = "RADIATION_AGE", columnDefinition = "NUMBER|放射工龄(a)||", length = 5, nullable = true)
    private Integer radiationAge;

    @Column(name = "RADIATION_INDEX_CODE", columnDefinition = "VARCHAR2|放射性疾病的分度代码||", length = 1, nullable = true)
    private String radiationIndexCode;

    @Column(name = "RADIATION_DIVISION_CODE", columnDefinition = "VARCHAR2|放射性疾病的分期代码||", length = 1, nullable = true)
    private String radiationDivisionCode;

    @Column(name = "UNDERLYING_DEATH_CODE", columnDefinition = "VARCHAR2|根本死因代码||", length = 5, nullable = true)
    private String underlyingDeathCode;

    @Column(name = "START_WORK_DATE", columnDefinition = "DATE|开始从事放射工作日期||", nullable = true)
    private Date startWorkDate;

    @Column(name = "START_DUST_DATE", columnDefinition = "DATE|开始接尘日期||", nullable = true)
    private Date startDustDate;

    @Column(name = "CUMULATIVE_EXPOSURE_RUNTIME", columnDefinition = "NUMBER|累积受照时长(h/a)||", length = 5, nullable = true)
    private Integer cumulativeExposureRuntime;

    @Column(name = "ACTUAL_HARM_AGE", columnDefinition = "NUMBER|实际接害工龄(a)||", length = 5, nullable = true)
    private Integer actualHarmAge;

    @Column(name = "FIRST_SYMPTOMS_DATE", columnDefinition = "DATE|首次出现症状日期||", nullable = true)
    private Date firstSymptomsDate;

    @Column(name = "EXPOSURE_DOSE", columnDefinition = "NUMBER|受照剂量(Gy)||", scale = 6, precision = 2, nullable = true)
    private BigDecimal exposureDose;

    @Column(name = "EXPOSURE_TYPE_CODE", columnDefinition = "VARCHAR2|受照类型代码||", length = 1, nullable = true)
    private String exposureTypeCode;

    @Column(name = "EXPOSURE_DATE", columnDefinition = "DATE|受照日期||", nullable = true)
    private Date exposureDate;

    @Column(name = "IRRADIATION_HISTORY", columnDefinition = "VARCHAR2|受照史||", length = 100, nullable = true)
    private String irradiationHistory;

    @Column(name = "EXPOSURE_REASON_CODE", columnDefinition = "VARCHAR2|受照原因代码||", length = 2, nullable = true)
    private String exposureReasonCode;

    @Column(name = "DEATH_DATE", columnDefinition = "TIMESTAMP|死亡日期时间||", nullable = true)
    private Date deathDate;

    @Column(name = "STATISTICS_WORK", columnDefinition = "VARCHAR2|统计工种||", length = 100, nullable = true)
    private String statisticsWork;

    @Column(name = "OCCUPATION_NAME_CODE", columnDefinition = "VARCHAR2|职业病名称代码||", length = 5, nullable = true)
    private String occupationNameCode;

    @Column(name = "OCCUPATION_LEVEL_CODE", columnDefinition = "VARCHAR2|职业病伤残等级代码||", length = 2, nullable = true)
    private String occupationLevelCode;

    @Column(name = "OCCUPATION_TYPE_CODE", columnDefinition = "VARCHAR2|职业病种类代码||", length = 2, nullable = true)
    private String occupationTypeCode;

    @Column(name = "OCCUPATION_PROGNOSIS_CODE", columnDefinition = "VARCHAR2|职业病转归代码||", length = 1, nullable = true)
    private String occupationPrognosisCode;

    @Column(name = "OCCUPATION_RADIATION_TYPE", columnDefinition = "VARCHAR2|职业性放射性疾病处理类别代码||", length = 2, nullable = true)
    private String occupationRadiationType;

    @Column(name = "OCCUPATION_RADIATION_CODE", columnDefinition = "VARCHAR2|职业性放射性疾病代码||", length = 100, nullable = true)
    private String occupationRadiationCode;

    @Column(name = "OCCUPATION_EXPOSURE_TYPE_CODE", columnDefinition = "VARCHAR2|职业照射种类代码||", length = 1, nullable = true)
    private String occupationExposureTypeCode;

    @Column(name = "DIAGNOSIS_ORGAN_NAME", columnDefinition = "VARCHAR2|诊断机构名称||", length = 70, nullable = true)
    private String diagnosisOrganName;

    @Column(name = "DIAGNOSIS_DATE", columnDefinition = "TIMESTAMP|诊断日期时间||", nullable = true)
    private Date diagnosisDate;

    @Column(name = "DIAGNOSTICIAN_NAME", columnDefinition = "VARCHAR2|诊断医师姓名||", length = 50, nullable = true)
    private String diagnosticianName;

    @Column(name = "FILL_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 70, nullable = true)
    private String fillOrganName;

    @Column(name = "FILL_USER_NAME", columnDefinition = "VARCHAR2|填报人姓名||", length = 50, nullable = true)
    private String fillUserName;

    @Column(name = "FILL_TIME", columnDefinition = "TIMESTAMP|填报日期时间||", nullable = true)
    private Date fillTime;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete=0;

    @Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|创建机构编码||", length = 20, nullable = true)
    private String createOrganCode;

    public String getPaGroup() {
		return paGroup;
	}

	public void setPaGroup(String paGroup) {
		this.paGroup = paGroup;
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

    public String getHealthFileNo() {
        return this.healthFileNo;
    }

    public void setHealthFileNo(String healthFileNo) {
        this.healthFileNo = healthFileNo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducation() {
        return this.education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdcard() {
        return this.idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getIdcardType() {
        return this.idcardType;
    }

    public void setIdcardType(String idcardType) {
        this.idcardType = idcardType;
    }

    public String getWorkDesc() {
        return this.workDesc;
    }

    public void setWorkDesc(String workDesc) {
        this.workDesc = workDesc;
    }

    public String getAreaCode() {
        return this.areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getHrstreet() {
        return this.hrstreet;
    }

    public void setHrstreet(String hrstreet) {
        this.hrstreet = hrstreet;
    }

    public String getHrhouseNumber() {
        return this.hrhouseNumber;
    }

    public void setHrhouseNumber(String hrhouseNumber) {
        this.hrhouseNumber = hrhouseNumber;
    }

    public String getHrprovince() {
        return this.hrprovince;
    }

    public void setHrprovince(String hrprovince) {
        this.hrprovince = hrprovince;
    }

    public String getHrcity() {
        return this.hrcity;
    }

    public void setHrcity(String hrcity) {
        this.hrcity = hrcity;
    }

    public String getHrcounty() {
        return this.hrcounty;
    }

    public void setHrcounty(String hrcounty) {
        this.hrcounty = hrcounty;
    }

    public String getHrtownShip() {
        return this.hrtownShip;
    }

    public void setHrtownShip(String hrtownShip) {
        this.hrtownShip = hrtownShip;
    }

    public String getPastreet() {
        return this.pastreet;
    }

    public void setPastreet(String pastreet) {
        this.pastreet = pastreet;
    }

    public String getPahouseNumber() {
        return this.pahouseNumber;
    }

    public void setPahouseNumber(String pahouseNumber) {
        this.pahouseNumber = pahouseNumber;
    }

    public String getPaprovince() {
        return this.paprovince;
    }

    public void setPaprovince(String paprovince) {
        this.paprovince = paprovince;
    }

    public String getPacity() {
        return this.pacity;
    }

    public void setPacity(String pacity) {
        this.pacity = pacity;
    }

    public String getPacounty() {
        return this.pacounty;
    }

    public void setPacounty(String pacounty) {
        this.pacounty = pacounty;
    }

    public String getPatownShip() {
        return this.patownShip;
    }

    public void setPatownShip(String patownShip) {
        this.patownShip = patownShip;
    }

    public String getUastreet() {
        return this.uastreet;
    }

    public void setUastreet(String uastreet) {
        this.uastreet = uastreet;
    }

    public String getUahouseNumber() {
        return this.uahouseNumber;
    }

    public void setUahouseNumber(String uahouseNumber) {
        this.uahouseNumber = uahouseNumber;
    }

    public String getUaprovince() {
        return this.uaprovince;
    }

    public void setUaprovince(String uaprovince) {
        this.uaprovince = uaprovince;
    }

    public String getUacity() {
        return this.uacity;
    }

    public void setUacity(String uacity) {
        this.uacity = uacity;
    }

    public String getUacounty() {
        return this.uacounty;
    }

    public void setUacounty(String uacounty) {
        this.uacounty = uacounty;
    }

    public String getUatownShip() {
        return this.uatownShip;
    }

    public void setUatownShip(String uatownShip) {
        this.uatownShip = uatownShip;
    }

    public String getUnitPhone() {
        return this.unitPhone;
    }

    public void setUnitPhone(String unitPhone) {
        this.unitPhone = unitPhone;
    }

    public String getUnitName() {
        return this.unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getPostCode() {
        return this.postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getFamilyPhone() {
        return this.familyPhone;
    }

    public void setFamilyPhone(String familyPhone) {
        this.familyPhone = familyPhone;
    }

    public String getAsbestosisTuberculosisFlag() {
        return this.asbestosisTuberculosisFlag;
    }

    public void setAsbestosisTuberculosisFlag(String asbestosisTuberculosisFlag) {
        this.asbestosisTuberculosisFlag = asbestosisTuberculosisFlag;
    }

    public String getAsbestosisType() {
        return this.asbestosisType;
    }

    public void setAsbestosisType(String asbestosisType) {
        this.asbestosisType = asbestosisType;
    }

    public String getAsbestosisStage() {
        return this.asbestosisStage;
    }

    public void setAsbestosisStage(String asbestosisStage) {
        this.asbestosisStage = asbestosisStage;
    }

    public Integer getRadiationAge() {
        return this.radiationAge;
    }

    public void setRadiationAge(Integer radiationAge) {
        this.radiationAge = radiationAge;
    }

    public String getRadiationIndexCode() {
        return this.radiationIndexCode;
    }

    public void setRadiationIndexCode(String radiationIndexCode) {
        this.radiationIndexCode = radiationIndexCode;
    }

    public String getRadiationDivisionCode() {
        return this.radiationDivisionCode;
    }

    public void setRadiationDivisionCode(String radiationDivisionCode) {
        this.radiationDivisionCode = radiationDivisionCode;
    }

    public String getUnderlyingDeathCode() {
        return this.underlyingDeathCode;
    }

    public void setUnderlyingDeathCode(String underlyingDeathCode) {
        this.underlyingDeathCode = underlyingDeathCode;
    }

    public Date getStartWorkDate() {
        return this.startWorkDate;
    }

    public void setStartWorkDate(Date startWorkDate) {
        this.startWorkDate = startWorkDate;
    }

    public Date getStartDustDate() {
        return this.startDustDate;
    }

    public void setStartDustDate(Date startDustDate) {
        this.startDustDate = startDustDate;
    }

    public Integer getCumulativeExposureRuntime() {
        return this.cumulativeExposureRuntime;
    }

    public void setCumulativeExposureRuntime(Integer cumulativeExposureRuntime) {
        this.cumulativeExposureRuntime = cumulativeExposureRuntime;
    }

    public Integer getActualHarmAge() {
        return this.actualHarmAge;
    }

    public void setActualHarmAge(Integer actualHarmAge) {
        this.actualHarmAge = actualHarmAge;
    }

    public Date getFirstSymptomsDate() {
        return this.firstSymptomsDate;
    }

    public void setFirstSymptomsDate(Date firstSymptomsDate) {
        this.firstSymptomsDate = firstSymptomsDate;
    }

    public BigDecimal getExposureDose() {
        return this.exposureDose;
    }

    public void setExposureDose(BigDecimal exposureDose) {
        this.exposureDose = exposureDose;
    }

    public String getExposureTypeCode() {
        return this.exposureTypeCode;
    }

    public void setExposureTypeCode(String exposureTypeCode) {
        this.exposureTypeCode = exposureTypeCode;
    }

    public Date getExposureDate() {
        return this.exposureDate;
    }

    public void setExposureDate(Date exposureDate) {
        this.exposureDate = exposureDate;
    }

    public String getIrradiationHistory() {
        return this.irradiationHistory;
    }

    public void setIrradiationHistory(String irradiationHistory) {
        this.irradiationHistory = irradiationHistory;
    }

    public String getExposureReasonCode() {
        return this.exposureReasonCode;
    }

    public void setExposureReasonCode(String exposureReasonCode) {
        this.exposureReasonCode = exposureReasonCode;
    }

    public Date getDeathDate() {
        return this.deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public String getStatisticsWork() {
        return this.statisticsWork;
    }

    public void setStatisticsWork(String statisticsWork) {
        this.statisticsWork = statisticsWork;
    }

    public String getOccupationNameCode() {
        return this.occupationNameCode;
    }

    public void setOccupationNameCode(String occupationNameCode) {
        this.occupationNameCode = occupationNameCode;
    }

    public String getOccupationLevelCode() {
        return this.occupationLevelCode;
    }

    public void setOccupationLevelCode(String occupationLevelCode) {
        this.occupationLevelCode = occupationLevelCode;
    }

    public String getOccupationTypeCode() {
        return this.occupationTypeCode;
    }

    public void setOccupationTypeCode(String occupationTypeCode) {
        this.occupationTypeCode = occupationTypeCode;
    }

    public String getOccupationPrognosisCode() {
        return this.occupationPrognosisCode;
    }

    public void setOccupationPrognosisCode(String occupationPrognosisCode) {
        this.occupationPrognosisCode = occupationPrognosisCode;
    }


	public String getOccupationRadiationType() {
		return occupationRadiationType;
	}

	public void setOccupationRadiationType(String occupationRadiationType) {
		this.occupationRadiationType = occupationRadiationType;
	}

	public String getOccupationRadiationCode() {
        return this.occupationRadiationCode;
    }

    public void setOccupationRadiationCode(String occupationRadiationCode) {
        this.occupationRadiationCode = occupationRadiationCode;
    }

    public String getOccupationExposureTypeCode() {
        return this.occupationExposureTypeCode;
    }

    public void setOccupationExposureTypeCode(String occupationExposureTypeCode) {
        this.occupationExposureTypeCode = occupationExposureTypeCode;
    }

    public String getDiagnosisOrganName() {
        return this.diagnosisOrganName;
    }

    public void setDiagnosisOrganName(String diagnosisOrganName) {
        this.diagnosisOrganName = diagnosisOrganName;
    }

    public Date getDiagnosisDate() {
        return this.diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public String getDiagnosticianName() {
        return this.diagnosticianName;
    }

    public void setDiagnosticianName(String diagnosticianName) {
        this.diagnosticianName = diagnosticianName;
    }

    public String getFillOrganName() {
        return this.fillOrganName;
    }

    public void setFillOrganName(String fillOrganName) {
        this.fillOrganName = fillOrganName;
    }

    public String getFillUserName() {
        return this.fillUserName;
    }

    public void setFillUserName(String fillUserName) {
        this.fillUserName = fillUserName;
    }

    public Date getFillTime() {
        return this.fillTime;
    }

    public void setFillTime(Date fillTime) {
        this.fillTime = fillTime;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getSmpiId() {
        return smpiId;
    }

    public void setSmpiId(String smpiId) {
        this.smpiId = smpiId;
    }

	public String getCreateOrganCode() {
		return createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	
}
