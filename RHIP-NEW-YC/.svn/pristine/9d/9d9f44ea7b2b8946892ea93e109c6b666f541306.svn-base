package com.founder.elb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CV_METADATA")
public class CvMetadata implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="METADATA_ID",columnDefinition="VARCHAR2|数据元标识",length=20,nullable=false)
	private String metadataId;

	@Column(name="NAME",columnDefinition="VARCHAR2|数据元名称",length=50,nullable=false)
	private String name;

	@Column(name="DEFINATION",columnDefinition="VARCHAR2|数据元定义",length=100,nullable=true)
	private String defination;

	@Column(name="JAVA_TYPE",columnDefinition="VARCHAR2|Java类型",length=20,nullable=true)
	private String javaType;

	@Column(name="DATA_TYPE",columnDefinition="VARCHAR2|数据元值类型",length=10,nullable=true)
	private String dataType;

	@Column(name="DATA_FORMAT",columnDefinition="VARCHAR2|数据元表示格式",length=10,nullable=true)
	private String dataFormat;

	@Column(name="HL7_TYPE",columnDefinition="VARCHAR2|HL7 数据类型",length=10,nullable=true)
	private String hl7Type;

	@Column(name="OPTION_VALUE",columnDefinition="VARCHAR2|允许值",length=30,nullable=true)
	private String optionValue;

	@Column(name="DICMETA_ID",columnDefinition="NUMBER|字典元标识",length=19,nullable=true)
	private Long dicmetaId;

	public String getMetadataId() {
		return this.metadataId;
	}

	public void setMetadataId(String metadataId) {
		this.metadataId = metadataId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDefination() {
		return this.defination;
	}

	public void setDefination(String defination) {
		this.defination = defination;
	}

	public String getJavaType() {
		return this.javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDataFormat() {
		return this.dataFormat;
	}

	public void setDataFormat(String dataFormat) {
		this.dataFormat = dataFormat;
	}

	public String getHl7Type() {
		return this.hl7Type;
	}

	public void setHl7Type(String hl7Type) {
		this.hl7Type = hl7Type;
	}

	public String getOptionValue() {
		return this.optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	public Long getDicmetaId() {
		return this.dicmetaId;
	}

	public void setDicmetaId(Long dicmetaId) {
		this.dicmetaId = dicmetaId;
	}

}