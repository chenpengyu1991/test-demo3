/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.exception;

/**
 * 两个具长度的集合（数组），或一个具有长度的集合（数组）与指定长度 不一致时，抛出当前异常 copyright Founder 2010
 * 
 * @date 2011-9-23 V1.0初始作成
 * @author yang_jiangping
 * @version V1.0
 * @brief xxxClass的定义
 * @since 1.0
 * @history 2011-9-23 V1.X 修改内容，一个版本一行
 * @descript 类的概要说明(需要手动修改)
 * @todo 未完成的事项
 */
public class SizeNotMacthException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5861898809965492015L;

	private static final String EXCEPTION_INFO = "长度不匹配。";

	/**
	 * 构造方法
	 */
	public SizeNotMacthException() {
		super();
	}

	/**
	 * 构造方法
	 * 
	 * @param message
	 *            异常显示信息
	 */
	public SizeNotMacthException(String message) {
		super(message);
	}

	/**
	 * 构造方法
	 * 
	 * @param message
	 *            异常显示信息
	 * @param cause
	 *            异常原因：上级异常
	 */
	public SizeNotMacthException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 构造方法
	 * 
	 * @param cause
	 *            异常显示信息
	 */
	public SizeNotMacthException(Throwable cause) {
		super(cause);
	}

	/**
	 * 异常信息 getter
	 * 
	 * @return 异常信息
	 */
	@Override
	public String getMessage() {
		if (super.getMessage() == null) {
			return EXCEPTION_INFO;
		}
		return super.getMessage();
	}
}
