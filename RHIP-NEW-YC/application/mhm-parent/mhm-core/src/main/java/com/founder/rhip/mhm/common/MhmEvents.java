/*
 * Copyright (c) 2010-2020 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 */


package com.founder.rhip.mhm.common;

/**
 * 精神卫生事件
 * @version 1.0, 2013-8-12
 */
public enum MhmEvents {

	/**
	 * 线索登记
	 */
	M_CLUE(1001),
	/**
	 * 规范管理-基本档案
	 */
	M_ARCHIVES(2001),
	/**
	 * 规范管理-出院信息(集成)
	 */
	I_DISCHARGED(2002),
	/**
	 * 规范管理-随访记录
	 */
	M_FOLLOWUP(2003),
	/**
	 * 规范管理-失访信息
	 */
	M_LOST_FOLLOWUP(2004),
    /**
     * 规范管理-个案管理计划
     */
	M_CASE_PLAN(2005),
    /**
     * 规范管理-效果评估
     */
	M_EVALUATION(2006),
    /**
     * 规范管理-应急处置
     */
	M_EMERGENCY(2007),   
    /**
     * 规范管理-转诊信息
     */
	M_REFERRAL(2009),
    /**
     * 规范管理-转诊信息
     */
    M_HEALTH_CHECK(2010),
    /**
     * 集成数据-门诊数据
     */
	I_OUTPATIENT(3001);

   private Integer value;

   MhmEvents(Integer value) {
        this.value = value;
    }

   public Integer getValue() {
       return this.value;
   }
}
