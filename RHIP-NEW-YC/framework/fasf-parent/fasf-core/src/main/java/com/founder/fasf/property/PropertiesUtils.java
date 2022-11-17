/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

public class PropertiesUtils {

	private static final String PLACEHOLDER_START = "${";

	private static String extractFromSystem(String systemPropertyName) {
		try {
			return System.getProperty(systemPropertyName);
		} catch (Throwable t) {
			return null;
		}
	}

	/**
	 * Extract a property value by name from the given properties object.
	 * <p/>
	 * Both <tt>null</tt> and <tt>empty string</tt> are viewed as the same, and
	 * return null.
	 * 
	 * @param propertyName
	 *            The name of the property for which to extract value
	 * @param properties
	 *            The properties object
	 * @return The property value; may be null.
	 */
	public static String extractPropertyValue(String propertyName, Properties properties) {
		String value = properties.getProperty(propertyName);
		if (value == null) {
			return null;
		}
		value = value.trim();
		if (StringUtil.isNullOrEmpty(value)) {
			return null;
		}
		return value;
	}

	/**
	 * Get a property value as a boolean. Shorthand for calling
	 * {@link #getBoolean(String, java.util.Properties, boolean)} with
	 * <tt>false</tt> as the default value.
	 * 
	 * @param propertyName
	 *            The name of the property for which to retrieve value
	 * @param properties
	 *            The properties object
	 * @return The property value.
	 */
	public static boolean getBoolean(String propertyName, Properties properties) {
		return getBoolean(propertyName, properties, false);
	}

	/**
	 * Get a property value as a boolean.
	 * <p/>
	 * First, the string value is extracted, and then
	 * {@link Boolean#valueOf(String)} is used to determine the correct boolean
	 * value.
	 * 
	 * @see #extractPropertyValue(String, java.util.Properties)
	 * 
	 * @param propertyName
	 *            The name of the property for which to retrieve value
	 * @param properties
	 *            The properties object
	 * @param defaultValue
	 *            The default property value to use.
	 * @return The property value.
	 */
	public static boolean getBoolean(String propertyName, Properties properties, boolean defaultValue) {
		String value = extractPropertyValue(propertyName, properties);
		return value == null ? defaultValue : Boolean.valueOf(value).booleanValue();
	}

	/**
	 * Get a property value as an int.
	 * <p/>
	 * First, the string value is extracted, and then
	 * {@link Integer#parseInt(String)} is used to determine the correct int
	 * value for any non-null property values.
	 * 
	 * @see #extractPropertyValue(String, java.util.Properties)
	 * 
	 * @param propertyName
	 *            The name of the property for which to retrieve value
	 * @param properties
	 *            The properties object
	 * @param defaultValue
	 *            The default property value to use.
	 * @return The property value.
	 */
	public static int getInt(String propertyName, Properties properties, int defaultValue) {
		String value = extractPropertyValue(propertyName, properties);
		return value == null ? defaultValue : Integer.parseInt(value);
	}

	/**
	 * Get a property value as an Integer.
	 * <p/>
	 * First, the string value is extracted, and then
	 * {@link Integer#valueOf(String)} is used to determine the correct boolean
	 * value for any non-null property values.
	 * 
	 * @see #extractPropertyValue(String, java.util.Properties)
	 * 
	 * @param propertyName
	 *            The name of the property for which to retrieve value
	 * @param properties
	 *            The properties object
	 * @return The property value; may be null.
	 */
	public static Integer getInteger(String propertyName, Properties properties) {
		String value = extractPropertyValue(propertyName, properties);
		return value == null ? null : Integer.valueOf(value);
	}

	/**
	 * Get a property value as a string.
	 * 
	 * @see #extractPropertyValue(String, java.util.Properties)
	 * 
	 * @param propertyName
	 *            The name of the property for which to retrieve value
	 * @param properties
	 *            The properties object
	 * @param defaultValue
	 *            The default property value to use.
	 * @return The property value; may be null.
	 */
	public static String getString(String propertyName, Properties properties, String defaultValue) {
		String value = extractPropertyValue(propertyName, properties);
		return value == null ? defaultValue : value;
	}

	/**
	 * Load a Properties File
	 * 
	 * @param propsFile
	 * @return Properties
	 * @throws IOException
	 */
	public static Properties load(File propsFile) throws IOException {
		Properties props = new Properties();
		FileInputStream fis = new FileInputStream(propsFile);
		props.load(fis);
		fis.close();
		return props;
	}

	/**
	 * Load a properties file from the classpath
	 * 
	 * @param propsName
	 * @return Properties
	 * @throws Exception
	 */
	public static Properties load(String propsName) throws Exception {
		Properties props = new Properties();
		props.load(PropertiesUtils.class.getClassLoader().getResourceAsStream(propsName));
		return props;
	}

	/**
	 * replace a property by a starred version
	 * 
	 * @param props
	 *            properties to check
	 * @param key
	 *            proeprty to mask
	 * @return cloned and masked properties
	 */
	public static Properties maskOut(Properties props, String key) {
		Properties clone = (Properties) props.clone();
		if (clone.get(key) != null) {
			clone.setProperty(key, "****");
		}
		return clone;
	}

	/**
	 * Handles interpolation processing for a single property.
	 * 
	 * @param property
	 *            The property value to be processed for interpolation.
	 * @return The (possibly) interpolated property value.
	 */
	public static String resolvePlaceHolder(String property) {
		if (property.indexOf(PLACEHOLDER_START) < 0) {
			return property;
		}
		StringBuffer buff = new StringBuffer();
		char[] chars = property.toCharArray();
		for (int pos = 0; pos < chars.length; pos++) {
			if (chars[pos] == '$') {
				// peek ahead
				if (chars[pos + 1] == '{') {
					// we have a placeholder, spin forward till we find the end
					String systemPropertyName = "";
					int x = pos + 2;
					for (; (x < chars.length) && (chars[x] != '}'); x++) {
						systemPropertyName += chars[x];
						// if we reach the end of the string w/o finding the
						// matching end, that is an exception
						if (x == (chars.length - 1)) {
							throw new IllegalArgumentException("unmatched placeholder start [" + property + "]");
						}
					}
					String systemProperty = extractFromSystem(systemPropertyName);
					buff.append(systemProperty == null ? "" : systemProperty);
					pos = x + 1;
					// make sure spinning forward did not put us past the end of
					// the buffer...
					if (pos >= chars.length) {
						break;
					}
				}
			}
			buff.append(chars[pos]);
		}
		String rtn = buff.toString();
		return StringUtil.isNullOrEmpty(rtn) ? null : rtn;
	}

	/**
	 * Handles interpolation processing for all entries in a properties object.
	 * 
	 * @param properties
	 *            The properties object.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void resolvePlaceHolders(Properties properties) {
		Iterator itr = properties.entrySet().iterator();
		while (itr.hasNext()) {
			final Map.Entry entry = (Map.Entry) itr.next();
			final Object value = entry.getValue();
			if ((value != null) && String.class.isInstance(value)) {
				final String resolved = resolvePlaceHolder((String) value);
				if (!value.equals(resolved)) {
					if (resolved == null) {
						itr.remove();
					} else {
						entry.setValue(resolved);
					}
				}
			}
		}
	}

	/**
	 * Constructs a map from a property value.
	 * <p/>
	 * The exact behavior here is largely dependant upon what is passed in as
	 * the delimiter.
	 * 
	 * @see #extractPropertyValue(String, java.util.Properties)
	 * 
	 * @param propertyName
	 *            The name of the property for which to retrieve value
	 * @param delim
	 *            The string defining tokens used as both entry and key/value
	 *            delimiters.
	 * @param properties
	 *            The properties object
	 * @return The resulting map; never null, though perhaps empty.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map toMap(String propertyName, String delim, Properties properties) {
		Map map = new HashMap();
		String value = extractPropertyValue(propertyName, properties);
		if (value != null) {
			StringTokenizer tokens = new StringTokenizer(value, delim);
			while (tokens.hasMoreTokens()) {
				map.put(tokens.nextToken(), tokens.hasMoreElements() ? tokens.nextToken() : "");
			}
		}
		return map;
	}

	/**
	 * Convert a string to an array of strings. The assumption is that the
	 * individual array elements are delimited in the source stringForm param by
	 * the delim param.
	 * 
	 * @param stringForm
	 *            The string form of the string array.
	 * @param delim
	 *            The delimiter used to separate individual array elements.
	 * @return The array; never null, though may be empty.
	 */
	public static String[] toStringArray(String stringForm, String delim) {
		// todo : move to StringUtil?
		if (stringForm != null) {
			return StringUtil.split(delim, stringForm);
		} else {
			return new String[]{};
		}
	}

	/**
	 * Get a property value as a string array.
	 * 
	 * @see #extractPropertyValue(String, java.util.Properties)
	 * @see #toStringArray(String, String)
	 * 
	 * @param propertyName
	 *            The name of the property for which to retrieve value
	 * @param delim
	 *            The delimiter used to separate individual array elements.
	 * @param properties
	 *            The properties object
	 * @return The array; never null, though may be empty.
	 */
	public static String[] toStringArray(String propertyName, String delim, Properties properties) {
		return toStringArray(extractPropertyValue(propertyName, properties), delim);
	}
	
	/**
	 * Merge the given Properties instance into the given Map, copying all
	 * properties (key-value pairs) over.
	 * <p>
	 * Uses <code>Properties.propertyNames()</code> to even catch default
	 * properties linked into the original Properties instance.
	 * 
	 * @param props
	 *            the Properties instance to merge (may be <code>null</code>)
	 * @param map
	 *            the target Map to merge the properties into
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void mergePropertiesIntoMap(Properties props, Map map) {
		if (map == null) {
			throw new IllegalArgumentException("Map must not be null");
		}
		if (props != null) {
			for (Enumeration en = props.propertyNames(); en.hasMoreElements();) {
				String key = (String) en.nextElement();
				Object value = props.getProperty(key);
				if (value == null) {
					// Potentially a non-String value...
					value = props.get(key);
				}
				map.put(key, value);
			}
		}
	}

	private PropertiesUtils() {
	}
	
	/**
	 * Take an array Strings and split each element based on the given
	 * delimiter. A <code>Properties</code> instance is then generated, with the
	 * left of the delimiter providing the key, and the right of the delimiter
	 * providing the value.
	 * <p>
	 * Will trim both the key and value before adding them to the
	 * <code>Properties</code> instance.
	 * 
	 * @param array
	 *            the array to process
	 * @param delimiter
	 *            to split each element using (typically the equals symbol)
	 * @return a <code>Properties</code> instance representing the array
	 *         contents, or <code>null</code> if the array to process was null
	 *         or empty
	 */
	public static Properties splitArrayElementsIntoProperties(String[] array, String delimiter) {
		return splitArrayElementsIntoProperties(array, delimiter, null);
	}

	/**
	 * Take an array Strings and split each element based on the given
	 * delimiter. A <code>Properties</code> instance is then generated, with the
	 * left of the delimiter providing the key, and the right of the delimiter
	 * providing the value.
	 * <p>
	 * Will trim both the key and value before adding them to the
	 * <code>Properties</code> instance.
	 * 
	 * @param array
	 *            the array to process
	 * @param delimiter
	 *            to split each element using (typically the equals symbol)
	 * @param charsToDelete
	 *            one or more characters to remove from each element prior to
	 *            attempting the split operation (typically the quotation mark
	 *            symbol), or <code>null</code> if no removal should occur
	 * @return a <code>Properties</code> instance representing the array
	 *         contents, or <code>null</code> if the array to process was
	 *         <code>null</code> or empty
	 */
	public static Properties splitArrayElementsIntoProperties(String[] array, String delimiter, String charsToDelete) {
		if (ObjectUtil.isNullOrEmpty(array)) {
			return null;
		}
		Properties result = new Properties();
		for (String element : array) {
			if (charsToDelete != null) {
				element =element.replace(charsToDelete, "");
			}
			String[] splittedElement =element.split(delimiter);
					
			if (splittedElement == null) {
				continue;
			}
			result.setProperty(splittedElement[0].trim(), splittedElement[1].trim());
		}
		return result;
	}
}
