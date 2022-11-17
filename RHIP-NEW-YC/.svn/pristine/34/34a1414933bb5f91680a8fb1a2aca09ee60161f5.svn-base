/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */
package com.founder.fasf.cache;

import java.util.Map;

public interface Cache {

	/**
	 * Clear the cache
	 */
	public void clear() throws CacheException;

	/**
	 * Clean up
	 */
	public void destroy() throws CacheException;

	/**
	 * Get an item from the cache, nontransactionally
	 * 
	 * @param key
	 * @return the cached object or <tt>null</tt>
	 * @throws CacheException
	 */
	public Object get(Object key) throws CacheException;

	/**
	 * The count of entries currently contained in the regions in-memory store.
	 * 
	 * @return The count of entries in memory; -1 if unknown or unsupported.
	 */
	public long getElementCountInMemory();

	/**
	 * The count of entries currently contained in the regions disk store.
	 * 
	 * @return The count of entries on disk; -1 if unknown or unsupported.
	 */
	public long getElementCountOnDisk();

	/**
	 * Get the name of the cache region
	 */
	public String getRegionName();

	/**
	 * The number of bytes is this cache region currently consuming in memory.
	 * 
	 * @return The number of bytes consumed by this region; -1 if unknown or
	 *         unsupported.
	 */
	public long getSizeInMemory();

	/**
	 * Get a reasonable "lock timeout"
	 */
	public int getTimeout();

	/**
	 * If this is a clustered cache, lock the item
	 */
	public void lock(Object key) throws CacheException;

	/**
	 * Generate a timestamp
	 */
	public long nextTimestamp();

	/**
	 * Add an item to the cache, nontransactionally, with failfast semantics
	 * 
	 * @param key
	 * @param value
	 * @throws CacheException
	 */
	public void put(Object key, Object value) throws CacheException;

	/**
	 * Get an item from the cache
	 * 
	 * @param key
	 * @return the cached object or <tt>null</tt>
	 * @throws CacheException
	 */
	public Object read(Object key) throws CacheException;

	/**
	 * Remove an item from the cache
	 */
	public void remove(Object key) throws CacheException;

	/**
	 * optional operation
	 */
	@SuppressWarnings("rawtypes")
	public Map toMap();

	/**
	 * If this is a clustered cache, unlock the item
	 */
	public void unlock(Object key) throws CacheException;

	/**
	 * Add an item to the cache
	 * 
	 * @param key
	 * @param value
	 * @throws CacheException
	 */
	public void update(Object key, Object value) throws CacheException;
}
