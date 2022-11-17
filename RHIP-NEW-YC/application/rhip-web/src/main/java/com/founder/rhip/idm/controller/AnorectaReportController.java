package com.founder.rhip.idm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.idm.controller.form.AnorectaQueryForm;
import com.founder.rhip.idm.service.ICaseSurveyService;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/idm/anorecta")
public class AnorectaReportController extends BaseController {

	 @Resource(name = "caseSurveyService")
	 private ICaseSurveyService caseSurveyService;
	
    /**
	 * 进入查询画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/search")
	public String searchAnorectaReport(HttpServletRequest request, ModelMap model) {
		/*根据当前机构，设置页面中的上报机构*/
        Organization org = getCurrentOrg(request);
		/*站和医院 默认*/
        if (hasRole(RoleType.YYCRB, request) || hasRole(RoleType.ZCRB, request)){
        	model.addAttribute("fillOrganCode", org.getOrganCode());
        }
		return "rhip.idm.anorecta.search";
	}

	/**
	 * 查询肛肠门诊旬报表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String getAnorectaReport(HttpServletRequest request, ModelMap model, AnorectaQueryForm form) {
		String url = "rhip.idm.anorecta.list";
		Criteria criteria = new Criteria();
        String orgCode = getCurrentOrg(request).getOrganCode();
        Criteria ca = form.getCriteria();
        //默认为所有机构
        if(ObjectUtil.isNotEmpty(ca.get("centerAndStation"))){//中心及下属站
        	criteria.add("centreCode", ca.get("fillOrganCode"));
        }else if(ObjectUtil.isNotEmpty(ca.get("fillOrganCode"))){//站/中心/医院/疾控
        	criteria.add("stationCode", ca.get("fillOrganCode"));
        }else if(hasRole(RoleType.ZXCRB, request)){//中心登陆时初始化机构：中心及下属站
        	criteria.add("centreCode", orgCode);
        }
        criteria.add("beginDate", ca.get("beginDate"));
        criteria.add("endDate", ca.get("endDate"));
    	List<Map<String,Object>> list =  caseSurveyService.getAnorectaStatisticsList(criteria);
    	model.addAttribute("statisticsMaps", this.sortOrg(list));
		return url;
	}
	
}
