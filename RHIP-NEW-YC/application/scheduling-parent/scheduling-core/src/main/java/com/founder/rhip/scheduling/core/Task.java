package com.founder.rhip.scheduling.core;

import java.util.Map;

/**
 * 任务
 * 
 * @author liuk
 * 
 */
public interface Task {
	public void run(Map<String, Object> data);
}
