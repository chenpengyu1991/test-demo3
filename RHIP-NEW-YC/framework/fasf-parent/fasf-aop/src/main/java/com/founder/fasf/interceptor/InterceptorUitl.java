/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.interceptor;

import java.util.List;

/*
 * import org.aopalliance.intercept.MethodInvocation; import
 * org.apache.commons.logging.Log; import org.apache.commons.logging.LogFactory;
 * 
 * import com.founder.saas.framework.log.BaseLogInterceptor;
 */
public final class InterceptorUitl {

	/**
	 * 遍历配置中的切点方法: 匹配当前方法是否是指定的切点方法
	 * 
	 * @param targetMethodName
	 *            被匹配的方法
	 * @param pointCutMethods
	 *            切点方法
	 * @return boolean
	 */
	public static boolean isMatchedPointCutMethod(String targetMethodName, List<String> pointCutMethods) {
		for (String m : pointCutMethods) {
			// 此处用replace就可以全部替换，而非replaceAll()??
			if (targetMethodName.matches(m.replace("*", "[\\s\\S]*"))) {
				return true;
			}
		}
		return false;
	}

	private InterceptorUitl() {
		super();
	}
	/*
	*//**
	 * 获取logger：指定方法所属类的全名对应的logger
	 * 
	 * 如：先获取定义方法methodInv的类(不是代理类)，然后以此类的全名做为参数，getLog(类全名)
	 * 
	 * 作用：可以根据method原类，把日志分别输出到不同日志文件中
	 * 
	 * @param methodInv
	 *            方法对象
	 * @return Log
	 */
	/*
	 * public static Log getLoggerUseSrcClass(MethodInvocation methodInv) {
	 * return LogFactory.getLog(methodInv.getMethod().getDeclaringClass()); }
	 *//**
	 * 获取logger：指定logInterceptor的全名对应的logger 作用：可以根据action，把日志分别输出到不同日志文件中
	 * 
	 * @param logInterceptor
	 *            日志拦截器
	 * @return Log 日志拦截器Class 对应的日志记录器
	 */
	/*
	 * public static Log getLoggerUseIntercetorClass( BaseLogInterceptor
	 * logInterceptor) { return LogFactory.getLog(logInterceptor.getClass()); }
	 *//**
	 * 获取logger:混合日志，logInterceptor类全名 + "." + method所在类的全名
	 * 
	 * 作用：可以在log4j配置文件中,通过action类与业务类组合成复杂的logger，从而可以输出更细粒度的文件中。
	 * 
	 * @param logInterceptor
	 *            日志拦截器
	 * @param methodInv
	 *            方法对象
	 * @return Log 日志拦截器Class和目标方法所在Class组合， 对应的日志记录器
	 */
	/*
	 * public static Log getLoggerUseMixClass(BaseLogInterceptor logInterceptor,
	 * MethodInvocation methodInv) { return
	 * LogFactory.getLog(logInterceptor.getClass().getName() + "." +
	 * methodInv.getMethod().getDeclaringClass().getName());
	 * 
	 * }
	 */
}
