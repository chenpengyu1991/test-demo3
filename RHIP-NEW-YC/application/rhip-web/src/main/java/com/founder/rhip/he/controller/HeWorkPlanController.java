package com.founder.rhip.he.controller;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.ResourceCategory;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.healtheducation.HeResourceRecord;
import com.founder.rhip.ehr.entity.healtheducation.HeWorkPlan;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.he.service.IHeResourceRecordService;
import com.founder.rhip.he.service.IHeWorkPlanService;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 健康教育登记-年度工作计划
 * 
 * @author jiang_haiying
 *
 */
@Controller
@RequestMapping(value = "/he/work/plan")
public class HeWorkPlanController  extends BaseController {
	
	@Resource(name = "heWorkPlanService")
	private IHeWorkPlanService heWorkPlanService;

	@Resource(name="mdmOrganizationService")
	private IOrganizationService organizationService;

	/**
	 * 查询年度工作计划
	 * 
	 * @return
	 */
	@RequestMapping("/search")
	public String search(ModelMap model) {
		return "rhip.he.work.plan.search";
	}
	
	/**
	 * 列表显示年度工作计划
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(HeWorkPlan heWorkPlan, HttpServletRequest request, ModelMap model) {
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		//Criteria criteria = CriteriaOrganizer.initCriteria(request.getParameterMap(), HeResourceRecord.class, "");
		Criteria criteria = toCriteria(heWorkPlan);
		// 不同身份查询条件
		organizeCriteria(criteria, model, request);
		PageList<HeWorkPlan> pageList = null;
		pageList = heWorkPlanService.findHeWorkPlan(criteria, page);
		model.addAttribute("heWorkPlans", pageList.getList());
		model.addAttribute("page", pageList.getPage());

		return "rhip.he.work.plan.list";
	}
	
	/**
	 * 添加年度工作计划
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("/add")
	public String add( ModelMap model, HttpServletRequest request) {
		HeWorkPlan heWorkPlan = new HeWorkPlan();
		heWorkPlan.setCreateDate(new Date());
		User user = getCurrentUser(request);
		heWorkPlan.setCreateUserCode(user.getUserCode());
		model.addAttribute("heWorkPlan", heWorkPlan);
		return "rhip.he.work.plan.edit";
	}
	
	/**
	 * 保存年度工作计划
	 * 
	 * @param heWorkPlan 年度工作计划对象
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(HeWorkPlan heWorkPlan, HttpServletRequest request) {
		int ret = 1;
		try {
			// 新增年度工作计划
			init(heWorkPlan, request);
			if (ObjectUtil.isNullOrEmpty(heWorkPlan.getId())) {
                createOperationLog(request, RhipModuleName.HE, "健康教育登记-年度工作计划", OperationName.ADD);
				heWorkPlanService.createHeWorkPlan(heWorkPlan);
			} else {
                createOperationLog(request, RhipModuleName.HE, "健康教育登记-年度工作计划", OperationName.ADD);
				String[] properties = new String[] {"planType", "planContent", "beginDate", "endDate", "updateDate", "updateOrgCode", "updateUserCode",
				"updateGbcode", "updateCenterOrgCode"};
				heWorkPlanService.updateHeWorkPlan(heWorkPlan, properties);
				ret = 1;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
			ret = 0;
		}
		Map<String, Object> map = new HashMap<>();
		map.put("result", ret > 0 ? true : false);
		map.put("message", ret > 0 ? "保存成功!" : "保存失败!");
		return map;
	}
	
	/**
	 * 编辑健康教育登记-年度工作计划
	 * 
	 * @param id 健康教育登记-年度工作计划主键ID
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(Long id, ModelMap model) {
		// 编辑健康教育登记-年度工作计划
		if (ObjectUtil.isNotEmpty(id)) {
			HeWorkPlan heWorkPlan = heWorkPlanService.getHeWorkPlan(new Criteria("ID", id));
			model.addAttribute("heWorkPlan", heWorkPlan);
		}
		return "rhip.he.work.plan.edit";
	}


	@RequestMapping("/detail")
	public String detail(Long id, ModelMap model) {
		if (ObjectUtil.isNotEmpty(id)) {
			HeWorkPlan heWorkPlan = heWorkPlanService.getHeWorkPlan(new Criteria("ID", id));
			model.addAttribute("heWorkPlan", heWorkPlan);
		}
		return "rhip.he.work.plan.detail";
	}

	/**
	 * 删除健康教育登记-年度工作计划
	 * 
	 * @param id 健康教育登记-年度工作计划主键ID
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable("id") Long id, HttpServletRequest request) {
		int ret = 0;
		try {
            createOperationLog(request, RhipModuleName.HE, "健康教育登记-年度工作计划", OperationName.DELETE);
			heWorkPlanService.deleteHeWorkPlan(id);
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
			if (hasRole(RoleType.ZXJKJY, request)) {
				criteria.add("createCenterOrgCode", org.getOrganCode());
			} else if (hasRole(RoleType.ZJKJY, request)) {
				criteria.add("createOrgCode", org.getOrganCode());
			}
		}
	}

	/**
	 * 设置对应的机构编码
	 *
	 * @param heWorkPlan
	 * @param request
	 */
	protected void init(HeWorkPlan heWorkPlan, HttpServletRequest request) {
		if (ObjectUtil.isNullOrEmpty(heWorkPlan)) {
			return;
		}
		Organization org = getCurrentOrg(request); // 当前登录机构
		User user = getCurrentUser(request); // 当前登录机构

		heWorkPlan.setCreateOrgCode(org.getOrganCode());
		if (hasRole(RoleType.ZJKJY, request)) { // 如果当前登录为社区服务站需通过它的上级中心code获取gbcode
			heWorkPlan.setCreateCenterOrgCode(org.getParentCode());
			heWorkPlan.setCreateGbcode(org.getGbCode());
			heWorkPlan.setUpdateOrgCode(org.getOrganCode());
			heWorkPlan.setUpdateCenterOrgCode(org.getParentCode());
			heWorkPlan.setUpdateGbcode(org.getGbCode());
		} else if(hasRole(RoleType.ZXJKJY, request) || hasRole(RoleType.JKJKJY, request)){
			heWorkPlan.setCreateCenterOrgCode(org.getOrganCode());
			heWorkPlan.setCreateGbcode(org.getGbCode());
			heWorkPlan.setUpdateOrgCode(org.getOrganCode());
			heWorkPlan.setUpdateCenterOrgCode(org.getOrganCode());
			heWorkPlan.setUpdateGbcode(org.getGbCode());
		}
		Date date = new Date();

		heWorkPlan.setUpdateUserCode(user.getUserCode());
		heWorkPlan.setUpdateDate(date);
	}

	public Criteria toCriteria(HeWorkPlan heWorkPlan) {
		Criteria criteria = new Criteria();

		if (StringUtil.isNotEmpty(heWorkPlan.getPlanType())) {
			criteria.add("plan_type", OP.LIKE, heWorkPlan.getPlanType());
		}
		String column = "CREATE_DATE";
		if (null != heWorkPlan.getBeginDate() && null == heWorkPlan.getEndDate()) {
			criteria.add(column, OP.GE, DateUtil.makeTimeToZero(heWorkPlan.getBeginDate()));
		} else if (null == heWorkPlan.getBeginDate() && null != heWorkPlan.getEndDate()) {
			criteria.add(column, OP.LE, DateUtil.makeTimeToMax(heWorkPlan.getEndDate()));
		}
		if (null != heWorkPlan.getBeginDate() && null != heWorkPlan.getEndDate()) {
			criteria.add(column, OP.BETWEEN, new Date[] { DateUtil.makeTimeToZero(heWorkPlan.getBeginDate()), DateUtil.makeTimeToMax(heWorkPlan.getEndDate()) });
		}
		

		if (ObjectUtil.isNotEmpty(heWorkPlan.getCreateOrgCode())) {
			criteria.add("CREATE_ORG_CODE", heWorkPlan.getCreateOrgCode());
		} else if (ObjectUtil.isNotEmpty(heWorkPlan.getCreateCenterOrgCode())) {
			criteria.add("CREATE_CENTER_ORG_CODE", heWorkPlan.getCreateCenterOrgCode());
		} else if (ObjectUtil.isNotEmpty(heWorkPlan.getCreateGbcode())) {
			criteria.add("CREATE_GBCODE", heWorkPlan.getCreateGbcode());
		}

		return criteria;
	}
}
