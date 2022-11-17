package com.founder.rhip.ehr.repository.management;


import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.basic.TransferOperationLog;
import com.founder.rhip.ehr.entity.management.DmReportInfoRh;

public interface IDmReportInfoRhDao  extends IDao<DmReportInfoRh,Long> {
	public PageList<DmReportInfoRh> getTransferReportInfo(Page page,TransferOperationLog transferLog);
}
