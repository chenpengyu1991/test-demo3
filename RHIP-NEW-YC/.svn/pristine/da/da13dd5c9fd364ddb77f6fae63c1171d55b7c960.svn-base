package com.founder.rhip.vaccine.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.RabiesStatisticsDTO;
import com.founder.rhip.ehr.dto.idm.AcuteStatisicsDto;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/vaccine/statistics/report/monthReport")
public class RabiesReportController extends BaseController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "reportStatisticsService")
	private IReportStatisticsService reportStatisticsService;
	
    @Resource(name = "vaccineStatisticsService")
    private IVaccineStatisticsService vaccineStatisticsService;   
    
	private static  CustomDateEditor  dateEditor =  
			new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true);

	@InitBinder
	@Override
	public void initBinder(WebDataBinder binder) {	    
	    binder.registerCustomEditor(Date.class, dateEditor);
	}
	
	
	/**
	 * 进入传染病管理月报表-狂犬病防治月报查询画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/rabiesSearch")
	public String rabiesSearch(HttpServletRequest request,ModelMap model) {
		/*根据当前机构，设置页面中的上报机构*/
		Organization org = getCurrentOrg(request);
		String currentOrgCode = org.getOrganCode();

		/*防疫科显示所有机构数据*/
		if (!hasRole(RoleType.JKYFJZ, request) && !hasRole(RoleType.ADMIN, request)){
			model.addAttribute("fillOrganCode", currentOrgCode);
		}
		model.addAttribute("defaultMonth", new Date());
		return "rhip.vaccine.statistics.report.monthReport.rabiesSearch";
	}	
	/**
	 * 传染病管理月报表-狂犬病防治月报列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/rabiesList")
	public String rabiesList(ReportStatisticsQueryForm form,HttpServletRequest request,ModelMap model) {
		Criteria criteria = new Criteria();
		if (ObjectUtil.isNotEmpty(form.getFillOrganCode())) {
			criteria.add("createOrg", form.getFillOrganCode());
		}
		if (!hasRole(RoleType.JKYFJZ, request) && !hasRole(RoleType.ADMIN, request)){
			criteria.add("createOrg", getCurrentOrg(request).getOrganCode());
		}
		if (ObjectUtil.isNotEmpty(form.getFillBeginDate())) {
			criteria.add("fillBeginDate", form.getFillBeginDate());
		}
		if (ObjectUtil.isNotEmpty(form.getFillEndDate())) {
			criteria.add("fillEndDate", form.getFillEndDate());
		}
//		Organization org = getCurrentOrg(request);
//		String currentOrgCode = org.getOrganCode();
//		model.addAttribute("currentOrgCode", currentOrgCode);
//        Object fillDate = ca.get("FILL_DATE");
//        model.addAttribute("currentMonth", ca.get("FILL_DATE"));
//        
//        String reportMonth = formateReportDate(fillDate.toString());
//        model.addAttribute("reportMonth", reportMonth);
//        List<RabiesStatisicsDto> dto = reportStatisticsService.findRabiesSummary(ca);
//        
//        Object fillOrgan = ca.get("FILL_ORGAN_CODE");
//        /*设置报表信息*/
//        if(ObjectUtil.isNotEmpty(fillOrgan)){
//	        String fillUserId = "";
//	        String fillOrgCode = "";
//	        Date fillDt = null;        	
//    		if (hasRole(RoleType.JKYFJZ, request)  && fillOrgan.equals("46714114-9")){//如果是疾控登录，填报机构显示为：疾控，填写人、填写日期为当前用户
//    			fillUserId = getCurrentUser(request).getId().toString();
//    			fillOrgCode = fillOrgan.toString();
//    			fillDt = new Date();
//    		}else{        	
//		        StatisticsData statistics = reportStatisticsService.getStatisticsInfo(StatisticsType.RABIES.getValue(), fillOrgan.toString(), fillDate.toString());
//		        if(ObjectUtil.isNotEmpty(statistics)){
//		            fillUserId = statistics.getFillUserId();
//		            fillOrgCode = statistics.getFillOrganCode();
//		            fillDt = statistics.getFillDt();
//		        }
//    		}
//        	model.addAttribute("fillUserId", fillUserId);
//        	model.addAttribute("fillOrgCode", fillOrgCode);
//        	model.addAttribute("fillDt", fillDt);    		
//        }
//        Object genreCode = ca.get("GENRE_CODE");//机构类别代码,只有中心需要调用二类疫苗接口
//        if(!OrgGenreCode.HOSPITAL.getValue().equals(genreCode)){
//            /*获取二类疫苗接口*/
//            Date startDate = firstDateOfMonth(DateUtil.parseDateString(fillDate.toString() + "/01"));
//            String orgCode = ObjectUtil.isNotEmpty(fillOrgan)?fillOrgan.toString():null;
//            vaccineInterface(startDate,orgCode,dto);       	
//        }
//
//        model.addAttribute("rabieses", dto);
		List<Map<String, Object>> mapList = vaccineStatisticsService.statisticsRabiesMapList(criteria);
		List<Map<String, Object>> destMapList = new ArrayList<>();
		for (Map<String, Object> map : mapList) {
			if (ObjectUtil.isNullOrEmpty(map.get("PERSON_NUM"))
					&& ObjectUtil.isNullOrEmpty(map.get("NUM1"))
					&& ObjectUtil.isNullOrEmpty(map.get("NUM2"))
					&& ObjectUtil.isNullOrEmpty(map.get("NUM3"))
					&& ObjectUtil.isNullOrEmpty(map.get("NUM4"))) {
				continue;
			}
			destMapList.add(map);
		}
		model.addAttribute("mapList", destMapList);
		model.addAttribute("beginDate",form.getFillBeginDate());
		model.addAttribute("endDate",form.getFillEndDate());
		model.addAttribute("createOrg", form.getFillOrganCode());
		return "rhip.vaccine.statistics.report.monthReport.rabiesList";
	}
	/**
	 * 获取二类疫苗接口数据
	 * @param searchDate
	 * @param orgCode
	 * @param dtos
	 * @return
	 */
	private void vaccineInterface(Date searchDate,String orgCode,List<RabiesStatisicsDto> dtos){
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
	public String rabiesSave(StatisticsData statistics,String currentOrgCode,String currentMonth,HttpServletRequest request,ModelMap model) {
		boolean result = false;
		if(ObjectUtil.isNotEmpty(statistics)){
			statistics.setFillDate(DateUtil.convert("yyyy/MM/dd", currentMonth + "/01"));
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
		Date date = DateUtil.convert("yyyy/MM",strDate); 
		String result =DateUtil.getDateTime("yyyy年M月", date);
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
