/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.compare;

import java.io.Serializable;
import java.util.Comparator;

/**
 * A Comparator for Boolean objects that can sort either true or false first.
 * 
 * @author Keith Donald
 * @since 1.2.2
 */
public final class BooleanComparator implements Comparator<Boolean>, Serializable {

	/**
	 * Fields .....
	 */
	private static final long serialVersionUID = -653292041562224141L;

	/**
	 * A shared default instance of this comparator, treating true lower than
	 * false.
	 */
	public static final BooleanComparator TRUE_LOW = new BooleanComparator(true);

	/**
	 * A shared default instance of this comparator, treating true higher than
	 * false.
	 */
	public static final BooleanComparator TRUE_HIGH = new BooleanComparator(false);

	private final boolean trueLow;

	/**
	 * Create a BooleanComparator that sorts boolean values based on the
	 * provided flag.
	 * <p>
	 * Alternatively, you can use the default shared instances:
	 * <code>BooleanComparator.TRUE_LOW</code> and
	 * <code>BooleanComparator.TRUE_HIGH</code>.
	 * 
	 * @param trueLow
	 *            whether to treat true as lower or higher than false
	 * @see #TRUE_LOW
	 * @see #TRUE_HIGH
	 */
	public BooleanComparator(boolean trueLow) {
		this.trueLow = trueLow;
	}

	@Override
	public int compare(Boolean v1, Boolean v2) {
		return (v1 ^ v2) ? ((v1 ^ trueLow) ? 1 : -1) : 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof BooleanComparator)) {
			return false;
		}
		return (trueLow == ((BooleanComparator) obj).trueLow);
	}

	@Override
	public int hashCode() {
		return (trueLow ? -1 : 1) * getClass().hashCode();
	}

	@Override
	public String toString() {
		return "BooleanComparator: " + (trueLow ? "true low" : "true high");
	}
}
