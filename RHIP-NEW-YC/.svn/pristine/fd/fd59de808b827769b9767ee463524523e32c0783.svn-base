/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.exception;

public class AppMessageException extends BaseException {

	/** default serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * message content
	 */
	private String message;

	/**
	 * message type
	 */
	private MessageType messageType;

	private MessageCode messageCode;

	private String[] messageArgs;

	public AppMessageException(final MessageCode code) {
		messageCode = code;
	}

	public AppMessageException(final MessageCode code, final String message) {
		super(message);
		messageCode = code;
	}

	public AppMessageException(final MessageCode code, final String message, final Throwable cause) {
		super(message, cause);
		messageCode = code;
	}

	public AppMessageException(final MessageCode code, final String[] args) {
		messageCode = code;
		setMessageArgs(args);
	}

	public AppMessageException(final MessageCode code, final String[] args, final String message) {
		super(message);
		messageCode = code;
		setMessageArgs(args);
	}

	public AppMessageException(final MessageCode code, final String[] args, final String message, final Throwable cause) {
		super(message, cause);
		messageCode = code;
		setMessageArgs(args);
	}

	public AppMessageException(final MessageCode code, final String[] args, final Throwable cause) {
		super(cause);
		messageCode = code;
		setMessageArgs(args);
	}

	public AppMessageException(final MessageCode code, final Throwable cause) {
		super(cause);
		messageCode = code;
	}

	public AppMessageException(final String message, final MessageType messageType) {
		this.message = message;
		this.messageType = messageType;
	}

	/**
	 * @return the message
	 */
	@Override
	public String getMessage() {
		return message;
	}

	public String[] getMessageArgs() {
		if (messageArgs == null) {
			return null;
		}
		return messageArgs.clone();
	}

	public MessageCode getMessageCode() {
		return messageCode;
	}

	/**
	 * @return the messageType
	 */
	public MessageType getMessageType() {
		return messageType;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public void setMessageArgs(final String[] args) {
		if (args == null) {
			messageArgs = null;
		} else {
			messageArgs = args.clone();
		}
	}

	/**
	 * @param messageCode
	 *            the messageCode to set
	 */
	public void setMessageCode(MessageCode messageCode) {
		this.messageCode = messageCode;
	}

	/**
	 * @param messageType
	 *            the messageType to set
	 */
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}
}
