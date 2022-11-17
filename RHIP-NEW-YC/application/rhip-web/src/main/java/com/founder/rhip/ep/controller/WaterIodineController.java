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
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.ep.WaterIodineMonitor;
import com.founder.rhip.ep.controller.form.WaterIodineQueryForm;
import com.founder.rhip.ep.service.IWaterIodineService;
import com.founder.rhip.mdm.entity.Organization;

@Controller
@RequestMapping(value = "/ep/waterIodine/monitor")
public class WaterIodineController extends BaseController {
	
	@Resource
	private IWaterIodineService waterIodineService;
	
	@RequestMapping("/search")
	public String search(ModelMap model) {
		return "rhip.ep.waterIodine.monitor.search";
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request,ModelMap model, int indexPage, WaterIodineQueryForm form) {
		Page page = super.getPage(request, indexPage); 
		Criteria criteria = form.toCriteria();
		criteria.add("deleteFlag", EHRConstants.DELETE_FLG_0);
		PageList<WaterIodineMonitor> pageList = waterIodineService.getPageList(page, criteria);
		model.addAttribute("monitorList", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		model.addAttribute("indexPage", indexPage);
		return "rhip.ep.waterIodine.monitor.list";
	}
	
	@RequestMapping("/view")
	public String view(ModelMap model, Long id) {
		WaterIodineMonitor monitor = waterIodineService.getDetail(id);
		Assert.notNull(monitor, "监测记录ID("+id+")找不到");
		model.addAttribute("monitor", monitor);
		return "rhip.ep.waterIodine.monitor.info";
	}
	
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, ModelMap model, WaterIodineMonitor monitor) {
		Long id = monitor.getId();
		if (ObjectUtil.isNotEmpty(id)) {
			monitor = waterIodineService.getDetail(id);
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
		}
		
		model.addAttribute("monitor", monitor);
		return "rhip.ep.waterIodine.monitor.infoEdit";
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public ModelMap save(HttpServletRequest request, WaterIodineMonitor monitor) {
		ModelMap model = new ModelMap();
		setMonitorValue(request, monitor);
		try {
			/*
			String monitorId = monitor.getMonitorId();
			Long id = monitor.getId();
			if (ObjectUtil.isNullOrEmpty(id)) {
				WaterIodineMonitor dbMonitor = waterIodineService.getDetail(new Criteria("monitorId", monitorId));
				if (dbMonitor != null) {
					model.addAttribute("success", false);
					model.addAttribute("message", "相同编号("+monitorId+")的监测记录已经存在");
					return model;
				}
			}*/
			waterIodineService.save(monitor);
			model.addAttribute("success", true);
			model.addAttribute("message", "保存成功");
			if (monitor.getId() == null) {
				createOperationLog(request, RhipModuleName.EP, "地方病水碘监测保存", OperationName.ADD);
			} else {
				createOperationLog(request, RhipModuleName.EP, "地方病水碘监测保存", OperationName.UPDATE);
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
		//WaterIodineMonitor monitor = waterIodineService.getDetail(id);
		//setMonitorValue(request, monitor);
		//monitor.setDeleteFlag(EHRConstants.DELETE_FLG_1);
		try {
			waterIodineService.delete(id);
			model.addAttribute("success", true);
			model.addAttribute("message", "删除成功");
			createOperationLog(request, RhipModuleName.EP, "地方病水碘监测删除", OperationName.DELETE);
		} catch (Exception e) {
			logger.error("删除出错", e);
			model.addAttribute("success", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	private void setMonitorValue(HttpServletRequest request, WaterIodineMonitor monitor) {
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
	
}
