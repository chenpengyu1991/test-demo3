/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.mhm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.management.mhm.MhmEventInfo;
import com.founder.rhip.ehr.entity.management.mhm.MhmStatusInfo;
import com.founder.rhip.ehr.repository.management.mhm.IMhmEventInfoDao;
import com.founder.rhip.ehr.repository.management.mhm.IMhmOtherInfoDao;
import com.founder.rhip.ehr.repository.management.mhm.IMhmStatusInfoDao;
import com.founder.rhip.ehr.service.IPersonCancelListener;
import com.founder.rhip.ehr.service.personal.IPersonRecordActivateService;
import com.founder.rhip.ehr.service.personal.IPersonRecordMoveService;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mhm.common.MhmEvents;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("mhmPersonRecordService")
public class MhmPersonRecordServiceImpl extends AbstractService implements IPersonRecordActivateService, IPersonCancelListener, IPersonRecordMoveService {

    @Resource(name = "mhmStatusInfoDao")
    private IMhmStatusInfoDao mhmStatusInfoDao;

    @Resource(name = "mhmEventInfoDao")
    private IMhmEventInfoDao mhmEventInfoDao;

    @Resource(name = "mhmOtherInfoDao")
    private IMhmOtherInfoDao mhmOtherInfoDao;

    /**
     * 根据PersonId注销人员档案
     * @param personId
     */
    @Override
    @Transactional
    public void cancelPerson(Long personId, String pixId) {
        if(ObjectUtil.isNotEmpty(pixId)){
            Parameters parameters = new Parameters();
            parameters.add("LOGOFF", 1);
            mhmStatusInfoDao.update(parameters, new Criteria("pixId", pixId));
        }
    }

    @Override
    /**
     * 根据PersonId激活人员档案
     */
    @Transactional
    public void activatePerson(Long personId, String pixId) {
        if(ObjectUtil.isNotEmpty(pixId)){
            Parameters parameters = new Parameters();
            parameters.add("LOGOFF", 0);
            mhmStatusInfoDao.update(parameters, new Criteria("pixId", pixId));
        }
    }

    @Override
    /**
     *  档案迁移
     * @param personId
     * @param smpiId
     * @param oldOrg
     * @param newOrg
     */
    @Transactional
    public void personRecordMove(Long personId, String smpiId, Organization oldOrg, Organization newOrg) {
        List<MhmStatusInfo> mhmStatusInfoList = mhmStatusInfoDao.getList(new Criteria("pixId", smpiId));
        List<Integer> events = new ArrayList<Integer>();
        events.add(MhmEvents.M_CLUE.getValue());
        events.add(MhmEvents.I_DISCHARGED.getValue());
        events.add(MhmEvents.I_OUTPATIENT.getValue());
        List<Long> mhmEventIds = new ArrayList<Long>();
        for(MhmStatusInfo mhmStatusInfo : mhmStatusInfoList){
            List<MhmEventInfo> mhmEvents = mhmEventInfoDao.getList(new Criteria("statusId", mhmStatusInfo.getId()).add("eventType", OP.NOTIN, events.toArray()));
            for(MhmEventInfo mhmEventInfo : mhmEvents){
                mhmEventIds.add(mhmEventInfo.getId());
            }
        }
        Criteria ca = new Criteria("id", OP.IN, mhmEventIds);
        Parameters parametersFo = new Parameters();
        parametersFo.add("FILL_ORGAN_CODE", newOrg.getOrganCode());
        mhmOtherInfoDao.update(parametersFo, ca.add("FILL_ORGAN_CODE", oldOrg.getOrganCode()));

        Parameters parametersMs = new Parameters();
        parametersMs.add("MANAGEMENT_STATION", newOrg.getOrganCode());
        mhmOtherInfoDao.update(parametersMs, ca.add("MANAGEMENT_STATION", oldOrg.getOrganCode()));

    }

}