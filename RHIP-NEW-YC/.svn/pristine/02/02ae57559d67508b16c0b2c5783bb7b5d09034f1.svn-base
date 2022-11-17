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
import com.founder.rhip.ehr.dto.DoctorSignCensus;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.he.controller.VisitController;
import com.founder.rhip.ihm.service.IDoctorSignCensusService;

/**
 * 家庭医生签约服务进展情况统计
 *
 */
@Controller
@RequestMapping(value = "/doctorSignCensus")
public class DoctorSignCensusController  extends VisitController{

	@Resource(name = "doctorSignCensusService")
	private IDoctorSignCensusService doctorSignCensusService;
	
	/**
	 * 查看
	 * 
	 */
	@RequestMapping("/search")
	public String search(HttpServletRequest request, ModelMap model) {
		model.addAttribute("currentYear",new Date());
		return "rhip.phsr.doctorSignCensus.search";
	}
	
	/**
	 * 统计列表
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
		organizeCriteria(criteria, model, request,RoleType.ZXJKDN,RoleType.ZJKDN,null);
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		if(SecurityUtils.hasRole(RoleType.QWGZX, request)){
			criteria.add("qwgzxCode",currentLoginInfo.getOrganization().getGbCode());
		}
		List<DoctorSignCensus> reports = doctorSignCensusService.getDoctorSignCensusList(criteria);
		
		//统计总数
		DoctorSignCensus census = countCensus(reports);
		
		model.addAttribute("currentLoginInfo", currentLoginInfo);
		model.addAttribute("reports", reports);
		model.addAttribute("census", census);
		return "rhip.phsr.doctorSignCensus.list";
	}
	
	private DoctorSignCensus countCensus(List<DoctorSignCensus> reports){
		//统计合计信息
		DoctorSignCensus dsCensus = new DoctorSignCensus();
		
		if(ObjectUtil.isNotEmpty(reports)){
			for (DoctorSignCensus report : reports) {
				dsCensus.setDoctorTeamNum(dsCensus.getDoctorTeamNum() + (report.getDoctorTeamNum()==null?0:report.getDoctorTeamNum()));
				dsCensus.setHouseholdNum(dsCensus.getHouseholdNum() + (report.getHouseholdNum()==null?0:report.getHouseholdNum()));
				dsCensus.setPermanentNum(dsCensus.getPermanentNum() + (report.getPermanentNum()==null?0:report.getPermanentNum()));
				dsCensus.setPermanentSignNum(dsCensus.getPermanentSignNum() + (report.getPermanentSignNum()==null?0:report.getPermanentSignNum()));
				dsCensus.setFocusGroupsNum(dsCensus.getFocusGroupsNum() + (report.getFocusGroupsNum()==null?0:report.getFocusGroupsNum()));
				
				dsCensus.setFocusGroupsSignNum(dsCensus.getFocusGroupsSignNum() + (report.getFocusGroupsSignNum()==null?0:report.getFocusGroupsSignNum()));
				dsCensus.setChildNum(dsCensus.getChildNum() + (report.getChildNum()==null?0:report.getChildNum()));
				dsCensus.setFamilyVisitNum(dsCensus.getFamilyVisitNum() + (report.getFamilyVisitNum()==null?0:report.getFamilyVisitNum()));
				dsCensus.setChildSignNum(dsCensus.getChildSignNum() + (report.getChildSignNum()==null?0:report.getChildSignNum()));
				dsCensus.setHouseholdGreatSixfNum(dsCensus.getHouseholdGreatSixfNum() + (report.getHouseholdGreatSixfNum()==null?0:report.getHouseholdGreatSixfNum()));
				
				dsCensus.setGreatSixfHasNum(dsCensus.getGreatSixfHasNum() + (report.getGreatSixfHasNum()==null?0:report.getGreatSixfHasNum()));
				dsCensus.setGreatSixfSignNum(dsCensus.getGreatSixfSignNum() + (report.getGreatSixfSignNum()==null?0:report.getGreatSixfSignNum()));
				dsCensus.setWomenNum(dsCensus.getWomenNum() + (report.getWomenNum()==null?0:report.getWomenNum()));
				dsCensus.setWomenSignNum(dsCensus.getWomenSignNum() + (report.getWomenSignNum()==null?0:report.getWomenSignNum()));
				dsCensus.setHbpNum(dsCensus.getHbpNum() + (report.getHbpNum()==null?0:report.getHbpNum()));
				
				dsCensus.setHbpHasNum(dsCensus.getHbpHasNum() + (report.getHbpHasNum()==null?0:report.getHbpHasNum()));
				dsCensus.setHbpSignNum(dsCensus.getHbpSignNum() + (report.getHbpSignNum()==null?0:report.getHbpSignNum()));
				dsCensus.setDiNum(dsCensus.getDiNum() + (report.getDiNum()==null?0:report.getDiNum()));
				dsCensus.setDiHasNum(dsCensus.getDiHasNum() + (report.getDiHasNum()==null?0:report.getDiHasNum()));
				dsCensus.setDiSignNum(dsCensus.getDiSignNum() + (report.getDiSignNum()==null?0:report.getDiSignNum()));
				
				dsCensus.setTubercManageNum(dsCensus.getTubercManageNum() +  (report.getTubercManageNum()==null?0:report.getTubercManageNum()));
				dsCensus.setTubercSignNum(dsCensus.getTubercSignNum() + (report.getTubercSignNum()==null?0:report.getTubercSignNum()));
				dsCensus.setMentalManageNum(dsCensus.getMentalManageNum() + (report.getMentalManageNum()==null?0:report.getMentalManageNum()));
				dsCensus.setMentalSignNum(dsCensus.getMentalSignNum() + (report.getMentalSignNum()==null?0:report.getMentalSignNum()));
			}
		}
		return dsCensus;
	}
}
