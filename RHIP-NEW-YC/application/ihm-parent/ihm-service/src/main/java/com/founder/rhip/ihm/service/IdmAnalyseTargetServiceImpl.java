/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ihm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.repository.ihm.IIdmAnalyseTargetDao;
import com.founder.rhip.mdm.common.OrgGenreCode;


@Service("idmAnalyseTargetService")
public class IdmAnalyseTargetServiceImpl extends IhmService implements IIdmAnalyseTargetService {

	@Resource(name="idmAnalyseTargetDao")
	private IIdmAnalyseTargetDao idmAnalyseTargetDao;

	
	@Override
	public Map<String, Object> getTrendMap(String beginDate
			,String endDate
			,String genreCode
			,String gbCode
			,String parentCode
			,String organCode
			,String infectiousCode){
		Map<String, Object> result = new HashMap<String,Object>();
		if(StringUtil.isNotEmpty(beginDate)
				&& StringUtil.isNotEmpty(endDate)
				&& StringUtil.isNotEmpty(genreCode)){
			result = idmAnalyseTargetDao.getTrendMap(beginDate,endDate,genreCode,gbCode,parentCode,organCode,infectiousCode);
		}
		return result;
	}
	
	@Override
	public List<Map<String, Object>> getRegionList(String beginDate
			,String endDate
			,String genreCode
			,String gbCode
			,String parentCode
			,String organCode){
		List<Map<String, Object>> result = null;
		if(StringUtil.isNotEmpty(beginDate)
				&& StringUtil.isNotEmpty(endDate)
				&& StringUtil.isNotEmpty(genreCode)){
			result = idmAnalyseTargetDao.getRegionList(beginDate,endDate,genreCode,gbCode,parentCode,organCode);
			//如果按镇统计，将没有统计到的镇数据补齐
			if("0".equals(genreCode) && ObjectUtil.isNullOrEmpty(gbCode)){
				fillTownData(result,"GB_CODE");
			}			
		}
		amountAdjustData(result,genreCode,gbCode,parentCode,organCode);
		return result;
	}
	
	/**
	 * 只统计某一个具体机构时，去掉合计数据
	 *
	 * @param reports
	 * @param gbCode
	 * @param parentCode
	 * @param organCode
	 * @author Ye jianfei
	 */
	private void amountAdjustData(List<Map<String, Object>> reports, String genreCode, String gbCode, String parentCode, String organCode){
		String amountFlag = "grouping";
		for(int i = 0;i < reports.size(); i ++ ) {  
			Object gbCodeValue = reports.get(i).get("GB_CODE");
			Object parentCodeValue;
			Object organCodeValue = reports.get(i).get("ORGAN_CODE");
			if(OrgGenreCode.STATION.getValue().equals(genreCode)){
				parentCodeValue = reports.get(i).get("PARENT_CODE");
    		}else{
    			parentCodeValue = reports.get(i).get("ORGAN_CODE");
    		}
			if(StringUtil.isNotEmpty(gbCode) && amountFlag.equals(gbCodeValue) ){
				reports.remove(i);
				i--;
				continue;
			}
			if(StringUtil.isNotEmpty(parentCode)&& amountFlag.equals(parentCodeValue) ){
				reports.remove(i);
				i--;
				continue;
			}
			if(StringUtil.isNotEmpty(organCode)&& amountFlag.equals(organCodeValue) ){
				reports.remove(i);
				i--;
				continue;
			}
		 }
	}
}