/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ph.service.vaccine;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.repository.basic.HistoryRecorder;
import com.founder.rhip.ehr.repository.control.IVaccinationMgmtDao;
import com.founder.rhip.mdm.service.IMergerTownListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dcMergerTownService")
public class VaMergerTownListenerImpl extends AbstractService implements IMergerTownListener {

    @Autowired
    private IVaccinationMgmtDao vaccinationMgmtDao;

    /**
     * 乡镇合并
     * @param newTownCode 合并后的乡镇编码
     * @param oldTownCode 被合并的乡镇编码
     */
    @Override
    public void mergeTown(String newTownCode, String[] oldTownCode) {
        Criteria criteria = new Criteria("PATOWN_SHIP", OP.IN, oldTownCode);
        HistoryRecorder.record(vaccinationMgmtDao, criteria, new String[]{"ID", "PAPROVINCE", "PACITY", "PACOUNTY", "PATOWN_SHIP", "PASTREET"});
        Parameters param = new Parameters();
        param.add("PATOWN_SHIP",newTownCode);
        vaccinationMgmtDao.update(param, criteria);
    }

    /**
     * 镇村关系变化时响应的接口 townCode镇编码 newAddVillageCodes镇中新增加的村
     * @param townCode
     * @param newAddVillageCodes
     */
	@Override
	public void sendTownVillageRelation(String townCode, String[] newAddVillageCodes) {

        Criteria criteria = new Criteria("PASTREET", OP.IN, newAddVillageCodes);
        HistoryRecorder.record(vaccinationMgmtDao, criteria, new String[]{"ID", "PAPROVINCE", "PACITY", "PACOUNTY", "PATOWN_SHIP", "PASTREET"});
        Parameters param = new Parameters();
        param.add("PATOWN_SHIP",townCode);
        vaccinationMgmtDao.update(param, criteria);

	}

}