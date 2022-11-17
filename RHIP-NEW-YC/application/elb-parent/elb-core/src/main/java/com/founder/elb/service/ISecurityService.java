/**
 * copyright Relax4J 2011
 *
 * @date 2012-02-15
 * @author founder
 * @version V1.0
 * @describe 用户、角色、权限管理
 */

package com.founder.elb.service;

import java.util.List;
import java.util.Map;

import com.founder.elb.entity.Access;
import com.founder.elb.entity.ActionControl;
import com.founder.elb.entity.FieldControl;
import com.founder.elb.entity.Menu;
import com.founder.elb.entity.Role;
import com.founder.elb.entity.RoleAccess;
import com.founder.elb.entity.SysControl;
import com.founder.elb.entity.User;
import com.founder.elb.entity.UserRole;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;

public interface ISecurityService {

    /**
     * 创建用户
     *
     * @param
     * @return User
     */
    public int createUser(User user, String... roleId);

    /**
     * 批量创建用户
     *
     * @param
     * @return int
     */
    public int createUser(List<User> userList);

    /**
     * 删除用户
     *
     * @param
     * @return int
     */
    public int deleteUser(String... userIds);

    /**
     * 更新其它用户(同时设置角色)
     *
     * @param
     * @param
     *
     * @return int
     */
    public int updateUser(User user, String[] roleIds);

    public int updateUser(User user, String[] roleIds, String... properties);

    /**
     * 更新个人信息(基本信息)
     *
     * @param
     * @return int
     */
    public int updateUser(User user);

    /**
     * 用户登录
     *
     * @param
     * @param password
     *            should be MD5
     * @return User
     */
    public User login(String userName, String password);

    /**
     * 修改密码
     *
     * @param
     * @return int
     */
    public int changePassword(String userName, String oldPassword, String newPassword);

    /**
     * 忘记密码
     *
     * @param
     * @return void
     */
    public void forgetPassword(String userName, String email);

    /**
     * 查询用户
     *
     * @param
     * @return User
     */
    public User getUserId(String userId);

    /**
     * 查询多个用户
     *
     * @param
     * @return User
     */
    public List<User> getUsers(String... userId);

    /**
     * 查询用户( 用于检查用户名是否重复)
     *
     * @param
     * @return User
     */
    public User getUser(String userName);

    /**
     * 查询用户
     *
     * @param criteria
     * @return
     * @author Denggao Li
     */
    public User getUser(Criteria criteria);

    /**
     * 查询用户列表
     *
     * @param
     * @return List<User>
     */
    public PageList<User> getUsers(Page page, Criteria criteria);
    /**
     * 查询用户列表
     *
     * @param
     * @param
     * @return List<User>
     */
    public PageList<User> getUsers(Page page, Criteria criteria,Order order);

    /**
     * 查询用户列表(自定义)
     *
     * @param
     * @return List<User>
     */
    public PageList<User> getUsers(Page page, Criteria criteria, User user);

    /**
     * 新增角色
     *
     * @param role
     * @return　long
     * @author Denggao Li
     */
    public int createRole(Role role);

    /**
     * 批量增加角色（用于批量导入）
     *
     * @param roles
     * @return
     * @author Denggao Li
     */
    public int createRoles(List<Role> roles);

    /**
     * 更新角色
     *
     * @param role
     * @return
     * @author Denggao Li
     */
    public int updateRole(Role role);

    /**
     * 批量更新用户角色
     *
     * @param
     * @return
     * @author Denggao Li
     */
    public int updateUserRole(String[] userIds, String[] roleIds);

    /**
     * 更新角色(同时设置权限)
     *
     * @param
     * @param
     * @return int
     */
    public int updateRole(Role role, String... accessIds);

    /**
     * 获取角色

     * @param
     * @return Role
     */
    public Role getRoleId(String roleCode);

    /**
     * 获取角色
     *
     * @param
     * @param
     * @return List<Role>
     */
    public List<Role> getRoles(String userId, Integer... type);

    public List<Role> getRoles(String userId, String orgId, Integer  type);

    public List<UserRole> getUserRole(String userId, Integer... type);

    public List<UserRole> getUserRole(String userId, String orgId, Integer  type);

    /**
     * 获取角色
     *
     * @param criteria
     * @return
     */
    public List<Role> getRoles(Criteria criteria);

    /**
     * 获取角色
     *
     * @return List<Role>
     */
    public List<Role> getRoles();

    public List<RoleAccess> getRoleAccess(String roleId,Integer accessLevel);
    /**
     * 获取权限
     * @param
     * @param
     *
     * @return List<Access>
     */
    public List<Access> getAccess(String userId, Integer accessLevel, Integer... type);

    public List<Access> getAccess(String userId, String orgId, Integer type);

    public List<Access> getAccezz(String userId, Integer accessLevel);

    /**
     * 获取权限
     *
     * @param
     * @return List<Access>
     */
    public List<Access> getAccess(String roleCode);

    /**
     * 获取权限
     *
     * @return List<Access>
     */
    public List<Access> getAccess();

    /**
     * 根据用户Id和角色Id获取机构
     *
     * @param userId
     * @param roleId
     * @return
     */
	/*
	 * public Organization getOrganization(Long userId,Integer roleId);
	 */
    /**
     * 绑定角色与资源
     *
     * @param roleId
     * @param accessIds
     * @return
     */
    public int saveRole(String roleId, String... accessIds);

    public Map<Integer, SysControl> getSysMap();

    public Map<Integer, Menu> getMenuMap();

    public Map<Integer, ActionControl> getActionMap();

    public Map<Integer, FieldControl> getFieldMap();

    public List<Map<String, Object>> getMenuTree(String roleCode);

    /**
     * 根据条件删除角色权限
     *
     * @return int
     */
    public int deleteRoleAccess(Criteria criteria);

    /**
     * 设定角色权限
     *
     * @return int
     */
    public int setRoleAccess(Role role);

    /**
     * 变更用户状态
     *
     * @return int
     */
    public int changeStatus(Integer status, String... userIds);

    /*
     * 分页查询角色(首页)
     *
     * */
    public PageList<Role> getRoles(Page page, Criteria criteria);

    /*
     * 分页查询角色(首页)
     *
     * */
    public PageList<Role> getRoles(Page page, Criteria criteria,Order order);

    /*
     * 分页查询角色(查询)
     *
     * */
    public PageList<Role> getRoles(Page page, Criteria criteria, Role role);

    public Role getRole(String roleName);

	public Map<String, Menu> getAllMenuMap();

}
