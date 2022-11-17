package com.founder.rhip.ehr.filter;

import com.founder.rhip.ehr.common.WebProperties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.client.util.AbstractConfigurationFilter;
import org.jasig.cas.client.util.CommonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Andy
 * Date: 13-7-2
 * Time: 下午2:36
 */
public abstract class RHIPAbstractCasFilter extends AbstractConfigurationFilter {
    /** Represents the constant for where the assertion will be located in memory. */
    public static final String CONST_CAS_ASSERTION = "_const_cas_assertion_";

    /** Instance of commons logging for logging purposes. */
    protected final Log log = LogFactory.getLog(getClass());

    /** Defines the parameter to look for for the artifact. */
    private String artifactParameterName = "ticket";

    /** Defines the parameter to look for for the service. */
    private String serviceParameterName = "service";

    /** Sets where response.encodeUrl should be called on service urls when constructed. */
    private boolean encodeServiceUrl = true;

    /**
     * The name of the server.  Should be in the following format: {protocol}:{hostName}:{port}.
     * Standard ports can be excluded. */
    protected String serverName;

    private  String logoutServeceUrl;

    /** The exact url of the service. */
    protected String service;

    public final void init(final FilterConfig filterConfig) throws ServletException {
        if (!isIgnoreInitConfiguration()) {
          // setServerName(getPropertyFromInitParams(filterConfig, "serverName", null));
            setServerName();     //modify by yaofeng
            setLogOutServiceUrl(filterConfig);//增加退出跳转服务url
            filterConfig.getServletContext().setAttribute("logoutUrl",WebProperties.getMsg("cas.casServerUrlPrefix")+"/logout"); //
            filterConfig.getServletContext().setAttribute("logoutServeceUrl",this.logoutServeceUrl); //
            log.trace("Loading serverName property: " + this.serverName);
            setService(getPropertyFromInitParams(filterConfig, "service", null));
            log.trace("Loading service property: " + this.service);
            setArtifactParameterName(getPropertyFromInitParams(filterConfig, "artifactParameterName", "ticket"));
            log.trace("Loading artifact parameter name property: " + this.artifactParameterName);
            setServiceParameterName(getPropertyFromInitParams(filterConfig, "serviceParameterName", "service"));
            log.trace("Loading serviceParameterName property: " + this.serviceParameterName);
            setEncodeServiceUrl(parseBoolean(getPropertyFromInitParams(filterConfig, "encodeServiceUrl", "true")));
            log.trace("Loading encodeServiceUrl property: " + this.encodeServiceUrl);

            initInternal(filterConfig);
        }
        init();
    }

    /** Controls the ordering of filter initialization and checking by defining a method that runs before the init.
     * @param filterConfig the original filter configuration.
     * @throws ServletException if there is a problem.
     *
     */
    protected void initInternal(final FilterConfig filterConfig) throws ServletException {
        // template method
    }

    /**
     * Initialization method.  Called by Filter's init method or by Spring.  Similar in concept to the InitializingBean interface's
     * afterPropertiesSet();
     */
    public void init() {
        CommonUtils.assertNotNull(this.artifactParameterName, "artifactParameterName cannot be null.");
        CommonUtils.assertNotNull(this.serviceParameterName, "serviceParameterName cannot be null.");
        CommonUtils.assertTrue(CommonUtils.isNotEmpty(this.serverName) || CommonUtils.isNotEmpty(this.service), "serverName or service must be set.");
        CommonUtils.assertTrue(CommonUtils.isBlank(this.serverName) || CommonUtils.isBlank(this.service), "serverName and service cannot both be set.  You MUST ONLY set one.");
    }

    // empty implementation as most filters won't need this.
    public void destroy() {
        // nothing to do
    }

    protected final String constructServiceUrl(final HttpServletRequest request, final HttpServletResponse response) {
        return CommonUtils.constructServiceUrl(request, response, this.service, this.serverName, this.artifactParameterName, this.encodeServiceUrl);
    }

    /**
     * Note that trailing slashes should not be used in the serverName.  As a convenience for this common misconfiguration, we strip them from the provided
     * value.
     *
     * @param serverName the serverName. If this method is called, this should not be null.  This AND service should not be both configured.
     */
    public final void setServerName() {
        this.serverName = WebProperties.getMsg("cas.serverName"); //modify by yaofeng
        if (serverName != null && serverName.endsWith("/")) {
            this.serverName = serverName.substring(0, serverName.length()-1);
            log.info(String.format("Eliminated extra slash from serverName [%s].  It is now [%s]", serverName, this.serverName));
        }
    }

    protected void setLogOutServiceUrl(FilterConfig filterConfig){
        String url = WebProperties.getMsg("cas.casServerLoginUrl");
        String contextPath= filterConfig.getServletContext().getContextPath();
        if (url != null ) {
            if(url.startsWith("http://")||url.startsWith("https://")){
                this.logoutServeceUrl=url;
            }else if(url.startsWith("/")){
                this.logoutServeceUrl=serverName+contextPath+url;
            }else{
                this.logoutServeceUrl=serverName+contextPath+"/"+url;
            }
        }else{
            this.logoutServeceUrl=serverName+contextPath;
        }
    }

    public void setService(final String service) {
        this.service = service;
    }

    public final void setArtifactParameterName(final String artifactParameterName) {
        this.artifactParameterName = artifactParameterName;
    }

    public final void setServiceParameterName(final String serviceParameterName) {
        this.serviceParameterName = serviceParameterName;
    }

    public final void setEncodeServiceUrl(final boolean encodeServiceUrl) {
        this.encodeServiceUrl = encodeServiceUrl;
    }

    public final String getArtifactParameterName() {
        return this.artifactParameterName;
    }

    public String getServiceParameterName() {
        return this.serviceParameterName;
    }

}
