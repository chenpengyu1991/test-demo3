package com.founder.rhip.im.common;

import java.net.URL;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


public class PropertiesUtils {
	
	private static final Logger log = Logger.getLogger(PropertiesUtils.class);
	
	private static final String FILE_EXTENSION = ".properties";
	public static final String FILE_PATH = "/config/";
	
	/**
	 * 初始化配置文件
	 * @param templateName
	 * @return
	 */
	public static Properties initProperties(String templateName) {
		Properties properties = new Properties();
		try {
			if (StringUtils.isNotBlank(templateName)) {
				URL url = PropertiesUtils.class.getResource(new StringBuilder(FILE_PATH).append(templateName).append(FILE_EXTENSION).toString());
//				if (url == null) {
//					url = PropertiesUtils.class.getResource(new StringBuilder(FILE_PATH).append("hip/").append(templateName).append(FILE_EXTENSION).toString());
//				}
				if (url != null) {
					properties.load(url.openStream());
				}
			}
		} catch (Exception e) {
			log.error(new StringBuilder("Cannot find Configuration : ").append(templateName).append(FILE_EXTENSION), e);
		}
		return properties;
	}
}
