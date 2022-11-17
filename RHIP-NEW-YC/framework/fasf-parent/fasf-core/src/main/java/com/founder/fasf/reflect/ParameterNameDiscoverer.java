/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Interface to discover parameter names for methods and constructors.
 * 
 * <p>
 * Parameter name discovery is not always possible, but various strategies are
 * available to try, such as looking for debug information that may have been
 * emitted at compile time, and looking for argname annotation values optionally
 * accompanying AspectJ annotated methods.
 * 
 * @author Rod Johnson
 * @author Adrian Colyer
 * @since 2.0
 */
public interface ParameterNameDiscoverer {

	/**
	 * Return parameter names for this constructor, or <code>null</code> if they
	 * cannot be determined.
	 * 
	 * @param ctor
	 *            constructor to find parameter names for
	 * @return an array of parameter names if the names can be resolved, or
	 *         <code>null</code> if they cannot
	 */
	@SuppressWarnings("rawtypes")
	String[] getParameterNames(Constructor ctor);

	/**
	 * Return parameter names for this method, or <code>null</code> if they
	 * cannot be determined.
	 * 
	 * @param method
	 *            method to find parameter names for
	 * @return an array of parameter names if the names can be resolved, or
	 *         <code>null</code> if they cannot
	 */
	String[] getParameterNames(Method method);
}
