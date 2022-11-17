/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;


public interface IMsTrigerService {
    /**
     * 根据ehr_id区分是住院还是门诊来填充op_em_hp_mark
     * EHR_ID门诊是mz开头的
     * zy开头的是住院
     * 急诊的活动号也是mz 
     * 1:急诊 0:普通门诊 2：住院
     */
	public void updateMsMark();
}