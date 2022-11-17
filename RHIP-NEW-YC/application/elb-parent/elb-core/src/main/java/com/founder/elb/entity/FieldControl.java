package com.founder.elb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FIELD_CONTROL")
public class FieldControl implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|字段标识|11|", length = 11, nullable = false)
	private Integer id;

	@Column(name = "TABLE_NAME", columnDefinition = "VARCHAR2|表名|50|", length = 50, nullable = false)
	private String tableName;

	@Column(name = "COLUMN_NAME", columnDefinition = "VARCHAR2|字段名|50|", length = 50, nullable = false)
	private String columnName;

	@Column(name = "FLAG", columnDefinition = "NUMBER|权限控制标志|1|", length = 1, nullable = false)
	private Integer flag;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return this.columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

}