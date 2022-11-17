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
 * 疟疾状态
 * @version 1.0, 2013-2-26
 */
public enum MalariaStatus {
	/**
	 * 血检登记
	 */
	REGISTER(1),
	/**
	 * 排除
	 */
	ELIMINATION(2),
	/**
	 * 审核通过
	 */
	VERIFY(3),
	/**
	 * 个案已填写
	 */
	WRITE(4),
	/**
	 * 患者死亡，流程终止
	 */
	CURE(6);
   private Integer value;
   
   MalariaStatus(Integer value) {
        this.value = value;
    }

   public Integer getValue() {
       return this.value;
   }
}
