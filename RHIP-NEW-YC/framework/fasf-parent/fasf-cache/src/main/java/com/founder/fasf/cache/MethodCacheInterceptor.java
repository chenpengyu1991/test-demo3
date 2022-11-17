package com.founder.fasf.cache;

import java.io.Serializable;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;

import com.founder.fasf.util.Assert;



public class MethodCacheInterceptor implements MethodInterceptor,
        InitializingBean
{

    private static final Logger log = Logger.getLogger(MethodCacheInterceptor.class);

    private Cache cache;

    /**
     * cache setter
     * @param cache cache
     */
    public void setCache(Cache cache)
    {
        this.cache = cache;
    }

    /**
     * 构造方法
     */
    public MethodCacheInterceptor()
    {
        super();
    }

    /**  
     * 缓存当前切点方法的返回值；
     * 以租户id,用户id,类名，方法名，方法参数做为缓存中的key
     * 
     * 注意事项：租户对应的key
     * 
     * 拦截Service/DAO的方法，并查找该结果是否存在，如果存在就返回cache中的值，  
     * 否则，返回数据库查询结果，并将查询结果放入cache  
     * @param invocation 切点方法对应的方法对象
     * @return 返回切点方法对象执行结果
     * @exception Throwable 异常
     */
    public Object invoke(MethodInvocation invocation) throws Throwable
    {
        String targetName = invocation.getMethod().getDeclaringClass().getName();
        String methodName = invocation.getMethod().getName();
        Object[] arguments = invocation.getArguments();
        Object result;

        log.debug("Find object from cache is " + cache.getName());

        String cacheKey = CacheKeyUtil.getFullCacheKey(targetName, methodName,
                arguments);
        Element element = cache.get(cacheKey);

        if (element == null)
        {
            log.debug("Hold up method , Get method result and create cache........!");
            result = invocation.proceed();

            element = new Element(cacheKey, (Serializable) result);
            cache.put(element);
        }
        return element.getValue();
    }

    /**  
     * implement InitializingBean，检查cache是否为空  
     * @exception Exception 异常
     */
    public void afterPropertiesSet() throws Exception
    {
    	
        Assert.notNull(cache,"Need a cache. Please use setCache(Cache) create it.");
    }

}
