package com.founder.rhip.cdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.Populace;
import com.founder.rhip.ehr.entity.management.CdmsStatisticsInfo;
import com.founder.rhip.ehr.repository.basic.IPopulaceDao;
import com.founder.rhip.ehr.repository.management.IDmPopulaceInfoDao;
import com.founder.rhip.ehr.repository.statistics.ICdmsStatisticsDao;
import com.founder.rhip.ehr.service.statistics.IIdmStatisticsService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

@Service("cdmStatisticsService")
public class CdmStatisticsReportService extends AbstractService implements ICdmStatisticsReportService, IIdmStatisticsService {
	@Resource
	private ICdmsStatisticsDao cdmsStatisticsDao;
	@Resource
	private IDictionaryApp dictionaryApp;

	@Resource
	private IPopulaceDao populaceDao;

	@Override
	public List<CdmsStatisticsInfo> getCdmsStatisticsList(Criteria criteria) {
		List<CdmsStatisticsInfo> cdmsStatisticsList=new ArrayList<CdmsStatisticsInfo>();
		//获取镇
		List<DicItem> townList = dictionaryApp.queryDicItem(new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT));
		//获取辖区人口数，获取辖区病人估计数
        Object yearParam= criteria.get("createDate");
        int year;
        if (ObjectUtil.isNotEmpty(yearParam)){
            year = Integer.valueOf(String.valueOf(yearParam));
        }else {
			year = DateUtil.getCurrentYear();
        }
		//List<DmPopulaceInfo> populaceList = dmPopulaceInfoDao.getList(new Criteria("COUNT_YEAR",year));
		//List<Populace> populaceList = populaceDao.getList(new Criteria("COUNT_YEAR",year));
		//B1：卫生院  0 ：镇
		List<Populace> populaceList = populaceDao.getTarget("", "", year, "0");
		Map<String,CdmsStatisticsInfo> mapCdmsStatistics = new HashMap<>();
		if(!ObjectUtil.isNullOrEmpty(townList) && !ObjectUtil.isNullOrEmpty(populaceList)){
			for(DicItem dicItem :townList){
				//new 统计实体并且赋初始值
				CdmsStatisticsInfo cdmsStatistics = new CdmsStatisticsInfo();
				setEntity(cdmsStatistics);
				for(Populace populace : populaceList){
					if(dicItem.getItemCode().equals(populace.getOrganCode())){
						cdmsStatistics.setCreateUnitCode(populace.getOrganCode());
						cdmsStatistics.setCreateUnitName(dicItem.getItemName());
						Integer householdNum = ObjectUtil.isNotEmpty(populace.getHouseholdNum()) ? populace.getHouseholdNum() : 0;
						Integer unHouseholdNum = ObjectUtil.isNotEmpty(populace.getUnHouseHoldNum()) ? populace.getUnHouseHoldNum() : 0;
						Integer totalNum = householdNum + unHouseholdNum;

                        if (null != totalNum){
							cdmsStatistics.setDistrictPopulation(totalNum.longValue());
                            cdmsStatistics.setAppraisePopulation(new Double(Math.floor(totalNum * EHRConstants.CDM_PATIENT_RATE)).longValue());
                        }
						cdmsStatisticsList.add(cdmsStatistics);
						break;
					}
				}
				mapCdmsStatistics.put(cdmsStatistics.getCreateUnitCode(), cdmsStatistics);
			}
		
		//获取慢病总人数
		//获取已管理慢性病人数
		int count=0;
		List<Map<String, Object>> managePopulationList = cdmsStatisticsDao.getCdmsStatisticList(criteria);
		if(!ObjectUtil.isNullOrEmpty(managePopulationList)){
				for (Map<String, Object> map : managePopulationList) {
					if(mapCdmsStatistics.containsKey(getString(map, "CREATE_GBCODE"))){
						CdmsStatisticsInfo toWitch = mapCdmsStatistics.get(getString(map, "CREATE_GBCODE"));
						//设置慢病以管理人数和规范化管理人数
						switch(getLong(map,"TOORDER").intValue()){
							case 1:
								toWitch.setManageHbpPopulation(getLong(map,"COUNT"));
								break;
							case 2:
								toWitch.setManageDiPopulation(getLong(map,"COUNT"));
								break;
							case 3:
								toWitch.setManageCancerPopulation(getLong(map,"COUNT"));
								break;
							case 5:
								toWitch.setManageStrokePopulation(getLong(map,"COUNT"));
								break;
							case 4:
								toWitch.setManageCoronaryPopulation(getLong(map,"COUNT"));
								break;
							case 6:
								toWitch.setStandardizationHbpPopulation(getLong(map,"COUNT"));
								break;
							case 7:
								toWitch.setStandardizationDiPopulation(getLong(map,"COUNT"));
								break;
							case 8:
								toWitch.setStandardizationCancerPopulation(getLong(map,"COUNT"));
								break;
							case 10:
								toWitch.setStandardizationStrokePopulation(getLong(map,"COUNT"));
								break;
							case 9:
								toWitch.setStandardizationCoronaryPopulation(getLong(map,"COUNT"));
								break;
							case 11:
								toWitch.setCdmManageTotal(getLong(map,"COUNT"));
								break;
							case 12:
								toWitch.setBloodToStandard(getLong(map,"COUNT"));
								break;
							case 13:
								toWitch.setBloodSugerToStandard(getLong(map,"COUNT"));
					}
					
				  }
				}

                //增加合计
				CdmsStatisticsInfo total = new CdmsStatisticsInfo();
				setEntity(total);
				total.setCreateUnitName("合计");
				for (CdmsStatisticsInfo to : cdmsStatisticsList) {
					total.add(to);
				}
                 cdmsStatisticsList.add(total);
				for(CdmsStatisticsInfo to:cdmsStatisticsList){
					//规范化管理率
					if(to.getManageHbpPopulation()!=0)
						to.setStandardizationManagementHbpRate(new BigDecimal((float)to.getStandardizationHbpPopulation()/to.getManageHbpPopulation()));
					if(to.getManageDiPopulation()!=0)
						to.setStandardizationManagementDiRate(new BigDecimal((float)to.getStandardizationDiPopulation()/to.getManageDiPopulation()));
					if(to.getManageCancerPopulation()!=0)
						to.setStandardizationManagementCancerRate(new BigDecimal((float)to.getStandardizationCancerPopulation()/to.getManageCancerPopulation()));
					if(to.getManageStrokePopulation()!=0)
						to.setStandardizationManagementStrokeRate(new BigDecimal((float)to.getStandardizationStrokePopulation()/to.getManageStrokePopulation()));
					if(to.getManageCoronaryPopulation()!=0)
						to.setStandardizationManagementCoronaryRate(new BigDecimal((float)to.getStandardizationCoronaryPopulation()/to.getManageCoronaryPopulation()));
					//健康管理率
					if(to.getAppraisePopulation()!=0)
						to.setHealthManagementRate(new BigDecimal((float)to.getCdmManageTotal()/to.getAppraisePopulation()));
					//管理人群血压控制率
					if(to.getManageHbpPopulation()!=0)
						to.setBloodToStandardRate(new BigDecimal((float)to.getBloodToStandard()/to.getManageHbpPopulation()));
					//管理人群血糖控制率
					if(to.getManageDiPopulation()!=0)
						to.setBloodSugerToStandardRate(new BigDecimal((float)to.getBloodSugerToStandard()/to.getManageDiPopulation()));
				}
			}
		}
		return cdmsStatisticsList;
	}

	private void setEntity(CdmsStatisticsInfo cdmsStatistics){
		cdmsStatistics.setAppraisePopulation(Long.valueOf("0"));
		cdmsStatistics.setBloodSugerToStandard(Long.valueOf("0"));
		cdmsStatistics.setBloodSugerToStandardRate(new BigDecimal("0.00"));
		cdmsStatistics.setBloodToStandard(Long.valueOf("0"));
		cdmsStatistics.setBloodToStandardRate(new BigDecimal("0.00"));
		cdmsStatistics.setCdmManageTotal(Long.valueOf("0"));
		cdmsStatistics.setDistrictPopulation(Long.valueOf("0"));
		cdmsStatistics.setHealthManagementRate(new BigDecimal("0.00"));
		cdmsStatistics.setManageCancerPopulation(Long.valueOf("0"));
		cdmsStatistics.setManageCoronaryPopulation(Long.valueOf("0"));
		cdmsStatistics.setManageDiPopulation(Long.valueOf("0"));
		cdmsStatistics.setManageHbpPopulation(Long.valueOf("0"));
		cdmsStatistics.setManageStrokePopulation(Long.valueOf("0"));
		cdmsStatistics.setStandardizationCancerPopulation(Long.valueOf("0"));
		cdmsStatistics.setStandardizationCoronaryPopulation(Long.valueOf("0"));
		cdmsStatistics.setStandardizationDiPopulation(Long.valueOf("0"));
		cdmsStatistics.setStandardizationHbpPopulation(Long.valueOf("0"));
		cdmsStatistics.setStandardizationStrokePopulation(Long.valueOf("0"));
		cdmsStatistics.setStandardizationManagementCancerRate(new BigDecimal("0.00"));
		cdmsStatistics.setStandardizationManagementCoronaryRate(new BigDecimal("0.00"));
		cdmsStatistics.setStandardizationManagementDiRate(new BigDecimal("0.00"));
		cdmsStatistics.setStandardizationManagementHbpRate(new BigDecimal("0.00"));
		cdmsStatistics.setStandardizationManagementStrokeRate(new BigDecimal("0.00"));
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
	public List<Map<String, Long>> getStaticticsByAdmin(Date startDate, Date endDate,String gbCode) {
		List<Map<String, Object>> list = new ArrayList<>();
		if(StringUtil.isNotEmpty(gbCode)){
			list = cdmsStatisticsDao.getCdmStatictics(gbCode, "QWGZX", startDate,endDate);
		}else {
			list = cdmsStatisticsDao.getCdmStatictics(null, "ADMIN", startDate,endDate);
		}
		return retrunList(list);
	}

	@Override
	public List<Map<String, Long>> getStaticticsByCenter(String centerOrganCode,Date startDate, Date endDate) {
		List<Map<String, Object>> list = cdmsStatisticsDao.getCdmStatictics(centerOrganCode, "CENTER", startDate,endDate);
		return retrunList(list);
	}

	@Override
	public List<Map<String, Long>> getStaticticsByStation(
			String stationOrganCode,Date startDate, Date endDate) {
		List<Map<String, Object>> list = cdmsStatisticsDao.getCdmStatictics(stationOrganCode, "STATION", startDate,endDate);
		return retrunList(list);
	}
	
	private List<Map<String,Long>> retrunList(List<Map<String, Object>> list){
		List<Map<String,Long>> returnList=new ArrayList<>();
		for(Map<String, Object> map:list){
			Map<String,Long> returnMap=new HashMap<>(6);
			returnMap.put("HBP_TOTAL", getLong(map,"HBP_TOTAL"));
			returnMap.put("DI_TOTAL", getLong(map,"DI_TOTAL"));
			returnMap.put("TUMOR_TOTAL", getLong(map,"TUMOR_TOTAL"));
			returnMap.put("STROKE_TOTAL", getLong(map,"STROKE_TOTAL"));
			returnMap.put("CORONARY_TOTAL", getLong(map,"CORONARY_TOTAL"));
			returnMap.put("HOUSEHOLD_TYPE", getLong(map,"HOUSEHOLD_TYPE"));
			returnList.add(returnMap);
		}
		return returnList;
	}
	
}
