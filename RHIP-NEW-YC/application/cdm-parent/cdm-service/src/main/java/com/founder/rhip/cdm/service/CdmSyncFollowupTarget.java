package com.founder.rhip.cdm.service;

import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.repository.ta.ICdmSyncTargetDao;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import com.founder.rhip.scheduling.core.TaskConstants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * @author liuk
 * @since 2014/5/26 16:31
 */
@Service
@TaskBean(description = "同步慢病随访血压血糖指标")
public class CdmSyncFollowupTarget implements Task {
    @Resource(name="cdmSyncTargetDao")
    private ICdmSyncTargetDao cdmSyncTargetDao;
    private Date start;

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
        start = null;
        if (-1 != days) {
            start = new Date();
            start = DateUtil.add(start, Calendar.DAY_OF_YEAR, -days);
        }
        cdmSyncTargetDao.syncFollowup(start);
    }
}
