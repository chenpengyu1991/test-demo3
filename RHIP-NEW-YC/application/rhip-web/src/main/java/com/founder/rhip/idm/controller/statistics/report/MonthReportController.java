package com.founder.rhip.idm.controller.statistics.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.RabiesStatisticsDTO;
import com.founder.rhip.ehr.dto.idm.DysenteryStatisicsDto;
import com.founder.rhip.ehr.dto.idm.InterviewStatisicsDto;
import com.founder.rhip.ehr.dto.idm.RabiesStatisicsDto;
import com.founder.rhip.ehr.entity.control.idm.statistics.report.StatisticsData;
import com.founder.rhip.idm.common.StatisticsType;
import com.founder.rhip.idm.controller.form.ReportStatisticsQueryForm;
import com.founder.rhip.idm.service.IReportStatisticsService;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.ph.service.vaccine.IVaccineStatisticsService;
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
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/idm/statistics/report/monthReport")
public class MonthReportController extends BaseController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "reportStatisticsService")
	private IReportStatisticsService reportStatisticsService;
	
    @Resource(name = "vaccineStatisticsService")
    private IVaccineStatisticsService vaccineStatisticsService;
    
	private static  CustomDateEditor  dateEditor =  
			new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true);

	@InitBinder
	public void initBinder(WebDataBinder binder) {	    
	    binder.registerCustomEditor(Date.class, dateEditor);
	}
	/**
	 * 进入传染病管理月报表-传染病访视查询画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/interviewSearch")
	public String interviewSearch(HttpServletRequest request, ModelMap model) {
		/*根据当前机构，设置页面中的上报机构*/
		Organization org = getCurrentOrg(request);
		String currentOrgCode = org.getOrganCode();
		/*防疫科显示所有机构数据*/
		if (!hasRole(RoleType.JKFYK, request)){
			model.addAttribute("fillOrganCode", currentOrgCode);
		}else{
			model.addAttribute("RoleType", "JKFYK");
		}		
		model.addAttribute("defaultMonth", new Date());
		return "rhip.idm.statistics.report.monthReport.interviewSearch";
	}	
	/**
	 * 传染病管理月报表-传染病访视列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/interviewList")
	public String interviewList(ReportStatisticsQueryForm form, HttpServletRequest request, ModelMap model) {
		Organization org = getCurrentOrg(request);
		String currentOrgCode = org.getOrganCode();
		model.addAttribute("currentOrgCode", currentOrgCode);
        Criteria ca = form.getInterviewCriteria();
        Object fillDate = ca.get("FILL_DATE");

        model.addAttribute("currentMonth", fillDate);
        String reportMonth = formateReportDate(fillDate.toString());
        model.addAttribute("reportMonth", reportMonth);
        List<InterviewStatisicsDto> dto = reportStatisticsService.findInterviewSummary(ca);
        Object fillOrgan = ca.get("FILL_ORGAN_CODE");
        /*设置报表信息*/
        if(ObjectUtil.isNotEmpty(fillOrgan)){
	        String fillUserId = "";
	        String fillOrgCode = "";
	        Date fillDt = null;
    		if (hasRole(RoleType.JKFYK, request) && fillOrgan.equals("46714114-9")){//如果是疾控登录，填报机构显示为：疾控，填写人、填写日期为当前用户
    			fillUserId = getCurrentUser(request).getId().toString();
    			fillOrgCode = fillOrgan.toString();
    			fillDt = new Date();
    		}else{
		        StatisticsData statistics = reportStatisticsService.getStatisticsInfo(StatisticsType.INTERVIEW.getValue(), fillOrgan.toString(), fillDate.toString());
		        if(ObjectUtil.isNotEmpty(statistics)){
		            fillUserId = statistics.getFillUserId();
		            fillOrgCode = statistics.getFillOrganCode();
		            fillDt = statistics.getFillDt();
		        }
    		}
        	model.addAttribute("fillUserId", fillUserId);
        	model.addAttribute("fillOrgCode", fillOrgCode);
        	model.addAttribute("fillDt", fillDt);    		
        }
        model.addAttribute("interviews", dto);
		return "rhip.idm.statistics.report.monthReport.interviewList";
	}

	/**
	 * 传染病管理月报表-传染病访视报表保存
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/interviewSave")
	public String interviewSave(String diseaseCode, String currentOrgCode, String currentMonth, HttpServletRequest request, ModelMap model) {
		boolean result = false;
		String[] codes = diseaseCode.split(",");
		if(ObjectUtil.isNotEmpty(codes)){
			List<StatisticsData> lists = new ArrayList<StatisticsData>();
			for(String code:codes){
				StatisticsData statisticsData = getStatisticsData(currentOrgCode,currentMonth,code,request);
				lists.add(statisticsData);
			}
			if(lists.size() > 0){
				result = reportStatisticsService.saveStatistics(lists);
			}
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}

	private StatisticsData getStatisticsData(String currentOrgCode, String currentMonth, String diseaseCode, HttpServletRequest request){
		Organization org = getCurrentOrg(request);
		StatisticsData statisticsData = new StatisticsData();
		statisticsData.setDiseaseCode(diseaseCode);
		statisticsData.setFillDate(DateUtil.parseSimpleDate(currentMonth + "/01", "yyyy/MM/dd"));
		statisticsData.setFillOrganCode(currentOrgCode);
		Integer interviewOther = NumberUtil.convert(request.getParameter("interviewOther" + diseaseCode),Integer.class);
		Integer misdiagnose = NumberUtil.convert(request.getParameter("misdiagnose" + diseaseCode),Integer.class);
		Integer unknownPerson = NumberUtil.convert(request.getParameter("unknownPerson" + diseaseCode),Integer.class);
		Integer vaccinationNumber = NumberUtil.convert(request.getParameter("vaccinationNumber" + diseaseCode),Integer.class);
		statisticsData.setInterviewOther(interviewOther);
		statisticsData.setMisdiagnose(misdiagnose);
		statisticsData.setUnknownPerson(unknownPerson);
		statisticsData.setVaccinationNumber(vaccinationNumber);
		statisticsData.setType(StatisticsType.INTERVIEW.getValue());
		statisticsData.setOther(request.getParameter("other" + diseaseCode).toString());
		Long userId = getCurrentUser(request).getId();
		statisticsData.setFillUserId(userId.toString());
		statisticsData.setFillDt(new Date());
		statisticsData.setGenreCode(org.getGenreCode());//机构类型
		return statisticsData;
	}
	
	/**
	 * 进入传染病管理月报表-细菌性痢疾流调查询画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/dysenterySearch")
	public String dysenterySearch(HttpServletRequest request, ModelMap model) {
		/*根据当前机构，设置页面中的上报机构*/
		Organization org = getCurrentOrg(request);
		String currentOrgCode = org.getOrganCode();

		/*防疫科显示所有机构数据*/
		if (!hasRole(RoleType.JKFYK, request)){
			model.addAttribute("fillOrganCode", currentOrgCode);
		}else{
			model.addAttribute("RoleType", "JKFYK");
		}
		model.addAttribute("defaultMonth", new Date());
		return "rhip.idm.statistics.report.monthReport.dysenterySearch";
	}	
	/**
	 * 传染病管理月报表-细菌性痢疾流调列表
	 * @param summaryType:汇总方式
	 * @param form：查询条件
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/dysenteryList")
	public String dysenteryList(ReportStatisticsQueryForm form, HttpServletRequest request, ModelMap model) {
		Organization org = getCurrentOrg(request);
		String currentOrgCode = org.getOrganCode();
		model.addAttribute("currentOrgCode", currentOrgCode);
        Criteria ca = form.getInterviewCriteria();
        Object fillDate = ca.get("FILL_DATE");
        model.addAttribute("currentMonth", fillDate);
        String reportMonth = formateReportDate(fillDate.toString());
        model.addAttribute("reportMonth", reportMonth);
        List<DysenteryStatisicsDto> dto = reportStatisticsService.findDysenterySummary(ca);
        Object fillOrgan = ca.get("FILL_ORGAN_CODE");
        /*设置报表信息*/
        if(ObjectUtil.isNotEmpty(fillOrgan)){
	        String fillUserId = "";
	        String fillOrgCode = "";
	        Date fillDt = null;
    		if (hasRole(RoleType.JKFYK, request)  && fillOrgan.equals("46714114-9")){//如果是疾控登录，填报机构显示为：疾控，填写人、填写日期为当前用户
    			fillUserId = getCurrentUser(request).getId().toString();
    			fillOrgCode = fillOrgan.toString();
    			fillDt = new Date();
    		}else{
		        StatisticsData statistics = reportStatisticsService.getStatisticsInfo(StatisticsType.DYSENTERY.getValue(), fillOrgan.toString(), fillDate.toString());
		        if(ObjectUtil.isNotEmpty(statistics)){
		            fillUserId = statistics.getFillUserId();
		            fillOrgCode = statistics.getFillOrganCode();
		            fillDt = statistics.getFillDt();
		        }
    		}
        	model.addAttribute("fillUserId", fillUserId);
        	model.addAttribute("fillOrgCode", fillOrgCode);
        	model.addAttribute("fillDt", fillDt);
        }
        
        model.addAttribute("dysenterys", dto);
		return "rhip.idm.statistics.report.monthReport.dysenteryList";
	}

	/**
	 * 传染病管理月报表-细菌性痢疾流调报表保存
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/dysenterySave")
	public String dysenterySave(StatisticsData statistics, String currentOrgCode, String currentMonth, HttpServletRequest request, ModelMap model) {
		boolean result = false;
		if(ObjectUtil.isNotEmpty(statistics)){
			statistics.setFillDate(DateUtil.parseSimpleDate(currentMonth + "/01", "yyyy/MM/dd"));
			statistics.setFillOrganCode(currentOrgCode);
			Long userId = getCurrentUser(request).getId();
			statistics.setFillUserId(userId.toString());
			statistics.setFillDt(new Date());
			statistics.setType(StatisticsType.DYSENTERY.getValue());
			List<StatisticsData> lists = new ArrayList<StatisticsData>();
			lists.add(statistics);
			result = reportStatisticsService.saveStatistics(lists);
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}	
	
	/**
	 * 进入传染病管理月报表-狂犬病防治月报查询画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/rabiesSearch")
	public String rabiesSearch(HttpServletRequest request, ModelMap model) {
		/*根据当前机构，设置页面中的上报机构*/
		Organization org = getCurrentOrg(request);
		String currentOrgCode = org.getOrganCode();

		/*防疫科显示所有机构数据*/
		if (!hasRole(RoleType.JKFYK, request)){
			model.addAttribute("fillOrganCode", currentOrgCode);
		}else{
			model.addAttribute("RoleType", "JKFYK");
		}
		model.addAttribute("defaultMonth", new Date());
		return "rhip.idm.statistics.report.monthReport.rabiesSearch";
	}	
	/**
	 * 传染病管理月报表-狂犬病防治月报列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/rabiesList")
	public String rabiesList(ReportStatisticsQueryForm form, HttpServletRequest request, ModelMap model) {
		Organization org = getCurrentOrg(request);
		String currentOrgCode = org.getOrganCode();
		model.addAttribute("currentOrgCode", currentOrgCode);
        Criteria ca = form.getInterviewCriteria();
        Object fillDate = ca.get("FILL_DATE");
        model.addAttribute("currentMonth", ca.get("FILL_DATE"));
        
        String reportMonth = formateReportDate(fillDate.toString());
        model.addAttribute("reportMonth", reportMonth);
        List<RabiesStatisicsDto> dto = reportStatisticsService.findRabiesSummary(ca);
        
        Object fillOrgan = ca.get("FILL_ORGAN_CODE");
        /*设置报表信息*/
        if(ObjectUtil.isNotEmpty(fillOrgan)){
	        String fillUserId = "";
	        String fillOrgCode = "";
	        Date fillDt = null;
    		if (hasRole(RoleType.JKFYK, request)  && fillOrgan.equals("46714114-9")){//如果是疾控登录，填报机构显示为：疾控，填写人、填写日期为当前用户
    			fillUserId = getCurrentUser(request).getId().toString();
    			fillOrgCode = fillOrgan.toString();
    			fillDt = new Date();
    		}else{        	
		        StatisticsData statistics = reportStatisticsService.getStatisticsInfo(StatisticsType.RABIES.getValue(), fillOrgan.toString(), fillDate.toString());
		        if(ObjectUtil.isNotEmpty(statistics)){
		            fillUserId = statistics.getFillUserId();
		            fillOrgCode = statistics.getFillOrganCode();
		            fillDt = statistics.getFillDt();
		        }
    		}
        	model.addAttribute("fillUserId", fillUserId);
        	model.addAttribute("fillOrgCode", fillOrgCode);
        	model.addAttribute("fillDt", fillDt);    		
        }
        Object genreCode = ca.get("GENRE_CODE");//机构类别代码,只有中心需要调用二类疫苗接口
        if(!OrgGenreCode.HOSPITAL.getValue().equals(genreCode)){
            /*获取二类疫苗接口*/
            Date startDate = firstDateOfMonth(DateUtil.parseSimpleDate(fillDate.toString() + "/01", null));
            String orgCode = ObjectUtil.isNotEmpty(fillOrgan)?fillOrgan.toString():null;
            vaccineInterface(startDate,orgCode,dto);       	
        }

        model.addAttribute("rabieses", dto);
		return "rhip.idm.statistics.report.monthReport.rabiesList";
	}
	/**
	 * 获取二类疫苗接口数据
	 * @param startDate
	 * @param endDate
	 * @param dtos
	 * @return
	 */
	private void vaccineInterface(Date searchDate, String orgCode, List<RabiesStatisicsDto> dtos){
        Map<String,RabiesStatisticsDTO> vaccineMap = vaccineStatisticsService.statistics(searchDate, orgCode);
        RabiesStatisticsDTO vaccineDto = new RabiesStatisticsDTO();
        for(RabiesStatisicsDto dto:dtos){
        	if("-1".equals(dto.getFillOrganCode())){//累计
        		vaccineDto = vaccineMap.get("year");
        	}else{
        		vaccineDto = vaccineMap.get("month");
        	}
           	if(ObjectUtil.isNotEmpty(vaccineDto)){
	        	dto.setRabiesVisit(vaccineDto.getOutpatient());//被动物咬伤就诊人数
	        	dto.setDisposeVulnus(vaccineDto.getWoundTreatment());//伤口经正规处理人数
	        	dto.setRabiesImmunoglobulin(vaccineDto.getCommentGray());//使用狂犬病人免疫球蛋白联合疫苗人数
	        	dto.setRabiesVaccine(vaccineDto.getCommentVaccine());//使用人用狂犬病疫苗人数
        	}        	
        }
	}
	/**
	 * 传染病管理月报表-狂犬病防治月报报表保存
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/rabiesSave")
	public String rabiesSave(StatisticsData statistics, String currentOrgCode, String currentMonth, HttpServletRequest request, ModelMap model) {
		boolean result = false;
		if(ObjectUtil.isNotEmpty(statistics)){
			statistics.setFillDate(DateUtil.parseSimpleDate(currentMonth + "/01", "yyyy/MM/dd"));
			statistics.setFillOrganCode(currentOrgCode);
			statistics.setType(StatisticsType.RABIES.getValue());
			Long userId = getCurrentUser(request).getId();
			statistics.setFillUserId(userId.toString());
			statistics.setFillDt(new Date());
			List<StatisticsData> lists = new ArrayList<StatisticsData>();
			lists.add(statistics);
			result = reportStatisticsService.saveStatistics(lists);
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}	
	
	private String formateReportDate(String strDate){
		Date date = DateUtil.parseSimpleDate(strDate, "yyyy/MM");
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
	private static Date lastDateOfMonth(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 2;
		
		String dateString = year + "/" + month + "/01 00:00:00";
		Date first = DateUtil.parseSimpleDate(dateString,"yyyy/MM/dd HH:mm:ss");
		
		Date lastDate = new Date(first.getTime() - 1);
		return lastDate;
	}
	
	private static Date firstDateOfMonth(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		
		String dateString = year + "/" + month + "/01 00:00:00";
		Date first = DateUtil.parseSimpleDate(dateString,"yyyy/MM/dd HH:mm:ss");
		return first;
	}	
}
