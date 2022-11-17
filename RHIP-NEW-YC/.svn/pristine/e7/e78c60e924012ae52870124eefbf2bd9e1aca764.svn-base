/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service.personal;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.entity.basic.PersonCanceledInfo;

import java.util.List;
import java.util.Map;

public interface IPersonCanceledService {
    /**
     * 查询个人档案列表
     *
     * @param criteria
     * @return
     */
    public PageList<PersonCanceledInfo> getPersonCanceledList(Criteria criteria, Page page, Order order);

    /**
     * 注销个人档案信息
     *
     * @param personCanceledInfo
     */
    //public PersonCanceledInfo offPersonCanceled(IValidateDTO personCanceledInfo);
    public int offPersonCanceled(String status, PersonCanceledInfo personCanceledInfo);

    public Integer approveCancelPerson(String status, PersonCanceledInfo personCanceledInfo);

    public List<PersonCanceledInfo> getCancelPersonRecords(Criteria criteria, Order order);

    public void cancelPersonByIdcard(String idcard);
    
    public String cancelPersonByIdcard(CurrentLoginInfo loginInfo, String ip);
    
    public PageList<PersonCanceledInfo> getCancelPersonRecordPageList(Criteria criteria, Page page, Order order);
    
    /**
	 * 获取档案注销的详情
	 * @param criteria
	 * @return
	 */
	public PersonCanceledInfo getPersonCanceledInfo(Criteria criteria);

	public List<Map<String, Object>> exportCancelPersonRecordList(Page page,
                                                                  Criteria criteria, Order order);
}