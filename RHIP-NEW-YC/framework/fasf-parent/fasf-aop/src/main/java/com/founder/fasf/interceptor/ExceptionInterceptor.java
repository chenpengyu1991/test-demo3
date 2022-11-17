/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * import org.aopalliance.intercept.MethodInvocation; import
 * org.apache.commons.logging.Log;
 * 
 * import com.founder.saas.framework.base.interceptor.BaseInterceptor; import
 * com.founder.saas.framework.util.ExceptionUtil; import
 * com.founder.saas.framework.util.InterceptorUitl; import
 * com.founder.saas.framework.util.ObjectUtil;
 */
public class ExceptionInterceptor // extends BaseInterceptor
{

	// 异常国际化信息
	@SuppressWarnings("unused")
	private Map<String, String> exceptionI18nMsg = null;

	// 异常国际文件中配置的类：用于匹配当前捕获的异常或其顶层异常 ，是否是配置文件中的某个异常的实例
	@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
	private List<Class> exceptionClasses = new ArrayList();

	// 某指定异常在国际化文件中的值，为指定值时，使用当前捕获的异常的内部message
	private String useExceptionInnerMsgWhenI18MsgValue = null;

	private String exceptionI18nConfigLocation = "";

	/**
	 * 默认异常信息，在国际化文件对应的key
	 */
	public static final String DEFAULT_EXCEPTION_KEY = "com.founder.exception.default";

	/**
	 * 拦截切点方法
	 * 
	 * @param methodInv
	 *            目标切点方法
	 * @exception Throwable
	 * @return 目标方法执行结果，即目标方法的返回值
	 * @since 1.0
	 * @todo 未完成的事项
	 */
	/*
	 * public Object invoke(MethodInvocation methodInv) throws Throwable {
	 * 
	 * // 匹配方法 boolean isMatched = isMatched(methodInv.getMethod().getName());
	 * 
	 * Object retValue = null;
	 * 
	 * // 如果不是指定的切点，则忽视异常的捕获 if (!isMatched) { retValue = methodInv.proceed();
	 * return retValue; }
	 * 
	 * // 如果是指定切点，捕获异常，并重新封装异常 try { retValue = methodInv.proceed(); } catch
	 * (Throwable e) { // 保存异常日志 proceedLog(methodInv, e);
	 * 
	 * // 国际化 String msg = getExceptionI18nMsg(e); throw new ViewException(msg,
	 * e); }
	 * 
	 * return retValue; }
	 */
	/**
	 * 保存异常日志
	 * 
	 * @param methodInv
	 * @param e
	 * @param
	 * @return void
	 */
	/*
	 * private void proceedLog(MethodInvocation methodInv, Throwable e) { //
	 * 日志保存，不能抛出错误，因为日志记录已经出错，那么就没有办法再记录日志了，所以异常不再抛出 try { Log log =
	 * InterceptorUitl.getLoggerUseSrcClass(methodInv);
	 * 
	 * // 因为在发向客户端时的异常，一定是错误级别，否则不会抛出到当前位置 // 所以此处始终使用error日志级别 log.error(e); }
	 * catch (Exception e1) { e1.printStackTrace(); } }
	 */
	/**
	 * 获取指定异常国际化信息
	 * 
	 * 算法 ：1：返回：如果当前异常的className可以在国际化文件中找到，则获取此信息。否则执行 -2-
	 * 2：返回：如果当前异常的顶层异常(递归e.getCause()到最后一个，
	 * 返回：如果当前异常就是最后一个即返回当前异常)的className在国际化文件中打开，同理.否则，执行-3-
	 * 3：返回：查找国际化文件中配置的默认异常
	 * 4：返回：如果异常信息值与useExceptionInnerMsgWhenI18MsgValue相等（大小写不敏感），则返回异常自带的信息
	 * 
	 * @param e
	 * @return
	 * @param
	 * @return String
	 */
	/*
	 * private String getExceptionI18nMsg(Throwable e) { if
	 * (exceptionI18nConfigLocation == null ||
	 * exceptionI18nConfigLocation.length() <= 0) { return "异常国际化文件不存在"; } //
	 * 如果没有加载国际化文件，则加载 if (exceptionI18nMsg == null) {
	 * loadI18nMsg(ResourceBundle.getBundle(this.exceptionI18nConfigLocation));
	 * }
	 * 
	 * // 根据类全名，查找相应的异常国际化信息 String key = null; if (e instanceof BaseException)
	 * { key = e.getClass().getName(); } else {
	 * 
	 * for (Class clazz : exceptionClasses) { Throwable topE =
	 * ExceptionUtil.getTopThrowable(e); if (clazz.isInstance(e) ||
	 * clazz.isInstance(topE)) { key = clazz.getName(); break; } } }
	 * 
	 * if (key != null && exceptionI18nMsg.containsKey(key)) { String msg =
	 * exceptionI18nMsg.get(key);
	 * 
	 * if (useExceptionInnerMsgWhenI18MsgValue != null &&
	 * useExceptionInnerMsgWhenI18MsgValue.equalsIgnoreCase(msg)) { return
	 * e.getMessage(); } if (msg == null || msg.trim().length() <= 0) { return
	 * e.getMessage(); } return msg; } else { return
	 * exceptionI18nMsg.get(DEFAULT_EXCEPTION_KEY); }
	 * 
	 * }
	 */
	/**
	 * 
	 * @precondition 调用方法的前提条件写在这，分行写。
	 * @return 异常国际化文件对应的路径
	 * @see xxxClass#xxxMethod
	 * @since 1.0
	 * @todo 未完成的事项
	 */
	public String getExceptionI18nConfigLocation() {
		return exceptionI18nConfigLocation;
	}

	/**
	 * 
	 * @precondition 调用方法的前提条件写在这，分行写。
	 * @param exceptionI18nConfigLocation
	 *            异常国际化文件对应的路径
	 * @see xxxClass#xxxMethod
	 * @since 1.0
	 * @todo 未完成的事项
	 */
	/*
	 * public void setExceptionI18nConfigLocation( String
	 * exceptionI18nConfigLocation) { if
	 * (ObjectUtil.isEmpty(exceptionI18nConfigLocation)) { return; }
	 * this.exceptionI18nConfigLocation = exceptionI18nConfigLocation.trim(); }
	 */
	/**
	 * 
	 * @precondition 调用方法的前提条件写在这，分行写。
	 * @return 是否使用异常内部的异常信息（而不用国际化文件中对应的异常信息）
	 * @see xxxClass#xxxMethod
	 * @since 1.0
	 * @todo 未完成的事项
	 */
	public String getUseExceptionInnerMsgWhenI18MsgValue() {
		return useExceptionInnerMsgWhenI18MsgValue;
	}
	/**
	 * 
	 * @precondition 调用方法的前提条件写在这，分行写。
	 * @param useExceptionInnerMsgWhenI18MsgValue
	 *            是否使用异常内部的异常信息（而不用国际化文件中对应的异常信息）
	 * @see xxxClass#xxxMethod
	 * @since 1.0
	 * @todo 未完成的事项
	 */
	/*
	 * public void setUseExceptionInnerMsgWhenI18MsgValue( String
	 * useExceptionInnerMsgWhenI18MsgValue) { if
	 * (ObjectUtil.isEmpty(useExceptionInnerMsgWhenI18MsgValue)) { return; }
	 * this.useExceptionInnerMsgWhenI18MsgValue =
	 * useExceptionInnerMsgWhenI18MsgValue; }
	 */
}
