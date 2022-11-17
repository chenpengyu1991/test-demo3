package com.founder.fasf.util;

import java.util.Locale;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import com.founder.fasf.config.ApplicationSetting;

public class LocalizableUtil {
	private static ReloadableResourceBundleMessageSource messageSource;

	static {
		String basenames = (String) ApplicationSetting
				.getProperty("localizable.basenames");
		if (basenames != null && basenames.length() > 0) {
			String[] baseNamesArray = basenames.split(",");
			messageSource = new ReloadableResourceBundleMessageSource();
			messageSource.setBasenames(baseNamesArray);
		}
	}

	public static String getLocalizedString(String key, Locale locale) {
		return getLocalizedString(key, null, locale);
	}

	public static String getLocalizedString(String key, Object[] args,
			Locale locale) {
		return messageSource.getMessage(key, args, locale);
	}
}
