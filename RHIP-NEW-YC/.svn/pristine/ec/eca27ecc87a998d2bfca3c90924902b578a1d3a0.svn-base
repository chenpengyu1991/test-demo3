package com.founder.rhip.hm.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.dto.HealthRecordCensus;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.hm.controller.form.HealthManageQueryForm;
import com.founder.rhip.hm.service.IPhysicalExamRecordService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;

@Controller
@RequestMapping(value = "/hm/statistics")
public class HealthManageStatisticsController extends BaseController {
	
	@Resource(name = "physicalExamRecordService")
	private IPhysicalExamRecordService physicalExamRecordService;
	
    @Autowired
    private IOrganizationApp organizationApp;
	
	/**
	 * 进入体检进度统计查询界面
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("/search")
	public String search(HttpServletRequest request, ModelMap map, Model model) {
//		model.addAttribute("currentYear",new Date());
		model.addAttribute("currentBeginDate", DateUtil.firstDateOfMonth(new Date()));
		model.addAttribute("currentEndDate",new Date());
		return "rhip.hm.statistics.search";
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
	
	/**
	 * 体检进度统计结果界面
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, HealthManageQueryForm queryForm, ModelMap model) {
		Criteria criteria = queryForm.toCriteria();
		criteria.add("genrecode",queryForm.getGenreCode());
		
		
		// 不同身份查询条件
		organizeCriteria(criteria, model, request);
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		if(SecurityUtils.hasRole(RoleType.QWGZX, request)){
			criteria.add("qwgzxCode",currentLoginInfo.getOrganization().getGbCode());
		}
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		if("1".equals(queryForm.getGenreCode())){//统计类型  1机构  2现地址
			mapList = physicalExamRecordService.getElderlyPhysicalExamStatisticsMapList(criteria, 1);
		}else if ("2".equals(queryForm.getGenreCode())){
			mapList = physicalExamRecordService.getElderlyPhysicalExamStatisticsByPaAddress(criteria, 1);
		}
		
		
		//统计总数
		Map<String,Integer> census = countCensus(mapList);
		model.addAttribute("total", census);
		model.addAttribute("patownShip_flag", StringUtil.isNullOrEmpty(queryForm.getPatownShip())?0:1);
	    model.addAttribute("results", mapList);
        model.addAttribute("genrecode", queryForm.getGenreCode());
		return "rhip.hm.statistics.list";
	}
	
    private Map<String, Integer> countCensus(List<Map<String, Object>> reports) {
    	//统计合计信息
		Map<String,Integer> census = new HashMap<String,Integer>();
		census.put("fpg_count", 0 );
		census.put("blood_count", 0 );
		census.put("urine_count", 0 );
		census.put("dyslipidemia_count", 0 );
		census.put("liver_count", 0 );
		
		census.put("renal_count", 0 );
		census.put("b_count", 0 );
		census.put("ecg_count", 0 );
		census.put("older_num", 0 );
		if(ObjectUtil.isNotEmpty(reports)){
			for (Map<String,Object> map : reports) {
				census.put("fpg_count", census.get("fpg_count") + Integer.parseInt(map.get("fpg_count").toString()));
				census.put("blood_count", census.get("blood_count") + Integer.parseInt(map.get("blood_count").toString()));
				census.put("urine_count", census.get("urine_count") + Integer.parseInt(map.get("urine_count").toString()));
				census.put("dyslipidemia_count", census.get("dyslipidemia_count") + Integer.parseInt(map.get("dyslipidemia_count").toString()));
				census.put("liver_count", census.get("liver_count") + Integer.parseInt(map.get("liver_count").toString()));
				
				census.put("renal_count", census.get("renal_count") + Integer.parseInt(map.get("renal_count").toString()));
				census.put("b_count", census.get("b_count") + Integer.parseInt(map.get("b_count").toString()));
				census.put("ecg_count", census.get("ecg_count") + Integer.parseInt(map.get("ecg_count").toString()));
				census.put("older_num", census.get("older_num") + Integer.parseInt(map.get("older_num").toString()));
			}
		}
		return census;
	}

	/**
     * 获取机构下属所有机构
     *
     * @param supOrganCode 中心机构编码
     */
    private List<Organization> getBelongedOrgans(String supOrganCode, String genreCode, String gbCode) {
        List<Organization> organs = new ArrayList<Organization>();
        Criteria c = new Criteria();
        if(StringUtil.isNotEmpty(supOrganCode)){
        	c.add( Organization.PARENT_CODE, supOrganCode);
        }
        if(StringUtil.isNotEmpty(genreCode)){
        	c.add( "GENRE_CODE", genreCode);
        }
        if(StringUtil.isNotEmpty(gbCode)){
        	c.add( "GB_CODE", gbCode);
        }
        organs.addAll(organizationApp.queryOrganization(c));
        return organs;
    }
}
