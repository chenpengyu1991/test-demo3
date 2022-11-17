/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ech.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.rhip.ehr.repository.child.IChildHealthExaminationDao;
import com.founder.rhip.mdm.service.IMergerTownListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("echMergerTownService")
public class EchMergerTownListenerImpl extends AbstractService implements IMergerTownListener {

    @Resource
    private IChildHealthExaminationDao childHealthExaminationDao;

    /**
     * 乡镇合并
     * @param newTownCode 合并后的乡镇编码
     * @param oldTownCode 被合并的乡镇编码
     */
    @Override
    public void mergeTown(String newTownCode, String[] oldTownCode) {
        //更新数据
        childHealthExaminationDao.update(new Parameters("PATOWN_SHIP", newTownCode), new Criteria("PATOWN_SHIP", OP.IN, oldTownCode));
        childHealthExaminationDao.update(new Parameters("HRTOWN_SHIP", newTownCode), new Criteria("HRTOWN_SHIP", OP.IN, oldTownCode));
        childHealthExaminationDao.update(new Parameters("CREATE_GB_CODE", newTownCode), new Criteria("CREATE_GB_CODE", OP.IN, oldTownCode));
        
    }

    /**
     * 镇村关系变化时响应的接口 townCode镇编码 newAddVillageCodes镇中新增加的村
     * @param townCode
     * @param newAddVillageCodes
     */
	@Override
	public void sendTownVillageRelation(String newTownCode, String[] newAddVillageCodes) {
		Assert.hasText(newTownCode, "需要迁移到的镇编码为空");
		Assert.notEmpty(newAddVillageCodes, "需要迁移的社区编码为空");
		
		;
		Parameters parameters = new Parameters("PATOWN_SHIP", newTownCode);
		childHealthExaminationDao.update(parameters, new Criteria( "PATOWN_SHIP", OP.IN, newAddVillageCodes));
		parameters = new Parameters("HRTOWN_SHIP", newTownCode);
		childHealthExaminationDao.update(parameters, new Criteria( "HRTOWN_SHIP", OP.IN, newAddVillageCodes));
		parameters = new Parameters("CREATE_GB_CODE", newTownCode);
		childHealthExaminationDao.update(parameters, new Criteria( "CREATE_GB_CODE", OP.IN, newAddVillageCodes));

    }
    
}