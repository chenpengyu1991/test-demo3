package com.founder.rhip.ehr.entity.healtheducation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "HE_SUPERVISOR")
public class HeSupervisor implements Serializable {

	private static final long serialVersionUID = 2873077749487631330L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;
	
	@Column(name = "ORG_CODE", columnDefinition = "VARCHAR2|机构代码||", length = 18, nullable = true)
	private String orgCode;
	
	@Column(name = "CENTER_ORG_CODE", columnDefinition = "VARCHAR2|上级机构代码||", length = 18, nullable = true)
	private String centerOrgCode;

	@Column(name = "GBCODE", columnDefinition = "VARCHAR2|乡镇代码||", length = 18, nullable = true)
	private String gbcode;

	@Column(name = "PARTICIPANTS", columnDefinition = "VARCHAR2|参加人员||", length = 50, nullable = true)
	private String participants;

	@Column(name = "OVERSEE_PERSON", columnDefinition = "VARCHAR2|督查对象||", length = 50, nullable = true)
	private String overseePerson;

	@Column(name = "CONTENT", columnDefinition = "VARCHAR2|内容摘要||", length = 2000, nullable = true)
	private String content;

	@Column(name = "OVERSEE_TIME", columnDefinition = "DATE|督查时间||", nullable = true)
	private Date overseeTime;
	
	@Column(name = "STATUS", columnDefinition = "VARCHAR2|状态||", length = 1, nullable = true)
	private String status;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParticipants() {
		return this.participants;
	}

	public void setParticipants(String participants) {
		this.participants = participants;
	}

	public String getOverseePerson() {
		return this.overseePerson;
	}

	public void setOverseePerson(String overseePerson) {
		this.overseePerson = overseePerson;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getOverseeTime() {
		return this.overseeTime;
	}

	public void setOverseeTime(Date overseeTime) {
		this.overseeTime = overseeTime;
	}

	
	public String getOrgCode() {
		return orgCode;
	}

	
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	
	public String getCenterOrgCode() {
		return centerOrgCode;
	}

	
	public void setCenterOrgCode(String centerOrgCode) {
		this.centerOrgCode = centerOrgCode;
	}

	
	public String getGbcode() {
		return gbcode;
	}

	
	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
	}

	
	public String getStatus() {
		return status;
	}

	
	public void setStatus(String status) {
		this.status = status;
	}

	
}