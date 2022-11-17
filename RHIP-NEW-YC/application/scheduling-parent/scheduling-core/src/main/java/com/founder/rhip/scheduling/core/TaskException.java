package com.founder.rhip.scheduling.core;

/**
 * 任务异常
 * 
 * @author liuk
 * 
 */
public class TaskException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TaskException(String string, Throwable throwable) {
		super(string, throwable);
	}

}
