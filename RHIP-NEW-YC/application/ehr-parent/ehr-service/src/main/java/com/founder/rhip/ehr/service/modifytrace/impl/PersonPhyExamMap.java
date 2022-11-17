package com.founder.rhip.ehr.service.modifytrace.impl;

import java.util.HashMap;
import java.util.Map;


/**
 * 比较器
 * @author donghong
 *
 */
public class PersonPhyExamMap {
	public static Map<String, Map<String,String>> phyExamMap = new HashMap<String, Map<String,String>>();
	
	static{
		Map<String, String> pfMap = new HashMap<>();
		pfMap.put("1", "正常");
		pfMap.put("2", "潮红");
		pfMap.put("3", "苍白");
		pfMap.put("4", "发绀");
		pfMap.put("5", "黄染");
		pfMap.put("6", "色素沉着");
		pfMap.put("7", "其他");
		phyExamMap.put("皮肤", pfMap);
		
		Map<String, String> gmMap = new HashMap<>();
		gmMap.put("1", "正常");
		gmMap.put("2", "黄染");
		gmMap.put("3", "充血");
		gmMap.put("4", "其他");
		phyExamMap.put("巩膜", gmMap);
		
		Map<String, String> lbjMap = new HashMap<>();
		lbjMap.put("1", "未触及");
		lbjMap.put("2", "锁上骨");
		lbjMap.put("3", "腋窝");
		lbjMap.put("4", "其他");
		phyExamMap.put("淋巴结", lbjMap);
		
		Map<String, String> lyMap = new HashMap<>();
		lyMap.put("1", "无");
		lyMap.put("2", "干罗音");
		lyMap.put("3", "湿罗音");
		lyMap.put("4", "其他");
		phyExamMap.put("罗音", lyMap);
		
		
	}
}
