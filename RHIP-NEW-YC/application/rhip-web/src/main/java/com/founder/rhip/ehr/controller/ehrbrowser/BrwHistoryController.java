package com.founder.rhip.ehr.controller.ehrbrowser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.rhip.BaseController;

/**
 * 更新历史
 * @author liuk
 *
 */
@Controller
@RequestMapping("/ehrbrowser/history")
public class BrwHistoryController extends BaseController{

	@RequestMapping()
	public String index(){
		return "rhip.ehr.browser.history";
	}
}
