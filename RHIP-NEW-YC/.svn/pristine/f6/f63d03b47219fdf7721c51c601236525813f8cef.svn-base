/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.clinic.IDrugUsageDao;
import com.founder.rhip.ehr.repository.ihm.ICdmPerformanceDao;
import com.founder.rhip.ehr.repository.ihm.IMedicalTargetDao;
import com.founder.rhip.ehr.repository.ihm.IPerformanceDao;
import com.founder.rhip.ehr.repository.ihm.IWchPerformanceDao;
import com.founder.rhip.mdm.common.OrgGenreCode;

import com.founder.rhip.mdm.repository.IPersonDao;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service("performanceService")
public class PerformanceServiceImpl extends IhmService implements IPerformanceService {

	@Resource(name = "wchPerformanceDao")
    private IWchPerformanceDao wchPerformanceDao;

    @Resource(name = "performanceDao")
    private IPerformanceDao performanceDao;

    @Resource(name = "cdmPerformanceDao")
    private ICdmPerformanceDao cdmPerformanceDao;

    @Resource(name = "personInfoDao")
    private IPersonInfoDao personInfoDao;

	@Resource(name="medicalTargetDao")
	private IMedicalTargetDao medicalTargetDao;
	
    public PageList<Map<String, Object>> getWchPersonPerformance(Map<String, String> paramMap, Page page){

        return wchPerformanceDao.getWchPerformance(paramMap, page);
    }

    /**
     * 疫苗接种针次数
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getVaccinationPerformance(Map<String, String> paramMap){

        return performanceDao.getVaccinationPerformance(paramMap);
    }

    /**
     * 体检次数、各体检项目次数
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getHealthExamPerformance(Map<String, String> paramMap){
        return  performanceDao.getHealthExamPerformance(paramMap);
    }

    /**
     * 医疗考核个人绩效-门诊摘要(挂号人次)
     * @param paramMap
     * @return
     */
    public PageList<Map<String, Object>> getOutpatientPersonPerformance(Map<String, String> paramMap, Page page){
    	return medicalTargetDao.getPersonRegisterPerformance(paramMap, page);
    }
    
    /**
     * 医疗考核个人绩效-处方
     * @param paramMap
     * @return
     */
    public PageList<Map<String, Object>> getPrescriptionPersonPerformance(Map<String, String> paramMap, Page page){
    	return medicalTargetDao.getPersonPrescriptionPerformance(paramMap, page);
    }

    /**
     * 绩效- 机构人员培训
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getTrainingPerformance(Map<String, String> paramMap){
        return performanceDao.getTrainingPerformance(paramMap);
    }
    
    /**
     * 慢病个人绩效
     * @param paramMap
     * @param type  1:高血压 2:糖尿病 3:脑卒中 4:冠心病 5:肿瘤
     * @return
     */
    public PageList<Map<String, Object>> getCdmPersonPerformance(String type, Map<String, String> paramMap, Page page){
        return cdmPerformanceDao.getCdmPerformance(type, paramMap, page);
    }

    /**
     * 健康档案个人绩效
     * @param paramMap
     * @return
     */
    public PageList<Map<String, Object>> getHRPersonPerformance(Map<String, String> paramMap, Page page){
        return personInfoDao.getHRPerformance(paramMap, page);
    }


	@Override
	public List<Map<String, Object>> getServiceCapacityList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode) {
		List<Map<String, Object>> result = null;
		if(StringUtil.isNotEmpty(beginDate)
				&& StringUtil.isNotEmpty(endDate)
				&& StringUtil.isNotEmpty(genreCode)){
			result = medicalTargetDao.getServiceCapacityList(beginDate,endDate,genreCode,gbCode,parentCode,organCode);
			//如果按镇统计，将没有统计到的镇数据补齐
			if("0".equals(genreCode) && ObjectUtil.isNullOrEmpty(gbCode)){
				fillTownData(result,"GB_CODE");
			}			
		}
		amountAdjustData(result,genreCode,gbCode,parentCode,organCode);
		return result;
	}

	@Override
	public Map<String, Object> getServiceCapacity(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode) {
		List<Map<String, Object>> resultList = null;
		Map<String, Object>  result = null;
		if(StringUtil.isNotEmpty(beginDate)
				&& StringUtil.isNotEmpty(endDate)
				&& StringUtil.isNotEmpty(genreCode)){
			resultList = medicalTargetDao.getServiceCapacityList(beginDate,endDate,genreCode,gbCode,parentCode,organCode);
		}
		if(ObjectUtil.isNotEmpty(resultList)){
			result = resultList.get(0);
		}
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
     * 公共卫生服务项目指标
     * @param beginDate
     * @return
     */
    public List<Map<String, Object>> getServiceProjectPerformance(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode){

        List<Map<String, Object>> result = null;
        if(StringUtil.isNotEmpty(beginDate)
                && StringUtil.isNotEmpty(endDate)
                && StringUtil.isNotEmpty(genreCode)){
            result = medicalTargetDao.getServiceProjectPerformance(beginDate,endDate,genreCode,gbCode,parentCode,organCode);
            //如果按镇统计，将没有统计到的镇数据补齐
            if("0".equals(genreCode) && ObjectUtil.isNullOrEmpty(gbCode)){
                fillTownData(result,"GB_CODE");
            }
        }
        amountAdjustData(result,genreCode,gbCode,parentCode,organCode);
        return result;
    }

	@Override
	public List<Map<String, Object>> getHRPerformanceList(Map<String, String> paramMap) {
		List<Map<String, Object>> result = null;
		
		String genreCode = paramMap.get("genreCode");
		String gbCode = paramMap.get("gbCode");
		String parentCode = paramMap.get("parentCode");
        String organCode = paramMap.get("organCode"); 

		if(ObjectUtil.isNotEmpty(paramMap)){
			result = personInfoDao.getHRPerformance(paramMap);
			//如果按镇统计，将没有统计到的镇数据补齐
			if("0".equals(genreCode) && ObjectUtil.isNullOrEmpty(gbCode)){
				fillTownData(result,"GB_CODE");
			}			
		}
		amountAdjustData(result,genreCode,gbCode,parentCode,organCode);
		return result;		
	}

	@Override
	public PageList<Map<String, Object>> getAntibacterialsList(Map<String, String> paramMap, Page page) {
		PageList<Map<String, Object>> pageList = new PageList<>();
		if (paramMap == null) {
			return pageList;
		}
		
		return performanceDao.getAntibacterials(paramMap, page);
	}

	@Override
	public List<Map<String, Object>> getDoctors(String orgCode, String medicalCode, String beginDateA,String endDateA) {
		List<Map<String, Object>> results = new ArrayList<>();
		if (ObjectUtil.isNullOrEmpty(orgCode) || ObjectUtil.isNullOrEmpty(medicalCode)) {
			return results;
		}
		
		return performanceDao.getDoctors(orgCode, medicalCode, beginDateA, endDateA);
	}

	@Override
	public PageList<Map<String, Object>> getInpatientMedicalRecordQuality(Map<String, String> paramMap, Page page) {
		PageList<Map<String, Object>> list = new PageList<Map<String, Object>>();
		if (paramMap == null) {
			return list;
		}

		return performanceDao.getInpatientMedicalRecord(paramMap, page);
	}

	@Override
	public List<Map<String, Object>> getAntibacterialsPrescriptionList(Map<String, String> paramMap) {
		List<Map<String, Object>> result = new ArrayList<>();
		if (ObjectUtil.isNullOrEmpty(paramMap)) {
			return result;
		}
		
		return performanceDao.getAntibacterialPrescriptions(paramMap);
	}
}