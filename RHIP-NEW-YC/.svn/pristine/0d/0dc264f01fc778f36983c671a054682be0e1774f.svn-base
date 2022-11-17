/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. You
 * shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.builder.HashCodeBuilder;

import com.founder.fasf.util.DateUtil;

/**
 * 
 * @author DenggaoLi
 * 
 */
public class Record implements Map<String, Object>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7399222384028288070L;

	/*
	 * private static String getDate(Date aDate) { SimpleDateFormat df; String
	 * returnValue = ""; if (aDate != null) { df = new
	 * SimpleDateFormat("yyyy-MM-dd"); returnValue = df.format(aDate); } return
	 * (returnValue); }
	 */
	private Long recordId;

	// private Object object;
	// private ConvertingWrapDynaBean dynaBean;
	// private RecordTypeDef recordTypeDefinition;
	private Map<String, Object> mapObject;

	public Record() {
		mapObject = new HashMap<String, Object>();
	}
	
	//Attention: this convert is only used by tiny data operation
	public Record(Object object) {
        if (object != null) {
            ConvertingWrapDynaBean bean = new ConvertingWrapDynaBean(object);
            mapObject = bean.getPropertyMap();
        }
	}

	public Record(Map<String, Object> object, Class<?> clazz) {
		if (object == null) {
			return;
		}
		ClassMetadata cMetadata = ClassMetadata.getMetadata(clazz);
		LinkedHashMap<String, String> columns = cMetadata.getColumns();
		mapObject = new HashMap<String, Object>();
		for (String key : object.keySet()) {
			if (columns.containsKey(key)) {
				mapObject.put(columns.get(key), object.get(key));
			} else {
				mapObject.put(key, object.get(key));
			}
		}
	}

	/*
	 * public Record(Object object) { this.object = object; dynaBean = new
	 * ConvertingWrapDynaBean(object); values=getMap(); }
	 */
	public Record(Map<String, Object> object, Class<?> clazz, Long recordId) {
		this(object, clazz);
		this.recordId = recordId;
	}

	public String getAsString(String fieldName) {
		Object o = mapObject.get(fieldName);
		if (o == null) return null;
		if (o instanceof String) return (String)o;
		if (o instanceof Date) return DateUtil.toDateString((Date)o, null);
		return o.toString();
	}

	public Long getAsLong(String fieldName) {
		Object o = mapObject.get(fieldName);
		if (o == null) return null;
		if (o instanceof Long) return (Long)o;
		if (o instanceof BigDecimal) return ((BigDecimal)o).longValue();
		return Long.valueOf(o.toString());
	}

	public Integer getAsInteger(String fieldName) {
		Object o = mapObject.get(fieldName);
		if (o == null) return null;
		if (o instanceof Integer) return (Integer)o;
		if (o instanceof BigDecimal) return ((BigDecimal)o).intValue();
		return Integer.parseInt(o.toString());
	}

	public Double getAsDouble(String fieldName) {
		Object o = mapObject.get(fieldName);
		if (o == null) return null;
		if (o instanceof Double) return (Double)o;
		if (o instanceof BigDecimal) return ((BigDecimal)o).doubleValue();
		return Double.parseDouble(o.toString());
	}

	public Float getAsFloat(String fieldName) {
		Object o = mapObject.get(fieldName);
		if (o == null) return null;
		if (o instanceof Float) return (Float)o;
		if (o instanceof BigDecimal) return ((BigDecimal)o).floatValue();
		return Float.parseFloat(o.toString());
	}

	public Date getAsDate(String fieldName) {
		return (Date)mapObject.get(fieldName);
	}

	public Boolean getAsBoolean(String fieldName) {
		return (Boolean) mapObject.get(fieldName);
	}

	public Object get(String fieldName) {
		return mapObject.get(fieldName);
	}

	public Set<String> getPropertyNames() {
		return mapObject.keySet();// dynaBean.getPropertyNames();
	}

	/*
	 * private String className;
	 * 
	 * public synchronized String getClassName() {
	 * 
	 * if(className==null){ className=object.getClass().getSimpleName(); }
	 * return className; }
	 * 
	 * public synchronized RecordTypeDef getRecordDef() { if
	 * (recordTypeDefinition == null) { recordTypeDefinition = new
	 * RecordTypeDef(object); } return recordTypeDefinition; }
	 */
	public Map<String, Object> getMap() {
		return mapObject;
	}

	// public Map<String, Object> getMap() {
	// if (this == null) {
	// return null;
	// }
	// Map<String, Object> map = new HashMap<String, Object>();
	// for (String field : getPropertyNames()) {
	// Object value = get(field);
	// if (value != null && !value.toString().trim().equals("")) {
	// map.put(field, value);
	// }
	// }
	// return map;
	// }
	public Long getRecordId() {
		return recordId;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(recordId).toHashCode();
	}

	public void set(String fieldName, Object value) {
		mapObject.put(fieldName, value);
		// dynaBean.set(fieldName, value);
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}
	/*
	 * @Override public String toString() { return new
	 * ToStringBuilder(this).append("recordId", recordId).append("dynaBean",
	 * dynaBean).append("recordTypeDefinition",
	 * recordTypeDefinition).toString(); }
	 */

	@Override
	public void clear() {
		mapObject.clear();
	}

	@Override
	public boolean containsKey(Object arg0) {
		return mapObject.containsKey(arg0);
	}

	@Override
	public boolean containsValue(Object arg0) {
		return mapObject.containsValue(arg0);
	}

	@Override
	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		return mapObject.entrySet();
	}

	@Override
	public Object get(Object arg0) {
		return mapObject.get(arg0);
	}

	@Override
	public boolean isEmpty() {
		return mapObject.isEmpty();
	}

	@Override
	public Set<String> keySet() {
		return mapObject.keySet();
	}

	@Override
	public Object put(String arg0, Object arg1) {
		return mapObject.put(arg0, arg1);
	}

	@Override
	public void putAll(Map<? extends String, ? extends Object> arg0) {
		mapObject.putAll(arg0);
	}

	@Override
	public Object remove(Object arg0) {
		return mapObject.remove(arg0);
	}

	@Override
	public int size() {
		return mapObject.size();
	}

	@Override
	public Collection<Object> values() {
		return mapObject.values();
	}
}
