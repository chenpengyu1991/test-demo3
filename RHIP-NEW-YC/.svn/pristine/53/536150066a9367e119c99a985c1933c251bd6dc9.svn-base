package com.founder.rhip.hsa.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.ui.ModelMap;

import com.founder.fasf.beans.Page;
import com.founder.fasf.util.Assert;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;

/**
 * @author liuk
 * 
 */
public abstract class HsaController extends BaseController {
	private static final String INDEX_PAGE_KEY = "indexPage";// resquest中的当前页的key
	private static final String PAGE_KEY = "page";// page key
	private static final boolean DEVELOP_MODE = false;

    protected int getDefaultPageSize() {
    	return EHRConstants.PAGE_SIZE+5;
    }
	/**
	 * 分页设置
	 * 
	 * @param request
	 * @return
	 */
	public Page buildPage(HttpServletRequest request) {
		String indexPage = request.getParameter(INDEX_PAGE_KEY);
		int currentPage = 1;
		try {
			currentPage = Integer.valueOf(indexPage);
		} catch (Exception e) {
			logger.warn("没有当前页数");
		}
		Page page = getPage(request, currentPage);
		request.setAttribute(PAGE_KEY, page);
		return page;
	}

	public RoleType getHrRole(HttpServletRequest request) {
		RoleType role = null;
		if (hasRole(RoleType.ZXWJ, request)) {
			role = RoleType.ZXWJ;
//		} else if (hasRole(RoleType.WSJDSFS, request)) {
//			role = RoleType.WSJDSFS;
//		} else if (hasRole(RoleType.WSJDS, request)) {
//			role = RoleType.WSJDS;
		} else if (hasRole(RoleType.ADMIN, request)) {
			role = RoleType.ADMIN;
		} else if (hasRole(RoleType.ZWJ, request)) { //站可以卫生监督协管  add by bagen
            role = RoleType.ZWJ;
        } else if(hasRole(RoleType.JKWJ,request)){ //卫管中心-卫生监督协管 add by yuanzg
        	role = RoleType.JKWJ;
		}
		Assert.notNull(role, "没有权限,请更换用户登录");
		return role;
	}

	/**
	 * 当前controller类功能描述
	 * 
	 * @return
	 */
	abstract protected String getActionName();

	/**
	 * 记录操作日志
	 * 
	 * @param request
	 * @param op
	 */
	protected void record(HttpServletRequest request, OperationName op) {
		createOperationLog(request, RhipModuleName.WSJDXG, getActionName(), op);
	}

	protected void setCurrentInfo(ModelMap model, HttpServletRequest request) {
		model.put("currentDate", new Date());
		model.put("currentUserName", getCurrentUser(request).getName());
		model.put("currentOrgName", getCurrentOrg(request).getOrganName());
	}

	/**
	 * 处理异常,打印详细信息
	 * 
	 * @param message
	 * @param exception
	 */
	protected void handleException(final String message, final Exception exception) {
		StringBuilder builder = new StringBuilder();
		builder.append(getActionName());
		builder.append("发生错误: ");
		builder.append(message == null ? "" : message);
        builder.append("\n错误详细:");
        builder.append(ExceptionUtils.getStackTrace(exception));
		logger.error(builder.toString(), exception);
		if (DEVELOP_MODE) {
        //    logger.error(builder.toString());
			throw new RuntimeException(message, exception);
		}
	}

    protected Date getCurrentYearStartDate(){
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        calendar.set(year,0,1,0,0,0);
        return  calendar.getTime();
    }
}
