
package com.founder.fasf.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.founder.fasf.util.Assert;

/**
 * Miscellaneous class utility methods. Mainly for internal use within the
 * framework; consider Apache Commons Lang for a more comprehensive suite of
 * class utilities.
 */
public abstract class CommonClassesUtil {

	/**
	 * Map with primitive wrapper type as key and corresponding primitive type
	 * as value, for example: Integer.class -> int.class.
	 */
	private static final Map<Class<?>, Class<?>> primitiveWrapperTypeMap = new HashMap<Class<?>, Class<?>>(8);

	/**
	 * Map with primitive type as key and corresponding wrapper type as value,
	 * for example: int.class -> Integer.class.
	 */
	private static final Map<Class<?>, Class<?>> primitiveTypeToWrapperMap = new HashMap<Class<?>, Class<?>>(8);

	/**
	 * Map with primitive type name as key and corresponding primitive type as
	 * value, for example: "int" -> "int.class".
	 */
	private static final Map<String, Class<?>> primitiveTypeNameMap = new HashMap<String, Class<?>>(32);

	/**
	 * Map with common "java.lang" class name as key and corresponding Class as
	 * value. Primarily for efficient deserialization of remote invocations.
	 */
	private static final Map<String, Class<?>> commonClassCache = new HashMap<String, Class<?>>(32);

	/**
	 * Register the given common classes with the ClassUtils cache.
	 */
	private static void registerCommonClasses(Class<?>... commonClasses) {
		for (Class<?> clazz : commonClasses) {
			commonClassCache.put(clazz.getName(), clazz);
		}
	}

	static {
		primitiveWrapperTypeMap.put(Boolean.class, boolean.class);
		primitiveWrapperTypeMap.put(Byte.class, byte.class);
		primitiveWrapperTypeMap.put(Character.class, char.class);
		primitiveWrapperTypeMap.put(Double.class, double.class);
		primitiveWrapperTypeMap.put(Float.class, float.class);
		primitiveWrapperTypeMap.put(Integer.class, int.class);
		primitiveWrapperTypeMap.put(Long.class, long.class);
		primitiveWrapperTypeMap.put(Short.class, short.class);
		for (Map.Entry<Class<?>, Class<?>> entry : primitiveWrapperTypeMap.entrySet()) {
			primitiveTypeToWrapperMap.put(entry.getValue(), entry.getKey());
			registerCommonClasses(entry.getKey());
		}
		Set<Class<?>> primitiveTypes = new HashSet<Class<?>>(32);
		primitiveTypes.addAll(primitiveWrapperTypeMap.values());
		primitiveTypes.addAll(Arrays.asList(boolean[].class, byte[].class, char[].class, double[].class, float[].class, int[].class, long[].class, short[].class));
		primitiveTypes.add(void.class);
		for (Class<?> primitiveType : primitiveTypes) {
			primitiveTypeNameMap.put(primitiveType.getName(), primitiveType);
		}
		registerCommonClasses(Boolean[].class, Byte[].class, Character[].class, Double[].class, Float[].class, Integer[].class, Long[].class, Short[].class);
		registerCommonClasses(Number.class, Number[].class, String.class, String[].class, Object.class, Object[].class, Class.class, Class[].class);
		registerCommonClasses(Throwable.class, Exception.class, RuntimeException.class, Error.class, StackTraceElement.class, StackTraceElement[].class);
	}

	/**
	 * Replacement for <code>Class.forName()</code> that also returns Class
	 * instances for primitives (e.g."int") and array class names (e.g.
	 * "String[]"). Furthermore, it is also capable of resolving inner class
	 * names in Java source style (e.g. "java.lang.Thread.State" instead of
	 * "java.lang.Thread$State").
	 * 
	 * @param name
	 *            the name of the Class
	 * @param classLoader
	 *            the class loader to use (may be <code>null</code>, which
	 *            indicates the default class loader)
	 * @return Class instance for the supplied name
	 * @throws ClassNotFoundException
	 *             if the class was not found
	 * @throws LinkageError
	 *             if the class file could not be loaded
	 * @see Class#forName(String, boolean, ClassLoader)
	 */
	public static Class<?> forName(String name, ClassLoader classLoader) throws ClassNotFoundException, LinkageError {
		Assert.notNull(name, "Name must not be null");
		Class<?> clazz = resolvePrimitiveClassName(name);
		if (clazz == null) {
			clazz = commonClassCache.get(name);
		}
		if (clazz != null) {
			return clazz;
		}
		// "java.lang.String[]" style arrays
		if (name.endsWith(ReflectUtil.ARRAY_SUFFIX)) {
			String elementClassName = name.substring(0, name.length() - ReflectUtil.ARRAY_SUFFIX.length());
			Class<?> elementClass = forName(elementClassName, classLoader);
			return Array.newInstance(elementClass, 0).getClass();
		}
		// "[Ljava.lang.String;" style arrays
		if (name.startsWith(ReflectUtil.NON_PRIMITIVE_ARRAY_PREFIX) && name.endsWith(";")) {
			String elementName = name.substring(ReflectUtil.NON_PRIMITIVE_ARRAY_PREFIX.length(), name.length() - 1);
			Class<?> elementClass = forName(elementName, classLoader);
			return Array.newInstance(elementClass, 0).getClass();
		}
		// "[[I" or "[[Ljava.lang.String;" style arrays
		if (name.startsWith(ReflectUtil.INTERNAL_ARRAY_PREFIX)) {
			String elementName = name.substring(ReflectUtil.INTERNAL_ARRAY_PREFIX.length());
			Class<?> elementClass = forName(elementName, classLoader);
			return Array.newInstance(elementClass, 0).getClass();
		}
		ClassLoader classLoaderToUse = classLoader;
		if (classLoaderToUse == null) {
			classLoaderToUse = getDefaultClassLoader();
		}
		try {
			return classLoaderToUse.loadClass(name);
		} catch (ClassNotFoundException ex) {
			int lastDotIndex = name.lastIndexOf(ReflectUtil.PACKAGE_SEPARATOR);
			if (lastDotIndex != -1) {
				String innerClassName = name.substring(0, lastDotIndex) + ReflectUtil.INNER_CLASS_SEPARATOR + name.substring(lastDotIndex + 1);
				try {
					return classLoaderToUse.loadClass(innerClassName);
				} catch (ClassNotFoundException ex2) {
					// swallow - let original exception get through
				}
			}
			throw ex;
		}
	}

	/**
	 * Replacement for <code>Class.forName()</code> that also returns Class
	 * instances for primitives (like "int") and array class names (like
	 * "String[]").
	 * <p>
	 * Always uses the default class loader: that is, preferably the thread
	 * context class loader, or the ClassLoader that loaded the ClassUtils class
	 * as fallback.
	 * 
	 * @param name
	 *            the name of the Class
	 * @return Class instance for the supplied name
	 * @throws ClassNotFoundException
	 *             if the class was not found
	 * @throws LinkageError
	 *             if the class file could not be loaded
	 * @see Class#forName(String, boolean, ClassLoader)
	 * @see #getDefaultClassLoader()
	 */
	public static Class<?> forName(String name) throws ClassNotFoundException, LinkageError {
		return forName(name, getDefaultClassLoader());
	}

	/**
	 * Return the default ClassLoader to use: typically the thread context
	 * ClassLoader, if available; the ClassLoader that loaded the ClassUtils
	 * class will be used as fallback.
	 * <p>
	 * Call this method if you intend to use the thread context ClassLoader in a
	 * scenario where you absolutely need a non-null ClassLoader reference: for
	 * example, for class path resource loading (but not necessarily for
	 * <code>Class.forName</code>, which accepts a <code>null</code> ClassLoader
	 * reference as well).
	 * 
	 * @return the default ClassLoader (never <code>null</code>)
	 * @see java.lang.Thread#getContextClassLoader()
	 */
	public static ClassLoader getDefaultClassLoader() {
		ClassLoader cl = null;
		try {
			cl = Thread.currentThread().getContextClassLoader();
		} catch (Throwable ex) {
			// Cannot access thread context ClassLoader - falling back to system
			// class loader...
		}
		if (cl == null) {
			// No thread context class loader -> use class loader of this class.
			cl = CommonClassesUtil.class.getClassLoader();
		}
		return cl;
	}

	/**
	 * Resolve the given class name into a Class instance. Supports primitives
	 * (like "int") and array class names (like "String[]").
	 * <p>
	 * This is effectively equivalent to the <code>forName</code> method with
	 * the same arguments, with the only difference being the exceptions thrown
	 * in case of class loading failure.
	 * 
	 * @param className
	 *            the name of the Class
	 * @param classLoader
	 *            the class loader to use (may be <code>null</code>, which
	 *            indicates the default class loader)
	 * @return Class instance for the supplied name
	 * @throws IllegalArgumentException
	 *             if the class name was not resolvable (that is, the class
	 *             could not be found or the class file could not be loaded)
	 * @see #forName(String, ClassLoader)
	 */
	public static Class<?> resolveClassName(String className, ClassLoader classLoader) throws IllegalArgumentException {
		try {
			return forName(className, classLoader);
		} catch (ClassNotFoundException ex) {
			throw new IllegalArgumentException("Cannot find class [" + className + "]", ex);
		} catch (LinkageError ex) {
			throw new IllegalArgumentException("Error loading class [" + className + "]: problem with class file or dependent class.", ex);
		}
	}

	/**
	 * Resolve the given class name as primitive class, if appropriate,
	 * according to the JVM's naming rules for primitive classes.
	 * <p>
	 * Also supports the JVM's internal class names for primitive arrays. Does
	 * <i>not</i> support the "[]" suffix notation for primitive arrays; this is
	 * only supported by {@link #forName(String, ClassLoader)}.
	 * 
	 * @param name
	 *            the name of the potentially primitive class
	 * @return the primitive class, or <code>null</code> if the name does not
	 *         denote a primitive class or primitive array class
	 */
	public static Class<?> resolvePrimitiveClassName(String name) {
		Class<?> result = null;
		// Most class names will be quite long, considering that they
		// SHOULD sit in a package, so a length check is worthwhile.
		if ((name != null) && (name.length() <= 8)) {
			// Could be a primitive - likely.
			result = primitiveTypeNameMap.get(name);
		}
		return result;
	}

	/**
	 * Resolve the given class if it is a primitive class, returning the
	 * corresponding primitive wrapper type instead.
	 * 
	 * @param clazz
	 *            the class to check
	 * @return the original class, or a primitive wrapper for the original
	 *         primitive type
	 */
	public static Class<?> resolvePrimitiveIfNecessary(Class<?> clazz) {
		Assert.notNull(clazz, "Class must not be null");
		return (clazz.isPrimitive() && (clazz != void.class) ? primitiveTypeToWrapperMap.get(clazz) : clazz);
	}

	/**
	 * Parse a method signature in the form
	 * <code>methodName[([arg_list])]</code>, where <code>arg_list</code> is an
	 * optional, comma-separated list of fully-qualified type names, and
	 * attempts to resolve that signature against the supplied
	 * <code>Class</code>.
	 * <p>
	 * When not supplying an argument list (<code>methodName</code>) the method
	 * whose name matches and has the least number of parameters will be
	 * returned. When supplying an argument type list, only the method whose
	 * name and argument types match will be returned.
	 * <p>
	 * Note then that <code>methodName</code> and <code>methodName()</code> are
	 * <strong>not</strong> resolved in the same way. The signature
	 * <code>methodName</code> means the method called <code>methodName</code>
	 * with the least number of arguments, whereas <code>methodName()</code>
	 * means the method called <code>methodName</code> with exactly 0 arguments.
	 * <p>
	 * If no method can be found, then <code>null</code> is returned.
	 * 
	 * @param signature
	 *            the method signature as String representation
	 * @param clazz
	 *            the class to resolve the method signature against
	 * @return the resolved Method
	 * @see #findMethod
	 * @see #findMethodWithMinimalParameters
	 */
	public static Method resolveSignature(String signature, Class<?> clazz) {
		Assert.hasText(signature, "'signature' must not be empty");
		Assert.notNull(clazz, "Class must not be null");
		int firstParen = signature.indexOf("(");
		int lastParen = signature.indexOf(")");
		if ((firstParen > -1) && (lastParen == -1)) {
			throw new IllegalArgumentException("Invalid method signature '" + signature + "': expected closing ')' for args list");
		} else if ((lastParen > -1) && (firstParen == -1)) {
			throw new IllegalArgumentException("Invalid method signature '" + signature + "': expected opening '(' for args list");
		} else if ((firstParen == -1) && (lastParen == -1)) {
			return findMethodWithMinimalParameters(clazz, signature);
		} else {
			String methodName = signature.substring(0, firstParen);
			String[] parameterTypeNames =signature.substring(firstParen + 1, lastParen).split(",");// StringUtil.commaDelimitedListToStringArray();
			Class<?>[] parameterTypes = new Class[parameterTypeNames.length];
			for (int i = 0; i < parameterTypeNames.length; i++) {
				String parameterTypeName = parameterTypeNames[i].trim();
				try {
					parameterTypes[i] = forName(parameterTypeName, clazz.getClassLoader());
				} catch (Throwable ex) {
					throw new IllegalArgumentException("Invalid method signature: unable to resolve type [" + parameterTypeName + "] for argument " + i + ". Root cause: " + ex);
				}
			}
			return findMethod(clazz, methodName, parameterTypes);
		}
	}

	/**
	 * Check if the right-hand side type may be assigned to the left-hand side
	 * type, assuming setting by reflection. Considers primitive wrapper classes
	 * as assignable to the corresponding primitive types.
	 * 
	 * @param lhsType
	 *            the target type
	 * @param rhsType
	 *            the value type that should be assigned to the target type
	 * @return if the target type is assignable from the value type
	 * @see TypeUtil#isAssignable
	 */
	public static boolean isAssignable(Class<?> lhsType, Class<?> rhsType) {
		Assert.notNull(lhsType, "Left-hand side type must not be null");
		Assert.notNull(rhsType, "Right-hand side type must not be null");
		if (lhsType.isAssignableFrom(rhsType)) {
			return true;
		}
		if (lhsType.isPrimitive()) {
			Class<?> resolvedPrimitive = primitiveWrapperTypeMap.get(rhsType);
			if ((resolvedPrimitive != null) && lhsType.equals(resolvedPrimitive)) {
				return true;
			}
		} else {
			Class<?> resolvedWrapper = primitiveTypeToWrapperMap.get(rhsType);
			if ((resolvedWrapper != null) && lhsType.isAssignableFrom(resolvedWrapper)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Determine if the given type is assignable from the given value, assuming
	 * setting by reflection. Considers primitive wrapper classes as assignable
	 * to the corresponding primitive types.
	 * 
	 * @param type
	 *            the target type
	 * @param value
	 *            the value that should be assigned to the type
	 * @return if the type is assignable from the value
	 */
	public static boolean isAssignableValue(Class<?> type, Object value) {
		Assert.notNull(type, "Type must not be null");
		return (value != null ? isAssignable(type, value.getClass()) : !type.isPrimitive());
	}

	/**
	 * Determine whether the {@link Class} identified by the supplied name is
	 * present and can be loaded. Will return <code>false</code> if either the
	 * class or one of its dependencies is not present or cannot be loaded.
	 * 
	 * @param className
	 *            the name of the class to check
	 * @return whether the specified class is present
	 */
	public static boolean isPresent(String className) {
		return isPresent(className, getDefaultClassLoader());
	}

	/**
	 * Determine whether the {@link Class} identified by the supplied name is
	 * present and can be loaded. Will return <code>false</code> if either the
	 * class or one of its dependencies is not present or cannot be loaded.
	 * 
	 * @param className
	 *            the name of the class to check
	 * @param classLoader
	 *            the class loader to use (may be <code>null</code>, which
	 *            indicates the default class loader)
	 * @return whether the specified class is present
	 */
	public static boolean isPresent(String className, ClassLoader classLoader) {
		try {
			forName(className, classLoader);
			return true;
		} catch (Throwable ex) {
			// Class or one of its dependencies is not present...
			return false;
		}
	}

	/**
	 * Check if the given class represents an array of primitives, i.e. boolean,
	 * byte, char, short, int, long, float, or double.
	 * 
	 * @param clazz
	 *            the class to check
	 * @return whether the given class is a primitive array class
	 */
	public static boolean isPrimitiveArray(Class<?> clazz) {
		Assert.notNull(clazz, "Class must not be null");
		return (clazz.isArray() && clazz.getComponentType().isPrimitive());
	}

	/**
	 * Check if the given class represents a primitive (i.e. boolean, byte,
	 * char, short, int, long, float, or double) or a primitive wrapper (i.e.
	 * Boolean, Byte, Character, Short, Integer, Long, Float, or Double).
	 * 
	 * @param clazz
	 *            the class to check
	 * @return whether the given class is a primitive or primitive wrapper class
	 */
	public static boolean isPrimitiveOrWrapper(Class<?> clazz) {
		Assert.notNull(clazz, "Class must not be null");
		return (clazz.isPrimitive() || isPrimitiveWrapper(clazz));
	}

	/**
	 * Check if the given class represents a primitive wrapper, i.e. Boolean,
	 * Byte, Character, Short, Integer, Long, Float, or Double.
	 * 
	 * @param clazz
	 *            the class to check
	 * @return whether the given class is a primitive wrapper class
	 */
	public static boolean isPrimitiveWrapper(Class<?> clazz) {
		Assert.notNull(clazz, "Class must not be null");
		return primitiveWrapperTypeMap.containsKey(clazz);
	}

	/**
	 * Check if the given class represents an array of primitive wrappers, i.e.
	 * Boolean, Byte, Character, Short, Integer, Long, Float, or Double.
	 * 
	 * @param clazz
	 *            the class to check
	 * @return whether the given class is a primitive wrapper array class
	 */
	public static boolean isPrimitiveWrapperArray(Class<?> clazz) {
		Assert.notNull(clazz, "Class must not be null");
		return (clazz.isArray() && isPrimitiveWrapper(clazz.getComponentType()));
	}

	/**
	 * Find a method with the given method name and minimal parameters (best
	 * case: none), declared on the given class or one of its superclasses.
	 * Prefers public methods, but will return a protected, package access, or
	 * private method too.
	 * <p>
	 * Checks <code>Class.getMethods</code> first, falling back to
	 * <code>findDeclaredMethodWithMinimalParameters</code>. This allows for
	 * finding public methods without issues even in environments with
	 * restricted Java security settings.
	 * 
	 * @param clazz
	 *            the class to check
	 * @param methodName
	 *            the name of the method to find
	 * @return the Method object, or <code>null</code> if not found
	 * @throws IllegalArgumentException
	 *             if methods of the given name were found but could not be
	 *             resolved to a unique method with minimal parameters
	 * @see java.lang.Class#getMethods
	 * @see #findDeclaredMethodWithMinimalParameters
	 */
	public static Method findMethodWithMinimalParameters(Class<?> clazz, String methodName) throws IllegalArgumentException {
		Method targetMethod = findMethodWithMinimalParameters(clazz.getMethods(), methodName);
		if (targetMethod == null) {
			targetMethod = findDeclaredMethodWithMinimalParameters(clazz, methodName);
		}
		return targetMethod;
	}

	/**
	 * Find a method with the given method name and minimal parameters (best
	 * case: none) in the given list of methods.
	 * 
	 * @param methods
	 *            the methods to check
	 * @param methodName
	 *            the name of the method to find
	 * @return the Method object, or <code>null</code> if not found
	 * @throws IllegalArgumentException
	 *             if methods of the given name were found but could not be
	 *             resolved to a unique method with minimal parameters
	 */
	public static Method findMethodWithMinimalParameters(Method[] methods, String methodName) throws IllegalArgumentException {
		Method targetMethod = null;
		int numMethodsFoundWithCurrentMinimumArgs = 0;
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				int numParams = method.getParameterTypes().length;
				if ((targetMethod == null) || (numParams < targetMethod.getParameterTypes().length)) {
					targetMethod = method;
					numMethodsFoundWithCurrentMinimumArgs = 1;
				} else {
					if (targetMethod.getParameterTypes().length == numParams) {
						// Additional candidate with same length.
						numMethodsFoundWithCurrentMinimumArgs++;
					}
				}
			}
		}
		if (numMethodsFoundWithCurrentMinimumArgs > 1) {
			throw new IllegalArgumentException("Cannot resolve method '" + methodName + "' to a unique method. Attempted to resolve to overloaded method with "
					+ "the least number of parameters, but there were " + numMethodsFoundWithCurrentMinimumArgs + " candidates.");
		}
		return targetMethod;
	}

	/**
	 * Find a method with the given method name and the given parameter types,
	 * declared on the given class or one of its superclasses. Prefers public
	 * methods, but will return a protected, package access, or private method
	 * too.
	 * <p>
	 * Checks <code>Class.getMethod</code> first, falling back to
	 * <code>findDeclaredMethod</code>. This allows to find public methods
	 * without issues even in environments with restricted Java security
	 * settings.
	 * 
	 * @param clazz
	 *            the class to check
	 * @param methodName
	 *            the name of the method to find
	 * @param paramTypes
	 *            the parameter types of the method to find
	 * @return the Method object, or <code>null</code> if not found
	 * @see java.lang.Class#getMethod
	 * @see #findDeclaredMethod
	 */
	public static Method findMethod(Class<?> clazz, String methodName, Class<?>... paramTypes) {
		try {
			return clazz.getMethod(methodName, paramTypes);
		} catch (NoSuchMethodException ex) {
			return findDeclaredMethod(clazz, methodName, paramTypes);
		}
	}

	/**
	 * Find a method with the given method name and the given parameter types,
	 * declared on the given class or one of its superclasses. Will return a
	 * public, protected, package access, or private method.
	 * <p>
	 * Checks <code>Class.getDeclaredMethod</code>, cascading upwards to all
	 * superclasses.
	 * 
	 * @param clazz
	 *            the class to check
	 * @param methodName
	 *            the name of the method to find
	 * @param paramTypes
	 *            the parameter types of the method to find
	 * @return the Method object, or <code>null</code> if not found
	 * @see java.lang.Class#getDeclaredMethod
	 */
	public static Method findDeclaredMethod(Class<?> clazz, String methodName, Class<?>[] paramTypes) {
		try {
			return clazz.getDeclaredMethod(methodName, paramTypes);
		} catch (NoSuchMethodException ex) {
			if (clazz.getSuperclass() != null) {
				return findDeclaredMethod(clazz.getSuperclass(), methodName, paramTypes);
			}
			return null;
		}
	}

	/**
	 * Find a method with the given method name and minimal parameters (best
	 * case: none), declared on the given class or one of its superclasses. Will
	 * return a public, protected, package access, or private method.
	 * <p>
	 * Checks <code>Class.getDeclaredMethods</code>, cascading upwards to all
	 * superclasses.
	 * 
	 * @param clazz
	 *            the class to check
	 * @param methodName
	 *            the name of the method to find
	 * @return the Method object, or <code>null</code> if not found
	 * @throws IllegalArgumentException
	 *             if methods of the given name were found but could not be
	 *             resolved to a unique method with minimal parameters
	 * @see java.lang.Class#getDeclaredMethods
	 */
	public static Method findDeclaredMethodWithMinimalParameters(Class<?> clazz, String methodName) throws IllegalArgumentException {
		Method targetMethod = findMethodWithMinimalParameters(clazz.getDeclaredMethods(), methodName);
		if ((targetMethod == null) && (clazz.getSuperclass() != null)) {
			targetMethod = findDeclaredMethodWithMinimalParameters(clazz.getSuperclass(), methodName);
		}
		return targetMethod;
	}

	/**
	 * Check if the given type represents a "simple" property: a primitive, a
	 * String or other CharSequence, a Number, a Date, a URI, a URL, a Locale, a
	 * Class, or a corresponding array.
	 * <p>
	 * Used to determine properties to check for a "simple" dependency-check.
	 * 
	 * @param clazz
	 *            the type to check
	 * @return whether the given type represents a "simple" property
	 * @see org.springframework.beans.factory.support.RootBeanDefinition#DEPENDENCY_CHECK_SIMPLE
	 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory
	 */
	public static boolean isSimpleProperty(Class<?> clazz) {
		Assert.notNull(clazz, "Class must not be null");
		return isSimpleValueType(clazz) || (clazz.isArray() && isSimpleValueType(clazz.getComponentType()));
	}

	/**
	 * Check if the given type represents a "simple" value type: a primitive, a
	 * String or other CharSequence, a Number, a Date, a URI, a URL, a Locale or
	 * a Class.
	 * 
	 * @param clazz
	 *            the type to check
	 * @return whether the given type represents a "simple" value type
	 */
	public static boolean isSimpleValueType(Class<?> clazz) {
		return isPrimitiveOrWrapper(clazz) || clazz.isEnum() || CharSequence.class.isAssignableFrom(clazz) || Number.class.isAssignableFrom(clazz)
				|| Date.class.isAssignableFrom(clazz) || clazz.equals(URI.class) || clazz.equals(URL.class) || clazz.equals(Locale.class) || clazz.equals(Class.class);
	}

	

	private static boolean isAssignable(ParameterizedType lhsType, ParameterizedType rhsType) {
		if (lhsType.equals(rhsType)) {
			return true;
		}
		Type[] lhsTypeArguments = lhsType.getActualTypeArguments();
		Type[] rhsTypeArguments = rhsType.getActualTypeArguments();
		if (lhsTypeArguments.length != rhsTypeArguments.length) {
			return false;
		}
		for (int size = lhsTypeArguments.length, i = 0; i < size; ++i) {
			Type lhsArg = lhsTypeArguments[i];
			Type rhsArg = rhsTypeArguments[i];
			if (!lhsArg.equals(rhsArg) && !((lhsArg instanceof WildcardType) && isAssignable((WildcardType) lhsArg, rhsArg))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Check if the right-hand side type may be assigned to the left-hand side
	 * type following the Java generics rules.
	 * 
	 * @param lhsType
	 *            the target type
	 * @param rhsType
	 *            the value type that should be assigned to the target type
	 * @return true if rhs is assignable to lhs
	 */
	public static boolean isAssignable(Type lhsType, Type rhsType) {
		Assert.notNull(lhsType, "Left-hand side type must not be null");
		Assert.notNull(rhsType, "Right-hand side type must not be null");
		// all types are assignable to themselves and to class Object
		if (lhsType.equals(rhsType) || lhsType.equals(Object.class)) {
			return true;
		}
		if (lhsType instanceof Class<?>) {
			Class<?> lhsClass = (Class<?>) lhsType;
			// just comparing two classes
			if (rhsType instanceof Class<?>) {
				return CommonClassesUtil.isAssignable(lhsClass, (Class<?>) rhsType);
			}
			if (rhsType instanceof ParameterizedType) {
				Type rhsRaw = ((ParameterizedType) rhsType).getRawType();
				// a parameterized type is always assignable to its raw class
				// type
				if (rhsRaw instanceof Class<?>) {
					return CommonClassesUtil.isAssignable(lhsClass, (Class<?>) rhsRaw);
				}
			} else if (lhsClass.isArray() && (rhsType instanceof GenericArrayType)) {
				Type rhsComponent = ((GenericArrayType) rhsType).getGenericComponentType();
				return isAssignable(lhsClass.getComponentType(), rhsComponent);
			}
		}
		// parameterized types are only assignable to other parameterized types
		// and class types
		if (lhsType instanceof ParameterizedType) {
			if (rhsType instanceof Class<?>) {
				Type lhsRaw = ((ParameterizedType) lhsType).getRawType();
				if (lhsRaw instanceof Class<?>) {
					return CommonClassesUtil.isAssignable((Class<?>) lhsRaw, (Class<?>) rhsType);
				}
			} else if (rhsType instanceof ParameterizedType) {
				return isAssignable((ParameterizedType) lhsType, (ParameterizedType) rhsType);
			}
		}
		if (lhsType instanceof GenericArrayType) {
			Type lhsComponent = ((GenericArrayType) lhsType).getGenericComponentType();
			if (rhsType instanceof Class<?>) {
				Class<?> rhsClass = (Class<?>) rhsType;
				if (rhsClass.isArray()) {
					return isAssignable(lhsComponent, rhsClass.getComponentType());
				}
			} else if (rhsType instanceof GenericArrayType) {
				Type rhsComponent = ((GenericArrayType) rhsType).getGenericComponentType();
				return isAssignable(lhsComponent, rhsComponent);
			}
		}
		if (lhsType instanceof WildcardType) {
			return isAssignable((WildcardType) lhsType, rhsType);
		}
		return false;
	}

	private static boolean isAssignable(WildcardType lhsType, Type rhsType) {
		Type[] lUpperBounds = lhsType.getUpperBounds();
		// supply the implicit upper bound if none are specified
		if (lUpperBounds.length == 0) {
			lUpperBounds = new Type[] { Object.class };
		}
		Type[] lLowerBounds = lhsType.getLowerBounds();
		// supply the implicit lower bound if none are specified
		if (lLowerBounds.length == 0) {
			lLowerBounds = new Type[] { null };
		}
		if (rhsType instanceof WildcardType) {
			// both the upper and lower bounds of the right-hand side must be
			// completely enclosed in the upper and lower bounds of the left-
			// hand side.
			WildcardType rhsWcType = (WildcardType) rhsType;
			Type[] rUpperBounds = rhsWcType.getUpperBounds();
			if (rUpperBounds.length == 0) {
				rUpperBounds = new Type[] { Object.class };
			}
			Type[] rLowerBounds = rhsWcType.getLowerBounds();
			if (rLowerBounds.length == 0) {
				rLowerBounds = new Type[] { null };
			}
			for (Type lBound : lUpperBounds) {
				for (Type rBound : rUpperBounds) {
					if (!isAssignableBound(lBound, rBound)) {
						return false;
					}
				}
				for (Type rBound : rLowerBounds) {
					if (!isAssignableBound(lBound, rBound)) {
						return false;
					}
				}
			}
			for (Type lBound : lLowerBounds) {
				for (Type rBound : rUpperBounds) {
					if (!isAssignableBound(rBound, lBound)) {
						return false;
					}
				}
				for (Type rBound : rLowerBounds) {
					if (!isAssignableBound(rBound, lBound)) {
						return false;
					}
				}
			}
		} else {
			for (Type lBound : lUpperBounds) {
				if (!isAssignableBound(lBound, rhsType)) {
					return false;
				}
			}
			for (Type lBound : lLowerBounds) {
				if (!isAssignableBound(rhsType, lBound)) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isAssignableBound(Type lhsType, Type rhsType) {
		if (rhsType == null) {
			return true;
		}
		if (lhsType == null) {
			return false;
		}
		return isAssignable(lhsType, rhsType);
	}
}
