/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.log;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Track references to arbitrary objects using proxy and weak references. To
 * monitor a handle, one should call {@link #monitor(Object, ReleaseListener)},
 * with the given handle object usually being a holder that uses the target
 * object underneath, and the release listener performing cleanup of the target
 * object once the handle is not strongly referenced anymore.
 * 
 * <p>
 * When a given handle becomes weakly reachable, the specified listener will be
 * called by a background thread. This thread will only be started lazily and
 * will be stopped once no handles are registered for monitoring anymore, to be
 * restarted if further handles are added.
 * 
 * <p>
 * Thanks to Tomasz Wysocki for the suggestion and the original implementation
 * of this class!
 * 
 * @author Colin Sampaleanu
 * @author Juergen Hoeller
 * @since 1.2
 * @see #monitor
 */
public class WeakReferenceMonitor {

	/**
	 * Thread implementation that performs the actual monitoring.
	 */
	private static class MonitoringProcess implements Runnable {

		@SuppressWarnings("rawtypes")
		@Override
		public void run() {
			logger.debug("Starting reference monitor thread");
			// Check if there are any tracked entries left.
			while (keepMonitoringThreadAlive()) {
				try {
					Reference reference = handleQueue.remove();
					// Stop tracking this reference.
					ReleaseListener entry = removeEntry(reference);
					if (entry != null) {
						// Invoke listener callback.
						try {
							entry.released();
						} catch (Throwable ex) {
							logger.warn("Reference release listener threw exception", ex);
						}
					}
				} catch (InterruptedException ex) {
					synchronized (WeakReferenceMonitor.class) {
						monitoringThread = null;
					}
					logger.debug("Reference monitor thread interrupted", ex);
					break;
				}
			}
		}
	}

	/**
	 * Listener that is notified when the handle is being released. To be
	 * implemented by users of this reference monitor.
	 */
	public static interface ReleaseListener {

		/**
		 * This callback method is invoked once the associated handle has been
		 * released, i.e. once there are no monitored strong references to the
		 * handle anymore.
		 */
		void released();
	}

	private static final Logger logger = Logger.getLogger(WeakReferenceMonitor.class);

	// Queue receiving reachability events
	private static final ReferenceQueue<Object> handleQueue = new ReferenceQueue<Object>();

	// All tracked entries (WeakReference => ReleaseListener)
	@SuppressWarnings("rawtypes")
	private static final Map<Reference, ReleaseListener> trackedEntries = new HashMap<Reference, ReleaseListener>();

	// Thread polling handleQueue, lazy initialized
	private static Thread monitoringThread = null;

	/**
	 * Add entry to internal map of tracked entries. Internal monitoring thread
	 * is started if not already running.
	 * 
	 * @param ref
	 *            reference to tracked handle
	 * @param entry
	 *            the associated entry
	 */
	@SuppressWarnings("rawtypes")
	private static void addEntry(Reference ref, ReleaseListener entry) {
		synchronized (WeakReferenceMonitor.class) {
			// Add entry, the key is given reference.
			trackedEntries.put(ref, entry);
			// Start monitoring thread lazily.
			if (monitoringThread == null) {
				monitoringThread = new Thread(new MonitoringProcess(), WeakReferenceMonitor.class.getName());
				monitoringThread.setDaemon(true);
				monitoringThread.start();
			}
		}
	}

	/**
	 * Check whether to keep the monitoring thread alive, i.e. whether there are
	 * still entries being tracked.
	 */
	private static boolean keepMonitoringThreadAlive() {
		synchronized (WeakReferenceMonitor.class) {
			if (!trackedEntries.isEmpty()) {
				return true;
			} else {
				logger.debug("No entries left to track - stopping reference monitor thread");
				monitoringThread = null;
				return false;
			}
		}
	}

	/**
	 * Start to monitor given handle object for becoming weakly reachable. When
	 * the handle isn't used anymore, the given listener will be called.
	 * 
	 * @param handle
	 *            the object that will be monitored
	 * @param listener
	 *            the listener that will be called upon release of the handle
	 */
	public static void monitor(Object handle, ReleaseListener listener) {
		if (logger.isDebugEnabled()) {
			logger.debug("Monitoring handle [" + handle + "] with release listener [" + listener + "]");
		}
		// Make weak reference to this handle, so we can say when
		// handle is not used any more by polling on handleQueue.
		WeakReference<Object> weakRef = new WeakReference<Object>(handle, handleQueue);
		// Add monitored entry to internal map of all monitored entries.
		addEntry(weakRef, listener);
	}

	/**
	 * Remove entry from internal map of tracked entries.
	 * 
	 * @param reference
	 *            the reference that should be removed
	 * @return entry object associated with given reference
	 */
	@SuppressWarnings("rawtypes")
	private static ReleaseListener removeEntry(Reference reference) {
		synchronized (WeakReferenceMonitor.class) {
			return trackedEntries.remove(reference);
		}
	}
}
