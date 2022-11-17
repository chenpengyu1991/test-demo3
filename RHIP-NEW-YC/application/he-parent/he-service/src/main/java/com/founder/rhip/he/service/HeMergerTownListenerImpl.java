/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.he.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.repository.basic.HistoryRecorder;
import com.founder.rhip.ehr.repository.healtheducation.*;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.service.IMergerTownListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("heMergerTownService")
public class HeMergerTownListenerImpl extends AbstractService implements IMergerTownListener {


    @Resource(name = "heResourceDao")
    private IHeResourceDao healthEducationResourceDao;        //宣传设备 宣传阵地 宣传材料

    @Resource(name = "heActiveDao")
    private IHeActiveDao healthEducationActiveDao;     //健康教育活动

    @Resource(name = "heResourceRecordDao")
    private IHeResourceRecordDao healthResourceRecordDao;   //宣传阵地使用

    @Resource(name = "heSupervisorDao")
    private IHeSupervisorDao healthSupervisorDao;      //工作督查

    @Resource(name = "hePrescriptionDao")
    private IHePrescriptionDao healthPrescriptionDao;   //健康教育处方

    @Resource(name = "organizationApp")
    private IOrganizationApp organizationApp;


    /**
     * 乡镇合并
     * @param newTownCode 合并后的乡镇编码
     * @param oldTownCode 被合并的乡镇编码
     */
    @Override
    public void mergeTown(String newTownCode, String[] oldTownCode) {
        //备份数据
        Criteria caTown = new Criteria("GBCODE", OP.IN, oldTownCode);

        HistoryRecorder.record(healthEducationResourceDao, caTown, new String[]{"ID", "ORG_CODE", "CENTER_ORG_CODE", "GBCODE"});
        HistoryRecorder.record(healthEducationActiveDao, caTown, new String[]{"ID", "ORG_CODE", "CENTER_ORG_CODE", "GBCODE"});
        HistoryRecorder.record(healthResourceRecordDao, caTown, new String[]{"ID", "ORG_CODE", "CENTER_ORG_CODE", "GBCODE"});
        HistoryRecorder.record(healthSupervisorDao, caTown, new String[]{"ID", "ORG_CODE", "CENTER_ORG_CODE", "GBCODE"});
        HistoryRecorder.record(healthPrescriptionDao, caTown, new String[]{"ID", "ORG_CODE", "CENTER_ORG_CODE", "GBCODE"});

        //更新数据
        Parameters paramTown = new Parameters();
        paramTown.add("GBCODE", newTownCode);
        healthEducationResourceDao.update(paramTown, caTown);
        healthEducationActiveDao.update(paramTown, caTown);
        healthResourceRecordDao.update(paramTown, caTown);
        healthSupervisorDao.update(paramTown, caTown);
        healthPrescriptionDao.update(paramTown, caTown);
    }

    /**
     * 镇村关系变化时响应的接口 townCode镇编码 newAddVillageCodes镇中新增加的村
     * @param townCode
     * @param newAddVillageCodes
     */
    @Override
    public void sendTownVillageRelation(String townCode, String[] newAddVillageCodes) {

    }
}