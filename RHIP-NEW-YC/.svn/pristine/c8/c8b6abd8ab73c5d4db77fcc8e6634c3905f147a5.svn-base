package com.founder.rhip.portal.controller;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.portal.OrganizationLink;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.portal.service.IOrganizationLinkService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 医疗机构链接
 * 
 * @author Zhou Yang
 *
 */
@Controller
@RequestMapping(value = "/organizationLink")
public class OrganizationLinkController extends BaseController {
	@Resource(name="organizationLinkService")
	private IOrganizationLinkService organizationLinkService;
	
	@Resource(name = "uploadInfoRecordService")
	private IUploadInfoRecordService uploadInfoRecordService;
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request, ModelMap model) {
		return "rhip.lhportal.organizationLink.search";
	}

	/**
     * 机构列表
     * @param request
     * @param model
     * @return
	 */
	@RequestMapping("/list")
	public String getrecords(HttpServletRequest request, ModelMap model, Integer indexPage, OrganizationLink organizationLink) {
		int currentPage = indexPage;
		Page page = super.getPage(request, currentPage);
		Criteria criteria = initSearch(organizationLink);		
		criteria.add("IS_DELETE", "0");
		if(!hasRole(RoleType.ADMIN, request)){
			String createOrgCode = SecurityUtils.getCurrentOrganization(request).getOrganCode();
			criteria.add("CREATE_ORG_CODE", createOrgCode);
		}
		PageList<OrganizationLink> list = organizationLinkService.getList(page,criteria);
		model.addAttribute("organizationlink", list.getList());
		model.addAttribute("page", list.getPage());
		return "rhip.lhportal.organizationLink.list";
	}
	
	/**
	 * 查看页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/detail")
	public String detail(HttpServletRequest request, ModelMap model) {
		String idTemp = request.getParameter("linkId");
		OrganizationLink organizationLink =null;
		Long id = new Long(idTemp);
		if(ObjectUtil.isNotEmpty(id)) {
			organizationLink=organizationLinkService.get(id);
			List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID",id).add("FILE_RESOURCE", "lhol"));
			model.addAttribute("attches", uploadInfoRecords);
			model.addAttribute("organizationLink", organizationLink);
		}
		return "rhip.lhportal.organizationLink.detail";
	}
	
	/**
	 * 发布和不发布到门户
	 * 
	 * @param request
	 * @param model
	 * @param linkId
	 * @param operation
	 * @return
	 */
	@RequestMapping("/status")
	public String publish(HttpServletRequest request, ModelMap model, Long linkId, String operation) {
		if(ObjectUtil.isNotEmpty(linkId) && operation.trim().equals("publish")) {
			if(organizationLinkService.updateStatus(new Parameters("status", 1), new Criteria("id", linkId)) > 0)
				return EHRMessageUtil.returnMsg(model, "1");
		}
		else
			if(ObjectUtil.isNotEmpty(linkId) && operation.trim().equals("unpublish")) {
				if(organizationLinkService.updateStatus(new Parameters("status", 0), new Criteria("id", linkId)) > 0)
					return EHRMessageUtil.returnMsg(model, "1");
			}
		return EHRMessageUtil.returnMsg(model, "0");
	}
	
	/**
	 * 机构链接的新增和更新页面
	 * @param request
	 * @param operation
	 * @return
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request, ModelMap model, String operation) {
		OrganizationLink organizationLink =null;
		if(ObjectUtil.equals(operation, "2")) {
			String idTemp = request.getParameter("linkId");
			Long id = new Long(idTemp);
			organizationLink=organizationLinkService.get(id);
			List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID",id).add("FILE_RESOURCE", "lhol"));
			model.addAttribute("attches", uploadInfoRecords);
			model.addAttribute("organizationLink", organizationLink);
		}
		return "rhip.lhportal.organizationLink.add";
	}
	
	/**
	 * 机构链接的保存
	 * @param organizationLink
	 * @param request
	 * @param model
	 * @param id
	 * @param orName
	 * @param url
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(@Valid OrganizationLink organizationLink, HttpServletRequest request, ModelMap model) {
		boolean result = false;
		Map<String, Object> map =new HashMap<>();
		Map<String, String> linkMap = (Map<String, String>) request.getSession().getAttribute("lhol_fileMap");//附件
		map = validateAttchement(map, linkMap, organizationLink.getId());
		if(ObjectUtil.isNotEmpty(map)) {
			return map;
		}
		String createOrgCode = getCurrentOrg(request).getOrganCode();
		organizationLink.setCreateOrgCode(createOrgCode);
		String createUserCode = getCurrentUser(request).getUserCode();
		//新增
		if(ObjectUtil.isNullOrEmpty(organizationLink.getId())) {
			result = organizationLinkService.save(organizationLink, linkMap, createUserCode);
		}else {//更新
			result = organizationLinkService.update(organizationLink, linkMap, createUserCode);
		}
		// 保存成功清理session
		if(result && ObjectUtil.isNotEmpty(linkMap)) {
			request.getSession().removeAttribute("lhol_fileMap");
		}
		map.put("message", result ? "success" : "fail");
		return map;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public void delete(HttpServletRequest request, ModelMap model) {
		String idTemp = request.getParameter("linkId");
		Long id = new Long(idTemp);
		if(ObjectUtil.isNotEmpty(id)) {
			organizationLinkService.delete(id);
			super.createOperationLog(request,RhipModuleName.LHPORTAL,"医疗机构链接",OperationName.DELETE);
		}
	}
	
	private Criteria initSearch(OrganizationLink organizationLink) {
		Criteria criteria = new Criteria();
		if(ObjectUtil.isNullOrEmpty(organizationLink)){
			return criteria;
		}
		if(ObjectUtil.isNotEmpty(organizationLink.getOrgName()) && null != organizationLink.getOrgName())
			criteria.add("orgName", OP.LIKE, organizationLink.getOrgName());
		if(ObjectUtil.isNotEmpty(organizationLink.getStatus()) && null != organizationLink.getStatus())
			criteria.add("status", OP.EQ, organizationLink.getStatus());
		return criteria;
	}
	
	/**
	 * 验证附件数量
	 * @param map
	 * @param fileMap
	 * @param resourceId
	 * @return
	 */
	protected Map<String, Object> validateAttchement(Map<String, Object> map, Map<String, String> fileMap, Long resourceId) {
		if (map == null) {
			throw new IllegalArgumentException("map参数可以为空！");
		}
		int count = 0;
		List<UploadInfoRecord> infoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", resourceId).add("FILE_RESOURCE", "lhol"));
		if (ObjectUtil.isNotEmpty(fileMap)) {
			count += fileMap.size();
		}
		if (ObjectUtil.isNotEmpty(infoRecords)) {
			count += infoRecords.size();
		}
		if (count > 1) {
			map.put("message", "附件总数量不能大于1个！");
			map.put("result", false);
			return map;
		}
		return map;
	}
	
}
