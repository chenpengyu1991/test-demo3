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
public enum FilStatus {
	/**
     * 监测登记
     */
	REGISTER(1),
	/**
	 * 个案已填写
	 */
	CASE(2),
	/**
     * 随访
     */
	VISIT(3),
    /**
     * 工作督导
     */
    SC(4);
   private Integer value;

   FilStatus(Integer value) {
        this.value = value;
    }

   public Integer getValue() {
       return this.value;
   }
}
