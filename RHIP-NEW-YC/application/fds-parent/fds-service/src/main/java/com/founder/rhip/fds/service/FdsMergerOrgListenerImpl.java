/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.fds.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.repository.fds.IFdsDao;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IDictionaryService;
import com.founder.rhip.mdm.service.IMergerOrganizationListener;
import com.founder.rhip.mdm.service.IMergerTownListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("fdsMergerOrgService")
public class FdsMergerOrgListenerImpl extends AbstractService implements IMergerTownListener, IMergerOrganizationListener {

    @Resource(name = "fdsDao")
    IFdsDao fdsDao;

    @Resource(name="mdmDictionaryService")
    private IDictionaryService dictionaryService;

    /**
     * 站合并（包括同一个中心下和不同中心下）
     *
     * @param station     合并后的站
     * @param stationList 被合并的站列表
     */
    @Override
    @Transactional
    public void mergeStation(Organization station, List<Organization> stationList) {
        for(Organization org : stationList){
            Criteria caM = new Criteria("ORGAN_CODE", org.getOrganCode());
            Parameters parameterM = new Parameters();
            parameterM.add("ORGAN_CODE", station.getOrganCode());
            fdsDao.updateOrganCode("DOCTOR", "ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("TEAM", "ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("TEAM_MEMBER", "ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("TEAM_ACTIVITY", "ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("HEALTH_EDUCATION", "ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("SIGN", "ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("SIGN_PERSON", "ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("SIGN_MODIFY_TRACE", "ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("SERVICE_PLAN", "ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("SERVICE_RECORD", "ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("SIGN_LOG", "ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("USER_ROLE", "ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("TEAM_COOPERATION", "INVITE_ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("QUESTION", "SUBMITOR_ORG", parameterM, caM);
            fdsDao.updateOrganCode("QUESTION", "ANSWER_ORG", parameterM, caM);
            fdsDao.updateOrganCode("USER_OPERATION_LOG", "ORG_CODE", parameterM, caM);
            fdsDao.updateOrganCode("NOTICE", "PUBLISH_ORGAN_CODE", parameterM, caM);

            caM = new Criteria("INPUT_ORGAN_CODE", org.getOrganCode());
            parameterM = new Parameters();
            parameterM.add("INPUT_ORGAN_CODE", station.getOrganCode());
            parameterM.add("INPUT_ORGAN_NAME", station.getOrganName());
            fdsDao.updateInputOrgan(parameterM, caM);

            caM = new Criteria("ORGAN_CODE", org.getOrganCode());
            parameterM = new Parameters();
            parameterM.add("ORGAN_CODE", station.getOrganCode());
            parameterM.add("GB_CODE", station.getGbCode());
            fdsDao.updateGbOrgan(parameterM, caM);

        }
    }

    /**
     * 中心合并
     *
     * @param center     合并后的中心
     * @param centerList 被合并的中心列表
     */
    @Override
    public void mergeCenter(Organization center, List<Organization> centerList) {
        for(Organization org : centerList){
            Criteria caM = new Criteria("ORGAN_CODE", org.getOrganCode());
            Parameters parameterM = new Parameters();
            parameterM.add("ORGAN_CODE", center.getOrganCode());
            fdsDao.updateOrganCode("DOCTOR", "ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("TEAM", "ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("TEAM_MEMBER", "ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("TEAM_ACTIVITY", "ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("HEALTH_EDUCATION", "ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("SIGN", "ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("SIGN_PERSON", "ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("SIGN_MODIFY_TRACE", "ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("SERVICE_PLAN", "ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("SERVICE_RECORD", "ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("SIGN_LOG", "ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("USER_ROLE", "ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("TEAM_COOPERATION", "INVITE_ORGAN_CODE", parameterM, caM);
            fdsDao.updateOrganCode("QUESTION", "SUBMITOR_ORG", parameterM, caM);
            fdsDao.updateOrganCode("QUESTION", "ANSWER_ORG", parameterM, caM);
            fdsDao.updateOrganCode("USER_OPERATION_LOG", "ORG_CODE", parameterM, caM);
            fdsDao.updateOrganCode("NOTICE", "PUBLISH_ORGAN_CODE", parameterM, caM);

            caM = new Criteria("INPUT_ORGAN_CODE", org.getOrganCode());
            parameterM = new Parameters();
            parameterM.add("INPUT_ORGAN_CODE", center.getOrganCode());
            parameterM.add("INPUT_ORGAN_NAME", center.getOrganName());
            fdsDao.updateInputOrgan(parameterM, caM);

            caM = new Criteria("ORGAN_CODE", org.getOrganCode());
            parameterM = new Parameters();
            parameterM.add("ORGAN_CODE", center.getOrganCode());
            parameterM.add("GB_CODE", center.getGbCode());
            fdsDao.updateGbOrgan(parameterM, caM);
        }
    }

    /**
     * 站转移
     *
     * @param center      转移后的中心
     * @param stationList 被转移的站列表
     */
    @Override
    public void moveStation(Organization center, List<Organization> stationList) {
        if (ObjectUtil.isNotEmpty(stationList)) {
            checkNewOrganization(center);
            for (Organization organization : stationList) {
                // 更新条件
                Criteria criteria = new Criteria("ORGAN_CODE", organization.getOrganCode());
                // 更新字段,站边和站名
                Parameters parameters = new Parameters("GB_CODE", center.getGbCode());// 所在镇,直接取GbCode因为迁移针只对站
                fdsDao.updateGbCode(parameters, criteria);
            }
        }
    }

    private void checkNewOrganization(Organization organization) {
        Assert.notNull(organization, "目标机构为空");
    }

    /**
     * 机构（站）村关系变化时响应的接口 orgCode机构编码 newAddVillageCodes机构中新增加的村
     *
     * @param orgCode
     * @param newAddVillageCodes
     */
    @Override
    public void changeRelationOrgVillage(String orgCode, String[] newAddVillageCodes) {
    }

    /**
     * 乡镇合并
     * @param newTownCode 合并后的乡镇编码
     * @param oldTownCode 被合并的乡镇编码
     */
    @Override
    public void mergeTown(String newTownCode, String[] oldTownCode) {
        Criteria caB = new Criteria("PATOWN_SHIP", OP.IN, oldTownCode);
        Parameters parametersBt = new Parameters();
        parametersBt.add("PATOWN_SHIP", newTownCode);
        //个人签约
        fdsDao.updateTownShip("SIGN_PERSON", parametersBt, oldTownCode);
        //家庭签约
        fdsDao.updateTownShip("SIGN_FAMILY", parametersBt, oldTownCode);
    }

    /**
     * 镇村关系变化时响应的接口 townCode镇编码 newAddVillageCodes镇中新增加的村
     * @param townCode
     * @param newAddVillageCodes
     */
    @Override
    public void sendTownVillageRelation(String townCode, String[] newAddVillageCodes) {
        Assert.notNull(townCode, "目标机构编码为空");
        Assert.notEmpty(newAddVillageCodes, "需要迁移的村编码为空");
        // 更新现住址镇
        Criteria criteria = new Criteria("PASTREET", OP.IN, newAddVillageCodes);
        Parameters parameters = new Parameters("PATOWN_SHIP", townCode);
        fdsDao.updateTownShipByStreet("SIGN_PERSON", parameters, newAddVillageCodes);
        fdsDao.updateTownShipByStreet("SIGN_FAMILY", parameters, newAddVillageCodes);

        for(String villageCode : newAddVillageCodes){
            DicItem dicItemTown = dictionaryService.getDicItem("FS990001", townCode);
            DicItem dicItemVillage = dictionaryService.getDicItem("FS990001", villageCode);
            String townName = dicItemTown.getItemName();
            String villageName = dicItemVillage.getItemName();
            if(StringUtil.isNotEmpty(townName) && StringUtil.isNotEmpty(villageName)){
                fdsDao.updatePaAddress("SIGN_PERSON", villageCode, townName, villageName);
                fdsDao.updatePaAddress("SIGN_FAMILY", villageCode, townName, villageName);
            }
        }
    }
}