package com.founder.rhip.ehr.service.ta;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.repository.cic.ICicTargetTaskDao;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;

/**
 * @author liuk
 * @since 2014/5/15 14:09
 */
@Service("cicDiTargetSevice")
@TaskBean(description = "市民卡糖尿病指标")
public class CicDiTargetSevice extends AbstractService implements Task {

	@Resource(name = "cicTargetTaskDao")
	private ICicTargetTaskDao targetTaskDao;

	@Override
	public void run(Map<String, Object> data) {
		targetTaskDao.syncDi(null);
	}
}
