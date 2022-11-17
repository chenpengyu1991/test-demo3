package com.founder.rhip.ehr.repository.hsa;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.hsa.PenaltyInfo;

/**
 * The interface of PenaltyInfo dao.
 * @author liuk
 */
public interface IPenaltyInfoDao extends IDao<PenaltyInfo, Long> {
     void importOnUpdate(PenaltyInfo info) ;
}
