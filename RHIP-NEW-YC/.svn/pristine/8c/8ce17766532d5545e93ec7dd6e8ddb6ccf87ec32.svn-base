/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. You
 * shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.beans;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

import com.founder.fasf.map.FastHashMap;
import com.founder.fasf.util.ObjectUtil;

@SuppressWarnings("serial")
public class ConvertingWrapDynaBean extends org.apache.commons.beanutils.ConvertingWrapDynaBean {

	protected Logger log = Logger.getLogger(this.getClass());

	public ConvertingWrapDynaBean(Object instance) {
		super(instance);
	}

	@Override
	public Object get(String name) {
		Object value = null;
		try {
			value = PropertyUtils.getNestedProperty(instance, name);
		} catch (InvocationTargetException ite) {
			Throwable cause = ite.getTargetException();
			throw new IllegalArgumentException("Error reading property '" + name + "' nested exception - " + cause);
		} catch (Throwable t) {
			throw new IllegalArgumentException("Error reading property '" + name + "', exception - " + t);
		}
		return (value);
	}

	@SuppressWarnings("unchecked")
	public Set<String> getPropertyNames() {
		Set<String> properties = new HashSet<String>();
		try {
			@SuppressWarnings("rawtypes")
			Map map = BeanUtils.describe(getInstance());
			for (Iterator<String> iter = map.keySet().iterator(); iter.hasNext();) {
				String name = iter.next();
				if (!name.equals("class")) {
					properties.add(name);
				}
			}
		} catch (Exception e) {
			log.warn("Failed while extracting bean properties: " + e, e);
		}
		return properties;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPropertyMap() {
		if (this == null) {
			return null;
		}
		Map<String, Object> map = null;
		Map<String, Object> newMap = new FastHashMap();
		try {
			map = BeanUtils.describe(getInstance());
			for (String name : map.keySet()) {
				if (!name.equals("class") && !ObjectUtil.isNullOrEmpty(map.get(name))) {
					newMap.put(name, get(name));
				}
			}
		} catch (Exception e) {
			log.warn("Failed while extracting bean properties: " + e, e);
		}
		return newMap;
	}
}
