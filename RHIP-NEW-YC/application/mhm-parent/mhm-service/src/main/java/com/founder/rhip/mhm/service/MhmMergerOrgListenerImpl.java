/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.mhm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.management.mhm.MhmBasicsInfo;
import com.founder.rhip.ehr.repository.basic.HistoryRecorder;
import com.founder.rhip.ehr.repository.management.mhm.*;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IDictionaryService;
import com.founder.rhip.mdm.service.IMergerOrganizationListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("mhmMergerOrgService")
public class MhmMergerOrgListenerImpl extends AbstractService implements IMergerOrganizationListener {

    @Resource(name = "mhmOtherInfoDao")
    private IMhmOtherInfoDao mhmOtherInfoDao;

    @Resource(name = "mhmBasicsInfoDao")
    private IMhmBasicsInfoDao mhmBasicsInfoDao;

    @Resource(name = "mhmMoveDao")
    private IMhmMoveDao mhmMoveDao;

    @Resource(name = "mhmDrugUseDao")
    private IMhmDrugUseDao mhmDrugUseDao;

    @Resource(name = "mhmDiagnosisDao")
    private IMhmDiagnosisDao mhmDiagnosisDao;

    @Resource(name = "mhmApprovalInfoDao")
    private IMhmApprovalInfoDao mhmApprovalInfoDao;

    @Resource(name = "mhmPathHistoryDao")
    private IMhmPathHistoryDao mhmPathHistoryDao;

    @Resource(name = "mhmInhospitalDao")
    private IMhmInhospitalDao mhmInhospitalDao;

    @Resource(name = "mhmDrugRecordDao")
    private IMhmDrugRecordDao mhmDrugRecordDao;

    @Resource(name = "mhmFollowupDao")
    private IMhmFollowupDao mhmFollowupDao;

    @Resource(name = "mhmCaseDao")
    private IMhmCaseDao mhmCaseDao;

    @Resource(name = "mhmCaseDetailDao")
    IMhmCaseDetailDao mhmCaseDetailDao;

    @Resource(name = "mhmAssessDao")
    IMhmAssessDao mhmAssessDao;

    @Resource(name = "mhmEmergencyDao")
    IMhmEmergencyDao mhmEmergencyDao;

    @Resource(name = "mhmOutpatientRecordDao")
    IMhmOutpatientRecordDao mhmOutpatientRecordDao;

    @Resource(name = "mhmPhysicalExaminationDao")
    IMhmPhysicalExaminationDao mhmPhysicalExaminationDao;

    @Resource(name = "mhmDrugDao")
    IMhmDrugDao mhmDrugDao;

    @Resource(name = "mhmEconomyDao")
    IMhmEconomyDao mhmEconomyDao;

    @Resource(name = "mhmDrugFreeDao")
    IMhmDrugFreeDao mhmDrugFreeDao;

    @Resource(name = "mhmDrugPriceDao")
    IMhmDrugPriceDao mhmDrugPriceDao;

    @Resource(name = "mhmSeverityDao")
    IMhmSeverityDao mhmSeverityDao;

    @Resource(name = "mhmReferralRecordDao")
    IMhmReferralRecordDao mhmReferralRecordDao;

    @Resource(name = "organizationApp")
    private IOrganizationApp organizationApp;

    @Resource(name="mdmDictionaryService")
    private IDictionaryService dictionaryService;

    /**
     * 站合并（包括同一个中心下和不同中心下）
     * @param station 合并后的站
     * @param stationList 被合并的站列表
     */
    @Override
    public void mergeStation(Organization station, List<Organization> stationList){
        for(Organization org : stationList){
            Criteria caF = new Criteria("FILL_ORGAN_CODE", org.getOrganCode());
            saveHistory(caF);
            Parameters parameterF = new Parameters();
            parameterF.add("FILL_ORGAN_CODE", station.getOrganCode());
            parameterF.add("BELONG_CENTER", station.getParentCode());
            parameterF.add("BELONG_TOWNSHIP", station.getGbCode());
            mhmOtherInfoDao.update(parameterF, caF);

            Criteria caM = new Criteria("MANAGEMENT_STATION", org.getOrganCode());
            saveHistory(caM);
            Parameters parameterM = new Parameters();
            parameterM.add("MANAGEMENT_STATION", station.getOrganCode());
            parameterM.add("MANAGEMENT_CENTER", station.getParentCode());
            parameterM.add("MANAGEMENT_TOWN", station.getGbCode());
            mhmOtherInfoDao.update(parameterM, caM);

            caF = new Criteria("BASIC_MEDICAL_UNIT", org.getOrganCode());
            saveHistory(caF);
            parameterF = new Parameters();
            parameterF.add("BASIC_MEDICAL_UNIT", station.getOrganCode());
            mhmOtherInfoDao.update(parameterF, caF);

            caF = new Criteria("BASIC_MEDICAL_UNIT", org.getOrganName());
            saveHistory(caF);
            parameterF = new Parameters();
            parameterF.add("BASIC_MEDICAL_UNIT", station.getOrganName());
            mhmOtherInfoDao.update(parameterF, caF);

            caF = new Criteria("DIAGNOSIS_ORGAN_CODE", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("DIAGNOSIS_ORGAN_CODE", station.getOrganCode());
            mhmOtherInfoDao.update(parameterF, caF);

            //复核机构
            caF = new Criteria("RE_ORGAN_CODE", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("RE_ORGAN_CODE", station.getOrganCode());
            mhmOtherInfoDao.update(parameterF, caF);

            //诊断医院
            caF = new Criteria("DIAGNOSIS_HOSPITAL", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("DIAGNOSIS_HOSPITAL", station.getOrganCode());
            mhmDiagnosisDao.update(parameterF, caF);

            //审批机构
            caF = new Criteria("ORGAN_CODE", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("ORGAN_CODE", station.getOrganCode());
            parameterF.add("ORGAN_NAME", station.getOrganName());
            mhmApprovalInfoDao.update(parameterF, caF);

            //末次住院医院
            caF = new Criteria("LAST_INHOSPITAL", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("LAST_INHOSPITAL", station.getOrganCode());
            mhmPathHistoryDao.update(parameterF, caF);

            //住院医院
            caF = new Criteria("INPATIENT_ORGAN_CODE", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("INPATIENT_ORGAN_CODE", station.getOrganCode());
            mhmInhospitalDao.update(parameterF, caF);

            //转诊至机构
            caF = new Criteria("REFERRALS_TO_ORGAN", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("REFERRALS_TO_ORGAN", station.getOrganCode());
            mhmFollowupDao.update(parameterF, caF);

            //报送处置单位
            caF = new Criteria("REPORT_DISPOSE_ORGAN", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("REPORT_DISPOSE_ORGAN", station.getOrganCode());
            mhmEmergencyDao.update(parameterF, caF);

            //应急处置单位
            caF = new Criteria("EMERGEMCY_ORGAN", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("EMERGEMCY_ORGAN", station.getOrganCode());
            mhmEmergencyDao.update(parameterF, caF);

            //就诊机构
            caF = new Criteria("OUTPATIENT_ORGAN", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("OUTPATIENT_ORGAN", station.getOrganCode());
            mhmOutpatientRecordDao.update(parameterF, caF);

            //检查机构
            caF = new Criteria("EXAMINATION_ORGAN_CODE", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("EXAMINATION_ORGAN_CODE", station.getOrganCode());
            mhmPhysicalExaminationDao.update(parameterF, caF);

            //检查机构其他
            caF = new Criteria("EXAMINATION_ORGAN_OTHER", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("EXAMINATION_ORGAN_OTHER", station.getOrganCode());
            mhmPhysicalExaminationDao.update(parameterF, caF);

            //转出机构
            caF = new Criteria("REFERRAL_OUT_ORGAN", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("REFERRAL_OUT_ORGAN", station.getOrganCode());
            mhmReferralRecordDao.update(parameterF, caF);

            //转入机构
            caF = new Criteria("REFERRAL_IN_OGRAN", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("REFERRAL_IN_OGRAN", station.getOrganCode());
            mhmReferralRecordDao.update(parameterF, caF);

            //迁入迁出
            Criteria caO = new Criteria("MOVE_OUT_ORGAN", org.getOrganCode());
            HistoryRecorder.record(mhmMoveDao, caO, new String[]{"ID", "MOVE_IN_ORGAN", "MOVE_OUT_ORGAN"});
            Parameters parametersMove1 = new Parameters();
            parametersMove1.add("MOVE_OUT_ORGAN", station.getOrganCode());
            mhmMoveDao.update(parametersMove1, caO);

            Criteria caI = new Criteria("MOVE_IN_ORGAN", org.getOrganCode());
            HistoryRecorder.record(mhmMoveDao, caI, new String[]{"ID", "MOVE_IN_ORGAN", "MOVE_OUT_ORGAN"});
            Parameters parametersMove2 = new Parameters();
            parametersMove2.add("MOVE_IN_ORGAN", station.getOrganCode());
            mhmMoveDao.update(parametersMove2, caI);

//            mhmDrugUseDao
            Criteria caS = new Criteria("FILL_ORGAN_STATION", org.getOrganCode());
            HistoryRecorder.record(mhmDrugUseDao, caS, new String[]{"ID", "FILL_ORGAN_TOWN","FILL_ORGAN_CENTER", "FILL_ORGAN_STATION"});
            Parameters parametersS = new Parameters();
            parametersS.add("FILL_ORGAN_TOWN", station.getGbCode());
            parametersS.add("FILL_ORGAN_CENTER", station.getParentCode());
            parametersS.add("FILL_ORGAN_STATION", station.getOrganCode());
            mhmDrugUseDao.update(parametersS, caS);

            caS = new Criteria("MODIFY_ORGAN_STATION", org.getOrganCode());
            parametersS = new Parameters();
            parametersS.add("MODIFY_ORGAN_TOWN", station.getGbCode());
            parametersS.add("MODIFY_ORGAN_CENTER", station.getParentCode());
            parametersS.add("MODIFY_ORGAN_STATION", station.getOrganCode());
            mhmDrugUseDao.update(parametersS, caS);

            caS = new Criteria("START_ORGAN", org.getOrganCode());
            parametersS = new Parameters();
            parametersS.add("START_ORGAN", station.getOrganCode());
            mhmEconomyDao.update(parametersS, caS);
            mhmDrugFreeDao.update(parametersS, caS);
            mhmDrugPriceDao.update(parametersS, caS);
            mhmSeverityDao.update(parametersS, caS);

            caS = new Criteria("END_ORGAN", org.getOrganCode());
            parametersS = new Parameters();
            parametersS.add("END_ORGAN", station.getOrganCode());
            mhmEconomyDao.update(parametersS, caS);
            mhmDrugFreeDao.update(parametersS, caS);
            mhmDrugPriceDao.update(parametersS, caS);
            mhmSeverityDao.update(parametersS, caS);

            //填写机构
            caF = new Criteria("FILL_ORGAN_CODE", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("FILL_ORGAN_CODE", station.getOrganCode());
            mhmDrugRecordDao.update(parameterF, caF);
            mhmFollowupDao.update(parameterF, caF);
            mhmCaseDao.update(parameterF, caF);
            mhmCaseDetailDao.update(parameterF, caF);
            mhmAssessDao.update(parameterF, caF);
            mhmEmergencyDao.update(parameterF, caF);
            mhmPhysicalExaminationDao.update(parameterF, caF);
            mhmDrugDao.update(parameterF, caF);

            //修改机构
            caF = new Criteria("MODIFY_ORGAN_CODE", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("MODIFY_ORGAN_CODE", station.getOrganCode());
            mhmOtherInfoDao.update(parameterF, caF);
            mhmDrugRecordDao.update(parameterF, caF);
            mhmFollowupDao.update(parameterF, caF);
            mhmCaseDao.update(parameterF, caF);
            mhmCaseDetailDao.update(parameterF, caF);
            mhmAssessDao.update(parameterF, caF);
            mhmEmergencyDao.update(parameterF, caF);
            mhmPhysicalExaminationDao.update(parameterF, caF);
            mhmDrugDao.update(parameterF, caF);
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

            Criteria caB = new Criteria("BELONG_CENTER", org.getOrganCode());
            saveHistory(caB);
            Parameters parametersB = new Parameters();
            parametersB.add("BELONG_CENTER", center.getOrganCode());
            parametersB.add("BELONG_TOWNSHIP", center.getGbCode());
            mhmOtherInfoDao.update(parametersB, caB);

            Criteria caM = new Criteria("MANAGEMENT_CENTER", org.getOrganCode());
            saveHistory(caM);
            Parameters parametersM = new Parameters();
            parametersM.add("MANAGEMENT_CENTER", center.getOrganCode());
            parametersM.add("MANAGEMENT_TOWN", center.getGbCode());
            mhmOtherInfoDao.update(parametersM, caM);

            Criteria caF = new Criteria("FILL_ORGAN_CODE", org.getOrganCode());
            saveHistory(caF);
            Parameters parametersF = new Parameters();
            parametersF.add("FILL_ORGAN_CODE", center.getOrganCode());
            mhmOtherInfoDao.update(parametersF, caF);

            caF = new Criteria("MODIFY_ORGAN_CODE", org.getOrganCode());
            saveHistory(caF);
            parametersF = new Parameters();
            parametersF.add("MODIFY_ORGAN_CODE", center.getOrganCode());
            mhmOtherInfoDao.update(parametersF, caF);

            caF = new Criteria("BASIC_MEDICAL_UNIT", org.getOrganCode());
            parametersF = new Parameters();
            parametersF.add("BASIC_MEDICAL_UNIT", center.getOrganCode());
            mhmOtherInfoDao.update(parametersF, caF);

            caF = new Criteria("DIAGNOSIS_ORGAN_CODE", org.getOrganCode());
            saveHistory(caF);
            parametersF = new Parameters();
            parametersF.add("DIAGNOSIS_ORGAN_CODE", center.getOrganCode());
            mhmOtherInfoDao.update(parametersF, caF);

            caF = new Criteria("RE_ORGAN_CODE", org.getOrganCode());
            saveHistory(caF);
            parametersF = new Parameters();
            parametersF.add("RE_ORGAN_CODE", center.getOrganCode());
            mhmOtherInfoDao.update(parametersF, caF);

            //诊断医院
            caF = new Criteria("DIAGNOSIS_HOSPITAL", org.getOrganCode());
            Parameters parameterF = new Parameters();
            parameterF.add("DIAGNOSIS_HOSPITAL", center.getOrganCode());
            mhmDiagnosisDao.update(parameterF, caF);

            //审批机构
            caF = new Criteria("ORGAN_CODE", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("ORGAN_CODE", center.getOrganCode());
            parameterF.add("ORGAN_NAME", center.getOrganName());
            mhmApprovalInfoDao.update(parameterF, caF);

            //末次住院医院
            caF = new Criteria("LAST_INHOSPITAL", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("LAST_INHOSPITAL", center.getOrganCode());
            mhmPathHistoryDao.update(parameterF, caF);

            //住院医院
            caF = new Criteria("INPATIENT_ORGAN_CODE", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("INPATIENT_ORGAN_CODE", center.getOrganCode());
            mhmInhospitalDao.update(parameterF, caF);

            //转诊至机构
            caF = new Criteria("REFERRALS_TO_ORGAN", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("REFERRALS_TO_ORGAN", center.getOrganCode());
            mhmFollowupDao.update(parameterF, caF);

            //报送处置单位
            caF = new Criteria("REPORT_DISPOSE_ORGAN", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("REPORT_DISPOSE_ORGAN", center.getOrganCode());
            mhmEmergencyDao.update(parameterF, caF);

            //应急处置单位
            caF = new Criteria("EMERGEMCY_ORGAN", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("EMERGEMCY_ORGAN", center.getOrganCode());
            mhmEmergencyDao.update(parameterF, caF);

            //就诊机构
            caF = new Criteria("OUTPATIENT_ORGAN", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("OUTPATIENT_ORGAN", center.getOrganCode());
            mhmOutpatientRecordDao.update(parameterF, caF);

            //检查机构
            caF = new Criteria("EXAMINATION_ORGAN_CODE", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("EXAMINATION_ORGAN_CODE", center.getOrganCode());
            mhmPhysicalExaminationDao.update(parameterF, caF);

            //检查机构其他
            caF = new Criteria("EXAMINATION_ORGAN_OTHER", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("EXAMINATION_ORGAN_OTHER", center.getOrganCode());
            mhmPhysicalExaminationDao.update(parameterF, caF);

            //转出机构
            caF = new Criteria("REFERRAL_OUT_ORGAN", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("REFERRAL_OUT_ORGAN", center.getOrganCode());
            mhmReferralRecordDao.update(parameterF, caF);

            //转入机构
            caF = new Criteria("REFERRAL_IN_OGRAN", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("REFERRAL_IN_OGRAN", center.getOrganCode());
            mhmReferralRecordDao.update(parameterF, caF);

            //mhmDrugUseDao
            Criteria caS = new Criteria("FILL_ORGAN_CENTER", org.getOrganCode());
            HistoryRecorder.record(mhmDrugUseDao, caS, new String[]{"ID", "FILL_ORGAN_TOWN","FILL_ORGAN_CENTER"});
            Parameters parametersS = new Parameters();
            parametersS.add("FILL_ORGAN_TOWN", center.getGbCode());
            parametersS.add("FILL_ORGAN_CENTER", center.getOrganCode());
            mhmDrugUseDao.update(parametersS, caS);

            caS = new Criteria("MODIFY_ORGAN_CENTER", org.getOrganCode());
            parametersS = new Parameters();
            parametersS.add("MODIFY_ORGAN_TOWN", center.getGbCode());
            parametersS.add("MODIFY_ORGAN_CENTER", center.getOrganCode());
            mhmDrugUseDao.update(parametersS, caS);

            //迁入迁出
            Criteria caO = new Criteria("MOVE_OUT_ORGAN", org.getOrganCode());
            HistoryRecorder.record(mhmMoveDao, caO, new String[]{"ID", "MOVE_IN_ORGAN", "MOVE_OUT_ORGAN"});
            Parameters parametersMove1 = new Parameters();
            parametersMove1.add("MOVE_OUT_ORGAN", center.getOrganCode());
            mhmMoveDao.update(parametersMove1, caO);

            Criteria caI = new Criteria("MOVE_IN_ORGAN", org.getOrganCode());
            HistoryRecorder.record(mhmMoveDao, caI, new String[]{"ID", "MOVE_IN_ORGAN", "MOVE_OUT_ORGAN"});
            Parameters parametersMove2 = new Parameters();
            parametersMove2.add("MOVE_IN_ORGAN", center.getOrganCode());
            mhmMoveDao.update(parametersMove2, caI);

            caS = new Criteria("START_ORGAN", org.getOrganCode());
            parametersS = new Parameters();
            parametersS.add("START_ORGAN", center.getOrganCode());
            mhmEconomyDao.update(parametersS, caS);
            mhmDrugFreeDao.update(parametersS, caS);
            mhmDrugPriceDao.update(parametersS, caS);
            mhmSeverityDao.update(parametersS, caS);

            caS = new Criteria("END_ORGAN", org.getOrganCode());
            parametersS = new Parameters();
            parametersS.add("END_ORGAN", center.getOrganCode());
            mhmEconomyDao.update(parametersS, caS);
            mhmDrugFreeDao.update(parametersS, caS);
            mhmDrugPriceDao.update(parametersS, caS);
            mhmSeverityDao.update(parametersS, caS);

            //填写机构
            caF = new Criteria("FILL_ORGAN_CODE", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("FILL_ORGAN_CODE", center.getOrganCode());
            mhmDrugRecordDao.update(parameterF, caF);
            mhmFollowupDao.update(parameterF, caF);
            mhmCaseDao.update(parameterF, caF);
            mhmCaseDetailDao.update(parameterF, caF);
            mhmAssessDao.update(parameterF, caF);
            mhmEmergencyDao.update(parameterF, caF);
            mhmPhysicalExaminationDao.update(parameterF, caF);
            mhmDrugDao.update(parameterF, caF);

            //修改机构
            caF = new Criteria("MODIFY_ORGAN_CODE", org.getOrganCode());
            parameterF = new Parameters();
            parameterF.add("MODIFY_ORGAN_CODE", center.getOrganCode());
            mhmDrugRecordDao.update(parameterF, caF);
            mhmFollowupDao.update(parameterF, caF);
            mhmCaseDao.update(parameterF, caF);
            mhmCaseDetailDao.update(parameterF, caF);
            mhmAssessDao.update(parameterF, caF);
            mhmEmergencyDao.update(parameterF, caF);
            mhmPhysicalExaminationDao.update(parameterF, caF);
            mhmDrugDao.update(parameterF, caF);

        }
    }

    /**
     * 站转移
     * @param center 转移后的中心
     * @param stationList 被转移的站列表
     */
    @Override
    public void moveStation(Organization center, List<Organization> stationList){
        for(Organization org : stationList){
            Criteria caB = new Criteria("FILL_ORGAN_CODE", org.getOrganCode());
            saveHistory(caB);

            Parameters parametersB = new Parameters();
            parametersB.add("BELONG_CENTER", center.getOrganCode());
            parametersB.add("BELONG_TOWNSHIP", center.getGbCode());
            mhmOtherInfoDao.update(parametersB, caB);

            Criteria caM = new Criteria("MANAGEMENT_STATION", org.getOrganCode());
            saveHistory(caM);
            Parameters parametersM = new Parameters();
            parametersM.add("MANAGEMENT_CENTER", center.getOrganCode());
            parametersM.add("MANAGEMENT_TOWN", center.getGbCode());
            mhmOtherInfoDao.update(parametersM, caM);

            Criteria caS = new Criteria("FILL_ORGAN_STATION", org.getOrganCode());
            Parameters parametersS = new Parameters();
            parametersS.add("FILL_ORGAN_TOWN", center.getGbCode());
            parametersS.add("FILL_ORGAN_CENTER", center.getOrganCode());
            mhmDrugUseDao.update(parametersS, caS);

            caS = new Criteria("MODIFY_ORGAN_STATION", org.getOrganCode());
            parametersS = new Parameters();
            parametersS.add("MODIFY_ORGAN_TOWN", center.getGbCode());
            parametersS.add("MODIFY_ORGAN_CENTER", center.getOrganCode());
            mhmDrugUseDao.update(parametersS, caS);
        }
    }

    /**
     * 机构（站）村关系变化时响应的接口 orgCode机构编码 newAddVillageCodes机构中新增加的村
     * @param orgCode
     * @param newAddVillageCodes
     */
    @Override
    public void changeRelationOrgVillage(String orgCode, String[] newAddVillageCodes) {
        Assert.notNull(orgCode, "目标机构编码为空");
        Organization organization = organizationApp.queryOrgan(orgCode);
        Assert.notNull(organization, "目标机构在系统中不存在");
        Assert.notEmpty(newAddVillageCodes, "需要迁移的村编码为空");
        Criteria criteria = new Criteria("PASTREET", OP.IN, newAddVillageCodes);
        // 更新相关机构
        List<MhmBasicsInfo> list = mhmBasicsInfoDao.getList(criteria, new String[]{"ID","EVENT_ID"});
        if(ObjectUtil.isNotEmpty(list)){
            List idList = new ArrayList();
            for(MhmBasicsInfo basicsInfo : list){
                if(!ObjectUtil.isNullOrEmpty(basicsInfo.getEventId())) {
                    idList.add(basicsInfo.getEventId());
                }
            }
            Criteria caOther = new Criteria("EVENT_ID", OP.IN, idList);
            saveHistory(caOther);
            Parameters parametersOther = new Parameters();
            parametersOther.add("FILL_ORGAN_CODE", orgCode);
            parametersOther.add("BELONG_CENTER", organization.getParentCode());
            parametersOther.add("BELONG_TOWNSHIP", organization.getGbCode());
            parametersOther.add("MANAGEMENT_STATION", orgCode);
            parametersOther.add("MANAGEMENT_CENTER", organization.getParentCode());
            parametersOther.add("MANAGEMENT_TOWN", organization.getGbCode());
            mhmOtherInfoDao.update(parametersOther, caOther);
        }

        // 更新现住址
        HistoryRecorder.record(MhmBasicsInfo.class, mhmBasicsInfoDao, criteria, new String[] { "ID", "PATOWN_SHIP", "PASTREET"});
        Parameters param = new Parameters("PATOWN_SHIP", organization.getGbCode());
        for(String oldCode : newAddVillageCodes){
            String oldTownName = "";
            String newTownName = "";
            DicItem dicItemOld = dictionaryService.getDicItem("FS990001", oldCode);
            DicItem dicItemNew = dictionaryService.getDicItem("FS990001", oldCode);
//            String oldTownName = organizationApp.queryOrganName(oldCode);
//            String newTownName = organizationApp.queryOrganName(newTownCode);
            if(ObjectUtil.isNotEmpty(dicItemOld)){
                oldTownName = dicItemOld.getItemName();
            }
            if(ObjectUtil.isNotEmpty(dicItemNew)){
                newTownName = dicItemNew.getItemName();
            }

            if(StringUtil.isNotEmpty(oldTownName) && StringUtil.isNotEmpty(newTownName)){
                mhmBasicsInfoDao.updatePaAddress2(oldCode, oldTownName, newTownName);
            }
        }
        mhmBasicsInfoDao.update(param, criteria);

    }

    private void saveHistory(Criteria criteria){
        HistoryRecorder.record(mhmOtherInfoDao, criteria, new String[]{"ID", "FILL_ORGAN_CODE", "FILL_DOCTOR_ID", "FILL_DATE", "MODIFY_ORGAN_CODE", "MODIFY_DOCTOR_ID", "MODIFY_DATE",
                "DIAGNOSIS_ORGAN_CODE", "DIAGNOSIS_DOCTOR_ID", "DIAGNOSIS_DATE", "RE_ORGAN_CODE", "RE_DOCTOR_ID", "RE_DATE", "MANAGEMENT_CENTER", "MANAGEMENT_TOWN",
                "MANAGEMENT_STATION", "BRING_INTO_DATE"});
    }
}