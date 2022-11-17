package com.founder.fasf.security.impl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.founder.fasf.entity.User;

public class DefaultUserDetails implements UserDetails
{
    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private Collection<GrantedAuthority> authorities;

    private boolean enabled;

    public DefaultUserDetails(User user,
            Collection<GrantedAuthority> authorities)
    {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.enabled = true;
        this.authorities = authorities;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities()
    {
        return this.authorities;
    }

    @Override
    public String getPassword()
    {
        return this.password;
    }

    @Override
    public String getUsername()
    {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return false;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return false;
    }

    @Override
    public boolean isEnabled()
    {
        return this.enabled;
    }

}
