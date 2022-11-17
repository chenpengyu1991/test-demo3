package com.founder.rhip.hm.controller;

import com.founder.fasf.util.ObjectUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.dto.PhysicalExaminationStatisticsSummary;
import com.founder.rhip.hm.controller.form.HealthManageQueryForm;
import com.founder.rhip.hm.service.IPhysicalExamRecordService;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;

@Controller
@RequestMapping(value = "/hm/progress")
public class ProgressStatisticsController extends BaseController {

    @Resource(name = "physicalExamRecordService")
    private IPhysicalExamRecordService physicalExamRecordService;

    @Autowired
    private IOrganizationApp organizationApp;

    /**
     * 进入体检进度查询界面
     */
    @RequestMapping("/search")
    public String search(HealthManageQueryForm queryForm, HttpServletRequest request, Model model) {
//        model.addAttribute("beginDate", DateUtil.firstDateOfYear(new Date()));
//        model.addAttribute("endDate", new Date());
        model.addAttribute("currentBeginDate", DateUtil.firstDateOfMonth(new Date()));
		model.addAttribute("currentEndDate",new Date());
        return "rhip.hm.progress.search";
    }

    /**
     * 体检进度统计结果界面
     */
    @RequestMapping("/list")
    public String list(HttpServletRequest request, HealthManageQueryForm queryForm, Model model) {
    	Criteria criteria = queryForm.toCriteria();
		// 不同身份查询条件
		organizeCriteria(criteria, model, request);
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		if(SecurityUtils.hasRole(RoleType.QWGZX, request)){
			criteria.add("qwgzxCode",currentLoginInfo.getOrganization().getGbCode());
		}
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		if("1".equals(queryForm.getGenreCode())){//统计类型  1机构  2现地址
			mapList = physicalExamRecordService.getElderlyPhysicalExamStatisticsMapList(criteria, 2);
		}else if ("2".equals(queryForm.getGenreCode())){
			mapList = physicalExamRecordService.getElderlyPhysicalExamStatisticsByPaAddress(criteria, 2);
		}
		
        //统计总数
  		Map<String,Object> census = countCensus(mapList);
  		
  		model.addAttribute("total", census);
  		model.addAttribute("patownShip_flag", StringUtil.isNullOrEmpty(queryForm.getPatownShip())?0:1);
  	    model.addAttribute("results", mapList);
  	    model.addAttribute("genrecode", queryForm.getGenreCode());
        return "rhip.hm.progress.list";
    }

    private Map<String, Object> countCensus(List<Map<String, Object>> reports) {
    	//统计合计信息
		Map<String,Object> census = new HashMap<String,Object>();
		census.put("estimate_sum", 0 );
		census.put("exam_count", 0 );
		census.put("exam_sum", 0 );
		census.put("manage_sum", 0 );
		census.put("guide_sum", 0 );
		census.put("fill_count", 0 );
		census.put("older_num", 0 );
		census.put("tcm_count", 0 );
		if(ObjectUtil.isNotEmpty(reports)){
			for (Map<String,Object> map : reports) {
				census.put("estimate_sum", Integer.parseInt(census.get("estimate_sum").toString()) + Integer.parseInt(map.get("estimate_sum").toString()));
				census.put("exam_count", Integer.parseInt(census.get("exam_count").toString()) + Integer.parseInt(map.get("exam_count").toString()));
				census.put("exam_sum", Integer.parseInt(census.get("exam_sum").toString()) + Integer.parseInt(map.get("exam_sum").toString()));
				census.put("manage_sum", Integer.parseInt(census.get("manage_sum").toString()) + Integer.parseInt(map.get("manage_sum").toString()));
				census.put("guide_sum", Integer.parseInt(census.get("guide_sum").toString()) + Integer.parseInt(map.get("guide_sum").toString()));
				census.put("fill_count", Integer.parseInt(census.get("fill_count").toString()) + Integer.parseInt(map.get("fill_count").toString()));
				census.put("older_num", Integer.parseInt(census.get("older_num").toString()) + Integer.parseInt(map.get("older_num").toString()));
				census.put("tcm_count", Integer.parseInt(census.get("tcm_count").toString()) + Integer.parseInt(map.get("tcm_count").toString()));
			}
		}
		return census;
	}
    
    /**
     * 获取机构下属所有机构
     *
     * @param supOrganCode 中心机构编码
     */
    private List<Organization> getBelongedOrgans(String supOrganCode, String genreCode) {
        List<Organization> organs = new ArrayList<Organization>();
        organs.addAll(organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, supOrganCode).add("GENRE_CODE", genreCode)));
        return organs;
    }

	/**
	 * 组织不同身份查询条件
	 * 
	 * @param criteria
	 * @param model
	 * @param request
	 */
	protected void organizeCriteria(Criteria criteria, Model model, HttpServletRequest request) {
		Organization org = getCurrentOrg(request);
		model.addAttribute("createrOrg", hasRole(RoleType.YY_GLY, request) ? "_999" : org.getOrganCode()); // 用来控制编辑与删除的操作
		if (!criteria.contains("organCode")) {
			if (hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.ZXJKDN, request)) {
				criteria.add("centerCode", org.getOrganCode());
			} else if (hasRole(RoleType.Z_GLY, request) || hasRole(RoleType.ZJKDN, request)) {
				criteria.add("orgCode", org.getOrganCode());
			}
		}
		
		// 用来页面判断显示机构
		if (criteria.contains("orgCode")) {
			model.addAttribute("orgCode", criteria.get("orgCode")); 
		} else if (criteria.contains("centerCode")) {
			model.addAttribute("centerCode", criteria.get("centerCode")); 
		} else if (criteria.contains("gbcode")) {
			model.addAttribute("gbcode", criteria.get("gbcode")); 
		}else{
			model.addAttribute("all", "all"); 
		}
	}
	
}
