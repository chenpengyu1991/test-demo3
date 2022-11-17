package com.founder.rhip.portal.controller;

import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.dto.PersonalBasicInfoDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.UserOperationLog;
import com.founder.rhip.ehr.entity.portal.AccountInfo;
import com.founder.rhip.ehr.service.basic.IUserOperationLogService;
import com.founder.rhip.portal.common.Constants;
import com.founder.rhip.portal.common.OperationName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Andy
 * Date: 13-2-10
 * Time: 下午1:39
 * To change this template use File | Settings | File Templates.
 */
public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource(name = "userOperationLogService")
    private IUserOperationLogService userOperationLogService;


    @Value("${csws.url}")
    private String cswsUrl;

    //图片显示
    private String imageReplacePattern="src=\"/(\\w+/)?showImage/showUeImage";
    //文件下载
    private String fileReplacePattern="href=\"/(\\w+/)?portal/file/download";

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // 忽略字段绑定异常
        // binder.setIgnoreInvalidFields(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(EHRConstants.COMMON_DATE_PATTERN), true));
    }

    protected void setExcelContent(HttpServletResponse response, String fileName) {
    	String name = fileName;
		try {
			name = new String(fileName.getBytes("GBK"),"ISO8859_1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	response.reset();
    	response.setHeader("Content-Disposition", "attachment; filename=\"" + name + "\"");
    	response.setContentType("application/vnd.ms-excel"); 
    }
    
    protected String getExcelPath(String filePath) throws UnsupportedEncodingException {
    	URL url = Thread.currentThread().getContextClassLoader().getResource(filePath);
    	return URLDecoder.decode(url.getPath(), "UTF-8");
    }

    /**
     *记录用户操作
     * @param request
     * @param moduleName    登录模块名称
     * @param actionName    模块功能名称
     * @param operationName    具体操作
     */
    protected void createOperationLog(HttpServletRequest request, RhipModuleName moduleName,String actionName, OperationName operationName) {
    	AccountInfo user = this.getCurrentUser(request);
        if (user == null || moduleName == null || operationName == null) return;
        UserOperationLog userOperationLog = new UserOperationLog();
        userOperationLog.setUserName(user.getAccountName());
        userOperationLog.setUserIp(getRequestIp(request));
        userOperationLog.setUserRequest(request.getRequestURI());
        userOperationLog.setModuleName(moduleName.getZhName());
        userOperationLog.setActionName(actionName);
        userOperationLog.setOperationName(operationName.getZhName());
        userOperationLog.setOperationTime(new Date());
        userOperationLogService.createOperationLog(userOperationLog);
    }
    
    protected AccountInfo getCurrentUser(HttpServletRequest request) {
        if (ObjectUtil.isNullOrEmpty(request) || ObjectUtil.isNullOrEmpty(request.getSession())) return null;
        return (AccountInfo) request.getSession().getAttribute(Constants.ACCOUNT_INFO);
    }

    /**
     * @author shushu 获取当前用户的id
     * @param request
     * @return
     */
    protected Long getCurrentAccountInfoId(HttpServletRequest request){
        if (ObjectUtil.isNullOrEmpty(getCurrentUser(request))) return null;
        return getCurrentUser(request).getId();
    }

    /**
     *@author:shushu: 取当登录前用户
     * @param request
     * @return
     */
    protected PersonInfo getPerson(HttpServletRequest request) {
        return (PersonInfo) request.getSession().getAttribute(Constants.PERSON_INFO);
    }

    /**
     * @ahutor:shushu:获取当前用户id
     * @param request
     * @return
     */
    protected Long getPersonId(HttpServletRequest request) {
        return ObjectUtil.isNotEmpty(getPerson(request))?getPerson(request).getId():null;
    }

    /**
     * 检查用户是否登录
     * @author: shushu
     * @param request
     * @return
     */
    protected boolean checkLoginStatus(HttpServletRequest request){
        return ObjectUtil.isNotEmpty(getPerson(request))?true:false;
    }


    /**
     * 获取当前用户健康档案的dto
     * @author: shushu
     * @param request
     * @return
     */
    protected PersonalBasicInfoDTO getPersonDtoFromRequest(HttpServletRequest request){
        return (PersonalBasicInfoDTO)request.getSession().getAttribute(Constants.EHR_PERSON_HEALTH);
    }

    public String getRequestIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


    //=====图片地址替换==============//
    protected String changeImageSrc(String infoString) {
        //修正图片和文件地址,修改到平台接口
        if (StringUtil.hasText(infoString) && StringUtil.hasText(cswsUrl) && StringUtil.hasText(imageReplacePattern)) {
            String newInfo = infoString.replaceAll(imageReplacePattern, "src=\"" + cswsUrl + "/showImage/showPortalImage");
            newInfo = newInfo.replaceAll(fileReplacePattern, "href=\"" + cswsUrl + "/portal/file/portalDownload");
            return newInfo;
        }
        return infoString;
    }
}
