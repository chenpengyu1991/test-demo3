/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.mdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.repository.basic.HistoryRecorder;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.repository.ISchoolInfoDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("mdmMergerOrgService")
public class MdmMergerOrgListenerImpl extends AbstractService implements IMergerOrganizationListener {

    @Resource
    private ISchoolInfoDao schoolInfoDao;

    /**
     * 站合并（包括同一个中心下和不同中心下）
     * @param station 合并后的站
     * @param stationList 被合并的站列表
     */
    @Override
    public void mergeStation(Organization station, List<Organization> stationList){
//        Criteria criteria = new Criteria("EXAM_ORGAN", OP.IN, stationList);
//        HistoryRecorder.record(schoolInfoDao, criteria, new String[]{"ID", "ORGAN_TOWN", "EXAM_ORGAN"});
//        Parameters param = new Parameters();
//        param.add("EXAM_ORGAN", station.getOrganCode());
//        param.add("ORGAN_TOWN",station.getGbCode());
//        schoolInfoDao.update(param, criteria);
    }

    /**
     * 中心合并
     * @param center  合并后的中心
     * @param centerList 被合并的中心列表
     */
    @Override
    public void mergeCenter(Organization center, List<Organization> centerList){
        List<String> centerCodes = new ArrayList<>();
        for(Organization organ : centerList){
            centerCodes.add(organ.getOrganCode());
        }
        Criteria criteria = new Criteria("EXAM_ORGAN", OP.IN, centerCodes);
//        HistoryRecorder.record(schoolInfoDao, criteria, new String[]{"schoolId", "ORGAN_TOWN", "EXAM_ORGAN"});
        Parameters param = new Parameters();
        param.add("EXAM_ORGAN", center.getOrganCode());
        param.add("ORGAN_TOWN",center.getGbCode());
        schoolInfoDao.update(param, criteria);
    }

    /**
     * 站转移
     * @param center 转移后的中心
     * @param stationList 被转移的站列表
     */
    @Override
    public void moveStation(Organization center, List<Organization> stationList){
//        Criteria criteria = new Criteria("EXAM_ORGAN", OP.IN, stationList);
//        HistoryRecorder.record(schoolInfoDao, criteria, new String[]{"ID", "ORGAN_TOWN", "EXAM_ORGAN"});
//        Parameters param = new Parameters();
//        param.add("ORGAN_TOWN",center.getOrganCode());
//        param.add("ORGAN_TOWN",center.getGbCode());
//        schoolInfoDao.update(param, criteria);
    }

    /**
     * 机构（站）村关系变化时响应的接口 orgCode机构编码 newAddVillageCodes机构中新增加的村
     * @param orgCode
     * @param newAddVillageCodes
     */
	@Override
	public void changeRelationOrgVillage(String orgCode, String[] newAddVillageCodes) {
    }

}