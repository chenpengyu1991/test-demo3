package com.founder.elb.repository;

import java.util.List;

import com.founder.elb.entity.Role;
import com.founder.fasf.repository.IDao;

/**
 * DAO interface of Role
 * 
 */
public interface IRoleDao extends IDao<Role,Integer>
{

	/**
	 * 通过用户Id和机构Id获取所有角色
	 * @param userId
	 * @param organizationId
	 * @return
	 */
	List<Role> getRoles(Long userId, Integer organizationId);

}