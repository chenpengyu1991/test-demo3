package com.founder.rhip.ehr.repository.statistics;

import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.basic.PhysicalExamRecordRh;
import com.founder.rhip.ehr.entity.basic.TransferOperationLog;

public interface IPhysicalExamRecordRhDao extends IDao<PhysicalExamRecordRh,Long>{
	
	public PageList<PhysicalExamRecordRh> getphysicalexamrecordInfo(Page page, TransferOperationLog transferLog);

}
