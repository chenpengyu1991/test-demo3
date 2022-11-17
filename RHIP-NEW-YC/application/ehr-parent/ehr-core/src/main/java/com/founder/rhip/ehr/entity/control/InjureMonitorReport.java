package com.founder.rhip.ehr.entity.control;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "DC_INJURE_MONITOR_REPORT")
public class InjureMonitorReport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "SMPI_ID", columnDefinition = "VARCHAR2|PIX号||", length = 50, nullable = true)
    private String smpiId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号||", length = 17, nullable = true)
    private String healthFileNo;

    @Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|伤害报告卡编号||", length = 20, nullable = true)
    private String recordNumber;

    @Column(name = "MONITORING_HOSPITAL_NO", columnDefinition = "VARCHAR2|监测医院编号||", length = 20, nullable = true)
    private String monitoringHospitalNo;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|本人姓名||", length = 50, nullable = true)
    private String name;

    @Column(name = "IDCARD_TYPE", columnDefinition = "VARCHAR2|身份证件类别代码||", length = 2, nullable = true)
    private String idCardType;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证件号码||", length = 18, nullable = true)
    private String idCard;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别代码||", length = 1, nullable = true)
    private String gender;

    @Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
    private Date birthday;

    @Column(name = "OCCUPATION", columnDefinition = "VARCHAR2|职业类别代码||", length = 3, nullable = true)
    private String occupation;

    @Column(name = "EDUCATION", columnDefinition = "VARCHAR2|学历代码||", length = 2, nullable = true)
    private String education;

    @Column(name = "HRPROVINCE", columnDefinition = "VARCHAR2|户籍地址-省(自治区、直辖市)||", length = 70, nullable = true)
    private String hrprovince;

    @Column(name = "HRCITY", columnDefinition = "VARCHAR2|户籍地址-市(地区、州)||", length = 70, nullable = true)
    private String hrcity;

    @Column(name = "HRCOUNTY", columnDefinition = "VARCHAR2|户籍地址-县(区)||", length = 70, nullable = true)
    private String hrcounty;

    @Column(name = "HRTOWN_SHIP", columnDefinition = "VARCHAR2|户籍地址-乡(镇、街道办事处)||", length = 70, nullable = true)
    private String hrtownShip;

    @Column(name = "HRSTREET", columnDefinition = "VARCHAR2|户籍地址-村(街、路、弄等)||", length = 70, nullable = true)
    private String hrstreet;

    @Column(name = "HRHOUSE_NUMBER", columnDefinition = "VARCHAR2|户籍地址-门牌号码||", length = 70, nullable = true)
    private String hrhouseNumber;

    @Column(name = "PAPROVINCE", columnDefinition = "VARCHAR2|现住地址-省(自治区、直辖市)||", length = 70, nullable = true)
    private String paprovince;

    @Column(name = "PACITY", columnDefinition = "VARCHAR2|现住地址-市(地区、州)||", length = 70, nullable = true)
    private String pacity;

    @Column(name = "PACOUNTY", columnDefinition = "VARCHAR2|现住地址-县(区)||", length = 70, nullable = true)
    private String pacounty;

    @Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|现住地址-乡(镇、街道办事处)||", length = 70, nullable = true)
    private String patownShip;

    @Column(name = "PASTREET", columnDefinition = "VARCHAR2|现住地址-村(街、路、弄等)||", length = 70, nullable = true)
    private String pastreet;

    @Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|现住地址-门牌号码||", length = 70, nullable = true)
    private String pahouseNumber;

    @Column(name = "UAPROVINCE", columnDefinition = "VARCHAR2|工作单位地址-省(自治区、直辖市)||", length = 70, nullable = true)
    private String uaprovince;

    @Column(name = "UACITY", columnDefinition = "VARCHAR2|工作单位地址-市(地区、州)||", length = 70, nullable = true)
    private String uacity;

    @Column(name = "UACOUNTY", columnDefinition = "VARCHAR2|工作单位地址-县(区)||", length = 70, nullable = true)
    private String uacounty;

    @Column(name = "UATOWN_SHIP", columnDefinition = "VARCHAR2|工作单位地址-乡(镇、街道办事处)||", length = 70, nullable = true)
    private String uatownShip;

    @Column(name = "UASTREET", columnDefinition = "VARCHAR2|工作单位地址-村(街、路、弄等)||", length = 70, nullable = true)
    private String uastreet;

    @Column(name = "UAHOUSE_NUMBER", columnDefinition = "VARCHAR2|工作单位地址-门牌号码||", length = 70, nullable = true)
    private String uahouseNumber;

    @Column(name = "POST_CODE", columnDefinition = "VARCHAR2|邮政编码||", length = 6, nullable = true)
    private String postCode;

    @Column(name = "CLINIC_ORGAN_NAME", columnDefinition = "VARCHAR2|就诊机构名称||", length = 70, nullable = true)
    private String clinicOrganName;

    @Column(name = "CLINIC_DATE", columnDefinition = "TIMESTAMP|就诊日期时间||", nullable = true)
    private Date clinicDate;

    @Column(name = "INJURY_OCCUR_DATE", columnDefinition = "TIMESTAMP|伤害发生日期时间||", nullable = true)
    private Date injuryOccurDate;

    @Column(name = "INJURY_OCCUR_REASON_CODE", columnDefinition = "VARCHAR2|伤害发生原因代码||", length = 2, nullable = true)
    private String injuryOccurReasonCode;

    @Column(name = "INJURY_OCCUR_REASON_DESC", columnDefinition = "VARCHAR2|伤害发生原因其他描述||", length = 1000, nullable = true)
    private String injuryOccurReasonOtherDesc;

    @Column(name = "INJURY_OCCUR_ADDRESS", columnDefinition = "VARCHAR2|伤害发生地点代码||", length = 2, nullable = true)
    private String injuryOccurAddress;

    @Column(name = "INJURY_OCCUR_ADDRESS_DESC", columnDefinition = "VARCHAR2|伤害发生地点其他描述||", length = 1000, nullable = true)
    private String injuryOccurAddressOtherDesc;

    @Column(name = "INJURY_OCCUR_TYPE_CODE", columnDefinition = "VARCHAR2|伤害发生时活动类别代码||", length = 1, nullable = true)
    private String injuryOccurTypeCode;

    @Column(name = "INJURY_OCCUR_TYPE_OTHER_DESC", columnDefinition = "VARCHAR2|伤害发生时活动其他描述||", length = 1000, nullable = true)
    private String injuryOccurTypeOtherDesc;

    @Column(name = "INJURY_INTENTION_TYPE_CODE", columnDefinition = "VARCHAR2|伤害意图类别代码||", length = 1, nullable = true)
    private String injuryIntentionTypeCode;

    @Column(name = "INJURY_NATURE_CODE", columnDefinition = "VARCHAR2|伤害性质代码||", length = 2, nullable = true)
    private String injuryNatureCode;

    @Column(name = "INJURY_NATURE_OTHER_DESC", columnDefinition = "VARCHAR2|伤害性质其他描述||", length = 1000, nullable = true)
    private String injuryNatureOtherDesc;

    @Column(name = "INJURY_PART_CODE", columnDefinition = "VARCHAR2|伤害部位代码||", length = 2, nullable = true)
    private String injuryPartCode;

    @Column(name = "INJURY_PART_OTHER_DESC", columnDefinition = "VARCHAR2|伤害部位其他描述||", length = 1000, nullable = true)
    private String injuryPartOtherDesc;

    @Column(name = "INJURY_DIAGNOSIS_CODE", columnDefinition = "VARCHAR2|伤害诊断代码||", length = 5, nullable = true)
    private String injuryDiagnosisCode;

    @Column(name = "INJURY_DEGREE_CODE", columnDefinition = "VARCHAR2|伤害严重程度代码||", length = 1, nullable = true)
    private String injuryDegreeCode;

    @Column(name = "INJURY_RESULT", columnDefinition = "VARCHAR2|伤害结局||", length = 1, nullable = true)
    private String injuryResult;

    @Column(name = "INJURY_RESULT_OTHER_DESC", columnDefinition = "VARCHAR2|伤害结局其他描述||", length = 1000, nullable = true)
    private String injuryResultOtherDesc;

    @Column(name = "INJURY_PROGNOSIS_CODE", columnDefinition = "VARCHAR2|伤害转归代码||", length = 1, nullable = true)
    private String injuryPrognosisCode;

    @Column(name = "FILL_USER_NAME", columnDefinition = "VARCHAR2|填报人姓名||", length = 50, nullable = true)
    private String fillUserName;

    @Column(name = "FILL_DATE", columnDefinition = "DATE|填报日期||", nullable = true)
    private Date fillDate;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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

    public String getMonitoringHospitalNo() {
        return this.monitoringHospitalNo;
    }

    public void setMonitoringHospitalNo(String monitoringHospitalNo) {
        this.monitoringHospitalNo = monitoringHospitalNo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCardType() {
        return this.idCardType;
    }

    public void setIdCardType(String idCardType) {
        this.idCardType = idCardType;
    }

    public String getIdCard() {
        return this.idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEducation() {
        return this.education;
    }

    public void setEducation(String education) {
        this.education = education;
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

    public String getPostCode() {
        return this.postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getClinicOrganName() {
        return this.clinicOrganName;
    }

    public void setClinicOrganName(String clinicOrganName) {
        this.clinicOrganName = clinicOrganName;
    }

    public Date getClinicDate() {
        return this.clinicDate;
    }

    public void setClinicDate(Date clinicDate) {
        this.clinicDate = clinicDate;
    }

    public Date getInjuryOccurDate() {
        return this.injuryOccurDate;
    }

    public void setInjuryOccurDate(Date injuryOccurDate) {
        this.injuryOccurDate = injuryOccurDate;
    }

    public String getInjuryOccurReasonCode() {
        return this.injuryOccurReasonCode;
    }

    public void setInjuryOccurReasonCode(String injuryOccurReasonCode) {
        this.injuryOccurReasonCode = injuryOccurReasonCode;
    }

    public String getInjuryOccurReasonOtherDesc() {
        return this.injuryOccurReasonOtherDesc;
    }

    public void setInjuryOccurReasonOtherDesc(String injuryOccurReasonOtherDesc) {
        this.injuryOccurReasonOtherDesc = injuryOccurReasonOtherDesc;
    }

    public String getInjuryOccurAddress() {
        return this.injuryOccurAddress;
    }

    public void setInjuryOccurAddress(String injuryOccurAddress) {
        this.injuryOccurAddress = injuryOccurAddress;
    }

    public String getInjuryOccurAddressOtherDesc() {
        return this.injuryOccurAddressOtherDesc;
    }

    public void setInjuryOccurAddressOtherDesc(String injuryOccurAddressOtherDesc) {
        this.injuryOccurAddressOtherDesc = injuryOccurAddressOtherDesc;
    }

    public String getInjuryOccurTypeCode() {
        return this.injuryOccurTypeCode;
    }

    public void setInjuryOccurTypeCode(String injuryOccurTypeCode) {
        this.injuryOccurTypeCode = injuryOccurTypeCode;
    }

    public String getInjuryOccurTypeOtherDesc() {
        return this.injuryOccurTypeOtherDesc;
    }

    public void setInjuryOccurTypeOtherDesc(String injuryOccurTypeOtherDesc) {
        this.injuryOccurTypeOtherDesc = injuryOccurTypeOtherDesc;
    }

    public String getInjuryIntentionTypeCode() {
        return this.injuryIntentionTypeCode;
    }

    public void setInjuryIntentionTypeCode(String injuryIntentionTypeCode) {
        this.injuryIntentionTypeCode = injuryIntentionTypeCode;
    }

    public String getInjuryNatureCode() {
        return this.injuryNatureCode;
    }

    public void setInjuryNatureCode(String injuryNatureCode) {
        this.injuryNatureCode = injuryNatureCode;
    }

    public String getInjuryNatureOtherDesc() {
        return this.injuryNatureOtherDesc;
    }

    public void setInjuryNatureOtherDesc(String injuryNatureOtherDesc) {
        this.injuryNatureOtherDesc = injuryNatureOtherDesc;
    }

    public String getInjuryPartCode() {
        return this.injuryPartCode;
    }

    public void setInjuryPartCode(String injuryPartCode) {
        this.injuryPartCode = injuryPartCode;
    }

    public String getInjuryPartOtherDesc() {
        return this.injuryPartOtherDesc;
    }

    public void setInjuryPartOtherDesc(String injuryPartOtherDesc) {
        this.injuryPartOtherDesc = injuryPartOtherDesc;
    }

    public String getInjuryDiagnosisCode() {
        return this.injuryDiagnosisCode;
    }

    public void setInjuryDiagnosisCode(String injuryDiagnosisCode) {
        this.injuryDiagnosisCode = injuryDiagnosisCode;
    }

    public String getInjuryDegreeCode() {
        return this.injuryDegreeCode;
    }

    public void setInjuryDegreeCode(String injuryDegreeCode) {
        this.injuryDegreeCode = injuryDegreeCode;
    }

    public String getInjuryResult() {
        return this.injuryResult;
    }

    public void setInjuryResult(String injuryResult) {
        this.injuryResult = injuryResult;
    }

    public String getInjuryResultOtherDesc() {
        return this.injuryResultOtherDesc;
    }

    public void setInjuryResultOtherDesc(String injuryResultOtherDesc) {
        this.injuryResultOtherDesc = injuryResultOtherDesc;
    }

    public String getInjuryPrognosisCode() {
        return this.injuryPrognosisCode;
    }

    public void setInjuryPrognosisCode(String injuryPrognosisCode) {
        this.injuryPrognosisCode = injuryPrognosisCode;
    }

    public String getFillUserName() {
        return this.fillUserName;
    }

    public void setFillUserName(String fillUserName) {
        this.fillUserName = fillUserName;
    }

    public Date getFillDate() {
        return this.fillDate;
    }

    public void setFillDate(Date fillDate) {
        this.fillDate = fillDate;
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

}
