/*
 * Copyright (c) 2010-2020 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 */

package com.founder.rhip.ehr.validator.constraints;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Target;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import javax.validation.Constraint;
import javax.validation.Payload;


/**
 * 
 * 
 * @version 1.0, 2014-07-07
 * @author Ye jianfei
 */
@Target({FIELD,ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = DateCustomValidator.class)
@Documented
public @interface DateCustom {
	String message() default "";
	String pattern() default "yyyy/MM/dd HH:mm:ss";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};
}
