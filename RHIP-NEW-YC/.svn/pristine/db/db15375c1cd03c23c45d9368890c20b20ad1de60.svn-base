package com.founder.rhip.ehr.service.basic;

import java.util.List;
import java.util.Map;

import com.founder.elb.entity.Access;
import com.founder.elb.entity.Menu;
import com.founder.elb.entity.Role;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.basic.PortalUser;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.basic.UserRole;
import com.founder.rhip.mdm.entity.Organization;

public interface IEhrSecurityService {

    /**
     * 删除用户
     *
     * @param userCodes 用户编码
     * @return int
     */
    public int deleteUser(String... userCodes);

    /**
     * 更新用户信息
     * @param user
     * @param userRoles
     * @return
     */
    public int updateUser(User user, List<UserRole> userRoles);

    /**
     * 用户登录
     *
     * @param String
     * @param password should be MD5
     * @return User
     */
    public User login(String userName, String password, int status);

    /**
     * 修改密码
     *
     * @param String
     * @param String
     * @param String
     * @return int
     */
    public int changePassword(String userName, String oldPassword, String newPassword);


    /**
     * 查询用户
     *
     * @param Long
     * @return User
     */
    public User getUser(Long id);

    /**
     * 查询用户( 用于检查用户名是否重复)
     *
     * @param String
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
     * @param Criteria
     * @return List<User>
     */
    public PageList<User> getUserPageList(Page page, Criteria criteria);


    /**
     * 获取角色
     *
     * @param Long
     * @param Integer
     * @return List<Role>
     */
    public List<Role> getRoles(String userCode, Integer... type);

    public List<Role> getRoles(String userCode, String organCode, Integer type);

    public List<UserRole> getUserRole(String userCode, Integer... type);

    public List<UserRole> getUserRole(String userCode, String organCode, Integer type);

    /**
     * 获取角色
     *
     * @return List<Role>
     */
    public List<Role> getRoles();

    public Map<String, Menu> getMenuMap(Criteria criteria);

    /**
     * 变更用户状态
     *
     * @return int
     */
    public int changeStatus(Integer status, String... userCodes);

    /**
     * 创建新用户
     * @param user
     * @param userRoles
     * @return
     */
    public int createUser(User user, List<UserRole> userRoles);

    /**
     * 用过http请求创建新用户，无角色
     * @param user
     * @return
     */
    public int createUser(User user);

    /**
     * 用过http请求创建新用户,赋予默认角色
     * @param user
     * @param organCode
     * @param roleCodes
     * @return
     */
    public int createUser(User user, String organCode, String[] roleCodes);

    public int deleteUserRoleOrganiation(String userCode, String organCode);

    public Map<Organization, List<Role>> getOrgRoleSet(String userCode, List<Organization> orgList);

    public int updateUserObject(User user);

    public int updatePortalUserPassword(String newPassWord,String userCode);

    /**
     * 重置密码
     *
     * @param Integer
     * @return userCode
     */
    public int setPassword(String userCode);

    public int setPortalPassword(String userCode);

    public List<User> getUserList(UserRole userRole, Criteria userCriteria);

    public List<Access> getAccess(String userCode, String organCode, Integer type, Integer accessLevel);

    /**
     * 根据ID和机构创建新的用户
     *
     * @param Integer
     * @return userCode
     */
    public Long createNewUser(Long userCode, String organCode);

    /**
     * 根据ID和机构创建新的用户
     *
     * @param Integer
     * @return userCode
     */
    public Role getRole(Integer id);

    /**
     * For CAS
     * @param userName
     * @return
     */
    public User loginWithCAS(String userName);

    /**
     * 查询未读消息
     * @param criteria
     * @return
     */
    public int getNewMessages(Criteria criteria);

    Role getRole(Criteria criteria);

    /**
     * 根据条件获取MDM_USER_ROLE中的org_code
     * @param criteria
     * @return
     */
    public List<String> getDistinctOrgCodes(Criteria criteria);
}
