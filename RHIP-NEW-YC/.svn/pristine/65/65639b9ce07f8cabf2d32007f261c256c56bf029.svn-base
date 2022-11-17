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
import com.founder.rhip.mdm.repository.ISchoolInfoDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("mdmMergerTownService")
public class MdmMergerTownListenerImpl extends AbstractService implements IMergerTownListener {

    @Resource
    private ISchoolInfoDao schoolInfoDao;

    /**
     * 乡镇合并
     * @param newTownCode 合并后的乡镇编码
     * @param oldTownCode 被合并的乡镇编码
     */
    @Override
    public void mergeTown(String newTownCode, String[] oldTownCode) {
        Criteria criteria = new Criteria("ORGAN_TOWN", OP.IN, oldTownCode);
//        HistoryRecorder.record(schoolInfoDao, criteria, new String[]{"schoolId", "ORGAN_TOWN", "EXAM_ORGAN"});
        Parameters param = new Parameters();
        param.add("ORGAN_TOWN",newTownCode);
        schoolInfoDao.update(param, criteria);
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