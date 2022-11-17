
package com.founder.fasf.beans;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;

import com.founder.fasf.reflect.ReflectUtil;
import com.founder.fasf.util.StringUtil;

public class ClassMetadata implements Serializable {

	/**
	 * Fields .....
	 */
	private static final long serialVersionUID = -8782013587911001006L;

	private String entity;

	private String table;

	private String primaryKey;

	private String propertiesIndexTempString;

	private LinkedHashMap<String, String> columns;

	private LinkedHashMap<String, PropertyMetadata> property;

	private Map<String, Integer> propertiesIndexHashMap;

	private static Map<String, ClassMetadata> classMetadataMap = new HashMap<String, ClassMetadata>();

	public static ClassMetadata getMetadata(Class<?> clazz) {
		synchronized (classMetadataMap) {
			String key = clazz.getName();
			if (!classMetadataMap.containsKey(key)) {
				classMetadataMap.put(key, new ClassMetadata(clazz));
			}
			return classMetadataMap.get(key);
		}
	}

	private ClassMetadata() {
	}

	private ClassMetadata(Class<?> clazz) {
		this.entity = clazz.getName();
		Table table = clazz.getAnnotation(Table.class);
		if (table != null) {
			this.table = table.name();
		}
		this.property = new LinkedHashMap<String, PropertyMetadata>();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			this.property.put(field.getName(), new PropertyMetadata(field));
		}
		PropertyDescriptor[] propertyDescriptors = ReflectUtil.getPropertyDescriptors(clazz);
		for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			if (property.containsKey(propertyDescriptor.getName())) {
				property.get(propertyDescriptor.getName()).setPropertyDescriptor(propertyDescriptor);
			}
		}
		this.columns = new LinkedHashMap<String, String>();
		for (PropertyMetadata propertyMetada : property.values()) {
			String column = propertyMetada.getColumn();
			if (column != null) {
				columns.put(column.toUpperCase(), propertyMetada.getName());
			}
			if (propertyMetada.isPrimayKey()) {
				// primaryKey = propertyMetada.getColumn();
				primaryKey = propertyMetada.getName();
			}
		}
		this.propertiesIndexHashMap = new HashMap<String, Integer>();
		if (propertiesIndexHashMap.size() == 0) {
			int count = 0;
			for (String pKey : property.keySet()) {
				propertiesIndexHashMap.put(pKey, count);
				count++;
			}
		}
		
		if (StringUtil.isNullOrEmpty(propertiesIndexTempString)) {
			propertiesIndexTempString = StringUtils.rightPad("", propertiesIndexHashMap.size(), "0");
		}
	}

	public String getEntity() {
		return entity;
	}

	public LinkedHashMap<String, PropertyMetadata> getProperty() {
		return property;
	}

	public String getTable() {
		return table;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public void setProperty(LinkedHashMap<String, PropertyMetadata> property) {
		this.property = property;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public LinkedHashMap<String, String> getColumns() {
		return columns;
	}

	public void setColumns(LinkedHashMap<String, String> columns) {
		this.columns = columns;
	}

	public Map<String, Integer> getPropertiesIndexHashMap() {
		return propertiesIndexHashMap;
	}

	public void setPropertiesIndexHashMap(Map<String, Integer> propertiesIndexHashMap) {
		this.propertiesIndexHashMap = propertiesIndexHashMap;
	}

	public String getPropertiesIndexTempString() {
		return propertiesIndexTempString;
	}

	public void setPropertiesIndexTempString(String propertiesIndexTempString) {
		this.propertiesIndexTempString = propertiesIndexTempString;
	}
}
