package com.founder.rhip.ihm.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.TargetConstants;
import com.founder.rhip.ehr.dto.TargetDTO;
import com.founder.rhip.ehr.service.ihm.IPublicHealthTarget;
import com.founder.rhip.ehr.service.statistics.ITargetOrgService;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.ihm.controller.form.TargetQueryForm;
import com.founder.rhip.ihm.controller.form.TargetValueForm;
import com.founder.rhip.ihm.service.IHmTargetService;

/**
 * 健康管理
 */
@Controller
@RequestMapping("/hm/hm/")
public class HMTargetController extends IHMBaseController {

	@Resource(name = "hmHealthTarget")
	private IPublicHealthTarget hmHealthTarget;

	@Resource(name = "targetOrgService")
	private ITargetOrgService targetOrgService;
	
	@Resource(name = "hmTargetService")
	private IHmTargetService hmTargetService;
	

	@RequestMapping("/index")
	public String index(Model model) {
		Date today = new Date();
		Date startDate = DateUtil.firstDateOfMonth(today);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", today);
		return "ihm.hm.index";
	}

	@RequestMapping("/list")
	public String list(HttpServletRequest request,
			TargetQueryForm targetQueryForm, Model model) {
		Integer nextCodeType = targetQueryForm.getSelectOrgCodeNextCodeType();
		Integer codeType = targetQueryForm.getSelectOrgCodeType();
		String orgCode = targetQueryForm.getSelectOrgCode();
		codeType = codeType(request, codeType);
		orgCode = orgCode(request, orgCode);
		nextCodeType = nextCodeType(request, nextCodeType);
		// /统计指标数组
		String[] targetCodes = TargetConstants.HM_TARGETS;
		List<TargetDTO> targetList = targetOrgService.getTargetDTOs(
				nextCodeType, codeType, orgCode, ITargetOrgService.GET_STATION,
				targetCodes);
		// /统计目标是中心,为True的时候查中心
		model.addAttribute("targetList", targetList);
		return "ihm.hm.list";
	}

	@RequestMapping("/getValue")
	public @ResponseBody
	Float getValue(TargetValueForm targetValueForm, Model model) {
		List<String> orgCodes = targetOrgService.getStationCodes(
				targetValueForm.getType(), targetValueForm.getCode());
		// 统计目标是中心
		if (ObjectUtil.isNullOrEmpty(orgCodes)) {
			return 0.0f;
		}
		Float at = hmHealthTarget.getHmTarget(orgCodes,
				targetValueForm.getBeginTime(), targetValueForm.getEndTime(),
				targetValueForm.getTargetCode());
		return at;
	}

	@RequestMapping("/healthindex")
	public String healthindex(Model model) {
		return "ihm.hm.healthindex";
	}
	
    @RequestMapping("/targetsearch")
    public String targetsearch(HttpServletRequest request,Model model) {
    	//不需要按月查询
    	model.addAttribute("monthRangeFlag", 1);
    	//不需要按季度查询
    	model.addAttribute("quarterRangeFlag", 1);
    	//不需要按时间范围查询
    	model.addAttribute("rangeFlag", 1);
    	
    	model.addAttribute("fullYearFlag", 1);
    	//不需要按上半年查询
    	model.addAttribute("firstHalfYearFlag", 1);
    	//不需要按下半年查询
    	model.addAttribute("secondHalfYearFlag", 1);
    	//不需要按市级医院查询
    	model.addAttribute("hospitalFlag", 1);      	
    	//不需要按站查询
    	model.addAttribute("organFlag", 1);
    	//列表URL
    	model.addAttribute("searchUrl", "/hm/hm/targetlist");
    	//页面URL
    	model.addAttribute("listpath", "hmTarget/targetlist.jsp");
    	model.addAttribute("type", "ihmDa"); // 页面导航文字提示判断
    	initOrg(request,model);
        return "ihm.hm.targetsearch";
    }	
    
    @RequestMapping("/targetlist")
    public String targetlist(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
        List<Map<String, Object>> targets = hmTargetService.getTargetList(form.getYearDate()
        		,form.getGenreCode()
        		,form.getGbCode()
        		,form.getSuperOrganCode());
        model.addAttribute("healthlist", targets);
        model.addAttribute("genreCode",form.getGenreCode());
        return "ihm.hm.targetlist";
    }
    
    @RequestMapping("/ratesearch")
    public String ratesearch(HttpServletRequest request,Model model) {
    	//不需要按月查询
    	model.addAttribute("monthRangeFlag", 1);
    	//不需要按季度查询
    	model.addAttribute("quarterRangeFlag", 1);
    	//不需要按时间范围查询
    	model.addAttribute("rangeFlag", 1);
    	model.addAttribute("fullYearFlag", 1);
    	//不需要按上半年查询
    	model.addAttribute("firstHalfYearFlag", 1);
    	//不需要按下半年查询
    	model.addAttribute("secondHalfYearFlag", 1);
    	//不需要按市级医院查询
    	model.addAttribute("hospitalFlag", 1);    	
    	//列表URL
    	model.addAttribute("searchUrl", "/hm/hm/ratelist");
    	//页面URL
    	model.addAttribute("listpath", "hmTarget/ratelist.jsp");
    	model.addAttribute("type", "ihmDa"); // 页面导航文字提示判断
    	initOrg(request,model);
        return "ihm.hm.ratesearch";
    }	
    
    @RequestMapping("/ratelist")
    public String ratelist(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
        List<Map<String, Object>> rates = hmTargetService.getRateList(form.getYearDate()
        		,form.getGenreCode()
        		,form.getGbCode()
        		,form.getSuperOrganCode()
        		,form.getOrganCode());
        model.addAttribute("healthlist", rates);
        model.addAttribute("genreCode",form.getGenreCode());
        return "ihm.hm.ratelist";
    }    
}