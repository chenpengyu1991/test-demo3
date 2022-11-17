package com.founder.rhip.scheduling.task;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskConstants;
import com.founder.rhip.scheduling.core.TaskException;

/**
 * 调用url任务
 * 
 * @author liuk
 * 
 */
public abstract class AbstractRemoteTask implements Task {
	private Logger logger = LoggerFactory.getLogger(AbstractRemoteTask.class);

	@Override
	public void run(Map<String, Object> data) {
		Object urlString = data.get(TaskConstants.TASK_PARAM_KEY);
		if (ObjectUtil.isNotEmpty(urlString)) {
			try {
				URL url = new URL(urlString.toString());
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				// TODO 子类可以设置
				conn.setRequestMethod("GET");
				conn.setConnectTimeout(50 * 1000);
				try (InputStream inputStream = conn.getInputStream();) {
					handleResult(data, inputStream);
				}
			} catch (Exception e) {
				throw new TaskException("远程调用出错 url:".concat(urlString.toString()), e);
			}
		} else {
			logger.warn("当前任务无url参数!");
		}

	}

	protected abstract void handleResult(Map<String, Object> data, InputStream inputStream);
}
