package com.founder.rhip.mdm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.SysConfigQueryForm;
import com.founder.rhip.mdm.entity.StandParameterCfg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.rhip.mdm.service.IStandParameterCfgService;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/standParameterCfg")
public class StandParameterCfgController extends BaseController{
	@Resource(name = "systemConfigService")
	private IStandParameterCfgService standParameterCfgService;


	@RequestMapping("/search")
	public String search() {
		return "rhip.conifg.sysconfig.search";
	}

	@RequestMapping("/list")
	public String list(HttpServletRequest request, ModelMap modelMap,  int indexPage,SysConfigQueryForm form) {
		Page page = super.getPage(request, indexPage);
		Criteria criteria = form.toCriteria();
		PageList<StandParameterCfg> sysConfigList = standParameterCfgService.getSysConfigList(criteria, page);
		modelMap.addAttribute("sysConfigList", sysConfigList.getList());
		return "rhip.conifg.sysconfig.list";
	}

	@RequestMapping("/modifyConfig")
	public String modifyConfig(ModelMap modelMap,StandParameterCfg standParameterCfg) {
		if(ObjectUtil.isNotEmpty(standParameterCfg)){
			StandParameterCfg standCfg = standParameterCfgService.getSystemConfig(new Criteria("id",standParameterCfg.getId()));
			modelMap.addAttribute("standParameterCfg",standCfg);
		}
		return "rhip.conifg.sysconfig.modifyConfig";
	}

	@RequestMapping("/saveConfig")
	@ResponseBody
	public int saveConfig(HttpServletRequest request, ModelMap modelMap,StandParameterCfg standParameterCfg) {
		int result =0;
		result=standParameterCfgService.saveSystemConfig(standParameterCfg);
		return result;
	}
}
