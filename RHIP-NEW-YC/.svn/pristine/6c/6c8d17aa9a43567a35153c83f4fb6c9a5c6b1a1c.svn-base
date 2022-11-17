package com.founder.rhip.ehr.entity.control;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "DC_PESTICIDE_POISONING_REPORT")
public class PesticidePoisoningReport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "SMPI_ID", columnDefinition = "VARCHAR2|PIX号||", length = 50, nullable = true)
    private String smpiId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号||", length = 17, nullable = true)
    private String healthFileNo;

    @Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|中毒报告卡编码||", length = 20, nullable = true)
    private String recordNumber;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|本人姓名||", length = 50, nullable = true)
    private String name;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别代码||", length = 1, nullable = true)
    private String gender;

    @Column(name = "IDCARD_TYPE", columnDefinition = "VARCHAR2|身份证件类别代码||", length = 2, nullable = true)
    private String idCardType;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证件号码||", length = 18, nullable = true)
    private String idCard;

    @Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
    private Date birthday;

    @Column(name = "AREA_CODE", columnDefinition = "VARCHAR2|行政区划代码||", length = 6, nullable = true)
    private String areaCode;

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

    @Column(name = "DIAGNOSIS_DATE", columnDefinition = "DATE|诊断日期||", nullable = true)
    private Date diagnosisDate;

    @Column(name = "PESTICIDES_NAME_CODE", columnDefinition = "VARCHAR2|中毒农药名称代码||", length = 2, nullable = true)
    private String pesticidesNameCode;

    @Column(name = "PESTICIDES_TYPE_CODE", columnDefinition = "VARCHAR2|农药中毒原因类型代码||", length = 1, nullable = true)
    private String pesticidesTypeCode;

    @Column(name = "PESTICIDES_PROGNOSIS_CODE", columnDefinition = "VARCHAR2|农药中毒转归代码||", length = 1, nullable = true)
    private String pesticidesPrognosisCode;

    @Column(name = "DEATH_DATE", columnDefinition = "TIMESTAMP|死亡日期时间||", nullable = true)
    private Date deathDate;

    @Column(name = "FILL_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 70, nullable = true)
    private String fillOrganName;

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

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAreaCode() {
        return this.areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
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

    public Date getDiagnosisDate() {
        return this.diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public String getPesticidesNameCode() {
        return this.pesticidesNameCode;
    }

    public void setPesticidesNameCode(String pesticidesNameCode) {
        this.pesticidesNameCode = pesticidesNameCode;
    }

    public String getPesticidesTypeCode() {
        return this.pesticidesTypeCode;
    }

    public void setPesticidesTypeCode(String pesticidesTypeCode) {
        this.pesticidesTypeCode = pesticidesTypeCode;
    }

    public String getPesticidesPrognosisCode() {
        return this.pesticidesPrognosisCode;
    }

    public void setPesticidesPrognosisCode(String pesticidesPrognosisCode) {
        this.pesticidesPrognosisCode = pesticidesPrognosisCode;
    }

    public Date getDeathDate() {
        return this.deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
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
