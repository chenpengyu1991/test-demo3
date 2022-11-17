package com.founder.rhip.ep.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Record;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.VoUtil;
import com.founder.rhip.ehr.dto.EndemicPreventDTO;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.ep.SaltMonitorRecord;
import com.founder.rhip.ehr.entity.ep.SaltSamplingRecord;
import com.founder.rhip.ehr.entity.ep.SaltTestRecord;
import com.founder.rhip.ep.controller.form.IodateQueryForm;
import com.founder.rhip.ep.service.IIodateService;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import net.sf.cglib.beans.BeanMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 碘盐监测
 * @author Jingqiu Hao
 */
@Controller
@RequestMapping(value = "/ep/iodate")
public class IodateController extends BaseController {

	@Resource
	private IIodateService iodateService;

	@Resource
	private com.founder.rhip.mdm.app.IDictionaryApp dictionaryApp;

	@RequestMapping("/samplingSearch")
	public String samplingSearch() {
		return "rhip.ep.iodate.samplingSearch";
	}

	@RequestMapping("/samplingList")
	public String samplingList(ModelMap modelMap, HttpServletRequest request, int indexPage) {
		Page page = super.getPage(request, indexPage); 
		String year = request.getParameter("samplingTime");
		PageList<SaltSamplingRecord> pageList = iodateService.getSamplingPageList(page, year);
		modelMap.addAttribute("recordList", pageList.getList());
		modelMap.addAttribute("page", pageList.getPage());
		modelMap.addAttribute("indexPage", indexPage);
		String thisYear = DateUtil.toFormatString("yyyy", new Date());
		modelMap.addAttribute("thisYear", thisYear);
		return "rhip.ep.iodate.samplingList";
	}

	@RequestMapping("/editSamplingRecord")
	public String editSamplingRecord(ModelMap modelMap, String year, String gbCode) {
		List<SaltSamplingRecord> records = iodateService.getSamplingRecords(new Criteria("samplingYear", year).add("gbCode", gbCode).add("deleteFlag", EHRConstants.DELETE_FLG_0));
		if (ObjectUtil.isNullOrEmpty(records)) {
			records = new ArrayList<>();
			SaltSamplingRecord record = new SaltSamplingRecord();
			record.setSamplingTime(new Date());
			records.add(record);
		}
		modelMap.addAttribute("samplingRecords", records);
		modelMap.addAttribute("base", records.get(0));
		modelMap.addAttribute("villageCount", records.size());
		List<DicItem> villages = dictionaryApp.queryDicItem(new Criteria("dic_code", "FS990001").add("parent_code", gbCode));
		modelMap.addAttribute("villages", villages);
		modelMap.addAttribute("taday", new Date());
		return "rhip.ep.iodate.samplingEdit";
	}

	@RequestMapping("/saveSamplingRecord")
	@ResponseBody
	public ModelMap saveSamplingRecord(HttpServletRequest request, SaltSamplingRecord base) {
		ModelMap modelMap = new ModelMap();
		//检查乡镇重复
		List<SaltSamplingRecord> oldRecords = iodateService.getSamplingRecords(new Criteria("samplingYear", base.getSamplingYear()).add("gbCode", base.getGbCode()).add("deleteFlag", EHRConstants.DELETE_FLG_0));
		String oldTown = request.getParameter("oldTown");
		if (ObjectUtil.isNotEmpty(oldRecords)) {
			if (base.getId() == null || !base.getGbCode().equals(oldTown)) {
				modelMap.addAttribute("success", false);
				modelMap.addAttribute("message", "该乡镇已登记过，请重新选择。");
				return modelMap;
			}
		}
		EndemicPreventDTO endemicPreventDTO = VoUtil.getFormData(request, EndemicPreventDTO.class);
		List<SaltSamplingRecord> records = endemicPreventDTO.getSamplingRecords();
		Map<String, String> dicMap = dictionaryApp.queryDicItemMap(new Criteria("dic_code", "FS990001").add("parent_code", base.getGbCode()));
		Iterator<SaltSamplingRecord> iter = records.iterator();
		while (iter.hasNext()) {
			if (iter.next() == null) {
				iter.remove();
			}
		}
		//填公共值
		Record rec = new Record(base);
		for (SaltSamplingRecord record : records) {
			BeanMap beanMap = BeanMap.create(record);
			beanMap.putAll(rec.getMap());
			//beforeSave(request, record);
			record.setId(null);
			record.setVillageName(dicMap.get(record.getVillageCode()));
		}
		try {
			int result = iodateService.saveSamplingRecords(records, base.getSamplingYear(), oldTown);
			if (result != 0) {
				modelMap.addAttribute("success", true);
				modelMap.addAttribute("message", "保存成功！");
				if (base.getId() == null) {
					createOperationLog(request, RhipModuleName.EP, "地方病碘盐监测抽样登记保存", OperationName.ADD);
				} else {
					createOperationLog(request, RhipModuleName.EP, "地方病碘盐监测抽样登记保存", OperationName.UPDATE);
				}
			} else {
				modelMap.addAttribute("success", false);
				modelMap.addAttribute("message", "保存失败！");
			}
		} catch (Exception e) {
			modelMap.addAttribute("success", false);
			modelMap.addAttribute("message", "保存失败！" + e.getMessage());
		}
		return modelMap;
	}

	@RequestMapping("/deleteSamplingRecord")
	@ResponseBody
	public ModelMap deleteSamplingRecord(HttpServletRequest request, String year, String gbCode) {
		ModelMap modelMap = new ModelMap();
		List<SaltSamplingRecord> records = iodateService.getSamplingRecords(new Criteria("samplingYear", year).add("gbCode", gbCode));
		for (SaltSamplingRecord record : records) {
			record.setDeleteFlag(EHRConstants.DELETE_FLG_1);
			beforeSave(request, record);
		}
		try {
			int result = iodateService.deleteSamplingRecords(records);
			if (result != 0) {
				modelMap.addAttribute("success", true);
				modelMap.addAttribute("message", "删除成功！");
				createOperationLog(request, RhipModuleName.EP, "地方病碘盐监测抽样登记删除", OperationName.DELETE);
			} else {
				modelMap.addAttribute("success", false);
				modelMap.addAttribute("message", "删除失败！");
			}
		} catch (Exception e) {
			modelMap.addAttribute("success", false);
			modelMap.addAttribute("message", "删除失败！" + e.getMessage());
		}
		return modelMap;
	}

	@RequestMapping("/viewSamplingRecord")
	public String viewSamplingRecord(ModelMap modelMap, String year, String gbCode) {
		List<SaltSamplingRecord> records = iodateService.getSamplingRecords(new Criteria("samplingYear", year).add("gbCode", gbCode).add("deleteFlag", EHRConstants.DELETE_FLG_0));
		if (ObjectUtil.isNotEmpty(records)) {
			modelMap.addAttribute("records", records);
			modelMap.addAttribute("base", records.get(0));
		}
		return "rhip.ep.iodate.samplingDetail";
	}

	@RequestMapping("/monitorSearch/{function}")
	public String monitorSearch(HttpServletRequest request, ModelMap modelMap, @PathVariable String function) {
		List<String[]> townList = getMonitorTowns(request, false);
		modelMap.addAttribute("townList", townList);
		if (hasRole(RoleType.ZXDFB, request)) {
			Organization org = getCurrentOrg(request);
			String year = DateUtil.toFormatString("yyyy", new Date());
			List<SaltSamplingRecord> list = iodateService.getSamplingRecords(new Criteria("samplingYear", year).add("gbCode", org.getGbCode()).add("deleteFlag", EHRConstants.DELETE_FLG_0));
			if (ObjectUtil.isNullOrEmpty(list)) {
				modelMap.addAttribute("addAllowed", false);
			}
		}
		if (!modelMap.containsKey("addAllowed")) {
			modelMap.addAttribute("addAllowed", true);
		}
		return "rhip.ep.iodate." + function + "Search";
	}

	@RequestMapping("/monitorList")
	public String monitorList(HttpServletRequest request, ModelMap modelMap, IodateQueryForm form, int indexPage) {
		if (hasRole(RoleType.ZXDFB, request)) {
			Organization org = getCurrentOrg(request);
			form.setGbCode(org.getGbCode());
			form.setCreateOrgan(org.getOrganCode());
		}
		Page page = super.getPage(request, indexPage); 
		PageList<SaltMonitorRecord> pageList = iodateService.getMonitorPageList(page, form.toCriteria());
		modelMap.addAttribute("recordList", pageList.getList());
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("indexPage", indexPage);
		String thisYear = DateUtil.toFormatString("yyyy", new Date());
		modelMap.addAttribute("thisYear", thisYear);
		return "rhip.ep.iodate." + form.getFunction() + "List";
	}

	@RequestMapping("/viewMonitorRecord")
	public String viewMonitorRecord(HttpServletRequest request, ModelMap modelMap, String functionCode, Long id) {
		SaltMonitorRecord record = iodateService.getMonitorRecord(new Criteria("id", id));
		modelMap.addAttribute("record", record);
		List<SaltTestRecord> testList = iodateService.getTestRecords(new Criteria("monitorId", record.getId()));
		modelMap.addAttribute("surveyType", record.getSurveyType());
		modelMap.addAttribute("test", testList.get(0));
		modelMap.addAttribute("saltList", testList);
		modelMap.addAttribute("saltCount", testList.size());
		return "rhip.ep.iodate." + functionCode + "Detail";
	}

	@RequestMapping("/editMonitorRecord")
	public String editMonitorRecord(HttpServletRequest request, ModelMap modelMap, String functionCode, Long id, Integer surveyType) {
		SaltMonitorRecord record = iodateService.getMonitorRecord(new Criteria("id", id));
		List<SaltTestRecord> testList = null;
		if (record != null) {
			testList = iodateService.getTestRecords(new Criteria("monitorId", record.getId()));
			List<String[]> villages = getMonitorVillages(record.getGbCode());
			modelMap.addAttribute("villages", villages);
			modelMap.addAttribute("surveyType", record.getSurveyType());
		} else {
			record = new SaltMonitorRecord();
			record.setMonitorTime(new Date());
			modelMap.addAttribute("surveyType", surveyType);
		}
		if (ObjectUtil.isNullOrEmpty(testList)) {
			testList = new ArrayList<>();
			testList.add(new SaltTestRecord());
		}
		if (!"iodineContent".equals(functionCode)) {
			List<String[]> townList = getMonitorTowns(request, true);
			modelMap.addAttribute("townList", townList);
		}
		if (hasRole(RoleType.ZXDFB, request)) {
			modelMap.addAttribute("displayTest", "none");
		} else {
			modelMap.addAttribute("displayTest", "block");
		}
		modelMap.addAttribute("record", record);
		modelMap.addAttribute("test", testList.get(0));
		modelMap.addAttribute("saltList", testList);
		modelMap.addAttribute("saltCount", testList.size());
		return "rhip.ep.iodate." + functionCode + "Edit";
	}

	@RequestMapping("/saveMonitorRecord")
	@ResponseBody
	public ModelMap saveMonitorRecord(HttpServletRequest request, SaltMonitorRecord record) {
		ModelMap modelMap = new ModelMap();
		if (record.getGbCode() != null && record.getVillageCode() != null) {
			//关联抽样ID
			SaltSamplingRecord sample = iodateService.getSamplingRecord(new Criteria("gbCode", record.getGbCode()).add("villageCode", record.getVillageCode()));
			if (sample != null) {
				record.setSamplingId(sample.getId());
			}
		}
		beforeSave(request, record);
		EndemicPreventDTO endemicPreventDTO = VoUtil.getFormData(request, EndemicPreventDTO.class);
		List<SaltTestRecord> testRecords = endemicPreventDTO.getSaltTestRecords();
		//去除空数据
		Iterator<SaltTestRecord> itr = testRecords.iterator();
		while (itr.hasNext()) {
			SaltTestRecord str = itr.next();
			if (str == null) {
				itr.remove();
			}
		}
		if (ObjectUtil.isNotEmpty(testRecords)) {
			//冗余盐样编号
			record.setSaltSamplingNumber(testRecords.get(0).getSaltSamplingNumber());
		}
		try {
			int result = iodateService.saveMonitorRecord(record, testRecords);
			if (result == 1) {
				modelMap.addAttribute("success", true);
				modelMap.addAttribute("message", "保存成功！");
				if (record.getId() == null) {
					createOperationLog(request, RhipModuleName.EP, "地方病碘盐监测相关监测记录保存", OperationName.ADD);
				} else {
					createOperationLog(request, RhipModuleName.EP, "地方病碘盐监测相关监测记录保存", OperationName.UPDATE);
				}
			} else {
				modelMap.addAttribute("success", false);
				modelMap.addAttribute("message", "保存失败！");
			}
		} catch (Exception e) {
			modelMap.addAttribute("success", false);
			modelMap.addAttribute("message", e.getMessage());
		}
		return modelMap;
	}

	@RequestMapping("/deleteMonitorRecord")
	@ResponseBody
	public ModelMap deleteMonitorRecord(HttpServletRequest request, Long id) {
		ModelMap modelMap = new ModelMap();
		SaltMonitorRecord record = iodateService.getMonitorRecord(new Criteria("id", id));
		record.setDeleteFlag(EHRConstants.DELETE_FLG_1);
		beforeSave(request, record);
		try {
			int result = iodateService.deleteMonitorRecord(record);
			if (result != 0) {
				modelMap.addAttribute("success", true);
				modelMap.addAttribute("message", "删除成功！");
				createOperationLog(request, RhipModuleName.EP, "地方病碘盐监测相关监测记录删除", OperationName.DELETE);
			} else {
				modelMap.addAttribute("success", false);
				modelMap.addAttribute("message", "删除失败！");
			}
		} catch (Exception e) {
			modelMap.addAttribute("success", false);
			modelMap.addAttribute("message", e.getMessage());
		}
		return modelMap;
	}

	@RequestMapping("/getMonitorVillages")
	@ResponseBody
	public List<String[]> getMonitorVillages(String gbCode) {
		String year = DateUtil.toFormatString("yyyy", new Date());
		return iodateService.getSamplingVillages(year, gbCode);
	}

	@RequestMapping("/getMonitorTowns")
	@ResponseBody
	public List<String[]> getMonitorTowns(HttpServletRequest request, boolean thisYear) {
		if (request != null) {
			Organization org = getCurrentOrg(request);
			if (hasRole(RoleType.ZXDFB, request)) {
				Map<String, String> dicMap = dictionaryApp.queryDicItemMap(new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT));
				String[] town = {org.getGbCode(), dicMap.get(org.getGbCode())};
				List<String[]> list = new ArrayList<>();
				list.add(town);
				return list;
			} else {
				String year = null;
				if (thisYear) {
					year = DateUtil.toFormatString("yyyy", new Date());
				}
				return iodateService.getSamplingTowns(year);
			}
		}
		return null;
	}

	@RequestMapping("/getVillages")
	@ResponseBody
	public String getVillages(String gbCode) {
		Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code", gbCode);
		List<DicItem> list = dictionaryApp.queryDicItem(criteria);
		String html = "<tr>" +
				"<td>" +
				"<select name=\"EndemicPreventDTO.samplingRecords[index].villageCode\" style=\"width: 150px\" reg=\"{'required':'true'}\">" +
				"<option value=\"\">请选择</option>";
		for (DicItem item : list) {
			html += "<option value=\"" + item.getItemCode() + "\"}>" + item.getItemName() + "</option>";
		}
		html += "</select>" +
				"</td>" +
				"<td>"
				+ "<a title=\"删除\" class=\"layui-btn layui-btn-danger layui-btn-xs\" href=\"javascript:void(0)\" onclick=\"epSamplingEdit.deleteRecord(this)\" style=\"color: #FFF;font-size: 12px;\"><i class=\"layui-icon\">&#xe640;</i>删除</a>"
				+ "</td>" +
				"</tr>";
		return html;
	}

	private void beforeSave(HttpServletRequest request, Object entity) {
		BeanMap beanMap = BeanMap.create(entity);
		User user = getCurrentUser(request);
		Organization org = getCurrentOrg(request);
		Date date = new Date();
		if (beanMap.get("id") == null) {
			beanMap.put("createPerson", user.getUserName());
			beanMap.put("createOrgan", org.getOrganCode());
			beanMap.put("createTime", date);
			beanMap.put("gbCode", org.getGbCode());
		} else {
			beanMap.put("updatePerson", user.getUserName());
			beanMap.put("updateOrgan", org.getOrganCode());
			beanMap.put("updateTime", date);
		}
	}
}
