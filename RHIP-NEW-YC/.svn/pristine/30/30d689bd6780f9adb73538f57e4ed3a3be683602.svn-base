package com.founder.rhip.ep.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.PropertyMetadata;

public class ServiceUtil {
	
	private static final String[] deleteProperties = new String[] {"updatePerson", "updateOrgan", "updateTime", "deleteFlag"};
	
	private static final String[] notUpdateProperties = new String[] {"id", "createPerson", "createOrgan", "createTime", "deleteFlag"};
	
	public static String[] getUpdateProperties(Class<?> cls) {
		return getNotContainsProperties(cls, notUpdateProperties);
	}
	
	public static String[] getDeleteProperties() {
		return deleteProperties;
	}
	
	public static String[] getNotContainsProperties(Class<?> cls, String... notContains) {
		List<String> properties = new ArrayList<String>();
		ClassMetadata cMetadata = ClassMetadata.getMetadata(cls);
		LinkedHashMap<String, PropertyMetadata> pMetadata= cMetadata.getProperty();
		Set<String> keyset = pMetadata.keySet();
		List<String> notContainsList = Arrays.asList(notContains);
		for (String key : keyset) {
			if (!notContainsList.contains(key)) {
				PropertyMetadata metadata = pMetadata.get(key);
				if (metadata.isDbField()) {
					properties.add(key);
				}
			}
		}
		//properties.remove("serialVersionUID");
		return properties.toArray(new String[]{});
	}

}
