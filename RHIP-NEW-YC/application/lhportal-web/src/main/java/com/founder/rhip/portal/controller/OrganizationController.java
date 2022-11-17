/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.portal.controller;

import com.founder.elb.common.MessageUtils;
import com.founder.fasf.beans.Criteria;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
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
 *
 * @author Jiang Haiying
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
     *
     * @param gbCode
     * @param response
     * @param request
     */
    @RequestMapping("/json")
    public void getVillageJson(String gbCode, HttpServletResponse response, HttpServletRequest request) {
        List<DicItem> villages = dictionaryApp.queryDicItems("FS990001", gbCode);
        StringBuffer buffer = new StringBuffer();
        for (DicItem item : villages) {
            buffer.append("<option title=\"" + item.getItemName() + "\" value='" + item.getItemCode() + "'>" + item.getItemName() + "</option>");
        }
        MessageUtils.outputJSONResult(StringUtils.isNotEmpty(buffer.toString()) ? buffer.toString() : "empty", response);
    }

    /**
     * 根据镇的code获取中心医院的列表
     *
     * @param gbCode
     * @param response
     * @param request
     */
    @RequestMapping("/centre")
    public void getCentreJson(String gbCode, HttpServletResponse response, HttpServletRequest request) {
        List<Organization> centres = organizationApp.queryOrganization(new Criteria("GB_CODE", gbCode));
        StringBuffer buffer = new StringBuffer();
        for (Organization org : centres) {
            buffer.append("<option title=\"" + org.getOrganName() + "\" value='" + org.getOrganCode() + "'>" + org.getOrganName() + "</option>");
        }
        MessageUtils.outputJSONResult(StringUtils.isNotEmpty(buffer.toString()) ? buffer.toString() : "empty", response);
    }

    /**
     * 根据中心医院的code获取卫生服务站的列表
     *
     * @param supOrganCode
     * @param response
     * @param request
     */
    @RequestMapping("/station")
    public void getStationJson(String supOrganCode, boolean isShowOneself, HttpServletResponse response, HttpServletRequest request) {
        List<Organization> stations = new ArrayList<Organization>();
        //isShowOneself 为true 在站的下拉列表中也显示该站的所属上级
        if (isShowOneself) {
            stations.add(organizationApp.queryOrgan(supOrganCode));
        }
        stations.addAll(organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, supOrganCode)));
        StringBuffer buffer = new StringBuffer();
        for (Organization org : stations) {
            buffer.append("<option title=\"" + org.getOrganName() + "\"  value='" + org.getOrganCode() + "'>" + org.getOrganName() + "</option>");
        }
        MessageUtils.outputJSONResult(StringUtils.isNotEmpty(buffer.toString()) ? buffer.toString() : "empty", response);
    }
}