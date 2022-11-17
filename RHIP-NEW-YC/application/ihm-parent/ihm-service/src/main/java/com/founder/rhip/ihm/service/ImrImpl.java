/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ihm.service;

import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.repository.ihm.*;
import com.founder.rhip.mdm.common.OrgGenreCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("imrService")
public class ImrImpl extends IhmService implements IImrService {

	@Resource(name="imrDao")
	private IImrDao imrDao;

	@Override
	public List<Map<String, Object>> getImrFeeList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode) {
		List<Map<String, Object>> result = null;
		if(StringUtil.isNotEmpty(beginDate)
				&& StringUtil.isNotEmpty(endDate)
				&& StringUtil.isNotEmpty(genreCode)){
			result = imrDao.getImrFeeList(beginDate,endDate,genreCode,gbCode,parentCode,organCode);
			//如果按镇统计，将没有统计到的镇数据补齐
			if("0".equals(genreCode) && ObjectUtil.isNullOrEmpty(gbCode)){
				fillTownData(result,"GB_CODE");
			}
		}
		amountAdjustData(result,genreCode,gbCode,parentCode,organCode);
		return result;
	}

	@Override
	public List<Map<String, Object>> getIncisionList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode) {
		List<Map<String, Object>> result = null;
		if(StringUtil.isNotEmpty(beginDate)
				&& StringUtil.isNotEmpty(endDate)
				&& StringUtil.isNotEmpty(genreCode)){
			result = imrDao.getIncisionList(beginDate,endDate,genreCode,gbCode,parentCode,organCode);
			//如果按镇统计，将没有统计到的镇数据补齐
			if("0".equals(genreCode) && ObjectUtil.isNullOrEmpty(gbCode)){
				fillTownData(result,"GB_CODE");
			}
		}
		amountAdjustData(result,genreCode,gbCode,parentCode,organCode);
		return result;
	}

	@Override
	public List<Map<String, Object>> getConsistencyList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode) {
		List<Map<String, Object>> result = null;
		if(StringUtil.isNotEmpty(beginDate)
				&& StringUtil.isNotEmpty(endDate)
				&& StringUtil.isNotEmpty(genreCode)){
			result = imrDao.getConsistencyList(beginDate,endDate,genreCode,gbCode,parentCode,organCode);
			//如果按镇统计，将没有统计到的镇数据补齐
			if("0".equals(genreCode) && ObjectUtil.isNullOrEmpty(gbCode)){
				fillTownData(result,"GB_CODE");
			}
		}
		deleteTotal(result);
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

	/**
	 * 删除所有合计
	 *
	 * @param reports
	 * @author Ye jianfei
	 */
	private void deleteTotal(List<Map<String, Object>> reports){
		String amountFlag = "grouping";
		for(int i = 0;i < reports.size(); i ++ ) {
			Object organCodeValue = reports.get(i).get("ORGAN_CODE");
			if(amountFlag.equals(organCodeValue) ){
				reports.remove(i);
				i--;
				continue;
			}
		}
	}
}