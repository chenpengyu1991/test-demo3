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

import java.util.List;
import java.util.Map;

/**
 * 病案首页
 */
public interface IImrService {

    /**
     *病案首页的费用 结果页面
     * @param beginDate
     * @param endDate
     * @param genreCode
     * @param gbCode
     * @param parentCode
     * @param organCode
     * @return
     */
	public List<Map<String, Object>> getImrFeeList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode);

    /**
     *手术切口 结果页面
     * @param beginDate
     * @param endDate
     * @param genreCode
     * @param gbCode
     * @param parentCode
     * @param organCode
     * @return
     */
    public List<Map<String, Object>> getIncisionList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode);

    /**
     *诊断符合率分析 结果页面
     * @param beginDate
     * @param endDate
     * @param genreCode
     * @param gbCode
     * @param parentCode
     * @param organCode
     * @return
     */
    public List<Map<String, Object>> getConsistencyList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode);

}