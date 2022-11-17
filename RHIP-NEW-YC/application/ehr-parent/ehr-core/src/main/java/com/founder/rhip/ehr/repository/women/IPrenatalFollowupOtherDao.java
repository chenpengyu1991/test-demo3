package com.founder.rhip.ehr.repository.women;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.women.PrenatalFollowupOther;

/**
 * DAO interface of PrenatalFollowup
 */
public interface IPrenatalFollowupOtherDao extends IDao<PrenatalFollowupOther, Long> {

    public void updateOrganByVillage(String inputSuperOrganCode, String orgCode, String[] newAddVillageCodes);
}