package com.founder.rhip.im.service.task;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.im.service.loader.PublicHealthTargetLoader;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 公共卫生指标数据抽取
 * Created by bagen  2016-08-03
 */
@Service("publicHealthTargetLoader")
@TaskBean(description = "公共卫生指标数据抽取")
public class PublicHealthTargetTaskService implements ApplicationContextAware, Task {

    // Spring应用上下文环境
    protected static ApplicationContext context;

    protected static Logger logger;

    @Override
    public void run(Map<String, Object> data) {
        logger = Logger.getLogger(PublicHealthTargetTaskService.class);
        if (ObjectUtil.isNullOrEmpty(logger)) logger = Logger.getLogger(PublicHealthTargetTaskService.class);
        try {
            new PublicHealthTargetLoader(context).run();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
