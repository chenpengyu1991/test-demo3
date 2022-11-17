package com.founder.rhip.ehr.service.statistics;

import java.util.List;

import com.founder.rhip.ehr.dto.TargetDTO;

public interface ITargetOrgService {
	
	/**
	 * 定义选择方式，当机构下拉选择为中心时，有不同
	 * GET_CENTER 只获取当前中心
	 * GET_STATION 只获取下属站
	 * GET_ALL 获取中心和站
	 * */
	public static final Integer GET_CENTER = 1;
	public static final Integer GET_STATION = 2;
	public static final Integer GET_ALL = 3;

	/** 
	* @Title: getTargetDTOs 
	* @Description: 获取节点List
	* @param @param nextCodeType 下级机构类型
	* @param @param codeType 机构类型
	* @param @param orgCode 机构编码
	* @param @param getCenter 1 只获取到中心,2获取到站，3获取中心和站
	* @param @param targetCodes 统计指标
	* @param @return
	* @return List<TargetDTO>
	* @throws 
	*/
	List<TargetDTO> getTargetDTOs(Integer nextCodeType, Integer codeType, String orgCode,Integer getCenter,String[] targetCodes);

	/** 
	* @Title: getStationCodes 
	* @Description: 获取站机构编码
	* @param @param type
	* @param @param code
	* @param @return
	* @return List<String>
	* @throws 
	*/
	List<String> getStationCodes(Integer type, String code);

	/** 
	* @Title: getCenters 
	* @Description: 获取中心机构编码
	* @param @param type
	* @param @param code
	* @param @return
	* @return List<String>
	* @throws 
	*/
	List<String> getCenters(Integer type, String code);

}