package com.founder.rhip.ehr.service.report;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.ConvertingWrapDynaBean;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.report.RpChild;
import com.founder.rhip.ehr.repository.child.IChildHealthCardDao;
import com.founder.rhip.ehr.repository.report.IRpChildDao;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import com.founder.rhip.scheduling.core.TaskConstants;

@Service("rpChildService")
@TaskBean(cron = "0 0 4 * * ?", description = "儿童0-7岁各年龄段统计任务")
public class RpChildService extends RpBaseService implements IRpChildService,Task {
	
	@Resource(name = "childHealthCardDao")
	private IChildHealthCardDao childHealthCardDao;
	
	@Resource(name = "rpChildDao")
	private IRpChildDao rpChildDao;

	@Override
	public void saveChildAgeStatistics(String dateStr) {
		if (ObjectUtil.isNullOrEmpty(dateStr)) {
			dateStr = DateUtil.convertDateToString(new Date());
		}
		List<Map<String, Object>> childAgeMapList = childHealthCardDao.getChildAgeStatisticsMapList(dateStr);
		if (ObjectUtil.isNotEmpty(childAgeMapList)) {
			for (Map<String, Object> map : childAgeMapList) {
				Object paCounty = null;
				Object paTownShip = null;
				if (ObjectUtil.isNullOrEmpty(map) || ObjectUtil.isNullOrEmpty(paCounty = map.get("latown_ship"))
						|| ObjectUtil.isNullOrEmpty(paTownShip = map.get("lastreet"))) {
					continue;
				}
				Criteria criteria1 = new Criteria("paCounty", paCounty).add("paTownShip", paTownShip).add("rpType", "1"); // 1:3月31 2：9月30
				DateUtil.getCriteriaByDateRange(criteria1, "rpDate", DateUtil.makeTimeToZero(DateUtil.parseDateString(dateStr)), DateUtil.makeTimeToMax(DateUtil.parseDateString(String.valueOf(dateStr))));
				RpChild rc1 = rpChildDao.get(criteria1);
				if (ObjectUtil.isNullOrEmpty(rc1)) {
					rc1 = new RpChild();
				}
				saveOrUpdateRpChild(map, rc1, "1", dateStr);
			
				Criteria criteria2 = new Criteria("paCounty", paCounty).add("paTownShip", paTownShip).add("rpType", "2"); // 1:3月31 2：9月30
				DateUtil.getCriteriaByDateRange(criteria2, "rpDate", DateUtil.makeTimeToZero(DateUtil.parseDateString(dateStr)), DateUtil.makeTimeToMax(DateUtil.parseDateString(String.valueOf(dateStr))));
				RpChild rc2 = rpChildDao.get(criteria2);
				if (ObjectUtil.isNullOrEmpty(rc2)) {
					rc2 = new RpChild();
				}
				saveOrUpdateRpChild(map, rc2, "2", dateStr);
			}
		}
	}

	@Override
	public List<Map<String, Object>> getChildAgeMapList(
			Map<String, String> paramMap) {
		return rpChildDao.getChildMapList(paramMap);
	}

	@Override
	public void run(Map<String, Object> data) {
		String dateStr = ObjectUtil.isNullOrEmpty(data.get(TaskConstants.TASK_PARAM_KEY)) ? null : String.valueOf(data.get(TaskConstants.TASK_PARAM_KEY));
		saveChildAgeStatistics(dateStr);
	}

	private void saveOrUpdateRpChild(Map<String, Object> map,RpChild rpChild, String rpType, String dateStr) {
		if (ObjectUtil.isNullOrEmpty(map) 
				|| ObjectUtil.isNullOrEmpty(rpChild) 
				|| ObjectUtil.isNullOrEmpty(rpType)
				|| (!StringUtils.equals(rpType, "1") && !StringUtils.equals(rpType, "2"))) {
			return;
		}
		ConvertingWrapDynaBean dynaBean = new ConvertingWrapDynaBean(rpChild);

		String[] properties = new String[] {"zeroNum","oneNum","twoNum","threeNum","fourNum","fiveNum","sixNum","totalNum"};
		for (String property : properties) {
			dynaBean.set(property, ObjectUtil.isNullOrEmpty(map.get(property+rpType)) ? null : Long.valueOf(String.valueOf(map.get(property+rpType))));
		}
		if (ObjectUtil.isNullOrEmpty(rpChild.getId())) {
			dynaBean.set("rpType", rpType);
			dynaBean.set("rpDate",DateUtil.parseDateString(dateStr));
			dynaBean.set("paCounty", map.get("latown_ship"));
			dynaBean.set("paTownShip", map.get("lastreet"));
			rpChildDao.insert(rpChild);
		} else {
			rpChildDao.update(rpChild, properties);
		}
		
	}
}
