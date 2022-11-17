package com.founder.rhip.ncp.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ncp.dto.FollowDto;
import com.founder.rhip.ncp.dto.NcpClassifyReport;
import com.founder.rhip.ncp.dto.NcpHealthReport;
import com.founder.rhip.ncp.dto.NcpManageReport;
import com.founder.rhip.ncp.repository.IFollowListDao;
import com.founder.rhip.ncp.repository.IReportClassifyDao;
import com.founder.rhip.ncp.repository.IReportDao;
import com.founder.rhip.ncp.repository.IReportHealthDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ncpReportService")
public class ReportServiceImpl extends AbstractService implements IReportService{

    @Resource(name="ncpReportDao")
    IReportDao reportDao;

    @Resource(name="ncpClassifyReportDao")
    IReportClassifyDao classifyReportDao;

    @Resource(name="ncpHealthReportDao")
    IReportHealthDao healthReportDao;

    @Override
    public List<NcpManageReport> getNcpManageReports(Criteria criteria) {
        return reportDao.getNcpManageReports(criteria);
    }

    @Override
    public List<NcpClassifyReport> getNcpClassifyReports(Criteria criteria) {
        return classifyReportDao.getNcpClassifyReports(criteria);
    }

    @Override
    public List<NcpHealthReport> getNcpHealthReports(Criteria criteria) {
        return healthReportDao.getNcpHealthReports(criteria);
    }
}
