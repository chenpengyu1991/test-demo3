package com.founder.rhip.portal.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.portal.HospitalInfo;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;
import com.founder.rhip.portal.service.IHospitalInfoService;


/**
 * 机构管理
 */
@Controller
@RequestMapping(value = "lhhospitalInfo")
public class LHHospitalInfoController extends BaseController {
	@Resource(name="lhhospitalInfoService")
	private IHospitalInfoService hospitalInfoService;
	
	@Resource(name = "mdmOrganizationService")
	private IOrganizationService organizationService;
	
	@Resource(name = "uploadInfoRecordService")
	private IUploadInfoRecordService uploadInfoRecordService;
	
	
	@RequestMapping(value="/search")
	public String search(HttpServletRequest request, ModelMap model) {
		return "rhip.lhportal.hospitalInfo.search";
	}
	
	/**
	 * 机构列表
	 * 
	 * @param request
	 * @param model
	 * @param indexPage
	 * @param hospitalInfo
	 * @return
	 */
	@RequestMapping(value="/list")
	public String records(HttpServletRequest request, ModelMap model, Integer indexPage, HospitalInfo hospitalInfo) {
		int currentPage = indexPage;
		Page page = super.getPage(request, currentPage);
		Criteria criteria = iniSerachCondition(hospitalInfo, request);
		if(!hasRole(RoleType.ADMIN,request)){
			String createOrganCode = SecurityUtils.getCurrentOrganization(request).getOrganCode();
			/*criteria.add("CREATE_ORG_CODE",createOrganCode);*/
			criteria.add("HOSPITAL_NO",createOrganCode);
		}
		PageList<HospitalInfo> list = hospitalInfoService.getList(page, criteria);
		model.addAttribute("hospitalInfos", list.getList());
		model.addAttribute("page", list.getPage());
		return "rhip.lhportal.hospitalInfo.list";
	}

	/**
	 * 查看页面
	 * 
	 * @param request
	 * @param model
	 * @param id
	 * @param operation
	 * @return
	 */
	@RequestMapping("/edit")
	public String detail(HttpServletRequest request, ModelMap model, Long id, String operation) {
		HospitalInfo hospitalInfo = null;
		if(ObjectUtil.isNotEmpty(id) && ObjectUtil.isNotEmpty(operation) && operation.trim().equals("1")) {//查看
			hospitalInfo = hospitalInfoService.get(id);
			model.addAttribute("hospitalInfodetails", hospitalInfo);
			model.addAttribute("operation", "1");
		}else {//修改
			hospitalInfo = hospitalInfoService.get(id);
			model.addAttribute("hospitalInfodetails", hospitalInfo);
			model.addAttribute("operation", "2");
		}
		List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID",id).add("FILE_RESOURCE", "lhHospitalPic"));
		model.addAttribute("attches", uploadInfoRecords);
		return "rhip.lhportal.hospitalInfo.add";
	}
	
	/**
	 * 发布和不发布到门户
	 * @param request
	 * @param model
	 * @param id
	 * @param operation
	 * @return
	 */
	@RequestMapping(value="/status")
	public String changeStatus(HttpServletRequest request, ModelMap model, String id, String operation) {
		if(ObjectUtil.isNotEmpty(id)&&ObjectUtil.isNotEmpty(operation)&&operation.trim().equals("publish")) {
			if(hospitalInfoService.update(new Parameters("STATUS", 1), new Criteria("ID", id)) > 0)
				return EHRMessageUtil.returnMsg(model, "1");
		}
		else
			if(ObjectUtil.isNotEmpty(id)&&ObjectUtil.isNotEmpty(operation)&&operation.trim().equals("unpublish")) {
			if(hospitalInfoService.update(new Parameters("STATUS", 0), new Criteria("ID", id)) > 0)
				return EHRMessageUtil.returnMsg(model, "1");
			}
		return EHRMessageUtil.returnMsg(model, "0");
	}
	
	/**
	 * 从机构选择画面，添加机构
	 *
	 * @param request
	 * @param organCode
	 * @return
	 * @author Ye jianfei
	 */
	@RequestMapping("/addOrg")
	public String addOg(HttpServletRequest request, ModelMap model, String organCode) {
		if(ObjectUtil.isNotEmpty(organCode)) {
			model.addAttribute("hospitalInfodetails", initHospitalInfo(organCode));
			model.addAttribute("operation", "3");
		}
		return "rhip.lhportal.hospitalInfo.add";
	}
	
	/**
	 * 根据机构编码初始化医院数据
	 *
	 * @param organCode
	 * @return
	 * @author Ye jianfei
	 */
	private HospitalInfo initHospitalInfo(String organCode) {
		HospitalInfo hospitalInfo = new HospitalInfo();
		Organization organization = organizationService.getOrganization(organCode);
		hospitalInfo.setHospitalNo(organCode);
		if(ObjectUtil.isNotEmpty(organCode)) {
			hospitalInfo.setHospitalName(organization.getOrganName());//机构名称
			hospitalInfo.setHospitalPhone(organization.getTel());//机构电话
			hospitalInfo.setHospitalLevel(organization.getGradeCode());//机构等级
			hospitalInfo.setHospitalAddress(organization.getAddress());//机构地址
			hospitalInfo.setOrganizationType(organization.getGenreCode());//机构类别
		}
		return hospitalInfo;
	}

	/**
	 * 进入查询界面
	 *
	 * @param queryForm
	 * @param model
	 * @return
	 */
	@RequestMapping("/organizationSearch")
	public String organziationSerach(ModelMap model) {
		model.addAttribute("organization", new Organization());
		return "rhip.lhportal.hospitalInfo.organizationSearch";
	}
	
	/**
	 * 机构列表（机构选择弹出画面）
	 *
	 * @param request
	 * @param model
	 * @param criOrganization
	 * @param indexPage
	 * @return
	 * @author Ye jianfei
	 */
	@RequestMapping("/organizationList")
	public String organizationList(HttpServletRequest request, ModelMap model, Organization organization, int indexPage) {
		Page page = super.getPage(request, indexPage);
		Criteria criteria = initCriteria(organization);
		PageList<Map<String, Object>> pageList = organizationService.getOrganizations(page, criteria
				,new String[] {"organCode","organName","genreCode","manageCode","gradeCode","artificialPerson","tel"});
		model.addAttribute("organList", organizationAddFlag(pageList.getList()));
		model.addAttribute("page", pageList.getPage());
		model.addAttribute("indexPage", indexPage);
		return "rhip.lhportal.hospitalInfo.organizationList";
	}

	/**
	 * 机构的保存
	 * @param hospitalInfo
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/save")
	@ResponseBody
	public Map<String, Object> save(HttpServletRequest request, ModelMap model, @Valid HospitalInfo hospitalInfo, 
			Long id, String hospitalInf, String guideForMedical, String microGuidance) {
		
		boolean result = false;
		Map<String, Object> map =new HashMap<>();
		Map<String, String> linkMap = (Map<String, String>) request.getSession().getAttribute("lhHospitalPic_fileMap");//附件
		map = validateAttchement(map, linkMap, hospitalInfo.getId());
		if(ObjectUtil.isNotEmpty(map)) {
			return map;
		}
		String createOrganCode = getCurrentOrg(request).getOrganCode();
		hospitalInfo.setCreateOrgCode(createOrganCode);
		String createUserCode = getCurrentUser(request).getUserCode();
		hospitalInfo.setHospitalInfo(hospitalInf);
		hospitalInfo.setGuideForMedical(guideForMedical);
		hospitalInfo.setMicroGuidance(microGuidance);
		if(ObjectUtil.isNullOrEmpty(id)) {//新增
			hospitalInfo.setCreateTime(new Date());
			result = hospitalInfoService.insert(hospitalInfo, linkMap, createUserCode);
		}else {
			hospitalInfo.setUpdateTime(new Date());
			result = hospitalInfoService.update(hospitalInfo, linkMap, createUserCode);
		}
			
		// 保存成功清理session
			if(result && ObjectUtil.isNotEmpty(linkMap)) {
				request.getSession().removeAttribute("lhHospitalPic_fileMap");
			}
			map.put("message", result ? "success" : "fail");
			return map;
	}
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public void delete(HttpServletRequest request, Long id) {
		if(ObjectUtil.isNotEmpty(id)) {
			hospitalInfoService.delete(id);
			super.createOperationLog(request, RhipModuleName.LHPORTAL, "罗湖机构管理", OperationName.DELETE);
		}
	}
	
	private Criteria iniSerachCondition(HospitalInfo hospitalInfo,
			HttpServletRequest request) {
		Date fromDate = hospitalInfo.getBeginTime();
		Date endDate = hospitalInfo.getEndTime();
		Criteria criteria = new Criteria();
		if(ObjectUtil.isNullOrEmpty(hospitalInfo)) {
			return criteria;
		}
		if(ObjectUtil.isNotEmpty(hospitalInfo.getHospitalName())) {
			criteria.add("HOSPITAL_NAME", OP.LIKE, hospitalInfo.getHospitalName());
		}
		if(ObjectUtil.isNotEmpty(hospitalInfo.getOrganizationType()) && null != hospitalInfo.getOrganizationType()) {
			criteria.add("ORGANIZATION_TYPE", OP.EQ, hospitalInfo.getOrganizationType());
		}
		if(ObjectUtil.isNotEmpty(hospitalInfo.getStatus()) && null != hospitalInfo.getStatus()) {
			criteria.add("STATUS", OP.EQ, hospitalInfo.getStatus());
		}
		if(ObjectUtil.isNotEmpty(hospitalInfo.getHospitalLevel()) && null != hospitalInfo.getHospitalLevel()) {
			criteria.add("HOSPITAL_LEVEL", OP.EQ, hospitalInfo.getHospitalLevel());
		}
		DateUtil.getCriteriaByDateRange(criteria, "CREATE_TIME", fromDate, endDate);
		return criteria;
	}

	private Criteria initCriteria(Organization organization) {
		Criteria criteria = new Criteria();
		String organCode = organization.getOrganCode();
		if (StringUtil.isNotEmpty(organCode)) {
			criteria.add(Organization.ORGAN_CODE, OP.LIKE, organCode);
		}
		String organName = organization.getOrganName();
		if (StringUtil.isNotEmpty(organName)) {
			criteria.add("organName", OP.LIKE, organName);
		}
		String manageCode = organization.getManageCode();
		if (StringUtil.isNotEmpty(manageCode)) {
			criteria.add("manageCode", manageCode);
		}
		String genreCode = organization.getGenreCode();
		if (StringUtil.isNotEmpty(genreCode)) {
			criteria.add("genreCode", genreCode);
		}
		String gbCode = organization.getGbCode();
		if (StringUtil.isNotEmpty(gbCode)) {
			criteria.add("gbCode", gbCode);
		}
		String gradeCode = organization.getGradeCode();
		if (StringUtil.isNotEmpty(gradeCode)) {
			criteria.add("gradeCode", gradeCode);
		}
		String parentCode = organization.getParentCode();
		if (StringUtil.isNotEmpty(parentCode)) {
			criteria.add("parentCode", parentCode);
		}
		criteria.add("status",1);
		return criteria;
	}

	/**
	 * 机构是否已经被添加
	 *
	 * @param orgList
	 * @return
	 * @author Ye jianfei
	 */
	private Object organizationAddFlag(List<Map<String, Object>> list) {
		if(ObjectUtil.isNotEmpty(list)) {
			for(Map<String, Object> orgMap : list) {
				Criteria criteria = new Criteria();
				criteria.add("hospitalNo",orgMap.get("organ_Code")).add("IS_DELETE", "0");
				Integer orgCount = hospitalInfoService.getHospitalCount(criteria);
				orgMap.put("hospitalFlag", orgCount>0?true:false);
			}
		}
		return list;
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
		List<UploadInfoRecord> infoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", resourceId).add("FILE_RESOURCE", "lhHospitalPic"));
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
