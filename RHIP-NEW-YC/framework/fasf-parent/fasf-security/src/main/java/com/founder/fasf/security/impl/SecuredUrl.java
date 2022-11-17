package com.founder.fasf.security.impl;

public class SecuredUrl extends CachedSecuredObject
{
    private String pattern;

    public String getPattern()
    {
        return pattern;
    }

    public void setPattern(String pattern)
    {
        this.pattern = pattern;
    }

}
