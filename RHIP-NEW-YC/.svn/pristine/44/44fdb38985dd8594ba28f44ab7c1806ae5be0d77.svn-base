package com.founder.rhip.mdm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Record;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.common.OperateType;
import com.founder.rhip.mdm.entity.Department;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.service.IDepartmentService;

/**
 * 部门维护
 */
@Controller
@RequestMapping("/mdmDepartment")
public class DepartmentController extends BaseController {
	
	@Resource(name = "mdmDepartmentService")
	private IDepartmentService departmentService;
	
	@RequestMapping("/manager")
	public String manager(ModelMap model) {
		return "com.founder.mdm.smpi.departmentManager";
	}
	
	@RequestMapping("/search")
	public String search(ModelMap model, String organCode) {
		Department department = new Department();
		department.setOrganCode(organCode);
		model.addAttribute("criDepartment", department);
		return "com.founder.mdm.smpi.departmentSearch";
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request,ModelMap model, Department criDepartment, int indexPage) {
		Page page = super.getPage(request,  indexPage);
		Criteria criteria = initCriteria(criDepartment);
		PageList<Department> pageList = departmentService.getDepartments(page, criteria);
		model.addAttribute("deptList", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		model.addAttribute("indexPage", indexPage);
		return "com.founder.mdm.smpi.departmentList";
	}
	
	@RequestMapping("/add")
	public String add(ModelMap model, String organCode) {
		Department department = new Department();
		department.setOrganCode(organCode);
		model.addAttribute("department", department);
		return "com.founder.mdm.smpi.departmentInfoEdit";
	}
	
	@RequestMapping("/edit")
	public String edit(ModelMap model, Long deptId) {
		Department department = departmentService.getDepartment(deptId);
		model.addAttribute("department", department);
		return "com.founder.mdm.smpi.departmentInfoEdit";
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public ModelMap save(Department department, String type) {
		ModelMap model = new ModelMap();
		
		department.setOperator(getOperator());
		department.setOperateTime(getOperatorTime());
		
		//检查合法性
		Record record = new Record(department);
		List<String> chkMessageList = new ArrayList<String>();
		checkAll(chkMessageList, record, EntityType.DEPARTMENT);
		
		if (chkMessageList.size() > 0) {
			model.addAttribute("result", false);
			model.addAttribute("message", getCheckErrorStr(chkMessageList));
			return model;
		}
		
		String deptCode = department.getDeptCode();
		Department dbDept = departmentService.getDepartment(deptCode);
		if (dbDept == null) {
			if ("edit".equalsIgnoreCase(type)) {
				model.addAttribute("result", false);
				model.addAttribute("message", "需要更新的科室不存在");
				return model;
			}
		} else {
			if ("add".equalsIgnoreCase(type)) {
				model.addAttribute("result", false);
				model.addAttribute("message", "相同编码的科室已经存在");
				return model;
			}
		}
		
		try {
			if ("add".equalsIgnoreCase(type)) {
				department.setOperateType(OperateType.create.getName());
				departmentService.createDepartment(department);
				model.addAttribute("result", true);
				model.addAttribute("message", "添加成功");
			} else if ("edit".equalsIgnoreCase(type)) {
				department.setOperateType(OperateType.update.getName());
				department.setDeptId(dbDept.getDeptId());
				departmentService.updateDepartment(department);
				model.addAttribute("result", true);
				model.addAttribute("message", "修改成功");
			}
		} catch (Exception e) {
			log.error("保存科室出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/remove")
	@ResponseBody
	public ModelMap remove(Long deptId) {
		ModelMap model = new ModelMap();
		try {
			departmentService.deleteDepartment(deptId);
			model.addAttribute("result", true);
		} catch (Exception e) {
			log.error("删除科室出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/showLogs")
	public String showLogs(HttpServletRequest request,ModelMap model, Long deptId, int indexPage) {
		Page page = super.getPage(request,  indexPage);
		PageList<Department> pageList = departmentService.getUpdateHistory(page, deptId);
		model.addAttribute("logList", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		model.addAttribute("deptId", deptId);
		return "com.founder.mdm.smpi.departmentLogList";
	}
	
	private Criteria initCriteria(Department criDepartment) {
		Criteria criteria = new Criteria();
		String organCode = criDepartment.getOrganCode();
		if (StringUtil.isNotEmpty(organCode)) {
			criteria.add(Department.ORGAN_CODE, organCode);
		}
		String deptCode = criDepartment.getDeptCode();
		if (StringUtil.isNotEmpty(deptCode)) {
			criteria.add(Department.DEPT_CODE, OP.LIKE, deptCode);
		}
		String deptName = criDepartment.getDeptName();
		if (StringUtil.isNotEmpty(deptName)) {
			criteria.add("deptName", OP.LIKE, deptName);
		}
		return criteria;
	}
	
}
