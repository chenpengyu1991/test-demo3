/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */
package com.founder.fasf.cache;

public interface ICache<T> {

	void cleanAll();

	boolean containsKey(String key);

	T getCache(String key);

	void remove(String... key);

	void setCache(String key, T t);
}
