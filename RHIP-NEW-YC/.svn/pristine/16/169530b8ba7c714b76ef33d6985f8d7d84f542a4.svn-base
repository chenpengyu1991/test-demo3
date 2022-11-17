 /*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */
package com.founder.fasf.collection;

import java.util.Iterator;
import java.util.List;

/**
 * An JoinedIterator is an Iterator that wraps a number of Iterators.
 * 
 * This class makes multiple iterators look like one to the caller. When any
 * method from the Iterator interface is called, the JoinedIterator will
 * delegate to a single underlying Iterator. The JoinedIterator will invoke the
 * Iterators in sequence until all Iterators are exhausted.
 * 
 */
@SuppressWarnings("rawtypes")
public class JoinedIterator implements Iterator {

	private static final Iterator[] ITERATORS = {};

	// wrapped iterators
	private Iterator[] iterators;

	// index of current iterator in the wrapped iterators array
	private int currentIteratorIndex;

	// the current iterator
	private Iterator currentIterator;

	// the last used iterator
	private Iterator lastUsedIterator;

	public JoinedIterator(Iterator first, Iterator second) {
		this(new Iterator[] { first, second });
	}

	public JoinedIterator(Iterator[] iterators) {
		if (iterators == null) {
			throw new NullPointerException("Unexpected NULL iterators argument");
		}
		this.iterators = iterators;
	}

	@SuppressWarnings("unchecked")
	public JoinedIterator(List iterators) {
		this((Iterator[]) iterators.toArray(ITERATORS));
	}

	@Override
	public boolean hasNext() {
		updateCurrentIterator();
		return currentIterator.hasNext();
	}

	@Override
	public Object next() {
		updateCurrentIterator();
		return currentIterator.next();
	}

	@Override
	public void remove() {
		updateCurrentIterator();
		lastUsedIterator.remove();
	}

	// call this before any Iterator method to make sure that the current
	// Iterator
	// is not exhausted
	protected void updateCurrentIterator() {
		if (currentIterator == null) {
			if (iterators.length == 0) {
				currentIterator = EmptyIterator.INSTANCE;
			} else {
				currentIterator = iterators[0];
			}
			// set last used iterator here, in case the user calls remove
			// before calling hasNext() or next() (although they shouldn't)
			lastUsedIterator = currentIterator;
		}
		while (!currentIterator.hasNext() && (currentIteratorIndex < (iterators.length - 1))) {
			currentIteratorIndex++;
			currentIterator = iterators[currentIteratorIndex];
		}
	}
}
