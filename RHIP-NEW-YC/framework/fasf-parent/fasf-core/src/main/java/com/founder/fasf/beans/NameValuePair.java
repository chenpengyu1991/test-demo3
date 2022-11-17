/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.beans;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * NameValuePair encapsulates the combination of a column or attribute with its
 * corresponding value
 * 
 * @author DenggaoLi
 */
public class NameValuePair implements Serializable {

	private static final long serialVersionUID = -4012644666481353904L;

	private String name;

	private Object value;

	public NameValuePair() {
	}

	public NameValuePair(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof NameValuePair)) {
			return false;
		}
		NameValuePair castOther = (NameValuePair) other;
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
