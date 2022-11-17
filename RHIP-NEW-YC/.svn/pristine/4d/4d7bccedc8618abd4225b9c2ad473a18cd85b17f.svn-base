/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public final class ApplicationSetting {

	private static Properties properties;

	protected static Logger logger = Logger.getLogger(ApplicationSetting.class);
	static {
		init("setting.properties");
	}

	public static Object getProperty(String name) {
		return properties.get(name);
	}

	static void init(final String fileName) {
		properties = new Properties();
		InputStream in = null;
		String message = null;
		try {
			in = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
			properties.load(in);
		} catch (FileNotFoundException e) {
			message = "Setting file not found.";
		} catch (IOException e) {
			message = "IO error when process setting file.";
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					message = "IO error when close setting file.";
				}
				if (message != null) {
					logger.info(message);
				}
			}
		}
	}
}
