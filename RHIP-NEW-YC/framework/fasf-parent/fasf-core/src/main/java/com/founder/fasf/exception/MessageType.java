/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.exception;

public enum MessageType {

	INFO("I"),
	WARN("W"),	
	ERROR("E"),
	FATAL("F");
	private String shortName;

	
	private MessageType(final String prmShortName) {
		shortName = prmShortName;
	}
	
	public String getShortName() {
		return shortName;
	}
}
