package com.founder.rhip.he.controller;

import com.founder.fasf.beans.ConvertingWrapDynaBean;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.ResourceCategory;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.healtheducation.HeSupervisor;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.he.service.IHeSupervisorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 工作督查
 * 
 * @author GaoFei
 *
 */
@Controller
@RequestMapping(value = "/he/supervisor")
public class HeSupervisorController extends VisitController {
	
	@Resource(name = "heSupervisorService")
	private IHeSupervisorService heSupervisorService;
	
	@Resource(name = "uploadInfoRecordService")
	private IUploadInfoRecordService uploadInfoRecordService;
	
	/**
	 * 查询健康督查信息
	 * 
	 * @return
	 */
	@RequestMapping("/search")
	public String search() {
		return "rhip.he.health.education.supervisor.search";
	}
	
	/**
	 * 督查信息详情
	 * 
	 * @param id 主键ID
	 * @param model
	 * @return
	 */
	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable("id")Long id, ModelMap model) {
		if (ObjectUtil.isNotEmpty(id)) {
			HeSupervisor healthSupervisor = heSupervisorService.getHealthSupervisor(new Criteria("ID", id));
			List<UploadInfoRecord> uploadInfoRecords =  uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", id).add("FILE_RESOURCE", ResourceCategory.HEALTH_EDUCATION_SUPERVISOR.getCode()));
			model.addAttribute("attches", uploadInfoRecords);
			model.addAttribute("healthSupervisor", healthSupervisor);
		}
		return "rhip.he.health.education.supervisor.detail";
	}
	
	/**
	 * 列表显示健康督查信息
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/list")
	public String list(HttpServletRequest request, ModelMap model) {
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		
		Criteria criteria = CriteriaOrganizer.initCriteria(request.getParameterMap(), HeSupervisor.class, "OVERSEE_TIME");
		if(hasRole(RoleType.QWGZX,request) && !criteria.contains("gbcode")){
			criteria.add("gbcode",getCurrentOrg(request).getGbCode());
		}
		// 不同身份查询条件
		organizeCriteria(criteria, model, request);
		
		PageList<HeSupervisor> pageList = heSupervisorService.findHealthSupervisor(criteria.add("STATUS", "1"), page);
		model.addAttribute("healthSupervisors", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		
		return "rhip.he.health.education.supervisor.list";
	}
	
	/**
	 * 编辑工作督查信息
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap model) {
		if (ObjectUtil.isNotEmpty(id)) {
			HeSupervisor healthSupervisor = heSupervisorService.getHealthSupervisor(new Criteria("ID", id));
			model.addAttribute("healthSupervisor", healthSupervisor);
			List<UploadInfoRecord> uploadInfoRecords =  uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", id).add("FILE_RESOURCE", ResourceCategory.HEALTH_EDUCATION_SUPERVISOR.getCode()));
			model.addAttribute("attches", uploadInfoRecords);
		}
		return "rhip.he.health.education.supervisor.edit";
	}
	
	/**
	 * 添加工作督查信息
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	public String add() {
		return "rhip.he.health.education.supervisor.edit";
	}
	
	/**
	 * 保存工作督查信息
	 * 
	 * @param healthSupervisor 工作督查对象
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(HeSupervisor healthSupervisor, HttpServletRequest request) {
		int ret = 0;
		Map<String, Object> map = new HashMap<>();
		Map<String, String> fileMap = (Map<String, String>) request.getSession().getAttribute("jjdc_fileMap"); // 附件
		map = validateAttchement(map, fileMap, healthSupervisor.getId());
		if (ObjectUtil.isNotEmpty(map)) {
			return map;
		}

		try {
			// 新增工作督查信息
            createOperationLog(request, RhipModuleName.HE, "工作督查", OperationName.ADD);
			if (ObjectUtil.isNullOrEmpty(healthSupervisor.getId())) {
				initOrgCode(new ConvertingWrapDynaBean(healthSupervisor), request); // 初始化机构代码
				healthSupervisor.setStatus("1"); // "1"默认状态，"0"删除
				heSupervisorService.createHealthSupervisor(healthSupervisor, fileMap, getCurrentUser(request).getName());
				ret = 1;
			} else { // 更新工作督查信息
                createOperationLog(request, RhipModuleName.HE, "工作督查", OperationName.UPDATE);
				String[] properties = new String[] {"overseeTime", "participants", "overseePerson", "content"};
				heSupervisorService.updateHealthSupervisor(healthSupervisor, fileMap, getCurrentUser(request).getName(), properties);
				ret = 1;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
			ret = 0;
		}
		// 保存成功清理session
		if (ret == 1 && ObjectUtil.isNotEmpty(fileMap)) {
			request.getSession().removeAttribute("jjdc_fileMap");
		}
		map.put("result", ret > 0 ? true : false);
		map.put("message", ret > 0 ? "保存成功!" : "保存失败!");
		return map;
	}
	
	/**
	 * 删除健康工作督查
	 * 
	 * @param id 健康工作督查主键ID
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable("id") Long id, HttpServletRequest request) {
        createOperationLog(request, RhipModuleName.HE, "工作督查", OperationName.DELETE);
		int ret = heSupervisorService.deleteHealthSupervisor(id);
		Map<String, Object> map = new HashMap<>();
		map.put("result", ret > 0 ? true : false);
		map.put("message", ret > 0 ? "删除成功!" : "删除失败!");
		
		return map;
	}
}
