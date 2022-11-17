/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.entity.clinic.ReferralInfo;
import com.founder.rhip.ehr.repository.basic.HistoryRecorder;
import com.founder.rhip.ehr.repository.clinic.IReferralInfoDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("drMergerOrgService")
public class DrMergerOrgListenerImpl extends AbstractService /**implements IMergerOrganizationListener**/ {

    @Resource
    private IReferralInfoDao referralInfoDao;

    @Resource(name = "organizationApp")
    private IOrganizationApp organizationApp;     //

    /**
     * 站合并（包括同一个中心下和不同中心下）
     * @param station 合并后的站
     * @param stationList 被合并的站列表
     */
    //@Override
    public void mergeStation(Organization station, List<Organization> stationList){
        List<String> stationCodes = new ArrayList<>();
        for(Organization organ : stationList){
            stationCodes.add(organ.getOrganCode());
        }
        Criteria criteria1 = new Criteria("REFERRAL_HOSPITAL_CODE", OP.IN, stationCodes);
        Criteria criteria2 = new Criteria("UPDATE_ORGAN", OP.IN, stationCodes);
        criteria1.add(LOP.OR, criteria2);
        Criteria criteria = new Criteria();
        HistoryRecorder.record(referralInfoDao, criteria.add(criteria1), new String[]{"ID", "FASTREET", "DEST_DEPT_CODE", "DEST_DEPT_NAME", "REFERRAL_HOSPITAL_CODE", "REFERRAL_HOSPITAL_NAME", "UPDATE_ORGAN"});

        Parameters param1 = new Parameters();
        param1.add("REFERRAL_HOSPITAL_CODE",station.getOrganCode());
        param1.add("REFERRAL_HOSPITAL_NAME",station.getOrganName());
        referralInfoDao.update(param1, new Criteria("REFERRAL_HOSPITAL_CODE", OP.IN, stationCodes));

        Parameters param2 = new Parameters();
        param2.add("UPDATE_ORGAN",station.getOrganCode());
        referralInfoDao.update(param2, new Criteria("UPDATE_ORGAN", OP.IN, stationCodes));

        Parameters param3 = new Parameters();
        param3.add("DEST_DEPT_CODE",station.getOrganCode());
        param3.add("DEST_DEPT_NAME",station.getOrganName());
        referralInfoDao.update(param3, new Criteria("DEST_DEPT_CODE", OP.IN, stationCodes));
    }

    /**
     * 中心合并
     * @param center  合并后的中心
     * @param centerList 被合并的中心列表
     */
    //@Override
    public void mergeCenter(Organization center, List<Organization> centerList){
        List<String> centerCodes = new ArrayList<>();
        for(Organization organ : centerList){
            centerCodes.add(organ.getOrganCode());
        }
        Criteria criteria1 = new Criteria("REFERRAL_HOSPITAL_CODE", OP.IN, centerCodes);
        Criteria criteria2 = new Criteria("UPDATE_ORGAN", OP.IN, centerCodes);
        Criteria criteria3 = new Criteria("DEST_DEPT_CODE", OP.IN, centerCodes);
        criteria1.add(LOP.OR, criteria2);
        criteria1.add(LOP.OR, criteria3);
        Criteria criteria = new Criteria();
        HistoryRecorder.record(referralInfoDao, criteria.add(criteria1), new String[]{"ID", "FASTREET", "DEST_DEPT_CODE", "DEST_DEPT_NAME", "REFERRAL_HOSPITAL_CODE", "REFERRAL_HOSPITAL_NAME", "UPDATE_ORGAN"});

        Parameters param1 = new Parameters();
        param1.add("REFERRAL_HOSPITAL_CODE",center.getOrganCode());
        param1.add("REFERRAL_HOSPITAL_NAME",center.getOrganName());
        referralInfoDao.update(param1, new Criteria("REFERRAL_HOSPITAL_CODE", OP.IN, centerCodes));

        Parameters param2 = new Parameters();
        param2.add("UPDATE_ORGAN",center.getOrganCode());
        referralInfoDao.update(param2, new Criteria("UPDATE_ORGAN", OP.IN, centerCodes));

        Parameters param3 = new Parameters();
        param3.add("DEST_DEPT_CODE",center.getOrganCode());
        param3.add("DEST_DEPT_NAME",center.getOrganName());
        referralInfoDao.update(param3, new Criteria("DEST_DEPT_CODE", OP.IN, centerCodes));
    }

    /**
     * 站转移
     * @param center 转移后的中心
     * @param stationList 被转移的站列表
     */
   // @Override
    public void moveStation(Organization center, List<Organization> stationList){
    }

    /**
     * 机构（站）村关系变化时响应的接口 orgCode机构编码 newAddVillageCodes机构中新增加的村
     * @param orgCode
     * @param newAddVillageCodes
     */
	//@Override
	public void changeRelationOrgVillage(String orgCode, String[] newAddVillageCodes) {
        Organization station = organizationApp.queryOrgan(orgCode);

        Criteria ca = new Criteria("FASTREET", OP.IN, newAddVillageCodes);
        List<ReferralInfo> refs = referralInfoDao.getList(ca, new String[]{"ID", "DEST_DEPT_CODE", "DEST_DEPT_NAME", "REFERRAL_HOSPITAL_CODE", "REFERRAL_HOSPITAL_NAME", "UPDATE_ORGAN"});

        List stationIds = new ArrayList();
        List centerIds = new ArrayList();

        for(ReferralInfo referralInfo : refs){
            String organCode = referralInfo.getUpdateOrgan();
            Organization org = organizationApp.queryOrgan(organCode);
            if("B1".equals(org.getGenreCode())){
                centerIds.add(referralInfo.getId());
            }
            if("B2".equals(org.getGenreCode())){
                stationIds.add(referralInfo.getId());
            }
        }

        //站
        Parameters paramS1 = new Parameters();
        paramS1.add("UPDATE_ORGAN",station.getOrganCode());
        paramS1.add("DEST_DEPT_CODE",station.getOrganCode());
        paramS1.add("DEST_DEPT_NAME",station.getOrganName());
        referralInfoDao.update(paramS1, new Criteria("ID", OP.IN, stationIds));

        //中心
        Parameters paramC1 = new Parameters();
        paramC1.add("UPDATE_ORGAN",station.getParentCode());
        paramS1.add("DEST_DEPT_CODE",station.getParentCode());
        paramS1.add("DEST_DEPT_NAME",station.getOrganName());
        referralInfoDao.update(paramC1, new Criteria("ID", OP.IN, centerIds));
    }

}