/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. You
 * shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.reflect;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.WeakHashMap;

import org.apache.log4j.Logger;

import com.founder.fasf.beans.BeansException;
import com.founder.fasf.exception.BaseException;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;



/**
 * Simple utility class for working with the reflection API and handling
 * reflection exceptions. Only intended for internal use.
 */
public abstract class ReflectUtil {
	
	private static Logger log = Logger.getLogger(ReflectUtil.class);

	/**
	 * Callback interface invoked on each field in the hierarchy.
	 */
	public interface FieldCallback {

		/**
		 * Perform an operation using the given field.
		 * 
		 * @param field
		 *            the field to operate on
		 */
		void doWith(Field field) throws IllegalArgumentException, IllegalAccessException;
	}

	/**
	 * Callback optionally used to filter fields to be operated on by a field
	 * callback.
	 */
	public interface FieldFilter {

		/**
		 * Determine whether the given field matches.
		 * 
		 * @param field
		 *            the field to check
		 */
		boolean matches(Field field);
	}

	/**
	 * Action to take on each method.
	 */
	public interface MethodCallback {

		/**
		 * Perform an operation using the given method.
		 * 
		 * @param method
		 *            the method to operate on
		 */
		void doWith(Method method) throws IllegalArgumentException, IllegalAccessException;
	}

	/**
	 * Callback optionally used to method fields to be operated on by a method
	 * callback.
	 */
	public interface MethodFilter {

		/**
		 * Determine whether the given method matches.
		 * 
		 * @param method
		 *            the method to check
		 */
		boolean matches(Method method);
	}

	static final Logger logger = Logger.getLogger(ReflectUtil.class);

	/** Suffix for array class names: "[]" */
	public static final String ARRAY_SUFFIX = "[]";

	/** Prefix for internal array class names: "[" */
	public static final String INTERNAL_ARRAY_PREFIX = "[";

	/** Prefix for internal non-primitive array class names: "[L" */
	public static final String NON_PRIMITIVE_ARRAY_PREFIX = "[L";

	/** The path separator character "/" */
	public static final char PATH_SEPARATOR = '/';

	/** The package separator character '.' */
	public static final char PACKAGE_SEPARATOR = '.';

	/** The inner class separator character '$' */
	public static final char INNER_CLASS_SEPARATOR = '$';

	/** The CGLIB class separator character "$$" */
	public static final String CGLIB_CLASS_SEPARATOR = "$$";

	/** The ".class" file suffix */
	public static final String CLASS_FILE_SUFFIX = ".class";

	/**
	 * Pre-built FieldFilter that matches all non-static, non-final fields.
	 */
	public static FieldFilter COPYABLE_FIELDS = new FieldFilter() {

		@Override
		public boolean matches(Field field) {
			return !(Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers()));
		}
	};

	/**
	 * Pre-built MethodFilter that matches all non-bridge methods.
	 */
	public static MethodFilter NON_BRIDGED_METHODS = new MethodFilter() {

		@Override
		public boolean matches(Method method) {
			return !method.isBridge();
		}
	};

	/**
	 * Pre-built MethodFilter that matches all non-bridge methods which are not
	 * declared on <code>java.lang.Object</code>.
	 */
	public static MethodFilter USER_DECLARED_METHODS = new MethodFilter() {

		@Override
		public boolean matches(Method method) {
			return (!method.isBridge() && (method.getDeclaringClass() != Object.class));
		}
	};

	/**
	 * Return a path suitable for use with <code>ClassLoader.getResource</code>
	 * (also suitable for use with <code>Class.getResource</code> by prepending
	 * a slash ('/') to the return value). Built by taking the package of the
	 * specified class file, converting all dots ('.') to slashes ('/'), adding
	 * a trailing slash if necessary, and concatenating the specified resource
	 * name to this. <br/>
	 * As such, this function may be used to build a path suitable for loading a
	 * resource file that is in the same package as a class file, although
	 * {@link org.springframework.core.io.ClassPathResource} is usually even
	 * more convenient.
	 * 
	 * @param clazz
	 *            the Class whose package will be used as the base
	 * @param resourceName
	 *            the resource name to append. A leading slash is optional.
	 * @return the built-up resource path
	 * @see java.lang.ClassLoader#getResource
	 * @see java.lang.Class#getResource
	 */
	public static String addResourcePathToPackagePath(Class<?> clazz, String resourceName) {
		Assert.notNull(resourceName, "Resource name must not be null");
		if (!resourceName.startsWith("/")) {
			return classPackageAsResourcePath(clazz) + PATH_SEPARATOR + resourceName;
		}
		return classPackageAsResourcePath(clazz) + resourceName;
	}

	/**
	 * Build a String that consists of the names of the classes/interfaces in
	 * the given array.
	 * <p>
	 * Basically like <code>AbstractCollection.toString()</code>, but stripping
	 * the "class "/"interface " prefix before every class name.
	 * 
	 * @param classes
	 *            a Collection of Class objects (may be <code>null</code>)
	 * @return a String of form "[com.foo.Bar, com.foo.Baz]"
	 * @see java.util.AbstractCollection#toString()
	 */
	public static String classNamesToString(Class<?>... classes) {
		return classNamesToString(Arrays.asList(classes));
	}

	/**
	 * Build a String that consists of the names of the classes/interfaces in
	 * the given collection.
	 * <p>
	 * Basically like <code>AbstractCollection.toString()</code>, but stripping
	 * the "class "/"interface " prefix before every class name.
	 * 
	 * @param classes
	 *            a Collection of Class objects (may be <code>null</code>)
	 * @return a String of form "[com.foo.Bar, com.foo.Baz]"
	 * @see java.util.AbstractCollection#toString()
	 */
	public static String classNamesToString(Collection<Class<?>> classes) {
		if (ObjectUtil.isNullOrEmpty(classes)) {
			return ARRAY_SUFFIX;// "[]";
		}
		StringBuilder sb = new StringBuilder(INTERNAL_ARRAY_PREFIX);
		for (Iterator<Class<?>> it = classes.iterator(); it.hasNext();) {
			Class<?> clazz = it.next();
			sb.append(clazz.getName());
			if (it.hasNext()) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Convert a "."-based fully qualified class name to a "/"-based resource
	 * path.
	 * 
	 * @param className
	 *            the fully qualified class name
	 * @return the corresponding resource path, pointing to the class
	 */
	public static String classNameToResourcePath(String className) {
		Assert.notNull(className, "Class name must not be null");
		return className.replace(PACKAGE_SEPARATOR, PATH_SEPARATOR);
	}

	/**
	 * Given an input class object, return a string which consists of the
	 * class's package name as a pathname, i.e., all dots ('.') are replaced by
	 * slashes ('/'). Neither a leading nor trailing slash is added. The result
	 * could be concatenated with a slash and the name of a resource and fed
	 * directly to <code>ClassLoader.getResource()</code>. For it to be fed to
	 * <code>Class.getResource</code> instead, a leading slash would also have
	 * to be prepended to the returned value.
	 * 
	 * @param clazz
	 *            the input class. A <code>null</code> value or the default
	 *            (empty) package will result in an empty string ("") being
	 *            returned.
	 * @return a path which represents the package name
	 * @see ClassLoader#getResource
	 * @see Class#getResource
	 */
	public static String classPackageAsResourcePath(Class<?> clazz) {
		if (clazz == null) {
			return "";
		}
		String className = clazz.getName();
		int packageEndIndex = className.lastIndexOf(PACKAGE_SEPARATOR);
		if (packageEndIndex == -1) {
			return "";
		}
		String packageName = className.substring(0, packageEndIndex);
		return packageName.replace(PACKAGE_SEPARATOR, PATH_SEPARATOR);
	}

	/**
	 * Create a composite interface Class for the given interfaces, implementing
	 * the given interfaces in one single Class.
	 * <p>
	 * This implementation builds a JDK proxy class for the given interfaces.
	 * 
	 * @param interfaces
	 *            the interfaces to merge
	 * @param classLoader
	 *            the ClassLoader to create the composite Class in
	 * @return the merged interface as Class
	 * @see java.lang.reflect.Proxy#getProxyClass
	 */
	public static Class<?> createCompositeInterface(Class<?>[] interfaces, ClassLoader classLoader) {
		Assert.notEmpty(interfaces, "Interfaces must not be empty");
		Assert.notNull(classLoader, "ClassLoader must not be null");
		return Proxy.getProxyClass(classLoader, interfaces);
	}

	/**
	 * Determine whether the given method explicitly declares the given
	 * exception or one of its superclasses, which means that an exception of
	 * that type can be propagated as-is within a reflective invocation.
	 * 
	 * @param method
	 *            the declaring method
	 * @param exceptionType
	 *            the exception to throw
	 * @return <code>true</code> if the exception can be thrown as-is;
	 *         <code>false</code> if it needs to be wrapped
	 */
	public static boolean declaresException(Method method, Class<?> exceptionType) {
		Assert.notNull(method, "Method must not be null");
		Class<?>[] declaredExceptions = method.getExceptionTypes();
		for (Class<?> declaredException : declaredExceptions) {
			if (declaredException.isAssignableFrom(exceptionType)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Invoke the given callback on all fields in the target class, going up the
	 * class hierarchy to get all declared fields.
	 * 
	 * @param clazz
	 *            the target class to analyze
	 * @param fc
	 *            the callback to invoke for each field
	 */
	public static void doWithFields(Class<?> clazz, FieldCallback fc) throws IllegalArgumentException {
		doWithFields(clazz, fc, null);
	}

	/**
	 * Invoke the given callback on all fields in the target class, going up the
	 * class hierarchy to get all declared fields.
	 * 
	 * @param clazz
	 *            the target class to analyze
	 * @param fc
	 *            the callback to invoke for each field
	 * @param ff
	 *            the filter that determines the fields to apply the callback to
	 */
	public static void doWithFields(Class<?> clazz, FieldCallback fc, FieldFilter ff) throws IllegalArgumentException {
		// Keep backing up the inheritance hierarchy.
		Class<?> targetClass = clazz;
		do {
			Field[] fields = targetClass.getDeclaredFields();
			for (Field field : fields) {
				// Skip static and final fields.
				if ((ff != null) && !ff.matches(field)) {
					continue;
				}
				try {
					fc.doWith(field);
				} catch (IllegalAccessException ex) {
					throw new IllegalStateException("Shouldn't be illegal to access field '" + field.getName() + "': " + ex);
				}
			}
			targetClass = targetClass.getSuperclass();
		} while ((targetClass != null) && (targetClass != Object.class));
	}

	/**
	 * Perform the given callback operation on all matching methods of the given
	 * class and superclasses.
	 * <p>
	 * The same named method occurring on subclass and superclass will appear
	 * twice, unless excluded by a {@link MethodFilter}.
	 * 
	 * @param clazz
	 *            class to start looking at
	 * @param mc
	 *            the callback to invoke for each method
	 * @see #doWithMethods(Class, MethodCallback, MethodFilter)
	 */
	public static void doWithMethods(Class<?> clazz, MethodCallback mc) throws IllegalArgumentException {
		doWithMethods(clazz, mc, null);
	}

	/**
	 * Perform the given callback operation on all matching methods of the given
	 * class and superclasses (or given interface and super-interfaces).
	 * <p>
	 * The same named method occurring on subclass and superclass will appear
	 * twice, unless excluded by the specified {@link MethodFilter}.
	 * 
	 * @param clazz
	 *            class to start looking at
	 * @param mc
	 *            the callback to invoke for each method
	 * @param mf
	 *            the filter that determines the methods to apply the callback
	 *            to
	 */
	public static void doWithMethods(Class<?> clazz, MethodCallback mc, MethodFilter mf) throws IllegalArgumentException {
		// Keep backing up the inheritance hierarchy.
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			if ((mf != null) && !mf.matches(method)) {
				continue;
			}
			try {
				mc.doWith(method);
			} catch (IllegalAccessException ex) {
				throw new IllegalStateException("Shouldn't be illegal to access method '" + method.getName() + "': " + ex);
			}
		}
		if (clazz.getSuperclass() != null) {
			doWithMethods(clazz.getSuperclass(), mc, mf);
		} else if (clazz.isInterface()) {
			for (Class<?> superIfc : clazz.getInterfaces()) {
				doWithMethods(superIfc, mc, mf);
			}
		}
	}

	/**
	 * Attempt to find a {@link Field field} on the supplied {@link Class} with
	 * the supplied <code>name</code>. Searches all superclasses up to
	 * {@link Object}.
	 * 
	 * @param clazz
	 *            the class to introspect
	 * @param name
	 *            the name of the field
	 * @return the corresponding Field object, or <code>null</code> if not found
	 */
	public static Field findField(Class<?> clazz, String name) {
		return findField(clazz, name, null);
	}

	/**
	 * Attempt to find a {@link Field field} on the supplied {@link Class} with
	 * the supplied <code>name</code> and/or {@link Class type}. Searches all
	 * superclasses up to {@link Object}.
	 * 
	 * @param clazz
	 *            the class to introspect
	 * @param name
	 *            the name of the field (may be <code>null</code> if type is
	 *            specified)
	 * @param type
	 *            the type of the field (may be <code>null</code> if name is
	 *            specified)
	 * @return the corresponding Field object, or <code>null</code> if not found
	 */
	public static Field findField(Class<?> clazz, String name, Class<?> type) {
		Assert.notNull(clazz, "Class must not be null");
		Assert.isTrue((name != null) || (type != null), "Either name or type of the field must be specified");
		Class<?> searchType = clazz;
		while (!Object.class.equals(searchType) && (searchType != null)) {
			Field[] fields = searchType.getDeclaredFields();
			for (Field field : fields) {
				if (((name == null) || name.equals(field.getName())) && ((type == null) || type.equals(field.getType()))) {
					return field;
				}
			}
			searchType = searchType.getSuperclass();
		}
		return null;
	}

	/**
	 * Attempt to find a {@link Method} on the supplied class with the supplied
	 * name and no parameters. Searches all superclasses up to
	 * <code>Object</code>.
	 * <p>
	 * Returns <code>null</code> if no {@link Method} can be found.
	 * 
	 * @param clazz
	 *            the class to introspect
	 * @param name
	 *            the name of the method
	 * @return the Method object, or <code>null</code> if none found
	 */
	public static Method findMethod(Class<?> clazz, String name) {
		return findMethod(clazz, name, new Class[0]);
	}

	/**
	 * Attempt to find a {@link Method} on the supplied class with the supplied
	 * name and parameter types. Searches all superclasses up to
	 * <code>Object</code>.
	 * <p>
	 * Returns <code>null</code> if no {@link Method} can be found.
	 * 
	 * @param clazz
	 *            the class to introspect
	 * @param name
	 *            the name of the method
	 * @param paramTypes
	 *            the parameter types of the method (may be <code>null</code> to
	 *            indicate any signature)
	 * @return the Method object, or <code>null</code> if none found
	 */
	public static Method findMethod(Class<?> clazz, String name, Class<?>... paramTypes) {
		Assert.notNull(clazz, "Class must not be null");
		Assert.notNull(name, "Method name must not be null");
		Class<?> searchType = clazz;
		while (searchType != null) {
			Method[] methods = (searchType.isInterface() ? searchType.getMethods() : searchType.getDeclaredMethods());
			for (Method method : methods) {
				if (name.equals(method.getName()) && ((paramTypes == null) || Arrays.equals(paramTypes, method.getParameterTypes()))) {
					return method;
				}
			}
			searchType = searchType.getSuperclass();
		}
		return null;
	}

	/**
	 * Determine the bean property type for the given property from the given
	 * classes/interfaces, if possible.
	 * 
	 * @param propertyName
	 *            the name of the bean property
	 * @param beanClasses
	 *            the classes to check against
	 * @return the property type, or <code>Object.class</code> as fallback
	 */
	public static Class<?> findPropertyType(String propertyName, Class<?>[] beanClasses) {
		if (beanClasses != null) {
			for (Class<?> beanClass : beanClasses) {
				PropertyDescriptor pd = ReflectUtil.getPropertyDescriptor(beanClass, propertyName);
				if (pd != null) {
					return pd.getPropertyType();
				}
			}
		}
		return Object.class;
	}

	/**
	 * Get all declared methods on the leaf class and all superclasses. Leaf
	 * class methods are included first.
	 */
	public static Method[] getAllDeclaredMethods(Class<?> leafClass) throws IllegalArgumentException {
		final List<Method> methods = new ArrayList<Method>(32);
		doWithMethods(leafClass, new MethodCallback() {

			@Override
			public void doWith(Method method) {
				methods.add(method);
			}
		});
		return methods.toArray(new Method[methods.size()]);
	}

	/**
	 * Return all interfaces that the given instance implements as array,
	 * including ones implemented by superclasses.
	 * 
	 * @param instance
	 *            the instance to analyze for interfaces
	 * @return all interfaces that the given instance implements as array
	 */
	public static Class<?>[] getAllInterfaces(Object instance) {
		Assert.notNull(instance, "Instance must not be null");
		return getAllInterfacesForClass(instance.getClass());
	}

	/**
	 * Return all interfaces that the given instance implements as Set,
	 * including ones implemented by superclasses.
	 * 
	 * @param instance
	 *            the instance to analyze for interfaces
	 * @return all interfaces that the given instance implements as Set
	 */
	public static Set<Class<?>> getAllInterfacesAsSet(Object instance) {
		Assert.notNull(instance, "Instance must not be null");
		return getAllInterfacesForClassAsSet(instance.getClass());
	}

	/**
	 * Return all interfaces that the given class implements as array, including
	 * ones implemented by superclasses.
	 * <p>
	 * If the class itself is an interface, it gets returned as sole interface.
	 * 
	 * @param clazz
	 *            the class to analyze for interfaces
	 * @return all interfaces that the given object implements as array
	 */
	public static Class<?>[] getAllInterfacesForClass(Class<?> clazz) {
		return getAllInterfacesForClass(clazz, null);
	}

	/**
	 * Return all interfaces that the given class implements as array, including
	 * ones implemented by superclasses.
	 * <p>
	 * If the class itself is an interface, it gets returned as sole interface.
	 * 
	 * @param clazz
	 *            the class to analyze for interfaces
	 * @param classLoader
	 *            the ClassLoader that the interfaces need to be visible in (may
	 *            be <code>null</code> when accepting all declared interfaces)
	 * @return all interfaces that the given object implements as array
	 */
	public static Class<?>[] getAllInterfacesForClass(Class<?> clazz, ClassLoader classLoader) {
		Set<Class<?>> ifcs = getAllInterfacesForClassAsSet(clazz, classLoader);
		return ifcs.toArray(new Class[ifcs.size()]);
	}

	/**
	 * Return all interfaces that the given class implements as Set, including
	 * ones implemented by superclasses.
	 * <p>
	 * If the class itself is an interface, it gets returned as sole interface.
	 * 
	 * @param clazz
	 *            the class to analyze for interfaces
	 * @return all interfaces that the given object implements as Set
	 */
	public static Set<Class<?>> getAllInterfacesForClassAsSet(Class<?> clazz) {
		return getAllInterfacesForClassAsSet(clazz, null);
	}

	/**
	 * Return all interfaces that the given class implements as Set, including
	 * ones implemented by superclasses.
	 * <p>
	 * If the class itself is an interface, it gets returned as sole interface.
	 * 
	 * @param clazz
	 *            the class to analyze for interfaces
	 * @param classLoader
	 *            the ClassLoader that the interfaces need to be visible in (may
	 *            be <code>null</code> when accepting all declared interfaces)
	 * @return all interfaces that the given object implements as Set
	 */
	public static Set<Class<?>> getAllInterfacesForClassAsSet(Class<?> clazz, ClassLoader classLoader) {
		Assert.notNull(clazz, "Class must not be null");
/*		if (clazz.isInterface() && isVisible(clazz, classLoader)) {
			return Collections.singleton(clazz);
		}*/
		Set<Class<?>> interfaces = new LinkedHashSet<Class<?>>();
		while (clazz != null) {
			Class<?>[] ifcs = clazz.getInterfaces();
			for (Class<?> ifc : ifcs) {
				interfaces.addAll(getAllInterfacesForClassAsSet(ifc, classLoader));
			}
			clazz = clazz.getSuperclass();
		}
		return interfaces;
	}

	/**
	 * Determine the name of the class file, relative to the containing package:
	 * e.g. "String.class"
	 * 
	 * @param clazz
	 *            the class
	 * @return the file name of the ".class" file
	 */
	public static String getClassFileName(Class<?> clazz) {
		Assert.notNull(clazz, "Class must not be null");
		String className = clazz.getName();
		int lastDotIndex = className.lastIndexOf(PACKAGE_SEPARATOR);
		return className.substring(lastDotIndex + 1) + CLASS_FILE_SUFFIX;
	}

	/**
	 * Determine whether the given class has a public constructor with the given
	 * signature, and return it if available (else return <code>null</code>).
	 * <p>
	 * Essentially translates <code>NoSuchMethodException</code> to
	 * <code>null</code>.
	 * 
	 * @param clazz
	 *            the clazz to analyze
	 * @param paramTypes
	 *            the parameter types of the method
	 * @return the constructor, or <code>null</code> if not found
	 * @see java.lang.Class#getConstructor
	 */
	public static <T> Constructor<T> getConstructorIfAvailable(Class<T> clazz, Class<?>... paramTypes) {
		Assert.notNull(clazz, "Class must not be null");
		try {
			return clazz.getConstructor(paramTypes);
		} catch (NoSuchMethodException ex) {
			return null;
		}
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
			cl = ReflectUtil.class.getClassLoader();
		}
		return cl;
	}

	/**
	 * Return a descriptive name for the given object's type: usually simply the
	 * class name, but component type class name + "[]" for arrays, and an
	 * appended list of implemented interfaces for JDK proxies.
	 * 
	 * @param value
	 *            the value to introspect
	 * @return the qualified name of the class
	 */
	public static String getDescriptiveType(Object value) {
		if (value == null) {
			return null;
		}
		Class<?> clazz = value.getClass();
		if (Proxy.isProxyClass(clazz)) {
			StringBuilder result = new StringBuilder(clazz.getName());
			result.append(" implementing ");
			Class<?>[] ifcs = clazz.getInterfaces();
			for (int i = 0; i < ifcs.length; i++) {
				result.append(ifcs[i].getName());
				if (i < (ifcs.length - 1)) {
					result.append(',');
				}
			}
			return result.toString();
		} else if (clazz.isArray()) {
			return getQualifiedNameForArray(clazz);
		} else {
			return clazz.getName();
		}
	}

	/**
	 * Get the field represented by the supplied {@link Field field object} on
	 * the specified {@link Object target object}. In accordance with
	 * {@link Field#get(Object)} semantics, the returned value is automatically
	 * wrapped if the underlying field has a primitive type.
	 * <p>
	 * Thrown exceptions are handled via a call to
	 * {@link #handleReflectionException(Exception)}.
	 * 
	 * @param field
	 *            the field to get
	 * @param target
	 *            the target object from which to get the field
	 * @return the field's current value
	 */
	public static Object getField(Field field, Object target) {
		try {
			return field.get(target);
		} catch (IllegalAccessException ex) {
			handleReflectionException(ex);
			throw new IllegalStateException("Unexpected reflection exception - " + ex.getClass().getName() + ": " + ex.getMessage());
		}
	}

	/**
	 * Return the number of methods with a given name (with any argument types),
	 * for the given class and/or its superclasses. Includes non-public methods.
	 * 
	 * @param clazz
	 *            the clazz to check
	 * @param methodName
	 *            the name of the method
	 * @return the number of methods with the given name
	 */
	public static int getMethodCountForName(Class<?> clazz, String methodName) {
		Assert.notNull(clazz, "Class must not be null");
		Assert.notNull(methodName, "Method name must not be null");
		int count = 0;
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for (Method method : declaredMethods) {
			if (methodName.equals(method.getName())) {
				count++;
			}
		}
		Class<?>[] ifcs = clazz.getInterfaces();
		for (Class<?> ifc : ifcs) {
			count += getMethodCountForName(ifc, methodName);
		}
		if (clazz.getSuperclass() != null) {
			count += getMethodCountForName(clazz.getSuperclass(), methodName);
		}
		return count;
	}

	public static String getMethodFullName(Method method) {
		Class<?> declaringClass = method.getDeclaringClass();
		Class<?>[] pars = method.getParameterTypes();
		StringBuffer methodFullName = new StringBuffer();
		methodFullName.append(declaringClass.getName()).append(".").append(method.getName()).append("(");
		for (Class<?> par : pars) {
			methodFullName.append(",").append(par.getSimpleName());
		}
		methodFullName.append(")");
		return methodFullName.toString().replaceFirst(",", "");
	}

	/**
	 * Determine whether the given class has a method with the given signature,
	 * and return it if available (else return <code>null</code>).
	 * <p>
	 * Essentially translates <code>NoSuchMethodException</code> to
	 * <code>null</code>.
	 * 
	 * @param clazz
	 *            the clazz to analyze
	 * @param methodName
	 *            the name of the method
	 * @param paramTypes
	 *            the parameter types of the method
	 * @return the method, or <code>null</code> if not found
	 * @see java.lang.Class#getMethod
	 */
	public static Method getMethodIfAvailable(Class<?> clazz, String methodName, Class<?>... paramTypes) {
		Assert.notNull(clazz, "Class must not be null");
		Assert.notNull(methodName, "Method name must not be null");
		try {
			return clazz.getMethod(methodName, paramTypes);
		} catch (NoSuchMethodException ex) {
			return null;
		}
	}

	/**
	 * Given a method, which may come from an interface, and a target class used
	 * in the current reflective invocation, find the corresponding target
	 * method if there is one. E.g. the method may be <code>IFoo.bar()</code>
	 * and the target class may be <code>DefaultFoo</code>. In this case, the
	 * method may be <code>DefaultFoo.bar()</code>. This enables attributes on
	 * that method to be found.
	 * <p>
	 * <b>NOTE:</b> In contrast to
	 * {@link org.springframework.aop.support.AopUtils#getMostSpecificMethod},
	 * this method does <i>not</i> resolve Java 5 bridge methods automatically.
	 * Call
	 * {@link org.springframework.core.BridgeMethodResolver#findBridgedMethod}
	 * if bridge method resolution is desirable (e.g. for obtaining metadata
	 * from the original method definition).
	 * 
	 * @param method
	 *            the method to be invoked, which may come from an interface
	 * @param targetClass
	 *            the target class for the current invocation. May be
	 *            <code>null</code> or may not even implement the method.
	 * @return the specific target method, or the original method if the
	 *         <code>targetClass</code> doesn't implement it or is
	 *         <code>null</code>
	 */
	public static Method getMostSpecificMethod(Method method, Class<?> targetClass) {
		Method specificMethod = null;
		if ((method != null) && isOverridable(method, targetClass) && (targetClass != null) && !targetClass.equals(method.getDeclaringClass())) {
			specificMethod = findMethod(targetClass, method.getName(), method.getParameterTypes());
		}
		return (specificMethod != null ? specificMethod : method);
	}

	/**
	 * Determine the name of the package of the given class: e.g. "java.lang"
	 * for the <code>java.lang.String</code> class.
	 * 
	 * @param clazz
	 *            the class
	 * @return the package name, or the empty String if the class is defined in
	 *         the default package
	 */
	public static String getPackageName(Class<?> clazz) {
		Assert.notNull(clazz, "Class must not be null");
		String className = clazz.getName();
		int lastDotIndex = className.lastIndexOf(PACKAGE_SEPARATOR);
		return (lastDotIndex != -1 ? className.substring(0, lastDotIndex) : "");
	}

	/**
	 * Return the qualified name of the given method, consisting of fully
	 * qualified interface/class name + "." + method name.
	 * 
	 * @param method
	 *            the method
	 * @return the qualified name of the method
	 */
	public static String getQualifiedMethodName(Method method) {
		Assert.notNull(method, "Method must not be null");
		return method.getDeclaringClass().getName() + "." + method.getName();
	}

	/**
	 * Return the qualified name of the given class: usually simply the class
	 * name, but component type class name + "[]" for arrays.
	 * 
	 * @param clazz
	 *            the class
	 * @return the qualified name of the class
	 */
	public static String getQualifiedName(Class<?> clazz) {
		Assert.notNull(clazz, "Class must not be null");
		if (clazz.isArray()) {
			return getQualifiedNameForArray(clazz);
		} else {
			return clazz.getName();
		}
	}

	/**
	 * Build a nice qualified name for an array: component type class name +
	 * "[]".
	 * 
	 * @param clazz
	 *            the array class
	 * @return a qualified name for the array class
	 */
	private static String getQualifiedNameForArray(Class<?> clazz) {
		StringBuilder result = new StringBuilder();
		while (clazz.isArray()) {
			clazz = clazz.getComponentType();
			result.append(ReflectUtil.ARRAY_SUFFIX);
		}
		result.insert(0, clazz.getName());
		return result.toString();
	}

	/**
	 * Get the class name without the qualified package name.
	 * 
	 * @param clazz
	 *            the class to get the short name for
	 * @return the class name of the class without the package name
	 */
	public static String getShortName(Class<?> clazz) {
		return getShortName(getQualifiedName(clazz));
	}

	/**
	 * Get the class name without the qualified package name.
	 * 
	 * @param className
	 *            the className to get the short name for
	 * @return the class name of the class without the package name
	 * @throws IllegalArgumentException
	 *             if the className is empty
	 */
	public static String getShortName(String className) {
		Assert.hasLength(className, "Class name must not be empty");
		int lastDotIndex = className.lastIndexOf(PACKAGE_SEPARATOR);
		int nameEndIndex = className.indexOf(CGLIB_CLASS_SEPARATOR);
		if (nameEndIndex == -1) {
			nameEndIndex = className.length();
		}
		String shortName = className.substring(lastDotIndex + 1, nameEndIndex);
		shortName = shortName.replace(INNER_CLASS_SEPARATOR, PACKAGE_SEPARATOR);
		return shortName;
	}

	/**
	 * Return the short string name of a Java class in uncapitalized JavaBeans
	 * property format. Strips the outer class name in case of an inner class.
	 * 
	 * @param clazz
	 *            the class
	 * @return the short name rendered in a standard JavaBeans property format
	 * @see java.beans.Introspector#decapitalize(String)
	 */
	public static String getShortNameAsProperty(Class<?> clazz) {
		String shortName = ReflectUtil.getShortName(clazz);
		int dotIndex = shortName.lastIndexOf(PACKAGE_SEPARATOR);
		shortName = (dotIndex != -1 ? shortName.substring(dotIndex + 1) : shortName);
		return Introspector.decapitalize(shortName);
	}

	/**
	 * Return a public static method of a class.
	 * 
	 * @param methodName
	 *            the static method name
	 * @param clazz
	 *            the class which defines the method
	 * @param args
	 *            the parameter types to the method
	 * @return the static method, or <code>null</code> if no static method was
	 *         found
	 * @throws IllegalArgumentException
	 *             if the method name is blank or the clazz is null
	 */
	public static Method getStaticMethod(Class<?> clazz, String methodName, Class<?>... args) {
		Assert.notNull(clazz, "Class must not be null");
		Assert.notNull(methodName, "Method name must not be null");
		try {
			Method method = clazz.getMethod(methodName, args);
			return Modifier.isStatic(method.getModifiers()) ? method : null;
		} catch (NoSuchMethodException ex) {
			return null;
		}
	}

	/**
	 * Return the user-defined class for the given class: usually simply the
	 * given class, but the original class in case of a CGLIB-generated
	 * subclass.
	 * 
	 * @param clazz
	 *            the class to check
	 * @return the user-defined class
	 */
	public static Class<?> getUserClass(Class<?> clazz) {
		if ((clazz != null) && clazz.getName().contains(CGLIB_CLASS_SEPARATOR)) {
			Class<?> superClass = clazz.getSuperclass();
			if ((superClass != null) && !Object.class.equals(superClass)) {
				return superClass;
			}
		}
		return clazz;
	}

	/**
	 * Return the user-defined class for the given instance: usually simply the
	 * class of the given instance, but the original class in case of a
	 * CGLIB-generated subclass.
	 * 
	 * @param instance
	 *            the instance to check
	 * @return the user-defined class
	 */
	public static Class<?> getUserClass(Object instance) {
		Assert.notNull(instance, "Instance must not be null");
		return getUserClass(instance.getClass());
	}

	/**
	 * Obtain a new MethodParameter object for the write method of the specified
	 * property.
	 * 
	 * @param pd
	 *            the PropertyDescriptor for the property
	 * @return a corresponding MethodParameter object
	 */
	public static MethodParameter getWriteMethodParameter(PropertyDescriptor pd) {
		if (pd instanceof GenericTypeAwarePropertyDescriptor) {
			return new MethodParameter(((GenericTypeAwarePropertyDescriptor) pd).getWriteMethodParameter());
		} else {
			return new MethodParameter(pd.getWriteMethod(), 0);
		}
	}

	/**
	 * Handle the given invocation target exception. Should only be called if no
	 * checked exception is expected to be thrown by the target method.
	 * <p>
	 * Throws the underlying RuntimeException or Error in case of such a root
	 * cause. Throws an IllegalStateException else.
	 * 
	 * @param ex
	 *            the invocation target exception to handle
	 */
	public static void handleInvocationTargetException(InvocationTargetException ex) {
		rethrowRuntimeException(ex.getTargetException());
	}

	/**
	 * Handle the given reflection exception. Should only be called if no
	 * checked exception is expected to be thrown by the target method.
	 * <p>
	 * Throws the underlying RuntimeException or Error in case of an
	 * InvocationTargetException with such a root cause. Throws an
	 * IllegalStateException with an appropriate message else.
	 * 
	 * @param ex
	 *            the reflection exception to handle
	 */
	public static void handleReflectionException(Exception ex) {
		if (ex instanceof NoSuchMethodException) {
			throw new IllegalStateException("Method not found: " + ex.getMessage());
		}
		if (ex instanceof IllegalAccessException) {
			throw new IllegalStateException("Could not access method: " + ex.getMessage());
		}
		if (ex instanceof InvocationTargetException) {
			handleInvocationTargetException((InvocationTargetException) ex);
		}
		if (ex instanceof RuntimeException) {
			throw (RuntimeException) ex;
		}
		handleUnexpectedException(ex);
	}

	/**
	 * Throws an IllegalStateException with the given exception as root cause.
	 * 
	 * @param ex
	 *            the unexpected exception
	 */
	private static void handleUnexpectedException(Throwable ex) {
		throw new IllegalStateException("Unexpected exception thrown", ex);
	}

	/**
	 * Does the given class or one of its superclasses at least have one or more
	 * methods with the supplied name (with any argument types)? Includes
	 * non-public methods.
	 * 
	 * @param clazz
	 *            the clazz to check
	 * @param methodName
	 *            the name of the method
	 * @return whether there is at least one method with the given name
	 */
	public static boolean hasAtLeastOneMethodWithName(Class<?> clazz, String methodName) {
		Assert.notNull(clazz, "Class must not be null");
		Assert.notNull(methodName, "Method name must not be null");
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for (Method method : declaredMethods) {
			if (method.getName().equals(methodName)) {
				return true;
			}
		}
		Class<?>[] ifcs = clazz.getInterfaces();
		for (Class<?> ifc : ifcs) {
			if (hasAtLeastOneMethodWithName(ifc, methodName)) {
				return true;
			}
		}
		return ((clazz.getSuperclass() != null) && hasAtLeastOneMethodWithName(clazz.getSuperclass(), methodName));
	}

	/**
	 * Determine whether the given class has a public constructor with the given
	 * signature.
	 * <p>
	 * Essentially translates <code>NoSuchMethodException</code> to "false".
	 * 
	 * @param clazz
	 *            the clazz to analyze
	 * @param paramTypes
	 *            the parameter types of the method
	 * @return whether the class has a corresponding constructor
	 * @see java.lang.Class#getMethod
	 */
	public static boolean hasConstructor(Class<?> clazz, Class<?>... paramTypes) {
		return (getConstructorIfAvailable(clazz, paramTypes) != null);
	}

	/**
	 * Determine whether the given class has a method with the given signature.
	 * <p>
	 * Essentially translates <code>NoSuchMethodException</code> to "false".
	 * 
	 * @param clazz
	 *            the clazz to analyze
	 * @param methodName
	 *            the name of the method
	 * @param paramTypes
	 *            the parameter types of the method
	 * @return whether the class has a corresponding method
	 * @see java.lang.Class#getMethod
	 */
	public static boolean hasMethod(Class<?> clazz, String methodName, Class<?>... paramTypes) {
		return (getMethodIfAvailable(clazz, methodName, paramTypes) != null);
	}

	/*
	public static Object instanceByClass(Class<?> clazz) {
	Object instance = null;
	try {
		instance = clazz.newInstance();
	} catch (Exception e) {
		// throw new ClassInstanceException(e);
	}
	return instance;
	}*/

	public static Object instanceByClassName(String className) {
		Object instance = null;
		try {
			instance = Class.forName(className).newInstance();
		} catch (Exception e) {
			// throw ClassInstanceException(e);
		}
		return instance;
	}


	public static Object instanceByClassNameWithDefaultClass(String instClassName, String defaultClassName) {
		if ((instClassName != null) && (instClassName.trim().length() > 0)) {
			return instanceByClassName(instClassName);
		}
		return instanceByClassName(defaultClassName);
	}


	public static Object instanceByClassWithDefaultClass(Class<?> instClass, Class<?> defaultClass) {
		if (instClass != null) {
			return instantiate(instClass);
		}
		return instantiate(defaultClass);
	}

	/**
	 * Convenience method to instantiate a class using its no-arg constructor.
	 * As this method doesn't try to load classes by name, it should avoid
	 * class-loading issues.
	 * 
	 * @param clazz
	 *            class to instantiate
	 * @return the new instance
	 * @throws BeanInstantiationException
	 *             if the bean cannot be instantiated
	 */
	public static <T> T instantiate(Class<T> clazz) throws BeansException {
		Assert.notNull(clazz, "Class must not be null");
		if (clazz.isInterface()) {
			throw new BeansException(clazz, "Specified class is an interface");
		}
		try {
			return clazz.newInstance();
		} catch (InstantiationException ex) {
			throw new BeansException(clazz, "Is it an abstract class?", ex);
		} catch (IllegalAccessException ex) {
			throw new BeansException(clazz, "Is the constructor accessible?", ex);
		}
	}

	/**
	 * Convenience method to instantiate a class using its no-arg constructor.
	 * As this method doesn't try to load classes by name, it should avoid
	 * class-loading issues.
	 * <p>
	 * Note that this method tries to set the constructor accessible if given a
	 * non-accessible (that is, non-public) constructor.
	 * 
	 * @param clazz
	 *            class to instantiate
	 * @return the new instance
	 * @throws BeanInstantiationException
	 *             if the bean cannot be instantiated
	 */
	public static <T> T instantiateClass(Class<T> clazz) throws BeansException {
		Assert.notNull(clazz, "Class must not be null");
		if (clazz.isInterface()) {
			throw new BeansException(clazz, "Specified class is an interface");
		}
		try {
			return instantiateClass(clazz.getDeclaredConstructor());
		} catch (NoSuchMethodException ex) {
			throw new BeansException(clazz, "No default constructor found", ex);
		}
	}

	/**
	 * Convenience method to instantiate a class using the given constructor. As
	 * this method doesn't try to load classes by name, it should avoid
	 * class-loading issues.
	 * <p>
	 * Note that this method tries to set the constructor accessible if given a
	 * non-accessible (that is, non-public) constructor.
	 * 
	 * @param ctor
	 *            the constructor to instantiate
	 * @param args
	 *            the constructor arguments to apply
	 * @return the new instance
	 * @throws BeanInstantiationException
	 *             if the bean cannot be instantiated
	 */
	public static <T> T instantiateClass(Constructor<T> ctor, Object... args) throws BeansException {
		Assert.notNull(ctor, "Constructor must not be null");
		try {
			makeAccessible(ctor);
			return ctor.newInstance(args);
		} catch (InstantiationException ex) {
			throw new BeansException(ctor.getDeclaringClass(), "Is it an abstract class?", ex);
		} catch (IllegalAccessException ex) {
			throw new BeansException(ctor.getDeclaringClass(), "Is the constructor accessible?", ex);
		} catch (IllegalArgumentException ex) {
			throw new BeansException(ctor.getDeclaringClass(), "Illegal arguments for constructor", ex);
		} catch (InvocationTargetException ex) {
			throw new BeansException(ctor.getDeclaringClass(), "Constructor threw exception", ex.getTargetException());
		}
	}

	/*	*//**
	 * Invoke the specified JDBC API {@link Method} against the supplied
	 * target object with no arguments.
	 * 
	 * @param method
	 *            the method to invoke
	 * @param target
	 *            the target object to invoke the method on
	 * @return the invocation result, if any
	 * @throws SQLException
	 *             the JDBC API SQLException to rethrow (if any)
	 * @see #invokeJdbcMethod(java.lang.reflect.Method, Object, Object[])
	 */
	/*
	public static Object invokeJdbcMethod(Method method, Object target) throws SQLException {
	return invokeJdbcMethod(method, target, new Object[0]);
	}

	*//**
	 * Invoke the specified JDBC API {@link Method} against the supplied
	 * target object with the supplied arguments.
	 * 
	 * @param method
	 *            the method to invoke
	 * @param target
	 *            the target object to invoke the method on
	 * @param args
	 *            the invocation arguments (may be <code>null</code>)
	 * @return the invocation result, if any
	 * @throws SQLException
	 *             the JDBC API SQLException to rethrow (if any)
	 * @see #invokeMethod(java.lang.reflect.Method, Object, Object[])
	 */
	/*
	public static Object invokeJdbcMethod(Method method, Object target, Object... args) throws SQLException {
	try {
		return method.invoke(target, args);
	} catch (IllegalAccessException ex) {
		handleReflectionException(ex);
	} catch (InvocationTargetException ex) {
		if (ex.getTargetException() instanceof SQLException) {
			throw (SQLException) ex.getTargetException();
		}
		handleInvocationTargetException(ex);
	}
	throw new IllegalStateException("Should never get here");
	}*/
	/**
	 * Invoke the specified {@link Method} against the supplied target object
	 * with no arguments. The target object can be <code>null</code> when
	 * invoking a static {@link Method}.
	 * <p>
	 * Thrown exceptions are handled via a call to
	 * {@link #handleReflectionException}.
	 * 
	 * @param method
	 *            the method to invoke
	 * @param target
	 *            the target object to invoke the method on
	 * @return the invocation result, if any
	 * @see #invokeMethod(java.lang.reflect.Method, Object, Object[])
	 */
	public static Object invokeMethod(Method method, Object target) {
		return invokeMethod(method, target, new Object[0]);
	}

	/**
	 * Invoke the specified {@link Method} against the supplied target object
	 * with the supplied arguments. The target object can be <code>null</code>
	 * when invoking a static {@link Method}.
	 * <p>
	 * Thrown exceptions are handled via a call to
	 * {@link #handleReflectionException}.
	 * 
	 * @param method
	 *            the method to invoke
	 * @param target
	 *            the target object to invoke the method on
	 * @param args
	 *            the invocation arguments (may be <code>null</code>)
	 * @return the invocation result, if any
	 */
	public static Object invokeMethod(Method method, Object target, Object... args) {
		try {
			return method.invoke(target, args);
		} catch (Exception ex) {
			handleReflectionException(ex);
		}
		throw new IllegalStateException("Should never get here");
	}

	/**
	 * Check whether the given class is cache-safe in the given context, i.e.
	 * whether it is loaded by the given ClassLoader or a parent of it.
	 * 
	 * @param clazz
	 *            the class to analyze
	 * @param classLoader
	 *            the ClassLoader to potentially cache metadata in
	 */
	public static boolean isCacheSafe(Class<?> clazz, ClassLoader classLoader) {
		Assert.notNull(clazz, "Class must not be null");
		ClassLoader target = clazz.getClassLoader();
		if (target == null) {
			return false;
		}
		ClassLoader cur = classLoader;
		if (cur == target) {
			return true;
		}
		while (cur != null) {
			cur = cur.getParent();
			if (cur == target) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Determine whether the given method is an "equals" method.
	 * 
	 * @see java.lang.Object#equals(Object)
	 */
	public static boolean isEqualsMethod(Method method) {
		if ((method == null) || !method.getName().equals("equals")) {
			return false;
		}
		Class<?>[] paramTypes = method.getParameterTypes();
		return ((paramTypes.length == 1) && (paramTypes[0] == Object.class));
	}

	public static Boolean isFieldInClass(Class<?> cl, String fieldName) {
		boolean flag = false;
		Field[] fields = cl.getDeclaredFields();
		for (Field field : fields) {
			field.getName().equalsIgnoreCase(fieldName);
			flag = true;
			break;
		}
		return flag;
	}

	/**
	 * 判断目标class是否定义了当前方法
	 */
	public static Boolean isHadMethod(Class<?> targetClazz, Method method) {
		Class<?> methodDeclarClass = method.getDeclaringClass();
		if (targetClazz == methodDeclarClass) {
			return true;
		}
		return false;
	}

	/**
	 * Determine whether the given method is a "hashCode" method.
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public static boolean isHashCodeMethod(Method method) {
		return ((method != null) && method.getName().equals("hashCode") && (method.getParameterTypes().length == 0));
	}

	/**
	 * Determine whether the given method is overridable in the given target
	 * class.
	 * 
	 * @param method
	 *            the method to check
	 * @param targetClass
	 *            the target class to check against
	 */
	public static boolean isOverridable(Method method, Class<?> targetClass) {
		if (Modifier.isPrivate(method.getModifiers())) {
			return false;
		}
		if (Modifier.isPublic(method.getModifiers()) || Modifier.isProtected(method.getModifiers())) {
			return true;
		}
		return getPackageName(method.getDeclaringClass()).equals(getPackageName(targetClass));
	}

	/**
	 * Determine whether the given field is a "public static final" constant.
	 * 
	 * @param field
	 *            the field to check
	 */
	public static boolean isPublicStaticFinal(Field field) {
		int modifiers = field.getModifiers();
		return (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers));
	}

	/**
	 * Determine whether the given method is a "toString" method.
	 * 
	 * @see java.lang.Object#toString()
	 */
	public static boolean isToStringMethod(Method method) {
		return ((method != null) && method.getName().equals("toString") && (method.getParameterTypes().length == 0));
	}

	/**
	 * Check whether the given class is visible in the given ClassLoader.
	 * 
	 * @param clazz
	 *            the class to check (typically an interface)
	 * @param classLoader
	 *            the ClassLoader to check against (may be <code>null</code>, in
	 *            which case this method will always return <code>true</code>)
	 */
	public static boolean isVisible(Class<?> clazz, ClassLoader classLoader) {
		if (classLoader == null) {
			return true;
		}
		try {
			Class<?> actualClass = classLoader.loadClass(clazz.getName());
			return (clazz == actualClass);
			// Else: different interface class found...
		} catch (ClassNotFoundException ex) {
			// No interface class found...
			return false;
		}
	}

	/**
	 * Make the given constructor accessible, explicitly setting it accessible
	 * if necessary. The <code>setAccessible(true)</code> method is only called
	 * when actually necessary, to avoid unnecessary conflicts with a JVM
	 * SecurityManager (if active).
	 * 
	 * @param ctor
	 *            the constructor to make accessible
	 * @see java.lang.reflect.Constructor#setAccessible
	 */
	public static void makeAccessible(Constructor<?> ctor) {
		if ((!Modifier.isPublic(ctor.getModifiers()) || !Modifier.isPublic(ctor.getDeclaringClass().getModifiers())) && !ctor.isAccessible()) {
			ctor.setAccessible(true);
		}
	}

	/**
	 * Make the given field accessible, explicitly setting it accessible if
	 * necessary. The <code>setAccessible(true)</code> method is only called
	 * when actually necessary, to avoid unnecessary conflicts with a JVM
	 * SecurityManager (if active).
	 * 
	 * @param field
	 *            the field to make accessible
	 * @see java.lang.reflect.Field#setAccessible
	 */
	public static void makeAccessible(Field field) {
		if ((!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers()) || Modifier.isFinal(field.getModifiers()))
				&& !field.isAccessible()) {
			field.setAccessible(true);
		}
	}

	/**
	 * Make the given method accessible, explicitly setting it accessible if
	 * necessary. The <code>setAccessible(true)</code> method is only called
	 * when actually necessary, to avoid unnecessary conflicts with a JVM
	 * SecurityManager (if active).
	 * 
	 * @param method
	 *            the method to make accessible
	 * @see java.lang.reflect.Method#setAccessible
	 */
	public static void makeAccessible(Method method) {
		if ((!Modifier.isPublic(method.getModifiers()) || !Modifier.isPublic(method.getDeclaringClass().getModifiers())) && !method.isAccessible()) {
			method.setAccessible(true);
		}
	}

	/**
	 * Check whether the given class matches the user-specified type name.
	 * 
	 * @param clazz
	 *            the class to check
	 * @param typeName
	 *            the type name to match
	 */
	public static boolean matchesTypeName(Class<?> clazz, String typeName) {
		return ((typeName != null) && (typeName.equals(clazz.getName()) || typeName.equals(clazz.getSimpleName()) || (clazz.isArray() && typeName
				.equals(getQualifiedNameForArray(clazz)))));
	}

	/**
	 * Override the thread context ClassLoader with the environment's bean
	 * ClassLoader if necessary, i.e. if the bean ClassLoader is not equivalent
	 * to the thread context ClassLoader already.
	 * 
	 * @param classLoaderToUse
	 *            the actual ClassLoader to use for the thread context
	 * @return the original thread context ClassLoader, or <code>null</code> if
	 *         not overridden
	 */
	public static ClassLoader overrideThreadContextClassLoader(ClassLoader classLoaderToUse) {
		Thread currentThread = Thread.currentThread();
		ClassLoader threadContextClassLoader = currentThread.getContextClassLoader();
		if ((classLoaderToUse != null) && !classLoaderToUse.equals(threadContextClassLoader)) {
			currentThread.setContextClassLoader(classLoaderToUse);
			return threadContextClassLoader;
		} else {
			return null;
		}
	}

	/**
	 * Convert a "/"-based resource path to a "."-based fully qualified class
	 * name.
	 * 
	 * @param resourcePath
	 *            the resource path pointing to a class
	 * @return the corresponding fully qualified class name
	 */
	public static String resourcePathToClassName(String resourcePath) {
		Assert.notNull(resourcePath, "Resource path must not be null");
		return resourcePath.replace(PATH_SEPARATOR, PACKAGE_SEPARATOR);
	}

	/**
	 * Rethrow the given {@link Throwable exception}, which is presumably the
	 * <em>target exception</em> of an {@link InvocationTargetException}. Should
	 * only be called if no checked exception is expected to be thrown by the
	 * target method.
	 * <p>
	 * Rethrows the underlying exception cast to an {@link Exception} or
	 * {@link Error} if appropriate; otherwise, throws an
	 * {@link IllegalStateException}.
	 * 
	 * @param ex
	 *            the exception to rethrow
	 * @throws Exception
	 *             the rethrown exception (in case of a checked exception)
	 */
	public static void rethrowException(Throwable ex) throws Exception {
		if (ex instanceof Exception) {
			throw (Exception) ex;
		}
		if (ex instanceof Error) {
			throw (Error) ex;
		}
		handleUnexpectedException(ex);
	}

	/**
	 * Rethrow the given {@link Throwable exception}, which is presumably the
	 * <em>target exception</em> of an {@link InvocationTargetException}. Should
	 * only be called if no checked exception is expected to be thrown by the
	 * target method.
	 * <p>
	 * Rethrows the underlying exception cast to an {@link RuntimeException} or
	 * {@link Error} if appropriate; otherwise, throws an
	 * {@link IllegalStateException}.
	 * 
	 * @param ex
	 *            the exception to rethrow
	 * @throws RuntimeException
	 *             the rethrown exception
	 */
	public static void rethrowRuntimeException(Throwable ex) {
		if (ex instanceof RuntimeException) {
			throw (RuntimeException) ex;
		}
		if (ex instanceof Error) {
			throw (Error) ex;
		}
		handleUnexpectedException(ex);
	}

	/**
	 * Set the field represented by the supplied {@link Field field object} on
	 * the specified {@link Object target object} to the specified
	 * <code>value</code>. In accordance with {@link Field#set(Object, Object)}
	 * semantics, the new value is automatically unwrapped if the underlying
	 * field has a primitive type.
	 * <p>
	 * Thrown exceptions are handled via a call to
	 * {@link #handleReflectionException(Exception)}.
	 * 
	 * @param field
	 *            the field to set
	 * @param target
	 *            the target object on which to set the field
	 * @param value
	 *            the value to set; may be <code>null</code>
	 */
	public static void setField(Field field, Object target, Object value) {
		try {
			field.set(target, value);
		} catch (IllegalAccessException ex) {
			handleReflectionException(ex);
			throw new IllegalStateException("Unexpected reflection exception - " + ex.getClass().getName() + ": " + ex.getMessage());
		}
	}

	/**
	 * Given the source object and the destination, which must be the same class
	 * or a subclass, copy all fields, including inherited fields. Designed to
	 * work on objects with public no-arg constructors.
	 * 
	 * @throws IllegalArgumentException
	 *             if the arguments are incompatible
	 */
	public static void shallowCopyFieldState(final Object src, final Object dest) throws IllegalArgumentException {
		if (src == null) {
			throw new IllegalArgumentException("Source for field copy cannot be null");
		}
		if (dest == null) {
			throw new IllegalArgumentException("Destination for field copy cannot be null");
		}
		if (!src.getClass().isAssignableFrom(dest.getClass())) {
			throw new IllegalArgumentException("Destination class [" + dest.getClass().getName() + "] must be same or subclass as source class [" + src.getClass().getName() + "]");
		}
		doWithFields(src.getClass(), new FieldCallback() {

			@Override
			public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
				makeAccessible(field);
				Object srcValue = field.get(src);
				field.set(dest, srcValue);
			}
		}, COPYABLE_FIELDS);
	}

	/**
	 * Retrieve the JavaBeans <code>PropertyDescriptors</code> for the given
	 * property.
	 * 
	 * @param clazz
	 *            the Class to retrieve the PropertyDescriptor for
	 * @param propertyName
	 *            the name of the property
	 * @return the corresponding PropertyDescriptor, or <code>null</code> if
	 *         none
	 * @throws BeansException
	 *             if PropertyDescriptor lookup fails
	 */
	public static PropertyDescriptor getPropertyDescriptor(Class<?> clazz, String propertyName) throws BeansException {
		CachedIntrospectionResults cr = CachedIntrospectionResults.forClass(clazz);
		return cr.getPropertyDescriptor(propertyName);
	}

	/**
	 * Retrieve the JavaBeans <code>PropertyDescriptor</code>s of a given class.
	 * 
	 * @param clazz
	 *            the Class to retrieve the PropertyDescriptors for
	 * @return an array of <code>PropertyDescriptors</code> for the given class
	 * @throws BeansException
	 *             if PropertyDescriptor look fails
	 */
	public static PropertyDescriptor[] getPropertyDescriptors(Class<?> clazz) throws BeansException {
		CachedIntrospectionResults cr = CachedIntrospectionResults.forClass(clazz);
		return cr.getPropertyDescriptors();
	}

	/**
	 * Copy the property values of the given source bean into the target bean.
	 * <p>
	 * Note: The source and target classes do not have to match or even be
	 * derived from each other, as long as the properties match. Any bean
	 * properties that the source bean exposes but the target bean does not will
	 * silently be ignored.
	 * <p>
	 * This is just a convenience method. For more complex transfer needs,
	 * consider using a full BeanWrapper.
	 * 
	 * @param source
	 *            the source bean
	 * @param target
	 *            the target bean
	 * @throws BeansException
	 *             if the copying failed
	 * @see BeanWrapper
	 */
	public static void copyProperties(Object source, Object target) throws BeansException {
		copyProperties(source, target, null, null);
	}

	/**
	 * Copy the property values of the given source bean into the given target
	 * bean, only setting properties defined in the given "editable" class (or
	 * interface).
	 * <p>
	 * Note: The source and target classes do not have to match or even be
	 * derived from each other, as long as the properties match. Any bean
	 * properties that the source bean exposes but the target bean does not will
	 * silently be ignored.
	 * <p>
	 * This is just a convenience method. For more complex transfer needs,
	 * consider using a full BeanWrapper.
	 * 
	 * @param source
	 *            the source bean
	 * @param target
	 *            the target bean
	 * @param editable
	 *            the class (or interface) to restrict property setting to
	 * @throws BeansException
	 *             if the copying failed
	 * @see BeanWrapper
	 */
	public static void copyProperties(Object source, Object target, Class<?> editable) throws BeansException {
		copyProperties(source, target, editable, null);
	}

	/**
	 * Copy the property values of the given source bean into the given target
	 * bean.
	 * <p>
	 * Note: The source and target classes do not have to match or even be
	 * derived from each other, as long as the properties match. Any bean
	 * properties that the source bean exposes but the target bean does not will
	 * silently be ignored.
	 * 
	 * @param source
	 *            the source bean
	 * @param target
	 *            the target bean
	 * @param editable
	 *            the class (or interface) to restrict property setting to
	 * @param ignoreProperties
	 *            array of property names to ignore
	 * @throws BeansException
	 *             if the copying failed
	 * @see BeanWrapper
	 */
	private static void copyProperties(Object source, Object target, Class<?> editable, String[] ignoreProperties) throws BeansException {
		Assert.notNull(source, "Source must not be null");
		Assert.notNull(target, "Target must not be null");
		Class<?> actualEditable = target.getClass();
		if (editable != null) {
			if (!editable.isInstance(target)) {
				throw new IllegalArgumentException("Target class [" + target.getClass().getName() + "] not assignable to Editable class [" + editable.getName() + "]");
			}
			actualEditable = editable;
		}
		PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
		List<String> ignoreList = (ignoreProperties != null) ? Arrays.asList(ignoreProperties) : null;
		for (PropertyDescriptor targetPd : targetPds) {
			if ((targetPd.getWriteMethod() != null) && ((ignoreProperties == null) || (!ignoreList.contains(targetPd.getName())))) {
				PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
				if ((sourcePd != null) && (sourcePd.getReadMethod() != null)) {
					try {
						Method readMethod = sourcePd.getReadMethod();
						if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
							readMethod.setAccessible(true);
						}
						Object value = readMethod.invoke(source);
						Method writeMethod = targetPd.getWriteMethod();
						if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
							writeMethod.setAccessible(true);
						}
						writeMethod.invoke(target, value);
					} catch (Throwable ex) {
						throw new BeansException("Could not copy properties from source to target", ex);
					}
				}
			}
		}
	}

	/**
	 * Copy the property values of the given source bean into the given target
	 * bean, ignoring the given "ignoreProperties".
	 * <p>
	 * Note: The source and target classes do not have to match or even be
	 * derived from each other, as long as the properties match. Any bean
	 * properties that the source bean exposes but the target bean does not will
	 * silently be ignored.
	 * <p>
	 * This is just a convenience method. For more complex transfer needs,
	 * consider using a full BeanWrapper.
	 * 
	 * @param source
	 *            the source bean
	 * @param target
	 *            the target bean
	 * @param ignoreProperties
	 *            array of property names to ignore
	 * @throws BeansException
	 *             if the copying failed
	 * @see BeanWrapper
	 */
	public static void copyProperties(Object source, Object target, String[] ignoreProperties) throws BeansException {
		copyProperties(source, target, null, ignoreProperties);
	}

	public static final Map<Class<?>, Boolean> unknownEditorTypes = Collections.synchronizedMap(new WeakHashMap<Class<?>, Boolean>());

	/**
	 * Method to convert a ResourceBundle to a Properties object.
	 * 
	 * @param rb
	 *            a given resource bundle
	 * @return Properties a populated properties object
	 */
	public static Properties convertBundleToProperties(ResourceBundle rb) {
		Properties props = new Properties();
		for (Enumeration<String> keys = rb.getKeys(); keys.hasMoreElements();) {
			String key = keys.nextElement();
			props.put(key, rb.getString(key));
		}
		return props;
	}

	/**
	 * Find a JavaBeans PropertyEditor following the 'Editor' suffix convention
	 * (e.g. "mypackage.MyDomainClass" -> "mypackage.MyDomainClassEditor").
	 * <p>
	 * Compatible to the standard JavaBeans convention as implemented by
	 * {@link java.beans.PropertyEditorManager} but isolated from the latter's
	 * registered default editors for primitive types.
	 * 
	 * @param targetType
	 *            the type to find an editor for
	 * @return the corresponding editor, or <code>null</code> if none found
	 */
	public static PropertyEditor findEditorByConvention(Class<?> targetType) {
		if ((targetType == null) || targetType.isArray() || unknownEditorTypes.containsKey(targetType)) {
			return null;
		}
		ClassLoader cl = targetType.getClassLoader();
		if (cl == null) {
			try {
				cl = ClassLoader.getSystemClassLoader();
				if (cl == null) {
					return null;
				}
			} catch (Throwable ex) {
				// e.g. AccessControlException on Google App Engine
				if (log.isDebugEnabled()) {
					log.debug("Could not access system ClassLoader: " + ex);
				}
				return null;
			}
		}
		String editorName = targetType.getName() + "Editor";
		try {
			Class<?> editorClass = cl.loadClass(editorName);
			if (!PropertyEditor.class.isAssignableFrom(editorClass)) {
				// if (logger.isWarnEnabled()) {
				log.warn("Editor class [" + editorName + "] does not implement [java.beans.PropertyEditor] interface");
				// }
				unknownEditorTypes.put(targetType, Boolean.TRUE);
				return null;
			}
			return (PropertyEditor) instantiateClass(editorClass);
		} catch (ClassNotFoundException ex) {
			if (log.isDebugEnabled()) {
				log.debug("No property editor [" + editorName + "] found for type " + targetType.getName() + " according to 'Editor' suffix convention");
			}
			unknownEditorTypes.put(targetType, Boolean.TRUE);
			return null;
		}
	}

	/**
	 * Find a JavaBeans <code>PropertyDescriptor</code> for the given method,
	 * with the method either being the read method or the write method for that
	 * bean property.
	 * 
	 * @param method
	 *            the method to find a corresponding PropertyDescriptor for
	 * @return the corresponding PropertyDescriptor, or <code>null</code> if
	 *         none
	 * @throws BeansException
	 *             if PropertyDescriptor lookup fails
	 */
	public static PropertyDescriptor findPropertyForMethod(Method method) throws BeansException {
		Assert.notNull(method, "Method must not be null");
		PropertyDescriptor[] pds = getPropertyDescriptors(method.getDeclaringClass());
		for (PropertyDescriptor pd : pds) {
			if (method.equals(pd.getReadMethod()) || method.equals(pd.getWriteMethod())) {
				return pd;
			}
		}
		return null;
	}

	// TODO: this dependency is kinda Bad
	/*	private static final PropertyAccessor BASIC_PROPERTY_ACCESSOR = new BasicPropertyAccessor();
		private static final PropertyAccessor DIRECT_PROPERTY_ACCESSOR = new DirectPropertyAccessor();*/
	public static final Class<?>[] NO_PARAM_SIGNATURE = new Class[0];

	public static final Object[] NO_PARAMS = new Object[0];

	public static final Class<?>[] SINGLE_OBJECT_PARAM_SIGNATURE = new Class[] { Object.class };

	private static final Method OBJECT_EQUALS;

	private static final Method OBJECT_HASHCODE;
	static {
		Method eq;
		Method hash;
		try {
			eq = extractEqualsMethod(Object.class);
			hash = extractHashCodeMethod(Object.class);
		} catch (Exception e) {
			throw new BaseException("Could not find Object.equals() or Object.hashCode()", e);
			// throw new AssertionFailure(
			// "Could not find Object.equals() or Object.hashCode()", e );
		}
		OBJECT_EQUALS = eq;
		OBJECT_HASHCODE = hash;
	}

	/**
	 * Encapsulation of getting hold of a class's {@link Object#equals equals}
	 * method.
	 * 
	 * @param clazz
	 *            The class from which to extract the equals method.
	 * @return The equals method reference
	 * @throws NoSuchMethodException
	 *             Should indicate an attempt to extract equals method from
	 *             interface.
	 */
	public static Method extractEqualsMethod(Class<?> clazz) throws NoSuchMethodException {
		return clazz.getMethod("equals", SINGLE_OBJECT_PARAM_SIGNATURE);
	}

	/**
	 * Encapsulation of getting hold of a class's {@link Object#hashCode
	 * hashCode} method.
	 * 
	 * @param clazz
	 *            The class from which to extract the hashCode method.
	 * @return The hashCode method reference
	 * @throws NoSuchMethodException
	 *             Should indicate an attempt to extract hashCode method from
	 *             interface.
	 */
	public static Method extractHashCodeMethod(Class<?> clazz) throws NoSuchMethodException {
		return clazz.getMethod("hashCode", NO_PARAM_SIGNATURE);
	}

	/**
	 * Determine if the given class defines an {@link Object#equals} override.
	 * 
	 * @param clazz
	 *            The class to check
	 * @return True if clazz defines an equals override.
	 */
	public static boolean overridesEquals(Class<?> clazz) {
		Method equals;
		try {
			equals = extractEqualsMethod(clazz);
		} catch (NoSuchMethodException nsme) {
			return false; // its an interface so we can't really tell
							// anything...
		}
		return !OBJECT_EQUALS.equals(equals);
	}

	/**
	 * Determine if the given class defines a {@link Object#hashCode} override.
	 * 
	 * @param clazz
	 *            The class to check
	 * @return True if clazz defines an hashCode override.
	 */
	public static boolean overridesHashCode(Class<?> clazz) {
		Method hashCode;
		try {
			hashCode = extractHashCodeMethod(clazz);
		} catch (NoSuchMethodException nsme) {
			return false; // its an interface so we can't really tell
							// anything...
		}
		return !OBJECT_HASHCODE.equals(hashCode);
	}

	/**
	 * Determine if the given class implements the given interface.
	 * 
	 * @param clazz
	 *            The class to check
	 * @param intf
	 *            The interface to check it against.
	 * @return True if the class does implement the interface, false otherwise.
	 */
	public static boolean implementsInterface(Class<?> clazz, Class<?> intf) {
		assert intf.isInterface() : "Interface to check was not an interface";
		return intf.isAssignableFrom(clazz);
	}

	/**
	 * Perform resolution of a class name.
	 * <p/>
	 * Here we first check the context classloader, if one, before delegating to
	 * {@link Class#forName(String, boolean, ClassLoader)} using the caller's
	 * classloader
	 * 
	 * @param name
	 *            The class name
	 * @param caller
	 *            The class from which this call originated (in order to access
	 *            that class's loader).
	 * @return The class reference.
	 * @throws ClassNotFoundException
	 *             From {@link Class#forName(String, boolean, ClassLoader)}.
	 */
	public static Class<?> classForName(String name, Class<?> caller) throws ClassNotFoundException {
		try {
			ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
			if (contextClassLoader != null) {
				return contextClassLoader.loadClass(name);
			}
		} catch (Throwable ignore) {
		}
		return Class.forName(name, true, caller.getClassLoader());
	}

	/**
	 * Perform resolution of a class name.
	 * <p/>
	 * Same as {@link #classForName(String, Class)} except that here we delegate
	 * to {@link Class#forName(String)} if the context classloader lookup is
	 * unsuccessful.
	 * 
	 * @param name
	 *            The class name
	 * @return The class reference.
	 * @throws ClassNotFoundException
	 *             From {@link Class#forName(String)}.
	 */
	public static Class<?> classForName(String name) throws ClassNotFoundException {
		try {
			ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
			if (contextClassLoader != null) {
				return contextClassLoader.loadClass(name);
			}
		} catch (Throwable ignore) {
		}
		return Class.forName(name);
	}

	/**
	 * Attempt to resolve the specified property type through reflection.
	 * 
	 * @param className
	 *            The name of the class owning the property.
	 * @param name
	 *            The name of the property.
	 * @return The type of the property.
	 * @throws MappingException
	 *             Indicates we were unable to locate the property.
	 */
	/*	public static Class reflectedPropertyClass(String className, String name) throws MappingException {
			try {
				Class clazz = ReflectHelper.classForName( className );
				return getter( clazz, name ).getReturnType();
			}
			catch ( ClassNotFoundException cnfe ) {
				throw new MappingException( "class " + className + " not found while looking for property: " + name, cnfe );
			}
		}
	
		private static Getter getter(Class<?> clazz, String name) throws MappingException {
			try {
				return BASIC_PROPERTY_ACCESSOR.getGetter( clazz, name );
			}
			catch ( PropertyNotFoundException pnfe ) {
				return DIRECT_PROPERTY_ACCESSOR.getGetter( clazz, name );
			}
		}*/
	/**
	 * Directly retrieve the {@link Getter} reference via the
	 * {@link BasicPropertyAccessor}.
	 * 
	 * @param theClass
	 *            The class owning the property
	 * @param name
	 *            The name of the property
	 * @return The getter.
	 * @throws MappingException
	 *             Indicates we were unable to locate the property.
	 */
	/*	public static Getter getGetter(Class<?> theClass, String name) throws MappingException {
			return BASIC_PROPERTY_ACCESSOR.getGetter( theClass, name );
		}
	*/
	/**
	 * Resolve a constant to its actual value.
	 * 
	 * @param name
	 *            The name
	 * @return The value
	 */
	public static Object getConstantValue(String name) {
		Class<?> clazz;
		try {
			clazz = classForName(StringUtil.qualifier(name));
		} catch (Throwable t) {
			return null;
		}
		try {
			return clazz.getField(StringUtil.unqualify(name)).get(null);
		} catch (Throwable t) {
			return null;
		}
	}

	/**
	 * Retrieve the default (no arg) constructor from the given class.
	 * 
	 * @param clazz
	 *            The class for which to retrieve the default ctor.
	 * @return The default constructor.
	 * @throws PropertyNotFoundException
	 *             Indicates there was not publicly accessible, no-arg
	 *             constructor (todo : why PropertyNotFoundException???)
	 */
	public static Constructor<?> getDefaultConstructor(Class<?> clazz) throws PropertyNotFoundException {
		if (isAbstractClass(clazz)) {
			return null;
		}
		try {
			Constructor<?> constructor = clazz.getDeclaredConstructor(NO_PARAM_SIGNATURE);
			if (!isPublic(clazz, constructor)) {
				constructor.setAccessible(true);
			}
			return constructor;
		} catch (NoSuchMethodException nme) {
			throw new PropertyNotFoundException("Object class [" + clazz.getName() + "] must declare a default (no-argument) constructor");
		}
	}

	/**
	 * Is this member publicly accessible.
	 * <p/>
	 * Short-hand for {@link #isPublic(Class, Member)} passing the member +
	 * {@link Member#getDeclaringClass()}
	 * 
	 * @param member
	 *            The member to check
	 * @return True if the member is publicly accessible.
	 */
	public static boolean isPublic(Member member) {
		return isPublic(member.getDeclaringClass(), member);
	}

	/**
	 * Is this member publicly accessible.
	 * 
	 * @param clazz
	 *            The class which defines the member
	 * @param member
	 *            The memeber.
	 * @return True if the member is publicly accessible, false otherwise.
	 */
	public static boolean isPublic(Class<?> clazz, Member member) {
		return Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(clazz.getModifiers());
	}

	/**
	 * Attempt to resolve the specified property type through reflection.
	 * 
	 * @param className
	 *            The name of the class owning the property.
	 * @param name
	 *            The name of the property.
	 * @return The type of the property.
	 * @throws MappingException
	 *             Indicates we were unable to locate the property.
	 */
	/*	public static Class reflectedPropertyClass(String className, String name) throws MappingException {
			try {
				Class clazz = ReflectHelper.classForName( className );
				return getter( clazz, name ).getReturnType();
			}
			catch ( ClassNotFoundException cnfe ) {
				throw new MappingException( "class " + className + " not found while looking for property: " + name, cnfe );
			}
		}
	
		private static Getter getter(Class<?> clazz, String name) throws MappingException {
			try {
				return BASIC_PROPERTY_ACCESSOR.getGetter( clazz, name );
			}
			catch ( PropertyNotFoundException pnfe ) {
				return DIRECT_PROPERTY_ACCESSOR.getGetter( clazz, name );
			}
		}*/
	/**
	 * Determine if the given class is declared abstract.
	 * 
	 * @param clazz
	 *            The class to check.
	 * @return True if the class is abstract, false otherwise.
	 */
	public static boolean isAbstractClass(Class<?> clazz) {
		int modifier = clazz.getModifiers();
		return Modifier.isAbstract(modifier) || Modifier.isInterface(modifier);
	}

	/**
	 * Determine is the given class is declared final.
	 * 
	 * @param clazz
	 *            The class to check.
	 * @return True if the class is final, flase otherwise.
	 */
	public static boolean isFinalClass(Class<?> clazz) {
		return Modifier.isFinal(clazz.getModifiers());
	}

	/**
	 * Retrieve a constructor for the given class, with arguments matching the
	 * specified Hibernate mapping {@link Type types}.
	 * 
	 * @param clazz
	 *            The class needing instantiation
	 * @param types
	 *            The types representing the required ctor param signature
	 * @return The matching constructor.
	 * @throws PropertyNotFoundException
	 *             Indicates we could not locate an appropriate constructor
	 *             (todo : again with PropertyNotFoundException???)
	 */
	public static Constructor<?> getConstructor(Class<?> clazz, Type[] types) throws PropertyNotFoundException {
		final Constructor<?>[] candidates = clazz.getConstructors();
		for (int i = 0; i < candidates.length; i++) {
			final Constructor<?> constructor = candidates[i];
			final Class<?>[] params = constructor.getParameterTypes();
			if (params.length == types.length) {
				boolean found = true;
				for (int j = 0; j < params.length; j++) {
					/*					final boolean ok = params[j].isAssignableFrom( types[j].getReturnedClass() ) || (
												types[j] instanceof PrimitiveType &&
														params[j] == ( ( PrimitiveType ) types[j] ).getPrimitiveClass()
										);
										if ( !ok ) {
											found = false;
											break;
										}*/
				}
				if (found) {
					if (!isPublic(clazz, constructor)) {
						constructor.setAccessible(true);
					}
					return constructor;
				}
			}
		}
		throw new PropertyNotFoundException("no appropriate constructor in class: " + clazz.getName());
	}

	public static Method getMethod(Class<?> clazz, Method method) {
		try {
			return clazz.getMethod(method.getName(), method.getParameterTypes());
		} catch (Exception e) {
			return null;
		}
	}
}
