package com.founder.rhip.he.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.entity.healtheducation.HePromoteUnit;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.he.service.IHePromoteUnitService;
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
 * 健康促进单位
 * 
 * @author GaoFei
 *
 */
@Controller
@RequestMapping(value = "/he/promoteunit")
public class HePromoteUnitController extends VisitController {
	
	@Resource(name = "hePromoteUnitService")
	private IHePromoteUnitService hePromoteUnitService;
	
	/**
	 * 查询健康促进单位
	 * 
	 * @return
	 */
	@RequestMapping("/search")
	public String search() {
		return "rhip.he.health.education.promoteunit.search";
	}
	
	/**
	 * 健康促进单位详情
	 * 
	 * @param id 健康促进单位ID
	 * @param model
	 * @return
	 */
	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable("id")Long id, ModelMap model) {
		if (ObjectUtil.isNotEmpty(id)) {
			HePromoteUnit healthPromoteUnit = hePromoteUnitService.getHealthPromoteUnit(new Criteria("ID", id));
			model.addAttribute("healthPromoteUnit", healthPromoteUnit);
		}
		return "rhip.he.health.education.promoteunit.detail";
	}
	
	/**
	 * 分页显示健康促进单位
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
		
		Criteria criteria = CriteriaOrganizer.initCriteria(request.getParameterMap(), HePromoteUnit.class, "GRANT_TIME");
		
		// 不同身份查询条件
		//organizeCriteria(criteria, model, request);
		
		PageList<HePromoteUnit> pageList = hePromoteUnitService.findHealthPromoteUnit(criteria.add("STATUS", "1"), page);
		model.addAttribute("healthPromoteUnits", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		return "rhip.he.health.education.promoteunit.list";
	}
	
	/**
	 * 编辑健康促进单位
	 * 
	 * @param id 健康促进单位主键ID
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap model) {
		if (ObjectUtil.isNotEmpty(id)) {
			HePromoteUnit healthPromoteUnit = hePromoteUnitService.getHealthPromoteUnit(new Criteria("ID", id));
			model.addAttribute("healthPromoteUnit", healthPromoteUnit);
		}
		return "rhip.he.health.education.promoteunit.edit";
	}
	
	/**
	 * 添加健康促进单位
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	public String add() {
		return "rhip.he.health.education.promoteunit.edit";
	}
	
	/**
	 * 保存健康促进单位
	 * 
	 * @param healthPromoteUnit 健康促进对象
	 * @param request
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(HePromoteUnit healthPromoteUnit, HttpServletRequest request) {
		int ret = 0;
		// 新增健康教育处方
		if (ObjectUtil.isNullOrEmpty(healthPromoteUnit.getId())) {
            createOperationLog(request, RhipModuleName.HE, "保存健康促进单位", OperationName.ADD);
			//initOrgCode(new ConvertingWrapDynaBean(healthPromoteUnit), request); // 初始化机构代码
			healthPromoteUnit.setStatus("1"); // "1"默认状态，"0"删除
			ret = hePromoteUnitService.createHealthPromoteUnit(healthPromoteUnit);
		} else { // 更新健康教育处方
            createOperationLog(request, RhipModuleName.HE, "保存健康促进单位", OperationName.UPDATE);
			String[] properties = new String[] {"name", "type", "unitLevel", "grantTime", "otherType", "otherUnitLevel"};
			ret = hePromoteUnitService.updateHealthPromoteUnit(healthPromoteUnit, properties);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("result", ret > 0 ? true : false);
		map.put("message", ret > 0 ? "操作成功!" : "操作失败!");
		return map;
	}
	
	/**
	 * 删除健康促进单位
	 * 
	 * @param id 健康促进单位主键ID
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable("id") Long id, HttpServletRequest request) {
        createOperationLog(request, RhipModuleName.HE, "保存健康促进单位", OperationName.DELETE);
		int ret = hePromoteUnitService.deleteHealthPromoteUnit(id);
		Map<String, Object> map = new HashMap<>();
		map.put("result", ret > 0 ? true : false);
		map.put("message", ret > 0 ? "删除成功!" : "删除失败!");
		
		return map;
	}
}
