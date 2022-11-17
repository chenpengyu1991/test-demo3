package com.founder.rhip.dmbc.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.dmbc.controller.form.MonitorQueryForm;
import com.founder.rhip.ehr.common.OHConstants;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcChildInstMonitor;
import com.founder.rhip.ph.service.dmbc.IChildInstMonitorService;

/**
 * 托幼机构监测
 * @author mei_xingjian ChildcareInst controller
 */
@Controller
@RequestMapping("/dmbc/childcareInst")
public class ChildcareInstController extends BaseController {
	
	@Resource(name="dmbcChildInstMonitorService")
	private IChildInstMonitorService service;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request, ModelMap model) {
		return "rhip.dmbc.childcareInst.monitor.search";
	}
	
	@RequestMapping("/monitorList")
	public String monitorList(HttpServletRequest request, ModelMap model, MonitorQueryForm form, int indexPage) {
		Page page = super.getPage(request, indexPage);
		Criteria criteria = form.getCriteria();
		PageList<DmbcChildInstMonitor> plist = service.getList(criteria, page);
		model.addAttribute("monitorList", plist.getList());
		model.addAttribute("page", plist.getPage());
		model.addAttribute("indexPage", indexPage);
		return "rhip.dmbc.childcareInst.monitor.list";
	}
	
	@RequestMapping("/monitorView")
	public String monitorView(ModelMap model, Long id) {
		DmbcChildInstMonitor monitor = service.getDetail(id);
		Assert.notNull(monitor, "监测记录ID("+id+")找不到");
		model.addAttribute("monitor", monitor);
		return "rhip.dmbc.childcareInst.monitor.view";
	}
	
	@RequestMapping("/monitorEdit")
	public String monitorEdit(ModelMap model, Long id) {
		DmbcChildInstMonitor monitor =new DmbcChildInstMonitor();
		if (ObjectUtil.isNotEmpty(id)) {
			monitor = service.getDetail(id);
			Assert.notNull(monitor, "监测记录ID("+id+")找不到");
		}
		model.addAttribute("monitor", monitor);
		return "rhip.dmbc.childcareInst.monitor.infoEdit";
	}
	
	@RequestMapping("/monitorSave")
	@ResponseBody
	public ModelMap monitorEdit(HttpServletRequest request, DmbcChildInstMonitor monitor) {
		ModelMap model = new ModelMap();
		try {
			initMonitorData(request, monitor);
			service.save(monitor);
			model.addAttribute("success", true);
			model.addAttribute("message", "保存成功");
			if (monitor.getId() == null) {
				createOperationLog(request, RhipModuleName.DMBC, "托幼机构消毒监测记录保存", OperationName.ADD);
			} else {
				createOperationLog(request, RhipModuleName.DMBC, "托幼机构消毒监测记录保存", OperationName.UPDATE);
			}
		} catch (Exception e) {
			logger.error("保存出错", e);
			model.addAttribute("success", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/monitorDelete")
	@ResponseBody
	public ModelMap monitorDelete(HttpServletRequest request, Long id) {
		ModelMap model = new ModelMap();
		try {
			service.delete(id);
			model.addAttribute("success", true);
			model.addAttribute("message", "删除成功");
			createOperationLog(request, RhipModuleName.DMBC, "托幼机构消毒监测记录删除", OperationName.DELETE);
		} catch (Exception e) {
			logger.error("删除出错", e);
			model.addAttribute("success", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	private void initMonitorData(HttpServletRequest request, DmbcChildInstMonitor monitor) {
		Date now  = new Date();
		User user = this.getCurrentUser(request);
		monitor.setUpdateTime(now);
		monitor.setUpdateBy(user.getUserName());
		monitor.setIsDelete(OHConstants.delete_0);
	}

}
