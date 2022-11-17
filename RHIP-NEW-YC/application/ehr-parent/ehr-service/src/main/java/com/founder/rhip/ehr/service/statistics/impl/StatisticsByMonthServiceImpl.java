package com.founder.rhip.ehr.service.statistics.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.StatisticsByMonth;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.basic.IStatisticsByMonthDao;
import com.founder.rhip.ehr.service.statistics.IPublicHealthDmStatisticsService;
import com.founder.rhip.ehr.service.statistics.IStatisticsByMonthService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;

@Service("statisticsByMonthService")
@TaskBean(cron="0 00 23 * * ?",description="公卫月报统计")
public class StatisticsByMonthServiceImpl extends AbstractService implements IStatisticsByMonthService,Task {
    
     @Resource(name = "organizationApp")
     private IOrganizationApp organizationApp;
    
     @Autowired
     private IPersonInfoDao personInfoDao;
    
     @Autowired
     private IDictionaryApp dictionaryApp;
    
     @Autowired
     private IStatisticsByMonthDao statisticsByMonthDao;
     
     @Autowired(required = false)
     private IPublicHealthDmStatisticsService publicHealthDmStatisticsService;
     
 	@Override
 	public List<StatisticsByMonth> getStatisticsByMonth(Criteria criteria) {
 		List<StatisticsByMonth> statisticsByMonths = statisticsByMonthDao.getList(criteria);
 		return statisticsByMonths;
 	}
     
     @Override
    // @Scheduled(cron = "0 00 23 * * ?")
     public void setStatisticsByMonth() {
    	 Criteria cr1 = new Criteria();
    	 int searchYear = DateUtil.getBirthYearByAge(EHRConstants.SIXTY_FIVE_ELDER);
    	 Date searchDate = DateUtil.getDateByYearMonthDay(searchYear,11,31);
         
         Calendar cal = Calendar.getInstance();
         cal.set(Calendar.YEAR, DateUtil.getCurrentYear() - 1);
         Date lastYear = cal.getTime();
         
         cr1.add("BIRTHDAY",OP.LE,searchDate);
         cr1.add("FILING_FLAG",OP.NE, EHRConstants.UN_CREATE);
         cr1.add("HOUSEHOLD_TYPE", EHRConstants.HOUSE_HOLDER);
         List<Map<String,Object>> sixFiveMaps = personInfoDao.getPersonCount(cr1);//65岁以上老人(户籍)
         Map<String, Long> sixFiveMap = this.covertToMap(sixFiveMaps);
         
//         Criteria cri1 = cr1;
//         cri1.remove("FILING_FLAG");
//         cri1.remove("BIRTHDAY");
//         List<Map<String,Object>> totalWithUCMaps = personInfoDao.getPersonCount(cri1); //所有档案，包括已注销(户籍)
         
         Criteria c1 = cr1;
         c1.remove("BIRTHDAY");
         Map<String ,Long> totalTownMap = this.covertToMap(personInfoDao.getPersonCount(c1));//所有档案(户籍)
         
         Criteria lastYearCr1 = new Criteria();
         lastYearCr1.add("inputDate", lastYear);
         lastYearCr1.add("householdType", EHRConstants.HOUSE_HOLDER);
         Map<String, Long> changedRecordMap  =  this.covertToMap(personInfoDao.getChangedCountTown(lastYearCr1));//一年内改变(户籍)
         
         Criteria cr2 = new Criteria();
         cr2.add("BIRTHDAY",OP.LE,searchDate);
         cr2.add("FILING_FLAG", OP.NE, EHRConstants.UN_CREATE);
         cr2.add("HOUSEHOLD_TYPE", EHRConstants.UN_HOUSE_HOLDER);
         Map<String, Long> sixFiveUnHousesMap = this.covertToMap(personInfoDao.getPersonCount(cr2));//65岁以上老人(非户籍)
         
//         Criteria cri2 = cr2;
//         cri2.remove("FILING_FLAG");
//         cri2.remove("BIRTHDAY");
//         List<Map<String,Object>> totalWithUCMapUnHouses = personInfoDao.getPersonCount(cri2); //所有档案，包括已注销(非户籍)
         
         Criteria c2 = cr2;
         c2.remove("BIRTHDAY");
         Map<String,Long> totalUnHTownMap = this.covertToMap(personInfoDao.getPersonCount(c2));//所有档案(非户籍)
         
         Criteria lastYearCr2 = new Criteria();
         lastYearCr2.add("inputDate", lastYear);
         lastYearCr2.add("householdType", EHRConstants.UN_HOUSE_HOLDER);
         Map<String, Long> changedRecordUnHousesMap = this.covertToMap(personInfoDao.getChangedCountTown(lastYearCr2));//一年内改变(非户籍)
         
         Criteria cr6 = new Criteria();
         cr6.add("BIRTHDAY",OP.LE,searchDate);
         cr6.add("FILING_FLAG", OP.NE, EHRConstants.UN_CREATE);
         Map<String, Long> sixFiveUnHousesAllMap = this.covertToMap(personInfoDao.getPersonCount(cr6));//65岁以上老人(全部)
         
//         Criteria cri6 = cr6;
//         cri6.remove("FILING_FLAG");
//         cri6.remove("BIRTHDAY");
//         List<Map<String,Object>> totalWithUCMapUnHousesAll = personInfoDao.getPersonCount(cri6); //所有档案，包括已注销(全部)
         
         Criteria c6 = cr6;
         c6.remove("BIRTHDAY");
         Map<String, Long> totalUnHsTownAllMap = this.covertToMap(personInfoDao.getPersonCount(c6));//所有档案(全部)
         
         Criteria lastYearCr6 = new Criteria();
         lastYearCr6.add("inputDate", lastYear);
         Map<String, Long> changedRecordUnHousesAllMap = this.covertToMap(personInfoDao.getChangedCountTown(lastYearCr6));//一年内改变(全部)
         
         Map<String, Long> hBPCountHHMap = publicHealthDmStatisticsService.getHBPCount(EHRConstants.HOUSE_HOLDER); //高血压患者（户籍）
         Map<String, Long> newHBPCountHHMap = publicHealthDmStatisticsService.getNewHBPCount(EHRConstants.HOUSE_HOLDER);//新增高血压患者（户籍）
         Map<String, Long> curedHBPCountHHMap = publicHealthDmStatisticsService.getCuredHBPCount(EHRConstants.HOUSE_HOLDER);//治愈的高血压患者（户籍）
         
         Map<String, Long> hBPCountUHMap = publicHealthDmStatisticsService.getHBPCount(EHRConstants.UN_HOUSE_HOLDER); //高血压患者（非户籍）
         Map<String, Long> newHBPCountUHMap = publicHealthDmStatisticsService.getNewHBPCount(EHRConstants.UN_HOUSE_HOLDER);//新增高血压患者（非户籍）
         Map<String, Long> curedHBPCountUHMap = publicHealthDmStatisticsService.getCuredHBPCount(EHRConstants.UN_HOUSE_HOLDER);//治愈的高血压患者（非户籍）
         
         Map<String, Long> hBPCountAllMap = publicHealthDmStatisticsService.getHBPCount(null); //高血压患者（全部）
         Map<String, Long> newHBPCountAllMap = publicHealthDmStatisticsService.getNewHBPCount(null);//新增高血压患者（全部）
         Map<String, Long> curedHBPCountAllMap = publicHealthDmStatisticsService.getCuredHBPCount(null);//治愈的高血压患者（全部）
         
         Map<String, Long> dITypeTwoCountHHMap = publicHealthDmStatisticsService.getHBPCount(EHRConstants.HOUSE_HOLDER); //糖尿病患者（户籍）
         Map<String, Long> newDITypeTwoCountHHMap = publicHealthDmStatisticsService.getNewHBPCount(EHRConstants.HOUSE_HOLDER);//新增糖尿病患者（户籍）
         Map<String, Long> curedDITypeTwoCountHHMap = publicHealthDmStatisticsService.getCuredHBPCount(EHRConstants.HOUSE_HOLDER);//治愈的糖尿病患者（户籍）
         
         Map<String, Long> dITypeTwoCountUHMap = publicHealthDmStatisticsService.getDITypeTwoCount(EHRConstants.UN_HOUSE_HOLDER); //糖尿病患者（非户籍）
         Map<String, Long> newDITypeTwoCountUHMap = publicHealthDmStatisticsService.getNewDITypeTwoCount(EHRConstants.UN_HOUSE_HOLDER);//新增糖尿病患者（非户籍）
         Map<String, Long> curedDITypeTwoCountUHMap = publicHealthDmStatisticsService.getCuredDITypeTwoCount(EHRConstants.UN_HOUSE_HOLDER);//治愈的糖尿病患者（非户籍）
         
         Map<String, Long> dITypeTwoCountAllMap = publicHealthDmStatisticsService.getDITypeTwoCount(null); //糖尿病患者（全部）
         Map<String, Long> newDITypeTwoCountAllMap = publicHealthDmStatisticsService.getNewDITypeTwoCount(null);//新增糖尿病患者（全部）
         Map<String, Long> curedDITypeTwoCountAllMap = publicHealthDmStatisticsService.getCuredDITypeTwoCount(null);//治愈的糖尿病患者（全部）
         
         Map<String, Long> hBPTownCountHHMap = publicHealthDmStatisticsService.getTownHBPCount(EHRConstants.HOUSE_HOLDER); //高血压患者（户籍、镇）
         Map<String, Long> newTownHBPCountHHMap = publicHealthDmStatisticsService.getTownNewHBPCount(EHRConstants.HOUSE_HOLDER);//新增高血压患者（户籍、镇）
         Map<String, Long> curedTownHBPCountHHMap = publicHealthDmStatisticsService.getTownCuredHBPCount(EHRConstants.HOUSE_HOLDER);//治愈的高血压患者（户籍、镇）
         
         Map<String, Long> hBPTownCountUHMap = publicHealthDmStatisticsService.getTownHBPCount(EHRConstants.UN_HOUSE_HOLDER); //高血压患者（非户籍、镇）
         Map<String, Long> newTownHBPCountUHMap = publicHealthDmStatisticsService.getTownNewHBPCount(EHRConstants.UN_HOUSE_HOLDER);//新增高血压患者（非户籍、镇）
         Map<String, Long> curedTownHBPCountUHMap = publicHealthDmStatisticsService.getTownCuredHBPCount(EHRConstants.UN_HOUSE_HOLDER);//治愈的高血压患者（非户籍、镇）
         
         Map<String, Long> hBPTownCountAllMap = publicHealthDmStatisticsService.getTownHBPCount(null); //高血压患者（全部、镇）
         Map<String, Long> newTownHBPCountAllMap = publicHealthDmStatisticsService.getTownNewHBPCount(null);//新增高血压患者（全部、镇）
         Map<String, Long> curedTownHBPCountAllMap = publicHealthDmStatisticsService.getTownCuredHBPCount(null);//治愈的高血压患者（全部、镇）
         
         Map<String, Long> dITypeTwoTownCountHHMap = publicHealthDmStatisticsService.getTownDITypeTwoCount(EHRConstants.HOUSE_HOLDER); //糖尿病患者（户籍、镇）
         Map<String, Long> newDITypeTwoTownCountHHMap = publicHealthDmStatisticsService.getTownDITypeTwoCount(EHRConstants.HOUSE_HOLDER);//新增糖尿病患者（户籍、镇）
         Map<String, Long> curedDITypeTwoTownCountHHMap = publicHealthDmStatisticsService.getTownCuredDITypeTwoCount(EHRConstants.HOUSE_HOLDER);//治愈的糖尿病患者（户籍、镇）
         
         Map<String, Long> dITypeTwoTownCountUHMap = publicHealthDmStatisticsService.getTownDITypeTwoCount(EHRConstants.UN_HOUSE_HOLDER); //糖尿病患者（非户籍、镇）
         Map<String, Long> newDITypeTwoTownCountUHMap = publicHealthDmStatisticsService.getTownNewDITypeTwoCount(EHRConstants.UN_HOUSE_HOLDER);//新增糖尿病患者（非户籍、镇）
         Map<String, Long> curedDITypeTwoTownCountUHMap = publicHealthDmStatisticsService.getTownCuredDITypeTwoCount(EHRConstants.UN_HOUSE_HOLDER);//治愈的糖尿病患者（非户籍、镇）
         
         Map<String, Long> dITypeTwoTownCountAllMap = publicHealthDmStatisticsService.getTownDITypeTwoCount(null); //糖尿病患者（全部、镇）
         Map<String, Long> newDITypeTwoTownCountAllMap = publicHealthDmStatisticsService.getTownNewDITypeTwoCount(null);//新增糖尿病患者（全部、镇）
         Map<String, Long> curedDITypeTwoTownCountAllMap = publicHealthDmStatisticsService.getTownCuredDITypeTwoCount(null);//治愈的糖尿病患者（全部、镇）
         
         List<Organization> organizations = new ArrayList<Organization>();
         List<StatisticsByMonth> statisticsByMonths = new ArrayList<StatisticsByMonth>();
         Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
         List<DicItem> items = dictionaryApp.queryDicItem(criteria);
         for (DicItem dicItem : items) {
        	StatisticsByMonth statisticsByMonthAll = this.getStatisticsByMonthTown(EHRConstants.NO_HOUSE_HOLDER_TYPE, dicItem, sixFiveUnHousesAllMap, 
        			changedRecordUnHousesAllMap, totalUnHsTownAllMap,hBPTownCountAllMap,newTownHBPCountAllMap,curedTownHBPCountAllMap,
        			dITypeTwoTownCountAllMap,newDITypeTwoTownCountAllMap,curedDITypeTwoTownCountAllMap);
        	statisticsByMonths.add(statisticsByMonthAll);
        	if(ObjectUtil.isNotEmpty(EHRConstants.HOUSE_HOLDER)){
         		StatisticsByMonth statisticsByMonth = this.getStatisticsByMonthTown(EHRConstants.HOUSE_HOLDER, dicItem,sixFiveMap, changedRecordMap, 
     				totalTownMap,hBPTownCountHHMap,newTownHBPCountHHMap,curedTownHBPCountHHMap,
     				dITypeTwoTownCountHHMap,newDITypeTwoTownCountHHMap,curedDITypeTwoTownCountHHMap);
	     		statisticsByMonths.add(statisticsByMonth);
	     	}
	     	if(ObjectUtil.isNotEmpty(EHRConstants.UN_HOUSE_HOLDER)){
	     		StatisticsByMonth statisticsByMonth = this.getStatisticsByMonthTown(EHRConstants.UN_HOUSE_HOLDER, dicItem,sixFiveUnHousesMap, 
	     				changedRecordUnHousesMap, totalUnHTownMap,hBPTownCountUHMap,newTownHBPCountUHMap,curedTownHBPCountUHMap,
	     				dITypeTwoTownCountUHMap,newDITypeTwoTownCountUHMap,curedDITypeTwoTownCountUHMap);
	     		statisticsByMonths.add(statisticsByMonth);
	     	}
	     	List<Organization> orgs = this.getOrgByGBCode(dicItem.getItemCode());
	     	organizations.addAll(orgs);
         }
         
         Criteria cr3 = new Criteria();
         cr3.add("BIRTHDAY",OP.LE,searchDate);
         cr3.add("FILING_FLAG", OP.NE, EHRConstants.UN_CREATE);
         cr3.add("HOUSEHOLD_TYPE", EHRConstants.HOUSE_HOLDER);
         Map<String, Long> sixFiveHusMap = this.covertToMap(personInfoDao.getPersonCountStation(cr3));//65岁以上老人（户籍）
         
//         Criteria cri3 = cr3;
//         cri3.remove("FILING_FLAG");
//         cri3.remove("BIRTHDAY");
//         List<Map<String,Object>> totalWithUCMapHus = personInfoDao.getPersonCountStation(cri3); //所有档案，包括已注销（户籍）
         
         Criteria c3 = cr3;
         c3.remove("BIRTHDAY");
         Map<String, Long> totalHusMap = this.covertToMap(personInfoDao.getPersonCountStation(c3));//所有档案（户籍）
         
         Criteria lastYearCr3 = new Criteria();
         lastYearCr3.add("inputDate", lastYear);
         lastYearCr3.add("householdType", EHRConstants.HOUSE_HOLDER);
         Map<String, Long> changedRecordHusMap = this.covertToMap(personInfoDao.getChangedCount(lastYearCr3));//一年内改变（户籍）
         
         Criteria cr4 = new Criteria();
         cr4.add("BIRTHDAY",OP.LE,searchDate);
         cr4.add("FILING_FLAG", OP.NE, EHRConstants.UN_CREATE);
         cr4.add("HOUSEHOLD_TYPE", EHRConstants.UN_HOUSE_HOLDER);
         Map<String, Long> sixFiveUnHsMap = this.covertToMap(personInfoDao.getPersonCountStation(cr4));//65岁以上老人（非户籍）
         
//         Criteria cri4 = cr4;
//         cri4.remove("FILING_FLAG");
//         cri4.remove("BIRTHDAY");
//         List<Map<String,Object>> totalWithUCMapUnHs = personInfoDao.getPersonCountStation(cri4); //所有档案，包括已注销（非户籍）
         
         Criteria c4 = cr4;
         c4.remove("BIRTHDAY");
         Map<String, Long> totalUnHsMap = this.covertToMap(personInfoDao.getPersonCountStation(c4));//所有档案（非户籍）
         
         Criteria lastYearCr4 = new Criteria();
         lastYearCr4.add("inputDate", lastYear);
         lastYearCr4.add("householdType", EHRConstants.HOUSE_HOLDER);
         Map<String, Long> changedRecordUnHsMap = this.covertToMap(personInfoDao.getChangedCount(lastYearCr3));//一年内改变（非户籍）
         
         Criteria cr5 = new Criteria();
         cr5.add("BIRTHDAY",OP.LE,searchDate);
         cr5.add("FILING_FLAG", OP.NE, EHRConstants.UN_CREATE);
         Map<String, Long> sixFiveUnHsAllMap = this.covertToMap(personInfoDao.getPersonCountStation(cr5));//65岁以上老人(全部)
         
//         Criteria cri5 = cr5;
//         cri5.remove("FILING_FLAG");
//         cri5.remove("BIRTHDAY");
//         List<Map<String,Object>> totalWithUCMapUnHsAll = personInfoDao.getPersonCountStation(cri5); //所有档案，包括已注销(全部)
         
         Criteria c5 = cr5;
         c5.remove("BIRTHDAY");
         Map<String, Long> totalUnHsAllMap = this.covertToMap(personInfoDao.getPersonCountStation(c5));//所有档案(全部)
         
         Criteria lastYearCr5 = new Criteria();
         lastYearCr5.add("inputDate", lastYear);
         Map<String, Long> changedRecordHsAllMap = this.covertToMap(personInfoDao.getChangedCount(lastYearCr5));//一年内改变(全部)
         
         for (Organization org : organizations) {
        	StatisticsByMonth statisticsByMonthAll = this.getStatisticsByMonthStation(EHRConstants.NO_HOUSE_HOLDER_TYPE, org, sixFiveUnHsAllMap,
        			changedRecordHsAllMap, totalUnHsAllMap, hBPCountAllMap,newHBPCountAllMap,curedHBPCountAllMap,
        			dITypeTwoCountAllMap,newDITypeTwoCountAllMap,curedDITypeTwoCountAllMap);
        	statisticsByMonths.add(statisticsByMonthAll);
            if(ObjectUtil.isNotEmpty(EHRConstants.HOUSE_HOLDER)){
            	StatisticsByMonth statisticsByMonth = this.getStatisticsByMonthStation(EHRConstants.HOUSE_HOLDER,org,sixFiveHusMap, changedRecordHusMap, 
            			totalHusMap, hBPCountHHMap,newHBPCountHHMap,curedHBPCountHHMap,
            			dITypeTwoCountHHMap,newDITypeTwoCountHHMap,curedDITypeTwoCountHHMap);
 	     		statisticsByMonths.add(statisticsByMonth);
 	     	}
 	     	if(ObjectUtil.isNotEmpty(EHRConstants.UN_HOUSE_HOLDER)){
 	     		StatisticsByMonth statisticsByMonth = this.getStatisticsByMonthStation(EHRConstants.UN_HOUSE_HOLDER,org,sixFiveUnHsMap, changedRecordUnHsMap, 
 	     				totalUnHsMap, hBPCountUHMap,newHBPCountUHMap,curedHBPCountUHMap,
 	     				dITypeTwoCountUHMap,newDITypeTwoCountUHMap,curedDITypeTwoCountUHMap);
	     		statisticsByMonths.add(statisticsByMonth);
 	     	}
         }
         statisticsByMonthDao.batchInsert(statisticsByMonths);
     }
     
     /**
      * 设置镇的月报信息
      * @param houseHoldType
      * @param dicItem
      * @return
      */
     private StatisticsByMonth getStatisticsByMonthTown(String houseHoldType, DicItem dicItem,Map<String,Long> sixFiveMap,Map<String,Long> changedRecordMap, 
    		 Map<String,Long> totalMap, Map<String, Long> hpbMap, Map<String, Long> newHpbMap, Map<String, Long> curedHBPMap,
    		 Map<String, Long> dITypeTwoMap,Map<String, Long> newDITypeTwoMap,Map<String, Long> curedDITypeTwoMap){
    	 StatisticsByMonth statisticsByMonth = new StatisticsByMonth();
    	 statisticsByMonth.setOrganName(dicItem.getItemName());
    	 statisticsByMonth.setOrganCode(dicItem.getItemCode());
    	 statisticsByMonth.setOrganType(EHRConstants.TOWN);
    	 statisticsByMonth.setHouseholdtype(houseHoldType);
    	 statisticsByMonth.setRecordDate(new Date());
    	 statisticsByMonth.setSixtyFiveElder((long)0);
    	 statisticsByMonth.setTotalRecord((long)0);
    	 statisticsByMonth.setChangedRecord((long)0);
    	 statisticsByMonth.setUnchangedRecord((long)0);
    	 statisticsByMonth.setHypertension((long)0);
    	 statisticsByMonth.setNewHypertension((long)0);
    	 statisticsByMonth.setCuredHypertension((long)0);
    	 statisticsByMonth.setTypeTwoDiabetes((long)0);
    	 statisticsByMonth.setNewTypeTwoDiabetes((long)0);
    	 statisticsByMonth.setCuredTypeTwoDiabetes((long)0);
    	 String organCode = dicItem.getItemCode();
    	 if(ObjectUtil.isNotEmpty(sixFiveMap.get(organCode))){
    		 statisticsByMonth.setSixtyFiveElder(Long.parseLong(sixFiveMap.get(organCode).toString()));
    	 }
         //档案跟新数
    	 if(ObjectUtil.isNotEmpty(changedRecordMap.get(organCode)) && ObjectUtil.isNotEmpty(totalMap.get(organCode))){
             statisticsByMonth.setChangedRecord(Long.parseLong(changedRecordMap.get(organCode).toString()));
    		 statisticsByMonth.setUnchangedRecord(Long.parseLong(totalMap.get(organCode).toString()) - Long.parseLong(changedRecordMap.get(organCode).toString()));
    	 }else if(ObjectUtil.isNotEmpty(changedRecordMap.get(organCode)) && ObjectUtil.isNullOrEmpty((totalMap.get(organCode)))){
    		 statisticsByMonth.setUnchangedRecord(Long.parseLong(totalMap.get(organCode).toString()));
    	 }
    	 if(ObjectUtil.isNotEmpty(hpbMap.get(organCode))){
    		 statisticsByMonth.setHypertension(Long.parseLong(hpbMap.get(organCode).toString()));
    	 }
    	 if(ObjectUtil.isNotEmpty(newHpbMap.get(organCode))){
    		 statisticsByMonth.setNewHypertension(Long.parseLong(newHpbMap.get(organCode).toString()));
    	 }
    	 if(ObjectUtil.isNotEmpty(curedHBPMap.get(organCode))){
    		 statisticsByMonth.setCuredHypertension(Long.parseLong(curedHBPMap.get(organCode).toString()));
    	 }
    	 if(ObjectUtil.isNotEmpty(dITypeTwoMap.get(organCode))){
    		 statisticsByMonth.setTypeTwoDiabetes(Long.parseLong(dITypeTwoMap.get(organCode).toString()));
    	 }
    	 if(ObjectUtil.isNotEmpty(newDITypeTwoMap.get(organCode))){
    		 statisticsByMonth.setNewTypeTwoDiabetes(Long.parseLong(newDITypeTwoMap.get(organCode).toString()));
    	 }
    	 if(ObjectUtil.isNotEmpty(curedDITypeTwoMap.get(organCode))){
    		 statisticsByMonth.setCuredTypeTwoDiabetes(Long.parseLong(curedDITypeTwoMap.get(organCode).toString()));
    	 }

         return statisticsByMonth;
     }
     
     /**
      * 设置站的月报信息
      * @param houseHoldType
      * @param org
      * @return
      */
     private StatisticsByMonth getStatisticsByMonthStation(String houseHoldType, Organization org ,Map<String,Long> sixFiveMap, Map<String,Long> changedRecordMap, 
    		 Map<String,Long> totalMap, Map<String, Long> hpbMap, Map<String, Long> newHpbMap, Map<String, Long> curedHBPMap,
    		 Map<String, Long> dITypeTwoMap,Map<String, Long> newDITypeTwoMap,Map<String, Long> curedDITypeTwoMap){
    	 StatisticsByMonth statisticsByMonth = new StatisticsByMonth();
    	 statisticsByMonth.setOrganName(org.getOrganName());
    	 statisticsByMonth.setOrganCode(org.getOrganCode());
    	 statisticsByMonth.setOrganType(EHRConstants.STATION);
    	 statisticsByMonth.setHouseholdtype(houseHoldType);
		 statisticsByMonth.setRecordDate(new Date());
    	 statisticsByMonth.setSixtyFiveElder((long)0);
    	 statisticsByMonth.setTotalRecord((long)0);
    	 statisticsByMonth.setChangedRecord((long)0);
    	 statisticsByMonth.setUnchangedRecord((long)0);
    	 statisticsByMonth.setHypertension((long)0);
    	 statisticsByMonth.setNewHypertension((long)0);
    	 statisticsByMonth.setCuredHypertension((long)0);
    	 statisticsByMonth.setTypeTwoDiabetes((long)0);
    	 statisticsByMonth.setNewTypeTwoDiabetes((long)0);
    	 statisticsByMonth.setCuredTypeTwoDiabetes((long)0);
    	 String organCode = org.getOrganCode();
    	 if(ObjectUtil.isNotEmpty(sixFiveMap.get(organCode))){
    		 statisticsByMonth.setSixtyFiveElder(Long.parseLong(sixFiveMap.get(organCode).toString()));
    	 }
    	 if(ObjectUtil.isNotEmpty(changedRecordMap.get(organCode)) && ObjectUtil.isNotEmpty(totalMap.get(organCode))){
    		 statisticsByMonth.setChangedRecord(Long.parseLong(changedRecordMap.get(organCode).toString()));
    		 statisticsByMonth.setUnchangedRecord(Long.parseLong(totalMap.get(organCode).toString()) - Long.parseLong(changedRecordMap.get(organCode).toString()));
    	 }else if(ObjectUtil.isNotEmpty(totalMap.get(organCode)) && ObjectUtil.isNullOrEmpty((changedRecordMap.get(organCode)))){
    		 statisticsByMonth.setUnchangedRecord(Long.parseLong(totalMap.get(organCode).toString()));
    	 }
    	 if(ObjectUtil.isNotEmpty(hpbMap.get(organCode))){
    		 statisticsByMonth.setHypertension(Long.parseLong(hpbMap.get(organCode).toString()));
    	 }
    	 if(ObjectUtil.isNotEmpty(newHpbMap.get(organCode))){
    		 statisticsByMonth.setNewHypertension(Long.parseLong(newHpbMap.get(organCode).toString()));
    	 }
    	 if(ObjectUtil.isNotEmpty(curedHBPMap.get(organCode))){
    		 statisticsByMonth.setCuredHypertension(Long.parseLong(curedHBPMap.get(organCode).toString()));
    	 }
    	 if(ObjectUtil.isNotEmpty(dITypeTwoMap.get(organCode))){
    		 statisticsByMonth.setTypeTwoDiabetes(Long.parseLong(dITypeTwoMap.get(organCode).toString()));
    	 }
    	 if(ObjectUtil.isNotEmpty(newDITypeTwoMap.get(organCode))){
    		 statisticsByMonth.setNewTypeTwoDiabetes(Long.parseLong(newDITypeTwoMap.get(organCode).toString()));
    	 }
    	 if(ObjectUtil.isNotEmpty(curedDITypeTwoMap.get(organCode))){
    		 statisticsByMonth.setCuredTypeTwoDiabetes(Long.parseLong(curedDITypeTwoMap.get(organCode).toString()));
    	 }

         return statisticsByMonth;
     }
     
     private Map<String, Long> covertToMap(List<Map<String, Object>> listMap){
    	 Map<String ,Long> map = new HashMap<String ,Long>();
    	 for(Map<String ,Object> m : listMap){
    		 if(ObjectUtil.isNullOrEmpty(m.get("ORGAN_CODE"))){
    			 continue;
    		 }
    		 map.put(getString(m,"ORGAN_CODE"),getLong(m, "COUNT"));
    	 }
    	 return map;
     }
     /**
 	 * 根据GBCODE得到镇下面所有站
 	 * @param gbCode
 	 * @return
 	 */
 	private List<Organization> getOrgByGBCode(String gbCode){
 		List<Organization> organizationListThree = new ArrayList<Organization>();
 		Criteria criteria = new Criteria("gbCode",gbCode);
 		List<Organization> organizationList = organizationApp.queryOrganization(criteria); //镇下面的站
 		if(!ObjectUtil.isNullOrEmpty(organizationList)){
 			List<String> centerCodes = new ArrayList<String>();
 			for (Organization organization : organizationList) {
 				centerCodes.add(organization.getOrganCode());
 			}
			criteria = new Criteria();
			criteria.add(Organization.PARENT_CODE, OP.IN, centerCodes);
			organizationListThree = organizationApp.queryOrganization(criteria); //服务站
 		}
 		return organizationListThree;
 	}

	private Long getLong(Map<String, Object> map, String key) {
		Object val = map.get(key);
		if (null == val) {
			return 0L;
		}
		return Long.parseLong(val.toString());
	}

	private String getString(Map<String, Object> map, String key) {
		Object val = map.get(key);
		if (null == val) {
			return "";
		}
		return val.toString();
	}

	@Override
	public void run(Map<String, Object> data) {
	     setStatisticsByMonth();
	}
}