/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.fdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.fdm.repository.IFoodBorneReportDao;
import com.founder.rhip.fdm.repository.IFoodTestDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IMergerOrganizationListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("foodMergerOrgService")
public class FoodMergerOrgListenerImpl extends AbstractService implements IMergerOrganizationListener {

    @Resource(name = "fcFoodTest")
    private IFoodTestDao foodTestDao;

    @Resource(name = "fdFoodborneReportDao")
    private IFoodBorneReportDao foodBorneReportDao;

    @Resource(name = "organizationApp")
    private IOrganizationApp organizationApp;

    /**
     * 站合并（包括同一个中心下和不同中心下）
     * @param station 合并后的站
     * @param stationList 被合并的站列表
     */
    @Override
    public void mergeStation(Organization station, List<Organization> stationList){
        for(Organization org : stationList){
            Criteria caF = new Criteria("FILL_ORGAN_CODE", org.getOrganCode());
            Parameters parameterF = new Parameters();
            parameterF.add("FILL_ORGAN_CODE", station.getOrganCode());
            parameterF.add("FILL_ORGAN_NAME", station.getOrganName());
            foodBorneReportDao.update(parameterF, caF);

            Criteria caM = new Criteria("ORGAN_CODE", org.getOrganCode());
            Parameters parameterM = new Parameters();
            parameterM.add("ORGAN_CODE", station.getOrganCode());
            parameterM.add("ORGAN_NAME", station.getOrganName());
            foodTestDao.update(parameterM, caM);
        }
    }

    /**
     * 中心合并
     * @param center  合并后的中心
     * @param centerList 被合并的中心列表
     */
    @Override
    public void mergeCenter(Organization center, List<Organization> centerList){
        for(Organization org : centerList){
            Criteria caF = new Criteria("FILL_ORGAN_CODE", org.getOrganCode());
            Parameters parametersF = new Parameters();
            parametersF.add("FILL_ORGAN_CODE", center.getOrganCode());
            parametersF.add("FILL_ORGAN_NAME", center.getOrganName());
            foodBorneReportDao.update(parametersF, caF);

            //送检医院
            caF = new Criteria("ORGAN_CODE", org.getOrganCode());
            parametersF = new Parameters();
            parametersF.add("ORGAN_CODE", center.getOrganCode());
            parametersF.add("ORGAN_NAME", center.getOrganName());
            foodTestDao.update(parametersF, caF);

        }
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