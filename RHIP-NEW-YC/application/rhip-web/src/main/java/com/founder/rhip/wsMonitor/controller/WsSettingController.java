package com.founder.rhip.wsMonitor.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.entity.basic.StandParameterCfg;
import com.founder.rhip.ehr.service.basic.IStandParameterCfgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/wsMonitor/setting")
public class WsSettingController extends BaseController {

	private static final String STANDARD_CODE = "WEBSERVICE_MONITOR";

	private static final String PARAMETER_CODE = "001";

	@Autowired(required = false)
	private IStandParameterCfgService standParameterCfgService;

	/**
	 * 服务监控配置
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public String setting(ModelMap model, HttpServletRequest request) {
		model.addAttribute("standardCode","WEBSERVICE_MONITOR");
		model.addAttribute("parameterCode","001");
		Criteria criteria = new Criteria("standardCode", STANDARD_CODE);
		criteria.add("parameterCode", PARAMETER_CODE);
		StandParameterCfg cfg = standParameterCfgService.getStandParameterCfg(criteria);
		model.addAttribute("parameterValue",cfg.getParameterValue());
		return "rhip.wsMonitor.setting.index";
	}

	@RequestMapping("/save")
	public String saveRefreshTime(HttpServletRequest request
			,String standardCode
			,String parameterCode
			,String parameterValue
			,ModelMap modelMap) {
		boolean result = false;
		StandParameterCfg cfg = new StandParameterCfg();
		List<StandParameterCfg> cfgs = new ArrayList<StandParameterCfg>();

		cfg = new StandParameterCfg();
		cfg.setStandardCode(standardCode);
		cfg.setParameterCode(parameterCode);
		cfg.setParameterValue(parameterValue);
		cfgs.add(cfg);
		try {
			standParameterCfgService.saveStandParameter(cfgs);
			result = true;
		} catch (Exception e) {
			logger.error("保存出错", e);
			result = false;
		}
		return EHRMessageUtil.returnMsg(modelMap, result ? "success" : "fail");
	}
}
