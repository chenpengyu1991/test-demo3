/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.founder.fasf.exception.RepositoryException;
import com.founder.fasf.util.StringUtil;

/**
 * Collection of helper methods for dealing with configuration settings.
 * 
 * @author Denggao Li
 */
public final class ConfigurationUtil {

	private static final String PLACEHOLDER_START = "${";
	
	private static final Logger LOG = Logger.getLogger(ConfigurationUtil.class);

	/**
	 * Disallow instantiation
	 */
	private ConfigurationUtil() {
	}

	/**
	 * Make a clone of the configuration values.
	 * 
	 * @param configurationValues
	 *            The config values to clone
	 * 
	 * @return The clone
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map clone(Map<?, ?> configurationValues) {
		if (configurationValues == null) {
			return null;
		}
		// If a Properties object, leverage its clone() impl
		if (Properties.class.isInstance(configurationValues)) {
			return (Properties) ((Properties) configurationValues).clone();
		}
		// Otherwise make a manual copy
		HashMap clone = new HashMap();
		for (Map.Entry entry : configurationValues.entrySet()) {
			clone.put(entry.getKey(), entry.getValue());
		}
		return clone;
	}

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
	 * Get the config value as a boolean (default of false)
	 * 
	 * @param name
	 *            The config setting name.
	 * @param values
	 *            The map of config values
	 * 
	 * @return The value.
	 */
	@SuppressWarnings("rawtypes")
	public static boolean getBoolean(String name, Map values) {
		return getBoolean(name, values, false);
	}

	/**
	 * Get the config value as a boolean.
	 * 
	 * @param name
	 *            The config setting name.
	 * @param values
	 *            The map of config values
	 * @param defaultValue
	 *            The default value to use if not found
	 * 
	 * @return The value.
	 */
	@SuppressWarnings("rawtypes")
	public static boolean getBoolean(String name, Map values, boolean defaultValue) {
		Object value = values.get(name);
		if (value == null) {
			return defaultValue;
		}
		if (Boolean.class.isInstance(value)) {
			return ((Boolean) value).booleanValue();
		}
		if (String.class.isInstance(value)) {
			return Boolean.parseBoolean((String) value);
		}
		throw new ConfigurationException("Could not determine how to handle configuration value [name=" + name + ", value=" + value + "] as boolean");
	}

	/**
	 * Get the config value as an int
	 * 
	 * @param name
	 *            The config setting name.
	 * @param values
	 *            The map of config values
	 * @param defaultValue
	 *            The default value to use if not found
	 * 
	 * @return The value.
	 */
	@SuppressWarnings("rawtypes")
	public static int getInt(String name, Map values, int defaultValue) {
		Object value = values.get(name);
		if (value == null) {
			return defaultValue;
		}
		if (Integer.class.isInstance(value)) {
			return ((Integer) value).intValue();
		}
		if (String.class.isInstance(value)) {
			return Integer.parseInt((String) value);
		}
		throw new ConfigurationException("Could not determine how to handle configuration value [name=" + name + ", value=" + value + "(" + value.getClass().getName()
				+ ")] as int");
	}

	/**
	 * Get the config value as an {@link Integer}
	 * 
	 * @param name
	 *            The config setting name.
	 * @param values
	 *            The map of config values
	 * 
	 * @return The value, or null if not found
	 */
	@SuppressWarnings("rawtypes")
	public static Integer getInteger(String name, Map values) {
		Object value = values.get(name);
		if (value == null) {
			return null;
		}
		if (Integer.class.isInstance(value)) {
			return (Integer) value;
		}
		if (String.class.isInstance(value)) {
			// empty values are ignored
			final String trimmed = value.toString().trim();
			if (trimmed.isEmpty()) {
				return null;
			}
			return Integer.valueOf(trimmed);
		}
		throw new ConfigurationException("Could not determine how to handle configuration value [name=" + name + ", value=" + value + "(" + value.getClass().getName()
				+ ")] as Integer");
	}

	/**
	 * Get the config value as a {@link String}
	 * 
	 * @param name
	 *            The config setting name.
	 * @param values
	 *            The map of config values
	 * 
	 * @return The value, or null if not found
	 */
	@SuppressWarnings("rawtypes")
	public static String getString(String name, Map values) {
		Object value = values.get(name);
		if (value == null) {
			return null;
		}
		if (String.class.isInstance(value)) {
			return (String) value;
		}
		return value.toString();
	}

	/**
	 * Get the config value as a {@link String}
	 * 
	 * @param name
	 *            The config setting name.
	 * @param values
	 *            The map of config values
	 * @param defaultValue
	 *            The default value to use if not found
	 * 
	 * @return The value.
	 */
	@SuppressWarnings("rawtypes")
	public static String getString(String name, Map values, String defaultValue) {
		final String value = getString(name, values);
		return value == null ? defaultValue : value;
	}

	/**
	 * replace a property by a starred version
	 * 
	 * @param props
	 *            properties to check
	 * @param key
	 *            proeprty to mask
	 * 
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
	 * @param configurationValues
	 *            The configuration map.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void resolvePlaceHolders(Map<?, ?> configurationValues) {
		Iterator itr = configurationValues.entrySet().iterator();
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
	 * Try to locate a local URL representing the incoming path. This method
	 * <b>only</b> attempts to locate this URL as a java system resource.
	 * 
	 * @param path
	 *            The path representing the config location.
	 * @return An appropriate URL or null.
	 */
	public static URL findAsResource(final String path) {
		URL url = null;
		// First, try to locate this resource through the current
		// context classloader.
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		if (contextClassLoader != null) {
			url = contextClassLoader.getResource(path);
		}
		if (url != null) {
			return url;
		}
		// Next, try to locate this resource through this class's classloader
		url = ConfigurationUtil.class.getClassLoader().getResource(path);
		if (url != null) {
			return url;
		}
		// Next, try to locate this resource through the system classloader
		url = ClassLoader.getSystemClassLoader().getResource(path);
		// Anywhere else we should look?
		return url;
	}

	/**
	 * Loads a properties instance based on the data at the incoming config
	 * location.
	 * 
	 * @param path
	 *            The path representing the config location.
	 * @return The loaded properties instance.
	 * @throws RepositoryException
	 *             Unable to load properties from that resource.
	 */
	public static Properties getConfigProperties(String path) throws ConfigurationException {
		try {
			Properties properties = new Properties();
			properties.load(getConfigStream(path));
			return properties;
		} catch (IOException e) {
			throw new ConfigurationException("Unable to load properties from specified config file: " + path, e);
		}
	}

	/**
	 * Open an InputStream to the URL represented by the incoming path. First
	 * makes a call to {@link #locateConfig(java.lang.String)} in order to find
	 * an appropriate URL. {@link java.net.URL#openStream()} is then called to
	 * obtain the stream.
	 * 
	 * @param path
	 *            The path representing the config location.
	 * @return An input stream to the requested config resource.
	 * @throws RepositoryException
	 *             Unable to open stream to that resource.
	 */
	public static InputStream getConfigStream(final String path) throws ConfigurationException {
		final URL url = ConfigurationUtil.locateConfig(path);
		if (url == null) {
			String msg = "";// LOG.unableToLocateConfigFile(path);
			LOG.error(msg);
			throw new ConfigurationException(msg);
		}
		try {
			return url.openStream();
		} catch (IOException e) {
			throw new ConfigurationException("Unable to open config file: " + path, e);
		}
	}

	/**
	 * Open an Reader to the URL represented by the incoming path. First makes a
	 * call to {@link #locateConfig(java.lang.String)} in order to find an
	 * appropriate URL. {@link java.net.URL#openStream()} is then called to
	 * obtain a stream, which is then wrapped in a Reader.
	 * 
	 * @param path
	 *            The path representing the config location.
	 * @return An input stream to the requested config resource.
	 * @throws RepositoryException
	 *             Unable to open reader to that resource.
	 */
	public static Reader getConfigStreamReader(final String path) throws ConfigurationException {
		return new InputStreamReader(getConfigStream(path));
	}

	public static InputStream getResourceAsStream(String resource) {
		String stripped = resource.startsWith("/") ? resource.substring(1) : resource;
		InputStream stream = null;
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if (classLoader != null) {
			stream = classLoader.getResourceAsStream(stripped);
		}
		/*
		 * if ( stream == null ) { stream =
		 * Environment.class.getResourceAsStream( resource ); } if ( stream ==
		 * null ) { stream =
		 * Environment.class.getClassLoader().getResourceAsStream( stripped ); }
		 */
		if (stream == null) {
			throw new ConfigurationException(resource + " not found");
		}
		return stream;
	}

	public static InputStream getUserResourceAsStream(String resource) {
		boolean hasLeadingSlash = resource.startsWith("/");
		String stripped = hasLeadingSlash ? resource.substring(1) : resource;
		InputStream stream = null;
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if (classLoader != null) {
			stream = classLoader.getResourceAsStream(resource);
			if ((stream == null) && hasLeadingSlash) {
				stream = classLoader.getResourceAsStream(stripped);
			}
		}
		/*
		 * if ( stream == null ) { stream =
		 * Environment.class.getClassLoader().getResourceAsStream( resource ); }
		 * if ( stream == null && hasLeadingSlash ) { stream =
		 * Environment.class.getClassLoader().getResourceAsStream( stripped ); }
		 */
		if (stream == null) {
			throw new ConfigurationException(resource + " not found");
		}
		return stream;
	}

	/**
	 * Try to locate a local URL representing the incoming path. The first
	 * attempt assumes that the incoming path is an actual URL string (file://,
	 * etc). If this does not work, then the next attempts try to locate this
	 * UURL as a java system resource.
	 * 
	 * @param path
	 *            The path representing the config location.
	 * @return An appropriate URL or null.
	 */
	public static URL locateConfig(final String path) {
		try {
			return new URL(path);
		} catch (MalformedURLException e) {
			return findAsResource(path);
		}
	}
}
