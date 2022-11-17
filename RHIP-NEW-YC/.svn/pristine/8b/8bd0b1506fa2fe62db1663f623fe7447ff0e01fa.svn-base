package com.founder.rhip.fds.controller;

import com.founder.rhip.BaseController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/familyDoctor")
public class FdsManagementController extends BaseController {

	private static final String acctionName = "健康档案";

	private static Logger logger = Logger.getLogger(FdsManagementController.class);

	/**
	 * 打开首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public String search( ModelMap model, HttpServletRequest request) {
		return "com.founder.rhip.fds.index";
	}
}