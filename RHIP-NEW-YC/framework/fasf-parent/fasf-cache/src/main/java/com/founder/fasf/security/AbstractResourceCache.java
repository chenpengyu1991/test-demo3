package com.founder.fasf.security;

import java.util.ArrayList;
import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;


public abstract class AbstractResourceCache implements IResourceCache
{
    protected Cache cache;

    public abstract void initCache();

    @Override
    public IResource getResource(Object key)
    {
        return null;
    }

    @Override
    public void putResource(IResource resource)
    {
        Element element = new Element(resource.getResourceKey(), resource);
        cache.put(element);

    }

    @Override
    public void removeResource(Object key)
    {
        cache.remove(key);
    }

    @Override
    public IResource[] getResourcesByType(Object type)
    {
        List<Object> resources = new ArrayList<Object>();
        for (Object key : this.cache.getKeys())
        {
            IResource res = this.getResource(key);
            if (res != null && res.getResourceType().equals(type))
            {
                resources.add(res.getResourceKey());
            }
        }
        return resources.toArray(new IResource[0]);
    }

}
