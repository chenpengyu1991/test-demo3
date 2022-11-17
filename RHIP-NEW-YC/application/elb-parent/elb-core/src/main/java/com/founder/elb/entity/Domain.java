package com.founder.elb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DOMAIN")
public class Domain implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|域标识|8|", length = 8, nullable = false)
	private Integer id;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|域名|60|", length = 60, nullable = false)
	private String name;

	@Column(name = "DESCRIPTION", columnDefinition = "VARCHAR2|描述|200|", length = 200, nullable = true)
	private String description;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}