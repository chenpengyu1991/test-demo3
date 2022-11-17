package com.founder.rhip.ep.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.ep.IodineNutritionMonitor;
import com.founder.rhip.ehr.entity.ep.IodineNutritionSampling;
import com.founder.rhip.ep.controller.form.IodineNutritionQueryForm;
import com.founder.rhip.ep.service.IIodineNutritionMonitorService;
import com.founder.rhip.ep.service.IIodineNutritionService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.entity.SchoolInfo;
import com.founder.rhip.mdm.service.ISchoolInfoService;

@Controller
@RequestMapping(value = "/ep/iodineNutrition/monitor")
public class IodineNutritionMonitorController extends BaseController {
	
	@Resource
	private ISchoolInfoService schoolInfoService;
	
	@Resource
	private IOrganizationApp organizationApp;
	
	@Resource
	private IIodineNutritionMonitorService iodineNutritionMonitorService;
	
	@Resource
	private IIodineNutritionService iodineNutritionService;
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request, ModelMap model) {
		List<IodineNutritionSampling> samplingList = getCurrentYearSampling(request, null);
		model.addAttribute("samplingList", samplingList);
		model.addAttribute("type", getType(samplingList));
		return "rhip.ep.iodineNutrition.monitorSearch";
	}
	
	private String getType(List<IodineNutritionSampling> samplingList) {
		Set<String> typeSet = new HashSet<String>();
		for (IodineNutritionSampling sampling : samplingList) {
			typeSet.add(sampling.getType());
		}
		return (typeSet.size() == 1 ? typeSet.iterator().next() : "3");
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, ModelMap model, int indexPage, IodineNutritionQueryForm form) {
		Page page = super.getPage(request, indexPage); 
		Criteria criteria = form.toCriteria();
		if (hasRole(RoleType.ZXDFB, request)) {
			Organization organ = getCurrentOrg(request);
			criteria.add("createOrgan", organ.getOrganCode());
		}
		criteria.add("deleteFlag", EHRConstants.DELETE_FLG_0);
		PageList<IodineNutritionMonitor> pageList = iodineNutritionMonitorService.getPageList(page, criteria);
		model.addAttribute("monitorList", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		model.addAttribute("indexPage", indexPage);
		return "rhip.ep.iodineNutrition.monitorList";
	}
	
	@RequestMapping("/view")
	public String view(HttpServletRequest request, ModelMap model, Long id) {
		IodineNutritionMonitor monitor = iodineNutritionMonitorService.getDetail(id);
		Assert.notNull(monitor, "监测记录ID("+id+")找不到");
		model.addAttribute("samplingList", getCurrentYearSampling(request, null));
		model.addAttribute("monitor", monitor);
		if ("1".equals(monitor.getCrowd())) {
			return "rhip.ep.iodineNutrition.monitorInfoChildren";
		} else {
			return "rhip.ep.iodineNutrition.monitorInfoWomen";
		}
	}
	
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, ModelMap model, IodineNutritionMonitor monitor) {
		Long id = monitor.getId();
		if (ObjectUtil.isNotEmpty(id)) {
			monitor = iodineNutritionMonitorService.getDetail(id);
			Assert.notNull(monitor, "监测记录ID("+id+")找不到");
		} else {
			if (StringUtil.isNullOrEmpty(monitor.getInvestigator())) {
				User user = this.getCurrentUser(request);
				monitor.setInvestigator(user.getName());
			}
			if (StringUtil.isNullOrEmpty(monitor.getInvestigateUnit())) {
				Organization organization=this.getCurrentOrg(request);
				monitor.setInvestigateUnit(organization.getOrganName());
			}
			if (ObjectUtil.isNullOrEmpty(monitor.getInvestigateTime())) {
				monitor.setInvestigateTime(new Date());
			}
			if (IodineNutritionMonitor.CROWD_WORMEN.equals(monitor.getCrowd())) {
				monitor.setGender("2");//女
			}
		}

		model.addAttribute("monitor", monitor);

		if (hasRole(RoleType.ADMIN, request)) {
			model.addAttribute("role", "1");
		} else {
			model.addAttribute("role", "0");
		}
		if (IodineNutritionMonitor.CROWD_CHILDREN.equals(monitor.getCrowd())) {
			model.addAttribute("samplingList", getCurrentYearSampling(request, IodineNutritionSampling.TYPE_SCHOOL));
			return "rhip.ep.iodineNutrition.monitorInfoEditChildren";
		} else {
			model.addAttribute("samplingList", getCurrentYearSampling(request, IodineNutritionSampling.TYPE_TOWN));
			return "rhip.ep.iodineNutrition.monitorInfoEditWomen";
		}
	}
	
	@RequestMapping("/changeSimpling")
	@ResponseBody
	public ModelMap changeSimpling(Long samplingId) {
		ModelMap model = new ModelMap();
		if (samplingId == null) {
			model.addAttribute("success", false);
			model.addAttribute("message", "查询ID为空");
			return model;
		}
		
		try {
			IodineNutritionSampling sampling = iodineNutritionService.getDetail(samplingId);
			model.addAttribute("success", true);
			String type = sampling.getType();
			if (IodineNutritionSampling.TYPE_TOWN.equals(type)) {
				model.addAttribute("townCode", sampling.getCode());
			} else if (IodineNutritionSampling.TYPE_SCHOOL.equals(type)) {
				String schoolCode = sampling.getCode();
				SchoolInfo schoolInfo = schoolInfoService.getSchool(schoolCode);
				if ("_other".equals(schoolInfo.getOrganTown())) {
					Organization organ = organizationApp.queryOrgan(schoolInfo.getExamOrgan());
					model.addAttribute("townCode", organ.getGbCode());
				} else {
					model.addAttribute("townCode", schoolInfo.getOrganTown());
				}
				model.addAttribute("schoolName", sampling.getName());
			}
		} catch (Exception e) {
			logger.error("查询出错", e);
			model.addAttribute("success", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public ModelMap save(HttpServletRequest request, IodineNutritionMonitor monitor) {
		ModelMap model = new ModelMap();
		setMonitorValue(request, monitor);
		try {
			String surveyNo = monitor.getSurveyNo();
			Long id = monitor.getId();
			if (ObjectUtil.isNullOrEmpty(id)) {
				IodineNutritionMonitor dbMonitor = iodineNutritionMonitorService.getCurrentYearDetailBySurveyNo(surveyNo);
				if (dbMonitor != null) {
					model.addAttribute("success", false);
					model.addAttribute("message", "相同编号("+surveyNo+")的监测记录已经存在");
					return model;
				}
			}
			iodineNutritionMonitorService.save(monitor);
			model.addAttribute("success", true);
			model.addAttribute("message", "保存成功");
			if (monitor.getId() == null) {
				createOperationLog(request, RhipModuleName.EP, "地方病碘营养监测记录保存", OperationName.ADD);
			} else {
				createOperationLog(request, RhipModuleName.EP, "地方病碘营养监测记录保存", OperationName.UPDATE);
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
		//IodineNutritionMonitor monitor = iodineNutritionMonitorService.getDetail(id);
		//setMonitorValue(request, monitor);
		//monitor.setDeleteFlag(EHRConstants.DELETE_FLG_1);
		try {
			iodineNutritionMonitorService.delete(id);
			model.addAttribute("success", true);
			model.addAttribute("message", "删除成功");
			createOperationLog(request, RhipModuleName.EP, "地方病碘营养监测记录删除", OperationName.DELETE);
		} catch (Exception e) {
			logger.error("删除出错", e);
			model.addAttribute("success", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	private void setMonitorValue(HttpServletRequest request, IodineNutritionMonitor monitor) {
		Date now  = new Date();
		Long id = monitor.getId();
		User user = this.getCurrentUser(request);
		Organization organization=this.getCurrentOrg(request);
		if (ObjectUtil.isNullOrEmpty(id)) {
			monitor.setCreatePerson(user.getUserName());
			monitor.setCreateOrgan(organization.getOrganCode());
			monitor.setCreateTime(now);
			monitor.setDeleteFlag(EHRConstants.DELETE_FLG_0);
		} else {
			monitor.setUpdatePerson(user.getUserName());
			monitor.setUpdateOrgan(organization.getOrganCode());
			monitor.setUpdateTime(now);
		}
	}
	
	private List<IodineNutritionSampling> getCurrentYearSampling(HttpServletRequest request, String type) {
		List<IodineNutritionSampling> list;
		if (hasRole(RoleType.ZXDFB, request)) {
			Organization organ = getCurrentOrg(request);
			String townCode = organ.getGbCode();
			list = iodineNutritionService.getCurrentYearSampling(townCode, type);
		} else {
			list = iodineNutritionService.getCurrentYearSampling(null, type);
		}
		return list;
	}
	
	/*
	private String formatSurveyNo(IodineNutritionMonitor monitor) {
		Long simpleId = monitor.getSamplingId();
		IodineNutritionSampling sampling = iodineNutritionService.getDetail(simpleId);
		String samplingNo = sampling.getSamplingNo();
		Long maxMonitorId = iodineNutritionMonitorService.getMaxMonitorId(simpleId);
		return samplingNo + "_" + (maxMonitorId + 1);
	}
	 */
}
