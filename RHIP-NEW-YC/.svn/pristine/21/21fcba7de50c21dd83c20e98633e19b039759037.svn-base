package com.founder.rhip.ehr.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.dto.HisWebServiceDto;


public interface IPastHistoryAnalyzeService {
	/**
	 * 分析疾病史
	 */
	void analyzeDiseaseHistory(Criteria criteria);
	
	/**
	 * 分析手术史
	 */
	void analyzeSurgeryHistory(Criteria criteria);
	
	/**
	 * 分析住院史
	 */
	void analyzeHospitalizedHistory(Criteria criteria);
	
	/**
	 * 分析输血史
	 */
	void analyzeTransBloodHistory(Criteria criteria);
	
	/**
	 * 分析过敏史
	 */
	void analyzeDrugAllergyHistory(Criteria criteria);
	
	/** 
	* @Title: getAnalyse 
	* @Description: 查询患者过敏信息信息接口
	* @param @param requestXml
	* @param @return
	* @return String
	* @throws 
	*/
	@WebMethod
	public String getAnalyse(HisWebServiceDto hisWebServiceDto);
}
