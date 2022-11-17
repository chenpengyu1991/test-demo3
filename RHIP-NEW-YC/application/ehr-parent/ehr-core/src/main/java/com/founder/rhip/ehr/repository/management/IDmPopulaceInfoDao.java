package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.DmPopulaceInfo;

public interface IDmPopulaceInfoDao extends IDao<DmPopulaceInfo,Long> {

	DmPopulaceInfo getTotalCount(Criteria criteria);

}
