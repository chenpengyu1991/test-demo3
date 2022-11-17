package com.founder.rhip.portal.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AccountLoginFilter implements Filter {

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
        String url = request.getRequestURI();
        String param = request.getQueryString();
        if(url.indexOf("/manage/imageValidator")!=-1){
        	filterChain.doFilter(servletRequest, servletResponse);
        }
        if (sessionKey == null) {
            filterChain.doFilter(request, response);
            return;
        }
        if (!(url.endsWith(redirectURL) || checkExtetionNotFilterList(request) || checkRequestURIIntNotFilterList(request))) {
            if (!isSessionUser(session)) {
                if (isXMLHttpRequestHeader(request)) {
                    response.sendError(403);
                } else {
                    //String referrer = request.getHeader("referer");
                   // if (null != referrer) {
                       // request.getSession().setAttribute("referer.uri", url);
                   // }else {
                    	//request.getSession().setAttribute("referer.uri", request.getContextPath()+redirectURL);
                    //}
                       
                    if (null != param) {
                        request.getSession().setAttribute("referer.uri", url + "?" + param);
                    }else {
                    	request.getSession().setAttribute("referer.uri", url);
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
