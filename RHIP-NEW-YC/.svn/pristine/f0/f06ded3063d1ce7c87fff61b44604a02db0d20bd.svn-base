package com.founder.rhip.ehr.service.report;

import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.entity.report.RpSymptom;
import com.founder.rhip.ehr.repository.report.IRpSymptomDao;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("rpSymptomService")
@TaskBean(cron = "0 0 4 * * ?", description = "症状表项目统计数据")
public class RpSymptomServiceImpl extends AbstractService implements IRpSymptomService, Task {

	@Resource(name = "rpSymptomDao")
	IRpSymptomDao rpSymptomDao;

	private static final String FORMATER = "yyyy/MM/dd";

	@Override
	public void insertSymptomStatistics(String dateStr) {
		//目前统计定时任务还不知道取什么数据
	}

	@Override
	public List<RpSymptom> getSymptom(Map<String, String> paramMap) {
		return rpSymptomDao.getSymptom(paramMap);
	}

	public List<Map<String, Object>> getSymptomMonth(Map<String, String> paramMap){
		return rpSymptomDao.getSymptomMonth(paramMap);
	}

	@Override
	public void run(Map<String, Object> data) {
		insertSymptomStatistics(String.valueOf(data.get("jobDataCustomParamKey")));
	}

	/*2014-01-05 00:00:00*/
	public static void main(String []rr) {
		System.out.println(DateUtil.parseSimpleDate("2014/01/05 00:00:00", FORMATER));
	}


}
