package com.founder.rhip.phsr.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.dto.HealthRecordCensus;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.ihm.service.IHealthRecordCensusService;
import com.founder.rhip.mdm.entity.Organization;

/**
 * 城乡居民健康档案管理统计报表
 * @author admin
 *
 */
@Controller
@RequestMapping(value = "/healthRecordCensus")
public class HealthRecordCensusController extends BaseController {

	@Resource(name = "healthRecordCensusService")
	private IHealthRecordCensusService healthRecordCensusService;
	
    /**
     * 城乡居民健康档案管理统计报表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/search")
    public String Search(HttpServletRequest request, ModelMap model) {
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
        return "rhip.phsr.healthRecordCensus.search";
    }

    /**
     * 城乡居民健康档案管理统计报表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String List(HttpServletRequest request, ModelMap model, HealthRecordCensus healthRecord) {
		Criteria criteria = CriteriaOrganizer.initCriteriaCondition(request.getParameterMap());
        
        String countType = healthRecord.getCountType();
		if("1".equals(countType)){//按年
			criteria.remove("quarter");
		}
		
		String roleType = "";
        String currentOrgCode = "";
        //获取当前机构
        Organization organization = getCurrentOrg(request);
        if (ObjectUtil.isNotEmpty(organization)) {
            currentOrgCode = organization.getOrganCode();
        }

	      //获取查询条件
	      int year = 0;
	      if (ObjectUtil.isNullOrEmpty(healthRecord.getYear())) {
	          year = new Date().getYear() + 1900;
	      } else {
	          year = healthRecord.getYear();
	      }
       
		// 不同身份查询条件
		organizeCriteria(criteria, model, request);
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		if(SecurityUtils.hasRole(RoleType.QWGZX, request)){
			criteria.add("qwgzxCode",currentLoginInfo.getOrganization().getGbCode());
		}
		List<HealthRecordCensus> reports = healthRecordCensusService.getHealthRecordCensusList(criteria);  
		
		HealthRecordCensus hrc = new HealthRecordCensus();
		if (hasRole(RoleType.ZX_GLY, request)) {//中心
            roleType = RoleType.ZX_GLY.getValue();
            
            hrc = healthRecordCensusService.getHealthRecordCensus(new Criteria("orgCode", currentOrgCode).add("year", year).add("quarter", healthRecord.getQuarter().toString()));
            if (ObjectUtil.isNullOrEmpty(hrc)) {
            	hrc = new HealthRecordCensus();
            	hrc.setOrgCode(currentOrgCode);
			}
            for(HealthRecordCensus census :reports){
            	if(census.getOrgCode().equals(currentOrgCode)){
            		hrc.setPermanentNum(census.getPermanentNum());
            		hrc.setBuildERecordNum(census.getBuildERecordNum());
            		hrc.setDynamicRecordNum(census.getDynamicRecordNum());
            		hrc.setGbCode(census.getGbCode());
            	}
            }
		} else if (hasRole(RoleType.Z_GLY, request)) {   //站
			roleType = RoleType.Z_GLY.getValue();
			hrc = healthRecordCensusService.getHealthRecordCensus(new Criteria("orgCode", currentOrgCode).add("year", year).add("quarter", healthRecord.getQuarter().toString()));
            if (ObjectUtil.isNullOrEmpty(hrc)) {
            	hrc = new HealthRecordCensus();
            	hrc.setOrgCode(currentOrgCode);
			}
            for(HealthRecordCensus census :reports){
            	if(census.getOrgCode().equals(currentOrgCode)){
            		hrc.setPermanentNum(census.getPermanentNum());
            		hrc.setBuildERecordNum(census.getBuildERecordNum());
            		hrc.setDynamicRecordNum(census.getDynamicRecordNum());
            		hrc.setGbCode(census.getGbCode());
            	}
            }
        } else if (hasRole(RoleType.QWGZX, request)) {  //卫管中心
            roleType = RoleType.QWGZX.getValue();
        }else{
            roleType = RoleType.ADMIN.getValue();
        }
		
		//统计总数
		HealthRecordCensus census = countCensus(reports);
		
		model.addAttribute("total", census);
	    model.addAttribute("reports", reports);
	    model.addAttribute("healthRecordCensus", hrc);
	    
        model.addAttribute("ROLE", roleType);
		return "rhip.phsr.healthRecordCensus.list";
	}
    
	private HealthRecordCensus countCensus(List<HealthRecordCensus> reports) {
		//统计合计信息
		HealthRecordCensus census = new HealthRecordCensus();
		if(ObjectUtil.isNotEmpty(reports)){
			for (HealthRecordCensus hr : reports) {
				census.setPermanentNum(census.getPermanentNum() + hr.getPermanentNum());		
				census.setBuildRecordNum(census.getBuildRecordNum() + hr.getBuildRecordNum());		
				census.setBuildERecordNum(census.getBuildERecordNum() + hr.getBuildERecordNum());		
				census.setDynamicRecordNum(census.getDynamicRecordNum() + hr.getDynamicRecordNum());		
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
	
    /**
     * 保存
     *
     * @param request
     * @param model
     * @param infectEmergencies
     * @return
     */
	@ResponseBody
    @RequestMapping("/save")
    public String save(HttpServletRequest request, ModelMap model, HealthRecordCensus healthRecord) {
    	int num=0;
        //赋值年、季度、时间
        String quarter = request.getParameter("quarter");
        String year = request.getParameter("year");
        if (StringUtil.isNotEmpty(quarter) && StringUtil.isNotEmpty(year)) {
        	healthRecord.setYear(Integer.parseInt(year));
        	healthRecord.setQuarter(Integer.parseInt(quarter));
        }
        //赋值机构
        CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
        healthRecord.setOrgCode(currentLoginInfo.getOrganization().getOrganCode());
        healthRecord.setOrgName(currentLoginInfo.getOrganization().getOrganName());
        healthRecord.setGbCode(currentLoginInfo.getOrganization().getGbCode());

        if(ObjectUtil.isNotEmpty(healthRecord.getId())){
			num=healthRecordCensusService.updateBuildRecord(healthRecord);
		}else{
		    num=healthRecordCensusService.addBuildRecord(healthRecord);
		}
        if(num>0){
			return "保存成功!";
		}else{
			return "保存失败!";
		}
    }



}
