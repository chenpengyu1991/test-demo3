package com.founder.elb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACTION_CONTROL")
public class ActionControl implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|字段标识|11|", length = 11, nullable = false)
	private Integer id;

	@Column(name = "CONTROLLER", columnDefinition = "VARCHAR2|表名|50|", length = 50, nullable = false)
	private String controller;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|字段名|50|", length = 50, nullable = false)
	private String name;

	@Column(name = "PATH", columnDefinition = "VARCHAR2|字段名|50|", length = 50, nullable = false)
	private String path;

	@Column(name = "FLAG", columnDefinition = "NUMBER|权限控制标志|1|", length = 1, nullable = false)
	private Integer flag;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getController() {
		return this.controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

}