/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.exception;

public class AuthenticationException extends RuntimeException {

	private static final long serialVersionUID = 7090787379424967604L;

	public AuthenticationException() {
		super();
	}

	public AuthenticationException(String message) {
		super(message);
	}

	public AuthenticationException(String message, Throwable exception) {
		super(message, exception);
	}

	public AuthenticationException(Throwable exception) {
		super(exception);
	}
}
