package com.founder.rhip.ehr.service.star.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.annotation.DisplayField;
import com.founder.rhip.ehr.annotation.Star;
import com.founder.rhip.ehr.common.StarType;

public class StarUtil {
	private static Map<String, List<Field>> cache = new HashMap<String, List<Field>>(5);
	private static Map<String, List<Field>> displayFieldCache = new HashMap<String, List<Field>>(5);

	/**
	 * 获取计算星级的属性
	 * 
	 * @param cls
	 * @param type
	 * @return
	 */
	public static List<Field> getFields(Class<?> cls, StarType type) {
		String key = cls + "_" + type;
		List<Field> result = cache.get(key);
		if (result == null) {
			synchronized ( StarUtil.class ) {
				if (!cache.containsKey(key)) {
					 result =  doGetFields(cls, type);
					 cache.put(key, result);
				}
			}
			
		}
		return result;
	}
	
	/**
	 * 获取显示的属性
	 * @param cls
	 * @param type
	 * @return
	 */
	public static List<Field> getDisplayFields(Class<?> cls, StarType type){
		String key = cls + "_" + type;
		List<Field> result = displayFieldCache.get(key);
		if (result == null) {
			synchronized ( StarUtil.class ) {
				if (!displayFieldCache.containsKey(key)) {
					 result =  doGetDisplayField(cls, type);
					 displayFieldCache.put(key, result);
				}
			}
			
		}
		return result;
	}

	/**
	 * 根据类和星级类型返回属性
	 * 
	 * @param cls
	 *            ：对象类型
	 * @param type
	 *            ：星级档案类型
	 * @return
	 */
	private static List<Field> doGetFields(Class<?> cls, StarType type) {
		List<Field> fieldList = new ArrayList<Field>();
		Set<String> medNames = new HashSet<String>();
		Method[] methods = cls.getMethods();
		for (Method method : methods) {
			medNames.add(method.getName());
		}
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Star.class)) {
				Star star = field.getAnnotation(Star.class);
				if (star.star().equals(type)) {
					String fildeName = field.getName();
					if (medNames.contains("get" + getMethodName(fildeName)) && medNames.contains("set" + getMethodName(fildeName))) {
						fieldList.add(field);
					}
				}
			}
		}
		return fieldList;
	}

	private static String getMethodName(String fildeName) {
		byte[] items = fildeName.getBytes();
		items[0] = (byte) ((char) items[0] - 'a' + 'A');
		return new String(items);
	}

	public static boolean valid(String... strings) {
		boolean result = false;
		for (String string : strings) {
			result = valid(string);
			if (!result) {
				break;
			}
		}
		return result;
	}

	public static boolean valid(Integer... ints) {
		boolean result = false;
		for (Integer i : ints) {
			result = valid(i);
			if (!result) {
				break;
			}
		}
		return result;
	}

	public static boolean valid(BigDecimal... ints) {
		boolean result = false;
		for (BigDecimal i : ints) {
			result = valid(i);
			if (!result) {
				break;
			}
		}
		return result;
	}

    public static boolean valid(Float... ints) {
        boolean result = false;
        for (Float i : ints) {
            result = valid(i);
            if (!result) {
                break;
            }
        }
        return result;
    }

	public static boolean valid(Integer i) {
		return null != i && 0 != i;
	}

    public static boolean valid(Float i) {
        return null !=i && 0 != i;
    }

	public static boolean valid(Long i) {
		return null != i && 0 != i;
	}

	public static boolean valid(BigDecimal i) {
		return null != i && !i.equals(new BigDecimal("0"));
	}

	public static boolean valid(String string) {
		return null != string && string.trim().length() > 0;
	}

	public static boolean valid(Object object) {
		if (null == object) {
			return false;
		}
		Class<?> cls = object.getClass();
		if (Integer.class.isAssignableFrom(cls)) {
			return valid((Integer) object);
		} else if (Long.class.isAssignableFrom(cls)) {
			return valid((Long) object);
		} else if (String.class.isAssignableFrom(cls)) {
			return valid((String) object);
		} else if (BigDecimal.class.isAssignableFrom(cls)) {
			return valid((BigDecimal) object);
		} else {
			return true;
		}
	}

	public static BigDecimal div(Integer v1,Integer v2) {
		if (null==v1||0==v1||null==v2||0==v2) {
			return new BigDecimal("0");
		}
		BigDecimal b1 = new BigDecimal(Integer.toString(v1));
		BigDecimal b2 = new BigDecimal(Integer.toString(v2));
		return b1.divide(b2, 2, BigDecimal.ROUND_DOWN);
	}
	
	private static List<Field> doGetDisplayField(Class<?> cls ,StarType starType){
		List<Field> fieldList = new ArrayList<Field>();
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			DisplayField displayfield = field.getAnnotation(DisplayField.class);
			if(ObjectUtil.isNotEmpty(displayfield) && displayfield.star().equals(starType)){
				fieldList.add(field);
			}
		}
		return fieldList;
	}

}
