package com.founder.rhip.portal.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.entity.portal.Poll;
import com.founder.rhip.ehr.entity.portal.PollOption;
import com.founder.rhip.ehr.entity.portal.PollText;
import com.founder.rhip.ehr.entity.portal.Survey;
import com.founder.rhip.ehr.entity.portal.SurveyItem;
import com.founder.rhip.ehr.entity.portal.SurveyOption;
import com.founder.rhip.portal.common.DateJsonValueProcessor;
import com.founder.rhip.portal.common.OperationName;
import com.founder.rhip.portal.common.SurveyStatus;
import com.founder.rhip.portal.service.ISurveyService;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

@Controller
@RequestMapping(value="/survey")
public class SurveyController extends BaseController{

	@Resource(name="lhsurveyService")
	private ISurveyService lhsurveyService;
	
	@RequestMapping(value="/index")
	public String index(HttpServletRequest request, ModelMap model, Integer indexPage) {
		Page page = new Page(EHRConstants.PAGE_SIZE, indexPage);
		Criteria criteria = new Criteria();
		criteria.add("status", SurveyStatus.START.getValue());
		PageList<Survey> survetPageList = lhsurveyService.getSurveyList(page, criteria);
		model.addAttribute("surveyList", survetPageList.getList());
		model.addAttribute("page", survetPageList.getPage());
		model.addAttribute("operation", "surveyInfoClick");
		return "lhportal.survey.index";
	}
	
	@RequestMapping(value="/surveyDetail")
	public String surveyDetail(HttpServletRequest request, ModelMap model) {
		Long id = Long.parseLong(request.getParameter("id"));
		Survey survey = lhsurveyService.getSurvey(id);//survey表的内容
		Criteria criteria = new Criteria();
		criteria.add("surveyId", id);
		Order order = new Order("order_num", true);
		List<SurveyItem> surveyItemList = lhsurveyService.getSurveyItemList(criteria, order);//surveyItem表的内容,调查表的问题编号和问题描述
		ArrayList<SurveyOption> surveyOptionLists = new ArrayList<SurveyOption>();
		if(surveyItemList != null && surveyItemList.size() > 0) {
			for(int i = 0; i < surveyItemList.size();  i++) {//遍历surveyItem表，通过获取itemId值来获取SurveyOption表中itemId值的内容
				Long itemId = surveyItemList.get(i).getId();
				criteria = new Criteria();
				criteria.add("itemId", itemId);
				Order order1 = new Order("id", true);
				List<SurveyOption> surveyOptionList = lhsurveyService.getSurveyOptionList(criteria, order1);//surveyOption表的内容,每个调查问题下的选项值
				surveyOptionLists.addAll(surveyOptionList);
			}
		}
		model.addAttribute("survey", survey);
		model.addAttribute("surveyItemList", surveyItemList);
		model.addAttribute("surveyOptionLists", surveyOptionLists);
		model.addAttribute("operation", "surveyInfoClick");
		return "lhportal.survey.surveyDetail";
	}
	
	@RequestMapping(value="/addPoll")
	@ResponseBody
	public ModelMap addPoll(HttpServletRequest request, Long surveyId, Poll poll, String optionListJson) throws InstantiationException, IllegalAccessException {
		ModelMap model = new ModelMap();
		this.getListData(poll, optionListJson);
		poll.setIsFinished("1");
		poll.setIsAnonymous("1");//匿名
		poll.setRecordDate(new Date());
		if (lhsurveyService.createPoll(poll) > 0) {
			Survey survey = lhsurveyService.getSurvey(surveyId);
			Integer count = survey.getCount();
			count++;//参与人数加1
			survey.setCount(count);
			lhsurveyService.updateSurvey(survey);
			createOperationLog(request, RhipModuleName.LHPORTAL, "addPoll", OperationName.ADD_SURVEY);
			model.addAttribute("msg", "提交成功，谢谢答卷！");
			model.addAttribute("success", true);
		} else {
			model.addAttribute("msg", "提交错误！");
			model.addAttribute("success", false);
		}
		return model;
	}

	
	private void getListData(Poll poll, String optionListJson) throws InstantiationException, IllegalAccessException {
		if (StringUtil.isNotEmpty(optionListJson)) {
			List<PollText> pollTexts = (List<PollText>) json2Obj(optionListJson, PollText.class);
        	List<PollOption> pollOptions = (List<PollOption>) json2Obj(optionListJson, PollOption.class);
        	List<PollText> PollTextLists = new ArrayList<PollText>();
        	List<PollOption> PollOptionLists = new ArrayList<PollOption>();
        	for(int i = 0; i < pollOptions.size(); i++) {
        		String labelTypeCode = pollOptions.get(i).getType();
        		if(labelTypeCode.equals("radio") || labelTypeCode.equals("checkbox")) {
        			PollOptionLists.add(pollOptions.get(i));
        			poll.setPollOptions(PollOptionLists);
        		}
        	}
        	for(int i = 0; i < pollTexts.size(); i++) {
        		String labelTypeCode = pollTexts.get(i).getType();
        		if(labelTypeCode.equals("text")) {
        			PollTextLists.add(pollTexts.get(i));
        			poll.setPollTexts(PollTextLists);
        		}
        	}
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
}
