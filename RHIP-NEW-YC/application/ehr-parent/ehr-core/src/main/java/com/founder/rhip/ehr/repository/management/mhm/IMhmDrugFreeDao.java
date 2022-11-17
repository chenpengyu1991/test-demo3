package com.founder.rhip.ehr.repository.management.mhm;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrugFree;

/**
 * DAO interface of MhmManageType
 * 
 */
public interface IMhmDrugFreeDao extends IDao<MhmDrugFree,Long> {

    public MhmDrugFree findMhmDrugFree(String eventId);
}