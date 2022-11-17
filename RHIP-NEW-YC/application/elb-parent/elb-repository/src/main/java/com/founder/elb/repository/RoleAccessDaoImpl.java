package com.founder.elb.repository;

import com.founder.elb.entity.RoleAccess;
import com.founder.fasf.repository.AbstractDao;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;


/**
 * DAO implement of RoleAccess
 * 
 */
@Repository("roleAccessDao")
public class RoleAccessDaoImpl extends AbstractDao<RoleAccess, Integer> implements IRoleAccessDao
{
	
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public List<RoleAccess> getList(String roleId,Integer accessLevel) {
	    String sql="SELECT RA.* FROM ROLE_ACCESS RA LEFT JOIN ACCEZZ A ON RA.ACCESS_ID=A.ID WHERE RA.ROLE_ID="+roleId
	    		+" AND A.ACCESS_LEVEL="+accessLevel;	   
		return getList(sql);
	}

}