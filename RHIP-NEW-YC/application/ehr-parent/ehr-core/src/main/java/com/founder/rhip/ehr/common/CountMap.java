package com.founder.rhip.ehr.common;

import java.util.HashMap;
import java.util.Map;

public class CountMap {
	
	private Map<String, Integer> sumMap = new HashMap<String, Integer>();
	
	/**
	 * 
	 * @param key
	 */
	public void add(String key) {
		add(key, 1);
	}
	
	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void add(String key, int value) {
		sumMap.put(key, get(key) + value);
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public int get(String key) {
		Integer count = sumMap.get(key);
		return (count == null ? 0 : count);
	}

}
