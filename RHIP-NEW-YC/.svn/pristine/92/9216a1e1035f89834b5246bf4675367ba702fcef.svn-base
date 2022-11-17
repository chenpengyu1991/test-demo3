package com.founder.rhip.hsa.controller.insp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.dto.HealthRecordCensus;
import com.founder.rhip.ehr.dto.HealthSuperviseForm;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.statisticsdto.HsaServiceReport;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.hsa.controller.HsaController;
import com.founder.rhip.hsa.service.IHsaServiceReportService;
import com.ibm.wsdl.util.StringUtils;

/**
 * 统计报表
 * 
 * @author liuk
 * 
 */
@Controller("HsaReportController")
public class ReportController extends HsaController {

	private final static String CONTROLLER_NAME = " 统计报表";

	@Resource(name = "hsaServiceReportService")
	private IHsaServiceReportService serviceReportService;

    @Autowired
    private IOrganizationApp organizationApp;


	@RequestMapping(value = "hsa/inspRecord/report/list")
	public String main(ModelMap model) {
		model.put("currentDate", new Date());
		return "rhip.hsa.insp.report.serviceReport";
	}

	@RequestMapping(value = "hsa/inspRecord/report/serviceReportResult")
	public String serviceReportResult(ReportQueryForm queryForm, ModelMap model, HttpServletRequest request) throws ParseException {
		// 统计权限
		// TODO
		String yearMonthEndDate=null;
		String yearMonthStart=null;
		if (RoleType.Z_GLY.equals(getHrRole(request))||RoleType.ZWJ.equals(getHrRole(request))) {
			queryForm.setOrganCode(getCurrentOrg(request).getOrganCode());
		}
		if (RoleType.ZX_GLY.equals(getHrRole(request))||RoleType.ZXWJ.equals(getHrRole(request))) {
			queryForm.setOrganCode(getCurrentOrg(request).getOrganCode());
		}
		if(ObjectUtil.isNotEmpty(request.getParameter("yearMonthStart"))){
			String yearMonthDate=request.getParameter("yearMonthStart");
			yearMonthStart=yearMonthDate+" 00:00:00";
		}
		if(ObjectUtil.isNotEmpty(request.getParameter("yearMonthEnd"))){
			String yearMonthEnd=request.getParameter("yearMonthEnd");
			yearMonthEndDate=yearMonthEnd+" 23:59:59";
		}
		Map<String, HsaServiceReport> reportRecord = serviceReportService.getReportData(queryForm.getGbCode(), queryForm.getOrganCode(), yearMonthStart,yearMonthEndDate);
		Map<String, HsaServiceReport> inspection = serviceReportService.getInspectionData(queryForm.getGbCode(), queryForm.getOrganCode(), yearMonthStart,yearMonthEndDate);
		Map<String, HsaServiceReport> edu = serviceReportService.getEduData(queryForm.getGbCode(), queryForm.getOrganCode(), yearMonthStart,yearMonthEndDate);
		Map<String, HsaServiceReport> sodp = serviceReportService.getSodpData(queryForm.getGbCode(), queryForm.getOrganCode(), yearMonthStart,yearMonthEndDate);
		model.addAttribute("reportRecord", reportRecord);
		model.addAttribute("inspection", inspection);
		model.addAttribute("edu", edu);
		model.addAttribute("sodp", sodp);
		setCurrentInfo(model, request);
		return "rhip.hsa.insp.report.serviceReportResult";
	}



    @RequestMapping(value = "/hsa/inspRecord/healthSpur/search")
    public String mainSec(HttpServletRequest request, ModelMap model) {
    	//判断机构
        String roleType = "";
        if (hasRole(RoleType.Z_GLY, request)) {
            roleType = RoleType.Z_GLY.getValue();
        }
        if (hasRole(RoleType.ZX_GLY, request)) {
            roleType = RoleType.ZX_GLY.getValue();
        }
        try {
            int year = new Date().getYear() + 1900;
            SimpleDateFormat sd = new SimpleDateFormat("yyyy");
            Date date = sd.parse(String.valueOf(year));
            model.addAttribute("searchDate", date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("roleType", roleType);
        return "rhip.hsa.insp.report.serviceReportSec";
    }

    @RequestMapping(value = "/hsa/inspRecord/healthSpur/list")
    public String serviceReportResultSec(HealthSuperviseForm initForm, ModelMap model, HttpServletRequest request) {
    	Criteria criteria = CriteriaOrganizer.initCriteriaCondition(request.getParameterMap());
        String countType = initForm.getCountType();
		if("1".equals(countType)){//按年
			criteria.remove("quarter");
		}
		
		String roleType = "";
		// 不同身份查询条件
		organizeCriteria(criteria, model, request);
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		if(SecurityUtils.hasRole(RoleType.QWGZX, request)){
			criteria.add("qwgzxCode",currentLoginInfo.getOrganization().getGbCode());
		}
		if(SecurityUtils.hasRole(RoleType.Z_GLY, request) || SecurityUtils.hasRole(RoleType.YYMB, request)) {
			criteria.add("orgCode",currentLoginInfo.getOrganization().getOrganCode());
		}
		
		List<Map<String,Object>> mapList = serviceReportService.getHealthSupervisionList(criteria);  
		
		//统计总数
		Map<String,Integer> census = countCensus(mapList);
		
		model.addAttribute("total", census);
	    model.addAttribute("reports", mapList);
        model.addAttribute("ROLE", roleType);
		        
        return "rhip.hsa.insp.report.serviceReportResultSec";
    }

	private Map<String,Integer> countCensus(List<Map<String,Object>> reports) {
		//统计合计信息
		Map<String,Integer> census = new HashMap<String,Integer>();
		census.put("reportnum", 0 );
		census.put("patrolnum", 0 );
		census.put("unitnum", 0 );
		census.put("findnum", 0 );
		if(ObjectUtil.isNotEmpty(reports)){
			for (Map<String,Object> map : reports) {
				census.put("reportnum", census.get("reportnum") + Integer.parseInt(map.get("reportnum").toString()));
				census.put("patrolnum", census.get("patrolnum") + Integer.parseInt(map.get("patrolnum").toString()));
				census.put("unitnum", census.get("unitnum") + Integer.parseInt(map.get("unitnum").toString()));
				census.put("findnum", census.get("findnum") + Integer.parseInt(map.get("findnum").toString()));
			}
		}
		return census;
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

    private void getqx(List<Map<String,Object>> mapList){
        if(ObjectUtil.isNotEmpty(mapList)){
            String qx = "";
            for(Map<String,Object> map : mapList){
                List<Organization> orgs =   organizationApp.queryOrganization(new Criteria().add("organName",map.get("organ_name").toString()));
                List<Organization> qxs =   organizationApp.queryOrganization(new Criteria().add("genreCode","R11").add("gbCode",orgs.get(0).getGbCode()));
                if(qxs.get(0).getOrganName().contains("兴庆")){
                    qx = "兴庆区";
                }else if(qxs.get(0).getOrganName().contains("金凤")){
                    qx = "金凤区";
                }else if(qxs.get(0).getOrganName().contains("永宁")){
                    qx = "永宁县";
                }else if(qxs.get(0).getOrganName().contains("贺兰")){
                    qx = "贺兰县";
                }else if(qxs.get(0).getOrganName().contains("西夏")){
                    qx = "西夏区";
                }else if(qxs.get(0).getOrganName().contains("灵武")){
                    qx = "灵武市";
                }
                map.put("qx",qx);
            }
        }
    }

    private Map<String,Object> getCenterTotal(String orgCode,int reportnum,int patrolnum,HealthSuperviseForm initForm){
        Map<String,Object> all = new HashedMap();
        List<Organization> organizations = organizationApp.queryOrganization(new Criteria().add("parentCode",orgCode));
        if(ObjectUtil.isNotEmpty(organizations)){
            for(Organization organization : organizations){
                List<Map<String,Object>> mapTotalList =  serviceReportService.getHealthSupervisionStation(organization.getOrganCode(),initForm);
                if(ObjectUtil.isNotEmpty(mapTotalList)){
                    reportnum =reportnum+Integer.valueOf(mapTotalList.get(0).get("reportnum").toString());
                    patrolnum =patrolnum+Integer.valueOf(mapTotalList.get(0).get("patrolnum").toString());
                }
            }
        }
        List<Map<String,Object>> mapTotalList =  serviceReportService.getHealthSupervisionStation(organizationApp.queryOrgan(orgCode).getOrganCode(),initForm);
        if(ObjectUtil.isNotEmpty(mapTotalList)){
            reportnum =reportnum+Integer.valueOf(mapTotalList.get(0).get("reportnum").toString());
            patrolnum =patrolnum+Integer.valueOf(mapTotalList.get(0).get("patrolnum").toString());
        }
        all.put("reportnum",reportnum);
        all.put("patrolnum",patrolnum);
        return all;
    }

	@Override
	protected String getActionName() {
		return CONTROLLER_NAME;
	}

}
