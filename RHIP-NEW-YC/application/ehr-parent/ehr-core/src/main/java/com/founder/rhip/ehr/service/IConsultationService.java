/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.clinic.ConsultationInfo;

public interface IConsultationService {


    /**
     * 查询会诊数据
     * @param criteria
     * @param page
     * @return
     */
    public PageList<ConsultationInfo> getConsultationInfoList(Criteria criteria, Page page);
    
   
    /**
     * 查看会诊信息详细
     * @param criteria
     * @return
     */
    public ConsultationInfo getConsultationInfo(Criteria criteria);

   

}