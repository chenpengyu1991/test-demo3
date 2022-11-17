package com.founder.rhip.scheduling.task;

import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.founder.rhip.scheduling.core.TaskBean;

/**
 * URL调用,仅打印结果
 * 
 * @author liuk
 * 
 */
@TaskBean(description = "远程调用任务")
@Component(value = "SchedulingRemoteTask")
public class RemoteTask extends AbstractRemoteTask {
	private Logger logger = LoggerFactory.getLogger(RemoteTask.class);

	@Override
	protected void handleResult(Map<String, Object> data, InputStream inputStream) {
		String result = new Scanner(inputStream, "UTF-8").useDelimiter("\\A").next();
		logger.debug(result);
	}

}
