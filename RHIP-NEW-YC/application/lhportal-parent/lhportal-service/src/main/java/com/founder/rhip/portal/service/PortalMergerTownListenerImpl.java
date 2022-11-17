/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.portal.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.repository.basic.HistoryRecorder;
import com.founder.rhip.ehr.repository.portal.IReserveRegisterDao;
import com.founder.rhip.mdm.service.IMergerTownListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("portalMergerTownService")
public class PortalMergerTownListenerImpl extends AbstractService /**implements IMergerTownListener**/ {

    @Resource
    private IReserveRegisterDao reserveRegisterDao;

    /**
     * 乡镇合并
     * @param newTownCode 合并后的乡镇编码
     * @param oldTownCode 被合并的乡镇编码
     */
    //@Override
    public void mergeTown(String newTownCode, String[] oldTownCode) {
        Criteria criteria = new Criteria("PATOWN_SHIP", OP.IN, oldTownCode);
        HistoryRecorder.record(reserveRegisterDao, criteria, new String[]{"ID", "PATOWN_SHIP", "PASTREET"});
        Parameters param = new Parameters();
        param.add("PATOWN_SHIP",newTownCode);
        reserveRegisterDao.update(param, criteria);
    }

    /**
     * 镇村关系变化时响应的接口 townCode镇编码 newAddVillageCodes镇中新增加的村
     * @param townCode
     * @param newAddVillageCodes
     */
	//@Override
	public void sendTownVillageRelation(String townCode, String[] newAddVillageCodes) {
        Criteria criteria = new Criteria("PASTREET", OP.IN, newAddVillageCodes);
        HistoryRecorder.record(reserveRegisterDao, criteria, new String[]{"ID", "PATOWN_SHIP", "PASTREET"});
        Parameters param = new Parameters();
        param.add("PATOWN_SHIP",townCode);
        reserveRegisterDao.update(param, criteria);
	}

}