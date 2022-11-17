/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.reflect;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.founder.fasf.util.StringUtil;

// import org.springframework.core.BridgeMethodResolver;
// import org.springframework.core.GenericTypeResolver;
// import org.springframework.core.MethodParameter;
/*
 * import org.springframework.util.ClassUtils; import
 * org.springframework.util.StringUtils;
 */
/**
 * Extension of the standard JavaBeans PropertyDescriptor class, overriding
 * <code>getPropertyType()</code> such that a generically declared type will be
 * resolved against the containing bean class.
 * 
 * @author Juergen Hoeller
 * @since 2.5.2
 */
class GenericTypeAwarePropertyDescriptor extends PropertyDescriptor {

	private final Class<?> beanClass;

	private final Method readMethod;

	private final Method writeMethod;

	private final Class<?> propertyEditorClass;

	private volatile Set<Method> ambiguousWriteMethods;

	private Class<?> propertyType;

	private MethodParameter writeMethodParameter;

	public GenericTypeAwarePropertyDescriptor(Class<?> beanClass, String propertyName, Method readMethod, Method writeMethod, Class<?> propertyEditorClass) throws IntrospectionException {
		super(propertyName, null, null);
		this.beanClass = beanClass;
		this.propertyEditorClass = propertyEditorClass;
		Method readMethodToUse = BridgeMethodResolver.findBridgedMethod(readMethod);
		Method writeMethodToUse = BridgeMethodResolver.findBridgedMethod(writeMethod);
		if ((writeMethodToUse == null) && (readMethodToUse != null)) {
			// Fallback: Original JavaBeans introspection might not have found
			// matching setter
			// method due to lack of bridge method resolution, in case of the
			// getter using a
			// covariant return type whereas the setter is defined for the
			// concrete property type.
			writeMethodToUse = ReflectUtil.getMethodIfAvailable(this.beanClass, "set" + StringUtil.capitalize(getName()), readMethodToUse.getReturnType());
		}
		this.readMethod = readMethodToUse;
		this.writeMethod = writeMethodToUse;
		if ((this.writeMethod != null) && (this.readMethod == null)) {
			// Write method not matched against read method: potentially
			// ambiguous through
			// several overloaded variants, in which case an arbitrary winner
			// has been chosen
			// by the JDK's JavaBeans Introspector...
			Set<Method> ambiguousCandidates = new HashSet<Method>();
			for (Method method : beanClass.getMethods()) {
				if (method.getName().equals(writeMethodToUse.getName()) && !method.equals(writeMethodToUse) && !method.isBridge()) {
					ambiguousCandidates.add(method);
				}
			}
			if (!ambiguousCandidates.isEmpty()) {
				ambiguousWriteMethods = ambiguousCandidates;
			}
		}
	}

	@Override
	public Class<?> getPropertyEditorClass() {
		return propertyEditorClass;
	}

	@Override
	public synchronized Class<?> getPropertyType() {
		if (propertyType == null) {
			if (readMethod != null) {
				propertyType = GenericTypeResolver.resolveReturnType(readMethod, beanClass);
			} else {
				MethodParameter writeMethodParam = getWriteMethodParameter();
				if (writeMethodParam != null) {
					propertyType = writeMethodParam.getParameterType();
				} else {
					propertyType = super.getPropertyType();
				}
			}
		}
		return propertyType;
	}

	@Override
	public Method getReadMethod() {
		return readMethod;
	}

	@Override
	public Method getWriteMethod() {
		return writeMethod;
	}

	public Method getWriteMethodForActualAccess() {
		Set<Method> ambiguousCandidates = ambiguousWriteMethods;
		if (ambiguousCandidates != null) {
			ambiguousWriteMethods = null;
			Logger.getLogger(GenericTypeAwarePropertyDescriptor.class).warn(
					"Invalid JavaBean property '" + getName() + "' being accessed! Ambiguous write methods found next to actually used [" + writeMethod + "]: "
							+ ambiguousCandidates);
		}
		return writeMethod;
	}

	public synchronized MethodParameter getWriteMethodParameter() {
		if (writeMethod == null) {
			return null;
		}
		if (writeMethodParameter == null) {
			writeMethodParameter = new MethodParameter(writeMethod, 0);
			GenericTypeResolver.resolveParameterType(writeMethodParameter, beanClass);
		}
		return writeMethodParameter;
	}
}
