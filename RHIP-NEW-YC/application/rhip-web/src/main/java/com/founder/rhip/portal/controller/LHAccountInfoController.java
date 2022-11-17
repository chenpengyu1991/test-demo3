package com.founder.rhip.portal.controller;


import com.founder.elb.common.MessageUtils;
import com.founder.fasf.beans.*;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.entity.portal.AccountInfo;
import com.founder.rhip.portal.service.IAccountInfoService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户管理
 * 
 * @author Zhou Yang
 *
 */
@Controller
@RequestMapping(value = "/lhaccountInfo")
public class LHAccountInfoController extends BaseController {
	@Resource(name="lhaccountInfoService")
	private IAccountInfoService accountInfoService;

	@RequestMapping(value="/search")
	public String search(HttpServletRequest request, ModelMap model) {
		return "rhip.lhportal.lhaccountInfo.search";
	}
	
	/**
	 * 用户列表
	 * 
	 * @param request
	 * @param indexPage
	 * @param model
	 * @param accountInfo
	 * @return
	 */
	@RequestMapping(value="/list")
	public String serachAccountInfoList(HttpServletRequest request, Integer indexPage, ModelMap model, AccountInfo accountInfo) {
		int currentPage = indexPage;
		Page page = super.getPage(request, currentPage);
		Criteria criteria = initSearch(accountInfo);//获取查询条件
		PageList<AccountInfo> list = accountInfoService.getList(page, criteria);
		model.addAttribute("accountInfos", list.getList());
		model.addAttribute("page", list.getPage());
		return "rhip.lhportal.lhaccountInfo.list";
	}
	
	/**
	 * 查看个人信息
	 * 
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/showAccountInfo")
	public String showAccountInfo(HttpServletRequest request, ModelMap model, Long id) {
		AccountInfo accountInfo = accountInfoService.get(id);
		model.addAttribute("accountInfo", accountInfo);
		return "rhip.lhportal.lhaccountInfo.showAccountInfo";
	}

	@RequestMapping("/psdUpdate")
	public void psdUpdate(Long userId, HttpServletResponse response,HttpServletRequest request) {
		accountInfoService.settingPassword(userId);
		MessageUtils.outputJSONResult("1", response);
	}

	/**
	 * 启用禁用用户
	 * 
	 * @param request
	 * @param model
	 * @param id
	 * @param operation
	 * @return
	 */
	@RequestMapping(value="/status")
	public String enable(HttpServletRequest request, ModelMap model, Long id, String operation) {
		if(ObjectUtil.isNotEmpty(id) && operation.trim().equals("enable")) {//启用
			if(accountInfoService.update(new Parameters("status", "1"), new Criteria("id", id)) > 0)
				return EHRMessageUtil.returnMsg(model, "1");
		}
		else
		if(ObjectUtil.isNotEmpty(id) && operation.trim().equals("disable")) {//禁用
			if(accountInfoService.update(new Parameters("status", "0"), new Criteria("id", id)) > 0)
				return EHRMessageUtil.returnMsg(model, "1");
		}
		else
			if(ObjectUtil.isNotEmpty(id) && operation.trim().equals("enableReserve")) {//启用预约
				if(accountInfoService.update(new Parameters("reserveStatus", "1"), new Criteria("id", id)) > 0)
					return EHRMessageUtil.returnMsg(model, "1");
			}
		else
			if(ObjectUtil.isNotEmpty(id) && operation.trim().equals("disableReserve")) {//禁用预约
				if(accountInfoService.update(new Parameters("reserveStatus", "0"), new Criteria("id", id)) > 0)
					return EHRMessageUtil.returnMsg(model, "1");
			}
		return EHRMessageUtil.returnMsg(model, "0");
	}
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public void delete(HttpServletRequest request, HttpServletResponse response, Long id) {
		if(ObjectUtil.isNullOrEmpty(id)) {
			MessageUtils.outputJSONResult("idIsNull", response);
		}
		accountInfoService.delete(id);
		createOperationLog(request, RhipModuleName.LHPORTAL,"罗湖门户用户管理记录删除", OperationName.DELETE);
	}
	
	/**
	 * 用户名，身份证号，状态的查询条件
	 * @param accountInfo
	 * @return
	 */
	private Criteria initSearch(AccountInfo accountInfo) {
		Criteria criteria = new Criteria();
		if(ObjectUtil.isNullOrEmpty(accountInfo)) {
			return criteria;
		}
		if (ObjectUtil.isNotEmpty(accountInfo.getAccountName()) && null != accountInfo.getAccountName())
			criteria.add("accountName", OP.LIKE, accountInfo.getAccountName());
		if (ObjectUtil.isNotEmpty(accountInfo.getCardNo()) && null != accountInfo.getCardNo())
			criteria.add("cardNo", OP.LIKE, accountInfo.getCardNo());
		if (ObjectUtil.isNotEmpty(accountInfo.getStatus()) && null != accountInfo.getStatus())
			criteria.add("status", OP.EQ, accountInfo.getStatus());
		return criteria;
	}
}
