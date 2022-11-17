package com.founder.rhip.ehr.repository.basic;


import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.basic.PersonInfoRh;
import com.founder.rhip.ehr.entity.basic.TransferOperationLog;


public interface IPersonInfoRhDao extends IDao<PersonInfoRh,Long>{
	
	public PageList<PersonInfoRh> getTransferPersonInfo(Page page,TransferOperationLog transferLog);
	
	public PageList<PersonInfoRh> getVillageTransferPersonInfo(Page page,TransferOperationLog transferLog);
	

}
