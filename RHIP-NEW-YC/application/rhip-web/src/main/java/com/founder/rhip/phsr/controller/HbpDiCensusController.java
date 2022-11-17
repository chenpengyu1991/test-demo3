package com.founder.rhip.phsr.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.dto.HbpDiCensus;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.he.controller.VisitController;
import com.founder.rhip.ihm.service.IHbpDiCensusService;

/**
 * 高血压、2型糖尿病患者健康管理统计报表
 * @author admin
 *
 */
@Controller
@RequestMapping(value = "/hbpDiCensus")
public class HbpDiCensusController  extends VisitController{

	@Resource(name = "hbpDiCensusService")
	private IHbpDiCensusService hbpDiCensusService;
	
	/**
	 * 查看高血压统计
	 * 
	 */
	@RequestMapping("/hbpSearch")
	public String search(HttpServletRequest request, ModelMap model) {
		model.addAttribute("currentYear",new Date());
		return "rhip.phsr.hbpDiCensus.hbpSearch";
	}
	
	/**
	 * 查看2型糖尿病统计
	 * 
	 */
	@RequestMapping("/diSearch")
	public String diSearch(HttpServletRequest request, ModelMap model) {
		model.addAttribute("currentYear",new Date());
		return "rhip.phsr.hbpDiCensus.diSearch";
	}
	
	/**
	 * 高血压统计列表
	 * @param request
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/hbplist")
	public String list(HttpServletRequest request, ModelMap model) {
		Criteria criteria = CriteriaOrganizer.initCriteriaCondition(request.getParameterMap());
		criteria.remove("date"); // 去除多余的条件
		String summaryType = request.getParameter("countType");
		if("2".equals(summaryType)){//按月
			criteria.remove("createBeginTime");
			criteria.remove("createEndTime");
		}else if("1".equals(summaryType)){//按年
			criteria.remove("month");
		}
		
		criteria.remove("countType");
		// 不同身份查询条件
		organizeCriteria(criteria, model, request,RoleType.ZXMB,RoleType.ZMB,RoleType.YYMB);
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		if(SecurityUtils.hasRole(RoleType.QWGZX, request)){
			criteria.add("qwgzxCode",currentLoginInfo.getOrganization().getGbCode());
		}
		if(SecurityUtils.hasRole(RoleType.Z_GLY, request) || SecurityUtils.hasRole(RoleType.YYMB, request)) {
			criteria.add("orgCode",currentLoginInfo.getOrganization().getOrganCode());
		}
		List<HbpDiCensus> reports = hbpDiCensusService.hbpDiCensusServiceList(criteria, true);
		
		//统计总数
		HbpDiCensus census = countCensus(reports);
		
		model.addAttribute("currentLoginInfo", currentLoginInfo);
		model.addAttribute("reports", reports);
		model.addAttribute("census", census);
		
		return "rhip.phsr.hbpDiCensus.hbplist";
	}
	
	/**
	 * 糖尿病统计列表
	 * @param request
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/dilist")
	public String diList(HttpServletRequest request, ModelMap model) {
		Criteria criteria = CriteriaOrganizer.initCriteriaCondition(request.getParameterMap());
		criteria.remove("date"); // 去除多余的条件
		String summaryType = request.getParameter("countType");
		if("2".equals(summaryType)){//按月
			criteria.remove("createBeginTime");
			criteria.remove("createEndTime");
		}else if("1".equals(summaryType)){//按年
			criteria.remove("month");
		}
		
		criteria.remove("countType");
		// 不同身份查询条件
		organizeCriteria(criteria, model, request,RoleType.ZXMB,RoleType.ZMB,RoleType.YYMB);
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		if(SecurityUtils.hasRole(RoleType.QWGZX, request)){
			criteria.add("qwgzxCode",currentLoginInfo.getOrganization().getGbCode());
		}
		if(SecurityUtils.hasRole(RoleType.Z_GLY, request) || SecurityUtils.hasRole(RoleType.YYMB, request)) {
			criteria.add("orgCode",currentLoginInfo.getOrganization().getOrganCode());
		}
		List<HbpDiCensus> reports = hbpDiCensusService.hbpDiCensusServiceList(criteria, false);
		
		//统计总数
		HbpDiCensus census = countCensus(reports);
		
		model.addAttribute("currentLoginInfo", currentLoginInfo);
		model.addAttribute("reports", reports);
		model.addAttribute("census", census);
		
		return "rhip.phsr.hbpDiCensus.dilist";
	}
	
	private HbpDiCensus countCensus(List<HbpDiCensus> reports){
		//统计合计信息
		HbpDiCensus hbpDiCensus = new HbpDiCensus();
		
		if(ObjectUtil.isNotEmpty(reports)){
			int hbpSum = 0;//辖区内已管理高血压患者总数
			int hbpManageSum = 0;//按照规范要求进行高血压患者健康管理的总数
			int hbpBpSum = 0;//最后一次随访血压达标总数
			int hbpSignSum = 0;//在管高血压患者家庭医生签约总数
			int diSum = 0; //辖区内已管理的2型糖尿病患者总数
			int diManageSum = 0; //按照规范要求进行2型糖尿病患者总数
			int diBsStandardSum = 0;	//最近一次随访空腹血糖达标总数
			int hbpShouldSum =0;  //高血压患者人数
			int diShouldSum = 0; //糖尿病患者人数
			int diSignCount = 0; // 糖尿病家庭医生签约数

			int diTwoHStandardSum = 0;	//最近一次餐后2小时血糖达标总数
			
			for (HbpDiCensus report : reports) {
				hbpSum += report.getHbpCount() == null ? 0 : report.getHbpCount();
				hbpManageSum += report.getHbpManageCount() == null ? 0 : report.getHbpManageCount();
				hbpBpSum += report.getHbpBpCount() == null ? 0 :report.getHbpBpCount();
				hbpSignSum += report.getHbpSignCount() == null ? 0 :report.getHbpSignCount();
				diSum += report.getDiCount() == null ? 0 :report.getDiCount();
				diManageSum += report.getDiManageCount()== null ? 0 :report.getDiManageCount();
				diBsStandardSum += report.getDiBsCount() == null ? 0 :report.getDiBsCount();
				diTwoHStandardSum += report.getDiTwohourCount() == null ? 0 :report.getDiTwohourCount();
				hbpShouldSum += report.getHbpShouldCount() == null ? 0 :report.getHbpShouldCount();
				diShouldSum += report.getDiShouldCount() == null ? 0 : report.getDiShouldCount();
				diSignCount += report.getDiSignCount() == null ? 0 : report.getDiSignCount();
			}
			hbpDiCensus.setHbpSum(hbpSum);
			hbpDiCensus.setHbpManageSum(hbpManageSum);
			hbpDiCensus.setHbpBpSum(hbpBpSum);
			hbpDiCensus.setHbpSignSum(hbpSignSum);
			hbpDiCensus.setDiSum(diSum);
			hbpDiCensus.setDiManageSum(diManageSum);
			hbpDiCensus.setDiBsSum(diBsStandardSum);
			hbpDiCensus.setDiTwoHSum(diTwoHStandardSum);
			hbpDiCensus.setHbpShouldSum(hbpShouldSum);
			hbpDiCensus.setDiShouldSum(diShouldSum);
			hbpDiCensus.setDiSignCount(diSignCount);
		}
		return hbpDiCensus;
	}
}
