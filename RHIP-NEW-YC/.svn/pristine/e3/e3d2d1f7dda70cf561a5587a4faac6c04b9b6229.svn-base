package com.founder.fasf.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;

import com.founder.fasf.config.ApplicationSetting;
import com.founder.fasf.constants.CoreConstants;


public class InitContextListener implements ServletContextListener
{
    private GenericApplicationContext beanContext;

    @Override
    public void contextDestroyed(ServletContextEvent event)
    {
        if (this.beanContext != null)
        {
            this.beanContext.close();
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent event)
    {
        this.loadBeanContext();
        event.getServletContext().setAttribute(
                WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE,
                beanContext);
    }

    private void loadBeanContext()
    {
        this.beanContext = new GenericWebApplicationContext();
        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(
                beanContext);
        String[] files = this.getContextFiles();
        for (String file : files)
        {
            xmlReader.loadBeanDefinitions(new ClassPathResource(file));
        }
        beanContext.refresh();
        // Map<String, ClassPathInterfaceBeanDefinitionScanner> beans =
        // beanContext.getBeansOfType(ClassPathInterfaceBeanDefinitionScanner.class);
        // for (String key : beans.keySet())
        // {
        // ClassPathInterfaceBeanDefinitionScanner scanner = beans.get(key);
        // scanner.scan(beanContext);
        // }
    }

    private String[] getContextFiles()
    {
        String files = (String) ApplicationSetting.getProperty(CoreConstants.SETTING_CONTEXT_FILES);
        if (files != null && files.length() > 0)
        {
            return files.split(",");
        }
        return new String[] { "application-context.xml" };
    }

}
