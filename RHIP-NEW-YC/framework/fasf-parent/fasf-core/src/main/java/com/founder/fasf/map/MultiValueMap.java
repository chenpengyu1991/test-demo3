/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.map;

import java.util.List;
import java.util.Map;

/**
 * Extension of the {@code Map} interface that stores multiple values.
 * 
 * @author Arjen Poutsma
 * @since 3.0
 */
public interface MultiValueMap<K, V> extends Map<K, List<V>> {

	/**
	 * Add the given single value to the current list of values for the given
	 * key.
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value to be added
	 */
	void add(K key, V value);

	/**
	 * Return the first value for the given key.
	 * 
	 * @param key
	 *            the key
	 * @return the first value for the specified key, or <code>null</code>
	 */
	V getFirst(K key);

	/**
	 * Set the given single value under the given key.
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value to set
	 */
	void set(K key, V value);

	/**
	 * Set the given values under.
	 * 
	 * @param values
	 *            the values.
	 */
	void setAll(Map<K, V> values);

	/**
	 * Returns the first values contained in this {@code MultiValueMap}.
	 * 
	 * @return a single value representation of this map
	 */
	Map<K, V> toSingleValueMap();
}
