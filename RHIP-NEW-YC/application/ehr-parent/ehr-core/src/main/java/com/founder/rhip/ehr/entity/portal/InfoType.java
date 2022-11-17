package com.founder.rhip.ehr.entity.portal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "INFO_TYPE")
public class InfoType implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|编码|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|名称|50|", length = 50, nullable = true)
	private String name;

	@Column(name = "PARENT_CODE", columnDefinition = "VARCHAR2|父编码|50|", length = 50, nullable = true)
	private String parentCode;

	@Column(name = "CREATOR", columnDefinition = "VARCHAR2|创建者|50|", length = 50, nullable = true)
	private String creator;

	@Column(name = "CREAT_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date creatTime;
	
	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date updateTime;
	
	@Column(name = "IS_DELETE", columnDefinition = "VARCHAR2|删除||", nullable = true)
	private String isDelete = "0";

	private Date beginTime;
	private Date endTime;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentCode() {
		return this.parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreatTime() {
		return this.creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


}