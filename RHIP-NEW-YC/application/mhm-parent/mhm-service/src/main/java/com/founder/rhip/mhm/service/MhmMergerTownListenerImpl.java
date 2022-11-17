/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.mhm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.management.mhm.MhmBasicsInfo;
import com.founder.rhip.ehr.repository.basic.HistoryRecorder;
import com.founder.rhip.ehr.repository.management.mhm.IMhmBasicsInfoDao;
import com.founder.rhip.ehr.repository.management.mhm.IMhmDrugUseDao;
import com.founder.rhip.ehr.repository.management.mhm.IMhmOtherInfoDao;
import com.founder.rhip.ehr.repository.management.mhm.IMhmPhysicalExaminationDao;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.service.IDictionaryService;
import com.founder.rhip.mdm.service.IMergerTownListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("mhmMergerTownService")
public class MhmMergerTownListenerImpl extends AbstractService implements IMergerTownListener {

    @Resource(name = "mhmOtherInfoDao")
    private IMhmOtherInfoDao mhmOtherInfoDao;

    @Resource(name="mdmDictionaryService")
    private IDictionaryService dictionaryService;


    @Resource(name = "mhmBasicsInfoDao")
    private IMhmBasicsInfoDao mhmBasicsInfoDao;     //基本信息

    @Resource(name = "dictionaryApp")
    private IDictionaryApp dictionaryApp;

    @Resource(name = "mhmDrugUseDao")
    private IMhmDrugUseDao mhmDrugUseDao;

    @Resource(name = "mhmPhysicalExaminationDao")
    IMhmPhysicalExaminationDao mhmPhysicalExaminationDao;

    /**
     * 乡镇合并
     * @param newTownCode 合并后的乡镇编码
     * @param oldTownCode 被合并的乡镇编码
     */
    @Override
    public void mergeTown(String newTownCode, String[] oldTownCode) {

        Criteria caB = new Criteria("BELONG_TOWNSHIP", OP.IN, oldTownCode);
        saveHistory(caB);
        Parameters parametersBt = new Parameters();
        parametersBt.add("BELONG_TOWNSHIP", newTownCode);
        mhmOtherInfoDao.update(parametersBt, new Criteria("BELONG_TOWNSHIP", caB));

        Criteria caM = new Criteria("MANAGEMENT_TOWN", OP.IN, oldTownCode);
        saveHistory(caM);
        Parameters parametersMt = new Parameters();
        parametersMt.add("MANAGEMENT_TOWN", newTownCode);
        mhmOtherInfoDao.update(parametersMt, caM);

        Criteria caPa = new Criteria("PATOWN_SHIP", OP.IN, oldTownCode);
        Criteria caHr = new Criteria("HRTOWN_SHIP", OP.IN, oldTownCode);
        caPa.add(LOP.OR, caHr);
        Criteria caOr = new Criteria();
        HistoryRecorder.record(mhmBasicsInfoDao, caOr.add(caPa), new String[]{"ID", "PATOWN_SHIP", "PASTREET", "HRTOWN_SHIP", "HRSTREET"});

        Parameters paTownShip = new Parameters();
        paTownShip.add("PATOWN_SHIP", newTownCode);
        mhmBasicsInfoDao.update(paTownShip,  new Criteria("PATOWN_SHIP", OP.IN, oldTownCode));

        Parameters hrTownShip = new Parameters();
        hrTownShip.add("HRTOWN_SHIP", newTownCode);
        mhmBasicsInfoDao.update(hrTownShip,  new Criteria("HRTOWN_SHIP", OP.IN, oldTownCode));

        Parameters townShip = new Parameters();
        townShip.add("PA_GBCODE", newTownCode);
        mhmBasicsInfoDao.update(townShip,  new Criteria("PA_GBCODE", OP.IN, oldTownCode));

        townShip = new Parameters();
        townShip.add("HR_GBCODE", newTownCode);
        mhmBasicsInfoDao.update(townShip,  new Criteria("HR_GBCODE", OP.IN, oldTownCode));

        townShip = new Parameters();
        townShip.add("FILL_ORGAN_TOWN", newTownCode);
        mhmDrugUseDao.update(townShip,  new Criteria("FILL_ORGAN_TOWN", OP.IN, oldTownCode));

        townShip = new Parameters();
        townShip.add("MODIFY_ORGAN_TOWN", newTownCode);
        mhmDrugUseDao.update(townShip,  new Criteria("MODIFY_ORGAN_TOWN", OP.IN, oldTownCode));

        townShip = new Parameters();
        townShip.add("PATOWN_SHIP", newTownCode);
        mhmPhysicalExaminationDao.update(townShip,  new Criteria("PATOWN_SHIP", OP.IN, oldTownCode));

        //更新完整现住址
//        for(String oldCode : oldTownCode){
//            String oldTownName = "";
//            String newTownName = "";
//            DicItem dicItemOld = dictionaryService.getDicItem("FS990001", oldCode);
//            DicItem dicItemNew = dictionaryService.getDicItem("FS990001", newTownCode);
////            String oldTownName = organizationApp.queryOrganName(oldCode);
////            String newTownName = organizationApp.queryOrganName(newTownCode);
//            if(ObjectUtil.isNotEmpty(dicItemOld)){
//                oldTownName = dicItemOld.getItemName();
//            }
//            if(ObjectUtil.isNotEmpty(dicItemNew)){
//                newTownName = dicItemNew.getItemName();
//            }
//            if(StringUtil.isNotEmpty(oldTownName) && StringUtil.isNotEmpty(newTownName)){
//                mhmBasicsInfoDao.updatePaAddress(oldCode, oldTownName, newTownName);
//            }
//        }
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
        Criteria caPa = new Criteria("pastreet", OP.IN, newAddVillageCodes);
        Criteria caHr = new Criteria("hrstreet", OP.IN, newAddVillageCodes);
        caPa.add(LOP.OR, caHr);
        Criteria crOr = new Criteria();
        HistoryRecorder.record(MhmBasicsInfo.class, mhmBasicsInfoDao, crOr.add(caPa), new String[]{"id","PATOWN_SHIP", "PASTREET", "HRTOWN_SHIP", "HRSTREET"});

        Parameters paramPa = new Parameters("PATOWN_SHIP", townCode);
        mhmBasicsInfoDao.update(paramPa, new Criteria("pastreet", OP.IN, newAddVillageCodes));
        mhmPhysicalExaminationDao.update(paramPa, new Criteria("pastreet", OP.IN, newAddVillageCodes));

        Parameters paramHr = new Parameters("HRTOWN_SHIP", townCode);
        mhmBasicsInfoDao.update(paramHr, new Criteria("hrstreet", OP.IN, newAddVillageCodes));


        for(String villageCode : newAddVillageCodes){
            DicItem dicItemTown = dictionaryService.getDicItem("FS990001", townCode);
            DicItem dicItemVillage = dictionaryService.getDicItem("FS990001", villageCode);
            String townName = dicItemTown.getItemName();
            String villageName = dicItemVillage.getItemName();
            if(StringUtil.isNotEmpty(townName) && StringUtil.isNotEmpty(villageName)){
                mhmBasicsInfoDao.updatePaAddress2(villageCode, townName, villageName);
            }
        }
	}

    private void saveHistory(Criteria criteria){
        HistoryRecorder.record(mhmOtherInfoDao, criteria, new String[]{"ID", "FILL_ORGAN_CODE", "FILL_DOCTOR_ID", "FILL_DATE", "MODIFY_ORGAN_CODE", "MODIFY_DOCTOR_ID", "MODIFY_DATE",
                "DIAGNOSIS_ORGAN_CODE", "DIAGNOSIS_DOCTOR_ID", "DIAGNOSIS_DATE", "RE_ORGAN_CODE", "RE_DOCTOR_ID", "RE_DATE", "MANAGEMENT_CENTER", "MANAGEMENT_TOWN",
                "MANAGEMENT_STATION", "BRING_INTO_DATE"});
    }
}