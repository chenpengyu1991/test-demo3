package com.founder.rhip.ihm.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.IDataSource;
import com.founder.rhip.ehr.common.PageableDateSource;
import com.founder.rhip.ehr.entity.child.WomenChildHealth;
import com.founder.rhip.ehr.repository.child.IWomenChildHealthDao;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;

@Service("childHealthService")
@TaskBean(cron = "0 0 5 * * ?", description = "儿童信息定时任务")
public class ChildHealthServiceImpl extends AbstractService implements Task {

    @Resource(name = "womenChildHealthDao")
	private IWomenChildHealthDao womenChildHealthDao;
    
	@Override
	public void run(Map<String, Object> data) {
		//大于6岁儿童修改状态IS_DELETE=1
		updateChild();
	}
	
	private void updateChild() {

		// 分页处理
		PageableDateSource.execFirst(new IDataSource<WomenChildHealth>() {
			@Override
			public PageList<WomenChildHealth> get(Page page) {
				return womenChildHealthDao.getPageList(page);
			}

			@Override
			public void run(List<WomenChildHealth> list) {
				if (ObjectUtil.isNullOrEmpty(list)) {
					return;
				}
				for (WomenChildHealth child : list) {
					if (ObjectUtil.isNullOrEmpty(child) || ObjectUtil.isNullOrEmpty(child.getId())) {
						continue;
					}
					child.setIsDelete("1");
				}
				womenChildHealthDao.batchUpdate(list, "isDelete");
			}
		});
	}
}
