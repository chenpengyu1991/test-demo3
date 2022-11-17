package com.founder.rhip.ehr.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.founder.elb.entity.Role;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.mdm.entity.Organization;

public class SecurityUtils {


    public static User getCurrentUser(HttpServletRequest request) {
        CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
        User user = currentLoginInfo.getUser();
        /*取当登录前用户*/
        return user;
    }

    public static Organization getCurrentOrganization(HttpServletRequest request) {
        CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
        Organization org = currentLoginInfo.getOrganization();
        /*取当登录前用户*/
        return org;
    }

    public static List<Role> getUserRoles(HttpServletRequest request) {
        CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
        List<Role> roles = new ArrayList<>();
        if(ObjectUtil.isNotEmpty(currentLoginInfo)) {
            roles = currentLoginInfo.getRoles();
        }
        /*取当登录前用户*/
        return roles;
    }

    public static boolean hasRole(RoleType roleType, HttpServletRequest request) {
        List<Role> list = getUserRoles(request);
        if (null == list || list.size() <= 0) return false;
        for (Role role : list) {
            for (RoleType roleCode : RoleType.values()) {
                if (roleCode.equals(roleType)) {
                    if (role.getRoleCode().equalsIgnoreCase(roleCode.getValue())) return true;
                }
            }
        }
        return false;
    }
}
