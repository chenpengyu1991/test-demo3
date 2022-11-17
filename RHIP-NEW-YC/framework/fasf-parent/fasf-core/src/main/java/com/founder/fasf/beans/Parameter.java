package com.founder.fasf.beans;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class Parameter implements Serializable {

	private static final long serialVersionUID = -4012644666481353904L;

	private String name;

	private Object value;

	public Parameter() {
	}

	public Parameter(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof NameValuePair)) {
			return false;
		}
		Parameter castOther = (Parameter) other;
		return new EqualsBuilder().append(name, castOther.name).append(value, castOther.value).isEquals();
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(name).append(value).toHashCode();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("name", name).append("value", value).toString();
	}
}
