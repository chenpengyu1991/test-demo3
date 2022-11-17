package com.founder.rhip.ncp.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class NcpController extends BaseController {

    protected  void createRoleSearch(HttpServletRequest request, Criteria criteria) {
        String orgCode = request.getParameter("stationOrganCode");
        if(SecurityUtils.hasRole(RoleType.JKXG, request)){
            String searchCenter = request.getParameter("centerOrganCode");
            String searchstation = request.getParameter("stationOrganCode");
            String gbcode  = request.getParameter("gbcode");
            if(ObjectUtil.isNotEmpty(searchstation)){
                criteria.add("ncp.management_org", searchstation);
            }else if(ObjectUtil.isNotEmpty(searchCenter)){
                List<String> orgCodes = this.getOrgCodeByOrgCode(searchCenter);
                criteria.add("ncp.management_org", OP.IN, orgCodes);
            }else if(ObjectUtil.isNotEmpty(gbcode)){
                List<String> orgCodes = this.getOrgCodeByGBCode(gbcode);
                criteria.add("ncp.management_org", OP.IN, orgCodes);
            }


        }else if(SecurityUtils.hasRole(RoleType.ZXXG, request)){//中心
            if(ObjectUtil.isNotEmpty(orgCode)){
                criteria.add("ncp.management_org", orgCode);
            }else{
                List<String> orgCodes = this.getOrgCodeByOrgCode(SecurityUtils.getCurrentOrganization(request).getOrganCode());
                criteria.add("ncp.management_org", OP.IN, orgCodes);
            }
        } else if(SecurityUtils.hasRole(RoleType.ZXG, request)) {//站
            if(ObjectUtil.isNullOrEmpty(orgCode)) {
                orgCode = SecurityUtils.getCurrentOrganization(request).getOrganCode();
            }
            criteria.add("ncp.management_org",  orgCode);
        }else {
            if(StringUtils.isNotEmpty((String) request.getParameter("stationOrganCode"))){
                orgCode = (String) request.getParameter("stationOrganCode");
                criteria.add("ncp.management_org", orgCode);
            }else if(StringUtils.isNotEmpty((String) request.getParameter("centerOrganCode"))){
                orgCode = (String) request.getParameter("centerOrganCode");
                List<String> orgCodes = this.getOrgCodeByOrgCode(orgCode);
                orgCodes.add(orgCode);
                if(ObjectUtil.isNotEmpty(orgCodes)){
                    criteria.add("ncp.management_org", OP.IN, orgCodes);
                }else {
                    criteria.add("ncp.management_org", EHRConstants.INPUTORGANCODE_NULL);//如果中心下面没有站，给inputOrganCode -1值
                }
            }else if(StringUtils.isNotEmpty((String) request.getParameter("gbcode"))){
                String gBCode = (String) request.getParameter("gbcode");
                List<String> orgCodes = this.getOrgCodeByGBCode(gBCode);
                if(ObjectUtil.isNotEmpty(orgCodes)){
                    criteria.add("ncp.management_org", OP.IN, orgCodes);
                }else {
                    criteria.add("ncp.management_org", EHRConstants.INPUTORGANCODE_NULL);//如果中心下面没有站，给inputOrganCode -1值
                }
            }

        }
    }
}
