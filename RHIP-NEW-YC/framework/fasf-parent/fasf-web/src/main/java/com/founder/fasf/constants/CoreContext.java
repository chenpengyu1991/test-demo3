
package com.founder.fasf.constants;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.founder.fasf.config.ApplicationSetting;

public class CoreContext {

	static {
	}

	private static GenericApplicationContext beanContext;

	private static ApplicationSetting applicationSetting;

	private CoreContext() {
	}

	public static void init() {
		if (beanContext == null) {
			beanContext = new GenericApplicationContext();
			XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(beanContext);
			xmlReader.loadBeanDefinitions(new ClassPathResource("coreContext.xml"));
			beanContext.refresh();
		}
	}

	public static void destory() {
		if (beanContext != null) {
			beanContext.close();
		}
	}

	public static AbstractApplicationContext getBeanContext() {
		return beanContext;
	}

	public static void setBeanContext(GenericApplicationContext beanContext) {
		CoreContext.beanContext = beanContext;
	}

	public static ApplicationSetting getApplicationSetting() {
		return applicationSetting;
	}
}
