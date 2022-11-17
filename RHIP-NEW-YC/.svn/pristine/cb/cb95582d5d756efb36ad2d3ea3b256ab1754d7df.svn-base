/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. You
 * shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.util;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Criterion;
import com.founder.fasf.beans.Record;

public final class RecordUtil {

	public static Criteria recordToCriteria(Record record) {
		Criteria criteria = new Criteria();
		Map<String, Object> map = record.getMap();
		for (String name : map.keySet()) {
			criteria.add(name, map.get(name));
		}
		return criteria;
	}

	public static Record CriteriaToRecord(Criteria criteria, Class<?> clazz) throws Exception {
		Record record;
		try {
			record = new Record(clazz.newInstance());
			List<Criterion>  criterionList= criteria.getCriteria();
			for (Criterion criterion : criterionList) {
				record.set(criterion.getName(), criterion.getValue());
			}
			return record;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
	}
	public static Record CriteriaToRecord(Criteria criteria) {
		Record record=new Record();
		for(Criterion criterion:criteria.getCriteria()){
			if(StringUtil.isNotEmpty(criterion.getName())){
				record.set(criterion.getName(),criterion.getValue() );
			}
		}
		return record;
	}
}