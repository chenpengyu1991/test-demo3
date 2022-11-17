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
 * 精神卫生管理状态
 * @version 1.0, 2013-8-13
 */
public enum MhmStatus {
	/**
	 * 未审核
	 */
	SUBMIT(0),
	/**
	 * 中心审核
	 */
	VERIFY_SQZX(1),	
	/**
	 * 诊断确诊
	 */
	VERIFY_DIAGNOSIS(2),		
	/**
	 * 复核确诊
	 */
	VERIFY_CHECK(3),
	/**
	 * 管理
	 */
	MANAGEMENT(4),
	/**
	 * 不通过
	 */
	ELIMINATION(5),	
	/**
	 * 诊断排除
	 */
	ELIMINATION_DIAGNOSIS(6),
	/**
	 * 复核排除
	 */
	ELIMINATION_CHECK(7),
    /**
     * 建档未管理
     */
    NO_MANAGEMENT(8),
    /**
     * 死亡
     */
	DEAD(9);
   private Integer value;
   
   MhmStatus(Integer value) {
        this.value = value;
    }

   public Integer getValue() {
       return this.value;
   }
}
