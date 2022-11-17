 /*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.compare;

import java.util.Calendar;
import java.util.Comparator;

/**
 * @author Gavin King
 */
@SuppressWarnings("rawtypes")
public class CalendarComparator implements Comparator {

	public static final Comparator INSTANCE = new CalendarComparator();

	@Override
	public int compare(Object x, Object y) {
		Calendar xcal = (Calendar) x;
		Calendar ycal = (Calendar) y;
		if (xcal.before(ycal)) {
			return -1;
		}
		if (xcal.after(ycal)) {
			return 1;
		}
		return 0;
	}
}
