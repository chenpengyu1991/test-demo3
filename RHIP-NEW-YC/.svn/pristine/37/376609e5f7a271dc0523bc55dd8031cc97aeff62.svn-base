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
import com.founder.rhip.ehr.repository.ech.IEchIdentificationDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IMergerOrganizationListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("echMergerOrgService")
public class EchMergerOrgListenerImpl extends AbstractService implements IMergerOrganizationListener {

	 @Resource(name = "echIdentificationDao")
	    private IEchIdentificationDao echIdentificationDao;        //中医体质辨识表

	    @Resource
	    private IChildHealthExaminationDao childHealthExaminationDao;

	    @Resource(name = "organizationApp")
	    private IOrganizationApp organizationApp;

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
	        List<String> stationNames = new ArrayList<>();
	        for (Organization org : stationList) {
	            String stationCode = org.getOrganCode();
	            stationCodes.add(stationCode);
	            stationNames.add(org.getOrganName());
	        }
	        //备份数据
	        Criteria ca1 = new Criteria();
	        ca1.add("CREATE_ORG", OP.IN, stationCodes);
	        Criteria ca2 = new Criteria();
	        ca2.add("UPDATE_ORG", OP.IN, stationCodes);
	        //HistoryRecorder.record(echIdentificationDao, ca1.add(LOP.OR, ca2), new String[]{"ID", "CREATE_ORG", "UPDATE_ORG"});

	        //更新数据
	        Parameters parameter1 = new Parameters();
	        parameter1.add("CREATE_ORG", station.getOrganCode());
	        echIdentificationDao.update(parameter1, new Criteria("CREATE_ORG", OP.IN, stationCodes));

	        Parameters parameter2 = new Parameters();
	        parameter2.add("UPDATE_ORG", station.getOrganCode());
	        echIdentificationDao.update(parameter2, new Criteria("UPDATE_ORG", OP.IN, stationCodes));
	        
	        parameter2 = new Parameters("REFERRAL_HOSPITAL_NAME", station.getOrganName());
	        childHealthExaminationDao.update(parameter2, new Criteria("REFERRAL_HOSPITAL_NAME", OP.IN, stationNames));
	        
	        parameter2 = new Parameters("INPUT_ORGAN_NAME", station.getOrganName());
	        childHealthExaminationDao.update(parameter2, new Criteria("INPUT_ORGAN_NAME", OP.IN, stationNames));
	        
	        parameter2 = new Parameters("CHECK_ORGAN_CODE", station.getOrganCode());
	        parameter2.add("CHECK_ORGAN_NAME",  station.getOrganName());
	        childHealthExaminationDao.update(parameter2, new Criteria("CHECK_ORGAN_CODE", OP.IN, stationCodes));
	        
	        parameter2 = new Parameters("CREATE_ORGAN_CODE", station.getOrganCode());
	        parameter2.add("CREATE_ORGAN_NAME",  station.getOrganName());
	        parameter2.add("CREATE_SUPER_ORGAN_CODE",  station.getParentCode());
	        parameter2.add("CREATE_GB_CODE",  station.getGbCode());
	        childHealthExaminationDao.update(parameter2, new Criteria("CREATE_ORGAN_CODE", OP.IN, stationCodes));
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
	        List<String> centerNames = new ArrayList<>();
	        for (Organization org : centerList) {
	            String centerCode = org.getOrganCode();
	            centerCodes.add(centerCode);
	            centerNames.add(org.getOrganName());
	        }
	        //备份数据
	        Criteria ca1 = new Criteria();
	        ca1.add("CREATE_ORG", OP.IN, centerCodes);
	        Criteria ca2 = new Criteria();
	        ca2.add("UPDATE_ORG", OP.IN, centerCodes);
	        //HistoryRecorder.record(echIdentificationDao, ca1.add(LOP.OR, ca2), new String[]{"ID", "CREATE_ORG", "UPDATE_ORG"});

	        //更新数据
	        Parameters parameter1 = new Parameters();
	        parameter1.add("CREATE_ORG", center.getOrganCode());
	        echIdentificationDao.update(parameter1, new Criteria("CREATE_ORG", OP.IN, centerCodes));

	        Parameters parameter2 = new Parameters();
	        parameter2.add("UPDATE_ORG", center.getOrganCode());
	        echIdentificationDao.update(parameter2, new Criteria("UPDATE_ORG", OP.IN, centerCodes));
	        
	        
	        parameter2 = new Parameters("REFERRAL_HOSPITAL_NAME", center.getOrganName());
	        childHealthExaminationDao.update(parameter2, new Criteria("REFERRAL_HOSPITAL_NAME", OP.IN, centerNames));
	        
	        parameter2 = new Parameters("INPUT_ORGAN_NAME", center.getOrganName());
	        childHealthExaminationDao.update(parameter2, new Criteria("INPUT_ORGAN_NAME", OP.IN, centerNames));
	        
	        parameter2 = new Parameters("CHECK_ORGAN_CODE", center.getOrganCode());
	        parameter2.add("CHECK_ORGAN_NAME",  center.getOrganName());
	        childHealthExaminationDao.update(parameter2, new Criteria("CHECK_ORGAN_CODE", OP.IN, centerCodes));
	        
	        parameter2 = new Parameters("CREATE_ORGAN_CODE", center.getOrganCode());
	        parameter2.add("CREATE_ORGAN_NAME",  center.getOrganName());
	        parameter2.add("CREATE_GB_CODE",  center.getGbCode());
	        childHealthExaminationDao.update(parameter2, new Criteria("CREATE_ORGAN_CODE", OP.IN, centerCodes));
	        
	        parameter2 = new Parameters("CREATE_SUPER_ORGAN_CODE",  center.getOrganCode());
	        childHealthExaminationDao.update(parameter2, new Criteria("CREATE_SUPER_ORGAN_CODE", OP.IN, centerCodes));
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
	        childHealthExaminationDao.update(new Parameters("CREATE_SUPER_ORGAN_CODE",  center.getOrganCode()), new Criteria("CREATE_ORGAN_CODE", OP.IN, stationCodes));
	    }

	    /**
	     * 机构（站）村关系变化时响应的接口 orgCode机构编码 newAddVillageCodes机构中新增加的村
	     *
	     * @param orgCode
	     * @param newAddVillageCodes
	     */
	    @Override
	    public void changeRelationOrgVillage(String orgCode, String[] newAddVillageCodes) {
	        Assert.notNull(orgCode, "HmMergerOrgListenerImpl-changeRelationOrgVillage目标机构编码为空");
	        Organization organization = organizationApp.queryOrgan(orgCode);
	        Assert.notNull(organization, "HmMergerOrgListenerImpl-changeRelationOrgVillage目标机构在系统中不存在");
	        Assert.notEmpty(newAddVillageCodes, "HmMergerOrgListenerImpl-changeRelationOrgVillage需要迁移的村编码为空");

	        childHealthExaminationDao.updateOrganByVillage(organization, newAddVillageCodes);
	    }
}