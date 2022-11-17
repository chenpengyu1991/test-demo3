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

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.clinic.ClinicalPathway;
import com.founder.rhip.ehr.entity.clinic.SickbedUseState;
import com.founder.rhip.ehr.repository.ihm.IMedicalTargetDao;
import com.founder.rhip.ehr.repository.clinic.IClinicalPathwayDao;
import com.founder.rhip.ehr.repository.clinic.ISickbedUseStateDao;
import com.founder.rhip.mdm.common.OrgGenreCode;


@Service("medicalTargetService")
public class MedicalTargetServiceImpl extends IhmService implements IMedicalTargetService {

	@Resource(name="medicalTargetDao")
	private IMedicalTargetDao medicalTargetDao;
	
	@Resource(name="clinicalPathwayDao")
	private IClinicalPathwayDao clinicalPathwayDao;

	@Resource(name="sickbedUseStateDao")
	private ISickbedUseStateDao sickbedUseStateDao;
	
	@Override
	public List<Map<String, Object>> getOutpatientList(String beginDate
			,String endDate
			,String genreCode
			,String gbCode
			,String parentCode
			,String organCode){
		List<Map<String, Object>> result = null;
		if(StringUtil.isNotEmpty(beginDate)
				&& StringUtil.isNotEmpty(endDate)
				&& StringUtil.isNotEmpty(genreCode)){
			result = medicalTargetDao.getOutpatientList(beginDate,endDate,genreCode,gbCode,parentCode,organCode);
			//如果按镇统计，将没有统计到的镇数据补齐
			if("0".equals(genreCode) && ObjectUtil.isNullOrEmpty(gbCode)){
				fillTownData(result,"GB_CODE");
			}			
		}
		amountAdjustData(result,genreCode,gbCode,parentCode,organCode);
		return result;
	}

	@Override
	public List<Map<String, Object>> getInpatientList(String beginDate
			,String endDate
			,String genreCode
			,String gbCode
			,String parentCode
			,String organCode){
		List<Map<String, Object>> result = null;
		if(StringUtil.isNotEmpty(beginDate)
				&& StringUtil.isNotEmpty(endDate)
				&& StringUtil.isNotEmpty(genreCode)){
			result = medicalTargetDao.getInpatientList(beginDate,endDate,genreCode,gbCode,parentCode,organCode);
			//如果按镇统计，将没有统计到的镇数据补齐
			if("0".equals(genreCode) && ObjectUtil.isNullOrEmpty(gbCode)){
				fillTownData(result,"GB_CODE");
			}			
		}
		amountAdjustData(result,genreCode,gbCode,parentCode,organCode);
		return result;
	}


	@Override
	public List<Map<String, Object>> getHospitalCostsList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode,String opEmHpMark) {
		List<Map<String, Object>> result = null;
		if(StringUtil.isNotEmpty(beginDate)
				&& StringUtil.isNotEmpty(endDate)
				&& StringUtil.isNotEmpty(genreCode)){
			result = medicalTargetDao.getHospitalCostsList(beginDate,endDate,genreCode,gbCode,parentCode,organCode,opEmHpMark);
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


	@Override
	public PageList<ClinicalPathway> getClinicalPathwayList(Page page, Criteria criteria) {
		return clinicalPathwayDao.getPageList(page,criteria);
	}

	@Override
	public PageList<SickbedUseState> getSickbedUseStateList(Page page, Criteria criteria) {
		return sickbedUseStateDao.getPageList(page,criteria);
	}

    /**
     * 临床路径统计
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getClinicalPathwayStatistics(Map<String, String> paramMap){
        return medicalTargetDao.getClinicalPathwayStatistics(paramMap);
    }


    /**
     * 治疗质量统计分析
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getCureResultAnalys(Map<String, String> paramMap){
        return medicalTargetDao.getCureResultAnalys(paramMap);
    }


    /**
     * 监测症状统计
     *
     * @param paramMap
     * @return
     * @author Ye jianfei
     */
    public List<Map<String, Object>> getSymptomList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode){
        return medicalTargetDao.getSymptomList(beginDate, endDate, genreCode, gbCode, parentCode, organCode);
    }


    /**
     * 检查结果统计分析
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getStudyAnalys(Map<String, String> paramMap){
        return medicalTargetDao.getStudyAnalys(paramMap);
    }
    /**
     * 检验结果统计分析
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getExamAnalys(Map<String, String> paramMap){
        return medicalTargetDao.getExamAnalys(paramMap);
    }

    /**
     * A、B类型传染病统计
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getDiseaseType(Map<String, String> paramMap){
        return medicalTargetDao.getDiseaseType(paramMap);
    }

    /**
     * 1年内按月统计A、B类型传染病
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getDiseaseMonth(Map<String, String> paramMap){
        return medicalTargetDao.getDiseaseMonth(paramMap);
    }
    
    /**
	 * 检验人数统计
	 * @param paramMap
	 * @return
	 */
	public List<Map<String, Object>> getExamCount(Map<String, String> paramMap){
		return medicalTargetDao.getExamCount(paramMap);
	}


}