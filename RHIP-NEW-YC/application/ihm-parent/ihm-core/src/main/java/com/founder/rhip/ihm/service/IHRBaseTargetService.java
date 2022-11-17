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

/**
 * 医护人员统计
 * 
 * @author chen_wenbo
 *
 */
public interface IHRBaseTargetService {

	/**
	 * 统计医护人员
	 * 
	 * @Description: 
	 * @param organCode
	 * @param superOrganCode
	 * @param gbCode
	 * @return List<Map<String, Object>>
	 * @author chen_wenbo
	 */
	public List<Map<String, Object>> getHealthTargetList(String organCode, String superOrganCode, String gbCode, String genreCode);

    public List<Map<String, Object>> getPracticeList(String organCode, String superOrganCode, String gbCode, String genreCode);

	/**
	 * 统计从业分类
	 * @return
	 */
	public Map<String, Object> getStaffCyTypeDate();

}