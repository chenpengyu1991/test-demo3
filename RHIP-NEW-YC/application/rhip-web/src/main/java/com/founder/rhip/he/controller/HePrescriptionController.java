package com.founder.rhip.he.controller;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.healtheducation.HePrescription;
import com.founder.rhip.ehr.service.IRemindStatisticsService;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.he.service.IHePrescriptionService;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 健康教育处方
 * 
 * @author GaoFei
 *
 */
@Controller
@RequestMapping(value = "/he/prescription")
public class HePrescriptionController extends VisitController {
	
	@Resource(name = "hePrescriptionService")
	private IHePrescriptionService hePrescriptionService;

    @Resource(name = "remindStatisticsService")
    private IRemindStatisticsService remindStatisticsService;
	
	/**
	 * 查询健康教育处方
	 * 
	 * @return
	 */
	@RequestMapping("/search")
	public String search() {
		return "rhip.he.health.education.prescription.search";
	}
	
	/**
	 * 健康教育处方详情
	 * 
	 * @param id 健康教育处方主键ID
	 * @param model
	 * @return
	 */
	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable("id") Long id, ModelMap model, String operatorType) {
		if (ObjectUtil.isNotEmpty(id)) {
			HePrescription healthPrescription = hePrescriptionService.getHealthPrescription(new Criteria("ID", id));
			model.addAttribute("healthPrescription", healthPrescription);
		}
		model.addAttribute("operatorType", operatorType);
		return "rhip.he.health.education.prescription.detail";
	}
	
	
	/**
	 * 分页显示健康教育处方
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
		
		Criteria criteria = CriteriaOrganizer.initCriteria(request.getParameterMap(), HePrescription.class, "CREATE_TIME");
		if(hasRole(RoleType.QWGZX,request) && !criteria.contains("gbcode")){
			criteria.add("gbcode",getCurrentOrg(request).getGbCode());
		}
		// 不同身份查询条件
		//organizeCriteria(criteria, model, request);
		// 用来页面判断显示机构
		Organization org = getCurrentOrg(request);
		model.addAttribute("createrOrg", hasRole(RoleType.JKJKJY, request) ? "_999" : org.getOrganCode());

		PageList<HePrescription> pageList = hePrescriptionService.findHealthPrescription(criteria, page);
		model.addAttribute("healthPrescriptions", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		model.addAttribute("currentOrgCode", getCurrentOrg(request).getOrganCode());
		return "rhip.he.health.education.prescription.list";
	}
	
	/**
	 * 编辑健康教育处方
	 * 
	 * @param id 健康教育处方主键ID
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap model, String operatorType) {
		if (ObjectUtil.isNotEmpty(id)) {
			HePrescription healthPrescription = hePrescriptionService.getHealthPrescription(new Criteria("ID", id));
			model.addAttribute("healthPrescription", healthPrescription);
		}
		model.addAttribute("operatorType", operatorType);
		return "rhip.he.health.education.prescription.edit";
	}
	
	/**
	 * 添加健康教育处方
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	public String add(ModelMap model, String operatorType) {

		model.addAttribute("healthPrescription", new HePrescription());

		model.addAttribute("operatorType", operatorType);
		//TODO:处方名称与类别
		return "rhip.he.health.education.prescription.edit";
	}
	
	/**
	 * 保存健康教育处方
	 * 
	 * @param healthPrescription 健康教育处方对象
	 * @param request
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(HePrescription healthPrescription, HttpServletRequest request) {
		int ret = 0;
		// 新增健康教育处方
		if (ObjectUtil.isNullOrEmpty(healthPrescription.getId())) {
			createOperationLog(request, RhipModuleName.HE, "健康教育处方", OperationName.ADD);
			initOrgCode(new ConvertingWrapDynaBean(healthPrescription), request); // 初始化机构代码
			ret = hePrescriptionService.createHealthPrescription(healthPrescription);
		} else { // 更新健康教育处方
            createOperationLog(request, RhipModuleName.HE, "健康教育处方", OperationName.UPDATE);
			String[] properties = new String[] {"name", "type", "content", "title","status"};
			ret = hePrescriptionService.updateHealthPrescription(healthPrescription, properties);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("result", ret > 0 ? true : false);
		map.put("message", ret > 0 ? "操作成功!" : "操作失败!");
		return map;
	}
	
	/**
	 * 删除健康教育处方
	 * 
	 * @param id 健康教育处方主键ID
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable("id") Long id, HttpServletRequest request) {
        createOperationLog(request, RhipModuleName.HE, "健康教育处方", OperationName.DELETE);
		int ret = hePrescriptionService.deleteHealthPrescription(id);
		Map<String, Object> map = new HashMap<>();
		map.put("result", ret > 0 ? true : false);
		map.put("message", ret > 0 ? "删除成功!" : "删除失败!");
		
		return map;
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
		if (ObjectUtil.isNotEmpty(id) && operation.trim().equals("publish")) {
			if (hePrescriptionService.updateStatus(new Parameters("status", 1), new Criteria("id", id)) > 0)
				return EHRMessageUtil.returnMsg(model, "1");
		} else if (ObjectUtil.isNotEmpty(id) && operation.trim().equals("unpublish")) {
			if (hePrescriptionService.updateStatus(new Parameters("status", 0), new Criteria("id", id)) > 0)
				return EHRMessageUtil.returnMsg(model, "1");
		}
		return EHRMessageUtil.returnMsg(model, "0");
	}
}
