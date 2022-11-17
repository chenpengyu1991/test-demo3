package com.founder.fasf.security;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService
{
    // @Resource
    // private UserDao userDao;

    @SuppressWarnings("unused")
	@Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException
    {

        // User user = userDao.getUserByUsername(username);
        // List<Role> roles = user.getRoles();
        Collection<GrantedAuthority> authorities = new LinkedList<GrantedAuthority>();

        // for (Role role : roles)
        // {
        // authorities.add(new GrantedAuthorityImpl(role.getCode()));
        // }

        UserDetails userDetails = null;
        // new org.springframework.security.core.userdetails.User(
        // username, user.getPassword(),
        // Constants.STATE_VALID.equals(user.getState()), true, true,
        // true, authorities);

        return userDetails;
    }

}
