/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */
package com.founder.fasf.cache;

import java.io.IOException;
import java.io.Serializable;

import com.founder.fasf.map.LRUMap;

/**
 * Cache following a "Most Recently Used" (MRU) algorithm for maintaining a
 * bounded in-memory size; the "Least Recently Used" (LRU) entry is the first
 * available for removal from the cache.
 * <p/>
 * This implementation uses a bounded MRU Map to limit the in-memory size of the
 * cache. Thus the size of this cache never grows beyond the stated size.
 * 
 * @author Steve Ebersole
 */
public class SimpleMRUCache implements Serializable {

	/**
	 * Fields .....
	 */
	private static final long serialVersionUID = -7684341573331273922L;

	public static final int DEFAULT_STRONG_REF_COUNT = 128;

	private final int strongReferenceCount;

	private transient LRUMap cache;

	public SimpleMRUCache() {
		this(DEFAULT_STRONG_REF_COUNT);
	}

	public SimpleMRUCache(int strongReferenceCount) {
		this.strongReferenceCount = strongReferenceCount;
		init();
	}

	public synchronized void clear() {
		cache.clear();
	}

	public synchronized Object get(Object key) {
		return cache.get(key);
	}

	private void init() {
		cache = new LRUMap(strongReferenceCount);
	}

	@SuppressWarnings("unchecked")
	public synchronized Object put(Object key, Object value) {
		return cache.put(key, value);
	}

	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		init();
	}

	public synchronized int size() {
		return cache.size();
	}
}
