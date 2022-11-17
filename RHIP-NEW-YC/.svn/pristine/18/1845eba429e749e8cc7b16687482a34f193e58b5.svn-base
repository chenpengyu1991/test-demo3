/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */
package com.founder.fasf.collection;

import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Set implementation that use == instead of equals() as its comparison
 * mechanism. This is achieved by internally using an IdentityHashMap.
 * 
 * @author Emmanuel Bernard
 */
@SuppressWarnings("rawtypes")
public class IdentitySet implements Set {

	private static final Object DUMP_VALUE = new Object();

	private final IdentityHashMap map;

	/**
	 * Create an IdentitySet with default sizing.
	 */
	public IdentitySet() {
		map = new IdentityHashMap();
	}

	/**
	 * Create an IdentitySet with the given sizing.
	 * 
	 * @param sizing
	 *            The sizing of the set to create.
	 */
	public IdentitySet(int sizing) {
		map = new IdentityHashMap(sizing);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(Object o) {
		return map.put(o, DUMP_VALUE) == null;
	}

	@Override
	public boolean addAll(Collection c) {
		Iterator it = c.iterator();
		boolean changed = false;
		while (it.hasNext()) {
			if (add(it.next())) {
				changed = true;
			}
		}
		return changed;
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public boolean contains(Object o) {
		return map.get(o) == DUMP_VALUE;
	}

	@Override
	public boolean containsAll(Collection c) {
		Iterator it = c.iterator();
		while (it.hasNext()) {
			if (!map.containsKey(it.next())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public Iterator iterator() {
		return map.keySet().iterator();
	}

	@Override
	public boolean remove(Object o) {
		return map.remove(o) == DUMP_VALUE;
	}

	@Override
	public boolean removeAll(Collection c) {
		Iterator it = c.iterator();
		boolean changed = false;
		while (it.hasNext()) {
			if (remove(it.next())) {
				changed = true;
			}
		}
		return changed;
	}

	@Override
	public boolean retainAll(Collection c) {
		// doable if needed
		throw new UnsupportedOperationException();
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public Object[] toArray() {
		return map.keySet().toArray();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] toArray(Object[] a) {
		return map.keySet().toArray(a);
	}
}
