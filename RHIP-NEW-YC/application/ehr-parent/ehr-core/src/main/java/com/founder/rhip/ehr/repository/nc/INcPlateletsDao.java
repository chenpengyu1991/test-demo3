package com.founder.rhip.ehr.repository.nc;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.nc.NcPlatelets;

/**
 * DAO interface of NcPlatelets
 * 
 */
public interface INcPlateletsDao extends IDao<NcPlatelets,Integer> {

    public int getPlatelets5(Criteria ca);

}