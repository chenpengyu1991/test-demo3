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
import com.founder.rhip.ehr.dto.ChildCensus;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.dto.MedicineCensus;
import com.founder.rhip.ehr.dto.VaccinationService;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.he.controller.VisitController;
import com.founder.rhip.ihm.service.ImedicineCensusService;

/**
 * 中医药健康管理统计报表
 */
@Controller
@RequestMapping(value = "/medicineCensus")
public class MedicineCensusController  extends VisitController{

	@Resource(name = "medicineCensusService")
	private ImedicineCensusService medicineCensusService;
	
	/**
	 * 查看中医药健康管理统计
	 * 
	 */
	@RequestMapping("/search")
	public String search(HttpServletRequest request, ModelMap model) {
		model.addAttribute("currentYear",new Date());
		return "rhip.phsr.medicineCensus.search";
	}
	
	
	/**
	 * 列表显示中医药健康管理统计报表
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/list")
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
		organizeCriteria(criteria, model, request, RoleType.ZXZYY, RoleType.ZZYY, RoleType.YYZYY);
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		if(SecurityUtils.hasRole(RoleType.QWGZX, request)){
			criteria.add("qwgzxCode",currentLoginInfo.getOrganization().getGbCode());
		}
		if(SecurityUtils.hasRole(RoleType.Z_GLY, request) || SecurityUtils.hasRole(RoleType.YYMB, request)) {
			criteria.add("orgCode",currentLoginInfo.getOrganization().getOrganCode());
		}
		List<MedicineCensus> reports = medicineCensusService.MedicineCensusServiceList(criteria);
		
		//统计总数
		MedicineCensus census = countCensus(reports);
		
		model.addAttribute("currentLoginInfo", currentLoginInfo);
		model.addAttribute("reports", reports);
		model.addAttribute("census", census);
		
		return "rhip.phsr.medicineCensus.list";
	}
	
	private MedicineCensus countCensus(List<MedicineCensus> reports){
		//统计合计信息
		MedicineCensus medicineCensus = new MedicineCensus();
		if(ObjectUtil.isNotEmpty(reports)){
			int householdGreatSixfSum = 0;//65岁以上老人常住人口总数
			int medicineGreatSixfSum = 0;//65岁以上老人接受中医服务总数
			int diSum = 0;//已管理糖尿病患者总数
			int hbpSum = 0;//已管理高血压患者总数
			int diManageSum = 0; //接受中医药健康管理的糖尿病患者总数
			int hbpManageSum = 0; //接受中医药健康管理的高血压患者总数
			int womenSum = 0;	//已管理孕产妇总数
			int womenServeSum = 0; //接受中医药健康管理的孕产妇总数
			int childSum = 0;	//已管理儿童数
			int childServeSum = 0;	//接受全部中医药服务的儿童数
			
			for (MedicineCensus report : reports) {
				householdGreatSixfSum += report.getHouseholdGreatSixfNum() == null ? 0 : report.getHouseholdGreatSixfNum();
				medicineGreatSixfSum += report.getMedicineGreatSixfNum() == null ? 0 : report.getMedicineGreatSixfNum();
				diSum += report.getDiCount() == null ? 0 :report.getDiCount();
				hbpSum += report.getHbpCount() == null ? 0 :report.getHbpCount();
				diManageSum += report.getDiManageCount() == null ? 0 :report.getDiManageCount();
				
				hbpManageSum += report.getHbpServeCount()== null ? 0 :report.getHbpServeCount();
				womenSum += report.getWomenCount() == null ? 0 :report.getWomenCount();
				womenServeSum += report.getWomenServeCount() == null ? 0 : report.getWomenServeCount();
				childSum += report.getChildCount() == null ? 0 : report.getChildCount();
				childServeSum += report.getChildServeCount() == null ? 0 :report.getChildServeCount();
			}
			medicineCensus.setHouseholdGreatSixfSum(householdGreatSixfSum);
			medicineCensus.setMedicineGreatSixfSum(medicineGreatSixfSum);
			medicineCensus.setDiSum(diSum);
			medicineCensus.setHbpSum(hbpSum);
			medicineCensus.setDiManageSum(diManageSum);
			medicineCensus.setHbpManageSum(hbpManageSum);
			medicineCensus.setWomenSum(womenSum);
			medicineCensus.setWomenServeSum(womenServeSum);
			medicineCensus.setChildSum(childSum);
			medicineCensus.setChildServeSum(childServeSum);
		}
		
		return medicineCensus;
	}
}
