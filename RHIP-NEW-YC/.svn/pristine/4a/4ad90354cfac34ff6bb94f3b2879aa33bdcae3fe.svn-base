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
 * Comparator that adapts Comparables to the Comparator interface. Mainly for
 * internal use in other Comparators, when supposed to work on Comparables.
 * 
 * @author Keith Donald
 * @since 1.2.2
 * @see Comparable
 */
public class ComparableComparator<T extends Comparable<T>> implements Comparator<T> {

	@SuppressWarnings("rawtypes")
	public static final Comparator INSTANCE = new ComparableComparator();
	@Override
	public int compare(T o1, T o2) {
		return o1.compareTo(o2);
	}
}
