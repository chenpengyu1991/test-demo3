/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */
package com.founder.fasf.map;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A simple LRU cache that implements the <code>Map</code> interface. Instances
 * are not thread-safe and should be synchronized externally, for instance by
 * using {@link java.util.Collections#synchronizedMap}.
 * 
 * @author Manuel Dominguez Sarmiento
 */
@SuppressWarnings("rawtypes")
public class LRUMap extends LinkedHashMap implements Serializable {

	private static final long serialVersionUID = -5522608033020688048L;

	private final int maxEntries;

	public LRUMap(int maxEntries) {
		super(maxEntries, .75f, true);
		this.maxEntries = maxEntries;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry eldest) {
		return (size() > maxEntries);
	}
}