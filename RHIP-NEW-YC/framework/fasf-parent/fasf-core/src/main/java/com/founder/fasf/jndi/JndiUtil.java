/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */
package com.founder.fasf.jndi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.Name;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

/**
 * @author yang_jiangping
 * 
 */
public abstract class JndiUtil {

	private static InitialContext ic;

	/**
	 * jndi对象缓存
	 */
	@SuppressWarnings("rawtypes")
	private static final HashMap JNDIS_CACHE = new HashMap();

	/*
	 * private static void bindJndi(CommonInf inf) throws NamingException {
	 * 
	 * // Construct BasicDataSource reference Reference ref = new
	 * Reference("javax.sql.DataSource",
	 * "org.apache.commons.dbcp.BasicDataSourceFactory", null); ref.add(new
	 * StringRefAddr("driverClassName", inf.getDriverClassName())); ref.add(new
	 * StringRefAddr("url", inf.getUrl())); ref.add(new
	 * StringRefAddr("username", inf.getUserName())); ref.add(new
	 * StringRefAddr("password", inf.getPwd())); ic.rebind(inf.getJndiName(),
	 * ref); }
	 * 
	 * public static void createJndiDataSource(CommonInf inf) throws
	 * NamingException { if (ic == null) { // Create initial context
	 * System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
	 * "org.apache.naming.java.javaURLContextFactory");
	 * System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");
	 * 
	 * ic = new InitialContext(); } if (getJndi(inf.getJndiName()) != null) {
	 * return; }
	 * 
	 * bindJndi(inf);
	 * 
	 * }
	 */
	private static final Logger log = Logger.getLogger(JndiUtil.class);

	/**
	 * Names the {@literal JNDI} {@link javax.naming.InitialContext} class.
	 * 
	 * @see javax.naming.Context#INITIAL_CONTEXT_FACTORY
	 */
	public static final String JNDI_CLASS = "hibernate.jndi.class";

	/**
	 * Names the {@literal JNDI} provider/connection url
	 * 
	 * @see javax.naming.Context#PROVIDER_URL
	 */
	public static final String JNDI_URL = "hibernate.jndi.url";

	/**
	 * Names a prefix used to define arbitrary {@literal JNDI}
	 * {@link javax.naming.InitialContext} properties. These properties are
	 * passed along to
	 * {@link javax.naming.InitialContext#InitialContext(java.util.Hashtable)}
	 */
	public static final String JNDI_PREFIX = "hibernate.jndi";

	/**
	 * Bind val to name in ctx, and make sure that all intermediate contexts
	 * exist.
	 * 
	 * @param ctx
	 *            the root context
	 * @param name
	 *            the name as a string
	 * @param val
	 *            the object to be bound
	 * 
	 * @throws NamingException
	 *             Indicates a problem performing the bind.
	 */
	/*
	 * public static void bind(Context ctx, String name, Object val) throws
	 * NamingException { try { ctx.rebind(name, val); } catch (Exception e) {
	 * Name n = ctx.getNameParser("").parse(name); while (n.size() > 1) { String
	 * ctxName = n.get(0); Context subctx = null; try { subctx = (Context)
	 * ctx.lookup(ctxName); } catch (NameNotFoundException ignore) { } if
	 * (subctx != null) { ctx = subctx; } else { ctx =
	 * ctx.createSubcontext(ctxName); } n = n.getSuffix(1); } ctx.rebind(n,
	 * val); } }
	 */
	/**
	 * Bind val to name in ctx, and make sure that all intermediate contexts
	 * exist.
	 * 
	 * @param ctx
	 *            the root context
	 * @param name
	 *            the name as a string
	 * @param val
	 *            the object to be bound
	 * @throws NamingException
	 */
	public static void bind(Context ctx, String name, Object val) throws NamingException {
		try {
			log.trace("binding: " + name);
			ctx.rebind(name, val);
		} catch (Exception e) {
			Name n = ctx.getNameParser("").parse(name);
			while (n.size() > 1) {
				String ctxName = n.get(0);
				Context subctx = null;
				try {
					log.trace("lookup: " + ctxName);
					subctx = (Context) ctx.lookup(ctxName);
				} catch (NameNotFoundException nfe) {
				}
				if (subctx != null) {
					log.debug("Found subcontext: " + ctxName);
					ctx = subctx;
				} else {
					log.info("Creating subcontext: " + ctxName);
					ctx = ctx.createSubcontext(ctxName);
				}
				n = n.getSuffix(1);
			}
			log.trace("binding: " + n);
			ctx.rebind(n, val);
		}
		log.debug("Bound name: " + name);
	}

	/**
	 * Given a hodgepodge of properties, extract out the ones relevant for JNDI
	 * interaction.
	 * 
	 * @param configurationValues
	 *            The map of config values
	 * 
	 * @return The extracted JNDI specific properties.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Properties extractJndiProperties(Map configurationValues) {
		final Properties jndiProperties = new Properties();
		for (Map.Entry entry : (Set<Map.Entry>) configurationValues.entrySet()) {
			if (!String.class.isInstance(entry.getKey())) {
				continue;
			}
			final String propertyName = (String) entry.getKey();
			final Object propertyValue = entry.getValue();
			if (propertyName.startsWith(JNDI_PREFIX)) {
				// write the IntialContextFactory class and provider url to the
				// result only if they are
				// non-null; this allows the environmental defaults (if any) to
				// remain in effect
				if (JNDI_CLASS.equals(propertyName)) {
					if (propertyValue != null) {
						jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, propertyValue);
					}
				} else if (JNDI_URL.equals(propertyName)) {
					if (propertyValue != null) {
						jndiProperties.put(Context.PROVIDER_URL, propertyValue);
					}
				} else {
					final String passThruPropertyname = propertyName.substring(JNDI_PREFIX.length() + 1);
					jndiProperties.put(passThruPropertyname, propertyValue);
				}
			}
		}
		return jndiProperties;
	}

	@SuppressWarnings("rawtypes")
	public static InitialContext getInitialContext(Properties props) throws NamingException {
		Hashtable hash = getJndiProperties(props);
		log.info("JNDI InitialContext properties:" + hash);
		try {
			return hash.size() == 0 ? new InitialContext() : new InitialContext(hash);
		} catch (NamingException e) {
			log.error("Could not obtain initial context", e);
			throw e;
		}
	}

	/**
	 * 根据指定的jndiName，返回对应的对象。
	 * 
	 * @param jndiName
	 * @exception NamingException
	 * @return jndiName对应的对象
	 */
	@SuppressWarnings("unchecked")
	public static Object getJndi(String jndiName) throws NamingException {
		// 从缓存中取，如果缓存中不存在，或缓存中指定对象为空
		if (JNDIS_CACHE.containsKey(jndiName)) {
			Object jndiObj = JNDIS_CACHE.get(jndiName);
			if (jndiObj != null) {
				return jndiObj;
			}
		}
		try {
			ic = new InitialContext();
			Object jndiObj = ic.lookup(jndiName);
			JNDIS_CACHE.put(jndiName, jndiObj);
			return jndiObj;
		} finally {
			try {
				ic.close();
			} catch (NamingException ex) {
				System.out.println("Could not close JNDI InitialContext");
			}
		}
	}

	/**
	 * Transform JNDI properties passed in the form <tt>hibernate.jndi.*</tt> to
	 * the format accepted by <tt>InitialContext</tt> by triming the leading "
	 * <tt>hibernate.jndi</tt>".
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Properties getJndiProperties(Properties properties) {
		HashSet specialProps = new HashSet();
		specialProps.add(JNDI_CLASS);
		specialProps.add(JNDI_URL);
		Iterator iter = properties.keySet().iterator();
		Properties result = new Properties();
		while (iter.hasNext()) {
			String prop = (String) iter.next();
			if ((prop.indexOf(JNDI_PREFIX) > -1) && !specialProps.contains(prop)) {
				result.setProperty(prop.substring(JNDI_PREFIX.length() + 1), properties.getProperty(prop));
			}
		}
		String jndiClass = properties.getProperty(JNDI_CLASS);
		String jndiURL = properties.getProperty(JNDI_URL);
		// we want to be able to just use the defaults,
		// if JNDI environment properties are not supplied
		// so don't put null in anywhere
		if (jndiClass != null) {
			result.put(Context.INITIAL_CONTEXT_FACTORY, jndiClass);
		}
		if (jndiURL != null) {
			result.put(Context.PROVIDER_URL, jndiURL);
		}
		return result;
	}
}
