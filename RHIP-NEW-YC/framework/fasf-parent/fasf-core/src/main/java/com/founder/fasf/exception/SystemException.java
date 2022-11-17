/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.exception;

/**
 * システム的な例外を通知.
 * 
 * @author acn_ohara
 */
public class SystemException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9146604698647495157L;

	/**
	 * コンストラクタ.
	 */
	public SystemException() {
		super();
	}

	/**
	 * コンストラクタ.
	 * 
	 * @param message
	 *            詳細メッセージ
	 */
	public SystemException(final String message) {
		super(message);
	}

	/**
	 * コンストラクタ.
	 * 
	 * @param message
	 *            詳細メッセージ
	 * @param cause
	 *            原因
	 */
	public SystemException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * コンストラクタ.
	 * 
	 * @param cause
	 *            原因
	 */
	public SystemException(final Throwable cause) {
		super(cause);
	}
}
