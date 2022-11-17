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
@Service("cicIrTargetSevice")
@TaskBean(description = "市民卡过敏相关指标")
public class CicIrTargetSevice extends AbstractService implements Task {

	@Resource(name = "cicTargetTaskDao")
	private ICicTargetTaskDao targetTaskDao;

	@Override
	public void run(Map<String, Object> data) {
		targetTaskDao.syncIrritability(null);
	}
}
