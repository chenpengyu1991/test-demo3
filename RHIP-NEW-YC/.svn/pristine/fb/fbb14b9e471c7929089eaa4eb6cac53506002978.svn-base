package com.founder.fasf.security;

import java.util.Collection;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

public abstract class AbstractFilterInvocationSecurityMetadataSource implements
        FilterInvocationSecurityMetadataSource
{
    public abstract Collection<ConfigAttribute> lookupAttributes(String url);

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes()
    {
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException
    {
        if ((object == null) || !this.supports(object.getClass()))
        {
            throw new IllegalArgumentException(
                    "Object must be a FilterInvocation");
        }

        String url = ((FilterInvocation) object).getRequestUrl();
        // String method = ((FilterInvocation)
        // object).getHttpRequest().getMethod();

        return lookupAttributes(url);
    }

    @Override
    public boolean supports(Class<?> clazz)
    {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
