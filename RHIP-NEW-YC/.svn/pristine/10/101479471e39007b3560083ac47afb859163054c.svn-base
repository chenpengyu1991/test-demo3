package com.founder.rhip.he.controller;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.ResourceCategory;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.healtheducation.HeActive;
import com.founder.rhip.ehr.entity.healtheducation.HeResourceRecord;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.he.service.IHeActiveService;
import com.founder.rhip.he.service.IHeResourceRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 健康教育活动
 * 
 * @author GaoFei
 */
@Controller
@RequestMapping(value = "/he/active")
public class HeActiveController extends VisitController {

	@Resource(name = "heActiveService")
	private IHeActiveService heActiveService;

	@Resource(name = "heResourceRecordService")
	private IHeResourceRecordService healthResourceRecordService;

	@Resource(name = "uploadInfoRecordService")
	private IUploadInfoRecordService uploadInfoRecordService;

	/**
	 * 查询健康教育活动
	 * 
	 * @return
	 */
	@RequestMapping("/search")
	public String search() {
		return "rhip.he.health.education.active.search";
	}

	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable("id") Long id, ModelMap model) {
		if (ObjectUtil.isNotEmpty(id)) {
			HeActive healthEducationActive = heActiveService.getHealthEducationActive(new Criteria("ID", id));
			HeResourceRecord healthResourceRecord = healthResourceRecordService.getHealthResourceRecord(new Criteria("ACTIVE_ID", id));
			List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", id).add("FILE_RESOURCE", ResourceCategory.HEALTH_ACTIVE.getCode()));
			for (UploadInfoRecord uploadInfoRecord : uploadInfoRecords){
				uploadInfoRecord.isImageFlag();
			}
			model.addAttribute("attches", uploadInfoRecords);
			model.addAttribute("healthEducationActive", healthEducationActive);
			model.addAttribute("healthResourceRecord", healthResourceRecord);
		}
		return "rhip.he.health.education.active.detail";
	}

	/**
	 * 标志系统类型
	 * 
	 * @param systemType
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/search/{systemType}")
	public String listByType(@PathVariable("systemType") String systemType, HttpServletRequest request, ModelMap model) {
		request.setAttribute("systemType", systemType);
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		calendar.set(year, 0, 1, 0, 0, 0);
		model.addAttribute("currentYearStartDate", calendar.getTime());
		return search();
	}

	/**
	 * 列表显示健康教育活动
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/list")
	public String list(HttpServletRequest request, ModelMap model, @RequestParam(value = "systemType", required = false) String systemType) {
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria criteria = CriteriaOrganizer.initCriteria(request.getParameterMap(), HeActive.class, "ACTIVE_TIME");

		// 不同身份查询条件
		organizeCriteria(criteria, model, request);
		if(hasRole(RoleType.QWGZX,request) && !criteria.contains("gbcode")){
			criteria.add("gbcode",getCurrentOrg(request).getGbCode());
		}
		// 如果有类型,增加类型条件
		if (ObjectUtil.isNotEmpty(systemType)) {
			criteria.add("systemType", systemType);
			model.addAttribute("systemType", systemType);
		}
//		else {
//            Criteria ca =new Criteria();
//            ca.add("systemType", OP.NE, 1).add(LOP.OR, "systemType", OP.IS, null);
//			criteria.add(ca);
//		}

		PageList<HeActive> pageList = heActiveService.findHealthEducationActive(criteria.add("STATUS", "1"), page);
		model.addAttribute("healthEducationActives", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		return "rhip.he.health.education.active.list";
	}

	/**
	 * 添加健康教育活动
	 * 
	 * @param systemType
	 * @param model
	 * @return
	 */
	@RequestMapping("/add")
	public String add(@RequestParam(value = "systemType", required = false) String systemType,Model model) {
		if (null != systemType) {
			HeActive healthEducationActive=new HeActive();
			healthEducationActive.setSystemType(systemType);
			model.addAttribute("healthEducationActive", healthEducationActive);
		}
		return "rhip.he.health.education.active.edit";
	}

	/**
	 * 保存健康教育活动
	 * 
	 * @param healthResourceRecord
	 *            健康资源记录对象
	 * @param request
	 * @param healthEducationActive
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(HeActive healthEducationActive, HeResourceRecord healthResourceRecord, HttpServletRequest request) {
		int ret = 0;
		Map<String, Object> map = new HashMap<>();
		Map<String, String> fileMap = (Map<String, String>) request.getSession().getAttribute("jjhd_fileMap"); // 附件
		Map<String, String> fileNameMap = (Map<String, String>) request.getSession().getAttribute("jjhd_filenameMap"); // 附件
		map = validateAttchement(map, fileMap, healthEducationActive.getId());
		if (ObjectUtil.isNotEmpty(map)) {
			return map;
		}
		try {
			// 新增健康教育活动
			if (ObjectUtil.isNullOrEmpty(healthEducationActive.getId())) {
                createOperationLog(request, RhipModuleName.HE, "健康教育活动", OperationName.ADD);
				initOrgCode(new ConvertingWrapDynaBean(healthEducationActive), request);
				heActiveService.createHealthEducationActive(healthEducationActive, healthResourceRecord, fileMap, fileNameMap, getCurrentUser(request).getName());
			} else { // 更新健康教育活动
                createOperationLog(request, RhipModuleName.HE, "健康教育活动", OperationName.UPDATE);
				String[] properties = new String[] { "activeType", "activeTime", "activePlace", "activeTheme", "medicalPersonQuantity", "organizer", "educationPersonType", "educationPersonQuantity",
						"activeDetail", "activeTotalEval", "otherActiveType", "otherPersonType", "industryType", "businessType", "workPlan" };
				heActiveService.updateHealthEducationActive(healthEducationActive, healthResourceRecord, fileMap, fileNameMap, getCurrentUser(request).getName(), properties);
			}
			ret = 1;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
			ret = 0;
		}
		// 保存成功清理session
		if (ret == 1 && ObjectUtil.isNotEmpty(fileMap)) {
			request.getSession().removeAttribute("jjhd_fileMap");
		}
		map.put("result", ret > 0 ? true : false);
		map.put("message", ret > 0 ? "保存成功!" : "保存失败!");

		return map;
	}

	/**
	 * 编辑健康教育活动
	 * 
	 * @param id
	 *            健康教育活动主键ID
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(Long id, ModelMap model, HttpServletRequest request) {
		// 编辑健康教育资源
		if (ObjectUtil.isNotEmpty(id)) {
			HeActive healthEducationActive = heActiveService.getHealthEducationActive(new Criteria("ID", id));
			HeResourceRecord healthResourceRecord = healthResourceRecordService.getHealthResourceRecord(new Criteria("ACTIVE_ID", healthEducationActive.getId()));
			List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", id).add("FILE_RESOURCE", ResourceCategory.HEALTH_ACTIVE.getCode()));
			model.addAttribute("attches", uploadInfoRecords);
			model.addAttribute("healthEducationActive", healthEducationActive);
			model.addAttribute("healthResourceRecord", healthResourceRecord);
		}
		return "rhip.he.health.education.active.edit";
	}

	/**
	 * 删除健康教育活动
	 * 
	 * @param id
	 *            健康教育活动主键ID
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable("id") Long id, HttpServletRequest request) {
		int ret = 0;
		try {
            createOperationLog(request, RhipModuleName.HE, "健康教育活动", OperationName.DELETE);
			heActiveService.deleteHealthEducationActive(id);
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
