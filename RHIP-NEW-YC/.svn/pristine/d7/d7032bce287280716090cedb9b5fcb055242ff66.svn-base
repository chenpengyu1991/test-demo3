package com.founder.elb.repository;

import java.util.List;

import com.founder.elb.entity.Access;
import com.founder.fasf.repository.IDao;

/**
 * DAO interface of Access
 * 
 */
public interface IAccessDao extends IDao<Access,Integer>
{
	/**
	 * 通过角色Id获取权限
	 * @param roleId
	 * @return
	 */
	List<Access> getAccess(String roleId);

	/**
	 * 通过用户Id，机构Id获取权限
	 * @param userId
	 * @param organizationId
	 * @return
	 */
	List<Access> getAccess(String userId, String organizationId);

	List<Access> getAccezz(String userId, Integer accessLevel);
}