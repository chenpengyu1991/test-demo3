/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.beans;

import java.io.Serializable;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple JavaBean to represent label-value pairs. This is most commonly used
 * when constructing user interface elements which have a label to be displayed
 * to the user, and a corresponding value to be returned to the server. One
 * example is the <code>&lt;html:options&gt;</code> tag.
 * 
 * <p>
 * Note: this class has a natural ordering that is inconsistent with equals.
 * 
 * @see org.apache.struts.util.LabelValueBean
 */
@SuppressWarnings("rawtypes")
public class LabelValue implements Comparable, Serializable {

	private static final long serialVersionUID = 3689355407466181430L;

	/**
	 * Comparator that can be used for a case insensitive sort of
	 * <code>LabelValue</code> objects.
	 */
	public static final Comparator CASE_INSENSITIVE_ORDER = new Comparator() {

		@Override
		public int compare(Object o1, Object o2) {
			String label1 = ((LabelValue) o1).getLabel();
			String label2 = ((LabelValue) o2).getLabel();
			return label1.compareToIgnoreCase(label2);
		}
	};
	/**
	 * Convert a java.util.List of LabelValue objects to a LinkedHashMap.
	 * 
	 * @param list
	 *            the list to convert
	 * @return the populated map with the label as the key
	 */
	public static Map<String, String> convertListToMap(List<LabelValue> list) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		for (LabelValue option : list) {
			map.put(option.getLabel(), option.getValue());
		}
		return map;
	}

	// ----------------------------------------------------------- Constructors
	/**
	 * The property which supplies the option label visible to the end user.
	 */
	private String label;

	/**
	 * The property which supplies the value returned to the server.
	 */
	private String value;

	// ------------------------------------------------------------- Properties
	/**
	 * Default constructor.
	 */
	public LabelValue() {
		super();
	}

	/**
	 * Construct an instance with the supplied property values.
	 * 
	 * @param label
	 *            The label to be displayed to the user.
	 * @param value
	 *            The value to be returned to the server.
	 */
	public LabelValue(final String label, final String value) {
		this.label = label;
		this.value = value;
	}

	/**
	 * Compare LabelValueBeans based on the label, because that's the human
	 * viewable part of the object.
	 * 
	 * @see Comparable
	 * @param o
	 *            LabelValue object to compare to
	 * @return 0 if labels match for compared objects
	 */
	@Override
	public int compareTo(Object o) {
		// Implicitly tests for the correct type, throwing
		// ClassCastException as required by interface
		String otherLabel = ((LabelValue) o).getLabel();
		return getLabel().compareTo(otherLabel);
	}

	/**
	 * LabelValueBeans are equal if their values are both null or equal.
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param obj
	 *            object to compare to
	 * @return true/false based on whether values match or not
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof LabelValue)) {
			return false;
		}
		LabelValue bean = (LabelValue) obj;
		int nil = (getValue() == null) ? 1 : 0;
		nil += (bean.getValue() == null) ? 1 : 0;
		if (nil == 2) {
			return true;
		} else if (nil == 1) {
			return false;
		} else {
			return getValue().equals(bean.getValue());
		}
	}

	public String getLabel() {
		return label;
	}

	public String getValue() {
		return value;
	}

	// --------------------------------------------------------- Public Methods
	/**
	 * The hash code is based on the object's value.
	 * 
	 * @see java.lang.Object#hashCode()
	 * @return hashCode
	 */
	@Override
	public int hashCode() {
		return (getValue() == null) ? 17 : getValue().hashCode();
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Return a string representation of this object.
	 * 
	 * @return object as a string
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("LabelValue[");
		sb.append(label);
		sb.append(", ");
		sb.append(value);
		sb.append("]");
		return (sb.toString());
	}
}