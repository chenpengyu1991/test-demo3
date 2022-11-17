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
 * A decorator for a comparator, with an "ascending" flag denoting whether
 * comparison results should be treated in forward (standard ascending) order or
 * flipped for reverse (descending) order.
 * 
 * @author Keith Donald
 * @author Juergen Hoeller
 * @since 1.2.2
 */
public class InvertibleComparator<T> implements Comparator<T>, Serializable {

	/**
	 * Fields .....
	 */
	private static final long serialVersionUID = -1953405659608503507L;

	private final Comparator<T> comparator;

	private boolean ascending = true;

	/**
	 * Create an InvertibleComparator that sorts ascending by default. For the
	 * actual comparison, the specified Comparator will be used.
	 * 
	 * @param comparator
	 *            the comparator to decorate
	 */
	public InvertibleComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	/**
	 * Create an InvertibleComparator that sorts based on the provided order.
	 * For the actual comparison, the specified Comparator will be used.
	 * 
	 * @param comparator
	 *            the comparator to decorate
	 * @param ascending
	 *            the sort order: ascending (true) or descending (false)
	 */
	public InvertibleComparator(Comparator<T> comparator, boolean ascending) {
		this.comparator = comparator;
		setAscending(ascending);
	}

	@Override
	public int compare(T o1, T o2) {
		int result = this.comparator.compare(o1, o2);
		if (result != 0) {
			// Invert the order if it is a reverse sort.
			if (!this.ascending) {
				if (Integer.MIN_VALUE == result) {
					result = Integer.MAX_VALUE;
				} else {
					result *= -1;
				}
			}
			return result;
		}
		return 0;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof InvertibleComparator)) {
			return false;
		}
		InvertibleComparator other = (InvertibleComparator) obj;
		return (this.comparator.equals(other.comparator) && (this.ascending == other.ascending));
	}

	@Override
	public int hashCode() {
		return this.comparator.hashCode();
	}

	/**
	 * Invert the sort order: ascending -> descending or descending ->
	 * ascending.
	 */
	public void invertOrder() {
		this.ascending = !this.ascending;
	}

	/**
	 * Return the sort order: ascending (true) or descending (false).
	 */
	public boolean isAscending() {
		return this.ascending;
	}

	/**
	 * Specify the sort order: ascending (true) or descending (false).
	 */
	public void setAscending(boolean ascending) {
		this.ascending = ascending;
	}

	@Override
	public String toString() {
		return "InvertibleComparator: [" + this.comparator + "]; ascending=" + this.ascending;
	}
}
