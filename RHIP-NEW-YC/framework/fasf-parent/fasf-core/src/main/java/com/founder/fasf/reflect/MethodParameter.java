/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

import com.founder.fasf.util.Assert;

/**
 * Helper class that encapsulates the specification of a method parameter, i.e.
 * a Method or Constructor plus a parameter index and a nested type index for a
 * declared generic type. Useful as a specification object to pass along.
 * 
 * @author Juergen Hoeller
 * @author Rob Harrop
 * @author Andy Clement
 * @since 2.0
 * @see GenericCollectionTypeResolver
 */
public class MethodParameter {

	/**
	 * Create a new MethodParameter for the given method or constructor.
	 * <p>
	 * This is a convenience constructor for scenarios where a Method or
	 * Constructor reference is treated in a generic fashion.
	 * 
	 * @param methodOrConstructor
	 *            the Method or Constructor to specify a parameter for
	 * @param parameterIndex
	 *            the index of the parameter
	 * @return the corresponding MethodParameter instance
	 */
	public static MethodParameter forMethodOrConstructor(
			Object methodOrConstructor, int parameterIndex) {
		if (methodOrConstructor instanceof Method) {
			return new MethodParameter((Method) methodOrConstructor,
					parameterIndex);
		} else if (methodOrConstructor instanceof Constructor) {
			return new MethodParameter((Constructor<?>) methodOrConstructor,
					parameterIndex);
		} else {
			throw new IllegalArgumentException("Given object ["
					+ methodOrConstructor
					+ "] is neither a Method nor a Constructor");
		}
	}

	private Method method;

	private Constructor<?> constructor;

	private final int parameterIndex;

	private Class<?> parameterType;

	private Type genericParameterType;

	private Annotation[] parameterAnnotations;

	private ParameterNameDiscoverer parameterNameDiscoverer;

	private String parameterName;

	private int nestingLevel = 1;

	/** Map from Integer level to Integer type index */
	private Map<Integer, Integer> typeIndexesPerLevel;

	Map<TypeVariable<?>, Type> typeVariableMap;

	/**
	 * Create a new MethodParameter for the given constructor, with nesting
	 * level 1.
	 * 
	 * @param constructor
	 *            the Constructor to specify a parameter for
	 * @param parameterIndex
	 *            the index of the parameter
	 */
	public MethodParameter(Constructor<?> constructor, int parameterIndex) {
		this(constructor, parameterIndex, 1);
	}

	/**
	 * Create a new MethodParameter for the given constructor.
	 * 
	 * @param constructor
	 *            the Constructor to specify a parameter for
	 * @param parameterIndex
	 *            the index of the parameter
	 * @param nestingLevel
	 *            the nesting level of the target type (typically 1; e.g. in
	 *            case of a List of Lists, 1 would indicate the nested List,
	 *            whereas 2 would indicate the element of the nested List)
	 */
	public MethodParameter(Constructor<?> constructor, int parameterIndex,
			int nestingLevel) {
		Assert.notNull(constructor, "Constructor must not be null");
		this.constructor = constructor;
		this.parameterIndex = parameterIndex;
		this.nestingLevel = nestingLevel;
	}

	/**
	 * Create a new MethodParameter for the given method, with nesting level 1.
	 * 
	 * @param method
	 *            the Method to specify a parameter for
	 * @param parameterIndex
	 *            the index of the parameter
	 */
	public MethodParameter(Method method, int parameterIndex) {
		this(method, parameterIndex, 1);
	}

	/**
	 * Create a new MethodParameter for the given method.
	 * 
	 * @param method
	 *            the Method to specify a parameter for
	 * @param parameterIndex
	 *            the index of the parameter (-1 for the method return type; 0
	 *            for the first method parameter, 1 for the second method
	 *            parameter, etc)
	 * @param nestingLevel
	 *            the nesting level of the target type (typically 1; e.g. in
	 *            case of a List of Lists, 1 would indicate the nested List,
	 *            whereas 2 would indicate the element of the nested List)
	 */
	public MethodParameter(Method method, int parameterIndex, int nestingLevel) {
		Assert.notNull(method, "Method must not be null");
		this.method = method;
		this.parameterIndex = parameterIndex;
		this.nestingLevel = nestingLevel;
	}

	/**
	 * Copy constructor, resulting in an independent MethodParameter object
	 * based on the same metadata and cache state that the original object was
	 * in.
	 * 
	 * @param original
	 *            the original MethodParameter object to copy from
	 */
	public MethodParameter(MethodParameter original) {
		Assert.notNull(original, "Original must not be null");
		method = original.method;
		constructor = original.constructor;
		parameterIndex = original.parameterIndex;
		parameterType = original.parameterType;
		parameterAnnotations = original.parameterAnnotations;
		typeVariableMap = original.typeVariableMap;
	}

	/**
	 * Decrease this parameter's nesting level.
	 * 
	 * @see #getNestingLevel()
	 */
	public void decreaseNestingLevel() {
		getTypeIndexesPerLevel().remove(nestingLevel);
		nestingLevel--;
	}

	/**
	 * Return the wrapped Constructor, if any.
	 * <p>
	 * Note: Either Method or Constructor is available.
	 * 
	 * @return the Constructor, or <code>null</code> if none
	 */
	public Constructor<?> getConstructor() {
		return constructor;
	}

	/**
	 * Return the class that declares the underlying Method or Constructor.
	 */
	public Class<?> getDeclaringClass() {
		return (method != null ? method.getDeclaringClass() : constructor
				.getDeclaringClass());
	}

	/**
	 * Return the generic type of the method/constructor parameter.
	 * 
	 * @return the parameter type (never <code>null</code>)
	 */
	public Type getGenericParameterType() {
		if (genericParameterType == null) {
			if (parameterIndex < 0) {
				genericParameterType = (method != null ? method
						.getGenericReturnType() : null);
			} else {
				genericParameterType = (method != null ? method
						.getGenericParameterTypes()[parameterIndex]
						: constructor.getGenericParameterTypes()[parameterIndex]);
			}
		}
		return genericParameterType;
	}

	/**
	 * Return the wrapped Method, if any.
	 * <p>
	 * Note: Either Method or Constructor is available.
	 * 
	 * @return the Method, or <code>null</code> if none
	 */
	public Method getMethod() {
		return method;
	}

	/**
	 * Return the method/constructor annotation of the given type, if available.
	 * 
	 * @param annotationType
	 *            the annotation type to look for
	 * @return the annotation object, or <code>null</code> if not found
	 */
	public <T extends Annotation> T getMethodAnnotation(Class<T> annotationType) {
		return (method != null ? method.getAnnotation(annotationType)
				: (T) constructor.getAnnotation(annotationType));
	}

	/**
	 * Return the annotations associated with the target method/constructor
	 * itself.
	 */
	public Annotation[] getMethodAnnotations() {
		return (method != null ? method.getAnnotations() : constructor
				.getAnnotations());
	}

	/**
	 * Return the nesting level of the target type (typically 1; e.g. in case of
	 * a List of Lists, 1 would indicate the nested List, whereas 2 would
	 * indicate the element of the nested List).
	 */
	public int getNestingLevel() {
		return nestingLevel;
	}

	/**
	 * Return the parameter annotation of the given type, if available.
	 * 
	 * @param annotationType
	 *            the annotation type to look for
	 * @return the annotation object, or <code>null</code> if not found
	 */
	@SuppressWarnings("unchecked")
	public <T extends Annotation> T getParameterAnnotation(
			Class<T> annotationType) {
		Annotation[] anns = getParameterAnnotations();
		for (Annotation ann : anns) {
			if (annotationType.isInstance(ann)) {
				return (T) ann;
			}
		}
		return null;
	}

	/**
	 * Return the annotations associated with the specific method/constructor
	 * parameter.
	 */
	public Annotation[] getParameterAnnotations() {
		if (parameterAnnotations == null) {
			Annotation[][] annotationArray = (method != null ? method
					.getParameterAnnotations() : constructor
					.getParameterAnnotations());
			if ((parameterIndex >= 0)
					&& (parameterIndex < annotationArray.length)) {
				parameterAnnotations = annotationArray[parameterIndex];
			} else {
				parameterAnnotations = new Annotation[0];
			}
		}
		return parameterAnnotations;
	}

	/**
	 * Return the index of the method/constructor parameter.
	 * 
	 * @return the parameter index (never negative)
	 */
	public int getParameterIndex() {
		return parameterIndex;
	}

	/**
	 * Return the name of the method/constructor parameter.
	 * 
	 * @return the parameter name (may be <code>null</code> if no parameter name
	 *         metadata is contained in the class file or no
	 *         {@link #initParameterNameDiscovery ParameterNameDiscoverer} has
	 *         been set to begin with)
	 */
	public String getParameterName() {
		if (parameterNameDiscoverer != null) {
			String[] parameterNames = (method != null ? parameterNameDiscoverer
					.getParameterNames(method) : parameterNameDiscoverer
					.getParameterNames(constructor));
			if (parameterNames != null) {
				parameterName = parameterNames[parameterIndex];
			}
			parameterNameDiscoverer = null;
		}
		return parameterName;
	}

	/**
	 * Return the type of the method/constructor parameter.
	 * 
	 * @return the parameter type (never <code>null</code>)
	 */
	public Class<?> getParameterType() {
		if (parameterType == null) {
			if (parameterIndex < 0) {
				parameterType = (method != null ? method.getReturnType() : null);
			} else {
				parameterType = (method != null ? method.getParameterTypes()[parameterIndex]
						: constructor.getParameterTypes()[parameterIndex]);
			}
		}
		return parameterType;
	}

	/**
	 * Obtain the (lazily constructed) type-indexes-per-level Map.
	 */
	private Map<Integer, Integer> getTypeIndexesPerLevel() {
		if (typeIndexesPerLevel == null) {
			typeIndexesPerLevel = new HashMap<Integer, Integer>(4);
		}
		return typeIndexesPerLevel;
	}

	/**
	 * Return the type index for the current nesting level.
	 * 
	 * @return the corresponding type index, or <code>null</code> if none
	 *         specified (indicating the default type index)
	 * @see #getNestingLevel()
	 */
	public Integer getTypeIndexForCurrentLevel() {
		return getTypeIndexForLevel(nestingLevel);
	}

	/**
	 * Return the type index for the specified nesting level.
	 * 
	 * @param nestingLevel
	 *            the nesting level to check
	 * @return the corresponding type index, or <code>null</code> if none
	 *         specified (indicating the default type index)
	 */
	public Integer getTypeIndexForLevel(int nestingLevel) {
		return getTypeIndexesPerLevel().get(nestingLevel);
	}

	/**
	 * Increase this parameter's nesting level.
	 * 
	 * @see #getNestingLevel()
	 */
	public void increaseNestingLevel() {
		nestingLevel++;
	}

	/**
	 * Initialize parameter name discovery for this method parameter.
	 * <p>
	 * This method does not actually try to retrieve the parameter name at this
	 * point; it just allows discovery to happen when the application calls
	 * {@link #getParameterName()} (if ever).
	 */
	public void initParameterNameDiscovery(
			ParameterNameDiscoverer parameterNameDiscoverer) {
		this.parameterNameDiscoverer = parameterNameDiscoverer;
	}

	/**
	 * Set a resolved (generic) parameter type.
	 */
	void setParameterType(Class<?> parameterType) {
		this.parameterType = parameterType;
	}

	/**
	 * Set the type index for the current nesting level.
	 * 
	 * @param typeIndex
	 *            the corresponding type index (or <code>null</code> for the
	 *            default type index)
	 * @see #getNestingLevel()
	 */
	public void setTypeIndexForCurrentLevel(int typeIndex) {
		getTypeIndexesPerLevel().put(nestingLevel, typeIndex);
	}
}
