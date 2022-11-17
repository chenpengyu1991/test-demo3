package com.founder.rhip.scheduling.test;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskConstants;

/**
 * 测试用任务
 * @author liuk
 *
 */
//@Component("testTask")
public class TestTask implements Task {

	@Override
	public void run(Map<String, Object> data) {
		System.err.println(Thread.currentThread());
		System.err.println(data.get(TaskConstants.TASK_BEAN_NAME_KEY));
	}

}
