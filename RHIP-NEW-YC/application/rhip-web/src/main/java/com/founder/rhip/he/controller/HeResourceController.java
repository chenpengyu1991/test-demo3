package com.founder.rhip.he.controller;

import com.founder.fasf.beans.ConvertingWrapDynaBean;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.ResourceCategory;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.healtheducation.HeMedia;
import com.founder.rhip.ehr.entity.healtheducation.HeResource;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.he.service.IHeMediaService;
import com.founder.rhip.he.service.IHeResourceService;
import com.founder.rhip.mdm.entity.Organization;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 健康教育资源
 * 
 * @author GaoFei
 *
 */
@Controller
@RequestMapping(value = "/he/resource")
public class HeResourceController extends VisitController {
	
	@Resource(name = "heResourceService")
	private IHeResourceService heResourceService;
	
	@Resource(name = "uploadInfoRecordService")
	private IUploadInfoRecordService uploadInfoRecordService;

	@Resource(name = "heMediaService")
	private IHeMediaService heMediaService;
	
	/**
	 * 添加健康教育资源
	 * 
	 * @param type 健康教育资源类别(宣传设备：1 宣传阵地：2  宣传材料：3)
	 * @param model
	 * @return
	 */
	@RequestMapping("/detail/{type}")
	public String detail(@PathVariable("type") String type, Long id, ModelMap model) {
		model.addAttribute("type", type); // 用来显示添加或者修改健教资源的时候显示不同的dialog
		if (ObjectUtil.isNotEmpty(id)) {
			HeResource healthEducationResource = heResourceService.getHealthEducationResource(new Criteria("ID", id));
			model.addAttribute("healthEducationResource", healthEducationResource);
			if (StringUtils.equals(type, "3")) {
				List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", id).add("FILE_RESOURCE", ResourceCategory.HEALTH_RESOURCE_MATERIAL.getCode()));
				model.addAttribute("attches", uploadInfoRecords);
			}
		}
		return "rhip.he.health.education.resource.detail";
	}
	
	/**
	 * 添加健康教育资源
	 * 
	 * @param type 健康教育资源类别(宣传设备：1 宣传阵地：2  宣传材料：3)
	 * @param model
	 * @return
	 */
	@RequestMapping("/add/{type}")
	public String add(@PathVariable("type") String type, ModelMap model) {
		model.addAttribute("type", type); // 用来显示添加或者修改健教资源的时候显示不同的dialog
		return "rhip.he.health.education.resource.edit";
	}
	
	/**
	 * 编辑健康教育资源
	 * 
	 * @param type 健康教育资源类别(宣传设备：1 宣传阵地：2  宣传材料：3)
	 * @param id 健康教育资源主键ID
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit/{type}")
	public String edit(@PathVariable("type") String type, Long id, ModelMap model) {
		model.addAttribute("type", type); // 用来显示添加或者修改健教资源的时候显示不同的dialog
		// 编辑健康教育资源
		if (ObjectUtil.isNotEmpty(id)) {
			HeResource healthEducationResource = heResourceService.getHealthEducationResource(new Criteria("ID", id));
			model.addAttribute("healthEducationResource", healthEducationResource);
			List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", id).add("FILE_RESOURCE", ResourceCategory.HEALTH_RESOURCE_MATERIAL.getCode()));
			model.addAttribute("attches", uploadInfoRecords);
		}
		return "rhip.he.health.education.resource.edit";
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Map<String, Object> remove(@PathVariable("id") Long id, HttpServletRequest request) {
        createOperationLog(request, RhipModuleName.HE, "健康教育资源", OperationName.DELETE);
		int ret = heResourceService.deleteHealthEducationResource(id);
		Map<String, Object> map = new HashMap<>();
		map.put("result", ret > 0 ? true : false);
		map.put("message", ret > 0 ? "删除成功!" : "删除失败!");
		
		return map;
	}
	
	/**
	 * 保存健康教育资源
	 * 
	 * @param healthEducationResource 健康检验资源对象
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(HeResource healthEducationResource, String positionYear, HttpServletRequest request) {
		
		int ret = 0;
		Map<String, Object> map = new HashMap<>();
		Map<String, String> fileMap = (Map<String, String>) request.getSession().getAttribute("jjzy_fileMap"); // 附件
		Map<String, String> fileNameMap = (Map<String, String>) request.getSession().getAttribute("jjzy_filenameMap"); // 附件名称
		// 宣传资料需上传附件
		if (StringUtils.equals(healthEducationResource.getResourceType(), "3")) {
			map = validateAttchement(map, fileMap, healthEducationResource.getId());
		}
		if (ObjectUtil.isNotEmpty(map)) {
			return map;
		}
		/* 宣传阵地年度*/
		if (StringUtils.isNotBlank(positionYear)) {
			Date resourceRecordTime = DateUtil.convert("yyyy", positionYear);
			healthEducationResource.setResourceRecordTime(resourceRecordTime);
		}
		try {
			// 新增健康教育资源
			if (ObjectUtil.isNullOrEmpty(healthEducationResource.getId())) {
                createOperationLog(request, RhipModuleName.HE, "健康教育资源", OperationName.ADD);
				initOrgCode(new ConvertingWrapDynaBean(healthEducationResource), request);
				healthEducationResource.setStatus("1"); // "1"默认状态，"0"删除
				healthEducationResource.setResourceCreater(getCurrentUser(request).getName()); // 资源创建者(当前登录人)
                //宣传阵地每年一条数据，如果已经存在即更新
                if(healthEducationResource.getResourceType().equalsIgnoreCase(EHRConstants.HE_ZD)){
                    Criteria criteria = new Criteria();
                    criteria.add("resourceType",healthEducationResource.getResourceType());
                    if(hasRole(RoleType.ZJKJY,request)){
                        criteria.add("orgCode",healthEducationResource.getOrgCode());
                    }else if(hasRole(RoleType.ZXJKJY,request)){
                        criteria.add("orgCode",healthEducationResource.getOrgCode());
                        criteria.add("centerOrgCode",healthEducationResource.getOrgCode());
                    }else if(hasRole(RoleType.JKJKJY,request)){
                        criteria.add("orgCode","_999");
                        criteria.add("centerOrgCode","_999");
                        criteria.add("gbcode","_999");
                    }
                    criteria.add("resourceRecordTime",healthEducationResource.getResourceRecordTime());
                    HeResource he = heResourceService.getHealthEducationResource(criteria);
                    if(ObjectUtil.isNullOrEmpty(he)){
                        ret = heResourceService.createHealthEducationResource(healthEducationResource,  fileMap, fileNameMap, getCurrentUser(request).getName());

                    }else{ //如果存在无需新增，更新即可
                        healthEducationResource.setId(he.getId());
                        String[] properties = new String[] {"galleryQuantity","blackboardQuantity","ledQuantity","boardQuantity","displayStandQuantity","resourceRemark","resourceCreater","status"};
                        ret = heResourceService.updateHealthEducationResource(healthEducationResource, fileMap, fileNameMap, getCurrentUser(request).getName(), properties);
                    }
                }else{
				    ret = heResourceService.createHealthEducationResource(healthEducationResource,  fileMap, fileNameMap, getCurrentUser(request).getName());
                }
			} else { // 更新健康教育资源
                createOperationLog(request, RhipModuleName.HE, "健康教育资源", OperationName.UPDATE);
				String[] properties = new String[] {"resourceRecordTime", "deviceName", "resourcelQuantity", "specification", "deviceCost", "materialType", "custodyDept",
						"blackboardQuantity","ledQuantity","boardQuantity","displayStandQuantity","publishDept","materialName","galleryQuantity","resourceRemark","otherDeviceName"};
				ret = heResourceService.updateHealthEducationResource(healthEducationResource, fileMap, fileNameMap, getCurrentUser(request).getName(), properties);
			}
			ret = 1;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
			ret = 0;
		}
		// 保存成功清理session
		if (ret == 1 && ObjectUtil.isNotEmpty(fileMap)) {
			request.getSession().removeAttribute("jjzy_fileMap");
		}
		
		map.put("result", ret > 0 ? true : false);
		map.put("message", ret > 0 ? "保存成功!" : "保存失败!");
		return  map;
	}
	
	/**
	 * 查询健康教育资源
	 * 
	 * @param type 健康教育资源类别(宣传设备：1 宣传阵地：2  宣传材料：3)
	 * @param model
	 * @return
	 */
	@RequestMapping("/search/{type}")
	public String search(@PathVariable("type") String type, HttpServletRequest request, ModelMap model) {
        model.addAttribute("type", type); // 用来显示添加或者修改健教资源的时候显示不同的dialog
        model.addAttribute("currentOrgCode", getCurrentOrg(request).getOrganCode()); // 用来显示添加或者修改健教资源的时候显示不同的dialog
        return "rhip.he.health.education.resource.search";
	}
	
	/**
	 * 列表显示健康教育资源
	 * 
	 * @param type 健康教育资源类别(宣传设备：1 宣传阵地：2  宣传材料：3)
	 * @param request
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/list/{type}")
	public String list(@PathVariable("type") String type, HttpServletRequest request, ModelMap model) {
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage); 
		
		Criteria criteria = CriteriaOrganizer.initCriteria(request.getParameterMap(), HeResource.class, "RESOURCE_RECORD_TIME");
		if(hasRole(RoleType.QWGZX,request) && !criteria.contains("gbcode")){
            criteria.add("gbcode",getCurrentOrg(request).getGbCode());
        }
        // 不同身份查询条件
		organizeCriteria(criteria, model, request);
		Organization org = getCurrentOrg(request);
		if (hasRole(RoleType.ZJKJY, request)) {
			criteria.add("orgCode", org.getOrganCode());
		}
		PageList<HeResource> pageList = heResourceService.findHealthEducationResource(criteria.add("RESOURCE_TYPE", type).add("STATUS", "1"), page);
		model.addAttribute("healthEducationResources", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		model.addAttribute("type", type);
		return "rhip.he.health.education.resource.list";
	}
	
	/**
	 * 健康素养评估
	 * 
	 * @return
	 */
	@RequestMapping("/eval")
	public String eval() {
		return "rhip.he.health.quality.eval";
	}

	/*************影像播放 add by Kevin Ro 2018-07-16 start**************/
	@RequestMapping("/media/search")
	public String mediaSearch(HttpServletRequest request, ModelMap model) {
		model.addAttribute("currentOrgCode", getCurrentOrg(request).getOrganCode());
		return "rhip.he.health.education.resource.media.search";
	}

	@ResponseBody
	@RequestMapping("/media/delete/{id}")
	public Map<String, Object> mediaRemove(@PathVariable("id") Long id, HttpServletRequest request) {
		createOperationLog(request, RhipModuleName.HE, "宣传影像", OperationName.DELETE);
		int ret = heMediaService.deleteMedia(id);
		Map<String, Object> map = new HashMap<>();
		map.put("result", ret > 0 ? true : false);
		map.put("message", ret > 0 ? "删除成功!" : "删除失败!");

		return map;
	}

	@RequestMapping("/media/list")
	public String mediaList( HttpServletRequest request, ModelMap model) {
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);

		Criteria criteria = CriteriaOrganizer.initCriteria(request.getParameterMap(), HeMedia.class, "PLAY_DATE");
		if(hasRole(RoleType.QWGZX,request) && !criteria.contains("gbcode")){
			criteria.add("gbcode",getCurrentOrg(request).getGbCode());
		}if (!criteria.contains("orgCode")) {
			if (hasRole(RoleType.ZXJKJY, request)||hasRole(RoleType.ZX_GLY, request)) {
				criteria.add("centerOrgCode", getCurrentOrg(request).getOrganCode());
			} else if (hasRole(RoleType.ZJKJY, request)||hasRole(RoleType.Z_GLY, request)) {
				criteria.add("orgCode", getCurrentOrg(request).getOrganCode());
			}
		}
		// 不同身份查询条件
		//organizeCriteria(criteria, model, request);

		PageList<HeMedia> pageList = heMediaService.getMediaPageList(criteria,page);
		model.addAttribute("healthEducationResources", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		return "rhip.he.health.education.resource.media.list";
	}

	@RequestMapping("/media/add")
	public String mediaAdd(ModelMap model) {
		return "rhip.he.health.education.resource.media.edit";
	}

	@RequestMapping("/media/edit")
	public String mediaEdit(Long id, ModelMap model) {
		if(ObjectUtil.isNotEmpty(id)) {
			HeMedia media = heMediaService.getMedia(new Criteria("ID",id));
			List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", id).add("FILE_RESOURCE", ResourceCategory.HEALTH_RESOURCE_VIDEO.getCode()));
			model.addAttribute("attches", uploadInfoRecords);
			model.addAttribute("media",media);
		}
		return  "rhip.he.health.education.resource.media.edit";
	}

	@ResponseBody
	@RequestMapping("/media/save")
	public Map<String, Object> mediaSave(HeMedia media,String playDates, HttpServletRequest request) {
		//设置播放总时长
		if (ObjectUtil.isNotEmpty(media) && StringUtil.isNotEmpty(media.getTimes()) && StringUtil.isNotEmpty(media.getPeriod())){
			BigDecimal times = new BigDecimal(media.getTimes());
			BigDecimal period = new BigDecimal(media.getPeriod());
			media.setTotalPeriod(times.multiply(period).longValue());
		}
		Map<String, Object> msgMap = new HashMap<>();
		Map<String, String> fileMap = (Map<String, String>) request.getSession().getAttribute("jjdj_fileMap"); // 附件
		Map<String, String> filenameMap = (Map<String, String>) request.getSession().getAttribute("jjdj_filenameMap"); // 附件名字
		msgMap = validateAttchement(msgMap, fileMap, media.getId());
		if (ObjectUtil.isNotEmpty(msgMap)) {
			return msgMap;
		}
		Map<String,Object> map = new HashMap<String, Object>();

		if(ObjectUtil.isNotEmpty(playDates)) {
			Date date = DateUtil.parseSimpleDate(playDates, "yyyy-MM-dd");
			media.setPlayDate(date);
		}

		// 添加或更新之前要先判断主题是否已经重复了
		HeMedia old = heMediaService.getMedia(new Criteria("theme",media.getTheme()));
		int result = 0 ; // 返回结果
		if(ObjectUtil.isNotEmpty(media.getId())) { // 更新
			if(ObjectUtil.isNotEmpty(old)) {
				if(!old.getId().equals(media.getId())) {
					map.put("result", false);
					map.put("message", "已存在相同的视频主题!");
					return map;
				}
			}
			createOperationLog(request, RhipModuleName.HE, "宣传影像", OperationName.UPDATE);
			result = heMediaService.updateMedia(media,fileMap,filenameMap,new String[]{"theme","times","period"});
		} else { // 新增
			if(ObjectUtil.isNotEmpty(old)) { // 存在重复的，不能进行添加
				map.put("result", false);
				map.put("message", "已存在相同的视频主题!");
				return map;
			}
			initOrgCode(new ConvertingWrapDynaBean(media), request);
			media.setFillDate(new Date());
			media.setResourceCreater(getCurrentUser(request).getName());
			result = heMediaService.saveMedia(media,fileMap,filenameMap);
			createOperationLog(request, RhipModuleName.HE, "宣传影像", OperationName.ADD);
		}
		// 保存成功清理session
		if (result >0 && ObjectUtil.isNotEmpty(fileMap)) {
			request.getSession().removeAttribute("jjdj_fileMap");
			request.getSession().removeAttribute("jjdj_filenameMap");
		}
		map.put("result", result > 0 ? true : false);
		map.put("message", result > 0 ? "保存成功!" : "保存失败!");
		return map;
	}

	@RequestMapping("/media/view")
	public String mediaView(Long id, ModelMap model) {
		if(ObjectUtil.isNotEmpty(id)) {
			HeMedia media = heMediaService.getMedia(new Criteria("ID",id));
			List<UploadInfoRecord> uploadInfoRecords =  uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", id).add("FILE_RESOURCE", ResourceCategory.HEALTH_RESOURCE_VIDEO.getCode()));
			model.addAttribute("attches", uploadInfoRecords);
			model.addAttribute("media",media);
		}
		return  "rhip.he.health.education.resource.media.view";
	}
		/*************影像播放 add by Kevin Ro 2018-07-16 end**************/
}
