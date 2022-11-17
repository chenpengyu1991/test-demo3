package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.basic.ReportRecord;

import java.util.List;
import java.util.Map;


/**
 * Created by chen.q on 15-6-4.
 */
public interface ICardMonitoringDao  extends IDao<ReportRecord, Long> {
    /**
     * 保卡统计
     * @param criteria
     * @return
     * @author ChenQin
     */
    List<Map<String, Object>> getCountReportMapList(Criteria criteria);
}
