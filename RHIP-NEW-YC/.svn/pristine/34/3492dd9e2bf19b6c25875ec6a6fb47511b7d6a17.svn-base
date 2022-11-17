package com.founder.rhip.ehr.service.personal.impl;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.founder.rhip.ehr.service.personal.IPersonCanceledService;
import com.founder.rhip.scheduling.core.TaskBean;
import com.founder.rhip.scheduling.core.TaskConstants;

/**
 * 
 * @author liuk
 * @since 14-3-6 下午12:10
 */
@Service
@TaskBean(description = "批量根据身份证注销档案")
public class CancelPersonTask implements com.founder.rhip.scheduling.core.Task {

	private Logger logger = LoggerFactory.getLogger(CancelPersonTask.class);

	@Autowired
	private IPersonCanceledService personCanceledService;

	@Override
	public void run(Map<String, Object> data) {
		Object path = data.get(TaskConstants.TASK_PARAM_KEY);
		if (null != path) {
			String file = path.toString();
			List<String> idcards = getIdcards(file);
			for (final String idcard : idcards) {
				try {
					personCanceledService.cancelPersonByIdcard(idcard);
				} catch (Exception e) {
					logger.error("{}注销失败", idcard, e);
				}
			}
		}
	}

	private List<String> getIdcards(String file) {
		List<String> idcards = null;
		ResourceLoader loader = new DefaultResourceLoader();
		org.springframework.core.io.Resource resource = loader.getResource(file);
		try {
			if (resource.exists() && resource.isReadable()) {
				Path path = resource.getFile().toPath();
				idcards = Files.readAllLines(path, Charset.forName("UTF-8"));
			}
		} catch (Exception e) {
			logger.error("{}文件读取失败", file, e);
			throw new RuntimeException("文件读取失败," + file, e);
		}
		if (null == idcards) {
			idcards = Collections.emptyList();
		}
		return idcards;
	}

}
