/*
 * Copyright (c) 2010-2020 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 */

package com.founder.rhip.idm.controller.tb;

import com.founder.rhip.idm.common.TbStatus;

import java.util.HashMap;
import java.util.Map;


/**
 * 根据结核病状态获取响应页面地址
 * 
 * @version 1.0, 2013-3-18
 */
public class TbLayoutMap {
	private static Map<Integer, String> LayoutMap = new HashMap<Integer, String>();
	
	public static String getLayoutStr(Integer key){
		if(LayoutMap.size() == 0){
			initLayout();
		}
		return LayoutMap.get(key);
	}
	
	private static void initLayout(){
		LayoutMap.put(TbStatus.RECOMMENDATION.getValue(),"rhip.idm.recommendation.add");//推荐单
		LayoutMap.put(TbStatus.REGISTER.getValue(),"rhip.idm.register.add");//筛查
		LayoutMap.put(TbStatus.TRANSFERTREAT.getValue(),"rhip.idm.transfertreat.add");//转诊
		LayoutMap.put(TbStatus.DIAGNOSIS.getValue(),"rhip.idm.diagnosis.add");//确诊页面
		LayoutMap.put(TbStatus.DCMR.getValue(),"rhip.idm.dcmr.add");//专用病历
		LayoutMap.put(TbStatus.TREATMENT.getValue(),"rhip.idm.treatment.add");//治疗管理卡
	}
}
