package com.founder.elb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "NOTICE")
public class Notice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|通知标识|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "TITLE", columnDefinition = "VARCHAR2|标题|200|", length = 400, nullable = true)
	private String title;

	@Column(name = "CONTENT", columnDefinition = "VARCHAR2|内容|1000|", length = 1000, nullable = true)
	private String content;

	@Column(name = "RELEASE_DATE", columnDefinition = "DATE|发布日期||", nullable = true)
	private Date release;

	@Column(name = "TRIGGER_DATE", columnDefinition = "DATE|日期||", nullable = true)
	private Date trigger;

	@Column(name = "SUBMITTER", columnDefinition = "NUMBER|用户ID|11|", length = 11, nullable = true)
	private Long submitter;

	@Column(name = "NOTIFICATION_STATUS", columnDefinition = "NUMBER|通知状态|1|", length = 1, nullable = true)
	private Integer notificationStatus;

	@Column(name = "TOADDRESS", columnDefinition = "VARCHAR2|标题|200|", length = 400, nullable = true)
	private String toAddress;

	@Column(name = "CCADDRESS", columnDefinition = "VARCHAR2|标题|200|", length = 400, nullable = true)
	private String ccAddress;

	@Column(name = "BCCADDRESS", columnDefinition = "VARCHAR2|标题|200|", length = 400, nullable = true)
	private String bccAddress;

	@Column(name = "ATTACHFILEPATH", columnDefinition = "VARCHAR2|标题|200|", length = 400, nullable = true)
	private String[] attachFilePath;

	@Column(name = "LOGINNAME", columnDefinition = "VARCHAR2|接口登录名|100|", length = 100, nullable = true)
	private String loginName;

	@Column(name = "LOGINPWD", columnDefinition = "VARCHAR2|接口登录密码|100|", length = 100, nullable = true)
	private String loginPwd;

	@Column(name = "SRCID", columnDefinition = "NUMBER|短信尾号|11|", length = 11, nullable = true)
	private Long srcId;

	@Column(name = "MOBILES", columnDefinition = "VARCHAR2|短信发送目的号码|15|", length = 15, nullable = true)
	private String[] mobiles;

	@Column(name = "APICODE", columnDefinition = "VARCHAR2|接口编码|4|", length = 4, nullable = true)
	private String apiCode;

	@Column(name = "SCENE", columnDefinition = "VARCHAR2|场景名|400|", length = 400, nullable = true)
	private String scene;

	@Column(name = "FILEFLOW", columnDefinition = "BYTE|附件文件流|15|", length = 15, nullable = true)
	private byte[] fileFlow;

	@Column(name = "FILE64STR", columnDefinition = "VARCHAR2|附件64位加密字符串|20000|", length = 20000, nullable = true)
	private String[] file64Str;

	@Column(name = "ATTACHFILENAME", columnDefinition = "VARCHAR2|附件文件名|100|", length = 100, nullable = true)
	private String[] attachFileName;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRelease() {
		return this.release;
	}

	public void setRelease(Date release) {
		this.release = release;
	}

	public Date getTrigger() {
		return this.trigger;
	}

	public void setTrigger(Date trigger) {
		this.trigger = trigger;
	}

	public Long getSubmitter() {
		return this.submitter;
	}

	public void setSubmitter(Long submitter) {
		this.submitter = submitter;
	}

	public Integer getNotificationStatus() {
		return this.notificationStatus;
	}

	public void setNotificationStatus(Integer notificationStatus) {
		this.notificationStatus = notificationStatus;
	}

	public String getToAddress() {
		return this.toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getCcAddress() {
		return this.ccAddress;
	}

	public void setCcAddress(String ccAddress) {
		this.ccAddress = ccAddress;
	}

	public String getBccAddress() {
		return this.bccAddress;
	}

	public void setBccAddress(String bccAddress) {
		this.bccAddress = bccAddress;
	}

	public String[] getAttachFilePath() {
		return this.attachFilePath;
	}

	public void setAttachFilePath(String[] attachFilePath) {
		this.attachFilePath = attachFilePath;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return this.loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public Long getSrcId() {
		return this.srcId;
	}

	public void setSrcId(Long srcId) {
		this.srcId = srcId;
	}

	public String[] getMobiles() {
		return this.mobiles;
	}

	public void setMobiles(String[] mobiles) {
		this.mobiles = mobiles;
	}

	public String getApiCode() {
		return this.apiCode;
	}

	public void setApiCode(String apiCode) {
		this.apiCode = apiCode;
	}

	public String getScene() {
		return this.scene;
	}

	public void setScene(String scene) {
		this.scene = scene;
	}

	public byte[] getFileFlow() {
		return this.fileFlow;
	}

	public void setFileFlow(byte[] fileFlow) {
		this.fileFlow = fileFlow;
	}

	public String[] getFile64Str() {
		return this.file64Str;
	}

	public void setFile64Str(String[] file64Str) {
		this.file64Str = file64Str;
	}

	public String[] getAttachFileName() {
		return this.attachFileName;
	}

	public void setAttachFileName(String[] attachFileName) {
		this.attachFileName = attachFileName;
	}

}