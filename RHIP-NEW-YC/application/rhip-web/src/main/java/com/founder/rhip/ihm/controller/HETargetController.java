package com.founder.rhip.ihm.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.TargetConstants;
import com.founder.rhip.ehr.dto.TargetDTO;
import com.founder.rhip.ehr.service.ihm.IPublicHealthTarget;
import com.founder.rhip.ehr.service.statistics.ITargetOrgService;
import com.founder.rhip.ihm.controller.form.TargetQueryForm;
import com.founder.rhip.ihm.controller.form.TargetValueForm;
/**
 * 健康教育
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/hm/he/")
public class HETargetController extends IHMBaseController {
	
	@Resource(name = "heHealthTarget")
	private IPublicHealthTarget heHealthTarget;
	
	@Resource(name = "targetOrgService")
	private ITargetOrgService targetOrgService;
	
	@RequestMapping("/index")
	public String index(Model model) {
		Date today = new Date();
		Date startDate = DateUtil.firstDateOfMonth(today);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", today);
		return "ihm.he.index";
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request,TargetQueryForm targetQueryForm, Model model) {
		Integer nextCodeType = targetQueryForm.getSelectOrgCodeNextCodeType();
		Integer codeType = targetQueryForm.getSelectOrgCodeType();
		String orgCode = targetQueryForm.getSelectOrgCode();
		codeType = codeType(request, codeType);
		orgCode = orgCode(request, orgCode);
		nextCodeType =nextCodeType(request, nextCodeType);
		///统计指标数组
		String[] targetCodes = TargetConstants.HE_TARGETS;
		List<TargetDTO> targetList = targetOrgService.getTargetDTOs(nextCodeType, codeType, orgCode,ITargetOrgService.GET_STATION ,targetCodes);
		///统计目标是中心,为True的时候查中心
		model.addAttribute("targetList", targetList);
		return "ihm.he.list";
	}
	
	@RequestMapping("/getValue")
	public @ResponseBody Float getValue(TargetValueForm targetValueForm, Model model) {
		List<String> orgCodes = targetOrgService.getStationCodes(targetValueForm.getType(), targetValueForm.getCode());
		//统计目标是中心
		if(ObjectUtil.isNullOrEmpty(orgCodes)){
			return 0.0f;
		}
		Float at =  heHealthTarget.getHETarget(orgCodes, targetValueForm.getBeginTime(), targetValueForm.getEndTime(), targetValueForm.getTargetCode());
		return at;
	}
}