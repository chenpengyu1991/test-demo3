package com.founder.elb.repository;

import java.util.List;

import com.founder.elb.entity.RoleAccess;
import com.founder.fasf.repository.IDao;

/**
 * DAO interface of RoleAccess
 * 
 */
public interface IRoleAccessDao extends IDao<RoleAccess,Integer>
{
	public List<RoleAccess> getList(String roleId,Integer accessLevel);
}