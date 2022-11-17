package com.founder.rhip.ehr.entity.management.mhm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "MHM_MANAGE_TYPE")
public class MhmManageType implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "EVENT_ID", columnDefinition = "NUMBER|本系统唯一编码|11|", length = 11, nullable = false)
	private Long eventId;

	@Column(name = "STATUS", columnDefinition = "VARCHAR2|管理方式（1个案管理，2基础管理）|2|", length = 2, nullable = true)
	private String status;

	@Column(name = "START_DT", columnDefinition = "DATE|开始方式时间||", nullable = true)
	private Date startDt;

	@Column(name = "START_ORGAN", columnDefinition = "VARCHAR2|开始机构|100|", length = 100, nullable = true)
	private String startOrgan;

	@Column(name = "START_USER", columnDefinition = "VARCHAR2|开始人|50|", length = 50, nullable = true)
	private String startUser;

	@Column(name = "END_DT", columnDefinition = "DATE|结束方式时间||", nullable = true)
	private Date endDt;

	@Column(name = "END_ORGAN", columnDefinition = "VARCHAR2|结束机构|100|", length = 100, nullable = true)
	private String endOrgan;

	@Column(name = "END_USER", columnDefinition = "VARCHAR2|结束人|50|", length = 50, nullable = true)
	private String endUser;

	@Column(name = "VERSION", columnDefinition = "NUMBER|版本号|11|", length = 11, nullable = true)
	private Long version;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEventId() {
		return this.eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStartDt() {
		return this.startDt;
	}

	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}

	public String getStartOrgan() {
		return this.startOrgan;
	}

	public void setStartOrgan(String startOrgan) {
		this.startOrgan = startOrgan;
	}

	public String getStartUser() {
		return this.startUser;
	}

	public void setStartUser(String startUser) {
		this.startUser = startUser;
	}

	public Date getEndDt() {
		return this.endDt;
	}

	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}

	public String getEndOrgan() {
		return this.endOrgan;
	}

	public void setEndOrgan(String endOrgan) {
		this.endOrgan = endOrgan;
	}

	public String getEndUser() {
		return this.endUser;
	}

	public void setEndUser(String endUser) {
		this.endUser = endUser;
	}

	public Long getVersion() {
		return this.version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

}