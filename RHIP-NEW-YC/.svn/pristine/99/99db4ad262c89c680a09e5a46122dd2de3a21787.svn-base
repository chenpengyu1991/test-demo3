/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.collection;

import java.util.Iterator;

/**
 * @author Gavin King
 */
@SuppressWarnings("rawtypes")
public final class SingletonIterator implements Iterator {

	private Object value;

	private boolean hasNext = true;

	public SingletonIterator(Object value) {
		this.value = value;
	}

	@Override
	public boolean hasNext() {
		return hasNext;
	}

	@Override
	public Object next() {
		if (hasNext) {
			hasNext = false;
			return value;
		} else {
			throw new IllegalStateException();
		}
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
