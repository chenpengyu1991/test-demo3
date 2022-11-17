/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.compare;

import java.util.Comparator;

/**
 * A Comparator that will safely compare nulls to be lower or higher than other
 * objects. Can decorate a given Comparator or work on Comparables.
 * 
 * @author Keith Donald
 * @author Juergen Hoeller
 * @since 1.2.2
 * @see Comparable
 */
public class NullSafeComparator<T> implements Comparator<T> {

	/**
	 * A shared default instance of this comparator, treating nulls lower than
	 * non-null objects.
	 */
	@SuppressWarnings("rawtypes")
	public static final NullSafeComparator NULLS_LOW = new NullSafeComparator(true);

	/**
	 * A shared default instance of this comparator, treating nulls higher than
	 * non-null objects.
	 */
	@SuppressWarnings("rawtypes")
	public static final NullSafeComparator NULLS_HIGH = new NullSafeComparator(false);

	private final Comparator<T> nonNullComparator;

	private final boolean nullsLow;

	/**
	 * Create a NullSafeComparator that sorts <code>null</code> based on the
	 * provided flag, working on Comparables.
	 * <p>
	 * When comparing two non-null objects, their Comparable implementation will
	 * be used: this means that non-null elements (that this Comparator will be
	 * applied to) need to implement Comparable.
	 * <p>
	 * As a convenience, you can use the default shared instances:
	 * <code>NullSafeComparator.NULLS_LOW</code> and
	 * <code>NullSafeComparator.NULLS_HIGH</code>.
	 * 
	 * @param nullsLow
	 *            whether to treat nulls lower or higher than non-null objects
	 * @see java.lang.Comparable
	 * @see #NULLS_LOW
	 * @see #NULLS_HIGH
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private NullSafeComparator(boolean nullsLow) {
		this.nonNullComparator = new ComparableComparator();
		this.nullsLow = nullsLow;
	}

	/**
	 * Create a NullSafeComparator that sorts <code>null</code> based on the
	 * provided flag, decorating the given Comparator.
	 * <p>
	 * When comparing two non-null objects, the specified Comparator will be
	 * used. The given underlying Comparator must be able to handle the elements
	 * that this Comparator will be applied to.
	 * 
	 * @param comparator
	 *            the comparator to use when comparing two non-null objects
	 * @param nullsLow
	 *            whether to treat nulls lower or higher than non-null objects
	 */
	public NullSafeComparator(Comparator<T> comparator, boolean nullsLow) {
		if (comparator == null) {
			throw new IllegalArgumentException("The non-null comparator is require");
		}
		this.nonNullComparator = comparator;
		this.nullsLow = nullsLow;
	}

	@Override
	public int compare(T o1, T o2) {
		if (o1 == o2) {
			return 0;
		}
		if (o1 == null) {
			return (this.nullsLow ? -1 : 1);
		}
		if (o2 == null) {
			return (this.nullsLow ? 1 : -1);
		}
		return this.nonNullComparator.compare(o1, o2);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof NullSafeComparator)) {
			return false;
		}
		NullSafeComparator other = (NullSafeComparator) obj;
		return (this.nonNullComparator.equals(other.nonNullComparator) && (this.nullsLow == other.nullsLow));
	}

	@Override
	public int hashCode() {
		return (this.nullsLow ? -1 : 1) * this.nonNullComparator.hashCode();
	}

	@Override
	public String toString() {
		return "NullSafeComparator: non-null comparator [" + this.nonNullComparator + "]; " + (this.nullsLow ? "nulls low" : "nulls high");
	}
}
