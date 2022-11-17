package com.founder.rhip.ehr.service;

import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.repository.clinic.IHeRecReadStatisticsDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by chen.q on 15-6-11.
 */
@Service("heRecReadStatisticsService")
public class HeRecReadStatisticsServiceImpl extends AbstractService implements IHeRecReadStatisticsService{
    @Resource(name = "heRecReadStatisticsDao")
    private IHeRecReadStatisticsDao heRecReadStatisticsDao;

    @Override
    public List<Map<String, Object>> getHeRecReadStatistics(Map<String, String> paramMap) {
        return heRecReadStatisticsDao.getHeRecReadStatistics(paramMap);
    }
}
