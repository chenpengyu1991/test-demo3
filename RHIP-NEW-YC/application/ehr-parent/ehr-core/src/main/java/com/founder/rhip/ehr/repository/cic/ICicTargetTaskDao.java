package com.founder.rhip.ehr.repository.cic;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.cic.CicTarget;

import java.util.Date;

/**
 * @author liuk
 * @since 2014/5/15 14:13
 */
public interface ICicTargetTaskDao extends IDao<CicTarget,Long> {
    void syncDi(Date start);

    void syncAborh(Date start);

    void syncIrritability(Date start);
}
