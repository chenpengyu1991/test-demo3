package com.founder.rhip.ehr.service.basic;

import com.founder.elb.entity.Access;
import com.founder.elb.entity.Menu;
import com.founder.elb.entity.Role;
import com.founder.elb.entity.RoleAccess;
import com.founder.elb.repository.IAccessDao;
import com.founder.elb.repository.IRoleAccessDao;
import com.founder.elb.repository.IRoleDao;
import com.founder.fasf.beans.*;
import com.founder.fasf.map.FastHashMap;
import com.founder.fasf.repository.IDao;
import com.founder.fasf.repository.dialect.Oracle9Dialect;
import com.founder.fasf.security.MD5Encoder;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.WebProperties;
import com.founder.rhip.ehr.entity.basic.PortalUser;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.basic.UserRole;
import com.founder.rhip.ehr.entity.message.ReceivedInfo;
import com.founder.rhip.ehr.repository.basic.IMenuDao;
import com.founder.rhip.ehr.repository.basic.IPortalUserDao;
import com.founder.rhip.ehr.repository.basic.IUserDao;
import com.founder.rhip.ehr.repository.basic.IUserRoleDao;
import com.founder.rhip.ehr.repository.ihm.IMessageReceivedDao;
import com.founder.rhip.mdm.entity.Organization;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("ehrSecurityService")
public class EhrSecurityServiceImpl extends AbstractService implements
        IEhrSecurityService {

	@Resource(name = "ehrUserDao")
	private IUserDao userDao;

	@Resource(name = "ehrUserRoleDao")
	private IUserRoleDao userRoleDao;

	@Resource(name = "portalUserDao")
	private IPortalUserDao portalUserDao;

	@Autowired
	private IAccessDao accessDao;

	@Autowired
	private IRoleDao roleDao;

	@Autowired
	private IRoleAccessDao roleAccessDao;

	@Autowired
	private IMenuDao idsMenuDao;

	@Autowired
	private IMessageReceivedDao messageReceivedDao;

	/**
	 * 创建用户
	 * @param
	 * @return
	 */
	@Override
	@Transactional
	public Long createNewUser(Long id, String organCode){
		User user = userDao.get(id);
		Parameters parameters = new Parameters("status",2);
		userDao.update(parameters, new Criteria("staffCode", user.getStaffCode()));

		String userName = user.getUserName();
		String bakName = getBakUserName(userName);

		user.setUserName(bakName);
		user.setStatus(2);

		//更新已失效用户的用户名
		userDao.update(user);

		//插入新的用户
		user.setId(null);
		String userCode = Oracle9Dialect.getDialect().getSequenceNextValString("USER_SEQUENCE");
		user.setUserCode(userCode);
		user.setUserName(userName);
		user.setStatus(1);
		userDao.generatedKey(user, "ID", null).longValue();
		//插入用户角色
		UserRole userRole = userRoleDao.get(new Criteria("userCode", userCode));
		userRole.setOrganCode(organCode);
		userRole.setUserCode(userCode);
		userRoleDao.insert(userRole);

		return id;
	}

	private String getBakUserName(String uName){
		uName = uName.substring(0, uName.length()-2);

		String newuName;

		for(int i = 1 ; i< 100; i++){
			newuName = uName + "_" + i;
			Criteria criteria = new Criteria("userName", newuName);
			User user = userDao.get(criteria);
			if(user == null){
				return newuName;
			}
		}
		return uName + "_1";
	}


	@Override
	public List<User> getUserList(UserRole userRole, Criteria userCriteria) {
		if (null == userRole) return null;
		return userDao.getUserList(userRole, userCriteria);
	}

	@Override
	@Transactional(value = "transma", rollbackFor = Exception.class)
	public int createUser(User user, List<UserRole> userRoles) {
		int result = 0;
		if (ObjectUtil.isNotEmpty(user) && ObjectUtil.isNotEmpty(userRoles)) {
			String pws = MD5Encoder.getMD5Str(user.getPassword());
			user.setPassword(pws);
			long id = Long.parseLong(userDao.generatedKey(user, "ID",null).toString());
			user.setId(id);
			user.setUserCode(id+"");
			final String[] userUpdateProperties = new String[] {"userCode"};
			result = userDao.update(user,userUpdateProperties);
			if (id > 0 && ObjectUtil.isNotEmpty(userRoles)) {
				userRoles = this.setUserCodeForUserRole(user.getUserCode(), userRoles);
				userRoleDao.batchInsert(userRoles);
			}
		}
		return result;
	}

	@Override
	@Transactional(value = "transma", rollbackFor = Exception.class)
	public int createUser(User user) {
		int result = 0;
		String pws = MD5Encoder.getMD5Str(user.getPassword());
		user.setPassword(pws);
		user.setUserCode(user.getStaffCode());//数据库约束导致无法插入先赋值再更新
		long id = Long.parseLong(userDao.generatedKey(user, "ID",null).toString());
		user.setId(id);
		user.setUserCode(id+"");
		final String[] userUpdateProperties = new String[] {"userCode"};
		result = userDao.update(user,userUpdateProperties);
		return result;
	}

	@Override
	public int createUser(User user, String organCode, String[] roleCodes) {
		int result = 0;
		if (ObjectUtil.isNotEmpty(user) && ObjectUtil.isNotEmpty(organCode)) {
			String pws = MD5Encoder.getMD5Str(user.getPassword());
			user.setPassword(pws);
			long userId = Long.parseLong(userDao.generatedKey(user, "ID",null).toString());
			user.setId(userId);
			user.setUserCode(userId+"");
			final String[] userUpdateProperties = new String[] {"userCode"};
			result = userDao.update(user,userUpdateProperties);
			if (userId > 0 && ObjectUtil.isNotEmpty(roleCodes)) {
				result = insertUserRole(organCode, user.getUserCode(), roleCodes);
			}
		}
		return result;
	}

	/**
	 * 查询用户( 用于检查用户名是否重复)
	 *
	 * @param
	 * @return User
	 */
	@Override
	public User getUser(String userName) {
		User result = null;
		if (!ObjectUtil.isNullOrEmpty(userName)) {
			Criteria criteria = new Criteria("userName", userName);
			result = userDao.get(criteria);
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
	@Override
	public int deleteUser(String... userCodes) {
		int result = 0;
		if (ObjectUtil.isNotEmpty(userCodes)) {
			Criteria criteria = new Criteria("USER_CODE", OP.IN, userCodes);
			result = userDao.delete(criteria);
			result = userRoleDao.delete(criteria);

		}
		return result;
	}

	/**
	 * 变更用户状态
	 * @param status
	 * @param userCodes
	 * @return
	 */
	@Override
	@Transactional
	public int changeStatus(Integer status, String... userCodes) {
		int result = 0;
		if (ObjectUtil.isNotEmpty(userCodes)) {
			result = userDao.update(new Parameters("status", status),
					new Criteria("USER_CODE", OP.IN, userCodes));
		}
		return result;
	}

	/**
	 * 更新个人信息(基本信息)
	 * @param
	 * @return int
	 */
	@Override
	@Transactional
	public int updateUser(User user, List<UserRole> userRoles) {
		int result = 0;
		if (ObjectUtil.isNotEmpty(user) && ObjectUtil.isNotEmpty(user.getId())) {
			User userDb = userDao.get(user.getId());
			user.setPassword(userDb.getPassword());
			result = userDao.update(user);
			userRoleDao.delete(new Criteria("USER_CODE",user.getUserCode()));
			userRoles = this.setUserCodeForUserRole(user.getUserCode(), userRoles);
			userRoleDao.batchInsert(userRoles);
		}
		return result;
	}


	@Override
	public User login(String userName, String password,int status) {
		User user = null;
		try {
			if (ObjectUtil.isNotEmpty(userName)
					&& ObjectUtil.isNotEmpty(password)) {
				Criteria criteria = new Criteria("userName", userName)
						.add(new Criteria("password", MD5Encoder
								.getMD5Str(password))).add("status", status);
				user = userDao.get(criteria); // MD5 Encoder
			}
		} finally {

		}
		return user;
	}

	/**
	 * 查询用户列表
	 *
	 * @param
	 * @return List<User>
	 */
	@Override
	public PageList<User> getUserPageList(Page page, Criteria criteria) {
		PageList<User> result = userDao.getUserList(page, criteria);
		return result;
	}


	/**
	 * 查询用户
	 *
	 * @param
	 * @return User
	 */
	@Override
	public User getUser(Long id) {
		User result = null;
		if (ObjectUtil.isNotEmpty(id)) {
			result = userDao.get(id);
		}
		return result;
	}

	/**
	 * 获取角色
	 *
	 * @return List<Role>
	 */
	@Override
	public List<Role> getRoles() {//先长短排序,再大小排序
		Order order = new Order("nvl(length(trim(role_code)),0)", true).asc("role_code");
		List<Role> result = roleDao.getList(new Criteria("status","1"),order);
		return result;
	}

	@Override
	@Transactional
	public int changePassword(String userName, String oldPassword,
							  String newPassword) {
		int result = 0;
		if (ObjectUtil.isNotEmpty(userName)
				&& ObjectUtil.isNotEmpty(oldPassword)
				&& ObjectUtil.isNotEmpty(newPassword)) {
			User user = userDao.get(new Criteria("userName", userName).add(
					"password", MD5Encoder.getMD5Str(oldPassword)));
			if (ObjectUtil.isNotEmpty(user)) {
				user.setPassword(MD5Encoder.getMD5Str(newPassword));
				result = userDao.update(user);
			}
		}
		return result;
	}

	@Override
	@Transactional
	public int setPassword(String userCode) {
		int result = 0;
		if(ObjectUtil.isNotEmpty(userCode)){
			result = userDao.update(new Parameters("password", MD5Encoder.getMD5Str(WebProperties.getMsg("default.pwd"))), new Criteria("user_code", userCode));
			//同步重置门户中密码（po_user）
			portalUserDao.update(new Parameters("password", MD5Encoder.getMD5Str(WebProperties.getMsg("default.pwd"))), new Criteria("user_code", userCode));
		}
		return result;
	}

	@Override
	@Transactional
	public int setPortalPassword(String userCode) {
		int result = 0;
		if(ObjectUtil.isNotEmpty(userCode)){
			//同步重置门户中密码（po_user）
			portalUserDao.update(new Parameters("password", MD5Encoder.getMD5Str(WebProperties.getMsg("default.pwd"))), new Criteria("user_code", userCode));
		}
		return result;
	}

	@Override
	public User getUser(Criteria criteria) {
		User user = userDao.get(criteria);
		return user;
	}

	@Override
	public List<Role> getRoles(String userCode, Integer... type) {
		List<Role> roles = new ArrayList<Role>();
		if (ObjectUtil.isNotEmpty(userCode)) {
			List<UserRole> userRoles = getUserRole(userCode, type);
			if (ObjectUtil.isNotEmpty(userRoles)) {
				List<String> roleCodes = new ArrayList<String>();
				for (UserRole userRole : userRoles) {
					roleCodes.add(userRole.getRoleCode());
				}
				if (ObjectUtil.isNotEmpty(roleCodes)) {
					roles = roleDao.getList(new Criteria("role_code", OP.IN, roleCodes));
				}
			}
		}
		return roles;
	}

	@Override
	public Map<Organization,List<Role>> getOrgRoleSet(String userCode, List<Organization> orgList){
		Map<Organization,List<Role>> map = new HashMap<Organization,List<Role>>();
		List<Role> list = new ArrayList<Role>();
		for(Organization org:orgList){

			list = this.getRoles(userCode, org.getOrganCode(), 0);
			map.put(org, list);
		}

		return map;
	}

	@Override
	public List<UserRole> getUserRole(String userCode, Integer... type) {
		Criteria criteria = new Criteria("userCode", userCode);
		if (ObjectUtil.isNotEmpty(type)) {
			criteria.add("type", type[0]);
		}
		List<UserRole> userRoles = userRoleDao.getList(criteria);
		return userRoles;
	}

	@Override
	public Map<String, Menu> getMenuMap(Criteria criteria) {
		/*
		 * @SuppressWarnings("unchecked") Map<Integer,Menu> result =new
		 * FastHashMap(); List<Menu> list=menuDao.getAll(); for (Menu menu :
		 * list) { result.put(menu.getId(), menu); } return result;
		 */
		return getAttributeMap(Menu.class, idsMenuDao, "code", criteria);
	}


	private Integer integer;

	@SuppressWarnings({ "unchecked", "static-access", "hiding" })
	private <Integer, T> Map<Integer, T> getMap(Class<T> clazz,
												@SuppressWarnings("rawtypes") IDao dao) {
		@SuppressWarnings("unused")
		ClassMetadata classMetadata = ClassMetadata.getMetadata(clazz);
		Map<Integer, T> result = new FastHashMap();
		//List<T> list = dao.getAll();
		Criteria criteria=new Criteria("status",OP.NE,"0");
		List<T> list = dao.getList(criteria);
		for (T field : list) {
			String primaryKey = ClassMetadata.getMetadata(clazz)
					.getPrimaryKey();
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

	@SuppressWarnings({ "unchecked", "static-access", "hiding" })
	private <Integer, T> Map<String, T> getAttributeMap(Class<T> clazz,
														@SuppressWarnings("rawtypes") IDao dao, String attribute, Criteria criteria) {
		@SuppressWarnings("unused")
		ClassMetadata classMetadata = ClassMetadata.getMetadata(clazz);
		Map<String, T> result = new FastHashMap();
		//List<T> list = dao.getAll();
		if(ObjectUtil.isNullOrEmpty(criteria)) {
			criteria = new Criteria("status",OP.NE,"0");
		}
		List<T> list = dao.getList(criteria);
		for (T field : list) {
			Field f;
			Object value = 0;
			try {
				f = field.getClass().getDeclaredField(attribute);
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
			result.put(value.toString(), field);
		}
		return result;
	}

	@Override
	public List<Role> getRoles(String userCode, String organCode, Integer type) {
		List<Role> roles = new ArrayList<Role>();
		if (ObjectUtil.isNotEmpty(userCode)) {
			List<UserRole> userRoles = getUserRole(userCode, organCode, type);
			if (ObjectUtil.isNotEmpty(userRoles)) {
				List<String> roleCodes = new ArrayList<String>();
				for (UserRole userRole : userRoles) {
					roleCodes.add(userRole.getRoleCode());
				}
				if (ObjectUtil.isNotEmpty(roleCodes)) {
					roles = roleDao.getList(new Criteria("role_code", OP.IN, roleCodes));
				}
			}
		}
		return roles;
	}

	@Override
	public List<UserRole> getUserRole(String userCode, String organCode, Integer type) {
		Criteria criteria = new Criteria("userCode", userCode).add("organCode", organCode);
		if (ObjectUtil.isNotEmpty(type)) {
			criteria.add("type", type);
		}
		List<UserRole> userRoles = userRoleDao.getList(criteria);
		return userRoles;
	}

	@Override
	public List<Access> getAccess(String userCode, String organCode, Integer type,
								  Integer accessLevel) {
		List<Access> accesses = new ArrayList<Access>();
		if (ObjectUtil.isNotEmpty(userCode)) {
			List<Role> roles = getRoles(userCode, organCode, type);
			if (ObjectUtil.isNotEmpty(roles)) {
				List<String> roleCodes = new ArrayList<String>();
				for (Role role : roles) {
					roleCodes.add(role.getRoleCode());
				}
				if (ObjectUtil.isNotEmpty(roleCodes)) {
					List<RoleAccess> roleAccesses = roleAccessDao
							.getList(new Criteria("role_Code", OP.IN, roleCodes));
					if (ObjectUtil.isNotEmpty(roleAccesses)) {
						List<String> accessCodes = new ArrayList<String>();
						for (RoleAccess roleAccess : roleAccesses) {
							accessCodes.add(roleAccess.getAccessCode());
						}
						accesses = accessDao.getList(new Criteria("access_code", OP.IN,
								accessCodes).add("accessLevel", OP.EQ,
								accessLevel));
					}
				}
			}
		}
		return accesses;
	}
	@Override
	public int deleteUserRoleOrganiation(String userCode, String organCode) {
		int result = 0;
		Criteria criteria = new Criteria("userCode", OP.EQ, userCode);
		criteria.add(new Criteria("organCode", OP.EQ, organCode));
		criteria.add(new Criteria("TYPE", OP.EQ, 0));
		result = userRoleDao.delete(criteria);

		return result;
	}
	@Override
	public int updateUserObject(User user){
		return userDao.update(user);
	}

	@Override
	@Transactional
	public int updatePortalUserPassword(String newPassWord,String userCode){
		int result = 0;
		result =portalUserDao.update(new Parameters("password", newPassWord), new Criteria("user_code", userCode));
		return result;
	}

	@Override
	public User loginWithCAS(String userName) {
		if (StringUtils.isBlank(userName)) {
			return null;
		}
		//该方法saas适用
		if(StringUtils.startsWith(userName,"1&")){
			userName = userName.substring(2,userName.length());
		}
		return userDao.get(new Criteria("userName",userName).add("status",1));
	}

	/* (non-Javadoc)
	* <p>Title: getRole</p>
	* <p>Description: </p>
	* @param roleId
	* @return
	* @see com.founder.rhip.ehr.service.basic.IEhrSecurityService#getRole(java.lang.Long)
	*/
	@Override
	public Role getRole(Integer id) {
		return roleDao.get(id);
	}

	/**
	 * 查询未读消息
	 * @param criteria
	 * @return
	 */
	public int getNewMessages(Criteria criteria){

		List<ReceivedInfo> receivedInfos = messageReceivedDao.getList(criteria);
		if(ObjectUtil.isNotEmpty(receivedInfos)){
			return receivedInfos.size();
		}else {
			return 0;
		}
	}
	@Override
	public Role getRole(Criteria criteria) {
		return roleDao.get(criteria);
	}

	/**
	 * 为对象userRoles赋值userCode
	 * @param userCode
	 * @param userRoles
	 */
	private List<UserRole> setUserCodeForUserRole(String userCode, List<UserRole> userRoles) {
		List<UserRole> results = new ArrayList<UserRole>();
		for(UserRole userRole : userRoles) {
			if(ObjectUtil.isNotEmpty(userRole.getRoleCode())) {
				String roleCodes[] = userRole.getRoleCode().split(",");
				for(String roleCode : roleCodes) {
					if(ObjectUtil.isNotEmpty(roleCode)) {
						UserRole temp = new UserRole();
						temp.setUserCode(userCode);
						temp.setOrganCode(userRole.getOrganCode());
						temp.setRoleCode(roleCode);
						temp.setType(EHRConstants.USER_TYPE_OFFICER);// 表示机构
						results.add(temp);
					}
				}
			}
		}
		return results;
	}

	/**
	 * 根据条件获取MDM_USER_ROLE中的org_code
	 * @param criteria
	 * @return
	 */
	@Override
	public List<String> getDistinctOrgCodes(Criteria criteria) {
		return userRoleDao.getDistinctOrgCodes(criteria);
	}

	private int insertUserRole(String organCode, String userCode, String... roleCodes) {
		int result = 0;
		List<UserRole> list = new ArrayList<UserRole>();
		for (String roleCode : roleCodes) {
			UserRole userRole = new UserRole();
			userRole.setRoleCode(roleCode);
			userRole.setType(EHRConstants.USER_TYPE_OFFICER);// 表示机构
			userRole.setUserCode(userCode);
			userRole.setOrganCode(organCode);
			list.add(userRole);
		}
		userRoleDao.batchInsert(list);
		result = list.size();
		return result;
	}
}
