package com.founder.fasf.security.impl;

import java.util.HashMap;
import java.util.Map;

import com.founder.fasf.security.IResource;
import com.founder.fasf.security.IResourceCache;


public class SecuredObjectCache implements IResourceCache
{
    public static final String CACHE_NAME = "securedObjectCache";

    //@SuppressWarnings("rawtypes")
	//@Autowired
   // private IDao entityDao;

	@Override
   // @Cacheable(cacheName = SecuredObjectCache.CACHE_NAME)
    public IResource getResource(Object key)
    {
    	//Criteria criteria=new Criteria("Name",Operation.EQ,username);
       // User res =(User)entityDao.get(key.toString()); 
    	//User res = (User) this.entityDao.selectById(User.class, key);
        SecuredUrl securedUrl = new SecuredUrl();
        securedUrl.setResourceType(SecuredUrl.class);
       // securedUrl.setResourceKey(res.getUsername());
        return securedUrl;
    }

    @Override
    public void putResource(IResource resource)
    {
    }

    @Override
    public void removeResource(Object key)
    {
    }

    @Override
    //@Cacheable(cacheName = SecuredObjectCache.CACHE_NAME)
    public IResource[] getResourcesByType(Object type)
    {
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("type", type);
        //this.entityDao.selectByCondition(User.class, condition);
        return null;
    }
}
