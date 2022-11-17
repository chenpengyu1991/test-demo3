package com.founder.rhip.idm.controller.leprosy;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.CaseInformation;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.GeneralCondition;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmStatusInfo;
import com.founder.rhip.ehr.entity.control.idm.special.EventInfo;
import com.founder.rhip.ehr.entity.control.idm.special.ListCc;
import com.founder.rhip.ehr.entity.control.idm.special.ListCm;
import com.founder.rhip.ehr.entity.control.idm.special.ListFr;
import com.founder.rhip.idm.common.IdmType;
import com.founder.rhip.idm.common.LeprosyStatus;
import com.founder.rhip.idm.common.ListCmStatus;
import com.founder.rhip.idm.common.SpecialEvents;
import com.founder.rhip.idm.controller.DateJsonValueProcessor;
import com.founder.rhip.idm.controller.form.LeprosyQueryForm;
import com.founder.rhip.idm.controller.form.ListCmForm;
import com.founder.rhip.idm.controller.form.ReportQueryForm;
import com.founder.rhip.idm.dto.LeprosySaveDto;
import com.founder.rhip.idm.dto.ReportDto;
import com.founder.rhip.idm.service.ILeprosyService;
import com.founder.rhip.idm.service.IReportService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.Organization;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/idm/leprosy")
public class SuspectedController extends BaseController {

	@Resource(name = "leprosyService")
	private ILeprosyService leprosyService;
	
	@Autowired
    private IDictionaryApp dictionaryApp;
	
	@Resource(name = "reportService")
	private IReportService reportService;
	
	/**
	 * 进入麻风首页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request, ModelMap model) {
		model.put("pageIndex", 1);
		return "rhip.idm.leprosy.index";
	}
	
	@RequestMapping("/count")
    public String getNotReportLeprosyCount(HttpServletRequest request, ModelMap model) {
		/*直报传染病中为麻风病切没有进行麻风疑似上报的患者*/
		Criteria criteria = this.getCriteriaNotReportLeprosy(request);
		return EHRMessageUtil.returnMsg(model, leprosyService.getNotReportLeprosyCount(criteria));
    }
	
    /**
     * 麻风疑似报卡列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/suspected/list")
    public String searchSuspectedList(LeprosyQueryForm form, HttpServletRequest request, ModelMap model) {
    	
    	String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria criteria = form.getCriteria();
		/*获取唯一事件编码*/
		criteria.add("EVENT_ID", OP.IN, new String[]{SpecialEvents.L_SUSPECTED.getValue()});
		getStatusCriteriaForSuspected(form, criteria);
		getRoleCriteria(criteria, request);//权限
		Order order = new Order("caseInfo.REVIEW_RESULT", false);
		order.desc("caseInfo.MODIFY_SURVEY_DATE");
		PageList<IdmStatusInfo> plist = leprosyService.findSuspectedList(page, criteria,order);
		model.addAttribute("suspecteds", plist.getList());
		model.addAttribute("page", plist.getPage());
		/*直报传染病中为麻风病切没有进行麻风疑似上报的患者*/
		Criteria criterias = this.getCriteriaNotReportLeprosy(request);
		model.addAttribute("notReportLeprosyCount", leprosyService.getNotReportLeprosyCount(criterias));
        return "rhip.idm.leprosy.suspected.list";
    }
    
    @RequestMapping("/case/search")
    public String caseSearch(HttpServletRequest request, ModelMap model) {
        return "rhip.idm.leprosy.case.search";
    }
	
    /**
     * 麻风个案列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/case/list")
    public String searchCaseList(LeprosyQueryForm form, HttpServletRequest request, ModelMap model) {
    	
    	String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria criteria = form.getCriteria();
		/*获取唯一事件编码*/
		criteria.add("EVENT_ID", OP.IN, new String[]{SpecialEvents.L_SUSPECTED.getValue()/*,SpecialEvents.L_CASE.getValue()*/ });
		getStatusCriteriaForCase(form, criteria);
		/*获取确诊为麻风的患者*/
		criteria.add("caseInfo.REVIEW_RESULT", "6");
		Order order = new Order("status.logoff", true);
		order.asc("status.SPECIAL_STATUS");
		order.desc("caseInfo.MODIFY_SURVEY_DATE");
		criteria.add("caseInfo.MODIFY_SURVEY_ORG", getCurrentOrg(request).getOrganCode());//权限
		PageList<IdmStatusInfo> plist = leprosyService.findSuspectedList(page, criteria, order);
		model.addAttribute("cases", plist.getList());
		model.addAttribute("page", plist.getPage());
        return "rhip.idm.leprosy.case.list";
    }


    @RequestMapping("/followup/search")
    public String followupSearch(HttpServletRequest request, ModelMap model) {
        return "rhip.idm.leprosy.followup.search";
    }
	
    /**
     * 麻风随访列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/followup/list")
    public String searchFollowupList(LeprosyQueryForm form, HttpServletRequest request, ModelMap model) {
    	
    	String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria criteria = form.getCriteria();
		/*获取唯一事件编码*/
		criteria.add("EVENT_ID", OP.IN, new String[]{SpecialEvents.L_SUSPECTED.getValue()});
		criteria.add("caseInfo.REVIEW_RESULT", OP.IN, new String[]{"6","7"});
		Order order = new Order("status.logoff", true);
		order.desc("caseInfo.MODIFY_SURVEY_DATE");
        criteria.add("caseInfo.MODIFY_SURVEY_ORG", getCurrentOrg(request).getOrganCode());//权限

        PageList<IdmStatusInfo> plist = leprosyService.findSuspectedList(page, criteria, order);
		model.addAttribute("followups", plist.getList());
		model.addAttribute("page", plist.getPage());
        return "rhip.idm.leprosy.followup.list";
    }
    
    @RequestMapping("/contact/search")
    public String contactSearch(HttpServletRequest request, ModelMap model) {
        return "rhip.idm.leprosy.contact.search";
    }
	
    /**
     * 麻风密切接触者列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/contact/list")
    public String searchContactList(LeprosyQueryForm form, HttpServletRequest request, ModelMap model) {
    	
    	String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria criteria = form.getCriteria();
		/*获取唯一事件编码*/
		criteria.add("EVENT_ID", OP.IN, new String[]{SpecialEvents.L_SUSPECTED.getValue()/*,SpecialEvents.L_CASE.getValue()*/});
		criteria.add("caseInfo.REVIEW_RESULT", "6");
		Order order = new Order("status.logoff", true);
		order.desc("caseInfo.MODIFY_SURVEY_DATE");
		criteria.add("caseInfo.MODIFY_SURVEY_ORG", getCurrentOrg(request).getOrganCode());//权限
		PageList<IdmStatusInfo> plist = leprosyService.findSuspectedList(page, criteria, order);
		model.addAttribute("contacts", plist.getList());
		model.addAttribute("page", plist.getPage());
        return "rhip.idm.leprosy.contact.list";
    }
    
    
    /**
     * 进入麻风添加页面
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/init")
    public String initAdd(String singleId, Integer specialStatus, String type, String pageIndex, ModelMap model, HttpServletRequest request) {
    	LeprosySaveDto leprosySaveDto = new LeprosySaveDto();
    	if(StringUtil.isNotEmpty(singleId)) {
    		if(ObjectUtil.equals(specialStatus, LeprosyStatus.CASE.getValue())) {
    			EventInfo eventInfo = leprosyService.findEventInfo(singleId);
    			if(ObjectUtil.isNotEmpty(eventInfo.getId())) {
    				singleId = eventInfo.getId().toString();
    			}
    		}
    		leprosySaveDto = leprosyService.getLeprosySaveDto(singleId);
    	}
    	if (StringUtils.equals(type, "1")) {
    		leprosySaveDto.setSpecialStatus(specialStatus);
    		this.setCurrentUser(leprosySaveDto, request);
    	}

        model.addAttribute("leprosySaveDto", leprosySaveDto);
        model.addAttribute("listCmForm", new ListCmForm().getListCmForm(leprosySaveDto.getListCms()));
        model.put("type", type);
        model.put("statusId", "");
        model.put("pageIndex", pageIndex);
        return LeprosyLayoutMap.getLayoutStr(specialStatus);
    }
    
    private Criteria getCriteriaNotReportLeprosy(HttpServletRequest request) {
    	/*直报传染病中为麻风病切没有进行麻风疑似上报的患者*/
		Criteria criteria = new Criteria("status.idm_type", IdmType.LEGAL.getValue());
		criteria.add("re.fill_organ_code", getCurrentOrg(request).getOrganCode());
		criteria.add("re.infectious_code", "305");//麻风病编码
		criteria.add("status.SPECIAL_STATUS", OP.IS, "NULL");
		return criteria;
    }
    /**
     * 新增麻风病专项
     * @param leprosySaveDto
     * @param type
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    public String saveLeprosySaveDto(LeprosySaveDto leprosySaveDto, ListCmForm listCmForm, int type, Long statusId, HttpServletRequest request, ModelMap model)  throws Exception {
    	boolean result = false;
    	leprosySaveDto.setListCms(this.getListCm(listCmForm, leprosySaveDto.getSingleId()));
    	String actionName = getActionName(leprosySaveDto.getSpecialStatus());
		if(ObjectUtil.isNotEmpty(leprosySaveDto)){
			GeneralCondition generalCondition = leprosySaveDto.getGeneralCondition();
			boolean flag = ObjectUtil.isNotEmpty(generalCondition.getFloatPopulation()) && generalCondition.getFloatPopulation().equalsIgnoreCase("1");
			generalCondition.setPaAddress(flag
                    ? dictionaryApp.queryDicItemName("FS990001", generalCondition.getPatownShip()) + dictionaryApp.queryDicItemName("FS990001", generalCondition.getPastreet()) + generalCondition.getPahouseNumber()
                    : generalCondition.getPahouseNumber());
			generalCondition.setHrAddress(flag
                    ? dictionaryApp.queryDicItemName("FS990001", generalCondition.getHrtownShip()) + dictionaryApp.queryDicItemName("FS990001", generalCondition.getHrstreet()) + generalCondition.getHrhouseNumber()
                    : generalCondition.getHrhouseNumber());
			if(null != statusId && statusId >0) {
				//在直报中 传染病是麻风  若入口是从直报的数据初始化
				leprosyService.updateSpecialStatus(statusId, "1");
			}
            /*获取PERSON_ID modify by yjf 20140107*/
        	Long personId = leprosyService.getPersonId(leprosySaveDto.getIdmId());
        	leprosySaveDto.setPersonId(personId);				
			if(type == 1){//新增
				this.setCurrentUser(leprosySaveDto, request);
				User user = this.getCurrentUser(request);
				Organization org = this.getCurrentOrg(request);
			
				leprosySaveDto.getPersonInfo().setUpdateOrganCode(org.getOrganCode());
				leprosySaveDto.getPersonInfo().setUpdateOrganName(org.getOrganName());
				leprosySaveDto.getPersonInfo().setUpdateIdcard(user.getIdentityCard());
				leprosySaveDto.getPersonInfo().setUpdateName(user.getName());
				leprosySaveDto.getPersonInfo().setUpdateDate(new Date());
				result = leprosyService.saveLeprosySaveDto(leprosySaveDto, leprosySaveDto.getEventId(), null);
				createOperationLog(request, RhipModuleName.IDM, actionName, OperationName.ADD);
			} else {//更新
				result = leprosyService.updateLeprosySaveDto(leprosySaveDto);
				createOperationLog(request, RhipModuleName.IDM, actionName, OperationName.UPDATE);
			}
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }
    
    /**
     * 根据状态获取麻风病专项的哪一步
     * @param specialStatus
     * @return
     */
    private String getActionName(Integer specialStatus) {
    	if(specialStatus == LeprosyStatus.SUSPECTED.getValue()) {
    		return "麻风病专项-疑似上报";
    	} else if (specialStatus == LeprosyStatus.CASE.getValue()) {
    		return "麻风病专项-个案";
    	} else if (specialStatus == LeprosyStatus.FOLLOWUP.getValue()) {
    		return "麻风病专项-随访";
    	}
    	return "麻风病专项";
    }
    
    /**
     * 进入随访页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/initFollowup")
    public String initFollowups(Long singleId, String pageIndex, Integer logoff, HttpServletRequest request, ModelMap model) throws Exception {

        Criteria ca = new Criteria("IDM_ID",singleId);
        Order od = new Order("VISIT_DT",false);//正序

        Page page = super.getPage(request,  1, "/idm/leprosy/followupList");
        PageList<ListFr> listFr = leprosyService.getFrList(page, ca, od);
        GeneralCondition generalCondition = leprosyService.findGeneralCondition(singleId);
        request.getSession().setAttribute("patientNameF", generalCondition.getName());
        model.put("listFrs", listFr.getList());
        model.put("page", listFr.getPage());
        model.put("idmId", singleId);
        model.put("logoff", logoff);
        model.put("caseInformation", leprosyService.findCaseInformation(singleId));
        model.put("pageIndex", pageIndex);
        model.put("nowDate", new Date());
        model.put("nowDateStr", DateUtil.toDateString(new Date(), "yyyy/MM/dd"));
        return "rhip.idm.leprosy.followups";
    }

    /**
     * 查询随访列表
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/followupList")
    public String getFollowups(String singleId, String pageIndex, HttpServletRequest request, ModelMap model) throws Exception {

        Criteria ca = new Criteria("IDM_ID",singleId);
        Order od = new Order("VISIT_DT",false);//正序

        int currentPage = Integer.valueOf(pageIndex);
        Page page = super.getPage(request, currentPage);

        PageList<ListFr> listFr = leprosyService.getFrList(page, ca, od);

        model.put("listFrs", listFr.getList());
        model.put("page", listFr.getPage());
        return "rhip.idm.leprosy.followupList";
    }

    /**
     * 添加随访
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/followup/save")
    public String addFollowup(ListFr listFr, String pageIndex, HttpServletRequest request, ModelMap model) throws Exception {
        if(!ObjectUtil.isNotEmpty(listFr)){
            return EHRMessageUtil.returnMsg(model, "fail");
        }else {
            leprosyService.saveFr(listFr, getCurrentUser(request).getId().toString());
            createOperationLog(request, RhipModuleName.IDM, "麻风病专项-随访", OperationName.ADD);
            return EHRMessageUtil.returnMsg(model, "success");
        }
    }


    /**
     * 随访详细
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/followupDetail")
    public String followupDetail(String id, String pageIndex, HttpServletRequest request, ModelMap model) throws Exception {
        ListFr listFr = leprosyService.getFr(Long.parseLong(id));
        model.put("listFr", listFr);
        model.put("idmId", listFr.getIdmId());
        model.put("id", listFr.getId());
        model.put("caseInformation", leprosyService.findCaseInformation(listFr.getIdmId()));
        
        return "rhip.idm.leprosy.followupDetail";
    }

    /**
     * 修改随访
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/followupUpdate")
    public String updateFollowups(ListFr listFr, String pageIndex, HttpServletRequest request, ModelMap model) throws Exception {
        if(!ObjectUtil.isNotEmpty(listFr)){
            return EHRMessageUtil.returnMsg(model, "fail");
        }else {
        	String listCcJson = listFr.getListCcJson();
            if (StringUtil.isNotEmpty(listCcJson)) {
                List<ListCc> listCc = (List<ListCc>) json2Obj(listCcJson, ListCc.class);
                listFr.setListCcs(listCc);
            }
            leprosyService.updateFr(listFr, getCurrentUser(request).getId().toString());
            createOperationLog(request, RhipModuleName.IDM, "麻风病专项-随访", OperationName.UPDATE);
            return EHRMessageUtil.returnMsg(model, "success");
        }
    }

    /**
     * 删除随访
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/deleteFollowup")
    public String deleteFollowups(String id, String pageIndex, HttpServletRequest request, ModelMap model) throws Exception {
        if(!StringUtil.isNotEmpty(id)){
            return EHRMessageUtil.returnMsg(model, "fail");
        }else {
            leprosyService.deleteFr(Long.parseLong(id));
            createOperationLog(request, RhipModuleName.IDM, "麻风病专项-随访", OperationName.DELETE);
            return EHRMessageUtil.returnMsg(model, "success");
        }
    }
    
    /**
     * 规范化管理中的子页面添加
     * @param trData
     * @param rowIndex
     * @param type
     * @param pageIndex
     * @param model
     * @param request
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @RequestMapping("/followup/contact/add")
    public String addChild(String followupId, String trData, String rowIndex, String type, String pageIndex,
                           ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
    	
    	model.put("rowIndex", rowIndex);
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
            List<ListCc> idmListSdList = (List<ListCc>) json2Obj(trData, ListCc.class);
            model.put("contact", idmListSdList.get(0));
        } else {
            model.put("type", "add");
            model.put("contact", null);
        }
    	model.put("pageIndex", pageIndex);
    	model.put("followupId", followupId);
    	model.put("nowDate", new Date());
        return "rhip.idm.leprosy.followup.contact.add";
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
     * 进入随访页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/initContact")
    public String initContacts(Long singleId, String pageIndex, Integer logoff, HttpServletRequest request, ModelMap model) throws Exception {

        Criteria ca = new Criteria("IDM_ID",singleId);
        Order od = new Order("regist_dt",false);//正序
        Page page = super.getPage(request,  1, "/idm/leprosy/contactList");
        PageList<ListCc> listCc = leprosyService.getCcList(page, ca, od);
        GeneralCondition generalCondition = leprosyService.findGeneralCondition(singleId);
        
        model.put("generalCondition", generalCondition);
        model.put("listCcs", listCc.getList());
        model.put("page", listCc.getPage());
        model.put("idmId", singleId);
        model.put("logoff", logoff);
        model.put("pageIndex", pageIndex);
        return "rhip.idm.leprosy.contacts";
    }
    
    /**
     * 查询密切接触者列表
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/contactList")
    public String getContacts(Long singleId, String pageIndex, HttpServletRequest request, ModelMap model) throws Exception {

        Criteria ca = new Criteria("IDM_ID",singleId);
        Order od = new Order("REGIST_DT",false);//正序

        int currentPage = Integer.valueOf(pageIndex);
        Page page = super.getPage(request, currentPage);
        PageList<ListCc> listCc = leprosyService.getCcList(page, ca, od);
        
        model.put("listCcs", listCc.getList());
        model.put("page", listCc.getPage());
        model.put("idmId", singleId);
        return "rhip.idm.leprosy.contactList";
    }


    /**
     * 密切接触者详细
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/contact/add")
    public String addContact(Long singleId, Long id, String pageIndex, String type, HttpServletRequest request, ModelMap model) throws Exception {
    	ListCc listCc = new ListCc();
    	if(id != null) {
        	listCc = leprosyService.getCc(id);
        }
    	GeneralCondition generalCondition = leprosyService.findGeneralCondition(singleId);
    	model.put("generalCondition", generalCondition);
        model.put("listCc", listCc);
        model.put("idmId", singleId);
        model.put("type", type);
        return "rhip.idm.leprosy.contactDetail";
    }
    
    /**
     * 添加密切接触者
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/contact/save")
    public String addContact(ListCc listCc, String pageIndex, HttpServletRequest request, ModelMap model) throws Exception {
        if(!ObjectUtil.isNotEmpty(listCc)){
            return EHRMessageUtil.returnMsg(model, "fail");
        }else {
            leprosyService.saveCc(listCc);
            createOperationLog(request, RhipModuleName.IDM, "麻风病专项-密切接触者", OperationName.ADD);
            return EHRMessageUtil.returnMsg(model, "success");
        }
    }

    /**
     * 修改密切接触者
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/contact/update")
    public String updateContact(ListCc listCc, String pageIndex, HttpServletRequest request, ModelMap model) throws Exception {
        if(!ObjectUtil.isNotEmpty(listCc)){
            return EHRMessageUtil.returnMsg(model, "fail");
        }else {
            leprosyService.updateCc(listCc);
            createOperationLog(request, RhipModuleName.IDM, "麻风病专项-密切接触者", OperationName.UPDATE);
            return EHRMessageUtil.returnMsg(model, "success");
        }
    }

    /**
     * 删除密切接触者
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/contact/delete")
    public String deleteContact(String id, String pageIndex, HttpServletRequest request, ModelMap model) throws Exception {
        if(!StringUtil.isNotEmpty(id)){
            return EHRMessageUtil.returnMsg(model, "fail");
        }else {
            leprosyService.deleteCc(Long.parseLong(id));
            createOperationLog(request, RhipModuleName.IDM, "麻风病专项-密切接触者", OperationName.DELETE);
            return EHRMessageUtil.returnMsg(model, "success");
        }
    }
    
    /**
     * 初始化加载 直报传染病中为麻风病切没有进行麻风疑似上报的患者的查询页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/initNotReport")
    public String initNotReport(HttpServletRequest request, ModelMap model) {
        return "rhip.idm.leprosy.notReport.search";
    }
	
    /**
     * 初始化加载 直报传染病中为麻风病切没有进行麻风疑似上报的患者的列表页面
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/notReport/list")
    public String searchNotReportList(ReportQueryForm form, ModelMap model, HttpServletRequest request) {
    	String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Criteria ca = form.getCriteria();
		
		/*直报传染病中为麻风病切没有进行麻风疑似上报的患者*/
		Criteria criteria = new Criteria("S.idm_type", IdmType.LEGAL.getValue());
		criteria.add("D.fill_organ_code", getCurrentOrg(request).getOrganCode());
		criteria.add("D.infectious_code", "305");//麻风病编码
		criteria.add("S.SPECIAL_STATUS", OP.IS, "NULL");
		ca.add(criteria);
		
		Page page = super.getPage(request, currentPage);
		PageList<IdmReport> plist = reportService.findReport(ca,page);
		model.addAttribute("reports", plist.getList());
		model.addAttribute("page", plist.getPage());
        return "rhip.idm.leprosy.notReport.list";
    }
    
    @RequestMapping("/notReport/add")
    public String addNotReport(Integer reportId, Integer statusId, Integer pageIndex, ModelMap model, HttpServletRequest request) {
    	LeprosySaveDto leprosySaveDto = new LeprosySaveDto();
    	ReportDto reportDto = reportService.getReport(reportId);
    	if(ObjectUtil.isNotEmpty(reportDto.getReport())) {
    		IdmReport idmReport = reportDto.getReport();
    		GeneralCondition generalCondition = new GeneralCondition();
    		generalCondition.setName(idmReport.getName());
    		generalCondition.setGender(idmReport.getGender());
    		generalCondition.setBirthday(idmReport.getBirthday());
    		generalCondition.setPhoneNumber(idmReport.getPhoneNumber());
    		generalCondition.setOccupation(idmReport.getOccupation());
    		generalCondition.setOccupationOther(idmReport.getOccupationOther());
    		generalCondition.setEducation(idmReport.getEducation());
    		generalCondition.setPatownShip(idmReport.getPatownShip());
    		generalCondition.setPastreet(idmReport.getPastreet());
    		generalCondition.setPahouseNumber(idmReport.getPahouseNumber());
    		leprosySaveDto.setGeneralCondition(generalCondition);
    	}
		leprosySaveDto.setSpecialStatus(LeprosyStatus.SUSPECTED.getValue());
		CaseInformation caseInformation = leprosySaveDto.getCaseInformation();
        if (ObjectUtil.isNullOrEmpty(caseInformation)) {
        	caseInformation = new CaseInformation();
        }
        Long userId = getCurrentUser(request).getId();
        caseInformation.setModifyRespondents(String.valueOf(userId));
        caseInformation.setModifySurveyOrg(getCurrentOrg(request).getOrganCode());
        caseInformation.setModifySurveyDate(new Date());
        caseInformation.setAcceptTown(getCurrentOrg(request).getGbCode());
        leprosySaveDto.setCaseInformation(caseInformation);
    	
        model.addAttribute("leprosySaveDto", leprosySaveDto);
        model.put("pageIndex", pageIndex);
        model.put("statusId", statusId);
        return "rhip.idm.leprosy.suspected.add";
    }
    /**
     * 页面初始化时 进行一些关于用户信息的加载
     */
    private void setCurrentUser(LeprosySaveDto leprosySaveDto, HttpServletRequest request) {
    	/*根据当前用户，设置页面中的调查机构*/
        CaseInformation caseInformation = leprosySaveDto.getCaseInformation();
        if (ObjectUtil.isNullOrEmpty(caseInformation)) {
        	caseInformation = new CaseInformation();
        }
        Long userId = getCurrentUser(request).getId();
        caseInformation.setModifyRespondents(String.valueOf(userId));
        caseInformation.setModifySurveyOrg(getCurrentOrg(request).getOrganCode());
        caseInformation.setModifySurveyDate(new Date());
        caseInformation.setAcceptTown(getCurrentOrg(request).getGbCode());
        leprosySaveDto.setCaseInformation(caseInformation);
    }
    
    /**
	 * 获取查询权限条件
	 * @return
	 */
	private void getRoleCriteria(Criteria criteria, HttpServletRequest request) {
		criteria.add("caseInfo.MODIFY_SURVEY_ORG", getCurrentOrg(request).getOrganCode());//权限
	}
	
	/**
	 * 疑似上报是否处理 形成查询条件
	 * @param form
	 * @param criteria
	 */
	private void getStatusCriteriaForSuspected(LeprosyQueryForm form, Criteria criteria) {
		String specialStatus = form.getStatus();
    	if (StringUtils.isNotBlank(specialStatus)){
    		if(StringUtils.equals(specialStatus, "1")) {
    			criteria.add("caseInfo.REVIEW_RESULT", OP.IS, "NUll");
    		} else if(StringUtils.equals(specialStatus, "2")){
    			criteria.add("caseInfo.REVIEW_RESULT", OP.UEMPTY, "");
    		}
    	}
	}
	
	/**
	 * 个案是否处理 形成查询条件
	 * @param form
	 * @param criteria
	 */
	private void getStatusCriteriaForCase(LeprosyQueryForm form, Criteria criteria) {
		String specialStatus = form.getStatus();
    	if (StringUtils.isNotBlank(specialStatus)){
    		criteria.add("status.SPECIAL_STATUS", specialStatus);
    	}
	}
	
	/**
	 * 获取临床表现-列表
	 * @param listCmForm
	 * @param idmId
	 * @return
	 */
	public List<ListCm> getListCm(ListCmForm listCmForm, Long idmId) {
		List<ListCm> listCms = new ArrayList<ListCm>();
		if(ObjectUtil.isNullOrEmpty(listCmForm)) {
			return listCms;
		}
		ListCm listCmR = new ListCm();
		ListCm listCmH = new ListCm();
		ListCm listCmT = new ListCm();
		//粗度
		listCmR.setId(listCmForm.getIdRough());
		listCmR.setIdmId(idmId);
		listCmR.setDegreeType(ListCmStatus.ROUGH.getValue());
		listCmR.setEyeLeft(listCmForm.getEyeLeftRough());
		listCmR.setEyeRight(listCmForm.getEyeRightRough());
		listCmR.setEarLeft(listCmForm.getEarLeftRough());
		listCmR.setEarRight(listCmForm.getEarRightRough());
		listCmR.setRuleLeft(listCmForm.getRuleLeftRough());
		listCmR.setRuleRight(listCmForm.getRuleRightRough());
		listCmR.setOarLeft(listCmForm.getOarLeftRough());
		listCmR.setOarRight(listCmForm.getOarRightRough());
		listCmR.setCenterLeft(listCmForm.getCenterLeftRough());
		listCmR.setCenterRight(listCmForm.getCenterRightRough());
		listCmR.setPeronealLeft(listCmForm.getPeronealLeftRough());
		listCmR.setPeronealRight(listCmForm.getPeronealRightRough());
		listCmR.setLegLeft(listCmForm.getLegLeftRough());
		listCmR.setLegRight(listCmForm.getLegRightRough());
		listCmR.setOtherLeft(listCmForm.getOtherLeftRough());
		listCmR.setOtherRight(listCmForm.getOtherRightRough());
		
		//硬度
		listCmH.setId(listCmForm.getIdHard());
		listCmH.setIdmId(idmId);
		listCmH.setDegreeType(ListCmStatus.HARD.getValue());
		listCmH.setEyeLeft(listCmForm.getEyeLeftHard());
		listCmH.setEyeRight(listCmForm.getEyeRightHard());
		listCmH.setEarLeft(listCmForm.getEarLeftHard());
		listCmH.setEarRight(listCmForm.getEarRightHard());
		listCmH.setRuleLeft(listCmForm.getRuleLeftHard());
		listCmH.setRuleRight(listCmForm.getRuleRightHard());
		listCmH.setOarLeft(listCmForm.getOarLeftHard());
		listCmH.setOarRight(listCmForm.getOarRightHard());
		listCmH.setCenterLeft(listCmForm.getCenterLeftHard());
		listCmH.setCenterRight(listCmForm.getCenterRightHard());
		listCmH.setPeronealLeft(listCmForm.getPeronealLeftHard());
		listCmH.setPeronealRight(listCmForm.getPeronealRightHard());
		listCmH.setLegLeft(listCmForm.getLegLeftHard());
		listCmH.setLegRight(listCmForm.getLegRightHard());
		listCmH.setOtherLeft(listCmForm.getOtherLeftHard());
		listCmH.setOtherRight(listCmForm.getOtherRightHard());
		
		//触压痛
		listCmT.setId(listCmForm.getIdTouch());
		listCmT.setIdmId(idmId);
		listCmT.setDegreeType(ListCmStatus.TOUCH.getValue());
		listCmT.setEyeLeft(listCmForm.getEyeLeftTouch());
		listCmT.setEyeRight(listCmForm.getEyeRightTouch());
		listCmT.setEarLeft(listCmForm.getEarLeftTouch());
		listCmT.setEarRight(listCmForm.getEarRightTouch());
		listCmT.setRuleLeft(listCmForm.getRuleLeftTouch());
		listCmT.setRuleRight(listCmForm.getRuleRightTouch());
		listCmT.setOarLeft(listCmForm.getOarLeftTouch());
		listCmT.setOarRight(listCmForm.getOarRightTouch());
		listCmT.setCenterLeft(listCmForm.getCenterLeftTouch());
		listCmT.setCenterRight(listCmForm.getCenterRightTouch());
		listCmT.setPeronealLeft(listCmForm.getPeronealLeftTouch());
		listCmT.setPeronealRight(listCmForm.getPeronealRightTouch());
		listCmT.setLegLeft(listCmForm.getLegLeftTouch());
		listCmT.setLegRight(listCmForm.getLegRightTouch());
		listCmT.setOtherLeft(listCmForm.getOtherLeftTouch());
		listCmT.setOtherRight(listCmForm.getOtherRightTouch());

		if(ObjectUtil.isNotEmpty(listCmR)) {
			listCms.add(listCmR);
		}
		if(ObjectUtil.isNotEmpty(listCmH)) {
			listCms.add(listCmH);
		}
		if(ObjectUtil.isNotEmpty(listCmT)) {
			listCms.add(listCmT);
		}
		return listCms;
	}
}
