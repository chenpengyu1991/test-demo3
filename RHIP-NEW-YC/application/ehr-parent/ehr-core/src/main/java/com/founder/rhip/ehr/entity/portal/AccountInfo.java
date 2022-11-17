package com.founder.rhip.ehr.entity.portal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ACCOUNT_INFO")
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlTransient
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长id|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "ACCOUNT_NAME", columnDefinition = "VARCHAR2|账户名称|50|", length = 50, nullable = true)
	private String accountName;

	@Column(name = "EMAIL", columnDefinition = "VARCHAR2|电子邮箱|50|", length = 50, nullable = true)
	private String email;

	@Column(name = "TELEPHONE", columnDefinition = "VARCHAR2|手机号码|18|", length = 18, nullable = true)
	private String telephone;

	@Column(name = "PASSWORD", columnDefinition = "VARCHAR2|登陆密码|50|", length = 50, nullable = true)
	private String password;

	@Column(name = "CARD_NO", columnDefinition = "VARCHAR2|身份证号|50|", length = 50, nullable = true)
	private String cardNo;

	@Column(name = "STATUS", columnDefinition = "VARCHAR2|状态|启用：0 禁用：1|", length = 1, nullable = true)
	private String status;

	@Column(name = "CHECK_PER", columnDefinition = "VARCHAR2|审核人|20|", length = 20, nullable = true)
	private String checkPer;

	@XmlTransient
	@Column(name = "CHECK_DATE", columnDefinition = "DATE|审核时间||", nullable = true)
	private Date checkDate;

	@Column(name = "REAL_NAME", columnDefinition = "VARCHAR2|姓名|20|", length = 20, nullable = true)
	private String realName;

	@Column(name = "PASTREET", columnDefinition = "VARCHAR2|现住址-村(街、路、弄等)|20|", length = 20, nullable = true)
	private String pastreet;

	@Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|现住址-乡(镇、街道办事处)|20|", length = 20, nullable = true)
	private String patownShip;

	@Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|现住址-门牌号码|20|", length = 20, nullable = true)
	private String pahouseNumber;

	@Column(name = "HRSTREET", columnDefinition = "VARCHAR2|户籍地址-村(街、路、弄等)|20|", length = 20, nullable = true)
	private String hrstreet;

	@Column(name = "HRTOWN_SHIP", columnDefinition = "VARCHAR2|户籍地址-乡(镇、街道办事处)|20|", length = 20, nullable = true)
	private String hrtownShip;

	@Column(name = "HRHOUSE_NUMBER", columnDefinition = "VARCHAR2|户籍地址-门牌号码|20|", length = 20, nullable = true)
	private String hrhouseNumber;

	@Column(name = "HOUSEHOLD_TYPE", columnDefinition = "VARCHAR2|常住类型|20|", length = 20, nullable = true)
	private String householdType;

	@XmlTransient
	@Column(name = "RESERVE_STATUS", columnDefinition = "VARCHAR2|预约功能开启状态 0：禁用 1：可用|20|", length = 20, nullable = true)
	private String reserveStatus = "1";
	
	@XmlTransient
	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|是否删除|1|", length = 1, nullable = true)
	private Integer isDelete = 0;
	
	@XmlTransient
	@Column(name = "ACTIVATE_STATUS", columnDefinition = "VARCHAR2|激活状态|1|", length = 1, nullable = true)
	private String activateStatus = "0";

	@XmlTransient
	@Column(name = "IS_READ_INFORM", columnDefinition = "VARCHAR2|是否已经阅读告知书|2|", length = 1, nullable = true)
	private String isReadInform = "0";

	private String checkCode;//注册时候的验证码
	
	/*带星号手机号*/
	private String phoneWithStar;
	
	/*带星号邮箱*/
	private String emailWithStar;
	
	/*带星号邮箱*/
	private String oldPassword;

	
	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getPhoneWithStar() {
		return phoneWithStar;
	}

	public void setPhoneWithStar(String phoneWithStar) {
		this.phoneWithStar = phoneWithStar;
	}

	public String getEmailWithStar() {
		return emailWithStar;
	}

	public void setEmailWithStar(String emailWithStar) {
		this.emailWithStar = emailWithStar;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCheckPer() {
		return this.checkPer;
	}

	public void setCheckPer(String checkPer) {
		this.checkPer = checkPer;
	}

	public Date getCheckDate() {
		return this.checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPastreet() {
		return this.pastreet;
	}

	public void setPastreet(String pastreet) {
		this.pastreet = pastreet;
	}

	public String getPatownShip() {
		return this.patownShip;
	}

	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}

	public String getPahouseNumber() {
		return this.pahouseNumber;
	}

	public void setPahouseNumber(String pahouseNumber) {
		this.pahouseNumber = pahouseNumber;
	}

	public String getHrstreet() {
		return this.hrstreet;
	}

	public void setHrstreet(String hrstreet) {
		this.hrstreet = hrstreet;
	}

	public String getHrtownShip() {
		return this.hrtownShip;
	}

	public void setHrtownShip(String hrtownShip) {
		this.hrtownShip = hrtownShip;
	}

	public String getHrhouseNumber() {
		return this.hrhouseNumber;
	}

	public void setHrhouseNumber(String hrhouseNumber) {
		this.hrhouseNumber = hrhouseNumber;
	}

	public String getHouseholdType() {
		return this.householdType;
	}

	public void setHouseholdType(String householdType) {
		this.householdType = householdType;
	}

	public String getReserveStatus() {
		return this.reserveStatus;
	}

	public void setReserveStatus(String reserveStatus) {
		this.reserveStatus = reserveStatus;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public String getActivateStatus() {
		return activateStatus;
	}

	public void setActivateStatus(String activateStatus) {
		this.activateStatus = activateStatus;
	}

	public String getIsReadInform() {
		return isReadInform;
	}

	public void setIsReadInform(String isReadInform) {
		this.isReadInform = isReadInform;
	}
}