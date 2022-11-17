package com.founder.file.action;

import com.founder.file.service.FileService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author liuk
 * @since 14-3-17 下午3:30
 */
@WebListener
public class InitListener implements ServletContextListener {

    private FileService fileService;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        fileService  = new FileService();
        context.setAttribute(FileService.class.getName(),fileService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        context.removeAttribute(FileService.class.getName());
        fileService=null;
    }
}
