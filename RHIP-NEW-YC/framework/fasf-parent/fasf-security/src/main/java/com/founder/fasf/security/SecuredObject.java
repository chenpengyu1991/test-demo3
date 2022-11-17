package com.founder.fasf.security;

import org.springframework.security.core.GrantedAuthority;

public interface SecuredObject
{
    GrantedAuthority[] getAuthorities();
}
