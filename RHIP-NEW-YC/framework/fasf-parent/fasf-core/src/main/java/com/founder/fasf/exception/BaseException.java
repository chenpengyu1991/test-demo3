/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.exception;

/**
 * 
 */
public class BaseException extends RuntimeException {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	public BaseException() {
	}

	/**
	 * @param message
	 */
	public BaseException(final String message) {
		super(message);
	}

	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public BaseException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * 
	 * 
	 * @param cause
	 */
	public BaseException(final Throwable cause) {
		super(cause);
	}
}
