/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ph.service.oh;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.repository.basic.HistoryRecorder;
import com.founder.rhip.ehr.repository.oh.IOhEmployeeInfoDao;
import com.founder.rhip.ehr.repository.oh.IOhHospitalInfoDao;
import com.founder.rhip.ehr.repository.oh.IOhPoisonReportDao;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IMergerOrganizationListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("ohMergerOrgService")
public class OhMergerOrgListenerImpl extends AbstractService implements IMergerOrganizationListener {

    @Resource
    IOhEmployeeInfoDao employeeInfoDao; //职业病人管理

    @Resource
    private IOhPoisonReportDao ohPoisonReportDao; //农药中毒报告

    @Resource
    private IOhHospitalInfoDao ohHospitalInfoDao; //放射卫生管理

    /**
     * 站合并（包括同一个中心下和不同中心下）
     * @param station 合并后的站
     * @param stationList 被合并的站列表
     */
    @Override
    public void mergeStation(Organization station, List<Organization> stationList){
        List<String> stationCodes = new ArrayList<>();
        for(Organization organ : stationList){
            stationCodes.add(organ.getOrganCode());
        }
        Criteria criteriaE = new Criteria("CREATE_ORGAN_CODE", OP.IN, stationCodes);
        Criteria criteriaP = new Criteria("CREATE_ORGAN_CODE", OP.IN, stationCodes);
        Criteria criteriaH1 = new Criteria("ORG_CODE", OP.IN, stationCodes);
        Criteria criteriaH2 = new Criteria("CREATE_ORGAN_CODE", OP.IN, stationCodes);
        criteriaH1.add(LOP.OR, criteriaH2);
        HistoryRecorder.record(employeeInfoDao, criteriaE, new String[]{"ID", "PAPROVINCE", "PACITY", "PACOUNTY", "PATOWN_SHIP", "PASTREET", "CREATE_ORGAN_CODE", "UPDATE_ORGAN_CODE"});
        HistoryRecorder.record(ohPoisonReportDao, criteriaP, new String[]{"ID", "PAPROVINCE", "PACITY", "PACOUNTY", "PATOWN_SHIP", "PASTREET", "CREATE_ORGAN_CODE", "UPDATE_ORGAN_CODE"});
        HistoryRecorder.record(ohHospitalInfoDao, new Criteria().add(criteriaH1), new String[]{"ID", "ORG_CODE", "CREATE_ORGAN_CODE", "UPDATE_ORGAN_CODE"});

        Parameters paramE = new Parameters();
        paramE.add("CREATE_ORGAN_CODE",station.getOrganCode());
        employeeInfoDao.update(paramE, criteriaE);

        Parameters paramP = new Parameters();
        paramP.add("CREATE_ORGAN_CODE",station.getOrganCode());
        ohPoisonReportDao.update(paramP, criteriaP);

        Parameters paramH1 = new Parameters();
        paramH1.add("ORG_CODE",station.getOrganCode());
        ohHospitalInfoDao.update(paramH1, new Criteria("ORG_CODE", OP.IN, stationCodes));

        Parameters paramH2 = new Parameters();
        paramH2.add("CREATE_ORGAN_CODE",station.getOrganCode());
        ohHospitalInfoDao.update(paramH2, new Criteria("CREATE_ORGAN_CODE", OP.IN, stationCodes));
    }

    /**
     * 中心合并
     * @param center  合并后的中心
     * @param centerList 被合并的中心列表
     */
    @Override
    public void mergeCenter(Organization center, List<Organization> centerList){
        List<String> centerCodes = new ArrayList<>();
        for(Organization organ : centerList){
            centerCodes.add(organ.getOrganCode());
        }
        Criteria criteriaE = new Criteria("CREATE_ORGAN_CODE", OP.IN, centerCodes);
        Criteria criteriaP = new Criteria("CREATE_ORGAN_CODE", OP.IN, centerCodes);
        Criteria criteriaH1 = new Criteria("ORG_CODE", OP.IN, centerCodes);
        Criteria criteriaH2 = new Criteria("CREATE_ORGAN_CODE", OP.IN, centerCodes);
        criteriaH1.add(LOP.OR, criteriaH2);

        HistoryRecorder.record(employeeInfoDao, criteriaE, new String[]{"ID", "PAPROVINCE", "PACITY", "PACOUNTY", "PATOWN_SHIP", "PASTREET", "CREATE_ORGAN_CODE", "UPDATE_ORGAN_CODE"});
        HistoryRecorder.record(ohPoisonReportDao, criteriaP, new String[]{"ID", "PAPROVINCE", "PACITY", "PACOUNTY", "PATOWN_SHIP", "PASTREET", "CREATE_ORGAN_CODE", "UPDATE_ORGAN_CODE"});
        HistoryRecorder.record(ohHospitalInfoDao, new Criteria().add(criteriaH1), new String[]{"ID", "ORG_CODE", "CREATE_ORGAN_CODE", "UPDATE_ORGAN_CODE"});

        Parameters paramE = new Parameters();
        paramE.add("CREATE_ORGAN_CODE",center.getOrganCode());
        employeeInfoDao.update(paramE, criteriaE);

        Parameters paramP = new Parameters();
        paramP.add("CREATE_ORGAN_CODE",center.getOrganCode());
        ohPoisonReportDao.update(paramP, criteriaP);

        Parameters paramH1 = new Parameters();
        paramH1.add("ORG_CODE",center.getOrganCode());
        ohHospitalInfoDao.update(paramH1, new Criteria("ORG_CODE", OP.IN, centerCodes));

        Parameters paramH2 = new Parameters();
        paramH2.add("CREATE_ORGAN_CODE",center.getOrganCode());
        ohHospitalInfoDao.update(paramH2, new Criteria("CREATE_ORGAN_CODE", OP.IN, centerCodes));
    }

    /**
     * 站转移
     * @param center 转移后的中心
     * @param stationList 被转移的站列表
     */
    @Override
    public void moveStation(Organization center, List<Organization> stationList){
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