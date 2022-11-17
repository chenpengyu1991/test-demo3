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
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IMergerOrganizationListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("epMergerOrgService")
public class EpMergerOrgListenerImpl extends AbstractService implements IMergerOrganizationListener {

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

    /**
     * 站合并（包括同一个中心下和不同中心下）
     * @param station 合并后的站
     * @param stationList 被合并的站列表
     */
    @Override
    public void mergeStation(Organization station, List<Organization> stationList){
        List<String> stationCodeList = new ArrayList<String>();
        for(Organization org: stationList){
            stationCodeList.add(org.getOrganCode());
        }
        Criteria criteria = new Criteria("CREATE_ORGAN", OP.IN, stationCodeList);
        HistoryRecorder.record(saltMonitorRecordDao, criteria, new String[]{"ID", "GB_CODE", "VILLAGE_CODE", "CREATE_ORGAN"});
        HistoryRecorder.record(iodineNutritionMonitorDao, criteria, new String[]{"ID", "GB_CODE", "VILLAGE_CODE", "CREATE_ORGAN"});
        HistoryRecorder.record(iodineNutritionSamplingDao, criteria, new String[]{"ID", "CODE", "NAME", "CREATE_ORGAN"});
        HistoryRecorder.record(waterIodineMonitorDao, criteria, new String[]{"ID", "GB_CODE", "VILLAGE_CODE", "CREATE_ORGAN"});
        HistoryRecorder.record(saltSamplingRecordDao, criteria, new String[]{"ID", "GB_CODE", "VILLAGE_CODE", "CREATE_ORGAN"});

        Parameters param = new Parameters();
        param.add("CREATE_ORGAN",station.getOrganCode());
        param.add("GB_CODE",station.getGbCode());
        saltMonitorRecordDao.update(param, criteria);
        iodineNutritionMonitorDao.update(param, criteria);
        waterIodineMonitorDao.update(param, criteria);
        saltSamplingRecordDao.update(param, criteria);

        Parameters param1 = new Parameters();
        param1.add("CREATE_ORGAN",station.getOrganCode());
        param1.add("CODE",station.getGbCode());
        iodineNutritionSamplingDao.update(param1, criteria.add("TYPE", 1));
    }

    /**
     * 中心合并
     * @param center  合并后的中心
     * @param centerList 被合并的中心列表
     */
    @Override
    public void mergeCenter(Organization center, List<Organization> centerList){
        List<String> centerCodeList = new ArrayList<String>();
        for(Organization org: centerList){
            centerCodeList.add(org.getOrganCode());
        }
        Criteria criteria = new Criteria("CREATE_ORGAN", OP.IN, centerCodeList);
        HistoryRecorder.record(saltMonitorRecordDao, criteria, new String[]{"ID", "GB_CODE", "VILLAGE_CODE", "CREATE_ORGAN"});
        HistoryRecorder.record(iodineNutritionMonitorDao, criteria, new String[]{"ID", "GB_CODE", "VILLAGE_CODE", "CREATE_ORGAN"});
        HistoryRecorder.record(iodineNutritionSamplingDao, criteria, new String[]{"ID", "CODE", "NAME", "CREATE_ORGAN"});
        HistoryRecorder.record(waterIodineMonitorDao, criteria, new String[]{"ID", "GB_CODE", "VILLAGE_CODE", "CREATE_ORGAN"});
        HistoryRecorder.record(saltSamplingRecordDao, criteria, new String[]{"ID", "GB_CODE", "VILLAGE_CODE", "CREATE_ORGAN"});

        Parameters param = new Parameters();
        param.add("CREATE_ORGAN",center.getOrganCode());
        param.add("GB_CODE",center.getGbCode());
        saltMonitorRecordDao.update(param, criteria);
        iodineNutritionMonitorDao.update(param, criteria);
        waterIodineMonitorDao.update(param, criteria);
        saltSamplingRecordDao.update(param, criteria);

        Parameters param1 = new Parameters();
        param1.add("CREATE_ORGAN",center.getOrganCode());
        param1.add("CODE",center.getGbCode());
        iodineNutritionSamplingDao.update(param1, criteria.add("TYPE", 1));
    }

    /**
     * 站转移
     * @param center 转移后的中心
     * @param stationList 被转移的站列表
     */
    @Override
    public void moveStation(Organization center, List<Organization> stationList){
        List<String> stationCodeList = new ArrayList<String>();
        for(Organization org: stationList){
            stationCodeList.add(org.getOrganCode());
        }
        Criteria criteria = new Criteria("CREATE_ORGAN", OP.IN, stationCodeList);
        HistoryRecorder.record(saltMonitorRecordDao, criteria, new String[]{"ID", "GB_CODE", "VILLAGE_CODE", "CREATE_ORGAN"});
        HistoryRecorder.record(iodineNutritionMonitorDao, criteria, new String[]{"ID", "GB_CODE", "VILLAGE_CODE", "CREATE_ORGAN"});
        HistoryRecorder.record(iodineNutritionSamplingDao, criteria, new String[]{"ID", "CODE", "NAME", "CREATE_ORGAN"});
        HistoryRecorder.record(waterIodineMonitorDao, criteria, new String[]{"ID", "GB_CODE", "VILLAGE_CODE", "CREATE_ORGAN"});
        HistoryRecorder.record(saltSamplingRecordDao, criteria, new String[]{"ID", "GB_CODE", "VILLAGE_CODE", "CREATE_ORGAN"});

        Parameters param = new Parameters();
        param.add("GB_CODE",center.getGbCode());
        saltMonitorRecordDao.update(param, criteria);
        iodineNutritionMonitorDao.update(param, criteria);
        waterIodineMonitorDao.update(param, criteria);
        saltSamplingRecordDao.update(param, criteria);

        Parameters param1 = new Parameters();
        param1.add("CODE",center.getGbCode());
        iodineNutritionSamplingDao.update(param1, criteria.add("TYPE", 1));
    }

    /**
     * 机构（站）村关系变化时响应的接口 orgCode机构编码 newAddVillageCodes机构中新增加的村
     * @param orgCode
     * @param newAddVillageCodes
     */
	@Override
	public void changeRelationOrgVillage(String orgCode, String[] newAddVillageCodes) {
    }

}