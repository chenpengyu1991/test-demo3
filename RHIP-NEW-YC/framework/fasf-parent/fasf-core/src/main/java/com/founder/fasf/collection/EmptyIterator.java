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
public final class EmptyIterator implements Iterator {

	public static final Iterator INSTANCE = new EmptyIterator();

	private EmptyIterator() {
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Object next() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
