package com.founder.fasf.cache;

import java.lang.reflect.Method;

import net.sf.ehcache.Cache;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

public class MethodCacheAfterAdvice implements AfterReturningAdvice,InitializingBean {

	private static final Logger log = Logger.getLogger(MethodCacheAfterAdvice.class);

	private Cache cache;

	/**
	 * cache setter
	 * 
	 * @param cache
	 *            cache
	 */
	public void setCache(Cache cache) {
		this.cache = cache;
	}

	/**
	 * 构造方法
	 */
	public MethodCacheAfterAdvice() {
		super();
	}

	/**
	 * 清空切点方法对应的所有缓存对象
	 * 
	 * 前提：是当前租户下的当前用户
	 * 
	 * @param returnValue
	 *            切点方法执行结果
	 * @param method
	 *            切点方法对象
	 * @param args
	 *            切点方法对应的参数
	 * @param target
	 *            切点方法所在的对象
	 * @return
	 * @exception Throwable
	 *                异常
	 */
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

		String className = target.getClass().getName();
		className = method.getDeclaringClass().getName();

		// 不包含参数值的key,因为在修改缓存对象时，参数值一定与原缓存中值不同，所以参数值无法定位到缓存。
		String key = CacheKeyUtil.getPartCacheKey(className, method.getName());

		//List list = cache.getKeys();
		//int ii = list.size();
		//int cacheSize = cache.getKeys().size();
		// cache.put(new Element("" + cacheSize, cacheSize));
		for (Object cacheKey : cache.getKeys()) {
			if (((String) cacheKey).startsWith(key)) {
				cache.remove(cacheKey);
				log.debug("remove cache " + cacheKey);
			}
			System.out.println("Key:" + cacheKey);
		}
	}

	/**
	 * 
	 * @exception Exception
	 */
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(cache, "Need a cache. Please use setCache(Cache) create it.");
	}

}
