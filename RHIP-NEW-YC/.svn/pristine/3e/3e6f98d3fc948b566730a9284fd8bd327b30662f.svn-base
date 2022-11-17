package com.founder.rhip.mdm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "BRW_ENTITY_MODEL")
public class EntityModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7676010837616477610L;

	@Id
	@Column(name = "ENTITY_MODEL_ID", columnDefinition = "NUMBER|Id||", length = 5, nullable = false)
	private Long entityModelId;

	@Column(name = "ENTITY_ID", columnDefinition = "NUMBER|模型Id||", length = 5, nullable = false)
	private Integer entityId;

	@Column(name = "PROPERTY_ID", columnDefinition = "NUMBER|属性Id||", length = 5, nullable = false)
	private Integer propertyId;

	@Column(name = "PROPERTY_NAME", columnDefinition = "VARCHAR2|属性名||", length = 100, nullable = true)
	private String propertyName;

	@Column(name = "FIELD_NAME", columnDefinition = "VARCHAR2|字段名||", length = 100, nullable = true)
	private String fieldName;

	@Column(name = "IS_IDENTIFIER", columnDefinition = "NUMBER|是否标识项||", length = 2, nullable = true)
	private Integer isIdentifier;

	@Column(name = "DISCRIPTION", columnDefinition = "VARCHAR2|描述||", length = 500, nullable = true)
	private String idscription;

	@Column(name = "DISPLAY_NAME", columnDefinition = "VARCHAR2|显示名称||", length = 100, nullable = true)
	private String displayName;

	@Column(name = "NULL_VALUE", columnDefinition = "VARCHAR2|空值串||", length = 30, nullable = true)
	private String nullValue;

	@Column(name = "USEABLE", columnDefinition = "NUMBER|使用标志||", length = 2, nullable = true)
	private Integer useable;

	@Column(name = "NOT_NULL", columnDefinition = "VARCHAR2|检查项-非空||", length = 20, nullable = true)
	private String notNull;

	@Column(name = "MAX_LENGTH", columnDefinition = "VARCHAR2|检查项-最大长度||", length = 20, nullable = true)
	private String maxLength;

	@Column(name = "DICTIONARY", columnDefinition = "VARCHAR2|检查项-字典||", length = 50, nullable = true)
	private String dictionary;

	@Column(name = "REGEX", columnDefinition = "VARCHAR2|检查项-正则||", length = 300, nullable = true)
	private String regex;

	public Integer getEntityId() {
		return this.entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public Integer getPropertyId() {
		return this.propertyId;
	}

	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyName() {
		return this.propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Integer getIsIdentifier() {
		return this.isIdentifier;
	}

	public void setIsIdentifier(Integer isIdentifier) {
		this.isIdentifier = isIdentifier;
	}

	public String getIdscription() {
		return this.idscription;
	}

	public void setIdscription(String idscription) {
		this.idscription = idscription;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getNullValue() {
		return this.nullValue;
	}

	public void setNullValue(String nullValue) {
		this.nullValue = nullValue;
	}

	public Integer getUseable() {
		return this.useable;
	}

	public void setUseable(Integer useable) {
		this.useable = useable;
	}

	public String getNotNull() {
		return this.notNull;
	}

	public void setNotNull(String notNull) {
		this.notNull = notNull;
	}

	public String getMaxLength() {
		return this.maxLength;
	}

	public void setMaxLength(String maxLength) {
		this.maxLength = maxLength;
	}

	public String getDictionary() {
		return this.dictionary;
	}

	public void setDictionary(String dictionary) {
		this.dictionary = dictionary;
	}

	public String getRegex() {
		return this.regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public Long getEntityModelId() {
		return entityModelId;
	}

	public void setEntityModelId(Long entityModelId) {
		this.entityModelId = entityModelId;
	}

}