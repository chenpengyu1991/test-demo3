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
import com.founder.rhip.ehr.repository.dmbc.IDmbcFlyMonitorDao;
import com.founder.rhip.ehr.repository.dmbc.IDmbcMosquitoesMonitorDao;
import com.founder.rhip.ehr.repository.dmbc.IDmbcMouseMonitorDao;
import com.founder.rhip.ehr.repository.dmbc.IDmbcRoachMonitorDao;
import com.founder.rhip.mdm.service.IMergerTownListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("dmbcMergerTownService")
public class DmbcMergerTownListenerImpl extends AbstractService implements IMergerTownListener {

    @Resource(name = "dmbcMouseMonitorDao")
    IDmbcMouseMonitorDao mouseMonitorDao;    //鼠密度监测

    @Resource(name = "dmbcMosquitoesMonitorDao")
    IDmbcMosquitoesMonitorDao mosquitoesMonitorDao;    //成蚊监测

    @Resource(name = "dmbcFlyMonitorDao")
    IDmbcFlyMonitorDao flyMonitorDao;   //苍蝇监测

    @Resource(name = "dmbcRoachMonitorDao")
    IDmbcRoachMonitorDao roachMonitorDao;   // 蟑螂监测

    /**
     * 乡镇合并
     * @param newTownCode 合并后的乡镇编码
     * @param oldTownCode 被合并的乡镇编码
     */
    @Override
    public void mergeTown(String newTownCode, String[] oldTownCode) {
        Criteria criteria = new Criteria("TOWN_SHIP", OP.IN, oldTownCode);
        Parameters param = new Parameters();
        param.add("TOWN_SHIP",newTownCode);

        HistoryRecorder.record(mouseMonitorDao, criteria, new String[]{"ID", "TOWN_SHIP"});
        mouseMonitorDao.update(param, criteria);

        HistoryRecorder.record(mosquitoesMonitorDao, criteria, new String[]{"ID", "TOWN_SHIP"});
        mosquitoesMonitorDao.update(param, criteria);

        HistoryRecorder.record(flyMonitorDao, criteria, new String[]{"ID", "TOWN_SHIP"});
        flyMonitorDao.update(param, criteria);

        HistoryRecorder.record(roachMonitorDao, criteria, new String[]{"ID", "TOWN_SHIP"});
        roachMonitorDao.update(param, criteria);

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