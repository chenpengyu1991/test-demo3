package com.founder.rhip.ehr.entity.clinic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yuanzg on 2017/2/21.
 */
@Entity
@Table(name = "EXCEL_TO_DB")
public class ExcelToDB implements Serializable{
    private static final long serialVersionUID = 1L;

    @Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|档案编号|25|", length = 25, nullable = true)
    private String healthFileNo;
    @Column(name = "NAME", columnDefinition = "VARCHAR2|名字|100|", length = 100, nullable = true)
    private String name;
    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别|5|", length = 5, nullable = true)
    private String gender;
    @Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
    private Date birthday;
    @Column(name = "ID_CARD", columnDefinition = "VARCHAR2|身份证|20|", length = 20, nullable = true)
    private String idCard;
    @Column(name = "NATION", columnDefinition = "VARCHAR2|民族|20|", length = 20, nullable = true)
    private String nation;
    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况|20|", length = 20, nullable = true)
    private String marriage;
    @Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|电话号码|20|", length = 20, nullable = true)
    private String phoneNumber;
    @Column(name = "HOME_PHONE", columnDefinition = "VARCHAR2|联系人号码|20|", length = 20, nullable = true)
    private String homePhone;
    @Column(name = "INPUT_DATE", columnDefinition = "DATE|建档日期|20|", length = 20, nullable = true)
    private Date inputDate;
    @Column(name = "HOUSEHOLD_TYPE", columnDefinition = "VARCHAR2|户籍|20|", length = 20, nullable = true)
    private String householdType;
    @Column(name = "ADDRESS", columnDefinition = "VARCHAR2|住址|100|", length = 100, nullable = true)
    private String address;
    @Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|机构编码|20|", length = 20, nullable = true)
    private String organCode;
    @Column(name = "PATOWNSHIPCODE", columnDefinition = "VARCHAR2|住址区编码|20|", length = 20, nullable = true)
    private String paTownshipCode;
    @Column(name = "PASTREETCODE", columnDefinition = "VARCHAR2|居委会编码|20|", length = 20, nullable = true)
    private String paStreetCode;
    @Column(name = "PATOWNSHIPNAME", columnDefinition = "VARCHAR2|住址区名称|20|", length = 20, nullable = true)
    private String paTownshipName;
    @Column(name = "PASTREETNAME", columnDefinition = "VARCHAR2|居委会名称|20|", length = 20, nullable = true)
    private String paStreetName;

    public String getHealthFileNo() {
        return healthFileNo;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getNation() {
        return nation;
    }

    public String getMarriage() {
        return marriage;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public String getHouseholdType() {
        return householdType;
    }

    public String getAddress() {
        return address;
    }

    public String getOrganCode() {
        return organCode;
    }

    public String getPaTownshipCode() {
        return paTownshipCode;
    }

    public String getPaStreetCode() {
        return paStreetCode;
    }

    public String getPaTownshipName() {
        return paTownshipName;
    }

    public String getPaStreetName() {
        return paStreetName;
    }

    public void setHealthFileNo(String healthFileNo) {
        this.healthFileNo = healthFileNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public void setHouseholdType(String householdType) {
        this.householdType = householdType;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    public void setPaTownshipCode(String paTownshipCode) {
        this.paTownshipCode = paTownshipCode;
    }

    public void setPaStreetCode(String paStreetCode) {
        this.paStreetCode = paStreetCode;
    }

    public void setPaTownshipName(String paTownshipName) {
        this.paTownshipName = paTownshipName;
    }

    public void setPaStreetName(String paStreetName) {
        this.paStreetName = paStreetName;
    }
}
