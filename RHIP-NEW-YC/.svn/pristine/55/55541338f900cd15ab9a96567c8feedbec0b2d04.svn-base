package com.founder.rhip.ehr.auth;

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

/**
 * Servlet Filter implementation class AuthFilter
 */
public class AuthFilter implements Filter {

	private String authKey = "authKey";//存放用户名的sessionkey
	private String tokenName = "token";//存放token的属性名
	private String redirectURL = null;//验证失败跳转的地址
	private List<String> notCheckURLList = new ArrayList<String>();//不检查的url
	private List<String> prefixList = new ArrayList<String>();//不检查的后缀名

	/**
	 * Default constructor.
	 */
	public AuthFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		notCheckURLList.clear();
		prefixList.clear();
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest rq = (HttpServletRequest) request;
		HttpServletResponse rs = (HttpServletResponse) response;
		// 不过滤的url和后缀
		if (checkRequestURIIntNotFilterList(rq)||checkExtetionNotFilterList(rq)) {
			chain.doFilter(request, response);
			return;
		}
		HttpSession session = rq.getSession();
		// 有sessionKey通过
		if (null != session && null != session.getAttribute(authKey)) {
			chain.doFilter(request, response);
			return;
		} else {
			// 如果有token,则检查token是否有效
			String token = rq.getParameter(tokenName);
			if (null == token || "".equals(token.trim())) {
				//没有则跳转
				rs.sendRedirect(rq.getContextPath() + redirectURL);
				return;
			}
			//检查
			String username = auth(token);
			// token无效或已经过期
			if (null == username || "".equals(username.trim())) {
				rs.sendRedirect(rq.getContextPath() + redirectURL);
				return;
			} else {
				// token 有效，session设置用户名,下次将不再检查token
				session.setAttribute(authKey, username);
				chain.doFilter(request, response);
				return;
			}
		}
	}

	private String auth(String token) {
		String userName = null;
		try {
			userName = TokenUtil.checkToken(token);
		} catch (Exception e) {
			throw new RuntimeException("验证发生错误",e);
		}
		return userName;
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

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		String authKey = fConfig.getInitParameter("authKey");
		if (null != authKey && !"".equals(authKey.trim())) {
			this.authKey = authKey;
		}
		String tokenName = fConfig.getInitParameter("tokenName");
		if (null != tokenName && !"".equals(tokenName.trim())) {
			this.tokenName = tokenName;
		}
		
		String maxInterval = fConfig.getInitParameter("maxInterval");
		if (null != maxInterval && !"".equals(maxInterval.trim())) {
			try {
				TokenUtil.MAX_INTERVAL =	Long.parseLong(maxInterval);
			} catch (NumberFormatException e) {
				//配置不对使用默认值
				//TODO log
			}
		}
		
		redirectURL = fConfig.getInitParameter("redirectURL");

		// for url
		String notCheckURLListStr = fConfig.getInitParameter("notCheckURLList");

		if (notCheckURLListStr != null) {
			StringTokenizer st = new StringTokenizer(notCheckURLListStr, ";");
			notCheckURLList.clear();
			while (st.hasMoreTokens()) {
				notCheckURLList.add(st.nextToken());
			}
		}

		// for extention
		String prefixStr = fConfig.getInitParameter("prefixList");

		if (prefixStr != null) {
			StringTokenizer stt = new StringTokenizer(prefixStr, ";");
			prefixList.clear();
			while (stt.hasMoreTokens()) {
				prefixList.add(stt.nextToken());
			}
		}
	}

}
