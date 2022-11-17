/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ep.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.repository.basic.HistoryRecorder;
import com.founder.rhip.ehr.repository.ep.*;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.service.IDictionaryService;
import com.founder.rhip.mdm.service.IMergerTownListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("epMergerTownService")
public class EpMergerTownListenerImpl extends AbstractService implements IMergerTownListener {

    @Resource
    private ISaltMonitorRecordDao saltMonitorRecordDao;  //监测记录

    @Resource
    private IIodineNutritionMonitorDao iodineNutritionMonitorDao;  //监测调查记录

    @Resource
    private IIodineNutritionSamplingDao iodineNutritionSamplingDao;   //抽样登记

    @Resource
    private IWaterIodineMonitorDao waterIodineMonitorDao;//水碘监测

    @Resource
    private ISaltSamplingRecordDao saltSamplingRecordDao;//抽样登记－碘盐监测

    @Resource(name="mdmDictionaryService")
    private IDictionaryService dictionaryService;

    /**
     * 乡镇合并
     * @param newTownCode 合并后的乡镇编码
     * @param oldTownCode 被合并的乡镇编码
     */
    @Override
    public void mergeTown(String newTownCode, String[] oldTownCode) {
        Criteria criteria = new Criteria("GB_CODE", OP.IN, oldTownCode);
        HistoryRecorder.record(saltMonitorRecordDao, criteria, new String[]{"ID", "GB_CODE", "VILLAGE_CODE"});
        Parameters param = new Parameters();
        param.add("GB_CODE",newTownCode);
        saltMonitorRecordDao.update(param, criteria);

        Criteria criteria1 = new Criteria("GB_CODE", OP.IN, oldTownCode);
        HistoryRecorder.record(iodineNutritionMonitorDao, criteria1, new String[]{"ID", "GB_CODE", "VILLAGE_CODE"});
        Parameters param1 = new Parameters();
        param1.add("GB_CODE",newTownCode);
        iodineNutritionMonitorDao.update(param1, criteria1);

        Criteria criteria2 = new Criteria("CODE", OP.IN, oldTownCode);
        HistoryRecorder.record(iodineNutritionSamplingDao, criteria2, new String[]{"ID", "CODE", "NAME"});
        Parameters param2 = new Parameters();
        param2.add("CODE",newTownCode);
        DicItem dicItemOld = dictionaryService.getDicItem("FS990001", newTownCode);
        param2.add("NAME",dicItemOld.getItemName());
        iodineNutritionSamplingDao.update(param2, criteria2);

        Criteria criteria3 = new Criteria("GB_CODE", OP.IN, oldTownCode);
        HistoryRecorder.record(waterIodineMonitorDao, criteria3, new String[]{"ID", "GB_CODE", "VILLAGE_CODE"});
        Parameters param3 = new Parameters();
        param3.add("GB_CODE",newTownCode);
        waterIodineMonitorDao.update(param3, criteria3);

        Criteria criteria4 = new Criteria("GB_CODE", OP.IN, oldTownCode);
        HistoryRecorder.record(saltSamplingRecordDao, criteria4, new String[]{"ID", "GB_CODE", "VILLAGE_CODE"});
        Parameters param4 = new Parameters();
        param4.add("GB_CODE",newTownCode);
        saltSamplingRecordDao.update(param4, criteria4);
    }

    /**
     * 镇村关系变化时响应的接口 townCode镇编码 newAddVillageCodes镇中新增加的村
     * @param townCode
     * @param newAddVillageCodes
     */
	@Override
	public void sendTownVillageRelation(String townCode, String[] newAddVillageCodes) {
        Criteria criteria = new Criteria("VILLAGE_CODE", OP.IN, newAddVillageCodes);
        HistoryRecorder.record(saltMonitorRecordDao, criteria, new String[]{"ID", "GB_CODE", "VILLAGE_CODE"});
        Parameters param = new Parameters();
        param.add("GB_CODE",townCode);
        saltMonitorRecordDao.update(param, criteria);

        Criteria criteria1 = new Criteria("VILLAGE_CODE", OP.IN, newAddVillageCodes);
        HistoryRecorder.record(iodineNutritionMonitorDao, criteria1, new String[]{"ID", "GB_CODE", "VILLAGE_CODE"});
        Parameters param1 = new Parameters();
        param1.add("GB_CODE",townCode);
        iodineNutritionMonitorDao.update(param1, criteria1);

        Criteria criteria3 = new Criteria("VILLAGE_CODE", OP.IN, newAddVillageCodes);
        HistoryRecorder.record(waterIodineMonitorDao, criteria3, new String[]{"ID", "GB_CODE", "VILLAGE_CODE"});
        Parameters param3 = new Parameters();
        param3.add("GB_CODE",townCode);
        waterIodineMonitorDao.update(param3, criteria3);

        Criteria criteria4 = new Criteria("VILLAGE_CODE", OP.IN, newAddVillageCodes);
        HistoryRecorder.record(saltSamplingRecordDao, criteria4, new String[]{"ID", "GB_CODE", "VILLAGE_CODE"});
        Parameters param4 = new Parameters();
        param4.add("GB_CODE",townCode);
        saltSamplingRecordDao.update(param4, criteria4);

	}

}