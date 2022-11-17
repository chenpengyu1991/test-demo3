/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.thread;

import java.io.Serializable;

import com.founder.fasf.reflect.ReflectUtil;

/**
 * Simple customizable helper class for creating threads. Provides various bean
 * properties, such as thread name prefix, thread priority, etc.
 * 
 * <p>
 * Serves as base class for thread factories such as
 * {@link org.springframework.scheduling.concurrent.CustomizableThreadFactory}.
 * 
 * @author Juergen Hoeller
 * @since 2.0.3
 * @see org.springframework.scheduling.concurrent.CustomizableThreadFactory
 */
public class ThreadCreator implements Serializable {

	/**
	 * Empty class used for a serializable monitor object.
	 */
	private static class SerializableMonitor implements Serializable {

		/**
		 * Fields .....
		 */
		private static final long serialVersionUID = 8614296997411589281L;
	}

	/**
	 * Fields .....
	 */
	private static final long serialVersionUID = -4582647486099690775L;

	private String threadNamePrefix;

	private int threadPriority = Thread.NORM_PRIORITY;

	private boolean daemon = false;

	private ThreadGroup threadGroup;

	private int threadCount = 0;

	private final Object threadCountMonitor = new SerializableMonitor();

	/**
	 * Create a new CustomizableThreadCreator with default thread name prefix.
	 */
	public ThreadCreator() {
		threadNamePrefix = getDefaultThreadNamePrefix();
	}

	/**
	 * Create a new CustomizableThreadCreator with the given thread name prefix.
	 * 
	 * @param threadNamePrefix
	 *            the prefix to use for the names of newly created threads
	 */
	public ThreadCreator(String threadNamePrefix) {
		this.threadNamePrefix = (threadNamePrefix != null ? threadNamePrefix : getDefaultThreadNamePrefix());
	}

	/**
	 * Template method for the creation of a Thread.
	 * <p>
	 * Default implementation creates a new Thread for the given Runnable,
	 * applying an appropriate thread name.
	 * 
	 * @param runnable
	 *            the Runnable to execute
	 * @see #nextThreadName()
	 */
	public Thread createThread(Runnable runnable) {
		Thread thread = new Thread(getThreadGroup(), runnable, nextThreadName());
		thread.setPriority(getThreadPriority());
		thread.setDaemon(isDaemon());
		return thread;
	}

	/**
	 * Build the default thread name prefix for this factory.
	 * 
	 * @return the default thread name prefix (never <code>null</code>)
	 */
	protected String getDefaultThreadNamePrefix() {
		return ReflectUtil.getShortName(getClass()) + "-";
	}

	/**
	 * Return the thread group that threads should be created in (or
	 * <code>null</code>) for the default group.
	 */
	public ThreadGroup getThreadGroup() {
		return threadGroup;
	}

	/**
	 * Return the thread name prefix to use for the names of newly created
	 * threads.
	 */
	public String getThreadNamePrefix() {
		return threadNamePrefix;
	}

	/**
	 * Return the priority of the threads that this factory creates.
	 */
	public int getThreadPriority() {
		return threadPriority;
	}

	/**
	 * Return whether this factory should create daemon threads.
	 */
	public boolean isDaemon() {
		return daemon;
	}

	/**
	 * Return the thread name to use for a newly created thread.
	 * <p>
	 * Default implementation returns the specified thread name prefix with an
	 * increasing thread count appended: for example,
	 * "SimpleAsyncTaskExecutor-0".
	 * 
	 * @see #getThreadNamePrefix()
	 */
	protected String nextThreadName() {
		int threadNumber = 0;
		synchronized (threadCountMonitor) {
			threadCount++;
			threadNumber = threadCount;
		}
		return getThreadNamePrefix() + threadNumber;
	}

	/**
	 * Set whether this factory is supposed to create daemon threads, just
	 * executing as long as the application itself is running.
	 * <p>
	 * Default is "false": Concrete factories usually support explicit
	 * cancelling. Hence, if the application shuts down, Runnables will by
	 * default finish their execution.
	 * <p>
	 * Specify "true" for eager shutdown of threads which still actively execute
	 * a Runnable.
	 * 
	 * @see java.lang.Thread#setDaemon
	 */
	public void setDaemon(boolean daemon) {
		this.daemon = daemon;
	}

	/**
	 * Specify the thread group that threads should be created in.
	 * 
	 * @see #setThreadGroupName
	 */
	public void setThreadGroup(ThreadGroup threadGroup) {
		this.threadGroup = threadGroup;
	}

	/**
	 * Specify the name of the thread group that threads should be created in.
	 * 
	 * @see #setThreadGroup
	 */
	public void setThreadGroupName(String name) {
		threadGroup = new ThreadGroup(name);
	}

	/**
	 * Specify the prefix to use for the names of newly created threads. Default
	 * is "SimpleAsyncTaskExecutor-".
	 */
	public void setThreadNamePrefix(String threadNamePrefix) {
		this.threadNamePrefix = (threadNamePrefix != null ? threadNamePrefix : getDefaultThreadNamePrefix());
	}

	/**
	 * Set the priority of the threads that this factory creates. Default is 5.
	 * 
	 * @see java.lang.Thread#NORM_PRIORITY
	 */
	public void setThreadPriority(int threadPriority) {
		this.threadPriority = threadPriority;
	}
}
