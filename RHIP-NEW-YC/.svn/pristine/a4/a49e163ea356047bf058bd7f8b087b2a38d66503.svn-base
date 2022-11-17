/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.exception;

public final class ExceptionUtil {

	private ExceptionUtil() {
	}

	/**
	 * 根据指定Throwable获取最顶层的Throwable 如果指定的Throwable已经是最顶层，则直接返回指定的Throwable
	 * 
	 * @param e
	 *            目标异常
	 * @return Throwable 目标异常对应的最顶层异常
	 */
	public static Throwable getTopThrowable(Throwable e) {
		Throwable t = e.getCause();
		if (t == null) {
			return e;
		}
		Throwable topT = null;
		for (; t != null; t = t.getCause()) {
			topT = t;
		}
		return topT;
	}
}
