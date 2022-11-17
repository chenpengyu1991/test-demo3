package com.founder.rhip.ehr.repository.fds;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.basic.FamilyInfo;

/**
 * DAO interface of Doctor
 * 
 */
public interface IFdsDao extends IDao<FamilyInfo,Long> {

    int updateOrganCode(String tableName, String columnName, Parameters parameters, Criteria criteria);

    int updateInputOrgan(Parameters parameters, Criteria criteria);

    int updateGbOrgan(Parameters parameters, Criteria criteria);

    int updateGbCode(Parameters parameters, Criteria criteria);

    int updateTownShip(String tableName, Parameters parameters, String[] oldTownCode);

    int updateTownShipByStreet(String tableName, Parameters parameters, String[] newAddVillageCodes);

    void updatePaAddress(String tableName, String paStreet, String townName, String villageName);

}