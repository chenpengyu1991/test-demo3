package com.founder.rhip.idm.controller.statistics.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.control.idm.statistics.report.ListScDc;
import com.founder.rhip.ehr.entity.control.idm.statistics.report.SelfCheck;
import com.founder.rhip.idm.controller.DateJsonValueProcessor;
import com.founder.rhip.idm.controller.form.ReportStatisticsQueryForm;
import com.founder.rhip.idm.service.IReportStatisticsService;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Dictionary;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IDictionaryService;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/idm/statistics/report/selfcheck")
public class SelfCheckController extends BaseController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "reportStatisticsService")
	private IReportStatisticsService reportStatisticsService;
	
	@Resource(name="mdmDictionaryService")
	private IDictionaryService mdmDictionaryService;
	
	private static  CustomDateEditor  dateEditor =  
			new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true);

	@InitBinder
	public void initBinder(WebDataBinder binder) {	    
	    binder.registerCustomEditor(Date.class, dateEditor);
	}
	/**
	 * 进入执行情况自查-填写查询画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/fillSearch")
	public String fillSearch(HttpServletRequest request, ModelMap model) {
		/*根据当前机构，设置页面中的上报机构*/
		Organization org = getCurrentOrg(request);
		String currentOrgCode = org.getOrganCode();

		/*防疫科显示所有机构数据*/
		if (!hasRole(RoleType.JKFYK, request)){
			model.addAttribute("reportUnitCode", currentOrgCode);
		}else{
			model.addAttribute("RoleType", "JKFYK");
		}
		
		return "rhip.idm.statistics.report.selfcheck.fillSearch";
	}	
	/**
	 * 执行情况自查-填写列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/fillList")
	public String fillList(ReportStatisticsQueryForm form, HttpServletRequest request, ModelMap model) {
		String indexPage = request.getParameter("indexPage");
        int currentPage = Integer.valueOf(indexPage);
        Page page = super.getPage(request, currentPage);
        Criteria ca = form.getSelfCheckFillCriteria();
        PageList<SelfCheck> plist = reportStatisticsService.findSelfCheckFill(ca, page);
        model.addAttribute("selfchecks", plist.getList());
        model.addAttribute("page", plist.getPage());	
        
		/*防疫科只能查看数据*/
		if (hasRole(RoleType.JKFYK, request)){
			 model.addAttribute("editFlag", "0");
		}else{
			model.addAttribute("editFlag", "1");
		}
		
		return "rhip.idm.statistics.report.selfcheck.fillList";
	}

	/**
	 * 进入执行情况自查-新增/查看-法定传染病报告画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/addFillDc")
	public String addFill(HttpServletRequest request, String type, Long id, ModelMap model) {
		SelfCheck selfCheck = reportStatisticsService.getSelfCheckFill(id);
        /*根据当前用户，设置页面中的调查机构*/
        if(ObjectUtil.isNullOrEmpty(selfCheck)){
        	selfCheck = new SelfCheck();
	        Organization org = getCurrentOrg(request);
	        String organCode = org.getOrganCode();
	        Long userId = getCurrentUser(request).getId();
	        selfCheck.setReportUnitCode(organCode);
	        selfCheck.setModifyUnitCode(organCode);
	        selfCheck.setReportUserCode(userId.toString());
	        selfCheck.setModifyUserCode(userId.toString());
	        selfCheck.setReportDate(new Date());
	        selfCheck.setModifyDate(new Date());
        }
        model.put("selfCheck", selfCheck);
        model.put("type", type);
		return "rhip.idm.statistics.report.selfcheck.addFillDc";
	}

	
	/**
	 * 进入执行情况自查-新增/查看-新生儿产房接种画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/addFillNeonate")
	public String addFillNeonate(HttpServletRequest request, String type, Long id, ModelMap model) {
		SelfCheck selfCheck = reportStatisticsService.getSelfCheckFill(id);
        /*根据当前用户，设置页面中的调查机构*/
        if(ObjectUtil.isNullOrEmpty(selfCheck)){
        	selfCheck = new SelfCheck();
	        Organization org = getCurrentOrg(request);
	        String organCode = org.getOrganCode();
	        Long userId = getCurrentUser(request).getId();
	        selfCheck.setReportUnitCode(organCode);
	        selfCheck.setModifyUnitCode(organCode);
	        selfCheck.setReportUserCode(userId.toString());
	        selfCheck.setModifyUserCode(userId.toString());
	        selfCheck.setReportDate(new Date());
	        selfCheck.setModifyDate(new Date());
        }
        model.put("selfCheck", selfCheck);
        model.put("type", type);
		return "rhip.idm.statistics.report.selfcheck.addFillNeonate";
	}
	
	/**
	 * 进入传染病子画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/editInfectious")
    public String editInfectious(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            @SuppressWarnings("unchecked")
            List<ListScDc> listScDcs = (List<ListScDc>) json2Obj(trData, ListScDc.class);
            model.put("listScDc", listScDcs.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.statistics.report.selfcheck.addInfectious";
    }	
	/**
	 * 保存执行情况自查
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/saveFill")
	public String saveFill(String reportMonthSelf, SelfCheck selfCheck, String type, HttpServletRequest request, ModelMap model) throws Exception {
		boolean result = false;
		if(ObjectUtil.isNotEmpty(selfCheck)){
			getListData(selfCheck);
			selfCheck.setType(type);//执行情况：1，新生儿产房接种：2
			selfCheck.setReportMonth(DateUtil.parseSimpleDate(reportMonthSelf, "yyyy/MM"));
			String actionName = "直报统计-执行情况自查";
			OperationName op = OperationName.ADD;
			Organization org = getCurrentOrg(request);
	        String organCode = org.getOrganCode();
	        Long userId = getCurrentUser(request).getId();
			if(ObjectUtil.isNotEmpty(selfCheck.getId())){
				op = OperationName.UPDATE;
				selfCheck.setModifyUnitCode(organCode);
				selfCheck.setModifyUserCode(userId.toString());
				selfCheck.setModifyDate(new Date());
			}else{
				selfCheck.setGenreCode(org.getGenreCode());//机构类别代码
			}
			result = reportStatisticsService.saveSelfCheckFill(selfCheck);
			createOperationLog(request, RhipModuleName.IDM, actionName,op);
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}
	
	/**
	 * 根据机构编码、填报月份查询是否已经填报
	 * @param reportMonth
	 * @param name
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping("/queryFill")
	public String queryFill(Date reportMonth, String reportUnitCode, String departmentCode, String type, HttpServletResponse response, ModelMap model) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		int count = 0;
		if(ObjectUtil.isNotEmpty(reportMonth) && ObjectUtil.isNotEmpty(reportUnitCode)){
			Criteria criteria = new Criteria("REPORT_MONTH",reportMonth);
			criteria.add("REPORT_UNIT_CODE",reportUnitCode);
			if(StringUtil.isNotEmpty(departmentCode)){
				criteria.add("DEPARTMENT_CODE",departmentCode);
			}
			criteria.add("TYPE",type);
			count = reportStatisticsService.getSelfCheckFillCount(criteria);
			map.put("count", count);
		}
		return EHRMessageUtil.returnMsg(model, map);
	}
	
	/**
	 * 进入执行情况自查-汇总查询画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/summarySearch")
	public String summarySearch(HttpServletRequest request, ModelMap model) {
		/*根据当前机构，设置页面中的上报机构*/
		Organization org = getCurrentOrg(request);
		String currentOrgCode = org.getOrganCode();

		/*防疫科显示所有机构数据*/
		if (!hasRole(RoleType.JKFYK, request)){
			model.addAttribute("reportUnitCode", currentOrgCode);
		}else{
			model.addAttribute("RoleType", "JKFYK");
		}		

		model.addAttribute("defaultMonth", new Date());
		
		return "rhip.idm.statistics.report.selfcheck.summarySearch";
	}	
	/**
	 * 传染病管理及督导-汇总列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/summaryList")
	public String summaryList(ReportStatisticsQueryForm form, HttpServletRequest request, ModelMap model) {

        Criteria ca = form.getSelfCheckCriteria();
        
		String reportUnitCode = ca.get("REPORT_UNIT_CODE").toString();
		model.addAttribute("reportUnitCode", reportUnitCode);
		
        String reportMonth = ca.get("REPORT_MONTH").toString();
        reportMonth = formateReportDate(reportMonth);
        model.addAttribute("reportMonth", reportMonth);
        /*本机构本月上报传染病统计*/
        List<SelfCheck> selfChecks = reportStatisticsService.findSelfCheckSummary(ca);
        model.addAttribute("selfChecks", selfChecks);
        
        /*本机构本月上报传染病集合*/
        List<ListScDc> listScDcs = reportStatisticsService.findInfections(ca);
        model.addAttribute("infections", listScDcs);
        
        /*新生儿产房接种*/
        SelfCheck neonate = reportStatisticsService.findNeonateSummary(ca);
        model.addAttribute("neonate", neonate);
        
        /*法定传染病合计*/
        SelfCheck summary = reportStatisticsService.getSelfCheckSummary(ca);
        model.addAttribute("summary", summary);

        /*报表信息：填报日期、填报人*/
        
        reportMonth = ca.get("REPORT_MONTH").toString();
        reportMonth = reportMonth.substring(0, 7);
        SelfCheck info = reportStatisticsService.getSelfCheckInfo(reportUnitCode, reportMonth);
        if(ObjectUtil.isNotEmpty(info)){
        	model.addAttribute("reportUserCode", info.getReportUserCode());
        	model.addAttribute("reportUnitCode", info.getReportUnitCode());
        	model.addAttribute("reportDate", info.getReportDate());
        }        
		return "rhip.idm.statistics.report.selfcheck.summaryList";
	}
	
	private String formateReportDate(String strDate){
		Date date = DateUtil.parseSimpleDate(strDate, "yyyy/MM/dd");
		String result = DateUtil.getDateTime("yyyy年M月", date);
		result = result.replace("0", "○");
		result = result.replace("1", "一");
		result = result.replace("2", "二");
		result = result.replace("3", "三");
		result = result.replace("4", "四");
		result = result.replace("5", "五");
		result = result.replace("6", "六");
		result = result.replace("7", "七");
		result = result.replace("8", "八");
		result = result.replace("9", "九");
		return result;
	}
	/**
	 * 根据传染病类型查询传染病
	 *
	 * @param type
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping("/queryInfection")
	public String queryInfection(String type, ModelMap model) throws IOException {
		Criteria criteria = new Criteria(Dictionary.DIC_CODE, "CV0501017");
		if (StringUtil.isNotEmpty(type)) {
			criteria.add("parentCode", type);
		}
		List<DicItem> dicItems = mdmDictionaryService.getDicItemsUseCache(criteria);

		JSONObject jsonObject = getInfectionDic(dicItems);
		return EHRMessageUtil.returnMsg(model, jsonObject.toString());
	}
	/**
	 * 生成传染病JSON字符
	 * @param dicItems
	 * @return
	 */
	private JSONObject getInfectionDic(List<DicItem> dicItems) {
		int length = dicItems.size();
		String code;
		String name;
		JSONObject jsonObject = new JSONObject();
		for (int i = 0; i < length; i++) {
			DicItem item = dicItems.get(i);
			code = item.getItemCode();
			name = item.getItemName();
			jsonObject.put(code, name);
		}
		return jsonObject;
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
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy/MM/dd"));
        JSONArray jsonObjects = JSONArray.fromObject(jsonArrayStr, jsonConfig);
        String[] dateFormats = new String[]{"yyyy/MM/dd"};
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
        @SuppressWarnings("rawtypes")
        List resultList = new ArrayList();
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
     * 子表数据处理
     *
     * @param selfCheck
     * @return SelfCheck
     */
    @SuppressWarnings("unchecked")
	private SelfCheck getListData(SelfCheck selfCheck) throws InstantiationException, IllegalAccessException {
        // 传染病报告记录
        String listScDcJson = selfCheck.getListScDcJson();
        if (StringUtil.isNotEmpty(listScDcJson)) {
            List<ListScDc> listScDcs = (List<ListScDc>) json2Obj(listScDcJson, ListScDc.class);
            selfCheck.setListScDcs(listScDcs);
        }
   
        return selfCheck;
    }	
}
