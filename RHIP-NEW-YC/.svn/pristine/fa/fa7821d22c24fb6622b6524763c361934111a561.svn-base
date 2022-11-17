package com.founder.rhip.ehr.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.entity.control.oh.OhTestItems;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.ph.service.oh.IEnterpriseDocService;

/** 
* @ClassName: BulletinController 
* @Description: 公告管理的controller
* @author LJY
* @date 2013-8-2 上午10:05:50 
*  
*/
@Controller
@RequestMapping("/dialog")
public class DialogController extends BaseController {
	
	@Resource(name = "uploadInfoRecordService")
	private IUploadInfoRecordService uploadInfoRecordService;
	
	@Resource(name = "ohEnterpriseDocService")
	private IEnterpriseDocService ohEnterpriseDocService;
	
	@RequestMapping("/showImage")
	public String showImage(HttpServletRequest request, ModelMap model,String id){
		if (ObjectUtil.isNotEmpty(id)) {
			OhTestItems ohTestItems = ohEnterpriseDocService.searchTestItem(new Criteria("id", id));
			if (ObjectUtil.isNotEmpty(ohTestItems)) {
				model.addAttribute("imgUrl", ohTestItems.getMiniUrl());
			}
		}
		return "rhip.ehr.dialog";
	}
}