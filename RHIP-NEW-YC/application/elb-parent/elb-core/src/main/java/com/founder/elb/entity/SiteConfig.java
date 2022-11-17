package com.founder.elb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SITE_CONFIG")
public class SiteConfig implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|参数标识|5|", length = 5, nullable = false)
	private Integer id;

	@Column(name = "ORG_ID", columnDefinition = "NUMBER|机构标识|5|", length = 5, nullable = true)
	private Integer orgId;

	@Column(name = "SYSTEM_NAME", columnDefinition = "VARCHAR2|系统名称|50|", length = 50, nullable = true)
	private String systemName;

	@Column(name = "SYSTEM_LOGO", columnDefinition = "VARCHAR2|系统图标|200|", length = 200, nullable = true)
	private String systemLogo;

	@Column(name = "SEND_EMAIL_ADDRESS", columnDefinition = "VARCHAR2|邮件发送email账号|50|", length = 50, nullable = true)
	private String sendEmailAddress;

	@Column(name = "SEND_EMAIL_PASSWORD", columnDefinition = "VARCHAR2|邮件发送密码|20|", length = 20, nullable = true)
	private String sendEmailPassword;

	@Column(name = "SEND_EMAIL_SMTP", columnDefinition = "VARCHAR2|邮件SMTP地址|100|", length = 100, nullable = true)
	private String sendEmailSmtp;

	@Column(name = "EMPI_SERVER_URL", columnDefinition = "VARCHAR2|EMPI服务器地址|100|", length = 100, nullable = true)
	private String empiServerUrl;

	@Column(name = "SMS_SERVER_URL", columnDefinition = "VARCHAR2|短信服务地址|200|", length = 200, nullable = true)
	private String smsServerUrl;

	@Column(name = "COPYRIGHT", columnDefinition = "VARCHAR2|版权|200|", length = 200, nullable = true)
	private String copyright;

	@Column(name = "STATUS", columnDefinition = "NUMBER|是否可用|1|", length = 1, nullable = true)
	private Integer status;

	@Column(name = "SEND_EMAIL_AUTH", columnDefinition = "VARCHAR2|邮件验证|10|", length = 10, nullable = true)
	private String mailSmtpAuth;

	@Column(name = "SEND_EMAIL_PORT", columnDefinition = "VARCHAR2|邮件端口|6|", length = 6, nullable = true)
	private String mailSmtpPort;

	@Column(name = "SMS_DB_NAME", columnDefinition = "VARCHAR2|短信数据库名称|200|", length = 200, nullable = false)
	private String smsDbName;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getSystemName() {
		return this.systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getSystemLogo() {
		return this.systemLogo;
	}

	public void setSystemLogo(String systemLogo) {
		this.systemLogo = systemLogo;
	}

	public String getSendEmailAddress() {
		return this.sendEmailAddress;
	}

	public void setSendEmailAddress(String sendEmailAddress) {
		this.sendEmailAddress = sendEmailAddress;
	}

	public String getSendEmailPassword() {
		return this.sendEmailPassword;
	}

	public void setSendEmailPassword(String sendEmailPassword) {
		this.sendEmailPassword = sendEmailPassword;
	}

	public String getSendEmailSmtp() {
		return this.sendEmailSmtp;
	}

	public void setSendEmailSmtp(String sendEmailSmtp) {
		this.sendEmailSmtp = sendEmailSmtp;
	}

	public String getEmpiServerUrl() {
		return this.empiServerUrl;
	}

	public void setEmpiServerUrl(String empiServerUrl) {
		this.empiServerUrl = empiServerUrl;
	}

	public String getSmsServerUrl() {
		return this.smsServerUrl;
	}

	public void setSmsServerUrl(String smsServerUrl) {
		this.smsServerUrl = smsServerUrl;
	}

	public String getCopyright() {
		return this.copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMailSmtpAuth() {
		return this.mailSmtpAuth;
	}

	public void setMailSmtpAuth(String mailSmtpAuth) {
		this.mailSmtpAuth = mailSmtpAuth;
	}

	public String getMailSmtpPort() {
		return this.mailSmtpPort;
	}

	public void setMailSmtpPort(String mailSmtpPort) {
		this.mailSmtpPort = mailSmtpPort;
	}

	public String getSmsDbName() {
		return this.smsDbName;
	}

	public void setSmsDbName(String smsDbName) {
		this.smsDbName = smsDbName;
	}

}