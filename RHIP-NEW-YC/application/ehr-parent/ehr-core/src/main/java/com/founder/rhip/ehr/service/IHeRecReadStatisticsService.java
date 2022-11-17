package com.founder.rhip.ehr.service;

import java.util.List;
import java.util.Map;

/**
 * Created by chen.q on 15-6-11.
 */
public interface IHeRecReadStatisticsService {
    List<Map<String, Object>> getHeRecReadStatistics(Map<String, String> paramMap);
}
