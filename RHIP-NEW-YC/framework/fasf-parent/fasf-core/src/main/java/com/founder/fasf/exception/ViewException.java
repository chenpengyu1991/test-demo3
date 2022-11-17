/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.exception;

/**
 * 发送到客户端的异常
 * 
 * @author yang_jiangping
 * 
 */
public class ViewException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3338756280217728957L;

	/**
	 * 无参构造方法
	 */
	public ViewException() {
		super();
	}

	/**
	 * 
	 * @param message
	 *            异常信息
	 */
	public ViewException(String message) {
		super(message);
	}

	/**
	 * 
	 * @param message
	 *            异常信息
	 * @param cause
	 *            导致当前异常对应的原因对象
	 */
	public ViewException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 
	 * @param cause
	 *            导致当前异常对应的原因对象
	 */
	public ViewException(Throwable cause) {
		super(cause);
	}
}
