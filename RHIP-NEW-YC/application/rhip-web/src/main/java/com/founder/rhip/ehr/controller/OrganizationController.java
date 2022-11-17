/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.controller;

import com.founder.elb.common.MessageUtils;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 机构标签中关于级联的应用
 * @author Jiang Haiying
 *
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController extends BaseController {

	@Autowired
	private IOrganizationApp organizationApp;
	
	@Autowired
	private IDictionaryApp dictionaryApp;
	 
	/**
	 * 根据镇的code获取行政村的列表
	 * @param parentCode
	 * @param response
	 * @param request
	 */
	 @RequestMapping("/json")
	 public void getVillageJson(String parentCode, String villageCode, HttpServletResponse response, HttpServletRequest request){
		 List<DicItem> villages = dictionaryApp.queryDicItems("FS990001", parentCode);
		 StringBuffer buffer = new StringBuffer();
		 if(StringUtils.isNotEmpty(villageCode)) {
			 for(DicItem item: villages) {
				 if(StringUtils.equals(item.getItemCode(), villageCode)) {
					 buffer.append("<option title=\""+ item.getItemName() + "\" value='"+ item.getItemCode() +  "' selected=\"selected\">" + item.getItemName() + "</option>");
				 } else {
					 buffer.append("<option title=\""+ item.getItemName() + "\" value='"+ item.getItemCode() +  "'>" + item.getItemName() + "</option>");
				 }
			 }
		 } else {
			 for(DicItem item: villages) {
				 buffer.append("<option title=\""+ item.getItemName() + "\" value='"+ item.getItemCode() +  "'>" + item.getItemName() + "</option>");
			 }
		 }
		 MessageUtils.outputJSONResult(StringUtils.isNotEmpty(buffer.toString()) ? buffer.toString():"empty", response);
	 }
	 
	 /**
	  * 根据镇的code获取中心医院的列表
	  * @param gbCode
	  * @param response
	  * @param request
	  */
	 @RequestMapping("/centre")
	 public void getCentreJson(String gbCode, Boolean isAdministration, HttpServletResponse response, HttpServletRequest request){
		 Criteria criteria = new Criteria();
		 if(StringUtils.endsWith(gbCode, "_showJk")) {
			 criteria.add("GENRE_CODE", OrgGenreCode.JK.getValue());
		 }else if(StringUtils.endsWith(gbCode, "_showWjw")) {
			 criteria.add("GENRE_CODE", OrgGenreCode.AREA_HEALTH.getValue());
		 }else if(StringUtils.endsWith(gbCode, "_hospital")) {
			 criteria.add("GENRE_CODE", OrgGenreCode.HOSPITAL.getValue());
		 } else if(StringUtils.endsWith(gbCode, "_other")) {
			 criteria.add("GENRE_CODE", OrgGenreCode.OTHER.getValue());
		 }  else if(gbCode.equals(EHRConstants._INFIRMARY)) {
			criteria.add("GENRE_CODE",OrgGenreCode.INFIRMARY.getValue());
		 }   else if(gbCode.equals(EHRConstants._HEALTHOVERSIGHT)) {
				criteria.add("GENRE_CODE",OrgGenreCode.HEALTH_OVERSIGHT.getValue());
		 } else {
			 if(isAdministration) {
				 criteria = new Criteria("GB_CODE", gbCode);
				 //中心和卫生院
				 criteria.add("GENRE_CODE", OP.IN, new String[]{OrgGenreCode.CENTRE.getValue(), OrgGenreCode.INSTITUTES.getValue()});
			 } else {
				 Organization orgParent = organizationApp.queryOrgan(gbCode);
				 if(ObjectUtil.isNullOrEmpty(orgParent)) {
					 MessageUtils.outputJSONResult("empty", response);
					 return;
				 }
				 if(ObjectUtil.equals(OrgGenreCode.JK.getValue(), orgParent.getGenreCode())) {
					 criteria = new Criteria("parentCode", gbCode);
				 } else {
					 criteria = new Criteria("parentCodeHealth", gbCode);
				 }
				 criteria.add("GENRE_CODE", OP.NOTIN, new String[]{OrgGenreCode.STATION.getValue(), OrgGenreCode.CITY_HEALTH.getValue(),
						 OrgGenreCode.AREA_HEALTH.getValue(), OrgGenreCode.JK.getValue()});
			 }
			}
		 List<Organization> centres = organizationApp.queryOrganization(criteria);
		 StringBuffer buffer = new StringBuffer();
		 for(Organization org: centres) {
			 buffer.append("<option title=\""+ org.getOrganName() + "\" value='"+ org.getOrganCode() +  "'>" + org.getOrganName() + "</option>");
		 }
		 MessageUtils.outputJSONResult(StringUtils.isNotEmpty(buffer.toString()) ? buffer.toString():"empty", response);
	 }
	 
	 /**
	  * 根据中心医院的code获取卫生服务站的列表
	  * @param supOrganCode
	  * @param response
	  * @param request
	  */
	 @RequestMapping("/station")
	 public void getStationJson(String supOrganCode, boolean isShowOneself, HttpServletResponse response, HttpServletRequest request){
		 List<Organization> stations = new ArrayList<Organization>();
		 //isShowOneself 为true 在站的下拉列表中也显示该站的所属上级
		if(isShowOneself) {//仅限中心和卫生院
			Organization organization=organizationApp.queryOrgan(supOrganCode);
			if(OrgGenreCode.CENTRE.getValue().equals(organization.getGenreCode())||OrgGenreCode.INSTITUTES.getValue().equals(organization.getGenreCode())){
				stations.add(organizationApp.queryOrgan(supOrganCode));
			}

		}
		 Criteria criteria = new Criteria(Organization.PARENT_CODE, supOrganCode);
		 criteria.add("GENRE_CODE", OP.IN, new String[]{OrgGenreCode.STATION.getValue(), OrgGenreCode.CLINIC.getValue()});

		 stations.addAll(organizationApp.queryOrganization(criteria));
	    StringBuffer buffer = new StringBuffer();
		 for(Organization org: stations) {
			 buffer.append("<option title=\""+ org.getOrganName() + "\"  value='"+ org.getOrganCode() +  "'>" + org.getOrganName() + "</option>");
		 }
		 MessageUtils.outputJSONResult(StringUtils.isNotEmpty(buffer.toString()) ? buffer.toString():"empty", response);
	 }
	 
	 /**
		 * 级联下拉菜单
		 * 根据code获下级下拉菜单的列表
		 * @param parentCode
		 * @param code
		 * @param response
		 * @param request
		 */
		 @RequestMapping("/cascadedList")
		 public void getCascadedListJson(String parentCode,String code, HttpServletResponse response, HttpServletRequest request){
			 List<DicItem> cascadedList = dictionaryApp.queryDicItems(code, parentCode);
			 StringBuffer buffer = new StringBuffer();
			 for(DicItem item: cascadedList) {
				 buffer.append("<option title=\""+ item.getItemName() + "\" value='"+ item.getItemCode() +  "'>" + item.getItemName() + "</option>");
			 }
			 MessageUtils.outputJSONResult(StringUtils.isNotEmpty(buffer.toString()) ? buffer.toString():"empty", response);
		 }
		 
		 /**
		  * 获取中心、市级，或者两者都包括医院的列表
		  * @param response
		  * @param request
		  */
		 @RequestMapping("/allOrg")
		 public void getAllCentreJson(String type,String codeOther,HttpServletResponse response, HttpServletRequest request){
			List<Organization> result = new ArrayList<Organization>(); 
			if(StringUtils.contains(type, "hospital")) {
				List<Organization> hospitals = organizationApp.queryOrganization(new Criteria("GENRE_CODE",OrgGenreCode.HOSPITAL.getValue()));//获取综合医院
				result.addAll(hospitals);
			}
			if(StringUtils.contains(type, "other")) {
				Criteria criteria = new Criteria("GENRE_CODE",OrgGenreCode.OTHER.getValue());
				if(StringUtils.isNotEmpty(codeOther)) {
					result.addAll(organizationApp.queryOrganization(criteria.add("organCode", codeOther)));
				} else {
					result.addAll(organizationApp.queryOrganization(criteria));
				}
			}				
			if(StringUtils.contains(type, "centre")) {
				List<Organization> centres = organizationApp.queryOrganization(new Criteria("GENRE_CODE",OrgGenreCode.CENTRE.getValue()));//获取中心医院
				result.addAll(centres);
			}	
		
			StringBuffer buffer = new StringBuffer();
			for(Organization org: result) {
				buffer.append("<option title=\""+ org.getOrganName() + "\" value='"+ org.getOrganCode() +  "'>" + org.getOrganName() + "</option>");
			}
			 MessageUtils.outputJSONResult(StringUtils.isNotEmpty(buffer.toString()) ? buffer.toString():"empty", response);
		 }
}