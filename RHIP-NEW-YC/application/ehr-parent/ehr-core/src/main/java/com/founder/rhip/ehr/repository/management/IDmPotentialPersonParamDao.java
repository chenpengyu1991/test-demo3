package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.DmPotentialPersonParam;

public interface IDmPotentialPersonParamDao extends IDao<DmPotentialPersonParam,Long> {
      public boolean truncateTable();
}
