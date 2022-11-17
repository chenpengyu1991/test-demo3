package com.founder.rhip.he.controller;


import com.founder.fasf.beans.ConvertingWrapDynaBean;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;
import org.springframework.ui.ModelMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 访问控制器,根据不同身份限定查询条件
 * 
 * @author GaoFei
 *
 */
public class VisitController extends BaseController {
	
	@Resource(name="mdmOrganizationService")
	private IOrganizationService organizationService;
	

	@Resource(name = "uploadInfoRecordService")
	private IUploadInfoRecordService uploadInfoRecordService;
	
	/**
	 * 组织不同身份查询条件
	 * 
	 * @param criteria
	 * @param model
	 * @param request
	 */
	protected void organizeCriteria(Criteria criteria, ModelMap model, HttpServletRequest request) {
		Organization org = getCurrentOrg(request);
		model.addAttribute("createrOrg", hasRole(RoleType.JKJKJY, request) ? "_999" : org.getOrganCode()); // 用来控制编辑与删除的操作
		if (!criteria.contains("organCode")) {
			if (hasRole(RoleType.ZXJKJY, request)||hasRole(RoleType.ZX_GLY, request)) {
				criteria.add("centerOrgCode", org.getOrganCode());
			} else if (hasRole(RoleType.ZJKJY, request)||hasRole(RoleType.Z_GLY, request)) {
				criteria.add("orgCode", org.getOrganCode());
			}
		}
		
		// 用来页面判断显示机构
		if (criteria.contains("orgCode")) {
			model.addAttribute("orgCode", criteria.get("orgCode")); 
		} else if (criteria.contains("centerOrgCode")) {
			model.addAttribute("centerOrgCode", criteria.get("centerOrgCode")); 
		} else if (criteria.contains("gbcode")) {
			model.addAttribute("gbcode", criteria.get("gbcode")); 
		}else{
			model.addAttribute("all", "all"); 
		}
	}

	/**
	 * 组织不同身份查询条件
	 *
	 * @param criteria
	 * @param model
	 * @param request
	 * @param center
	 * @param station
	 */
	protected void organizeCriteria(Criteria criteria, ModelMap model, HttpServletRequest request,RoleType center,RoleType station,RoleType hospital) {
		Organization org = getCurrentOrg(request);
		model.addAttribute("createrOrg", hasRole(RoleType.YY_GLY, request) ? "_999" : org.getOrganCode()); // 用来控制编辑与删除的操作
		if (!criteria.contains("organCode")) {
			if (hasRole(center, request)) {
				criteria.add("centerOrgCode", org.getOrganCode());
			} else if (hasRole(station, request) || hasRole(hospital, request)) {
				criteria.add("orgCode", org.getOrganCode());
			}
		}

		// 用来页面判断显示机构
		if (criteria.contains("orgCode")) {
			model.addAttribute("orgCode", criteria.get("orgCode"));
		} else if (criteria.contains("centerOrgCode")) {
			model.addAttribute("centerOrgCode", criteria.get("centerOrgCode"));
		} else if (criteria.contains("gbcode")) {
			model.addAttribute("gbcode", criteria.get("gbcode"));
		}else{
			model.addAttribute("all", "all");
		}
	}

	/**
	 * 设置对应的机构编码
	 * 
	 * @param dynaBean
	 * @param request
	 */
	protected void initOrgCode(ConvertingWrapDynaBean dynaBean, HttpServletRequest request) {
		if (ObjectUtil.isNullOrEmpty(dynaBean)) {
			return;
		}
		
		Organization org = getCurrentOrg(request); // 当前登录机构
		dynaBean.set("orgCode", org.getOrganCode()); // 机构编码
		if (hasRole(RoleType.ZJKJY, request)) { // 如果当前登录为社区服务站需通过它的上级中心code获取gbcode
			Organization o = organizationService.getOrganization(org.getParentCode());
			dynaBean.set("gbcode",o.getGbCode()); // 行政区划代码
		} else {
			dynaBean.set("gbcode", org.getGbCode()); // 行政区划代码
		}
		// 中心或乡镇卫生院
		if (hasRole(RoleType.ZXJKJY, request)) {
			dynaBean.set("centerOrgCode", org.getOrganCode()); // 上级机构编码为中心自己
		}  else if (hasRole(RoleType.JKJKJY, request)) { // 健康教育所特殊
			dynaBean.set("orgCode", "_999");
			dynaBean.set("centerOrgCode", "_999");
			dynaBean.set("gbcode", "_999");
		} else if (hasRole(RoleType.ZJKJY, request)) { // 卫生服务站
			dynaBean.set("centerOrgCode", org.getParentCode());
		}
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
		if (resourceId == null) {
			if (ObjectUtil.isNullOrEmpty(fileMap)) {
				map.put("result", false);
				map.put("message", "请上传附件！");
				return map;
			}
			count = fileMap.size();
		} else {
			List<UploadInfoRecord> infoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", resourceId));
			if (ObjectUtil.isNotEmpty(fileMap)) {
				count += fileMap.size();
			}
			if (ObjectUtil.isNotEmpty(infoRecords)) {
				count += infoRecords.size();
			}
		}
		if (count > 5) {
			map.put("result", false);
			map.put("message", "附件总数量不能大于5个！");
			return map;
		}
		return map;
	}

}
