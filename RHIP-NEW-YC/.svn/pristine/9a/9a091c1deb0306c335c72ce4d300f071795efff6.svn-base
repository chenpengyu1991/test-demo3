/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 * 精神卫生规范管理
 */

package com.founder.rhip.mhm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.dto.mhm.MhmStatisticsReportDto;
import com.founder.rhip.ehr.repository.healtheducation.IHeActiveDao;
import com.founder.rhip.ehr.repository.management.mhm.*;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.common.StatusValue;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("mhmStatisticsReportService")
public class MhmStatisticsReportServiceImpl extends AbstractService implements IMhmStatisticsReportService {

    @Resource(name = "mhmStatisticsReportDao")
    private IMhmStatisticsReportDao mhmStatisticsReportDao;
	
	@Resource(name = "mdmOrganizationService")
	private IOrganizationService organizationService;
	
	@Resource(name = "heActiveDao")
	private IHeActiveDao healthEducationActiveDao;
	
	
	/**
	 * 中心角色统计报表
	 *
	 * @param year
	 * @param month
	 * @param quarter
	 * @param centerCode
	 * @param stationCode
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public List<MhmStatisticsReportDto> getStationResult(String year, String month, Integer quarter,String centerCode,String stationCode){
		String startDate = this.getStartDate(year, month, quarter);
		String endDate = this.getEndDate(year, month, quarter);
		List<MhmStatisticsReportDto> reports = new ArrayList<MhmStatisticsReportDto>();
		Criteria ca = new Criteria(Organization.PARENT_CODE, centerCode);
		ca.add(Organization.STATUS, StatusValue.normalValue.getValue());
		if(StringUtil.isNotEmpty(stationCode)){
			ca= new Criteria(Organization.ORGAN_CODE, stationCode);
		}
		List<Organization> stationList = organizationService.getOrganizationsUseCache(ca,new Order("gb_code",true));
		/*如果查询站数据，则需要查询本年度或指定季度，截至到当月，每个月的数据*/
		if(StringUtil.isNullOrEmpty(month) && StringUtil.isNotEmpty(stationCode)){
			List<String> months = getMonths(year,quarter);
			for(String searchMonth:months){
				Date reportMonth = DateUtil.parseSimpleDate(searchMonth,"yyyy/MM");
				Map<String, MhmStatisticsReportDto> map = mhmStatisticsReportDao.getStatisticsResult(year, searchMonth, null,null, stationCode, OrgGenreCode.STATION);
				startDate = searchMonth + "/01";
				endDate = DateUtil.getDateTime("yyyy/MM/dd",DateUtil.lastDateOfMonth(reportMonth));
				
				for(Organization org:stationList){
					MhmStatisticsReportDto dto = map.get(org.getOrganCode());
					if(ObjectUtil.isNullOrEmpty(dto)){
						dto = new MhmStatisticsReportDto();
						dto.setManagementStation(org.getOrganCode());//站
					}
					dto.setReportMonth(reportMonth);
					getHealthEducationData(dto,OrgGenreCode.STATION,startDate,endDate);//获取健康教育接口
					reports.add(dto);
				}
				
			}
		}else{
			Map<String, MhmStatisticsReportDto> map = mhmStatisticsReportDao.getStatisticsResult(year, month, quarter,null, stationCode, OrgGenreCode.STATION);
			for(Organization org:stationList){
				MhmStatisticsReportDto dto = map.get(org.getOrganCode());
				if(ObjectUtil.isNullOrEmpty(dto)){
					dto = new MhmStatisticsReportDto();
					dto.setManagementStation(org.getOrganCode());
				}
				getHealthEducationData(dto,OrgGenreCode.STATION,startDate,endDate);//获取健康教育接口
				reports.add(dto);
			}
			reports.add(amountResult(reports));//累加
		}
		
		return reports;
	}
	

	/**
	 * 精防中心角色统计报表
	 *
	 * @param year
	 * @param month
	 * @param quarter
	 * @param townCode
	 * @param centreCode
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public List<MhmStatisticsReportDto> getCentreResult(String year, String month, Integer quarter,String townCode,String centerCode){
		String startDate = this.getStartDate(year, month, quarter);
		String endDate = this.getEndDate(year, month, quarter);
		List<MhmStatisticsReportDto> reports = new ArrayList<MhmStatisticsReportDto>();
		Criteria ca = new Criteria("genreCode",OrgGenreCode.CENTRE.getValue());
		ca.add(Organization.STATUS, StatusValue.normalValue.getValue());
		if(StringUtil.isNotEmpty(townCode)){
			ca.add("gbCode", townCode);
		}		
		if(StringUtil.isNotEmpty(centerCode)){
			ca.add(Organization.ORGAN_CODE, centerCode);
		}
		List<Organization> stationList = organizationService.getOrganizationsUseCache(ca,new Order("gb_code",true));
		/*如果查询中心数据，则需要查询本年度或指定季度，截至到当月，每个月的数据*/
		if(StringUtil.isNullOrEmpty(month) && StringUtil.isNotEmpty(centerCode)){
			List<String> months = getMonths(year,quarter);
			for(String searchMonth:months){
				Date reportMonth = DateUtil.parseSimpleDate(searchMonth, "yyyy/MM");
				startDate = searchMonth + "/01";
				endDate = DateUtil.getDateTime("yyyy/MM/dd",DateUtil.lastDateOfMonth(reportMonth));				
				Map<String, MhmStatisticsReportDto> map = mhmStatisticsReportDao.getStatisticsResult(year, searchMonth, null,townCode, centerCode, OrgGenreCode.CENTRE);
				for(Organization org:stationList){
					MhmStatisticsReportDto dto = map.get(org.getOrganCode());
					if(ObjectUtil.isNullOrEmpty(dto)){
						dto = new MhmStatisticsReportDto();
						dto.setManagementCenter(org.getOrganCode());//中心编码
					}
					dto.setManagementTown(org.getGbCode());
					dto.setReportMonth(reportMonth);
					getHealthEducationData(dto,OrgGenreCode.CENTRE,startDate,endDate);//获取健康教育接口
					reports.add(dto);
				}
			}			
		}else{
			Map<String, Integer> amountTownCountMap = amountTownCount(stationList);
			Map<String, MhmStatisticsReportDto> map = mhmStatisticsReportDao.getStatisticsResult(year, month, quarter,townCode, centerCode, OrgGenreCode.CENTRE);
			MhmStatisticsReportDto townDto = new MhmStatisticsReportDto();
			String oldGbCode = "";
			Integer townCenterCount = 0;//镇下属中心个数
			Integer orgCount = stationList.size();
			Integer orgIndex = 0;
			/*同一个镇的数据需要累加*/
			for(Organization org:stationList){
				orgIndex ++;
				MhmStatisticsReportDto dto = map.get(org.getOrganCode());
				if(ObjectUtil.isNullOrEmpty(dto)){
					dto = new MhmStatisticsReportDto();
					dto.setManagementCenter(org.getOrganCode());
				}
				dto.setManagementTown(org.getGbCode());
				getHealthEducationData(dto,OrgGenreCode.CENTRE,startDate,endDate);//获取健康教育接口
				if(StringUtil.isNullOrEmpty(oldGbCode)){
					oldGbCode = org.getGbCode();
					/*每个镇的第一条数据设置中心个数*/
					townCenterCount = amountTownCountMap.get(oldGbCode);
					dto.setTownCenterCount(townCenterCount);
				}
				String newGbCode = org.getGbCode();
				if(oldGbCode.equals(newGbCode)){
					townDto.amout(dto);//累加
				}else{
					townDto.setManagementTown(oldGbCode);
					townDto.setAmountFlag("2");//镇合计标志
					reports.add(townDto);
					oldGbCode = org.getGbCode();
					townDto = new MhmStatisticsReportDto();
					townDto.amout(dto);//累加
					/*每个镇的第一条数据设置中心个数*/
					townCenterCount = amountTownCountMap.get(oldGbCode);
					dto.setTownCenterCount(townCenterCount);
				}
				reports.add(dto);
				if(orgIndex.equals(orgCount)){
					townDto.setManagementTown(oldGbCode);
					townDto.setAmountFlag("2");//镇合计标志
					reports.add(townDto);
				}				
			}
			reports.add(amountResult(reports));//总计
		}
		return reports;
	}
	
	/**
	 * 获取健康教育接口:培训人数,培训次数
	 *
	 * @param reportMap
	 * @param genreCode
	 * @param startDate
	 * @param endDate
	 * @author Ye jianfei
	 */
	private void getHealthEducationData(Map<String, MhmStatisticsReportDto> reportMap, OrgGenreCode genreCode, String startDate, String endDate){
		String gbCode;
		String parentCode;
		String organCode;
		for(String key: reportMap.keySet()){  
			if(StringUtil.isNullOrEmpty(key)){
				continue;
			}
			gbCode = reportMap.get(key).getManagementTown();
			parentCode = reportMap.get(key).getManagementCenter();
			organCode = reportMap.get(key).getManagementStation();
			Map<String, Object> educationMap = healthEducationActiveDao.getStatistics(gbCode, parentCode, organCode, genreCode, startDate, endDate);
			if(ObjectUtil.isNotEmpty(educationMap)){
				Integer trainingNumber = NumberUtil.convert(educationMap.get("EDUCATION_PERSON_QUANTITY").toString(), Integer.class);
				Integer trainingTime = NumberUtil.convert(educationMap.get("EDUCATION_QUANTITY").toString(), Integer.class);
				reportMap.get(key).setTrainingNumber(trainingNumber);
				reportMap.get(key).setTrainingTime(trainingTime);
			}
		}  

	}

	/**
	 * 获取健康教育接口:培训人数,培训次数(单独一个机构)
	 *
	 * @param dto
	 * @param genreCode
	 * @param startDate
	 * @param endDate
	 * @author Ye jianfei
	 */
	private void getHealthEducationData(MhmStatisticsReportDto dto, OrgGenreCode genreCode, String startDate, String endDate){
		String gbCode = dto.getManagementTown();
		String parentCode = dto.getManagementCenter();
		String organCode = dto.getManagementStation();
		Map<String, Object> educationMap = healthEducationActiveDao.getStatistics(gbCode, parentCode, organCode, genreCode, startDate, endDate);
		if(ObjectUtil.isNotEmpty(educationMap)){
			Integer trainingNumber = NumberUtil.convert(educationMap.get("EDUCATION_PERSON_QUANTITY").toString(), Integer.class);
			Integer trainingTime = NumberUtil.convert(educationMap.get("EDUCATION_QUANTITY").toString(), Integer.class);
			dto.setTrainingNumber(trainingNumber);
			dto.setTrainingTime(trainingTime);
		}
	}
	
	
	private String getStartDate(String year, String month, Integer quarter){
		String result = "";
		if(StringUtil.isNotEmpty(month)){
			result = month + "/01";
		}else if(ObjectUtil.isNotEmpty(quarter)){
            Calendar c = Calendar.getInstance();
            Date quarterMonth[] = DateUtil.getDateRangeBySeason(quarter);
            c.setTime(quarterMonth[0]);
            c.set(Calendar.YEAR, NumberUtil.convert(year, Integer.class));
            result = DateUtil.getDateTime("yyyy/MM/dd", c.getTime());
		}else{
			result = year + "/01/01";
		}
		return result;
	}
	
	private String getEndDate(String year, String month, Integer quarter){
		String result = "";
		if(StringUtil.isNotEmpty(month)){
			Date tempDate = DateUtil.parseSimpleDate(month, "yyyy/MM");
			result = DateUtil.getDateTime("yyyy/MM/dd",DateUtil.lastDateOfMonth(tempDate));;
		}else if(ObjectUtil.isNotEmpty(quarter)){

            Calendar c = Calendar.getInstance();
            Date quarterMonth[] = DateUtil.getDateRangeBySeason(quarter);
            c.setTime(quarterMonth[1]);
            c.set(Calendar.YEAR, NumberUtil.convert(year, Integer.class));
            result = DateUtil.getDateTime("yyyy/MM/dd", c.getTime());
		}else{
			result = year + "/12/31";
		}
		return result;
	}
	/**
	 * 合计
	 *
	 * @param reports
	 * @return
	 * @author Ye jianfei
	 */
	private MhmStatisticsReportDto amountResult(List<MhmStatisticsReportDto> reports){
		MhmStatisticsReportDto result = new MhmStatisticsReportDto();
		if(ObjectUtil.isNotEmpty(reports)){
			for(MhmStatisticsReportDto dto:reports){
				if(!"2".equals(dto.getAmountFlag())){
					result.amout(dto);
				}
			}
		}
		result.setAmountFlag("1");
		return result;
	}

	/**
	 * 合计
	 *
	 * @param stationList
	 * @return
	 * @author Ye jianfei
	 */
	private Map<String, Integer> amountTownCount(List<Organization> stationList){
		String gbCode = "";
		Integer amount = 0;
		Map<String, Integer> map= new HashMap<String, Integer>();
		for(Organization org:stationList){
			gbCode = org.getGbCode();
			if(map.containsKey(gbCode)){
				amount = map.get(gbCode);
				map.put(gbCode,amount + 1);
			}else{
				map.put(gbCode, 1);
			}
		}
		return map;
	}
	
	/**
	 * 根据年份、季度生成月份
	 *
	 * @param year
	 * @param quarter
	 * @return
	 * @author Ye jianfei
	 */
	private List<String> getMonths(String year,Integer quarter){
		List<String> months = new ArrayList<String>();
    	int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    	int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
    	if(ObjectUtil.isNotEmpty(quarter)){
    		for(int i = 1;i<=3;i++){
    			int searchMonth = (quarter-1)*3 + i;
    			if(searchMonth <= currentMonth){
    				months.add(year + "/" + String.format("%1$02d", searchMonth));
    			}
    		}
    	}else if(Integer.parseInt(year) != currentYear){
    		for(int i = 1;i <=12 ;i++){
				months.add(year + "/" + String.format("%1$02d", i));
			}   		
    	}else{
			for(int i = 1;i <=currentMonth ;i++){
				months.add(year + "/" + String.format("%1$02d", i));
			}    		
    	}
    	return months;
	}	
}