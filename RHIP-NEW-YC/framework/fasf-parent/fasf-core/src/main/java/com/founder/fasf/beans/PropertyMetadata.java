
package com.founder.fasf.beans;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.founder.fasf.util.ObjectUtil;

public class PropertyMetadata implements Serializable {

	/**
	 * Fields .....
	 */
	private static final long serialVersionUID = 4614931494206011559L;

	private String name;

	private String column;

	private Class<?> extendClass = null;

	private String extendKey = null;

	private Class<?> fieldClass;

	private boolean isDbField;

	private boolean isPrimayKey;

	private boolean isNullable;

	private boolean isUnique;

	private Integer scale;

	private Integer length;

	private String dataType;

	private PropertyDescriptor propertyDescriptor;

	public PropertyMetadata(Field field) {
		this.name = field.getName();
		this.fieldClass = field.getType();
		Column column = field.getAnnotation(Column.class);
		Id id = field.getAnnotation(Id.class);
		OneToMany oneToMany = field.getAnnotation(OneToMany.class);
		if (id != null) {
			this.isPrimayKey = true;
			this.isUnique = true;
		}
		if (column != null) {
			this.column = column.name();
			this.length = column.length();
			this.isNullable = column.nullable();
			this.scale = column.scale();
			this.dataType = column.columnDefinition();
			this.isUnique = column.unique();
			this.isDbField = true;
		}
		if (oneToMany != null) {
			if (oneToMany.targetEntity() != null) {
				extendClass = oneToMany.targetEntity();
				extendKey = oneToMany.mappedBy();
			} else {
				if (field.getType().isAssignableFrom(List.class)) {
					extendClass = (Class<?>) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
				} else {
					extendClass = field.getType();
				}
			}
		}
		if (ObjectUtil.isNullOrEmpty(this.column)) {
			this.column = getUnderscoreString(name);
		}
	}

	private String getUnderscoreString(String strCamel) {
		StringBuilder sb = new StringBuilder();
		if (strCamel != null && strCamel.length() > 0) {
			sb.append(strCamel.substring(0, 1).toLowerCase());
			for (int i = 1; i < strCamel.length(); i++) {
				String s = strCamel.substring(i, i + 1);
				boolean isDigit = s.matches("[0-9]+");
				if (s.equals(s.toUpperCase()) && !isDigit) {
					sb.append("_");
					sb.append(s.toLowerCase());
				} else {
					sb.append(s);
				}
			}
		}
		return sb.toString();
	}

	public String getColumn() {
		return column;
	}

	public String getDataType() {
		return dataType;
	}

	public int getLength() {
		return length;
	}

	public String getName() {
		return name;
	}

	public PropertyDescriptor getPropertyDescriptor() {
		return propertyDescriptor;
	}

	public Integer getScale() {
		return scale;
	}

	public boolean isNullable() {
		return isNullable;
	}

	public boolean isPrimayKey() {
		return isPrimayKey;
	}

	public boolean isUnique() {
		return isUnique;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNullable(boolean isNullable) {
		this.isNullable = isNullable;
	}

	public void setPrimayKey(boolean isPrimayKey) {
		this.isPrimayKey = isPrimayKey;
	}

	public void setPropertyDescriptor(PropertyDescriptor propertyDescriptor) {
		this.propertyDescriptor = propertyDescriptor;
	}

	public void setScale(Integer scale) {
		this.scale = scale;
	}

	public void setUnique(boolean isUnique) {
		this.isUnique = isUnique;
	}

	public boolean isDbField() {
		return isDbField;
	}

	public void setDbField(boolean isDbField) {
		this.isDbField = isDbField;
	}

	public Class<?> getExtendClass() {
		return extendClass;
	}

	public void setExtendClass(Class<?> extendClass) {
		this.extendClass = extendClass;
	}

	public Class<?> getFieldClass() {
		return fieldClass;
	}

	public void setFieldClass(Class<?> fieldClass) {
		this.fieldClass = fieldClass;
	}

	public String getExtendKey() {
		return extendKey;
	}

	public void setExtendKey(String extendKey) {
		this.extendKey = extendKey;
	}
}
