/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ihm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.repository.ihm.IEpidemicTargetDao;

@Service("epidemicTargetService")
public class EpidemicTargetServiceImpl extends IhmService implements IEpidemicTargetService {

	@Resource(name = "epidemicTargetDao")
    private IEpidemicTargetDao epidemicTargetDao; 

	
	/**
	 * 默认职业列表
	 */
	private static final LinkedHashMap<String, Object> defaultOccupationMap = new LinkedHashMap<String, Object>(){
		/**
		 * Fields .....
		 */
		private static final long serialVersionUID = 4894158473223979290L;

		{
			put("CV020120201", 0);put("CV020120202", 0);put("CV020120203", 0);put("CV020120204", 0);put("CV020120205", 0);put("CV020120206", 0);
			put("CV020120207", 0);put("CV020120208", 0);put("CV020120209", 0);put("CV020120210", 0);put("CV020120211", 0);put("CV020120212", 0);
			put("CV020120213", 0);put("CV020120214", 0);put("CV020120215", 0);put("CV020120216", 0);put("CV020120299", 0);put("CV020120217", 0);
		}
	}; 
	
	@Override
	public List<Map<String, Object>> getOccupationTargetList(Criteria criteria) {
		//按市级医院（一个市级医院一条数据）、按卫生院（一个卫生院一条数据）、按镇（一个镇一条数据）
		return getReportData(criteria,0);
	}

	@Override
	public List<Map<String, Object>> getAgeTargetList(Criteria criteria) {
		//按市级医院（一个市级医院一条数据）、按卫生院（一个卫生院一条数据）、按镇（一个镇一条数据）
		return getReportData(criteria,1);
	}

	
	/**
	 * 根据机构编码统计报卡数据--按职业
	 *
	 * @param criteria
	 * @param reportType 0:按职业统计，1：按年龄统计
	 * @return
	 * @author Ye jianfei
	 */
	private List<Map<String, Object>> getReportData(Criteria ca,int reportType){
		Object genreCode = ca.get("genreCode");
		Object gbCode = ca.get("GB_CODE");
		List<Map<String, Object>> result = null;
		if(0 == reportType){//按职业统计
			List<Map<String, Object>> reports = epidemicTargetDao.getOccupationTargetList(ca);
			result = organizeOccupation(reports);	
		}else if (1 == reportType){//按年龄统计
			result = epidemicTargetDao.getAgeTargetList(ca);
		}
		
		//如果按镇统计，将没有统计到的镇数据补齐
		if("0".equals(genreCode) && ObjectUtil.isNullOrEmpty(gbCode)){
			fillTownData(result,"organCode");
		}
		return result;
	}
	
	/**
	 * 组织数据：将报卡统计数据按职业行转列
	 *
	 * @param reports
	 * @return
	 * @author Ye jianfei
	 */
	private List<Map<String, Object>> organizeOccupation(List<Map<String, Object>> reports){
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		if(ObjectUtil.isNotEmpty(reports)){
			String organCodeOld = "";
			HashMap<String,Object> report = null;
			HashMap<String,Object> totalMap = new HashMap<String,Object>(); 
			for(Map<String, Object> map:reports){
				Object occupation = map.get("occupation");
				Object reportSum = map.get("reportSum");
				Object organCodeNew = map.get("organCode");
				//如果机构编码不相等则表示下一个机构
				if(!organCodeOld.equals(organCodeNew.toString())){
					if(ObjectUtil.isNotEmpty(report)){
						result.add(report);
					}
					report = new HashMap<String,Object>();
					organCodeOld = organCodeNew.toString();
					report.put("organCode", organCodeNew);
				}
				//总计
				if("grouping".equals(occupation.toString()) && "grouping".equals(organCodeNew.toString())){
					totalMap.put("organCode", "total");
					totalMap.put("total", reportSum.toString());					
				}else if("grouping".equals(occupation.toString())){//按镇合计
					report.put("total", reportSum.toString());
				}else if("grouping".equals(organCodeNew.toString())){//按职业合计
					totalMap.put(occupation.toString(), reportSum.toString());
				}else{				
					report.put(occupation.toString(), reportSum.toString());
				}
			}
			//总计数据
			result.add(totalMap);
		}
		return result;
	}
	
	/**
	 * 获取机构下报卡职业列表
	 */
	@Override
	public List<Map<String, Object>> getOccupationList(Criteria criteria){
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		if(ObjectUtil.isNotEmpty(criteria)){
			result = epidemicTargetDao.getOccupationTypeList(criteria);
		}
		/**
		 * 如果结果为空，则初始化默认职业列表
		 */
		if(ObjectUtil.isNullOrEmpty(result)){
			@SuppressWarnings("rawtypes")
			Iterator iter = defaultOccupationMap.entrySet().iterator();
			while (iter.hasNext()){
				Map<String, Object> occupationMap = new HashMap<String,Object>();
				@SuppressWarnings("rawtypes")
				Map.Entry entry = (Map.Entry) iter.next();
				occupationMap.put("occupation",entry.getKey().toString());
				result.add(occupationMap);
			}
		}
		return result;
	}
}