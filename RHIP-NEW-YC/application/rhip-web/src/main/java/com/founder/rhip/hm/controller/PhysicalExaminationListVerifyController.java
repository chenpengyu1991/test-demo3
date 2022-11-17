package com.founder.rhip.hm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.ExcelUtils;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.entity.basic.PhysicalExamRecord;
import com.founder.rhip.hm.controller.form.HealthManageQueryForm;
import com.founder.rhip.hm.service.IPhysicalExamRecordService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/hm/verify")
public class PhysicalExaminationListVerifyController extends BaseController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private IPhysicalExamRecordService physicalExamRecordService;
	
	@Resource
	private IDictionaryApp dictionaryApp;
	
	//@Resource
	//private IOrganizationApp organizationApp;
	
	@RequestMapping("/list")
	public String list(ModelMap model) {
		return "com.founder.rhip.hm.physicalExamRecord.search";
	}
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request, ModelMap model, HealthManageQueryForm criForm, int indexPage) {
		Page page = super.getPage(request, indexPage); 
		Criteria criteria = initCriteria(request, criForm);
		PageList<PhysicalExamRecord> result = physicalExamRecordService.getPhysicalExamRecords(page, criteria);
		model.addAttribute("records", result.getList());
		model.addAttribute("page", result.getPage());
		return "com.founder.rhip.hm.physicalExamRecord.list";
	}
	
	@RequestMapping("/confirm")
	@ResponseBody
	public ModelMap confirm(HttpServletRequest request, String personIds) {
		ModelMap model = new ModelMap();
		try {
			String[] ids = personIds.split(",");
			Organization org = getCurrentOrg(request);
			physicalExamRecordService.confirmExamRecord(org.getOrganCode(), ids);
			model.addAttribute("success", true);
			model.addAttribute("message", "核实确认成功");
		} catch (Exception e) {
			log.error("核实确认失败", e);
			model.addAttribute("success", false);
			model.addAttribute("message", "核实确认失败，错误：" + e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/reflashVerify")
	@ResponseBody
	public ModelMap reflashVerify(HttpServletRequest request) {
		ModelMap model = new ModelMap();
		try {
			Organization org = getCurrentOrg(request);
			String inputOrgFieldName = "inputCenterOrganCode";
            Criteria criteria = new Criteria();
			/*根据角色过滤字段*/
			if (hasRole(RoleType.ZLNR, request)){
				inputOrgFieldName = "inputOrganCode";
                criteria.add("inputOrganCode",org.getOrganCode());
			} else if(hasRole(RoleType.ZXLNR, request)){
                List<String> orgCodes = this.getOrgCodeByOrgCode(request);
                criteria.add("inputOrganCode", OP.IN, orgCodes);
			}
            physicalExamRecordService.reflashVerify(criteria);
			
			model.addAttribute("success", true);
			model.addAttribute("message", "更新名单成功");
		} catch (Exception e) {
			log.error("更新名单失败", e);
			model.addAttribute("success", false);
			model.addAttribute("message", "更新名单失败，原因：" + e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/confirmAll")
	@ResponseBody
	public ModelMap confirmAll(HttpServletRequest request, HealthManageQueryForm criForm) {
		ModelMap model = new ModelMap();
		try {
			criForm.setConfirm(0);//未确认
			Criteria criteria = initCriteria(request, criForm);
			criteria.add("logoff", 0);//未注销
			List<String> ids = new ArrayList<String>();
			List<PhysicalExamRecord> examRecords = physicalExamRecordService.getPhysicalExamRecords(criteria);
			for (PhysicalExamRecord record : examRecords) {
				ids.add(record.getId().toString());
			}
			Organization org = getCurrentOrg(request);
			physicalExamRecordService.confirmExamRecord(org.getOrganCode(), ids.toArray(new String[]{}));
			model.addAttribute("success", true);
			model.addAttribute("message", "全部核实确认成功,共核实确认（" + ids.size() + "）条");

			ids.clear();
			ids = null;
			examRecords.clear();
			examRecords = null;
		} catch (Exception e) {
			log.error("核实确认失败", e);
			model.addAttribute("success", false);
			model.addAttribute("message", "全部核实确认失败，错误：" + e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/cancelConfirm")
	@ResponseBody
	public ModelMap cancelConfirm(HttpServletRequest request, String personIds) {
		ModelMap model = new ModelMap();
		try {
			String[] ids = personIds.split(",");
			Organization org = getCurrentOrg(request);
			physicalExamRecordService.cancelConfirmExamRecord(org.getOrganCode(), ids);
			model.addAttribute("success", true);
			model.addAttribute("message", "取消核实成功");
		} catch (Exception e) {
			log.error("取消核实失败", e);
			model.addAttribute("success", false);
			model.addAttribute("message", "取消核实失败，错误：" + e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/cancelConfirmAll")
	@ResponseBody
	public ModelMap cancelConfirmAll(HttpServletRequest request, HealthManageQueryForm criForm) {
		ModelMap model = new ModelMap();
		try {
			criForm.setConfirm(1);//已确认
			Criteria criteria = initCriteria(request, criForm);
			List<String> ids = new ArrayList<String>();
			List<PhysicalExamRecord> examRecords = physicalExamRecordService.getPhysicalExamRecords(criteria);
			for (PhysicalExamRecord record : examRecords) {
				ids.add(record.getId().toString());
			}
			Organization org = getCurrentOrg(request);
			physicalExamRecordService.cancelConfirmExamRecord(org.getOrganCode(), ids.toArray(new String[]{}));
			model.addAttribute("success", true);
			model.addAttribute("message", "全部取消核实成功,共取消确认（" + ids.size() + "）条");

			ids.clear();
			ids = null;
			examRecords.clear();
			examRecords = null;
		} catch (Exception e) {
			log.error("取消核实失败", e);
			model.addAttribute("success", false);
			model.addAttribute("message", "全部取消核实失败，错误：" + e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/downExcel")
	@ResponseBody
	public void downExcel(HttpServletRequest request, HttpServletResponse response, HealthManageQueryForm criForm) throws Exception {
		try {
			ExcelUtils excel = new ExcelUtils(getExcelPath("../views/hm/template/physicalExaminationVerifyList.xls"));
			criForm.setConfirm(1);//已经确认
			Criteria criteria = initCriteria(request, criForm);
			List<PhysicalExamRecord> examRecords = physicalExamRecordService.getPhysicalExamRecords(criteria);
			for (PhysicalExamRecord record : examRecords) {
				excel.writeLine(getExcelValues(record));
			}
			setExcelContent(response, "体检预约表.xls");
			excel.save(response.getOutputStream());

			examRecords.clear();
			examRecords = null;
            createOperationLog(request, RhipModuleName.HM_OLDMAN, "体检预约表", OperationName.EXP);
		} catch (Exception e) {
			log.error("下载已确认名单出错", e);
			throw e;
		}
	}
	
	private List<Object> getExcelValues(PhysicalExamRecord record) {
		List<Object> line = new ArrayList<Object>();
		line.add(record.getName());
		line.add(dictionaryApp.queryDicItemName("GBT226112003", record.getGender()));
		line.add(record.getAge());
		line.add(formatMarriageCode(record.getMarriage()));
		line.add(record.getTelephone());
		line.add(record.getMoible());
		line.add(record.geteMail());
		line.add("");
		line.add("");
		line.add(record.getIdcard());
		line.add("");
//		line.add(record.getExamNumber());
		return line;
	}
	
	private String formatMarriageCode(String marriage) {
		//婚姻状况(GBT226122003)
		//40	离婚	3
		//90	未说明的婚姻状况
		//10	未婚	1
		//20	已婚	2
		//21	初婚
		//22	再婚
		//23	复婚
		//30	丧偶	4
		//50	同居
		//		其他	5
		if ("10".equals(marriage)) {
			marriage = "1";
		} else if ("20".equals(marriage)) {
			marriage = "1";
		} else if ("40".equals(marriage)) {
			marriage = "3";
		} else if ("30".equals(marriage)) {
			marriage = "4";
		} else {
			marriage = "5";
		}
		return marriage;
	}
	
	private Criteria initCriteria(HttpServletRequest request, HealthManageQueryForm criForm) {
		//criForm.setExamYear(String.valueOf(DateUtil.getCurrentYear()));//本年度
		//criForm.setPaymentPatternCode("04");//新农合
		Criteria criteria = criForm.toCriteria();
		if (!criteria.contains("inputOrganCode")) {
			Organization org = getCurrentOrg(request);
			if (hasRole(RoleType.ZX_GLY, request)) {
				criteria.add("inputSuperOrganCode", org.getOrganCode());
			} else if (hasRole(RoleType.Z_GLY, request)) {
				criteria.add("inputOrganCode", org.getOrganCode());
			}
		}
		return criteria;
	}


}
