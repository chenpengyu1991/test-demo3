/*
 * Copyright (c) 2010-2020 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 */
package com.founder.rhip.ehr.validator.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.founder.rhip.ehr.common.IDCardUtil;


/**
 * 
 * 
 * @version 1.0, 2014-5-15
 * @author Ye jianfei
 */

public class IdcardValidator implements ConstraintValidator<Idcard,String>{

	
	@Override
	public void initialize(Idcard constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean isValid = true;
		try {
			isValid = IDCardUtil.validateCard(value);

		} catch (Exception e) {
			isValid = false;
		}
		return isValid;
	}
}
