package com.founder.rhip.ehr.service.ta;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.repository.cic.ICicTargetTaskDao;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import com.founder.rhip.scheduling.core.TaskConstants;

/**
 * @author liuk
 * @since 2014/5/15 14:09
 */
@Service("cicBloodTargetSevice")
@TaskBean(description = "市民卡血型相关指标")
public class CicBloodTargetSevice extends AbstractService implements Task {

	@Resource(name = "cicTargetTaskDao")
	private ICicTargetTaskDao targetTaskDao;

	@Override
	public void run(Map<String, Object> data) {
		Object param = data.get(TaskConstants.TASK_PARAM_KEY);
		Integer days = 7;
		if (null != param) {
			try {
				days = Integer.parseInt(param.toString());
			} catch (Exception e) {
				// days=1;
			}
		}
		Date start = null;
		if (-1 != days) {
			start = new Date();
			start = DateUtil.add(start, Calendar.DAY_OF_YEAR, -days);
		}
		targetTaskDao.syncAborh(start);
	}
}
