package com.founder.rhip.ehr.listener;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.core.io.ClassPathResource;

import com.founder.rhip.ehr.common.WebProperties;

/**
 * @author ljy
 *
 */
public class PropertiesInitListener implements ServletContextListener {

    private static final String WEBSERVICE_CONFIG_FILE = "config/common-web.properties";
	
    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ClassPathResource cr = new ClassPathResource(WEBSERVICE_CONFIG_FILE);
      
        try {
            WebProperties.getInstance();
            WebProperties.getProperties().load(cr.getInputStream());
        } catch (IOException ex) {
            throw new RuntimeException("Cannot find Configuration " + PropertiesInitListener.WEBSERVICE_CONFIG_FILE);
        }
    }
    
}
