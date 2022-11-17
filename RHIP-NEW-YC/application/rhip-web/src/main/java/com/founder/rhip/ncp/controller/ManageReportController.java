package com.founder.rhip.ncp.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.dto.HealthEducationReport;
import com.founder.rhip.ehr.dto.HealthRecordCensus;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.ihm.service.IHealthRecordCensusService;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.ncp.controller.form.ManageReportForm;
import com.founder.rhip.ncp.dto.NcpClassifyReport;
import com.founder.rhip.ncp.dto.NcpHealthReport;
import com.founder.rhip.ncp.dto.NcpManageReport;
import com.founder.rhip.ncp.service.IReportService;
import com.founder.rhip.phsr.controller.form.HealthEducationQueryForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 城乡居民健康档案管理统计报表
 * @author admin
 *
 */
@Controller
@RequestMapping(value = "/ncp/manageReport")
public class ManageReportController extends BaseController {

	@Autowired
	private IReportService reportService;

    /**
     * 绩效考核查询
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/search")
    public String Search(HttpServletRequest request, ModelMap model) {
        return "rhip.ncp.manageReport.search";
    }

    /**
     * 绩效考核列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String List(HttpServletRequest request, ModelMap model, ManageReportForm queryForm) {
		Criteria criteria = queryForm.toCriteria();
		organizeCriteria(criteria, model, request);
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		if(SecurityUtils.hasRole(RoleType.QWGZX, request)){
			criteria.add("qwgzxCode",currentLoginInfo.getOrganization().getGbCode());
		}
		List<NcpManageReport> reports = reportService.getNcpManageReports(criteria);
		NcpManageReport total = new NcpManageReport();
		total.setManageDoctorName("合计");
		Long healthCardNum = 0L;
		Long monitorNum = 0L;
		Long followupNum = 0L;
		Long reviewNum = 0L;
		for (NcpManageReport report : reports){
			healthCardNum += report.getHealthCardNum();
			monitorNum += report.getMonitorNum();
			followupNum += report.getFollowupNum();
			reviewNum += report.getReviewNum();
		}
		total.setHealthCardNum(healthCardNum);
		total.setMonitorNum(monitorNum);
		total.setReviewNum(reviewNum);
		total.setFollowupNum(followupNum);

		model.addAttribute("reports", reports);
		model.addAttribute("total", total);

		if ("1".equals(queryForm.getSelectMethod())){
			return "rhip.ncp.manageReport.list";
		}else {
			return "rhip.ncp.manageReport.listByOrg";
		}

	}


	/**
	 * 病例分类查询
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/classify/search")
	public String classifySearch(HttpServletRequest request, ModelMap model) {
		return "rhip.ncp.manageReport.classify.search";
	}

	/**
	 * 病例分类列表
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/classify/list")
	public String classifyList(HttpServletRequest request, ModelMap model, ManageReportForm queryForm) {
		Criteria criteria = queryForm.toCriteria();
		organizeCriteria(criteria, model, request);
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		if(SecurityUtils.hasRole(RoleType.QWGZX, request)){
			criteria.add("qwgzxCode",currentLoginInfo.getOrganization().getGbCode());
		}
		List<NcpClassifyReport> reports = reportService.getNcpClassifyReports(criteria);
		NcpClassifyReport total = new NcpClassifyReport();
		total.setManageOrgName("合计");
		Long insideTreatNum = 0L;
		Long outsideTreatNum = 0L;
		Long suspectedNum = 0L;
		Long asymptomaticNum = 0L;
		for (NcpClassifyReport report : reports){
			insideTreatNum += report.getInsideTreatNum();
			outsideTreatNum += report.getOutsideTreatNum();
			suspectedNum += report.getSuspectedNum();
			asymptomaticNum += report.getAsymptomaticNum();
		}
		total.setInsideTreatNum(insideTreatNum);
		total.setOutsideTreatNum(outsideTreatNum);
		total.setSuspectedNum(suspectedNum);
		total.setAsymptomaticNum(asymptomaticNum);

		model.addAttribute("reports", reports);
		model.addAttribute("total", total);

		return "rhip.ncp.manageReport.classify.list";
	}

	/**
	 * 健康管理查询
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/health/search")
	public String healthSearch(HttpServletRequest request, ModelMap model) {
		return "rhip.ncp.manageReport.health.search";
	}

	/**
	 * 健康管理列表
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/health/list")
	public String healthList(HttpServletRequest request, ModelMap model, ManageReportForm queryForm) {
		Criteria criteria = queryForm.toCriteria();
		organizeCriteria(criteria, model, request);
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		if(SecurityUtils.hasRole(RoleType.QWGZX, request)){
			criteria.add("qwgzxCode",currentLoginInfo.getOrganization().getGbCode());
		}
		List<NcpHealthReport> reports = reportService.getNcpHealthReports(criteria);
		NcpHealthReport total = new NcpHealthReport();
		Long healthCardNum = 0L;
		Long monitorNum = 0L;
		Long followupNum = 0L;
		Long reviewNum = 0L;
		for (NcpHealthReport report : reports){
			healthCardNum += report.getHealthCardNum();
			monitorNum += report.getMonitorNum();
			followupNum += report.getFollowupNum();
			reviewNum += report.getReviewNum();
		}
		total.setHealthCardNum(healthCardNum);
		total.setMonitorNum(monitorNum);
		total.setReviewNum(reviewNum);
		total.setFollowupNum(followupNum);

		model.addAttribute("reports", reports);
		model.addAttribute("total", total);

		return "rhip.ncp.manageReport.health.list";

	}

	/**
	 * 组织不同身份查询条件
	 *
	 * @param criteria
	 * @param model
	 * @param request
	 */
	protected void organizeCriteria(Criteria criteria, ModelMap model, HttpServletRequest request) {
		Organization org = getCurrentOrg(request);
		model.addAttribute("createrOrg", hasRole(RoleType.YY_GLY, request) ? "_999" : org.getOrganCode()); // 用来控制编辑与删除的操作
		if (!criteria.contains("organCode")) {
			if (hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.ZXJKDN, request)) {
				criteria.add("centerOrgCode", org.getOrganCode());
			} else if (hasRole(RoleType.Z_GLY, request) || hasRole(RoleType.ZJKDN, request)) {
				criteria.add("orgCode", org.getOrganCode());
			}
		}

		// 用来页面判断显示机构
		if (criteria.contains("orgCode")) {
			model.addAttribute("orgCode", criteria.get("orgCode"));
		} else if (criteria.contains("centerOrgCode")) {
			model.addAttribute("centerOrgCode", criteria.get("centerOrgCode"));
		} else if (criteria.contains("gbcode")) {
			model.addAttribute("gbcode", criteria.get("gbcode"));
		}else{
			model.addAttribute("all", "all");
		}
	}

}
