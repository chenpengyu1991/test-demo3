package com.founder.rhip.ehr.service;

import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Map;
/**
 * 健康档案人群分类定时任务（根据孕产妇的末次月经日期计算满一年后自动生成为“普通人群”）
 */
@Service("healthArchivesService")
@TaskBean(cron = "0 0 0/2 * * ?", description = "健康档案人群分类定时任务")
public class HealthArchivesServiceImpl extends AbstractService implements
		IHealthArchivesService, Task {

	@Resource(name = "personInfoDao")
	private IPersonInfoDao personInfoDao;

	@Override
	public void run(Map<String, Object> data) {
		System.out.println("健康档案人群分类定时任务开始...");
		updateClassification();
		System.out.println("健康档案人群分类定时任务结束...");
	}

	/**
	 * 根据孕产妇的末次月经日期计算满一年后自动生成为“普通人群”
	 */
	@Override
	public void updateClassification() {
		try{
			Long start = System.currentTimeMillis();
			int updateCount=personInfoDao.updateClassification();
			Long end = System.currentTimeMillis();
			if(updateCount>0){
				StringBuilder sb = new StringBuilder(
						"健康档案人群分类定时任务共更新").append(updateCount).append("条数据,").append("用时：" + (end-start)/1000);
				log.info(sb.toString());
			}

		}catch(Exception e){
			log.error("健康档案人群分类定时任务发生错误！" + e.getMessage(), e);
		}
	}
}
