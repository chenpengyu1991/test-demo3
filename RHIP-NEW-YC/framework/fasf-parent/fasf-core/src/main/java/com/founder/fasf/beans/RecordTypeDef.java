/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.beans;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;



/**
 * 
 * @author DenggaoLi
 * 
 */
public class RecordTypeDef {

	private List<String> fieldNames = new ArrayList<String>();

	public RecordTypeDef(Object object) {
		fieldNames = BeanUtil.getDynaProperties(object);
	}

	public void addFieldName(String fieldName) {
		fieldNames.add(fieldName);
	}

	public int fieldCount() {
		return fieldNames.size();
	}

	public List<String> getFieldNames() {
		return fieldNames;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("fieldNames", fieldNames).toString();
	}
}
