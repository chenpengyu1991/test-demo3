package com.founder.elb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CV_CONFIG")
public class CvConfig implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|术语配置标识|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "CODE", columnDefinition = "VARCHAR2|术语目录编码|20|", length = 20, nullable = false)
	private String code;

	@Column(name = "TABLENAME", columnDefinition = "VARCHAR2|表名|50|", length = 50, nullable = true)
	private String tablename;

	@Column(name = "COLUMN_NAME", columnDefinition = "VARCHAR2|字段名|20|", length = 20, nullable = true)
	private String columnName;

	@Column(name = "DISPLAYNAME", columnDefinition = "VARCHAR2|字段中文名|60|", length = 60, nullable = true)
	private String displayname;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTablename() {
		return this.tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getColumnName() {
		return this.columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getDisplayname() {
		return this.displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

}