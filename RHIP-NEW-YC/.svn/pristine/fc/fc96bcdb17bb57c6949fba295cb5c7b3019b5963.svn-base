package com.founder.rhip.portal.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.founder.elb.common.MessageUtils;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.entity.control.idm.special.ListAs;
import com.founder.rhip.ehr.entity.portal.PollOption;
import com.founder.rhip.ehr.entity.portal.PollText;
import com.founder.rhip.ehr.entity.portal.SurveyRecord;
import com.founder.rhip.ehr.entity.portal.SurveyItem;
import com.founder.rhip.ehr.entity.portal.SurveyOption;
import com.founder.rhip.idm.controller.DateJsonValueProcessor;
import com.founder.rhip.portal.controller.form.SurveyForm;
import com.founder.rhip.portal.service.ISurveyRecordService;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

/**
 * 调查表管理
 */
@Controller
@RequestMapping("/survey")
public class SurveyController extends BaseController {

	@Resource(name="surveyRecordService")
	private ISurveyRecordService lhsurveyService;

	/**
	 * Search Home
	 */
	@RequestMapping("/search")
	public String search(Criteria criteria, HttpServletRequest request, Model model) {
		String result = "rhip.lhportal.survey.search";
		model.addAttribute("org", SecurityUtils.getCurrentOrganization(request));
		if("new".equalsIgnoreCase(request.getParameter("status"))){
			return result;
		}

		if(null != request.getSession().getAttribute("search.surveyForm")){
			SurveyForm surveyForm = (SurveyForm)request.getSession().getAttribute("search.SurveyForm");
			model.addAttribute("rhip.lhportal.surveyForm", surveyForm);
			request.getSession().removeAttribute("rhip.lhportal.search.SurveyForm");
		}

		return result;
	}

	@RequestMapping("/list")
	public String list(SurveyForm surveyForm, Model model, HttpServletRequest request) {
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);

		Criteria criteria = new Criteria();
		surveyForm.createCriteriaForSurvey(criteria);
		if (!hasRole(RoleType.ADMIN, request)){
			String organCode = SecurityUtils.getCurrentOrganization(request).getOrganCode();
			criteria.add("ORG_CODE",organCode);
		}
		PageList<SurveyRecord> plist = lhsurveyService.getSurveyList(page, criteria);
		model.addAttribute("surveies", plist.getList());
		model.addAttribute("page", plist.getPage());
		return "rhip.lhportal.survey.list";
	}

	/**
	 * 进入创建页面
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request, Model model, Long surveyId, String type) {
		SurveyRecord survey = new SurveyRecord();
		if(ObjectUtil.isNotEmpty(surveyId)) {
			survey = lhsurveyService.getSurvey(surveyId);
		}
		model.addAttribute("survey", survey);
//		编辑类型 是查看 see 编辑 edit
		model.addAttribute("type", type);
		return "rhip.lhportal.survey.add";
	}

	/**
	 * 进入调查问卷统计结果页面
	 */
	@RequestMapping("/poll")
	public String poll(HttpServletRequest request, Model model, Long surveyId, String type) {
		SurveyRecord survey = new SurveyRecord();
		if(ObjectUtil.isNotEmpty(surveyId)) {
			survey = lhsurveyService.getSurvey(surveyId);
		}
		if(type.equals("see")) {
			
			Criteria criteria = new Criteria();
			criteria.add("survey_Id", surveyId);
			Order order = new Order("order_num", true);
			List<SurveyItem> surveyItemList = lhsurveyService.getSurveyItemList(criteria, order);//surveyItem表的内容,调查表的问题编号和问题描述
			
			//查询某个问题的一个选项被选的次数
			List<PollOption> optionCountList = lhsurveyService.getOptionCountLists(criteria);
			//查询某个问题所有选项被选的次数
			List<PollOption> optionSumsList = lhsurveyService.optionCountByItemLists(criteria);
			
			//根据survey_id查相应的问题的radio,checkbox选项列表
			List<SurveyOption> surveyOptionLists = lhsurveyService.getSurveyOptionsByItemIdLists(criteria
					.add("label_type_code", OP.IN, new String[]{"radio","checkbox"}));
			
			//根据survey_id查相应的问题的text选项列表
			List<PollText> pollTextLists = lhsurveyService.getPollTextLists(
					new Criteria("survey_Id", surveyId).add("label_type_code", "text"));
			
			model.addAttribute("optionCount", optionCountList);
			model.addAttribute("optionSums", optionSumsList);
			model.addAttribute("surveyItemList", surveyItemList);
			model.addAttribute("surveyOptionLists", surveyOptionLists);
			model.addAttribute("pollTextLists", pollTextLists);
			
		}
		model.addAttribute("survey", survey);
//		编辑类型 是查看 see 编辑 edit
		model.addAttribute("type", type);
		return "rhip.lhportal.survey.poll";
	}
	
	/**
	 * 创建或者更新调查表：第一步-创建调查表和选择对象
	 */
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public void createSurvey(SurveyRecord survey, String type, HttpServletRequest request, HttpServletResponse response) {
		if(ObjectUtil.isNullOrEmpty(survey.getId())) {
			this.setBasicInfo(survey, request);
		}

		String surveyId = "";
		if (ObjectUtil.equals(type, "edit")) {
			surveyId = lhsurveyService.createSurvey(survey).toString();
		} else {
			surveyId = survey.getId().toString();
		}
		boolean result = false;
		if(ObjectUtil.isNotEmpty(surveyId)) {
			result = true;
		}

		MessageUtils.outputJSONResult(result ? surveyId : "fail", response);
	}

	@RequestMapping("/item/add")
	public String toSubmitSurvey(String surveyId, String type, String surveyStatus, Model model, HttpServletRequest request){
		Page page = super.getPage(request,  1, "/survey/surveyItems");
		Criteria criteria = new Criteria("surveyId" , surveyId);
		Order order = new Order("order_num", true);
		PageList<SurveyItem> pList = lhsurveyService.getSurveyItemList(page, criteria, order);

		model.addAttribute("surveyId", surveyId);
		model.addAttribute("surveyItems", pList.getList());
		model.addAttribute("page", pList.getPage());
		model.addAttribute("type", type);
		model.addAttribute("surveyStatus", surveyStatus);
		return "rhip.lhportal.survey.item.add";
	}

	/**
	 * 查询密切接触者列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/surveyItems")
	public String getSurveyItems(String surveyId, String pageIndex, HttpServletRequest request,ModelMap model) throws Exception {

		int currentPage = Integer.valueOf(pageIndex);
		Page page = super.getPage(request, currentPage);

		Criteria criteria = new Criteria("surveyId" , surveyId);
		Order order = new Order("order_num", true);
		PageList<SurveyItem> pList = lhsurveyService.getSurveyItemList(page, criteria, order);

		model.addAttribute("surveyItems", pList.getList());
		model.addAttribute("page", pList.getPage());
		return "rhip.lhportal.survey.item.list";
	}

	@RequestMapping("/option/add")
	public String addChild(String itemId,String trData, String rowIndex, String type, String labelTypeCode,
						   ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {

		this.setModel(trData, model, request);
		model.put("rowIndex", rowIndex);
		if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
			model.put("type", type);
		} else {
			model.put("type", "add");
		}
		model.put("labelTypeCode", labelTypeCode);
		return "rhip.lhportal.survey.option.add";
	}

	private void setModel(String trData, ModelMap model, HttpServletRequest request)  throws InstantiationException, IllegalAccessException {
		if (StringUtil.isNotEmpty(trData)) {
			List<SurveyOption> optionList = (List<SurveyOption>) json2Obj(trData, SurveyOption.class);
			model.put("option", optionList.get(0));
		}
	}

	/**
	 * 保存调查选项
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/item/save")
	public String saveItems(SurveyItem surveyItem, String optionListJson, String surveyStatus, HttpServletRequest request,ModelMap model) throws Exception {
		if(!ObjectUtil.isNotEmpty(surveyItem)){
			return EHRMessageUtil.returnMsg(model, "fail");
		}else {
			getListData(surveyItem, optionListJson);
			lhsurveyService.createSurveyItemsAndOptions(surveyItem, surveyStatus);
			createOperationLog(request, RhipModuleName.LHPORTAL, "调查表-调查项",OperationName.ADD);
			return EHRMessageUtil.returnMsg(model, "success");
		}
	}

	/**
	 * 子表数据处理
	 *
	 * @return
	 */
	private void getListData(SurveyItem surveyItem, String optionListJson) throws InstantiationException, IllegalAccessException {
		//选项－子表
		if (StringUtil.isNotEmpty(optionListJson)) {
			List<SurveyOption> surveyOptions = (List<SurveyOption>) json2Obj(optionListJson, SurveyOption.class);
			surveyItem.setSurveyOptions(surveyOptions);
		}
	}


	/**
	 * 调查选项详细
	 * type为edit时，可修改
	 * type为see时，可查看各选项的统计数量
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/itemDetail")
	public String getSurveyItemDetail(String id, String type, Integer indexPage, HttpServletRequest request, ModelMap model) throws Exception {
		SurveyItem surveyItem = lhsurveyService.getSurveyItem(new Criteria("id", id));
		model.addAttribute("surveyId", surveyItem.getSurveyId());
		model.put("surveyItem", surveyItem);
		model.addAttribute("type", type);
		return "rhip.lhportal.survey.item.detail";
	}

	/**
	 * 调查选项详细
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/optionDetail")
	public String getSurveyOptionDetail(String id, HttpServletRequest request,ModelMap model) throws Exception {
		SurveyOption surveyOption = lhsurveyService.getSurveyOption(new Criteria("id", id));
		model.put("surveyOption", surveyOption);
		return "rhip.lhportal.survey.option.detail";
	}

	/**
	 * 修改调查选项
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateItem")
	public String updateContacts(SurveyItem surveyItem, String optionListJson, String surveyStatus, HttpServletRequest request,ModelMap model) throws Exception {
		if(!ObjectUtil.isNotEmpty(surveyItem)){
			return EHRMessageUtil.returnMsg(model, "fail");
		}else {
			getListData(surveyItem, optionListJson);
			lhsurveyService.updateSurveyItem(surveyItem, surveyStatus);
			createOperationLog(request, RhipModuleName.LHPORTAL, "调查表-调查项",OperationName.UPDATE);
			return EHRMessageUtil.returnMsg(model, "success");
		}
	}

	/**
	 * 删除调查选项
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/deleteItem")
	public String deleteItems(Long id, HttpServletRequest request,ModelMap model) throws Exception {
		if(ObjectUtil.isNullOrEmpty(id)){
			return EHRMessageUtil.returnMsg(model, "fail");
		}else {
			SurveyItem surveyItem = lhsurveyService.getSurveyItem(new Criteria("id", id));
			if(surveyItem.getLabelTypeCode().equals("text")) {
				lhsurveyService.deletePollText(id);
			} else {
				lhsurveyService.deletePollOption(id);
			}
			lhsurveyService.deleteSurveyOption(id);
			lhsurveyService.deleteSurveyItem(id);
			createOperationLog(request, RhipModuleName.LHPORTAL, "调查表-调查项",OperationName.DELETE);
			return EHRMessageUtil.returnMsg(model, "success");
		}
	}

	@RequestMapping(value="/deleteOption")
	public String deleteOption(Long id, HttpServletRequest request,ModelMap model) throws Exception {
		if(ObjectUtil.isNullOrEmpty(id)){
			return EHRMessageUtil.returnMsg(model, "fail");
		}else {
			lhsurveyService.deleteOption(id);
			lhsurveyService.deletePollOption(id);
			createOperationLog(request, RhipModuleName.LHPORTAL, "调查表-调查项-选择项",OperationName.DELETE);
			return EHRMessageUtil.returnMsg(model, "success");
		}
	}

	/**
	 * json数组转成List
	 *
	 * @param jsonArrayStr
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static List<?> json2Obj(String jsonArrayStr, @SuppressWarnings("rawtypes") Class clazz) throws IllegalAccessException, InstantiationException {
		@SuppressWarnings("rawtypes")
		List resultList = new ArrayList();
		if (StringUtil.isNullOrEmpty(jsonArrayStr)) {
			return resultList;
		}
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy/MM/dd"));
		JSONArray jsonObjects = JSONArray.fromObject(jsonArrayStr, jsonConfig);
		String[] dateFormats = new String[]{"yyyy/MM/dd"};
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
		for (int i = 0; i < jsonObjects.size(); i++) {
			JSONObject jsonObj = (JSONObject) jsonObjects.get(i);
			Object obj = JSONObject.toBean(jsonObj, clazz);
			if(ObjectUtil.isNotEmpty(obj)){
				resultList.add(obj);
			}
		}
		return resultList;
	}

	/**
	 * json数组转成List
	 *
	 * @param jsonArrayStr
	 * @param clazz
	 * @return
	 */
	private static List<?> json2Obj(String jsonArrayStr, Class clazz, String orgCode, Long userId ,String singleId) throws IllegalAccessException, InstantiationException {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy/MM/dd"));
		JSONArray jsonObjects = JSONArray.fromObject(jsonArrayStr, jsonConfig);
		String[] dateFormats = new String[]{"yyyy/MM/dd"};
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
		List resultList = new ArrayList();
		for (int i = 0; i < jsonObjects.size(); i++) {
			JSONObject jsonObj = (JSONObject) jsonObjects.get(i);
			ListAs obj = (ListAs)JSONObject.toBean(jsonObj, clazz);
			obj.setIdmId(Long.parseLong(singleId));
			obj.setModifyDt(obj.getInspectDt());
			obj.setModifyUnit(orgCode);
			obj.setMofigyUser(userId.toString());
			resultList.add(obj);
		}
		return resultList;
	}

	/**
	 * 选择项
	 */
	@RequestMapping("/toOptions")
	public String toOptions() {
		String result = "rhip.lhportal.survey.toOptions";
		return result;
	}



	/**
	 * 开启和结束调查
	 */
	@RequestMapping("/updateStatus")
	public void updateStatus(HttpServletRequest request, HttpServletResponse response, Long surveyId,String surveyStatus) {
		int result = -1;
		result = lhsurveyService.updateStatus(surveyId, surveyStatus);
		MessageUtils.outputJSONResult(result >= 0 ? "success" : "fail", response);
	}

	private void setBasicInfo(SurveyRecord survey, HttpServletRequest request) {
		Date nowDate = new Date();
		survey.setSubmitTime(nowDate);
		survey.setOrgCode(this.getCurrentOrg(request).getOrganCode());
		survey.setUserCode(getCurrentUser(request).getUserCode());
		survey.setCount(0);
	}
}