package com.founder.rhip.mdm.app;

import au.com.bytecode.opencsv.CSVReader;
import net.sf.cglib.beans.BeanMap;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestUtil {
	
	public static <T> List<T> readData(String fileName, Class<T> clazz, String encoding) {
		List<T> list = new ArrayList<T>();
		InputStream is = TestUtil.class.getClassLoader().getResourceAsStream("data/" + fileName + ".csv");
		try {
			CSVReader reader = new CSVReader(new InputStreamReader(is, encoding));
			try {
		        String[] fieldLine = reader.readNext();
		        reader.readNext();
		        String[] nextLine;
		        while ((nextLine = reader.readNext()) != null) {
		        	T o = clazz.newInstance();
		        	BeanMap beanMap = BeanMap.create(o);
		        	for (int i = 0; i < fieldLine.length; i++) {
		        		if (i >= nextLine.length) {
		            		continue;
		            	}
		                String fieldName = fieldLine[i];
		                String value = nextLine[i].trim();
		                if (value == null || "".equals(value.trim())) {
		                    continue;
		                }
		                setValue(beanMap, fieldName, value);
		        	}
		        	list.add(o);
		        }
			} finally {
				reader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	private static void setValue(BeanMap beanMap, String fieldName, String value) throws ParseException {
		if (fieldName.contains("@")) {
			String[] vals = fieldName.split("@");
            SimpleDateFormat df = new SimpleDateFormat(vals[1]);
            Date date = df.parse(value);
            beanMap.put(vals[0], date);
        } else {
        	Class clazz = beanMap.getPropertyType(fieldName);
        	if (Float.class.equals(clazz)) {
        		beanMap.put(fieldName, Float.parseFloat(value));
        	} else if (Double.class.equals(clazz)) {
        		beanMap.put(fieldName, Double.parseDouble(value));
        	} else if (Integer.class.equals(clazz)) {
        		beanMap.put(fieldName, Integer.parseInt(value));
        	} else if (Long.class.equals(clazz)) {
        		beanMap.put(fieldName, Long.parseLong(value));
        	} else if (Boolean.class.equals(clazz)) {
        		beanMap.put(fieldName, Boolean.parseBoolean(value));
        	} else {
        		beanMap.put(fieldName, value);
        	}
        }
    }
}
