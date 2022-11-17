package com.founder.fasf.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.util.UrlMatcher;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import com.founder.fasf.security.impl.SecuredObjectCache;
import com.founder.fasf.security.impl.SecuredUrl;


public class DataBasedFilterInvocationSecurityMetadataSource extends
        AbstractFilterInvocationSecurityMetadataSource
{
    private boolean useAntPath = false;

    private boolean convertUrlToLowercaseBeforeComprison = false;

    private UrlMatcher urlMatcher;

    private PathMatcher pathMatcher = new AntPathMatcher();

    SecuredObjectCache cache;

    @Override
    public Collection<ConfigAttribute> lookupAttributes(String url)
    {
        if (isUseAntPath())
        {
            int firstQuestionMarkIndex = url.lastIndexOf("?");
            if (firstQuestionMarkIndex != -1)
            {
                url = url.substring(0, firstQuestionMarkIndex);
            }
        }
        if (isConvertUrlToLowercaseBeforeComprison())
        {
            url = url.toLowerCase();
        }
        GrantedAuthority[] authorities = new GrantedAuthority[0];
        SecuredUrl[] securedUrls = (SecuredUrl[]) cache.getResourcesByType(SecuredUrl.class);
        for (SecuredUrl securedUrl : securedUrls)
        {
            boolean matched = false;

            String pattern = securedUrl.getPattern();

            if (isUseAntPath())
            {
                matched = this.pathMatcher.match(pattern, url);
            }
            else
            {
                matched = this.urlMatcher.pathMatchesUrl(pattern, url);
            }
            if (matched)
            {
                authorities = securedUrl.getAuthorities();
                break;
            }
        }
        if (authorities.length > 0)
        {
            Collection<ConfigAttribute> attrs = new ArrayList<ConfigAttribute>();
            for (GrantedAuthority grantedAuthority : authorities)
            {
                attrs.add(new SecurityConfig(grantedAuthority.getAuthority()));
            }
            return attrs;
        }
        return null;
    }

    public boolean isUseAntPath()
    {
        return useAntPath;
    }

    public void setUseAntPath(boolean useAntPath)
    {
        this.useAntPath = useAntPath;
    }

    public boolean isConvertUrlToLowercaseBeforeComprison()
    {
        return convertUrlToLowercaseBeforeComprison;
    }

    public void setConvertUrlToLowercaseBeforeComprison(
            boolean convertUrlToLowercaseBeforeComprison)
    {
        this.convertUrlToLowercaseBeforeComprison = convertUrlToLowercaseBeforeComprison;
    }

}
