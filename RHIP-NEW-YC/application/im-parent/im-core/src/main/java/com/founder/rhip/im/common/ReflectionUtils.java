package com.founder.rhip.im.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.ConvertingWrapDynaBean;
import com.founder.fasf.beans.PropertyMetadata;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;


public class ReflectionUtils {
	
	private static final Logger log = Logger.getLogger(ReflectionUtils.class);
	public static final String columnDefSeparator = "|";
	public static final String SERIALVERSIONUID = "serialVersionUID";
	
	// 构造方法私有
	private ReflectionUtils() {
	}
	
	public static Method getMethod(Class<?> clazz, String field, String prefix, Class<?>... args) {
		if (ObjectUtil.isNotEmpty(clazz) && ObjectUtil.isNotEmpty(field)) {
			try {
				Method m = clazz.getMethod(prefix + StringUtil.capitalize(field), args);
				return m;
			} catch (NoSuchMethodException e) {
				log.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (SecurityException e) {
				log.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static Object invokeMethod(Method m, Object o, Object... args) {
		if (ObjectUtil.isNullOrEmpty(m) || ObjectUtil.isNullOrEmpty(o)) {
			return null;
		}
		
		try {
			return m.invoke(o, args);
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		return null;
	}
	
	
    public static Object createInstance(Class<?> clazz) {
    	Object o = null;
    	try {
			if (ObjectUtil.isNotEmpty(clazz)) {
				o = clazz.newInstance();
			}
		} catch (InstantiationException e) {
			log.error(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(), e);
		}
    	return o;
    }
    
    /**
     * 用指定对象中的相同属性的值来填充目标对象
     * @param clazz
     * @param objects
     * @return
     */
    @SuppressWarnings("unchecked")
	public static <T> T wrapBean(Class<T> clazz, Object... objects) {
    	if (clazz == null || objects == null) {
			return null;
		}
    	
    	//创建将要被赋值的实体对象
    	T t = (T) createInstance(clazz);
    	
    	// 以实体对象创建动态Bean
    	ConvertingWrapDynaBean dynaBean = new ConvertingWrapDynaBean(t);
    	
    	// 获取类元数据/
    	ClassMetadata classMetadata = ClassMetadata.getMetadata(clazz);
    	LinkedHashMap<String, PropertyMetadata> propertyMetadaMap = classMetadata.getProperty();
    	
    	// 遍历目标类属性
    	for (Iterator<String> iterator = propertyMetadaMap.keySet().iterator(); iterator.hasNext();) {
    		String field = iterator.next();
    		PropertyMetadata propertyMetadata = null;
    		if (StringUtils.isBlank(field) || (propertyMetadata = propertyMetadaMap.get(field)) == null) {
				continue;
			}

    		// 获取column注解中的columnDefinition值，取分隔符"|"中间的中文说明部分
			String columnDefinition = StringUtils.substringBetween(propertyMetadata.getDataType(), columnDefSeparator, columnDefSeparator);
			for (Object object : objects) {
				wrap(dynaBean, object, columnDefinition, field, propertyMetadata);
			}
    	}
    	return t;
    }
    
    private static <T> void wrap(ConvertingWrapDynaBean dynaBean, Object object, String columnDefinition, String refField, PropertyMetadata propertyMetadata) {
		if (dynaBean == null || object == null || StringUtils.isBlank(columnDefinition)
				|| StringUtils.isBlank(refField) || propertyMetadata == null) {
			return;
		}
		
		// 转换动态bean对象
		ConvertingWrapDynaBean actualDynaBean = new ConvertingWrapDynaBean(object);
		
		Class<?> cls = object.getClass();
		// 获取类元数据
		ClassMetadata cmd = ClassMetadata.getMetadata(cls);
		LinkedHashMap<String, PropertyMetadata> pmdMap = cmd.getProperty();
		
		// 循环比较属性对应的中文说明是否相同，如果相同取该属性值设置到目标类对象中
		for (Iterator<String> it = pmdMap.keySet().iterator(); it.hasNext();) {
			String actualField = it.next();
			PropertyMetadata pm = null;
			if (StringUtils.isBlank(actualField) || (pm = pmdMap.get(actualField)) == null) {
				continue;
			}
		
			// 获得类属性的中文说明指定部分位于两条分割线"|"之中
			String cdf = StringUtils.substringBetween(pm.getDataType(), columnDefSeparator, columnDefSeparator);
			if (StringUtils.equals(cdf, columnDefinition)) {
				Object o = actualDynaBean.get(actualField);
				// 设置对象属性值
				if (ObjectUtil.isNotEmpty(o)) {
					dynaBean.set(refField, o);
				}
				break;
			}
		}
    }
   
	/**
	 * 获取某个类的所有字段
	 * @param clazz
	 * @return
	 */
	public static List<String> getFields(Class<?> clazz) {
		List<String> fields = new ArrayList<String>();
		if (ObjectUtil.isNotEmpty(clazz)) {
			ClassMetadata classMetadata = ClassMetadata.getMetadata(clazz);
			LinkedHashMap<String, PropertyMetadata> propertyMetada = classMetadata.getProperty();
			for (Iterator<String> iterator = propertyMetada.keySet().iterator(); iterator.hasNext();) {
				String name = iterator.next();
				if (ObjectUtil.isNullOrEmpty(name) || name.equalsIgnoreCase(SERIALVERSIONUID)) {
					continue;
				}
				fields.add(name);
			}
		}
		return fields;
	}
}
