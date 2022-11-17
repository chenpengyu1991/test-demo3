package com.founder.fasf.security.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.entity.Authorities;
import com.founder.fasf.entity.User;
import com.founder.fasf.repository.IDao;

public class DefaultUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

//	@SuppressWarnings("rawtypes")
//	private IDao entityDao;
//
//	@SuppressWarnings({ "unchecked", "unused" })
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException,
//			DataAccessException {
//		Criteria criteria = new Criteria("Name", OP.EQ, username);
//		User user = (User) entityDao.get(criteria); // (User)
//													// entityDao.selectById(User.class,
//													// username);
//		if (user == null || user.getUsername() == null) {
//			throw new UsernameNotFoundException("User " + username + "is not found");
//		}
//		Map<String, Object> condition = new HashMap<String, Object>();
//		condition.put("username", user.getUsername());
//		List<Object> authorities = null;// this.entityDao.selectByCondition(Authorities.class,
//										// condition);
//		if (authorities == null || authorities.size() <= 0) {
//			throw new UsernameNotFoundException("User " + username + "doesn't have authorities");
//		}
//		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
//		for (Object authority : authorities) {
//			String roleName = "ROLE_" + ((Authorities) authority).getAuthority();
//			grantedAuthorities.add(new GrantedAuthorityImpl(roleName));
//		}
//		DefaultUserDetails userDetails = new DefaultUserDetails(user, grantedAuthorities);
//		return userDetails;
//	}
//
//	@SuppressWarnings("rawtypes")
//	public void setEntityDao(IDao entityDao) {
//		this.entityDao = entityDao;
//	}
}
