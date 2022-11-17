/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service.personal;

import java.util.List;
import java.util.Map;

import com.founder.rhip.ehr.dto.RecordCountDTO;
import com.founder.rhip.ehr.entity.basic.PersonDeathRecord;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfoAdditional;
import com.founder.rhip.ehr.entity.basic.PersonInfoTemp;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;


/**
 * The interface IPersonalRecordService.
 */
public interface IPersonalRecordService {
    /**
     * 查询个人档案列表
     *
     * @param criteria the criteria
     * @param page the page
     * @param order the order
     * @return person record list
     */
    public PageList<PersonInfo> getPersonRecordList(Criteria criteria, Page page, Order order);

    /**
     * 查询个人档案列表
     *
     * @param criteria the criteria
     * @return person record list
     */
    public List<PersonInfo> getPersonRecordList(Criteria criteria);

    /**
     * 查询个人档案
     *
     * @param criteria the criteria
     * @param properties the properties
     * @return person record
     */
    public PersonInfo getPersonRecord(Criteria criteria,String... properties);

    /**
     * 导出健康档案列表
     *
     * @return void
     */
    public void exportPersonalRecord();

    /**
     * 分类统计个人建档信息(待建档、待转入、已迁出、已注销、迁移中、待分配、已分配健康档案)
     *
     * @param organCode the organ code
     * @return RecordCountDTO record count dTO
     */
    public RecordCountDTO statisticPersonalRecord(String organCode);

    /**
     * 导出分类统计个人建档信息
     *
     * @param organCode the organ code
     * @return void
     */
    public void exportStatisticPersonalRecord(String organCode);

    /**
     * 二星及以上的完整率
     *
     * @return void
     */
    public void statisticIntactRateForTwoStar();

    /**
     * Gets person record temp list.
     *
     * @param criteria the criteria
     * @param page the page
     * @param order the order
     * @return the person record temp list
     */
    public PageList<PersonInfoTemp> getPersonRecordTempList(Criteria criteria,
			Page page, Order order);

    /**
     * Gets person info temp.
     *
     * @param criteria the criteria
     * @return the person info temp
     */
    public PersonInfoTemp getPersonInfoTemp(Criteria criteria);

    /**
     * Export person record list.
     *
     * @param page the page
     * @param criteria the criteria
     * @param order the order
     * @return the list
     */
    List<Map<String, Object>> exportPersonRecordList(Page page, Criteria criteria, Order order);

    /**
     * 查询死亡记录
     *
     * @param criteria the criteria
     * @param order the order
     * @param properites the properites
     * @return the list
     */
    List<PersonDeathRecord> getDeathPersonRecords(Criteria criteria,Order order,String... properites);

	public PageList<PersonInfo> queryPersonRecordList(Criteria criteria,
			Page buildPage, Order order);

    /**
     * 获取居民头像信息
     * @param idcard
     * @return
     */
    PersonInfoAdditional getPersonInfoAdditional(String idcard);
    
    /**
     * 获取居民头像信息的主键ID不用获取整条数据信息，用在调用的地方判断是否有头像
     */
    Long  getPersonInfoAdditionalId(String idcard);
}