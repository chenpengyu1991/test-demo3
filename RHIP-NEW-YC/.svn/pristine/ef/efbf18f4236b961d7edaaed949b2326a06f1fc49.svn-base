package com.founder.rhip.cdm.controller.RiskAssessmentModel;

import com.founder.rhip.BaseController;
import com.founder.rhip.cdm.controller.CdmBaseController;
import com.founder.rhip.cdm.service.ICdPreventService;
import com.founder.rhip.ehr.entity.basic.StandParameterCfg;
import com.founder.rhip.ehr.service.basic.IStandParameterCfgService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 危险因素评估模型
 * 
 */
@Controller
@RequestMapping("/cdm/highrisk")
public class RiskAssessmentModelController extends CdmBaseController {

	private final static String CONTROLLER_NAME = "慢病 危险因素评估模型";

	@Resource
	private IStandParameterCfgService standParameterCfgService;

	@Resource
	private ICdPreventService cdPreventService;

	/**
	 * 危险因素评估模型
	 * 
	 * @return
	 */
	@RequestMapping("/assessmentModel")
	public String assessmentModel(ModelMap map) {
		Map<String, Object> riskFactorModelValues = standParameterCfgService.loadRiskFactorModelValues();
		map.addAttribute("riskFactorModelValues", riskFactorModelValues);
		return "rhip.cdm.highRisk.assessmentModel";
	}

	/**
	 * 保存
	 * 
	 * @param cfgs
	 * @return
	 */
	@RequestMapping("/riskFactorInfoList")
	@ResponseBody
	public String riskFactorInfoList(HttpServletRequest request, ParamForm cfgs) {
		List<StandParameterCfg> standParameterCfgList = cfgs.getCfgs();
		boolean status = standParameterCfgService.saveRiskFactorModel(standParameterCfgList);
		if (status) {
			record(request, BaseController.OperationName.UPDATE);
		}
		return status ? "success" : "failure";
	}

	/**
	 * 给测试提供
	 * 
	 * @return
	 */
	@RequestMapping("/preventive")
	@ResponseBody
	public String preventiveList() {
		cdPreventService.insertPotentialPersonAndParam();
		return "";
	}

	@Override
	protected String getActionName() {
		return CONTROLLER_NAME;
	}
}
