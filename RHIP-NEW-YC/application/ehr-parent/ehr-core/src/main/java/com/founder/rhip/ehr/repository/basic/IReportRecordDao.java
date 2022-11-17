package com.founder.rhip.ehr.repository.basic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.basic.ReportRecord;

/**
 * DAO interface of ReportRecord
 * 
 */
public interface IReportRecordDao extends IDao<ReportRecord,Long> {

    /**
     * 报表监控查询
     * @param page
     * @param criteria
     * @return
     */

    PageList<ReportRecord> getPageReportRecord(Page page, Criteria criteria, String order);

}