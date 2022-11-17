package com.founder.rhip.ehr.repository.management.mhm;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmManageType;

/**
 * DAO interface of MhmManageType
 * 
 */
public interface IMhmManageTypeDao extends IDao<MhmManageType,Long> {

    public MhmManageType findMhmManageType(String eventId);
}