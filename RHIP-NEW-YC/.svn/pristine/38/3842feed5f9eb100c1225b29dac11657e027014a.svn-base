/*
 * Copyright (c) 2010-2020 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 */

package com.founder.rhip.idm.controller.leprosy;

import com.founder.rhip.idm.common.LeprosyStatus;

import java.util.HashMap;
import java.util.Map;


/**
 * 根据结核病状态获取响应页面地址
 * 
 * @version 1.0, 2013-3-18
 */
public class LeprosyLayoutMap {
	private static Map<Integer, String> LayoutMap = new HashMap<Integer, String>();
	
	public static String getLayoutStr(Integer key){
		if(LayoutMap.size() == 0){
			initLayout();
		}
		return LayoutMap.get(key);
	}
	
	private static void initLayout(){
		LayoutMap.put(LeprosyStatus.SUSPECTED.getValue(),"rhip.idm.leprosy.suspected.add");//疑似上报
		LayoutMap.put(LeprosyStatus.CASE.getValue(),"rhip.idm.leprosy.case.add");//个案
		LayoutMap.put(LeprosyStatus.FOLLOWUP.getValue(),"rhip.idm.leprosy.followups");//个案随访观察
	}
}
