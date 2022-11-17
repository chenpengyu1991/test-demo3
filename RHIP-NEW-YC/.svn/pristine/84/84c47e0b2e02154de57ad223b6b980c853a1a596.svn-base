package com.founder.rhip.cdm.controller.populationSet;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.cdm.controller.CdmBaseController;
import com.founder.rhip.cdm.service.IPopulaceInfoService;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.management.DmPopulaceInfo;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 人口设置
 */
@Controller
@RequestMapping("/cdm/population")
public class populationSetController extends CdmBaseController {

	private final static String CONTROLLER_NAME = "慢病人口设置";

	@Resource
	private IPopulaceInfoService populaceInfoService;

	@Autowired
	private IDictionaryApp dictionaryApp;

	/**
	 * 人口数设置
	 * 
	 * @return
	 */
	@RequestMapping("/setUp")
	public String populationSetup(ModelMap model) {
		model.addAttribute("defaultYear", Integer.valueOf(DateUtil.getCurrentYear()));
		return "rhip.cdm.populationSetup.search";
	}

	/**
	 * 显示人口结果
	 * 
	 * @param countYear
	 * @param model
	 * @return
	 */
	@RequestMapping("/populationSetupResult")
	public String manageHome(@RequestParam("countYear") Integer countYear, ModelMap model) {
		Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
		List<DicItem> items = dictionaryApp.queryDicItem(criteria);
		if (countYear == null) {
			countYear = Integer.valueOf(DateUtil.getCurrentYear());
		}
		List<DmPopulaceInfo> dmPopulaceInfo = populaceInfoService.buildPopulaceInfo(countYear, items);
		model.addAttribute("townList", dmPopulaceInfo);
		model.addAttribute("year", countYear);
		return "rhip.cdm.populationSetup.result";
	}

	/**
	 * 保存人口设置
	 * 
	 * @param request
	 * @param dmPopulaceInfo
	 * @return
	 */
	@RequestMapping("/savePopulaceInfo")
	@ResponseBody
	public String savePopulaceValues(HttpServletRequest request, populaceForm dmPopulaceInfo) {
		boolean status = populaceInfoService.saveOrUpdatePopulaceInfo(dmPopulaceInfo.getDmPopulaceInfo());
		if (status) {
			record(request, BaseController.OperationName.UPDATE);
		}
		return status ? "success" : "failure";
	}

	@Override
	protected String getActionName() {
		return CONTROLLER_NAME;
	}
}
