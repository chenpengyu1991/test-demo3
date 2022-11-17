/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service.check;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.dcConfig.DcParam;

import java.util.List;

/**
 * 重复检验...参数配置
 *
 * @version 1.0, 2016-05-03
 * @author Cary
 */
public interface IDcConfigService {

    /**
     * 参数保存
     * @param dcParams
     * @return
     */
    public void saveDcParam(List<DcParam> dcParams) ;

    public void saveDcParam(DcParam dcParams);

    public PageList<DcParam> getDcParamList(Page page, Criteria criteria);

    public DcParam getDcParam(Criteria criteria);

    public int delete(Criteria criteria);

}