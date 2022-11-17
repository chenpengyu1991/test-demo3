
package com.founder.fasf.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Parameters implements Serializable {

	private static final long serialVersionUID = 7534673028743277151L;

	private List<Parameter> parameters;

	
	public List<Parameter> getParameters() {
		return parameters;
	}

	public Parameters() {
		parameters = new ArrayList<Parameter>();
	}

	public Parameters(String name, Object value) {
		parameters = new ArrayList<Parameter>();
		addParameter(new Parameter(name, value));
	}

	public void addParameter(Parameter parameter) {
		parameters.add(parameter);
	}

	public Parameters add(String name, Object value) {
		this.addParameter(new Parameter(name, value));
		return this;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Parameters)) {
			return false;
		}
		Parameters castOther = (Parameters) other;
		return new EqualsBuilder().append(parameters, castOther.parameters).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(parameters).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("Parameters", parameters).toString();
	}
}