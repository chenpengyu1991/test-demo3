/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ech.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.founder.rhip.ehr.common.EHRConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.dto.HealthEducationReport;
import com.founder.rhip.ehr.repository.ech.IEchStatisticsQueryDao;
import com.founder.rhip.ehr.repository.statistics.IHealthEducationActiveStatisticsDao;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;

@Service("echStatisticsService")
public class EchStatisticsServiceImpl extends AbstractService implements IEchStatisticsService {
	
	@Autowired
	private IOrganizationApp organizationApp;

	@Autowired
	private IDictionaryApp dictionaryApp;
	
	@Resource(name = "echStatisticsQueryDao")
	private IEchStatisticsQueryDao echStatisticsQueryDao;
	
	private static final String INPUTORGANCODE = "inputOrganCode";
	private static final String INPUTSUPERORGANCODE = "inputSuperOrganCode";
	private static final String GBCODE = "gbcode";
	
	@Override
	public List<Map<String, Object>> getStatistics(Criteria criteria) {
		List<Map<String, Object>> statisticses = null;
		String organCode = "";
		String superOrganCode = "";
		String gbCode = "";
		String year = criteria.get("examYear").toString();
		if (criteria.contains(INPUTORGANCODE)){
			organCode = criteria.get(INPUTORGANCODE).toString();//站编码
		}
		if (criteria.contains(INPUTSUPERORGANCODE)){
			superOrganCode = criteria.get(INPUTSUPERORGANCODE).toString();//中心编码
		}
		if (criteria.contains(GBCODE)){
			gbCode = criteria.get(GBCODE).toString();//镇编码
		}
		/**
		 * 如果中心编码等于站编码，则查询该中心数据
		 * 如果中心编码不为空，站编码为空，则查询该中心下所有站及本中心的数据
		 * 如果中心编码为空，则根据镇编码查询中心数据
		 */
		if(StringUtil.isNotEmpty(organCode)){
//			if(superOrganCode.equals(organCode)){//查本中心数据，按中心分组
//				statisticses = echStatisticsQueryDao.getStatisticsCentreResult(year,gbCode, superOrganCode);
//			}else{//查具体站数据，按站分组
				statisticses = echStatisticsQueryDao.getStatisticsStationResult(year, superOrganCode, organCode);
//			}			
		}else if(StringUtil.isNotEmpty(superOrganCode)){//查中心及所属站数据，按站分组+本中心数据
			statisticses = echStatisticsQueryDao.getStatisticsStationResult(year, superOrganCode, organCode);
//			statisticses = new ArrayList<>();
//			List<Map<String, Object>> centreLists = echStatisticsQueryDao.getStatisticsCentreResult(year,gbCode, superOrganCode);
//			if(centreLists.size()>0){
//				statisticses.add(centreLists.get(0));
//			}
//			centreLists = echStatisticsQueryDao.getStatisticsStationResult(year, superOrganCode, organCode);
//			for (Map<String, Object> centre : centreLists) {
//				statisticses.add(centre);
//			}
		}else{//查中心数据，按中心分组
			statisticses = echStatisticsQueryDao.getStatisticsCentreResult(year,gbCode, superOrganCode);
		}
		return statisticses;
	}

	/**
	 * 组织健康体检进度统计
	 * @param criteria 查询条件
	 * @param orgCode 机构集合
	 * @return
	 */
	private  Map<String, Object> organizeStatistics(Criteria criteria, String orgCode) {
		return null;
	}
	
	/**
	 * 获取卫生服务中心下属卫生服务站
	 * @param supOrganCode 中心机构编码
	 * @return
	 */
	private List<Organization> getStation(String supOrganCode) {
		List<Organization> stations = new ArrayList<Organization>();
		stations.addAll(organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, supOrganCode).add("GENRE_CODE", OrgGenreCode.STATION.getValue())));
		return stations;
	}
	
	/**
	 * 获取镇下面所有服务服务中心
	 * @param gbCode 镇的编码
	 * @return
	 */
	private List<Organization> getCentre(String gbCode) {
		Criteria criteria = new Criteria();
		if(gbCode.equals("_hospital")){
			criteria.add("GENRE_CODE",OrgGenreCode.HOSPITAL.getValue());
		}else if(gbCode.equals("_other")){
			criteria.add("GENRE_CODE",OrgGenreCode.OTHER.getValue());
		} else if(gbCode.equals(EHRConstants._INFIRMARY)) {
			criteria.add("GENRE_CODE",OrgGenreCode.INFIRMARY.getValue());
		} else if(gbCode.equals(EHRConstants._HEALTHOVERSIGHT)) {
			criteria.add("GENRE_CODE",OrgGenreCode.HEALTH_OVERSIGHT.getValue());
		} else{
			criteria = new Criteria("GB_CODE", gbCode);
			criteria.add("GENRE_CODE", OrgGenreCode.CENTRE.getValue());
		}
		
		List<Organization> centres = organizationApp.queryOrganization(criteria);
		return centres;
	}	
}