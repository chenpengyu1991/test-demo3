package com.founder.fasf.cache;

import java.io.Serializable;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;



public class CacheClientManager
{
    // 日志记录器
   // private static final Logger log = Logger.getLogger(CacheClientManager.class);

    // 缓存客户端
    private Cache cache;

    /**
     * 通过缓存id，查询已经缓存过的对象
     * @param cacheKey 缓存中的唯一标识
     * @param scope 缓存范围
     * @return 被缓存的对象或null
     */
    public Object getObjectFromCache(String cacheKey, CacheScope scope)
    {
        if (cacheKey == null)
        {
            throw new NullPointerException();
        }
        String cacheKeyByScope = CacheKeyUtil.getCacheKeyByScope(cacheKey, scope);

        Element element = cache.get(cacheKeyByScope);
        if (element == null)
        {
            return null;
        }
        else
        {
            return element.getValue();
        }
    }

    /**
     * 根据指定的key把对象缓存到缓存服务器
     * @param cacheKey 缓存对象对应的唯一值
     * @param obj 将被缓存的对象 
     * @param scope 缓存范围
     * @return 是否缓存成功
     */
    public Boolean saveObject2Cache(String cacheKey, Serializable obj,
            CacheScope scope)
    {
        if (cacheKey == null)
        {
            throw new NullPointerException();
        }
        String cacheKeyByScope = CacheKeyUtil.getCacheKeyByScope(cacheKey,
                scope);

        Element element = new Element(cacheKeyByScope, obj);
        cache.put(element);
        return true;
    }

    /**
     * 缓存客户端 getter
     * @return 缓存客户端
     */
    public Cache getCache()
    {
        return cache;
    }

    /**
     * 缓存客户端对象 setter
     * @param cache 缓存客户端
     */
    public void setCache(Cache cache)
    {
        this.cache = cache;
    }

}
