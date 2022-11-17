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
 * 血吸虫病状态
 * @version 1.0, 2013-5-24
 */
public enum SchStatus {
	/**
	 * 待核实(乡镇卫生院体检中心提交)
	 */
	REGISTER_DOCTOR(11),
	/**
	 * 待核实(防保科提交)
	 */
	REGISTER_SQZX(12),	
	/**
	 * 待核实(疾控体检中心提交)
	 */
	REGISTER_JKTJZX(13),
	/**
	 * 待核实(卫生院检验科提交)
	 */
	REGISTER_WSYJYK(14),	
	/**
	 * 排除
	 */
	ELIMINATION(2),
	/**
	 * 防保科审核通过
	 */
	FBK_VERIFY(3),
	/**
	 * 疾控审核通过
	 */
	JK_VERIFY(4),	
	/**
	 * 个案已填写
	 */
	WRITE(5),
	/**
	 * 患者治愈，流程终止
	 */
	CURE(6);
   private Integer value;
   
   SchStatus(Integer value) {
        this.value = value;
    }

   public Integer getValue() {
       return this.value;
   }
}
