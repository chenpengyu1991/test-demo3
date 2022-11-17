package com.founder.rhip.ehr.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.founder.elb.entity.Access;
import com.founder.elb.entity.Menu;
import com.founder.elb.entity.Role;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.security.MD5Encoder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.PropertiesUtils;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.WebProperties;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.dto.MenuForm;
import com.founder.rhip.ehr.entity.basic.StandParameterCfg;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.basic.UserRole;
import com.founder.rhip.ehr.service.basic.IEhrSecurityService;
import com.founder.rhip.ehr.service.basic.IStandParameterCfgService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/access")
public class LoginController extends BaseController {

	@Resource(name = "ehrSecurityService")
	private IEhrSecurityService securityService;

	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;

	@Autowired
	private IDictionaryApp dictionaryApp;

	@Resource
	private IStandParameterCfgService standParameterCfgService;

	private Properties webProps = PropertiesUtils.initProperties("common-web");
	@RequestMapping("/index")
	public String index() throws Exception {
		return "rhip.ehr.login.index";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) throws Exception {
		request.getSession().removeAttribute("currentLoginInfo");
		request.getSession().removeAttribute("menus");
		/*request.getSession().removeAttribute("currentUser");*/
		request.getSession().removeAttribute("currentPatient");
		request.getSession().invalidate();
		return "redirect:/";
//		return "rhip.ehr.login.index";
	}

	/**
	 * 清空session 因为当cas退出时没有走/access/logout所以需要手动清空一下
	 *
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/clearSession")
	@ResponseBody
	public Map<String, Object> clearSession(HttpServletRequest request) throws Exception {
		request.getSession().invalidate();
		Map<String, Object> map = new HashMap<>();
		map.put("result", true);
		return map;
	}

	@RequestMapping("/cas")
	public String loginWithCAS(HttpServletRequest request) {
		AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();
		if(ObjectUtil.isNullOrEmpty(principal)) {
			return "redirect:/access/index";
		}
		String name = principal.getName();
		principal.getAttributes();
		User currentUser = securityService.loginWithCAS(name);
		if(ObjectUtil.isNullOrEmpty(currentUser)) {
			FlashScope.getCurrent(request).put("message", "登录失败，您的用户在区域平台系统中不存在，请核实后登录！");
			return "redirect:/access/index";
			//return "rhip.ehr.cas.login.fail";
		}
		request.getSession().setAttribute("isLoginSuccess", "");
		request.getSession().setAttribute("currentUser", currentUser);
		setOnlineUser(currentUser, request);
		if(ObjectUtil.isNotEmpty(request.getSession().getAttribute("saas"))){
			request.getSession().setAttribute("saas",request.getSession().getAttribute("saas"));
		}
		return getOrganizations(request, 0, currentUser.getUserCode());
	}

	@RequestMapping("/login")
	public String login(User user, HttpServletRequest request) {
		//判断当前用户名的用户是否存在
		User loginUser = securityService.getUser(user.getUserName());
		int errorCount = Integer.valueOf(WebProperties.getMsg("login.errorCount"));
		int lockTime = Integer.valueOf(WebProperties.getMsg("login.lockTime"));
		if (ObjectUtil.isNotEmpty(loginUser)) {//用户名存在
			if ("1".equals(loginUser.getLockFlag())) {//判断当前用户是否锁定,若锁定
				long now = new Date().getTime();// 转换成long获取毫秒值
				long time_cha = (now - loginUser.getLockTime().getTime()) / 1000 / 60;// 把时间差的毫秒值转换成分钟
				if (time_cha < lockTime) {//判断锁定时间是否超过lockTime
					long remainTime = lockTime - time_cha ;
					FlashScope.getCurrent(request).put("message", "该用户已被锁定!请在"+remainTime+"分钟后登录");;
					return "redirect:/access/index";
				} else {//锁定时间已经过了，更新用户状态
					loginUser.setLockTime(null);
					loginUser.setLoginErrorCount(0);
					loginUser.setLockFlag("0");
					securityService.updateUserObject(loginUser);
					//重新查询
					loginUser = securityService.getUser(user.getUserName());
				}
			}
			if (!MD5Encoder.getMD5Str(user.getPassword()).equals(loginUser.getPassword())) {
				//获取当前登录失败次数
				int cloginErrorCount = loginUser.getLoginErrorCount();
				if (cloginErrorCount == errorCount - 1) {//如果当前已经登录失败次数等于errorCount-1次
					loginUser.setLockFlag("1");
					loginUser.setLockTime(new Date());
				}
				loginUser.setLoginErrorCount(cloginErrorCount + 1);
				securityService.updateUserObject(loginUser);
				FlashScope.getCurrent(request).put("message", "登录失败，输入的密码不正确！");
			} else {
				int type = 0;
				User currentUser = securityService.login(user.getUserName(), user.getPassword(), 1);
				//登录成功 重置登录失败次数
				currentUser.setLoginErrorCount(0);
				securityService.updateUserObject(currentUser);
				DicItem rootDicItem = dictionaryApp.queryDicItem("FS990001", EHRConstants.FS990001_ROOT);
				request.getSession().setAttribute("rootDicItem", rootDicItem);
				if (ObjectUtil.isNotEmpty(currentUser)) {
					request.getSession().setAttribute("currentUser", currentUser);
					setOnlineUser(user, request);
					Date currentDate=new Date();
					request.getSession().setAttribute("currentDate", currentDate);
					return getOrganizations(request, type, currentUser.getUserCode());
				} else {
					User cuser = securityService.login(user.getUserName(), user.getPassword(), 0);
					if (ObjectUtil.isNotEmpty(cuser)) {
						FlashScope.getCurrent(request).put("message", "登录失败，您的用户已经被禁用请联系管理员！");
					}
				}
			}
		} else {//用户名不存在
			FlashScope.getCurrent(request).put("message", "登录失败，该用户名不存在！");
		}

		return "redirect:/access/index";
	}

	@RequestMapping("/left")
	public String left() {
		return "rhip.ehr.index.left";
	}

	@RequestMapping("/no")
	public String no() {
		return "rhip.ehr.index.no";
	}

	@RequestMapping("/chooseOrg")
	public String chooseOrg(HttpServletRequest request) {
		User user = getCurrentUser(request);
		int type = (int) request.getSession().getAttribute("userType");
		return getOrganizations(request, type, user.getUserCode());
	}

	private String getOrganizations(HttpServletRequest request, Integer type, String userCode) {
		request.getSession().setAttribute("userType", type);
		List<UserRole> userRoleOrgs = securityService.getUserRole(userCode, type);
		if (userRoleOrgs.isEmpty()) {
			FlashScope.getCurrent(request).put("message", "登录失败，该用户无权限登录系统！");
			return "redirect:/access/index";
		}
		if (userRoleOrgs.size() > 1) {
			String[] organizationIds = new String[userRoleOrgs.size()];
			for (int i = 0; i < userRoleOrgs.size(); i++) {
				organizationIds[i] = userRoleOrgs.get(i).getOrganCode();
			}

			List<Organization> orglst = organizationApp.queryOrganization(new Criteria("organCode", OP.IN, organizationIds));
			if (orglst.size() > 1) {
				Map<String, List<Organization>> orgMap = new HashMap<>();
				for(Organization organization : orglst) {
					List<Organization> orgList = new ArrayList<>();
					orgList.add(organization);
					orgMap.put(organization.getOrganCode(), orgList);
				}
				User user = (User) request.getSession().getAttribute("currentUser");
				request.getSession().setAttribute("lastLoginOrg", user.getLastLoginOrg());
				request.getSession().setAttribute("orgMap", orgMap);
				request.getSession().setAttribute("organizations", orglst);
				return "rhip.ehr.login.organization";
			}
		}
		//TODO orgCode 要页面传过来
		return getRoleAccess(request, userRoleOrgs.get(0).getOrganCode());
	}

	@RequestMapping("/getAccess/{organCode}")
	private String getRoleAccess(HttpServletRequest request, @PathVariable("organCode") String organCode) {
		HttpSession session = request.getSession();
		Integer userType = (Integer) session.getAttribute("userType");
		User user = (User) session.getAttribute("currentUser");
		String userCode = user.getUserCode();
		List<Organization> orgList = (List<Organization>) session.getAttribute("organizations");

		user.setLastLoginOrg(organCode); //设定本次登录的机构
		securityService.updateUserObject(user);

		List<Menu> menus = new ArrayList<Menu>();
		Criteria criteria = new Criteria("status",OP.IN, new Integer[]{EHRConstants.MENU_STATUS_RHIP, EHRConstants.MENU_STATUS_COMMON});
		Map<String, Menu> menuMap = securityService.getMenuMap(criteria); // 这里有问题
		List<Access> accesslst = securityService.getAccess(userCode, organCode, userType, 2); // 从role_access中查询
		for (Access access : accesslst) {
			menus.add(menuMap.get(access.getAccessCode())); // 从access中查询：没什么意义
		}

		List<MenuForm> menuForms = getSortedMenuForm(menus);
		request.getSession().setAttribute("menus", menuForms);
		setCurrentLoginInfo(request, organCode, userType);
		createOperationLog(request, RhipModuleName.LOGIN, "用户登录", OperationName.ADD);
		return "redirect:/home/index";//
	}

	private void setCurrentLoginInfo(HttpServletRequest request, String organCode, Integer userType) {

		Organization organization = organizationApp.queryOrgan(organCode);
		User user = (User) request.getSession().getAttribute("currentUser");

		List<Role> roles = securityService.getRoles(user.getUserCode(), organCode, userType);

		CurrentLoginInfo currentLoginInfo = new CurrentLoginInfo();
		currentLoginInfo.setUser(user);
		currentLoginInfo.setOrganization(organization);
		currentLoginInfo.setRoles(roles);
		request.getSession().setAttribute("currentLoginInfo", currentLoginInfo);

		Criteria criteria = new Criteria("RECIPIENT", user.getId());
		criteria.add("STATUS",0);//未读信息
		int newMessageNum = securityService.getNewMessages(criteria);
		request.getSession().setAttribute("newMessageNum", newMessageNum);

		//设置定时刷新报卡数的标识
//		if(hasRole(RoleType.SQZX, request) || hasRole(RoleType.SJYYFBK, request)){
//			ReportRefreshTime reportRefreshTime = sysConfigService.getReportRefreshTime(new Criteria());
//			request.getSession().setAttribute("idmFrequency", reportRefreshTime.getMinutes());//所有报卡提醒频率一样
////			request.getSession().setAttribute("idmFrequency", reportRefreshTime.getIdmFrequency());
////			request.getSession().setAttribute("cmdFrequency", reportRefreshTime.getCmdFrequency());
//			request.getSession().setAttribute("needRefresh", "1");
//		}
	}

	private List<MenuForm> getSortedMenuForm(List<Menu> menus) {
		List<Menu> menuKey = getMenuKey(menus);
		List<MenuForm> menuFormList = new ArrayList<MenuForm>();
		for (Menu menuOne : menuKey) {
			MenuForm menuForm = new MenuForm();
			menuForm.setMenu(menuOne);
			menuForm.setChildMenuForms(getChildByMenuForms(menus, menuOne));
			menuFormList.add(menuForm);
		}

		List<MenuForm> retList = new ArrayList<MenuForm>();
		return sortMenu(retList, menuFormList);
	}

	private List<MenuForm> getChildByMenuForms(List<Menu> menus, Menu menu) {
		List<MenuForm> menuFormList = new ArrayList<MenuForm>();
		if (null == menus || menus.isEmpty() || null == menu)
			return menuFormList;
		for (Menu menuOne : menus) {
			if (null == menuOne)
				continue;
			if (menuOne.getParentCode().equals(Integer.parseInt(menu.getCode()))) {
				MenuForm menuForm = new MenuForm();
				menuForm.setMenu(menuOne);
				menuForm.setChildMenuForms(getThreeLevelChildByMenuForms(menus, menuOne));
				menuFormList.add(menuForm);
			}
		}

		List<MenuForm> retList = new ArrayList<MenuForm>();
		return sortMenu(retList, menuFormList);
	}

	private List<MenuForm> getThreeLevelChildByMenuForms(List<Menu> menus, Menu menu) {
		List<MenuForm> menuFormList = new ArrayList<MenuForm>();
		if (null == menus || menus.isEmpty() || null == menu)
			return menuFormList;
		for (Menu menuOne : menus) {
			if (null == menuOne)
				continue;
			if (menuOne.getParentCode().equals(Integer.parseInt(menu.getCode()))) {
				MenuForm menuForm = new MenuForm();
				menuForm.setMenu(menuOne);
				menuForm.setChildMenuForms(new ArrayList<MenuForm>());
				menuFormList.add(menuForm);
			}
		}
		List<MenuForm> retList = new ArrayList<MenuForm>();
		return sortMenu(retList, menuFormList);
	}

	private List<Menu> getMenuKey(List<Menu> menu) {
		List<Menu> menuKey = new ArrayList<Menu>();
		if (null == menu || menu.isEmpty())
			return menuKey;
		for (Menu menuOne : menu) {
			if (null == menuOne)
				continue;
			if (0 == menuOne.getParentCode()) {
				menuKey.add(menuOne);
			}
		}
		return menuKey;
	}

	private List<MenuForm> sortMenu(List<MenuForm> retList, List<MenuForm> formList) {
		if (!ObjectUtil.isNotEmpty(retList)) {
			retList = new ArrayList<MenuForm>();
		}
		if (!ObjectUtil.isNotEmpty(formList)) {
			return retList;
		}
		int index = 0;
		MenuForm minForm = formList.get(0);
		for (int i = 0; i < formList.size(); i++) {
			MenuForm formI = formList.get(i);
			if (!ObjectUtil.isNotEmpty(minForm.getMenu().getMenuNo())) {
				continue;
			}
			if (!ObjectUtil.isNotEmpty(formI.getMenu().getMenuNo())) {
				continue;
			}
			if (formI.getMenu().getMenuNo() < minForm.getMenu().getMenuNo()) {
				minForm = formList.get(i);
				index = i;
			}
		}
		retList.add(minForm);
		formList.remove(index);
		return sortMenu(retList, formList);
	}

	/**
	 * 当前登录用户的人数
	 *
	 * @param user
	 * @param request
	 */
	private void setOnlineUser(User user, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		//就是获取用户名，因为是struts2可以这样获取
		String username = user.getUserName();
		// 把用户名放入在线列表
		Map<String, String> onlineUserlist = (Map<String, String>) application.getAttribute("onlineUserlist");
		// 第一次使用前，需要初始化
		if (ObjectUtil.isNullOrEmpty(onlineUserlist)) {
			onlineUserlist = new HashMap<String, String>();
		}

		//用户名一样，sessionid不一样，所以是二次登录
//		if(onlineUserlist.containsKey(username) && !(onlineUserlist.get(username).equals(session.getId()))) {
//			onlineUserlist.remove(username);
//		}

		onlineUserlist.put(username, session.getId());
		application.removeAttribute("onlineUserlist");
		application.setAttribute("onlineUserlist", onlineUserlist);
		standParameterCfgService.saveStandParameter(setStandParameterCfg(onlineUserlist.size()));
	}

	/**
	 * StandParameterCfg赋值
	 *
	 * @param count
	 * @return
	 */
	private StandParameterCfg setStandParameterCfg(Integer count) {
		StandParameterCfg standParameterCfg = new StandParameterCfg();
		standParameterCfg.setStandardCode(EHRConstants.STANDARD_CODE_USER);
		standParameterCfg.setStandardName("平台在线人数");
		standParameterCfg.setParameterCode(EHRConstants.PARAMETER_CODE_USER);
		standParameterCfg.setParameterName("总人数");
		standParameterCfg.setParameterValue(count.toString());
		return standParameterCfg;
	}

	/**
	 * 从PORTAL登陆系统
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/loginFromPortal")
	@ResponseBody
	public String loginFromPortal(HttpServletRequest request, HttpServletResponse response) {
		String token = request.getParameter("token");
		JSONObject result = new JSONObject();
		try {
			//解析JWT令牌，寻找用户
			JWT jwt = JWT.decode(token);
			String username = jwt.getClaim("username").asString();
			if(StringUtil.isEmpty(username)){
				result.put("code", 404);
				result.put("msg", "未找到该用户");
				return result.toString();
			}
			User user = securityService.getUser(username);
			if (user == null) {
				result.put("code", 404);
				result.put("msg", "未找到该用户");
			}
			request.getSession().setAttribute("currentUser", user);
			int type = 0;
			String rs = getOrganizations(request, 0, user.getUserCode());
			if("redirect:/access/index".equals(rs)){
				result.put("code", 404);
				result.put("msg", "登录失败，该用户无权限登录系统！");
			}

			//保存cookie，使得下次请求携带cookie，可以做二次验证
			Cookie cookie = new Cookie("token", token);
			cookie.setDomain(request.getRemoteAddr());
			cookie.setPath(request.getContextPath());
			response.addCookie(cookie);
			response.addHeader("Access-Control-Allow-Origin", webProps.getProperty("portal.address"));
			response.addHeader("Access-Control-Allow-Credentials", "true");
			result.put("code", 200);
			result.put("msg", "成功");


			return result.toString();
		} catch (JWTDecodeException exception) {
			logger.error(exception.getMessage());
			result.put("code", 500);
			result.put("msg", exception.getMessage());
			return result.toString();
		}
	}
}