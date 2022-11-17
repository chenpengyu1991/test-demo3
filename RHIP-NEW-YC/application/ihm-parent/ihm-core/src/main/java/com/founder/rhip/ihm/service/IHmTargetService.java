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

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;

/**
 * 老年人保健
 * 
 * 
 * @version 1.0, 2014-4-16
 * @author Ye jianfei
 */
public interface IHmTargetService {
	
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
	public List<Map<String, Object>> getTargetList(Integer examYear,String genreCode,String gbCode,String parentCode);

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
	public List<Map<String, Object>> getRateList(Integer examYear,String genreCode,String gbCode,String parentCode,String organCode);
	
	/**
	 * 体检人次月、季、年统计表
	 *
	 * @param examYear
	 * @param genreCode
	 * @param gbCode
	 * @param parentCode
	 * @param organCode
	 * @return
	 * @author Ye jianfei
	 */
	public List<Map<String, Object>> getPersonTimeList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode);
}