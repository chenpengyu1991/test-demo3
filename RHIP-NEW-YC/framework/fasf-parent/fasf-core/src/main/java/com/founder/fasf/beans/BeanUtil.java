
package com.founder.fasf.beans;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.WrapDynaClass;

import com.founder.fasf.reflect.ReflectUtil;
import com.founder.fasf.util.BaseUtil;
import com.founder.fasf.util.ObjectUtil;

public abstract class BeanUtil extends BaseUtil {


	public static List<String> getModelAttributeNames(Record record, boolean needCustomFields) {
		java.util.Set<String> propertySet = record.getPropertyNames();
		java.util.List<String> sortedList = new java.util.ArrayList<String>(propertySet.size());
		for (String property : propertySet) {
			if (!(needCustomFields ^ isValidCustomFieldName(property))) {
				sortedList.add(property);
			}
		}
		Collections.sort(sortedList);
		return sortedList;
	}

	public static boolean isValidCustomFieldName(String fieldName) {
		if (!fieldName.startsWith("custom") && !fieldName.startsWith("bcustom")) {
			return false;
		} else {
			String fieldNumberStr = null;
			if (fieldName.startsWith("custom")) {
				fieldNumberStr = fieldName.substring(6);
			} else if (fieldName.startsWith("bcustom")) {
				fieldNumberStr = fieldName.substring(7);
			}
			Integer fieldNumber = Integer.valueOf(fieldNumberStr);
			// That allows signs and other stuff also
			if ((fieldNumber <= 0) || (fieldNumber > 30)) {
				return false;
			}
		}
		return true;
	}

	public static String getModifiedFieldName(String fieldName, String prefix) {
		StringBuilder modifiedName = new StringBuilder(fieldName);
		modifiedName.setCharAt(0, Character.toUpperCase(modifiedName.charAt(0)));
		modifiedName.insert(0, prefix);
		return modifiedName.toString();
	}

	public static void extractClassProperties(WrapDynaClass theClass, Map<String, String> visitMap, List<String> properties, String parent) {
		if (theClass == null) {
			return;
		}
		for (DynaProperty property : theClass.getDynaProperties()) {
			boolean visitedAlready = (visitMap.get(property.getType().getName()) != null);
			log.debug("Checking to see if type " + property.getType().getName() + " has been visited already returns " + visitedAlready);
			if (!property.getType().getName().startsWith("java") && !visitedAlready) {
				WrapDynaClass dynaClass = WrapDynaClass.createDynaClass(property.getType());
				extractClassProperties(dynaClass, visitMap, properties, parent + property.getName() + ".");
			} else {
				if (!property.getType().getName().equalsIgnoreCase("java.lang.Class")) {
					log.debug("Adding type " + property.getType().getName() + " to the list of types visited already.");
					visitMap.put(property.getType().getName(), property.getType().getName());
					properties.add(parent + property.getName());
				}
			}
		}
	}

	public static List<String> getDynaProperties(Object obj) {
		List<String> properties = new ArrayList<String>();
		Map<String, String> visitMap = new HashMap<String, String>();
		visitMap.put(obj.getClass().getName(), obj.getClass().getName());
		WrapDynaClass topClass = WrapDynaClass.createDynaClass(obj.getClass());
		extractClassProperties(topClass, visitMap, properties, "");
		return properties;
	}

	/**
	 * Method to convert a ResourceBundle to a Map object.
	 * 
	 * @param rb
	 *            a given resource bundle
	 * @return Map a populated map
	 */
	public static Map<String, String> convertBundleToMap(ResourceBundle rb) {
		Map<String, String> map = new HashMap<String, String>();
		Enumeration<String> keys = rb.getKeys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			map.put(key, rb.getString(key));
		}
		return map;
	}

	/**
	 * Convenience method used by tests to populate an object from a
	 * ResourceBundle
	 * 
	 * @param obj
	 *            an initialized object
	 * @param rb
	 *            a resource bundle
	 * @return a populated object
	 */
	public static Object populateObject(Object obj, ResourceBundle rb) {
		try {
			Map<String, String> map = convertBundleToMap(rb);
			BeanUtils.copyProperties(obj, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getWarpBean(Class<T> clazz, Map<String, Object> map) {
		Object result;
		ClassMetadata cMetadata = ClassMetadata.getMetadata(clazz);
		String entityName = ReflectUtil.getShortName(clazz) + '.';
		LinkedHashMap<String, PropertyMetadata> pMetata = cMetadata.getProperty();
		LinkedHashMap<String,String> columns=cMetadata.getColumns();
		try {
			result = clazz.newInstance();
			for (String key : map.keySet()) {
				int bIndex = key.indexOf(entityName);
				String propertyName = bIndex >= 0 ? key.substring(entityName.length(), key.length()) : key;	
				if(columns.containsKey(propertyName.toUpperCase())){propertyName=columns.get(propertyName.toUpperCase()); }
				PropertyMetadata propertyMetada = pMetata.get(propertyName);
				if (ObjectUtil.isNotEmpty(propertyMetada) && map.get(key)!=null) {
					PropertyDescriptor descriptor = propertyMetada.getPropertyDescriptor();
					Object value = ObjectUtil.convertValue(descriptor.getPropertyType(), map.get(key));
					if (value != null) {
						descriptor.getWriteMethod().invoke(result, new Object[]{value});
					}
				}
			}
			return (T) result;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clazz, Map<String, Object[]> map) {
		Object result;
		ClassMetadata classMetadata = ClassMetadata.getMetadata(clazz);
		String entityName = ReflectUtil.getShortName(clazz) + '.';
		LinkedHashMap<String, PropertyMetadata> propertyMetata = classMetadata.getProperty();
		try {
			result = clazz.newInstance();
			for (String key : map.keySet()) {
				int bIndex = key.indexOf(entityName);
				String propertyName = bIndex >= 0 ? key.substring(entityName.length(), key.length()) : key;
				PropertyMetadata propertyMetada = propertyMetata.get(propertyName);
				if (ObjectUtil.isNotEmpty(propertyMetada) && map.get(key).length > 0) {
					PropertyDescriptor descriptor = propertyMetada.getPropertyDescriptor();
					Object[] value = ObjectUtil.convertValue(descriptor.getPropertyType(), map.get(key));
					if (value != null && value.length > 0) {
						descriptor.getWriteMethod().invoke(result, value);
					}
				}
			}
			return (T) result;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Criteria getCriteria(Map<String, Object[]> map) {
		if (map == null || map.size() < 1) {
			return null;
		} else {
			Criteria result = new Criteria();
			for (String key : map.keySet()) {
				String[] parameters = key.split(":");
				if (parameters.length != 3) {
					continue;
				}
				Class<?> clazz = ObjectUtil.getClass(parameters[1].trim());
				if (map.get(key).length > 0) {
					Object[] value = ObjectUtil.convertValue(clazz, map.get(key));
					if (value != null && value.length > 0) {
						if (value.length == 1) {
							result.addCriterion(new Criterion(parameters[0], clazz, parameters[2], value[0]));
						} else {
							result.addCriterion(new Criterion(parameters[0], clazz, parameters[2], value));
						}
					}
				}
			}
			return result;
		}
	}

}
