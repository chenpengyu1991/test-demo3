/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.dto.DoctorSignCensus;
import com.founder.rhip.ehr.dto.FamilyRecordDTO;
import com.founder.rhip.ehr.dto.FamilyStatisticDto;
import com.founder.rhip.ehr.entity.basic.FamilyCanceledInfo;
import com.founder.rhip.ehr.entity.basic.FamilyInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfo;

public interface IFamilyRecordService {

    /**
     * 创建家庭档案
     *
     * @param familyRecordDTO
     * @return boolean
     */
    String createFamilyRecord(FamilyRecordDTO familyRecordDTO);

    /**
     * 获取家庭档案列表
     *
     * @param criteria
     * @return FamilyRecordDTO
     */
    PageList<FamilyInfo> getFamilyRecord(Page page, Criteria criteria, Order order);

    /**
     * 根据FamilyInfo对象取得家庭档案对象
     *
     * @param familyInfo
     * @return
     */
    public FamilyRecordDTO getFamilyRecord(FamilyInfo familyInfo);

    /**
     * 获取未注册的个人列表
     *
     * @param ca
     * @param ids
     * @param page
     * @param criteria 
     * @return
     */
    public PageList<PersonInfo> getUnRegRecordPersonList(PersonInfo personInfo, List<Long> ids, Page page, Criteria criteria);

    /**
     * 注销家庭
     *
     * @param familyId
     * @return
     */
    public Integer cancelFamilyRecord(int status, FamilyCanceledInfo familyCanceledInfo);

    /**
     * 审核
     *
     * @param familyId
     * @return
     */
    public Integer approveCancelFamily(int status, FamilyCanceledInfo familyCanceledInfo);

    public FamilyCanceledInfo getCancelFamilyRecord(Criteria criteria);
    
    /**
     * 获取注销家庭档案列表
     * @param criteria
     * @return
     */
    public List<FamilyCanceledInfo> getFamilies(Criteria criteria, Order order);
    
    /**
     * 简单得到家庭档案
     * @param criteria
     * @return
     */
    public FamilyInfo getFamilyInfo(Criteria criteria);
    
    /**
     * 简单更新家庭档案
     * @return
     */
    public boolean updateFamilyInfo(FamilyInfo familyInfo, String... properties);


    List<FamilyStatisticDto> getFamilyDtoList(Criteria criteria);

}