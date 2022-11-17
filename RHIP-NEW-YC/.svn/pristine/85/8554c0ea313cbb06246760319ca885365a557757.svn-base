/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service.report;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.*;
import com.founder.rhip.ehr.entity.report.RpWeightSet;

public interface IRpWeightSetService {


	/**
	 * 查询所有
	 * @return      PageList<RpWeightSet>
	 */
	PageList<RpWeightSet> getWeightSets(Page page, Criteria criteria);

	/**
	 * 根据条件查询一条数据
	 * @param criteria
	 * @return
	 */
	RpWeightSet getRpWeightSet(Criteria criteria);
	
	/**
	 * 根据机构 类型和时间的查取表中的数据 只有一段时间在此时间段的也算
	 * @param organCode
	 * @param weightIndex
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public List<RpWeightSet> getWeightSets(String gbCode, String organCode, String weightIndex, Date beginDate, Date endDate);
	
	public int insertRpWeightSet(RpWeightSet rpWeightSet);
	
	public int updateRpWeightSet(RpWeightSet rpWeightSet);

	/**
	 * 删除权重设置内容功能
	 * @param criteria
	 * @return
	 */
	public int deletWeightSets(Criteria criteria);

	/**
	 * 个人绩效模拟(查询页面)
	 * @param organCode
	 * @param rpType
	 * @param weightIndex
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public List<Map<String, Object>> getStaffRpPaList(String organCode, String rpType, String weightIndex, String weightIndexColumn, String beginDate, String endDate);
}