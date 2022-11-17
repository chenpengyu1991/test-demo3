package com.founder.rhip.ehr.repository.basic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.basic.MachineInfo;

/**
 * DAO interface of MachineInfo
 * 
 */
public interface IMachineMonitorDao extends IDao<MachineInfo,Long> {

    /**
     * 报表监控查询
     * @param page
     * @param criteria
     * @return
     */

    PageList<MachineInfo> getPageReportRecord(Page page, Criteria criteria, String order);

}