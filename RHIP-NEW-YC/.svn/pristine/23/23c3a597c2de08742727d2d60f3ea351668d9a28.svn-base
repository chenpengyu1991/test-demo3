/*
 * Copyright (c) 2010-2020 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 */
package com.founder.rhip.ehr.validator.constraints;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;



/**
 * 
 * 
 * @version 1.0, 2014-07-07
 * @author Ye jianfei
 */

public class DateCustomValidator implements ConstraintValidator<DateCustom,String>{

	private String pattern;
	
	@Override
	public void initialize(DateCustom constraintAnnotation) {
		this.pattern = constraintAnnotation.pattern();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean isValid = true;
		Date result = null;
		if(StringUtil.isNotEmpty(value)){
			try {
				result = DateUtil.parseSimpleDate(pattern, value);
				if(ObjectUtil.isNullOrEmpty(result)){
					isValid = false;
				}
			} catch (Exception e) {
				isValid = false;
			}
		}
		return isValid;
	}
}
