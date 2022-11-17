package com.founder.rhip.ehr.controller.recordhome;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.elb.common.MessageUtils;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.entity.basic.HaStatistics;
import com.founder.rhip.ehr.service.statistics.IIdmStatisticsService;
import com.founder.rhip.ehr.service.statistics.IStatisticsService;
import com.founder.rhip.mdm.entity.Organization;

@Controller
@RequestMapping("/haStatistics")
public class HaStatisticsController extends BaseController {

	@Autowired
    private IStatisticsService statisticsService;
	
	@Autowired(required=false)
	private IIdmStatisticsService idmStatisticsService;

	@Autowired
	private IOrganizationApp organizationApp;
	/**
	 * 获取社区卫生站档案管理数据
	 * @param httpServletRequest
	 * @param
	 * @param
	 */
	@RequestMapping(value="/getCommunityArchiveManagementList")
    public @ResponseBody Map<String,Long> getCommunityArchiveManagementList(HttpServletRequest httpServletRequest,String statisticsDate) {
		String orgCode = SecurityUtils.getCurrentOrganization(httpServletRequest).getOrganCode();
		Map<String,Long> map = statisticsService.getArchiveManagementList(statisticsDate,SecurityUtils.getCurrentOrganization(httpServletRequest),2);
		return map;
    }
	
	/**
	 * 获取社区卫生服务中心档案管理数据
	 * @param httpServletRequest
	 * @param
	 * @param
	 */
	@RequestMapping(value="/getCdcArchiveManagementList")
    public @ResponseBody Map<String,Long> getCdcArchiveManagementList(HttpServletRequest httpServletRequest,String statisticsDate) {
		String orgCode = SecurityUtils.getCurrentOrganization(httpServletRequest).getOrganCode();
		Map<String,Long> map = statisticsService.getArchiveManagementList(statisticsDate,SecurityUtils.getCurrentOrganization(httpServletRequest),1);
		return map;
    }
	
	/**
	 * 获取管理员档案管理统计数据
	 * @param httpServletRequest
	 * @param
	 * @param
	 */
	@RequestMapping(value=" /getAdminArchiveManagementList")
    public @ResponseBody Map<String,Long> getAdminArchiveManagementList(HttpServletRequest httpServletRequest,String statisticsDate) {
		String orgCode = SecurityUtils.getCurrentOrganization(httpServletRequest).getOrganCode();
		Map<String,Long> map = new HashMap<>();
		// 根据管理员，中心，站查询
		/*private static final Integer MANAGE_ADMIN = 0;
		private static final Integer MANAGE_CENTER = 1;
		private static final Integer MANAGE_ORG = 2;*/
		if(hasRole(RoleType.ADMIN,httpServletRequest)||hasRole(RoleType.JKJKDN,httpServletRequest)){
			//管理员或疾控健康档案bug0128499
			map = statisticsService.getArchiveManagementList(statisticsDate,SecurityUtils.getCurrentOrganization(httpServletRequest),0);
		}else if(hasRole(RoleType.QWGZX,httpServletRequest)){
			//区卫管中心
			map = statisticsService.getArchiveManagementList(statisticsDate,SecurityUtils.getCurrentOrganization(httpServletRequest),3);
		} else if(hasRole(RoleType.ZX_GLY,httpServletRequest)){
			//中心
			map = statisticsService.getArchiveManagementList(statisticsDate,SecurityUtils.getCurrentOrganization(httpServletRequest),1);
		}else {
			//站
		    map = statisticsService.getArchiveManagementList(statisticsDate,SecurityUtils.getCurrentOrganization(httpServletRequest),2);
		}
		return map;
    }
	
	/**
	 * 所有建档数
	 * @return
	 */
	@RequestMapping("/allCreatePerson")
	public @ResponseBody Long getAllCreatePerson(HttpServletRequest request){
		Criteria criteria = new Criteria();
		String[] flags = {EHRConstants.HAD_CREATE};
		criteria.add("FILING_FLAG",OP.IN,flags);
		if(hasRole(RoleType.QWGZX,request)){
			criteria.add("inputGbcode",getCurrentOrg(request).getGbCode());
		}
		return statisticsService.getAllCreatePerson(criteria);
	}
	
	/**
	 * 获取社区重点人群统计数据
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param model
	 */
	@RequestMapping(value="/getCommunityMajorCrowdList")
    public void getCommunityMajorCrowdList(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ModelMap model) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("orgCode", SecurityUtils.getCurrentOrganization(httpServletRequest).getOrganCode());
		paramMap.put("statisticsDate", httpServletRequest.getParameter("statisticsDate"));
		List<HaStatistics> list = statisticsService.getCommunityMajorCrowdList(paramMap);
		MessageUtils.outputJSONResult(JSONArray.fromObject(list).toString(), httpServletResponse);
//        return list;
    }
	
	@RequestMapping(value="/getCdcMajorCrowdList")
    public void getCdcMajorCrowdList(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ModelMap model) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("orgCode", SecurityUtils.getCurrentOrganization(httpServletRequest).getOrganCode());
		paramMap.put("statisticsDate", httpServletRequest.getParameter("statisticsDate"));
		List<HaStatistics> list = statisticsService.getCdcMajorCrowdList(paramMap);
		MessageUtils.outputJSONResult(JSONArray.fromObject(list).toString(), httpServletResponse);
//        return list;
    }
	
	@RequestMapping(value="/getAdminMajorCrowdList")
    public void getAdminMajorCrowdList(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ModelMap model) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("orgCode", SecurityUtils.getCurrentOrganization(httpServletRequest).getOrganCode());
		paramMap.put("statisticsDate", httpServletRequest.getParameter("statisticsDate"));
		List<HaStatistics> list = statisticsService.getAdminMajorCrowdList(paramMap);
		MessageUtils.outputJSONResult(JSONArray.fromObject(list).toString(), httpServletResponse);
//        return list;
    }
	
	@RequestMapping(value="/getCdmList")
    public void getCdmList(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ModelMap model) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("orgCode", SecurityUtils.getCurrentOrganization(httpServletRequest).getOrganCode());
		paramMap.put("statisticsDate", httpServletRequest.getParameter("statisticsDate"));
		List<HaStatistics> list = statisticsService.getCdmList(paramMap);
		MessageUtils.outputJSONResult(JSONArray.fromObject(list).toString(), httpServletResponse);
//        return list;
    }
	
	@RequestMapping(value="/getQuickJob")
	public @ResponseBody HaStatistics getQuickJob(HttpServletRequest request)
	{
		return statisticsService.getQuickJob(new Criteria("intputOrganCode",SecurityUtils.getCurrentOrganization(request).getOrganCode()));
	}

	@RequestMapping(value="/getTownDistributionList")
	public void getTownDistributionList(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ModelMap model) {
		List<HaStatistics> list = new ArrayList<>();
		/**if(hasRole(RoleType.QWGZX,httpServletRequest)){
			List<Organization> centers = organizationApp.queryOrganization(new Criteria("gbCode",getCurrentOrg(httpServletRequest).getGbCode()).add("genreCode", OrgGenreCode.CENTRE.getValue()));
			list = statisticsService.getHaStatisticsEveryTown(centers);
		}else {
		list = statisticsService.getHaStatisticsByTown();
		}**/
		List<Organization> centers = organizationApp.queryOrganization(new Criteria("genreCode", OP.IN, new String[]{OrgGenreCode.CENTRE.getValue(), OrgGenreCode.INSTITUTES.getValue()}));
		list = statisticsService.getHaStatisticsEveryTown(centers);
		List<HaStatistics> destList = new ArrayList<HaStatistics>();
		for (HaStatistics haStatistics : list) {
			if (ObjectUtil.isNotEmpty(haStatistics) && ObjectUtil.isNotEmpty(haStatistics.getTownName())) {
				destList.add(haStatistics);
			}
		}
		MessageUtils.outputJSONResult(JSONArray.fromObject(destList).toString(), httpServletResponse);
	}
	
	@RequestMapping(value="/getCommunityDistributionList1")
	public void getCommunityDistributionList(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ModelMap model) {
		String centerCode = SecurityUtils.getCurrentOrganization(httpServletRequest).getOrganCode();
		List<HaStatistics> list = statisticsService.getHaStatisticsByCenter(centerCode);
		MessageUtils.outputJSONResult(JSONArray.fromObject(list).toString(), httpServletResponse);
	}
	
	@RequestMapping("adminIdmStatistics")
	public void getAdminIdmStatistics(HttpServletRequest request,HttpServletResponse response,@RequestParam(value="statisticsDate")String statisticsDate, ModelMap map){
		Date[] dateRange = getDateRange(statisticsDate);
		String gbCode = "";
		if(hasRole(RoleType.QWGZX,request)){
			gbCode = getCurrentOrg(request).getGbCode();
		}
		List<Map<String, Long>> idmStatistics = idmStatisticsService.getStaticticsByAdmin(dateRange[0], dateRange[1],gbCode);
		MessageUtils.outputJSONResult(JSONArray.fromObject(idmStatistics).toString(), response);
	}
	
	@RequestMapping("centerIdmStatistics")
	public void getCenterIdmStatistics(HttpServletRequest request,HttpServletResponse response,@RequestParam(value="statisticsDate")String statisticsDate, ModelMap map){
		Date[] dateRange = getDateRange(statisticsDate);
		Organization org = SecurityUtils.getCurrentOrganization(request);
		if(ObjectUtil.isNullOrEmpty(org)){
			return;
		}
		List<Map<String, Long>> idmStatistics = idmStatisticsService.getStaticticsByCenter(org.getOrganCode(), dateRange[0], dateRange[1]);
		MessageUtils.outputJSONResult(JSONArray.fromObject(idmStatistics).toString(), response);
	}
	
	@RequestMapping("stationIdmStatistics")
	public void getStationIdmStatistics(HttpServletRequest request,HttpServletResponse response,@RequestParam(value="statisticsDate")String statisticsDate, ModelMap map){
		Date[] dateRange = getDateRange(statisticsDate);
		Organization org = SecurityUtils.getCurrentOrganization(request);
		if(ObjectUtil.isNullOrEmpty(org)){
			return;
		}
		List<Map<String, Long>> idmStatistics = idmStatisticsService.getStaticticsByStation(org.getOrganCode(), dateRange[0], dateRange[1]);
		MessageUtils.outputJSONResult(JSONArray.fromObject(idmStatistics).toString(), response);
	}
	
	/**
	 * 获取统计的日期时间范围
	 * @param statisticsDate
	 * @return
	 */
	private Date[] getDateRange(String statisticsDate){
		Calendar cal = Calendar.getInstance();
		Date[] dateRange = new Date[2];
		switch(statisticsDate){
			case "1" : 
				dateRange[0] = DateUtil.makeTimeToZero(cal.getTime());
				dateRange[1] =DateUtil.makeTimeToMax(cal.getTime());
				break;
			case "2" : 
				dateRange = DateUtil.getDateRangeByMonth(cal.get(Calendar.MONTH));
				break;
			case "3" :
				dateRange = DateUtil.getDateRangeByYear(cal.get(Calendar.YEAR));
				break;
			default : 
				dateRange[0] = null;
				dateRange[1] = null;
				break;
		}
		return dateRange;
	}
}
