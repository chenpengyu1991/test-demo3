package com.founder.fasf.security;

public class BaseResource implements IResource
{
    private Object resourceKey;

    private Object resourceType;

    @Override
    public Object getResourceKey()
    {
        return this.resourceKey;
    }

    @Override
    public Object getResourceType()
    {
        return this.resourceType;
    }

    public void setResourceKey(Object resourceKey)
    {
        this.resourceKey = resourceKey;
    }

    public void setResourceType(Object resourceType)
    {
        this.resourceType = resourceType;
    }

}
