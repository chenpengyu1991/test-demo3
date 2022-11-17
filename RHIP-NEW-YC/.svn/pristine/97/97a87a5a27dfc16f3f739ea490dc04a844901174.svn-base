package com.founder.elb.repository;

import com.founder.elb.entity.Access;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO implement of Access
 * 
 */
@Repository("accessDao")
public class AccessDaoImpl extends AbstractDao<Access, Integer> implements IAccessDao
{
	
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;


	@Override
	public List<Access> getAccess(String roleId) {
		String sql = "select id, url from access where id in (select access_id from role_access where role_id =:roleId)";
		return this.getList(sql, new Criteria("roleId",roleId));
	}

	@Override
	public List<Access> getAccess(String userId, String organizationId) {

		String sql = "select id, url from access where id in " +
				"(select r.id from role r where r.id in " +
				"(select role_id from user_role_organization +where user_id=:userId and organization_id =:organizationId))";

		return this.getList(sql, new Criteria("userId", userId).add("organizationId", organizationId));
	}

	@Override
	public List<Access> getAccezz(String userId, Integer accessLevel) {
		String sql="SELECT ID,SRC_ID FROM ACCEZZ WHERE ID IN(SELECT ACCESS_ID FROM ROLE_ACCESS WHERE ROLE_ID IN( SELECT U.ROLE_ID FROM USER_ROLE U, ROLE R  WHERE R.ID = U.ROLE_ID AND R.STATUS = 1 AND U.USER_ID=:userId))AND ACCESS_LEVEL=:accessLevel";
		Criteria criteria=new Criteria("userId",userId).add("accessLevel",accessLevel);
		return getList(sql, criteria);
	}

}