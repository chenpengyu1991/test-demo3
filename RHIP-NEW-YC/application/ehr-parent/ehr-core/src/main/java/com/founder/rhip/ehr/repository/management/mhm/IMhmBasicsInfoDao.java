package com.founder.rhip.ehr.repository.management.mhm;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmBasicsInfo;

/**
 * DAO interface of MhmBasicsInfo
 * 
 */
public interface IMhmBasicsInfoDao extends IDao<MhmBasicsInfo,Long> {

    public void updatePaAddress(String paTownShip, String oldTown, String newTown);

    public void updatePaAddress2(String paStreet, String townName, String villageName);

    public void updateHrAddress(String hrTownShip, String oldTown, String newTown);

}