package com.founder.rhip.ehr.filter;

import com.founder.rhip.ehr.common.WebProperties;
import org.apache.commons.lang.StringUtils;
import org.jasig.cas.client.authentication.DefaultGatewayResolverImpl;
import org.jasig.cas.client.authentication.GatewayResolver;
import org.jasig.cas.client.util.CommonUtils;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 用于处理不需要登录的请求
 * User: Andy
 * Date: 13-6-19
 * Time: 下午5:19
 */
public class RHIPAuthenticationFilter extends RHIPAbstractCasFilter {

    /**
     * The URL to the CAS Server login.
     */
    private String casServerLoginUrl;

    /**
     * Whether to send the renew request or not.
     */
    private boolean renew = false;

    /**
     * Whether to send the gateway request or not.
     */
    private boolean gateway = false;

    /**
     * not required request URL for check
     */
    private String[] notCheckURLArr;
    private String[] prefixListArr;

    private Set<String> matchPreUrl = new HashSet<>();

    private final static String MATCH_STR = "/*";

    private GatewayResolver gatewayStorage = new DefaultGatewayResolverImpl();

    protected void initInternal(final FilterConfig filterConfig) throws ServletException {
        if (!isIgnoreInitConfiguration()) {
            super.initInternal(filterConfig);
            //setCasServerLoginUrl(getPropertyFromInitParams(filterConfig, "casServerLoginUrl", null));
            setCasServerLoginUrl();//modify by yaofeng
            log.trace("Loaded CasServerLoginUrl parameter: " + this.casServerLoginUrl);
            setRenew(parseBoolean(getPropertyFromInitParams(filterConfig, "renew", "false")));
            log.trace("Loaded renew parameter: " + this.renew);
            setGateway(parseBoolean(getPropertyFromInitParams(filterConfig, "gateway", "false")));
            log.trace("Loaded gateway parameter: " + this.gateway);

            final String gatewayStorageClass = getPropertyFromInitParams(filterConfig, "gatewayStorageClass", null);

            if (gatewayStorageClass != null) {
                try {
                    this.gatewayStorage = (GatewayResolver) Class.forName(gatewayStorageClass).newInstance();
                } catch (final Exception e) {
                    log.error(e, e);
                    throw new ServletException(e);
                }
            }

            String notCheckUrl = WebProperties.getMsg("cas.notCheckUrl");
            String prefixList = WebProperties.getMsg("cas.prefixList");
            if (StringUtils.isNotBlank(notCheckUrl)) {
                notCheckURLArr = StringUtils.split(notCheckUrl,";");
                if (notCheckUrl.contains(MATCH_STR)) {
                    for (String str : notCheckURLArr) {
                        if (str.contains(MATCH_STR)) {
                            matchPreUrl.add(StringUtils.substringBefore(str,MATCH_STR));
                        }
                    }
                }
            }
            if (StringUtils.isNotBlank(prefixList)) {
                prefixListArr = StringUtils.split(prefixList,";");
            }
        }
    }

    public void init() {
        super.init();
        CommonUtils.assertNotNull(this.casServerLoginUrl, "casServerLoginUrl cannot be null.");
    }

    public final void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException,

            ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final HttpSession session = request.getSession(false);
        final Assertion assertion = session != null ? (Assertion) session.getAttribute(CONST_CAS_ASSERTION) : null;

        if (assertion != null) {
            filterChain.doFilter(request, response);
            return;
        }

        final String serviceUrl = constructServiceUrl(request, response);
        final String ticket = CommonUtils.safeGetParameter(request, getArtifactParameterName());
        final boolean wasGatewayed = this.gatewayStorage.hasGatewayedAlready(request, serviceUrl);
            /*获取请求地址非完整RequestURL*/
        final String requestURL = request.getServletPath() + (request.getPathInfo() == null ? "" : request.getPathInfo());

        //TODO 用eache缓存机制，减少重复请求验证
            /*处理对部分静态文件请求不做单点登录验证*/
        if (StringUtils.contains(requestURL,".")) {
            String tempStr = StringUtils.substringAfterLast(requestURL,".");
            for (String endStr : prefixListArr) {
                if (endStr.equalsIgnoreCase("."+tempStr)) {
                    filterChain.doFilter(request,response);
                    return;
                }
            }
        }

              /*处理/XX/*请求不做单点登录验证*/
        if (matchPreUrl.size()>0 && !requestURL.contains(".")) {
            for (String str : matchPreUrl) {
                if(StringUtils.containsIgnoreCase(requestURL,str+"/")){
                    filterChain.doFilter(request,response);
                    return;
                }
            }
        }

            /*处理配置中请求不做单点登录验证*/
        for (String url : notCheckURLArr) {
            //  url += request.getServletPath();
            if (requestURL.equalsIgnoreCase(url)) {
                filterChain.doFilter(request, response);
                return;
            }
        }

        if (CommonUtils.isNotBlank(ticket) || wasGatewayed) {
            filterChain.doFilter(request, response);
            return;
        }

        final String modifiedServiceUrl;

        log.debug("no ticket and no assertion found");
        if (this.gateway) {
            log.debug("setting gateway attribute in session");
            modifiedServiceUrl = this.gatewayStorage.storeGatewayInformation(request, serviceUrl);
        } else {
            modifiedServiceUrl = serviceUrl;
        }

        if (log.isDebugEnabled()) {
            log.debug("Constructed service url: " + modifiedServiceUrl);
        }

        //如果是ajax请求直接返回无权限错误
        if(isAjaxRequest(request)){
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        //转到登录页面
        final String urlToRedirectTo = CommonUtils.constructRedirectUrl(this.casServerLoginUrl, getServiceParameterName(), modifiedServiceUrl, this.renew, this.gateway);

        if (log.isDebugEnabled()) {
            log.debug("redirecting to \"" + urlToRedirectTo + "\"");
        }

        response.sendRedirect(urlToRedirectTo);
    }

    public final void setRenew(final boolean renew) {
        this.renew = renew;
    }

    public final void setGateway(final boolean gateway) {
        this.gateway = gateway;
    }

    public final void setCasServerLoginUrl() {
        this.casServerLoginUrl = WebProperties.getMsg("cas.casServerUrlPrefix")+"/login";
    }

    public final void setGatewayStorage(final GatewayResolver gatewayStorage) {
        this.gatewayStorage = gatewayStorage;
    }

    public boolean isAjaxRequest(HttpServletRequest request){
        String header = request.getHeader("X-Requested-With");
        boolean isAjax = "XMLHttpRequest".equals(header) ? true:false;
        return isAjax;
    }
}
