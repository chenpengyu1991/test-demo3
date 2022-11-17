package com.founder.rhip.ehr.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;


public class IntegrationQueryConditionUtils {
	
	/**
	 * 处理集成监控查询条件
	 * 
	 * @param paraMap 请求参数map
	 * @return
	 */
	public static Object[] processQueryCondition(Map<String, Object[]> paraMap) {
		Object[] objs = new Object[3];
		if (ObjectUtil.isNullOrEmpty(paraMap)) {
			return objs;
		}
		Object[] vs1 = paraMap.get("createBeginTime");
		Object[] vs2 = paraMap.get("createEndTime");
		Object[] vs3 = paraMap.get("organCode");
		Object v1 = null;
		Object v2 = null;
		Date beginDate = null;
		Date endDate = null;
		if (ObjectUtil.isNotEmpty(vs1) && ObjectUtil.isNotEmpty(v1 = vs1[0])) {
			beginDate = DateUtil.parseSimpleDate(String.valueOf(v1), "yyyy/MM/dd");
		}
		if (ObjectUtil.isNotEmpty(vs2) && ObjectUtil.isNotEmpty(v2 = vs2[0])) {
			endDate = DateUtil.parseSimpleDate(String.valueOf(v2), "yyyy/MM/dd");
		}
		List<Date> dateList = new ArrayList<>();
		if (ObjectUtil.isNullOrEmpty(beginDate) || ObjectUtil.isNullOrEmpty(endDate)) {
			// 默认一周
			Date currentDate = new Date();
			beginDate = DateUtil.getBeforeDay(currentDate, 7);
			dateList = getDateList(beginDate, 7);
		} else {
			int days = DateUtil.getBetweenDays(beginDate, endDate);
			dateList = getDateList(beginDate, days);
		}
		objs[0] = beginDate;
		objs[1] = dateList;
		objs[2] = vs3 == null ? null : vs3[0];
		
		return objs;
	}
	
	private static List<Date> getDateList(Date date, int day) {
		date = date == null ? new Date() : date;
		day = day == 0 ? 7 : day;
		List<Date> dateList = new ArrayList<>();
		for (int i = 0; i < day; i++) {
			Date di = DateUtil.getAfterDay(date, i);
			dateList.add(di);
		}
		return dateList;
	}
}
