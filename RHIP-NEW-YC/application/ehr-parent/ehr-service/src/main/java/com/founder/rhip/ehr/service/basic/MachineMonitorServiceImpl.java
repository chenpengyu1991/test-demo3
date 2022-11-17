package com.founder.rhip.ehr.service.basic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.entity.basic.MachineInfo;
import com.founder.rhip.ehr.repository.basic.IMachineMonitorDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("machineMonitorService")
public class MachineMonitorServiceImpl extends AbstractService implements IMachineMonitorService {

    @Resource(name = "machineMonitorDao")
    private IMachineMonitorDao machineMonitorDao;

    public PageList<MachineInfo> findPageReportRecord(Criteria criteria, Page page, String order) {
        return machineMonitorDao.getPageReportRecord(page, criteria, order);
    }


    @Override
    public MachineInfo getReportRecord(Long id) {
        return machineMonitorDao.get(id);
    }

    

}
