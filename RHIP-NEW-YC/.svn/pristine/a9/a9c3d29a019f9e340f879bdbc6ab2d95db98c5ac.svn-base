 /*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */
package com.founder.fasf.map;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * A <tt>Map</tt> where keys are compared by object identity, rather than
 * <tt>equals()</tt>.
 */
public final class IdentityMap<K, V> implements Map<K, V> {

	public static final class IdentityKey<K> implements Serializable {

		/**
		 * Fields .....
		 */
		private static final long serialVersionUID = -3243192368034904537L;

		private K key;

		IdentityKey(K key) {
			this.key = key;
		}


		@SuppressWarnings("rawtypes")
		@Override
		public boolean equals(Object other) {
			return key == ((IdentityKey) other).key;
		}

		public K getRealKey() {
			return key;
		}

		@Override
		public int hashCode() {
			return System.identityHashCode(key);
		}

		@Override
		public String toString() {
			return key.toString();
		}
	}

	public static final class IdentityMapEntry<K, V> implements java.util.Map.Entry<K, V> {

		private K key;

		private V value;

		IdentityMapEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			V result = this.value;
			this.value = value;
			return result;
		}
	}

	static final class KeyIterator<K> implements Iterator<K> {

		private final Iterator<IdentityKey<K>> identityKeyIterator;

		private KeyIterator(Iterator<IdentityKey<K>> iterator) {
			identityKeyIterator = iterator;
		}

		@Override
		public boolean hasNext() {
			return identityKeyIterator.hasNext();
		}

		@Override
		public K next() {
			return identityKeyIterator.next().getRealKey();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * Return the map entries (as instances of <tt>Map.Entry</tt> in a
	 * collection that is safe from concurrent modification). ie. we may safely
	 * add new instances to the underlying <tt>Map</tt> during iteration of the
	 * <tt>entries()</tt>.
	 * 
	 * @param map
	 *            The map of entries
	 * @return Collection
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> Map.Entry<K, V>[] concurrentEntries(Map<K, V> map) {
		return ((IdentityMap<K, V>) map).entryArray();
	}

	/**
	 * Return a new instance of this class, with iteration order defined as the
	 * order in which entries were added
	 * 
	 * @param size
	 *            The size of the map to create
	 * @return The map
	 */
	public static <K, V> IdentityMap<K, V> instantiateSequenced(int size) {
		return new IdentityMap<K, V>(new LinkedHashMap<IdentityKey<K>, V>(size));
	}

	private final Map<IdentityKey<K>, V> map;

	@SuppressWarnings({ "unchecked" })
	private transient Entry<IdentityKey<K>, V>[] entryArray = new Entry[0];

	private transient boolean dirty = false;

	/**
	 * Private ctor used in serialization.
	 * 
	 * @param underlyingMap
	 *            The delegate map.
	 */
	private IdentityMap(Map<IdentityKey<K>, V> underlyingMap) {
		map = underlyingMap;
		dirty = true;
	}

	@Override
	public void clear() {
		dirty = true;
		entryArray = null;
		map.clear();
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean containsKey(Object key) {
		return map.containsKey(new IdentityKey(key));
	}

	@Override
	public boolean containsValue(Object val) {
		return map.containsValue(val);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map.Entry[] entryArray() {
		if (dirty) {
			entryArray = new Map.Entry[map.size()];
			Iterator itr = map.entrySet().iterator();
			int i = 0;
			while (itr.hasNext()) {
				Map.Entry me = (Map.Entry) itr.next();
				entryArray[i++] = new IdentityMapEntry(((IdentityKey) me.getKey()).key, me.getValue());
			}
			dirty = false;
		}
		return entryArray;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		Set<Entry<K, V>> set = new HashSet<Entry<K, V>>(map.size());
		for (Entry<IdentityKey<K>, V> entry : map.entrySet()) {
			set.add(new IdentityMapEntry<K, V>(entry.getKey().getRealKey(), entry.getValue()));
		}
		return set;
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public V get(Object key) {
		return map.get(new IdentityKey(key));
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	public Iterator<K> keyIterator() {
		return new KeyIterator<K>(map.keySet().iterator());
	}

	@Override
	public Set<K> keySet() {
		// would need an IdentitySet for this!
		throw new UnsupportedOperationException();
	}

	@Override
	public V put(K key, V value) {
		dirty = true;
		return map.put(new IdentityKey<K>(key), value);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> otherMap) {
		for (Entry<? extends K, ? extends V> entry : otherMap.entrySet()) {
			put(entry.getKey(), entry.getValue());
		}
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public V remove(Object key) {
		dirty = true;
		return map.remove(new IdentityKey(key));
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public String toString() {
		return map.toString();
	}

	@Override
	public Collection<V> values() {
		return map.values();
	}
}