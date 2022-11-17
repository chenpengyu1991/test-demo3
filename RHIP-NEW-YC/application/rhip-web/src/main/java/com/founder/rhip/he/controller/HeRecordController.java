package com.founder.rhip.he.controller;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.ResourceCategory;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.healtheducation.HeResourceRecord;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.he.service.IHeResourceRecordService;
import org.apache.commons.lang.StringUtils;
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
 * 健康教育宣传阵地使用、资料发放情况
 * 
 * @author GaoFei
 *
 */
@Controller
@RequestMapping(value = "/he/record")
public class HeRecordController extends VisitController {
	
	@Resource(name = "heResourceRecordService")
	private IHeResourceRecordService heResourceRecordService;
	
	@Resource(name = "uploadInfoRecordService")
	private IUploadInfoRecordService uploadInfoRecordService;
	
	/**
	 * 查询健康教育记录
	 * 
	 * @return
	 */
	@RequestMapping("/search/{type}")
	public String search(@PathVariable("type") String type, ModelMap model) {
		model.addAttribute("type", type); // type值为1或者2， 1：宣传阵地使用情况 2：健康资料发放情况
		return "rhip.he.health.education.record.search";
	}
	
	@RequestMapping("/detail/{type}")
	public String detail(@PathVariable("type")String type, Long id, ModelMap model) {
		if (ObjectUtil.isNotEmpty(id)) {
			HeResourceRecord healthResourceRecord = heResourceRecordService.getHealthResourceRecord(new Criteria("ID", id));
			List<UploadInfoRecord> uploadInfoRecords =  uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", id).add("FILE_RESOURCE", ResourceCategory.HEALTH_EDUCATION_RECORD.getCode()));
			model.addAttribute("attches", uploadInfoRecords);
			model.addAttribute("healthEducationResourceRecord", healthResourceRecord);
		}
		model.addAttribute("type", type);
		return "rhip.he.health.education.record.detail";
	}
	
	/**
	 * 列表显示健康教育记录
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/list/{type}")
	public String list(@PathVariable("type")String type, HttpServletRequest request, ModelMap model) {
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		String timeColumn = StringUtils.equals(type, "2") ? "ISSUE_TIME" : "USE_TIME";
		Criteria criteria = CriteriaOrganizer.initCriteria(request.getParameterMap(), HeResourceRecord.class, timeColumn);
		if(hasRole(RoleType.QWGZX,request) && !criteria.contains("gbcode")){
			criteria.add("gbcode",getCurrentOrg(request).getGbCode());
		}
		// 不同身份查询条件
		organizeCriteria(criteria, model, request);
		PageList<HeResourceRecord> pageList = null;
		if (StringUtils.equals(type, "1")) {
			Criteria c = CriteriaOrganizer.initCriteriaCondition(request.getParameterMap());
			if(hasRole(RoleType.QWGZX,request) && !c.contains("gbcode")){
				c.add("gbcode",getCurrentOrg(request).getGbCode());
			}
			if (criteria.contains("orgCode")) {
				c.add("orgCode", criteria.get("orgCode"));
			}
			if (criteria.contains("centerOrgCode")) {
				c.add("centerOrgCode", criteria.get("centerOrgCode"));
			}
			pageList = heResourceRecordService.findHealthPostionRecord(c, page);
		} else {
			if (!criteria.contains("orgCode")) {
				if (hasRole(RoleType.ZXJKJY, request)||hasRole(RoleType.ZX_GLY, request)) {
					criteria.add("centerOrgCode", getCurrentOrg(request).getOrganCode());
				} else if (hasRole(RoleType.ZJKJY, request)||hasRole(RoleType.Z_GLY, request)) {
					criteria.add("orgCode", getCurrentOrg(request).getOrganCode());
				}
			}
			pageList = heResourceRecordService.findHealthResourceRecord(criteria.add("ACTIVE_ID", OP.IS, null).add("RESOURCE_TYPE", type).add("STATUS", "1"), page);
		}
		model.addAttribute("healthEducationResourceRecords", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		model.addAttribute("type", type);
		
		return "rhip.he.health.education.record.list";
	}
	
	/**
	 * 添加健康教育记录
	 * 
	 * @param type
	 * @param model
	 * @return
	 */
	@RequestMapping("/add/{type}")
	public String add(@PathVariable("type")String type, ModelMap model) {
		model.addAttribute("type", type); // type值为1或者2， 1：宣传阵地使用情况 2：健康资料发放情况
		return "rhip.he.health.education.record.edit";
	}
	
	/**
	 * 保存健康教育记录
	 * 
	 * @param healthResourceRecord 健康教育对象
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(HeResourceRecord healthResourceRecord, HttpServletRequest request) {
		int ret = 0;
		Map<String, Object> map = new HashMap<>();
		Map<String, String> fileMap = (Map<String, String>) request.getSession().getAttribute("jjdj_fileMap"); // 附件
		Map<String, String> filenameMap = (Map<String, String>) request.getSession().getAttribute("jjdj_filenameMap"); // 附件名字
		map = validateAttchement(map, fileMap, healthResourceRecord.getId());
		if (ObjectUtil.isNotEmpty(map)) {
			return map;
		}
		try {
			// 新增健康教育记录
			if (ObjectUtil.isNullOrEmpty(healthResourceRecord.getId())) {
                createOperationLog(request, RhipModuleName.HE, "宣传阵地使用、资料发放情况", OperationName.ADD);
				healthResourceRecord.setStatus("1"); // "1"默认状态，"0"删除
				initOrgCode(new ConvertingWrapDynaBean(healthResourceRecord), request);
				heResourceRecordService.createHealthResourceRecord(healthResourceRecord, fileMap,filenameMap,getCurrentUser(request).getName());
				ret = 1;
			} else {
                createOperationLog(request, RhipModuleName.HE, "宣传阵地使用、资料发放情况", OperationName.ADD);
				String[] properties = new String[] {"constructTime", "useTime", "positionType", "place", "pageQuantity", "frequency", "period", "content", 
						"materialType", "materialName", "issueQuantity", "issuer", "receiver", "issueTime", "otherMaterialType", "contentType","otherContentType"};
				heResourceRecordService.updateHealthResourceRecord(healthResourceRecord, fileMap, filenameMap,getCurrentUser(request).getName(), properties);
				ret = 1;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
			ret = 0;
		}
		
		// 保存成功清理session
		if (ret == 1 && ObjectUtil.isNotEmpty(fileMap)) {
			request.getSession().removeAttribute("jjdj_fileMap");
			request.getSession().removeAttribute("jjdj_filenameMap");
		}
		
		map.put("result", ret > 0 ? true : false);
		map.put("message", ret > 0 ? "保存成功!" : "保存失败!");
		return map;
	}
	
	/**
	 * 编辑健康教育记录
	 * 
	 * @param id 健康教育记录主键ID
	 * @param type
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit/{type}")
	public String edit(@PathVariable("type")String type, Long id, ModelMap model) {
		// 编辑健康教育资源
		if (ObjectUtil.isNotEmpty(id)) {
			HeResourceRecord healthResourceRecord = heResourceRecordService.getHealthResourceRecord(new Criteria("ID", id));
			model.addAttribute("healthEducationResourceRecord", healthResourceRecord);
			List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", id).add("FILE_RESOURCE", ResourceCategory.HEALTH_EDUCATION_RECORD.getCode()));
			model.addAttribute("attches", uploadInfoRecords);
		}
		model.addAttribute("type", type);
		return "rhip.he.health.education.record.edit";
	}
	
	/**
	 * 删除健康教育记录
	 * 
	 * @param id 健康教育记录主键ID
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable("id") Long id, HttpServletRequest request) {
		int ret = 0;
		try {
            createOperationLog(request, RhipModuleName.HE, "宣传阵地使用、资料发放情况", OperationName.DELETE);
			heResourceRecordService.deleteHealthResourceRecord(id);
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
