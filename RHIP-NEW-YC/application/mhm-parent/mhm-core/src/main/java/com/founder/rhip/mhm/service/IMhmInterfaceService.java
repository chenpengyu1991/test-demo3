/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.mhm.service;

import com.founder.rhip.ehr.entity.basic.PersonInfo;


public interface IMhmInterfaceService {

	/**
	 * 获取患者信息
	 * @param       String
	 * @param       String
	 * @return      PersonInfo
	 */
	public PersonInfo queryPersonalInfo(String personName, String idCard);

	/**
	 * 更新患者信息
	 * @param       personInfo
	 * @param       String...
	 * @return      String
	 */
	public String updatePersonInfo(PersonInfo personInfo,String...param);
}