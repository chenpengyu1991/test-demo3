/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */
package com.founder.fasf.cache;

/**
 * Something went wrong in the cache
 */
public class CacheException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6258696383822846248L;

	public CacheException(String s) {
		super(s);
	}

	public CacheException(String string, Throwable root) {
		super(string, root);
	}

	public CacheException(Throwable root) {
		super(root);
	}
}