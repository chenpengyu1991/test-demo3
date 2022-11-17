package com.founder.rhip.phsr.controller;

import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.dto.ChildStatistical;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.he.controller.VisitController;
import com.founder.rhip.ihm.service.IchildStatisticalService;

@Controller
@RequestMapping(value = "/childStatistical")
public class ChildStatisticalController extends VisitController{
	@Resource(name = "childStatisticalService")
	private IchildStatisticalService childStatisticalService;

	@Autowired
	private IOrganizationApp organizationApp;
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request, ModelMap model) {
		model.addAttribute("currentYear",new Date());
		return "rhip.phsr.he.childStatistical.search";
	}
	/**
	 * 列表显示预防接种服务报表
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/list")
	public String list(HttpServletRequest request, ModelMap model) {
		Criteria criteria = CriteriaOrganizer.initCriteriaCondition(request.getParameterMap());
		if(criteria.contains("countType")){
			criteria.remove("countType");
		}
		criteria.remove("date"); // 去除多余的条件
		String countType = request.getParameter("countType");
		if("2".equals(countType)){//按月
			criteria.remove("createBeginTime");
			criteria.remove("createEndTime");
		}else if("1".equals(countType)){//按年
			criteria.remove("month");
		}
		criteria.remove("countType");
		// 不同身份查询条件
		organizeCriteria(criteria, model, request, RoleType.ZXJKDN, RoleType.ZJKDN, null);
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		if(SecurityUtils.hasRole(RoleType.QWGZX, request)){
			criteria.add("qwgzxCode",currentLoginInfo.getOrganization().getGbCode());
		}
		List<ChildStatistical> reports = childStatisticalService.childStatisticalServiceList(criteria);
		if(SecurityUtils.hasRole(RoleType.QWGZX, request)){
			criteria.add("qwgzxCode",currentLoginInfo.getOrganization().getGbCode());
		}
		ChildStatistical childStatisticalServiceDto=childStatisticalService.childStatisticalServiceListSum(criteria);
		List<ChildStatistical> reportList =new ArrayList<>();
		
		if(SecurityUtils.hasRole(RoleType.ZX_GLY, request) || SecurityUtils.hasRole(RoleType.Z_GLY, request)) {
			criteria.add("orgCode",currentLoginInfo.getOrganization().getOrganCode());
			reportList = childStatisticalService.childStatisticalServiceList(criteria);
		}else{
			reportList.addAll(reports);
		}
//		int num=0;
//		if(ObjectUtil.isNotEmpty(reports)){
//			for (int i = 0; i < reports.size(); i++) {
//				num=num+reports.get(i).getChildExaminationNum();
//			}
//			childStatisticalServiceDto.setChildExaminationNum(num);
//		}
//		if(ObjectUtil.isNotEmpty(reportList)){
//			num=0;
//			for (int i = 0; i < reportList.size(); i++) {
//				num=num+reportList.get(i).getChildExaminationNum();
//			}
//			childStatisticalServiceDto.setChildExaminationNum(num);
//		}
		criteria.remove("orgCode");
		model.addAttribute("currentLoginInfo", currentLoginInfo);
		model.addAttribute("reports", reports);
		model.addAttribute("reportList", reportList);
		model.addAttribute("childStatisticalServiceDto", childStatisticalServiceDto);
		
		return "rhip.phsr.he.childStatistical.list";
	}

	@RequestMapping("/elderlySearch")
	public String elderlySearch(HttpServletRequest request, ModelMap model) {
		model.addAttribute("currentYear",new Date());
		return "rhip.phsr.he.childStatistical.elderlySearch";
	}
	
	public  int getAge(Date birthDay) throws Exception {  
        Calendar cal = Calendar.getInstance();  
  
        if (cal.before(birthDay)) {  
            throw new IllegalArgumentException(  
                    "The birthDay is before Now.It's unbelievable!");  
        }  
        int yearNow = cal.get(Calendar.YEAR);  
        int monthNow = cal.get(Calendar.MONTH);  
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);  
        cal.setTime(birthDay);  
  
        int yearBirth = cal.get(Calendar.YEAR);  
        int monthBirth = cal.get(Calendar.MONTH);  
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);  
  
        int age = yearNow - yearBirth;  
  
        if (monthNow <= monthBirth) {  
            if (monthNow == monthBirth) {  
                if (dayOfMonthNow < dayOfMonthBirth) age--;  
            }else{  
                age--;  
            }  
        }  
        return age;  
    }  
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/elderlyList")
	public String elderlylist(HttpServletRequest request, ModelMap model) {
		Criteria criteria = CriteriaOrganizer.initCriteriaCondition(request.getParameterMap());
		// 计算65岁以前的日期
		Date birthday = DateUtil.getBirthdayByAge(65);
		String birth = DateUtil.toDateString(birthday,"yyyy");
		criteria.add("birthday",birth);
		Object year = criteria.get("year");
		// 计算开始时间和截止时间
		calculateDate(criteria,year);
		criteria.remove("date"); // 去除多余的条件
		criteria.remove("countType");
		// 不同身份查询条件
		organizeCriteria(criteria, model, request);
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		if(SecurityUtils.hasRole(RoleType.QWGZX, request)){
			criteria.add("gbcode",currentLoginInfo.getOrganization().getGbCode());
		}
		// 获取选择的镇，中心， 站
		Object gbcode = request.getParameter("gbcode");
		Object centerOrgCode = request.getParameter("centerOrgCode");
		Object orgCode = request.getParameter("orgCode");
		List<String> orgCodes = this.getOrgCodeByOrgCode(request,request.getParameter("gbcode"),request.getParameter("centerOrgCode"),request.getParameter("orgCode"));
		//如果是站-老年人或者医院-老年人健康角色
		if(hasRole(RoleType.ZLNR, request) || hasRole(RoleType.YYLNR, request)){
			Organization org = getCurrentOrg(request);
			orgCode=org.getOrganCode();
		}
		//如果是中心-老年人角色
		if(hasRole(RoleType.ZXLNR, request)){
			Organization org = getCurrentOrg(request);
			centerOrgCode=org.getOrganCode();
		}
		String centerOrgCodelist="";
		/**
		 * type值域 1：全部，2：（选择了镇）当前镇下的所有中心，3：(选择了中心)当前中心下的所有站 ,4:(选择了站)当前站
		 */
		if(ObjectUtil.isNullOrEmpty(gbcode)) { // 没有选择了镇，查询镇下的全部中心
			criteria.add("type", "1");
		} else if(ObjectUtil.isNotEmpty(gbcode) && ObjectUtil.isNullOrEmpty(centerOrgCode)) { // 选择了镇，但是没有选择中心
			criteria.add("type", "2");
			//不是团风镇，选择了镇，但是没有选择中心时统计镇中所有
//			if(!"411481102000".equals(gbcode)){
//				criteria.remove("type");
//				criteria.add("type", "3");
//				Criteria ca = new Criteria();
//				ca.add("GB_CODE",gbcode);
//				ca.add("GENRE_CODE","B100");
//				List<Organization> currentOrg = organizationApp.queryOrganization(ca);
//
//				for (int i = 0; i < currentOrg.size(); i++) {
//					centerOrgCodelist=centerOrgCodelist+",'"+currentOrg.get(i).getOrganCode()+"'";
//				}
//				centerOrgCodelist=centerOrgCodelist.replaceFirst(",", "");
//			}

		} else if(ObjectUtil.isNotEmpty(gbcode) && ObjectUtil.isNotEmpty(centerOrgCode) && ObjectUtil.isNullOrEmpty(orgCode)) { // 镇和中心都选择了，没有选择站
			criteria.add("type", "3");
			// 镇和中心都选择了，没有选择站,只查询中心，除团风镇外
			/*if(!"411481102000".equals(gbcode)){
				criteria.remove("type");
				criteria.add("type", "4");
				orgCode = centerOrgCode;
			}*/

		} else if(ObjectUtil.isNotEmpty(gbcode) && ObjectUtil.isNotEmpty(centerOrgCode) && ObjectUtil.isNotEmpty(orgCode)) { //所有的都选择了
			criteria.add("type", "4");
		}
		criteria.add("gbcode",gbcode);
		if(ObjectUtil.isNotEmpty(centerOrgCode)) {
			criteria.add("centerOrgCode",centerOrgCode);
		}else {
			criteria.add("centerOrgCode",centerOrgCodelist);
		}
		
		criteria.add("orgCode",orgCode);
		List<Map<String,Object>> reports = childStatisticalService.getElderlyManagementSum(criteria,orgCodes);
		model.addAttribute("reports", reports);
		/*List<ElderlyStatistical> reports = childStatisticalService.elderlyStatisticalServiceListSum(criteria);
		int residentNum=0;
		int samsungNum=0;
		int healthManagementNum=0;
		int towstarNum=0;
		for (int i = 0; i < reports.size(); i++) {
			if(ObjectUtil.isNotEmpty(reports.get(i).getResidentNum())){
				residentNum=residentNum+reports.get(i).getResidentNum();
			}
			samsungNum=samsungNum+reports.get(i).getSamsungNum();
			healthManagementNum=healthManagementNum+reports.get(i).getHealthManagementNum();
			towstarNum=towstarNum+reports.get(i).getTowstarNum();
		}
		//ElderlyStatistical elderlyStatisticalServiceDto=childStatisticalService.elderlyStatisticalServiceListSum(criteria);
		ElderlyStatistical elderlyStatisticalServiceDto=new ElderlyStatistical();
		elderlyStatisticalServiceDto.setResidentNum(residentNum);
		elderlyStatisticalServiceDto.setSamsungNum(samsungNum);
		elderlyStatisticalServiceDto.setHealthManagementNum(healthManagementNum);
		elderlyStatisticalServiceDto.setTowstarNum(towstarNum);
		//criteria.remove("orgCode");
		model.addAttribute("currentLoginInfo", currentLoginInfo);
		model.addAttribute("reports", reports);
		model.addAttribute("elderlyStatisticalServiceDto", elderlyStatisticalServiceDto);

		/*Criteria criteria = CriteriaOrganizer.initCriteriaCondition(request.getParameterMap());
		criteria.add("birthday",DateUtil.getBirthdayByAge(65));
		if(criteria.contains("countType")){
			criteria.remove("countType");
		}
		criteria.remove("date"); // 去除多余的条件
		String countType = request.getParameter("countType");
		if("2".equals(countType)){//按月
			criteria.remove("createBeginTime");
			criteria.remove("createEndTime");
		}else if("1".equals(countType)){//按年
			criteria.remove("month");
		}
		criteria.remove("countType");
		// 不同身份查询条件
		organizeCriteria(criteria, model, request);
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		if(SecurityUtils.hasRole(RoleType.QWGZX, request)){
			criteria.add("qwgzxCode",currentLoginInfo.getOrganization().getGbCode());
		}
		List<ElderlyStatistical> reports = childStatisticalService.elderlyStatisticalServiceListSum(criteria);
		int residentNum=0;
		int samsungNum=0;
		int healthManagementNum=0;
		int towstarNum=0;
		for (int i = 0; i < reports.size(); i++) {
			if(ObjectUtil.isNotEmpty(reports.get(i).getResidentNum())){
				residentNum=residentNum+reports.get(i).getResidentNum();
			}
			samsungNum=samsungNum+reports.get(i).getSamsungNum();
			healthManagementNum=healthManagementNum+reports.get(i).getHealthManagementNum();
			towstarNum=towstarNum+reports.get(i).getTowstarNum();
		}
		//ElderlyStatistical elderlyStatisticalServiceDto=childStatisticalService.elderlyStatisticalServiceListSum(criteria);
		ElderlyStatistical elderlyStatisticalServiceDto=new ElderlyStatistical();
		elderlyStatisticalServiceDto.setResidentNum(residentNum);
		elderlyStatisticalServiceDto.setSamsungNum(samsungNum);
		elderlyStatisticalServiceDto.setHealthManagementNum(healthManagementNum);
		elderlyStatisticalServiceDto.setTowstarNum(towstarNum);
		//criteria.remove("orgCode");
		model.addAttribute("currentLoginInfo", currentLoginInfo);
		model.addAttribute("reports", reports);
		model.addAttribute("elderlyStatisticalServiceDto", elderlyStatisticalServiceDto);*/

		return "rhip.phsr.he.childStatistical.elderlyList";
	}

	/**
	 * 根据年份和选择的查询方式计算初始日期和截止日期
	 * @param criteria
	 * @param year
	 */
	private void calculateDate(Criteria criteria,Object year) {
		Object countType = criteria.get("countType");
		if("1".equals(countType)) { // 按年
			criteria.add("startDate",year+"-01-01");
			criteria.add("endDate", year+"-12-31");
		} else { // 按季度
			String month = "99";
			if(ObjectUtil.isNotEmpty(criteria.get("month")))
				month = criteria.get("month").toString();
			switch (month) {
				case "01" : // 第一季度
					criteria.add("startDate",year+"-01-01");
					criteria.add("endDate", year+"-03-31");
					break;
				case "02" : // 第二季度
					criteria.add("startDate",year+"-04-01");
					criteria.add("endDate", year+"-06-30");
					break;
				case "03" :
					criteria.add("startDate",year+"-07-01");
					criteria.add("endDate", year+"-09-30");
					break;
				case "04" :
					criteria.add("startDate",year+"-10-01");
					criteria.add("endDate", year+"-12-31");
					break;
				default :
					criteria.add("startDate",year+"-01-01");
					criteria.add("endDate", year+"-12-31");
					break;
			}
		}
	}

}
