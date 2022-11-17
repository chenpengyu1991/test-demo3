/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.exception;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = -5235890872962251059L;

	public ValidationException() {
		super();
	}

	public ValidationException(String message) {
		super(message);
	}

	public ValidationException(String message, Throwable exception) {
		super(message, exception);
	}

	public ValidationException(Throwable exception) {
		super(exception);
	}
}
