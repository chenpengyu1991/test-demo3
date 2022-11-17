/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.exception;

import java.io.Serializable;

public class MessageCode implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;


	private final String code;

	private final MessageType type;
	
	protected MessageCode(final String messageCode, final MessageType messageType) {
		code = messageCode;
		type = messageType;
	}
	
	public final String getCode() {
		return code;
	}

	public final MessageType getType() {
		return type;
	}
}
