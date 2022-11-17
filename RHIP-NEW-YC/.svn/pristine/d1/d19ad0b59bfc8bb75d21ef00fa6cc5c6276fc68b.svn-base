/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ph.service.oh;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.repository.basic.HistoryRecorder;
import com.founder.rhip.ehr.repository.oh.IOhEmployeeInfoDao;
import com.founder.rhip.ehr.repository.oh.IOhHospitalInfoDao;
import com.founder.rhip.ehr.repository.oh.IOhPoisonReportDao;
import com.founder.rhip.mdm.service.IMergerTownListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("ohMergerTownService")
public class OhMergerTownListenerImpl extends AbstractService implements IMergerTownListener {

    @Resource
    IOhEmployeeInfoDao employeeInfoDao; //职业病人管理

    @Resource
    private IOhPoisonReportDao ohPoisonReportDao; //农药中毒报告

    @Resource
    private IOhHospitalInfoDao ohHospitalInfoDao; //放射卫生管理

    /**
     * 乡镇合并
     * @param newTownCode 合并后的乡镇编码
     * @param oldTownCode 被合并的乡镇编码
     */
    @Override
    public void mergeTown(String newTownCode, String[] oldTownCode) {
        Criteria criteria = new Criteria("PATOWN_SHIP", OP.IN, oldTownCode);
        HistoryRecorder.record(employeeInfoDao, criteria, new String[]{"ID", "PAPROVINCE", "PACITY", "PACOUNTY", "PATOWN_SHIP", "PASTREET", "CREATE_ORGAN_CODE", "UPDATE_ORGAN_CODE"});
        Parameters param = new Parameters();
        param.add("PATOWN_SHIP",newTownCode);
        employeeInfoDao.update(param, criteria);

        Criteria criteria1 = new Criteria("PATOWN_SHIP", OP.IN, oldTownCode);
        HistoryRecorder.record(ohPoisonReportDao, criteria1, new String[]{"ID", "PAPROVINCE", "PACITY", "PACOUNTY", "PATOWN_SHIP", "PASTREET", "CREATE_ORGAN_CODE", "UPDATE_ORGAN_CODE"});
        Parameters param1 = new Parameters();
        param1.add("PATOWN_SHIP",newTownCode);
        ohPoisonReportDao.update(param1, criteria1);

    }

    /**
     * 镇村关系变化时响应的接口 townCode镇编码 newAddVillageCodes镇中新增加的村
     * @param townCode
     * @param newAddVillageCodes
     */
	@Override
	public void sendTownVillageRelation(String townCode, String[] newAddVillageCodes) {
        Criteria criteria = new Criteria("PASTREET", OP.IN, newAddVillageCodes);
        HistoryRecorder.record(employeeInfoDao, criteria, new String[]{"ID", "PAPROVINCE", "PACITY", "PACOUNTY", "PATOWN_SHIP", "PASTREET", "CREATE_ORGAN_CODE", "UPDATE_ORGAN_CODE"});
        Parameters param = new Parameters();
        param.add("PATOWN_SHIP",townCode);
        employeeInfoDao.update(param, criteria);

        Criteria criteria1 = new Criteria("PASTREET", OP.IN, newAddVillageCodes);
        HistoryRecorder.record(ohPoisonReportDao, criteria1, new String[]{"ID", "PAPROVINCE", "PACITY", "PACOUNTY", "PATOWN_SHIP", "PASTREET", "CREATE_ORGAN_CODE", "UPDATE_ORGAN_CODE"});
        Parameters param1 = new Parameters();
        param1.add("PATOWN_SHIP",townCode);
        ohPoisonReportDao.update(param1, criteria1);

	}

}