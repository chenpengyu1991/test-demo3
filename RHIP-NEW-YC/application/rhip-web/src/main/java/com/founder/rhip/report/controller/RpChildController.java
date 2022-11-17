package com.founder.rhip.report.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.service.report.IRpChildService;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report/rpChild")
public class RpChildController extends BaseController {
	
	@Resource(name = "rpChildService")
	private IRpChildService rpChildService;

    //儿童人数统计报表
	  /**
     * 进入儿童人数统计页面
     * @return
     */
    @RequestMapping("/search")
    public String search(HttpServletRequest request, Model model) {
        model.addAttribute("searchUrl", "/report/rpChild/list");
        initOrg(request, model);
        return "ihm.childCount.search";
    }

    /**
     * 儿童人数统计列表
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(HttpServletRequest request, TargetOrgQueryForm form, Model model) {

        List<Map<String, Object>> resultList = rpChildService.getChildAgeMapList(form.getParamMap());
        if(resultList.size() != 0){
        	 Map<String, Object> data = resultList.get(resultList.size()-1);
             String count = "";
             count = count + "," + data.get("ZERO_NUM");
             count = count + "," + data.get("ONE_NUM");
             count = count + "," + data.get("TWO_NUM"); 
             count = count + "," + data.get("THREE_NUM");
             count = count + "," + data.get("FOUR_NUM");
             count = count + "," + data.get("FIVE_NUM");
             count = count + "," + data.get("SIX_NUM");
             count = count.substring(1, count.length());
             model.addAttribute("count", count);
        }
        model.addAttribute("paCounty",form.getPaCounty());
        model.addAttribute("childCoundList", resultList);
        return "ihm.childCount.list";
    }

}