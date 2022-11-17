package com.founder.rhip.he.common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.PropertyMetadata;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;

/**
 * Criteria查询条件组织
 * 
 * @author GaoFei
 *
 */
public class CriteriaOrganizer {
	
	/**
	 * 用map参数值初始化查询条件Criteria,适用于无自定义SQL语句查询
	 * 
	 * @param map 请求传递的参数
	 * @param clazz
	 * @param timeColumnName
	 * @return
	 */
	public static Criteria initCriteria(Map<String, Object[]> map, Class<?> clazz, String timeColumnName) {
		Criteria criteria = new Criteria();
		// 组织时间查询条件
		organizeDateCondition(map, criteria, timeColumnName);
		List<String> fields = getFields(clazz);
		for (String key : map.keySet()) {
			Object[] values = null;
			Object value = null;
			if (ObjectUtil.isNullOrEmpty(key) || !fields.contains(key) || ObjectUtil.isNullOrEmpty(values = map.get(key)) || ObjectUtil.isNullOrEmpty(value = values[0])) {
				continue;
			}
			criteria.add(key, value);
		}
		return criteria;
	}
	
	/**
	 * 用map参数值初始化查询条件Criteria,适用于有自定义SQL语句查询
	 * 
	 * @param map 请求传递的参数
	 * @return
	 */
	public static Criteria initCriteriaCondition(Map<String, Object[]> map) {
		Criteria criteria = new Criteria();
		for (String key : map.keySet()) {
			Object[] values = null;
			Object value = null;
			if (ObjectUtil.isNullOrEmpty(key) || ObjectUtil.isNullOrEmpty(values = map.get(key))
					|| ObjectUtil.isNullOrEmpty(value = values[0])) {
				continue;
			}
			criteria.add(key, value);
		}
		return criteria;
	}
	
	/**
	 * 组织时间类型的查询条件
	 * 
	 * @param map 请求传递的参数
	 * @param criteria 查询条件对象
	 * @param timeColumnName 时间字段名称，如果所在的表有别名一起加上
	 */
	private static void organizeDateCondition(Map<String, Object[]> map, Criteria criteria, String timeColumnName) {
		if (ObjectUtil.isNullOrEmpty(map) || ObjectUtil.isNullOrEmpty(timeColumnName)) {
			return;
		}
		
		Object[] vs1 = map.get("createBeginTime");
		Object[] vs2 = map.get("createEndTime");
		Object[] vs3 = map.get("positionYear"); // 宣传阵地年份yyyy
		Object v1 = null;
		Object v2 = null;
		Object v3 = null;
		Date beginDate = null;
		Date endDate = null;
		if (ObjectUtil.isNotEmpty(vs1) && ObjectUtil.isNotEmpty(v1 = vs1[0])) {
			beginDate = DateUtil.parseSimpleDate(String.valueOf(v1), "yyyy/MM/dd");
		}
		if (ObjectUtil.isNotEmpty(vs2) && ObjectUtil.isNotEmpty(v2 = vs2[0])) {
			endDate = DateUtil.parseSimpleDate(String.valueOf(v2), "yyyy/MM/dd");
		}
		if (ObjectUtil.isNotEmpty(vs3) && ObjectUtil.isNotEmpty(v3 = vs3[0])) {
			Calendar bDate = Calendar.getInstance();
			bDate.set(Calendar.YEAR, Integer.parseInt(String.valueOf(v3)));
			bDate.set(Calendar.MONTH, Calendar.JANUARY);
			bDate.set(Calendar.DAY_OF_MONTH, 1);
			makeTimeToZero(bDate);
			Calendar eDate = Calendar.getInstance();
			eDate.set(Calendar.YEAR, Integer.parseInt(String.valueOf(v3)));
			eDate.set(Calendar.MONTH, Calendar.DECEMBER);
			eDate.set(Calendar.DAY_OF_MONTH, 31);
			makeTimeToZero(eDate);
			criteria.add("resourceRecordTime", OP.BETWEEN, new Date[] {bDate.getTime(), eDate.getTime()});
		}
		DateUtil.getCriteriaByDateRange(criteria, timeColumnName, beginDate, endDate);
	}
	
	private static void makeTimeToZero(Calendar calendar) {
		if (calendar == null) {
			return;
		}
		calendar.set(Calendar.HOUR,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MILLISECOND,0);
		calendar.set(Calendar.AM_PM,0);
	}
	
	/**
	 * 获取某个类的所有字段
	 * @param clazz
	 * @return
	 */
	private static List<String> getFields(Class<?> clazz) {
		List<String> fields = new ArrayList<String>();
		if (ObjectUtil.isNotEmpty(clazz)) {
			ClassMetadata classMetadata = ClassMetadata.getMetadata(clazz);
			LinkedHashMap<String, PropertyMetadata> propertyMetada = classMetadata.getProperty();
			for (Iterator<String> iterator = propertyMetada.keySet().iterator(); iterator.hasNext();) {
				String field = iterator.next();
				if (ObjectUtil.isNullOrEmpty(field)) {
					continue;
				}
				fields.add(field);
			}
		}
		return fields;
	}
}
