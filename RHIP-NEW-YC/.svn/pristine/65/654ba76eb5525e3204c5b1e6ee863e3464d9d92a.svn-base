/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ihm.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.repository.ech.IEchStatisticsQueryDao;
import com.founder.rhip.ehr.repository.ihm.IHmTargetDao;


@Service("hmTargetService")
public class HmTargetServiceImpl extends IhmService implements IHmTargetService {


	@Resource(name="echStatisticsQueryDao")
	private IEchStatisticsQueryDao echStatisticsQueryDao;

	@Resource(name="hmTargetDao")
	private IHmTargetDao hmTargetDao;
	/**
	 * 综合管理老年人保健-指标数据
	 *
	 * @param examYear:体检年份
	 * @param genreCode：机构类型
	 * @param gbCode：镇编码
	 * @param parentCode：中心编码
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public List<Map<String, Object>> getTargetList(Integer examYear,String genreCode,String gbCode,String parentCode){
		List<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(examYear) 
				&& StringUtil.isNotEmpty(genreCode)){
			result = getTargetData(examYear,genreCode,gbCode,parentCode);			
		}
		//如果按镇统计，将没有统计到的镇数据补齐
		if("0".equals(genreCode) && StringUtil.isNullOrEmpty(gbCode)){
			fillTownData(result,"organCode");
		}
		return result;
	}

	/**
	 * 统计老年人保健-管理率数据
	 *
	 * @param examYear
	 * @param genreCode
	 * @param gbCode
	 * @param parentCode
	 * @param organCode
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public List<Map<String, Object>> getRateList(Integer examYear
			,String genreCode
			,String gbCode
			,String parentCode
			,String organCode){
		List<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(examYear) 
				&& StringUtil.isNotEmpty(genreCode)){
			result = getRateData(examYear,genreCode,gbCode,parentCode,organCode);			
		}
		//如果按镇统计，将没有统计到的镇数据补齐
		if("0".equals(genreCode) && StringUtil.isNullOrEmpty(gbCode)){
			fillTownData(result,"organCode");
		}
		return result;
	}

	/**
	 * 统计指标
	 *
	 * @param examYear:体检年份
	 * @param genreCode：机构类型
	 * @param gbCode：镇编码
	 * @param parentCode：中心编码
	 * @return
	 * @author Ye jianfei
	 */
	private List<Map<String, Object>> getTargetData(Integer examYear,String genreCode,String gbCode,String parentCode){
		return echStatisticsQueryDao.getTargetData(examYear, genreCode,gbCode, parentCode);
	}
	
	private List<Map<String, Object>> getRateData(Integer examYear,String genreCode,String gbCode,String parentCode,String organCode){
		return echStatisticsQueryDao.getRateData(examYear, genreCode,gbCode, parentCode,organCode);
	}

	@Override
	public List<Map<String, Object>> getPersonTimeList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode) {
		return hmTargetDao.getPersonTimeList(beginDate, endDate, genreCode, gbCode, parentCode, organCode);
	}	
}