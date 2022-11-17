/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.hm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.repository.basic.HistoryRecorder;
import com.founder.rhip.ehr.repository.clinic.IElderlyPhyExaminationDao;
import com.founder.rhip.ehr.repository.clinic.IElderlyPhyStatusDao;
import com.founder.rhip.ehr.repository.clinic.IHealthExaminationDao;
import com.founder.rhip.ehr.repository.statistics.IElderlyHealthStatisticsDao;
import com.founder.rhip.ehr.repository.statistics.IPhysicalExamRecordDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IMergerOrganizationListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("hmMergerOrgService")
public class HmMergerOrgListenerImpl extends AbstractService implements IMergerOrganizationListener {

    @Resource(name = "physicalExamRecordDao")
    private IPhysicalExamRecordDao physicalExamRecordDao;

    @Resource(name = "healthExaminationDao")
    private IHealthExaminationDao healthExaminationDao;

    @Resource(name = "elderlyPhyExaminationDao")
    private IElderlyPhyExaminationDao elderlyPhyExaminationDao;

    @Resource(name = "elderlyHealthStatisticsDao")
    private IElderlyHealthStatisticsDao elderlyHealthStatisticsDao;

    @Resource(name = "organizationApp")
    private IOrganizationApp organizationApp;

    @Resource(name = "elderlyPhyStatusDao")
    private IElderlyPhyStatusDao elderlyPhyStatusDao;

    /**
     * 站合并（包括同一个中心下和不同中心下）
     * @param station 合并后的站
     * @param stationList 被合并的站列表
     */
    @Override
    public void mergeStation(Organization station, List<Organization> stationList){
        List<String> stationCodes = new ArrayList<>();
        for(Organization org : stationList){
            String stationCode = org.getOrganCode();
            stationCodes.add(stationCode);
        }
        //备份数据
        Criteria caPe = new Criteria("INPUT_ORGAN_CODE", OP.IN, stationCodes);
        HistoryRecorder.record(physicalExamRecordDao, caPe, new String[]{"ID", "INPUT_ORGAN_CODE","INPUT_SUPER_ORGAN_CODE"});

        Criteria caHe = new Criteria("HOSPITAL_CODE", OP.IN, stationCodes);
        //HistoryRecorder.record(healthExaminationDao, caHe, new String[]{"ID", "HOSPITAL_CODE","HOSPITAL_NAME"});

        Criteria caEpe = new Criteria("EXAMINATION_ORGAN_CODE", OP.IN, stationCodes);
       // HistoryRecorder.record(elderlyPhyExaminationDao, caEpe, new String[]{"ID", "EXAMINATION_ORGAN_CODE","EXAMINATION_ORGAN_NAME"});

        Criteria caEhs = new Criteria("ORG_CODE", OP.IN, stationCodes);
        //HistoryRecorder.record(elderlyHealthStatisticsDao, caEhs, new String[]{"ID", "ORG_CODE"});

        //更新数据
        Parameters parameterPe = new Parameters();
        parameterPe.add("INPUT_ORGAN_CODE", station.getOrganCode());
        parameterPe.add("INPUT_SUPER_ORGAN_CODE", station.getParentCode());
        physicalExamRecordDao.update(parameterPe, caPe);

        Parameters parameterHe = new Parameters();
        parameterHe.add("HOSPITAL_CODE", station.getOrganCode());
        parameterHe.add("HOSPITAL_NAME", station.getOrganName());
        healthExaminationDao.update(parameterHe, caHe);

        Parameters parameterEpe = new Parameters();
        parameterEpe.add("EXAMINATION_ORGAN_CODE", station.getOrganCode());
        parameterEpe.add("EXAMINATION_ORGAN_NAME", station.getOrganName());   
        elderlyPhyExaminationDao.update(parameterEpe, caEpe);

        Parameters parameterEhs = new Parameters();
        parameterEhs.add("ORG_CODE", station.getOrganCode());
        elderlyHealthStatisticsDao.update(parameterEhs, caEhs);

        Parameters parameter = new Parameters();
        parameter.add("EXAMINATION_ORGAN_CODE", station.getOrganCode());
        elderlyPhyStatusDao.update(parameter, new Criteria("EXAMINATION_ORGAN_CODE", OP.IN, stationCodes));
    }

    /**
     * 中心合并
     * @param center  合并后的中心
     * @param centerList 被合并的中心列表
     */
    @Override
    public void mergeCenter(Organization center, List<Organization> centerList){
        List<String> centerCodes = new ArrayList<>();
        for(Organization org : centerList){
            String centerCode = org.getOrganCode();
            centerCodes.add(centerCode);
        }
        //备份数据
        Criteria caPe = new Criteria("INPUT_SUPER_ORGAN_CODE", OP.IN, centerCodes);
        Criteria caPes = new Criteria("INPUT_ORGAN_CODE", OP.IN, centerCodes);
        HistoryRecorder.record(physicalExamRecordDao, caPe, new String[]{"ID", "INPUT_SUPER_ORGAN_CODE"});
        HistoryRecorder.record(physicalExamRecordDao, caPes, new String[]{"ID", "INPUT_ORGAN_CODE"});

        Criteria caHe = new Criteria("HOSPITAL_CODE", OP.IN, centerCodes);
        //HistoryRecorder.record(healthExaminationDao, caHe, new String[]{"ID", "HOSPITAL_CODE","HOSPITAL_NAME"});

        Criteria caEpe = new Criteria("EXAMINATION_ORGAN_CODE", OP.IN, centerCodes);
        //HistoryRecorder.record(elderlyPhyExaminationDao, caEpe, new String[]{"ID", "EXAMINATION_ORGAN_CODE","EXAMINATION_ORGAN_NAME"});


        Criteria caEhs = new Criteria("ORG_CODE", OP.IN, centerCodes);
        //HistoryRecorder.record(elderlyHealthStatisticsDao, caEhs, new String[]{"ID", "ORG_CODE"});

        //更新数据
        Parameters parameterPe = new Parameters();
        parameterPe.add("INPUT_ORGAN_CODE", center.getOrganCode());
        physicalExamRecordDao.update(parameterPe, caPes);
        
        parameterPe = new Parameters();
        parameterPe.add("INPUT_SUPER_ORGAN_CODE", center.getOrganCode());
        physicalExamRecordDao.update(parameterPe, caPe);

        Parameters parameterHe = new Parameters();
        parameterHe.add("HOSPITAL_CODE", center.getOrganCode());
        parameterHe.add("HOSPITAL_NAME", center.getOrganName());
        healthExaminationDao.update(parameterHe, caHe);

        Parameters parameterEpe = new Parameters();
        parameterEpe.add("EXAMINATION_ORGAN_CODE", center.getOrganCode());
        parameterEpe.add("EXAMINATION_ORGAN_NAME", center.getOrganName());   
        elderlyPhyExaminationDao.update(parameterEpe, caEpe);

        Parameters parameterEhs = new Parameters();
        parameterEhs.add("ORG_CODE", center.getOrganCode());
        elderlyHealthStatisticsDao.update(parameterEhs, caEhs);

        Parameters parameter = new Parameters();
        parameter.add("EXAMINATION_ORGAN_CODE", center.getOrganCode());
        elderlyPhyStatusDao.update(parameter, new Criteria("EXAMINATION_ORGAN_CODE", OP.IN, centerCodes));
    }

    /**
     * 站转移
     * @param center 转移后的中心
     * @param stationList 被转移的站列表
     */
    @Override
    public void moveStation(Organization center, List<Organization> stationList){
        List<String> stationCodes = new ArrayList<>();
        for(Organization org : stationList){
            String stationCode = org.getOrganCode();
            stationCodes.add(stationCode);
        }
        //备份数据
        Criteria caPe = new Criteria("INPUT_ORGAN_CODE", OP.IN, stationCodes);
        HistoryRecorder.record(physicalExamRecordDao, caPe, new String[]{"ID", "INPUT_SUPER_ORGAN_CODE"});

        //更新数据
        Parameters parameterPe = new Parameters();
        parameterPe.add("INPUT_SUPER_ORGAN_CODE", center.getOrganCode());
        physicalExamRecordDao.update(parameterPe, caPe);


    }

    /**
     * 机构（站）村关系变化时响应的接口 orgCode机构编码 newAddVillageCodes机构中新增加的村
     * @param orgCode
     * @param newAddVillageCodes
     */
	@Override
	public void changeRelationOrgVillage(String orgCode, String[] newAddVillageCodes) {
        Assert.notNull(orgCode, "HmMergerOrgListenerImpl-changeRelationOrgVillage目标机构编码为空");
        Organization organization = organizationApp.queryOrgan(orgCode);
        Assert.notNull(organization, "HmMergerOrgListenerImpl-changeRelationOrgVillage目标机构在系统中不存在");
        Assert.notEmpty(newAddVillageCodes, "HmMergerOrgListenerImpl-changeRelationOrgVillage需要迁移的村编码为空");
        String inputSuperOrganCode = organization.getParentCode();
        if(ObjectUtil.equals(organization.getGenreCode(), OrgGenreCode.CENTRE.getValue())) {
            inputSuperOrganCode = organization.getOrganCode();
        }
        physicalExamRecordDao.updateOrganByVillage(inputSuperOrganCode, orgCode, newAddVillageCodes);
	}
}