package com.founder.rhip.he.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.ConvertingWrapDynaBean;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.ResourceCategory;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.healtheducation.HeActive;
import com.founder.rhip.ehr.entity.healtheducation.HeIndividual;
import com.founder.rhip.ehr.entity.healtheducation.HeResourceRecord;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.he.service.IHeActiveService;
import com.founder.rhip.he.service.IHeIndividualService;

/**
 * 健康教育活动
 * 
 */
@Controller
@RequestMapping(value = "/he/individual")
public class HeIndividualController extends VisitController{
	@Resource(name = "uploadInfoRecordService")
	private IUploadInfoRecordService uploadInfoRecordService;
	@Resource(name = "heIndividualService")
	private IHeIndividualService heIndividualService;
	@RequestMapping("/search")
	public String search() {
		return "rhip.he.health.education.individual.search";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/list")
	public String list(HttpServletRequest request, ModelMap model) {
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria criteria = CriteriaOrganizer.initCriteria(request.getParameterMap(), HeIndividual.class, "GUIDANCE_TIME");

		// 不同身份查询条件
		organizeCriteria(criteria, model, request);
		if(hasRole(RoleType.QWGZX,request) && !criteria.contains("gbcode")){
			criteria.add("gbcode",getCurrentOrg(request).getGbCode());
		}
		criteria.add("status","1");
		PageList<HeIndividual> pageList = heIndividualService.findHealthEducationActive(criteria, page);
		model.addAttribute("heIndividuals", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		return "rhip.he.health.education.individual.list";
	}

	@RequestMapping("/add")
	public String add(Model model, HttpServletRequest request) {
		model.addAttribute("organization",getCurrentOrg(request));
		return "rhip.he.health.education.individual.edit";
	}
	@SuppressWarnings("unchecked")
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(HeIndividual heIndividual, HttpServletRequest request) {
		int ret = 0;
		Map<String, Object> map = new HashMap<>();
		Map<String, String> fileMap = (Map<String, String>) request.getSession().getAttribute("jjdj_fileMap"); // 附件
		map = validateAttchement(map, fileMap, heIndividual.getId());
		if (ObjectUtil.isNotEmpty(map)) {
			return map;
		}
		try {
			// 新增健康教育活动
			if (ObjectUtil.isNullOrEmpty(heIndividual.getId())) {
				initOrgCode(new ConvertingWrapDynaBean(heIndividual), request);
				heIndividualService.createHeIndividual(heIndividual, fileMap, getCurrentUser(request).getName());
			} else { // 更新健康教育活动
				String[] properties = new String[] { "individualName", "gender", "age", "phoneNumber", "idcard", "patownShip", "pastreet", "paGroup",
						"pahouseNumber", "individualType", "educationDesc", "educationType", "guidanceTime", "placeName","placeDesc","healthDesc","guidanceAdvice"
						,"guidanceAdviceDesc","riskQuitSmoking","riskHealthDrink","riskDiet","riskExercise","riskWeightReduction","riskWeightTarget","riskOther","riskOtherDesc",
						"riskHygiene","riskNursing","guideVaccinationDesc","guideVaccination","serviceUnit","individualDesc","preceptor"};
				heIndividualService.updateHeIndividual(heIndividual, fileMap, getCurrentUser(request).getName(),properties);
			}
			ret = 1;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
			ret = 0;
		}
		// 保存成功清理session
		if (ret == 1 && ObjectUtil.isNotEmpty(fileMap)) {
			request.getSession().removeAttribute("jjdj_fileMap");
		}
		map.put("result", ret > 0 ? true : false);
		map.put("message", ret > 0 ? "保存成功!" : "保存失败!");

		return map;
	}
	@RequestMapping("/edit")
	public String edit(Long id, ModelMap model, HttpServletRequest request) {
		// 编辑健康教育资源
		if (ObjectUtil.isNotEmpty(id)) {
			HeIndividual heIndividual = heIndividualService.getHeIndividual(new Criteria("ID", id));
			List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", id).add("FILE_RESOURCE", ResourceCategory.HEALTH_INDIVIDUAL.getCode()));
			model.addAttribute("attches", uploadInfoRecords);
			model.addAttribute("heIndividual", heIndividual);
			model.addAttribute("organization",getCurrentOrg(request));
		}
		return "rhip.he.health.education.individual.edit";
	}
	
	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable("id") Long id, ModelMap model, HttpServletRequest request) {
		if (ObjectUtil.isNotEmpty(id)) {
			HeIndividual heIndividual = heIndividualService.getHeIndividual(new Criteria("ID", id));
			List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", id).add("FILE_RESOURCE", ResourceCategory.HEALTH_INDIVIDUAL.getCode()));
			model.addAttribute("attches", uploadInfoRecords);
			model.addAttribute("heIndividual", heIndividual);
		}
		return "rhip.he.health.education.individual.detail";
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable("id") Long id, HttpServletRequest request) {
		int ret = 0;
		try {
			heIndividualService.deleteHeIndividual(id);
			ret = 1;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
			ret = 0;
		}
		Map<String, Object> map = new HashMap<>();
		map.put("result", ret > 0 ? true : false);
		map.put("message", ret > 0 ? "删除成功!" : "删除失败!");

		return map;
	}
}
