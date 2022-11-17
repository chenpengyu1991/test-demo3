package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "BI_ORGANIZATION_STAFF")
public class OrganizationStaff implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "GBCODE", columnDefinition = "VARCHAR2|12位行政区划代码||", length = 12, nullable = true)
    private String gBCode;

    @Column(name = "ZONE_GBCODE", columnDefinition = "VARCHAR2|10位行政区划代码||", length = 10, nullable = true)
    private String zoneGBCode;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|职工姓名||", length = 50, nullable = true)
    private String name;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|职工身份证号||", length = 18, nullable = true)
    private String idcard;

    @Column(name = "WORK_CARD_ID", columnDefinition = "VARCHAR2|工作证号||", length = 20, nullable = true)
    private String workCardId;

    @Column(name = "CARD_NUM", columnDefinition = "VARCHAR2|胸牌号||", length = 20, nullable = true)
    private String cardNum;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别代码||", length = 1, nullable = true)
    private String gender;

    @Column(name = "BIRTHDAY", columnDefinition = "DATE|职工生日||", nullable = true)
    private Date birthday;

    @Column(name = "NATION_CODE", columnDefinition = "VARCHAR2|职工民族编码||", length = 2, nullable = true)
    private String nationCode;

    @Column(name = "FAPROVINCE", columnDefinition = "VARCHAR2|职工家庭地址-省(自治区、直辖市)||", length = 70, nullable = true)
    private String faprovince;

    @Column(name = "FACITY", columnDefinition = "VARCHAR2|职工家庭地址-市(地区、州)||", length = 70, nullable = true)
    private String facity;

    @Column(name = "FACOUNTY", columnDefinition = "VARCHAR2|职工家庭地址-县(区)||", length = 70, nullable = true)
    private String facounty;

    @Column(name = "FATOWN_SHIP", columnDefinition = "VARCHAR2|职工家庭地址-乡(镇、街道办事处)||", length = 70, nullable = true)
    private String fatownShip;

    @Column(name = "FASTREET", columnDefinition = "VARCHAR2|职工家庭地址-村(街、路、弄等)||", length = 70, nullable = true)
    private String fastreet;

    @Column(name = "FAHOUSE_NUMBER", columnDefinition = "VARCHAR2|职工家庭地址-门牌号码||", length = 70, nullable = true)
    private String fahouseNumber;

    @Column(name = "FAPOST_CODE", columnDefinition = "VARCHAR2|职工家庭地址地区邮政编码||", length = 6, nullable = true)
    private String fapostCode;

    @Column(name = "HOME_PHONE", columnDefinition = "VARCHAR2|职工住宅电话||", length = 20, nullable = true)
    private String homePhone;

    @Column(name = "MOBILE", columnDefinition = "VARCHAR2|职工手机||", length = 20, nullable = true)
    private String mobile;

    @Column(name = "MAIL", columnDefinition = "VARCHAR2|电子邮箱||", length = 70, nullable = true)
    private String mail;

    @Column(name = "UNIVERSITY", columnDefinition = "VARCHAR2|毕业学校||", length = 70, nullable = true)
    private String university;

    @Column(name = "GRADUATE_DATE", columnDefinition = "DATE|毕业日期||", nullable = true)
    private Date graduateDate;

    @Column(name = "SPECIALITY_TEXT", columnDefinition = "VARCHAR2|所学专业名称||", length = 70, nullable = true)
    private String specialityText;

    @Column(name = "EDUCATION", columnDefinition = "VARCHAR2|最高学历代码||", length = 1, nullable = true)
    private String education;

    @Column(name = "DEGREE", columnDefinition = "VARCHAR2|最高学位代码||", length = 1, nullable = true)
    private String degree;

    @Column(name = "PARTY", columnDefinition = "VARCHAR2|党派编码||", length = 2, nullable = true)
    private String party;

    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况代码||", length = 1, nullable = true)
    private String marriage;

    @Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|所在机构编码||", length = 15, nullable = true)
    private String organCode;

    @Column(name = "DEPARTMENT_CODE", columnDefinition = "VARCHAR2|所在科室编码||", length = 5, nullable = true)
    private String departmentCode;

    @Column(name = "TYPE", columnDefinition = "VARCHAR2|职工分类标志||", length = 1, nullable = true)
    private String type;

    @Column(name = "WORK", columnDefinition = "VARCHAR2|从事工种||", length = 70, nullable = true)
    private String work;

    @Column(name = "TECHNICAL", columnDefinition = "VARCHAR2|职称级别代码||", length = 1, nullable = true)
    private String technical;

    @Column(name = "TECHNICAL_TEXT", columnDefinition = "VARCHAR2|职称名称||", length = 30, nullable = true)
    private String technicalText;

    @Column(name = "BUSINESS", columnDefinition = "VARCHAR2|职务等级||", length = 2, nullable = true)
    private String business;

    @Column(name = "BUSINESS_NAME", columnDefinition = "VARCHAR2|职务名称||", length = 30, nullable = true)
    private String businessName;

    @Column(name = "OFFICE_TEL", columnDefinition = "VARCHAR2|办公室电话||", length = 20, nullable = true)
    private String officeTel;

    @Column(name = "OFFICE_FAX", columnDefinition = "VARCHAR2|办公室传真||", length = 20, nullable = true)
    private String officeFax;

    @Column(name = "START_WORK_DATE", columnDefinition = "DATE|参加工作日期||", nullable = true)
    private Date startWorkDate;

    @Column(name = "ORG_WORK_DATE", columnDefinition = "DATE|到本单位日期||", nullable = true)
    private Date orgWorkDate;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getGBCode() {
        return this.gBCode;
    }

    public void setGBCode(String gBCode) {
        this.gBCode = gBCode;
    }

    public String getZoneGBCode() {
        return this.zoneGBCode;
    }

    public void setZoneGBCode(String zoneGBCode) {
        this.zoneGBCode = zoneGBCode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdcard() {
        return this.idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getWorkCardId() {
        return this.workCardId;
    }

    public void setWorkCardId(String workCardId) {
        this.workCardId = workCardId;
    }

    public String getCardNum() {
        return this.cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
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

    public String getNationCode() {
        return this.nationCode;
    }

    public void setNationCode(String nationCode) {
        this.nationCode = nationCode;
    }

    public String getFaprovince() {
        return this.faprovince;
    }

    public void setFaprovince(String faprovince) {
        this.faprovince = faprovince;
    }

    public String getFacity() {
        return this.facity;
    }

    public void setFacity(String facity) {
        this.facity = facity;
    }

    public String getFacounty() {
        return this.facounty;
    }

    public void setFacounty(String facounty) {
        this.facounty = facounty;
    }

    public String getFatownShip() {
        return this.fatownShip;
    }

    public void setFatownShip(String fatownShip) {
        this.fatownShip = fatownShip;
    }

    public String getFastreet() {
        return this.fastreet;
    }

    public void setFastreet(String fastreet) {
        this.fastreet = fastreet;
    }

    public String getFahouseNumber() {
        return this.fahouseNumber;
    }

    public void setFahouseNumber(String fahouseNumber) {
        this.fahouseNumber = fahouseNumber;
    }

    public String getFapostCode() {
        return this.fapostCode;
    }

    public void setFapostCode(String fapostCode) {
        this.fapostCode = fapostCode;
    }

    public String getHomePhone() {
        return this.homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUniversity() {
        return this.university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Date getGraduateDate() {
        return this.graduateDate;
    }

    public void setGraduateDate(Date graduateDate) {
        this.graduateDate = graduateDate;
    }

    public String getSpecialityText() {
        return this.specialityText;
    }

    public void setSpecialityText(String specialityText) {
        this.specialityText = specialityText;
    }

    public String getEducation() {
        return this.education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDegree() {
        return this.degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getParty() {
        return this.party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getMarriage() {
        return this.marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getOrganCode() {
        return this.organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    public String getDepartmentCode() {
        return this.departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWork() {
        return this.work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getTechnical() {
        return this.technical;
    }

    public void setTechnical(String technical) {
        this.technical = technical;
    }

    public String getTechnicalText() {
        return this.technicalText;
    }

    public void setTechnicalText(String technicalText) {
        this.technicalText = technicalText;
    }

    public String getBusiness() {
        return this.business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getBusinessName() {
        return this.businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getOfficeTel() {
        return this.officeTel;
    }

    public void setOfficeTel(String officeTel) {
        this.officeTel = officeTel;
    }

    public String getOfficeFax() {
        return this.officeFax;
    }

    public void setOfficeFax(String officeFax) {
        this.officeFax = officeFax;
    }

    public Date getStartWorkDate() {
        return this.startWorkDate;
    }

    public void setStartWorkDate(Date startWorkDate) {
        this.startWorkDate = startWorkDate;
    }

    public Date getOrgWorkDate() {
        return this.orgWorkDate;
    }

    public void setOrgWorkDate(Date orgWorkDate) {
        this.orgWorkDate = orgWorkDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
