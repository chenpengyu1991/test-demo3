package com.founder.rhip.ehr.entity.portal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LABEL_TYPE")
public class LabelType implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长id|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|名称|50|", length = 50, nullable = true)
	private String name;

	@Column(name = "CODE", columnDefinition = "VARCHAR2|编码|50|", length = 50, nullable = true)
	private String code;

	@Column(name = "DESCRIPTION", columnDefinition = "VARCHAR2|描述|100|", length = 100, nullable = true)
	private String description;

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

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}