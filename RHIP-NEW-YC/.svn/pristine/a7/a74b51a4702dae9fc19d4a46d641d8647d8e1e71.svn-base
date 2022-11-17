package com.founder.rhip.idm.controller.statistics.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.VaccineStatisticsMonthDTO;
import com.founder.rhip.ehr.dto.idm.AcuteStatisicsDto;
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
@RequestMapping(value = "/idm/statistics/report/acuteReport")
public class AcuteReportController extends BaseController {
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
	 * 进入急性传染病防治-按月查询画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/monthSearch")
	public String monthSearch(HttpServletRequest request, ModelMap model) {
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
		return "rhip.idm.statistics.report.acuteReport.monthSearch";
	}	
	/**
	 * 急性传染病防治-按月汇总列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/monthList")
	public String monthList(ReportStatisticsQueryForm form, HttpServletRequest request, ModelMap model) {
		Organization org = getCurrentOrg(request);
		String currentOrgCode = org.getOrganCode();
		model.addAttribute("currentOrgCode", currentOrgCode);
        Criteria ca = form.getAcuteCriteria();
        Object orgCode = ca.get("FILL_ORGAN_CODE");
        Object fillDate = ca.get("FILL_DATE");
        if(ObjectUtil.isNullOrEmpty(orgCode) && hasRole(RoleType.ZXCRB,request)){
        	ca.add("FILL_ORGAN_CODE",currentOrgCode);
        }
        model.addAttribute("currentMonth", fillDate);
        
        List<AcuteStatisicsDto> dtos = reportStatisticsService.findAcuteMonthSummary(ca);
        
        /*获取二类疫苗接口*/
        Object genreCode = ca.get("GENRE_CODE");//机构类别代码,只有中心需要调用二类疫苗接口
        if(!OrgGenreCode.HOSPITAL.getValue().equals(genreCode)){
            Date startDate = firstDateOfMonth(DateUtil.parseSimpleDate(fillDate.toString() + "/01", null));
            Date endDate = lastDateOfMonth(DateUtil.parseSimpleDate(fillDate.toString() + "/01", null));
            vaccineInterface(startDate,endDate,dtos);       	
        }
        model.addAttribute("acuteMonths", dtos);
        
        /*设置报表信息*/
        Object fillOrgan = ca.get("FILL_ORGAN_CODE");
        
        if(ObjectUtil.isNotEmpty(fillOrgan)){
        	Date reportMonthDate = DateUtil.parseSimpleDate(ca.get("FILL_DATE").toString(), "yyy/MM");
        	model.addAttribute("reportMonth", reportMonthDate);
	        StatisticsData statistics = reportStatisticsService.getStatisticsInfo(StatisticsType.ACUTE.getValue(), orgCode.toString(), ca.get("FILL_DATE").toString());
	        String fillUserId = "";
	        String fillOrgCode = "";
	        Date fillDt = null;
	        if(ObjectUtil.isNotEmpty(statistics)){
	            fillUserId = statistics.getFillUserId();
	            fillOrgCode = statistics.getFillOrganCode();
	            fillDt = statistics.getFillDt();
	        	model.addAttribute("fillUserId", fillUserId);
	        	model.addAttribute("fillOrgCode", fillOrgCode);
	        	model.addAttribute("fillDt", fillDt);
	        }
        }        
		return "rhip.idm.statistics.report.acuteReport.monthList";
	}

	/**
	 * 急性传染病防治-按月报表保存
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/monthSave")
	public String monthSave(String fillOrganCode, String currentMonth, HttpServletRequest request, ModelMap model) {
		boolean result = false;
		String[] fillOrganCodes = fillOrganCode.split(",");
		if(ObjectUtil.isNotEmpty(fillOrganCodes)){
			List<StatisticsData> lists = new ArrayList<StatisticsData>();
			for(String code:fillOrganCodes){
				StatisticsData statisticsData = getStatisticsData(code,currentMonth,request);
				lists.add(statisticsData);
			}
			if(lists.size() > 0){
				result = reportStatisticsService.saveStatistics(lists);
			}
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}

	private StatisticsData getStatisticsData(String currentOrgCode, String currentMonth, HttpServletRequest request){
		StatisticsData statisticsData = new StatisticsData();
		statisticsData.setFillDate(DateUtil.parseSimpleDate(currentMonth + "/01", "yyyy/MM/dd"));
		statisticsData.setFillOrganCode(currentOrgCode);
		Integer efdDispose = NumberUtil.convert(request.getParameter("efdDispose" + currentOrgCode),Integer.class);
		Integer efdInsulate = NumberUtil.convert(request.getParameter("efdInsulate" + currentOrgCode),Integer.class);
		Integer dysenteryDispose = NumberUtil.convert(request.getParameter("dysenteryDispose" + currentOrgCode),Integer.class);
		Integer dysenteryInsulate = NumberUtil.convert(request.getParameter("dysenteryInsulate" + currentOrgCode),Integer.class);
		statisticsData.setEfdDispose(efdDispose);
		statisticsData.setEfdInsulate(efdInsulate);
		statisticsData.setDysenteryDispose(dysenteryDispose);
		statisticsData.setDysenteryInsulate(dysenteryInsulate);
		statisticsData.setType(StatisticsType.ACUTE.getValue());
		Long fillUserId = getCurrentUser(request).getId();
		statisticsData.setFillUserId(fillUserId.toString());
		statisticsData.setFillDt(new Date());
		return statisticsData;
	}
	
	/**
	 * 急性传染病防治-按年查询画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/yearSearch")
	public String yearSearch(HttpServletRequest request, ModelMap model) {
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
		return "rhip.idm.statistics.report.acuteReport.yearSearch";
	}	
	/**
	 * 急性传染病防治-按年汇总列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/yearList")
	public String yearList(ReportStatisticsQueryForm form, HttpServletRequest request, ModelMap model) {
		Organization org = getCurrentOrg(request);
		String currentOrgCode = org.getOrganCode();
		model.addAttribute("currentOrgCode", currentOrgCode);
        Criteria ca = form.getAcuteCriteria();
        Object orgCode = ca.get("FILL_ORGAN_CODE");
        Object fillDate = ca.get("FILL_DATE");
        if(ObjectUtil.isNullOrEmpty(orgCode) && hasRole(RoleType.ZXCRB,request)){
        	ca.add("FILL_ORGAN_CODE",currentOrgCode);
        }
        
        model.addAttribute("currentMonth", fillDate);
        List<AcuteStatisicsDto> dtos = reportStatisticsService.findAcuteYearSummary(ca);
        
        /*获取二类疫苗接口*/
        Object genreCode = ca.get("GENRE_CODE");//机构类别代码,只有中心需要调用二类疫苗接口
        if(!OrgGenreCode.HOSPITAL.getValue().equals(genreCode)){
	        Date startDate = firstDateOfMonth(DateUtil.parseSimpleDate(fillDate.toString() + "/01/01", null));
	        Date endDate = lastDateOfMonth(DateUtil.parseSimpleDate(fillDate.toString() + "/12/01", null));
	        vaccineInterface(startDate,endDate,dtos);
        }
        model.addAttribute("acuteYears", dtos);
		return "rhip.idm.statistics.report.acuteReport.yearList";
	}


	/**
	 * 获取二类疫苗接口数据
	 * @param startDate
	 * @param endDate
	 * @param dtos
	 * @return
	 */
	private void vaccineInterface(Date startDate, Date endDate, List<AcuteStatisicsDto> dtos){
        Map<String,VaccineStatisticsMonthDTO> vaccineMap = vaccineStatisticsService.statisticsByMonth(startDate, endDate);
        String fillOrganCode;
        AcuteStatisicsDto dtoTotal = new AcuteStatisicsDto();//合计
        for(AcuteStatisicsDto dto:dtos){
        	fillOrganCode = dto.getFillOrganCode();
        	VaccineStatisticsMonthDTO vaccineDto = vaccineMap.get(fillOrganCode);
        	if(ObjectUtil.isNotEmpty(vaccineDto)){
	        	dto.setRabiesVisit(vaccineDto.getOutpatient()==null?0:vaccineDto.getOutpatient());//犬伤就诊数
	        	dto.setRabiesDispose(vaccineDto.getWoundTreatment()==null?0:vaccineDto.getWoundTreatment());//伤口处理数
	        	dto.setRabiesVaccine(vaccineDto.getCommentVaccine()==null?0:vaccineDto.getCommentVaccine());//接种疫苗人数
	        	dto.setRabiesPassive(vaccineDto.getCommentGray()==null?0:vaccineDto.getCommentGray());//使用被动免疫制剂数
	        	dtoTotal.setRabiesVisit(dtoTotal.getRabiesVisit() + dto.getRabiesVisit());//合计-犬伤就诊数
	        	dtoTotal.setRabiesDispose(dtoTotal.getRabiesDispose() + dto.getRabiesDispose());//合计-伤口处理数
	        	dtoTotal.setRabiesVaccine(dtoTotal.getRabiesVaccine() + dto.getRabiesVaccine());//合计-接种疫苗人数
	        	dtoTotal.setRabiesPassive(dtoTotal.getRabiesPassive() + dto.getRabiesPassive());//合计-使用被动免疫制剂数	        	
        	}
        }
        for(AcuteStatisicsDto dto:dtos){
        	if("-1".equals(dto.getFillOrganCode())){//合计
        		dto.setRabiesVisit(dtoTotal.getRabiesVisit());//合计-犬伤就诊数
        		dto.setRabiesDispose(dtoTotal.getRabiesDispose());//合计-伤口处理数
        		dto.setRabiesVaccine(dtoTotal.getRabiesVaccine());//合计-接种疫苗人数
        		dto.setRabiesPassive(dtoTotal.getRabiesPassive());//合计-使用被动免疫制剂数	  
        		break;
        	}
        }   		
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
