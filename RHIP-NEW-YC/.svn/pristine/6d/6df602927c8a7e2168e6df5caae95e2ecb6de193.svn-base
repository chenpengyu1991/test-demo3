package com.founder.elb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SYS_CONTROL")
public class SysControl implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|字段标识|11|", length = 11, nullable = false)
	private Integer id;

	@Column(name = "SYS_NAME", columnDefinition = "VARCHAR2|表名|50|", length = 50, nullable = false)
	private String sysName;

	@Column(name = "PATH", columnDefinition = "VARCHAR2|字段名|50|", length = 50, nullable = false)
	private String path;

	@Column(name = "DESCRIPTION", columnDefinition = "VARCHAR2|表名|50|", length = 50, nullable = false)
	private String description;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSysName() {
		return this.sysName;
	}

	public void setSysName(String sysName) {
		this.sysName = sysName;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}