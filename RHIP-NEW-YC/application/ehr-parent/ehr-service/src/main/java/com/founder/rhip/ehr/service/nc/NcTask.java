package com.founder.rhip.ehr.service.nc;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.rhip.ehr.repository.nc.INcDataDao;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import com.founder.rhip.scheduling.core.TaskConstants;

/**
 * @author liuk
 * @since 14-3-19 下午1:26
 */
@Service("ncTask")
@TaskBean(description = "新市民积分数据处理")
public class NcTask implements Task {

	@Resource(name = "ncDataDao")
	private INcDataDao ncDataDao;

	@Override
	public void run(Map<String, Object> data) {
		Object param = data.get(TaskConstants.TASK_PARAM_KEY);
		if (null == param || param.toString().trim().length() < 1) {
			ncDataDao.dealNcData(null);
		} else {
			String viewName = param.toString();
			ncDataDao.dealNcData(viewName);
		}
	}
}
