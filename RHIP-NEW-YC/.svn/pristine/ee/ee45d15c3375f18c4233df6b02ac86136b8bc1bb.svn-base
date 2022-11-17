/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.dto.CommunityInfoDTO;
import com.founder.rhip.ehr.entity.basic.Populace;
import com.founder.rhip.mdm.entity.Organization;

public interface IPopulaceService {

    /**
     * Save or update the populace
     *
     * @param Populace
     * @return void
     */
    public void saveOrUpdatePopulace(Populace populace);

    /**
     * 人口分类统计
     *
     * @param String…
     * @return Map<String,String>
     */
    public Map<String, String> getPoulaceStatistic(String... gBCodes);

    /**
     * Get populace by organization
     *
     * @param organization
     * @return
     */
    public CommunityInfoDTO getPopulaceByOrganization(Organization organization);
    
    /**
     * Get OrganizationBasicInfo by organization
     *
     * @param organization
     * @return
     */
    public CommunityInfoDTO getBasicInfoByOrganization(Organization organization);

    /**
     * 查找当年的人口统计
     *
     * @return
     */
    public Map<String, Long> getPopulaceByYear();

    /**
     * 根据社区中心查找当年的人口统计
     *
     * @return
     */
    public Map<String, Long> getPopulaceByYearAndOrgCode(Organization organization);

    public List<Populace> getOrganizationPopulaceListByYear(String orgCode, String organCode, String countYear);

    public List<Populace> getHealthManagementPopulaceListByYear(String superOrgCode);

    public void updateOrSavePopulace(List<Populace> populaces, String[] properties, String gbCode, String organCode);

    public List<Populace> getPopulaces(Criteria criteria);
    
    Integer getPopulaceNum(Criteria criteria,String countPropertyName);
    
    /**
     * 插入机构人口记录
     * @param populace
     */
    public void insertPopulaceInfo(Populace populace);
    
    /**
     * 删除机构人口信息
     * @param criteria
     */
    public void deletePopulaceInfo(Criteria criteria);
    
    /**
     * 根据镇 中心统计人口
     * @param criteria
     * @return
     */
    public List<Populace> getTarget(String gbCode, String organCode, Integer countYear, String genreCode);

    public List<Populace> getPopolaceReport(Criteria criteria);

    /**
     * 获取人口总数
     * @param criteria
     * @return
     */
    public Map<String, Object> getTotalCountByYear(Criteria criteria);
}