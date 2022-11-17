package com.founder.rhip.ehr.repository.hsa;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.hsa.BusinessInfo;
import com.founder.rhip.ehr.entity.hsa.LocationInfo;

/**
 * @author liuk
 * 
 */
public interface IBusinessInfoDao extends IDao<BusinessInfo, Long> {

	void importOnUpdate(LocationInfo locationInfo);

	void importOnAdd(LocationInfo locationInfo);

}