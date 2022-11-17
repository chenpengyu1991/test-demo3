package com.founder.elb.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SITE_NOTICE")
public class SiteNotice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|站内信标识|8|", length = 8, nullable = false)
	private Integer id;

	@Column(name = "SEND_TIME", columnDefinition = "DATE|发出时间||", nullable = true)
	private Date sendTime;

	@Column(name = "SENDER", columnDefinition = "VARCHAR2|发出者|20|", length = 20, nullable = false)
	private String sender;

	@Column(name = "SEND_CONTENT", columnDefinition = "VARCHAR2|发出内容|1000|", length = 1000, nullable = true)
	private String sendContent;

	@Column(name = "NOTICE_SOURCE", columnDefinition = "VARCHAR2|信息源|3|", length = 3, nullable = true)
	private String noticeSource;

	@Column(name = "RECEIVER", columnDefinition = "VARCHAR2|接收者|20|", length = 20, nullable = false)
	private String receiver;
	
	@Column(name = "IS_READ", columnDefinition = "VARCHAR2|已读未读|1|", length = 1, nullable = true)
	private String isRead;
	
	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateTime;
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSendContent() {
		return this.sendContent;
	}

	public void setSendContent(String sendContent) {
		this.sendContent = sendContent;
	}

	public String getNoticeSource() {
		return this.noticeSource;
	}

	public void setNoticeSource(String noticeSource) {
		this.noticeSource = noticeSource;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}