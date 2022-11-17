/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.property;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

import com.founder.fasf.util.Assert;
import com.founder.fasf.util.StringUtil;

/**
 * Utility class for working with Strings that have placeholder values in them.
 * A placeholder takes the form <code>${name}</code>. Using
 * <code>PropertyPlaceholderHelper</code> these placeholders can be substituted
 * for user-supplied values.
 * <p>
 * Values for substitution can be supplied using a {@link Properties} instance
 * or using a {@link PlaceholderResolver}.
 * 
 * @author Juergen Hoeller
 * @author Rob Harrop
 * @since 3.0
 */
public class PropertyPlaceholderHelper {

	/**
	 * Strategy interface used to resolve replacement values for placeholders
	 * contained in Strings.
	 * 
	 * @see PropertyPlaceholderHelper
	 */
	public static interface PlaceholderResolver {

		/**
		 * Resolves the supplied placeholder name into the replacement value.
		 * 
		 * @param placeholderName
		 *            the name of the placeholder to resolve.
		 * @return the replacement value or <code>null</code> if no replacement
		 *         is to be made.
		 */
		String resolvePlaceholder(String placeholderName);
	}

	private static final Logger logger = Logger.getLogger(PropertyPlaceholderHelper.class);

	private static final Map<String, String> wellKnownSimplePrefixes = new HashMap<String, String>(4);
	static {
		wellKnownSimplePrefixes.put("}", "{");
		wellKnownSimplePrefixes.put("]", "[");
		wellKnownSimplePrefixes.put(")", "(");
	}

	private final String placeholderPrefix;

	private final String placeholderSuffix;

	private final String simplePrefix;

	private final String valueSeparator;

	private final boolean ignoreUnresolvablePlaceholders;

	/**
	 * Creates a new <code>PropertyPlaceholderHelper</code> that uses the
	 * supplied prefix and suffix. Unresolvable placeholders are ignored.
	 * 
	 * @param placeholderPrefix
	 *            the prefix that denotes the start of a placeholder.
	 * @param placeholderSuffix
	 *            the suffix that denotes the end of a placeholder.
	 */
	public PropertyPlaceholderHelper(String placeholderPrefix, String placeholderSuffix) {
		this(placeholderPrefix, placeholderSuffix, null, true);
	}

	/**
	 * Creates a new <code>PropertyPlaceholderHelper</code> that uses the
	 * supplied prefix and suffix.
	 * 
	 * @param placeholderPrefix
	 *            the prefix that denotes the start of a placeholder
	 * @param placeholderSuffix
	 *            the suffix that denotes the end of a placeholder
	 * @param valueSeparator
	 *            the separating character between the placeholder variable and
	 *            the associated default value, if any
	 * @param ignoreUnresolvablePlaceholders
	 *            indicates whether unresolvable placeholders should be ignored
	 *            (<code>true</code>) or cause an exception (<code>false</code>
	 *            ).
	 */
	public PropertyPlaceholderHelper(String placeholderPrefix, String placeholderSuffix, String valueSeparator, boolean ignoreUnresolvablePlaceholders) {
		Assert.notNull(placeholderPrefix, "placeholderPrefix must not be null");
		Assert.notNull(placeholderSuffix, "placeholderSuffix must not be null");
		this.placeholderPrefix = placeholderPrefix;
		this.placeholderSuffix = placeholderSuffix;
		String simplePrefixForSuffix = wellKnownSimplePrefixes.get(this.placeholderSuffix);
		if ((simplePrefixForSuffix != null) && this.placeholderPrefix.endsWith(simplePrefixForSuffix)) {
			simplePrefix = simplePrefixForSuffix;
		} else {
			simplePrefix = this.placeholderPrefix;
		}
		this.valueSeparator = valueSeparator;
		this.ignoreUnresolvablePlaceholders = ignoreUnresolvablePlaceholders;
	}

	private int findPlaceholderEndIndex(CharSequence buf, int startIndex) {
		int index = startIndex + placeholderPrefix.length();
		int withinNestedPlaceholder = 0;
		while (index < buf.length()) {
			if (StringUtil.substringMatch(buf, index, placeholderSuffix)) {
				if (withinNestedPlaceholder > 0) {
					withinNestedPlaceholder--;
					index = index + placeholderSuffix.length();
				} else {
					return index;
				}
			} else if (StringUtil.substringMatch(buf, index, simplePrefix)) {
				withinNestedPlaceholder++;
				index = index + simplePrefix.length();
			} else {
				index++;
			}
		}
		return -1;
	}

	protected String parseStringValue(String strVal, PlaceholderResolver placeholderResolver, Set<String> visitedPlaceholders) {
		StringBuilder buf = new StringBuilder(strVal);
		int startIndex = strVal.indexOf(placeholderPrefix);
		while (startIndex != -1) {
			int endIndex = findPlaceholderEndIndex(buf, startIndex);
			if (endIndex != -1) {
				String placeholder = buf.substring(startIndex + placeholderPrefix.length(), endIndex);
				if (!visitedPlaceholders.add(placeholder)) {
					throw new IllegalArgumentException("Circular placeholder reference '" + placeholder + "' in property definitions");
				}
				// Recursive invocation, parsing placeholders contained in the
				// placeholder key.
				placeholder = parseStringValue(placeholder, placeholderResolver, visitedPlaceholders);
				// Now obtain the value for the fully resolved key...
				String propVal = placeholderResolver.resolvePlaceholder(placeholder);
				if ((propVal == null) && (valueSeparator != null)) {
					int separatorIndex = placeholder.indexOf(valueSeparator);
					if (separatorIndex != -1) {
						String actualPlaceholder = placeholder.substring(0, separatorIndex);
						String defaultValue = placeholder.substring(separatorIndex + valueSeparator.length());
						propVal = placeholderResolver.resolvePlaceholder(actualPlaceholder);
						if (propVal == null) {
							propVal = defaultValue;
						}
					}
				}
				if (propVal != null) {
					// Recursive invocation, parsing placeholders contained in
					// the
					// previously resolved placeholder value.
					propVal = parseStringValue(propVal, placeholderResolver, visitedPlaceholders);
					buf.replace(startIndex, endIndex + placeholderSuffix.length(), propVal);
					if (logger.isTraceEnabled()) {
						logger.trace("Resolved placeholder '" + placeholder + "'");
					}
					startIndex = buf.indexOf(placeholderPrefix, startIndex + propVal.length());
				} else if (ignoreUnresolvablePlaceholders) {
					// Proceed with unprocessed value.
					startIndex = buf.indexOf(placeholderPrefix, endIndex + placeholderSuffix.length());
				} else {
					throw new IllegalArgumentException("Could not resolve placeholder '" + placeholder + "'");
				}
				visitedPlaceholders.remove(placeholder);
			} else {
				startIndex = -1;
			}
		}
		return buf.toString();
	}

	/**
	 * Replaces all placeholders of format <code>${name}</code> with the value
	 * returned from the supplied {@link PlaceholderResolver}.
	 * 
	 * @param value
	 *            the value containing the placeholders to be replaced.
	 * @param placeholderResolver
	 *            the <code>PlaceholderResolver</code> to use for replacement.
	 * @return the supplied value with placeholders replaced inline.
	 */
	public String replacePlaceholders(String value, PlaceholderResolver placeholderResolver) {
		Assert.notNull(value, "Argument 'value' must not be null.");
		return parseStringValue(value, placeholderResolver, new HashSet<String>());
	}

	/**
	 * Replaces all placeholders of format <code>${name}</code> with the
	 * corresponding property from the supplied {@link Properties}.
	 * 
	 * @param value
	 *            the value containing the placeholders to be replaced.
	 * @param properties
	 *            the <code>Properties</code> to use for replacement.
	 * @return the supplied value with placeholders replaced inline.
	 */
	public String replacePlaceholders(String value, final Properties properties) {
		Assert.notNull(properties, "Argument 'properties' must not be null.");
		return replacePlaceholders(value, new PlaceholderResolver() {

			@Override
			public String resolvePlaceholder(String placeholderName) {
				return properties.getProperty(placeholderName);
			}
		});
	}
}
