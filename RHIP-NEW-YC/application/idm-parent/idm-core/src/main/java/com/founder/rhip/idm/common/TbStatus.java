/*
 * Copyright (c) 2010-2020 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 */


package com.founder.rhip.idm.common;

/**
 * 麻风状态
 * @version 1.0, 2013-2-26
 */
public enum TbStatus {
	
	/*推荐单*/
	RECOMMENDATION(1),
	
	/*筛查登记*/
	REGISTER(2),
	
	/*转诊*/
	TRANSFERTREAT(3),
	
	/*诊断*/
	DIAGNOSIS(11),
	
	/*专用病历*/
	DCMR(4),
	
	/*管理卡*/
	TREATMENT(5),
	
	/*已分派*/
	ASSIGN(6),
	
	/*已接受*/
	ACCEPT(7),
	
	/*已退回*/
	RETURN(8),
	
	/*已作废*/
	CANCEL(9),

	/*已停止管理*/
	STOP(10),
	
	/*重新分派*/
	REASSIGN(11);
	
   private Integer value;
   
   TbStatus(Integer value) {
        this.value = value;
    }

   public Integer getValue() {
       return this.value;
   }
}
