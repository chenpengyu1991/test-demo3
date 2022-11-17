package com.founder.fasf.beans;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * BaseField encapsulates a base field that contains information about the
 * person object
 * 
 * @author DenggaoLi
 */
public class BaseField implements Serializable {
	private static final long serialVersionUID = -4012644666481353904L;

	protected String fieldName;
	protected String propertyName;

	
	public BaseField() {
	
	}


	public BaseField(String fieldName) {
		this.fieldName = fieldName;
	}


	public String getPropertyName() {
		return propertyName;
	}

	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof BaseField))
			return false;
		BaseField castOther = (BaseField) other;
		return new EqualsBuilder().append(fieldName, castOther.fieldName)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(fieldName).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("fieldName", fieldName)
				.toString();
	}	

}
