/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.exception;

public class InitializationException extends RuntimeException {

	private static final long serialVersionUID = -3892027771172929962L;

	public InitializationException() {
		super();
	}

	public InitializationException(String message) {
		super(message);
	}

	public InitializationException(String message, Throwable exception) {
		super(message, exception);
	}

	public InitializationException(Throwable exception) {
		super(exception);
	}
}
