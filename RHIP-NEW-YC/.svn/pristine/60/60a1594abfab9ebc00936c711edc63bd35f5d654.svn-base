package com.founder.rhip.ehr.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.founder.elb.entity.Access;
import com.founder.elb.entity.Menu;
import com.founder.elb.entity.Role;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.PropertiesUtils;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.dto.MenuForm;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.basic.UserRole;
import com.founder.rhip.ehr.service.basic.IEhrSecurityService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class PortalLoginController extends BaseController {

    @Resource(name = "ehrSecurityService")
    private IEhrSecurityService securityService;

    @Resource(name = "organizationApp")
    private IOrganizationApp organizationApp;

    private Properties webProps = PropertiesUtils.initProperties("common-web");
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
            int type = 0;
            request.getSession().setAttribute("currentUser", user);
            String rs = getOrganizations(request, 0, user);
            if("redirect:/access/index".equals(rs)){
                result.put("code", 404);
                result.put("msg", "登录失败，该用户无权限登录系统！");
                return result.toString();
            }

            Cookie cookie = new Cookie("token", token);
            cookie.setDomain(request.getRemoteAddr());
            cookie.setPath(request.getContextPath());
            response.addCookie(cookie);
            response.addHeader("Access-Control-Allow-Credentials", "true");
            //如果请求来源地址，包含在portal.address,则设置Access-Control-Allow-Origin
            String portalAddress = webProps.getProperty("portal.address");
            logger.debug("\033[31;4m" + "portal.address:" +  portalAddress + "\033[0m");
            String []  allowDomain = {"*"};
            if(StringUtil.isNotEmpty(portalAddress)){
                allowDomain = portalAddress.split(",");
            }
            Set<String> allowedOrigins= new HashSet<>(Arrays.asList(allowDomain));
            String originHeader = request.getHeader("Origin");
            logger.debug("\033[31;4m" + "originHeader:" +  originHeader + "\033[0m");
            if (allowedOrigins.contains(originHeader)) {
                response.addHeader("Access-Control-Allow-Origin", originHeader);
                result.put("code", 200);
                result.put("msg", "成功");
            }else{
                logger.error("\033[31;4m" + "originHeader:" +  originHeader + "\033[0m");
                result.put("code", 401);
                result.put("msg", String.format("IP地址：%s，不允许访问", originHeader));
            }


            return result.toString();
        } catch (JWTDecodeException exception) {
            logger.error(exception.getMessage());
            result.put("code", 500);
            result.put("msg", exception.getMessage());
            return result.toString();
        }
    }

    private String getOrganizations(HttpServletRequest request, Integer type,User user) {
        String userCode = user.getUserCode();
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
//                User user = (User) request.getSession().getAttribute("currentUser");
                request.getSession().setAttribute("lastLoginOrg", user.getLastLoginOrg());
                request.getSession().setAttribute("orgMap", orgMap);
                request.getSession().setAttribute("organizations", orglst);
                return "rhip.ehr.login.organization";
            }
        }
        //TODO orgCode 要页面传过来
        return getRoleAccess(type,user, userRoleOrgs.get(0).getOrganCode(),request);
    }

    private String getRoleAccess(Integer userType,User user, @PathVariable("organCode") String organCode,HttpServletRequest request) {
        HttpSession session = request.getSession();
         /*Integer userType = (Integer) session.getAttribute("userType");
        User user = (User) session.getAttribute("currentUser");*/
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
        session.setAttribute("menus", menuForms);
        setCurrentLoginInfo(request, organCode, userType);
        createOperationLog(request, RhipModuleName.LOGIN, "用户登录", OperationName.ADD);
        return "redirect:/home/index";
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
}
