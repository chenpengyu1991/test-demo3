package com.founder.rhip.ep.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.rhip.ehr.common.RhipModuleName;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.ep.IddKnowledgeSurvey;
import com.founder.rhip.ehr.entity.ep.IodineNutritionSampling;
import com.founder.rhip.ep.controller.form.IodineNutritionQueryForm;
import com.founder.rhip.ep.service.IIodineNutritionKnowledgeService;
import com.founder.rhip.ep.service.IIodineNutritionService;
import com.founder.rhip.mdm.entity.Organization;

/**
 * 碘营养与碘缺乏病
 * @author chenweihua
 */
@Controller
@RequestMapping(value = "/ep/iodineNutrition/knowledge")
public class IodineNutritionKnowledgeController extends BaseController {
	
	@Resource
	private IIodineNutritionKnowledgeService iodineNutritionKnowledgeService;
	
	@Resource
	private IIodineNutritionService iodineNutritionService;
	
	@RequestMapping("/search")
	public String search(ModelMap model) {
		model.addAttribute("samplingList", iodineNutritionService.getCurrentYearSampling(null, null));
		return "rhip.ep.iodineNutrition.knowledge.search";
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request,ModelMap model, int indexPage, IodineNutritionQueryForm form) {
		Page page = super.getPage(request, indexPage); 
		Criteria criteria = form.toCriteria();
		criteria.add("deleteFlag", EHRConstants.DELETE_FLG_0);
		PageList<IddKnowledgeSurvey> pageList = iodineNutritionKnowledgeService.getPageList(page, criteria);
		model.addAttribute("knowledgeList", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		model.addAttribute("indexPage", indexPage);
		return "rhip.ep.iodineNutrition.knowledge.list";
	}
	
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, ModelMap model, Long id) {
		IddKnowledgeSurvey knowledge;
		if (ObjectUtil.isNotEmpty(id)) {
			knowledge = iodineNutritionKnowledgeService.getDetail(id);
			String type = knowledge.getSamplingLocationType();
			model.addAttribute("samplingList", iodineNutritionService.getCurrentYearSampling(null, type));
		} else {
			knowledge = new IddKnowledgeSurvey();
		}
		if (StringUtil.isNullOrEmpty(knowledge.getInvestigator())) {
			User user = this.getCurrentUser(request);
			knowledge.setInvestigator(user.getName());
		}
		if (StringUtil.isNullOrEmpty(knowledge.getInvestigateUnit())) {
			Organization organization=this.getCurrentOrg(request);
			knowledge.setInvestigateUnit(organization.getOrganName());
		}
		if (ObjectUtil.isNullOrEmpty(knowledge.getInvestigateTime())) {
			knowledge.setInvestigateTime(new Date());
		}
		model.addAttribute("knowledge", knowledge);
		return "rhip.ep.iodineNutrition.knowledge.infoEdit";
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public ModelMap save(HttpServletRequest request, IddKnowledgeSurvey knowledge) {
		ModelMap model = new ModelMap();
		setValue(request, knowledge);
		try {
			iodineNutritionKnowledgeService.save(knowledge);
			model.addAttribute("success", true);
			model.addAttribute("message", "保存成功");
			if (knowledge.getId() == null) {
				createOperationLog(request, RhipModuleName.EP, "地方病碘营养问卷调查保存", OperationName.ADD);
			} else {
				createOperationLog(request, RhipModuleName.EP, "地方病碘营养问卷调查保存", OperationName.UPDATE);
			}
		} catch (Exception e) {
			logger.error("保存出错", e);
			model.addAttribute("success", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public ModelMap delete(HttpServletRequest request, Long id) {
		ModelMap model = new ModelMap();
		//IddKnowledgeSurvey knowledge = iodineNutritionKnowledgeService.getDetail(id);
		//setValue(request, knowledge);
		//knowledge.setDeleteFlag(EHRConstants.DELETE_FLG_1);
		try {
			iodineNutritionKnowledgeService.delete(id);
			model.addAttribute("success", true);
			model.addAttribute("message", "删除成功");
			createOperationLog(request, RhipModuleName.EP, "地方病碘营养问卷调查删除", OperationName.DELETE);
		} catch (Exception e) {
			logger.error("删除出错", e);
			model.addAttribute("success", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	private void setValue(HttpServletRequest request, IddKnowledgeSurvey knowledge) {
		Date now  = new Date();
		Long id = knowledge.getId();
		User user = this.getCurrentUser(request);
		Organization organization=this.getCurrentOrg(request);
		
		if (ObjectUtil.isNullOrEmpty(id)) {
			knowledge.setCreatePerson(user.getUserName());
			knowledge.setCreateOrgan(organization.getOrganCode());
			knowledge.setCreateTime(now);
			knowledge.setDeleteFlag(EHRConstants.DELETE_FLG_0);
		} else {
			knowledge.setUpdatePerson(user.getUserName());
			knowledge.setUpdateOrgan(organization.getOrganCode());
			knowledge.setUpdateTime(now);
		}
		Long samplingId = knowledge.getSamplingId();
		IodineNutritionSampling sampling = iodineNutritionService.getDetail(samplingId);
		knowledge.setSamplingLocationName(sampling.getName());
	}
}
