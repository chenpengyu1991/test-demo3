/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.beans;

import com.founder.fasf.exception.BaseException;
import com.founder.fasf.util.ObjectUtil;

/**
 * Abstract superclass for all exceptions thrown in the beans package and
 * subpackages.
 * 
 * <p>
 * Note that this is a runtime (unchecked) exception. Beans exceptions are
 * usually fatal; there is no reason for them to be checked.
 * 
 * @author Rod Johnson
 * @author Juergen Hoeller
 */
public class BeansException extends BaseException {

	@SuppressWarnings("rawtypes")
	private Class beanClass;

	/**
	 * Fields .....
	 */
	private static final long serialVersionUID = -2258357294841304133L;

	/**
	 * Create a new BeansException with the specified message.
	 * 
	 * @param msg
	 *            the detail message
	 */
	public BeansException(String msg) {
		super(msg);
	}

	/**
	 * Create a new BeansException with the specified message and root cause.
	 * 
	 * @param msg
	 *            the detail message
	 * @param cause
	 *            the root cause
	 */
	public BeansException(String msg, Throwable cause) {
		super(msg, cause);
	}
	/**
	 * Create a new BeanInstantiationException.
	 * @param beanClass the offending bean class
	 * @param msg the detail message
	 */
	@SuppressWarnings("rawtypes")
	public BeansException(Class beanClass, String msg) {
		this(beanClass, msg, null);
	}
	@SuppressWarnings("rawtypes")
	public Class getBeanClass() {
		return beanClass;
	}

	/**
	 * Create a new BeanInstantiationException.
	 * @param beanClass the offending bean class
	 * @param msg the detail message
	 * @param cause the root cause
	 */
	@SuppressWarnings("rawtypes")
	public BeansException(Class beanClass, String msg, Throwable cause) {
		super("Could not instantiate bean class [" + beanClass.getName() + "]: " + msg, cause);
		this.beanClass = beanClass;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BeansException)) {
			return false;
		}
		BeansException otherBe = (BeansException) other;
		return (getMessage().equals(otherBe.getMessage()) && ObjectUtil.equals(getCause(), otherBe.getCause()));
	}

	@Override
	public int hashCode() {
		return getMessage().hashCode();
	}
}
