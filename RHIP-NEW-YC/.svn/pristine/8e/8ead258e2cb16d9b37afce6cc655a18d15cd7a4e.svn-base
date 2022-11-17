/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.he.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.repository.basic.HistoryRecorder;
import com.founder.rhip.ehr.repository.healtheducation.*;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IMergerOrganizationListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("heMergerOrgService")//机构合并 健康教育服务模块
public class HeMergerOrgListenerImpl extends AbstractService implements IMergerOrganizationListener {


    @Resource(name = "heResourceDao")
    private IHeResourceDao healthEducationResourceDao;        //宣传设备 宣传阵地 宣传材料

    @Resource(name = "heActiveDao")
    private IHeActiveDao healthEducationActiveDao;     //健康教育活动

    @Resource(name = "heResourceRecordDao")
    private IHeResourceRecordDao healthResourceRecordDao;   //宣传阵地使用

    @Resource(name = "heSupervisorDao")
    private IHeSupervisorDao healthSupervisorDao;      //工作督查


    @Resource(name = "hePrescriptionDao")
    private IHePrescriptionDao healthPrescriptionDao;   //健康教育处方

    @Resource(name = "heWorkPlanDao")
    private IHeWorkPlanDao heWorkPlanDao;

    @Resource(name = "heIndividualDao")
    private IHeIndividualDao heIndividualDao;

    @Resource(name = "heMediaDao")
    private IHeMediaDao heMediaDao; //播放影像


    /**
     * 站合并（包括同一个中心下和不同中心下）
     *
     * @param station     合并后的站
     * @param stationList 被合并的站列表
     */
    @Override
    @Transactional
    public void mergeStation(Organization station, List<Organization> stationList) {
        List<String> stationCodes = new ArrayList<>();
        for (Organization org : stationList) {
            String stationCode = org.getOrganCode();
            stationCodes.add(stationCode);
        }
        //备份数据
        Criteria caOrg = new Criteria("ORG_CODE", OP.IN, stationCodes);
        HistoryRecorder.record(healthEducationResourceDao, caOrg, new String[]{"ID", "ORG_CODE", "CENTER_ORG_CODE", "GBCODE"});
        HistoryRecorder.record(healthEducationActiveDao, caOrg, new String[]{"ID", "ORG_CODE", "CENTER_ORG_CODE", "GBCODE"});
        HistoryRecorder.record(healthResourceRecordDao, caOrg, new String[]{"ID", "ORG_CODE", "CENTER_ORG_CODE", "GBCODE"});
        HistoryRecorder.record(healthSupervisorDao, caOrg, new String[]{"ID", "ORG_CODE", "CENTER_ORG_CODE", "GBCODE"});
        HistoryRecorder.record(healthPrescriptionDao, caOrg, new String[]{"ID", "ORG_CODE", "CENTER_ORG_CODE", "GBCODE"});

        //更新数据
        Parameters parameter = new Parameters("ORG_CODE", station.getOrganCode());
        parameter.add("GBCODE", station.getGbCode());
        parameter.add("CENTER_ORG_CODE", station.getParentCode());
        healthEducationResourceDao.update(parameter, caOrg);
        healthEducationActiveDao.update(parameter, caOrg);
        healthResourceRecordDao.update(parameter, caOrg);
        healthSupervisorDao.update(parameter, caOrg);
        healthPrescriptionDao.update(parameter, caOrg);
        heIndividualDao.update(parameter, caOrg);
        heMediaDao.update(parameter, caOrg);//播放影像

        caOrg = new Criteria("CREATE_ORG_CODE", OP.IN, stationCodes);
        parameter = new Parameters("CREATE_ORG_CODE", station.getOrganCode());
        parameter.add("CREATE_CENTER_ORG_CODE", station.getParentCode());
        parameter.add("CREATE_GBCODE", station.getGbCode());
        heWorkPlanDao.update(parameter, caOrg);
    }

    /**
     * 中心合并
     *
     * @param center     合并后的中心
     * @param centerList 被合并的中心列表
     */
    @Override
    public void mergeCenter(Organization center, List<Organization> centerList) {
        List<String> centerCodes = new ArrayList<>();
        for (Organization org : centerList) {
            String centerCode = org.getOrganCode();
            centerCodes.add(centerCode);
        }
        //备份数据
        Criteria caOrg = new Criteria("ORG_CODE", OP.IN, centerCodes);
        Criteria caCenterOrg = new Criteria("CENTER_ORG_CODE", OP.IN, centerCodes);
        caOrg.add(LOP.OR, caCenterOrg);
        Criteria ca = new Criteria();
        HistoryRecorder.record(healthEducationResourceDao, ca.add(caOrg), new String[]{"ID", "ORG_CODE", "CENTER_ORG_CODE", "GBCODE"});
        HistoryRecorder.record(healthEducationActiveDao, ca.add(caOrg), new String[]{"ID", "ORG_CODE", "CENTER_ORG_CODE", "GBCODE"});
        HistoryRecorder.record(healthResourceRecordDao, ca.add(caOrg), new String[]{"ID", "ORG_CODE", "CENTER_ORG_CODE", "GBCODE"});
        HistoryRecorder.record(healthSupervisorDao, ca.add(caOrg), new String[]{"ID", "ORG_CODE", "CENTER_ORG_CODE", "GBCODE"});
        HistoryRecorder.record(healthPrescriptionDao, ca.add(caOrg), new String[]{"ID", "ORG_CODE", "CENTER_ORG_CODE", "GBCODE"});

        //更新数据
        Criteria caOrg1 = new Criteria("ORG_CODE", OP.IN, centerCodes);
        Parameters parameter = new Parameters();
        parameter.add("ORG_CODE", center.getOrganCode());
        parameter.add("GBCODE", center.getGbCode());
        healthEducationResourceDao.update(parameter, caOrg1);
        healthEducationActiveDao.update(parameter, caOrg1);
        healthResourceRecordDao.update(parameter, caOrg1);
        healthSupervisorDao.update(parameter, caOrg1);
        healthPrescriptionDao.update(parameter, caOrg1);
        heIndividualDao.update(parameter, caOrg1);
        heMediaDao.update(parameter, caOrg1);//播放影像

        caCenterOrg = new Criteria("CENTER_ORG_CODE", OP.IN, centerCodes);
        Parameters parameterCenter = new Parameters();
        parameterCenter.add("CENTER_ORG_CODE", center.getOrganCode());
        parameterCenter.add("GBCODE", center.getGbCode());
        healthEducationResourceDao.update(parameterCenter, caCenterOrg);
        healthEducationActiveDao.update(parameterCenter, caCenterOrg);
        healthResourceRecordDao.update(parameterCenter, caCenterOrg);
        healthSupervisorDao.update(parameterCenter, caCenterOrg);
        healthPrescriptionDao.update(parameterCenter, caCenterOrg);
        heIndividualDao.update(parameterCenter, caCenterOrg);
        heMediaDao.update(parameterCenter, caCenterOrg);//播放影像

        caOrg = new Criteria("CREATE_ORG_CODE", OP.IN, centerCodes);
        parameter = new Parameters("CREATE_ORG_CODE", center.getOrganCode());
        parameter.add("CREATE_CENTER_ORG_CODE", center.getOrganCode());
        parameter.add("CREATE_GBCODE", center.getGbCode());
        heWorkPlanDao.update(parameter, caOrg);
    }

    /**
     * 站转移
     *
     * @param center      转移后的中心
     * @param stationList 被转移的站列表
     */
    @Override
    public void moveStation(Organization center, List<Organization> stationList) {
        List<String> stationCodes = new ArrayList<>();
        for (Organization org : stationList) {
            String stationCode = org.getOrganCode();
            stationCodes.add(stationCode);
        }
        //备份数据
        Criteria caOrg = new Criteria("ORG_CODE", OP.IN, stationCodes);
        HistoryRecorder.record(healthEducationResourceDao, caOrg, new String[]{"ID", "ORG_CODE", "CENTER_ORG_CODE", "GBCODE"});
        HistoryRecorder.record(healthEducationActiveDao, caOrg, new String[]{"ID", "ORG_CODE", "CENTER_ORG_CODE", "GBCODE"});
        HistoryRecorder.record(healthResourceRecordDao, caOrg, new String[]{"ID", "ORG_CODE", "CENTER_ORG_CODE", "GBCODE"});
        HistoryRecorder.record(healthSupervisorDao, caOrg, new String[]{"ID", "ORG_CODE", "CENTER_ORG_CODE", "GBCODE"});
        HistoryRecorder.record(healthPrescriptionDao, caOrg, new String[]{"ID", "ORG_CODE", "CENTER_ORG_CODE", "GBCODE"});

        //更新数据
        Parameters parameter = new Parameters();
        parameter.add("CENTER_ORG_CODE", center.getOrganCode());
        parameter.add("GBCODE", center.getGbCode());
        healthEducationResourceDao.update(parameter, caOrg);
        healthEducationActiveDao.update(parameter, caOrg);
        healthResourceRecordDao.update(parameter, caOrg);
        healthSupervisorDao.update(parameter, caOrg);
        healthPrescriptionDao.update(parameter, caOrg);
        heIndividualDao.update(parameter, caOrg);
        heMediaDao.update(parameter, caOrg);//播放影像

        caOrg = new Criteria("CREATE_ORG_CODE", OP.IN, stationCodes);
        parameter = new Parameters("CREATE_CENTER_ORG_CODE", center.getOrganCode());
        parameter.add("CREATE_GBCODE", center.getGbCode());
        heWorkPlanDao.update(parameter, caOrg);
    }

    /**
     * 机构（站）村关系变化时响应的接口 orgCode机构编码 newAddVillageCodes机构中新增加的村
     *
     * @param orgCode
     * @param newAddVillageCodes
     */
    @Override
    public void changeRelationOrgVillage(String orgCode, String[] newAddVillageCodes) {

//        List<String> stationCodes = new ArrayList<String>();
//        Map<String, String> stationMap = new HashMap<String, String>();
//
//        for (String villageCode : newAddVillageCodes) {
//            Organization org = organizationApp.queryOrganByVillage(villageCode);
//            if (ObjectUtil.isNotEmpty(org)) {
//                String stationCode = org.getOrganCode();
//                if (stationMap.containsKey(stationCode)) {
//                    continue;
//                } else {
//                    stationMap.put(stationCode, stationCode);
//                    stationCodes.add(stationCode);
//                }
//            }
//        }
//
//        //备份数据
//        Criteria caOrg = new Criteria("ORG_CODE", OP.IN, stationCodes);
//
//        HistoryRecorder.record(healthEducationResourceDao, caOrg, new String[]{"ID", "ORG_CODE", "CENTER_ORG_CODE", "GBCODE"});
//        HistoryRecorder.record(healthEducationActiveDao, caOrg, new String[]{"ID", "ORG_CODE", "CENTER_ORG_CODE", "GBCODE"});
//        HistoryRecorder.record(healthResourceRecordDao, caOrg, new String[]{"ID", "ORG_CODE", "CENTER_ORG_CODE", "GBCODE"});
//        HistoryRecorder.record(healthSupervisorDao, caOrg, new String[]{"ID", "ORG_CODE", "CENTER_ORG_CODE", "GBCODE"});
//        HistoryRecorder.record(healthPrescriptionDao, caOrg, new String[]{"ID", "ORG_CODE", "CENTER_ORG_CODE", "GBCODE"});
//
//        //更新数据
//        Organization station = organizationApp.queryOrgan(orgCode);
//        if (ObjectUtil.isNotEmpty(station)) {
//            Parameters parameter = new Parameters();
//            parameter.add("CENTER_ORG_CODE", station.getParentCode());
//            parameter.add("GBCODE", station.getGbCode());
//            healthEducationResourceDao.update(parameter, caOrg);
//            healthEducationActiveDao.update(parameter, caOrg);
//            healthResourceRecordDao.update(parameter, caOrg);
//            healthSupervisorDao.update(parameter, caOrg);
//            healthPrescriptionDao.update(parameter, caOrg);
//        }
    }

}