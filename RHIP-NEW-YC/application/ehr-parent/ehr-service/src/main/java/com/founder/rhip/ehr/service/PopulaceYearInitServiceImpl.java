package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.Populace;
import com.founder.rhip.ehr.repository.basic.IPopulaceDao;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import com.founder.rhip.scheduling.core.TaskConstants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("populaceYearInitService")
@TaskBean(cron = "0 0 4 31 12 ?", description = "人口数设置年度初始化")
public class PopulaceYearInitServiceImpl extends AbstractService implements
        IPopulaceYearInitService, Task {

	@Resource(name="populaceDao")
	private IPopulaceDao populaceDao;

	@Override
	public void run(Map<String, Object> data) {
		Object param = data.get(TaskConstants.TASK_PARAM_KEY); // 参数格式yyyy 年份如2016
		Integer year = null;
		if(ObjectUtil.isNotEmpty(param)){
			year = NumberUtil.convert(param.toString(),Integer.class);
		}
		if(ObjectUtil.isNullOrEmpty(year)){
			year = DateUtil.getCurrentYear() + 1;
		}
		startCollectData(year);
	}

	private void startCollectData(Integer year){
		try{
			log.info("人口数设置开始复制了...");
			Long start = System.currentTimeMillis();
			List<Populace> populaceList = populaceDao.getList(new Criteria("COUNT_YEAR",year -1));
			if(ObjectUtil.isNullOrEmpty(populaceList)){
				log.info("暂无人口数设置数据");
			}
			savePopulace(populaceList,year);
			Long end = System.currentTimeMillis();
			StringBuilder sb = new StringBuilder(
					"人口数设置共复制").append( populaceList.size()).append("条 数据完成,共花费").append(formatTime(end - start));
			log.info(sb.toString());
		}catch(Exception e){
			log.error("人口数设置复制数据发生错误！" + e.getMessage(), e);
		}
	}

	/**
	 * 保存人口数设置数据
	 * @param populaceList
	 * @param newCountYear
     */
	private void savePopulace(List<Populace> populaceList, Integer newCountYear){
		for(Populace populace:populaceList){
			String organCode = populace.getOrganCode();
			Criteria ca = new Criteria("COUNT_YEAR",newCountYear);
			ca.add("ORGAN_CODE",organCode);
			Populace oldPopulace = populaceDao.get(ca);
			//如果已经存在该机构人口设置数据，则跳过
			if(ObjectUtil.isNotEmpty(oldPopulace)){
				continue;
			}else{
				populace.setCountYear(newCountYear);
				populaceDao.insert(populace);
			}
		}
	}

	private String formatTime(long millis) {
		String unit = "秒";
		double sec = (double)millis / 1000;
		if (sec >= 60) {
			sec = sec / 60;
			unit = "分钟";
		}
		if (sec >= 60) {
			sec = sec / 60;
			unit = "小时";
		}
		return String.format("%.2f", sec) + unit;
	}
}
