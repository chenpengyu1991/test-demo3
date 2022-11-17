package com.founder.elb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CV_ACT")
public class CvAct implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|活动标识|19|", length = 19, nullable = false)
	private Integer id;

	@Column(name = "CODE", columnDefinition = "VARCHAR2|活动编码|30|", length = 30, nullable = false)
	private String code;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|业务活动名称|100|", length = 100, nullable = false)
	private String name;

	@Column(name = "HL7_DOMAIN", columnDefinition = "VARCHAR2|HL7通用域|50|", length = 50, nullable = true)
	private String hl7Domain;

	@Column(name = "HL7_RIM", columnDefinition = "VARCHAR2|HL7模型|50|", length = 50, nullable = true)
	private String hl7Rim;

	@Column(name = "V3_OID", columnDefinition = "VARCHAR2|v3 OID|50|", length = 50, nullable = true)
	private String v3Oid;

	@Column(name = "V3_TEMPLATE", columnDefinition = "VARCHAR2|v3 模板|50|", length = 50, nullable = true)
	private String v3Template;

	@Column(name = "CDA_OID", columnDefinition = "VARCHAR2|CDA OID|50|", length = 50, nullable = true)
	private String cdaOid;

	@Column(name = "CDA_TEMPLATE", columnDefinition = "VARCHAR2|CDA模板|50|", length = 50, nullable = true)
	private String cdaTemplate;
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHl7Domain() {
		return this.hl7Domain;
	}

	public void setHl7Domain(String hl7Domain) {
		this.hl7Domain = hl7Domain;
	}

	public String getHl7Rim() {
		return this.hl7Rim;
	}

	public void setHl7Rim(String hl7Rim) {
		this.hl7Rim = hl7Rim;
	}

	public String getV3Oid() {
		return this.v3Oid;
	}

	public void setV3Oid(String v3Oid) {
		this.v3Oid = v3Oid;
	}

	public String getV3Template() {
		return this.v3Template;
	}

	public void setV3Template(String v3Template) {
		this.v3Template = v3Template;
	}

	public String getCdaOid() {
		return this.cdaOid;
	}

	public void setCdaOid(String cdaOid) {
		this.cdaOid = cdaOid;
	}

	public String getCdaTemplate() {
		return this.cdaTemplate;
	}

	public void setCdaTemplate(String cdaTemplate) {
		this.cdaTemplate = cdaTemplate;
	}

}