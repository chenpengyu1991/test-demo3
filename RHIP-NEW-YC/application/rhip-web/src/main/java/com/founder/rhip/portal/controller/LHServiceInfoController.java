package com.founder.rhip.portal.controller;

import com.founder.elb.entity.Role;
import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.portal.InfoType;
import com.founder.rhip.ehr.entity.portal.ServiceInfo;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.portal.service.IInfoTypeService;
import com.founder.rhip.portal.service.IServiceInfoService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务信息管理
 * @author Zhou Yang
 *
 */
@Controller
@RequestMapping(value="/lhserviceInfo")
public class LHServiceInfoController extends BaseController {
	@Resource(name="lhserviceInfoService")
	private IServiceInfoService serviceInfoService;
	
	@Resource(name="lhinfoTypeService")
	private IInfoTypeService infoTypeService;
	
	@Resource(name = "uploadInfoRecordService")
	private IUploadInfoRecordService uploadInfoRecordService;
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request, ModelMap model) {
		List<InfoType> infoTypeParentList = infoTypeService.getList(new Criteria("parentCode", OP.IS, null));
		model.addAttribute("infoTypeParentList", infoTypeParentList);
		return "rhip.lhportal.serviceInfo.search";
	}
	
	/**
	 * 服务信息的类别和子类别条件的选择
	 * 
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/infoTypeChildren")
	@ResponseBody
	public Map<String, Object> infoTypeChildren(String id, HttpServletRequest request, ModelMap model) {
		Map<String, Object> map = new HashMap<>();
		if(StringUtil.isNotEmpty(id)) {
			Long idTemp = new Long(id);
			Criteria criteria = new Criteria("parentCode", idTemp);
			List<InfoType> infoTypeParentList = infoTypeService.getList(criteria);
			map.put("infoTypeChildren", infoTypeParentList);
			map.put("success", true);
		}
		return map;
	}
	
	/**
	 * 服务信息管理列表
	 * 
	 * @param request
	 * @param model
	 * @param indexPage
	 * @param serviceInfo
	 * @return
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, ModelMap model, Integer indexPage, ServiceInfo serviceInfo) {
		int currentPage = indexPage;
		Page page = super.getPage(request, currentPage);
		Criteria criteria=new Criteria();
		criteria = initsearchCondition(serviceInfo);
		if (!hasRole(RoleType.ADMIN, request)){
			String organCode = SecurityUtils.getCurrentOrganization(request).getOrganCode();
			criteria.add("CREATE_ORG_CODE",organCode);
		}
		PageList<ServiceInfo> list = serviceInfoService.getList(page, criteria);		
		if(null != list && list.getList().size() > 0) {
			for(int i = 0; i < list.getList().size(); i++) {
				ServiceInfo si=list.getList().get(i);
				InfoType infoType = infoTypeService.get(new Criteria("id", si.getInfoType()));
				InfoType detailType = infoTypeService.get(new Criteria("id", si.getDetailType()));
				
				if(ObjectUtil.isNotEmpty(infoType)) {
					si.setInfoTypeName(infoType.getName());
				}
				
				if(ObjectUtil.isNotEmpty(detailType)) {
					si.setDetailTypeName(detailType.getName());
				}
			}
		}
		model.addAttribute("infoRecords", list.getList());
		model.addAttribute("page", list.getPage());
		model.addAttribute("serviceInfo", serviceInfo);
		return "rhip.lhportal.serviceInfo.list";
	}

	/**
	 * 服务信息的查看/修改/新增
	 * 
	 * @param request
	 * @param model
	 * @param serviceInfo
	 * @param operatorType
	 * @return
	 */
	@RequestMapping("/edit")
	public String add(HttpServletRequest request, ModelMap model, ServiceInfo serviceInfo, String operatorType) {
		String role = SecurityUtils.getUserRoles(request).get(0).getRoleCode(); 
		String idTemp = request.getParameter("id");
		if(ObjectUtil.isNotEmpty(idTemp)) {//修改和查看
			Long id = new Long(idTemp);
			serviceInfo = serviceInfoService.get(id);
			serviceInfo.setAuthor(this.getCurrentUser(request).getName());
			serviceInfo.setOperatorType(operatorType);
			List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID",id).add("FILE_RESOURCE", "lhrollpic"));
			model.addAttribute("attches", uploadInfoRecords);
		}else {//新建
			serviceInfo = new ServiceInfo();
			serviceInfo.setCreatTime(new Date());
			serviceInfo.setAuthor(this.getCurrentUser(request).getName());
			serviceInfo.setOperatorType(operatorType);
		}
		List<InfoType> infoTypeParentList = infoTypeService.getList(new Criteria("parentCode", OP.IS, null));
		model.addAttribute("infoTypeParentList", infoTypeParentList);
		model.addAttribute("serviceInfo", serviceInfo);
		model.addAttribute("role", role);
		return "rhip.lhportal.serviceInfo.edit";
	}
	
	/**
	 * 发布和不发布到门户
	 * 
	 * @param request
	 * @param model
	 * @param id
	 * @param operation
	 * @return
	 */
	@RequestMapping("/status")
	public String publish(HttpServletRequest request, ModelMap model, Long id, String operation) {
		if(ObjectUtil.isNotEmpty(id) && operation.trim().equals("publish")) {
			if(serviceInfoService.updateStatus(new Parameters("status", 1), new Criteria("id", id)) > 0)
				return EHRMessageUtil.returnMsg(model, "1");
		}
		else
			if(ObjectUtil.isNotEmpty(id) && operation.trim().equals("unpublish")) {
				if(serviceInfoService.updateStatus(new Parameters("status", 0), new Criteria("id", id)) > 0)
					return EHRMessageUtil.returnMsg(model, "1");
			}
		return EHRMessageUtil.returnMsg(model, "0");
	}
	
	/**
	 * 服务信息的保存
	 * 
	 * @param request
	 * @param model
	 * @param serviceInfo
	 * @param contents
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(HttpServletRequest request, ModelMap model, @Valid ServiceInfo serviceInfo, String contents) {
		boolean result = false;
		Map<String, Object> map =new HashMap<>();
		Map<String, String> linkMap = (Map<String, String>) request.getSession().getAttribute("lhrollpic_fileMap");//附件
		map = validateAttchement(map, linkMap, serviceInfo.getId());
		if(ObjectUtil.isNotEmpty(map)) {
			return map;
		}
		String createOrgCode =getCurrentOrg(request).getOrganCode();
		serviceInfo.setCreateOrgCode(createOrgCode);
		String createUserCode = getCurrentUser(request).getUserCode();
		serviceInfo.setCreator(this.getCurrentUser(request).getUserName());
		if(ObjectUtil.isNotEmpty(serviceInfo.getId()) && serviceInfo.getOperatorType().trim().equals("2")) {//更新
			serviceInfo.setUpdateTime(new Date());
			serviceInfo.setContents(contents);
			result = serviceInfoService.update(serviceInfo, linkMap, createUserCode);
		}else {//新增
			serviceInfo.setCreatTime(new Date());
			serviceInfo.setContents(contents);
			serviceInfo.setTimes(0L);
			result = serviceInfoService.insert(serviceInfo, linkMap,createUserCode);
		}
		// 保存成功清理session
			if(result && ObjectUtil.isNotEmpty(linkMap)) {
				request.getSession().removeAttribute("lhrollpic_fileMap");
			}
			map.put("message", result ? "success" : "fail");
			return map;
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, ModelMap model, Long id) {
		if(ObjectUtil.isNotEmpty(id)) {
			if(serviceInfoService.delete(new Criteria("ID", id)) > 0 )
				return EHRMessageUtil.returnMsg(model, 1);
		}
		return EHRMessageUtil.returnMsg(model, 0);
	}
	
	private Criteria initsearchCondition(ServiceInfo serviceInfo) {
		Date beginTime = serviceInfo.getBeginTime();
		Date endTime = serviceInfo.getEndTime();
		Criteria criteria = new Criteria();
		if(ObjectUtil.isNullOrEmpty(serviceInfo)) {
			return criteria;
		}
		if(ObjectUtil.isNotEmpty(serviceInfo.getTitle()) && null != serviceInfo.getTitle())
			criteria.add("TITLE", OP.LIKE, serviceInfo.getTitle());
		if(ObjectUtil.isNotEmpty(serviceInfo.getSource()) && null != serviceInfo.getSource()) 
			criteria.add("SOURCE", OP.LIKE, serviceInfo.getSource());
		if(ObjectUtil.isNotEmpty(serviceInfo.getAuthor()) && null != serviceInfo.getAuthor())
			criteria.add("AUTHOR", OP.LIKE, serviceInfo.getAuthor());
		if(ObjectUtil.isNotEmpty(serviceInfo.getInfoType()) && null != serviceInfo.getInfoType())
			criteria.add("INFO_TYPE", OP.EQ, serviceInfo.getInfoType());
		if(ObjectUtil.isNotEmpty(serviceInfo.getDetailType()) && null != serviceInfo.getDetailType())
			criteria.add("DETAIL_TYPE", OP.EQ, serviceInfo.getDetailType());
		if(ObjectUtil.isNotEmpty(serviceInfo.getStatus()) && null != serviceInfo.getStatus())
			criteria.add("STATUS", OP.EQ, serviceInfo.getStatus());
		if(ObjectUtil.isNotEmpty(serviceInfo.getIsRollPicture()) && null != serviceInfo.getIsRollPicture())
			criteria.add("IS_ROLL_PICTURE", OP.EQ, serviceInfo.getIsRollPicture());
		DateUtil.getCriteriaByDateRange(criteria, "CREAT_TIME", beginTime, endTime);
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
		List<UploadInfoRecord> infoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", resourceId).add("FILE_RESOURCE", "lhrollpic"));
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
