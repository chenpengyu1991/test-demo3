package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.basic.ReportRecord;

import java.util.List;
import java.util.Map;

/**
 * Created by chen.q on 15-6-4.
 */
public interface ICardMonitoringService {
    List<Map<String, Object>> getCountReportMapList(Criteria criteria);
     Map<String,String> getCountReportMap(Criteria criteria);
}
