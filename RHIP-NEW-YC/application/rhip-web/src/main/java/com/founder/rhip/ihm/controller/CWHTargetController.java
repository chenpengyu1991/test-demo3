package com.founder.rhip.ihm.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.util.DateUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.TargetConstants;
import com.founder.rhip.ehr.service.ihm.IPublicHealthTarget;
import com.founder.rhip.ihm.controller.form.TargetValueForm;

/**
 * 妇幼保健
 * @author ggf
 *
 */
@Controller
@RequestMapping("/hm/cwh/")
public class CWHTargetController extends BaseController {
	
	@Resource(name = "womanChildrenService")
	private IPublicHealthTarget  womanChildrenServiceImpl;

	/**
	 * 进入查询页面
	 * @return
	 */
	@RequestMapping("/index")
	public String index(Model model) {
		Date today = new Date();
		Date startDate = DateUtil.firstDateOfMonth(today);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", today);
		return "ihm.cwh.index";
	}
	
	/**
	 * 传递targetCode
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		String[] targetCodes = TargetConstants.cwhCodeArray();
		model.addAttribute("targetCodes", targetCodes);
		return "ihm.cwh.list";
	}
	
	/**
	 * 取值
	 * @param targetValueForm
	 * @param model
	 * @return
	 */
	@RequestMapping("/getValue")
	public @ResponseBody Float getValue(TargetValueForm targetValueForm, Model model) {
		Float value =  womanChildrenServiceImpl.getWomenChildrenTarget(null, targetValueForm.getBeginTime(), targetValueForm.getEndTime(), targetValueForm.getTargetCode());
		return value;
	}
}