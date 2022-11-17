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
 * An JoinedIterable is an Iterable that wraps a number of Iterables.
 * 
 * This class makes multiple iterables look like one to the caller. When any
 * method from the Iterator interface is called on the Iterator object returned
 * by {@link #iterator()}, the JoinedIterable will delegate to a single
 * underlying Iterator. The JoinedIterable will invoke the iterator on each
 * Iterable, in sequence, until all Iterators are exhausted.
 * 
 * @author Gail Badner (adapted from JoinedIterator)
 */
public class JoinedIterable<T> implements Iterable<T> {

	@SuppressWarnings("hiding")
	private class TypeSafeJoinedIterator<T> implements Iterator<T> {

		// wrapped iterators
		private List<Iterable<T>> iterables;

		// index of current iterator in the wrapped iterators array
		private int currentIterableIndex;

		// the current iterator
		private Iterator<T> currentIterator;

		// the last used iterator
		private Iterator<T> lastUsedIterator;

		public TypeSafeJoinedIterator(List<Iterable<T>> iterables) {
			this.iterables = iterables;
		}

		@Override
		public boolean hasNext() {
			updateCurrentIterator();
			return currentIterator.hasNext();
		}

		@Override
		public T next() {
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
		@SuppressWarnings({ "unchecked" })
		protected void updateCurrentIterator() {
			if (currentIterator == null) {
				if (iterables.size() == 0) {
					currentIterator = EmptyIterator.INSTANCE;
				} else {
					currentIterator = iterables.get(0).iterator();
				}
				// set last used iterator here, in case the user calls remove
				// before calling hasNext() or next() (although they shouldn't)
				lastUsedIterator = currentIterator;
			}
			while (!currentIterator.hasNext() && (currentIterableIndex < (iterables.size() - 1))) {
				currentIterableIndex++;
				currentIterator = iterables.get(currentIterableIndex).iterator();
			}
		}
	}

	private final TypeSafeJoinedIterator<T> iterator;

	public JoinedIterable(List<Iterable<T>> iterables) {
		if (iterables == null) {
			throw new NullPointerException("Unexpected null iterables argument");
		}
		iterator = new TypeSafeJoinedIterator<T>(iterables);
	}

	@Override
	public Iterator<T> iterator() {
		return iterator;
	}
}
