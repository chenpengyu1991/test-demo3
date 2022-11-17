
package com.founder.elb.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.elb.entity.Access;
import com.founder.elb.entity.ActionControl;
import com.founder.elb.entity.FieldControl;
import com.founder.elb.entity.Menu;
import com.founder.elb.entity.Role;
import com.founder.elb.entity.RoleAccess;
import com.founder.elb.entity.SysControl;
import com.founder.elb.entity.User;
import com.founder.elb.entity.UserRole;
import com.founder.elb.repository.IAccessDao;
import com.founder.elb.repository.IActionControlDao;
import com.founder.elb.repository.IFieldControlDao;
import com.founder.elb.repository.IMenuDao;
import com.founder.elb.repository.IRoleAccessDao;
import com.founder.elb.repository.IRoleDao;
import com.founder.elb.repository.ISysControlDao;
import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.map.FastHashMap;
import com.founder.fasf.repository.IDao;
import com.founder.fasf.security.MD5Encoder;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

@Service("securityService")
public class SecurityServiceImpl extends AbstractService implements ISecurityService {

	@Autowired
	private IAccessDao accessDao;

	@Autowired
	private IRoleDao roleDao;

	@Autowired
	private IRoleAccessDao roleAccessDao;

	@Autowired
	private ISysControlDao sysControlDao;

	@Autowired
	private IMenuDao menuDao;

	@Autowired
	private IActionControlDao actionControlDao;

	@Autowired
	private IFieldControlDao fieldControlDao;

	/*
	 * @Autowired private IOrganizationDao organizationDao;
	 */
	/**
	 * 创建用户
	 * 
	 * @param
	 * @return User
	 */
	@Transactional
	public int createUser(User user, String... roleIds) {
		int result = 0;
		if (ObjectUtil.isNotEmpty(user)) {
			String pws = MD5Encoder.getMD5Str(user.getPassword());
			user.setPassword(pws);
			long userTableId = genericDao.getSequenceNextVal("SEQ_USERS", Long.class);
            user.setId(userTableId);
            genericDao.insert(user);
			if (userTableId > 0 && ObjectUtil.isNotEmpty(roleIds)) {
				result = insertUserRole(user.getUserId(), roleIds);
			}
		}
		return result;
	}

	private int insertUserRole(String userId, String... roleIds) {
		int result;
		List<UserRole> list = new ArrayList<UserRole>();
		for (String id : roleIds) {
			UserRole userRole = new UserRole();
			userRole.setRoleId(id);
			userRole.setUserId(userId);
			list.add(userRole);
		}
		result = genericDao.batchInsert(list);
		return result;
	}

	/**
	 * 查询用户( 用于检查用户名是否重复)
	 * 
	 * @param
	 * @return User
	 */
	public User getUser(String userName) {
		User result = null;
		if (ObjectUtil.isNotEmpty(userName)) {
			Criteria criteria = new Criteria("userName", userName);
			result = genericDao.get(User.class, criteria);
		}
		return result;
	}

	/**
	 * 批量创建用户
	 * 
	 * @param
	 *            <User>
	 * @return int
	 */
	public int createUser(List<User> users) {
		int result = 0;
		if (ObjectUtil.isNotEmpty(users)) {
			result = genericDao.batchInsert(users);
		}
		return result;
	}

	/**
	 * 删除用户(物理删除)
	 * 
	 * @param
	 * @return int
	 */
	@Transactional
	public int deleteUser(String... userIds) {
		int result = 0;
		if (ObjectUtil.isNotEmpty(userIds)) {
			result = genericDao.delete(User.class, new Criteria("id", OP.IN, userIds));
			genericDao.delete(UserRole.class, new Criteria("user_id", OP.IN, userIds));
		}
		return result;
	}

	/**
	 * 变更用户状态
	 * 
	 * @param
	 * @return int
	 */
	public int changeStatus(Integer status, String... userIds) {
		int result = 0;
		if (ObjectUtil.isNotEmpty(userIds)) {
			result = genericDao.update(User.class, new Parameters("status", status), new Criteria("id", OP.IN, userIds));
		}
		return result;
	}

	/**
	 * 更新其它用户(同时设置角色)
	 * 
	 * @param
	 * @param
	 * @return int
	 */
	@Transactional
	public int updateUser(User user, String[] roleIds) {
		int result = 0;
		if (ObjectUtil.isNotEmpty(user)) {
				result =genericDao.update(user);
				genericDao.delete(UserRole.class,new Criteria("userId", OP.EQ, user.getUserId()));
			if (ObjectUtil.isNotEmpty(roleIds)) {
				insertUserRole(user.getUserId(),roleIds);
			}
		}
		return result;
	}
	
	@Transactional
	public int updateUser(User user, String[] roleIds, String... properties) {
		int result = 0;
		if (ObjectUtil.isNotEmpty(user)) {
				result =genericDao.update(user,properties);
				genericDao.delete(UserRole.class,new Criteria("userId", OP.EQ, user.getUserId()));
			if (ObjectUtil.isNotEmpty(roleIds)) {
				insertUserRole(user.getUserId(),roleIds);
			}
		}
		return result;
	}

	/**
	 * 更新个人信息(基本信息)
	 * 
	 * @param
	 * @return int
	 */
	public int updateUser(User user) {
		int result = 0;
		if (ObjectUtil.isNotEmpty(user) && ObjectUtil.isNotEmpty(user.getId())) {
			result = genericDao.update(user);
		}
		return result;
	}

	@Override
	public User login(String userName, String password) {
		User user = null;
		try {
			if (ObjectUtil.isNotEmpty(userName) && ObjectUtil.isNotEmpty(password)) {
				Criteria criteria = new Criteria("userName", userName).add(new Criteria("password", MD5Encoder.getMD5Str(password))).add("status", 1);
				// Criteria criteria = new Criteria("userName",
				// userName).add(LOP.OR, new Criteria("identityCard",
				// userName).add(new Criteria("password",
				// MD5Encoder.getMD5Str(password))));
				user = genericDao.get(User.class, criteria); // MD5 Encoder
			}
		} catch (Exception e) {
			return null;
		}
		return user;
	}

	/**
	 * 非患者用户登录 此方法只针对非患者用户登录
	 * 
	 * @param
	 * @param password
	 *            should be MD5
	 * @return User
	 */
	public User loginForAdmin(String userName, String password) {
		User result = null;
		if (ObjectUtil.isNotEmpty(userName) && ObjectUtil.isNotEmpty(password)) {
			Criteria criteria = new Criteria("userName", userName).add("password", password);
			result = genericDao.get(User.class, criteria);
		}
		return result;
	}

	/**
	 * 患者用户登录 此方法只针对患者用户登录
	 * 
	 * @param String
	 * @param password
	 *            should be MD5
	 * @return User
	 */
	/*
	 * public Patient loginForPatient(String userName, String password) {
	 * Patient result = null; if (ObjectUtil.isNotEmpty(userName) &&
	 * ObjectUtil.isNotEmpty(password)) { Criteria criteria = new
	 * Criteria("userName", userName).add("password", password); result =
	 * patientDao.get(criteria); } return result; }
	 */
	/**
	 * 非患者修改密码
	 * 
	 * @param String
	 * @param String
	 * @param String
	 * @return int
	 */
	/*
	 * public int changePasswordForAdmin(String userName, String oldPassword,
	 * String newPassword) { int result = 0; if (ObjectUtil.isNotEmpty(userName)
	 * && ObjectUtil.NotEmpty(oldPassword) &&
	 * ObjectUtil.isNotEmpty(newPassword)) { result = userDao.update(new
	 * Parameters("password", newPassword), new Criteria("userName",
	 * userName).add("password", oldPassword)); } return result; }
	 */
	/**
	 * 患者修改密码
	 * 
	 * @param String
	 * @param String
	 * @param String
	 * @return int
	 */
	/*
	 * public int changePasswordForPatient(String userName, String oldPassword,
	 * String newPassword) { int result = 0; if (ObjectUtil.isNotEmpty(userName)
	 * && ObjectUtil.NotEmpty(oldPassword) &&
	 * ObjectUtil.isNotEmpty(newPassword)) { result = patientDao.update(new
	 * Parameters("password", newPassword), new Criteria("userName",
	 * userName).add("password", oldPassword)); } return result; }
	 */
	/**
	 * 查询用户列表
	 * 
	 * @param
	 * @return List<User>
	 */
	public PageList<User> getUsers(Page page, Criteria criteria) {
		PageList<User> result = genericDao.getPageList(User.class, page, criteria);
		return result;
	}
	/**
	 * 查询用户列表
	 * 
	 * @param
	 * @param
	 * @return List<User>
	 */
	public PageList<User> getUsers(Page page, Criteria criteria,Order order) {
		PageList<User> result = genericDao.getPageList(User.class, page, criteria , order);
		return result;
	}

	// 删除-cj
	public PageList<User> getUsers(Page page, Criteria criteria, User user) { // 条件查询
		PageList<User> list;
		Criteria criteriaSearch = new Criteria();
		if (ObjectUtil.isNotEmpty(user.getUserName()) && !user.getUserName().equals("请输入用户名"))
			criteriaSearch.add(new Criteria("userName", OP.LIKE, user.getUserName()));
		if (ObjectUtil.isNotEmpty(user.getName()) && !user.getName().equals("请输入姓名"))
			criteriaSearch.add(new Criteria("name", OP.LIKE, user.getName()));
		if (ObjectUtil.isNotEmpty(user.getGender()))
			criteriaSearch.add(new Criteria("gender", OP.EQ, user.getGender()));
		if (ObjectUtil.isNotEmpty(user.getEmail()) && !user.getEmail().equals("请输入Email"))
			criteriaSearch.add(new Criteria("email", OP.LIKE, user.getEmail()));
		if (ObjectUtil.isNotEmpty(user.getTelephone()) && !user.getTelephone().equals("请输入固定电话"))
			criteriaSearch.add(new Criteria("telephone", OP.LIKE, user.getTelephone()));
		if (ObjectUtil.isNotEmpty(user.getMobile()) && !user.getMobile().equals("请输入手机号"))
			criteriaSearch.add(new Criteria("mobile", OP.LIKE, user.getMobile()));
		if (ObjectUtil.isNotEmpty(user.getHomeAddress()) && !user.getHomeAddress().equals("请输入家庭住址"))
			criteriaSearch.add(new Criteria("homeAddress", OP.LIKE, user.getHomeAddress()));
		if (ObjectUtil.isNotEmpty(user.getStatus()))
			criteriaSearch.add(new Criteria("status", OP.EQ, user.getStatus()));
		list = genericDao.getPageList(User.class, page, criteriaSearch);
		return list;
	}

	/**
	 * 查询用户列表
	 * 
	 * @param
	 * @param
	 * @return List<User>
	 */
	public List<User> getUsers(User user, String... organizationIds) {
		List<User> result = new ArrayList<User>();
		if (ObjectUtil.isNotEmpty(user) && ObjectUtil.isNotEmpty(user.getId()) && ObjectUtil.isNotEmpty(organizationIds)) {
			Criteria criteria = new Criteria("userId", user.getId()).add("organizationId", OP.IN, organizationIds);
			result = genericDao.getList(User.class, criteria);
		}
		return result;
	}

	/**
	 * 查询用户
	 * 
	 * @param
	 * @return User
	 */
	public User getUserId(String userId) {
		User user = null;
		if (ObjectUtil.isNotEmpty(userId)) {
			user = genericDao.get(User.class, userId);
		}
		return user;
	}

	/**
	 * 更新角色(同时设置权限)
	 * 
	 * @param
	 * @param
	 * @return int
	 */
	public int updateRole(Role role, String... accessIds) {
		int result = 0;
		/*
		 * if (ObjectUtil.isNotEmpty(role) &&
		 * ObjectUtil.isNotEmpty(role.getId())) { result = roleDao.update(role);
		 * if (ObjectUtil.isNotEmpty(accessIds)) { ArrayList<RoleAccess> list =
		 * new ArrayList<RoleAccess>(); Integer roleId = role.getId(); for (Long
		 * accessId : accessIds) { list.add(new RoleAccess(roleId, accessId)); }
		 * //先删除以往与此角色相关联的权限，此后再加入新权限 roleAccessDao.delete(new
		 * Criteria("roleId", roleId)); roleAccessDao.batchInsert(list); } }
		 */
		return result;
	}

	/**
	 * 获取角色
	 * 
	 * @param
	 * @return Role
	 */
	public Role getRoleId(String roleCode) {
		Role result = new Role();
		if (ObjectUtil.isNotEmpty(roleCode)) {
			result = roleDao.get(new Criteria("ROLE_CODE",roleCode));
		}
		return result;
	}

	// /**
	// * 获取角色
	// *
	// * @param Long
	// * @param Integer
	// * @return List<Role>
	// */
	// public List<Role> getRoles(Long userId, Integer organizationId) {
	// List<Role> result = new ArrayList<Role>();
	// if (ObjectUtil.isNotEmpty(userId) &&
	// ObjectUtil.isNotEmpty(organizationId)) {
	//
	// result = roleDao.getRoles(userId, organizationId);
	// }
	// return result;
	// }
	/**
	 * 获取角色
	 * 
	 * @return List<Role>
	 */
	public List<Role> getRoles() {
		List<Role> result = roleDao.getAll();
		return result;
	}

	/**
	 * 取得ACCESS绑定权限的部分
	 * 
	 * 
	 */
	@Override
	public List<RoleAccess> getRoleAccess(String roleId, Integer accessLevel) {
		return roleAccessDao.getList(roleId, accessLevel);
	}

	/**
	 * 获取权限
	 * 
	 * @param Long
	 * @param Integer
	 * @return List<Access>
	 */
	// public List<Access> getAccess(Long userId, Integer organizationId) {
	// List<Access> result = new ArrayList<Access>();
	// if (ObjectUtil.isNotEmpty(userId) &&
	// ObjectUtil.isNotEmpty(organizationId)) {
	//
	// result = accessDao.getAccess(userId, organizationId);
	//
	// }
	// return result;
	// }
	/**
	 * 获取权限
	 * 
	 * @param
	 * @return List<Access>
	 */
	public List<Access> getAccess(String roleCode) {
		List<Access> result = new ArrayList<Access>();
		if (ObjectUtil.isNotEmpty(roleCode)) {
			List<RoleAccess> roleAccesses = roleAccessDao.getList(new Criteria("roleCode", roleCode));
			if (ObjectUtil.isNotEmpty(roleAccesses)) {
				List<String> accessCodes = new ArrayList<String>();
				for (RoleAccess roleAccess : roleAccesses) {
					accessCodes.add(roleAccess.getAccessCode());
				}
				result = accessDao.getList(new Criteria("accessCode", OP.IN, accessCodes));
			}
		}
		return result;
	}
	
	public List<Access> getAccezz(String userId,Integer accessLevel){
		return accessDao.getAccezz(userId,accessLevel);	
	}

	/**
	 * 获取权限
	 * 
	 * @return List<Access>
	 */
	public List<Access> getAccess() {
		List<Access> result = accessDao.getAll();
		return result;
	}

	/*
	 * @Override public Organization getOrganization(Long userId, Integer
	 * roleId) { Organization result = new Organization(); if
	 * (ObjectUtil.isNotEmpty(userId) && ObjectUtil.isNotEmpty(roleId)) {
	 * 
	 * result = organizationDao.getOrganization(userId, roleId); } return
	 * result; }
	 */
	@Override
	public int changePassword(String userName, String oldPassword, String newPassword) {
		int result = 0;
		if (ObjectUtil.isNotEmpty(userName) && ObjectUtil.isNotEmpty(oldPassword) && ObjectUtil.isNotEmpty(newPassword)) {
			User user = genericDao.get(User.class, new Criteria("userName", userName).add("password", MD5Encoder.getMD5Str(oldPassword)));
			if (ObjectUtil.isNotEmpty(user)) {
				user.setPassword(MD5Encoder.getMD5Str(newPassword));
				result = genericDao.update(user);
			}
		}
		return result;
	}

	@Override
	public void forgetPassword(String userName, String email) {
		// TODO Auto-generated method stub
	}

	@Override
	public User getUser(Criteria criteria) {
		User user = genericDao.get(User.class, criteria);
		return user;
	}

	@Override
	public int createRole(Role role) {
		int result = 0;
		if (ObjectUtil.isNotEmpty(role)) {
            Integer id = genericDao.getSequenceNextVal("SEQ_ROLE",Integer.class);
			role.setId(id);
			result = genericDao.insert(role);
			setRoleAccess1(role);
		}
		return result;
	}

	@Transactional
	public int setRoleAccess1(Role role) {
		int result = 0;
		String roleCode = role.getRoleCode();
		String accessCodes = role.getAccesses();
		Criteria criteria = new Criteria("roleId", roleCode);
		result = deleteRoleAccess(criteria); // 判断menuIds不为空，删除所有权限信息，并设置新的权限信息
		if (ObjectUtil.isNotEmpty(accessCodes)) {
			// 为角色授予指定权限
			Set<String> set = new HashSet<String>();
			String[] arrMenuId = StringUtil.split(accessCodes, ",");
			for (String menuId : arrMenuId) {
				if (!"0".equals(menuId) && ObjectUtil.isNotEmpty(menuId)) {
					set.add(menuId);
				}
			}
			Iterator<String> itera = set.iterator();
			while (itera.hasNext()) {
                String accessCode = itera.next().toString();
				RoleAccess roleAccess = new RoleAccess();
				roleAccess.setRoleCode(roleCode);
				roleAccess.setAccessCode(accessCode);
				result = roleAccessDao.insert(roleAccess);
			}
		}
		return result;
	}

	@Override
	public int createRoles(List<Role> roles) {
		int result = 0;
		for(Role role : roles) {
			
		}
		if (ObjectUtil.isNotEmpty(roles)) {
			result = roleDao.batchInsert(roles);
		}
		return result;
	}

	@Override
	public int updateRole(Role role) {
		int result = 0;
		if (ObjectUtil.isNotEmpty(role)) {
			result = roleDao.update(role);
			// setRoleAccess(role);
			setRoleAccess1(role);
		}
		return result;
	}

	@Override
	public List<Role> getRoles(String userId, Integer... type) {
		List<Role> roles = new ArrayList<Role>();
		if (ObjectUtil.isNotEmpty(userId)) {
			List<UserRole> userRoles = getUserRole(userId, type);
			if (ObjectUtil.isNotEmpty(userRoles)) {
				List<String> roleIds = new ArrayList<String>();
				for (UserRole userRole : userRoles) {
					roleIds.add(userRole.getRoleId());
				}
				if (ObjectUtil.isNotEmpty(roleIds)) {
					roles = roleDao.getList(new Criteria("roleId", OP.IN, roleIds).add("status", OP.EQ, "1"));
				}
			}
		}
		return roles;
	}

	@Override
	public List<UserRole> getUserRole(String userId, Integer... type) {
		Criteria criteria = new Criteria("userId", userId);
		if (ObjectUtil.isNotEmpty(type)) {
			criteria.add("type", type[0]);
		}
		List<UserRole> userRoles = genericDao.getList(UserRole.class, criteria);
		return userRoles;
	}

	@Override
	public List<Role> getRoles(Criteria criteria) {
		List<Role> roles = roleDao.getList(criteria);
		return roles;
	}

	@Override
	public List<Access> getAccess(String userId, Integer accessLevel, Integer... type) {
		List<Access> accesses = new ArrayList<Access>();
		if (ObjectUtil.isNotEmpty(userId)) {
			List<Role> roles = getRoles(userId, type);
			if (ObjectUtil.isNotEmpty(roles)) {
						List<String> roleCodes = new ArrayList<String>();
				for (Role role : roles) {
					roleCodes.add(role.getRoleCode());
				}
				if (ObjectUtil.isNotEmpty(roleCodes)) {
					List<RoleAccess> roleAccesses = roleAccessDao.getList(new Criteria("roleCode", OP.IN, roleCodes));
					if (ObjectUtil.isNotEmpty(roleAccesses)) {
						List<String> accessCodes = new ArrayList<String>();
						for (RoleAccess roleAccess : roleAccesses) {
							accessCodes.add(roleAccess.getAccessCode());
						}
						accesses = accessDao.getList(new Criteria("accessCode", OP.IN, accessCodes).add("accessLevel", OP.EQ, accessLevel));
					}
				}
			}
		}
		return accesses;
	}

	@Override
    @Transactional
	public int saveRole(String roleCode, String... accessIds) {
        int result = 0;
        if (ObjectUtil.isNotEmpty(roleCode) && ObjectUtil.isNotEmpty(accessIds)) {
            List<RoleAccess> roleAccesses = new ArrayList<>();
            for (String accessCode : accessIds) {
                RoleAccess ra = new RoleAccess();
                ra.setAccessCode(accessCode);
                ra.setRoleCode(roleCode);
                roleAccesses.add(ra);
            }
            // 删除之前的角色与资源关系
            roleAccessDao.delete(new Criteria("roleCode", roleCode));
            //保存新的角色与资源关系
            result = roleAccessDao.batchInsert(roleAccesses);
        }
        return result;
    }

	@Override
	public Map<Integer, SysControl> getSysMap() {
		return getMap(SysControl.class, sysControlDao, 1);
	}

	@SuppressWarnings({ "unchecked", "static-access", "hiding", "unused" })
	private <Integer, T> Map<Integer, T> getMap(Class<T> clazz, @SuppressWarnings("rawtypes") IDao dao, int accessLevel) {
		ClassMetadata classMetadata = ClassMetadata.getMetadata(clazz);
		Map<Integer, T> result = new FastHashMap();
		List<T> list = null;
		switch (accessLevel) {
			case 1:
				list = (List<T>) sysControlDao.getList();
				break;
		}
		for (T field : list) {
			String primaryKey = ClassMetadata.getMetadata(clazz).getPrimaryKey();
			Field f;
			Object value = 0;
			try {
				f = field.getClass().getDeclaredField(primaryKey);
				f.setAccessible(true);
				try {
					value = f.get(field);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			result.put((Integer) integer.valueOf(value.toString()), field);
		}
		return result;
	}
	
	@Override
	public Map<Integer, Menu> getMenuMap() {
		/*
		 * @SuppressWarnings("unchecked") Map<Integer,Menu> result =new
		 * FastHashMap(); List<Menu> list=menuDao.getAll(); for (Menu menu :
		 * list) { result.put(menu.getId(), menu); } return result;
		 */
		return getMap(Menu.class, menuDao);
	}
	/**
	 * 获得启用所有的菜单
	 * 
	 * @return Map
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Menu> getAllMenuMap() {
		Criteria criteria=new Criteria("status",OP.EQ,"0");
		criteria.add("parent_code",OP.EQ,"0");
		//禁用的菜单Map
		Map<String, Menu> disabledMenusMap = new FastHashMap();
		//没有父菜单的菜单
		List<Menu> notParentMenus = null;	
		notParentMenus = menuDao.getList(criteria);
		for (Menu menu : notParentMenus) {
			disabledMenusMap.put(menu.getCode(), menu);
		}
		//可用菜单		
		Map<String, Menu> result = new FastHashMap();
		List<Menu> allMenus = null;	
		Criteria criteria1=new Criteria("status",OP.NE,"0");
		allMenus = menuDao.getList(criteria1);
		for (Menu menu :allMenus) {
			Integer parentCode = menu.getParentCode();
			if (parentCode!=null&&disabledMenusMap.containsKey(parentCode.toString())) {
				disabledMenusMap.put(menu.getCode(), menu);
			}else{
				result.put(menu.getCode(), menu);
			}
		}
		/*for (Menu menu :allMenus) {
			if (!disabledMenusMap.containsKey(menu.getParentCode().toString())) {
				result.put(menu.getCode(), menu);
			}
		}*/
		return result;
	}

	@Override
	public Map<Integer, ActionControl> getActionMap() {
		return getMap(ActionControl.class, actionControlDao);
	}

	@Override
	public Map<Integer, FieldControl> getFieldMap() {
		return getMap(FieldControl.class, fieldControlDao);
	}

	private Integer integer;

	// 要和上面的方法合并
	@SuppressWarnings({ "unchecked", "static-access", "hiding" })
	private <Integer, T> Map<Integer, T> getMap(Class<T> clazz, @SuppressWarnings("rawtypes") IDao dao) {		
		ClassMetadata classMetadata = ClassMetadata.getMetadata(clazz);
		Map<Integer, T> result = new FastHashMap();

		List<T> list = null;
		if (classMetadata.getProperty().containsKey("status")) {
			Criteria criteria=new Criteria("status",OP.NE,"0");
			list = dao.getList(criteria);
		} else {
			list = dao.getAll();
		}
		for (T field : list) {
			String primaryKey = ClassMetadata.getMetadata(clazz).getPrimaryKey();
			Field f;
			Object value = 0;
			try {
				f = field.getClass().getDeclaredField(primaryKey);
				f.setAccessible(true);
				try {
					value = f.get(field);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			result.put((Integer) integer.valueOf(value.toString()), field);
		}
		return result;
	}

	@Override
	public int deleteRoleAccess(Criteria criteria) {
		int result = 0;
		result = roleAccessDao.delete(criteria);
		return result;
	}

	@Override
	public List<Map<String, Object>> getMenuTree(String roleCode) {
		if (roleCode.isEmpty())
			return null;
		return menuDao.getMenuTree(roleCode);
	}

	/**
	 * 设定角色权限
	 * 
	 * @return int
	 */
	// 要将菜单的ID变为ACCESSid
	@Transactional
	public int setRoleAccess(Role role) {
		int result = 0;
        String roleCode = role.getRoleCode();
		String accessIds = role.getAccesses();
		Criteria criteria = new Criteria("roleCode", roleCode);
		result = deleteRoleAccess(criteria); // 判断menuIds不为空，删除所有权限信息，并设置新的权限信息
		if (ObjectUtil.isNotEmpty(accessIds)) {
			// 为角色授予指定权限
			Set<String> set = new HashSet<String>();
			String[] arrMenuId = StringUtil.split(accessIds, ",");
			for (String menuId : arrMenuId) {
				if (!"0".equals(menuId) && ObjectUtil.isNotEmpty(menuId)) {
					set.add(menuId);
				}
			}
			List<Access> accessList = this.getAccess();
			Iterator<String> itera = set.iterator();
			while (itera.hasNext()) {
				Integer menuId = Integer.parseInt(itera.next().toString());
				for (Access acc : accessList) {
					if (acc.getAccessLevel() == 2 && acc.getSrcId() == menuId) {
                        String accessCode = acc.getAccessCode();
						RoleAccess roleAccess = new RoleAccess();
						roleAccess.setRoleCode(roleCode);
						roleAccess.setAccessCode(accessCode);
						result = roleAccessDao.insert(roleAccess);
					}
				}
			}
		}
		return result;
	}

	@Override
	public List<User> getUsers(String... userId) {
		return genericDao.getList(User.class, new Criteria("userId", OP.IN, userId));
	}

	@Override
	@Transactional
	public int updateUserRole(String[] userIds, String[] roleIds) {
		int result = 0;
		if (ObjectUtil.isNotEmpty(userIds)) {
			if (ObjectUtil.isNotEmpty(roleIds)) { // roleIds不为空
				List<UserRole> list = new ArrayList<UserRole>();
				for (String userId : userIds) { // 循环删除用户角色信息
					genericDao.delete(UserRole.class, new Criteria("userId", OP.EQ, userId));
					for (String roleId : roleIds) {
						UserRole userRole = new UserRole();
						userRole.setRoleId(roleId);
						userRole.setUserId(userId);
						list.add(userRole);
					}
				}
				result = genericDao.batchInsert(list);
			} else { // roleIds为空
				for (String userId : userIds) { // 循环删除用户角色信息
					result += genericDao.delete(UserRole.class, new Criteria("userId", OP.EQ, userId));
				}
			}
		}
		return result;
	}

	@Override
	public List<Role> getRoles(String userId, String orgId, Integer type) {
		List<Role> roles = new ArrayList<Role>();
		if (ObjectUtil.isNotEmpty(userId)) {
			List<UserRole> userRoles = getUserRole(userId, orgId, type);
			if (ObjectUtil.isNotEmpty(userRoles)) {
				List<String> roleIds = new ArrayList<String>();
				for (UserRole userRole : userRoles) {
					roleIds.add(userRole.getRoleId());
				}
				if (ObjectUtil.isNotEmpty(roleIds)) {
					roles = roleDao.getList(new Criteria("roleId", OP.IN, roleIds));
				}
			}
		}
		return roles;
	}

	@Override
	public List<UserRole> getUserRole(String userId, String orgId, Integer type) {
		Criteria criteria = new Criteria("userId", userId).add("orgId", orgId);
		if (ObjectUtil.isNotEmpty(type)) {
			criteria.add("type", type);
		}
		List<UserRole> userRoles = genericDao.getList(UserRole.class, criteria);
		return userRoles;
	}

	@Override
	public List<Access> getAccess(String userId, String orgId, Integer type) {
		List<Access> accesses = new ArrayList<Access>();
		if (ObjectUtil.isNotEmpty(userId)) {
			List<Role> roles = getRoles(userId, orgId, type);
			if (ObjectUtil.isNotEmpty(roles)) {
				List<Integer> roleIds = new ArrayList<Integer>();
				for (Role role : roles) {
					roleIds.add(role.getId());
				}
				if (ObjectUtil.isNotEmpty(roleIds)) {
					List<RoleAccess> roleAccesses = roleAccessDao.getList(new Criteria("roleId", OP.IN, roleIds));
					if (ObjectUtil.isNotEmpty(roleAccesses)) {
						List<String> accessCodes = new ArrayList<String>();
						for (RoleAccess roleAccess : roleAccesses) {
							accessCodes.add(roleAccess.getAccessCode());
						}
						accesses = accessDao.getList(new Criteria("accessCode", OP.IN, accessCodes));
					}
				}
			}
		}
		return accesses;
	}

	/*
	 * 分页查询角色
	 */
	@Override
	public PageList<Role> getRoles(Page page, Criteria criteria) {
		PageList<Role> result = roleDao.getPageList(page, criteria);
		return result;
	}
	/*
	 * 分页查询角色
	 */
	@Override
	public PageList<Role> getRoles(Page page, Criteria criteria, Order order) {
		PageList<Role> result = roleDao.getPageList(page, criteria, order);
		return result;
	}

	/*
	 * 条件查询角色
	 */
	@Override
	public PageList<Role> getRoles(Page page, Criteria criteria, Role role) {
		PageList<Role> list;
		Criteria criteriaSearch = new Criteria();
		if (ObjectUtil.isNotEmpty(role.getName()) && !role.getName().equals("请输入角色"))
			criteriaSearch.add(new Criteria("name", OP.LIKE, role.getName()));
		if (ObjectUtil.isNotEmpty(role.getDescription()) && !role.getDescription().equals("请输入描述"))
			criteriaSearch.add(new Criteria("description", OP.LIKE, role.getDescription()));
		list = roleDao.getPageList(page, criteriaSearch);
		return list;
	}

	@Override
	public Role getRole(String roleName) {
		Criteria criteria = new Criteria("name", roleName);
		return roleDao.get(criteria);
	}
}