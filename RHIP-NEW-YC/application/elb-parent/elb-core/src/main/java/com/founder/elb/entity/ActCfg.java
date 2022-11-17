package com.founder.elb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACT_CFG")
public class ActCfg implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ACT_CFG_ID", columnDefinition = "NUMBER|配置表id|19|", length = 19, nullable = false)
	private Integer actCfgId;

	@Column(name = "ACT_ID", columnDefinition = "VARCHAR2|活动名称|200|", length = 100, nullable = false)
	private String actId;

	@Column(name = "DISPLAY_NAME", columnDefinition = "VARCHAR2|数据元名称|50|", length = 50, nullable = false)
	private String displayName;

	@Column(name = "METADATA_ID", columnDefinition = "VARCHAR2|数据元标识符|20|", length = 20, nullable = false)
	private String metadataId;

	@Column(name = "ENTITY", columnDefinition = "VARCHAR2|表名|50|", length = 50, nullable = false)
	private String entity;

	@Column(name = "PROPERTY", columnDefinition = "VARCHAR2|字段名|50|", length = 50, nullable = false)
	private String property;

	@Column(name = "CDA_SECTION", columnDefinition = "VARCHAR2|CDA Section|100|", length = 100, nullable = true)
	private String cdaSection;

	@Column(name = "CDA_CLASS", columnDefinition = "VARCHAR2|MDHT类|50|", length = 50, nullable = true)
	private String cdaClass;

	@Column(name = "CDA_PROPERTY", columnDefinition = "VARCHAR2|MDHT属性|50|", length = 50, nullable = true)
	private String cdaProperty;

	@Column(name = "V3_CLASS", columnDefinition = "VARCHAR2|v3类名|50|", length = 50, nullable = true)
	private String v3Class;

	@Column(name = "V3_PROPERTY", columnDefinition = "VARCHAR2|v3属性|50|", length = 50, nullable = true)
	private String v3Property;

	@Column(name = "RIM_CLASS", columnDefinition = "VARCHAR2|HL7类名称|100|", length = 50, nullable = true)
	private String rimClass;

	public Integer getActCfgId() {
		return this.actCfgId;
	}

	public void setActCfgId(Integer actCfgId) {
		this.actCfgId = actCfgId;
	}

	public String getActId() {
		return this.actId;
	}

	public void setActId(String actId) {
		this.actId = actId;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getMetadataId() {
		return this.metadataId;
	}

	public void setMetadataId(String metadataId) {
		this.metadataId = metadataId;
	}

	public String getEntity() {
		return this.entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getCdaSection() {
		return this.cdaSection;
	}

	public void setCdaSection(String cdaSection) {
		this.cdaSection = cdaSection;
	}

	public String getCdaClass() {
		return this.cdaClass;
	}

	public void setCdaClass(String cdaClass) {
		this.cdaClass = cdaClass;
	}

	public String getCdaProperty() {
		return this.cdaProperty;
	}

	public void setCdaProperty(String cdaProperty) {
		this.cdaProperty = cdaProperty;
	}

	public String getV3Class() {
		return this.v3Class;
	}

	public void setV3Class(String v3Class) {
		this.v3Class = v3Class;
	}

	public String getV3Property() {
		return this.v3Property;
	}

	public void setV3Property(String v3Property) {
		this.v3Property = v3Property;
	}

	public String getRimClass() {
		return this.rimClass;
	}

	public void setRimClass(String rimClass) {
		this.rimClass = rimClass;
	}

}