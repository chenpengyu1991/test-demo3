package com.founder.rhip.ehr.controller;

import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.service.IPopulaceService;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
/**
 * RecordController by Sean Xiyang
 */

@Controller
@RequestMapping(value = "/community")
public class RecordController extends BaseController {
	
	@Resource(name = "populaceService")
    private IPopulaceService populaceService;
	
    @RequestMapping(value="/sanitaryBureau")
    public String sanitaryBureauIndex(HttpServletRequest request, ModelMap model) {
        Map<String,Long> populaceMap = new HashMap<String,Long>();
        if(this.hasRole(RoleType.QWGZX, request)) {
            CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
            populaceMap = populaceService.getPopulaceByYearAndOrgCode(currentLoginInfo.getOrganization());
        } else {
            populaceMap = populaceService.getPopulaceByYear();
        }

    	model.addAttribute("sanitaryBureauPopulace",populaceMap);
        return "rhip.ehr.record.sanitaryBureau.index";
    }

    @RequestMapping(value="/healthManagement")
    public String healthManagementIndex( HttpServletRequest request, ModelMap model) {
    	Organization organization = SecurityUtils.getCurrentOrganization(request);
    	Map<String,Long> populaceMap = new HashMap<String, Long>();
    	if(null != organization && null != organization.getOrganCode()){
    		populaceMap = populaceService.getPopulaceByYearAndOrgCode(organization);
    	}
    	model.addAttribute("healthManagementPopulace",populaceMap);
        return "rhip.ehr.record.healthManagement.index";
    }

    @RequestMapping(value="/community")
    public String communityIndex() {
        return "rhip.ehr.record.community.index";
    }
    
}
