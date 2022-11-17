/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.child.ChildDeathRecord;
import com.founder.rhip.ehr.entity.child.ChildUnderThreeManage;
import com.founder.rhip.ehr.repository.child.*;
import com.founder.rhip.ehr.repository.clinic.IRpStatisticsDao;
import com.founder.rhip.ehr.repository.ihm.IChildDeathRecordDao;
import com.founder.rhip.ehr.repository.ihm.IChildManageDao;
import com.founder.rhip.ehr.repository.ihm.INewWchTargetDao;
import com.founder.rhip.ehr.repository.ihm.IWchTargetDao;
import com.founder.rhip.ehr.repository.women.*;
import com.founder.rhip.mdm.common.StatusValue;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Dictionary;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IDictionaryService;
import com.founder.rhip.mdm.service.IOrganizationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

@Service("wchTargetService")
public class WchTargetServiceImpl extends IhmService implements IWchTargetService {

	@Resource(name = "wchTargetDao")
    private IWchTargetDao wchTargetDao;

	
	@Resource(name="mdmOrganizationService")
	private IOrganizationService organizationService;


    @Resource(name = "birthCertificateDao")
    private IBirthCertificateDao birthCertificateDao; //出生医学证明表

    @Resource(name = "childHealthCardDao")
    private IChildHealthCardDao childHealthCardDao; //儿童保健卡表

    @Resource(name = "birthDefectMonitorDao")
    private IBirthDefectMonitorDao birthDefectMonitorDao;  //出生缺陷监测表

    @Resource(name = "neonatalFamilyVisitDao")
    private INeonatalFamilyVisitDao neonatalFamilyVisitDao;  //新生儿家庭访视表

    @Resource(name = "neonatalDiseaseScreenDao")
    private INeonatalDiseaseScreenDao neonatalDiseaseScreenDao;  //新生儿疾病筛查表

    @Resource(name = "childHealthExaminationDao")
    private IChildHealthExaminationDao childHealthExaminationDao;  //儿童健康体检表

    @Resource(name = "deliveryRecordInfoDao")
    private IDeliveryRecordInfoDao deliveryRecordInfoDao;  //分娩记录信息表

    @Resource(name="mdmDictionaryService")
    private IDictionaryService dictionaryService;
    
    @Resource(name = "motherhoodPeriodFollowupDao")
    private IMotherhoodPeriodFollowupDao motherhoodPeriodFollowupDao;  //孕产期保健服务与高危管理随访表

    @Resource(name = "prenatalFollowupDao")
    private IPrenatalFollowupDao prenatalFollowupDao;  //产前随访服务信息表
    
    @Resource(name = "postpartumDaysHealthInfoDao")
    private IPostpartumDaysHealthInfoDao postpartumDaysHealthInfoDao;  //产后42天健康检查信息表

    @Resource(name = "rpStatisticsDao")
    private IRpStatisticsDao rpStatisticsDao;

    @Resource(name = "childManageDao")
    private IChildManageDao childManageDao;

    @Resource(name = "newWchTargetDao")
    private INewWchTargetDao newWchTargetDao;

    @Resource(name = "childDeathRecordDao")
    private IChildDeathRecordDao childDeathRecordDao;

    @Override
    public List<Map<String, Object>> getChildCount(Map<String, String> paramMap){
        String genreCode = paramMap.get("genreCode");
        String gbCode = paramMap.get("gbCode");
        String superOrganCode = paramMap.get("superOrganCode");
        String organCode = paramMap.get("organCode");
        List<Map<String, Object>> orgList = getQueryOrgans(genreCode,gbCode,superOrganCode,organCode);

        List orgCodes = new ArrayList();
        for(Map<String, Object> org : orgList){
            orgCodes.add(org.get("ORGAN_CODE"));
        }
         List<Map<String, Object>> ageMap = childHealthCardDao.getChildCount(paramMap, orgCodes);
        if(ageMap.size() ==0){
            Map<String, Object> totalLine = new HashMap<>();
            totalLine.put("ORGAN_CODE", "合计");
            ageMap.add(totalLine);
        }

        for(Map<String, Object> ageMapLine : ageMap){
            String key = (String)ageMapLine.get("ORGAN_CODE");
            for(Map<String, Object> orgMapLine : orgList){
                if(orgMapLine.get("ORGAN_CODE").equals(key)){
                    orgMapLine.put("G1", ageMapLine.get("G1"));
                    orgMapLine.put("G2", ageMapLine.get("G2"));
                    orgMapLine.put("G3", ageMapLine.get("G3"));
                    orgMapLine.put("G4", ageMapLine.get("G4"));
                    orgMapLine.put("G5", ageMapLine.get("G5"));
                    orgMapLine.put("G6", ageMapLine.get("G6"));
                    orgMapLine.put("G7", ageMapLine.get("G7"));
                    orgMapLine.put("ORGSUM", ageMapLine.get("ORGSUM"));
                }
            }
            if("合计".equals(key)){
                orgList.add(ageMapLine);
            }
        }
        return orgList;
    }

    @Override
    public List<Map<String, Object>> getChildBaseInfo(Map<String, String> paramMap) {
          List<Map<String, Object>> resultMap = wchTargetDao.getChildBaseCount(paramMap);


        int birthCountTotal = 0;
        int defectCountTotal = 0;
        int cardCountTotal = 0;
        int healthExamCountTotal = 0;
        int childVisitCountTotal = 0;
        for(Map<String, Object> lineMap : resultMap){
            if(ObjectUtil.isNotEmpty(lineMap.get("birthCount"))){
                birthCountTotal = birthCountTotal + ((BigDecimal)lineMap.get("birthCount")).intValue();
            }
            if(ObjectUtil.isNotEmpty(lineMap.get("defectCount"))){
                defectCountTotal = defectCountTotal + ((BigDecimal)lineMap.get("defectCount")).intValue();
            }
            if(ObjectUtil.isNotEmpty(lineMap.get("cardCount"))){
                cardCountTotal = cardCountTotal + ((BigDecimal)lineMap.get("cardCount")).intValue();
            }
            if(ObjectUtil.isNotEmpty(lineMap.get("healthExamCount"))){
                healthExamCountTotal = healthExamCountTotal + ((BigDecimal)lineMap.get("healthExamCount")).intValue();
            }
            if(ObjectUtil.isNotEmpty(lineMap.get("childVisitCount"))){
                childVisitCountTotal = childVisitCountTotal + ((BigDecimal)lineMap.get("childVisitCount")).intValue();
            }
        }
        Map<String, Object> sumRow = new HashMap();
        sumRow.put("ORGAN_CODE","合计");
        sumRow.put("birthCount",birthCountTotal);
        sumRow.put("defectCount",defectCountTotal);
        sumRow.put("cardCount",cardCountTotal);
        sumRow.put("healthExamCount",healthExamCountTotal);
        sumRow.put("childVisitCount",childVisitCountTotal);
        resultMap.add(sumRow);

//        //按市级医院（一个市级医院一条数据）、按卫生院（一个卫生院一条数据）、按镇（一个镇一条数据）
//        String genreCode = paramMap.get("genreCode");
//        String gbCode = paramMap.get("gbCode");
//        String superOrganCode = paramMap.get("superOrganCode");
//        String organCode = paramMap.get("organCode");
//        List<Map<String, Object>> orgList = getQueryOrgans(genreCode,gbCode,superOrganCode,organCode);
//
//        List orgCodes = new ArrayList();
//        for(Map<String, Object> org : orgList){
//            orgCodes.add(org.get("ORGAN_CODE"));
//        }
//        Map birthCountMap = birthCertificateDao.countChildBirth(paramMap, orgCodes); //新生儿人数
//        Map defectMap = birthDefectMonitorDao.countChildDefect(paramMap, orgCodes);//出生缺陷人数
//        Map childCardMap = childHealthCardDao.countChildCard(paramMap, orgCodes);//儿童登记人数
//        Map childVisitMap = neonatalFamilyVisitDao.countChildVisit(paramMap, orgCodes);  //新生儿随访人数
//        Map healthExamMap = childHealthExaminationDao.countHealthExamination(paramMap, orgCodes);//儿童体检人次数
////        Map childDieMap = deliveryRecordInfoDao.countChildDeath(paramMap, orgCodes);//儿童死亡登记数
//
//
//        for(Map<String, Object> lineMap : orgList){
//            String key = (String)lineMap.get("ORGAN_CODE");
//            lineMap.put("birthCount", birthCountMap.get(key)==null?"0":birthCountMap.get(key));
//
//            lineMap.put("defectCount", defectMap.get(key)==null?"0":defectMap.get(key));
//
//            lineMap.put("cardCount", childCardMap.get(key)==null?"0":childCardMap.get(key));
//
//            lineMap.put("healthExamCount", healthExamMap.get(key)==null?"0":healthExamMap.get(key));
//
//            lineMap.put("childVisitCount", childVisitMap.get(key)==null?"0":childVisitMap.get(key));
//
////            lineMap.put("deathCount", childDieMap.get(key));
//        }
//        Map<String, Object> sumRow = new HashMap();
//        sumRow.put("ORGAN_CODE","合计");
//        sumRow.put("birthCount",birthCountMap.get("合计")==null?"0":birthCountMap.get("合计"));
//        sumRow.put("defectCount",defectMap.get("合计")==null?"0":defectMap.get("合计"));
//        sumRow.put("cardCount",childCardMap.get("合计")==null?"0":childCardMap.get("合计"));
//        sumRow.put("healthExamCount",healthExamMap.get("合计")==null?"0":healthExamMap.get("合计"));
//        sumRow.put("childVisitCount",childVisitMap.get("合计")==null?"0":childVisitMap.get("合计"));
//        orgList.add(sumRow);
        return resultMap;
    }

    @Override
    public List<Map<String, Object>> getChildService(Map<String, String> paramMap) {
        String genreCode = paramMap.get("genreCode");
        String gbCode = paramMap.get("gbCode");
        String superOrganCode = paramMap.get("superOrganCode");
        String organCode = paramMap.get("organCode");
        List<Map<String, Object>> orgList = getQueryOrgans(genreCode,gbCode,superOrganCode,organCode);

        Map<String, String> paramMap1 = new HashMap<>();
        paramMap1.putAll(paramMap);
        paramMap1.put("diseaseScreenItem", "1");

        Map<String, String> paramMap2 = new HashMap<>();
        paramMap2.putAll(paramMap);
        paramMap2.put("diseaseScreenItem", "2");

        List orgCodes = new ArrayList();
        for(Map<String, Object> org : orgList){
            orgCodes.add(org.get("ORGAN_CODE"));
        }
        Map childVisitMap = neonatalFamilyVisitDao.countChildVisit(paramMap, orgCodes);  //新生儿随访人次数
        Map bbtnMap = neonatalDiseaseScreenDao.countDiseaseScreen(paramMap2, orgCodes); //苯丙酮尿症筛查数
        Map thyroidMap = neonatalDiseaseScreenDao.countDiseaseScreen(paramMap1, orgCodes);//甲状腺功能减低症筛查数
        Map hearingMap = neonatalFamilyVisitDao.countHearing(paramMap, orgCodes);//听力筛查数
        Map carded3Map = childHealthExaminationDao.count3Mgnt(paramMap, orgCodes);  //3岁以下保健覆盖数
        Map carded7Map = childHealthExaminationDao.count7Mgnt(paramMap, orgCodes);//7岁以下系统管理数

        for(Map<String, Object> lineMap : orgList){
            String key = (String)lineMap.get("ORGAN_CODE");
            lineMap.put("childVisitCount", childVisitMap.get(key)==null?"0":childVisitMap.get(key));
            lineMap.put("bbtnCount", bbtnMap.get(key)==null?"0":bbtnMap.get(key));
            lineMap.put("thyroidCount", thyroidMap.get(key)==null?"0":thyroidMap.get(key));
            lineMap.put("hearingCount", hearingMap.get(key)==null?"0":hearingMap.get(key));
            lineMap.put("count3", carded3Map.get(key)==null?"0":carded3Map.get(key));
            lineMap.put("count7", carded7Map.get(key)==null?"0":carded7Map.get(key));
        }
        Map<String, Object> sumRow = new HashMap();
        sumRow.put("ORGAN_CODE","合计");
        sumRow.put("childVisitCount", childVisitMap.get("合计")==null?"0":childVisitMap.get("合计"));
        sumRow.put("bbtnCount", bbtnMap.get("合计")==null?"0":bbtnMap.get("合计"));
        sumRow.put("thyroidCount", thyroidMap.get("合计")==null?"0":thyroidMap.get("合计"));
        sumRow.put("hearingCount", hearingMap.get("合计")==null?"0":hearingMap.get("合计"));
        sumRow.put("count3", carded3Map.get("合计")==null?"0":carded3Map.get("合计"));
        sumRow.put("count7", carded7Map.get("合计")==null?"0":carded7Map.get("合计"));
        orgList.add(sumRow);
        return orgList;
    }

    @Override
    public List<Map<String, Object>> getChildNutrition(Map<String, String> paramMap) {
        String genreCode = paramMap.get("genreCode");
        String gbCode = paramMap.get("gbCode");
        String superOrganCode = paramMap.get("superOrganCode");
        String organCode = paramMap.get("organCode");
        List<Map<String, Object>> orgList = getQueryOrgans(genreCode,gbCode,superOrganCode,organCode);

        List orgCodes = new ArrayList();
        for(Map<String, Object> org : orgList){
            orgCodes.add(org.get("ORGAN_CODE"));
        }
        Map<String, String> paramMap1 = new HashMap<>();
        paramMap1.putAll(paramMap);
        paramMap1.put("weight", "Y");

        Map<String, String> paramMap2 = new HashMap<>();
        paramMap2.putAll(paramMap);
        paramMap2.put("hemoglobin", "Y");

        Map<String, String> paramMap3 = new HashMap<>();
        paramMap3.putAll(paramMap);
        paramMap3.put("evaluationresultcode", "3");



        Map weightMap = childHealthExaminationDao.countHealthExaminationByPerson(paramMap1, orgCodes); //体重检查人数
        Map weightLowMap = childHealthExaminationDao.countHealthExaminationByPerson(paramMap3, orgCodes); //体重<(中位数-2SD)的人数                                                                                       //体重<(中位数-2SD)的人数
        Map hhbMap = childHealthExaminationDao.countHealthExaminationByPerson(paramMap2, orgCodes);       //血红蛋白检查人数
        paramMap2.put("hemoglobin", "90");
        Map hhbLowMap = childHealthExaminationDao.countHealthExaminationByPerson(paramMap2, orgCodes); //中重度贫血人数                                                                               //中重度贫血人数

        for(Map<String, Object> lineMap : orgList){
            String key = (String)lineMap.get("ORGAN_CODE");
            lineMap.put("weightCheckCount", weightMap.get(key)==null?"0":weightMap.get(key));
            lineMap.put("weightCheckLowCount", weightLowMap.get(key)==null?"0":weightLowMap.get(key));
            lineMap.put("hhbCheckCount", hhbMap.get(key)==null?"0":hhbMap.get(key));
            lineMap.put("hhbCheckLowCount", hhbLowMap.get(key)==null?"0":hhbLowMap.get(key));
        }
        Map<String, Object> sumRow = new HashMap();
        sumRow.put("ORGAN_CODE","合计");
        sumRow.put("weightCheckCount",weightMap.get("合计")==null?"0":weightMap.get("合计"));
        sumRow.put("weightCheckLowCount",weightLowMap.get("合计")==null?"0":weightLowMap.get("合计"));
        sumRow.put("hhbCheckCount",hhbMap.get("合计")==null?"0":hhbMap.get("合计"));
        sumRow.put("hhbCheckLowCount",hhbLowMap.get("合计")==null?"0":hhbLowMap.get("合计"));
        orgList.add(sumRow);
        return orgList;
    }
	

	/**
	 * 获取需要统计数据的机构列表
	 *
	 * @param page
	 * @param criteria
	 * @param townFlag:获取机构列表
	 * @return
	 * @author Cary
	 */
	private List<Map<String, Object>>  getOrganizationList(Page page, Criteria criteria,boolean townFlag){
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			if(townFlag){//按镇统计
				result = getGbCodes(criteria);
			}else{//按中心统计
//				result = organizationService.getOrganizations(page, criteria,new String[]{"organCode"});//查询机构列表
                List<Organization> organizations = organizationService.getOrganizations(criteria);//查询机构列表
                for(Organization organization : organizations){
                    Map orgMap = new HashMap();
                    orgMap.put("ORGAN_CODE", organization.getOrganCode());
                    result.add(orgMap);
                }
			}			
		}
		return result;
	}

    /**
     * 获取要统计的机构
     * @param genreCode
     * @param gbCode
     * @param superOrganCode
     * @param organCode
     * @return
     */
    private List<Map<String,Object>> getQueryOrgans(String genreCode, String gbCode, String superOrganCode, String organCode){
        List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();

        if("A100".equals(genreCode)){
            Criteria criteria = new Criteria("genreCode", "A100");
            if(StringUtil.isNotEmpty(superOrganCode)){
                criteria.add("organCode", superOrganCode);
            }
            criteria.add("SUBSID","0");
            List<Organization> organizations = organizationService.getOrganizations(criteria);
            result = MapOrgans(organizations);
        }
        if("B100".equals(genreCode)){
            Criteria criteria = new Criteria("genreCode", "B100");
            if(StringUtil.isNotEmpty(gbCode)){
                criteria.add("gbCode", gbCode);
            }
            if(StringUtil.isNotEmpty(superOrganCode)){
                criteria.add("organCode", superOrganCode);
            }
            List<Organization> organizations = organizationService.getOrganizations(criteria);
            result = MapOrgans(organizations);
        }
        if("B200".equals(genreCode)){
            Criteria criteria = new Criteria("genreCode", "B200");
            if(StringUtil.isNotEmpty(gbCode)){
                criteria.add("gbCode", gbCode);
            }
            if(StringUtil.isNotEmpty(superOrganCode)){
                criteria.add("parentCode", superOrganCode);
            }
            if(StringUtil.isNotEmpty(organCode)){
                criteria.add("organCode", organCode);
            }
            List<Organization> organizations = organizationService.getOrganizations(criteria);
            result = MapOrgans(organizations);
        }if("G2".equals(genreCode)){
            Criteria criteria = new Criteria("genreCode", "G2");
            if(StringUtil.isNotEmpty(gbCode)){
                criteria.add("gbCode", gbCode);
            }
            if(StringUtil.isNotEmpty(superOrganCode)){
                criteria.add("parentCode", superOrganCode);
            }
            if(StringUtil.isNotEmpty(organCode)){
                criteria.add("organCode", organCode);
            }
            List<Organization> organizations = organizationService.getOrganizations(criteria);
            result = MapOrgans(organizations);
        }
        if("0".equals(genreCode)){
            result = getGbCodes(new Criteria("gbCode", gbCode));
        }
        return result;
    }

    private List<Map<String,Object>> MapOrgans(List<Organization> organizations){
        List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
        for(Organization organization : organizations){
            Map orgMap = new HashMap();
            orgMap.put("ORGAN_CODE", organization.getOrganCode());
            result.add(orgMap);
        }
        return result;
    }


    /**
     * 获取镇机构列表
     *
     * @param criteria
     * @return
     * @author Cary
     */
    protected List<Map<String,Object>> getGbCodes( Criteria criteria){
        List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
        Object orgCode = criteria.get("gbCode");
        Criteria dicCa = new Criteria("dic_code", "FS990001")
                .add("parent_code", EHRConstants.FS990001_ROOT)
                .add(Dictionary.STATUS, StatusValue.normalValue.getValue());
        if(ObjectUtil.isNotEmpty(orgCode)){
            dicCa.add("item_code",orgCode.toString());
        }
        List<DicItem> dicitems = dictionaryService.getDicItems(dicCa);
        if(ObjectUtil.isNotEmpty(dicitems)){
            for(DicItem dicitem:dicitems){
                Map<String,Object> org = new HashMap<String,Object>();
                org.put("ORGAN_CODE", dicitem.getItemCode());
                result.add(org);
            }
        }
        return result;
    }

    private List getQueryOrgCodes(Map<String, String> paramMap){
        String genreCode = paramMap.get("genreCode");
        String gbCode = paramMap.get("gbCode");
        String superOrganCode = paramMap.get("superOrganCode");
        String organCode = paramMap.get("organCode");
        List<Map<String, Object>> orgList = getQueryOrgans(genreCode,gbCode,superOrganCode,organCode);

        List orgCodes = new ArrayList();
        for(Map<String, Object> org : orgList){
            orgCodes.add(org.get("ORGAN_CODE"));
        }
        return orgCodes;
    }
    
    @Override
    public List<Map<String,Object>> getMotherhoodPeriodFollowupStatistics(Map<String, String> paramMap) {
        String genreCode = paramMap.get("genreCode");
        String gbCode = paramMap.get("gbCode");
        String superOrganCode = paramMap.get("superOrganCode");
        String organCode = paramMap.get("organCode");

        List<Map<String, Object>> orgList = getQueryOrgans(genreCode,gbCode,superOrganCode,organCode);

        String beginDateStr = paramMap.get("beginDate");
        String endDateStr = paramMap.get("endDate");
        Date beginDate = DateUtil.parseDateString(beginDateStr);
        Date endDate = DateUtil.parseDateString(endDateStr);
        //查孕产妇登记数
        Criteria criteria = new Criteria();
        DateUtil.getCriteriaByDateRange(criteria, "CHECK_DATE", beginDate,endDate);
        Map<String, Object> motherhoodMap = motherhoodPeriodFollowupDao.getOrganMapCount(criteria);
        //产前检查人次数
        criteria = new Criteria();
        DateUtil.getCriteriaByDateRange(criteria, "INPUT_DATE", beginDate,endDate);
        Map<String, Object> prenatalMap = prenatalFollowupDao.getOrganMapCount(criteria);
        //孕妇叶酸发放
        //TODO
        //产妇分娩数
        criteria = new Criteria();
        DateUtil.getCriteriaByDateRange(criteria, "DELIVERY_DATE", beginDate,endDate);
        Map<String, Object> deliveryMap = deliveryRecordInfoDao.getOrganMapCount(criteria);
        //产后42天健康检查
        criteria = new Criteria();
        DateUtil.getCriteriaByDateRange(criteria, "SUPERVISION_DATE", beginDate,endDate);
        Map<String, Object> postpartumMap = postpartumDaysHealthInfoDao.getOrganMapCount(criteria);
        //各种分娩方式分娩人数
        criteria = new Criteria();
        DateUtil.getCriteriaByDateRange(criteria, "DELIVERY_DATE", beginDate,endDate);
        Map<String, Object> deliveryCountMap = deliveryRecordInfoDao.getOrganMapDeliveryAndCount(criteria);
        //TODO
        int pregnantWomenRegNumSum = 0;
        int prenatalExamNumSum = 0;
        int prenatalFolicAcidReleaseSum = 0;
        int childbirthNumSum = 0;
        int days42PostPartumExamSum = 0;
        int diffWayChirdbirthNumSum = 0;
        Map<String, Object> deliveryTypes = (Map<String, Object>)deliveryCountMap.get("deliveryTypes");

        //按镇统计 
        if("0".equals(genreCode)){
            Criteria lcriteria = new Criteria();
            if(StringUtil.isNotEmpty(gbCode)){
                lcriteria.add("gbCode", gbCode);
            }
            List<Organization> organizations = organizationService.getOrganizations(lcriteria);
            //镇对镇下所有机构的映射
            Map<String,Object> townToAllOrgans = new HashMap<String,Object>();
            for(Map<String,Object> maping : orgList){
                for(Organization org : organizations){
                    String orgCode = (String)maping.get("ORGAN_CODE");
                    if(orgCode.equals(org.getGbCode())){
                        if(townToAllOrgans.containsKey(orgCode)){
                            List<String> list = (List<String>)townToAllOrgans.get(orgCode);
                            list.add(org.getOrganCode());
                        }else{
                            List<String> list = new ArrayList<String>();
                            list.add(org.getOrganCode());
                            townToAllOrgans.put(orgCode, list);
                        }
                    }
                }
            }
            orgList = new ArrayList<Map<String, Object>>();
            for(Map.Entry<String, Object> townEntry: townToAllOrgans.entrySet()){
                Integer pregnantWomenRegNumTemp = 0;
                Integer prenatalExamNumTemp = 0;
                Integer prenatalFolicAcidReleaseTemp = 0;
                Integer childbirthNumTemp = 0;
                Integer days42PostPartumExamTemp = 0;
                List<Object> diffWayChirdbirthNumTemp = null;
                Map<String,Object> lineMap = new HashMap<String,Object>();
                orgList.add(lineMap);
                lineMap.put("ORGAN_CODE", townEntry.getKey());
                List<String> organCodeList = (List<String>)townEntry.getValue();
                for(String orgCode : organCodeList){
                    pregnantWomenRegNumTemp += motherhoodMap.get(orgCode)==null?0:(Integer)motherhoodMap.get(orgCode);
                    prenatalExamNumTemp += prenatalMap.get(orgCode)==null?0:(Integer)prenatalMap.get(orgCode);
                    prenatalFolicAcidReleaseTemp += prenatalFolicAcidReleaseTemp;
                    childbirthNumTemp += deliveryMap.get(orgCode)==null?0:(Integer)deliveryMap.get(orgCode);
                    days42PostPartumExamTemp += postpartumMap.get(orgCode)==null?0:(Integer)postpartumMap.get(orgCode);
                    if(deliveryCountMap.get(orgCode) == null){
                        Map<String, Object> map = (Map<String, Object>)deliveryCountMap.get("deliveryTypes");
                        List<Object> list = new ArrayList<Object>();
                        for(Map.Entry<String, Object> entry : map.entrySet()){
                            list.add(0);
                        }
                        if(list.size() == 0) list.add(0);
                        diffWayChirdbirthNumTemp = concat(list,diffWayChirdbirthNumTemp);
                    }else{
                        Map<String, Object> map = (Map<String, Object>)deliveryCountMap.get(orgCode);
                        List<Object> list = mapValueToList(map);
                        if(list.size() == 0){
                            list.add(0);
                        }
                        diffWayChirdbirthNumTemp = concat(list,diffWayChirdbirthNumTemp);
                        for(Map.Entry<String, Object> mapEntry : map.entrySet()){
                            for(Map.Entry<String, Object> deliEntry : deliveryTypes.entrySet()){
                                if(mapEntry.getKey().equals(deliEntry.getKey())){
                                    deliEntry.setValue(((Integer)deliEntry.getValue())+(Integer)mapEntry.getValue());
                                }
                            }
                        }
                    }
                }
                lineMap.put("pregnantWomenRegNum", pregnantWomenRegNumTemp);
                lineMap.put("prenatalExamNum", prenatalExamNumTemp);
                lineMap.put("prenatalFolicAcidRelease", prenatalFolicAcidReleaseTemp);
                lineMap.put("childbirthNum", childbirthNumTemp);
                lineMap.put("days42PostPartumExam", days42PostPartumExamTemp);
                lineMap.put("diffWayChirdbirthNum", diffWayChirdbirthNumTemp);

                pregnantWomenRegNumSum += pregnantWomenRegNumTemp;
                prenatalExamNumSum += prenatalExamNumTemp;
                prenatalFolicAcidReleaseSum += prenatalFolicAcidReleaseTemp;
                childbirthNumSum += childbirthNumTemp;
                days42PostPartumExamSum += days42PostPartumExamTemp;
            }

        }else{
            //按机构统计
            for(Map<String, Object> lineMap : orgList){
                String key = (String)lineMap.get("ORGAN_CODE");
                lineMap.put("pregnantWomenRegNum", motherhoodMap.get(key)==null?0:(Integer)motherhoodMap.get(key));
                lineMap.put("prenatalExamNum", prenatalMap.get(key)==null?0:(Integer)prenatalMap.get(key));
                lineMap.put("prenatalFolicAcidRelease", 0);
                lineMap.put("childbirthNum", deliveryMap.get(key)==null?0:(Integer)deliveryMap.get(key));
                lineMap.put("days42PostPartumExam", postpartumMap.get(key)==null?0:(Integer)postpartumMap.get(key));
                if(deliveryCountMap.get(key) == null){
                    Map<String, Object> map = (Map<String, Object>)deliveryCountMap.get("deliveryTypes");
                    List<Object> list = new ArrayList<Object>();
                    for(Map.Entry<String, Object> entry : map.entrySet()){
                        list.add(0);
                    }
                    if(list.size() == 0) list.add(0);
                    lineMap.put("diffWayChirdbirthNum", list);
                }else{
                    Map<String, Object> map = (Map<String, Object>)deliveryCountMap.get(key);
                    List<Object> list = mapValueToList(map);
                    if(list.size() == 0){
                        list.add(0);
                    }
                    lineMap.put("diffWayChirdbirthNum", list);
                    for(Map.Entry<String, Object> mapEntry : map.entrySet()){
                        for(Map.Entry<String, Object> deliEntry : deliveryTypes.entrySet()){
                            if(mapEntry.getKey().equals(deliEntry.getKey())){
                                deliEntry.setValue(((Integer)deliEntry.getValue())+(Integer)mapEntry.getValue());
                            }
                        }
                    }
                }
                pregnantWomenRegNumSum += (Integer)lineMap.get("pregnantWomenRegNum");
                prenatalExamNumSum += (Integer)lineMap.get("prenatalExamNum");
                prenatalFolicAcidReleaseSum += (Integer)lineMap.get("prenatalFolicAcidRelease");
                childbirthNumSum += (Integer)lineMap.get("childbirthNum");
                days42PostPartumExamSum += (Integer)lineMap.get("days42PostPartumExam");
            }
        }

        Map<String, Object> sumRow = new HashMap<String, Object>();
        sumRow.put("ORGAN_CODE","合计");
        sumRow.put("pregnantWomenRegNum", pregnantWomenRegNumSum);
        sumRow.put("prenatalExamNum", prenatalExamNumSum);
        sumRow.put("prenatalFolicAcidRelease", prenatalFolicAcidReleaseSum);
        sumRow.put("childbirthNum", childbirthNumSum);
        sumRow.put("days42PostPartumExam", days42PostPartumExamSum);
        Map<String, Object> map = ((Map<String, Object>)deliveryCountMap.get("deliveryTypes"));
        if(map.size() == 0){
            List<Object> list = new ArrayList<Object>();
            list.add(0);
            sumRow.put("diffWayChirdbirthNum", list);
            sumRow.put("diffWayChirdbirthNumMapKey", new ArrayList<Object>());
        }else{
            sumRow.put("diffWayChirdbirthNum", mapValueToList(map));
            sumRow.put("diffWayChirdbirthNumMapKey", mapKeyToList(map));
        }
        orgList.add(sumRow);
        return orgList;
    }
    
    private List<Object> concat(List<Object> list1, List<Object> list2){
    	List<Object> list = new ArrayList<Object>();
    	for(int i=0;i<list1.size();i++){
    		if(list2 == null || list2.size() < i + 1){
    			list.add((Integer)list1.get(i));
    		}else{
    			list.add((Integer)list1.get(i)+(Integer)list2.get(i));
    		}
    	}
    	return list;
    }
    
    private List<Object> mapKeyToList(Map<String, Object> map){
  		List<Object> list = new ArrayList<Object>();
  		for(Map.Entry<String, Object> entry : map.entrySet()){
  			list.add(entry.getKey());
  		}
  		return list;
  	}
    
    private List<Object> mapValueToList(Map<String, Object> map){
		List<Object> list = new ArrayList<Object>();
		for(Map.Entry<String, Object> entry : map.entrySet()){
			list.add(entry.getValue());
		}
		return list;
	}

    /**
     * 儿童疫苗接种率
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getChildVacc(Map<String, String> paramMap){
        return rpStatisticsDao.getChildVacc(paramMap);
    }

    /**
     * 住院分娩率
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getHospitalDelivery(Map<String, String> paramMap){
        return wchTargetDao.getHospitalDelivery(paramMap);
    }


    public List<ChildUnderThreeManage> getNewChildMgnt3(String criteria, String gbCode){
        return childManageDao.getChildManageRate(criteria, gbCode);
    }


    @Override
    public List<Map<String, Object>> getNewMaternalDeath(Map<String, String> paramMap) {
        return newWchTargetDao.getMaternalDeath(paramMap);
    }

    public List<ChildDeathRecord> getChildDeathMortality(String criteria, String gbCode){
        return childDeathRecordDao.getChildDeathMortality(criteria, gbCode);
    }
}