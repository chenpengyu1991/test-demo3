package com.founder.rhip.ehr.repository.nc;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.nc.NcBloodDonation;

/**
 * DAO interface of NcBloodDonation
 * 
 */
public interface INcBloodDonationDao extends IDao<NcBloodDonation,Integer> {

    public int getBloodDonation5(Criteria ca);

}