/*
 * Copyright (c) 2010-2020 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 */


package com.founder.rhip.cic;

/**
 * 市民卡状态
 * @version 1.0, 2014-5-7
 */
public enum CicCardStatus {
	/**
	 * 正常
	 */
	NORMAL("00"),
	/**
	 * 挂失
	 */
	LOSS("01"),	
	/**
	 * 冻结
	 */
	FROZEN("02"),		
	/**
	 * 退卡
	 */
	RETURN("03"),
	/**
	 * 换卡
	 */
	CHANGE("04"),
	/**
	 * 补卡
	 */
	REISSUE("05");
   private String value;
   
   CicCardStatus(String value) {
        this.value = value;
    }

   public String getValue() {
       return this.value;
   }
}
