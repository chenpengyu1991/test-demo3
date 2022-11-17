package com.founder.rhip.portal.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.entity.portal.SmsRecord;
import com.founder.rhip.portal.service.ISmsRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA. User: zheng_dandan Date: 13-6-14 Time: 上午9:44 To
 * change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping(value = "/portal/sms")
public class SMSController extends BaseController {

	@Resource(name = "lhsmsService")
	private ISmsRecordService lhsmsService;

	@RequestMapping("/search")
	public String search(HttpServletRequest request) {
		return "rhip.lhportal.sms.search";
	}

	/**
	 * 查询发送短信记录
	 * 
	 * @param request
	 * @param model
	 * @param indexPage
	 * @return
	 */
	@RequestMapping("/list")
	public String getSMSList(SmsRecord sms, Integer indexPage, HttpServletRequest request, ModelMap model) {
		Page page = super.getPage(request, indexPage);
		Criteria criteria = sms.getCriteria();

		PageList<SmsRecord> smsList = lhsmsService.getSMSList(criteria, page);
		model.addAttribute("smsList", smsList.getList());
		model.addAttribute("page", smsList.getPage());
		return "rhip.lhportal.sms.list";

	}

}
