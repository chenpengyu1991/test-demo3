
package com.founder.fasf.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.founder.fasf.util.StringUtil;

public class IndexMap {

	private Map<String, Map<Object, Set<Integer>>> indexMap;

	public IndexMap(List<String> properties) {
		indexMap = new HashMap<String, Map<Object, Set<Integer>>>();
		for (String p : properties) {
			indexMap.put(p, new HashMap<Object, Set<Integer>>());
		}
	}

	public void clear() {
		for (String key : indexMap.keySet()) {
			for (Object obj : indexMap.get(key).keySet()) {
				indexMap.get(key).get(obj).clear();
			}
		}
	}

	public void setIndex(String propertyName, Object key, Integer index) {
		if (StringUtil.isNullOrEmpty(propertyName) || null == key || null == index || index < 0) {
			return;
		}
		if (!indexMap.containsKey(propertyName)) {
			indexMap.put(propertyName, new HashMap<Object, Set<Integer>>());
		}
		if (!indexMap.get(propertyName).containsKey(key)) {
			indexMap.get(propertyName).put(key, new HashSet<Integer>());
		}
		indexMap.get(propertyName).get(key).add(index);
	}

	public boolean containsKey(String propertyName, Object key) {
		return indexMap.containsKey(propertyName) && indexMap.get(propertyName).containsKey(key);
	}

	public Set<Integer> getIndexSet(String propertyName, Object key) {
		return indexMap.get(propertyName).get(key);
	}
}