package com.founder.rhip.phsr.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.common.VoUtil;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.dto.Tuberculosis;
import com.founder.rhip.ehr.dto.TuberculosisDto;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.he.controller.VisitController;
import com.founder.rhip.ihm.service.ItuberculosisService;

/**
 * 肺结核患者健康管理统计报表
 */
@Controller
@RequestMapping(value = "/tubercCensus")
public class TubercCensusController extends VisitController{
	@Resource(name = "tuberculosisService")
	private ItuberculosisService tuberculosisService;
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request, ModelMap model) {
		model.addAttribute("currentYear",new Date());
		return "rhip.phsr.he.tubercCensus.search";
	}
	
	/**
	 * 列表显示肺结核患者健康管理统计报表
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/list")
	public String list(HttpServletRequest request, ModelMap model) {
		Criteria criteria = CriteriaOrganizer.initCriteriaCondition(request.getParameterMap());
		criteria.remove("date"); // 去除多余的条件
		String countType = request.getParameter("countType");
		if("2".equals(countType)){//按月
			criteria.remove("createBeginTime");
			criteria.remove("createEndTime");
		}else if("1".equals(countType)){//按年
			criteria.remove("month");
		}
		criteria.remove("countType");
		// 不同身份查询条件
		organizeCriteria(criteria, model, request, RoleType.ZXJHB, RoleType.ZJHB, RoleType.YYJHB);
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		if(SecurityUtils.hasRole(RoleType.QWGZX, request)){
			criteria.add("qwgzxCode",currentLoginInfo.getOrganization().getGbCode());
		}
		List<Tuberculosis> reports = tuberculosisService.tuberculosisServiceList(criteria);
		if(SecurityUtils.hasRole(RoleType.QWGZX, request)){
			criteria.add("qwgzxCode",currentLoginInfo.getOrganization().getGbCode());
		}
		Tuberculosis tuberculosisServiceDto=tuberculosisService.tuberculosisServiceListSum(criteria);
		List<Tuberculosis> reportList =new ArrayList<>();
		
		if(SecurityUtils.hasRole(RoleType.ZX_GLY, request) ||SecurityUtils.hasRole(RoleType.ZXJHB, request) ||SecurityUtils.hasRole(RoleType.Z_GLY, request) ||SecurityUtils.hasRole(RoleType.ZJHB, request)) {
			criteria.remove("orgCode");
			criteria.add("orgCode",currentLoginInfo.getOrganization().getOrganCode());
			reportList = tuberculosisService.tuberculosisServiceList(criteria);
		}else{
			reportList.addAll(reports);
		}
		
		criteria.remove("orgCode");
		model.addAttribute("currentLoginInfo", currentLoginInfo);
		model.addAttribute("reports", reports);
		model.addAttribute("reportList", reportList);
		model.addAttribute("tuberculosisServiceDto", tuberculosisServiceDto);
		
		return "rhip.phsr.he.tubercCensus.list";
	}
	
	@ResponseBody
	@RequestMapping("/saveTubercCensus")
	public String saveTubercCensus(HttpServletRequest request, ModelMap model) {
		TuberculosisDto tuberculosisDto = VoUtil.getFormData(request, TuberculosisDto.class);
		int num=0;
		for (int i = 0; i < tuberculosisDto.getTuberculosisDtoList().size(); i++) {
			if(ObjectUtil.isNotEmpty(tuberculosisDto.getTuberculosisDtoList().get(i))){
				if(ObjectUtil.isNotEmpty(tuberculosisDto.getTuberculosisDtoList().get(i).getId())){
					tuberculosisDto.getTuberculosisDtoList().get(i).setUpdateReportingTime(new Date());
					num=tuberculosisService.updateTuberculosis(tuberculosisDto.getTuberculosisDtoList().get(i));
				}else{
				    CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
				    tuberculosisDto.getTuberculosisDtoList().get(i).setOrgCode(currentLoginInfo.getOrganization().getOrganCode());
				    tuberculosisDto.getTuberculosisDtoList().get(i).setOrgName(currentLoginInfo.getOrganization().getOrganName());
				    if(SecurityUtils.hasRole(RoleType.ZXJHB, request)||SecurityUtils.hasRole(RoleType.ZX_GLY, request)) {
				    	tuberculosisDto.getTuberculosisDtoList().get(i).setCenterOrgCode(currentLoginInfo.getOrganization().getOrganCode());
				    }else if(SecurityUtils.hasRole(RoleType.ZJHB, request)||SecurityUtils.hasRole(RoleType.Z_GLY, request)){
				    	tuberculosisDto.getTuberculosisDtoList().get(i).setCenterOrgCode(currentLoginInfo.getOrganization().getParentCode());
				    }
				   
				    tuberculosisDto.getTuberculosisDtoList().get(i).setGbCode(currentLoginInfo.getOrganization().getGbCode());
				    tuberculosisDto.getTuberculosisDtoList().get(i).setYear(Integer.parseInt(request.getParameter("year")));
				    tuberculosisDto.getTuberculosisDtoList().get(i).setMonth(Integer.parseInt(request.getParameter("month")));
				    tuberculosisDto.getTuberculosisDtoList().get(i).setReportingTime(new Date());
				    num=tuberculosisService.addTuberculosis(tuberculosisDto.getTuberculosisDtoList().get(i));
				}
			}
		}
		if(num>0){
			return "保存成功!";
		}else{
			return "保存失败!";
		}
	}
}
