package com.founder.rhip.ehr.service.basic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.basic.MachineInfo;

public interface IMachineMonitorService {

    /**
     * 查询列表
     * @param criteria
     * @param page
     * @param order
     * @return
     */
    public PageList<MachineInfo> findPageReportRecord(Criteria criteria, Page page, String order);

    public MachineInfo getReportRecord(Long id);
    

}
