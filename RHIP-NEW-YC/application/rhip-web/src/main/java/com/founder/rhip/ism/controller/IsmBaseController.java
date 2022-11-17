package com.founder.rhip.ism.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.founder.fasf.beans.Page;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;

/**
 * 慢病
 * 
 * @author liuk
 * 
 */
public abstract class IsmBaseController extends BaseController {

	private static final String INDEX_PAGE_KEY = "indexPage";// resquest中的当前页的key
	private static final String PAGE_KEY = "page";// page key
	

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
		Page page = super.getPage(request, currentPage); 
		request.setAttribute(PAGE_KEY, page);
		return page;
	}

	/**
	 * 获取角色
	 * 
	 * @param request
	 * @return
	 */
	public RoleType getRole(HttpServletRequest request) {
		RoleType role = null;
		if (hasRole(RoleType.ZX_GLY, request)) {
			role = RoleType.ZX_GLY;
		} else if (hasRole(RoleType.JKMBK, request)) {
			role = RoleType.JKMBK;
		} else if (hasRole(RoleType.Z_GLY, request)) {
			role = RoleType.Z_GLY;
		} else if (hasRole(RoleType.ADMIN, request)) {
			role = RoleType.ADMIN;
		} else {
			Assert.notNull(role, "没有权限,请更换用户登录");
		}
		return role;
	}

	/**
	 * 如果人员生日为空,则根据身份证设置生日
	 * 
	 * @param personInfo
	 * @return
	 */
	public Date setBirthday(PersonInfo personInfo) {
		Date birthday = personInfo.getBirthday();
		if (ObjectUtil.isNullOrEmpty(birthday)) {
			String idcard = personInfo.getIdcard();
			if (ObjectUtil.isNotEmpty(idcard)) {
				// 如果没有生日,根据身份证算出
				birthday = IDCardUtil.getBirthDateByIdCard(idcard);
				personInfo.setBirthday(birthday);
			}
		}
		return birthday;
	}

	/**
	 * 当前controller类功能描述
	 * @return
	 */
	protected  String getActionName() {
		String clazzName=this.getClass().getName();
		return clazzName;
	}

	/**
	 * 记录操作日志
	 * @param request
	 * @param op
	 */
	protected void record(HttpServletRequest request, OperationName op) {
		createOperationLog(request, RhipModuleName.ISM, getActionName(), op);
	}
}
