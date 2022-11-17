package com.founder.fasf.listener;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;

public class SpringContextInitListener implements ServletContextListener {
	private GenericApplicationContext beanContext;

	private String contextConfigLocation;

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		if (this.beanContext != null) {
			this.beanContext.close();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();
		this.contextConfigLocation = (String) servletContext.getInitParameter("contextConfigLocation");
		try {
			this.loadBeanContext(event);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		event.getServletContext().setAttribute(
				WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE,
				beanContext);
	}

	private void loadBeanContext(ServletContextEvent event) throws IOException {
		this.beanContext = new GenericWebApplicationContext(event.getServletContext());
		XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(beanContext);
		String[] files = this.getContextFiles();
		ResourcePatternResolver resourceLoader = new PathMatchingResourcePatternResolver();
		for (String file : files) {
			Resource[] resources = resourceLoader.getResources(file.trim());
			if (resources != null) {
				for (Resource res : resources) {
					xmlReader.loadBeanDefinitions(res);
				}
			}
		}
		beanContext.refresh();
	}

	private String[] getContextFiles() {
		if (this.contextConfigLocation == null || this.contextConfigLocation.length() <= 0) {
			this.contextConfigLocation = "application-context.xml";
		}
		return this.contextConfigLocation.split(",");
	}

}
