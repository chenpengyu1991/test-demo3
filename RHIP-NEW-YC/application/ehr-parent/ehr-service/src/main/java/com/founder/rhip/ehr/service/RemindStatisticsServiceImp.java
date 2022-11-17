package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.entity.control.RemindStatistics;
import com.founder.rhip.ehr.repository.control.IRemindStatisticsCountDao;
import com.founder.rhip.ehr.repository.control.IRemindStatisticsDao;
import com.founder.rhip.mdm.entity.DicItem;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by wang_zhou on 2015/6/5.
 */
@Service("remindStatisticsService")
public class RemindStatisticsServiceImp extends AbstractService implements IRemindStatisticsService {
    @Resource(name = "remindStatisticsDao")
    private IRemindStatisticsDao remindStatisticsDao;
    @Resource(name = "remindStatisticsCountDao")
    private IRemindStatisticsCountDao remindStatisticsCountDao;

    @Override
    public List<Map<String, Object>> getRemindStatisticsMapList(Criteria criteria) {
        return remindStatisticsCountDao.getRemindStatisticsMapList(criteria);
    }

    @Override
    public List<Map<String, Object>> getOutOrgReStatisticsMapList(Criteria criteria) {
        return remindStatisticsCountDao.getOutOrgReStatisticsMapList(criteria);
    }

    @Override
    public int save(RemindStatistics remindSt) {

        return remindStatisticsDao.insert(remindSt);
    }

    @Override
    public List<DicItem> getRemindList() {
        return remindStatisticsCountDao.getRemindList();
    }
}