package com.founder.rhip.ehr.repository.management.mhm;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmEconomy;

/**
 * DAO interface of MhmManageType
 * 
 */
public interface IMhmEconomyDao extends IDao<MhmEconomy,Long> {

    public MhmEconomy findMhmEconomy(String eventId);

}