package com.founder.rhip.da.controller;

import java.util.Date;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.da.controller.form.DaConfigQueryForm;
import com.founder.rhip.da.service.IDaConfigService;
import com.founder.rhip.ehr.entity.clinic.DaConfig;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 医院药品管理配置
 * 
 * 
 * @version 1.0, 2014-6-24
 * @author Ye jianfei
 */
@Controller
@RequestMapping(value = "/da/config")
public class DaConfigController extends DaBaseController {
	
	@Resource(name = "mdmOrganizationService")
	private IOrganizationService organizationService;

	@Resource(name = "daConfigService")
	private IDaConfigService daConfigService;
	
    /**
	 * 进入医院药品管理配置查询画面
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/search")
	public String configSearch(HttpServletRequest request,ModelMap model) {
		Date firstDate = firstDateOfMonth(new Date());
		Date lastDate = lastDateOfMonth(new Date());
		model.addAttribute("firstDate", firstDate);
		model.addAttribute("lastDate", lastDate);	
		return "rhip.da.config.search";
	}


    /**
     * 医院药品管理配置查询结果画面
     * @param form
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String configList(DaConfigQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getCriteria();
		PageList<Organization> pageList = organizationService.getOrganizationsNoVirtual(buildPage(request), ca);
		model.addAttribute("organList", pageList.getList());
		model.addAttribute("page", pageList.getPage());
        return "rhip.da.config.list";
    }
    
    /**
     * 医院药品管理配置详细画面
     * @param form
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/detail")
    public String configDetail(String organCode,String organName,HttpServletRequest request,ModelMap model) {
		DaConfig config = daConfigService.getDaConfig(organCode);
		model.addAttribute("config", config);
		model.addAttribute("organName", organName);
        return "rhip.da.config.detail";
    }    
}
