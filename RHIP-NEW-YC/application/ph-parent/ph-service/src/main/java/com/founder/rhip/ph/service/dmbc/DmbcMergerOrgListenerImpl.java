/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ph.service.dmbc;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.repository.basic.HistoryRecorder;
import com.founder.rhip.ehr.repository.dmbc.IDmbcDisinfectionMonitorDao;
import com.founder.rhip.ehr.repository.dmbc.IDmbcInfectMonitorDao;
import com.founder.rhip.ehr.repository.dmbc.IDmbcSewageTreatmentDao;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("dmbcMergerOrgService")
public class DmbcMergerOrgListenerImpl extends AbstractService /**implements IMergerOrganizationListener**/ {

    @Resource(name = "dmbcSewageTreatmentDao")
    IDmbcSewageTreatmentDao sewageTreatmentDao;    //污水处理

    @Resource(name = "dmbcDisinfectionMonitorDao")
    IDmbcDisinfectionMonitorDao disinfectionMonitorDao;    //限度监测

    @Resource(name = "dmbcInfectMonitorDao")
    IDmbcInfectMonitorDao infectMonitorDao;    //院感监测

    /**
     * 站合并（包括同一个中心下和不同中心下）
     * @param station 合并后的站
     * @param stationList 被合并的站列表
     */
    //@Override
    public void mergeStation(Organization station, List<Organization> stationList){
        List<String> stationCodes = new ArrayList<>();
        for(Organization org : stationList){
            String stationCode = org.getOrganCode();
            stationCodes.add(stationCode);
        }
        Criteria ca = new Criteria("ORG_NAME", OP.IN, stationCodes);
        //备份数据
        HistoryRecorder.record(sewageTreatmentDao, ca, new String[]{"ID", "ORG_NAME"});
        HistoryRecorder.record(disinfectionMonitorDao, ca, new String[]{"ID", "ORG_NAME"});
        HistoryRecorder.record(infectMonitorDao, ca, new String[]{"ID", "ORG_NAME"});
        //更新数据
        Parameters parameter = new Parameters();
        parameter.add("ORG_NAME", station.getOrganCode());
        sewageTreatmentDao.update(parameter, ca);
        disinfectionMonitorDao.update(parameter, ca);
        infectMonitorDao.update(parameter, ca);
    }

    /**
     * 中心合并
     * @param center  合并后的中心
     * @param centerList 被合并的中心列表
     */
   // @Override
    public void mergeCenter(Organization center, List<Organization> centerList){
        List<String> centerCodes = new ArrayList<>();
        for(Organization org : centerList){
            String centerCode = org.getOrganCode();
            centerCodes.add(centerCode);
        }
        Criteria ca = new Criteria("ORG_NAME", OP.IN, centerCodes);
        //备份数据
        HistoryRecorder.record(sewageTreatmentDao, ca, new String[]{"ID", "ORG_NAME"});
        HistoryRecorder.record(disinfectionMonitorDao, ca, new String[]{"ID", "ORG_NAME"});
        HistoryRecorder.record(infectMonitorDao, ca, new String[]{"ID", "ORG_NAME"});
        //更新数据
        Parameters parameter = new Parameters();
        parameter.add("ORG_NAME", center.getOrganCode());
        sewageTreatmentDao.update(parameter, ca);
        disinfectionMonitorDao.update(parameter, ca);
        infectMonitorDao.update(parameter, ca);
    }

    /**
     * 站转移
     * @param center 转移后的中心
     * @param stationList 被转移的站列表
     */
   // @Override
    public void moveStation(Organization center, List<Organization> stationList){
    }

    /**
     * 机构（站）村关系变化时响应的接口 orgCode机构编码 newAddVillageCodes机构中新增加的村
     * @param orgCode
     * @param newAddVillageCodes
     */
	//@Override
	public void changeRelationOrgVillage(String orgCode, String[] newAddVillageCodes) {
    }

}