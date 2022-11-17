package com.founder.fasf.aop;

import com.founder.fasf.repository.DbContextHolder;
import com.founder.fasf.repository.JdbcTemplateCache;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * User: Andy
 * Date: 13-2-13
 * Time: 下午6:59
 * To change this template use File | Settings | File Templates.
 */

@Component
@Aspect
public class jdbcTemplateAspect implements ApplicationContextAware {
	
	private ApplicationContext ctx;

    //方法执行前调用               com.founder.rhip.ehr.repository.OrganizationDaoImpl@1e16599
    @Before(value = "execution (* com.founder..IDao+.*(..))")
    public void before(JoinPoint joinPoint) {
        SimpleJdbcTemplate simpleJdbcTemplate = null;
        try {
            Object o = joinPoint.getTarget();
            String className = o.getClass().getName();
            Class<?> clz =  Class.forName(className);

            if (JdbcTemplateCache.get(className) != null)  {
                simpleJdbcTemplate = JdbcTemplateCache.get(className);
                DbContextHolder.setJdbcTemplate(simpleJdbcTemplate);
            } else {
                Field field = null;
                try {
                    field = clz.getDeclaredField("simpleJdbcTemplate");
                }catch (Exception e) {
                	try {
                		field = clz.getSuperclass().getDeclaredField("simpleJdbcTemplate");
                	}catch (Exception e1) {
                		String defaultBean = "defaultJDBCTemplate";
                		DefaultJDBCTemplate ds = (DefaultJDBCTemplate)ctx.getBean(defaultBean);
                		if (ds == null) { throw e1;}
                		String defaultName = ds.getName();
            			simpleJdbcTemplate = (SimpleJdbcTemplate)ctx.getBean(defaultName);
            			if (simpleJdbcTemplate == null) { throw e1;}
            			DbContextHolder.setJdbcTemplate(simpleJdbcTemplate);
            			JdbcTemplateCache.put(className, simpleJdbcTemplate);
            			return;
                	}
                }
                field.setAccessible(true);
                Object o2 = field.get(o);
                if (null != o) simpleJdbcTemplate = (SimpleJdbcTemplate) o2;
                DbContextHolder.setJdbcTemplate(simpleJdbcTemplate);
                field.setAccessible(false);
                JdbcTemplateCache.put(className, simpleJdbcTemplate);
            }
          //  ConvertingWrapDynaBean bean = new ConvertingWrapDynaBean(o);
          //  bean.set("simpleJdbcTemplate",  simpleJdbcTemplate);
            //System.out.print("==========="+clz.getName()+"========="+simpleJdbcTemplate.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		ctx = applicationContext;
	}
}
/*
class JdbcTemplateCache{
   static CacheMap<String,SimpleJdbcTemplate> jdbcTemplateCacheMap = new CacheMap<>(500);
    public static void put(String key, SimpleJdbcTemplate simpleJdbcTemplate) {
           jdbcTemplateCacheMap.put(key,simpleJdbcTemplate);
    }
    public static SimpleJdbcTemplate get (String key) {
           return jdbcTemplateCacheMap.get(key);
    }
}*/
