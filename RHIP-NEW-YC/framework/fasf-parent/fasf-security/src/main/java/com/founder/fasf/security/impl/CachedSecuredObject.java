
package com.founder.fasf.security.impl;

import org.springframework.security.core.GrantedAuthority;

import com.founder.fasf.security.BaseResource;
import com.founder.fasf.security.SecuredObject;

public class CachedSecuredObject extends BaseResource implements SecuredObject {

	private GrantedAuthority[] authorities;

	public GrantedAuthority[] getAuthorities() {
		return authorities;
	}

	public void setAuthorities(GrantedAuthority[] authorities) {
		this.authorities = authorities;
	}
}
