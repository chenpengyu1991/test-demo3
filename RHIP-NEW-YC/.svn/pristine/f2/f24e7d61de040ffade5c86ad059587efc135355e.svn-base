package com.founder.elb.repository;

import com.founder.elb.entity.Role;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;


/**
 * DAO implement of Role
 * 
 */
@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Role,Integer > implements IRoleDao
{

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public List<Role> getRoles(Long userId, Integer organizationId) {

		String sql = "select id,name from role where id in (select role_id from user_role_organization " +
				"where user_id=:userId and organization_id =:organizationId )";

		return getList(sql,new Criteria("userId", userId).add("organizationId", organizationId));
	}

}