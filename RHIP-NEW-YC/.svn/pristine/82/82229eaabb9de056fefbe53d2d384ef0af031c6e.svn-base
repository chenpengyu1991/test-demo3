/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.collection;

import java.util.Iterator;
import java.util.Map;

@SuppressWarnings("rawtypes")
public final class LazyIterator implements Iterator {

	private final Map map;

	private Iterator iterator;

	public LazyIterator(Map map) {
		this.map = map;
	}

	private Iterator getIterator() {
		if (iterator == null) {
			iterator = map.values().iterator();
		}
		return iterator;
	}

	@Override
	public boolean hasNext() {
		return getIterator().hasNext();
	}

	@Override
	public Object next() {
		return getIterator().next();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
