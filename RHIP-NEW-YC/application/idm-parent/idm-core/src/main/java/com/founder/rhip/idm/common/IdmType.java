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
public enum IdmType {
	/**
	 * 法定传染病：上报、个案
	 */
	LEGAL("1"),
	/**
	 * 结核病专项
	 */
	TB("2"),
	/**
	 * 疟疾专项
	 */
	MALARIA("3"),
	/**
	 * 血吸虫专项
	 */
	SCHISTOSOME("4"),
    /**
     * 丝虫病
     */
    FILARIASIS("5"),
	/**
	 * 麻风专项
	 */
	LEPROSY("6"),
	
	/**
	 * 血吸虫专项-个案
	 */
	SCHISTOSOME_CASE("41"),
	/**
	 * 血吸虫专项-晚血历史数据导入
	 */
	SCHISTOSOME_ADVANCED_IMPORT("42");		
  private String value;   
   
   IdmType(String value) {
        this.value = value;
    }

   public String getValue() {
       return this.value;
   }
}
