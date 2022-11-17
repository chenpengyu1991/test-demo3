package com.founder.rhip.portal.controller;


import com.founder.elb.common.MessageUtils;
import com.founder.fasf.beans.*;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.entity.portal.AccountInfo;
import com.founder.rhip.ehr.entity.portal.FrequentContacts;
import com.founder.rhip.portal.service.IAccountInfoService;
import com.founder.rhip.portal.service.IFrequentContactsService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 常用联系人管理
 * 
 * @author Zhou Yang
 *
 */
@Controller
@RequestMapping(value = "/frequent")
public class FrequentContactsController extends BaseController {
	@Resource(name="lhaccountInfoService")
	private IAccountInfoService accountInfoService;
	
	@Resource(name="lhFrequentContactsService")
	private IFrequentContactsService frequentService;

	@RequestMapping(value="/search")
	public String search(HttpServletRequest request, ModelMap model) {
		return "rhip.portal.frequent.search";
	}
	
	/**
	 * 常用联系人列表
	 * 
	 * @param request
	 * @param indexPage
	 * @param model
	 * @param accountInfo
	 * @return
	 */
	@RequestMapping(value="/list")
	public String list(HttpServletRequest request, Integer indexPage, ModelMap model, FrequentContacts frequent) {
		int currentPage = indexPage;
		Page page = super.getPage(request, currentPage);
		Criteria criteria = initSearch(frequent);//获取查询条件
		PageList<FrequentContacts> list = frequentService.getRealNameByFrequentPageList(page, criteria);
		model.addAttribute("frequent", list.getList());
		model.addAttribute("page", list.getPage());
		return "rhip.portal.frequent.list";
	}
	
	/**
	 * 查看常用联系人个人信息
	 * 
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/showFrequent")
	public String showFrequent(HttpServletRequest request, ModelMap model, Long id) {
		FrequentContacts frequent = frequentService.get(id);
		model.addAttribute("frequent", frequent);
		return "rhip.portal.frequent.showFrequent";
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
		if(ObjectUtil.isNotEmpty(id) && operation.trim().equals("enableReserve")) {//启用预约
			if(frequentService.update(new Parameters("reserveStatus", "1"), new Criteria("id", id)) > 0)
				return EHRMessageUtil.returnMsg(model, "1");
		}
		else
			if(ObjectUtil.isNotEmpty(id) && operation.trim().equals("disableReserve")) {//禁用预约
				if(frequentService.update(new Parameters("reserveStatus", "0"), new Criteria("id", id)) > 0)
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
		frequentService.delete(id);
		createOperationLog(request, RhipModuleName.LHPORTAL,"门户常用联系人记录删除", OperationName.DELETE);
	}
	
	/**
	 * 姓名名，身份证号，预约状态和性别的查询条件
	 * @param accountInfo
	 * @return
	 */
	private Criteria initSearch(FrequentContacts frequent) {
		Criteria criteria = new Criteria();
		if(ObjectUtil.isNullOrEmpty(frequent)) {
			return criteria;
		}
		if (ObjectUtil.isNotEmpty(frequent.getFrequentName()) && null != frequent.getFrequentName())
			criteria.add("fc.frequent_Name", OP.LIKE, frequent.getFrequentName());
		if (ObjectUtil.isNotEmpty(frequent.getCardNo()) && null != frequent.getCardNo())
			criteria.add("fc.card_No", OP.LIKE, frequent.getCardNo());
		if (ObjectUtil.isNotEmpty(frequent.getReserveStatus()) && null != frequent.getReserveStatus())
			criteria.add("fc.reserve_Status", OP.EQ, frequent.getReserveStatus());
		if (ObjectUtil.isNotEmpty(frequent.getGender()) && null != frequent.getGender())
			criteria.add("fc.gender", OP.EQ, frequent.getGender());
		if (ObjectUtil.isNotEmpty(frequent.getRealName()) && null != frequent.getRealName())
			criteria.add("ac.real_name", OP.EQ, frequent.getRealName());
		return criteria;
	}
}
