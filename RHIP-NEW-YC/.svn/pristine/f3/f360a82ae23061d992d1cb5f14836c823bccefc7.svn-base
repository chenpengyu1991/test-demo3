package com.founder.rhip.ehr.service.basic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.basic.ReportRecord;

public interface IReportRecordService {

    public PageList<ReportRecord> findReportRecord(Criteria criteria, Page page, Order order);

    /**
     * 查询列表（要求此时默认是不要重卡状态（9:重卡），并且传染病时不显示复诊未上报（3:复诊未上报））
     * @param criteria
     * @param page
     * @param order
     * @return
     */
    public PageList<ReportRecord> findPageReportRecord(Criteria criteria, Page page, String order);

    public long save(ReportRecord reportRecord);

    public int update(Long id, Long reportId, int status);

    public ReportRecord getReportRecord(Long id);
    
    public boolean deleteReportRecord(ReportRecord reportRecord);

}
