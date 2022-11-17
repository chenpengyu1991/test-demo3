/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.entity.clinic.BrwAnonymousSet;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IBrwAnonymousSetService {

    List<BrwAnonymousSet> getBrwAnonymousSets(Criteria criteria);

    /**
     * 保存设置
     * @param brwAnonymousSet
     */
    void save(BrwAnonymousSet brwAnonymousSet);

    /**
     * 批量保存
     * @param request
     * @param roleNames
     */
    void saveBath(HttpServletRequest request, String roleNames);

        /**
         * 删除设置
         * @param brwAnonymousSet
         */
    void delete(BrwAnonymousSet brwAnonymousSet);

}