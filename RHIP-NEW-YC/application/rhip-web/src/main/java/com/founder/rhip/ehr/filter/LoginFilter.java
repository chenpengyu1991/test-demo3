package com.founder.rhip.ehr.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.founder.elb.entity.Role;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.Base64Util;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.basic.UserRole;
import com.founder.rhip.ehr.service.basic.IEhrSecurityService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;

/**
 * checkSessionKey 需检查的在 Session 中保存的关键字，以分号隔开
 * <p/>
 * redirectURL 如果用户未登录，则重定向到指定的页面，URL不包括 ContextPath
 * <p/>
 * notCheckURLList 不做检查的URL列表，以分号分开，并且 URL 中不包括 ContextPath
 */
public class LoginFilter implements Filter {

    protected FilterConfig filterConfig = null;
    private String redirectURL = null;
    private List<String> notCheckURLList = new ArrayList<String>();
    private List<String> prefixList = new ArrayList<String>();
    private String sessionKey = null;
    private List<String> sessionKeyList = new ArrayList<String>();

    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        
        HttpSession session = request.getSession();
        
        // his调用  Goofy 20201112
        String queryString = request.getQueryString();
        if (ObjectUtil.isNotEmpty(queryString)) {
        	String destString = Base64Util.decrypt(queryString, "utf-8");
        	if (StringUtils.contains(destString, "username")) {
    			String userName = StringUtils.substringAfter(destString, "=");
    			ServletContext sc = request.getSession().getServletContext();
    			WebApplicationContext cxt = WebApplicationContextUtils.getWebApplicationContext(sc);
    			if (cxt.getBean("ehrSecurityService") != null && cxt.getBean("organizationApp") != null) {
    				IEhrSecurityService ehrSecurityService = (IEhrSecurityService) cxt.getBean("ehrSecurityService");
    				IOrganizationApp organizationApp = (IOrganizationApp) cxt.getBean("organizationApp");
    				User currentUser = ehrSecurityService.getUser(new Criteria("userName", userName));
    				if (ObjectUtil.isNotEmpty(currentUser)) {
    					session.setAttribute("currentUser", currentUser);
    					List<UserRole> userRoleOrgs = ehrSecurityService.getUserRole(currentUser.getUserCode(), 0);
    					CurrentLoginInfo currentLoginInfo = new CurrentLoginInfo();
    					Organization organization = organizationApp.queryOrgan(userRoleOrgs.get(0).getOrganCode());
    					currentLoginInfo.setUser(currentUser);
    					currentLoginInfo.setOrganization(organization);
    					List<Role> roles = ehrSecurityService.getRoles(currentUser.getUserCode(), userRoleOrgs.get(0).getOrganCode(), 0);
    					currentLoginInfo.setRoles(roles);
    					request.getSession().setAttribute("currentLoginInfo", currentLoginInfo);
					}
    			}
        			
			}
        }
        if (sessionKey == null) {
            filterChain.doFilter(request, response);
            return;
        }
        String url = request.getRequestURI();
        // 不是登录url
        if (!(url.endsWith(redirectURL) || checkExtetionNotFilterList(request) || checkRequestURIIntNotFilterList(request))) {
            if (!isSessionUser(session)) {
                if (isXMLHttpRequestHeader(request)) {
                    response.sendError(403);
                } else {
                    String referrer = request.getHeader("referer");
                    if (null != referrer) {
                        request.getSession().setAttribute("referer.uri", referrer);
                    }
                    response.sendRedirect(request.getContextPath() + redirectURL);
                }
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean isSessionUser(HttpSession session) {

        for (String keyOne : sessionKeyList) {
            if (null != keyOne && session.getAttribute(keyOne) != null) {
                return true;
            }
        }

        return false;
    }

    public void destroy() {
        notCheckURLList.clear();
        prefixList.clear();
        sessionKeyList.clear();
    }

    private boolean checkRequestURIIntNotFilterList(HttpServletRequest request) {
        String uri = request.getServletPath() + (request.getPathInfo() == null ? "" : request.getPathInfo());
        for (String urlOne : notCheckURLList) {
            if (uri.equalsIgnoreCase(urlOne)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkExtetionNotFilterList(HttpServletRequest request) {
        String uri = request.getRequestURI();
        for (String extOne : prefixList) {
            if (uri.endsWith(extOne)) {
                return true;
            }
        }
        return false;
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        redirectURL = filterConfig.getInitParameter("redirectURL");

        String logoutURL=filterConfig.getInitParameter("logoutURL");

        filterConfig.getServletContext().setAttribute("logoutUrl",filterConfig.getServletContext().getContextPath()+logoutURL);

        filterConfig.getServletContext().setAttribute("logoutServeceUrl",filterConfig.getServletContext().getContextPath()+this.redirectURL); //no use

        //for url
        String notCheckURLListStr = filterConfig.getInitParameter("notCheckURLList");

        if (notCheckURLListStr != null) {
            StringTokenizer st = new StringTokenizer(notCheckURLListStr, ";");
            notCheckURLList.clear();
            while (st.hasMoreTokens()) {
                notCheckURLList.add(st.nextToken());
            }
        }

        //for extention
        String prefixStr = filterConfig.getInitParameter("prefixList");

        if (prefixStr != null) {
            StringTokenizer stt = new StringTokenizer(prefixStr, ";");
            prefixList.clear();
            while (stt.hasMoreTokens()) {
                prefixList.add(stt.nextToken());
            }
        }

        //for sessionKey
        sessionKey = filterConfig.getInitParameter("checkSessionKey");
        if (sessionKey != null) {
            StringTokenizer stt = new StringTokenizer(sessionKey, ";");
            sessionKeyList.clear();
            while (stt.hasMoreTokens()) {
                sessionKeyList.add(stt.nextToken());
            }
        }
    }


    private boolean isXMLHttpRequestHeader(HttpServletRequest request) {
        return request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equals("XMLHttpRequest");
    }


}
