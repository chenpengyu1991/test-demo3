package com.founder.rhip.dmbc.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.dmbc.controller.form.MedicalInstQueryForm;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.OHConstants;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcDisinfectionMonitor;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcDisinfectionResult;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcInfectDetail;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcInfectMonitor;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcSewageTreatment;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcTreatmentRecord;
import com.founder.rhip.ph.service.dmbc.IMedicalInstService;
import net.sf.cglib.beans.BeanMap;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 医疗机构管理
 *
 * @author mei_xingjian Vertor controller
 */
@Controller
@RequestMapping("/dmbc/medicalInst")
public class MedicalInstController extends BaseController {

	@Resource(name = "dmbcMedicalInstService")
	private IMedicalInstService medicalInstService;

	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, "treatmentDate",
				new CustomDateEditor(new SimpleDateFormat(
						EHRConstants.SPEC_DATE_PATTERN), true));
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat(EHRConstants.COMMON_DATE_PATTERN), true));
	}

	// 污水处理监测begin
	@RequestMapping("/sewageTreatment")
	public String sewageTreatmentIndex(HttpServletRequest request, Model model) {
		if (hasRole(RoleType.Z_GLY, request) || hasRole(RoleType.ZX_GLY, request)) {
			model.addAttribute("currentOrg", getCurrentOrg(request));
		}
		return "rhip.dmbc.medicalInst.sewage.treatment.search";
	}

	@RequestMapping(value = "/sewageTreatment/list")
	public String searchSewageTreatment(MedicalInstQueryForm form,
	                                    HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.medicalInst.sewage.treatment.list";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = null;
		ca = form.getCriteria();
		if (hasRole(RoleType.Z_GLY, request) || hasRole(RoleType.ZX_GLY, request)) {
			User user = getCurrentUser(request);
			ca.add("createBy", user.getUserName());
		}
		PageList<DmbcSewageTreatment> plist = medicalInstService
				.searchSewageTreatment(ca, page);
		model.addAttribute("sewageTreatmentList", plist);
		model.addAttribute("page", plist.getPage());
		return url;
	}

	@RequestMapping(value = "/initSewageTreatmentAdd")
	public String initSewageTreatmentAdd(HttpServletRequest request,
	                                     ModelMap model) {
		String url = "rhip.dmbc.medicalInst.sewage.treatment.add";
		model.put("type", OHConstants.add);
		model.put("currentOrg", getCurrentOrg(request));
		model.put("displayList", "display:none");
		return url;
	}

	@RequestMapping(value = "/saveSewageTreatment")
	public String saveSewageTreatment(DmbcSewageTreatment sewageTreatment,
	                                  String type, HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.medicalInst.sewage.treatment.add";
		Map<String, String> fileMap = (Map<String, String>) request
				.getSession().getAttribute("dmbcSewageTreatment_fileMap"); // 附件
		// 附件
		if (ObjectUtil.isNotEmpty(fileMap)) {
			if (fileMap.size() > 1) {
				model.addAttribute("result", false);
				model.addAttribute("message", "只能保存一个附件!");
				model.put("sewageTreatment", sewageTreatment);
				model.put("type", type);
				request.getSession().removeAttribute("dmbcSewageTreatment_fileMap");
				return url;
			}

			for (String urlKey : fileMap.keySet()) {
				sewageTreatment.setPicUrl(fileMap.get(urlKey));
			}
		}

		if (OHConstants.add.equals(type)) {
			sewageTreatment.setCreateBy(getCurrentUser(request).getUserName());
			sewageTreatment.setCreateTime(new Date());
		}
		sewageTreatment.setUpdateBy(getCurrentUser(request).getUserName());
		sewageTreatment.setUpdateTime(new Date());
		Boolean rs = medicalInstService.saveSewageTreatment(sewageTreatment,
				type);
		if (rs) {
			if (OHConstants.edit.equals(type)) {
				addTreatment(request, model, sewageTreatment.getId());
				createOperationLog(request, RhipModuleName.DMBC,
						"医疗机构监测-污水处理监测", OperationName.UPDATE);
			} else if (OHConstants.add.equals(type)) {
				createOperationLog(request, RhipModuleName.DMBC,
						"医疗机构监测-污水处理监测", OperationName.ADD);
			}
			model.put("type", OHConstants.edit);
		} else {
			model.put("type", OHConstants.add);
		}
		model.put("msg", rs);
		model.put("sewageTreatment", sewageTreatment);
		model.put("currentOrg", getCurrentOrg(request));
		request.getSession().removeAttribute("dmbcSewageTreatment_fileMap");
		return url;
	}

	@RequestMapping("/delSewageTreatment")
	@ResponseBody
	public ModelMap delSewageTreatment(Long id, HttpServletRequest request) {
		DmbcSewageTreatment sewageTreatment = new DmbcSewageTreatment();
		sewageTreatment.setUpdateBy(getCurrentUser(request).getUserName());
		sewageTreatment.setUpdateTime(new Date());
		sewageTreatment.setId(id);
		Boolean rs = medicalInstService.saveSewageTreatment(sewageTreatment,
				OHConstants.del);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "删除成功");
			createOperationLog(request, RhipModuleName.DMBC, "医疗机构监测-污水处理监测",
					OperationName.DELETE);

		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "删除失败");
		}
		return model;
	}

	@RequestMapping(value = "/initSewageTreatmentViewModify/{monitorId}")
	public String initSewageTreatmentViewModify(
			@PathVariable("monitorId") Long monitorId, String type,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.medicalInst.sewage.treatment.add";
		DmbcSewageTreatment sewageTreatment = medicalInstService
				.searchSewageTreatment(monitorId);
		addTreatment(request, model, monitorId);
		model.addAttribute("sewageTreatment", sewageTreatment);
		model.put("type", type);
		request.getSession().removeAttribute("dmbcSewageTreatment_fileMap");
		model.put("currentOrg", getCurrentOrg(request));
		return url;
	}

	private void addTreatment(HttpServletRequest request, ModelMap model,
	                          Long monitorId) {
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = new Criteria();
		ca.add("sewage_treatment_id", monitorId);
		ca.add("is_delete", OHConstants.delete_0);
		PageList<DmbcTreatmentRecord> treatmentList = medicalInstService
				.searchTreatmentRecord(page, ca);
		model.addAttribute("treatmentList", treatmentList);
		model.addAttribute("page", treatmentList.getPage());
	}

	@RequestMapping(value = "/treatmentList/{sewageTreatmentId}")
	public String treatmentList(
			@PathVariable("sewageTreatmentId") Long sewageTreatmentId,
			String type, HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.medicalInst.treatment.list";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = new Criteria();
		ca.add("sewage_treatment_id", sewageTreatmentId);
		ca.add("is_delete", OHConstants.delete_0);
		PageList<DmbcTreatmentRecord> treatmentList = medicalInstService
				.searchTreatmentRecord(page, ca);
		model.addAttribute("treatmentList", treatmentList);
		model.addAttribute("page", treatmentList.getPage());
		model.addAttribute("type", type);
		return url;
	}

	@RequestMapping(value = "/initTreatmentAdd/{monitorId}")
	public String initTreatmentAdd(@PathVariable("monitorId") Long monitorId,
	                               Long id, HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.medicalInst.treatment.add";
		DmbcTreatmentRecord treatment = null;
		if (id == null) {
			treatment = new DmbcTreatmentRecord();
			treatment.setSewageTreatmentId(monitorId);
			model.put("type", OHConstants.add);
		} else {
			treatment = medicalInstService.searchTreatmentRecord(id);
			model.put("type", OHConstants.edit);
		}
		model.addAttribute("treatment", treatment);
		return url;
	}

	@RequestMapping("/saveTreatment")
	@ResponseBody
	public ModelMap saveTreatment(DmbcTreatmentRecord treatment, String type,
	                              HttpServletRequest request) {
		if (OHConstants.add.equals(type)) {
			treatment.setCreateBy(getCurrentUser(request).getUserName());
			treatment.setCreateTime(new Date());
		}
		treatment.setUpdateBy(getCurrentUser(request).getUserName());
		treatment.setUpdateTime(new Date());
		Boolean rs = medicalInstService.saveTreatmentRecord(treatment, type);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "保存成功");
			if (OHConstants.edit.equals(type)) {
				createOperationLog(request, RhipModuleName.DMBC,
						"医疗机构监测-污水处理记录", OperationName.UPDATE);
			} else if (OHConstants.add.equals(type)) {
				createOperationLog(request, RhipModuleName.DMBC,
						"医疗机构监测-污水处理记录", OperationName.ADD);
			}
		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "保存失败");
		}
		return model;
	}

	@RequestMapping("/delTreatment")
	@ResponseBody
	public ModelMap delTreatment(Long id, HttpServletRequest request) {
		DmbcTreatmentRecord treatment = new DmbcTreatmentRecord();
		treatment.setUpdateBy(getCurrentUser(request).getUserName());
		treatment.setUpdateTime(new Date());
		treatment.setId(id);
		Boolean rs = medicalInstService.saveTreatmentRecord(treatment,
				OHConstants.del);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "删除成功");
			createOperationLog(request, RhipModuleName.DMBC, "医疗机构监测-污水处理记录",
					OperationName.DELETE);

		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "删除失败");
		}
		return model;
	}

	// 污水处理监测end

	// 消毒质量监测begin
	@RequestMapping("/disinfectionMonitor")
	public String disinfectionMonitorIndex(HttpServletRequest request,
	                                       Model model) {
		if (hasRole(RoleType.Z_GLY, request) || hasRole(RoleType.ZX_GLY, request)) {
			model.addAttribute("currentOrg", getCurrentOrg(request));
		}
		return "rhip.dmbc.medicalInst.disinfection.monitor.search";
	}

	@RequestMapping(value = "/disinfectionMonitor/list")
	public String searchDisinfectionMonitor(MedicalInstQueryForm form,
	                                        HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.medicalInst.disinfection.monitor.list";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = null;
		ca = form.getCriteria();
		if (hasRole(RoleType.Z_GLY, request) || hasRole(RoleType.ZX_GLY, request)) {
			User user = getCurrentUser(request);
			ca.add("createBy", user.getUserName());
		}
		PageList<DmbcDisinfectionMonitor> plist = medicalInstService
				.searchDisinfectionMonitor(ca, page);
		model.addAttribute("disinfectionMonitorList", plist);
		model.addAttribute("page", plist.getPage());
		return url;
	}

	@RequestMapping(value = "/initDisinfectionMonitorAdd")
	public String initDisinfectionMonitorAdd(HttpServletRequest request,
	                                         ModelMap model) {
		String url = "rhip.dmbc.medicalInst.disinfection.monitor.add";
		model.put("type", OHConstants.add);
		model.put("currentOrg", getCurrentOrg(request));
		model.put("displayList", "display:none");
		return url;
	}

	@RequestMapping(value = "/saveDisinfectionMonitor")
	public String saveDisinfectionMonitor(
			DmbcDisinfectionMonitor disinfectionMonitor, String type,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.medicalInst.disinfection.monitor.add";
		if (OHConstants.add.equals(type)) {
			disinfectionMonitor.setCreateBy(getCurrentUser(request)
					.getUserName());
			disinfectionMonitor.setCreateTime(new Date());
		}
		disinfectionMonitor.setUpdateBy(getCurrentUser(request).getUserName());
		disinfectionMonitor.setUpdateTime(new Date());
		Boolean rs = medicalInstService.saveDisinfectionMonitor(
				disinfectionMonitor, type);
		if (rs) {
			if (OHConstants.edit.equals(type)) {
				addDisinfectionRs(request, model, disinfectionMonitor.getId());
				createOperationLog(request, RhipModuleName.DMBC,
						"医疗机构监测-消毒质量监测", OperationName.UPDATE);
			} else if (OHConstants.add.equals(type)) {
				createOperationLog(request, RhipModuleName.DMBC,
						"医疗机构监测-消毒质量监测", OperationName.ADD);
			}
			model.put("type", OHConstants.edit);
		} else {
			model.put("type", OHConstants.add);
		}
		model.put("msg", rs);
		model.put("disinfectionMonitor", disinfectionMonitor);
		model.put("currentOrg", getCurrentOrg(request));
		return url;
	}

	@RequestMapping("/delDisinfectionMonitor")
	@ResponseBody
	public ModelMap delDisinfectionMonitor(Long id, HttpServletRequest request) {
		DmbcDisinfectionMonitor disinfectionMonitor = new DmbcDisinfectionMonitor();
		disinfectionMonitor.setUpdateBy(getCurrentUser(request).getUserName());
		disinfectionMonitor.setUpdateTime(new Date());
		disinfectionMonitor.setId(id);
		Boolean rs = medicalInstService.saveDisinfectionMonitor(
				disinfectionMonitor, OHConstants.del);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "删除成功");
			createOperationLog(request, RhipModuleName.DMBC, "医疗机构监测-消毒质量监测",
					OperationName.DELETE);

		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "删除失败");
		}
		return model;
	}

	@RequestMapping(value = "/initDisinfectionMonitorViewModify/{monitorId}")
	public String initDisinfectionMonitorViewModify(
			@PathVariable("monitorId") Long monitorId, String type,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.medicalInst.disinfection.monitor.add";
		DmbcDisinfectionMonitor disinfectionMonitor = medicalInstService
				.searchDisinfectionMonitor(monitorId);
		addDisinfectionRs(request, model, monitorId);
		model.addAttribute("disinfectionMonitor", disinfectionMonitor);
		model.put("type", type);
		model.put("currentOrg", getCurrentOrg(request));
		return url;
	}

	private void addDisinfectionRs(HttpServletRequest request, ModelMap model,
	                               Long monitorId) {
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = new Criteria();
		ca.add("monitor_id", monitorId);
		ca.add("is_delete", OHConstants.delete_0);
		PageList<DmbcDisinfectionResult> disinfectionRsList = medicalInstService
				.searchDisinfectionResult(ca, page);
		model.addAttribute("disinfectionRsList", disinfectionRsList);
		model.addAttribute("page", disinfectionRsList.getPage());
	}

	@RequestMapping(value = "/disinfectionRsList/{disinfectionMonitorId}")
	public String disinfectionRsList(
			@PathVariable("disinfectionMonitorId") Long disinfectionMonitorId,
			String type, HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.medicalInst.disinfection.rs.list";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = new Criteria();
		ca.add("monitor_id", disinfectionMonitorId);
		ca.add("is_delete", OHConstants.delete_0);
		PageList<DmbcDisinfectionResult> disinfectionRsList = medicalInstService
				.searchDisinfectionResult(ca, page);
		model.addAttribute("disinfectionRsList", disinfectionRsList);
		model.addAttribute("page", disinfectionRsList.getPage());
		model.addAttribute("type", type);
		return url;
	}

	@RequestMapping(value = "/initDisinfectionRsAdd/{monitorId}")
	public String initDisinfectionRsAdd(
			@PathVariable("monitorId") Long monitorId, Long id,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.medicalInst.disinfection.rs.add";
		DmbcDisinfectionResult disinfectionRs = null;
		if (id == null) {
			disinfectionRs = new DmbcDisinfectionResult();
			disinfectionRs.setMonitorId(monitorId);
			model.put("type", OHConstants.add);
		} else {
			disinfectionRs = medicalInstService.searchDisinfectionResult(id);
			model.put("type", OHConstants.edit);
		}
		model.addAttribute("disinfectionRs", disinfectionRs);
		return url;
	}

	@RequestMapping("/saveDisinfectionRs")
	@ResponseBody
	public ModelMap saveDisinfectionRs(DmbcDisinfectionResult disinfectionRs,
	                                   String type, HttpServletRequest request) {
		if (OHConstants.add.equals(type)) {
			disinfectionRs.setCreateBy(getCurrentUser(request).getUserName());
			disinfectionRs.setCreateTime(new Date());
		}
		disinfectionRs.setUpdateBy(getCurrentUser(request).getUserName());
		disinfectionRs.setUpdateTime(new Date());
		Boolean rs = medicalInstService.saveDisinfectionResult(disinfectionRs,
				type);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "保存成功");
			if (OHConstants.edit.equals(type)) {
				createOperationLog(request, RhipModuleName.DMBC,
						"医疗机构监测-消毒监测结果", OperationName.UPDATE);
			} else if (OHConstants.add.equals(type)) {
				createOperationLog(request, RhipModuleName.DMBC,
						"医疗机构监测-消毒监测结果", OperationName.ADD);
			}
		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "保存失败");
		}
		return model;
	}

	@RequestMapping("/delDisinfectionRs")
	@ResponseBody
	public ModelMap delDisinfectionRs(Long id, HttpServletRequest request) {
		DmbcDisinfectionResult disinfectionRs = new DmbcDisinfectionResult();
		disinfectionRs.setUpdateBy(getCurrentUser(request).getUserName());
		disinfectionRs.setUpdateTime(new Date());
		disinfectionRs.setId(id);
		Boolean rs = medicalInstService.saveDisinfectionResult(disinfectionRs,
				OHConstants.del);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "删除成功");
			createOperationLog(request, RhipModuleName.DMBC, "医疗机构监测-消毒监测结果",
					OperationName.DELETE);

		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "删除失败");
		}
		return model;
	}
	// 消毒质量监测end

	//院感监测begin
	@RequestMapping("/infectMonitor")
	public String infectMonitorIndex(HttpServletRequest request, ModelMap model) {
		if (hasRole(RoleType.Z_GLY, request) || hasRole(RoleType.ZX_GLY, request)) {
			model.addAttribute("currentOrg", getCurrentOrg(request));
		}
		return "rhip.dmbc.medicalInst.infectMonitor.search";
	}

	@RequestMapping("/infectMonitor/list")
	public String searchInfectMonitor(HttpServletRequest request, ModelMap modelMap, int indexPage, MedicalInstQueryForm form) {
		Page page = super.getPage(request, indexPage);
		Criteria criteria = form.getCriteria();
		if (hasRole(RoleType.Z_GLY, request) || hasRole(RoleType.ZX_GLY, request)) {
			User user = getCurrentUser(request);
			criteria.add("createBy", user.getUserName());
		}
		PageList<DmbcInfectMonitor> pageList = medicalInstService.searchInfectMonitor(page, criteria);
		modelMap.addAttribute("infectMonitorList", pageList.getList());
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("indexPage", indexPage);
		return "rhip.dmbc.medicalInst.infectMonitor.list";
	}

	@RequestMapping("/infectMonitor/edit")
	public String editInfectMonitor(HttpServletRequest request, ModelMap modelMap, Long id, String operation) {
		if (id != null) {
			DmbcInfectMonitor monitor = medicalInstService.getInfectMonitor(new Criteria("id", id));
			modelMap.addAttribute("monitor", monitor);
		}
		modelMap.addAttribute("operation", operation);
		modelMap.addAttribute("currentOrg", getCurrentOrg(request));
		return "rhip.dmbc.medicalInst.infectMonitor.edit";
	}

	@RequestMapping("/infectMonitor/save")
	@ResponseBody
	public ModelMap saveInfectMonitor(HttpServletRequest request, DmbcInfectMonitor monitor) {
		ModelMap modelMap = new ModelMap();
		beforeSave(request, monitor);
		try {
			boolean result = medicalInstService.saveInfectMonitor(monitor);
			modelMap.addAttribute("success", result);
			if (result) {
				modelMap.addAttribute("message", "保存成功！");
				modelMap.addAttribute("monitor", monitor);
			} else {
				modelMap.addAttribute("message", "保存失败！");
			}
		} catch (Exception e) {
			modelMap.addAttribute("success", false);
			modelMap.addAttribute("message", "保存失败！" + e.getMessage());
		}
		return modelMap;
	}

	@RequestMapping("/infectMonitor/delete")
	@ResponseBody
	public ModelMap deleteInfectMonitor(HttpServletRequest request, Long id) {
		ModelMap modelMap = new ModelMap();
		DmbcInfectMonitor monitor = new DmbcInfectMonitor();
		monitor.setId(id);
		beforeSave(request, monitor);
		try {
			boolean result = medicalInstService.deleteInfectMonitor(monitor);
			modelMap.addAttribute("success", result);
			if (result) {
				modelMap.addAttribute("message", "删除成功！");
			} else {
				modelMap.addAttribute("message", "删除失败！");
			}
		} catch (Exception e) {
			modelMap.addAttribute("success", false);
			modelMap.addAttribute("message", "删除失败！" + e.getMessage());
		}
		return modelMap;
	}

	@RequestMapping("/infectDetail/list")
	public String searchInfectDetail(HttpServletRequest request, ModelMap modelMap, int idxPage, Long monitorId, String operation) {
		Page page = super.getPage(request, idxPage);
		PageList<DmbcInfectDetail> pageList = medicalInstService.searchInfectDetail(page, new Criteria("monitorId", monitorId).add("isDelete", EHRConstants.DELETE_FLG_0));
		modelMap.addAttribute("detailList", pageList.getList());
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("idxPage", idxPage);
		modelMap.addAttribute("operation", operation);
		if (monitorId == null) {
			modelMap.addAttribute("displayDetailList", "display:none");
		} else {
			modelMap.addAttribute("displayDetailList", "");
		}
		return "rhip.dmbc.medicalInst.infectDetail.list";
	}

	@RequestMapping("/infectDetail/edit")
	public String editInfectDetail(ModelMap modelMap, Long id, Long monitorId, String operation) {
		DmbcInfectDetail detail = null;
		if (id != null) {
			detail = medicalInstService.getInfectDetail(new Criteria("id", id));
		}
		if (detail == null) {
			detail = new DmbcInfectDetail();
			detail.setMonitorId(monitorId);
		}
		modelMap.addAttribute("detail", detail);
		modelMap.addAttribute("operation", operation);
		return "rhip.dmbc.medicalInst.infectDetail.edit";
	}

	@RequestMapping("/infectDetail/save")
	@ResponseBody
	public ModelMap saveInfectDetail(HttpServletRequest request, DmbcInfectDetail detail) {
		ModelMap modelMap = new ModelMap();
		beforeSave(request, detail);
		try {
			Boolean result = medicalInstService.saveInfectDetail(detail);
			modelMap.addAttribute("success", result);
			if (result) {
				modelMap.addAttribute("message", "保存成功！");
			} else {
				modelMap.addAttribute("message", "保存失败！");
			}
		} catch (Exception e) {
			modelMap.addAttribute("success", false);
			modelMap.addAttribute("message", "保存失败！");
		}
		return modelMap;
	}

	@RequestMapping("/infectDetail/delete")
	@ResponseBody
	public ModelMap deleteInfectDetail(HttpServletRequest request, Long id, Long monitorId) {
		ModelMap modelMap = new ModelMap();
		DmbcInfectDetail detail = new DmbcInfectDetail();
		detail.setId(id);
		detail.setMonitorId(monitorId);
		beforeSave(request, detail);
		try {
			boolean result = medicalInstService.deleteInfectDetail(detail);
			modelMap.addAttribute("success", result);
			if (result) {
				modelMap.addAttribute("message", "删除成功！");
			} else {
				modelMap.addAttribute("message", "删除失败！");
			}
		} catch (Exception e) {
			modelMap.addAttribute("success", false);
			modelMap.addAttribute("message", "删除失败！" + e.getMessage());
		}
		return modelMap;
	}

	private void beforeSave(HttpServletRequest request, Object entity) {
		BeanMap beanMap = BeanMap.create(entity);
		User user = getCurrentUser(request);
		Date date = new Date();
		if (beanMap.get("id") == null) {
			beanMap.put("createBy", user.getUserName());
			beanMap.put("createTime", date);
		} else {
			beanMap.put("updateBy", user.getUserName());
			beanMap.put("updateTime", date);
		}
	}
	//院感监测end
}
