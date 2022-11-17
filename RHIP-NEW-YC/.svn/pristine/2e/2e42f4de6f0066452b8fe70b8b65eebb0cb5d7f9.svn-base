package com.founder.rhip.ehr.entity.control;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "SR_DC_INFECTION_DISEASE_REPORT")
public class InfectionDiseaseReport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "SMPI_ID", columnDefinition = "VARCHAR2|PIX号||", length = 50, nullable = true)
    private String smpiId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|传染病报告卡编号||", length = 20, nullable = false)
    private String recordNumber;

    @Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号||", length = 17, scale = 4, precision = 1, nullable = true)
    private String healthFileNo;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|本人姓名||", length = 50, nullable = true)
    private String name;

    @Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
    private Date birthday;

    @Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|本人电话号码||", length = 20, nullable = true)
    private String phoneNumber;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证件号码||", length = 18, nullable = true)
    private String idCard;

    @Column(name = "IDCARD_TYPE", columnDefinition = "VARCHAR2|身份证件类别代码||", length = 2, nullable = true)
    private String idCardType;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别代码||", length = 1, nullable = true)
    private String gender;

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

    @Column(name = "PARENTS_NAME", columnDefinition = "VARCHAR2|家长姓名||", length = 50, nullable = true)
    private String parentsName;

    @Column(name = "FAMILY_PHONE", columnDefinition = "VARCHAR2|家人电话号码||", length = 20, nullable = true)
    private String familyPhone;

    @Column(name = "REPORT_DOCTOR_NAME", columnDefinition = "VARCHAR2|报告医师姓名||", length = 50, nullable = true)
    private String reportDoctorName;

    @Column(name = "REPORT_CARD_TYPE_CODE", columnDefinition = "VARCHAR2|报卡类别代码||", length = 1, nullable = true)
    private String reportCardTypeCode;

    @Column(name = "BACK_CARD_CAUSE", columnDefinition = "VARCHAR2|退卡原因||", length = 100, nullable = true)
    private String backCardCause;

    @Column(name = "INFECTIOUS_ATTACK_TYPE", columnDefinition = "VARCHAR2|传染病发病类别代码||", length = 1, nullable = true)
    private String infectiousAttackType;

    @Column(name = "INFECTEDPERSON_BELONG", columnDefinition = "VARCHAR2|传染病患者属于代码||", length = 1, nullable = true)
    private String infectedpersonBelong;

    @Column(name = "INFECTEDPERSON_OCCUPATION", columnDefinition = "VARCHAR2|传染病患者职业代码||", length = 3, nullable = true)
    private String infectedpersonOccupation;

    @Column(name = "INFECTIOUS_TYPE", columnDefinition = "VARCHAR2|传染病类别代码||", length = 1, nullable = true)
    private String infectiousType;

    @Column(name = "INFECTIOUS_NAME", columnDefinition = "VARCHAR2|传染病名称代码||", length = 1, nullable = true)
    private String infectiousName;

    @Column(name = "AMEND_NAME", columnDefinition = "VARCHAR2|订正病名||", length = 70, nullable = true)
    private String amendName;

    @Column(name = "AMEND_DIAGNOSE", columnDefinition = "VARCHAR2|订正诊断||", length = 70, nullable = true)
    private String amendDiagnose;

    @Column(name = "OTHER_INFECTIOUS_NAME", columnDefinition = "VARCHAR2|其他法定管理以及重点监测传染病名称||", length = 20, nullable = true)
    private String otherInfectiousName;

    @Column(name = "FIRST_SYMPTOMS_DATE", columnDefinition = "DATE|首次出现症状日期||", nullable = true)
    private Date firstSymptomsDate;

    @Column(name = "DIAGNOSIS_STATUS", columnDefinition = "VARCHAR2|诊断状态代码||", length = 1, nullable = true)
    private String diagnosisStatus;

    @Column(name = "DIAGNOSIS_DATE", columnDefinition = "DATE|诊断日期||", nullable = true)
    private Date diagnosisDate;

    @Column(name = "DEATH_DATE", columnDefinition = "DATE|死亡日期||", nullable = true)
    private Date deathDate;

    @Column(name = "FILL_ORGAN_PHONE", columnDefinition = "VARCHAR2|填报机构电话号码||", length = 20, nullable = true)
    private String fillOrganPhone;

    @Column(name = "FILL_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 70, nullable = true)
    private String fillOrganName;

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

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdCard() {
        return this.idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIdCardType() {
        return this.idCardType;
    }

    public void setIdCardType(String idCardType) {
        this.idCardType = idCardType;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getParentsName() {
        return this.parentsName;
    }

    public void setParentsName(String parentsName) {
        this.parentsName = parentsName;
    }

    public String getFamilyPhone() {
        return this.familyPhone;
    }

    public void setFamilyPhone(String familyPhone) {
        this.familyPhone = familyPhone;
    }

    public String getReportDoctorName() {
        return this.reportDoctorName;
    }

    public void setReportDoctorName(String reportDoctorName) {
        this.reportDoctorName = reportDoctorName;
    }

    public String getReportCardTypeCode() {
        return this.reportCardTypeCode;
    }

    public void setReportCardTypeCode(String reportCardTypeCode) {
        this.reportCardTypeCode = reportCardTypeCode;
    }

    public String getBackCardCause() {
        return this.backCardCause;
    }

    public void setBackCardCause(String backCardCause) {
        this.backCardCause = backCardCause;
    }

    public String getInfectiousAttackType() {
        return this.infectiousAttackType;
    }

    public void setInfectiousAttackType(String infectiousAttackType) {
        this.infectiousAttackType = infectiousAttackType;
    }

    public String getInfectedpersonBelong() {
        return this.infectedpersonBelong;
    }

    public void setInfectedpersonBelong(String infectedpersonBelong) {
        this.infectedpersonBelong = infectedpersonBelong;
    }

    public String getInfectedpersonOccupation() {
        return this.infectedpersonOccupation;
    }

    public void setInfectedpersonOccupation(String infectedpersonOccupation) {
        this.infectedpersonOccupation = infectedpersonOccupation;
    }

    public String getInfectiousType() {
        return this.infectiousType;
    }

    public void setInfectiousType(String infectiousType) {
        this.infectiousType = infectiousType;
    }

    public String getInfectiousName() {
        return this.infectiousName;
    }

    public void setInfectiousName(String infectiousName) {
        this.infectiousName = infectiousName;
    }

    public String getAmendName() {
        return this.amendName;
    }

    public void setAmendName(String amendName) {
        this.amendName = amendName;
    }

    public String getAmendDiagnose() {
        return this.amendDiagnose;
    }

    public void setAmendDiagnose(String amendDiagnose) {
        this.amendDiagnose = amendDiagnose;
    }

    public String getOtherInfectiousName() {
        return this.otherInfectiousName;
    }

    public void setOtherInfectiousName(String otherInfectiousName) {
        this.otherInfectiousName = otherInfectiousName;
    }

    public Date getFirstSymptomsDate() {
        return this.firstSymptomsDate;
    }

    public void setFirstSymptomsDate(Date firstSymptomsDate) {
        this.firstSymptomsDate = firstSymptomsDate;
    }

    public String getDiagnosisStatus() {
        return this.diagnosisStatus;
    }

    public void setDiagnosisStatus(String diagnosisStatus) {
        this.diagnosisStatus = diagnosisStatus;
    }

    public Date getDiagnosisDate() {
        return this.diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public Date getDeathDate() {
        return this.deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public String getFillOrganPhone() {
        return this.fillOrganPhone;
    }

    public void setFillOrganPhone(String fillOrganPhone) {
        this.fillOrganPhone = fillOrganPhone;
    }

    public String getFillOrganName() {
        return this.fillOrganName;
    }

    public void setFillOrganName(String fillOrganName) {
        this.fillOrganName = fillOrganName;
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
