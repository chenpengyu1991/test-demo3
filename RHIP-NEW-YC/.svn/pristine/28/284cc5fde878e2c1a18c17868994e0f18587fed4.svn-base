package com.founder.rhip.portal.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.entity.portal.ReserveRegister;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.portal.controller.form.TargetOrgQueryForm;
import com.founder.rhip.portal.service.IReserveService;

@Controller
@RequestMapping(value = "/protal/statistics")
public class RegisterStatisticsController extends BaseController {

	@Resource(name = "reserveService")
   	private IReserveService reserveService;

	/**
	 * 进入挂号统计首页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/search")
	public String index(HttpServletRequest request,ModelMap model) {
		this.initOrg(request, model);
		return "portal.register.statistics.search";
	}
	
	/**
	 * 挂号统计查询列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String supervisorIndex(TargetOrgQueryForm form,HttpServletRequest request,ModelMap model) {
		Criteria criteria = form.getCriteria();
		List<ReserveRegister> reserveRegisters = reserveService.getRegisterTargetList(criteria);
		model.addAttribute("reserveRegisters", reserveRegisters);
		return "portal.register.statistics.list";
	}
	
	 private void initOrg(HttpServletRequest request, ModelMap model) {
	        Organization org = getCurrentOrg(request);
	        model.addAttribute("orgCode",org.getOrganCode());
	        model.addAttribute("currentBeginDate", DateUtil.firstDateOfMonth(new Date()));
	        model.addAttribute("currentEndDate",DateUtil.lastDateOfMonth(new Date()));
	    }
}
