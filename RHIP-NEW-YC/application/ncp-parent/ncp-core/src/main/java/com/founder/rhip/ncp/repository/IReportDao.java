package com.founder.rhip.ncp.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ncp.dto.NcpManageReport;

import java.util.List;

public interface IReportDao extends IDao<NcpManageReport, String> {

    public List<NcpManageReport> getNcpManageReports(Criteria criteria);
}
